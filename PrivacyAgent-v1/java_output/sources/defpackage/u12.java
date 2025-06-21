package defpackage;

/* loaded from: classes27.dex */
public final /* synthetic */ class u12 implements android.view.View.OnClickListener {
    public final /* synthetic */ com.moji.liveview_finalversion.ui.detail.viewholder.PictureFeedDetailRecommendViewHolder n;
    public final /* synthetic */ com.moji.liveview_finalversion.data.base.MJSinglePictureFeedDetail t;

    public /* synthetic */ u12(com.moji.liveview_finalversion.ui.detail.viewholder.PictureFeedDetailRecommendViewHolder pictureFeedDetailRecommendViewHolder, com.moji.liveview_finalversion.data.base.MJSinglePictureFeedDetail mJSinglePictureFeedDetail) {
        this.n = pictureFeedDetailRecommendViewHolder;
        this.t = mJSinglePictureFeedDetail;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(android.view.View view) {
        com.moji.liveview_finalversion.ui.detail.viewholder.PictureFeedDetailRecommendViewHolder.b(this.n, this.t, view);
    }
}
