package androidx.core.graphics;

@android.annotation.SuppressLint({"NewApi"})
/* loaded from: classes.dex */
public class TypefaceCompat {
    private static final androidx.collection.LruCache<java.lang.String, android.graphics.Typeface> sTypefaceCache;
    private static final androidx.core.graphics.TypefaceCompatBaseImpl sTypefaceCompatImpl;

    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY})
    public static class ResourcesCallbackAdapter extends androidx.core.provider.FontsContractCompat.FontRequestCallback {

        @androidx.annotation.Nullable
        private androidx.core.content.res.ResourcesCompat.FontCallback mFontCallback;

        public ResourcesCallbackAdapter(@androidx.annotation.Nullable androidx.core.content.res.ResourcesCompat.FontCallback fontCallback) {
            this.mFontCallback = fontCallback;
        }

        @Override // androidx.core.provider.FontsContractCompat.FontRequestCallback
        public void onTypefaceRequestFailed(int i) {
            androidx.core.content.res.ResourcesCompat.FontCallback fontCallback = this.mFontCallback;
            if (fontCallback != null) {
                fontCallback.onFontRetrievalFailed(i);
            }
        }

        @Override // androidx.core.provider.FontsContractCompat.FontRequestCallback
        public void onTypefaceRetrieved(@androidx.annotation.NonNull android.graphics.Typeface typeface) {
            androidx.core.content.res.ResourcesCompat.FontCallback fontCallback = this.mFontCallback;
            if (fontCallback != null) {
                fontCallback.onFontRetrieved(typeface);
            }
        }
    }

    static {
        int i = android.os.Build.VERSION.SDK_INT;
        if (i >= 29) {
            sTypefaceCompatImpl = new androidx.core.graphics.TypefaceCompatApi29Impl();
        } else if (i >= 28) {
            sTypefaceCompatImpl = new androidx.core.graphics.TypefaceCompatApi28Impl();
        } else if (i >= 26) {
            sTypefaceCompatImpl = new androidx.core.graphics.TypefaceCompatApi26Impl();
        } else if (i < 24 || !androidx.core.graphics.TypefaceCompatApi24Impl.isUsable()) {
            sTypefaceCompatImpl = new androidx.core.graphics.TypefaceCompatApi21Impl();
        } else {
            sTypefaceCompatImpl = new androidx.core.graphics.TypefaceCompatApi24Impl();
        }
        sTypefaceCache = new androidx.collection.LruCache<>(16);
    }

    private TypefaceCompat() {
    }

    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @androidx.annotation.VisibleForTesting
    public static void clearCache() {
        sTypefaceCache.evictAll();
    }

    @androidx.annotation.NonNull
    public static android.graphics.Typeface create(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.Nullable android.graphics.Typeface typeface, int i) {
        if (context != null) {
            return android.graphics.Typeface.create(typeface, i);
        }
        throw new java.lang.IllegalArgumentException("Context cannot be null");
    }

    @androidx.annotation.Nullable
    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static android.graphics.Typeface createFromFontInfo(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.Nullable android.os.CancellationSignal cancellationSignal, @androidx.annotation.NonNull androidx.core.provider.FontsContractCompat.FontInfo[] fontInfoArr, int i) {
        return sTypefaceCompatImpl.createFromFontInfo(context, cancellationSignal, fontInfoArr, i);
    }

    @androidx.annotation.Nullable
    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static android.graphics.Typeface createFromResourcesFamilyXml(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.NonNull androidx.core.content.res.FontResourcesParserCompat.FamilyResourceEntry familyResourceEntry, @androidx.annotation.NonNull android.content.res.Resources resources, int i, int i2, @androidx.annotation.Nullable androidx.core.content.res.ResourcesCompat.FontCallback fontCallback, @androidx.annotation.Nullable android.os.Handler handler, boolean z) {
        android.graphics.Typeface createFromFontFamilyFilesResourceEntry;
        if (familyResourceEntry instanceof androidx.core.content.res.FontResourcesParserCompat.ProviderResourceEntry) {
            androidx.core.content.res.FontResourcesParserCompat.ProviderResourceEntry providerResourceEntry = (androidx.core.content.res.FontResourcesParserCompat.ProviderResourceEntry) familyResourceEntry;
            android.graphics.Typeface systemFontFamily = getSystemFontFamily(providerResourceEntry.getSystemFontFamilyName());
            if (systemFontFamily != null) {
                if (fontCallback != null) {
                    fontCallback.callbackSuccessAsync(systemFontFamily, handler);
                }
                return systemFontFamily;
            }
            createFromFontFamilyFilesResourceEntry = androidx.core.provider.FontsContractCompat.requestFont(context, providerResourceEntry.getRequest(), i2, !z ? fontCallback != null : providerResourceEntry.getFetchStrategy() != 0, z ? providerResourceEntry.getTimeout() : -1, androidx.core.content.res.ResourcesCompat.FontCallback.getHandler(handler), new androidx.core.graphics.TypefaceCompat.ResourcesCallbackAdapter(fontCallback));
        } else {
            createFromFontFamilyFilesResourceEntry = sTypefaceCompatImpl.createFromFontFamilyFilesResourceEntry(context, (androidx.core.content.res.FontResourcesParserCompat.FontFamilyFilesResourceEntry) familyResourceEntry, resources, i2);
            if (fontCallback != null) {
                if (createFromFontFamilyFilesResourceEntry != null) {
                    fontCallback.callbackSuccessAsync(createFromFontFamilyFilesResourceEntry, handler);
                } else {
                    fontCallback.callbackFailAsync(-3, handler);
                }
            }
        }
        if (createFromFontFamilyFilesResourceEntry != null) {
            sTypefaceCache.put(createResourceUid(resources, i, i2), createFromFontFamilyFilesResourceEntry);
        }
        return createFromFontFamilyFilesResourceEntry;
    }

    @androidx.annotation.Nullable
    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static android.graphics.Typeface createFromResourcesFontFile(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.NonNull android.content.res.Resources resources, int i, java.lang.String str, int i2) {
        android.graphics.Typeface createFromResourcesFontFile = sTypefaceCompatImpl.createFromResourcesFontFile(context, resources, i, str, i2);
        if (createFromResourcesFontFile != null) {
            sTypefaceCache.put(createResourceUid(resources, i, i2), createFromResourcesFontFile);
        }
        return createFromResourcesFontFile;
    }

    private static java.lang.String createResourceUid(android.content.res.Resources resources, int i, int i2) {
        return resources.getResourcePackageName(i) + com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER + i + com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER + i2;
    }

    @androidx.annotation.Nullable
    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static android.graphics.Typeface findFromCache(@androidx.annotation.NonNull android.content.res.Resources resources, int i, int i2) {
        return sTypefaceCache.get(createResourceUid(resources, i, i2));
    }

    @androidx.annotation.Nullable
    private static android.graphics.Typeface getBestFontFromFamily(android.content.Context context, android.graphics.Typeface typeface, int i) {
        androidx.core.graphics.TypefaceCompatBaseImpl typefaceCompatBaseImpl = sTypefaceCompatImpl;
        androidx.core.content.res.FontResourcesParserCompat.FontFamilyFilesResourceEntry fontFamily = typefaceCompatBaseImpl.getFontFamily(typeface);
        if (fontFamily == null) {
            return null;
        }
        return typefaceCompatBaseImpl.createFromFontFamilyFilesResourceEntry(context, fontFamily, context.getResources(), i);
    }

    private static android.graphics.Typeface getSystemFontFamily(@androidx.annotation.Nullable java.lang.String str) {
        if (str == null || str.isEmpty()) {
            return null;
        }
        android.graphics.Typeface create = android.graphics.Typeface.create(str, 0);
        android.graphics.Typeface create2 = android.graphics.Typeface.create(android.graphics.Typeface.DEFAULT, 0);
        if (create == null || create.equals(create2)) {
            return null;
        }
        return create;
    }
}
