package com.umeng.analytics.pro;

/* loaded from: classes19.dex */
public class cu extends com.umeng.analytics.pro.db {
    protected static final int a = -65536;
    protected static final int b = -2147418112;
    private static final com.umeng.analytics.pro.dg h = new com.umeng.analytics.pro.dg();
    protected boolean c;
    protected boolean d;
    protected int e;
    protected boolean f;
    private byte[] i;
    private byte[] j;
    private byte[] k;
    private byte[] l;
    private byte[] m;
    private byte[] n;
    private byte[] o;
    private byte[] p;

    public static class a implements com.umeng.analytics.pro.dd {
        protected boolean a;
        protected boolean b;
        protected int c;

        public a() {
            this(false, true);
        }

        public a(boolean z, boolean z2) {
            this(z, z2, 0);
        }

        public a(boolean z, boolean z2, int i) {
            this.a = z;
            this.b = z2;
            this.c = i;
        }

        @Override // com.umeng.analytics.pro.dd
        public com.umeng.analytics.pro.db a(com.umeng.analytics.pro.dp dpVar) {
            com.umeng.analytics.pro.cu cuVar = new com.umeng.analytics.pro.cu(dpVar, this.a, this.b);
            int i = this.c;
            if (i != 0) {
                cuVar.c(i);
            }
            return cuVar;
        }
    }

    public cu(com.umeng.analytics.pro.dp dpVar) {
        this(dpVar, false, true);
    }

    public cu(com.umeng.analytics.pro.dp dpVar, boolean z, boolean z2) {
        super(dpVar);
        this.f = false;
        this.i = new byte[1];
        this.j = new byte[2];
        this.k = new byte[4];
        this.l = new byte[8];
        this.m = new byte[1];
        this.n = new byte[2];
        this.o = new byte[4];
        this.p = new byte[8];
        this.c = z;
        this.d = z2;
    }

    private int a(byte[] bArr, int i, int i2) throws com.umeng.analytics.pro.ci {
        d(i2);
        return this.g.d(bArr, i, i2);
    }

    @Override // com.umeng.analytics.pro.db
    public java.nio.ByteBuffer A() throws com.umeng.analytics.pro.ci {
        int w = w();
        d(w);
        if (this.g.h() >= w) {
            java.nio.ByteBuffer wrap = java.nio.ByteBuffer.wrap(this.g.f(), this.g.g(), w);
            this.g.a(w);
            return wrap;
        }
        byte[] bArr = new byte[w];
        this.g.d(bArr, 0, w);
        return java.nio.ByteBuffer.wrap(bArr);
    }

    @Override // com.umeng.analytics.pro.db
    public void a() {
    }

    @Override // com.umeng.analytics.pro.db
    public void a(byte b2) throws com.umeng.analytics.pro.ci {
        byte[] bArr = this.i;
        bArr[0] = b2;
        this.g.b(bArr, 0, 1);
    }

    @Override // com.umeng.analytics.pro.db
    public void a(double d) throws com.umeng.analytics.pro.ci {
        a(java.lang.Double.doubleToLongBits(d));
    }

    @Override // com.umeng.analytics.pro.db
    public void a(int i) throws com.umeng.analytics.pro.ci {
        byte[] bArr = this.k;
        bArr[0] = (byte) ((i >> 24) & 255);
        bArr[1] = (byte) ((i >> 16) & 255);
        bArr[2] = (byte) ((i >> 8) & 255);
        bArr[3] = (byte) (i & 255);
        this.g.b(bArr, 0, 4);
    }

    @Override // com.umeng.analytics.pro.db
    public void a(long j) throws com.umeng.analytics.pro.ci {
        byte[] bArr = this.l;
        bArr[0] = (byte) ((j >> 56) & 255);
        bArr[1] = (byte) ((j >> 48) & 255);
        bArr[2] = (byte) ((j >> 40) & 255);
        bArr[3] = (byte) ((j >> 32) & 255);
        bArr[4] = (byte) ((j >> 24) & 255);
        bArr[5] = (byte) ((j >> 16) & 255);
        bArr[6] = (byte) ((j >> 8) & 255);
        bArr[7] = (byte) (j & 255);
        this.g.b(bArr, 0, 8);
    }

    @Override // com.umeng.analytics.pro.db
    public void a(com.umeng.analytics.pro.cw cwVar) throws com.umeng.analytics.pro.ci {
        a(cwVar.b);
        a(cwVar.c);
    }

