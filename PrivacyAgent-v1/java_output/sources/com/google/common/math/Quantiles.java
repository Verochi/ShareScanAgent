package com.google.common.math;

@com.google.common.annotations.Beta
@com.google.common.annotations.GwtIncompatible
/* loaded from: classes22.dex */
public final class Quantiles {

    public static final class Scale {
        public final int a;

        public Scale(int i) {
            com.google.common.base.Preconditions.checkArgument(i > 0, "Quantile scale must be positive");
            this.a = i;
        }

        public /* synthetic */ Scale(int i, com.google.common.math.Quantiles.AnonymousClass1 anonymousClass1) {
            this(i);
        }

        public com.google.common.math.Quantiles.ScaleAndIndex index(int i) {
            return new com.google.common.math.Quantiles.ScaleAndIndex(this.a, i, null);
        }

        public com.google.common.math.Quantiles.ScaleAndIndexes indexes(java.util.Collection<java.lang.Integer> collection) {
            return new com.google.common.math.Quantiles.ScaleAndIndexes(this.a, com.google.common.primitives.Ints.toArray(collection), null);
        }

        public com.google.common.math.Quantiles.ScaleAndIndexes indexes(int... iArr) {
            return new com.google.common.math.Quantiles.ScaleAndIndexes(this.a, (int[]) iArr.clone(), null);
        }
    }

    public static final class ScaleAndIndex {
        public final int a;
        public final int b;

        public ScaleAndIndex(int i, int i2) {
            com.google.common.math.Quantiles.h(i2, i);
            this.a = i;
            this.b = i2;
        }

        public /* synthetic */ ScaleAndIndex(int i, int i2, com.google.common.math.Quantiles.AnonymousClass1 anonymousClass1) {
            this(i, i2);
        }

        public double compute(java.util.Collection<? extends java.lang.Number> collection) {
            return computeInPlace(com.google.common.primitives.Doubles.toArray(collection));
        }

        public double compute(double... dArr) {
            return computeInPlace((double[]) dArr.clone());
        }

        public double compute(int... iArr) {
            return computeInPlace(com.google.common.math.Quantiles.l(iArr));
        }

        public double compute(long... jArr) {
            return computeInPlace(com.google.common.math.Quantiles.m(jArr));
        }

        public double computeInPlace(double... dArr) {
            com.google.common.base.Preconditions.checkArgument(dArr.length > 0, "Cannot calculate quantiles of an empty dataset");
            if (com.google.common.math.Quantiles.j(dArr)) {
                return Double.NaN;
            }
            long length = this.b * (dArr.length - 1);
            int divide = (int) com.google.common.math.LongMath.divide(length, this.a, java.math.RoundingMode.DOWN);
            int i = (int) (length - (divide * this.a));
            com.google.common.math.Quantiles.q(divide, dArr, 0, dArr.length - 1);
            if (i == 0) {
                return dArr[divide];
            }
            int i2 = divide + 1;
            com.google.common.math.Quantiles.q(i2, dArr, i2, dArr.length - 1);
            return com.google.common.math.Quantiles.k(dArr[divide], dArr[i2], i, this.a);
        }
    }

    public static final class ScaleAndIndexes {
        public final int a;
        public final int[] b;

        public ScaleAndIndexes(int i, int[] iArr) {
            for (int i2 : iArr) {
                com.google.common.math.Quantiles.h(i2, i);
            }
            this.a = i;
            this.b = iArr;
        }

        public /* synthetic */ ScaleAndIndexes(int i, int[] iArr, com.google.common.math.Quantiles.AnonymousClass1 anonymousClass1) {
            this(i, iArr);
        }

        public java.util.Map<java.lang.Integer, java.lang.Double> compute(java.util.Collection<? extends java.lang.Number> collection) {
            return computeInPlace(com.google.common.primitives.Doubles.toArray(collection));
        }

        public java.util.Map<java.lang.Integer, java.lang.Double> compute(double... dArr) {
            return computeInPlace((double[]) dArr.clone());
        }

        public java.util.Map<java.lang.Integer, java.lang.Double> compute(int... iArr) {
            return computeInPlace(com.google.common.math.Quantiles.l(iArr));
        }

        public java.util.Map<java.lang.Integer, java.lang.Double> compute(long... jArr) {
            return computeInPlace(com.google.common.math.Quantiles.m(jArr));
        }

        public java.util.Map<java.lang.Integer, java.lang.Double> computeInPlace(double... dArr) {
            int i = 0;
            int i2 = 1;
            com.google.common.base.Preconditions.checkArgument(dArr.length > 0, "Cannot calculate quantiles of an empty dataset");
            if (com.google.common.math.Quantiles.j(dArr)) {
                java.util.HashMap hashMap = new java.util.HashMap();
                int[] iArr = this.b;
                int length = iArr.length;
                while (i < length) {
                    hashMap.put(java.lang.Integer.valueOf(iArr[i]), java.lang.Double.valueOf(Double.NaN));
                    i++;
                }
                return java.util.Collections.unmodifiableMap(hashMap);
            }
            int[] iArr2 = this.b;
            int[] iArr3 = new int[iArr2.length];
            int[] iArr4 = new int[iArr2.length];
            int[] iArr5 = new int[iArr2.length * 2];
            int i3 = 0;
            int i4 = 0;
            while (true) {
                if (i3 >= this.b.length) {
                    break;
                }
                long length2 = r5[i3] * (dArr.length - i2);
                int divide = (int) com.google.common.math.LongMath.divide(length2, this.a, java.math.RoundingMode.DOWN);
                int i5 = i3;
                int i6 = (int) (length2 - (divide * this.a));
                iArr3[i5] = divide;
                iArr4[i5] = i6;
                iArr5[i4] = divide;
                i4++;
                if (i6 != 0) {
                    iArr5[i4] = divide + 1;
                    i4++;
                }
                i3 = i5 + 1;
                i2 = 1;
            }
            java.util.Arrays.sort(iArr5, 0, i4);
            com.google.common.math.Quantiles.p(iArr5, 0, i4 - 1, dArr, 0, dArr.length - 1);
            java.util.HashMap hashMap2 = new java.util.HashMap();
            while (true) {
                int[] iArr6 = this.b;
                if (i >= iArr6.length) {
                    return java.util.Collections.unmodifiableMap(hashMap2);
                }
                int i7 = iArr3[i];
                int i8 = iArr4[i];
                if (i8 == 0) {
                    hashMap2.put(java.lang.Integer.valueOf(iArr6[i]), java.lang.Double.valueOf(dArr[i7]));
                } else {
                    hashMap2.put(java.lang.Integer.valueOf(iArr6[i]), java.lang.Double.valueOf(com.google.common.math.Quantiles.k(dArr[i7], dArr[i7 + 1], i8, this.a)));
                }
                i++;
            }
        }
    }

