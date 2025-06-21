package com.huawei.hms.opendevice;

/* loaded from: classes22.dex */
public class o {
    public static com.huawei.hms.aaid.entity.DeleteTokenReq a(android.content.Context context, java.lang.String str) {
        return a(context, null, null, str, null);
    }

    public static com.huawei.hms.aaid.entity.DeleteTokenReq a(android.content.Context context, java.lang.String str, java.lang.String str2) {
        return a(context, str, null, null, str2);
    }

    public static com.huawei.hms.aaid.entity.DeleteTokenReq a(android.content.Context context, java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4) {
        com.huawei.hms.aaid.entity.DeleteTokenReq deleteTokenReq = new com.huawei.hms.aaid.entity.DeleteTokenReq();
        deleteTokenReq.setAppId(str);
        deleteTokenReq.setScope(str4);
        deleteTokenReq.setProjectId(str2);
        deleteTokenReq.setPkgName(context.getPackageName());
        deleteTokenReq.setSubjectId(str3);
        if (android.text.TextUtils.isEmpty(str)) {
            deleteTokenReq.setAppId(com.huawei.hms.utils.Util.getAppId(context));
        }
        if (android.text.TextUtils.isEmpty(str4)) {
            deleteTokenReq.setScope(com.huawei.hms.push.HmsMessaging.DEFAULT_TOKEN_SCOPE);
        }
        if (android.text.TextUtils.isEmpty(str2)) {
            deleteTokenReq.setProjectId(d(context));
        }
        return deleteTokenReq;
    }

    public static java.lang.String a(android.content.Context context) {
        com.huawei.hms.aaid.utils.PushPreferences pushPreferences = new com.huawei.hms.aaid.utils.PushPreferences(context, "aaid");
        if (pushPreferences.containsKey("aaid")) {
            return pushPreferences.getString("aaid");
        }
        return null;
    }

    public static com.huawei.hms.aaid.entity.DeleteTokenReq b(android.content.Context context) {
        return a(context, null, null, null, null);
    }

    public static com.huawei.hms.aaid.entity.TokenReq b(android.content.Context context, java.lang.String str) {
        return b(context, null, null, str, null);
    }

    public static com.huawei.hms.aaid.entity.TokenReq b(android.content.Context context, java.lang.String str, java.lang.String str2) {
        return b(context, str, null, null, str2);
    }

    public static com.huawei.hms.aaid.entity.TokenReq b(android.content.Context context, java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4) {
        com.huawei.hms.aaid.entity.TokenReq tokenReq = new com.huawei.hms.aaid.entity.TokenReq();
        tokenReq.setPackageName(context.getPackageName());
        tokenReq.setAppId(str);
        tokenReq.setScope(str4);
        tokenReq.setProjectId(str2);
        tokenReq.setSubjectId(str3);
        tokenReq.setMultiSender(false);
        if (android.text.TextUtils.isEmpty(str)) {
            tokenReq.setAppId(com.huawei.hms.utils.Util.getAppId(context));
        }
        if (android.text.TextUtils.isEmpty(str2)) {
            tokenReq.setProjectId(d(context));
        }
        if (android.text.TextUtils.isEmpty(str4)) {
            tokenReq.setScope(com.huawei.hms.push.HmsMessaging.DEFAULT_TOKEN_SCOPE);
        }
        com.huawei.hms.opendevice.i a = com.huawei.hms.opendevice.i.a(context);
        if (a.getBoolean("hasRequestAgreement")) {
            tokenReq.setFirstTime(false);
        } else {
            tokenReq.setFirstTime(true);
            a.saveBoolean("hasRequestAgreement", true);
        }
        return tokenReq;
    }

    public static synchronized java.lang.String c(android.content.Context context) {
        java.lang.String uuid;
        synchronized (com.huawei.hms.opendevice.o.class) {
            com.huawei.hms.aaid.utils.PushPreferences pushPreferences = new com.huawei.hms.aaid.utils.PushPreferences(context, "aaid");
            if (pushPreferences.containsKey("aaid")) {
                uuid = pushPreferences.getString("aaid");
            } else {
                uuid = java.util.UUID.randomUUID().toString();
                pushPreferences.saveString("aaid", uuid);
                pushPreferences.saveLong("creationTime", java.lang.Long.valueOf(java.lang.System.currentTimeMillis()));
            }
        }
        return uuid;
    }

    public static java.lang.String d(android.content.Context context) {
        return com.huawei.agconnect.config.AGConnectServicesConfig.fromContext(context).getString("client/project_id");
    }

    public static boolean e(android.content.Context context) {
        android.os.Bundle bundle;
        try {
            android.content.pm.ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            if (applicationInfo != null && (bundle = applicationInfo.metaData) != null) {
                if (!android.text.TextUtils.isEmpty(bundle.getString("com.huawei.hms.client.service.name:base"))) {
                    return true;
                }
            }
            return false;
        } catch (android.content.pm.PackageManager.NameNotFoundException unused) {
            com.huawei.hms.support.log.HMSLog.e(com.huawei.hms.aaid.HmsInstanceId.TAG, "isIntegratedBaseSdk failed.");
            return true;
        }
    }
}
