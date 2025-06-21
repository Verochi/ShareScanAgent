package com.sijla.g.a.a;

/* loaded from: classes19.dex */
final class s implements android.content.ServiceConnection {
    private /* synthetic */ com.sijla.g.a.a.r a;

    public s(com.sijla.g.a.a.r rVar) {
        this.a = rVar;
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
