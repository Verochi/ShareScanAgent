package androidx.core.content.res;

/* loaded from: classes.dex */
public final class ResourcesCompat {

    @androidx.annotation.AnyRes
    public static final int ID_NULL = 0;
    private static final java.lang.String TAG = "ResourcesCompat";

    public static abstract class FontCallback {

        /* renamed from: androidx.core.content.res.ResourcesCompat$FontCallback$1, reason: invalid class name */
        public class AnonymousClass1 implements java.lang.Runnable {
            final /* synthetic */ android.graphics.Typeface val$typeface;

            public AnonymousClass1(android.graphics.Typeface typeface) {
                this.val$typeface = typeface;
            }

            @Override // java.lang.Runnable
            public void run() {
                androidx.core.content.res.ResourcesCompat.FontCallback.this.onFontRetrieved(this.val$typeface);
            }
        }

        /* renamed from: androidx.core.content.res.ResourcesCompat$FontCallback$2, reason: invalid class name */
        public class AnonymousClass2 implements java.lang.Runnable {
            final /* synthetic */ int val$reason;

            public AnonymousClass2(int i) {
                this.val$reason = i;
            }

            @Override // java.lang.Runnable
            public void run() {
                androidx.core.content.res.ResourcesCompat.FontCallback.this.onFontRetrievalFailed(this.val$reason);
            }
        }

