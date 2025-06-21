package com.huawei.hms.opendevice;

/* loaded from: classes22.dex */
public abstract class p {
    public static java.lang.String a;

    public static java.lang.String a() {
        try {
            java.io.FileInputStream fileInputStream = new java.io.FileInputStream("/proc/self/cmdline");
            try {
                java.io.InputStreamReader inputStreamReader = new java.io.InputStreamReader(fileInputStream, java.nio.charset.StandardCharsets.UTF_8);
                try {
                    java.io.BufferedReader bufferedReader = new java.io.BufferedReader(inputStreamReader);
                    try {
                        java.lang.String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            bufferedReader.close();
                            inputStreamReader.close();
                            fileInputStream.close();
                            return "";
                        }
                        java.lang.String trim = readLine.trim();
                        bufferedReader.close();
                        inputStreamReader.close();
                        fileInputStream.close();
                        return trim;
                    } finally {
                    }
                } finally {
                }
            } catch (java.lang.Throwable th) {
                try {
                    throw th;
                } catch (java.lang.Throwable th2) {
                    try {
                        fileInputStream.close();
                    } catch (java.lang.Throwable th3) {
                        th.addSuppressed(th3);
                    }
                    throw th2;
                }
            }
        } catch (java.io.IOException unused) {
            com.huawei.hms.support.log.HMSLog.e("CommFun", "get current app processes IOException!");
            return "";
        } catch (java.lang.Exception e) {
            com.huawei.hms.support.log.HMSLog.e("CommFun", "get current app processes exception!" + e.getMessage());
            return "";
        }
    }

    public static java.lang.String a(android.content.Context context) {
        if (!android.text.TextUtils.isEmpty(a)) {
            return a;
        }
        java.lang.String b = b(context);
        a = b;
        if (!android.text.TextUtils.isEmpty(b)) {
            return a;
        }
        java.lang.String a2 = a();
        a = a2;
        return a2;
    }

    public static java.lang.String b(android.content.Context context) {
        android.app.ActivityManager activityManager = (android.app.ActivityManager) context.getSystemService("activity");
        if (activityManager == null) {
            return "";
        }
        java.util.List<android.app.ActivityManager.RunningAppProcessInfo> runningAppProcesses = activityManager.getRunningAppProcesses();
        if (runningAppProcesses == null || runningAppProcesses.size() == 0) {
            com.huawei.hms.support.log.HMSLog.w("CommFun", "get running app processes null!");
            return "";
        }
        int myPid = android.os.Process.myPid();
        for (android.app.ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
            if (runningAppProcessInfo.pid == myPid && runningAppProcessInfo.processName != null) {
                com.huawei.hms.support.log.HMSLog.i("CommFun", "info.pid -> " + runningAppProcessInfo.pid + ", info.processName -> " + runningAppProcessInfo.processName);
                return runningAppProcessInfo.processName;
            }
        }
        return "";
    }

    public static boolean b() {
        int i = com.huawei.hms.android.HwBuildEx.VERSION.EMUI_SDK_INT;
        com.huawei.hms.support.log.HMSLog.d("CommFun", "Emui Api Level:" + i);
        return i > 0;
    }

    public static java.lang.String c(android.content.Context context) {
        java.lang.String parent;
        android.content.Context createDeviceProtectedStorageContext;
        java.io.File dataDir;
        if (android.os.Build.VERSION.SDK_INT >= 24) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            createDeviceProtectedStorageContext = context.createDeviceProtectedStorageContext();
            dataDir = createDeviceProtectedStorageContext.getDataDir();
            sb.append(dataDir);
            sb.append("");
            parent = sb.toString();
        } else {
            parent = context.getFilesDir().getParent();
        }
        if (android.text.TextUtils.isEmpty(parent)) {
            com.huawei.hms.support.log.HMSLog.e("CommFun", "get storage root path of the current user failed.");
        }
        return parent;
    }

    public static long d(android.content.Context context) {
        try {
            return context.getPackageManager().getPackageInfo("com.huawei.android.pushagent", 16384).versionCode;
        } catch (java.lang.Exception unused) {
            com.huawei.hms.support.log.HMSLog.e("CommFun", "get nc versionCode error");
            return -1L;
        }
    }

    public static boolean e(android.content.Context context) {
        return b() && com.huawei.hms.android.HwBuildEx.VERSION.EMUI_SDK_INT < 21 && d(context) < 110001400;
    }
}
