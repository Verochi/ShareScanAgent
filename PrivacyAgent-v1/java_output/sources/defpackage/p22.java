package defpackage;

/* loaded from: classes27.dex */
public final /* synthetic */ class p22 implements android.view.View.OnClickListener {
    public final /* synthetic */ com.moji.liveview_finalversion.ui.detail.viewholder.PictureTextViewHolder n;
    public final /* synthetic */ com.moji.liveview_finalversion.data.operational_activities.OperationalActInfo t;

    public /* synthetic */ p22(com.moji.liveview_finalversion.ui.detail.viewholder.PictureTextViewHolder pictureTextViewHolder, com.moji.liveview_finalversion.data.operational_activities.OperationalActInfo operationalActInfo) {
        this.n = pictureTextViewHolder;
        this.t = operationalActInfo;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(android.view.View view) {
        com.moji.liveview_finalversion.ui.detail.viewholder.PictureTextViewHolder.c(this.n, this.t, view);
    }
}
