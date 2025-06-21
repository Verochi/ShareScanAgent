package moji.com.mjweatherservicebase;

@kotlin.Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"Lmoji/com/mjweatherservicebase/WeatherServiceThemeRegister;", "Lcom/moji/theme/ThemeRegister;", "()V", "onRegisterTheme", "", "context", "Landroid/content/Context;", "MJWeatherServiceBase_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes20.dex */
public final class WeatherServiceThemeRegister implements com.moji.theme.ThemeRegister {
    public void onRegisterTheme(@org.jetbrains.annotations.NotNull android.content.Context context) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(context, "context");
        context.getTheme().applyStyle(moji.com.mjweatherservicebase.R.style.WeatherServiceDayNightTheme, true);
    }
}
