package com.ss.android.socialbase.appdownloader.kz;

/* loaded from: classes19.dex */
public class yl {
    private static java.lang.String bt = null;
    private static java.lang.String kz = null;
    private static java.lang.Boolean o = null;
    public static java.lang.String t = null;
    private static java.lang.String v = "";
    public static java.lang.String vw = null;
    public static java.lang.String wg = "";
    private static java.lang.String yl;

    public static boolean bt() {
        return vw("SAMSUNG");
    }

    public static boolean cp() {
        tq();
        return "V11".equals(bt);
    }

    public static boolean d() {
        tq();
        return "V12".equals(bt);
    }

    public static java.lang.String es() {
        if (t == null) {
            vw("");
        }
        return t;
    }

    public static boolean j() {
        if (o == null) {
            o = java.lang.Boolean.valueOf(com.ss.android.socialbase.appdownloader.kz.v.bt().equals("harmony"));
        }
        return o.booleanValue();
    }

    public static boolean k() {
        java.lang.String str = android.os.Build.BRAND;
        if (!android.text.TextUtils.isEmpty(str) && str.toLowerCase().startsWith(com.igexin.assist.util.AssistUtils.BRAND_HON)) {
            return true;
        }
        java.lang.String str2 = android.os.Build.MANUFACTURER;
        return !android.text.TextUtils.isEmpty(str2) && str2.toLowerCase().startsWith(com.igexin.assist.util.AssistUtils.BRAND_HON);
    }

    public static boolean kz() {
        return vw("FLYME");
    }

    public static java.lang.String o() {
        if (yl == null) {
            vw("");
        }
        return yl;
    }

    public static java.lang.String t(java.lang.String str) throws java.lang.Throwable {
        return (java.lang.String) java.lang.Class.forName("android.os.SystemProperties").getMethod(com.ss.android.socialbase.downloader.constants.MonitorConstants.CONNECT_TYPE_GET, java.lang.String.class).invoke(null, str);
    }

    public static boolean t() {
        return vw("MIUI");
    }

    private static void te() {
        if (android.text.TextUtils.isEmpty(vw)) {
            com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.ensureOPPO();
            vw = com.ss.android.socialbase.downloader.constants.DownloadConstants.UPPER_OPPO;
            v = "ro.build.version." + com.ss.android.socialbase.downloader.constants.DownloadConstants.LOWER_OPPO + "rom";
            wg = "com." + com.ss.android.socialbase.downloader.constants.DownloadConstants.LOWER_OPPO + ".market";
        }
    }

    private static void tq() {
        if (bt == null) {
            try {
                bt = v(com.igexin.assist.control.xiaomi.XmSystemUtils.KEY_VERSION_MIUI);
            } catch (java.lang.Exception e) {
                e.printStackTrace();
            }
            java.lang.String str = bt;
            if (str == null) {
                str = "";
            }
            bt = str;
        }
    }

    public static boolean u() {
        tq();
        return "V10".equals(bt);
    }

    public static java.lang.String v(java.lang.String str) {
        if (com.ss.android.socialbase.downloader.setting.DownloadSetting.getGlobalSettings().optBoolean(com.ss.android.socialbase.downloader.setting.DownloadSettingKeys.ENABLE_REFLECT_SYSTEM_PROPERTIES, true)) {
            try {
                return t(str);
            } catch (java.lang.Throwable th) {
                th.printStackTrace();
            }
        }
        return wg(str);
    }

    public static boolean v() {
        return vw("VIVO");
    }

    @androidx.annotation.NonNull
    public static java.lang.String vl() {
        java.lang.String str = android.os.Build.DISPLAY;
        return str == null ? "" : str.trim();
    }

    public static boolean vw() {
        return vw("EMUI") || vw("MAGICUI");
    }

