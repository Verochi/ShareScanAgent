package com.getui.gtc.extension.distribution.gbd.n.d.b;

/* loaded from: classes22.dex */
public final class f extends com.getui.gtc.extension.distribution.gbd.n.d.b.i {
    public f(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4) {
        super(str4);
        com.getui.gtc.extension.distribution.gbd.n.d.a.e.a(str);
        b("name", str);
        b("publicId", str2);
        b("systemId", str3);
    }

    @Override // com.getui.gtc.extension.distribution.gbd.n.d.b.i
    public final java.lang.String a() {
        return "#doctype";
    }

    @Override // com.getui.gtc.extension.distribution.gbd.n.d.b.i
    public final void a(java.lang.StringBuilder sb, int i, com.getui.gtc.extension.distribution.gbd.n.d.b.e.a aVar) {
        sb.append("<!DOCTYPE ");
        sb.append(p("name"));
        if (!com.getui.gtc.extension.distribution.gbd.n.d.a.d.a(p("publicId"))) {
            sb.append(" PUBLIC \"");
            sb.append(p("publicId"));
            sb.append("\"");
        }
        if (!com.getui.gtc.extension.distribution.gbd.n.d.a.d.a(p("systemId"))) {
            sb.append(" \"");
            sb.append(p("systemId"));
            sb.append("\"");
        }
        sb.append(kotlin.text.Typography.greater);
    }

    @Override // com.getui.gtc.extension.distribution.gbd.n.d.b.i
    public final void b(java.lang.StringBuilder sb, int i, com.getui.gtc.extension.distribution.gbd.n.d.b.e.a aVar) {
    }
}
