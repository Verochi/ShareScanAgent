package org.apache.tools.zip;

/* loaded from: classes26.dex */
public final class ZipEightByteInteger {
    public static final org.apache.tools.zip.ZipEightByteInteger ZERO = new org.apache.tools.zip.ZipEightByteInteger(0);
    public final java.math.BigInteger a;

    public ZipEightByteInteger(long j) {
        this(java.math.BigInteger.valueOf(j));
    }

    public ZipEightByteInteger(java.math.BigInteger bigInteger) {
        this.a = bigInteger;
    }

    public ZipEightByteInteger(byte[] bArr) {
        this(bArr, 0);
    }

    public ZipEightByteInteger(byte[] bArr, int i) {
        this.a = getValue(bArr, i);
    }

    public static byte[] getBytes(long j) {
        return getBytes(java.math.BigInteger.valueOf(j));
    }

    public static byte[] getBytes(java.math.BigInteger bigInteger) {
        long longValue = bigInteger.longValue();
        byte[] bArr = {(byte) (255 & longValue), (byte) ((65280 & longValue) >> 8), (byte) ((16711680 & longValue) >> 16), (byte) ((4278190080L & longValue) >> 24), (byte) ((1095216660480L & longValue) >> 32), (byte) ((280375465082880L & longValue) >> 40), (byte) ((71776119061217280L & longValue) >> 48), (byte) ((longValue & 9151314442816847872L) >> 56)};
        if (bigInteger.testBit(63)) {
            bArr[7] = (byte) (bArr[7] | Byte.MIN_VALUE);
        }
        return bArr;
    }

    public static long getLongValue(byte[] bArr) {
        return getLongValue(bArr, 0);
    }

    public static long getLongValue(byte[] bArr, int i) {
        return getValue(bArr, i).longValue();
    }

    public static java.math.BigInteger getValue(byte[] bArr) {
        return getValue(bArr, 0);
    }

    public static java.math.BigInteger getValue(byte[] bArr, int i) {
        int i2 = i + 7;
        java.math.BigInteger valueOf = java.math.BigInteger.valueOf(((bArr[i2] << 56) & 9151314442816847872L) + ((bArr[i + 6] << 48) & 71776119061217280L) + ((bArr[i + 5] << 40) & 280375465082880L) + ((bArr[i + 4] << 32) & 1095216660480L) + ((bArr[i + 3] << 24) & 4278190080L) + ((bArr[i + 2] << 16) & 16711680) + ((bArr[i + 1] << 8) & 65280) + (bArr[i] & 255));
        return (bArr[i2] & Byte.MIN_VALUE) == -128 ? valueOf.setBit(63) : valueOf;
    }

    public boolean equals(java.lang.Object obj) {
        if (obj == null || !(obj instanceof org.apache.tools.zip.ZipEightByteInteger)) {
            return false;
        }
        return this.a.equals(((org.apache.tools.zip.ZipEightByteInteger) obj).getValue());
    }

    public byte[] getBytes() {
        return getBytes(this.a);
    }

    public long getLongValue() {
        return this.a.longValue();
    }

    public java.math.BigInteger getValue() {
        return this.a;
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    public java.lang.String toString() {
        return "ZipEightByteInteger value: " + this.a;
    }
}
