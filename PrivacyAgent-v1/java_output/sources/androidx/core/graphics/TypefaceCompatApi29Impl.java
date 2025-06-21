package androidx.core.graphics;

@androidx.annotation.RequiresApi(29)
@androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes.dex */
public class TypefaceCompatApi29Impl extends androidx.core.graphics.TypefaceCompatBaseImpl {
    @Override // androidx.core.graphics.TypefaceCompatBaseImpl
    @androidx.annotation.Nullable
    public android.graphics.Typeface createFromFontFamilyFilesResourceEntry(android.content.Context context, androidx.core.content.res.FontResourcesParserCompat.FontFamilyFilesResourceEntry fontFamilyFilesResourceEntry, android.content.res.Resources resources, int i) {
        android.graphics.fonts.FontFamily build;
        android.graphics.Typeface.CustomFallbackBuilder style;
        android.graphics.Typeface build2;
        android.graphics.fonts.Font.Builder weight;
        android.graphics.fonts.Font.Builder slant;
        android.graphics.fonts.Font.Builder ttcIndex;
        android.graphics.fonts.Font.Builder fontVariationSettings;
        android.graphics.fonts.Font build3;
        try {
            androidx.core.content.res.FontResourcesParserCompat.FontFileResourceEntry[] entries = fontFamilyFilesResourceEntry.getEntries();
            int length = entries.length;
            android.graphics.fonts.FontFamily.Builder builder = null;
            int i2 = 0;
            while (true) {
                int i3 = 1;
                if (i2 >= length) {
                    break;
                }
                androidx.core.content.res.FontResourcesParserCompat.FontFileResourceEntry fontFileResourceEntry = entries[i2];
                try {
                    weight = new android.graphics.fonts.Font.Builder(resources, fontFileResourceEntry.getResourceId()).setWeight(fontFileResourceEntry.getWeight());
                    if (!fontFileResourceEntry.isItalic()) {
                        i3 = 0;
                    }
                    slant = weight.setSlant(i3);
                    ttcIndex = slant.setTtcIndex(fontFileResourceEntry.getTtcIndex());
                    fontVariationSettings = ttcIndex.setFontVariationSettings(fontFileResourceEntry.getVariationSettings());
                    build3 = fontVariationSettings.build();
                    if (builder == null) {
                        builder = new android.graphics.fonts.FontFamily.Builder(build3);
                    } else {
                        builder.addFont(build3);
                    }
                } catch (java.io.IOException unused) {
                }
                i2++;
            }
            if (builder == null) {
                return null;
            }
            android.graphics.fonts.FontStyle fontStyle = new android.graphics.fonts.FontStyle((i & 1) != 0 ? 700 : 400, (i & 2) != 0 ? 1 : 0);
            build = builder.build();
            style = new android.graphics.Typeface.CustomFallbackBuilder(build).setStyle(fontStyle);
            build2 = style.build();
            return build2;
        } catch (java.lang.Exception unused2) {
            return null;
        }
    }

    @Override // androidx.core.graphics.TypefaceCompatBaseImpl
    @androidx.annotation.Nullable
    public android.graphics.Typeface createFromFontInfo(android.content.Context context, @androidx.annotation.Nullable android.os.CancellationSignal cancellationSignal, @androidx.annotation.NonNull androidx.core.provider.FontsContractCompat.FontInfo[] fontInfoArr, int i) {
        int i2;
        android.graphics.fonts.FontFamily build;
        android.graphics.Typeface.CustomFallbackBuilder style;
        android.graphics.Typeface build2;
        android.os.ParcelFileDescriptor openFileDescriptor;
        android.graphics.fonts.Font.Builder weight;
        android.graphics.fonts.Font.Builder slant;
        android.graphics.fonts.Font.Builder ttcIndex;
        android.graphics.fonts.Font build3;
        android.content.ContentResolver contentResolver = context.getContentResolver();
        try {
            int length = fontInfoArr.length;
            android.graphics.fonts.FontFamily.Builder builder = null;
            while (true) {
                int i3 = 1;
                if (i2 >= length) {
                    if (builder == null) {
                        return null;
                    }
                    android.graphics.fonts.FontStyle fontStyle = new android.graphics.fonts.FontStyle((i & 1) != 0 ? 700 : 400, (i & 2) != 0 ? 1 : 0);
                    build = builder.build();
                    style = new android.graphics.Typeface.CustomFallbackBuilder(build).setStyle(fontStyle);
                    build2 = style.build();
                    return build2;
                }
                androidx.core.provider.FontsContractCompat.FontInfo fontInfo = fontInfoArr[i2];
                try {
                    openFileDescriptor = contentResolver.openFileDescriptor(fontInfo.getUri(), "r", cancellationSignal);
                } catch (java.io.IOException unused) {
                }
                if (openFileDescriptor == null) {
                    i2 = openFileDescriptor == null ? i2 + 1 : 0;
                } else {
                    try {
                        weight = new android.graphics.fonts.Font.Builder(openFileDescriptor).setWeight(fontInfo.getWeight());
                        if (!fontInfo.isItalic()) {
                            i3 = 0;
                        }
                        slant = weight.setSlant(i3);
                        ttcIndex = slant.setTtcIndex(fontInfo.getTtcIndex());
                        build3 = ttcIndex.build();
                        if (builder == null) {
                            builder = new android.graphics.fonts.FontFamily.Builder(build3);
                        } else {
                            builder.addFont(build3);
                        }
                    } catch (java.lang.Throwable th) {
                        try {
                            openFileDescriptor.close();
                        } catch (java.lang.Throwable th2) {
                            th.addSuppressed(th2);
                        }
                        throw th;
                    }
                }
                openFileDescriptor.close();
            }
        } catch (java.lang.Exception unused2) {
            return null;
        }
    }

    @Override // androidx.core.graphics.TypefaceCompatBaseImpl
    public android.graphics.Typeface createFromInputStream(android.content.Context context, java.io.InputStream inputStream) {
        throw new java.lang.RuntimeException("Do not use this function in API 29 or later.");
    }

    @Override // androidx.core.graphics.TypefaceCompatBaseImpl
    @androidx.annotation.Nullable
    public android.graphics.Typeface createFromResourcesFontFile(android.content.Context context, android.content.res.Resources resources, int i, java.lang.String str, int i2) {
        android.graphics.fonts.Font build;
        android.graphics.fonts.FontFamily build2;
        android.graphics.fonts.FontStyle style;
        android.graphics.Typeface.CustomFallbackBuilder style2;
        android.graphics.Typeface build3;
        try {
            build = new android.graphics.fonts.Font.Builder(resources, i).build();
            build2 = new android.graphics.fonts.FontFamily.Builder(build).build();
            android.graphics.Typeface.CustomFallbackBuilder customFallbackBuilder = new android.graphics.Typeface.CustomFallbackBuilder(build2);
            style = build.getStyle();
            style2 = customFallbackBuilder.setStyle(style);
            build3 = style2.build();
            return build3;
        } catch (java.lang.Exception unused) {
            return null;
        }
    }

    @Override // androidx.core.graphics.TypefaceCompatBaseImpl
    public androidx.core.provider.FontsContractCompat.FontInfo findBestInfo(androidx.core.provider.FontsContractCompat.FontInfo[] fontInfoArr, int i) {
        throw new java.lang.RuntimeException("Do not use this function in API 29 or later.");
    }
}
