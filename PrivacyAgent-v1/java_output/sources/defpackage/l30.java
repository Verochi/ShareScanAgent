package defpackage;

/* loaded from: classes27.dex */
public final /* synthetic */ class l30 implements android.view.View.OnClickListener {
    public final /* synthetic */ com.moji.FooterView n;
    public final /* synthetic */ com.moji.liveview_finalversion.ui.discover.DiscoverFeedListAdapter t;

    public /* synthetic */ l30(com.moji.FooterView footerView, com.moji.liveview_finalversion.ui.discover.DiscoverFeedListAdapter discoverFeedListAdapter) {
        this.n = footerView;
        this.t = discoverFeedListAdapter;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(android.view.View view) {
        com.moji.liveview_finalversion.ui.discover.DiscoverFeedListAdapter.FooterViewHolder.a(this.n, this.t, view);
    }
}
