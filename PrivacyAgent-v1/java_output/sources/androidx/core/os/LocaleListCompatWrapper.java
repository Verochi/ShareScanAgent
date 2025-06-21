package androidx.core.os;

/* loaded from: classes.dex */
final class LocaleListCompatWrapper implements androidx.core.os.LocaleListInterface {
    private final java.util.Locale[] mList;

    @androidx.annotation.NonNull
    private final java.lang.String mStringRepresentation;
    private static final java.util.Locale[] sEmptyList = new java.util.Locale[0];
    private static final java.util.Locale LOCALE_EN_XA = new java.util.Locale("en", "XA");
    private static final java.util.Locale LOCALE_AR_XB = new java.util.Locale(com.anythink.expressad.video.dynview.a.a.V, "XB");
    private static final java.util.Locale EN_LATN = androidx.core.os.LocaleListCompat.forLanguageTagCompat("en-Latn");

    public LocaleListCompatWrapper(@androidx.annotation.NonNull java.util.Locale... localeArr) {
        if (localeArr.length == 0) {
            this.mList = sEmptyList;
            this.mStringRepresentation = "";
            return;
        }
        java.util.ArrayList arrayList = new java.util.ArrayList();
        java.util.HashSet hashSet = new java.util.HashSet();
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        for (int i = 0; i < localeArr.length; i++) {
            java.util.Locale locale = localeArr[i];
            if (locale == null) {
                throw new java.lang.NullPointerException("list[" + i + "] is null");
            }
            if (!hashSet.contains(locale)) {
                java.util.Locale locale2 = (java.util.Locale) locale.clone();
                arrayList.add(locale2);
                toLanguageTag(sb, locale2);
                if (i < localeArr.length - 1) {
                    sb.append(',');
                }
                hashSet.add(locale2);
            }
        }
        this.mList = (java.util.Locale[]) arrayList.toArray(new java.util.Locale[arrayList.size()]);
        this.mStringRepresentation = sb.toString();
    }

