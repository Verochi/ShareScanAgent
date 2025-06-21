package defpackage;

/* loaded from: classes7.dex */
public final /* synthetic */ class jj0 implements android.view.View.OnClickListener {
    public final /* synthetic */ com.moji.mjweather.tabme.FunctionSettingsGridAdapter n;
    public final /* synthetic */ int t;

    public /* synthetic */ jj0(com.moji.mjweather.tabme.FunctionSettingsGridAdapter functionSettingsGridAdapter, int i) {
        this.n = functionSettingsGridAdapter;
        this.t = i;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(android.view.View view) {
        com.moji.mjweather.tabme.FunctionSettingsGridAdapter.a(this.n, this.t, view);
    }
}
