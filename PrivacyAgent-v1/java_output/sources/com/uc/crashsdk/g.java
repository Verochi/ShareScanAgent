package com.uc.crashsdk;

/* loaded from: classes19.dex */
public class g {
    public static java.lang.RuntimeException a = null;
    public static java.lang.RuntimeException b = null;
    static final /* synthetic */ boolean c = true;
    private static com.uc.crashsdk.export.CustomInfo d;
    private static com.uc.crashsdk.export.VersionInfo e;
    private static java.lang.String g;
    private static java.lang.String h;
    private static java.lang.String i;
    private static java.lang.String j;
    private static final java.lang.Object f = new java.lang.Object();
    private static final java.lang.Object k = new java.lang.Object();

    public static java.lang.String A() {
        return d.mCrashRateUploadUrl;
    }

    public static int B() {
        return d.mLogMaxBytesLimit;
    }

    public static int C() {
        return d.mLogMaxUploadBytesLimit;
    }

    public static long D() {
        return d.mMaxUploadBytesPerDay;
    }

    public static int E() {
        return d.mMaxUploadBuiltinLogCountPerDay;
    }

    public static int F() {
        return d.mMaxUploadCustomLogCountPerDay;
    }

    public static int G() {
        return d.mMaxCustomLogCountPerTypePerDay;
    }

    public static int H() {
        return d.mInfoUpdateInterval;
    }

    public static int I() {
        return d.mInfoSaveFrequency;
    }

    public static int J() {
        return d.mReservedJavaFileHandleCount;
    }

    public static int K() {
        return d.mFdDumpMinLimit;
    }

    public static int L() {
        return d.mThreadsDumpMinLimit;
    }

    public static boolean M() {
        return d.mAutoDetectLifeCycle;
    }

    public static boolean N() {
        return d.mMonitorBattery;
    }

    public static int O() {
        return d.mAnrTraceStrategy;
    }

    public static boolean P() {
        com.uc.crashsdk.export.CustomInfo customInfo = d;
        return customInfo == null || customInfo.mDebug;
    }

    public static boolean Q() {
        com.uc.crashsdk.export.CustomInfo customInfo = d;
        return customInfo == null || customInfo.mPrintStackInfos;
    }

    public static boolean R() {
        return d.mEnableStatReport;
    }

    public static boolean S() {
        return d.mIsInternational;
    }

    public static boolean T() {
        return d.mAddPvForNewDay;
    }

    public static java.lang.String U() {
        return com.uc.crashsdk.a.g.a(e.mVersion) ? com.uc.crashsdk.a.a() : a(e.mVersion);
    }

    public static java.lang.String V() {
        return com.uc.crashsdk.a.g.a(e.mSubVersion) ? "release" : e.mSubVersion;
    }

    public static java.lang.String W() {
        return com.uc.crashsdk.a.g.a(e.mBuildId) ? ae() : a(e.mBuildId);
    }

    public static java.lang.String X() {
        if (h == null) {
            h = com.uc.crashsdk.a.g.b() + java.io.File.separatorChar + d.mTagFilesFolderName + java.io.File.separatorChar;
        }
        return h;
    }

    public static java.lang.String Y() {
        if (i == null) {
            i = com.uc.crashsdk.a.g.b() + java.io.File.separatorChar + d.mCrashLogsFolderName + java.io.File.separatorChar;
        }
        return i;
    }

    public static java.lang.String Z() {
        if (j == null) {
            if (com.uc.crashsdk.a.g.a(d.mLogsBackupPathName)) {
                j = (com.uc.crashsdk.a.g.b() + java.io.File.separatorChar + "msdb" + java.io.File.separatorChar) + java.io.File.separatorChar + d.mCrashLogsFolderName + java.io.File.separatorChar;
            } else {
                java.lang.String trim = d.mLogsBackupPathName.trim();
                java.lang.String str = java.io.File.separator;
                if (!trim.endsWith(str)) {
                    trim = trim + str;
                }
                j = trim;
            }
        }
        return j;
    }

    public static com.uc.crashsdk.export.CustomInfo a(com.uc.crashsdk.export.CustomInfo customInfo, android.os.Bundle bundle) {
        if (customInfo == null) {
            com.uc.crashsdk.export.CustomInfo customInfo2 = d;
            customInfo = customInfo2 == null ? new com.uc.crashsdk.export.CustomInfo() : new com.uc.crashsdk.export.CustomInfo(customInfo2);
        }
        java.lang.reflect.Field[] fields = customInfo.getClass().getFields();
        for (java.lang.String str : bundle.keySet()) {
            for (java.lang.reflect.Field field : fields) {
                if (field.getName().equals(str)) {
                    java.lang.Object obj = bundle.get(str);
                    try {
                        field.set(customInfo, obj);
                    } catch (java.lang.Exception e2) {
                        com.uc.crashsdk.a.g.a(e2);
                        java.lang.StringBuilder sb = new java.lang.StringBuilder("Field ");
                        sb.append(str);
                        sb.append(" must be a ");
                        sb.append(field.getType().getName());
                        sb.append(", but give a ");
                        sb.append(obj != null ? obj.getClass().getName() : "(null)");
                        throw new java.lang.IllegalArgumentException(sb.toString());
                    }
                }
            }
        }
        return customInfo;
    }

