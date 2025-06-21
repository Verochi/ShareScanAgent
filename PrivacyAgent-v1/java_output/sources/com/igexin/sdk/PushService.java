package com.igexin.sdk;

/* loaded from: classes23.dex */
public class PushService extends android.app.Service {
    public static final /* synthetic */ int n = 0;
    private final java.lang.String TAG = getClass().getName();
    private com.igexin.push.f.b qtsService;

    @Override // android.app.Service
    public android.os.IBinder onBind(android.content.Intent intent) {
        java.lang.String type = (intent == null || intent.getType() == null) ? "" : intent.getType();
        if (type.startsWith("GB-") || type.startsWith("PB-")) {
            com.igexin.push.core.ServiceManager.getInstance().a(this, intent, 0, 0);
            return null;
        }
        if (com.igexin.c.a.c.a.c.a.equals(type)) {
            return com.igexin.c.a.c.a.d.a().a.getBinder();
        }
        if (type.startsWith("GTC-")) {
            return com.igexin.push.core.ServiceManager.getInstance().a((android.app.Service) this, intent);
        }
        this.qtsService.a(intent);
        return com.igexin.push.core.ServiceManager.getInstance().a((android.app.Service) this, intent);
    }

    @Override // android.app.Service
    public void onCreate() {
        try {
            com.getui.gtc.base.GtcProvider.setContext(this);
        } catch (java.lang.Exception e) {
            com.igexin.c.a.c.a.a(e);
        }
        super.onCreate();
        com.igexin.push.core.ServiceManager.getInstance();
        com.igexin.push.core.ServiceManager.a((android.content.Context) this);
        com.igexin.push.f.b bVar = new com.igexin.push.f.b(this);
        this.qtsService = bVar;
        if (bVar.b == null) {
            com.igexin.c.a.c.a.a("QtsService|mInstance = null", new java.lang.Object[0]);
            return;
        }
        try {
            java.lang.reflect.Method declaredMethod = bVar.a.getDeclaredMethod("onCreate", new java.lang.Class[0]);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(bVar.b, new java.lang.Object[0]);
            com.igexin.c.a.c.a.a("QtsService|callMethod onCreate() success", new java.lang.Object[0]);
        } catch (java.lang.Exception e2) {
            com.igexin.c.a.c.a.a("QtsService|callMethod onCreate() failed：%s", e2.toString());
        }
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        com.igexin.push.f.b bVar = this.qtsService;
        if (bVar.b == null) {
            com.igexin.c.a.c.a.a("QtsService|mInstance = null", new java.lang.Object[0]);
        } else {
            try {
                java.lang.reflect.Method declaredMethod = bVar.a.getDeclaredMethod("onDestroy", new java.lang.Class[0]);
                declaredMethod.setAccessible(true);
                declaredMethod.invoke(bVar.b, new java.lang.Object[0]);
                com.igexin.c.a.c.a.a("QtsService|callMethod onDestroy() success", new java.lang.Object[0]);
            } catch (java.lang.Exception e) {
                com.igexin.c.a.c.a.a("QtsService|callMethod onDestroy() failed：%s", e.toString());
            }
        }
        com.igexin.push.core.ServiceManager serviceManager = com.igexin.push.core.ServiceManager.getInstance();
        com.igexin.c.a.c.a.a("ServiceManager|onDestroy...", new java.lang.Object[0]);
        com.igexin.sdk.IPushCore iPushCore = serviceManager.a;
        if (iPushCore != null) {
            iPushCore.onServiceDestroy();
        }
    }

    @Override // android.app.Service, android.content.ComponentCallbacks
    public void onLowMemory() {
        super.onLowMemory();
        com.igexin.push.core.ServiceManager.getInstance();
        com.igexin.push.core.ServiceManager.a();
    }

    @Override // android.app.Service
    public int onStartCommand(android.content.Intent intent, int i, int i2) {
        super.onStartCommand(intent, i, i2);
        this.qtsService.a(intent, i, i2);
        com.igexin.push.core.ServiceManager.getInstance().a(this, intent, i, i2);
        return 2;
    }
}
