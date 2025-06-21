package com.xiaomi.push;

/* loaded from: classes19.dex */
public final class in extends com.xiaomi.push.id {
    private static int f = 10000;
    private static int g = 10000;
    private static int h = 10000;
    private static int i = 10485760;
    private static int j = 104857600;

    public static class a extends com.xiaomi.push.id.a {
        public a() {
            super((byte) 0);
        }

        public a(int i) {
            super(true, i);
        }

        @Override // com.xiaomi.push.id.a, com.xiaomi.push.ij
        public final com.xiaomi.push.ih a(com.xiaomi.push.ir irVar) {
            com.xiaomi.push.in inVar = new com.xiaomi.push.in(irVar, this.a, this.b);
            int i = this.c;
            if (i != 0) {
                inVar.c(i);
            }
            return inVar;
        }
    }

    public in(com.xiaomi.push.ir irVar, boolean z, boolean z2) {
        super(irVar, z, z2);
    }

    @Override // com.xiaomi.push.id, com.xiaomi.push.ih
    public final com.xiaomi.push.ig c() {
        byte g2 = g();
        byte g3 = g();
        int i2 = i();
        if (i2 <= f) {
            return new com.xiaomi.push.ig(g2, g3, i2);
        }
        throw new com.xiaomi.push.ii("Thrift map size " + i2 + " out of range!");
    }

    @Override // com.xiaomi.push.id, com.xiaomi.push.ih
    public final com.xiaomi.push.Cif d() {
        byte g2 = g();
        int i2 = i();
        if (i2 <= g) {
            return new com.xiaomi.push.Cif(g2, i2);
        }
        throw new com.xiaomi.push.ii("Thrift list size " + i2 + " out of range!");
    }

    @Override // com.xiaomi.push.id, com.xiaomi.push.ih
    public final com.xiaomi.push.il e() {
        byte g2 = g();
        int i2 = i();
        if (i2 <= h) {
            return new com.xiaomi.push.il(g2, i2);
        }
        throw new com.xiaomi.push.ii("Thrift set size " + i2 + " out of range!");
    }

    @Override // com.xiaomi.push.id, com.xiaomi.push.ih
    public final java.lang.String l() {
        int i2 = i();
        if (i2 > i) {
            throw new com.xiaomi.push.ii("Thrift string size " + i2 + " out of range!");
        }
        if (this.e.c() < i2) {
            return b(i2);
        }
        try {
            java.lang.String str = new java.lang.String(this.e.a(), this.e.b(), i2, "UTF-8");
            this.e.a(i2);
            return str;
        } catch (java.io.UnsupportedEncodingException unused) {
            throw new com.xiaomi.push.ia("JVM DOES NOT SUPPORT UTF-8");
        }
    }

    @Override // com.xiaomi.push.id, com.xiaomi.push.ih
    public final java.nio.ByteBuffer m() {
        int i2 = i();
        if (i2 > j) {
            throw new com.xiaomi.push.ii("Thrift binary size " + i2 + " out of range!");
        }
        d(i2);
        if (this.e.c() >= i2) {
            java.nio.ByteBuffer wrap = java.nio.ByteBuffer.wrap(this.e.a(), this.e.b(), i2);
            this.e.a(i2);
            return wrap;
        }
        byte[] bArr = new byte[i2];
        this.e.b(bArr, i2);
        return java.nio.ByteBuffer.wrap(bArr);
    }
}
