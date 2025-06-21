package com.huawei.hms.framework.common.hianalytics;

/* loaded from: classes22.dex */
public class HianalyticsHelper {
    private static final java.lang.String DEAULT_HA_SERVICE_TAG = "_default_config_tag";
    private static final java.lang.String HWID_HA_SERVICE_TAG = "hms_hwid";
    private static final java.lang.String TAG = "HianalyticsHelper";
    private static final int TYPE_MAINTF = 1;
    private static final java.lang.String USER_EXPERIENCE_INVOLVED = "user_experience_involved";
    private static final int USER_EXPERIENCE_ON = 1;

    @android.annotation.SuppressLint({"StaticFieldLeak"})
    private static volatile com.huawei.hms.framework.common.hianalytics.HianalyticsHelper instance;
    private boolean hasHMSBI;
    private boolean hasHianalytics;
    private java.lang.String haTag = HWID_HA_SERVICE_TAG;
    private com.huawei.hianalytics.process.HiAnalyticsInstance hInstance = null;
    private com.huawei.hianalytics.process.HiAnalyticsInstance defaultInstance = null;
    private boolean isEnablePrivacyPolicy = false;
    private java.util.concurrent.ExecutorService reportExecutor = com.huawei.hms.framework.common.ExecutorsUtils.newSingleThreadExecutor("report_ha");

    /* renamed from: com.huawei.hms.framework.common.hianalytics.HianalyticsHelper$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {
        final /* synthetic */ java.lang.Throwable val$e;
        final /* synthetic */ java.lang.String val$eventId;
        final /* synthetic */ java.lang.String val$threadName;

