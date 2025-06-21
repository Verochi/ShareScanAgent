package com.bumptech.glide.signature;

/* loaded from: classes.dex */
public final class ApplicationVersionSignature {
    private static final java.util.concurrent.ConcurrentMap<java.lang.String, com.bumptech.glide.load.Key> PACKAGE_NAME_TO_KEY = new java.util.concurrent.ConcurrentHashMap();
    private static final java.lang.String TAG = "AppVersionSignature";

    private ApplicationVersionSignature() {
    }

    @androidx.annotation.Nullable
    private static android.content.pm.PackageInfo getPackageInfo(@androidx.annotation.NonNull android.content.Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
        } catch (android.content.pm.PackageManager.NameNotFoundException unused) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("Cannot resolve info for");
            sb.append(context.getPackageName());
            return null;
        }
    }

    @androidx.annotation.NonNull
    private static java.lang.String getVersionCode(@androidx.annotation.Nullable android.content.pm.PackageInfo packageInfo) {
        return packageInfo != null ? java.lang.String.valueOf(packageInfo.versionCode) : java.util.UUID.randomUUID().toString();
    }

    @androidx.annotation.NonNull
    public static com.bumptech.glide.load.Key obtain(@androidx.annotation.NonNull android.content.Context context) {
        java.lang.String packageName = context.getPackageName();
        java.util.concurrent.ConcurrentMap<java.lang.String, com.bumptech.glide.load.Key> concurrentMap = PACKAGE_NAME_TO_KEY;
        com.bumptech.glide.load.Key key = concurrentMap.get(packageName);
        if (key != null) {
            return key;
        }
        com.bumptech.glide.load.Key obtainVersionSignature = obtainVersionSignature(context);
        com.bumptech.glide.load.Key putIfAbsent = concurrentMap.putIfAbsent(packageName, obtainVersionSignature);
        return putIfAbsent == null ? obtainVersionSignature : putIfAbsent;
    }

    @androidx.annotation.NonNull
    private static com.bumptech.glide.load.Key obtainVersionSignature(@androidx.annotation.NonNull android.content.Context context) {
        return new com.bumptech.glide.signature.ObjectKey(getVersionCode(getPackageInfo(context)));
    }

    @androidx.annotation.VisibleForTesting
    public static void reset() {
        PACKAGE_NAME_TO_KEY.clear();
    }
}
