package com.umeng.analytics.pro;

/* loaded from: classes19.dex */
public class cv extends com.umeng.analytics.pro.db {
    private static final com.umeng.analytics.pro.dg d = new com.umeng.analytics.pro.dg("");
    private static final com.umeng.analytics.pro.cw e = new com.umeng.analytics.pro.cw("", (byte) 0, 0);
    private static final byte[] f = {0, 0, 1, 3, 7, 0, 4, 0, 5, 0, 6, 8, 12, 11, 10, 9};
    private static final byte h = -126;
    private static final byte i = 1;
    private static final byte j = 31;
    private static final byte k = -32;
    private static final int l = 5;
    byte[] a;
    byte[] b;
    byte[] c;
    private com.umeng.analytics.pro.ca m;
    private short n;
    private com.umeng.analytics.pro.cw o;
    private java.lang.Boolean p;
    private final long q;
    private byte[] r;

    public static class a implements com.umeng.analytics.pro.dd {
        private final long a;

        public a() {
            this.a = -1L;
        }

        public a(int i) {
            this.a = i;
        }

        @Override // com.umeng.analytics.pro.dd
        public com.umeng.analytics.pro.db a(com.umeng.analytics.pro.dp dpVar) {
            return new com.umeng.analytics.pro.cv(dpVar, this.a);
        }
    }

    public static class b {
        public static final byte a = 1;
        public static final byte b = 2;
        public static final byte c = 3;
        public static final byte d = 4;
        public static final byte e = 5;
        public static final byte f = 6;
        public static final byte g = 7;
        public static final byte h = 8;
        public static final byte i = 9;
        public static final byte j = 10;
        public static final byte k = 11;
        public static final byte l = 12;

        private b() {
        }
    }

    public cv(com.umeng.analytics.pro.dp dpVar) {
        this(dpVar, -1L);
    }

    public cv(com.umeng.analytics.pro.dp dpVar, long j2) {
        super(dpVar);
        this.m = new com.umeng.analytics.pro.ca(15);
        this.n = (short) 0;
        this.o = null;
        this.p = null;
        this.a = new byte[5];
        this.b = new byte[10];
        this.r = new byte[1];
        this.c = new byte[1];
        this.q = j2;
    }

    private int E() throws com.umeng.analytics.pro.ci {
        int i2 = 0;
        if (this.g.h() >= 5) {
            byte[] f2 = this.g.f();
            int g = this.g.g();
            int i3 = 0;
            int i4 = 0;
            while (true) {
                byte b2 = f2[g + i2];
                i3 |= (b2 & Byte.MAX_VALUE) << i4;
                if ((b2 & 128) != 128) {
                    this.g.a(i2 + 1);
                    return i3;
                }
                i4 += 7;
                i2++;
            }
        } else {
            int i5 = 0;
            while (true) {
                byte u = u();
                i2 |= (u & Byte.MAX_VALUE) << i5;
                if ((u & 128) != 128) {
                    return i2;
                }
                i5 += 7;
            }
        }
    }

    private long F() throws com.umeng.analytics.pro.ci {
        int i2 = 0;
        long j2 = 0;
        if (this.g.h() >= 10) {
            byte[] f2 = this.g.f();
            int g = this.g.g();
            long j3 = 0;
            int i3 = 0;
            while (true) {
                j3 |= (r7 & Byte.MAX_VALUE) << i3;
                if ((f2[g + i2] & 128) != 128) {
                    this.g.a(i2 + 1);
                    return j3;
                }
                i3 += 7;
                i2++;
            }
        } else {
            while (true) {
                j2 |= (r0 & Byte.MAX_VALUE) << i2;
                if ((u() & 128) != 128) {
                    return j2;
                }
                i2 += 7;
            }
        }
    }

    private long a(byte[] bArr) {
        return ((bArr[7] & 255) << 56) | ((bArr[6] & 255) << 48) | ((bArr[5] & 255) << 40) | ((bArr[4] & 255) << 32) | ((bArr[3] & 255) << 24) | ((bArr[2] & 255) << 16) | ((bArr[1] & 255) << 8) | (255 & bArr[0]);
    }

    private void a(long j2, byte[] bArr, int i2) {
        bArr[i2 + 0] = (byte) (j2 & 255);
        bArr[i2 + 1] = (byte) ((j2 >> 8) & 255);
        bArr[i2 + 2] = (byte) ((j2 >> 16) & 255);
        bArr[i2 + 3] = (byte) ((j2 >> 24) & 255);
        bArr[i2 + 4] = (byte) ((j2 >> 32) & 255);
        bArr[i2 + 5] = (byte) ((j2 >> 40) & 255);
        bArr[i2 + 6] = (byte) ((j2 >> 48) & 255);
        bArr[i2 + 7] = (byte) ((j2 >> 56) & 255);
    }

