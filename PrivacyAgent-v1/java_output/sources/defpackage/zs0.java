package defpackage;

/* loaded from: classes.dex */
public final /* synthetic */ class zs0 implements java.lang.Runnable {
    public final /* synthetic */ cn.jzvd.JZMediaAliyun n;
    public final /* synthetic */ long t;

    public /* synthetic */ zs0(cn.jzvd.JZMediaAliyun jZMediaAliyun, long j) {
        this.n = jZMediaAliyun;
        this.t = j;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.n.q(this.t);
    }
}
