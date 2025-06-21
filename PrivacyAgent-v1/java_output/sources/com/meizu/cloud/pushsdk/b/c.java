package com.meizu.cloud.pushsdk.b;

/* loaded from: classes23.dex */
public class c {
    private static java.lang.String a = "";

    public static java.lang.String a(android.content.Context context) {
        if (!android.text.TextUtils.isEmpty(a)) {
            return a;
        }
        a = !a() ? d(context) : b(context);
        return a;
    }

    public static boolean a() {
        java.lang.String a2 = com.meizu.cloud.pushsdk.b.i.a("ro.target.product");
        if (android.text.TextUtils.isEmpty(a2)) {
            com.meizu.cloud.pushinternal.DebugLogger.i("DeviceUtils", "current product is phone");
            return true;
        }
        com.meizu.cloud.pushinternal.DebugLogger.i("DeviceUtils", "current product is " + a2);
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @android.annotation.SuppressLint({"MissingPermission", "HardwareIds"})
    public static java.lang.String b(android.content.Context context) {
        java.lang.String deviceId;
        try {
            com.meizu.cloud.pushsdk.b.b.d a2 = com.meizu.cloud.pushsdk.b.b.a.a("android.telephony.MzTelephonyManager").a("getDeviceId", new java.lang.Class[0]).a(new java.lang.Object[0]);
            if (!a2.a || android.text.TextUtils.isEmpty((java.lang.CharSequence) a2.b)) {
                android.telephony.TelephonyManager telephonyManager = (android.telephony.TelephonyManager) context.getSystemService(com.aliyun.vod.log.core.AliyunLogCommon.TERMINAL_TYPE);
                if (telephonyManager == null) {
                    return null;
                }
                deviceId = telephonyManager.getDeviceId();
            } else {
                deviceId = (java.lang.String) a2.b;
            }
            return deviceId;
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @android.annotation.SuppressLint({"HardwareIds"})
    public static java.lang.String c(android.content.Context context) {
        return null;
    }

    private static java.lang.String d(android.content.Context context) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        java.lang.String str = android.os.Build.SERIAL;
        com.meizu.cloud.pushinternal.DebugLogger.i("DeviceUtils", "device serial " + str);
        if (!android.text.TextUtils.isEmpty(str)) {
            sb.append(str);
            java.lang.String c = c(context);
            com.meizu.cloud.pushinternal.DebugLogger.e("DeviceUtils", "mac address " + c);
            if (!android.text.TextUtils.isEmpty(c)) {
                sb.append(c.replace(com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR, "").toUpperCase());
                return sb.toString();
            }
        }
        return null;
    }
}
