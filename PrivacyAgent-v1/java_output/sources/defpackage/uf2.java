package defpackage;

/* loaded from: classes27.dex */
public final /* synthetic */ class uf2 implements java.lang.Runnable {
    public final /* synthetic */ java.lang.String n;
    public final /* synthetic */ com.moji.share.MJThirdShareManager t;

    public /* synthetic */ uf2(java.lang.String str, com.moji.share.MJThirdShareManager mJThirdShareManager) {
        this.n = str;
        this.t = mJThirdShareManager;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.moji.liveview_finalversion.ui.detail.ShareHelper.c(this.n, this.t);
    }
}
