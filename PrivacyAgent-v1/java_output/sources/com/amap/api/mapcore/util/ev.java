package com.amap.api.mapcore.util;

/* loaded from: classes12.dex */
public final class ev {
    static java.lang.String a = null;
    static boolean b = false;
    private static java.lang.String c = "";
    private static java.lang.String d = "";
    private static java.lang.String e = "";
    private static java.lang.String f = "";

    /* renamed from: com.amap.api.mapcore.util.ev$1, reason: invalid class name */
    public static class AnonymousClass1 extends com.amap.api.mapcore.util.ij {
        final /* synthetic */ android.content.Context a;
        final /* synthetic */ java.lang.String b;

        public AnonymousClass1(android.content.Context context, java.lang.String str) {
            this.a = context;
            this.b = str;
        }

        @Override // com.amap.api.mapcore.util.ij
        public final void runTask() {
            java.io.FileOutputStream fileOutputStream = null;
            try {
                java.io.File file = new java.io.File(com.amap.api.mapcore.util.gb.c(this.a, "k.store"));
                if (!file.getParentFile().exists()) {
                    file.getParentFile().mkdirs();
                }
                java.io.FileOutputStream fileOutputStream2 = new java.io.FileOutputStream(file);
                try {
                    fileOutputStream2.write(com.amap.api.mapcore.util.fi.a(this.b));
                    try {
                        fileOutputStream2.close();
                    } catch (java.lang.Throwable th) {
                        th.printStackTrace();
                    }
                } catch (java.lang.Throwable th2) {
                    th = th2;
                    fileOutputStream = fileOutputStream2;
                    try {
                        com.amap.api.mapcore.util.ga.a(th, "AI", com.umeng.analytics.pro.bs.c);
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (java.lang.Throwable th3) {
                                th3.printStackTrace();
                            }
                        }
                    } catch (java.lang.Throwable th4) {
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (java.lang.Throwable th5) {
                                th5.printStackTrace();
                            }
                        }
                        throw th4;
                    }
                }
            } catch (java.lang.Throwable th6) {
                th = th6;
            }
        }
    }

    public static java.lang.String a(android.content.Context context) {
        try {
            return h(context);
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            return f;
        }
    }

    public static void a(android.content.Context context, java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return;
        }
        f = str;
        if (context != null) {
            com.amap.api.mapcore.util.ii.a().a(new com.amap.api.mapcore.util.ev.AnonymousClass1(context, str));
        }
    }

    public static boolean a() {
        if (b) {
            return true;
        }
        if (a(a)) {
            b = true;
            return true;
        }
        if (!android.text.TextUtils.isEmpty(a)) {
            b = false;
            a = null;
            return false;
        }
        if (a(d)) {
            b = true;
            return true;
        }
        if (!android.text.TextUtils.isEmpty(d)) {
            b = false;
            d = null;
            return false;
        }
        return true;
    }

    private static boolean a(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return false;
        }
        str.toCharArray();
        for (char c2 : str.toCharArray()) {
            if (('A' > c2 || c2 > 'z') && (('0' > c2 || c2 > ':') && c2 != '.')) {
                try {
                    com.amap.api.mapcore.util.gd.b(com.amap.api.mapcore.util.fi.a(), str, "errorPackage");
                } catch (java.lang.Throwable unused) {
                }
                return false;
            }
        }
        return true;
    }

    public static java.lang.String b(android.content.Context context) {
        try {
        } catch (java.lang.Throwable th) {
            com.amap.api.mapcore.util.ga.a(th, "AI", "gAN");
        }
        if (!"".equals(c)) {
            return c;
        }
        android.content.pm.PackageManager packageManager = context.getPackageManager();
        c = (java.lang.String) packageManager.getApplicationLabel(packageManager.getApplicationInfo(context.getPackageName(), 0));
        return c;
    }

    public static java.lang.String c(android.content.Context context) {
        java.lang.String str;
        try {
            str = d;
        } catch (java.lang.Throwable th) {
            com.amap.api.mapcore.util.ga.a(th, "AI", "gpck");
        }
        if (str != null && !"".equals(str)) {
            return d;
        }
        java.lang.String packageName = context.getPackageName();
        d = packageName;
        if (!a(packageName)) {
            d = context.getPackageName();
        }
        return d;
    }

    public static java.lang.String d(android.content.Context context) {
        try {
        } catch (java.lang.Throwable th) {
            com.amap.api.mapcore.util.ga.a(th, "AI", "gAV");
        }
        if (!"".equals(e)) {
            return e;
        }
        e = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        java.lang.String str = e;
        return str == null ? "" : str;
    }

    public static java.lang.String e(android.content.Context context) {
        try {
            android.content.pm.PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 64);
            byte[] digest = java.security.MessageDigest.getInstance(com.amap.api.mapcore.util.fi.c("IU0hBMQ")).digest(packageInfo.signatures[0].toByteArray());
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
            if (a(str)) {
                str = packageInfo.packageName;
            }
            if (!android.text.TextUtils.isEmpty(d)) {
                str = c(context);
            }
            stringBuffer.append(str);
            java.lang.String stringBuffer2 = stringBuffer.toString();
            a = stringBuffer2;
            return stringBuffer2;
        } catch (java.lang.Throwable th) {
            com.amap.api.mapcore.util.ga.a(th, "AI", "gsp");
            return a;
        }
    }

    public static java.lang.String f(android.content.Context context) {
        try {
            com.amap.api.mapcore.util.ew.a(context);
        } catch (java.lang.Throwable unused) {
        }
        try {
            return h(context);
        } catch (java.lang.Throwable th) {
            com.amap.api.mapcore.util.ga.a(th, "AI", "gKy");
            return f;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x0056 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static java.lang.String g(android.content.Context context) {
        java.io.FileInputStream fileInputStream;
        java.lang.Throwable th;
        java.io.File file = new java.io.File(com.amap.api.mapcore.util.gb.c(context, "k.store"));
        if (!file.exists()) {
            return "";
        }
        try {
            fileInputStream = new java.io.FileInputStream(file);
            try {
                byte[] bArr = new byte[fileInputStream.available()];
                fileInputStream.read(bArr);
                java.lang.String a2 = com.amap.api.mapcore.util.fi.a(bArr);
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
                    com.amap.api.mapcore.util.ga.a(th, "AI", "gKe");
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

    private static java.lang.String h(android.content.Context context) throws android.content.pm.PackageManager.NameNotFoundException {
        android.os.Bundle bundle;
        java.lang.String str = f;
        if (str == null || str.equals("")) {
            android.content.pm.ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            if (applicationInfo == null || (bundle = applicationInfo.metaData) == null) {
                return f;
            }
            java.lang.String string = bundle.getString("com.amap.api.v2.apikey");
            f = string;
            if (string == null) {
                f = g(context);
            }
        }
        return f;
    }
}