        @androidx.annotation.NonNull
        @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY})
        public static android.os.Handler getHandler(@androidx.annotation.Nullable android.os.Handler handler) {
            return handler == null ? new android.os.Handler(android.os.Looper.getMainLooper()) : handler;
        }

        @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public final void callbackFailAsync(int i, @androidx.annotation.Nullable android.os.Handler handler) {
            getHandler(handler).post(new androidx.core.content.res.ResourcesCompat.FontCallback.AnonymousClass2(i));
        }

        @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public final void callbackSuccessAsync(android.graphics.Typeface typeface, @androidx.annotation.Nullable android.os.Handler handler) {
            getHandler(handler).post(new androidx.core.content.res.ResourcesCompat.FontCallback.AnonymousClass1(typeface));
        }

        public abstract void onFontRetrievalFailed(int i);

        public abstract void onFontRetrieved(@androidx.annotation.NonNull android.graphics.Typeface typeface);
    }

    public static final class ThemeCompat {

        @androidx.annotation.RequiresApi(23)
        public static class ImplApi23 {
            private static java.lang.reflect.Method sRebaseMethod;
            private static boolean sRebaseMethodFetched;
            private static final java.lang.Object sRebaseMethodLock = new java.lang.Object();

            private ImplApi23() {
            }

            public static void rebase(@androidx.annotation.NonNull android.content.res.Resources.Theme theme) {
                synchronized (sRebaseMethodLock) {
                    if (!sRebaseMethodFetched) {
                        try {
                            java.lang.reflect.Method declaredMethod = android.content.res.Resources.Theme.class.getDeclaredMethod("rebase", new java.lang.Class[0]);
                            sRebaseMethod = declaredMethod;
                            declaredMethod.setAccessible(true);
                        } catch (java.lang.NoSuchMethodException unused) {
                        }
                        sRebaseMethodFetched = true;
                    }
                    java.lang.reflect.Method method = sRebaseMethod;
                    if (method != null) {
                        try {
                            method.invoke(theme, new java.lang.Object[0]);
                        } catch (java.lang.IllegalAccessException | java.lang.reflect.InvocationTargetException unused2) {
                            sRebaseMethod = null;
                        }
                    }
                }
            }
        }

        @androidx.annotation.RequiresApi(29)
        public static class ImplApi29 {
            private ImplApi29() {
            }

            public static void rebase(@androidx.annotation.NonNull android.content.res.Resources.Theme theme) {
                theme.rebase();
            }
        }

        private ThemeCompat() {
        }

        public static void rebase(@androidx.annotation.NonNull android.content.res.Resources.Theme theme) {
            int i = android.os.Build.VERSION.SDK_INT;
            if (i >= 29) {
                androidx.core.content.res.ResourcesCompat.ThemeCompat.ImplApi29.rebase(theme);
            } else if (i >= 23) {
                androidx.core.content.res.ResourcesCompat.ThemeCompat.ImplApi23.rebase(theme);
            }
        }
    }

    private ResourcesCompat() {
    }

    @androidx.annotation.Nullable
    public static android.graphics.Typeface getCachedFont(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.FontRes int i) throws android.content.res.Resources.NotFoundException {
        if (context.isRestricted()) {
            return null;
        }
        return loadFont(context, i, new android.util.TypedValue(), 0, null, null, false, true);
    }

    @androidx.annotation.ColorInt
    public static int getColor(@androidx.annotation.NonNull android.content.res.Resources resources, @androidx.annotation.ColorRes int i, @androidx.annotation.Nullable android.content.res.Resources.Theme theme) throws android.content.res.Resources.NotFoundException {
        int color;
        if (android.os.Build.VERSION.SDK_INT < 23) {
            return resources.getColor(i);
        }
        color = resources.getColor(i, theme);
        return color;
    }

    @androidx.annotation.Nullable
    public static android.content.res.ColorStateList getColorStateList(@androidx.annotation.NonNull android.content.res.Resources resources, @androidx.annotation.ColorRes int i, @androidx.annotation.Nullable android.content.res.Resources.Theme theme) throws android.content.res.Resources.NotFoundException {
        android.content.res.ColorStateList colorStateList;
        if (android.os.Build.VERSION.SDK_INT < 23) {
            return resources.getColorStateList(i);
        }
        colorStateList = resources.getColorStateList(i, theme);
        return colorStateList;
    }

    @androidx.annotation.Nullable
    public static android.graphics.drawable.Drawable getDrawable(@androidx.annotation.NonNull android.content.res.Resources resources, @androidx.annotation.DrawableRes int i, @androidx.annotation.Nullable android.content.res.Resources.Theme theme) throws android.content.res.Resources.NotFoundException {
        return resources.getDrawable(i, theme);
    }

    @androidx.annotation.Nullable
    public static android.graphics.drawable.Drawable getDrawableForDensity(@androidx.annotation.NonNull android.content.res.Resources resources, @androidx.annotation.DrawableRes int i, int i2, @androidx.annotation.Nullable android.content.res.Resources.Theme theme) throws android.content.res.Resources.NotFoundException {
        return resources.getDrawableForDensity(i, i2, theme);
    }

    public static float getFloat(@androidx.annotation.NonNull android.content.res.Resources resources, @androidx.annotation.DimenRes int i) {
        android.util.TypedValue typedValue = new android.util.TypedValue();
        resources.getValue(i, typedValue, true);
        if (typedValue.type == 4) {
            return typedValue.getFloat();
        }
        throw new android.content.res.Resources.NotFoundException("Resource ID #0x" + java.lang.Integer.toHexString(i) + " type #0x" + java.lang.Integer.toHexString(typedValue.type) + " is not valid");
    }

    @androidx.annotation.Nullable
    public static android.graphics.Typeface getFont(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.FontRes int i) throws android.content.res.Resources.NotFoundException {
        if (context.isRestricted()) {
            return null;
        }
        return loadFont(context, i, new android.util.TypedValue(), 0, null, null, false, false);
    }

    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static android.graphics.Typeface getFont(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.FontRes int i, android.util.TypedValue typedValue, int i2, @androidx.annotation.Nullable androidx.core.content.res.ResourcesCompat.FontCallback fontCallback) throws android.content.res.Resources.NotFoundException {
        if (context.isRestricted()) {
            return null;
        }
        return loadFont(context, i, typedValue, i2, fontCallback, null, true, false);
    }

    public static void getFont(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.FontRes int i, @androidx.annotation.NonNull androidx.core.content.res.ResourcesCompat.FontCallback fontCallback, @androidx.annotation.Nullable android.os.Handler handler) throws android.content.res.Resources.NotFoundException {
        androidx.core.util.Preconditions.checkNotNull(fontCallback);
        if (context.isRestricted()) {
            fontCallback.callbackFailAsync(-4, handler);
        } else {
            loadFont(context, i, new android.util.TypedValue(), 0, fontCallback, handler, false, false);
        }
    }

    private static android.graphics.Typeface loadFont(@androidx.annotation.NonNull android.content.Context context, int i, android.util.TypedValue typedValue, int i2, @androidx.annotation.Nullable androidx.core.content.res.ResourcesCompat.FontCallback fontCallback, @androidx.annotation.Nullable android.os.Handler handler, boolean z, boolean z2) {
        android.content.res.Resources resources = context.getResources();
        resources.getValue(i, typedValue, true);
        android.graphics.Typeface loadFont = loadFont(context, resources, typedValue, i, i2, fontCallback, handler, z, z2);
        if (loadFont != null || fontCallback != null || z2) {
            return loadFont;
        }
        throw new android.content.res.Resources.NotFoundException("Font resource ID #0x" + java.lang.Integer.toHexString(i) + " could not be retrieved.");
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x008c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static android.graphics.Typeface loadFont(@androidx.annotation.NonNull android.content.Context context, android.content.res.Resources resources, android.util.TypedValue typedValue, int i, int i2, @androidx.annotation.Nullable androidx.core.content.res.ResourcesCompat.FontCallback fontCallback, @androidx.annotation.Nullable android.os.Handler handler, boolean z, boolean z2) {
        java.lang.CharSequence charSequence = typedValue.string;
        if (charSequence == null) {
            throw new android.content.res.Resources.NotFoundException("Resource \"" + resources.getResourceName(i) + "\" (" + java.lang.Integer.toHexString(i) + ") is not a Font: " + typedValue);
        }
        java.lang.String charSequence2 = charSequence.toString();
        if (!charSequence2.startsWith("res/")) {
            if (fontCallback != null) {
                fontCallback.callbackFailAsync(-3, handler);
            }
            return null;
        }
        android.graphics.Typeface findFromCache = androidx.core.graphics.TypefaceCompat.findFromCache(resources, i, i2);
        if (findFromCache != null) {
            if (fontCallback != null) {
                fontCallback.callbackSuccessAsync(findFromCache, handler);
            }
            return findFromCache;
        }
        if (z2) {
            return null;
        }
        try {
            if (charSequence2.toLowerCase().endsWith(".xml")) {
                androidx.core.content.res.FontResourcesParserCompat.FamilyResourceEntry parse = androidx.core.content.res.FontResourcesParserCompat.parse(resources.getXml(i), resources);
                if (parse != null) {
                    return androidx.core.graphics.TypefaceCompat.createFromResourcesFamilyXml(context, parse, resources, i, i2, fontCallback, handler, z);
                }
                if (fontCallback != null) {
                    fontCallback.callbackFailAsync(-3, handler);
                }
                return null;
            }
            android.graphics.Typeface createFromResourcesFontFile = androidx.core.graphics.TypefaceCompat.createFromResourcesFontFile(context, resources, i, charSequence2, i2);
            if (fontCallback != null) {
                if (createFromResourcesFontFile != null) {
                    fontCallback.callbackSuccessAsync(createFromResourcesFontFile, handler);
                } else {
                    fontCallback.callbackFailAsync(-3, handler);
                }
            }
            return createFromResourcesFontFile;
        } catch (java.io.IOException unused) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("Failed to read xml resource ");
            sb.append(charSequence2);
            if (fontCallback != null) {
                fontCallback.callbackFailAsync(-3, handler);
            }
            return null;
        } catch (org.xmlpull.v1.XmlPullParserException unused2) {
            java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
            sb2.append("Failed to parse xml resource ");
            sb2.append(charSequence2);
            if (fontCallback != null) {
            }
            return null;
        }
    }
}
