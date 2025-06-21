package defpackage;

/* loaded from: classes27.dex */
public final /* synthetic */ class w30 implements androidx.lifecycle.Observer {
    public final /* synthetic */ com.moji.liveview.home.discover.ui.DiscoverFragment n;

    public /* synthetic */ w30(com.moji.liveview.home.discover.ui.DiscoverFragment discoverFragment) {
        this.n = discoverFragment;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(java.lang.Object obj) {
        com.moji.liveview.home.discover.ui.DiscoverFragment.f(this.n, (com.moji.liveview.home.discover.model.LiveDiscoverData) obj);
    }
}
