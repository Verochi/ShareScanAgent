package com.ss.android.downloadad.api.download;

/* loaded from: classes19.dex */
public class AdDownloadModel implements com.ss.android.download.api.download.DownloadModel {
    protected java.lang.String mAppIcon;
    protected java.lang.String mAppName;
    protected boolean mAutoInstallWithoutNotification;
    protected java.util.List<java.lang.String> mBackupUrls;
    protected java.util.List<java.lang.String> mClickTrackUrl;
    protected com.ss.android.download.api.model.DeepLink mDeepLink;
    protected boolean mDistinctDir;
    protected org.json.JSONObject mDownloadSettings;
    protected java.lang.String mDownloadUrl;
    protected long mExpectFileLength;
    protected org.json.JSONObject mExtra;
    protected long mExtraValue;
    protected java.lang.String mFileName;
    protected java.lang.String mFilePath;
    protected com.ss.android.socialbase.downloader.depend.IDownloadFileUriProvider mFileUriProvider;
    protected java.util.Map<java.lang.String, java.lang.String> mHeaders;
    protected long mId;
    protected boolean mIndependentProcess;

    @java.lang.Deprecated
    protected boolean mIsInExternalPublicDir;
    protected java.lang.String mLogExtra;
    protected java.lang.String mMd5;
    protected java.lang.String mMimeType;
    protected int mModelType;
    protected java.lang.String mNotificationJumpUrl;
    protected java.lang.String mPackageName;
    protected com.ss.android.download.api.model.v mQuickAppModel;
    protected java.lang.String mSdkMonitorScene;
    protected java.lang.String mStartToast;
    protected java.lang.String mTaskKey;
    protected int mVersionCode;
    protected java.lang.String mVersionName;
    protected boolean mIsAd = true;
    protected boolean mIsShowToast = true;
    protected boolean mIsShowNotification = true;
    protected boolean mAutoInstall = true;
    protected boolean mNeedWifi = false;

    @com.ss.android.socialbase.downloader.constants.ExecutorGroup
    protected int mExecutorGroup = 2;
    protected boolean mEnablePause = true;
    protected int mFunnelType = 1;

    public static final class Builder {
        com.ss.android.downloadad.api.download.AdDownloadModel model = new com.ss.android.downloadad.api.download.AdDownloadModel();

        public com.ss.android.downloadad.api.download.AdDownloadModel build() {
            return this.model;
        }

        @java.lang.Deprecated
        public com.ss.android.downloadad.api.download.AdDownloadModel.Builder setAdId(long j) {
            return setId(j);
        }

        public com.ss.android.downloadad.api.download.AdDownloadModel.Builder setAppIcon(java.lang.String str) {
            this.model.mAppIcon = str;
            return this;
        }

        public com.ss.android.downloadad.api.download.AdDownloadModel.Builder setAppName(java.lang.String str) {
            this.model.mAppName = str;
            return this;
        }

        public com.ss.android.downloadad.api.download.AdDownloadModel.Builder setAutoInstall(boolean z) {
            this.model.mAutoInstall = z;
            return this;
        }

        public com.ss.android.downloadad.api.download.AdDownloadModel.Builder setAutoInstallWithoutNotification(boolean z) {
            this.model.mAutoInstallWithoutNotification = z;
            return this;
        }

        public com.ss.android.downloadad.api.download.AdDownloadModel.Builder setBackupUrls(java.util.List<java.lang.String> list) {
            this.model.mBackupUrls = list;
            return this;
        }

        public com.ss.android.downloadad.api.download.AdDownloadModel.Builder setClickTrackUrl(java.util.List<java.lang.String> list) {
            this.model.mClickTrackUrl = list;
            return this;
        }

        public com.ss.android.downloadad.api.download.AdDownloadModel.Builder setDeepLink(com.ss.android.download.api.model.DeepLink deepLink) {
            this.model.mDeepLink = deepLink;
            return this;
        }

        public com.ss.android.downloadad.api.download.AdDownloadModel.Builder setDistinctDir(boolean z) {
            this.model.mDistinctDir = z;
            return this;
        }

