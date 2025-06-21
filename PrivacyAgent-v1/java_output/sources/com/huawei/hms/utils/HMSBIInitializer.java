package com.huawei.hms.utils;

/* loaded from: classes22.dex */
public class HMSBIInitializer {
    public static final java.lang.Object d = new java.lang.Object();
    public static com.huawei.hms.utils.HMSBIInitializer e;
    public static com.huawei.hianalytics.process.HiAnalyticsInstance f;
    public final android.content.Context a;
    public java.util.concurrent.atomic.AtomicBoolean b = new java.util.concurrent.atomic.AtomicBoolean(false);
    public boolean c = com.huawei.hms.stats.c.a();

    public class a implements com.huawei.hms.framework.network.grs.IQueryUrlCallBack {
        public a() {
        }

        @Override // com.huawei.hms.framework.network.grs.IQueryUrlCallBack
        public void onCallBackFail(int i) {
            com.huawei.hms.support.log.HMSLog.e("HMSBIInitializer", "get grs failed, the errorcode is " + i);
            com.huawei.hms.utils.HMSBIInitializer.this.b.set(false);
        }

        @Override // com.huawei.hms.framework.network.grs.IQueryUrlCallBack
        public void onCallBackSuccess(java.lang.String str) {
            if (!android.text.TextUtils.isEmpty(str)) {
                if (com.huawei.hms.utils.HMSBIInitializer.this.c) {
                    com.huawei.hianalytics.process.HiAnalyticsConfig build = new com.huawei.hianalytics.process.HiAnalyticsConfig.Builder().setEnableImei(false).setEnableUDID(false).setEnableSN(false).setCollectURL(str).build();
                    com.huawei.hianalytics.process.HiAnalyticsInstance unused = com.huawei.hms.utils.HMSBIInitializer.f = new com.huawei.hianalytics.process.HiAnalyticsInstance.Builder(com.huawei.hms.utils.HMSBIInitializer.this.a).setOperConf(build).setMaintConf(new com.huawei.hianalytics.process.HiAnalyticsConfig.Builder().setEnableImei(false).setEnableUDID(false).setEnableSN(false).setCollectURL(str).build()).create(com.huawei.hms.support.hianalytics.HiAnalyticsConstant.HA_SERVICE_TAG);
                    com.huawei.hms.utils.HMSBIInitializer.f.setAppid("com.huawei.hwid");
                } else {
                    com.huawei.hms.hatool.HmsHiAnalyticsUtils.init(com.huawei.hms.utils.HMSBIInitializer.this.a, false, false, false, str, "com.huawei.hwid");
                }
                com.huawei.hms.support.log.HMSLog.i("HMSBIInitializer", "BI URL acquired successfully");
            }
            com.huawei.hms.utils.HMSBIInitializer.this.b.set(false);
        }
    }

    public class b extends android.os.AsyncTask<java.lang.String, java.lang.Integer, java.lang.Void> {
        public b() {
        }

        public /* synthetic */ b(com.huawei.hms.utils.HMSBIInitializer hMSBIInitializer, com.huawei.hms.utils.HMSBIInitializer.a aVar) {
            this();
        }

        @Override // android.os.AsyncTask
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public java.lang.Void doInBackground(java.lang.String... strArr) {
            com.huawei.hms.utils.HMSBIInitializer.this.a(strArr[0]);
            return null;
        }
    }

    public HMSBIInitializer(android.content.Context context) {
        this.a = context;
    }

    public static com.huawei.hms.utils.HMSBIInitializer getInstance(android.content.Context context) {
        synchronized (d) {
            if (e == null) {
                android.content.Context applicationContext = context.getApplicationContext();
                if (applicationContext != null) {
                    e = new com.huawei.hms.utils.HMSBIInitializer(applicationContext);
                } else {
                    e = new com.huawei.hms.utils.HMSBIInitializer(context);
                }
            }
        }
        return e;
    }

    public final void a(java.lang.String str) {
        com.huawei.hms.support.log.HMSLog.i("HMSBIInitializer", "Start to query GRS");
        com.huawei.hms.framework.network.grs.GrsBaseInfo grsBaseInfo = new com.huawei.hms.framework.network.grs.GrsBaseInfo();
        grsBaseInfo.setIssueCountry(str);
        new com.huawei.hms.framework.network.grs.GrsClient(this.a, grsBaseInfo).ayncGetGrsUrl("com.huawei.cloud.opensdkhianalytics", "ROOTV2", new com.huawei.hms.utils.HMSBIInitializer.a());
    }

    public com.huawei.hianalytics.process.HiAnalyticsInstance getAnalyticsInstance() {
        return f;
    }

    public void initBI() {
        boolean initFlag = !this.c ? com.huawei.hms.hatool.HmsHiAnalyticsUtils.getInitFlag() : com.huawei.hianalytics.process.HiAnalyticsManager.getInitFlag(com.huawei.hms.support.hianalytics.HiAnalyticsConstant.HA_SERVICE_TAG);
        com.huawei.hms.support.log.HMSLog.i("HMSBIInitializer", "Builder->biInitFlag :" + initFlag);
        if (initFlag || com.huawei.hms.stats.a.c(this.a) || !this.b.compareAndSet(false, true)) {
            return;
        }
        java.lang.String issueCountryCode = com.huawei.hms.framework.network.grs.GrsApp.getInstance().getIssueCountryCode(this.a);
        if (!android.text.TextUtils.isEmpty(issueCountryCode)) {
            issueCountryCode = issueCountryCode.toUpperCase(java.util.Locale.ENGLISH);
        }
        if (!com.huawei.hms.framework.network.grs.GrsBaseInfo.CountryCodeSource.UNKNOWN.equalsIgnoreCase(issueCountryCode) && !android.text.TextUtils.isEmpty(issueCountryCode)) {
            new com.huawei.hms.utils.HMSBIInitializer.b(this, null).execute(issueCountryCode);
        } else {
            com.huawei.hms.support.log.HMSLog.e("HMSBIInitializer", "Failed to get device issue country");
            this.b.set(false);
        }
    }

    public boolean isInit() {
        return !this.c ? com.huawei.hms.hatool.HmsHiAnalyticsUtils.getInitFlag() : com.huawei.hianalytics.process.HiAnalyticsManager.getInitFlag(com.huawei.hms.support.hianalytics.HiAnalyticsConstant.HA_SERVICE_TAG);
    }
}
