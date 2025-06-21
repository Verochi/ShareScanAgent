package com.sijla.g.a.a;

/* loaded from: classes19.dex */
public final class e {
    private android.content.Context b;
    public final java.util.concurrent.LinkedBlockingQueue<android.os.IBinder> a = new java.util.concurrent.LinkedBlockingQueue<>(1);
    private android.content.ServiceConnection c = new com.sijla.g.a.a.f(this);

    public e(android.content.Context context) {
        this.b = context;
    }

    public final void a(com.sijla.g.a.a.c.a aVar) {
        try {
            this.b.getPackageManager().getPackageInfo("com.huawei.hwid", 0);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
        android.content.Intent intent = new android.content.Intent("com.uodis.opendevice.OPENIDS_SERVICE");
        intent.setPackage("com.huawei.hwid");
        if (this.b.bindService(intent, this.c, 1)) {
            try {
                try {
                    java.lang.String a = new com.sijla.g.a.b.b.a(this.a.take()).a();
                    if (aVar != null) {
                        aVar.a(a);
                    }
                } catch (java.lang.Exception e2) {
                    e2.printStackTrace();
                    try {
                        this.b.unbindService(this.c);
                    } catch (java.lang.Throwable th) {
                        th.printStackTrace();
                    }
                }
            } finally {
                try {
                    this.b.unbindService(this.c);
                } catch (java.lang.Throwable th2) {
                    th2.printStackTrace();
                }
            }
        }
    }
}
