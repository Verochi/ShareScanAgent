package com.igexin.assist.util;

/* loaded from: classes22.dex */
public class AssistUtils {
    public static final java.lang.String BRAND_HON = "honor";
    public static final java.lang.String BRAND_HW = "huawei";
    public static final java.lang.String BRAND_MZ = "meizu";
    public static final java.lang.String BRAND_OPPO = "oppo";
    public static final java.lang.String BRAND_STP = "stp";
    public static final java.lang.String BRAND_VIVO = "vivo";
    public static final java.lang.String BRAND_XIAOMI = "xiaomi";
    static java.lang.String a = "";

    /* JADX WARN: Code restructure failed: missing block: B:9:0x001b, code lost:
    
        if (com.igexin.push.h.b.a(r0, com.igexin.assist.util.AssistUtils.BRAND_HON) != false) goto L13;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static java.lang.String getDeviceBrand() {
        java.lang.String str;
        if (!android.text.TextUtils.isEmpty(a)) {
            return a;
        }
        if (com.igexin.push.config.d.U) {
            android.content.Context applicationContext = com.igexin.push.core.ServiceManager.b.getApplicationContext();
            str = BRAND_HON;
        }
        android.content.Context applicationContext2 = com.igexin.push.core.ServiceManager.b.getApplicationContext();
        str = BRAND_HW;
        if (!com.igexin.push.h.b.a(applicationContext2, BRAND_HW)) {
            android.content.Context applicationContext3 = com.igexin.push.core.ServiceManager.b.getApplicationContext();
            str = BRAND_XIAOMI;
            if (!com.igexin.push.h.b.a(applicationContext3, BRAND_XIAOMI)) {
                android.content.Context applicationContext4 = com.igexin.push.core.ServiceManager.b.getApplicationContext();
                str = BRAND_OPPO;
                if (!com.igexin.push.h.b.a(applicationContext4, BRAND_OPPO)) {
                    android.content.Context applicationContext5 = com.igexin.push.core.ServiceManager.b.getApplicationContext();
                    str = BRAND_MZ;
                    if (!com.igexin.push.h.b.a(applicationContext5, BRAND_MZ)) {
                        android.content.Context applicationContext6 = com.igexin.push.core.ServiceManager.b.getApplicationContext();
                        str = BRAND_VIVO;
                        if (!com.igexin.push.h.b.a(applicationContext6, BRAND_VIVO)) {
                            a = com.igexin.push.h.b.a(com.igexin.push.core.ServiceManager.b) ? BRAND_STP : android.os.Build.BRAND;
                            return a.toLowerCase();
                        }
                    }
                }
            }
        }
        a = str;
        return a.toLowerCase();
    }

    public static void startGetuiService(android.content.Context context) {
        if (context != null) {
            try {
                com.igexin.sdk.PushManager.getInstance().initialize(context);
            } catch (java.lang.Throwable th) {
                com.igexin.c.a.c.a.a(th);
            }
        }
    }
}
