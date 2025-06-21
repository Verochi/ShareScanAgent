package com.jd.ad.sdk.jad_qd;

/* loaded from: classes23.dex */
public class jad_an {
    public static java.lang.String jad_an() {
        java.lang.String str = "NA";
        if (!jad_an(me.leolin.shortcutbadger.impl.NewHtcHomeBadger.PACKAGENAME, true)) {
            return "NA";
        }
        com.jd.ad.sdk.jad_uh.jad_an jad_anVar = com.jd.ad.sdk.jad_uh.jad_an.jad_bo.jad_an;
        if (jad_anVar.jad_an(me.leolin.shortcutbadger.impl.NewHtcHomeBadger.PACKAGENAME, true)) {
            str = jad_anVar.jad_dq(me.leolin.shortcutbadger.impl.NewHtcHomeBadger.PACKAGENAME);
        } else {
            str = com.jd.android.sdk.coreinfo.CoreInfo.App.getPackageName(com.jd.ad.sdk.jad_il.jad_an.jad_an);
            jad_anVar.jad_bo(me.leolin.shortcutbadger.impl.NewHtcHomeBadger.PACKAGENAME, str);
        }
        return str;
    }

    public static java.lang.String jad_an(android.content.Context context) {
        long j;
        try {
            if (!jad_an("freeDiskSpace", true) || context == null) {
                return "";
            }
            try {
                android.os.StatFs statFs = new android.os.StatFs(android.os.Environment.getDataDirectory().getPath());
                j = statFs.getBlockSizeLong() * statFs.getAvailableBlocksLong();
            } catch (java.lang.Exception e) {
                e.printStackTrace();
                j = 0;
            }
            return java.lang.String.valueOf(j);
        } catch (java.lang.Exception unused) {
            return "";
        }
    }

    public static boolean jad_an(java.lang.String str, boolean z) {
        if (z && com.jd.ad.sdk.jad_ob.jad_dq.jad_an.jad_an.jad_an(11, (java.lang.String) null)) {
            return false;
        }
        return com.jd.ad.sdk.jad_qd.jad_fs.jad_an.jad_an.jad_an(str);
    }

    public static int jad_bo(android.content.Context context) {
        if (context == null) {
            return -1;
        }
        try {
            if (jad_an("remainingBatteryLevel", true)) {
                return com.jd.android.sdk.coreinfo.CoreInfo.Device.getBatteryLevel(com.jd.ad.sdk.jad_il.jad_an.jad_an);
            }
            return -1;
        } catch (java.lang.Exception unused) {
            return -1;
        }
    }

