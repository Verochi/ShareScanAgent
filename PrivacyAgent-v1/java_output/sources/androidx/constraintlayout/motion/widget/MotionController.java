package androidx.constraintlayout.motion.widget;

/* loaded from: classes.dex */
public class MotionController {
    private static final boolean DEBUG = false;
    public static final int DRAW_PATH_AS_CONFIGURED = 4;
    public static final int DRAW_PATH_BASIC = 1;
    public static final int DRAW_PATH_CARTESIAN = 3;
    public static final int DRAW_PATH_NONE = 0;
    public static final int DRAW_PATH_RECTANGLE = 5;
    public static final int DRAW_PATH_RELATIVE = 2;
    public static final int DRAW_PATH_SCREEN = 6;
    private static final boolean FAVOR_FIXED_SIZE_VIEWS = false;
    public static final int HORIZONTAL_PATH_X = 2;
    public static final int HORIZONTAL_PATH_Y = 3;
    public static final int PATH_PERCENT = 0;
    public static final int PATH_PERPENDICULAR = 1;
    private static final java.lang.String TAG = "MotionController";
    public static final int VERTICAL_PATH_X = 4;
    public static final int VERTICAL_PATH_Y = 5;
    java.lang.String[] attributeTable;
    private androidx.constraintlayout.motion.utils.CurveFit mArcSpline;
    private int[] mAttributeInterpCount;
    private java.lang.String[] mAttributeNames;
    private java.util.HashMap<java.lang.String, androidx.constraintlayout.motion.widget.SplineSet> mAttributesMap;
    java.lang.String mConstraintTag;
    private java.util.HashMap<java.lang.String, androidx.constraintlayout.motion.widget.KeyCycleOscillator> mCycleMap;
    int mId;
    private double[] mInterpolateData;
    private int[] mInterpolateVariables;
    private double[] mInterpolateVelocity;
    private androidx.constraintlayout.motion.widget.KeyTrigger[] mKeyTriggers;
    private androidx.constraintlayout.motion.utils.CurveFit[] mSpline;
    private java.util.HashMap<java.lang.String, androidx.constraintlayout.motion.widget.TimeCycleSplineSet> mTimeCycleAttributesMap;
    android.view.View mView;
    private int mCurveFitType = -1;
    private androidx.constraintlayout.motion.widget.MotionPaths mStartMotionPath = new androidx.constraintlayout.motion.widget.MotionPaths();
    private androidx.constraintlayout.motion.widget.MotionPaths mEndMotionPath = new androidx.constraintlayout.motion.widget.MotionPaths();
    private androidx.constraintlayout.motion.widget.MotionConstrainedPoint mStartPoint = new androidx.constraintlayout.motion.widget.MotionConstrainedPoint();
    private androidx.constraintlayout.motion.widget.MotionConstrainedPoint mEndPoint = new androidx.constraintlayout.motion.widget.MotionConstrainedPoint();
    float mMotionStagger = Float.NaN;
    float mStaggerOffset = 0.0f;
    float mStaggerScale = 1.0f;
    private int MAX_DIMENSION = 4;
    private float[] mValuesBuff = new float[4];
    private java.util.ArrayList<androidx.constraintlayout.motion.widget.MotionPaths> mMotionPaths = new java.util.ArrayList<>();
    private float[] mVelocity = new float[1];
    private java.util.ArrayList<androidx.constraintlayout.motion.widget.Key> mKeyList = new java.util.ArrayList<>();
    private int mPathMotionArc = androidx.constraintlayout.motion.widget.Key.UNSET;

    public MotionController(android.view.View view) {
        setView(view);
    }

    private float getAdjustedPosition(float f, float[] fArr) {
        float f2 = 0.0f;
        if (fArr != null) {
            fArr[0] = 1.0f;
        } else {
            float f3 = this.mStaggerScale;
            if (f3 != 1.0d) {
                float f4 = this.mStaggerOffset;
                if (f < f4) {
                    f = 0.0f;
                }
                if (f > f4 && f < 1.0d) {
                    f = (f - f4) * f3;
                }
            }
        }
        androidx.constraintlayout.motion.utils.Easing easing = this.mStartMotionPath.mKeyFrameEasing;
        java.util.Iterator<androidx.constraintlayout.motion.widget.MotionPaths> it = this.mMotionPaths.iterator();
        float f5 = Float.NaN;
        while (it.hasNext()) {
            androidx.constraintlayout.motion.widget.MotionPaths next = it.next();
            androidx.constraintlayout.motion.utils.Easing easing2 = next.mKeyFrameEasing;
            if (easing2 != null) {
                float f6 = next.time;
                if (f6 < f) {
                    easing = easing2;
                    f2 = f6;
                } else if (java.lang.Float.isNaN(f5)) {
                    f5 = next.time;
                }
            }
        }
        if (easing != null) {
            float f7 = (java.lang.Float.isNaN(f5) ? 1.0f : f5) - f2;
            double d = (f - f2) / f7;
            f = (((float) easing.get(d)) * f7) + f2;
            if (fArr != null) {
                fArr[0] = (float) easing.getDiff(d);
            }
        }
        return f;
    }

    private float getPreCycleDistance() {
        float[] fArr = new float[2];
        float f = 1.0f / 99;
        double d = 0.0d;
        double d2 = 0.0d;
        int i = 0;
        float f2 = 0.0f;
        while (i < 100) {
            float f3 = i * f;
            double d3 = f3;
            androidx.constraintlayout.motion.utils.Easing easing = this.mStartMotionPath.mKeyFrameEasing;
            java.util.Iterator<androidx.constraintlayout.motion.widget.MotionPaths> it = this.mMotionPaths.iterator();
            float f4 = Float.NaN;
            float f5 = 0.0f;
            while (it.hasNext()) {
                androidx.constraintlayout.motion.widget.MotionPaths next = it.next();
                androidx.constraintlayout.motion.utils.Easing easing2 = next.mKeyFrameEasing;
                float f6 = f;
                if (easing2 != null) {
                    float f7 = next.time;
                    if (f7 < f3) {
                        f5 = f7;
                        easing = easing2;
                    } else if (java.lang.Float.isNaN(f4)) {
                        f4 = next.time;
                    }
                }
                f = f6;
            }
            float f8 = f;
            if (easing != null) {
                if (java.lang.Float.isNaN(f4)) {
                    f4 = 1.0f;
                }
                d3 = (((float) easing.get((f3 - f5) / r16)) * (f4 - f5)) + f5;
            }
            this.mSpline[0].getPos(d3, this.mInterpolateData);
            this.mStartMotionPath.getCenter(this.mInterpolateVariables, this.mInterpolateData, fArr, 0);
            if (i > 0) {
                f2 = (float) (f2 + java.lang.Math.hypot(d2 - fArr[1], d - fArr[0]));
            }
            d = fArr[0];
            d2 = fArr[1];
            i++;
            f = f8;
        }
        return f2;
    }

