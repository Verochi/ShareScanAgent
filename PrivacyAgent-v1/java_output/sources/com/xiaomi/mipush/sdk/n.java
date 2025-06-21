package com.xiaomi.mipush.sdk;

/* loaded from: classes19.dex */
public class n {
    private static int a = -1;

    public static com.xiaomi.mipush.sdk.ag a(android.content.Context context) {
        try {
            return (context.getPackageManager().getServiceInfo(new android.content.ComponentName("com.huawei.hwid", "com.huawei.hms.core.service.HMSCoreService"), 128) == null || !a()) ? com.xiaomi.mipush.sdk.ag.OTHER : com.xiaomi.mipush.sdk.ag.HUAWEI;
        } catch (java.lang.Exception unused) {
            return com.xiaomi.mipush.sdk.ag.OTHER;
        }
    }

    private static boolean a() {
        try {
            java.lang.String str = (java.lang.String) com.xiaomi.push.aj.a("android.os.SystemProperties", com.ss.android.socialbase.downloader.constants.MonitorConstants.CONNECT_TYPE_GET, "ro.build.hw_emui_api_level", "");
            if (!android.text.TextUtils.isEmpty(str)) {
                if (java.lang.Integer.parseInt(str) >= 9) {
                    return true;
                }
            }
        } catch (java.lang.Exception e) {
            com.xiaomi.channel.commonutils.logger.b.a(e);
        }
        return false;
    }

    /* renamed from: a, reason: collision with other method in class */
    public static boolean m154a(android.content.Context context) {
        java.lang.Object a2 = com.xiaomi.push.aj.a(com.xiaomi.push.aj.a("com.google.android.gms.common.GoogleApiAvailability", "getInstance", new java.lang.Object[0]), "isGooglePlayServicesAvailable", context);
        java.lang.Object a3 = com.xiaomi.push.aj.a("com.google.android.gms.common.ConnectionResult", com.alipay.sdk.m.f0.c.p);
        if (a3 == null || !(a3 instanceof java.lang.Integer)) {
            com.xiaomi.channel.commonutils.logger.b.c("google service is not avaliable");
            a = 0;
            return false;
        }
        int intValue = ((java.lang.Integer) java.lang.Integer.class.cast(a3)).intValue();
        if (a2 != null) {
            if (a2 instanceof java.lang.Integer) {
                a = ((java.lang.Integer) java.lang.Integer.class.cast(a2)).intValue() == intValue ? 1 : 0;
            } else {
                a = 0;
                com.xiaomi.channel.commonutils.logger.b.c("google service is not avaliable");
            }
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder("is google service can be used");
        sb.append(a > 0);
        com.xiaomi.channel.commonutils.logger.b.c(sb.toString());
        return a > 0;
    }

    public static boolean b(android.content.Context context) {
        boolean z = false;
        java.lang.Object a2 = com.xiaomi.push.aj.a("com.xiaomi.assemble.control.COSPushManager", "isSupportPush", context);
        if (a2 != null && (a2 instanceof java.lang.Boolean)) {
            z = ((java.lang.Boolean) java.lang.Boolean.class.cast(a2)).booleanValue();
        }
        com.xiaomi.channel.commonutils.logger.b.c("color os push  is avaliable ? :".concat(java.lang.String.valueOf(z)));
        return z;
    }

    public static boolean c(android.content.Context context) {
        boolean z = false;
        java.lang.Object a2 = com.xiaomi.push.aj.a("com.xiaomi.assemble.control.FTOSPushManager", "isSupportPush", context);
        if (a2 != null && (a2 instanceof java.lang.Boolean)) {
            z = ((java.lang.Boolean) java.lang.Boolean.class.cast(a2)).booleanValue();
        }
        com.xiaomi.channel.commonutils.logger.b.c("fun touch os push  is avaliable ? :".concat(java.lang.String.valueOf(z)));
        return z;
    }
}
