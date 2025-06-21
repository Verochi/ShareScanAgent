package com.anythink.expressad.mbbanner.a.c;

/* loaded from: classes12.dex */
public class g implements com.anythink.expressad.foundation.g.d.c {
    private static final java.lang.String a = "g";
    private com.anythink.expressad.mbbanner.a.d.b b;
    private java.lang.String c;

    public g(com.anythink.expressad.mbbanner.a.d.b bVar, java.lang.String str) {
        this.b = bVar;
        this.c = str;
    }

    @Override // com.anythink.expressad.foundation.g.d.c
    public final void a(android.graphics.Bitmap bitmap, java.lang.String str) {
        this.b.a(this.c, 1, str, true);
    }

    @Override // com.anythink.expressad.foundation.g.d.c
    public final void a(java.lang.String str, java.lang.String str2) {
        this.b.a(this.c, 1, str2, false);
    }
}
