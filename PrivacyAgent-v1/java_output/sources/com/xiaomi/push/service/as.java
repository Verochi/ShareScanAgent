package com.xiaomi.push.service;

/* loaded from: classes19.dex */
public final class as {
    private static int a = 8;
    private int e = -666;
    private byte[] b = new byte[256];
    private int d = 0;
    private int c = 0;

    private static int a(byte b) {
        return b >= 0 ? b : b + 256;
    }

    private void a() {
        this.d = 0;
        this.c = 0;
    }

    private void a(byte[] bArr) {
        int length = bArr.length;
        int i = 0;
        for (int i2 = 0; i2 < 256; i2++) {
            this.b[i2] = (byte) i2;
        }
        this.d = 0;
        while (true) {
            this.c = i;
            int i3 = this.c;
            if (i3 >= 256) {
                return;
            }
            int a2 = ((this.d + a(this.b[i3])) + a(bArr[this.c % length])) % 256;
            this.d = a2;
            a(this.b, this.c, a2);
            i = this.c + 1;
        }
    }

    private static void a(byte[] bArr, int i, int i2) {
        byte b = bArr[i];
        bArr[i] = bArr[i2];
        bArr[i2] = b;
    }

    public static byte[] a(java.lang.String str, java.lang.String str2) {
        byte[] b = com.xiaomi.push.al.b(str);
        byte[] bytes = str2.getBytes();
        byte[] bArr = new byte[b.length + 1 + bytes.length];
        for (int i = 0; i < b.length; i++) {
            bArr[i] = b[i];
        }
        bArr[b.length] = 95;
        for (int i2 = 0; i2 < bytes.length; i2++) {
            bArr[b.length + 1 + i2] = bytes[i2];
        }
        return bArr;
    }

    public static byte[] a(byte[] bArr, java.lang.String str) {
        return a(bArr, com.xiaomi.push.al.b(str));
    }

    public static byte[] a(byte[] bArr, byte[] bArr2) {
        byte[] bArr3 = new byte[bArr2.length];
        com.xiaomi.push.service.as asVar = new com.xiaomi.push.service.as();
        asVar.a(bArr);
        asVar.a();
        for (int i = 0; i < bArr2.length; i++) {
            bArr3[i] = (byte) (bArr2[i] ^ asVar.b());
        }
        return bArr3;
    }

    public static byte[] a(byte[] bArr, byte[] bArr2, int i, int i2) {
        if (i < 0 || i > bArr2.length || i + i2 > bArr2.length) {
            throw new java.lang.IllegalArgumentException("start = " + i + " len = " + i2);
        }
        com.xiaomi.push.service.as asVar = new com.xiaomi.push.service.as();
        asVar.a(bArr);
        asVar.a();
        for (int i3 = 0; i3 < i2; i3++) {
            int i4 = i + i3;
            bArr2[i4] = (byte) (bArr2[i4] ^ asVar.b());
        }
        return bArr2;
    }

    private byte b() {
        int i = (this.c + 1) % 256;
        this.c = i;
        int a2 = (this.d + a(this.b[i])) % 256;
        this.d = a2;
        a(this.b, this.c, a2);
        byte[] bArr = this.b;
        return bArr[(a(bArr[this.c]) + a(this.b[this.d])) % 256];
    }
}
