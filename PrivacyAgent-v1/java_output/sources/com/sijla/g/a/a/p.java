package com.sijla.g.a.a;

/* loaded from: classes19.dex */
final class p implements android.content.ServiceConnection {
    private /* synthetic */ com.sijla.g.a.a.o a;

    public p(com.sijla.g.a.a.o oVar) {
        this.a = oVar;
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
