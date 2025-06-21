package androidx.constraintlayout.motion.widget;

/* loaded from: classes.dex */
class MotionPaths implements java.lang.Comparable<androidx.constraintlayout.motion.widget.MotionPaths> {
    static final int CARTESIAN = 2;
    public static final boolean DEBUG = false;
    static final int OFF_HEIGHT = 4;
    static final int OFF_PATH_ROTATE = 5;
    static final int OFF_POSITION = 0;
    static final int OFF_WIDTH = 3;
    static final int OFF_X = 1;
    static final int OFF_Y = 2;
    public static final boolean OLD_WAY = false;
    static final int PERPENDICULAR = 1;
    static final int SCREEN = 3;
    public static final java.lang.String TAG = "MotionPaths";
    static java.lang.String[] names = {com.alibaba.sdk.android.oss.common.RequestParameters.POSITION, "x", "y", "width", "height", "pathRotate"};
    java.util.LinkedHashMap<java.lang.String, androidx.constraintlayout.widget.ConstraintAttribute> attributes;
    float height;
    int mDrawPath;
    androidx.constraintlayout.motion.utils.Easing mKeyFrameEasing;
    int mMode;
    int mPathMotionArc;
    float mPathRotate;
    float mProgress;
    double[] mTempDelta;
    double[] mTempValue;
    float position;
    float time;
    float width;
    float x;
    float y;

    public MotionPaths() {
        this.mDrawPath = 0;
        this.mPathRotate = Float.NaN;
        this.mProgress = Float.NaN;
        this.mPathMotionArc = androidx.constraintlayout.motion.widget.Key.UNSET;
        this.attributes = new java.util.LinkedHashMap<>();
        this.mMode = 0;
        this.mTempValue = new double[18];
        this.mTempDelta = new double[18];
    }

    public MotionPaths(int i, int i2, androidx.constraintlayout.motion.widget.KeyPosition keyPosition, androidx.constraintlayout.motion.widget.MotionPaths motionPaths, androidx.constraintlayout.motion.widget.MotionPaths motionPaths2) {
        this.mDrawPath = 0;
        this.mPathRotate = Float.NaN;
        this.mProgress = Float.NaN;
        this.mPathMotionArc = androidx.constraintlayout.motion.widget.Key.UNSET;
        this.attributes = new java.util.LinkedHashMap<>();
        this.mMode = 0;
        this.mTempValue = new double[18];
        this.mTempDelta = new double[18];
        int i3 = keyPosition.mPositionType;
        if (i3 == 1) {
            initPath(keyPosition, motionPaths, motionPaths2);
        } else if (i3 != 2) {
            initCartesian(keyPosition, motionPaths, motionPaths2);
        } else {
            initScreen(i, i2, keyPosition, motionPaths, motionPaths2);
        }
    }

    private boolean diff(float f, float f2) {
        return (java.lang.Float.isNaN(f) || java.lang.Float.isNaN(f2)) ? java.lang.Float.isNaN(f) != java.lang.Float.isNaN(f2) : java.lang.Math.abs(f - f2) > 1.0E-6f;
    }

    private static final float xRotate(float f, float f2, float f3, float f4, float f5, float f6) {
        return (((f5 - f3) * f2) - ((f6 - f4) * f)) + f3;
    }

    private static final float yRotate(float f, float f2, float f3, float f4, float f5, float f6) {
        return ((f5 - f3) * f) + ((f6 - f4) * f2) + f4;
    }

    public void applyParameters(androidx.constraintlayout.widget.ConstraintSet.Constraint constraint) {
        this.mKeyFrameEasing = androidx.constraintlayout.motion.utils.Easing.getInterpolator(constraint.motion.mTransitionEasing);
        androidx.constraintlayout.widget.ConstraintSet.Motion motion = constraint.motion;
        this.mPathMotionArc = motion.mPathMotionArc;
        this.mPathRotate = motion.mPathRotate;
        this.mDrawPath = motion.mDrawPath;
        this.mProgress = constraint.propertySet.mProgress;
        for (java.lang.String str : constraint.mCustomConstraints.keySet()) {
            androidx.constraintlayout.widget.ConstraintAttribute constraintAttribute = constraint.mCustomConstraints.get(str);
            if (constraintAttribute.getType() != androidx.constraintlayout.widget.ConstraintAttribute.AttributeType.STRING_TYPE) {
                this.attributes.put(str, constraintAttribute);
            }
        }
    }