    public static com.uc.crashsdk.export.VersionInfo a(android.os.Bundle bundle) {
        com.uc.crashsdk.export.VersionInfo versionInfo = e;
        com.uc.crashsdk.export.VersionInfo versionInfo2 = versionInfo == null ? new com.uc.crashsdk.export.VersionInfo() : new com.uc.crashsdk.export.VersionInfo(versionInfo);
        java.lang.String string = bundle.getString("mVersion");
        if (!com.uc.crashsdk.a.g.a(string)) {
            versionInfo2.mVersion = string;
        }
        java.lang.String string2 = bundle.getString("mSubVersion");
        if (!com.uc.crashsdk.a.g.a(string2)) {
            versionInfo2.mSubVersion = string2;
        }
        java.lang.String string3 = bundle.getString("mBuildId");
        if (!com.uc.crashsdk.a.g.a(string3)) {
            versionInfo2.mBuildId = string3;
        }
        java.lang.String string4 = bundle.getString("crver");
        if (!com.uc.crashsdk.a.g.a(string4)) {
            com.uc.crashsdk.a.b = string4;
            af();
        }
        return versionInfo2;
    }

    private static java.lang.String a(java.lang.String str) {
        return (str == null || !str.contains("_")) ? str : str.replaceAll("_", com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER);
    }

    public static void a() {
        com.uc.crashsdk.b.y();
        com.uc.crashsdk.b.x();
        if (d.mBackupLogs) {
            java.io.File file = new java.io.File(Z());
            if (file.exists()) {
                return;
            }
            file.mkdirs();
        }
    }

    public static void a(com.uc.crashsdk.export.CustomInfo customInfo) {
        boolean z = c;
        if (!z && customInfo.mTagFilesFolderName == null) {
            throw new java.lang.AssertionError();
        }
        if (!z && customInfo.mCrashLogsFolderName == null) {
            throw new java.lang.AssertionError();
        }
        if (customInfo.mTagFilesFolderName.equals(customInfo.mCrashLogsFolderName)) {
            throw new java.lang.IllegalArgumentException("mTagFilesFolderName and mCrashLogsFolderName can not be set to the same!");
        }
    }

    public static void a(com.uc.crashsdk.export.CustomInfo customInfo, com.uc.crashsdk.export.VersionInfo versionInfo) {
        com.uc.crashsdk.export.CustomInfo customInfo2 = new com.uc.crashsdk.export.CustomInfo(customInfo);
        d = customInfo2;
        c(customInfo2);
        if (!d.mZipLog) {
            a = new java.lang.RuntimeException("initialize set mZipLog to false, info.mZipLog: " + customInfo.mZipLog);
        }
        if (d.mEncryptLog) {
            b = new java.lang.RuntimeException("initialize set mEncryptLog to true, info.mEncryptLog: " + customInfo.mEncryptLog);
        }
        e = new com.uc.crashsdk.export.VersionInfo(versionInfo);
        if (com.uc.crashsdk.b.L()) {
            return;
        }
        try {
            a();
        } catch (java.lang.Throwable th) {
            com.uc.crashsdk.a.g.a(th);
        }
    }

    public static void a(com.uc.crashsdk.export.VersionInfo versionInfo) {
        synchronized (f) {
            e = new com.uc.crashsdk.export.VersionInfo(versionInfo);
            com.uc.crashsdk.e.c();
            if (com.uc.crashsdk.b.d) {
                com.uc.crashsdk.JNIBridge.set(109, U());
                com.uc.crashsdk.JNIBridge.set(110, V());
                com.uc.crashsdk.JNIBridge.set(111, W());
                com.uc.crashsdk.JNIBridge.set(112, "240515102041");
                com.uc.crashsdk.JNIBridge.cmd(2);
            }
        }
    }

    private static boolean a(java.lang.String str, java.lang.String str2) {
        if (str == str2) {
            return true;
        }
        if (str == null || str2 == null) {
            return false;
        }
        return str.equals(str2);
    }

    public static boolean aa() {
        return d.mEnableCrpStat;
    }

    public static boolean ab() {
        return d.mEnableStatToWPKDirect;
    }

    public static java.lang.String ac() {
        return d.mUserId;
    }

