package androidx.constraintlayout.solver.widgets;

/* loaded from: classes.dex */
public class Flow extends androidx.constraintlayout.solver.widgets.VirtualLayout {
    public static final int HORIZONTAL_ALIGN_CENTER = 2;
    public static final int HORIZONTAL_ALIGN_END = 1;
    public static final int HORIZONTAL_ALIGN_START = 0;
    public static final int VERTICAL_ALIGN_BASELINE = 3;
    public static final int VERTICAL_ALIGN_BOTTOM = 1;
    public static final int VERTICAL_ALIGN_CENTER = 2;
    public static final int VERTICAL_ALIGN_TOP = 0;
    public static final int WRAP_ALIGNED = 2;
    public static final int WRAP_CHAIN = 1;
    public static final int WRAP_NONE = 0;
    private androidx.constraintlayout.solver.widgets.ConstraintWidget[] mDisplayedWidgets;
    private int mHorizontalStyle = -1;
    private int mVerticalStyle = -1;
    private int mFirstHorizontalStyle = -1;
    private int mFirstVerticalStyle = -1;
    private int mLastHorizontalStyle = -1;
    private int mLastVerticalStyle = -1;
    private float mHorizontalBias = 0.5f;
    private float mVerticalBias = 0.5f;
    private float mFirstHorizontalBias = 0.5f;
    private float mFirstVerticalBias = 0.5f;
    private float mLastHorizontalBias = 0.5f;
    private float mLastVerticalBias = 0.5f;
    private int mHorizontalGap = 0;
    private int mVerticalGap = 0;
    private int mHorizontalAlign = 2;
    private int mVerticalAlign = 2;
    private int mWrapMode = 0;
    private int mMaxElementsWrap = -1;
    private int mOrientation = 0;
    private java.util.ArrayList<androidx.constraintlayout.solver.widgets.Flow.WidgetsList> mChainList = new java.util.ArrayList<>();
    private androidx.constraintlayout.solver.widgets.ConstraintWidget[] mAlignedBiggestElementsInRows = null;
    private androidx.constraintlayout.solver.widgets.ConstraintWidget[] mAlignedBiggestElementsInCols = null;
    private int[] mAlignedDimensions = null;
    private int mDisplayedWidgetsCount = 0;

    public class WidgetsList {
        private androidx.constraintlayout.solver.widgets.ConstraintAnchor mBottom;
        private androidx.constraintlayout.solver.widgets.ConstraintAnchor mLeft;
        private int mMax;
        private int mOrientation;
        private int mPaddingBottom;
        private int mPaddingLeft;
        private int mPaddingRight;
        private int mPaddingTop;
        private androidx.constraintlayout.solver.widgets.ConstraintAnchor mRight;
        private androidx.constraintlayout.solver.widgets.ConstraintAnchor mTop;
        private androidx.constraintlayout.solver.widgets.ConstraintWidget biggest = null;
        int biggestDimension = 0;
        private int mWidth = 0;
        private int mHeight = 0;
        private int mStartIndex = 0;
        private int mCount = 0;
        private int mNbMatchConstraintsWidgets = 0;

        public WidgetsList(int i, androidx.constraintlayout.solver.widgets.ConstraintAnchor constraintAnchor, androidx.constraintlayout.solver.widgets.ConstraintAnchor constraintAnchor2, androidx.constraintlayout.solver.widgets.ConstraintAnchor constraintAnchor3, androidx.constraintlayout.solver.widgets.ConstraintAnchor constraintAnchor4, int i2) {
            this.mPaddingLeft = 0;
            this.mPaddingTop = 0;
            this.mPaddingRight = 0;
            this.mPaddingBottom = 0;
            this.mMax = 0;
            this.mOrientation = i;
            this.mLeft = constraintAnchor;
            this.mTop = constraintAnchor2;
            this.mRight = constraintAnchor3;
            this.mBottom = constraintAnchor4;
            this.mPaddingLeft = androidx.constraintlayout.solver.widgets.Flow.this.getPaddingLeft();
            this.mPaddingTop = androidx.constraintlayout.solver.widgets.Flow.this.getPaddingTop();
            this.mPaddingRight = androidx.constraintlayout.solver.widgets.Flow.this.getPaddingRight();
            this.mPaddingBottom = androidx.constraintlayout.solver.widgets.Flow.this.getPaddingBottom();
            this.mMax = i2;
        }

        private void recomputeDimensions() {
            this.mWidth = 0;
            this.mHeight = 0;
            this.biggest = null;
            this.biggestDimension = 0;
            int i = this.mCount;
            for (int i2 = 0; i2 < i && this.mStartIndex + i2 < androidx.constraintlayout.solver.widgets.Flow.this.mDisplayedWidgetsCount; i2++) {
                androidx.constraintlayout.solver.widgets.ConstraintWidget constraintWidget = androidx.constraintlayout.solver.widgets.Flow.this.mDisplayedWidgets[this.mStartIndex + i2];
                if (this.mOrientation == 0) {
                    int width = constraintWidget.getWidth();
                    int i3 = androidx.constraintlayout.solver.widgets.Flow.this.mHorizontalGap;
                    if (constraintWidget.getVisibility() == 8) {
                        i3 = 0;
                    }
                    this.mWidth += width + i3;
                    int widgetHeight = androidx.constraintlayout.solver.widgets.Flow.this.getWidgetHeight(constraintWidget, this.mMax);
                    if (this.biggest == null || this.biggestDimension < widgetHeight) {
                        this.biggest = constraintWidget;
                        this.biggestDimension = widgetHeight;
                        this.mHeight = widgetHeight;
                    }
                } else {
                    int widgetWidth = androidx.constraintlayout.solver.widgets.Flow.this.getWidgetWidth(constraintWidget, this.mMax);
                    int widgetHeight2 = androidx.constraintlayout.solver.widgets.Flow.this.getWidgetHeight(constraintWidget, this.mMax);
                    int i4 = androidx.constraintlayout.solver.widgets.Flow.this.mVerticalGap;
                    if (constraintWidget.getVisibility() == 8) {
                        i4 = 0;
                    }
                    this.mHeight += widgetHeight2 + i4;
                    if (this.biggest == null || this.biggestDimension < widgetWidth) {
                        this.biggest = constraintWidget;
                        this.biggestDimension = widgetWidth;
                        this.mWidth = widgetWidth;
                    }
                }
            }
        }

