package defpackage;

/* loaded from: classes27.dex */
public final /* synthetic */ class zw0 implements java.lang.Runnable {
    public final /* synthetic */ com.moji.liveview.home.discover.view.LiveModuleView n;
    public final /* synthetic */ com.moji.http.snsforum.v9.entity.LiveDiscoverResult.Module t;
    public final /* synthetic */ float u;
    public final /* synthetic */ float v;

    public /* synthetic */ zw0(com.moji.liveview.home.discover.view.LiveModuleView liveModuleView, com.moji.http.snsforum.v9.entity.LiveDiscoverResult.Module module, float f, float f2) {
        this.n = liveModuleView;
        this.t = module;
        this.u = f;
        this.v = f2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.moji.liveview.home.discover.view.LiveModuleView.a(this.n, this.t, this.u, this.v);
    }
}
