package androidx.constraintlayout.solver.state.helpers;

/* loaded from: classes.dex */
public class AlignVerticallyReference extends androidx.constraintlayout.solver.state.HelperReference {
    private float mBias;
    private java.lang.Object mBottomToBottom;
    private java.lang.Object mBottomToTop;
    private java.lang.Object mTopToBottom;
    private java.lang.Object mTopToTop;

    public AlignVerticallyReference(androidx.constraintlayout.solver.state.State state) {
        super(state, androidx.constraintlayout.solver.state.State.Helper.ALIGN_VERTICALLY);
        this.mBias = 0.5f;
    }

    @Override // androidx.constraintlayout.solver.state.HelperReference
    public void apply() {
        java.util.Iterator<java.lang.Object> it = this.mReferences.iterator();
        while (it.hasNext()) {
            androidx.constraintlayout.solver.state.ConstraintReference constraints = this.mState.constraints(it.next());
            constraints.clearVertical();
            java.lang.Object obj = this.mTopToTop;
            if (obj != null) {
                constraints.topToTop(obj);
            } else {
                java.lang.Object obj2 = this.mTopToBottom;
                if (obj2 != null) {
                    constraints.topToBottom(obj2);
                } else {
                    constraints.topToTop(androidx.constraintlayout.solver.state.State.PARENT);
                }
            }
            java.lang.Object obj3 = this.mBottomToTop;
            if (obj3 != null) {
                constraints.bottomToTop(obj3);
            } else {
                java.lang.Object obj4 = this.mBottomToBottom;
                if (obj4 != null) {
                    constraints.bottomToBottom(obj4);
                } else {
                    constraints.bottomToBottom(androidx.constraintlayout.solver.state.State.PARENT);
                }
            }
            float f = this.mBias;
            if (f != 0.5f) {
                constraints.verticalBias(f);
            }
        }
    }

    public void bias(float f) {
        this.mBias = f;
    }

    public void bottomToBottom(java.lang.Object obj) {
        this.mBottomToBottom = obj;
    }

    public void bottomToTop(java.lang.Object obj) {
        this.mBottomToTop = obj;
    }

    public void topToBottom(java.lang.Object obj) {
        this.mTopToBottom = obj;
    }

    public void topToTop(java.lang.Object obj) {
        this.mTopToTop = obj;
    }
}
