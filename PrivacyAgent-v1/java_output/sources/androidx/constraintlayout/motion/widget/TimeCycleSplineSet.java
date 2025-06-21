package androidx.constraintlayout.motion.widget;

/* loaded from: classes.dex */
public abstract class TimeCycleSplineSet {
    private static final int CURVE_OFFSET = 2;
    private static final int CURVE_PERIOD = 1;
    private static final int CURVE_VALUE = 0;
    private static final java.lang.String TAG = "SplineSet";
    private static float VAL_2PI = 6.2831855f;
    private int count;
    long last_time;
    protected androidx.constraintlayout.motion.utils.CurveFit mCurveFit;
    private java.lang.String mType;
    protected int mWaveShape = 0;
    protected int[] mTimePoints = new int[10];
    protected float[][] mValues = (float[][]) java.lang.reflect.Array.newInstance((java.lang.Class<?>) java.lang.Float.TYPE, 10, 3);
    private float[] mCache = new float[3];
    protected boolean mContinue = false;
    float last_cycle = Float.NaN;

    public static class AlphaSet extends androidx.constraintlayout.motion.widget.TimeCycleSplineSet {
        @Override // androidx.constraintlayout.motion.widget.TimeCycleSplineSet
        public boolean setProperty(android.view.View view, float f, long j, androidx.constraintlayout.motion.widget.KeyCache keyCache) {
            view.setAlpha(get(f, j, view, keyCache));
            return this.mContinue;
        }
    }

    public static class CustomSet extends androidx.constraintlayout.motion.widget.TimeCycleSplineSet {
        java.lang.String mAttributeName;
        float[] mCache;
        android.util.SparseArray<androidx.constraintlayout.widget.ConstraintAttribute> mConstraintAttributeList;
        float[] mTempValues;
        android.util.SparseArray<float[]> mWaveProperties = new android.util.SparseArray<>();

        public CustomSet(java.lang.String str, android.util.SparseArray<androidx.constraintlayout.widget.ConstraintAttribute> sparseArray) {
            this.mAttributeName = str.split(",")[1];
            this.mConstraintAttributeList = sparseArray;
        }

        @Override // androidx.constraintlayout.motion.widget.TimeCycleSplineSet
        public void setPoint(int i, float f, float f2, int i2, float f3) {
            throw new java.lang.RuntimeException("don't call for custom attribute call setPoint(pos, ConstraintAttribute,...)");
        }

        public void setPoint(int i, androidx.constraintlayout.widget.ConstraintAttribute constraintAttribute, float f, int i2, float f2) {
            this.mConstraintAttributeList.append(i, constraintAttribute);
            this.mWaveProperties.append(i, new float[]{f, f2});
            this.mWaveShape = java.lang.Math.max(this.mWaveShape, i2);
        }

        @Override // androidx.constraintlayout.motion.widget.TimeCycleSplineSet
        public boolean setProperty(android.view.View view, float f, long j, androidx.constraintlayout.motion.widget.KeyCache keyCache) {
            this.mCurveFit.getPos(f, this.mTempValues);
            float[] fArr = this.mTempValues;
            float f2 = fArr[fArr.length - 2];
            float f3 = fArr[fArr.length - 1];
            long j2 = j - this.last_time;
            if (java.lang.Float.isNaN(this.last_cycle)) {
                float floatValue = keyCache.getFloatValue(view, this.mAttributeName, 0);
                this.last_cycle = floatValue;
                if (java.lang.Float.isNaN(floatValue)) {
                    this.last_cycle = 0.0f;
                }
            }
            float f4 = (float) ((this.last_cycle + ((j2 * 1.0E-9d) * f2)) % 1.0d);
            this.last_cycle = f4;
            this.last_time = j;
            float calcWave = calcWave(f4);
            this.mContinue = false;
            int i = 0;
            while (true) {
                float[] fArr2 = this.mCache;
                if (i >= fArr2.length) {
                    break;
                }
                boolean z = this.mContinue;
                float f5 = this.mTempValues[i];
                this.mContinue = z | (((double) f5) != 0.0d);
                fArr2[i] = (f5 * calcWave) + f3;
                i++;
            }
            this.mConstraintAttributeList.valueAt(0).setInterpolatedValue(view, this.mCache);
            if (f2 != 0.0f) {
                this.mContinue = true;
            }
            return this.mContinue;
        }

