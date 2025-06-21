package com.sijla.mla.a.b;

/* loaded from: classes19.dex */
public final class b extends com.sijla.mla.a.b.s {

    public static final class a extends com.sijla.mla.a.b.s {
        @Override // com.sijla.mla.a.b.s, com.sijla.mla.a.b.j, com.sijla.mla.a.r
        public final com.sijla.mla.a.r b(com.sijla.mla.a.r rVar, com.sijla.mla.a.r rVar2) {
            int i = this.d;
            return i != 0 ? i != 1 ? i != 2 ? i != 3 ? i != 4 ? com.sijla.mla.a.r.k : com.sijla.mla.a.b.b.b(rVar.x(), rVar2.x()) : com.sijla.mla.a.b.b.f(rVar.x(), rVar2.x()) : com.sijla.mla.a.b.b.d(rVar.x(), rVar2.x()) : com.sijla.mla.a.b.b.e(rVar.x(), rVar2.x()) : com.sijla.mla.a.b.b.a(rVar.x(), rVar2.x());
        }
    }

    /* renamed from: com.sijla.mla.a.b.b$b, reason: collision with other inner class name */
    public static final class C0459b extends com.sijla.mla.a.b.t {
        @Override // com.sijla.mla.a.b.t, com.sijla.mla.a.b.j, com.sijla.mla.a.r
        public final com.sijla.mla.a.y a(com.sijla.mla.a.y yVar) {
            switch (this.d) {
                case 0:
                    return com.sijla.mla.a.b.b.c(yVar);
                case 1:
                    return com.sijla.mla.a.b.b.d(yVar);
                case 2:
                    return com.sijla.mla.a.b.b.e(yVar);
                case 3:
                    int i = -1;
                    for (int i2 = 1; i2 <= yVar.e(); i2++) {
                        i &= yVar.u(i2);
                    }
                    return com.sijla.mla.a.r.a(i != 0);
                case 4:
                    return com.sijla.mla.a.b.b.f(yVar);
                case 5:
                    return com.sijla.mla.a.b.b.a(yVar.u(1), yVar.u(2), yVar.c(3, 1));
                case 6:
                    return com.sijla.mla.a.b.b.a(yVar.u(1), yVar.u(2), yVar.u(3), yVar.c(4, 1));
                default:
                    return com.sijla.mla.a.r.k;
            }
        }
    }

    public static com.sijla.mla.a.r a(int i, int i2) {
        return m(i2 >= 0 ? i >> i2 : i << (-i2));
    }

    public static com.sijla.mla.a.r a(int i, int i2, int i3) {
        if (i2 < 0) {
            com.sijla.mla.a.r.a(2, "field cannot be negative");
        }
        if (i3 < 0) {
            com.sijla.mla.a.r.a(3, "width must be postive");
        }
        if (i2 + i3 > 32) {
            com.sijla.mla.a.r.d("trying to access non-existent bits");
        }
        return m((i >>> i2) & ((-1) >>> (32 - i3)));
    }

    public static com.sijla.mla.a.r a(int i, int i2, int i3, int i4) {
        if (i3 < 0) {
            com.sijla.mla.a.r.a(3, "field cannot be negative");
        }
        if (i4 < 0) {
            com.sijla.mla.a.r.a(4, "width must be postive");
        }
        if (i3 + i4 > 32) {
            com.sijla.mla.a.r.d("trying to access non-existent bits");
        }
        int i5 = ((-1) >>> (32 - i4)) << i3;
        return m((i & (~i5)) | ((i2 << i3) & i5));
    }

    public static com.sijla.mla.a.r b(int i, int i2) {
        if (i2 >= 32 || i2 <= -32) {
            return com.sijla.mla.a.r.o;
        }
        return m(i2 >= 0 ? i >>> i2 : i << (-i2));
    }

    public static com.sijla.mla.a.y c(com.sijla.mla.a.y yVar) {
        int i = -1;
        for (int i2 = 1; i2 <= yVar.e(); i2++) {
            i &= yVar.u(i2);
        }
        return m(i);
    }

    public static com.sijla.mla.a.r d(int i, int i2) {
        if (i2 >= 32 || i2 <= -32) {
            return com.sijla.mla.a.r.o;
        }
        return m(i2 >= 0 ? i << i2 : i >>> (-i2));
    }

    public static com.sijla.mla.a.y d(com.sijla.mla.a.y yVar) {
        return m(~yVar.u(1));
    }

    public static com.sijla.mla.a.r e(int i, int i2) {
        if (i2 < 0) {
            return f(i, -i2);
        }
        int i3 = i2 & 31;
        return m((i >>> (32 - i3)) | (i << i3));
    }

    public static com.sijla.mla.a.y e(com.sijla.mla.a.y yVar) {
        int i = 0;
        for (int i2 = 1; i2 <= yVar.e(); i2++) {
            i |= yVar.u(i2);
        }
        return m(i);
    }

    public static com.sijla.mla.a.r f(int i, int i2) {
        if (i2 < 0) {
            return e(i, -i2);
        }
        int i3 = i2 & 31;
        return m((i << (32 - i3)) | (i >>> i3));
    }

    public static com.sijla.mla.a.y f(com.sijla.mla.a.y yVar) {
        int i = 0;
        for (int i2 = 1; i2 <= yVar.e(); i2++) {
            i ^= yVar.u(i2);
        }
        return m(i);
    }

    private static com.sijla.mla.a.r m(int i) {
        return i < 0 ? com.sijla.mla.a.h.a(i & net.lingala.zip4j.util.InternalZipConstants.ZIP_64_LIMIT) : com.sijla.mla.a.k.c_(i);
    }

    @Override // com.sijla.mla.a.b.s, com.sijla.mla.a.b.j, com.sijla.mla.a.r
    public final com.sijla.mla.a.r b(com.sijla.mla.a.r rVar, com.sijla.mla.a.r rVar2) {
        com.sijla.mla.a.o oVar = new com.sijla.mla.a.o();
        com.sijla.mla.a.b.j.a(oVar, com.sijla.mla.a.b.b.C0459b.class, new java.lang.String[]{com.sijla.mla.L2.s1066894763(), com.sijla.mla.L2.s1067283503(), com.sijla.mla.L2.s34429471(), com.sijla.mla.L2.s1268704944(), com.sijla.mla.L2.s1067581351(), com.sijla.mla.L2.s1161785827(), com.sijla.mla.L2.s1754242544()});
        com.sijla.mla.a.b.j.a(oVar, com.sijla.mla.a.b.b.a.class, new java.lang.String[]{com.sijla.mla.L2.s1712801139(), com.sijla.mla.L2.s694781347(), com.sijla.mla.L2.s416212758(), com.sijla.mla.L2.s1172146071(), com.sijla.mla.L2.s613842032()});
        rVar2.a(com.sijla.mla.L2.s1278480360(), oVar);
        rVar2.g(com.sijla.mla.L2.s573041986()).g(com.sijla.mla.L2.s537344421()).a(com.sijla.mla.L2.s1278480360(), oVar);
        return oVar;
    }
}
