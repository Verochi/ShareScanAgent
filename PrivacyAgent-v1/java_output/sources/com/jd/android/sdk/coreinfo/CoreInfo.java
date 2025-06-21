package com.jd.android.sdk.coreinfo;

/* loaded from: classes23.dex */
public class CoreInfo {
    private static final java.lang.String TAG = "BaseInfo.CoreInfo";
    public static com.jd.ad.sdk.jad_an.jad_bo sensitiveApi;

    public static class App {
        public static java.lang.String getAppName(android.content.Context context) {
            java.lang.String str;
            java.lang.String str2;
            if (android.text.TextUtils.isEmpty(com.jd.ad.sdk.jad_an.jad_cp.jad_an)) {
                str = "";
                if (context == null) {
                    str2 = com.anythink.expressad.foundation.g.b.b.a;
                } else {
                    android.content.pm.PackageInfo jad_an = com.jd.ad.sdk.jad_an.jad_cp.jad_an(context, 16384);
                    if (jad_an == null) {
                        str2 = "packageInfo is null";
                    } else {
                        com.jd.ad.sdk.jad_an.jad_cp.jad_an = context.getPackageManager().getApplicationLabel(jad_an.applicationInfo).toString();
                    }
                }
                com.jd.android.sdk.coreinfo.util.Logger.w("AppInfo", str2);
                com.jd.ad.sdk.jad_an.jad_an.jad_an(str, "getAppName() --> ", com.jd.android.sdk.coreinfo.CoreInfo.TAG);
                return str;
            }
            str = com.jd.ad.sdk.jad_an.jad_cp.jad_an;
            com.jd.ad.sdk.jad_an.jad_an.jad_an(str, "getAppName() --> ", com.jd.android.sdk.coreinfo.CoreInfo.TAG);
            return str;
        }

        public static long getFirstInstallTime(android.content.Context context) {
            java.lang.String str;
            long j = 0;
            if (com.jd.ad.sdk.jad_an.jad_cp.jad_er <= 0) {
                if (context == null) {
                    str = com.anythink.expressad.foundation.g.b.b.a;
                } else {
                    android.content.pm.PackageInfo jad_an = com.jd.ad.sdk.jad_an.jad_cp.jad_an(context, 16384);
                    if (jad_an == null) {
                        str = "packageInfo is null";
                    } else {
                        com.jd.ad.sdk.jad_an.jad_cp.jad_er = jad_an.firstInstallTime;
                    }
                }
                com.jd.android.sdk.coreinfo.util.Logger.w("AppInfo", str);
                com.jd.android.sdk.coreinfo.util.Logger.debugWithStackTrace(com.jd.android.sdk.coreinfo.CoreInfo.TAG, "getFirstInstallTime() --> ".concat(java.lang.String.valueOf(j)));
                return j;
            }
            j = com.jd.ad.sdk.jad_an.jad_cp.jad_er;
            com.jd.android.sdk.coreinfo.util.Logger.debugWithStackTrace(com.jd.android.sdk.coreinfo.CoreInfo.TAG, "getFirstInstallTime() --> ".concat(java.lang.String.valueOf(j)));
            return j;
        }

        public static long getLastUpdateTime(android.content.Context context) {
            java.lang.String str;
            long j = 0;
            if (com.jd.ad.sdk.jad_an.jad_cp.jad_fs <= 0) {
                if (context == null) {
                    str = com.anythink.expressad.foundation.g.b.b.a;
                } else {
                    android.content.pm.PackageInfo jad_an = com.jd.ad.sdk.jad_an.jad_cp.jad_an(context, 16384);
                    if (jad_an == null) {
                        str = "packageInfo is null";
                    } else {
                        com.jd.ad.sdk.jad_an.jad_cp.jad_fs = jad_an.lastUpdateTime;
                    }
                }
                com.jd.android.sdk.coreinfo.util.Logger.w("AppInfo", str);
                com.jd.android.sdk.coreinfo.util.Logger.debugWithStackTrace(com.jd.android.sdk.coreinfo.CoreInfo.TAG, "getLastUpdateTime() --> ".concat(java.lang.String.valueOf(j)));
                return j;
            }
            j = com.jd.ad.sdk.jad_an.jad_cp.jad_fs;
            com.jd.android.sdk.coreinfo.util.Logger.debugWithStackTrace(com.jd.android.sdk.coreinfo.CoreInfo.TAG, "getLastUpdateTime() --> ".concat(java.lang.String.valueOf(j)));
            return j;
        }

        public static java.lang.String getPackageName(android.content.Context context) {
            java.lang.String jad_an = com.jd.ad.sdk.jad_an.jad_cp.jad_an(context);
            com.jd.ad.sdk.jad_an.jad_an.jad_an(jad_an, "getPackageName() --> ", com.jd.android.sdk.coreinfo.CoreInfo.TAG);
            return jad_an;
        }

        public static java.util.List<android.app.ActivityManager.RunningAppProcessInfo> getRunningAppProcesses(android.content.Context context) {
            com.jd.ad.sdk.jad_an.jad_bo jad_boVar = com.jd.android.sdk.coreinfo.CoreInfo.sensitiveApi;
            java.util.List<android.app.ActivityManager.RunningAppProcessInfo> jad_dq = jad_boVar != null ? jad_boVar.jad_dq(context) : new java.util.ArrayList<>();
            com.jd.android.sdk.coreinfo.util.Logger.debugWithStackTrace(com.jd.android.sdk.coreinfo.CoreInfo.TAG, "getRunningAppProcesses() --> ".concat(java.lang.String.valueOf(jad_dq)));
            return jad_dq;
        }

        public static java.util.List<android.app.ActivityManager.RunningServiceInfo> getRunningServices(android.content.Context context) {
            return getRunningServices(context, Integer.MAX_VALUE);
        }

        public static java.util.List<android.app.ActivityManager.RunningServiceInfo> getRunningServices(android.content.Context context, int i) {
            com.jd.ad.sdk.jad_an.jad_bo jad_boVar = com.jd.android.sdk.coreinfo.CoreInfo.sensitiveApi;
            java.util.List<android.app.ActivityManager.RunningServiceInfo> jad_an = jad_boVar != null ? jad_boVar.jad_an(context, i) : new java.util.ArrayList<>();
            com.jd.android.sdk.coreinfo.util.Logger.debugWithStackTrace(com.jd.android.sdk.coreinfo.CoreInfo.TAG, "getRunningServices() --> ".concat(java.lang.String.valueOf(jad_an)));
            return jad_an;
        }

        public static java.util.List<android.app.ActivityManager.RunningTaskInfo> getRunningTasks(android.content.Context context) {
            return getRunningTasks(context, Integer.MAX_VALUE);
        }

        public static java.util.List<android.app.ActivityManager.RunningTaskInfo> getRunningTasks(android.content.Context context, int i) {
            com.jd.ad.sdk.jad_an.jad_bo jad_boVar = com.jd.android.sdk.coreinfo.CoreInfo.sensitiveApi;
            java.util.List<android.app.ActivityManager.RunningTaskInfo> jad_bo = jad_boVar != null ? jad_boVar.jad_bo(context, i) : new java.util.ArrayList<>();
            com.jd.android.sdk.coreinfo.util.Logger.debugWithStackTrace(com.jd.android.sdk.coreinfo.CoreInfo.TAG, "getRunningTasks() --> ".concat(java.lang.String.valueOf(jad_bo)));
            return jad_bo;
        }

        public static long getSignatureHash(android.content.Context context) {
            long jad_bo = com.jd.ad.sdk.jad_an.jad_cp.jad_bo(context);
            com.jd.android.sdk.coreinfo.util.Logger.debugWithStackTrace(com.jd.android.sdk.coreinfo.CoreInfo.TAG, "getSignatureHash() --> ".concat(java.lang.String.valueOf(jad_bo)));
            return jad_bo;
        }

        public static int getStatusBarHeight(android.content.Context context) {
            int dimensionPixelSize;
            if (context == null) {
                com.jd.android.sdk.coreinfo.util.Logger.w("AppInfo", com.anythink.expressad.foundation.g.b.b.a);
                dimensionPixelSize = 0;
            } else {
                android.content.res.Resources resources = context.getResources();
                dimensionPixelSize = resources.getDimensionPixelSize(resources.getIdentifier("status_bar_height", "dimen", com.aliyun.vod.log.core.AliyunLogCommon.OPERATION_SYSTEM));
            }
            com.jd.android.sdk.coreinfo.util.Logger.debugWithStackTrace(com.jd.android.sdk.coreinfo.CoreInfo.TAG, "getStatusBarHeight() --> ".concat(java.lang.String.valueOf(dimensionPixelSize)));
            return dimensionPixelSize;
        }

        public static int getVersionCode(android.content.Context context) {
            int i;
            java.lang.String str;
            if (com.jd.ad.sdk.jad_an.jad_cp.jad_dq <= 0) {
                i = 0;
                if (context == null) {
                    str = com.anythink.expressad.foundation.g.b.b.a;
                } else {
                    android.content.pm.PackageInfo jad_an = com.jd.ad.sdk.jad_an.jad_cp.jad_an(context, 16384);
                    if (jad_an == null) {
                        str = "packageInfo is null";
                    } else {
                        com.jd.ad.sdk.jad_an.jad_cp.jad_dq = jad_an.versionCode;
                    }
                }
                com.jd.android.sdk.coreinfo.util.Logger.w("AppInfo", str);
                com.jd.android.sdk.coreinfo.util.Logger.debugWithStackTrace(com.jd.android.sdk.coreinfo.CoreInfo.TAG, "getVersionCode() --> ".concat(java.lang.String.valueOf(i)));
                return i;
            }
            i = com.jd.ad.sdk.jad_an.jad_cp.jad_dq;
            com.jd.android.sdk.coreinfo.util.Logger.debugWithStackTrace(com.jd.android.sdk.coreinfo.CoreInfo.TAG, "getVersionCode() --> ".concat(java.lang.String.valueOf(i)));
            return i;
        }

        public static java.lang.String getVersionName(android.content.Context context) {
            java.lang.String str;
            java.lang.String str2;
            if (android.text.TextUtils.isEmpty(com.jd.ad.sdk.jad_an.jad_cp.jad_cp)) {
                str = "";
                if (context == null) {
                    str2 = com.anythink.expressad.foundation.g.b.b.a;
                } else {
                    android.content.pm.PackageInfo jad_an = com.jd.ad.sdk.jad_an.jad_cp.jad_an(context, 16384);
                    if (jad_an == null) {
                        str2 = "packageInfo is null";
                    } else {
                        com.jd.ad.sdk.jad_an.jad_cp.jad_cp = jad_an.versionName;
                    }
                }
                com.jd.android.sdk.coreinfo.util.Logger.w("AppInfo", str2);
                com.jd.ad.sdk.jad_an.jad_an.jad_an(str, "getVersionName() --> ", com.jd.android.sdk.coreinfo.CoreInfo.TAG);
                return str;
            }
            str = com.jd.ad.sdk.jad_an.jad_cp.jad_cp;
            com.jd.ad.sdk.jad_an.jad_an.jad_an(str, "getVersionName() --> ", com.jd.android.sdk.coreinfo.CoreInfo.TAG);
            return str;
        }

        @android.annotation.TargetApi(17)
        public static boolean isNavigationBarVisible(android.app.Activity activity) {
            boolean z = false;
            if (activity == null) {
                com.jd.android.sdk.coreinfo.util.Logger.w("AppInfo", "activity is null");
            } else {
                android.view.Display defaultDisplay = activity.getWindowManager().getDefaultDisplay();
                android.util.DisplayMetrics displayMetrics = new android.util.DisplayMetrics();
                defaultDisplay.getRealMetrics(displayMetrics);
                int i = displayMetrics.heightPixels;
                int i2 = displayMetrics.widthPixels;
                android.util.DisplayMetrics displayMetrics2 = new android.util.DisplayMetrics();
                defaultDisplay.getMetrics(displayMetrics2);
                int i3 = displayMetrics2.heightPixels;
                int i4 = displayMetrics2.widthPixels;
                if (i - i3 > 0 || i2 - i4 > 0) {
                    z = true;
                }
            }
            com.jd.android.sdk.coreinfo.util.Logger.debugWithStackTrace(com.jd.android.sdk.coreinfo.CoreInfo.TAG, "isNavigationBarVisible() --> ".concat(java.lang.String.valueOf(z)));
            return z;
        }
    }

    public static class Device {
        public static com.jd.ad.sdk.jad_lo.jad_dq<java.util.ArrayList<java.net.NetworkInterface>> networkInterfacesSupplier;
        public static com.jd.ad.sdk.jad_lo.jad_dq<android.net.wifi.WifiInfo> wifiInfoSupplier;
        public static com.jd.ad.sdk.jad_lo.jad_dq<java.util.List<android.net.wifi.ScanResult>> wifiListSupplier;

        public static boolean checkPipes() {
            boolean jad_bo = com.jd.android.sdk.coreinfo.jad_an.jad_bo();
            com.jd.android.sdk.coreinfo.util.Logger.debugWithStackTrace(com.jd.android.sdk.coreinfo.CoreInfo.TAG, "checkPipes() --> ".concat(java.lang.String.valueOf(jad_bo)));
            return jad_bo;
        }

        public static java.lang.String getAndroidId(android.content.Context context) {
            java.lang.String str;
            if (android.text.TextUtils.isEmpty(com.jd.android.sdk.coreinfo.jad_an.jad_an)) {
                if (context == null) {
                    com.jd.android.sdk.coreinfo.util.Logger.w("Baseinfo.DeviceInfo", com.anythink.expressad.foundation.g.b.b.a);
                    str = "";
                    com.jd.ad.sdk.jad_an.jad_an.jad_an(str, "getAndroidId() --> ", com.jd.android.sdk.coreinfo.CoreInfo.TAG);
                    return str;
                }
                com.jd.android.sdk.coreinfo.jad_an.jad_an = com.jd.ad.sdk.jad_lo.jad_bo.jad_an(android.provider.Settings.Secure.getString(context.getContentResolver(), "android_id"));
            }
            str = com.jd.android.sdk.coreinfo.jad_an.jad_an;
            com.jd.ad.sdk.jad_an.jad_an.jad_an(str, "getAndroidId() --> ", com.jd.android.sdk.coreinfo.CoreInfo.TAG);
            return str;
        }