        public void add(androidx.constraintlayout.solver.widgets.ConstraintWidget constraintWidget) {
            if (this.mOrientation == 0) {
                int widgetWidth = androidx.constraintlayout.solver.widgets.Flow.this.getWidgetWidth(constraintWidget, this.mMax);
                if (constraintWidget.getHorizontalDimensionBehaviour() == androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                    this.mNbMatchConstraintsWidgets++;
                    widgetWidth = 0;
                }
                this.mWidth += widgetWidth + (constraintWidget.getVisibility() != 8 ? androidx.constraintlayout.solver.widgets.Flow.this.mHorizontalGap : 0);
                int widgetHeight = androidx.constraintlayout.solver.widgets.Flow.this.getWidgetHeight(constraintWidget, this.mMax);
                if (this.biggest == null || this.biggestDimension < widgetHeight) {
                    this.biggest = constraintWidget;
                    this.biggestDimension = widgetHeight;
                    this.mHeight = widgetHeight;
                }
            } else {
                int widgetWidth2 = androidx.constraintlayout.solver.widgets.Flow.this.getWidgetWidth(constraintWidget, this.mMax);
                int widgetHeight2 = androidx.constraintlayout.solver.widgets.Flow.this.getWidgetHeight(constraintWidget, this.mMax);
                if (constraintWidget.getVerticalDimensionBehaviour() == androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                    this.mNbMatchConstraintsWidgets++;
                    widgetHeight2 = 0;
                }
                this.mHeight += widgetHeight2 + (constraintWidget.getVisibility() != 8 ? androidx.constraintlayout.solver.widgets.Flow.this.mVerticalGap : 0);
                if (this.biggest == null || this.biggestDimension < widgetWidth2) {
                    this.biggest = constraintWidget;
                    this.biggestDimension = widgetWidth2;
                    this.mWidth = widgetWidth2;
                }
            }
            this.mCount++;
        }

        public void clear() {
            this.biggestDimension = 0;
            this.biggest = null;
            this.mWidth = 0;
            this.mHeight = 0;
            this.mStartIndex = 0;
            this.mCount = 0;
            this.mNbMatchConstraintsWidgets = 0;
        }

