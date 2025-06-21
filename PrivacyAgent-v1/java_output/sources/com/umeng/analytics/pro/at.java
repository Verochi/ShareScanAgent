package com.umeng.analytics.pro;

/* loaded from: classes19.dex */
public class at {
    private static java.lang.String a = "";
    private static java.lang.String b = "";
    private static final java.lang.String c = "hw_sc.build.platform.version";
    private static final java.lang.String d = "ro.build.version.emui";
    private static final java.lang.String e = "ro.build.version.magic";
    private static final java.lang.String f = "ro.miui.ui.version.name";
    private static final java.lang.String g = "ro.build.version.opporom";
    private static final java.lang.String h = "ro.vivo.os.name";
    private static final java.lang.String i = "ro.vivo.os.version";
    private static final java.lang.String j = "ro.build.version.oplusrom";
    private static final java.lang.String k = "ro.rom.version";

    public static java.lang.String a(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(a)) {
            e(str);
        }
        return a;
    }

    private static boolean a() {
        try {
            java.lang.Class<?> cls = java.lang.Class.forName("com.huawei.system.BuildEx");
            return !android.text.TextUtils.isEmpty((java.lang.String) cls.getMethod("getOsBrand", new java.lang.Class[0]).invoke(cls, new java.lang.Object[0]));
        } catch (java.lang.Throwable unused) {
            return false;
        }
    }

    public static java.lang.String b(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(a)) {
            e(str);
        }
        return b;
    }

    public static java.lang.String c(java.lang.String str) {
        return android.text.TextUtils.isEmpty(str) ? "" : str.replaceAll(" ", "").toUpperCase();
    }

    private static java.lang.String d(java.lang.String str) {
        try {
            java.lang.Class<?> cls = java.lang.Class.forName("android.os.SystemProperties");
            return (java.lang.String) cls.getDeclaredMethod(com.ss.android.socialbase.downloader.constants.MonitorConstants.CONNECT_TYPE_GET, java.lang.String.class).invoke(cls, str);
        } catch (java.lang.Throwable unused) {
            return null;
        }
    }

    private static void e(java.lang.String str) {
        char c2;
        try {
            java.lang.String c3 = c(str);
            switch (c3.hashCode()) {
                case -1881642058:
                    if (c3.equals("REALME")) {
                        c2 = 4;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -1706170181:
                    if (c3.equals("XIAOMI")) {
                        c2 = 2;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -602397472:
                    if (c3.equals("ONEPLUS")) {
                        c2 = 7;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 2432928:
                    if (c3.equals(com.ss.android.download.api.constant.BaseConstants.ROM_OPPO_UPPER_CONSTANT)) {
                        c2 = 5;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 2634924:
                    if (c3.equals("VIVO")) {
                        c2 = 6;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 68924490:
                    if (c3.equals("HONOR")) {
                        c2 = 1;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 77852109:
                    if (c3.equals("REDMI")) {
                        c2 = 3;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 2141820391:
                    if (c3.equals("HUAWEI")) {
                        c2 = 0;
                        break;
                    }
                    c2 = 65535;
                    break;
                default:
                    c2 = 65535;
                    break;
            }
            switch (c2) {
                case 0:
                    if (!a()) {
                        a = "EMUI";
                        b = d("ro.build.version.emui");
                        break;
                    } else {
                        b = d("hw_sc.build.platform.version");
                        a = "HarmonyOS";
                        break;
                    }
                case 1:
                    if (!android.text.TextUtils.isEmpty(d(e))) {
                        a = "MagicUI";
                        b = d(e);
                        break;
                    } else {
                        a = "EMUI";
                        b = d("ro.build.version.emui");
                        break;
                    }
                case 2:
                case 3:
                    a = "MIUI";
                    b = d("ro.miui.ui.version.name");
                    break;
                case 4:
                case 5:
                    a = "ColorOS";
                    b = d(g);
                    break;
                case 6:
                    a = "Funtouch";
                    b = d(i);
                    break;
                case 7:
                    a = "HydrogenOS";
                    java.lang.String d2 = d(k);
                    if (android.text.TextUtils.isEmpty(d2)) {
                        a = "ColorOS";
                        d2 = d(j);
                    }
                    b = d2;
                    break;
                default:
                    a = "Android";
                    b = android.os.Build.VERSION.RELEASE;
                    break;
            }
        } catch (java.lang.Throwable unused) {
        }
    }
}
