package com.sensorsdata.analytics.android.sdk.advert.oaid;

/* loaded from: classes19.dex */
public final class OAIDRom {
    private static final java.lang.String TAG = "SA.OAIDRom";

    private OAIDRom() {
    }

    public static boolean isASUS() {
        return android.os.Build.MANUFACTURER.equalsIgnoreCase("ASUS") || android.os.Build.BRAND.equalsIgnoreCase("ASUS");
    }

    public static boolean isBlackShark() {
        return android.os.Build.MANUFACTURER.equalsIgnoreCase("BLACKSHARK") || android.os.Build.BRAND.equalsIgnoreCase("BLACKSHARK");
    }

    public static boolean isCoolpad(android.content.Context context) {
        try {
            if (!android.os.Build.MANUFACTURER.equalsIgnoreCase("COOLPAD")) {
                if (!android.os.Build.BRAND.equalsIgnoreCase("COOLPAD")) {
                    return false;
                }
            }
            return true;
        } catch (java.lang.Exception unused) {
            return false;
        }
    }

    public static boolean isEmui() {
        return !android.text.TextUtils.isEmpty(sysProperty(com.alipay.sdk.m.c.a.a, ""));
    }

    public static boolean isHuawei() {
        if (!android.os.Build.MANUFACTURER.equalsIgnoreCase("HUAWEI")) {
            java.lang.String str = android.os.Build.BRAND;
            if (!str.equalsIgnoreCase("HUAWEI") && !str.equalsIgnoreCase("HONOR")) {
                return false;
            }
        }
        return true;
    }

    public static boolean isLenovo() {
        if (!android.os.Build.MANUFACTURER.equalsIgnoreCase("LENOVO")) {
            java.lang.String str = android.os.Build.BRAND;
            if (!str.equalsIgnoreCase("LENOVO") && !str.equalsIgnoreCase("ZUK")) {
                return false;
            }
        }
        return true;
    }

    public static boolean isMeizu() {
        return android.os.Build.MANUFACTURER.equalsIgnoreCase("MEIZU") || android.os.Build.BRAND.equalsIgnoreCase("MEIZU") || android.os.Build.DISPLAY.toUpperCase().contains("FLYME");
    }

    public static boolean isMiui() {
        return !android.text.TextUtils.isEmpty(sysProperty(com.igexin.assist.control.xiaomi.XmSystemUtils.KEY_VERSION_MIUI, ""));
    }

    public static boolean isMotolora() {
        return android.os.Build.MANUFACTURER.equalsIgnoreCase("MOTOLORA") || android.os.Build.BRAND.equalsIgnoreCase("MOTOLORA");
    }

    public static boolean isNubia() {
        return android.os.Build.MANUFACTURER.equalsIgnoreCase("NUBIA") || android.os.Build.BRAND.equalsIgnoreCase("NUBIA");
    }

    public static boolean isOnePlus() {
        return android.os.Build.MANUFACTURER.equalsIgnoreCase("ONEPLUS") || android.os.Build.BRAND.equalsIgnoreCase("ONEPLUS");
    }

    public static boolean isOppo() {
        if (!android.os.Build.MANUFACTURER.equalsIgnoreCase(com.ss.android.download.api.constant.BaseConstants.ROM_OPPO_UPPER_CONSTANT)) {
            java.lang.String str = android.os.Build.BRAND;
            if (!str.equalsIgnoreCase(com.ss.android.download.api.constant.BaseConstants.ROM_OPPO_UPPER_CONSTANT) && !str.equalsIgnoreCase("REALME") && android.text.TextUtils.isEmpty(sysProperty("ro.build.version.opporom", ""))) {
                return false;
            }
        }
        return true;
    }

    public static boolean isSamsung() {
        return android.os.Build.MANUFACTURER.equalsIgnoreCase("SAMSUNG") || android.os.Build.BRAND.equalsIgnoreCase("SAMSUNG");
    }

    public static boolean isVivo() {
        return android.os.Build.MANUFACTURER.equalsIgnoreCase("VIVO") || android.os.Build.BRAND.equalsIgnoreCase("VIVO") || !android.text.TextUtils.isEmpty(sysProperty("ro.vivo.os.version", ""));
    }

    public static boolean isXiaomi() {
        if (!android.os.Build.MANUFACTURER.equalsIgnoreCase("XIAOMI")) {
            java.lang.String str = android.os.Build.BRAND;
            if (!str.equalsIgnoreCase("XIAOMI") && !str.equalsIgnoreCase("REDMI")) {
                return false;
            }
        }
        return true;
    }

    public static boolean isZTE() {
        return android.os.Build.MANUFACTURER.equalsIgnoreCase("ZTE") || android.os.Build.BRAND.equalsIgnoreCase("ZTE");
    }

    public static java.lang.String sysProperty(java.lang.String str, java.lang.String str2) {
        java.lang.String str3;
        try {
            java.lang.Class<?> cls = java.lang.Class.forName("android.os.SystemProperties");
            str3 = (java.lang.String) cls.getMethod(com.ss.android.socialbase.downloader.constants.MonitorConstants.CONNECT_TYPE_GET, java.lang.String.class, java.lang.String.class).invoke(cls, str, str2);
        } catch (java.lang.Throwable th) {
            com.sensorsdata.analytics.android.sdk.SALog.i(TAG, th);
            str3 = null;
        }
        return str3 == null ? "" : str3;
    }
}
