package androidx.constraintlayout.motion.widget;

/* loaded from: classes.dex */
public abstract class SplineSet {
    private static final java.lang.String TAG = "SplineSet";
    private int count;
    protected androidx.constraintlayout.motion.utils.CurveFit mCurveFit;
    private java.lang.String mType;
    protected int[] mTimePoints = new int[10];
    protected float[] mValues = new float[10];

    public static class AlphaSet extends androidx.constraintlayout.motion.widget.SplineSet {
        @Override // androidx.constraintlayout.motion.widget.SplineSet
        public void setProperty(android.view.View view, float f) {
            view.setAlpha(get(f));
        }
    }

    public static class CustomSet extends androidx.constraintlayout.motion.widget.SplineSet {
        java.lang.String mAttributeName;
        android.util.SparseArray<androidx.constraintlayout.widget.ConstraintAttribute> mConstraintAttributeList;
        float[] mTempValues;

        public CustomSet(java.lang.String str, android.util.SparseArray<androidx.constraintlayout.widget.ConstraintAttribute> sparseArray) {
            this.mAttributeName = str.split(",")[1];
            this.mConstraintAttributeList = sparseArray;
        }

        @Override // androidx.constraintlayout.motion.widget.SplineSet
        public void setPoint(int i, float f) {
            throw new java.lang.RuntimeException("don't call for custom attribute call setPoint(pos, ConstraintAttribute)");
        }

        public void setPoint(int i, androidx.constraintlayout.widget.ConstraintAttribute constraintAttribute) {
            this.mConstraintAttributeList.append(i, constraintAttribute);
        }

        @Override // androidx.constraintlayout.motion.widget.SplineSet
        public void setProperty(android.view.View view, float f) {
            this.mCurveFit.getPos(f, this.mTempValues);
            this.mConstraintAttributeList.valueAt(0).setInterpolatedValue(view, this.mTempValues);
        }

        @Override // androidx.constraintlayout.motion.widget.SplineSet
        public void setup(int i) {
            int size = this.mConstraintAttributeList.size();
            int noOfInterpValues = this.mConstraintAttributeList.valueAt(0).noOfInterpValues();
            double[] dArr = new double[size];
            this.mTempValues = new float[noOfInterpValues];
            double[][] dArr2 = (double[][]) java.lang.reflect.Array.newInstance((java.lang.Class<?>) java.lang.Double.TYPE, size, noOfInterpValues);
            for (int i2 = 0; i2 < size; i2++) {
                int keyAt = this.mConstraintAttributeList.keyAt(i2);
                androidx.constraintlayout.widget.ConstraintAttribute valueAt = this.mConstraintAttributeList.valueAt(i2);
                dArr[i2] = keyAt * 0.01d;
                valueAt.getValuesToInterpolate(this.mTempValues);
                int i3 = 0;
                while (true) {
                    if (i3 < this.mTempValues.length) {
                        dArr2[i2][i3] = r6[i3];
                        i3++;
                    }
                }
            }
            this.mCurveFit = androidx.constraintlayout.motion.utils.CurveFit.get(i, dArr, dArr2);
        }
    }

    public static class ElevationSet extends androidx.constraintlayout.motion.widget.SplineSet {
        @Override // androidx.constraintlayout.motion.widget.SplineSet
        public void setProperty(android.view.View view, float f) {
            view.setElevation(get(f));
        }
    }

    public static class PathRotate extends androidx.constraintlayout.motion.widget.SplineSet {
        public void setPathRotate(android.view.View view, float f, double d, double d2) {
            view.setRotation(get(f) + ((float) java.lang.Math.toDegrees(java.lang.Math.atan2(d2, d))));
        }

        @Override // androidx.constraintlayout.motion.widget.SplineSet
        public void setProperty(android.view.View view, float f) {
        }
    }

    public static class PivotXset extends androidx.constraintlayout.motion.widget.SplineSet {
        @Override // androidx.constraintlayout.motion.widget.SplineSet
        public void setProperty(android.view.View view, float f) {
            view.setPivotX(get(f));
        }
    }

    public static class PivotYset extends androidx.constraintlayout.motion.widget.SplineSet {
        @Override // androidx.constraintlayout.motion.widget.SplineSet
        public void setProperty(android.view.View view, float f) {
            view.setPivotY(get(f));
        }
    }

    public static class ProgressSet extends androidx.constraintlayout.motion.widget.SplineSet {
        boolean mNoMethod = false;

        @Override // androidx.constraintlayout.motion.widget.SplineSet
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

    public static class RotationSet extends androidx.constraintlayout.motion.widget.SplineSet {
        @Override // androidx.constraintlayout.motion.widget.SplineSet
        public void setProperty(android.view.View view, float f) {
            view.setRotation(get(f));
        }
    }

