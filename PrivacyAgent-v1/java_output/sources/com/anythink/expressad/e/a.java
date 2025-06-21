package com.anythink.expressad.e;

/* loaded from: classes12.dex */
public final class a implements com.anythink.expressad.b {
    public static java.util.Map<java.lang.String, java.lang.String> a;
    private android.content.Context b;
    private boolean c = false;

    private void a() {
        this.c = false;
        try {
            com.anythink.expressad.foundation.g.f.m.a(this.b);
            com.anythink.expressad.foundation.b.b.a().a(a, this.b);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.anythink.expressad.b
    public final void a(java.util.Map<java.lang.String, java.lang.String> map, android.content.Context context) {
        android.content.Context applicationContext = context.getApplicationContext();
        this.b = applicationContext;
        a = map;
        this.c = false;
        try {
            com.anythink.expressad.foundation.g.f.m.a(applicationContext);
            com.anythink.expressad.foundation.b.b.a().a(a, this.b);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }
}