        @Override // androidx.constraintlayout.motion.widget.TimeCycleSplineSet
        public void setup(int i) {
            int size = this.mConstraintAttributeList.size();
            int noOfInterpValues = this.mConstraintAttributeList.valueAt(0).noOfInterpValues();
            double[] dArr = new double[size];
            int i2 = noOfInterpValues + 2;
            this.mTempValues = new float[i2];
            this.mCache = new float[noOfInterpValues];
            double[][] dArr2 = (double[][]) java.lang.reflect.Array.newInstance((java.lang.Class<?>) java.lang.Double.TYPE, size, i2);
            for (int i3 = 0; i3 < size; i3++) {
                int keyAt = this.mConstraintAttributeList.keyAt(i3);
                androidx.constraintlayout.widget.ConstraintAttribute valueAt = this.mConstraintAttributeList.valueAt(i3);
                float[] valueAt2 = this.mWaveProperties.valueAt(i3);
                dArr[i3] = keyAt * 0.01d;
                valueAt.getValuesToInterpolate(this.mTempValues);
                int i4 = 0;
                while (true) {
                    if (i4 < this.mTempValues.length) {
                        dArr2[i3][i4] = r8[i4];
                        i4++;
                    }
                }
                double[] dArr3 = dArr2[i3];
                dArr3[noOfInterpValues] = valueAt2[0];
                dArr3[noOfInterpValues + 1] = valueAt2[1];
            }
            this.mCurveFit = androidx.constraintlayout.motion.utils.CurveFit.get(i, dArr, dArr2);
        }
    }

    public static class ElevationSet extends androidx.constraintlayout.motion.widget.TimeCycleSplineSet {
        @Override // androidx.constraintlayout.motion.widget.TimeCycleSplineSet
        public boolean setProperty(android.view.View view, float f, long j, androidx.constraintlayout.motion.widget.KeyCache keyCache) {
            view.setElevation(get(f, j, view, keyCache));
            return this.mContinue;
        }
    }

    public static class PathRotate extends androidx.constraintlayout.motion.widget.TimeCycleSplineSet {
        public boolean setPathRotate(android.view.View view, androidx.constraintlayout.motion.widget.KeyCache keyCache, float f, long j, double d, double d2) {
            view.setRotation(get(f, j, view, keyCache) + ((float) java.lang.Math.toDegrees(java.lang.Math.atan2(d2, d))));
            return this.mContinue;
        }

        @Override // androidx.constraintlayout.motion.widget.TimeCycleSplineSet
        public boolean setProperty(android.view.View view, float f, long j, androidx.constraintlayout.motion.widget.KeyCache keyCache) {
            return this.mContinue;
        }
    }

    public static class ProgressSet extends androidx.constraintlayout.motion.widget.TimeCycleSplineSet {
        boolean mNoMethod = false;

        @Override // androidx.constraintlayout.motion.widget.TimeCycleSplineSet
        public boolean setProperty(android.view.View view, float f, long j, androidx.constraintlayout.motion.widget.KeyCache keyCache) {
            java.lang.reflect.Method method;
            if (view instanceof androidx.constraintlayout.motion.widget.MotionLayout) {
                ((androidx.constraintlayout.motion.widget.MotionLayout) view).setProgress(get(f, j, view, keyCache));
            } else {
                if (this.mNoMethod) {
                    return false;
                }
                try {
                    method = view.getClass().getMethod("setProgress", java.lang.Float.TYPE);
                } catch (java.lang.NoSuchMethodException unused) {
                    this.mNoMethod = true;
                    method = null;
                }
                if (method != null) {
                    try {
                        method.invoke(view, java.lang.Float.valueOf(get(f, j, view, keyCache)));
                    } catch (java.lang.IllegalAccessException | java.lang.reflect.InvocationTargetException unused2) {
                    }
                }
            }
            return this.mContinue;
        }
    }