        public com.ss.android.downloadad.api.download.AdDownloadModel.Builder setDownloadSettings(org.json.JSONObject jSONObject) {
            this.model.mDownloadSettings = jSONObject;
            return this;
        }

        public com.ss.android.downloadad.api.download.AdDownloadModel.Builder setDownloadUrl(java.lang.String str) {
            this.model.mDownloadUrl = str;
            return this;
        }

        public com.ss.android.downloadad.api.download.AdDownloadModel.Builder setEnablePause(boolean z) {
            this.model.mEnablePause = z;
            return this;
        }

        public com.ss.android.downloadad.api.download.AdDownloadModel.Builder setExecutorGroup(@com.ss.android.socialbase.downloader.constants.ExecutorGroup int i) {
            this.model.mExecutorGroup = i;
            return this;
        }

        public com.ss.android.downloadad.api.download.AdDownloadModel.Builder setExpectFileLength(long j) {
            this.model.mExpectFileLength = j;
            return this;
        }

        public com.ss.android.downloadad.api.download.AdDownloadModel.Builder setExtra(org.json.JSONObject jSONObject) {
            this.model.mExtra = jSONObject;
            return this;
        }

        public com.ss.android.downloadad.api.download.AdDownloadModel.Builder setExtraValue(long j) {
            this.model.mExtraValue = j;
            return this;
        }

        public com.ss.android.downloadad.api.download.AdDownloadModel.Builder setFileName(java.lang.String str) {
            this.model.mFileName = str;
            return this;
        }

        public com.ss.android.downloadad.api.download.AdDownloadModel.Builder setFilePath(java.lang.String str) {
            this.model.mFilePath = str;
            return this;
        }

        public com.ss.android.downloadad.api.download.AdDownloadModel.Builder setFileUriProvider(com.ss.android.socialbase.downloader.depend.IDownloadFileUriProvider iDownloadFileUriProvider) {
            this.model.mFileUriProvider = iDownloadFileUriProvider;
            return this;
        }

        public com.ss.android.downloadad.api.download.AdDownloadModel.Builder setHeaders(java.util.Map<java.lang.String, java.lang.String> map) {
            this.model.mHeaders = map;
            return this;
        }

        public com.ss.android.downloadad.api.download.AdDownloadModel.Builder setId(long j) {
            this.model.mId = j;
            return this;
        }

        public com.ss.android.downloadad.api.download.AdDownloadModel.Builder setIsAd(boolean z) {
            this.model.mIsAd = z;
            return this;
        }

        @java.lang.Deprecated
        public com.ss.android.downloadad.api.download.AdDownloadModel.Builder setIsInExternalPublicDir(boolean z) {
            this.model.mIsInExternalPublicDir = z;
            return this;
        }

        public com.ss.android.downloadad.api.download.AdDownloadModel.Builder setIsShowNotification(boolean z) {
            this.model.mIsShowNotification = z;
            return this;
        }

        public com.ss.android.downloadad.api.download.AdDownloadModel.Builder setIsShowToast(boolean z) {
            this.model.mIsShowToast = z;
            return this;
        }

        public com.ss.android.downloadad.api.download.AdDownloadModel.Builder setLogExtra(java.lang.String str) {
            this.model.mLogExtra = str;
            return this;
        }

        public com.ss.android.downloadad.api.download.AdDownloadModel.Builder setMd5(java.lang.String str) {
            this.model.mMd5 = str;
            return this;
        }

        public com.ss.android.downloadad.api.download.AdDownloadModel.Builder setMimeType(java.lang.String str) {
            this.model.mMimeType = str;
            return this;
        }

        public com.ss.android.downloadad.api.download.AdDownloadModel.Builder setModelType(int i) {
            this.model.mModelType = i;
            return this;
        }

        public com.ss.android.downloadad.api.download.AdDownloadModel.Builder setNeedIndependentProcess(boolean z) {
            this.model.mIndependentProcess = z;
            return this;
        }

        public com.ss.android.downloadad.api.download.AdDownloadModel.Builder setNeedWifi(boolean z) {
            this.model.mNeedWifi = z;
            return this;
        }

