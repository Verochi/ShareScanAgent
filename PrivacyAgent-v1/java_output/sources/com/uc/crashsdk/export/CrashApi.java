package com.uc.crashsdk.export;

/* loaded from: classes19.dex */
public class CrashApi {
    private static com.uc.crashsdk.export.CrashApi a = null;
    private static boolean c = true;
    private static boolean d;
    private boolean b;

    private CrashApi(android.content.Context context, com.uc.crashsdk.export.CustomInfo customInfo, com.uc.crashsdk.export.VersionInfo versionInfo, com.uc.crashsdk.export.ICrashClient iCrashClient, boolean z, boolean z2, boolean z3) {
        this.b = false;
        android.content.Context a2 = a(context);
        b(a2);
        com.uc.crashsdk.b.g = z2;
        com.uc.crashsdk.b.h = z3;
        if (com.uc.crashsdk.b.L()) {
            b(a2);
            a(a2, customInfo, versionInfo, iCrashClient);
            if (z) {
                a();
            }
            if (com.uc.crashsdk.b.g && com.uc.crashsdk.e.e("libcrashsdk.so")) {
                com.uc.crashsdk.b.f = true;
                b();
                return;
            }
            return;
        }
        if (customInfo == null || versionInfo == null) {
            com.uc.crashsdk.a.a.d("crashsdk", "VersionInfo and CustomInfo can not be null!");
            throw null;
        }
        com.uc.crashsdk.g.a(customInfo);
        try {
            a(a2, customInfo, versionInfo, iCrashClient);
        } catch (java.lang.Throwable th) {
            a(th);
        }
        if (z) {
            try {
                a();
            } catch (java.lang.Throwable th2) {
                a(th2);
            }
        }
        try {
            com.uc.crashsdk.b.M();
            com.uc.crashsdk.a.h.a();
            com.uc.crashsdk.a.d.a();
            com.uc.crashsdk.a.g.j();
        } catch (java.lang.Throwable th3) {
            com.uc.crashsdk.a.g.a(th3);
        }
        try {
            if (!com.uc.crashsdk.b.a(a2)) {
                com.uc.crashsdk.a.a.d("crashsdk", "registerLifecycleCallbacks failed!");
            }
        } catch (java.lang.Throwable th4) {
            com.uc.crashsdk.a.g.a(th4);
        }
        try {
            com.uc.crashsdk.a.n();
            try {
                com.uc.crashsdk.e.A();
            } catch (java.lang.Throwable th5) {
                com.uc.crashsdk.a.g.b(th5);
            }
            com.uc.crashsdk.e.B();
        } catch (java.lang.Throwable th6) {
            com.uc.crashsdk.a.g.a(th6);
        }
        try {
            if (com.uc.crashsdk.g.s() && com.uc.crashsdk.b.F() && !this.b) {
                com.uc.crashsdk.e.G();
                this.b = true;
            }
        } catch (java.lang.Throwable th7) {
            com.uc.crashsdk.a.g.b(th7);
        }
    }

    private static android.content.Context a(android.content.Context context) {
        if (context == null) {
            com.uc.crashsdk.a.a.d("crashsdk", "context can not be null!");
            throw null;
        }
        if (!c || (context instanceof android.app.Application) || ((context = context.getApplicationContext()) != null && (context instanceof android.app.Application))) {
            return context;
        }
        com.uc.crashsdk.a.a.d("crashsdk", "Can not get Application context from given context!");
        throw new java.lang.IllegalArgumentException("Can not get Application context from given context!");
    }

    private static void a() {
        if (com.uc.crashsdk.b.a) {
            com.uc.crashsdk.a.a.b("Has enabled java log!");
            return;
        }
        com.uc.crashsdk.e.s();
        com.uc.crashsdk.e.o();
        com.uc.crashsdk.b.a = true;
    }

    private static void a(android.content.Context context, com.uc.crashsdk.export.CustomInfo customInfo, com.uc.crashsdk.export.VersionInfo versionInfo, com.uc.crashsdk.export.ICrashClient iCrashClient) {
        com.uc.crashsdk.d.a(iCrashClient);
        com.uc.crashsdk.g.a(customInfo, versionInfo);
        if (com.uc.crashsdk.b.L()) {
            return;
        }
        com.uc.crashsdk.e.p();
        com.uc.crashsdk.e.a(context);
        com.uc.crashsdk.e.b(context);
    }

    private static void a(java.lang.Throwable th) {
        new com.uc.crashsdk.e().a(java.lang.Thread.currentThread(), th, true);
    }

