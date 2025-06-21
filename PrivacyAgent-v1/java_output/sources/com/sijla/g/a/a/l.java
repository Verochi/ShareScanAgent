package com.sijla.g.a.a;

/* loaded from: classes19.dex */
final class l implements android.content.ServiceConnection {
    private /* synthetic */ com.sijla.g.a.a.k a;

    public l(com.sijla.g.a.a.k kVar) {
        this.a = kVar;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(android.content.ComponentName componentName, android.os.IBinder iBinder) {
        this.a.a = com.sijla.g.a.b.d.a.a(iBinder);
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(android.content.ComponentName componentName) {
        this.a.a = null;
    }
}
