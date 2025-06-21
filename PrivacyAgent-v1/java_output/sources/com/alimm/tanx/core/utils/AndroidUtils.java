package com.alimm.tanx.core.utils;

/* loaded from: classes.dex */
public class AndroidUtils implements com.alimm.tanx.core.utils.NotConfused {
    private static final java.lang.String TAG = "PackageUtils";
    private static com.alimm.tanx.core.ad.bean.RequestBaseBean.AdDeviceBean deviceBean;

    public static java.lang.String getAndroidId() {
        return "";
    }

    public static java.lang.String getAppName(android.content.Context context) {
        try {
            android.content.pm.PackageManager packageManager = context.getPackageManager();
            return com.alimm.tanx.core.utils.StringUtil.filterNonPrintableCharacters(java.lang.String.valueOf(packageManager.getApplicationLabel(packageManager.getPackageInfo(context.getPackageName(), 0).applicationInfo)));
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static java.lang.String getAppVersion(android.content.Context context, java.lang.String str) {
        try {
            return context.getPackageManager().getPackageInfo(str, 0).versionName;
        } catch (android.content.pm.PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return str;
        }
    }

    public static java.lang.String getBrand() {
        return com.alimm.tanx.core.utils.StringUtil.filterNonPrintableCharacters(android.os.Build.BRAND);
    }

    public static com.alimm.tanx.core.ad.bean.RequestBaseBean.AdDeviceBean getDeviceBean() {
        getDeviceInfo(true);
        return deviceBean;
    }

    public static java.lang.String getDeviceInfo(boolean z) {
        try {
            if (deviceBean == null) {
                com.alimm.tanx.core.ad.bean.RequestBaseBean.AdDeviceBean adDeviceBean = new com.alimm.tanx.core.ad.bean.RequestBaseBean.AdDeviceBean();
                deviceBean = adDeviceBean;
                adDeviceBean.user_agent = getUserAgent();
                deviceBean.android_id = getAndroidId();
                com.alimm.tanx.core.ad.bean.RequestBaseBean.AdDeviceBean adDeviceBean2 = deviceBean;
                adDeviceBean2.device_type = 0;
                adDeviceBean2.brand = getBrand();
                deviceBean.model = getModel();
                com.alimm.tanx.core.ad.bean.RequestBaseBean.AdDeviceBean adDeviceBean3 = deviceBean;
                adDeviceBean3.os = "Android";
                adDeviceBean3.osv = getSystemVersion();
                android.graphics.Point screenSize = getScreenSize(com.alimm.tanx.core.TanxCoreSdk.getApplication());
                com.alimm.tanx.core.ad.bean.RequestBaseBean.AdDeviceBean adDeviceBean4 = deviceBean;
                adDeviceBean4.width = screenSize.x;
                adDeviceBean4.height = screenSize.y;
                adDeviceBean4.pixel_ratio = getDisplayDpi(com.alimm.tanx.core.TanxCoreSdk.getApplication());
            }
            deviceBean.network = com.alimm.tanx.core.utils.NetWorkUtil.getNetworkType(com.alimm.tanx.core.TanxCoreSdk.getApplication()).getKey();
            return com.alibaba.fastjson.JSON.toJSONString(deviceBean);
        } catch (java.lang.Exception e) {
            com.alimm.tanx.core.utils.LogUtils.e(e);
            e.printStackTrace();
            if (z) {
                com.alimm.tanx.core.ut.impl.TanxBaseUt.utError(com.alimm.tanx.core.ut.UtErrorCode.CRASH_ERROR.getIntCode(), "PackageUtils", com.alimm.tanx.core.utils.LogUtils.getStackTraceMessage(e), "");
            }
            return "";
        }
    }

    public static int getDisplayDpi(android.content.Context context) {
        return context.getResources().getDisplayMetrics().densityDpi;
    }

    public static java.lang.String getModel() {
        return com.alimm.tanx.core.utils.StringUtil.filterNonPrintableCharacters(android.os.Build.MODEL);
    }

    public static java.lang.String getPackageName(android.content.Context context) {
        return context != null ? com.alimm.tanx.core.utils.StringUtil.filterNonPrintableCharacters(context.getPackageName()) : "";
    }

    public static int getScreenOrientation(android.content.Context context) {
        int i = context.getResources().getConfiguration().orientation;
        if (i == 1) {
            return 1;
        }
        return i == 2 ? 2 : 0;
    }

    public static android.graphics.Point getScreenSize(android.content.Context context) {
        android.view.Display defaultDisplay = ((android.view.WindowManager) context.getSystemService("window")).getDefaultDisplay();
        android.graphics.Point point = new android.graphics.Point();
        defaultDisplay.getSize(point);
        return point;
    }

    public static java.lang.String getSystemVersion() {
        return android.os.Build.VERSION.RELEASE;
    }

    public static java.lang.String getUserAgent() {
        return com.alimm.tanx.core.utils.StringUtil.filterNonPrintableCharacters(java.lang.System.getProperty("http.agent"));
    }

    public static java.lang.String getUserAgentSuffix() {
        return " AliApp(TANXSDK/" + com.alimm.tanx.core.SdkConstant.getSdkVersion() + ")";
    }

    public static com.alimm.tanx.core.ad.bean.RequestBaseBean.AdDeviceBean getUtDeviceBean() {
        getDeviceInfo(false);
        return deviceBean;
    }

    public static java.lang.String mediaNameStr() {
        try {
            com.alimm.tanx.core.config.TanxConfig config = com.alimm.tanx.core.TanxCoreSdk.getConfig();
            java.lang.String packageName = getPackageName(com.alimm.tanx.core.TanxCoreSdk.getApplication());
            java.lang.String appVersion = !android.text.TextUtils.isEmpty(packageName) ? getAppVersion(com.alimm.tanx.core.TanxCoreSdk.getApplication(), packageName) : "";
            return "AppName/" + (config != null ? config.getAppName() : "") + net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR + packageName + net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR + appVersion;
        } catch (java.lang.Exception e) {
            com.alimm.tanx.core.utils.LogUtils.e(e);
            return "";
        }
    }
}
