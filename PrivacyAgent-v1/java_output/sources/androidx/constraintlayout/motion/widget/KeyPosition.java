package androidx.constraintlayout.motion.widget;

/* loaded from: classes.dex */
public class KeyPosition extends androidx.constraintlayout.motion.widget.KeyPositionBase {
    static final int KEY_TYPE = 2;
    static final java.lang.String NAME = "KeyPosition";
    private static final java.lang.String PERCENT_X = "percentX";
    private static final java.lang.String PERCENT_Y = "percentY";
    private static final java.lang.String TAG = "KeyPosition";
    public static final int TYPE_CARTESIAN = 0;
    public static final int TYPE_PATH = 1;
    public static final int TYPE_SCREEN = 2;
    java.lang.String mTransitionEasing = null;
    int mPathMotionArc = androidx.constraintlayout.motion.widget.Key.UNSET;
    int mDrawPath = 0;
    float mPercentWidth = Float.NaN;
    float mPercentHeight = Float.NaN;
    float mPercentX = Float.NaN;
    float mPercentY = Float.NaN;
    float mAltPercentX = Float.NaN;
    float mAltPercentY = Float.NaN;
    int mPositionType = 0;
    private float mCalculatedPositionX = Float.NaN;
    private float mCalculatedPositionY = Float.NaN;

    public static class Loader {
        private static final int CURVE_FIT = 4;
        private static final int DRAW_PATH = 5;
        private static final int FRAME_POSITION = 2;
        private static final int PATH_MOTION_ARC = 10;
        private static final int PERCENT_HEIGHT = 12;
        private static final int PERCENT_WIDTH = 11;
        private static final int PERCENT_X = 6;
        private static final int PERCENT_Y = 7;
        private static final int SIZE_PERCENT = 8;
        private static final int TARGET_ID = 1;
        private static final int TRANSITION_EASING = 3;
        private static final int TYPE = 9;
        private static android.util.SparseIntArray mAttrMap;

        static {
            android.util.SparseIntArray sparseIntArray = new android.util.SparseIntArray();
            mAttrMap = sparseIntArray;
            sparseIntArray.append(androidx.constraintlayout.widget.R.styleable.KeyPosition_motionTarget, 1);
            mAttrMap.append(androidx.constraintlayout.widget.R.styleable.KeyPosition_framePosition, 2);
            mAttrMap.append(androidx.constraintlayout.widget.R.styleable.KeyPosition_transitionEasing, 3);
            mAttrMap.append(androidx.constraintlayout.widget.R.styleable.KeyPosition_curveFit, 4);
            mAttrMap.append(androidx.constraintlayout.widget.R.styleable.KeyPosition_drawPath, 5);
            mAttrMap.append(androidx.constraintlayout.widget.R.styleable.KeyPosition_percentX, 6);
            mAttrMap.append(androidx.constraintlayout.widget.R.styleable.KeyPosition_percentY, 7);
            mAttrMap.append(androidx.constraintlayout.widget.R.styleable.KeyPosition_keyPositionType, 9);
            mAttrMap.append(androidx.constraintlayout.widget.R.styleable.KeyPosition_sizePercent, 8);
            mAttrMap.append(androidx.constraintlayout.widget.R.styleable.KeyPosition_percentWidth, 11);
            mAttrMap.append(androidx.constraintlayout.widget.R.styleable.KeyPosition_percentHeight, 12);
            mAttrMap.append(androidx.constraintlayout.widget.R.styleable.KeyPosition_pathMotionArc, 10);
        }

