package com.getui.gtc.extension.distribution.gbd.n.d.b;

/* loaded from: classes22.dex */
public final class k extends com.getui.gtc.extension.distribution.gbd.n.d.b.i {
    private static final java.lang.String a = "declaration";
    private final boolean b;

    private k(java.lang.String str, java.lang.String str2, boolean z) {
        super(str2);
        this.f.a(a, str);
        this.b = z;
    }

    private java.lang.String c() {
        return this.f.a(a);
    }

    @Override // com.getui.gtc.extension.distribution.gbd.n.d.b.i
    public final java.lang.String a() {
        return "#declaration";
    }

    @Override // com.getui.gtc.extension.distribution.gbd.n.d.b.i
    public final void a(java.lang.StringBuilder sb, int i, com.getui.gtc.extension.distribution.gbd.n.d.b.e.a aVar) {
        sb.append("<");
        sb.append(this.b ? "!" : "?");
        sb.append(this.f.a(a));
        sb.append(">");
    }

    @Override // com.getui.gtc.extension.distribution.gbd.n.d.b.i
    public final void b(java.lang.StringBuilder sb, int i, com.getui.gtc.extension.distribution.gbd.n.d.b.e.a aVar) {
    }

    @Override // com.getui.gtc.extension.distribution.gbd.n.d.b.i
    public final java.lang.String toString() {
        return a_();
    }
}
