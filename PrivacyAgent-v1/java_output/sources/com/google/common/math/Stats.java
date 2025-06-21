package com.google.common.math;

@com.google.common.annotations.Beta
@com.google.common.annotations.GwtIncompatible
/* loaded from: classes22.dex */
public final class Stats implements java.io.Serializable {
    static final int BYTES = 40;
    private static final long serialVersionUID = 0;
    private final long count;
    private final double max;
    private final double mean;
    private final double min;
    private final double sumOfSquaresOfDeltas;

    public Stats(long j, double d, double d2, double d3, double d4) {
        this.count = j;
        this.mean = d;
        this.sumOfSquaresOfDeltas = d2;
        this.min = d3;
        this.max = d4;
    }

    public static com.google.common.math.Stats fromByteArray(byte[] bArr) {
        com.google.common.base.Preconditions.checkNotNull(bArr);
        com.google.common.base.Preconditions.checkArgument(bArr.length == 40, "Expected Stats.BYTES = %s remaining , got %s", 40, bArr.length);
        return readFrom(java.nio.ByteBuffer.wrap(bArr).order(java.nio.ByteOrder.LITTLE_ENDIAN));
    }

    public static double meanOf(java.lang.Iterable<? extends java.lang.Number> iterable) {
        return meanOf(iterable.iterator());
    }

    public static double meanOf(java.util.Iterator<? extends java.lang.Number> it) {
        com.google.common.base.Preconditions.checkArgument(it.hasNext());
        double doubleValue = it.next().doubleValue();
        long j = 1;
        while (it.hasNext()) {
            double doubleValue2 = it.next().doubleValue();
            j++;
            doubleValue = (com.google.common.primitives.Doubles.isFinite(doubleValue2) && com.google.common.primitives.Doubles.isFinite(doubleValue)) ? doubleValue + ((doubleValue2 - doubleValue) / j) : com.google.common.math.StatsAccumulator.a(doubleValue, doubleValue2);
        }
        return doubleValue;
    }

    public static double meanOf(double... dArr) {
        com.google.common.base.Preconditions.checkArgument(dArr.length > 0);
        double d = dArr[0];
        for (int i = 1; i < dArr.length; i++) {
            double d2 = dArr[i];
            d = (com.google.common.primitives.Doubles.isFinite(d2) && com.google.common.primitives.Doubles.isFinite(d)) ? d + ((d2 - d) / (i + 1)) : com.google.common.math.StatsAccumulator.a(d, d2);
        }
        return d;
    }

    public static double meanOf(int... iArr) {
        com.google.common.base.Preconditions.checkArgument(iArr.length > 0);
        double d = iArr[0];
        for (int i = 1; i < iArr.length; i++) {
            double d2 = iArr[i];
            d = (com.google.common.primitives.Doubles.isFinite(d2) && com.google.common.primitives.Doubles.isFinite(d)) ? d + ((d2 - d) / (i + 1)) : com.google.common.math.StatsAccumulator.a(d, d2);
        }
        return d;
    }

    public static double meanOf(long... jArr) {
        com.google.common.base.Preconditions.checkArgument(jArr.length > 0);
        double d = jArr[0];
        for (int i = 1; i < jArr.length; i++) {
            double d2 = jArr[i];
            d = (com.google.common.primitives.Doubles.isFinite(d2) && com.google.common.primitives.Doubles.isFinite(d)) ? d + ((d2 - d) / (i + 1)) : com.google.common.math.StatsAccumulator.a(d, d2);
        }
        return d;
    }

    public static com.google.common.math.Stats of(java.lang.Iterable<? extends java.lang.Number> iterable) {
        com.google.common.math.StatsAccumulator statsAccumulator = new com.google.common.math.StatsAccumulator();
        statsAccumulator.addAll(iterable);
        return statsAccumulator.snapshot();
    }

    public static com.google.common.math.Stats of(java.util.Iterator<? extends java.lang.Number> it) {
        com.google.common.math.StatsAccumulator statsAccumulator = new com.google.common.math.StatsAccumulator();
        statsAccumulator.addAll(it);
        return statsAccumulator.snapshot();
    }

    public static com.google.common.math.Stats of(double... dArr) {
        com.google.common.math.StatsAccumulator statsAccumulator = new com.google.common.math.StatsAccumulator();
        statsAccumulator.addAll(dArr);
        return statsAccumulator.snapshot();
    }

    public static com.google.common.math.Stats of(int... iArr) {
        com.google.common.math.StatsAccumulator statsAccumulator = new com.google.common.math.StatsAccumulator();
        statsAccumulator.addAll(iArr);
        return statsAccumulator.snapshot();
    }

