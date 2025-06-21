package androidx.core.os;

@androidx.annotation.RequiresApi(24)
/* loaded from: classes.dex */
final class LocaleListPlatformWrapper implements androidx.core.os.LocaleListInterface {
    private final android.os.LocaleList mLocaleList;

    public LocaleListPlatformWrapper(android.os.LocaleList localeList) {
        this.mLocaleList = localeList;
    }

    public boolean equals(java.lang.Object obj) {
        boolean equals;
        equals = this.mLocaleList.equals(((androidx.core.os.LocaleListInterface) obj).getLocaleList());
        return equals;
    }

    @Override // androidx.core.os.LocaleListInterface
    public java.util.Locale get(int i) {
        java.util.Locale locale;
        locale = this.mLocaleList.get(i);
        return locale;
    }

    @Override // androidx.core.os.LocaleListInterface
    @androidx.annotation.Nullable
    public java.util.Locale getFirstMatch(@androidx.annotation.NonNull java.lang.String[] strArr) {
        java.util.Locale firstMatch;
        firstMatch = this.mLocaleList.getFirstMatch(strArr);
        return firstMatch;
    }

    @Override // androidx.core.os.LocaleListInterface
    public java.lang.Object getLocaleList() {
        return this.mLocaleList;
    }

    public int hashCode() {
        int hashCode;
        hashCode = this.mLocaleList.hashCode();
        return hashCode;
    }

    @Override // androidx.core.os.LocaleListInterface
    public int indexOf(java.util.Locale locale) {
        int indexOf;
        indexOf = this.mLocaleList.indexOf(locale);
        return indexOf;
    }

    @Override // androidx.core.os.LocaleListInterface
    public boolean isEmpty() {
        boolean isEmpty;
        isEmpty = this.mLocaleList.isEmpty();
        return isEmpty;
    }

    @Override // androidx.core.os.LocaleListInterface
    public int size() {
        int size;
        size = this.mLocaleList.size();
        return size;
    }

    @Override // androidx.core.os.LocaleListInterface
    public java.lang.String toLanguageTags() {
        java.lang.String languageTags;
        languageTags = this.mLocaleList.toLanguageTags();
        return languageTags;
    }

    public java.lang.String toString() {
        java.lang.String localeList;
        localeList = this.mLocaleList.toString();
        return localeList;
    }
}
