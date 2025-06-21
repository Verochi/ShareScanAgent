package org.apache.tools.bzip2;

/* loaded from: classes26.dex */
public class CBZip2OutputStream extends java.io.OutputStream implements org.apache.tools.bzip2.BZip2Constants {
    protected static final int CLEARMASK = -2097153;
    protected static final int DEPTH_THRESH = 10;
    protected static final int GREATER_ICOST = 15;
    public static final int[] H = {1, 4, 13, 40, 121, 364, 1093, 3280, 9841, 29524, 88573, 265720, 797161, 2391484};
    protected static final int LESSER_ICOST = 0;
    public static final int MAX_BLOCKSIZE = 9;
    public static final int MIN_BLOCKSIZE = 1;
    protected static final int QSORT_STACK_SIZE = 1000;
    protected static final int SETMASK = 2097152;
    protected static final int SMALL_THRESH = 20;
    protected static final int WORK_FACTOR = 30;
    public int A;
    public int B;
    public int C;
    public final int D;
    public org.apache.tools.bzip2.CBZip2OutputStream.Data E;
    public org.apache.tools.bzip2.BlockSort F;
    public java.io.OutputStream G;
    public int n;
    public final int t;
    public int u;
    public int v;
    public final org.apache.tools.bzip2.CRC w;
    public int x;
    public int y;
    public int z;

    public static final class Data {
        public final boolean[] a = new boolean[256];
        public final byte[] b = new byte[256];
        public final int[] c = new int[258];
        public final byte[] d = new byte[org.apache.tools.bzip2.BZip2Constants.MAX_SELECTORS];
        public final byte[] e = new byte[org.apache.tools.bzip2.BZip2Constants.MAX_SELECTORS];
        public final byte[] f = new byte[256];
        public final byte[][] g = (byte[][]) java.lang.reflect.Array.newInstance((java.lang.Class<?>) java.lang.Byte.TYPE, 6, 258);
        public final int[][] h;
        public final int[] i;
        public final short[] j;
        public final int[][] k;
        public final byte[] l;
        public final boolean[] m;
        public final int[] n;
        public final int[] o;
        public final int[] p;
        public final byte[] q;
        public final int[] r;

        /* renamed from: s, reason: collision with root package name */
        public final char[] f505s;
        public int t;

        public Data(int i) {
            java.lang.Class cls = java.lang.Integer.TYPE;
            this.h = (int[][]) java.lang.reflect.Array.newInstance((java.lang.Class<?>) cls, 6, 258);
            this.i = new int[6];
            this.j = new short[6];
            this.k = (int[][]) java.lang.reflect.Array.newInstance((java.lang.Class<?>) cls, 6, 258);
            this.l = new byte[6];
            this.m = new boolean[16];
            this.n = new int[260];
            this.o = new int[com.badlogic.gdx.graphics.GL20.GL_GREATER];
            this.p = new int[com.badlogic.gdx.graphics.GL20.GL_GREATER];
            int i2 = i * 100000;
            this.q = new byte[i2 + 1 + 20];
            this.r = new int[i2];
            this.f505s = new char[i2 * 2];
        }
    }

    public CBZip2OutputStream(java.io.OutputStream outputStream) throws java.io.IOException {
        this(outputStream, 9);
    }

    public CBZip2OutputStream(java.io.OutputStream outputStream, int i) throws java.io.IOException {
        this.w = new org.apache.tools.bzip2.CRC();
        this.z = -1;
        this.A = 0;
        if (i < 1) {
            throw new java.lang.IllegalArgumentException("blockSize(" + i + ") < 1");
        }
        if (i <= 9) {
            this.t = i;
            this.G = outputStream;
            this.D = (i * 100000) - 20;
            n();
            return;
        }
        throw new java.lang.IllegalArgumentException("blockSize(" + i + ") > 9");
    }

    public static int chooseBlockSize(long j) {
        if (j > 0) {
            return (int) java.lang.Math.min((j / 132000) + 1, 9L);
        }
        return 9;
    }

