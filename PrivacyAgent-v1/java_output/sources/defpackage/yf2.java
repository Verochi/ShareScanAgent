package defpackage;

/* loaded from: classes27.dex */
public final /* synthetic */ class yf2 implements java.lang.Runnable {
    public final /* synthetic */ android.app.Activity n;
    public final /* synthetic */ com.moji.entity.Image t;
    public final /* synthetic */ java.lang.String u;
    public final /* synthetic */ com.moji.liveview_finalversion.data.base.MJSinglePictureFeedDetail.SinglePicture v;
    public final /* synthetic */ com.moji.liveview_finalversion.data.base.MJSinglePictureFeedDetail w;
    public final /* synthetic */ java.lang.String x;
    public final /* synthetic */ com.moji.share.MJThirdShareManager y;
    public final /* synthetic */ java.lang.String z;

    public /* synthetic */ yf2(android.app.Activity activity, com.moji.entity.Image image, java.lang.String str, com.moji.liveview_finalversion.data.base.MJSinglePictureFeedDetail.SinglePicture singlePicture, com.moji.liveview_finalversion.data.base.MJSinglePictureFeedDetail mJSinglePictureFeedDetail, java.lang.String str2, com.moji.share.MJThirdShareManager mJThirdShareManager, java.lang.String str3) {
        this.n = activity;
        this.t = image;
        this.u = str;
        this.v = singlePicture;
        this.w = mJSinglePictureFeedDetail;
        this.x = str2;
        this.y = mJThirdShareManager;
        this.z = str3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.moji.liveview_finalversion.ui.detail.ShareHelper.b(this.n, this.t, this.u, this.v, this.w, this.x, this.y, this.z);
    }
}
