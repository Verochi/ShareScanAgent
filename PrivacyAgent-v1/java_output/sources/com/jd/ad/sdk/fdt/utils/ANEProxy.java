package com.jd.ad.sdk.fdt.utils;

/* loaded from: classes23.dex */
public class ANEProxy {
    public static synchronized java.lang.String ja(java.lang.String str) {
        java.lang.String jad_cp;
        synchronized (com.jd.ad.sdk.fdt.utils.ANEProxy.class) {
            jad_cp = com.jd.ad.sdk.fdt.utils.ANE.jad_cp(str);
        }
        return jad_cp;
    }

    public static synchronized java.lang.String jb(java.lang.String str) {
        java.lang.String jad_an;
        synchronized (com.jd.ad.sdk.fdt.utils.ANEProxy.class) {
            jad_an = com.jd.ad.sdk.fdt.utils.ANE.jad_an(str);
        }
        return jad_an;
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x0044, code lost:
    
        if (r3.endsWith(com.alipay.sdk.m.u.i.d) != false) goto L23;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static synchronized java.lang.String jc(java.lang.String str) {
        java.lang.String trim;
        synchronized (com.jd.ad.sdk.fdt.utils.ANEProxy.class) {
            synchronized (com.jd.ad.sdk.fdt.utils.ANE.class) {
                int i = com.jd.ad.sdk.fdt.utils.ANE.jad_an;
                if (!android.text.TextUtils.isEmpty(str)) {
                    trim = str.trim();
                    if (!trim.startsWith("{") || !trim.endsWith(com.alipay.sdk.m.u.i.d)) {
                        try {
                            trim = com.jd.ad.sdk.fdt.utils.ANE.jad_an(trim);
                        } catch (java.lang.Throwable th) {
                            com.jd.ad.sdk.logger.Logger.d(android.util.Log.getStackTraceString(th));
                            trim = "";
                        }
                        if (trim.startsWith("{")) {
                        }
                    }
                }
                trim = "";
            }
        }
        return trim;
    }

    public static synchronized java.lang.String jd(java.lang.String str) {
        java.lang.String jad_dq;
        synchronized (com.jd.ad.sdk.fdt.utils.ANEProxy.class) {
            jad_dq = com.jd.ad.sdk.fdt.utils.ANE.jad_dq(str);
        }
        return jad_dq;
    }

    public static synchronized java.lang.String je(java.lang.String str) {
        java.lang.String jad_bo;
        synchronized (com.jd.ad.sdk.fdt.utils.ANEProxy.class) {
            jad_bo = com.jd.ad.sdk.fdt.utils.ANE.jad_bo(str);
        }
        return jad_bo;
    }
}
