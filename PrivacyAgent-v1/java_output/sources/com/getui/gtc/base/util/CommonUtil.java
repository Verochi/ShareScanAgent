package com.getui.gtc.base.util;

/* loaded from: classes22.dex */
public class CommonUtil {
    private static java.io.File externalFilesDir;
    private static java.lang.Boolean isAppDebug;

    public static class CommonUtilSubscriber implements com.getui.gtc.base.publish.Subscriber {
        private static final com.getui.gtc.base.util.CommonUtil.CommonUtilSubscriber INSTANCE = new com.getui.gtc.base.util.CommonUtil.CommonUtilSubscriber();
        private static java.lang.String getInstanceMethodName;
        private android.content.pm.ApplicationInfo applicationInfo;
        private android.content.pm.PackageInfo packageInfo;

        private CommonUtilSubscriber() {
        }

        private android.os.Bundle createBundle() {
            android.os.Bundle bundle = new android.os.Bundle();
            bundle.putString(com.getui.gtc.base.ProcessSwitchContract.CLASS_NAME, getClass().getName());
            bundle.putString(com.getui.gtc.base.ProcessSwitchContract.GET_INSTANCE, getInstanceMethodName);
            return bundle;
        }

        public static com.getui.gtc.base.util.CommonUtil.CommonUtilSubscriber getInstance() {
            getInstanceMethodName = java.lang.Thread.currentThread().getStackTrace()[2].getMethodName();
            return INSTANCE;
        }

        public android.content.pm.ApplicationInfo getAppInfoForSelf(android.content.Context context) {
            try {
                if (!com.getui.gtc.base.util.CommonUtil.isGtcProcess()) {
                    com.getui.gtc.base.GtcProvider.setContext(context);
                    android.os.Bundle createBundle = createBundle();
                    createBundle.putString(com.getui.gtc.base.ProcessSwitchContract.METHOD_NAME, "base-1-3-1");
                    return (android.content.pm.ApplicationInfo) com.getui.gtc.base.publish.Broker.getInstance().subscribe(createBundle).getParcelable(com.getui.gtc.base.ProcessSwitchContract.METHOD_RETURN);
                }
                if (this.applicationInfo == null) {
                    if (context == null) {
                        context = com.getui.gtc.base.util.CommonUtil.findAppContext();
                    }
                    this.applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
                }
                return this.applicationInfo;
            } catch (java.lang.Throwable th) {
                th.printStackTrace();
                return null;
            }
        }

        public android.content.pm.PackageInfo getPackageInfoForSelf(android.content.Context context) {
            try {
                if (!com.getui.gtc.base.util.CommonUtil.isGtcProcess()) {
                    com.getui.gtc.base.GtcProvider.setContext(context);
                    android.os.Bundle createBundle = createBundle();
                    createBundle.putString(com.getui.gtc.base.ProcessSwitchContract.METHOD_NAME, "base-1-2-1");
                    return (android.content.pm.PackageInfo) com.getui.gtc.base.publish.Broker.getInstance().subscribe(createBundle).getParcelable(com.getui.gtc.base.ProcessSwitchContract.METHOD_RETURN);
                }
                if (this.packageInfo == null) {
                    if (context == null) {
                        context = com.getui.gtc.base.util.CommonUtil.findAppContext();
                    }
                    this.packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 79);
                }
                return this.packageInfo;
            } catch (java.lang.Throwable th) {
                th.printStackTrace();
                return null;
            }
        }

