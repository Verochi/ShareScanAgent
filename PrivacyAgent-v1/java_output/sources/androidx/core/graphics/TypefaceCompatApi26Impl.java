package androidx.core.graphics;

@androidx.annotation.RequiresApi(26)
@androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
public class TypefaceCompatApi26Impl extends androidx.core.graphics.TypefaceCompatApi21Impl {
    private static final java.lang.String ABORT_CREATION_METHOD = "abortCreation";
    private static final java.lang.String ADD_FONT_FROM_ASSET_MANAGER_METHOD = "addFontFromAssetManager";
    private static final java.lang.String ADD_FONT_FROM_BUFFER_METHOD = "addFontFromBuffer";
    private static final java.lang.String CREATE_FROM_FAMILIES_WITH_DEFAULT_METHOD = "createFromFamiliesWithDefault";
    private static final java.lang.String FONT_FAMILY_CLASS = "android.graphics.FontFamily";
    private static final java.lang.String FREEZE_METHOD = "freeze";
    private static final int RESOLVE_BY_FONT_TABLE = -1;
    private static final java.lang.String TAG = "TypefaceCompatApi26Impl";
    protected final java.lang.reflect.Method mAbortCreation;
    protected final java.lang.reflect.Method mAddFontFromAssetManager;
    protected final java.lang.reflect.Method mAddFontFromBuffer;
    protected final java.lang.reflect.Method mCreateFromFamiliesWithDefault;
    protected final java.lang.Class<?> mFontFamily;
    protected final java.lang.reflect.Constructor<?> mFontFamilyCtor;
    protected final java.lang.reflect.Method mFreeze;

