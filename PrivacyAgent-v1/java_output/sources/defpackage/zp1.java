package defpackage;

/* loaded from: classes8.dex */
public final /* synthetic */ class zp1 implements android.view.View.OnClickListener {
    public final /* synthetic */ kotlin.jvm.functions.Function3 n;
    public final /* synthetic */ com.moji.mjweathercorrect.ui.WeatherCorrectIconView t;
    public final /* synthetic */ com.moji.mjweathercorrect.model.WeatherIconModel u;
    public final /* synthetic */ int v;

    public /* synthetic */ zp1(kotlin.jvm.functions.Function3 function3, com.moji.mjweathercorrect.ui.WeatherCorrectIconView weatherCorrectIconView, com.moji.mjweathercorrect.model.WeatherIconModel weatherIconModel, int i) {
        this.n = function3;
        this.t = weatherCorrectIconView;
        this.u = weatherIconModel;
        this.v = i;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(android.view.View view) {
        com.moji.mjweathercorrect.newcorrect.NewCorrectPickWeatherFragment.d(this.n, this.t, this.u, this.v, view);
    }
}
