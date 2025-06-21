package com.xiaomi.push;

/* loaded from: classes19.dex */
public class id extends com.xiaomi.push.ih {
    private static final com.xiaomi.push.im f = new com.xiaomi.push.im();
    protected boolean a;
    protected boolean b;
    protected int c;
    protected boolean d;
    private byte[] g;
    private byte[] h;
    private byte[] i;
    private byte[] j;
    private byte[] k;
    private byte[] l;
    private byte[] m;
    private byte[] n;

    public static class a implements com.xiaomi.push.ij {
        protected boolean a;
        protected boolean b;
        protected int c;

        public a() {
            this((byte) 0);
        }

        public a(byte b) {
            this(false, 0);
        }

        public a(boolean z, int i) {
            this.a = z;
            this.b = true;
            this.c = i;
        }

        @Override // com.xiaomi.push.ij
        public com.xiaomi.push.ih a(com.xiaomi.push.ir irVar) {
            com.xiaomi.push.id idVar = new com.xiaomi.push.id(irVar, this.a, this.b);
            int i = this.c;
            if (i != 0) {
                idVar.c(i);
            }
            return idVar;
        }
    }

    public id(com.xiaomi.push.ir irVar, boolean z, boolean z2) {
        super(irVar);
        this.d = false;
        this.g = new byte[1];
        this.h = new byte[2];
        this.i = new byte[4];
        this.j = new byte[8];
        this.k = new byte[1];
        this.l = new byte[2];
        this.m = new byte[4];
        this.n = new byte[8];
        this.a = z;
        this.b = z2;
    }

    private int a(byte[] bArr, int i) {
        d(i);
        return this.e.b(bArr, i);
    }

    @Override // com.xiaomi.push.ih
    public final void a() {
        a((byte) 0);
    }

    @Override // com.xiaomi.push.ih
    public final void a(byte b) {
        byte[] bArr = this.g;
        bArr[0] = b;
        this.e.b(bArr, 0, 1);
    }

    @Override // com.xiaomi.push.ih
    public final void a(int i) {
        byte[] bArr = this.i;
        bArr[0] = (byte) ((i >> 24) & 255);
        bArr[1] = (byte) ((i >> 16) & 255);
        bArr[2] = (byte) ((i >> 8) & 255);
        bArr[3] = (byte) (i & 255);
        this.e.b(bArr, 0, 4);
    }

    @Override // com.xiaomi.push.ih
    public final void a(long j) {
        byte[] bArr = this.j;
        bArr[0] = (byte) ((j >> 56) & 255);
        bArr[1] = (byte) ((j >> 48) & 255);
        bArr[2] = (byte) ((j >> 40) & 255);
        bArr[3] = (byte) ((j >> 32) & 255);
        bArr[4] = (byte) ((j >> 24) & 255);
        bArr[5] = (byte) ((j >> 16) & 255);
        bArr[6] = (byte) ((j >> 8) & 255);
        bArr[7] = (byte) (j & 255);
        this.e.b(bArr, 0, 8);
    }

    @Override // com.xiaomi.push.ih
    public final void a(com.xiaomi.push.ie ieVar) {
        a(ieVar.b);
        a(ieVar.c);
    }

    @Override // com.xiaomi.push.ih
    public final void a(com.xiaomi.push.Cif cif) {
        a(cif.a);
        a(cif.b);
    }

    @Override // com.xiaomi.push.ih
    public final void a(com.xiaomi.push.ig igVar) {
        a(igVar.a);
        a(igVar.b);
        a(igVar.c);
    }

    @Override // com.xiaomi.push.ih
    public final void a(java.lang.String str) {
        try {
            byte[] bytes = str.getBytes("UTF-8");
            a(bytes.length);
            this.e.b(bytes, 0, bytes.length);
        } catch (java.io.UnsupportedEncodingException unused) {
            throw new com.xiaomi.push.ia("JVM DOES NOT SUPPORT UTF-8");
        }
    }

    @Override // com.xiaomi.push.ih
    public final void a(java.nio.ByteBuffer byteBuffer) {
        int limit = (byteBuffer.limit() - byteBuffer.position()) - byteBuffer.arrayOffset();
        a(limit);
        this.e.b(byteBuffer.array(), byteBuffer.position() + byteBuffer.arrayOffset(), limit);
    }

    @Override // com.xiaomi.push.ih
    public final void a(short s2) {
        byte[] bArr = this.h;
        bArr[0] = (byte) ((s2 >> 8) & 255);
        bArr[1] = (byte) (s2 & 255);
        this.e.b(bArr, 0, 2);
    }

    @Override // com.xiaomi.push.ih
    public final void a(boolean z) {
        a(z ? (byte) 1 : (byte) 0);
    }

