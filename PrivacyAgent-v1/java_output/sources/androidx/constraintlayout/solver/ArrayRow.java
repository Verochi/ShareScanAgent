package androidx.constraintlayout.solver;

/* loaded from: classes.dex */
public class ArrayRow implements androidx.constraintlayout.solver.LinearSystem.Row {
    private static final boolean DEBUG = false;
    private static final boolean FULL_NEW_CHECK = false;
    public androidx.constraintlayout.solver.ArrayRow.ArrayRowVariables variables;
    androidx.constraintlayout.solver.SolverVariable variable = null;
    float constantValue = 0.0f;
    boolean used = false;
    java.util.ArrayList<androidx.constraintlayout.solver.SolverVariable> variablesToUpdate = new java.util.ArrayList<>();
    boolean isSimpleDefinition = false;

    public interface ArrayRowVariables {
        void add(androidx.constraintlayout.solver.SolverVariable solverVariable, float f, boolean z);

        void clear();

        boolean contains(androidx.constraintlayout.solver.SolverVariable solverVariable);

        void display();

        void divideByAmount(float f);

        float get(androidx.constraintlayout.solver.SolverVariable solverVariable);

        int getCurrentSize();

        androidx.constraintlayout.solver.SolverVariable getVariable(int i);

        float getVariableValue(int i);

        int indexOf(androidx.constraintlayout.solver.SolverVariable solverVariable);

        void invert();

        void put(androidx.constraintlayout.solver.SolverVariable solverVariable, float f);

        float remove(androidx.constraintlayout.solver.SolverVariable solverVariable, boolean z);

        int sizeInBytes();

        float use(androidx.constraintlayout.solver.ArrayRow arrayRow, boolean z);
    }

    public ArrayRow() {
    }

    public ArrayRow(androidx.constraintlayout.solver.Cache cache) {
        this.variables = new androidx.constraintlayout.solver.ArrayLinkedVariables(this, cache);
    }

    private boolean isNew(androidx.constraintlayout.solver.SolverVariable solverVariable, androidx.constraintlayout.solver.LinearSystem linearSystem) {
        return solverVariable.usageInRowCount <= 1;
    }

    private androidx.constraintlayout.solver.SolverVariable pickPivotInVariables(boolean[] zArr, androidx.constraintlayout.solver.SolverVariable solverVariable) {
        androidx.constraintlayout.solver.SolverVariable.Type type;
        int currentSize = this.variables.getCurrentSize();
        androidx.constraintlayout.solver.SolverVariable solverVariable2 = null;
        float f = 0.0f;
        for (int i = 0; i < currentSize; i++) {
            float variableValue = this.variables.getVariableValue(i);
            if (variableValue < 0.0f) {
                androidx.constraintlayout.solver.SolverVariable variable = this.variables.getVariable(i);
                if ((zArr == null || !zArr[variable.id]) && variable != solverVariable && (((type = variable.mType) == androidx.constraintlayout.solver.SolverVariable.Type.SLACK || type == androidx.constraintlayout.solver.SolverVariable.Type.ERROR) && variableValue < f)) {
                    f = variableValue;
                    solverVariable2 = variable;
                }
            }
        }
        return solverVariable2;
    }

    public androidx.constraintlayout.solver.ArrayRow addError(androidx.constraintlayout.solver.LinearSystem linearSystem, int i) {
        this.variables.put(linearSystem.createErrorVariable(i, "ep"), 1.0f);
        this.variables.put(linearSystem.createErrorVariable(i, "em"), -1.0f);
        return this;
    }

    @Override // androidx.constraintlayout.solver.LinearSystem.Row
    public void addError(androidx.constraintlayout.solver.SolverVariable solverVariable) {
        int i = solverVariable.strength;
        float f = 1.0f;
        if (i != 1) {
            if (i == 2) {
                f = 1000.0f;
            } else if (i == 3) {
                f = 1000000.0f;
            } else if (i == 4) {
                f = 1.0E9f;
            } else if (i == 5) {
                f = 1.0E12f;
            }
        }
        this.variables.put(solverVariable, f);
    }