    public static java.lang.String jad_bo() {
        java.lang.String str = "NA";
        if (!jad_an("lock_awake_receiver", true)) {
            return "NA";
        }
        com.jd.ad.sdk.jad_uh.jad_an jad_anVar = com.jd.ad.sdk.jad_uh.jad_an.jad_bo.jad_an;
        if (jad_anVar.jad_an("lock_awake_receiver", true)) {
            return jad_anVar.jad_dq("lock_awake_receiver");
        }
        java.util.List<java.lang.String> jad_an = com.jd.ad.sdk.jad_jm.jad_an.jad_an(com.jd.ad.sdk.jad_il.jad_an.jad_an);
        str = jad_an == null ? "" : android.text.TextUtils.join(", ", jad_an);
        jad_anVar.jad_bo("lock_awake_receiver", str);
        return str;
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x004c, code lost:
    
        if (r4.getType() == 17) goto L29;
     */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:27:0x0053 -> B:21:0x0054). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static java.lang.String jad_cn() {
        android.net.ConnectivityManager connectivityManager;
        android.net.Network activeNetwork;
        java.lang.String str = "NA";
        boolean z = true;
        if (!jad_an("vpnConnect", true)) {
            return "NA";
        }
        com.jd.ad.sdk.jad_uh.jad_an jad_anVar = com.jd.ad.sdk.jad_uh.jad_an.jad_bo.jad_an;
        if (jad_anVar.jad_an("vpnConnect", true)) {
            return jad_anVar.jad_dq("vpnConnect");
        }
        try {
            connectivityManager = (android.net.ConnectivityManager) com.jd.ad.sdk.jad_il.jad_an.jad_an.getSystemService("connectivity");
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
        if (android.os.Build.VERSION.SDK_INT >= 23) {
            if (connectivityManager != null) {
                activeNetwork = connectivityManager.getActiveNetwork();
                android.net.NetworkCapabilities networkCapabilities = connectivityManager.getNetworkCapabilities(activeNetwork);
                if (networkCapabilities != null && networkCapabilities.hasTransport(4)) {
                }
            }
            z = false;
        } else {
            if (connectivityManager != null) {
                android.net.NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                if (activeNetworkInfo != null) {
                }
            }
            z = false;
        }
        str = z ? "1" : "0";
        com.jd.ad.sdk.jad_uh.jad_an.jad_bo.jad_an.jad_bo("vpnConnect", str);
        return str;
    }

    public static int jad_cp(android.content.Context context) {
        if (context == null) {
            return -1;
        }
        try {
            if (jad_an(com.getui.gtc.extension.distribution.gbd.f.h.n, true)) {
                return com.jd.ad.sdk.jad_il.jad_an.jad_fs() ? 1 : 0;
            }
            return -1;
        } catch (java.lang.Exception unused) {
            return -1;
        }
    }

    public static java.lang.String jad_cp() {
        java.lang.String str = "NA";
        if (!jad_an("batteryVoltage", true)) {
            return "NA";
        }
        com.jd.ad.sdk.jad_uh.jad_an jad_anVar = com.jd.ad.sdk.jad_uh.jad_an.jad_bo.jad_an;
        if (jad_anVar.jad_an("batteryVoltage", true)) {
            return jad_anVar.jad_dq("batteryVoltage");
        }
        int i = -1;
        try {
            if (com.jd.ad.sdk.jad_il.jad_an.jad_an != null) {
                i = com.jd.ad.sdk.jad_il.jad_an.jad_an.registerReceiver(null, new android.content.IntentFilter("android.intent.action.BATTERY_CHANGED")).getIntExtra("voltage", -1);
            }
        } catch (java.lang.Throwable unused) {
        }
        str = java.lang.String.valueOf(i);
        com.jd.ad.sdk.jad_uh.jad_an.jad_bo.jad_an.jad_bo("batteryVoltage", str);
        return str;
    }

    public static java.lang.String jad_dq() {
        java.lang.String str = "";
        if (!jad_an("cpuType", true)) {
            return "";
        }
        com.jd.ad.sdk.jad_uh.jad_an jad_anVar = com.jd.ad.sdk.jad_uh.jad_an.jad_bo.jad_an;
        if (jad_anVar.jad_an("cpuType", true)) {
            str = jad_anVar.jad_dq("cpuType");
        } else {
            str = com.jd.android.sdk.coreinfo.CoreInfo.Device.getCpuName();
            jad_anVar.jad_bo("cpuType", str);
        }
        return str;
    }

    public static java.lang.String jad_er() {
        if (!jad_an("cpuFrequency", true)) {
            return "";
        }
        java.lang.String cpuCurFreq = com.jd.android.sdk.coreinfo.CoreInfo.Device.getCpuCurFreq();
        if (!android.text.TextUtils.isEmpty(cpuCurFreq)) {
            return java.lang.Double.parseDouble(new java.text.DecimalFormat(com.baidu.mobads.sdk.internal.cl.d).format(java.lang.Double.parseDouble(cpuCurFreq) / 1000000.0d)) + "GHz";
        }
        return "";
    }

    public static java.lang.String jad_fs() {
        java.lang.String str = "NA";
        if (!jad_an("brand", true)) {
            return "NA";
        }
        com.jd.ad.sdk.jad_uh.jad_an jad_anVar = com.jd.ad.sdk.jad_uh.jad_an.jad_bo.jad_an;
        if (jad_anVar.jad_an("brand", true)) {
            str = jad_anVar.jad_dq("brand");
        } else {
            str = com.jd.android.sdk.coreinfo.CoreInfo.Device.getBrand();
            jad_anVar.jad_bo("brand", str);
        }
        return str;
    }

    public static java.lang.String jad_hu() {
        java.lang.String str = "";
        if (!jad_an("display", true)) {
            return "";
        }
        com.jd.ad.sdk.jad_uh.jad_an jad_anVar = com.jd.ad.sdk.jad_uh.jad_an.jad_bo.jad_an;
        if (jad_anVar.jad_an("display", true)) {
            str = (java.lang.String) jad_anVar.jad_bo("display");
        } else {
            str = com.jd.android.sdk.coreinfo.CoreInfo.System.getOSName();
            jad_anVar.jad_bo("display", str);
        }
        return str;
    }

    public static java.lang.String jad_iv() {
        java.lang.String str = "";
        if (!jad_an("hardware", true)) {
            return "";
        }
        com.jd.ad.sdk.jad_uh.jad_an jad_anVar = com.jd.ad.sdk.jad_uh.jad_an.jad_bo.jad_an;
        if (jad_anVar.jad_an("hardware", true)) {
            str = jad_anVar.jad_dq("hardware");
        } else {
            str = com.jd.android.sdk.coreinfo.CoreInfo.Device.getHardwareName();
            jad_anVar.jad_bo("hardware", str);
        }
        return str;
    }

    public static java.lang.String jad_jt() {
        java.lang.String str = "NA";
        if (!jad_an("devicename", true)) {
            return "NA";
        }
        com.jd.ad.sdk.jad_uh.jad_an jad_anVar = com.jd.ad.sdk.jad_uh.jad_an.jad_bo.jad_an;
        if (jad_anVar.jad_an("devicename", true)) {
            str = jad_anVar.jad_dq("devicename");
        } else {
            str = com.jd.android.sdk.coreinfo.CoreInfo.Device.getDeviceName();
            jad_anVar.jad_bo("devicename", str);
        }
        return str;
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0032, code lost:
    
        if (r2.jad_an() != false) goto L16;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static java.lang.String jad_jw() {
        java.lang.String str = "0";
        java.lang.String str2 = "NA";
        try {
            if (!jad_an("ifp", true)) {
                return "NA";
            }
            com.jd.ad.sdk.jad_uh.jad_an jad_anVar = com.jd.ad.sdk.jad_uh.jad_an.jad_bo.jad_an;
            if (jad_anVar.jad_an("ifp", true)) {
                return jad_anVar.jad_dq("ifp");
            }
            try {
                com.jd.ad.sdk.jad_kn.jad_dq jad_dqVar = new com.jd.ad.sdk.jad_kn.jad_dq(com.jd.ad.sdk.jad_il.jad_an.jad_an);
                if (!jad_dqVar.jad_cp() && !jad_dqVar.jad_bo()) {
                }
                str = "1";
            } catch (java.lang.Exception unused) {
            }
            try {
                com.jd.ad.sdk.jad_uh.jad_an.jad_bo.jad_an.jad_bo("ifp", str);
                return str;
            } catch (java.lang.Exception unused2) {
                str2 = str;
                return str2;
            }
        } catch (java.lang.Exception unused3) {
        }
    }

    public static java.lang.String jad_kx() {
        java.lang.String str = "NA";
        if (!jad_an(com.anythink.expressad.d.a.b.bU, true)) {
            return "NA";
        }
        com.jd.ad.sdk.jad_uh.jad_an jad_anVar = com.jd.ad.sdk.jad_uh.jad_an.jad_bo.jad_an;
        if (jad_anVar.jad_an(com.anythink.expressad.d.a.b.bU, true)) {
            return jad_anVar.jad_dq(com.anythink.expressad.d.a.b.bU);
        }
        android.content.Intent intent = new android.content.Intent("android.intent.action.MAIN");
        intent.addCategory("android.intent.category.HOME");
        android.content.pm.ResolveInfo resolveActivity = com.jd.ad.sdk.jad_il.jad_an.jad_an.getPackageManager().resolveActivity(intent, 0);
        java.lang.String str2 = "";
        if (resolveActivity != null) {
            java.lang.String str3 = resolveActivity.activityInfo.packageName;
            int i = com.jd.ad.sdk.jad_jm.jad_cp.jad_an;
            if (str3 != null) {
                str2 = str3;
            }
        }
        str = str2;
        jad_anVar.jad_bo(com.anythink.expressad.d.a.b.bU, str);
        return str;
    }

    public static java.lang.String jad_ly() {
        java.lang.String str = "NA";
        if (!jad_an(com.getui.gtc.extension.distribution.gbd.f.b.m, false)) {
            return "NA";
        }
        com.jd.ad.sdk.jad_uh.jad_an jad_anVar = com.jd.ad.sdk.jad_uh.jad_an.jad_bo.jad_an;
        if (jad_anVar.jad_an(com.getui.gtc.extension.distribution.gbd.f.b.m, true)) {
            return (java.lang.String) jad_anVar.jad_bo(com.getui.gtc.extension.distribution.gbd.f.b.m);
        }
        java.util.List<java.lang.String> list = com.jd.ad.sdk.jad_qd.jad_cp.jad_an;
        java.lang.String str2 = null;
        try {
            java.util.Enumeration<java.net.NetworkInterface> networkInterfaces = java.net.NetworkInterface.getNetworkInterfaces();
            if (networkInterfaces != null) {
                while (networkInterfaces.hasMoreElements()) {
                    java.net.NetworkInterface nextElement = networkInterfaces.nextElement();
                    if (nextElement.isUp()) {
                        str2 = nextElement.getDisplayName();
                    }
                }
            }
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
        str = str2 == null ? "" : str2;
        com.jd.ad.sdk.jad_uh.jad_an.jad_bo.jad_an.jad_bo(com.getui.gtc.extension.distribution.gbd.f.b.m, str);
        return str;
    }

    public static java.lang.String jad_mz() {
        java.lang.String str = "";
        if (!jad_an("make", true)) {
            return "";
        }
        com.jd.ad.sdk.jad_uh.jad_an jad_anVar = com.jd.ad.sdk.jad_uh.jad_an.jad_bo.jad_an;
        if (jad_anVar.jad_an("make", true)) {
            str = jad_anVar.jad_dq("make");
        } else {
            str = com.jd.android.sdk.coreinfo.CoreInfo.Device.getManufacture();
            jad_anVar.jad_bo("make", str);
        }
        return str;
    }

    public static java.lang.String jad_na() {
        java.lang.String str = "";
        if (!jad_an("model", true)) {
            return "";
        }
        com.jd.ad.sdk.jad_uh.jad_an jad_anVar = com.jd.ad.sdk.jad_uh.jad_an.jad_bo.jad_an;
        if (jad_anVar.jad_an("model", true)) {
            str = jad_anVar.jad_dq("model");
        } else {
            str = com.jd.android.sdk.coreinfo.CoreInfo.Device.getModel();
            jad_anVar.jad_bo("model", str);
        }
        return str;
    }

    public static int jad_ob() {
        int i = -1;
        if (!jad_an("physicalCpu", true)) {
            return -1;
        }
        com.jd.ad.sdk.jad_uh.jad_an jad_anVar = com.jd.ad.sdk.jad_uh.jad_an.jad_bo.jad_an;
        if (jad_anVar.jad_an("physicalCpu", true)) {
            i = jad_anVar.jad_cp("physicalCpu");
        } else {
            i = java.lang.Integer.parseInt(com.jd.android.sdk.coreinfo.CoreInfo.Device.getCPUNum());
            jad_anVar.jad_bo("physicalCpu", java.lang.Integer.valueOf(i));
        }
        return i;
    }

    public static java.lang.String jad_pc() {
        try {
            if (!jad_an("processcount", true)) {
                return "NA";
            }
            com.jd.ad.sdk.jad_uh.jad_an jad_anVar = com.jd.ad.sdk.jad_uh.jad_an.jad_bo.jad_an;
            if (jad_anVar.jad_an("processcount", true)) {
                return jad_anVar.jad_dq("processcount");
            }
            java.util.List<android.app.ActivityManager.RunningAppProcessInfo> runningAppProcesses = com.jd.android.sdk.coreinfo.CoreInfo.App.getRunningAppProcesses(com.jd.ad.sdk.jad_il.jad_an.jad_an);
            java.lang.String valueOf = java.lang.String.valueOf(runningAppProcesses != null ? runningAppProcesses.size() : 0);
            jad_anVar.jad_bo("processcount", valueOf);
            return valueOf;
        } catch (java.lang.Exception unused) {
            return "NA";
        }
    }

    public static java.lang.String jad_qd() {
        try {
            return !jad_an("soaid", false) ? "NA" : com.jd.ad.sdk.jad_jw.jad_an.jad_an;
        } catch (java.lang.Exception unused) {
            return "NA";
        }
    }

    public static java.lang.String jad_re() {
        int i;
        java.lang.String str = "NA";
        if (!jad_an("brightness", true)) {
            return "NA";
        }
        com.jd.ad.sdk.jad_uh.jad_an jad_anVar = com.jd.ad.sdk.jad_uh.jad_an.jad_bo.jad_an;
        if (jad_anVar.jad_an("brightness", true)) {
            return jad_anVar.jad_dq("brightness");
        }
        try {
            i = android.provider.Settings.System.getInt(com.jd.ad.sdk.jad_il.jad_an.jad_an.getContentResolver(), "screen_brightness");
        } catch (java.lang.Exception e) {
            com.jd.android.sdk.coreinfo.util.Logger.e("AntiSDK", e.getMessage());
            i = 0;
        }
        str = java.lang.String.valueOf(i);
        com.jd.ad.sdk.jad_uh.jad_an.jad_bo.jad_an.jad_bo("brightness", str);
        return str;
    }

    public static java.lang.String jad_sf() {
        java.lang.String str = "NA";
        if (!jad_an("isDebug", true)) {
            return "NA";
        }
        com.jd.ad.sdk.jad_uh.jad_an jad_anVar = com.jd.ad.sdk.jad_uh.jad_an.jad_bo.jad_an;
        if (jad_anVar.jad_an("isDebug", true)) {
            str = jad_anVar.jad_dq("isDebug");
        } else {
            str = com.jd.ad.sdk.jad_il.jad_an.jad_bo();
            jad_anVar.jad_bo("isDebug", str);
        }
        return str;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v2, types: [boolean, int] */
    public static int jad_tg() {
        int i = -1;
        if (!jad_an("jailbreak", true)) {
            return -1;
        }
        com.jd.ad.sdk.jad_uh.jad_an jad_anVar = com.jd.ad.sdk.jad_uh.jad_an.jad_bo.jad_an;
        if (jad_anVar.jad_an("jailbreak", true)) {
            return jad_anVar.jad_cp("jailbreak");
        }
        i = com.jd.android.sdk.coreinfo.CoreInfo.Device.isRoot();
        jad_anVar.jad_bo("jailbreak", java.lang.Integer.valueOf((int) i));
        return i;
    }

    public static int jad_uh() {
        int i = -1;
        if (!jad_an("em", true)) {
            return -1;
        }
        com.jd.ad.sdk.jad_uh.jad_an jad_anVar = com.jd.ad.sdk.jad_uh.jad_an.jad_bo.jad_an;
        if (jad_anVar.jad_an("em", true)) {
            return jad_anVar.jad_cp("em");
        }
        i = com.jd.ad.sdk.jad_il.jad_an.jad_cp();
        jad_anVar.jad_bo("em", java.lang.Integer.valueOf(i));
        return i;
    }

    public static java.lang.String jad_vi() {
        java.lang.String str = "NA";
        if (!jad_an("isHooked", true)) {
            return "NA";
        }
        com.jd.ad.sdk.jad_uh.jad_an jad_anVar = com.jd.ad.sdk.jad_uh.jad_an.jad_bo.jad_an;
        if (jad_anVar.jad_an("isHooked", true)) {
            str = jad_anVar.jad_dq("isHooked");
        } else {
            str = com.jd.ad.sdk.jad_il.jad_an.jad_dq();
            jad_anVar.jad_bo("isHooked", str);
        }
        return str;
    }

    public static java.lang.String jad_wj() {
        java.lang.String str = "NA";
        if (!jad_an("isMoreOpen", true)) {
            return "NA";
        }
        com.jd.ad.sdk.jad_uh.jad_an jad_anVar = com.jd.ad.sdk.jad_uh.jad_an.jad_bo.jad_an;
        if (jad_anVar.jad_an("isMoreOpen", true)) {
            str = jad_anVar.jad_dq("isMoreOpen");
        } else {
            str = com.jd.ad.sdk.jad_il.jad_an.jad_er();
            jad_anVar.jad_bo("isMoreOpen", str);
        }
        return str;
    }

    public static java.lang.String jad_xk() {
        java.lang.String str = "NA";
        if (!jad_an("isQEmuDriverExist", true)) {
            return "NA";
        }
        com.jd.ad.sdk.jad_uh.jad_an jad_anVar = com.jd.ad.sdk.jad_uh.jad_an.jad_bo.jad_an;
        if (jad_anVar.jad_an("isQEmuDriverExist", true)) {
            return jad_anVar.jad_dq("isQEmuDriverExist");
        }
        str = com.jd.android.sdk.coreinfo.CoreInfo.Device.isQEmuDriverFile() ? "1" : "0";
        jad_anVar.jad_bo("isQEmuDriverExist", str);
        return str;
    }

    public static java.lang.String jad_yl() {
        java.lang.String str = "NA";
        if (!jad_an("isPipeExist", true)) {
            return "NA";
        }
        com.jd.ad.sdk.jad_uh.jad_an jad_anVar = com.jd.ad.sdk.jad_uh.jad_an.jad_bo.jad_an;
        if (jad_anVar.jad_an("isPipeExist", true)) {
            return jad_anVar.jad_dq("isPipeExist");
        }
        str = com.jd.android.sdk.coreinfo.CoreInfo.Device.checkPipes() ? "1" : "0";
        jad_anVar.jad_bo("isPipeExist", str);
        return str;
    }

    public static int jad_zm() {
        try {
            if (jad_an("sof", true)) {
                return com.jd.ad.sdk.jad_il.jad_an.jad_jt() ^ true ? 1 : 0;
            }
            return -1;
        } catch (java.lang.Exception unused) {
            return -1;
        }
    }
}
