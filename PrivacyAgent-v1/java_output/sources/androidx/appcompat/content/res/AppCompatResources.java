package androidx.appcompat.content.res;

@android.annotation.SuppressLint({"RestrictedAPI"})
/* loaded from: classes.dex */
public final class AppCompatResources {
    private static final java.lang.String LOG_TAG = "AppCompatResources";
    private static final java.lang.ThreadLocal<android.util.TypedValue> TL_TYPED_VALUE = new java.lang.ThreadLocal<>();
    private static final java.util.WeakHashMap<android.content.Context, android.util.SparseArray<androidx.appcompat.content.res.AppCompatResources.ColorStateListCacheEntry>> sColorStateCaches = new java.util.WeakHashMap<>(0);
    private static final java.lang.Object sColorStateCacheLock = new java.lang.Object();

    public static class ColorStateListCacheEntry {
        final android.content.res.Configuration configuration;
        final android.content.res.ColorStateList value;

        public ColorStateListCacheEntry(@androidx.annotation.NonNull android.content.res.ColorStateList colorStateList, @androidx.annotation.NonNull android.content.res.Configuration configuration) {
            this.value = colorStateList;
            this.configuration = configuration;
        }
    }

    private AppCompatResources() {
    }

    private static void addColorStateListToCache(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.ColorRes int i, @androidx.annotation.NonNull android.content.res.ColorStateList colorStateList) {
        synchronized (sColorStateCacheLock) {
            java.util.WeakHashMap<android.content.Context, android.util.SparseArray<androidx.appcompat.content.res.AppCompatResources.ColorStateListCacheEntry>> weakHashMap = sColorStateCaches;
            android.util.SparseArray<androidx.appcompat.content.res.AppCompatResources.ColorStateListCacheEntry> sparseArray = weakHashMap.get(context);
            if (sparseArray == null) {
                sparseArray = new android.util.SparseArray<>();
                weakHashMap.put(context, sparseArray);
            }
            sparseArray.append(i, new androidx.appcompat.content.res.AppCompatResources.ColorStateListCacheEntry(colorStateList, context.getResources().getConfiguration()));
        }
    }

    @androidx.annotation.Nullable
    private static android.content.res.ColorStateList getCachedColorStateList(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.ColorRes int i) {
        androidx.appcompat.content.res.AppCompatResources.ColorStateListCacheEntry colorStateListCacheEntry;
        synchronized (sColorStateCacheLock) {
            android.util.SparseArray<androidx.appcompat.content.res.AppCompatResources.ColorStateListCacheEntry> sparseArray = sColorStateCaches.get(context);
            if (sparseArray != null && sparseArray.size() > 0 && (colorStateListCacheEntry = sparseArray.get(i)) != null) {
                if (colorStateListCacheEntry.configuration.equals(context.getResources().getConfiguration())) {
                    return colorStateListCacheEntry.value;
                }
                sparseArray.remove(i);
            }
            return null;
        }
    }

    public static android.content.res.ColorStateList getColorStateList(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.ColorRes int i) {
        android.content.res.ColorStateList colorStateList;
        if (android.os.Build.VERSION.SDK_INT >= 23) {
            colorStateList = context.getColorStateList(i);
            return colorStateList;
        }
        android.content.res.ColorStateList cachedColorStateList = getCachedColorStateList(context, i);
        if (cachedColorStateList != null) {
            return cachedColorStateList;
        }
        android.content.res.ColorStateList inflateColorStateList = inflateColorStateList(context, i);
        if (inflateColorStateList == null) {
            return androidx.core.content.ContextCompat.getColorStateList(context, i);
        }
        addColorStateListToCache(context, i, inflateColorStateList);
        return inflateColorStateList;
    }

    @androidx.annotation.Nullable
    public static android.graphics.drawable.Drawable getDrawable(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.DrawableRes int i) {
        return androidx.appcompat.widget.ResourceManagerInternal.get().getDrawable(context, i);
    }

    @androidx.annotation.NonNull
    private static android.util.TypedValue getTypedValue() {
        java.lang.ThreadLocal<android.util.TypedValue> threadLocal = TL_TYPED_VALUE;
        android.util.TypedValue typedValue = threadLocal.get();
        if (typedValue != null) {
            return typedValue;
        }
        android.util.TypedValue typedValue2 = new android.util.TypedValue();
        threadLocal.set(typedValue2);
        return typedValue2;
    }

    @androidx.annotation.Nullable
    private static android.content.res.ColorStateList inflateColorStateList(android.content.Context context, int i) {
        if (isColorInt(context, i)) {
            return null;
        }
        android.content.res.Resources resources = context.getResources();
        try {
            return androidx.core.content.res.ColorStateListInflaterCompat.createFromXml(resources, resources.getXml(i), context.getTheme());
        } catch (java.lang.Exception unused) {
            return null;
        }
    }

    private static boolean isColorInt(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.ColorRes int i) {
        android.content.res.Resources resources = context.getResources();
        android.util.TypedValue typedValue = getTypedValue();
        resources.getValue(i, typedValue, true);
        int i2 = typedValue.type;
        return i2 >= 28 && i2 <= 31;
    }
}
