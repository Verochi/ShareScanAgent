package org.repackage.a.a.a.a;

/* loaded from: classes26.dex */
public class b implements android.content.ServiceConnection {
    public final /* synthetic */ org.repackage.a.a.a.a.c a;

    public b(org.repackage.a.a.a.a.c cVar) {
        this.a = cVar;
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(android.content.ComponentName componentName, android.os.IBinder iBinder) {
        this.a.a = org.repackage.a.a.a.a.AbstractBinderC0543a.a(iBinder);
        synchronized (this.a.d) {
            this.a.d.notify();
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(android.content.ComponentName componentName) {
        this.a.a = null;
    }
}
