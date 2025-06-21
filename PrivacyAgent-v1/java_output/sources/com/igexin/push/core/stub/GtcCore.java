package com.igexin.push.core.stub;

import com.igexin.push.core.e.f.AnonymousClass31;

/* loaded from: classes23.dex */
public class GtcCore implements com.igexin.sdk.IPushCore {
    private static final java.lang.String a = "GtcCore";

    /* renamed from: com.igexin.push.core.stub.GtcCore$1, reason: invalid class name */
    public class AnonymousClass1 extends com.getui.gtc.api.GtcIdCallback.Stub {
        final /* synthetic */ long a;
        final /* synthetic */ java.util.concurrent.atomic.AtomicInteger b;

        /* renamed from: com.igexin.push.core.stub.GtcCore$1$1, reason: invalid class name and collision with other inner class name */
        public class RunnableC03721 implements java.lang.Runnable {
            final /* synthetic */ java.lang.String a;
            final /* synthetic */ android.os.Handler b;

            public RunnableC03721(java.lang.String str, android.os.Handler handler) {
                this.a = str;
                this.b = handler;
            }

            @Override // java.lang.Runnable
            public final void run() {
                if (com.igexin.push.core.e.m.get()) {
                    com.igexin.push.core.stub.GtcCore.AnonymousClass1.this.b.get();
                    com.igexin.push.core.stub.GtcCore.a(this.a);
                } else if (com.igexin.push.core.stub.GtcCore.AnonymousClass1.this.b.incrementAndGet() <= 30) {
                    com.igexin.push.core.stub.GtcCore.AnonymousClass1.this.b.get();
                    this.b.postDelayed(this, 300L);
                }
            }
        }

        public AnonymousClass1(long j, java.util.concurrent.atomic.AtomicInteger atomicInteger) {
            this.a = j;
            this.b = atomicInteger;
        }

        @Override // com.getui.gtc.api.GtcIdCallback
        public final void onFailure(java.lang.String str) throws android.os.RemoteException {
            com.igexin.c.a.c.a.a("GtcCore|gtcid callback error ,error info is :".concat(java.lang.String.valueOf(str)), new java.lang.Object[0]);
        }

        @Override // com.getui.gtc.api.GtcIdCallback
        public final void onSuccess(java.lang.String str) throws android.os.RemoteException {
            java.lang.System.currentTimeMillis();
            com.igexin.c.a.c.a.a("GtcCore|gtcid = ".concat(java.lang.String.valueOf(str)), new java.lang.Object[0]);
            if (com.igexin.push.core.e.m.get()) {
                com.igexin.push.core.stub.GtcCore.a(str);
            } else {
                android.os.Handler handler = new android.os.Handler(android.os.Looper.getMainLooper());
                handler.postDelayed(new com.igexin.push.core.stub.GtcCore.AnonymousClass1.RunnableC03721(str, handler), 300L);
            }
        }
    }

    public static /* synthetic */ void a(java.lang.String str) {
        try {
            if (str.equals(com.igexin.push.core.e.C)) {
                return;
            }
            com.igexin.push.core.e.f a2 = com.igexin.push.core.e.f.a();
            com.igexin.push.core.e.C = str;
            com.igexin.c.a.b.e.a().a((com.igexin.c.a.d.f) a2.new AnonymousClass31(), false, true);
            if (com.igexin.push.core.e.u) {
                com.igexin.push.core.a.b.d().i();
            }
        } catch (java.lang.Exception e) {
            com.igexin.c.a.c.a.a(e);
        }
    }

    private static void b(java.lang.String str) {
        try {
            if (str.equals(com.igexin.push.core.e.C)) {
                return;
            }
            com.igexin.push.core.e.f a2 = com.igexin.push.core.e.f.a();
            com.igexin.push.core.e.C = str;
            com.igexin.c.a.b.e.a().a((com.igexin.c.a.d.f) a2.new AnonymousClass31(), false, true);
            if (com.igexin.push.core.e.u) {
                com.igexin.push.core.a.b.d().i();
            }
        } catch (java.lang.Exception e) {
            com.igexin.c.a.c.a.a(e);
        }
    }

    @Override // com.igexin.sdk.IPushCore
    public void onActivityConfigurationChanged(android.app.Activity activity, android.content.res.Configuration configuration) {
    }

    @Override // com.igexin.sdk.IPushCore
    public boolean onActivityCreateOptionsMenu(android.app.Activity activity, android.view.Menu menu) {
        return false;
    }

    @Override // com.igexin.sdk.IPushCore
    public void onActivityDestroy(android.app.Activity activity) {
    }

    @Override // com.igexin.sdk.IPushCore
    public boolean onActivityKeyDown(android.app.Activity activity, int i, android.view.KeyEvent keyEvent) {
        return false;
    }

    @Override // com.igexin.sdk.IPushCore
    public void onActivityNewIntent(android.app.Activity activity, android.content.Intent intent) {
    }

    @Override // com.igexin.sdk.IPushCore
    public void onActivityPause(android.app.Activity activity) {
    }

    @Override // com.igexin.sdk.IPushCore
    public void onActivityRestart(android.app.Activity activity) {
    }

    @Override // com.igexin.sdk.IPushCore
    public void onActivityResume(android.app.Activity activity) {
    }

    @Override // com.igexin.sdk.IPushCore
    public void onActivityStart(android.app.Activity activity, android.content.Intent intent) {
    }

    @Override // com.igexin.sdk.IPushCore
    public void onActivityStop(android.app.Activity activity) {
    }

    @Override // com.igexin.sdk.IPushCore
    public android.os.IBinder onServiceBind(android.content.Intent intent) {
        return null;
    }

    @Override // com.igexin.sdk.IPushCore
    public void onServiceDestroy() {
    }

    @Override // com.igexin.sdk.IPushCore
    public int onServiceStartCommand(android.content.Intent intent, int i, int i2) {
        return 2;
    }

    @Override // com.igexin.sdk.IPushCore
    public boolean start(android.content.Context context) {
        com.igexin.c.a.c.a.a("GtcCore | ready to start gtc ", new java.lang.Object[0]);
        long currentTimeMillis = java.lang.System.currentTimeMillis();
        java.util.concurrent.atomic.AtomicInteger atomicInteger = new java.util.concurrent.atomic.AtomicInteger(1);
        try {
            com.igexin.push.h.n.u();
            java.lang.String initialize = com.getui.gtc.api.GtcManager.getInstance().initialize(context, com.getui.gtc.dim.Caller.PUSH, new com.igexin.push.core.stub.GtcCore.AnonymousClass1(currentTimeMillis, atomicInteger));
            java.lang.System.currentTimeMillis();
            com.igexin.c.a.c.a.a("GtcCore|gtcid = ".concat(java.lang.String.valueOf(initialize)), new java.lang.Object[0]);
        } catch (java.lang.Throwable th) {
            com.igexin.c.a.c.a.a("GtcCore|init gtc error =  " + th.toString(), new java.lang.Object[0]);
        }
        java.lang.System.currentTimeMillis();
        return true;
    }
}