    public androidx.constraintlayout.solver.ArrayRow addSingleError(androidx.constraintlayout.solver.SolverVariable solverVariable, int i) {
        this.variables.put(solverVariable, i);
        return this;
    }

    public boolean chooseSubject(androidx.constraintlayout.solver.LinearSystem linearSystem) {
        boolean z;
        androidx.constraintlayout.solver.SolverVariable chooseSubjectInVariables = chooseSubjectInVariables(linearSystem);
        if (chooseSubjectInVariables == null) {
            z = true;
        } else {
            pivot(chooseSubjectInVariables);
            z = false;
        }
        if (this.variables.getCurrentSize() == 0) {
            this.isSimpleDefinition = true;
        }
        return z;
    }

    public androidx.constraintlayout.solver.SolverVariable chooseSubjectInVariables(androidx.constraintlayout.solver.LinearSystem linearSystem) {
        boolean isNew;
        boolean isNew2;
        int currentSize = this.variables.getCurrentSize();
        androidx.constraintlayout.solver.SolverVariable solverVariable = null;
        androidx.constraintlayout.solver.SolverVariable solverVariable2 = null;
        boolean z = false;
        boolean z2 = false;
        float f = 0.0f;
        float f2 = 0.0f;
        for (int i = 0; i < currentSize; i++) {
            float variableValue = this.variables.getVariableValue(i);
            androidx.constraintlayout.solver.SolverVariable variable = this.variables.getVariable(i);
            if (variable.mType == androidx.constraintlayout.solver.SolverVariable.Type.UNRESTRICTED) {
                if (solverVariable == null) {
                    isNew2 = isNew(variable, linearSystem);
                } else if (f > variableValue) {
                    isNew2 = isNew(variable, linearSystem);
                } else if (!z && isNew(variable, linearSystem)) {
                    f = variableValue;
                    solverVariable = variable;
                    z = true;
                }
                z = isNew2;
                f = variableValue;
                solverVariable = variable;
            } else if (solverVariable == null && variableValue < 0.0f) {
                if (solverVariable2 == null) {
                    isNew = isNew(variable, linearSystem);
                } else if (f2 > variableValue) {
                    isNew = isNew(variable, linearSystem);
                } else if (!z2 && isNew(variable, linearSystem)) {
                    f2 = variableValue;
                    solverVariable2 = variable;
                    z2 = true;
                }
                z2 = isNew;
                f2 = variableValue;
                solverVariable2 = variable;
            }
        }
        return solverVariable != null ? solverVariable : solverVariable2;
    }

    @Override // androidx.constraintlayout.solver.LinearSystem.Row
    public void clear() {
        this.variables.clear();
        this.variable = null;
        this.constantValue = 0.0f;
    }

    public androidx.constraintlayout.solver.ArrayRow createRowCentering(androidx.constraintlayout.solver.SolverVariable solverVariable, androidx.constraintlayout.solver.SolverVariable solverVariable2, int i, float f, androidx.constraintlayout.solver.SolverVariable solverVariable3, androidx.constraintlayout.solver.SolverVariable solverVariable4, int i2) {
        if (solverVariable2 == solverVariable3) {
            this.variables.put(solverVariable, 1.0f);
            this.variables.put(solverVariable4, 1.0f);
            this.variables.put(solverVariable2, -2.0f);
            return this;
        }
        if (f == 0.5f) {
            this.variables.put(solverVariable, 1.0f);
            this.variables.put(solverVariable2, -1.0f);
            this.variables.put(solverVariable3, -1.0f);
            this.variables.put(solverVariable4, 1.0f);
            if (i > 0 || i2 > 0) {
                this.constantValue = (-i) + i2;
            }
        } else if (f <= 0.0f) {
            this.variables.put(solverVariable, -1.0f);
            this.variables.put(solverVariable2, 1.0f);
            this.constantValue = i;
        } else if (f >= 1.0f) {
            this.variables.put(solverVariable4, -1.0f);
            this.variables.put(solverVariable3, 1.0f);
            this.constantValue = -i2;
        } else {
            float f2 = 1.0f - f;
            this.variables.put(solverVariable, f2 * 1.0f);
            this.variables.put(solverVariable2, f2 * (-1.0f));
            this.variables.put(solverVariable3, (-1.0f) * f);
            this.variables.put(solverVariable4, 1.0f * f);
            if (i > 0 || i2 > 0) {
                this.constantValue = ((-i) * f2) + (i2 * f);
            }
        }
        return this;
    }

