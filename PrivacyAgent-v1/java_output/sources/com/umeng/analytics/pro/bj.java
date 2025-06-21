package com.umeng.analytics.pro;

/* loaded from: classes19.dex */
public class bj implements com.umeng.analytics.pro.az {

    public static final class a implements android.content.ServiceConnection {
        boolean a;
        private final java.util.concurrent.LinkedBlockingQueue<android.os.IBinder> b;

        private a() {
            this.a = false;
            this.b = new java.util.concurrent.LinkedBlockingQueue<>();
        }

        public /* synthetic */ a(com.umeng.analytics.pro.bj.AnonymousClass1 anonymousClass1) {
            this();
        }

        public android.os.IBinder a() throws java.lang.InterruptedException {
            if (this.a) {
                throw new java.lang.IllegalStateException();
            }
            this.a = true;
            return this.b.poll(5L, java.util.concurrent.TimeUnit.SECONDS);
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(android.content.ComponentName componentName, android.os.IBinder iBinder) {
            try {
                this.b.put(iBinder);
            } catch (java.lang.InterruptedException unused) {
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(android.content.ComponentName componentName) {
        }
    }

    @Override // com.umeng.analytics.pro.az
    public java.lang.String a(android.content.Context context) {
        com.umeng.analytics.pro.bj.a aVar = new com.umeng.analytics.pro.bj.a(null);
        android.content.Intent intent = new android.content.Intent();
        intent.setClassName("com.samsung.android.deviceidservice", "com.samsung.android.deviceidservice.DeviceIdService");
        if (context.bindService(intent, aVar, 1)) {
            try {
                return com.umeng.analytics.pro.d.b.a(aVar.a()).a();
            } catch (java.lang.Exception unused) {
            } finally {
                context.unbindService(aVar);
            }
        }
        return null;
    }
}
