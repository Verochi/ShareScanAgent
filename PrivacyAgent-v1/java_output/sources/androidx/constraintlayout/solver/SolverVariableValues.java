package androidx.constraintlayout.solver;

/* loaded from: classes.dex */
public class SolverVariableValues implements androidx.constraintlayout.solver.ArrayRow.ArrayRowVariables {
    private static final boolean DEBUG = false;
    private static final boolean HASH = true;
    private static float epsilon = 0.001f;
    protected final androidx.constraintlayout.solver.Cache mCache;
    private final androidx.constraintlayout.solver.ArrayRow mRow;
    private final int NONE = -1;
    private int SIZE = 16;
    private int HASH_SIZE = 16;
    int[] keys = new int[16];
    int[] nextKeys = new int[16];
    int[] variables = new int[16];
    float[] values = new float[16];
    int[] previous = new int[16];
    int[] next = new int[16];
    int mCount = 0;
    int head = -1;

    public SolverVariableValues(androidx.constraintlayout.solver.ArrayRow arrayRow, androidx.constraintlayout.solver.Cache cache) {
        this.mRow = arrayRow;
        this.mCache = cache;
        clear();
    }

    private void addToHashMap(androidx.constraintlayout.solver.SolverVariable solverVariable, int i) {
        int[] iArr;
        int i2 = solverVariable.id % this.HASH_SIZE;
        int[] iArr2 = this.keys;
        int i3 = iArr2[i2];
        if (i3 == -1) {
            iArr2[i2] = i;
        } else {
            while (true) {
                iArr = this.nextKeys;
                int i4 = iArr[i3];
                if (i4 == -1) {
                    break;
                } else {
                    i3 = i4;
                }
            }
            iArr[i3] = i;
        }
        this.nextKeys[i] = -1;
    }

    private void addVariable(int i, androidx.constraintlayout.solver.SolverVariable solverVariable, float f) {
        this.variables[i] = solverVariable.id;
        this.values[i] = f;
        this.previous[i] = -1;
        this.next[i] = -1;
        solverVariable.addToRow(this.mRow);
        solverVariable.usageInRowCount++;
        this.mCount++;
    }

    private void displayHash() {
        for (int i = 0; i < this.HASH_SIZE; i++) {
            if (this.keys[i] != -1) {
                java.lang.String str = hashCode() + " hash [" + i + "] => ";
                int i2 = this.keys[i];
                boolean z = false;
                while (!z) {
                    str = str + " " + this.variables[i2];
                    int i3 = this.nextKeys[i2];
                    if (i3 != -1) {
                        i2 = i3;
                    } else {
                        z = true;
                    }
                }
                java.lang.System.out.println(str);
            }
        }
    }

    private int findEmptySlot() {
        for (int i = 0; i < this.SIZE; i++) {
            if (this.variables[i] == -1) {
                return i;
            }
        }
        return -1;
    }

    private void increaseSize() {
        int i = this.SIZE * 2;
        this.variables = java.util.Arrays.copyOf(this.variables, i);
        this.values = java.util.Arrays.copyOf(this.values, i);
        this.previous = java.util.Arrays.copyOf(this.previous, i);
        this.next = java.util.Arrays.copyOf(this.next, i);
        this.nextKeys = java.util.Arrays.copyOf(this.nextKeys, i);
        for (int i2 = this.SIZE; i2 < i; i2++) {
            this.variables[i2] = -1;
            this.nextKeys[i2] = -1;
        }
        this.SIZE = i;
    }

    private void insertVariable(int i, androidx.constraintlayout.solver.SolverVariable solverVariable, float f) {
        int findEmptySlot = findEmptySlot();
        addVariable(findEmptySlot, solverVariable, f);
        if (i != -1) {
            this.previous[findEmptySlot] = i;
            int[] iArr = this.next;
            iArr[findEmptySlot] = iArr[i];
            iArr[i] = findEmptySlot;
        } else {
            this.previous[findEmptySlot] = -1;
            if (this.mCount > 0) {
                this.next[findEmptySlot] = this.head;
                this.head = findEmptySlot;
            } else {
                this.next[findEmptySlot] = -1;
            }
        }
        int i2 = this.next[findEmptySlot];
        if (i2 != -1) {
            this.previous[i2] = findEmptySlot;
        }
        addToHashMap(solverVariable, findEmptySlot);
    }

    private void removeFromHashMap(androidx.constraintlayout.solver.SolverVariable solverVariable) {
        int[] iArr;
        int i;
        int i2 = solverVariable.id;
        int i3 = i2 % this.HASH_SIZE;
        int[] iArr2 = this.keys;
        int i4 = iArr2[i3];
        if (i4 == -1) {
            return;
        }
        if (this.variables[i4] == i2) {
            int[] iArr3 = this.nextKeys;
            iArr2[i3] = iArr3[i4];
            iArr3[i4] = -1;
            return;
        }
        while (true) {
            iArr = this.nextKeys;
            i = iArr[i4];
            if (i == -1 || this.variables[i] == i2) {
                break;
            } else {
                i4 = i;
            }
        }
        if (i == -1 || this.variables[i] != i2) {
            return;
        }
        iArr[i4] = iArr[i];
        iArr[i] = -1;
    }

