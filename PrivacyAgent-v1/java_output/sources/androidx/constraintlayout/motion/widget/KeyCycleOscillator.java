package androidx.constraintlayout.motion.widget;

/* loaded from: classes.dex */
public abstract class KeyCycleOscillator {
    private static final java.lang.String TAG = "KeyCycleOscillator";
    private androidx.constraintlayout.motion.utils.CurveFit mCurveFit;
    protected androidx.constraintlayout.widget.ConstraintAttribute mCustom;
    private androidx.constraintlayout.motion.widget.KeyCycleOscillator.CycleOscillator mCycleOscillator;
    private java.lang.String mType;
    private int mWaveShape = 0;
    public int mVariesBy = 0;
    java.util.ArrayList<androidx.constraintlayout.motion.widget.KeyCycleOscillator.WavePoint> mWavePoints = new java.util.ArrayList<>();

    /* renamed from: androidx.constraintlayout.motion.widget.KeyCycleOscillator$1, reason: invalid class name */
    public class AnonymousClass1 implements java.util.Comparator<androidx.constraintlayout.motion.widget.KeyCycleOscillator.WavePoint> {
        public AnonymousClass1() {
        }

        @Override // java.util.Comparator
        public int compare(androidx.constraintlayout.motion.widget.KeyCycleOscillator.WavePoint wavePoint, androidx.constraintlayout.motion.widget.KeyCycleOscillator.WavePoint wavePoint2) {
            return java.lang.Integer.compare(wavePoint.mPosition, wavePoint2.mPosition);
        }
    }

    public static class AlphaSet extends androidx.constraintlayout.motion.widget.KeyCycleOscillator {
        @Override // androidx.constraintlayout.motion.widget.KeyCycleOscillator
        public void setProperty(android.view.View view, float f) {
            view.setAlpha(get(f));
        }
    }

    public static class CustomSet extends androidx.constraintlayout.motion.widget.KeyCycleOscillator {
        float[] value = new float[1];

        @Override // androidx.constraintlayout.motion.widget.KeyCycleOscillator
        public void setProperty(android.view.View view, float f) {
            this.value[0] = get(f);
            this.mCustom.setInterpolatedValue(view, this.value);
        }
    }

    public static class CycleOscillator {
        private static final java.lang.String TAG = "CycleOscillator";
        static final int UNSET = -1;
        androidx.constraintlayout.motion.utils.CurveFit mCurveFit;
        float[] mOffset;
        float mPathLength;
        float[] mPeriod;
        double[] mPosition;
        float[] mScale;
        double[] mSplineSlopeCache;
        double[] mSplineValueCache;
        float[] mValues;
        private final int mVariesBy;
        int mWaveShape;
        androidx.constraintlayout.motion.utils.Oscillator mOscillator = new androidx.constraintlayout.motion.utils.Oscillator();
        public java.util.HashMap<java.lang.String, androidx.constraintlayout.widget.ConstraintAttribute> mCustomConstraints = new java.util.HashMap<>();

