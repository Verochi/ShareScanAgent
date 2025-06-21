package androidx.constraintlayout.widget;

/* loaded from: classes.dex */
public class ConstraintSet {
    private static final int ALPHA = 43;
    private static final int ANIMATE_RELATIVE_TO = 64;
    private static final int BARRIER_ALLOWS_GONE_WIDGETS = 75;
    private static final int BARRIER_DIRECTION = 72;
    private static final int BARRIER_MARGIN = 73;
    private static final int BARRIER_TYPE = 1;
    public static final int BASELINE = 5;
    private static final int BASELINE_TO_BASELINE = 1;
    public static final int BOTTOM = 4;
    private static final int BOTTOM_MARGIN = 2;
    private static final int BOTTOM_TO_BOTTOM = 3;
    private static final int BOTTOM_TO_TOP = 4;
    public static final int CHAIN_PACKED = 2;
    public static final int CHAIN_SPREAD = 0;
    public static final int CHAIN_SPREAD_INSIDE = 1;
    private static final int CHAIN_USE_RTL = 71;
    private static final int CIRCLE = 61;
    private static final int CIRCLE_ANGLE = 63;
    private static final int CIRCLE_RADIUS = 62;
    private static final int CONSTRAINED_HEIGHT = 81;
    private static final int CONSTRAINED_WIDTH = 80;
    private static final int CONSTRAINT_REFERENCED_IDS = 74;
    private static final int CONSTRAINT_TAG = 77;
    private static final boolean DEBUG = false;
    private static final int DIMENSION_RATIO = 5;
    private static final int DRAW_PATH = 66;
    private static final int EDITOR_ABSOLUTE_X = 6;
    private static final int EDITOR_ABSOLUTE_Y = 7;
    private static final int ELEVATION = 44;
    public static final int END = 7;
    private static final int END_MARGIN = 8;
    private static final int END_TO_END = 9;
    private static final int END_TO_START = 10;
    private static final java.lang.String ERROR_MESSAGE = "XML parser error must be within a Constraint ";
    public static final int GONE = 8;
    private static final int GONE_BOTTOM_MARGIN = 11;
    private static final int GONE_END_MARGIN = 12;
    private static final int GONE_LEFT_MARGIN = 13;
    private static final int GONE_RIGHT_MARGIN = 14;
    private static final int GONE_START_MARGIN = 15;
    private static final int GONE_TOP_MARGIN = 16;
    private static final int GUIDE_BEGIN = 17;
    private static final int GUIDE_END = 18;
    private static final int GUIDE_PERCENT = 19;
    private static final int HEIGHT_DEFAULT = 55;
    private static final int HEIGHT_MAX = 57;
    private static final int HEIGHT_MIN = 59;
    private static final int HEIGHT_PERCENT = 70;
    public static final int HORIZONTAL = 0;
    private static final int HORIZONTAL_BIAS = 20;
    public static final int HORIZONTAL_GUIDELINE = 0;
    private static final int HORIZONTAL_STYLE = 41;
    private static final int HORIZONTAL_WEIGHT = 39;
    public static final int INVISIBLE = 4;
    private static final int LAYOUT_HEIGHT = 21;
    private static final int LAYOUT_VISIBILITY = 22;
    private static final int LAYOUT_WIDTH = 23;
    public static final int LEFT = 1;
    private static final int LEFT_MARGIN = 24;
    private static final int LEFT_TO_LEFT = 25;
    private static final int LEFT_TO_RIGHT = 26;
    public static final int MATCH_CONSTRAINT = 0;
    public static final int MATCH_CONSTRAINT_SPREAD = 0;
    public static final int MATCH_CONSTRAINT_WRAP = 1;
    private static final int MOTION_STAGGER = 79;
    private static final int ORIENTATION = 27;
    public static final int PARENT_ID = 0;
    private static final int PATH_MOTION_ARC = 76;
    private static final int PROGRESS = 68;
    public static final int RIGHT = 2;
    private static final int RIGHT_MARGIN = 28;
    private static final int RIGHT_TO_LEFT = 29;
    private static final int RIGHT_TO_RIGHT = 30;
    private static final int ROTATION = 60;
    private static final int ROTATION_X = 45;
    private static final int ROTATION_Y = 46;
    private static final int SCALE_X = 47;
    private static final int SCALE_Y = 48;
    public static final int START = 6;
    private static final int START_MARGIN = 31;
    private static final int START_TO_END = 32;
    private static final int START_TO_START = 33;
    private static final java.lang.String TAG = "ConstraintSet";
    public static final int TOP = 3;
    private static final int TOP_MARGIN = 34;
    private static final int TOP_TO_BOTTOM = 35;
    private static final int TOP_TO_TOP = 36;
    private static final int TRANSFORM_PIVOT_X = 49;
    private static final int TRANSFORM_PIVOT_Y = 50;
    private static final int TRANSITION_EASING = 65;
    private static final int TRANSITION_PATH_ROTATE = 67;
    private static final int TRANSLATION_X = 51;
    private static final int TRANSLATION_Y = 52;
    private static final int TRANSLATION_Z = 53;
    public static final int UNSET = -1;
    private static final int UNUSED = 82;
    public static final int VERTICAL = 1;
    private static final int VERTICAL_BIAS = 37;
    public static final int VERTICAL_GUIDELINE = 1;
    private static final int VERTICAL_STYLE = 42;
    private static final int VERTICAL_WEIGHT = 40;
    private static final int VIEW_ID = 38;
    private static final int[] VISIBILITY_FLAGS = {0, 4, 8};
    private static final int VISIBILITY_MODE = 78;
    public static final int VISIBILITY_MODE_IGNORE = 1;
    public static final int VISIBILITY_MODE_NORMAL = 0;
    public static final int VISIBLE = 0;
    private static final int WIDTH_DEFAULT = 54;
    private static final int WIDTH_MAX = 56;
    private static final int WIDTH_MIN = 58;
    private static final int WIDTH_PERCENT = 69;
    public static final int WRAP_CONTENT = -2;
    private static android.util.SparseIntArray mapToConstant;
    private boolean mValidate;
    private java.util.HashMap<java.lang.String, androidx.constraintlayout.widget.ConstraintAttribute> mSavedAttributes = new java.util.HashMap<>();
    private boolean mForceId = true;
    private java.util.HashMap<java.lang.Integer, androidx.constraintlayout.widget.ConstraintSet.Constraint> mConstraints = new java.util.HashMap<>();

    public static class Constraint {
        int mViewId;
        public final androidx.constraintlayout.widget.ConstraintSet.PropertySet propertySet = new androidx.constraintlayout.widget.ConstraintSet.PropertySet();
        public final androidx.constraintlayout.widget.ConstraintSet.Motion motion = new androidx.constraintlayout.widget.ConstraintSet.Motion();
        public final androidx.constraintlayout.widget.ConstraintSet.Layout layout = new androidx.constraintlayout.widget.ConstraintSet.Layout();
        public final androidx.constraintlayout.widget.ConstraintSet.Transform transform = new androidx.constraintlayout.widget.ConstraintSet.Transform();
        public java.util.HashMap<java.lang.String, androidx.constraintlayout.widget.ConstraintAttribute> mCustomConstraints = new java.util.HashMap<>();

