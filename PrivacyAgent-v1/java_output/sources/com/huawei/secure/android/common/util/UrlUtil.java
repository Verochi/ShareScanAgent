package com.huawei.secure.android.common.util;

/* loaded from: classes22.dex */
public class UrlUtil {
    public static boolean isAboutUrl(java.lang.String str) {
        return android.webkit.URLUtil.isAboutUrl(str);
    }

    public static boolean isAssetUrl(java.lang.String str) {
        return android.webkit.URLUtil.isAssetUrl(str);
    }

    public static boolean isContentUrl(java.lang.String str) {
        return android.webkit.URLUtil.isContentUrl(str);
    }

    public static boolean isDataUrl(java.lang.String str) {
        return android.webkit.URLUtil.isDataUrl(str);
    }

    public static boolean isFileUrl(java.lang.String str) {
        return android.webkit.URLUtil.isFileUrl(str);
    }

    public static boolean isHttpUrl(java.lang.String str) {
        return android.webkit.URLUtil.isHttpUrl(str);
    }

    public static boolean isHttpsUrl(java.lang.String str) {
        return android.webkit.URLUtil.isHttpsUrl(str);
    }

    public static boolean isJavaScriptUrl(java.lang.String str) {
        return android.webkit.URLUtil.isJavaScriptUrl(str);
    }

    public static boolean isNetworkUrl(java.lang.String str) {
        return android.webkit.URLUtil.isNetworkUrl(str);
    }

    public static boolean isResourceUrl(java.lang.String str) {
        return str != null && str.startsWith("file:///android_res/");
    }

    public static boolean isValidUrl(java.lang.String str) {
        return android.webkit.URLUtil.isValidUrl(str);
    }
}
