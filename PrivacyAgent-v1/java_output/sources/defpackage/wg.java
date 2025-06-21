package defpackage;

/* loaded from: classes27.dex */
public final /* synthetic */ class wg implements android.view.View.OnClickListener {
    public final /* synthetic */ com.moji.multiplestatuslayout.MJMultipleStatusLayout n;
    public final /* synthetic */ com.moji.liveview_finalversion.ui.detail.BaseFeedDetailFragment t;

    public /* synthetic */ wg(com.moji.multiplestatuslayout.MJMultipleStatusLayout mJMultipleStatusLayout, com.moji.liveview_finalversion.ui.detail.BaseFeedDetailFragment baseFeedDetailFragment) {
        this.n = mJMultipleStatusLayout;
        this.t = baseFeedDetailFragment;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(android.view.View view) {
        com.moji.liveview_finalversion.ui.detail.BaseFeedDetailFragment.a(this.n, this.t, view);
    }
}