    public static void hbMakeCodeLengths(char[] cArr, int[] iArr, int i, int i2) {
        int[] iArr2 = new int[com.badlogic.gdx.graphics.GL20.GL_GREATER];
        int[] iArr3 = new int[com.badlogic.gdx.graphics.GL20.GL_GREATER];
        int[] iArr4 = new int[com.badlogic.gdx.graphics.GL20.GL_GREATER];
        int i3 = i;
        while (true) {
            i3--;
            int i4 = 1;
            if (i3 < 0) {
                break;
            }
            int i5 = i3 + 1;
            int i6 = iArr[i3];
            if (i6 != 0) {
                i4 = i6;
            }
            iArr3[i5] = i4 << 8;
        }
        boolean z = true;
        while (z) {
            iArr2[0] = 0;
            iArr3[0] = 0;
            iArr4[0] = -2;
            int i7 = 0;
            for (int i8 = 1; i8 <= i; i8++) {
                iArr4[i8] = -1;
                i7++;
                iArr2[i7] = i8;
                int i9 = i7;
                while (true) {
                    int i10 = iArr3[i8];
                    int i11 = i9 >> 1;
                    int i12 = iArr2[i11];
                    if (i10 < iArr3[i12]) {
                        iArr2[i9] = i12;
                        i9 = i11;
                    }
                }
                iArr2[i9] = i8;
            }
            int i13 = i;
            while (i7 > 1) {
                int i14 = iArr2[1];
                int i15 = iArr2[i7];
                iArr2[1] = i15;
                int i16 = i7 - 1;
                int i17 = 1;
                while (true) {
                    int i18 = i17 << 1;
                    if (i18 > i16) {
                        break;
                    }
                    if (i18 < i16) {
                        int i19 = i18 + 1;
                        if (iArr3[iArr2[i19]] < iArr3[iArr2[i18]]) {
                            i18 = i19;
                        }
                    }
                    int i20 = iArr3[i15];
                    int i21 = iArr2[i18];
                    if (i20 < iArr3[i21]) {
                        break;
                    }
                    iArr2[i17] = i21;
                    i17 = i18;
                }
                iArr2[i17] = i15;
                int i22 = iArr2[1];
                int i23 = iArr2[i16];
                iArr2[1] = i23;
                int i24 = i16 - 1;
                int i25 = 1;
                while (true) {
                    int i26 = i25 << 1;
                    if (i26 > i24) {
                        break;
                    }
                    if (i26 < i24) {
                        int i27 = i26 + 1;
                        if (iArr3[iArr2[i27]] < iArr3[iArr2[i26]]) {
                            i26 = i27;
                        }
                    }
                    int i28 = iArr3[i23];
                    int i29 = iArr2[i26];
                    if (i28 < iArr3[i29]) {
                        break;
                    }
                    iArr2[i25] = i29;
                    i25 = i26;
                }
                iArr2[i25] = i23;
                i13++;
                iArr4[i22] = i13;
                iArr4[i14] = i13;
                int i30 = iArr3[i14];
                int i31 = iArr3[i22];
                int i32 = (i30 & androidx.core.view.InputDeviceCompat.SOURCE_ANY) + (i31 & androidx.core.view.InputDeviceCompat.SOURCE_ANY);
                int i33 = i30 & 255;
                int i34 = i31 & 255;
                if (i33 <= i34) {
                    i33 = i34;
                }
                iArr3[i13] = (i33 + 1) | i32;
                iArr4[i13] = -1;
                i7 = i24 + 1;
                iArr2[i7] = i13;
                int i35 = iArr3[i13];
                int i36 = i7;
                while (true) {
                    int i37 = i36 >> 1;
                    int i38 = iArr2[i37];
                    if (i35 < iArr3[i38]) {
                        iArr2[i36] = i38;
                        i36 = i37;
                    }
                }
                iArr2[i36] = i13;
            }
            z = false;
            for (int i39 = 1; i39 <= i; i39++) {
                int i40 = i39;
                int i41 = 0;
                while (true) {
                    i40 = iArr4[i40];
                    if (i40 < 0) {
                        break;
                    } else {
                        i41++;
                    }
                }
                cArr[i39 - 1] = (char) i41;
                if (i41 > i2) {
                    z = true;
                }
            }
            if (z) {
                for (int i42 = 1; i42 < i; i42++) {
                    iArr3[i42] = (((iArr3[i42] >> 8) >> 1) + 1) << 8;
                }
            }
        }
    }

