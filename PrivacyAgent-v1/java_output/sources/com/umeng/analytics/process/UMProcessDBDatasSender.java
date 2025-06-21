package com.umeng.analytics.process;

/* loaded from: classes19.dex */
public class UMProcessDBDatasSender implements com.umeng.commonsdk.framework.UMLogDataProtocol {
    public static final int UM_PROCESS_CONSTRUCTMESSAGE = 36946;
    public static final int UM_PROCESS_EVENT_KEY = 36945;
    private static java.util.concurrent.ScheduledThreadPoolExecutor executor = new java.util.concurrent.ScheduledThreadPoolExecutor(1);
    private static com.umeng.analytics.process.UMProcessDBDatasSender mInstance;
    private android.content.Context mContext;
    private java.util.List<java.lang.Integer> mGeneralBodyIds;
    private com.umeng.commonsdk.utils.FileLockUtil mLockUtil = new com.umeng.commonsdk.utils.FileLockUtil();
    private com.umeng.analytics.pro.q.c mPolicySelector;

    /* renamed from: com.umeng.analytics.process.UMProcessDBDatasSender$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {
        public AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public void run() {
            com.umeng.commonsdk.debug.UMRTLog.i(com.umeng.commonsdk.debug.UMRTLog.RTLOG_TAG, "--->>> call processDBToMain start.");
            com.umeng.analytics.process.UMProcessDBHelper.getInstance(com.umeng.analytics.process.UMProcessDBDatasSender.this.mContext).processDBToMain();
        }
    }

    public class ConstructMessageCallback implements com.umeng.commonsdk.utils.FileLockCallback {
        private ConstructMessageCallback() {
        }

        public /* synthetic */ ConstructMessageCallback(com.umeng.analytics.process.UMProcessDBDatasSender uMProcessDBDatasSender, com.umeng.analytics.process.UMProcessDBDatasSender.AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // com.umeng.commonsdk.utils.FileLockCallback
        public boolean onFileLock(java.io.File file, int i) {
            return false;
        }

        @Override // com.umeng.commonsdk.utils.FileLockCallback
        public boolean onFileLock(java.lang.String str) {
            org.json.JSONObject buildEnvelopeWithExtHeader;
            com.umeng.analytics.process.UMProcessDBDatasSender uMProcessDBDatasSender = com.umeng.analytics.process.UMProcessDBDatasSender.this;
            org.json.JSONObject jSONObject = uMProcessDBDatasSender.setupReportData(com.umeng.commonsdk.framework.UMEnvelopeBuild.maxDataSpace(uMProcessDBDatasSender.mContext));
            if (jSONObject != null && jSONObject.length() >= 1) {
                org.json.JSONObject jSONObject2 = (org.json.JSONObject) jSONObject.opt("header");
                org.json.JSONObject jSONObject3 = (org.json.JSONObject) jSONObject.opt("content");
                if (com.umeng.analytics.process.UMProcessDBDatasSender.this.mContext != null && jSONObject2 != null && jSONObject3 != null && (buildEnvelopeWithExtHeader = com.umeng.commonsdk.framework.UMEnvelopeBuild.buildEnvelopeWithExtHeader(com.umeng.analytics.process.UMProcessDBDatasSender.this.mContext, jSONObject2, jSONObject3)) != null) {
                    com.umeng.analytics.process.UMProcessDBDatasSender.this.removeCacheData(buildEnvelopeWithExtHeader);
                }
            }
            return true;
        }

        @Override // com.umeng.commonsdk.utils.FileLockCallback
        public boolean onFileLock(java.lang.String str, java.lang.Object obj) {
            return false;
        }
    }

    public class ReplaceCallback implements com.umeng.commonsdk.utils.FileLockCallback {
        private ReplaceCallback() {
        }

