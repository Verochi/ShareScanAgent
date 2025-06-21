package com.vivo.push.sdk.service;

/* loaded from: classes19.dex */
public class CommandService extends android.app.Service {
    public boolean a(java.lang.String str) {
        return "com.vivo.pushservice.action.RECEIVE".equals(str);
    }

    @Override // android.app.Service
    public android.os.IBinder onBind(android.content.Intent intent) {
        com.vivo.push.util.p.c("CommandService", "onBind initSuc: ");
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        com.vivo.push.util.p.c("CommandService", getClass().getSimpleName() + " -- oncreate " + getPackageName());
        super.onCreate();
        com.vivo.push.sdk.a.a().a(com.vivo.push.util.ContextDelegate.getContext(getApplicationContext()));
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // android.app.Service
    public int onStartCommand(android.content.Intent intent, int i, int i2) {
        com.vivo.push.util.p.c("CommandService", getClass().getSimpleName() + " -- onStartCommand " + getPackageName());
        if (intent == null) {
            stopSelf();
            return 2;
        }
        if (a(intent.getAction())) {
            try {
                com.vivo.push.sdk.a.a().a(getClass().getName());
                com.vivo.push.sdk.a.a().a(intent);
            } catch (java.lang.Exception e) {
                com.vivo.push.util.p.a("CommandService", "onStartCommand -- error", e);
            }
            stopSelf();
            return 2;
        }
        com.vivo.push.util.p.a("CommandService", getPackageName() + " receive invalid action " + intent.getAction());
        stopSelf();
        return 2;
    }

    @Override // android.app.Service
    public boolean onUnbind(android.content.Intent intent) {
        return super.onUnbind(intent);
    }
}
