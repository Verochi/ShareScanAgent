package androidx.constraintlayout.solver.state.helpers;

/* loaded from: classes.dex */
public class ChainReference extends androidx.constraintlayout.solver.state.HelperReference {
    protected float mBias;
    protected androidx.constraintlayout.solver.state.State.Chain mStyle;

    public ChainReference(androidx.constraintlayout.solver.state.State state, androidx.constraintlayout.solver.state.State.Helper helper) {
        super(state, helper);
        this.mBias = 0.5f;
        this.mStyle = androidx.constraintlayout.solver.state.State.Chain.SPREAD;
    }

    public void bias(float f) {
        this.mBias = f;
    }

    public float getBias() {
        return this.mBias;
    }

    public androidx.constraintlayout.solver.state.State.Chain getStyle() {
        return androidx.constraintlayout.solver.state.State.Chain.SPREAD;
    }

    public void style(androidx.constraintlayout.solver.state.State.Chain chain) {
        this.mStyle = chain;
    }
}
