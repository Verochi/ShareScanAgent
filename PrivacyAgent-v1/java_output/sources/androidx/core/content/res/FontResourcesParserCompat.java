package androidx.core.content.res;

@androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
public class FontResourcesParserCompat {
    private static final int DEFAULT_TIMEOUT_MILLIS = 500;
    public static final int FETCH_STRATEGY_ASYNC = 1;
    public static final int FETCH_STRATEGY_BLOCKING = 0;
    public static final int INFINITE_TIMEOUT_VALUE = -1;
    private static final int ITALIC = 1;
    private static final int NORMAL_WEIGHT = 400;

    public interface FamilyResourceEntry {
    }

    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    public @interface FetchStrategy {
    }

    public static final class FontFamilyFilesResourceEntry implements androidx.core.content.res.FontResourcesParserCompat.FamilyResourceEntry {

        @androidx.annotation.NonNull
        private final androidx.core.content.res.FontResourcesParserCompat.FontFileResourceEntry[] mEntries;

        public FontFamilyFilesResourceEntry(@androidx.annotation.NonNull androidx.core.content.res.FontResourcesParserCompat.FontFileResourceEntry[] fontFileResourceEntryArr) {
            this.mEntries = fontFileResourceEntryArr;
        }

        @androidx.annotation.NonNull
        public androidx.core.content.res.FontResourcesParserCompat.FontFileResourceEntry[] getEntries() {
            return this.mEntries;
        }
    }

    public static final class FontFileResourceEntry {

        @androidx.annotation.NonNull
        private final java.lang.String mFileName;
        private boolean mItalic;
        private int mResourceId;
        private int mTtcIndex;
        private java.lang.String mVariationSettings;
        private int mWeight;

        public FontFileResourceEntry(@androidx.annotation.NonNull java.lang.String str, int i, boolean z, @androidx.annotation.Nullable java.lang.String str2, int i2, int i3) {
            this.mFileName = str;
            this.mWeight = i;
            this.mItalic = z;
            this.mVariationSettings = str2;
            this.mTtcIndex = i2;
            this.mResourceId = i3;
        }

        @androidx.annotation.NonNull
        public java.lang.String getFileName() {
            return this.mFileName;
        }

        public int getResourceId() {
            return this.mResourceId;
        }

        public int getTtcIndex() {
            return this.mTtcIndex;
        }

        @androidx.annotation.Nullable
        public java.lang.String getVariationSettings() {
            return this.mVariationSettings;
        }

        public int getWeight() {
            return this.mWeight;
        }

        public boolean isItalic() {
            return this.mItalic;
        }
    }

    public static final class ProviderResourceEntry implements androidx.core.content.res.FontResourcesParserCompat.FamilyResourceEntry {

        @androidx.annotation.NonNull
        private final androidx.core.provider.FontRequest mRequest;
        private final int mStrategy;

        @androidx.annotation.Nullable
        private final java.lang.String mSystemFontFamilyName;
        private final int mTimeoutMs;

        public ProviderResourceEntry(@androidx.annotation.NonNull androidx.core.provider.FontRequest fontRequest, int i, int i2) {
            this(fontRequest, i, i2, null);
        }