    public static void l(int[] iArr, byte[] bArr, int i, int i2, int i3) {
        int i4 = 0;
        while (i <= i2) {
            for (int i5 = 0; i5 < i3; i5++) {
                if ((bArr[i5] & 255) == i) {
                    iArr[i5] = i4;
                    i4++;
                }
            }
            i4 <<= 1;
            i++;
        }
    }

    public static void m(byte[] bArr, int[] iArr, org.apache.tools.bzip2.CBZip2OutputStream.Data data, int i, int i2) {
        int[] iArr2 = data.n;
        int[] iArr3 = data.o;
        int[] iArr4 = data.p;
        int i3 = i;
        while (true) {
            i3--;
            int i4 = 1;
            if (i3 < 0) {
                break;
            }
            int i5 = i3 + 1;
            int i6 = iArr[i3];
            if (i6 != 0) {
                i4 = i6;
            }
            iArr3[i5] = i4 << 8;
        }
        boolean z = true;
        while (z) {
            iArr2[0] = 0;
            iArr3[0] = 0;
            iArr4[0] = -2;
            int i7 = 0;
            for (int i8 = 1; i8 <= i; i8++) {
                iArr4[i8] = -1;
                i7++;
                iArr2[i7] = i8;
                int i9 = i7;
                while (true) {
                    int i10 = iArr3[i8];
                    int i11 = i9 >> 1;
                    int i12 = iArr2[i11];
                    if (i10 < iArr3[i12]) {
                        iArr2[i9] = i12;
                        i9 = i11;
                    }
                }
                iArr2[i9] = i8;
            }
            int i13 = i;
            while (i7 > 1) {
                int i14 = iArr2[1];
                int i15 = iArr2[i7];
                iArr2[1] = i15;
                int i16 = i7 - 1;
                int i17 = 1;
                while (true) {
                    int i18 = i17 << 1;
                    if (i18 > i16) {
                        break;
                    }
                    if (i18 < i16) {
                        int i19 = i18 + 1;
                        if (iArr3[iArr2[i19]] < iArr3[iArr2[i18]]) {
                            i18 = i19;
                        }
                    }
                    int i20 = iArr3[i15];
                    int i21 = iArr2[i18];
                    if (i20 < iArr3[i21]) {
                        break;
                    }
                    iArr2[i17] = i21;
                    i17 = i18;
                }
                iArr2[i17] = i15;
                int i22 = iArr2[1];
                int i23 = iArr2[i16];
                iArr2[1] = i23;
                int i24 = i16 - 1;
                int i25 = 1;
                while (true) {
                    int i26 = i25 << 1;
                    if (i26 > i24) {
                        break;
                    }
                    if (i26 < i24) {
                        int i27 = i26 + 1;
                        if (iArr3[iArr2[i27]] < iArr3[iArr2[i26]]) {
                            i26 = i27;
                        }
                    }
                    int i28 = iArr3[i23];
                    int i29 = iArr2[i26];
                    if (i28 < iArr3[i29]) {
                        break;
                    }
                    iArr2[i25] = i29;
                    i25 = i26;
                }
                iArr2[i25] = i23;
                i13++;
                iArr4[i22] = i13;
                iArr4[i14] = i13;
                int i30 = iArr3[i14];
                int i31 = iArr3[i22];
                int i32 = (i30 & androidx.core.view.InputDeviceCompat.SOURCE_ANY) + (i31 & androidx.core.view.InputDeviceCompat.SOURCE_ANY);
                int i33 = i30 & 255;
                int i34 = i31 & 255;
                if (i33 <= i34) {
                    i33 = i34;
                }
                iArr3[i13] = (i33 + 1) | i32;
                iArr4[i13] = -1;
                i7 = i24 + 1;
                iArr2[i7] = i13;
                int i35 = iArr3[i13];
                int i36 = i7;
                while (true) {
                    int i37 = i36 >> 1;
                    int i38 = iArr2[i37];
                    if (i35 < iArr3[i38]) {
                        iArr2[i36] = i38;
                        i36 = i37;
                    }
                }
                iArr2[i36] = i13;
            }
            z = false;
            for (int i39 = 1; i39 <= i; i39++) {
                int i40 = i39;
                int i41 = 0;
                while (true) {
                    i40 = iArr4[i40];
                    if (i40 < 0) {
                        break;
                    } else {
                        i41++;
                    }
                }
                bArr[i39 - 1] = (byte) i41;
                if (i41 > i2) {
                    z = true;
                }
            }
            if (z) {
                for (int i42 = 1; i42 < i; i42++) {
                    iArr3[i42] = (((iArr3[i42] >> 8) >> 1) + 1) << 8;
                }
            }
        }
    }

