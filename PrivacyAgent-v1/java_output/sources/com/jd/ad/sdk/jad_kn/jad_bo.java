package com.jd.ad.sdk.jad_kn;

/* loaded from: classes23.dex */
public class jad_bo {
    public static long jad_an;
    public static java.lang.String[] jad_bo = {"/data/app/com.bluestacks.appmart-1.apk", "/data/app/com.bluestacks.BstCommandProcessor-1.apk", "/data/app/com.bluestacks.help-1.apk", "/data/app/com.bluestacks.home-1.apk", "/data/app/com.bluestacks.s2p-1.apk", "/data/app/com.bluestacks.searchapp-1.apk", "/data/bluestacks.prop", "/data/data/com.androVM.vmconfig", "/data/data/com.bluestacks.accelerometerui", "/data/data/com.bluestacks.appfinder", "/data/data/com.bluestacks.appmart", "/data/data/com.bluestacks.appsettings", "/data/data/com.bluestacks.BstCommandProcessor", "/data/data/com.bluestacks.bstfolder", "/data/data/com.bluestacks.help", "/data/data/com.bluestacks.home", "/data/data/com.bluestacks.s2p", "/data/data/com.bluestacks.searchapp", "/data/data/com.bluestacks.settings", "/data/data/com.bluestacks.setup", "/data/data/com.bluestacks.spotlight", "/mnt/prebundledapps/bluestacks.prop.orig"};

    public static java.lang.String jad_an(java.lang.String str) {
        java.lang.String str2;
        int i = com.jd.ad.sdk.jad_jm.jad_cp.jad_an;
        try {
            java.lang.Class<?> loadClass = java.lang.ClassLoader.getSystemClassLoader().loadClass("android.os.SystemProperties");
            java.lang.reflect.Method method = loadClass.getMethod(com.ss.android.socialbase.downloader.constants.MonitorConstants.CONNECT_TYPE_GET, java.lang.String.class);
            method.setAccessible(true);
            str2 = (java.lang.String) method.invoke(loadClass, str);
        } catch (java.lang.Exception unused) {
            str2 = "";
        }
        if (android.text.TextUtils.isEmpty(str2)) {
            return null;
        }
        return str2;
    }

    public static boolean jad_an() {
        java.lang.String str = android.os.Build.PRODUCT;
        if (str.contains("sdk") || str.contains("sdk_x86") || str.contains("sdk_google") || str.contains("Andy") || str.contains("Droid4X") || str.contains("nox") || str.contains("vbox86p") || str.contains("aries")) {
            return true;
        }
        java.lang.String str2 = android.os.Build.MANUFACTURER;
        if (str2.equals("Genymotion") || str2.contains("Andy") || str2.contains("nox") || str2.contains("TiantianVM") || android.os.Build.BRAND.contains("Andy")) {
            return true;
        }
        java.lang.String str3 = android.os.Build.DEVICE;
        if (str3.contains("Andy") || str3.contains("Droid4X") || str3.contains("nox") || str3.contains("vbox86p") || str3.contains("aries")) {
            return true;
        }
        java.lang.String str4 = android.os.Build.MODEL;
        if (str4.contains("Emulator") || str4.equals("google_sdk") || str4.contains("Droid4X") || str4.contains("TiantianVM") || str4.contains("Andy") || str4.equals("Android SDK built for x86_64") || str4.equals("Android SDK built for x86")) {
            return true;
        }
        java.lang.String str5 = android.os.Build.HARDWARE;
        if (str5.equals("vbox86") || str5.contains("nox") || str5.contains("ttVM_x86")) {
            return true;
        }
        java.lang.String str6 = android.os.Build.FINGERPRINT;
        return str6.contains("generic/sdk/generic") || str6.contains("generic_x86/sdk_x86/generic_x86") || str6.contains("Andy") || str6.contains("ttVM_Hdragon") || str6.contains("generic/google_sdk/generic") || str6.contains("vbox86p") || str6.contains("generic/vbox86p/vbox86p");
    }

    public static java.lang.String jad_bo() {
        try {
            java.lang.Process start = new java.lang.ProcessBuilder("/system/bin/cat", "/proc/cpuinfo").start();
            java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
            java.io.BufferedReader bufferedReader = new java.io.BufferedReader(new java.io.InputStreamReader(start.getInputStream(), "utf-8"));
            while (true) {
                java.lang.String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    bufferedReader.close();
                    return stringBuffer.toString().toLowerCase();
                }
                stringBuffer.append(readLine);
            }
        } catch (java.io.IOException unused) {
            return "";
        }
    }
}
