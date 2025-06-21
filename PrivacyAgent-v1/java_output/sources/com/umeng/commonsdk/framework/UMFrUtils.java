package com.umeng.commonsdk.framework;

/* loaded from: classes19.dex */
public class UMFrUtils {
    private static final java.lang.String KEY_LAST_INSTANT_SUCC_BUILD_TIME = "last_instant_build_time";
    private static final java.lang.String KEY_LAST_SUCC_BUILD_TIME = "last_successful_build_time";
    private static java.lang.Object mEnvelopeBuildTimeLock = new java.lang.Object();
    private static java.lang.String mDefaultEnvelopeDir = com.umeng.analytics.pro.ay.b().b(com.umeng.analytics.pro.ay.a);
    private static java.lang.String mDefaultEnvelopeDirPath = null;
    private static java.lang.Object mEnvelopeFileLock = new java.lang.Object();
    private static java.lang.String sCurrentProcessName = "";

    /* renamed from: com.umeng.commonsdk.framework.UMFrUtils$1, reason: invalid class name */
    public static class AnonymousClass1 implements java.util.Comparator<java.io.File> {
        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(java.io.File file, java.io.File file2) {
            long lastModified = file.lastModified() - file2.lastModified();
            if (lastModified > 0) {
                return 1;
            }
            return lastModified == 0 ? 0 : -1;
        }
    }

    /* renamed from: com.umeng.commonsdk.framework.UMFrUtils$2, reason: invalid class name */
    public static class AnonymousClass2 implements java.util.Comparator<java.io.File> {
        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(java.io.File file, java.io.File file2) {
            long lastModified = file.lastModified() - file2.lastModified();
            if (lastModified > 0) {
                return 1;
            }
            return lastModified == 0 ? 0 : -1;
        }
    }

    private static boolean checkPermission(android.content.Context context, java.lang.String str) {
        if (context == null) {
            return false;
        }
        android.content.Context applicationContext = context.getApplicationContext();
        if (android.os.Build.VERSION.SDK_INT >= 23) {
            try {
                if (((java.lang.Integer) java.lang.Class.forName("android.content.Context").getMethod("checkSelfPermission", java.lang.String.class).invoke(context, str)).intValue() != 0) {
                    return false;
                }
            } catch (java.lang.Throwable th) {
                com.umeng.commonsdk.internal.crash.UMCrashManager.reportCrash(applicationContext, th);
                return false;
            }
        } else {
            try {
                if (applicationContext.getPackageManager().checkPermission(str, applicationContext.getPackageName()) != 0) {
                    return false;
                }
            } catch (java.lang.Throwable th2) {
                com.umeng.commonsdk.internal.crash.UMCrashManager.reportCrash(applicationContext, th2);
                return false;
            }
        }
        return true;
    }

    public static int envelopeFileNumber(android.content.Context context) {
        java.lang.String[] list;
        if (context != null) {
            try {
                java.io.File file = new java.io.File(getEnvelopeDirPath(context));
                synchronized (mEnvelopeFileLock) {
                    if (file.isDirectory() && (list = file.list()) != null) {
                        return list.length;
                    }
                }
            } catch (java.lang.Throwable th) {
                com.umeng.commonsdk.internal.crash.UMCrashManager.reportCrash(context, th);
            }
        }
        return 0;
    }

    public static java.lang.String getCurrentProcessName(android.content.Context context) {
        java.util.List<android.app.ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        if (android.text.TextUtils.isEmpty(sCurrentProcessName)) {
            try {
                java.lang.String processName = android.os.Build.VERSION.SDK_INT >= 28 ? android.app.Application.getProcessName() : "";
                if (android.text.TextUtils.isEmpty(processName)) {
                    int myPid = android.os.Process.myPid();
                    java.lang.String processName2 = getProcessName(myPid);
                    if (android.text.TextUtils.isEmpty(processName2)) {
                        android.app.ActivityManager activityManager = (android.app.ActivityManager) context.getSystemService("activity");
                        if (activityManager != null && (runningAppProcesses = activityManager.getRunningAppProcesses()) != null && runningAppProcesses.size() > 0) {
                            java.util.Iterator<android.app.ActivityManager.RunningAppProcessInfo> it = runningAppProcesses.iterator();
                            while (true) {
                                if (!it.hasNext()) {
                                    break;
                                }
                                android.app.ActivityManager.RunningAppProcessInfo next = it.next();
                                if (next.pid == myPid) {
                                    sCurrentProcessName = next.processName;
                                    break;
                                }
                            }
                        }
                    } else {
                        sCurrentProcessName = processName2;
                    }
                } else {
                    sCurrentProcessName = processName;
                }
            } catch (java.lang.Throwable th) {
                com.umeng.commonsdk.internal.crash.UMCrashManager.reportCrash(context.getApplicationContext(), th);
            }
        }
        return sCurrentProcessName;
    }

