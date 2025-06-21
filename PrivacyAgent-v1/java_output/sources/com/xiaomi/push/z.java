package com.xiaomi.push;

/* loaded from: classes19.dex */
public final class z {
    private final byte[] a;
    private int b;
    private int c;
    private int d;
    private final java.io.InputStream e;
    private int f;
    private int g;
    private int h;
    private int i;
    private int j;
    private int k;

    private z(java.io.InputStream inputStream) {
        this.h = Integer.MAX_VALUE;
        this.j = 64;
        this.k = 67108864;
        this.a = new byte[4096];
        this.b = 0;
        this.d = 0;
        this.e = inputStream;
    }

    public z(byte[] bArr, int i, int i2) {
        this.h = Integer.MAX_VALUE;
        this.j = 64;
        this.k = 67108864;
        this.a = bArr;
        this.b = i2 + i;
        this.d = i;
        this.e = null;
    }

    public static com.xiaomi.push.z a(java.io.InputStream inputStream) {
        return new com.xiaomi.push.z(inputStream);
    }

    private boolean a(boolean z) {
        int i = this.d;
        int i2 = this.b;
        if (i < i2) {
            throw new java.lang.IllegalStateException("refillBuffer() called when buffer wasn't empty.");
        }
        int i3 = this.g;
        if (i3 + i2 == this.h) {
            if (z) {
                throw com.xiaomi.push.ca.a();
            }
            return false;
        }
        this.g = i3 + i2;
        this.d = 0;
        java.io.InputStream inputStream = this.e;
        int read = inputStream == null ? -1 : inputStream.read(this.a);
        this.b = read;
        if (read == 0 || read < -1) {
            throw new java.lang.IllegalStateException("InputStream#read(byte[]) returned invalid result: " + this.b + "\nThe InputStream implementation is buggy.");
        }
        if (read == -1) {
            this.b = 0;
            if (z) {
                throw com.xiaomi.push.ca.a();
            }
            return false;
        }
        g();
        int i4 = this.g + this.b + this.c;
        if (i4 > this.k || i4 < 0) {
            throw com.xiaomi.push.ca.h();
        }
        return true;
    }

    private byte[] c(int i) {
        if (i < 0) {
            throw com.xiaomi.push.ca.b();
        }
        int i2 = this.g;
        int i3 = this.d;
        int i4 = i2 + i3 + i;
        int i5 = this.h;
        if (i4 > i5) {
            d((i5 - i2) - i3);
            throw com.xiaomi.push.ca.a();
        }
        int i6 = this.b;
        if (i <= i6 - i3) {
            byte[] bArr = new byte[i];
            java.lang.System.arraycopy(this.a, i3, bArr, 0, i);
            this.d += i;
            return bArr;
        }
        if (i >= 4096) {
            this.g = i2 + i6;
            this.d = 0;
            this.b = 0;
            int i7 = i6 - i3;
            int i8 = i - i7;
            java.util.Vector vector = new java.util.Vector();
            while (i8 > 0) {
                int min = java.lang.Math.min(i8, 4096);
                byte[] bArr2 = new byte[min];
                int i9 = 0;
                while (i9 < min) {
                    java.io.InputStream inputStream = this.e;
                    int read = inputStream == null ? -1 : inputStream.read(bArr2, i9, min - i9);
                    if (read == -1) {
                        throw com.xiaomi.push.ca.a();
                    }
                    this.g += read;
                    i9 += read;
                }
                i8 -= min;
                vector.addElement(bArr2);
            }
            byte[] bArr3 = new byte[i];
            java.lang.System.arraycopy(this.a, i3, bArr3, 0, i7);
            for (int i10 = 0; i10 < vector.size(); i10++) {
                byte[] bArr4 = (byte[]) vector.elementAt(i10);
                java.lang.System.arraycopy(bArr4, 0, bArr3, i7, bArr4.length);
                i7 += bArr4.length;
            }
            return bArr3;
        }
        byte[] bArr5 = new byte[i];
        int i11 = i6 - i3;
        java.lang.System.arraycopy(this.a, i3, bArr5, 0, i11);
        this.d = this.b;
        while (true) {
            a(true);
            int i12 = i - i11;
            int i13 = this.b;
            if (i12 <= i13) {
                java.lang.System.arraycopy(this.a, 0, bArr5, i11, i12);
                this.d = i12;
                return bArr5;
            }
            java.lang.System.arraycopy(this.a, 0, bArr5, i11, i13);
            int i14 = this.b;
            i11 += i14;
            this.d = i14;
        }
    }