        public boolean isAppForeground() {
            try {
                if (com.getui.gtc.base.util.CommonUtil.isGtcProcess()) {
                    return com.getui.gtc.base.GtcProvider.isForeground();
                }
                android.os.Bundle createBundle = createBundle();
                createBundle.putString(com.getui.gtc.base.ProcessSwitchContract.METHOD_NAME, "base-1-1-1");
                return com.getui.gtc.base.publish.Broker.getInstance().subscribe(createBundle).getBoolean(com.getui.gtc.base.ProcessSwitchContract.METHOD_RETURN);
            } catch (java.lang.Throwable unused) {
                return false;
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:18:0x0057  */
        /* JADX WARN: Removed duplicated region for block: B:25:0x0082 A[DONT_GENERATE, LOOP:0: B:23:0x007c->B:25:0x0082, LOOP_END] */
        /* JADX WARN: Removed duplicated region for block: B:30:0x0071 A[Catch: all -> 0x0095, TRY_LEAVE, TryCatch #0 {all -> 0x0095, blocks: (B:3:0x0005, B:5:0x000f, B:6:0x0012, B:8:0x001e, B:20:0x005c, B:21:0x0064, B:29:0x0068, B:30:0x0071, B:31:0x0034, B:34:0x003e, B:37:0x0048, B:40:0x008d, B:41:0x0094), top: B:2:0x0005 }] */
        @Override // com.getui.gtc.base.publish.Subscriber
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void receive(android.os.Bundle bundle, android.os.Bundle bundle2) {
            char c;
            android.os.Parcelable packageInfoForSelf;
            java.util.ArrayList arrayList = new java.util.ArrayList();
            try {
                java.lang.Throwable th = (java.lang.Throwable) bundle2.getSerializable(com.getui.gtc.base.ProcessSwitchContract.METHOD_EXCEPTION);
                if (th != null) {
                    arrayList.add(th);
                }
                java.lang.String string = bundle.getString(com.getui.gtc.base.ProcessSwitchContract.METHOD_NAME);
                if (android.text.TextUtils.isEmpty(string)) {
                    throw new java.lang.RuntimeException("methodName missed");
                }
                int hashCode = string.hashCode();
                if (hashCode == -1969640451) {
                    if (string.equals("base-1-1-1")) {
                        c = 0;
                        if (c == 0) {
                        }
                    }
                    c = 65535;
                    if (c == 0) {
                    }
                }
                if (hashCode == -1969639490) {
                    if (string.equals("base-1-2-1")) {
                        c = 1;
                        if (c == 0) {
                        }
                    }
                    c = 65535;
                    if (c == 0) {
                    }
                }
                if (hashCode == -1969638529 && string.equals("base-1-3-1")) {
                    c = 2;
                    if (c == 0) {
                        if (c == 1) {
                            packageInfoForSelf = getPackageInfoForSelf(com.getui.gtc.base.GtcProvider.context());
                        } else if (c == 2) {
                            packageInfoForSelf = getAppInfoForSelf(com.getui.gtc.base.GtcProvider.context());
                        }
                        bundle2.putParcelable(com.getui.gtc.base.ProcessSwitchContract.METHOD_RETURN, packageInfoForSelf);
                    } else {
                        bundle2.putBoolean(com.getui.gtc.base.ProcessSwitchContract.METHOD_RETURN, isAppForeground());
                    }
                }
                c = 65535;
                if (c == 0) {
                }
            } catch (java.lang.Throwable th2) {
                try {
                    arrayList.add(th2);
                    java.util.Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        ((java.lang.Throwable) it.next()).printStackTrace();
                    }
                } finally {
                    java.util.Iterator it2 = arrayList.iterator();
                    while (it2.hasNext()) {
                        ((java.lang.Throwable) it2.next()).printStackTrace();
                    }
                }
            }
        }
    }

    public static void checkRuntimePermission(android.content.Context context, java.lang.String str, boolean z) throws java.lang.Throwable {
        if (hasPermission(context, str, z)) {
            return;
        }
        throw new java.lang.IllegalStateException("permission " + str + " not granted");
    }

