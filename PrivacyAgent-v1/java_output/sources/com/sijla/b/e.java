package com.sijla.b;

/* loaded from: classes19.dex */
final class e implements android.app.Application.ActivityLifecycleCallbacks {
    final /* synthetic */ android.app.Application a;

    public e(android.app.Application application) {
        this.a = application;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(android.app.Activity activity, android.os.Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(android.app.Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(android.app.Activity activity) {
        com.sijla.b.g.f = 0;
        com.sijla.b.d.a = "";
        com.sijla.b.a.b(activity);
        com.sijla.a.a.a(new com.sijla.b.f(this), 1000L);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(android.app.Activity activity) {
        boolean z;
        com.sijla.b.d.a aVar;
        com.sijla.b.d.a aVar2;
        com.sijla.b.g.f = 1;
        com.sijla.b.d.a = activity.getLocalClassName();
        com.sijla.b.a.a(activity);
        try {
            z = com.sijla.b.d.c;
            if (!z) {
                com.sijla.b.g.c(this.a);
                com.sijla.b.d.b();
            }
            aVar = com.sijla.b.d.d;
            if (aVar.a == 0) {
                aVar2 = com.sijla.b.d.d;
                aVar2.a = java.lang.System.currentTimeMillis();
                com.sijla.b.g.c(this.a);
            }
        } catch (java.lang.Exception e) {
            e.printStackTrace();
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
