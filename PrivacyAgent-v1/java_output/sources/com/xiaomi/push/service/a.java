package com.xiaomi.push.service;

/* loaded from: classes19.dex */
public final class a {
    private static com.xiaomi.push.service.a a;
    private static java.lang.String e;
    private static java.lang.String f = com.xiaomi.push.fy.a() + com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER;
    private static long g = 0;
    private android.content.Context b;
    private boolean d;
    private android.os.Messenger j;
    private android.os.Messenger c = null;
    private java.util.List<android.os.Message> h = new java.util.ArrayList();
    private boolean i = false;

    private a(android.content.Context context) {
        this.d = false;
        this.b = context.getApplicationContext();
        if (a()) {
            com.xiaomi.channel.commonutils.logger.b.c("use miui push service");
            this.d = true;
        }
    }

    public static com.xiaomi.push.service.a a(android.content.Context context) {
        if (a == null) {
            a = new com.xiaomi.push.service.a(context);
        }
        return a;
    }

    private boolean a() {
        if (com.xiaomi.push.f.f) {
            return false;
        }
        try {
            android.content.pm.PackageInfo packageInfo = this.b.getPackageManager().getPackageInfo("com.xiaomi.xmsf", 4);
            if (packageInfo == null) {
                return false;
            }
            return packageInfo.versionCode >= 104;
        } catch (java.lang.Exception unused) {
            return false;
        }
    }

    public static /* synthetic */ boolean a(com.xiaomi.push.service.a aVar) {
        aVar.i = false;
        return false;
    }

    private synchronized void b(android.content.Intent intent) {
        if (this.i) {
            android.os.Message c = c(intent);
            if (this.h.size() >= 50) {
                this.h.remove(0);
            }
            this.h.add(c);
            return;
        }
        if (this.j == null) {
            this.b.bindService(intent, new com.xiaomi.push.service.ax(this), 1);
            this.i = true;
            this.h.clear();
            this.h.add(c(intent));
            return;
        }
        try {
            this.j.send(c(intent));
        } catch (android.os.RemoteException unused) {
            this.j = null;
            this.i = false;
        }
    }

    private static android.os.Message c(android.content.Intent intent) {
        android.os.Message obtain = android.os.Message.obtain();
        obtain.what = 17;
        obtain.obj = intent;
        return obtain;
    }

    public final boolean a(android.content.Intent intent) {
        try {
            if (com.xiaomi.push.iu.a() || android.os.Build.VERSION.SDK_INT < 26) {
                this.b.startService(intent);
                return true;
            }
            b(intent);
            return true;
        } catch (java.lang.Exception e2) {
            com.xiaomi.channel.commonutils.logger.b.a(e2);
            return false;
        }
    }
}
