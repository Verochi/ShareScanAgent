package androidx.constraintlayout.solver;

/* loaded from: classes.dex */
public class LinearSystem {
    public static long ARRAY_ROW_CREATION = 0;
    public static final boolean DEBUG = false;
    private static final boolean DEBUG_CONSTRAINTS = false;
    public static final boolean FULL_DEBUG = false;
    public static final boolean MEASURE = false;
    public static long OPTIMIZED_ARRAY_ROW_CREATION = 0;
    public static boolean OPTIMIZED_ENGINE = false;
    private static int POOL_SIZE = 1000;
    public static boolean SIMPLIFY_SYNONYMS = true;
    public static boolean SKIP_COLUMNS = true;
    public static boolean USE_BASIC_SYNONYMS = true;
    public static boolean USE_DEPENDENCY_ORDERING = false;
    public static boolean USE_SYNONYMS = true;
    public static androidx.constraintlayout.solver.Metrics sMetrics;
    final androidx.constraintlayout.solver.Cache mCache;
    private androidx.constraintlayout.solver.LinearSystem.Row mGoal;
    androidx.constraintlayout.solver.ArrayRow[] mRows;
    private androidx.constraintlayout.solver.LinearSystem.Row mTempGoal;
    public boolean hasSimpleDefinition = false;
    int mVariablesID = 0;
    private java.util.HashMap<java.lang.String, androidx.constraintlayout.solver.SolverVariable> mVariables = null;
    private int TABLE_SIZE = 32;
    private int mMaxColumns = 32;
    public boolean graphOptimizer = false;
    public boolean newgraphOptimizer = false;
    private boolean[] mAlreadyTestedCandidates = new boolean[32];
    int mNumColumns = 1;
    int mNumRows = 0;
    private int mMaxRows = 32;
    private androidx.constraintlayout.solver.SolverVariable[] mPoolVariables = new androidx.constraintlayout.solver.SolverVariable[POOL_SIZE];
    private int mPoolVariablesCount = 0;

    public interface Row {
        void addError(androidx.constraintlayout.solver.SolverVariable solverVariable);

        void clear();

        androidx.constraintlayout.solver.SolverVariable getKey();

        androidx.constraintlayout.solver.SolverVariable getPivotCandidate(androidx.constraintlayout.solver.LinearSystem linearSystem, boolean[] zArr);

        void initFromRow(androidx.constraintlayout.solver.LinearSystem.Row row);

        boolean isEmpty();

        void updateFromFinalVariable(androidx.constraintlayout.solver.LinearSystem linearSystem, androidx.constraintlayout.solver.SolverVariable solverVariable, boolean z);

        void updateFromRow(androidx.constraintlayout.solver.LinearSystem linearSystem, androidx.constraintlayout.solver.ArrayRow arrayRow, boolean z);

        void updateFromSystem(androidx.constraintlayout.solver.LinearSystem linearSystem);
    }

    public class ValuesRow extends androidx.constraintlayout.solver.ArrayRow {
        public ValuesRow(androidx.constraintlayout.solver.Cache cache) {
            this.variables = new androidx.constraintlayout.solver.SolverVariableValues(this, cache);
        }
    }

    public LinearSystem() {
        this.mRows = null;
        this.mRows = new androidx.constraintlayout.solver.ArrayRow[32];
        releaseRows();
        androidx.constraintlayout.solver.Cache cache = new androidx.constraintlayout.solver.Cache();
        this.mCache = cache;
        this.mGoal = new androidx.constraintlayout.solver.PriorityGoalRow(cache);
        if (OPTIMIZED_ENGINE) {
            this.mTempGoal = new androidx.constraintlayout.solver.LinearSystem.ValuesRow(cache);
        } else {
            this.mTempGoal = new androidx.constraintlayout.solver.ArrayRow(cache);
        }
    }

    private androidx.constraintlayout.solver.SolverVariable acquireSolverVariable(androidx.constraintlayout.solver.SolverVariable.Type type, java.lang.String str) {
        androidx.constraintlayout.solver.SolverVariable acquire = this.mCache.solverVariablePool.acquire();
        if (acquire == null) {
            acquire = new androidx.constraintlayout.solver.SolverVariable(type, str);
            acquire.setType(type, str);
        } else {
            acquire.reset();
            acquire.setType(type, str);
        }
        int i = this.mPoolVariablesCount;
        int i2 = POOL_SIZE;
        if (i >= i2) {
            int i3 = i2 * 2;
            POOL_SIZE = i3;
            this.mPoolVariables = (androidx.constraintlayout.solver.SolverVariable[]) java.util.Arrays.copyOf(this.mPoolVariables, i3);
        }
        androidx.constraintlayout.solver.SolverVariable[] solverVariableArr = this.mPoolVariables;
        int i4 = this.mPoolVariablesCount;
        this.mPoolVariablesCount = i4 + 1;
        solverVariableArr[i4] = acquire;
        return acquire;
    }

    private void addError(androidx.constraintlayout.solver.ArrayRow arrayRow) {
        arrayRow.addError(this, 0);
    }