        @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY})
        public ProviderResourceEntry(@androidx.annotation.NonNull androidx.core.provider.FontRequest fontRequest, int i, int i2, @androidx.annotation.Nullable java.lang.String str) {
            this.mRequest = fontRequest;
            this.mStrategy = i;
            this.mTimeoutMs = i2;
            this.mSystemFontFamilyName = str;
        }

        public int getFetchStrategy() {
            return this.mStrategy;
        }

        @androidx.annotation.NonNull
        public androidx.core.provider.FontRequest getRequest() {
            return this.mRequest;
        }

        @androidx.annotation.Nullable
        @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY})
        public java.lang.String getSystemFontFamilyName() {
            return this.mSystemFontFamilyName;
        }

        public int getTimeout() {
            return this.mTimeoutMs;
        }
    }

    private FontResourcesParserCompat() {
    }

    private static int getType(android.content.res.TypedArray typedArray, int i) {
        return typedArray.getType(i);
    }

    @androidx.annotation.Nullable
    public static androidx.core.content.res.FontResourcesParserCompat.FamilyResourceEntry parse(org.xmlpull.v1.XmlPullParser xmlPullParser, android.content.res.Resources resources) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        int next;
        do {
            next = xmlPullParser.next();
            if (next == 2) {
                break;
            }
        } while (next != 1);
        if (next == 2) {
            return readFamilies(xmlPullParser, resources);
        }
        throw new org.xmlpull.v1.XmlPullParserException("No start tag found");
    }

    public static java.util.List<java.util.List<byte[]>> readCerts(android.content.res.Resources resources, @androidx.annotation.ArrayRes int i) {
        if (i == 0) {
            return java.util.Collections.emptyList();
        }
        android.content.res.TypedArray obtainTypedArray = resources.obtainTypedArray(i);
        try {
            if (obtainTypedArray.length() == 0) {
                return java.util.Collections.emptyList();
            }
            java.util.ArrayList arrayList = new java.util.ArrayList();
            if (getType(obtainTypedArray, 0) == 1) {
                for (int i2 = 0; i2 < obtainTypedArray.length(); i2++) {
                    int resourceId = obtainTypedArray.getResourceId(i2, 0);
                    if (resourceId != 0) {
                        arrayList.add(toByteArrayList(resources.getStringArray(resourceId)));
                    }
                }
            } else {
                arrayList.add(toByteArrayList(resources.getStringArray(i)));
            }
            return arrayList;
        } finally {
            obtainTypedArray.recycle();
        }
    }

    @androidx.annotation.Nullable
    private static androidx.core.content.res.FontResourcesParserCompat.FamilyResourceEntry readFamilies(org.xmlpull.v1.XmlPullParser xmlPullParser, android.content.res.Resources resources) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        xmlPullParser.require(2, null, "font-family");
        if (xmlPullParser.getName().equals("font-family")) {
            return readFamily(xmlPullParser, resources);
        }
        skip(xmlPullParser);
        return null;
    }

    @androidx.annotation.Nullable
    private static androidx.core.content.res.FontResourcesParserCompat.FamilyResourceEntry readFamily(org.xmlpull.v1.XmlPullParser xmlPullParser, android.content.res.Resources resources) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        android.content.res.TypedArray obtainAttributes = resources.obtainAttributes(android.util.Xml.asAttributeSet(xmlPullParser), androidx.core.R.styleable.FontFamily);
        java.lang.String string = obtainAttributes.getString(androidx.core.R.styleable.FontFamily_fontProviderAuthority);
        java.lang.String string2 = obtainAttributes.getString(androidx.core.R.styleable.FontFamily_fontProviderPackage);
        java.lang.String string3 = obtainAttributes.getString(androidx.core.R.styleable.FontFamily_fontProviderQuery);
        int resourceId = obtainAttributes.getResourceId(androidx.core.R.styleable.FontFamily_fontProviderCerts, 0);
        int integer = obtainAttributes.getInteger(androidx.core.R.styleable.FontFamily_fontProviderFetchStrategy, 1);
        int integer2 = obtainAttributes.getInteger(androidx.core.R.styleable.FontFamily_fontProviderFetchTimeout, 500);
        java.lang.String string4 = obtainAttributes.getString(androidx.core.R.styleable.FontFamily_fontProviderSystemFontFamily);
        obtainAttributes.recycle();
        if (string != null && string2 != null && string3 != null) {
            while (xmlPullParser.next() != 3) {
                skip(xmlPullParser);
            }
            return new androidx.core.content.res.FontResourcesParserCompat.ProviderResourceEntry(new androidx.core.provider.FontRequest(string, string2, string3, readCerts(resources, resourceId)), integer, integer2, string4);
        }
        java.util.ArrayList arrayList = new java.util.ArrayList();
        while (xmlPullParser.next() != 3) {
            if (xmlPullParser.getEventType() == 2) {
                if (xmlPullParser.getName().equals("font")) {
                    arrayList.add(readFont(xmlPullParser, resources));
                } else {
                    skip(xmlPullParser);
                }
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return new androidx.core.content.res.FontResourcesParserCompat.FontFamilyFilesResourceEntry((androidx.core.content.res.FontResourcesParserCompat.FontFileResourceEntry[]) arrayList.toArray(new androidx.core.content.res.FontResourcesParserCompat.FontFileResourceEntry[arrayList.size()]));
    }

    private static androidx.core.content.res.FontResourcesParserCompat.FontFileResourceEntry readFont(org.xmlpull.v1.XmlPullParser xmlPullParser, android.content.res.Resources resources) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        android.content.res.TypedArray obtainAttributes = resources.obtainAttributes(android.util.Xml.asAttributeSet(xmlPullParser), androidx.core.R.styleable.FontFamilyFont);
        int i = androidx.core.R.styleable.FontFamilyFont_fontWeight;
        if (!obtainAttributes.hasValue(i)) {
            i = androidx.core.R.styleable.FontFamilyFont_android_fontWeight;
        }
        int i2 = obtainAttributes.getInt(i, 400);
        int i3 = androidx.core.R.styleable.FontFamilyFont_fontStyle;
        if (!obtainAttributes.hasValue(i3)) {
            i3 = androidx.core.R.styleable.FontFamilyFont_android_fontStyle;
        }
        boolean z = 1 == obtainAttributes.getInt(i3, 0);
        int i4 = androidx.core.R.styleable.FontFamilyFont_ttcIndex;
        if (!obtainAttributes.hasValue(i4)) {
            i4 = androidx.core.R.styleable.FontFamilyFont_android_ttcIndex;
        }
        int i5 = androidx.core.R.styleable.FontFamilyFont_fontVariationSettings;
        if (!obtainAttributes.hasValue(i5)) {
            i5 = androidx.core.R.styleable.FontFamilyFont_android_fontVariationSettings;
        }
        java.lang.String string = obtainAttributes.getString(i5);
        int i6 = obtainAttributes.getInt(i4, 0);
        int i7 = androidx.core.R.styleable.FontFamilyFont_font;
        if (!obtainAttributes.hasValue(i7)) {
            i7 = androidx.core.R.styleable.FontFamilyFont_android_font;
        }
        int resourceId = obtainAttributes.getResourceId(i7, 0);
        java.lang.String string2 = obtainAttributes.getString(i7);
        obtainAttributes.recycle();
        while (xmlPullParser.next() != 3) {
            skip(xmlPullParser);
        }
        return new androidx.core.content.res.FontResourcesParserCompat.FontFileResourceEntry(string2, i2, z, string, i6, resourceId);
    }

    private static void skip(org.xmlpull.v1.XmlPullParser xmlPullParser) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        int i = 1;
        while (i > 0) {
            int next = xmlPullParser.next();
            if (next == 2) {
                i++;
            } else if (next == 3) {
                i--;
            }
        }
    }

    private static java.util.List<byte[]> toByteArrayList(java.lang.String[] strArr) {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        for (java.lang.String str : strArr) {
            arrayList.add(android.util.Base64.decode(str, 0));
        }
        return arrayList;
    }
}
