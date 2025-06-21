package com.getui.gtc.extension.distribution.gbd.n.d.c;

/* loaded from: classes22.dex */
public final class f {
    private static final int a = 0;
    private com.getui.gtc.extension.distribution.gbd.n.d.c.l b;
    private int c = 0;
    private com.getui.gtc.extension.distribution.gbd.n.d.c.e d;

    private f(com.getui.gtc.extension.distribution.gbd.n.d.c.l lVar) {
        this.b = lVar;
    }

    public static com.getui.gtc.extension.distribution.gbd.n.d.c.f a() {
        return new com.getui.gtc.extension.distribution.gbd.n.d.c.f(new com.getui.gtc.extension.distribution.gbd.n.d.c.b());
    }

    private com.getui.gtc.extension.distribution.gbd.n.d.c.f a(int i) {
        this.c = i;
        return this;
    }

    private com.getui.gtc.extension.distribution.gbd.n.d.c.f a(com.getui.gtc.extension.distribution.gbd.n.d.c.l lVar) {
        this.b = lVar;
        return this;
    }

    public static java.util.List<com.getui.gtc.extension.distribution.gbd.n.d.b.i> a(java.lang.String str, com.getui.gtc.extension.distribution.gbd.n.d.b.g gVar, java.lang.String str2) {
        return new com.getui.gtc.extension.distribution.gbd.n.d.c.b().a(str, gVar, str2, com.getui.gtc.extension.distribution.gbd.n.d.c.e.b());
    }

    public static com.getui.gtc.extension.distribution.gbd.n.d.b.e b(java.lang.String str, java.lang.String str2) {
        return new com.getui.gtc.extension.distribution.gbd.n.d.c.b().a(str, str2, com.getui.gtc.extension.distribution.gbd.n.d.c.e.b());
    }

    private com.getui.gtc.extension.distribution.gbd.n.d.c.l b() {
        return this.b;
    }

    public static com.getui.gtc.extension.distribution.gbd.n.d.b.e c(java.lang.String str, java.lang.String str2) {
        com.getui.gtc.extension.distribution.gbd.n.d.b.e a2 = com.getui.gtc.extension.distribution.gbd.n.d.b.e.a(str2);
        com.getui.gtc.extension.distribution.gbd.n.d.b.g a3 = a2.a("body", (com.getui.gtc.extension.distribution.gbd.n.d.b.i) a2);
        java.util.List<com.getui.gtc.extension.distribution.gbd.n.d.b.i> a4 = a(str, a3, str2);
        for (com.getui.gtc.extension.distribution.gbd.n.d.b.i iVar : (com.getui.gtc.extension.distribution.gbd.n.d.b.i[]) a4.toArray(new com.getui.gtc.extension.distribution.gbd.n.d.b.i[a4.size()])) {
            a3.a(iVar);
        }
        return a2;
    }

    private boolean c() {
        return this.c > 0;
    }

    private static com.getui.gtc.extension.distribution.gbd.n.d.b.e d(java.lang.String str, java.lang.String str2) {
        return b(str, str2);
    }

    private java.util.List<com.getui.gtc.extension.distribution.gbd.n.d.c.d> d() {
        return this.d;
    }

    private static com.getui.gtc.extension.distribution.gbd.n.d.c.f e() {
        return new com.getui.gtc.extension.distribution.gbd.n.d.c.f(new com.getui.gtc.extension.distribution.gbd.n.d.c.m());
    }

    public final com.getui.gtc.extension.distribution.gbd.n.d.b.e a(java.lang.String str, java.lang.String str2) {
        com.getui.gtc.extension.distribution.gbd.n.d.c.e a2 = c() ? com.getui.gtc.extension.distribution.gbd.n.d.c.e.a(this.c) : com.getui.gtc.extension.distribution.gbd.n.d.c.e.b();
        this.d = a2;
        return this.b.a(str, str2, a2);
    }
}
