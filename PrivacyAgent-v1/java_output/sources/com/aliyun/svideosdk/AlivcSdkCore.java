package com.aliyun.svideosdk;

/* loaded from: classes12.dex */
public class AlivcSdkCore {
    private static final java.lang.String TAG = "AlivcSdkCore";
    protected static long mNativeHandle;
    private static com.aliyun.svideosdk.b.a mReporter;
    private static com.aliyun.svideosdk.AlivcSdkCore.AlivcDebugLoggerLevel sDebugLoggerLevel = com.aliyun.svideosdk.AlivcSdkCore.AlivcDebugLoggerLevel.AlivcDLNormal;
    private static com.aliyun.svideosdk.AlivcSdkCore.AlivcLogLevel mLogLevel = com.aliyun.svideosdk.AlivcSdkCore.AlivcLogLevel.AlivcLogWarn;
    public static java.lang.String APP_PRIVATE_DIR = null;
    public static java.lang.String APP_PUBLIC_DIR = android.os.Environment.getExternalStorageDirectory().getAbsolutePath();

    /* renamed from: com.aliyun.svideosdk.AlivcSdkCore$1, reason: invalid class name */
    public static class AnonymousClass1 implements java.lang.Runnable {
        final /* synthetic */ com.aliyun.svideosdk.license.ILicenseNativeInitCallback val$callback;
        final /* synthetic */ android.content.Context val$context;

        public AnonymousClass1(android.content.Context context, com.aliyun.svideosdk.license.ILicenseNativeInitCallback iLicenseNativeInitCallback) {
            this.val$context = context;
            this.val$callback = iLicenseNativeInitCallback;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.aliyun.svideosdk.AlivcSdkCore.initLicense(this.val$context, this.val$callback);
        }
    }

    public enum AlivcDebugLoggerLevel {
        AlivcDLClose(1),
        AlivcDLNormal(2),
        AlivcDLAll(3);

        int value;

        AlivcDebugLoggerLevel(int i) {
            this.value = i;
        }

        public int getValue() {
            return this.value;
        }
    }

    public enum AlivcLogLevel {
        AlivcLogClose(1),
        AlivcLogVerbose(2),
        AlivcLogDebug(3),
        AlivcLogInfo(4),
        AlivcLogWarn(5),
        AlivcLogError(6),
        AlivcLogFatal(7);

        int value;

        AlivcLogLevel(int i) {
            this.value = i;
        }

        public int getValue() {
            return this.value;
        }
    }

    @java.lang.Deprecated
    public static com.aliyun.svideosdk.AlivcSdkCore.AlivcDebugLoggerLevel getDebugLoggerLevel() {
        return sDebugLoggerLevel;
    }

    public static com.aliyun.svideosdk.AlivcSdkCore.AlivcLogLevel getLogLevel() {
        return mLogLevel;
    }