        public void createConstraints(boolean z, int i, boolean z2) {
            androidx.constraintlayout.solver.widgets.ConstraintWidget constraintWidget;
            int i2 = this.mCount;
            for (int i3 = 0; i3 < i2 && this.mStartIndex + i3 < androidx.constraintlayout.solver.widgets.Flow.this.mDisplayedWidgetsCount; i3++) {
                androidx.constraintlayout.solver.widgets.ConstraintWidget constraintWidget2 = androidx.constraintlayout.solver.widgets.Flow.this.mDisplayedWidgets[this.mStartIndex + i3];
                if (constraintWidget2 != null) {
                    constraintWidget2.resetAnchors();
                }
            }
            if (i2 == 0 || this.biggest == null) {
                return;
            }
            boolean z3 = z2 && i == 0;
            int i4 = -1;
            int i5 = -1;
            for (int i6 = 0; i6 < i2; i6++) {
                int i7 = z ? (i2 - 1) - i6 : i6;
                if (this.mStartIndex + i7 >= androidx.constraintlayout.solver.widgets.Flow.this.mDisplayedWidgetsCount) {
                    break;
                }
                if (androidx.constraintlayout.solver.widgets.Flow.this.mDisplayedWidgets[this.mStartIndex + i7].getVisibility() == 0) {
                    if (i4 == -1) {
                        i4 = i6;
                    }
                    i5 = i6;
                }
            }
            androidx.constraintlayout.solver.widgets.ConstraintWidget constraintWidget3 = null;
            if (this.mOrientation != 0) {
                androidx.constraintlayout.solver.widgets.ConstraintWidget constraintWidget4 = this.biggest;
                constraintWidget4.setHorizontalChainStyle(androidx.constraintlayout.solver.widgets.Flow.this.mHorizontalStyle);
                int i8 = this.mPaddingLeft;
                if (i > 0) {
                    i8 += androidx.constraintlayout.solver.widgets.Flow.this.mHorizontalGap;
                }
                if (z) {
                    constraintWidget4.mRight.connect(this.mRight, i8);
                    if (z2) {
                        constraintWidget4.mLeft.connect(this.mLeft, this.mPaddingRight);
                    }
                    if (i > 0) {
                        this.mRight.mOwner.mLeft.connect(constraintWidget4.mRight, 0);
                    }
                } else {
                    constraintWidget4.mLeft.connect(this.mLeft, i8);
                    if (z2) {
                        constraintWidget4.mRight.connect(this.mRight, this.mPaddingRight);
                    }
                    if (i > 0) {
                        this.mLeft.mOwner.mRight.connect(constraintWidget4.mLeft, 0);
                    }
                }
                int i9 = 0;
                while (i9 < i2 && this.mStartIndex + i9 < androidx.constraintlayout.solver.widgets.Flow.this.mDisplayedWidgetsCount) {
                    androidx.constraintlayout.solver.widgets.ConstraintWidget constraintWidget5 = androidx.constraintlayout.solver.widgets.Flow.this.mDisplayedWidgets[this.mStartIndex + i9];
                    if (i9 == 0) {
                        constraintWidget5.connect(constraintWidget5.mTop, this.mTop, this.mPaddingTop);
                        int i10 = androidx.constraintlayout.solver.widgets.Flow.this.mVerticalStyle;
                        float f = androidx.constraintlayout.solver.widgets.Flow.this.mVerticalBias;
                        if (this.mStartIndex == 0 && androidx.constraintlayout.solver.widgets.Flow.this.mFirstVerticalStyle != -1) {
                            i10 = androidx.constraintlayout.solver.widgets.Flow.this.mFirstVerticalStyle;
                            f = androidx.constraintlayout.solver.widgets.Flow.this.mFirstVerticalBias;
                        } else if (z2 && androidx.constraintlayout.solver.widgets.Flow.this.mLastVerticalStyle != -1) {
                            i10 = androidx.constraintlayout.solver.widgets.Flow.this.mLastVerticalStyle;
                            f = androidx.constraintlayout.solver.widgets.Flow.this.mLastVerticalBias;
                        }
                        constraintWidget5.setVerticalChainStyle(i10);
                        constraintWidget5.setVerticalBiasPercent(f);
                    }
                    if (i9 == i2 - 1) {
                        constraintWidget5.connect(constraintWidget5.mBottom, this.mBottom, this.mPaddingBottom);
                    }
                    if (constraintWidget3 != null) {
                        constraintWidget5.mTop.connect(constraintWidget3.mBottom, androidx.constraintlayout.solver.widgets.Flow.this.mVerticalGap);
                        if (i9 == i4) {
                            constraintWidget5.mTop.setGoneMargin(this.mPaddingTop);
                        }
                        constraintWidget3.mBottom.connect(constraintWidget5.mTop, 0);
                        if (i9 == i5 + 1) {
                            constraintWidget3.mBottom.setGoneMargin(this.mPaddingBottom);
                        }
                    }
                    if (constraintWidget5 != constraintWidget4) {
                        if (z) {
                            int i11 = androidx.constraintlayout.solver.widgets.Flow.this.mHorizontalAlign;
                            if (i11 == 0) {
                                constraintWidget5.mRight.connect(constraintWidget4.mRight, 0);
                            } else if (i11 == 1) {
                                constraintWidget5.mLeft.connect(constraintWidget4.mLeft, 0);
                            } else if (i11 == 2) {
                                constraintWidget5.mLeft.connect(constraintWidget4.mLeft, 0);
                                constraintWidget5.mRight.connect(constraintWidget4.mRight, 0);
                            }
                        } else {
                            int i12 = androidx.constraintlayout.solver.widgets.Flow.this.mHorizontalAlign;
                            if (i12 == 0) {
                                constraintWidget5.mLeft.connect(constraintWidget4.mLeft, 0);
                            } else if (i12 == 1) {
                                constraintWidget5.mRight.connect(constraintWidget4.mRight, 0);
                            } else if (i12 == 2) {
                                if (z3) {
                                    constraintWidget5.mLeft.connect(this.mLeft, this.mPaddingLeft);
                                    constraintWidget5.mRight.connect(this.mRight, this.mPaddingRight);
                                } else {
                                    constraintWidget5.mLeft.connect(constraintWidget4.mLeft, 0);
                                    constraintWidget5.mRight.connect(constraintWidget4.mRight, 0);
                                }
                            }
                            i9++;
                            constraintWidget3 = constraintWidget5;
                        }
                    }
                    i9++;
                    constraintWidget3 = constraintWidget5;
                }
                return;
            }
            androidx.constraintlayout.solver.widgets.ConstraintWidget constraintWidget6 = this.biggest;
            constraintWidget6.setVerticalChainStyle(androidx.constraintlayout.solver.widgets.Flow.this.mVerticalStyle);
            int i13 = this.mPaddingTop;
            if (i > 0) {
                i13 += androidx.constraintlayout.solver.widgets.Flow.this.mVerticalGap;
            }
            constraintWidget6.mTop.connect(this.mTop, i13);
            if (z2) {
                constraintWidget6.mBottom.connect(this.mBottom, this.mPaddingBottom);
            }
            if (i > 0) {
                this.mTop.mOwner.mBottom.connect(constraintWidget6.mTop, 0);
            }
            if (androidx.constraintlayout.solver.widgets.Flow.this.mVerticalAlign == 3 && !constraintWidget6.hasBaseline()) {
                for (int i14 = 0; i14 < i2; i14++) {
                    int i15 = z ? (i2 - 1) - i14 : i14;
                    if (this.mStartIndex + i15 >= androidx.constraintlayout.solver.widgets.Flow.this.mDisplayedWidgetsCount) {
                        break;
                    }
                    constraintWidget = androidx.constraintlayout.solver.widgets.Flow.this.mDisplayedWidgets[this.mStartIndex + i15];
                    if (constraintWidget.hasBaseline()) {
                        break;
                    }
                }
            }
            constraintWidget = constraintWidget6;
            int i16 = 0;
            while (i16 < i2) {
                int i17 = z ? (i2 - 1) - i16 : i16;
                if (this.mStartIndex + i17 >= androidx.constraintlayout.solver.widgets.Flow.this.mDisplayedWidgetsCount) {
                    return;
                }
                androidx.constraintlayout.solver.widgets.ConstraintWidget constraintWidget7 = androidx.constraintlayout.solver.widgets.Flow.this.mDisplayedWidgets[this.mStartIndex + i17];
                if (i16 == 0) {
                    constraintWidget7.connect(constraintWidget7.mLeft, this.mLeft, this.mPaddingLeft);
                }
                if (i17 == 0) {
                    int i18 = androidx.constraintlayout.solver.widgets.Flow.this.mHorizontalStyle;
                    float f2 = androidx.constraintlayout.solver.widgets.Flow.this.mHorizontalBias;
                    if (this.mStartIndex == 0 && androidx.constraintlayout.solver.widgets.Flow.this.mFirstHorizontalStyle != -1) {
                        i18 = androidx.constraintlayout.solver.widgets.Flow.this.mFirstHorizontalStyle;
                        f2 = androidx.constraintlayout.solver.widgets.Flow.this.mFirstHorizontalBias;
                    } else if (z2 && androidx.constraintlayout.solver.widgets.Flow.this.mLastHorizontalStyle != -1) {
                        i18 = androidx.constraintlayout.solver.widgets.Flow.this.mLastHorizontalStyle;
                        f2 = androidx.constraintlayout.solver.widgets.Flow.this.mLastHorizontalBias;
                    }
                    constraintWidget7.setHorizontalChainStyle(i18);
                    constraintWidget7.setHorizontalBiasPercent(f2);
                }
                if (i16 == i2 - 1) {
                    constraintWidget7.connect(constraintWidget7.mRight, this.mRight, this.mPaddingRight);
                }
                if (constraintWidget3 != null) {
                    constraintWidget7.mLeft.connect(constraintWidget3.mRight, androidx.constraintlayout.solver.widgets.Flow.this.mHorizontalGap);
                    if (i16 == i4) {
                        constraintWidget7.mLeft.setGoneMargin(this.mPaddingLeft);
                    }
                    constraintWidget3.mRight.connect(constraintWidget7.mLeft, 0);
                    if (i16 == i5 + 1) {
                        constraintWidget3.mRight.setGoneMargin(this.mPaddingRight);
                    }
                }
                if (constraintWidget7 != constraintWidget6) {
                    if (androidx.constraintlayout.solver.widgets.Flow.this.mVerticalAlign == 3 && constraintWidget.hasBaseline() && constraintWidget7 != constraintWidget && constraintWidget7.hasBaseline()) {
                        constraintWidget7.mBaseline.connect(constraintWidget.mBaseline, 0);
                    } else {
                        int i19 = androidx.constraintlayout.solver.widgets.Flow.this.mVerticalAlign;
                        if (i19 == 0) {
                            constraintWidget7.mTop.connect(constraintWidget6.mTop, 0);
                        } else if (i19 == 1) {
                            constraintWidget7.mBottom.connect(constraintWidget6.mBottom, 0);
                        } else if (z3) {
                            constraintWidget7.mTop.connect(this.mTop, this.mPaddingTop);
                            constraintWidget7.mBottom.connect(this.mBottom, this.mPaddingBottom);
                        } else {
                            constraintWidget7.mTop.connect(constraintWidget6.mTop, 0);
                            constraintWidget7.mBottom.connect(constraintWidget6.mBottom, 0);
                        }
                    }
                }
                i16++;
                constraintWidget3 = constraintWidget7;
            }
        }

