package defpackage;

/* loaded from: classes27.dex */
public final /* synthetic */ class o30 implements java.lang.Runnable {
    public final /* synthetic */ com.moji.liveview.home.discover.ui.DiscoverFragment n;
    public final /* synthetic */ boolean t;

    public /* synthetic */ o30(com.moji.liveview.home.discover.ui.DiscoverFragment discoverFragment, boolean z) {
        this.n = discoverFragment;
        this.t = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.moji.liveview.home.discover.ui.DiscoverFragment.c(this.n, this.t);
    }
}
