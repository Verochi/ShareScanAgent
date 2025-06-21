package com.anythink.china.b;

/* loaded from: classes12.dex */
public final class c {
    public static java.lang.String a(android.content.Context context) {
        java.lang.String str = "";
        if (com.anythink.core.common.b.o.a().c("imei")) {
            return "";
        }
        try {
            int i = android.os.Build.VERSION.SDK_INT;
            str = i < 23 ? b(context) : i < 26 ? a(c(context)) : a(d(context));
        } catch (java.lang.Throwable unused) {
        }
        return str;
    }

    private static java.lang.String a(java.util.Map map) {
        return map != null ? (java.lang.String) map.get("imei1") : "";
    }

    private static java.lang.String b(android.content.Context context) {
        android.telephony.TelephonyManager telephonyManager = (android.telephony.TelephonyManager) context.getSystemService(com.aliyun.vod.log.core.AliyunLogCommon.TERMINAL_TYPE);
        if (telephonyManager == null) {
            return null;
        }
        try {
            return telephonyManager.getDeviceId();
        } catch (java.lang.Throwable unused) {
            return null;
        }
    }

    @android.annotation.TargetApi(23)
    private static java.util.Map c(android.content.Context context) {
        java.lang.String deviceId;
        java.lang.String deviceId2;
        java.lang.String deviceId3;
        java.lang.String deviceId4;
        java.lang.String deviceId5;
        java.util.HashMap hashMap = new java.util.HashMap();
        android.telephony.TelephonyManager telephonyManager = (android.telephony.TelephonyManager) context.getSystemService(com.aliyun.vod.log.core.AliyunLogCommon.TERMINAL_TYPE);
        try {
            java.lang.reflect.Method method = java.lang.Class.forName("android.os.SystemProperties").getMethod(com.ss.android.socialbase.downloader.constants.MonitorConstants.CONNECT_TYPE_GET, java.lang.String.class, java.lang.String.class);
            java.lang.String str = (java.lang.String) method.invoke(null, "ril.gsm.imei", "");
            hashMap.put("meid", (java.lang.String) method.invoke(null, "ril.cdma.meid", ""));
            if (android.text.TextUtils.isEmpty(str)) {
                deviceId = telephonyManager.getDeviceId(0);
                hashMap.put("imei1", deviceId);
                deviceId2 = telephonyManager.getDeviceId(1);
                hashMap.put("imei2", deviceId2);
            } else {
                java.lang.String[] split = str.split(",");
                if (split == null || split.length <= 0) {
                    deviceId3 = telephonyManager.getDeviceId(0);
                    hashMap.put("imei1", deviceId3);
                    deviceId4 = telephonyManager.getDeviceId(1);
                    hashMap.put("imei2", deviceId4);
                } else {
                    hashMap.put("imei1", split[0]);
                    if (split.length > 1) {
                        hashMap.put("imei2", split[1]);
                    } else {
                        deviceId5 = telephonyManager.getDeviceId(1);
                        hashMap.put("imei2", deviceId5);
                    }
                }
            }
        } catch (java.lang.Throwable unused) {
        }
        return hashMap;
    }

    @android.annotation.TargetApi(26)
    private static java.util.Map d(android.content.Context context) {
        java.lang.String imei;
        java.lang.String imei2;
        java.lang.String meid;
        java.util.HashMap hashMap = new java.util.HashMap();
        try {
            android.telephony.TelephonyManager telephonyManager = (android.telephony.TelephonyManager) context.getSystemService(com.aliyun.vod.log.core.AliyunLogCommon.TERMINAL_TYPE);
            imei = telephonyManager.getImei(0);
            imei2 = telephonyManager.getImei(1);
            if (android.text.TextUtils.isEmpty(imei) && android.text.TextUtils.isEmpty(imei2)) {
                meid = telephonyManager.getMeid();
                hashMap.put("imei1", meid);
            } else {
                hashMap.put("imei1", imei);
                hashMap.put("imei2", imei2);
            }
        } catch (java.lang.Throwable unused) {
        }
        return hashMap;
    }
}