        public /* synthetic */ ReplaceCallback(com.umeng.analytics.process.UMProcessDBDatasSender uMProcessDBDatasSender, com.umeng.analytics.process.UMProcessDBDatasSender.AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // com.umeng.commonsdk.utils.FileLockCallback
        public boolean onFileLock(java.io.File file, int i) {
            return false;
        }

        @Override // com.umeng.commonsdk.utils.FileLockCallback
        public boolean onFileLock(java.lang.String str) {
            if (android.text.TextUtils.isEmpty(str)) {
                return true;
            }
            java.lang.String str2 = com.umeng.analytics.process.a.c;
            if (str.startsWith(str2)) {
                str = str.replaceFirst(str2, "");
            }
            com.umeng.analytics.process.UMProcessDBHelper.getInstance(com.umeng.analytics.process.UMProcessDBDatasSender.this.mContext).deleteEventDatas(str.replace(com.umeng.analytics.process.a.d, ""), null, null);
            return true;
        }

        @Override // com.umeng.commonsdk.utils.FileLockCallback
        public boolean onFileLock(java.lang.String str, java.lang.Object obj) {
            return false;
        }
    }

    private UMProcessDBDatasSender() {
    }

    private void constructMessage() {
        if (defconProcesserHandler() != 0) {
            return;
        }
        this.mLockUtil.doFileOperateion(com.umeng.analytics.process.b.b(this.mContext, ""), new com.umeng.analytics.process.UMProcessDBDatasSender.ConstructMessageCallback(this, null));
    }

    private int defconProcesserHandler() {
        int a = com.umeng.analytics.pro.t.a().a(this.mContext);
        if (a != 0) {
            try {
                com.umeng.analytics.process.DBFileTraversalUtil.traverseDBFiles(com.umeng.analytics.process.b.a(this.mContext), new com.umeng.analytics.process.UMProcessDBDatasSender.ReplaceCallback(this, null), null);
            } catch (java.lang.Exception unused) {
            }
            com.umeng.analytics.process.UMProcessDBHelper.getInstance(this.mContext).deleteEventDatas(com.umeng.analytics.process.a.h, null, null);
        }
        return a;
    }

    private org.json.JSONObject generalBody() {
        org.json.JSONObject jSONObject = null;
        try {
            if (this.mGeneralBodyIds == null) {
                this.mGeneralBodyIds = new java.util.ArrayList();
            }
            jSONObject = com.umeng.analytics.process.UMProcessDBHelper.getInstance(this.mContext).readMainEvents(com.umeng.commonsdk.framework.UMEnvelopeBuild.maxDataSpace(this.mContext) - 2000, this.mGeneralBodyIds);
            android.content.SharedPreferences sharedPreferences = com.umeng.commonsdk.statistics.internal.PreferenceWrapper.getDefault(this.mContext);
            if (sharedPreferences != null) {
                java.lang.String string = sharedPreferences.getString("userlevel", "");
                if (!android.text.TextUtils.isEmpty(string)) {
                    jSONObject.put("userlevel", string);
                }
            }
            java.lang.String[] a = com.umeng.analytics.c.a(this.mContext);
            if (a != null && !android.text.TextUtils.isEmpty(a[0]) && !android.text.TextUtils.isEmpty(a[1])) {
                org.json.JSONObject jSONObject2 = new org.json.JSONObject();
                jSONObject2.put(com.umeng.analytics.pro.f.M, a[0]);
                jSONObject2.put(com.umeng.analytics.pro.f.N, a[1]);
                if (jSONObject2.length() > 0) {
                    jSONObject.put(com.umeng.analytics.pro.f.L, jSONObject2);
                }
            }
            if (com.umeng.commonsdk.statistics.noise.ABTest.getService(this.mContext).isInTest()) {
                org.json.JSONObject jSONObject3 = new org.json.JSONObject();
                jSONObject3.put(com.umeng.commonsdk.statistics.noise.ABTest.getService(this.mContext).getTestName(), com.umeng.commonsdk.statistics.noise.ABTest.getService(this.mContext).getGroupInfo());
                jSONObject.put(com.umeng.analytics.pro.f.K, jSONObject3);
            }
        } catch (java.lang.Throwable unused) {
        }
        return jSONObject;
    }

