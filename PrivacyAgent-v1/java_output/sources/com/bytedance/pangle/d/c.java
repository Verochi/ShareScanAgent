package com.bytedance.pangle.d;

/* loaded from: classes12.dex */
public final class c {
    private static java.io.File a;
    private static java.io.File b;
    private static java.io.File c;

    public static java.lang.String a() {
        android.app.Application appApplication = com.bytedance.pangle.Zeus.getAppApplication();
        if (b == null) {
            java.io.File downloadDir = com.bytedance.pangle.GlobalParam.getInstance().getDownloadDir();
            if (downloadDir == null) {
                downloadDir = new java.io.File(appApplication.getFilesDir(), ".pangle" + com.bytedance.pangle.h.b);
            }
            b = downloadDir;
        }
        return a(b);
    }

    private static java.lang.String a(java.io.File file) {
        if (file == null) {
            return null;
        }
        if (!file.exists()) {
            file.mkdirs();
        }
        return file.getPath();
    }

    public static java.lang.String a(java.lang.String str) {
        return a(str);
    }

    public static java.lang.String a(java.lang.String str, int i) {
        d();
        java.io.File file = a;
        java.lang.String[] strArr = {str, "version-".concat(java.lang.String.valueOf(i))};
        for (int i2 = 0; i2 < 2; i2++) {
            java.lang.String str2 = strArr[i2];
            if (!android.text.TextUtils.isEmpty(str2)) {
                file = new java.io.File(file, str2);
            }
        }
        if (file != null) {
            return file.getPath();
        }
        return null;
    }

    private static java.lang.String a(java.lang.String... strArr) {
        d();
        java.io.File file = a;
        if (strArr.length > 0) {
            for (java.lang.String str : strArr) {
                if (!android.text.TextUtils.isEmpty(str)) {
                    file = new java.io.File(file, str);
                }
            }
        }
        return a(file);
    }

    public static java.lang.String b() {
        android.app.Application appApplication = com.bytedance.pangle.Zeus.getAppApplication();
        if (c == null) {
            c = new java.io.File(appApplication.getFilesDir(), ".pangle" + com.bytedance.pangle.h.a);
        }
        return a(c);
    }

    public static java.lang.String b(java.lang.String str, int i) {
        return new java.io.File(a(str, "version-".concat(java.lang.String.valueOf(i)), "apk"), "base-1.apk").getPath();
    }

    public static java.lang.String c() {
        android.app.Application appApplication = com.bytedance.pangle.Zeus.getAppApplication();
        try {
            if (!"mounted".equals(android.os.Environment.getExternalStorageState())) {
                return null;
            }
            java.io.File externalFilesDir = appApplication.getExternalFilesDir(".pangle" + com.bytedance.pangle.h.b);
            if (externalFilesDir != null) {
                return a(externalFilesDir);
            }
            return null;
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static java.lang.String c(java.lang.String str, int i) {
        return com.bytedance.pangle.util.i.i() ? a(str, "version-".concat(java.lang.String.valueOf(i)), "apk", "oat", com.bytedance.pangle.e.b.a()) : a(str, "version-".concat(java.lang.String.valueOf(i)), "dalvik-cache");
    }

    public static java.lang.String d(java.lang.String str, int i) {
        return a(str, "version-".concat(java.lang.String.valueOf(i)), "lib");
    }

    private static void d() {
        if (a == null) {
            java.io.File file = new java.io.File(com.bytedance.pangle.Zeus.getAppApplication().getFilesDir(), com.bytedance.sdk.openadsdk.mediation.MediationConstant.ADN_PANGLE + com.bytedance.pangle.h.c);
            a = file;
            a(file);
        }
    }

    public static java.lang.String e(java.lang.String str, int i) {
        return new java.io.File(a(str, "version-".concat(java.lang.String.valueOf(i)), "apk", "temp"), "base-1.apk").getPath();
    }

    public static java.lang.String f(java.lang.String str, int i) {
        return new java.io.File(a(str, "version-".concat(java.lang.String.valueOf(i)), "apk")).getPath();
    }

    public static java.lang.String g(java.lang.String str, int i) {
        return new java.io.File(a(str, "version-".concat(java.lang.String.valueOf(i)), "apk", "temp")).getPath();
    }

    public static java.lang.String h(java.lang.String str, int i) {
        return com.bytedance.pangle.util.i.i() ? a(str, "version-".concat(java.lang.String.valueOf(i)), "apk", "temp", "oat", com.bytedance.pangle.e.b.a()) : a(str, "version-".concat(java.lang.String.valueOf(i)), "dalvik-cache");
    }

    public static java.lang.String i(java.lang.String str, int i) {
        return a(str, "version-".concat(java.lang.String.valueOf(i)), "secondary-dexes");
    }
}
