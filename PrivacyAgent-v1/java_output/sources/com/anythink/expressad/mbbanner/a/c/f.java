package com.anythink.expressad.mbbanner.a.c;

/* loaded from: classes12.dex */
public class f implements com.anythink.expressad.videocommon.b.i.b {
    private static final java.lang.String a = "f";
    private com.anythink.expressad.mbbanner.a.d.b b;
    private java.lang.String c;

    public f(com.anythink.expressad.mbbanner.a.d.b bVar, java.lang.String str) {
        this.b = bVar;
        this.c = str;
    }

    @Override // com.anythink.expressad.videocommon.b.i.a
    public final void a(java.lang.String str) {
        com.anythink.expressad.mbbanner.a.d.b bVar = this.b;
        if (bVar != null) {
            bVar.a(this.c, 3, str, true);
        }
    }

    @Override // com.anythink.expressad.videocommon.b.i.a
    public final void a(java.lang.String str, java.lang.String str2) {
        com.anythink.expressad.mbbanner.a.d.b bVar = this.b;
        if (bVar != null) {
            bVar.a(this.c, 3, str, false);
        }
    }
}
