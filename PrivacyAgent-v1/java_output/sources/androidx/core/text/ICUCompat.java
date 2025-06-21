package androidx.core.text;

/* loaded from: classes.dex */
public final class ICUCompat {
    private static final java.lang.String TAG = "ICUCompat";
    private static java.lang.reflect.Method sAddLikelySubtagsMethod;
    private static java.lang.reflect.Method sGetScriptMethod;

    static {
        if (android.os.Build.VERSION.SDK_INT < 24) {
            try {
                sAddLikelySubtagsMethod = java.lang.Class.forName("libcore.icu.ICU").getMethod("addLikelySubtags", java.util.Locale.class);
            } catch (java.lang.Exception e) {
                throw new java.lang.IllegalStateException(e);
            }
        }
    }

    private ICUCompat() {
    }

    private static java.lang.String addLikelySubtags(java.util.Locale locale) {
        java.lang.String locale2 = locale.toString();
        try {
            java.lang.reflect.Method method = sAddLikelySubtagsMethod;
            if (method != null) {
                return (java.lang.String) method.invoke(null, locale2);
            }
        } catch (java.lang.IllegalAccessException | java.lang.reflect.InvocationTargetException unused) {
        }
        return locale2;
    }

    private static java.lang.String getScript(java.lang.String str) {
        try {
            java.lang.reflect.Method method = sGetScriptMethod;
            if (method != null) {
                return (java.lang.String) method.invoke(null, str);
            }
        } catch (java.lang.IllegalAccessException | java.lang.reflect.InvocationTargetException unused) {
        }
        return null;
    }

    @androidx.annotation.Nullable
    public static java.lang.String maximizeAndGetScript(java.util.Locale locale) {
        android.icu.util.ULocale forLocale;
        android.icu.util.ULocale addLikelySubtags;
        java.lang.String script;
        if (android.os.Build.VERSION.SDK_INT < 24) {
            try {
                return ((java.util.Locale) sAddLikelySubtagsMethod.invoke(null, locale)).getScript();
            } catch (java.lang.IllegalAccessException | java.lang.reflect.InvocationTargetException unused) {
                return locale.getScript();
            }
        }
        forLocale = android.icu.util.ULocale.forLocale(locale);
        addLikelySubtags = android.icu.util.ULocale.addLikelySubtags(forLocale);
        script = addLikelySubtags.getScript();
        return script;
    }
}
