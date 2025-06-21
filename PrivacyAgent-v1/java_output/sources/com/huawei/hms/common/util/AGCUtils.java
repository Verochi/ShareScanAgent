package com.huawei.hms.common.util;

/* loaded from: classes22.dex */
public class AGCUtils {
    public static java.lang.String a(android.content.Context context) {
        android.os.Bundle bundle;
        java.lang.Object obj;
        android.content.pm.PackageManager packageManager = context.getPackageManager();
        if (packageManager == null) {
            com.huawei.hms.support.log.HMSLog.e("AGCUtils", "In getMetaDataAppId, Failed to get 'PackageManager' instance.");
            return "";
        }
        try {
            android.content.pm.ApplicationInfo applicationInfo = packageManager.getPackageInfo(context.getPackageName(), 128).applicationInfo;
            if (applicationInfo == null || (bundle = applicationInfo.metaData) == null || (obj = bundle.get(com.xiaomi.mipush.sdk.Constants.HUAWEI_HMS_CLIENT_APPID)) == null) {
                com.huawei.hms.support.log.HMSLog.e("AGCUtils", "In getMetaDataAppId, Failed to read meta data for the AppID.");
                return "";
            }
            java.lang.String valueOf = java.lang.String.valueOf(obj);
            return valueOf.startsWith("appid=") ? valueOf.substring(6) : valueOf;
        } catch (android.content.pm.PackageManager.NameNotFoundException unused) {
            com.huawei.hms.support.log.HMSLog.e("AGCUtils", "In getMetaDataAppId, Failed to read meta data for the AppID.");
            return "";
        } catch (java.lang.RuntimeException e) {
            com.huawei.hms.support.log.HMSLog.e("AGCUtils", "In getMetaDataAppId, Failed to read meta data for the AppID.", e);
            return "";
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:6:0x0069 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x006a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static java.lang.String a(android.content.Context context, java.lang.String str) {
        java.lang.String str2;
        java.io.InputStream inputStream = null;
        try {
            try {
                try {
                    com.huawei.agconnect.AGConnectOptionsBuilder aGConnectOptionsBuilder = new com.huawei.agconnect.AGConnectOptionsBuilder();
                    inputStream = context.getResources().getAssets().open("agconnect-services.json");
                    aGConnectOptionsBuilder.setInputStream(inputStream);
                    str2 = aGConnectOptionsBuilder.build(context).getString(str);
                } catch (java.io.IOException e) {
                    com.huawei.hms.support.log.HMSLog.e("AGCUtils", "Get " + str + " failed: " + e);
                    str2 = "";
                    com.huawei.hms.utils.IOUtils.closeQuietly(inputStream);
                    if (!android.text.TextUtils.isEmpty(str2)) {
                    }
                }
            } catch (java.lang.NullPointerException e2) {
                com.huawei.hms.support.log.HMSLog.e("AGCUtils", "Get " + str + " with AGConnectServicesConfig failed: " + e2);
                str2 = "";
                com.huawei.hms.utils.IOUtils.closeQuietly(inputStream);
                if (!android.text.TextUtils.isEmpty(str2)) {
                }
            }
            com.huawei.hms.utils.IOUtils.closeQuietly(inputStream);
            if (!android.text.TextUtils.isEmpty(str2)) {
                return str2;
            }
            com.huawei.hms.support.log.HMSLog.e("AGCUtils", "The " + str + " is null.");
            return "";
        } catch (java.lang.Throwable th) {
            com.huawei.hms.utils.IOUtils.closeQuietly(inputStream);
            throw th;
        }
    }

    public static java.lang.String b(android.content.Context context) {
        android.os.Bundle bundle;
        java.lang.Object obj;
        android.content.pm.PackageManager packageManager = context.getPackageManager();
        if (packageManager == null) {
            com.huawei.hms.support.log.HMSLog.e("AGCUtils", "In getMetaDataCpId, Failed to get 'PackageManager' instance.");
            return "";
        }
        try {
            android.content.pm.ApplicationInfo applicationInfo = packageManager.getPackageInfo(context.getPackageName(), 128).applicationInfo;
            if (applicationInfo == null || (bundle = applicationInfo.metaData) == null || (obj = bundle.get("com.huawei.hms.client.cpid")) == null) {
                com.huawei.hms.support.log.HMSLog.i("AGCUtils", "In getMetaDataCpId, Failed to read meta data for the CpId.");
                return "";
            }
            java.lang.String valueOf = java.lang.String.valueOf(obj);
            return valueOf.startsWith("cpid=") ? valueOf.substring(5) : valueOf;
        } catch (android.content.pm.PackageManager.NameNotFoundException unused) {
            com.huawei.hms.support.log.HMSLog.e("AGCUtils", "In getMetaDataCpId, Failed to read meta data for the CpId.");
            return "";
        } catch (java.lang.RuntimeException e) {
            com.huawei.hms.support.log.HMSLog.e("AGCUtils", "In getMetaDataCpId, Failed to read meta data for the CpId.", e);
            return "";
        }
    }

    public static boolean c(android.content.Context context) {
        return context.getPackageName().equals(com.huawei.hms.utils.HMSPackageManager.getInstance(context).getHMSPackageNameForMultiService());
    }

    public static java.lang.String getAppId(android.content.Context context) {
        java.lang.String str;
        if (c(context)) {
            str = a(context, "client/app_id");
            if (!android.text.TextUtils.isEmpty(str)) {
                return str;
            }
        } else {
            str = null;
        }
        try {
            com.huawei.agconnect.AGConnectInstance aGConnectInstance = com.huawei.agconnect.AGConnectInstance.getInstance();
            if (aGConnectInstance.getContext() != context) {
                aGConnectInstance = com.huawei.agconnect.AGConnectInstance.buildInstance(new com.huawei.agconnect.AGConnectOptionsBuilder().build(context));
            }
            str = aGConnectInstance.getOptions().getString("client/app_id");
        } catch (java.lang.NullPointerException unused) {
            com.huawei.hms.support.log.HMSLog.e("AGCUtils", "Get appId with AGConnectServicesConfig failed");
        }
        if (!android.text.TextUtils.isEmpty(str)) {
            return str;
        }
        java.lang.String a = a(context);
        return !android.text.TextUtils.isEmpty(a) ? a : a(context, "client/app_id");
    }

    public static java.lang.String getCpId(android.content.Context context) {
        java.lang.String str;
        if (c(context)) {
            return a(context, "client/cp_id");
        }
        try {
            com.huawei.agconnect.AGConnectInstance aGConnectInstance = com.huawei.agconnect.AGConnectInstance.getInstance();
            if (aGConnectInstance.getContext() != context) {
                aGConnectInstance = com.huawei.agconnect.AGConnectInstance.buildInstance(new com.huawei.agconnect.AGConnectOptionsBuilder().build(context));
            }
            str = aGConnectInstance.getOptions().getString("client/cp_id");
        } catch (java.lang.NullPointerException unused) {
            com.huawei.hms.support.log.HMSLog.e("AGCUtils", "Get cpid with AGConnectServicesConfig failed");
            str = null;
        }
        if (!android.text.TextUtils.isEmpty(str)) {
            return str;
        }
        java.lang.String b = b(context);
        return !android.text.TextUtils.isEmpty(b) ? b : a(context, "client/cp_id");
    }
}
