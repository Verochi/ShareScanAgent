package com.jd.android.sdk.coreinfo;

/* loaded from: classes23.dex */
public final class jad_an {
    public static java.lang.String jad_an = "";
    public static java.lang.String jad_bo = "";
    public static boolean jad_cn = false;
    public static java.lang.String jad_cp = "";
    public static boolean jad_do = false;
    public static java.lang.String jad_dq = "";
    public static boolean jad_ep = false;
    public static java.lang.String jad_er = "";
    public static boolean jad_fq = false;
    public static java.lang.String jad_fs = "";
    public static final java.lang.String[] jad_gr = {"/su", "/su/bin/su", "/sbin/su", "/data/local/xbin/su", "/data/local/bin/su", "/data/local/su", "/system/xbin/su", "/system/bin/su", "/system/sd/xbin/su", "/system/bin/failsafe/su", "/system/bin/cufsdosck", "/system/xbin/cufsdosck", "/system/bin/cufsmgr", "/system/xbin/cufsmgr", "/system/bin/cufaevdd", "/system/xbin/cufaevdd", "/system/bin/conbb", "/system/xbin/conbb"};
    public static java.lang.String jad_hu = "";
    public static java.lang.String[] jad_iv = null;
    public static java.lang.String jad_jt = "";
    public static java.lang.String jad_jw = "";
    public static java.lang.String jad_kx = "";
    public static java.lang.String jad_ly = "";
    public static java.lang.String jad_mz = "";
    public static java.lang.String jad_na = "";
    public static java.lang.String jad_ob = "";
    public static java.lang.String jad_pc = "";
    public static java.lang.String jad_qd = "";
    public static java.lang.String jad_re = "";
    public static java.lang.String jad_sf = "";
    public static long jad_tg;
    public static long jad_uh;
    public static long jad_vi;
    public static boolean jad_wj;
    public static boolean jad_xk;
    public static boolean jad_yl;
    public static boolean jad_zm;

    public static long jad_an(java.lang.String str) {
        android.os.StatFs statFs = new android.os.StatFs(str);
        return statFs.getBlockSizeLong() * statFs.getBlockCountLong();
    }

    public static android.net.wifi.WifiInfo jad_an(android.content.Context context) {
        java.lang.String str;
        if (context == null) {
            str = "getWifiConnectionInfo context is null";
        } else {
            if (com.jd.ad.sdk.jad_lo.jad_fs.jad_an(context, "android.permission.ACCESS_FINE_LOCATION")) {
                try {
                    android.net.wifi.WifiManager wifiManager = (android.net.wifi.WifiManager) context.getApplicationContext().getSystemService(com.efs.sdk.base.core.util.NetworkUtil.NETWORK_TYPE_WIFI);
                    if (wifiManager != null) {
                        return wifiManager.getConnectionInfo();
                    }
                } catch (java.lang.Exception e) {
                    com.jd.android.sdk.coreinfo.util.Logger.e("Baseinfo.DeviceInfo", "", e);
                }
                return null;
            }
            str = "ACCESS_FINE_LOCATION permission is not granted, give up get wifi info.";
        }
        com.jd.android.sdk.coreinfo.util.Logger.e("Baseinfo.DeviceInfo", str);
        return null;
    }

