package androidx.core.text;

/* loaded from: classes.dex */
public final class TextUtilsCompat {
    private static final java.lang.String ARAB_SCRIPT_SUBTAG = "Arab";
    private static final java.lang.String HEBR_SCRIPT_SUBTAG = "Hebr";
    private static final java.util.Locale ROOT = new java.util.Locale("", "");

    private TextUtilsCompat() {
    }

    private static int getLayoutDirectionFromFirstChar(@androidx.annotation.NonNull java.util.Locale locale) {
        byte directionality = java.lang.Character.getDirectionality(locale.getDisplayName(locale).charAt(0));
        return (directionality == 1 || directionality == 2) ? 1 : 0;
    }

    public static int getLayoutDirectionFromLocale(@androidx.annotation.Nullable java.util.Locale locale) {
        return android.text.TextUtils.getLayoutDirectionFromLocale(locale);
    }

    @androidx.annotation.NonNull
    public static java.lang.String htmlEncode(@androidx.annotation.NonNull java.lang.String str) {
        return android.text.TextUtils.htmlEncode(str);
    }
}
