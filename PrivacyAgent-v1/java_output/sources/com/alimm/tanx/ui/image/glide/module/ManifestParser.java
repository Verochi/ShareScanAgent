package com.alimm.tanx.ui.image.glide.module;

/* loaded from: classes.dex */
public final class ManifestParser {
    private static final java.lang.String GLIDE_MODULE_VALUE = "GlideModule";
    private final android.content.Context context;

    public ManifestParser(android.content.Context context) {
        this.context = context;
    }

    private static com.alimm.tanx.ui.image.glide.module.GlideModule parseModule(java.lang.String str) {
        try {
            java.lang.Class<?> cls = java.lang.Class.forName(str);
            try {
                java.lang.Object newInstance = cls.newInstance();
                if (newInstance instanceof com.alimm.tanx.ui.image.glide.module.GlideModule) {
                    return (com.alimm.tanx.ui.image.glide.module.GlideModule) newInstance;
                }
                com.alimm.tanx.core.utils.LogUtils.e(GLIDE_MODULE_VALUE, "Expected instanceof GlideModule, but found: " + newInstance);
                return null;
            } catch (java.lang.IllegalAccessException e) {
                throw new java.lang.RuntimeException("Unable to instantiate GlideModule implementation for " + cls, e);
            } catch (java.lang.InstantiationException e2) {
                throw new java.lang.RuntimeException("Unable to instantiate GlideModule implementation for " + cls, e2);
            }
        } catch (java.lang.ClassNotFoundException e3) {
            throw new java.lang.IllegalArgumentException("Unable to find GlideModule implementation", e3);
        }
    }

    public java.util.List<com.alimm.tanx.ui.image.glide.module.GlideModule> parse() {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        try {
            android.content.pm.ApplicationInfo applicationInfo = this.context.getPackageManager().getApplicationInfo(this.context.getPackageName(), 128);
            android.os.Bundle bundle = applicationInfo.metaData;
            if (bundle != null) {
                for (java.lang.String str : bundle.keySet()) {
                    if (GLIDE_MODULE_VALUE.equals(applicationInfo.metaData.get(str))) {
                        if (!android.text.TextUtils.isEmpty(str) && str.contains("integration.okhttp3.OkHttpGlideModule")) {
                            str = "com.alimm.tanx.ui.image.glide.integration.okhttp3.OkHttpGlideModule";
                        }
                        com.alimm.tanx.ui.image.glide.module.GlideModule parseModule = parseModule(str);
                        if (parseModule != null) {
                            arrayList.add(parseModule);
                        }
                    }
                }
            }
            return arrayList;
        } catch (android.content.pm.PackageManager.NameNotFoundException e) {
            throw new java.lang.RuntimeException("Unable to find metadata to parse GlideModules", e);
        }
    }
}
