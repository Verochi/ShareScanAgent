package com.meizu.cloud.pushsdk.a;

/* loaded from: classes23.dex */
public class b {
    private static final java.lang.String a = "b";
    private final java.util.HashMap<java.lang.String, java.lang.String> b;
    private final java.util.HashMap<java.lang.String, java.lang.Object> c;
    private final java.util.HashMap<java.lang.String, java.lang.Object> d;

    public static class a {
        private android.content.Context a = null;

        public com.meizu.cloud.pushsdk.a.b.a a(android.content.Context context) {
            this.a = context;
            return this;
        }

        public com.meizu.cloud.pushsdk.a.b a() {
            return new com.meizu.cloud.pushsdk.a.b(this, null);
        }
    }

    private b(com.meizu.cloud.pushsdk.a.b.a aVar) {
        this.b = new java.util.HashMap<>();
        this.c = new java.util.HashMap<>();
        this.d = new java.util.HashMap<>();
        d();
        if (aVar.a != null) {
            b(aVar.a);
            a(aVar.a);
            c(aVar.a);
            d(aVar.a);
        }
        com.meizu.cloud.pushinternal.DebugLogger.i(a, "Subject created successfully.");
    }

    public /* synthetic */ b(com.meizu.cloud.pushsdk.a.b.a aVar, com.meizu.cloud.pushsdk.a.b.AnonymousClass1 anonymousClass1) {
        this(aVar);
    }

    private void a(java.lang.String str, int i, int i2) {
        this.b.put(str, i + "." + i2);
    }

    private void a(java.lang.String str, java.lang.Object obj) {
        if (android.text.TextUtils.isEmpty(str) || obj == null) {
            return;
        }
        if ((obj instanceof java.lang.String) && ((java.lang.String) obj).isEmpty()) {
            return;
        }
        this.c.put(str, obj);
    }

    private void a(java.lang.String str, java.lang.String str2) {
        if (android.text.TextUtils.isEmpty(str) || android.text.TextUtils.isEmpty(str2)) {
            return;
        }
        this.b.put(str, str2);
    }

    private void b(android.content.Context context) {
        a("op", com.meizu.cloud.pushsdk.d.f.e.c(context));
    }

    private void b(java.lang.String str, java.lang.Object obj) {
        if (android.text.TextUtils.isEmpty(str) || obj == null) {
            return;
        }
        if ((obj instanceof java.lang.String) && ((java.lang.String) obj).isEmpty()) {
            return;
        }
        this.d.put(str, obj);
    }

    private void c(android.content.Context context) {
        b("nt", com.meizu.cloud.pushsdk.util.MzSystemUtils.getNetWorkType(context));
    }

    private void d() {
        a("br", android.os.Build.BRAND);
        a("dc", android.os.Build.MODEL);
        a(com.anythink.expressad.foundation.g.a.J, android.os.Build.VERSION.RELEASE);
        a("ov", android.os.Build.DISPLAY);
        a("ll", com.meizu.cloud.pushsdk.util.MzSystemUtils.getCurrentLanguage());
    }

    private void d(android.content.Context context) {
        a("pn", (java.lang.Object) context.getPackageName());
        a(com.umeng.analytics.pro.f.T, (java.lang.Object) com.meizu.cloud.pushsdk.util.MzSystemUtils.getAppVersionName(context));
        a("pvc", java.lang.Integer.valueOf(com.meizu.cloud.pushsdk.util.MzSystemUtils.getAppVersionCode(context)));
        a("st", java.lang.Integer.valueOf(!android.text.TextUtils.isEmpty(com.meizu.cloud.pushsdk.util.MzSystemUtils.findReceiver(context, "com.meizu.ups.push.intent.MESSAGE", context.getPackageName())) ? 1 : 0));
    }

    public java.util.Map<java.lang.String, java.lang.String> a() {
        return this.b;
    }

    public void a(android.content.Context context) {
        android.graphics.Point d = com.meizu.cloud.pushsdk.d.f.e.d(context);
        if (d == null) {
            com.meizu.cloud.pushinternal.DebugLogger.e(a, "screen information not available.");
        } else {
            a("ss", d.x, d.y);
        }
    }

    public java.util.Map<java.lang.String, java.lang.Object> b() {
        return this.c;
    }

    public java.util.Map<java.lang.String, java.lang.Object> c() {
        return this.d;
    }
}