    private void insertKey(androidx.constraintlayout.motion.widget.MotionPaths motionPaths) {
        if (java.util.Collections.binarySearch(this.mMotionPaths, motionPaths) == 0) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append(" KeyPath positon \"");
            sb.append(motionPaths.position);
            sb.append("\" outside of range");
        }
        this.mMotionPaths.add((-r0) - 1, motionPaths);
    }

    private void readView(androidx.constraintlayout.motion.widget.MotionPaths motionPaths) {
        motionPaths.setBounds((int) this.mView.getX(), (int) this.mView.getY(), this.mView.getWidth(), this.mView.getHeight());
    }

    public void addKey(androidx.constraintlayout.motion.widget.Key key) {
        this.mKeyList.add(key);
    }

    public void addKeys(java.util.ArrayList<androidx.constraintlayout.motion.widget.Key> arrayList) {
        this.mKeyList.addAll(arrayList);
    }

    public void buildBounds(float[] fArr, int i) {
        float f = 1.0f / (i - 1);
        java.util.HashMap<java.lang.String, androidx.constraintlayout.motion.widget.SplineSet> hashMap = this.mAttributesMap;
        if (hashMap != null) {
            hashMap.get("translationX");
        }
        java.util.HashMap<java.lang.String, androidx.constraintlayout.motion.widget.SplineSet> hashMap2 = this.mAttributesMap;
        if (hashMap2 != null) {
            hashMap2.get("translationY");
        }
        java.util.HashMap<java.lang.String, androidx.constraintlayout.motion.widget.KeyCycleOscillator> hashMap3 = this.mCycleMap;
        if (hashMap3 != null) {
            hashMap3.get("translationX");
        }
        java.util.HashMap<java.lang.String, androidx.constraintlayout.motion.widget.KeyCycleOscillator> hashMap4 = this.mCycleMap;
        if (hashMap4 != null) {
            hashMap4.get("translationY");
        }
        for (int i2 = 0; i2 < i; i2++) {
            float f2 = i2 * f;
            float f3 = this.mStaggerScale;
            float f4 = 0.0f;
            if (f3 != 1.0f) {
                float f5 = this.mStaggerOffset;
                if (f2 < f5) {
                    f2 = 0.0f;
                }
                if (f2 > f5 && f2 < 1.0d) {
                    f2 = (f2 - f5) * f3;
                }
            }
            double d = f2;
            androidx.constraintlayout.motion.utils.Easing easing = this.mStartMotionPath.mKeyFrameEasing;
            java.util.Iterator<androidx.constraintlayout.motion.widget.MotionPaths> it = this.mMotionPaths.iterator();
            float f6 = Float.NaN;
            while (it.hasNext()) {
                androidx.constraintlayout.motion.widget.MotionPaths next = it.next();
                androidx.constraintlayout.motion.utils.Easing easing2 = next.mKeyFrameEasing;
                if (easing2 != null) {
                    float f7 = next.time;
                    if (f7 < f2) {
                        easing = easing2;
                        f4 = f7;
                    } else if (java.lang.Float.isNaN(f6)) {
                        f6 = next.time;
                    }
                }
            }
            if (easing != null) {
                if (java.lang.Float.isNaN(f6)) {
                    f6 = 1.0f;
                }
                d = (((float) easing.get((f2 - f4) / r12)) * (f6 - f4)) + f4;
            }
            this.mSpline[0].getPos(d, this.mInterpolateData);
            androidx.constraintlayout.motion.utils.CurveFit curveFit = this.mArcSpline;
            if (curveFit != null) {
                double[] dArr = this.mInterpolateData;
                if (dArr.length > 0) {
                    curveFit.getPos(d, dArr);
                }
            }
            this.mStartMotionPath.getBounds(this.mInterpolateVariables, this.mInterpolateData, fArr, i2 * 2);
        }
    }

    public int buildKeyBounds(float[] fArr, int[] iArr) {
        if (fArr == null) {
            return 0;
        }
        double[] timePoints = this.mSpline[0].getTimePoints();
        if (iArr != null) {
            java.util.Iterator<androidx.constraintlayout.motion.widget.MotionPaths> it = this.mMotionPaths.iterator();
            int i = 0;
            while (it.hasNext()) {
                iArr[i] = it.next().mMode;
                i++;
            }
        }
        int i2 = 0;
        for (double d : timePoints) {
            this.mSpline[0].getPos(d, this.mInterpolateData);
            this.mStartMotionPath.getBounds(this.mInterpolateVariables, this.mInterpolateData, fArr, i2);
            i2 += 2;
        }
        return i2 / 2;
    }

    public int buildKeyFrames(float[] fArr, int[] iArr) {
        if (fArr == null) {
            return 0;
        }
        double[] timePoints = this.mSpline[0].getTimePoints();
        if (iArr != null) {
            java.util.Iterator<androidx.constraintlayout.motion.widget.MotionPaths> it = this.mMotionPaths.iterator();
            int i = 0;
            while (it.hasNext()) {
                iArr[i] = it.next().mMode;
                i++;
            }
        }
        int i2 = 0;
        for (double d : timePoints) {
            this.mSpline[0].getPos(d, this.mInterpolateData);
            this.mStartMotionPath.getCenter(this.mInterpolateVariables, this.mInterpolateData, fArr, i2);
            i2 += 2;
        }
        return i2 / 2;
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00f8  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0104  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00e6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void buildPath(float[] fArr, int i) {
        androidx.constraintlayout.motion.widget.SplineSet splineSet;
        androidx.constraintlayout.motion.utils.Easing easing;
        java.util.Iterator<androidx.constraintlayout.motion.widget.MotionPaths> it;
        androidx.constraintlayout.motion.utils.CurveFit curveFit;
        int i2 = i;
        float f = 1.0f;
        float f2 = 1.0f / (i2 - 1);
        java.util.HashMap<java.lang.String, androidx.constraintlayout.motion.widget.SplineSet> hashMap = this.mAttributesMap;
        androidx.constraintlayout.motion.widget.SplineSet splineSet2 = hashMap == null ? null : hashMap.get("translationX");
        java.util.HashMap<java.lang.String, androidx.constraintlayout.motion.widget.SplineSet> hashMap2 = this.mAttributesMap;
        androidx.constraintlayout.motion.widget.SplineSet splineSet3 = hashMap2 == null ? null : hashMap2.get("translationY");
        java.util.HashMap<java.lang.String, androidx.constraintlayout.motion.widget.KeyCycleOscillator> hashMap3 = this.mCycleMap;
        androidx.constraintlayout.motion.widget.KeyCycleOscillator keyCycleOscillator = hashMap3 == null ? null : hashMap3.get("translationX");
        java.util.HashMap<java.lang.String, androidx.constraintlayout.motion.widget.KeyCycleOscillator> hashMap4 = this.mCycleMap;
        androidx.constraintlayout.motion.widget.KeyCycleOscillator keyCycleOscillator2 = hashMap4 != null ? hashMap4.get("translationY") : null;
        int i3 = 0;
        while (i3 < i2) {
            float f3 = i3 * f2;
            float f4 = this.mStaggerScale;
            float f5 = 0.0f;
            if (f4 != f) {
                float f6 = this.mStaggerOffset;
                if (f3 < f6) {
                    f3 = 0.0f;
                }
                if (f3 > f6) {
                    splineSet = splineSet2;
                    if (f3 < 1.0d) {
                        f3 = (f3 - f6) * f4;
                    }
                    double d = f3;
                    easing = this.mStartMotionPath.mKeyFrameEasing;
                    it = this.mMotionPaths.iterator();
                    float f7 = Float.NaN;
                    while (it.hasNext()) {
                        androidx.constraintlayout.motion.widget.MotionPaths next = it.next();
                        androidx.constraintlayout.motion.utils.Easing easing2 = next.mKeyFrameEasing;
                        if (easing2 != null) {
                            float f8 = next.time;
                            if (f8 < f3) {
                                f5 = f8;
                                easing = easing2;
                            } else if (java.lang.Float.isNaN(f7)) {
                                f7 = next.time;
                            }
                        }
                    }
                    if (easing != null) {
                        if (java.lang.Float.isNaN(f7)) {
                            f7 = 1.0f;
                        }
                        d = (((float) easing.get((f3 - f5) / r17)) * (f7 - f5)) + f5;
                    }
                    this.mSpline[0].getPos(d, this.mInterpolateData);
                    curveFit = this.mArcSpline;
                    if (curveFit != null) {
                        double[] dArr = this.mInterpolateData;
                        if (dArr.length > 0) {
                            curveFit.getPos(d, dArr);
                        }
                    }
                    int i4 = i3 * 2;
                    this.mStartMotionPath.getCenter(this.mInterpolateVariables, this.mInterpolateData, fArr, i4);
                    if (keyCycleOscillator == null) {
                        fArr[i4] = fArr[i4] + keyCycleOscillator.get(f3);
                    } else if (splineSet != null) {
                        splineSet2 = splineSet;
                        fArr[i4] = fArr[i4] + splineSet2.get(f3);
                        if (keyCycleOscillator2 != null) {
                            int i5 = i4 + 1;
                            fArr[i5] = fArr[i5] + keyCycleOscillator2.get(f3);
                        } else if (splineSet3 != null) {
                            int i6 = i4 + 1;
                            fArr[i6] = fArr[i6] + splineSet3.get(f3);
                        }
                        i3++;
                        i2 = i;
                        f = 1.0f;
                    }
                    splineSet2 = splineSet;
                    if (keyCycleOscillator2 != null) {
                    }
                    i3++;
                    i2 = i;
                    f = 1.0f;
                }
            }
            splineSet = splineSet2;
            double d2 = f3;
            easing = this.mStartMotionPath.mKeyFrameEasing;
            it = this.mMotionPaths.iterator();
            float f72 = Float.NaN;
            while (it.hasNext()) {
            }
            if (easing != null) {
            }
            this.mSpline[0].getPos(d2, this.mInterpolateData);
            curveFit = this.mArcSpline;
            if (curveFit != null) {
            }
            int i42 = i3 * 2;
            this.mStartMotionPath.getCenter(this.mInterpolateVariables, this.mInterpolateData, fArr, i42);
            if (keyCycleOscillator == null) {
            }
            splineSet2 = splineSet;
            if (keyCycleOscillator2 != null) {
            }
            i3++;
            i2 = i;
            f = 1.0f;
        }
    }

    public void buildRect(float f, float[] fArr, int i) {
        this.mSpline[0].getPos(getAdjustedPosition(f, null), this.mInterpolateData);
        this.mStartMotionPath.getRect(this.mInterpolateVariables, this.mInterpolateData, fArr, i);
    }

    public void buildRectangles(float[] fArr, int i) {
        float f = 1.0f / (i - 1);
        for (int i2 = 0; i2 < i; i2++) {
            this.mSpline[0].getPos(getAdjustedPosition(i2 * f, null), this.mInterpolateData);
            this.mStartMotionPath.getRect(this.mInterpolateVariables, this.mInterpolateData, fArr, i2 * 8);
        }
    }

    public int getAttributeValues(java.lang.String str, float[] fArr, int i) {
        androidx.constraintlayout.motion.widget.SplineSet splineSet = this.mAttributesMap.get(str);
        if (splineSet == null) {
            return -1;
        }
        for (int i2 = 0; i2 < fArr.length; i2++) {
            fArr[i2] = splineSet.get(i2 / (fArr.length - 1));
        }
        return fArr.length;
    }

    public void getDpDt(float f, float f2, float f3, float[] fArr) {
        double[] dArr;
        float adjustedPosition = getAdjustedPosition(f, this.mVelocity);
        androidx.constraintlayout.motion.utils.CurveFit[] curveFitArr = this.mSpline;
        int i = 0;
        if (curveFitArr == null) {
            androidx.constraintlayout.motion.widget.MotionPaths motionPaths = this.mEndMotionPath;
            float f4 = motionPaths.x;
            androidx.constraintlayout.motion.widget.MotionPaths motionPaths2 = this.mStartMotionPath;
            float f5 = f4 - motionPaths2.x;
            float f6 = motionPaths.y - motionPaths2.y;
            float f7 = (motionPaths.width - motionPaths2.width) + f5;
            float f8 = (motionPaths.height - motionPaths2.height) + f6;
            fArr[0] = (f5 * (1.0f - f2)) + (f7 * f2);
            fArr[1] = (f6 * (1.0f - f3)) + (f8 * f3);
            return;
        }
        double d = adjustedPosition;
        curveFitArr[0].getSlope(d, this.mInterpolateVelocity);
        this.mSpline[0].getPos(d, this.mInterpolateData);
        float f9 = this.mVelocity[0];
        while (true) {
            dArr = this.mInterpolateVelocity;
            if (i >= dArr.length) {
                break;
            }
            dArr[i] = dArr[i] * f9;
            i++;
        }
        androidx.constraintlayout.motion.utils.CurveFit curveFit = this.mArcSpline;
        if (curveFit == null) {
            this.mStartMotionPath.setDpDt(f2, f3, fArr, this.mInterpolateVariables, dArr, this.mInterpolateData);
            return;
        }
        double[] dArr2 = this.mInterpolateData;
        if (dArr2.length > 0) {
            curveFit.getPos(d, dArr2);
            this.mArcSpline.getSlope(d, this.mInterpolateVelocity);
            this.mStartMotionPath.setDpDt(f2, f3, fArr, this.mInterpolateVariables, this.mInterpolateVelocity, this.mInterpolateData);
        }
    }

    public int getDrawPath() {
        int i = this.mStartMotionPath.mDrawPath;
        java.util.Iterator<androidx.constraintlayout.motion.widget.MotionPaths> it = this.mMotionPaths.iterator();
        while (it.hasNext()) {
            i = java.lang.Math.max(i, it.next().mDrawPath);
        }
        return java.lang.Math.max(i, this.mEndMotionPath.mDrawPath);
    }

    public float getFinalX() {
        return this.mEndMotionPath.x;
    }

    public float getFinalY() {
        return this.mEndMotionPath.y;
    }

    public androidx.constraintlayout.motion.widget.MotionPaths getKeyFrame(int i) {
        return this.mMotionPaths.get(i);
    }

    public int getKeyFrameInfo(int i, int[] iArr) {
        float[] fArr = new float[2];
        java.util.Iterator<androidx.constraintlayout.motion.widget.Key> it = this.mKeyList.iterator();
        int i2 = 0;
        int i3 = 0;
        while (it.hasNext()) {
            androidx.constraintlayout.motion.widget.Key next = it.next();
            int i4 = next.mType;
            if (i4 == i || i != -1) {
                iArr[i3] = 0;
                int i5 = i3 + 1;
                iArr[i5] = i4;
                int i6 = i5 + 1;
                iArr[i6] = next.mFramePosition;
                this.mSpline[0].getPos(r8 / 100.0f, this.mInterpolateData);
                this.mStartMotionPath.getCenter(this.mInterpolateVariables, this.mInterpolateData, fArr, 0);
                int i7 = i6 + 1;
                iArr[i7] = java.lang.Float.floatToIntBits(fArr[0]);
                int i8 = i7 + 1;
                iArr[i8] = java.lang.Float.floatToIntBits(fArr[1]);
                if (next instanceof androidx.constraintlayout.motion.widget.KeyPosition) {
                    androidx.constraintlayout.motion.widget.KeyPosition keyPosition = (androidx.constraintlayout.motion.widget.KeyPosition) next;
                    int i9 = i8 + 1;
                    iArr[i9] = keyPosition.mPositionType;
                    int i10 = i9 + 1;
                    iArr[i10] = java.lang.Float.floatToIntBits(keyPosition.mPercentX);
                    i8 = i10 + 1;
                    iArr[i8] = java.lang.Float.floatToIntBits(keyPosition.mPercentY);
                }
                int i11 = i8 + 1;
                iArr[i3] = i11 - i3;
                i2++;
                i3 = i11;
            }
        }
        return i2;
    }

    public float getKeyFrameParameter(int i, float f, float f2) {
        androidx.constraintlayout.motion.widget.MotionPaths motionPaths = this.mEndMotionPath;
        float f3 = motionPaths.x;
        androidx.constraintlayout.motion.widget.MotionPaths motionPaths2 = this.mStartMotionPath;
        float f4 = motionPaths2.x;
        float f5 = f3 - f4;
        float f6 = motionPaths.y;
        float f7 = motionPaths2.y;
        float f8 = f6 - f7;
        float f9 = f4 + (motionPaths2.width / 2.0f);
        float f10 = f7 + (motionPaths2.height / 2.0f);
        float hypot = (float) java.lang.Math.hypot(f5, f8);
        if (hypot < 1.0E-7d) {
            return Float.NaN;
        }
        float f11 = f - f9;
        float f12 = f2 - f10;
        if (((float) java.lang.Math.hypot(f11, f12)) == 0.0f) {
            return 0.0f;
        }
        float f13 = (f11 * f5) + (f12 * f8);
        if (i == 0) {
            return f13 / hypot;
        }
        if (i == 1) {
            return (float) java.lang.Math.sqrt((hypot * hypot) - (f13 * f13));
        }
        if (i == 2) {
            return f11 / f5;
        }
        if (i == 3) {
            return f12 / f5;
        }
        if (i == 4) {
            return f11 / f8;
        }
        if (i != 5) {
            return 0.0f;
        }
        return f12 / f8;
    }

    public androidx.constraintlayout.motion.widget.KeyPositionBase getPositionKeyframe(int i, int i2, float f, float f2) {
        android.graphics.RectF rectF = new android.graphics.RectF();
        androidx.constraintlayout.motion.widget.MotionPaths motionPaths = this.mStartMotionPath;
        float f3 = motionPaths.x;
        rectF.left = f3;
        float f4 = motionPaths.y;
        rectF.top = f4;
        rectF.right = f3 + motionPaths.width;
        rectF.bottom = f4 + motionPaths.height;
        android.graphics.RectF rectF2 = new android.graphics.RectF();
        androidx.constraintlayout.motion.widget.MotionPaths motionPaths2 = this.mEndMotionPath;
        float f5 = motionPaths2.x;
        rectF2.left = f5;
        float f6 = motionPaths2.y;
        rectF2.top = f6;
        rectF2.right = f5 + motionPaths2.width;
        rectF2.bottom = f6 + motionPaths2.height;
        java.util.Iterator<androidx.constraintlayout.motion.widget.Key> it = this.mKeyList.iterator();
        while (it.hasNext()) {
            androidx.constraintlayout.motion.widget.Key next = it.next();
            if (next instanceof androidx.constraintlayout.motion.widget.KeyPositionBase) {
                androidx.constraintlayout.motion.widget.KeyPositionBase keyPositionBase = (androidx.constraintlayout.motion.widget.KeyPositionBase) next;
                if (keyPositionBase.intersects(i, i2, rectF, rectF2, f, f2)) {
                    return keyPositionBase;
                }
            }
        }
        return null;
    }

    public void getPostLayoutDvDp(float f, int i, int i2, float f2, float f3, float[] fArr) {
        float adjustedPosition = getAdjustedPosition(f, this.mVelocity);
        java.util.HashMap<java.lang.String, androidx.constraintlayout.motion.widget.SplineSet> hashMap = this.mAttributesMap;
        androidx.constraintlayout.motion.widget.SplineSet splineSet = hashMap == null ? null : hashMap.get("translationX");
        java.util.HashMap<java.lang.String, androidx.constraintlayout.motion.widget.SplineSet> hashMap2 = this.mAttributesMap;
        androidx.constraintlayout.motion.widget.SplineSet splineSet2 = hashMap2 == null ? null : hashMap2.get("translationY");
        java.util.HashMap<java.lang.String, androidx.constraintlayout.motion.widget.SplineSet> hashMap3 = this.mAttributesMap;
        androidx.constraintlayout.motion.widget.SplineSet splineSet3 = hashMap3 == null ? null : hashMap3.get("rotation");
        java.util.HashMap<java.lang.String, androidx.constraintlayout.motion.widget.SplineSet> hashMap4 = this.mAttributesMap;
        androidx.constraintlayout.motion.widget.SplineSet splineSet4 = hashMap4 == null ? null : hashMap4.get("scaleX");
        java.util.HashMap<java.lang.String, androidx.constraintlayout.motion.widget.SplineSet> hashMap5 = this.mAttributesMap;
        androidx.constraintlayout.motion.widget.SplineSet splineSet5 = hashMap5 == null ? null : hashMap5.get("scaleY");
        java.util.HashMap<java.lang.String, androidx.constraintlayout.motion.widget.KeyCycleOscillator> hashMap6 = this.mCycleMap;
        androidx.constraintlayout.motion.widget.KeyCycleOscillator keyCycleOscillator = hashMap6 == null ? null : hashMap6.get("translationX");
        java.util.HashMap<java.lang.String, androidx.constraintlayout.motion.widget.KeyCycleOscillator> hashMap7 = this.mCycleMap;
        androidx.constraintlayout.motion.widget.KeyCycleOscillator keyCycleOscillator2 = hashMap7 == null ? null : hashMap7.get("translationY");
        java.util.HashMap<java.lang.String, androidx.constraintlayout.motion.widget.KeyCycleOscillator> hashMap8 = this.mCycleMap;
        androidx.constraintlayout.motion.widget.KeyCycleOscillator keyCycleOscillator3 = hashMap8 == null ? null : hashMap8.get("rotation");
        java.util.HashMap<java.lang.String, androidx.constraintlayout.motion.widget.KeyCycleOscillator> hashMap9 = this.mCycleMap;
        androidx.constraintlayout.motion.widget.KeyCycleOscillator keyCycleOscillator4 = hashMap9 == null ? null : hashMap9.get("scaleX");
        java.util.HashMap<java.lang.String, androidx.constraintlayout.motion.widget.KeyCycleOscillator> hashMap10 = this.mCycleMap;
        androidx.constraintlayout.motion.widget.KeyCycleOscillator keyCycleOscillator5 = hashMap10 != null ? hashMap10.get("scaleY") : null;
        androidx.constraintlayout.motion.utils.VelocityMatrix velocityMatrix = new androidx.constraintlayout.motion.utils.VelocityMatrix();
        velocityMatrix.clear();
        velocityMatrix.setRotationVelocity(splineSet3, adjustedPosition);
        velocityMatrix.setTranslationVelocity(splineSet, splineSet2, adjustedPosition);
        velocityMatrix.setScaleVelocity(splineSet4, splineSet5, adjustedPosition);
        velocityMatrix.setRotationVelocity(keyCycleOscillator3, adjustedPosition);
        velocityMatrix.setTranslationVelocity(keyCycleOscillator, keyCycleOscillator2, adjustedPosition);
        velocityMatrix.setScaleVelocity(keyCycleOscillator4, keyCycleOscillator5, adjustedPosition);
        androidx.constraintlayout.motion.utils.CurveFit curveFit = this.mArcSpline;
        if (curveFit != null) {
            double[] dArr = this.mInterpolateData;
            if (dArr.length > 0) {
                double d = adjustedPosition;
                curveFit.getPos(d, dArr);
                this.mArcSpline.getSlope(d, this.mInterpolateVelocity);
                this.mStartMotionPath.setDpDt(f2, f3, fArr, this.mInterpolateVariables, this.mInterpolateVelocity, this.mInterpolateData);
            }
            velocityMatrix.applyTransform(f2, f3, i, i2, fArr);
            return;
        }
        int i3 = 0;
        if (this.mSpline == null) {
            androidx.constraintlayout.motion.widget.MotionPaths motionPaths = this.mEndMotionPath;
            float f4 = motionPaths.x;
            androidx.constraintlayout.motion.widget.MotionPaths motionPaths2 = this.mStartMotionPath;
            float f5 = f4 - motionPaths2.x;
            androidx.constraintlayout.motion.widget.KeyCycleOscillator keyCycleOscillator6 = keyCycleOscillator5;
            float f6 = motionPaths.y - motionPaths2.y;
            androidx.constraintlayout.motion.widget.KeyCycleOscillator keyCycleOscillator7 = keyCycleOscillator4;
            float f7 = (motionPaths.width - motionPaths2.width) + f5;
            float f8 = (motionPaths.height - motionPaths2.height) + f6;
            fArr[0] = (f5 * (1.0f - f2)) + (f7 * f2);
            fArr[1] = (f6 * (1.0f - f3)) + (f8 * f3);
            velocityMatrix.clear();
            velocityMatrix.setRotationVelocity(splineSet3, adjustedPosition);
            velocityMatrix.setTranslationVelocity(splineSet, splineSet2, adjustedPosition);
            velocityMatrix.setScaleVelocity(splineSet4, splineSet5, adjustedPosition);
            velocityMatrix.setRotationVelocity(keyCycleOscillator3, adjustedPosition);
            velocityMatrix.setTranslationVelocity(keyCycleOscillator, keyCycleOscillator2, adjustedPosition);
            velocityMatrix.setScaleVelocity(keyCycleOscillator7, keyCycleOscillator6, adjustedPosition);
            velocityMatrix.applyTransform(f2, f3, i, i2, fArr);
            return;
        }
        double adjustedPosition2 = getAdjustedPosition(adjustedPosition, this.mVelocity);
        this.mSpline[0].getSlope(adjustedPosition2, this.mInterpolateVelocity);
        this.mSpline[0].getPos(adjustedPosition2, this.mInterpolateData);
        float f9 = this.mVelocity[0];
        while (true) {
            double[] dArr2 = this.mInterpolateVelocity;
            if (i3 >= dArr2.length) {
                this.mStartMotionPath.setDpDt(f2, f3, fArr, this.mInterpolateVariables, dArr2, this.mInterpolateData);
                velocityMatrix.applyTransform(f2, f3, i, i2, fArr);
                return;
            } else {
                dArr2[i3] = dArr2[i3] * f9;
                i3++;
            }
        }
    }

    public float getStartX() {
        return this.mStartMotionPath.x;
    }

    public float getStartY() {
        return this.mStartMotionPath.y;
    }

    public int getkeyFramePositions(int[] iArr, float[] fArr) {
        java.util.Iterator<androidx.constraintlayout.motion.widget.Key> it = this.mKeyList.iterator();
        int i = 0;
        int i2 = 0;
        while (it.hasNext()) {
            androidx.constraintlayout.motion.widget.Key next = it.next();
            iArr[i] = (next.mType * 1000) + next.mFramePosition;
            this.mSpline[0].getPos(r6 / 100.0f, this.mInterpolateData);
            this.mStartMotionPath.getCenter(this.mInterpolateVariables, this.mInterpolateData, fArr, i2);
            i2 += 2;
            i++;
        }
        return i;
    }

    public boolean interpolate(android.view.View view, float f, long j, androidx.constraintlayout.motion.widget.KeyCache keyCache) {
        androidx.constraintlayout.motion.widget.TimeCycleSplineSet.PathRotate pathRotate;
        boolean z;
        double d;
        float adjustedPosition = getAdjustedPosition(f, null);
        java.util.HashMap<java.lang.String, androidx.constraintlayout.motion.widget.SplineSet> hashMap = this.mAttributesMap;
        if (hashMap != null) {
            java.util.Iterator<androidx.constraintlayout.motion.widget.SplineSet> it = hashMap.values().iterator();
            while (it.hasNext()) {
                it.next().setProperty(view, adjustedPosition);
            }
        }
        java.util.HashMap<java.lang.String, androidx.constraintlayout.motion.widget.TimeCycleSplineSet> hashMap2 = this.mTimeCycleAttributesMap;
        if (hashMap2 != null) {
            pathRotate = null;
            boolean z2 = false;
            for (androidx.constraintlayout.motion.widget.TimeCycleSplineSet timeCycleSplineSet : hashMap2.values()) {
                if (timeCycleSplineSet instanceof androidx.constraintlayout.motion.widget.TimeCycleSplineSet.PathRotate) {
                    pathRotate = (androidx.constraintlayout.motion.widget.TimeCycleSplineSet.PathRotate) timeCycleSplineSet;
                } else {
                    z2 |= timeCycleSplineSet.setProperty(view, adjustedPosition, j, keyCache);
                }
            }
            z = z2;
        } else {
            pathRotate = null;
            z = false;
        }
        androidx.constraintlayout.motion.utils.CurveFit[] curveFitArr = this.mSpline;
        if (curveFitArr != null) {
            double d2 = adjustedPosition;
            curveFitArr[0].getPos(d2, this.mInterpolateData);
            this.mSpline[0].getSlope(d2, this.mInterpolateVelocity);
            androidx.constraintlayout.motion.utils.CurveFit curveFit = this.mArcSpline;
            if (curveFit != null) {
                double[] dArr = this.mInterpolateData;
                if (dArr.length > 0) {
                    curveFit.getPos(d2, dArr);
                    this.mArcSpline.getSlope(d2, this.mInterpolateVelocity);
                }
            }
            this.mStartMotionPath.setView(view, this.mInterpolateVariables, this.mInterpolateData, this.mInterpolateVelocity, null);
            java.util.HashMap<java.lang.String, androidx.constraintlayout.motion.widget.SplineSet> hashMap3 = this.mAttributesMap;
            if (hashMap3 != null) {
                for (androidx.constraintlayout.motion.widget.SplineSet splineSet : hashMap3.values()) {
                    if (splineSet instanceof androidx.constraintlayout.motion.widget.SplineSet.PathRotate) {
                        double[] dArr2 = this.mInterpolateVelocity;
                        ((androidx.constraintlayout.motion.widget.SplineSet.PathRotate) splineSet).setPathRotate(view, adjustedPosition, dArr2[0], dArr2[1]);
                    }
                }
            }
            if (pathRotate != null) {
                double[] dArr3 = this.mInterpolateVelocity;
                d = d2;
                z = pathRotate.setPathRotate(view, keyCache, adjustedPosition, j, dArr3[0], dArr3[1]) | z;
            } else {
                d = d2;
            }
            int i = 1;
            while (true) {
                androidx.constraintlayout.motion.utils.CurveFit[] curveFitArr2 = this.mSpline;
                if (i >= curveFitArr2.length) {
                    break;
                }
                curveFitArr2[i].getPos(d, this.mValuesBuff);
                this.mStartMotionPath.attributes.get(this.mAttributeNames[i - 1]).setInterpolatedValue(view, this.mValuesBuff);
                i++;
            }
            androidx.constraintlayout.motion.widget.MotionConstrainedPoint motionConstrainedPoint = this.mStartPoint;
            if (motionConstrainedPoint.mVisibilityMode == 0) {
                if (adjustedPosition <= 0.0f) {
                    view.setVisibility(motionConstrainedPoint.visibility);
                } else if (adjustedPosition >= 1.0f) {
                    view.setVisibility(this.mEndPoint.visibility);
                } else if (this.mEndPoint.visibility != motionConstrainedPoint.visibility) {
                    view.setVisibility(0);
                }
            }
            if (this.mKeyTriggers != null) {
                int i2 = 0;
                while (true) {
                    androidx.constraintlayout.motion.widget.KeyTrigger[] keyTriggerArr = this.mKeyTriggers;
                    if (i2 >= keyTriggerArr.length) {
                        break;
                    }
                    keyTriggerArr[i2].conditionallyFire(adjustedPosition, view);
                    i2++;
                }
            }
        } else {
            androidx.constraintlayout.motion.widget.MotionPaths motionPaths = this.mStartMotionPath;
            float f2 = motionPaths.x;
            androidx.constraintlayout.motion.widget.MotionPaths motionPaths2 = this.mEndMotionPath;
            float f3 = f2 + ((motionPaths2.x - f2) * adjustedPosition);
            float f4 = motionPaths.y;
            float f5 = f4 + ((motionPaths2.y - f4) * adjustedPosition);
            float f6 = motionPaths.width;
            float f7 = motionPaths2.width;
            float f8 = motionPaths.height;
            float f9 = motionPaths2.height;
            float f10 = f3 + 0.5f;
            int i3 = (int) f10;
            float f11 = f5 + 0.5f;
            int i4 = (int) f11;
            int i5 = (int) (f10 + ((f7 - f6) * adjustedPosition) + f6);
            int i6 = (int) (f11 + ((f9 - f8) * adjustedPosition) + f8);
            int i7 = i5 - i3;
            int i8 = i6 - i4;
            if (f7 != f6 || f9 != f8) {
                view.measure(android.view.View.MeasureSpec.makeMeasureSpec(i7, 1073741824), android.view.View.MeasureSpec.makeMeasureSpec(i8, 1073741824));
            }
            view.layout(i3, i4, i5, i6);
        }
        java.util.HashMap<java.lang.String, androidx.constraintlayout.motion.widget.KeyCycleOscillator> hashMap4 = this.mCycleMap;
        if (hashMap4 != null) {
            for (androidx.constraintlayout.motion.widget.KeyCycleOscillator keyCycleOscillator : hashMap4.values()) {
                if (keyCycleOscillator instanceof androidx.constraintlayout.motion.widget.KeyCycleOscillator.PathRotateSet) {
                    double[] dArr4 = this.mInterpolateVelocity;
                    ((androidx.constraintlayout.motion.widget.KeyCycleOscillator.PathRotateSet) keyCycleOscillator).setPathRotate(view, adjustedPosition, dArr4[0], dArr4[1]);
                } else {
                    keyCycleOscillator.setProperty(view, adjustedPosition);
                }
            }
        }
        return z;
    }

    public java.lang.String name() {
        return this.mView.getContext().getResources().getResourceEntryName(this.mView.getId());
    }

    public void positionKeyframe(android.view.View view, androidx.constraintlayout.motion.widget.KeyPositionBase keyPositionBase, float f, float f2, java.lang.String[] strArr, float[] fArr) {
        android.graphics.RectF rectF = new android.graphics.RectF();
        androidx.constraintlayout.motion.widget.MotionPaths motionPaths = this.mStartMotionPath;
        float f3 = motionPaths.x;
        rectF.left = f3;
        float f4 = motionPaths.y;
        rectF.top = f4;
        rectF.right = f3 + motionPaths.width;
        rectF.bottom = f4 + motionPaths.height;
        android.graphics.RectF rectF2 = new android.graphics.RectF();
        androidx.constraintlayout.motion.widget.MotionPaths motionPaths2 = this.mEndMotionPath;
        float f5 = motionPaths2.x;
        rectF2.left = f5;
        float f6 = motionPaths2.y;
        rectF2.top = f6;
        rectF2.right = f5 + motionPaths2.width;
        rectF2.bottom = f6 + motionPaths2.height;
        keyPositionBase.positionAttributes(view, rectF, rectF2, f, f2, strArr, fArr);
    }

    public void setDrawPath(int i) {
        this.mStartMotionPath.mDrawPath = i;
    }

    public void setEndState(androidx.constraintlayout.solver.widgets.ConstraintWidget constraintWidget, androidx.constraintlayout.widget.ConstraintSet constraintSet) {
        androidx.constraintlayout.motion.widget.MotionPaths motionPaths = this.mEndMotionPath;
        motionPaths.time = 1.0f;
        motionPaths.position = 1.0f;
        readView(motionPaths);
        this.mEndMotionPath.setBounds(constraintWidget.getX(), constraintWidget.getY(), constraintWidget.getWidth(), constraintWidget.getHeight());
        this.mEndMotionPath.applyParameters(constraintSet.getParameters(this.mId));
        this.mEndPoint.setState(constraintWidget, constraintSet, this.mId);
    }

    public void setPathMotionArc(int i) {
        this.mPathMotionArc = i;
    }

    public void setStartCurrentState(android.view.View view) {
        androidx.constraintlayout.motion.widget.MotionPaths motionPaths = this.mStartMotionPath;
        motionPaths.time = 0.0f;
        motionPaths.position = 0.0f;
        motionPaths.setBounds(view.getX(), view.getY(), view.getWidth(), view.getHeight());
        this.mStartPoint.setState(view);
    }

    public void setStartState(androidx.constraintlayout.solver.widgets.ConstraintWidget constraintWidget, androidx.constraintlayout.widget.ConstraintSet constraintSet) {
        androidx.constraintlayout.motion.widget.MotionPaths motionPaths = this.mStartMotionPath;
        motionPaths.time = 0.0f;
        motionPaths.position = 0.0f;
        readView(motionPaths);
        this.mStartMotionPath.setBounds(constraintWidget.getX(), constraintWidget.getY(), constraintWidget.getWidth(), constraintWidget.getHeight());
        androidx.constraintlayout.widget.ConstraintSet.Constraint parameters = constraintSet.getParameters(this.mId);
        this.mStartMotionPath.applyParameters(parameters);
        this.mMotionStagger = parameters.motion.mMotionStagger;
        this.mStartPoint.setState(constraintWidget, constraintSet, this.mId);
    }

    public void setView(android.view.View view) {
        this.mView = view;
        this.mId = view.getId();
        android.view.ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof androidx.constraintlayout.widget.ConstraintLayout.LayoutParams) {
            this.mConstraintTag = ((androidx.constraintlayout.widget.ConstraintLayout.LayoutParams) layoutParams).getConstraintTag();
        }
    }

    public void setup(int i, int i2, float f, long j) {
        java.util.ArrayList arrayList;
        java.lang.String[] strArr;
        androidx.constraintlayout.motion.widget.TimeCycleSplineSet makeSpline;
        androidx.constraintlayout.widget.ConstraintAttribute constraintAttribute;
        androidx.constraintlayout.motion.widget.SplineSet makeSpline2;
        androidx.constraintlayout.widget.ConstraintAttribute constraintAttribute2;
        new java.util.HashSet();
        java.util.HashSet<java.lang.String> hashSet = new java.util.HashSet<>();
        java.util.HashSet<java.lang.String> hashSet2 = new java.util.HashSet<>();
        java.util.HashSet<java.lang.String> hashSet3 = new java.util.HashSet<>();
        java.util.HashMap<java.lang.String, java.lang.Integer> hashMap = new java.util.HashMap<>();
        int i3 = this.mPathMotionArc;
        if (i3 != androidx.constraintlayout.motion.widget.Key.UNSET) {
            this.mStartMotionPath.mPathMotionArc = i3;
        }
        this.mStartPoint.different(this.mEndPoint, hashSet2);
        java.util.ArrayList<androidx.constraintlayout.motion.widget.Key> arrayList2 = this.mKeyList;
        if (arrayList2 != null) {
            java.util.Iterator<androidx.constraintlayout.motion.widget.Key> it = arrayList2.iterator();
            arrayList = null;
            while (it.hasNext()) {
                androidx.constraintlayout.motion.widget.Key next = it.next();
                if (next instanceof androidx.constraintlayout.motion.widget.KeyPosition) {
                    androidx.constraintlayout.motion.widget.KeyPosition keyPosition = (androidx.constraintlayout.motion.widget.KeyPosition) next;
                    insertKey(new androidx.constraintlayout.motion.widget.MotionPaths(i, i2, keyPosition, this.mStartMotionPath, this.mEndMotionPath));
                    int i4 = keyPosition.mCurveFit;
                    if (i4 != androidx.constraintlayout.motion.widget.Key.UNSET) {
                        this.mCurveFitType = i4;
                    }
                } else if (next instanceof androidx.constraintlayout.motion.widget.KeyCycle) {
                    next.getAttributeNames(hashSet3);
                } else if (next instanceof androidx.constraintlayout.motion.widget.KeyTimeCycle) {
                    next.getAttributeNames(hashSet);
                } else if (next instanceof androidx.constraintlayout.motion.widget.KeyTrigger) {
                    if (arrayList == null) {
                        arrayList = new java.util.ArrayList();
                    }
                    arrayList.add((androidx.constraintlayout.motion.widget.KeyTrigger) next);
                } else {
                    next.setInterpolation(hashMap);
                    next.getAttributeNames(hashSet2);
                }
            }
        } else {
            arrayList = null;
        }
        char c = 0;
        if (arrayList != null) {
            this.mKeyTriggers = (androidx.constraintlayout.motion.widget.KeyTrigger[]) arrayList.toArray(new androidx.constraintlayout.motion.widget.KeyTrigger[0]);
        }
        char c2 = 1;
        if (!hashSet2.isEmpty()) {
            this.mAttributesMap = new java.util.HashMap<>();
            java.util.Iterator<java.lang.String> it2 = hashSet2.iterator();
            while (it2.hasNext()) {
                java.lang.String next2 = it2.next();
                if (next2.startsWith("CUSTOM,")) {
                    android.util.SparseArray sparseArray = new android.util.SparseArray();
                    java.lang.String str = next2.split(",")[1];
                    java.util.Iterator<androidx.constraintlayout.motion.widget.Key> it3 = this.mKeyList.iterator();
                    while (it3.hasNext()) {
                        androidx.constraintlayout.motion.widget.Key next3 = it3.next();
                        java.util.HashMap<java.lang.String, androidx.constraintlayout.widget.ConstraintAttribute> hashMap2 = next3.mCustomConstraints;
                        if (hashMap2 != null && (constraintAttribute2 = hashMap2.get(str)) != null) {
                            sparseArray.append(next3.mFramePosition, constraintAttribute2);
                        }
                    }
                    makeSpline2 = androidx.constraintlayout.motion.widget.SplineSet.makeCustomSpline(next2, sparseArray);
                } else {
                    makeSpline2 = androidx.constraintlayout.motion.widget.SplineSet.makeSpline(next2);
                }
                if (makeSpline2 != null) {
                    makeSpline2.setType(next2);
                    this.mAttributesMap.put(next2, makeSpline2);
                }
            }
            java.util.ArrayList<androidx.constraintlayout.motion.widget.Key> arrayList3 = this.mKeyList;
            if (arrayList3 != null) {
                java.util.Iterator<androidx.constraintlayout.motion.widget.Key> it4 = arrayList3.iterator();
                while (it4.hasNext()) {
                    androidx.constraintlayout.motion.widget.Key next4 = it4.next();
                    if (next4 instanceof androidx.constraintlayout.motion.widget.KeyAttributes) {
                        next4.addValues(this.mAttributesMap);
                    }
                }
            }
            this.mStartPoint.addValues(this.mAttributesMap, 0);
            this.mEndPoint.addValues(this.mAttributesMap, 100);
            for (java.lang.String str2 : this.mAttributesMap.keySet()) {
                this.mAttributesMap.get(str2).setup(hashMap.containsKey(str2) ? hashMap.get(str2).intValue() : 0);
            }
        }
        if (!hashSet.isEmpty()) {
            if (this.mTimeCycleAttributesMap == null) {
                this.mTimeCycleAttributesMap = new java.util.HashMap<>();
            }
            java.util.Iterator<java.lang.String> it5 = hashSet.iterator();
            while (it5.hasNext()) {
                java.lang.String next5 = it5.next();
                if (!this.mTimeCycleAttributesMap.containsKey(next5)) {
                    if (next5.startsWith("CUSTOM,")) {
                        android.util.SparseArray sparseArray2 = new android.util.SparseArray();
                        java.lang.String str3 = next5.split(",")[1];
                        java.util.Iterator<androidx.constraintlayout.motion.widget.Key> it6 = this.mKeyList.iterator();
                        while (it6.hasNext()) {
                            androidx.constraintlayout.motion.widget.Key next6 = it6.next();
                            java.util.HashMap<java.lang.String, androidx.constraintlayout.widget.ConstraintAttribute> hashMap3 = next6.mCustomConstraints;
                            if (hashMap3 != null && (constraintAttribute = hashMap3.get(str3)) != null) {
                                sparseArray2.append(next6.mFramePosition, constraintAttribute);
                            }
                        }
                        makeSpline = androidx.constraintlayout.motion.widget.TimeCycleSplineSet.makeCustomSpline(next5, sparseArray2);
                    } else {
                        makeSpline = androidx.constraintlayout.motion.widget.TimeCycleSplineSet.makeSpline(next5, j);
                    }
                    if (makeSpline != null) {
                        makeSpline.setType(next5);
                        this.mTimeCycleAttributesMap.put(next5, makeSpline);
                    }
                }
            }
            java.util.ArrayList<androidx.constraintlayout.motion.widget.Key> arrayList4 = this.mKeyList;
            if (arrayList4 != null) {
                java.util.Iterator<androidx.constraintlayout.motion.widget.Key> it7 = arrayList4.iterator();
                while (it7.hasNext()) {
                    androidx.constraintlayout.motion.widget.Key next7 = it7.next();
                    if (next7 instanceof androidx.constraintlayout.motion.widget.KeyTimeCycle) {
                        ((androidx.constraintlayout.motion.widget.KeyTimeCycle) next7).addTimeValues(this.mTimeCycleAttributesMap);
                    }
                }
            }
            for (java.lang.String str4 : this.mTimeCycleAttributesMap.keySet()) {
                this.mTimeCycleAttributesMap.get(str4).setup(hashMap.containsKey(str4) ? hashMap.get(str4).intValue() : 0);
            }
        }
        int i5 = 2;
        int size = this.mMotionPaths.size() + 2;
        androidx.constraintlayout.motion.widget.MotionPaths[] motionPathsArr = new androidx.constraintlayout.motion.widget.MotionPaths[size];
        motionPathsArr[0] = this.mStartMotionPath;
        motionPathsArr[size - 1] = this.mEndMotionPath;
        if (this.mMotionPaths.size() > 0 && this.mCurveFitType == -1) {
            this.mCurveFitType = 0;
        }
        java.util.Iterator<androidx.constraintlayout.motion.widget.MotionPaths> it8 = this.mMotionPaths.iterator();
        int i6 = 1;
        while (it8.hasNext()) {
            motionPathsArr[i6] = it8.next();
            i6++;
        }
        java.util.HashSet hashSet4 = new java.util.HashSet();
        for (java.lang.String str5 : this.mEndMotionPath.attributes.keySet()) {
            if (this.mStartMotionPath.attributes.containsKey(str5)) {
                if (!hashSet2.contains("CUSTOM," + str5)) {
                    hashSet4.add(str5);
                }
            }
        }
        java.lang.String[] strArr2 = (java.lang.String[]) hashSet4.toArray(new java.lang.String[0]);
        this.mAttributeNames = strArr2;
        this.mAttributeInterpCount = new int[strArr2.length];
        int i7 = 0;
        while (true) {
            strArr = this.mAttributeNames;
            if (i7 >= strArr.length) {
                break;
            }
            java.lang.String str6 = strArr[i7];
            this.mAttributeInterpCount[i7] = 0;
            int i8 = 0;
            while (true) {
                if (i8 >= size) {
                    break;
                }
                if (motionPathsArr[i8].attributes.containsKey(str6)) {
                    int[] iArr = this.mAttributeInterpCount;
                    iArr[i7] = iArr[i7] + motionPathsArr[i8].attributes.get(str6).noOfInterpValues();
                    break;
                }
                i8++;
            }
            i7++;
        }
        boolean z = motionPathsArr[0].mPathMotionArc != androidx.constraintlayout.motion.widget.Key.UNSET;
        int length = 18 + strArr.length;
        boolean[] zArr = new boolean[length];
        for (int i9 = 1; i9 < size; i9++) {
            motionPathsArr[i9].different(motionPathsArr[i9 - 1], zArr, this.mAttributeNames, z);
        }
        int i10 = 0;
        for (int i11 = 1; i11 < length; i11++) {
            if (zArr[i11]) {
                i10++;
            }
        }
        int[] iArr2 = new int[i10];
        this.mInterpolateVariables = iArr2;
        this.mInterpolateData = new double[iArr2.length];
        this.mInterpolateVelocity = new double[iArr2.length];
        int i12 = 0;
        for (int i13 = 1; i13 < length; i13++) {
            if (zArr[i13]) {
                this.mInterpolateVariables[i12] = i13;
                i12++;
            }
        }
        double[][] dArr = (double[][]) java.lang.reflect.Array.newInstance((java.lang.Class<?>) java.lang.Double.TYPE, size, this.mInterpolateVariables.length);
        double[] dArr2 = new double[size];
        for (int i14 = 0; i14 < size; i14++) {
            motionPathsArr[i14].fillStandard(dArr[i14], this.mInterpolateVariables);
            dArr2[i14] = motionPathsArr[i14].time;
        }
        int i15 = 0;
        while (true) {
            int[] iArr3 = this.mInterpolateVariables;
            if (i15 >= iArr3.length) {
                break;
            }
            if (iArr3[i15] < androidx.constraintlayout.motion.widget.MotionPaths.names.length) {
                java.lang.String str7 = androidx.constraintlayout.motion.widget.MotionPaths.names[this.mInterpolateVariables[i15]] + " [";
                for (int i16 = 0; i16 < size; i16++) {
                    str7 = str7 + dArr[i16][i15];
                }
            }
            i15++;
        }
        this.mSpline = new androidx.constraintlayout.motion.utils.CurveFit[this.mAttributeNames.length + 1];
        int i17 = 0;
        while (true) {
            java.lang.String[] strArr3 = this.mAttributeNames;
            if (i17 >= strArr3.length) {
                break;
            }
            java.lang.String str8 = strArr3[i17];
            int i18 = 0;
            double[] dArr3 = null;
            int i19 = 0;
            double[][] dArr4 = null;
            while (i18 < size) {
                if (motionPathsArr[i18].hasCustomData(str8)) {
                    if (dArr4 == null) {
                        dArr3 = new double[size];
                        int[] iArr4 = new int[i5];
                        iArr4[c2] = motionPathsArr[i18].getCustomDataCount(str8);
                        iArr4[c] = size;
                        dArr4 = (double[][]) java.lang.reflect.Array.newInstance((java.lang.Class<?>) java.lang.Double.TYPE, iArr4);
                    }
                    androidx.constraintlayout.motion.widget.MotionPaths motionPaths = motionPathsArr[i18];
                    dArr3[i19] = motionPaths.time;
                    motionPaths.getCustomData(str8, dArr4[i19], 0);
                    i19++;
                }
                i18++;
                i5 = 2;
                c = 0;
                c2 = 1;
            }
            i17++;
            this.mSpline[i17] = androidx.constraintlayout.motion.utils.CurveFit.get(this.mCurveFitType, java.util.Arrays.copyOf(dArr3, i19), (double[][]) java.util.Arrays.copyOf(dArr4, i19));
            i5 = 2;
            c = 0;
            c2 = 1;
        }
        this.mSpline[0] = androidx.constraintlayout.motion.utils.CurveFit.get(this.mCurveFitType, dArr2, dArr);
        if (motionPathsArr[0].mPathMotionArc != androidx.constraintlayout.motion.widget.Key.UNSET) {
            int[] iArr5 = new int[size];
            double[] dArr5 = new double[size];
            double[][] dArr6 = (double[][]) java.lang.reflect.Array.newInstance((java.lang.Class<?>) java.lang.Double.TYPE, size, 2);
            for (int i20 = 0; i20 < size; i20++) {
                iArr5[i20] = motionPathsArr[i20].mPathMotionArc;
                dArr5[i20] = r8.time;
                double[] dArr7 = dArr6[i20];
                dArr7[0] = r8.x;
                dArr7[1] = r8.y;
            }
            this.mArcSpline = androidx.constraintlayout.motion.utils.CurveFit.getArc(iArr5, dArr5, dArr6);
        }
        this.mCycleMap = new java.util.HashMap<>();
        if (this.mKeyList != null) {
            java.util.Iterator<java.lang.String> it9 = hashSet3.iterator();
            float f2 = Float.NaN;
            while (it9.hasNext()) {
                java.lang.String next8 = it9.next();
                androidx.constraintlayout.motion.widget.KeyCycleOscillator makeSpline3 = androidx.constraintlayout.motion.widget.KeyCycleOscillator.makeSpline(next8);
                if (makeSpline3 != null) {
                    if (makeSpline3.variesByPath() && java.lang.Float.isNaN(f2)) {
                        f2 = getPreCycleDistance();
                    }
                    makeSpline3.setType(next8);
                    this.mCycleMap.put(next8, makeSpline3);
                }
            }
            java.util.Iterator<androidx.constraintlayout.motion.widget.Key> it10 = this.mKeyList.iterator();
            while (it10.hasNext()) {
                androidx.constraintlayout.motion.widget.Key next9 = it10.next();
                if (next9 instanceof androidx.constraintlayout.motion.widget.KeyCycle) {
                    ((androidx.constraintlayout.motion.widget.KeyCycle) next9).addCycleValues(this.mCycleMap);
                }
            }
            java.util.Iterator<androidx.constraintlayout.motion.widget.KeyCycleOscillator> it11 = this.mCycleMap.values().iterator();
            while (it11.hasNext()) {
                it11.next().setup(f2);
            }
        }
    }

    public java.lang.String toString() {
        return " start: x: " + this.mStartMotionPath.x + " y: " + this.mStartMotionPath.y + " end: x: " + this.mEndMotionPath.x + " y: " + this.mEndMotionPath.y;
    }
}
