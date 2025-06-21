package androidx.constraintlayout.solver.state.helpers;

/* loaded from: classes.dex */
public class HorizontalChainReference extends androidx.constraintlayout.solver.state.helpers.ChainReference {
    private java.lang.Object mEndToEnd;
    private java.lang.Object mEndToStart;
    private java.lang.Object mStartToEnd;
    private java.lang.Object mStartToStart;

    /* renamed from: androidx.constraintlayout.solver.state.helpers.HorizontalChainReference$1, reason: invalid class name */
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

    public HorizontalChainReference(androidx.constraintlayout.solver.state.State state) {
        super(state, androidx.constraintlayout.solver.state.State.Helper.HORIZONTAL_CHAIN);
    }

    @Override // androidx.constraintlayout.solver.state.HelperReference
    public void apply() {
        java.util.Iterator<java.lang.Object> it = this.mReferences.iterator();
        while (it.hasNext()) {
            this.mState.constraints(it.next()).clearHorizontal();
        }
        java.util.Iterator<java.lang.Object> it2 = this.mReferences.iterator();
        androidx.constraintlayout.solver.state.ConstraintReference constraintReference = null;
        androidx.constraintlayout.solver.state.ConstraintReference constraintReference2 = null;
        while (it2.hasNext()) {
            androidx.constraintlayout.solver.state.ConstraintReference constraints = this.mState.constraints(it2.next());
            if (constraintReference2 == null) {
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
                constraintReference2 = constraints;
            }
            if (constraintReference != null) {
                constraintReference.endToStart(constraints.getKey());
                constraints.startToEnd(constraintReference.getKey());
            }
            constraintReference = constraints;
        }
        if (constraintReference != null) {
            java.lang.Object obj3 = this.mEndToStart;
            if (obj3 != null) {
                constraintReference.endToStart(obj3);
            } else {
                java.lang.Object obj4 = this.mEndToEnd;
                if (obj4 != null) {
                    constraintReference.endToEnd(obj4);
                } else {
                    constraintReference.endToEnd(androidx.constraintlayout.solver.state.State.PARENT);
                }
            }
        }
        if (constraintReference2 != null) {
            float f = this.mBias;
            if (f != 0.5f) {
                constraintReference2.horizontalBias(f);
            }
        }
        int i = androidx.constraintlayout.solver.state.helpers.HorizontalChainReference.AnonymousClass1.$SwitchMap$androidx$constraintlayout$solver$state$State$Chain[this.mStyle.ordinal()];
        if (i == 1) {
            constraintReference2.setHorizontalChainStyle(0);
        } else if (i == 2) {
            constraintReference2.setHorizontalChainStyle(1);
        } else {
            if (i != 3) {
                return;
            }
            constraintReference2.setHorizontalChainStyle(2);
        }
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
