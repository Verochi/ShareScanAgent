package com.google.common.math;

@com.google.common.annotations.Beta
@com.google.common.annotations.GwtIncompatible
/* loaded from: classes22.dex */
public final class StatsAccumulator {
    public long a = 0;
    public double b = 0.0d;
    public double c = 0.0d;
    public double d = Double.NaN;
    public double e = Double.NaN;

    public static double a(double d, double d2) {
        if (com.google.common.primitives.Doubles.isFinite(d)) {
            return d2;
        }
        if (com.google.common.primitives.Doubles.isFinite(d2) || d == d2) {
            return d;
        }
        return Double.NaN;
    }

    public void add(double d) {
        long j = this.a;
        if (j == 0) {
            this.a = 1L;
            this.b = d;
            this.d = d;
            this.e = d;
            if (com.google.common.primitives.Doubles.isFinite(d)) {
                return;
            }
            this.c = Double.NaN;
            return;
        }
        this.a = j + 1;
        if (com.google.common.primitives.Doubles.isFinite(d) && com.google.common.primitives.Doubles.isFinite(this.b)) {
            double d2 = this.b;
            double d3 = d - d2;
            double d4 = d2 + (d3 / this.a);
            this.b = d4;
            this.c += d3 * (d - d4);
        } else {
            this.b = a(this.b, d);
            this.c = Double.NaN;
        }
        this.d = java.lang.Math.min(this.d, d);
        this.e = java.lang.Math.max(this.e, d);
    }

    public void addAll(com.google.common.math.Stats stats) {
        if (stats.count() == 0) {
            return;
        }
        long j = this.a;
        if (j == 0) {
            this.a = stats.count();
            this.b = stats.mean();
            this.c = stats.sumOfSquaresOfDeltas();
            this.d = stats.min();
            this.e = stats.max();
            return;
        }
        this.a = j + stats.count();
        if (com.google.common.primitives.Doubles.isFinite(this.b) && com.google.common.primitives.Doubles.isFinite(stats.mean())) {
            double mean = stats.mean();
            double d = this.b;
            double d2 = mean - d;
            this.b = d + ((stats.count() * d2) / this.a);
            this.c += stats.sumOfSquaresOfDeltas() + (d2 * (stats.mean() - this.b) * stats.count());
        } else {
            this.b = a(this.b, stats.mean());
            this.c = Double.NaN;
        }
        this.d = java.lang.Math.min(this.d, stats.min());
        this.e = java.lang.Math.max(this.e, stats.max());
    }

    public void addAll(java.lang.Iterable<? extends java.lang.Number> iterable) {
        java.util.Iterator<? extends java.lang.Number> it = iterable.iterator();
        while (it.hasNext()) {
            add(it.next().doubleValue());
        }
    }

    public void addAll(java.util.Iterator<? extends java.lang.Number> it) {
        while (it.hasNext()) {
            add(it.next().doubleValue());
        }
    }

    public void addAll(double... dArr) {
        for (double d : dArr) {
            add(d);
        }
    }

    public void addAll(int... iArr) {
        for (int i : iArr) {
            add(i);
        }
    }

    public void addAll(long... jArr) {
        for (long j : jArr) {
            add(j);
        }
    }

    public double b() {
        return this.c;
    }

    public long count() {
        return this.a;
    }

    public double max() {
        com.google.common.base.Preconditions.checkState(this.a != 0);
        return this.e;
    }

    public double mean() {
        com.google.common.base.Preconditions.checkState(this.a != 0);
        return this.b;
    }

    public double min() {
        com.google.common.base.Preconditions.checkState(this.a != 0);
        return this.d;
    }

    public final double populationStandardDeviation() {
        return java.lang.Math.sqrt(populationVariance());
    }

    public final double populationVariance() {
        com.google.common.base.Preconditions.checkState(this.a != 0);
        if (java.lang.Double.isNaN(this.c)) {
            return Double.NaN;
        }
        if (this.a == 1) {
            return 0.0d;
        }
        return com.google.common.math.DoubleUtils.b(this.c) / this.a;
    }

    public final double sampleStandardDeviation() {
        return java.lang.Math.sqrt(sampleVariance());
    }

    public final double sampleVariance() {
        com.google.common.base.Preconditions.checkState(this.a > 1);
        if (java.lang.Double.isNaN(this.c)) {
            return Double.NaN;
        }
        return com.google.common.math.DoubleUtils.b(this.c) / (this.a - 1);
    }

    public com.google.common.math.Stats snapshot() {
        return new com.google.common.math.Stats(this.a, this.b, this.c, this.d, this.e);
    }

    public final double sum() {
        return this.b * this.a;
    }
}
