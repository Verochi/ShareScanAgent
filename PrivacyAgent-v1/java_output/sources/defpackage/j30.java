package defpackage;

/* loaded from: classes27.dex */
public final /* synthetic */ class j30 implements android.view.View.OnClickListener {
    public final /* synthetic */ com.moji.liveview_finalversion.ui.discover.DiscoverFeedListAdapter n;
    public final /* synthetic */ int t;
    public final /* synthetic */ com.moji.liveview_finalversion.ui.discover.DiscoverFeedListAdapter.FeedItemViewHolder u;
    public final /* synthetic */ com.moji.liveview_finalversion.data.base.FeedList.LiveViewFeed v;

    public /* synthetic */ j30(com.moji.liveview_finalversion.ui.discover.DiscoverFeedListAdapter discoverFeedListAdapter, int i, com.moji.liveview_finalversion.ui.discover.DiscoverFeedListAdapter.FeedItemViewHolder feedItemViewHolder, com.moji.liveview_finalversion.data.base.FeedList.LiveViewFeed liveViewFeed) {
        this.n = discoverFeedListAdapter;
        this.t = i;
        this.u = feedItemViewHolder;
        this.v = liveViewFeed;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(android.view.View view) {
        com.moji.liveview_finalversion.ui.discover.DiscoverFeedListAdapter.FeedItemViewHolder.d(this.n, this.t, this.u, this.v, view);
    }
}
