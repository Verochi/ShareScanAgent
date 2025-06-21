package defpackage;

/* loaded from: classes7.dex */
public final /* synthetic */ class zh3 implements com.moji.weathersence.view.PageGLTextureView.EGLConfigChooser {
    public final /* synthetic */ com.badlogic.gdx.backends.android.surfaceview.GLTextureView.ShareEGLEnv a;

    public /* synthetic */ zh3(com.badlogic.gdx.backends.android.surfaceview.GLTextureView.ShareEGLEnv shareEGLEnv) {
        this.a = shareEGLEnv;
    }

    public final javax.microedition.khronos.egl.EGLConfig chooseConfig(javax.microedition.khronos.egl.EGL10 egl10, javax.microedition.khronos.egl.EGLDisplay eGLDisplay) {
        return com.moji.mjweather.weather.WeatherPageView.u(this.a, egl10, eGLDisplay);
    }
}
