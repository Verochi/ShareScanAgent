package defpackage;

/* loaded from: classes.dex */
public final /* synthetic */ class ft0 implements java.lang.Runnable {
    public final /* synthetic */ cn.jzvd.JZMediaAliyun n;
    public final /* synthetic */ int t;

    public /* synthetic */ ft0(cn.jzvd.JZMediaAliyun jZMediaAliyun, int i) {
        this.n = jZMediaAliyun;
        this.t = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.n.w(this.t);
    }
}
