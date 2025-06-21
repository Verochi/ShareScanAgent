package com.alimm.tanx.ui.image.glide.signature;

/* loaded from: classes.dex */
public final class ApplicationVersionSignature {
    private static final java.util.concurrent.ConcurrentHashMap<java.lang.String, com.alimm.tanx.ui.image.glide.load.Key> PACKAGE_NAME_TO_KEY = new java.util.concurrent.ConcurrentHashMap<>();

    private ApplicationVersionSignature() {
    }

    public static com.alimm.tanx.ui.image.glide.load.Key obtain(android.content.Context context) {
        com.alimm.tanx.ui.image.glide.load.Key putIfAbsent;
        java.lang.String packageName = context.getPackageName();
        java.util.concurrent.ConcurrentHashMap<java.lang.String, com.alimm.tanx.ui.image.glide.load.Key> concurrentHashMap = PACKAGE_NAME_TO_KEY;
        com.alimm.tanx.ui.image.glide.load.Key key = concurrentHashMap.get(packageName);
        return (key != null || (putIfAbsent = concurrentHashMap.putIfAbsent(packageName, (key = obtainVersionSignature(context)))) == null) ? key : putIfAbsent;
    }

    private static com.alimm.tanx.ui.image.glide.load.Key obtainVersionSignature(android.content.Context context) {
        android.content.pm.PackageInfo packageInfo;
        try {
            packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
        } catch (android.content.pm.PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            packageInfo = null;
        }
        return new com.alimm.tanx.ui.image.glide.signature.StringSignature(packageInfo != null ? java.lang.String.valueOf(packageInfo.versionCode) : java.util.UUID.randomUUID().toString());
    }

    public static void reset() {
        PACKAGE_NAME_TO_KEY.clear();
    }
}