        public CycleOscillator(int i, int i2, int i3) {
            this.mWaveShape = i;
            this.mVariesBy = i2;
            this.mOscillator.setType(i);
            this.mValues = new float[i3];
            this.mPosition = new double[i3];
            this.mPeriod = new float[i3];
            this.mOffset = new float[i3];
            this.mScale = new float[i3];
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

        public double getSlope(float f) {
            androidx.constraintlayout.motion.utils.CurveFit curveFit = this.mCurveFit;
            if (curveFit != null) {
                double d = f;
                curveFit.getSlope(d, this.mSplineSlopeCache);
                this.mCurveFit.getPos(d, this.mSplineValueCache);
            } else {
                double[] dArr = this.mSplineSlopeCache;
                dArr[0] = 0.0d;
                dArr[1] = 0.0d;
            }
            double d2 = f;
            double value = this.mOscillator.getValue(d2);
            double slope = this.mOscillator.getSlope(d2);
            double[] dArr2 = this.mSplineSlopeCache;
            return dArr2[0] + (value * dArr2[1]) + (slope * this.mSplineValueCache[1]);
        }

        public double getValues(float f) {
            androidx.constraintlayout.motion.utils.CurveFit curveFit = this.mCurveFit;
            if (curveFit != null) {
                curveFit.getPos(f, this.mSplineValueCache);
            } else {
                double[] dArr = this.mSplineValueCache;
                dArr[0] = this.mOffset[0];
                dArr[1] = this.mValues[0];
            }
            return this.mSplineValueCache[0] + (this.mOscillator.getValue(f) * this.mSplineValueCache[1]);
        }

        public void setPoint(int i, int i2, float f, float f2, float f3) {
            this.mPosition[i] = i2 / 100.0d;
            this.mPeriod[i] = f;
            this.mOffset[i] = f2;
            this.mValues[i] = f3;
        }

        public void setup(float f) {
            this.mPathLength = f;
            double[][] dArr = (double[][]) java.lang.reflect.Array.newInstance((java.lang.Class<?>) java.lang.Double.TYPE, this.mPosition.length, 2);
            float[] fArr = this.mValues;
            this.mSplineValueCache = new double[fArr.length + 1];
            this.mSplineSlopeCache = new double[fArr.length + 1];
            if (this.mPosition[0] > 0.0d) {
                this.mOscillator.addPoint(0.0d, this.mPeriod[0]);
            }
            double[] dArr2 = this.mPosition;
            int length = dArr2.length - 1;
            if (dArr2[length] < 1.0d) {
                this.mOscillator.addPoint(1.0d, this.mPeriod[length]);
            }
            for (int i = 0; i < dArr.length; i++) {
                dArr[i][0] = this.mOffset[i];
                int i2 = 0;
                while (true) {
                    if (i2 < this.mValues.length) {
                        dArr[i2][1] = r4[i2];
                        i2++;
                    }
                }
                this.mOscillator.addPoint(this.mPosition[i], this.mPeriod[i]);
            }
            this.mOscillator.normalize();
            double[] dArr3 = this.mPosition;
            if (dArr3.length > 1) {
                this.mCurveFit = androidx.constraintlayout.motion.utils.CurveFit.get(0, dArr3, dArr);
            } else {
                this.mCurveFit = null;
            }
        }
    }

    public static class ElevationSet extends androidx.constraintlayout.motion.widget.KeyCycleOscillator {
        @Override // androidx.constraintlayout.motion.widget.KeyCycleOscillator
        public void setProperty(android.view.View view, float f) {
            view.setElevation(get(f));
        }
    }

    public static class IntDoubleSort {
        private IntDoubleSort() {
        }

