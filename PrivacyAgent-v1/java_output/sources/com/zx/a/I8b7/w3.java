package com.zx.a.I8b7;

/* loaded from: classes19.dex */
public class w3 {
    public static android.content.pm.PackageManager a;
    public static com.zx.a.I8b7.a2 b;
    public static java.util.HashMap<java.lang.String, java.lang.String> c = new java.util.HashMap<>();

    @android.annotation.TargetApi(26)
    @com.zx.module.annotation.Java2C.Method2C
    public static native java.lang.String a();

    @com.zx.module.annotation.Java2C.Method2C
    public static native java.lang.String a(android.content.Context context);

    @com.zx.module.annotation.Java2C.Method2C
    public static native java.lang.String a(java.lang.String str);

    public static java.lang.String a(java.util.HashMap<java.lang.String, java.lang.String> hashMap, java.lang.String str) {
        return hashMap.containsKey(str) ? hashMap.get(str) : "";
    }

    public static boolean a(android.content.Context context, java.lang.String str, boolean z) {
        try {
            return c(context).checkPermission(str, context.getPackageName()) == 0;
        } catch (java.lang.Throwable th) {
            try {
                com.zx.a.I8b7.r2.a.a.a.a.a(4, null, null, th);
                return z;
            } catch (java.lang.Throwable th2) {
                th2.printStackTrace();
                return z;
            }
        }
    }

    @android.annotation.SuppressLint({"MissingPermission"})
    public static boolean a(android.content.Context context, boolean z) {
        try {
            android.net.NetworkInfo activeNetworkInfo = ((android.net.ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo != null) {
                return activeNetworkInfo.isAvailable();
            }
            return false;
        } catch (java.lang.Throwable unused) {
            return z;
        }
    }

    @com.zx.module.annotation.Java2C.Method2C
    public static native android.content.pm.PackageInfo b(java.lang.String str);

    public static java.lang.String b() {
        try {
            java.lang.String str = android.os.Build.BRAND;
            return (android.text.TextUtils.isEmpty(str) || str.equals("unknown")) ? android.os.Build.MANUFACTURER : str;
        } catch (java.lang.Throwable th) {
            com.zx.a.I8b7.r2.a(th);
            return "";
        }
    }

    @com.zx.module.annotation.Java2C.Method2C
    public static native java.lang.String b(android.content.Context context);

    public static android.content.pm.PackageManager c(android.content.Context context) {
        if (a == null) {
            a = context.getPackageManager();
        }
        return a;
    }

    public static java.lang.String c() {
        java.lang.String[] strArr = android.os.Build.SUPPORTED_ABIS;
        java.lang.String str = "";
        if (strArr != null && strArr.length > 0) {
            for (java.lang.String str2 : strArr) {
                str = str + str2 + ",";
            }
        }
        return str;
    }

    @com.zx.module.annotation.Java2C.Method2C
    public static native com.zx.a.I8b7.a2 d(android.content.Context context);

    @com.zx.module.annotation.Java2C.Method2C
    public static native java.lang.String d();

    @com.zx.module.annotation.Java2C.Method2C
    public static native long e(android.content.Context context);

    @com.zx.module.annotation.Java2C.Method2C
    public static native java.lang.String e();

    @com.zx.module.annotation.Java2C.Method2C
    public static native java.lang.String f();

    @com.zx.module.annotation.Java2C.Method2C
    private static native boolean f(android.content.Context context);

    @com.zx.module.annotation.Java2C.Method2C
    public static native java.lang.String g();

    @com.zx.module.annotation.Java2C.Method2C
    public static native long h();

    @com.zx.module.annotation.Java2C.Method2C
    public static native boolean i();
}
