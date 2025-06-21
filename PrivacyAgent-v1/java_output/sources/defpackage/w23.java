package defpackage;

/* loaded from: classes7.dex */
public final /* synthetic */ class w23 implements android.view.View.OnClickListener {
    public final /* synthetic */ com.moji.mjweather.tabme.ToolGridAdapter n;
    public final /* synthetic */ int t;

    public /* synthetic */ w23(com.moji.mjweather.tabme.ToolGridAdapter toolGridAdapter, int i) {
        this.n = toolGridAdapter;
        this.t = i;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(android.view.View view) {
        com.moji.mjweather.tabme.ToolGridAdapter.a(this.n, this.t, view);
    }
}
