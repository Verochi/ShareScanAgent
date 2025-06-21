package defpackage;

/* loaded from: classes14.dex */
public final /* synthetic */ class h61 implements java.lang.Runnable {
    public final /* synthetic */ com.moji.share.MJThirdShareManager n;
    public final /* synthetic */ android.app.Activity t;
    public final /* synthetic */ com.moji.share.entity.ShareChannelType u;
    public final /* synthetic */ com.moji.share.entity.ShareRealContent v;
    public final /* synthetic */ com.moji.share.listener.ShareListener w;

    public /* synthetic */ h61(com.moji.share.MJThirdShareManager mJThirdShareManager, android.app.Activity activity, com.moji.share.entity.ShareChannelType shareChannelType, com.moji.share.entity.ShareRealContent shareRealContent, com.moji.share.listener.ShareListener shareListener) {
        this.n = mJThirdShareManager;
        this.t = activity;
        this.u = shareChannelType;
        this.v = shareRealContent;
        this.w = shareListener;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.moji.share.MJThirdShareManager.d(this.n, this.t, this.u, this.v, this.w);
    }
}
