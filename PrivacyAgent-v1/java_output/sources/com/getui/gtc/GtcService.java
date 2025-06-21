package com.getui.gtc;

@java.lang.Deprecated
/* loaded from: classes22.dex */
public class GtcService extends android.app.Service {

    /* renamed from: com.getui.gtc.GtcService$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {
        final /* synthetic */ android.content.Intent a;

        public AnonymousClass1(android.content.Intent intent) {
            this.a = intent;
        }

        @Override // java.lang.Runnable
        public final void run() {
            android.content.Context applicationContext = com.getui.gtc.GtcService.this.getApplicationContext();
            android.content.Intent intent = this.a;
            if (intent == null || !intent.hasExtra("10010")) {
                return;
            }
            java.lang.String str = new java.lang.String(android.util.Base64.decode(intent.getByteArrayExtra("10010"), 0));
            int b = com.getui.gtc.b.b.b(str);
            com.getui.gtc.api.GtcManager.getInstance().init(applicationContext, new com.getui.gtc.b.b.AnonymousClass1(applicationContext, com.getui.gtc.b.b.a(str), b, com.getui.gtc.b.b.c(str)));
        }
    }

    @Override // android.app.Service
    public android.os.IBinder onBind(android.content.Intent intent) {
        com.getui.gtc.h.c.a.a("GtcService onBind");
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        com.getui.gtc.h.c.a.a("GtcService onCreated");
        super.onCreate();
    }

    @Override // android.app.Service
    public void onDestroy() {
        com.getui.gtc.h.c.a.a("GtcService onDestroy");
        super.onDestroy();
    }

    @Override // android.app.Service
    public int onStartCommand(android.content.Intent intent, int i, int i2) {
        try {
            com.getui.gtc.base.util.ScheduleQueue.getInstance().addSchedule(new com.getui.gtc.GtcService.AnonymousClass1(intent));
            return 2;
        } catch (java.lang.Throwable th) {
            com.getui.gtc.h.c.a.b(th);
            return 2;
        }
    }
}
