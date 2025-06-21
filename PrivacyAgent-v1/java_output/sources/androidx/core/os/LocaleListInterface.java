package androidx.core.os;

/* loaded from: classes.dex */
interface LocaleListInterface {
    java.util.Locale get(int i);

    @androidx.annotation.Nullable
    java.util.Locale getFirstMatch(@androidx.annotation.NonNull java.lang.String[] strArr);

    java.lang.Object getLocaleList();

    @androidx.annotation.IntRange(from = -1)
    int indexOf(java.util.Locale locale);

    boolean isEmpty();

    @androidx.annotation.IntRange(from = 0)
    int size();

    java.lang.String toLanguageTags();
}
