package com.bytedance.pangle.util.b.a;

/* loaded from: classes.dex */
public final class c {
    public final byte[] a = new byte[2];
    private final byte[] b = new byte[4];

    private static int a(byte[] bArr) {
        return ((bArr[1] & 255) << 8) | (bArr[0] & 255);
    }

    public static void a(byte[] bArr, int i) {
        bArr[1] = (byte) (i >>> 8);
        bArr[0] = (byte) (i & 255);
    }

    private static int b(byte[] bArr) {
        return ((((bArr[3] & 255) << 8) | (bArr[2] & 255)) << 16) | (bArr[0] & 255) | ((bArr[1] & 255) << 8);
    }

    private static void b(byte[] bArr, int i) {
        bArr[3] = (byte) (i >>> 24);
        bArr[2] = (byte) (i >>> 16);
        bArr[1] = (byte) (i >>> 8);
        bArr[0] = (byte) (i & 255);
    }

    public final int a(java.io.RandomAccessFile randomAccessFile) {
        randomAccessFile.readFully(this.b);
        return b(this.b);
    }

    public final void a(java.io.ByteArrayOutputStream byteArrayOutputStream, int i) {
        a(this.a, i);
        byteArrayOutputStream.write(this.a);
    }

    public final void a(java.io.OutputStream outputStream, int i) {
        b(this.b, i);
        outputStream.write(this.b);
    }

    public final int b(java.io.RandomAccessFile randomAccessFile) {
        randomAccessFile.readFully(this.a);
        return a(this.a);
    }
}
