package org.apache.tools.zip;

/* loaded from: classes26.dex */
public final class ZipShort implements java.lang.Cloneable {
    public final int n;

    public ZipShort(int i) {
        this.n = i;
    }

    public ZipShort(byte[] bArr) {
        this(bArr, 0);
    }

    public ZipShort(byte[] bArr, int i) {
        this.n = getValue(bArr, i);
    }

    public static byte[] getBytes(int i) {
        return new byte[]{(byte) (i & 255), (byte) ((i & androidx.core.view.MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8)};
    }

    public static int getValue(byte[] bArr) {
        return getValue(bArr, 0);
    }

    public static int getValue(byte[] bArr, int i) {
        return ((bArr[i + 1] << 8) & androidx.core.view.MotionEventCompat.ACTION_POINTER_INDEX_MASK) + (bArr[i] & 255);
    }

    public static void putShort(int i, byte[] bArr, int i2) {
        bArr[i2] = (byte) (i & 255);
        bArr[i2 + 1] = (byte) ((i & androidx.core.view.MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8);
    }

    public java.lang.Object clone() {
        try {
            return super.clone();
        } catch (java.lang.CloneNotSupportedException e) {
            throw new java.lang.RuntimeException(e);
        }
    }

    public boolean equals(java.lang.Object obj) {
        return obj != null && (obj instanceof org.apache.tools.zip.ZipShort) && this.n == ((org.apache.tools.zip.ZipShort) obj).getValue();
    }

    public byte[] getBytes() {
        byte[] bArr = new byte[2];
        putShort(this.n, bArr, 0);
        return bArr;
    }

    public int getValue() {
        return this.n;
    }

    public int hashCode() {
        return this.n;
    }

    public java.lang.String toString() {
        return "ZipShort value: " + this.n;
    }
}
