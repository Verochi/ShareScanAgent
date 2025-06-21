package defpackage;

/* loaded from: classes23.dex */
public final /* synthetic */ class ha2 implements java.lang.Runnable {
    public final /* synthetic */ okhttp3.internal.connection.RealConnectionPool n;

    public /* synthetic */ ha2(okhttp3.internal.connection.RealConnectionPool realConnectionPool) {
        this.n = realConnectionPool;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.n.d();
    }
}