        public static java.lang.String getAndroidIdForDeviceFinger(android.content.Context context) {
            java.lang.String str;
            if (android.text.TextUtils.isEmpty(com.jd.android.sdk.coreinfo.jad_an.jad_bo)) {
                java.lang.String str2 = "";
                if (context != null) {
                    try {
                        if (android.os.Build.VERSION.SDK_INT < 28) {
                            str = com.jd.ad.sdk.jad_dq.jad_an.jad_an(context, "android_id");
                            try {
                                if (android.text.TextUtils.isEmpty(str)) {
                                    str = com.jd.ad.sdk.jad_dq.jad_an.jad_bo(context, "android_id");
                                }
                            } catch (java.lang.Throwable unused) {
                            }
                        } else {
                            str = "";
                        }
                        str.equals("");
                        if (str.equals("")) {
                            str2 = android.provider.Settings.Secure.getString(context.getContentResolver(), "android_id");
                        }
                        str2 = str;
                    } catch (java.lang.Throwable unused2) {
                    }
                }
                com.jd.android.sdk.coreinfo.jad_an.jad_bo = com.jd.ad.sdk.jad_lo.jad_bo.jad_an(str2);
            }
            java.lang.String str3 = com.jd.android.sdk.coreinfo.jad_an.jad_bo;
            com.jd.ad.sdk.jad_an.jad_an.jad_an(str3, "getAndroidIdForDeviceFinger() --> ", com.jd.android.sdk.coreinfo.CoreInfo.TAG);
            return str3;
        }

        public static long getAvailableInternalMemorySize(android.content.Context context) {
            long j;
            try {
                android.os.StatFs statFs = new android.os.StatFs(android.os.Environment.getDataDirectory().getPath());
                j = statFs.getAvailableBlocks() * statFs.getBlockSize();
            } catch (java.lang.Exception unused) {
                j = 0;
            }
            com.jd.android.sdk.coreinfo.util.Logger.debugWithStackTrace(com.jd.android.sdk.coreinfo.CoreInfo.TAG, "getAvailableInternalMemorySize() --> ".concat(java.lang.String.valueOf(j)));
            return j;
        }

        public static int getBatteryLevel(android.content.Context context) {
            int i = -1;
            if (context != null) {
                try {
                    i = context.registerReceiver(null, new android.content.IntentFilter("android.intent.action.BATTERY_CHANGED")).getIntExtra(com.aliyun.svideo.downloader.FileDownloaderModel.LEVEL, -1);
                } catch (java.lang.Throwable unused) {
                }
            }
            com.jd.android.sdk.coreinfo.util.Logger.debugWithStackTrace(com.jd.android.sdk.coreinfo.CoreInfo.TAG, "getBatteryLevel() --> ".concat(java.lang.String.valueOf(i)));
            return i;
        }

        public static int getBatteryPlugged(android.content.Context context) {
            int i = -1;
            if (context != null) {
                try {
                    i = context.registerReceiver(null, new android.content.IntentFilter("android.intent.action.BATTERY_CHANGED")).getIntExtra("plugged", -1);
                } catch (java.lang.Throwable unused) {
                }
            }
            com.jd.android.sdk.coreinfo.util.Logger.debugWithStackTrace(com.jd.android.sdk.coreinfo.CoreInfo.TAG, "getBatteryPlugged() --> ".concat(java.lang.String.valueOf(i)));
            return i;
        }

        public static int getBatteryScale(android.content.Context context) {
            int i = -1;
            if (context != null) {
                try {
                    i = context.registerReceiver(null, new android.content.IntentFilter("android.intent.action.BATTERY_CHANGED")).getIntExtra("scale", -1);
                } catch (java.lang.Throwable unused) {
                }
            }
            com.jd.android.sdk.coreinfo.util.Logger.debugWithStackTrace(com.jd.android.sdk.coreinfo.CoreInfo.TAG, "getBatteryScale() --> ".concat(java.lang.String.valueOf(i)));
            return i;
        }

        public static int getBatteryStatus(android.content.Context context) {
            int i = -1;
            if (context != null) {
                try {
                    i = context.registerReceiver(null, new android.content.IntentFilter("android.intent.action.BATTERY_CHANGED")).getIntExtra("status", -1);
                } catch (java.lang.Throwable unused) {
                }
            }
            com.jd.android.sdk.coreinfo.util.Logger.debugWithStackTrace(com.jd.android.sdk.coreinfo.CoreInfo.TAG, "getBatteryStatus() --> ".concat(java.lang.String.valueOf(i)));
            return i;
        }

        public static java.lang.String getBluetoothMac(android.content.Context context) {
            java.lang.String str = "";
            try {
                android.bluetooth.BluetoothAdapter defaultAdapter = android.bluetooth.BluetoothAdapter.getDefaultAdapter();
                java.lang.String address = defaultAdapter != null ? defaultAdapter.getAddress() : "";
                if (android.text.TextUtils.isEmpty(address) || android.text.TextUtils.equals("02:00:00:00:00:00", address)) {
                    address = android.provider.Settings.Secure.getString(context.getContentResolver(), "bluetooth_address");
                }
                if (!android.text.TextUtils.isEmpty(address)) {
                    str = address;
                }
            } catch (java.lang.Exception unused) {
            }
            com.jd.ad.sdk.jad_an.jad_an.jad_an(str, "getBluetoothMac() --> ", com.jd.android.sdk.coreinfo.CoreInfo.TAG);
            return str;
        }

        public static java.lang.String getBluetoothName(android.content.Context context) {
            java.lang.String str = "";
            try {
                android.bluetooth.BluetoothAdapter defaultAdapter = android.bluetooth.BluetoothAdapter.getDefaultAdapter();
                java.lang.String name = defaultAdapter != null ? defaultAdapter.getName() : "";
                if (!android.text.TextUtils.isEmpty(name)) {
                    str = name;
                }
            } catch (java.lang.Exception unused) {
            }
            com.jd.ad.sdk.jad_an.jad_an.jad_an(str, "getBluetoothName() --> ", com.jd.android.sdk.coreinfo.CoreInfo.TAG);
            return str;
        }

        public static java.lang.String getBoard() {
            if (android.text.TextUtils.isEmpty(com.jd.android.sdk.coreinfo.jad_an.jad_jt)) {
                com.jd.android.sdk.coreinfo.jad_an.jad_jt = com.jd.ad.sdk.jad_lo.jad_bo.jad_an(android.os.Build.BOARD);
            }
            java.lang.String str = com.jd.android.sdk.coreinfo.jad_an.jad_jt;
            com.jd.ad.sdk.jad_an.jad_an.jad_an(str, "getBoard() --> ", com.jd.android.sdk.coreinfo.CoreInfo.TAG);
            return str;
        }

        public static java.lang.String getBoardPlatform() {
            if (android.text.TextUtils.isEmpty(com.jd.android.sdk.coreinfo.jad_an.jad_hu)) {
                com.jd.android.sdk.coreinfo.jad_an.jad_hu = com.jd.ad.sdk.jad_lo.jad_bo.jad_an(com.jd.ad.sdk.jad_lo.jad_hu.jad_an("ro.board.platform", ""));
            }
            java.lang.String str = com.jd.android.sdk.coreinfo.jad_an.jad_hu;
            com.jd.ad.sdk.jad_an.jad_an.jad_an(str, "getBoardPlatform() --> ", com.jd.android.sdk.coreinfo.CoreInfo.TAG);
            return str;
        }

        public static java.lang.String getBootloaderVersion() {
            if (android.text.TextUtils.isEmpty(com.jd.android.sdk.coreinfo.jad_an.jad_ly)) {
                com.jd.android.sdk.coreinfo.jad_an.jad_ly = com.jd.ad.sdk.jad_lo.jad_bo.jad_an(android.os.Build.BOOTLOADER);
            }
            java.lang.String str = com.jd.android.sdk.coreinfo.jad_an.jad_ly;
            com.jd.ad.sdk.jad_an.jad_an.jad_an(str, "getBootloaderVersion() --> ", com.jd.android.sdk.coreinfo.CoreInfo.TAG);
            return str;
        }

        public static java.lang.String getBrand() {
            if (android.text.TextUtils.isEmpty(com.jd.android.sdk.coreinfo.jad_an.jad_er)) {
                com.jd.android.sdk.coreinfo.jad_an.jad_er = com.jd.ad.sdk.jad_lo.jad_bo.jad_an(android.os.Build.BRAND);
            }
            java.lang.String str = com.jd.android.sdk.coreinfo.jad_an.jad_er;
            com.jd.ad.sdk.jad_an.jad_an.jad_an(str, "getBrand() --> ", com.jd.android.sdk.coreinfo.CoreInfo.TAG);
            return str;
        }

        public static java.lang.String getCPUMaxFreq() {
            java.lang.String str;
            if (android.text.TextUtils.isEmpty(com.jd.android.sdk.coreinfo.jad_an.jad_re)) {
                java.lang.String jad_an = com.jd.ad.sdk.jad_lo.jad_cp.jad_an("/sys/devices/system/cpu/cpu0/cpufreq/cpuinfo_max_freq", false);
                if (jad_an.length() == 0) {
                    str = "";
                    com.jd.ad.sdk.jad_an.jad_an.jad_an(str, "getCPUMaxFreq() --> ", com.jd.android.sdk.coreinfo.CoreInfo.TAG);
                    return str;
                }
                com.jd.android.sdk.coreinfo.jad_an.jad_re = com.jd.ad.sdk.jad_lo.jad_bo.jad_an(jad_an);
            }
            str = com.jd.android.sdk.coreinfo.jad_an.jad_re;
            com.jd.ad.sdk.jad_an.jad_an.jad_an(str, "getCPUMaxFreq() --> ", com.jd.android.sdk.coreinfo.CoreInfo.TAG);
            return str;
        }

        public static java.lang.String getCPUNum() {
            java.lang.String str;
            if (android.text.TextUtils.isEmpty(com.jd.android.sdk.coreinfo.jad_an.jad_pc)) {
                try {
                    com.jd.android.sdk.coreinfo.jad_an.jad_pc = java.lang.String.valueOf(new java.io.File("/sys/devices/system/cpu/").listFiles(new com.jd.ad.sdk.jad_cp.jad_an()).length);
                } catch (java.lang.Exception e) {
                    com.jd.android.sdk.coreinfo.util.Logger.e("Baseinfo.DeviceInfo", "An exception happens when call getCPUNum()", e);
                    str = "1";
                }
            }
            str = com.jd.android.sdk.coreinfo.jad_an.jad_pc;
            com.jd.ad.sdk.jad_an.jad_an.jad_an(str, "getCPUNum() --> ", com.jd.android.sdk.coreinfo.CoreInfo.TAG);
            return str;
        }

        public static java.lang.String getCPUSerialNo() {
            java.io.LineNumberReader lineNumberReader;
            java.lang.Throwable th;
            java.io.InputStreamReader inputStreamReader;
            java.lang.String str;
            if (android.text.TextUtils.isEmpty(com.jd.android.sdk.coreinfo.jad_an.jad_ob)) {
                try {
                    inputStreamReader = new java.io.InputStreamReader(java.lang.Runtime.getRuntime().exec("cat /proc/cpuinfo | grep Serial").getInputStream());
                    try {
                        lineNumberReader = new java.io.LineNumberReader(inputStreamReader);
                        for (int i = 0; i < 100; i = i + 1 + 1) {
                            try {
                                java.lang.String readLine = lineNumberReader.readLine();
                                if (readLine != null && readLine.indexOf("Serial") >= 0) {
                                    str = readLine.substring(readLine.indexOf(com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR) + 1).trim();
                                    break;
                                }
                            } catch (java.lang.Throwable th2) {
                                try {
                                    th2.printStackTrace();
                                } catch (java.lang.Throwable th3) {
                                    th = th3;
                                    try {
                                        th.printStackTrace();
                                        str = "";
                                        com.jd.android.sdk.coreinfo.jad_an.jad_ob = com.jd.ad.sdk.jad_lo.jad_bo.jad_an(str);
                                        java.lang.String str2 = com.jd.android.sdk.coreinfo.jad_an.jad_ob;
                                        com.jd.ad.sdk.jad_an.jad_an.jad_an(str2, "getCPUSerialNo() --> ", com.jd.android.sdk.coreinfo.CoreInfo.TAG);
                                        return str2;
                                    } finally {
                                    }
                                }
                            }
                        }
                    } catch (java.lang.Throwable th4) {
                        lineNumberReader = null;
                        th = th4;
                    }
                } catch (java.lang.Throwable th5) {
                    lineNumberReader = null;
                    th = th5;
                    inputStreamReader = null;
                }
                str = "";
                com.jd.android.sdk.coreinfo.jad_an.jad_ob = com.jd.ad.sdk.jad_lo.jad_bo.jad_an(str);
            }
            java.lang.String str22 = com.jd.android.sdk.coreinfo.jad_an.jad_ob;
            com.jd.ad.sdk.jad_an.jad_an.jad_an(str22, "getCPUSerialNo() --> ", com.jd.android.sdk.coreinfo.CoreInfo.TAG);
            return str22;
        }

        public static int getCellId(android.content.Context context) {
            com.jd.android.sdk.coreinfo.util.Logger.debugWithStackTrace(com.jd.android.sdk.coreinfo.CoreInfo.TAG, "getCellId() --> -1");
            return -1;
        }

