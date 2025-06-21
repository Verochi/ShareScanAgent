package defpackage;

/* loaded from: classes17.dex */
public final /* synthetic */ class ti3 implements androidx.lifecycle.Observer {
    public final /* synthetic */ com.moji.weatherpain.WeatherPainActivity n;

    public /* synthetic */ ti3(com.moji.weatherpain.WeatherPainActivity weatherPainActivity) {
        this.n = weatherPainActivity;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(java.lang.Object obj) {
        com.moji.weatherpain.WeatherPainActivity.b(this.n, (com.moji.http.weatherpain.entity.WeatherPainResult) obj);
    }
}
