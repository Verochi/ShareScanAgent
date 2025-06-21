package com.google.common.math;

@com.google.common.annotations.Beta
@com.google.common.annotations.GwtIncompatible
/* loaded from: classes22.dex */
public final class PairedStatsAccumulator {
    public final com.google.common.math.StatsAccumulator a = new com.google.common.math.StatsAccumulator();
    public final com.google.common.math.StatsAccumulator b = new com.google.common.math.StatsAccumulator();
    public double c = 0.0d;

    public static double a(double d) {
        if (d >= 1.0d) {
            return 1.0d;
        }
        if (d <= -1.0d) {
            return -1.0d;
        }
        return d;
    }

    public void add(double d, double d2) {
        this.a.add(d);
        if (!com.google.common.primitives.Doubles.isFinite(d) || !com.google.common.primitives.Doubles.isFinite(d2)) {
            this.c = Double.NaN;
        } else if (this.a.count() > 1) {
            this.c += (d - this.a.mean()) * (d2 - this.b.mean());
        }
        this.b.add(d2);
    }

    public void addAll(com.google.common.math.PairedStats pairedStats) {
        if (pairedStats.count() == 0) {
            return;
        }
        this.a.addAll(pairedStats.xStats());
        if (this.b.count() == 0) {
            this.c = pairedStats.sumOfProductsOfDeltas();
        } else {
            this.c += pairedStats.sumOfProductsOfDeltas() + ((pairedStats.xStats().mean() - this.a.mean()) * (pairedStats.yStats().mean() - this.b.mean()) * pairedStats.count());
        }
        this.b.addAll(pairedStats.yStats());
    }

    public final double b(double d) {
        if (d > 0.0d) {
            return d;
        }
        return Double.MIN_VALUE;
    }

    public long count() {
        return this.a.count();
    }

    public final com.google.common.math.LinearTransformation leastSquaresFit() {
        com.google.common.base.Preconditions.checkState(count() > 1);
        if (java.lang.Double.isNaN(this.c)) {
            return com.google.common.math.LinearTransformation.forNaN();
        }
        double b = this.a.b();
        if (b > 0.0d) {
            return this.b.b() > 0.0d ? com.google.common.math.LinearTransformation.mapping(this.a.mean(), this.b.mean()).withSlope(this.c / b) : com.google.common.math.LinearTransformation.horizontal(this.b.mean());
        }
        com.google.common.base.Preconditions.checkState(this.b.b() > 0.0d);
        return com.google.common.math.LinearTransformation.vertical(this.a.mean());
    }

    public final double pearsonsCorrelationCoefficient() {
        com.google.common.base.Preconditions.checkState(count() > 1);
        if (java.lang.Double.isNaN(this.c)) {
            return Double.NaN;
        }
        double b = this.a.b();
        double b2 = this.b.b();
        com.google.common.base.Preconditions.checkState(b > 0.0d);
        com.google.common.base.Preconditions.checkState(b2 > 0.0d);
        return a(this.c / java.lang.Math.sqrt(b(b * b2)));
    }

    public double populationCovariance() {
        com.google.common.base.Preconditions.checkState(count() != 0);
        return this.c / count();
    }

    public final double sampleCovariance() {
        com.google.common.base.Preconditions.checkState(count() > 1);
        return this.c / (count() - 1);
    }

    public com.google.common.math.PairedStats snapshot() {
        return new com.google.common.math.PairedStats(this.a.snapshot(), this.b.snapshot(), this.c);
    }

    public com.google.common.math.Stats xStats() {
        return this.a.snapshot();
    }

    public com.google.common.math.Stats yStats() {
        return this.b.snapshot();
    }
}