    @Override // java.lang.Comparable
    public int compareTo(@androidx.annotation.NonNull androidx.constraintlayout.motion.widget.MotionPaths motionPaths) {
        return java.lang.Float.compare(this.position, motionPaths.position);
    }

    public void different(androidx.constraintlayout.motion.widget.MotionPaths motionPaths, boolean[] zArr, java.lang.String[] strArr, boolean z) {
        zArr[0] = zArr[0] | diff(this.position, motionPaths.position);
        zArr[1] = zArr[1] | diff(this.x, motionPaths.x) | z;
        zArr[2] = z | diff(this.y, motionPaths.y) | zArr[2];
        zArr[3] = zArr[3] | diff(this.width, motionPaths.width);
        zArr[4] = diff(this.height, motionPaths.height) | zArr[4];
    }

    public void fillStandard(double[] dArr, int[] iArr) {
        float[] fArr = {this.position, this.x, this.y, this.width, this.height, this.mPathRotate};
        int i = 0;
        for (int i2 : iArr) {
            if (i2 < 6) {
                dArr[i] = fArr[r4];
                i++;
            }
        }
    }

    public void getBounds(int[] iArr, double[] dArr, float[] fArr, int i) {
        float f = this.width;
        float f2 = this.height;
        for (int i2 = 0; i2 < iArr.length; i2++) {
            float f3 = (float) dArr[i2];
            int i3 = iArr[i2];
            if (i3 == 3) {
                f = f3;
            } else if (i3 == 4) {
                f2 = f3;
            }
        }
        fArr[i] = f;
        fArr[i + 1] = f2;
    }

    public void getCenter(int[] iArr, double[] dArr, float[] fArr, int i) {
        float f = this.x;
        float f2 = this.y;
        float f3 = this.width;
        float f4 = this.height;
        for (int i2 = 0; i2 < iArr.length; i2++) {
            float f5 = (float) dArr[i2];
            int i3 = iArr[i2];
            if (i3 == 1) {
                f = f5;
            } else if (i3 == 2) {
                f2 = f5;
            } else if (i3 == 3) {
                f3 = f5;
            } else if (i3 == 4) {
                f4 = f5;
            }
        }
        fArr[i] = f + (f3 / 2.0f) + 0.0f;
        fArr[i + 1] = f2 + (f4 / 2.0f) + 0.0f;
    }

    public int getCustomData(java.lang.String str, double[] dArr, int i) {
        androidx.constraintlayout.widget.ConstraintAttribute constraintAttribute = this.attributes.get(str);
        if (constraintAttribute.noOfInterpValues() == 1) {
            dArr[i] = constraintAttribute.getValueToInterpolate();
            return 1;
        }
        int noOfInterpValues = constraintAttribute.noOfInterpValues();
        constraintAttribute.getValuesToInterpolate(new float[noOfInterpValues]);
        int i2 = 0;
        while (i2 < noOfInterpValues) {
            dArr[i] = r1[i2];
            i2++;
            i++;
        }
        return noOfInterpValues;
    }

    public int getCustomDataCount(java.lang.String str) {
        return this.attributes.get(str).noOfInterpValues();
    }

