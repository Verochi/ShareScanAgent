package com.sijla.g.a.a;

/* loaded from: classes19.dex */
final class f implements android.content.ServiceConnection {
    private /* synthetic */ com.sijla.g.a.a.e a;

    public f(com.sijla.g.a.a.e eVar) {
        this.a = eVar;
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
