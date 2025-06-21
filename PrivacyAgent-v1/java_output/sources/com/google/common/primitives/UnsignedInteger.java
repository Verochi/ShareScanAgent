package com.google.common.primitives;

@com.google.common.annotations.GwtCompatible(emulated = true)
/* loaded from: classes22.dex */
public final class UnsignedInteger extends java.lang.Number implements java.lang.Comparable<com.google.common.primitives.UnsignedInteger> {
    private final int value;
    public static final com.google.common.primitives.UnsignedInteger ZERO = fromIntBits(0);
    public static final com.google.common.primitives.UnsignedInteger ONE = fromIntBits(1);
    public static final com.google.common.primitives.UnsignedInteger MAX_VALUE = fromIntBits(-1);

    private UnsignedInteger(int i) {
        this.value = i & (-1);
    }

    public static com.google.common.primitives.UnsignedInteger fromIntBits(int i) {
        return new com.google.common.primitives.UnsignedInteger(i);
    }

    public static com.google.common.primitives.UnsignedInteger valueOf(long j) {
        com.google.common.base.Preconditions.checkArgument((net.lingala.zip4j.util.InternalZipConstants.ZIP_64_LIMIT & j) == j, "value (%s) is outside the range for an unsigned integer value", j);
        return fromIntBits((int) j);
    }

    public static com.google.common.primitives.UnsignedInteger valueOf(java.lang.String str) {
        return valueOf(str, 10);
    }

    public static com.google.common.primitives.UnsignedInteger valueOf(java.lang.String str, int i) {
        return fromIntBits(com.google.common.primitives.UnsignedInts.parseUnsignedInt(str, i));
    }

    public static com.google.common.primitives.UnsignedInteger valueOf(java.math.BigInteger bigInteger) {
        com.google.common.base.Preconditions.checkNotNull(bigInteger);
        com.google.common.base.Preconditions.checkArgument(bigInteger.signum() >= 0 && bigInteger.bitLength() <= 32, "value (%s) is outside the range for an unsigned integer value", bigInteger);
        return fromIntBits(bigInteger.intValue());
    }

    public java.math.BigInteger bigIntegerValue() {
        return java.math.BigInteger.valueOf(longValue());
    }

    @Override // java.lang.Comparable
    public int compareTo(com.google.common.primitives.UnsignedInteger unsignedInteger) {
        com.google.common.base.Preconditions.checkNotNull(unsignedInteger);
        return com.google.common.primitives.UnsignedInts.compare(this.value, unsignedInteger.value);
    }

    public com.google.common.primitives.UnsignedInteger dividedBy(com.google.common.primitives.UnsignedInteger unsignedInteger) {
        return fromIntBits(com.google.common.primitives.UnsignedInts.divide(this.value, ((com.google.common.primitives.UnsignedInteger) com.google.common.base.Preconditions.checkNotNull(unsignedInteger)).value));
    }

    @Override // java.lang.Number
    public double doubleValue() {
        return longValue();
    }

    public boolean equals(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
        return (obj instanceof com.google.common.primitives.UnsignedInteger) && this.value == ((com.google.common.primitives.UnsignedInteger) obj).value;
    }

    @Override // java.lang.Number
    public float floatValue() {
        return longValue();
    }

    public int hashCode() {
        return this.value;
    }

    @Override // java.lang.Number
    public int intValue() {
        return this.value;
    }

    @Override // java.lang.Number
    public long longValue() {
        return com.google.common.primitives.UnsignedInts.toLong(this.value);
    }

    public com.google.common.primitives.UnsignedInteger minus(com.google.common.primitives.UnsignedInteger unsignedInteger) {
        return fromIntBits(this.value - ((com.google.common.primitives.UnsignedInteger) com.google.common.base.Preconditions.checkNotNull(unsignedInteger)).value);
    }

    public com.google.common.primitives.UnsignedInteger mod(com.google.common.primitives.UnsignedInteger unsignedInteger) {
        return fromIntBits(com.google.common.primitives.UnsignedInts.remainder(this.value, ((com.google.common.primitives.UnsignedInteger) com.google.common.base.Preconditions.checkNotNull(unsignedInteger)).value));
    }

    public com.google.common.primitives.UnsignedInteger plus(com.google.common.primitives.UnsignedInteger unsignedInteger) {
        return fromIntBits(this.value + ((com.google.common.primitives.UnsignedInteger) com.google.common.base.Preconditions.checkNotNull(unsignedInteger)).value);
    }

    @com.google.common.annotations.GwtIncompatible
    public com.google.common.primitives.UnsignedInteger times(com.google.common.primitives.UnsignedInteger unsignedInteger) {
        return fromIntBits(this.value * ((com.google.common.primitives.UnsignedInteger) com.google.common.base.Preconditions.checkNotNull(unsignedInteger)).value);
    }

    public java.lang.String toString() {
        return toString(10);
    }

    public java.lang.String toString(int i) {
        return com.google.common.primitives.UnsignedInts.toString(this.value, i);
    }
}
