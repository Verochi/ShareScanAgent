package androidx.constraintlayout.solver.widgets;

/* loaded from: classes.dex */
public class ChainHead {
    private boolean mDefined;
    protected androidx.constraintlayout.solver.widgets.ConstraintWidget mFirst;
    protected androidx.constraintlayout.solver.widgets.ConstraintWidget mFirstMatchConstraintWidget;
    protected androidx.constraintlayout.solver.widgets.ConstraintWidget mFirstVisibleWidget;
    protected boolean mHasComplexMatchWeights;
    protected boolean mHasDefinedWeights;
    protected boolean mHasRatio;
    protected boolean mHasUndefinedWeights;
    protected androidx.constraintlayout.solver.widgets.ConstraintWidget mHead;
    private boolean mIsRtl;
    protected androidx.constraintlayout.solver.widgets.ConstraintWidget mLast;
    protected androidx.constraintlayout.solver.widgets.ConstraintWidget mLastMatchConstraintWidget;
    protected androidx.constraintlayout.solver.widgets.ConstraintWidget mLastVisibleWidget;
    boolean mOptimizable;
    private int mOrientation;
    int mTotalMargins;
    int mTotalSize;
    protected float mTotalWeight = 0.0f;
    int mVisibleWidgets;
    protected java.util.ArrayList<androidx.constraintlayout.solver.widgets.ConstraintWidget> mWeightedMatchConstraintsWidgets;
    protected int mWidgetsCount;
    protected int mWidgetsMatchCount;

    public ChainHead(androidx.constraintlayout.solver.widgets.ConstraintWidget constraintWidget, int i, boolean z) {
        this.mFirst = constraintWidget;
        this.mOrientation = i;
        this.mIsRtl = z;
    }

