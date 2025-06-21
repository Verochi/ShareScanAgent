package androidx.constraintlayout.solver.widgets;

/* loaded from: classes.dex */
public class ConstraintWidget {
    public static final int ANCHOR_BASELINE = 4;
    public static final int ANCHOR_BOTTOM = 3;
    public static final int ANCHOR_LEFT = 0;
    public static final int ANCHOR_RIGHT = 1;
    public static final int ANCHOR_TOP = 2;
    private static final boolean AUTOTAG_CENTER = false;
    public static final int BOTH = 2;
    public static final int CHAIN_PACKED = 2;
    public static final int CHAIN_SPREAD = 0;
    public static final int CHAIN_SPREAD_INSIDE = 1;
    public static float DEFAULT_BIAS = 0.5f;
    static final int DIMENSION_HORIZONTAL = 0;
    static final int DIMENSION_VERTICAL = 1;
    protected static final int DIRECT = 2;
    public static final int GONE = 8;
    public static final int HORIZONTAL = 0;
    public static final int INVISIBLE = 4;
    public static final int MATCH_CONSTRAINT_PERCENT = 2;
    public static final int MATCH_CONSTRAINT_RATIO = 3;
    public static final int MATCH_CONSTRAINT_RATIO_RESOLVED = 4;
    public static final int MATCH_CONSTRAINT_SPREAD = 0;
    public static final int MATCH_CONSTRAINT_WRAP = 1;
    protected static final int SOLVER = 1;
    public static final int UNKNOWN = -1;
    private static final boolean USE_WRAP_DIMENSION_FOR_SPREAD = false;
    public static final int VERTICAL = 1;
    public static final int VISIBLE = 0;
    private static final int WRAP = -2;
    private boolean OPTIMIZE_WRAP;
    private boolean OPTIMIZE_WRAP_ON_RESOLVED;
    private boolean hasBaseline;
    public androidx.constraintlayout.solver.widgets.analyzer.ChainRun horizontalChainRun;
    public int horizontalGroup;
    public androidx.constraintlayout.solver.widgets.analyzer.HorizontalWidgetRun horizontalRun;
    private boolean inPlaceholder;
    public boolean[] isTerminalWidget;
    protected java.util.ArrayList<androidx.constraintlayout.solver.widgets.ConstraintAnchor> mAnchors;
    public androidx.constraintlayout.solver.widgets.ConstraintAnchor mBaseline;
    int mBaselineDistance;
    public androidx.constraintlayout.solver.widgets.ConstraintAnchor mBottom;
    boolean mBottomHasCentered;
    public androidx.constraintlayout.solver.widgets.ConstraintAnchor mCenter;
    androidx.constraintlayout.solver.widgets.ConstraintAnchor mCenterX;
    androidx.constraintlayout.solver.widgets.ConstraintAnchor mCenterY;
    private float mCircleConstraintAngle;
    private java.lang.Object mCompanionWidget;
    private int mContainerItemSkip;
    private java.lang.String mDebugName;
    public float mDimensionRatio;
    protected int mDimensionRatioSide;
    int mDistToBottom;
    int mDistToLeft;
    int mDistToRight;
    int mDistToTop;
    boolean mGroupsToSolver;
    int mHeight;
    float mHorizontalBiasPercent;
    boolean mHorizontalChainFixedPosition;
    int mHorizontalChainStyle;
    androidx.constraintlayout.solver.widgets.ConstraintWidget mHorizontalNextWidget;
    public int mHorizontalResolution;
    boolean mHorizontalWrapVisited;
    private boolean mInVirtuaLayout;
    public boolean mIsHeightWrapContent;
    private boolean[] mIsInBarrier;
    public boolean mIsWidthWrapContent;
    private int mLastHorizontalMeasureSpec;
    private int mLastVerticalMeasureSpec;
    public androidx.constraintlayout.solver.widgets.ConstraintAnchor mLeft;
    boolean mLeftHasCentered;
    public androidx.constraintlayout.solver.widgets.ConstraintAnchor[] mListAnchors;
    public androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour[] mListDimensionBehaviors;
    protected androidx.constraintlayout.solver.widgets.ConstraintWidget[] mListNextMatchConstraintsWidget;
    public int mMatchConstraintDefaultHeight;
    public int mMatchConstraintDefaultWidth;
    public int mMatchConstraintMaxHeight;
    public int mMatchConstraintMaxWidth;
    public int mMatchConstraintMinHeight;
    public int mMatchConstraintMinWidth;
    public float mMatchConstraintPercentHeight;
    public float mMatchConstraintPercentWidth;
    private int[] mMaxDimension;
    private boolean mMeasureRequested;
    protected int mMinHeight;
    protected int mMinWidth;
    protected androidx.constraintlayout.solver.widgets.ConstraintWidget[] mNextChainWidget;
    protected int mOffsetX;
    protected int mOffsetY;
    public androidx.constraintlayout.solver.widgets.ConstraintWidget mParent;
    int mRelX;
    int mRelY;
    float mResolvedDimensionRatio;
    int mResolvedDimensionRatioSide;
    boolean mResolvedHasRatio;
    public int[] mResolvedMatchConstraintDefault;
    public androidx.constraintlayout.solver.widgets.ConstraintAnchor mRight;
    boolean mRightHasCentered;
    public androidx.constraintlayout.solver.widgets.ConstraintAnchor mTop;
    boolean mTopHasCentered;
    private java.lang.String mType;
    float mVerticalBiasPercent;
    boolean mVerticalChainFixedPosition;
    int mVerticalChainStyle;
    androidx.constraintlayout.solver.widgets.ConstraintWidget mVerticalNextWidget;
    public int mVerticalResolution;
    boolean mVerticalWrapVisited;
    private int mVisibility;
    public float[] mWeight;
    int mWidth;
    protected int mX;
    protected int mY;
    public boolean measured;
    private boolean resolvedHorizontal;
    private boolean resolvedVertical;
    public androidx.constraintlayout.solver.widgets.analyzer.WidgetRun[] run;
    public androidx.constraintlayout.solver.widgets.analyzer.ChainRun verticalChainRun;
    public int verticalGroup;
    public androidx.constraintlayout.solver.widgets.analyzer.VerticalWidgetRun verticalRun;

    /* renamed from: androidx.constraintlayout.solver.widgets.ConstraintWidget$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type;
        static final /* synthetic */ int[] $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintWidget$DimensionBehaviour;