        public com.ss.android.downloadad.api.download.AdDownloadModel.Builder setNotificationJumpUrl(java.lang.String str) {
            this.model.mNotificationJumpUrl = str;
            return this;
        }

        public com.ss.android.downloadad.api.download.AdDownloadModel.Builder setPackageName(java.lang.String str) {
            this.model.mPackageName = str;
            return this;
        }

        public com.ss.android.downloadad.api.download.AdDownloadModel.Builder setQuickAppModel(com.ss.android.download.api.model.v vVar) {
            this.model.mQuickAppModel = vVar;
            return this;
        }

        public com.ss.android.downloadad.api.download.AdDownloadModel.Builder setSdkMonitorScene(java.lang.String str) {
            this.model.mSdkMonitorScene = str;
            return this;
        }

        public com.ss.android.downloadad.api.download.AdDownloadModel.Builder setStartToast(java.lang.String str) {
            this.model.mStartToast = str;
            return this;
        }

        public com.ss.android.downloadad.api.download.AdDownloadModel.Builder setTaskKey(java.lang.String str) {
            this.model.mTaskKey = str;
            return this;
        }

        public com.ss.android.downloadad.api.download.AdDownloadModel.Builder setVersionCode(int i) {
            this.model.mVersionCode = i;
            return this;
        }

        public com.ss.android.downloadad.api.download.AdDownloadModel.Builder setVersionName(java.lang.String str) {
            this.model.mVersionName = str;
            return this;
        }
    }

    private static void appendBackupUrlsFromJson(org.json.JSONObject jSONObject, com.ss.android.downloadad.api.download.AdDownloadModel.Builder builder) {
        org.json.JSONArray optJSONArray = jSONObject.optJSONArray("backup_urls");
        if (optJSONArray == null || optJSONArray.length() <= 0) {
            return;
        }
        java.util.ArrayList arrayList = new java.util.ArrayList();
        for (int i = 0; i < optJSONArray.length(); i++) {
            arrayList.add(optJSONArray.optString(i));
        }
        builder.setBackupUrls(arrayList);
    }

    private static void appendDeepLinkFromJson(org.json.JSONObject jSONObject, com.ss.android.downloadad.api.download.AdDownloadModel.Builder builder) {
        builder.setDeepLink(new com.ss.android.download.api.model.DeepLink(jSONObject.optString("open_url"), jSONObject.optString("web_url"), null));
    }

    private static void appendHeaderMapFromJson(org.json.JSONObject jSONObject, com.ss.android.downloadad.api.download.AdDownloadModel.Builder builder) {
        org.json.JSONArray optJSONArray = jSONObject.optJSONArray("header_keys");
        org.json.JSONArray optJSONArray2 = jSONObject.optJSONArray("header_values");
        if (optJSONArray == null || optJSONArray2 == null) {
            return;
        }
        java.util.HashMap hashMap = new java.util.HashMap();
        for (int i = 0; i < optJSONArray.length(); i++) {
            hashMap.put(optJSONArray.optString(i), optJSONArray2.optString(i));
        }
        builder.setHeaders(hashMap);
    }

    private static void appendQuickAppUrlFromJson(org.json.JSONObject jSONObject, com.ss.android.downloadad.api.download.AdDownloadModel.Builder builder) {
        java.lang.String optString = jSONObject.optString("quick_app_url");
        if (android.text.TextUtils.isEmpty(optString)) {
            return;
        }
        builder.setQuickAppModel(new com.ss.android.download.api.model.v.vw().vw(optString).vw());
    }

    private static void appendTrackUrlFromJson(org.json.JSONObject jSONObject, com.ss.android.downloadad.api.download.AdDownloadModel.Builder builder) {
        org.json.JSONArray optJSONArray = jSONObject.optJSONArray("click_track_urls");
        if (optJSONArray != null) {
            java.util.ArrayList arrayList = new java.util.ArrayList();
            for (int i = 0; i < optJSONArray.length(); i++) {
                arrayList.add(optJSONArray.optString(i));
            }
            builder.setClickTrackUrl(arrayList);
        }
    }