    public static java.lang.String ad() {
        return d.mChannel;
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0045, code lost:
    
        if (r1 == null) goto L17;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static java.lang.String ae() {
        java.util.zip.ZipFile zipFile;
        java.lang.Throwable th;
        java.lang.String str = g;
        if (str != null) {
            return str;
        }
        try {
            zipFile = new java.util.zip.ZipFile(com.uc.crashsdk.a.g.c());
            try {
                g = java.lang.Long.toHexString(zipFile.getEntry("classes.dex").getCrc());
                com.uc.crashsdk.a.a.a("crashsdk", "version unique build id: " + g);
            } catch (java.lang.Throwable th2) {
                th = th2;
                try {
                    g = "";
                    com.uc.crashsdk.a.g.a(th);
                } catch (java.lang.Throwable th3) {
                    if (zipFile != null) {
                        try {
                            zipFile.close();
                        } catch (java.lang.Throwable unused) {
                        }
                    }
                    throw th3;
                }
            }
        } catch (java.lang.Throwable th4) {
            zipFile = null;
            th = th4;
        }
        try {
            zipFile.close();
        } catch (java.lang.Throwable unused2) {
        }
        return g;
    }

    private static void af() {
        if (com.uc.crashsdk.b.d) {
            com.uc.crashsdk.JNIBridge.nativeSet(24, 1L, com.uc.crashsdk.a.b, null);
        }
    }

    public static int b(com.uc.crashsdk.export.CustomInfo customInfo) {
        int i2;
        int i3;
        boolean z;
        boolean z2;
        synchronized (k) {
            i2 = 0;
            if (customInfo != null) {
                c(customInfo);
                if (d == null) {
                    d = new com.uc.crashsdk.export.CustomInfo();
                }
                com.uc.crashsdk.export.CustomInfo customInfo2 = d;
                boolean z3 = true;
                if (a(customInfo.mAppId, customInfo2.mAppId)) {
                    i3 = 0;
                    z = false;
                } else {
                    java.lang.String str = customInfo.mAppId;
                    customInfo2.mAppId = str;
                    if (com.uc.crashsdk.b.d) {
                        com.uc.crashsdk.JNIBridge.set(102, str);
                    }
                    i3 = 1;
                    z = true;
                }
                if (!a(customInfo.mJavaCrashLogFileName, customInfo2.mJavaCrashLogFileName)) {
                    customInfo2.mJavaCrashLogFileName = customInfo.mJavaCrashLogFileName;
                    i3++;
                }
                if (!a(customInfo.mNativeCrashLogFileName, customInfo2.mNativeCrashLogFileName)) {
                    java.lang.String str2 = customInfo.mNativeCrashLogFileName;
                    customInfo2.mNativeCrashLogFileName = str2;
                    if (com.uc.crashsdk.b.d) {
                        com.uc.crashsdk.JNIBridge.set(100, str2);
                    }
                    i3++;
                    z = true;
                }
                if (!a(customInfo.mUnexpCrashLogFileName, customInfo2.mUnexpCrashLogFileName)) {
                    java.lang.String str3 = customInfo.mUnexpCrashLogFileName;
                    customInfo2.mUnexpCrashLogFileName = str3;
                    if (com.uc.crashsdk.b.d) {
                        com.uc.crashsdk.JNIBridge.set(101, str3);
                    }
                    i3++;
                    z = true;
                }
                if (z) {
                    com.uc.crashsdk.e.c();
                    if (com.uc.crashsdk.b.d) {
                        com.uc.crashsdk.JNIBridge.cmd(2);
                    }
                }
                boolean z4 = customInfo2.mPrintStackInfos;
                boolean z5 = customInfo.mPrintStackInfos;
                if (z4 != z5) {
                    customInfo2.mPrintStackInfos = z5;
                    if (com.uc.crashsdk.b.d) {
                        com.uc.crashsdk.JNIBridge.set(11, z5);
                    }
                    i3++;
                }
                boolean z6 = customInfo2.mDebug;
                boolean z7 = customInfo.mDebug;
                if (z6 != z7) {
                    customInfo2.mDebug = z7;
                    if (com.uc.crashsdk.b.d) {
                        com.uc.crashsdk.JNIBridge.set(18, z7);
                    }
                    i3++;
                }
                boolean z8 = customInfo2.mBackupLogs;
                boolean z9 = customInfo.mBackupLogs;
                if (z8 != z9) {
                    customInfo2.mBackupLogs = z9;
                    if (com.uc.crashsdk.b.d) {
                        com.uc.crashsdk.JNIBridge.set(12, z9);
                    }
                    i3++;
                }
                boolean z10 = customInfo2.mOmitNativeCrash;
                boolean z11 = customInfo.mOmitNativeCrash;
                if (z10 != z11) {
                    customInfo2.mOmitNativeCrash = z11;
                    if (com.uc.crashsdk.b.d) {
                        com.uc.crashsdk.JNIBridge.set(21, z11);
                    }
                    i3++;
                }
                int i4 = customInfo2.mCrashRestartInterval;
                int i5 = customInfo.mCrashRestartInterval;
                if (i4 != i5) {
                    customInfo2.mCrashRestartInterval = i5;
                    if (com.uc.crashsdk.b.d) {
                        com.uc.crashsdk.JNIBridge.set(13, i5);
                    }
                    if (customInfo2.mCrashRestartInterval >= 0) {
                        com.uc.crashsdk.b.M();
                    }
                    i3++;
                }
                int i6 = customInfo2.mMaxBuiltinLogFilesCount;
                int i7 = customInfo.mMaxBuiltinLogFilesCount;
                if (i6 != i7) {
                    customInfo2.mMaxBuiltinLogFilesCount = i7;
                    if (com.uc.crashsdk.b.d) {
                        com.uc.crashsdk.JNIBridge.set(14, i7);
                    }
                    i3++;
                }
                int i8 = customInfo2.mMaxNativeLogcatLineCount;
                int i9 = customInfo.mMaxNativeLogcatLineCount;
                if (i8 != i9) {
                    customInfo2.mMaxNativeLogcatLineCount = i9;
                    if (com.uc.crashsdk.b.d) {
                        com.uc.crashsdk.JNIBridge.set(15, i9);
                    }
                    i3++;
                }
                int i10 = customInfo2.mMaxJavaLogcatLineCount;
                int i11 = customInfo.mMaxJavaLogcatLineCount;
                if (i10 != i11) {
                    customInfo2.mMaxJavaLogcatLineCount = i11;
                    i3++;
                }
                int i12 = customInfo2.mMaxUnexpLogcatLineCount;
                int i13 = customInfo.mMaxUnexpLogcatLineCount;
                if (i12 != i13) {
                    customInfo2.mMaxUnexpLogcatLineCount = i13;
                    if (com.uc.crashsdk.b.d) {
                        com.uc.crashsdk.JNIBridge.set(16, i13);
                    }
                    i3++;
                }
                int i14 = customInfo2.mMaxAnrLogcatLineCount;
                int i15 = customInfo.mMaxAnrLogcatLineCount;
                if (i14 != i15) {
                    customInfo2.mMaxAnrLogcatLineCount = i15;
                    if (com.uc.crashsdk.b.d) {
                        com.uc.crashsdk.JNIBridge.set(31, i15);
                    }
                    i3++;
                }
                boolean z12 = customInfo2.mZipLog;
                boolean z13 = customInfo.mZipLog;
                if (z12 != z13) {
                    customInfo2.mZipLog = z13;
                    if (!z13) {
                        com.uc.crashsdk.a.a.d("DEBUG", "updateCustomInfoImpl set mZipLog to false");
                        a = new java.lang.RuntimeException("updateCustomInfoImpl set mZipLog to false");
                    }
                    i3++;
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (a(customInfo.mZippedLogExtension, customInfo2.mZippedLogExtension)) {
                    z3 = z2;
                } else {
                    customInfo2.mZippedLogExtension = customInfo.mZippedLogExtension;
                    i3++;
                }
                if (z3 && com.uc.crashsdk.b.d) {
                    com.uc.crashsdk.JNIBridge.nativeSet(3, customInfo2.mZipLog ? 1L : 0L, customInfo2.mZippedLogExtension, null);
                }
                int i16 = customInfo2.mLogMaxBytesLimit;
                int i17 = customInfo.mLogMaxBytesLimit;
                if (i16 != i17) {
                    customInfo2.mLogMaxBytesLimit = i17;
                    if (com.uc.crashsdk.b.d) {
                        com.uc.crashsdk.JNIBridge.set(4, i17);
                    }
                    i3++;
                }
                boolean z14 = customInfo2.mEncryptLog;
                boolean z15 = customInfo.mEncryptLog;
                if (z14 != z15) {
                    customInfo2.mEncryptLog = z15;
                    if (z15) {
                        com.uc.crashsdk.a.a.d("DEBUG", "updateCustomInfoImpl set mEncryptLog to true");
                        b = new java.lang.RuntimeException("updateCustomInfoImpl set mEncryptLog to true");
                    }
                    i3++;
                }
                boolean z16 = customInfo2.mSyncUploadSetupCrashLogs;
                boolean z17 = customInfo.mSyncUploadSetupCrashLogs;
                if (z16 != z17) {
                    customInfo2.mSyncUploadSetupCrashLogs = z17;
                    i3++;
                }
                boolean z18 = customInfo2.mSyncUploadLogs;
                boolean z19 = customInfo.mSyncUploadLogs;
                if (z18 != z19) {
                    customInfo2.mSyncUploadLogs = z19;
                    i3++;
                }
                int i18 = customInfo2.mMaxCustomLogFilesCount;
                int i19 = customInfo.mMaxCustomLogFilesCount;
                if (i18 != i19) {
                    customInfo2.mMaxCustomLogFilesCount = i19;
                    i3++;
                }
                boolean z20 = customInfo2.mOmitJavaCrash;
                boolean z21 = customInfo.mOmitJavaCrash;
                if (z20 != z21) {
                    customInfo2.mOmitJavaCrash = z21;
                    i3++;
                }
                int i20 = customInfo2.mLogMaxUploadBytesLimit;
                int i21 = customInfo.mLogMaxUploadBytesLimit;
                if (i20 != i21) {
                    customInfo2.mLogMaxUploadBytesLimit = i21;
                    i3++;
                }
                long j2 = customInfo2.mMaxUploadBytesPerDay;
                long j3 = customInfo.mMaxUploadBytesPerDay;
                if (j2 != j3) {
                    customInfo2.mMaxUploadBytesPerDay = j3;
                    i3++;
                }
                int i22 = customInfo2.mMaxUploadBuiltinLogCountPerDay;
                int i23 = customInfo.mMaxUploadBuiltinLogCountPerDay;
                if (i22 != i23) {
                    customInfo2.mMaxUploadBuiltinLogCountPerDay = i23;
                    i3++;
                }
                int i24 = customInfo2.mMaxUploadCustomLogCountPerDay;
                int i25 = customInfo.mMaxUploadCustomLogCountPerDay;
                if (i24 != i25) {
                    customInfo2.mMaxUploadCustomLogCountPerDay = i25;
                    i3++;
                }
                int i26 = customInfo2.mMaxCustomLogCountPerTypePerDay;
                int i27 = customInfo.mMaxCustomLogCountPerTypePerDay;
                if (i26 != i27) {
                    customInfo2.mMaxCustomLogCountPerTypePerDay = i27;
                    i3++;
                }
                int i28 = customInfo2.mMaxAnrLogCountPerProcess;
                int i29 = customInfo.mMaxAnrLogCountPerProcess;
                if (i28 != i29) {
                    customInfo2.mMaxAnrLogCountPerProcess = i29;
                    if (com.uc.crashsdk.b.d) {
                        com.uc.crashsdk.JNIBridge.set(32, d.mMaxAnrLogCountPerProcess);
                    }
                    i3++;
                }
                boolean z22 = customInfo2.mCallJavaDefaultHandler;
                boolean z23 = customInfo.mCallJavaDefaultHandler;
                if (z22 != z23) {
                    customInfo2.mCallJavaDefaultHandler = z23;
                    i3++;
                }
                boolean z24 = customInfo2.mEnableKillProcessAfterCrash;
                boolean z25 = customInfo.mEnableKillProcessAfterCrash;
                if (z24 != z25) {
                    customInfo2.mEnableKillProcessAfterCrash = z25;
                    i3++;
                }
                boolean z26 = customInfo2.mCallNativeDefaultHandler;
                boolean z27 = customInfo.mCallNativeDefaultHandler;
                if (z26 != z27) {
                    customInfo2.mCallNativeDefaultHandler = z27;
                    i3++;
                    if (com.uc.crashsdk.b.d) {
                        com.uc.crashsdk.JNIBridge.set(5, d.mCallNativeDefaultHandler);
                    }
                }
                boolean z28 = customInfo2.mDumpUserSolibBuildId;
                boolean z29 = customInfo.mDumpUserSolibBuildId;
                if (z28 != z29) {
                    customInfo2.mDumpUserSolibBuildId = z29;
                    i3++;
                    if (com.uc.crashsdk.b.d) {
                        com.uc.crashsdk.JNIBridge.set(6, d.mDumpUserSolibBuildId);
                    }
                }
                boolean z30 = customInfo2.mDumpHprofDataForJavaOOM;
                boolean z31 = customInfo.mDumpHprofDataForJavaOOM;
                if (z30 != z31) {
                    customInfo2.mDumpHprofDataForJavaOOM = z31;
                    i3++;
                }
                boolean z32 = customInfo2.mRenameFileToDefaultName;
                boolean z33 = customInfo.mRenameFileToDefaultName;
                if (z32 != z33) {
                    customInfo2.mRenameFileToDefaultName = z33;
                    i3++;
                }
                boolean z34 = customInfo2.mAutoDeleteOldVersionStats;
                boolean z35 = customInfo.mAutoDeleteOldVersionStats;
                if (z34 != z35) {
                    customInfo2.mAutoDeleteOldVersionStats = z35;
                    i3++;
                }
                int i30 = customInfo2.mFdDumpMinLimit;
                int i31 = customInfo.mFdDumpMinLimit;
                if (i30 != i31) {
                    customInfo2.mFdDumpMinLimit = i31;
                    if (com.uc.crashsdk.b.d) {
                        com.uc.crashsdk.JNIBridge.set(10, i31);
                    }
                    i3++;
                }
                int i32 = customInfo2.mThreadsDumpMinLimit;
                int i33 = customInfo.mThreadsDumpMinLimit;
                if (i32 != i33) {
                    customInfo2.mThreadsDumpMinLimit = i33;
                    if (com.uc.crashsdk.b.d) {
                        com.uc.crashsdk.JNIBridge.set(22, i33);
                    }
                    i3++;
                }
                int i34 = customInfo2.mInfoUpdateInterval;
                int i35 = customInfo.mInfoUpdateInterval;
                if (i34 != i35) {
                    if (i34 <= 0 && i35 > 0) {
                        com.uc.crashsdk.a.a(false);
                    }
                    customInfo2.mInfoUpdateInterval = customInfo.mInfoUpdateInterval;
                    i3++;
                }
                int i36 = customInfo2.mInfoSaveFrequency;
                int i37 = customInfo.mInfoSaveFrequency;
                if (i36 != i37) {
                    customInfo2.mInfoSaveFrequency = i37;
                    i3++;
                }
                long j4 = customInfo2.mDisableBackgroundSignals;
                long j5 = customInfo.mDisableBackgroundSignals;
                if (j4 != j5) {
                    customInfo2.mDisableBackgroundSignals = j5;
                    if (com.uc.crashsdk.b.d) {
                        com.uc.crashsdk.JNIBridge.set(9, j5);
                    }
                    i3++;
                }
                boolean z36 = customInfo2.mEnableStatReport;
                boolean z37 = customInfo.mEnableStatReport;
                if (z36 != z37) {
                    customInfo2.mEnableStatReport = z37;
                    if (z37) {
                        com.uc.crashsdk.e.B();
                    }
                    i3++;
                }
                boolean z38 = customInfo2.mEnableCrpStat;
                boolean z39 = customInfo.mEnableCrpStat;
                if (z38 != z39) {
                    customInfo2.mEnableCrpStat = z39;
                    i3++;
                }
                boolean z40 = customInfo2.mEnableStatToWPKDirect;
                boolean z41 = customInfo.mEnableStatToWPKDirect;
                if (z40 != z41) {
                    customInfo2.mEnableStatToWPKDirect = z41;
                    i3++;
                }
                boolean z42 = customInfo2.mIsInternational;
                boolean z43 = customInfo.mIsInternational;
                if (z42 != z43) {
                    customInfo2.mIsInternational = z43;
                    if (com.uc.crashsdk.b.d) {
                        com.uc.crashsdk.JNIBridge.set(23, z43);
                    }
                    com.uc.crashsdk.e.l();
                    com.uc.crashsdk.a.d.c();
                    com.uc.crashsdk.a.h.k();
                    i3++;
                }
                boolean z44 = customInfo2.mAutoDetectLifeCycle;
                boolean z45 = customInfo.mAutoDetectLifeCycle;
                if (z44 != z45) {
                    customInfo2.mAutoDetectLifeCycle = z45;
                    if (z45) {
                        com.uc.crashsdk.b.C();
                    }
                    i3++;
                }
                boolean z46 = customInfo2.mMonitorBattery;
                boolean z47 = customInfo.mMonitorBattery;
                if (z46 != z47) {
                    customInfo2.mMonitorBattery = z47;
                    com.uc.crashsdk.e.c(com.uc.crashsdk.b.B());
                    i3++;
                }
                int i38 = customInfo2.mUnexpSubTypes;
                int i39 = customInfo.mUnexpSubTypes;
                if (i38 != i39) {
                    customInfo2.mUnexpSubTypes = i39;
                    i3++;
                }
                boolean z48 = customInfo2.mEnableMemoryGroup;
                boolean z49 = customInfo.mEnableMemoryGroup;
                if (z48 != z49) {
                    customInfo2.mEnableMemoryGroup = z49;
                    if (com.uc.crashsdk.b.d) {
                        com.uc.crashsdk.JNIBridge.set(35, z49);
                    }
                    i3++;
                }
                boolean z50 = customInfo2.mEnableLibcMallocDetail;
                boolean z51 = customInfo.mEnableLibcMallocDetail;
                if (z50 != z51) {
                    customInfo2.mEnableLibcMallocDetail = z51;
                    if (com.uc.crashsdk.b.d) {
                        com.uc.crashsdk.JNIBridge.set(36, z51);
                    }
                    i3++;
                }
                java.lang.String str4 = customInfo2.mLibcMallocDetailConfig;
                java.lang.String str5 = customInfo.mLibcMallocDetailConfig;
                if (str4 != str5) {
                    customInfo2.mLibcMallocDetailConfig = str5;
                    if (com.uc.crashsdk.b.d) {
                        com.uc.crashsdk.JNIBridge.set(131, str5);
                    }
                    i3++;
                }
                if (!a(customInfo.mUserId, customInfo2.mUserId)) {
                    customInfo2.mUserId = customInfo.mUserId;
                    i3++;
                }
                if (!a(customInfo.mChannel, customInfo2.mChannel)) {
                    customInfo2.mChannel = customInfo.mChannel;
                    i3++;
                }
                if (!a(customInfo2.mCrashLogUploadUrl, customInfo.mCrashLogUploadUrl)) {
                    customInfo2.mCrashLogUploadUrl = customInfo.mCrashLogUploadUrl;
                    i3++;
                }
                if (!a(customInfo2.mCrashRateUploadUrl, customInfo.mCrashRateUploadUrl)) {
                    java.lang.String str6 = customInfo.mCrashRateUploadUrl;
                    customInfo2.mCrashRateUploadUrl = str6;
                    i3++;
                    if (com.uc.crashsdk.b.d) {
                        com.uc.crashsdk.JNIBridge.set(38, str6);
                    }
                }
                if (!a(customInfo2.mCrashSDKAuthUrl, customInfo.mCrashSDKAuthUrl)) {
                    java.lang.String str7 = customInfo.mCrashSDKAuthUrl;
                    customInfo2.mCrashSDKAuthUrl = str7;
                    i3++;
                    if (com.uc.crashsdk.b.d) {
                        com.uc.crashsdk.JNIBridge.set(39, str7);
                    }
                }
                i2 = i3;
            }
        }
        return i2;
    }

    public static void b() {
        com.uc.crashsdk.JNIBridge.set(103, com.uc.crashsdk.a.g.b());
        com.uc.crashsdk.JNIBridge.set(104, d.mTagFilesFolderName);
        com.uc.crashsdk.JNIBridge.set(105, d.mCrashLogsFolderName);
        com.uc.crashsdk.JNIBridge.set(106, Z());
        com.uc.crashsdk.JNIBridge.set(107, com.uc.crashsdk.e.h());
        com.uc.crashsdk.JNIBridge.set(108, com.uc.crashsdk.b.a());
        com.uc.crashsdk.JNIBridge.set(109, U());
        com.uc.crashsdk.JNIBridge.set(110, V());
        com.uc.crashsdk.JNIBridge.set(111, W());
        com.uc.crashsdk.JNIBridge.set(112, "240515102041");
        com.uc.crashsdk.JNIBridge.set(116, android.os.Build.MODEL);
        com.uc.crashsdk.JNIBridge.set(117, android.os.Build.VERSION.RELEASE);
        com.uc.crashsdk.JNIBridge.set(118, com.uc.crashsdk.e.q());
        com.uc.crashsdk.JNIBridge.set(5, d.mCallNativeDefaultHandler);
        com.uc.crashsdk.JNIBridge.set(6, d.mDumpUserSolibBuildId);
        com.uc.crashsdk.JNIBridge.set(7, d.mReservedNativeMemoryBytes);
        com.uc.crashsdk.JNIBridge.set(100, d.mNativeCrashLogFileName);
        com.uc.crashsdk.JNIBridge.set(101, d.mUnexpCrashLogFileName);
        com.uc.crashsdk.JNIBridge.set(35, d.mEnableMemoryGroup);
        com.uc.crashsdk.JNIBridge.set(36, d.mEnableLibcMallocDetail);
        com.uc.crashsdk.JNIBridge.set(131, d.mLibcMallocDetailConfig);
        com.uc.crashsdk.JNIBridge.set(102, d.mAppId);
        com.uc.crashsdk.JNIBridge.set(38, d.mCrashRateUploadUrl);
        com.uc.crashsdk.JNIBridge.set(39, d.mCrashSDKAuthUrl);
    }

    public static void c() {
        com.uc.crashsdk.JNIBridge.set(11, Q());
        com.uc.crashsdk.JNIBridge.set(12, d.mBackupLogs);
        com.uc.crashsdk.JNIBridge.set(13, d.mCrashRestartInterval);
        com.uc.crashsdk.JNIBridge.set(14, d.mMaxBuiltinLogFilesCount);
        com.uc.crashsdk.JNIBridge.set(15, d.mMaxNativeLogcatLineCount);
        com.uc.crashsdk.JNIBridge.set(16, d.mMaxUnexpLogcatLineCount);
        com.uc.crashsdk.JNIBridge.set(31, d.mMaxAnrLogcatLineCount);
        com.uc.crashsdk.JNIBridge.set(18, P());
        com.uc.crashsdk.JNIBridge.set(20, android.os.Build.VERSION.SDK_INT);
        com.uc.crashsdk.JNIBridge.set(21, d.mOmitNativeCrash);
        com.uc.crashsdk.JNIBridge.set(32, d.mMaxAnrLogCountPerProcess);
        com.uc.crashsdk.JNIBridge.set(8, d.mDisableSignals);
        com.uc.crashsdk.JNIBridge.set(9, d.mDisableBackgroundSignals);
        com.uc.crashsdk.export.CustomInfo customInfo = d;
        com.uc.crashsdk.JNIBridge.nativeSet(3, customInfo.mZipLog ? 1L : 0L, customInfo.mZippedLogExtension, null);
        com.uc.crashsdk.JNIBridge.set(4, d.mLogMaxBytesLimit);
        com.uc.crashsdk.JNIBridge.set(119, android.os.Build.FINGERPRINT);
    }

    private static void c(com.uc.crashsdk.export.CustomInfo customInfo) {
        if (customInfo.mZippedLogExtension == null) {
            customInfo.mZippedLogExtension = "";
        }
        if (customInfo.mZippedLogExtension.equals(com.baidu.mobads.sdk.internal.al.k)) {
            throw new java.lang.IllegalArgumentException("mZippedLogExtension can not be '.tmp'!");
        }
        if (customInfo.mOmitJavaCrash) {
            customInfo.mCallJavaDefaultHandler = false;
        }
        if (customInfo.mOmitNativeCrash) {
            customInfo.mCallNativeDefaultHandler = false;
        }
        long b2 = com.uc.crashsdk.e.b();
        if (b2 >= 1) {
            customInfo.mMaxBuiltinLogFilesCount = 200;
            customInfo.mMaxCustomLogFilesCount = 100;
            customInfo.mMaxUploadBytesPerDay = 268435456L;
            customInfo.mMaxUploadBuiltinLogCountPerDay = 2000;
            customInfo.mMaxUploadCustomLogCountPerDay = 2000;
            customInfo.mMaxCustomLogCountPerTypePerDay = 100;
            customInfo.mMaxAnrLogCountPerProcess = 100;
            customInfo.mAnrTraceStrategy = 2;
            if (b2 >= 2) {
                customInfo.mSyncUploadSetupCrashLogs = true;
                customInfo.mSyncUploadLogs = true;
                if (b2 >= 3) {
                    customInfo.mBackupLogs = true;
                    customInfo.mPrintStackInfos = true;
                    customInfo.mDebug = true;
                }
            }
        }
    }

    public static void d() {
        com.uc.crashsdk.JNIBridge.set(23, d.mIsInternational);
        if (com.uc.crashsdk.b.H()) {
            com.uc.crashsdk.JNIBridge.set(34, true);
        }
        if (com.uc.crashsdk.e.i()) {
            com.uc.crashsdk.JNIBridge.set(1, true);
        }
        com.uc.crashsdk.JNIBridge.set(10, d.mFdDumpMinLimit);
        com.uc.crashsdk.JNIBridge.nativeCmd(3, d.mReservedNativeFileHandleCount, null, null);
        com.uc.crashsdk.JNIBridge.nativeSetForeground(com.uc.crashsdk.b.B());
        com.uc.crashsdk.JNIBridge.set(2, com.uc.crashsdk.b.F());
        com.uc.crashsdk.a.e();
        com.uc.crashsdk.a.g();
        com.uc.crashsdk.a.i();
        com.uc.crashsdk.a.k();
        com.uc.crashsdk.JNIBridge.set(113, com.uc.crashsdk.a.a);
        com.uc.crashsdk.JNIBridge.cmd(1);
        com.uc.crashsdk.JNIBridge.set(22, d.mThreadsDumpMinLimit);
        com.uc.crashsdk.JNIBridge.set(122, com.uc.crashsdk.a.a());
        com.uc.crashsdk.JNIBridge.set(33, com.uc.crashsdk.a.c());
        af();
        com.uc.crashsdk.b.K();
        com.uc.crashsdk.b.D();
        com.uc.crashsdk.a.g.k();
    }

    public static java.lang.String e() {
        return d.mAppId;
    }

    public static boolean f() {
        if (com.uc.crashsdk.a.g.b(d.mJavaCrashLogFileName) || com.uc.crashsdk.a.g.b(d.mNativeCrashLogFileName)) {
            return true;
        }
        return com.uc.crashsdk.a.g.b(d.mUnexpCrashLogFileName);
    }

    public static java.lang.String g() {
        return d.mJavaCrashLogFileName;
    }

    public static int h() {
        return d.mCrashRestartInterval;
    }

    public static boolean i() {
        return d.mCallJavaDefaultHandler;
    }

    public static boolean j() {
        return d.mEnableKillProcessAfterCrash;
    }

    public static boolean k() {
        return d.mDumpHprofDataForJavaOOM;
    }

    public static boolean l() {
        return d.mRenameFileToDefaultName;
    }

    public static int m() {
        return d.mMaxBuiltinLogFilesCount;
    }

    public static int n() {
        return d.mMaxCustomLogFilesCount;
    }

    public static int o() {
        return d.mMaxJavaLogcatLineCount;
    }

    public static int p() {
        return d.mUnexpDelayMillSeconds;
    }

    public static int q() {
        return d.mUnexpSubTypes;
    }

    public static boolean r() {
        return d.mBackupLogs;
    }

    public static boolean s() {
        return d.mSyncUploadSetupCrashLogs;
    }

    public static boolean t() {
        return d.mSyncUploadLogs;
    }

    public static boolean u() {
        return d.mOmitJavaCrash;
    }

    public static boolean v() {
        return d.mAutoDeleteOldVersionStats;
    }

    public static boolean w() {
        return d.mZipLog;
    }

    public static java.lang.String x() {
        return d.mZippedLogExtension;
    }

    public static boolean y() {
        return d.mEncryptLog;
    }

    public static java.lang.String z() {
        return d.mCrashLogUploadUrl;
    }
}
