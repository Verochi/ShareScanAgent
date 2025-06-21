package com.anythink.core.common.b;

/* loaded from: classes12.dex */
public final class f implements android.app.Application.ActivityLifecycleCallbacks {
    int a;
    boolean d;
    boolean c = false;
    java.util.concurrent.ConcurrentHashMap<java.lang.String, java.lang.Boolean> b = new java.util.concurrent.ConcurrentHashMap<>(3);

    public f(boolean z) {
        this.d = false;
        if (z) {
            this.d = true;
            a();
        }
    }

    private static void a() {
        com.anythink.core.common.n.c.a();
        com.anythink.core.common.n.a.a(com.anythink.core.common.b.o.a().f()).a(21, new com.anythink.core.common.f.h());
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(android.app.Activity activity, android.os.Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(android.app.Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(android.app.Activity activity) {
        if (this.d) {
            return;
        }
        this.d = true;
        a();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(android.app.Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(android.app.Activity activity, android.os.Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(android.app.Activity activity) {
        com.anythink.core.common.b.o.a().a(activity);
        this.a++;
        this.b.put(activity.toString(), java.lang.Boolean.TRUE);
        if (this.a != 1 || this.d) {
            return;
        }
        this.d = true;
        a();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(android.app.Activity activity) {
        this.a--;
        boolean containsKey = this.b.containsKey(activity.toString());
        if (!this.c && !containsKey) {
            this.c = true;
            this.a++;
        }
        if (containsKey) {
            try {
                this.b.remove(activity.toString());
            } catch (java.lang.Throwable unused) {
            }
        }
        if (this.a == 0) {
            this.d = false;
        }
    }
}