        private Loader() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static void read(androidx.constraintlayout.motion.widget.KeyPosition keyPosition, android.content.res.TypedArray typedArray) {
            int indexCount = typedArray.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = typedArray.getIndex(i);
                switch (mAttrMap.get(index)) {
                    case 1:
                        if (androidx.constraintlayout.motion.widget.MotionLayout.IS_IN_EDIT_MODE) {
                            int resourceId = typedArray.getResourceId(index, keyPosition.mTargetId);
                            keyPosition.mTargetId = resourceId;
                            if (resourceId == -1) {
                                keyPosition.mTargetString = typedArray.getString(index);
                                break;
                            } else {
                                break;
                            }
                        } else if (typedArray.peekValue(index).type == 3) {
                            keyPosition.mTargetString = typedArray.getString(index);
                            break;
                        } else {
                            keyPosition.mTargetId = typedArray.getResourceId(index, keyPosition.mTargetId);
                            break;
                        }
                    case 2:
                        keyPosition.mFramePosition = typedArray.getInt(index, keyPosition.mFramePosition);
                        break;
                    case 3:
                        if (typedArray.peekValue(index).type == 3) {
                            keyPosition.mTransitionEasing = typedArray.getString(index);
                            break;
                        } else {
                            keyPosition.mTransitionEasing = androidx.constraintlayout.motion.utils.Easing.NAMED_EASING[typedArray.getInteger(index, 0)];
                            break;
                        }
                    case 4:
                        keyPosition.mCurveFit = typedArray.getInteger(index, keyPosition.mCurveFit);
                        break;
                    case 5:
                        keyPosition.mDrawPath = typedArray.getInt(index, keyPosition.mDrawPath);
                        break;
                    case 6:
                        keyPosition.mPercentX = typedArray.getFloat(index, keyPosition.mPercentX);
                        break;
                    case 7:
                        keyPosition.mPercentY = typedArray.getFloat(index, keyPosition.mPercentY);
                        break;
                    case 8:
                        float f = typedArray.getFloat(index, keyPosition.mPercentHeight);
                        keyPosition.mPercentWidth = f;
                        keyPosition.mPercentHeight = f;
                        break;
                    case 9:
                        keyPosition.mPositionType = typedArray.getInt(index, keyPosition.mPositionType);
                        break;
                    case 10:
                        keyPosition.mPathMotionArc = typedArray.getInt(index, keyPosition.mPathMotionArc);
                        break;
                    case 11:
                        keyPosition.mPercentWidth = typedArray.getFloat(index, keyPosition.mPercentWidth);
                        break;
                    case 12:
                        keyPosition.mPercentHeight = typedArray.getFloat(index, keyPosition.mPercentHeight);
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
            int i2 = keyPosition.mFramePosition;
        }
    }

    public KeyPosition() {
        this.mType = 2;
    }

    private void calcCartesianPosition(float f, float f2, float f3, float f4) {
        float f5 = f3 - f;
        float f6 = f4 - f2;
        float f7 = java.lang.Float.isNaN(this.mPercentX) ? 0.0f : this.mPercentX;
        float f8 = java.lang.Float.isNaN(this.mAltPercentY) ? 0.0f : this.mAltPercentY;
        float f9 = java.lang.Float.isNaN(this.mPercentY) ? 0.0f : this.mPercentY;
        this.mCalculatedPositionX = (int) (f + (f7 * f5) + ((java.lang.Float.isNaN(this.mAltPercentX) ? 0.0f : this.mAltPercentX) * f6));
        this.mCalculatedPositionY = (int) (f2 + (f5 * f8) + (f6 * f9));
    }

    private void calcPathPosition(float f, float f2, float f3, float f4) {
        float f5 = f3 - f;
        float f6 = f4 - f2;
        float f7 = this.mPercentX;
        float f8 = this.mPercentY;
        this.mCalculatedPositionX = f + (f5 * f7) + ((-f6) * f8);
        this.mCalculatedPositionY = f2 + (f6 * f7) + (f5 * f8);
    }

