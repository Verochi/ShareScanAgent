package com.igexin.push.core.stub;

/* loaded from: classes23.dex */
public class PushCore implements com.igexin.sdk.IPushCore {
    private com.igexin.push.core.d a;
    private java.util.Map<android.app.Activity, com.igexin.push.core.i.a> b = new java.util.HashMap();
    private com.igexin.push.GtPushInterface.Stub c = new com.igexin.push.core.stub.PushCore.AnonymousClass1();

    /* renamed from: com.igexin.push.core.stub.PushCore$1, reason: invalid class name */
    public class AnonymousClass1 extends com.igexin.push.GtPushInterface.Stub {
        public AnonymousClass1() {
        }

        @Override // com.igexin.push.GtPushInterface
        public final java.lang.String getVersion() {
            return "3.3.7.2";
        }

        @Override // com.igexin.push.GtPushInterface
        public final boolean loadSdk(android.os.Bundle bundle) {
            try {
                java.lang.String string = bundle.getString(com.meizu.cloud.pushsdk.notification.model.AdvanceSetting.CLEAR_NOTIFICATION);
                com.getui.gtc.api.GtcManager.getInstance().loadBundle(com.igexin.push.core.ServiceManager.b, bundle);
                if (!android.text.TextUtils.isEmpty(string)) {
                    com.igexin.push.core.e.o.put(string.substring(string.indexOf("distribution") + 13, string.indexOf("stub") - 1), com.getui.gtc.api.GtcManager.getInstance().getClassLoader(bundle));
                }
                return true;
            } catch (java.lang.Throwable th) {
                com.igexin.c.a.c.a.a(th);
                return false;
            }
        }
    }

    @Override // com.igexin.sdk.IPushCore
    public void onActivityConfigurationChanged(android.app.Activity activity, android.content.res.Configuration configuration) {
        this.b.get(activity);
    }

    @Override // com.igexin.sdk.IPushCore
    public boolean onActivityCreateOptionsMenu(android.app.Activity activity, android.view.Menu menu) {
        com.igexin.push.core.i.a aVar = this.b.get(activity);
        return aVar != null && aVar.i();
    }

    @Override // com.igexin.sdk.IPushCore
    public void onActivityDestroy(android.app.Activity activity) {
        com.igexin.push.core.i.a aVar = this.b.get(activity);
        if (aVar != null) {
            this.b.remove(activity);
            com.igexin.push.core.i.b.a().a(aVar);
        }
    }

    @Override // com.igexin.sdk.IPushCore
    public boolean onActivityKeyDown(android.app.Activity activity, int i, android.view.KeyEvent keyEvent) {
        com.igexin.push.core.i.a aVar = this.b.get(activity);
        return aVar != null && aVar.k();
    }

    @Override // com.igexin.sdk.IPushCore
    public void onActivityNewIntent(android.app.Activity activity, android.content.Intent intent) {
        this.b.get(activity);
    }

    @Override // com.igexin.sdk.IPushCore
    public void onActivityPause(android.app.Activity activity) {
        this.b.get(activity);
    }

    @Override // com.igexin.sdk.IPushCore
    public void onActivityRestart(android.app.Activity activity) {
        this.b.get(activity);
    }

    @Override // com.igexin.sdk.IPushCore
    public void onActivityResume(android.app.Activity activity) {
        this.b.get(activity);
    }

    @Override // com.igexin.sdk.IPushCore
    public void onActivityStart(android.app.Activity activity, android.content.Intent intent) {
        if (activity == null || intent == null || !intent.hasExtra("activityid")) {
            return;
        }
        com.igexin.push.core.i.a aVar = com.igexin.push.core.i.b.a().a.get(java.lang.Long.valueOf(intent.getLongExtra("activityid", 0L)));
        if (aVar == null) {
            activity.finish();
        } else {
            aVar.a(activity);
            this.b.put(activity, aVar);
        }
    }

    @Override // com.igexin.sdk.IPushCore
    public void onActivityStop(android.app.Activity activity) {
        this.b.get(activity);
    }

    @Override // com.igexin.sdk.IPushCore
    public android.os.IBinder onServiceBind(android.content.Intent intent) {
        return this.c;
    }

    @Override // com.igexin.sdk.IPushCore
    public void onServiceDestroy() {
    }

    @Override // com.igexin.sdk.IPushCore
    public int onServiceStartCommand(android.content.Intent intent, int i, int i2) {
        if (this.a == null) {
            return 2;
        }
        android.os.Message obtain = android.os.Message.obtain();
        obtain.what = com.igexin.push.core.b.P;
        obtain.obj = intent;
        this.a.a(obtain);
        return 2;
    }

    @Override // com.igexin.sdk.IPushCore
    public boolean start(android.content.Context context) {
        com.igexin.c.a.c.a.d.a().a("PushCore started");
        com.igexin.push.core.d dVar = com.igexin.push.core.d.a.a;
        this.a = dVar;
        dVar.a(context);
        return true;
    }
}
