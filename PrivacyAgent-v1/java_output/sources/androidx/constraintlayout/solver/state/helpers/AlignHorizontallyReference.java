package androidx.constraintlayout.solver.state.helpers;

/* loaded from: classes.dex */
public class AlignHorizontallyReference extends androidx.constraintlayout.solver.state.HelperReference {
    private float mBias;
    private java.lang.Object mEndToEnd;
    private java.lang.Object mEndToStart;
    private java.lang.Object mStartToEnd;
    private java.lang.Object mStartToStart;

    public AlignHorizontallyReference(androidx.constraintlayout.solver.state.State state) {
        super(state, androidx.constraintlayout.solver.state.State.Helper.ALIGN_VERTICALLY);
        this.mBias = 0.5f;
    }

    @Override // androidx.constraintlayout.solver.state.HelperReference
    public void apply() {
        java.util.Iterator<java.lang.Object> it = this.mReferences.iterator();
        while (it.hasNext()) {
            androidx.constraintlayout.solver.state.ConstraintReference constraints = this.mState.constraints(it.next());
            constraints.clearHorizontal();
            java.lang.Object obj = this.mStartToStart;
            if (obj != null) {
                constraints.startToStart(obj);
            } else {
                java.lang.Object obj2 = this.mStartToEnd;
                if (obj2 != null) {
                    constraints.startToEnd(obj2);
                } else {
                    constraints.startToStart(androidx.constraintlayout.solver.state.State.PARENT);
                }
            }
            java.lang.Object obj3 = this.mEndToStart;
            if (obj3 != null) {
                constraints.endToStart(obj3);
            } else {
                java.lang.Object obj4 = this.mEndToEnd;
                if (obj4 != null) {
                    constraints.endToEnd(obj4);
                } else {
                    constraints.endToEnd(androidx.constraintlayout.solver.state.State.PARENT);
                }
            }
            float f = this.mBias;
            if (f != 0.5f) {
                constraints.horizontalBias(f);
            }
        }
    }

    public void bias(float f) {
        this.mBias = f;
    }

    public void endToEnd(java.lang.Object obj) {
        this.mEndToEnd = obj;
    }

    public void endToStart(java.lang.Object obj) {
        this.mEndToStart = obj;
    }

    public void startToEnd(java.lang.Object obj) {
        this.mStartToEnd = obj;
    }

    public void startToStart(java.lang.Object obj) {
        this.mStartToStart = obj;
    }
}