    private final void addRow(androidx.constraintlayout.solver.ArrayRow arrayRow) {
        int i;
        if (SIMPLIFY_SYNONYMS && arrayRow.isSimpleDefinition) {
            arrayRow.variable.setFinalValue(this, arrayRow.constantValue);
        } else {
            androidx.constraintlayout.solver.ArrayRow[] arrayRowArr = this.mRows;
            int i2 = this.mNumRows;
            arrayRowArr[i2] = arrayRow;
            androidx.constraintlayout.solver.SolverVariable solverVariable = arrayRow.variable;
            solverVariable.definitionId = i2;
            this.mNumRows = i2 + 1;
            solverVariable.updateReferencesWithNewDefinition(this, arrayRow);
        }
        if (SIMPLIFY_SYNONYMS && this.hasSimpleDefinition) {
            int i3 = 0;
            while (i3 < this.mNumRows) {
                if (this.mRows[i3] == null) {
                    java.lang.System.out.println("WTF");
                }
                androidx.constraintlayout.solver.ArrayRow arrayRow2 = this.mRows[i3];
                if (arrayRow2 != null && arrayRow2.isSimpleDefinition) {
                    arrayRow2.variable.setFinalValue(this, arrayRow2.constantValue);
                    if (OPTIMIZED_ENGINE) {
                        this.mCache.optimizedArrayRowPool.release(arrayRow2);
                    } else {
                        this.mCache.arrayRowPool.release(arrayRow2);
                    }
                    this.mRows[i3] = null;
                    int i4 = i3 + 1;
                    int i5 = i4;
                    while (true) {
                        i = this.mNumRows;
                        if (i4 >= i) {
                            break;
                        }
                        androidx.constraintlayout.solver.ArrayRow[] arrayRowArr2 = this.mRows;
                        int i6 = i4 - 1;
                        androidx.constraintlayout.solver.ArrayRow arrayRow3 = arrayRowArr2[i4];
                        arrayRowArr2[i6] = arrayRow3;
                        androidx.constraintlayout.solver.SolverVariable solverVariable2 = arrayRow3.variable;
                        if (solverVariable2.definitionId == i4) {
                            solverVariable2.definitionId = i6;
                        }
                        i5 = i4;
                        i4++;
                    }
                    if (i5 < i) {
                        this.mRows[i5] = null;
                    }
                    this.mNumRows = i - 1;
                    i3--;
                }
                i3++;
            }
            this.hasSimpleDefinition = false;
        }
    }

    private void addSingleError(androidx.constraintlayout.solver.ArrayRow arrayRow, int i) {
        addSingleError(arrayRow, i, 0);
    }

    private void computeValues() {
        for (int i = 0; i < this.mNumRows; i++) {
            androidx.constraintlayout.solver.ArrayRow arrayRow = this.mRows[i];
            arrayRow.variable.computedValue = arrayRow.constantValue;
        }
    }

    public static androidx.constraintlayout.solver.ArrayRow createRowDimensionPercent(androidx.constraintlayout.solver.LinearSystem linearSystem, androidx.constraintlayout.solver.SolverVariable solverVariable, androidx.constraintlayout.solver.SolverVariable solverVariable2, float f) {
        return linearSystem.createRow().createRowDimensionPercent(solverVariable, solverVariable2, f);
    }

    private androidx.constraintlayout.solver.SolverVariable createVariable(java.lang.String str, androidx.constraintlayout.solver.SolverVariable.Type type) {
        androidx.constraintlayout.solver.Metrics metrics = sMetrics;
        if (metrics != null) {
            metrics.variables++;
        }
        if (this.mNumColumns + 1 >= this.mMaxColumns) {
            increaseTableSize();
        }
        androidx.constraintlayout.solver.SolverVariable acquireSolverVariable = acquireSolverVariable(type, null);
        acquireSolverVariable.setName(str);
        int i = this.mVariablesID + 1;
        this.mVariablesID = i;
        this.mNumColumns++;
        acquireSolverVariable.id = i;
        if (this.mVariables == null) {
            this.mVariables = new java.util.HashMap<>();
        }
        this.mVariables.put(str, acquireSolverVariable);
        this.mCache.mIndexedVariables[this.mVariablesID] = acquireSolverVariable;
        return acquireSolverVariable;
    }

    private void displayRows() {
        displaySolverVariables();
        java.lang.String str = "";
        for (int i = 0; i < this.mNumRows; i++) {
            str = (str + this.mRows[i]) + "\n";
        }
        java.lang.System.out.println(str + this.mGoal + "\n");
    }

    private void displaySolverVariables() {
        java.lang.System.out.println("Display Rows (" + this.mNumRows + "x" + this.mNumColumns + ")\n");
    }

