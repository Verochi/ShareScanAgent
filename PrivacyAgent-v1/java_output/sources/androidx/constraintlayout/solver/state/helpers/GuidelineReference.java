package androidx.constraintlayout.solver.state.helpers;

/* loaded from: classes.dex */
public class GuidelineReference implements androidx.constraintlayout.solver.state.Reference {
    private java.lang.Object key;
    private androidx.constraintlayout.solver.widgets.Guideline mGuidelineWidget;
    private int mOrientation;
    final androidx.constraintlayout.solver.state.State mState;
    private int mStart = -1;
    private int mEnd = -1;
    private float mPercent = 0.0f;

    public GuidelineReference(androidx.constraintlayout.solver.state.State state) {
        this.mState = state;
    }

    @Override // androidx.constraintlayout.solver.state.Reference
    public void apply() {
        this.mGuidelineWidget.setOrientation(this.mOrientation);
        int i = this.mStart;
        if (i != -1) {
            this.mGuidelineWidget.setGuideBegin(i);
            return;
        }
        int i2 = this.mEnd;
        if (i2 != -1) {
            this.mGuidelineWidget.setGuideEnd(i2);
        } else {
            this.mGuidelineWidget.setGuidePercent(this.mPercent);
        }
    }

    public void end(java.lang.Object obj) {
        this.mStart = -1;
        this.mEnd = this.mState.convertDimension(obj);
        this.mPercent = 0.0f;
    }

    @Override // androidx.constraintlayout.solver.state.Reference
    public androidx.constraintlayout.solver.widgets.ConstraintWidget getConstraintWidget() {
        if (this.mGuidelineWidget == null) {
            this.mGuidelineWidget = new androidx.constraintlayout.solver.widgets.Guideline();
        }
        return this.mGuidelineWidget;
    }

    @Override // androidx.constraintlayout.solver.state.Reference
    public java.lang.Object getKey() {
        return this.key;
    }

    public int getOrientation() {
        return this.mOrientation;
    }

    public void percent(float f) {
        this.mStart = -1;
        this.mEnd = -1;
        this.mPercent = f;
    }

    @Override // androidx.constraintlayout.solver.state.Reference
    public void setConstraintWidget(androidx.constraintlayout.solver.widgets.ConstraintWidget constraintWidget) {
        if (constraintWidget instanceof androidx.constraintlayout.solver.widgets.Guideline) {
            this.mGuidelineWidget = (androidx.constraintlayout.solver.widgets.Guideline) constraintWidget;
        } else {
            this.mGuidelineWidget = null;
        }
    }

    @Override // androidx.constraintlayout.solver.state.Reference
    public void setKey(java.lang.Object obj) {
        this.key = obj;
    }

    public void setOrientation(int i) {
        this.mOrientation = i;
    }

    public void start(java.lang.Object obj) {
        this.mStart = this.mState.convertDimension(obj);
        this.mEnd = -1;
        this.mPercent = 0.0f;
    }
}