    private void a(com.umeng.analytics.pro.cw cwVar, byte b2) throws com.umeng.analytics.pro.ci {
        if (b2 == -1) {
            b2 = e(cwVar.b);
        }
        short s2 = cwVar.c;
        short s3 = this.n;
        if (s2 <= s3 || s2 - s3 > 15) {
            b(b2);
            a(cwVar.c);
        } else {
            d(b2 | ((s2 - s3) << 4));
        }
        this.n = cwVar.c;
    }

    private void a(byte[] bArr, int i2, int i3) throws com.umeng.analytics.pro.ci {
        b(i3);
        this.g.b(bArr, i2, i3);
    }

    private void b(byte b2) throws com.umeng.analytics.pro.ci {
        byte[] bArr = this.r;
        bArr[0] = b2;
        this.g.b(bArr);
    }

    private void b(int i2) throws com.umeng.analytics.pro.ci {
        int i3 = 0;
        while ((i2 & com.alipay.sdk.m.n.a.g) != 0) {
            this.a[i3] = (byte) ((i2 & 127) | 128);
            i2 >>>= 7;
            i3++;
        }
        byte[] bArr = this.a;
        bArr[i3] = (byte) i2;
        this.g.b(bArr, 0, i3 + 1);
    }

    private void b(long j2) throws com.umeng.analytics.pro.ci {
        int i2 = 0;
        while (((-128) & j2) != 0) {
            this.b[i2] = (byte) ((127 & j2) | 128);
            j2 >>>= 7;
            i2++;
        }
        byte[] bArr = this.b;
        bArr[i2] = (byte) j2;
        this.g.b(bArr, 0, i2 + 1);
    }

    private int c(int i2) {
        return (i2 >> 31) ^ (i2 << 1);
    }

    private long c(long j2) {
        return (j2 >> 63) ^ (j2 << 1);
    }

    private boolean c(byte b2) {
        int i2 = b2 & 15;
        return i2 == 1 || i2 == 2;
    }

    private byte d(byte b2) throws com.umeng.analytics.pro.dc {
        byte b3 = (byte) (b2 & 15);
        switch (b3) {
            case 0:
                return (byte) 0;
            case 1:
            case 2:
                return (byte) 2;
            case 3:
                return (byte) 3;
            case 4:
                return (byte) 6;
            case 5:
                return (byte) 8;
            case 6:
                return (byte) 10;
            case 7:
                return (byte) 4;
            case 8:
                return (byte) 11;
            case 9:
                return (byte) 15;
            case 10:
                return (byte) 14;
            case 11:
                return (byte) 13;
            case 12:
                return (byte) 12;
            default:
                throw new com.umeng.analytics.pro.dc("don't know what type: " + ((int) b3));
        }
    }

    private long d(long j2) {
        return (-(j2 & 1)) ^ (j2 >>> 1);
    }

    private void d(int i2) throws com.umeng.analytics.pro.ci {
        b((byte) i2);
    }

    private byte e(byte b2) {
        return f[b2];
    }

    private byte[] e(int i2) throws com.umeng.analytics.pro.ci {
        if (i2 == 0) {
            return new byte[0];
        }
        byte[] bArr = new byte[i2];
        this.g.d(bArr, 0, i2);
        return bArr;
    }

    private void f(int i2) throws com.umeng.analytics.pro.dc {
        if (i2 < 0) {
            throw new com.umeng.analytics.pro.dc("Negative length: " + i2);
        }
        long j2 = this.q;
        if (j2 == -1 || i2 <= j2) {
            return;
        }
        throw new com.umeng.analytics.pro.dc("Length exceeded max allowed: " + i2);
    }

    private int g(int i2) {
        return (-(i2 & 1)) ^ (i2 >>> 1);
    }

    @Override // com.umeng.analytics.pro.db
    public java.nio.ByteBuffer A() throws com.umeng.analytics.pro.ci {
        int E = E();
        f(E);
        if (E == 0) {
            return java.nio.ByteBuffer.wrap(new byte[0]);
        }
        byte[] bArr = new byte[E];
        this.g.d(bArr, 0, E);
        return java.nio.ByteBuffer.wrap(bArr);
    }

    @Override // com.umeng.analytics.pro.db
    public void B() {
        this.m.c();
        this.n = (short) 0;
    }

    @Override // com.umeng.analytics.pro.db
    public void a() throws com.umeng.analytics.pro.ci {
    }

    @Override // com.umeng.analytics.pro.db
    public void a(byte b2) throws com.umeng.analytics.pro.ci {
        b(b2);
    }

    public void a(byte b2, int i2) throws com.umeng.analytics.pro.ci {
        if (i2 <= 14) {
            d(e(b2) | (i2 << 4));
        } else {
            d(e(b2) | 240);
            b(i2);
        }
    }

