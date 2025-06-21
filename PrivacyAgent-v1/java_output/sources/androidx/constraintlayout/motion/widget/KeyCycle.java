package androidx.constraintlayout.motion.widget;

/* loaded from: classes.dex */
public class KeyCycle extends androidx.constraintlayout.motion.widget.Key {
    public static final int KEY_TYPE = 4;
    static final java.lang.String NAME = "KeyCycle";
    private static final java.lang.String TAG = "KeyCycle";
    private java.lang.String mTransitionEasing = null;
    private int mCurveFit = 0;
    private int mWaveShape = -1;
    private float mWavePeriod = Float.NaN;
    private float mWaveOffset = 0.0f;
    private float mProgress = Float.NaN;
    private int mWaveVariesBy = -1;
    private float mAlpha = Float.NaN;
    private float mElevation = Float.NaN;
    private float mRotation = Float.NaN;
    private float mTransitionPathRotate = Float.NaN;
    private float mRotationX = Float.NaN;
    private float mRotationY = Float.NaN;
    private float mScaleX = Float.NaN;
    private float mScaleY = Float.NaN;
    private float mTranslationX = Float.NaN;
    private float mTranslationY = Float.NaN;
    private float mTranslationZ = Float.NaN;

    public static class Loader {
        private static final int ANDROID_ALPHA = 9;
        private static final int ANDROID_ELEVATION = 10;
        private static final int ANDROID_ROTATION = 11;
        private static final int ANDROID_ROTATION_X = 12;
        private static final int ANDROID_ROTATION_Y = 13;
        private static final int ANDROID_SCALE_X = 15;
        private static final int ANDROID_SCALE_Y = 16;
        private static final int ANDROID_TRANSLATION_X = 17;
        private static final int ANDROID_TRANSLATION_Y = 18;
        private static final int ANDROID_TRANSLATION_Z = 19;
        private static final int CURVE_FIT = 4;
        private static final int FRAME_POSITION = 2;
        private static final int PROGRESS = 20;
        private static final int TARGET_ID = 1;
        private static final int TRANSITION_EASING = 3;
        private static final int TRANSITION_PATH_ROTATE = 14;
        private static final int WAVE_OFFSET = 7;
        private static final int WAVE_PERIOD = 6;
        private static final int WAVE_SHAPE = 5;
        private static final int WAVE_VARIES_BY = 8;
        private static android.util.SparseIntArray mAttrMap;

        static {
            android.util.SparseIntArray sparseIntArray = new android.util.SparseIntArray();
            mAttrMap = sparseIntArray;
            sparseIntArray.append(androidx.constraintlayout.widget.R.styleable.KeyCycle_motionTarget, 1);
            mAttrMap.append(androidx.constraintlayout.widget.R.styleable.KeyCycle_framePosition, 2);
            mAttrMap.append(androidx.constraintlayout.widget.R.styleable.KeyCycle_transitionEasing, 3);
            mAttrMap.append(androidx.constraintlayout.widget.R.styleable.KeyCycle_curveFit, 4);
            mAttrMap.append(androidx.constraintlayout.widget.R.styleable.KeyCycle_waveShape, 5);
            mAttrMap.append(androidx.constraintlayout.widget.R.styleable.KeyCycle_wavePeriod, 6);
            mAttrMap.append(androidx.constraintlayout.widget.R.styleable.KeyCycle_waveOffset, 7);
            mAttrMap.append(androidx.constraintlayout.widget.R.styleable.KeyCycle_waveVariesBy, 8);
            mAttrMap.append(androidx.constraintlayout.widget.R.styleable.KeyCycle_android_alpha, 9);
            mAttrMap.append(androidx.constraintlayout.widget.R.styleable.KeyCycle_android_elevation, 10);
            mAttrMap.append(androidx.constraintlayout.widget.R.styleable.KeyCycle_android_rotation, 11);
            mAttrMap.append(androidx.constraintlayout.widget.R.styleable.KeyCycle_android_rotationX, 12);
            mAttrMap.append(androidx.constraintlayout.widget.R.styleable.KeyCycle_android_rotationY, 13);
            mAttrMap.append(androidx.constraintlayout.widget.R.styleable.KeyCycle_transitionPathRotate, 14);
            mAttrMap.append(androidx.constraintlayout.widget.R.styleable.KeyCycle_android_scaleX, 15);
            mAttrMap.append(androidx.constraintlayout.widget.R.styleable.KeyCycle_android_scaleY, 16);
            mAttrMap.append(androidx.constraintlayout.widget.R.styleable.KeyCycle_android_translationX, 17);
            mAttrMap.append(androidx.constraintlayout.widget.R.styleable.KeyCycle_android_translationY, 18);
            mAttrMap.append(androidx.constraintlayout.widget.R.styleable.KeyCycle_android_translationZ, 19);
            mAttrMap.append(androidx.constraintlayout.widget.R.styleable.KeyCycle_motionProgress, 20);
        }