    public static com.ss.android.downloadad.api.download.AdDownloadModel fromJson(org.json.JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        com.ss.android.downloadad.api.download.AdDownloadModel.Builder builder = new com.ss.android.downloadad.api.download.AdDownloadModel.Builder();
        try {
            boolean z = true;
            com.ss.android.downloadad.api.download.AdDownloadModel.Builder distinctDir = builder.setAdId(com.ss.android.download.api.t.wg.vw(jSONObject, "id")).setIsAd(jSONObject.optInt("is_ad", 1) == 1).setModelType(jSONObject.optInt("model_type")).setMimeType(jSONObject.optString("mime_type")).setExtraValue(com.ss.android.download.api.t.wg.vw(jSONObject, "ext_value")).setLogExtra(jSONObject.optString("log_extra")).setPackageName(jSONObject.optString("package_name")).setDownloadUrl(jSONObject.optString("download_url")).setAppName(jSONObject.optString("app_name")).setAppIcon(jSONObject.optString("app_icon")).setIsShowToast(jSONObject.optInt("is_show_toast", 1) == 1).setIsShowNotification(jSONObject.optInt("show_notification", 1) == 1).setNeedWifi(jSONObject.optInt("need_wifi") == 1).setMd5(jSONObject.optString("md5")).setExpectFileLength(jSONObject.optLong("expect_file_length")).setNeedIndependentProcess(jSONObject.optInt("independent_process") == 1).setVersionCode(jSONObject.optInt("version_code")).setVersionName(jSONObject.optString(com.qq.e.ads.nativ.NativeUnifiedADAppInfoImpl.Keys.VERSION_NAME)).setFilePath(jSONObject.optString("file_path")).setFileName(jSONObject.optString("file_name")).setNotificationJumpUrl(jSONObject.optString("notification_jump_url")).setAutoInstallWithoutNotification(jSONObject.optInt("auto_install_without_notify") == 1).setExecutorGroup(jSONObject.optInt(com.ss.android.socialbase.downloader.constants.DbJsonConstants.DBJSON_KEY_EXECUTOR)).setDownloadSettings(jSONObject.optJSONObject("download_settings")).setExtra(jSONObject.optJSONObject("extra")).setStartToast(jSONObject.optString("start_toast")).setSdkMonitorScene(jSONObject.optString("sdk_monitor_scene")).setAutoInstall(jSONObject.optInt(com.ss.android.socialbase.downloader.constants.DbJsonConstants.AUTO_INSTALL, 1) == 1).setDistinctDir(jSONObject.optInt("distinct_dir") == 1);
            if (jSONObject.optInt("enable_pause", 1) != 1) {
                z = false;
            }
            distinctDir.setEnablePause(z).setTaskKey(jSONObject.optString(com.ss.android.socialbase.downloader.constants.DbJsonConstants.DBJSON_KEY_TASK_KEY));
            appendDeepLinkFromJson(jSONObject, builder);
            appendQuickAppUrlFromJson(jSONObject, builder);
            appendTrackUrlFromJson(jSONObject, builder);
            appendHeaderMapFromJson(jSONObject, builder);
            appendBackupUrlsFromJson(jSONObject, builder);
        } catch (java.lang.Exception e) {
            com.ss.android.downloadlib.addownload.z.q().vw(e, "AdDownloadModel fromJson");
        }
        return builder.build();
    }

    @Override // com.ss.android.download.api.download.DownloadModel
    public boolean autoInstallWithoutNotification() {
        return this.mAutoInstallWithoutNotification;
    }

    @Override // com.ss.android.download.api.download.DownloadModel
    public boolean distinctDir() {
        return this.mDistinctDir;
    }

    @Override // com.ss.android.download.api.download.DownloadModel
    public boolean enablePause() {
        return this.mEnablePause;
    }

    @Override // com.ss.android.download.api.download.DownloadModel
    public void forceHideNotification() {
        this.mIsShowNotification = false;
    }

    @Override // com.ss.android.download.api.download.DownloadModel
    public void forceHideToast() {
        this.mIsShowToast = false;
    }

