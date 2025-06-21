package com.anythink.china.b;

/* loaded from: classes12.dex */
public final class b {
    private static final java.lang.String[] a = {"/su", "/su/bin/su", "/sbin/su", "/data/local/xbin/su", "/data/local/bin/su", "/data/local/su", "/system/xbin/su", "/system/bin/su", "/system/sd/xbin/su", "/system/bin/failsafe/su", "/system/bin/cufsdosck", "/system/xbin/cufsdosck", "/system/bin/cufsmgr", "/system/xbin/cufsmgr", "/system/bin/cufaevdd", "/system/xbin/cufaevdd", "/system/bin/conbb", "/system/xbin/conbb"};

    public static java.lang.String a() {
        try {
            java.lang.String[] strArr = a;
            int length = strArr.length;
            boolean z = false;
            int i = 0;
            while (true) {
                if (i >= length) {
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
                if (str.contains("test-keys")) {
                    return "1";
                }
            }
            return z ? "1" : "2";
        } catch (java.lang.Throwable unused) {
            return "";
        }
    }

    public static java.lang.String a(android.content.Context context) {
        try {
            java.lang.String property = java.lang.System.getProperty(org.apache.tools.ant.util.ProxySetup.HTTP_PROXY_HOST);
            java.lang.String property2 = java.lang.System.getProperty(org.apache.tools.ant.util.ProxySetup.HTTP_PROXY_PORT);
            if (property2 == null) {
                property2 = "-1";
            }
            return (android.text.TextUtils.isEmpty(property) || java.lang.Integer.parseInt(property2) == -1) ? "2" : "1";
        } catch (java.lang.Throwable unused) {
            return "";
        }
    }

    public static java.lang.String b() {
        try {
            java.lang.String str = android.os.Build.CPU_ABI;
            java.lang.String str2 = android.os.Build.CPU_ABI2;
            if (android.text.TextUtils.isEmpty(str2)) {
                return str;
            }
            return str + "|" + str2;
        } catch (java.lang.Throwable unused) {
            return "";
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0047 A[Catch: all -> 0x0052, TryCatch #0 {all -> 0x0052, blocks: (B:3:0x0002, B:5:0x0008, B:7:0x0030, B:15:0x0047, B:20:0x004d), top: B:2:0x0002 }] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x004c A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static java.lang.String b(android.content.Context context) {
        boolean z;
        try {
            if (android.os.Build.VERSION.SDK_INT < 28) {
                return e(context);
            }
            boolean isProviderEnabled = ((android.location.LocationManager) context.getApplicationContext().getSystemService(com.alibaba.sdk.android.oss.common.RequestParameters.SUBRESOURCE_LOCATION)).isProviderEnabled(com.amap.api.services.geocoder.GeocodeSearch.GPS);
            android.content.pm.PackageManager packageManager = context.getApplicationContext().getPackageManager();
            boolean z2 = false;
            if (packageManager.checkPermission("android.permission.ACCESS_FINE_LOCATION", context.getPackageName()) != 0 && packageManager.checkPermission("android.permission.ACCESS_COARSE_LOCATION", context.getPackageName()) != 0) {
                z = false;
                if (isProviderEnabled && z) {
                    z2 = true;
                }
                return !z2 ? e(context) : "";
            }
            z = true;
            if (isProviderEnabled) {
                z2 = true;
            }
            if (!z2) {
            }
        } catch (java.lang.Throwable unused) {
            return "";
        }
    }

    public static java.lang.String c() {
        java.io.BufferedReader bufferedReader;
        java.io.FileReader fileReader = null;
        try {
            java.io.File file = new java.io.File("/proc/sys/kernel/random/boot_id");
            if (file.exists()) {
                java.io.FileReader fileReader2 = new java.io.FileReader(file);
                try {
                    bufferedReader = new java.io.BufferedReader(fileReader2);
                    java.lang.String str = "";
                    while (true) {
                        try {
                            java.lang.String readLine = bufferedReader.readLine();
                            if (readLine != null) {
                                str = str + readLine;
                            } else {
                                try {
                                    break;
                                } catch (java.lang.Throwable unused) {
                                }
                            }
                        } catch (java.lang.Throwable unused2) {
                            fileReader = fileReader2;
                            if (fileReader != null) {
                                try {
                                    fileReader.close();
                                } catch (java.lang.Throwable unused3) {
                                }
                            }
                            if (bufferedReader != null) {
                                try {
                                    bufferedReader.close();
                                } catch (java.lang.Throwable unused4) {
                                }
                            }
                            return "";
                        }
                    }
                    fileReader2.close();
                    try {
                        bufferedReader.close();
                    } catch (java.lang.Throwable unused5) {
                    }
                    return str;
                } catch (java.lang.Throwable unused6) {
                    bufferedReader = null;
                }
            }
        } catch (java.lang.Throwable unused7) {
            bufferedReader = null;
        }
        return "";
    }

    public static java.lang.String[] c(android.content.Context context) {
        try {
            android.content.pm.PackageInfo packageInfo = context.getApplicationContext().getPackageManager().getPackageInfo(context.getPackageName(), 0);
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append(packageInfo.firstInstallTime);
            java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
            sb2.append(packageInfo.lastUpdateTime);
            return new java.lang.String[]{sb.toString(), sb2.toString()};
        } catch (java.lang.Throwable unused) {
            return null;
        }
    }

    public static java.lang.String d() {
        try {
            java.io.File file = new java.io.File("/data/data");
            if (!file.exists()) {
                return "";
            }
            return (file.lastModified() / 1000) + ".000000000";
        } catch (java.lang.Throwable unused) {
            return "";
        }
    }

    private static boolean d(android.content.Context context) {
        boolean isProviderEnabled = ((android.location.LocationManager) context.getApplicationContext().getSystemService(com.alibaba.sdk.android.oss.common.RequestParameters.SUBRESOURCE_LOCATION)).isProviderEnabled(com.amap.api.services.geocoder.GeocodeSearch.GPS);
        android.content.pm.PackageManager packageManager = context.getApplicationContext().getPackageManager();
        return isProviderEnabled && (packageManager.checkPermission("android.permission.ACCESS_FINE_LOCATION", context.getPackageName()) == 0 || packageManager.checkPermission("android.permission.ACCESS_COARSE_LOCATION", context.getPackageName()) == 0);
    }

    @android.annotation.SuppressLint({"MissingPermission"})
    private static java.lang.String e(android.content.Context context) {
        try {
            android.net.wifi.WifiInfo connectionInfo = ((android.net.wifi.WifiManager) context.getApplicationContext().getSystemService(com.efs.sdk.base.core.util.NetworkUtil.NETWORK_TYPE_WIFI)).getConnectionInfo();
            java.lang.String ssid = connectionInfo == null ? "" : connectionInfo.getSSID();
            if ("<unknown ssid>".equalsIgnoreCase(ssid)) {
                ssid = ((android.net.ConnectivityManager) context.getApplicationContext().getSystemService("connectivity")).getActiveNetworkInfo().getExtraInfo();
            }
            return "<unknown ssid>".equalsIgnoreCase(ssid) ? "" : ssid;
        } catch (java.lang.Throwable unused) {
            return "";
        }
    }
}
