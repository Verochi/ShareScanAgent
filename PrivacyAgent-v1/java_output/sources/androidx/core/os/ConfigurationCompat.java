package androidx.core.os;

/* loaded from: classes.dex */
public final class ConfigurationCompat {
    private ConfigurationCompat() {
    }

    @androidx.annotation.NonNull
    public static androidx.core.os.LocaleListCompat getLocales(@androidx.annotation.NonNull android.content.res.Configuration configuration) {
        android.os.LocaleList locales;
        if (android.os.Build.VERSION.SDK_INT < 24) {
            return androidx.core.os.LocaleListCompat.create(configuration.locale);
        }
        locales = configuration.getLocales();
        return androidx.core.os.LocaleListCompat.wrap(locales);
    }
}
