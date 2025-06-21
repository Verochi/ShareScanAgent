package com.getui.gtc.extension.distribution.gbd.n.d.b;

/* loaded from: classes22.dex */
public final class d extends com.getui.gtc.extension.distribution.gbd.n.d.b.i {
    private static final java.lang.String a = "data";

    public d(java.lang.String str, java.lang.String str2) {
        super(str2);
        this.f.a("data", str);
    }

    private com.getui.gtc.extension.distribution.gbd.n.d.b.d a(java.lang.String str) {
        this.f.a("data", str);
        return this;
    }

    private static com.getui.gtc.extension.distribution.gbd.n.d.b.d a(java.lang.String str, java.lang.String str2) {
        return new com.getui.gtc.extension.distribution.gbd.n.d.b.d(com.getui.gtc.extension.distribution.gbd.n.d.b.h.c(str), str2);
    }

    @Override // com.getui.gtc.extension.distribution.gbd.n.d.b.i
    public final java.lang.String a() {
        return "#data";
    }

    @Override // com.getui.gtc.extension.distribution.gbd.n.d.b.i
    public final void a(java.lang.StringBuilder sb, int i, com.getui.gtc.extension.distribution.gbd.n.d.b.e.a aVar) {
        sb.append(b());
    }

    public final java.lang.String b() {
        return this.f.a("data");
    }

    @Override // com.getui.gtc.extension.distribution.gbd.n.d.b.i
    public final void b(java.lang.StringBuilder sb, int i, com.getui.gtc.extension.distribution.gbd.n.d.b.e.a aVar) {
    }

    @Override // com.getui.gtc.extension.distribution.gbd.n.d.b.i
    public final java.lang.String toString() {
        return a_();
    }
}