    public static void h(int i, int i2) {
        if (i < 0 || i > i2) {
            throw new java.lang.IllegalArgumentException("Quantile indexes must be between 0 and the scale, which is " + i2);
        }
    }

    public static int i(int[] iArr, int i, int i2, int i3, int i4) {
        if (i == i2) {
            return i;
        }
        int i5 = i3 + i4;
        int i6 = i5 >>> 1;
        while (i2 > i + 1) {
            int i7 = (i + i2) >>> 1;
            int i8 = iArr[i7];
            if (i8 > i6) {
                i2 = i7;
            } else {
                if (i8 >= i6) {
                    return i7;
                }
                i = i7;
            }
        }
        return (i5 - iArr[i]) - iArr[i2] > 0 ? i2 : i;
    }

    public static boolean j(double... dArr) {
        for (double d : dArr) {
            if (java.lang.Double.isNaN(d)) {
                return true;
            }
        }
        return false;
    }

    public static double k(double d, double d2, double d3, double d4) {
        if (d == Double.NEGATIVE_INFINITY) {
            return d2 == Double.POSITIVE_INFINITY ? Double.NaN : Double.NEGATIVE_INFINITY;
        }
        if (d2 == Double.POSITIVE_INFINITY) {
            return Double.POSITIVE_INFINITY;
        }
        return d + (((d2 - d) * d3) / d4);
    }

    public static double[] l(int[] iArr) {
        int length = iArr.length;
        double[] dArr = new double[length];
        for (int i = 0; i < length; i++) {
            dArr[i] = iArr[i];
        }
        return dArr;
    }

    public static double[] m(long[] jArr) {
        int length = jArr.length;
        double[] dArr = new double[length];
        for (int i = 0; i < length; i++) {
            dArr[i] = jArr[i];
        }
        return dArr;
    }

    public static com.google.common.math.Quantiles.ScaleAndIndex median() {
        return scale(2).index(1);
    }

    public static void n(double[] dArr, int i, int i2) {
        int i3 = (i + i2) >>> 1;
        double d = dArr[i2];
        double d2 = dArr[i3];
        boolean z = d < d2;
        double d3 = dArr[i];
        boolean z2 = d2 < d3;
        boolean z3 = d < d3;
        if (z == z2) {
            r(dArr, i3, i);
        } else if (z != z3) {
            r(dArr, i, i2);
        }
    }

    public static int o(double[] dArr, int i, int i2) {
        n(dArr, i, i2);
        double d = dArr[i];
        int i3 = i2;
        while (i2 > i) {
            if (dArr[i2] > d) {
                r(dArr, i3, i2);
                i3--;
            }
            i2--;
        }
        r(dArr, i, i3);
        return i3;
    }

    public static void p(int[] iArr, int i, int i2, double[] dArr, int i3, int i4) {
        int i5 = i(iArr, i, i2, i3, i4);
        int i6 = iArr[i5];
        q(i6, dArr, i3, i4);
        int i7 = i5 - 1;
        while (i7 >= i && iArr[i7] == i6) {
            i7--;
        }
        if (i7 >= i) {
            p(iArr, i, i7, dArr, i3, i6 - 1);
        }
        int i8 = i5 + 1;
        while (i8 <= i2 && iArr[i8] == i6) {
            i8++;
        }
        if (i8 <= i2) {
            p(iArr, i8, i2, dArr, i6 + 1, i4);
        }
    }

    public static com.google.common.math.Quantiles.Scale percentiles() {
        return scale(100);
    }

    public static void q(int i, double[] dArr, int i2, int i3) {
        if (i != i2) {
            while (i3 > i2) {
                int o = o(dArr, i2, i3);
                if (o >= i) {
                    i3 = o - 1;
                }
                if (o <= i) {
                    i2 = o + 1;
                }
            }
            return;
        }
        int i4 = i2;
        for (int i5 = i2 + 1; i5 <= i3; i5++) {
            if (dArr[i4] > dArr[i5]) {
                i4 = i5;
            }
        }
        if (i4 != i2) {
            r(dArr, i4, i2);
        }
    }

    public static com.google.common.math.Quantiles.Scale quartiles() {
        return scale(4);
    }

    public static void r(double[] dArr, int i, int i2) {
        double d = dArr[i];
        dArr[i] = dArr[i2];
        dArr[i2] = d;
    }

    public static com.google.common.math.Quantiles.Scale scale(int i) {
        return new com.google.common.math.Quantiles.Scale(i, null);
    }
}
