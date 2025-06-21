package defpackage;

/* loaded from: classes27.dex */
public final /* synthetic */ class pl1 implements android.view.View.OnClickListener {
    public final /* synthetic */ com.moji.liveview_finalversion.ui.discover.ModuleAdapter n;
    public final /* synthetic */ int t;
    public final /* synthetic */ com.moji.liveview_finalversion.data.discover.ModuleConfig u;

    public /* synthetic */ pl1(com.moji.liveview_finalversion.ui.discover.ModuleAdapter moduleAdapter, int i, com.moji.liveview_finalversion.data.discover.ModuleConfig moduleConfig) {
        this.n = moduleAdapter;
        this.t = i;
        this.u = moduleConfig;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(android.view.View view) {
        com.moji.liveview_finalversion.ui.discover.ModuleAdapter.ViewHolder.a(this.n, this.t, this.u, view);
    }
}