    private int enforceBFS(androidx.constraintlayout.solver.LinearSystem.Row row) throws java.lang.Exception {
        boolean z;
        int i = 0;
        while (true) {
            if (i >= this.mNumRows) {
                z = false;
                break;
            }
            androidx.constraintlayout.solver.ArrayRow arrayRow = this.mRows[i];
            if (arrayRow.variable.mType != androidx.constraintlayout.solver.SolverVariable.Type.UNRESTRICTED && arrayRow.constantValue < 0.0f) {
                z = true;
                break;
            }
            i++;
        }
        if (!z) {
            return 0;
        }
        boolean z2 = false;
        int i2 = 0;
        while (!z2) {
            androidx.constraintlayout.solver.Metrics metrics = sMetrics;
            if (metrics != null) {
                metrics.bfs++;
            }
            i2++;
            float f = Float.MAX_VALUE;
            int i3 = -1;
            int i4 = -1;
            int i5 = 0;
            for (int i6 = 0; i6 < this.mNumRows; i6++) {
                androidx.constraintlayout.solver.ArrayRow arrayRow2 = this.mRows[i6];
                if (arrayRow2.variable.mType != androidx.constraintlayout.solver.SolverVariable.Type.UNRESTRICTED && !arrayRow2.isSimpleDefinition && arrayRow2.constantValue < 0.0f) {
                    int i7 = 9;
                    if (SKIP_COLUMNS) {
                        int currentSize = arrayRow2.variables.getCurrentSize();
                        int i8 = 0;
                        while (i8 < currentSize) {
                            androidx.constraintlayout.solver.SolverVariable variable = arrayRow2.variables.getVariable(i8);
                            float f2 = arrayRow2.variables.get(variable);
                            if (f2 > 0.0f) {
                                int i9 = 0;
                                while (i9 < i7) {
                                    float f3 = variable.strengthVector[i9] / f2;
                                    if ((f3 < f && i9 == i5) || i9 > i5) {
                                        i4 = variable.id;
                                        i5 = i9;
                                        i3 = i6;
                                        f = f3;
                                    }
                                    i9++;
                                    i7 = 9;
                                }
                            }
                            i8++;
                            i7 = 9;
                        }
                    } else {
                        for (int i10 = 1; i10 < this.mNumColumns; i10++) {
                            androidx.constraintlayout.solver.SolverVariable solverVariable = this.mCache.mIndexedVariables[i10];
                            float f4 = arrayRow2.variables.get(solverVariable);
                            if (f4 > 0.0f) {
                                for (int i11 = 0; i11 < 9; i11++) {
                                    float f5 = solverVariable.strengthVector[i11] / f4;
                                    if ((f5 < f && i11 == i5) || i11 > i5) {
                                        i4 = i10;
                                        i5 = i11;
                                        i3 = i6;
                                        f = f5;
                                    }
                                }
                            }
                        }
                    }
                }
            }
            if (i3 != -1) {
                androidx.constraintlayout.solver.ArrayRow arrayRow3 = this.mRows[i3];
                arrayRow3.variable.definitionId = -1;
                androidx.constraintlayout.solver.Metrics metrics2 = sMetrics;
                if (metrics2 != null) {
                    metrics2.pivots++;
                }
                arrayRow3.pivot(this.mCache.mIndexedVariables[i4]);
                androidx.constraintlayout.solver.SolverVariable solverVariable2 = arrayRow3.variable;
                solverVariable2.definitionId = i3;
                solverVariable2.updateReferencesWithNewDefinition(this, arrayRow3);
            } else {
                z2 = true;
            }
            if (i2 > this.mNumColumns / 2) {
                z2 = true;
            }
        }
        return i2;
    }

    private java.lang.String getDisplaySize(int i) {
        int i2 = i * 4;
        int i3 = i2 / 1024;
        int i4 = i3 / 1024;
        if (i4 > 0) {
            return "" + i4 + " Mb";
        }
        if (i3 > 0) {
            return "" + i3 + " Kb";
        }
        return "" + i2 + " bytes";
    }

    private java.lang.String getDisplayStrength(int i) {
        return i == 1 ? "LOW" : i == 2 ? "MEDIUM" : i == 3 ? "HIGH" : i == 4 ? "HIGHEST" : i == 5 ? "EQUALITY" : i == 8 ? "FIXED" : i == 6 ? "BARRIER" : "NONE";
    }

    public static androidx.constraintlayout.solver.Metrics getMetrics() {
        return sMetrics;
    }

    private void increaseTableSize() {
        int i = this.TABLE_SIZE * 2;
        this.TABLE_SIZE = i;
        this.mRows = (androidx.constraintlayout.solver.ArrayRow[]) java.util.Arrays.copyOf(this.mRows, i);
        androidx.constraintlayout.solver.Cache cache = this.mCache;
        cache.mIndexedVariables = (androidx.constraintlayout.solver.SolverVariable[]) java.util.Arrays.copyOf(cache.mIndexedVariables, this.TABLE_SIZE);
        int i2 = this.TABLE_SIZE;
        this.mAlreadyTestedCandidates = new boolean[i2];
        this.mMaxColumns = i2;
        this.mMaxRows = i2;
        androidx.constraintlayout.solver.Metrics metrics = sMetrics;
        if (metrics != null) {
            metrics.tableSizeIncrease++;
            metrics.maxTableSize = java.lang.Math.max(metrics.maxTableSize, i2);
            androidx.constraintlayout.solver.Metrics metrics2 = sMetrics;
            metrics2.lastTableSize = metrics2.maxTableSize;
        }
    }

    private final int optimize(androidx.constraintlayout.solver.LinearSystem.Row row, boolean z) {
        androidx.constraintlayout.solver.Metrics metrics = sMetrics;
        if (metrics != null) {
            metrics.optimize++;
        }
        for (int i = 0; i < this.mNumColumns; i++) {
            this.mAlreadyTestedCandidates[i] = false;
        }
        boolean z2 = false;
        int i2 = 0;
        while (!z2) {
            androidx.constraintlayout.solver.Metrics metrics2 = sMetrics;
            if (metrics2 != null) {
                metrics2.iterations++;
            }
            i2++;
            if (i2 >= this.mNumColumns * 2) {
                return i2;
            }
            if (row.getKey() != null) {
                this.mAlreadyTestedCandidates[row.getKey().id] = true;
            }
            androidx.constraintlayout.solver.SolverVariable pivotCandidate = row.getPivotCandidate(this, this.mAlreadyTestedCandidates);
            if (pivotCandidate != null) {
                boolean[] zArr = this.mAlreadyTestedCandidates;
                int i3 = pivotCandidate.id;
                if (zArr[i3]) {
                    return i2;
                }
                zArr[i3] = true;
            }
            if (pivotCandidate != null) {
                float f = Float.MAX_VALUE;
                int i4 = -1;
                for (int i5 = 0; i5 < this.mNumRows; i5++) {
                    androidx.constraintlayout.solver.ArrayRow arrayRow = this.mRows[i5];
                    if (arrayRow.variable.mType != androidx.constraintlayout.solver.SolverVariable.Type.UNRESTRICTED && !arrayRow.isSimpleDefinition && arrayRow.hasVariable(pivotCandidate)) {
                        float f2 = arrayRow.variables.get(pivotCandidate);
                        if (f2 < 0.0f) {
                            float f3 = (-arrayRow.constantValue) / f2;
                            if (f3 < f) {
                                i4 = i5;
                                f = f3;
                            }
                        }
                    }
                }
                if (i4 > -1) {
                    androidx.constraintlayout.solver.ArrayRow arrayRow2 = this.mRows[i4];
                    arrayRow2.variable.definitionId = -1;
                    androidx.constraintlayout.solver.Metrics metrics3 = sMetrics;
                    if (metrics3 != null) {
                        metrics3.pivots++;
                    }
                    arrayRow2.pivot(pivotCandidate);
                    androidx.constraintlayout.solver.SolverVariable solverVariable = arrayRow2.variable;
                    solverVariable.definitionId = i4;
                    solverVariable.updateReferencesWithNewDefinition(this, arrayRow2);
                }
            } else {
                z2 = true;
            }
        }
        return i2;
    }

