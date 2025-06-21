package defpackage;

/* loaded from: classes17.dex */
public final /* synthetic */ class q61 implements java.lang.Runnable {
    public final /* synthetic */ com.moji.weathersence.weather.MJWeatherSceneFragment n;
    public final /* synthetic */ com.moji.weathersence.data.SceneData t;

    public /* synthetic */ q61(com.moji.weathersence.weather.MJWeatherSceneFragment mJWeatherSceneFragment, com.moji.weathersence.data.SceneData sceneData) {
        this.n = mJWeatherSceneFragment;
        this.t = sceneData;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.moji.weathersence.weather.MJWeatherSceneFragment.a(this.n, this.t);
    }
}
