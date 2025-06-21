package androidx.constraintlayout.solver.state.helpers;

/* loaded from: classes.dex */
public class BarrierReference extends androidx.constraintlayout.solver.state.HelperReference {
    private androidx.constraintlayout.solver.widgets.Barrier mBarrierWidget;
    private androidx.constraintlayout.solver.state.State.Direction mDirection;
    private int mMargin;

    /* renamed from: androidx.constraintlayout.solver.state.helpers.BarrierReference$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$androidx$constraintlayout$solver$state$State$Direction;

        static {
            int[] iArr = new int[androidx.constraintlayout.solver.state.State.Direction.values().length];
            $SwitchMap$androidx$constraintlayout$solver$state$State$Direction = iArr;
            try {
                iArr[androidx.constraintlayout.solver.state.State.Direction.LEFT.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$solver$state$State$Direction[androidx.constraintlayout.solver.state.State.Direction.START.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$solver$state$State$Direction[androidx.constraintlayout.solver.state.State.Direction.RIGHT.ordinal()] = 3;
            } catch (java.lang.NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$solver$state$State$Direction[androidx.constraintlayout.solver.state.State.Direction.END.ordinal()] = 4;
            } catch (java.lang.NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$solver$state$State$Direction[androidx.constraintlayout.solver.state.State.Direction.TOP.ordinal()] = 5;
            } catch (java.lang.NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$solver$state$State$Direction[androidx.constraintlayout.solver.state.State.Direction.BOTTOM.ordinal()] = 6;
            } catch (java.lang.NoSuchFieldError unused6) {
            }
        }
    }

    public BarrierReference(androidx.constraintlayout.solver.state.State state) {
        super(state, androidx.constraintlayout.solver.state.State.Helper.BARRIER);
    }

    @Override // androidx.constraintlayout.solver.state.HelperReference
    public void apply() {
        getHelperWidget();
        int i = 0;
        switch (androidx.constraintlayout.solver.state.helpers.BarrierReference.AnonymousClass1.$SwitchMap$androidx$constraintlayout$solver$state$State$Direction[this.mDirection.ordinal()]) {
            case 3:
            case 4:
                i = 1;
                break;
            case 5:
                i = 2;
                break;
            case 6:
                i = 3;
                break;
        }
        this.mBarrierWidget.setBarrierType(i);
        this.mBarrierWidget.setMargin(this.mMargin);
    }

    @Override // androidx.constraintlayout.solver.state.HelperReference
    public androidx.constraintlayout.solver.widgets.HelperWidget getHelperWidget() {
        if (this.mBarrierWidget == null) {
            this.mBarrierWidget = new androidx.constraintlayout.solver.widgets.Barrier();
        }
        return this.mBarrierWidget;
    }

    public void margin(int i) {
        this.mMargin = i;
    }

    public void margin(java.lang.Object obj) {
        margin(this.mState.convertDimension(obj));
    }

    public void setBarrierDirection(androidx.constraintlayout.solver.state.State.Direction direction) {
        this.mDirection = direction;
    }
}
