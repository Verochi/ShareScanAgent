package defpackage;

/* loaded from: classes27.dex */
public final /* synthetic */ class fk2 implements android.view.View.OnClickListener {
    public final /* synthetic */ com.moji.liveview_finalversion.ui.detail.viewholder.SinglePictureViewHolder n;
    public final /* synthetic */ com.moji.liveview_finalversion.data.base.MJFeedDetail t;

    public /* synthetic */ fk2(com.moji.liveview_finalversion.ui.detail.viewholder.SinglePictureViewHolder singlePictureViewHolder, com.moji.liveview_finalversion.data.base.MJFeedDetail mJFeedDetail) {
        this.n = singlePictureViewHolder;
        this.t = mJFeedDetail;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(android.view.View view) {
        com.moji.liveview_finalversion.ui.detail.viewholder.SinglePictureViewHolder.b(this.n, this.t, view);
    }
}