    private void defineChainProperties() {
        int i = this.mOrientation * 2;
        androidx.constraintlayout.solver.widgets.ConstraintWidget constraintWidget = this.mFirst;
        this.mOptimizable = true;
        androidx.constraintlayout.solver.widgets.ConstraintWidget constraintWidget2 = constraintWidget;
        boolean z = false;
        while (!z) {
            this.mWidgetsCount++;
            androidx.constraintlayout.solver.widgets.ConstraintWidget[] constraintWidgetArr = constraintWidget.mNextChainWidget;
            int i2 = this.mOrientation;
            androidx.constraintlayout.solver.widgets.ConstraintWidget constraintWidget3 = null;
            constraintWidgetArr[i2] = null;
            constraintWidget.mListNextMatchConstraintsWidget[i2] = null;
            if (constraintWidget.getVisibility() != 8) {
                this.mVisibleWidgets++;
                androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour dimensionBehaviour = constraintWidget.getDimensionBehaviour(this.mOrientation);
                androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
                if (dimensionBehaviour != dimensionBehaviour2) {
                    this.mTotalSize += constraintWidget.getLength(this.mOrientation);
                }
                int margin = this.mTotalSize + constraintWidget.mListAnchors[i].getMargin();
                this.mTotalSize = margin;
                int i3 = i + 1;
                this.mTotalSize = margin + constraintWidget.mListAnchors[i3].getMargin();
                int margin2 = this.mTotalMargins + constraintWidget.mListAnchors[i].getMargin();
                this.mTotalMargins = margin2;
                this.mTotalMargins = margin2 + constraintWidget.mListAnchors[i3].getMargin();
                if (this.mFirstVisibleWidget == null) {
                    this.mFirstVisibleWidget = constraintWidget;
                }
                this.mLastVisibleWidget = constraintWidget;
                androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour[] dimensionBehaviourArr = constraintWidget.mListDimensionBehaviors;
                int i4 = this.mOrientation;
                if (dimensionBehaviourArr[i4] == dimensionBehaviour2) {
                    int i5 = constraintWidget.mResolvedMatchConstraintDefault[i4];
                    if (i5 == 0 || i5 == 3 || i5 == 2) {
                        this.mWidgetsMatchCount++;
                        float f = constraintWidget.mWeight[i4];
                        if (f > 0.0f) {
                            this.mTotalWeight += f;
                        }
                        if (isMatchConstraintEqualityCandidate(constraintWidget, i4)) {
                            if (f < 0.0f) {
                                this.mHasUndefinedWeights = true;
                            } else {
                                this.mHasDefinedWeights = true;
                            }
                            if (this.mWeightedMatchConstraintsWidgets == null) {
                                this.mWeightedMatchConstraintsWidgets = new java.util.ArrayList<>();
                            }
                            this.mWeightedMatchConstraintsWidgets.add(constraintWidget);
                        }
                        if (this.mFirstMatchConstraintWidget == null) {
                            this.mFirstMatchConstraintWidget = constraintWidget;
                        }
                        androidx.constraintlayout.solver.widgets.ConstraintWidget constraintWidget4 = this.mLastMatchConstraintWidget;
                        if (constraintWidget4 != null) {
                            constraintWidget4.mListNextMatchConstraintsWidget[this.mOrientation] = constraintWidget;
                        }
                        this.mLastMatchConstraintWidget = constraintWidget;
                    }
                    if (this.mOrientation == 0) {
                        if (constraintWidget.mMatchConstraintDefaultWidth != 0) {
                            this.mOptimizable = false;
                        } else if (constraintWidget.mMatchConstraintMinWidth != 0 || constraintWidget.mMatchConstraintMaxWidth != 0) {
                            this.mOptimizable = false;
                        }
                    } else if (constraintWidget.mMatchConstraintDefaultHeight != 0) {
                        this.mOptimizable = false;
                    } else if (constraintWidget.mMatchConstraintMinHeight != 0 || constraintWidget.mMatchConstraintMaxHeight != 0) {
                        this.mOptimizable = false;
                    }
                    if (constraintWidget.mDimensionRatio != 0.0f) {
                        this.mOptimizable = false;
                        this.mHasRatio = true;
                    }
                }
            }
            if (constraintWidget2 != constraintWidget) {
                constraintWidget2.mNextChainWidget[this.mOrientation] = constraintWidget;
            }
            androidx.constraintlayout.solver.widgets.ConstraintAnchor constraintAnchor = constraintWidget.mListAnchors[i + 1].mTarget;
            if (constraintAnchor != null) {
                androidx.constraintlayout.solver.widgets.ConstraintWidget constraintWidget5 = constraintAnchor.mOwner;
                androidx.constraintlayout.solver.widgets.ConstraintAnchor constraintAnchor2 = constraintWidget5.mListAnchors[i].mTarget;
                if (constraintAnchor2 != null && constraintAnchor2.mOwner == constraintWidget) {
                    constraintWidget3 = constraintWidget5;
                }
            }
            if (constraintWidget3 == null) {
                constraintWidget3 = constraintWidget;
                z = true;
            }
            constraintWidget2 = constraintWidget;
            constraintWidget = constraintWidget3;
        }
        androidx.constraintlayout.solver.widgets.ConstraintWidget constraintWidget6 = this.mFirstVisibleWidget;
        if (constraintWidget6 != null) {
            this.mTotalSize -= constraintWidget6.mListAnchors[i].getMargin();
        }
        androidx.constraintlayout.solver.widgets.ConstraintWidget constraintWidget7 = this.mLastVisibleWidget;
        if (constraintWidget7 != null) {
            this.mTotalSize -= constraintWidget7.mListAnchors[i + 1].getMargin();
        }
        this.mLast = constraintWidget;
        if (this.mOrientation == 0 && this.mIsRtl) {
            this.mHead = constraintWidget;
        } else {
            this.mHead = this.mFirst;
        }
        this.mHasComplexMatchWeights = this.mHasDefinedWeights && this.mHasUndefinedWeights;
    }

    private static boolean isMatchConstraintEqualityCandidate(androidx.constraintlayout.solver.widgets.ConstraintWidget constraintWidget, int i) {
        int i2;
        return constraintWidget.getVisibility() != 8 && constraintWidget.mListDimensionBehaviors[i] == androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && ((i2 = constraintWidget.mResolvedMatchConstraintDefault[i]) == 0 || i2 == 3);
    }

    public void define() {
        if (!this.mDefined) {
            defineChainProperties();
        }
        this.mDefined = true;
    }

    public androidx.constraintlayout.solver.widgets.ConstraintWidget getFirst() {
        return this.mFirst;
    }

    public androidx.constraintlayout.solver.widgets.ConstraintWidget getFirstMatchConstraintWidget() {
        return this.mFirstMatchConstraintWidget;
    }

    public androidx.constraintlayout.solver.widgets.ConstraintWidget getFirstVisibleWidget() {
        return this.mFirstVisibleWidget;
    }

    public androidx.constraintlayout.solver.widgets.ConstraintWidget getHead() {
        return this.mHead;
    }

    public androidx.constraintlayout.solver.widgets.ConstraintWidget getLast() {
        return this.mLast;
    }

    public androidx.constraintlayout.solver.widgets.ConstraintWidget getLastMatchConstraintWidget() {
        return this.mLastMatchConstraintWidget;
    }

    public androidx.constraintlayout.solver.widgets.ConstraintWidget getLastVisibleWidget() {
        return this.mLastVisibleWidget;
    }

    public float getTotalWeight() {
        return this.mTotalWeight;
    }
}
