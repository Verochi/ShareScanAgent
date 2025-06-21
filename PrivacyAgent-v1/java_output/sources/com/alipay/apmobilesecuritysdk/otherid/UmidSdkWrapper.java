package com.alipay.apmobilesecuritysdk.otherid;

/* loaded from: classes.dex */
public class UmidSdkWrapper {
    public static final java.lang.String UMIDTOKEN_FILE_NAME = "xxxwww_v2";
    public static final java.lang.String UMIDTOKEN_KEY_NAME = "umidtk";
    public static volatile java.lang.String cachedUmidToken = "";
    public static volatile boolean initUmidFinished;

    public static java.lang.String compatUmidBug(android.content.Context context, java.lang.String str) {
        if (!com.alipay.sdk.m.z.a.a(str) && !com.alipay.sdk.m.z.a.a(str, "000000000000000000000000")) {
            return str;
        }
        java.lang.String utdid = com.alipay.apmobilesecuritysdk.otherid.UtdidWrapper.getUtdid(context);
        if (utdid != null && utdid.contains("?")) {
            utdid = "";
        }
        return com.alipay.sdk.m.z.a.a(utdid) ? "" : utdid;
    }

    public static synchronized java.lang.String getSecurityToken(android.content.Context context) {
        java.lang.String str;
        synchronized (com.alipay.apmobilesecuritysdk.otherid.UmidSdkWrapper.class) {
            str = cachedUmidToken;
        }
        return str;
    }

    public static java.lang.String startUmidTaskSync(android.content.Context context, int i) {
        return "";
    }

    public static synchronized void updateLocalUmidToken(android.content.Context context, java.lang.String str) {
        synchronized (com.alipay.apmobilesecuritysdk.otherid.UmidSdkWrapper.class) {
            if (com.alipay.sdk.m.z.a.b(str)) {
                com.alipay.sdk.m.b0.d.a(context, UMIDTOKEN_FILE_NAME, UMIDTOKEN_KEY_NAME, str);
                cachedUmidToken = str;
            }
        }
    }
}
