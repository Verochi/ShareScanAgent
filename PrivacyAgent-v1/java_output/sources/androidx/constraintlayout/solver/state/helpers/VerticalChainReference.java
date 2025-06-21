package androidx.constraintlayout.solver.state.helpers;

/* loaded from: classes.dex */
public class VerticalChainReference extends androidx.constraintlayout.solver.state.helpers.ChainReference {
    private java.lang.Object mBottomToBottom;
    private java.lang.Object mBottomToTop;
    private java.lang.Object mTopToBottom;
    private java.lang.Object mTopToTop;

    /* renamed from: androidx.constraintlayout.solver.state.helpers.VerticalChainReference$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$androidx$constraintlayout$solver$state$State$Chain;

        static {
            int[] iArr = new int[androidx.constraintlayout.solver.state.State.Chain.values().length];
            $SwitchMap$androidx$constraintlayout$solver$state$State$Chain = iArr;
            try {
                iArr[androidx.constraintlayout.solver.state.State.Chain.SPREAD.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$solver$state$State$Chain[androidx.constraintlayout.solver.state.State.Chain.SPREAD_INSIDE.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$solver$state$State$Chain[androidx.constraintlayout.solver.state.State.Chain.PACKED.ordinal()] = 3;
            } catch (java.lang.NoSuchFieldError unused3) {
            }
        }
    }

    public VerticalChainReference(androidx.constraintlayout.solver.state.State state) {
        super(state, androidx.constraintlayout.solver.state.State.Helper.VERTICAL_CHAIN);
    }

    @Override // androidx.constraintlayout.solver.state.HelperReference
    public void apply() {
        java.util.Iterator<java.lang.Object> it = this.mReferences.iterator();
        while (it.hasNext()) {
            this.mState.constraints(it.next()).clearVertical();
        }
        java.util.Iterator<java.lang.Object> it2 = this.mReferences.iterator();
        androidx.constraintlayout.solver.state.ConstraintReference constraintReference = null;
        androidx.constraintlayout.solver.state.ConstraintReference constraintReference2 = null;
        while (it2.hasNext()) {
            androidx.constraintlayout.solver.state.ConstraintReference constraints = this.mState.constraints(it2.next());
            if (constraintReference2 == null) {
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
                constraintReference2 = constraints;
            }
            if (constraintReference != null) {
                constraintReference.bottomToTop(constraints.getKey());
                constraints.topToBottom(constraintReference.getKey());
            }
            constraintReference = constraints;
        }
        if (constraintReference != null) {
            java.lang.Object obj3 = this.mBottomToTop;
            if (obj3 != null) {
                constraintReference.bottomToTop(obj3);
            } else {
                java.lang.Object obj4 = this.mBottomToBottom;
                if (obj4 != null) {
                    constraintReference.bottomToBottom(obj4);
                } else {
                    constraintReference.bottomToBottom(androidx.constraintlayout.solver.state.State.PARENT);
                }
            }
        }
        if (constraintReference2 != null) {
            float f = this.mBias;
            if (f != 0.5f) {
                constraintReference2.verticalBias(f);
            }
        }
        int i = androidx.constraintlayout.solver.state.helpers.VerticalChainReference.AnonymousClass1.$SwitchMap$androidx$constraintlayout$solver$state$State$Chain[this.mStyle.ordinal()];
        if (i == 1) {
            constraintReference2.setVerticalChainStyle(0);
        } else if (i == 2) {
            constraintReference2.setVerticalChainStyle(1);
        } else {
            if (i != 3) {
                return;
            }
            constraintReference2.setVerticalChainStyle(2);
        }
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
