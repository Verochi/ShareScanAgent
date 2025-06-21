package com.igexin.sdk;

/* loaded from: classes23.dex */
public class GService extends android.app.Service {
    public static final java.lang.String TAG = "com.igexin.sdk.GService";

    @Override // android.app.Service
    public android.os.IBinder onBind(android.content.Intent intent) {
        try {
            com.getui.gtc.base.GtcProvider.setContext(getApplicationContext());
            com.igexin.push.core.ServiceManager.getInstance().a(getApplicationContext(), intent);
            return null;
        } catch (java.lang.Throwable unused) {
            return null;
        }
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        try {
            com.getui.gtc.base.GtcProvider.setContext(getApplicationContext());
        } catch (java.lang.Throwable unused) {
        }
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // android.app.Service
    public int onStartCommand(android.content.Intent intent, int i, int i2) {
        try {
            com.getui.gtc.base.GtcProvider.setContext(getApplicationContext());
            com.igexin.push.core.ServiceManager.getInstance().a(getApplicationContext(), intent);
            return 2;
        } catch (java.lang.Throwable unused) {
            return 2;
        }
    }
}