    public androidx.constraintlayout.solver.ArrayRow createRowDefinition(androidx.constraintlayout.solver.SolverVariable solverVariable, int i) {
        this.variable = solverVariable;
        float f = i;
        solverVariable.computedValue = f;
        this.constantValue = f;
        this.isSimpleDefinition = true;
        return this;
    }

    public androidx.constraintlayout.solver.ArrayRow createRowDimensionPercent(androidx.constraintlayout.solver.SolverVariable solverVariable, androidx.constraintlayout.solver.SolverVariable solverVariable2, float f) {
        this.variables.put(solverVariable, -1.0f);
        this.variables.put(solverVariable2, f);
        return this;
    }

    public androidx.constraintlayout.solver.ArrayRow createRowDimensionRatio(androidx.constraintlayout.solver.SolverVariable solverVariable, androidx.constraintlayout.solver.SolverVariable solverVariable2, androidx.constraintlayout.solver.SolverVariable solverVariable3, androidx.constraintlayout.solver.SolverVariable solverVariable4, float f) {
        this.variables.put(solverVariable, -1.0f);
        this.variables.put(solverVariable2, 1.0f);
        this.variables.put(solverVariable3, f);
        this.variables.put(solverVariable4, -f);
        return this;
    }

    public androidx.constraintlayout.solver.ArrayRow createRowEqualDimension(float f, float f2, float f3, androidx.constraintlayout.solver.SolverVariable solverVariable, int i, androidx.constraintlayout.solver.SolverVariable solverVariable2, int i2, androidx.constraintlayout.solver.SolverVariable solverVariable3, int i3, androidx.constraintlayout.solver.SolverVariable solverVariable4, int i4) {
        if (f2 == 0.0f || f == f3) {
            this.constantValue = ((-i) - i2) + i3 + i4;
            this.variables.put(solverVariable, 1.0f);
            this.variables.put(solverVariable2, -1.0f);
            this.variables.put(solverVariable4, 1.0f);
            this.variables.put(solverVariable3, -1.0f);
        } else {
            float f4 = (f / f2) / (f3 / f2);
            this.constantValue = ((-i) - i2) + (i3 * f4) + (i4 * f4);
            this.variables.put(solverVariable, 1.0f);
            this.variables.put(solverVariable2, -1.0f);
            this.variables.put(solverVariable4, f4);
            this.variables.put(solverVariable3, -f4);
        }
        return this;
    }

    public androidx.constraintlayout.solver.ArrayRow createRowEqualMatchDimensions(float f, float f2, float f3, androidx.constraintlayout.solver.SolverVariable solverVariable, androidx.constraintlayout.solver.SolverVariable solverVariable2, androidx.constraintlayout.solver.SolverVariable solverVariable3, androidx.constraintlayout.solver.SolverVariable solverVariable4) {
        this.constantValue = 0.0f;
        if (f2 == 0.0f || f == f3) {
            this.variables.put(solverVariable, 1.0f);
            this.variables.put(solverVariable2, -1.0f);
            this.variables.put(solverVariable4, 1.0f);
            this.variables.put(solverVariable3, -1.0f);
        } else if (f == 0.0f) {
            this.variables.put(solverVariable, 1.0f);
            this.variables.put(solverVariable2, -1.0f);
        } else if (f3 == 0.0f) {
            this.variables.put(solverVariable3, 1.0f);
            this.variables.put(solverVariable4, -1.0f);
        } else {
            float f4 = (f / f2) / (f3 / f2);
            this.variables.put(solverVariable, 1.0f);
            this.variables.put(solverVariable2, -1.0f);
            this.variables.put(solverVariable4, f4);
            this.variables.put(solverVariable3, -f4);
        }
        return this;
    }

