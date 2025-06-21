package com.amap.api.col.s;

/* loaded from: classes12.dex */
public final class am {
    public static com.amap.api.col.s.dj a;

    public static java.lang.String a(com.amap.api.services.core.AMapException aMapException) {
        if (aMapException == null) {
            return null;
        }
        if (aMapException.getErrorLevel() != 0) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append(aMapException.getErrorCode());
            return sb.toString();
        }
        int errorCode = aMapException.getErrorCode();
        if (errorCode == 0) {
            return "4";
        }
        int pow = (int) java.lang.Math.pow(10.0d, java.lang.Math.floor(java.lang.Math.log10(errorCode)));
        return java.lang.String.valueOf((errorCode % pow) + (pow * 4));
    }

    public static void a(android.content.Context context, java.lang.String str, long j, boolean z) {
        try {
            java.lang.String b = b(str, j, z);
            if (b != null && b.length() > 0) {
                if (a == null) {
                    a = new com.amap.api.col.s.dj(context, "sea", "8.1.0", "O002");
                }
                a.a(b);
                com.amap.api.col.s.dk.a(a, context);
            }
        } catch (java.lang.Throwable th) {
            com.amap.api.col.s.i.a(th, "StatisticsUtil", "recordResponseAction");
        }
    }

    public static void a(android.content.Context context, java.lang.String str, boolean z) {
        try {
            java.lang.String c = c(str, z);
            if (c != null && c.length() > 0) {
                com.amap.api.col.s.dj djVar = new com.amap.api.col.s.dj(context, "sea", "8.1.0", "O006");
                djVar.a(c);
                com.amap.api.col.s.dk.a(djVar, context);
            }
        } catch (java.lang.Throwable th) {
            com.amap.api.col.s.i.a(th, "StatisticsUtil", "recordResponseAction");
        }
    }

    public static void a(java.lang.String str, java.lang.String str2, com.amap.api.services.core.AMapException aMapException) {
        if (str != null) {
            java.lang.String errorType = aMapException.getErrorType();
            java.lang.String a2 = a(aMapException);
            if (a2 == null || a2.length() <= 0) {
                return;
            }
            com.amap.api.col.s.cj.a(com.amap.api.col.s.h.a(true), str, errorType, str2, a2);
        }
    }

    public static java.lang.String b(java.lang.String str, long j, boolean z) {
        try {
            return "{\"RequestPath\":\"" + str + "\",\"ResponseTime\":" + j + ",\"Success\":" + z + com.alipay.sdk.m.u.i.d;
        } catch (java.lang.Throwable th) {
            com.amap.api.col.s.i.a(th, "StatisticsUtil", "generateNetWorkResponseStatisticsEntity");
            return null;
        }
    }

    public static java.lang.String c(java.lang.String str, boolean z) {
        java.lang.String str2;
        try {
            str2 = "";
            int indexOf = str.indexOf("?");
            int length = str.length();
            if (indexOf > 0) {
                java.lang.String substring = str.substring(0, indexOf);
                int i = indexOf + 1;
                str2 = i < length ? str.substring(i) : "";
                str = substring;
            }
            return "{\"RequestPath\":\"" + str + "\",\"RequestParm\":\"" + str2 + "\",\"IsCacheRequest\":" + z + com.alipay.sdk.m.u.i.d;
        } catch (java.lang.Throwable th) {
            com.amap.api.col.s.i.a(th, "StatisticsUtil", "generateNetWorkResponseStatisticsEntity");
            return null;
        }
    }
}