    @Override // androidx.constraintlayout.solver.ArrayRow.ArrayRowVariables
    public void add(androidx.constraintlayout.solver.SolverVariable solverVariable, float f, boolean z) {
        float f2 = epsilon;
        if (f <= (-f2) || f >= f2) {
            int indexOf = indexOf(solverVariable);
            if (indexOf == -1) {
                put(solverVariable, f);
                return;
            }
            float[] fArr = this.values;
            float f3 = fArr[indexOf] + f;
            fArr[indexOf] = f3;
            float f4 = epsilon;
            if (f3 <= (-f4) || f3 >= f4) {
                return;
            }
            fArr[indexOf] = 0.0f;
            remove(solverVariable, z);
        }
    }

    @Override // androidx.constraintlayout.solver.ArrayRow.ArrayRowVariables
    public void clear() {
        int i = this.mCount;
        for (int i2 = 0; i2 < i; i2++) {
            androidx.constraintlayout.solver.SolverVariable variable = getVariable(i2);
            if (variable != null) {
                variable.removeFromRow(this.mRow);
            }
        }
        for (int i3 = 0; i3 < this.SIZE; i3++) {
            this.variables[i3] = -1;
            this.nextKeys[i3] = -1;
        }
        for (int i4 = 0; i4 < this.HASH_SIZE; i4++) {
            this.keys[i4] = -1;
        }
        this.mCount = 0;
        this.head = -1;
    }

    @Override // androidx.constraintlayout.solver.ArrayRow.ArrayRowVariables
    public boolean contains(androidx.constraintlayout.solver.SolverVariable solverVariable) {
        return indexOf(solverVariable) != -1;
    }

    @Override // androidx.constraintlayout.solver.ArrayRow.ArrayRowVariables
    public void display() {
        int i = this.mCount;
        java.lang.System.out.print("{ ");
        for (int i2 = 0; i2 < i; i2++) {
            androidx.constraintlayout.solver.SolverVariable variable = getVariable(i2);
            if (variable != null) {
                java.lang.System.out.print(variable + " = " + getVariableValue(i2) + " ");
            }
        }
        java.lang.System.out.println(" }");
    }

    @Override // androidx.constraintlayout.solver.ArrayRow.ArrayRowVariables
    public void divideByAmount(float f) {
        int i = this.mCount;
        int i2 = this.head;
        for (int i3 = 0; i3 < i; i3++) {
            float[] fArr = this.values;
            fArr[i2] = fArr[i2] / f;
            i2 = this.next[i2];
            if (i2 == -1) {
                return;
            }
        }
    }

    @Override // androidx.constraintlayout.solver.ArrayRow.ArrayRowVariables
    public float get(androidx.constraintlayout.solver.SolverVariable solverVariable) {
        int indexOf = indexOf(solverVariable);
        if (indexOf != -1) {
            return this.values[indexOf];
        }
        return 0.0f;
    }

    @Override // androidx.constraintlayout.solver.ArrayRow.ArrayRowVariables
    public int getCurrentSize() {
        return this.mCount;
    }

    @Override // androidx.constraintlayout.solver.ArrayRow.ArrayRowVariables
    public androidx.constraintlayout.solver.SolverVariable getVariable(int i) {
        int i2 = this.mCount;
        if (i2 == 0) {
            return null;
        }
        int i3 = this.head;
        for (int i4 = 0; i4 < i2; i4++) {
            if (i4 == i && i3 != -1) {
                return this.mCache.mIndexedVariables[this.variables[i3]];
            }
            i3 = this.next[i3];
            if (i3 == -1) {
                break;
            }
        }
        return null;
    }

    @Override // androidx.constraintlayout.solver.ArrayRow.ArrayRowVariables
    public float getVariableValue(int i) {
        int i2 = this.mCount;
        int i3 = this.head;
        for (int i4 = 0; i4 < i2; i4++) {
            if (i4 == i) {
                return this.values[i3];
            }
            i3 = this.next[i3];
            if (i3 == -1) {
                return 0.0f;
            }
        }
        return 0.0f;
    }

