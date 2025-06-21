package com.jd.ad.sdk.fdt.utils;

/* loaded from: classes23.dex */
public class ANE {
    public static final /* synthetic */ int jad_an = 0;

    static {
        try {
            java.lang.System.loadLibrary("ane");
        } catch (java.lang.Throwable th) {
            com.jd.ad.sdk.logger.Logger.d(android.util.Log.getStackTraceString(th));
        }
    }

    private static native java.lang.String a(java.lang.String str);

    private static native java.lang.String b(java.lang.String str);

    private static native java.lang.String c(java.lang.String str);

    private static native java.lang.String d(java.lang.String str);

    public static synchronized java.lang.String jad_an(java.lang.String str) {
        synchronized (com.jd.ad.sdk.fdt.utils.ANE.class) {
            if (!com.jd.ad.sdk.jad_fq.jad_jw.jad_an(str)) {
                return "";
            }
            java.lang.String str2 = "";
            try {
                str2 = b(str);
            } catch (java.lang.Throwable th) {
                com.jd.ad.sdk.logger.Logger.d(android.util.Log.getStackTraceString(th));
            }
            if (android.text.TextUtils.isEmpty(str2)) {
                str2 = "";
            }
            return str2;
        }
    }

    public static synchronized java.lang.String jad_bo(java.lang.String str) {
        synchronized (com.jd.ad.sdk.fdt.utils.ANE.class) {
            if (android.text.TextUtils.isEmpty(str)) {
                return "";
            }
            java.lang.String trim = str.trim();
            if (trim.startsWith("{") && trim.endsWith(com.alipay.sdk.m.u.i.d)) {
                return trim;
            }
            java.lang.String str2 = "";
            try {
            } catch (java.lang.Throwable th) {
                com.jd.ad.sdk.logger.Logger.d(android.util.Log.getStackTraceString(th));
            }
            synchronized (com.jd.ad.sdk.fdt.utils.ANE.class) {
                if (com.jd.ad.sdk.jad_fq.jad_jw.jad_an(trim)) {
                    java.lang.String str3 = "";
                    try {
                        str3 = d(trim);
                    } catch (java.lang.Throwable th2) {
                        com.jd.ad.sdk.logger.Logger.d(android.util.Log.getStackTraceString(th2));
                    }
                    if (android.text.TextUtils.isEmpty(str3)) {
                        str3 = "";
                    }
                    str2 = str3;
                } else {
                    str2 = "";
                }
                return (str2.startsWith("{") && str2.endsWith(com.alipay.sdk.m.u.i.d)) ? str2 : "";
            }
        }
    }

    public static synchronized java.lang.String jad_cp(java.lang.String str) {
        synchronized (com.jd.ad.sdk.fdt.utils.ANE.class) {
            if (android.text.TextUtils.isEmpty(str)) {
                return "";
            }
            java.lang.String str2 = "";
            try {
                str2 = a(str);
            } catch (java.lang.Throwable th) {
                com.jd.ad.sdk.logger.Logger.d(android.util.Log.getStackTraceString(th));
            }
            if (android.text.TextUtils.isEmpty(str2)) {
                str2 = "";
            }
            return str2;
        }
    }

    public static synchronized java.lang.String jad_dq(java.lang.String str) {
        synchronized (com.jd.ad.sdk.fdt.utils.ANE.class) {
            if (android.text.TextUtils.isEmpty(str)) {
                return "";
            }
            java.lang.String str2 = "";
            try {
                str2 = c(str);
            } catch (java.lang.Throwable th) {
                com.jd.ad.sdk.logger.Logger.d(android.util.Log.getStackTraceString(th));
            }
            if (android.text.TextUtils.isEmpty(str2)) {
                str2 = "";
            }
            return str2;
        }
    }
}
