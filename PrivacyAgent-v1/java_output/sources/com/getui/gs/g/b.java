package com.getui.gs.g;

/* loaded from: classes22.dex */
public final class b implements android.app.Application.ActivityLifecycleCallbacks {
    static final com.getui.gs.g.b a = new com.getui.gs.g.b();

    public static void a(android.content.Context context) {
        try {
            android.app.Application application = (android.app.Application) context.getApplicationContext();
            com.getui.gs.g.b bVar = a;
            application.unregisterActivityLifecycleCallbacks(bVar);
            application.registerActivityLifecycleCallbacks(bVar);
        } catch (java.lang.Throwable th) {
            com.getui.gs.h.b.a.a.a.e(th);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(android.app.Activity activity, android.os.Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(android.app.Activity activity) {
        try {
            com.getui.gs.a.c.e();
        } catch (java.lang.Throwable th) {
            com.getui.gs.h.b.a.a.a.e(th);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(android.app.Activity activity) {
        try {
            com.getui.gs.a.c.d();
        } catch (java.lang.Throwable th) {
            com.getui.gs.h.b.a.a.a.e(th);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(android.app.Activity activity) {
        try {
            com.getui.gs.a.c.c();
        } catch (java.lang.Throwable th) {
            com.getui.gs.h.b.a.a.a.e(th);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(android.app.Activity activity, android.os.Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(android.app.Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(android.app.Activity activity) {
    }
}
