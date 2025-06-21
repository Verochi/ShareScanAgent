package androidx.core.graphics;

@androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
class TypefaceCompatBaseImpl {
    private static final int INVALID_KEY = 0;
    private static final java.lang.String TAG = "TypefaceCompatBaseImpl";

    @android.annotation.SuppressLint({"BanConcurrentHashMap"})
    private java.util.concurrent.ConcurrentHashMap<java.lang.Long, androidx.core.content.res.FontResourcesParserCompat.FontFamilyFilesResourceEntry> mFontFamilies = new java.util.concurrent.ConcurrentHashMap<>();

    /* renamed from: androidx.core.graphics.TypefaceCompatBaseImpl$1, reason: invalid class name */
    public class AnonymousClass1 implements androidx.core.graphics.TypefaceCompatBaseImpl.StyleExtractor<androidx.core.provider.FontsContractCompat.FontInfo> {
        public AnonymousClass1() {
        }

        @Override // androidx.core.graphics.TypefaceCompatBaseImpl.StyleExtractor
        public int getWeight(androidx.core.provider.FontsContractCompat.FontInfo fontInfo) {
            return fontInfo.getWeight();
        }

        @Override // androidx.core.graphics.TypefaceCompatBaseImpl.StyleExtractor
        public boolean isItalic(androidx.core.provider.FontsContractCompat.FontInfo fontInfo) {
            return fontInfo.isItalic();
        }
    }

    /* renamed from: androidx.core.graphics.TypefaceCompatBaseImpl$2, reason: invalid class name */
    public class AnonymousClass2 implements androidx.core.graphics.TypefaceCompatBaseImpl.StyleExtractor<androidx.core.content.res.FontResourcesParserCompat.FontFileResourceEntry> {
        public AnonymousClass2() {
        }

        @Override // androidx.core.graphics.TypefaceCompatBaseImpl.StyleExtractor
        public int getWeight(androidx.core.content.res.FontResourcesParserCompat.FontFileResourceEntry fontFileResourceEntry) {
            return fontFileResourceEntry.getWeight();
        }

        @Override // androidx.core.graphics.TypefaceCompatBaseImpl.StyleExtractor
        public boolean isItalic(androidx.core.content.res.FontResourcesParserCompat.FontFileResourceEntry fontFileResourceEntry) {
            return fontFileResourceEntry.isItalic();
        }
    }

    public interface StyleExtractor<T> {
        int getWeight(T t);

        boolean isItalic(T t);
    }

    private void addFontFamily(android.graphics.Typeface typeface, androidx.core.content.res.FontResourcesParserCompat.FontFamilyFilesResourceEntry fontFamilyFilesResourceEntry) {
        long uniqueKey = getUniqueKey(typeface);
        if (uniqueKey != 0) {
            this.mFontFamilies.put(java.lang.Long.valueOf(uniqueKey), fontFamilyFilesResourceEntry);
        }
    }

    private androidx.core.content.res.FontResourcesParserCompat.FontFileResourceEntry findBestEntry(androidx.core.content.res.FontResourcesParserCompat.FontFamilyFilesResourceEntry fontFamilyFilesResourceEntry, int i) {
        return (androidx.core.content.res.FontResourcesParserCompat.FontFileResourceEntry) findBestFont(fontFamilyFilesResourceEntry.getEntries(), i, new androidx.core.graphics.TypefaceCompatBaseImpl.AnonymousClass2());
    }

    private static <T> T findBestFont(T[] tArr, int i, androidx.core.graphics.TypefaceCompatBaseImpl.StyleExtractor<T> styleExtractor) {
        int i2 = (i & 1) == 0 ? 400 : 700;
        boolean z = (i & 2) != 0;
        T t = null;
        int i3 = Integer.MAX_VALUE;
        for (T t2 : tArr) {
            int abs = (java.lang.Math.abs(styleExtractor.getWeight(t2) - i2) * 2) + (styleExtractor.isItalic(t2) == z ? 0 : 1);
            if (t == null || i3 > abs) {
                t = t2;
                i3 = abs;
            }
        }
        return t;
    }

    private static long getUniqueKey(@androidx.annotation.Nullable android.graphics.Typeface typeface) {
        if (typeface == null) {
            return 0L;
        }
        try {
            java.lang.reflect.Field declaredField = android.graphics.Typeface.class.getDeclaredField("native_instance");
            declaredField.setAccessible(true);
            return ((java.lang.Number) declaredField.get(typeface)).longValue();
        } catch (java.lang.IllegalAccessException | java.lang.NoSuchFieldException unused) {
            return 0L;
        }
    }