    private static boolean a(java.lang.String str) {
        if (!com.uc.crashsdk.b.L()) {
            return false;
        }
        com.uc.crashsdk.a.a.d("crashsdk", "Can not call '" + str + "' in isolated process!");
        return true;
    }

    private static void b() {
        synchronized (com.uc.crashsdk.b.e) {
            if (com.uc.crashsdk.b.g && com.uc.crashsdk.b.f) {
                if (com.uc.crashsdk.b.b) {
                    com.uc.crashsdk.a.a.b("Has enabled native log!");
                    return;
                }
                c();
                com.uc.crashsdk.e.D();
                com.uc.crashsdk.b.b = true;
                com.uc.crashsdk.JNIBridge.cmd(6);
                com.uc.crashsdk.g.d();
            }
        }
    }

    private static void b(android.content.Context context) {
        try {
            if (d) {
                return;
            }
            com.uc.crashsdk.a.g.a(context);
            com.uc.crashsdk.a.a = context.getPackageName();
            d = true;
        } catch (java.lang.Throwable th) {
            a(th);
        }
    }

    private static void c() {
        if (com.uc.crashsdk.b.d) {
            return;
        }
        com.uc.crashsdk.g.b();
        com.uc.crashsdk.JNIBridge.cmd(5);
        com.uc.crashsdk.g.c();
        com.uc.crashsdk.b.d = true;
    }

    public static synchronized com.uc.crashsdk.export.CrashApi createInstance(android.content.Context context, com.uc.crashsdk.export.CustomInfo customInfo, com.uc.crashsdk.export.VersionInfo versionInfo, com.uc.crashsdk.export.ICrashClient iCrashClient, boolean z, boolean z2, boolean z3) {
        com.uc.crashsdk.export.CrashApi crashApi;
        synchronized (com.uc.crashsdk.export.CrashApi.class) {
            if (a == null) {
                a = new com.uc.crashsdk.export.CrashApi(context, customInfo, versionInfo, iCrashClient, z, z2, z3);
            }
            crashApi = a;
        }
        return crashApi;
    }

    public static com.uc.crashsdk.export.CrashApi createInstanceEx(android.content.Context context, java.lang.String str, boolean z) {
        return createInstanceEx(context, str, z, null);
    }

    public static com.uc.crashsdk.export.CrashApi createInstanceEx(android.content.Context context, java.lang.String str, boolean z, android.os.Bundle bundle) {
        return createInstanceEx(context, str, z, bundle, null);
    }

    public static com.uc.crashsdk.export.CrashApi createInstanceEx(android.content.Context context, java.lang.String str, boolean z, android.os.Bundle bundle, com.uc.crashsdk.export.ICrashClient iCrashClient) {
        com.uc.crashsdk.export.CrashApi crashApi = a;
        if (crashApi != null) {
            return crashApi;
        }
        if (bundle == null) {
            bundle = new android.os.Bundle();
        }
        c = bundle.getBoolean("useApplicationContext", true);
        android.content.Context a2 = a(context);
        b(a2);
        com.uc.crashsdk.export.CustomInfo customInfo = new com.uc.crashsdk.export.CustomInfo(str);
        customInfo.mEnableStatReport = false;
        customInfo.mZipLog = true;
        customInfo.mPrintStackInfos = z;
        bundle.putString("crver", "2.0");
        com.uc.crashsdk.export.CustomInfo a3 = com.uc.crashsdk.g.a(customInfo, bundle);
        com.uc.crashsdk.export.VersionInfo a4 = com.uc.crashsdk.g.a(bundle);
        boolean z2 = bundle.getBoolean(com.umeng.umcrash.UMCrash.KEY_ENABLE_CRASH_JAVA, true);
        boolean z3 = bundle.getBoolean(com.umeng.umcrash.UMCrash.KEY_ENABLE_CRASH_NATIVE, true);
        boolean z4 = bundle.getBoolean(com.umeng.umcrash.UMCrash.KEY_ENABLE_CRASH_UNEXP, com.uc.crashsdk.b.F());
        boolean z5 = bundle.getBoolean(com.umeng.umcrash.UMCrash.KEY_ENABLE_ANR, true);
        com.uc.crashsdk.export.CrashApi createInstance = createInstance(a2, a3, a4, iCrashClient, z2, z3, z4);
        createInstance.disableLog(com.google.android.exoplayer2.C.ENCODING_PCM_32BIT);
        com.uc.crashsdk.b.a(z5);
        if (z3 || z4) {
            if (com.uc.crashsdk.e.e("libcrashsdk.so")) {
                createInstance.crashSoLoaded();
            } else {
                com.uc.crashsdk.a.a.d("crashsdk", "load libcrashsdk.so failed!");
            }
        }
        int i = bundle.getInt("uploadLogDelaySeconds", 15);
        if (i >= 0 && com.uc.crashsdk.b.F()) {
            com.uc.crashsdk.e.b(i);
        }
        return createInstance;
    }