    private void d(int i) {
        if (i < 0) {
            throw com.xiaomi.push.ca.b();
        }
        int i2 = this.g;
        int i3 = this.d;
        int i4 = i2 + i3 + i;
        int i5 = this.h;
        if (i4 > i5) {
            d((i5 - i2) - i3);
            throw com.xiaomi.push.ca.a();
        }
        int i6 = this.b;
        if (i <= i6 - i3) {
            this.d = i3 + i;
            return;
        }
        int i7 = i6 - i3;
        this.g = i2 + i6;
        this.d = 0;
        this.b = 0;
        while (i7 < i) {
            java.io.InputStream inputStream = this.e;
            int skip = inputStream == null ? -1 : (int) inputStream.skip(i - i7);
            if (skip <= 0) {
                throw com.xiaomi.push.ca.a();
            }
            i7 += skip;
            this.g += skip;
        }
    }

    private void g() {
        int i = this.b + this.c;
        this.b = i;
        int i2 = this.g + i;
        int i3 = this.h;
        if (i2 <= i3) {
            this.c = 0;
            return;
        }
        int i4 = i2 - i3;
        this.c = i4;
        this.b = i - i4;
    }

    private byte h() {
        if (this.d == this.b) {
            a(true);
        }
        byte[] bArr = this.a;
        int i = this.d;
        this.d = i + 1;
        return bArr[i];
    }

    public final int a() {
        if (this.d == this.b && !a(false)) {
            this.f = 0;
            return 0;
        }
        int e = e();
        this.f = e;
        if (e != 0) {
            return e;
        }
        throw com.xiaomi.push.ca.d();
    }

    public final void a(int i) {
        if (this.f != i) {
            throw com.xiaomi.push.ca.e();
        }
    }

    public final void a(com.xiaomi.push.da daVar) {
        int e = e();
        if (this.i >= this.j) {
            throw com.xiaomi.push.ca.g();
        }
        if (e < 0) {
            throw com.xiaomi.push.ca.b();
        }
        int i = e + this.g + this.d;
        int i2 = this.h;
        if (i > i2) {
            throw com.xiaomi.push.ca.a();
        }
        this.h = i;
        g();
        this.i++;
        daVar.b(this);
        a(0);
        this.i--;
        this.h = i2;
        g();
    }

    public final boolean b() {
        return e() != 0;
    }

    public final boolean b(int i) {
        int a;
        int a2 = com.xiaomi.push.dz.a(i);
        if (a2 == 0) {
            e();
            return true;
        }
        if (a2 == 1) {
            h();
            h();
            h();
            h();
            h();
            h();
            h();
            h();
            return true;
        }
        if (a2 == 2) {
            d(e());
            return true;
        }
        if (a2 == 3) {
            do {
                a = a();
                if (a == 0) {
                    break;
                }
            } while (b(a));
            a(com.xiaomi.push.dz.a(com.xiaomi.push.dz.b(i), 4));
            return true;
        }
        if (a2 == 4) {
            return false;
        }
        if (a2 != 5) {
            throw com.xiaomi.push.ca.f();
        }
        h();
        h();
        h();
        h();
        return true;
    }

    public final java.lang.String c() {
        int e = e();
        int i = this.b;
        int i2 = this.d;
        if (e > i - i2 || e <= 0) {
            return new java.lang.String(c(e), "UTF-8");
        }
        java.lang.String str = new java.lang.String(this.a, i2, e, "UTF-8");
        this.d += e;
        return str;
    }

    public final com.xiaomi.push.a d() {
        int e = e();
        int i = this.b;
        int i2 = this.d;
        if (e > i - i2 || e <= 0) {
            return com.xiaomi.push.a.a(c(e));
        }
        com.xiaomi.push.a a = com.xiaomi.push.a.a(this.a, i2, e);
        this.d += e;
        return a;
    }

    public final int e() {
        int i;
        byte h = h();
        if (h >= 0) {
            return h;
        }
        int i2 = h & Byte.MAX_VALUE;
        byte h2 = h();
        if (h2 >= 0) {
            i = h2 << 7;
        } else {
            i2 |= (h2 & Byte.MAX_VALUE) << 7;
            byte h3 = h();
            if (h3 >= 0) {
                i = h3 << 14;
            } else {
                i2 |= (h3 & Byte.MAX_VALUE) << 14;
                byte h4 = h();
                if (h4 < 0) {
                    int i3 = i2 | ((h4 & Byte.MAX_VALUE) << 21);
                    byte h5 = h();
                    int i4 = i3 | (h5 << com.google.common.base.Ascii.FS);
                    if (h5 >= 0) {
                        return i4;
                    }
                    for (int i5 = 0; i5 < 5; i5++) {
                        if (h() >= 0) {
                            return i4;
                        }
                    }
                    throw com.xiaomi.push.ca.c();
                }
                i = h4 << com.google.common.base.Ascii.NAK;
            }
        }
        return i2 | i;
    }

    public final long f() {
        long j = 0;
        for (int i = 0; i < 64; i += 7) {
            j |= (r3 & Byte.MAX_VALUE) << i;
            if ((h() & 128) == 0) {
                return j;
            }
        }
        throw com.xiaomi.push.ca.c();
    }
}
