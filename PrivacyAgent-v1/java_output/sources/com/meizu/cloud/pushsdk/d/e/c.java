package com.meizu.cloud.pushsdk.d.e;

/* loaded from: classes23.dex */
public class c {
    private static final java.lang.String a = "c";
    private final java.util.HashMap<java.lang.String, java.lang.String> b;
    private final java.util.HashMap<java.lang.String, java.lang.Object> c;
    private final java.util.HashMap<java.lang.String, java.lang.String> d;

    public static class a {
        private android.content.Context a = null;

        public com.meizu.cloud.pushsdk.d.e.c.a a(android.content.Context context) {
            this.a = context;
            return this;
        }

        public com.meizu.cloud.pushsdk.d.e.c a() {
            return new com.meizu.cloud.pushsdk.d.e.c(this, null);
        }
    }

    private c(com.meizu.cloud.pushsdk.d.e.c.a aVar) {
        this.b = new java.util.HashMap<>();
        this.c = new java.util.HashMap<>();
        this.d = new java.util.HashMap<>();
        d();
        e();
        f();
        g();
        if (aVar.a != null) {
            a(aVar.a);
        }
        com.meizu.cloud.pushsdk.d.f.c.c(a, "Subject created successfully.", new java.lang.Object[0]);
    }

    public /* synthetic */ c(com.meizu.cloud.pushsdk.d.e.c.a aVar, com.meizu.cloud.pushsdk.d.e.c.AnonymousClass1 anonymousClass1) {
        this(aVar);
    }

    private void a(java.lang.String str, java.lang.String str2) {
        if (str == null || str2 == null || str.isEmpty() || str2.isEmpty()) {
            return;
        }
        this.d.put(str, str2);
    }

    private void d() {
        a(com.anythink.expressad.foundation.g.a.J, "android-" + android.os.Build.VERSION.RELEASE);
    }

    private void e() {
        a("ov", android.os.Build.DISPLAY);
    }

    private void f() {
        a("dm", android.os.Build.MODEL);
    }

    private void g() {
        a("df", android.os.Build.MANUFACTURER);
    }

    public java.util.Map<java.lang.String, java.lang.Object> a() {
        return this.c;
    }

    public void a(android.content.Context context) {
        b(context);
    }

    public java.util.Map<java.lang.String, java.lang.String> b() {
        return this.d;
    }

    public void b(android.content.Context context) {
        java.lang.String b = com.meizu.cloud.pushsdk.d.f.e.b(context);
        if (b != null) {
            a("ca", b);
        }
    }

    public java.util.Map<java.lang.String, java.lang.String> c() {
        return this.b;
    }
}
