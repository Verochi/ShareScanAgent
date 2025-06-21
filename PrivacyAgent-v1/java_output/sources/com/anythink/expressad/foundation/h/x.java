package com.anythink.expressad.foundation.h;

/* loaded from: classes12.dex */
public final class x {
    public static java.lang.String a(java.lang.String str) {
        try {
            return (android.text.TextUtils.isEmpty(str) || !android.webkit.URLUtil.isValidUrl(str)) ? str : new java.net.URL(str).getPath();
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static java.lang.String a(java.lang.String str, java.lang.String str2) {
        try {
            return (android.text.TextUtils.isEmpty(str) || !android.webkit.URLUtil.isValidUrl(str)) ? str : android.net.Uri.parse(str).getQueryParameter(str2);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static int b(java.lang.String str) {
        try {
            if (android.text.TextUtils.isEmpty(str) || !android.webkit.URLUtil.isValidUrl(str)) {
                return 0;
            }
            return android.net.Uri.parse(str).getQueryParameterNames().size();
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public static java.lang.String c(java.lang.String str) {
        try {
            if (android.text.TextUtils.isEmpty(str) || str.contains("n_logo=0")) {
                return str;
            }
            java.util.Set<java.lang.String> queryParameterNames = android.net.Uri.parse(str).getQueryParameterNames();
            if (queryParameterNames != null && queryParameterNames.size() != 0) {
                return str + "&n_logo=0";
            }
            return str + "?n_logo=0";
        } catch (java.lang.Exception unused) {
            return str;
        }
    }
}
