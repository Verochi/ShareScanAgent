package com.google.android.gms.common.util;

@com.google.android.gms.common.util.VisibleForTesting
@com.google.android.gms.common.annotation.KeepForSdk
/* loaded from: classes22.dex */
public final class PlatformVersion {
    public static java.lang.Boolean a;

    @androidx.annotation.RecentlyNonNull
    @com.google.android.gms.common.annotation.KeepForSdk
    public static boolean isAtLeastHoneycomb() {
        return true;
    }

    @androidx.annotation.RecentlyNonNull
    @com.google.android.gms.common.annotation.KeepForSdk
    public static boolean isAtLeastHoneycombMR1() {
        return true;
    }

    @androidx.annotation.RecentlyNonNull
    @com.google.android.gms.common.annotation.KeepForSdk
    public static boolean isAtLeastIceCreamSandwich() {
        return true;
    }

    @androidx.annotation.RecentlyNonNull
    @com.google.android.gms.common.annotation.KeepForSdk
    public static boolean isAtLeastIceCreamSandwichMR1() {
        return true;
    }

    @androidx.annotation.RecentlyNonNull
    @com.google.android.gms.common.annotation.KeepForSdk
    public static boolean isAtLeastJellyBean() {
        return true;
    }

    @androidx.annotation.RecentlyNonNull
    @com.google.android.gms.common.annotation.KeepForSdk
    public static boolean isAtLeastJellyBeanMR1() {
        return true;
    }

    @androidx.annotation.RecentlyNonNull
    @com.google.android.gms.common.annotation.KeepForSdk
    public static boolean isAtLeastJellyBeanMR2() {
        return true;
    }

    @androidx.annotation.RecentlyNonNull
    @com.google.android.gms.common.annotation.KeepForSdk
    public static boolean isAtLeastKitKat() {
        return true;
    }

    @androidx.annotation.RecentlyNonNull
    @com.google.android.gms.common.annotation.KeepForSdk
    public static boolean isAtLeastKitKatWatch() {
        return true;
    }

    @androidx.annotation.RecentlyNonNull
    @com.google.android.gms.common.annotation.KeepForSdk
    public static boolean isAtLeastLollipop() {
        return true;
    }

    @androidx.annotation.RecentlyNonNull
    @com.google.android.gms.common.annotation.KeepForSdk
    public static boolean isAtLeastLollipopMR1() {
        return android.os.Build.VERSION.SDK_INT >= 22;
    }

    @androidx.annotation.RecentlyNonNull
    @com.google.android.gms.common.annotation.KeepForSdk
    public static boolean isAtLeastM() {
        return android.os.Build.VERSION.SDK_INT >= 23;
    }

    @androidx.annotation.RecentlyNonNull
    @com.google.android.gms.common.annotation.KeepForSdk
    public static boolean isAtLeastN() {
        return android.os.Build.VERSION.SDK_INT >= 24;
    }

    @androidx.annotation.RecentlyNonNull
    @com.google.android.gms.common.annotation.KeepForSdk
    public static boolean isAtLeastO() {
        return android.os.Build.VERSION.SDK_INT >= 26;
    }

    @androidx.annotation.RecentlyNonNull
    @com.google.android.gms.common.annotation.KeepForSdk
    public static boolean isAtLeastP() {
        return android.os.Build.VERSION.SDK_INT >= 28;
    }

    @androidx.annotation.RecentlyNonNull
    @com.google.android.gms.common.annotation.KeepForSdk
    public static boolean isAtLeastQ() {
        return android.os.Build.VERSION.SDK_INT >= 29;
    }

    @androidx.annotation.RecentlyNonNull
    @com.google.android.gms.common.annotation.KeepForSdk
    public static boolean isAtLeastR() {
        boolean z = false;
        if (!isAtLeastQ()) {
            return false;
        }
        if (android.os.Build.VERSION.SDK_INT >= 30 && android.os.Build.VERSION.CODENAME.equals("REL")) {
            return true;
        }
        java.lang.String str = android.os.Build.VERSION.CODENAME;
        if (!(str.length() == 1 && str.charAt(0) >= 'R' && str.charAt(0) <= 'Z')) {
            return false;
        }
        java.lang.Boolean bool = a;
        if (bool != null) {
            return bool.booleanValue();
        }
        try {
            if ("google".equals(android.os.Build.BRAND) && !android.os.Build.ID.startsWith("RPP1") && !android.os.Build.ID.startsWith("RPP2") && java.lang.Integer.parseInt(android.os.Build.VERSION.INCREMENTAL) >= 6301457) {
                z = true;
            }
            a = java.lang.Boolean.valueOf(z);
        } catch (java.lang.NumberFormatException unused) {
            a = java.lang.Boolean.TRUE;
        }
        a.booleanValue();
        return a.booleanValue();
    }
}