        public static android.telephony.CellLocation getCellLocationForDeviceFinger(android.content.Context context) {
            com.jd.android.sdk.coreinfo.util.Logger.debugWithStackTrace(com.jd.android.sdk.coreinfo.CoreInfo.TAG, "getCellLocationForDeviceFinger() --> ".concat(com.igexin.push.core.b.m));
            return null;
        }

        /* JADX WARN: Code restructure failed: missing block: B:25:0x0047, code lost:
        
            if (r2 == null) goto L33;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public static java.lang.String getCpuCurFreq() {
            java.io.BufferedReader bufferedReader;
            java.lang.String str;
            java.io.FileReader fileReader;
            java.io.FileReader fileReader2 = null;
            try {
                fileReader = new java.io.FileReader("/sys/devices/system/cpu/cpu0/cpufreq/scaling_cur_freq");
                try {
                    bufferedReader = new java.io.BufferedReader(fileReader);
                } catch (java.lang.Exception unused) {
                    bufferedReader = null;
                } catch (java.lang.Throwable th) {
                    bufferedReader = null;
                    fileReader2 = fileReader;
                    th = th;
                }
            } catch (java.lang.Exception unused2) {
                bufferedReader = null;
            } catch (java.lang.Throwable th2) {
                th = th2;
                bufferedReader = null;
            }
            try {
                str = bufferedReader.readLine().trim();
                try {
                    fileReader.close();
                } catch (java.io.IOException unused3) {
                }
            } catch (java.lang.Exception unused4) {
                fileReader2 = fileReader;
                if (fileReader2 != null) {
                    try {
                        fileReader2.close();
                    } catch (java.io.IOException unused5) {
                    }
                }
                str = "";
            } catch (java.lang.Throwable th3) {
                th = th3;
                fileReader2 = fileReader;
                if (fileReader2 != null) {
                    try {
                        fileReader2.close();
                    } catch (java.io.IOException unused6) {
                    }
                }
                if (bufferedReader == null) {
                    throw th;
                }
                try {
                    bufferedReader.close();
                    throw th;
                } catch (java.io.IOException unused7) {
                    throw th;
                }
            }
            try {
                bufferedReader.close();
            } catch (java.io.IOException unused8) {
            }
            com.jd.ad.sdk.jad_an.jad_an.jad_an(str, "getCpuCurFreq() --> ", com.jd.android.sdk.coreinfo.CoreInfo.TAG);
            return str;
        }

        /* JADX WARN: Code restructure failed: missing block: B:22:0x0053, code lost:
        
            if (r2 == null) goto L34;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public static java.lang.String getCpuMinFreq() {
            java.io.BufferedReader bufferedReader;
            if (android.text.TextUtils.isEmpty(com.jd.android.sdk.coreinfo.jad_an.jad_sf)) {
                java.io.FileReader fileReader = null;
                try {
                    java.io.FileReader fileReader2 = new java.io.FileReader("/sys/devices/system/cpu/cpu0/cpufreq/cpuinfo_min_freq");
                    try {
                        bufferedReader = new java.io.BufferedReader(fileReader2);
                        try {
                            com.jd.android.sdk.coreinfo.jad_an.jad_sf = com.jd.ad.sdk.jad_lo.jad_bo.jad_an(bufferedReader.readLine().trim());
                            try {
                                fileReader2.close();
                            } catch (java.io.IOException unused) {
                            }
                        } catch (java.lang.Exception unused2) {
                            fileReader = fileReader2;
                            if (fileReader != null) {
                                try {
                                    fileReader.close();
                                } catch (java.io.IOException unused3) {
                                }
                            }
                        } catch (java.lang.Throwable th) {
                            th = th;
                            fileReader = fileReader2;
                            if (fileReader != null) {
                                try {
                                    fileReader.close();
                                } catch (java.io.IOException unused4) {
                                }
                            }
                            if (bufferedReader == null) {
                                throw th;
                            }
                            try {
                                bufferedReader.close();
                                throw th;
                            } catch (java.io.IOException unused5) {
                                throw th;
                            }
                        }
                    } catch (java.lang.Exception unused6) {
                        bufferedReader = null;
                    } catch (java.lang.Throwable th2) {
                        bufferedReader = null;
                        fileReader = fileReader2;
                        th = th2;
                    }
                } catch (java.lang.Exception unused7) {
                    bufferedReader = null;
                } catch (java.lang.Throwable th3) {
                    th = th3;
                    bufferedReader = null;
                }
                try {
                    bufferedReader.close();
                } catch (java.io.IOException unused8) {
                }
            }
            java.lang.String str = com.jd.android.sdk.coreinfo.jad_an.jad_sf;
            com.jd.ad.sdk.jad_an.jad_an.jad_an(str, "getCpuMinFreq() --> ", com.jd.android.sdk.coreinfo.CoreInfo.TAG);
            return str;
        }

        /* JADX WARN: Code restructure failed: missing block: B:27:0x0046, code lost:
        
            if (r2 == null) goto L34;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public static java.lang.String getCpuName() {
            java.io.BufferedReader bufferedReader;
            java.io.FileReader fileReader;
            if (android.text.TextUtils.isEmpty(com.jd.android.sdk.coreinfo.jad_an.jad_qd)) {
                java.io.FileReader fileReader2 = null;
                try {
                    fileReader = new java.io.FileReader("/proc/cpuinfo");
                    try {
                        bufferedReader = new java.io.BufferedReader(fileReader);
                    } catch (java.lang.Throwable th) {
                        bufferedReader = null;
                        fileReader2 = fileReader;
                        th = th;
                    }
                } catch (java.lang.Throwable th2) {
                    th = th2;
                    bufferedReader = null;
                }
                try {
                    java.lang.String[] split = bufferedReader.readLine().split(":\\s+", 2);
                    if (split.length >= 2) {
                        com.jd.android.sdk.coreinfo.jad_an.jad_qd = split[1];
                    }
                    try {
                        fileReader.close();
                    } catch (java.io.IOException unused) {
                    }
                } catch (java.lang.Throwable th3) {
                    th = th3;
                    fileReader2 = fileReader;
                    try {
                        th.printStackTrace();
                        if (fileReader2 != null) {
                            try {
                                fileReader2.close();
                            } catch (java.io.IOException unused2) {
                            }
                        }
                    } finally {
                    }
                }
                try {
                    bufferedReader.close();
                } catch (java.io.IOException unused3) {
                }
            }
            java.lang.String str = com.jd.android.sdk.coreinfo.jad_an.jad_qd;
            com.jd.ad.sdk.jad_an.jad_an.jad_an(str, "getCpuName() --> ", com.jd.android.sdk.coreinfo.CoreInfo.TAG);
            return str;
        }

        public static float getDensity(android.content.Context context) {
            android.util.DisplayMetrics jad_hu = com.jd.android.sdk.coreinfo.jad_an.jad_hu(context);
            float f = jad_hu == null ? 1.0f : jad_hu.density;
            com.jd.android.sdk.coreinfo.util.Logger.debugWithStackTrace(com.jd.android.sdk.coreinfo.CoreInfo.TAG, "getDensity() --> ".concat(java.lang.String.valueOf(f)));
            return f;
        }

        public static java.lang.String getDensityDpi(android.content.Context context) {
            java.lang.String valueOf = java.lang.String.valueOf(getDensityDpiInt(context));
            com.jd.android.sdk.coreinfo.util.Logger.d(com.jd.android.sdk.coreinfo.CoreInfo.TAG, "getDensityDpi() --> ".concat(java.lang.String.valueOf(valueOf)));
            return valueOf;
        }

        public static int getDensityDpiInt(android.content.Context context) {
            android.util.DisplayMetrics jad_hu = com.jd.android.sdk.coreinfo.jad_an.jad_hu(context);
            int i = jad_hu == null ? com.autonavi.amap.mapcore.tools.GlMapUtil.DEVICE_DISPLAY_DPI_NORMAL : jad_hu.densityDpi;
            com.jd.android.sdk.coreinfo.util.Logger.debugWithStackTrace(com.jd.android.sdk.coreinfo.CoreInfo.TAG, "getDensityDpiInt() --> ".concat(java.lang.String.valueOf(i)));
            return i;
        }

        public static java.lang.String getDeviceId(android.content.Context context) {
            com.jd.android.sdk.coreinfo.util.Logger.debugWithStackTrace(com.jd.android.sdk.coreinfo.CoreInfo.TAG, "getDeviceId() --> ".concat(""));
            return "";
        }

        public static java.lang.String getDeviceIdForDeviceFinger(android.content.Context context) {
            com.jd.android.sdk.coreinfo.util.Logger.debugWithStackTrace(com.jd.android.sdk.coreinfo.CoreInfo.TAG, "getDeviceIdForDeviceFinger() --> ".concat(""));
            return "";
        }

        public static java.lang.String getDeviceName() {
            com.jd.ad.sdk.jad_an.jad_bo jad_boVar = com.jd.android.sdk.coreinfo.CoreInfo.sensitiveApi;
            java.lang.String jad_an = jad_boVar != null ? jad_boVar.jad_an() : "";
            com.jd.ad.sdk.jad_an.jad_an.jad_an(jad_an, "getDeviceName() --> ", com.jd.android.sdk.coreinfo.CoreInfo.TAG);
            return jad_an;
        }

        public static java.lang.String getDisplayMetrics(android.content.Context context) {
            java.lang.String str;
            android.util.DisplayMetrics jad_hu = com.jd.android.sdk.coreinfo.jad_an.jad_hu(context);
            if (jad_hu == null) {
                str = "";
            } else {
                str = jad_hu.widthPixels + "*" + jad_hu.heightPixels;
            }
            com.jd.ad.sdk.jad_an.jad_an.jad_an(str, "getDisplayMetrics() --> ", com.jd.android.sdk.coreinfo.CoreInfo.TAG);
            return str;
        }

        public static android.util.DisplayMetrics getDisplayMetricsObject(android.content.Context context) {
            android.util.DisplayMetrics jad_hu = com.jd.android.sdk.coreinfo.jad_an.jad_hu(context);
            com.jd.android.sdk.coreinfo.util.Logger.debugWithStackTrace(com.jd.android.sdk.coreinfo.CoreInfo.TAG, "getDisplayMetricsObject() --> ".concat(java.lang.String.valueOf(jad_hu)));
            return jad_hu;
        }

        public static java.lang.String getDisplayMetricsWithNavigationBar(android.content.Context context) {
            java.lang.String jad_anVar = com.jd.ad.sdk.jad_dq.jad_bo.jad_an(context).toString();
            com.jd.ad.sdk.jad_an.jad_an.jad_an(jad_anVar, "getDisplayMetricsWithNavigationBar() --> ", com.jd.android.sdk.coreinfo.CoreInfo.TAG);
            return jad_anVar;
        }

        public static long getExternalStorageSize() {
            long j = 0;
            if (com.jd.android.sdk.coreinfo.jad_an.jad_vi <= 0) {
                try {
                    com.jd.android.sdk.coreinfo.jad_an.jad_vi = com.jd.android.sdk.coreinfo.jad_an.jad_an(android.os.Environment.getExternalStorageDirectory().getPath());
                } catch (java.lang.Exception e) {
                    com.jd.android.sdk.coreinfo.util.Logger.e("Baseinfo.DeviceInfo", "An exception happens when call getExternalStorageSize()", e);
                }
            }
            j = com.jd.android.sdk.coreinfo.jad_an.jad_vi;
            com.jd.android.sdk.coreinfo.util.Logger.debugWithStackTrace(com.jd.android.sdk.coreinfo.CoreInfo.TAG, "getExternalStorageSize() --> ".concat(java.lang.String.valueOf(j)));
            return j;
        }

        public static int getGateway(android.content.Context context) {
            android.net.DhcpInfo dhcpInfo;
            int i = 0;
            try {
                android.net.wifi.WifiManager wifiManager = (android.net.wifi.WifiManager) context.getApplicationContext().getSystemService(com.efs.sdk.base.core.util.NetworkUtil.NETWORK_TYPE_WIFI);
                if (wifiManager != null && (dhcpInfo = wifiManager.getDhcpInfo()) != null) {
                    i = dhcpInfo.gateway;
                }
            } catch (java.lang.Throwable unused) {
            }
            com.jd.android.sdk.coreinfo.util.Logger.debugWithStackTrace(com.jd.android.sdk.coreinfo.CoreInfo.TAG, "getGateway() --> ".concat(java.lang.String.valueOf(i)));
            return i;
        }

        public static java.lang.String getHardwareName() {
            if (android.text.TextUtils.isEmpty(com.jd.android.sdk.coreinfo.jad_an.jad_kx)) {
                com.jd.android.sdk.coreinfo.jad_an.jad_kx = com.jd.ad.sdk.jad_lo.jad_bo.jad_an(android.os.Build.HARDWARE);
            }
            java.lang.String str = com.jd.android.sdk.coreinfo.jad_an.jad_kx;
            com.jd.ad.sdk.jad_an.jad_an.jad_an(str, "getHardwareName() --> ", com.jd.android.sdk.coreinfo.CoreInfo.TAG);
            return str;
        }

        public static java.lang.String getHardwareSerialNo() {
            com.jd.ad.sdk.jad_an.jad_bo jad_boVar = com.jd.android.sdk.coreinfo.CoreInfo.sensitiveApi;
            java.lang.String jad_bo = jad_boVar != null ? jad_boVar.jad_bo() : "";
            com.jd.ad.sdk.jad_an.jad_an.jad_an(jad_bo, "getHardwareSerialNo() --> ", com.jd.android.sdk.coreinfo.CoreInfo.TAG);
            return jad_bo;
        }

        public static java.lang.String getHostName() {
            if (android.text.TextUtils.isEmpty(com.jd.android.sdk.coreinfo.jad_an.jad_mz)) {
                com.jd.android.sdk.coreinfo.jad_an.jad_mz = com.jd.ad.sdk.jad_lo.jad_bo.jad_an(android.os.Build.HOST);
            }
            java.lang.String str = com.jd.android.sdk.coreinfo.jad_an.jad_mz;
            com.jd.ad.sdk.jad_an.jad_an.jad_an(str, "getHostName() --> ", com.jd.android.sdk.coreinfo.CoreInfo.TAG);
            return str;
        }

        public static java.lang.String getIpAddressFromWifiInfo(android.content.Context context) {
            android.net.wifi.WifiInfo jad_fs;
            java.lang.String str = "";
            if (context == null) {
                com.jd.android.sdk.coreinfo.util.Logger.e("Baseinfo.DeviceInfo", "getIpAddressFromWifiInfo context is null");
            } else {
                android.net.NetworkInfo networkInfo = ((android.net.ConnectivityManager) context.getSystemService("connectivity")).getNetworkInfo(1);
                if (networkInfo != null && networkInfo.isConnected() && (jad_fs = com.jd.android.sdk.coreinfo.jad_an.jad_fs(context)) != null) {
                    int ipAddress = jad_fs.getIpAddress();
                    str = (ipAddress & 255) + "." + ((ipAddress >> 8) & 255) + "." + ((ipAddress >> 16) & 255) + "." + ((ipAddress >> 24) & 255);
                }
            }
            com.jd.ad.sdk.jad_an.jad_an.jad_an(str, "getIpAddressFromWifiInfo() --> ", com.jd.android.sdk.coreinfo.CoreInfo.TAG);
            return str;
        }

        public static java.lang.String getLinuxVersion() {
            java.lang.String str;
            if (android.text.TextUtils.isEmpty(com.jd.android.sdk.coreinfo.jad_an.jad_na)) {
                try {
                    str = com.jd.ad.sdk.jad_lo.jad_cp.jad_an("/proc/version", false);
                    try {
                        if (android.text.TextUtils.isEmpty(str)) {
                            str = com.jd.ad.sdk.jad_lo.jad_an.jad_an("uname -a");
                        }
                    } catch (java.lang.Throwable unused) {
                    }
                } catch (java.lang.Throwable unused2) {
                    str = "";
                }
                com.jd.android.sdk.coreinfo.jad_an.jad_na = com.jd.ad.sdk.jad_lo.jad_bo.jad_an(str);
            }
            java.lang.String str2 = com.jd.android.sdk.coreinfo.jad_an.jad_na;
            com.jd.ad.sdk.jad_an.jad_an.jad_an(str2, "getLinuxVersion() --> ", com.jd.android.sdk.coreinfo.CoreInfo.TAG);
            return str2;
        }

        public static java.lang.String getManufacture() {
            if (android.text.TextUtils.isEmpty(com.jd.android.sdk.coreinfo.jad_an.jad_dq)) {
                com.jd.android.sdk.coreinfo.jad_an.jad_dq = com.jd.ad.sdk.jad_lo.jad_bo.jad_an(android.os.Build.MANUFACTURER);
            }
            java.lang.String str = com.jd.android.sdk.coreinfo.jad_an.jad_dq;
            com.jd.ad.sdk.jad_an.jad_an.jad_an(str, "getManufacture() --> ", com.jd.android.sdk.coreinfo.CoreInfo.TAG);
            return str;
        }

        public static long getMemAvailSize(android.content.Context context) {
            long j = 0;
            if (context == null) {
                com.jd.android.sdk.coreinfo.util.Logger.w("Baseinfo.DeviceInfo", com.anythink.expressad.foundation.g.b.b.a);
            } else {
                try {
                    android.app.ActivityManager activityManager = (android.app.ActivityManager) context.getSystemService("activity");
                    android.app.ActivityManager.MemoryInfo memoryInfo = new android.app.ActivityManager.MemoryInfo();
                    activityManager.getMemoryInfo(memoryInfo);
                    j = memoryInfo.availMem >> 10;
                } catch (java.lang.Exception e) {
                    com.jd.android.sdk.coreinfo.util.Logger.e("Baseinfo.DeviceInfo", "An exception happens when call getMemAvailSize()", e);
                }
            }
            com.jd.android.sdk.coreinfo.util.Logger.debugWithStackTrace(com.jd.android.sdk.coreinfo.CoreInfo.TAG, "getMemAvailSize() --> ".concat(java.lang.String.valueOf(j)));
            return j;
        }

        /* JADX WARN: Code restructure failed: missing block: B:12:0x0038, code lost:
        
            if (r1 == null) goto L25;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public static java.lang.String[] getMemInfo() {
            java.lang.String[] strArr = {"", "", ""};
            java.io.BufferedReader bufferedReader = null;
            try {
                try {
                    java.io.BufferedReader bufferedReader2 = new java.io.BufferedReader(new java.io.FileReader("/proc/meminfo"), 8192);
                    for (int i = 0; i < 3; i++) {
                        try {
                            strArr[i] = bufferedReader2.readLine();
                        } catch (java.io.FileNotFoundException unused) {
                            bufferedReader = bufferedReader2;
                        } catch (java.io.IOException unused2) {
                            bufferedReader = bufferedReader2;
                            if (bufferedReader != null) {
                                bufferedReader.close();
                            }
                            com.jd.android.sdk.coreinfo.util.Logger.debugWithStackTrace(com.jd.android.sdk.coreinfo.CoreInfo.TAG, "getMemInfo() --> ".concat(java.lang.String.valueOf(strArr)));
                            return strArr;
                        } catch (java.lang.Throwable unused3) {
                            bufferedReader = bufferedReader2;
                            if (bufferedReader != null) {
                                bufferedReader.close();
                            }
                            com.jd.android.sdk.coreinfo.util.Logger.debugWithStackTrace(com.jd.android.sdk.coreinfo.CoreInfo.TAG, "getMemInfo() --> ".concat(java.lang.String.valueOf(strArr)));
                            return strArr;
                        }
                    }
                    bufferedReader2.close();
                } catch (java.io.IOException e) {
                    e.printStackTrace();
                }
            } catch (java.io.FileNotFoundException unused4) {
            } catch (java.io.IOException unused5) {
            } catch (java.lang.Throwable unused6) {
            }
            com.jd.android.sdk.coreinfo.util.Logger.debugWithStackTrace(com.jd.android.sdk.coreinfo.CoreInfo.TAG, "getMemInfo() --> ".concat(java.lang.String.valueOf(strArr)));
            return strArr;
        }

        public static long getMemState(android.content.Context context) {
            long j;
            java.io.BufferedReader bufferedReader = null;
            java.lang.String str = null;
            java.io.BufferedReader bufferedReader2 = null;
            try {
                java.io.BufferedReader bufferedReader3 = new java.io.BufferedReader(new java.io.InputStreamReader(new java.io.FileInputStream(new java.io.File("/proc/meminfo"))), 1024);
                java.lang.String str2 = null;
                while (true) {
                    try {
                        java.lang.String readLine = bufferedReader3.readLine();
                        if (readLine != null) {
                            if (readLine.startsWith("MemTotal")) {
                                str = readLine;
                            } else if (readLine.startsWith("MemFree")) {
                                str2 = readLine;
                            }
                            if (str != null && str2 != null) {
                                break;
                            }
                        } else {
                            break;
                        }
                    } catch (java.lang.Exception unused) {
                        bufferedReader2 = bufferedReader3;
                        if (bufferedReader2 != null) {
                            try {
                                bufferedReader2.close();
                            } catch (java.io.IOException unused2) {
                            }
                        }
                        j = 0;
                        com.jd.android.sdk.coreinfo.util.Logger.debugWithStackTrace(com.jd.android.sdk.coreinfo.CoreInfo.TAG, "getMemState() --> ".concat(java.lang.String.valueOf(j)));
                        return j;
                    } catch (java.lang.Throwable th) {
                        th = th;
                        bufferedReader = bufferedReader3;
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (java.io.IOException unused3) {
                            }
                        }
                        throw th;
                    }
                }
                android.app.ActivityManager activityManager = (android.app.ActivityManager) context.getSystemService("activity");
                android.app.ActivityManager.MemoryInfo memoryInfo = new android.app.ActivityManager.MemoryInfo();
                activityManager.getMemoryInfo(memoryInfo);
                j = new long[]{com.jd.android.sdk.coreinfo.jad_an.jad_bo(str), com.jd.android.sdk.coreinfo.jad_an.jad_bo(str2), memoryInfo.availMem}[0];
                try {
                    bufferedReader3.close();
                } catch (java.io.IOException unused4) {
                }
            } catch (java.lang.Exception unused5) {
            } catch (java.lang.Throwable th2) {
                th = th2;
            }
            com.jd.android.sdk.coreinfo.util.Logger.debugWithStackTrace(com.jd.android.sdk.coreinfo.CoreInfo.TAG, "getMemState() --> ".concat(java.lang.String.valueOf(j)));
            return j;
        }

        public static long getMemTotalSize(android.content.Context context) {
            long j = 0;
            if (com.jd.android.sdk.coreinfo.jad_an.jad_tg <= 0) {
                if (context == null) {
                    com.jd.android.sdk.coreinfo.util.Logger.w("Baseinfo.DeviceInfo", com.anythink.expressad.foundation.g.b.b.a);
                } else {
                    try {
                        android.app.ActivityManager activityManager = (android.app.ActivityManager) context.getSystemService("activity");
                        android.app.ActivityManager.MemoryInfo memoryInfo = new android.app.ActivityManager.MemoryInfo();
                        activityManager.getMemoryInfo(memoryInfo);
                        com.jd.android.sdk.coreinfo.jad_an.jad_tg = memoryInfo.totalMem >> 10;
                    } catch (java.lang.Exception e) {
                        com.jd.android.sdk.coreinfo.util.Logger.e("Baseinfo.DeviceInfo", "An exception happens when call getMemTotalSize()", e);
                    }
                }
                com.jd.android.sdk.coreinfo.util.Logger.debugWithStackTrace(com.jd.android.sdk.coreinfo.CoreInfo.TAG, "getMemTotalSize() --> ".concat(java.lang.String.valueOf(j)));
                return j;
            }
            j = com.jd.android.sdk.coreinfo.jad_an.jad_tg;
            com.jd.android.sdk.coreinfo.util.Logger.debugWithStackTrace(com.jd.android.sdk.coreinfo.CoreInfo.TAG, "getMemTotalSize() --> ".concat(java.lang.String.valueOf(j)));
            return j;
        }

        public static java.lang.String getModel() {
            if (android.text.TextUtils.isEmpty(com.jd.android.sdk.coreinfo.jad_an.jad_fs)) {
                if (android.text.TextUtils.isEmpty(com.jd.android.sdk.coreinfo.jad_an.jad_er)) {
                    com.jd.android.sdk.coreinfo.jad_an.jad_er = com.jd.ad.sdk.jad_lo.jad_bo.jad_an(android.os.Build.BRAND);
                }
                if (com.igexin.assist.util.AssistUtils.BRAND_XIAOMI.equalsIgnoreCase(com.jd.android.sdk.coreinfo.jad_an.jad_er)) {
                    com.jd.android.sdk.coreinfo.jad_an.jad_fs = com.jd.ad.sdk.jad_lo.jad_hu.jad_an("ro.product.marketname", "");
                }
                if (android.text.TextUtils.isEmpty(com.jd.android.sdk.coreinfo.jad_an.jad_fs)) {
                    com.jd.android.sdk.coreinfo.jad_an.jad_fs = com.jd.ad.sdk.jad_lo.jad_bo.jad_an(android.os.Build.MODEL);
                }
            }
            java.lang.String str = com.jd.android.sdk.coreinfo.jad_an.jad_fs;
            com.jd.ad.sdk.jad_an.jad_an.jad_an(str, "getModel() --> ", com.jd.android.sdk.coreinfo.CoreInfo.TAG);
            return str;
        }

        /* JADX WARN: Code restructure failed: missing block: B:30:0x0068, code lost:
        
            if (android.text.TextUtils.isEmpty(r0) == false) goto L25;
         */
        @java.lang.Deprecated
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public static java.lang.String getNetAddressInfo() {
            java.lang.String str;
            try {
                java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
                java.util.ArrayList<java.net.NetworkInterface> jad_cp = com.jd.android.sdk.coreinfo.jad_an.jad_cp();
                if (jad_cp != null) {
                    java.util.Iterator<java.net.NetworkInterface> it = jad_cp.iterator();
                    while (it.hasNext()) {
                        java.util.Enumeration<java.net.InetAddress> inetAddresses = it.next().getInetAddresses();
                        while (inetAddresses.hasMoreElements()) {
                            java.net.InetAddress nextElement = inetAddresses.nextElement();
                            if (!nextElement.isLoopbackAddress()) {
                                java.lang.String hostAddress = nextElement.getHostAddress();
                                if (!android.text.TextUtils.isEmpty(hostAddress)) {
                                    if (nextElement instanceof java.net.Inet4Address) {
                                        hostAddress = hostAddress + "%ipv4";
                                    }
                                    if (stringBuffer.length() != 0) {
                                        stringBuffer.append(", ");
                                    }
                                    stringBuffer.append(hostAddress);
                                }
                            }
                        }
                    }
                }
                str = stringBuffer.toString();
            } catch (java.lang.Throwable unused) {
            }
            str = "";
            com.jd.ad.sdk.jad_an.jad_an.jad_an(str, "getNetAddressInfo() --> ", com.jd.android.sdk.coreinfo.CoreInfo.TAG);
            return str;
        }

