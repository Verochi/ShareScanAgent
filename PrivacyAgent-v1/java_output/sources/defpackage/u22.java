package defpackage;

/* loaded from: classes27.dex */
public final /* synthetic */ class u22 implements android.view.View.OnClickListener {
    public final /* synthetic */ com.moji.liveview_finalversion.ui.detail.viewholder.PictureTextViewHolder n;
    public final /* synthetic */ com.moji.liveview_finalversion.data.base.MJFeedDetail t;

    public /* synthetic */ u22(com.moji.liveview_finalversion.ui.detail.viewholder.PictureTextViewHolder pictureTextViewHolder, com.moji.liveview_finalversion.data.base.MJFeedDetail mJFeedDetail) {
        this.n = pictureTextViewHolder;
        this.t = mJFeedDetail;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(android.view.View view) {
        com.moji.liveview_finalversion.ui.detail.viewholder.PictureTextViewHolder.f(this.n, this.t, view);
    }
}