    @Override // com.xiaomi.push.ih
    public final com.xiaomi.push.ie b() {
        byte g = g();
        return new com.xiaomi.push.ie("", g, g == 0 ? (short) 0 : h());
    }

    public final java.lang.String b(int i) {
        try {
            d(i);
            byte[] bArr = new byte[i];
            this.e.b(bArr, i);
            return new java.lang.String(bArr, "UTF-8");
        } catch (java.io.UnsupportedEncodingException unused) {
            throw new com.xiaomi.push.ia("JVM DOES NOT SUPPORT UTF-8");
        }
    }

    @Override // com.xiaomi.push.ih
    public com.xiaomi.push.ig c() {
        return new com.xiaomi.push.ig(g(), g(), i());
    }

    public final void c(int i) {
        this.c = i;
        this.d = true;
    }

    @Override // com.xiaomi.push.ih
    public com.xiaomi.push.Cif d() {
        return new com.xiaomi.push.Cif(g(), i());
    }

    public final void d(int i) {
        if (i < 0) {
            throw new com.xiaomi.push.ia("Negative length: ".concat(java.lang.String.valueOf(i)));
        }
        if (this.d) {
            int i2 = this.c - i;
            this.c = i2;
            if (i2 < 0) {
                throw new com.xiaomi.push.ia("Message length exceeded: ".concat(java.lang.String.valueOf(i)));
            }
        }
    }

    @Override // com.xiaomi.push.ih
    public com.xiaomi.push.il e() {
        return new com.xiaomi.push.il(g(), i());
    }

    @Override // com.xiaomi.push.ih
    public final boolean f() {
        return g() == 1;
    }

    @Override // com.xiaomi.push.ih
    public final byte g() {
        if (this.e.c() <= 0) {
            a(this.k, 1);
            return this.k[0];
        }
        byte b = this.e.a()[this.e.b()];
        this.e.a(1);
        return b;
    }

    @Override // com.xiaomi.push.ih
    public final short h() {
        int i;
        byte[] bArr = this.l;
        if (this.e.c() >= 2) {
            bArr = this.e.a();
            i = this.e.b();
            this.e.a(2);
        } else {
            a(this.l, 2);
            i = 0;
        }
        return (short) ((bArr[i + 1] & 255) | ((bArr[i] & 255) << 8));
    }

    @Override // com.xiaomi.push.ih
    public final int i() {
        int i;
        byte[] bArr = this.m;
        if (this.e.c() >= 4) {
            bArr = this.e.a();
            i = this.e.b();
            this.e.a(4);
        } else {
            a(this.m, 4);
            i = 0;
        }
        return (bArr[i + 3] & 255) | ((bArr[i] & 255) << 24) | ((bArr[i + 1] & 255) << 16) | ((bArr[i + 2] & 255) << 8);
    }

    @Override // com.xiaomi.push.ih
    public final long j() {
        int i;
        byte[] bArr = this.n;
        if (this.e.c() >= 8) {
            bArr = this.e.a();
            i = this.e.b();
            this.e.a(8);
        } else {
            a(this.n, 8);
            i = 0;
        }
        return (bArr[i + 7] & 255) | ((bArr[i] & 255) << 56) | ((bArr[i + 1] & 255) << 48) | ((bArr[i + 2] & 255) << 40) | ((bArr[i + 3] & 255) << 32) | ((bArr[i + 4] & 255) << 24) | ((bArr[i + 5] & 255) << 16) | ((bArr[i + 6] & 255) << 8);
    }

    @Override // com.xiaomi.push.ih
    public final double k() {
        return java.lang.Double.longBitsToDouble(j());
    }

    @Override // com.xiaomi.push.ih
    public java.lang.String l() {
        int i = i();
        if (this.e.c() < i) {
            return b(i);
        }
        try {
            java.lang.String str = new java.lang.String(this.e.a(), this.e.b(), i, "UTF-8");
            this.e.a(i);
            return str;
        } catch (java.io.UnsupportedEncodingException unused) {
            throw new com.xiaomi.push.ia("JVM DOES NOT SUPPORT UTF-8");
        }
    }

    @Override // com.xiaomi.push.ih
    public java.nio.ByteBuffer m() {
        int i = i();
        d(i);
        if (this.e.c() >= i) {
            java.nio.ByteBuffer wrap = java.nio.ByteBuffer.wrap(this.e.a(), this.e.b(), i);
            this.e.a(i);
            return wrap;
        }
        byte[] bArr = new byte[i];
        this.e.b(bArr, i);
        return java.nio.ByteBuffer.wrap(bArr);
    }
}
