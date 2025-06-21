package androidx.constraintlayout.solver;

/* loaded from: classes.dex */
public class SolverVariable {
    private static final boolean INTERNAL_DEBUG = false;
    static final int MAX_STRENGTH = 9;
    public static final int STRENGTH_BARRIER = 6;
    public static final int STRENGTH_CENTERING = 7;
    public static final int STRENGTH_EQUALITY = 5;
    public static final int STRENGTH_FIXED = 8;
    public static final int STRENGTH_HIGH = 3;
    public static final int STRENGTH_HIGHEST = 4;
    public static final int STRENGTH_LOW = 1;
    public static final int STRENGTH_MEDIUM = 2;
    public static final int STRENGTH_NONE = 0;
    private static final boolean VAR_USE_HASH = false;
    private static int uniqueConstantId = 1;
    private static int uniqueErrorId = 1;
    private static int uniqueId = 1;
    private static int uniqueSlackId = 1;
    private static int uniqueUnrestrictedId = 1;
    public float computedValue;
    int definitionId;
    float[] goalStrengthVector;
    public int id;
    public boolean inGoal;
    java.util.HashSet<androidx.constraintlayout.solver.ArrayRow> inRows;
    public boolean isFinalValue;
    boolean isSynonym;
    androidx.constraintlayout.solver.ArrayRow[] mClientEquations;
    int mClientEquationsCount;
    private java.lang.String mName;
    androidx.constraintlayout.solver.SolverVariable.Type mType;
    public int strength;
    float[] strengthVector;
    int synonym;
    float synonymDelta;
    public int usageInRowCount;

