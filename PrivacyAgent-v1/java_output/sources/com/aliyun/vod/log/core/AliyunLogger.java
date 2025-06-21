package com.aliyun.vod.log.core;

/* loaded from: classes12.dex */
public class AliyunLogger {
    private static final java.lang.String KEY_SHARED_PREFERENCE = "aliyun_svideo_global_info";
    private static final java.lang.String TAG = "AliyunLogger";
    private java.lang.String appVersion;
    private java.lang.ref.WeakReference<android.content.Context> mContextRef;
    private com.aliyun.vod.log.core.LogService mLogService;
    private java.lang.String mRequestID = null;
    private boolean canModify = true;
    private boolean productSVideo = false;
    private java.lang.String domainRegion = null;
    private com.aliyun.vod.log.core.LogService mHttpService = new com.aliyun.vod.log.core.LogService(java.lang.String.valueOf(java.lang.System.currentTimeMillis()));

    /* renamed from: com.aliyun.vod.log.core.AliyunLogger$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {
        final /* synthetic */ java.util.Map val$args;
        final /* synthetic */ android.content.Context val$context;
        final /* synthetic */ int val$eventId;
        final /* synthetic */ java.lang.String val$logLevel;
        final /* synthetic */ java.lang.String val$logstore;
        final /* synthetic */ java.lang.String val$module;
        final /* synthetic */ java.lang.String val$product;
        final /* synthetic */ java.lang.String val$requestID;
        final /* synthetic */ java.lang.String val$subModule;

        /* renamed from: com.aliyun.vod.log.core.AliyunLogger$1$1, reason: invalid class name and collision with other inner class name */
        public class C01141 extends com.aliyun.vod.qupaiokhttp.BaseHttpRequestCallback {
            public C01141() {
            }

            @Override // com.aliyun.vod.qupaiokhttp.BaseHttpRequestCallback
            public void onFailure(int i, java.lang.String str) {
                super.onFailure(i, str);
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                sb.append("Push log failure, error Code ");
                sb.append(i);
                sb.append(", msg:");
                sb.append(str);
            }

            @Override // com.aliyun.vod.qupaiokhttp.BaseHttpRequestCallback
            public void onSuccess(okhttp3.Headers headers, java.lang.Object obj) {
                super.onSuccess(headers, obj);
            }
        }

