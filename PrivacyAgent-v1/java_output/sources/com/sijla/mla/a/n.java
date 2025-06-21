package com.sijla.mla.a;

/* loaded from: classes19.dex */
public final class n extends com.sijla.mla.a.r {
    public static com.sijla.mla.a.r a;
    public final byte[] b;
    public final int c;
    public final int d;
    private final int e;

    public static final class a {
        private static final com.sijla.mla.a.n[] a = new com.sijla.mla.a.n[128];
    }

    private n(byte[] bArr, int i, int i2) {
        this.b = bArr;
        this.c = i;
        this.d = i2;
        this.e = e(bArr, i, i2);
    }

    private double a(int i, int i2, int i3) {
        boolean z = this.b[i2] == 45;
        if (z) {
            i2++;
        }
        long j = 0;
        while (i2 < i3) {
            byte b = this.b[i2];
            byte b2 = org.apache.tools.tar.TarConstants.LF_NORMAL;
            if (i > 10 && (b < 48 || b > 57)) {
                b2 = (b < 65 || b > 90) ? (byte) 87 : org.apache.tools.tar.TarConstants.LF_CONTIG;
            }
            int i4 = b - b2;
            if (i4 < 0 || i4 >= i) {
                return Double.NaN;
            }
            j = (j * i) + i4;
            if (j < 0) {
                return Double.NaN;
            }
            i2++;
        }
        return z ? -j : j;
    }

    public static int a(char[] cArr) {
        int length = cArr.length;
        int i = length;
        while (true) {
            length--;
            if (length < 0) {
                return i;
            }
            char c = cArr[length];
            if (c >= 128) {
                i += c >= 2048 ? 2 : 1;
            }
        }
    }

    public static int a(char[] cArr, int i, byte[] bArr, int i2) {
        int i3 = i2;
        for (int i4 = 0; i4 < i; i4++) {
            char c = cArr[i4];
            if (c < 128) {
                bArr[i3] = (byte) c;
                i3++;
            } else if (c < 2048) {
                int i5 = i3 + 1;
                bArr[i3] = (byte) (((c >> 6) & 31) | 192);
                i3 = i5 + 1;
                bArr[i5] = (byte) ((c & '?') | 128);
            } else {
                int i6 = i3 + 1;
                bArr[i3] = (byte) (((c >> '\f') & 15) | 224);
                int i7 = i6 + 1;
                bArr[i6] = (byte) (((c >> 6) & 63) | 128);
                bArr[i7] = (byte) ((c & '?') | 128);
                i3 = i7 + 1;
            }
        }
        return i3 - i2;
    }

    public static com.sijla.mla.a.n a(byte[] bArr) {
        return a(bArr, 0, bArr.length);
    }

    public static com.sijla.mla.a.n a(byte[] bArr, int i, int i2) {
        if (i2 > 32) {
            return d(bArr, i, i2);
        }
        int e = e(bArr, i, i2);
        int i3 = e & 127;
        com.sijla.mla.a.n nVar = com.sijla.mla.a.n.a.a[i3];
        if (nVar != null && nVar.e == e && nVar.f(bArr, i, i2)) {
            return nVar;
        }
        com.sijla.mla.a.n d = d(bArr, i, i2);
        com.sijla.mla.a.n.a.a[i3] = d;
        return d;
    }

    public static com.sijla.mla.a.n a(char[] cArr, int i, int i2) {
        byte[] bArr = new byte[i2];
        for (int i3 = 0; i3 < i2; i3++) {
            bArr[i3] = (byte) cArr[i3 + i];
        }
        return b(bArr, 0, i2);
    }

    public static boolean a(com.sijla.mla.a.n nVar, int i, com.sijla.mla.a.n nVar2, int i2, int i3) {
        return a(nVar.b, nVar.c + i, nVar2.b, nVar2.c + i2, i3);
    }

    private static boolean a(byte[] bArr, int i, byte[] bArr2, int i2, int i3) {
        if (bArr.length < i + i3 || bArr2.length < i2 + i3) {
            return false;
        }
        while (true) {
            i3--;
            if (i3 < 0) {
                return true;
            }
            int i4 = i + 1;
            int i5 = i2 + 1;
            if (bArr[i] != bArr2[i2]) {
                return false;
            }
            i = i4;
            i2 = i5;
        }
    }

