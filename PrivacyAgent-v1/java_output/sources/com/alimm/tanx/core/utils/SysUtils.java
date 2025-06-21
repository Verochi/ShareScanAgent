package com.alimm.tanx.core.utils;

/* loaded from: classes.dex */
public class SysUtils implements com.alimm.tanx.core.utils.NotConfused {
    private static final java.lang.String TAG = "SysUtils";

    public static boolean checkUrlSuffixAndValid(java.lang.String str) {
        java.lang.String urlSuffix = getUrlSuffix(str);
        if (android.text.TextUtils.isEmpty(urlSuffix)) {
            return false;
        }
        return com.alimm.tanx.core.orange.OrangeManager.getInstance().getWebSuffixWhiteSwitch(urlSuffix);
    }

    public static long currentTimeSecs() {
        return java.lang.System.currentTimeMillis() / 1000;
    }

    public static java.util.List<java.lang.String> getInstallStatus() {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        java.util.HashMap<java.lang.String, java.lang.Boolean> installSwitch = com.alimm.tanx.core.orange.OrangeManager.getInstance().getInstallSwitch();
        if (com.alimm.tanx.core.orange.OrangeManager.getInstance().getInstallSwitch() != null) {
            for (java.util.Map.Entry<java.lang.String, java.lang.Boolean> entry : installSwitch.entrySet()) {
                if (entry.getValue() != null && entry.getValue().booleanValue() && !android.text.TextUtils.isEmpty(entry.getKey()) && hasPackage(com.alimm.tanx.core.TanxCoreSdk.getApplication(), entry.getKey())) {
                    arrayList.add(entry.getKey());
                }
            }
        }
        return arrayList;
    }

    public static int getScreenHeight(android.content.Context context) {
        return context.getResources().getDisplayMetrics().heightPixels;
    }

    public static int getScreenWidth(android.content.Context context) {
        return context.getResources().getDisplayMetrics().widthPixels;
    }

    public static int getStatusBarHeight(android.content.Context context) {
        try {
            int identifier = context.getResources().getIdentifier("status_bar_height", "dimen", com.aliyun.vod.log.core.AliyunLogCommon.OPERATION_SYSTEM);
            if (identifier <= 0) {
                identifier = com.alimm.tanx.core.R.dimen.default_status_bar_height;
            }
            int dimensionPixelSize = context.getResources().getDimensionPixelSize(identifier);
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("System StatusBar height : ");
            sb.append(dimensionPixelSize);
            return dimensionPixelSize;
        } catch (java.lang.Exception unused) {
            return context.getResources().getDimensionPixelSize(com.alimm.tanx.core.R.dimen.default_status_bar_height);
        }
    }

    public static int getStatusBarHeight2WebView(android.content.Context context) {
        int statusbarHeight = getStatusbarHeight(context);
        int i = statusbarHeight > 0 ? statusbarHeight - 58 : 0;
        if (i <= 0) {
            return 0;
        }
        return i;
    }

    public static int getStatusbarHeight(android.content.Context context) {
        int identifier = context.getResources().getIdentifier("status_bar_height", "dimen", com.aliyun.vod.log.core.AliyunLogCommon.OPERATION_SYSTEM);
        if (identifier > 0) {
            return context.getResources().getDimensionPixelSize(identifier);
        }
        return 0;
    }

    public static java.lang.String getUrlSuffix(java.lang.String str) {
        java.lang.String[] split;
        if (android.text.TextUtils.isEmpty(str)) {
            com.alimm.tanx.core.utils.LogUtils.d("getUrlSuffix", "url为空");
            return null;
        }
        int indexOf = str.indexOf("?");
        if (indexOf > 0) {
            str = str.substring(0, indexOf);
        }
        int indexOf2 = str.indexOf("#");
        if (indexOf2 > 0) {
            str = str.substring(0, indexOf2);
        }
        java.lang.String[] split2 = str.split("[\\\\/]");
        return (split2 == null || (split = split2[split2.length - 1].split("\\.")) == null || split.length < 1) ? "" : split[split.length - 1];
    }

    private static boolean hasPackage(android.content.Context context, java.lang.String str) {
        if (context == null || str == null) {
            return false;
        }
        try {
            context.getPackageManager().getPackageInfo(str, 256);
            return true;
        } catch (java.lang.Exception unused) {
            com.alimm.tanx.core.utils.LogUtils.d("hasPackage", str + " not fount app");
            return false;
        }
    }

    public static boolean isValidUrl(java.lang.String str) {
        try {
            java.net.URI uri = new java.net.URI(str.replaceAll("\\\\", "").trim());
            if (uri.getHost() == null) {
                return false;
            }
            return uri.getScheme().equalsIgnoreCase(com.alipay.sdk.m.l.a.q) || uri.getScheme().equalsIgnoreCase("https");
        } catch (java.lang.Exception e) {
            com.alimm.tanx.core.utils.LogUtils.e(e);
            return false;
        }
    }
}
