package org.apache.tools.bzip2;

/* loaded from: classes26.dex */
public class CBZip2InputStream extends java.io.InputStream implements org.apache.tools.bzip2.BZip2Constants {
    public java.io.InputStream A;
    public final boolean B;
    public int C;
    public int D;
    public int E;
    public int F;
    public int G;
    public int H;
    public int I;
    public int J;
    public int K;
    public int L;
    public int M;
    public int N;
    public int O;
    public int P;
    public char Q;
    public org.apache.tools.bzip2.CBZip2InputStream.Data R;
    public int n;
    public int t;
    public int u;
    public boolean v;
    public int w;
    public int x;
    public final org.apache.tools.bzip2.CRC y;
    public int z;

    public static final class Data {
        public final boolean[] a = new boolean[256];
        public final byte[] b = new byte[256];
        public final byte[] c = new byte[org.apache.tools.bzip2.BZip2Constants.MAX_SELECTORS];
        public final byte[] d = new byte[org.apache.tools.bzip2.BZip2Constants.MAX_SELECTORS];
        public final int[] e = new int[256];
        public final int[][] f;
        public final int[][] g;
        public final int[][] h;
        public final int[] i;
        public final int[] j;
        public final char[] k;
        public final char[][] l;
        public final byte[] m;
        public int[] n;
        public byte[] o;

        public Data(int i) {
            java.lang.Class cls = java.lang.Integer.TYPE;
            this.f = (int[][]) java.lang.reflect.Array.newInstance((java.lang.Class<?>) cls, 6, 258);
            this.g = (int[][]) java.lang.reflect.Array.newInstance((java.lang.Class<?>) cls, 6, 258);
            this.h = (int[][]) java.lang.reflect.Array.newInstance((java.lang.Class<?>) cls, 6, 258);
            this.i = new int[6];
            this.j = new int[257];
            this.k = new char[256];
            this.l = (char[][]) java.lang.reflect.Array.newInstance((java.lang.Class<?>) java.lang.Character.TYPE, 6, 258);
            this.m = new byte[6];
            this.o = new byte[i * 100000];
        }

        public final int[] a(int i) {
            int[] iArr = this.n;
            if (iArr != null && iArr.length >= i) {
                return iArr;
            }
            int[] iArr2 = new int[i];
            this.n = iArr2;
            return iArr2;
        }
    }

    public CBZip2InputStream(java.io.InputStream inputStream) throws java.io.IOException {
        this(inputStream, false);
    }

    public CBZip2InputStream(java.io.InputStream inputStream, boolean z) throws java.io.IOException {
        this.y = new org.apache.tools.bzip2.CRC();
        this.C = -1;
        this.D = 1;
        this.A = inputStream;
        this.B = z;
        n(true);
        o();
        t();
    }

    public static void m(int[] iArr, int[] iArr2, int[] iArr3, char[] cArr, int i, int i2, int i3) {
        int i4 = 0;
        int i5 = 0;
        for (int i6 = i; i6 <= i2; i6++) {
            for (int i7 = 0; i7 < i3; i7++) {
                if (cArr[i7] == i6) {
                    iArr3[i5] = i7;
                    i5++;
                }
            }
        }
        int i8 = 23;
        while (true) {
            i8--;
            if (i8 <= 0) {
                break;
            }
            iArr2[i8] = 0;
            iArr[i8] = 0;
        }
        for (int i9 = 0; i9 < i3; i9++) {
            int i10 = cArr[i9] + 1;
            iArr2[i10] = iArr2[i10] + 1;
        }
        int i11 = iArr2[0];
        for (int i12 = 1; i12 < 23; i12++) {
            i11 += iArr2[i12];
            iArr2[i12] = i11;
        }
        int i13 = iArr2[i];
        int i14 = i;
        while (i14 <= i2) {
            int i15 = i14 + 1;
            int i16 = iArr2[i15];
            int i17 = i4 + (i16 - i13);
            iArr[i14] = i17 - 1;
            i4 = i17 << 1;
            i14 = i15;
            i13 = i16;
        }
        for (int i18 = i + 1; i18 <= i2; i18++) {
            iArr2[i18] = ((iArr[i18 - 1] + 1) << 1) - iArr2[i18];
        }
    }

    public static void s() throws java.io.IOException {
        java.lang.System.err.println("BZip2 CRC error");
    }