    public static class RotationSet extends androidx.constraintlayout.motion.widget.TimeCycleSplineSet {
        @Override // androidx.constraintlayout.motion.widget.TimeCycleSplineSet
        public boolean setProperty(android.view.View view, float f, long j, androidx.constraintlayout.motion.widget.KeyCache keyCache) {
            view.setRotation(get(f, j, view, keyCache));
            return this.mContinue;
        }
    }

    public static class RotationXset extends androidx.constraintlayout.motion.widget.TimeCycleSplineSet {
        @Override // androidx.constraintlayout.motion.widget.TimeCycleSplineSet
        public boolean setProperty(android.view.View view, float f, long j, androidx.constraintlayout.motion.widget.KeyCache keyCache) {
            view.setRotationX(get(f, j, view, keyCache));
            return this.mContinue;
        }
    }

    public static class RotationYset extends androidx.constraintlayout.motion.widget.TimeCycleSplineSet {
        @Override // androidx.constraintlayout.motion.widget.TimeCycleSplineSet
        public boolean setProperty(android.view.View view, float f, long j, androidx.constraintlayout.motion.widget.KeyCache keyCache) {
            view.setRotationY(get(f, j, view, keyCache));
            return this.mContinue;
        }
    }

    public static class ScaleXset extends androidx.constraintlayout.motion.widget.TimeCycleSplineSet {
        @Override // androidx.constraintlayout.motion.widget.TimeCycleSplineSet
        public boolean setProperty(android.view.View view, float f, long j, androidx.constraintlayout.motion.widget.KeyCache keyCache) {
            view.setScaleX(get(f, j, view, keyCache));
            return this.mContinue;
        }
    }

    public static class ScaleYset extends androidx.constraintlayout.motion.widget.TimeCycleSplineSet {
        @Override // androidx.constraintlayout.motion.widget.TimeCycleSplineSet
        public boolean setProperty(android.view.View view, float f, long j, androidx.constraintlayout.motion.widget.KeyCache keyCache) {
            view.setScaleY(get(f, j, view, keyCache));
            return this.mContinue;
        }
    }

    public static class Sort {
        private Sort() {
        }

        public static void doubleQuickSort(int[] iArr, float[][] fArr, int i, int i2) {
            int[] iArr2 = new int[iArr.length + 10];
            iArr2[0] = i2;
            iArr2[1] = i;
            int i3 = 2;
            while (i3 > 0) {
                int i4 = i3 - 1;
                int i5 = iArr2[i4];
                i3 = i4 - 1;
                int i6 = iArr2[i3];
                if (i5 < i6) {
                    int partition = partition(iArr, fArr, i5, i6);
                    int i7 = i3 + 1;
                    iArr2[i3] = partition - 1;
                    int i8 = i7 + 1;
                    iArr2[i7] = i5;
                    int i9 = i8 + 1;
                    iArr2[i8] = i6;
                    i3 = i9 + 1;
                    iArr2[i9] = partition + 1;
                }
            }
        }

        private static int partition(int[] iArr, float[][] fArr, int i, int i2) {
            int i3 = iArr[i2];
            int i4 = i;
            while (i < i2) {
                if (iArr[i] <= i3) {
                    swap(iArr, fArr, i4, i);
                    i4++;
                }
                i++;
            }
            swap(iArr, fArr, i4, i2);
            return i4;
        }

        private static void swap(int[] iArr, float[][] fArr, int i, int i2) {
            int i3 = iArr[i];
            iArr[i] = iArr[i2];
            iArr[i2] = i3;
            float[] fArr2 = fArr[i];
            fArr[i] = fArr[i2];
            fArr[i2] = fArr2;
        }
    }

    public static class TranslationXset extends androidx.constraintlayout.motion.widget.TimeCycleSplineSet {
        @Override // androidx.constraintlayout.motion.widget.TimeCycleSplineSet
        public boolean setProperty(android.view.View view, float f, long j, androidx.constraintlayout.motion.widget.KeyCache keyCache) {
            view.setTranslationX(get(f, j, view, keyCache));
            return this.mContinue;
        }
    }

