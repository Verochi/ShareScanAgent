package com.amap.api.location;

/* loaded from: classes12.dex */
public class APSService extends android.app.Service {
    com.loc.f a;
    int b = 0;
    boolean c = false;

    private void a(android.content.Context context) {
        try {
            if (this.a == null) {
                this.a = new com.loc.f(context);
            }
            this.a.a();
        } catch (java.lang.Throwable th) {
            com.loc.fv.a(th, "APSService", "onCreate");
        }
        super.onCreate();
    }

    @Override // android.app.Service
    public android.os.IBinder onBind(android.content.Intent intent) {
        try {
            return this.a.a(intent);
        } catch (java.lang.Throwable th) {
            com.loc.fv.a(th, "APSService", "onBind");
            return null;
        }
    }

    @Override // android.app.Service
    public void onCreate() {
        a(this);
    }

    @Override // android.app.Service
    public void onDestroy() {
        try {
            this.a.c();
            if (this.c) {
                stopForeground(true);
            }
        } catch (java.lang.Throwable th) {
            com.loc.fv.a(th, "APSService", "onDestroy");
        }
        super.onDestroy();
    }

    @Override // android.app.Service
    public int onStartCommand(android.content.Intent intent, int i, int i2) {
        int i3;
        com.sensorsdata.analytics.android.sdk.aop.push.PushAutoTrackHelper.onServiceStartCommand(this, intent, i, i2);
        if (intent != null) {
            try {
                int intExtra = intent.getIntExtra("g", 0);
                if (intExtra == 1) {
                    int intExtra2 = intent.getIntExtra("i", 0);
                    android.app.Notification notification = (android.app.Notification) intent.getParcelableExtra("h");
                    if (intExtra2 != 0 && notification != null) {
                        startForeground(intExtra2, notification);
                        this.c = true;
                        this.b++;
                    }
                } else if (intExtra == 2) {
                    if (intent.getBooleanExtra("j", true) && (i3 = this.b) > 0) {
                        this.b = i3 - 1;
                    }
                    if (this.b <= 0) {
                        stopForeground(true);
                        this.c = false;
                    } else {
                        stopForeground(false);
                    }
                }
            } catch (java.lang.Throwable unused) {
            }
        }
        try {
            return this.a.b();
        } catch (java.lang.Throwable th) {
            com.loc.fv.a(th, "APSService", "onStartCommand");
            return super.onStartCommand(intent, i, i2);
        }
    }
}
