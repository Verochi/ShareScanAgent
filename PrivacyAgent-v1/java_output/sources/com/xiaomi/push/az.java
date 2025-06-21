package com.xiaomi.push;

/* loaded from: classes19.dex */
public final class az {
    public final java.io.OutputStream a;
    private final byte[] b;
    private final int c;
    private int d;

    public static class a extends java.io.IOException {
        public a() {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.");
        }
    }

    public az(java.io.OutputStream outputStream, byte[] bArr) {
        this.a = outputStream;
        this.b = bArr;
        this.d = 0;
        this.c = 4096;
    }

    private az(byte[] bArr, int i, int i2) {
        this.a = null;
        this.b = bArr;
        this.d = i;
        this.c = i + i2;
    }

    public static int a(long j) {
        return c(2) + c(j);
    }

    public static int a(java.lang.String str) {
        try {
            byte[] bytes = str.getBytes("UTF-8");
            return e(bytes.length) + bytes.length;
        } catch (java.io.UnsupportedEncodingException unused) {
            throw new java.lang.RuntimeException("UTF-8 not supported.");
        }
    }

    public static com.xiaomi.push.az a(byte[] bArr, int i, int i2) {
        return new com.xiaomi.push.az(bArr, i, i2);
    }

    private void a(byte b) {
        if (this.d == this.c) {
            a();
        }
        byte[] bArr = this.b;
        int i = this.d;
        this.d = i + 1;
        bArr[i] = b;
    }

    private void a(byte[] bArr, int i) {
        int i2 = this.c;
        int i3 = this.d;
        if (i2 - i3 >= i) {
            java.lang.System.arraycopy(bArr, 0, this.b, i3, i);
            this.d += i;
            return;
        }
        int i4 = i2 - i3;
        java.lang.System.arraycopy(bArr, 0, this.b, i3, i4);
        int i5 = i4 + 0;
        int i6 = i - i4;
        this.d = this.c;
        a();
        if (i6 > this.c) {
            this.a.write(bArr, i5, i6);
        } else {
            java.lang.System.arraycopy(bArr, i5, this.b, 0, i6);
            this.d = i6;
        }
    }

    public static int b(int i) {
        return c(1) + e(i);
    }

    public static int b(int i, int i2) {
        return c(i) + (i2 >= 0 ? e(i2) : 10);
    }

    public static int b(int i, long j) {
        return c(i) + c(j);
    }

    public static int b(int i, com.xiaomi.push.da daVar) {
        int c = c(i);
        int b = daVar.b();
        return c + e(b) + b;
    }

    public static int b(int i, java.lang.String str) {
        return c(i) + a(str);
    }

    public static int b(com.xiaomi.push.a aVar) {
        return c(1) + e(aVar.a.length) + aVar.a.length;
    }

    public static int c(int i) {
        return e(com.xiaomi.push.dz.a(i, 0));
    }

    private static int c(long j) {
        if (((-128) & j) == 0) {
            return 1;
        }
        if (((-16384) & j) == 0) {
            return 2;
        }
        if (((-2097152) & j) == 0) {
            return 3;
        }
        if (((-268435456) & j) == 0) {
            return 4;
        }
        if (((-34359738368L) & j) == 0) {
            return 5;
        }
        if (((-4398046511104L) & j) == 0) {
            return 6;
        }
        if (((-562949953421312L) & j) == 0) {
            return 7;
        }
        if (((-72057594037927936L) & j) == 0) {
            return 8;
        }
        return (j & Long.MIN_VALUE) == 0 ? 9 : 10;
    }

    private void d(int i) {
        while ((i & com.alipay.sdk.m.n.a.g) != 0) {
            a((byte) ((i & 127) | 128));
            i >>>= 7;
        }
        a((byte) i);
    }

    private static int e(int i) {
        if ((i & com.alipay.sdk.m.n.a.g) == 0) {
            return 1;
        }
        if ((i & (-16384)) == 0) {
            return 2;
        }
        if (((-2097152) & i) == 0) {
            return 3;
        }
        return (i & (-268435456)) == 0 ? 4 : 5;
    }

    public final void a() {
        java.io.OutputStream outputStream = this.a;
        if (outputStream == null) {
            throw new com.xiaomi.push.az.a();
        }
        outputStream.write(this.b, 0, this.d);
        this.d = 0;
    }

    public final void a(int i) {
        c(1, 0);
        d(i);
    }

    public final void a(int i, int i2) {
        c(i, 0);
        if (i2 >= 0) {
            d(i2);
        } else {
            b(i2);
        }
    }

    public final void a(int i, long j) {
        c(i, 0);
        b(j);
    }

    public final void a(int i, com.xiaomi.push.da daVar) {
        c(i, 2);
        d(daVar.a());
        daVar.a(this);
    }

    public final void a(int i, java.lang.String str) {
        c(i, 2);
        byte[] bytes = str.getBytes("UTF-8");
        d(bytes.length);
        a(bytes, bytes.length);
    }

    public final void a(int i, boolean z) {
        c(i, 0);
        a(z ? (byte) 1 : (byte) 0);
    }

    public final void a(com.xiaomi.push.a aVar) {
        c(1, 2);
        byte[] bArr = aVar.a;
        int length = bArr.length;
        byte[] bArr2 = new byte[length];
        java.lang.System.arraycopy(bArr, 0, bArr2, 0, length);
        d(length);
        a(bArr2, length);
    }

    public final void b() {
        if (this.a != null) {
            throw new java.lang.UnsupportedOperationException("spaceLeft() can only be called on CodedOutputStreams that are writing to a flat array.");
        }
        if (this.c - this.d != 0) {
            throw new java.lang.IllegalStateException("Did not write as much data as expected.");
        }
    }

    public final void b(long j) {
        while (((-128) & j) != 0) {
            a((byte) ((((int) j) & 127) | 128));
            j >>>= 7;
        }
        a((byte) j);
    }

    public final void c(int i, int i2) {
        d(com.xiaomi.push.dz.a(i, i2));
    }
}
