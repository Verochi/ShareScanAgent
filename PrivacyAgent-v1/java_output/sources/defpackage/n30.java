package defpackage;

/* loaded from: classes27.dex */
public final /* synthetic */ class n30 implements com.moji.swiperefreshlayout.SwipeRefreshLayout.OnRefreshListener {
    public final /* synthetic */ com.moji.liveview.home.discover.ui.DiscoverFragment a;
    public final /* synthetic */ com.moji.swiperefreshlayout.SwipeRefreshLayout b;

    public /* synthetic */ n30(com.moji.liveview.home.discover.ui.DiscoverFragment discoverFragment, com.moji.swiperefreshlayout.SwipeRefreshLayout swipeRefreshLayout) {
        this.a = discoverFragment;
        this.b = swipeRefreshLayout;
    }

    public final void onRefresh() {
        com.moji.liveview.home.discover.ui.DiscoverFragment.k(this.a, this.b);
    }
}