    public androidx.constraintlayout.solver.ArrayRow createRowEquals(androidx.constraintlayout.solver.SolverVariable solverVariable, int i) {
        if (i < 0) {
            this.constantValue = i * (-1);
            this.variables.put(solverVariable, 1.0f);
        } else {
            this.constantValue = i;
            this.variables.put(solverVariable, -1.0f);
        }
        return this;
    }

    public androidx.constraintlayout.solver.ArrayRow createRowEquals(androidx.constraintlayout.solver.SolverVariable solverVariable, androidx.constraintlayout.solver.SolverVariable solverVariable2, int i) {
        boolean z = false;
        if (i != 0) {
            if (i < 0) {
                i *= -1;
                z = true;
            }
            this.constantValue = i;
        }
        if (z) {
            this.variables.put(solverVariable, 1.0f);
            this.variables.put(solverVariable2, -1.0f);
        } else {
            this.variables.put(solverVariable, -1.0f);
            this.variables.put(solverVariable2, 1.0f);
        }
        return this;
    }

    public androidx.constraintlayout.solver.ArrayRow createRowGreaterThan(androidx.constraintlayout.solver.SolverVariable solverVariable, int i, androidx.constraintlayout.solver.SolverVariable solverVariable2) {
        this.constantValue = i;
        this.variables.put(solverVariable, -1.0f);
        return this;
    }

    public androidx.constraintlayout.solver.ArrayRow createRowGreaterThan(androidx.constraintlayout.solver.SolverVariable solverVariable, androidx.constraintlayout.solver.SolverVariable solverVariable2, androidx.constraintlayout.solver.SolverVariable solverVariable3, int i) {
        boolean z = false;
        if (i != 0) {
            if (i < 0) {
                i *= -1;
                z = true;
            }
            this.constantValue = i;
        }
        if (z) {
            this.variables.put(solverVariable, 1.0f);
            this.variables.put(solverVariable2, -1.0f);
            this.variables.put(solverVariable3, -1.0f);
        } else {
            this.variables.put(solverVariable, -1.0f);
            this.variables.put(solverVariable2, 1.0f);
            this.variables.put(solverVariable3, 1.0f);
        }
        return this;
    }

    public androidx.constraintlayout.solver.ArrayRow createRowLowerThan(androidx.constraintlayout.solver.SolverVariable solverVariable, androidx.constraintlayout.solver.SolverVariable solverVariable2, androidx.constraintlayout.solver.SolverVariable solverVariable3, int i) {
        boolean z = false;
        if (i != 0) {
            if (i < 0) {
                i *= -1;
                z = true;
            }
            this.constantValue = i;
        }
        if (z) {
            this.variables.put(solverVariable, 1.0f);
            this.variables.put(solverVariable2, -1.0f);
            this.variables.put(solverVariable3, 1.0f);
        } else {
            this.variables.put(solverVariable, -1.0f);
            this.variables.put(solverVariable2, 1.0f);
            this.variables.put(solverVariable3, -1.0f);
        }
        return this;
    }

    public androidx.constraintlayout.solver.ArrayRow createRowWithAngle(androidx.constraintlayout.solver.SolverVariable solverVariable, androidx.constraintlayout.solver.SolverVariable solverVariable2, androidx.constraintlayout.solver.SolverVariable solverVariable3, androidx.constraintlayout.solver.SolverVariable solverVariable4, float f) {
        this.variables.put(solverVariable3, 0.5f);
        this.variables.put(solverVariable4, 0.5f);
        this.variables.put(solverVariable, -0.5f);
        this.variables.put(solverVariable2, -0.5f);
        this.constantValue = -f;
        return this;
    }

    public void ensurePositiveConstant() {
        float f = this.constantValue;
        if (f < 0.0f) {
            this.constantValue = f * (-1.0f);
            this.variables.invert();
        }
    }