    public final boolean a() throws java.io.IOException {
        int i = this.x;
        int i2 = this.w;
        if (i < 1) {
            int read = this.A.read();
            if (read < 0) {
                throw new java.io.IOException("unexpected end of stream");
            }
            i2 = (i2 << 8) | read;
            i += 8;
            this.w = i2;
        }
        int i3 = i - 1;
        this.x = i3;
        return ((i2 >> i3) & 1) != 0;
    }

    public final int c() throws java.io.IOException {
        return f(8) | (((((f(8) << 8) | f(8)) << 8) | f(8)) << 8);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws java.io.IOException {
        java.io.InputStream inputStream = this.A;
        if (inputStream != null) {
            try {
                if (inputStream != java.lang.System.in) {
                    inputStream.close();
                }
            } finally {
                this.R = null;
                this.A = null;
            }
        }
    }

    public final char e() throws java.io.IOException {
        return (char) f(8);
    }

    public final int f(int i) throws java.io.IOException {
        int i2 = this.x;
        int i3 = this.w;
        if (i2 < i) {
            java.io.InputStream inputStream = this.A;
            do {
                int read = inputStream.read();
                if (read < 0) {
                    throw new java.io.IOException("unexpected end of stream");
                }
                i3 = (i3 << 8) | read;
                i2 += 8;
            } while (i2 < i);
            this.w = i3;
        }
        int i4 = i2 - i;
        this.x = i4;
        return ((1 << i) - 1) & (i3 >> i4);
    }

    public final boolean g() throws java.io.IOException {
        int c = c();
        this.F = c;
        this.D = 0;
        this.R = null;
        if (c != this.H) {
            s();
        }
        return (this.B && n(false)) ? false : true;
    }

    public final void h(int i, int i2) {
        org.apache.tools.bzip2.CBZip2InputStream.Data data = this.R;
        char[][] cArr = data.l;
        int[] iArr = data.i;
        int[][] iArr2 = data.f;
        int[][] iArr3 = data.g;
        int[][] iArr4 = data.h;
        for (int i3 = 0; i3 < i2; i3++) {
            char[] cArr2 = cArr[i3];
            char c = ' ';
            int i4 = i;
            char c2 = 0;
            while (true) {
                i4--;
                if (i4 >= 0) {
                    char c3 = cArr2[i4];
                    if (c3 > c2) {
                        c2 = c3;
                    }
                    if (c3 < c) {
                        c = c3;
                    }
                }
            }
            m(iArr2[i3], iArr3[i3], iArr4[i3], cArr[i3], c, c2, i);
            iArr[i3] = c;
        }
    }

    public final void j() throws java.io.IOException {
        int a = this.y.a();
        this.G = a;
        int i = this.E;
        if (i != a) {
            int i2 = this.F;
            this.H = ((i2 >>> 31) | (i2 << 1)) ^ i;
            s();
        }
        int i3 = this.H;
        this.H = ((i3 >>> 31) | (i3 << 1)) ^ this.G;
    }

    public final void k() throws java.io.IOException {
        int i;
        char c;
        int i2;
        org.apache.tools.bzip2.CBZip2InputStream cBZip2InputStream = this;
        cBZip2InputStream.t = cBZip2InputStream.f(24);
        r();
        java.io.InputStream inputStream = cBZip2InputStream.A;
        org.apache.tools.bzip2.CBZip2InputStream.Data data = cBZip2InputStream.R;
        byte[] bArr = data.o;
        int[] iArr = data.e;
        byte[] bArr2 = data.c;
        byte[] bArr3 = data.b;
        char[] cArr = data.k;
        int[] iArr2 = data.i;
        int[][] iArr3 = data.f;
        int[][] iArr4 = data.g;
        int[][] iArr5 = data.h;
        int i3 = cBZip2InputStream.u * 100000;
        int i4 = 256;
        while (true) {
            i4--;
            if (i4 < 0) {
                break;
            }
            cArr[i4] = (char) i4;
            iArr[i4] = 0;
        }
        int i5 = cBZip2InputStream.z + 1;
        int l = cBZip2InputStream.l(0);
        int i6 = cBZip2InputStream.w;
        int i7 = cBZip2InputStream.x;
        int i8 = bArr2[0] & 255;
        int[] iArr6 = iArr4[i8];
        int[] iArr7 = iArr3[i8];
        int[] iArr8 = iArr5[i8];
        int i9 = i7;
        int i10 = l;
        int i11 = -1;
        int i12 = 0;
        int i13 = 49;
        int i14 = iArr2[i8];
        int i15 = i6;
        while (i10 != i5) {
            int i16 = i5;
            int i17 = i15;
            if (i10 == 0 || i10 == 1) {
                byte[] bArr4 = bArr3;
                int i18 = i3;
                int i19 = 1;
                int i20 = -1;
                while (true) {
                    if (i10 == 0) {
                        i20 += i19;
                    } else if (i10 == 1) {
                        i20 += i19 << 1;
                    } else {
                        int[][] iArr9 = iArr5;
                        byte[] bArr5 = bArr2;
                        byte b = bArr4[cArr[0]];
                        int i21 = b & 255;
                        iArr[i21] = iArr[i21] + i20 + 1;
                        while (true) {
                            int i22 = i20 - 1;
                            if (i20 < 0) {
                                break;
                            }
                            i11++;
                            bArr[i11] = b;
                            i20 = i22;
                        }
                        i3 = i18;
                        if (i11 >= i3) {
                            throw new java.io.IOException("block overrun");
                        }
                        cBZip2InputStream = this;
                        i5 = i16;
                        i15 = i17;
                        bArr3 = bArr4;
                        iArr5 = iArr9;
                        bArr2 = bArr5;
                    }
                    if (i13 == 0) {
                        i12++;
                        int i23 = bArr2[i12] & 255;
                        iArr6 = iArr4[i23];
                        iArr7 = iArr3[i23];
                        iArr8 = iArr5[i23];
                        i = iArr2[i23];
                        i13 = 49;
                    } else {
                        i13--;
                        i = i14;
                    }
                    int i24 = i9;
                    while (i24 < i) {
                        int read = inputStream.read();
                        if (read < 0) {
                            throw new java.io.IOException("unexpected end of stream");
                        }
                        i17 = (i17 << 8) | read;
                        i24 += 8;
                    }
                    int i25 = i24 - i;
                    int[][] iArr10 = iArr5;
                    i9 = i25;
                    int i26 = (i17 >> i25) & ((1 << i) - 1);
                    int i27 = i;
                    while (i26 > iArr7[i27]) {
                        int i28 = i27 + 1;
                        byte[] bArr6 = bArr2;
                        int i29 = i9;
                        while (i29 < 1) {
                            int read2 = inputStream.read();
                            if (read2 < 0) {
                                throw new java.io.IOException("unexpected end of stream");
                            }
                            i17 = (i17 << 8) | read2;
                            i29 += 8;
                        }
                        i9 = i29 - 1;
                        i26 = (i26 << 1) | ((i17 >> i9) & 1);
                        i27 = i28;
                        bArr2 = bArr6;
                    }
                    i10 = iArr8[i26 - iArr6[i27]];
                    i19 <<= 1;
                    i14 = i;
                    iArr5 = iArr10;
                }
            } else {
                i11++;
                if (i11 >= i3) {
                    throw new java.io.IOException("block overrun");
                }
                int i30 = i10 - 1;
                char c2 = cArr[i30];
                int i31 = i3;
                byte b2 = bArr3[c2];
                byte[] bArr7 = bArr3;
                int i32 = b2 & 255;
                iArr[i32] = iArr[i32] + 1;
                bArr[i11] = b2;
                if (i10 <= 16) {
                    while (i30 > 0) {
                        int i33 = i30 - 1;
                        cArr[i30] = cArr[i33];
                        i30 = i33;
                    }
                    c = 0;
                } else {
                    c = 0;
                    java.lang.System.arraycopy(cArr, 0, cArr, 1, i30);
                }
                cArr[c] = c2;
                if (i13 == 0) {
                    i12++;
                    int i34 = bArr2[i12] & 255;
                    int[] iArr11 = iArr4[i34];
                    int[] iArr12 = iArr3[i34];
                    int[] iArr13 = iArr5[i34];
                    i2 = iArr2[i34];
                    iArr6 = iArr11;
                    iArr7 = iArr12;
                    iArr8 = iArr13;
                    i13 = 49;
                } else {
                    i13--;
                    i2 = i14;
                }
                int i35 = i9;
                while (i35 < i2) {
                    int read3 = inputStream.read();
                    if (read3 < 0) {
                        throw new java.io.IOException("unexpected end of stream");
                    }
                    i17 = (i17 << 8) | read3;
                    i35 += 8;
                }
                int i36 = i35 - i2;
                int i37 = 1;
                int i38 = (i17 >> i36) & ((1 << i2) - 1);
                i9 = i36;
                int i39 = i2;
                while (i38 > iArr7[i39]) {
                    i39++;
                    int i40 = i9;
                    while (i40 < i37) {
                        int read4 = inputStream.read();
                        if (read4 < 0) {
                            throw new java.io.IOException("unexpected end of stream");
                        }
                        i17 = (i17 << 8) | read4;
                        i40 += 8;
                        i37 = 1;
                    }
                    i9 = i40 - 1;
                    i38 = (i38 << 1) | ((i17 >> i9) & 1);
                    i37 = 1;
                }
                i10 = iArr8[i38 - iArr6[i39]];
                i14 = i2;
                i5 = i16;
                i15 = i17;
                i3 = i31;
                bArr3 = bArr7;
                cBZip2InputStream = this;
            }
        }
        cBZip2InputStream.n = i11;
        cBZip2InputStream.x = i9;
        cBZip2InputStream.w = i15;
    }

    public final int l(int i) throws java.io.IOException {
        java.io.InputStream inputStream = this.A;
        org.apache.tools.bzip2.CBZip2InputStream.Data data = this.R;
        int i2 = data.c[i] & 255;
        int[] iArr = data.f[i2];
        int i3 = data.i[i2];
        int f = f(i3);
        int i4 = this.x;
        int i5 = this.w;
        while (f > iArr[i3]) {
            i3++;
            while (i4 < 1) {
                int read = inputStream.read();
                if (read < 0) {
                    throw new java.io.IOException("unexpected end of stream");
                }
                i5 = (i5 << 8) | read;
                i4 += 8;
            }
            i4--;
            f = (f << 1) | (1 & (i5 >> i4));
        }
        this.x = i4;
        this.w = i5;
        return data.h[i2][f - data.g[i2][i3]];
    }

    public final boolean n(boolean z) throws java.io.IOException {
        java.io.InputStream inputStream = this.A;
        if (inputStream == null) {
            throw new java.io.IOException("No InputStream");
        }
        if (!z) {
            int read = inputStream.read();
            if (read == -1) {
                return false;
            }
            int read2 = this.A.read();
            if (read != 66 || read2 != 90) {
                throw new java.io.IOException("Garbage after a valid BZip2 stream");
            }
        } else if (inputStream.available() == 0) {
            throw new java.io.IOException("Empty InputStream");
        }
        if (this.A.read() != 104) {
            throw new java.io.IOException(z ? "Stream is not in the BZip2 format" : "Garbage after a valid BZip2 stream");
        }
        int read3 = this.A.read();
        if (read3 < 49 || read3 > 57) {
            throw new java.io.IOException("Stream is not BZip2 formatted: illegal blocksize " + ((char) read3));
        }
        this.u = read3 - 48;
        this.x = 0;
        this.H = 0;
        return true;
    }

    public final void o() throws java.io.IOException {
        do {
            char e = e();
            char e2 = e();
            char e3 = e();
            char e4 = e();
            char e5 = e();
            char e6 = e();
            if (e != 23 || e2 != 'r' || e3 != 'E' || e4 != '8' || e5 != 'P' || e6 != 144) {
                if (e != '1' || e2 != 'A' || e3 != 'Y' || e4 != '&' || e5 != 'S' || e6 != 'Y') {
                    this.D = 0;
                    throw new java.io.IOException("bad block header");
                }
                this.E = c();
                this.v = f(1) == 1;
                if (this.R == null) {
                    this.R = new org.apache.tools.bzip2.CBZip2InputStream.Data(this.u);
                }
                k();
                this.y.b();
                this.D = 1;
                return;
            }
        } while (!g());
    }

    public final void p() {
        org.apache.tools.bzip2.CBZip2InputStream.Data data = this.R;
        boolean[] zArr = data.a;
        byte[] bArr = data.b;
        int i = 0;
        for (int i2 = 0; i2 < 256; i2++) {
            if (zArr[i2]) {
                bArr[i] = (byte) i2;
                i++;
            }
        }
        this.z = i;
    }

    public final int q() throws java.io.IOException {
        int i = this.C;
        switch (this.D) {
            case 0:
                return -1;
            case 1:
                throw new java.lang.IllegalStateException();
            case 2:
                throw new java.lang.IllegalStateException();
            case 3:
                y();
                return i;
            case 4:
                z();
                return i;
            case 5:
                throw new java.lang.IllegalStateException();
            case 6:
                v();
                return i;
            case 7:
                w();
                return i;
            default:
                throw new java.lang.IllegalStateException();
        }
    }

    public final void r() throws java.io.IOException {
        org.apache.tools.bzip2.CBZip2InputStream.Data data = this.R;
        boolean[] zArr = data.a;
        byte[] bArr = data.m;
        byte[] bArr2 = data.c;
        byte[] bArr3 = data.d;
        int i = 0;
        for (int i2 = 0; i2 < 16; i2++) {
            if (a()) {
                i |= 1 << i2;
            }
        }
        int i3 = 256;
        while (true) {
            i3--;
            if (i3 < 0) {
                break;
            } else {
                zArr[i3] = false;
            }
        }
        for (int i4 = 0; i4 < 16; i4++) {
            if (((1 << i4) & i) != 0) {
                int i5 = i4 << 4;
                for (int i6 = 0; i6 < 16; i6++) {
                    if (a()) {
                        zArr[i5 + i6] = true;
                    }
                }
            }
        }
        p();
        int i7 = this.z + 2;
        int f = f(3);
        int f2 = f(15);
        for (int i8 = 0; i8 < f2; i8++) {
            int i9 = 0;
            while (a()) {
                i9++;
            }
            bArr3[i8] = (byte) i9;
        }
        int i10 = f;
        while (true) {
            i10--;
            if (i10 < 0) {
                break;
            } else {
                bArr[i10] = (byte) i10;
            }
        }
        for (int i11 = 0; i11 < f2; i11++) {
            int i12 = bArr3[i11] & 255;
            byte b = bArr[i12];
            while (i12 > 0) {
                bArr[i12] = bArr[i12 - 1];
                i12--;
            }
            bArr[0] = b;
            bArr2[i11] = b;
        }
        char[][] cArr = data.l;
        for (int i13 = 0; i13 < f; i13++) {
            int f3 = f(5);
            char[] cArr2 = cArr[i13];
            for (int i14 = 0; i14 < i7; i14++) {
                while (a()) {
                    f3 += a() ? -1 : 1;
                }
                cArr2[i14] = (char) f3;
            }
        }
        h(i7, f);
    }

    @Override // java.io.InputStream
    public int read() throws java.io.IOException {
        if (this.A != null) {
            return q();
        }
        throw new java.io.IOException("stream closed");
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws java.io.IOException {
        if (i < 0) {
            throw new java.lang.IndexOutOfBoundsException("offs(" + i + ") < 0.");
        }
        if (i2 < 0) {
            throw new java.lang.IndexOutOfBoundsException("len(" + i2 + ") < 0.");
        }
        int i3 = i + i2;
        if (i3 > bArr.length) {
            throw new java.lang.IndexOutOfBoundsException("offs(" + i + ") + len(" + i2 + ") > dest.length(" + bArr.length + ").");
        }
        if (this.A == null) {
            throw new java.io.IOException("stream closed");
        }
        int i4 = i;
        while (i4 < i3) {
            int q = q();
            if (q < 0) {
                break;
            }
            bArr[i4] = (byte) q;
            i4++;
        }
        if (i4 == i) {
            return -1;
        }
        return i4 - i;
    }

    public final void t() throws java.io.IOException {
        org.apache.tools.bzip2.CBZip2InputStream.Data data = this.R;
        if (data == null) {
            return;
        }
        int[] iArr = data.j;
        int[] a = data.a(this.n + 1);
        org.apache.tools.bzip2.CBZip2InputStream.Data data2 = this.R;
        byte[] bArr = data2.o;
        iArr[0] = 0;
        java.lang.System.arraycopy(data2.e, 0, iArr, 1, 256);
        int i = iArr[0];
        for (int i2 = 1; i2 <= 256; i2++) {
            i += iArr[i2];
            iArr[i2] = i;
        }
        int i3 = this.n;
        for (int i4 = 0; i4 <= i3; i4++) {
            int i5 = bArr[i4] & 255;
            int i6 = iArr[i5];
            iArr[i5] = i6 + 1;
            a[i6] = i4;
        }
        int i7 = this.t;
        if (i7 < 0 || i7 >= a.length) {
            throw new java.io.IOException("stream corrupted");
        }
        this.P = a[i7];
        this.I = 0;
        this.L = 0;
        this.J = 256;
        if (!this.v) {
            u();
            return;
        }
        this.N = 0;
        this.O = 0;
        x();
    }

    public final void u() throws java.io.IOException {
        int i = this.L;
        if (i > this.n) {
            this.D = 5;
            j();
            o();
            t();
            return;
        }
        this.K = this.J;
        org.apache.tools.bzip2.CBZip2InputStream.Data data = this.R;
        byte[] bArr = data.o;
        int i2 = this.P;
        int i3 = bArr[i2] & 255;
        this.J = i3;
        this.P = data.n[i2];
        this.L = i + 1;
        this.C = i3;
        this.D = 6;
        this.y.c(i3);
    }

    public final void v() throws java.io.IOException {
        if (this.J != this.K) {
            this.I = 1;
            u();
            return;
        }
        int i = this.I + 1;
        this.I = i;
        if (i < 4) {
            u();
            return;
        }
        org.apache.tools.bzip2.CBZip2InputStream.Data data = this.R;
        byte[] bArr = data.o;
        int i2 = this.P;
        this.Q = (char) (bArr[i2] & 255);
        this.P = data.n[i2];
        this.M = 0;
        w();
    }

    public final void w() throws java.io.IOException {
        if (this.M >= this.Q) {
            this.L++;
            this.I = 0;
            u();
        } else {
            int i = this.J;
            this.C = i;
            this.y.c(i);
            this.M++;
            this.D = 7;
        }
    }

    public final void x() throws java.io.IOException {
        int i = this.L;
        if (i > this.n) {
            j();
            o();
            t();
            return;
        }
        this.K = this.J;
        org.apache.tools.bzip2.CBZip2InputStream.Data data = this.R;
        byte[] bArr = data.o;
        int i2 = this.P;
        int i3 = bArr[i2] & 255;
        this.P = data.n[i2];
        int i4 = this.N;
        if (i4 == 0) {
            int[] iArr = org.apache.tools.bzip2.BZip2Constants.rNums;
            int i5 = this.O;
            this.N = iArr[i5] - 1;
            int i6 = i5 + 1;
            this.O = i6;
            if (i6 == 512) {
                this.O = 0;
            }
        } else {
            this.N = i4 - 1;
        }
        int i7 = i3 ^ (this.N == 1 ? 1 : 0);
        this.J = i7;
        this.L = i + 1;
        this.C = i7;
        this.D = 3;
        this.y.c(i7);
    }

    public final void y() throws java.io.IOException {
        if (this.J != this.K) {
            this.D = 2;
            this.I = 1;
            x();
            return;
        }
        int i = this.I + 1;
        this.I = i;
        if (i < 4) {
            this.D = 2;
            x();
            return;
        }
        org.apache.tools.bzip2.CBZip2InputStream.Data data = this.R;
        byte[] bArr = data.o;
        int i2 = this.P;
        char c = (char) (bArr[i2] & 255);
        this.Q = c;
        this.P = data.n[i2];
        int i3 = this.N;
        if (i3 == 0) {
            int[] iArr = org.apache.tools.bzip2.BZip2Constants.rNums;
            int i4 = this.O;
            this.N = iArr[i4] - 1;
            int i5 = i4 + 1;
            this.O = i5;
            if (i5 == 512) {
                this.O = 0;
            }
        } else {
            this.N = i3 - 1;
        }
        this.M = 0;
        this.D = 4;
        if (this.N == 1) {
            this.Q = (char) (c ^ 1);
        }
        z();
    }

    public final void z() throws java.io.IOException {
        if (this.M < this.Q) {
            int i = this.J;
            this.C = i;
            this.y.c(i);
            this.M++;
            return;
        }
        this.D = 2;
        this.L++;
        this.I = 0;
        x();
    }
}