    public void getRect(int[] iArr, double[] dArr, float[] fArr, int i) {
        float f = this.x;
        float f2 = this.y;
        float f3 = this.width;
        float f4 = this.height;
        for (int i2 = 0; i2 < iArr.length; i2++) {
            float f5 = (float) dArr[i2];
            int i3 = iArr[i2];
            if (i3 == 1) {
                f = f5;
            } else if (i3 == 2) {
                f2 = f5;
            } else if (i3 == 3) {
                f3 = f5;
            } else if (i3 == 4) {
                f4 = f5;
            }
        }
        float f6 = f3 + f;
        float f7 = f4 + f2;
        java.lang.Float.isNaN(Float.NaN);
        java.lang.Float.isNaN(Float.NaN);
        int i4 = i + 1;
        fArr[i] = f + 0.0f;
        int i5 = i4 + 1;
        fArr[i4] = f2 + 0.0f;
        int i6 = i5 + 1;
        fArr[i5] = f6 + 0.0f;
        int i7 = i6 + 1;
        fArr[i6] = f2 + 0.0f;
        int i8 = i7 + 1;
        fArr[i7] = f6 + 0.0f;
        int i9 = i8 + 1;
        fArr[i8] = f7 + 0.0f;
        fArr[i9] = f + 0.0f;
        fArr[i9 + 1] = f7 + 0.0f;
    }

    public boolean hasCustomData(java.lang.String str) {
        return this.attributes.containsKey(str);
    }

    public void initCartesian(androidx.constraintlayout.motion.widget.KeyPosition keyPosition, androidx.constraintlayout.motion.widget.MotionPaths motionPaths, androidx.constraintlayout.motion.widget.MotionPaths motionPaths2) {
        float f = keyPosition.mFramePosition / 100.0f;
        this.time = f;
        this.mDrawPath = keyPosition.mDrawPath;
        float f2 = java.lang.Float.isNaN(keyPosition.mPercentWidth) ? f : keyPosition.mPercentWidth;
        float f3 = java.lang.Float.isNaN(keyPosition.mPercentHeight) ? f : keyPosition.mPercentHeight;
        float f4 = motionPaths2.width;
        float f5 = motionPaths.width;
        float f6 = motionPaths2.height;
        float f7 = motionPaths.height;
        this.position = this.time;
        float f8 = motionPaths.x;
        float f9 = motionPaths.y;
        float f10 = (motionPaths2.x + (f4 / 2.0f)) - ((f5 / 2.0f) + f8);
        float f11 = (motionPaths2.y + (f6 / 2.0f)) - (f9 + (f7 / 2.0f));
        float f12 = ((f4 - f5) * f2) / 2.0f;
        this.x = (int) ((f8 + (f10 * f)) - f12);
        float f13 = ((f6 - f7) * f3) / 2.0f;
        this.y = (int) ((f9 + (f11 * f)) - f13);
        this.width = (int) (f5 + r9);
        this.height = (int) (f7 + r12);
        float f14 = java.lang.Float.isNaN(keyPosition.mPercentX) ? f : keyPosition.mPercentX;
        float f15 = java.lang.Float.isNaN(keyPosition.mAltPercentY) ? 0.0f : keyPosition.mAltPercentY;
        if (!java.lang.Float.isNaN(keyPosition.mPercentY)) {
            f = keyPosition.mPercentY;
        }
        float f16 = java.lang.Float.isNaN(keyPosition.mAltPercentX) ? 0.0f : keyPosition.mAltPercentX;
        this.mMode = 2;
        this.x = (int) (((motionPaths.x + (f14 * f10)) + (f16 * f11)) - f12);
        this.y = (int) (((motionPaths.y + (f10 * f15)) + (f11 * f)) - f13);
        this.mKeyFrameEasing = androidx.constraintlayout.motion.utils.Easing.getInterpolator(keyPosition.mTransitionEasing);
        this.mPathMotionArc = keyPosition.mPathMotionArc;
    }