    @Override // androidx.constraintlayout.solver.LinearSystem.Row
    public androidx.constraintlayout.solver.SolverVariable getKey() {
        return this.variable;
    }

    @Override // androidx.constraintlayout.solver.LinearSystem.Row
    public androidx.constraintlayout.solver.SolverVariable getPivotCandidate(androidx.constraintlayout.solver.LinearSystem linearSystem, boolean[] zArr) {
        return pickPivotInVariables(zArr, null);
    }

    public boolean hasKeyVariable() {
        androidx.constraintlayout.solver.SolverVariable solverVariable = this.variable;
        return solverVariable != null && (solverVariable.mType == androidx.constraintlayout.solver.SolverVariable.Type.UNRESTRICTED || this.constantValue >= 0.0f);
    }

    public boolean hasVariable(androidx.constraintlayout.solver.SolverVariable solverVariable) {
        return this.variables.contains(solverVariable);
    }

    @Override // androidx.constraintlayout.solver.LinearSystem.Row
    public void initFromRow(androidx.constraintlayout.solver.LinearSystem.Row row) {
        if (row instanceof androidx.constraintlayout.solver.ArrayRow) {
            androidx.constraintlayout.solver.ArrayRow arrayRow = (androidx.constraintlayout.solver.ArrayRow) row;
            this.variable = null;
            this.variables.clear();
            for (int i = 0; i < arrayRow.variables.getCurrentSize(); i++) {
                this.variables.add(arrayRow.variables.getVariable(i), arrayRow.variables.getVariableValue(i), true);
            }
        }
    }

    @Override // androidx.constraintlayout.solver.LinearSystem.Row
    public boolean isEmpty() {
        return this.variable == null && this.constantValue == 0.0f && this.variables.getCurrentSize() == 0;
    }

    public androidx.constraintlayout.solver.SolverVariable pickPivot(androidx.constraintlayout.solver.SolverVariable solverVariable) {
        return pickPivotInVariables(null, solverVariable);
    }

    public void pivot(androidx.constraintlayout.solver.SolverVariable solverVariable) {
        androidx.constraintlayout.solver.SolverVariable solverVariable2 = this.variable;
        if (solverVariable2 != null) {
            this.variables.put(solverVariable2, -1.0f);
            this.variable.definitionId = -1;
            this.variable = null;
        }
        float remove = this.variables.remove(solverVariable, true) * (-1.0f);
        this.variable = solverVariable;
        if (remove == 1.0f) {
            return;
        }
        this.constantValue /= remove;
        this.variables.divideByAmount(remove);
    }

    public void reset() {
        this.variable = null;
        this.variables.clear();
        this.constantValue = 0.0f;
        this.isSimpleDefinition = false;
    }

