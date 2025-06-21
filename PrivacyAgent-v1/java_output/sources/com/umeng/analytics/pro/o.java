package com.umeng.analytics.pro;

@android.annotation.TargetApi(14)
/* loaded from: classes19.dex */
public class o implements android.app.Application.ActivityLifecycleCallbacks {
    private static com.umeng.analytics.pro.o a = new com.umeng.analytics.pro.o();
    private final int b = 3000;
    private boolean c = false;
    private boolean d = true;
    private android.os.Handler e = new android.os.Handler(android.os.Looper.getMainLooper());
    private java.util.ArrayList<com.umeng.analytics.pro.p> f = new java.util.ArrayList<>();
    private com.umeng.analytics.pro.o.a g = new com.umeng.analytics.pro.o.a();

    public class a implements java.lang.Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!com.umeng.analytics.pro.o.this.c || !com.umeng.analytics.pro.o.this.d) {
                com.umeng.commonsdk.debug.UMRTLog.i(com.umeng.commonsdk.debug.UMRTLog.RTLOG_TAG, "--->>> still foreground.");
                return;
            }
            com.umeng.analytics.pro.o.this.c = false;
            com.umeng.commonsdk.debug.UMRTLog.i(com.umeng.commonsdk.debug.UMRTLog.RTLOG_TAG, "--->>> went background.");
            for (int i = 0; i < com.umeng.analytics.pro.o.this.f.size(); i++) {
                ((com.umeng.analytics.pro.p) com.umeng.analytics.pro.o.this.f.get(i)).n();
            }
        }
    }

    private o() {
    }

    public static com.umeng.analytics.pro.o a() {
        return a;
    }

    public static void a(android.content.Context context) {
        if (context instanceof android.app.Application) {
            ((android.app.Application) context).registerActivityLifecycleCallbacks(a);
        }
    }

    public synchronized void a(com.umeng.analytics.pro.p pVar) {
        if (pVar != null) {
            this.f.add(pVar);
        }
    }

    public synchronized void b(com.umeng.analytics.pro.p pVar) {
        if (pVar != null) {
            for (int i = 0; i < this.f.size(); i++) {
                if (this.f.get(i) == pVar) {
                    this.f.remove(i);
                }
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(android.app.Activity activity, android.os.Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(android.app.Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(android.app.Activity activity) {
        this.d = true;
        com.umeng.analytics.pro.o.a aVar = this.g;
        if (aVar != null) {
            this.e.removeCallbacks(aVar);
            this.e.postDelayed(this.g, 3000L);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(android.app.Activity activity) {
        this.d = false;
        this.c = true;
        com.umeng.analytics.pro.o.a aVar = this.g;
        if (aVar != null) {
            this.e.removeCallbacks(aVar);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(android.app.Activity activity, android.os.Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(android.app.Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(android.app.Activity activity) {
    }
}
