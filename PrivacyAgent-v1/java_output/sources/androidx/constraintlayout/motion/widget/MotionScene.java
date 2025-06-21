package androidx.constraintlayout.motion.widget;

/* loaded from: classes.dex */
public class MotionScene {
    static final int ANTICIPATE = 4;
    static final int BOUNCE = 5;
    private static final boolean DEBUG = false;
    static final int EASE_IN = 1;
    static final int EASE_IN_OUT = 0;
    static final int EASE_OUT = 2;
    private static final int INTERPOLATOR_REFRENCE_ID = -2;
    public static final int LAYOUT_HONOR_REQUEST = 1;
    public static final int LAYOUT_IGNORE_REQUEST = 0;
    static final int LINEAR = 3;
    private static final int SPLINE_STRING = -1;
    public static final java.lang.String TAG = "MotionScene";
    static final int TRANSITION_BACKWARD = 0;
    static final int TRANSITION_FORWARD = 1;
    public static final int UNSET = -1;
    private android.view.MotionEvent mLastTouchDown;
    float mLastTouchX;
    float mLastTouchY;
    private final androidx.constraintlayout.motion.widget.MotionLayout mMotionLayout;
    private boolean mRtl;
    private androidx.constraintlayout.motion.widget.MotionLayout.MotionTracker mVelocityTracker;
    androidx.constraintlayout.widget.StateSet mStateSet = null;
    androidx.constraintlayout.motion.widget.MotionScene.Transition mCurrentTransition = null;
    private boolean mDisableAutoTransition = false;
    private java.util.ArrayList<androidx.constraintlayout.motion.widget.MotionScene.Transition> mTransitionList = new java.util.ArrayList<>();
    private androidx.constraintlayout.motion.widget.MotionScene.Transition mDefaultTransition = null;
    private java.util.ArrayList<androidx.constraintlayout.motion.widget.MotionScene.Transition> mAbstractTransitionList = new java.util.ArrayList<>();
    private android.util.SparseArray<androidx.constraintlayout.widget.ConstraintSet> mConstraintSetMap = new android.util.SparseArray<>();
    private java.util.HashMap<java.lang.String, java.lang.Integer> mConstraintSetIdMap = new java.util.HashMap<>();
    private android.util.SparseIntArray mDeriveMap = new android.util.SparseIntArray();
    private boolean DEBUG_DESKTOP = false;
    private int mDefaultDuration = 400;
    private int mLayoutDuringTransition = 0;
    private boolean mIgnoreTouch = false;
    private boolean mMotionOutsideRegion = false;

    /* renamed from: androidx.constraintlayout.motion.widget.MotionScene$1, reason: invalid class name */
    public class AnonymousClass1 implements android.view.animation.Interpolator {
        final /* synthetic */ androidx.constraintlayout.motion.utils.Easing val$easing;

