package com.aliyun.vod.log.report;

/* loaded from: classes12.dex */
public class AliyunUploadProgressReporter {
    private static final java.lang.String KEY_SHARED_PREFERENCE = "aliyun_svideo_global_info";
    private static final java.lang.String TAG = "AliyunUploadProgressReporter";
    private java.lang.String mTerminalType;
    private java.lang.String mAction = "ReportUploadProgress";
    private java.lang.String mSource = "AndroidSDK";
    private java.lang.String mClientId = com.aliyun.vod.log.core.AliyunLogCommon.UUID;
    private java.lang.String mBusinessType = "UploadVideo";
    private java.lang.String mDeviceModel = android.os.Build.MODEL;
    private java.lang.String mAppVersion = com.aliyun.vod.common.global.Version.VERSION;
    private java.lang.String mAuthTimestamp = "";
    private java.lang.String mAuthInfo = "";
    private java.lang.String mFileName = "";
    private java.lang.Long mFileSize = 0L;
    private java.lang.String mFileCreateTime = "";
    private java.lang.String mFileHash = "";
    private java.lang.Float mUploadRatio = java.lang.Float.valueOf(0.0f);
    private java.lang.String mUploadId = "todo";
    private java.lang.Integer mDonePartsCount = 0;
    private java.lang.Integer mTotalPart = 0;
    private java.lang.Long mPartSize = 0L;

    @java.lang.Deprecated
    private java.lang.String mUploadPoint = "todo";

    @java.lang.Deprecated
    private java.lang.Long mUserId = -1L;
    private java.lang.String mVideoId = "";
    private java.lang.String mUploadAddress = "todo";
    private java.lang.String INNER_SECRET_KEY = "FqQ^jDLpi0PVZ74A";
    private java.lang.String mDomainRegion = null;

    /* renamed from: com.aliyun.vod.log.report.AliyunUploadProgressReporter$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {
        final /* synthetic */ java.lang.String val$accessSecretKey;

