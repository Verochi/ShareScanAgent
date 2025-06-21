package androidx.constraintlayout.solver.state;

/* loaded from: classes.dex */
public class ConstraintReference implements androidx.constraintlayout.solver.state.Reference {
    private java.lang.Object key;
    private androidx.constraintlayout.solver.widgets.ConstraintWidget mConstraintWidget;
    androidx.constraintlayout.solver.state.Dimension mHorizontalDimension;
    final androidx.constraintlayout.solver.state.State mState;
    androidx.constraintlayout.solver.state.Dimension mVerticalDimension;
    private java.lang.Object mView;
    int mHorizontalChainStyle = 0;
    int mVerticalChainStyle = 0;
    float mHorizontalBias = 0.5f;
    float mVerticalBias = 0.5f;
    int mMarginLeft = 0;
    int mMarginRight = 0;
    int mMarginStart = 0;
    int mMarginEnd = 0;
    int mMarginTop = 0;
    int mMarginBottom = 0;
    int mMarginLeftGone = 0;
    int mMarginRightGone = 0;
    int mMarginStartGone = 0;
    int mMarginEndGone = 0;
    int mMarginTopGone = 0;
    int mMarginBottomGone = 0;
    java.lang.Object mLeftToLeft = null;
    java.lang.Object mLeftToRight = null;
    java.lang.Object mRightToLeft = null;
    java.lang.Object mRightToRight = null;
    java.lang.Object mStartToStart = null;
    java.lang.Object mStartToEnd = null;
    java.lang.Object mEndToStart = null;
    java.lang.Object mEndToEnd = null;
    java.lang.Object mTopToTop = null;
    java.lang.Object mTopToBottom = null;
    java.lang.Object mBottomToTop = null;
    java.lang.Object mBottomToBottom = null;
    java.lang.Object mBaselineToBaseline = null;
    androidx.constraintlayout.solver.state.State.Constraint mLast = null;

