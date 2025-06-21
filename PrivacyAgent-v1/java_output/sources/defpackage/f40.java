package defpackage;

/* loaded from: classes27.dex */
public final /* synthetic */ class f40 implements java.lang.Runnable {
    public final /* synthetic */ android.view.View n;
    public final /* synthetic */ android.content.Intent t;
    public final /* synthetic */ com.moji.liveview_finalversion.ui.discover.DiscoverFragmentV2 u;

    public /* synthetic */ f40(android.view.View view, android.content.Intent intent, com.moji.liveview_finalversion.ui.discover.DiscoverFragmentV2 discoverFragmentV2) {
        this.n = view;
        this.t = intent;
        this.u = discoverFragmentV2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.moji.liveview_finalversion.ui.discover.DiscoverFragmentV2.b(this.n, this.t, this.u);
    }
}
