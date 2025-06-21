package com.huawei.secure.android.common.webview;

/* loaded from: classes22.dex */
public class UriUtil {
    public static java.lang.String a(java.lang.String str) {
        if (!android.text.TextUtils.isEmpty(str)) {
            return !android.webkit.URLUtil.isNetworkUrl(str) ? str : getHostByURI(str);
        }
        com.huawei.secure.android.common.util.LogsUtil.i("UriUtil", "whiteListUrl is null");
        return null;
    }

    @android.annotation.TargetApi(9)
    public static java.lang.String getHostByURI(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            com.huawei.secure.android.common.util.LogsUtil.i("UriUtil", "url is null");
            return str;
        }
        try {
            if (android.webkit.URLUtil.isNetworkUrl(str)) {
                return new java.net.URL(str.replaceAll("[\\\\#]", net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR)).getHost();
            }
            com.huawei.secure.android.common.util.LogsUtil.e("UriUtil", "url don't starts with http or https");
            return "";
        } catch (java.net.MalformedURLException e) {
            com.huawei.secure.android.common.util.LogsUtil.e("UriUtil", "getHostByURI error  MalformedURLException : " + e.getMessage());
            return "";
        }
    }

    public static boolean isUrlHostAndPathInWhitelist(java.lang.String str, java.lang.String[] strArr) {
        if (strArr == null || strArr.length == 0) {
            com.huawei.secure.android.common.util.LogsUtil.e("UriUtil", "whitelist is null");
            return false;
        }
        for (java.lang.String str2 : strArr) {
            if (isUrlHostAndPathMatchWhitelist(str, str2)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isUrlHostAndPathMatchWhitelist(java.lang.String str, java.lang.String str2) {
        if (android.text.TextUtils.isEmpty(str) || android.text.TextUtils.isEmpty(str2) || str.contains("..") || str.contains("@")) {
            return false;
        }
        if (!str2.equals(str)) {
            if (!str.startsWith(str2 + "?")) {
                if (!str.startsWith(str2 + "#")) {
                    if (!str2.endsWith(net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR)) {
                        return false;
                    }
                    if (android.net.Uri.parse(str).getPathSegments().size() - android.net.Uri.parse(str2).getPathSegments().size() != 1) {
                        return false;
                    }
                    return str.startsWith(str2);
                }
            }
        }
        return true;
    }

    public static boolean isUrlHostInWhitelist(java.lang.String str, java.lang.String[] strArr) {
        if (strArr == null || strArr.length == 0) {
            com.huawei.secure.android.common.util.LogsUtil.e("UriUtil", "whitelist is null");
            return false;
        }
        for (java.lang.String str2 : strArr) {
            if (isUrlHostMatchWhitelist(str, str2)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isUrlHostMatchWhitelist(java.lang.String str, java.lang.String str2) {
        java.lang.String hostByURI = getHostByURI(str);
        if (android.text.TextUtils.isEmpty(hostByURI) || android.text.TextUtils.isEmpty(str2)) {
            com.huawei.secure.android.common.util.LogsUtil.e("UriUtil", "url or whitelist is null");
            return false;
        }
        java.lang.String a = a(str2);
        if (android.text.TextUtils.isEmpty(a)) {
            return false;
        }
        if (a.equals(hostByURI)) {
            return true;
        }
        if (hostByURI.endsWith(a)) {
            try {
                java.lang.String substring = hostByURI.substring(0, hostByURI.length() - a.length());
                if (substring.endsWith(".")) {
                    return substring.matches("^[A-Za-z0-9.-]+$");
                }
                return false;
            } catch (java.lang.IndexOutOfBoundsException e) {
                com.huawei.secure.android.common.util.LogsUtil.e("UriUtil", "IndexOutOfBoundsException" + e.getMessage());
            } catch (java.lang.Exception e2) {
                com.huawei.secure.android.common.util.LogsUtil.e("UriUtil", "Exception : " + e2.getMessage());
                return false;
            }
        }
        return false;
    }

    public static boolean isUrlHostSameWhitelist(java.lang.String str, java.lang.String str2) {
        if (android.text.TextUtils.isEmpty(str) || android.text.TextUtils.isEmpty(str2)) {
            return false;
        }
        return android.text.TextUtils.equals(getHostByURI(str), a(str2));
    }

    public static boolean isUrlHostSameWhitelist(java.lang.String str, java.lang.String[] strArr) {
        if (strArr == null || strArr.length == 0) {
            com.huawei.secure.android.common.util.LogsUtil.e("UriUtil", "whitelist is null");
            return false;
        }
        for (java.lang.String str2 : strArr) {
            if (isUrlHostSameWhitelist(str, str2)) {
                return true;
            }
        }
        return false;
    }
}
