package defpackage;

/* loaded from: classes10.dex */
public final /* synthetic */ class ga0 implements java.lang.Runnable {
    public final /* synthetic */ com.moji.statistics.EventSession n;

    public /* synthetic */ ga0(com.moji.statistics.EventSession eventSession) {
        this.n = eventSession;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.moji.statistics.EventSession.a(this.n);
    }
}
