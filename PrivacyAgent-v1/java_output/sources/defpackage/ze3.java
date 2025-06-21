package defpackage;

/* loaded from: classes17.dex */
public final /* synthetic */ class ze3 implements com.moji.weathersence.weather.MJWeatherDynamicSceneFragment.OnSharedEglContextListener {
    public final /* synthetic */ com.moji.weathersence.weather.WeatherAvatarView a;
    public final /* synthetic */ android.content.Context b;

    public /* synthetic */ ze3(com.moji.weathersence.weather.WeatherAvatarView weatherAvatarView, android.content.Context context) {
        this.a = weatherAvatarView;
        this.b = context;
    }

    public final void onEglContextCreated(com.badlogic.gdx.backends.android.surfaceview.GLTextureView.ShareEGLEnv shareEGLEnv) {
        com.moji.weathersence.weather.WeatherAvatarView.c(this.a, this.b, shareEGLEnv);
    }
}
