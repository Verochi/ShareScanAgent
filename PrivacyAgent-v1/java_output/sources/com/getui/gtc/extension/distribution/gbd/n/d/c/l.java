package com.getui.gtc.extension.distribution.gbd.n.d.c;

/* loaded from: classes22.dex */
abstract class l {
    com.getui.gtc.extension.distribution.gbd.n.d.c.a k;
    com.getui.gtc.extension.distribution.gbd.n.d.c.j l;
    protected com.getui.gtc.extension.distribution.gbd.n.d.b.e m;
    protected com.getui.gtc.extension.distribution.gbd.n.d.a.b<com.getui.gtc.extension.distribution.gbd.n.d.b.g> n;
    protected java.lang.String o;
    protected com.getui.gtc.extension.distribution.gbd.n.d.c.h p;
    protected com.getui.gtc.extension.distribution.gbd.n.d.c.e q;

    private com.getui.gtc.extension.distribution.gbd.n.d.b.e a(java.lang.String str, java.lang.String str2) {
        return a(str, str2, com.getui.gtc.extension.distribution.gbd.n.d.c.e.b());
    }

    public com.getui.gtc.extension.distribution.gbd.n.d.b.e a(java.lang.String str, java.lang.String str2, com.getui.gtc.extension.distribution.gbd.n.d.c.e eVar) {
        b(str, str2, eVar);
        o();
        return this.m;
    }

    public abstract boolean a(com.getui.gtc.extension.distribution.gbd.n.d.c.h hVar);

    public void b(java.lang.String str, java.lang.String str2, com.getui.gtc.extension.distribution.gbd.n.d.c.e eVar) {
        com.getui.gtc.extension.distribution.gbd.n.d.a.e.a((java.lang.Object) str, "String input must not be null");
        com.getui.gtc.extension.distribution.gbd.n.d.a.e.a((java.lang.Object) str2, "BaseURI must not be null");
        this.m = new com.getui.gtc.extension.distribution.gbd.n.d.b.e(str2);
        com.getui.gtc.extension.distribution.gbd.n.d.c.a aVar = new com.getui.gtc.extension.distribution.gbd.n.d.c.a(str);
        this.k = aVar;
        this.q = eVar;
        this.l = new com.getui.gtc.extension.distribution.gbd.n.d.c.j(aVar, eVar);
        this.n = new com.getui.gtc.extension.distribution.gbd.n.d.a.b<>();
        this.o = str2;
    }

    public final void o() {
        com.getui.gtc.extension.distribution.gbd.n.d.c.h a;
        do {
            a = this.l.a();
            a(a);
        } while (a.a != com.getui.gtc.extension.distribution.gbd.n.d.c.h.EnumC0322h.EOF);
    }

    public final com.getui.gtc.extension.distribution.gbd.n.d.b.g p() {
        return this.n.getLast();
    }
}
