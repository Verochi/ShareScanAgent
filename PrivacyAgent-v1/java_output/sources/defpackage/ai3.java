package defpackage;

/* loaded from: classes7.dex */
public final /* synthetic */ class ai3 implements androidx.lifecycle.Observer {
    public final /* synthetic */ com.moji.mjweather.weather.WeatherPageView n;
    public final /* synthetic */ androidx.fragment.app.Fragment t;

    public /* synthetic */ ai3(com.moji.mjweather.weather.WeatherPageView weatherPageView, androidx.fragment.app.Fragment fragment) {
        this.n = weatherPageView;
        this.t = fragment;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(java.lang.Object obj) {
        com.moji.mjweather.weather.WeatherPageView.t(this.n, this.t, (com.badlogic.gdx.backends.android.surfaceview.GLTextureView.ShareEGLEnv) obj);
    }
}
