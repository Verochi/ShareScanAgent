package com.umeng.analytics.pro;

/* loaded from: classes19.dex */
public class bn {
    private static final java.lang.String a = "OpenId";
    private static boolean b;

    private static java.lang.String a(java.lang.Object obj, java.lang.Object obj2) {
        java.lang.Object[] objArr = new java.lang.Object[2];
        if (obj == null) {
            obj = "";
        }
        objArr[0] = obj;
        if (obj2 == null) {
            obj2 = "";
        }
        objArr[1] = obj2;
        return java.lang.String.format("%s:%s", objArr);
    }

    public static void a(java.lang.String str, java.lang.Object... objArr) {
        if (b) {
            e(str, objArr);
        }
    }

    public static void a(boolean z) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("setDebug:");
        sb.append(z);
        b = z;
    }

    public static void b(java.lang.String str, java.lang.Object... objArr) {
        if (b) {
            e(str, objArr);
        }
    }

    public static void c(java.lang.String str, java.lang.Object... objArr) {
        if (b) {
            e(str, objArr);
        }
    }

    public static void d(java.lang.String str, java.lang.Object... objArr) {
        if (b) {
            e(str, objArr);
        }
    }

    private static java.lang.String e(java.lang.String str, java.lang.Object... objArr) {
        if (str == null && objArr == null) {
            return "";
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        java.lang.Object[] objArr2 = new java.lang.Object[1];
        if (str == null) {
            str = com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER;
        }
        int i = 0;
        objArr2[0] = str;
        sb.append(java.lang.String.format("[%s] ", objArr2));
        if (objArr != null) {
            int length = objArr.length;
            while (true) {
                int i2 = i + 1;
                if (i2 >= objArr.length) {
                    break;
                }
                sb.append(a(objArr[i], objArr[i2]));
                if (i2 < length - 1) {
                    sb.append(",");
                }
                i = i2 + 1;
            }
            if (i == objArr.length - 1) {
                sb.append(objArr[i]);
            }
        }
        return sb.toString();
    }
}