    @Override // com.umeng.analytics.pro.db
    public void a(com.umeng.analytics.pro.cx cxVar) throws com.umeng.analytics.pro.ci {
        a(cxVar.a);
        a(cxVar.b);
    }

    @Override // com.umeng.analytics.pro.db
    public void a(com.umeng.analytics.pro.cy cyVar) throws com.umeng.analytics.pro.ci {
        a(cyVar.a);
        a(cyVar.b);
        a(cyVar.c);
    }

    @Override // com.umeng.analytics.pro.db
    public void a(com.umeng.analytics.pro.cz czVar) throws com.umeng.analytics.pro.ci {
        if (this.d) {
            a(czVar.b | b);
            a(czVar.a);
            a(czVar.c);
        } else {
            a(czVar.a);
            a(czVar.b);
            a(czVar.c);
        }
    }

    @Override // com.umeng.analytics.pro.db
    public void a(com.umeng.analytics.pro.df dfVar) throws com.umeng.analytics.pro.ci {
        a(dfVar.a);
        a(dfVar.b);
    }

    @Override // com.umeng.analytics.pro.db
    public void a(com.umeng.analytics.pro.dg dgVar) {
    }

    @Override // com.umeng.analytics.pro.db
    public void a(java.lang.String str) throws com.umeng.analytics.pro.ci {
        try {
            byte[] bytes = str.getBytes("UTF-8");
            a(bytes.length);
            this.g.b(bytes, 0, bytes.length);
        } catch (java.io.UnsupportedEncodingException unused) {
            throw new com.umeng.analytics.pro.ci("JVM DOES NOT SUPPORT UTF-8");
        }
    }

    @Override // com.umeng.analytics.pro.db
    public void a(java.nio.ByteBuffer byteBuffer) throws com.umeng.analytics.pro.ci {
        int limit = byteBuffer.limit() - byteBuffer.position();
        a(limit);
        this.g.b(byteBuffer.array(), byteBuffer.position() + byteBuffer.arrayOffset(), limit);
    }

    @Override // com.umeng.analytics.pro.db
    public void a(short s2) throws com.umeng.analytics.pro.ci {
        byte[] bArr = this.j;
        bArr[0] = (byte) ((s2 >> 8) & 255);
        bArr[1] = (byte) (s2 & 255);
        this.g.b(bArr, 0, 2);
    }

    @Override // com.umeng.analytics.pro.db
    public void a(boolean z) throws com.umeng.analytics.pro.ci {
        a(z ? (byte) 1 : (byte) 0);
    }

    public java.lang.String b(int i) throws com.umeng.analytics.pro.ci {
        try {
            d(i);
            byte[] bArr = new byte[i];
            this.g.d(bArr, 0, i);
            return new java.lang.String(bArr, "UTF-8");
        } catch (java.io.UnsupportedEncodingException unused) {
            throw new com.umeng.analytics.pro.ci("JVM DOES NOT SUPPORT UTF-8");
        }
    }

    @Override // com.umeng.analytics.pro.db
    public void b() {
    }

    @Override // com.umeng.analytics.pro.db
    public void c() {
    }

    public void c(int i) {
        this.e = i;
        this.f = true;
    }

    @Override // com.umeng.analytics.pro.db
    public void d() throws com.umeng.analytics.pro.ci {
        a((byte) 0);
    }

    public void d(int i) throws com.umeng.analytics.pro.ci {
        if (i < 0) {
            throw new com.umeng.analytics.pro.dc("Negative length: " + i);
        }
        if (this.f) {
            int i2 = this.e - i;
            this.e = i2;
            if (i2 >= 0) {
                return;
            }
            throw new com.umeng.analytics.pro.dc("Message length exceeded: " + i);
        }
    }

    @Override // com.umeng.analytics.pro.db
    public void e() {
    }

    @Override // com.umeng.analytics.pro.db
    public void f() {
    }

    @Override // com.umeng.analytics.pro.db
    public void g() {
    }

    @Override // com.umeng.analytics.pro.db
    public com.umeng.analytics.pro.cz h() throws com.umeng.analytics.pro.ci {
        int w = w();
        if (w < 0) {
            if (((-65536) & w) == b) {
                return new com.umeng.analytics.pro.cz(z(), (byte) (w & 255), w());
            }
            throw new com.umeng.analytics.pro.dc(4, "Bad version in readMessageBegin");
        }
        if (this.c) {
            throw new com.umeng.analytics.pro.dc(4, "Missing version in readMessageBegin, old client?");
        }
        return new com.umeng.analytics.pro.cz(b(w), u(), w());
    }

