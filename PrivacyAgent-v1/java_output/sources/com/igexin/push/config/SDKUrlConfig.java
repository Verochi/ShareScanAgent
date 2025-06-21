package com.igexin.push.config;

/* loaded from: classes31.dex */
public class SDKUrlConfig {
    private static java.lang.String[] b = null;
    private static java.lang.String c = "HZ";
    private static final java.lang.String d = "socket://sdk.open.talk.igexin.com:5224";
    private static final java.lang.String e = "socket://sdk.open.talk.getui.net:5224";
    private static final java.lang.String f = "socket://sdk.open.talk.gepush.com:5224";
    private static volatile java.lang.String h;
    private static final java.lang.Object a = new java.lang.Object();
    private static java.lang.String[] g = {"socket://sdk.open.talk.igexin.com:5224", "socket://sdk.open.talk.getui.net:5224", "socket://sdk.open.talk.gepush.com:5224"};
    public static java.lang.String[] XFR_ADDRESS_BAK = {com.igexin.push.a.m};
    public static java.lang.String[] BI_ADDRESS_IPS = {"https://sdk-open-phone.getui.com/api.php"};
    public static java.lang.String[] CONFIG_ADDRESS_IPS = {"https://c-hzgt2.getui.com/api.php"};
    public static java.lang.String[] LOG_ADDRESS_IPS = {com.igexin.push.a.l};

    public static java.lang.String getBiUploadServiceUrl() {
        return BI_ADDRESS_IPS[0] + "?format=json&t=1";
    }

    public static java.lang.String getConfigServiceUrl() {
        return CONFIG_ADDRESS_IPS[0] + "?format=json&t=1";
    }

    public static java.lang.String getConnectAddress() {
        return h == null ? g[0] : h;
    }

    public static java.util.List<java.lang.String> getDefaultXfrList() {
        java.lang.String[] xfrAddress = getXfrAddress();
        java.util.ArrayList arrayList = new java.util.ArrayList();
        for (java.lang.String str : xfrAddress) {
            if (!arrayList.contains(str)) {
                arrayList.add(str);
            }
        }
        return arrayList;
    }

    public static java.lang.String[] getIdcConfigUrl() {
        return b;
    }

    public static java.lang.String getLocation() {
        return c;
    }

    public static java.lang.String getLogServiceUrl() {
        return LOG_ADDRESS_IPS[0] + "?format=json&t=1";
    }

    public static java.lang.String[] getXfrAddress() {
        java.lang.String[] strArr;
        synchronized (a) {
            strArr = g;
        }
        return strArr;
    }

    public static boolean hasMultipleXfr() {
        return getDefaultXfrList().size() > 1;
    }

    public static void setConnectAddress(java.lang.String str) {
        com.igexin.c.a.c.a.a("set cm address : ".concat(java.lang.String.valueOf(str)), new java.lang.Object[0]);
        h = str;
    }

    public static void setIdcConfigUrl(java.lang.String[] strArr) {
        b = strArr;
    }

    public static void setLocation(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return;
        }
        com.igexin.push.core.e.f = str;
        c = str;
    }

    public static void setXfrAddressIps(java.lang.String[] strArr) {
        synchronized (a) {
            g = strArr;
        }
    }
}