    /* renamed from: androidx.constraintlayout.solver.state.ConstraintReference$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$androidx$constraintlayout$solver$state$State$Constraint;

        static {
            int[] iArr = new int[androidx.constraintlayout.solver.state.State.Constraint.values().length];
            $SwitchMap$androidx$constraintlayout$solver$state$State$Constraint = iArr;
            try {
                iArr[androidx.constraintlayout.solver.state.State.Constraint.LEFT_TO_LEFT.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$solver$state$State$Constraint[androidx.constraintlayout.solver.state.State.Constraint.LEFT_TO_RIGHT.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$solver$state$State$Constraint[androidx.constraintlayout.solver.state.State.Constraint.RIGHT_TO_LEFT.ordinal()] = 3;
            } catch (java.lang.NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$solver$state$State$Constraint[androidx.constraintlayout.solver.state.State.Constraint.RIGHT_TO_RIGHT.ordinal()] = 4;
            } catch (java.lang.NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$solver$state$State$Constraint[androidx.constraintlayout.solver.state.State.Constraint.START_TO_START.ordinal()] = 5;
            } catch (java.lang.NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$solver$state$State$Constraint[androidx.constraintlayout.solver.state.State.Constraint.START_TO_END.ordinal()] = 6;
            } catch (java.lang.NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$solver$state$State$Constraint[androidx.constraintlayout.solver.state.State.Constraint.END_TO_START.ordinal()] = 7;
            } catch (java.lang.NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$solver$state$State$Constraint[androidx.constraintlayout.solver.state.State.Constraint.END_TO_END.ordinal()] = 8;
            } catch (java.lang.NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$solver$state$State$Constraint[androidx.constraintlayout.solver.state.State.Constraint.TOP_TO_TOP.ordinal()] = 9;
            } catch (java.lang.NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$solver$state$State$Constraint[androidx.constraintlayout.solver.state.State.Constraint.TOP_TO_BOTTOM.ordinal()] = 10;
            } catch (java.lang.NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$solver$state$State$Constraint[androidx.constraintlayout.solver.state.State.Constraint.BOTTOM_TO_TOP.ordinal()] = 11;
            } catch (java.lang.NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$solver$state$State$Constraint[androidx.constraintlayout.solver.state.State.Constraint.BOTTOM_TO_BOTTOM.ordinal()] = 12;
            } catch (java.lang.NoSuchFieldError unused12) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$solver$state$State$Constraint[androidx.constraintlayout.solver.state.State.Constraint.BASELINE_TO_BASELINE.ordinal()] = 13;
            } catch (java.lang.NoSuchFieldError unused13) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$solver$state$State$Constraint[androidx.constraintlayout.solver.state.State.Constraint.CENTER_HORIZONTALLY.ordinal()] = 14;
            } catch (java.lang.NoSuchFieldError unused14) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$solver$state$State$Constraint[androidx.constraintlayout.solver.state.State.Constraint.CENTER_VERTICALLY.ordinal()] = 15;
            } catch (java.lang.NoSuchFieldError unused15) {
            }
        }
    }

    public interface ConstraintReferenceFactory {
        androidx.constraintlayout.solver.state.ConstraintReference create(androidx.constraintlayout.solver.state.State state);
    }

    public class IncorrectConstraintException extends java.lang.Exception {
        private final java.util.ArrayList<java.lang.String> mErrors;

        public IncorrectConstraintException(java.util.ArrayList<java.lang.String> arrayList) {
            this.mErrors = arrayList;
        }

        public java.util.ArrayList<java.lang.String> getErrors() {
            return this.mErrors;
        }

        @Override // java.lang.Throwable
        public java.lang.String toString() {
            return "IncorrectConstraintException: " + this.mErrors.toString();
        }
    }

    public ConstraintReference(androidx.constraintlayout.solver.state.State state) {
        java.lang.Object obj = androidx.constraintlayout.solver.state.Dimension.WRAP_DIMENSION;
        this.mHorizontalDimension = androidx.constraintlayout.solver.state.Dimension.Fixed(obj);
        this.mVerticalDimension = androidx.constraintlayout.solver.state.Dimension.Fixed(obj);
        this.mState = state;
    }

    private void applyConnection(androidx.constraintlayout.solver.widgets.ConstraintWidget constraintWidget, java.lang.Object obj, androidx.constraintlayout.solver.state.State.Constraint constraint) {
        androidx.constraintlayout.solver.widgets.ConstraintWidget target = getTarget(obj);
        if (target == null) {
        }
        int[] iArr = androidx.constraintlayout.solver.state.ConstraintReference.AnonymousClass1.$SwitchMap$androidx$constraintlayout$solver$state$State$Constraint;
        int i = iArr[constraint.ordinal()];
        switch (iArr[constraint.ordinal()]) {
            case 1:
                androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type type = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.LEFT;
                constraintWidget.getAnchor(type).connect(target.getAnchor(type), this.mMarginLeft, this.mMarginLeftGone, false);
                break;
            case 2:
                constraintWidget.getAnchor(androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.LEFT).connect(target.getAnchor(androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.RIGHT), this.mMarginLeft, this.mMarginLeftGone, false);
                break;
            case 3:
                constraintWidget.getAnchor(androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.RIGHT).connect(target.getAnchor(androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.LEFT), this.mMarginRight, this.mMarginRightGone, false);
                break;
            case 4:
                androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type type2 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.RIGHT;
                constraintWidget.getAnchor(type2).connect(target.getAnchor(type2), this.mMarginRight, this.mMarginRightGone, false);
                break;
            case 5:
                androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type type3 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.LEFT;
                constraintWidget.getAnchor(type3).connect(target.getAnchor(type3), this.mMarginStart, this.mMarginStartGone, false);
                break;
            case 6:
                constraintWidget.getAnchor(androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.LEFT).connect(target.getAnchor(androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.RIGHT), this.mMarginStart, this.mMarginStartGone, false);
                break;
            case 7:
                constraintWidget.getAnchor(androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.RIGHT).connect(target.getAnchor(androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.LEFT), this.mMarginEnd, this.mMarginEndGone, false);
                break;
            case 8:
                androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type type4 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.RIGHT;
                constraintWidget.getAnchor(type4).connect(target.getAnchor(type4), this.mMarginEnd, this.mMarginEndGone, false);
                break;
            case 9:
                androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type type5 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.TOP;
                constraintWidget.getAnchor(type5).connect(target.getAnchor(type5), this.mMarginTop, this.mMarginTopGone, false);
                break;
            case 10:
                constraintWidget.getAnchor(androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.TOP).connect(target.getAnchor(androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.BOTTOM), this.mMarginTop, this.mMarginTopGone, false);
                break;
            case 11:
                constraintWidget.getAnchor(androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.BOTTOM).connect(target.getAnchor(androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.TOP), this.mMarginBottom, this.mMarginBottomGone, false);
                break;
            case 12:
                androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type type6 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.BOTTOM;
                constraintWidget.getAnchor(type6).connect(target.getAnchor(type6), this.mMarginBottom, this.mMarginBottomGone, false);
                break;
            case 13:
                androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type type7 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.BASELINE;
                constraintWidget.immediateConnect(type7, target, type7, 0, 0);
                break;
        }
    }

    private void dereference() {
        this.mLeftToLeft = get(this.mLeftToLeft);
        this.mLeftToRight = get(this.mLeftToRight);
        this.mRightToLeft = get(this.mRightToLeft);
        this.mRightToRight = get(this.mRightToRight);
        this.mStartToStart = get(this.mStartToStart);
        this.mStartToEnd = get(this.mStartToEnd);
        this.mEndToStart = get(this.mEndToStart);
        this.mEndToEnd = get(this.mEndToEnd);
        this.mTopToTop = get(this.mTopToTop);
        this.mTopToBottom = get(this.mTopToBottom);
        this.mBottomToTop = get(this.mBottomToTop);
        this.mBottomToBottom = get(this.mBottomToBottom);
        this.mBaselineToBaseline = get(this.mBaselineToBaseline);
    }

    private java.lang.Object get(java.lang.Object obj) {
        if (obj == null) {
            return null;
        }
        return !(obj instanceof androidx.constraintlayout.solver.state.ConstraintReference) ? this.mState.reference(obj) : obj;
    }

    private androidx.constraintlayout.solver.widgets.ConstraintWidget getTarget(java.lang.Object obj) {
        if (obj instanceof androidx.constraintlayout.solver.state.Reference) {
            return ((androidx.constraintlayout.solver.state.Reference) obj).getConstraintWidget();
        }
        return null;
    }

    @Override // androidx.constraintlayout.solver.state.Reference
    public void apply() {
        androidx.constraintlayout.solver.widgets.ConstraintWidget constraintWidget = this.mConstraintWidget;
        if (constraintWidget == null) {
            return;
        }
        this.mHorizontalDimension.apply(this.mState, constraintWidget, 0);
        this.mVerticalDimension.apply(this.mState, this.mConstraintWidget, 1);
        dereference();
        applyConnection(this.mConstraintWidget, this.mLeftToLeft, androidx.constraintlayout.solver.state.State.Constraint.LEFT_TO_LEFT);
        applyConnection(this.mConstraintWidget, this.mLeftToRight, androidx.constraintlayout.solver.state.State.Constraint.LEFT_TO_RIGHT);
        applyConnection(this.mConstraintWidget, this.mRightToLeft, androidx.constraintlayout.solver.state.State.Constraint.RIGHT_TO_LEFT);
        applyConnection(this.mConstraintWidget, this.mRightToRight, androidx.constraintlayout.solver.state.State.Constraint.RIGHT_TO_RIGHT);
        applyConnection(this.mConstraintWidget, this.mStartToStart, androidx.constraintlayout.solver.state.State.Constraint.START_TO_START);
        applyConnection(this.mConstraintWidget, this.mStartToEnd, androidx.constraintlayout.solver.state.State.Constraint.START_TO_END);
        applyConnection(this.mConstraintWidget, this.mEndToStart, androidx.constraintlayout.solver.state.State.Constraint.END_TO_START);
        applyConnection(this.mConstraintWidget, this.mEndToEnd, androidx.constraintlayout.solver.state.State.Constraint.END_TO_END);
        applyConnection(this.mConstraintWidget, this.mTopToTop, androidx.constraintlayout.solver.state.State.Constraint.TOP_TO_TOP);
        applyConnection(this.mConstraintWidget, this.mTopToBottom, androidx.constraintlayout.solver.state.State.Constraint.TOP_TO_BOTTOM);
        applyConnection(this.mConstraintWidget, this.mBottomToTop, androidx.constraintlayout.solver.state.State.Constraint.BOTTOM_TO_TOP);
        applyConnection(this.mConstraintWidget, this.mBottomToBottom, androidx.constraintlayout.solver.state.State.Constraint.BOTTOM_TO_BOTTOM);
        applyConnection(this.mConstraintWidget, this.mBaselineToBaseline, androidx.constraintlayout.solver.state.State.Constraint.BASELINE_TO_BASELINE);
        int i = this.mHorizontalChainStyle;
        if (i != 0) {
            this.mConstraintWidget.setHorizontalChainStyle(i);
        }
        int i2 = this.mVerticalChainStyle;
        if (i2 != 0) {
            this.mConstraintWidget.setVerticalChainStyle(i2);
        }
        this.mConstraintWidget.setHorizontalBiasPercent(this.mHorizontalBias);
        this.mConstraintWidget.setVerticalBiasPercent(this.mVerticalBias);
    }

    public androidx.constraintlayout.solver.state.ConstraintReference baseline() {
        this.mLast = androidx.constraintlayout.solver.state.State.Constraint.BASELINE_TO_BASELINE;
        return this;
    }

    public androidx.constraintlayout.solver.state.ConstraintReference baselineToBaseline(java.lang.Object obj) {
        this.mLast = androidx.constraintlayout.solver.state.State.Constraint.BASELINE_TO_BASELINE;
        this.mBaselineToBaseline = obj;
        return this;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0016, code lost:
    
        return r2;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public androidx.constraintlayout.solver.state.ConstraintReference bias(float f) {
        androidx.constraintlayout.solver.state.State.Constraint constraint = this.mLast;
        if (constraint != null) {
            switch (androidx.constraintlayout.solver.state.ConstraintReference.AnonymousClass1.$SwitchMap$androidx$constraintlayout$solver$state$State$Constraint[constraint.ordinal()]) {
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                case 8:
                case 14:
                    this.mHorizontalBias = f;
                    break;
                case 9:
                case 10:
                case 11:
                case 12:
                case 15:
                    this.mVerticalBias = f;
                    break;
            }
        } else {
            return this;
        }
    }

    public androidx.constraintlayout.solver.state.ConstraintReference bottom() {
        if (this.mBottomToTop != null) {
            this.mLast = androidx.constraintlayout.solver.state.State.Constraint.BOTTOM_TO_TOP;
        } else {
            this.mLast = androidx.constraintlayout.solver.state.State.Constraint.BOTTOM_TO_BOTTOM;
        }
        return this;
    }

    public androidx.constraintlayout.solver.state.ConstraintReference bottomToBottom(java.lang.Object obj) {
        this.mLast = androidx.constraintlayout.solver.state.State.Constraint.BOTTOM_TO_BOTTOM;
        this.mBottomToBottom = obj;
        return this;
    }

    public androidx.constraintlayout.solver.state.ConstraintReference bottomToTop(java.lang.Object obj) {
        this.mLast = androidx.constraintlayout.solver.state.State.Constraint.BOTTOM_TO_TOP;
        this.mBottomToTop = obj;
        return this;
    }

    public androidx.constraintlayout.solver.state.ConstraintReference centerHorizontally(java.lang.Object obj) {
        java.lang.Object obj2 = get(obj);
        this.mStartToStart = obj2;
        this.mEndToEnd = obj2;
        this.mLast = androidx.constraintlayout.solver.state.State.Constraint.CENTER_HORIZONTALLY;
        this.mHorizontalBias = 0.5f;
        return this;
    }

    public androidx.constraintlayout.solver.state.ConstraintReference centerVertically(java.lang.Object obj) {
        java.lang.Object obj2 = get(obj);
        this.mTopToTop = obj2;
        this.mBottomToBottom = obj2;
        this.mLast = androidx.constraintlayout.solver.state.State.Constraint.CENTER_VERTICALLY;
        this.mVerticalBias = 0.5f;
        return this;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public androidx.constraintlayout.solver.state.ConstraintReference clear() {
        androidx.constraintlayout.solver.state.State.Constraint constraint = this.mLast;
        if (constraint != null) {
            switch (androidx.constraintlayout.solver.state.ConstraintReference.AnonymousClass1.$SwitchMap$androidx$constraintlayout$solver$state$State$Constraint[constraint.ordinal()]) {
                case 1:
                case 2:
                    this.mLeftToLeft = null;
                    this.mLeftToRight = null;
                    this.mMarginLeft = 0;
                    this.mMarginLeftGone = 0;
                    break;
                case 3:
                case 4:
                    this.mRightToLeft = null;
                    this.mRightToRight = null;
                    this.mMarginRight = 0;
                    this.mMarginRightGone = 0;
                    break;
                case 5:
                case 6:
                    this.mStartToStart = null;
                    this.mStartToEnd = null;
                    this.mMarginStart = 0;
                    this.mMarginStartGone = 0;
                    break;
                case 7:
                case 8:
                    this.mEndToStart = null;
                    this.mEndToEnd = null;
                    this.mMarginEnd = 0;
                    this.mMarginEndGone = 0;
                    break;
                case 9:
                case 10:
                    this.mTopToTop = null;
                    this.mTopToBottom = null;
                    this.mMarginTop = 0;
                    this.mMarginTopGone = 0;
                    break;
                case 11:
                case 12:
                    this.mBottomToTop = null;
                    this.mBottomToBottom = null;
                    this.mMarginBottom = 0;
                    this.mMarginBottomGone = 0;
                    break;
                case 13:
                    this.mBaselineToBaseline = null;
                    break;
            }
        } else {
            this.mLeftToLeft = null;
            this.mLeftToRight = null;
            this.mMarginLeft = 0;
            this.mRightToLeft = null;
            this.mRightToRight = null;
            this.mMarginRight = 0;
            this.mStartToStart = null;
            this.mStartToEnd = null;
            this.mMarginStart = 0;
            this.mEndToStart = null;
            this.mEndToEnd = null;
            this.mMarginEnd = 0;
            this.mTopToTop = null;
            this.mTopToBottom = null;
            this.mMarginTop = 0;
            this.mBottomToTop = null;
            this.mBottomToBottom = null;
            this.mMarginBottom = 0;
            this.mBaselineToBaseline = null;
            this.mHorizontalBias = 0.5f;
            this.mVerticalBias = 0.5f;
            this.mMarginLeftGone = 0;
            this.mMarginRightGone = 0;
            this.mMarginStartGone = 0;
            this.mMarginEndGone = 0;
            this.mMarginTopGone = 0;
            this.mMarginBottomGone = 0;
        }
        return this;
    }

    public androidx.constraintlayout.solver.state.ConstraintReference clearHorizontal() {
        start().clear();
        end().clear();
        left().clear();
        right().clear();
        return this;
    }

    public androidx.constraintlayout.solver.state.ConstraintReference clearVertical() {
        top().clear();
        baseline().clear();
        bottom().clear();
        return this;
    }

    public androidx.constraintlayout.solver.widgets.ConstraintWidget createConstraintWidget() {
        return new androidx.constraintlayout.solver.widgets.ConstraintWidget(getWidth().getValue(), getHeight().getValue());
    }

    public androidx.constraintlayout.solver.state.ConstraintReference end() {
        if (this.mEndToStart != null) {
            this.mLast = androidx.constraintlayout.solver.state.State.Constraint.END_TO_START;
        } else {
            this.mLast = androidx.constraintlayout.solver.state.State.Constraint.END_TO_END;
        }
        return this;
    }

    public androidx.constraintlayout.solver.state.ConstraintReference endToEnd(java.lang.Object obj) {
        this.mLast = androidx.constraintlayout.solver.state.State.Constraint.END_TO_END;
        this.mEndToEnd = obj;
        return this;
    }

    public androidx.constraintlayout.solver.state.ConstraintReference endToStart(java.lang.Object obj) {
        this.mLast = androidx.constraintlayout.solver.state.State.Constraint.END_TO_START;
        this.mEndToStart = obj;
        return this;
    }

    @Override // androidx.constraintlayout.solver.state.Reference
    public androidx.constraintlayout.solver.widgets.ConstraintWidget getConstraintWidget() {
        if (this.mConstraintWidget == null) {
            androidx.constraintlayout.solver.widgets.ConstraintWidget createConstraintWidget = createConstraintWidget();
            this.mConstraintWidget = createConstraintWidget;
            createConstraintWidget.setCompanionWidget(this.mView);
        }
        return this.mConstraintWidget;
    }

    public androidx.constraintlayout.solver.state.Dimension getHeight() {
        return this.mVerticalDimension;
    }

    public int getHorizontalChainStyle() {
        return this.mHorizontalChainStyle;
    }

    @Override // androidx.constraintlayout.solver.state.Reference
    public java.lang.Object getKey() {
        return this.key;
    }

    public int getVerticalChainStyle(int i) {
        return this.mVerticalChainStyle;
    }

    public java.lang.Object getView() {
        return this.mView;
    }

    public androidx.constraintlayout.solver.state.Dimension getWidth() {
        return this.mHorizontalDimension;
    }

    public androidx.constraintlayout.solver.state.ConstraintReference height(androidx.constraintlayout.solver.state.Dimension dimension) {
        return setHeight(dimension);
    }

    public androidx.constraintlayout.solver.state.ConstraintReference horizontalBias(float f) {
        this.mHorizontalBias = f;
        return this;
    }

    public androidx.constraintlayout.solver.state.ConstraintReference left() {
        if (this.mLeftToLeft != null) {
            this.mLast = androidx.constraintlayout.solver.state.State.Constraint.LEFT_TO_LEFT;
        } else {
            this.mLast = androidx.constraintlayout.solver.state.State.Constraint.LEFT_TO_RIGHT;
        }
        return this;
    }

    public androidx.constraintlayout.solver.state.ConstraintReference leftToLeft(java.lang.Object obj) {
        this.mLast = androidx.constraintlayout.solver.state.State.Constraint.LEFT_TO_LEFT;
        this.mLeftToLeft = obj;
        return this;
    }

    public androidx.constraintlayout.solver.state.ConstraintReference leftToRight(java.lang.Object obj) {
        this.mLast = androidx.constraintlayout.solver.state.State.Constraint.LEFT_TO_RIGHT;
        this.mLeftToRight = obj;
        return this;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public androidx.constraintlayout.solver.state.ConstraintReference margin(int i) {
        androidx.constraintlayout.solver.state.State.Constraint constraint = this.mLast;
        if (constraint != null) {
            switch (androidx.constraintlayout.solver.state.ConstraintReference.AnonymousClass1.$SwitchMap$androidx$constraintlayout$solver$state$State$Constraint[constraint.ordinal()]) {
                case 1:
                case 2:
                    this.mMarginLeft = i;
                    break;
                case 3:
                case 4:
                    this.mMarginRight = i;
                    break;
                case 5:
                case 6:
                    this.mMarginStart = i;
                    break;
                case 7:
                case 8:
                    this.mMarginEnd = i;
                    break;
                case 9:
                case 10:
                    this.mMarginTop = i;
                    break;
                case 11:
                case 12:
                    this.mMarginBottom = i;
                    break;
            }
        } else {
            this.mMarginLeft = i;
            this.mMarginRight = i;
            this.mMarginStart = i;
            this.mMarginEnd = i;
            this.mMarginTop = i;
            this.mMarginBottom = i;
        }
        return this;
    }

    public androidx.constraintlayout.solver.state.ConstraintReference margin(java.lang.Object obj) {
        return margin(this.mState.convertDimension(obj));
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public androidx.constraintlayout.solver.state.ConstraintReference marginGone(int i) {
        androidx.constraintlayout.solver.state.State.Constraint constraint = this.mLast;
        if (constraint != null) {
            switch (androidx.constraintlayout.solver.state.ConstraintReference.AnonymousClass1.$SwitchMap$androidx$constraintlayout$solver$state$State$Constraint[constraint.ordinal()]) {
                case 1:
                case 2:
                    this.mMarginLeftGone = i;
                    break;
                case 3:
                case 4:
                    this.mMarginRightGone = i;
                    break;
                case 5:
                case 6:
                    this.mMarginStartGone = i;
                    break;
                case 7:
                case 8:
                    this.mMarginEndGone = i;
                    break;
                case 9:
                case 10:
                    this.mMarginTopGone = i;
                    break;
                case 11:
                case 12:
                    this.mMarginBottomGone = i;
                    break;
            }
        } else {
            this.mMarginLeftGone = i;
            this.mMarginRightGone = i;
            this.mMarginStartGone = i;
            this.mMarginEndGone = i;
            this.mMarginTopGone = i;
            this.mMarginBottomGone = i;
        }
        return this;
    }

    public androidx.constraintlayout.solver.state.ConstraintReference right() {
        if (this.mRightToLeft != null) {
            this.mLast = androidx.constraintlayout.solver.state.State.Constraint.RIGHT_TO_LEFT;
        } else {
            this.mLast = androidx.constraintlayout.solver.state.State.Constraint.RIGHT_TO_RIGHT;
        }
        return this;
    }

    public androidx.constraintlayout.solver.state.ConstraintReference rightToLeft(java.lang.Object obj) {
        this.mLast = androidx.constraintlayout.solver.state.State.Constraint.RIGHT_TO_LEFT;
        this.mRightToLeft = obj;
        return this;
    }

    public androidx.constraintlayout.solver.state.ConstraintReference rightToRight(java.lang.Object obj) {
        this.mLast = androidx.constraintlayout.solver.state.State.Constraint.RIGHT_TO_RIGHT;
        this.mRightToRight = obj;
        return this;
    }

    @Override // androidx.constraintlayout.solver.state.Reference
    public void setConstraintWidget(androidx.constraintlayout.solver.widgets.ConstraintWidget constraintWidget) {
        if (constraintWidget == null) {
            return;
        }
        this.mConstraintWidget = constraintWidget;
        constraintWidget.setCompanionWidget(this.mView);
    }

    public androidx.constraintlayout.solver.state.ConstraintReference setHeight(androidx.constraintlayout.solver.state.Dimension dimension) {
        this.mVerticalDimension = dimension;
        return this;
    }

    public void setHorizontalChainStyle(int i) {
        this.mHorizontalChainStyle = i;
    }

    @Override // androidx.constraintlayout.solver.state.Reference
    public void setKey(java.lang.Object obj) {
        this.key = obj;
    }

    public void setVerticalChainStyle(int i) {
        this.mVerticalChainStyle = i;
    }

    public void setView(java.lang.Object obj) {
        this.mView = obj;
        androidx.constraintlayout.solver.widgets.ConstraintWidget constraintWidget = this.mConstraintWidget;
        if (constraintWidget != null) {
            constraintWidget.setCompanionWidget(obj);
        }
    }

    public androidx.constraintlayout.solver.state.ConstraintReference setWidth(androidx.constraintlayout.solver.state.Dimension dimension) {
        this.mHorizontalDimension = dimension;
        return this;
    }

    public androidx.constraintlayout.solver.state.ConstraintReference start() {
        if (this.mStartToStart != null) {
            this.mLast = androidx.constraintlayout.solver.state.State.Constraint.START_TO_START;
        } else {
            this.mLast = androidx.constraintlayout.solver.state.State.Constraint.START_TO_END;
        }
        return this;
    }

    public androidx.constraintlayout.solver.state.ConstraintReference startToEnd(java.lang.Object obj) {
        this.mLast = androidx.constraintlayout.solver.state.State.Constraint.START_TO_END;
        this.mStartToEnd = obj;
        return this;
    }

    public androidx.constraintlayout.solver.state.ConstraintReference startToStart(java.lang.Object obj) {
        this.mLast = androidx.constraintlayout.solver.state.State.Constraint.START_TO_START;
        this.mStartToStart = obj;
        return this;
    }

    public androidx.constraintlayout.solver.state.ConstraintReference top() {
        if (this.mTopToTop != null) {
            this.mLast = androidx.constraintlayout.solver.state.State.Constraint.TOP_TO_TOP;
        } else {
            this.mLast = androidx.constraintlayout.solver.state.State.Constraint.TOP_TO_BOTTOM;
        }
        return this;
    }

    public androidx.constraintlayout.solver.state.ConstraintReference topToBottom(java.lang.Object obj) {
        this.mLast = androidx.constraintlayout.solver.state.State.Constraint.TOP_TO_BOTTOM;
        this.mTopToBottom = obj;
        return this;
    }

    public androidx.constraintlayout.solver.state.ConstraintReference topToTop(java.lang.Object obj) {
        this.mLast = androidx.constraintlayout.solver.state.State.Constraint.TOP_TO_TOP;
        this.mTopToTop = obj;
        return this;
    }

    public void validate() throws androidx.constraintlayout.solver.state.ConstraintReference.IncorrectConstraintException {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        if (this.mLeftToLeft != null && this.mLeftToRight != null) {
            arrayList.add("LeftToLeft and LeftToRight both defined");
        }
        if (this.mRightToLeft != null && this.mRightToRight != null) {
            arrayList.add("RightToLeft and RightToRight both defined");
        }
        if (this.mStartToStart != null && this.mStartToEnd != null) {
            arrayList.add("StartToStart and StartToEnd both defined");
        }
        if (this.mEndToStart != null && this.mEndToEnd != null) {
            arrayList.add("EndToStart and EndToEnd both defined");
        }
        if ((this.mLeftToLeft != null || this.mLeftToRight != null || this.mRightToLeft != null || this.mRightToRight != null) && (this.mStartToStart != null || this.mStartToEnd != null || this.mEndToStart != null || this.mEndToEnd != null)) {
            arrayList.add("Both left/right and start/end constraints defined");
        }
        if (arrayList.size() > 0) {
            throw new androidx.constraintlayout.solver.state.ConstraintReference.IncorrectConstraintException(arrayList);
        }
    }

    public androidx.constraintlayout.solver.state.ConstraintReference verticalBias(float f) {
        this.mVerticalBias = f;
        return this;
    }

    public androidx.constraintlayout.solver.state.ConstraintReference width(androidx.constraintlayout.solver.state.Dimension dimension) {
        return setWidth(dimension);
    }
}