    private void releaseRows() {
        int i = 0;
        if (OPTIMIZED_ENGINE) {
            while (i < this.mNumRows) {
                androidx.constraintlayout.solver.ArrayRow arrayRow = this.mRows[i];
                if (arrayRow != null) {
                    this.mCache.optimizedArrayRowPool.release(arrayRow);
                }
                this.mRows[i] = null;
                i++;
            }
            return;
        }
        while (i < this.mNumRows) {
            androidx.constraintlayout.solver.ArrayRow arrayRow2 = this.mRows[i];
            if (arrayRow2 != null) {
                this.mCache.arrayRowPool.release(arrayRow2);
            }
            this.mRows[i] = null;
            i++;
        }
    }

    public void addCenterPoint(androidx.constraintlayout.solver.widgets.ConstraintWidget constraintWidget, androidx.constraintlayout.solver.widgets.ConstraintWidget constraintWidget2, float f, int i) {
        androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type type = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.LEFT;
        androidx.constraintlayout.solver.SolverVariable createObjectVariable = createObjectVariable(constraintWidget.getAnchor(type));
        androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type type2 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.TOP;
        androidx.constraintlayout.solver.SolverVariable createObjectVariable2 = createObjectVariable(constraintWidget.getAnchor(type2));
        androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type type3 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.RIGHT;
        androidx.constraintlayout.solver.SolverVariable createObjectVariable3 = createObjectVariable(constraintWidget.getAnchor(type3));
        androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type type4 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.BOTTOM;
        androidx.constraintlayout.solver.SolverVariable createObjectVariable4 = createObjectVariable(constraintWidget.getAnchor(type4));
        androidx.constraintlayout.solver.SolverVariable createObjectVariable5 = createObjectVariable(constraintWidget2.getAnchor(type));
        androidx.constraintlayout.solver.SolverVariable createObjectVariable6 = createObjectVariable(constraintWidget2.getAnchor(type2));
        androidx.constraintlayout.solver.SolverVariable createObjectVariable7 = createObjectVariable(constraintWidget2.getAnchor(type3));
        androidx.constraintlayout.solver.SolverVariable createObjectVariable8 = createObjectVariable(constraintWidget2.getAnchor(type4));
        androidx.constraintlayout.solver.ArrayRow createRow = createRow();
        double d = f;
        double d2 = i;
        createRow.createRowWithAngle(createObjectVariable2, createObjectVariable4, createObjectVariable6, createObjectVariable8, (float) (java.lang.Math.sin(d) * d2));
        addConstraint(createRow);
        androidx.constraintlayout.solver.ArrayRow createRow2 = createRow();
        createRow2.createRowWithAngle(createObjectVariable, createObjectVariable3, createObjectVariable5, createObjectVariable7, (float) (java.lang.Math.cos(d) * d2));
        addConstraint(createRow2);
    }