    private java.util.Locale computeFirstMatch(java.util.Collection<java.lang.String> collection, boolean z) {
        int computeFirstMatchIndex = computeFirstMatchIndex(collection, z);
        if (computeFirstMatchIndex == -1) {
            return null;
        }
        return this.mList[computeFirstMatchIndex];
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x001b, code lost:
    
        if (r6 < Integer.MAX_VALUE) goto L17;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private int computeFirstMatchIndex(java.util.Collection<java.lang.String> collection, boolean z) {
        int i;
        java.util.Locale[] localeArr = this.mList;
        if (localeArr.length == 1) {
            return 0;
        }
        if (localeArr.length == 0) {
            return -1;
        }
        if (z) {
            i = findFirstMatchIndex(EN_LATN);
            if (i == 0) {
                return 0;
            }
        }
        i = Integer.MAX_VALUE;
        java.util.Iterator<java.lang.String> it = collection.iterator();
        while (it.hasNext()) {
            int findFirstMatchIndex = findFirstMatchIndex(androidx.core.os.LocaleListCompat.forLanguageTagCompat(it.next()));
            if (findFirstMatchIndex == 0) {
                return 0;
            }
            if (findFirstMatchIndex < i) {
                i = findFirstMatchIndex;
            }
        }
        if (i == Integer.MAX_VALUE) {
            return 0;
        }
        return i;
    }

    private int findFirstMatchIndex(java.util.Locale locale) {
        int i = 0;
        while (true) {
            java.util.Locale[] localeArr = this.mList;
            if (i >= localeArr.length) {
                return Integer.MAX_VALUE;
            }
            if (matchScore(locale, localeArr[i]) > 0) {
                return i;
            }
            i++;
        }
    }

    private static java.lang.String getLikelyScript(java.util.Locale locale) {
        java.lang.String script = locale.getScript();
        return !script.isEmpty() ? script : "";
    }

    private static boolean isPseudoLocale(java.util.Locale locale) {
        return LOCALE_EN_XA.equals(locale) || LOCALE_AR_XB.equals(locale);
    }

    @androidx.annotation.IntRange(from = 0, to = 1)
    private static int matchScore(java.util.Locale locale, java.util.Locale locale2) {
        if (locale.equals(locale2)) {
            return 1;
        }
        if (!locale.getLanguage().equals(locale2.getLanguage()) || isPseudoLocale(locale) || isPseudoLocale(locale2)) {
            return 0;
        }
        java.lang.String likelyScript = getLikelyScript(locale);
        if (!likelyScript.isEmpty()) {
            return likelyScript.equals(getLikelyScript(locale2)) ? 1 : 0;
        }
        java.lang.String country = locale.getCountry();
        return (country.isEmpty() || country.equals(locale2.getCountry())) ? 1 : 0;
    }

    @androidx.annotation.VisibleForTesting
    public static void toLanguageTag(java.lang.StringBuilder sb, java.util.Locale locale) {
        sb.append(locale.getLanguage());
        java.lang.String country = locale.getCountry();
        if (country == null || country.isEmpty()) {
            return;
        }
        sb.append('-');
        sb.append(locale.getCountry());
    }

    public boolean equals(java.lang.Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof androidx.core.os.LocaleListCompatWrapper)) {
            return false;
        }
        java.util.Locale[] localeArr = ((androidx.core.os.LocaleListCompatWrapper) obj).mList;
        if (this.mList.length != localeArr.length) {
            return false;
        }
        int i = 0;
        while (true) {
            java.util.Locale[] localeArr2 = this.mList;
            if (i >= localeArr2.length) {
                return true;
            }
            if (!localeArr2[i].equals(localeArr[i])) {
                return false;
            }
            i++;
        }
    }

    @Override // androidx.core.os.LocaleListInterface
    public java.util.Locale get(int i) {
        if (i >= 0) {
            java.util.Locale[] localeArr = this.mList;
            if (i < localeArr.length) {
                return localeArr[i];
            }
        }
        return null;
    }

    @Override // androidx.core.os.LocaleListInterface
    public java.util.Locale getFirstMatch(@androidx.annotation.NonNull java.lang.String[] strArr) {
        return computeFirstMatch(java.util.Arrays.asList(strArr), false);
    }

    @Override // androidx.core.os.LocaleListInterface
    @androidx.annotation.Nullable
    public java.lang.Object getLocaleList() {
        return null;
    }

    public int hashCode() {
        int i = 1;
        int i2 = 0;
        while (true) {
            java.util.Locale[] localeArr = this.mList;
            if (i2 >= localeArr.length) {
                return i;
            }
            i = (i * 31) + localeArr[i2].hashCode();
            i2++;
        }
    }

    @Override // androidx.core.os.LocaleListInterface
    public int indexOf(java.util.Locale locale) {
        int i = 0;
        while (true) {
            java.util.Locale[] localeArr = this.mList;
            if (i >= localeArr.length) {
                return -1;
            }
            if (localeArr[i].equals(locale)) {
                return i;
            }
            i++;
        }
    }

    @Override // androidx.core.os.LocaleListInterface
    public boolean isEmpty() {
        return this.mList.length == 0;
    }

    @Override // androidx.core.os.LocaleListInterface
    public int size() {
        return this.mList.length;
    }

    @Override // androidx.core.os.LocaleListInterface
    public java.lang.String toLanguageTags() {
        return this.mStringRepresentation;
    }

    public java.lang.String toString() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("[");
        int i = 0;
        while (true) {
            java.util.Locale[] localeArr = this.mList;
            if (i >= localeArr.length) {
                sb.append("]");
                return sb.toString();
            }
            sb.append(localeArr[i]);
            if (i < this.mList.length - 1) {
                sb.append(',');
            }
            i++;
        }
    }
}
