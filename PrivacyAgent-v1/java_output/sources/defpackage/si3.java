package defpackage;

/* loaded from: classes17.dex */
public final /* synthetic */ class si3 implements androidx.lifecycle.Observer {
    public final /* synthetic */ com.moji.weatherpain.WeatherPainActivity n;

    public /* synthetic */ si3(com.moji.weatherpain.WeatherPainActivity weatherPainActivity) {
        this.n = weatherPainActivity;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(java.lang.Object obj) {
        com.moji.weatherpain.WeatherPainActivity.g(this.n, (com.moji.mjcitypicker.data.SelectedArea) obj);
    }
}
