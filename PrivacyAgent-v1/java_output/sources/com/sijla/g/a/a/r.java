package com.sijla.g.a.a;

/* loaded from: classes19.dex */
public final class r {
    private android.content.Context b;
    private java.lang.String c = "com.mdid.msa";
    public final java.util.concurrent.LinkedBlockingQueue<android.os.IBinder> a = new java.util.concurrent.LinkedBlockingQueue<>(1);
    private android.content.ServiceConnection d = new com.sijla.g.a.a.s(this);

    public r(android.content.Context context) {
        this.b = context;
    }

    private int a() {
        try {
            this.b.getPackageManager().getPackageInfo(this.c, 0);
            return 1;
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public final void a(com.sijla.g.a.a.c.a aVar) {
        try {
            this.b.getPackageManager().getPackageInfo(this.c, 0);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
        java.lang.String packageName = this.b.getPackageName();
        if (a() > 0) {
            android.content.Intent intent = new android.content.Intent();
            intent.setClassName(this.c, "com.mdid.msa.service.MsaKlService");
            intent.setAction("com.bun.msa.action.start.service");
            intent.putExtra("com.bun.msa.param.pkgname", packageName);
            try {
                intent.putExtra("com.bun.msa.param.runinset", true);
                this.b.startService(intent);
            } catch (java.lang.Exception e2) {
                e2.printStackTrace();
            }
        }
        android.content.Intent intent2 = new android.content.Intent();
        intent2.setClassName("com.mdid.msa", "com.mdid.msa.service.MsaIdService");
        intent2.setAction("com.bun.msa.action.bindto.service");
        intent2.putExtra("com.bun.msa.param.pkgname", packageName);
        if (this.b.bindService(intent2, this.d, 1)) {
            try {
                try {
                    java.lang.String a = new com.sijla.g.a.b.g.a.C0453a(this.a.take()).a();
                    if (aVar != null) {
                        aVar.a(a);
                    }
                } catch (java.lang.Exception e3) {
                    e3.printStackTrace();
                }
            } finally {
                this.b.unbindService(this.d);
            }
        }
    }
}