    public static android.content.Context findAppContext() {
        try {
            java.lang.reflect.Method declaredMethod = java.lang.Class.forName("android.app.ActivityThread").getDeclaredMethod("currentApplication", new java.lang.Class[0]);
            declaredMethod.setAccessible(true);
            return (android.content.Context) declaredMethod.invoke(null, new java.lang.Object[0]);
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public static android.content.pm.ApplicationInfo getAppInfoForSelf(android.content.Context context) throws android.content.pm.PackageManager.NameNotFoundException {
        android.content.pm.ApplicationInfo appInfoForSelf = com.getui.gtc.base.util.CommonUtil.CommonUtilSubscriber.getInstance().getAppInfoForSelf(context);
        if (appInfoForSelf != null) {
            return appInfoForSelf;
        }
        throw new android.content.pm.PackageManager.NameNotFoundException();
    }

    public static java.io.File getExternalFilesDir(android.content.Context context) {
        if (externalFilesDir == null) {
            if (context == null) {
                context = findAppContext();
            }
            externalFilesDir = context.getExternalFilesDir(null);
        }
        return externalFilesDir;
    }

    public static android.content.pm.PackageInfo getPackageInfoForSelf(android.content.Context context) throws android.content.pm.PackageManager.NameNotFoundException {
        android.content.pm.PackageInfo packageInfoForSelf = com.getui.gtc.base.util.CommonUtil.CommonUtilSubscriber.getInstance().getPackageInfoForSelf(context);
        if (packageInfoForSelf != null) {
            return packageInfoForSelf;
        }
        throw new android.content.pm.PackageManager.NameNotFoundException();
    }

    public static java.lang.String getProcessName() {
        java.lang.String str;
        try {
            if (android.os.Build.VERSION.SDK_INT >= 28) {
                str = android.app.Application.getProcessName();
            } else {
                java.lang.reflect.Method declaredMethod = java.lang.Class.forName("android.app.ActivityThread").getDeclaredMethod("currentProcessName", new java.lang.Class[0]);
                declaredMethod.setAccessible(true);
                str = (java.lang.String) declaredMethod.invoke(null, new java.lang.Object[0]);
            }
            return str;
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            java.lang.String processNameByPid = getProcessNameByPid(android.os.Process.myPid());
            return !android.text.TextUtils.isEmpty(processNameByPid) ? processNameByPid : "unknown.process";
        }
    }

    private static java.lang.String getProcessNameByPid(int i) {
        java.io.BufferedReader bufferedReader;
        try {
            bufferedReader = new java.io.BufferedReader(new java.io.FileReader("/proc/" + i + "/cmdline"));
            try {
                java.lang.String readLine = bufferedReader.readLine();
                if (!android.text.TextUtils.isEmpty(readLine)) {
                    readLine = readLine.trim();
                }
                try {
                    bufferedReader.close();
                } catch (java.io.IOException e) {
                    e.printStackTrace();
                }
                return readLine;
            } catch (java.lang.Throwable th) {
                th = th;
                try {
                    th.printStackTrace();
                    return null;
                } finally {
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (java.io.IOException e2) {
                            e2.printStackTrace();
                        }
                    }
                }
            }
        } catch (java.lang.Throwable th2) {
            th = th2;
            bufferedReader = null;
        }
    }

    public static android.app.Activity getTopActivity() {
        android.util.ArrayMap arrayMap;
        try {
            java.lang.Class<?> cls = java.lang.Class.forName("android.app.ActivityThread");
            java.lang.Object invoke = cls.getMethod("currentActivityThread", new java.lang.Class[0]).invoke(null, new java.lang.Object[0]);
            java.lang.reflect.Field declaredField = cls.getDeclaredField("mActivities");
            declaredField.setAccessible(true);
            arrayMap = (android.util.ArrayMap) declaredField.get(invoke);
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
        if (arrayMap.size() <= 0) {
            return null;
        }
        for (java.lang.Object obj : arrayMap.values()) {
            java.lang.Class<?> cls2 = obj.getClass();
            java.lang.reflect.Field declaredField2 = cls2.getDeclaredField("paused");
            declaredField2.setAccessible(true);
            if (!declaredField2.getBoolean(obj)) {
                java.lang.reflect.Field declaredField3 = cls2.getDeclaredField("activity");
                declaredField3.setAccessible(true);
                return (android.app.Activity) declaredField3.get(obj);
            }
        }
        return null;
    }

    public static boolean hasPermission(android.content.Context context, java.lang.String str, boolean z) {
        try {
            return context.getPackageManager().checkPermission(str, context.getPackageName()) == 0;
        } catch (java.lang.Throwable unused) {
            return z;
        }
    }

    public static boolean isAppDebugEnable() {
        if (com.getui.gtc.base.GtcProvider.context() == null) {
            return false;
        }
        if (isAppDebug == null) {
            try {
                isAppDebug = java.lang.Boolean.valueOf((com.getui.gtc.base.GtcProvider.context().getApplicationInfo().flags & 2) != 0);
            } catch (java.lang.Throwable unused) {
                return false;
            }
        }
        return isAppDebug.booleanValue();
    }

    public static boolean isAppForeground() {
        return com.getui.gtc.base.util.CommonUtil.CommonUtilSubscriber.getInstance().isAppForeground();
    }

    public static boolean isGtcProcess() {
        return android.os.Process.myPid() == com.getui.gtc.base.GtcProvider.gtcPid();
    }

    public static boolean isMainProcess() {
        return isMainProcess(com.getui.gtc.base.GtcProvider.context());
    }

    public static boolean isMainProcess(android.content.Context context) {
        if (context == null) {
            try {
                context = findAppContext();
            } catch (java.lang.Throwable th) {
                th.printStackTrace();
            }
        }
        if (context != null) {
            java.lang.String str = context.getApplicationInfo().processName;
            java.lang.String processName = getProcessName();
            if (str != null) {
                if (str.equals(processName)) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    public static boolean isMainThread() {
        return android.os.Looper.myLooper() == android.os.Looper.getMainLooper();
    }
}
