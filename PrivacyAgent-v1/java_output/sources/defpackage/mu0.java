package defpackage;

/* loaded from: classes.dex */
public final /* synthetic */ class mu0 implements java.lang.Runnable {
    public final /* synthetic */ cn.jzvd.Jzvd.ProgressTimerTask n;

    public /* synthetic */ mu0(cn.jzvd.Jzvd.ProgressTimerTask progressTimerTask) {
        this.n = progressTimerTask;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.n.b();
    }
}
