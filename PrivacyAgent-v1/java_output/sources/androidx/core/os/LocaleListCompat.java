package androidx.core.os;

/* loaded from: classes.dex */
public final class LocaleListCompat {
    private static final androidx.core.os.LocaleListCompat sEmptyLocaleList = create(new java.util.Locale[0]);
    private androidx.core.os.LocaleListInterface mImpl;

    private LocaleListCompat(androidx.core.os.LocaleListInterface localeListInterface) {
        this.mImpl = localeListInterface;
    }

    @androidx.annotation.NonNull
    public static androidx.core.os.LocaleListCompat create(@androidx.annotation.NonNull java.util.Locale... localeArr) {
        return android.os.Build.VERSION.SDK_INT >= 24 ? wrap(new android.os.LocaleList(localeArr)) : new androidx.core.os.LocaleListCompat(new androidx.core.os.LocaleListCompatWrapper(localeArr));
    }

    public static java.util.Locale forLanguageTagCompat(java.lang.String str) {
        if (str.contains(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER)) {
            java.lang.String[] split = str.split(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER, -1);
            if (split.length > 2) {
                return new java.util.Locale(split[0], split[1], split[2]);
            }
            if (split.length > 1) {
                return new java.util.Locale(split[0], split[1]);
            }
            if (split.length == 1) {
                return new java.util.Locale(split[0]);
            }
        } else {
            if (!str.contains("_")) {
                return new java.util.Locale(str);
            }
            java.lang.String[] split2 = str.split("_", -1);
            if (split2.length > 2) {
                return new java.util.Locale(split2[0], split2[1], split2[2]);
            }
            if (split2.length > 1) {
                return new java.util.Locale(split2[0], split2[1]);
            }
            if (split2.length == 1) {
                return new java.util.Locale(split2[0]);
            }
        }
        throw new java.lang.IllegalArgumentException("Can not parse language tag: [" + str + "]");
    }

    @androidx.annotation.NonNull
    public static androidx.core.os.LocaleListCompat forLanguageTags(@androidx.annotation.Nullable java.lang.String str) {
        if (str == null || str.isEmpty()) {
            return getEmptyLocaleList();
        }
        java.lang.String[] split = str.split(",", -1);
        int length = split.length;
        java.util.Locale[] localeArr = new java.util.Locale[length];
        for (int i = 0; i < length; i++) {
            localeArr[i] = java.util.Locale.forLanguageTag(split[i]);
        }
        return create(localeArr);
    }

    @androidx.annotation.NonNull
    @androidx.annotation.Size(min = 1)
    public static androidx.core.os.LocaleListCompat getAdjustedDefault() {
        android.os.LocaleList adjustedDefault;
        if (android.os.Build.VERSION.SDK_INT < 24) {
            return create(java.util.Locale.getDefault());
        }
        adjustedDefault = android.os.LocaleList.getAdjustedDefault();
        return wrap(adjustedDefault);
    }

    @androidx.annotation.NonNull
    @androidx.annotation.Size(min = 1)
    public static androidx.core.os.LocaleListCompat getDefault() {
        android.os.LocaleList localeList;
        if (android.os.Build.VERSION.SDK_INT < 24) {
            return create(java.util.Locale.getDefault());
        }
        localeList = android.os.LocaleList.getDefault();
        return wrap(localeList);
    }

    @androidx.annotation.NonNull
    public static androidx.core.os.LocaleListCompat getEmptyLocaleList() {
        return sEmptyLocaleList;
    }

    @androidx.annotation.NonNull
    @androidx.annotation.RequiresApi(24)
    public static androidx.core.os.LocaleListCompat wrap(@androidx.annotation.NonNull android.os.LocaleList localeList) {
        return new androidx.core.os.LocaleListCompat(new androidx.core.os.LocaleListPlatformWrapper(localeList));
    }

    @androidx.annotation.RequiresApi(24)
    @java.lang.Deprecated
    public static androidx.core.os.LocaleListCompat wrap(java.lang.Object obj) {
        return wrap((android.os.LocaleList) obj);
    }

    public boolean equals(java.lang.Object obj) {
        return (obj instanceof androidx.core.os.LocaleListCompat) && this.mImpl.equals(((androidx.core.os.LocaleListCompat) obj).mImpl);
    }

    public java.util.Locale get(int i) {
        return this.mImpl.get(i);
    }

    @androidx.annotation.Nullable
    public java.util.Locale getFirstMatch(@androidx.annotation.NonNull java.lang.String[] strArr) {
        return this.mImpl.getFirstMatch(strArr);
    }

    public int hashCode() {
        return this.mImpl.hashCode();
    }

    @androidx.annotation.IntRange(from = -1)
    public int indexOf(java.util.Locale locale) {
        return this.mImpl.indexOf(locale);
    }

    public boolean isEmpty() {
        return this.mImpl.isEmpty();
    }

    @androidx.annotation.IntRange(from = 0)
    public int size() {
        return this.mImpl.size();
    }

    @androidx.annotation.NonNull
    public java.lang.String toLanguageTags() {
        return this.mImpl.toLanguageTags();
    }

    public java.lang.String toString() {
        return this.mImpl.toString();
    }

    @androidx.annotation.Nullable
    public java.lang.Object unwrap() {
        return this.mImpl.getLocaleList();
    }
}