    public static boolean vw(java.lang.String str) {
        te();
        java.lang.String str2 = yl;
        if (str2 != null) {
            return str2.equals(str);
        }
        java.lang.String v2 = v(com.igexin.assist.control.xiaomi.XmSystemUtils.KEY_VERSION_MIUI);
        kz = v2;
        if (android.text.TextUtils.isEmpty(v2)) {
            java.lang.String v3 = v(com.alipay.sdk.m.c.a.a);
            kz = v3;
            if (android.text.TextUtils.isEmpty(v3)) {
                java.lang.String v4 = v(v);
                kz = v4;
                if (android.text.TextUtils.isEmpty(v4)) {
                    java.lang.String v5 = v("ro.vivo.os.version");
                    kz = v5;
                    if (android.text.TextUtils.isEmpty(v5)) {
                        java.lang.String v6 = v("ro.smartisan.version");
                        kz = v6;
                        if (android.text.TextUtils.isEmpty(v6)) {
                            java.lang.String v7 = v("ro.gn.sv.version");
                            kz = v7;
                            if (android.text.TextUtils.isEmpty(v7)) {
                                java.lang.String v8 = v("ro.lenovo.lvp.version");
                                kz = v8;
                                if (!android.text.TextUtils.isEmpty(v8)) {
                                    yl = "LENOVO";
                                    t = "com.lenovo.leos.appstore";
                                } else if (z().toUpperCase().contains("SAMSUNG")) {
                                    yl = "SAMSUNG";
                                    t = "com.sec.android.app.samsungapps";
                                } else if (z().toUpperCase().contains("ZTE")) {
                                    yl = "ZTE";
                                    t = "zte.com.market";
                                } else if (z().toUpperCase().contains("NUBIA")) {
                                    yl = "NUBIA";
                                    t = "cn.nubia.neostore";
                                } else if (vl().toUpperCase().contains("FLYME")) {
                                    yl = "FLYME";
                                    t = "com.meizu.mstore";
                                    kz = vl();
                                } else if (z().toUpperCase().contains("ONEPLUS")) {
                                    yl = "ONEPLUS";
                                    kz = v("ro.rom.version");
                                    if (com.ss.android.socialbase.appdownloader.bt.vw(wg) >= 0) {
                                        t = wg;
                                    } else {
                                        t = "com.heytap.market";
                                    }
                                } else {
                                    yl = z().toUpperCase();
                                    t = "";
                                    kz = "";
                                }
                            } else {
                                yl = "QIONEE";
                                t = "com.gionee.aora.market";
                            }
                        } else {
                            yl = "SMARTISAN";
                            t = "com.smartisanos.appstore";
                        }
                    } else {
                        yl = "VIVO";
                        t = "com.bbk.appstore";
                    }
                } else {
                    yl = vw;
                    if (com.ss.android.socialbase.appdownloader.bt.vw(wg) >= 0) {
                        t = wg;
                    } else {
                        t = "com.heytap.market";
                    }
                }
            } else {
                java.lang.String str3 = k() ? "MAGICUI" : "EMUI";
                yl = str3;
                if (android.text.TextUtils.equals(str3, "MAGICUI")) {
                    t = "com.hihonor.appmarket";
                } else {
                    t = "com.huawei.appmarket";
                }
            }
        } else {
            yl = "MIUI";
            t = "com.xiaomi.market";
            bt = kz;
        }
        return yl.equals(str);
    }

    public static java.lang.String wg(java.lang.String str) {
        java.io.BufferedReader bufferedReader;
        try {
            bufferedReader = new java.io.BufferedReader(new java.io.InputStreamReader(java.lang.Runtime.getRuntime().exec("getprop ".concat(java.lang.String.valueOf(str))).getInputStream()), 1024);
        } catch (java.lang.Throwable unused) {
            bufferedReader = null;
        }
        try {
            java.lang.String readLine = bufferedReader.readLine();
            bufferedReader.close();
            com.ss.android.socialbase.downloader.utils.DownloadUtils.safeClose(bufferedReader);
            return readLine;
        } catch (java.lang.Throwable unused2) {
            com.ss.android.socialbase.downloader.utils.DownloadUtils.safeClose(bufferedReader);
            return null;
        }
    }

    public static boolean wg() {
        return vw("MAGICUI");
    }

    public static java.lang.String x() {
        if (kz == null) {
            vw("");
        }
        return kz;
    }

    public static boolean yl() {
        te();
        return vw(vw);
    }

    @androidx.annotation.NonNull
    public static java.lang.String z() {
        java.lang.String str = android.os.Build.MANUFACTURER;
        return str == null ? "" : str.trim();
    }
}