    public void initPath(androidx.constraintlayout.motion.widget.KeyPosition keyPosition, androidx.constraintlayout.motion.widget.MotionPaths motionPaths, androidx.constraintlayout.motion.widget.MotionPaths motionPaths2) {
        float f = keyPosition.mFramePosition / 100.0f;
        this.time = f;
        this.mDrawPath = keyPosition.mDrawPath;
        float f2 = java.lang.Float.isNaN(keyPosition.mPercentWidth) ? f : keyPosition.mPercentWidth;
        float f3 = java.lang.Float.isNaN(keyPosition.mPercentHeight) ? f : keyPosition.mPercentHeight;
        float f4 = motionPaths2.width - motionPaths.width;
        float f5 = motionPaths2.height - motionPaths.height;
        this.position = this.time;
        if (!java.lang.Float.isNaN(keyPosition.mPercentX)) {
            f = keyPosition.mPercentX;
        }
        float f6 = motionPaths.x;
        float f7 = motionPaths.width;
        float f8 = motionPaths.y;
        float f9 = motionPaths.height;
        float f10 = (motionPaths2.x + (motionPaths2.width / 2.0f)) - ((f7 / 2.0f) + f6);
        float f11 = (motionPaths2.y + (motionPaths2.height / 2.0f)) - ((f9 / 2.0f) + f8);
        float f12 = f10 * f;
        float f13 = (f4 * f2) / 2.0f;
        this.x = (int) ((f6 + f12) - f13);
        float f14 = f * f11;
        float f15 = (f5 * f3) / 2.0f;
        this.y = (int) ((f8 + f14) - f15);
        this.width = (int) (f7 + r7);
        this.height = (int) (f9 + r8);
        float f16 = java.lang.Float.isNaN(keyPosition.mPercentY) ? 0.0f : keyPosition.mPercentY;
        this.mMode = 1;
        float f17 = (int) ((motionPaths.x + f12) - f13);
        float f18 = (int) ((motionPaths.y + f14) - f15);
        this.x = f17 + ((-f11) * f16);
        this.y = f18 + (f10 * f16);
        this.mKeyFrameEasing = androidx.constraintlayout.motion.utils.Easing.getInterpolator(keyPosition.mTransitionEasing);
        this.mPathMotionArc = keyPosition.mPathMotionArc;
    }

    public void initScreen(int i, int i2, androidx.constraintlayout.motion.widget.KeyPosition keyPosition, androidx.constraintlayout.motion.widget.MotionPaths motionPaths, androidx.constraintlayout.motion.widget.MotionPaths motionPaths2) {
        float f = keyPosition.mFramePosition / 100.0f;
        this.time = f;
        this.mDrawPath = keyPosition.mDrawPath;
        float f2 = java.lang.Float.isNaN(keyPosition.mPercentWidth) ? f : keyPosition.mPercentWidth;
        float f3 = java.lang.Float.isNaN(keyPosition.mPercentHeight) ? f : keyPosition.mPercentHeight;
        float f4 = motionPaths2.width;
        float f5 = motionPaths.width;
        float f6 = motionPaths2.height;
        float f7 = motionPaths.height;
        this.position = this.time;
        float f8 = motionPaths.x;
        float f9 = motionPaths.y;
        float f10 = motionPaths2.x + (f4 / 2.0f);
        float f11 = motionPaths2.y + (f6 / 2.0f);
        float f12 = (f4 - f5) * f2;
        this.x = (int) ((f8 + ((f10 - ((f5 / 2.0f) + f8)) * f)) - (f12 / 2.0f));
        float f13 = (f6 - f7) * f3;
        this.y = (int) ((f9 + ((f11 - (f9 + (f7 / 2.0f))) * f)) - (f13 / 2.0f));
        this.width = (int) (f5 + f12);
        this.height = (int) (f7 + f13);
        this.mMode = 3;
        if (!java.lang.Float.isNaN(keyPosition.mPercentX)) {
            this.x = (int) (keyPosition.mPercentX * ((int) (i - this.width)));
        }
        if (!java.lang.Float.isNaN(keyPosition.mPercentY)) {
            this.y = (int) (keyPosition.mPercentY * ((int) (i2 - this.height)));
        }
        this.mKeyFrameEasing = androidx.constraintlayout.motion.utils.Easing.getInterpolator(keyPosition.mTransitionEasing);
        this.mPathMotionArc = keyPosition.mPathMotionArc;
    }

    public void setBounds(float f, float f2, float f3, float f4) {
        this.x = f;
        this.y = f2;
        this.width = f3;
        this.height = f4;
    }