    public static com.uc.crashsdk.export.CrashApi getInstance() {
        return a;
    }

    public int addCachedInfo(java.lang.String str, java.lang.String str2) {
        if (str == null || str2 == null) {
            throw null;
        }
        return com.uc.crashsdk.a.b(str, str2);
    }

    public int addDumpFile(com.uc.crashsdk.export.DumpFileInfo dumpFileInfo) {
        java.lang.String str;
        dumpFileInfo.getClass();
        java.lang.String str2 = dumpFileInfo.mCategory;
        if (str2 == null || (str = dumpFileInfo.mFileTobeDump) == null) {
            throw null;
        }
        int i = dumpFileInfo.mLogType;
        if ((1048849 & i) == 0) {
            return 0;
        }
        return com.uc.crashsdk.a.a(str2, str, dumpFileInfo.mIsEncrypted, dumpFileInfo.mWriteCategory, i, dumpFileInfo.mDeleteAfterDump);
    }

    public int addDumpFile(java.lang.String str, java.lang.String str2, int i, android.os.Bundle bundle) {
        com.uc.crashsdk.export.DumpFileInfo dumpFileInfo = new com.uc.crashsdk.export.DumpFileInfo(str, str2, i);
        if (bundle != null) {
            dumpFileInfo.mIsEncrypted = bundle.getBoolean("mIsEncrypted", dumpFileInfo.mIsEncrypted);
            dumpFileInfo.mWriteCategory = bundle.getBoolean("mWriteCategory", dumpFileInfo.mWriteCategory);
            dumpFileInfo.mDeleteAfterDump = bundle.getBoolean("mDeleteAfterDump", dumpFileInfo.mDeleteAfterDump);
        }
        return addDumpFile(dumpFileInfo);
    }

    public void addHeaderInfo(java.lang.String str, java.lang.String str2) {
        str.getClass();
        com.uc.crashsdk.a.a(str, str2);
    }

    public boolean addStatInfo(java.lang.String str, java.lang.String str2) {
        if (a("addStatInfo")) {
            return false;
        }
        if (com.uc.crashsdk.a.g.a(str)) {
            throw null;
        }
        if (str.length() > 24) {
            throw new java.lang.IllegalArgumentException("key is too long!");
        }
        if (str2 != null && str2.length() > 512) {
            str2 = str2.substring(0, 512);
        }
        return com.uc.crashsdk.a.h.a(str, str2);
    }

    public void crashSoLoaded() {
        if (a("crashSoLoaded")) {
            return;
        }
        com.uc.crashsdk.b.f = true;
        b();
        synchronized (com.uc.crashsdk.b.e) {
            if (com.uc.crashsdk.b.h && com.uc.crashsdk.b.f && !com.uc.crashsdk.b.c) {
                if (!com.uc.crashsdk.b.d) {
                    c();
                    com.uc.crashsdk.g.d();
                }
                com.uc.crashsdk.e.x();
                com.uc.crashsdk.b.c = true;
            }
        }
        com.uc.crashsdk.a.n();
        com.uc.crashsdk.e.m();
    }

    public int createCachedInfo(java.lang.String str, int i, int i2) {
        str.getClass();
        if (i <= 0) {
            throw new java.lang.IllegalArgumentException("capacity must > 0!");
        }
        if ((1048849 & i2) == 0) {
            return 0;
        }
        return com.uc.crashsdk.a.a(str, i, i2);
    }

