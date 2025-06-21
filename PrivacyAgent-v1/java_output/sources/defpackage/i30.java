package defpackage;

/* loaded from: classes27.dex */
public final /* synthetic */ class i30 implements android.view.View.OnClickListener {
    public final /* synthetic */ com.moji.liveview_finalversion.ui.discover.DiscoverFeedListAdapter n;
    public final /* synthetic */ com.moji.paraiseview.WaterFallPraiseView t;
    public final /* synthetic */ com.moji.liveview_finalversion.data.base.FeedList.LiveViewFeed u;

    public /* synthetic */ i30(com.moji.liveview_finalversion.ui.discover.DiscoverFeedListAdapter discoverFeedListAdapter, com.moji.paraiseview.WaterFallPraiseView waterFallPraiseView, com.moji.liveview_finalversion.data.base.FeedList.LiveViewFeed liveViewFeed) {
        this.n = discoverFeedListAdapter;
        this.t = waterFallPraiseView;
        this.u = liveViewFeed;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(android.view.View view) {
        com.moji.liveview_finalversion.ui.discover.DiscoverFeedListAdapter.FeedItemViewHolder.c(this.n, this.t, this.u, view);
    }
}
