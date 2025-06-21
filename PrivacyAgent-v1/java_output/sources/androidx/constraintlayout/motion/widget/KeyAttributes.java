package androidx.constraintlayout.motion.widget;

/* loaded from: classes.dex */
public class KeyAttributes extends androidx.constraintlayout.motion.widget.Key {
    public static final int KEY_TYPE = 1;
    static final java.lang.String NAME = "KeyAttribute";
    private static final java.lang.String TAG = "KeyAttribute";
    private java.lang.String mTransitionEasing;
    private int mCurveFit = -1;
    private boolean mVisibility = false;
    private float mAlpha = Float.NaN;
    private float mElevation = Float.NaN;
    private float mRotation = Float.NaN;
    private float mRotationX = Float.NaN;
    private float mRotationY = Float.NaN;
    private float mPivotX = Float.NaN;
    private float mPivotY = Float.NaN;
    private float mTransitionPathRotate = Float.NaN;
    private float mScaleX = Float.NaN;
    private float mScaleY = Float.NaN;
    private float mTranslationX = Float.NaN;
    private float mTranslationY = Float.NaN;
    private float mTranslationZ = Float.NaN;
    private float mProgress = Float.NaN;

    public static class Loader {
        private static final int ANDROID_ALPHA = 1;
        private static final int ANDROID_ELEVATION = 2;
        private static final int ANDROID_PIVOT_X = 19;
        private static final int ANDROID_PIVOT_Y = 20;
        private static final int ANDROID_ROTATION = 4;
        private static final int ANDROID_ROTATION_X = 5;
        private static final int ANDROID_ROTATION_Y = 6;
        private static final int ANDROID_SCALE_X = 7;
        private static final int ANDROID_SCALE_Y = 14;
        private static final int ANDROID_TRANSLATION_X = 15;
        private static final int ANDROID_TRANSLATION_Y = 16;
        private static final int ANDROID_TRANSLATION_Z = 17;
        private static final int CURVE_FIT = 13;
        private static final int FRAME_POSITION = 12;
        private static final int PROGRESS = 18;
        private static final int TARGET_ID = 10;
        private static final int TRANSITION_EASING = 9;
        private static final int TRANSITION_PATH_ROTATE = 8;
        private static android.util.SparseIntArray mAttrMap;

        static {
            android.util.SparseIntArray sparseIntArray = new android.util.SparseIntArray();
            mAttrMap = sparseIntArray;
            sparseIntArray.append(androidx.constraintlayout.widget.R.styleable.KeyAttribute_android_alpha, 1);
            mAttrMap.append(androidx.constraintlayout.widget.R.styleable.KeyAttribute_android_elevation, 2);
            mAttrMap.append(androidx.constraintlayout.widget.R.styleable.KeyAttribute_android_rotation, 4);
            mAttrMap.append(androidx.constraintlayout.widget.R.styleable.KeyAttribute_android_rotationX, 5);
            mAttrMap.append(androidx.constraintlayout.widget.R.styleable.KeyAttribute_android_rotationY, 6);
            mAttrMap.append(androidx.constraintlayout.widget.R.styleable.KeyAttribute_android_transformPivotX, 19);
            mAttrMap.append(androidx.constraintlayout.widget.R.styleable.KeyAttribute_android_transformPivotY, 20);
            mAttrMap.append(androidx.constraintlayout.widget.R.styleable.KeyAttribute_android_scaleX, 7);
            mAttrMap.append(androidx.constraintlayout.widget.R.styleable.KeyAttribute_transitionPathRotate, 8);
            mAttrMap.append(androidx.constraintlayout.widget.R.styleable.KeyAttribute_transitionEasing, 9);
            mAttrMap.append(androidx.constraintlayout.widget.R.styleable.KeyAttribute_motionTarget, 10);
            mAttrMap.append(androidx.constraintlayout.widget.R.styleable.KeyAttribute_framePosition, 12);
            mAttrMap.append(androidx.constraintlayout.widget.R.styleable.KeyAttribute_curveFit, 13);
            mAttrMap.append(androidx.constraintlayout.widget.R.styleable.KeyAttribute_android_scaleY, 14);
            mAttrMap.append(androidx.constraintlayout.widget.R.styleable.KeyAttribute_android_translationX, 15);
            mAttrMap.append(androidx.constraintlayout.widget.R.styleable.KeyAttribute_android_translationY, 16);
            mAttrMap.append(androidx.constraintlayout.widget.R.styleable.KeyAttribute_android_translationZ, 17);
            mAttrMap.append(androidx.constraintlayout.widget.R.styleable.KeyAttribute_motionProgress, 18);
        }