        private Loader() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static void read(androidx.constraintlayout.motion.widget.KeyCycle keyCycle, android.content.res.TypedArray typedArray) {
            int indexCount = typedArray.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = typedArray.getIndex(i);
                switch (mAttrMap.get(index)) {
                    case 1:
                        if (androidx.constraintlayout.motion.widget.MotionLayout.IS_IN_EDIT_MODE) {
                            int resourceId = typedArray.getResourceId(index, keyCycle.mTargetId);
                            keyCycle.mTargetId = resourceId;
                            if (resourceId == -1) {
                                keyCycle.mTargetString = typedArray.getString(index);
                                break;
                            } else {
                                break;
                            }
                        } else if (typedArray.peekValue(index).type == 3) {
                            keyCycle.mTargetString = typedArray.getString(index);
                            break;
                        } else {
                            keyCycle.mTargetId = typedArray.getResourceId(index, keyCycle.mTargetId);
                            break;
                        }
                    case 2:
                        keyCycle.mFramePosition = typedArray.getInt(index, keyCycle.mFramePosition);
                        break;
                    case 3:
                        keyCycle.mTransitionEasing = typedArray.getString(index);
                        break;
                    case 4:
                        keyCycle.mCurveFit = typedArray.getInteger(index, keyCycle.mCurveFit);
                        break;
                    case 5:
                        keyCycle.mWaveShape = typedArray.getInt(index, keyCycle.mWaveShape);
                        break;
                    case 6:
                        keyCycle.mWavePeriod = typedArray.getFloat(index, keyCycle.mWavePeriod);
                        break;
                    case 7:
                        if (typedArray.peekValue(index).type == 5) {
                            keyCycle.mWaveOffset = typedArray.getDimension(index, keyCycle.mWaveOffset);
                            break;
                        } else {
                            keyCycle.mWaveOffset = typedArray.getFloat(index, keyCycle.mWaveOffset);
                            break;
                        }
                    case 8:
                        keyCycle.mWaveVariesBy = typedArray.getInt(index, keyCycle.mWaveVariesBy);
                        break;
                    case 9:
                        keyCycle.mAlpha = typedArray.getFloat(index, keyCycle.mAlpha);
                        break;
                    case 10:
                        keyCycle.mElevation = typedArray.getDimension(index, keyCycle.mElevation);
                        break;
                    case 11:
                        keyCycle.mRotation = typedArray.getFloat(index, keyCycle.mRotation);
                        break;
                    case 12:
                        keyCycle.mRotationX = typedArray.getFloat(index, keyCycle.mRotationX);
                        break;
                    case 13:
                        keyCycle.mRotationY = typedArray.getFloat(index, keyCycle.mRotationY);
                        break;
                    case 14:
                        keyCycle.mTransitionPathRotate = typedArray.getFloat(index, keyCycle.mTransitionPathRotate);
                        break;
                    case 15:
                        keyCycle.mScaleX = typedArray.getFloat(index, keyCycle.mScaleX);
                        break;
                    case 16:
                        keyCycle.mScaleY = typedArray.getFloat(index, keyCycle.mScaleY);
                        break;
                    case 17:
                        keyCycle.mTranslationX = typedArray.getDimension(index, keyCycle.mTranslationX);
                        break;
                    case 18:
                        keyCycle.mTranslationY = typedArray.getDimension(index, keyCycle.mTranslationY);
                        break;
                    case 19:
                        keyCycle.mTranslationZ = typedArray.getDimension(index, keyCycle.mTranslationZ);
                        break;
                    case 20:
                        keyCycle.mProgress = typedArray.getFloat(index, keyCycle.mProgress);
                        break;
                    default:
                        java.lang.StringBuilder sb = new java.lang.StringBuilder();
                        sb.append("unused attribute 0x");
                        sb.append(java.lang.Integer.toHexString(index));
                        sb.append("   ");
                        sb.append(mAttrMap.get(index));
                        break;
                }
            }
        }
    }

    public KeyCycle() {
        this.mType = 4;
        this.mCustomConstraints = new java.util.HashMap<>();
    }

    public void addCycleValues(java.util.HashMap<java.lang.String, androidx.constraintlayout.motion.widget.KeyCycleOscillator> hashMap) {
        for (java.lang.String str : hashMap.keySet()) {
            if (str.startsWith("CUSTOM")) {
                androidx.constraintlayout.widget.ConstraintAttribute constraintAttribute = this.mCustomConstraints.get(str.substring(7));
                if (constraintAttribute != null && constraintAttribute.getType() == androidx.constraintlayout.widget.ConstraintAttribute.AttributeType.FLOAT_TYPE) {
                    hashMap.get(str).setPoint(this.mFramePosition, this.mWaveShape, this.mWaveVariesBy, this.mWavePeriod, this.mWaveOffset, constraintAttribute.getValueToInterpolate(), constraintAttribute);
                }
            } else {
                float value = getValue(str);
                if (!java.lang.Float.isNaN(value)) {
                    hashMap.get(str).setPoint(this.mFramePosition, this.mWaveShape, this.mWaveVariesBy, this.mWavePeriod, this.mWaveOffset, value);
                }
            }
        }
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    public void addValues(java.util.HashMap<java.lang.String, androidx.constraintlayout.motion.widget.SplineSet> hashMap) {
        androidx.constraintlayout.motion.widget.SplineSet splineSet;
        androidx.constraintlayout.motion.widget.Debug.logStack("KeyCycle", "add " + hashMap.size() + " values", 2);
        for (java.lang.String str : hashMap.keySet()) {
            splineSet = hashMap.get(str);
            str.hashCode();
            switch (str) {
                case "rotationX":
                    splineSet.setPoint(this.mFramePosition, this.mRotationX);
                    break;
                case "rotationY":
                    splineSet.setPoint(this.mFramePosition, this.mRotationY);
                    break;
                case "translationX":
                    splineSet.setPoint(this.mFramePosition, this.mTranslationX);
                    break;
                case "translationY":
                    splineSet.setPoint(this.mFramePosition, this.mTranslationY);
                    break;
                case "translationZ":
                    splineSet.setPoint(this.mFramePosition, this.mTranslationZ);
                    break;
                case "progress":
                    splineSet.setPoint(this.mFramePosition, this.mProgress);
                    break;
                case "scaleX":
                    splineSet.setPoint(this.mFramePosition, this.mScaleX);
                    break;
                case "scaleY":
                    splineSet.setPoint(this.mFramePosition, this.mScaleY);
                    break;
                case "rotation":
                    splineSet.setPoint(this.mFramePosition, this.mRotation);
                    break;
                case "elevation":
                    splineSet.setPoint(this.mFramePosition, this.mElevation);
                    break;
                case "transitionPathRotate":
                    splineSet.setPoint(this.mFramePosition, this.mTransitionPathRotate);
                    break;
                case "alpha":
                    splineSet.setPoint(this.mFramePosition, this.mAlpha);
                    break;
                case "waveOffset":
                    splineSet.setPoint(this.mFramePosition, this.mWaveOffset);
                    break;
                default:
                    java.lang.StringBuilder sb = new java.lang.StringBuilder();
                    sb.append("WARNING KeyCycle UNKNOWN  ");
                    sb.append(str);
                    break;
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
        if (!java.lang.Float.isNaN(this.mScaleX)) {
            hashSet.add("scaleX");
        }
        if (!java.lang.Float.isNaN(this.mScaleY)) {
            hashSet.add("scaleY");
        }
        if (!java.lang.Float.isNaN(this.mTransitionPathRotate)) {
            hashSet.add("transitionPathRotate");
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
        if (this.mCustomConstraints.size() > 0) {
            java.util.Iterator<java.lang.String> it = this.mCustomConstraints.keySet().iterator();
            while (it.hasNext()) {
                hashSet.add("CUSTOM," + it.next());
            }
        }
    }

    public float getValue(java.lang.String str) {
        str.hashCode();
        switch (str) {
            case "rotationX":
                return this.mRotationX;
            case "rotationY":
                return this.mRotationY;
            case "translationX":
                return this.mTranslationX;
            case "translationY":
                return this.mTranslationY;
            case "translationZ":
                return this.mTranslationZ;
            case "progress":
                return this.mProgress;
            case "scaleX":
                return this.mScaleX;
            case "scaleY":
                return this.mScaleY;
            case "rotation":
                return this.mRotation;
            case "elevation":
                return this.mElevation;
            case "transitionPathRotate":
                return this.mTransitionPathRotate;
            case "alpha":
                return this.mAlpha;
            case "waveOffset":
                return this.mWaveOffset;
            default:
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                sb.append("WARNING! KeyCycle UNKNOWN  ");
                sb.append(str);
                return Float.NaN;
        }
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    public void load(android.content.Context context, android.util.AttributeSet attributeSet) {
        androidx.constraintlayout.motion.widget.KeyCycle.Loader.read(this, context.obtainStyledAttributes(attributeSet, androidx.constraintlayout.widget.R.styleable.KeyCycle));
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    public void setValue(java.lang.String str, java.lang.Object obj) {
        str.hashCode();
        switch (str) {
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
            case "progress":
                this.mProgress = toFloat(obj);
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
            case "waveOffset":
                this.mWaveOffset = toFloat(obj);
                break;
            case "wavePeriod":
                this.mWavePeriod = toFloat(obj);
                break;
            case "curveFit":
                this.mCurveFit = toInt(obj);
                break;
            case "mTranslationZ":
                this.mTranslationZ = toFloat(obj);
                break;
        }
    }
}