    @Override // com.ss.android.download.api.download.DownloadModel
    public void forceWifi() {
        this.mNeedWifi = true;
    }

    @Override // com.ss.android.download.api.download.DownloadModel
    public java.lang.String getAppIcon() {
        return this.mAppIcon;
    }

    @Override // com.ss.android.download.api.download.DownloadModel
    public java.util.List<java.lang.String> getBackupUrls() {
        return this.mBackupUrls;
    }

    @Override // com.ss.android.download.api.download.DownloadModel
    public java.util.List<java.lang.String> getClickTrackUrl() {
        return this.mClickTrackUrl;
    }

    @Override // com.ss.android.download.api.download.DownloadModel
    public com.ss.android.download.api.model.DeepLink getDeepLink() {
        return this.mDeepLink;
    }

    @Override // com.ss.android.download.api.download.DownloadModel
    public com.ss.android.socialbase.downloader.depend.IDownloadFileUriProvider getDownloadFileUriProvider() {
        return this.mFileUriProvider;
    }

    @Override // com.ss.android.download.api.download.DownloadModel
    public org.json.JSONObject getDownloadSettings() {
        return this.mDownloadSettings;
    }

    @Override // com.ss.android.download.api.download.DownloadModel
    public java.lang.String getDownloadUrl() {
        return this.mDownloadUrl;
    }

    @Override // com.ss.android.download.api.download.DownloadModel
    public int getExecutorGroup() {
        return this.mExecutorGroup;
    }

    @Override // com.ss.android.download.api.download.DownloadModel
    public long getExpectFileLength() {
        return this.mExpectFileLength;
    }

    @Override // com.ss.android.download.api.download.DownloadModel
    public org.json.JSONObject getExtra() {
        return this.mExtra;
    }

    @Override // com.ss.android.download.api.download.DownloadModel
    public long getExtraValue() {
        return this.mExtraValue;
    }

    @Override // com.ss.android.download.api.download.DownloadModel
    public java.lang.String getFileName() {
        return this.mFileName;
    }

    @Override // com.ss.android.download.api.download.DownloadModel
    public java.lang.String getFilePath() {
        return this.mFilePath;
    }

    @Override // com.ss.android.download.api.download.DownloadModel
    public int getFunnelType() {
        return this.mFunnelType;
    }

    @Override // com.ss.android.download.api.download.DownloadModel
    public java.util.Map<java.lang.String, java.lang.String> getHeaders() {
        return this.mHeaders;
    }

    @Override // com.ss.android.download.api.download.DownloadModel
    public long getId() {
        return this.mId;
    }

    @Override // com.ss.android.download.api.download.DownloadModel
    public java.lang.String getLogExtra() {
        return this.mLogExtra;
    }

    @Override // com.ss.android.download.api.download.DownloadModel
    public java.lang.String getMd5() {
        return this.mMd5;
    }

    @Override // com.ss.android.download.api.download.DownloadModel
    public java.lang.String getMimeType() {
        return this.mMimeType;
    }

    @Override // com.ss.android.download.api.download.DownloadModel
    public int getModelType() {
        return this.mModelType;
    }

    @Override // com.ss.android.download.api.download.DownloadModel
    public java.lang.String getName() {
        return this.mAppName;
    }

    @Override // com.ss.android.download.api.download.DownloadModel
    public java.lang.String getNotificationJumpUrl() {
        return this.mNotificationJumpUrl;
    }

    @Override // com.ss.android.download.api.download.DownloadModel
    public java.lang.String getPackageName() {
        return this.mPackageName;
    }

    @Override // com.ss.android.download.api.download.DownloadModel
    public com.ss.android.download.api.model.v getQuickAppModel() {
        return this.mQuickAppModel;
    }

    @Override // com.ss.android.download.api.download.DownloadModel
    public java.lang.String getSdkMonitorScene() {
        return this.mSdkMonitorScene;
    }

    @Override // com.ss.android.download.api.download.DownloadModel
    public java.lang.String getStartToast() {
        return this.mStartToast;
    }

    public java.lang.String getTaskKey() {
        return this.mTaskKey;
    }