        private Loader() {
        }

        public static void read(androidx.constraintlayout.motion.widget.KeyAttributes keyAttributes, android.content.res.TypedArray typedArray) {
            int indexCount = typedArray.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = typedArray.getIndex(i);
                switch (mAttrMap.get(index)) {
                    case 1:
                        keyAttributes.mAlpha = typedArray.getFloat(index, keyAttributes.mAlpha);
                        break;
                    case 2:
                        keyAttributes.mElevation = typedArray.getDimension(index, keyAttributes.mElevation);
                        break;
                    case 3:
                    case 11:
                    default:
                        java.lang.StringBuilder sb = new java.lang.StringBuilder();
                        sb.append("unused attribute 0x");
                        sb.append(java.lang.Integer.toHexString(index));
                        sb.append("   ");
                        sb.append(mAttrMap.get(index));
                        break;
                    case 4:
                        keyAttributes.mRotation = typedArray.getFloat(index, keyAttributes.mRotation);
                        break;
                    case 5:
                        keyAttributes.mRotationX = typedArray.getFloat(index, keyAttributes.mRotationX);
                        break;
                    case 6:
                        keyAttributes.mRotationY = typedArray.getFloat(index, keyAttributes.mRotationY);
                        break;
                    case 7:
                        keyAttributes.mScaleX = typedArray.getFloat(index, keyAttributes.mScaleX);
                        break;
                    case 8:
                        keyAttributes.mTransitionPathRotate = typedArray.getFloat(index, keyAttributes.mTransitionPathRotate);
                        break;
                    case 9:
                        keyAttributes.mTransitionEasing = typedArray.getString(index);
                        break;
                    case 10:
                        if (androidx.constraintlayout.motion.widget.MotionLayout.IS_IN_EDIT_MODE) {
                            int resourceId = typedArray.getResourceId(index, keyAttributes.mTargetId);
                            keyAttributes.mTargetId = resourceId;
                            if (resourceId == -1) {
                                keyAttributes.mTargetString = typedArray.getString(index);
                                break;
                            } else {
                                break;
                            }
                        } else if (typedArray.peekValue(index).type == 3) {
                            keyAttributes.mTargetString = typedArray.getString(index);
                            break;
                        } else {
                            keyAttributes.mTargetId = typedArray.getResourceId(index, keyAttributes.mTargetId);
                            break;
                        }
                    case 12:
                        keyAttributes.mFramePosition = typedArray.getInt(index, keyAttributes.mFramePosition);
                        break;
                    case 13:
                        keyAttributes.mCurveFit = typedArray.getInteger(index, keyAttributes.mCurveFit);
                        break;
                    case 14:
                        keyAttributes.mScaleY = typedArray.getFloat(index, keyAttributes.mScaleY);
                        break;
                    case 15:
                        keyAttributes.mTranslationX = typedArray.getDimension(index, keyAttributes.mTranslationX);
                        break;
                    case 16:
                        keyAttributes.mTranslationY = typedArray.getDimension(index, keyAttributes.mTranslationY);
                        break;
                    case 17:
                        keyAttributes.mTranslationZ = typedArray.getDimension(index, keyAttributes.mTranslationZ);
                        break;
                    case 18:
                        keyAttributes.mProgress = typedArray.getFloat(index, keyAttributes.mProgress);
                        break;
                    case 19:
                        keyAttributes.mPivotX = typedArray.getDimension(index, keyAttributes.mPivotX);
                        break;
                    case 20:
                        keyAttributes.mPivotY = typedArray.getDimension(index, keyAttributes.mPivotY);
                        break;
                }
            }
        }
    }

    public KeyAttributes() {
        this.mType = 1;
        this.mCustomConstraints = new java.util.HashMap<>();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:132:0x009a, code lost:
    
        if (r1.equals("scaleY") == false) goto L12;
     */
    @Override // androidx.constraintlayout.motion.widget.Key
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void addValues(java.util.HashMap<java.lang.String, androidx.constraintlayout.motion.widget.SplineSet> hashMap) {
        java.util.Iterator<java.lang.String> it = hashMap.keySet().iterator();
        while (it.hasNext()) {
            java.lang.String next = it.next();
            androidx.constraintlayout.motion.widget.SplineSet splineSet = hashMap.get(next);
            char c = 7;
            if (!next.startsWith("CUSTOM")) {
                switch (next.hashCode()) {
                    case -1249320806:
                        if (next.equals("rotationX")) {
                            c = 0;
                            break;
                        }
                        c = 65535;
                        break;
                    case -1249320805:
                        if (next.equals("rotationY")) {
                            c = 1;
                            break;
                        }
                        c = 65535;
                        break;
                    case -1225497657:
                        if (next.equals("translationX")) {
                            c = 2;
                            break;
                        }
                        c = 65535;
                        break;
                    case -1225497656:
                        if (next.equals("translationY")) {
                            c = 3;
                            break;
                        }
                        c = 65535;
                        break;
                    case -1225497655:
                        if (next.equals("translationZ")) {
                            c = 4;
                            break;
                        }
                        c = 65535;
                        break;
                    case -1001078227:
                        if (next.equals(androidx.core.app.NotificationCompat.CATEGORY_PROGRESS)) {
                            c = 5;
                            break;
                        }
                        c = 65535;
                        break;
                    case -908189618:
                        if (next.equals("scaleX")) {
                            c = 6;
                            break;
                        }
                        c = 65535;
                        break;
                    case -908189617:
                        break;
                    case -760884510:
                        if (next.equals("transformPivotX")) {
                            c = '\b';
                            break;
                        }
                        c = 65535;
                        break;
                    case -760884509:
                        if (next.equals("transformPivotY")) {
                            c = '\t';
                            break;
                        }
                        c = 65535;
                        break;
                    case -40300674:
                        if (next.equals("rotation")) {
                            c = '\n';
                            break;
                        }
                        c = 65535;
                        break;
                    case -4379043:
                        if (next.equals("elevation")) {
                            c = 11;
                            break;
                        }
                        c = 65535;
                        break;
                    case 37232917:
                        if (next.equals("transitionPathRotate")) {
                            c = '\f';
                            break;
                        }
                        c = 65535;
                        break;
                    case 92909918:
                        if (next.equals("alpha")) {
                            c = '\r';
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
                        if (!java.lang.Float.isNaN(this.mRotationX)) {
                            splineSet.setPoint(this.mFramePosition, this.mRotationX);
                            break;
                        } else {
                            break;
                        }
                    case 1:
                        if (!java.lang.Float.isNaN(this.mRotationY)) {
                            splineSet.setPoint(this.mFramePosition, this.mRotationY);
                            break;
                        } else {
                            break;
                        }
                    case 2:
                        if (!java.lang.Float.isNaN(this.mTranslationX)) {
                            splineSet.setPoint(this.mFramePosition, this.mTranslationX);
                            break;
                        } else {
                            break;
                        }
                    case 3:
                        if (!java.lang.Float.isNaN(this.mTranslationY)) {
                            splineSet.setPoint(this.mFramePosition, this.mTranslationY);
                            break;
                        } else {
                            break;
                        }
                    case 4:
                        if (!java.lang.Float.isNaN(this.mTranslationZ)) {
                            splineSet.setPoint(this.mFramePosition, this.mTranslationZ);
                            break;
                        } else {
                            break;
                        }
                    case 5:
                        if (!java.lang.Float.isNaN(this.mProgress)) {
                            splineSet.setPoint(this.mFramePosition, this.mProgress);
                            break;
                        } else {
                            break;
                        }
                    case 6:
                        if (!java.lang.Float.isNaN(this.mScaleX)) {
                            splineSet.setPoint(this.mFramePosition, this.mScaleX);
                            break;
                        } else {
                            break;
                        }
                    case 7:
                        if (!java.lang.Float.isNaN(this.mScaleY)) {
                            splineSet.setPoint(this.mFramePosition, this.mScaleY);
                            break;
                        } else {
                            break;
                        }
                    case '\b':
                        if (!java.lang.Float.isNaN(this.mRotationX)) {
                            splineSet.setPoint(this.mFramePosition, this.mPivotX);
                            break;
                        } else {
                            break;
                        }
                    case '\t':
                        if (!java.lang.Float.isNaN(this.mRotationY)) {
                            splineSet.setPoint(this.mFramePosition, this.mPivotY);
                            break;
                        } else {
                            break;
                        }
                    case '\n':
                        if (!java.lang.Float.isNaN(this.mRotation)) {
                            splineSet.setPoint(this.mFramePosition, this.mRotation);
                            break;
                        } else {
                            break;
                        }
                    case 11:
                        if (!java.lang.Float.isNaN(this.mElevation)) {
                            splineSet.setPoint(this.mFramePosition, this.mElevation);
                            break;
                        } else {
                            break;
                        }
                    case '\f':
                        if (!java.lang.Float.isNaN(this.mTransitionPathRotate)) {
                            splineSet.setPoint(this.mFramePosition, this.mTransitionPathRotate);
                            break;
                        } else {
                            break;
                        }
                    case '\r':
                        if (!java.lang.Float.isNaN(this.mAlpha)) {
                            splineSet.setPoint(this.mFramePosition, this.mAlpha);
                            break;
                        } else {
                            break;
                        }
                    default:
                        java.lang.StringBuilder sb = new java.lang.StringBuilder();
                        sb.append("UNKNOWN addValues \"");
                        sb.append(next);
                        sb.append("\"");
                        break;
                }
            } else {
                androidx.constraintlayout.widget.ConstraintAttribute constraintAttribute = this.mCustomConstraints.get(next.substring(7));
                if (constraintAttribute != null) {
                    ((androidx.constraintlayout.motion.widget.SplineSet.CustomSet) splineSet).setPoint(this.mFramePosition, constraintAttribute);
                }
            }
        }
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    public void getAttributeNames(java.util.HashSet<java.lang.String> hashSet) {
        if (!java.lang.Float.isNaN(this.mAlpha)) {
            hashSet.add("alpha");
        }
        if (!java.lang.Float.isNaN(this.mElevation)) {
            hashSet.add("elevation");
        }
        if (!java.lang.Float.isNaN(this.mRotation)) {
            hashSet.add("rotation");
        }
        if (!java.lang.Float.isNaN(this.mRotationX)) {
            hashSet.add("rotationX");
        }
        if (!java.lang.Float.isNaN(this.mRotationY)) {
            hashSet.add("rotationY");
        }
        if (!java.lang.Float.isNaN(this.mPivotX)) {
            hashSet.add("transformPivotX");
        }
        if (!java.lang.Float.isNaN(this.mPivotY)) {
            hashSet.add("transformPivotY");
        }
        if (!java.lang.Float.isNaN(this.mTranslationX)) {
            hashSet.add("translationX");
        }
        if (!java.lang.Float.isNaN(this.mTranslationY)) {
            hashSet.add("translationY");
        }
        if (!java.lang.Float.isNaN(this.mTranslationZ)) {
            hashSet.add("translationZ");
        }
        if (!java.lang.Float.isNaN(this.mTransitionPathRotate)) {
            hashSet.add("transitionPathRotate");
        }
        if (!java.lang.Float.isNaN(this.mScaleX)) {
            hashSet.add("scaleX");
        }
        if (!java.lang.Float.isNaN(this.mScaleY)) {
            hashSet.add("scaleY");
        }
        if (!java.lang.Float.isNaN(this.mProgress)) {
            hashSet.add(androidx.core.app.NotificationCompat.CATEGORY_PROGRESS);
        }
        if (this.mCustomConstraints.size() > 0) {
            java.util.Iterator<java.lang.String> it = this.mCustomConstraints.keySet().iterator();
            while (it.hasNext()) {
                hashSet.add("CUSTOM," + it.next());
            }
        }
    }

    public int getCurveFit() {
        return this.mCurveFit;
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    public void load(android.content.Context context, android.util.AttributeSet attributeSet) {
        androidx.constraintlayout.motion.widget.KeyAttributes.Loader.read(this, context.obtainStyledAttributes(attributeSet, androidx.constraintlayout.widget.R.styleable.KeyAttribute));
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    public void setInterpolation(java.util.HashMap<java.lang.String, java.lang.Integer> hashMap) {
        if (this.mCurveFit == -1) {
            return;
        }
        if (!java.lang.Float.isNaN(this.mAlpha)) {
            hashMap.put("alpha", java.lang.Integer.valueOf(this.mCurveFit));
        }
        if (!java.lang.Float.isNaN(this.mElevation)) {
            hashMap.put("elevation", java.lang.Integer.valueOf(this.mCurveFit));
        }
        if (!java.lang.Float.isNaN(this.mRotation)) {
            hashMap.put("rotation", java.lang.Integer.valueOf(this.mCurveFit));
        }
        if (!java.lang.Float.isNaN(this.mRotationX)) {
            hashMap.put("rotationX", java.lang.Integer.valueOf(this.mCurveFit));
        }
        if (!java.lang.Float.isNaN(this.mRotationY)) {
            hashMap.put("rotationY", java.lang.Integer.valueOf(this.mCurveFit));
        }
        if (!java.lang.Float.isNaN(this.mPivotX)) {
            hashMap.put("transformPivotX", java.lang.Integer.valueOf(this.mCurveFit));
        }
        if (!java.lang.Float.isNaN(this.mPivotY)) {
            hashMap.put("transformPivotY", java.lang.Integer.valueOf(this.mCurveFit));
        }
        if (!java.lang.Float.isNaN(this.mTranslationX)) {
            hashMap.put("translationX", java.lang.Integer.valueOf(this.mCurveFit));
        }
        if (!java.lang.Float.isNaN(this.mTranslationY)) {
            hashMap.put("translationY", java.lang.Integer.valueOf(this.mCurveFit));
        }
        if (!java.lang.Float.isNaN(this.mTranslationZ)) {
            hashMap.put("translationZ", java.lang.Integer.valueOf(this.mCurveFit));
        }
        if (!java.lang.Float.isNaN(this.mTransitionPathRotate)) {
            hashMap.put("transitionPathRotate", java.lang.Integer.valueOf(this.mCurveFit));
        }
        if (!java.lang.Float.isNaN(this.mScaleX)) {
            hashMap.put("scaleX", java.lang.Integer.valueOf(this.mCurveFit));
        }
        if (!java.lang.Float.isNaN(this.mScaleY)) {
            hashMap.put("scaleY", java.lang.Integer.valueOf(this.mCurveFit));
        }
        if (!java.lang.Float.isNaN(this.mProgress)) {
            hashMap.put(androidx.core.app.NotificationCompat.CATEGORY_PROGRESS, java.lang.Integer.valueOf(this.mCurveFit));
        }
        if (this.mCustomConstraints.size() > 0) {
            java.util.Iterator<java.lang.String> it = this.mCustomConstraints.keySet().iterator();
            while (it.hasNext()) {
                hashMap.put("CUSTOM," + it.next(), java.lang.Integer.valueOf(this.mCurveFit));
            }
        }
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    public void setValue(java.lang.String str, java.lang.Object obj) {
        str.hashCode();
        switch (str) {
            case "motionProgress":
                this.mProgress = toFloat(obj);
                break;
            case "transitionEasing":
                this.mTransitionEasing = obj.toString();
                break;
            case "rotationX":
                this.mRotationX = toFloat(obj);
                break;
            case "rotationY":
                this.mRotationY = toFloat(obj);
                break;
            case "translationX":
                this.mTranslationX = toFloat(obj);
                break;
            case "translationY":
                this.mTranslationY = toFloat(obj);
                break;
            case "pivotX":
                this.mPivotX = toFloat(obj);
                break;
            case "pivotY":
                this.mPivotY = toFloat(obj);
                break;
            case "scaleX":
                this.mScaleX = toFloat(obj);
                break;
            case "scaleY":
                this.mScaleY = toFloat(obj);
                break;
            case "rotation":
                this.mRotation = toFloat(obj);
                break;
            case "elevation":
                this.mElevation = toFloat(obj);
                break;
            case "transitionPathRotate":
                this.mTransitionPathRotate = toFloat(obj);
                break;
            case "alpha":
                this.mAlpha = toFloat(obj);
                break;
            case "curveFit":
                this.mCurveFit = toInt(obj);
                break;
            case "mTranslationZ":
                this.mTranslationZ = toFloat(obj);
                break;
            case "visibility":
                this.mVisibility = toBoolean(obj);
                break;
        }
    }
}
