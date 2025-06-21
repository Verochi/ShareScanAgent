package com.getui.gtc.extension.distribution.gbd.n.d.b;

/* loaded from: classes22.dex */
public final class j extends com.getui.gtc.extension.distribution.gbd.n.d.b.i {
    private static final java.lang.String b = "text";
    java.lang.String a;

    public j(java.lang.String str, java.lang.String str2) {
        this.g = str2;
        this.a = str;
    }

    private com.getui.gtc.extension.distribution.gbd.n.d.b.j a(int i) {
        com.getui.gtc.extension.distribution.gbd.n.d.a.e.a(i >= 0, "Split offset must be not be negative");
        com.getui.gtc.extension.distribution.gbd.n.d.a.e.a(i < this.a.length(), "Split offset must not be greater than current text length");
        java.lang.String substring = c().substring(0, i);
        java.lang.String substring2 = c().substring(i);
        this.a = substring;
        com.getui.gtc.extension.distribution.gbd.n.d.b.b bVar = this.f;
        if (bVar != null) {
            bVar.a("text", substring);
        }
        com.getui.gtc.extension.distribution.gbd.n.d.b.j jVar = new com.getui.gtc.extension.distribution.gbd.n.d.b.j(substring2, this.g);
        if (o() != null) {
            o().a(this.h + 1, jVar);
        }
        return jVar;
    }

    private static com.getui.gtc.extension.distribution.gbd.n.d.b.j a(java.lang.String str, java.lang.String str2) {
        return new com.getui.gtc.extension.distribution.gbd.n.d.b.j(com.getui.gtc.extension.distribution.gbd.n.d.b.h.c(str), str2);
    }

    public static java.lang.String a(java.lang.String str) {
        return str.replaceFirst("^\\s+", "");
    }

    private com.getui.gtc.extension.distribution.gbd.n.d.b.j b(java.lang.String str) {
        this.a = str;
        com.getui.gtc.extension.distribution.gbd.n.d.b.b bVar = this.f;
        if (bVar != null) {
            bVar.a("text", str);
        }
        return this;
    }

    public static boolean b(java.lang.StringBuilder sb) {
        return sb.length() != 0 && sb.charAt(sb.length() - 1) == ' ';
    }

    private static java.lang.String c(java.lang.String str) {
        return com.getui.gtc.extension.distribution.gbd.n.d.a.d.c(str);
    }

    private java.lang.String e() {
        return com.getui.gtc.extension.distribution.gbd.n.d.a.d.c(c());
    }

    private boolean f() {
        return com.getui.gtc.extension.distribution.gbd.n.d.a.d.a(c());
    }

    private void g() {
        if (this.f == null) {
            com.getui.gtc.extension.distribution.gbd.n.d.b.b bVar = new com.getui.gtc.extension.distribution.gbd.n.d.b.b();
            this.f = bVar;
            bVar.a("text", this.a);
        }
    }

    @Override // com.getui.gtc.extension.distribution.gbd.n.d.b.i
    public final java.lang.String a() {
        return "#text";
    }

    @Override // com.getui.gtc.extension.distribution.gbd.n.d.b.i
    public final void a(java.lang.StringBuilder sb, int i, com.getui.gtc.extension.distribution.gbd.n.d.b.e.a aVar) {
        java.lang.String a = com.getui.gtc.extension.distribution.gbd.n.d.b.h.a(c(), aVar);
        if (aVar.d && (o() instanceof com.getui.gtc.extension.distribution.gbd.n.d.b.g) && !((com.getui.gtc.extension.distribution.gbd.n.d.b.g) o()).k()) {
            a = com.getui.gtc.extension.distribution.gbd.n.d.a.d.c(a);
        }
        if (aVar.d && this.h == 0) {
            com.getui.gtc.extension.distribution.gbd.n.d.b.i iVar = this.d;
            if ((iVar instanceof com.getui.gtc.extension.distribution.gbd.n.d.b.g) && ((com.getui.gtc.extension.distribution.gbd.n.d.b.g) iVar).c.c && !com.getui.gtc.extension.distribution.gbd.n.d.a.d.a(c())) {
                com.getui.gtc.extension.distribution.gbd.n.d.b.i.c(sb, i, aVar);
            }
        }
        sb.append(a);
    }

    @Override // com.getui.gtc.extension.distribution.gbd.n.d.b.i
    public final com.getui.gtc.extension.distribution.gbd.n.d.b.i b(java.lang.String str, java.lang.String str2) {
        g();
        return super.b(str, str2);
    }

    @Override // com.getui.gtc.extension.distribution.gbd.n.d.b.i
    public final void b(java.lang.StringBuilder sb, int i, com.getui.gtc.extension.distribution.gbd.n.d.b.e.a aVar) {
    }

    public final java.lang.String c() {
        com.getui.gtc.extension.distribution.gbd.n.d.b.b bVar = this.f;
        return bVar == null ? this.a : bVar.a("text");
    }

    @Override // com.getui.gtc.extension.distribution.gbd.n.d.b.i
    public final com.getui.gtc.extension.distribution.gbd.n.d.b.b p() {
        g();
        return super.p();
    }

    @Override // com.getui.gtc.extension.distribution.gbd.n.d.b.i
    public final java.lang.String p(java.lang.String str) {
        g();
        return super.p(str);
    }

    @Override // com.getui.gtc.extension.distribution.gbd.n.d.b.i
    public final boolean q(java.lang.String str) {
        g();
        return super.q(str);
    }

    @Override // com.getui.gtc.extension.distribution.gbd.n.d.b.i
    public final com.getui.gtc.extension.distribution.gbd.n.d.b.i r(java.lang.String str) {
        g();
        return super.r(str);
    }

    @Override // com.getui.gtc.extension.distribution.gbd.n.d.b.i
    public final java.lang.String s(java.lang.String str) {
        g();
        return super.s(str);
    }

    @Override // com.getui.gtc.extension.distribution.gbd.n.d.b.i
    public final java.lang.String toString() {
        return a_();
    }
}
