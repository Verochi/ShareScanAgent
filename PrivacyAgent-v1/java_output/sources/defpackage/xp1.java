package defpackage;

/* loaded from: classes8.dex */
public final /* synthetic */ class xp1 implements com.moji.mjweathercorrect.newcorrect.WeatherSecondaryOptionView.OnSecondaryOptionCheckListener {
    public final /* synthetic */ com.moji.mjweathercorrect.newcorrect.NewCorrectPickWeatherFragment a;

    public /* synthetic */ xp1(com.moji.mjweathercorrect.newcorrect.NewCorrectPickWeatherFragment newCorrectPickWeatherFragment) {
        this.a = newCorrectPickWeatherFragment;
    }

    public final void onSelectChanged(boolean z, com.moji.mjweathercorrect.model.WeatherIconModel weatherIconModel) {
        com.moji.mjweathercorrect.newcorrect.NewCorrectPickWeatherFragment.a(this.a, z, weatherIconModel);
    }
}
