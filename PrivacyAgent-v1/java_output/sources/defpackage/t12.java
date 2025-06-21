package defpackage;

/* loaded from: classes27.dex */
public final /* synthetic */ class t12 implements android.view.View.OnClickListener {
    public final /* synthetic */ com.moji.liveview_finalversion.data.base.MJSinglePictureFeedDetail n;
    public final /* synthetic */ com.moji.liveview_finalversion.ui.detail.viewholder.PictureFeedDetailRecommendViewHolder t;

    public /* synthetic */ t12(com.moji.liveview_finalversion.data.base.MJSinglePictureFeedDetail mJSinglePictureFeedDetail, com.moji.liveview_finalversion.ui.detail.viewholder.PictureFeedDetailRecommendViewHolder pictureFeedDetailRecommendViewHolder) {
        this.n = mJSinglePictureFeedDetail;
        this.t = pictureFeedDetailRecommendViewHolder;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(android.view.View view) {
        com.moji.liveview_finalversion.ui.detail.viewholder.PictureFeedDetailRecommendViewHolder.a(this.n, this.t, view);
    }
}
