package defpackage;

/* loaded from: classes8.dex */
public final /* synthetic */ class q12 implements java.lang.Runnable {
    public final /* synthetic */ com.moji.newliveview.detail.PictureDetailViewModel n;
    public final /* synthetic */ com.moji.http.snsforum.entity.PictureDetailResult t;

    public /* synthetic */ q12(com.moji.newliveview.detail.PictureDetailViewModel pictureDetailViewModel, com.moji.http.snsforum.entity.PictureDetailResult pictureDetailResult) {
        this.n = pictureDetailViewModel;
        this.t = pictureDetailResult;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.moji.newliveview.detail.PictureDetailViewModel.loadPictureInfo.1.a(this.n, this.t);
    }
}