    @androidx.annotation.Nullable
    public android.graphics.Typeface createFromFontFamilyFilesResourceEntry(android.content.Context context, androidx.core.content.res.FontResourcesParserCompat.FontFamilyFilesResourceEntry fontFamilyFilesResourceEntry, android.content.res.Resources resources, int i) {
        androidx.core.content.res.FontResourcesParserCompat.FontFileResourceEntry findBestEntry = findBestEntry(fontFamilyFilesResourceEntry, i);
        if (findBestEntry == null) {
            return null;
        }
        android.graphics.Typeface createFromResourcesFontFile = androidx.core.graphics.TypefaceCompat.createFromResourcesFontFile(context, resources, findBestEntry.getResourceId(), findBestEntry.getFileName(), i);
        addFontFamily(createFromResourcesFontFile, fontFamilyFilesResourceEntry);
        return createFromResourcesFontFile;
    }

    @androidx.annotation.Nullable
    public android.graphics.Typeface createFromFontInfo(android.content.Context context, @androidx.annotation.Nullable android.os.CancellationSignal cancellationSignal, @androidx.annotation.NonNull androidx.core.provider.FontsContractCompat.FontInfo[] fontInfoArr, int i) {
        java.io.InputStream inputStream;
        java.io.InputStream inputStream2 = null;
        if (fontInfoArr.length < 1) {
            return null;
        }
        try {
            inputStream = context.getContentResolver().openInputStream(findBestInfo(fontInfoArr, i).getUri());
        } catch (java.io.IOException unused) {
            inputStream = null;
        } catch (java.lang.Throwable th) {
            th = th;
        }
        try {
            android.graphics.Typeface createFromInputStream = createFromInputStream(context, inputStream);
            androidx.core.graphics.TypefaceCompatUtil.closeQuietly(inputStream);
            return createFromInputStream;
        } catch (java.io.IOException unused2) {
            androidx.core.graphics.TypefaceCompatUtil.closeQuietly(inputStream);
            return null;
        } catch (java.lang.Throwable th2) {
            th = th2;
            inputStream2 = inputStream;
            androidx.core.graphics.TypefaceCompatUtil.closeQuietly(inputStream2);
            throw th;
        }
    }

    public android.graphics.Typeface createFromInputStream(android.content.Context context, java.io.InputStream inputStream) {
        java.io.File tempFile = androidx.core.graphics.TypefaceCompatUtil.getTempFile(context);
        if (tempFile == null) {
            return null;
        }
        try {
            if (androidx.core.graphics.TypefaceCompatUtil.copyToFile(tempFile, inputStream)) {
                return android.graphics.Typeface.createFromFile(tempFile.getPath());
            }
            return null;
        } catch (java.lang.RuntimeException unused) {
            return null;
        } finally {
            tempFile.delete();
        }
    }

    @androidx.annotation.Nullable
    public android.graphics.Typeface createFromResourcesFontFile(android.content.Context context, android.content.res.Resources resources, int i, java.lang.String str, int i2) {
        java.io.File tempFile = androidx.core.graphics.TypefaceCompatUtil.getTempFile(context);
        if (tempFile == null) {
            return null;
        }
        try {
            if (androidx.core.graphics.TypefaceCompatUtil.copyToFile(tempFile, resources, i)) {
                return android.graphics.Typeface.createFromFile(tempFile.getPath());
            }
            return null;
        } catch (java.lang.RuntimeException unused) {
            return null;
        } finally {
            tempFile.delete();
        }
    }

    public androidx.core.provider.FontsContractCompat.FontInfo findBestInfo(androidx.core.provider.FontsContractCompat.FontInfo[] fontInfoArr, int i) {
        return (androidx.core.provider.FontsContractCompat.FontInfo) findBestFont(fontInfoArr, i, new androidx.core.graphics.TypefaceCompatBaseImpl.AnonymousClass1());
    }

    @androidx.annotation.Nullable
    public androidx.core.content.res.FontResourcesParserCompat.FontFamilyFilesResourceEntry getFontFamily(android.graphics.Typeface typeface) {
        long uniqueKey = getUniqueKey(typeface);
        if (uniqueKey == 0) {
            return null;
        }
        return this.mFontFamilies.get(java.lang.Long.valueOf(uniqueKey));
    }
}
