package defpackage;

/* loaded from: classes7.dex */
public final /* synthetic */ class ra1 implements android.view.View.OnClickListener {
    public final /* synthetic */ com.moji.weatherprovider.data.AlertList.Alert n;
    public final /* synthetic */ int t;

    public /* synthetic */ ra1(com.moji.weatherprovider.data.AlertList.Alert alert, int i) {
        this.n = alert;
        this.t = i;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(android.view.View view) {
        com.moji.mjweather.weather.view.MainWarnView.a(this.n, this.t, view);
    }
}