    private void calcScreenPosition(int i, int i2) {
        float f = this.mPercentX;
        float f2 = 0;
        this.mCalculatedPositionX = ((i - 0) * f) + f2;
        this.mCalculatedPositionY = ((i2 - 0) * f) + f2;
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    public void addValues(java.util.HashMap<java.lang.String, androidx.constraintlayout.motion.widget.SplineSet> hashMap) {
    }

    @Override // androidx.constraintlayout.motion.widget.KeyPositionBase
    public void calcPosition(int i, int i2, float f, float f2, float f3, float f4) {
        int i3 = this.mPositionType;
        if (i3 == 1) {
            calcPathPosition(f, f2, f3, f4);
        } else if (i3 != 2) {
            calcCartesianPosition(f, f2, f3, f4);
        } else {
            calcScreenPosition(i, i2);
        }
    }

    @Override // androidx.constraintlayout.motion.widget.KeyPositionBase
    public float getPositionX() {
        return this.mCalculatedPositionX;
    }

    @Override // androidx.constraintlayout.motion.widget.KeyPositionBase
    public float getPositionY() {
        return this.mCalculatedPositionY;
    }

    @Override // androidx.constraintlayout.motion.widget.KeyPositionBase
    public boolean intersects(int i, int i2, android.graphics.RectF rectF, android.graphics.RectF rectF2, float f, float f2) {
        calcPosition(i, i2, rectF.centerX(), rectF.centerY(), rectF2.centerX(), rectF2.centerY());
        return java.lang.Math.abs(f - this.mCalculatedPositionX) < 20.0f && java.lang.Math.abs(f2 - this.mCalculatedPositionY) < 20.0f;
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    public void load(android.content.Context context, android.util.AttributeSet attributeSet) {
        androidx.constraintlayout.motion.widget.KeyPosition.Loader.read(this, context.obtainStyledAttributes(attributeSet, androidx.constraintlayout.widget.R.styleable.KeyPosition));
    }

    @Override // androidx.constraintlayout.motion.widget.KeyPositionBase
    public void positionAttributes(android.view.View view, android.graphics.RectF rectF, android.graphics.RectF rectF2, float f, float f2, java.lang.String[] strArr, float[] fArr) {
        int i = this.mPositionType;
        if (i == 1) {
            positionPathAttributes(rectF, rectF2, f, f2, strArr, fArr);
        } else if (i != 2) {
            positionCartAttributes(rectF, rectF2, f, f2, strArr, fArr);
        } else {
            positionScreenAttributes(view, rectF, rectF2, f, f2, strArr, fArr);
        }
    }

    public void positionCartAttributes(android.graphics.RectF rectF, android.graphics.RectF rectF2, float f, float f2, java.lang.String[] strArr, float[] fArr) {
        float centerX = rectF.centerX();
        float centerY = rectF.centerY();
        float centerX2 = rectF2.centerX() - centerX;
        float centerY2 = rectF2.centerY() - centerY;
        java.lang.String str = strArr[0];
        if (str == null) {
            strArr[0] = PERCENT_X;
            fArr[0] = (f - centerX) / centerX2;
            strArr[1] = PERCENT_Y;
            fArr[1] = (f2 - centerY) / centerY2;
            return;
        }
        if (PERCENT_X.equals(str)) {
            fArr[0] = (f - centerX) / centerX2;
            fArr[1] = (f2 - centerY) / centerY2;
        } else {
            fArr[1] = (f - centerX) / centerX2;
            fArr[0] = (f2 - centerY) / centerY2;
        }
    }

    public void positionPathAttributes(android.graphics.RectF rectF, android.graphics.RectF rectF2, float f, float f2, java.lang.String[] strArr, float[] fArr) {
        float centerX = rectF.centerX();
        float centerY = rectF.centerY();
        float centerX2 = rectF2.centerX() - centerX;
        float centerY2 = rectF2.centerY() - centerY;
        float hypot = (float) java.lang.Math.hypot(centerX2, centerY2);
        if (hypot < 1.0E-4d) {
            java.lang.System.out.println("distance ~ 0");
            fArr[0] = 0.0f;
            fArr[1] = 0.0f;
            return;
        }
        float f3 = centerX2 / hypot;
        float f4 = centerY2 / hypot;
        float f5 = f2 - centerY;
        float f6 = f - centerX;
        float f7 = ((f3 * f5) - (f6 * f4)) / hypot;
        float f8 = ((f3 * f6) + (f4 * f5)) / hypot;
        java.lang.String str = strArr[0];
        if (str != null) {
            if (PERCENT_X.equals(str)) {
                fArr[0] = f8;
                fArr[1] = f7;
                return;
            }
            return;
        }
        strArr[0] = PERCENT_X;
        strArr[1] = PERCENT_Y;
        fArr[0] = f8;
        fArr[1] = f7;
    }

    public void positionScreenAttributes(android.view.View view, android.graphics.RectF rectF, android.graphics.RectF rectF2, float f, float f2, java.lang.String[] strArr, float[] fArr) {
        rectF.centerX();
        rectF.centerY();
        rectF2.centerX();
        rectF2.centerY();
        android.view.ViewGroup viewGroup = (android.view.ViewGroup) view.getParent();
        int width = viewGroup.getWidth();
        int height = viewGroup.getHeight();
        java.lang.String str = strArr[0];
        if (str == null) {
            strArr[0] = PERCENT_X;
            fArr[0] = f / width;
            strArr[1] = PERCENT_Y;
            fArr[1] = f2 / height;
            return;
        }
        if (PERCENT_X.equals(str)) {
            fArr[0] = f / width;
            fArr[1] = f2 / height;
        } else {
            fArr[1] = f / width;
            fArr[0] = f2 / height;
        }
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    public void setValue(java.lang.String str, java.lang.Object obj) {
        str.hashCode();
        switch (str) {
            case "transitionEasing":
                this.mTransitionEasing = obj.toString();
                break;
            case "percentWidth":
                this.mPercentWidth = toFloat(obj);
                break;
            case "percentHeight":
                this.mPercentHeight = toFloat(obj);
                break;
            case "drawPath":
                this.mDrawPath = toInt(obj);
                break;
            case "sizePercent":
                float f = toFloat(obj);
                this.mPercentWidth = f;
                this.mPercentHeight = f;
                break;
            case "percentX":
                this.mPercentX = toFloat(obj);
                break;
            case "percentY":
                this.mPercentY = toFloat(obj);
                break;
        }
    }
}
