package defpackage;

/* loaded from: classes14.dex */
public final /* synthetic */ class f61 implements java.lang.Runnable {
    public final /* synthetic */ com.moji.share.MJThirdShareManager n;
    public final /* synthetic */ com.moji.share.entity.ShareFromType t;
    public final /* synthetic */ com.moji.share.entity.ShareContentConfig u;
    public final /* synthetic */ boolean v;
    public final /* synthetic */ android.view.View w;

    public /* synthetic */ f61(com.moji.share.MJThirdShareManager mJThirdShareManager, com.moji.share.entity.ShareFromType shareFromType, com.moji.share.entity.ShareContentConfig shareContentConfig, boolean z, android.view.View view) {
        this.n = mJThirdShareManager;
        this.t = shareFromType;
        this.u = shareContentConfig;
        this.v = z;
        this.w = view;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.moji.share.MJThirdShareManager.c(this.n, this.t, this.u, this.v, this.w);
    }
}