    @Override // com.ss.android.download.api.download.DownloadModel
    public int getVersionCode() {
        return this.mVersionCode;
    }

    @Override // com.ss.android.download.api.download.DownloadModel
    public java.lang.String getVersionName() {
        return this.mVersionName;
    }

    @Override // com.ss.android.download.api.download.DownloadModel
    public boolean isAd() {
        return this.mIsAd;
    }

    @Override // com.ss.android.download.api.download.DownloadModel
    public boolean isAutoInstall() {
        return this.mAutoInstall;
    }

    @Override // com.ss.android.download.api.download.DownloadModel
    public boolean isInExternalPublicDir() {
        return this.mIsInExternalPublicDir;
    }

    @Override // com.ss.android.download.api.download.DownloadModel
    public boolean isNeedWifi() {
        return this.mNeedWifi;
    }

    @Override // com.ss.android.download.api.download.DownloadModel
    public boolean isShowNotification() {
        return this.mIsShowNotification;
    }

    @Override // com.ss.android.download.api.download.DownloadModel
    public boolean isShowToast() {
        return this.mIsShowToast;
    }

    @Override // com.ss.android.download.api.download.DownloadModel
    public boolean isVisibleInDownloadsUi() {
        return true;
    }

    @Override // com.ss.android.download.api.download.DownloadModel
    public boolean needIndependentProcess() {
        return this.mIndependentProcess;
    }

    @java.lang.Deprecated
    public com.ss.android.downloadad.api.download.AdDownloadModel setAdId(long j) {
        return setId(j);
    }

    public com.ss.android.downloadad.api.download.AdDownloadModel setAppIcon(java.lang.String str) {
        this.mAppIcon = str;
        return this;
    }

    public void setAppName(java.lang.String str) {
        this.mAppName = str;
    }

    public com.ss.android.downloadad.api.download.AdDownloadModel setAutoInstallWithoutNotification(boolean z) {
        this.mAutoInstallWithoutNotification = z;
        return this;
    }

    public com.ss.android.downloadad.api.download.AdDownloadModel setBackupUrls(java.util.List<java.lang.String> list) {
        this.mBackupUrls = list;
        return this;
    }

    public com.ss.android.downloadad.api.download.AdDownloadModel setClickTrackUrl(java.util.List<java.lang.String> list) {
        this.mClickTrackUrl = list;
        return this;
    }

    public com.ss.android.downloadad.api.download.AdDownloadModel setDeepLink(com.ss.android.download.api.model.DeepLink deepLink) {
        this.mDeepLink = deepLink;
        return this;
    }

    public com.ss.android.downloadad.api.download.AdDownloadModel setDownloadUrl(java.lang.String str) {
        this.mDownloadUrl = str;
        return this;
    }

    public void setExpectFileLength(long j) {
        this.mExpectFileLength = j;
    }

    public void setExtra(org.json.JSONObject jSONObject) {
        this.mExtra = jSONObject;
    }

    public void setExtraValue(long j) {
        this.mExtraValue = j;
    }

    public com.ss.android.downloadad.api.download.AdDownloadModel setFileName(java.lang.String str) {
        this.mFileName = str;
        return this;
    }

    @Override // com.ss.android.download.api.download.DownloadModel
    public com.ss.android.downloadad.api.download.AdDownloadModel setFilePath(java.lang.String str) {
        this.mFilePath = str;
        return this;
    }

    public com.ss.android.downloadad.api.download.AdDownloadModel setFileUriProvider(com.ss.android.socialbase.downloader.depend.IDownloadFileUriProvider iDownloadFileUriProvider) {
        this.mFileUriProvider = iDownloadFileUriProvider;
        return this;
    }

    public com.ss.android.downloadad.api.download.AdDownloadModel setFunnelType(int i) {
        this.mFunnelType = i;
        return this;
    }

    public com.ss.android.downloadad.api.download.AdDownloadModel setHeaders(java.util.Map<java.lang.String, java.lang.String> map) {
        this.mHeaders = map;
        return this;
    }

    public com.ss.android.downloadad.api.download.AdDownloadModel setId(long j) {
        this.mId = j;
        return this;
    }

