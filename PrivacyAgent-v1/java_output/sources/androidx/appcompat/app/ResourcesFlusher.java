package androidx.appcompat.app;

/* loaded from: classes.dex */
class ResourcesFlusher {
    private static final java.lang.String TAG = "ResourcesFlusher";
    private static java.lang.reflect.Field sDrawableCacheField;
    private static boolean sDrawableCacheFieldFetched;
    private static java.lang.reflect.Field sResourcesImplField;
    private static boolean sResourcesImplFieldFetched;
    private static java.lang.Class<?> sThemedResourceCacheClazz;
    private static boolean sThemedResourceCacheClazzFetched;
    private static java.lang.reflect.Field sThemedResourceCache_mUnthemedEntriesField;
    private static boolean sThemedResourceCache_mUnthemedEntriesFieldFetched;

    private ResourcesFlusher() {
    }

    public static void flush(@androidx.annotation.NonNull android.content.res.Resources resources) {
        int i = android.os.Build.VERSION.SDK_INT;
        if (i >= 28) {
            return;
        }
        if (i >= 24) {
            flushNougats(resources);
        } else if (i >= 23) {
            flushMarshmallows(resources);
        } else {
            flushLollipops(resources);
        }
    }

    @androidx.annotation.RequiresApi(21)
    private static void flushLollipops(@androidx.annotation.NonNull android.content.res.Resources resources) {
        java.util.Map map;
        if (!sDrawableCacheFieldFetched) {
            try {
                java.lang.reflect.Field declaredField = android.content.res.Resources.class.getDeclaredField("mDrawableCache");
                sDrawableCacheField = declaredField;
                declaredField.setAccessible(true);
            } catch (java.lang.NoSuchFieldException unused) {
            }
            sDrawableCacheFieldFetched = true;
        }
        java.lang.reflect.Field field = sDrawableCacheField;
        if (field != null) {
            try {
                map = (java.util.Map) field.get(resources);
            } catch (java.lang.IllegalAccessException unused2) {
                map = null;
            }
            if (map != null) {
                map.clear();
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0020 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0021  */
    @androidx.annotation.RequiresApi(23)
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static void flushMarshmallows(@androidx.annotation.NonNull android.content.res.Resources resources) {
        java.lang.Object obj;
        if (!sDrawableCacheFieldFetched) {
            try {
                java.lang.reflect.Field declaredField = android.content.res.Resources.class.getDeclaredField("mDrawableCache");
                sDrawableCacheField = declaredField;
                declaredField.setAccessible(true);
            } catch (java.lang.NoSuchFieldException unused) {
            }
            sDrawableCacheFieldFetched = true;
        }
        java.lang.reflect.Field field = sDrawableCacheField;
        if (field != null) {
            try {
                obj = field.get(resources);
            } catch (java.lang.IllegalAccessException unused2) {
            }
            if (obj != null) {
                return;
            }
            flushThemedResourcesCache(obj);
            return;
        }
        obj = null;
        if (obj != null) {
        }
    }

    @androidx.annotation.RequiresApi(24)
    private static void flushNougats(@androidx.annotation.NonNull android.content.res.Resources resources) {
        java.lang.Object obj;
        if (!sResourcesImplFieldFetched) {
            try {
                java.lang.reflect.Field declaredField = android.content.res.Resources.class.getDeclaredField("mResourcesImpl");
                sResourcesImplField = declaredField;
                declaredField.setAccessible(true);
            } catch (java.lang.NoSuchFieldException unused) {
            }
            sResourcesImplFieldFetched = true;
        }
        java.lang.reflect.Field field = sResourcesImplField;
        if (field == null) {
            return;
        }
        java.lang.Object obj2 = null;
        try {
            obj = field.get(resources);
        } catch (java.lang.IllegalAccessException unused2) {
            obj = null;
        }
        if (obj == null) {
            return;
        }
        if (!sDrawableCacheFieldFetched) {
            try {
                java.lang.reflect.Field declaredField2 = obj.getClass().getDeclaredField("mDrawableCache");
                sDrawableCacheField = declaredField2;
                declaredField2.setAccessible(true);
            } catch (java.lang.NoSuchFieldException unused3) {
            }
            sDrawableCacheFieldFetched = true;
        }
        java.lang.reflect.Field field2 = sDrawableCacheField;
        if (field2 != null) {
            try {
                obj2 = field2.get(obj);
            } catch (java.lang.IllegalAccessException unused4) {
            }
        }
        if (obj2 != null) {
            flushThemedResourcesCache(obj2);
        }
    }

    @androidx.annotation.RequiresApi(16)
    private static void flushThemedResourcesCache(@androidx.annotation.NonNull java.lang.Object obj) {
        android.util.LongSparseArray longSparseArray;
        if (!sThemedResourceCacheClazzFetched) {
            try {
                sThemedResourceCacheClazz = java.lang.Class.forName("android.content.res.ThemedResourceCache");
            } catch (java.lang.ClassNotFoundException unused) {
            }
            sThemedResourceCacheClazzFetched = true;
        }
        java.lang.Class<?> cls = sThemedResourceCacheClazz;
        if (cls == null) {
            return;
        }
        if (!sThemedResourceCache_mUnthemedEntriesFieldFetched) {
            try {
                java.lang.reflect.Field declaredField = cls.getDeclaredField("mUnthemedEntries");
                sThemedResourceCache_mUnthemedEntriesField = declaredField;
                declaredField.setAccessible(true);
            } catch (java.lang.NoSuchFieldException unused2) {
            }
            sThemedResourceCache_mUnthemedEntriesFieldFetched = true;
        }
        java.lang.reflect.Field field = sThemedResourceCache_mUnthemedEntriesField;
        if (field == null) {
            return;
        }
        try {
            longSparseArray = (android.util.LongSparseArray) field.get(obj);
        } catch (java.lang.IllegalAccessException unused3) {
            longSparseArray = null;
        }
        if (longSparseArray != null) {
            longSparseArray.clear();
        }
    }
}
