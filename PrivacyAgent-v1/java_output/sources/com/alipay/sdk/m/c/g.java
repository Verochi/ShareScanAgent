package com.alipay.sdk.m.c;

/* loaded from: classes.dex */
public class g implements com.alipay.sdk.m.b.b {

    public static final class b implements android.content.ServiceConnection {
        public boolean a;
        public final java.util.concurrent.LinkedBlockingQueue<android.os.IBinder> b;

        public b() {
            this.a = false;
            this.b = new java.util.concurrent.LinkedBlockingQueue<>();
        }

        public /* synthetic */ b(com.alipay.sdk.m.c.g.a aVar) {
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

    @Override // com.alipay.sdk.m.b.b
    public java.lang.String a(android.content.Context context) {
        com.alipay.sdk.m.c.g.b bVar = new com.alipay.sdk.m.c.g.b(null);
        android.content.Intent intent = new android.content.Intent();
        intent.setClassName("com.samsung.android.deviceidservice", "com.samsung.android.deviceidservice.DeviceIdService");
        if (context.bindService(intent, bVar, 1)) {
            try {
                return com.alipay.sdk.m.k0.a.AbstractBinderC0035a.a(bVar.a()).a();
            } catch (java.lang.Exception unused) {
            } finally {
                context.unbindService(bVar);
            }
        }
        return null;
    }
}
