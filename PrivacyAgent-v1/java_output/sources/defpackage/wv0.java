package defpackage;

/* loaded from: classes7.dex */
public final /* synthetic */ class wv0 implements java.lang.Runnable {
    public final /* synthetic */ com.moji.mjweather.weather.beta.life.LifeSettingGridItem n;
    public final /* synthetic */ android.view.View t;

    public /* synthetic */ wv0(com.moji.mjweather.weather.beta.life.LifeSettingGridItem lifeSettingGridItem, android.view.View view) {
        this.n = lifeSettingGridItem;
        this.t = view;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.moji.mjweather.weather.beta.life.LifeSettingGridItem.a(this.n, this.t);
    }
}
