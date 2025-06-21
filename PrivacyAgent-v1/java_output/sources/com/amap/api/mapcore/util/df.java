package com.amap.api.mapcore.util;

/* loaded from: classes12.dex */
public final class df {
    private static boolean a = new java.io.File("/system/framework/amap.jar").exists();

    public static android.content.res.AssetManager a(android.content.Context context) {
        if (context == null) {
            return null;
        }
        android.content.res.AssetManager assets = context.getAssets();
        if (a) {
            try {
                assets.getClass().getDeclaredMethod("addAssetPath", java.lang.String.class).invoke(assets, "/system/framework/amap.jar");
            } catch (java.lang.Throwable th) {
                com.amap.api.mapcore.util.gd.c(th, "ResourcesUtil", "getSelfAssets");
            }
        }
        return assets;
    }

    public static int b(android.content.Context context) {
        return (int) ((context.getResources().getDisplayMetrics().density * 1.0f) + 0.5f);
    }
}
