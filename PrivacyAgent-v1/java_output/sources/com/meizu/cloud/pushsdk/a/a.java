package com.meizu.cloud.pushsdk.a;

/* loaded from: classes23.dex */
public class a {

    /* renamed from: com.meizu.cloud.pushsdk.a.a$1, reason: invalid class name */
    public static class AnonymousClass1 implements java.lang.Runnable {
        final /* synthetic */ android.content.Context a;

        public AnonymousClass1(android.content.Context context) {
            this.a = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.meizu.cloud.pushsdk.a.a.b.a(this.a).a("POST", null, com.meizu.cloud.pushsdk.a.a.a(this.a).toString());
        }
    }

    public static com.meizu.cloud.pushsdk.d.a.c a(android.content.Context context) {
        com.meizu.cloud.pushsdk.d.a.c cVar = new com.meizu.cloud.pushsdk.d.a.c();
        com.meizu.cloud.pushsdk.a.b c = c(context);
        java.util.Map<java.lang.String, java.lang.String> a = c.a();
        java.util.Map<java.lang.String, java.lang.Object> b = c.b();
        java.util.Map<java.lang.String, java.lang.Object> c2 = c.c();
        if (a.size() > 0) {
            cVar.a(com.meizu.cloud.pushsdk.notification.model.AppIconSetting.DEFAULT_LARGE_ICON, a);
        }
        if (b.size() > 0) {
            cVar.a(com.anythink.expressad.d.a.b.cZ, b);
        }
        if (c2.size() > 0) {
            cVar.a(com.meizu.cloud.pushsdk.notification.model.AppIconSetting.LARGE_ICON_URL, c2);
        }
        return cVar;
    }

    public static void b(android.content.Context context) {
        com.meizu.cloud.pushsdk.b.c.a.a().execute(new com.meizu.cloud.pushsdk.a.a.AnonymousClass1(context));
    }

    private static com.meizu.cloud.pushsdk.a.b c(android.content.Context context) {
        return new com.meizu.cloud.pushsdk.a.b.a().a(context).a();
    }
}