    public static boolean jad_an() {
        java.io.File file = new java.io.File("/proc/tty/drivers");
        if (!file.exists() || !file.canRead()) {
            return false;
        }
        byte[] bArr = new byte[(int) file.length()];
        try {
            java.io.FileInputStream fileInputStream = new java.io.FileInputStream(file);
            fileInputStream.read(bArr);
            fileInputStream.close();
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
        return new java.lang.String(bArr).indexOf("goldfish") != -1;
    }

    public static long jad_bo(java.lang.String str) {
        int indexOf;
        java.lang.String trim;
        int lastIndexOf;
        long j;
        if (str == null || (indexOf = str.indexOf(58)) == -1 || (lastIndexOf = (trim = str.substring(indexOf + 1).trim()).lastIndexOf(32)) == -1) {
            return -1L;
        }
        java.lang.String substring = trim.substring(lastIndexOf + 1);
        try {
            long parseLong = java.lang.Long.parseLong(trim.substring(0, lastIndexOf).trim());
            if ("kb".equalsIgnoreCase(substring)) {
                j = 1024;
            } else if ("mb".equalsIgnoreCase(substring)) {
                j = 1048576;
            } else {
                if (!"gb".equalsIgnoreCase(substring)) {
                    return parseLong;
                }
                j = 1073741824;
            }
            return parseLong * j;
        } catch (java.lang.Exception unused) {
            return -1L;
        }
    }

    public static java.util.List<android.net.wifi.ScanResult> jad_bo(android.content.Context context) {
        java.lang.String str;
        if (context == null) {
            str = "getWifiScanResultList context is null";
        } else {
            if (com.jd.ad.sdk.jad_lo.jad_fs.jad_an(context, "android.permission.ACCESS_FINE_LOCATION")) {
                try {
                    android.net.wifi.WifiManager wifiManager = (android.net.wifi.WifiManager) context.getApplicationContext().getSystemService(com.efs.sdk.base.core.util.NetworkUtil.NETWORK_TYPE_WIFI);
                    if (wifiManager != null) {
                        return wifiManager.getScanResults();
                    }
                } catch (java.lang.Exception e) {
                    com.jd.android.sdk.coreinfo.util.Logger.e("Baseinfo.DeviceInfo", "", e);
                }
                return null;
            }
            str = "ACCESS_FINE_LOCATION permission is not granted, give up scan wifi list.";
        }
        com.jd.android.sdk.coreinfo.util.Logger.e("Baseinfo.DeviceInfo", str);
        return null;
    }

    public static boolean jad_bo() {
        try {
            java.lang.String[] strArr = {"/dev/socket/qemud", "/dev/qemu_pipe"};
            boolean z = false;
            for (int i = 0; i < 2; i++) {
                if (new java.io.File(strArr[i]).exists()) {
                    z = true;
                }
            }
            return z;
        } catch (java.lang.Exception unused) {
            return false;
        }
    }

    public static java.util.ArrayList<java.net.NetworkInterface> jad_cp() {
        com.jd.ad.sdk.jad_lo.jad_dq<java.util.ArrayList<java.net.NetworkInterface>> jad_dqVar = com.jd.android.sdk.coreinfo.CoreInfo.Device.networkInterfacesSupplier;
        return jad_dqVar != null ? jad_dqVar.jad_an() : java.util.Collections.list(java.net.NetworkInterface.getNetworkInterfaces());
    }

    public static java.util.List<java.lang.String> jad_cp(android.content.Context context) {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        java.util.List<android.net.wifi.ScanResult> jad_jt2 = jad_jt(context);
        if (jad_jt2 != null && !jad_jt2.isEmpty()) {
            java.util.Iterator<android.net.wifi.ScanResult> it = jad_jt2.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().BSSID);
            }
        }
        return arrayList;
    }

    public static boolean jad_dq(android.content.Context context) {
        android.os.storage.StorageManager storageManager = (android.os.storage.StorageManager) context.getSystemService("storage");
        try {
            java.lang.reflect.Method method = android.os.storage.StorageManager.class.getMethod("getVolumeList", new java.lang.Class[0]);
            method.setAccessible(true);
            java.lang.Object[] objArr = (java.lang.Object[]) method.invoke(storageManager, new java.lang.Object[0]);
            if (objArr == null) {
                return false;
            }
            for (java.lang.Object obj : objArr) {
                if (((java.lang.Boolean) obj.getClass().getMethod("isRemovable", new java.lang.Class[0]).invoke(obj, new java.lang.Object[0])).booleanValue() && ((java.lang.String) obj.getClass().getMethod("getState", new java.lang.Class[0]).invoke(obj, new java.lang.Object[0])).equals("mounted")) {
                    return true;
                }
            }
            return false;
        } catch (java.lang.Exception e) {
            com.jd.android.sdk.coreinfo.util.Logger.e("Baseinfo.DeviceInfo", "An exception happends when call storageIsRemovable()", e);
            return false;
        }
    }

    @android.annotation.SuppressLint({"MissingPermission"})
    @java.lang.Deprecated
    public static java.lang.String jad_er(android.content.Context context) {
        try {
            if (((android.telephony.TelephonyManager) context.getSystemService(com.aliyun.vod.log.core.AliyunLogCommon.TERMINAL_TYPE)) == null) {
                return "";
            }
            com.jd.ad.sdk.jad_an.jad_bo jad_boVar = com.jd.android.sdk.coreinfo.CoreInfo.sensitiveApi;
            int jad_an2 = jad_boVar != null ? jad_boVar.jad_an(context) : 0;
            if (jad_an2 == 20) {
                return com.efs.sdk.base.core.util.NetworkUtil.NETWORK_CLASS_5G;
            }
            switch (jad_an2) {
            }
            return moji.com.mjwallet.InputSmsCodeFragmentKt.MOBILE;
        } catch (java.lang.Throwable th) {
            com.jd.android.sdk.coreinfo.util.Logger.e("Baseinfo.DeviceInfo", "An exception happends when call getMobileDataType()", th);
            return moji.com.mjwallet.InputSmsCodeFragmentKt.MOBILE;
        }
    }

    public static android.net.wifi.WifiInfo jad_fs(android.content.Context context) {
        com.jd.ad.sdk.jad_lo.jad_dq<android.net.wifi.WifiInfo> jad_dqVar = com.jd.android.sdk.coreinfo.CoreInfo.Device.wifiInfoSupplier;
        return jad_dqVar != null ? jad_dqVar.jad_an() : jad_an(context);
    }

    public static android.util.DisplayMetrics jad_hu(android.content.Context context) {
        if (context == null) {
            com.jd.android.sdk.coreinfo.util.Logger.w("Baseinfo.DeviceInfo", com.anythink.expressad.foundation.g.b.b.a);
            return null;
        }
        try {
            return context.getResources().getDisplayMetrics();
        } catch (java.lang.Exception e) {
            com.jd.android.sdk.coreinfo.util.Logger.e("Baseinfo.DeviceInfo", "An exception happends when call getDisplayMetricsObject()", e);
            return null;
        }
    }

    public static boolean jad_iv(android.content.Context context) {
        if (!jad_do) {
            if (context == null) {
                com.jd.android.sdk.coreinfo.util.Logger.w("Baseinfo.DeviceInfo", com.anythink.expressad.foundation.g.b.b.a);
                return false;
            }
            jad_cn = context.getPackageManager().hasSystemFeature("android.hardware.nfc");
            jad_do = true;
        }
        return jad_cn;
    }

    public static java.util.List<android.net.wifi.ScanResult> jad_jt(android.content.Context context) {
        com.jd.ad.sdk.jad_lo.jad_dq<java.util.List<android.net.wifi.ScanResult>> jad_dqVar = com.jd.android.sdk.coreinfo.CoreInfo.Device.wifiListSupplier;
        return jad_dqVar != null ? jad_dqVar.jad_an() : jad_bo(context);
    }

    @android.annotation.SuppressLint({"MissingPermission"})
    public static java.lang.String jad_jw(android.content.Context context) {
        if (context == null) {
            com.jd.android.sdk.coreinfo.util.Logger.w("Baseinfo.DeviceInfo", com.anythink.expressad.foundation.g.b.b.a);
            return "";
        }
        try {
            android.net.ConnectivityManager connectivityManager = (android.net.ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager == null) {
                return "";
            }
            android.net.NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo != null && activeNetworkInfo.isAvailable()) {
                if (activeNetworkInfo.getType() == 0) {
                    return com.jd.android.sdk.coreinfo.CoreInfo.sensitiveApi != null ? jad_er(context) : moji.com.mjwallet.InputSmsCodeFragmentKt.MOBILE;
                }
                try {
                    android.net.NetworkInfo networkInfo = connectivityManager.getNetworkInfo(1);
                    if (networkInfo != null && networkInfo.getState() != null) {
                        android.net.NetworkInfo.State state = networkInfo.getState();
                        if (state == android.net.NetworkInfo.State.CONNECTED) {
                            return com.efs.sdk.base.core.util.NetworkUtil.NETWORK_TYPE_WIFI;
                        }
                        if (state == android.net.NetworkInfo.State.CONNECTING) {
                            return com.efs.sdk.base.core.util.NetworkUtil.NETWORK_TYPE_WIFI;
                        }
                    }
                } catch (java.lang.Throwable th) {
                    com.jd.android.sdk.coreinfo.util.Logger.e("Baseinfo.DeviceInfo", "An exception happends when call getNetworkType()", th);
                }
                try {
                    android.net.NetworkInfo networkInfo2 = connectivityManager.getNetworkInfo(9);
                    if (networkInfo2 != null && networkInfo2.getState() != null) {
                        android.net.NetworkInfo.State state2 = networkInfo2.getState();
                        if (state2 == android.net.NetworkInfo.State.CONNECTED) {
                            return "enterNet";
                        }
                        if (state2 == android.net.NetworkInfo.State.CONNECTING) {
                            return "enterNet";
                        }
                    }
                } catch (java.lang.Throwable th2) {
                    com.jd.android.sdk.coreinfo.util.Logger.e("Baseinfo.DeviceInfo", "An exception happends when call getNetworkType()", th2);
                }
                return "";
            }
            return "none";
        } catch (java.lang.Throwable th3) {
            com.jd.android.sdk.coreinfo.util.Logger.e("Baseinfo.DeviceInfo", "An exception happends when call getNetworkType()", th3);
            return "";
        }
    }
}
