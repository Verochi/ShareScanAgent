package defpackage;

/* loaded from: classes27.dex */
public final /* synthetic */ class r22 implements android.view.View.OnClickListener {
    public final /* synthetic */ java.util.ArrayList n;
    public final /* synthetic */ com.moji.liveview_finalversion.ui.detail.viewholder.PictureTextViewHolder t;
    public final /* synthetic */ com.moji.liveview_finalversion.data.base.MJPictureTextFeedDetail u;
    public final /* synthetic */ int v;

    public /* synthetic */ r22(java.util.ArrayList arrayList, com.moji.liveview_finalversion.ui.detail.viewholder.PictureTextViewHolder pictureTextViewHolder, com.moji.liveview_finalversion.data.base.MJPictureTextFeedDetail mJPictureTextFeedDetail, int i) {
        this.n = arrayList;
        this.t = pictureTextViewHolder;
        this.u = mJPictureTextFeedDetail;
        this.v = i;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(android.view.View view) {
        com.moji.liveview_finalversion.ui.detail.viewholder.PictureTextViewHolder.e(this.n, this.t, this.u, this.v, view);
    }
}
