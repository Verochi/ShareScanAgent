package androidx.core.telephony.mbms;

/* loaded from: classes.dex */
public final class MbmsHelper {
    private MbmsHelper() {
    }

    @androidx.annotation.Nullable
    @android.annotation.SuppressLint({"BanTargetApiAnnotation"})
    @android.annotation.TargetApi(28)
    public static java.lang.CharSequence getBestNameForService(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.NonNull android.telephony.mbms.ServiceInfo serviceInfo) {
        android.os.LocaleList locales;
        java.util.Set namedContentLocales;
        java.util.Set namedContentLocales2;
        java.util.Locale firstMatch;
        java.lang.CharSequence nameForLocale;
        if (android.os.Build.VERSION.SDK_INT < 28) {
            return null;
        }
        locales = context.getResources().getConfiguration().getLocales();
        namedContentLocales = serviceInfo.getNamedContentLocales();
        int size = namedContentLocales.size();
        if (size == 0) {
            return null;
        }
        java.lang.String[] strArr = new java.lang.String[size];
        namedContentLocales2 = serviceInfo.getNamedContentLocales();
        java.util.Iterator it = namedContentLocales2.iterator();
        int i = 0;
        while (it.hasNext()) {
            strArr[i] = ((java.util.Locale) it.next()).toLanguageTag();
            i++;
        }
        firstMatch = locales.getFirstMatch(strArr);
        if (firstMatch == null) {
            return null;
        }
        nameForLocale = serviceInfo.getNameForLocale(firstMatch);
        return nameForLocale;
    }
}
