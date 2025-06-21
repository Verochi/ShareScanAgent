package defpackage;

/* loaded from: classes7.dex */
public final /* synthetic */ class y23 implements android.view.View.OnClickListener {
    public final /* synthetic */ com.moji.mjweather.tabme.ToolPageGridAdapter n;
    public final /* synthetic */ int t;
    public final /* synthetic */ com.moji.mjweather.tabme.ToolPageGridAdapter.ViewHolder u;

    public /* synthetic */ y23(com.moji.mjweather.tabme.ToolPageGridAdapter toolPageGridAdapter, int i, com.moji.mjweather.tabme.ToolPageGridAdapter.ViewHolder viewHolder) {
        this.n = toolPageGridAdapter;
        this.t = i;
        this.u = viewHolder;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(android.view.View view) {
        com.moji.mjweather.tabme.ToolPageGridAdapter.a(this.n, this.t, this.u, view);
    }
}
