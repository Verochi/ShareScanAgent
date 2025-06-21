package com.sijla.g.a.a;

/* loaded from: classes19.dex */
public final class a {
    private android.content.Context b;
    public final java.util.concurrent.LinkedBlockingQueue<android.os.IBinder> a = new java.util.concurrent.LinkedBlockingQueue<>(1);
    private android.content.ServiceConnection c = new com.sijla.g.a.a.b(this);

    public a(android.content.Context context) {
        this.b = context;
    }

    public final void a(com.sijla.g.a.a.c.a aVar) {
        try {
            this.b.getPackageManager().getPackageInfo("com.asus.msa.SupplementaryDID", 0);
            android.content.Intent intent = new android.content.Intent();
            intent.setAction("com.asus.msa.action.ACCESS_DID");
            intent.setComponent(new android.content.ComponentName("com.asus.msa.SupplementaryDID", "com.asus.msa.SupplementaryDID.SupplementaryDIDService"));
            if (this.b.bindService(intent, this.c, 1)) {
                try {
                    java.lang.String a = new com.sijla.g.a.b.a.C0449a(this.a.take()).a();
                    if (aVar != null) {
                        aVar.a(a);
                    }
                    this.b.unbindService(this.c);
                } catch (java.lang.Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (java.lang.Exception e2) {
            e2.printStackTrace();
        }
    }
}