    public com.ss.android.downloadad.api.download.AdDownloadModel setIsAd(boolean z) {
        this.mIsAd = z;
        return this;
    }

    public com.ss.android.downloadad.api.download.AdDownloadModel setIsShowNotification(boolean z) {
        this.mIsShowNotification = z;
        return this;
    }

    public void setIsShowToast(boolean z) {
        this.mIsShowToast = z;
    }

    public com.ss.android.downloadad.api.download.AdDownloadModel setLogExtra(java.lang.String str) {
        this.mLogExtra = str;
        return this;
    }

    public void setMd5(java.lang.String str) {
        this.mMd5 = str;
    }

    public com.ss.android.downloadad.api.download.AdDownloadModel setMimeType(java.lang.String str) {
        this.mMimeType = str;
        return this;
    }

    public com.ss.android.downloadad.api.download.AdDownloadModel setModelType(int i) {
        this.mModelType = i;
        return this;
    }

    public com.ss.android.downloadad.api.download.AdDownloadModel setNeedIndependentProcess(boolean z) {
        this.mIndependentProcess = z;
        return this;
    }

    public void setNeedWifi(boolean z) {
        this.mNeedWifi = z;
    }

    public com.ss.android.downloadad.api.download.AdDownloadModel setNotificationJumpUrl(java.lang.String str) {
        this.mNotificationJumpUrl = str;
        return this;
    }

    public com.ss.android.downloadad.api.download.AdDownloadModel setPackageName(java.lang.String str) {
        this.mPackageName = str;
        return this;
    }

    public com.ss.android.downloadad.api.download.AdDownloadModel setQuickAppModel(com.ss.android.download.api.model.v vVar) {
        this.mQuickAppModel = vVar;
        return this;
    }

    public void setSdkMonitorScene(java.lang.String str) {
        this.mSdkMonitorScene = str;
    }

    public void setStartToast(java.lang.String str) {
        this.mStartToast = str;
    }

    public void setTaskKey(java.lang.String str) {
        this.mTaskKey = str;
    }

    public com.ss.android.downloadad.api.download.AdDownloadModel setVersionCode(int i) {
        this.mVersionCode = i;
        return this;
    }

    public com.ss.android.downloadad.api.download.AdDownloadModel setVersionName(java.lang.String str) {
        this.mVersionName = str;
        return this;
    }

    @Override // com.ss.android.download.api.download.DownloadModel
    public boolean shouldDownloadWithPatchApply() {
        return com.ss.android.download.api.t.wg.vw(com.ss.android.socialbase.downloader.setting.DownloadSetting.obtain(getDownloadSettings()), getMimeType());
    }

