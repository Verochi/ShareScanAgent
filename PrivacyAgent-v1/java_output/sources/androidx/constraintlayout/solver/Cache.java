package androidx.constraintlayout.solver;

/* loaded from: classes.dex */
public class Cache {
    androidx.constraintlayout.solver.Pools.Pool<androidx.constraintlayout.solver.ArrayRow> optimizedArrayRowPool = new androidx.constraintlayout.solver.Pools.SimplePool(256);
    androidx.constraintlayout.solver.Pools.Pool<androidx.constraintlayout.solver.ArrayRow> arrayRowPool = new androidx.constraintlayout.solver.Pools.SimplePool(256);
    androidx.constraintlayout.solver.Pools.Pool<androidx.constraintlayout.solver.SolverVariable> solverVariablePool = new androidx.constraintlayout.solver.Pools.SimplePool(256);
    androidx.constraintlayout.solver.SolverVariable[] mIndexedVariables = new androidx.constraintlayout.solver.SolverVariable[32];
}