        public AnonymousClass1(java.lang.String str, java.lang.Throwable th, java.lang.String str2) {
            this.val$threadName = str;
            this.val$e = th;
            this.val$eventId = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData crashHianalyticsData = new com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData();
            crashHianalyticsData.put("sdk_version", "5.0.10.302");
            crashHianalyticsData.put(com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData.CRASH_TYPE, "exception");
            crashHianalyticsData.put(com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData.THREAD_NAME, this.val$threadName);
            crashHianalyticsData.put(com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData.EXCEPTION_NAME, this.val$e.getClass().getName());
            crashHianalyticsData.put("message", com.huawei.hms.framework.common.StringUtils.anonymizeMessage(this.val$e.getMessage()));
            crashHianalyticsData.put(com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData.STACK_TRACE, com.huawei.hms.framework.common.StringUtils.getTraceInfo(this.val$e));
            com.huawei.hms.framework.common.hianalytics.HianalyticsHelper.getInstance().onEvent(crashHianalyticsData.get(), this.val$eventId);
        }
    }

    public static class HianalyticsRunnable implements java.lang.Runnable {
        private final com.huawei.hms.framework.common.hianalytics.HianalyticsBaseData data;
        private final java.lang.String event;

        public HianalyticsRunnable(com.huawei.hms.framework.common.hianalytics.HianalyticsBaseData hianalyticsBaseData, java.lang.String str) {
            this.data = hianalyticsBaseData;
            this.event = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.huawei.hms.framework.common.hianalytics.HianalyticsHelper.getInstance().onEvent(this.data.get(), this.event);
        }
    }

    private HianalyticsHelper() {
        try {
            com.huawei.hianalytics.process.HiAnalyticsManager.getInitFlag(DEAULT_HA_SERVICE_TAG);
            this.hasHianalytics = true;
        } catch (java.lang.Throwable unused) {
            com.huawei.hms.framework.common.Logger.i(TAG, "Hianalytics sdk not found");
            this.hasHianalytics = false;
        }
        if (!this.hasHianalytics) {
            tryHMSBIInit(com.huawei.hms.framework.common.ContextHolder.getAppContext());
        }
        com.huawei.hms.framework.common.Logger.v(TAG, "this time the ha %s, mini %s", java.lang.Boolean.valueOf(this.hasHianalytics), java.lang.Boolean.valueOf(this.hasHMSBI));
    }

    public static com.huawei.hms.framework.common.hianalytics.HianalyticsHelper getInstance() {
        if (instance == null) {
            synchronized (com.huawei.hms.framework.common.hianalytics.HianalyticsHelper.class) {
                if (instance == null) {
                    instance = new com.huawei.hms.framework.common.hianalytics.HianalyticsHelper();
                }
            }
        }
        return instance;
    }

    private boolean isHianalyticsOk() {
        if (com.huawei.hianalytics.process.HiAnalyticsManager.getInitFlag(DEAULT_HA_SERVICE_TAG)) {
            if (this.defaultInstance == null) {
                this.defaultInstance = com.huawei.hianalytics.process.HiAnalyticsManager.getInstanceByTag(DEAULT_HA_SERVICE_TAG);
            }
            return this.defaultInstance != null;
        }
        if (this.hInstance == null) {
            this.hInstance = com.huawei.hianalytics.process.HiAnalyticsManager.getInstanceByTag(this.haTag);
        }
        return this.hInstance != null;
    }

    private void onNewEvent(android.content.Context context, java.lang.String str, java.util.Map map, int i) {
        if (context == null || map == null) {
            return;
        }
        com.huawei.hms.framework.common.Logger.v(TAG, "data = %s", map);
        try {
            com.huawei.hms.support.hianalytics.HiAnalyticsUtils.getInstance().onNewEvent(context, str, map, i);
        } catch (java.lang.NoSuchMethodError unused) {
            com.huawei.hms.framework.common.Logger.w(TAG, "may be you need upgrade stats sdk");
        } catch (java.lang.Throwable unused2) {
            com.huawei.hms.framework.common.Logger.i(TAG, "the stats has other error,pls check it");
        }
    }

    private void tryHMSBIInit(android.content.Context context) {
        if (context == null) {
            com.huawei.hms.framework.common.Logger.i(TAG, "the appContext hasn't init");
            return;
        }
        try {
            com.huawei.hms.utils.HMSBIInitializer.getInstance(context).initBI();
            this.hasHMSBI = true;
        } catch (java.lang.NoClassDefFoundError unused) {
            com.huawei.hms.framework.common.Logger.w(TAG, "maybe you need add base sdk!");
        } catch (java.lang.Throwable unused2) {
            com.huawei.hms.framework.common.Logger.w(TAG, "the hms base has other error!");
        }
    }

    public void enablePrivacyPolicy(boolean z) {
        this.isEnablePrivacyPolicy = z;
    }

    public void executeReportHa(com.huawei.hms.framework.common.hianalytics.HianalyticsBaseData hianalyticsBaseData, java.lang.String str) {
        getReportExecutor().execute(new com.huawei.hms.framework.common.hianalytics.HianalyticsHelper.HianalyticsRunnable(hianalyticsBaseData, str));
    }

    public java.util.concurrent.ExecutorService getReportExecutor() {
        return this.reportExecutor;
    }

    public boolean isEnableReport(android.content.Context context) {
        if (this.hasHMSBI) {
            return true;
        }
        if (this.hasHianalytics) {
            return isEnableReportNoSeed(context);
        }
        return false;
    }

    public boolean isEnableReportNoSeed(android.content.Context context) {
        if (this.hasHMSBI) {
            return true;
        }
        if (!this.hasHianalytics) {
            com.huawei.hms.framework.common.Logger.i(TAG, "Hianalytics sdk need to be initialized");
            return false;
        }
        if (context == null) {
            com.huawei.hms.framework.common.Logger.i(TAG, "HianalyticsHelper context can't be null");
            return false;
        }
        if (this.isEnablePrivacyPolicy) {
            return isHianalyticsOk();
        }
        try {
            if (android.provider.Settings.Secure.getInt(context.getContentResolver(), USER_EXPERIENCE_INVOLVED, -1) == 1) {
                return isHianalyticsOk();
            }
        } catch (java.lang.IllegalStateException unused) {
            com.huawei.hms.framework.common.Logger.w(TAG, "the setting has illegalStateException");
        } catch (java.lang.Throwable unused2) {
            com.huawei.hms.framework.common.Logger.w(TAG, "the setting has other error");
        }
        com.huawei.hms.framework.common.Logger.i(TAG, "user experience involved needs to be opened");
        return false;
    }

    public void onEvent(java.util.LinkedHashMap<java.lang.String, java.lang.String> linkedHashMap) {
        onEvent(linkedHashMap, com.huawei.hms.framework.common.hianalytics.HianalyticsBaseData.EVENT_ID);
    }

    public void onEvent(java.util.LinkedHashMap<java.lang.String, java.lang.String> linkedHashMap, java.lang.String str) {
        onEvent(linkedHashMap, str, 1);
    }

    public void onEvent(java.util.LinkedHashMap<java.lang.String, java.lang.String> linkedHashMap, java.lang.String str, int i) {
        com.huawei.hianalytics.process.HiAnalyticsInstance hiAnalyticsInstance;
        if (this.hasHMSBI) {
            onNewEvent(com.huawei.hms.framework.common.ContextHolder.getAppContext(), str, linkedHashMap, i);
        } else if (i == 0) {
            com.huawei.hms.framework.common.Logger.v(TAG, "the base sdk isn't exsit, and reportType is %s", java.lang.Integer.valueOf(i));
            return;
        }
        if (this.hasHianalytics && linkedHashMap != null) {
            com.huawei.hms.framework.common.Logger.v(TAG, "data = %s", linkedHashMap);
            if (com.huawei.hianalytics.process.HiAnalyticsManager.getInitFlag(DEAULT_HA_SERVICE_TAG) && (hiAnalyticsInstance = this.defaultInstance) != null) {
                hiAnalyticsInstance.onEvent(1, str, linkedHashMap);
                return;
            }
            com.huawei.hianalytics.process.HiAnalyticsInstance hiAnalyticsInstance2 = this.hInstance;
            if (hiAnalyticsInstance2 != null) {
                hiAnalyticsInstance2.onEvent(1, str, linkedHashMap);
            } else {
                com.huawei.hms.framework.common.Logger.e(TAG, "the ha has error,has init but is null!");
            }
        }
    }

    public void reportData(android.content.Context context, java.util.LinkedHashMap<java.lang.String, java.lang.String> linkedHashMap, java.lang.String str, int i) {
        if (isEnableReportNoSeed(context)) {
            onEvent(linkedHashMap, str, i);
        }
    }

    public void reportException(java.lang.Throwable th, java.lang.String str) {
        if (getInstance().isEnableReport(com.huawei.hms.framework.common.ContextHolder.getAppContext())) {
            try {
                this.reportExecutor.submit(new com.huawei.hms.framework.common.hianalytics.HianalyticsHelper.AnonymousClass1(java.lang.Thread.currentThread().getName(), th, str));
            } catch (java.util.concurrent.RejectedExecutionException unused) {
                com.huawei.hms.framework.common.Logger.i(TAG, "reportException error RejectedExecutionException");
            } catch (java.lang.Exception unused2) {
                com.huawei.hms.framework.common.Logger.i(TAG, "reportException error!", th);
            }
        }
    }

    public void setHaTag(java.lang.String str) {
        this.haTag = str;
    }
}
