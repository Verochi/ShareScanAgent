package com.alipay.sdk.m.p;

/* loaded from: classes.dex */
public class a {
    public static java.lang.String a(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return "";
        }
        java.lang.String[] split = str.split("&");
        if (split.length == 0) {
            return "";
        }
        java.lang.String str2 = null;
        java.lang.String str3 = null;
        java.lang.String str4 = null;
        java.lang.String str5 = null;
        for (java.lang.String str6 : split) {
            if (android.text.TextUtils.isEmpty(str2)) {
                str2 = e(str6);
            }
            if (android.text.TextUtils.isEmpty(str3)) {
                str3 = d(str6);
            }
            if (android.text.TextUtils.isEmpty(str4)) {
                str4 = f(str6);
            }
            if (android.text.TextUtils.isEmpty(str5)) {
                str5 = c(str6);
            }
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        if (!android.text.TextUtils.isEmpty(str2)) {
            sb.append("biz_type=" + str2 + com.alipay.sdk.m.u.i.b);
        }
        if (!android.text.TextUtils.isEmpty(str3)) {
            sb.append("biz_no=" + str3 + com.alipay.sdk.m.u.i.b);
        }
        if (!android.text.TextUtils.isEmpty(str4)) {
            sb.append("trade_no=" + str4 + com.alipay.sdk.m.u.i.b);
        }
        if (!android.text.TextUtils.isEmpty(str5)) {
            sb.append("app_userid=" + str5 + com.alipay.sdk.m.u.i.b);
        }
        java.lang.String sb2 = sb.toString();
        return sb2.endsWith(com.alipay.sdk.m.u.i.b) ? sb2.substring(0, sb2.length() - 1) : sb2;
    }

    public static java.lang.String b(java.lang.String str) {
        java.lang.String[] split = str.split(com.huawei.hms.framework.common.ContainerUtils.KEY_VALUE_DELIMITER);
        if (split.length <= 1) {
            return null;
        }
        java.lang.String str2 = split[1];
        return str2.contains("\"") ? str2.replaceAll("\"", "") : str2;
    }

    public static java.lang.String c(java.lang.String str) {
        if (str.contains("app_userid")) {
            return b(str);
        }
        return null;
    }

    public static java.lang.String d(java.lang.String str) {
        if (str.contains("biz_no")) {
            return b(str);
        }
        return null;
    }

    public static java.lang.String e(java.lang.String str) {
        if (str.contains("biz_type")) {
            return b(str);
        }
        return null;
    }

    public static java.lang.String f(java.lang.String str) {
        if (!str.contains(com.alipay.sdk.m.k.b.B0) || str.startsWith(com.alipay.sdk.m.k.b.A0)) {
            return null;
        }
        return b(str);
    }
}
