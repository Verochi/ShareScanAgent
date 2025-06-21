package com.anythink.china.a.a;

/* loaded from: classes12.dex */
public final class o {
    public final java.util.concurrent.LinkedBlockingQueue<android.os.IBinder> a = new java.util.concurrent.LinkedBlockingQueue<>(1);
    android.content.ServiceConnection b = new com.anythink.china.a.a.o.AnonymousClass1();
    private android.content.Context c;

    /* renamed from: com.anythink.china.a.a.o$1, reason: invalid class name */
    public class AnonymousClass1 implements android.content.ServiceConnection {
        public AnonymousClass1() {
        }

        @Override // android.content.ServiceConnection
        public final void onServiceConnected(android.content.ComponentName componentName, android.os.IBinder iBinder) {
            try {
                com.anythink.china.a.a.o.this.a.put(iBinder);
            } catch (java.lang.Exception e) {
                e.printStackTrace();
            }
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(android.content.ComponentName componentName) {
        }
    }

    public o(android.content.Context context) {
        this.c = context;
    }

    public final void a(com.anythink.china.a.a aVar) {
        try {
            this.c.getPackageManager().getPackageInfo("com.samsung.android.deviceidservice", 0);
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
        android.content.Intent intent = new android.content.Intent();
        intent.setClassName("com.samsung.android.deviceidservice", "com.samsung.android.deviceidservice.DeviceIdService");
        if (!this.c.bindService(intent, this.b, 1)) {
            aVar.a();
            return;
        }
        try {
            aVar.a(new com.anythink.china.a.a.n.a(this.a.take()).a(), false);
        } catch (java.lang.Throwable th2) {
            th2.printStackTrace();
            th2.getMessage();
            aVar.a();
        }
    }
}
