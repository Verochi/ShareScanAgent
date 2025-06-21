package com.huawei.hms.framework.network.grs.h;

/* loaded from: classes22.dex */
public class e {
    private static final java.lang.String a = "e";

    public static boolean a(java.lang.Long l) {
        if (l == null) {
            com.huawei.hms.framework.common.Logger.v(a, "Method isTimeExpire input param expireTime is null.");
            return true;
        }
        try {
        } catch (java.lang.NumberFormatException unused) {
            com.huawei.hms.framework.common.Logger.v(a, "isSpExpire spValue NumberFormatException.");
        }
        if (l.longValue() - java.lang.System.currentTimeMillis() >= 0) {
            com.huawei.hms.framework.common.Logger.i(a, "isSpExpire false.");
            return false;
        }
        com.huawei.hms.framework.common.Logger.i(a, "isSpExpire true.");
        return true;
    }

    public static boolean a(java.lang.Long l, long j) {
        if (l == null) {
            com.huawei.hms.framework.common.Logger.v(a, "Method isTimeWillExpire input param expireTime is null.");
            return true;
        }
        try {
            if (l.longValue() - (java.lang.System.currentTimeMillis() + j) >= 0) {
                com.huawei.hms.framework.common.Logger.v(a, "isSpExpire false.");
                return false;
            }
        } catch (java.lang.NumberFormatException unused) {
            com.huawei.hms.framework.common.Logger.v(a, "isSpExpire spValue NumberFormatException.");
        }
        return true;
    }
}
