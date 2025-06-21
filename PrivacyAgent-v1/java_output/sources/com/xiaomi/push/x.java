package com.xiaomi.push;

/* loaded from: classes19.dex */
final class x implements com.xiaomi.push.u {
    private android.content.Context a;
    private java.lang.Class<?> b;
    private java.lang.Object c;
    private java.lang.reflect.Method d;
    private java.lang.reflect.Method e;
    private java.lang.reflect.Method f;
    private java.lang.reflect.Method g;

    public x(android.content.Context context) {
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = null;
        this.a = context;
        try {
            java.lang.Class<?> a = com.xiaomi.push.jc.a(context, "com.android.id.impl.IdProviderImpl");
            this.b = a;
            this.c = a.newInstance();
            this.d = this.b.getMethod("getUDID", android.content.Context.class);
            this.e = this.b.getMethod("getOAID", android.content.Context.class);
            this.f = this.b.getMethod("getVAID", android.content.Context.class);
            this.g = this.b.getMethod("getAAID", android.content.Context.class);
        } catch (java.lang.Exception e) {
            com.xiaomi.channel.commonutils.logger.b.a("miui load class error", e);
        }
    }

    private java.lang.String a(android.content.Context context, java.lang.reflect.Method method) {
        java.lang.Object obj = this.c;
        if (obj == null || method == null) {
            return null;
        }
        try {
            java.lang.Object invoke = method.invoke(obj, context);
            if (invoke != null) {
                return (java.lang.String) invoke;
            }
            return null;
        } catch (java.lang.Exception e) {
            com.xiaomi.channel.commonutils.logger.b.a("miui invoke error", e);
            return null;
        }
    }

    @Override // com.xiaomi.push.u
    public final boolean a() {
        return (this.b == null || this.c == null) ? false : true;
    }

    @Override // com.xiaomi.push.u
    public final java.lang.String b() {
        return a(this.a, this.e);
    }
}
