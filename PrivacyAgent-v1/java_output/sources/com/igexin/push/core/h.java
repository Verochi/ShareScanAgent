package com.igexin.push.core;

/* loaded from: classes23.dex */
public final class h implements android.app.Application.ActivityLifecycleCallbacks {
    private static final java.lang.String a = "GALC";
    private java.util.concurrent.atomic.AtomicLong b = new java.util.concurrent.atomic.AtomicLong(0);
    private volatile int c;

    /* renamed from: com.igexin.push.core.h$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {
        final /* synthetic */ android.content.Context a;

        public AnonymousClass1(android.content.Context context) {
            this.a = context;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                java.lang.Thread.currentThread().getName();
                com.igexin.c.a.c.a.a("GALC|>>>>>> FG threadName=" + java.lang.Thread.currentThread().getName(), new java.lang.Object[0]);
                if (com.igexin.push.h.j.a(this.a) || java.lang.System.currentTimeMillis() - com.igexin.push.core.h.this.b.get() <= com.google.android.exoplayer2.audio.SilenceSkippingAudioProcessor.DEFAULT_PADDING_SILENCE_US) {
                    return;
                }
                android.content.Context context = this.a;
                com.igexin.push.core.a.b.d();
                android.content.Intent intent = new android.content.Intent(context, (java.lang.Class<?>) com.igexin.push.core.a.b.a(this.a));
                intent.putExtra("action", com.igexin.sdk.PushConsts.ACTION_SERVICE_ONRESUME);
                com.igexin.push.core.ServiceManager.getInstance().b(this.a, intent);
                com.igexin.c.a.c.a.a("GALC|on fg, start>>>>>>", new java.lang.Object[0]);
                com.igexin.push.core.h.this.b.set(java.lang.System.currentTimeMillis());
            } catch (java.lang.Throwable th) {
                com.igexin.c.a.c.a.a(th);
            }
        }
    }

    private void a(android.app.Activity activity) {
        android.content.Context applicationContext = activity.getApplicationContext();
        activity.getComponentName().getClassName();
        com.igexin.c.a.c.a.a("GALC|" + activity.getComponentName().getClassName() + " onAStart " + this.c, new java.lang.Object[0]);
        if (this.c == 0) {
            com.igexin.b.a.a().a("GTALCallback").execute(new com.igexin.push.core.h.AnonymousClass1(applicationContext));
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(android.app.Activity activity, android.os.Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(android.app.Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(android.app.Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(android.app.Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(android.app.Activity activity, android.os.Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(android.app.Activity activity) {
        if (activity == null) {
            return;
        }
        android.content.Context applicationContext = activity.getApplicationContext();
        activity.getComponentName().getClassName();
        com.igexin.c.a.c.a.a("GALC|" + activity.getComponentName().getClassName() + " onAStart " + this.c, new java.lang.Object[0]);
        if (this.c == 0) {
            com.igexin.b.a.a().a("GTALCallback").execute(new com.igexin.push.core.h.AnonymousClass1(applicationContext));
        }
        this.c++;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(android.app.Activity activity) {
        if (activity == null) {
            return;
        }
        this.c--;
        this.c = java.lang.Math.max(this.c, 0);
        com.igexin.c.a.c.a.b(a, "|" + activity.getComponentName().getClassName() + " onAStopp " + this.c);
        if (this.c == 0) {
            com.igexin.c.a.c.a.a("GALC|>>>>>> on bg", new java.lang.Object[0]);
        }
    }
}
