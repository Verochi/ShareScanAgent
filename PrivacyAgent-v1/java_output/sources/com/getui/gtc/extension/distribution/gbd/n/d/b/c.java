package com.getui.gtc.extension.distribution.gbd.n.d.b;

/* loaded from: classes22.dex */
public final class c extends com.getui.gtc.extension.distribution.gbd.n.d.b.i {
    private static final java.lang.String a = "comment";

    public c(java.lang.String str, java.lang.String str2) {
        super(str2);
        this.f.a(a, str);
    }

    private java.lang.String c() {
        return this.f.a(a);
    }

    @Override // com.getui.gtc.extension.distribution.gbd.n.d.b.i
    public final java.lang.String a() {
        return "#comment";
    }

    @Override // com.getui.gtc.extension.distribution.gbd.n.d.b.i
    public final void a(java.lang.StringBuilder sb, int i, com.getui.gtc.extension.distribution.gbd.n.d.b.e.a aVar) {
        if (aVar.d) {
            com.getui.gtc.extension.distribution.gbd.n.d.b.i.c(sb, i, aVar);
        }
        sb.append("<!--");
        sb.append(this.f.a(a));
        sb.append("-->");
    }

    @Override // com.getui.gtc.extension.distribution.gbd.n.d.b.i
    public final void b(java.lang.StringBuilder sb, int i, com.getui.gtc.extension.distribution.gbd.n.d.b.e.a aVar) {
    }

    @Override // com.getui.gtc.extension.distribution.gbd.n.d.b.i
    public final java.lang.String toString() {
        return a_();
    }
}
