package defpackage;

/* loaded from: classes27.dex */
public final /* synthetic */ class h30 implements android.view.View.OnClickListener {
    public final /* synthetic */ com.moji.liveview_finalversion.ui.discover.DiscoverFeedListAdapter n;
    public final /* synthetic */ int t;
    public final /* synthetic */ com.moji.liveview_finalversion.data.base.FeedList.LiveViewFeed u;

    public /* synthetic */ h30(com.moji.liveview_finalversion.ui.discover.DiscoverFeedListAdapter discoverFeedListAdapter, int i, com.moji.liveview_finalversion.data.base.FeedList.LiveViewFeed liveViewFeed) {
        this.n = discoverFeedListAdapter;
        this.t = i;
        this.u = liveViewFeed;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(android.view.View view) {
        com.moji.liveview_finalversion.ui.discover.DiscoverFeedListAdapter.FeedItemViewHolder.a(this.n, this.t, this.u, view);
    }
}
