package com.sijla.g.a.a;

/* loaded from: classes19.dex */
final class n implements android.content.ServiceConnection {
    private /* synthetic */ com.sijla.g.a.a.m a;

    public n(com.sijla.g.a.a.m mVar) {
        this.a = mVar;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(android.content.ComponentName componentName, android.os.IBinder iBinder) {
        this.a.a = com.sijla.g.a.b.e.a.a(iBinder);
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(android.content.ComponentName componentName) {
        this.a.a = null;
    }
}
