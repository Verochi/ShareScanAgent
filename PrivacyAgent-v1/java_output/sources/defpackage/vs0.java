package defpackage;

/* loaded from: classes.dex */
public final /* synthetic */ class vs0 implements java.lang.Runnable {
    public final /* synthetic */ cn.jzvd.JZMediaAliyun n;
    public final /* synthetic */ boolean t;

    public /* synthetic */ vs0(cn.jzvd.JZMediaAliyun jZMediaAliyun, boolean z) {
        this.n = jZMediaAliyun;
        this.t = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.n.z(this.t);
    }
}
