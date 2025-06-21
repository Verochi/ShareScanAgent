package com.sijla.g.a.a;

/* loaded from: classes19.dex */
public final class k {
    com.sijla.g.a.b.d a;
    private android.content.Context b;
    private java.lang.String d;
    private java.lang.String c = "OUID";
    private android.content.ServiceConnection e = new com.sijla.g.a.a.l(this);

    public k(android.content.Context context) {
        this.b = context;
    }

    public final java.lang.String a(com.sijla.g.a.a.c.a aVar) {
        java.lang.String str = null;
        if (android.os.Looper.myLooper() == android.os.Looper.getMainLooper()) {
            return null;
        }
        try {
            android.content.Intent intent = new android.content.Intent();
            intent.setComponent(new android.content.ComponentName("com.heytap.openid", "com.heytap.openid.IdentifyService"));
            intent.setAction("action.com.heytap.openid.OPEN_ID_SERVICE");
            if (this.b.bindService(intent, this.e, 1)) {
                android.os.SystemClock.sleep(3000L);
                if (this.a != null) {
                    java.lang.String packageName = this.b.getPackageName();
                    if (this.d == null) {
                        this.d = com.sijla.c.a.a(this.b);
                    }
                    str = ((com.sijla.g.a.b.d.a.C0451a) this.a).a(packageName, this.d, "OUID");
                    if (aVar != null) {
                        aVar.a(str);
                    }
                }
                this.b.unbindService(this.e);
            }
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
        return str;
    }
}