    private static void initInner(android.content.Context context, com.aliyun.svideosdk.common.AlivcSdkConfig alivcSdkConfig) {
        java.io.File externalFilesDir;
        APP_PRIVATE_DIR = context.getDir("svideo_libs", 0).getAbsolutePath();
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("register, APP_PRIVATE_DIR = ");
        sb.append(APP_PRIVATE_DIR);
        if (com.aliyun.common.utils.CommonUtil.isReadWrite() && (externalFilesDir = context.getExternalFilesDir(null)) != null) {
            APP_PUBLIC_DIR = externalFilesDir.getAbsolutePath();
        }
        java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
        sb2.append("register, APP_PUBLIC_DIR = ");
        sb2.append(APP_PUBLIC_DIR);
        com.aliyun.common.utils.MySystemParams.getInstance().init(context);
        com.aliyun.svideosdk.nativeload.AbstractNativeLoader.loadLibrary();
        if (mNativeHandle == 0) {
            setSdkInfo(context);
            if (mReporter == null) {
                mReporter = new com.aliyun.svideosdk.b.a(context);
            }
            long nativeInit = nativeInit(APP_PUBLIC_DIR, alivcSdkConfig.isCrashOn(), mReporter.a());
            mNativeHandle = nativeInit;
            mReporter.a(nativeInit != 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean initLicense(android.content.Context context, com.aliyun.svideosdk.license.ILicenseNativeInitCallback iLicenseNativeInitCallback) {
        long j;
        android.content.pm.ApplicationInfo applicationInfo;
        if (context == null) {
            return false;
        }
        try {
            j = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).firstInstallTime;
        } catch (android.content.pm.PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            j = 0;
        }
        long j2 = j;
        try {
            applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
        } catch (android.content.pm.PackageManager.NameNotFoundException e2) {
            e2.printStackTrace();
            applicationInfo = null;
        }
        if (applicationInfo == null) {
            return false;
        }
        java.lang.String string = applicationInfo.metaData.getString("com.aliyun.alivc_license.licensekey");
        java.lang.String string2 = applicationInfo.metaData.getString("com.aliyun.alivc_license.licensefile");
        java.lang.String packageName = context.getPackageName();
        boolean nativeSetUpLicense = nativeSetUpLicense(context, com.aliyun.common.global.Version.VERSION, com.aliyun.svideosdk.project.aliyunnative.BuildConfig.LICENSE_VERSION_CODE.intValue(), packageName, com.aliyun.common.utils.SignatureUtils.getSingInfo(context), context.getExternalCacheDir().getAbsolutePath(), j2, string, string2, context.getAssets(), com.aliyun.svideosdk.license.LicenseManager.getInstance().setCallback(iLicenseNativeInitCallback));
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("packageName = ");
        sb.append(packageName);
        return nativeSetUpLicense;
    }

    private static native long nativeInit(java.lang.String str, boolean z, long j);

    private static native void nativeSetDLLevel(int i);

    private static native void nativeSetLogLevel(int i);

    private static native void nativeSetLogPath(java.lang.String str);

    private static native void nativeSetSdkInfo(java.lang.String str, java.lang.String str2);

    private static native boolean nativeSetUpLicense(java.lang.Object obj, java.lang.String str, int i, java.lang.String str2, java.lang.String str3, java.lang.String str4, long j, java.lang.String str5, java.lang.String str6, java.lang.Object obj2, java.lang.Object obj3);

    private static native void nativeUnInit(long j);

    public static boolean register(android.content.Context context) {
        return register(context, new com.aliyun.svideosdk.common.AlivcSdkConfig());
    }

    public static boolean register(android.content.Context context, com.aliyun.svideosdk.common.AlivcSdkConfig alivcSdkConfig) {
        initInner(context, alivcSdkConfig);
        return initLicense(context, null);
    }

    public static void registerAsync(android.content.Context context, com.aliyun.svideosdk.common.AlivcSdkConfig alivcSdkConfig, com.aliyun.svideosdk.license.ILicenseNativeInitCallback iLicenseNativeInitCallback) {
        initInner(context, alivcSdkConfig);
        com.aliyun.common.utils.ThreadUtils.runOnSubThread(new com.aliyun.svideosdk.AlivcSdkCore.AnonymousClass1(context, iLicenseNativeInitCallback));
    }

    @java.lang.Deprecated
    public static void setDebugLoggerLevel(com.aliyun.svideosdk.AlivcSdkCore.AlivcDebugLoggerLevel alivcDebugLoggerLevel) {
        sDebugLoggerLevel = alivcDebugLoggerLevel;
        nativeSetDLLevel(alivcDebugLoggerLevel.getValue());
    }

    public static void setLogLevel(com.aliyun.svideosdk.AlivcSdkCore.AlivcLogLevel alivcLogLevel) {
        mLogLevel = alivcLogLevel;
        nativeSetLogLevel(alivcLogLevel.getValue());
    }

    public static void setLogPath(java.lang.String str) {
        java.lang.StringBuilder sb;
        java.lang.String str2 = "setLogPath failed!! path = ";
        if (!android.text.TextUtils.isEmpty(str)) {
            java.io.File file = new java.io.File(str);
            if (!file.exists()) {
                try {
                    if (!file.mkdirs()) {
                        java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
                        sb2.append("setLogPath mkdirs failed!!path = ");
                        sb2.append(str);
                        return;
                    }
                } catch (java.lang.Exception unused) {
                    sb = new java.lang.StringBuilder();
                }
            } else if (!file.isDirectory()) {
                sb = new java.lang.StringBuilder();
                str2 = "setLogPath failed, your path is an exist file !! path = ";
            }
            nativeSetLogPath(str);
            return;
        }
        sb = new java.lang.StringBuilder();
        sb.append(str2);
        sb.append(str);
    }

    private static native void setNativeDebugParams(int i);

    private static void setSdkInfo(android.content.Context context) {
        nativeSetSdkInfo("sty", "svideo_pro");
        nativeSetSdkInfo("svr", com.aliyun.common.global.Version.VERSION);
        nativeSetSdkInfo("sbi", com.aliyun.common.global.Version.BUILD_ID);
        nativeSetSdkInfo("sbt", com.aliyun.common.global.Version.BUILD_TIME);
        nativeSetSdkInfo("pkg", context.getPackageName());
        nativeSetSdkInfo("pvr", com.aliyun.common.utils.ManifestUtils.getVersionName(context));
        nativeSetSdkInfo("uid", com.aliyun.common.utils.UuidUtil.getUUID());
    }

    public static void unregister() {
        long j = mNativeHandle;
        if (j != 0) {
            nativeUnInit(j);
            mNativeHandle = 0L;
        }
        com.aliyun.svideosdk.b.a aVar = mReporter;
        if (aVar != null) {
            aVar.b();
            mReporter = null;
        }
    }
}