        public int getHeight() {
            return this.mOrientation == 1 ? this.mHeight - androidx.constraintlayout.solver.widgets.Flow.this.mVerticalGap : this.mHeight;
        }

        public int getWidth() {
            return this.mOrientation == 0 ? this.mWidth - androidx.constraintlayout.solver.widgets.Flow.this.mHorizontalGap : this.mWidth;
        }

        public void measureMatchConstraints(int i) {
            int i2 = this.mNbMatchConstraintsWidgets;
            if (i2 == 0) {
                return;
            }
            int i3 = this.mCount;
            int i4 = i / i2;
            for (int i5 = 0; i5 < i3 && this.mStartIndex + i5 < androidx.constraintlayout.solver.widgets.Flow.this.mDisplayedWidgetsCount; i5++) {
                androidx.constraintlayout.solver.widgets.ConstraintWidget constraintWidget = androidx.constraintlayout.solver.widgets.Flow.this.mDisplayedWidgets[this.mStartIndex + i5];
                if (this.mOrientation == 0) {
                    if (constraintWidget != null && constraintWidget.getHorizontalDimensionBehaviour() == androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && constraintWidget.mMatchConstraintDefaultWidth == 0) {
                        androidx.constraintlayout.solver.widgets.Flow.this.measure(constraintWidget, androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.FIXED, i4, constraintWidget.getVerticalDimensionBehaviour(), constraintWidget.getHeight());
                    }
                } else if (constraintWidget != null && constraintWidget.getVerticalDimensionBehaviour() == androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && constraintWidget.mMatchConstraintDefaultHeight == 0) {
                    androidx.constraintlayout.solver.widgets.Flow.this.measure(constraintWidget, constraintWidget.getHorizontalDimensionBehaviour(), constraintWidget.getWidth(), androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.FIXED, i4);
                }
            }
            recomputeDimensions();
        }

        public void setStartIndex(int i) {
            this.mStartIndex = i;
        }

        public void setup(int i, androidx.constraintlayout.solver.widgets.ConstraintAnchor constraintAnchor, androidx.constraintlayout.solver.widgets.ConstraintAnchor constraintAnchor2, androidx.constraintlayout.solver.widgets.ConstraintAnchor constraintAnchor3, androidx.constraintlayout.solver.widgets.ConstraintAnchor constraintAnchor4, int i2, int i3, int i4, int i5, int i6) {
            this.mOrientation = i;
            this.mLeft = constraintAnchor;
            this.mTop = constraintAnchor2;
            this.mRight = constraintAnchor3;
            this.mBottom = constraintAnchor4;
            this.mPaddingLeft = i2;
            this.mPaddingTop = i3;
            this.mPaddingRight = i4;
            this.mPaddingBottom = i5;
            this.mMax = i6;
        }
    }