    public static com.google.common.math.Stats of(long... jArr) {
        com.google.common.math.StatsAccumulator statsAccumulator = new com.google.common.math.StatsAccumulator();
        statsAccumulator.addAll(jArr);
        return statsAccumulator.snapshot();
    }

    public static com.google.common.math.Stats readFrom(java.nio.ByteBuffer byteBuffer) {
        com.google.common.base.Preconditions.checkNotNull(byteBuffer);
        com.google.common.base.Preconditions.checkArgument(byteBuffer.remaining() >= 40, "Expected at least Stats.BYTES = %s remaining , got %s", 40, byteBuffer.remaining());
        return new com.google.common.math.Stats(byteBuffer.getLong(), byteBuffer.getDouble(), byteBuffer.getDouble(), byteBuffer.getDouble(), byteBuffer.getDouble());
    }

    public long count() {
        return this.count;
    }

    public boolean equals(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
        if (obj == null || com.google.common.math.Stats.class != obj.getClass()) {
            return false;
        }
        com.google.common.math.Stats stats = (com.google.common.math.Stats) obj;
        return this.count == stats.count && java.lang.Double.doubleToLongBits(this.mean) == java.lang.Double.doubleToLongBits(stats.mean) && java.lang.Double.doubleToLongBits(this.sumOfSquaresOfDeltas) == java.lang.Double.doubleToLongBits(stats.sumOfSquaresOfDeltas) && java.lang.Double.doubleToLongBits(this.min) == java.lang.Double.doubleToLongBits(stats.min) && java.lang.Double.doubleToLongBits(this.max) == java.lang.Double.doubleToLongBits(stats.max);
    }

    public int hashCode() {
        return com.google.common.base.Objects.hashCode(java.lang.Long.valueOf(this.count), java.lang.Double.valueOf(this.mean), java.lang.Double.valueOf(this.sumOfSquaresOfDeltas), java.lang.Double.valueOf(this.min), java.lang.Double.valueOf(this.max));
    }

    public double max() {
        com.google.common.base.Preconditions.checkState(this.count != 0);
        return this.max;
    }

    public double mean() {
        com.google.common.base.Preconditions.checkState(this.count != 0);
        return this.mean;
    }

    public double min() {
        com.google.common.base.Preconditions.checkState(this.count != 0);
        return this.min;
    }

    public double populationStandardDeviation() {
        return java.lang.Math.sqrt(populationVariance());
    }

    public double populationVariance() {
        com.google.common.base.Preconditions.checkState(this.count > 0);
        if (java.lang.Double.isNaN(this.sumOfSquaresOfDeltas)) {
            return Double.NaN;
        }
        if (this.count == 1) {
            return 0.0d;
        }
        return com.google.common.math.DoubleUtils.b(this.sumOfSquaresOfDeltas) / count();
    }

    public double sampleStandardDeviation() {
        return java.lang.Math.sqrt(sampleVariance());
    }

    public double sampleVariance() {
        com.google.common.base.Preconditions.checkState(this.count > 1);
        if (java.lang.Double.isNaN(this.sumOfSquaresOfDeltas)) {
            return Double.NaN;
        }
        return com.google.common.math.DoubleUtils.b(this.sumOfSquaresOfDeltas) / (this.count - 1);
    }

    public double sum() {
        return this.mean * this.count;
    }

    public double sumOfSquaresOfDeltas() {
        return this.sumOfSquaresOfDeltas;
    }

    public byte[] toByteArray() {
        java.nio.ByteBuffer order = java.nio.ByteBuffer.allocate(40).order(java.nio.ByteOrder.LITTLE_ENDIAN);
        writeTo(order);
        return order.array();
    }

    public java.lang.String toString() {
        return count() > 0 ? com.google.common.base.MoreObjects.toStringHelper(this).add(me.leolin.shortcutbadger.impl.NewHtcHomeBadger.COUNT, this.count).add("mean", this.mean).add("populationStandardDeviation", populationStandardDeviation()).add(org.apache.tools.ant.types.selectors.DepthSelector.MIN_KEY, this.min).add(org.apache.tools.ant.types.selectors.DepthSelector.MAX_KEY, this.max).toString() : com.google.common.base.MoreObjects.toStringHelper(this).add(me.leolin.shortcutbadger.impl.NewHtcHomeBadger.COUNT, this.count).toString();
    }

    public void writeTo(java.nio.ByteBuffer byteBuffer) {
        com.google.common.base.Preconditions.checkNotNull(byteBuffer);
        com.google.common.base.Preconditions.checkArgument(byteBuffer.remaining() >= 40, "Expected at least Stats.BYTES = %s remaining , got %s", 40, byteBuffer.remaining());
        byteBuffer.putLong(this.count).putDouble(this.mean).putDouble(this.sumOfSquaresOfDeltas).putDouble(this.min).putDouble(this.max);
    }
}