    @Override // com.umeng.analytics.pro.db
    public void i() {
    }

    @Override // com.umeng.analytics.pro.db
    public com.umeng.analytics.pro.dg j() {
        return h;
    }

    @Override // com.umeng.analytics.pro.db
    public void k() {
    }

    @Override // com.umeng.analytics.pro.db
    public com.umeng.analytics.pro.cw l() throws com.umeng.analytics.pro.ci {
        byte u = u();
        return new com.umeng.analytics.pro.cw("", u, u == 0 ? (short) 0 : v());
    }

    @Override // com.umeng.analytics.pro.db
    public void m() {
    }

    @Override // com.umeng.analytics.pro.db
    public com.umeng.analytics.pro.cy n() throws com.umeng.analytics.pro.ci {
        return new com.umeng.analytics.pro.cy(u(), u(), w());
    }

    @Override // com.umeng.analytics.pro.db
    public void o() {
    }

    @Override // com.umeng.analytics.pro.db
    public com.umeng.analytics.pro.cx p() throws com.umeng.analytics.pro.ci {
        return new com.umeng.analytics.pro.cx(u(), w());
    }

    @Override // com.umeng.analytics.pro.db
    public void q() {
    }

    @Override // com.umeng.analytics.pro.db
    public com.umeng.analytics.pro.df r() throws com.umeng.analytics.pro.ci {
        return new com.umeng.analytics.pro.df(u(), w());
    }

    @Override // com.umeng.analytics.pro.db
    public void s() {
    }

    @Override // com.umeng.analytics.pro.db
    public boolean t() throws com.umeng.analytics.pro.ci {
        return u() == 1;
    }

    @Override // com.umeng.analytics.pro.db
    public byte u() throws com.umeng.analytics.pro.ci {
        if (this.g.h() < 1) {
            a(this.m, 0, 1);
            return this.m[0];
        }
        byte b2 = this.g.f()[this.g.g()];
        this.g.a(1);
        return b2;
    }

    @Override // com.umeng.analytics.pro.db
    public short v() throws com.umeng.analytics.pro.ci {
        int i;
        byte[] bArr = this.n;
        if (this.g.h() >= 2) {
            bArr = this.g.f();
            i = this.g.g();
            this.g.a(2);
        } else {
            a(this.n, 0, 2);
            i = 0;
        }
        return (short) ((bArr[i + 1] & 255) | ((bArr[i] & 255) << 8));
    }

    @Override // com.umeng.analytics.pro.db
    public int w() throws com.umeng.analytics.pro.ci {
        int i;
        byte[] bArr = this.o;
        if (this.g.h() >= 4) {
            bArr = this.g.f();
            i = this.g.g();
            this.g.a(4);
        } else {
            a(this.o, 0, 4);
            i = 0;
        }
        return (bArr[i + 3] & 255) | ((bArr[i] & 255) << 24) | ((bArr[i + 1] & 255) << 16) | ((bArr[i + 2] & 255) << 8);
    }

    @Override // com.umeng.analytics.pro.db
    public long x() throws com.umeng.analytics.pro.ci {
        int i;
        byte[] bArr = this.p;
        if (this.g.h() >= 8) {
            bArr = this.g.f();
            i = this.g.g();
            this.g.a(8);
        } else {
            a(this.p, 0, 8);
            i = 0;
        }
        return (bArr[i + 7] & 255) | ((bArr[i] & 255) << 56) | ((bArr[i + 1] & 255) << 48) | ((bArr[i + 2] & 255) << 40) | ((bArr[i + 3] & 255) << 32) | ((bArr[i + 4] & 255) << 24) | ((bArr[i + 5] & 255) << 16) | ((bArr[i + 6] & 255) << 8);
    }

    @Override // com.umeng.analytics.pro.db
    public double y() throws com.umeng.analytics.pro.ci {
        return java.lang.Double.longBitsToDouble(x());
    }

    @Override // com.umeng.analytics.pro.db
    public java.lang.String z() throws com.umeng.analytics.pro.ci {
        int w = w();
        if (this.g.h() < w) {
            return b(w);
        }
        try {
            java.lang.String str = new java.lang.String(this.g.f(), this.g.g(), w, "UTF-8");
            this.g.a(w);
            return str;
        } catch (java.io.UnsupportedEncodingException unused) {
            throw new com.umeng.analytics.pro.ci("JVM DOES NOT SUPPORT UTF-8");
        }
    }
}