    public void addCentering(androidx.constraintlayout.solver.SolverVariable solverVariable, androidx.constraintlayout.solver.SolverVariable solverVariable2, int i, float f, androidx.constraintlayout.solver.SolverVariable solverVariable3, androidx.constraintlayout.solver.SolverVariable solverVariable4, int i2, int i3) {
        androidx.constraintlayout.solver.ArrayRow createRow = createRow();
        createRow.createRowCentering(solverVariable, solverVariable2, i, f, solverVariable3, solverVariable4, i2);
        if (i3 != 8) {
            createRow.addError(this, i3);
        }
        addConstraint(createRow);
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x009f A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00a0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void addConstraint(androidx.constraintlayout.solver.ArrayRow arrayRow) {
        androidx.constraintlayout.solver.SolverVariable pickPivot;
        if (arrayRow == null) {
            return;
        }
        androidx.constraintlayout.solver.Metrics metrics = sMetrics;
        if (metrics != null) {
            metrics.constraints++;
            if (arrayRow.isSimpleDefinition) {
                metrics.simpleconstraints++;
            }
        }
        boolean z = true;
        if (this.mNumRows + 1 >= this.mMaxRows || this.mNumColumns + 1 >= this.mMaxColumns) {
            increaseTableSize();
        }
        boolean z2 = false;
        if (!arrayRow.isSimpleDefinition) {
            arrayRow.updateFromSystem(this);
            if (arrayRow.isEmpty()) {
                return;
            }
            arrayRow.ensurePositiveConstant();
            if (arrayRow.chooseSubject(this)) {
                androidx.constraintlayout.solver.SolverVariable createExtraVariable = createExtraVariable();
                arrayRow.variable = createExtraVariable;
                int i = this.mNumRows;
                addRow(arrayRow);
                if (this.mNumRows == i + 1) {
                    this.mTempGoal.initFromRow(arrayRow);
                    optimize(this.mTempGoal, true);
                    if (createExtraVariable.definitionId == -1) {
                        if (arrayRow.variable == createExtraVariable && (pickPivot = arrayRow.pickPivot(createExtraVariable)) != null) {
                            androidx.constraintlayout.solver.Metrics metrics2 = sMetrics;
                            if (metrics2 != null) {
                                metrics2.pivots++;
                            }
                            arrayRow.pivot(pickPivot);
                        }
                        if (!arrayRow.isSimpleDefinition) {
                            arrayRow.variable.updateReferencesWithNewDefinition(this, arrayRow);
                        }
                        if (OPTIMIZED_ENGINE) {
                            this.mCache.optimizedArrayRowPool.release(arrayRow);
                        } else {
                            this.mCache.arrayRowPool.release(arrayRow);
                        }
                        this.mNumRows--;
                    }
                    if (arrayRow.hasKeyVariable()) {
                        return;
                    } else {
                        z2 = z;
                    }
                }
            }
            z = false;
            if (arrayRow.hasKeyVariable()) {
            }
        }
        if (z2) {
            return;
        }
        addRow(arrayRow);
    }

    public androidx.constraintlayout.solver.ArrayRow addEquality(androidx.constraintlayout.solver.SolverVariable solverVariable, androidx.constraintlayout.solver.SolverVariable solverVariable2, int i, int i2) {
        if (USE_BASIC_SYNONYMS && i2 == 8 && solverVariable2.isFinalValue && solverVariable.definitionId == -1) {
            solverVariable.setFinalValue(this, solverVariable2.computedValue + i);
            return null;
        }
        androidx.constraintlayout.solver.ArrayRow createRow = createRow();
        createRow.createRowEquals(solverVariable, solverVariable2, i);
        if (i2 != 8) {
            createRow.addError(this, i2);
        }
        addConstraint(createRow);
        return createRow;
    }

    public void addEquality(androidx.constraintlayout.solver.SolverVariable solverVariable, int i) {
        if (USE_BASIC_SYNONYMS && solverVariable.definitionId == -1) {
            float f = i;
            solverVariable.setFinalValue(this, f);
            for (int i2 = 0; i2 < this.mVariablesID + 1; i2++) {
                androidx.constraintlayout.solver.SolverVariable solverVariable2 = this.mCache.mIndexedVariables[i2];
                if (solverVariable2 != null && solverVariable2.isSynonym && solverVariable2.synonym == solverVariable.id) {
                    solverVariable2.setFinalValue(this, solverVariable2.synonymDelta + f);
                }
            }
            return;
        }
        int i3 = solverVariable.definitionId;
        if (i3 == -1) {
            androidx.constraintlayout.solver.ArrayRow createRow = createRow();
            createRow.createRowDefinition(solverVariable, i);
            addConstraint(createRow);
            return;
        }
        androidx.constraintlayout.solver.ArrayRow arrayRow = this.mRows[i3];
        if (arrayRow.isSimpleDefinition) {
            arrayRow.constantValue = i;
            return;
        }
        if (arrayRow.variables.getCurrentSize() == 0) {
            arrayRow.isSimpleDefinition = true;
            arrayRow.constantValue = i;
        } else {
            androidx.constraintlayout.solver.ArrayRow createRow2 = createRow();
            createRow2.createRowEquals(solverVariable, i);
            addConstraint(createRow2);
        }
    }

    public void addGreaterBarrier(androidx.constraintlayout.solver.SolverVariable solverVariable, androidx.constraintlayout.solver.SolverVariable solverVariable2, int i, boolean z) {
        androidx.constraintlayout.solver.ArrayRow createRow = createRow();
        androidx.constraintlayout.solver.SolverVariable createSlackVariable = createSlackVariable();
        createSlackVariable.strength = 0;
        createRow.createRowGreaterThan(solverVariable, solverVariable2, createSlackVariable, i);
        addConstraint(createRow);
    }

    public void addGreaterThan(androidx.constraintlayout.solver.SolverVariable solverVariable, androidx.constraintlayout.solver.SolverVariable solverVariable2, int i, int i2) {
        androidx.constraintlayout.solver.ArrayRow createRow = createRow();
        androidx.constraintlayout.solver.SolverVariable createSlackVariable = createSlackVariable();
        createSlackVariable.strength = 0;
        createRow.createRowGreaterThan(solverVariable, solverVariable2, createSlackVariable, i);
        if (i2 != 8) {
            addSingleError(createRow, (int) (createRow.variables.get(createSlackVariable) * (-1.0f)), i2);
        }
        addConstraint(createRow);
    }

    public void addLowerBarrier(androidx.constraintlayout.solver.SolverVariable solverVariable, androidx.constraintlayout.solver.SolverVariable solverVariable2, int i, boolean z) {
        androidx.constraintlayout.solver.ArrayRow createRow = createRow();
        androidx.constraintlayout.solver.SolverVariable createSlackVariable = createSlackVariable();
        createSlackVariable.strength = 0;
        createRow.createRowLowerThan(solverVariable, solverVariable2, createSlackVariable, i);
        addConstraint(createRow);
    }

    public void addLowerThan(androidx.constraintlayout.solver.SolverVariable solverVariable, androidx.constraintlayout.solver.SolverVariable solverVariable2, int i, int i2) {
        androidx.constraintlayout.solver.ArrayRow createRow = createRow();
        androidx.constraintlayout.solver.SolverVariable createSlackVariable = createSlackVariable();
        createSlackVariable.strength = 0;
        createRow.createRowLowerThan(solverVariable, solverVariable2, createSlackVariable, i);
        if (i2 != 8) {
            addSingleError(createRow, (int) (createRow.variables.get(createSlackVariable) * (-1.0f)), i2);
        }
        addConstraint(createRow);
    }

    public void addRatio(androidx.constraintlayout.solver.SolverVariable solverVariable, androidx.constraintlayout.solver.SolverVariable solverVariable2, androidx.constraintlayout.solver.SolverVariable solverVariable3, androidx.constraintlayout.solver.SolverVariable solverVariable4, float f, int i) {
        androidx.constraintlayout.solver.ArrayRow createRow = createRow();
        createRow.createRowDimensionRatio(solverVariable, solverVariable2, solverVariable3, solverVariable4, f);
        if (i != 8) {
            createRow.addError(this, i);
        }
        addConstraint(createRow);
    }

    public void addSingleError(androidx.constraintlayout.solver.ArrayRow arrayRow, int i, int i2) {
        arrayRow.addSingleError(createErrorVariable(i2, null), i);
    }

    public void addSynonym(androidx.constraintlayout.solver.SolverVariable solverVariable, androidx.constraintlayout.solver.SolverVariable solverVariable2, int i) {
        if (solverVariable.definitionId != -1 || i != 0) {
            addEquality(solverVariable, solverVariable2, i, 8);
            return;
        }
        if (solverVariable2.isSynonym) {
            solverVariable2 = this.mCache.mIndexedVariables[solverVariable2.synonym];
        }
        if (solverVariable.isSynonym) {
            androidx.constraintlayout.solver.SolverVariable solverVariable3 = this.mCache.mIndexedVariables[solverVariable.synonym];
        } else {
            solverVariable.setSynonym(this, solverVariable2, 0.0f);
        }
    }

    public final void cleanupRows() {
        int i;
        int i2 = 0;
        while (i2 < this.mNumRows) {
            androidx.constraintlayout.solver.ArrayRow arrayRow = this.mRows[i2];
            if (arrayRow.variables.getCurrentSize() == 0) {
                arrayRow.isSimpleDefinition = true;
            }
            if (arrayRow.isSimpleDefinition) {
                androidx.constraintlayout.solver.SolverVariable solverVariable = arrayRow.variable;
                solverVariable.computedValue = arrayRow.constantValue;
                solverVariable.removeFromRow(arrayRow);
                int i3 = i2;
                while (true) {
                    i = this.mNumRows;
                    if (i3 >= i - 1) {
                        break;
                    }
                    androidx.constraintlayout.solver.ArrayRow[] arrayRowArr = this.mRows;
                    int i4 = i3 + 1;
                    arrayRowArr[i3] = arrayRowArr[i4];
                    i3 = i4;
                }
                this.mRows[i - 1] = null;
                this.mNumRows = i - 1;
                i2--;
                if (OPTIMIZED_ENGINE) {
                    this.mCache.optimizedArrayRowPool.release(arrayRow);
                } else {
                    this.mCache.arrayRowPool.release(arrayRow);
                }
            }
            i2++;
        }
    }

    public androidx.constraintlayout.solver.SolverVariable createErrorVariable(int i, java.lang.String str) {
        androidx.constraintlayout.solver.Metrics metrics = sMetrics;
        if (metrics != null) {
            metrics.errors++;
        }
        if (this.mNumColumns + 1 >= this.mMaxColumns) {
            increaseTableSize();
        }
        androidx.constraintlayout.solver.SolverVariable acquireSolverVariable = acquireSolverVariable(androidx.constraintlayout.solver.SolverVariable.Type.ERROR, str);
        int i2 = this.mVariablesID + 1;
        this.mVariablesID = i2;
        this.mNumColumns++;
        acquireSolverVariable.id = i2;
        acquireSolverVariable.strength = i;
        this.mCache.mIndexedVariables[i2] = acquireSolverVariable;
        this.mGoal.addError(acquireSolverVariable);
        return acquireSolverVariable;
    }

    public androidx.constraintlayout.solver.SolverVariable createExtraVariable() {
        androidx.constraintlayout.solver.Metrics metrics = sMetrics;
        if (metrics != null) {
            metrics.extravariables++;
        }
        if (this.mNumColumns + 1 >= this.mMaxColumns) {
            increaseTableSize();
        }
        androidx.constraintlayout.solver.SolverVariable acquireSolverVariable = acquireSolverVariable(androidx.constraintlayout.solver.SolverVariable.Type.SLACK, null);
        int i = this.mVariablesID + 1;
        this.mVariablesID = i;
        this.mNumColumns++;
        acquireSolverVariable.id = i;
        this.mCache.mIndexedVariables[i] = acquireSolverVariable;
        return acquireSolverVariable;
    }

    public androidx.constraintlayout.solver.SolverVariable createObjectVariable(java.lang.Object obj) {
        androidx.constraintlayout.solver.SolverVariable solverVariable = null;
        if (obj == null) {
            return null;
        }
        if (this.mNumColumns + 1 >= this.mMaxColumns) {
            increaseTableSize();
        }
        if (obj instanceof androidx.constraintlayout.solver.widgets.ConstraintAnchor) {
            androidx.constraintlayout.solver.widgets.ConstraintAnchor constraintAnchor = (androidx.constraintlayout.solver.widgets.ConstraintAnchor) obj;
            solverVariable = constraintAnchor.getSolverVariable();
            if (solverVariable == null) {
                constraintAnchor.resetSolverVariable(this.mCache);
                solverVariable = constraintAnchor.getSolverVariable();
            }
            int i = solverVariable.id;
            if (i == -1 || i > this.mVariablesID || this.mCache.mIndexedVariables[i] == null) {
                if (i != -1) {
                    solverVariable.reset();
                }
                int i2 = this.mVariablesID + 1;
                this.mVariablesID = i2;
                this.mNumColumns++;
                solverVariable.id = i2;
                solverVariable.mType = androidx.constraintlayout.solver.SolverVariable.Type.UNRESTRICTED;
                this.mCache.mIndexedVariables[i2] = solverVariable;
            }
        }
        return solverVariable;
    }

    public androidx.constraintlayout.solver.ArrayRow createRow() {
        androidx.constraintlayout.solver.ArrayRow acquire;
        if (OPTIMIZED_ENGINE) {
            acquire = this.mCache.optimizedArrayRowPool.acquire();
            if (acquire == null) {
                acquire = new androidx.constraintlayout.solver.LinearSystem.ValuesRow(this.mCache);
                OPTIMIZED_ARRAY_ROW_CREATION++;
            } else {
                acquire.reset();
            }
        } else {
            acquire = this.mCache.arrayRowPool.acquire();
            if (acquire == null) {
                acquire = new androidx.constraintlayout.solver.ArrayRow(this.mCache);
                ARRAY_ROW_CREATION++;
            } else {
                acquire.reset();
            }
        }
        androidx.constraintlayout.solver.SolverVariable.increaseErrorId();
        return acquire;
    }

    public androidx.constraintlayout.solver.SolverVariable createSlackVariable() {
        androidx.constraintlayout.solver.Metrics metrics = sMetrics;
        if (metrics != null) {
            metrics.slackvariables++;
        }
        if (this.mNumColumns + 1 >= this.mMaxColumns) {
            increaseTableSize();
        }
        androidx.constraintlayout.solver.SolverVariable acquireSolverVariable = acquireSolverVariable(androidx.constraintlayout.solver.SolverVariable.Type.SLACK, null);
        int i = this.mVariablesID + 1;
        this.mVariablesID = i;
        this.mNumColumns++;
        acquireSolverVariable.id = i;
        this.mCache.mIndexedVariables[i] = acquireSolverVariable;
        return acquireSolverVariable;
    }

    public void displayReadableRows() {
        displaySolverVariables();
        java.lang.String str = " num vars " + this.mVariablesID + "\n";
        for (int i = 0; i < this.mVariablesID + 1; i++) {
            androidx.constraintlayout.solver.SolverVariable solverVariable = this.mCache.mIndexedVariables[i];
            if (solverVariable != null && solverVariable.isFinalValue) {
                str = str + " $[" + i + "] => " + solverVariable + " = " + solverVariable.computedValue + "\n";
            }
        }
        java.lang.String str2 = str + "\n";
        for (int i2 = 0; i2 < this.mVariablesID + 1; i2++) {
            androidx.constraintlayout.solver.SolverVariable[] solverVariableArr = this.mCache.mIndexedVariables;
            androidx.constraintlayout.solver.SolverVariable solverVariable2 = solverVariableArr[i2];
            if (solverVariable2 != null && solverVariable2.isSynonym) {
                str2 = str2 + " ~[" + i2 + "] => " + solverVariable2 + " = " + solverVariableArr[solverVariable2.synonym] + " + " + solverVariable2.synonymDelta + "\n";
            }
        }
        java.lang.String str3 = str2 + "\n\n #  ";
        for (int i3 = 0; i3 < this.mNumRows; i3++) {
            str3 = (str3 + this.mRows[i3].toReadableString()) + "\n #  ";
        }
        if (this.mGoal != null) {
            str3 = str3 + "Goal: " + this.mGoal + "\n";
        }
        java.lang.System.out.println(str3);
    }

    public void displaySystemInformations() {
        int i = 0;
        for (int i2 = 0; i2 < this.TABLE_SIZE; i2++) {
            androidx.constraintlayout.solver.ArrayRow arrayRow = this.mRows[i2];
            if (arrayRow != null) {
                i += arrayRow.sizeInBytes();
            }
        }
        int i3 = 0;
        for (int i4 = 0; i4 < this.mNumRows; i4++) {
            androidx.constraintlayout.solver.ArrayRow arrayRow2 = this.mRows[i4];
            if (arrayRow2 != null) {
                i3 += arrayRow2.sizeInBytes();
            }
        }
        java.io.PrintStream printStream = java.lang.System.out;
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("Linear System -> Table size: ");
        sb.append(this.TABLE_SIZE);
        sb.append(" (");
        int i5 = this.TABLE_SIZE;
        sb.append(getDisplaySize(i5 * i5));
        sb.append(") -- row sizes: ");
        sb.append(getDisplaySize(i));
        sb.append(", actual size: ");
        sb.append(getDisplaySize(i3));
        sb.append(" rows: ");
        sb.append(this.mNumRows);
        sb.append(net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR);
        sb.append(this.mMaxRows);
        sb.append(" cols: ");
        sb.append(this.mNumColumns);
        sb.append(net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR);
        sb.append(this.mMaxColumns);
        sb.append(" ");
        sb.append(0);
        sb.append(" occupied cells, ");
        sb.append(getDisplaySize(0));
        printStream.println(sb.toString());
    }

    public void displayVariablesReadableRows() {
        displaySolverVariables();
        java.lang.String str = "";
        for (int i = 0; i < this.mNumRows; i++) {
            if (this.mRows[i].variable.mType == androidx.constraintlayout.solver.SolverVariable.Type.UNRESTRICTED) {
                str = (str + this.mRows[i].toReadableString()) + "\n";
            }
        }
        java.lang.System.out.println(str + this.mGoal + "\n");
    }

    public void fillMetrics(androidx.constraintlayout.solver.Metrics metrics) {
        sMetrics = metrics;
    }

    public androidx.constraintlayout.solver.Cache getCache() {
        return this.mCache;
    }

    public androidx.constraintlayout.solver.LinearSystem.Row getGoal() {
        return this.mGoal;
    }

    public int getMemoryUsed() {
        int i = 0;
        for (int i2 = 0; i2 < this.mNumRows; i2++) {
            androidx.constraintlayout.solver.ArrayRow arrayRow = this.mRows[i2];
            if (arrayRow != null) {
                i += arrayRow.sizeInBytes();
            }
        }
        return i;
    }

    public int getNumEquations() {
        return this.mNumRows;
    }

    public int getNumVariables() {
        return this.mVariablesID;
    }

    public int getObjectVariableValue(java.lang.Object obj) {
        androidx.constraintlayout.solver.SolverVariable solverVariable = ((androidx.constraintlayout.solver.widgets.ConstraintAnchor) obj).getSolverVariable();
        if (solverVariable != null) {
            return (int) (solverVariable.computedValue + 0.5f);
        }
        return 0;
    }

    public androidx.constraintlayout.solver.ArrayRow getRow(int i) {
        return this.mRows[i];
    }

    public float getValueFor(java.lang.String str) {
        androidx.constraintlayout.solver.SolverVariable variable = getVariable(str, androidx.constraintlayout.solver.SolverVariable.Type.UNRESTRICTED);
        if (variable == null) {
            return 0.0f;
        }
        return variable.computedValue;
    }

    public androidx.constraintlayout.solver.SolverVariable getVariable(java.lang.String str, androidx.constraintlayout.solver.SolverVariable.Type type) {
        if (this.mVariables == null) {
            this.mVariables = new java.util.HashMap<>();
        }
        androidx.constraintlayout.solver.SolverVariable solverVariable = this.mVariables.get(str);
        return solverVariable == null ? createVariable(str, type) : solverVariable;
    }

    public void minimize() throws java.lang.Exception {
        androidx.constraintlayout.solver.Metrics metrics = sMetrics;
        if (metrics != null) {
            metrics.minimize++;
        }
        if (this.mGoal.isEmpty()) {
            computeValues();
            return;
        }
        if (!this.graphOptimizer && !this.newgraphOptimizer) {
            minimizeGoal(this.mGoal);
            return;
        }
        androidx.constraintlayout.solver.Metrics metrics2 = sMetrics;
        if (metrics2 != null) {
            metrics2.graphOptimizer++;
        }
        boolean z = false;
        int i = 0;
        while (true) {
            if (i >= this.mNumRows) {
                z = true;
                break;
            } else if (!this.mRows[i].isSimpleDefinition) {
                break;
            } else {
                i++;
            }
        }
        if (!z) {
            minimizeGoal(this.mGoal);
            return;
        }
        androidx.constraintlayout.solver.Metrics metrics3 = sMetrics;
        if (metrics3 != null) {
            metrics3.fullySolved++;
        }
        computeValues();
    }

    public void minimizeGoal(androidx.constraintlayout.solver.LinearSystem.Row row) throws java.lang.Exception {
        androidx.constraintlayout.solver.Metrics metrics = sMetrics;
        if (metrics != null) {
            metrics.minimizeGoal++;
            metrics.maxVariables = java.lang.Math.max(metrics.maxVariables, this.mNumColumns);
            androidx.constraintlayout.solver.Metrics metrics2 = sMetrics;
            metrics2.maxRows = java.lang.Math.max(metrics2.maxRows, this.mNumRows);
        }
        enforceBFS(row);
        optimize(row, false);
        computeValues();
    }

    public void removeRow(androidx.constraintlayout.solver.ArrayRow arrayRow) {
        androidx.constraintlayout.solver.SolverVariable solverVariable;
        int i;
        if (!arrayRow.isSimpleDefinition || (solverVariable = arrayRow.variable) == null) {
            return;
        }
        int i2 = solverVariable.definitionId;
        if (i2 != -1) {
            while (true) {
                i = this.mNumRows;
                if (i2 >= i - 1) {
                    break;
                }
                androidx.constraintlayout.solver.ArrayRow[] arrayRowArr = this.mRows;
                int i3 = i2 + 1;
                androidx.constraintlayout.solver.ArrayRow arrayRow2 = arrayRowArr[i3];
                androidx.constraintlayout.solver.SolverVariable solverVariable2 = arrayRow2.variable;
                if (solverVariable2.definitionId == i3) {
                    solverVariable2.definitionId = i2;
                }
                arrayRowArr[i2] = arrayRow2;
                i2 = i3;
            }
            this.mNumRows = i - 1;
        }
        androidx.constraintlayout.solver.SolverVariable solverVariable3 = arrayRow.variable;
        if (!solverVariable3.isFinalValue) {
            solverVariable3.setFinalValue(this, arrayRow.constantValue);
        }
        if (OPTIMIZED_ENGINE) {
            this.mCache.optimizedArrayRowPool.release(arrayRow);
        } else {
            this.mCache.arrayRowPool.release(arrayRow);
        }
    }

    public void reset() {
        androidx.constraintlayout.solver.Cache cache;
        int i = 0;
        while (true) {
            cache = this.mCache;
            androidx.constraintlayout.solver.SolverVariable[] solverVariableArr = cache.mIndexedVariables;
            if (i >= solverVariableArr.length) {
                break;
            }
            androidx.constraintlayout.solver.SolverVariable solverVariable = solverVariableArr[i];
            if (solverVariable != null) {
                solverVariable.reset();
            }
            i++;
        }
        cache.solverVariablePool.releaseAll(this.mPoolVariables, this.mPoolVariablesCount);
        this.mPoolVariablesCount = 0;
        java.util.Arrays.fill(this.mCache.mIndexedVariables, (java.lang.Object) null);
        java.util.HashMap<java.lang.String, androidx.constraintlayout.solver.SolverVariable> hashMap = this.mVariables;
        if (hashMap != null) {
            hashMap.clear();
        }
        this.mVariablesID = 0;
        this.mGoal.clear();
        this.mNumColumns = 1;
        for (int i2 = 0; i2 < this.mNumRows; i2++) {
            androidx.constraintlayout.solver.ArrayRow arrayRow = this.mRows[i2];
            if (arrayRow != null) {
                arrayRow.used = false;
            }
        }
        releaseRows();
        this.mNumRows = 0;
        if (OPTIMIZED_ENGINE) {
            this.mTempGoal = new androidx.constraintlayout.solver.LinearSystem.ValuesRow(this.mCache);
        } else {
            this.mTempGoal = new androidx.constraintlayout.solver.ArrayRow(this.mCache);
        }
    }
}
