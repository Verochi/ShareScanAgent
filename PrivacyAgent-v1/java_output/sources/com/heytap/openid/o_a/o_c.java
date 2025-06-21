package com.heytap.openid.o_a;

/* loaded from: classes22.dex */
public class o_c implements android.content.ServiceConnection {
    public final /* synthetic */ com.heytap.openid.o_a.o_d a;

    public o_c(com.heytap.openid.o_a.o_d o_dVar) {
        this.a = o_dVar;
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(android.content.ComponentName componentName, android.os.IBinder iBinder) {
        com.heytap.openid.o_a.o_b.a("OpenIDHelper", "onServiceConnected");
        this.a.a = com.heytap.openid.o_a.AbstractBinderC0358o_a.a(iBinder);
        synchronized (this.a.d) {
            com.heytap.openid.o_a.o_b.a("OpenIDHelper", "UNLOCK");
            this.a.d.notify();
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(android.content.ComponentName componentName) {
        com.heytap.openid.o_a.o_b.a("OpenIDHelper", "onServiceDisconnected");
        this.a.a = null;
    }
}