    private org.json.JSONObject generalHeader() {
        java.lang.String str;
        java.lang.String str2;
        org.json.JSONObject readVersionInfoFromColumId;
        java.lang.String str3;
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        try {
            if (com.umeng.analytics.AnalyticsConfig.mWrapperType != null && (str3 = com.umeng.analytics.AnalyticsConfig.mWrapperVersion) != null) {
                jSONObject.put("wrapper_version", str3);
                jSONObject.put("wrapper_type", com.umeng.analytics.AnalyticsConfig.mWrapperType);
            }
            jSONObject.put(com.umeng.analytics.pro.f.i, com.umeng.analytics.AnalyticsConfig.getVerticalType(this.mContext));
            java.lang.String str4 = "9.7.5";
            if (com.umeng.analytics.AnalyticsConfig.getVerticalType(this.mContext) == 1) {
                java.lang.String gameSdkVersion = com.umeng.analytics.AnalyticsConfig.getGameSdkVersion(this.mContext);
                if (!android.text.TextUtils.isEmpty(gameSdkVersion)) {
                    str4 = gameSdkVersion;
                }
                jSONObject.put("sdk_version", str4);
            } else {
                jSONObject.put("sdk_version", "9.7.5");
            }
            if (this.mGeneralBodyIds.size() <= 0 || (readVersionInfoFromColumId = com.umeng.analytics.process.UMProcessDBHelper.getInstance(this.mContext).readVersionInfoFromColumId(this.mGeneralBodyIds.get(0))) == null) {
                str = "";
                str2 = "";
            } else {
                str = readVersionInfoFromColumId.optString("__av");
                str2 = readVersionInfoFromColumId.optString("__vc");
            }
            if (android.text.TextUtils.isEmpty(str)) {
                jSONObject.put("app_version", com.umeng.commonsdk.utils.UMUtils.getAppVersionName(this.mContext));
            } else {
                jSONObject.put("app_version", str);
            }
            if (android.text.TextUtils.isEmpty(str2)) {
                jSONObject.put("version_code", com.umeng.commonsdk.utils.UMUtils.getAppVersionCode(this.mContext));
            } else {
                jSONObject.put("version_code", str2);
            }
            java.lang.String MD5 = com.umeng.commonsdk.statistics.common.HelperUtils.MD5(com.umeng.analytics.AnalyticsConfig.getSecretKey(this.mContext));
            if (!android.text.TextUtils.isEmpty(MD5)) {
                jSONObject.put("secret", MD5);
            }
            java.lang.String imprintProperty = com.umeng.commonsdk.framework.UMEnvelopeBuild.imprintProperty(this.mContext, "pr_ve", null);
            android.content.SharedPreferences sharedPreferences = com.umeng.commonsdk.statistics.internal.PreferenceWrapper.getDefault(this.mContext);
            jSONObject.put(com.umeng.analytics.pro.f.l, com.umeng.commonsdk.framework.UMEnvelopeBuild.imprintProperty(this.mContext, "pr_ve", null));
            jSONObject.put(com.umeng.analytics.pro.f.m, com.umeng.commonsdk.framework.UMEnvelopeBuild.imprintProperty(this.mContext, "ud_da", null));
            jSONObject.put(com.umeng.analytics.pro.f.an, "1.0.0");
            if (android.text.TextUtils.isEmpty(imprintProperty)) {
                jSONObject.put(com.umeng.analytics.pro.f.l, sharedPreferences.getString("vers_pre_version", "0"));
                jSONObject.put(com.umeng.analytics.pro.f.m, sharedPreferences.getString("vers_date", new java.text.SimpleDateFormat("yyyy-MM-dd", java.util.Locale.getDefault()).format(new java.util.Date(java.lang.System.currentTimeMillis()))));
            }
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
        return jSONObject;
    }

    public static com.umeng.analytics.process.UMProcessDBDatasSender getInstance(android.content.Context context) {
        if (mInstance == null) {
            synchronized (com.umeng.analytics.process.UMProcessDBDatasSender.class) {
                if (mInstance == null) {
                    mInstance = new com.umeng.analytics.process.UMProcessDBDatasSender();
                }
            }
        }
        com.umeng.analytics.process.UMProcessDBDatasSender uMProcessDBDatasSender = mInstance;
        uMProcessDBDatasSender.mContext = context;
        return uMProcessDBDatasSender;
    }

    @Override // com.umeng.commonsdk.framework.UMLogDataProtocol
    public void removeCacheData(java.lang.Object obj) {
        java.util.List<java.lang.Integer> list;
        org.json.JSONObject optJSONObject;
        if (obj == null || (list = this.mGeneralBodyIds) == null || list.size() == 0) {
            return;
        }
        org.json.JSONObject jSONObject = (org.json.JSONObject) obj;
        if (!jSONObject.has(com.umeng.commonsdk.statistics.b.a("analytics")) || (optJSONObject = jSONObject.optJSONObject(com.umeng.commonsdk.statistics.b.a("analytics"))) == null || optJSONObject.length() <= 0 || !optJSONObject.has("ekv")) {
            return;
        }
        com.umeng.analytics.process.UMProcessDBHelper.getInstance(this.mContext).deleteMainProcessEventDatasByIds(this.mGeneralBodyIds);
        this.mGeneralBodyIds.clear();
    }

    @Override // com.umeng.commonsdk.framework.UMLogDataProtocol
    public org.json.JSONObject setupReportData(long j) {
        int a = com.umeng.analytics.pro.t.a().a(this.mContext);
        org.json.JSONObject generalBody = generalBody();
        if (generalBody.length() <= 0) {
            return null;
        }
        org.json.JSONObject generalHeader = generalHeader();
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        try {
            org.json.JSONObject jSONObject2 = new org.json.JSONObject();
            if (a == 3) {
                jSONObject2.put("analytics", new org.json.JSONObject());
            } else if (generalBody.length() > 0) {
                jSONObject2.put("analytics", generalBody);
            }
            if (generalHeader != null && generalHeader.length() > 0) {
                jSONObject.put("header", generalHeader);
            }
            if (jSONObject2.length() > 0) {
                if (jSONObject2.has("analytics")) {
                    org.json.JSONObject optJSONObject = jSONObject2.optJSONObject("analytics");
                    if (optJSONObject.length() == 1 && (optJSONObject.optJSONObject(com.umeng.analytics.pro.f.L) != null || !android.text.TextUtils.isEmpty(optJSONObject.optString("userlevel")))) {
                        return null;
                    }
                    if (optJSONObject.length() == 2 && optJSONObject.optJSONObject(com.umeng.analytics.pro.f.L) != null && !android.text.TextUtils.isEmpty(optJSONObject.optString("userlevel"))) {
                        return null;
                    }
                }
                jSONObject.put("content", jSONObject2);
            }
        } catch (java.lang.Throwable unused) {
        }
        return jSONObject;
    }

    @Override // com.umeng.commonsdk.framework.UMLogDataProtocol
    public void workEvent(java.lang.Object obj, int i) {
        if (com.umeng.commonsdk.utils.UMUtils.isMainProgress(this.mContext) && !com.umeng.commonsdk.utils.c.a()) {
            switch (i) {
                case UM_PROCESS_EVENT_KEY /* 36945 */:
                    executor.schedule(new com.umeng.analytics.process.UMProcessDBDatasSender.AnonymousClass1(), 5L, java.util.concurrent.TimeUnit.SECONDS);
                    break;
                case UM_PROCESS_CONSTRUCTMESSAGE /* 36946 */:
                    com.umeng.commonsdk.debug.UMRTLog.i(com.umeng.commonsdk.debug.UMRTLog.RTLOG_TAG, "--->>> recv UM_PROCESS_CONSTRUCTMESSAGE msg.");
                    constructMessage();
                    break;
            }
        }
    }
}