    private double ae() {
        double af = af();
        if (java.lang.Double.isNaN(af)) {
            W();
        }
        return af;
    }

    private double af() {
        int i;
        byte b;
        int i2 = this.c;
        int i3 = this.d + i2;
        while (i2 < i3 && this.b[i2] == 32) {
            i2++;
        }
        while (i2 < i3 && this.b[i3 - 1] == 32) {
            i3--;
        }
        if (i2 >= i3) {
            return Double.NaN;
        }
        byte[] bArr = this.b;
        if (bArr[i2] == 48 && (i = i2 + 1) < i3 && ((b = bArr[i]) == 120 || b == 88)) {
            return a(16, i2 + 2, i3);
        }
        double a2 = a(10, i2, i3);
        return java.lang.Double.isNaN(a2) ? b(i2, i3) : a2;
    }

    private double b(int i, int i2) {
        int i3 = i + 64;
        if (i2 > i3) {
            i2 = i3;
        }
        for (int i4 = i; i4 < i2; i4++) {
            byte b = this.b[i4];
            if (b != 43 && b != 69 && b != 101 && b != 45 && b != 46) {
                switch (b) {
                    case 48:
                    case 49:
                    case 50:
                    case 51:
                    case 52:
                    case 53:
                    case 54:
                    case 55:
                    case 56:
                    case 57:
                        break;
                    default:
                        return Double.NaN;
                }
            }
        }
        char[] cArr = new char[i2 - i];
        for (int i5 = i; i5 < i2; i5++) {
            cArr[i5 - i] = (char) this.b[i5];
        }
        try {
            return java.lang.Double.parseDouble(new java.lang.String(cArr));
        } catch (java.lang.Exception unused) {
            return Double.NaN;
        }
    }

    public static com.sijla.mla.a.n b(byte[] bArr) {
        return b(bArr, 0, bArr.length);
    }

    public static com.sijla.mla.a.n b(byte[] bArr, int i, int i2) {
        if (bArr.length > 32) {
            return new com.sijla.mla.a.n(bArr, i, i2);
        }
        int e = e(bArr, i, i2);
        int i3 = e & 127;
        com.sijla.mla.a.n nVar = com.sijla.mla.a.n.a.a[i3];
        if (nVar != null && nVar.e == e && nVar.f(bArr, i, i2)) {
            return nVar;
        }
        com.sijla.mla.a.n nVar2 = new com.sijla.mla.a.n(bArr, i, i2);
        com.sijla.mla.a.n.a.a[i3] = nVar2;
        return nVar2;
    }

    public static com.sijla.mla.a.n c(java.lang.String str) {
        char[] charArray = str.toCharArray();
        int a2 = a(charArray);
        byte[] bArr = new byte[a2];
        a(charArray, charArray.length, bArr, 0);
        return b(bArr, 0, a2);
    }

    private static com.sijla.mla.a.n d(byte[] bArr, int i, int i2) {
        byte[] bArr2 = new byte[i2];
        for (int i3 = 0; i3 < i2; i3++) {
            bArr2[i3] = bArr[i + i3];
        }
        return new com.sijla.mla.a.n(bArr2, 0, i2);
    }

    private static int e(byte[] bArr, int i, int i2) {
        int i3 = (i2 >> 5) + 1;
        int i4 = i2;
        while (i2 >= i3) {
            i4 ^= ((i4 << 5) + (i4 >> 2)) + (bArr[(i + i2) - 1] & 255);
            i2 -= i3;
        }
        return i4;
    }

    private boolean f(byte[] bArr, int i, int i2) {
        return this.d == i2 && a(this.b, this.c, bArr, i, i2);
    }

    @Override // com.sijla.mla.a.r
    public final double A() {
        double af = af();
        if (java.lang.Double.isNaN(af)) {
            e(com.sijla.mla.L2.s1420460951());
        }
        return af;
    }

    @Override // com.sijla.mla.a.r
    public final java.lang.String B() {
        return g();
    }

    @Override // com.sijla.mla.a.r
    public final com.sijla.mla.a.n C() {
        return this;
    }

    @Override // com.sijla.mla.a.r
    public final com.sijla.mla.a.r M() {
        return com.sijla.mla.a.k.c_(this.d);
    }

    @Override // com.sijla.mla.a.r
    public final int N() {
        return this.d;
    }

    @Override // com.sijla.mla.a.r
    public final int O() {
        return this.d;
    }

