package com.anythink.expressad.splash.c;

/* loaded from: classes12.dex */
public final class a {

    /* renamed from: com.anythink.expressad.splash.c.a$a, reason: collision with other inner class name */
    public static class C0222a {
        private static final com.anythink.expressad.splash.c.a a = new com.anythink.expressad.splash.c.a((byte) 0);
    }

    private a() {
    }

    public /* synthetic */ a(byte b) {
        this();
    }

    private static com.anythink.expressad.splash.c.a a() {
        return com.anythink.expressad.splash.c.a.C0222a.a;
    }

    private static void a(android.content.Context context, com.anythink.expressad.splash.view.ATSplashView aTSplashView, com.anythink.expressad.splash.a.b bVar, com.anythink.expressad.splash.b.a aVar) {
        try {
            com.anythink.expressad.splash.view.ATSplashNativeView aTSplashNativeView = new com.anythink.expressad.splash.view.ATSplashNativeView(context, aTSplashView, bVar);
            if (aVar != null) {
                aVar.a(aTSplashNativeView);
            }
        } catch (java.lang.Throwable unused) {
            if (aVar != null) {
                aVar.a("View render error.");
            }
        }
    }

    public static void a(com.anythink.expressad.splash.view.ATSplashView aTSplashView, com.anythink.expressad.splash.a.b bVar, com.anythink.expressad.splash.b.a aVar) {
        android.content.Context context = aTSplashView.getContext();
        if (context == null) {
            context = com.anythink.core.common.b.o.a().f();
        }
        try {
            aVar.a(new com.anythink.expressad.splash.view.ATSplashNativeView(context, aTSplashView, bVar));
        } catch (java.lang.Throwable unused) {
            aVar.a("View render error.");
        }
    }
}
