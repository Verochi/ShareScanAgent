package defpackage;

/* loaded from: classes8.dex */
public final /* synthetic */ class p12 implements java.lang.Runnable {
    public final /* synthetic */ com.moji.newliveview.detail.PictureDetailViewModel n;
    public final /* synthetic */ com.moji.http.snsforum.entity.PictureDetailResult t;

    public /* synthetic */ p12(com.moji.newliveview.detail.PictureDetailViewModel pictureDetailViewModel, com.moji.http.snsforum.entity.PictureDetailResult pictureDetailResult) {
        this.n = pictureDetailViewModel;
        this.t = pictureDetailResult;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.moji.newliveview.detail.PictureDetailViewModel.loadArticleInfo.1.a(this.n, this.t);
    }
}