        public static java.lang.String[][] getNetAddresses() {
            java.lang.String[][] strArr;
            java.util.ArrayList arrayList = new java.util.ArrayList();
            java.util.ArrayList arrayList2 = new java.util.ArrayList();
            try {
                java.util.ArrayList<java.net.NetworkInterface> jad_cp = com.jd.android.sdk.coreinfo.jad_an.jad_cp();
                if (jad_cp != null) {
                    java.util.Iterator<java.net.NetworkInterface> it = jad_cp.iterator();
                    while (it.hasNext()) {
                        java.util.Enumeration<java.net.InetAddress> inetAddresses = it.next().getInetAddresses();
                        while (inetAddresses.hasMoreElements()) {
                            java.net.InetAddress nextElement = inetAddresses.nextElement();
                            if (!nextElement.isLoopbackAddress()) {
                                java.lang.String hostAddress = nextElement.getHostAddress();
                                if (!android.text.TextUtils.isEmpty(hostAddress)) {
                                    if (nextElement instanceof java.net.Inet4Address) {
                                        arrayList.add(hostAddress);
                                    } else if (nextElement instanceof java.net.Inet6Address) {
                                        arrayList2.add(hostAddress);
                                    }
                                }
                            }
                        }
                    }
                }
                strArr = new java.lang.String[][]{(java.lang.String[]) arrayList.toArray(new java.lang.String[arrayList.size()]), (java.lang.String[]) arrayList2.toArray(new java.lang.String[arrayList2.size()])};
            } catch (java.lang.Throwable unused) {
                strArr = (java.lang.String[][]) java.lang.reflect.Array.newInstance((java.lang.Class<?>) java.lang.String.class, 0, 0);
            }
            com.jd.android.sdk.coreinfo.util.Logger.debugWithStackTrace(com.jd.android.sdk.coreinfo.CoreInfo.TAG, "getNetAddresses() --> ".concat(java.lang.String.valueOf(strArr)));
            return strArr;
        }

