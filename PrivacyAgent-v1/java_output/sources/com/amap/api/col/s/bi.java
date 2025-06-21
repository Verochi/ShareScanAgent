package com.amap.api.col.s;

/* loaded from: classes12.dex */
public final class bi {
    public static java.lang.String a = "";
    public static java.lang.String b = "";
    public static java.lang.String c = "";
    public static java.lang.String d = "";
    public static java.lang.String e;
    public static boolean f;

    public static java.lang.String a(android.content.Context context) {
        try {
            return h(context);
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            return d;
        }
    }

    public static java.lang.String b(android.content.Context context) {
        try {
        } catch (java.lang.Throwable th) {
            com.amap.api.col.s.cg.a(th, "AI", "gAN");
        }
        if (!"".equals(a)) {
            return a;
        }
        android.content.pm.PackageManager packageManager = context.getPackageManager();
        a = (java.lang.String) packageManager.getApplicationLabel(packageManager.getApplicationInfo(context.getPackageName(), 0));
        return a;
    }

    public static void b(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return;
        }
        d = str;
    }

    public static java.lang.String c(android.content.Context context) {
        java.lang.String str;
        try {
            str = b;
        } catch (java.lang.Throwable th) {
            com.amap.api.col.s.cg.a(th, "AI", "gpck");
        }
        if (str != null && !"".equals(str)) {
            return b;
        }
        java.lang.String packageName = context.getPackageName();
        b = packageName;
        if (!d(packageName)) {
            b = context.getPackageName();
        }
        return b;
    }

    public static boolean c() {
        if (f) {
            return true;
        }
        if (d(e)) {
            f = true;
            return true;
        }
        if (!android.text.TextUtils.isEmpty(e)) {
            f = false;
            e = null;
            return false;
        }
        if (d(b)) {
            f = true;
            return true;
        }
        if (!android.text.TextUtils.isEmpty(b)) {
            f = false;
            b = null;
            return false;
        }
        return true;
    }

    public static java.lang.String d(android.content.Context context) {
        try {
        } catch (java.lang.Throwable th) {
            com.amap.api.col.s.cg.a(th, "AI", "gAV");
        }
        if (!"".equals(c)) {
            return c;
        }
        c = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        java.lang.String str = c;
        return str == null ? "" : str;
    }

    public static boolean d(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return false;
        }
        str.toCharArray();
        for (char c2 : str.toCharArray()) {
            if (('A' > c2 || c2 > 'z') && (('0' > c2 || c2 > ':') && c2 != '.')) {
                try {
                    com.amap.api.col.s.cj.b(com.amap.api.col.s.bu.a(), str, "errorPackage");
                } catch (java.lang.Throwable unused) {
                }
                return false;
            }
        }
        return true;
    }

    public static java.lang.String e(android.content.Context context) {
        try {
            android.content.pm.PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 64);
            byte[] digest = java.security.MessageDigest.getInstance(com.amap.api.col.s.bu.c("IU0hBMQ")).digest(packageInfo.signatures[0].toByteArray());
            java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
            for (byte b2 : digest) {
                java.lang.String upperCase = java.lang.Integer.toHexString(b2 & 255).toUpperCase(java.util.Locale.US);
                if (upperCase.length() == 1) {
                    stringBuffer.append("0");
                }
                stringBuffer.append(upperCase);
                stringBuffer.append(com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR);
            }
            java.lang.String str = packageInfo.packageName;
            if (d(str)) {
                str = packageInfo.packageName;
            }
            if (!android.text.TextUtils.isEmpty(b)) {
                str = c(context);
            }
            stringBuffer.append(str);
            java.lang.String stringBuffer2 = stringBuffer.toString();
            e = stringBuffer2;
            return stringBuffer2;
        } catch (java.lang.Throwable th) {
            com.amap.api.col.s.cg.a(th, "AI", "gsp");
            return e;
        }
    }

    public static java.lang.String f(android.content.Context context) {
        try {
            com.amap.api.col.s.bj.a(context);
        } catch (java.lang.Throwable unused) {
        }
        try {
            return h(context);
        } catch (java.lang.Throwable th) {
            com.amap.api.col.s.cg.a(th, "AI", "gKy");
            return d;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x0056 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static java.lang.String g(android.content.Context context) {
        java.io.FileInputStream fileInputStream;
        java.lang.Throwable th;
        java.io.File file = new java.io.File(com.amap.api.col.s.ch.c(context, "k.store"));
        if (!file.exists()) {
            return "";
        }
        try {
            fileInputStream = new java.io.FileInputStream(file);
            try {
                byte[] bArr = new byte[fileInputStream.available()];
                fileInputStream.read(bArr);
                java.lang.String a2 = com.amap.api.col.s.bu.a(bArr);
                java.lang.String str = a2.length() == 32 ? a2 : "";
                try {
                    fileInputStream.close();
                } catch (java.lang.Throwable th2) {
                    th2.printStackTrace();
                }
                return str;
            } catch (java.lang.Throwable th3) {
                th = th3;
                try {
                    com.amap.api.col.s.cg.a(th, "AI", "gKe");
                    try {
                        if (file.exists()) {
                            file.delete();
                        }
                    } catch (java.lang.Throwable th4) {
                        th4.printStackTrace();
                        return "";
                    }
                    return "";
                } finally {
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (java.lang.Throwable th5) {
                            th5.printStackTrace();
                        }
                    }
                }
            }
        } catch (java.lang.Throwable th6) {
            fileInputStream = null;
            th = th6;
        }
    }

    public static java.lang.String h(android.content.Context context) throws android.content.pm.PackageManager.NameNotFoundException {
        android.os.Bundle bundle;
        java.lang.String str = d;
        if (str == null || str.equals("")) {
            android.content.pm.ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            if (applicationInfo == null || (bundle = applicationInfo.metaData) == null) {
                return d;
            }
            java.lang.String string = bundle.getString("com.amap.api.v2.apikey");
            d = string;
            if (string == null) {
                d = g(context);
            }
        }
        return d;
    }
}
