package defpackage;

/* loaded from: classes.dex */
public final /* synthetic */ class gt0 implements java.lang.Runnable {
    public final /* synthetic */ cn.jzvd.JZMediaAliyun n;
    public final /* synthetic */ com.aliyun.player.bean.ErrorInfo t;

    public /* synthetic */ gt0(cn.jzvd.JZMediaAliyun jZMediaAliyun, com.aliyun.player.bean.ErrorInfo errorInfo) {
        this.n = jZMediaAliyun;
        this.t = errorInfo;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.n.p(this.t);
    }
}
