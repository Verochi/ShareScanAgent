package com.umeng.analytics.pro;

/* loaded from: classes19.dex */
public class bb implements com.umeng.analytics.pro.az {
    private static final java.lang.String a = "Coolpad";
    private static final java.lang.String b = "com.coolpad.deviceidsupport";
    private static final java.lang.String c = "com.coolpad.deviceidsupport.DeviceIdService";
    private static com.umeng.analytics.pro.a d;
    private java.util.concurrent.CountDownLatch f;
    private android.content.Context g;
    private java.lang.String e = "";
    private final android.content.ServiceConnection h = new com.umeng.analytics.pro.bb.AnonymousClass1();

    /* renamed from: com.umeng.analytics.pro.bb$1, reason: invalid class name */
    public class AnonymousClass1 implements android.content.ServiceConnection {
        public AnonymousClass1() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(android.content.ComponentName componentName, android.os.IBinder iBinder) {
            try {
                com.umeng.analytics.pro.a unused = com.umeng.analytics.pro.bb.d = com.umeng.analytics.pro.a.b.a(iBinder);
                com.umeng.analytics.pro.bb.this.e = com.umeng.analytics.pro.bb.d.b(com.umeng.analytics.pro.bb.this.g.getPackageName());
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                sb.append("onServiceConnected: oaid = ");
                sb.append(com.umeng.analytics.pro.bb.this.e);
            } catch (android.os.RemoteException | java.lang.NullPointerException e) {
                java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
                sb2.append("onServiceConnected failed e=");
                sb2.append(e.getMessage());
            }
            com.umeng.analytics.pro.bb.this.f.countDown();
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(android.content.ComponentName componentName) {
            com.umeng.analytics.pro.a unused = com.umeng.analytics.pro.bb.d = null;
        }
    }

    private void b(android.content.Context context) {
        try {
            android.content.Intent intent = new android.content.Intent();
            intent.setComponent(new android.content.ComponentName(b, c));
            context.bindService(intent, this.h, 1);
        } catch (java.lang.Throwable th) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("bindService failed. e=");
            sb.append(th.getMessage());
            this.f.countDown();
        }
    }

    private void c(android.content.Context context) {
        try {
            context.unbindService(this.h);
        } catch (java.lang.Throwable th) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("unbindService failed. e=");
            sb.append(th.getMessage());
        }
    }

    @Override // com.umeng.analytics.pro.az
    public java.lang.String a(android.content.Context context) {
        if (context == null) {
            return null;
        }
        this.g = context.getApplicationContext();
        this.f = new java.util.concurrent.CountDownLatch(1);
        try {
            b(context);
            this.f.await(500L, java.util.concurrent.TimeUnit.MILLISECONDS);
            return this.e;
        } catch (java.lang.InterruptedException e) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("getOAID interrupted. e=");
            sb.append(e.getMessage());
            return null;
        } finally {
            c(context);
        }
    }
}
