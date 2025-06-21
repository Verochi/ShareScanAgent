package com.anythink.china.a.a;

/* loaded from: classes12.dex */
public final class b {
    public final java.util.concurrent.LinkedBlockingQueue<android.os.IBinder> a = new java.util.concurrent.LinkedBlockingQueue<>(1);
    android.content.ServiceConnection b = new com.anythink.china.a.a.b.AnonymousClass1();
    private android.content.Context c;

    /* renamed from: com.anythink.china.a.a.b$1, reason: invalid class name */
    public class AnonymousClass1 implements android.content.ServiceConnection {
        public AnonymousClass1() {
        }

        @Override // android.content.ServiceConnection
        public final void onServiceConnected(android.content.ComponentName componentName, android.os.IBinder iBinder) {
            try {
                com.anythink.china.a.a.b.this.a.put(iBinder);
            } catch (java.lang.Throwable th) {
                th.printStackTrace();
            }
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(android.content.ComponentName componentName) {
        }
    }

    public b(android.content.Context context) {
        this.c = context;
    }

    public final void a(com.anythink.china.a.a aVar) {
        try {
            this.c.getPackageManager().getPackageInfo("com.asus.msa.SupplementaryDID", 0);
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
        android.content.Intent intent = new android.content.Intent();
        intent.setAction("com.asus.msa.action.ACCESS_DID");
        intent.setComponent(new android.content.ComponentName("com.asus.msa.SupplementaryDID", "com.asus.msa.SupplementaryDID.SupplementaryDIDService"));
        if (!this.c.bindService(intent, this.b, 1)) {
            aVar.a();
            return;
        }
        try {
            aVar.a(new com.anythink.china.a.a.a(this.a.take()).a(), false);
        } catch (java.lang.Exception e) {
            e.getMessage();
            aVar.a();
        } catch (java.lang.Throwable th2) {
            th2.getMessage();
            aVar.a();
        }
    }
}
