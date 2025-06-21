package com.bytedance.sdk.openadsdk.api;

/* loaded from: classes22.dex */
public class t {
    private static boolean vw = false;
    private static int wg = 4;

    public static void t(java.lang.String str, java.lang.String str2) {
    }

    public static void t(java.lang.String str, java.lang.String str2, java.lang.Throwable th) {
    }

    public static void v(java.lang.String str, java.lang.String str2) {
    }

    private static java.lang.String vw(java.lang.Object... objArr) {
        if (objArr == null || objArr.length == 0) {
            return "";
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        for (java.lang.Object obj : objArr) {
            if (obj != null) {
                sb.append(obj.toString());
            } else {
                sb.append(" null ");
            }
            sb.append(" ");
        }
        return sb.toString();
    }

    public static void vw() {
        vw = true;
        vw(3);
    }

    public static void vw(int i) {
        wg = i;
    }

    public static void vw(java.lang.String str) {
        if (vw) {
            v("TTLogger", str);
        }
    }

    public static void vw(java.lang.String str, java.lang.String str2) {
    }

    public static void vw(java.lang.String str, java.lang.String str2, java.lang.Throwable th) {
    }

    public static void vw(java.lang.String str, java.lang.Object... objArr) {
        if (vw && objArr != null && wg <= 3) {
            vw(objArr);
        }
    }

    public static void wg(java.lang.String str, java.lang.String str2) {
    }

    public static void wg(java.lang.String str, java.lang.String str2, java.lang.Throwable th) {
    }

    public static void wg(java.lang.String str, java.lang.Object... objArr) {
        if (vw && objArr != null && wg <= 5) {
            vw(objArr);
        }
    }

    public static void yl(java.lang.String str, java.lang.String str2) {
    }
}
