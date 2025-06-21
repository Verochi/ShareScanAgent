package com.anythink.china.a.a;

/* loaded from: classes12.dex */
public final class d {
    private android.content.Context a;
    private android.app.KeyguardManager b;

    public d(android.content.Context context) {
        this.a = context;
    }

    public final void a(com.anythink.china.a.a aVar) {
        android.content.Context context = this.a;
        if (context == null) {
            return;
        }
        if (this.b == null) {
            this.b = (android.app.KeyguardManager) context.getSystemService("keyguard");
        }
        android.app.KeyguardManager keyguardManager = this.b;
        if (keyguardManager == null) {
            aVar.a();
            return;
        }
        try {
            java.lang.Object invoke = keyguardManager.getClass().getDeclaredMethod("obtainOaid", new java.lang.Class[0]).invoke(this.b, new java.lang.Object[0]);
            if (invoke != null) {
                aVar.a(invoke.toString(), false);
            } else {
                aVar.a();
            }
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }
}
