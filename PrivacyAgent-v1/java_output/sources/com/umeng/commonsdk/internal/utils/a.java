package com.umeng.commonsdk.internal.utils;

/* loaded from: classes19.dex */
public class a {

    /* renamed from: com.umeng.commonsdk.internal.utils.a$a, reason: collision with other inner class name */
    public static class C0520a {
        public java.lang.String a;
        public java.lang.String b;
    }

    public static float a(android.content.Context context) {
        if (context == null) {
            return 0.0f;
        }
        android.content.res.Configuration configuration = new android.content.res.Configuration();
        try {
            configuration.updateFrom(context.getResources().getConfiguration());
            return configuration.fontScale;
        } catch (java.lang.Exception e) {
            com.umeng.commonsdk.statistics.common.ULog.e("getFontSize:" + e.getMessage());
            return 0.0f;
        }
    }

    public static long a(android.content.Context context, java.lang.String str) {
        if (context == null) {
            return 0L;
        }
        try {
            android.content.pm.PackageInfo a = com.umeng.commonsdk.utils.b.a().a(context, str, 64);
            if (a != null) {
                return a.firstInstallTime;
            }
            return 0L;
        } catch (java.lang.Throwable th) {
            com.umeng.commonsdk.internal.crash.UMCrashManager.reportCrash(context, th);
            com.umeng.commonsdk.statistics.common.ULog.e("getAppFirstInstallTime" + th.getMessage());
            return 0L;
        }
    }

    public static boolean a() {
        return com.umeng.commonsdk.internal.utils.h.a();
    }

    public static long b(android.content.Context context, java.lang.String str) {
        if (context == null) {
            return 0L;
        }
        try {
            android.content.pm.PackageInfo a = com.umeng.commonsdk.utils.b.a().a(context, str, 64);
            if (a != null) {
                return a.lastUpdateTime;
            }
            return 0L;
        } catch (java.lang.Throwable th) {
            com.umeng.commonsdk.internal.crash.UMCrashManager.reportCrash(context, th);
            com.umeng.commonsdk.statistics.common.ULog.e("getAppLastUpdateTime:" + th.getMessage());
            return 0L;
        }
    }

    public static java.lang.String b() {
        return new java.text.SimpleDateFormat().format(new java.util.Date());
    }

    public static void b(android.content.Context context) {
    }

    public static int c(android.content.Context context) {
        if (context == null) {
            return 0;
        }
        android.content.res.Resources resources = context.getResources();
        return resources.getDimensionPixelSize(resources.getIdentifier("status_bar_height", "dimen", com.aliyun.vod.log.core.AliyunLogCommon.OPERATION_SYSTEM));
    }

    public static long c() {
        return java.lang.System.currentTimeMillis() - android.os.SystemClock.elapsedRealtime();
    }

    public static java.lang.String c(android.content.Context context, java.lang.String str) {
        try {
            return context.getPackageManager().getInstallerPackageName(str);
        } catch (java.lang.Exception e) {
            com.umeng.commonsdk.internal.crash.UMCrashManager.reportCrash(context, e);
            com.umeng.commonsdk.statistics.common.ULog.e("getAppInstaller:" + e.getMessage());
            return null;
        }
    }

    public static int d(android.content.Context context) {
        if (context == null) {
            return 0;
        }
        android.content.res.Resources resources = context.getResources();
        return resources.getDimensionPixelSize(resources.getIdentifier("navigation_bar_height", "dimen", com.aliyun.vod.log.core.AliyunLogCommon.OPERATION_SYSTEM));
    }

    public static int d(android.content.Context context, java.lang.String str) {
        android.content.pm.ApplicationInfo applicationInfo;
        if (context == null) {
            return 0;
        }
        try {
            android.content.pm.PackageInfo a = com.umeng.commonsdk.utils.b.a().a(context, str, 64);
            if (a == null || (applicationInfo = a.applicationInfo) == null) {
                return 0;
            }
            return applicationInfo.uid;
        } catch (java.lang.Throwable th) {
            com.umeng.commonsdk.internal.crash.UMCrashManager.reportCrash(context, th);
            com.umeng.commonsdk.statistics.common.ULog.e("getAppUid:" + th.getMessage());
            return 0;
        }
    }

    public static java.lang.String d() {
        try {
            java.lang.reflect.Method declaredMethod = android.os.Build.class.getDeclaredMethod("getString", java.lang.String.class);
            declaredMethod.setAccessible(true);
            java.lang.String obj = declaredMethod.invoke(null, "net.hostname").toString();
            return (obj == null || obj.equalsIgnoreCase("")) ? obj : com.umeng.commonsdk.statistics.common.HelperUtils.getUmengMD5(obj);
        } catch (java.lang.Exception e) {
            com.umeng.commonsdk.statistics.common.ULog.e("getHostName:" + e.getMessage());
            return null;
        }
    }

    public static android.util.DisplayMetrics e(android.content.Context context) {
        if (context == null) {
            return null;
        }
        return context.getResources().getDisplayMetrics();
    }

    private static java.lang.String e(android.content.Context context, java.lang.String str) {
        if (context == null) {
            return null;
        }
        try {
            android.content.pm.ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(str, 128);
            if (applicationInfo != null) {
                return (java.lang.String) applicationInfo.loadLabel(context.getPackageManager());
            }
            return null;
        } catch (java.lang.Exception e) {
            com.umeng.commonsdk.statistics.common.ULog.e("getLabel:" + e.getMessage());
            return null;
        }
    }

    public static java.util.List<com.umeng.commonsdk.internal.utils.a.C0520a> f(android.content.Context context) {
        java.lang.String[] list;
        if (context == null) {
            return null;
        }
        java.util.ArrayList arrayList = new java.util.ArrayList();
        try {
            java.io.File file = new java.io.File(android.os.Environment.getExternalStorageDirectory() + "/Android/data/");
            if (file.isDirectory() && (list = file.list()) != null && list.length > 0) {
                for (java.lang.String str : list) {
                    if (str != null && !str.startsWith(".")) {
                        com.umeng.commonsdk.internal.utils.a.C0520a c0520a = new com.umeng.commonsdk.internal.utils.a.C0520a();
                        c0520a.a = str;
                        c0520a.b = e(context, str);
                        arrayList.add(c0520a);
                    }
                }
            }
        } catch (java.lang.Exception e) {
            com.umeng.commonsdk.statistics.common.ULog.e("getAppList:" + e.getMessage());
        }
        return arrayList;
    }

    public static android.app.ActivityManager.MemoryInfo g(android.content.Context context) {
        android.app.ActivityManager activityManager;
        if (context == null || (activityManager = (android.app.ActivityManager) context.getSystemService("activity")) == null) {
            return null;
        }
        android.app.ActivityManager.MemoryInfo memoryInfo = new android.app.ActivityManager.MemoryInfo();
        activityManager.getMemoryInfo(memoryInfo);
        return memoryInfo;
    }

    public static java.lang.String h(android.content.Context context) {
        return null;
    }

    public static java.lang.String i(android.content.Context context) {
        return null;
    }
}