    public void disableLog(int i) {
        synchronized (com.uc.crashsdk.b.e) {
            com.uc.crashsdk.b.b(i);
            if (com.uc.crashsdk.export.LogType.isForJava(i) && com.uc.crashsdk.b.a) {
                com.uc.crashsdk.e.t();
                com.uc.crashsdk.b.a = false;
            }
            if (com.uc.crashsdk.export.LogType.isForNative(i)) {
                if (com.uc.crashsdk.b.b) {
                    com.uc.crashsdk.JNIBridge.cmd(9);
                    com.uc.crashsdk.b.b = false;
                } else {
                    com.uc.crashsdk.b.g = false;
                }
            }
            if (com.uc.crashsdk.export.LogType.isForANR(i)) {
                com.uc.crashsdk.b.a(false);
            }
            if (com.uc.crashsdk.export.LogType.isForUnexp(i)) {
                if (!com.uc.crashsdk.b.c) {
                    com.uc.crashsdk.b.h = false;
                } else if (com.uc.crashsdk.e.z()) {
                    com.uc.crashsdk.b.c = false;
                }
            }
        }
    }

    public boolean generateCustomLog(com.uc.crashsdk.export.CustomLogInfo customLogInfo) {
        java.lang.String str;
        java.lang.StringBuilder sb;
        customLogInfo.getClass();
        if (customLogInfo.mData == null || (str = customLogInfo.mLogType) == null) {
            throw new java.lang.NullPointerException("mData or mLogType is null!");
        }
        if (str.contains("_") || customLogInfo.mLogType.contains(" ")) {
            throw new java.lang.IllegalArgumentException("mLogType can not contain char '_' and ' '");
        }
        java.util.ArrayList<java.lang.Integer> arrayList = customLogInfo.mDumpTids;
        if (arrayList == null || arrayList.size() <= 0) {
            sb = null;
        } else {
            sb = new java.lang.StringBuilder();
            java.util.Iterator<java.lang.Integer> it = customLogInfo.mDumpTids.iterator();
            while (it.hasNext()) {
                sb.append(it.next().intValue());
                sb.append(" ");
            }
        }
        long j = customLogInfo.mAddHeader ? 1L : 0L;
        if (customLogInfo.mAddFooter) {
            j |= 2;
        }
        if (customLogInfo.mAddLogcat) {
            j |= 4;
        }
        if (customLogInfo.mAddThreadsDump) {
            j |= 8;
        }
        if (customLogInfo.mAddBuildId) {
            j |= 16;
        }
        if (customLogInfo.mUploadNow) {
            j |= 32;
        }
        return com.uc.crashsdk.e.a(customLogInfo.mData, customLogInfo.mLogType, j, customLogInfo.mDumpFiles, customLogInfo.mCallbacks, customLogInfo.mCachedInfos, sb != null ? sb.toString() : null);
    }

    public boolean generateCustomLog(java.lang.StringBuffer stringBuffer, java.lang.String str, android.os.Bundle bundle) {
        com.uc.crashsdk.export.CustomLogInfo customLogInfo = new com.uc.crashsdk.export.CustomLogInfo(stringBuffer, str);
        if (bundle != null) {
            customLogInfo.mAddHeader = bundle.getBoolean("mAddHeader", customLogInfo.mAddHeader);
            customLogInfo.mAddFooter = bundle.getBoolean("mAddFooter", customLogInfo.mAddFooter);
            customLogInfo.mAddLogcat = bundle.getBoolean("mAddLogcat", customLogInfo.mAddLogcat);
            customLogInfo.mUploadNow = bundle.getBoolean("mUploadNow", customLogInfo.mUploadNow);
            customLogInfo.mAddThreadsDump = bundle.getBoolean("mAddThreadsDump", customLogInfo.mAddThreadsDump);
            customLogInfo.mAddBuildId = bundle.getBoolean("mAddBuildId", customLogInfo.mAddBuildId);
            customLogInfo.mDumpFiles = bundle.getStringArrayList("mDumpFiles");
            customLogInfo.mCallbacks = bundle.getStringArrayList("mCallbacks");
            customLogInfo.mCachedInfos = bundle.getStringArrayList("mCachedInfos");
            customLogInfo.mDumpTids = bundle.getIntegerArrayList("mDumpTids");
        }
        return generateCustomLog(customLogInfo);
    }

    public boolean generateTraces(java.lang.String str, long j) {
        if (a("generateTraces")) {
            return false;
        }
        if (com.uc.crashsdk.b.d) {
            return com.uc.crashsdk.JNIBridge.nativeCmd(12, j, str, null) == 1;
        }
        com.uc.crashsdk.a.a.d("crashsdk", "Crash so is not loaded!");
        return false;
    }

    public java.lang.String getCrashLogUploadUrl() {
        if (a("getCrashLogUploadUrl")) {
            return null;
        }
        return com.uc.crashsdk.e.k();
    }

    public android.os.ParcelFileDescriptor getHostFd() {
        return com.uc.crashsdk.e.E();
    }