    public static class RotationXset extends androidx.constraintlayout.motion.widget.SplineSet {
        @Override // androidx.constraintlayout.motion.widget.SplineSet
        public void setProperty(android.view.View view, float f) {
            view.setRotationX(get(f));
        }
    }

    public static class RotationYset extends androidx.constraintlayout.motion.widget.SplineSet {
        @Override // androidx.constraintlayout.motion.widget.SplineSet
        public void setProperty(android.view.View view, float f) {
            view.setRotationY(get(f));
        }
    }

    public static class ScaleXset extends androidx.constraintlayout.motion.widget.SplineSet {
        @Override // androidx.constraintlayout.motion.widget.SplineSet
        public void setProperty(android.view.View view, float f) {
            view.setScaleX(get(f));
        }
    }

    public static class ScaleYset extends androidx.constraintlayout.motion.widget.SplineSet {
        @Override // androidx.constraintlayout.motion.widget.SplineSet
        public void setProperty(android.view.View view, float f) {
            view.setScaleY(get(f));
        }
    }

    public static class Sort {
        private Sort() {
        }

        public static void doubleQuickSort(int[] iArr, float[] fArr, int i, int i2) {
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

        private static void swap(int[] iArr, float[] fArr, int i, int i2) {
            int i3 = iArr[i];
            iArr[i] = iArr[i2];
            iArr[i2] = i3;
            float f = fArr[i];
            fArr[i] = fArr[i2];
            fArr[i2] = f;
        }
    }

    public static class TranslationXset extends androidx.constraintlayout.motion.widget.SplineSet {
        @Override // androidx.constraintlayout.motion.widget.SplineSet
        public void setProperty(android.view.View view, float f) {
            view.setTranslationX(get(f));
        }
    }

    public static class TranslationYset extends androidx.constraintlayout.motion.widget.SplineSet {
        @Override // androidx.constraintlayout.motion.widget.SplineSet
        public void setProperty(android.view.View view, float f) {
            view.setTranslationY(get(f));
        }
    }

    public static class TranslationZset extends androidx.constraintlayout.motion.widget.SplineSet {
        @Override // androidx.constraintlayout.motion.widget.SplineSet
        public void setProperty(android.view.View view, float f) {
            view.setTranslationZ(get(f));
        }
    }

    public static androidx.constraintlayout.motion.widget.SplineSet makeCustomSpline(java.lang.String str, android.util.SparseArray<androidx.constraintlayout.widget.ConstraintAttribute> sparseArray) {
        return new androidx.constraintlayout.motion.widget.SplineSet.CustomSet(str, sparseArray);
    }

    public static androidx.constraintlayout.motion.widget.SplineSet makeSpline(java.lang.String str) {
        str.hashCode();
        switch (str) {
        }
        return new androidx.constraintlayout.motion.widget.SplineSet.AlphaSet();
    }

    public float get(float f) {
        return (float) this.mCurveFit.getPos(f, 0);
    }

    public androidx.constraintlayout.motion.utils.CurveFit getCurveFit() {
        return this.mCurveFit;
    }

    public float getSlope(float f) {
        return (float) this.mCurveFit.getSlope(f, 0);
    }

    public void setPoint(int i, float f) {
        int[] iArr = this.mTimePoints;
        if (iArr.length < this.count + 1) {
            this.mTimePoints = java.util.Arrays.copyOf(iArr, iArr.length * 2);
            float[] fArr = this.mValues;
            this.mValues = java.util.Arrays.copyOf(fArr, fArr.length * 2);
        }
        int[] iArr2 = this.mTimePoints;
        int i2 = this.count;
        iArr2[i2] = i;
        this.mValues[i2] = f;
        this.count = i2 + 1;
    }

    public abstract void setProperty(android.view.View view, float f);

    public void setType(java.lang.String str) {
        this.mType = str;
    }

    public void setup(int i) {
        int i2;
        int i3 = this.count;
        if (i3 == 0) {
            return;
        }
        androidx.constraintlayout.motion.widget.SplineSet.Sort.doubleQuickSort(this.mTimePoints, this.mValues, 0, i3 - 1);
        int i4 = 1;
        for (int i5 = 1; i5 < this.count; i5++) {
            int[] iArr = this.mTimePoints;
            if (iArr[i5 - 1] != iArr[i5]) {
                i4++;
            }
        }
        double[] dArr = new double[i4];
        double[][] dArr2 = (double[][]) java.lang.reflect.Array.newInstance((java.lang.Class<?>) java.lang.Double.TYPE, i4, 1);
        int i6 = 0;
        while (i2 < this.count) {
            if (i2 > 0) {
                int[] iArr2 = this.mTimePoints;
                i2 = iArr2[i2] == iArr2[i2 + (-1)] ? i2 + 1 : 0;
            }
            dArr[i6] = this.mTimePoints[i2] * 0.01d;
            dArr2[i6][0] = this.mValues[i2];
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
