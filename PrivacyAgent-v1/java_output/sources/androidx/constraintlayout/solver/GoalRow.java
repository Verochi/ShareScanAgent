package androidx.constraintlayout.solver;

/* loaded from: classes.dex */
public class GoalRow extends androidx.constraintlayout.solver.ArrayRow {
    public GoalRow(androidx.constraintlayout.solver.Cache cache) {
        super(cache);
    }

    @Override // androidx.constraintlayout.solver.ArrayRow, androidx.constraintlayout.solver.LinearSystem.Row
    public void addError(androidx.constraintlayout.solver.SolverVariable solverVariable) {
        super.addError(solverVariable);
        solverVariable.usageInRowCount--;
    }
}