    public final void A() throws java.io.IOException {
        int i = this.n;
        if (i >= this.D) {
            g();
            o();
            A();
            return;
        }
        int i2 = this.z;
        org.apache.tools.bzip2.CBZip2OutputStream.Data data = this.E;
        data.a[i2] = true;
        byte b = (byte) i2;
        int i3 = this.A;
        this.w.d(i2, i3);
        byte[] bArr = data.q;
        if (i3 == 1) {
            bArr[i + 2] = b;
            this.n = i + 1;
            return;
        }
        if (i3 == 2) {
            int i4 = i + 2;
            bArr[i4] = b;
            bArr[i + 3] = b;
            this.n = i4;
            return;
        }
        if (i3 == 3) {
            bArr[i + 2] = b;
            int i5 = i + 3;
            bArr[i5] = b;
            bArr[i + 4] = b;
            this.n = i5;
            return;
        }
        int i6 = i3 - 4;
        data.a[i6] = true;
        bArr[i + 2] = b;
        bArr[i + 3] = b;
        bArr[i + 4] = b;
        int i7 = i + 5;
        bArr[i7] = b;
        bArr[i + 6] = (byte) i6;
        this.n = i7;
    }

    public final void a() {
        this.F.a(this.E, this.n);
    }

    public final void c() throws java.io.IOException {
        while (this.v > 0) {
            this.G.write(this.u >> 24);
            this.u <<= 8;
            this.v -= 8;
        }
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws java.io.IOException {
        java.io.OutputStream outputStream = this.G;
        if (outputStream != null) {
            finish();
            outputStream.close();
        }
    }

    public final void d(int i) throws java.io.IOException {
        f(8, (i >> 24) & 255);
        f(8, (i >> 16) & 255);
        f(8, (i >> 8) & 255);
        f(8, i & 255);
    }

    public final void e(int i) throws java.io.IOException {
        f(8, i);
    }

    public final void f(int i, int i2) throws java.io.IOException {
        java.io.OutputStream outputStream = this.G;
        int i3 = this.v;
        int i4 = this.u;
        while (i3 >= 8) {
            outputStream.write(i4 >> 24);
            i4 <<= 8;
            i3 -= 8;
        }
        this.u = (i2 << ((32 - i3) - i)) | i4;
        this.v = i3 + i;
    }

    public void finalize() throws java.lang.Throwable {
        finish();
        super.finalize();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void finish() throws java.io.IOException {
        if (this.G != null) {
            try {
                if (this.A > 0) {
                    A();
                }
                this.z = -1;
                g();
                j();
            } finally {
                this.G = null;
                this.E = null;
                this.F = null;
            }
        }
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() throws java.io.IOException {
        java.io.OutputStream outputStream = this.G;
        if (outputStream != null) {
            outputStream.flush();
        }
    }

    public final void g() throws java.io.IOException {
        int a = this.w.a();
        this.B = a;
        int i = this.C;
        this.C = a ^ ((i >>> 31) | (i << 1));
        if (this.n == -1) {
            return;
        }
        a();
        e(49);
        e(65);
        e(89);
        e(38);
        e(83);
        e(89);
        d(this.B);
        f(1, 0);
        p();
    }

    public final int getBlockSize() {
        return this.t;
    }

    public final void j() throws java.io.IOException {
        e(23);
        e(114);
        e(69);
        e(56);
        e(80);
        e(144);
        d(this.C);
        c();
    }

    public final void k() {
        int i = this.n;
        org.apache.tools.bzip2.CBZip2OutputStream.Data data = this.E;
        boolean[] zArr = data.a;
        byte[] bArr = data.q;
        int[] iArr = data.r;
        char[] cArr = data.f505s;
        int[] iArr2 = data.c;
        byte[] bArr2 = data.b;
        byte[] bArr3 = data.f;
        int i2 = 0;
        for (int i3 = 0; i3 < 256; i3++) {
            if (zArr[i3]) {
                bArr2[i3] = (byte) i2;
                i2++;
            }
        }
        this.x = i2;
        int i4 = i2 + 1;
        for (int i5 = i4; i5 >= 0; i5--) {
            iArr2[i5] = 0;
        }
        while (true) {
            i2--;
            if (i2 < 0) {
                break;
            } else {
                bArr3[i2] = (byte) i2;
            }
        }
        int i6 = 0;
        int i7 = 0;
        for (int i8 = 0; i8 <= i; i8++) {
            byte b = bArr2[bArr[iArr[i8]] & 255];
            byte b2 = bArr3[0];
            int i9 = 0;
            while (b != b2) {
                i9++;
                byte b3 = bArr3[i9];
                bArr3[i9] = b2;
                b2 = b3;
            }
            bArr3[0] = b2;
            if (i9 == 0) {
                i6++;
            } else {
                if (i6 > 0) {
                    int i10 = i6 - 1;
                    while (true) {
                        if ((i10 & 1) == 0) {
                            cArr[i7] = 0;
                            i7++;
                            iArr2[0] = iArr2[0] + 1;
                        } else {
                            cArr[i7] = 1;
                            i7++;
                            iArr2[1] = iArr2[1] + 1;
                        }
                        if (i10 < 2) {
                            break;
                        } else {
                            i10 = (i10 - 2) >> 1;
                        }
                    }
                    i6 = 0;
                }
                int i11 = i9 + 1;
                cArr[i7] = (char) i11;
                i7++;
                iArr2[i11] = iArr2[i11] + 1;
            }
        }
        if (i6 > 0) {
            int i12 = i6 - 1;
            while (true) {
                if ((i12 & 1) == 0) {
                    cArr[i7] = 0;
                    i7++;
                    iArr2[0] = iArr2[0] + 1;
                } else {
                    cArr[i7] = 1;
                    i7++;
                    iArr2[1] = iArr2[1] + 1;
                }
                if (i12 < 2) {
                    break;
                } else {
                    i12 = (i12 - 2) >> 1;
                }
            }
        }
        cArr[i7] = (char) i4;
        iArr2[i4] = iArr2[i4] + 1;
        this.y = i7 + 1;
    }

    public final void n() throws java.io.IOException {
        this.E = new org.apache.tools.bzip2.CBZip2OutputStream.Data(this.t);
        this.F = new org.apache.tools.bzip2.BlockSort(this.E);
        e(104);
        e(this.t + 48);
        this.C = 0;
        o();
    }

    public final void o() {
        this.w.b();
        this.n = -1;
        boolean[] zArr = this.E.a;
        int i = 256;
        while (true) {
            i--;
            if (i < 0) {
                return;
            } else {
                zArr[i] = false;
            }
        }
    }

    public final void p() throws java.io.IOException {
        f(24, this.E.t);
        k();
        q();
    }

    public final void q() throws java.io.IOException {
        byte[][] bArr = this.E.g;
        int i = this.x + 2;
        int i2 = 6;
        while (true) {
            i2--;
            if (i2 < 0) {
                break;
            }
            byte[] bArr2 = bArr[i2];
            int i3 = i;
            while (true) {
                i3--;
                if (i3 >= 0) {
                    bArr2[i3] = 15;
                }
            }
        }
        int i4 = this.y;
        int i5 = i4 >= 200 ? i4 < 600 ? 3 : i4 < 1200 ? 4 : i4 < 2400 ? 5 : 6 : 2;
        r(i5, i);
        int s2 = s(i5, i);
        t(i5, s2);
        u(i5, i);
        v();
        w(i5, s2);
        x(i5, i);
        y();
    }

    public final void r(int i, int i2) {
        org.apache.tools.bzip2.CBZip2OutputStream.Data data = this.E;
        byte[][] bArr = data.g;
        int[] iArr = data.c;
        int i3 = this.y;
        int i4 = 0;
        for (int i5 = i; i5 > 0; i5--) {
            int i6 = i3 / i5;
            int i7 = i4 - 1;
            int i8 = i2 - 1;
            int i9 = 0;
            while (i9 < i6 && i7 < i8) {
                i7++;
                i9 += iArr[i7];
            }
            if (i7 > i4 && i5 != i && i5 != 1 && (1 & (i - i5)) != 0) {
                i9 -= iArr[i7];
                i7--;
            }
            byte[] bArr2 = bArr[i5 - 1];
            int i10 = i2;
            while (true) {
                i10--;
                if (i10 >= 0) {
                    if (i10 < i4 || i10 > i7) {
                        bArr2[i10] = 15;
                    } else {
                        bArr2[i10] = 0;
                    }
                }
            }
            i4 = i7 + 1;
            i3 -= i9;
        }
    }

    public final int s(int i, int i2) {
        byte[] bArr;
        int i3;
        org.apache.tools.bzip2.CBZip2OutputStream cBZip2OutputStream = this;
        org.apache.tools.bzip2.CBZip2OutputStream.Data data = cBZip2OutputStream.E;
        int[][] iArr = data.h;
        int[] iArr2 = data.i;
        short[] sArr = data.j;
        char[] cArr = data.f505s;
        byte[] bArr2 = data.d;
        byte[][] bArr3 = data.g;
        int i4 = 0;
        byte[] bArr4 = bArr3[0];
        byte[] bArr5 = bArr3[1];
        byte[] bArr6 = bArr3[2];
        byte[] bArr7 = bArr3[3];
        int i5 = 4;
        byte[] bArr8 = bArr3[4];
        byte[] bArr9 = bArr3[5];
        int i6 = cBZip2OutputStream.y;
        int i7 = 0;
        int i8 = 0;
        while (i7 < i5) {
            int i9 = i;
            while (true) {
                i9--;
                if (i9 < 0) {
                    break;
                }
                iArr2[i9] = i4;
                int[] iArr3 = iArr[i9];
                int i10 = i2;
                while (true) {
                    i10--;
                    if (i10 >= 0) {
                        iArr3[i10] = i4;
                    }
                }
            }
            int i11 = 0;
            i8 = 0;
            while (i11 < cBZip2OutputStream.y) {
                int i12 = i11;
                int min = java.lang.Math.min((i11 + 50) - 1, i6 - 1);
                if (i == 6) {
                    int i13 = i12;
                    short s2 = 0;
                    short s3 = 0;
                    short s4 = 0;
                    short s5 = 0;
                    short s6 = 0;
                    short s7 = 0;
                    while (i13 <= min) {
                        char c = cArr[i13];
                        int i14 = i6;
                        short s8 = (short) (s2 + (bArr4[c] & 255));
                        byte[] bArr10 = bArr4;
                        short s9 = (short) (s3 + (bArr5[c] & 255));
                        short s10 = (short) (s4 + (bArr6[c] & 255));
                        short s11 = (short) (s5 + (bArr7[c] & 255));
                        short s12 = (short) (s6 + (bArr8[c] & 255));
                        i13++;
                        s7 = (short) (s7 + (bArr9[c] & 255));
                        s6 = s12;
                        bArr4 = bArr10;
                        s5 = s11;
                        s4 = s10;
                        s3 = s9;
                        s2 = s8;
                        i6 = i14;
                    }
                    bArr = bArr4;
                    i3 = i6;
                    sArr[0] = s2;
                    sArr[1] = s3;
                    sArr[2] = s4;
                    sArr[3] = s5;
                    sArr[4] = s6;
                    sArr[5] = s7;
                } else {
                    bArr = bArr4;
                    i3 = i6;
                    int i15 = i;
                    while (true) {
                        i15--;
                        if (i15 < 0) {
                            break;
                        }
                        sArr[i15] = 0;
                    }
                    for (int i16 = i12; i16 <= min; i16++) {
                        char c2 = cArr[i16];
                        int i17 = i;
                        while (true) {
                            i17--;
                            if (i17 >= 0) {
                                sArr[i17] = (short) (sArr[i17] + (bArr3[i17][c2] & 255));
                            }
                        }
                    }
                }
                short s13 = 999999999;
                int i18 = i;
                int i19 = -1;
                while (true) {
                    i18--;
                    if (i18 < 0) {
                        break;
                    }
                    byte[] bArr11 = bArr5;
                    short s14 = sArr[i18];
                    if (s14 < s13) {
                        s13 = s14;
                        i19 = i18;
                    }
                    bArr5 = bArr11;
                }
                byte[] bArr12 = bArr5;
                iArr2[i19] = iArr2[i19] + 1;
                bArr2[i8] = (byte) i19;
                i8++;
                int[] iArr4 = iArr[i19];
                for (int i20 = i12; i20 <= min; i20++) {
                    char c3 = cArr[i20];
                    iArr4[c3] = iArr4[c3] + 1;
                }
                i11 = min + 1;
                bArr5 = bArr12;
                i6 = i3;
                bArr4 = bArr;
            }
            byte[] bArr13 = bArr4;
            byte[] bArr14 = bArr5;
            int i21 = i6;
            int i22 = 0;
            while (i22 < i) {
                m(bArr3[i22], iArr[i22], cBZip2OutputStream.E, i2, 20);
                i22++;
                cBZip2OutputStream = this;
            }
            i7++;
            bArr5 = bArr14;
            i6 = i21;
            bArr4 = bArr13;
            i4 = 0;
            i5 = 4;
            cBZip2OutputStream = this;
        }
        return i8;
    }

    public final void t(int i, int i2) {
        org.apache.tools.bzip2.CBZip2OutputStream.Data data = this.E;
        byte[] bArr = data.l;
        while (true) {
            i--;
            if (i < 0) {
                break;
            } else {
                bArr[i] = (byte) i;
            }
        }
        for (int i3 = 0; i3 < i2; i3++) {
            byte b = data.d[i3];
            byte b2 = bArr[0];
            int i4 = 0;
            while (b != b2) {
                i4++;
                byte b3 = bArr[i4];
                bArr[i4] = b2;
                b2 = b3;
            }
            bArr[0] = b2;
            data.e[i3] = (byte) i4;
        }
    }

    public final void u(int i, int i2) {
        org.apache.tools.bzip2.CBZip2OutputStream.Data data = this.E;
        int[][] iArr = data.k;
        byte[][] bArr = data.g;
        for (int i3 = 0; i3 < i; i3++) {
            byte[] bArr2 = bArr[i3];
            int i4 = 32;
            int i5 = i2;
            int i6 = 0;
            while (true) {
                i5--;
                if (i5 >= 0) {
                    int i7 = bArr2[i5] & 255;
                    if (i7 > i6) {
                        i6 = i7;
                    }
                    if (i7 < i4) {
                        i4 = i7;
                    }
                }
            }
            l(iArr[i3], bArr[i3], i4, i6, i2);
        }
    }

    public final void v() throws java.io.IOException {
        org.apache.tools.bzip2.CBZip2OutputStream.Data data = this.E;
        boolean[] zArr = data.a;
        boolean[] zArr2 = data.m;
        int i = 16;
        while (true) {
            i--;
            if (i < 0) {
                break;
            }
            zArr2[i] = false;
            int i2 = i * 16;
            int i3 = 16;
            while (true) {
                i3--;
                if (i3 >= 0) {
                    if (zArr[i2 + i3]) {
                        zArr2[i] = true;
                    }
                }
            }
        }
        for (int i4 = 0; i4 < 16; i4++) {
            f(1, zArr2[i4] ? 1 : 0);
        }
        java.io.OutputStream outputStream = this.G;
        int i5 = this.v;
        int i6 = this.u;
        for (int i7 = 0; i7 < 16; i7++) {
            if (zArr2[i7]) {
                int i8 = i7 * 16;
                for (int i9 = 0; i9 < 16; i9++) {
                    while (i5 >= 8) {
                        outputStream.write(i6 >> 24);
                        i6 <<= 8;
                        i5 -= 8;
                    }
                    if (zArr[i8 + i9]) {
                        i6 |= 1 << ((32 - i5) - 1);
                    }
                    i5++;
                }
            }
        }
        this.u = i6;
        this.v = i5;
    }

    public final void w(int i, int i2) throws java.io.IOException {
        f(3, i);
        f(15, i2);
        java.io.OutputStream outputStream = this.G;
        byte[] bArr = this.E.e;
        int i3 = this.v;
        int i4 = this.u;
        for (int i5 = 0; i5 < i2; i5++) {
            int i6 = bArr[i5] & 255;
            for (int i7 = 0; i7 < i6; i7++) {
                while (i3 >= 8) {
                    outputStream.write(i4 >> 24);
                    i4 <<= 8;
                    i3 -= 8;
                }
                i4 |= 1 << ((32 - i3) - 1);
                i3++;
            }
            while (i3 >= 8) {
                outputStream.write(i4 >> 24);
                i4 <<= 8;
                i3 -= 8;
            }
            i3++;
        }
        this.u = i4;
        this.v = i3;
    }

    @Override // java.io.OutputStream
    public void write(int i) throws java.io.IOException {
        if (this.G == null) {
            throw new java.io.IOException("closed");
        }
        z(i);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) throws java.io.IOException {
        if (i < 0) {
            throw new java.lang.IndexOutOfBoundsException("offs(" + i + ") < 0.");
        }
        if (i2 < 0) {
            throw new java.lang.IndexOutOfBoundsException("len(" + i2 + ") < 0.");
        }
        int i3 = i + i2;
        if (i3 <= bArr.length) {
            if (this.G == null) {
                throw new java.io.IOException("stream closed");
            }
            while (i < i3) {
                z(bArr[i]);
                i++;
            }
            return;
        }
        throw new java.lang.IndexOutOfBoundsException("offs(" + i + ") + len(" + i2 + ") > buf.length(" + bArr.length + ").");
    }

    public final void x(int i, int i2) throws java.io.IOException {
        byte[][] bArr = this.E.g;
        java.io.OutputStream outputStream = this.G;
        int i3 = this.v;
        int i4 = this.u;
        for (int i5 = 0; i5 < i; i5++) {
            byte[] bArr2 = bArr[i5];
            int i6 = bArr2[0] & 255;
            while (i3 >= 8) {
                outputStream.write(i4 >> 24);
                i4 <<= 8;
                i3 -= 8;
            }
            i4 |= i6 << ((32 - i3) - 5);
            i3 += 5;
            for (int i7 = 0; i7 < i2; i7++) {
                int i8 = bArr2[i7] & 255;
                while (i6 < i8) {
                    while (i3 >= 8) {
                        outputStream.write(i4 >> 24);
                        i4 <<= 8;
                        i3 -= 8;
                    }
                    i4 |= 2 << ((32 - i3) - 2);
                    i3 += 2;
                    i6++;
                }
                while (i6 > i8) {
                    while (i3 >= 8) {
                        outputStream.write(i4 >> 24);
                        i4 <<= 8;
                        i3 -= 8;
                    }
                    i4 |= 3 << ((32 - i3) - 2);
                    i3 += 2;
                    i6--;
                }
                while (i3 >= 8) {
                    outputStream.write(i4 >> 24);
                    i4 <<= 8;
                    i3 -= 8;
                }
                i3++;
            }
        }
        this.u = i4;
        this.v = i3;
    }

    public final void y() throws java.io.IOException {
        org.apache.tools.bzip2.CBZip2OutputStream.Data data = this.E;
        byte[][] bArr = data.g;
        int[][] iArr = data.k;
        java.io.OutputStream outputStream = this.G;
        byte[] bArr2 = data.d;
        char[] cArr = data.f505s;
        int i = this.y;
        int i2 = this.v;
        int i3 = this.u;
        int i4 = 0;
        int i5 = 0;
        while (i4 < i) {
            int min = java.lang.Math.min((i4 + 50) - 1, i - 1);
            int i6 = bArr2[i5] & 255;
            int[] iArr2 = iArr[i6];
            byte[] bArr3 = bArr[i6];
            while (i4 <= min) {
                char c = cArr[i4];
                while (i2 >= 8) {
                    outputStream.write(i3 >> 24);
                    i3 <<= 8;
                    i2 -= 8;
                }
                int i7 = bArr3[c] & 255;
                i3 |= iArr2[c] << ((32 - i2) - i7);
                i2 += i7;
                i4++;
            }
            i4 = min + 1;
            i5++;
        }
        this.u = i3;
        this.v = i2;
    }

    public final void z(int i) throws java.io.IOException {
        int i2 = this.z;
        if (i2 == -1) {
            this.z = i & 255;
            this.A++;
            return;
        }
        int i3 = i & 255;
        if (i2 != i3) {
            A();
            this.A = 1;
            this.z = i3;
            return;
        }
        int i4 = this.A + 1;
        this.A = i4;
        if (i4 > 254) {
            A();
            this.z = -1;
            this.A = 0;
        }
    }
}