    public android.os.ParcelFileDescriptor getIsolatedHostFd() {
        return com.uc.crashsdk.e.E();
    }

    public int getLastExitType() {
        if (a("getLastExitType")) {
            return 1;
        }
        return com.uc.crashsdk.b.I();
    }

    public int getLastExitTypeEx() {
        if (a("getLastExitTypeEx")) {
            return 1;
        }
        return com.uc.crashsdk.b.J();
    }

    public java.lang.Throwable getUncaughtException() {
        return com.uc.crashsdk.e.v();
    }

    public int getUnexpReason() {
        if (a("getUnexpReason")) {
            return 100;
        }
        return com.uc.crashsdk.e.w();
    }

    public void onExit() {
        com.uc.crashsdk.b.w();
    }

    public boolean registerCallback(int i, android.webkit.ValueCallback<android.os.Bundle> valueCallback) {
        valueCallback.getClass();
        if (i == 1) {
            return com.uc.crashsdk.d.a(valueCallback);
        }
        if (i == 2) {
            return com.uc.crashsdk.d.c(valueCallback);
        }
        if (i == 3) {
            return com.uc.crashsdk.d.d(valueCallback);
        }
        if (i == 4) {
            return com.uc.crashsdk.d.b(valueCallback);
        }
        throw new java.lang.IllegalArgumentException("Unknown event type: " + i);
    }

    public int registerInfoCallback(java.lang.String str, int i) {
        str.getClass();
        if ((1048849 & i) == 0) {
            return 0;
        }
        return com.uc.crashsdk.a.a(str, i, null, 0L, 0);
    }

    public int registerInfoCallback(java.lang.String str, int i, java.util.concurrent.Callable<java.lang.String> callable) {
        if (str == null || callable == null) {
            throw null;
        }
        if ((1048849 & i) == 0) {
            return 0;
        }
        return com.uc.crashsdk.a.a(str, i, callable, 0L, 0);
    }

    public int registerThread(int i, java.lang.String str) {
        return com.uc.crashsdk.a.a(i, str);
    }

    public int reportCrashStats(boolean z) {
        if (a("reportCrashStats")) {
            return 0;
        }
        if (com.uc.crashsdk.g.P()) {
            com.uc.crashsdk.a.a.a("CrashApi::reportCrashStats. currentProcessOnly: " + z);
        }
        com.uc.crashsdk.e.d(z);
        return com.uc.crashsdk.e.e(z);
    }

    public int resetCrashStats(boolean z) {
        if (a("resetCrashStats")) {
            return 0;
        }
        if (com.uc.crashsdk.g.P()) {
            com.uc.crashsdk.a.a.a("CrashApi::resetCrashStats. currentProcessOnly: " + z);
        }
        return com.uc.crashsdk.e.f(z);
    }

    public void setForeground(boolean z) {
        com.uc.crashsdk.b.b(z);
    }

    public boolean setHostFd(android.os.ParcelFileDescriptor parcelFileDescriptor) {
        return com.uc.crashsdk.e.a(parcelFileDescriptor);
    }

    public boolean setIsolatedHostFd(android.os.ParcelFileDescriptor parcelFileDescriptor) {
        return com.uc.crashsdk.e.a(parcelFileDescriptor);
    }

    public void setNewInstall() {
        if (a("setNewInstall")) {
            return;
        }
        com.uc.crashsdk.b.v();
    }

    public int updateCustomInfo(android.os.Bundle bundle) {
        bundle.getClass();
        return updateCustomInfo(com.uc.crashsdk.g.a((com.uc.crashsdk.export.CustomInfo) null, bundle));
    }

    public int updateCustomInfo(com.uc.crashsdk.export.CustomInfo customInfo) {
        customInfo.getClass();
        return com.uc.crashsdk.g.b(customInfo);
    }

    public boolean updateUnexpInfo() {
        if (a("updateUnexpInfo")) {
            return false;
        }
        return com.uc.crashsdk.a.a(true);
    }

    public void updateVersionInfo(android.os.Bundle bundle) {
        bundle.getClass();
        updateVersionInfo(com.uc.crashsdk.g.a(bundle));
    }

    public void updateVersionInfo(com.uc.crashsdk.export.VersionInfo versionInfo) {
        versionInfo.getClass();
        com.uc.crashsdk.g.a(versionInfo);
    }

    public void uploadCrashLogs() {
        if (a("uploadCrashLogs")) {
            return;
        }
        com.uc.crashsdk.e.a(false, true);
    }
}
