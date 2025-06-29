package androidx.constraintlayout.solver.widgets;

/* loaded from: classes.dex */
public class VirtualLayout extends androidx.constraintlayout.solver.widgets.HelperWidget {
    private int mPaddingTop = 0;
    private int mPaddingBottom = 0;
    private int mPaddingLeft = 0;
    private int mPaddingRight = 0;
    private int mPaddingStart = 0;
    private int mPaddingEnd = 0;
    private int mResolvedPaddingLeft = 0;
    private int mResolvedPaddingRight = 0;
    private boolean mNeedsCallFromSolver = false;
    private int mMeasuredWidth = 0;
    private int mMeasuredHeight = 0;
    protected androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure.Measure mMeasure = new androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure.Measure();
    androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure.Measurer mMeasurer = null;

    public void applyRtl(boolean z) {
        int i = this.mPaddingStart;
        if (i > 0 || this.mPaddingEnd > 0) {
            if (z) {
                this.mResolvedPaddingLeft = this.mPaddingEnd;
                this.mResolvedPaddingRight = i;
            } else {
                this.mResolvedPaddingLeft = i;
                this.mResolvedPaddingRight = this.mPaddingEnd;
            }
        }
    }

    public void captureWidgets() {
        for (int i = 0; i < this.mWidgetsCount; i++) {
            androidx.constraintlayout.solver.widgets.ConstraintWidget constraintWidget = this.mWidgets[i];
            if (constraintWidget != null) {
                constraintWidget.setInVirtualLayout(true);
            }
        }
    }

    public int getMeasuredHeight() {
        return this.mMeasuredHeight;
    }

    public int getMeasuredWidth() {
        return this.mMeasuredWidth;
    }

    public int getPaddingBottom() {
        return this.mPaddingBottom;
    }

    public int getPaddingLeft() {
        return this.mResolvedPaddingLeft;
    }

    public int getPaddingRight() {
        return this.mResolvedPaddingRight;
    }

    public int getPaddingTop() {
        return this.mPaddingTop;
    }

    public void measure(int i, int i2, int i3, int i4) {
    }

    public void measure(androidx.constraintlayout.solver.widgets.ConstraintWidget constraintWidget, androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour dimensionBehaviour, int i, androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour dimensionBehaviour2, int i2) {
        while (this.mMeasurer == null && getParent() != null) {
            this.mMeasurer = ((androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer) getParent()).getMeasurer();
        }
        androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure.Measure measure = this.mMeasure;
        measure.horizontalBehavior = dimensionBehaviour;
        measure.verticalBehavior = dimensionBehaviour2;
        measure.horizontalDimension = i;
        measure.verticalDimension = i2;
        this.mMeasurer.measure(constraintWidget, measure);
        constraintWidget.setWidth(this.mMeasure.measuredWidth);
        constraintWidget.setHeight(this.mMeasure.measuredHeight);
        constraintWidget.setHasBaseline(this.mMeasure.measuredHasBaseline);
        constraintWidget.setBaselineDistance(this.mMeasure.measuredBaseline);
    }

    public boolean measureChildren() {
        androidx.constraintlayout.solver.widgets.ConstraintWidget constraintWidget = this.mParent;
        androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure.Measurer measurer = constraintWidget != null ? ((androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer) constraintWidget).getMeasurer() : null;
        if (measurer == null) {
            return false;
        }
        int i = 0;
        while (true) {
            if (i >= this.mWidgetsCount) {
                return true;
            }
            androidx.constraintlayout.solver.widgets.ConstraintWidget constraintWidget2 = this.mWidgets[i];
            if (constraintWidget2 != null && !(constraintWidget2 instanceof androidx.constraintlayout.solver.widgets.Guideline)) {
                androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour dimensionBehaviour = constraintWidget2.getDimensionBehaviour(0);
                androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = constraintWidget2.getDimensionBehaviour(1);
                androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour dimensionBehaviour3 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
                if (!(dimensionBehaviour == dimensionBehaviour3 && constraintWidget2.mMatchConstraintDefaultWidth != 1 && dimensionBehaviour2 == dimensionBehaviour3 && constraintWidget2.mMatchConstraintDefaultHeight != 1)) {
                    if (dimensionBehaviour == dimensionBehaviour3) {
                        dimensionBehaviour = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                    }
                    if (dimensionBehaviour2 == dimensionBehaviour3) {
                        dimensionBehaviour2 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                    }
                    androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure.Measure measure = this.mMeasure;
                    measure.horizontalBehavior = dimensionBehaviour;
                    measure.verticalBehavior = dimensionBehaviour2;
                    measure.horizontalDimension = constraintWidget2.getWidth();
                    this.mMeasure.verticalDimension = constraintWidget2.getHeight();
                    measurer.measure(constraintWidget2, this.mMeasure);
                    constraintWidget2.setWidth(this.mMeasure.measuredWidth);
                    constraintWidget2.setHeight(this.mMeasure.measuredHeight);
                    constraintWidget2.setBaselineDistance(this.mMeasure.measuredBaseline);
                }
            }
            i++;
        }
    }

    public boolean needSolverPass() {
        return this.mNeedsCallFromSolver;
    }

    public void needsCallbackFromSolver(boolean z) {
        this.mNeedsCallFromSolver = z;
    }

    public void setMeasure(int i, int i2) {
        this.mMeasuredWidth = i;
        this.mMeasuredHeight = i2;
    }

    public void setPadding(int i) {
        this.mPaddingLeft = i;
        this.mPaddingTop = i;
        this.mPaddingRight = i;
        this.mPaddingBottom = i;
        this.mPaddingStart = i;
        this.mPaddingEnd = i;
    }

    public void setPaddingBottom(int i) {
        this.mPaddingBottom = i;
    }

    public void setPaddingEnd(int i) {
        this.mPaddingEnd = i;
    }

    public void setPaddingLeft(int i) {
        this.mPaddingLeft = i;
        this.mResolvedPaddingLeft = i;
    }

    public void setPaddingRight(int i) {
        this.mPaddingRight = i;
        this.mResolvedPaddingRight = i;
    }

    public void setPaddingStart(int i) {
        this.mPaddingStart = i;
        this.mResolvedPaddingLeft = i;
        this.mResolvedPaddingRight = i;
    }

    public void setPaddingTop(int i) {
        this.mPaddingTop = i;
    }

    @Override // androidx.constraintlayout.solver.widgets.HelperWidget, androidx.constraintlayout.solver.widgets.Helper
    public void updateConstraints(androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer constraintWidgetContainer) {
        captureWidgets();
    }
}
