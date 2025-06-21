package com.umeng.analytics.pro;

/* loaded from: classes19.dex */
public class bt {
    public static final java.lang.String a = "resolve.umeng.com";
    public static final int b = 15000;
    private static com.umeng.analytics.pro.bx c = null;
    private static volatile int d = -1;

    public static class a {
        public static final com.umeng.analytics.pro.bt a = new com.umeng.analytics.pro.bt(null);

        private a() {
        }
    }

    private bt() {
    }

    public /* synthetic */ bt(com.umeng.analytics.pro.bt.AnonymousClass1 anonymousClass1) {
        this();
    }

    public static com.umeng.analytics.pro.bt a() {
        return com.umeng.analytics.pro.bt.a.a;
    }

    public static java.lang.String a(java.lang.String str, java.lang.String str2) {
        if (android.text.TextUtils.isEmpty(str) || android.text.TextUtils.isEmpty(str2)) {
            return "";
        }
        return "https://" + str + net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR + str2;
    }

    public static java.lang.String b(java.lang.String str) {
        try {
            java.lang.String c2 = c(str);
            return str.substring(str.indexOf(c2) + c2.length() + 1);
        } catch (java.lang.Throwable unused) {
            return "";
        }
    }

    private java.lang.String c() {
        if (c == null) {
            c = com.umeng.analytics.pro.bx.b();
        }
        com.umeng.analytics.pro.bv bvVar = new com.umeng.analytics.pro.bv("https://resolve.umeng.com/resolve", com.umeng.analytics.pro.bv.a.GET, null, c);
        com.umeng.commonsdk.debug.UMRTLog.i(com.umeng.commonsdk.debug.UMRTLog.RTLOG_TAG, "--->>> 发送domain下发请求。");
        return bvVar.a(15000, "");
    }

    private static java.lang.String c(java.lang.String str) {
        try {
            return new java.net.URL(str).getHost();
        } catch (java.lang.Throwable unused) {
            return null;
        }
    }

    public synchronized java.lang.String a(java.lang.String str) {
        java.lang.String str2 = "";
        if (android.text.TextUtils.isEmpty(str)) {
            return "";
        }
        c();
        java.lang.String c2 = com.umeng.analytics.pro.bx.b().c();
        if (!android.text.TextUtils.isEmpty(c2)) {
            str2 = "https://" + c2 + net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR + str;
        }
        return str2;
    }

    public synchronized boolean b() {
        if (d < 0) {
            java.lang.String imprintProperty = com.umeng.commonsdk.framework.UMEnvelopeBuild.imprintProperty(com.umeng.commonsdk.service.UMGlobalContext.getAppContext(), "cj_domain", "0");
            com.umeng.commonsdk.debug.UMRTLog.i(com.umeng.commonsdk.debug.UMRTLog.RTLOG_TAG, "--->>> cj_domain读取值：" + imprintProperty);
            if ("1".equalsIgnoreCase(imprintProperty)) {
                d = 1;
            } else {
                d = 0;
            }
        }
        return d <= 0;
    }
}