    /* renamed from: androidx.constraintlayout.solver.SolverVariable$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$androidx$constraintlayout$solver$SolverVariable$Type;

        static {
            int[] iArr = new int[androidx.constraintlayout.solver.SolverVariable.Type.values().length];
            $SwitchMap$androidx$constraintlayout$solver$SolverVariable$Type = iArr;
            try {
                iArr[androidx.constraintlayout.solver.SolverVariable.Type.UNRESTRICTED.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$solver$SolverVariable$Type[androidx.constraintlayout.solver.SolverVariable.Type.CONSTANT.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$solver$SolverVariable$Type[androidx.constraintlayout.solver.SolverVariable.Type.SLACK.ordinal()] = 3;
            } catch (java.lang.NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$solver$SolverVariable$Type[androidx.constraintlayout.solver.SolverVariable.Type.ERROR.ordinal()] = 4;
            } catch (java.lang.NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$solver$SolverVariable$Type[androidx.constraintlayout.solver.SolverVariable.Type.UNKNOWN.ordinal()] = 5;
            } catch (java.lang.NoSuchFieldError unused5) {
            }
        }
    }

    public enum Type {
        UNRESTRICTED,
        CONSTANT,
        SLACK,
        ERROR,
        UNKNOWN
    }

    public SolverVariable(androidx.constraintlayout.solver.SolverVariable.Type type, java.lang.String str) {
        this.id = -1;
        this.definitionId = -1;
        this.strength = 0;
        this.isFinalValue = false;
        this.strengthVector = new float[9];
        this.goalStrengthVector = new float[9];
        this.mClientEquations = new androidx.constraintlayout.solver.ArrayRow[16];
        this.mClientEquationsCount = 0;
        this.usageInRowCount = 0;
        this.isSynonym = false;
        this.synonym = -1;
        this.synonymDelta = 0.0f;
        this.inRows = null;
        this.mType = type;
    }

    public SolverVariable(java.lang.String str, androidx.constraintlayout.solver.SolverVariable.Type type) {
        this.id = -1;
        this.definitionId = -1;
        this.strength = 0;
        this.isFinalValue = false;
        this.strengthVector = new float[9];
        this.goalStrengthVector = new float[9];
        this.mClientEquations = new androidx.constraintlayout.solver.ArrayRow[16];
        this.mClientEquationsCount = 0;
        this.usageInRowCount = 0;
        this.isSynonym = false;
        this.synonym = -1;
        this.synonymDelta = 0.0f;
        this.inRows = null;
        this.mName = str;
        this.mType = type;
    }

    private static java.lang.String getUniqueName(androidx.constraintlayout.solver.SolverVariable.Type type, java.lang.String str) {
        if (str != null) {
            return str + uniqueErrorId;
        }
        int i = androidx.constraintlayout.solver.SolverVariable.AnonymousClass1.$SwitchMap$androidx$constraintlayout$solver$SolverVariable$Type[type.ordinal()];
        if (i == 1) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("U");
            int i2 = uniqueUnrestrictedId + 1;
            uniqueUnrestrictedId = i2;
            sb.append(i2);
            return sb.toString();
        }
        if (i == 2) {
            java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
            sb2.append("C");
            int i3 = uniqueConstantId + 1;
            uniqueConstantId = i3;
            sb2.append(i3);
            return sb2.toString();
        }
        if (i == 3) {
            java.lang.StringBuilder sb3 = new java.lang.StringBuilder();
            sb3.append(androidx.exifinterface.media.ExifInterface.LATITUDE_SOUTH);
            int i4 = uniqueSlackId + 1;
            uniqueSlackId = i4;
            sb3.append(i4);
            return sb3.toString();
        }
        if (i == 4) {
            java.lang.StringBuilder sb4 = new java.lang.StringBuilder();
            sb4.append("e");
            int i5 = uniqueErrorId + 1;
            uniqueErrorId = i5;
            sb4.append(i5);
            return sb4.toString();
        }
        if (i != 5) {
            throw new java.lang.AssertionError(type.name());
        }
        java.lang.StringBuilder sb5 = new java.lang.StringBuilder();
        sb5.append(androidx.exifinterface.media.ExifInterface.GPS_MEASUREMENT_INTERRUPTED);
        int i6 = uniqueId + 1;
        uniqueId = i6;
        sb5.append(i6);
        return sb5.toString();
    }

    public static void increaseErrorId() {
        uniqueErrorId++;
    }

    public final void addToRow(androidx.constraintlayout.solver.ArrayRow arrayRow) {
        int i = 0;
        while (true) {
            int i2 = this.mClientEquationsCount;
            if (i >= i2) {
                androidx.constraintlayout.solver.ArrayRow[] arrayRowArr = this.mClientEquations;
                if (i2 >= arrayRowArr.length) {
                    this.mClientEquations = (androidx.constraintlayout.solver.ArrayRow[]) java.util.Arrays.copyOf(arrayRowArr, arrayRowArr.length * 2);
                }
                androidx.constraintlayout.solver.ArrayRow[] arrayRowArr2 = this.mClientEquations;
                int i3 = this.mClientEquationsCount;
                arrayRowArr2[i3] = arrayRow;
                this.mClientEquationsCount = i3 + 1;
                return;
            }
            if (this.mClientEquations[i] == arrayRow) {
                return;
            } else {
                i++;
            }
        }
    }

    public void clearStrengths() {
        for (int i = 0; i < 9; i++) {
            this.strengthVector[i] = 0.0f;
        }
    }

    public java.lang.String getName() {
        return this.mName;
    }

    public final void removeFromRow(androidx.constraintlayout.solver.ArrayRow arrayRow) {
        int i = this.mClientEquationsCount;
        int i2 = 0;
        while (i2 < i) {
            if (this.mClientEquations[i2] == arrayRow) {
                while (i2 < i - 1) {
                    androidx.constraintlayout.solver.ArrayRow[] arrayRowArr = this.mClientEquations;
                    int i3 = i2 + 1;
                    arrayRowArr[i2] = arrayRowArr[i3];
                    i2 = i3;
                }
                this.mClientEquationsCount--;
                return;
            }
            i2++;
        }
    }

    public void reset() {
        this.mName = null;
        this.mType = androidx.constraintlayout.solver.SolverVariable.Type.UNKNOWN;
        this.strength = 0;
        this.id = -1;
        this.definitionId = -1;
        this.computedValue = 0.0f;
        this.isFinalValue = false;
        this.isSynonym = false;
        this.synonym = -1;
        this.synonymDelta = 0.0f;
        int i = this.mClientEquationsCount;
        for (int i2 = 0; i2 < i; i2++) {
            this.mClientEquations[i2] = null;
        }
        this.mClientEquationsCount = 0;
        this.usageInRowCount = 0;
        this.inGoal = false;
        java.util.Arrays.fill(this.goalStrengthVector, 0.0f);
    }

    public void setFinalValue(androidx.constraintlayout.solver.LinearSystem linearSystem, float f) {
        this.computedValue = f;
        this.isFinalValue = true;
        this.isSynonym = false;
        this.synonym = -1;
        this.synonymDelta = 0.0f;
        int i = this.mClientEquationsCount;
        this.definitionId = -1;
        for (int i2 = 0; i2 < i; i2++) {
            this.mClientEquations[i2].updateFromFinalVariable(linearSystem, this, false);
        }
        this.mClientEquationsCount = 0;
    }

    public void setName(java.lang.String str) {
        this.mName = str;
    }

    public void setSynonym(androidx.constraintlayout.solver.LinearSystem linearSystem, androidx.constraintlayout.solver.SolverVariable solverVariable, float f) {
        this.isSynonym = true;
        this.synonym = solverVariable.id;
        this.synonymDelta = f;
        int i = this.mClientEquationsCount;
        this.definitionId = -1;
        for (int i2 = 0; i2 < i; i2++) {
            this.mClientEquations[i2].updateFromSynonymVariable(linearSystem, this, false);
        }
        this.mClientEquationsCount = 0;
        linearSystem.displayReadableRows();
    }

    public void setType(androidx.constraintlayout.solver.SolverVariable.Type type, java.lang.String str) {
        this.mType = type;
    }

    public java.lang.String strengthsToString() {
        java.lang.String str = this + "[";
        boolean z = false;
        boolean z2 = true;
        for (int i = 0; i < this.strengthVector.length; i++) {
            java.lang.String str2 = str + this.strengthVector[i];
            float[] fArr = this.strengthVector;
            float f = fArr[i];
            if (f > 0.0f) {
                z = false;
            } else if (f < 0.0f) {
                z = true;
            }
            if (f != 0.0f) {
                z2 = false;
            }
            str = i < fArr.length - 1 ? str2 + ", " : str2 + "] ";
        }
        if (z) {
            str = str + " (-)";
        }
        if (!z2) {
            return str;
        }
        return str + " (*)";
    }

    public java.lang.String toString() {
        if (this.mName != null) {
            return "" + this.mName;
        }
        return "" + this.id;
    }

    public final void updateReferencesWithNewDefinition(androidx.constraintlayout.solver.LinearSystem linearSystem, androidx.constraintlayout.solver.ArrayRow arrayRow) {
        int i = this.mClientEquationsCount;
        for (int i2 = 0; i2 < i; i2++) {
            this.mClientEquations[i2].updateFromRow(linearSystem, arrayRow, false);
        }
        this.mClientEquationsCount = 0;
    }
}