    public TypefaceCompatApi26Impl() {
        java.lang.Class<?> cls;
        java.lang.reflect.Constructor<?> constructor;
        java.lang.reflect.Method method;
        java.lang.reflect.Method method2;
        java.lang.reflect.Method method3;
        java.lang.reflect.Method method4;
        java.lang.reflect.Method method5;
        try {
            cls = obtainFontFamily();
            constructor = obtainFontFamilyCtor(cls);
            method = obtainAddFontFromAssetManagerMethod(cls);
            method2 = obtainAddFontFromBufferMethod(cls);
            method3 = obtainFreezeMethod(cls);
            method4 = obtainAbortCreationMethod(cls);
            method5 = obtainCreateFromFamiliesWithDefaultMethod(cls);
        } catch (java.lang.ClassNotFoundException | java.lang.NoSuchMethodException e) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("Unable to collect necessary methods for class ");
            sb.append(e.getClass().getName());
            cls = null;
            constructor = null;
            method = null;
            method2 = null;
            method3 = null;
            method4 = null;
            method5 = null;
        }
        this.mFontFamily = cls;
        this.mFontFamilyCtor = constructor;
        this.mAddFontFromAssetManager = method;
        this.mAddFontFromBuffer = method2;
        this.mFreeze = method3;
        this.mAbortCreation = method4;
        this.mCreateFromFamiliesWithDefault = method5;
    }

    private void abortCreation(java.lang.Object obj) {
        try {
            this.mAbortCreation.invoke(obj, new java.lang.Object[0]);
        } catch (java.lang.IllegalAccessException | java.lang.reflect.InvocationTargetException unused) {
        }
    }

    private boolean addFontFromAssetManager(android.content.Context context, java.lang.Object obj, java.lang.String str, int i, int i2, int i3, @androidx.annotation.Nullable android.graphics.fonts.FontVariationAxis[] fontVariationAxisArr) {
        try {
            return ((java.lang.Boolean) this.mAddFontFromAssetManager.invoke(obj, context.getAssets(), str, 0, java.lang.Boolean.FALSE, java.lang.Integer.valueOf(i), java.lang.Integer.valueOf(i2), java.lang.Integer.valueOf(i3), fontVariationAxisArr)).booleanValue();
        } catch (java.lang.IllegalAccessException | java.lang.reflect.InvocationTargetException unused) {
            return false;
        }
    }

    private boolean addFontFromBuffer(java.lang.Object obj, java.nio.ByteBuffer byteBuffer, int i, int i2, int i3) {
        try {
            return ((java.lang.Boolean) this.mAddFontFromBuffer.invoke(obj, byteBuffer, java.lang.Integer.valueOf(i), null, java.lang.Integer.valueOf(i2), java.lang.Integer.valueOf(i3))).booleanValue();
        } catch (java.lang.IllegalAccessException | java.lang.reflect.InvocationTargetException unused) {
            return false;
        }
    }

    private boolean freeze(java.lang.Object obj) {
        try {
            return ((java.lang.Boolean) this.mFreeze.invoke(obj, new java.lang.Object[0])).booleanValue();
        } catch (java.lang.IllegalAccessException | java.lang.reflect.InvocationTargetException unused) {
            return false;
        }
    }

    private boolean isFontFamilyPrivateAPIAvailable() {
        return this.mAddFontFromAssetManager != null;
    }

    @androidx.annotation.Nullable
    private java.lang.Object newFamily() {
        try {
            return this.mFontFamilyCtor.newInstance(new java.lang.Object[0]);
        } catch (java.lang.IllegalAccessException | java.lang.InstantiationException | java.lang.reflect.InvocationTargetException unused) {
            return null;
        }
    }

    @androidx.annotation.Nullable
    public android.graphics.Typeface createFromFamiliesWithDefault(java.lang.Object obj) {
        try {
            java.lang.Object newInstance = java.lang.reflect.Array.newInstance(this.mFontFamily, 1);
            java.lang.reflect.Array.set(newInstance, 0, obj);
            return (android.graphics.Typeface) this.mCreateFromFamiliesWithDefault.invoke(null, newInstance, -1, -1);
        } catch (java.lang.IllegalAccessException | java.lang.reflect.InvocationTargetException unused) {
            return null;
        }
    }

    @Override // androidx.core.graphics.TypefaceCompatApi21Impl, androidx.core.graphics.TypefaceCompatBaseImpl
    @androidx.annotation.Nullable
    public android.graphics.Typeface createFromFontFamilyFilesResourceEntry(android.content.Context context, androidx.core.content.res.FontResourcesParserCompat.FontFamilyFilesResourceEntry fontFamilyFilesResourceEntry, android.content.res.Resources resources, int i) {
        android.graphics.fonts.FontVariationAxis[] fromFontVariationSettings;
        if (!isFontFamilyPrivateAPIAvailable()) {
            return super.createFromFontFamilyFilesResourceEntry(context, fontFamilyFilesResourceEntry, resources, i);
        }
        java.lang.Object newFamily = newFamily();
        if (newFamily == null) {
            return null;
        }
        for (androidx.core.content.res.FontResourcesParserCompat.FontFileResourceEntry fontFileResourceEntry : fontFamilyFilesResourceEntry.getEntries()) {
            java.lang.String fileName = fontFileResourceEntry.getFileName();
            int ttcIndex = fontFileResourceEntry.getTtcIndex();
            int weight = fontFileResourceEntry.getWeight();
            boolean isItalic = fontFileResourceEntry.isItalic();
            fromFontVariationSettings = android.graphics.fonts.FontVariationAxis.fromFontVariationSettings(fontFileResourceEntry.getVariationSettings());
            if (!addFontFromAssetManager(context, newFamily, fileName, ttcIndex, weight, isItalic ? 1 : 0, fromFontVariationSettings)) {
                abortCreation(newFamily);
                return null;
            }
        }
        if (freeze(newFamily)) {
            return createFromFamiliesWithDefault(newFamily);
        }
        return null;
    }

    @Override // androidx.core.graphics.TypefaceCompatApi21Impl, androidx.core.graphics.TypefaceCompatBaseImpl
    @androidx.annotation.Nullable
    public android.graphics.Typeface createFromFontInfo(android.content.Context context, @androidx.annotation.Nullable android.os.CancellationSignal cancellationSignal, @androidx.annotation.NonNull androidx.core.provider.FontsContractCompat.FontInfo[] fontInfoArr, int i) {
        android.graphics.Typeface createFromFamiliesWithDefault;
        android.graphics.Typeface.Builder weight;
        android.graphics.Typeface.Builder italic;
        android.graphics.Typeface build;
        if (fontInfoArr.length < 1) {
            return null;
        }
        if (!isFontFamilyPrivateAPIAvailable()) {
            androidx.core.provider.FontsContractCompat.FontInfo findBestInfo = findBestInfo(fontInfoArr, i);
            try {
                android.os.ParcelFileDescriptor openFileDescriptor = context.getContentResolver().openFileDescriptor(findBestInfo.getUri(), "r", cancellationSignal);
                if (openFileDescriptor == null) {
                    if (openFileDescriptor != null) {
                        openFileDescriptor.close();
                    }
                    return null;
                }
                try {
                    weight = new android.graphics.Typeface.Builder(openFileDescriptor.getFileDescriptor()).setWeight(findBestInfo.getWeight());
                    italic = weight.setItalic(findBestInfo.isItalic());
                    build = italic.build();
                    openFileDescriptor.close();
                    return build;
                } finally {
                }
            } catch (java.io.IOException unused) {
                return null;
            }
        }
        java.util.Map<android.net.Uri, java.nio.ByteBuffer> readFontInfoIntoByteBuffer = androidx.core.graphics.TypefaceCompatUtil.readFontInfoIntoByteBuffer(context, fontInfoArr, cancellationSignal);
        java.lang.Object newFamily = newFamily();
        if (newFamily == null) {
            return null;
        }
        boolean z = false;
        for (androidx.core.provider.FontsContractCompat.FontInfo fontInfo : fontInfoArr) {
            java.nio.ByteBuffer byteBuffer = readFontInfoIntoByteBuffer.get(fontInfo.getUri());
            if (byteBuffer != null) {
                if (!addFontFromBuffer(newFamily, byteBuffer, fontInfo.getTtcIndex(), fontInfo.getWeight(), fontInfo.isItalic() ? 1 : 0)) {
                    abortCreation(newFamily);
                    return null;
                }
                z = true;
            }
        }
        if (!z) {
            abortCreation(newFamily);
            return null;
        }
        if (freeze(newFamily) && (createFromFamiliesWithDefault = createFromFamiliesWithDefault(newFamily)) != null) {
            return android.graphics.Typeface.create(createFromFamiliesWithDefault, i);
        }
        return null;
    }

    @Override // androidx.core.graphics.TypefaceCompatBaseImpl
    @androidx.annotation.Nullable
    public android.graphics.Typeface createFromResourcesFontFile(android.content.Context context, android.content.res.Resources resources, int i, java.lang.String str, int i2) {
        if (!isFontFamilyPrivateAPIAvailable()) {
            return super.createFromResourcesFontFile(context, resources, i, str, i2);
        }
        java.lang.Object newFamily = newFamily();
        if (newFamily == null) {
            return null;
        }
        if (!addFontFromAssetManager(context, newFamily, str, 0, -1, -1, null)) {
            abortCreation(newFamily);
            return null;
        }
        if (freeze(newFamily)) {
            return createFromFamiliesWithDefault(newFamily);
        }
        return null;
    }

    public java.lang.reflect.Method obtainAbortCreationMethod(java.lang.Class<?> cls) throws java.lang.NoSuchMethodException {
        return cls.getMethod(ABORT_CREATION_METHOD, new java.lang.Class[0]);
    }

    public java.lang.reflect.Method obtainAddFontFromAssetManagerMethod(java.lang.Class<?> cls) throws java.lang.NoSuchMethodException {
        java.lang.Class<?> cls2 = java.lang.Integer.TYPE;
        return cls.getMethod(ADD_FONT_FROM_ASSET_MANAGER_METHOD, android.content.res.AssetManager.class, java.lang.String.class, cls2, java.lang.Boolean.TYPE, cls2, cls2, cls2, android.graphics.fonts.FontVariationAxis[].class);
    }

    public java.lang.reflect.Method obtainAddFontFromBufferMethod(java.lang.Class<?> cls) throws java.lang.NoSuchMethodException {
        java.lang.Class<?> cls2 = java.lang.Integer.TYPE;
        return cls.getMethod(ADD_FONT_FROM_BUFFER_METHOD, java.nio.ByteBuffer.class, cls2, android.graphics.fonts.FontVariationAxis[].class, cls2, cls2);
    }

    public java.lang.reflect.Method obtainCreateFromFamiliesWithDefaultMethod(java.lang.Class<?> cls) throws java.lang.NoSuchMethodException {
        java.lang.Class cls2 = java.lang.Integer.TYPE;
        java.lang.reflect.Method declaredMethod = android.graphics.Typeface.class.getDeclaredMethod(CREATE_FROM_FAMILIES_WITH_DEFAULT_METHOD, java.lang.reflect.Array.newInstance(cls, 1).getClass(), cls2, cls2);
        declaredMethod.setAccessible(true);
        return declaredMethod;
    }

    public java.lang.Class<?> obtainFontFamily() throws java.lang.ClassNotFoundException {
        return java.lang.Class.forName(FONT_FAMILY_CLASS);
    }

    public java.lang.reflect.Constructor<?> obtainFontFamilyCtor(java.lang.Class<?> cls) throws java.lang.NoSuchMethodException {
        return cls.getConstructor(new java.lang.Class[0]);
    }

    public java.lang.reflect.Method obtainFreezeMethod(java.lang.Class<?> cls) throws java.lang.NoSuchMethodException {
        return cls.getMethod(FREEZE_METHOD, new java.lang.Class[0]);
    }
}