    private static long getDistanceDays(long j, long j2) {
        return (j < j2 ? j2 - j : j - j2) / 86400000;
    }

    public static java.lang.String getEnvelopeDirPath(android.content.Context context) {
        synchronized (mEnvelopeFileLock) {
            try {
                if (mDefaultEnvelopeDirPath == null) {
                    mDefaultEnvelopeDirPath = context.getFilesDir().getAbsolutePath() + java.io.File.separator + "." + mDefaultEnvelopeDir;
                }
                java.io.File file = new java.io.File(mDefaultEnvelopeDirPath);
                if (!file.exists() && !file.mkdir()) {
                    com.umeng.commonsdk.statistics.common.ULog.d("--->>> Create Envelope Directory failed!!!");
                }
            } finally {
                return mDefaultEnvelopeDirPath;
            }
        }
        return mDefaultEnvelopeDirPath;
    }

    public static java.io.File getEnvelopeFile(android.content.Context context) {
        if (context == null) {
            return null;
        }
        java.io.File file = new java.io.File(getEnvelopeDirPath(context));
        synchronized (mEnvelopeFileLock) {
            java.io.File[] listFiles = file.listFiles();
            if (listFiles != null && listFiles.length != 0) {
                java.util.Arrays.sort(listFiles, new com.umeng.commonsdk.framework.UMFrUtils.AnonymousClass2());
                return listFiles[0];
            }
            return null;
        }
    }

    public static long getLastInstantBuildTime(android.content.Context context) {
        long j;
        synchronized (mEnvelopeBuildTimeLock) {
            j = com.umeng.commonsdk.statistics.internal.PreferenceWrapper.getDefault(context).getLong(KEY_LAST_INSTANT_SUCC_BUILD_TIME, 0L);
        }
        return j;
    }

    public static long getLastSuccessfulBuildTime(android.content.Context context) {
        long j;
        synchronized (mEnvelopeBuildTimeLock) {
            j = com.umeng.commonsdk.statistics.internal.PreferenceWrapper.getDefault(context).getLong(KEY_LAST_SUCC_BUILD_TIME, 0L);
        }
        return j;
    }

    public static java.lang.String getLegacyEnvelopeDir(android.content.Context context) {
        try {
            java.lang.String currentProcessName = getCurrentProcessName(context);
            if (!android.text.TextUtils.isEmpty(currentProcessName)) {
                java.lang.String b = com.umeng.analytics.pro.ay.b().b(com.umeng.analytics.pro.ay.B);
                java.lang.String replace = currentProcessName.replace(':', '_');
                com.umeng.commonsdk.statistics.common.ULog.d("--->>> getEnvelopeDir: use current process name as envelope directory.");
                return b + replace;
            }
        } catch (java.lang.Throwable th) {
            com.umeng.commonsdk.internal.crash.UMCrashManager.reportCrash(context, th);
        }
        return mDefaultEnvelopeDir;
    }