        public AnonymousClass1(androidx.constraintlayout.motion.utils.Easing easing) {
            this.val$easing = easing;
        }

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f) {
            return (float) this.val$easing.get(f);
        }
    }

    public static class Transition {
        public static final int AUTO_ANIMATE_TO_END = 4;
        public static final int AUTO_ANIMATE_TO_START = 3;
        public static final int AUTO_JUMP_TO_END = 2;
        public static final int AUTO_JUMP_TO_START = 1;
        public static final int AUTO_NONE = 0;
        static final int TRANSITION_FLAG_FIRST_DRAW = 1;
        private int mAutoTransition;
        private int mConstraintSetEnd;
        private int mConstraintSetStart;
        private int mDefaultInterpolator;
        private int mDefaultInterpolatorID;
        private java.lang.String mDefaultInterpolatorString;
        private boolean mDisable;
        private int mDuration;
        private int mId;
        private boolean mIsAbstract;
        private java.util.ArrayList<androidx.constraintlayout.motion.widget.KeyFrames> mKeyFramesList;
        private int mLayoutDuringTransition;
        private final androidx.constraintlayout.motion.widget.MotionScene mMotionScene;
        private java.util.ArrayList<androidx.constraintlayout.motion.widget.MotionScene.Transition.TransitionOnClick> mOnClicks;
        private int mPathMotionArc;
        private float mStagger;
        private androidx.constraintlayout.motion.widget.TouchResponse mTouchResponse;
        private int mTransitionFlags;

        public static class TransitionOnClick implements android.view.View.OnClickListener {
            public static final int ANIM_TOGGLE = 17;
            public static final int ANIM_TO_END = 1;
            public static final int ANIM_TO_START = 16;
            public static final int JUMP_TO_END = 256;
            public static final int JUMP_TO_START = 4096;
            int mMode;
            int mTargetId;
            private final androidx.constraintlayout.motion.widget.MotionScene.Transition mTransition;

            public TransitionOnClick(android.content.Context context, androidx.constraintlayout.motion.widget.MotionScene.Transition transition, org.xmlpull.v1.XmlPullParser xmlPullParser) {
                this.mTargetId = -1;
                this.mMode = 17;
                this.mTransition = transition;
                android.content.res.TypedArray obtainStyledAttributes = context.obtainStyledAttributes(android.util.Xml.asAttributeSet(xmlPullParser), androidx.constraintlayout.widget.R.styleable.OnClick);
                int indexCount = obtainStyledAttributes.getIndexCount();
                for (int i = 0; i < indexCount; i++) {
                    int index = obtainStyledAttributes.getIndex(i);
                    if (index == androidx.constraintlayout.widget.R.styleable.OnClick_targetId) {
                        this.mTargetId = obtainStyledAttributes.getResourceId(index, this.mTargetId);
                    } else if (index == androidx.constraintlayout.widget.R.styleable.OnClick_clickAction) {
                        this.mMode = obtainStyledAttributes.getInt(index, this.mMode);
                    }
                }
                obtainStyledAttributes.recycle();
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r7v3, types: [android.view.View] */
            public void addOnClickListeners(androidx.constraintlayout.motion.widget.MotionLayout motionLayout, int i, androidx.constraintlayout.motion.widget.MotionScene.Transition transition) {
                int i2 = this.mTargetId;
                androidx.constraintlayout.motion.widget.MotionLayout motionLayout2 = motionLayout;
                if (i2 != -1) {
                    motionLayout2 = motionLayout.findViewById(i2);
                }
                if (motionLayout2 == null) {
                    java.lang.StringBuilder sb = new java.lang.StringBuilder();
                    sb.append("OnClick could not find id ");
                    sb.append(this.mTargetId);
                    return;
                }
                int i3 = transition.mConstraintSetStart;
                int i4 = transition.mConstraintSetEnd;
                if (i3 == -1) {
                    motionLayout2.setOnClickListener(this);
                    return;
                }
                int i5 = this.mMode;
                boolean z = false;
                boolean z2 = ((i5 & 1) != 0 && i == i3) | ((i5 & 1) != 0 && i == i3) | ((i5 & 256) != 0 && i == i3) | ((i5 & 16) != 0 && i == i4);
                if ((i5 & 4096) != 0 && i == i4) {
                    z = true;
                }
                if (z2 || z) {
                    motionLayout2.setOnClickListener(this);
                }
            }

            public boolean isTransitionViable(androidx.constraintlayout.motion.widget.MotionScene.Transition transition, androidx.constraintlayout.motion.widget.MotionLayout motionLayout) {
                androidx.constraintlayout.motion.widget.MotionScene.Transition transition2 = this.mTransition;
                if (transition2 == transition) {
                    return true;
                }
                int i = transition2.mConstraintSetEnd;
                int i2 = this.mTransition.mConstraintSetStart;
                if (i2 == -1) {
                    return motionLayout.mCurrentState != i;
                }
                int i3 = motionLayout.mCurrentState;
                return i3 == i2 || i3 == i;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(android.view.View view) {
                androidx.constraintlayout.motion.widget.MotionLayout motionLayout = this.mTransition.mMotionScene.mMotionLayout;
                if (motionLayout.isInteractionEnabled()) {
                    if (this.mTransition.mConstraintSetStart == -1) {
                        int currentState = motionLayout.getCurrentState();
                        if (currentState == -1) {
                            motionLayout.transitionToState(this.mTransition.mConstraintSetEnd);
                            return;
                        }
                        androidx.constraintlayout.motion.widget.MotionScene.Transition transition = new androidx.constraintlayout.motion.widget.MotionScene.Transition(this.mTransition.mMotionScene, this.mTransition);
                        transition.mConstraintSetStart = currentState;
                        transition.mConstraintSetEnd = this.mTransition.mConstraintSetEnd;
                        motionLayout.setTransition(transition);
                        motionLayout.transitionToEnd();
                        return;
                    }
                    androidx.constraintlayout.motion.widget.MotionScene.Transition transition2 = this.mTransition.mMotionScene.mCurrentTransition;
                    int i = this.mMode;
                    boolean z = false;
                    boolean z2 = ((i & 1) == 0 && (i & 256) == 0) ? false : true;
                    boolean z3 = ((i & 16) == 0 && (i & 4096) == 0) ? false : true;
                    if (z2 && z3) {
                        androidx.constraintlayout.motion.widget.MotionScene.Transition transition3 = this.mTransition.mMotionScene.mCurrentTransition;
                        androidx.constraintlayout.motion.widget.MotionScene.Transition transition4 = this.mTransition;
                        if (transition3 != transition4) {
                            motionLayout.setTransition(transition4);
                        }
                        if (motionLayout.getCurrentState() != motionLayout.getEndState() && motionLayout.getProgress() <= 0.5f) {
                            z = z2;
                            z3 = false;
                        }
                    } else {
                        z = z2;
                    }
                    if (isTransitionViable(transition2, motionLayout)) {
                        if (z && (this.mMode & 1) != 0) {
                            motionLayout.setTransition(this.mTransition);
                            motionLayout.transitionToEnd();
                            return;
                        }
                        if (z3 && (this.mMode & 16) != 0) {
                            motionLayout.setTransition(this.mTransition);
                            motionLayout.transitionToStart();
                        } else if (z && (this.mMode & 256) != 0) {
                            motionLayout.setTransition(this.mTransition);
                            motionLayout.setProgress(1.0f);
                        } else {
                            if (!z3 || (this.mMode & 4096) == 0) {
                                return;
                            }
                            motionLayout.setTransition(this.mTransition);
                            motionLayout.setProgress(0.0f);
                        }
                    }
                }
            }

            public void removeOnClickListeners(androidx.constraintlayout.motion.widget.MotionLayout motionLayout) {
                int i = this.mTargetId;
                if (i == -1) {
                    return;
                }
                android.view.View findViewById = motionLayout.findViewById(i);
                if (findViewById != null) {
                    findViewById.setOnClickListener(null);
                    return;
                }
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                sb.append(" (*)  could not find id ");
                sb.append(this.mTargetId);
            }
        }

        public Transition(int i, androidx.constraintlayout.motion.widget.MotionScene motionScene, int i2, int i3) {
            this.mId = -1;
            this.mIsAbstract = false;
            this.mConstraintSetEnd = -1;
            this.mConstraintSetStart = -1;
            this.mDefaultInterpolator = 0;
            this.mDefaultInterpolatorString = null;
            this.mDefaultInterpolatorID = -1;
            this.mDuration = 400;
            this.mStagger = 0.0f;
            this.mKeyFramesList = new java.util.ArrayList<>();
            this.mTouchResponse = null;
            this.mOnClicks = new java.util.ArrayList<>();
            this.mAutoTransition = 0;
            this.mDisable = false;
            this.mPathMotionArc = -1;
            this.mLayoutDuringTransition = 0;
            this.mTransitionFlags = 0;
            this.mId = i;
            this.mMotionScene = motionScene;
            this.mConstraintSetStart = i2;
            this.mConstraintSetEnd = i3;
            this.mDuration = motionScene.mDefaultDuration;
            this.mLayoutDuringTransition = motionScene.mLayoutDuringTransition;
        }

        public Transition(androidx.constraintlayout.motion.widget.MotionScene motionScene, android.content.Context context, org.xmlpull.v1.XmlPullParser xmlPullParser) {
            this.mId = -1;
            this.mIsAbstract = false;
            this.mConstraintSetEnd = -1;
            this.mConstraintSetStart = -1;
            this.mDefaultInterpolator = 0;
            this.mDefaultInterpolatorString = null;
            this.mDefaultInterpolatorID = -1;
            this.mDuration = 400;
            this.mStagger = 0.0f;
            this.mKeyFramesList = new java.util.ArrayList<>();
            this.mTouchResponse = null;
            this.mOnClicks = new java.util.ArrayList<>();
            this.mAutoTransition = 0;
            this.mDisable = false;
            this.mPathMotionArc = -1;
            this.mLayoutDuringTransition = 0;
            this.mTransitionFlags = 0;
            this.mDuration = motionScene.mDefaultDuration;
            this.mLayoutDuringTransition = motionScene.mLayoutDuringTransition;
            this.mMotionScene = motionScene;
            fillFromAttributeList(motionScene, context, android.util.Xml.asAttributeSet(xmlPullParser));
        }

        public Transition(androidx.constraintlayout.motion.widget.MotionScene motionScene, androidx.constraintlayout.motion.widget.MotionScene.Transition transition) {
            this.mId = -1;
            this.mIsAbstract = false;
            this.mConstraintSetEnd = -1;
            this.mConstraintSetStart = -1;
            this.mDefaultInterpolator = 0;
            this.mDefaultInterpolatorString = null;
            this.mDefaultInterpolatorID = -1;
            this.mDuration = 400;
            this.mStagger = 0.0f;
            this.mKeyFramesList = new java.util.ArrayList<>();
            this.mTouchResponse = null;
            this.mOnClicks = new java.util.ArrayList<>();
            this.mAutoTransition = 0;
            this.mDisable = false;
            this.mPathMotionArc = -1;
            this.mLayoutDuringTransition = 0;
            this.mTransitionFlags = 0;
            this.mMotionScene = motionScene;
            if (transition != null) {
                this.mPathMotionArc = transition.mPathMotionArc;
                this.mDefaultInterpolator = transition.mDefaultInterpolator;
                this.mDefaultInterpolatorString = transition.mDefaultInterpolatorString;
                this.mDefaultInterpolatorID = transition.mDefaultInterpolatorID;
                this.mDuration = transition.mDuration;
                this.mKeyFramesList = transition.mKeyFramesList;
                this.mStagger = transition.mStagger;
                this.mLayoutDuringTransition = transition.mLayoutDuringTransition;
            }
        }

        private void fill(androidx.constraintlayout.motion.widget.MotionScene motionScene, android.content.Context context, android.content.res.TypedArray typedArray) {
            int indexCount = typedArray.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = typedArray.getIndex(i);
                if (index == androidx.constraintlayout.widget.R.styleable.Transition_constraintSetEnd) {
                    this.mConstraintSetEnd = typedArray.getResourceId(index, this.mConstraintSetEnd);
                    if ("layout".equals(context.getResources().getResourceTypeName(this.mConstraintSetEnd))) {
                        androidx.constraintlayout.widget.ConstraintSet constraintSet = new androidx.constraintlayout.widget.ConstraintSet();
                        constraintSet.load(context, this.mConstraintSetEnd);
                        motionScene.mConstraintSetMap.append(this.mConstraintSetEnd, constraintSet);
                    }
                } else if (index == androidx.constraintlayout.widget.R.styleable.Transition_constraintSetStart) {
                    this.mConstraintSetStart = typedArray.getResourceId(index, this.mConstraintSetStart);
                    if ("layout".equals(context.getResources().getResourceTypeName(this.mConstraintSetStart))) {
                        androidx.constraintlayout.widget.ConstraintSet constraintSet2 = new androidx.constraintlayout.widget.ConstraintSet();
                        constraintSet2.load(context, this.mConstraintSetStart);
                        motionScene.mConstraintSetMap.append(this.mConstraintSetStart, constraintSet2);
                    }
                } else if (index == androidx.constraintlayout.widget.R.styleable.Transition_motionInterpolator) {
                    int i2 = typedArray.peekValue(index).type;
                    if (i2 == 1) {
                        int resourceId = typedArray.getResourceId(index, -1);
                        this.mDefaultInterpolatorID = resourceId;
                        if (resourceId != -1) {
                            this.mDefaultInterpolator = -2;
                        }
                    } else if (i2 == 3) {
                        java.lang.String string = typedArray.getString(index);
                        this.mDefaultInterpolatorString = string;
                        if (string.indexOf(net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR) > 0) {
                            this.mDefaultInterpolatorID = typedArray.getResourceId(index, -1);
                            this.mDefaultInterpolator = -2;
                        } else {
                            this.mDefaultInterpolator = -1;
                        }
                    } else {
                        this.mDefaultInterpolator = typedArray.getInteger(index, this.mDefaultInterpolator);
                    }
                } else if (index == androidx.constraintlayout.widget.R.styleable.Transition_duration) {
                    this.mDuration = typedArray.getInt(index, this.mDuration);
                } else if (index == androidx.constraintlayout.widget.R.styleable.Transition_staggered) {
                    this.mStagger = typedArray.getFloat(index, this.mStagger);
                } else if (index == androidx.constraintlayout.widget.R.styleable.Transition_autoTransition) {
                    this.mAutoTransition = typedArray.getInteger(index, this.mAutoTransition);
                } else if (index == androidx.constraintlayout.widget.R.styleable.Transition_android_id) {
                    this.mId = typedArray.getResourceId(index, this.mId);
                } else if (index == androidx.constraintlayout.widget.R.styleable.Transition_transitionDisable) {
                    this.mDisable = typedArray.getBoolean(index, this.mDisable);
                } else if (index == androidx.constraintlayout.widget.R.styleable.Transition_pathMotionArc) {
                    this.mPathMotionArc = typedArray.getInteger(index, -1);
                } else if (index == androidx.constraintlayout.widget.R.styleable.Transition_layoutDuringTransition) {
                    this.mLayoutDuringTransition = typedArray.getInteger(index, 0);
                } else if (index == androidx.constraintlayout.widget.R.styleable.Transition_transitionFlags) {
                    this.mTransitionFlags = typedArray.getInteger(index, 0);
                }
            }
            if (this.mConstraintSetStart == -1) {
                this.mIsAbstract = true;
            }
        }

        private void fillFromAttributeList(androidx.constraintlayout.motion.widget.MotionScene motionScene, android.content.Context context, android.util.AttributeSet attributeSet) {
            android.content.res.TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, androidx.constraintlayout.widget.R.styleable.Transition);
            fill(motionScene, context, obtainStyledAttributes);
            obtainStyledAttributes.recycle();
        }

        public void addOnClick(android.content.Context context, org.xmlpull.v1.XmlPullParser xmlPullParser) {
            this.mOnClicks.add(new androidx.constraintlayout.motion.widget.MotionScene.Transition.TransitionOnClick(context, this, xmlPullParser));
        }

        public java.lang.String debugString(android.content.Context context) {
            java.lang.String resourceEntryName = this.mConstraintSetStart == -1 ? com.igexin.push.core.b.m : context.getResources().getResourceEntryName(this.mConstraintSetStart);
            if (this.mConstraintSetEnd == -1) {
                return resourceEntryName + " -> null";
            }
            return resourceEntryName + " -> " + context.getResources().getResourceEntryName(this.mConstraintSetEnd);
        }

        public int getAutoTransition() {
            return this.mAutoTransition;
        }

        public int getDuration() {
            return this.mDuration;
        }

        public int getEndConstraintSetId() {
            return this.mConstraintSetEnd;
        }

        public int getId() {
            return this.mId;
        }

        public java.util.List<androidx.constraintlayout.motion.widget.KeyFrames> getKeyFrameList() {
            return this.mKeyFramesList;
        }

        public int getLayoutDuringTransition() {
            return this.mLayoutDuringTransition;
        }

        public java.util.List<androidx.constraintlayout.motion.widget.MotionScene.Transition.TransitionOnClick> getOnClickList() {
            return this.mOnClicks;
        }

        public int getPathMotionArc() {
            return this.mPathMotionArc;
        }

        public float getStagger() {
            return this.mStagger;
        }

        public int getStartConstraintSetId() {
            return this.mConstraintSetStart;
        }

        public androidx.constraintlayout.motion.widget.TouchResponse getTouchResponse() {
            return this.mTouchResponse;
        }

        public boolean isEnabled() {
            return !this.mDisable;
        }

        public boolean isTransitionFlag(int i) {
            return (i & this.mTransitionFlags) != 0;
        }

        public void setAutoTransition(int i) {
            this.mAutoTransition = i;
        }

        public void setDuration(int i) {
            this.mDuration = i;
        }

        public void setEnable(boolean z) {
            this.mDisable = !z;
        }

        public void setPathMotionArc(int i) {
            this.mPathMotionArc = i;
        }

        public void setStagger(float f) {
            this.mStagger = f;
        }
    }

    public MotionScene(android.content.Context context, androidx.constraintlayout.motion.widget.MotionLayout motionLayout, int i) {
        this.mMotionLayout = motionLayout;
        load(context, i);
        android.util.SparseArray<androidx.constraintlayout.widget.ConstraintSet> sparseArray = this.mConstraintSetMap;
        int i2 = androidx.constraintlayout.widget.R.id.motion_base;
        sparseArray.put(i2, new androidx.constraintlayout.widget.ConstraintSet());
        this.mConstraintSetIdMap.put("motion_base", java.lang.Integer.valueOf(i2));
    }

    public MotionScene(androidx.constraintlayout.motion.widget.MotionLayout motionLayout) {
        this.mMotionLayout = motionLayout;
    }

    private int getId(android.content.Context context, java.lang.String str) {
        int i;
        if (str.contains(net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR)) {
            i = context.getResources().getIdentifier(str.substring(str.indexOf(47) + 1), "id", context.getPackageName());
            if (this.DEBUG_DESKTOP) {
                java.lang.System.out.println("id getMap res = " + i);
            }
        } else {
            i = -1;
        }
        return (i != -1 || str.length() <= 1) ? i : java.lang.Integer.parseInt(str.substring(1));
    }

    private int getIndex(androidx.constraintlayout.motion.widget.MotionScene.Transition transition) {
        int i = transition.mId;
        if (i == -1) {
            throw new java.lang.IllegalArgumentException("The transition must have an id");
        }
        for (int i2 = 0; i2 < this.mTransitionList.size(); i2++) {
            if (this.mTransitionList.get(i2).mId == i) {
                return i2;
            }
        }
        return -1;
    }

    private int getRealID(int i) {
        int stateGetConstraintID;
        androidx.constraintlayout.widget.StateSet stateSet = this.mStateSet;
        return (stateSet == null || (stateGetConstraintID = stateSet.stateGetConstraintID(i, -1, -1)) == -1) ? i : stateGetConstraintID;
    }

    private boolean hasCycleDependency(int i) {
        int i2 = this.mDeriveMap.get(i);
        int size = this.mDeriveMap.size();
        while (i2 > 0) {
            if (i2 == i) {
                return true;
            }
            int i3 = size - 1;
            if (size < 0) {
                return true;
            }
            i2 = this.mDeriveMap.get(i2);
            size = i3;
        }
        return false;
    }

    private boolean isProcessingTouch() {
        return this.mVelocityTracker != null;
    }

    private void load(android.content.Context context, int i) {
        android.content.res.XmlResourceParser xml = context.getResources().getXml(i);
        try {
            int eventType = xml.getEventType();
            androidx.constraintlayout.motion.widget.MotionScene.Transition transition = null;
            while (true) {
                char c = 1;
                if (eventType == 1) {
                    return;
                }
                if (eventType == 0) {
                    xml.getName();
                } else if (eventType == 2) {
                    java.lang.String name = xml.getName();
                    if (this.DEBUG_DESKTOP) {
                        java.lang.System.out.println("parsing = " + name);
                    }
                    switch (name.hashCode()) {
                        case -1349929691:
                            if (name.equals("ConstraintSet")) {
                                c = 5;
                                break;
                            }
                            c = 65535;
                            break;
                        case -1239391468:
                            if (name.equals("KeyFrameSet")) {
                                c = 6;
                                break;
                            }
                            c = 65535;
                            break;
                        case 269306229:
                            if (name.equals("Transition")) {
                                break;
                            }
                            c = 65535;
                            break;
                        case 312750793:
                            if (name.equals("OnClick")) {
                                c = 3;
                                break;
                            }
                            c = 65535;
                            break;
                        case 327855227:
                            if (name.equals("OnSwipe")) {
                                c = 2;
                                break;
                            }
                            c = 65535;
                            break;
                        case 793277014:
                            if (name.equals(TAG)) {
                                c = 0;
                                break;
                            }
                            c = 65535;
                            break;
                        case 1382829617:
                            if (name.equals("StateSet")) {
                                c = 4;
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
                            parseMotionSceneTags(context, xml);
                            break;
                        case 1:
                            java.util.ArrayList<androidx.constraintlayout.motion.widget.MotionScene.Transition> arrayList = this.mTransitionList;
                            transition = new androidx.constraintlayout.motion.widget.MotionScene.Transition(this, context, xml);
                            arrayList.add(transition);
                            if (this.mCurrentTransition == null && !transition.mIsAbstract) {
                                this.mCurrentTransition = transition;
                                if (transition.mTouchResponse != null) {
                                    this.mCurrentTransition.mTouchResponse.setRTL(this.mRtl);
                                }
                            }
                            if (!transition.mIsAbstract) {
                                break;
                            } else {
                                if (transition.mConstraintSetEnd == -1) {
                                    this.mDefaultTransition = transition;
                                } else {
                                    this.mAbstractTransitionList.add(transition);
                                }
                                this.mTransitionList.remove(transition);
                                break;
                            }
                            break;
                        case 2:
                            if (transition == null) {
                                java.lang.String resourceEntryName = context.getResources().getResourceEntryName(i);
                                int lineNumber = xml.getLineNumber();
                                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                                sb.append(" OnSwipe (");
                                sb.append(resourceEntryName);
                                sb.append(".xml:");
                                sb.append(lineNumber);
                                sb.append(")");
                            }
                            transition.mTouchResponse = new androidx.constraintlayout.motion.widget.TouchResponse(context, this.mMotionLayout, xml);
                            break;
                        case 3:
                            transition.addOnClick(context, xml);
                            break;
                        case 4:
                            this.mStateSet = new androidx.constraintlayout.widget.StateSet(context, xml);
                            break;
                        case 5:
                            parseConstraintSet(context, xml);
                            break;
                        case 6:
                            transition.mKeyFramesList.add(new androidx.constraintlayout.motion.widget.KeyFrames(context, xml));
                            break;
                        default:
                            java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
                            sb2.append("WARNING UNKNOWN ATTRIBUTE ");
                            sb2.append(name);
                            break;
                    }
                }
                eventType = xml.next();
            }
        } catch (java.io.IOException e) {
            e.printStackTrace();
        } catch (org.xmlpull.v1.XmlPullParserException e2) {
            e2.printStackTrace();
        }
    }

    private void parseConstraintSet(android.content.Context context, org.xmlpull.v1.XmlPullParser xmlPullParser) {
        androidx.constraintlayout.widget.ConstraintSet constraintSet = new androidx.constraintlayout.widget.ConstraintSet();
        constraintSet.setForceId(false);
        int attributeCount = xmlPullParser.getAttributeCount();
        int i = -1;
        int i2 = -1;
        for (int i3 = 0; i3 < attributeCount; i3++) {
            java.lang.String attributeName = xmlPullParser.getAttributeName(i3);
            java.lang.String attributeValue = xmlPullParser.getAttributeValue(i3);
            if (this.DEBUG_DESKTOP) {
                java.lang.System.out.println("id string = " + attributeValue);
            }
            attributeName.hashCode();
            if (attributeName.equals("deriveConstraintsFrom")) {
                i2 = getId(context, attributeValue);
            } else if (attributeName.equals("id")) {
                i = getId(context, attributeValue);
                this.mConstraintSetIdMap.put(stripID(attributeValue), java.lang.Integer.valueOf(i));
            }
        }
        if (i != -1) {
            if (this.mMotionLayout.mDebugPath != 0) {
                constraintSet.setValidateOnParse(true);
            }
            constraintSet.load(context, xmlPullParser);
            if (i2 != -1) {
                this.mDeriveMap.put(i, i2);
            }
            this.mConstraintSetMap.put(i, constraintSet);
        }
    }

    private void parseMotionSceneTags(android.content.Context context, org.xmlpull.v1.XmlPullParser xmlPullParser) {
        android.content.res.TypedArray obtainStyledAttributes = context.obtainStyledAttributes(android.util.Xml.asAttributeSet(xmlPullParser), androidx.constraintlayout.widget.R.styleable.MotionScene);
        int indexCount = obtainStyledAttributes.getIndexCount();
        for (int i = 0; i < indexCount; i++) {
            int index = obtainStyledAttributes.getIndex(i);
            if (index == androidx.constraintlayout.widget.R.styleable.MotionScene_defaultDuration) {
                this.mDefaultDuration = obtainStyledAttributes.getInt(index, this.mDefaultDuration);
            } else if (index == androidx.constraintlayout.widget.R.styleable.MotionScene_layoutDuringTransition) {
                this.mLayoutDuringTransition = obtainStyledAttributes.getInteger(index, 0);
            }
        }
        obtainStyledAttributes.recycle();
    }

    private void readConstraintChain(int i) {
        int i2 = this.mDeriveMap.get(i);
        if (i2 > 0) {
            readConstraintChain(this.mDeriveMap.get(i));
            androidx.constraintlayout.widget.ConstraintSet constraintSet = this.mConstraintSetMap.get(i);
            androidx.constraintlayout.widget.ConstraintSet constraintSet2 = this.mConstraintSetMap.get(i2);
            if (constraintSet2 != null) {
                constraintSet.readFallback(constraintSet2);
                this.mDeriveMap.put(i, -1);
            } else {
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                sb.append("ERROR! invalid deriveConstraintsFrom: @id/");
                sb.append(androidx.constraintlayout.motion.widget.Debug.getName(this.mMotionLayout.getContext(), i2));
            }
        }
    }

    public static java.lang.String stripID(java.lang.String str) {
        if (str == null) {
            return "";
        }
        int indexOf = str.indexOf(47);
        return indexOf < 0 ? str : str.substring(indexOf + 1);
    }

    public void addOnClickListeners(androidx.constraintlayout.motion.widget.MotionLayout motionLayout, int i) {
        java.util.Iterator<androidx.constraintlayout.motion.widget.MotionScene.Transition> it = this.mTransitionList.iterator();
        while (it.hasNext()) {
            androidx.constraintlayout.motion.widget.MotionScene.Transition next = it.next();
            if (next.mOnClicks.size() > 0) {
                java.util.Iterator it2 = next.mOnClicks.iterator();
                while (it2.hasNext()) {
                    ((androidx.constraintlayout.motion.widget.MotionScene.Transition.TransitionOnClick) it2.next()).removeOnClickListeners(motionLayout);
                }
            }
        }
        java.util.Iterator<androidx.constraintlayout.motion.widget.MotionScene.Transition> it3 = this.mAbstractTransitionList.iterator();
        while (it3.hasNext()) {
            androidx.constraintlayout.motion.widget.MotionScene.Transition next2 = it3.next();
            if (next2.mOnClicks.size() > 0) {
                java.util.Iterator it4 = next2.mOnClicks.iterator();
                while (it4.hasNext()) {
                    ((androidx.constraintlayout.motion.widget.MotionScene.Transition.TransitionOnClick) it4.next()).removeOnClickListeners(motionLayout);
                }
            }
        }
        java.util.Iterator<androidx.constraintlayout.motion.widget.MotionScene.Transition> it5 = this.mTransitionList.iterator();
        while (it5.hasNext()) {
            androidx.constraintlayout.motion.widget.MotionScene.Transition next3 = it5.next();
            if (next3.mOnClicks.size() > 0) {
                java.util.Iterator it6 = next3.mOnClicks.iterator();
                while (it6.hasNext()) {
                    ((androidx.constraintlayout.motion.widget.MotionScene.Transition.TransitionOnClick) it6.next()).addOnClickListeners(motionLayout, i, next3);
                }
            }
        }
        java.util.Iterator<androidx.constraintlayout.motion.widget.MotionScene.Transition> it7 = this.mAbstractTransitionList.iterator();
        while (it7.hasNext()) {
            androidx.constraintlayout.motion.widget.MotionScene.Transition next4 = it7.next();
            if (next4.mOnClicks.size() > 0) {
                java.util.Iterator it8 = next4.mOnClicks.iterator();
                while (it8.hasNext()) {
                    ((androidx.constraintlayout.motion.widget.MotionScene.Transition.TransitionOnClick) it8.next()).addOnClickListeners(motionLayout, i, next4);
                }
            }
        }
    }

    public void addTransition(androidx.constraintlayout.motion.widget.MotionScene.Transition transition) {
        int index = getIndex(transition);
        if (index == -1) {
            this.mTransitionList.add(transition);
        } else {
            this.mTransitionList.set(index, transition);
        }
    }

    public boolean autoTransition(androidx.constraintlayout.motion.widget.MotionLayout motionLayout, int i) {
        if (isProcessingTouch() || this.mDisableAutoTransition) {
            return false;
        }
        java.util.Iterator<androidx.constraintlayout.motion.widget.MotionScene.Transition> it = this.mTransitionList.iterator();
        while (it.hasNext()) {
            androidx.constraintlayout.motion.widget.MotionScene.Transition next = it.next();
            if (next.mAutoTransition != 0 && this.mCurrentTransition != next) {
                if (i == next.mConstraintSetStart && (next.mAutoTransition == 4 || next.mAutoTransition == 2)) {
                    androidx.constraintlayout.motion.widget.MotionLayout.TransitionState transitionState = androidx.constraintlayout.motion.widget.MotionLayout.TransitionState.FINISHED;
                    motionLayout.setState(transitionState);
                    motionLayout.setTransition(next);
                    if (next.mAutoTransition == 4) {
                        motionLayout.transitionToEnd();
                        motionLayout.setState(androidx.constraintlayout.motion.widget.MotionLayout.TransitionState.SETUP);
                        motionLayout.setState(androidx.constraintlayout.motion.widget.MotionLayout.TransitionState.MOVING);
                    } else {
                        motionLayout.setProgress(1.0f);
                        motionLayout.evaluate(true);
                        motionLayout.setState(androidx.constraintlayout.motion.widget.MotionLayout.TransitionState.SETUP);
                        motionLayout.setState(androidx.constraintlayout.motion.widget.MotionLayout.TransitionState.MOVING);
                        motionLayout.setState(transitionState);
                        motionLayout.onNewStateAttachHandlers();
                    }
                    return true;
                }
                if (i == next.mConstraintSetEnd && (next.mAutoTransition == 3 || next.mAutoTransition == 1)) {
                    androidx.constraintlayout.motion.widget.MotionLayout.TransitionState transitionState2 = androidx.constraintlayout.motion.widget.MotionLayout.TransitionState.FINISHED;
                    motionLayout.setState(transitionState2);
                    motionLayout.setTransition(next);
                    if (next.mAutoTransition == 3) {
                        motionLayout.transitionToStart();
                        motionLayout.setState(androidx.constraintlayout.motion.widget.MotionLayout.TransitionState.SETUP);
                        motionLayout.setState(androidx.constraintlayout.motion.widget.MotionLayout.TransitionState.MOVING);
                    } else {
                        motionLayout.setProgress(0.0f);
                        motionLayout.evaluate(true);
                        motionLayout.setState(androidx.constraintlayout.motion.widget.MotionLayout.TransitionState.SETUP);
                        motionLayout.setState(androidx.constraintlayout.motion.widget.MotionLayout.TransitionState.MOVING);
                        motionLayout.setState(transitionState2);
                        motionLayout.onNewStateAttachHandlers();
                    }
                    return true;
                }
            }
        }
        return false;
    }

    public androidx.constraintlayout.motion.widget.MotionScene.Transition bestTransitionFor(int i, float f, float f2, android.view.MotionEvent motionEvent) {
        if (i == -1) {
            return this.mCurrentTransition;
        }
        java.util.List<androidx.constraintlayout.motion.widget.MotionScene.Transition> transitionsWithState = getTransitionsWithState(i);
        android.graphics.RectF rectF = new android.graphics.RectF();
        float f3 = 0.0f;
        androidx.constraintlayout.motion.widget.MotionScene.Transition transition = null;
        for (androidx.constraintlayout.motion.widget.MotionScene.Transition transition2 : transitionsWithState) {
            if (!transition2.mDisable && transition2.mTouchResponse != null) {
                transition2.mTouchResponse.setRTL(this.mRtl);
                android.graphics.RectF touchRegion = transition2.mTouchResponse.getTouchRegion(this.mMotionLayout, rectF);
                if (touchRegion == null || motionEvent == null || touchRegion.contains(motionEvent.getX(), motionEvent.getY())) {
                    android.graphics.RectF touchRegion2 = transition2.mTouchResponse.getTouchRegion(this.mMotionLayout, rectF);
                    if (touchRegion2 == null || motionEvent == null || touchRegion2.contains(motionEvent.getX(), motionEvent.getY())) {
                        float dot = transition2.mTouchResponse.dot(f, f2) * (transition2.mConstraintSetEnd == i ? -1.0f : 1.1f);
                        if (dot > f3) {
                            transition = transition2;
                            f3 = dot;
                        }
                    }
                }
            }
        }
        return transition;
    }

    public void disableAutoTransition(boolean z) {
        this.mDisableAutoTransition = z;
    }

    public int gatPathMotionArc() {
        androidx.constraintlayout.motion.widget.MotionScene.Transition transition = this.mCurrentTransition;
        if (transition != null) {
            return transition.mPathMotionArc;
        }
        return -1;
    }

    public androidx.constraintlayout.widget.ConstraintSet getConstraintSet(int i) {
        return getConstraintSet(i, -1, -1);
    }

    public androidx.constraintlayout.widget.ConstraintSet getConstraintSet(int i, int i2, int i3) {
        int stateGetConstraintID;
        if (this.DEBUG_DESKTOP) {
            java.lang.System.out.println("id " + i);
            java.lang.System.out.println("size " + this.mConstraintSetMap.size());
        }
        androidx.constraintlayout.widget.StateSet stateSet = this.mStateSet;
        if (stateSet != null && (stateGetConstraintID = stateSet.stateGetConstraintID(i, i2, i3)) != -1) {
            i = stateGetConstraintID;
        }
        if (this.mConstraintSetMap.get(i) != null) {
            return this.mConstraintSetMap.get(i);
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("Warning could not find ConstraintSet id/");
        sb.append(androidx.constraintlayout.motion.widget.Debug.getName(this.mMotionLayout.getContext(), i));
        sb.append(" In MotionScene");
        android.util.SparseArray<androidx.constraintlayout.widget.ConstraintSet> sparseArray = this.mConstraintSetMap;
        return sparseArray.get(sparseArray.keyAt(0));
    }

    public androidx.constraintlayout.widget.ConstraintSet getConstraintSet(android.content.Context context, java.lang.String str) {
        if (this.DEBUG_DESKTOP) {
            java.lang.System.out.println("id " + str);
            java.lang.System.out.println("size " + this.mConstraintSetMap.size());
        }
        for (int i = 0; i < this.mConstraintSetMap.size(); i++) {
            int keyAt = this.mConstraintSetMap.keyAt(i);
            java.lang.String resourceName = context.getResources().getResourceName(keyAt);
            if (this.DEBUG_DESKTOP) {
                java.lang.System.out.println("Id for <" + i + "> is <" + resourceName + "> looking for <" + str + ">");
            }
            if (str.equals(resourceName)) {
                return this.mConstraintSetMap.get(keyAt);
            }
        }
        return null;
    }

    public int[] getConstraintSetIds() {
        int size = this.mConstraintSetMap.size();
        int[] iArr = new int[size];
        for (int i = 0; i < size; i++) {
            iArr[i] = this.mConstraintSetMap.keyAt(i);
        }
        return iArr;
    }

    public java.util.ArrayList<androidx.constraintlayout.motion.widget.MotionScene.Transition> getDefinedTransitions() {
        return this.mTransitionList;
    }

    public int getDuration() {
        androidx.constraintlayout.motion.widget.MotionScene.Transition transition = this.mCurrentTransition;
        return transition != null ? transition.mDuration : this.mDefaultDuration;
    }

    public int getEndId() {
        androidx.constraintlayout.motion.widget.MotionScene.Transition transition = this.mCurrentTransition;
        if (transition == null) {
            return -1;
        }
        return transition.mConstraintSetEnd;
    }

    public android.view.animation.Interpolator getInterpolator() {
        int i = this.mCurrentTransition.mDefaultInterpolator;
        if (i == -2) {
            return android.view.animation.AnimationUtils.loadInterpolator(this.mMotionLayout.getContext(), this.mCurrentTransition.mDefaultInterpolatorID);
        }
        if (i == -1) {
            return new androidx.constraintlayout.motion.widget.MotionScene.AnonymousClass1(androidx.constraintlayout.motion.utils.Easing.getInterpolator(this.mCurrentTransition.mDefaultInterpolatorString));
        }
        if (i == 0) {
            return new android.view.animation.AccelerateDecelerateInterpolator();
        }
        if (i == 1) {
            return new android.view.animation.AccelerateInterpolator();
        }
        if (i == 2) {
            return new android.view.animation.DecelerateInterpolator();
        }
        if (i == 4) {
            return new android.view.animation.AnticipateInterpolator();
        }
        if (i != 5) {
            return null;
        }
        return new android.view.animation.BounceInterpolator();
    }

    public androidx.constraintlayout.motion.widget.Key getKeyFrame(android.content.Context context, int i, int i2, int i3) {
        androidx.constraintlayout.motion.widget.MotionScene.Transition transition = this.mCurrentTransition;
        if (transition == null) {
            return null;
        }
        java.util.Iterator it = transition.mKeyFramesList.iterator();
        while (it.hasNext()) {
            androidx.constraintlayout.motion.widget.KeyFrames keyFrames = (androidx.constraintlayout.motion.widget.KeyFrames) it.next();
            for (java.lang.Integer num : keyFrames.getKeys()) {
                if (i2 == num.intValue()) {
                    java.util.Iterator<androidx.constraintlayout.motion.widget.Key> it2 = keyFrames.getKeyFramesForView(num.intValue()).iterator();
                    while (it2.hasNext()) {
                        androidx.constraintlayout.motion.widget.Key next = it2.next();
                        if (next.mFramePosition == i3 && next.mType == i) {
                            return next;
                        }
                    }
                }
            }
        }
        return null;
    }

    public void getKeyFrames(androidx.constraintlayout.motion.widget.MotionController motionController) {
        androidx.constraintlayout.motion.widget.MotionScene.Transition transition = this.mCurrentTransition;
        if (transition != null) {
            java.util.Iterator it = transition.mKeyFramesList.iterator();
            while (it.hasNext()) {
                ((androidx.constraintlayout.motion.widget.KeyFrames) it.next()).addFrames(motionController);
            }
        } else {
            androidx.constraintlayout.motion.widget.MotionScene.Transition transition2 = this.mDefaultTransition;
            if (transition2 != null) {
                java.util.Iterator it2 = transition2.mKeyFramesList.iterator();
                while (it2.hasNext()) {
                    ((androidx.constraintlayout.motion.widget.KeyFrames) it2.next()).addFrames(motionController);
                }
            }
        }
    }

    public float getMaxAcceleration() {
        androidx.constraintlayout.motion.widget.MotionScene.Transition transition = this.mCurrentTransition;
        if (transition == null || transition.mTouchResponse == null) {
            return 0.0f;
        }
        return this.mCurrentTransition.mTouchResponse.getMaxAcceleration();
    }

    public float getMaxVelocity() {
        androidx.constraintlayout.motion.widget.MotionScene.Transition transition = this.mCurrentTransition;
        if (transition == null || transition.mTouchResponse == null) {
            return 0.0f;
        }
        return this.mCurrentTransition.mTouchResponse.getMaxVelocity();
    }

    public boolean getMoveWhenScrollAtTop() {
        androidx.constraintlayout.motion.widget.MotionScene.Transition transition = this.mCurrentTransition;
        if (transition == null || transition.mTouchResponse == null) {
            return false;
        }
        return this.mCurrentTransition.mTouchResponse.getMoveWhenScrollAtTop();
    }

    public float getPathPercent(android.view.View view, int i) {
        return 0.0f;
    }

    public float getProgressDirection(float f, float f2) {
        androidx.constraintlayout.motion.widget.MotionScene.Transition transition = this.mCurrentTransition;
        if (transition == null || transition.mTouchResponse == null) {
            return 0.0f;
        }
        return this.mCurrentTransition.mTouchResponse.getProgressDirection(f, f2);
    }

    public float getStaggered() {
        androidx.constraintlayout.motion.widget.MotionScene.Transition transition = this.mCurrentTransition;
        if (transition != null) {
            return transition.mStagger;
        }
        return 0.0f;
    }

    public int getStartId() {
        androidx.constraintlayout.motion.widget.MotionScene.Transition transition = this.mCurrentTransition;
        if (transition == null) {
            return -1;
        }
        return transition.mConstraintSetStart;
    }

    public androidx.constraintlayout.motion.widget.MotionScene.Transition getTransitionById(int i) {
        java.util.Iterator<androidx.constraintlayout.motion.widget.MotionScene.Transition> it = this.mTransitionList.iterator();
        while (it.hasNext()) {
            androidx.constraintlayout.motion.widget.MotionScene.Transition next = it.next();
            if (next.mId == i) {
                return next;
            }
        }
        return null;
    }

    public int getTransitionDirection(int i) {
        java.util.Iterator<androidx.constraintlayout.motion.widget.MotionScene.Transition> it = this.mTransitionList.iterator();
        while (it.hasNext()) {
            if (it.next().mConstraintSetStart == i) {
                return 0;
            }
        }
        return 1;
    }

    public java.util.List<androidx.constraintlayout.motion.widget.MotionScene.Transition> getTransitionsWithState(int i) {
        int realID = getRealID(i);
        java.util.ArrayList arrayList = new java.util.ArrayList();
        java.util.Iterator<androidx.constraintlayout.motion.widget.MotionScene.Transition> it = this.mTransitionList.iterator();
        while (it.hasNext()) {
            androidx.constraintlayout.motion.widget.MotionScene.Transition next = it.next();
            if (next.mConstraintSetStart == realID || next.mConstraintSetEnd == realID) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    public boolean hasKeyFramePosition(android.view.View view, int i) {
        androidx.constraintlayout.motion.widget.MotionScene.Transition transition = this.mCurrentTransition;
        if (transition == null) {
            return false;
        }
        java.util.Iterator it = transition.mKeyFramesList.iterator();
        while (it.hasNext()) {
            java.util.Iterator<androidx.constraintlayout.motion.widget.Key> it2 = ((androidx.constraintlayout.motion.widget.KeyFrames) it.next()).getKeyFramesForView(view.getId()).iterator();
            while (it2.hasNext()) {
                if (it2.next().mFramePosition == i) {
                    return true;
                }
            }
        }
        return false;
    }

    public int lookUpConstraintId(java.lang.String str) {
        return this.mConstraintSetIdMap.get(str).intValue();
    }

    public java.lang.String lookUpConstraintName(int i) {
        for (java.util.Map.Entry<java.lang.String, java.lang.Integer> entry : this.mConstraintSetIdMap.entrySet()) {
            if (entry.getValue().intValue() == i) {
                return entry.getKey();
            }
        }
        return null;
    }

    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
    }

    public void processScrollMove(float f, float f2) {
        androidx.constraintlayout.motion.widget.MotionScene.Transition transition = this.mCurrentTransition;
        if (transition == null || transition.mTouchResponse == null) {
            return;
        }
        this.mCurrentTransition.mTouchResponse.scrollMove(f, f2);
    }

    public void processScrollUp(float f, float f2) {
        androidx.constraintlayout.motion.widget.MotionScene.Transition transition = this.mCurrentTransition;
        if (transition == null || transition.mTouchResponse == null) {
            return;
        }
        this.mCurrentTransition.mTouchResponse.scrollUp(f, f2);
    }

    public void processTouchEvent(android.view.MotionEvent motionEvent, int i, androidx.constraintlayout.motion.widget.MotionLayout motionLayout) {
        androidx.constraintlayout.motion.widget.MotionLayout.MotionTracker motionTracker;
        android.view.MotionEvent motionEvent2;
        android.graphics.RectF rectF = new android.graphics.RectF();
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = this.mMotionLayout.obtainVelocityTracker();
        }
        this.mVelocityTracker.addMovement(motionEvent);
        if (i != -1) {
            int action = motionEvent.getAction();
            boolean z = false;
            if (action == 0) {
                this.mLastTouchX = motionEvent.getRawX();
                this.mLastTouchY = motionEvent.getRawY();
                this.mLastTouchDown = motionEvent;
                this.mIgnoreTouch = false;
                if (this.mCurrentTransition.mTouchResponse != null) {
                    android.graphics.RectF limitBoundsTo = this.mCurrentTransition.mTouchResponse.getLimitBoundsTo(this.mMotionLayout, rectF);
                    if (limitBoundsTo != null && !limitBoundsTo.contains(this.mLastTouchDown.getX(), this.mLastTouchDown.getY())) {
                        this.mLastTouchDown = null;
                        this.mIgnoreTouch = true;
                        return;
                    }
                    android.graphics.RectF touchRegion = this.mCurrentTransition.mTouchResponse.getTouchRegion(this.mMotionLayout, rectF);
                    if (touchRegion == null || touchRegion.contains(this.mLastTouchDown.getX(), this.mLastTouchDown.getY())) {
                        this.mMotionOutsideRegion = false;
                    } else {
                        this.mMotionOutsideRegion = true;
                    }
                    this.mCurrentTransition.mTouchResponse.setDown(this.mLastTouchX, this.mLastTouchY);
                    return;
                }
                return;
            }
            if (action == 2 && !this.mIgnoreTouch) {
                float rawY = motionEvent.getRawY() - this.mLastTouchY;
                float rawX = motionEvent.getRawX() - this.mLastTouchX;
                if ((rawX == 0.0d && rawY == 0.0d) || (motionEvent2 = this.mLastTouchDown) == null) {
                    return;
                }
                androidx.constraintlayout.motion.widget.MotionScene.Transition bestTransitionFor = bestTransitionFor(i, rawX, rawY, motionEvent2);
                if (bestTransitionFor != null) {
                    motionLayout.setTransition(bestTransitionFor);
                    android.graphics.RectF touchRegion2 = this.mCurrentTransition.mTouchResponse.getTouchRegion(this.mMotionLayout, rectF);
                    if (touchRegion2 != null && !touchRegion2.contains(this.mLastTouchDown.getX(), this.mLastTouchDown.getY())) {
                        z = true;
                    }
                    this.mMotionOutsideRegion = z;
                    this.mCurrentTransition.mTouchResponse.setUpTouchEvent(this.mLastTouchX, this.mLastTouchY);
                }
            }
        }
        if (this.mIgnoreTouch) {
            return;
        }
        androidx.constraintlayout.motion.widget.MotionScene.Transition transition = this.mCurrentTransition;
        if (transition != null && transition.mTouchResponse != null && !this.mMotionOutsideRegion) {
            this.mCurrentTransition.mTouchResponse.processTouchEvent(motionEvent, this.mVelocityTracker, i, this);
        }
        this.mLastTouchX = motionEvent.getRawX();
        this.mLastTouchY = motionEvent.getRawY();
        if (motionEvent.getAction() != 1 || (motionTracker = this.mVelocityTracker) == null) {
            return;
        }
        motionTracker.recycle();
        this.mVelocityTracker = null;
        int i2 = motionLayout.mCurrentState;
        if (i2 != -1) {
            autoTransition(motionLayout, i2);
        }
    }

    public void readFallback(androidx.constraintlayout.motion.widget.MotionLayout motionLayout) {
        for (int i = 0; i < this.mConstraintSetMap.size(); i++) {
            int keyAt = this.mConstraintSetMap.keyAt(i);
            if (hasCycleDependency(keyAt)) {
                return;
            }
            readConstraintChain(keyAt);
        }
        for (int i2 = 0; i2 < this.mConstraintSetMap.size(); i2++) {
            this.mConstraintSetMap.valueAt(i2).readFallback(motionLayout);
        }
    }

    public void removeTransition(androidx.constraintlayout.motion.widget.MotionScene.Transition transition) {
        int index = getIndex(transition);
        if (index != -1) {
            this.mTransitionList.remove(index);
        }
    }

    public void setConstraintSet(int i, androidx.constraintlayout.widget.ConstraintSet constraintSet) {
        this.mConstraintSetMap.put(i, constraintSet);
    }

    public void setDuration(int i) {
        androidx.constraintlayout.motion.widget.MotionScene.Transition transition = this.mCurrentTransition;
        if (transition != null) {
            transition.setDuration(i);
        } else {
            this.mDefaultDuration = i;
        }
    }

    public void setKeyframe(android.view.View view, int i, java.lang.String str, java.lang.Object obj) {
        androidx.constraintlayout.motion.widget.MotionScene.Transition transition = this.mCurrentTransition;
        if (transition == null) {
            return;
        }
        java.util.Iterator it = transition.mKeyFramesList.iterator();
        while (it.hasNext()) {
            java.util.Iterator<androidx.constraintlayout.motion.widget.Key> it2 = ((androidx.constraintlayout.motion.widget.KeyFrames) it.next()).getKeyFramesForView(view.getId()).iterator();
            while (it2.hasNext()) {
                if (it2.next().mFramePosition == i) {
                    if (obj != null) {
                        ((java.lang.Float) obj).floatValue();
                    }
                    str.equalsIgnoreCase("app:PerpendicularPath_percent");
                }
            }
        }
    }

    public void setRtl(boolean z) {
        this.mRtl = z;
        androidx.constraintlayout.motion.widget.MotionScene.Transition transition = this.mCurrentTransition;
        if (transition == null || transition.mTouchResponse == null) {
            return;
        }
        this.mCurrentTransition.mTouchResponse.setRTL(this.mRtl);
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x0013, code lost:
    
        if (r2 != (-1)) goto L13;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void setTransition(int i, int i2) {
        int i3;
        int i4;
        androidx.constraintlayout.widget.StateSet stateSet = this.mStateSet;
        if (stateSet != null) {
            i3 = stateSet.stateGetConstraintID(i, -1, -1);
            if (i3 == -1) {
                i3 = i;
            }
            i4 = this.mStateSet.stateGetConstraintID(i2, -1, -1);
        } else {
            i3 = i;
        }
        i4 = i2;
        java.util.Iterator<androidx.constraintlayout.motion.widget.MotionScene.Transition> it = this.mTransitionList.iterator();
        while (it.hasNext()) {
            androidx.constraintlayout.motion.widget.MotionScene.Transition next = it.next();
            if ((next.mConstraintSetEnd == i4 && next.mConstraintSetStart == i3) || (next.mConstraintSetEnd == i2 && next.mConstraintSetStart == i)) {
                this.mCurrentTransition = next;
                if (next == null || next.mTouchResponse == null) {
                    return;
                }
                this.mCurrentTransition.mTouchResponse.setRTL(this.mRtl);
                return;
            }
        }
        androidx.constraintlayout.motion.widget.MotionScene.Transition transition = this.mDefaultTransition;
        java.util.Iterator<androidx.constraintlayout.motion.widget.MotionScene.Transition> it2 = this.mAbstractTransitionList.iterator();
        while (it2.hasNext()) {
            androidx.constraintlayout.motion.widget.MotionScene.Transition next2 = it2.next();
            if (next2.mConstraintSetEnd == i2) {
                transition = next2;
            }
        }
        androidx.constraintlayout.motion.widget.MotionScene.Transition transition2 = new androidx.constraintlayout.motion.widget.MotionScene.Transition(this, transition);
        transition2.mConstraintSetStart = i3;
        transition2.mConstraintSetEnd = i4;
        if (i3 != -1) {
            this.mTransitionList.add(transition2);
        }
        this.mCurrentTransition = transition2;
    }

    public void setTransition(androidx.constraintlayout.motion.widget.MotionScene.Transition transition) {
        this.mCurrentTransition = transition;
        if (transition == null || transition.mTouchResponse == null) {
            return;
        }
        this.mCurrentTransition.mTouchResponse.setRTL(this.mRtl);
    }

    public void setupTouch() {
        androidx.constraintlayout.motion.widget.MotionScene.Transition transition = this.mCurrentTransition;
        if (transition == null || transition.mTouchResponse == null) {
            return;
        }
        this.mCurrentTransition.mTouchResponse.setupTouch();
    }

    public boolean supportTouch() {
        java.util.Iterator<androidx.constraintlayout.motion.widget.MotionScene.Transition> it = this.mTransitionList.iterator();
        while (it.hasNext()) {
            if (it.next().mTouchResponse != null) {
                return true;
            }
        }
        androidx.constraintlayout.motion.widget.MotionScene.Transition transition = this.mCurrentTransition;
        return (transition == null || transition.mTouchResponse == null) ? false : true;
    }

    public boolean validateLayout(androidx.constraintlayout.motion.widget.MotionLayout motionLayout) {
        return motionLayout == this.mMotionLayout && motionLayout.mScene == this;
    }
}