    @Override // androidx.constraintlayout.solver.ArrayRow.ArrayRowVariables
    public int indexOf(androidx.constraintlayout.solver.SolverVariable solverVariable) {
        if (this.mCount != 0 && solverVariable != null) {
            int i = solverVariable.id;
            int i2 = this.keys[i % this.HASH_SIZE];
            if (i2 == -1) {
                return -1;
            }
            if (this.variables[i2] == i) {
                return i2;
            }
            do {
                i2 = this.nextKeys[i2];
                if (i2 == -1) {
                    break;
                }
            } while (this.variables[i2] != i);
            if (i2 != -1 && this.variables[i2] == i) {
                return i2;
            }
        }
        return -1;
    }

    @Override // androidx.constraintlayout.solver.ArrayRow.ArrayRowVariables
    public void invert() {
        int i = this.mCount;
        int i2 = this.head;
        for (int i3 = 0; i3 < i; i3++) {
            float[] fArr = this.values;
            fArr[i2] = fArr[i2] * (-1.0f);
            i2 = this.next[i2];
            if (i2 == -1) {
                return;
            }
        }
    }

    @Override // androidx.constraintlayout.solver.ArrayRow.ArrayRowVariables
    public void put(androidx.constraintlayout.solver.SolverVariable solverVariable, float f) {
        float f2 = epsilon;
        if (f > (-f2) && f < f2) {
            remove(solverVariable, true);
            return;
        }
        if (this.mCount == 0) {
            addVariable(0, solverVariable, f);
            addToHashMap(solverVariable, 0);
            this.head = 0;
            return;
        }
        int indexOf = indexOf(solverVariable);
        if (indexOf != -1) {
            this.values[indexOf] = f;
            return;
        }
        if (this.mCount + 1 >= this.SIZE) {
            increaseSize();
        }
        int i = this.mCount;
        int i2 = this.head;
        int i3 = -1;
        for (int i4 = 0; i4 < i; i4++) {
            int i5 = this.variables[i2];
            int i6 = solverVariable.id;
            if (i5 == i6) {
                this.values[i2] = f;
                return;
            }
            if (i5 < i6) {
                i3 = i2;
            }
            i2 = this.next[i2];
            if (i2 == -1) {
                break;
            }
        }
        insertVariable(i3, solverVariable, f);
    }

    @Override // androidx.constraintlayout.solver.ArrayRow.ArrayRowVariables
    public float remove(androidx.constraintlayout.solver.SolverVariable solverVariable, boolean z) {
        int indexOf = indexOf(solverVariable);
        if (indexOf == -1) {
            return 0.0f;
        }
        removeFromHashMap(solverVariable);
        float f = this.values[indexOf];
        if (this.head == indexOf) {
            this.head = this.next[indexOf];
        }
        this.variables[indexOf] = -1;
        int[] iArr = this.previous;
        int i = iArr[indexOf];
        if (i != -1) {
            int[] iArr2 = this.next;
            iArr2[i] = iArr2[indexOf];
        }
        int i2 = this.next[indexOf];
        if (i2 != -1) {
            iArr[i2] = iArr[indexOf];
        }
        this.mCount--;
        solverVariable.usageInRowCount--;
        if (z) {
            solverVariable.removeFromRow(this.mRow);
        }
        return f;
    }

    @Override // androidx.constraintlayout.solver.ArrayRow.ArrayRowVariables
    public int sizeInBytes() {
        return 0;
    }

    public java.lang.String toString() {
        java.lang.String str = hashCode() + " { ";
        int i = this.mCount;
        for (int i2 = 0; i2 < i; i2++) {
            androidx.constraintlayout.solver.SolverVariable variable = getVariable(i2);
            if (variable != null) {
                java.lang.String str2 = str + variable + " = " + getVariableValue(i2) + " ";
                int indexOf = indexOf(variable);
                java.lang.String str3 = str2 + "[p: ";
                java.lang.String str4 = (this.previous[indexOf] != -1 ? str3 + this.mCache.mIndexedVariables[this.variables[this.previous[indexOf]]] : str3 + "none") + ", n: ";
                str = (this.next[indexOf] != -1 ? str4 + this.mCache.mIndexedVariables[this.variables[this.next[indexOf]]] : str4 + "none") + "]";
            }
        }
        return str + " }";
    }

    @Override // androidx.constraintlayout.solver.ArrayRow.ArrayRowVariables
    public float use(androidx.constraintlayout.solver.ArrayRow arrayRow, boolean z) {
        float f = get(arrayRow.variable);
        remove(arrayRow.variable, z);
        androidx.constraintlayout.solver.SolverVariableValues solverVariableValues = (androidx.constraintlayout.solver.SolverVariableValues) arrayRow.variables;
        int currentSize = solverVariableValues.getCurrentSize();
        int i = 0;
        int i2 = 0;
        while (i < currentSize) {
            int i3 = solverVariableValues.variables[i2];
            if (i3 != -1) {
                add(this.mCache.mIndexedVariables[i3], solverVariableValues.values[i2] * f, z);
                i++;
            }
            i2++;
        }
        return f;
    }
}