        public AnonymousClass1(java.lang.String str) {
            this.val$accessSecretKey = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.aliyun.vod.log.report.AliyunUploadProgressReporter.this.doRun(this.val$accessSecretKey);
        }
    }

    /* renamed from: com.aliyun.vod.log.report.AliyunUploadProgressReporter$2, reason: invalid class name */
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

    public AliyunUploadProgressReporter(android.content.Context context) {
        this.mTerminalType = "APhone";
        initGlobalInfo(context);
        this.mTerminalType = com.aliyun.vod.common.utils.DeviceUtils.isTabletDevice(context) ? "APad" : "APhone";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doRun(java.lang.String str) {
        java.lang.String generateDomainWithRegion = com.aliyun.vod.log.report.AliyunReportParam.generateDomainWithRegion(this.mDomainRegion);
        java.lang.String generateUploadProgressParams = com.aliyun.vod.log.report.AliyunReportParam.generateUploadProgressParams(generatePublicParams(), str);
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("domain : ");
        sb.append(generateDomainWithRegion);
        java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
        sb2.append("params : ");
        sb2.append(generateUploadProgressParams);
        com.aliyun.vod.qupaiokhttp.HttpRequest.get(generateDomainWithRegion + generateUploadProgressParams, new com.aliyun.vod.log.report.AliyunUploadProgressReporter.AnonymousClass2());
    }

    private java.util.Map<java.lang.String, java.lang.String> generatePublicParams() {
        java.util.HashMap hashMap = new java.util.HashMap();
        hashMap.put(com.aliyun.auth.core.AliyunVodKey.KEY_VOD_ACTION, this.mAction);
        hashMap.put("Source", this.mSource);
        hashMap.put("ClientId", this.mClientId);
        hashMap.put("BusinessType", this.mBusinessType);
        hashMap.put("TerminalType", this.mTerminalType);
        hashMap.put("DeviceModel", this.mDeviceModel);
        hashMap.put("AppVersion", this.mAppVersion);
        hashMap.put("AuthTimestamp", this.mAuthTimestamp);
        hashMap.put("AuthInfo", this.mAuthInfo);
        hashMap.put(com.aliyun.auth.core.AliyunVodKey.KEY_VOD_FILENAME, this.mFileName);
        hashMap.put(com.aliyun.auth.core.AliyunVodKey.KEY_VOD_FILESIZE, java.lang.String.valueOf(this.mFileSize));
        hashMap.put("FileCreateTime", this.mFileCreateTime);
        hashMap.put("FileHash", this.mFileHash);
        hashMap.put("UploadRatio", java.lang.String.valueOf(this.mUploadRatio));
        hashMap.put("UploadId", this.mUploadId);
        hashMap.put("DonePartsCount", java.lang.String.valueOf(this.mDonePartsCount));
        hashMap.put("TotalPart", java.lang.String.valueOf(this.mTotalPart));
        hashMap.put("PartSize", java.lang.String.valueOf(this.mPartSize));
        hashMap.put("UploadPoint", this.mUploadPoint);
        if (!android.text.TextUtils.isEmpty(this.mVideoId)) {
            hashMap.put(com.aliyun.auth.core.AliyunVodKey.KEY_VOD_VIDEOID, this.mVideoId);
        }
        if (!android.text.TextUtils.isEmpty(this.mUploadAddress)) {
            hashMap.put("UploadAddress", this.mUploadAddress);
        }
        return hashMap;
    }

    private void initGlobalInfo(android.content.Context context) {
        if (context != null) {
            if (com.aliyun.vod.log.core.AliyunLogCommon.APPLICATION_ID == null) {
                com.aliyun.vod.log.core.AliyunLogCommon.APPLICATION_ID = context.getPackageName();
                com.aliyun.vod.log.core.AliyunLogCommon.APPLICATION_NAME = com.aliyun.vod.common.utils.ManifestUtils.getAppName(context);
            }
            if (com.aliyun.vod.log.core.AliyunLogCommon.UUID == null) {
                android.content.SharedPreferences sharedPreferences = context.getSharedPreferences(KEY_SHARED_PREFERENCE, 0);
                if (sharedPreferences.contains("uuid")) {
                    com.aliyun.vod.log.core.AliyunLogCommon.UUID = sharedPreferences.getString("uuid", null);
                }
                if (com.aliyun.vod.log.core.AliyunLogCommon.UUID == null) {
                    com.aliyun.vod.log.core.AliyunLogCommon.UUID = com.aliyun.vod.log.util.UUIDGenerator.generateUUID();
                    android.content.SharedPreferences.Editor edit = sharedPreferences.edit();
                    edit.putString("uuid", com.aliyun.vod.log.core.AliyunLogCommon.UUID);
                    edit.commit();
                }
                this.mClientId = com.aliyun.vod.log.core.AliyunLogCommon.UUID;
            }
        }
    }

    public void pushUploadProgress(java.lang.String str) {
        setAuthInfo();
        if (com.aliyun.vod.common.utils.ProcessUtil.isMainThread()) {
            java.util.concurrent.Executors.newSingleThreadExecutor().submit(new com.aliyun.vod.log.report.AliyunUploadProgressReporter.AnonymousClass1(str));
        } else {
            doRun(str);
        }
    }

    public void setAuthInfo() {
        this.mAuthInfo = com.aliyun.vod.common.utils.MD5Util.encryptToHexStr(this.mClientId + "|" + this.INNER_SECRET_KEY + "|" + this.mAuthTimestamp);
    }

    public void setAuthTimestamp(java.lang.String str) {
        this.mAuthTimestamp = str;
    }

    public void setDomainRegion(java.lang.String str) {
        this.mDomainRegion = str;
    }

    public void setDonePartsCount(java.lang.Integer num) {
        this.mDonePartsCount = num;
    }

    public void setFileCreateTime(java.lang.String str) {
        this.mFileCreateTime = str;
    }

    public void setFileHash(java.lang.String str) {
        this.mFileHash = str;
    }

    public void setFileName(java.lang.String str) {
        this.mFileName = str;
    }

    public void setFileSize(java.lang.Long l) {
        this.mFileSize = l;
    }

    public void setPartSize(java.lang.Long l) {
        this.mPartSize = l;
    }

    public void setTotalPart(java.lang.Integer num) {
        this.mTotalPart = num;
    }

    public void setUploadAddress(java.lang.String str) {
        this.mUploadAddress = str;
    }

    public void setUploadId(java.lang.String str) {
        this.mUploadId = str;
    }

    @java.lang.Deprecated
    public void setUploadPoint(java.lang.String str) {
        this.mUploadPoint = str;
    }

    public void setUploadRatio(java.lang.Float f) {
        this.mUploadRatio = f;
    }

    @java.lang.Deprecated
    public void setUserId(java.lang.Long l) {
        this.mUserId = l;
    }

    public void setVideoId(java.lang.String str) {
        this.mVideoId = str;
    }
}
