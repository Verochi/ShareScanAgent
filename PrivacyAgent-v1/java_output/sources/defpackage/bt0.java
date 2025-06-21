package defpackage;

/* loaded from: classes.dex */
public final /* synthetic */ class bt0 implements java.lang.Runnable {
    public final /* synthetic */ cn.jzvd.JZMediaAliyun n;
    public final /* synthetic */ com.aliyun.player.bean.InfoBean t;

    public /* synthetic */ bt0(cn.jzvd.JZMediaAliyun jZMediaAliyun, com.aliyun.player.bean.InfoBean infoBean) {
        this.n = jZMediaAliyun;
        this.t = infoBean;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.n.s(this.t);
    }
}
