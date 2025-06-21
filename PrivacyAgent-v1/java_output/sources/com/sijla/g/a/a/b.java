package com.sijla.g.a.a;

/* loaded from: classes19.dex */
final class b implements android.content.ServiceConnection {
    private /* synthetic */ com.sijla.g.a.a.a a;

    public b(com.sijla.g.a.a.a aVar) {
        this.a = aVar;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(android.content.ComponentName componentName, android.os.IBinder iBinder) {
        try {
            this.a.a.put(iBinder);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(android.content.ComponentName componentName) {
    }
}
