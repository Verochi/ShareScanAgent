package com.anythink.basead.f;

/* loaded from: classes12.dex */
public final class b extends com.anythink.basead.f.c {
    com.anythink.basead.e.a a;
    private final java.lang.String k;

    public b(android.content.Context context, com.anythink.core.common.f.m mVar, java.lang.String str, boolean z) {
        super(context, mVar, str, z);
        this.k = com.anythink.basead.f.b.class.getSimpleName();
    }

    @Override // com.anythink.basead.f.a
    public final void a(android.app.Activity activity, java.util.Map<java.lang.String, java.lang.Object> map) {
    }

    public final void a(com.anythink.basead.e.a aVar) {
        this.a = aVar;
    }

    public final android.view.View b() {
        if (a()) {
            return this.g.j() ? new com.anythink.basead.ui.MraidBannerATView(this.c, this.d, this.g, this.a) : new com.anythink.basead.ui.SdkBannerATView(this.c, this.d, this.g, this.a);
        }
        return null;
    }

    @Override // com.anythink.basead.f.c
    public final void c() {
        this.a = null;
    }
}
