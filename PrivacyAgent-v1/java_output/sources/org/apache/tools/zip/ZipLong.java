package org.apache.tools.zip;

/* loaded from: classes26.dex */
public final class ZipLong implements java.lang.Cloneable {
    public final long n;
    public static final org.apache.tools.zip.ZipLong CFH_SIG = new org.apache.tools.zip.ZipLong(net.lingala.zip4j.util.InternalZipConstants.CENSIG);
    public static final org.apache.tools.zip.ZipLong LFH_SIG = new org.apache.tools.zip.ZipLong(net.lingala.zip4j.util.InternalZipConstants.LOCSIG);
    public static final org.apache.tools.zip.ZipLong DD_SIG = new org.apache.tools.zip.ZipLong(134695760);
    public static final org.apache.tools.zip.ZipLong t = new org.apache.tools.zip.ZipLong(net.lingala.zip4j.util.InternalZipConstants.ZIP_64_LIMIT);

    public ZipLong(long j) {
        this.n = j;
    }

    public ZipLong(byte[] bArr) {
        this(bArr, 0);
    }

    public ZipLong(byte[] bArr, int i) {
        this.n = getValue(bArr, i);
    }

    public static byte[] getBytes(long j) {
        byte[] bArr = new byte[4];
        putLong(j, bArr, 0);
        return bArr;
    }

    public static long getValue(byte[] bArr) {
        return getValue(bArr, 0);
    }

    public static long getValue(byte[] bArr, int i) {
        return ((bArr[i + 3] << com.google.common.base.Ascii.CAN) & 4278190080L) + ((bArr[i + 2] << 16) & 16711680) + ((bArr[i + 1] << 8) & androidx.core.view.MotionEventCompat.ACTION_POINTER_INDEX_MASK) + (bArr[i] & 255);
    }

    public static void putLong(long j, byte[] bArr, int i) {
        int i2 = i + 1;
        bArr[i] = (byte) (255 & j);
        int i3 = i2 + 1;
        bArr[i2] = (byte) ((65280 & j) >> 8);
        bArr[i3] = (byte) ((16711680 & j) >> 16);
        bArr[i3 + 1] = (byte) ((j & 4278190080L) >> 24);
    }

    public java.lang.Object clone() {
        try {
            return super.clone();
        } catch (java.lang.CloneNotSupportedException e) {
            throw new java.lang.RuntimeException(e);
        }
    }

    public boolean equals(java.lang.Object obj) {
        return obj != null && (obj instanceof org.apache.tools.zip.ZipLong) && this.n == ((org.apache.tools.zip.ZipLong) obj).getValue();
    }

    public byte[] getBytes() {
        return getBytes(this.n);
    }

    public long getValue() {
        return this.n;
    }

    public int hashCode() {
        return (int) this.n;
    }

    public void putLong(byte[] bArr, int i) {
        putLong(this.n, bArr, i);
    }

    public java.lang.String toString() {
        return "ZipLong value: " + this.n;
    }
}
