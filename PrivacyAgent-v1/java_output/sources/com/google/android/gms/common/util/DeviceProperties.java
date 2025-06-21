package com.google.android.gms.common.util;

@com.google.android.gms.common.annotation.KeepForSdk
/* loaded from: classes22.dex */
public final class DeviceProperties {

    @androidx.annotation.Nullable
    public static java.lang.Boolean a;

    @androidx.annotation.Nullable
    public static java.lang.Boolean b;

    @androidx.annotation.Nullable
    public static java.lang.Boolean c;

    @androidx.annotation.Nullable
    public static java.lang.Boolean d;

    @androidx.annotation.Nullable
    public static java.lang.Boolean e;

    @androidx.annotation.Nullable
    public static java.lang.Boolean f;

    @androidx.annotation.Nullable
    public static java.lang.Boolean g;

    @androidx.annotation.Nullable
    public static java.lang.Boolean h;

    @android.annotation.TargetApi(21)
    public static boolean a(android.content.Context context) {
        if (d == null) {
            d = java.lang.Boolean.valueOf(com.google.android.gms.common.util.PlatformVersion.isAtLeastLollipop() && context.getPackageManager().hasSystemFeature("cn.google"));
        }
        return d.booleanValue();
    }

    @androidx.annotation.RecentlyNonNull
    @com.google.android.gms.common.annotation.KeepForSdk
    public static boolean isAuto(@androidx.annotation.RecentlyNonNull android.content.Context context) {
        return isAuto(context.getPackageManager());
    }

    @androidx.annotation.RecentlyNonNull
    @com.google.android.gms.common.annotation.KeepForSdk
    public static boolean isAuto(@androidx.annotation.RecentlyNonNull android.content.pm.PackageManager packageManager) {
        if (g == null) {
            g = java.lang.Boolean.valueOf(com.google.android.gms.common.util.PlatformVersion.isAtLeastO() && packageManager.hasSystemFeature("android.hardware.type.automotive"));
        }
        return g.booleanValue();
    }

    @androidx.annotation.RecentlyNonNull
    @com.google.android.gms.common.annotation.KeepForSdk
    @java.lang.Deprecated
    public static boolean isFeaturePhone(@androidx.annotation.RecentlyNonNull android.content.Context context) {
        return false;
    }

    @androidx.annotation.RecentlyNonNull
    @com.google.android.gms.common.annotation.KeepForSdk
    public static boolean isLatchsky(@androidx.annotation.RecentlyNonNull android.content.Context context) {
        if (e == null) {
            android.content.pm.PackageManager packageManager = context.getPackageManager();
            e = java.lang.Boolean.valueOf(packageManager.hasSystemFeature("com.google.android.feature.services_updater") && packageManager.hasSystemFeature("cn.google.services"));
        }
        return e.booleanValue();
    }

    @androidx.annotation.RecentlyNonNull
    @com.google.android.gms.common.annotation.KeepForSdk
    @android.annotation.TargetApi(21)
    public static boolean isSidewinder(@androidx.annotation.RecentlyNonNull android.content.Context context) {
        return a(context);
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x003c, code lost:
    
        if (com.google.android.gms.common.util.DeviceProperties.b.booleanValue() != false) goto L23;
     */
    @androidx.annotation.RecentlyNonNull
    @com.google.android.gms.common.annotation.KeepForSdk
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean isTablet(@androidx.annotation.RecentlyNonNull android.content.res.Resources resources) {
        boolean z = false;
        if (resources == null) {
            return false;
        }
        if (a == null) {
            if (!((resources.getConfiguration().screenLayout & 15) > 3)) {
                if (b == null) {
                    android.content.res.Configuration configuration = resources.getConfiguration();
                    b = java.lang.Boolean.valueOf((configuration.screenLayout & 15) <= 3 && configuration.smallestScreenWidthDp >= 600);
                }
            }
            z = true;
            a = java.lang.Boolean.valueOf(z);
        }
        return a.booleanValue();
    }

    @androidx.annotation.RecentlyNonNull
    @com.google.android.gms.common.annotation.KeepForSdk
    public static boolean isTv(@androidx.annotation.RecentlyNonNull android.content.Context context) {
        return isTv(context.getPackageManager());
    }

    @androidx.annotation.RecentlyNonNull
    @com.google.android.gms.common.annotation.KeepForSdk
    public static boolean isTv(@androidx.annotation.RecentlyNonNull android.content.pm.PackageManager packageManager) {
        if (h == null) {
            h = java.lang.Boolean.valueOf(packageManager.hasSystemFeature("com.google.android.tv") || packageManager.hasSystemFeature("android.hardware.type.television") || packageManager.hasSystemFeature("android.software.leanback"));
        }
        return h.booleanValue();
    }

    @androidx.annotation.RecentlyNonNull
    @com.google.android.gms.common.annotation.KeepForSdk
    public static boolean isUserBuild() {
        return com.umeng.analytics.pro.ay.m.equals(android.os.Build.TYPE);
    }

    @androidx.annotation.RecentlyNonNull
    @com.google.android.gms.common.annotation.KeepForSdk
    @android.annotation.TargetApi(20)
    public static boolean isWearable(@androidx.annotation.RecentlyNonNull android.content.Context context) {
        return isWearable(context.getPackageManager());
    }

    @androidx.annotation.RecentlyNonNull
    @com.google.android.gms.common.annotation.KeepForSdk
    @android.annotation.TargetApi(20)
    public static boolean isWearable(@androidx.annotation.RecentlyNonNull android.content.pm.PackageManager packageManager) {
        if (c == null) {
            c = java.lang.Boolean.valueOf(com.google.android.gms.common.util.PlatformVersion.isAtLeastKitKatWatch() && packageManager.hasSystemFeature("android.hardware.type.watch"));
        }
        return c.booleanValue();
    }

    @androidx.annotation.RecentlyNonNull
    @com.google.android.gms.common.annotation.KeepForSdk
    @android.annotation.TargetApi(26)
    public static boolean isWearableWithoutPlayStore(@androidx.annotation.RecentlyNonNull android.content.Context context) {
        if (!isWearable(context)) {
            return false;
        }
        if (com.google.android.gms.common.util.PlatformVersion.isAtLeastN()) {
            return a(context) && !com.google.android.gms.common.util.PlatformVersion.isAtLeastO();
        }
        return true;
    }

    @androidx.annotation.RecentlyNonNull
    public static boolean zza(@androidx.annotation.RecentlyNonNull android.content.Context context) {
        if (f == null) {
            f = java.lang.Boolean.valueOf(context.getPackageManager().hasSystemFeature("android.hardware.type.iot") || context.getPackageManager().hasSystemFeature("android.hardware.type.embedded"));
        }
        return f.booleanValue();
    }
}