        public AnonymousClass1(java.lang.String str, java.util.Map map, java.lang.String str2, java.lang.String str3, java.lang.String str4, java.lang.String str5, int i, java.lang.String str6, android.content.Context context) {
            this.val$logstore = str;
            this.val$args = map;
            this.val$product = str2;
            this.val$logLevel = str3;
            this.val$module = str4;
            this.val$subModule = str5;
            this.val$eventId = i;
            this.val$requestID = str6;
            this.val$context = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append(com.aliyun.vod.log.core.AliyunLogCommon.generateDomainWithRegion(com.aliyun.vod.log.core.AliyunLogger.this.domainRegion));
            sb.append(com.aliyun.vod.log.core.AliyunLogger.this.productSVideo ? "svideo" : this.val$logstore);
            sb.append(com.aliyun.vod.log.core.AliyunLogCommon.LOG_PUSH_TRACK_APIVERSION);
            java.util.Map map = this.val$args;
            java.lang.String str = com.aliyun.vod.log.core.AliyunLogger.this.productSVideo ? "svideo" : this.val$product;
            java.lang.String str2 = this.val$logLevel;
            java.lang.String str3 = this.val$module;
            java.lang.String str4 = this.val$subModule;
            int i = this.val$eventId;
            java.lang.String str5 = this.val$requestID;
            if (str5 == null) {
                str5 = com.aliyun.vod.log.core.AliyunLogger.this.mRequestID;
            }
            sb.append(com.aliyun.vod.log.core.AliyunLogParam.generatePushParams(map, str, str2, str3, str4, i, str5, com.aliyun.vod.common.utils.DeviceUtils.getNetWorkType(this.val$context), com.aliyun.vod.log.core.AliyunLogger.this.canModify ? com.aliyun.vod.common.global.Version.VERSION : com.aliyun.vod.log.core.AliyunLogger.this.appVersion));
            com.aliyun.vod.qupaiokhttp.HttpRequest.get(sb.toString(), new com.aliyun.vod.log.core.AliyunLogger.AnonymousClass1.C01141());
        }
    }

    /* renamed from: com.aliyun.vod.log.core.AliyunLogger$2, reason: invalid class name */
    public class AnonymousClass2 extends com.aliyun.vod.qupaiokhttp.BaseHttpRequestCallback {
        public AnonymousClass2() {
        }

        @Override // com.aliyun.vod.qupaiokhttp.BaseHttpRequestCallback
        public void onFailure(int i, java.lang.String str) {
            super.onFailure(i, str);
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("Push log failure, error Code ");
            sb.append(i);
            sb.append(", msg:");
            sb.append(str);
        }

        @Override // com.aliyun.vod.qupaiokhttp.BaseHttpRequestCallback
        public void onSuccess(okhttp3.Headers headers, java.lang.Object obj) {
            super.onSuccess(headers, obj);
        }
    }

    public AliyunLogger(com.aliyun.vod.log.core.LogService logService) {
        this.mLogService = logService;
    }

    private void initGlobalInfo() {
        android.content.Context context = this.mContextRef.get();
        if (context != null && com.aliyun.vod.log.core.AliyunLogCommon.APPLICATION_ID == null) {
            com.aliyun.vod.log.core.AliyunLogCommon.APPLICATION_ID = context.getPackageName();
            com.aliyun.vod.log.core.AliyunLogCommon.APPLICATION_NAME = com.aliyun.vod.common.utils.ManifestUtils.getAppName(context);
        }
        if (com.aliyun.vod.log.core.AliyunLogCommon.UUID == null) {
            com.aliyun.vod.log.core.AliyunLogCommon.UUID = com.aliyun.vod.log.util.UUIDGenerator.generateUUID();
        }
    }

    private void setDomainRegion(java.lang.String str) {
        this.domainRegion = str;
    }

    public void destroy() {
        com.aliyun.vod.log.core.LogService logService = this.mLogService;
        if (logService != null) {
            logService.quit();
            this.mLogService = null;
        }
        com.aliyun.vod.log.core.LogService logService2 = this.mHttpService;
        if (logService2 != null) {
            logService2.quit();
            this.mHttpService = null;
        }
    }

    public com.aliyun.vod.log.core.LogService getLogService() {
        return this.mLogService;
    }

    public java.lang.String getRequestID() {
        return this.mRequestID;
    }

    public void init(android.content.Context context) {
        this.mContextRef = new java.lang.ref.WeakReference<>(context.getApplicationContext());
        initGlobalInfo();
    }

    public void pushLog(java.util.Map<java.lang.String, java.lang.String> map, java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, int i, java.lang.String str5, java.lang.String str6) {
        android.content.Context context = this.mContextRef.get();
        if (com.aliyun.vod.common.utils.ProcessUtil.isMainThread()) {
            this.mHttpService.execute(new com.aliyun.vod.log.core.AliyunLogger.AnonymousClass1(str5, map, str, str2, str3, str4, i, str6, context));
            return;
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append(com.aliyun.vod.log.core.AliyunLogCommon.generateDomainWithRegion(this.domainRegion));
        sb.append(this.productSVideo ? "svideo" : str5);
        sb.append(com.aliyun.vod.log.core.AliyunLogCommon.LOG_PUSH_TRACK_APIVERSION);
        sb.append(com.aliyun.vod.log.core.AliyunLogParam.generatePushParams(map, this.productSVideo ? "svideo" : str, str2, str3, str4, i, str6 == null ? this.mRequestID : str6, com.aliyun.vod.common.utils.DeviceUtils.getNetWorkType(context), this.canModify ? com.aliyun.vod.common.global.Version.VERSION : this.appVersion));
        com.aliyun.vod.qupaiokhttp.HttpRequest.get(sb.toString(), new com.aliyun.vod.log.core.AliyunLogger.AnonymousClass2());
    }

    public void setAppVersion(java.lang.String str) {
        this.appVersion = str;
    }

    public void setProductSVideo(boolean z) {
        this.productSVideo = z;
    }

    public void setRequestID(java.lang.String str, boolean z) {
        this.mRequestID = str;
        this.canModify = z;
    }

    public void updateRequestID() {
        if (this.canModify) {
            this.mRequestID = com.aliyun.vod.log.util.UUIDGenerator.generateRequestID();
        }
    }
}