        /* JADX INFO: Access modifiers changed from: private */
        public void fillFrom(int i, androidx.constraintlayout.widget.ConstraintLayout.LayoutParams layoutParams) {
            this.mViewId = i;
            androidx.constraintlayout.widget.ConstraintSet.Layout layout = this.layout;
            layout.leftToLeft = layoutParams.leftToLeft;
            layout.leftToRight = layoutParams.leftToRight;
            layout.rightToLeft = layoutParams.rightToLeft;
            layout.rightToRight = layoutParams.rightToRight;
            layout.topToTop = layoutParams.topToTop;
            layout.topToBottom = layoutParams.topToBottom;
            layout.bottomToTop = layoutParams.bottomToTop;
            layout.bottomToBottom = layoutParams.bottomToBottom;
            layout.baselineToBaseline = layoutParams.baselineToBaseline;
            layout.startToEnd = layoutParams.startToEnd;
            layout.startToStart = layoutParams.startToStart;
            layout.endToStart = layoutParams.endToStart;
            layout.endToEnd = layoutParams.endToEnd;
            layout.horizontalBias = layoutParams.horizontalBias;
            layout.verticalBias = layoutParams.verticalBias;
            layout.dimensionRatio = layoutParams.dimensionRatio;
            layout.circleConstraint = layoutParams.circleConstraint;
            layout.circleRadius = layoutParams.circleRadius;
            layout.circleAngle = layoutParams.circleAngle;
            layout.editorAbsoluteX = layoutParams.editorAbsoluteX;
            layout.editorAbsoluteY = layoutParams.editorAbsoluteY;
            layout.orientation = layoutParams.orientation;
            layout.guidePercent = layoutParams.guidePercent;
            layout.guideBegin = layoutParams.guideBegin;
            layout.guideEnd = layoutParams.guideEnd;
            layout.mWidth = ((android.view.ViewGroup.MarginLayoutParams) layoutParams).width;
            layout.mHeight = ((android.view.ViewGroup.MarginLayoutParams) layoutParams).height;
            layout.leftMargin = ((android.view.ViewGroup.MarginLayoutParams) layoutParams).leftMargin;
            layout.rightMargin = ((android.view.ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
            layout.topMargin = ((android.view.ViewGroup.MarginLayoutParams) layoutParams).topMargin;
            layout.bottomMargin = ((android.view.ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
            layout.verticalWeight = layoutParams.verticalWeight;
            layout.horizontalWeight = layoutParams.horizontalWeight;
            layout.verticalChainStyle = layoutParams.verticalChainStyle;
            layout.horizontalChainStyle = layoutParams.horizontalChainStyle;
            layout.constrainedWidth = layoutParams.constrainedWidth;
            layout.constrainedHeight = layoutParams.constrainedHeight;
            layout.widthDefault = layoutParams.matchConstraintDefaultWidth;
            layout.heightDefault = layoutParams.matchConstraintDefaultHeight;
            layout.widthMax = layoutParams.matchConstraintMaxWidth;
            layout.heightMax = layoutParams.matchConstraintMaxHeight;
            layout.widthMin = layoutParams.matchConstraintMinWidth;
            layout.heightMin = layoutParams.matchConstraintMinHeight;
            layout.widthPercent = layoutParams.matchConstraintPercentWidth;
            layout.heightPercent = layoutParams.matchConstraintPercentHeight;
            layout.mConstraintTag = layoutParams.constraintTag;
            layout.goneTopMargin = layoutParams.goneTopMargin;
            layout.goneBottomMargin = layoutParams.goneBottomMargin;
            layout.goneLeftMargin = layoutParams.goneLeftMargin;
            layout.goneRightMargin = layoutParams.goneRightMargin;
            layout.goneStartMargin = layoutParams.goneStartMargin;
            layout.goneEndMargin = layoutParams.goneEndMargin;
            layout.endMargin = layoutParams.getMarginEnd();
            this.layout.startMargin = layoutParams.getMarginStart();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void fillFromConstraints(int i, androidx.constraintlayout.widget.Constraints.LayoutParams layoutParams) {
            fillFrom(i, layoutParams);
            this.propertySet.alpha = layoutParams.alpha;
            androidx.constraintlayout.widget.ConstraintSet.Transform transform = this.transform;
            transform.rotation = layoutParams.rotation;
            transform.rotationX = layoutParams.rotationX;
            transform.rotationY = layoutParams.rotationY;
            transform.scaleX = layoutParams.scaleX;
            transform.scaleY = layoutParams.scaleY;
            transform.transformPivotX = layoutParams.transformPivotX;
            transform.transformPivotY = layoutParams.transformPivotY;
            transform.translationX = layoutParams.translationX;
            transform.translationY = layoutParams.translationY;
            transform.translationZ = layoutParams.translationZ;
            transform.elevation = layoutParams.elevation;
            transform.applyElevation = layoutParams.applyElevation;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void fillFromConstraints(androidx.constraintlayout.widget.ConstraintHelper constraintHelper, int i, androidx.constraintlayout.widget.Constraints.LayoutParams layoutParams) {
            fillFromConstraints(i, layoutParams);
            if (constraintHelper instanceof androidx.constraintlayout.widget.Barrier) {
                androidx.constraintlayout.widget.ConstraintSet.Layout layout = this.layout;
                layout.mHelperType = 1;
                androidx.constraintlayout.widget.Barrier barrier = (androidx.constraintlayout.widget.Barrier) constraintHelper;
                layout.mBarrierDirection = barrier.getType();
                this.layout.mReferenceIds = barrier.getReferencedIds();
                this.layout.mBarrierMargin = barrier.getMargin();
            }
        }

        private androidx.constraintlayout.widget.ConstraintAttribute get(java.lang.String str, androidx.constraintlayout.widget.ConstraintAttribute.AttributeType attributeType) {
            if (!this.mCustomConstraints.containsKey(str)) {
                androidx.constraintlayout.widget.ConstraintAttribute constraintAttribute = new androidx.constraintlayout.widget.ConstraintAttribute(str, attributeType);
                this.mCustomConstraints.put(str, constraintAttribute);
                return constraintAttribute;
            }
            androidx.constraintlayout.widget.ConstraintAttribute constraintAttribute2 = this.mCustomConstraints.get(str);
            if (constraintAttribute2.getType() == attributeType) {
                return constraintAttribute2;
            }
            throw new java.lang.IllegalArgumentException("ConstraintAttribute is already a " + constraintAttribute2.getType().name());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setColorValue(java.lang.String str, int i) {
            get(str, androidx.constraintlayout.widget.ConstraintAttribute.AttributeType.COLOR_TYPE).setColorValue(i);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setFloatValue(java.lang.String str, float f) {
            get(str, androidx.constraintlayout.widget.ConstraintAttribute.AttributeType.FLOAT_TYPE).setFloatValue(f);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setIntValue(java.lang.String str, int i) {
            get(str, androidx.constraintlayout.widget.ConstraintAttribute.AttributeType.INT_TYPE).setIntValue(i);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setStringValue(java.lang.String str, java.lang.String str2) {
            get(str, androidx.constraintlayout.widget.ConstraintAttribute.AttributeType.STRING_TYPE).setStringValue(str2);
        }

        public void applyTo(androidx.constraintlayout.widget.ConstraintLayout.LayoutParams layoutParams) {
            androidx.constraintlayout.widget.ConstraintSet.Layout layout = this.layout;
            layoutParams.leftToLeft = layout.leftToLeft;
            layoutParams.leftToRight = layout.leftToRight;
            layoutParams.rightToLeft = layout.rightToLeft;
            layoutParams.rightToRight = layout.rightToRight;
            layoutParams.topToTop = layout.topToTop;
            layoutParams.topToBottom = layout.topToBottom;
            layoutParams.bottomToTop = layout.bottomToTop;
            layoutParams.bottomToBottom = layout.bottomToBottom;
            layoutParams.baselineToBaseline = layout.baselineToBaseline;
            layoutParams.startToEnd = layout.startToEnd;
            layoutParams.startToStart = layout.startToStart;
            layoutParams.endToStart = layout.endToStart;
            layoutParams.endToEnd = layout.endToEnd;
            ((android.view.ViewGroup.MarginLayoutParams) layoutParams).leftMargin = layout.leftMargin;
            ((android.view.ViewGroup.MarginLayoutParams) layoutParams).rightMargin = layout.rightMargin;
            ((android.view.ViewGroup.MarginLayoutParams) layoutParams).topMargin = layout.topMargin;
            ((android.view.ViewGroup.MarginLayoutParams) layoutParams).bottomMargin = layout.bottomMargin;
            layoutParams.goneStartMargin = layout.goneStartMargin;
            layoutParams.goneEndMargin = layout.goneEndMargin;
            layoutParams.goneTopMargin = layout.goneTopMargin;
            layoutParams.goneBottomMargin = layout.goneBottomMargin;
            layoutParams.horizontalBias = layout.horizontalBias;
            layoutParams.verticalBias = layout.verticalBias;
            layoutParams.circleConstraint = layout.circleConstraint;
            layoutParams.circleRadius = layout.circleRadius;
            layoutParams.circleAngle = layout.circleAngle;
            layoutParams.dimensionRatio = layout.dimensionRatio;
            layoutParams.editorAbsoluteX = layout.editorAbsoluteX;
            layoutParams.editorAbsoluteY = layout.editorAbsoluteY;
            layoutParams.verticalWeight = layout.verticalWeight;
            layoutParams.horizontalWeight = layout.horizontalWeight;
            layoutParams.verticalChainStyle = layout.verticalChainStyle;
            layoutParams.horizontalChainStyle = layout.horizontalChainStyle;
            layoutParams.constrainedWidth = layout.constrainedWidth;
            layoutParams.constrainedHeight = layout.constrainedHeight;
            layoutParams.matchConstraintDefaultWidth = layout.widthDefault;
            layoutParams.matchConstraintDefaultHeight = layout.heightDefault;
            layoutParams.matchConstraintMaxWidth = layout.widthMax;
            layoutParams.matchConstraintMaxHeight = layout.heightMax;
            layoutParams.matchConstraintMinWidth = layout.widthMin;
            layoutParams.matchConstraintMinHeight = layout.heightMin;
            layoutParams.matchConstraintPercentWidth = layout.widthPercent;
            layoutParams.matchConstraintPercentHeight = layout.heightPercent;
            layoutParams.orientation = layout.orientation;
            layoutParams.guidePercent = layout.guidePercent;
            layoutParams.guideBegin = layout.guideBegin;
            layoutParams.guideEnd = layout.guideEnd;
            ((android.view.ViewGroup.MarginLayoutParams) layoutParams).width = layout.mWidth;
            ((android.view.ViewGroup.MarginLayoutParams) layoutParams).height = layout.mHeight;
            java.lang.String str = layout.mConstraintTag;
            if (str != null) {
                layoutParams.constraintTag = str;
            }
            layoutParams.setMarginStart(layout.startMargin);
            layoutParams.setMarginEnd(this.layout.endMargin);
            layoutParams.validate();
        }

        /* renamed from: clone, reason: merged with bridge method [inline-methods] */
        public androidx.constraintlayout.widget.ConstraintSet.Constraint m2clone() {
            androidx.constraintlayout.widget.ConstraintSet.Constraint constraint = new androidx.constraintlayout.widget.ConstraintSet.Constraint();
            constraint.layout.copyFrom(this.layout);
            constraint.motion.copyFrom(this.motion);
            constraint.propertySet.copyFrom(this.propertySet);
            constraint.transform.copyFrom(this.transform);
            constraint.mViewId = this.mViewId;
            return constraint;
        }
    }

    public static class Layout {
        private static final int BARRIER_ALLOWS_GONE_WIDGETS = 75;
        private static final int BARRIER_DIRECTION = 72;
        private static final int BARRIER_MARGIN = 73;
        private static final int BASELINE_TO_BASELINE = 1;
        private static final int BOTTOM_MARGIN = 2;
        private static final int BOTTOM_TO_BOTTOM = 3;
        private static final int BOTTOM_TO_TOP = 4;
        private static final int CHAIN_USE_RTL = 71;
        private static final int CIRCLE = 61;
        private static final int CIRCLE_ANGLE = 63;
        private static final int CIRCLE_RADIUS = 62;
        private static final int CONSTRAINT_REFERENCED_IDS = 74;
        private static final int DIMENSION_RATIO = 5;
        private static final int EDITOR_ABSOLUTE_X = 6;
        private static final int EDITOR_ABSOLUTE_Y = 7;
        private static final int END_MARGIN = 8;
        private static final int END_TO_END = 9;
        private static final int END_TO_START = 10;
        private static final int GONE_BOTTOM_MARGIN = 11;
        private static final int GONE_END_MARGIN = 12;
        private static final int GONE_LEFT_MARGIN = 13;
        private static final int GONE_RIGHT_MARGIN = 14;
        private static final int GONE_START_MARGIN = 15;
        private static final int GONE_TOP_MARGIN = 16;
        private static final int GUIDE_BEGIN = 17;
        private static final int GUIDE_END = 18;
        private static final int GUIDE_PERCENT = 19;
        private static final int HEIGHT_PERCENT = 70;
        private static final int HORIZONTAL_BIAS = 20;
        private static final int HORIZONTAL_STYLE = 39;
        private static final int HORIZONTAL_WEIGHT = 37;
        private static final int LAYOUT_HEIGHT = 21;
        private static final int LAYOUT_WIDTH = 22;
        private static final int LEFT_MARGIN = 23;
        private static final int LEFT_TO_LEFT = 24;
        private static final int LEFT_TO_RIGHT = 25;
        private static final int ORIENTATION = 26;
        private static final int RIGHT_MARGIN = 27;
        private static final int RIGHT_TO_LEFT = 28;
        private static final int RIGHT_TO_RIGHT = 29;
        private static final int START_MARGIN = 30;
        private static final int START_TO_END = 31;
        private static final int START_TO_START = 32;
        private static final int TOP_MARGIN = 33;
        private static final int TOP_TO_BOTTOM = 34;
        private static final int TOP_TO_TOP = 35;
        public static final int UNSET = -1;
        private static final int UNUSED = 76;
        private static final int VERTICAL_BIAS = 36;
        private static final int VERTICAL_STYLE = 40;
        private static final int VERTICAL_WEIGHT = 38;
        private static final int WIDTH_PERCENT = 69;
        private static android.util.SparseIntArray mapToConstant;
        public java.lang.String mConstraintTag;
        public int mHeight;
        public java.lang.String mReferenceIdString;
        public int[] mReferenceIds;
        public int mWidth;
        public boolean mIsGuideline = false;
        public boolean mApply = false;
        public int guideBegin = -1;
        public int guideEnd = -1;
        public float guidePercent = -1.0f;
        public int leftToLeft = -1;
        public int leftToRight = -1;
        public int rightToLeft = -1;
        public int rightToRight = -1;
        public int topToTop = -1;
        public int topToBottom = -1;
        public int bottomToTop = -1;
        public int bottomToBottom = -1;
        public int baselineToBaseline = -1;
        public int startToEnd = -1;
        public int startToStart = -1;
        public int endToStart = -1;
        public int endToEnd = -1;
        public float horizontalBias = 0.5f;
        public float verticalBias = 0.5f;
        public java.lang.String dimensionRatio = null;
        public int circleConstraint = -1;
        public int circleRadius = 0;
        public float circleAngle = 0.0f;
        public int editorAbsoluteX = -1;
        public int editorAbsoluteY = -1;
        public int orientation = -1;
        public int leftMargin = -1;
        public int rightMargin = -1;
        public int topMargin = -1;
        public int bottomMargin = -1;
        public int endMargin = -1;
        public int startMargin = -1;
        public int goneLeftMargin = -1;
        public int goneTopMargin = -1;
        public int goneRightMargin = -1;
        public int goneBottomMargin = -1;
        public int goneEndMargin = -1;
        public int goneStartMargin = -1;
        public float verticalWeight = -1.0f;
        public float horizontalWeight = -1.0f;
        public int horizontalChainStyle = 0;
        public int verticalChainStyle = 0;
        public int widthDefault = 0;
        public int heightDefault = 0;
        public int widthMax = -1;
        public int heightMax = -1;
        public int widthMin = -1;
        public int heightMin = -1;
        public float widthPercent = 1.0f;
        public float heightPercent = 1.0f;
        public int mBarrierDirection = -1;
        public int mBarrierMargin = 0;
        public int mHelperType = -1;
        public boolean constrainedWidth = false;
        public boolean constrainedHeight = false;
        public boolean mBarrierAllowsGoneWidgets = true;

        static {
            android.util.SparseIntArray sparseIntArray = new android.util.SparseIntArray();
            mapToConstant = sparseIntArray;
            sparseIntArray.append(androidx.constraintlayout.widget.R.styleable.Layout_layout_constraintLeft_toLeftOf, 24);
            mapToConstant.append(androidx.constraintlayout.widget.R.styleable.Layout_layout_constraintLeft_toRightOf, 25);
            mapToConstant.append(androidx.constraintlayout.widget.R.styleable.Layout_layout_constraintRight_toLeftOf, 28);
            mapToConstant.append(androidx.constraintlayout.widget.R.styleable.Layout_layout_constraintRight_toRightOf, 29);
            mapToConstant.append(androidx.constraintlayout.widget.R.styleable.Layout_layout_constraintTop_toTopOf, 35);
            mapToConstant.append(androidx.constraintlayout.widget.R.styleable.Layout_layout_constraintTop_toBottomOf, 34);
            mapToConstant.append(androidx.constraintlayout.widget.R.styleable.Layout_layout_constraintBottom_toTopOf, 4);
            mapToConstant.append(androidx.constraintlayout.widget.R.styleable.Layout_layout_constraintBottom_toBottomOf, 3);
            mapToConstant.append(androidx.constraintlayout.widget.R.styleable.Layout_layout_constraintBaseline_toBaselineOf, 1);
            mapToConstant.append(androidx.constraintlayout.widget.R.styleable.Layout_layout_editor_absoluteX, 6);
            mapToConstant.append(androidx.constraintlayout.widget.R.styleable.Layout_layout_editor_absoluteY, 7);
            mapToConstant.append(androidx.constraintlayout.widget.R.styleable.Layout_layout_constraintGuide_begin, 17);
            mapToConstant.append(androidx.constraintlayout.widget.R.styleable.Layout_layout_constraintGuide_end, 18);
            mapToConstant.append(androidx.constraintlayout.widget.R.styleable.Layout_layout_constraintGuide_percent, 19);
            mapToConstant.append(androidx.constraintlayout.widget.R.styleable.Layout_android_orientation, 26);
            mapToConstant.append(androidx.constraintlayout.widget.R.styleable.Layout_layout_constraintStart_toEndOf, 31);
            mapToConstant.append(androidx.constraintlayout.widget.R.styleable.Layout_layout_constraintStart_toStartOf, 32);
            mapToConstant.append(androidx.constraintlayout.widget.R.styleable.Layout_layout_constraintEnd_toStartOf, 10);
            mapToConstant.append(androidx.constraintlayout.widget.R.styleable.Layout_layout_constraintEnd_toEndOf, 9);
            mapToConstant.append(androidx.constraintlayout.widget.R.styleable.Layout_layout_goneMarginLeft, 13);
            mapToConstant.append(androidx.constraintlayout.widget.R.styleable.Layout_layout_goneMarginTop, 16);
            mapToConstant.append(androidx.constraintlayout.widget.R.styleable.Layout_layout_goneMarginRight, 14);
            mapToConstant.append(androidx.constraintlayout.widget.R.styleable.Layout_layout_goneMarginBottom, 11);
            mapToConstant.append(androidx.constraintlayout.widget.R.styleable.Layout_layout_goneMarginStart, 15);
            mapToConstant.append(androidx.constraintlayout.widget.R.styleable.Layout_layout_goneMarginEnd, 12);
            mapToConstant.append(androidx.constraintlayout.widget.R.styleable.Layout_layout_constraintVertical_weight, 38);
            mapToConstant.append(androidx.constraintlayout.widget.R.styleable.Layout_layout_constraintHorizontal_weight, 37);
            mapToConstant.append(androidx.constraintlayout.widget.R.styleable.Layout_layout_constraintHorizontal_chainStyle, 39);
            mapToConstant.append(androidx.constraintlayout.widget.R.styleable.Layout_layout_constraintVertical_chainStyle, 40);
            mapToConstant.append(androidx.constraintlayout.widget.R.styleable.Layout_layout_constraintHorizontal_bias, 20);
            mapToConstant.append(androidx.constraintlayout.widget.R.styleable.Layout_layout_constraintVertical_bias, 36);
            mapToConstant.append(androidx.constraintlayout.widget.R.styleable.Layout_layout_constraintDimensionRatio, 5);
            mapToConstant.append(androidx.constraintlayout.widget.R.styleable.Layout_layout_constraintLeft_creator, 76);
            mapToConstant.append(androidx.constraintlayout.widget.R.styleable.Layout_layout_constraintTop_creator, 76);
            mapToConstant.append(androidx.constraintlayout.widget.R.styleable.Layout_layout_constraintRight_creator, 76);
            mapToConstant.append(androidx.constraintlayout.widget.R.styleable.Layout_layout_constraintBottom_creator, 76);
            mapToConstant.append(androidx.constraintlayout.widget.R.styleable.Layout_layout_constraintBaseline_creator, 76);
            mapToConstant.append(androidx.constraintlayout.widget.R.styleable.Layout_android_layout_marginLeft, 23);
            mapToConstant.append(androidx.constraintlayout.widget.R.styleable.Layout_android_layout_marginRight, 27);
            mapToConstant.append(androidx.constraintlayout.widget.R.styleable.Layout_android_layout_marginStart, 30);
            mapToConstant.append(androidx.constraintlayout.widget.R.styleable.Layout_android_layout_marginEnd, 8);
            mapToConstant.append(androidx.constraintlayout.widget.R.styleable.Layout_android_layout_marginTop, 33);
            mapToConstant.append(androidx.constraintlayout.widget.R.styleable.Layout_android_layout_marginBottom, 2);
            mapToConstant.append(androidx.constraintlayout.widget.R.styleable.Layout_android_layout_width, 22);
            mapToConstant.append(androidx.constraintlayout.widget.R.styleable.Layout_android_layout_height, 21);
            mapToConstant.append(androidx.constraintlayout.widget.R.styleable.Layout_layout_constraintCircle, 61);
            mapToConstant.append(androidx.constraintlayout.widget.R.styleable.Layout_layout_constraintCircleRadius, 62);
            mapToConstant.append(androidx.constraintlayout.widget.R.styleable.Layout_layout_constraintCircleAngle, 63);
            mapToConstant.append(androidx.constraintlayout.widget.R.styleable.Layout_layout_constraintWidth_percent, 69);
            mapToConstant.append(androidx.constraintlayout.widget.R.styleable.Layout_layout_constraintHeight_percent, 70);
            mapToConstant.append(androidx.constraintlayout.widget.R.styleable.Layout_chainUseRtl, 71);
            mapToConstant.append(androidx.constraintlayout.widget.R.styleable.Layout_barrierDirection, 72);
            mapToConstant.append(androidx.constraintlayout.widget.R.styleable.Layout_barrierMargin, 73);
            mapToConstant.append(androidx.constraintlayout.widget.R.styleable.Layout_constraint_referenced_ids, 74);
            mapToConstant.append(androidx.constraintlayout.widget.R.styleable.Layout_barrierAllowsGoneWidgets, 75);
        }

        public void copyFrom(androidx.constraintlayout.widget.ConstraintSet.Layout layout) {
            this.mIsGuideline = layout.mIsGuideline;
            this.mWidth = layout.mWidth;
            this.mApply = layout.mApply;
            this.mHeight = layout.mHeight;
            this.guideBegin = layout.guideBegin;
            this.guideEnd = layout.guideEnd;
            this.guidePercent = layout.guidePercent;
            this.leftToLeft = layout.leftToLeft;
            this.leftToRight = layout.leftToRight;
            this.rightToLeft = layout.rightToLeft;
            this.rightToRight = layout.rightToRight;
            this.topToTop = layout.topToTop;
            this.topToBottom = layout.topToBottom;
            this.bottomToTop = layout.bottomToTop;
            this.bottomToBottom = layout.bottomToBottom;
            this.baselineToBaseline = layout.baselineToBaseline;
            this.startToEnd = layout.startToEnd;
            this.startToStart = layout.startToStart;
            this.endToStart = layout.endToStart;
            this.endToEnd = layout.endToEnd;
            this.horizontalBias = layout.horizontalBias;
            this.verticalBias = layout.verticalBias;
            this.dimensionRatio = layout.dimensionRatio;
            this.circleConstraint = layout.circleConstraint;
            this.circleRadius = layout.circleRadius;
            this.circleAngle = layout.circleAngle;
            this.editorAbsoluteX = layout.editorAbsoluteX;
            this.editorAbsoluteY = layout.editorAbsoluteY;
            this.orientation = layout.orientation;
            this.leftMargin = layout.leftMargin;
            this.rightMargin = layout.rightMargin;
            this.topMargin = layout.topMargin;
            this.bottomMargin = layout.bottomMargin;
            this.endMargin = layout.endMargin;
            this.startMargin = layout.startMargin;
            this.goneLeftMargin = layout.goneLeftMargin;
            this.goneTopMargin = layout.goneTopMargin;
            this.goneRightMargin = layout.goneRightMargin;
            this.goneBottomMargin = layout.goneBottomMargin;
            this.goneEndMargin = layout.goneEndMargin;
            this.goneStartMargin = layout.goneStartMargin;
            this.verticalWeight = layout.verticalWeight;
            this.horizontalWeight = layout.horizontalWeight;
            this.horizontalChainStyle = layout.horizontalChainStyle;
            this.verticalChainStyle = layout.verticalChainStyle;
            this.widthDefault = layout.widthDefault;
            this.heightDefault = layout.heightDefault;
            this.widthMax = layout.widthMax;
            this.heightMax = layout.heightMax;
            this.widthMin = layout.widthMin;
            this.heightMin = layout.heightMin;
            this.widthPercent = layout.widthPercent;
            this.heightPercent = layout.heightPercent;
            this.mBarrierDirection = layout.mBarrierDirection;
            this.mBarrierMargin = layout.mBarrierMargin;
            this.mHelperType = layout.mHelperType;
            this.mConstraintTag = layout.mConstraintTag;
            int[] iArr = layout.mReferenceIds;
            if (iArr != null) {
                this.mReferenceIds = java.util.Arrays.copyOf(iArr, iArr.length);
            } else {
                this.mReferenceIds = null;
            }
            this.mReferenceIdString = layout.mReferenceIdString;
            this.constrainedWidth = layout.constrainedWidth;
            this.constrainedHeight = layout.constrainedHeight;
            this.mBarrierAllowsGoneWidgets = layout.mBarrierAllowsGoneWidgets;
        }

        public void dump(androidx.constraintlayout.motion.widget.MotionScene motionScene, java.lang.StringBuilder sb) {
            java.lang.reflect.Field[] declaredFields = getClass().getDeclaredFields();
            sb.append("\n");
            for (java.lang.reflect.Field field : declaredFields) {
                java.lang.String name = field.getName();
                if (!java.lang.reflect.Modifier.isStatic(field.getModifiers())) {
                    try {
                        java.lang.Object obj = field.get(this);
                        java.lang.Class<?> type = field.getType();
                        if (type == java.lang.Integer.TYPE) {
                            java.lang.Integer num = (java.lang.Integer) obj;
                            if (num.intValue() != -1) {
                                java.lang.Object lookUpConstraintName = motionScene.lookUpConstraintName(num.intValue());
                                sb.append("    ");
                                sb.append(name);
                                sb.append(" = \"");
                                sb.append(lookUpConstraintName == null ? num : lookUpConstraintName);
                                sb.append("\"\n");
                            }
                        } else if (type == java.lang.Float.TYPE) {
                            java.lang.Float f = (java.lang.Float) obj;
                            if (f.floatValue() != -1.0f) {
                                sb.append("    ");
                                sb.append(name);
                                sb.append(" = \"");
                                sb.append(f);
                                sb.append("\"\n");
                            }
                        }
                    } catch (java.lang.IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        public void fillFromAttributeList(android.content.Context context, android.util.AttributeSet attributeSet) {
            android.content.res.TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, androidx.constraintlayout.widget.R.styleable.Layout);
            this.mApply = true;
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = obtainStyledAttributes.getIndex(i);
                int i2 = mapToConstant.get(index);
                if (i2 == 80) {
                    this.constrainedWidth = obtainStyledAttributes.getBoolean(index, this.constrainedWidth);
                } else if (i2 != 81) {
                    switch (i2) {
                        case 1:
                            this.baselineToBaseline = androidx.constraintlayout.widget.ConstraintSet.lookupID(obtainStyledAttributes, index, this.baselineToBaseline);
                            break;
                        case 2:
                            this.bottomMargin = obtainStyledAttributes.getDimensionPixelSize(index, this.bottomMargin);
                            break;
                        case 3:
                            this.bottomToBottom = androidx.constraintlayout.widget.ConstraintSet.lookupID(obtainStyledAttributes, index, this.bottomToBottom);
                            break;
                        case 4:
                            this.bottomToTop = androidx.constraintlayout.widget.ConstraintSet.lookupID(obtainStyledAttributes, index, this.bottomToTop);
                            break;
                        case 5:
                            this.dimensionRatio = obtainStyledAttributes.getString(index);
                            break;
                        case 6:
                            this.editorAbsoluteX = obtainStyledAttributes.getDimensionPixelOffset(index, this.editorAbsoluteX);
                            break;
                        case 7:
                            this.editorAbsoluteY = obtainStyledAttributes.getDimensionPixelOffset(index, this.editorAbsoluteY);
                            break;
                        case 8:
                            this.endMargin = obtainStyledAttributes.getDimensionPixelSize(index, this.endMargin);
                            break;
                        case 9:
                            this.endToEnd = androidx.constraintlayout.widget.ConstraintSet.lookupID(obtainStyledAttributes, index, this.endToEnd);
                            break;
                        case 10:
                            this.endToStart = androidx.constraintlayout.widget.ConstraintSet.lookupID(obtainStyledAttributes, index, this.endToStart);
                            break;
                        case 11:
                            this.goneBottomMargin = obtainStyledAttributes.getDimensionPixelSize(index, this.goneBottomMargin);
                            break;
                        case 12:
                            this.goneEndMargin = obtainStyledAttributes.getDimensionPixelSize(index, this.goneEndMargin);
                            break;
                        case 13:
                            this.goneLeftMargin = obtainStyledAttributes.getDimensionPixelSize(index, this.goneLeftMargin);
                            break;
                        case 14:
                            this.goneRightMargin = obtainStyledAttributes.getDimensionPixelSize(index, this.goneRightMargin);
                            break;
                        case 15:
                            this.goneStartMargin = obtainStyledAttributes.getDimensionPixelSize(index, this.goneStartMargin);
                            break;
                        case 16:
                            this.goneTopMargin = obtainStyledAttributes.getDimensionPixelSize(index, this.goneTopMargin);
                            break;
                        case 17:
                            this.guideBegin = obtainStyledAttributes.getDimensionPixelOffset(index, this.guideBegin);
                            break;
                        case 18:
                            this.guideEnd = obtainStyledAttributes.getDimensionPixelOffset(index, this.guideEnd);
                            break;
                        case 19:
                            this.guidePercent = obtainStyledAttributes.getFloat(index, this.guidePercent);
                            break;
                        case 20:
                            this.horizontalBias = obtainStyledAttributes.getFloat(index, this.horizontalBias);
                            break;
                        case 21:
                            this.mHeight = obtainStyledAttributes.getLayoutDimension(index, this.mHeight);
                            break;
                        case 22:
                            this.mWidth = obtainStyledAttributes.getLayoutDimension(index, this.mWidth);
                            break;
                        case 23:
                            this.leftMargin = obtainStyledAttributes.getDimensionPixelSize(index, this.leftMargin);
                            break;
                        case 24:
                            this.leftToLeft = androidx.constraintlayout.widget.ConstraintSet.lookupID(obtainStyledAttributes, index, this.leftToLeft);
                            break;
                        case 25:
                            this.leftToRight = androidx.constraintlayout.widget.ConstraintSet.lookupID(obtainStyledAttributes, index, this.leftToRight);
                            break;
                        case 26:
                            this.orientation = obtainStyledAttributes.getInt(index, this.orientation);
                            break;
                        case 27:
                            this.rightMargin = obtainStyledAttributes.getDimensionPixelSize(index, this.rightMargin);
                            break;
                        case 28:
                            this.rightToLeft = androidx.constraintlayout.widget.ConstraintSet.lookupID(obtainStyledAttributes, index, this.rightToLeft);
                            break;
                        case 29:
                            this.rightToRight = androidx.constraintlayout.widget.ConstraintSet.lookupID(obtainStyledAttributes, index, this.rightToRight);
                            break;
                        case 30:
                            this.startMargin = obtainStyledAttributes.getDimensionPixelSize(index, this.startMargin);
                            break;
                        case 31:
                            this.startToEnd = androidx.constraintlayout.widget.ConstraintSet.lookupID(obtainStyledAttributes, index, this.startToEnd);
                            break;
                        case 32:
                            this.startToStart = androidx.constraintlayout.widget.ConstraintSet.lookupID(obtainStyledAttributes, index, this.startToStart);
                            break;
                        case 33:
                            this.topMargin = obtainStyledAttributes.getDimensionPixelSize(index, this.topMargin);
                            break;
                        case 34:
                            this.topToBottom = androidx.constraintlayout.widget.ConstraintSet.lookupID(obtainStyledAttributes, index, this.topToBottom);
                            break;
                        case 35:
                            this.topToTop = androidx.constraintlayout.widget.ConstraintSet.lookupID(obtainStyledAttributes, index, this.topToTop);
                            break;
                        case 36:
                            this.verticalBias = obtainStyledAttributes.getFloat(index, this.verticalBias);
                            break;
                        case 37:
                            this.horizontalWeight = obtainStyledAttributes.getFloat(index, this.horizontalWeight);
                            break;
                        case 38:
                            this.verticalWeight = obtainStyledAttributes.getFloat(index, this.verticalWeight);
                            break;
                        case 39:
                            this.horizontalChainStyle = obtainStyledAttributes.getInt(index, this.horizontalChainStyle);
                            break;
                        case 40:
                            this.verticalChainStyle = obtainStyledAttributes.getInt(index, this.verticalChainStyle);
                            break;
                        default:
                            switch (i2) {
                                case 54:
                                    this.widthDefault = obtainStyledAttributes.getInt(index, this.widthDefault);
                                    break;
                                case 55:
                                    this.heightDefault = obtainStyledAttributes.getInt(index, this.heightDefault);
                                    break;
                                case 56:
                                    this.widthMax = obtainStyledAttributes.getDimensionPixelSize(index, this.widthMax);
                                    break;
                                case 57:
                                    this.heightMax = obtainStyledAttributes.getDimensionPixelSize(index, this.heightMax);
                                    break;
                                case 58:
                                    this.widthMin = obtainStyledAttributes.getDimensionPixelSize(index, this.widthMin);
                                    break;
                                case 59:
                                    this.heightMin = obtainStyledAttributes.getDimensionPixelSize(index, this.heightMin);
                                    break;
                                default:
                                    switch (i2) {
                                        case 61:
                                            this.circleConstraint = androidx.constraintlayout.widget.ConstraintSet.lookupID(obtainStyledAttributes, index, this.circleConstraint);
                                            break;
                                        case 62:
                                            this.circleRadius = obtainStyledAttributes.getDimensionPixelSize(index, this.circleRadius);
                                            break;
                                        case 63:
                                            this.circleAngle = obtainStyledAttributes.getFloat(index, this.circleAngle);
                                            break;
                                        default:
                                            switch (i2) {
                                                case 69:
                                                    this.widthPercent = obtainStyledAttributes.getFloat(index, 1.0f);
                                                    break;
                                                case 70:
                                                    this.heightPercent = obtainStyledAttributes.getFloat(index, 1.0f);
                                                    break;
                                                case 71:
                                                    break;
                                                case 72:
                                                    this.mBarrierDirection = obtainStyledAttributes.getInt(index, this.mBarrierDirection);
                                                    break;
                                                case 73:
                                                    this.mBarrierMargin = obtainStyledAttributes.getDimensionPixelSize(index, this.mBarrierMargin);
                                                    break;
                                                case 74:
                                                    this.mReferenceIdString = obtainStyledAttributes.getString(index);
                                                    break;
                                                case 75:
                                                    this.mBarrierAllowsGoneWidgets = obtainStyledAttributes.getBoolean(index, this.mBarrierAllowsGoneWidgets);
                                                    break;
                                                case 76:
                                                    java.lang.StringBuilder sb = new java.lang.StringBuilder();
                                                    sb.append("unused attribute 0x");
                                                    sb.append(java.lang.Integer.toHexString(index));
                                                    sb.append("   ");
                                                    sb.append(mapToConstant.get(index));
                                                    break;
                                                case 77:
                                                    this.mConstraintTag = obtainStyledAttributes.getString(index);
                                                    break;
                                                default:
                                                    java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
                                                    sb2.append("Unknown attribute 0x");
                                                    sb2.append(java.lang.Integer.toHexString(index));
                                                    sb2.append("   ");
                                                    sb2.append(mapToConstant.get(index));
                                                    break;
                                            }
                                    }
                            }
                    }
                } else {
                    this.constrainedHeight = obtainStyledAttributes.getBoolean(index, this.constrainedHeight);
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    public static class Motion {
        private static final int ANIMATE_RELATIVE_TO = 5;
        private static final int MOTION_DRAW_PATH = 4;
        private static final int MOTION_STAGGER = 6;
        private static final int PATH_MOTION_ARC = 2;
        private static final int TRANSITION_EASING = 3;
        private static final int TRANSITION_PATH_ROTATE = 1;
        private static android.util.SparseIntArray mapToConstant;
        public boolean mApply = false;
        public int mAnimateRelativeTo = -1;
        public java.lang.String mTransitionEasing = null;
        public int mPathMotionArc = -1;
        public int mDrawPath = 0;
        public float mMotionStagger = Float.NaN;
        public float mPathRotate = Float.NaN;

        static {
            android.util.SparseIntArray sparseIntArray = new android.util.SparseIntArray();
            mapToConstant = sparseIntArray;
            sparseIntArray.append(androidx.constraintlayout.widget.R.styleable.Motion_motionPathRotate, 1);
            mapToConstant.append(androidx.constraintlayout.widget.R.styleable.Motion_pathMotionArc, 2);
            mapToConstant.append(androidx.constraintlayout.widget.R.styleable.Motion_transitionEasing, 3);
            mapToConstant.append(androidx.constraintlayout.widget.R.styleable.Motion_drawPath, 4);
            mapToConstant.append(androidx.constraintlayout.widget.R.styleable.Motion_animate_relativeTo, 5);
            mapToConstant.append(androidx.constraintlayout.widget.R.styleable.Motion_motionStagger, 6);
        }

        public void copyFrom(androidx.constraintlayout.widget.ConstraintSet.Motion motion) {
            this.mApply = motion.mApply;
            this.mAnimateRelativeTo = motion.mAnimateRelativeTo;
            this.mTransitionEasing = motion.mTransitionEasing;
            this.mPathMotionArc = motion.mPathMotionArc;
            this.mDrawPath = motion.mDrawPath;
            this.mPathRotate = motion.mPathRotate;
            this.mMotionStagger = motion.mMotionStagger;
        }

        public void fillFromAttributeList(android.content.Context context, android.util.AttributeSet attributeSet) {
            android.content.res.TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, androidx.constraintlayout.widget.R.styleable.Motion);
            this.mApply = true;
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = obtainStyledAttributes.getIndex(i);
                switch (mapToConstant.get(index)) {
                    case 1:
                        this.mPathRotate = obtainStyledAttributes.getFloat(index, this.mPathRotate);
                        break;
                    case 2:
                        this.mPathMotionArc = obtainStyledAttributes.getInt(index, this.mPathMotionArc);
                        break;
                    case 3:
                        if (obtainStyledAttributes.peekValue(index).type == 3) {
                            this.mTransitionEasing = obtainStyledAttributes.getString(index);
                            break;
                        } else {
                            this.mTransitionEasing = androidx.constraintlayout.motion.utils.Easing.NAMED_EASING[obtainStyledAttributes.getInteger(index, 0)];
                            break;
                        }
                    case 4:
                        this.mDrawPath = obtainStyledAttributes.getInt(index, 0);
                        break;
                    case 5:
                        this.mAnimateRelativeTo = androidx.constraintlayout.widget.ConstraintSet.lookupID(obtainStyledAttributes, index, this.mAnimateRelativeTo);
                        break;
                    case 6:
                        this.mMotionStagger = obtainStyledAttributes.getFloat(index, this.mMotionStagger);
                        break;
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    public static class PropertySet {
        public boolean mApply = false;
        public int visibility = 0;
        public int mVisibilityMode = 0;
        public float alpha = 1.0f;
        public float mProgress = Float.NaN;

        public void copyFrom(androidx.constraintlayout.widget.ConstraintSet.PropertySet propertySet) {
            this.mApply = propertySet.mApply;
            this.visibility = propertySet.visibility;
            this.alpha = propertySet.alpha;
            this.mProgress = propertySet.mProgress;
            this.mVisibilityMode = propertySet.mVisibilityMode;
        }

        public void fillFromAttributeList(android.content.Context context, android.util.AttributeSet attributeSet) {
            android.content.res.TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, androidx.constraintlayout.widget.R.styleable.PropertySet);
            this.mApply = true;
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = obtainStyledAttributes.getIndex(i);
                if (index == androidx.constraintlayout.widget.R.styleable.PropertySet_android_alpha) {
                    this.alpha = obtainStyledAttributes.getFloat(index, this.alpha);
                } else if (index == androidx.constraintlayout.widget.R.styleable.PropertySet_android_visibility) {
                    this.visibility = obtainStyledAttributes.getInt(index, this.visibility);
                    this.visibility = androidx.constraintlayout.widget.ConstraintSet.VISIBILITY_FLAGS[this.visibility];
                } else if (index == androidx.constraintlayout.widget.R.styleable.PropertySet_visibilityMode) {
                    this.mVisibilityMode = obtainStyledAttributes.getInt(index, this.mVisibilityMode);
                } else if (index == androidx.constraintlayout.widget.R.styleable.PropertySet_motionProgress) {
                    this.mProgress = obtainStyledAttributes.getFloat(index, this.mProgress);
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    public static class Transform {
        private static final int ELEVATION = 11;
        private static final int ROTATION = 1;
        private static final int ROTATION_X = 2;
        private static final int ROTATION_Y = 3;
        private static final int SCALE_X = 4;
        private static final int SCALE_Y = 5;
        private static final int TRANSFORM_PIVOT_X = 6;
        private static final int TRANSFORM_PIVOT_Y = 7;
        private static final int TRANSLATION_X = 8;
        private static final int TRANSLATION_Y = 9;
        private static final int TRANSLATION_Z = 10;
        private static android.util.SparseIntArray mapToConstant;
        public boolean mApply = false;
        public float rotation = 0.0f;
        public float rotationX = 0.0f;
        public float rotationY = 0.0f;
        public float scaleX = 1.0f;
        public float scaleY = 1.0f;
        public float transformPivotX = Float.NaN;
        public float transformPivotY = Float.NaN;
        public float translationX = 0.0f;
        public float translationY = 0.0f;
        public float translationZ = 0.0f;
        public boolean applyElevation = false;
        public float elevation = 0.0f;

        static {
            android.util.SparseIntArray sparseIntArray = new android.util.SparseIntArray();
            mapToConstant = sparseIntArray;
            sparseIntArray.append(androidx.constraintlayout.widget.R.styleable.Transform_android_rotation, 1);
            mapToConstant.append(androidx.constraintlayout.widget.R.styleable.Transform_android_rotationX, 2);
            mapToConstant.append(androidx.constraintlayout.widget.R.styleable.Transform_android_rotationY, 3);
            mapToConstant.append(androidx.constraintlayout.widget.R.styleable.Transform_android_scaleX, 4);
            mapToConstant.append(androidx.constraintlayout.widget.R.styleable.Transform_android_scaleY, 5);
            mapToConstant.append(androidx.constraintlayout.widget.R.styleable.Transform_android_transformPivotX, 6);
            mapToConstant.append(androidx.constraintlayout.widget.R.styleable.Transform_android_transformPivotY, 7);
            mapToConstant.append(androidx.constraintlayout.widget.R.styleable.Transform_android_translationX, 8);
            mapToConstant.append(androidx.constraintlayout.widget.R.styleable.Transform_android_translationY, 9);
            mapToConstant.append(androidx.constraintlayout.widget.R.styleable.Transform_android_translationZ, 10);
            mapToConstant.append(androidx.constraintlayout.widget.R.styleable.Transform_android_elevation, 11);
        }

        public void copyFrom(androidx.constraintlayout.widget.ConstraintSet.Transform transform) {
            this.mApply = transform.mApply;
            this.rotation = transform.rotation;
            this.rotationX = transform.rotationX;
            this.rotationY = transform.rotationY;
            this.scaleX = transform.scaleX;
            this.scaleY = transform.scaleY;
            this.transformPivotX = transform.transformPivotX;
            this.transformPivotY = transform.transformPivotY;
            this.translationX = transform.translationX;
            this.translationY = transform.translationY;
            this.translationZ = transform.translationZ;
            this.applyElevation = transform.applyElevation;
            this.elevation = transform.elevation;
        }

        public void fillFromAttributeList(android.content.Context context, android.util.AttributeSet attributeSet) {
            android.content.res.TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, androidx.constraintlayout.widget.R.styleable.Transform);
            this.mApply = true;
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = obtainStyledAttributes.getIndex(i);
                switch (mapToConstant.get(index)) {
                    case 1:
                        this.rotation = obtainStyledAttributes.getFloat(index, this.rotation);
                        break;
                    case 2:
                        this.rotationX = obtainStyledAttributes.getFloat(index, this.rotationX);
                        break;
                    case 3:
                        this.rotationY = obtainStyledAttributes.getFloat(index, this.rotationY);
                        break;
                    case 4:
                        this.scaleX = obtainStyledAttributes.getFloat(index, this.scaleX);
                        break;
                    case 5:
                        this.scaleY = obtainStyledAttributes.getFloat(index, this.scaleY);
                        break;
                    case 6:
                        this.transformPivotX = obtainStyledAttributes.getDimension(index, this.transformPivotX);
                        break;
                    case 7:
                        this.transformPivotY = obtainStyledAttributes.getDimension(index, this.transformPivotY);
                        break;
                    case 8:
                        this.translationX = obtainStyledAttributes.getDimension(index, this.translationX);
                        break;
                    case 9:
                        this.translationY = obtainStyledAttributes.getDimension(index, this.translationY);
                        break;
                    case 10:
                        this.translationZ = obtainStyledAttributes.getDimension(index, this.translationZ);
                        break;
                    case 11:
                        this.applyElevation = true;
                        this.elevation = obtainStyledAttributes.getDimension(index, this.elevation);
                        break;
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    static {
        android.util.SparseIntArray sparseIntArray = new android.util.SparseIntArray();
        mapToConstant = sparseIntArray;
        sparseIntArray.append(androidx.constraintlayout.widget.R.styleable.Constraint_layout_constraintLeft_toLeftOf, 25);
        mapToConstant.append(androidx.constraintlayout.widget.R.styleable.Constraint_layout_constraintLeft_toRightOf, 26);
        mapToConstant.append(androidx.constraintlayout.widget.R.styleable.Constraint_layout_constraintRight_toLeftOf, 29);
        mapToConstant.append(androidx.constraintlayout.widget.R.styleable.Constraint_layout_constraintRight_toRightOf, 30);
        mapToConstant.append(androidx.constraintlayout.widget.R.styleable.Constraint_layout_constraintTop_toTopOf, 36);
        mapToConstant.append(androidx.constraintlayout.widget.R.styleable.Constraint_layout_constraintTop_toBottomOf, 35);
        mapToConstant.append(androidx.constraintlayout.widget.R.styleable.Constraint_layout_constraintBottom_toTopOf, 4);
        mapToConstant.append(androidx.constraintlayout.widget.R.styleable.Constraint_layout_constraintBottom_toBottomOf, 3);
        mapToConstant.append(androidx.constraintlayout.widget.R.styleable.Constraint_layout_constraintBaseline_toBaselineOf, 1);
        mapToConstant.append(androidx.constraintlayout.widget.R.styleable.Constraint_layout_editor_absoluteX, 6);
        mapToConstant.append(androidx.constraintlayout.widget.R.styleable.Constraint_layout_editor_absoluteY, 7);
        mapToConstant.append(androidx.constraintlayout.widget.R.styleable.Constraint_layout_constraintGuide_begin, 17);
        mapToConstant.append(androidx.constraintlayout.widget.R.styleable.Constraint_layout_constraintGuide_end, 18);
        mapToConstant.append(androidx.constraintlayout.widget.R.styleable.Constraint_layout_constraintGuide_percent, 19);
        mapToConstant.append(androidx.constraintlayout.widget.R.styleable.Constraint_android_orientation, 27);
        mapToConstant.append(androidx.constraintlayout.widget.R.styleable.Constraint_layout_constraintStart_toEndOf, 32);
        mapToConstant.append(androidx.constraintlayout.widget.R.styleable.Constraint_layout_constraintStart_toStartOf, 33);
        mapToConstant.append(androidx.constraintlayout.widget.R.styleable.Constraint_layout_constraintEnd_toStartOf, 10);
        mapToConstant.append(androidx.constraintlayout.widget.R.styleable.Constraint_layout_constraintEnd_toEndOf, 9);
        mapToConstant.append(androidx.constraintlayout.widget.R.styleable.Constraint_layout_goneMarginLeft, 13);
        mapToConstant.append(androidx.constraintlayout.widget.R.styleable.Constraint_layout_goneMarginTop, 16);
        mapToConstant.append(androidx.constraintlayout.widget.R.styleable.Constraint_layout_goneMarginRight, 14);
        mapToConstant.append(androidx.constraintlayout.widget.R.styleable.Constraint_layout_goneMarginBottom, 11);
        mapToConstant.append(androidx.constraintlayout.widget.R.styleable.Constraint_layout_goneMarginStart, 15);
        mapToConstant.append(androidx.constraintlayout.widget.R.styleable.Constraint_layout_goneMarginEnd, 12);
        mapToConstant.append(androidx.constraintlayout.widget.R.styleable.Constraint_layout_constraintVertical_weight, 40);
        mapToConstant.append(androidx.constraintlayout.widget.R.styleable.Constraint_layout_constraintHorizontal_weight, 39);
        mapToConstant.append(androidx.constraintlayout.widget.R.styleable.Constraint_layout_constraintHorizontal_chainStyle, 41);
        mapToConstant.append(androidx.constraintlayout.widget.R.styleable.Constraint_layout_constraintVertical_chainStyle, 42);
        mapToConstant.append(androidx.constraintlayout.widget.R.styleable.Constraint_layout_constraintHorizontal_bias, 20);
        mapToConstant.append(androidx.constraintlayout.widget.R.styleable.Constraint_layout_constraintVertical_bias, 37);
        mapToConstant.append(androidx.constraintlayout.widget.R.styleable.Constraint_layout_constraintDimensionRatio, 5);
        mapToConstant.append(androidx.constraintlayout.widget.R.styleable.Constraint_layout_constraintLeft_creator, 82);
        mapToConstant.append(androidx.constraintlayout.widget.R.styleable.Constraint_layout_constraintTop_creator, 82);
        mapToConstant.append(androidx.constraintlayout.widget.R.styleable.Constraint_layout_constraintRight_creator, 82);
        mapToConstant.append(androidx.constraintlayout.widget.R.styleable.Constraint_layout_constraintBottom_creator, 82);
        mapToConstant.append(androidx.constraintlayout.widget.R.styleable.Constraint_layout_constraintBaseline_creator, 82);
        mapToConstant.append(androidx.constraintlayout.widget.R.styleable.Constraint_android_layout_marginLeft, 24);
        mapToConstant.append(androidx.constraintlayout.widget.R.styleable.Constraint_android_layout_marginRight, 28);
        mapToConstant.append(androidx.constraintlayout.widget.R.styleable.Constraint_android_layout_marginStart, 31);
        mapToConstant.append(androidx.constraintlayout.widget.R.styleable.Constraint_android_layout_marginEnd, 8);
        mapToConstant.append(androidx.constraintlayout.widget.R.styleable.Constraint_android_layout_marginTop, 34);
        mapToConstant.append(androidx.constraintlayout.widget.R.styleable.Constraint_android_layout_marginBottom, 2);
        mapToConstant.append(androidx.constraintlayout.widget.R.styleable.Constraint_android_layout_width, 23);
        mapToConstant.append(androidx.constraintlayout.widget.R.styleable.Constraint_android_layout_height, 21);
        mapToConstant.append(androidx.constraintlayout.widget.R.styleable.Constraint_android_visibility, 22);
        mapToConstant.append(androidx.constraintlayout.widget.R.styleable.Constraint_android_alpha, 43);
        mapToConstant.append(androidx.constraintlayout.widget.R.styleable.Constraint_android_elevation, 44);
        mapToConstant.append(androidx.constraintlayout.widget.R.styleable.Constraint_android_rotationX, 45);
        mapToConstant.append(androidx.constraintlayout.widget.R.styleable.Constraint_android_rotationY, 46);
        mapToConstant.append(androidx.constraintlayout.widget.R.styleable.Constraint_android_rotation, 60);
        mapToConstant.append(androidx.constraintlayout.widget.R.styleable.Constraint_android_scaleX, 47);
        mapToConstant.append(androidx.constraintlayout.widget.R.styleable.Constraint_android_scaleY, 48);
        mapToConstant.append(androidx.constraintlayout.widget.R.styleable.Constraint_android_transformPivotX, 49);
        mapToConstant.append(androidx.constraintlayout.widget.R.styleable.Constraint_android_transformPivotY, 50);
        mapToConstant.append(androidx.constraintlayout.widget.R.styleable.Constraint_android_translationX, 51);
        mapToConstant.append(androidx.constraintlayout.widget.R.styleable.Constraint_android_translationY, 52);
        mapToConstant.append(androidx.constraintlayout.widget.R.styleable.Constraint_android_translationZ, 53);
        mapToConstant.append(androidx.constraintlayout.widget.R.styleable.Constraint_layout_constraintWidth_default, 54);
        mapToConstant.append(androidx.constraintlayout.widget.R.styleable.Constraint_layout_constraintHeight_default, 55);
        mapToConstant.append(androidx.constraintlayout.widget.R.styleable.Constraint_layout_constraintWidth_max, 56);
        mapToConstant.append(androidx.constraintlayout.widget.R.styleable.Constraint_layout_constraintHeight_max, 57);
        mapToConstant.append(androidx.constraintlayout.widget.R.styleable.Constraint_layout_constraintWidth_min, 58);
        mapToConstant.append(androidx.constraintlayout.widget.R.styleable.Constraint_layout_constraintHeight_min, 59);
        mapToConstant.append(androidx.constraintlayout.widget.R.styleable.Constraint_layout_constraintCircle, 61);
        mapToConstant.append(androidx.constraintlayout.widget.R.styleable.Constraint_layout_constraintCircleRadius, 62);
        mapToConstant.append(androidx.constraintlayout.widget.R.styleable.Constraint_layout_constraintCircleAngle, 63);
        mapToConstant.append(androidx.constraintlayout.widget.R.styleable.Constraint_animate_relativeTo, 64);
        mapToConstant.append(androidx.constraintlayout.widget.R.styleable.Constraint_transitionEasing, 65);
        mapToConstant.append(androidx.constraintlayout.widget.R.styleable.Constraint_drawPath, 66);
        mapToConstant.append(androidx.constraintlayout.widget.R.styleable.Constraint_transitionPathRotate, 67);
        mapToConstant.append(androidx.constraintlayout.widget.R.styleable.Constraint_motionStagger, 79);
        mapToConstant.append(androidx.constraintlayout.widget.R.styleable.Constraint_android_id, 38);
        mapToConstant.append(androidx.constraintlayout.widget.R.styleable.Constraint_motionProgress, 68);
        mapToConstant.append(androidx.constraintlayout.widget.R.styleable.Constraint_layout_constraintWidth_percent, 69);
        mapToConstant.append(androidx.constraintlayout.widget.R.styleable.Constraint_layout_constraintHeight_percent, 70);
        mapToConstant.append(androidx.constraintlayout.widget.R.styleable.Constraint_chainUseRtl, 71);
        mapToConstant.append(androidx.constraintlayout.widget.R.styleable.Constraint_barrierDirection, 72);
        mapToConstant.append(androidx.constraintlayout.widget.R.styleable.Constraint_barrierMargin, 73);
        mapToConstant.append(androidx.constraintlayout.widget.R.styleable.Constraint_constraint_referenced_ids, 74);
        mapToConstant.append(androidx.constraintlayout.widget.R.styleable.Constraint_barrierAllowsGoneWidgets, 75);
        mapToConstant.append(androidx.constraintlayout.widget.R.styleable.Constraint_pathMotionArc, 76);
        mapToConstant.append(androidx.constraintlayout.widget.R.styleable.Constraint_layout_constraintTag, 77);
        mapToConstant.append(androidx.constraintlayout.widget.R.styleable.Constraint_visibilityMode, 78);
        mapToConstant.append(androidx.constraintlayout.widget.R.styleable.Constraint_layout_constrainedWidth, 80);
        mapToConstant.append(androidx.constraintlayout.widget.R.styleable.Constraint_layout_constrainedHeight, 81);
    }

    private void addAttributes(androidx.constraintlayout.widget.ConstraintAttribute.AttributeType attributeType, java.lang.String... strArr) {
        for (int i = 0; i < strArr.length; i++) {
            if (this.mSavedAttributes.containsKey(strArr[i])) {
                androidx.constraintlayout.widget.ConstraintAttribute constraintAttribute = this.mSavedAttributes.get(strArr[i]);
                if (constraintAttribute.getType() != attributeType) {
                    throw new java.lang.IllegalArgumentException("ConstraintAttribute is already a " + constraintAttribute.getType().name());
                }
            } else {
                this.mSavedAttributes.put(strArr[i], new androidx.constraintlayout.widget.ConstraintAttribute(strArr[i], attributeType));
            }
        }
    }

    private int[] convertReferenceString(android.view.View view, java.lang.String str) {
        int i;
        java.lang.Object designInformation;
        java.lang.String[] split = str.split(",");
        android.content.Context context = view.getContext();
        int[] iArr = new int[split.length];
        int i2 = 0;
        int i3 = 0;
        while (i2 < split.length) {
            java.lang.String trim = split[i2].trim();
            try {
                i = androidx.constraintlayout.widget.R.id.class.getField(trim).getInt(null);
            } catch (java.lang.Exception unused) {
                i = 0;
            }
            if (i == 0) {
                i = context.getResources().getIdentifier(trim, "id", context.getPackageName());
            }
            if (i == 0 && view.isInEditMode() && (view.getParent() instanceof androidx.constraintlayout.widget.ConstraintLayout) && (designInformation = ((androidx.constraintlayout.widget.ConstraintLayout) view.getParent()).getDesignInformation(0, trim)) != null && (designInformation instanceof java.lang.Integer)) {
                i = ((java.lang.Integer) designInformation).intValue();
            }
            iArr[i3] = i;
            i2++;
            i3++;
        }
        return i3 != split.length ? java.util.Arrays.copyOf(iArr, i3) : iArr;
    }

    private void createHorizontalChain(int i, int i2, int i3, int i4, int[] iArr, float[] fArr, int i5, int i6, int i7) {
        if (iArr.length < 2) {
            throw new java.lang.IllegalArgumentException("must have 2 or more widgets in a chain");
        }
        if (fArr != null && fArr.length != iArr.length) {
            throw new java.lang.IllegalArgumentException("must have 2 or more widgets in a chain");
        }
        if (fArr != null) {
            get(iArr[0]).layout.horizontalWeight = fArr[0];
        }
        get(iArr[0]).layout.horizontalChainStyle = i5;
        connect(iArr[0], i6, i, i2, -1);
        for (int i8 = 1; i8 < iArr.length; i8++) {
            int i9 = i8 - 1;
            connect(iArr[i8], i6, iArr[i9], i7, -1);
            connect(iArr[i9], i7, iArr[i8], i6, -1);
            if (fArr != null) {
                get(iArr[i8]).layout.horizontalWeight = fArr[i8];
            }
        }
        connect(iArr[iArr.length - 1], i7, i3, i4, -1);
    }

    private androidx.constraintlayout.widget.ConstraintSet.Constraint fillFromAttributeList(android.content.Context context, android.util.AttributeSet attributeSet) {
        androidx.constraintlayout.widget.ConstraintSet.Constraint constraint = new androidx.constraintlayout.widget.ConstraintSet.Constraint();
        android.content.res.TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, androidx.constraintlayout.widget.R.styleable.Constraint);
        populateConstraint(context, constraint, obtainStyledAttributes);
        obtainStyledAttributes.recycle();
        return constraint;
    }

    private androidx.constraintlayout.widget.ConstraintSet.Constraint get(int i) {
        if (!this.mConstraints.containsKey(java.lang.Integer.valueOf(i))) {
            this.mConstraints.put(java.lang.Integer.valueOf(i), new androidx.constraintlayout.widget.ConstraintSet.Constraint());
        }
        return this.mConstraints.get(java.lang.Integer.valueOf(i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int lookupID(android.content.res.TypedArray typedArray, int i, int i2) {
        int resourceId = typedArray.getResourceId(i, i2);
        return resourceId == -1 ? typedArray.getInt(i, -1) : resourceId;
    }

    private void populateConstraint(android.content.Context context, androidx.constraintlayout.widget.ConstraintSet.Constraint constraint, android.content.res.TypedArray typedArray) {
        int indexCount = typedArray.getIndexCount();
        for (int i = 0; i < indexCount; i++) {
            int index = typedArray.getIndex(i);
            if (index != androidx.constraintlayout.widget.R.styleable.Constraint_android_id && androidx.constraintlayout.widget.R.styleable.Constraint_android_layout_marginStart != index && androidx.constraintlayout.widget.R.styleable.Constraint_android_layout_marginEnd != index) {
                constraint.motion.mApply = true;
                constraint.layout.mApply = true;
                constraint.propertySet.mApply = true;
                constraint.transform.mApply = true;
            }
            switch (mapToConstant.get(index)) {
                case 1:
                    androidx.constraintlayout.widget.ConstraintSet.Layout layout = constraint.layout;
                    layout.baselineToBaseline = lookupID(typedArray, index, layout.baselineToBaseline);
                    break;
                case 2:
                    androidx.constraintlayout.widget.ConstraintSet.Layout layout2 = constraint.layout;
                    layout2.bottomMargin = typedArray.getDimensionPixelSize(index, layout2.bottomMargin);
                    break;
                case 3:
                    androidx.constraintlayout.widget.ConstraintSet.Layout layout3 = constraint.layout;
                    layout3.bottomToBottom = lookupID(typedArray, index, layout3.bottomToBottom);
                    break;
                case 4:
                    androidx.constraintlayout.widget.ConstraintSet.Layout layout4 = constraint.layout;
                    layout4.bottomToTop = lookupID(typedArray, index, layout4.bottomToTop);
                    break;
                case 5:
                    constraint.layout.dimensionRatio = typedArray.getString(index);
                    break;
                case 6:
                    androidx.constraintlayout.widget.ConstraintSet.Layout layout5 = constraint.layout;
                    layout5.editorAbsoluteX = typedArray.getDimensionPixelOffset(index, layout5.editorAbsoluteX);
                    break;
                case 7:
                    androidx.constraintlayout.widget.ConstraintSet.Layout layout6 = constraint.layout;
                    layout6.editorAbsoluteY = typedArray.getDimensionPixelOffset(index, layout6.editorAbsoluteY);
                    break;
                case 8:
                    androidx.constraintlayout.widget.ConstraintSet.Layout layout7 = constraint.layout;
                    layout7.endMargin = typedArray.getDimensionPixelSize(index, layout7.endMargin);
                    break;
                case 9:
                    androidx.constraintlayout.widget.ConstraintSet.Layout layout8 = constraint.layout;
                    layout8.endToEnd = lookupID(typedArray, index, layout8.endToEnd);
                    break;
                case 10:
                    androidx.constraintlayout.widget.ConstraintSet.Layout layout9 = constraint.layout;
                    layout9.endToStart = lookupID(typedArray, index, layout9.endToStart);
                    break;
                case 11:
                    androidx.constraintlayout.widget.ConstraintSet.Layout layout10 = constraint.layout;
                    layout10.goneBottomMargin = typedArray.getDimensionPixelSize(index, layout10.goneBottomMargin);
                    break;
                case 12:
                    androidx.constraintlayout.widget.ConstraintSet.Layout layout11 = constraint.layout;
                    layout11.goneEndMargin = typedArray.getDimensionPixelSize(index, layout11.goneEndMargin);
                    break;
                case 13:
                    androidx.constraintlayout.widget.ConstraintSet.Layout layout12 = constraint.layout;
                    layout12.goneLeftMargin = typedArray.getDimensionPixelSize(index, layout12.goneLeftMargin);
                    break;
                case 14:
                    androidx.constraintlayout.widget.ConstraintSet.Layout layout13 = constraint.layout;
                    layout13.goneRightMargin = typedArray.getDimensionPixelSize(index, layout13.goneRightMargin);
                    break;
                case 15:
                    androidx.constraintlayout.widget.ConstraintSet.Layout layout14 = constraint.layout;
                    layout14.goneStartMargin = typedArray.getDimensionPixelSize(index, layout14.goneStartMargin);
                    break;
                case 16:
                    androidx.constraintlayout.widget.ConstraintSet.Layout layout15 = constraint.layout;
                    layout15.goneTopMargin = typedArray.getDimensionPixelSize(index, layout15.goneTopMargin);
                    break;
                case 17:
                    androidx.constraintlayout.widget.ConstraintSet.Layout layout16 = constraint.layout;
                    layout16.guideBegin = typedArray.getDimensionPixelOffset(index, layout16.guideBegin);
                    break;
                case 18:
                    androidx.constraintlayout.widget.ConstraintSet.Layout layout17 = constraint.layout;
                    layout17.guideEnd = typedArray.getDimensionPixelOffset(index, layout17.guideEnd);
                    break;
                case 19:
                    androidx.constraintlayout.widget.ConstraintSet.Layout layout18 = constraint.layout;
                    layout18.guidePercent = typedArray.getFloat(index, layout18.guidePercent);
                    break;
                case 20:
                    androidx.constraintlayout.widget.ConstraintSet.Layout layout19 = constraint.layout;
                    layout19.horizontalBias = typedArray.getFloat(index, layout19.horizontalBias);
                    break;
                case 21:
                    androidx.constraintlayout.widget.ConstraintSet.Layout layout20 = constraint.layout;
                    layout20.mHeight = typedArray.getLayoutDimension(index, layout20.mHeight);
                    break;
                case 22:
                    androidx.constraintlayout.widget.ConstraintSet.PropertySet propertySet = constraint.propertySet;
                    propertySet.visibility = typedArray.getInt(index, propertySet.visibility);
                    androidx.constraintlayout.widget.ConstraintSet.PropertySet propertySet2 = constraint.propertySet;
                    propertySet2.visibility = VISIBILITY_FLAGS[propertySet2.visibility];
                    break;
                case 23:
                    androidx.constraintlayout.widget.ConstraintSet.Layout layout21 = constraint.layout;
                    layout21.mWidth = typedArray.getLayoutDimension(index, layout21.mWidth);
                    break;
                case 24:
                    androidx.constraintlayout.widget.ConstraintSet.Layout layout22 = constraint.layout;
                    layout22.leftMargin = typedArray.getDimensionPixelSize(index, layout22.leftMargin);
                    break;
                case 25:
                    androidx.constraintlayout.widget.ConstraintSet.Layout layout23 = constraint.layout;
                    layout23.leftToLeft = lookupID(typedArray, index, layout23.leftToLeft);
                    break;
                case 26:
                    androidx.constraintlayout.widget.ConstraintSet.Layout layout24 = constraint.layout;
                    layout24.leftToRight = lookupID(typedArray, index, layout24.leftToRight);
                    break;
                case 27:
                    androidx.constraintlayout.widget.ConstraintSet.Layout layout25 = constraint.layout;
                    layout25.orientation = typedArray.getInt(index, layout25.orientation);
                    break;
                case 28:
                    androidx.constraintlayout.widget.ConstraintSet.Layout layout26 = constraint.layout;
                    layout26.rightMargin = typedArray.getDimensionPixelSize(index, layout26.rightMargin);
                    break;
                case 29:
                    androidx.constraintlayout.widget.ConstraintSet.Layout layout27 = constraint.layout;
                    layout27.rightToLeft = lookupID(typedArray, index, layout27.rightToLeft);
                    break;
                case 30:
                    androidx.constraintlayout.widget.ConstraintSet.Layout layout28 = constraint.layout;
                    layout28.rightToRight = lookupID(typedArray, index, layout28.rightToRight);
                    break;
                case 31:
                    androidx.constraintlayout.widget.ConstraintSet.Layout layout29 = constraint.layout;
                    layout29.startMargin = typedArray.getDimensionPixelSize(index, layout29.startMargin);
                    break;
                case 32:
                    androidx.constraintlayout.widget.ConstraintSet.Layout layout30 = constraint.layout;
                    layout30.startToEnd = lookupID(typedArray, index, layout30.startToEnd);
                    break;
                case 33:
                    androidx.constraintlayout.widget.ConstraintSet.Layout layout31 = constraint.layout;
                    layout31.startToStart = lookupID(typedArray, index, layout31.startToStart);
                    break;
                case 34:
                    androidx.constraintlayout.widget.ConstraintSet.Layout layout32 = constraint.layout;
                    layout32.topMargin = typedArray.getDimensionPixelSize(index, layout32.topMargin);
                    break;
                case 35:
                    androidx.constraintlayout.widget.ConstraintSet.Layout layout33 = constraint.layout;
                    layout33.topToBottom = lookupID(typedArray, index, layout33.topToBottom);
                    break;
                case 36:
                    androidx.constraintlayout.widget.ConstraintSet.Layout layout34 = constraint.layout;
                    layout34.topToTop = lookupID(typedArray, index, layout34.topToTop);
                    break;
                case 37:
                    androidx.constraintlayout.widget.ConstraintSet.Layout layout35 = constraint.layout;
                    layout35.verticalBias = typedArray.getFloat(index, layout35.verticalBias);
                    break;
                case 38:
                    constraint.mViewId = typedArray.getResourceId(index, constraint.mViewId);
                    break;
                case 39:
                    androidx.constraintlayout.widget.ConstraintSet.Layout layout36 = constraint.layout;
                    layout36.horizontalWeight = typedArray.getFloat(index, layout36.horizontalWeight);
                    break;
                case 40:
                    androidx.constraintlayout.widget.ConstraintSet.Layout layout37 = constraint.layout;
                    layout37.verticalWeight = typedArray.getFloat(index, layout37.verticalWeight);
                    break;
                case 41:
                    androidx.constraintlayout.widget.ConstraintSet.Layout layout38 = constraint.layout;
                    layout38.horizontalChainStyle = typedArray.getInt(index, layout38.horizontalChainStyle);
                    break;
                case 42:
                    androidx.constraintlayout.widget.ConstraintSet.Layout layout39 = constraint.layout;
                    layout39.verticalChainStyle = typedArray.getInt(index, layout39.verticalChainStyle);
                    break;
                case 43:
                    androidx.constraintlayout.widget.ConstraintSet.PropertySet propertySet3 = constraint.propertySet;
                    propertySet3.alpha = typedArray.getFloat(index, propertySet3.alpha);
                    break;
                case 44:
                    androidx.constraintlayout.widget.ConstraintSet.Transform transform = constraint.transform;
                    transform.applyElevation = true;
                    transform.elevation = typedArray.getDimension(index, transform.elevation);
                    break;
                case 45:
                    androidx.constraintlayout.widget.ConstraintSet.Transform transform2 = constraint.transform;
                    transform2.rotationX = typedArray.getFloat(index, transform2.rotationX);
                    break;
                case 46:
                    androidx.constraintlayout.widget.ConstraintSet.Transform transform3 = constraint.transform;
                    transform3.rotationY = typedArray.getFloat(index, transform3.rotationY);
                    break;
                case 47:
                    androidx.constraintlayout.widget.ConstraintSet.Transform transform4 = constraint.transform;
                    transform4.scaleX = typedArray.getFloat(index, transform4.scaleX);
                    break;
                case 48:
                    androidx.constraintlayout.widget.ConstraintSet.Transform transform5 = constraint.transform;
                    transform5.scaleY = typedArray.getFloat(index, transform5.scaleY);
                    break;
                case 49:
                    androidx.constraintlayout.widget.ConstraintSet.Transform transform6 = constraint.transform;
                    transform6.transformPivotX = typedArray.getDimension(index, transform6.transformPivotX);
                    break;
                case 50:
                    androidx.constraintlayout.widget.ConstraintSet.Transform transform7 = constraint.transform;
                    transform7.transformPivotY = typedArray.getDimension(index, transform7.transformPivotY);
                    break;
                case 51:
                    androidx.constraintlayout.widget.ConstraintSet.Transform transform8 = constraint.transform;
                    transform8.translationX = typedArray.getDimension(index, transform8.translationX);
                    break;
                case 52:
                    androidx.constraintlayout.widget.ConstraintSet.Transform transform9 = constraint.transform;
                    transform9.translationY = typedArray.getDimension(index, transform9.translationY);
                    break;
                case 53:
                    androidx.constraintlayout.widget.ConstraintSet.Transform transform10 = constraint.transform;
                    transform10.translationZ = typedArray.getDimension(index, transform10.translationZ);
                    break;
                case 54:
                    androidx.constraintlayout.widget.ConstraintSet.Layout layout40 = constraint.layout;
                    layout40.widthDefault = typedArray.getInt(index, layout40.widthDefault);
                    break;
                case 55:
                    androidx.constraintlayout.widget.ConstraintSet.Layout layout41 = constraint.layout;
                    layout41.heightDefault = typedArray.getInt(index, layout41.heightDefault);
                    break;
                case 56:
                    androidx.constraintlayout.widget.ConstraintSet.Layout layout42 = constraint.layout;
                    layout42.widthMax = typedArray.getDimensionPixelSize(index, layout42.widthMax);
                    break;
                case 57:
                    androidx.constraintlayout.widget.ConstraintSet.Layout layout43 = constraint.layout;
                    layout43.heightMax = typedArray.getDimensionPixelSize(index, layout43.heightMax);
                    break;
                case 58:
                    androidx.constraintlayout.widget.ConstraintSet.Layout layout44 = constraint.layout;
                    layout44.widthMin = typedArray.getDimensionPixelSize(index, layout44.widthMin);
                    break;
                case 59:
                    androidx.constraintlayout.widget.ConstraintSet.Layout layout45 = constraint.layout;
                    layout45.heightMin = typedArray.getDimensionPixelSize(index, layout45.heightMin);
                    break;
                case 60:
                    androidx.constraintlayout.widget.ConstraintSet.Transform transform11 = constraint.transform;
                    transform11.rotation = typedArray.getFloat(index, transform11.rotation);
                    break;
                case 61:
                    androidx.constraintlayout.widget.ConstraintSet.Layout layout46 = constraint.layout;
                    layout46.circleConstraint = lookupID(typedArray, index, layout46.circleConstraint);
                    break;
                case 62:
                    androidx.constraintlayout.widget.ConstraintSet.Layout layout47 = constraint.layout;
                    layout47.circleRadius = typedArray.getDimensionPixelSize(index, layout47.circleRadius);
                    break;
                case 63:
                    androidx.constraintlayout.widget.ConstraintSet.Layout layout48 = constraint.layout;
                    layout48.circleAngle = typedArray.getFloat(index, layout48.circleAngle);
                    break;
                case 64:
                    androidx.constraintlayout.widget.ConstraintSet.Motion motion = constraint.motion;
                    motion.mAnimateRelativeTo = lookupID(typedArray, index, motion.mAnimateRelativeTo);
                    break;
                case 65:
                    if (typedArray.peekValue(index).type == 3) {
                        constraint.motion.mTransitionEasing = typedArray.getString(index);
                        break;
                    } else {
                        constraint.motion.mTransitionEasing = androidx.constraintlayout.motion.utils.Easing.NAMED_EASING[typedArray.getInteger(index, 0)];
                        break;
                    }
                case 66:
                    constraint.motion.mDrawPath = typedArray.getInt(index, 0);
                    break;
                case 67:
                    androidx.constraintlayout.widget.ConstraintSet.Motion motion2 = constraint.motion;
                    motion2.mPathRotate = typedArray.getFloat(index, motion2.mPathRotate);
                    break;
                case 68:
                    androidx.constraintlayout.widget.ConstraintSet.PropertySet propertySet4 = constraint.propertySet;
                    propertySet4.mProgress = typedArray.getFloat(index, propertySet4.mProgress);
                    break;
                case 69:
                    constraint.layout.widthPercent = typedArray.getFloat(index, 1.0f);
                    break;
                case 70:
                    constraint.layout.heightPercent = typedArray.getFloat(index, 1.0f);
                    break;
                case 71:
                    break;
                case 72:
                    androidx.constraintlayout.widget.ConstraintSet.Layout layout49 = constraint.layout;
                    layout49.mBarrierDirection = typedArray.getInt(index, layout49.mBarrierDirection);
                    break;
                case 73:
                    androidx.constraintlayout.widget.ConstraintSet.Layout layout50 = constraint.layout;
                    layout50.mBarrierMargin = typedArray.getDimensionPixelSize(index, layout50.mBarrierMargin);
                    break;
                case 74:
                    constraint.layout.mReferenceIdString = typedArray.getString(index);
                    break;
                case 75:
                    androidx.constraintlayout.widget.ConstraintSet.Layout layout51 = constraint.layout;
                    layout51.mBarrierAllowsGoneWidgets = typedArray.getBoolean(index, layout51.mBarrierAllowsGoneWidgets);
                    break;
                case 76:
                    androidx.constraintlayout.widget.ConstraintSet.Motion motion3 = constraint.motion;
                    motion3.mPathMotionArc = typedArray.getInt(index, motion3.mPathMotionArc);
                    break;
                case 77:
                    constraint.layout.mConstraintTag = typedArray.getString(index);
                    break;
                case 78:
                    androidx.constraintlayout.widget.ConstraintSet.PropertySet propertySet5 = constraint.propertySet;
                    propertySet5.mVisibilityMode = typedArray.getInt(index, propertySet5.mVisibilityMode);
                    break;
                case 79:
                    androidx.constraintlayout.widget.ConstraintSet.Motion motion4 = constraint.motion;
                    motion4.mMotionStagger = typedArray.getFloat(index, motion4.mMotionStagger);
                    break;
                case 80:
                    androidx.constraintlayout.widget.ConstraintSet.Layout layout52 = constraint.layout;
                    layout52.constrainedWidth = typedArray.getBoolean(index, layout52.constrainedWidth);
                    break;
                case 81:
                    androidx.constraintlayout.widget.ConstraintSet.Layout layout53 = constraint.layout;
                    layout53.constrainedHeight = typedArray.getBoolean(index, layout53.constrainedHeight);
                    break;
                case 82:
                    java.lang.StringBuilder sb = new java.lang.StringBuilder();
                    sb.append("unused attribute 0x");
                    sb.append(java.lang.Integer.toHexString(index));
                    sb.append("   ");
                    sb.append(mapToConstant.get(index));
                    break;
                default:
                    java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
                    sb2.append("Unknown attribute 0x");
                    sb2.append(java.lang.Integer.toHexString(index));
                    sb2.append("   ");
                    sb2.append(mapToConstant.get(index));
                    break;
            }
        }
    }

    private java.lang.String sideToString(int i) {
        switch (i) {
            case 1:
                return com.sensorsdata.sf.ui.view.UIProperty.left;
            case 2:
                return com.sensorsdata.sf.ui.view.UIProperty.right;
            case 3:
                return com.sensorsdata.sf.ui.view.UIProperty.top;
            case 4:
                return com.sensorsdata.sf.ui.view.UIProperty.bottom;
            case 5:
                return "baseline";
            case 6:
                return com.anythink.expressad.foundation.d.c.bT;
            case 7:
                return "end";
            default:
                return "undefined";
        }
    }

    private static java.lang.String[] splitString(java.lang.String str) {
        char[] charArray = str.toCharArray();
        java.util.ArrayList arrayList = new java.util.ArrayList();
        int i = 0;
        boolean z = false;
        for (int i2 = 0; i2 < charArray.length; i2++) {
            char c = charArray[i2];
            if (c == ',' && !z) {
                arrayList.add(new java.lang.String(charArray, i, i2 - i));
                i = i2 + 1;
            } else if (c == '\"') {
                z = !z;
            }
        }
        arrayList.add(new java.lang.String(charArray, i, charArray.length - i));
        return (java.lang.String[]) arrayList.toArray(new java.lang.String[arrayList.size()]);
    }

    public void addColorAttributes(java.lang.String... strArr) {
        addAttributes(androidx.constraintlayout.widget.ConstraintAttribute.AttributeType.COLOR_TYPE, strArr);
    }

    public void addFloatAttributes(java.lang.String... strArr) {
        addAttributes(androidx.constraintlayout.widget.ConstraintAttribute.AttributeType.FLOAT_TYPE, strArr);
    }

    public void addIntAttributes(java.lang.String... strArr) {
        addAttributes(androidx.constraintlayout.widget.ConstraintAttribute.AttributeType.INT_TYPE, strArr);
    }

    public void addStringAttributes(java.lang.String... strArr) {
        addAttributes(androidx.constraintlayout.widget.ConstraintAttribute.AttributeType.STRING_TYPE, strArr);
    }

    public void addToHorizontalChain(int i, int i2, int i3) {
        connect(i, 1, i2, i2 == 0 ? 1 : 2, 0);
        connect(i, 2, i3, i3 == 0 ? 2 : 1, 0);
        if (i2 != 0) {
            connect(i2, 2, i, 1, 0);
        }
        if (i3 != 0) {
            connect(i3, 1, i, 2, 0);
        }
    }

    public void addToHorizontalChainRTL(int i, int i2, int i3) {
        connect(i, 6, i2, i2 == 0 ? 6 : 7, 0);
        connect(i, 7, i3, i3 == 0 ? 7 : 6, 0);
        if (i2 != 0) {
            connect(i2, 7, i, 6, 0);
        }
        if (i3 != 0) {
            connect(i3, 6, i, 7, 0);
        }
    }

    public void addToVerticalChain(int i, int i2, int i3) {
        connect(i, 3, i2, i2 == 0 ? 3 : 4, 0);
        connect(i, 4, i3, i3 == 0 ? 4 : 3, 0);
        if (i2 != 0) {
            connect(i2, 4, i, 3, 0);
        }
        if (i3 != 0) {
            connect(i3, 3, i, 4, 0);
        }
    }

    public void applyCustomAttributes(androidx.constraintlayout.widget.ConstraintLayout constraintLayout) {
        int childCount = constraintLayout.getChildCount();
        for (int i = 0; i < childCount; i++) {
            android.view.View childAt = constraintLayout.getChildAt(i);
            int id = childAt.getId();
            if (!this.mConstraints.containsKey(java.lang.Integer.valueOf(id))) {
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                sb.append("id unknown ");
                sb.append(androidx.constraintlayout.motion.widget.Debug.getName(childAt));
            } else {
                if (this.mForceId && id == -1) {
                    throw new java.lang.RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
                }
                if (this.mConstraints.containsKey(java.lang.Integer.valueOf(id))) {
                    androidx.constraintlayout.widget.ConstraintAttribute.setAttributes(childAt, this.mConstraints.get(java.lang.Integer.valueOf(id)).mCustomConstraints);
                }
            }
        }
    }

    public void applyTo(androidx.constraintlayout.widget.ConstraintLayout constraintLayout) {
        applyToInternal(constraintLayout, true);
        constraintLayout.setConstraintSet(null);
        constraintLayout.requestLayout();
    }

    public void applyToHelper(androidx.constraintlayout.widget.ConstraintHelper constraintHelper, androidx.constraintlayout.solver.widgets.ConstraintWidget constraintWidget, androidx.constraintlayout.widget.ConstraintLayout.LayoutParams layoutParams, android.util.SparseArray<androidx.constraintlayout.solver.widgets.ConstraintWidget> sparseArray) {
        int id = constraintHelper.getId();
        if (this.mConstraints.containsKey(java.lang.Integer.valueOf(id))) {
            androidx.constraintlayout.widget.ConstraintSet.Constraint constraint = this.mConstraints.get(java.lang.Integer.valueOf(id));
            if (constraintWidget instanceof androidx.constraintlayout.solver.widgets.HelperWidget) {
                constraintHelper.loadParameters(constraint, (androidx.constraintlayout.solver.widgets.HelperWidget) constraintWidget, layoutParams, sparseArray);
            }
        }
    }

    public void applyToInternal(androidx.constraintlayout.widget.ConstraintLayout constraintLayout, boolean z) {
        int childCount = constraintLayout.getChildCount();
        java.util.HashSet hashSet = new java.util.HashSet(this.mConstraints.keySet());
        for (int i = 0; i < childCount; i++) {
            android.view.View childAt = constraintLayout.getChildAt(i);
            int id = childAt.getId();
            if (!this.mConstraints.containsKey(java.lang.Integer.valueOf(id))) {
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                sb.append("id unknown ");
                sb.append(androidx.constraintlayout.motion.widget.Debug.getName(childAt));
            } else {
                if (this.mForceId && id == -1) {
                    throw new java.lang.RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
                }
                if (id != -1) {
                    if (this.mConstraints.containsKey(java.lang.Integer.valueOf(id))) {
                        hashSet.remove(java.lang.Integer.valueOf(id));
                        androidx.constraintlayout.widget.ConstraintSet.Constraint constraint = this.mConstraints.get(java.lang.Integer.valueOf(id));
                        if (childAt instanceof androidx.constraintlayout.widget.Barrier) {
                            constraint.layout.mHelperType = 1;
                        }
                        int i2 = constraint.layout.mHelperType;
                        if (i2 != -1 && i2 == 1) {
                            androidx.constraintlayout.widget.Barrier barrier = (androidx.constraintlayout.widget.Barrier) childAt;
                            barrier.setId(id);
                            barrier.setType(constraint.layout.mBarrierDirection);
                            barrier.setMargin(constraint.layout.mBarrierMargin);
                            barrier.setAllowsGoneWidget(constraint.layout.mBarrierAllowsGoneWidgets);
                            androidx.constraintlayout.widget.ConstraintSet.Layout layout = constraint.layout;
                            int[] iArr = layout.mReferenceIds;
                            if (iArr != null) {
                                barrier.setReferencedIds(iArr);
                            } else {
                                java.lang.String str = layout.mReferenceIdString;
                                if (str != null) {
                                    layout.mReferenceIds = convertReferenceString(barrier, str);
                                    barrier.setReferencedIds(constraint.layout.mReferenceIds);
                                }
                            }
                        }
                        androidx.constraintlayout.widget.ConstraintLayout.LayoutParams layoutParams = (androidx.constraintlayout.widget.ConstraintLayout.LayoutParams) childAt.getLayoutParams();
                        layoutParams.validate();
                        constraint.applyTo(layoutParams);
                        if (z) {
                            androidx.constraintlayout.widget.ConstraintAttribute.setAttributes(childAt, constraint.mCustomConstraints);
                        }
                        childAt.setLayoutParams(layoutParams);
                        androidx.constraintlayout.widget.ConstraintSet.PropertySet propertySet = constraint.propertySet;
                        if (propertySet.mVisibilityMode == 0) {
                            childAt.setVisibility(propertySet.visibility);
                        }
                        childAt.setAlpha(constraint.propertySet.alpha);
                        childAt.setRotation(constraint.transform.rotation);
                        childAt.setRotationX(constraint.transform.rotationX);
                        childAt.setRotationY(constraint.transform.rotationY);
                        childAt.setScaleX(constraint.transform.scaleX);
                        childAt.setScaleY(constraint.transform.scaleY);
                        if (!java.lang.Float.isNaN(constraint.transform.transformPivotX)) {
                            childAt.setPivotX(constraint.transform.transformPivotX);
                        }
                        if (!java.lang.Float.isNaN(constraint.transform.transformPivotY)) {
                            childAt.setPivotY(constraint.transform.transformPivotY);
                        }
                        childAt.setTranslationX(constraint.transform.translationX);
                        childAt.setTranslationY(constraint.transform.translationY);
                        childAt.setTranslationZ(constraint.transform.translationZ);
                        androidx.constraintlayout.widget.ConstraintSet.Transform transform = constraint.transform;
                        if (transform.applyElevation) {
                            childAt.setElevation(transform.elevation);
                        }
                    } else {
                        java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
                        sb2.append("WARNING NO CONSTRAINTS for view ");
                        sb2.append(id);
                    }
                }
            }
        }
        java.util.Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            java.lang.Integer num = (java.lang.Integer) it.next();
            androidx.constraintlayout.widget.ConstraintSet.Constraint constraint2 = this.mConstraints.get(num);
            int i3 = constraint2.layout.mHelperType;
            if (i3 != -1 && i3 == 1) {
                androidx.constraintlayout.widget.Barrier barrier2 = new androidx.constraintlayout.widget.Barrier(constraintLayout.getContext());
                barrier2.setId(num.intValue());
                androidx.constraintlayout.widget.ConstraintSet.Layout layout2 = constraint2.layout;
                int[] iArr2 = layout2.mReferenceIds;
                if (iArr2 != null) {
                    barrier2.setReferencedIds(iArr2);
                } else {
                    java.lang.String str2 = layout2.mReferenceIdString;
                    if (str2 != null) {
                        layout2.mReferenceIds = convertReferenceString(barrier2, str2);
                        barrier2.setReferencedIds(constraint2.layout.mReferenceIds);
                    }
                }
                barrier2.setType(constraint2.layout.mBarrierDirection);
                barrier2.setMargin(constraint2.layout.mBarrierMargin);
                androidx.constraintlayout.widget.ConstraintLayout.LayoutParams generateDefaultLayoutParams = constraintLayout.generateDefaultLayoutParams();
                barrier2.validateParams();
                constraint2.applyTo(generateDefaultLayoutParams);
                constraintLayout.addView(barrier2, generateDefaultLayoutParams);
            }
            if (constraint2.layout.mIsGuideline) {
                android.view.View guideline = new androidx.constraintlayout.widget.Guideline(constraintLayout.getContext());
                guideline.setId(num.intValue());
                androidx.constraintlayout.widget.ConstraintLayout.LayoutParams generateDefaultLayoutParams2 = constraintLayout.generateDefaultLayoutParams();
                constraint2.applyTo(generateDefaultLayoutParams2);
                constraintLayout.addView(guideline, generateDefaultLayoutParams2);
            }
        }
    }

    public void applyToLayoutParams(int i, androidx.constraintlayout.widget.ConstraintLayout.LayoutParams layoutParams) {
        if (this.mConstraints.containsKey(java.lang.Integer.valueOf(i))) {
            this.mConstraints.get(java.lang.Integer.valueOf(i)).applyTo(layoutParams);
        }
    }

    public void applyToWithoutCustom(androidx.constraintlayout.widget.ConstraintLayout constraintLayout) {
        applyToInternal(constraintLayout, false);
        constraintLayout.setConstraintSet(null);
    }

    public void center(int i, int i2, int i3, int i4, int i5, int i6, int i7, float f) {
        if (i4 < 0) {
            throw new java.lang.IllegalArgumentException("margin must be > 0");
        }
        if (i7 < 0) {
            throw new java.lang.IllegalArgumentException("margin must be > 0");
        }
        if (f <= 0.0f || f > 1.0f) {
            throw new java.lang.IllegalArgumentException("bias must be between 0 and 1 inclusive");
        }
        if (i3 == 1 || i3 == 2) {
            connect(i, 1, i2, i3, i4);
            connect(i, 2, i5, i6, i7);
            this.mConstraints.get(java.lang.Integer.valueOf(i)).layout.horizontalBias = f;
        } else if (i3 == 6 || i3 == 7) {
            connect(i, 6, i2, i3, i4);
            connect(i, 7, i5, i6, i7);
            this.mConstraints.get(java.lang.Integer.valueOf(i)).layout.horizontalBias = f;
        } else {
            connect(i, 3, i2, i3, i4);
            connect(i, 4, i5, i6, i7);
            this.mConstraints.get(java.lang.Integer.valueOf(i)).layout.verticalBias = f;
        }
    }

    public void centerHorizontally(int i, int i2) {
        if (i2 == 0) {
            center(i, 0, 1, 0, 0, 2, 0, 0.5f);
        } else {
            center(i, i2, 2, 0, i2, 1, 0, 0.5f);
        }
    }

    public void centerHorizontally(int i, int i2, int i3, int i4, int i5, int i6, int i7, float f) {
        connect(i, 1, i2, i3, i4);
        connect(i, 2, i5, i6, i7);
        this.mConstraints.get(java.lang.Integer.valueOf(i)).layout.horizontalBias = f;
    }

    public void centerHorizontallyRtl(int i, int i2) {
        if (i2 == 0) {
            center(i, 0, 6, 0, 0, 7, 0, 0.5f);
        } else {
            center(i, i2, 7, 0, i2, 6, 0, 0.5f);
        }
    }

    public void centerHorizontallyRtl(int i, int i2, int i3, int i4, int i5, int i6, int i7, float f) {
        connect(i, 6, i2, i3, i4);
        connect(i, 7, i5, i6, i7);
        this.mConstraints.get(java.lang.Integer.valueOf(i)).layout.horizontalBias = f;
    }

    public void centerVertically(int i, int i2) {
        if (i2 == 0) {
            center(i, 0, 3, 0, 0, 4, 0, 0.5f);
        } else {
            center(i, i2, 4, 0, i2, 3, 0, 0.5f);
        }
    }

    public void centerVertically(int i, int i2, int i3, int i4, int i5, int i6, int i7, float f) {
        connect(i, 3, i2, i3, i4);
        connect(i, 4, i5, i6, i7);
        this.mConstraints.get(java.lang.Integer.valueOf(i)).layout.verticalBias = f;
    }

    public void clear(int i) {
        this.mConstraints.remove(java.lang.Integer.valueOf(i));
    }

    public void clear(int i, int i2) {
        if (this.mConstraints.containsKey(java.lang.Integer.valueOf(i))) {
            androidx.constraintlayout.widget.ConstraintSet.Constraint constraint = this.mConstraints.get(java.lang.Integer.valueOf(i));
            switch (i2) {
                case 1:
                    androidx.constraintlayout.widget.ConstraintSet.Layout layout = constraint.layout;
                    layout.leftToRight = -1;
                    layout.leftToLeft = -1;
                    layout.leftMargin = -1;
                    layout.goneLeftMargin = -1;
                    return;
                case 2:
                    androidx.constraintlayout.widget.ConstraintSet.Layout layout2 = constraint.layout;
                    layout2.rightToRight = -1;
                    layout2.rightToLeft = -1;
                    layout2.rightMargin = -1;
                    layout2.goneRightMargin = -1;
                    return;
                case 3:
                    androidx.constraintlayout.widget.ConstraintSet.Layout layout3 = constraint.layout;
                    layout3.topToBottom = -1;
                    layout3.topToTop = -1;
                    layout3.topMargin = -1;
                    layout3.goneTopMargin = -1;
                    return;
                case 4:
                    androidx.constraintlayout.widget.ConstraintSet.Layout layout4 = constraint.layout;
                    layout4.bottomToTop = -1;
                    layout4.bottomToBottom = -1;
                    layout4.bottomMargin = -1;
                    layout4.goneBottomMargin = -1;
                    return;
                case 5:
                    constraint.layout.baselineToBaseline = -1;
                    return;
                case 6:
                    androidx.constraintlayout.widget.ConstraintSet.Layout layout5 = constraint.layout;
                    layout5.startToEnd = -1;
                    layout5.startToStart = -1;
                    layout5.startMargin = -1;
                    layout5.goneStartMargin = -1;
                    return;
                case 7:
                    androidx.constraintlayout.widget.ConstraintSet.Layout layout6 = constraint.layout;
                    layout6.endToStart = -1;
                    layout6.endToEnd = -1;
                    layout6.endMargin = -1;
                    layout6.goneEndMargin = -1;
                    return;
                default:
                    throw new java.lang.IllegalArgumentException("unknown constraint");
            }
        }
    }

    public void clone(android.content.Context context, int i) {
        clone((androidx.constraintlayout.widget.ConstraintLayout) android.view.LayoutInflater.from(context).inflate(i, (android.view.ViewGroup) null));
    }

    public void clone(androidx.constraintlayout.widget.ConstraintLayout constraintLayout) {
        int childCount = constraintLayout.getChildCount();
        this.mConstraints.clear();
        for (int i = 0; i < childCount; i++) {
            android.view.View childAt = constraintLayout.getChildAt(i);
            androidx.constraintlayout.widget.ConstraintLayout.LayoutParams layoutParams = (androidx.constraintlayout.widget.ConstraintLayout.LayoutParams) childAt.getLayoutParams();
            int id = childAt.getId();
            if (this.mForceId && id == -1) {
                throw new java.lang.RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
            }
            if (!this.mConstraints.containsKey(java.lang.Integer.valueOf(id))) {
                this.mConstraints.put(java.lang.Integer.valueOf(id), new androidx.constraintlayout.widget.ConstraintSet.Constraint());
            }
            androidx.constraintlayout.widget.ConstraintSet.Constraint constraint = this.mConstraints.get(java.lang.Integer.valueOf(id));
            constraint.mCustomConstraints = androidx.constraintlayout.widget.ConstraintAttribute.extractAttributes(this.mSavedAttributes, childAt);
            constraint.fillFrom(id, layoutParams);
            constraint.propertySet.visibility = childAt.getVisibility();
            constraint.propertySet.alpha = childAt.getAlpha();
            constraint.transform.rotation = childAt.getRotation();
            constraint.transform.rotationX = childAt.getRotationX();
            constraint.transform.rotationY = childAt.getRotationY();
            constraint.transform.scaleX = childAt.getScaleX();
            constraint.transform.scaleY = childAt.getScaleY();
            float pivotX = childAt.getPivotX();
            float pivotY = childAt.getPivotY();
            if (pivotX != 0.0d || pivotY != 0.0d) {
                androidx.constraintlayout.widget.ConstraintSet.Transform transform = constraint.transform;
                transform.transformPivotX = pivotX;
                transform.transformPivotY = pivotY;
            }
            constraint.transform.translationX = childAt.getTranslationX();
            constraint.transform.translationY = childAt.getTranslationY();
            constraint.transform.translationZ = childAt.getTranslationZ();
            androidx.constraintlayout.widget.ConstraintSet.Transform transform2 = constraint.transform;
            if (transform2.applyElevation) {
                transform2.elevation = childAt.getElevation();
            }
            if (childAt instanceof androidx.constraintlayout.widget.Barrier) {
                androidx.constraintlayout.widget.Barrier barrier = (androidx.constraintlayout.widget.Barrier) childAt;
                constraint.layout.mBarrierAllowsGoneWidgets = barrier.allowsGoneWidget();
                constraint.layout.mReferenceIds = barrier.getReferencedIds();
                constraint.layout.mBarrierDirection = barrier.getType();
                constraint.layout.mBarrierMargin = barrier.getMargin();
            }
        }
    }

    public void clone(androidx.constraintlayout.widget.ConstraintSet constraintSet) {
        this.mConstraints.clear();
        for (java.lang.Integer num : constraintSet.mConstraints.keySet()) {
            this.mConstraints.put(num, constraintSet.mConstraints.get(num).m2clone());
        }
    }

    public void clone(androidx.constraintlayout.widget.Constraints constraints) {
        int childCount = constraints.getChildCount();
        this.mConstraints.clear();
        for (int i = 0; i < childCount; i++) {
            android.view.View childAt = constraints.getChildAt(i);
            androidx.constraintlayout.widget.Constraints.LayoutParams layoutParams = (androidx.constraintlayout.widget.Constraints.LayoutParams) childAt.getLayoutParams();
            int id = childAt.getId();
            if (this.mForceId && id == -1) {
                throw new java.lang.RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
            }
            if (!this.mConstraints.containsKey(java.lang.Integer.valueOf(id))) {
                this.mConstraints.put(java.lang.Integer.valueOf(id), new androidx.constraintlayout.widget.ConstraintSet.Constraint());
            }
            androidx.constraintlayout.widget.ConstraintSet.Constraint constraint = this.mConstraints.get(java.lang.Integer.valueOf(id));
            if (childAt instanceof androidx.constraintlayout.widget.ConstraintHelper) {
                constraint.fillFromConstraints((androidx.constraintlayout.widget.ConstraintHelper) childAt, id, layoutParams);
            }
            constraint.fillFromConstraints(id, layoutParams);
        }
    }

    public void connect(int i, int i2, int i3, int i4) {
        if (!this.mConstraints.containsKey(java.lang.Integer.valueOf(i))) {
            this.mConstraints.put(java.lang.Integer.valueOf(i), new androidx.constraintlayout.widget.ConstraintSet.Constraint());
        }
        androidx.constraintlayout.widget.ConstraintSet.Constraint constraint = this.mConstraints.get(java.lang.Integer.valueOf(i));
        switch (i2) {
            case 1:
                if (i4 == 1) {
                    androidx.constraintlayout.widget.ConstraintSet.Layout layout = constraint.layout;
                    layout.leftToLeft = i3;
                    layout.leftToRight = -1;
                    return;
                } else if (i4 == 2) {
                    androidx.constraintlayout.widget.ConstraintSet.Layout layout2 = constraint.layout;
                    layout2.leftToRight = i3;
                    layout2.leftToLeft = -1;
                    return;
                } else {
                    throw new java.lang.IllegalArgumentException("left to " + sideToString(i4) + " undefined");
                }
            case 2:
                if (i4 == 1) {
                    androidx.constraintlayout.widget.ConstraintSet.Layout layout3 = constraint.layout;
                    layout3.rightToLeft = i3;
                    layout3.rightToRight = -1;
                    return;
                } else if (i4 == 2) {
                    androidx.constraintlayout.widget.ConstraintSet.Layout layout4 = constraint.layout;
                    layout4.rightToRight = i3;
                    layout4.rightToLeft = -1;
                    return;
                } else {
                    throw new java.lang.IllegalArgumentException("right to " + sideToString(i4) + " undefined");
                }
            case 3:
                if (i4 == 3) {
                    androidx.constraintlayout.widget.ConstraintSet.Layout layout5 = constraint.layout;
                    layout5.topToTop = i3;
                    layout5.topToBottom = -1;
                    layout5.baselineToBaseline = -1;
                    return;
                }
                if (i4 == 4) {
                    androidx.constraintlayout.widget.ConstraintSet.Layout layout6 = constraint.layout;
                    layout6.topToBottom = i3;
                    layout6.topToTop = -1;
                    layout6.baselineToBaseline = -1;
                    return;
                }
                throw new java.lang.IllegalArgumentException("right to " + sideToString(i4) + " undefined");
            case 4:
                if (i4 == 4) {
                    androidx.constraintlayout.widget.ConstraintSet.Layout layout7 = constraint.layout;
                    layout7.bottomToBottom = i3;
                    layout7.bottomToTop = -1;
                    layout7.baselineToBaseline = -1;
                    return;
                }
                if (i4 == 3) {
                    androidx.constraintlayout.widget.ConstraintSet.Layout layout8 = constraint.layout;
                    layout8.bottomToTop = i3;
                    layout8.bottomToBottom = -1;
                    layout8.baselineToBaseline = -1;
                    return;
                }
                throw new java.lang.IllegalArgumentException("right to " + sideToString(i4) + " undefined");
            case 5:
                if (i4 != 5) {
                    throw new java.lang.IllegalArgumentException("right to " + sideToString(i4) + " undefined");
                }
                androidx.constraintlayout.widget.ConstraintSet.Layout layout9 = constraint.layout;
                layout9.baselineToBaseline = i3;
                layout9.bottomToBottom = -1;
                layout9.bottomToTop = -1;
                layout9.topToTop = -1;
                layout9.topToBottom = -1;
                return;
            case 6:
                if (i4 == 6) {
                    androidx.constraintlayout.widget.ConstraintSet.Layout layout10 = constraint.layout;
                    layout10.startToStart = i3;
                    layout10.startToEnd = -1;
                    return;
                } else if (i4 == 7) {
                    androidx.constraintlayout.widget.ConstraintSet.Layout layout11 = constraint.layout;
                    layout11.startToEnd = i3;
                    layout11.startToStart = -1;
                    return;
                } else {
                    throw new java.lang.IllegalArgumentException("right to " + sideToString(i4) + " undefined");
                }
            case 7:
                if (i4 == 7) {
                    androidx.constraintlayout.widget.ConstraintSet.Layout layout12 = constraint.layout;
                    layout12.endToEnd = i3;
                    layout12.endToStart = -1;
                    return;
                } else if (i4 == 6) {
                    androidx.constraintlayout.widget.ConstraintSet.Layout layout13 = constraint.layout;
                    layout13.endToStart = i3;
                    layout13.endToEnd = -1;
                    return;
                } else {
                    throw new java.lang.IllegalArgumentException("right to " + sideToString(i4) + " undefined");
                }
            default:
                throw new java.lang.IllegalArgumentException(sideToString(i2) + " to " + sideToString(i4) + " unknown");
        }
    }

    public void connect(int i, int i2, int i3, int i4, int i5) {
        if (!this.mConstraints.containsKey(java.lang.Integer.valueOf(i))) {
            this.mConstraints.put(java.lang.Integer.valueOf(i), new androidx.constraintlayout.widget.ConstraintSet.Constraint());
        }
        androidx.constraintlayout.widget.ConstraintSet.Constraint constraint = this.mConstraints.get(java.lang.Integer.valueOf(i));
        switch (i2) {
            case 1:
                if (i4 == 1) {
                    androidx.constraintlayout.widget.ConstraintSet.Layout layout = constraint.layout;
                    layout.leftToLeft = i3;
                    layout.leftToRight = -1;
                } else {
                    if (i4 != 2) {
                        throw new java.lang.IllegalArgumentException("Left to " + sideToString(i4) + " undefined");
                    }
                    androidx.constraintlayout.widget.ConstraintSet.Layout layout2 = constraint.layout;
                    layout2.leftToRight = i3;
                    layout2.leftToLeft = -1;
                }
                constraint.layout.leftMargin = i5;
                return;
            case 2:
                if (i4 == 1) {
                    androidx.constraintlayout.widget.ConstraintSet.Layout layout3 = constraint.layout;
                    layout3.rightToLeft = i3;
                    layout3.rightToRight = -1;
                } else {
                    if (i4 != 2) {
                        throw new java.lang.IllegalArgumentException("right to " + sideToString(i4) + " undefined");
                    }
                    androidx.constraintlayout.widget.ConstraintSet.Layout layout4 = constraint.layout;
                    layout4.rightToRight = i3;
                    layout4.rightToLeft = -1;
                }
                constraint.layout.rightMargin = i5;
                return;
            case 3:
                if (i4 == 3) {
                    androidx.constraintlayout.widget.ConstraintSet.Layout layout5 = constraint.layout;
                    layout5.topToTop = i3;
                    layout5.topToBottom = -1;
                    layout5.baselineToBaseline = -1;
                } else {
                    if (i4 != 4) {
                        throw new java.lang.IllegalArgumentException("right to " + sideToString(i4) + " undefined");
                    }
                    androidx.constraintlayout.widget.ConstraintSet.Layout layout6 = constraint.layout;
                    layout6.topToBottom = i3;
                    layout6.topToTop = -1;
                    layout6.baselineToBaseline = -1;
                }
                constraint.layout.topMargin = i5;
                return;
            case 4:
                if (i4 == 4) {
                    androidx.constraintlayout.widget.ConstraintSet.Layout layout7 = constraint.layout;
                    layout7.bottomToBottom = i3;
                    layout7.bottomToTop = -1;
                    layout7.baselineToBaseline = -1;
                } else {
                    if (i4 != 3) {
                        throw new java.lang.IllegalArgumentException("right to " + sideToString(i4) + " undefined");
                    }
                    androidx.constraintlayout.widget.ConstraintSet.Layout layout8 = constraint.layout;
                    layout8.bottomToTop = i3;
                    layout8.bottomToBottom = -1;
                    layout8.baselineToBaseline = -1;
                }
                constraint.layout.bottomMargin = i5;
                return;
            case 5:
                if (i4 != 5) {
                    throw new java.lang.IllegalArgumentException("right to " + sideToString(i4) + " undefined");
                }
                androidx.constraintlayout.widget.ConstraintSet.Layout layout9 = constraint.layout;
                layout9.baselineToBaseline = i3;
                layout9.bottomToBottom = -1;
                layout9.bottomToTop = -1;
                layout9.topToTop = -1;
                layout9.topToBottom = -1;
                return;
            case 6:
                if (i4 == 6) {
                    androidx.constraintlayout.widget.ConstraintSet.Layout layout10 = constraint.layout;
                    layout10.startToStart = i3;
                    layout10.startToEnd = -1;
                } else {
                    if (i4 != 7) {
                        throw new java.lang.IllegalArgumentException("right to " + sideToString(i4) + " undefined");
                    }
                    androidx.constraintlayout.widget.ConstraintSet.Layout layout11 = constraint.layout;
                    layout11.startToEnd = i3;
                    layout11.startToStart = -1;
                }
                constraint.layout.startMargin = i5;
                return;
            case 7:
                if (i4 == 7) {
                    androidx.constraintlayout.widget.ConstraintSet.Layout layout12 = constraint.layout;
                    layout12.endToEnd = i3;
                    layout12.endToStart = -1;
                } else {
                    if (i4 != 6) {
                        throw new java.lang.IllegalArgumentException("right to " + sideToString(i4) + " undefined");
                    }
                    androidx.constraintlayout.widget.ConstraintSet.Layout layout13 = constraint.layout;
                    layout13.endToStart = i3;
                    layout13.endToEnd = -1;
                }
                constraint.layout.endMargin = i5;
                return;
            default:
                throw new java.lang.IllegalArgumentException(sideToString(i2) + " to " + sideToString(i4) + " unknown");
        }
    }

    public void constrainCircle(int i, int i2, int i3, float f) {
        androidx.constraintlayout.widget.ConstraintSet.Layout layout = get(i).layout;
        layout.circleConstraint = i2;
        layout.circleRadius = i3;
        layout.circleAngle = f;
    }

    public void constrainDefaultHeight(int i, int i2) {
        get(i).layout.heightDefault = i2;
    }

    public void constrainDefaultWidth(int i, int i2) {
        get(i).layout.widthDefault = i2;
    }

    public void constrainHeight(int i, int i2) {
        get(i).layout.mHeight = i2;
    }

    public void constrainMaxHeight(int i, int i2) {
        get(i).layout.heightMax = i2;
    }

    public void constrainMaxWidth(int i, int i2) {
        get(i).layout.widthMax = i2;
    }

    public void constrainMinHeight(int i, int i2) {
        get(i).layout.heightMin = i2;
    }

    public void constrainMinWidth(int i, int i2) {
        get(i).layout.widthMin = i2;
    }

    public void constrainPercentHeight(int i, float f) {
        get(i).layout.heightPercent = f;
    }

    public void constrainPercentWidth(int i, float f) {
        get(i).layout.widthPercent = f;
    }

    public void constrainWidth(int i, int i2) {
        get(i).layout.mWidth = i2;
    }

    public void constrainedHeight(int i, boolean z) {
        get(i).layout.constrainedHeight = z;
    }

    public void constrainedWidth(int i, boolean z) {
        get(i).layout.constrainedWidth = z;
    }

    public void create(int i, int i2) {
        androidx.constraintlayout.widget.ConstraintSet.Layout layout = get(i).layout;
        layout.mIsGuideline = true;
        layout.orientation = i2;
    }

    public void createBarrier(int i, int i2, int i3, int... iArr) {
        androidx.constraintlayout.widget.ConstraintSet.Layout layout = get(i).layout;
        layout.mHelperType = 1;
        layout.mBarrierDirection = i2;
        layout.mBarrierMargin = i3;
        layout.mIsGuideline = false;
        layout.mReferenceIds = iArr;
    }

    public void createHorizontalChain(int i, int i2, int i3, int i4, int[] iArr, float[] fArr, int i5) {
        createHorizontalChain(i, i2, i3, i4, iArr, fArr, i5, 1, 2);
    }

    public void createHorizontalChainRtl(int i, int i2, int i3, int i4, int[] iArr, float[] fArr, int i5) {
        createHorizontalChain(i, i2, i3, i4, iArr, fArr, i5, 6, 7);
    }

    public void createVerticalChain(int i, int i2, int i3, int i4, int[] iArr, float[] fArr, int i5) {
        if (iArr.length < 2) {
            throw new java.lang.IllegalArgumentException("must have 2 or more widgets in a chain");
        }
        if (fArr != null && fArr.length != iArr.length) {
            throw new java.lang.IllegalArgumentException("must have 2 or more widgets in a chain");
        }
        if (fArr != null) {
            get(iArr[0]).layout.verticalWeight = fArr[0];
        }
        get(iArr[0]).layout.verticalChainStyle = i5;
        connect(iArr[0], 3, i, i2, 0);
        for (int i6 = 1; i6 < iArr.length; i6++) {
            int i7 = i6 - 1;
            connect(iArr[i6], 3, iArr[i7], 4, 0);
            connect(iArr[i7], 4, iArr[i6], 3, 0);
            if (fArr != null) {
                get(iArr[i6]).layout.verticalWeight = fArr[i6];
            }
        }
        connect(iArr[iArr.length - 1], 4, i3, i4, 0);
    }

    public void dump(androidx.constraintlayout.motion.widget.MotionScene motionScene, int... iArr) {
        java.util.HashSet hashSet;
        java.util.Set<java.lang.Integer> keySet = this.mConstraints.keySet();
        if (iArr.length != 0) {
            hashSet = new java.util.HashSet();
            for (int i : iArr) {
                hashSet.add(java.lang.Integer.valueOf(i));
            }
        } else {
            hashSet = new java.util.HashSet(keySet);
        }
        java.lang.System.out.println(hashSet.size() + " constraints");
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        for (java.lang.Integer num : (java.lang.Integer[]) hashSet.toArray(new java.lang.Integer[0])) {
            androidx.constraintlayout.widget.ConstraintSet.Constraint constraint = this.mConstraints.get(num);
            sb.append("<Constraint id=");
            sb.append(num);
            sb.append(" \n");
            constraint.layout.dump(motionScene, sb);
            sb.append("/>\n");
        }
        java.lang.System.out.println(sb.toString());
    }

    public boolean getApplyElevation(int i) {
        return get(i).transform.applyElevation;
    }

    public androidx.constraintlayout.widget.ConstraintSet.Constraint getConstraint(int i) {
        if (this.mConstraints.containsKey(java.lang.Integer.valueOf(i))) {
            return this.mConstraints.get(java.lang.Integer.valueOf(i));
        }
        return null;
    }

    public java.util.HashMap<java.lang.String, androidx.constraintlayout.widget.ConstraintAttribute> getCustomAttributeSet() {
        return this.mSavedAttributes;
    }

    public int getHeight(int i) {
        return get(i).layout.mHeight;
    }

    public int[] getKnownIds() {
        java.lang.Integer[] numArr = (java.lang.Integer[]) this.mConstraints.keySet().toArray(new java.lang.Integer[0]);
        int length = numArr.length;
        int[] iArr = new int[length];
        for (int i = 0; i < length; i++) {
            iArr[i] = numArr[i].intValue();
        }
        return iArr;
    }

    public androidx.constraintlayout.widget.ConstraintSet.Constraint getParameters(int i) {
        return get(i);
    }

    public int[] getReferencedIds(int i) {
        int[] iArr = get(i).layout.mReferenceIds;
        return iArr == null ? new int[0] : java.util.Arrays.copyOf(iArr, iArr.length);
    }

    public int getVisibility(int i) {
        return get(i).propertySet.visibility;
    }

    public int getVisibilityMode(int i) {
        return get(i).propertySet.mVisibilityMode;
    }

    public int getWidth(int i) {
        return get(i).layout.mWidth;
    }

    public boolean isForceId() {
        return this.mForceId;
    }

    public void load(android.content.Context context, int i) {
        android.content.res.XmlResourceParser xml = context.getResources().getXml(i);
        try {
            for (int eventType = xml.getEventType(); eventType != 1; eventType = xml.next()) {
                if (eventType == 0) {
                    xml.getName();
                } else if (eventType == 2) {
                    java.lang.String name = xml.getName();
                    androidx.constraintlayout.widget.ConstraintSet.Constraint fillFromAttributeList = fillFromAttributeList(context, android.util.Xml.asAttributeSet(xml));
                    if (name.equalsIgnoreCase("Guideline")) {
                        fillFromAttributeList.layout.mIsGuideline = true;
                    }
                    this.mConstraints.put(java.lang.Integer.valueOf(fillFromAttributeList.mViewId), fillFromAttributeList);
                }
            }
        } catch (java.io.IOException e) {
            e.printStackTrace();
        } catch (org.xmlpull.v1.XmlPullParserException e2) {
            e2.printStackTrace();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:63:0x0178, code lost:
    
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void load(android.content.Context context, org.xmlpull.v1.XmlPullParser xmlPullParser) {
        androidx.constraintlayout.widget.ConstraintSet.Constraint fillFromAttributeList;
        try {
            int eventType = xmlPullParser.getEventType();
            androidx.constraintlayout.widget.ConstraintSet.Constraint constraint = null;
            while (eventType != 1) {
                if (eventType != 0) {
                    char c = 3;
                    if (eventType == 2) {
                        java.lang.String name = xmlPullParser.getName();
                        switch (name.hashCode()) {
                            case -2025855158:
                                if (name.equals("Layout")) {
                                    c = 5;
                                    break;
                                }
                                c = 65535;
                                break;
                            case -1984451626:
                                if (name.equals("Motion")) {
                                    c = 6;
                                    break;
                                }
                                c = 65535;
                                break;
                            case -1269513683:
                                if (name.equals("PropertySet")) {
                                    break;
                                }
                                c = 65535;
                                break;
                            case -1238332596:
                                if (name.equals("Transform")) {
                                    c = 4;
                                    break;
                                }
                                c = 65535;
                                break;
                            case -71750448:
                                if (name.equals("Guideline")) {
                                    c = 1;
                                    break;
                                }
                                c = 65535;
                                break;
                            case 1331510167:
                                if (name.equals("Barrier")) {
                                    c = 2;
                                    break;
                                }
                                c = 65535;
                                break;
                            case 1791837707:
                                if (name.equals("CustomAttribute")) {
                                    c = 7;
                                    break;
                                }
                                c = 65535;
                                break;
                            case 1803088381:
                                if (name.equals("Constraint")) {
                                    c = 0;
                                    break;
                                }
                                c = 65535;
                                break;
                            default:
                                c = 65535;
                                break;
                        }
                        switch (c) {
                            case 0:
                                fillFromAttributeList = fillFromAttributeList(context, android.util.Xml.asAttributeSet(xmlPullParser));
                                break;
                            case 1:
                                fillFromAttributeList = fillFromAttributeList(context, android.util.Xml.asAttributeSet(xmlPullParser));
                                androidx.constraintlayout.widget.ConstraintSet.Layout layout = fillFromAttributeList.layout;
                                layout.mIsGuideline = true;
                                layout.mApply = true;
                                break;
                            case 2:
                                fillFromAttributeList = fillFromAttributeList(context, android.util.Xml.asAttributeSet(xmlPullParser));
                                fillFromAttributeList.layout.mHelperType = 1;
                                break;
                            case 3:
                                if (constraint == null) {
                                    throw new java.lang.RuntimeException(ERROR_MESSAGE + xmlPullParser.getLineNumber());
                                }
                                constraint.propertySet.fillFromAttributeList(context, android.util.Xml.asAttributeSet(xmlPullParser));
                                continue;
                            case 4:
                                if (constraint == null) {
                                    throw new java.lang.RuntimeException(ERROR_MESSAGE + xmlPullParser.getLineNumber());
                                }
                                constraint.transform.fillFromAttributeList(context, android.util.Xml.asAttributeSet(xmlPullParser));
                                continue;
                            case 5:
                                if (constraint == null) {
                                    throw new java.lang.RuntimeException(ERROR_MESSAGE + xmlPullParser.getLineNumber());
                                }
                                constraint.layout.fillFromAttributeList(context, android.util.Xml.asAttributeSet(xmlPullParser));
                                continue;
                            case 6:
                                if (constraint == null) {
                                    throw new java.lang.RuntimeException(ERROR_MESSAGE + xmlPullParser.getLineNumber());
                                }
                                constraint.motion.fillFromAttributeList(context, android.util.Xml.asAttributeSet(xmlPullParser));
                                continue;
                            case 7:
                                if (constraint == null) {
                                    throw new java.lang.RuntimeException(ERROR_MESSAGE + xmlPullParser.getLineNumber());
                                }
                                androidx.constraintlayout.widget.ConstraintAttribute.parse(context, xmlPullParser, constraint.mCustomConstraints);
                                continue;
                        }
                        constraint = fillFromAttributeList;
                    } else if (eventType != 3) {
                        continue;
                    } else {
                        java.lang.String name2 = xmlPullParser.getName();
                        if (TAG.equals(name2)) {
                            return;
                        }
                        if (name2.equalsIgnoreCase("Constraint")) {
                            this.mConstraints.put(java.lang.Integer.valueOf(constraint.mViewId), constraint);
                            constraint = null;
                        }
                    }
                } else {
                    xmlPullParser.getName();
                }
                eventType = xmlPullParser.next();
            }
        } catch (java.io.IOException e) {
            e.printStackTrace();
        } catch (org.xmlpull.v1.XmlPullParserException e2) {
            e2.printStackTrace();
        }
    }

    public void parseColorAttributes(androidx.constraintlayout.widget.ConstraintSet.Constraint constraint, java.lang.String str) {
        java.lang.String[] split = str.split(",");
        for (int i = 0; i < split.length; i++) {
            java.lang.String[] split2 = split[i].split(com.huawei.hms.framework.common.ContainerUtils.KEY_VALUE_DELIMITER);
            if (split2.length != 2) {
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                sb.append(" Unable to parse ");
                sb.append(split[i]);
            } else {
                constraint.setColorValue(split2[0], android.graphics.Color.parseColor(split2[1]));
            }
        }
    }

    public void parseFloatAttributes(androidx.constraintlayout.widget.ConstraintSet.Constraint constraint, java.lang.String str) {
        java.lang.String[] split = str.split(",");
        for (int i = 0; i < split.length; i++) {
            java.lang.String[] split2 = split[i].split(com.huawei.hms.framework.common.ContainerUtils.KEY_VALUE_DELIMITER);
            if (split2.length != 2) {
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                sb.append(" Unable to parse ");
                sb.append(split[i]);
            } else {
                constraint.setFloatValue(split2[0], java.lang.Float.parseFloat(split2[1]));
            }
        }
    }

    public void parseIntAttributes(androidx.constraintlayout.widget.ConstraintSet.Constraint constraint, java.lang.String str) {
        java.lang.String[] split = str.split(",");
        for (int i = 0; i < split.length; i++) {
            java.lang.String[] split2 = split[i].split(com.huawei.hms.framework.common.ContainerUtils.KEY_VALUE_DELIMITER);
            if (split2.length != 2) {
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                sb.append(" Unable to parse ");
                sb.append(split[i]);
            } else {
                constraint.setFloatValue(split2[0], java.lang.Integer.decode(split2[1]).intValue());
            }
        }
    }

    public void parseStringAttributes(androidx.constraintlayout.widget.ConstraintSet.Constraint constraint, java.lang.String str) {
        java.lang.String[] splitString = splitString(str);
        for (int i = 0; i < splitString.length; i++) {
            java.lang.String[] split = splitString[i].split(com.huawei.hms.framework.common.ContainerUtils.KEY_VALUE_DELIMITER);
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append(" Unable to parse ");
            sb.append(splitString[i]);
            constraint.setStringValue(split[0], split[1]);
        }
    }

    public void readFallback(androidx.constraintlayout.widget.ConstraintLayout constraintLayout) {
        int childCount = constraintLayout.getChildCount();
        for (int i = 0; i < childCount; i++) {
            android.view.View childAt = constraintLayout.getChildAt(i);
            androidx.constraintlayout.widget.ConstraintLayout.LayoutParams layoutParams = (androidx.constraintlayout.widget.ConstraintLayout.LayoutParams) childAt.getLayoutParams();
            int id = childAt.getId();
            if (this.mForceId && id == -1) {
                throw new java.lang.RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
            }
            if (!this.mConstraints.containsKey(java.lang.Integer.valueOf(id))) {
                this.mConstraints.put(java.lang.Integer.valueOf(id), new androidx.constraintlayout.widget.ConstraintSet.Constraint());
            }
            androidx.constraintlayout.widget.ConstraintSet.Constraint constraint = this.mConstraints.get(java.lang.Integer.valueOf(id));
            if (!constraint.layout.mApply) {
                constraint.fillFrom(id, layoutParams);
                if (childAt instanceof androidx.constraintlayout.widget.ConstraintHelper) {
                    constraint.layout.mReferenceIds = ((androidx.constraintlayout.widget.ConstraintHelper) childAt).getReferencedIds();
                    if (childAt instanceof androidx.constraintlayout.widget.Barrier) {
                        androidx.constraintlayout.widget.Barrier barrier = (androidx.constraintlayout.widget.Barrier) childAt;
                        constraint.layout.mBarrierAllowsGoneWidgets = barrier.allowsGoneWidget();
                        constraint.layout.mBarrierDirection = barrier.getType();
                        constraint.layout.mBarrierMargin = barrier.getMargin();
                    }
                }
                constraint.layout.mApply = true;
            }
            androidx.constraintlayout.widget.ConstraintSet.PropertySet propertySet = constraint.propertySet;
            if (!propertySet.mApply) {
                propertySet.visibility = childAt.getVisibility();
                constraint.propertySet.alpha = childAt.getAlpha();
                constraint.propertySet.mApply = true;
            }
            androidx.constraintlayout.widget.ConstraintSet.Transform transform = constraint.transform;
            if (!transform.mApply) {
                transform.mApply = true;
                transform.rotation = childAt.getRotation();
                constraint.transform.rotationX = childAt.getRotationX();
                constraint.transform.rotationY = childAt.getRotationY();
                constraint.transform.scaleX = childAt.getScaleX();
                constraint.transform.scaleY = childAt.getScaleY();
                float pivotX = childAt.getPivotX();
                float pivotY = childAt.getPivotY();
                if (pivotX != 0.0d || pivotY != 0.0d) {
                    androidx.constraintlayout.widget.ConstraintSet.Transform transform2 = constraint.transform;
                    transform2.transformPivotX = pivotX;
                    transform2.transformPivotY = pivotY;
                }
                constraint.transform.translationX = childAt.getTranslationX();
                constraint.transform.translationY = childAt.getTranslationY();
                constraint.transform.translationZ = childAt.getTranslationZ();
                androidx.constraintlayout.widget.ConstraintSet.Transform transform3 = constraint.transform;
                if (transform3.applyElevation) {
                    transform3.elevation = childAt.getElevation();
                }
            }
        }
    }

    public void readFallback(androidx.constraintlayout.widget.ConstraintSet constraintSet) {
        for (java.lang.Integer num : constraintSet.mConstraints.keySet()) {
            int intValue = num.intValue();
            androidx.constraintlayout.widget.ConstraintSet.Constraint constraint = constraintSet.mConstraints.get(num);
            if (!this.mConstraints.containsKey(java.lang.Integer.valueOf(intValue))) {
                this.mConstraints.put(java.lang.Integer.valueOf(intValue), new androidx.constraintlayout.widget.ConstraintSet.Constraint());
            }
            androidx.constraintlayout.widget.ConstraintSet.Constraint constraint2 = this.mConstraints.get(java.lang.Integer.valueOf(intValue));
            androidx.constraintlayout.widget.ConstraintSet.Layout layout = constraint2.layout;
            if (!layout.mApply) {
                layout.copyFrom(constraint.layout);
            }
            androidx.constraintlayout.widget.ConstraintSet.PropertySet propertySet = constraint2.propertySet;
            if (!propertySet.mApply) {
                propertySet.copyFrom(constraint.propertySet);
            }
            androidx.constraintlayout.widget.ConstraintSet.Transform transform = constraint2.transform;
            if (!transform.mApply) {
                transform.copyFrom(constraint.transform);
            }
            androidx.constraintlayout.widget.ConstraintSet.Motion motion = constraint2.motion;
            if (!motion.mApply) {
                motion.copyFrom(constraint.motion);
            }
            for (java.lang.String str : constraint.mCustomConstraints.keySet()) {
                if (!constraint2.mCustomConstraints.containsKey(str)) {
                    constraint2.mCustomConstraints.put(str, constraint.mCustomConstraints.get(str));
                }
            }
        }
    }

    public void removeAttribute(java.lang.String str) {
        this.mSavedAttributes.remove(str);
    }

    public void removeFromHorizontalChain(int i) {
        if (this.mConstraints.containsKey(java.lang.Integer.valueOf(i))) {
            androidx.constraintlayout.widget.ConstraintSet.Layout layout = this.mConstraints.get(java.lang.Integer.valueOf(i)).layout;
            int i2 = layout.leftToRight;
            int i3 = layout.rightToLeft;
            if (i2 != -1 || i3 != -1) {
                if (i2 != -1 && i3 != -1) {
                    connect(i2, 2, i3, 1, 0);
                    connect(i3, 1, i2, 2, 0);
                } else if (i2 != -1 || i3 != -1) {
                    int i4 = layout.rightToRight;
                    if (i4 != -1) {
                        connect(i2, 2, i4, 2, 0);
                    } else {
                        int i5 = layout.leftToLeft;
                        if (i5 != -1) {
                            connect(i3, 1, i5, 1, 0);
                        }
                    }
                }
                clear(i, 1);
                clear(i, 2);
                return;
            }
            int i6 = layout.startToEnd;
            int i7 = layout.endToStart;
            if (i6 != -1 || i7 != -1) {
                if (i6 != -1 && i7 != -1) {
                    connect(i6, 7, i7, 6, 0);
                    connect(i7, 6, i2, 7, 0);
                } else if (i2 != -1 || i7 != -1) {
                    int i8 = layout.rightToRight;
                    if (i8 != -1) {
                        connect(i2, 7, i8, 7, 0);
                    } else {
                        int i9 = layout.leftToLeft;
                        if (i9 != -1) {
                            connect(i7, 6, i9, 6, 0);
                        }
                    }
                }
            }
            clear(i, 6);
            clear(i, 7);
        }
    }

    public void removeFromVerticalChain(int i) {
        if (this.mConstraints.containsKey(java.lang.Integer.valueOf(i))) {
            androidx.constraintlayout.widget.ConstraintSet.Layout layout = this.mConstraints.get(java.lang.Integer.valueOf(i)).layout;
            int i2 = layout.topToBottom;
            int i3 = layout.bottomToTop;
            if (i2 != -1 || i3 != -1) {
                if (i2 != -1 && i3 != -1) {
                    connect(i2, 4, i3, 3, 0);
                    connect(i3, 3, i2, 4, 0);
                } else if (i2 != -1 || i3 != -1) {
                    int i4 = layout.bottomToBottom;
                    if (i4 != -1) {
                        connect(i2, 4, i4, 4, 0);
                    } else {
                        int i5 = layout.topToTop;
                        if (i5 != -1) {
                            connect(i3, 3, i5, 3, 0);
                        }
                    }
                }
            }
        }
        clear(i, 3);
        clear(i, 4);
    }

    public void setAlpha(int i, float f) {
        get(i).propertySet.alpha = f;
    }

    public void setApplyElevation(int i, boolean z) {
        get(i).transform.applyElevation = z;
    }

    public void setBarrierType(int i, int i2) {
        get(i).layout.mHelperType = i2;
    }

    public void setColorValue(int i, java.lang.String str, int i2) {
        get(i).setColorValue(str, i2);
    }

    public void setDimensionRatio(int i, java.lang.String str) {
        get(i).layout.dimensionRatio = str;
    }

    public void setEditorAbsoluteX(int i, int i2) {
        get(i).layout.editorAbsoluteX = i2;
    }

    public void setEditorAbsoluteY(int i, int i2) {
        get(i).layout.editorAbsoluteY = i2;
    }

    public void setElevation(int i, float f) {
        get(i).transform.elevation = f;
        get(i).transform.applyElevation = true;
    }

    public void setFloatValue(int i, java.lang.String str, float f) {
        get(i).setFloatValue(str, f);
    }

    public void setForceId(boolean z) {
        this.mForceId = z;
    }

    public void setGoneMargin(int i, int i2, int i3) {
        androidx.constraintlayout.widget.ConstraintSet.Constraint constraint = get(i);
        switch (i2) {
            case 1:
                constraint.layout.goneLeftMargin = i3;
                return;
            case 2:
                constraint.layout.goneRightMargin = i3;
                return;
            case 3:
                constraint.layout.goneTopMargin = i3;
                return;
            case 4:
                constraint.layout.goneBottomMargin = i3;
                return;
            case 5:
                throw new java.lang.IllegalArgumentException("baseline does not support margins");
            case 6:
                constraint.layout.goneStartMargin = i3;
                return;
            case 7:
                constraint.layout.goneEndMargin = i3;
                return;
            default:
                throw new java.lang.IllegalArgumentException("unknown constraint");
        }
    }

    public void setGuidelineBegin(int i, int i2) {
        get(i).layout.guideBegin = i2;
        get(i).layout.guideEnd = -1;
        get(i).layout.guidePercent = -1.0f;
    }

    public void setGuidelineEnd(int i, int i2) {
        get(i).layout.guideEnd = i2;
        get(i).layout.guideBegin = -1;
        get(i).layout.guidePercent = -1.0f;
    }

    public void setGuidelinePercent(int i, float f) {
        get(i).layout.guidePercent = f;
        get(i).layout.guideEnd = -1;
        get(i).layout.guideBegin = -1;
    }

    public void setHorizontalBias(int i, float f) {
        get(i).layout.horizontalBias = f;
    }

    public void setHorizontalChainStyle(int i, int i2) {
        get(i).layout.horizontalChainStyle = i2;
    }

    public void setHorizontalWeight(int i, float f) {
        get(i).layout.horizontalWeight = f;
    }

    public void setIntValue(int i, java.lang.String str, int i2) {
        get(i).setIntValue(str, i2);
    }

    public void setMargin(int i, int i2, int i3) {
        androidx.constraintlayout.widget.ConstraintSet.Constraint constraint = get(i);
        switch (i2) {
            case 1:
                constraint.layout.leftMargin = i3;
                return;
            case 2:
                constraint.layout.rightMargin = i3;
                return;
            case 3:
                constraint.layout.topMargin = i3;
                return;
            case 4:
                constraint.layout.bottomMargin = i3;
                return;
            case 5:
                throw new java.lang.IllegalArgumentException("baseline does not support margins");
            case 6:
                constraint.layout.startMargin = i3;
                return;
            case 7:
                constraint.layout.endMargin = i3;
                return;
            default:
                throw new java.lang.IllegalArgumentException("unknown constraint");
        }
    }

    public void setReferencedIds(int i, int... iArr) {
        get(i).layout.mReferenceIds = iArr;
    }

    public void setRotation(int i, float f) {
        get(i).transform.rotation = f;
    }

    public void setRotationX(int i, float f) {
        get(i).transform.rotationX = f;
    }

    public void setRotationY(int i, float f) {
        get(i).transform.rotationY = f;
    }

    public void setScaleX(int i, float f) {
        get(i).transform.scaleX = f;
    }

    public void setScaleY(int i, float f) {
        get(i).transform.scaleY = f;
    }

    public void setStringValue(int i, java.lang.String str, java.lang.String str2) {
        get(i).setStringValue(str, str2);
    }

    public void setTransformPivot(int i, float f, float f2) {
        androidx.constraintlayout.widget.ConstraintSet.Transform transform = get(i).transform;
        transform.transformPivotY = f2;
        transform.transformPivotX = f;
    }

    public void setTransformPivotX(int i, float f) {
        get(i).transform.transformPivotX = f;
    }

    public void setTransformPivotY(int i, float f) {
        get(i).transform.transformPivotY = f;
    }

    public void setTranslation(int i, float f, float f2) {
        androidx.constraintlayout.widget.ConstraintSet.Transform transform = get(i).transform;
        transform.translationX = f;
        transform.translationY = f2;
    }

    public void setTranslationX(int i, float f) {
        get(i).transform.translationX = f;
    }

    public void setTranslationY(int i, float f) {
        get(i).transform.translationY = f;
    }

    public void setTranslationZ(int i, float f) {
        get(i).transform.translationZ = f;
    }

    public void setValidateOnParse(boolean z) {
        this.mValidate = z;
    }

    public void setVerticalBias(int i, float f) {
        get(i).layout.verticalBias = f;
    }

    public void setVerticalChainStyle(int i, int i2) {
        get(i).layout.verticalChainStyle = i2;
    }

    public void setVerticalWeight(int i, float f) {
        get(i).layout.verticalWeight = f;
    }

    public void setVisibility(int i, int i2) {
        get(i).propertySet.visibility = i2;
    }

    public void setVisibilityMode(int i, int i2) {
        get(i).propertySet.mVisibilityMode = i2;
    }
}