    public void setDpDt(float f, float f2, float[] fArr, int[] iArr, double[] dArr, double[] dArr2) {
        float f3 = 0.0f;
        float f4 = 0.0f;
        float f5 = 0.0f;
        float f6 = 0.0f;
        for (int i = 0; i < iArr.length; i++) {
            float f7 = (float) dArr[i];
            double d = dArr2[i];
            int i2 = iArr[i];
            if (i2 == 1) {
                f3 = f7;
            } else if (i2 == 2) {
                f5 = f7;
            } else if (i2 == 3) {
                f4 = f7;
            } else if (i2 == 4) {
                f6 = f7;
            }
        }
        float f8 = f3 - ((0.0f * f4) / 2.0f);
        float f9 = f5 - ((0.0f * f6) / 2.0f);
        fArr[0] = (f8 * (1.0f - f)) + (((f4 * 1.0f) + f8) * f) + 0.0f;
        fArr[1] = (f9 * (1.0f - f2)) + (((f6 * 1.0f) + f9) * f2) + 0.0f;
    }

    public void setView(android.view.View view, int[] iArr, double[] dArr, double[] dArr2, double[] dArr3) {
        float f;
        float f2;
        float f3 = this.x;
        float f4 = this.y;
        float f5 = this.width;
        float f6 = this.height;
        if (iArr.length != 0 && this.mTempValue.length <= iArr[iArr.length - 1]) {
            int i = iArr[iArr.length - 1] + 1;
            this.mTempValue = new double[i];
            this.mTempDelta = new double[i];
        }
        java.util.Arrays.fill(this.mTempValue, Double.NaN);
        for (int i2 = 0; i2 < iArr.length; i2++) {
            double[] dArr4 = this.mTempValue;
            int i3 = iArr[i2];
            dArr4[i3] = dArr[i2];
            this.mTempDelta[i3] = dArr2[i2];
        }
        int i4 = 0;
        float f7 = Float.NaN;
        float f8 = 0.0f;
        float f9 = 0.0f;
        float f10 = 0.0f;
        float f11 = 0.0f;
        while (true) {
            double[] dArr5 = this.mTempValue;
            if (i4 >= dArr5.length) {
                break;
            }
            if (java.lang.Double.isNaN(dArr5[i4]) && (dArr3 == null || dArr3[i4] == 0.0d)) {
                f2 = f3;
            } else {
                double d = dArr3 != null ? dArr3[i4] : 0.0d;
                if (!java.lang.Double.isNaN(this.mTempValue[i4])) {
                    d = this.mTempValue[i4] + d;
                }
                f = (float) d;
                f2 = f3;
                float f12 = (float) this.mTempDelta[i4];
                if (i4 == 1) {
                    f8 = f12;
                    i4++;
                    f3 = f;
                } else if (i4 == 2) {
                    f10 = f12;
                    f4 = f;
                } else if (i4 == 3) {
                    f9 = f12;
                    f5 = f;
                } else if (i4 == 4) {
                    f11 = f12;
                    f6 = f;
                } else if (i4 == 5) {
                    f7 = f;
                }
            }
            f = f2;
            i4++;
            f3 = f;
        }
        float f13 = f3;
        if (!java.lang.Float.isNaN(f7)) {
            view.setRotation((float) ((java.lang.Float.isNaN(Float.NaN) ? 0.0f : Float.NaN) + f7 + java.lang.Math.toDegrees(java.lang.Math.atan2(f10 + (f11 / 2.0f), f8 + (f9 / 2.0f)))));
        } else if (!java.lang.Float.isNaN(Float.NaN)) {
            view.setRotation(Float.NaN);
        }
        float f14 = f13 + 0.5f;
        int i5 = (int) f14;
        float f15 = f4 + 0.5f;
        int i6 = (int) f15;
        int i7 = (int) (f14 + f5);
        int i8 = (int) (f15 + f6);
        int i9 = i7 - i5;
        int i10 = i8 - i6;
        if ((i9 == view.getMeasuredWidth() && i10 == view.getMeasuredHeight()) ? false : true) {
            view.measure(android.view.View.MeasureSpec.makeMeasureSpec(i9, 1073741824), android.view.View.MeasureSpec.makeMeasureSpec(i10, 1073741824));
        }
        view.layout(i5, i6, i7, i8);
    }
}