        public static java.util.List<java.lang.String> getNetAddressesForIPv4() {
            java.util.ArrayList arrayList = new java.util.ArrayList();
            try {
                java.util.ArrayList<java.net.NetworkInterface> jad_cp = com.jd.android.sdk.coreinfo.jad_an.jad_cp();
                if (jad_cp != null) {
                    java.util.Iterator<java.net.NetworkInterface> it = jad_cp.iterator();
                    while (it.hasNext()) {
                        java.util.Enumeration<java.net.InetAddress> inetAddresses = it.next().getInetAddresses();
                        while (inetAddresses.hasMoreElements()) {
                            java.net.InetAddress nextElement = inetAddresses.nextElement();
                            if (!nextElement.isLoopbackAddress()) {
                                java.lang.String hostAddress = nextElement.getHostAddress();
                                if (!android.text.TextUtils.isEmpty(hostAddress) && (nextElement instanceof java.net.Inet4Address)) {
                                    arrayList.add(hostAddress);
                                }
                            }
                        }
                    }
                }
            } catch (java.lang.Throwable unused) {
                arrayList = new java.util.ArrayList();
            }
            com.jd.android.sdk.coreinfo.util.Logger.debugWithStackTrace(com.jd.android.sdk.coreinfo.CoreInfo.TAG, "getNetAddressesForIPv4() --> ".concat(java.lang.String.valueOf(arrayList)));
            return arrayList;
        }

        public static java.util.List<java.lang.String> getNetAddressesForIPv6() {
            java.util.ArrayList arrayList = new java.util.ArrayList();
            try {
                java.util.ArrayList<java.net.NetworkInterface> jad_cp = com.jd.android.sdk.coreinfo.jad_an.jad_cp();
                if (jad_cp != null) {
                    java.util.Iterator<java.net.NetworkInterface> it = jad_cp.iterator();
                    while (it.hasNext()) {
                        java.util.Enumeration<java.net.InetAddress> inetAddresses = it.next().getInetAddresses();
                        while (inetAddresses.hasMoreElements()) {
                            java.net.InetAddress nextElement = inetAddresses.nextElement();
                            if (!nextElement.isLoopbackAddress()) {
                                java.lang.String hostAddress = nextElement.getHostAddress();
                                if (!android.text.TextUtils.isEmpty(hostAddress) && (nextElement instanceof java.net.Inet6Address)) {
                                    arrayList.add(hostAddress);
                                }
                            }
                        }
                    }
                }
            } catch (java.lang.Throwable unused) {
                arrayList = new java.util.ArrayList();
            }
            com.jd.android.sdk.coreinfo.util.Logger.debugWithStackTrace(com.jd.android.sdk.coreinfo.CoreInfo.TAG, "getNetAddressesForIPv6() --> ".concat(java.lang.String.valueOf(arrayList)));
            return arrayList;
        }

        public static int getNetmask(android.content.Context context) {
            android.net.DhcpInfo dhcpInfo;
            int i = 0;
            try {
                android.net.wifi.WifiManager wifiManager = (android.net.wifi.WifiManager) context.getApplicationContext().getSystemService(com.efs.sdk.base.core.util.NetworkUtil.NETWORK_TYPE_WIFI);
                if (wifiManager != null && (dhcpInfo = wifiManager.getDhcpInfo()) != null) {
                    i = dhcpInfo.netmask;
                }
            } catch (java.lang.Throwable unused) {
            }
            com.jd.android.sdk.coreinfo.util.Logger.debugWithStackTrace(com.jd.android.sdk.coreinfo.CoreInfo.TAG, "getNetmask() --> ".concat(java.lang.String.valueOf(i)));
            return i;
        }

        public static java.lang.String getNetworkISO(android.content.Context context) {
            java.lang.String str = "";
            try {
                java.lang.String networkCountryIso = ((android.telephony.TelephonyManager) context.getSystemService(com.aliyun.vod.log.core.AliyunLogCommon.TERMINAL_TYPE)).getNetworkCountryIso();
                if (!android.text.TextUtils.isEmpty(networkCountryIso)) {
                    str = networkCountryIso;
                }
            } catch (java.lang.Exception unused) {
            }
            com.jd.ad.sdk.jad_an.jad_an.jad_an(str, "getNetworkISO() --> ", com.jd.android.sdk.coreinfo.CoreInfo.TAG);
            return str;
        }

        public static java.util.ArrayList<java.net.NetworkInterface> getNetworkInterfaces() {
            java.util.ArrayList<java.net.NetworkInterface> list = java.util.Collections.list(java.net.NetworkInterface.getNetworkInterfaces());
            com.jd.android.sdk.coreinfo.util.Logger.debugWithStackTrace(com.jd.android.sdk.coreinfo.CoreInfo.TAG, "getNetworkInterfaces() --> ".concat(java.lang.String.valueOf(list)));
            return list;
        }

        public static java.lang.String getNetworkOperator(android.content.Context context) {
            java.lang.String str;
            try {
                str = com.jd.ad.sdk.jad_lo.jad_bo.jad_an(((android.telephony.TelephonyManager) context.getSystemService(com.aliyun.vod.log.core.AliyunLogCommon.TERMINAL_TYPE)).getNetworkOperator());
            } catch (java.lang.Exception unused) {
                str = "";
            }
            com.jd.ad.sdk.jad_an.jad_an.jad_an(str, "getNetworkOperator() --> ", com.jd.android.sdk.coreinfo.CoreInfo.TAG);
            return str;
        }

        public static java.lang.String getNetworkOperatorName(android.content.Context context) {
            java.lang.String str;
            try {
                str = com.jd.ad.sdk.jad_lo.jad_bo.jad_an(((android.telephony.TelephonyManager) context.getSystemService(com.aliyun.vod.log.core.AliyunLogCommon.TERMINAL_TYPE)).getNetworkOperatorName());
            } catch (java.lang.Exception unused) {
                str = "";
            }
            com.jd.ad.sdk.jad_an.jad_an.jad_an(str, "getNetworkOperatorName() --> ", com.jd.android.sdk.coreinfo.CoreInfo.TAG);
            return str;
        }

        public static java.lang.String getNetworkType(android.content.Context context) {
            java.lang.String jad_jw = com.jd.android.sdk.coreinfo.jad_an.jad_jw(context);
            com.jd.android.sdk.coreinfo.util.Logger.debugWithStackTrace(com.jd.android.sdk.coreinfo.CoreInfo.TAG, "getNetworkType() --> ".concat(jad_jw));
            return jad_jw;
        }

        public static java.lang.String getNetworkTypeForDeviceFinger(android.content.Context context) {
            android.net.NetworkInfo activeNetworkInfo;
            java.lang.String str = "";
            if (context != null) {
                try {
                    android.net.ConnectivityManager connectivityManager = (android.net.ConnectivityManager) context.getSystemService("connectivity");
                    if (connectivityManager != null && (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) != null && activeNetworkInfo.isConnected()) {
                        str = activeNetworkInfo.getSubtypeName();
                        java.lang.String typeName = activeNetworkInfo.getTypeName();
                        if (activeNetworkInfo.getType() == 1) {
                            str = typeName;
                        }
                    }
                } catch (java.lang.Throwable unused) {
                }
            }
            com.jd.ad.sdk.jad_an.jad_an.jad_an(str, "getNetworkTypeForDeviceFinger() --> ", com.jd.android.sdk.coreinfo.CoreInfo.TAG);
            return str;
        }

        public static int getNetworkTypeInt(android.content.Context context) {
            com.jd.ad.sdk.jad_an.jad_bo jad_boVar = com.jd.android.sdk.coreinfo.CoreInfo.sensitiveApi;
            int jad_an = jad_boVar != null ? jad_boVar.jad_an(context) : 0;
            com.jd.android.sdk.coreinfo.util.Logger.debugWithStackTrace(com.jd.android.sdk.coreinfo.CoreInfo.TAG, "getNetworkTypeInt() --> ".concat(java.lang.String.valueOf(jad_an)));
            return jad_an;
        }

        public static java.lang.String getProductName() {
            if (android.text.TextUtils.isEmpty(com.jd.android.sdk.coreinfo.jad_an.jad_cp)) {
                com.jd.android.sdk.coreinfo.jad_an.jad_cp = com.jd.ad.sdk.jad_lo.jad_bo.jad_an(android.os.Build.PRODUCT);
            }
            java.lang.String str = com.jd.android.sdk.coreinfo.jad_an.jad_cp;
            com.jd.ad.sdk.jad_an.jad_an.jad_an(str, "getProductName() --> ", com.jd.android.sdk.coreinfo.CoreInfo.TAG);
            return str;
        }

        public static java.lang.String getRadioVersion() {
            if (android.text.TextUtils.isEmpty(com.jd.android.sdk.coreinfo.jad_an.jad_jw)) {
                com.jd.android.sdk.coreinfo.jad_an.jad_jw = com.jd.ad.sdk.jad_lo.jad_bo.jad_an(android.os.Build.getRadioVersion());
            }
            java.lang.String str = com.jd.android.sdk.coreinfo.jad_an.jad_jw;
            com.jd.ad.sdk.jad_an.jad_an.jad_an(str, "getRadioVersion() --> ", com.jd.android.sdk.coreinfo.CoreInfo.TAG);
            return str;
        }

        public static com.jd.android.sdk.coreinfo.ScreenSize getRealScreenSize(android.content.Context context) {
            com.jd.ad.sdk.jad_dq.jad_bo.jad_an jad_an = com.jd.ad.sdk.jad_dq.jad_bo.jad_an(context);
            com.jd.android.sdk.coreinfo.ScreenSize screenSize = new com.jd.android.sdk.coreinfo.ScreenSize(jad_an.jad_an, jad_an.jad_bo);
            com.jd.android.sdk.coreinfo.util.Logger.debugWithStackTrace(com.jd.android.sdk.coreinfo.CoreInfo.TAG, "getRealScreenSize() --> ".concat(java.lang.String.valueOf(screenSize)));
            return screenSize;
        }

        public static long getRomSize() {
            long j = 0;
            if (com.jd.android.sdk.coreinfo.jad_an.jad_uh <= 0) {
                try {
                    com.jd.android.sdk.coreinfo.jad_an.jad_uh = com.jd.android.sdk.coreinfo.jad_an.jad_an(android.os.Environment.getDataDirectory().getPath());
                } catch (java.lang.Exception e) {
                    com.jd.android.sdk.coreinfo.util.Logger.e("Baseinfo.DeviceInfo", "An exception happens when call getRomSize()", e);
                }
            }
            j = com.jd.android.sdk.coreinfo.jad_an.jad_uh;
            com.jd.android.sdk.coreinfo.util.Logger.debugWithStackTrace(com.jd.android.sdk.coreinfo.CoreInfo.TAG, "getRomSize() --> ".concat(java.lang.String.valueOf(j)));
            return j;
        }

        public static java.lang.String getSDCardId() {
            java.lang.String jad_an = com.jd.ad.sdk.jad_lo.jad_bo.jad_an(com.jd.ad.sdk.jad_lo.jad_cp.jad_an("/sys/block/mmcblk0/device/cid", false));
            com.jd.ad.sdk.jad_an.jad_an.jad_an(jad_an, "getSDCardId() --> ", com.jd.android.sdk.coreinfo.CoreInfo.TAG);
            return jad_an;
        }

        public static float getScaledDensity(android.content.Context context) {
            android.util.DisplayMetrics jad_hu = com.jd.android.sdk.coreinfo.jad_an.jad_hu(context);
            float f = jad_hu == null ? 1.0f : jad_hu.scaledDensity;
            com.jd.android.sdk.coreinfo.util.Logger.debugWithStackTrace(com.jd.android.sdk.coreinfo.CoreInfo.TAG, "getScaledDensity() --> ".concat(java.lang.String.valueOf(f)));
            return f;
        }

        public static int getScreenHeight(android.content.Context context) {
            android.util.DisplayMetrics jad_hu = com.jd.android.sdk.coreinfo.jad_an.jad_hu(context);
            int i = jad_hu == null ? 320 : jad_hu.heightPixels;
            com.jd.android.sdk.coreinfo.util.Logger.debugWithStackTrace(com.jd.android.sdk.coreinfo.CoreInfo.TAG, "getScreenHeight() --> ".concat(java.lang.String.valueOf(i)));
            return i;
        }