    public static class TranslationYset extends androidx.constraintlayout.motion.widget.TimeCycleSplineSet {
        @Override // androidx.constraintlayout.motion.widget.TimeCycleSplineSet
        public boolean setProperty(android.view.View view, float f, long j, androidx.constraintlayout.motion.widget.KeyCache keyCache) {
            view.setTranslationY(get(f, j, view, keyCache));
            return this.mContinue;
        }
    }

    public static class TranslationZset extends androidx.constraintlayout.motion.widget.TimeCycleSplineSet {
        @Override // androidx.constraintlayout.motion.widget.TimeCycleSplineSet
        public boolean setProperty(android.view.View view, float f, long j, androidx.constraintlayout.motion.widget.KeyCache keyCache) {
            view.setTranslationZ(get(f, j, view, keyCache));
            return this.mContinue;
        }
    }

    public static androidx.constraintlayout.motion.widget.TimeCycleSplineSet makeCustomSpline(java.lang.String str, android.util.SparseArray<androidx.constraintlayout.widget.ConstraintAttribute> sparseArray) {
        return new androidx.constraintlayout.motion.widget.TimeCycleSplineSet.CustomSet(str, sparseArray);
    }

    public static androidx.constraintlayout.motion.widget.TimeCycleSplineSet makeSpline(java.lang.String str, long j) {
        androidx.constraintlayout.motion.widget.TimeCycleSplineSet rotationXset;
        str.hashCode();
        switch (str) {
            case "rotationX":
                rotationXset = new androidx.constraintlayout.motion.widget.TimeCycleSplineSet.RotationXset();
                break;
            case "rotationY":
                rotationXset = new androidx.constraintlayout.motion.widget.TimeCycleSplineSet.RotationYset();
                break;
            case "translationX":
                rotationXset = new androidx.constraintlayout.motion.widget.TimeCycleSplineSet.TranslationXset();
                break;
            case "translationY":
                rotationXset = new androidx.constraintlayout.motion.widget.TimeCycleSplineSet.TranslationYset();
                break;
            case "translationZ":
                rotationXset = new androidx.constraintlayout.motion.widget.TimeCycleSplineSet.TranslationZset();
                break;
            case "progress":
                rotationXset = new androidx.constraintlayout.motion.widget.TimeCycleSplineSet.ProgressSet();
                break;
            case "scaleX":
                rotationXset = new androidx.constraintlayout.motion.widget.TimeCycleSplineSet.ScaleXset();
                break;
            case "scaleY":
                rotationXset = new androidx.constraintlayout.motion.widget.TimeCycleSplineSet.ScaleYset();
                break;
            case "rotation":
                rotationXset = new androidx.constraintlayout.motion.widget.TimeCycleSplineSet.RotationSet();
                break;
            case "elevation":
                rotationXset = new androidx.constraintlayout.motion.widget.TimeCycleSplineSet.ElevationSet();
                break;
            case "transitionPathRotate":
                rotationXset = new androidx.constraintlayout.motion.widget.TimeCycleSplineSet.PathRotate();
                break;
            case "alpha":
                rotationXset = new androidx.constraintlayout.motion.widget.TimeCycleSplineSet.AlphaSet();
                break;
            default:
                return null;
        }
        rotationXset.setStartTime(j);
        return rotationXset;
    }

    public float calcWave(float f) {
        float abs;
        switch (this.mWaveShape) {
            case 1:
                return java.lang.Math.signum(f * VAL_2PI);
            case 2:
                abs = java.lang.Math.abs(f);
                break;
            case 3:
                return (((f * 2.0f) + 1.0f) % 2.0f) - 1.0f;
            case 4:
                abs = ((f * 2.0f) + 1.0f) % 2.0f;
                break;
            case 5:
                return (float) java.lang.Math.cos(f * VAL_2PI);
            case 6:
                float abs2 = 1.0f - java.lang.Math.abs(((f * 4.0f) % 4.0f) - 2.0f);
                abs = abs2 * abs2;
                break;
            default:
                return (float) java.lang.Math.sin(f * VAL_2PI);
        }
        return 1.0f - abs;
    }

