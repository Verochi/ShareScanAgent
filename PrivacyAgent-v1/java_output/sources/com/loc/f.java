package com.loc;

/* loaded from: classes23.dex */
public final class f {
    com.loc.e a;
    android.content.Context b;
    android.os.Messenger c = null;

    public f(android.content.Context context) {
        this.a = null;
        this.b = null;
        this.b = context.getApplicationContext();
        this.a = new com.loc.e(this.b);
    }

    public final android.os.IBinder a(android.content.Intent intent) {
        this.a.b(intent);
        this.a.a(intent);
        android.os.Messenger messenger = new android.os.Messenger(this.a.b());
        this.c = messenger;
        return messenger.getBinder();
    }

    public final void a() {
        try {
            com.loc.e.e();
            this.a.j = com.loc.gd.b();
            this.a.k = com.loc.gd.a();
            this.a.a();
        } catch (java.lang.Throwable th) {
            com.loc.fv.a(th, "ApsServiceCore", "onCreate");
        }
    }

    public final int b() {
        com.loc.e eVar = this.a;
        return (eVar == null || eVar.n.isSelfStartServiceEnable()) ? 3 : 2;
    }

    public final void c() {
        try {
            com.loc.e eVar = this.a;
            if (eVar != null) {
                eVar.b().sendEmptyMessage(11);
            }
        } catch (java.lang.Throwable th) {
            com.loc.fv.a(th, "ApsServiceCore", "onDestroy");
        }
    }
}
