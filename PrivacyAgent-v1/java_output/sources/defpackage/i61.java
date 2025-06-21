package defpackage;

/* loaded from: classes14.dex */
public final /* synthetic */ class i61 implements java.lang.Runnable {
    public final /* synthetic */ com.moji.share.MJThirdShareManager n;
    public final /* synthetic */ com.moji.share.listener.ShareListener t;
    public final /* synthetic */ com.moji.share.entity.ShareChannelType u;

    public /* synthetic */ i61(com.moji.share.MJThirdShareManager mJThirdShareManager, com.moji.share.listener.ShareListener shareListener, com.moji.share.entity.ShareChannelType shareChannelType) {
        this.n = mJThirdShareManager;
        this.t = shareListener;
        this.u = shareChannelType;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.moji.share.MJThirdShareManager.b(this.n, this.t, this.u);
    }
}