    @Override // com.umeng.analytics.pro.db
    public void a(double d2) throws com.umeng.analytics.pro.ci {
        byte[] bArr = {0, 0, 0, 0, 0, 0, 0, 0};
        a(java.lang.Double.doubleToLongBits(d2), bArr, 0);
        this.g.b(bArr);
    }

    @Override // com.umeng.analytics.pro.db
    public void a(int i2) throws com.umeng.analytics.pro.ci {
        b(c(i2));
    }

    @Override // com.umeng.analytics.pro.db
    public void a(long j2) throws com.umeng.analytics.pro.ci {
        b(c(j2));
    }

    @Override // com.umeng.analytics.pro.db
    public void a(com.umeng.analytics.pro.cw cwVar) throws com.umeng.analytics.pro.ci {
        if (cwVar.b == 2) {
            this.o = cwVar;
        } else {
            a(cwVar, (byte) -1);
        }
    }

    @Override // com.umeng.analytics.pro.db
    public void a(com.umeng.analytics.pro.cx cxVar) throws com.umeng.analytics.pro.ci {
        a(cxVar.a, cxVar.b);
    }

    @Override // com.umeng.analytics.pro.db
    public void a(com.umeng.analytics.pro.cy cyVar) throws com.umeng.analytics.pro.ci {
        int i2 = cyVar.c;
        if (i2 == 0) {
            d(0);
            return;
        }
        b(i2);
        d(e(cyVar.b) | (e(cyVar.a) << 4));
    }

    @Override // com.umeng.analytics.pro.db
    public void a(com.umeng.analytics.pro.cz czVar) throws com.umeng.analytics.pro.ci {
        b(h);
        d(((czVar.b << 5) & (-32)) | 1);
        b(czVar.c);
        a(czVar.a);
    }

    @Override // com.umeng.analytics.pro.db
    public void a(com.umeng.analytics.pro.df dfVar) throws com.umeng.analytics.pro.ci {
        a(dfVar.a, dfVar.b);
    }

    @Override // com.umeng.analytics.pro.db
    public void a(com.umeng.analytics.pro.dg dgVar) throws com.umeng.analytics.pro.ci {
        this.m.a(this.n);
        this.n = (short) 0;
    }

    @Override // com.umeng.analytics.pro.db
    public void a(java.lang.String str) throws com.umeng.analytics.pro.ci {
        try {
            byte[] bytes = str.getBytes("UTF-8");
            a(bytes, 0, bytes.length);
        } catch (java.io.UnsupportedEncodingException unused) {
            throw new com.umeng.analytics.pro.ci("UTF-8 not supported!");
        }
    }

    @Override // com.umeng.analytics.pro.db
    public void a(java.nio.ByteBuffer byteBuffer) throws com.umeng.analytics.pro.ci {
        a(byteBuffer.array(), byteBuffer.position() + byteBuffer.arrayOffset(), byteBuffer.limit() - byteBuffer.position());
    }

    @Override // com.umeng.analytics.pro.db
    public void a(short s2) throws com.umeng.analytics.pro.ci {
        b(c((int) s2));
    }

    @Override // com.umeng.analytics.pro.db
    public void a(boolean z) throws com.umeng.analytics.pro.ci {
        com.umeng.analytics.pro.cw cwVar = this.o;
        if (cwVar == null) {
            b(z ? (byte) 1 : (byte) 2);
        } else {
            a(cwVar, z ? (byte) 1 : (byte) 2);
            this.o = null;
        }
    }

    @Override // com.umeng.analytics.pro.db
    public void b() throws com.umeng.analytics.pro.ci {
        this.n = this.m.a();
    }

    @Override // com.umeng.analytics.pro.db
    public void c() throws com.umeng.analytics.pro.ci {
    }

    @Override // com.umeng.analytics.pro.db
    public void d() throws com.umeng.analytics.pro.ci {
        b((byte) 0);
    }

    @Override // com.umeng.analytics.pro.db
    public void e() throws com.umeng.analytics.pro.ci {
    }

    @Override // com.umeng.analytics.pro.db
    public void f() throws com.umeng.analytics.pro.ci {
    }

    @Override // com.umeng.analytics.pro.db
    public void g() throws com.umeng.analytics.pro.ci {
    }

    @Override // com.umeng.analytics.pro.db
    public com.umeng.analytics.pro.cz h() throws com.umeng.analytics.pro.ci {
        byte u = u();
        if (u != -126) {
            throw new com.umeng.analytics.pro.dc("Expected protocol id " + java.lang.Integer.toHexString(-126) + " but got " + java.lang.Integer.toHexString(u));
        }
        byte u2 = u();
        byte b2 = (byte) (u2 & 31);
        if (b2 == 1) {
            return new com.umeng.analytics.pro.cz(z(), (byte) ((u2 >> 5) & 3), E());
        }
        throw new com.umeng.analytics.pro.dc("Expected version 1 but got " + ((int) b2));
    }