        private static int partition(int[] iArr, float[] fArr, int i, int i2) {
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

        public static void sort(int[] iArr, float[] fArr, int i, int i2) {
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

        private static void swap(int[] iArr, float[] fArr, int i, int i2) {
            int i3 = iArr[i];
            iArr[i] = iArr[i2];
            iArr[i2] = i3;
            float f = fArr[i];
            fArr[i] = fArr[i2];
            fArr[i2] = f;
        }
    }

    public static class IntFloatFloatSort {
        private IntFloatFloatSort() {
        }

        private static int partition(int[] iArr, float[] fArr, float[] fArr2, int i, int i2) {
            int i3 = iArr[i2];
            int i4 = i;
            while (i < i2) {
                if (iArr[i] <= i3) {
                    swap(iArr, fArr, fArr2, i4, i);
                    i4++;
                }
                i++;
            }
            swap(iArr, fArr, fArr2, i4, i2);
            return i4;
        }

        public static void sort(int[] iArr, float[] fArr, float[] fArr2, int i, int i2) {
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
                    int partition = partition(iArr, fArr, fArr2, i5, i6);
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

        private static void swap(int[] iArr, float[] fArr, float[] fArr2, int i, int i2) {
            int i3 = iArr[i];
            iArr[i] = iArr[i2];
            iArr[i2] = i3;
            float f = fArr[i];
            fArr[i] = fArr[i2];
            fArr[i2] = f;
            float f2 = fArr2[i];
            fArr2[i] = fArr2[i2];
            fArr2[i2] = f2;
        }
    }

    public static class PathRotateSet extends androidx.constraintlayout.motion.widget.KeyCycleOscillator {
        public void setPathRotate(android.view.View view, float f, double d, double d2) {
            view.setRotation(get(f) + ((float) java.lang.Math.toDegrees(java.lang.Math.atan2(d2, d))));
        }

        @Override // androidx.constraintlayout.motion.widget.KeyCycleOscillator
        public void setProperty(android.view.View view, float f) {
        }
    }

    public static class ProgressSet extends androidx.constraintlayout.motion.widget.KeyCycleOscillator {
        boolean mNoMethod = false;

        @Override // androidx.constraintlayout.motion.widget.KeyCycleOscillator
        public void setProperty(android.view.View view, float f) {
            java.lang.reflect.Method method;
            if (view instanceof androidx.constraintlayout.motion.widget.MotionLayout) {
                ((androidx.constraintlayout.motion.widget.MotionLayout) view).setProgress(get(f));
                return;
            }
            if (this.mNoMethod) {
                return;
            }
            try {
                method = view.getClass().getMethod("setProgress", java.lang.Float.TYPE);
            } catch (java.lang.NoSuchMethodException unused) {
                this.mNoMethod = true;
                method = null;
            }
            if (method != null) {
                try {
                    method.invoke(view, java.lang.Float.valueOf(get(f)));
                } catch (java.lang.IllegalAccessException | java.lang.reflect.InvocationTargetException unused2) {
                }
            }
        }
    }

    public static class RotationSet extends androidx.constraintlayout.motion.widget.KeyCycleOscillator {
        @Override // androidx.constraintlayout.motion.widget.KeyCycleOscillator
        public void setProperty(android.view.View view, float f) {
            view.setRotation(get(f));
        }
    }

    public static class RotationXset extends androidx.constraintlayout.motion.widget.KeyCycleOscillator {
        @Override // androidx.constraintlayout.motion.widget.KeyCycleOscillator
        public void setProperty(android.view.View view, float f) {
            view.setRotationX(get(f));
        }
    }

    public static class RotationYset extends androidx.constraintlayout.motion.widget.KeyCycleOscillator {
        @Override // androidx.constraintlayout.motion.widget.KeyCycleOscillator
        public void setProperty(android.view.View view, float f) {
            view.setRotationY(get(f));
        }
    }

    public static class ScaleXset extends androidx.constraintlayout.motion.widget.KeyCycleOscillator {
        @Override // androidx.constraintlayout.motion.widget.KeyCycleOscillator
        public void setProperty(android.view.View view, float f) {
            view.setScaleX(get(f));
        }
    }

    public static class ScaleYset extends androidx.constraintlayout.motion.widget.KeyCycleOscillator {
        @Override // androidx.constraintlayout.motion.widget.KeyCycleOscillator
        public void setProperty(android.view.View view, float f) {
            view.setScaleY(get(f));
        }
    }

    public static class TranslationXset extends androidx.constraintlayout.motion.widget.KeyCycleOscillator {
        @Override // androidx.constraintlayout.motion.widget.KeyCycleOscillator
        public void setProperty(android.view.View view, float f) {
            view.setTranslationX(get(f));
        }
    }

    public static class TranslationYset extends androidx.constraintlayout.motion.widget.KeyCycleOscillator {
        @Override // androidx.constraintlayout.motion.widget.KeyCycleOscillator
        public void setProperty(android.view.View view, float f) {
            view.setTranslationY(get(f));
        }
    }

    public static class TranslationZset extends androidx.constraintlayout.motion.widget.KeyCycleOscillator {
        @Override // androidx.constraintlayout.motion.widget.KeyCycleOscillator
        public void setProperty(android.view.View view, float f) {
            view.setTranslationZ(get(f));
        }
    }

    public static class WavePoint {
        float mOffset;
        float mPeriod;
        int mPosition;
        float mValue;

        public WavePoint(int i, float f, float f2, float f3) {
            this.mPosition = i;
            this.mValue = f3;
            this.mOffset = f2;
            this.mPeriod = f;
        }
    }

    public static androidx.constraintlayout.motion.widget.KeyCycleOscillator makeSpline(java.lang.String str) {
        if (str.startsWith("CUSTOM")) {
            return new androidx.constraintlayout.motion.widget.KeyCycleOscillator.CustomSet();
        }
        switch (str) {
            case "rotationX":
                return new androidx.constraintlayout.motion.widget.KeyCycleOscillator.RotationXset();
            case "rotationY":
                return new androidx.constraintlayout.motion.widget.KeyCycleOscillator.RotationYset();
            case "translationX":
                return new androidx.constraintlayout.motion.widget.KeyCycleOscillator.TranslationXset();
            case "translationY":
                return new androidx.constraintlayout.motion.widget.KeyCycleOscillator.TranslationYset();
            case "translationZ":
                return new androidx.constraintlayout.motion.widget.KeyCycleOscillator.TranslationZset();
            case "progress":
                return new androidx.constraintlayout.motion.widget.KeyCycleOscillator.ProgressSet();
            case "scaleX":
                return new androidx.constraintlayout.motion.widget.KeyCycleOscillator.ScaleXset();
            case "scaleY":
                return new androidx.constraintlayout.motion.widget.KeyCycleOscillator.ScaleYset();
            case "waveVariesBy":
                return new androidx.constraintlayout.motion.widget.KeyCycleOscillator.AlphaSet();
            case "rotation":
                return new androidx.constraintlayout.motion.widget.KeyCycleOscillator.RotationSet();
            case "elevation":
                return new androidx.constraintlayout.motion.widget.KeyCycleOscillator.ElevationSet();
            case "transitionPathRotate":
                return new androidx.constraintlayout.motion.widget.KeyCycleOscillator.PathRotateSet();
            case "alpha":
                return new androidx.constraintlayout.motion.widget.KeyCycleOscillator.AlphaSet();
            case "waveOffset":
                return new androidx.constraintlayout.motion.widget.KeyCycleOscillator.AlphaSet();
            default:
                return null;
        }
    }

    public float get(float f) {
        return (float) this.mCycleOscillator.getValues(f);
    }

    public androidx.constraintlayout.motion.utils.CurveFit getCurveFit() {
        return this.mCurveFit;
    }

    public float getSlope(float f) {
        return (float) this.mCycleOscillator.getSlope(f);
    }

    public void setPoint(int i, int i2, int i3, float f, float f2, float f3) {
        this.mWavePoints.add(new androidx.constraintlayout.motion.widget.KeyCycleOscillator.WavePoint(i, f, f2, f3));
        if (i3 != -1) {
            this.mVariesBy = i3;
        }
        this.mWaveShape = i2;
    }

    public void setPoint(int i, int i2, int i3, float f, float f2, float f3, androidx.constraintlayout.widget.ConstraintAttribute constraintAttribute) {
        this.mWavePoints.add(new androidx.constraintlayout.motion.widget.KeyCycleOscillator.WavePoint(i, f, f2, f3));
        if (i3 != -1) {
            this.mVariesBy = i3;
        }
        this.mWaveShape = i2;
        this.mCustom = constraintAttribute;
    }

    public abstract void setProperty(android.view.View view, float f);

    public void setType(java.lang.String str) {
        this.mType = str;
    }

    @android.annotation.TargetApi(19)
    public void setup(float f) {
        int size = this.mWavePoints.size();
        if (size == 0) {
            return;
        }
        java.util.Collections.sort(this.mWavePoints, new androidx.constraintlayout.motion.widget.KeyCycleOscillator.AnonymousClass1());
        double[] dArr = new double[size];
        double[][] dArr2 = (double[][]) java.lang.reflect.Array.newInstance((java.lang.Class<?>) java.lang.Double.TYPE, size, 2);
        this.mCycleOscillator = new androidx.constraintlayout.motion.widget.KeyCycleOscillator.CycleOscillator(this.mWaveShape, this.mVariesBy, size);
        java.util.Iterator<androidx.constraintlayout.motion.widget.KeyCycleOscillator.WavePoint> it = this.mWavePoints.iterator();
        int i = 0;
        while (it.hasNext()) {
            androidx.constraintlayout.motion.widget.KeyCycleOscillator.WavePoint next = it.next();
            float f2 = next.mPeriod;
            dArr[i] = f2 * 0.01d;
            double[] dArr3 = dArr2[i];
            float f3 = next.mValue;
            dArr3[0] = f3;
            float f4 = next.mOffset;
            dArr3[1] = f4;
            this.mCycleOscillator.setPoint(i, next.mPosition, f2, f4, f3);
            i++;
        }
        this.mCycleOscillator.setup(f);
        this.mCurveFit = androidx.constraintlayout.motion.utils.CurveFit.get(0, dArr, dArr2);
    }

    public java.lang.String toString() {
        java.lang.String str = this.mType;
        java.text.DecimalFormat decimalFormat = new java.text.DecimalFormat("##.##");
        java.util.Iterator<androidx.constraintlayout.motion.widget.KeyCycleOscillator.WavePoint> it = this.mWavePoints.iterator();
        while (it.hasNext()) {
            str = str + "[" + it.next().mPosition + " , " + decimalFormat.format(r3.mValue) + "] ";
        }
        return str;
    }

    public boolean variesByPath() {
        return this.mVariesBy == 1;
    }
}
