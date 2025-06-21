package com.sijla.g.a.a;

/* loaded from: classes19.dex */
final class h implements android.content.ServiceConnection {
    private /* synthetic */ com.sijla.g.a.a.g a;

    public h(com.sijla.g.a.a.g gVar) {
        this.a = gVar;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(android.content.ComponentName componentName, android.os.IBinder iBinder) {
        this.a.a = new com.sijla.g.a.b.c.a.C0450a(iBinder);
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(android.content.ComponentName componentName) {
    }
}