        static {
            int[] iArr = new int[androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.values().length];
            $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintWidget$DimensionBehaviour = iArr;
            try {
                iArr[androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.FIXED.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintWidget$DimensionBehaviour[androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintWidget$DimensionBehaviour[androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_PARENT.ordinal()] = 3;
            } catch (java.lang.NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintWidget$DimensionBehaviour[androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT.ordinal()] = 4;
            } catch (java.lang.NoSuchFieldError unused4) {
            }
            int[] iArr2 = new int[androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.values().length];
            $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type = iArr2;
            try {
                iArr2[androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.LEFT.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.TOP.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.RIGHT.ordinal()] = 3;
            } catch (java.lang.NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.BOTTOM.ordinal()] = 4;
            } catch (java.lang.NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.BASELINE.ordinal()] = 5;
            } catch (java.lang.NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.CENTER.ordinal()] = 6;
            } catch (java.lang.NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.CENTER_X.ordinal()] = 7;
            } catch (java.lang.NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.CENTER_Y.ordinal()] = 8;
            } catch (java.lang.NoSuchFieldError unused12) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.NONE.ordinal()] = 9;
            } catch (java.lang.NoSuchFieldError unused13) {
            }
        }
    }

    public enum DimensionBehaviour {
        FIXED,
        WRAP_CONTENT,
        MATCH_CONSTRAINT,
        MATCH_PARENT
    }

    public ConstraintWidget() {
        this.measured = false;
        this.run = new androidx.constraintlayout.solver.widgets.analyzer.WidgetRun[2];
        this.horizontalRun = null;
        this.verticalRun = null;
        this.isTerminalWidget = new boolean[]{true, true};
        this.mResolvedHasRatio = false;
        this.mMeasureRequested = true;
        this.OPTIMIZE_WRAP = false;
        this.OPTIMIZE_WRAP_ON_RESOLVED = true;
        this.resolvedHorizontal = false;
        this.resolvedVertical = false;
        this.mHorizontalResolution = -1;
        this.mVerticalResolution = -1;
        this.mMatchConstraintDefaultWidth = 0;
        this.mMatchConstraintDefaultHeight = 0;
        this.mResolvedMatchConstraintDefault = new int[2];
        this.mMatchConstraintMinWidth = 0;
        this.mMatchConstraintMaxWidth = 0;
        this.mMatchConstraintPercentWidth = 1.0f;
        this.mMatchConstraintMinHeight = 0;
        this.mMatchConstraintMaxHeight = 0;
        this.mMatchConstraintPercentHeight = 1.0f;
        this.mResolvedDimensionRatioSide = -1;
        this.mResolvedDimensionRatio = 1.0f;
        this.mMaxDimension = new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE};
        this.mCircleConstraintAngle = 0.0f;
        this.hasBaseline = false;
        this.mInVirtuaLayout = false;
        this.mLastHorizontalMeasureSpec = 0;
        this.mLastVerticalMeasureSpec = 0;
        this.mLeft = new androidx.constraintlayout.solver.widgets.ConstraintAnchor(this, androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.LEFT);
        this.mTop = new androidx.constraintlayout.solver.widgets.ConstraintAnchor(this, androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.TOP);
        this.mRight = new androidx.constraintlayout.solver.widgets.ConstraintAnchor(this, androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.RIGHT);
        this.mBottom = new androidx.constraintlayout.solver.widgets.ConstraintAnchor(this, androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.BOTTOM);
        this.mBaseline = new androidx.constraintlayout.solver.widgets.ConstraintAnchor(this, androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.BASELINE);
        this.mCenterX = new androidx.constraintlayout.solver.widgets.ConstraintAnchor(this, androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.CENTER_X);
        this.mCenterY = new androidx.constraintlayout.solver.widgets.ConstraintAnchor(this, androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.CENTER_Y);
        androidx.constraintlayout.solver.widgets.ConstraintAnchor constraintAnchor = new androidx.constraintlayout.solver.widgets.ConstraintAnchor(this, androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.CENTER);
        this.mCenter = constraintAnchor;
        this.mListAnchors = new androidx.constraintlayout.solver.widgets.ConstraintAnchor[]{this.mLeft, this.mRight, this.mTop, this.mBottom, this.mBaseline, constraintAnchor};
        this.mAnchors = new java.util.ArrayList<>();
        this.mIsInBarrier = new boolean[2];
        androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour dimensionBehaviour = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.FIXED;
        this.mListDimensionBehaviors = new androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour[]{dimensionBehaviour, dimensionBehaviour};
        this.mParent = null;
        this.mWidth = 0;
        this.mHeight = 0;
        this.mDimensionRatio = 0.0f;
        this.mDimensionRatioSide = -1;
        this.mX = 0;
        this.mY = 0;
        this.mRelX = 0;
        this.mRelY = 0;
        this.mOffsetX = 0;
        this.mOffsetY = 0;
        this.mBaselineDistance = 0;
        float f = DEFAULT_BIAS;
        this.mHorizontalBiasPercent = f;
        this.mVerticalBiasPercent = f;
        this.mContainerItemSkip = 0;
        this.mVisibility = 0;
        this.mDebugName = null;
        this.mType = null;
        this.mGroupsToSolver = false;
        this.mHorizontalChainStyle = 0;
        this.mVerticalChainStyle = 0;
        this.mWeight = new float[]{-1.0f, -1.0f};
        this.mListNextMatchConstraintsWidget = new androidx.constraintlayout.solver.widgets.ConstraintWidget[]{null, null};
        this.mNextChainWidget = new androidx.constraintlayout.solver.widgets.ConstraintWidget[]{null, null};
        this.mHorizontalNextWidget = null;
        this.mVerticalNextWidget = null;
        this.horizontalGroup = -1;
        this.verticalGroup = -1;
        addAnchors();
    }

    public ConstraintWidget(int i, int i2) {
        this(0, 0, i, i2);
    }

    public ConstraintWidget(int i, int i2, int i3, int i4) {
        this.measured = false;
        this.run = new androidx.constraintlayout.solver.widgets.analyzer.WidgetRun[2];
        this.horizontalRun = null;
        this.verticalRun = null;
        this.isTerminalWidget = new boolean[]{true, true};
        this.mResolvedHasRatio = false;
        this.mMeasureRequested = true;
        this.OPTIMIZE_WRAP = false;
        this.OPTIMIZE_WRAP_ON_RESOLVED = true;
        this.resolvedHorizontal = false;
        this.resolvedVertical = false;
        this.mHorizontalResolution = -1;
        this.mVerticalResolution = -1;
        this.mMatchConstraintDefaultWidth = 0;
        this.mMatchConstraintDefaultHeight = 0;
        this.mResolvedMatchConstraintDefault = new int[2];
        this.mMatchConstraintMinWidth = 0;
        this.mMatchConstraintMaxWidth = 0;
        this.mMatchConstraintPercentWidth = 1.0f;
        this.mMatchConstraintMinHeight = 0;
        this.mMatchConstraintMaxHeight = 0;
        this.mMatchConstraintPercentHeight = 1.0f;
        this.mResolvedDimensionRatioSide = -1;
        this.mResolvedDimensionRatio = 1.0f;
        this.mMaxDimension = new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE};
        this.mCircleConstraintAngle = 0.0f;
        this.hasBaseline = false;
        this.mInVirtuaLayout = false;
        this.mLastHorizontalMeasureSpec = 0;
        this.mLastVerticalMeasureSpec = 0;
        this.mLeft = new androidx.constraintlayout.solver.widgets.ConstraintAnchor(this, androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.LEFT);
        this.mTop = new androidx.constraintlayout.solver.widgets.ConstraintAnchor(this, androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.TOP);
        this.mRight = new androidx.constraintlayout.solver.widgets.ConstraintAnchor(this, androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.RIGHT);
        this.mBottom = new androidx.constraintlayout.solver.widgets.ConstraintAnchor(this, androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.BOTTOM);
        this.mBaseline = new androidx.constraintlayout.solver.widgets.ConstraintAnchor(this, androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.BASELINE);
        this.mCenterX = new androidx.constraintlayout.solver.widgets.ConstraintAnchor(this, androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.CENTER_X);
        this.mCenterY = new androidx.constraintlayout.solver.widgets.ConstraintAnchor(this, androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.CENTER_Y);
        androidx.constraintlayout.solver.widgets.ConstraintAnchor constraintAnchor = new androidx.constraintlayout.solver.widgets.ConstraintAnchor(this, androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.CENTER);
        this.mCenter = constraintAnchor;
        this.mListAnchors = new androidx.constraintlayout.solver.widgets.ConstraintAnchor[]{this.mLeft, this.mRight, this.mTop, this.mBottom, this.mBaseline, constraintAnchor};
        this.mAnchors = new java.util.ArrayList<>();
        this.mIsInBarrier = new boolean[2];
        androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour dimensionBehaviour = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.FIXED;
        this.mListDimensionBehaviors = new androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour[]{dimensionBehaviour, dimensionBehaviour};
        this.mParent = null;
        this.mDimensionRatio = 0.0f;
        this.mDimensionRatioSide = -1;
        this.mRelX = 0;
        this.mRelY = 0;
        this.mOffsetX = 0;
        this.mOffsetY = 0;
        this.mBaselineDistance = 0;
        float f = DEFAULT_BIAS;
        this.mHorizontalBiasPercent = f;
        this.mVerticalBiasPercent = f;
        this.mContainerItemSkip = 0;
        this.mVisibility = 0;
        this.mDebugName = null;
        this.mType = null;
        this.mGroupsToSolver = false;
        this.mHorizontalChainStyle = 0;
        this.mVerticalChainStyle = 0;
        this.mWeight = new float[]{-1.0f, -1.0f};
        this.mListNextMatchConstraintsWidget = new androidx.constraintlayout.solver.widgets.ConstraintWidget[]{null, null};
        this.mNextChainWidget = new androidx.constraintlayout.solver.widgets.ConstraintWidget[]{null, null};
        this.mHorizontalNextWidget = null;
        this.mVerticalNextWidget = null;
        this.horizontalGroup = -1;
        this.verticalGroup = -1;
        this.mX = i;
        this.mY = i2;
        this.mWidth = i3;
        this.mHeight = i4;
        addAnchors();
    }

    public ConstraintWidget(java.lang.String str) {
        this.measured = false;
        this.run = new androidx.constraintlayout.solver.widgets.analyzer.WidgetRun[2];
        this.horizontalRun = null;
        this.verticalRun = null;
        this.isTerminalWidget = new boolean[]{true, true};
        this.mResolvedHasRatio = false;
        this.mMeasureRequested = true;
        this.OPTIMIZE_WRAP = false;
        this.OPTIMIZE_WRAP_ON_RESOLVED = true;
        this.resolvedHorizontal = false;
        this.resolvedVertical = false;
        this.mHorizontalResolution = -1;
        this.mVerticalResolution = -1;
        this.mMatchConstraintDefaultWidth = 0;
        this.mMatchConstraintDefaultHeight = 0;
        this.mResolvedMatchConstraintDefault = new int[2];
        this.mMatchConstraintMinWidth = 0;
        this.mMatchConstraintMaxWidth = 0;
        this.mMatchConstraintPercentWidth = 1.0f;
        this.mMatchConstraintMinHeight = 0;
        this.mMatchConstraintMaxHeight = 0;
        this.mMatchConstraintPercentHeight = 1.0f;
        this.mResolvedDimensionRatioSide = -1;
        this.mResolvedDimensionRatio = 1.0f;
        this.mMaxDimension = new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE};
        this.mCircleConstraintAngle = 0.0f;
        this.hasBaseline = false;
        this.mInVirtuaLayout = false;
        this.mLastHorizontalMeasureSpec = 0;
        this.mLastVerticalMeasureSpec = 0;
        this.mLeft = new androidx.constraintlayout.solver.widgets.ConstraintAnchor(this, androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.LEFT);
        this.mTop = new androidx.constraintlayout.solver.widgets.ConstraintAnchor(this, androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.TOP);
        this.mRight = new androidx.constraintlayout.solver.widgets.ConstraintAnchor(this, androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.RIGHT);
        this.mBottom = new androidx.constraintlayout.solver.widgets.ConstraintAnchor(this, androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.BOTTOM);
        this.mBaseline = new androidx.constraintlayout.solver.widgets.ConstraintAnchor(this, androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.BASELINE);
        this.mCenterX = new androidx.constraintlayout.solver.widgets.ConstraintAnchor(this, androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.CENTER_X);
        this.mCenterY = new androidx.constraintlayout.solver.widgets.ConstraintAnchor(this, androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.CENTER_Y);
        androidx.constraintlayout.solver.widgets.ConstraintAnchor constraintAnchor = new androidx.constraintlayout.solver.widgets.ConstraintAnchor(this, androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.CENTER);
        this.mCenter = constraintAnchor;
        this.mListAnchors = new androidx.constraintlayout.solver.widgets.ConstraintAnchor[]{this.mLeft, this.mRight, this.mTop, this.mBottom, this.mBaseline, constraintAnchor};
        this.mAnchors = new java.util.ArrayList<>();
        this.mIsInBarrier = new boolean[2];
        androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour dimensionBehaviour = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.FIXED;
        this.mListDimensionBehaviors = new androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour[]{dimensionBehaviour, dimensionBehaviour};
        this.mParent = null;
        this.mWidth = 0;
        this.mHeight = 0;
        this.mDimensionRatio = 0.0f;
        this.mDimensionRatioSide = -1;
        this.mX = 0;
        this.mY = 0;
        this.mRelX = 0;
        this.mRelY = 0;
        this.mOffsetX = 0;
        this.mOffsetY = 0;
        this.mBaselineDistance = 0;
        float f = DEFAULT_BIAS;
        this.mHorizontalBiasPercent = f;
        this.mVerticalBiasPercent = f;
        this.mContainerItemSkip = 0;
        this.mVisibility = 0;
        this.mDebugName = null;
        this.mType = null;
        this.mGroupsToSolver = false;
        this.mHorizontalChainStyle = 0;
        this.mVerticalChainStyle = 0;
        this.mWeight = new float[]{-1.0f, -1.0f};
        this.mListNextMatchConstraintsWidget = new androidx.constraintlayout.solver.widgets.ConstraintWidget[]{null, null};
        this.mNextChainWidget = new androidx.constraintlayout.solver.widgets.ConstraintWidget[]{null, null};
        this.mHorizontalNextWidget = null;
        this.mVerticalNextWidget = null;
        this.horizontalGroup = -1;
        this.verticalGroup = -1;
        addAnchors();
        setDebugName(str);
    }

    public ConstraintWidget(java.lang.String str, int i, int i2) {
        this(i, i2);
        setDebugName(str);
    }

    public ConstraintWidget(java.lang.String str, int i, int i2, int i3, int i4) {
        this(i, i2, i3, i4);
        setDebugName(str);
    }

    private void addAnchors() {
        this.mAnchors.add(this.mLeft);
        this.mAnchors.add(this.mTop);
        this.mAnchors.add(this.mRight);
        this.mAnchors.add(this.mBottom);
        this.mAnchors.add(this.mCenterX);
        this.mAnchors.add(this.mCenterY);
        this.mAnchors.add(this.mCenter);
        this.mAnchors.add(this.mBaseline);
    }

    /* JADX WARN: Removed duplicated region for block: B:103:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:147:0x0384  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x03e1  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x0420  */
    /* JADX WARN: Removed duplicated region for block: B:208:0x0470  */
    /* JADX WARN: Removed duplicated region for block: B:228:0x0407  */
    /* JADX WARN: Removed duplicated region for block: B:230:0x03c6  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:294:0x04d3  */
    /* JADX WARN: Removed duplicated region for block: B:296:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:349:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x01d6  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x04df A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:75:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:81:0x04a6 A[ADDED_TO_REGION] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void applyConstraints(androidx.constraintlayout.solver.LinearSystem linearSystem, boolean z, boolean z2, boolean z3, boolean z4, androidx.constraintlayout.solver.SolverVariable solverVariable, androidx.constraintlayout.solver.SolverVariable solverVariable2, androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour dimensionBehaviour, boolean z5, androidx.constraintlayout.solver.widgets.ConstraintAnchor constraintAnchor, androidx.constraintlayout.solver.widgets.ConstraintAnchor constraintAnchor2, int i, int i2, int i3, int i4, float f, boolean z6, boolean z7, boolean z8, boolean z9, boolean z10, int i5, int i6, int i7, int i8, float f2, boolean z11) {
        int i9;
        boolean z12;
        int i10;
        androidx.constraintlayout.solver.SolverVariable solverVariable3;
        int i11;
        int i12;
        androidx.constraintlayout.solver.SolverVariable solverVariable4;
        androidx.constraintlayout.solver.SolverVariable solverVariable5;
        androidx.constraintlayout.solver.SolverVariable solverVariable6;
        int i13;
        int i14;
        boolean z13;
        boolean z14;
        androidx.constraintlayout.solver.SolverVariable createObjectVariable;
        androidx.constraintlayout.solver.SolverVariable createObjectVariable2;
        androidx.constraintlayout.solver.SolverVariable solverVariable7;
        androidx.constraintlayout.solver.SolverVariable solverVariable8;
        androidx.constraintlayout.solver.SolverVariable solverVariable9;
        int i15;
        androidx.constraintlayout.solver.SolverVariable solverVariable10;
        int i16;
        int i17;
        boolean z15;
        androidx.constraintlayout.solver.widgets.ConstraintAnchor constraintAnchor3;
        androidx.constraintlayout.solver.SolverVariable solverVariable11;
        boolean z16;
        int i18;
        boolean z17;
        androidx.constraintlayout.solver.SolverVariable solverVariable12;
        int i19;
        boolean z18;
        int i20;
        int i21;
        boolean z19;
        int i22;
        androidx.constraintlayout.solver.widgets.ConstraintWidget constraintWidget;
        androidx.constraintlayout.solver.widgets.ConstraintWidget constraintWidget2;
        androidx.constraintlayout.solver.SolverVariable solverVariable13;
        androidx.constraintlayout.solver.SolverVariable solverVariable14;
        int i23;
        boolean z20;
        androidx.constraintlayout.solver.SolverVariable solverVariable15;
        int i24;
        int i25;
        androidx.constraintlayout.solver.SolverVariable solverVariable16;
        int i26;
        androidx.constraintlayout.solver.widgets.ConstraintWidget constraintWidget3;
        boolean z21;
        int i27;
        int i28;
        int i29;
        boolean z22;
        int i30;
        androidx.constraintlayout.solver.widgets.ConstraintWidget constraintWidget4;
        androidx.constraintlayout.solver.widgets.ConstraintWidget constraintWidget5;
        androidx.constraintlayout.solver.SolverVariable createObjectVariable3 = linearSystem.createObjectVariable(constraintAnchor);
        androidx.constraintlayout.solver.SolverVariable createObjectVariable4 = linearSystem.createObjectVariable(constraintAnchor2);
        androidx.constraintlayout.solver.SolverVariable createObjectVariable5 = linearSystem.createObjectVariable(constraintAnchor.getTarget());
        androidx.constraintlayout.solver.SolverVariable createObjectVariable6 = linearSystem.createObjectVariable(constraintAnchor2.getTarget());
        if (androidx.constraintlayout.solver.LinearSystem.getMetrics() != null) {
            androidx.constraintlayout.solver.LinearSystem.getMetrics().nonresolvedWidgets++;
        }
        boolean isConnected = constraintAnchor.isConnected();
        boolean isConnected2 = constraintAnchor2.isConnected();
        boolean isConnected3 = this.mCenter.isConnected();
        int i31 = isConnected2 ? (isConnected ? 1 : 0) + 1 : isConnected ? 1 : 0;
        if (isConnected3) {
            i31++;
        }
        int i32 = z6 ? 3 : i5;
        int i33 = androidx.constraintlayout.solver.widgets.ConstraintWidget.AnonymousClass1.$SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintWidget$DimensionBehaviour[dimensionBehaviour.ordinal()];
        if (i33 == 1 || i33 == 2 || i33 == 3 || i33 != 4) {
            i9 = i32;
        } else {
            i9 = i32;
            if (i9 != 4) {
                z12 = true;
                if (this.mVisibility != 8) {
                    i10 = 0;
                    z12 = false;
                } else {
                    i10 = i2;
                }
                if (z11) {
                    if (!isConnected && !isConnected2 && !isConnected3) {
                        linearSystem.addEquality(createObjectVariable3, i);
                    } else if (isConnected && !isConnected2) {
                        solverVariable3 = createObjectVariable6;
                        linearSystem.addEquality(createObjectVariable3, createObjectVariable5, constraintAnchor.getMargin(), 8);
                        if (!z12) {
                            if (z5) {
                                linearSystem.addEquality(createObjectVariable4, createObjectVariable3, 0, 3);
                                if (i3 > 0) {
                                    linearSystem.addGreaterThan(createObjectVariable4, createObjectVariable3, i3, 8);
                                }
                                if (i4 < Integer.MAX_VALUE) {
                                    linearSystem.addLowerThan(createObjectVariable4, createObjectVariable3, i4, 8);
                                }
                            } else {
                                linearSystem.addEquality(createObjectVariable4, createObjectVariable3, i10, 8);
                            }
                            i14 = i7;
                            i11 = i8;
                            solverVariable4 = createObjectVariable5;
                            solverVariable5 = createObjectVariable4;
                        } else {
                            if (i31 != 2 && !z6 && (i9 == 1 || i9 == 0)) {
                                int max = java.lang.Math.max(i7, i10);
                                if (i8 > 0) {
                                    max = java.lang.Math.min(i8, max);
                                }
                                linearSystem.addEquality(createObjectVariable4, createObjectVariable3, max, 8);
                                z14 = z4;
                                i14 = i7;
                                i11 = i8;
                                solverVariable4 = createObjectVariable5;
                                solverVariable5 = createObjectVariable4;
                                solverVariable6 = solverVariable3;
                                z13 = false;
                                i13 = i31;
                                if (!z11) {
                                }
                                if (i16 < i17) {
                                    return;
                                } else {
                                    return;
                                }
                            }
                            int i34 = i7 == -2 ? i10 : i7;
                            i11 = i8 == -2 ? i10 : i8;
                            if (i10 > 0 && i9 != 1) {
                                i10 = 0;
                            }
                            if (i34 > 0) {
                                linearSystem.addGreaterThan(createObjectVariable4, createObjectVariable3, i34, 8);
                                i10 = java.lang.Math.max(i10, i34);
                            }
                            if (i11 > 0) {
                                if ((z2 && i9 == 1) ? false : true) {
                                    i12 = 8;
                                    linearSystem.addLowerThan(createObjectVariable4, createObjectVariable3, i11, 8);
                                } else {
                                    i12 = 8;
                                }
                                i10 = java.lang.Math.min(i10, i11);
                            } else {
                                i12 = 8;
                            }
                            if (i9 != 1) {
                                if (i9 == 2) {
                                    androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type type = constraintAnchor.getType();
                                    androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type type2 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.TOP;
                                    if (type == type2 || constraintAnchor.getType() == androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.BOTTOM) {
                                        createObjectVariable = linearSystem.createObjectVariable(this.mParent.getAnchor(type2));
                                        createObjectVariable2 = linearSystem.createObjectVariable(this.mParent.getAnchor(androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.BOTTOM));
                                    } else {
                                        createObjectVariable = linearSystem.createObjectVariable(this.mParent.getAnchor(androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.LEFT));
                                        createObjectVariable2 = linearSystem.createObjectVariable(this.mParent.getAnchor(androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.RIGHT));
                                    }
                                    int i35 = i34;
                                    solverVariable6 = solverVariable3;
                                    i13 = i31;
                                    solverVariable4 = createObjectVariable5;
                                    solverVariable5 = createObjectVariable4;
                                    linearSystem.addConstraint(linearSystem.createRow().createRowDimensionRatio(createObjectVariable4, createObjectVariable3, createObjectVariable2, createObjectVariable, f2));
                                    z14 = z4;
                                    i14 = i35;
                                    z13 = false;
                                } else {
                                    solverVariable4 = createObjectVariable5;
                                    solverVariable5 = createObjectVariable4;
                                    int i36 = i34;
                                    solverVariable6 = solverVariable3;
                                    i13 = i31;
                                    i14 = i36;
                                    z13 = z12;
                                    z14 = true;
                                }
                                if (!z11) {
                                    solverVariable7 = solverVariable;
                                    solverVariable8 = solverVariable2;
                                    solverVariable9 = solverVariable5;
                                    i15 = 0;
                                    solverVariable10 = createObjectVariable3;
                                    i16 = i13;
                                    i17 = 2;
                                } else if (z8) {
                                    solverVariable7 = solverVariable;
                                    solverVariable8 = solverVariable2;
                                    solverVariable9 = solverVariable5;
                                    i16 = i13;
                                    i15 = 0;
                                    i17 = 2;
                                    solverVariable10 = createObjectVariable3;
                                } else {
                                    if ((isConnected || isConnected2 || isConnected3) && (!isConnected || isConnected2)) {
                                        if (!isConnected && isConnected2) {
                                            linearSystem.addEquality(solverVariable5, solverVariable6, -constraintAnchor2.getMargin(), 8);
                                            if (z2) {
                                                if (this.OPTIMIZE_WRAP && createObjectVariable3.isFinalValue && (constraintWidget4 = this.mParent) != null) {
                                                    androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer constraintWidgetContainer = (androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer) constraintWidget4;
                                                    if (z) {
                                                        constraintWidgetContainer.addHorizontalWrapMinVariable(constraintAnchor);
                                                    } else {
                                                        constraintWidgetContainer.addVerticalWrapMinVariable(constraintAnchor);
                                                    }
                                                } else {
                                                    linearSystem.addGreaterThan(createObjectVariable3, solverVariable, 0, 5);
                                                }
                                            }
                                        } else if (isConnected && isConnected2) {
                                            androidx.constraintlayout.solver.widgets.ConstraintWidget constraintWidget6 = constraintAnchor.mTarget.mOwner;
                                            androidx.constraintlayout.solver.widgets.ConstraintWidget constraintWidget7 = constraintAnchor2.mTarget.mOwner;
                                            androidx.constraintlayout.solver.widgets.ConstraintWidget parent = getParent();
                                            int i37 = 6;
                                            if (z13) {
                                                if (i9 == 0) {
                                                    if (i11 != 0 || i14 != 0) {
                                                        z16 = true;
                                                        z22 = false;
                                                        z17 = true;
                                                        i30 = 5;
                                                        i20 = 5;
                                                    } else if (solverVariable4.isFinalValue && solverVariable6.isFinalValue) {
                                                        linearSystem.addEquality(createObjectVariable3, solverVariable4, constraintAnchor.getMargin(), 8);
                                                        linearSystem.addEquality(solverVariable5, solverVariable6, -constraintAnchor2.getMargin(), 8);
                                                        return;
                                                    } else {
                                                        z16 = false;
                                                        z22 = true;
                                                        z17 = false;
                                                        i30 = 8;
                                                        i20 = 8;
                                                    }
                                                    if ((constraintWidget6 instanceof androidx.constraintlayout.solver.widgets.Barrier) || (constraintWidget7 instanceof androidx.constraintlayout.solver.widgets.Barrier)) {
                                                        solverVariable11 = solverVariable2;
                                                        i21 = i30;
                                                        i20 = 4;
                                                    } else {
                                                        solverVariable11 = solverVariable2;
                                                        i21 = i30;
                                                    }
                                                    z18 = z22;
                                                    i18 = 6;
                                                } else {
                                                    if (i9 == 1) {
                                                        solverVariable11 = solverVariable2;
                                                        z16 = true;
                                                        i18 = 6;
                                                        z17 = true;
                                                        z18 = false;
                                                        i20 = 4;
                                                    } else if (i9 != 3) {
                                                        solverVariable11 = solverVariable2;
                                                        z16 = false;
                                                        i18 = 6;
                                                        z17 = false;
                                                    } else if (this.mResolvedDimensionRatioSide == -1) {
                                                        if (z9) {
                                                            solverVariable11 = solverVariable2;
                                                            z16 = true;
                                                            i18 = z2 ? 5 : 4;
                                                        } else {
                                                            solverVariable11 = solverVariable2;
                                                            z16 = true;
                                                            i18 = 8;
                                                        }
                                                        z17 = true;
                                                        z18 = true;
                                                        i20 = 5;
                                                    } else if (z6) {
                                                        if (i6 == 2 || i6 == 1) {
                                                            i28 = 5;
                                                            i29 = 4;
                                                        } else {
                                                            i28 = 8;
                                                            i29 = 5;
                                                        }
                                                        solverVariable11 = solverVariable2;
                                                        i21 = i28;
                                                        i20 = i29;
                                                        z16 = true;
                                                        i18 = 6;
                                                        z17 = true;
                                                        z18 = true;
                                                    } else {
                                                        if (i11 > 0) {
                                                            solverVariable11 = solverVariable2;
                                                            z16 = true;
                                                            i18 = 6;
                                                            z17 = true;
                                                            z18 = true;
                                                            i20 = 5;
                                                        } else if (i11 != 0 || i14 != 0) {
                                                            solverVariable11 = solverVariable2;
                                                            z16 = true;
                                                            i18 = 6;
                                                            z17 = true;
                                                            z18 = true;
                                                            i20 = 4;
                                                        } else if (z9) {
                                                            solverVariable11 = solverVariable2;
                                                            i21 = (constraintWidget6 == parent || constraintWidget7 == parent) ? 5 : 4;
                                                            z16 = true;
                                                            i18 = 6;
                                                            z17 = true;
                                                            z18 = true;
                                                            i20 = 4;
                                                        } else {
                                                            solverVariable11 = solverVariable2;
                                                            z16 = true;
                                                            i18 = 6;
                                                            z17 = true;
                                                            z18 = true;
                                                            i20 = 8;
                                                        }
                                                        i21 = 5;
                                                    }
                                                    i21 = 8;
                                                }
                                                if (z17 || solverVariable4 != solverVariable6 || constraintWidget6 == parent) {
                                                    z19 = true;
                                                } else {
                                                    z17 = false;
                                                    z19 = false;
                                                }
                                                if (z16) {
                                                    i22 = i9;
                                                    constraintWidget = parent;
                                                    constraintWidget2 = constraintWidget7;
                                                    solverVariable13 = solverVariable5;
                                                    solverVariable14 = createObjectVariable3;
                                                    i23 = i21;
                                                    z20 = z2;
                                                } else {
                                                    if (z13 || z7 || z9 || solverVariable4 != solverVariable || solverVariable6 != solverVariable11) {
                                                        i23 = i21;
                                                        z21 = z19;
                                                        z20 = z2;
                                                        i27 = i18;
                                                    } else {
                                                        z20 = false;
                                                        i27 = 8;
                                                        z21 = false;
                                                        i23 = 8;
                                                    }
                                                    i22 = i9;
                                                    constraintWidget = parent;
                                                    constraintWidget2 = constraintWidget7;
                                                    androidx.constraintlayout.solver.SolverVariable solverVariable17 = solverVariable5;
                                                    solverVariable13 = solverVariable5;
                                                    solverVariable14 = createObjectVariable3;
                                                    linearSystem.addCentering(createObjectVariable3, solverVariable4, constraintAnchor.getMargin(), f, solverVariable6, solverVariable17, constraintAnchor2.getMargin(), i27);
                                                    z19 = z21;
                                                }
                                                if (this.mVisibility == 8 || constraintAnchor2.hasDependents()) {
                                                    if (z17) {
                                                        solverVariable15 = solverVariable13;
                                                    } else {
                                                        int i38 = (!z20 || solverVariable4 == solverVariable6 || z13 || !((constraintWidget6 instanceof androidx.constraintlayout.solver.widgets.Barrier) || (constraintWidget2 instanceof androidx.constraintlayout.solver.widgets.Barrier))) ? i23 : 6;
                                                        linearSystem.addGreaterThan(solverVariable14, solverVariable4, constraintAnchor.getMargin(), i38);
                                                        solverVariable15 = solverVariable13;
                                                        linearSystem.addLowerThan(solverVariable15, solverVariable6, -constraintAnchor2.getMargin(), i38);
                                                        i23 = i38;
                                                    }
                                                    if (z20 || !z10 || (constraintWidget6 instanceof androidx.constraintlayout.solver.widgets.Barrier) || (constraintWidget2 instanceof androidx.constraintlayout.solver.widgets.Barrier)) {
                                                        i24 = i20;
                                                        i25 = i23;
                                                    } else {
                                                        i24 = 6;
                                                        i25 = 6;
                                                        z19 = true;
                                                    }
                                                    if (z19) {
                                                        if (!z18 || (z9 && !z3)) {
                                                            constraintWidget3 = constraintWidget;
                                                        } else {
                                                            constraintWidget3 = constraintWidget;
                                                            if (constraintWidget6 != constraintWidget3 && constraintWidget2 != constraintWidget3) {
                                                                i37 = i24;
                                                            }
                                                            if ((constraintWidget6 instanceof androidx.constraintlayout.solver.widgets.Guideline) || (constraintWidget2 instanceof androidx.constraintlayout.solver.widgets.Guideline)) {
                                                                i37 = 5;
                                                            }
                                                            if ((constraintWidget6 instanceof androidx.constraintlayout.solver.widgets.Barrier) || (constraintWidget2 instanceof androidx.constraintlayout.solver.widgets.Barrier)) {
                                                                i37 = 5;
                                                            }
                                                            i24 = java.lang.Math.max(z9 ? 5 : i37, i24);
                                                        }
                                                        if (z20) {
                                                            i24 = java.lang.Math.min(i25, i24);
                                                            if (z6 && !z9 && (constraintWidget6 == constraintWidget3 || constraintWidget2 == constraintWidget3)) {
                                                                i24 = 4;
                                                            }
                                                        }
                                                        linearSystem.addEquality(solverVariable14, solverVariable4, constraintAnchor.getMargin(), i24);
                                                        linearSystem.addEquality(solverVariable15, solverVariable6, -constraintAnchor2.getMargin(), i24);
                                                    }
                                                    if (z20) {
                                                        int margin = solverVariable == solverVariable4 ? constraintAnchor.getMargin() : 0;
                                                        if (solverVariable4 != solverVariable) {
                                                            linearSystem.addGreaterThan(solverVariable14, solverVariable, margin, 5);
                                                        }
                                                    }
                                                    if (z20 || !z13) {
                                                        solverVariable16 = solverVariable15;
                                                    } else {
                                                        solverVariable16 = solverVariable15;
                                                        if (i3 == 0 && i14 == 0) {
                                                            if (z13 && i22 == 3) {
                                                                i26 = 0;
                                                                linearSystem.addGreaterThan(solverVariable16, solverVariable14, 0, 8);
                                                            } else {
                                                                i26 = 0;
                                                                linearSystem.addGreaterThan(solverVariable16, solverVariable14, 0, 5);
                                                            }
                                                            if (z20 || !z14) {
                                                                return;
                                                            }
                                                            if (constraintAnchor2.mTarget != null) {
                                                                i26 = constraintAnchor2.getMargin();
                                                            }
                                                            if (solverVariable6 != solverVariable2) {
                                                                if (!this.OPTIMIZE_WRAP || !solverVariable16.isFinalValue || (constraintWidget5 = this.mParent) == null) {
                                                                    linearSystem.addGreaterThan(solverVariable2, solverVariable16, i26, 5);
                                                                    return;
                                                                }
                                                                androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer constraintWidgetContainer2 = (androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer) constraintWidget5;
                                                                if (z) {
                                                                    constraintWidgetContainer2.addHorizontalWrapMaxVariable(constraintAnchor2);
                                                                    return;
                                                                } else {
                                                                    constraintWidgetContainer2.addVerticalWrapMaxVariable(constraintAnchor2);
                                                                    return;
                                                                }
                                                            }
                                                            return;
                                                        }
                                                    }
                                                    i26 = 0;
                                                    if (z20) {
                                                        return;
                                                    } else {
                                                        return;
                                                    }
                                                }
                                                return;
                                            }
                                            if (solverVariable4.isFinalValue && solverVariable6.isFinalValue) {
                                                linearSystem.addCentering(createObjectVariable3, solverVariable4, constraintAnchor.getMargin(), f, solverVariable6, solverVariable5, constraintAnchor2.getMargin(), 8);
                                                if (z2 && z14) {
                                                    if (constraintAnchor2.mTarget != null) {
                                                        i19 = constraintAnchor2.getMargin();
                                                        solverVariable12 = solverVariable2;
                                                    } else {
                                                        solverVariable12 = solverVariable2;
                                                        i19 = 0;
                                                    }
                                                    if (solverVariable6 != solverVariable12) {
                                                        linearSystem.addGreaterThan(solverVariable12, solverVariable5, i19, 5);
                                                        return;
                                                    }
                                                    return;
                                                }
                                                return;
                                            }
                                            solverVariable11 = solverVariable2;
                                            z16 = true;
                                            i18 = 6;
                                            z17 = true;
                                            z18 = false;
                                            i20 = 4;
                                            i21 = 5;
                                            if (z17) {
                                            }
                                            z19 = true;
                                            if (z16) {
                                            }
                                            if (this.mVisibility == 8) {
                                            }
                                            if (z17) {
                                            }
                                            if (z20) {
                                            }
                                            i24 = i20;
                                            i25 = i23;
                                            if (z19) {
                                            }
                                            if (z20) {
                                            }
                                            if (z20) {
                                            }
                                            solverVariable16 = solverVariable15;
                                            i26 = 0;
                                            if (z20) {
                                            }
                                        }
                                    }
                                    solverVariable16 = solverVariable5;
                                    i26 = 0;
                                    z20 = z2;
                                    if (z20) {
                                    }
                                }
                                if (i16 < i17 && z2 && z14) {
                                    linearSystem.addGreaterThan(solverVariable10, solverVariable7, i15, 8);
                                    boolean z23 = z || this.mBaseline.mTarget == null;
                                    if (z || (constraintAnchor3 = this.mBaseline.mTarget) == null) {
                                        z15 = z23;
                                    } else {
                                        androidx.constraintlayout.solver.widgets.ConstraintWidget constraintWidget8 = constraintAnchor3.mOwner;
                                        if (constraintWidget8.mDimensionRatio != 0.0f) {
                                            androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour[] dimensionBehaviourArr = constraintWidget8.mListDimensionBehaviors;
                                            androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = dimensionBehaviourArr[i15];
                                            androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour dimensionBehaviour3 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
                                            if (dimensionBehaviour2 == dimensionBehaviour3 && dimensionBehaviourArr[1] == dimensionBehaviour3) {
                                                z15 = true;
                                            }
                                        }
                                        z15 = false;
                                    }
                                    if (z15) {
                                        linearSystem.addGreaterThan(solverVariable8, solverVariable9, i15, 8);
                                        return;
                                    }
                                    return;
                                }
                                return;
                            }
                            if (z2) {
                                linearSystem.addEquality(createObjectVariable4, createObjectVariable3, i10, i12);
                            } else if (z8) {
                                linearSystem.addEquality(createObjectVariable4, createObjectVariable3, i10, 5);
                                linearSystem.addLowerThan(createObjectVariable4, createObjectVariable3, i10, i12);
                            } else {
                                linearSystem.addEquality(createObjectVariable4, createObjectVariable3, i10, 5);
                                linearSystem.addLowerThan(createObjectVariable4, createObjectVariable3, i10, i12);
                            }
                            solverVariable4 = createObjectVariable5;
                            solverVariable5 = createObjectVariable4;
                            i14 = i34;
                        }
                        z13 = z12;
                        solverVariable6 = solverVariable3;
                        z14 = z4;
                        i13 = i31;
                        if (!z11) {
                        }
                        if (i16 < i17) {
                        }
                    }
                }
                solverVariable3 = createObjectVariable6;
                if (!z12) {
                }
                z13 = z12;
                solverVariable6 = solverVariable3;
                z14 = z4;
                i13 = i31;
                if (!z11) {
                }
                if (i16 < i17) {
                }
            }
        }
        z12 = false;
        if (this.mVisibility != 8) {
        }
        if (z11) {
        }
        solverVariable3 = createObjectVariable6;
        if (!z12) {
        }
        z13 = z12;
        solverVariable6 = solverVariable3;
        z14 = z4;
        i13 = i31;
        if (!z11) {
        }
        if (i16 < i17) {
        }
    }

    private boolean isChainHead(int i) {
        androidx.constraintlayout.solver.widgets.ConstraintAnchor constraintAnchor;
        androidx.constraintlayout.solver.widgets.ConstraintAnchor constraintAnchor2;
        int i2 = i * 2;
        androidx.constraintlayout.solver.widgets.ConstraintAnchor[] constraintAnchorArr = this.mListAnchors;
        androidx.constraintlayout.solver.widgets.ConstraintAnchor constraintAnchor3 = constraintAnchorArr[i2];
        androidx.constraintlayout.solver.widgets.ConstraintAnchor constraintAnchor4 = constraintAnchor3.mTarget;
        return (constraintAnchor4 == null || constraintAnchor4.mTarget == constraintAnchor3 || (constraintAnchor2 = (constraintAnchor = constraintAnchorArr[i2 + 1]).mTarget) == null || constraintAnchor2.mTarget != constraintAnchor) ? false : true;
    }

    public void addChildrenToSolverByDependency(androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer constraintWidgetContainer, androidx.constraintlayout.solver.LinearSystem linearSystem, java.util.HashSet<androidx.constraintlayout.solver.widgets.ConstraintWidget> hashSet, int i, boolean z) {
        if (z) {
            if (!hashSet.contains(this)) {
                return;
            }
            androidx.constraintlayout.solver.widgets.Optimizer.checkMatchParent(constraintWidgetContainer, linearSystem, this);
            hashSet.remove(this);
            addToSolver(linearSystem, constraintWidgetContainer.optimizeFor(64));
        }
        if (i == 0) {
            java.util.HashSet<androidx.constraintlayout.solver.widgets.ConstraintAnchor> dependents = this.mLeft.getDependents();
            if (dependents != null) {
                java.util.Iterator<androidx.constraintlayout.solver.widgets.ConstraintAnchor> it = dependents.iterator();
                while (it.hasNext()) {
                    it.next().mOwner.addChildrenToSolverByDependency(constraintWidgetContainer, linearSystem, hashSet, i, true);
                }
            }
            java.util.HashSet<androidx.constraintlayout.solver.widgets.ConstraintAnchor> dependents2 = this.mRight.getDependents();
            if (dependents2 != null) {
                java.util.Iterator<androidx.constraintlayout.solver.widgets.ConstraintAnchor> it2 = dependents2.iterator();
                while (it2.hasNext()) {
                    it2.next().mOwner.addChildrenToSolverByDependency(constraintWidgetContainer, linearSystem, hashSet, i, true);
                }
                return;
            }
            return;
        }
        java.util.HashSet<androidx.constraintlayout.solver.widgets.ConstraintAnchor> dependents3 = this.mTop.getDependents();
        if (dependents3 != null) {
            java.util.Iterator<androidx.constraintlayout.solver.widgets.ConstraintAnchor> it3 = dependents3.iterator();
            while (it3.hasNext()) {
                it3.next().mOwner.addChildrenToSolverByDependency(constraintWidgetContainer, linearSystem, hashSet, i, true);
            }
        }
        java.util.HashSet<androidx.constraintlayout.solver.widgets.ConstraintAnchor> dependents4 = this.mBottom.getDependents();
        if (dependents4 != null) {
            java.util.Iterator<androidx.constraintlayout.solver.widgets.ConstraintAnchor> it4 = dependents4.iterator();
            while (it4.hasNext()) {
                it4.next().mOwner.addChildrenToSolverByDependency(constraintWidgetContainer, linearSystem, hashSet, i, true);
            }
        }
        java.util.HashSet<androidx.constraintlayout.solver.widgets.ConstraintAnchor> dependents5 = this.mBaseline.getDependents();
        if (dependents5 != null) {
            java.util.Iterator<androidx.constraintlayout.solver.widgets.ConstraintAnchor> it5 = dependents5.iterator();
            while (it5.hasNext()) {
                it5.next().mOwner.addChildrenToSolverByDependency(constraintWidgetContainer, linearSystem, hashSet, i, true);
            }
        }
    }

    public boolean addFirst() {
        return (this instanceof androidx.constraintlayout.solver.widgets.VirtualLayout) || (this instanceof androidx.constraintlayout.solver.widgets.Guideline);
    }

    /* JADX WARN: Removed duplicated region for block: B:140:0x02fb  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x0330  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x0436  */
    /* JADX WARN: Removed duplicated region for block: B:179:0x04ae  */
    /* JADX WARN: Removed duplicated region for block: B:181:0x04b3  */
    /* JADX WARN: Removed duplicated region for block: B:203:0x0544  */
    /* JADX WARN: Removed duplicated region for block: B:206:0x058d  */
    /* JADX WARN: Removed duplicated region for block: B:211:0x05c2  */
    /* JADX WARN: Removed duplicated region for block: B:215:0x05b8  */
    /* JADX WARN: Removed duplicated region for block: B:216:0x0547  */
    /* JADX WARN: Removed duplicated region for block: B:231:0x04b0  */
    /* JADX WARN: Removed duplicated region for block: B:236:0x049a  */
    /* JADX WARN: Removed duplicated region for block: B:237:0x037a  */
    /* JADX WARN: Removed duplicated region for block: B:240:0x038a  */
    /* JADX WARN: Removed duplicated region for block: B:243:0x0399  */
    /* JADX WARN: Removed duplicated region for block: B:246:0x03c2  */
    /* JADX WARN: Removed duplicated region for block: B:248:0x03c5  */
    /* JADX WARN: Removed duplicated region for block: B:249:0x03a2  */
    /* JADX WARN: Removed duplicated region for block: B:250:0x0393  */
    /* JADX WARN: Removed duplicated region for block: B:252:0x02fe  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void addToSolver(androidx.constraintlayout.solver.LinearSystem linearSystem, boolean z) {
        boolean z2;
        boolean z3;
        androidx.constraintlayout.solver.widgets.ConstraintWidget constraintWidget;
        androidx.constraintlayout.solver.widgets.ConstraintWidget constraintWidget2;
        boolean z4;
        boolean z5;
        int i;
        int i2;
        int i3;
        int i4;
        boolean z6;
        int i5;
        boolean z7;
        androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour dimensionBehaviour;
        boolean z8;
        int i6;
        boolean z9;
        boolean z10;
        boolean z11;
        androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour dimensionBehaviour2;
        androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour dimensionBehaviour3;
        boolean z12;
        androidx.constraintlayout.solver.SolverVariable solverVariable;
        androidx.constraintlayout.solver.SolverVariable solverVariable2;
        androidx.constraintlayout.solver.SolverVariable solverVariable3;
        androidx.constraintlayout.solver.SolverVariable solverVariable4;
        boolean z13;
        int i7;
        int i8;
        char c;
        androidx.constraintlayout.solver.widgets.ConstraintWidget constraintWidget3;
        androidx.constraintlayout.solver.LinearSystem linearSystem2;
        androidx.constraintlayout.solver.SolverVariable solverVariable5;
        androidx.constraintlayout.solver.SolverVariable solverVariable6;
        androidx.constraintlayout.solver.SolverVariable solverVariable7;
        boolean z14;
        androidx.constraintlayout.solver.SolverVariable solverVariable8;
        androidx.constraintlayout.solver.SolverVariable solverVariable9;
        androidx.constraintlayout.solver.widgets.ConstraintWidget constraintWidget4;
        boolean z15;
        androidx.constraintlayout.solver.widgets.analyzer.HorizontalWidgetRun horizontalWidgetRun;
        androidx.constraintlayout.solver.widgets.analyzer.DependencyNode dependencyNode;
        int i9;
        boolean isInHorizontalChain;
        boolean isInVerticalChain;
        androidx.constraintlayout.solver.widgets.analyzer.HorizontalWidgetRun horizontalWidgetRun2;
        androidx.constraintlayout.solver.widgets.analyzer.VerticalWidgetRun verticalWidgetRun;
        boolean z16;
        androidx.constraintlayout.solver.SolverVariable createObjectVariable = linearSystem.createObjectVariable(this.mLeft);
        androidx.constraintlayout.solver.SolverVariable createObjectVariable2 = linearSystem.createObjectVariable(this.mRight);
        androidx.constraintlayout.solver.SolverVariable createObjectVariable3 = linearSystem.createObjectVariable(this.mTop);
        androidx.constraintlayout.solver.SolverVariable createObjectVariable4 = linearSystem.createObjectVariable(this.mBottom);
        androidx.constraintlayout.solver.SolverVariable createObjectVariable5 = linearSystem.createObjectVariable(this.mBaseline);
        androidx.constraintlayout.solver.widgets.ConstraintWidget constraintWidget5 = this.mParent;
        if (constraintWidget5 != null) {
            boolean z17 = constraintWidget5 != null && constraintWidget5.mListDimensionBehaviors[0] == androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
            z3 = constraintWidget5 != null && constraintWidget5.mListDimensionBehaviors[1] == androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
            z2 = z17;
        } else {
            z2 = false;
            z3 = false;
        }
        if (this.mVisibility == 8 && !hasDependencies()) {
            boolean[] zArr = this.mIsInBarrier;
            if (!zArr[0] && !zArr[1]) {
                return;
            }
        }
        boolean z18 = this.resolvedHorizontal;
        if (z18 || this.resolvedVertical) {
            if (z18) {
                linearSystem.addEquality(createObjectVariable, this.mX);
                linearSystem.addEquality(createObjectVariable2, this.mX + this.mWidth);
                if (z2 && (constraintWidget2 = this.mParent) != null) {
                    if (this.OPTIMIZE_WRAP_ON_RESOLVED) {
                        androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer constraintWidgetContainer = (androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer) constraintWidget2;
                        constraintWidgetContainer.addVerticalWrapMinVariable(this.mLeft);
                        constraintWidgetContainer.addHorizontalWrapMaxVariable(this.mRight);
                    } else {
                        linearSystem.addGreaterThan(linearSystem.createObjectVariable(constraintWidget2.mRight), createObjectVariable2, 0, 5);
                    }
                }
            }
            if (this.resolvedVertical) {
                linearSystem.addEquality(createObjectVariable3, this.mY);
                linearSystem.addEquality(createObjectVariable4, this.mY + this.mHeight);
                if (this.mBaseline.hasDependents()) {
                    linearSystem.addEquality(createObjectVariable5, this.mY + this.mBaselineDistance);
                }
                if (z3 && (constraintWidget = this.mParent) != null) {
                    if (this.OPTIMIZE_WRAP_ON_RESOLVED) {
                        androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer constraintWidgetContainer2 = (androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer) constraintWidget;
                        constraintWidgetContainer2.addVerticalWrapMinVariable(this.mTop);
                        constraintWidgetContainer2.addVerticalWrapMaxVariable(this.mBottom);
                    } else {
                        linearSystem.addGreaterThan(linearSystem.createObjectVariable(constraintWidget.mBottom), createObjectVariable4, 0, 5);
                    }
                }
            }
            if (this.resolvedHorizontal && this.resolvedVertical) {
                this.resolvedHorizontal = false;
                this.resolvedVertical = false;
                return;
            }
        }
        androidx.constraintlayout.solver.Metrics metrics = androidx.constraintlayout.solver.LinearSystem.sMetrics;
        if (metrics != null) {
            metrics.widgets++;
        }
        if (z && (horizontalWidgetRun2 = this.horizontalRun) != null && (verticalWidgetRun = this.verticalRun) != null) {
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode dependencyNode2 = horizontalWidgetRun2.start;
            if (dependencyNode2.resolved && horizontalWidgetRun2.end.resolved && verticalWidgetRun.start.resolved && verticalWidgetRun.end.resolved) {
                if (metrics != null) {
                    metrics.graphSolved++;
                }
                linearSystem.addEquality(createObjectVariable, dependencyNode2.value);
                linearSystem.addEquality(createObjectVariable2, this.horizontalRun.end.value);
                linearSystem.addEquality(createObjectVariable3, this.verticalRun.start.value);
                linearSystem.addEquality(createObjectVariable4, this.verticalRun.end.value);
                linearSystem.addEquality(createObjectVariable5, this.verticalRun.baseline.value);
                if (this.mParent != null) {
                    if (z2 && this.isTerminalWidget[0] && !isInHorizontalChain()) {
                        linearSystem.addGreaterThan(linearSystem.createObjectVariable(this.mParent.mRight), createObjectVariable2, 0, 8);
                    }
                    if (z3 && this.isTerminalWidget[1] && !isInVerticalChain()) {
                        z16 = false;
                        linearSystem.addGreaterThan(linearSystem.createObjectVariable(this.mParent.mBottom), createObjectVariable4, 0, 8);
                        this.resolvedHorizontal = z16;
                        this.resolvedVertical = z16;
                        return;
                    }
                }
                z16 = false;
                this.resolvedHorizontal = z16;
                this.resolvedVertical = z16;
                return;
            }
        }
        if (metrics != null) {
            metrics.linearSolved++;
        }
        if (this.mParent != null) {
            if (isChainHead(0)) {
                ((androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer) this.mParent).addChain(this, 0);
                isInHorizontalChain = true;
            } else {
                isInHorizontalChain = isInHorizontalChain();
            }
            if (isChainHead(1)) {
                ((androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer) this.mParent).addChain(this, 1);
                isInVerticalChain = true;
            } else {
                isInVerticalChain = isInVerticalChain();
            }
            if (!isInHorizontalChain && z2 && this.mVisibility != 8 && this.mLeft.mTarget == null && this.mRight.mTarget == null) {
                linearSystem.addGreaterThan(linearSystem.createObjectVariable(this.mParent.mRight), createObjectVariable2, 0, 1);
            }
            if (!isInVerticalChain && z3 && this.mVisibility != 8 && this.mTop.mTarget == null && this.mBottom.mTarget == null && this.mBaseline == null) {
                linearSystem.addGreaterThan(linearSystem.createObjectVariable(this.mParent.mBottom), createObjectVariable4, 0, 1);
            }
            z5 = isInHorizontalChain;
            z4 = isInVerticalChain;
        } else {
            z4 = false;
            z5 = false;
        }
        int i10 = this.mWidth;
        int i11 = this.mMinWidth;
        if (i10 >= i11) {
            i11 = i10;
        }
        int i12 = this.mHeight;
        int i13 = this.mMinHeight;
        if (i12 >= i13) {
            i13 = i12;
        }
        androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour[] dimensionBehaviourArr = this.mListDimensionBehaviors;
        androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour dimensionBehaviour4 = dimensionBehaviourArr[0];
        androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour dimensionBehaviour5 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
        int i14 = i11;
        boolean z19 = dimensionBehaviour4 != dimensionBehaviour5;
        androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour dimensionBehaviour6 = dimensionBehaviourArr[1];
        int i15 = i13;
        boolean z20 = dimensionBehaviour6 != dimensionBehaviour5;
        int i16 = this.mDimensionRatioSide;
        this.mResolvedDimensionRatioSide = i16;
        float f = this.mDimensionRatio;
        this.mResolvedDimensionRatio = f;
        int i17 = this.mMatchConstraintDefaultWidth;
        androidx.constraintlayout.solver.SolverVariable solverVariable10 = createObjectVariable2;
        int i18 = this.mMatchConstraintDefaultHeight;
        if (f <= 0.0f || this.mVisibility == 8) {
            i = i17;
            i2 = i18;
            i3 = i14;
            i4 = i15;
            z6 = false;
        } else {
            if (dimensionBehaviour4 == dimensionBehaviour5 && i17 == 0) {
                i17 = 3;
            }
            if (dimensionBehaviour6 == dimensionBehaviour5 && i18 == 0) {
                i18 = 3;
            }
            if (dimensionBehaviour4 == dimensionBehaviour5 && dimensionBehaviour6 == dimensionBehaviour5 && i17 == 3 && i18 == 3) {
                setupDimensionRatio(z2, z3, z19, z20);
            } else if (dimensionBehaviour4 == dimensionBehaviour5 && i17 == 3) {
                this.mResolvedDimensionRatioSide = 0;
                i3 = (int) (f * i12);
                if (dimensionBehaviour6 != dimensionBehaviour5) {
                    i2 = i18;
                    i4 = i15;
                    z6 = false;
                    i = 4;
                } else {
                    i = i17;
                    i2 = i18;
                    i4 = i15;
                    z6 = true;
                }
            } else if (dimensionBehaviour6 == dimensionBehaviour5 && i18 == 3) {
                this.mResolvedDimensionRatioSide = 1;
                if (i16 == -1) {
                    this.mResolvedDimensionRatio = 1.0f / f;
                }
                i4 = (int) (this.mResolvedDimensionRatio * i10);
                i = i17;
                if (dimensionBehaviour4 != dimensionBehaviour5) {
                    i3 = i14;
                    z6 = false;
                    i2 = 4;
                } else {
                    i2 = i18;
                    i3 = i14;
                    z6 = true;
                }
            }
            i = i17;
            i2 = i18;
            i3 = i14;
            i4 = i15;
            z6 = true;
        }
        int[] iArr = this.mResolvedMatchConstraintDefault;
        iArr[0] = i;
        iArr[1] = i2;
        this.mResolvedHasRatio = z6;
        if (z6) {
            int i19 = this.mResolvedDimensionRatioSide;
            i5 = -1;
            if (i19 == 0 || i19 == -1) {
                z7 = true;
                boolean z21 = !z6 && ((i9 = this.mResolvedDimensionRatioSide) == 1 || i9 == i5);
                androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour dimensionBehaviour7 = this.mListDimensionBehaviors[0];
                dimensionBehaviour = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                z8 = dimensionBehaviour7 != dimensionBehaviour && (this instanceof androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer);
                i6 = !z8 ? 0 : i3;
                z9 = !this.mCenter.isConnected();
                boolean[] zArr2 = this.mIsInBarrier;
                z10 = zArr2[0];
                boolean z22 = zArr2[1];
                if (this.mHorizontalResolution != 2 && !this.resolvedHorizontal) {
                    if (z && (horizontalWidgetRun = this.horizontalRun) != null) {
                        dependencyNode = horizontalWidgetRun.start;
                        if (dependencyNode.resolved && horizontalWidgetRun.end.resolved) {
                            if (!z) {
                                linearSystem.addEquality(createObjectVariable, dependencyNode.value);
                                linearSystem.addEquality(solverVariable10, this.horizontalRun.end.value);
                                if (this.mParent != null && z2 && this.isTerminalWidget[0] && !isInHorizontalChain()) {
                                    linearSystem.addGreaterThan(linearSystem.createObjectVariable(this.mParent.mRight), solverVariable10, 0, 8);
                                }
                                z11 = z2;
                                z13 = z3;
                                dimensionBehaviour2 = dimensionBehaviour5;
                                solverVariable10 = solverVariable10;
                                solverVariable4 = createObjectVariable;
                                dimensionBehaviour3 = dimensionBehaviour;
                                z12 = z6;
                                solverVariable = createObjectVariable5;
                                solverVariable2 = createObjectVariable4;
                                solverVariable3 = createObjectVariable3;
                                if (z) {
                                    constraintWidget3 = this;
                                    androidx.constraintlayout.solver.widgets.analyzer.VerticalWidgetRun verticalWidgetRun2 = constraintWidget3.verticalRun;
                                    if (verticalWidgetRun2 != null) {
                                        androidx.constraintlayout.solver.widgets.analyzer.DependencyNode dependencyNode3 = verticalWidgetRun2.start;
                                        if (dependencyNode3.resolved && verticalWidgetRun2.end.resolved) {
                                            linearSystem2 = linearSystem;
                                            solverVariable7 = solverVariable3;
                                            linearSystem2.addEquality(solverVariable7, dependencyNode3.value);
                                            solverVariable6 = solverVariable2;
                                            linearSystem2.addEquality(solverVariable6, constraintWidget3.verticalRun.end.value);
                                            solverVariable5 = solverVariable;
                                            linearSystem2.addEquality(solverVariable5, constraintWidget3.verticalRun.baseline.value);
                                            androidx.constraintlayout.solver.widgets.ConstraintWidget constraintWidget6 = constraintWidget3.mParent;
                                            if (constraintWidget6 == null || z4 || !z13) {
                                                i7 = 8;
                                                i8 = 0;
                                                c = 1;
                                            } else {
                                                c = 1;
                                                if (constraintWidget3.isTerminalWidget[1]) {
                                                    i7 = 8;
                                                    i8 = 0;
                                                    linearSystem2.addGreaterThan(linearSystem2.createObjectVariable(constraintWidget6.mBottom), solverVariable6, 0, 8);
                                                } else {
                                                    i7 = 8;
                                                    i8 = 0;
                                                }
                                            }
                                            z14 = false;
                                            if ((constraintWidget3.mVerticalResolution != 2 ? false : z14) || constraintWidget3.resolvedVertical) {
                                                solverVariable8 = solverVariable6;
                                                solverVariable9 = solverVariable7;
                                            } else {
                                                boolean z23 = constraintWidget3.mListDimensionBehaviors[c] == dimensionBehaviour3 && (constraintWidget3 instanceof androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer);
                                                if (z23) {
                                                    i4 = 0;
                                                }
                                                androidx.constraintlayout.solver.widgets.ConstraintWidget constraintWidget7 = constraintWidget3.mParent;
                                                androidx.constraintlayout.solver.SolverVariable createObjectVariable6 = constraintWidget7 != null ? linearSystem2.createObjectVariable(constraintWidget7.mBottom) : null;
                                                androidx.constraintlayout.solver.widgets.ConstraintWidget constraintWidget8 = constraintWidget3.mParent;
                                                androidx.constraintlayout.solver.SolverVariable createObjectVariable7 = constraintWidget8 != null ? linearSystem2.createObjectVariable(constraintWidget8.mTop) : null;
                                                if (constraintWidget3.mBaselineDistance > 0 || constraintWidget3.mVisibility == i7) {
                                                    if (constraintWidget3.mBaseline.mTarget != null) {
                                                        linearSystem2.addEquality(solverVariable5, solverVariable7, getBaselineDistance(), i7);
                                                        linearSystem2.addEquality(solverVariable5, linearSystem2.createObjectVariable(constraintWidget3.mBaseline.mTarget), i8, i7);
                                                        if (z13) {
                                                            linearSystem2.addGreaterThan(createObjectVariable6, linearSystem2.createObjectVariable(constraintWidget3.mBottom), i8, 5);
                                                        }
                                                        z15 = false;
                                                        boolean z24 = constraintWidget3.isTerminalWidget[c];
                                                        androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour[] dimensionBehaviourArr2 = constraintWidget3.mListDimensionBehaviors;
                                                        solverVariable8 = solverVariable6;
                                                        solverVariable9 = solverVariable7;
                                                        applyConstraints(linearSystem, false, z13, z11, z24, createObjectVariable7, createObjectVariable6, dimensionBehaviourArr2[c], z23, constraintWidget3.mTop, constraintWidget3.mBottom, constraintWidget3.mY, i4, constraintWidget3.mMinHeight, constraintWidget3.mMaxDimension[c], constraintWidget3.mVerticalBiasPercent, z21, dimensionBehaviourArr2[0] != dimensionBehaviour2, z4, z5, z22, i2, i, constraintWidget3.mMatchConstraintMinHeight, constraintWidget3.mMatchConstraintMaxHeight, constraintWidget3.mMatchConstraintPercentHeight, z15);
                                                    } else if (constraintWidget3.mVisibility == i7) {
                                                        linearSystem2.addEquality(solverVariable5, solverVariable7, i8, i7);
                                                    } else {
                                                        linearSystem2.addEquality(solverVariable5, solverVariable7, getBaselineDistance(), i7);
                                                    }
                                                }
                                                z15 = z9;
                                                boolean z242 = constraintWidget3.isTerminalWidget[c];
                                                androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour[] dimensionBehaviourArr22 = constraintWidget3.mListDimensionBehaviors;
                                                solverVariable8 = solverVariable6;
                                                solverVariable9 = solverVariable7;
                                                applyConstraints(linearSystem, false, z13, z11, z242, createObjectVariable7, createObjectVariable6, dimensionBehaviourArr22[c], z23, constraintWidget3.mTop, constraintWidget3.mBottom, constraintWidget3.mY, i4, constraintWidget3.mMinHeight, constraintWidget3.mMaxDimension[c], constraintWidget3.mVerticalBiasPercent, z21, dimensionBehaviourArr22[0] != dimensionBehaviour2, z4, z5, z22, i2, i, constraintWidget3.mMatchConstraintMinHeight, constraintWidget3.mMatchConstraintMaxHeight, constraintWidget3.mMatchConstraintPercentHeight, z15);
                                            }
                                            if (z12) {
                                                constraintWidget4 = this;
                                            } else {
                                                constraintWidget4 = this;
                                                if (constraintWidget4.mResolvedDimensionRatioSide == 1) {
                                                    linearSystem.addRatio(solverVariable8, solverVariable9, solverVariable10, solverVariable4, constraintWidget4.mResolvedDimensionRatio, 8);
                                                } else {
                                                    linearSystem.addRatio(solverVariable10, solverVariable4, solverVariable8, solverVariable9, constraintWidget4.mResolvedDimensionRatio, 8);
                                                }
                                            }
                                            if (constraintWidget4.mCenter.isConnected()) {
                                                linearSystem.addCenterPoint(constraintWidget4, constraintWidget4.mCenter.getTarget().getOwner(), (float) java.lang.Math.toRadians(constraintWidget4.mCircleConstraintAngle + 90.0f), constraintWidget4.mCenter.getMargin());
                                            }
                                            constraintWidget4.resolvedHorizontal = false;
                                            constraintWidget4.resolvedVertical = false;
                                        }
                                    }
                                    linearSystem2 = linearSystem;
                                    solverVariable5 = solverVariable;
                                    solverVariable6 = solverVariable2;
                                    solverVariable7 = solverVariable3;
                                    i7 = 8;
                                    i8 = 0;
                                    c = 1;
                                } else {
                                    i7 = 8;
                                    i8 = 0;
                                    c = 1;
                                    constraintWidget3 = this;
                                    linearSystem2 = linearSystem;
                                    solverVariable5 = solverVariable;
                                    solverVariable6 = solverVariable2;
                                    solverVariable7 = solverVariable3;
                                }
                                z14 = true;
                                if (constraintWidget3.mVerticalResolution != 2 ? false : z14) {
                                }
                                solverVariable8 = solverVariable6;
                                solverVariable9 = solverVariable7;
                                if (z12) {
                                }
                                if (constraintWidget4.mCenter.isConnected()) {
                                }
                                constraintWidget4.resolvedHorizontal = false;
                                constraintWidget4.resolvedVertical = false;
                            }
                        }
                    }
                    androidx.constraintlayout.solver.widgets.ConstraintWidget constraintWidget9 = this.mParent;
                    androidx.constraintlayout.solver.SolverVariable createObjectVariable8 = constraintWidget9 == null ? linearSystem.createObjectVariable(constraintWidget9.mRight) : null;
                    androidx.constraintlayout.solver.widgets.ConstraintWidget constraintWidget10 = this.mParent;
                    androidx.constraintlayout.solver.SolverVariable createObjectVariable9 = constraintWidget10 == null ? linearSystem.createObjectVariable(constraintWidget10.mLeft) : null;
                    boolean z25 = this.isTerminalWidget[0];
                    androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour[] dimensionBehaviourArr3 = this.mListDimensionBehaviors;
                    z11 = z2;
                    z13 = z3;
                    dimensionBehaviour2 = dimensionBehaviour5;
                    solverVariable = createObjectVariable5;
                    solverVariable2 = createObjectVariable4;
                    solverVariable3 = createObjectVariable3;
                    solverVariable10 = solverVariable10;
                    dimensionBehaviour3 = dimensionBehaviour;
                    solverVariable4 = createObjectVariable;
                    z12 = z6;
                    applyConstraints(linearSystem, true, z2, z3, z25, createObjectVariable9, createObjectVariable8, dimensionBehaviourArr3[0], z8, this.mLeft, this.mRight, this.mX, i6, this.mMinWidth, this.mMaxDimension[0], this.mHorizontalBiasPercent, z7, dimensionBehaviourArr3[1] != dimensionBehaviour5, z5, z4, z10, i, i2, this.mMatchConstraintMinWidth, this.mMatchConstraintMaxWidth, this.mMatchConstraintPercentWidth, z9);
                    if (z) {
                    }
                    z14 = true;
                    if (constraintWidget3.mVerticalResolution != 2 ? false : z14) {
                    }
                    solverVariable8 = solverVariable6;
                    solverVariable9 = solverVariable7;
                    if (z12) {
                    }
                    if (constraintWidget4.mCenter.isConnected()) {
                    }
                    constraintWidget4.resolvedHorizontal = false;
                    constraintWidget4.resolvedVertical = false;
                }
                z11 = z2;
                dimensionBehaviour2 = dimensionBehaviour5;
                dimensionBehaviour3 = dimensionBehaviour;
                z12 = z6;
                solverVariable = createObjectVariable5;
                solverVariable2 = createObjectVariable4;
                solverVariable3 = createObjectVariable3;
                solverVariable4 = createObjectVariable;
                z13 = z3;
                if (z) {
                }
                z14 = true;
                if (constraintWidget3.mVerticalResolution != 2 ? false : z14) {
                }
                solverVariable8 = solverVariable6;
                solverVariable9 = solverVariable7;
                if (z12) {
                }
                if (constraintWidget4.mCenter.isConnected()) {
                }
                constraintWidget4.resolvedHorizontal = false;
                constraintWidget4.resolvedVertical = false;
            }
        } else {
            i5 = -1;
        }
        z7 = false;
        if (z6) {
        }
        androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour dimensionBehaviour72 = this.mListDimensionBehaviors[0];
        dimensionBehaviour = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        if (dimensionBehaviour72 != dimensionBehaviour) {
        }
        if (!z8) {
        }
        z9 = !this.mCenter.isConnected();
        boolean[] zArr22 = this.mIsInBarrier;
        z10 = zArr22[0];
        boolean z222 = zArr22[1];
        if (this.mHorizontalResolution != 2) {
            if (z) {
                dependencyNode = horizontalWidgetRun.start;
                if (dependencyNode.resolved) {
                    if (!z) {
                    }
                }
            }
            androidx.constraintlayout.solver.widgets.ConstraintWidget constraintWidget92 = this.mParent;
            if (constraintWidget92 == null) {
            }
            androidx.constraintlayout.solver.widgets.ConstraintWidget constraintWidget102 = this.mParent;
            if (constraintWidget102 == null) {
            }
            boolean z252 = this.isTerminalWidget[0];
            androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour[] dimensionBehaviourArr32 = this.mListDimensionBehaviors;
            z11 = z2;
            z13 = z3;
            dimensionBehaviour2 = dimensionBehaviour5;
            solverVariable = createObjectVariable5;
            solverVariable2 = createObjectVariable4;
            solverVariable3 = createObjectVariable3;
            solverVariable10 = solverVariable10;
            dimensionBehaviour3 = dimensionBehaviour;
            solverVariable4 = createObjectVariable;
            z12 = z6;
            applyConstraints(linearSystem, true, z2, z3, z252, createObjectVariable9, createObjectVariable8, dimensionBehaviourArr32[0], z8, this.mLeft, this.mRight, this.mX, i6, this.mMinWidth, this.mMaxDimension[0], this.mHorizontalBiasPercent, z7, dimensionBehaviourArr32[1] != dimensionBehaviour5, z5, z4, z10, i, i2, this.mMatchConstraintMinWidth, this.mMatchConstraintMaxWidth, this.mMatchConstraintPercentWidth, z9);
            if (z) {
            }
            z14 = true;
            if (constraintWidget3.mVerticalResolution != 2 ? false : z14) {
            }
            solverVariable8 = solverVariable6;
            solverVariable9 = solverVariable7;
            if (z12) {
            }
            if (constraintWidget4.mCenter.isConnected()) {
            }
            constraintWidget4.resolvedHorizontal = false;
            constraintWidget4.resolvedVertical = false;
        }
        z11 = z2;
        dimensionBehaviour2 = dimensionBehaviour5;
        dimensionBehaviour3 = dimensionBehaviour;
        z12 = z6;
        solverVariable = createObjectVariable5;
        solverVariable2 = createObjectVariable4;
        solverVariable3 = createObjectVariable3;
        solverVariable4 = createObjectVariable;
        z13 = z3;
        if (z) {
        }
        z14 = true;
        if (constraintWidget3.mVerticalResolution != 2 ? false : z14) {
        }
        solverVariable8 = solverVariable6;
        solverVariable9 = solverVariable7;
        if (z12) {
        }
        if (constraintWidget4.mCenter.isConnected()) {
        }
        constraintWidget4.resolvedHorizontal = false;
        constraintWidget4.resolvedVertical = false;
    }

    public boolean allowedInBarrier() {
        return this.mVisibility != 8;
    }

    public void connect(androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type type, androidx.constraintlayout.solver.widgets.ConstraintWidget constraintWidget, androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type type2) {
        connect(type, constraintWidget, type2, 0);
    }

    public void connect(androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type type, androidx.constraintlayout.solver.widgets.ConstraintWidget constraintWidget, androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type type2, int i) {
        androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type type3;
        androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type type4;
        boolean z;
        androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type type5 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.CENTER;
        if (type == type5) {
            if (type2 != type5) {
                androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type type6 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.LEFT;
                if (type2 == type6 || type2 == androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.RIGHT) {
                    connect(type6, constraintWidget, type2, 0);
                    connect(androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.RIGHT, constraintWidget, type2, 0);
                    getAnchor(type5).connect(constraintWidget.getAnchor(type2), 0);
                    return;
                }
                androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type type7 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.TOP;
                if (type2 == type7 || type2 == androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.BOTTOM) {
                    connect(type7, constraintWidget, type2, 0);
                    connect(androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.BOTTOM, constraintWidget, type2, 0);
                    getAnchor(type5).connect(constraintWidget.getAnchor(type2), 0);
                    return;
                }
                return;
            }
            androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type type8 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.LEFT;
            androidx.constraintlayout.solver.widgets.ConstraintAnchor anchor = getAnchor(type8);
            androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type type9 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.RIGHT;
            androidx.constraintlayout.solver.widgets.ConstraintAnchor anchor2 = getAnchor(type9);
            androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type type10 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.TOP;
            androidx.constraintlayout.solver.widgets.ConstraintAnchor anchor3 = getAnchor(type10);
            androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type type11 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.BOTTOM;
            androidx.constraintlayout.solver.widgets.ConstraintAnchor anchor4 = getAnchor(type11);
            boolean z2 = true;
            if ((anchor == null || !anchor.isConnected()) && (anchor2 == null || !anchor2.isConnected())) {
                connect(type8, constraintWidget, type8, 0);
                connect(type9, constraintWidget, type9, 0);
                z = true;
            } else {
                z = false;
            }
            if ((anchor3 == null || !anchor3.isConnected()) && (anchor4 == null || !anchor4.isConnected())) {
                connect(type10, constraintWidget, type10, 0);
                connect(type11, constraintWidget, type11, 0);
            } else {
                z2 = false;
            }
            if (z && z2) {
                getAnchor(type5).connect(constraintWidget.getAnchor(type5), 0);
                return;
            }
            if (z) {
                androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type type12 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.CENTER_X;
                getAnchor(type12).connect(constraintWidget.getAnchor(type12), 0);
                return;
            } else {
                if (z2) {
                    androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type type13 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.CENTER_Y;
                    getAnchor(type13).connect(constraintWidget.getAnchor(type13), 0);
                    return;
                }
                return;
            }
        }
        androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type type14 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.CENTER_X;
        if (type == type14 && (type2 == (type4 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.LEFT) || type2 == androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.RIGHT)) {
            androidx.constraintlayout.solver.widgets.ConstraintAnchor anchor5 = getAnchor(type4);
            androidx.constraintlayout.solver.widgets.ConstraintAnchor anchor6 = constraintWidget.getAnchor(type2);
            androidx.constraintlayout.solver.widgets.ConstraintAnchor anchor7 = getAnchor(androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.RIGHT);
            anchor5.connect(anchor6, 0);
            anchor7.connect(anchor6, 0);
            getAnchor(type14).connect(anchor6, 0);
            return;
        }
        androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type type15 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.CENTER_Y;
        if (type == type15 && (type2 == (type3 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.TOP) || type2 == androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.BOTTOM)) {
            androidx.constraintlayout.solver.widgets.ConstraintAnchor anchor8 = constraintWidget.getAnchor(type2);
            getAnchor(type3).connect(anchor8, 0);
            getAnchor(androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.BOTTOM).connect(anchor8, 0);
            getAnchor(type15).connect(anchor8, 0);
            return;
        }
        if (type == type14 && type2 == type14) {
            androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type type16 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.LEFT;
            getAnchor(type16).connect(constraintWidget.getAnchor(type16), 0);
            androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type type17 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.RIGHT;
            getAnchor(type17).connect(constraintWidget.getAnchor(type17), 0);
            getAnchor(type14).connect(constraintWidget.getAnchor(type2), 0);
            return;
        }
        if (type == type15 && type2 == type15) {
            androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type type18 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.TOP;
            getAnchor(type18).connect(constraintWidget.getAnchor(type18), 0);
            androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type type19 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.BOTTOM;
            getAnchor(type19).connect(constraintWidget.getAnchor(type19), 0);
            getAnchor(type15).connect(constraintWidget.getAnchor(type2), 0);
            return;
        }
        androidx.constraintlayout.solver.widgets.ConstraintAnchor anchor9 = getAnchor(type);
        androidx.constraintlayout.solver.widgets.ConstraintAnchor anchor10 = constraintWidget.getAnchor(type2);
        if (anchor9.isValidConnection(anchor10)) {
            androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type type20 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.BASELINE;
            if (type == type20) {
                androidx.constraintlayout.solver.widgets.ConstraintAnchor anchor11 = getAnchor(androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.TOP);
                androidx.constraintlayout.solver.widgets.ConstraintAnchor anchor12 = getAnchor(androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.BOTTOM);
                if (anchor11 != null) {
                    anchor11.reset();
                }
                if (anchor12 != null) {
                    anchor12.reset();
                }
                i = 0;
            } else if (type == androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.TOP || type == androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.BOTTOM) {
                androidx.constraintlayout.solver.widgets.ConstraintAnchor anchor13 = getAnchor(type20);
                if (anchor13 != null) {
                    anchor13.reset();
                }
                androidx.constraintlayout.solver.widgets.ConstraintAnchor anchor14 = getAnchor(type5);
                if (anchor14.getTarget() != anchor10) {
                    anchor14.reset();
                }
                androidx.constraintlayout.solver.widgets.ConstraintAnchor opposite = getAnchor(type).getOpposite();
                androidx.constraintlayout.solver.widgets.ConstraintAnchor anchor15 = getAnchor(type15);
                if (anchor15.isConnected()) {
                    opposite.reset();
                    anchor15.reset();
                }
            } else if (type == androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.LEFT || type == androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.RIGHT) {
                androidx.constraintlayout.solver.widgets.ConstraintAnchor anchor16 = getAnchor(type5);
                if (anchor16.getTarget() != anchor10) {
                    anchor16.reset();
                }
                androidx.constraintlayout.solver.widgets.ConstraintAnchor opposite2 = getAnchor(type).getOpposite();
                androidx.constraintlayout.solver.widgets.ConstraintAnchor anchor17 = getAnchor(type14);
                if (anchor17.isConnected()) {
                    opposite2.reset();
                    anchor17.reset();
                }
            }
            anchor9.connect(anchor10, i);
        }
    }

    public void connect(androidx.constraintlayout.solver.widgets.ConstraintAnchor constraintAnchor, androidx.constraintlayout.solver.widgets.ConstraintAnchor constraintAnchor2, int i) {
        if (constraintAnchor.getOwner() == this) {
            connect(constraintAnchor.getType(), constraintAnchor2.getOwner(), constraintAnchor2.getType(), i);
        }
    }

    public void connectCircularConstraint(androidx.constraintlayout.solver.widgets.ConstraintWidget constraintWidget, float f, int i) {
        androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type type = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.CENTER;
        immediateConnect(type, constraintWidget, type, i, 0);
        this.mCircleConstraintAngle = f;
    }

    public void copy(androidx.constraintlayout.solver.widgets.ConstraintWidget constraintWidget, java.util.HashMap<androidx.constraintlayout.solver.widgets.ConstraintWidget, androidx.constraintlayout.solver.widgets.ConstraintWidget> hashMap) {
        this.mHorizontalResolution = constraintWidget.mHorizontalResolution;
        this.mVerticalResolution = constraintWidget.mVerticalResolution;
        this.mMatchConstraintDefaultWidth = constraintWidget.mMatchConstraintDefaultWidth;
        this.mMatchConstraintDefaultHeight = constraintWidget.mMatchConstraintDefaultHeight;
        int[] iArr = this.mResolvedMatchConstraintDefault;
        int[] iArr2 = constraintWidget.mResolvedMatchConstraintDefault;
        iArr[0] = iArr2[0];
        iArr[1] = iArr2[1];
        this.mMatchConstraintMinWidth = constraintWidget.mMatchConstraintMinWidth;
        this.mMatchConstraintMaxWidth = constraintWidget.mMatchConstraintMaxWidth;
        this.mMatchConstraintMinHeight = constraintWidget.mMatchConstraintMinHeight;
        this.mMatchConstraintMaxHeight = constraintWidget.mMatchConstraintMaxHeight;
        this.mMatchConstraintPercentHeight = constraintWidget.mMatchConstraintPercentHeight;
        this.mIsWidthWrapContent = constraintWidget.mIsWidthWrapContent;
        this.mIsHeightWrapContent = constraintWidget.mIsHeightWrapContent;
        this.mResolvedDimensionRatioSide = constraintWidget.mResolvedDimensionRatioSide;
        this.mResolvedDimensionRatio = constraintWidget.mResolvedDimensionRatio;
        int[] iArr3 = constraintWidget.mMaxDimension;
        this.mMaxDimension = java.util.Arrays.copyOf(iArr3, iArr3.length);
        this.mCircleConstraintAngle = constraintWidget.mCircleConstraintAngle;
        this.hasBaseline = constraintWidget.hasBaseline;
        this.inPlaceholder = constraintWidget.inPlaceholder;
        this.mLeft.reset();
        this.mTop.reset();
        this.mRight.reset();
        this.mBottom.reset();
        this.mBaseline.reset();
        this.mCenterX.reset();
        this.mCenterY.reset();
        this.mCenter.reset();
        this.mListDimensionBehaviors = (androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour[]) java.util.Arrays.copyOf(this.mListDimensionBehaviors, 2);
        this.mParent = this.mParent == null ? null : hashMap.get(constraintWidget.mParent);
        this.mWidth = constraintWidget.mWidth;
        this.mHeight = constraintWidget.mHeight;
        this.mDimensionRatio = constraintWidget.mDimensionRatio;
        this.mDimensionRatioSide = constraintWidget.mDimensionRatioSide;
        this.mX = constraintWidget.mX;
        this.mY = constraintWidget.mY;
        this.mRelX = constraintWidget.mRelX;
        this.mRelY = constraintWidget.mRelY;
        this.mOffsetX = constraintWidget.mOffsetX;
        this.mOffsetY = constraintWidget.mOffsetY;
        this.mBaselineDistance = constraintWidget.mBaselineDistance;
        this.mMinWidth = constraintWidget.mMinWidth;
        this.mMinHeight = constraintWidget.mMinHeight;
        this.mHorizontalBiasPercent = constraintWidget.mHorizontalBiasPercent;
        this.mVerticalBiasPercent = constraintWidget.mVerticalBiasPercent;
        this.mCompanionWidget = constraintWidget.mCompanionWidget;
        this.mContainerItemSkip = constraintWidget.mContainerItemSkip;
        this.mVisibility = constraintWidget.mVisibility;
        this.mDebugName = constraintWidget.mDebugName;
        this.mType = constraintWidget.mType;
        this.mDistToTop = constraintWidget.mDistToTop;
        this.mDistToLeft = constraintWidget.mDistToLeft;
        this.mDistToRight = constraintWidget.mDistToRight;
        this.mDistToBottom = constraintWidget.mDistToBottom;
        this.mLeftHasCentered = constraintWidget.mLeftHasCentered;
        this.mRightHasCentered = constraintWidget.mRightHasCentered;
        this.mTopHasCentered = constraintWidget.mTopHasCentered;
        this.mBottomHasCentered = constraintWidget.mBottomHasCentered;
        this.mHorizontalWrapVisited = constraintWidget.mHorizontalWrapVisited;
        this.mVerticalWrapVisited = constraintWidget.mVerticalWrapVisited;
        this.mHorizontalChainStyle = constraintWidget.mHorizontalChainStyle;
        this.mVerticalChainStyle = constraintWidget.mVerticalChainStyle;
        this.mHorizontalChainFixedPosition = constraintWidget.mHorizontalChainFixedPosition;
        this.mVerticalChainFixedPosition = constraintWidget.mVerticalChainFixedPosition;
        float[] fArr = this.mWeight;
        float[] fArr2 = constraintWidget.mWeight;
        fArr[0] = fArr2[0];
        fArr[1] = fArr2[1];
        androidx.constraintlayout.solver.widgets.ConstraintWidget[] constraintWidgetArr = this.mListNextMatchConstraintsWidget;
        androidx.constraintlayout.solver.widgets.ConstraintWidget[] constraintWidgetArr2 = constraintWidget.mListNextMatchConstraintsWidget;
        constraintWidgetArr[0] = constraintWidgetArr2[0];
        constraintWidgetArr[1] = constraintWidgetArr2[1];
        androidx.constraintlayout.solver.widgets.ConstraintWidget[] constraintWidgetArr3 = this.mNextChainWidget;
        androidx.constraintlayout.solver.widgets.ConstraintWidget[] constraintWidgetArr4 = constraintWidget.mNextChainWidget;
        constraintWidgetArr3[0] = constraintWidgetArr4[0];
        constraintWidgetArr3[1] = constraintWidgetArr4[1];
        androidx.constraintlayout.solver.widgets.ConstraintWidget constraintWidget2 = constraintWidget.mHorizontalNextWidget;
        this.mHorizontalNextWidget = constraintWidget2 == null ? null : hashMap.get(constraintWidget2);
        androidx.constraintlayout.solver.widgets.ConstraintWidget constraintWidget3 = constraintWidget.mVerticalNextWidget;
        this.mVerticalNextWidget = constraintWidget3 != null ? hashMap.get(constraintWidget3) : null;
    }

    public void createObjectVariables(androidx.constraintlayout.solver.LinearSystem linearSystem) {
        linearSystem.createObjectVariable(this.mLeft);
        linearSystem.createObjectVariable(this.mTop);
        linearSystem.createObjectVariable(this.mRight);
        linearSystem.createObjectVariable(this.mBottom);
        if (this.mBaselineDistance > 0) {
            linearSystem.createObjectVariable(this.mBaseline);
        }
    }

    public void ensureMeasureRequested() {
        this.mMeasureRequested = true;
    }

    public void ensureWidgetRuns() {
        if (this.horizontalRun == null) {
            this.horizontalRun = new androidx.constraintlayout.solver.widgets.analyzer.HorizontalWidgetRun(this);
        }
        if (this.verticalRun == null) {
            this.verticalRun = new androidx.constraintlayout.solver.widgets.analyzer.VerticalWidgetRun(this);
        }
    }

    public androidx.constraintlayout.solver.widgets.ConstraintAnchor getAnchor(androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type type) {
        switch (androidx.constraintlayout.solver.widgets.ConstraintWidget.AnonymousClass1.$SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[type.ordinal()]) {
            case 1:
                return this.mLeft;
            case 2:
                return this.mTop;
            case 3:
                return this.mRight;
            case 4:
                return this.mBottom;
            case 5:
                return this.mBaseline;
            case 6:
                return this.mCenter;
            case 7:
                return this.mCenterX;
            case 8:
                return this.mCenterY;
            case 9:
                return null;
            default:
                throw new java.lang.AssertionError(type.name());
        }
    }

    public java.util.ArrayList<androidx.constraintlayout.solver.widgets.ConstraintAnchor> getAnchors() {
        return this.mAnchors;
    }

    public int getBaselineDistance() {
        return this.mBaselineDistance;
    }

    public float getBiasPercent(int i) {
        if (i == 0) {
            return this.mHorizontalBiasPercent;
        }
        if (i == 1) {
            return this.mVerticalBiasPercent;
        }
        return -1.0f;
    }

    public int getBottom() {
        return getY() + this.mHeight;
    }

    public java.lang.Object getCompanionWidget() {
        return this.mCompanionWidget;
    }

    public int getContainerItemSkip() {
        return this.mContainerItemSkip;
    }

    public java.lang.String getDebugName() {
        return this.mDebugName;
    }

    public androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour getDimensionBehaviour(int i) {
        if (i == 0) {
            return getHorizontalDimensionBehaviour();
        }
        if (i == 1) {
            return getVerticalDimensionBehaviour();
        }
        return null;
    }

    public float getDimensionRatio() {
        return this.mDimensionRatio;
    }

    public int getDimensionRatioSide() {
        return this.mDimensionRatioSide;
    }

    public boolean getHasBaseline() {
        return this.hasBaseline;
    }

    public int getHeight() {
        if (this.mVisibility == 8) {
            return 0;
        }
        return this.mHeight;
    }

    public float getHorizontalBiasPercent() {
        return this.mHorizontalBiasPercent;
    }

    public androidx.constraintlayout.solver.widgets.ConstraintWidget getHorizontalChainControlWidget() {
        if (!isInHorizontalChain()) {
            return null;
        }
        androidx.constraintlayout.solver.widgets.ConstraintWidget constraintWidget = this;
        androidx.constraintlayout.solver.widgets.ConstraintWidget constraintWidget2 = null;
        while (constraintWidget2 == null && constraintWidget != null) {
            androidx.constraintlayout.solver.widgets.ConstraintAnchor anchor = constraintWidget.getAnchor(androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.LEFT);
            androidx.constraintlayout.solver.widgets.ConstraintAnchor target = anchor == null ? null : anchor.getTarget();
            androidx.constraintlayout.solver.widgets.ConstraintWidget owner = target == null ? null : target.getOwner();
            if (owner == getParent()) {
                return constraintWidget;
            }
            androidx.constraintlayout.solver.widgets.ConstraintAnchor target2 = owner == null ? null : owner.getAnchor(androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.RIGHT).getTarget();
            if (target2 == null || target2.getOwner() == constraintWidget) {
                constraintWidget = owner;
            } else {
                constraintWidget2 = constraintWidget;
            }
        }
        return constraintWidget2;
    }

    public int getHorizontalChainStyle() {
        return this.mHorizontalChainStyle;
    }

    public androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour getHorizontalDimensionBehaviour() {
        return this.mListDimensionBehaviors[0];
    }

    public int getHorizontalMargin() {
        androidx.constraintlayout.solver.widgets.ConstraintAnchor constraintAnchor = this.mLeft;
        int i = constraintAnchor != null ? 0 + constraintAnchor.mMargin : 0;
        androidx.constraintlayout.solver.widgets.ConstraintAnchor constraintAnchor2 = this.mRight;
        return constraintAnchor2 != null ? i + constraintAnchor2.mMargin : i;
    }

    public int getLastHorizontalMeasureSpec() {
        return this.mLastHorizontalMeasureSpec;
    }

    public int getLastVerticalMeasureSpec() {
        return this.mLastVerticalMeasureSpec;
    }

    public int getLeft() {
        return getX();
    }

    public int getLength(int i) {
        if (i == 0) {
            return getWidth();
        }
        if (i == 1) {
            return getHeight();
        }
        return 0;
    }

    public int getMaxHeight() {
        return this.mMaxDimension[1];
    }

    public int getMaxWidth() {
        return this.mMaxDimension[0];
    }

    public int getMinHeight() {
        return this.mMinHeight;
    }

    public int getMinWidth() {
        return this.mMinWidth;
    }

    public androidx.constraintlayout.solver.widgets.ConstraintWidget getNextChainMember(int i) {
        androidx.constraintlayout.solver.widgets.ConstraintAnchor constraintAnchor;
        androidx.constraintlayout.solver.widgets.ConstraintAnchor constraintAnchor2;
        if (i != 0) {
            if (i == 1 && (constraintAnchor2 = (constraintAnchor = this.mBottom).mTarget) != null && constraintAnchor2.mTarget == constraintAnchor) {
                return constraintAnchor2.mOwner;
            }
            return null;
        }
        androidx.constraintlayout.solver.widgets.ConstraintAnchor constraintAnchor3 = this.mRight;
        androidx.constraintlayout.solver.widgets.ConstraintAnchor constraintAnchor4 = constraintAnchor3.mTarget;
        if (constraintAnchor4 == null || constraintAnchor4.mTarget != constraintAnchor3) {
            return null;
        }
        return constraintAnchor4.mOwner;
    }

    public int getOptimizerWrapHeight() {
        int i;
        int i2 = this.mHeight;
        if (this.mListDimensionBehaviors[1] != androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
            return i2;
        }
        if (this.mMatchConstraintDefaultHeight == 1) {
            i = java.lang.Math.max(this.mMatchConstraintMinHeight, i2);
        } else {
            i = this.mMatchConstraintMinHeight;
            if (i > 0) {
                this.mHeight = i;
            } else {
                i = 0;
            }
        }
        int i3 = this.mMatchConstraintMaxHeight;
        return (i3 <= 0 || i3 >= i) ? i : i3;
    }

    public int getOptimizerWrapWidth() {
        int i;
        int i2 = this.mWidth;
        if (this.mListDimensionBehaviors[0] != androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
            return i2;
        }
        if (this.mMatchConstraintDefaultWidth == 1) {
            i = java.lang.Math.max(this.mMatchConstraintMinWidth, i2);
        } else {
            i = this.mMatchConstraintMinWidth;
            if (i > 0) {
                this.mWidth = i;
            } else {
                i = 0;
            }
        }
        int i3 = this.mMatchConstraintMaxWidth;
        return (i3 <= 0 || i3 >= i) ? i : i3;
    }

    public androidx.constraintlayout.solver.widgets.ConstraintWidget getParent() {
        return this.mParent;
    }

    public androidx.constraintlayout.solver.widgets.ConstraintWidget getPreviousChainMember(int i) {
        androidx.constraintlayout.solver.widgets.ConstraintAnchor constraintAnchor;
        androidx.constraintlayout.solver.widgets.ConstraintAnchor constraintAnchor2;
        if (i != 0) {
            if (i == 1 && (constraintAnchor2 = (constraintAnchor = this.mTop).mTarget) != null && constraintAnchor2.mTarget == constraintAnchor) {
                return constraintAnchor2.mOwner;
            }
            return null;
        }
        androidx.constraintlayout.solver.widgets.ConstraintAnchor constraintAnchor3 = this.mLeft;
        androidx.constraintlayout.solver.widgets.ConstraintAnchor constraintAnchor4 = constraintAnchor3.mTarget;
        if (constraintAnchor4 == null || constraintAnchor4.mTarget != constraintAnchor3) {
            return null;
        }
        return constraintAnchor4.mOwner;
    }

    public int getRelativePositioning(int i) {
        if (i == 0) {
            return this.mRelX;
        }
        if (i == 1) {
            return this.mRelY;
        }
        return 0;
    }

    public int getRight() {
        return getX() + this.mWidth;
    }

    public int getRootX() {
        return this.mX + this.mOffsetX;
    }

    public int getRootY() {
        return this.mY + this.mOffsetY;
    }

    public androidx.constraintlayout.solver.widgets.analyzer.WidgetRun getRun(int i) {
        if (i == 0) {
            return this.horizontalRun;
        }
        if (i == 1) {
            return this.verticalRun;
        }
        return null;
    }

    public int getTop() {
        return getY();
    }

    public java.lang.String getType() {
        return this.mType;
    }

    public float getVerticalBiasPercent() {
        return this.mVerticalBiasPercent;
    }

    public androidx.constraintlayout.solver.widgets.ConstraintWidget getVerticalChainControlWidget() {
        if (!isInVerticalChain()) {
            return null;
        }
        androidx.constraintlayout.solver.widgets.ConstraintWidget constraintWidget = this;
        androidx.constraintlayout.solver.widgets.ConstraintWidget constraintWidget2 = null;
        while (constraintWidget2 == null && constraintWidget != null) {
            androidx.constraintlayout.solver.widgets.ConstraintAnchor anchor = constraintWidget.getAnchor(androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.TOP);
            androidx.constraintlayout.solver.widgets.ConstraintAnchor target = anchor == null ? null : anchor.getTarget();
            androidx.constraintlayout.solver.widgets.ConstraintWidget owner = target == null ? null : target.getOwner();
            if (owner == getParent()) {
                return constraintWidget;
            }
            androidx.constraintlayout.solver.widgets.ConstraintAnchor target2 = owner == null ? null : owner.getAnchor(androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.BOTTOM).getTarget();
            if (target2 == null || target2.getOwner() == constraintWidget) {
                constraintWidget = owner;
            } else {
                constraintWidget2 = constraintWidget;
            }
        }
        return constraintWidget2;
    }

    public int getVerticalChainStyle() {
        return this.mVerticalChainStyle;
    }

    public androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour getVerticalDimensionBehaviour() {
        return this.mListDimensionBehaviors[1];
    }

    public int getVerticalMargin() {
        int i = this.mLeft != null ? 0 + this.mTop.mMargin : 0;
        return this.mRight != null ? i + this.mBottom.mMargin : i;
    }

    public int getVisibility() {
        return this.mVisibility;
    }

    public int getWidth() {
        if (this.mVisibility == 8) {
            return 0;
        }
        return this.mWidth;
    }

    public int getX() {
        androidx.constraintlayout.solver.widgets.ConstraintWidget constraintWidget = this.mParent;
        return (constraintWidget == null || !(constraintWidget instanceof androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer)) ? this.mX : ((androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer) constraintWidget).mPaddingLeft + this.mX;
    }

    public int getY() {
        androidx.constraintlayout.solver.widgets.ConstraintWidget constraintWidget = this.mParent;
        return (constraintWidget == null || !(constraintWidget instanceof androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer)) ? this.mY : ((androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer) constraintWidget).mPaddingTop + this.mY;
    }

    public boolean hasBaseline() {
        return this.hasBaseline;
    }

    public boolean hasDanglingDimension(int i) {
        if (i == 0) {
            return (this.mLeft.mTarget != null ? 1 : 0) + (this.mRight.mTarget != null ? 1 : 0) < 2;
        }
        return ((this.mTop.mTarget != null ? 1 : 0) + (this.mBottom.mTarget != null ? 1 : 0)) + (this.mBaseline.mTarget != null ? 1 : 0) < 2;
    }

    public boolean hasDependencies() {
        int size = this.mAnchors.size();
        for (int i = 0; i < size; i++) {
            if (this.mAnchors.get(i).hasDependents()) {
                return true;
            }
        }
        return false;
    }

    public void immediateConnect(androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type type, androidx.constraintlayout.solver.widgets.ConstraintWidget constraintWidget, androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type type2, int i, int i2) {
        getAnchor(type).connect(constraintWidget.getAnchor(type2), i, i2, true);
    }

    public boolean isHeightWrapContent() {
        return this.mIsHeightWrapContent;
    }

    public boolean isInHorizontalChain() {
        androidx.constraintlayout.solver.widgets.ConstraintAnchor constraintAnchor = this.mLeft;
        androidx.constraintlayout.solver.widgets.ConstraintAnchor constraintAnchor2 = constraintAnchor.mTarget;
        if (constraintAnchor2 != null && constraintAnchor2.mTarget == constraintAnchor) {
            return true;
        }
        androidx.constraintlayout.solver.widgets.ConstraintAnchor constraintAnchor3 = this.mRight;
        androidx.constraintlayout.solver.widgets.ConstraintAnchor constraintAnchor4 = constraintAnchor3.mTarget;
        return constraintAnchor4 != null && constraintAnchor4.mTarget == constraintAnchor3;
    }

    public boolean isInPlaceholder() {
        return this.inPlaceholder;
    }

    public boolean isInVerticalChain() {
        androidx.constraintlayout.solver.widgets.ConstraintAnchor constraintAnchor = this.mTop;
        androidx.constraintlayout.solver.widgets.ConstraintAnchor constraintAnchor2 = constraintAnchor.mTarget;
        if (constraintAnchor2 != null && constraintAnchor2.mTarget == constraintAnchor) {
            return true;
        }
        androidx.constraintlayout.solver.widgets.ConstraintAnchor constraintAnchor3 = this.mBottom;
        androidx.constraintlayout.solver.widgets.ConstraintAnchor constraintAnchor4 = constraintAnchor3.mTarget;
        return constraintAnchor4 != null && constraintAnchor4.mTarget == constraintAnchor3;
    }

    public boolean isInVirtualLayout() {
        return this.mInVirtuaLayout;
    }

    public boolean isMeasureRequested() {
        return this.mMeasureRequested && this.mVisibility != 8;
    }

    public boolean isResolvedHorizontally() {
        return this.resolvedHorizontal || (this.mLeft.hasFinalValue() && this.mRight.hasFinalValue());
    }

    public boolean isResolvedVertically() {
        return this.resolvedVertical || (this.mTop.hasFinalValue() && this.mBottom.hasFinalValue());
    }

    public boolean isRoot() {
        return this.mParent == null;
    }

    public boolean isSpreadHeight() {
        return this.mMatchConstraintDefaultHeight == 0 && this.mDimensionRatio == 0.0f && this.mMatchConstraintMinHeight == 0 && this.mMatchConstraintMaxHeight == 0 && this.mListDimensionBehaviors[1] == androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
    }

    public boolean isSpreadWidth() {
        return this.mMatchConstraintDefaultWidth == 0 && this.mDimensionRatio == 0.0f && this.mMatchConstraintMinWidth == 0 && this.mMatchConstraintMaxWidth == 0 && this.mListDimensionBehaviors[0] == androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
    }

    public boolean isWidthWrapContent() {
        return this.mIsWidthWrapContent;
    }

    public boolean oppositeDimensionDependsOn(int i) {
        char c = i == 0 ? (char) 1 : (char) 0;
        androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour[] dimensionBehaviourArr = this.mListDimensionBehaviors;
        androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour dimensionBehaviour = dimensionBehaviourArr[i];
        androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = dimensionBehaviourArr[c];
        androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour dimensionBehaviour3 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
        return dimensionBehaviour == dimensionBehaviour3 && dimensionBehaviour2 == dimensionBehaviour3;
    }

    public boolean oppositeDimensionsTied() {
        androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour[] dimensionBehaviourArr = this.mListDimensionBehaviors;
        androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour dimensionBehaviour = dimensionBehaviourArr[0];
        androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
        return dimensionBehaviour == dimensionBehaviour2 && dimensionBehaviourArr[1] == dimensionBehaviour2;
    }

    public void reset() {
        this.mLeft.reset();
        this.mTop.reset();
        this.mRight.reset();
        this.mBottom.reset();
        this.mBaseline.reset();
        this.mCenterX.reset();
        this.mCenterY.reset();
        this.mCenter.reset();
        this.mParent = null;
        this.mCircleConstraintAngle = 0.0f;
        this.mWidth = 0;
        this.mHeight = 0;
        this.mDimensionRatio = 0.0f;
        this.mDimensionRatioSide = -1;
        this.mX = 0;
        this.mY = 0;
        this.mOffsetX = 0;
        this.mOffsetY = 0;
        this.mBaselineDistance = 0;
        this.mMinWidth = 0;
        this.mMinHeight = 0;
        float f = DEFAULT_BIAS;
        this.mHorizontalBiasPercent = f;
        this.mVerticalBiasPercent = f;
        androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour[] dimensionBehaviourArr = this.mListDimensionBehaviors;
        androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour dimensionBehaviour = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.FIXED;
        dimensionBehaviourArr[0] = dimensionBehaviour;
        dimensionBehaviourArr[1] = dimensionBehaviour;
        this.mCompanionWidget = null;
        this.mContainerItemSkip = 0;
        this.mVisibility = 0;
        this.mType = null;
        this.mHorizontalWrapVisited = false;
        this.mVerticalWrapVisited = false;
        this.mHorizontalChainStyle = 0;
        this.mVerticalChainStyle = 0;
        this.mHorizontalChainFixedPosition = false;
        this.mVerticalChainFixedPosition = false;
        float[] fArr = this.mWeight;
        fArr[0] = -1.0f;
        fArr[1] = -1.0f;
        this.mHorizontalResolution = -1;
        this.mVerticalResolution = -1;
        int[] iArr = this.mMaxDimension;
        iArr[0] = Integer.MAX_VALUE;
        iArr[1] = Integer.MAX_VALUE;
        this.mMatchConstraintDefaultWidth = 0;
        this.mMatchConstraintDefaultHeight = 0;
        this.mMatchConstraintPercentWidth = 1.0f;
        this.mMatchConstraintPercentHeight = 1.0f;
        this.mMatchConstraintMaxWidth = Integer.MAX_VALUE;
        this.mMatchConstraintMaxHeight = Integer.MAX_VALUE;
        this.mMatchConstraintMinWidth = 0;
        this.mMatchConstraintMinHeight = 0;
        this.mResolvedHasRatio = false;
        this.mResolvedDimensionRatioSide = -1;
        this.mResolvedDimensionRatio = 1.0f;
        this.mGroupsToSolver = false;
        boolean[] zArr = this.isTerminalWidget;
        zArr[0] = true;
        zArr[1] = true;
        this.mInVirtuaLayout = false;
        boolean[] zArr2 = this.mIsInBarrier;
        zArr2[0] = false;
        zArr2[1] = false;
        this.mMeasureRequested = true;
    }

    public void resetAllConstraints() {
        resetAnchors();
        setVerticalBiasPercent(DEFAULT_BIAS);
        setHorizontalBiasPercent(DEFAULT_BIAS);
    }

    public void resetAnchor(androidx.constraintlayout.solver.widgets.ConstraintAnchor constraintAnchor) {
        if (getParent() != null && (getParent() instanceof androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer) && ((androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer) getParent()).handlesInternalConstraints()) {
            return;
        }
        androidx.constraintlayout.solver.widgets.ConstraintAnchor anchor = getAnchor(androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.LEFT);
        androidx.constraintlayout.solver.widgets.ConstraintAnchor anchor2 = getAnchor(androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.RIGHT);
        androidx.constraintlayout.solver.widgets.ConstraintAnchor anchor3 = getAnchor(androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.TOP);
        androidx.constraintlayout.solver.widgets.ConstraintAnchor anchor4 = getAnchor(androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.BOTTOM);
        androidx.constraintlayout.solver.widgets.ConstraintAnchor anchor5 = getAnchor(androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.CENTER);
        androidx.constraintlayout.solver.widgets.ConstraintAnchor anchor6 = getAnchor(androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.CENTER_X);
        androidx.constraintlayout.solver.widgets.ConstraintAnchor anchor7 = getAnchor(androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.CENTER_Y);
        if (constraintAnchor == anchor5) {
            if (anchor.isConnected() && anchor2.isConnected() && anchor.getTarget() == anchor2.getTarget()) {
                anchor.reset();
                anchor2.reset();
            }
            if (anchor3.isConnected() && anchor4.isConnected() && anchor3.getTarget() == anchor4.getTarget()) {
                anchor3.reset();
                anchor4.reset();
            }
            this.mHorizontalBiasPercent = 0.5f;
            this.mVerticalBiasPercent = 0.5f;
        } else if (constraintAnchor == anchor6) {
            if (anchor.isConnected() && anchor2.isConnected() && anchor.getTarget().getOwner() == anchor2.getTarget().getOwner()) {
                anchor.reset();
                anchor2.reset();
            }
            this.mHorizontalBiasPercent = 0.5f;
        } else if (constraintAnchor == anchor7) {
            if (anchor3.isConnected() && anchor4.isConnected() && anchor3.getTarget().getOwner() == anchor4.getTarget().getOwner()) {
                anchor3.reset();
                anchor4.reset();
            }
            this.mVerticalBiasPercent = 0.5f;
        } else if (constraintAnchor == anchor || constraintAnchor == anchor2) {
            if (anchor.isConnected() && anchor.getTarget() == anchor2.getTarget()) {
                anchor5.reset();
            }
        } else if ((constraintAnchor == anchor3 || constraintAnchor == anchor4) && anchor3.isConnected() && anchor3.getTarget() == anchor4.getTarget()) {
            anchor5.reset();
        }
        constraintAnchor.reset();
    }

    public void resetAnchors() {
        androidx.constraintlayout.solver.widgets.ConstraintWidget parent = getParent();
        if (parent != null && (parent instanceof androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer) && ((androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer) getParent()).handlesInternalConstraints()) {
            return;
        }
        int size = this.mAnchors.size();
        for (int i = 0; i < size; i++) {
            this.mAnchors.get(i).reset();
        }
    }

    public void resetFinalResolution() {
        this.resolvedHorizontal = false;
        this.resolvedVertical = false;
        int size = this.mAnchors.size();
        for (int i = 0; i < size; i++) {
            this.mAnchors.get(i).resetFinalResolution();
        }
    }

    public void resetSolverVariables(androidx.constraintlayout.solver.Cache cache) {
        this.mLeft.resetSolverVariable(cache);
        this.mTop.resetSolverVariable(cache);
        this.mRight.resetSolverVariable(cache);
        this.mBottom.resetSolverVariable(cache);
        this.mBaseline.resetSolverVariable(cache);
        this.mCenter.resetSolverVariable(cache);
        this.mCenterX.resetSolverVariable(cache);
        this.mCenterY.resetSolverVariable(cache);
    }

    public void setBaselineDistance(int i) {
        this.mBaselineDistance = i;
        this.hasBaseline = i > 0;
    }

    public void setCompanionWidget(java.lang.Object obj) {
        this.mCompanionWidget = obj;
    }

    public void setContainerItemSkip(int i) {
        if (i >= 0) {
            this.mContainerItemSkip = i;
        } else {
            this.mContainerItemSkip = 0;
        }
    }

    public void setDebugName(java.lang.String str) {
        this.mDebugName = str;
    }

    public void setDebugSolverName(androidx.constraintlayout.solver.LinearSystem linearSystem, java.lang.String str) {
        this.mDebugName = str;
        androidx.constraintlayout.solver.SolverVariable createObjectVariable = linearSystem.createObjectVariable(this.mLeft);
        androidx.constraintlayout.solver.SolverVariable createObjectVariable2 = linearSystem.createObjectVariable(this.mTop);
        androidx.constraintlayout.solver.SolverVariable createObjectVariable3 = linearSystem.createObjectVariable(this.mRight);
        androidx.constraintlayout.solver.SolverVariable createObjectVariable4 = linearSystem.createObjectVariable(this.mBottom);
        createObjectVariable.setName(str + ".left");
        createObjectVariable2.setName(str + ".top");
        createObjectVariable3.setName(str + ".right");
        createObjectVariable4.setName(str + ".bottom");
        linearSystem.createObjectVariable(this.mBaseline).setName(str + ".baseline");
    }

    public void setDimension(int i, int i2) {
        this.mWidth = i;
        int i3 = this.mMinWidth;
        if (i < i3) {
            this.mWidth = i3;
        }
        this.mHeight = i2;
        int i4 = this.mMinHeight;
        if (i2 < i4) {
            this.mHeight = i4;
        }
    }

    public void setDimensionRatio(float f, int i) {
        this.mDimensionRatio = f;
        this.mDimensionRatioSide = i;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:38:0x0087 -> B:31:0x0088). Please report as a decompilation issue!!! */
    public void setDimensionRatio(java.lang.String str) {
        float f;
        int i = 0;
        if (str == null || str.length() == 0) {
            this.mDimensionRatio = 0.0f;
            return;
        }
        int length = str.length();
        int indexOf = str.indexOf(44);
        int i2 = -1;
        if (indexOf > 0 && indexOf < length - 1) {
            java.lang.String substring = str.substring(0, indexOf);
            i2 = substring.equalsIgnoreCase(androidx.exifinterface.media.ExifInterface.LONGITUDE_WEST) ? 0 : substring.equalsIgnoreCase("H") ? 1 : -1;
            r3 = indexOf + 1;
        }
        int indexOf2 = str.indexOf(58);
        if (indexOf2 < 0 || indexOf2 >= length - 1) {
            java.lang.String substring2 = str.substring(r3);
            if (substring2.length() > 0) {
                f = java.lang.Float.parseFloat(substring2);
            }
            f = 0.0f;
        } else {
            java.lang.String substring3 = str.substring(r3, indexOf2);
            java.lang.String substring4 = str.substring(indexOf2 + 1);
            if (substring3.length() > 0 && substring4.length() > 0) {
                float parseFloat = java.lang.Float.parseFloat(substring3);
                float parseFloat2 = java.lang.Float.parseFloat(substring4);
                if (parseFloat > 0.0f && parseFloat2 > 0.0f) {
                    f = i2 == 1 ? java.lang.Math.abs(parseFloat2 / parseFloat) : java.lang.Math.abs(parseFloat / parseFloat2);
                }
            }
            f = 0.0f;
        }
        i = (f > i ? 1 : (f == i ? 0 : -1));
        if (i > 0) {
            this.mDimensionRatio = f;
            this.mDimensionRatioSide = i2;
        }
    }

    public void setFinalBaseline(int i) {
        if (this.hasBaseline) {
            int i2 = i - this.mBaselineDistance;
            int i3 = this.mHeight + i2;
            this.mY = i2;
            this.mTop.setFinalValue(i2);
            this.mBottom.setFinalValue(i3);
            this.mBaseline.setFinalValue(i);
            this.resolvedVertical = true;
        }
    }

    public void setFinalFrame(int i, int i2, int i3, int i4, int i5, int i6) {
        setFrame(i, i2, i3, i4);
        setBaselineDistance(i5);
        if (i6 == 0) {
            this.resolvedHorizontal = true;
            this.resolvedVertical = false;
        } else if (i6 == 1) {
            this.resolvedHorizontal = false;
            this.resolvedVertical = true;
        } else if (i6 == 2) {
            this.resolvedHorizontal = true;
            this.resolvedVertical = true;
        } else {
            this.resolvedHorizontal = false;
            this.resolvedVertical = false;
        }
    }

    public void setFinalHorizontal(int i, int i2) {
        this.mLeft.setFinalValue(i);
        this.mRight.setFinalValue(i2);
        this.mX = i;
        this.mWidth = i2 - i;
        this.resolvedHorizontal = true;
    }

    public void setFinalLeft(int i) {
        this.mLeft.setFinalValue(i);
        this.mX = i;
    }

    public void setFinalTop(int i) {
        this.mTop.setFinalValue(i);
        this.mY = i;
    }

    public void setFinalVertical(int i, int i2) {
        this.mTop.setFinalValue(i);
        this.mBottom.setFinalValue(i2);
        this.mY = i;
        this.mHeight = i2 - i;
        if (this.hasBaseline) {
            this.mBaseline.setFinalValue(i + this.mBaselineDistance);
        }
        this.resolvedVertical = true;
    }

    public void setFrame(int i, int i2, int i3) {
        if (i3 == 0) {
            setHorizontalDimension(i, i2);
        } else if (i3 == 1) {
            setVerticalDimension(i, i2);
        }
    }

    public void setFrame(int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        int i7 = i3 - i;
        int i8 = i4 - i2;
        this.mX = i;
        this.mY = i2;
        if (this.mVisibility == 8) {
            this.mWidth = 0;
            this.mHeight = 0;
            return;
        }
        androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour[] dimensionBehaviourArr = this.mListDimensionBehaviors;
        androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour dimensionBehaviour = dimensionBehaviourArr[0];
        androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.FIXED;
        if (dimensionBehaviour == dimensionBehaviour2 && i7 < (i6 = this.mWidth)) {
            i7 = i6;
        }
        if (dimensionBehaviourArr[1] == dimensionBehaviour2 && i8 < (i5 = this.mHeight)) {
            i8 = i5;
        }
        this.mWidth = i7;
        this.mHeight = i8;
        int i9 = this.mMinHeight;
        if (i8 < i9) {
            this.mHeight = i9;
        }
        int i10 = this.mMinWidth;
        if (i7 < i10) {
            this.mWidth = i10;
        }
    }

    public void setGoneMargin(androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type type, int i) {
        int i2 = androidx.constraintlayout.solver.widgets.ConstraintWidget.AnonymousClass1.$SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[type.ordinal()];
        if (i2 == 1) {
            this.mLeft.mGoneMargin = i;
            return;
        }
        if (i2 == 2) {
            this.mTop.mGoneMargin = i;
        } else if (i2 == 3) {
            this.mRight.mGoneMargin = i;
        } else {
            if (i2 != 4) {
                return;
            }
            this.mBottom.mGoneMargin = i;
        }
    }

    public void setHasBaseline(boolean z) {
        this.hasBaseline = z;
    }

    public void setHeight(int i) {
        this.mHeight = i;
        int i2 = this.mMinHeight;
        if (i < i2) {
            this.mHeight = i2;
        }
    }

    public void setHeightWrapContent(boolean z) {
        this.mIsHeightWrapContent = z;
    }

    public void setHorizontalBiasPercent(float f) {
        this.mHorizontalBiasPercent = f;
    }

    public void setHorizontalChainStyle(int i) {
        this.mHorizontalChainStyle = i;
    }

    public void setHorizontalDimension(int i, int i2) {
        this.mX = i;
        int i3 = i2 - i;
        this.mWidth = i3;
        int i4 = this.mMinWidth;
        if (i3 < i4) {
            this.mWidth = i4;
        }
    }

    public void setHorizontalDimensionBehaviour(androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour dimensionBehaviour) {
        this.mListDimensionBehaviors[0] = dimensionBehaviour;
    }

    public void setHorizontalMatchStyle(int i, int i2, int i3, float f) {
        this.mMatchConstraintDefaultWidth = i;
        this.mMatchConstraintMinWidth = i2;
        if (i3 == Integer.MAX_VALUE) {
            i3 = 0;
        }
        this.mMatchConstraintMaxWidth = i3;
        this.mMatchConstraintPercentWidth = f;
        if (f <= 0.0f || f >= 1.0f || i != 0) {
            return;
        }
        this.mMatchConstraintDefaultWidth = 2;
    }

    public void setHorizontalWeight(float f) {
        this.mWeight[0] = f;
    }

    public void setInBarrier(int i, boolean z) {
        this.mIsInBarrier[i] = z;
    }

    public void setInPlaceholder(boolean z) {
        this.inPlaceholder = z;
    }

    public void setInVirtualLayout(boolean z) {
        this.mInVirtuaLayout = z;
    }

    public void setLastMeasureSpec(int i, int i2) {
        this.mLastHorizontalMeasureSpec = i;
        this.mLastVerticalMeasureSpec = i2;
        setMeasureRequested(false);
    }

    public void setLength(int i, int i2) {
        if (i2 == 0) {
            setWidth(i);
        } else if (i2 == 1) {
            setHeight(i);
        }
    }

    public void setMaxHeight(int i) {
        this.mMaxDimension[1] = i;
    }

    public void setMaxWidth(int i) {
        this.mMaxDimension[0] = i;
    }

    public void setMeasureRequested(boolean z) {
        this.mMeasureRequested = z;
    }

    public void setMinHeight(int i) {
        if (i < 0) {
            this.mMinHeight = 0;
        } else {
            this.mMinHeight = i;
        }
    }

    public void setMinWidth(int i) {
        if (i < 0) {
            this.mMinWidth = 0;
        } else {
            this.mMinWidth = i;
        }
    }

    public void setOffset(int i, int i2) {
        this.mOffsetX = i;
        this.mOffsetY = i2;
    }

    public void setOrigin(int i, int i2) {
        this.mX = i;
        this.mY = i2;
    }

    public void setParent(androidx.constraintlayout.solver.widgets.ConstraintWidget constraintWidget) {
        this.mParent = constraintWidget;
    }

    public void setRelativePositioning(int i, int i2) {
        if (i2 == 0) {
            this.mRelX = i;
        } else if (i2 == 1) {
            this.mRelY = i;
        }
    }

    public void setType(java.lang.String str) {
        this.mType = str;
    }

    public void setVerticalBiasPercent(float f) {
        this.mVerticalBiasPercent = f;
    }

    public void setVerticalChainStyle(int i) {
        this.mVerticalChainStyle = i;
    }

    public void setVerticalDimension(int i, int i2) {
        this.mY = i;
        int i3 = i2 - i;
        this.mHeight = i3;
        int i4 = this.mMinHeight;
        if (i3 < i4) {
            this.mHeight = i4;
        }
    }

    public void setVerticalDimensionBehaviour(androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour dimensionBehaviour) {
        this.mListDimensionBehaviors[1] = dimensionBehaviour;
    }

    public void setVerticalMatchStyle(int i, int i2, int i3, float f) {
        this.mMatchConstraintDefaultHeight = i;
        this.mMatchConstraintMinHeight = i2;
        if (i3 == Integer.MAX_VALUE) {
            i3 = 0;
        }
        this.mMatchConstraintMaxHeight = i3;
        this.mMatchConstraintPercentHeight = f;
        if (f <= 0.0f || f >= 1.0f || i != 0) {
            return;
        }
        this.mMatchConstraintDefaultHeight = 2;
    }

    public void setVerticalWeight(float f) {
        this.mWeight[1] = f;
    }

    public void setVisibility(int i) {
        this.mVisibility = i;
    }

    public void setWidth(int i) {
        this.mWidth = i;
        int i2 = this.mMinWidth;
        if (i < i2) {
            this.mWidth = i2;
        }
    }

    public void setWidthWrapContent(boolean z) {
        this.mIsWidthWrapContent = z;
    }

    public void setX(int i) {
        this.mX = i;
    }

    public void setY(int i) {
        this.mY = i;
    }

    public void setupDimensionRatio(boolean z, boolean z2, boolean z3, boolean z4) {
        if (this.mResolvedDimensionRatioSide == -1) {
            if (z3 && !z4) {
                this.mResolvedDimensionRatioSide = 0;
            } else if (!z3 && z4) {
                this.mResolvedDimensionRatioSide = 1;
                if (this.mDimensionRatioSide == -1) {
                    this.mResolvedDimensionRatio = 1.0f / this.mResolvedDimensionRatio;
                }
            }
        }
        if (this.mResolvedDimensionRatioSide == 0 && (!this.mTop.isConnected() || !this.mBottom.isConnected())) {
            this.mResolvedDimensionRatioSide = 1;
        } else if (this.mResolvedDimensionRatioSide == 1 && (!this.mLeft.isConnected() || !this.mRight.isConnected())) {
            this.mResolvedDimensionRatioSide = 0;
        }
        if (this.mResolvedDimensionRatioSide == -1 && (!this.mTop.isConnected() || !this.mBottom.isConnected() || !this.mLeft.isConnected() || !this.mRight.isConnected())) {
            if (this.mTop.isConnected() && this.mBottom.isConnected()) {
                this.mResolvedDimensionRatioSide = 0;
            } else if (this.mLeft.isConnected() && this.mRight.isConnected()) {
                this.mResolvedDimensionRatio = 1.0f / this.mResolvedDimensionRatio;
                this.mResolvedDimensionRatioSide = 1;
            }
        }
        if (this.mResolvedDimensionRatioSide == -1) {
            int i = this.mMatchConstraintMinWidth;
            if (i > 0 && this.mMatchConstraintMinHeight == 0) {
                this.mResolvedDimensionRatioSide = 0;
            } else {
                if (i != 0 || this.mMatchConstraintMinHeight <= 0) {
                    return;
                }
                this.mResolvedDimensionRatio = 1.0f / this.mResolvedDimensionRatio;
                this.mResolvedDimensionRatioSide = 1;
            }
        }
    }

    public java.lang.String toString() {
        java.lang.String str;
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        java.lang.String str2 = "";
        if (this.mType != null) {
            str = "type: " + this.mType + " ";
        } else {
            str = "";
        }
        sb.append(str);
        if (this.mDebugName != null) {
            str2 = "id: " + this.mDebugName + " ";
        }
        sb.append(str2);
        sb.append("(");
        sb.append(this.mX);
        sb.append(", ");
        sb.append(this.mY);
        sb.append(") - (");
        sb.append(this.mWidth);
        sb.append(" x ");
        sb.append(this.mHeight);
        sb.append(")");
        return sb.toString();
    }

    public void updateFromRuns(boolean z, boolean z2) {
        int i;
        int i2;
        boolean isResolved = z & this.horizontalRun.isResolved();
        boolean isResolved2 = z2 & this.verticalRun.isResolved();
        androidx.constraintlayout.solver.widgets.analyzer.HorizontalWidgetRun horizontalWidgetRun = this.horizontalRun;
        int i3 = horizontalWidgetRun.start.value;
        androidx.constraintlayout.solver.widgets.analyzer.VerticalWidgetRun verticalWidgetRun = this.verticalRun;
        int i4 = verticalWidgetRun.start.value;
        int i5 = horizontalWidgetRun.end.value;
        int i6 = verticalWidgetRun.end.value;
        int i7 = i6 - i4;
        if (i5 - i3 < 0 || i7 < 0 || i3 == Integer.MIN_VALUE || i3 == Integer.MAX_VALUE || i4 == Integer.MIN_VALUE || i4 == Integer.MAX_VALUE || i5 == Integer.MIN_VALUE || i5 == Integer.MAX_VALUE || i6 == Integer.MIN_VALUE || i6 == Integer.MAX_VALUE) {
            i5 = 0;
            i3 = 0;
            i6 = 0;
            i4 = 0;
        }
        int i8 = i5 - i3;
        int i9 = i6 - i4;
        if (isResolved) {
            this.mX = i3;
        }
        if (isResolved2) {
            this.mY = i4;
        }
        if (this.mVisibility == 8) {
            this.mWidth = 0;
            this.mHeight = 0;
            return;
        }
        if (isResolved) {
            if (this.mListDimensionBehaviors[0] == androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.FIXED && i8 < (i2 = this.mWidth)) {
                i8 = i2;
            }
            this.mWidth = i8;
            int i10 = this.mMinWidth;
            if (i8 < i10) {
                this.mWidth = i10;
            }
        }
        if (isResolved2) {
            if (this.mListDimensionBehaviors[1] == androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.FIXED && i9 < (i = this.mHeight)) {
                i9 = i;
            }
            this.mHeight = i9;
            int i11 = this.mMinHeight;
            if (i9 < i11) {
                this.mHeight = i11;
            }
        }
    }

    public void updateFromSolver(androidx.constraintlayout.solver.LinearSystem linearSystem, boolean z) {
        androidx.constraintlayout.solver.widgets.analyzer.VerticalWidgetRun verticalWidgetRun;
        androidx.constraintlayout.solver.widgets.analyzer.HorizontalWidgetRun horizontalWidgetRun;
        int objectVariableValue = linearSystem.getObjectVariableValue(this.mLeft);
        int objectVariableValue2 = linearSystem.getObjectVariableValue(this.mTop);
        int objectVariableValue3 = linearSystem.getObjectVariableValue(this.mRight);
        int objectVariableValue4 = linearSystem.getObjectVariableValue(this.mBottom);
        if (z && (horizontalWidgetRun = this.horizontalRun) != null) {
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode dependencyNode = horizontalWidgetRun.start;
            if (dependencyNode.resolved) {
                androidx.constraintlayout.solver.widgets.analyzer.DependencyNode dependencyNode2 = horizontalWidgetRun.end;
                if (dependencyNode2.resolved) {
                    objectVariableValue = dependencyNode.value;
                    objectVariableValue3 = dependencyNode2.value;
                }
            }
        }
        if (z && (verticalWidgetRun = this.verticalRun) != null) {
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode dependencyNode3 = verticalWidgetRun.start;
            if (dependencyNode3.resolved) {
                androidx.constraintlayout.solver.widgets.analyzer.DependencyNode dependencyNode4 = verticalWidgetRun.end;
                if (dependencyNode4.resolved) {
                    objectVariableValue2 = dependencyNode3.value;
                    objectVariableValue4 = dependencyNode4.value;
                }
            }
        }
        int i = objectVariableValue4 - objectVariableValue2;
        if (objectVariableValue3 - objectVariableValue < 0 || i < 0 || objectVariableValue == Integer.MIN_VALUE || objectVariableValue == Integer.MAX_VALUE || objectVariableValue2 == Integer.MIN_VALUE || objectVariableValue2 == Integer.MAX_VALUE || objectVariableValue3 == Integer.MIN_VALUE || objectVariableValue3 == Integer.MAX_VALUE || objectVariableValue4 == Integer.MIN_VALUE || objectVariableValue4 == Integer.MAX_VALUE) {
            objectVariableValue = 0;
            objectVariableValue4 = 0;
            objectVariableValue2 = 0;
            objectVariableValue3 = 0;
        }
        setFrame(objectVariableValue, objectVariableValue2, objectVariableValue3, objectVariableValue4);
    }
}
