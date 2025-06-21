package com.umeng.umcrash;

/* loaded from: classes19.dex */
public class UMCrash {
    private static final long DEFAULT_PA_TIMEOUT_TIME = 2000;
    private static final boolean DEFAULT_VALUE_CODE_LOG = true;
    private static final boolean DEFAULT_VALUE_CRASH_ANR = true;
    private static final boolean DEFAULT_VALUE_CRASH_JAVA = true;
    private static final boolean DEFAULT_VALUE_CRASH_NATIVE = true;
    private static final boolean DEFAULT_VALUE_CRASH_UNEXP = false;
    private static final boolean DEFAULT_VALUE_FLUTTER = true;
    private static final boolean DEFAULT_VALUE_H5PAGE = true;
    private static final boolean DEFAULT_VALUE_LAUNCH = true;
    private static final boolean DEFAULT_VALUE_MEM = true;
    private static final boolean DEFAULT_VALUE_NET = true;
    private static final boolean DEFAULT_VALUE_PA = true;
    private static final boolean DEFAULT_VALUE_PAGE = true;
    private static final boolean DEFAULT_VALUE_POWER = true;
    private static final java.lang.String INTEGRATIONTESTING_SP = "itconfig";
    private static final java.lang.String IT_DEBUGKEY = "apm_debugkey";
    private static final java.lang.String IT_SENDAGING = "apm_sendaging";
    private static final java.lang.String KEY_ACTIITY_ON_CREATED = "onCreated";
    private static final java.lang.String KEY_ACTIITY_ON_DESTROYED = "onDestroyed";
    private static final java.lang.String KEY_ACTIITY_ON_PAUSED = "onPaused";
    private static final java.lang.String KEY_ACTIITY_ON_RESUMED = "onResumed";
    private static final java.lang.String KEY_ACTIITY_ON_STARTED = "onStarted";
    private static final java.lang.String KEY_ACTIITY_ON_STOPPED = "onStopped";
    public static final java.lang.String KEY_APM_DEFAULT_SECRET = "NEej8y@anWa*8hep";
    public static final java.lang.String KEY_APM_ROOT_NAME = "UApm";
    public static final java.lang.String KEY_CALLBACK_CUSTOM_LOG = "um_custom_log";
    public static final java.lang.String KEY_CALLBACK_CUSTOM_MAPPING = "um_custom_mapping";
    public static final java.lang.String KEY_CALLBACK_PAGE_ACTION = "um_action_log";
    public static final java.lang.String KEY_CALLBACK_SESSION_ID = "um_session_id";
    public static final java.lang.String KEY_CALLBACK_UMID = "um_umid";
    public static final java.lang.String KEY_CALLBACK_UM_INFOS = "um_infos:";
    private static final java.lang.String KEY_CALLBACK_USER_STRING = "um_user_string";
    private static final java.lang.String KEY_CALLBACK_USER_STRING_ANR = "um_user_str_anr:";
    private static final java.lang.String KEY_CALLBACK_USER_STRING_CUSTOM_LOG = "um_user_str_custom_log:";
    private static final java.lang.String KEY_CALLBACK_USER_STRING_JAVA = "um_user_str_java:";
    private static final java.lang.String KEY_CALLBACK_USER_STRING_NATIVE = "um_user_str_native:";
    public static final java.lang.String KEY_DEBUGKEY = "um_dk";
    public static final java.lang.String KEY_ENABLE_ANR = "enableANRLog";
    public static final java.lang.String KEY_ENABLE_CODE_LOG = "enableCodeLog";
    public static final java.lang.String KEY_ENABLE_CRASH_JAVA = "enableJavaLog";
    public static final java.lang.String KEY_ENABLE_CRASH_NATIVE = "enableNativeLog";
    public static final java.lang.String KEY_ENABLE_CRASH_UNEXP = "enableUnexpLog";
    public static final java.lang.String KEY_ENABLE_FLUTTER = "enableFlutterLog";
    public static final java.lang.String KEY_ENABLE_H5PAGE = "enableH5PageLog";
    public static final java.lang.String KEY_ENABLE_LAUNCH = "enableLaunchLog";
    public static final java.lang.String KEY_ENABLE_MEM = "enableMemLog";
    public static final java.lang.String KEY_ENABLE_NET = "enableNetLog";
    public static final java.lang.String KEY_ENABLE_PA = "enablePaLog";
    public static final java.lang.String KEY_ENABLE_PAGE = "enablePageLog";
    public static final java.lang.String KEY_ENABLE_POWER = "enablePowerLog";
    public static final java.lang.String KEY_HEADER_ACCESS = "um_access";
    public static final java.lang.String KEY_HEADER_ACCESS_SUBTYPE = "um_access_subtype";
    public static final java.lang.String KEY_HEADER_APPKEY = "um_app_key";
    public static final java.lang.String KEY_HEADER_BESRIAL = "um_bserial";
    public static final java.lang.String KEY_HEADER_BSVER = "um_bsver";
    public static final java.lang.String KEY_HEADER_BVER = "um_bver";
    public static final java.lang.String KEY_HEADER_CARRIER = "um_app_carrier";
    public static final java.lang.String KEY_HEADER_CHANNEL = "um_app_channel";
    public static final java.lang.String KEY_HEADER_CRASH_VERSION = "um_crash_sdk_version";
    public static final java.lang.String KEY_HEADER_DEBUGKEY = "um_dk";
    public static final java.lang.String KEY_HEADER_NETWORK_TYPE = "um_network_type";
    public static final java.lang.String KEY_HEADER_OS = "um_os";
    public static final java.lang.String KEY_HEADER_PROVIDER = "um_app_provider";
    public static final java.lang.String KEY_HEADER_PUID = "um_app_puid";
    public static final java.lang.String KEY_HEADER_START_TIME = "um_app_start_time";
    public static final java.lang.String KEY_HEADER_UMID = "um_umid_header";
    public static final java.lang.String KEY_LOG_DEVICES_ID = "log_devices_id";
    public static final java.lang.String KEY_LOG_USER_ID = "log_user_id";
    private static final int KEY_MAX_LENGTH = 20480;
    private static final int KEY_MAX_LENGTH_128 = 128;
    public static final java.lang.String KEY_PA_TIMEOUT_TIME = "pa_timeout_time";
    public static final java.lang.String SP_KEY_DEBUG = "debugkey";
    public static final java.lang.String SP_KEY_TIMESTAMP = "timestamp";
    private static final java.lang.String TAG = "UMCrash";
    private static java.lang.String crashSdkVersion = "1.9.13";
    private static boolean isBuildId = true;
    private static boolean isDebug = true;
    private static boolean isEncrypt = false;
    private static boolean isIntl = false;
    private static boolean isZip = true;
    private static android.content.Context mContext = null;
    private static com.umeng.umcrash.UMCrashCallback mUMCrashCallback = null;
    private static com.umeng.umcrash.IUMCrashCallbackWithType mUMCrashCallbackWithType = null;
    private static boolean sIsEnableLogBackup = false;
    private static boolean sIsKillProcessAfterCrash = true;
    public static com.efs.sdk.base.EfsReporter sReporter;
    private static java.lang.String userBesrial;
    private static java.lang.String userBsver;
    private static java.lang.String userBver;
    private static java.lang.Object pageArrayLock = new java.lang.Object();
    private static java.util.ArrayList<java.lang.String> mArrayList = new java.util.ArrayList<>(10);
    private static boolean isCodeLog = false;
    private static int sApmCallbackLimit = 0;
    private static boolean isPA = false;
    private static boolean isLa = false;
    private static boolean isNet = false;
    private static boolean isPage = false;
    private static boolean isPower = false;
    private static boolean isFlutter = false;
    private static boolean enableJavaLog = true;
    private static boolean enableNativeLog = true;
    private static boolean enableANRLog = true;
    private static boolean enablePaLog = true;
    private static boolean enableLaunchLog = true;
    private static boolean enableMemLog = true;
    private static boolean enableNetLog = true;
    private static boolean enableH5PageLog = true;
    private static boolean enablePageLog = true;
    private static boolean enableCodeLog = true;
    private static boolean enablePowerLog = true;
    private static boolean enableFlutterLog = true;
    private static long paTimeoutTime = 2000;
    private static int index = 0;
    private static boolean isOpenUserCrash = true;
    private static boolean isUploadNowUserCrash = false;
    private static java.util.Map<java.lang.String, java.lang.String> sCustomInfo = new java.util.concurrent.ConcurrentHashMap();

    /* renamed from: com.umeng.umcrash.UMCrash$1, reason: invalid class name */
    public static class AnonymousClass1 implements java.lang.Runnable {
        final /* synthetic */ android.content.Context val$context;

        /* renamed from: com.umeng.umcrash.UMCrash$1$1, reason: invalid class name and collision with other inner class name */
        public class C05291 implements com.umeng.commonsdk.statistics.internal.UMImprintChangeCallback {
            public C05291() {
            }

            @Override // com.umeng.commonsdk.statistics.internal.UMImprintChangeCallback
            public void onImprintValueChanged(java.lang.String str, java.lang.String str2) {
                try {
                    if (android.text.TextUtils.isEmpty(str) || !com.umeng.umcrash.UMCrashContent.KEY_APM_CTR_FLAG.equals(str)) {
                        return;
                    }
                    if (com.umeng.umcrash.UMCrash.isDebug) {
                        java.lang.String unused = com.umeng.umcrash.UMCrash.TAG;
                        java.lang.StringBuilder sb = new java.lang.StringBuilder();
                        sb.append("common callback. apm ctr flag is ");
                        sb.append(str2);
                    }
                    com.umeng.umcrash.UMCrashUtils.saveInnerConfig(com.umeng.umcrash.UMCrash.AnonymousClass1.this.val$context.getApplicationContext(), str, str2);
                } catch (java.lang.Throwable th) {
                    th.printStackTrace();
                }
            }
        }

