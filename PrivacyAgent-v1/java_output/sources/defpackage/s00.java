package defpackage;

/* loaded from: classes8.dex */
public final /* synthetic */ class s00 implements java.lang.Runnable {
    public final /* synthetic */ com.moji.newliveview.detail.adapter.DetailPicturePresenter.DetailPictureViewHolder n;
    public final /* synthetic */ com.moji.newliveview.detail.adapter.DetailPicturePresenter t;

    public /* synthetic */ s00(com.moji.newliveview.detail.adapter.DetailPicturePresenter.DetailPictureViewHolder detailPictureViewHolder, com.moji.newliveview.detail.adapter.DetailPicturePresenter detailPicturePresenter) {
        this.n = detailPictureViewHolder;
        this.t = detailPicturePresenter;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.moji.newliveview.detail.adapter.DetailPicturePresenter.DetailPictureViewHolder.showCachePicture.1.b(this.n, this.t);
    }
}