    private static java.lang.String getProcessName(int i) {
        java.io.BufferedReader bufferedReader;
        try {
            bufferedReader = new java.io.BufferedReader(new java.io.FileReader("/proc/" + i + "/cmdline"));
        } catch (java.lang.Throwable unused) {
            bufferedReader = null;
        }
        try {
            java.lang.String readLine = bufferedReader.readLine();
            if (!android.text.TextUtils.isEmpty(readLine)) {
                readLine = readLine.trim();
            }
            try {
                bufferedReader.close();
            } catch (java.lang.Throwable unused2) {
            }
            return readLine;
        } catch (java.lang.Throwable unused3) {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (java.lang.Throwable unused4) {
                }
            }
            return null;
        }
    }

    public static java.lang.String getSubProcessName(android.content.Context context) {
        java.lang.String str;
        str = "";
        try {
            java.lang.String currentProcessName = getCurrentProcessName(context);
            int indexOf = currentProcessName.indexOf(com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR);
            str = indexOf >= 0 ? currentProcessName.substring(indexOf + 1) : "";
            if (indexOf < 0) {
                java.lang.String packageName = context.getPackageName();
                return currentProcessName.length() > packageName.length() ? currentProcessName.substring(packageName.length() + 1, currentProcessName.length()) : currentProcessName;
            }
        } catch (java.lang.Throwable th) {
            com.umeng.commonsdk.internal.crash.UMCrashManager.reportCrash(context.getApplicationContext(), th);
        }
        return str;
    }

    public static boolean hasEnvelopeFile(android.content.Context context, com.umeng.commonsdk.framework.UMLogDataProtocol.UMBusinessType uMBusinessType) {
        java.io.File[] listFiles;
        java.lang.String str = uMBusinessType == com.umeng.commonsdk.framework.UMLogDataProtocol.UMBusinessType.U_INTERNAL ? "i" : "a";
        if (uMBusinessType == com.umeng.commonsdk.framework.UMLogDataProtocol.UMBusinessType.U_ZeroEnv) {
            str = com.umeng.analytics.pro.bo.aJ;
        }
        if (uMBusinessType == com.umeng.commonsdk.framework.UMLogDataProtocol.UMBusinessType.U_Silent) {
            str = "h";
        }
        java.lang.String envelopeDirPath = getEnvelopeDirPath(context);
        if (envelopeDirPath == null) {
            return false;
        }
        java.io.File file = new java.io.File(envelopeDirPath);
        synchronized (mEnvelopeFileLock) {
            try {
                listFiles = file.listFiles();
            } catch (java.lang.Throwable th) {
                com.umeng.commonsdk.internal.crash.UMCrashManager.reportCrash(context, th);
            }
            if (listFiles != null && listFiles.length != 0) {
                for (java.io.File file2 : listFiles) {
                    if (file2.getName().startsWith(str)) {
                        return true;
                    }
                }
                return false;
            }
            return false;
        }
    }

    public static boolean isOnline(android.content.Context context) {
        android.net.ConnectivityManager connectivityManager;
        android.net.NetworkInfo activeNetworkInfo;
        try {
            if (!checkPermission(context, "android.permission.ACCESS_NETWORK_STATE") || (connectivityManager = (android.net.ConnectivityManager) context.getSystemService("connectivity")) == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null) {
                return false;
            }
            return activeNetworkInfo.isConnectedOrConnecting();
        } catch (java.lang.Throwable th) {
            com.umeng.commonsdk.internal.crash.UMCrashManager.reportCrash(context.getApplicationContext(), th);
            return false;
        }
    }

    public static boolean removeEnvelopeFile(java.io.File file) {
        android.content.Context appContext = com.umeng.commonsdk.framework.UMModuleRegister.getAppContext();
        synchronized (mEnvelopeFileLock) {
            if (file != null) {
                try {
                    if (file.exists()) {
                        return file.delete();
                    }
                } catch (java.lang.Throwable th) {
                    com.umeng.commonsdk.internal.crash.UMCrashManager.reportCrash(appContext, th);
                }
            }
            return true;
        }
    }

    public static void removeRedundantEnvelopeFiles(android.content.Context context, int i) {
        java.io.File file = new java.io.File(getEnvelopeDirPath(context));
        synchronized (mEnvelopeFileLock) {
            java.io.File[] listFiles = file.listFiles();
            if (listFiles != null && listFiles.length > i) {
                java.util.Arrays.sort(listFiles, new com.umeng.commonsdk.framework.UMFrUtils.AnonymousClass1());
                if (listFiles.length > i) {
                    for (int i2 = 0; i2 < listFiles.length - i; i2++) {
                        try {
                            if (!listFiles[i2].delete()) {
                                com.umeng.commonsdk.statistics.common.ULog.d("--->>> remove [" + i2 + "] file fail.");
                            }
                        } catch (java.lang.Throwable th) {
                            com.umeng.commonsdk.internal.crash.UMCrashManager.reportCrash(context, th);
                        }
                    }
                }
            }
        }
    }

    public static int saveEnvelopeFile(android.content.Context context, java.lang.String str, byte[] bArr) {
        java.io.FileOutputStream fileOutputStream;
        if (bArr == null) {
            return 101;
        }
        java.io.File file = new java.io.File(getEnvelopeDirPath(context) + java.io.File.separator + str);
        synchronized (mEnvelopeFileLock) {
            java.io.FileOutputStream fileOutputStream2 = null;
            try {
                try {
                    fileOutputStream = new java.io.FileOutputStream(file);
                } catch (java.io.IOException e) {
                    e = e;
                }
            } catch (java.lang.Throwable th) {
                th = th;
            }
            try {
                fileOutputStream.write(bArr);
                fileOutputStream.close();
                boolean a = com.umeng.commonsdk.statistics.internal.a.a(context).a(str);
                boolean b = com.umeng.commonsdk.statistics.internal.a.a(context).b(str);
                if (a) {
                    updateLastSuccessfulBuildTime(context);
                }
                if (b) {
                    updateLastInstantBuildTime(context);
                }
                return 0;
            } catch (java.io.IOException e2) {
                e = e2;
                fileOutputStream2 = fileOutputStream;
                com.umeng.commonsdk.internal.crash.UMCrashManager.reportCrash(context, e);
                if (fileOutputStream2 != null) {
                    try {
                        fileOutputStream2.close();
                    } catch (java.lang.Throwable th2) {
                        com.umeng.commonsdk.internal.crash.UMCrashManager.reportCrash(context, th2);
                    }
                }
                return 101;
            } catch (java.lang.Throwable th3) {
                th = th3;
                fileOutputStream2 = fileOutputStream;
                if (fileOutputStream2 != null) {
                    try {
                        fileOutputStream2.close();
                    } catch (java.lang.Throwable th4) {
                        com.umeng.commonsdk.internal.crash.UMCrashManager.reportCrash(context, th4);
                    }
                }
                throw th;
            }
        }
    }

    public static void syncLegacyEnvelopeIfNeeded(android.content.Context context) {
        java.lang.String legacyEnvelopeDir;
        if (context == null) {
            return;
        }
        try {
            legacyEnvelopeDir = getLegacyEnvelopeDir(context);
        } catch (java.lang.Throwable th) {
            com.umeng.commonsdk.internal.crash.UMCrashManager.reportCrash(context, th);
        }
        if (android.text.TextUtils.isEmpty(legacyEnvelopeDir) || legacyEnvelopeDir.equals(mDefaultEnvelopeDir)) {
            return;
        }
        java.io.File file = new java.io.File(context.getFilesDir().getAbsolutePath() + "/." + legacyEnvelopeDir);
        if (file.exists()) {
            java.io.File[] listFiles = file.listFiles();
            if (listFiles == null || listFiles.length == 0) {
                try {
                    if (file.isDirectory()) {
                        file.delete();
                        return;
                    }
                    return;
                } catch (java.lang.Throwable th2) {
                    com.umeng.commonsdk.internal.crash.UMCrashManager.reportCrash(context, th2);
                    return;
                }
            }
            try {
                java.lang.String envelopeDirPath = getEnvelopeDirPath(context);
                for (int i = 0; i < listFiles.length; i++) {
                    listFiles[i].renameTo(new java.io.File(envelopeDirPath + java.io.File.separator + listFiles[i].getName()));
                }
                if (file.isDirectory()) {
                    file.delete();
                    return;
                }
                return;
            } catch (java.lang.Throwable th3) {
                com.umeng.commonsdk.internal.crash.UMCrashManager.reportCrash(context, th3);
                return;
            }
            com.umeng.commonsdk.internal.crash.UMCrashManager.reportCrash(context, th);
        }
    }

    public static byte[] toByteArray(java.lang.String str) throws java.io.IOException {
        byte[] bArr;
        android.content.Context appContext = com.umeng.commonsdk.framework.UMModuleRegister.getAppContext();
        synchronized (mEnvelopeFileLock) {
            java.nio.channels.FileChannel fileChannel = null;
            try {
                try {
                    fileChannel = new java.io.RandomAccessFile(str, "r").getChannel();
                    java.nio.MappedByteBuffer load = fileChannel.map(java.nio.channels.FileChannel.MapMode.READ_ONLY, 0L, fileChannel.size()).load();
                    bArr = new byte[(int) fileChannel.size()];
                    if (load.remaining() > 0) {
                        load.get(bArr, 0, load.remaining());
                    }
                } catch (java.io.IOException e) {
                    com.umeng.commonsdk.internal.crash.UMCrashManager.reportCrash(appContext, e);
                    throw e;
                }
            } finally {
                try {
                    fileChannel.close();
                } catch (java.lang.Throwable th) {
                    com.umeng.commonsdk.internal.crash.UMCrashManager.reportCrash(appContext, th);
                }
            }
        }
        return bArr;
    }

    private static void updateLastInstantBuildTime(android.content.Context context) {
        synchronized (mEnvelopeBuildTimeLock) {
            android.content.SharedPreferences sharedPreferences = com.umeng.commonsdk.statistics.internal.PreferenceWrapper.getDefault(context);
            sharedPreferences.edit().putLong(KEY_LAST_INSTANT_SUCC_BUILD_TIME, java.lang.System.currentTimeMillis()).commit();
        }
    }

    private static void updateLastSuccessfulBuildTime(android.content.Context context) {
        synchronized (mEnvelopeBuildTimeLock) {
            android.content.SharedPreferences sharedPreferences = com.umeng.commonsdk.statistics.internal.PreferenceWrapper.getDefault(context);
            sharedPreferences.edit().putLong(KEY_LAST_SUCC_BUILD_TIME, java.lang.System.currentTimeMillis()).commit();
        }
    }
}