    public int sizeInBytes() {
        return (this.variable != null ? 4 : 0) + 4 + 4 + this.variables.sizeInBytes();
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00d0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public java.lang.String toReadableString() {
        boolean z;
        java.lang.String str = (this.variable == null ? "0" : "" + this.variable) + " = ";
        if (this.constantValue != 0.0f) {
            str = str + this.constantValue;
            z = true;
        } else {
            z = false;
        }
        int currentSize = this.variables.getCurrentSize();
        for (int i = 0; i < currentSize; i++) {
            androidx.constraintlayout.solver.SolverVariable variable = this.variables.getVariable(i);
            if (variable != null) {
                float variableValue = this.variables.getVariableValue(i);
                if (variableValue != 0.0f) {
                    java.lang.String solverVariable = variable.toString();
                    if (!z) {
                        if (variableValue < 0.0f) {
                            str = str + "- ";
                            variableValue *= -1.0f;
                        }
                        str = variableValue == 1.0f ? str + solverVariable : str + variableValue + " " + solverVariable;
                        z = true;
                    } else if (variableValue > 0.0f) {
                        str = str + " + ";
                        if (variableValue == 1.0f) {
                        }
                        z = true;
                    } else {
                        str = str + " - ";
                        variableValue *= -1.0f;
                        if (variableValue == 1.0f) {
                        }
                        z = true;
                    }
                }
            }
        }
        if (z) {
            return str;
        }
        return str + com.baidu.mobads.sdk.internal.cl.d;
    }

    public java.lang.String toString() {
        return toReadableString();
    }

    @Override // androidx.constraintlayout.solver.LinearSystem.Row
    public void updateFromFinalVariable(androidx.constraintlayout.solver.LinearSystem linearSystem, androidx.constraintlayout.solver.SolverVariable solverVariable, boolean z) {
        if (solverVariable.isFinalValue) {
            this.constantValue += solverVariable.computedValue * this.variables.get(solverVariable);
            this.variables.remove(solverVariable, z);
            if (z) {
                solverVariable.removeFromRow(this);
            }
            if (androidx.constraintlayout.solver.LinearSystem.SIMPLIFY_SYNONYMS && this.variables.getCurrentSize() == 0) {
                this.isSimpleDefinition = true;
                linearSystem.hasSimpleDefinition = true;
            }
        }
    }

    @Override // androidx.constraintlayout.solver.LinearSystem.Row
    public void updateFromRow(androidx.constraintlayout.solver.LinearSystem linearSystem, androidx.constraintlayout.solver.ArrayRow arrayRow, boolean z) {
        this.constantValue += arrayRow.constantValue * this.variables.use(arrayRow, z);
        if (z) {
            arrayRow.variable.removeFromRow(this);
        }
        if (androidx.constraintlayout.solver.LinearSystem.SIMPLIFY_SYNONYMS && this.variable != null && this.variables.getCurrentSize() == 0) {
            this.isSimpleDefinition = true;
            linearSystem.hasSimpleDefinition = true;
        }
    }

    public void updateFromSynonymVariable(androidx.constraintlayout.solver.LinearSystem linearSystem, androidx.constraintlayout.solver.SolverVariable solverVariable, boolean z) {
        if (solverVariable.isSynonym) {
            float f = this.variables.get(solverVariable);
            this.constantValue += solverVariable.synonymDelta * f;
            this.variables.remove(solverVariable, z);
            if (z) {
                solverVariable.removeFromRow(this);
            }
            this.variables.add(linearSystem.mCache.mIndexedVariables[solverVariable.synonym], f, z);
            if (androidx.constraintlayout.solver.LinearSystem.SIMPLIFY_SYNONYMS && this.variables.getCurrentSize() == 0) {
                this.isSimpleDefinition = true;
                linearSystem.hasSimpleDefinition = true;
            }
        }
    }

    @Override // androidx.constraintlayout.solver.LinearSystem.Row
    public void updateFromSystem(androidx.constraintlayout.solver.LinearSystem linearSystem) {
        if (linearSystem.mRows.length == 0) {
            return;
        }
        boolean z = false;
        while (!z) {
            int currentSize = this.variables.getCurrentSize();
            for (int i = 0; i < currentSize; i++) {
                androidx.constraintlayout.solver.SolverVariable variable = this.variables.getVariable(i);
                if (variable.definitionId != -1 || variable.isFinalValue || variable.isSynonym) {
                    this.variablesToUpdate.add(variable);
                }
            }
            int size = this.variablesToUpdate.size();
            if (size > 0) {
                for (int i2 = 0; i2 < size; i2++) {
                    androidx.constraintlayout.solver.SolverVariable solverVariable = this.variablesToUpdate.get(i2);
                    if (solverVariable.isFinalValue) {
                        updateFromFinalVariable(linearSystem, solverVariable, true);
                    } else if (solverVariable.isSynonym) {
                        updateFromSynonymVariable(linearSystem, solverVariable, true);
                    } else {
                        updateFromRow(linearSystem, linearSystem.mRows[solverVariable.definitionId], true);
                    }
                }
                this.variablesToUpdate.clear();
            } else {
                z = true;
            }
        }
        if (androidx.constraintlayout.solver.LinearSystem.SIMPLIFY_SYNONYMS && this.variable != null && this.variables.getCurrentSize() == 0) {
            this.isSimpleDefinition = true;
            linearSystem.hasSimpleDefinition = true;
        }
    }
}
