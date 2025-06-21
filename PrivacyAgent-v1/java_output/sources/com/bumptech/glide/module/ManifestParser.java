package com.bumptech.glide.module;

@java.lang.Deprecated
/* loaded from: classes.dex */
public final class ManifestParser {
    private static final java.lang.String GLIDE_MODULE_VALUE = "GlideModule";
    private static final java.lang.String TAG = "ManifestParser";
    private final android.content.Context context;

    public ManifestParser(android.content.Context context) {
        this.context = context;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static com.bumptech.glide.module.GlideModule parseModule(java.lang.String str) {
        java.lang.Object obj;
        try {
            java.lang.Class<?> cls = java.lang.Class.forName(str);
            try {
                obj = cls.getDeclaredConstructor(new java.lang.Class[0]).newInstance(new java.lang.Object[0]);
            } catch (java.lang.IllegalAccessException e) {
                throwInstantiateGlideModuleException(cls, e);
                obj = null;
                if (obj instanceof com.bumptech.glide.module.GlideModule) {
                }
            } catch (java.lang.InstantiationException e2) {
                throwInstantiateGlideModuleException(cls, e2);
                obj = null;
                if (obj instanceof com.bumptech.glide.module.GlideModule) {
                }
            } catch (java.lang.NoSuchMethodException e3) {
                throwInstantiateGlideModuleException(cls, e3);
                obj = null;
                if (obj instanceof com.bumptech.glide.module.GlideModule) {
                }
            } catch (java.lang.reflect.InvocationTargetException e4) {
                throwInstantiateGlideModuleException(cls, e4);
                obj = null;
                if (obj instanceof com.bumptech.glide.module.GlideModule) {
                }
            }
            if (obj instanceof com.bumptech.glide.module.GlideModule) {
                return (com.bumptech.glide.module.GlideModule) obj;
            }
            throw new java.lang.RuntimeException("Expected instanceof GlideModule, but found: " + obj);
        } catch (java.lang.ClassNotFoundException e5) {
            throw new java.lang.IllegalArgumentException("Unable to find GlideModule implementation", e5);
        }
    }

    private static void throwInstantiateGlideModuleException(java.lang.Class<?> cls, java.lang.Exception exc) {
        throw new java.lang.RuntimeException("Unable to instantiate GlideModule implementation for " + cls, exc);
    }

    public java.util.List<com.bumptech.glide.module.GlideModule> parse() {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        try {
            android.content.pm.ApplicationInfo applicationInfo = this.context.getPackageManager().getApplicationInfo(this.context.getPackageName(), 128);
            if (applicationInfo.metaData == null) {
                return arrayList;
            }
            if (android.util.Log.isLoggable(TAG, 2)) {
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                sb.append("Got app info metadata: ");
                sb.append(applicationInfo.metaData);
            }
            for (java.lang.String str : applicationInfo.metaData.keySet()) {
                if (GLIDE_MODULE_VALUE.equals(applicationInfo.metaData.get(str))) {
                    arrayList.add(parseModule(str));
                    if (android.util.Log.isLoggable(TAG, 3)) {
                        java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
                        sb2.append("Loaded Glide module: ");
                        sb2.append(str);
                    }
                }
            }
            return arrayList;
        } catch (android.content.pm.PackageManager.NameNotFoundException e) {
            throw new java.lang.RuntimeException("Unable to find metadata to parse GlideModules", e);
        }
    }
}