        public static int getScreenHeight2() {
            android.util.DisplayMetrics displayMetrics;
            try {
                displayMetrics = android.content.res.Resources.getSystem().getDisplayMetrics();
            } catch (java.lang.Exception e) {
                com.jd.android.sdk.coreinfo.util.Logger.e("Baseinfo.DeviceInfo", "An exception happends when call getSystemDisplayMetricsObject()", e);
                displayMetrics = null;
            }
            int i = displayMetrics == null ? 320 : displayMetrics.heightPixels;
            com.jd.android.sdk.coreinfo.util.Logger.debugWithStackTrace(com.jd.android.sdk.coreinfo.CoreInfo.TAG, "getScreenHeight2() --> ".concat(java.lang.String.valueOf(i)));
            return i;
        }

        public static int getScreenWidth(android.content.Context context) {
            android.util.DisplayMetrics jad_hu = com.jd.android.sdk.coreinfo.jad_an.jad_hu(context);
            int i = jad_hu == null ? 240 : jad_hu.widthPixels;
            com.jd.android.sdk.coreinfo.util.Logger.debugWithStackTrace(com.jd.android.sdk.coreinfo.CoreInfo.TAG, "getScreenWidth() --> ".concat(java.lang.String.valueOf(i)));
            return i;
        }

        public static int getScreenWidth2() {
            android.util.DisplayMetrics displayMetrics;
            try {
                displayMetrics = android.content.res.Resources.getSystem().getDisplayMetrics();
            } catch (java.lang.Exception e) {
                com.jd.android.sdk.coreinfo.util.Logger.e("Baseinfo.DeviceInfo", "An exception happends when call getSystemDisplayMetricsObject()", e);
                displayMetrics = null;
            }
            int i = displayMetrics == null ? 240 : displayMetrics.widthPixels;
            com.jd.android.sdk.coreinfo.util.Logger.debugWithStackTrace(com.jd.android.sdk.coreinfo.CoreInfo.TAG, "getScreenWidth2() --> ".concat(java.lang.String.valueOf(i)));
            return i;
        }

        public static java.util.List<android.hardware.Sensor> getSensorList(android.content.Context context) {
            java.util.List<android.hardware.Sensor> sensorList = ((android.hardware.SensorManager) context.getSystemService(com.umeng.analytics.pro.bo.ac)).getSensorList(-1);
            com.jd.android.sdk.coreinfo.util.Logger.debugWithStackTrace(com.jd.android.sdk.coreinfo.CoreInfo.TAG, "getSensorList() --> ".concat(java.lang.String.valueOf(sensorList)));
            return sensorList;
        }

        public static java.lang.String getSimCountryIso(android.content.Context context) {
            java.lang.String str = "";
            if (context != null) {
                try {
                    android.telephony.TelephonyManager telephonyManager = (android.telephony.TelephonyManager) context.getSystemService(com.aliyun.vod.log.core.AliyunLogCommon.TERMINAL_TYPE);
                    if (telephonyManager != null) {
                        str = com.jd.ad.sdk.jad_lo.jad_bo.jad_an(telephonyManager.getSimCountryIso());
                    }
                } catch (java.lang.Throwable unused) {
                }
            }
            com.jd.ad.sdk.jad_an.jad_an.jad_an(str, "getSimCountryIso() --> ", com.jd.android.sdk.coreinfo.CoreInfo.TAG);
            return str;
        }

        public static java.lang.String getSimOperator(android.content.Context context) {
            java.lang.String str;
            java.lang.String str2 = "";
            if (context != null) {
                try {
                    str2 = com.jd.ad.sdk.jad_lo.jad_bo.jad_an(((android.telephony.TelephonyManager) context.getSystemService(com.aliyun.vod.log.core.AliyunLogCommon.TERMINAL_TYPE)).getSimOperator());
                } catch (java.lang.Throwable th) {
                    str = "DeviceInfo.getSimOperator() exception: " + th.getMessage();
                }
                com.jd.ad.sdk.jad_an.jad_an.jad_an(str2, "getSimOperator() --> ", com.jd.android.sdk.coreinfo.CoreInfo.TAG);
                return str2;
            }
            str = com.anythink.expressad.foundation.g.b.b.a;
            com.jd.android.sdk.coreinfo.util.Logger.w("Baseinfo.DeviceInfo", str);
            com.jd.ad.sdk.jad_an.jad_an.jad_an(str2, "getSimOperator() --> ", com.jd.android.sdk.coreinfo.CoreInfo.TAG);
            return str2;
        }

        public static java.lang.String getSimOperatorName(android.content.Context context) {
            java.lang.String str = "";
            if (context != null) {
                try {
                    android.telephony.TelephonyManager telephonyManager = (android.telephony.TelephonyManager) context.getSystemService(com.aliyun.vod.log.core.AliyunLogCommon.TERMINAL_TYPE);
                    if (telephonyManager != null) {
                        str = com.jd.ad.sdk.jad_lo.jad_bo.jad_an(telephonyManager.getSimOperatorName());
                    }
                } catch (java.lang.Throwable unused) {
                }
            }
            com.jd.ad.sdk.jad_an.jad_an.jad_an(str, "getSimOperatorName() --> ", com.jd.android.sdk.coreinfo.CoreInfo.TAG);
            return str;
        }

        public static java.lang.String getSimSerialNo(android.content.Context context) {
            com.jd.ad.sdk.jad_an.jad_bo jad_boVar = com.jd.android.sdk.coreinfo.CoreInfo.sensitiveApi;
            java.lang.String jad_cp = jad_boVar != null ? jad_boVar.jad_cp(context) : "";
            com.jd.ad.sdk.jad_an.jad_an.jad_an(jad_cp, "getSimSerialNo() --> ", com.jd.android.sdk.coreinfo.CoreInfo.TAG);
            return jad_cp;
        }

        public static java.lang.String getSubscriberId(android.content.Context context) {
            com.jd.android.sdk.coreinfo.util.Logger.debugWithStackTrace(com.jd.android.sdk.coreinfo.CoreInfo.TAG, "getSubscriberId() --> ".concat(""));
            return "";
        }

        public static java.lang.String getSubscriberIdForDeviceFinger(android.content.Context context) {
            com.jd.android.sdk.coreinfo.util.Logger.debugWithStackTrace(com.jd.android.sdk.coreinfo.CoreInfo.TAG, "getSubscriberIdForDeviceFinger() --> ".concat(""));
            return "";
        }

        public static java.lang.String[] getSuppportedABIs() {
            java.lang.String[] strArr = com.jd.android.sdk.coreinfo.jad_an.jad_iv;
            if (strArr == null || strArr.length == 0) {
                com.jd.android.sdk.coreinfo.jad_an.jad_iv = android.os.Build.SUPPORTED_ABIS;
            }
            java.lang.String[] strArr2 = com.jd.android.sdk.coreinfo.jad_an.jad_iv;
            com.jd.android.sdk.coreinfo.util.Logger.debugWithStackTrace(com.jd.android.sdk.coreinfo.CoreInfo.TAG, "getSuppportedABIs() --> ".concat(java.lang.String.valueOf(strArr2)));
            return strArr2;
        }

        public static java.lang.String getUserAgent(android.content.Context context) {
            java.lang.String jad_an = com.jd.ad.sdk.jad_dq.jad_dq.jad_an(context, 1000L);
            com.jd.ad.sdk.jad_an.jad_an.jad_an(jad_an, "getUserAgent() --> ", com.jd.android.sdk.coreinfo.CoreInfo.TAG);
            return jad_an;
        }

        public static java.lang.String getUserAgent(android.content.Context context, long j) {
            java.lang.String jad_an = com.jd.ad.sdk.jad_dq.jad_dq.jad_an(context, j);
            com.jd.ad.sdk.jad_an.jad_an.jad_an(jad_an, "getUserAgent() --> ", com.jd.android.sdk.coreinfo.CoreInfo.TAG);
            return jad_an;
        }

