package defpackage;

/* loaded from: classes27.dex */
public final /* synthetic */ class s12 implements android.view.View.OnClickListener {
    public final /* synthetic */ com.moji.liveview_finalversion.ui.detail.viewholder.PictureFeedDetailRecommendViewHolder n;
    public final /* synthetic */ com.moji.http.snsforum.entity.PictureDetailCityArea t;

    public /* synthetic */ s12(com.moji.liveview_finalversion.ui.detail.viewholder.PictureFeedDetailRecommendViewHolder pictureFeedDetailRecommendViewHolder, com.moji.http.snsforum.entity.PictureDetailCityArea pictureDetailCityArea) {
        this.n = pictureFeedDetailRecommendViewHolder;
        this.t = pictureDetailCityArea;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(android.view.View view) {
        com.moji.liveview_finalversion.ui.detail.viewholder.PictureFeedDetailRecommendViewHolder.e(this.n, this.t, view);
    }
}
