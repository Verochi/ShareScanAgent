package com.alipay.sdk.m.a0;

/* loaded from: classes.dex */
public final class d {
    public static com.alipay.sdk.m.a0.d a = new com.alipay.sdk.m.a0.d();

    public static com.alipay.sdk.m.a0.d a() {
        return a;
    }

    public static java.lang.String a(java.lang.String str, java.lang.String str2) {
        try {
            return (java.lang.String) java.lang.Class.forName("android.os.SystemProperties").getMethod(com.ss.android.socialbase.downloader.constants.MonitorConstants.CONNECT_TYPE_GET, java.lang.String.class, java.lang.String.class).invoke(null, str, str2);
        } catch (java.lang.Exception unused) {
            return str2;
        }
    }

    public static boolean a(android.content.Context context) {
        boolean z;
        int length;
        try {
            if (!android.os.Build.HARDWARE.contains("goldfish") && !android.os.Build.PRODUCT.contains("sdk") && !android.os.Build.FINGERPRINT.contains("generic")) {
                android.telephony.TelephonyManager telephonyManager = (android.telephony.TelephonyManager) context.getSystemService(com.aliyun.vod.log.core.AliyunLogCommon.TERMINAL_TYPE);
                if (telephonyManager != null) {
                    java.lang.String deviceId = telephonyManager.getDeviceId();
                    if (deviceId != null && (length = deviceId.length()) != 0) {
                        for (int i = 0; i < length; i++) {
                            if (!java.lang.Character.isWhitespace(deviceId.charAt(i)) && deviceId.charAt(i) != '0') {
                                z = false;
                                break;
                            }
                        }
                    }
                    z = true;
                    if (z) {
                        return true;
                    }
                }
                return com.alipay.sdk.m.z.a.a(android.provider.Settings.Secure.getString(context.getContentResolver(), "android_id"));
            }
            return true;
        } catch (java.lang.Exception unused) {
            return false;
        }
    }

    public static java.lang.String b() {
        return com.aliyun.vod.log.core.AliyunLogCommon.OPERATION_SYSTEM;
    }

    public static boolean c() {
        java.lang.String[] strArr = {"/system/bin/", "/system/xbin/", "/system/sbin/", "/sbin/", "/vendor/bin/"};
        for (int i = 0; i < 5; i++) {
            try {
                if (new java.io.File(strArr[i] + com.getui.gtc.extension.distribution.gbd.n.aa.a).exists()) {
                    return true;
                }
            } catch (java.lang.Exception unused) {
            }
        }
        return false;
    }

    public static java.lang.String d() {
        return android.os.Build.BOARD;
    }

    public static java.lang.String e() {
        return android.os.Build.BRAND;
    }

    public static java.lang.String f() {
        return android.os.Build.DEVICE;
    }

    public static java.lang.String g() {
        return android.os.Build.DISPLAY;
    }

    public static java.lang.String h() {
        return android.os.Build.VERSION.INCREMENTAL;
    }

    public static java.lang.String i() {
        return android.os.Build.MANUFACTURER;
    }

    public static java.lang.String j() {
        return android.os.Build.MODEL;
    }

    public static java.lang.String k() {
        return android.os.Build.PRODUCT;
    }

    public static java.lang.String l() {
        return android.os.Build.VERSION.RELEASE;
    }

    public static java.lang.String m() {
        return android.os.Build.VERSION.SDK;
    }

    public static java.lang.String n() {
        return android.os.Build.TAGS;
    }

    public static java.lang.String o() {
        return a("ro.kernel.qemu", "0");
    }
}