    public org.json.JSONObject toJson() {
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        try {
            jSONObject.put("id", this.mId);
            int i = 1;
            jSONObject.put("is_ad", this.mIsAd ? 1 : 0);
            jSONObject.putOpt("model_type", java.lang.Integer.valueOf(this.mModelType));
            jSONObject.putOpt("mime_type", this.mMimeType);
            jSONObject.putOpt("ext_value", java.lang.Long.valueOf(this.mExtraValue));
            jSONObject.putOpt("log_extra", this.mLogExtra);
            jSONObject.putOpt("package_name", this.mPackageName);
            jSONObject.putOpt("download_url", this.mDownloadUrl);
            jSONObject.putOpt("app_name", this.mAppName);
            jSONObject.putOpt("app_icon", this.mAppIcon);
            jSONObject.putOpt("is_show_toast", java.lang.Integer.valueOf(this.mIsShowToast ? 1 : 0));
            jSONObject.putOpt("show_notification", java.lang.Integer.valueOf(this.mIsShowNotification ? 1 : 0));
            jSONObject.put("need_wifi", this.mNeedWifi ? 1 : 0);
            jSONObject.put("md5", this.mMd5);
            jSONObject.put("expect_file_length", this.mExpectFileLength);
            jSONObject.put("independent_process", this.mIndependentProcess ? 1 : 0);
            jSONObject.put("version_code", this.mVersionCode);
            jSONObject.putOpt(com.qq.e.ads.nativ.NativeUnifiedADAppInfoImpl.Keys.VERSION_NAME, this.mVersionName);
            jSONObject.putOpt("file_path", this.mFilePath);
            jSONObject.putOpt("file_name", this.mFileName);
            jSONObject.putOpt("notification_jump_url", this.mNotificationJumpUrl);
            jSONObject.putOpt("auto_install_without_notify", java.lang.Integer.valueOf(this.mAutoInstallWithoutNotification ? 1 : 0));
            jSONObject.putOpt(com.ss.android.socialbase.downloader.constants.DbJsonConstants.DBJSON_KEY_EXECUTOR, java.lang.Integer.valueOf(this.mExecutorGroup));
            jSONObject.putOpt("start_toast", this.mStartToast);
            jSONObject.putOpt("sdk_monitor_scene", this.mSdkMonitorScene);
            jSONObject.putOpt(com.ss.android.socialbase.downloader.constants.DbJsonConstants.AUTO_INSTALL, java.lang.Integer.valueOf(this.mAutoInstall ? 1 : 0));
            jSONObject.putOpt("distinct_dir", java.lang.Integer.valueOf(this.mDistinctDir ? 1 : 0));
            if (!this.mEnablePause) {
                i = 0;
            }
            jSONObject.putOpt("enable_pause", java.lang.Integer.valueOf(i));
            jSONObject.putOpt(com.ss.android.socialbase.downloader.constants.DbJsonConstants.DBJSON_KEY_TASK_KEY, this.mTaskKey);
            java.lang.Object obj = this.mDownloadSettings;
            if (obj != null) {
                jSONObject.put("download_settings", obj);
            }
            java.util.List<java.lang.String> list = this.mBackupUrls;
            if (list != null && !list.isEmpty()) {
                org.json.JSONArray jSONArray = new org.json.JSONArray();
                for (java.lang.String str : this.mBackupUrls) {
                    if (!android.text.TextUtils.isEmpty(str)) {
                        jSONArray.put(str);
                    }
                }
                jSONObject.put("backup_urls", jSONArray);
            }
            com.ss.android.download.api.model.DeepLink deepLink = this.mDeepLink;
            if (deepLink != null) {
                if (!android.text.TextUtils.isEmpty(deepLink.getOpenUrl())) {
                    jSONObject.put("open_url", this.mDeepLink.getOpenUrl());
                }
                if (!android.text.TextUtils.isEmpty(this.mDeepLink.getWebUrl())) {
                    jSONObject.put("web_url", this.mDeepLink.getWebUrl());
                }
            }
            com.ss.android.download.api.model.v vVar = this.mQuickAppModel;
            if (vVar != null) {
                jSONObject.putOpt("quick_app_url", vVar.vw());
            }
            java.util.List<java.lang.String> list2 = this.mClickTrackUrl;
            if (list2 != null && !list2.isEmpty()) {
                org.json.JSONArray jSONArray2 = new org.json.JSONArray();
                java.util.Iterator<java.lang.String> it = this.mClickTrackUrl.iterator();
                while (it.hasNext()) {
                    jSONArray2.put(it.next());
                }
                jSONObject.put("click_track_urls", jSONArray2);
            }
            java.lang.Object obj2 = this.mExtra;
            if (obj2 != null) {
                jSONObject.put("extra", obj2);
            }
            java.util.Map<java.lang.String, java.lang.String> map = this.mHeaders;
            if (map != null && !map.isEmpty()) {
                org.json.JSONArray jSONArray3 = new org.json.JSONArray();
                org.json.JSONArray jSONArray4 = new org.json.JSONArray();
                for (java.util.Map.Entry<java.lang.String, java.lang.String> entry : this.mHeaders.entrySet()) {
                    jSONArray3.put(entry.getKey());
                    jSONArray4.put(entry.getKey());
                }
                jSONObject.put("header_keys", jSONArray3);
                jSONObject.put("header_values", jSONArray4);
            }
        } catch (java.lang.Exception e) {
            com.ss.android.downloadlib.addownload.z.q().vw(e, "AdDownloadModel toJson");
        }
        return jSONObject;
    }
}