    private void createAlignedConstraints(boolean z) {
        androidx.constraintlayout.solver.widgets.ConstraintWidget constraintWidget;
        if (this.mAlignedDimensions == null || this.mAlignedBiggestElementsInCols == null || this.mAlignedBiggestElementsInRows == null) {
            return;
        }
        for (int i = 0; i < this.mDisplayedWidgetsCount; i++) {
            this.mDisplayedWidgets[i].resetAnchors();
        }
        int[] iArr = this.mAlignedDimensions;
        int i2 = iArr[0];
        int i3 = iArr[1];
        androidx.constraintlayout.solver.widgets.ConstraintWidget constraintWidget2 = null;
        for (int i4 = 0; i4 < i2; i4++) {
            androidx.constraintlayout.solver.widgets.ConstraintWidget constraintWidget3 = this.mAlignedBiggestElementsInCols[z ? (i2 - i4) - 1 : i4];
            if (constraintWidget3 != null && constraintWidget3.getVisibility() != 8) {
                if (i4 == 0) {
                    constraintWidget3.connect(constraintWidget3.mLeft, this.mLeft, getPaddingLeft());
                    constraintWidget3.setHorizontalChainStyle(this.mHorizontalStyle);
                    constraintWidget3.setHorizontalBiasPercent(this.mHorizontalBias);
                }
                if (i4 == i2 - 1) {
                    constraintWidget3.connect(constraintWidget3.mRight, this.mRight, getPaddingRight());
                }
                if (i4 > 0) {
                    constraintWidget3.connect(constraintWidget3.mLeft, constraintWidget2.mRight, this.mHorizontalGap);
                    constraintWidget2.connect(constraintWidget2.mRight, constraintWidget3.mLeft, 0);
                }
                constraintWidget2 = constraintWidget3;
            }
        }
        for (int i5 = 0; i5 < i3; i5++) {
            androidx.constraintlayout.solver.widgets.ConstraintWidget constraintWidget4 = this.mAlignedBiggestElementsInRows[i5];
            if (constraintWidget4 != null && constraintWidget4.getVisibility() != 8) {
                if (i5 == 0) {
                    constraintWidget4.connect(constraintWidget4.mTop, this.mTop, getPaddingTop());
                    constraintWidget4.setVerticalChainStyle(this.mVerticalStyle);
                    constraintWidget4.setVerticalBiasPercent(this.mVerticalBias);
                }
                if (i5 == i3 - 1) {
                    constraintWidget4.connect(constraintWidget4.mBottom, this.mBottom, getPaddingBottom());
                }
                if (i5 > 0) {
                    constraintWidget4.connect(constraintWidget4.mTop, constraintWidget2.mBottom, this.mVerticalGap);
                    constraintWidget2.connect(constraintWidget2.mBottom, constraintWidget4.mTop, 0);
                }
                constraintWidget2 = constraintWidget4;
            }
        }
        for (int i6 = 0; i6 < i2; i6++) {
            for (int i7 = 0; i7 < i3; i7++) {
                int i8 = (i7 * i2) + i6;
                if (this.mOrientation == 1) {
                    i8 = (i6 * i3) + i7;
                }
                androidx.constraintlayout.solver.widgets.ConstraintWidget[] constraintWidgetArr = this.mDisplayedWidgets;
                if (i8 < constraintWidgetArr.length && (constraintWidget = constraintWidgetArr[i8]) != null && constraintWidget.getVisibility() != 8) {
                    androidx.constraintlayout.solver.widgets.ConstraintWidget constraintWidget5 = this.mAlignedBiggestElementsInCols[i6];
                    androidx.constraintlayout.solver.widgets.ConstraintWidget constraintWidget6 = this.mAlignedBiggestElementsInRows[i7];
                    if (constraintWidget != constraintWidget5) {
                        constraintWidget.connect(constraintWidget.mLeft, constraintWidget5.mLeft, 0);
                        constraintWidget.connect(constraintWidget.mRight, constraintWidget5.mRight, 0);
                    }
                    if (constraintWidget != constraintWidget6) {
                        constraintWidget.connect(constraintWidget.mTop, constraintWidget6.mTop, 0);
                        constraintWidget.connect(constraintWidget.mBottom, constraintWidget6.mBottom, 0);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int getWidgetHeight(androidx.constraintlayout.solver.widgets.ConstraintWidget constraintWidget, int i) {
        if (constraintWidget == null) {
            return 0;
        }
        if (constraintWidget.getVerticalDimensionBehaviour() == androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
            int i2 = constraintWidget.mMatchConstraintDefaultHeight;
            if (i2 == 0) {
                return 0;
            }
            if (i2 == 2) {
                int i3 = (int) (constraintWidget.mMatchConstraintPercentHeight * i);
                if (i3 != constraintWidget.getHeight()) {
                    constraintWidget.setMeasureRequested(true);
                    measure(constraintWidget, constraintWidget.getHorizontalDimensionBehaviour(), constraintWidget.getWidth(), androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.FIXED, i3);
                }
                return i3;
            }
            if (i2 == 1) {
                return constraintWidget.getHeight();
            }
            if (i2 == 3) {
                return (int) ((constraintWidget.getWidth() * constraintWidget.mDimensionRatio) + 0.5f);
            }
        }
        return constraintWidget.getHeight();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int getWidgetWidth(androidx.constraintlayout.solver.widgets.ConstraintWidget constraintWidget, int i) {
        if (constraintWidget == null) {
            return 0;
        }
        if (constraintWidget.getHorizontalDimensionBehaviour() == androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
            int i2 = constraintWidget.mMatchConstraintDefaultWidth;
            if (i2 == 0) {
                return 0;
            }
            if (i2 == 2) {
                int i3 = (int) (constraintWidget.mMatchConstraintPercentWidth * i);
                if (i3 != constraintWidget.getWidth()) {
                    constraintWidget.setMeasureRequested(true);
                    measure(constraintWidget, androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.FIXED, i3, constraintWidget.getVerticalDimensionBehaviour(), constraintWidget.getHeight());
                }
                return i3;
            }
            if (i2 == 1) {
                return constraintWidget.getWidth();
            }
            if (i2 == 3) {
                return (int) ((constraintWidget.getHeight() * constraintWidget.mDimensionRatio) + 0.5f);
            }
        }
        return constraintWidget.getWidth();
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x005e  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:77:0x010d -> B:22:0x0059). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:78:0x010f -> B:22:0x0059). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:80:0x0115 -> B:22:0x0059). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:81:0x0117 -> B:22:0x0059). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void measureAligned(androidx.constraintlayout.solver.widgets.ConstraintWidget[] constraintWidgetArr, int i, int i2, int i3, int[] iArr) {
        int i4;
        int i5;
        boolean z;
        androidx.constraintlayout.solver.widgets.ConstraintWidget constraintWidget;
        if (i2 == 0) {
            int i6 = this.mMaxElementsWrap;
            if (i6 <= 0) {
                i6 = 0;
                int i7 = 0;
                for (int i8 = 0; i8 < i; i8++) {
                    if (i8 > 0) {
                        i7 += this.mHorizontalGap;
                    }
                    androidx.constraintlayout.solver.widgets.ConstraintWidget constraintWidget2 = constraintWidgetArr[i8];
                    if (constraintWidget2 != null) {
                        i7 += getWidgetWidth(constraintWidget2, i3);
                        if (i7 > i3) {
                            break;
                        } else {
                            i6++;
                        }
                    }
                }
            }
            i5 = i6;
            i4 = 0;
        } else {
            i4 = this.mMaxElementsWrap;
            if (i4 <= 0) {
                i4 = 0;
                int i9 = 0;
                for (int i10 = 0; i10 < i; i10++) {
                    if (i10 > 0) {
                        i9 += this.mVerticalGap;
                    }
                    androidx.constraintlayout.solver.widgets.ConstraintWidget constraintWidget3 = constraintWidgetArr[i10];
                    if (constraintWidget3 != null) {
                        i9 += getWidgetHeight(constraintWidget3, i3);
                        if (i9 > i3) {
                            break;
                        } else {
                            i4++;
                        }
                    }
                }
            }
            i5 = 0;
        }
        if (this.mAlignedDimensions == null) {
            this.mAlignedDimensions = new int[2];
        }
        if ((i4 != 0 || i2 != 1) && (i5 != 0 || i2 != 0)) {
            z = false;
            while (!z) {
                if (i2 == 0) {
                    i4 = (int) java.lang.Math.ceil(i / i5);
                } else {
                    i5 = (int) java.lang.Math.ceil(i / i4);
                }
                androidx.constraintlayout.solver.widgets.ConstraintWidget[] constraintWidgetArr2 = this.mAlignedBiggestElementsInCols;
                if (constraintWidgetArr2 == null || constraintWidgetArr2.length < i5) {
                    this.mAlignedBiggestElementsInCols = new androidx.constraintlayout.solver.widgets.ConstraintWidget[i5];
                } else {
                    java.util.Arrays.fill(constraintWidgetArr2, (java.lang.Object) null);
                }
                androidx.constraintlayout.solver.widgets.ConstraintWidget[] constraintWidgetArr3 = this.mAlignedBiggestElementsInRows;
                if (constraintWidgetArr3 == null || constraintWidgetArr3.length < i4) {
                    this.mAlignedBiggestElementsInRows = new androidx.constraintlayout.solver.widgets.ConstraintWidget[i4];
                } else {
                    java.util.Arrays.fill(constraintWidgetArr3, (java.lang.Object) null);
                }
                for (int i11 = 0; i11 < i5; i11++) {
                    for (int i12 = 0; i12 < i4; i12++) {
                        int i13 = (i12 * i5) + i11;
                        if (i2 == 1) {
                            i13 = (i11 * i4) + i12;
                        }
                        if (i13 < constraintWidgetArr.length && (constraintWidget = constraintWidgetArr[i13]) != null) {
                            int widgetWidth = getWidgetWidth(constraintWidget, i3);
                            androidx.constraintlayout.solver.widgets.ConstraintWidget constraintWidget4 = this.mAlignedBiggestElementsInCols[i11];
                            if (constraintWidget4 == null || constraintWidget4.getWidth() < widgetWidth) {
                                this.mAlignedBiggestElementsInCols[i11] = constraintWidget;
                            }
                            int widgetHeight = getWidgetHeight(constraintWidget, i3);
                            androidx.constraintlayout.solver.widgets.ConstraintWidget constraintWidget5 = this.mAlignedBiggestElementsInRows[i12];
                            if (constraintWidget5 == null || constraintWidget5.getHeight() < widgetHeight) {
                                this.mAlignedBiggestElementsInRows[i12] = constraintWidget;
                            }
                        }
                    }
                }
                int i14 = 0;
                for (int i15 = 0; i15 < i5; i15++) {
                    androidx.constraintlayout.solver.widgets.ConstraintWidget constraintWidget6 = this.mAlignedBiggestElementsInCols[i15];
                    if (constraintWidget6 != null) {
                        if (i15 > 0) {
                            i14 += this.mHorizontalGap;
                        }
                        i14 += getWidgetWidth(constraintWidget6, i3);
                    }
                }
                int i16 = 0;
                for (int i17 = 0; i17 < i4; i17++) {
                    androidx.constraintlayout.solver.widgets.ConstraintWidget constraintWidget7 = this.mAlignedBiggestElementsInRows[i17];
                    if (constraintWidget7 != null) {
                        if (i17 > 0) {
                            i16 += this.mVerticalGap;
                        }
                        i16 += getWidgetHeight(constraintWidget7, i3);
                    }
                }
                iArr[0] = i14;
                iArr[1] = i16;
                if (i2 != 0) {
                    if (i16 > i3 && i4 > 1) {
                        i4--;
                    }
                } else if (i14 > i3 && i5 > 1) {
                    i5--;
                }
                while (!z) {
                }
            }
            int[] iArr2 = this.mAlignedDimensions;
            iArr2[0] = i5;
            iArr2[1] = i4;
        }
        z = true;
        while (!z) {
        }
        int[] iArr22 = this.mAlignedDimensions;
        iArr22[0] = i5;
        iArr22[1] = i4;
    }

    private void measureChainWrap(androidx.constraintlayout.solver.widgets.ConstraintWidget[] constraintWidgetArr, int i, int i2, int i3, int[] iArr) {
        int i4;
        int i5;
        int i6;
        androidx.constraintlayout.solver.widgets.ConstraintAnchor constraintAnchor;
        int paddingRight;
        androidx.constraintlayout.solver.widgets.ConstraintAnchor constraintAnchor2;
        int paddingBottom;
        int i7;
        if (i == 0) {
            return;
        }
        this.mChainList.clear();
        androidx.constraintlayout.solver.widgets.Flow.WidgetsList widgetsList = new androidx.constraintlayout.solver.widgets.Flow.WidgetsList(i2, this.mLeft, this.mTop, this.mRight, this.mBottom, i3);
        this.mChainList.add(widgetsList);
        if (i2 == 0) {
            i4 = 0;
            int i8 = 0;
            int i9 = 0;
            while (i9 < i) {
                androidx.constraintlayout.solver.widgets.ConstraintWidget constraintWidget = constraintWidgetArr[i9];
                int widgetWidth = getWidgetWidth(constraintWidget, i3);
                if (constraintWidget.getHorizontalDimensionBehaviour() == androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                    i4++;
                }
                int i10 = i4;
                boolean z = (i8 == i3 || (this.mHorizontalGap + i8) + widgetWidth > i3) && widgetsList.biggest != null;
                if (!z && i9 > 0 && (i7 = this.mMaxElementsWrap) > 0 && i9 % i7 == 0) {
                    z = true;
                }
                if (z) {
                    widgetsList = new androidx.constraintlayout.solver.widgets.Flow.WidgetsList(i2, this.mLeft, this.mTop, this.mRight, this.mBottom, i3);
                    widgetsList.setStartIndex(i9);
                    this.mChainList.add(widgetsList);
                } else if (i9 > 0) {
                    i8 += this.mHorizontalGap + widgetWidth;
                    widgetsList.add(constraintWidget);
                    i9++;
                    i4 = i10;
                }
                i8 = widgetWidth;
                widgetsList.add(constraintWidget);
                i9++;
                i4 = i10;
            }
        } else {
            i4 = 0;
            int i11 = 0;
            int i12 = 0;
            while (i12 < i) {
                androidx.constraintlayout.solver.widgets.ConstraintWidget constraintWidget2 = constraintWidgetArr[i12];
                int widgetHeight = getWidgetHeight(constraintWidget2, i3);
                if (constraintWidget2.getVerticalDimensionBehaviour() == androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                    i4++;
                }
                int i13 = i4;
                boolean z2 = (i11 == i3 || (this.mVerticalGap + i11) + widgetHeight > i3) && widgetsList.biggest != null;
                if (!z2 && i12 > 0 && (i5 = this.mMaxElementsWrap) > 0 && i12 % i5 == 0) {
                    z2 = true;
                }
                if (z2) {
                    widgetsList = new androidx.constraintlayout.solver.widgets.Flow.WidgetsList(i2, this.mLeft, this.mTop, this.mRight, this.mBottom, i3);
                    widgetsList.setStartIndex(i12);
                    this.mChainList.add(widgetsList);
                } else if (i12 > 0) {
                    i11 += this.mVerticalGap + widgetHeight;
                    widgetsList.add(constraintWidget2);
                    i12++;
                    i4 = i13;
                }
                i11 = widgetHeight;
                widgetsList.add(constraintWidget2);
                i12++;
                i4 = i13;
            }
        }
        int size = this.mChainList.size();
        androidx.constraintlayout.solver.widgets.ConstraintAnchor constraintAnchor3 = this.mLeft;
        androidx.constraintlayout.solver.widgets.ConstraintAnchor constraintAnchor4 = this.mTop;
        androidx.constraintlayout.solver.widgets.ConstraintAnchor constraintAnchor5 = this.mRight;
        androidx.constraintlayout.solver.widgets.ConstraintAnchor constraintAnchor6 = this.mBottom;
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight2 = getPaddingRight();
        int paddingBottom2 = getPaddingBottom();
        androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour horizontalDimensionBehaviour = getHorizontalDimensionBehaviour();
        androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour dimensionBehaviour = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        boolean z3 = horizontalDimensionBehaviour == dimensionBehaviour || getVerticalDimensionBehaviour() == dimensionBehaviour;
        if (i4 > 0 && z3) {
            for (int i14 = 0; i14 < size; i14++) {
                androidx.constraintlayout.solver.widgets.Flow.WidgetsList widgetsList2 = this.mChainList.get(i14);
                if (i2 == 0) {
                    widgetsList2.measureMatchConstraints(i3 - widgetsList2.getWidth());
                } else {
                    widgetsList2.measureMatchConstraints(i3 - widgetsList2.getHeight());
                }
            }
        }
        int i15 = paddingTop;
        int i16 = paddingRight2;
        int i17 = 0;
        int i18 = 0;
        int i19 = 0;
        int i20 = paddingLeft;
        androidx.constraintlayout.solver.widgets.ConstraintAnchor constraintAnchor7 = constraintAnchor4;
        androidx.constraintlayout.solver.widgets.ConstraintAnchor constraintAnchor8 = constraintAnchor3;
        int i21 = paddingBottom2;
        while (i19 < size) {
            androidx.constraintlayout.solver.widgets.Flow.WidgetsList widgetsList3 = this.mChainList.get(i19);
            if (i2 == 0) {
                if (i19 < size - 1) {
                    constraintAnchor2 = this.mChainList.get(i19 + 1).biggest.mTop;
                    paddingBottom = 0;
                } else {
                    constraintAnchor2 = this.mBottom;
                    paddingBottom = getPaddingBottom();
                }
                androidx.constraintlayout.solver.widgets.ConstraintAnchor constraintAnchor9 = widgetsList3.biggest.mBottom;
                androidx.constraintlayout.solver.widgets.ConstraintAnchor constraintAnchor10 = constraintAnchor8;
                androidx.constraintlayout.solver.widgets.ConstraintAnchor constraintAnchor11 = constraintAnchor8;
                int i22 = i17;
                androidx.constraintlayout.solver.widgets.ConstraintAnchor constraintAnchor12 = constraintAnchor7;
                int i23 = i18;
                androidx.constraintlayout.solver.widgets.ConstraintAnchor constraintAnchor13 = constraintAnchor5;
                androidx.constraintlayout.solver.widgets.ConstraintAnchor constraintAnchor14 = constraintAnchor5;
                i6 = i19;
                widgetsList3.setup(i2, constraintAnchor10, constraintAnchor12, constraintAnchor13, constraintAnchor2, i20, i15, i16, paddingBottom, i3);
                int max = java.lang.Math.max(i23, widgetsList3.getWidth());
                i17 = i22 + widgetsList3.getHeight();
                if (i6 > 0) {
                    i17 += this.mVerticalGap;
                }
                constraintAnchor8 = constraintAnchor11;
                i18 = max;
                constraintAnchor7 = constraintAnchor9;
                i15 = 0;
                constraintAnchor = constraintAnchor14;
                int i24 = paddingBottom;
                constraintAnchor6 = constraintAnchor2;
                i21 = i24;
            } else {
                androidx.constraintlayout.solver.widgets.ConstraintAnchor constraintAnchor15 = constraintAnchor8;
                int i25 = i17;
                int i26 = i18;
                i6 = i19;
                if (i6 < size - 1) {
                    constraintAnchor = this.mChainList.get(i6 + 1).biggest.mLeft;
                    paddingRight = 0;
                } else {
                    constraintAnchor = this.mRight;
                    paddingRight = getPaddingRight();
                }
                androidx.constraintlayout.solver.widgets.ConstraintAnchor constraintAnchor16 = widgetsList3.biggest.mRight;
                widgetsList3.setup(i2, constraintAnchor15, constraintAnchor7, constraintAnchor, constraintAnchor6, i20, i15, paddingRight, i21, i3);
                i18 = i26 + widgetsList3.getWidth();
                int max2 = java.lang.Math.max(i25, widgetsList3.getHeight());
                if (i6 > 0) {
                    i18 += this.mHorizontalGap;
                }
                i17 = max2;
                i16 = paddingRight;
                constraintAnchor8 = constraintAnchor16;
                i20 = 0;
            }
            i19 = i6 + 1;
            constraintAnchor5 = constraintAnchor;
        }
        iArr[0] = i18;
        iArr[1] = i17;
    }

    private void measureNoWrap(androidx.constraintlayout.solver.widgets.ConstraintWidget[] constraintWidgetArr, int i, int i2, int i3, int[] iArr) {
        androidx.constraintlayout.solver.widgets.Flow.WidgetsList widgetsList;
        if (i == 0) {
            return;
        }
        if (this.mChainList.size() == 0) {
            widgetsList = new androidx.constraintlayout.solver.widgets.Flow.WidgetsList(i2, this.mLeft, this.mTop, this.mRight, this.mBottom, i3);
            this.mChainList.add(widgetsList);
        } else {
            androidx.constraintlayout.solver.widgets.Flow.WidgetsList widgetsList2 = this.mChainList.get(0);
            widgetsList2.clear();
            widgetsList = widgetsList2;
            widgetsList.setup(i2, this.mLeft, this.mTop, this.mRight, this.mBottom, getPaddingLeft(), getPaddingTop(), getPaddingRight(), getPaddingBottom(), i3);
        }
        for (int i4 = 0; i4 < i; i4++) {
            widgetsList.add(constraintWidgetArr[i4]);
        }
        iArr[0] = widgetsList.getWidth();
        iArr[1] = widgetsList.getHeight();
    }

    @Override // androidx.constraintlayout.solver.widgets.ConstraintWidget
    public void addToSolver(androidx.constraintlayout.solver.LinearSystem linearSystem, boolean z) {
        super.addToSolver(linearSystem, z);
        boolean isRtl = getParent() != null ? ((androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer) getParent()).isRtl() : false;
        int i = this.mWrapMode;
        if (i != 0) {
            if (i == 1) {
                int size = this.mChainList.size();
                int i2 = 0;
                while (i2 < size) {
                    this.mChainList.get(i2).createConstraints(isRtl, i2, i2 == size + (-1));
                    i2++;
                }
            } else if (i == 2) {
                createAlignedConstraints(isRtl);
            }
        } else if (this.mChainList.size() > 0) {
            this.mChainList.get(0).createConstraints(isRtl, 0, true);
        }
        needsCallbackFromSolver(false);
    }

    @Override // androidx.constraintlayout.solver.widgets.HelperWidget, androidx.constraintlayout.solver.widgets.ConstraintWidget
    public void copy(androidx.constraintlayout.solver.widgets.ConstraintWidget constraintWidget, java.util.HashMap<androidx.constraintlayout.solver.widgets.ConstraintWidget, androidx.constraintlayout.solver.widgets.ConstraintWidget> hashMap) {
        super.copy(constraintWidget, hashMap);
        androidx.constraintlayout.solver.widgets.Flow flow = (androidx.constraintlayout.solver.widgets.Flow) constraintWidget;
        this.mHorizontalStyle = flow.mHorizontalStyle;
        this.mVerticalStyle = flow.mVerticalStyle;
        this.mFirstHorizontalStyle = flow.mFirstHorizontalStyle;
        this.mFirstVerticalStyle = flow.mFirstVerticalStyle;
        this.mLastHorizontalStyle = flow.mLastHorizontalStyle;
        this.mLastVerticalStyle = flow.mLastVerticalStyle;
        this.mHorizontalBias = flow.mHorizontalBias;
        this.mVerticalBias = flow.mVerticalBias;
        this.mFirstHorizontalBias = flow.mFirstHorizontalBias;
        this.mFirstVerticalBias = flow.mFirstVerticalBias;
        this.mLastHorizontalBias = flow.mLastHorizontalBias;
        this.mLastVerticalBias = flow.mLastVerticalBias;
        this.mHorizontalGap = flow.mHorizontalGap;
        this.mVerticalGap = flow.mVerticalGap;
        this.mHorizontalAlign = flow.mHorizontalAlign;
        this.mVerticalAlign = flow.mVerticalAlign;
        this.mWrapMode = flow.mWrapMode;
        this.mMaxElementsWrap = flow.mMaxElementsWrap;
        this.mOrientation = flow.mOrientation;
    }

    /* JADX WARN: Removed duplicated region for block: B:50:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00e9  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0104  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00eb  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00dc  */
    @Override // androidx.constraintlayout.solver.widgets.VirtualLayout
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void measure(int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        int[] iArr;
        boolean z;
        char c;
        if (this.mWidgetsCount > 0 && !measureChildren()) {
            setMeasure(0, 0);
            needsCallbackFromSolver(false);
            return;
        }
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int[] iArr2 = new int[2];
        int i7 = (i2 - paddingLeft) - paddingRight;
        int i8 = this.mOrientation;
        if (i8 == 1) {
            i7 = (i4 - paddingTop) - paddingBottom;
        }
        int i9 = i7;
        if (i8 == 0) {
            if (this.mHorizontalStyle == -1) {
                this.mHorizontalStyle = 0;
            }
            if (this.mVerticalStyle == -1) {
                this.mVerticalStyle = 0;
            }
        } else {
            if (this.mHorizontalStyle == -1) {
                this.mHorizontalStyle = 0;
            }
            if (this.mVerticalStyle == -1) {
                this.mVerticalStyle = 0;
            }
        }
        androidx.constraintlayout.solver.widgets.ConstraintWidget[] constraintWidgetArr = this.mWidgets;
        int i10 = 0;
        int i11 = 0;
        while (true) {
            i5 = this.mWidgetsCount;
            if (i10 >= i5) {
                break;
            }
            if (this.mWidgets[i10].getVisibility() == 8) {
                i11++;
            }
            i10++;
        }
        if (i11 > 0) {
            constraintWidgetArr = new androidx.constraintlayout.solver.widgets.ConstraintWidget[i5 - i11];
            int i12 = 0;
            for (int i13 = 0; i13 < this.mWidgetsCount; i13++) {
                androidx.constraintlayout.solver.widgets.ConstraintWidget constraintWidget = this.mWidgets[i13];
                if (constraintWidget.getVisibility() != 8) {
                    constraintWidgetArr[i12] = constraintWidget;
                    i12++;
                }
            }
            i6 = i12;
        } else {
            i6 = i5;
        }
        this.mDisplayedWidgets = constraintWidgetArr;
        this.mDisplayedWidgetsCount = i6;
        int i14 = this.mWrapMode;
        if (i14 == 0) {
            iArr = iArr2;
            z = true;
            measureNoWrap(constraintWidgetArr, i6, this.mOrientation, i9, iArr2);
        } else if (i14 == 1) {
            iArr = iArr2;
            z = true;
            measureChainWrap(constraintWidgetArr, i6, this.mOrientation, i9, iArr2);
        } else {
            if (i14 != 2) {
                iArr = iArr2;
                c = 0;
                z = true;
                int i15 = iArr[c] + paddingLeft + paddingRight;
                int i16 = iArr[z ? 1 : 0] + paddingTop + paddingBottom;
                if (i != 1073741824) {
                    i15 = i2;
                } else if (i == Integer.MIN_VALUE) {
                    i15 = java.lang.Math.min(i15, i2);
                } else if (i != 0) {
                    i15 = 0;
                }
                if (i3 != 1073741824) {
                    i16 = i4;
                } else if (i3 == Integer.MIN_VALUE) {
                    i16 = java.lang.Math.min(i16, i4);
                } else if (i3 != 0) {
                    i16 = 0;
                }
                setMeasure(i15, i16);
                setWidth(i15);
                setHeight(i16);
                if (this.mWidgetsCount <= 0) {
                    z = false;
                }
                needsCallbackFromSolver(z);
            }
            z = true;
            iArr = iArr2;
            measureAligned(constraintWidgetArr, i6, this.mOrientation, i9, iArr2);
        }
        c = 0;
        int i152 = iArr[c] + paddingLeft + paddingRight;
        int i162 = iArr[z ? 1 : 0] + paddingTop + paddingBottom;
        if (i != 1073741824) {
        }
        if (i3 != 1073741824) {
        }
        setMeasure(i152, i162);
        setWidth(i152);
        setHeight(i162);
        if (this.mWidgetsCount <= 0) {
        }
        needsCallbackFromSolver(z);
    }

    public void setFirstHorizontalBias(float f) {
        this.mFirstHorizontalBias = f;
    }

    public void setFirstHorizontalStyle(int i) {
        this.mFirstHorizontalStyle = i;
    }

    public void setFirstVerticalBias(float f) {
        this.mFirstVerticalBias = f;
    }

    public void setFirstVerticalStyle(int i) {
        this.mFirstVerticalStyle = i;
    }

    public void setHorizontalAlign(int i) {
        this.mHorizontalAlign = i;
    }

    public void setHorizontalBias(float f) {
        this.mHorizontalBias = f;
    }

    public void setHorizontalGap(int i) {
        this.mHorizontalGap = i;
    }

    public void setHorizontalStyle(int i) {
        this.mHorizontalStyle = i;
    }

    public void setLastHorizontalBias(float f) {
        this.mLastHorizontalBias = f;
    }

    public void setLastHorizontalStyle(int i) {
        this.mLastHorizontalStyle = i;
    }

    public void setLastVerticalBias(float f) {
        this.mLastVerticalBias = f;
    }

    public void setLastVerticalStyle(int i) {
        this.mLastVerticalStyle = i;
    }

    public void setMaxElementsWrap(int i) {
        this.mMaxElementsWrap = i;
    }

    public void setOrientation(int i) {
        this.mOrientation = i;
    }

    public void setVerticalAlign(int i) {
        this.mVerticalAlign = i;
    }

    public void setVerticalBias(float f) {
        this.mVerticalBias = f;
    }

    public void setVerticalGap(int i) {
        this.mVerticalGap = i;
    }

    public void setVerticalStyle(int i) {
        this.mVerticalStyle = i;
    }

    public void setWrapMode(int i) {
        this.mWrapMode = i;
    }
}