    @Override // com.sijla.mla.a.r
    public final int a(int i) {
        return com.sijla.mla.a.h.a(A()).x();
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x002c, code lost:
    
        return r2 - r9.d;
     */
    @Override // com.sijla.mla.a.r
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final int a(com.sijla.mla.a.n nVar) {
        int i = 0;
        int i2 = 0;
        while (true) {
            int i3 = this.d;
            if (i >= i3 || i2 >= nVar.d) {
                break;
            }
            byte[] bArr = this.b;
            int i4 = this.c;
            byte b = bArr[i4 + i];
            byte[] bArr2 = nVar.b;
            int i5 = nVar.c;
            if (b != bArr2[i5 + i2]) {
                return bArr[i4 + i] - bArr2[i5 + i2];
            }
            i++;
            i2++;
        }
    }

    public final int a(com.sijla.mla.a.n nVar, int i) {
        int i2 = nVar.d;
        int i3 = this.d - i2;
        while (i <= i3) {
            if (a(this.b, this.c + i, nVar.b, nVar.c, i2)) {
                return i;
            }
            i++;
        }
        return -1;
    }

    @Override // com.sijla.mla.a.r
    public final com.sijla.mla.a.a a(com.sijla.mla.a.a aVar) {
        return aVar.b(this);
    }

    public final com.sijla.mla.a.n a(int i, int i2) {
        int i3 = this.c + i;
        int i4 = i2 - i;
        return i4 >= this.d / 2 ? b(this.b, i3, i4) : a(this.b, i3, i4);
    }

    @Override // com.sijla.mla.a.r
    public final com.sijla.mla.a.r a(com.sijla.mla.a.m mVar) {
        return c(mVar.s());
    }

    @Override // com.sijla.mla.a.r
    public final int a_() {
        return 4;
    }

    @Override // com.sijla.mla.a.r
    public final com.sijla.mla.a.r a_(int i) {
        return com.sijla.mla.a.h.a(ae() * i);
    }

    @Override // com.sijla.mla.a.r
    public final java.lang.String a_(java.lang.String str) {
        return g();
    }

    @Override // com.sijla.mla.a.r
    public final com.sijla.mla.a.m b(java.lang.String str) {
        double af = af();
        if (java.lang.Double.isNaN(af)) {
            com.sijla.mla.a.r.d(str);
        }
        return com.sijla.mla.a.h.a(af);
    }

    @Override // com.sijla.mla.a.r
    public final com.sijla.mla.a.n b(com.sijla.mla.a.n nVar) {
        return this;
    }

    @Override // com.sijla.mla.a.r
    public final com.sijla.mla.a.r c(double d) {
        return com.sijla.mla.a.h.a(ae() + d);
    }

    @Override // com.sijla.mla.a.r
    public final com.sijla.mla.a.r c(com.sijla.mla.a.n nVar) {
        int i = nVar.d;
        int i2 = this.d + i;
        byte[] bArr = new byte[i2];
        java.lang.System.arraycopy(nVar.b, nVar.c, bArr, 0, i);
        java.lang.System.arraycopy(this.b, this.c, bArr, nVar.d, this.d);
        return b(bArr, 0, i2);
    }

    @Override // com.sijla.mla.a.r
    public final java.lang.String c() {
        return com.sijla.mla.L2.s1539217359();
    }

    public final void c(byte[] bArr, int i, int i2) {
        java.lang.System.arraycopy(this.b, this.c, bArr, i, i2);
    }

    @Override // com.sijla.mla.a.r
    public final boolean c(com.sijla.mla.a.r rVar) {
        return rVar.d(this);
    }

    @Override // com.sijla.mla.a.r
    public final boolean c_() {
        double af = af();
        return !java.lang.Double.isNaN(af) && ((double) ((int) af)) == af;
    }

    @Override // com.sijla.mla.a.r
    public final com.sijla.mla.a.r d(double d) {
        return com.sijla.mla.a.h.a(d - ae());
    }

    @Override // com.sijla.mla.a.r
    public final com.sijla.mla.a.r d(int i) {
        return com.sijla.mla.a.b.k.a(i, ae());
    }

    @Override // com.sijla.mla.a.r
    public final boolean d(com.sijla.mla.a.n nVar) {
        if (this == nVar) {
            return true;
        }
        if (nVar.d != this.d) {
            return false;
        }
        if (nVar.b == this.b && nVar.c == this.c) {
            return true;
        }
        if (nVar.hashCode() != hashCode()) {
            return false;
        }
        for (int i = 0; i < this.d; i++) {
            if (nVar.b[nVar.c + i] != this.b[this.c + i]) {
                return false;
            }
        }
        return true;
    }

    @Override // com.sijla.mla.a.r
    public final boolean d(com.sijla.mla.a.r rVar) {
        return rVar.d(this);
    }

    @Override // com.sijla.mla.a.r
    public final com.sijla.mla.a.r e(double d) {
        return com.sijla.mla.a.h.a(ae() * d);
    }

    @Override // com.sijla.mla.a.r
    public final com.sijla.mla.a.r e(com.sijla.mla.a.r rVar) {
        double af = af();
        return java.lang.Double.isNaN(af) ? f(com.sijla.mla.a.r.w, rVar) : rVar.c(af);
    }

    @Override // com.sijla.mla.a.r
    public final boolean e(int i) {
        f("attempt to compare string with number");
        return false;
    }

    public final com.sijla.mla.a.r e_(int i) {
        double d = Double.NaN;
        if (i >= 2 && i <= 36) {
            int i2 = this.c;
            int i3 = this.d + i2;
            while (i2 < i3 && this.b[i2] == 32) {
                i2++;
            }
            while (i2 < i3 && this.b[i3 - 1] == 32) {
                i3--;
            }
            if (i2 < i3) {
                d = a(i, i2, i3);
            }
        }
        return java.lang.Double.isNaN(d) ? com.sijla.mla.a.r.k : com.sijla.mla.a.h.a(d);
    }

    @Override // com.sijla.mla.a.r
    public final boolean equals(java.lang.Object obj) {
        if (obj instanceof com.sijla.mla.a.n) {
            return d((com.sijla.mla.a.n) obj);
        }
        return false;
    }

    @Override // com.sijla.mla.a.r
    public final com.sijla.mla.a.r f(double d) {
        return com.sijla.mla.a.b.k.a(d, ae());
    }

    @Override // com.sijla.mla.a.r
    public final com.sijla.mla.a.r f(com.sijla.mla.a.r rVar) {
        double af = af();
        return java.lang.Double.isNaN(af) ? f(com.sijla.mla.a.r.x, rVar) : rVar.d(af);
    }

    @Override // com.sijla.mla.a.r
    public final boolean f(int i) {
        f("attempt to compare string with number");
        return false;
    }

    @Override // com.sijla.mla.a.r
    public final com.sijla.mla.a.r g(double d) {
        return com.sijla.mla.a.h.a(d, ae());
    }

    @Override // com.sijla.mla.a.r
    public final com.sijla.mla.a.r g(com.sijla.mla.a.r rVar) {
        double af = af();
        return java.lang.Double.isNaN(af) ? f(com.sijla.mla.a.r.z, rVar) : rVar.e(af);
    }

    @Override // com.sijla.mla.a.r, com.sijla.mla.a.y
    public final java.lang.String g() {
        int i;
        byte[] bArr = this.b;
        int i2 = this.c;
        int i3 = this.d + i2;
        int i4 = 0;
        int i5 = i2;
        int i6 = 0;
        while (i5 < i3) {
            int i7 = i5 + 1;
            int i8 = bArr[i5] & 224;
            if (i8 != 192) {
                if (i8 == 224) {
                    i7++;
                }
                i5 = i7;
                i6++;
            }
            i7++;
            i5 = i7;
            i6++;
        }
        char[] cArr = new char[i6];
        while (i2 < i3) {
            int i9 = i4 + 1;
            int i10 = i2 + 1;
            int i11 = bArr[i2];
            if (i11 < 0 && i10 < i3) {
                if (i11 < -32 || (i = i10 + 1) >= i3) {
                    i11 = ((i11 & 63) << 6) | (bArr[i10] & '?');
                    i10++;
                } else {
                    int i12 = ((i11 & 15) << 12) | ((bArr[i10] & '?') << 6);
                    i10 = i + 1;
                    i11 = i12 | (bArr[i] & '?');
                }
            }
            cArr[i4] = (char) i11;
            i4 = i9;
            i2 = i10;
        }
        return new java.lang.String(cArr);
    }

    @Override // com.sijla.mla.a.r
    public final boolean g(int i) {
        f("attempt to compare string with number");
        return false;
    }

    public final int h(int i) {
        return this.b[this.c + i] & 255;
    }

    @Override // com.sijla.mla.a.r
    public final com.sijla.mla.a.r h(double d) {
        return com.sijla.mla.a.h.b(d, ae());
    }

    @Override // com.sijla.mla.a.r
    public final com.sijla.mla.a.r h(com.sijla.mla.a.r rVar) {
        double af = af();
        return java.lang.Double.isNaN(af) ? f(com.sijla.mla.a.r.A, rVar) : rVar.f(af);
    }

    public final int hashCode() {
        return this.e;
    }

    @Override // com.sijla.mla.a.r
    public final com.sijla.mla.a.r i(com.sijla.mla.a.r rVar) {
        double af = af();
        return java.lang.Double.isNaN(af) ? f(com.sijla.mla.a.r.y, rVar) : rVar.g(af);
    }

    @Override // com.sijla.mla.a.r
    public final boolean i(double d) {
        f("attempt to compare string with number");
        return false;
    }

    @Override // com.sijla.mla.a.r
    public final com.sijla.mla.a.r j() {
        return a;
    }

    @Override // com.sijla.mla.a.r
    public final com.sijla.mla.a.r j(int i) {
        return com.sijla.mla.a.h.a(ae() + i);
    }

    @Override // com.sijla.mla.a.r
    public final com.sijla.mla.a.r j(com.sijla.mla.a.r rVar) {
        double af = af();
        return java.lang.Double.isNaN(af) ? f(com.sijla.mla.a.r.B, rVar) : rVar.h(af);
    }

    @Override // com.sijla.mla.a.r
    public final boolean j(double d) {
        f("attempt to compare string with number");
        return false;
    }

    @Override // com.sijla.mla.a.r
    public final boolean k(double d) {
        f("attempt to compare string with number");
        return false;
    }

    @Override // com.sijla.mla.a.r
    public final boolean k(com.sijla.mla.a.r rVar) {
        return rVar.a(this) > 0;
    }

    @Override // com.sijla.mla.a.r
    public final boolean l(com.sijla.mla.a.r rVar) {
        return rVar.a(this) >= 0;
    }

    @Override // com.sijla.mla.a.r
    public final boolean m(com.sijla.mla.a.r rVar) {
        return rVar.a(this) <= 0;
    }

    @Override // com.sijla.mla.a.r
    public final boolean n() {
        double af = af();
        return !java.lang.Double.isNaN(af) && ((double) ((long) af)) == af;
    }

    @Override // com.sijla.mla.a.r
    public final double o() {
        double af = af();
        if (java.lang.Double.isNaN(af)) {
            return 0.0d;
        }
        return af;
    }

    @Override // com.sijla.mla.a.r
    public final com.sijla.mla.a.r o(com.sijla.mla.a.r rVar) {
        return rVar.c(this);
    }

    @Override // com.sijla.mla.a.r
    public final int p() {
        return (int) o();
    }

    @Override // com.sijla.mla.a.r
    public final long q() {
        return (long) o();
    }

    @Override // com.sijla.mla.a.r
    public final com.sijla.mla.a.r r() {
        double af = af();
        return java.lang.Double.isNaN(af) ? super.r() : com.sijla.mla.a.h.a(-af);
    }

    @Override // com.sijla.mla.a.r
    public final com.sijla.mla.a.n s() {
        return this;
    }

    @Override // com.sijla.mla.a.r
    public final com.sijla.mla.a.r t() {
        return this;
    }

    @Override // com.sijla.mla.a.r
    public final boolean u() {
        return !java.lang.Double.isNaN(af());
    }

    @Override // com.sijla.mla.a.r
    public final boolean v() {
        return true;
    }

    @Override // com.sijla.mla.a.r
    public final com.sijla.mla.a.r w() {
        double af = af();
        return java.lang.Double.isNaN(af) ? com.sijla.mla.a.r.k : com.sijla.mla.a.h.a(af);
    }

    @Override // com.sijla.mla.a.r
    public final int x() {
        return (int) A();
    }

    @Override // com.sijla.mla.a.r
    public final long y() {
        return (long) A();
    }

    @Override // com.sijla.mla.a.r
    public final com.sijla.mla.a.m z() {
        return com.sijla.mla.a.h.a(A());
    }
}