    @Override // com.umeng.analytics.pro.db
    public void i() throws com.umeng.analytics.pro.ci {
    }

    @Override // com.umeng.analytics.pro.db
    public com.umeng.analytics.pro.dg j() throws com.umeng.analytics.pro.ci {
        this.m.a(this.n);
        this.n = (short) 0;
        return d;
    }

    @Override // com.umeng.analytics.pro.db
    public void k() throws com.umeng.analytics.pro.ci {
        this.n = this.m.a();
    }

    @Override // com.umeng.analytics.pro.db
    public com.umeng.analytics.pro.cw l() throws com.umeng.analytics.pro.ci {
        byte u = u();
        if (u == 0) {
            return e;
        }
        short s2 = (short) ((u & 240) >> 4);
        byte b2 = (byte) (u & 15);
        com.umeng.analytics.pro.cw cwVar = new com.umeng.analytics.pro.cw("", d(b2), s2 == 0 ? v() : (short) (this.n + s2));
        if (c(u)) {
            this.p = b2 == 1 ? java.lang.Boolean.TRUE : java.lang.Boolean.FALSE;
        }
        this.n = cwVar.c;
        return cwVar;
    }

    @Override // com.umeng.analytics.pro.db
    public void m() throws com.umeng.analytics.pro.ci {
    }

    @Override // com.umeng.analytics.pro.db
    public com.umeng.analytics.pro.cy n() throws com.umeng.analytics.pro.ci {
        int E = E();
        byte u = E == 0 ? (byte) 0 : u();
        return new com.umeng.analytics.pro.cy(d((byte) (u >> 4)), d((byte) (u & 15)), E);
    }

    @Override // com.umeng.analytics.pro.db
    public void o() throws com.umeng.analytics.pro.ci {
    }

    @Override // com.umeng.analytics.pro.db
    public com.umeng.analytics.pro.cx p() throws com.umeng.analytics.pro.ci {
        byte u = u();
        int i2 = (u >> 4) & 15;
        if (i2 == 15) {
            i2 = E();
        }
        return new com.umeng.analytics.pro.cx(d(u), i2);
    }

    @Override // com.umeng.analytics.pro.db
    public void q() throws com.umeng.analytics.pro.ci {
    }

    @Override // com.umeng.analytics.pro.db
    public com.umeng.analytics.pro.df r() throws com.umeng.analytics.pro.ci {
        return new com.umeng.analytics.pro.df(p());
    }

    @Override // com.umeng.analytics.pro.db
    public void s() throws com.umeng.analytics.pro.ci {
    }

    @Override // com.umeng.analytics.pro.db
    public boolean t() throws com.umeng.analytics.pro.ci {
        java.lang.Boolean bool = this.p;
        if (bool == null) {
            return u() == 1;
        }
        boolean booleanValue = bool.booleanValue();
        this.p = null;
        return booleanValue;
    }

    @Override // com.umeng.analytics.pro.db
    public byte u() throws com.umeng.analytics.pro.ci {
        if (this.g.h() <= 0) {
            this.g.d(this.c, 0, 1);
            return this.c[0];
        }
        byte b2 = this.g.f()[this.g.g()];
        this.g.a(1);
        return b2;
    }

    @Override // com.umeng.analytics.pro.db
    public short v() throws com.umeng.analytics.pro.ci {
        return (short) g(E());
    }

    @Override // com.umeng.analytics.pro.db
    public int w() throws com.umeng.analytics.pro.ci {
        return g(E());
    }

    @Override // com.umeng.analytics.pro.db
    public long x() throws com.umeng.analytics.pro.ci {
        return d(F());
    }

    @Override // com.umeng.analytics.pro.db
    public double y() throws com.umeng.analytics.pro.ci {
        byte[] bArr = new byte[8];
        this.g.d(bArr, 0, 8);
        return java.lang.Double.longBitsToDouble(a(bArr));
    }

    @Override // com.umeng.analytics.pro.db
    public java.lang.String z() throws com.umeng.analytics.pro.ci {
        int E = E();
        f(E);
        if (E == 0) {
            return "";
        }
        try {
            if (this.g.h() < E) {
                return new java.lang.String(e(E), "UTF-8");
            }
            java.lang.String str = new java.lang.String(this.g.f(), this.g.g(), E, "UTF-8");
            this.g.a(E);
            return str;
        } catch (java.io.UnsupportedEncodingException unused) {
            throw new com.umeng.analytics.pro.ci("UTF-8 not supported!");
        }
    }
}