    public float get(float f, long j, android.view.View view, androidx.constraintlayout.motion.widget.KeyCache keyCache) {
        this.mCurveFit.getPos(f, this.mCache);
        float[] fArr = this.mCache;
        float f2 = fArr[1];
        if (f2 == 0.0f) {
            this.mContinue = false;
            return fArr[2];
        }
        if (java.lang.Float.isNaN(this.last_cycle)) {
            float floatValue = keyCache.getFloatValue(view, this.mType, 0);
            this.last_cycle = floatValue;
            if (java.lang.Float.isNaN(floatValue)) {
                this.last_cycle = 0.0f;
            }
        }
        float f3 = (float) ((this.last_cycle + (((j - this.last_time) * 1.0E-9d) * f2)) % 1.0d);
        this.last_cycle = f3;
        keyCache.setFloatValue(view, this.mType, 0, f3);
        this.last_time = j;
        float f4 = this.mCache[0];
        float calcWave = (calcWave(this.last_cycle) * f4) + this.mCache[2];
        this.mContinue = (f4 == 0.0f && f2 == 0.0f) ? false : true;
        return calcWave;
    }

    public androidx.constraintlayout.motion.utils.CurveFit getCurveFit() {
        return this.mCurveFit;
    }

    public void setPoint(int i, float f, float f2, int i2, float f3) {
        int[] iArr = this.mTimePoints;
        int i3 = this.count;
        iArr[i3] = i;
        float[] fArr = this.mValues[i3];
        fArr[0] = f;
        fArr[1] = f2;
        fArr[2] = f3;
        this.mWaveShape = java.lang.Math.max(this.mWaveShape, i2);
        this.count++;
    }

    public abstract boolean setProperty(android.view.View view, float f, long j, androidx.constraintlayout.motion.widget.KeyCache keyCache);

    public void setStartTime(long j) {
        this.last_time = j;
    }

    public void setType(java.lang.String str) {
        this.mType = str;
    }

    public void setup(int i) {
        int i2;
        int i3 = this.count;
        if (i3 == 0) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("Error no points added to ");
            sb.append(this.mType);
            return;
        }
        androidx.constraintlayout.motion.widget.TimeCycleSplineSet.Sort.doubleQuickSort(this.mTimePoints, this.mValues, 0, i3 - 1);
        int i4 = 1;
        int i5 = 0;
        while (true) {
            int[] iArr = this.mTimePoints;
            if (i4 >= iArr.length) {
                break;
            }
            if (iArr[i4] != iArr[i4 - 1]) {
                i5++;
            }
            i4++;
        }
        if (i5 == 0) {
            i5 = 1;
        }
        double[] dArr = new double[i5];
        double[][] dArr2 = (double[][]) java.lang.reflect.Array.newInstance((java.lang.Class<?>) java.lang.Double.TYPE, i5, 3);
        int i6 = 0;
        while (i2 < this.count) {
            if (i2 > 0) {
                int[] iArr2 = this.mTimePoints;
                i2 = iArr2[i2] == iArr2[i2 + (-1)] ? i2 + 1 : 0;
            }
            dArr[i6] = this.mTimePoints[i2] * 0.01d;
            double[] dArr3 = dArr2[i6];
            float[] fArr = this.mValues[i2];
            dArr3[0] = fArr[0];
            dArr3[1] = fArr[1];
            dArr3[2] = fArr[2];
            i6++;
        }
        this.mCurveFit = androidx.constraintlayout.motion.utils.CurveFit.get(i, dArr, dArr2);
    }

    public java.lang.String toString() {
        java.lang.String str = this.mType;
        java.text.DecimalFormat decimalFormat = new java.text.DecimalFormat("##.##");
        for (int i = 0; i < this.count; i++) {
            str = str + "[" + this.mTimePoints[i] + " , " + decimalFormat.format(this.mValues[i]) + "] ";
        }
        return str;
    }
}