        /* JADX WARN: Code restructure failed: missing block: B:6:0x0016, code lost:
        
            if ("02:00:00:00:00:00".equals(r2) == false) goto L9;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public static java.lang.String getWifiBSSID(android.content.Context context) {
            java.lang.String str;
            android.net.wifi.WifiInfo jad_fs = com.jd.android.sdk.coreinfo.jad_an.jad_fs(context);
            if (jad_fs != null) {
                str = jad_fs.getBSSID();
                if (!android.text.TextUtils.isEmpty(str)) {
                }
            }
            str = "";
            com.jd.ad.sdk.jad_an.jad_an.jad_an(str, "getWifiBSSID() --> ", com.jd.android.sdk.coreinfo.CoreInfo.TAG);
            return str;
        }

        public static java.util.List<java.lang.String> getWifiBSSIDList(android.content.Context context) {
            java.util.List<java.lang.String> jad_cp = com.jd.android.sdk.coreinfo.jad_an.jad_cp(context);
            com.jd.android.sdk.coreinfo.util.Logger.debugWithStackTrace(com.jd.android.sdk.coreinfo.CoreInfo.TAG, "getWifiBSSIDList() --> ".concat(java.lang.String.valueOf(jad_cp)));
            return jad_cp;
        }

        public static java.util.Map<java.lang.String, java.lang.String> getWifiBssidAndSsidMap(android.content.Context context) {
            java.util.HashMap hashMap = new java.util.HashMap();
            java.util.List<android.net.wifi.ScanResult> jad_jt = com.jd.android.sdk.coreinfo.jad_an.jad_jt(context);
            if (jad_jt != null && !jad_jt.isEmpty()) {
                for (android.net.wifi.ScanResult scanResult : jad_jt) {
                    hashMap.put(scanResult.BSSID, scanResult.SSID);
                }
            }
            com.jd.android.sdk.coreinfo.util.Logger.debugWithStackTrace(com.jd.android.sdk.coreinfo.CoreInfo.TAG, "getWifiBssidAndSsidMap() --> ".concat(java.lang.String.valueOf(hashMap)));
            return hashMap;
        }

        public static android.net.wifi.WifiInfo getWifiInfo(android.content.Context context) {
            android.net.wifi.WifiInfo jad_an = com.jd.android.sdk.coreinfo.jad_an.jad_an(context);
            com.jd.android.sdk.coreinfo.util.Logger.debugWithStackTrace(com.jd.android.sdk.coreinfo.CoreInfo.TAG, "getWifiInfo() --> ".concat(java.lang.String.valueOf(jad_an)));
            if (!com.jd.android.sdk.coreinfo.util.Logger.printStack) {
                com.jd.android.sdk.coreinfo.util.Logger.d(com.jd.android.sdk.coreinfo.CoreInfo.TAG, com.jd.android.sdk.coreinfo.util.Logger.getStackTrace());
            }
            return jad_an;
        }

        public static int getWifiLinkSpeed(android.content.Context context) {
            android.net.wifi.WifiInfo jad_fs = com.jd.android.sdk.coreinfo.jad_an.jad_fs(context);
            int linkSpeed = jad_fs != null ? jad_fs.getLinkSpeed() : -1;
            com.jd.android.sdk.coreinfo.util.Logger.debugWithStackTrace(com.jd.android.sdk.coreinfo.CoreInfo.TAG, "getWifiLinkSpeed() --> ".concat(java.lang.String.valueOf(linkSpeed)));
            return linkSpeed;
        }

        public static java.util.List<java.lang.String> getWifiList(android.content.Context context) {
            java.util.List<java.lang.String> jad_cp = com.jd.android.sdk.coreinfo.jad_an.jad_cp(context);
            com.jd.android.sdk.coreinfo.util.Logger.debugWithStackTrace(com.jd.android.sdk.coreinfo.CoreInfo.TAG, "getWifiList() --> ".concat(java.lang.String.valueOf(jad_cp)));
            return jad_cp;
        }

        @java.lang.Deprecated
        public static java.lang.String getWifiMacAddress(android.content.Context context) {
            com.jd.ad.sdk.jad_an.jad_bo jad_boVar = com.jd.android.sdk.coreinfo.CoreInfo.sensitiveApi;
            return jad_boVar != null ? jad_boVar.jad_bo(context) : "";
        }

        @java.lang.Deprecated
        public static java.lang.String getWifiMacAddressForDeviceFinger(android.content.Context context) {
            return "";
        }

        @java.lang.Deprecated
        public static java.lang.String getWifiMacAddressOver23() {
            com.jd.ad.sdk.jad_an.jad_bo jad_boVar = com.jd.android.sdk.coreinfo.CoreInfo.sensitiveApi;
            return jad_boVar != null ? jad_boVar.jad_cp() : "";
        }

        public static int getWifiRssi(android.content.Context context) {
            android.net.wifi.WifiInfo wifiInfo;
            int rssi = (!android.text.TextUtils.equals(com.jd.android.sdk.coreinfo.jad_an.jad_jw(context), com.efs.sdk.base.core.util.NetworkUtil.NETWORK_TYPE_WIFI) || (wifiInfo = getWifiInfo(context)) == null) ? 0 : wifiInfo.getRssi();
            com.jd.android.sdk.coreinfo.util.Logger.debugWithStackTrace(com.jd.android.sdk.coreinfo.CoreInfo.TAG, "getWifiRssi() --> ".concat(java.lang.String.valueOf(rssi)));
            return rssi;
        }

        /* JADX WARN: Code restructure failed: missing block: B:6:0x0016, code lost:
        
            if ("<unknown ssid>".equals(r2) == false) goto L9;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public static java.lang.String getWifiSSID(android.content.Context context) {
            java.lang.String str;
            android.net.wifi.WifiInfo jad_fs = com.jd.android.sdk.coreinfo.jad_an.jad_fs(context);
            if (jad_fs != null) {
                str = jad_fs.getSSID();
                if (!android.text.TextUtils.isEmpty(str)) {
                }
            }
            str = "";
            com.jd.ad.sdk.jad_an.jad_an.jad_an(str, "getWifiSSID() --> ", com.jd.android.sdk.coreinfo.CoreInfo.TAG);
            return str;
        }

        public static java.util.List<java.lang.String> getWifiSSIDList(android.content.Context context) {
            java.util.ArrayList arrayList = new java.util.ArrayList();
            java.util.List<android.net.wifi.ScanResult> jad_jt = com.jd.android.sdk.coreinfo.jad_an.jad_jt(context);
            if (jad_jt != null && !jad_jt.isEmpty()) {
                java.util.Iterator<android.net.wifi.ScanResult> it = jad_jt.iterator();
                while (it.hasNext()) {
                    arrayList.add(it.next().SSID);
                }
            }
            com.jd.android.sdk.coreinfo.util.Logger.debugWithStackTrace(com.jd.android.sdk.coreinfo.CoreInfo.TAG, "getWifiSSIDList() --> ".concat(java.lang.String.valueOf(arrayList)));
            return arrayList;
        }

        public static java.util.List<android.net.wifi.ScanResult> getWifiScanResultList(android.content.Context context) {
            java.util.List<android.net.wifi.ScanResult> jad_bo = com.jd.android.sdk.coreinfo.jad_an.jad_bo(context);
            com.jd.android.sdk.coreinfo.util.Logger.debugWithStackTrace(com.jd.android.sdk.coreinfo.CoreInfo.TAG, "getWifiScanResultList() --> ".concat(java.lang.String.valueOf(jad_bo)));
            if (!com.jd.android.sdk.coreinfo.util.Logger.printStack) {
                com.jd.android.sdk.coreinfo.util.Logger.d(com.jd.android.sdk.coreinfo.CoreInfo.TAG, com.jd.android.sdk.coreinfo.util.Logger.getStackTrace());
            }
            return jad_bo;
        }

        public static boolean isBluetoothAvailabel() {
            if (!com.jd.android.sdk.coreinfo.jad_an.jad_fq) {
                com.jd.android.sdk.coreinfo.jad_an.jad_ep = android.bluetooth.BluetoothAdapter.getDefaultAdapter() != null;
                com.jd.android.sdk.coreinfo.jad_an.jad_fq = true;
            }
            boolean z = com.jd.android.sdk.coreinfo.jad_an.jad_ep;
            com.jd.android.sdk.coreinfo.util.Logger.debugWithStackTrace(com.jd.android.sdk.coreinfo.CoreInfo.TAG, "isBluetoothAvailabel() --> ".concat(java.lang.String.valueOf(z)));
            return z;
        }

        public static boolean isBluetoothEnabled() {
            android.bluetooth.BluetoothAdapter defaultAdapter = android.bluetooth.BluetoothAdapter.getDefaultAdapter();
            boolean z = defaultAdapter != null && defaultAdapter.isEnabled();
            com.jd.android.sdk.coreinfo.util.Logger.debugWithStackTrace(com.jd.android.sdk.coreinfo.CoreInfo.TAG, "isBluetoothEnabled() --> ".concat(java.lang.String.valueOf(z)));
            return z;
        }

        @android.annotation.TargetApi(23)
        public static boolean isFingerprintAvailable(android.content.Context context) {
            boolean z;
            android.hardware.fingerprint.FingerprintManager fingerprintManager;
            boolean isHardwareDetected;
            if (!com.jd.android.sdk.coreinfo.jad_an.jad_zm) {
                z = false;
                if (context == null) {
                    com.jd.android.sdk.coreinfo.util.Logger.w("Baseinfo.DeviceInfo", com.anythink.expressad.foundation.g.b.b.a);
                } else if (android.os.Build.VERSION.SDK_INT >= 23 && (fingerprintManager = (android.hardware.fingerprint.FingerprintManager) context.getSystemService("fingerprint")) != null) {
                    try {
                        isHardwareDetected = fingerprintManager.isHardwareDetected();
                        com.jd.android.sdk.coreinfo.jad_an.jad_yl = isHardwareDetected;
                        com.jd.android.sdk.coreinfo.jad_an.jad_zm = true;
                    } catch (java.lang.Throwable th) {
                        com.jd.android.sdk.coreinfo.util.Logger.e("Baseinfo.DeviceInfo", "An error occors when call isFingerprintAvailable()", th);
                    }
                }
                com.jd.android.sdk.coreinfo.util.Logger.debugWithStackTrace(com.jd.android.sdk.coreinfo.CoreInfo.TAG, "isFingerprintAvailable() --> ".concat(java.lang.String.valueOf(z)));
                return z;
            }
            z = com.jd.android.sdk.coreinfo.jad_an.jad_yl;
            com.jd.android.sdk.coreinfo.util.Logger.debugWithStackTrace(com.jd.android.sdk.coreinfo.CoreInfo.TAG, "isFingerprintAvailable() --> ".concat(java.lang.String.valueOf(z)));
            return z;
        }

        public static boolean isGPSAvailable(android.content.Context context) {
            boolean z;
            if (!com.jd.android.sdk.coreinfo.jad_an.jad_xk) {
                z = false;
                if (context == null) {
                    com.jd.android.sdk.coreinfo.util.Logger.w("Baseinfo.DeviceInfo", com.anythink.expressad.foundation.g.b.b.a);
                } else {
                    android.location.LocationManager locationManager = (android.location.LocationManager) context.getSystemService(com.alibaba.sdk.android.oss.common.RequestParameters.SUBRESOURCE_LOCATION);
                    if (locationManager != null) {
                        java.util.List<java.lang.String> allProviders = locationManager.getAllProviders();
                        if (allProviders != null && allProviders.contains(com.amap.api.services.geocoder.GeocodeSearch.GPS)) {
                            z = true;
                        }
                        com.jd.android.sdk.coreinfo.jad_an.jad_wj = z;
                        com.jd.android.sdk.coreinfo.jad_an.jad_xk = true;
                    }
                }
                com.jd.android.sdk.coreinfo.util.Logger.debugWithStackTrace(com.jd.android.sdk.coreinfo.CoreInfo.TAG, "isGPSAvailable() --> ".concat(java.lang.String.valueOf(z)));
                return z;
            }
            z = com.jd.android.sdk.coreinfo.jad_an.jad_wj;
            com.jd.android.sdk.coreinfo.util.Logger.debugWithStackTrace(com.jd.android.sdk.coreinfo.CoreInfo.TAG, "isGPSAvailable() --> ".concat(java.lang.String.valueOf(z)));
            return z;
        }

        public static boolean isNFCAvailable(android.content.Context context) {
            boolean jad_iv = com.jd.android.sdk.coreinfo.jad_an.jad_iv(context);
            com.jd.android.sdk.coreinfo.util.Logger.debugWithStackTrace(com.jd.android.sdk.coreinfo.CoreInfo.TAG, "isNFCAvailable() --> ".concat(java.lang.String.valueOf(jad_iv)));
            return jad_iv;
        }

        public static boolean isNFCEnabled(android.content.Context context) {
            android.nfc.NfcAdapter defaultAdapter;
            boolean z = com.jd.android.sdk.coreinfo.jad_an.jad_iv(context) && (defaultAdapter = ((android.nfc.NfcManager) context.getSystemService("nfc")).getDefaultAdapter()) != null && defaultAdapter.isEnabled();
            com.jd.android.sdk.coreinfo.util.Logger.debugWithStackTrace(com.jd.android.sdk.coreinfo.CoreInfo.TAG, "isNFCEnabled() --> ".concat(java.lang.String.valueOf(z)));
            return z;
        }

        public static boolean isQEmuDriverFile() {
            boolean jad_an = com.jd.android.sdk.coreinfo.jad_an.jad_an();
            com.jd.android.sdk.coreinfo.util.Logger.debugWithStackTrace(com.jd.android.sdk.coreinfo.CoreInfo.TAG, "isQEmuDriverFile() --> ".concat(java.lang.String.valueOf(jad_an)));
            return jad_an;
        }

        /* JADX WARN: Code restructure failed: missing block: B:14:0x0025, code lost:
        
            if (r2.contains("test-keys") == false) goto L15;
         */
        /* JADX WARN: Code restructure failed: missing block: B:15:0x0029, code lost:
        
            r0 = true;
         */
        /* JADX WARN: Code restructure failed: missing block: B:20:0x0027, code lost:
        
            if (r1 != false) goto L16;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public static boolean isRoot() {
            boolean z;
            boolean z2 = false;
            try {
                java.lang.String[] strArr = com.jd.android.sdk.coreinfo.jad_an.jad_gr;
                int length = strArr.length;
                int i = 0;
                while (true) {
                    if (i >= length) {
                        z = false;
                        break;
                    }
                    if (new java.io.File(strArr[i]).exists()) {
                        z = true;
                        break;
                    }
                    i++;
                }
                java.lang.String str = android.os.Build.TAGS;
                if (str != null) {
                }
            } catch (java.lang.Throwable th) {
                th.printStackTrace();
            }
            com.jd.android.sdk.coreinfo.util.Logger.debugWithStackTrace(com.jd.android.sdk.coreinfo.CoreInfo.TAG, "isRoot() --> ".concat(java.lang.String.valueOf(z2)));
            return z2;
        }

        public static boolean isSensorAvailable(android.content.Context context, int i) {
            java.util.List<android.hardware.Sensor> sensorList;
            boolean z = false;
            if (context == null) {
                com.jd.android.sdk.coreinfo.util.Logger.w("Baseinfo.DeviceInfo", com.anythink.expressad.foundation.g.b.b.a);
            } else {
                android.hardware.SensorManager sensorManager = (android.hardware.SensorManager) context.getSystemService(com.umeng.analytics.pro.bo.ac);
                if (sensorManager != null && (sensorList = sensorManager.getSensorList(i)) != null && sensorList.size() > 0) {
                    z = true;
                }
            }
            com.jd.android.sdk.coreinfo.util.Logger.debugWithStackTrace(com.jd.android.sdk.coreinfo.CoreInfo.TAG, "isSensorAvailable() --> ".concat(java.lang.String.valueOf(z)));
            return z;
        }

        public static boolean isStorageRemovable(android.content.Context context) {
            java.util.List<android.os.storage.StorageVolume> storageVolumes;
            boolean isRemovable;
            java.lang.String state;
            boolean z = false;
            if (context == null) {
                com.jd.android.sdk.coreinfo.util.Logger.w("Baseinfo.DeviceInfo", com.anythink.expressad.foundation.g.b.b.a);
            } else {
                try {
                    if (android.os.Build.VERSION.SDK_INT >= 24) {
                        storageVolumes = ((android.os.storage.StorageManager) context.getSystemService("storage")).getStorageVolumes();
                        if (storageVolumes != null) {
                            for (android.os.storage.StorageVolume storageVolume : storageVolumes) {
                                isRemovable = storageVolume.isRemovable();
                                if (isRemovable) {
                                    state = storageVolume.getState();
                                    if (state.equals("mounted")) {
                                        z = true;
                                        break;
                                    }
                                }
                            }
                        }
                    } else {
                        z = com.jd.android.sdk.coreinfo.jad_an.jad_dq(context);
                    }
                } catch (java.lang.Exception e) {
                    com.jd.android.sdk.coreinfo.util.Logger.e("Baseinfo.DeviceInfo", "An exception happends when call storageIsRemovable()", e);
                }
            }
            com.jd.android.sdk.coreinfo.util.Logger.debugWithStackTrace(com.jd.android.sdk.coreinfo.CoreInfo.TAG, "isStorageRemovable() --> ".concat(java.lang.String.valueOf(z)));
            return z;
        }

        public static void setUserAgent(java.lang.String str) {
            if (!android.text.TextUtils.isEmpty(str)) {
                com.jd.ad.sdk.jad_dq.jad_dq.jad_an = str;
            }
            com.jd.ad.sdk.jad_an.jad_an.jad_an(str, "setUserAgent() --> ", com.jd.android.sdk.coreinfo.CoreInfo.TAG);
        }
    }

    public static class System {
        public static int getAndroidSDKVersion() {
            if (com.jd.ad.sdk.jad_an.jad_dq.jad_jt == 0) {
                com.jd.ad.sdk.jad_an.jad_dq.jad_jt = android.os.Build.VERSION.SDK_INT;
            }
            int i = com.jd.ad.sdk.jad_an.jad_dq.jad_jt;
            com.jd.android.sdk.coreinfo.util.Logger.debugWithStackTrace(com.jd.android.sdk.coreinfo.CoreInfo.TAG, "getAndroidSDKVersion() --> ".concat(java.lang.String.valueOf(i)));
            return i;
        }

        public static java.lang.String getAndroidVersion() {
            if (android.text.TextUtils.isEmpty(com.jd.ad.sdk.jad_an.jad_dq.jad_fs)) {
                com.jd.ad.sdk.jad_an.jad_dq.jad_fs = com.jd.ad.sdk.jad_lo.jad_bo.jad_an(android.os.Build.VERSION.RELEASE);
            }
            java.lang.String str = com.jd.ad.sdk.jad_an.jad_dq.jad_fs;
            com.jd.ad.sdk.jad_an.jad_an.jad_an(str, "getAndroidVersion() --> ", com.jd.android.sdk.coreinfo.CoreInfo.TAG);
            return str;
        }

        public static java.lang.String getCountry(android.content.Context context) {
            android.content.res.Resources resources;
            android.content.res.Configuration configuration;
            java.util.Locale locale;
            android.os.LocaleList locales;
            int size;
            try {
                if (android.text.TextUtils.isEmpty(com.jd.ad.sdk.jad_an.jad_dq.jad_iv) && context != null && (resources = context.getResources()) != null && (configuration = resources.getConfiguration()) != null) {
                    if (android.os.Build.VERSION.SDK_INT >= 24) {
                        locales = configuration.getLocales();
                        if (locales != null) {
                            size = locales.size();
                            if (size > 0) {
                                locale = locales.get(0);
                            }
                        }
                    } else {
                        locale = configuration.locale;
                    }
                    com.jd.ad.sdk.jad_an.jad_dq.jad_iv = locale.getCountry();
                }
            } catch (java.lang.Exception unused) {
            }
            java.lang.String str = com.jd.ad.sdk.jad_an.jad_dq.jad_iv;
            com.jd.ad.sdk.jad_an.jad_an.jad_an(str, "getCountry() --> ", com.jd.android.sdk.coreinfo.CoreInfo.TAG);
            return str;
        }

        public static long getElapsedRealtime() {
            long elapsedRealtime = android.os.SystemClock.elapsedRealtime();
            com.jd.android.sdk.coreinfo.util.Logger.debugWithStackTrace(com.jd.android.sdk.coreinfo.CoreInfo.TAG, "getElapsedRealtime() --> ".concat(java.lang.String.valueOf(elapsedRealtime)));
            return elapsedRealtime;
        }

        public static java.util.List<android.content.pm.PackageInfo> getInstalledPkgs(android.content.Context context, int i) {
            com.jd.ad.sdk.jad_lo.jad_er.jad_an();
            com.jd.ad.sdk.jad_an.jad_bo jad_boVar = com.jd.android.sdk.coreinfo.CoreInfo.sensitiveApi;
            java.util.List<android.content.pm.PackageInfo> jad_cp = jad_boVar != null ? jad_boVar.jad_cp(context, i) : new java.util.ArrayList<>();
            com.jd.android.sdk.coreinfo.util.Logger.debugWithStackTrace(com.jd.android.sdk.coreinfo.CoreInfo.TAG, "getInstalledPkgs() --> ".concat(java.lang.String.valueOf(jad_cp)));
            return jad_cp;
        }

        public static java.lang.String getLanguage(android.content.Context context) {
            android.content.res.Resources resources;
            android.content.res.Configuration configuration;
            java.util.Locale locale;
            android.os.LocaleList locales;
            int size;
            try {
                if (android.text.TextUtils.isEmpty(com.jd.ad.sdk.jad_an.jad_dq.jad_jw) && context != null && (resources = context.getResources()) != null && (configuration = resources.getConfiguration()) != null) {
                    if (android.os.Build.VERSION.SDK_INT >= 24) {
                        locales = configuration.getLocales();
                        if (locales != null) {
                            size = locales.size();
                            if (size > 0) {
                                locale = locales.get(0);
                            }
                        }
                    } else {
                        locale = configuration.locale;
                    }
                    com.jd.ad.sdk.jad_an.jad_dq.jad_jw = locale.getLanguage();
                }
            } catch (java.lang.Exception unused) {
            }
            java.lang.String str = com.jd.ad.sdk.jad_an.jad_dq.jad_jw;
            com.jd.ad.sdk.jad_an.jad_an.jad_an(str, "getLanguage() --> ", com.jd.android.sdk.coreinfo.CoreInfo.TAG);
            return str;
        }

        public static java.lang.String getOSFingerprint() {
            if (android.text.TextUtils.isEmpty(com.jd.ad.sdk.jad_an.jad_dq.jad_dq)) {
                com.jd.ad.sdk.jad_an.jad_dq.jad_dq = com.jd.ad.sdk.jad_lo.jad_bo.jad_an(android.os.Build.FINGERPRINT);
            }
            java.lang.String str = com.jd.ad.sdk.jad_an.jad_dq.jad_dq;
            com.jd.ad.sdk.jad_an.jad_an.jad_an(str, "getOSFingerprint() --> ", com.jd.android.sdk.coreinfo.CoreInfo.TAG);
            return str;
        }

        public static java.lang.String getOSName() {
            if (android.text.TextUtils.isEmpty(com.jd.ad.sdk.jad_an.jad_dq.jad_an)) {
                com.jd.ad.sdk.jad_an.jad_dq.jad_an = com.jd.ad.sdk.jad_lo.jad_bo.jad_an(android.os.Build.DISPLAY);
            }
            java.lang.String str = com.jd.ad.sdk.jad_an.jad_dq.jad_an;
            com.jd.ad.sdk.jad_an.jad_an.jad_an(str, "getOSName() --> ", com.jd.android.sdk.coreinfo.CoreInfo.TAG);
            return str;
        }

        public static java.lang.String getOSVersionTags() {
            if (android.text.TextUtils.isEmpty(com.jd.ad.sdk.jad_an.jad_dq.jad_cp)) {
                com.jd.ad.sdk.jad_an.jad_dq.jad_cp = com.jd.ad.sdk.jad_lo.jad_bo.jad_an(android.os.Build.TAGS);
            }
            java.lang.String str = com.jd.ad.sdk.jad_an.jad_dq.jad_cp;
            com.jd.ad.sdk.jad_an.jad_an.jad_an(str, "getOSVersionTags() --> ", com.jd.android.sdk.coreinfo.CoreInfo.TAG);
            return str;
        }

        public static java.lang.String getOSVersionType() {
            if (android.text.TextUtils.isEmpty(com.jd.ad.sdk.jad_an.jad_dq.jad_bo)) {
                com.jd.ad.sdk.jad_an.jad_dq.jad_bo = com.jd.ad.sdk.jad_lo.jad_bo.jad_an(android.os.Build.TYPE);
            }
            java.lang.String str = com.jd.ad.sdk.jad_an.jad_dq.jad_bo;
            com.jd.ad.sdk.jad_an.jad_an.jad_an(str, "getOSVersionType() --> ", com.jd.android.sdk.coreinfo.CoreInfo.TAG);
            return str;
        }

        public static java.lang.String getRomName() {
            java.lang.StringBuilder sb;
            java.lang.String str;
            java.lang.String valueOf;
            java.lang.String str2;
            java.lang.StringBuilder sb2;
            java.lang.StringBuilder sb3;
            java.lang.String str3;
            if (android.text.TextUtils.isEmpty(com.jd.ad.sdk.jad_an.jad_dq.jad_er)) {
                if (android.text.TextUtils.isEmpty(com.jd.ad.sdk.jad_dq.jad_cp.jad_bo)) {
                    java.lang.String jad_an = com.jd.ad.sdk.jad_dq.jad_cp.jad_an(com.igexin.assist.control.xiaomi.XmSystemUtils.KEY_VERSION_MIUI);
                    if (android.text.TextUtils.isEmpty(jad_an) || "".equals(jad_an)) {
                        java.lang.String jad_an2 = com.jd.ad.sdk.jad_dq.jad_cp.jad_an(com.alipay.sdk.m.c.a.a);
                        if (android.text.TextUtils.isEmpty(jad_an2) || "".equals(jad_an2)) {
                            java.lang.String jad_an3 = com.jd.ad.sdk.jad_dq.jad_cp.jad_an("ro.lenovo.series");
                            if (android.text.TextUtils.isEmpty(jad_an3) || "".equals(jad_an3)) {
                                java.lang.String jad_an4 = com.jd.ad.sdk.jad_dq.jad_cp.jad_an("ro.build.nubia.rom.name");
                                if (android.text.TextUtils.isEmpty(jad_an4) || "".equals(jad_an4)) {
                                    java.lang.String jad_an5 = com.jd.ad.sdk.jad_dq.jad_cp.jad_an("ro.meizu.product.model");
                                    if (android.text.TextUtils.isEmpty(jad_an5) || "".equals(jad_an5)) {
                                        java.lang.String jad_an6 = com.jd.ad.sdk.jad_dq.jad_cp.jad_an("ro.build.version.opporom");
                                        if (android.text.TextUtils.isEmpty(jad_an6) || "".equals(jad_an6)) {
                                            java.lang.String jad_an7 = com.jd.ad.sdk.jad_dq.jad_cp.jad_an("ro.vivo.os.build.display.id");
                                            if (android.text.TextUtils.isEmpty(jad_an7) || "".equals(jad_an7)) {
                                                java.lang.String jad_an8 = com.jd.ad.sdk.jad_dq.jad_cp.jad_an("ro.aa.romver");
                                                if (android.text.TextUtils.isEmpty(jad_an8) || "".equals(jad_an8)) {
                                                    java.lang.String jad_an9 = com.jd.ad.sdk.jad_dq.jad_cp.jad_an("ro.lewa.version");
                                                    if (android.text.TextUtils.isEmpty(jad_an9) || "".equals(jad_an9)) {
                                                        jad_an9 = com.jd.ad.sdk.jad_dq.jad_cp.jad_an("ro.gn.gnromvernumber");
                                                        if (android.text.TextUtils.isEmpty(jad_an9) || "".equals(jad_an9)) {
                                                            java.lang.String jad_an10 = com.jd.ad.sdk.jad_dq.jad_cp.jad_an("ro.build.tyd.kbstyle_version");
                                                            if (android.text.TextUtils.isEmpty(jad_an10) || "".equals(jad_an10)) {
                                                                sb = new java.lang.StringBuilder();
                                                                sb.append(com.jd.ad.sdk.jad_dq.jad_cp.jad_an("ro.build.fingerprint"));
                                                                sb.append(net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR);
                                                                str = "ro.build.rom.moduleID";
                                                            } else {
                                                                valueOf = java.lang.String.valueOf(jad_an10);
                                                                str2 = "dido/";
                                                            }
                                                        } else {
                                                            sb2 = new java.lang.StringBuilder("amigo/");
                                                        }
                                                    } else {
                                                        sb2 = new java.lang.StringBuilder("tcl/");
                                                    }
                                                    sb2.append(jad_an9);
                                                    sb2.append(net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR);
                                                    sb = sb2;
                                                } else {
                                                    sb3 = new java.lang.StringBuilder("htc/");
                                                    sb3.append(jad_an8);
                                                    sb3.append(net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR);
                                                    str3 = "ro.build.description";
                                                }
                                            } else {
                                                valueOf = java.lang.String.valueOf(jad_an7);
                                                str2 = "vivo/FUNTOUCH/";
                                            }
                                        } else {
                                            valueOf = java.lang.String.valueOf(jad_an6);
                                            str2 = "Oppo/COLOROS/";
                                        }
                                    } else {
                                        sb = new java.lang.StringBuilder("Meizu/FLYME/");
                                    }
                                    str = "ro.build.display.id";
                                } else {
                                    sb3 = new java.lang.StringBuilder("Zte/NUBIA/");
                                    sb3.append(jad_an4);
                                    sb3.append("_");
                                    str3 = "ro.build.nubia.rom.code";
                                }
                                java.lang.StringBuilder sb4 = sb3;
                                str = str3;
                                sb = sb4;
                            } else {
                                sb = new java.lang.StringBuilder("Lenovo/VIBE/");
                                str = "ro.build.version.incremental";
                            }
                            sb.append(com.jd.ad.sdk.jad_dq.jad_cp.jad_an(str));
                            com.jd.ad.sdk.jad_dq.jad_cp.jad_bo = sb.toString();
                        } else {
                            valueOf = java.lang.String.valueOf(jad_an2);
                            str2 = "HuaWei/EMOTION/";
                        }
                    } else {
                        valueOf = java.lang.String.valueOf(jad_an);
                        str2 = "XiaoMi/MIUI/";
                    }
                    com.jd.ad.sdk.jad_dq.jad_cp.jad_bo = str2.concat(valueOf);
                }
                com.jd.ad.sdk.jad_an.jad_dq.jad_er = com.jd.ad.sdk.jad_lo.jad_bo.jad_an(com.jd.ad.sdk.jad_dq.jad_cp.jad_bo);
            }
            java.lang.String str4 = com.jd.ad.sdk.jad_an.jad_dq.jad_er;
            com.jd.ad.sdk.jad_an.jad_an.jad_an(str4, "getRomName() --> ", com.jd.android.sdk.coreinfo.CoreInfo.TAG);
            return str4;
        }

        public static java.lang.String getTimeZoneID() {
            java.util.TimeZone timeZone;
            try {
                if (android.text.TextUtils.isEmpty(com.jd.ad.sdk.jad_an.jad_dq.jad_hu) && (timeZone = java.util.TimeZone.getDefault()) != null) {
                    com.jd.ad.sdk.jad_an.jad_dq.jad_hu = timeZone.getID();
                }
            } catch (java.lang.Throwable unused) {
            }
            java.lang.String str = com.jd.ad.sdk.jad_an.jad_dq.jad_hu;
            com.jd.ad.sdk.jad_an.jad_an.jad_an(str, "getTimeZoneID() --> ", com.jd.android.sdk.coreinfo.CoreInfo.TAG);
            return str;
        }

        /* JADX WARN: Removed duplicated region for block: B:8:0x001d  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public static boolean isPkgInstalled(android.content.Context context, java.lang.String str) {
            android.content.pm.PackageInfo packageInfo;
            com.jd.ad.sdk.jad_lo.jad_er.jad_an();
            boolean z = false;
            if (context == null || android.text.TextUtils.isEmpty(str)) {
                com.jd.android.sdk.coreinfo.util.Logger.e("PackageInfoUtil", "isPackageInstalled parameter error!");
            } else {
                try {
                    packageInfo = context.getPackageManager().getPackageInfo(str, 0);
                } catch (android.content.pm.PackageManager.NameNotFoundException unused) {
                    packageInfo = null;
                    if (packageInfo != null) {
                    }
                    com.jd.android.sdk.coreinfo.util.Logger.debugWithStackTrace(com.jd.android.sdk.coreinfo.CoreInfo.TAG, "isPkgInstalled() --> ".concat(java.lang.String.valueOf(z)));
                    return z;
                } catch (java.lang.Throwable th) {
                    th.printStackTrace();
                    packageInfo = null;
                    if (packageInfo != null) {
                    }
                    com.jd.android.sdk.coreinfo.util.Logger.debugWithStackTrace(com.jd.android.sdk.coreinfo.CoreInfo.TAG, "isPkgInstalled() --> ".concat(java.lang.String.valueOf(z)));
                    return z;
                }
                if (packageInfo != null) {
                    z = true;
                }
            }
            com.jd.android.sdk.coreinfo.util.Logger.debugWithStackTrace(com.jd.android.sdk.coreinfo.CoreInfo.TAG, "isPkgInstalled() --> ".concat(java.lang.String.valueOf(z)));
            return z;
        }
    }
}
