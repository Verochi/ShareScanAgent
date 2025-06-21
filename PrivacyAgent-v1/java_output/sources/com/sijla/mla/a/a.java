package com.sijla.mla.a;

/* loaded from: classes19.dex */
public final class a {
    private static final byte[] a = new byte[0];
    private byte[] b;
    private int c;
    private int d;
    private com.sijla.mla.a.r e;

    public a() {
        this(64);
    }

    public a(int i) {
        this.b = new byte[i];
        this.c = 0;
        this.d = 0;
        this.e = null;
    }

    public a(com.sijla.mla.a.r rVar) {
        this.b = a;
        this.d = 0;
        this.c = 0;
        this.e = rVar;
    }

    private void a(int i, int i2) {
        com.sijla.mla.a.r rVar = this.e;
        if (rVar != null) {
            com.sijla.mla.a.n s2 = rVar.s();
            this.e = null;
            int i3 = s2.d;
            this.c = i3;
            this.d = i;
            byte[] bArr = new byte[i + i3 + i2];
            this.b = bArr;
            java.lang.System.arraycopy(s2.b, s2.c, bArr, i, i3);
            return;
        }
        int i4 = this.d;
        int i5 = this.c;
        if (i4 + i5 + i2 > this.b.length || i4 < i) {
            int i6 = i + i5 + i2;
            if (i6 < 32) {
                i6 = 32;
            } else if (i6 < (i5 << 1)) {
                i6 = i5 << 1;
            }
            b(i6, i == 0 ? 0 : (i6 - i5) - i2);
        }
    }

    private com.sijla.mla.a.a b(com.sijla.mla.a.r rVar) {
        this.b = a;
        this.c = 0;
        this.d = 0;
        this.e = rVar;
        return this;
    }

    private final void b(int i, int i2) {
        byte[] bArr = this.b;
        if (i != bArr.length) {
            byte[] bArr2 = new byte[i];
            java.lang.System.arraycopy(bArr, this.d, bArr2, i2, this.c);
            this.b = bArr2;
            this.d = i2;
        }
    }

    private com.sijla.mla.a.a c(com.sijla.mla.a.n nVar) {
        int i = nVar.d;
        a(i, 0);
        java.lang.System.arraycopy(nVar.b, nVar.c, this.b, this.d - i, i);
        this.d -= i;
        this.c += i;
        this.e = null;
        return this;
    }

    public final com.sijla.mla.a.a a(byte b) {
        a(0, 1);
        byte[] bArr = this.b;
        int i = this.d;
        int i2 = this.c;
        this.c = i2 + 1;
        bArr[i + i2] = b;
        return this;
    }

    public final com.sijla.mla.a.a a(com.sijla.mla.a.m mVar) {
        com.sijla.mla.a.r rVar = this.e;
        return (rVar == null || rVar.v()) ? c(mVar.s()) : b(this.e.a(mVar));
    }

    public final com.sijla.mla.a.a a(com.sijla.mla.a.n nVar) {
        int i = nVar.d;
        a(0, i);
        nVar.c(this.b, this.d + this.c, i);
        this.c += i;
        return this;
    }

    public final com.sijla.mla.a.a a(com.sijla.mla.a.r rVar) {
        return b(rVar.o(a()));
    }

    public final com.sijla.mla.a.a a(java.lang.String str) {
        char[] charArray = str.toCharArray();
        int a2 = com.sijla.mla.a.n.a(charArray);
        a(0, a2);
        com.sijla.mla.a.n.a(charArray, charArray.length, this.b, this.d + this.c);
        this.c += a2;
        return this;
    }

    public final com.sijla.mla.a.r a() {
        com.sijla.mla.a.r rVar = this.e;
        return rVar != null ? rVar : b();
    }

    public final com.sijla.mla.a.a b(com.sijla.mla.a.n nVar) {
        com.sijla.mla.a.r rVar = this.e;
        return (rVar == null || rVar.v()) ? c(nVar) : b(this.e.c(nVar));
    }

    public final com.sijla.mla.a.n b() {
        b(this.c, 0);
        return com.sijla.mla.a.n.a(this.b, this.d, this.c);
    }

    public final java.lang.String c() {
        return a().g();
    }

    public final java.lang.String toString() {
        return a().g();
    }
}