        public AnonymousClass1(android.content.Context context) {
            this.val$context = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                com.umeng.commonsdk.statistics.idtracking.ImprintHandler.getImprintService(com.umeng.umcrash.UMCrash.mContext).registImprintCallback(com.umeng.umcrash.UMCrashContent.KEY_APM_CTR_FLAG, new com.umeng.umcrash.UMCrash.AnonymousClass1.C05291());
                java.lang.String imprintProperty = com.umeng.commonsdk.framework.UMEnvelopeBuild.imprintProperty(com.umeng.umcrash.UMCrash.mContext, com.umeng.umcrash.UMCrashContent.KEY_APM_CTR_FLAG, "0");
                if (com.umeng.umcrash.UMCrash.isDebug) {
                    java.lang.String unused = com.umeng.umcrash.UMCrash.TAG;
                    java.lang.StringBuilder sb = new java.lang.StringBuilder();
                    sb.append("get common. apm ctr flag is ");
                    sb.append(imprintProperty);
                }
                if (imprintProperty == null || android.text.TextUtils.isEmpty(imprintProperty)) {
                    return;
                }
                com.umeng.umcrash.UMCrashUtils.saveInnerConfig(this.val$context.getApplicationContext(), com.umeng.umcrash.UMCrashContent.KEY_APM_CTR_FLAG, imprintProperty);
            } catch (java.lang.Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* renamed from: com.umeng.umcrash.UMCrash$2, reason: invalid class name */
    public static class AnonymousClass2 implements android.app.Application.ActivityLifecycleCallbacks {
        final /* synthetic */ java.lang.String val$appkey;
        final /* synthetic */ android.content.SharedPreferences val$sharedPreferences;

        public AnonymousClass2(java.lang.String str, android.content.SharedPreferences sharedPreferences) {
            this.val$appkey = str;
            this.val$sharedPreferences = sharedPreferences;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(android.app.Activity activity, android.os.Bundle bundle) {
            android.content.Intent intent;
            android.net.Uri data;
            java.lang.String scheme;
            long j;
            com.umeng.umcrash.UMCrash.saveActivityState(activity.getClass().getName(), com.umeng.umcrash.UMCrash.KEY_ACTIITY_ON_CREATED);
            if (com.umeng.umcrash.UMCrash.index != 0 || (intent = activity.getIntent()) == null || (data = intent.getData()) == null || (scheme = data.getScheme()) == null || scheme.isEmpty()) {
                return;
            }
            if (scheme.contains("um." + this.val$appkey)) {
                java.util.Set<java.lang.String> queryParameterNames = data.getQueryParameterNames();
                if (queryParameterNames.contains(com.umeng.umcrash.UMCrash.IT_DEBUGKEY) && queryParameterNames.contains(com.umeng.umcrash.UMCrash.IT_SENDAGING)) {
                    java.lang.String queryParameter = data.getQueryParameter(com.umeng.umcrash.UMCrash.IT_DEBUGKEY);
                    try {
                        j = java.lang.Long.parseLong(data.getQueryParameter(com.umeng.umcrash.UMCrash.IT_SENDAGING));
                    } catch (java.lang.NumberFormatException unused) {
                        j = 0;
                    }
                    if (j < 0) {
                        this.val$sharedPreferences.edit().clear().apply();
                        com.efs.sdk.base.integrationtesting.IntegrationTestingUtil.setIntegrationTestingInPeriod(false);
                        return;
                    }
                    if (j > 6) {
                        j = 6;
                    }
                    this.val$sharedPreferences.edit().putString("debugkey", queryParameter).apply();
                    this.val$sharedPreferences.edit().putLong("timestamp", java.lang.System.currentTimeMillis() + (j * 60 * 60 * 1000)).apply();
                    com.umeng.umcrash.UMCrashUtils.setIntegrationTesingParams(queryParameter);
                    com.efs.sdk.base.integrationtesting.IntegrationTestingUtil.setIntegrationTestingInPeriod(true);
                }
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(android.app.Activity activity) {
            com.umeng.umcrash.UMCrash.saveActivityState(activity.getClass().getName(), com.umeng.umcrash.UMCrash.KEY_ACTIITY_ON_DESTROYED);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(android.app.Activity activity) {
            com.umeng.umcrash.UMCrash.saveActivityState(activity.getClass().getName(), com.umeng.umcrash.UMCrash.KEY_ACTIITY_ON_PAUSED);
            com.umeng.umcrash.UMCrash.access$1210();
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(android.app.Activity activity) {
            com.umeng.umcrash.UMCrash.saveActivityState(activity.getClass().getName(), com.umeng.umcrash.UMCrash.KEY_ACTIITY_ON_RESUMED);
            com.efs.sdk.memoryinfo.UMMemoryMonitor.get().onActivityResumed(activity);
            com.umeng.powersdk.PowerManager.onActivityResumed(activity);
            com.umeng.umcrash.UMCrash.access$1208();
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(android.app.Activity activity, android.os.Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(android.app.Activity activity) {
            com.umeng.umcrash.UMCrash.saveActivityState(activity.getClass().getName(), com.umeng.umcrash.UMCrash.KEY_ACTIITY_ON_STARTED);
            com.efs.sdk.memoryinfo.UMMemoryMonitor.get().onActivityStarted(activity);
            com.umeng.powersdk.PowerManager.onActivityStarted(activity);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(android.app.Activity activity) {
            com.umeng.umcrash.UMCrash.saveActivityState(activity.getClass().getName(), com.umeng.umcrash.UMCrash.KEY_ACTIITY_ON_STOPPED);
            com.efs.sdk.memoryinfo.UMMemoryMonitor.get().onActivityStopped(activity);
            com.umeng.powersdk.PowerManager.onActivityStopped(activity);
        }
    }

    /* renamed from: com.umeng.umcrash.UMCrash$3, reason: invalid class name */
    public static class AnonymousClass3 implements java.lang.Runnable {
        final /* synthetic */ android.content.Context val$context;
        final /* synthetic */ com.uc.crashsdk.export.CrashApi val$mCrashApi;

        public AnonymousClass3(android.content.Context context, com.uc.crashsdk.export.CrashApi crashApi) {
            this.val$context = context;
            this.val$mCrashApi = crashApi;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                java.lang.String[] networkAccessMode = com.efs.sdk.base.core.util.NetworkUtil.getNetworkAccessMode(this.val$context);
                if ("Wi-Fi".equals(networkAccessMode[0])) {
                    this.val$mCrashApi.addHeaderInfo(com.umeng.umcrash.UMCrash.KEY_HEADER_ACCESS, com.efs.sdk.base.core.util.NetworkUtil.NETWORK_TYPE_WIFI);
                } else if ("2G/3G".equals(networkAccessMode[0])) {
                    this.val$mCrashApi.addHeaderInfo(com.umeng.umcrash.UMCrash.KEY_HEADER_ACCESS, "2G/3G");
                } else {
                    this.val$mCrashApi.addHeaderInfo(com.umeng.umcrash.UMCrash.KEY_HEADER_ACCESS, "unknow");
                }
                if ("".equals(networkAccessMode[1])) {
                    return;
                }
                this.val$mCrashApi.addHeaderInfo(com.umeng.umcrash.UMCrash.KEY_HEADER_ACCESS_SUBTYPE, networkAccessMode[1]);
            } catch (java.lang.Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* renamed from: com.umeng.umcrash.UMCrash$4, reason: invalid class name */
    public static class AnonymousClass4 implements java.lang.Runnable {
        final /* synthetic */ android.content.Context val$context;

        /* renamed from: com.umeng.umcrash.UMCrash$4$1, reason: invalid class name */
        public class AnonymousClass1 implements com.efs.sdk.pa.config.IEfsReporter {
            public AnonymousClass1() {
            }

            @Override // com.efs.sdk.pa.config.IEfsReporter
            public com.efs.sdk.base.EfsReporter getReporter() {
                return com.umeng.umcrash.UMCrash.sReporter;
            }
        }

        public AnonymousClass4(android.content.Context context) {
            this.val$context = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                com.efs.sdk.pa.PAFactory.Builder builder = new com.efs.sdk.pa.PAFactory.Builder(this.val$context.getApplicationContext(), new com.umeng.umcrash.UMCrash.AnonymousClass4.AnonymousClass1());
                builder.packageLevel(com.efs.sdk.pa.config.PackageLevel.RELEASE);
                builder.timeoutTime(com.umeng.umcrash.UMCrash.paTimeoutTime);
                builder.setPaClient(new com.umeng.umcrash.UMCrash.PaClientImpl(null));
                com.efs.sdk.pa.PAFactory build = builder.build();
                build.getPaInstance().start();
                boolean unused = com.umeng.umcrash.UMCrash.isPA = build.getConfigManager().enableTracer();
            } catch (java.lang.Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* renamed from: com.umeng.umcrash.UMCrash$5, reason: invalid class name */
    public static class AnonymousClass5 implements com.umeng.commonsdk.statistics.internal.UMImprintChangeCallback {
        final /* synthetic */ android.content.Context val$context;

        public AnonymousClass5(android.content.Context context) {
            this.val$context = context;
        }

        @Override // com.umeng.commonsdk.statistics.internal.UMImprintChangeCallback
        public void onImprintValueChanged(java.lang.String str, java.lang.String str2) {
            if (com.umeng.umcrash.UMCrash.isDebug) {
                java.lang.String unused = com.umeng.umcrash.UMCrash.TAG;
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                sb.append("common callback.  key is ");
                sb.append(str);
                sb.append("; value is ");
                sb.append(str2);
            }
            try {
                if (com.umeng.analytics.pro.bo.g.equals(str)) {
                    com.efs.sdk.launch.LaunchManager.sendLaunchCache(this.val$context, str2);
                    com.umeng.commonsdk.statistics.idtracking.ImprintHandler.getImprintService(this.val$context).unregistImprintCallback(com.umeng.analytics.pro.bo.g, this);
                }
            } catch (java.lang.Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* renamed from: com.umeng.umcrash.UMCrash$6, reason: invalid class name */
    public static class AnonymousClass6 implements com.efs.sdk.base.observer.IConfigCallback {
        final /* synthetic */ android.content.Context val$context;

        public AnonymousClass6(android.content.Context context) {
            this.val$context = context;
        }

        @Override // com.efs.sdk.base.observer.IConfigCallback
        public void onChange(java.util.Map<java.lang.String, java.lang.Object> map) {
            try {
                java.lang.Object obj = map.get(com.umeng.umcrash.UMCrashContent.APM_STATE_NET);
                if (obj != null) {
                    if (com.umeng.umcrash.UMCrash.isDebug) {
                        java.lang.StringBuilder sb = new java.lang.StringBuilder();
                        sb.append("callback netRate is ");
                        sb.append(obj.toString());
                    }
                    com.umeng.umcrash.UMCrashUtils.saveInnerConfig(this.val$context.getApplicationContext(), com.umeng.umcrash.UMCrashContent.APM_STATE_NET, obj);
                }
            } catch (java.lang.Throwable th) {
                th.printStackTrace();
            }
            try {
                java.lang.Object obj2 = map.get(com.umeng.umcrash.UMCrashContent.APM_STATE_NATIVE_H5);
                if (obj2 != null) {
                    if (com.umeng.umcrash.UMCrash.isDebug) {
                        java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
                        sb2.append("callback nativeH5Rate is ");
                        sb2.append(obj2.toString());
                    }
                    com.umeng.umcrash.UMCrashUtils.saveInnerConfig(this.val$context.getApplicationContext(), com.umeng.umcrash.UMCrashContent.APM_STATE_NATIVE_H5, obj2);
                }
            } catch (java.lang.Throwable th2) {
                th2.printStackTrace();
            }
            try {
                com.umeng.umcrash.UMCrash.saveLocalCrashSampling(this.val$context, map);
            } catch (java.lang.Throwable th3) {
                th3.printStackTrace();
            }
            try {
                com.umeng.umcrash.UMCrash.updateLocalCrashConfig(this.val$context, map);
            } catch (java.lang.Throwable th4) {
                th4.printStackTrace();
            }
            try {
                java.lang.Object obj3 = map.get(com.umeng.umcrash.UMCrashContent.APM_CRASH_USER_UPLOAD_TYPE);
                if (obj3 != null) {
                    if (com.umeng.umcrash.UMCrash.isDebug) {
                        java.lang.StringBuilder sb3 = new java.lang.StringBuilder();
                        sb3.append("callback uploadType is ");
                        sb3.append(obj3.toString());
                    }
                    if (java.lang.Integer.valueOf(obj3.toString()).intValue() == 0) {
                        boolean unused = com.umeng.umcrash.UMCrash.isUploadNowUserCrash = true;
                    } else {
                        boolean unused2 = com.umeng.umcrash.UMCrash.isUploadNowUserCrash = false;
                    }
                    com.umeng.umcrash.UMCrashUtils.saveInnerConfig(this.val$context.getApplicationContext(), com.umeng.umcrash.UMCrashContent.APM_CRASH_USER_UPLOAD_TYPE, obj3);
                }
            } catch (java.lang.Throwable th5) {
                th5.printStackTrace();
            }
            try {
                java.lang.Object obj4 = map.get(com.umeng.umcrash.UMCrashContent.APM_STATE_PAGE);
                if (obj4 != null) {
                    if (com.umeng.umcrash.UMCrash.isDebug) {
                        java.lang.StringBuilder sb4 = new java.lang.StringBuilder();
                        sb4.append("callback pageRate is ");
                        sb4.append(obj4.toString());
                    }
                    com.umeng.umcrash.UMCrashUtils.saveInnerConfig(this.val$context.getApplicationContext(), com.umeng.umcrash.UMCrashContent.APM_STATE_PAGE, obj4);
                }
            } catch (java.lang.Throwable th6) {
                th6.printStackTrace();
            }
            try {
                java.lang.Object obj5 = map.get(com.umeng.umcrash.UMCrashContent.APM_STATE_CODE_LOG);
                if (obj5 != null) {
                    if (com.umeng.umcrash.UMCrash.isDebug) {
                        java.lang.StringBuilder sb5 = new java.lang.StringBuilder();
                        sb5.append("callback codeLogRate is ");
                        sb5.append(obj5.toString());
                    }
                    com.umeng.umcrash.UMCrashUtils.saveInnerConfig(this.val$context.getApplicationContext(), com.umeng.umcrash.UMCrashContent.APM_STATE_CODE_LOG, obj5);
                }
            } catch (java.lang.Throwable th7) {
                th7.printStackTrace();
            }
            try {
                java.lang.Object obj6 = map.get(com.umeng.umcrash.UMCrashContent.APM_STATE_POWER);
                if (obj6 != null) {
                    if (com.umeng.umcrash.UMCrash.isDebug) {
                        java.lang.StringBuilder sb6 = new java.lang.StringBuilder();
                        sb6.append("callback powerRate is ");
                        sb6.append(obj6);
                    }
                    com.umeng.umcrash.UMCrashUtils.saveInnerConfig(this.val$context.getApplicationContext(), com.umeng.umcrash.UMCrashContent.APM_STATE_POWER, obj6);
                }
            } catch (java.lang.Throwable th8) {
                th8.printStackTrace();
            }
            try {
                java.lang.Object obj7 = map.get(com.umeng.umcrash.UMCrashContent.APM_STATE_HIT_WL);
                if (obj7 != null) {
                    if (com.umeng.umcrash.UMCrash.isDebug) {
                        java.lang.StringBuilder sb7 = new java.lang.StringBuilder();
                        sb7.append("callback hitwl is ");
                        sb7.append(obj7);
                    }
                    com.umeng.umcrash.UMCrashUtils.saveInnerConfig(this.val$context.getApplicationContext(), com.umeng.umcrash.UMCrashContent.APM_STATE_HIT_WL, obj7);
                }
            } catch (java.lang.Throwable th9) {
                th9.printStackTrace();
            }
            try {
                java.lang.Object obj8 = map.get(com.umeng.umcrash.UMCrashContent.APM_STATE_FLUTTER);
                if (obj8 != null) {
                    if (com.umeng.umcrash.UMCrash.isDebug) {
                        java.lang.StringBuilder sb8 = new java.lang.StringBuilder();
                        sb8.append("callback flutterRate is ");
                        sb8.append(obj8);
                    }
                    com.umeng.umcrash.UMCrashUtils.saveInnerConfig(this.val$context.getApplicationContext(), com.umeng.umcrash.UMCrashContent.APM_STATE_FLUTTER, obj8);
                }
            } catch (java.lang.Throwable th10) {
                th10.printStackTrace();
            }
            try {
                java.lang.Object obj9 = map.get(com.umeng.umcrash.UMCrashContent.APM_CALLBACK_LIMIT);
                if (obj9 != null) {
                    if (com.umeng.umcrash.UMCrash.isDebug) {
                        java.lang.StringBuilder sb9 = new java.lang.StringBuilder();
                        sb9.append("callback callbackLimit is ");
                        sb9.append(obj9);
                    }
                    com.umeng.umcrash.UMCrashUtils.saveInnerConfig(this.val$context.getApplicationContext(), com.umeng.umcrash.UMCrashContent.APM_CALLBACK_LIMIT, obj9);
                }
            } catch (java.lang.Throwable th11) {
                th11.printStackTrace();
            }
        }
    }

    /* renamed from: com.umeng.umcrash.UMCrash$7, reason: invalid class name */
    public static class AnonymousClass7 implements java.lang.Runnable {
        final /* synthetic */ boolean val$allThreadsDump;
        final /* synthetic */ java.lang.Throwable val$e;
        final /* synthetic */ java.lang.String val$errorMsg;
        final /* synthetic */ java.lang.String val$type;
        final /* synthetic */ boolean val$withLogcat;

        public AnonymousClass7(java.lang.String str, java.lang.Throwable th, java.lang.String str2, boolean z, boolean z2) {
            this.val$type = str;
            this.val$e = th;
            this.val$errorMsg = str2;
            this.val$withLogcat = z;
            this.val$allThreadsDump = z2;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.uc.crashsdk.export.CustomLogInfo build;
            try {
                com.umeng.umcrash.UMCustomLogInfoBuilder addLogCat = new com.umeng.umcrash.UMCustomLogInfoBuilder(this.val$type).stack(this.val$e, this.val$errorMsg).addLogCat(this.val$withLogcat);
                if (this.val$allThreadsDump) {
                    java.lang.StringBuilder sb = new java.lang.StringBuilder("AllThreadsTraces: \n");
                    for (java.util.Map.Entry<java.lang.String, java.lang.String> entry : com.umeng.innner.umcrash.UMCrashUtil.getAllThreadTraces().entrySet()) {
                        sb.append(entry.getKey());
                        sb.append("\n");
                        sb.append(entry.getValue());
                        sb.append("\n");
                    }
                    build = addLogCat.addSection(sb.toString()).build();
                } else {
                    build = addLogCat.build();
                }
                java.util.ArrayList<java.lang.String> arrayList = new java.util.ArrayList<>();
                arrayList.add(com.umeng.umcrash.UMCrash.KEY_CALLBACK_UMID);
                arrayList.add(com.umeng.umcrash.UMCrash.KEY_CALLBACK_UM_INFOS);
                arrayList.add(com.umeng.umcrash.UMCrash.KEY_CALLBACK_USER_STRING);
                arrayList.add(com.umeng.umcrash.UMCrash.KEY_CALLBACK_USER_STRING_CUSTOM_LOG);
                build.mCallbacks = arrayList;
                java.lang.String unused = com.umeng.umcrash.UMCrash.TAG;
                java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
                sb2.append("upload is ");
                sb2.append(com.umeng.umcrash.UMCrash.isUploadNowUserCrash);
                build.mUploadNow = com.umeng.umcrash.UMCrash.isUploadNowUserCrash;
                com.uc.crashsdk.export.CrashApi crashApi = com.uc.crashsdk.export.CrashApi.getInstance();
                if (crashApi == null) {
                    java.lang.String unused2 = com.umeng.umcrash.UMCrash.TAG;
                } else {
                    crashApi.generateCustomLog(build);
                }
            } catch (java.lang.Throwable unused3) {
            }
        }
    }

    /* renamed from: com.umeng.umcrash.UMCrash$8, reason: invalid class name */
    public static class AnonymousClass8 implements java.lang.Runnable {
        final /* synthetic */ boolean val$allThreadsDump;
        final /* synthetic */ java.lang.String val$e;
        final /* synthetic */ java.lang.String val$errorMsg;
        final /* synthetic */ java.lang.String val$type;
        final /* synthetic */ boolean val$withLogcat;

        public AnonymousClass8(boolean z, java.lang.String str, java.lang.String str2, java.lang.String str3, boolean z2) {
            this.val$withLogcat = z;
            this.val$type = str;
            this.val$errorMsg = str2;
            this.val$e = str3;
            this.val$allThreadsDump = z2;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                com.uc.crashsdk.export.CustomLogInfo customLogInfo = new com.uc.crashsdk.export.CustomLogInfo(null, "exception");
                java.util.ArrayList<java.lang.String> arrayList = new java.util.ArrayList<>();
                arrayList.add(com.umeng.umcrash.UMCrash.KEY_CALLBACK_UMID);
                arrayList.add(com.umeng.umcrash.UMCrash.KEY_CALLBACK_UM_INFOS);
                arrayList.add(com.umeng.umcrash.UMCrash.KEY_CALLBACK_USER_STRING);
                arrayList.add(com.umeng.umcrash.UMCrash.KEY_CALLBACK_USER_STRING_CUSTOM_LOG);
                customLogInfo.mCallbacks = arrayList;
                java.lang.String unused = com.umeng.umcrash.UMCrash.TAG;
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                sb.append("upload is ");
                sb.append(com.umeng.umcrash.UMCrash.isUploadNowUserCrash);
                customLogInfo.mUploadNow = com.umeng.umcrash.UMCrash.isUploadNowUserCrash;
                customLogInfo.mAddLogcat = this.val$withLogcat;
                java.util.HashMap hashMap = new java.util.HashMap(20);
                hashMap.put(com.umeng.umcrash.UMCustomLogInfoBuilder.LOG_KEY_CT, "exception");
                hashMap.put(com.umeng.umcrash.UMCustomLogInfoBuilder.LOG_KEY_AC, this.val$type);
                java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
                for (java.util.Map.Entry entry : hashMap.entrySet()) {
                    stringBuffer.append((java.lang.String) entry.getKey());
                    stringBuffer.append(com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR);
                    stringBuffer.append((java.lang.String) entry.getValue());
                    stringBuffer.append("\n");
                }
                java.lang.String str = this.val$errorMsg;
                if (str == null) {
                    str = "";
                }
                java.lang.String str2 = "Exception message:" + str + "\nBack traces starts.\n" + this.val$e + "\nBack traces ends.";
                if (!android.text.TextUtils.isEmpty(str2)) {
                    stringBuffer.append(str2);
                    stringBuffer.append("\n");
                }
                if (this.val$allThreadsDump) {
                    java.util.Map<java.lang.String, java.lang.String> allThreadTraces = com.umeng.innner.umcrash.UMCrashUtil.getAllThreadTraces();
                    stringBuffer.append(com.umeng.umcrash.UMCustomLogInfoBuilder.LOG_SECTION_SEP);
                    stringBuffer.append("\n");
                    stringBuffer.append("AllThreadsTraces: \n");
                    for (java.util.Map.Entry<java.lang.String, java.lang.String> entry2 : allThreadTraces.entrySet()) {
                        stringBuffer.append(entry2.getKey());
                        stringBuffer.append("\n");
                        stringBuffer.append(entry2.getValue());
                        stringBuffer.append("\n");
                    }
                }
                customLogInfo.mData = stringBuffer;
                com.uc.crashsdk.export.CrashApi crashApi = com.uc.crashsdk.export.CrashApi.getInstance();
                if (crashApi == null) {
                    java.lang.String unused2 = com.umeng.umcrash.UMCrash.TAG;
                } else {
                    crashApi.generateCustomLog(customLogInfo);
                }
            } catch (java.lang.Throwable unused3) {
            }
        }
    }

    public static class CrashClientImpl implements com.uc.crashsdk.export.ICrashClient {
        private CrashClientImpl() {
        }

        public /* synthetic */ CrashClientImpl(com.umeng.umcrash.UMCrash.AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // com.uc.crashsdk.export.ICrashClient
        public void onAddCrashStats(java.lang.String str, int i, int i2) {
        }

        @Override // com.uc.crashsdk.export.ICrashClient
        public java.io.File onBeforeUploadLog(java.io.File file) {
            return file;
        }

        @Override // com.uc.crashsdk.export.ICrashClient
        public void onClientProcessLogGenerated(java.lang.String str, java.io.File file, java.lang.String str2) {
        }

        @Override // com.uc.crashsdk.export.ICrashClient
        public void onCrashRestarting(boolean z) {
        }

        @Override // com.uc.crashsdk.export.ICrashClient
        public java.lang.String onGetCallbackInfo(java.lang.String str, boolean z) {
            java.lang.String onCallback;
            java.lang.String onCallback2;
            java.lang.String onCallback3;
            java.lang.String onCallback4;
            java.lang.String onCallback5;
            if (com.umeng.umcrash.UMCrash.KEY_CALLBACK_UMID.equals(str)) {
                return com.umeng.umcrash.UMCrash.getUMID(com.umeng.umcrash.UMCrash.mContext);
            }
            if (!com.umeng.umcrash.UMCrash.KEY_CALLBACK_UM_INFOS.equals(str)) {
                if (com.umeng.umcrash.UMCrash.KEY_CALLBACK_USER_STRING.equals(str)) {
                    if (com.umeng.umcrash.UMCrash.mUMCrashCallbackWithType != null || com.umeng.umcrash.UMCrash.mUMCrashCallback == null || (onCallback5 = com.umeng.umcrash.UMCrash.mUMCrashCallback.onCallback()) == null) {
                        return null;
                    }
                    return onCallback5.trim().getBytes().length > java.lang.Math.max(20480, com.umeng.umcrash.UMCrash.sApmCallbackLimit) ? com.umeng.umcrash.UMCrashUtils.splitByByte(onCallback5, java.lang.Math.max(20480, com.umeng.umcrash.UMCrash.sApmCallbackLimit)) : onCallback5;
                }
                if (com.umeng.umcrash.UMCrash.KEY_CALLBACK_USER_STRING_JAVA.equals(str)) {
                    if (com.umeng.umcrash.UMCrash.mUMCrashCallbackWithType == null || (onCallback4 = com.umeng.umcrash.UMCrash.mUMCrashCallbackWithType.onCallback(com.umeng.umcrash.IUMCrashCallbackWithType.CrashType.CRASH_TYPE_JAVA)) == null) {
                        return null;
                    }
                    return onCallback4.trim().getBytes().length > java.lang.Math.max(20480, com.umeng.umcrash.UMCrash.sApmCallbackLimit) ? com.umeng.umcrash.UMCrashUtils.splitByByte(onCallback4, java.lang.Math.max(20480, com.umeng.umcrash.UMCrash.sApmCallbackLimit)) : onCallback4;
                }
                if (com.umeng.umcrash.UMCrash.KEY_CALLBACK_USER_STRING_NATIVE.equals(str)) {
                    if (com.umeng.umcrash.UMCrash.mUMCrashCallbackWithType == null || (onCallback3 = com.umeng.umcrash.UMCrash.mUMCrashCallbackWithType.onCallback(com.umeng.umcrash.IUMCrashCallbackWithType.CrashType.CRASH_TYPE_NATIVE)) == null) {
                        return null;
                    }
                    return onCallback3.trim().getBytes().length > java.lang.Math.max(20480, com.umeng.umcrash.UMCrash.sApmCallbackLimit) ? com.umeng.umcrash.UMCrashUtils.splitByByte(onCallback3, java.lang.Math.max(20480, com.umeng.umcrash.UMCrash.sApmCallbackLimit)) : onCallback3;
                }
                if (com.umeng.umcrash.UMCrash.KEY_CALLBACK_USER_STRING_ANR.equals(str)) {
                    if (com.umeng.umcrash.UMCrash.mUMCrashCallbackWithType == null || (onCallback2 = com.umeng.umcrash.UMCrash.mUMCrashCallbackWithType.onCallback(com.umeng.umcrash.IUMCrashCallbackWithType.CrashType.CRASH_TYPE_ANR)) == null) {
                        return null;
                    }
                    return onCallback2.trim().getBytes().length > java.lang.Math.max(20480, com.umeng.umcrash.UMCrash.sApmCallbackLimit) ? com.umeng.umcrash.UMCrashUtils.splitByByte(onCallback2, java.lang.Math.max(20480, com.umeng.umcrash.UMCrash.sApmCallbackLimit)) : onCallback2;
                }
                if (!com.umeng.umcrash.UMCrash.KEY_CALLBACK_USER_STRING_CUSTOM_LOG.equals(str) || com.umeng.umcrash.UMCrash.mUMCrashCallbackWithType == null || (onCallback = com.umeng.umcrash.UMCrash.mUMCrashCallbackWithType.onCallback(com.umeng.umcrash.IUMCrashCallbackWithType.CrashType.CRASH_TYPE_CUSTOM_LOG)) == null) {
                    return null;
                }
                return onCallback.trim().getBytes().length > java.lang.Math.max(20480, com.umeng.umcrash.UMCrash.sApmCallbackLimit) ? com.umeng.umcrash.UMCrashUtils.splitByByte(onCallback, java.lang.Math.max(20480, com.umeng.umcrash.UMCrash.sApmCallbackLimit)) : onCallback;
            }
            org.json.JSONObject jSONObject = new org.json.JSONObject();
            try {
                if (com.umeng.umcrash.UMCrash.mArrayList != null && com.umeng.umcrash.UMCrash.mArrayList.size() > 0) {
                    org.json.JSONObject jSONObject2 = new org.json.JSONObject();
                    jSONObject2.put(com.tencent.open.SocialConstants.PARAM_SOURCE, 0);
                    jSONObject2.put("action_name", "page_view");
                    jSONObject2.put("action_page_state", com.umeng.umcrash.UMCrash.isPage);
                    org.json.JSONArray jSONArray = new org.json.JSONArray();
                    for (int i = 0; i < com.umeng.umcrash.UMCrash.mArrayList.size(); i++) {
                        java.lang.String str2 = (java.lang.String) com.umeng.umcrash.UMCrash.mArrayList.get(i);
                        if (str2 != null) {
                            org.json.JSONObject jSONObject3 = new org.json.JSONObject();
                            jSONObject3.put("name", str2);
                            jSONArray.put(jSONObject3);
                        }
                    }
                    jSONObject2.put("action_parameter", jSONArray);
                    java.lang.String jSONObject4 = jSONObject2.toString();
                    if (com.umeng.umcrash.UMCrash.isDebug) {
                        java.lang.String unused = com.umeng.umcrash.UMCrash.TAG;
                        java.lang.StringBuilder sb = new java.lang.StringBuilder();
                        sb.append("page json is ");
                        sb.append(jSONObject4);
                    }
                    jSONObject.put(com.umeng.umcrash.UMCrash.KEY_CALLBACK_PAGE_ACTION, jSONObject4);
                }
            } catch (java.lang.Throwable unused2) {
            }
            try {
                jSONObject.put(com.umeng.umcrash.UMCrash.KEY_CALLBACK_SESSION_ID, com.umeng.umcrash.UMCrash.getSessionId(com.umeng.umcrash.UMCrash.mContext));
                jSONObject.put(com.umeng.umcrash.UMCrash.KEY_CALLBACK_CUSTOM_LOG, com.umeng.umcrash.customlog.UAPMCustomLogManager.getCustomLogs());
                jSONObject.put(com.umeng.umcrash.UMCrash.KEY_CALLBACK_CUSTOM_MAPPING, com.efs.sdk.base.custommapping.InnerCustomMappingManager.getCustomMappingJsonStr());
                return jSONObject.toString();
            } catch (org.json.JSONException e) {
                throw new java.lang.RuntimeException(e);
            }
        }

        @Override // com.uc.crashsdk.export.ICrashClient
        public void onLogGenerated(java.io.File file, java.lang.String str) {
        }
    }

    public static class PaClientImpl implements com.efs.sdk.pa.IPaClient {
        private PaClientImpl() {
        }

        public /* synthetic */ PaClientImpl(com.umeng.umcrash.UMCrash.AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // com.efs.sdk.pa.IPaClient
        public java.lang.String onGetCallbackInfo(java.lang.String str) {
            java.lang.String onCallback;
            java.lang.String str2 = null;
            if (!com.umeng.umcrash.UMCrash.KEY_CALLBACK_PAGE_ACTION.equals(str)) {
                if (com.umeng.umcrash.UMCrash.KEY_CALLBACK_USER_STRING.equals(str)) {
                    if (com.umeng.umcrash.UMCrash.mUMCrashCallbackWithType != null) {
                        java.lang.String onCallback2 = com.umeng.umcrash.UMCrash.mUMCrashCallbackWithType.onCallback(com.umeng.umcrash.IUMCrashCallbackWithType.CrashType.CRASH_TYPE_BLOCK);
                        if (onCallback2 == null) {
                            return null;
                        }
                        return onCallback2.trim().getBytes().length > java.lang.Math.max(20480, com.umeng.umcrash.UMCrash.sApmCallbackLimit) ? com.umeng.umcrash.UMCrashUtils.splitByByte(onCallback2, java.lang.Math.max(20480, com.umeng.umcrash.UMCrash.sApmCallbackLimit)) : onCallback2;
                    }
                    if (com.umeng.umcrash.UMCrash.mUMCrashCallback == null || (onCallback = com.umeng.umcrash.UMCrash.mUMCrashCallback.onCallback()) == null) {
                        return null;
                    }
                    return onCallback.trim().getBytes().length > java.lang.Math.max(20480, com.umeng.umcrash.UMCrash.sApmCallbackLimit) ? com.umeng.umcrash.UMCrashUtils.splitByByte(onCallback, java.lang.Math.max(20480, com.umeng.umcrash.UMCrash.sApmCallbackLimit)) : onCallback;
                }
                return null;
            }
            try {
                if (com.umeng.umcrash.UMCrash.mArrayList != null && com.umeng.umcrash.UMCrash.mArrayList.size() > 0) {
                    org.json.JSONObject jSONObject = new org.json.JSONObject();
                    jSONObject.put(com.tencent.open.SocialConstants.PARAM_SOURCE, 0);
                    jSONObject.put("action_name", "page_view");
                    jSONObject.put("action_page_state", com.umeng.umcrash.UMCrash.isPage);
                    org.json.JSONArray jSONArray = new org.json.JSONArray();
                    for (int i = 0; i < com.umeng.umcrash.UMCrash.mArrayList.size(); i++) {
                        java.lang.String str3 = (java.lang.String) com.umeng.umcrash.UMCrash.mArrayList.get(i);
                        if (str3 != null) {
                            org.json.JSONObject jSONObject2 = new org.json.JSONObject();
                            jSONObject2.put("name", str3);
                            jSONArray.put(jSONObject2);
                        }
                    }
                    jSONObject.put("action_parameter", jSONArray);
                    str2 = jSONObject.toString();
                    if (com.umeng.umcrash.UMCrash.isDebug) {
                        java.lang.String unused = com.umeng.umcrash.UMCrash.TAG;
                        java.lang.StringBuilder sb = new java.lang.StringBuilder();
                        sb.append("page json is ");
                        sb.append(str2);
                    }
                }
            } catch (java.lang.Throwable unused2) {
            }
            return str2;
        }
    }

    public static /* synthetic */ int access$1208() {
        int i = index;
        index = i + 1;
        return i;
    }

    public static /* synthetic */ int access$1210() {
        int i = index;
        index = i - 1;
        return i;
    }

    public static void addCustomInfo(java.lang.String str, java.lang.String str2) {
        if (android.text.TextUtils.isEmpty(str) || android.text.TextUtils.isEmpty(str2)) {
            return;
        }
        if (sCustomInfo.containsKey(str)) {
            sCustomInfo.put(str, str2);
        } else if (sCustomInfo.size() < 10) {
            sCustomInfo.put(str, str2);
        }
        org.json.JSONObject jSONObject = new org.json.JSONObject(sCustomInfo);
        if (com.uc.crashsdk.export.CrashApi.getInstance() != null) {
            com.uc.crashsdk.export.CrashApi.getInstance().addHeaderInfo("um_custom_info", jSONObject.toString());
        }
    }

    @java.lang.Deprecated
    public static void enableANRLog(boolean z) {
        enableANRLog = z;
    }

    public static void enableJavaScriptBridge(android.view.View view) {
        try {
            com.efs.sdk.h5pagesdk.H5Manager.setWebView(view);
        } catch (java.lang.Throwable unused) {
        }
    }

    public static void enableJavaScriptBridge(android.webkit.WebView webView) {
        enableJavaScriptBridge((android.view.View) webView);
    }

    public static void enableKillProcessAfterCrash(boolean z) {
        sIsKillProcessAfterCrash = z;
    }

    public static void enableLogBackup(boolean z) {
        sIsEnableLogBackup = z;
    }

    @java.lang.Deprecated
    public static void enableMemoryMonitor(boolean z) {
        com.efs.sdk.memoryinfo.UMMemoryMonitor.get().setEnable(z);
    }

    @java.lang.Deprecated
    public static void enableNativeLog(boolean z) {
        enableNativeLog = z;
    }

    public static void generateCustomLog(java.lang.String str, java.lang.String str2) {
        generateCustomLog(str, str2, false, false);
    }

    public static void generateCustomLog(java.lang.String str, java.lang.String str2, java.lang.String str3, boolean z, boolean z2) {
        if (!isOpenUserCrash || android.text.TextUtils.isEmpty(str) || android.text.TextUtils.isEmpty(str2)) {
            return;
        }
        com.umeng.innner.umcrash.UMCrashThreadPoolExecutorFactory.execute(new com.umeng.umcrash.UMCrash.AnonymousClass8(z, str2, str3, str, z2));
    }

    public static void generateCustomLog(java.lang.String str, java.lang.String str2, boolean z, boolean z2) {
        generateCustomLog(str, str2, (java.lang.String) null, z, z2);
    }

    public static void generateCustomLog(java.lang.Throwable th, java.lang.String str) {
        generateCustomLog(th, str, false, false);
    }

    public static void generateCustomLog(java.lang.Throwable th, java.lang.String str, java.lang.String str2, boolean z, boolean z2) {
        if (!isOpenUserCrash || th == null || android.text.TextUtils.isEmpty(str)) {
            return;
        }
        com.umeng.innner.umcrash.UMCrashThreadPoolExecutorFactory.execute(new com.umeng.umcrash.UMCrash.AnonymousClass7(str, th, str2, z, z2));
    }

    public static void generateCustomLog(java.lang.Throwable th, java.lang.String str, boolean z, boolean z2) {
        generateCustomLog(th, str, (java.lang.String) null, z, z2);
    }

    public static com.efs.sdk.base.EfsReporter getReporter() {
        return sReporter;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static synchronized java.lang.String getSessionId(android.content.Context context) {
        java.lang.Class<com.umeng.commonsdk.statistics.common.DeviceConfig> cls;
        java.lang.reflect.Method method;
        synchronized (com.umeng.umcrash.UMCrash.class) {
            java.lang.String str = null;
            if (context == null) {
                return null;
            }
            try {
                cls = com.umeng.commonsdk.statistics.common.DeviceConfig.class;
                java.lang.String str2 = com.umeng.commonsdk.statistics.common.DeviceConfig.UNKNOW;
            } catch (java.lang.ClassNotFoundException unused) {
                cls = null;
            }
            if (cls != null) {
                try {
                    method = cls.getMethod("getSid", android.content.Context.class);
                } catch (java.lang.NoSuchMethodException unused2) {
                    method = null;
                }
                if (method != null) {
                    try {
                        java.lang.Object invoke = method.invoke(null, context);
                        if (invoke != null) {
                            str = invoke.toString();
                        }
                    } catch (java.lang.IllegalAccessException | java.lang.reflect.InvocationTargetException unused3) {
                    }
                }
            }
            return str;
        }
    }

    public static java.lang.String getUMAPMFlag() {
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        try {
            jSONObject.put("version", 0);
            jSONObject.put(com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData.EVENT_ID_CRASH, 1);
            if (enableJavaLog) {
                jSONObject.put("crashJava", 1);
            } else {
                jSONObject.put("crashJava", 0);
            }
            if (enableNativeLog) {
                jSONObject.put("crashNative", 1);
            } else {
                jSONObject.put("crashNative", 0);
            }
            if (enableANRLog) {
                jSONObject.put(com.uc.crashsdk.export.LogType.ANR_TYPE, 1);
            } else {
                jSONObject.put(com.uc.crashsdk.export.LogType.ANR_TYPE, 0);
            }
            if (isPA) {
                jSONObject.put(com.alipay.sdk.m.l.b.k, 1);
            } else {
                jSONObject.put(com.alipay.sdk.m.l.b.k, 0);
            }
            if (isLa) {
                jSONObject.put("la", 1);
            } else {
                jSONObject.put("la", 0);
            }
            if (com.efs.sdk.memoryinfo.UMMemoryMonitor.get().isEnable()) {
                jSONObject.put("mem", 1);
            } else {
                jSONObject.put("mem", 0);
            }
            if (isNet) {
                jSONObject.put(com.alipay.sdk.m.k.b.k, 1);
            } else {
                jSONObject.put(com.alipay.sdk.m.k.b.k, 0);
            }
            if (com.efs.sdk.h5pagesdk.H5Manager.getH5ConfigMananger() == null || !com.efs.sdk.h5pagesdk.H5Manager.getH5ConfigMananger().isH5TracerEnable()) {
                jSONObject.put("h5", 0);
            } else {
                jSONObject.put("h5", 1);
            }
            if (isOpenUserCrash) {
                jSONObject.put("crashUser", 1);
            } else {
                jSONObject.put("crashUser", 0);
            }
            if (isPage) {
                jSONObject.put("page", 1);
            } else {
                jSONObject.put("page", 0);
            }
            if (isPower) {
                jSONObject.put("power", 1);
            } else {
                jSONObject.put("power", 0);
            }
            if (isCodeLog) {
                jSONObject.put("codelog", 1);
            } else {
                jSONObject.put("codelog", 0);
            }
        } catch (java.lang.Throwable unused) {
        }
        return jSONObject.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static synchronized java.lang.String getUMID(android.content.Context context) {
        java.lang.Class<com.umeng.commonsdk.UMConfigure> cls;
        java.lang.reflect.Method method;
        synchronized (com.umeng.umcrash.UMCrash.class) {
            java.lang.String str = null;
            if (context == null) {
                return null;
            }
            try {
                cls = com.umeng.commonsdk.UMConfigure.class;
                com.umeng.commonsdk.debug.UMLog uMLog = com.umeng.commonsdk.UMConfigure.umDebugLog;
            } catch (java.lang.ClassNotFoundException unused) {
                cls = null;
            }
            if (cls != null) {
                try {
                    method = cls.getMethod("getUMIDString", android.content.Context.class);
                } catch (java.lang.NoSuchMethodException unused2) {
                    method = null;
                }
                if (method != null) {
                    try {
                        java.lang.Object invoke = method.invoke(null, context);
                        if (invoke != null) {
                            str = invoke.toString();
                        }
                    } catch (java.lang.IllegalAccessException | java.lang.reflect.InvocationTargetException unused3) {
                    }
                }
            }
            return str;
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(64:4|(2:5|6)|7|(4:8|9|(1:11)|(1:14))|16|(5:17|18|(1:20)|(1:22)(1:282)|23)|24|(9:25|26|(1:28)|29|(1:31)|32|(1:34)|35|(1:37)(1:277))|38|(1:40)|41|(1:43)|44|45|(1:47)(1:276)|48|(68:50|51|52|53|54|55|(1:59)|61|(1:63)|64|(1:66)|67|(1:69)|70|71|73|74|75|(1:77)(1:267)|78|(1:80)|81|82|84|85|(1:87)|(1:89)(2:251|(2:253|(3:255|(3:257|(1:259)|260)|261)))|90|(1:92)|94|95|96|97|(1:245)(1:101)|102|103|(1:105)(1:242)|106|107|(6:109|110|111|(1:113)|115|(1:236))(1:239)|119|120|(1:122)(1:233)|123|124|(1:126)|(1:128)(2:218|(2:220|(4:222|223|224|(1:226))(1:230)))|129|130|(1:132)|(1:134)(2:210|(2:212|(1:214)(1:215)))|135|136|(1:138)|(1:140)(2:195|(2:197|(4:199|200|201|(1:203))(1:207)))|141|142|(1:144)|(1:146)(2:180|(2:182|(4:184|185|186|(1:188))(1:192)))|147|148|(1:150)|(1:152)(2:165|(2:167|(4:169|170|171|(1:173))(1:177)))|153|154|(1:156)|158|(2:160|161)(1:162))|275|84|85|(0)|(0)(0)|90|(0)|94|95|96|97|(1:99)|245|102|103|(0)(0)|106|107|(0)(0)|119|120|(0)(0)|123|124|(0)|(0)(0)|129|130|(0)|(0)(0)|135|136|(0)|(0)(0)|141|142|(0)|(0)(0)|147|148|(0)|(0)(0)|153|154|(0)|158|(0)(0)) */
    /* JADX WARN: Can't wrap try/catch for region: R(68:4|(2:5|6)|7|(4:8|9|(1:11)|(1:14))|16|17|18|(1:20)|(1:22)(1:282)|23|24|(9:25|26|(1:28)|29|(1:31)|32|(1:34)|35|(1:37)(1:277))|38|(1:40)|41|(1:43)|44|45|(1:47)(1:276)|48|(68:50|51|52|53|54|55|(1:59)|61|(1:63)|64|(1:66)|67|(1:69)|70|71|73|74|75|(1:77)(1:267)|78|(1:80)|81|82|84|85|(1:87)|(1:89)(2:251|(2:253|(3:255|(3:257|(1:259)|260)|261)))|90|(1:92)|94|95|96|97|(1:245)(1:101)|102|103|(1:105)(1:242)|106|107|(6:109|110|111|(1:113)|115|(1:236))(1:239)|119|120|(1:122)(1:233)|123|124|(1:126)|(1:128)(2:218|(2:220|(4:222|223|224|(1:226))(1:230)))|129|130|(1:132)|(1:134)(2:210|(2:212|(1:214)(1:215)))|135|136|(1:138)|(1:140)(2:195|(2:197|(4:199|200|201|(1:203))(1:207)))|141|142|(1:144)|(1:146)(2:180|(2:182|(4:184|185|186|(1:188))(1:192)))|147|148|(1:150)|(1:152)(2:165|(2:167|(4:169|170|171|(1:173))(1:177)))|153|154|(1:156)|158|(2:160|161)(1:162))|275|84|85|(0)|(0)(0)|90|(0)|94|95|96|97|(1:99)|245|102|103|(0)(0)|106|107|(0)(0)|119|120|(0)(0)|123|124|(0)|(0)(0)|129|130|(0)|(0)(0)|135|136|(0)|(0)(0)|141|142|(0)|(0)(0)|147|148|(0)|(0)(0)|153|154|(0)|158|(0)(0)) */
    /* JADX WARN: Can't wrap try/catch for region: R(71:4|(2:5|6)|7|8|9|(1:11)|(1:14)|16|17|18|(1:20)|(1:22)(1:282)|23|24|(9:25|26|(1:28)|29|(1:31)|32|(1:34)|35|(1:37)(1:277))|38|(1:40)|41|(1:43)|44|45|(1:47)(1:276)|48|(68:50|51|52|53|54|55|(1:59)|61|(1:63)|64|(1:66)|67|(1:69)|70|71|73|74|75|(1:77)(1:267)|78|(1:80)|81|82|84|85|(1:87)|(1:89)(2:251|(2:253|(3:255|(3:257|(1:259)|260)|261)))|90|(1:92)|94|95|96|97|(1:245)(1:101)|102|103|(1:105)(1:242)|106|107|(6:109|110|111|(1:113)|115|(1:236))(1:239)|119|120|(1:122)(1:233)|123|124|(1:126)|(1:128)(2:218|(2:220|(4:222|223|224|(1:226))(1:230)))|129|130|(1:132)|(1:134)(2:210|(2:212|(1:214)(1:215)))|135|136|(1:138)|(1:140)(2:195|(2:197|(4:199|200|201|(1:203))(1:207)))|141|142|(1:144)|(1:146)(2:180|(2:182|(4:184|185|186|(1:188))(1:192)))|147|148|(1:150)|(1:152)(2:165|(2:167|(4:169|170|171|(1:173))(1:177)))|153|154|(1:156)|158|(2:160|161)(1:162))|275|84|85|(0)|(0)(0)|90|(0)|94|95|96|97|(1:99)|245|102|103|(0)(0)|106|107|(0)(0)|119|120|(0)(0)|123|124|(0)|(0)(0)|129|130|(0)|(0)(0)|135|136|(0)|(0)(0)|141|142|(0)|(0)(0)|147|148|(0)|(0)(0)|153|154|(0)|158|(0)(0)) */
    /* JADX WARN: Can't wrap try/catch for region: R(79:4|(2:5|6)|7|8|9|(1:11)|(1:14)|16|17|18|(1:20)|(1:22)(1:282)|23|24|25|26|(1:28)|29|(1:31)|32|(1:34)|35|(1:37)(1:277)|38|(1:40)|41|(1:43)|44|45|(1:47)(1:276)|48|(68:50|51|52|53|54|55|(1:59)|61|(1:63)|64|(1:66)|67|(1:69)|70|71|73|74|75|(1:77)(1:267)|78|(1:80)|81|82|84|85|(1:87)|(1:89)(2:251|(2:253|(3:255|(3:257|(1:259)|260)|261)))|90|(1:92)|94|95|96|97|(1:245)(1:101)|102|103|(1:105)(1:242)|106|107|(6:109|110|111|(1:113)|115|(1:236))(1:239)|119|120|(1:122)(1:233)|123|124|(1:126)|(1:128)(2:218|(2:220|(4:222|223|224|(1:226))(1:230)))|129|130|(1:132)|(1:134)(2:210|(2:212|(1:214)(1:215)))|135|136|(1:138)|(1:140)(2:195|(2:197|(4:199|200|201|(1:203))(1:207)))|141|142|(1:144)|(1:146)(2:180|(2:182|(4:184|185|186|(1:188))(1:192)))|147|148|(1:150)|(1:152)(2:165|(2:167|(4:169|170|171|(1:173))(1:177)))|153|154|(1:156)|158|(2:160|161)(1:162))|275|84|85|(0)|(0)(0)|90|(0)|94|95|96|97|(1:99)|245|102|103|(0)(0)|106|107|(0)(0)|119|120|(0)(0)|123|124|(0)|(0)(0)|129|130|(0)|(0)(0)|135|136|(0)|(0)(0)|141|142|(0)|(0)(0)|147|148|(0)|(0)(0)|153|154|(0)|158|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:163:0x050c, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:164:0x050d, code lost:
    
        r0.printStackTrace();
     */
    /* JADX WARN: Code restructure failed: missing block: B:178:0x04e8, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:179:0x04e9, code lost:
    
        r0.printStackTrace();
     */
    /* JADX WARN: Code restructure failed: missing block: B:193:0x049a, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:194:0x049b, code lost:
    
        r0.printStackTrace();
     */
    /* JADX WARN: Code restructure failed: missing block: B:208:0x044c, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:209:0x044d, code lost:
    
        r0.printStackTrace();
     */
    /* JADX WARN: Code restructure failed: missing block: B:216:0x03fe, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:217:0x03ff, code lost:
    
        r0.printStackTrace();
     */
    /* JADX WARN: Code restructure failed: missing block: B:231:0x03c7, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:232:0x03c8, code lost:
    
        r0.printStackTrace();
     */
    /* JADX WARN: Code restructure failed: missing block: B:234:0x037b, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:235:0x037c, code lost:
    
        r0.printStackTrace();
     */
    /* JADX WARN: Code restructure failed: missing block: B:240:0x0366, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:241:0x0367, code lost:
    
        r0.printStackTrace();
     */
    /* JADX WARN: Code restructure failed: missing block: B:243:0x0324, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:244:0x0325, code lost:
    
        r0.printStackTrace();
     */
    /* JADX WARN: Code restructure failed: missing block: B:246:0x0310, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:247:0x0311, code lost:
    
        r0.printStackTrace();
     */
    /* JADX WARN: Code restructure failed: missing block: B:249:0x02d8, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:250:0x02d9, code lost:
    
        r0.printStackTrace();
     */
    /* JADX WARN: Code restructure failed: missing block: B:262:0x02d0, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:263:0x02d1, code lost:
    
        r0.printStackTrace();
     */
    /* JADX WARN: Removed duplicated region for block: B:105:0x0318 A[Catch: all -> 0x0324, TryCatch #1 {all -> 0x0324, blocks: (B:103:0x0314, B:105:0x0318, B:242:0x0321), top: B:102:0x0314 }] */
    /* JADX WARN: Removed duplicated region for block: B:109:0x032c A[Catch: all -> 0x0366, TRY_LEAVE, TryCatch #3 {all -> 0x0366, blocks: (B:107:0x0328, B:109:0x032c, B:115:0x0346, B:117:0x034c, B:236:0x0352, B:238:0x0343, B:239:0x0363, B:111:0x0331, B:113:0x0337), top: B:106:0x0328, inners: #13 }] */
    /* JADX WARN: Removed duplicated region for block: B:122:0x036e A[Catch: all -> 0x037b, TryCatch #9 {all -> 0x037b, blocks: (B:120:0x036a, B:122:0x036e, B:233:0x0378), top: B:119:0x036a }] */
    /* JADX WARN: Removed duplicated region for block: B:126:0x038d A[Catch: all -> 0x03c7, TryCatch #16 {all -> 0x03c7, blocks: (B:124:0x037f, B:126:0x038d, B:128:0x039c, B:220:0x03a3, B:222:0x03a9, B:229:0x03c0, B:230:0x03c4, B:224:0x03ae, B:226:0x03b4), top: B:123:0x037f, inners: #11 }] */
    /* JADX WARN: Removed duplicated region for block: B:128:0x039c A[Catch: all -> 0x03c7, TryCatch #16 {all -> 0x03c7, blocks: (B:124:0x037f, B:126:0x038d, B:128:0x039c, B:220:0x03a3, B:222:0x03a9, B:229:0x03c0, B:230:0x03c4, B:224:0x03ae, B:226:0x03b4), top: B:123:0x037f, inners: #11 }] */
    /* JADX WARN: Removed duplicated region for block: B:132:0x03d9 A[Catch: all -> 0x03fe, TryCatch #10 {all -> 0x03fe, blocks: (B:130:0x03cb, B:132:0x03d9, B:134:0x03e8, B:212:0x03ef, B:214:0x03f5, B:215:0x03fb), top: B:129:0x03cb }] */
    /* JADX WARN: Removed duplicated region for block: B:134:0x03e8 A[Catch: all -> 0x03fe, TryCatch #10 {all -> 0x03fe, blocks: (B:130:0x03cb, B:132:0x03d9, B:134:0x03e8, B:212:0x03ef, B:214:0x03f5, B:215:0x03fb), top: B:129:0x03cb }] */
    /* JADX WARN: Removed duplicated region for block: B:138:0x0410 A[Catch: all -> 0x044c, TryCatch #18 {all -> 0x044c, blocks: (B:136:0x0402, B:138:0x0410, B:140:0x041f, B:197:0x0426, B:199:0x042c, B:206:0x0445, B:207:0x0449, B:201:0x0433, B:203:0x0439), top: B:135:0x0402, inners: #14 }] */
    /* JADX WARN: Removed duplicated region for block: B:140:0x041f A[Catch: all -> 0x044c, TryCatch #18 {all -> 0x044c, blocks: (B:136:0x0402, B:138:0x0410, B:140:0x041f, B:197:0x0426, B:199:0x042c, B:206:0x0445, B:207:0x0449, B:201:0x0433, B:203:0x0439), top: B:135:0x0402, inners: #14 }] */
    /* JADX WARN: Removed duplicated region for block: B:144:0x045e A[Catch: all -> 0x049a, TryCatch #25 {all -> 0x049a, blocks: (B:142:0x0450, B:144:0x045e, B:146:0x046d, B:182:0x0474, B:184:0x047a, B:191:0x0493, B:192:0x0497, B:186:0x0481, B:188:0x0487), top: B:141:0x0450, inners: #21 }] */
    /* JADX WARN: Removed duplicated region for block: B:146:0x046d A[Catch: all -> 0x049a, TryCatch #25 {all -> 0x049a, blocks: (B:142:0x0450, B:144:0x045e, B:146:0x046d, B:182:0x0474, B:184:0x047a, B:191:0x0493, B:192:0x0497, B:186:0x0481, B:188:0x0487), top: B:141:0x0450, inners: #21 }] */
    /* JADX WARN: Removed duplicated region for block: B:150:0x04ac A[Catch: all -> 0x04e8, TryCatch #4 {all -> 0x04e8, blocks: (B:148:0x049e, B:150:0x04ac, B:152:0x04bb, B:167:0x04c2, B:169:0x04c8, B:176:0x04e1, B:177:0x04e5, B:171:0x04cf, B:173:0x04d5), top: B:147:0x049e, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:152:0x04bb A[Catch: all -> 0x04e8, TryCatch #4 {all -> 0x04e8, blocks: (B:148:0x049e, B:150:0x04ac, B:152:0x04bb, B:167:0x04c2, B:169:0x04c8, B:176:0x04e1, B:177:0x04e5, B:171:0x04cf, B:173:0x04d5), top: B:147:0x049e, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:156:0x04fc A[Catch: all -> 0x050c, TRY_LEAVE, TryCatch #17 {all -> 0x050c, blocks: (B:154:0x04ec, B:156:0x04fc), top: B:153:0x04ec }] */
    /* JADX WARN: Removed duplicated region for block: B:160:0x0514  */
    /* JADX WARN: Removed duplicated region for block: B:162:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:165:0x04be  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x0470  */
    /* JADX WARN: Removed duplicated region for block: B:195:0x0422  */
    /* JADX WARN: Removed duplicated region for block: B:210:0x03eb  */
    /* JADX WARN: Removed duplicated region for block: B:218:0x039f  */
    /* JADX WARN: Removed duplicated region for block: B:233:0x0378 A[Catch: all -> 0x037b, TRY_LEAVE, TryCatch #9 {all -> 0x037b, blocks: (B:120:0x036a, B:122:0x036e, B:233:0x0378), top: B:119:0x036a }] */
    /* JADX WARN: Removed duplicated region for block: B:239:0x0363 A[Catch: all -> 0x0366, TRY_LEAVE, TryCatch #3 {all -> 0x0366, blocks: (B:107:0x0328, B:109:0x032c, B:115:0x0346, B:117:0x034c, B:236:0x0352, B:238:0x0343, B:239:0x0363, B:111:0x0331, B:113:0x0337), top: B:106:0x0328, inners: #13 }] */
    /* JADX WARN: Removed duplicated region for block: B:242:0x0321 A[Catch: all -> 0x0324, TRY_LEAVE, TryCatch #1 {all -> 0x0324, blocks: (B:103:0x0314, B:105:0x0318, B:242:0x0321), top: B:102:0x0314 }] */
    /* JADX WARN: Removed duplicated region for block: B:251:0x028c  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x027a A[Catch: all -> 0x02d0, TryCatch #20 {all -> 0x02d0, blocks: (B:85:0x026c, B:87:0x027a, B:89:0x0289, B:90:0x02bc, B:92:0x02c0, B:253:0x0290, B:255:0x0296, B:257:0x02a0, B:259:0x02aa, B:260:0x02b7, B:261:0x02ba), top: B:84:0x026c }] */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0289 A[Catch: all -> 0x02d0, TryCatch #20 {all -> 0x02d0, blocks: (B:85:0x026c, B:87:0x027a, B:89:0x0289, B:90:0x02bc, B:92:0x02c0, B:253:0x0290, B:255:0x0296, B:257:0x02a0, B:259:0x02aa, B:260:0x02b7, B:261:0x02ba), top: B:84:0x026c }] */
    /* JADX WARN: Removed duplicated region for block: B:92:0x02c0 A[Catch: all -> 0x02d0, TRY_LEAVE, TryCatch #20 {all -> 0x02d0, blocks: (B:85:0x026c, B:87:0x027a, B:89:0x0289, B:90:0x02bc, B:92:0x02c0, B:253:0x0290, B:255:0x0296, B:257:0x02a0, B:259:0x02aa, B:260:0x02b7, B:261:0x02ba), top: B:84:0x026c }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void init(android.content.Context context, java.lang.String str, java.lang.String str2) {
        int innerConfig;
        int innerConfig2;
        int innerConfig3;
        int innerConfig4;
        int innerConfig5;
        int innerConfig6;
        if (context == null || str == null) {
            return;
        }
        mContext = context;
        try {
            com.efs.sdk.base.core.util.concurrent.WorkThreadUtil.submit(new com.umeng.umcrash.UMCrash.AnonymousClass1(context));
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
        try {
            int innerConfig7 = com.umeng.umcrash.UMCrashUtils.getInnerConfig(mContext, com.umeng.umcrash.UMCrashContent.KEY_APM_CTR_FLAG, 0);
            if (isDebug) {
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                sb.append("int apm. flag is ");
                sb.append(innerConfig7);
            }
            if (innerConfig7 == -1) {
                return;
            }
        } catch (java.lang.Throwable th2) {
            th2.printStackTrace();
        }
        try {
            int innerConfig8 = com.umeng.umcrash.UMCrashUtils.getInnerConfig(mContext, com.umeng.umcrash.UMCrashContent.APM_STATE_HIT_WL, 0);
            if (isDebug) {
                java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
                sb2.append("int apm. hitWlState is ");
                sb2.append(innerConfig8);
            }
            com.efs.sdk.base.samplingwhitelist.SamplingWhiteListUtil.setHitWL(innerConfig8 == 1);
        } catch (java.lang.Throwable th3) {
            th3.printStackTrace();
        }
        android.content.SharedPreferences sharedPreferences = com.efs.sdk.base.newsharedpreferences.SharedPreferencesUtils.getSharedPreferences(context, INTEGRATIONTESTING_SP);
        try {
            try {
                if (enableJavaLog) {
                    enableJavaLog = com.umeng.umcrash.UMCrashUtils.random(com.umeng.umcrash.UMCrashUtils.getInnerConfig(context.getApplicationContext(), com.umeng.umcrash.UMCrashContent.APM_CRASH_JAVA_SAMPLING_RATE, 100));
                }
                if (enableNativeLog) {
                    enableNativeLog = com.umeng.umcrash.UMCrashUtils.random(com.umeng.umcrash.UMCrashUtils.getInnerConfig(context.getApplicationContext(), com.umeng.umcrash.UMCrashContent.APM_CRASH_NATIVE_SAMPLING_RATE, 100));
                }
                if (enableANRLog) {
                    enableANRLog = com.umeng.umcrash.UMCrashUtils.random(com.umeng.umcrash.UMCrashUtils.getInnerConfig(context.getApplicationContext(), com.umeng.umcrash.UMCrashContent.APM_CRASH_ANR_SAMPLING_RATE, 100));
                }
                isOpenUserCrash = com.umeng.umcrash.UMCrashUtils.random(com.umeng.umcrash.UMCrashUtils.getInnerConfig(context.getApplicationContext(), com.umeng.umcrash.UMCrashContent.APM_CRASH_USER_SAMPLING_RATE, 100));
                if (com.umeng.umcrash.UMCrashUtils.getInnerConfig(context.getApplicationContext(), com.umeng.umcrash.UMCrashContent.APM_CRASH_USER_UPLOAD_TYPE, -1) == 0) {
                    isUploadNowUserCrash = true;
                } else {
                    isUploadNowUserCrash = false;
                }
            } catch (java.lang.Throwable unused) {
            }
        } catch (java.lang.Throwable th4) {
            th4.printStackTrace();
        }
        android.os.Bundle bundle = new android.os.Bundle();
        bundle.putBoolean("mDebug", isDebug);
        bundle.putBoolean("mEncryptLog", isEncrypt);
        bundle.putBoolean("mZipLog", isZip);
        bundle.putBoolean("mEnableKillProcessAfterCrash", sIsKillProcessAfterCrash);
        bundle.putBoolean(KEY_ENABLE_CRASH_JAVA, enableJavaLog);
        bundle.putBoolean(KEY_ENABLE_CRASH_NATIVE, true);
        bundle.putBoolean(KEY_ENABLE_ANR, enableANRLog);
        if (sIsEnableLogBackup) {
            bundle.putBoolean("mBackupLogs", true);
            bundle.putString("mLogsBackupPathName", context.getApplicationInfo().dataDir + java.io.File.separator + "apm_backup_files");
        }
        if (isDebug) {
            java.lang.StringBuilder sb3 = new java.lang.StringBuilder();
            sb3.append("enable : java is ");
            sb3.append(enableJavaLog);
            sb3.append(", native is ");
            sb3.append(enableNativeLog);
            sb3.append(", anr is ");
            sb3.append(enableANRLog);
        }
        bundle.putBoolean(KEY_ENABLE_CRASH_UNEXP, false);
        bundle.putBoolean("mIsInternational", isIntl);
        bundle.putBoolean("mDumpUserSolibBuildId", isBuildId);
        if (isIntl) {
            bundle.putString("mCrashLogUploadUrl", "https://errnewlogos.umeng.com/upload");
            bundle.putString("mCrashSDKAuthUrl", com.umeng.umcrash.UMCrashContent.UM_DOMAIN_APM_URL_INTL);
            bundle.putString("mCrashRateUploadUrl", com.umeng.umcrash.UMCrashContent.UM_DOMAIN_APM_URL_INTL);
            boolean z = isDebug;
        } else {
            bundle.putString("mCrashLogUploadUrl", "https://errnewlog.umeng.com/upload");
            bundle.putString("mCrashSDKAuthUrl", com.umeng.umcrash.UMCrashContent.UM_DOMAIN_APM_URL);
            bundle.putString("mCrashRateUploadUrl", com.umeng.umcrash.UMCrashContent.UM_DOMAIN_APM_URL);
            boolean z2 = isDebug;
        }
        com.uc.crashsdk.export.CrashApi createInstanceEx = com.uc.crashsdk.export.CrashApi.createInstanceEx(context, str, isDebug, bundle, new com.umeng.umcrash.UMCrash.CrashClientImpl(null));
        if (createInstanceEx != null) {
            createInstanceEx.addHeaderInfo(KEY_HEADER_APPKEY, str);
            try {
                createInstanceEx.addHeaderInfo(KEY_HEADER_CHANNEL, str2);
                createInstanceEx.addHeaderInfo(KEY_HEADER_OS, com.aliyun.vod.log.core.AliyunLogCommon.OPERATION_SYSTEM);
                createInstanceEx.addHeaderInfo(KEY_HEADER_CRASH_VERSION, crashSdkVersion);
                createInstanceEx.addHeaderInfo(KEY_HEADER_UMID, getUMID(context));
                try {
                    java.lang.String[] activeUser = com.umeng.umcrash.UMCrashUtils.getActiveUser(context);
                    if (activeUser != null && activeUser.length == 2) {
                        createInstanceEx.addHeaderInfo(KEY_HEADER_PUID, activeUser[1]);
                        createInstanceEx.addHeaderInfo(KEY_HEADER_PROVIDER, activeUser[0]);
                    }
                } catch (java.lang.Throwable unused2) {
                    createInstanceEx.addHeaderInfo(KEY_HEADER_PUID, "");
                    createInstanceEx.addHeaderInfo(KEY_HEADER_PROVIDER, "");
                }
                createInstanceEx.addHeaderInfo(KEY_HEADER_CARRIER, com.umeng.umcrash.UMCrashUtils.getNetworkOperatorName(context));
                if (!android.text.TextUtils.isEmpty(userBver)) {
                    createInstanceEx.addHeaderInfo(KEY_HEADER_BVER, userBver);
                }
                if (!android.text.TextUtils.isEmpty(userBsver)) {
                    createInstanceEx.addHeaderInfo(KEY_HEADER_BSVER, userBsver);
                }
                if (!android.text.TextUtils.isEmpty(userBesrial)) {
                    createInstanceEx.addHeaderInfo(KEY_HEADER_BESRIAL, userBesrial);
                }
                try {
                    createInstanceEx.addHeaderInfo(KEY_HEADER_NETWORK_TYPE, "" + com.efs.sdk.base.core.util.NetworkUtil.getNetworkTypeUmeng(context));
                } catch (java.lang.Throwable th5) {
                    th5.printStackTrace();
                }
                try {
                    if (com.umeng.umcrash.UMCrashUtils.isHarmony(context)) {
                        createInstanceEx.addHeaderInfo("others_OS", "harmony");
                    } else {
                        createInstanceEx.addHeaderInfo("others_OS", "Android");
                    }
                } catch (java.lang.Throwable th6) {
                    th6.printStackTrace();
                }
                registerInfoCallback(createInstanceEx);
                if (context instanceof android.app.Application) {
                    ((android.app.Application) context).registerActivityLifecycleCallbacks(new com.umeng.umcrash.UMCrash.AnonymousClass2(str, sharedPreferences));
                }
                try {
                    com.efs.sdk.base.core.util.concurrent.WorkThreadUtil.submit(new com.umeng.umcrash.UMCrash.AnonymousClass3(context, createInstanceEx));
                } catch (java.lang.Throwable th7) {
                    th7.printStackTrace();
                }
            } catch (java.lang.Throwable unused3) {
            }
            innerConfig6 = com.umeng.umcrash.UMCrashUtils.getInnerConfig(context.getApplicationContext(), com.umeng.umcrash.UMCrashContent.APM_STATE_CODE_LOG, -1);
            if (isDebug) {
                java.lang.StringBuilder sb4 = new java.lang.StringBuilder();
                sb4.append("inner config : code log rate is ");
                sb4.append(innerConfig6);
            }
            if (innerConfig6 != 0) {
                boolean z3 = isDebug;
            } else if (innerConfig6 == 100) {
                boolean z4 = isDebug;
                if (enableCodeLog) {
                    if (android.text.TextUtils.isEmpty(com.umeng.logsdk.ULogManager.getDeviceID())) {
                        java.lang.String uMId = com.umeng.commonsdk.utils.UMUtils.getUMId(mContext);
                        if (isDebug) {
                            java.lang.StringBuilder sb5 = new java.lang.StringBuilder();
                            sb5.append("inner config : code log set umid is ");
                            sb5.append(uMId);
                        }
                        com.umeng.logsdk.ULogManager.setDeviceID(uMId);
                    }
                    isCodeLog = true;
                }
            }
            if (isDebug) {
                java.lang.StringBuilder sb6 = new java.lang.StringBuilder();
                sb6.append("enable codeLog is ");
                sb6.append(isCodeLog);
            }
            initReporter(context, str, str2);
            java.lang.String string = sharedPreferences.getString("debugkey", "");
            if (sharedPreferences.getLong("timestamp", 0L) - java.lang.System.currentTimeMillis() >= 0 || android.text.TextUtils.isEmpty(string)) {
                sharedPreferences.edit().clear().apply();
                com.efs.sdk.base.integrationtesting.IntegrationTestingUtil.setIntegrationTestingInPeriod(false);
            } else {
                com.efs.sdk.base.integrationtesting.IntegrationTestingUtil.setIntegrationTestingInPeriod(true);
                com.umeng.umcrash.UMCrashUtils.setIntegrationTesingParams(string);
            }
            if (enablePaLog) {
                boolean z5 = isDebug;
            } else {
                com.efs.sdk.base.core.util.concurrent.WorkThreadUtil.submit(new com.umeng.umcrash.UMCrash.AnonymousClass4(context));
            }
            if (enableLaunchLog) {
                boolean z6 = isDebug;
            } else {
                com.efs.sdk.launch.LaunchManager.init(context, sReporter);
                try {
                    if (com.efs.sdk.launch.LaunchManager.getLaunchConfigManager() != null) {
                        isLa = com.efs.sdk.launch.LaunchManager.getLaunchConfigManager().enableTracer();
                    }
                } catch (java.lang.Throwable th8) {
                    th8.printStackTrace();
                }
                java.lang.String uMId2 = com.umeng.commonsdk.utils.UMUtils.getUMId(context);
                if (uMId2 == null || android.text.TextUtils.isEmpty(uMId2)) {
                    boolean z7 = isDebug;
                    com.umeng.commonsdk.statistics.idtracking.ImprintHandler.getImprintService(context).registImprintCallback(com.umeng.analytics.pro.bo.g, new com.umeng.umcrash.UMCrash.AnonymousClass5(context));
                }
            }
            if (enableMemLog) {
                boolean z8 = isDebug;
            } else {
                com.efs.sdk.memoryinfo.UMMemoryMonitor.get().start(context, sReporter);
            }
            innerConfig5 = com.umeng.umcrash.UMCrashUtils.getInnerConfig(context.getApplicationContext(), com.umeng.umcrash.UMCrashContent.APM_STATE_NET, -1);
            if (isDebug) {
                java.lang.StringBuilder sb7 = new java.lang.StringBuilder();
                sb7.append("inner config : net rate is ");
                sb7.append(innerConfig5);
            }
            if (innerConfig5 != 0) {
                boolean z9 = isDebug;
            } else if (innerConfig5 == 100) {
                boolean z10 = isDebug;
                if (enableNetLog) {
                    com.efs.sdk.net.NetManager.init(context, sReporter);
                    try {
                        if (com.efs.sdk.net.NetManager.getNetConfigManager() != null) {
                            isNet = com.efs.sdk.net.NetManager.getNetConfigManager().enableTracer();
                        }
                    } catch (java.lang.Throwable th9) {
                        th9.printStackTrace();
                    }
                } else {
                    boolean z11 = isDebug;
                }
            }
            innerConfig4 = com.umeng.umcrash.UMCrashUtils.getInnerConfig(context.getApplicationContext(), com.umeng.umcrash.UMCrashContent.APM_STATE_NATIVE_H5, -1);
            if (isDebug) {
                java.lang.StringBuilder sb8 = new java.lang.StringBuilder();
                sb8.append("inner config : nativeH5Rate is ");
                sb8.append(innerConfig4);
            }
            if (innerConfig4 != 0) {
                boolean z12 = isDebug;
            } else if (innerConfig4 == 100) {
                boolean z13 = isDebug;
                if (enableH5PageLog) {
                    com.efs.sdk.h5pagesdk.H5Manager.init(context, sReporter);
                } else {
                    boolean z14 = isDebug;
                }
            }
            innerConfig3 = com.umeng.umcrash.UMCrashUtils.getInnerConfig(context.getApplicationContext(), com.umeng.umcrash.UMCrashContent.APM_STATE_PAGE, -1);
            if (isDebug) {
                java.lang.StringBuilder sb9 = new java.lang.StringBuilder();
                sb9.append("inner config : page rate is ");
                sb9.append(innerConfig3);
            }
            if (innerConfig3 != 0) {
                boolean z15 = isDebug;
            } else if (innerConfig3 == 100) {
                boolean z16 = isDebug;
                if (enablePageLog) {
                    com.umeng.pagesdk.PageManger.init(mContext, sReporter);
                    try {
                        if (com.umeng.pagesdk.PageManger.getPageConfigManger() != null) {
                            isPage = com.umeng.pagesdk.PageManger.getPageConfigManger().enableTracer();
                        }
                    } catch (java.lang.Throwable th10) {
                        th10.printStackTrace();
                    }
                } else {
                    boolean z17 = isDebug;
                }
            }
            innerConfig2 = com.umeng.umcrash.UMCrashUtils.getInnerConfig(context.getApplicationContext(), com.umeng.umcrash.UMCrashContent.APM_STATE_POWER, -1);
            if (isDebug) {
                java.lang.StringBuilder sb10 = new java.lang.StringBuilder();
                sb10.append("inner config : power rate is ");
                sb10.append(innerConfig2);
            }
            if (innerConfig2 != 0) {
                boolean z18 = isDebug;
            } else if (innerConfig2 == 100) {
                boolean z19 = isDebug;
                if (enablePowerLog) {
                    com.umeng.powersdk.PowerManager.init(mContext, sReporter);
                    try {
                        if (com.umeng.powersdk.PowerManager.getPowerConfigManager() != null) {
                            isPower = com.umeng.powersdk.PowerManager.getPowerConfigManager().enableTracer();
                        }
                    } catch (java.lang.Throwable th11) {
                        th11.printStackTrace();
                    }
                } else {
                    boolean z20 = isDebug;
                }
            }
            innerConfig = com.umeng.umcrash.UMCrashUtils.getInnerConfig(context.getApplicationContext(), com.umeng.umcrash.UMCrashContent.APM_STATE_FLUTTER, -1);
            if (isDebug) {
                java.lang.StringBuilder sb11 = new java.lang.StringBuilder();
                sb11.append("inner config : flutter rate is ");
                sb11.append(innerConfig);
            }
            if (innerConfig != 0) {
                boolean z21 = isDebug;
            } else if (innerConfig == 100) {
                boolean z22 = isDebug;
                if (enableFlutterLog) {
                    com.efs.sdk.fluttersdk.FlutterManager.init(mContext, sReporter);
                    try {
                        if (com.efs.sdk.fluttersdk.FlutterManager.getFlutterConfigManager() != null) {
                            isFlutter = com.efs.sdk.fluttersdk.FlutterManager.getFlutterConfigManager().isFlutterEnable();
                        }
                    } catch (java.lang.Throwable th12) {
                        th12.printStackTrace();
                    }
                } else {
                    boolean z23 = isDebug;
                }
            }
            sApmCallbackLimit = com.umeng.umcrash.UMCrashUtils.getInnerConfig(context.getApplicationContext(), com.umeng.umcrash.UMCrashContent.APM_CALLBACK_LIMIT, -1);
            if (isDebug) {
                java.lang.StringBuilder sb12 = new java.lang.StringBuilder();
                sb12.append("inner config : callback limit is ");
                sb12.append(sApmCallbackLimit);
            }
            if (isCodeLog) {
                return;
            }
            com.umeng.logsdk.ULogManager.init(mContext, sReporter);
            return;
        }
        innerConfig6 = com.umeng.umcrash.UMCrashUtils.getInnerConfig(context.getApplicationContext(), com.umeng.umcrash.UMCrashContent.APM_STATE_CODE_LOG, -1);
        if (isDebug) {
        }
        if (innerConfig6 != 0) {
        }
        if (isDebug) {
        }
        initReporter(context, str, str2);
        java.lang.String string2 = sharedPreferences.getString("debugkey", "");
        if (sharedPreferences.getLong("timestamp", 0L) - java.lang.System.currentTimeMillis() >= 0) {
        }
        sharedPreferences.edit().clear().apply();
        com.efs.sdk.base.integrationtesting.IntegrationTestingUtil.setIntegrationTestingInPeriod(false);
        if (enablePaLog) {
        }
        if (enableLaunchLog) {
        }
        if (enableMemLog) {
        }
        innerConfig5 = com.umeng.umcrash.UMCrashUtils.getInnerConfig(context.getApplicationContext(), com.umeng.umcrash.UMCrashContent.APM_STATE_NET, -1);
        if (isDebug) {
        }
        if (innerConfig5 != 0) {
        }
        innerConfig4 = com.umeng.umcrash.UMCrashUtils.getInnerConfig(context.getApplicationContext(), com.umeng.umcrash.UMCrashContent.APM_STATE_NATIVE_H5, -1);
        if (isDebug) {
        }
        if (innerConfig4 != 0) {
        }
        innerConfig3 = com.umeng.umcrash.UMCrashUtils.getInnerConfig(context.getApplicationContext(), com.umeng.umcrash.UMCrashContent.APM_STATE_PAGE, -1);
        if (isDebug) {
        }
        if (innerConfig3 != 0) {
        }
        innerConfig2 = com.umeng.umcrash.UMCrashUtils.getInnerConfig(context.getApplicationContext(), com.umeng.umcrash.UMCrashContent.APM_STATE_POWER, -1);
        if (isDebug) {
        }
        if (innerConfig2 != 0) {
        }
        innerConfig = com.umeng.umcrash.UMCrashUtils.getInnerConfig(context.getApplicationContext(), com.umeng.umcrash.UMCrashContent.APM_STATE_FLUTTER, -1);
        if (isDebug) {
        }
        if (innerConfig != 0) {
        }
        sApmCallbackLimit = com.umeng.umcrash.UMCrashUtils.getInnerConfig(context.getApplicationContext(), com.umeng.umcrash.UMCrashContent.APM_CALLBACK_LIMIT, -1);
        if (isDebug) {
        }
        if (isCodeLog) {
        }
    }

    public static void initConfig(android.os.Bundle bundle) {
        if (bundle != null) {
            if (bundle.getBoolean(KEY_ENABLE_CRASH_JAVA, true)) {
                enableJavaLog = true;
            } else {
                enableJavaLog = false;
            }
            if (bundle.getBoolean(KEY_ENABLE_CRASH_NATIVE, true)) {
                enableNativeLog = true;
            } else {
                enableNativeLog = false;
            }
            if (bundle.getBoolean(KEY_ENABLE_ANR, true)) {
                enableANRLog = true;
            } else {
                enableANRLog = false;
            }
            if (bundle.getBoolean(KEY_ENABLE_PA, true)) {
                enablePaLog = true;
            } else {
                enablePaLog = false;
            }
            if (bundle.getBoolean(KEY_ENABLE_LAUNCH, true)) {
                enableLaunchLog = true;
            } else {
                enableLaunchLog = false;
            }
            if (bundle.getBoolean(KEY_ENABLE_MEM, true)) {
                enableMemLog = true;
            } else {
                enableMemLog = false;
            }
            if (bundle.getBoolean(KEY_ENABLE_NET, true)) {
                enableNetLog = true;
            } else {
                enableNetLog = false;
            }
            if (bundle.getBoolean(KEY_ENABLE_H5PAGE, true)) {
                enableH5PageLog = true;
            } else {
                enableH5PageLog = false;
            }
            paTimeoutTime = bundle.getLong(KEY_PA_TIMEOUT_TIME, 2000L);
            if (bundle.getBoolean(KEY_ENABLE_PAGE, true)) {
                enablePageLog = true;
            } else {
                enablePageLog = false;
            }
            try {
                if (bundle.getBoolean(KEY_ENABLE_CODE_LOG, true)) {
                    enableCodeLog = true;
                } else {
                    enableCodeLog = false;
                }
                com.umeng.logsdk.ULogManager.setUserID(bundle.getString(KEY_LOG_USER_ID, ""));
            } catch (java.lang.Throwable th) {
                th.printStackTrace();
            }
            if (bundle.getBoolean(KEY_ENABLE_POWER, true)) {
                enablePowerLog = true;
            } else {
                enablePowerLog = false;
            }
            if (bundle.getBoolean(KEY_ENABLE_FLUTTER, true)) {
                enableFlutterLog = true;
            } else {
                enableFlutterLog = false;
            }
        }
    }

    private static void initReporter(android.content.Context context, java.lang.String str, java.lang.String str2) {
        java.util.HashMap hashMap = new java.util.HashMap(1);
        hashMap.put(KEY_HEADER_UMID, getUMID(context));
        hashMap.put(KEY_HEADER_CHANNEL, str2);
        hashMap.put(KEY_HEADER_CARRIER, com.umeng.umcrash.UMCrashUtils.getNetworkOperatorName(context));
        hashMap.put(KEY_HEADER_OS, com.aliyun.vod.log.core.AliyunLogCommon.OPERATION_SYSTEM);
        hashMap.put(KEY_HEADER_CRASH_VERSION, crashSdkVersion);
        try {
            java.lang.String[] activeUser = com.umeng.umcrash.UMCrashUtils.getActiveUser(context);
            if (activeUser != null && activeUser.length == 2) {
                hashMap.put(KEY_HEADER_PUID, activeUser[1]);
                hashMap.put(KEY_HEADER_PROVIDER, activeUser[0]);
            }
        } catch (java.lang.Throwable unused) {
            hashMap.put(KEY_HEADER_PUID, "");
            hashMap.put(KEY_HEADER_PROVIDER, "");
        }
        if (!android.text.TextUtils.isEmpty(userBver)) {
            hashMap.put(KEY_HEADER_BVER, userBver);
        }
        if (!android.text.TextUtils.isEmpty(userBsver)) {
            hashMap.put(KEY_HEADER_BSVER, userBsver);
        }
        if (!android.text.TextUtils.isEmpty(userBesrial)) {
            hashMap.put(KEY_HEADER_BESRIAL, userBesrial);
        }
        try {
            if (com.umeng.umcrash.UMCrashUtils.isHarmony(context)) {
                hashMap.put("others_OS", "harmony");
            } else {
                hashMap.put("others_OS", "Android");
            }
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
        com.efs.sdk.base.EfsReporter build = new com.efs.sdk.base.EfsReporter.Builder(context.getApplicationContext(), str, KEY_APM_DEFAULT_SECRET).debug(isDebug).enablePaBackup(sIsEnableLogBackup).efsDirRootName(KEY_APM_ROOT_NAME).printLogDetail(isDebug).intl(isIntl).enableWaStat(false).logUid(com.umeng.logsdk.ULogManager.getUserID()).logDid(com.umeng.logsdk.ULogManager.getDeviceID()).setOpenCodeLog(isCodeLog).build();
        sReporter = build;
        build.addPublicParams(hashMap);
        try {
            if (isCodeLog) {
                sReporter.setFileFilterCodeLog(new com.umeng.logsdk.UploadFileFilterCodeLog());
            }
        } catch (java.lang.Throwable th2) {
            th2.printStackTrace();
        }
        try {
            sReporter.getAllSdkConfig(new java.lang.String[]{com.umeng.umcrash.UMCrashContent.APM_STATE_CODE_LOG, com.umeng.umcrash.UMCrashContent.APM_STATE_HIT_WL, com.umeng.umcrash.UMCrashContent.APM_STATE_FLUTTER, com.umeng.umcrash.UMCrashContent.APM_STATE_POWER, com.umeng.umcrash.UMCrashContent.APM_STATE_PAGE, com.umeng.umcrash.UMCrashContent.APM_STATE_NET, com.umeng.umcrash.UMCrashContent.APM_STATE_NATIVE_H5, com.umeng.umcrash.UMCrashContent.APM_CRASH_JAVA_SAMPLING_RATE, com.umeng.umcrash.UMCrashContent.APM_CRASH_NATIVE_SAMPLING_RATE, com.umeng.umcrash.UMCrashContent.APM_CRASH_ANR_SAMPLING_RATE, com.umeng.umcrash.UMCrashContent.APM_CRASH_USER_SAMPLING_RATE, com.umeng.umcrash.UMCrashContent.APM_CRASH_USER_MAX_COUNT, com.umeng.umcrash.UMCrashContent.APM_CRASH_USER_UPLOAD_TYPE, com.umeng.umcrash.UMCrashContent.APM_CALLBACK_LIMIT}, new com.umeng.umcrash.UMCrash.AnonymousClass6(context));
        } catch (java.lang.Throwable th3) {
            th3.printStackTrace();
        }
    }

    public static void isBuildId(boolean z) {
        isBuildId = z;
    }

    private static void registerInfoCallback(com.uc.crashsdk.export.CrashApi crashApi) {
        crashApi.registerInfoCallback(KEY_CALLBACK_USER_STRING_JAVA, 16);
        crashApi.registerInfoCallback(KEY_CALLBACK_USER_STRING_NATIVE, 1);
        crashApi.registerInfoCallback(KEY_CALLBACK_USER_STRING_ANR, 1048576);
        crashApi.registerInfoCallback(KEY_CALLBACK_USER_STRING_CUSTOM_LOG, 256);
        crashApi.registerInfoCallback(KEY_CALLBACK_UM_INFOS, 1048593);
        crashApi.registerInfoCallback(KEY_CALLBACK_UMID, 1048593);
    }

    public static void registerPerfCallback(com.efs.sdk.base.custommapping.IUMPerfCallback iUMPerfCallback) {
        com.efs.sdk.base.EfsReporter.registerPerfCallback(iUMPerfCallback);
    }

    public static void registerUMCrashCallback(com.umeng.umcrash.IUMCrashCallbackWithType iUMCrashCallbackWithType) {
        if (iUMCrashCallbackWithType != null) {
            mUMCrashCallbackWithType = iUMCrashCallbackWithType;
        }
    }

    public static void registerUMCrashCallback(com.umeng.umcrash.UMCrashCallback uMCrashCallback) {
        if (uMCrashCallback != null) {
            mUMCrashCallback = uMCrashCallback;
            if (com.uc.crashsdk.export.CrashApi.getInstance() != null) {
                com.uc.crashsdk.export.CrashApi.getInstance().registerInfoCallback(KEY_CALLBACK_USER_STRING, 1048593);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void saveActivityState(java.lang.String str, java.lang.String str2) {
        try {
            java.util.ArrayList<java.lang.String> arrayList = mArrayList;
            if (arrayList != null) {
                if (arrayList.size() >= 20) {
                    mArrayList.remove(0);
                }
                mArrayList.add(str + com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER + java.lang.System.currentTimeMillis() + com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER + str2);
            }
        } catch (java.lang.Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void saveLocalCrashSampling(android.content.Context context, java.util.Map<java.lang.String, java.lang.Object> map) {
        if (context == null || map == null) {
            return;
        }
        java.lang.Object obj = map.get(com.umeng.umcrash.UMCrashContent.APM_CRASH_JAVA_SAMPLING_RATE);
        if (obj != null) {
            if (isDebug) {
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                sb.append("callback crashJavaSampling is ");
                sb.append(obj.toString());
            }
            com.umeng.umcrash.UMCrashUtils.saveInnerConfig(context.getApplicationContext(), com.umeng.umcrash.UMCrashContent.APM_CRASH_JAVA_SAMPLING_RATE, obj);
        }
        java.lang.Object obj2 = map.get(com.umeng.umcrash.UMCrashContent.APM_CRASH_NATIVE_SAMPLING_RATE);
        if (obj2 != null) {
            if (isDebug) {
                java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
                sb2.append("callback crashNativeSampling is ");
                sb2.append(obj2.toString());
            }
            com.umeng.umcrash.UMCrashUtils.saveInnerConfig(context.getApplicationContext(), com.umeng.umcrash.UMCrashContent.APM_CRASH_NATIVE_SAMPLING_RATE, obj2);
        }
        java.lang.Object obj3 = map.get(com.umeng.umcrash.UMCrashContent.APM_CRASH_ANR_SAMPLING_RATE);
        if (obj3 != null) {
            if (isDebug) {
                java.lang.StringBuilder sb3 = new java.lang.StringBuilder();
                sb3.append("callback crashANRSampling is ");
                sb3.append(obj3.toString());
            }
            com.umeng.umcrash.UMCrashUtils.saveInnerConfig(context.getApplicationContext(), com.umeng.umcrash.UMCrashContent.APM_CRASH_ANR_SAMPLING_RATE, obj3);
        }
        java.lang.Object obj4 = map.get(com.umeng.umcrash.UMCrashContent.APM_CRASH_USER_SAMPLING_RATE);
        if (obj4 != null) {
            if (isDebug) {
                java.lang.StringBuilder sb4 = new java.lang.StringBuilder();
                sb4.append("callback crashUserSampling is ");
                sb4.append(obj4.toString());
            }
            com.umeng.umcrash.UMCrashUtils.saveInnerConfig(context.getApplicationContext(), com.umeng.umcrash.UMCrashContent.APM_CRASH_USER_SAMPLING_RATE, obj4);
        }
    }

    public static void setAppVersion(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        try {
            if (android.text.TextUtils.isEmpty(str)) {
                boolean z = isDebug;
            } else {
                if (str.trim().getBytes().length > 128) {
                    str = com.umeng.umcrash.UMCrashUtils.splitByByte(str, 128);
                }
                userBver = str;
            }
            if (android.text.TextUtils.isEmpty(str2)) {
                boolean z2 = isDebug;
            } else {
                if (str2.trim().getBytes().length > 128) {
                    str2 = com.umeng.umcrash.UMCrashUtils.splitByByte(str2, 128);
                }
                userBsver = str2;
            }
            if (android.text.TextUtils.isEmpty(str3)) {
                boolean z3 = isDebug;
            } else {
                if (str3.trim().getBytes().length > 128) {
                    str3 = com.umeng.umcrash.UMCrashUtils.splitByByte(str3, 128);
                }
                userBesrial = str3;
            }
            com.uc.crashsdk.export.CrashApi crashApi = com.uc.crashsdk.export.CrashApi.getInstance();
            if (crashApi != null) {
                if (!android.text.TextUtils.isEmpty(userBver)) {
                    crashApi.addHeaderInfo(KEY_HEADER_BVER, userBver);
                }
                if (!android.text.TextUtils.isEmpty(userBsver)) {
                    crashApi.addHeaderInfo(KEY_HEADER_BSVER, userBsver);
                }
                if (!android.text.TextUtils.isEmpty(userBesrial)) {
                    crashApi.addHeaderInfo(KEY_HEADER_BESRIAL, userBesrial);
                }
            } else {
                boolean z4 = isDebug;
            }
            java.util.HashMap hashMap = new java.util.HashMap(1);
            if (!android.text.TextUtils.isEmpty(userBver)) {
                hashMap.put(KEY_HEADER_BVER, userBver);
            }
            if (!android.text.TextUtils.isEmpty(userBsver)) {
                hashMap.put(KEY_HEADER_BSVER, userBsver);
            }
            if (!android.text.TextUtils.isEmpty(userBesrial)) {
                hashMap.put(KEY_HEADER_BESRIAL, userBesrial);
            }
            com.efs.sdk.base.EfsReporter efsReporter = sReporter;
            if (efsReporter != null) {
                efsReporter.addPublicParams(hashMap);
            } else {
                boolean z5 = isDebug;
            }
            if (!android.text.TextUtils.isEmpty(userBver)) {
                com.umeng.umcrash.UMCrashUtils.setCommonTag(KEY_HEADER_BVER, userBver);
            }
            if (!android.text.TextUtils.isEmpty(userBsver)) {
                com.umeng.umcrash.UMCrashUtils.setCommonTag(KEY_HEADER_BSVER, userBsver);
            }
            if (android.text.TextUtils.isEmpty(userBesrial)) {
                return;
            }
            com.umeng.umcrash.UMCrashUtils.setCommonTag(KEY_HEADER_BESRIAL, userBesrial);
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    public static void setDebug(boolean z) {
        isDebug = z;
        com.efs.sdk.launch.LaunchManager.isDebug = z;
        com.efs.sdk.h5pagesdk.H5Manager.isDebug = z;
        com.umeng.pagesdk.PageManger.isDebug = z;
        com.umeng.powersdk.PowerManager.isDebug = z;
        com.umeng.logsdk.ULogManager.isDebug = z;
    }

    public static void setPaTimeoutTime(long j) {
        paTimeoutTime = j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void updateLocalCrashConfig(android.content.Context context, java.util.Map<java.lang.String, java.lang.Object> map) {
        if (context == null || map == null) {
            return;
        }
        android.os.Bundle bundle = new android.os.Bundle();
        java.lang.Object obj = map.get(com.umeng.umcrash.UMCrashContent.APM_CRASH_USER_MAX_COUNT);
        if (obj != null) {
            if (isDebug) {
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                sb.append("callback crashMaxUserCount is ");
                sb.append(obj.toString());
            }
            bundle.putInt("mMaxCustomLogCountPerTypePerDay", java.lang.Integer.valueOf(obj.toString()).intValue());
            bundle.putInt("mMaxUploadCustomLogCountPerDay", java.lang.Integer.valueOf(obj.toString()).intValue());
        }
        com.uc.crashsdk.export.CrashApi.getInstance().updateCustomInfo(bundle);
    }

    private static void updateLocalCrashSampling(java.lang.Object obj, java.lang.Object obj2, java.lang.Object obj3, java.lang.Object obj4) {
        com.uc.crashsdk.export.CrashApi crashApi = com.uc.crashsdk.export.CrashApi.getInstance();
        if (crashApi != null) {
            if (obj != null && com.umeng.umcrash.UMCrashUtils.random(java.lang.Integer.valueOf(obj.toString()).intValue())) {
                crashApi.disableLog(16);
            }
            if (obj2 != null && com.umeng.umcrash.UMCrashUtils.random(java.lang.Integer.valueOf(obj2.toString()).intValue())) {
                crashApi.disableLog(1);
            }
            if (obj3 != null && com.umeng.umcrash.UMCrashUtils.random(java.lang.Integer.valueOf(obj3.toString()).intValue())) {
                crashApi.disableLog(1048576);
            }
            if (obj4 == null || !com.umeng.umcrash.UMCrashUtils.random(java.lang.Integer.valueOf(obj4.toString()).intValue())) {
                return;
            }
            isOpenUserCrash = false;
        }
    }

    private static void useIntlServices(boolean z) {
        isIntl = z;
        if (isDebug) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("useIntlServices is ");
            sb.append(isIntl);
        }
    }
}
