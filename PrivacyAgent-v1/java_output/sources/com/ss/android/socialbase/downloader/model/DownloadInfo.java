package com.ss.android.socialbase.downloader.model;

/* loaded from: classes19.dex */
public class DownloadInfo implements android.os.Parcelable {
    public static final android.os.Parcelable.Creator<com.ss.android.socialbase.downloader.model.DownloadInfo> CREATOR = new com.ss.android.socialbase.downloader.model.DownloadInfo.AnonymousClass1();
    private static final int DEFAULT_MAX_PROCESS_POST_COUNT = 100;
    private static final long DEFAULT_MIN_BYTES_INTERVAL = 1048576;
    private static final int RESERVE_STATUS_NEVER = 0;
    private static final int RESERVE_STATUS_NOW = 2;
    private static final int RESERVE_STATUS_ONCE = 1;
    private static final java.lang.String TAG = "DownloadInfo";
    private boolean addListenerToSameTask;
    private java.util.concurrent.atomic.AtomicLong allConnectTime;
    private int appVersionCode;
    private com.ss.android.socialbase.downloader.constants.AsyncHandleStatus asyncHandleStatus;
    private boolean autoResumed;
    private int backUpUrlRetryCount;
    private boolean backUpUrlUsed;
    private java.util.List<java.lang.String> backUpUrls;
    private java.lang.String backUpUrlsStr;
    private int bindValueCount;
    private com.ss.android.socialbase.downloader.constants.ByteInvalidRetryStatus byteInvalidRetryStatus;
    private int chunkCount;
    private boolean chunkDowngradeRetryUsed;
    private int curBackUpUrlIndex;
    private java.util.concurrent.atomic.AtomicLong curBytes;
    private int curRetryTime;
    private org.json.JSONObject dbJsonData;
    private java.lang.String dbJsonDataString;
    private boolean deleteCacheIfCheckFailed;
    private boolean distinctDirectory;
    private long downloadTime;
    private java.lang.String eTag;
    private com.ss.android.socialbase.downloader.constants.EnqueueType enqueueType;
    private java.lang.StringBuffer errorBytesLog;
    private boolean expiredRedownload;
    private java.lang.String extra;
    private java.util.List<com.ss.android.socialbase.downloader.model.HttpHeader> extraHeaders;
    private int[] extraMonitorStatus;
    private com.ss.android.socialbase.downloader.exception.BaseException failedException;
    private java.lang.String filePackageName;
    private java.util.List<java.lang.String> forbiddenBackupUrls;
    private boolean force;
    private boolean forceIgnoreRecommendSize;
    private boolean headConnectionAvailable;
    private java.lang.String headConnectionException;
    private int httpStatusCode;
    private java.lang.String httpStatusMessage;
    private boolean httpsToHttpRetryUsed;
    private java.lang.String iconUrl;
    private int id;
    private boolean ignoreDataVerify;
    private java.lang.Boolean isAutoInstallWithoutNotification;
    private boolean isFirstDownload;
    private boolean isFirstSuccess;
    private boolean isForbiddenRetryed;
    private volatile boolean isSaveTempFile;
    private java.util.concurrent.atomic.AtomicLong lastNotifyProgressTime;
    private boolean mDownloadFromReserveWifi;
    private int maxBytes;
    private int maxProgressCount;
    private java.lang.String md5;
    private java.lang.String mimeType;
    private int minProgressTimeMsInterval;
    private java.lang.String monitorScene;
    private java.lang.String name;
    private boolean needChunkDowngradeRetry;
    private boolean needDefaultHttpServiceBackUp;
    private boolean needHttpsToHttpRetry;
    private boolean needIndependentProcess;
    private boolean needPostProgress;
    private boolean needRetryDelay;
    private boolean needReuseChunkRunnable;
    private boolean needReuseFirstConnection;
    private boolean needSDKMonitor;
    private java.lang.String networkQuality;
    private int notificationVisibility;
    private boolean onlyWifi;
    private boolean openLimitSpeed;
    private java.lang.String[] outIp;
    private int[] outSize;
    private java.lang.ref.SoftReference<android.content.pm.PackageInfo> packageInfoRef;
    private java.lang.String packageName;
    private long realDownloadTime;
    private long realStartDownloadTime;
    private int retryCount;
    private com.ss.android.socialbase.downloader.constants.RetryDelayStatus retryDelayStatus;
    private java.lang.String retryDelayTimeArray;

    @java.lang.Deprecated
    private int retryScheduleMinutes;
    private java.lang.String savePath;
    private boolean showNotification;
    private boolean showNotificationForAutoResumed;
    private boolean showNotificationForNetworkResumed;
    private org.json.JSONObject spData;
    private long startDownloadTime;
    private java.util.concurrent.atomic.AtomicInteger status;
    private int statusAtDbInit;
    private boolean successByCache;
    private boolean supportPartial;
    private java.lang.String taskId;
    private java.util.concurrent.ConcurrentHashMap<java.lang.String, java.lang.Object> tempCacheData;
    private volatile java.util.List<com.ss.android.socialbase.downloader.depend.ITempFileSaveCompleteCallback> tempFileSaveCompleteCallbacks;
    private java.lang.String tempPath;
    private long throttleNetSpeed;
    private java.lang.String title;
    private long totalBytes;
    private long ttnetProtectTimeout;
    private java.lang.String url;

    /* renamed from: com.ss.android.socialbase.downloader.model.DownloadInfo$1, reason: invalid class name */
    public static class AnonymousClass1 implements android.os.Parcelable.Creator<com.ss.android.socialbase.downloader.model.DownloadInfo> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public com.ss.android.socialbase.downloader.model.DownloadInfo createFromParcel(android.os.Parcel parcel) {
            return new com.ss.android.socialbase.downloader.model.DownloadInfo(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public com.ss.android.socialbase.downloader.model.DownloadInfo[] newArray(int i) {
            return new com.ss.android.socialbase.downloader.model.DownloadInfo[i];
        }
    }

    public static class Builder {
        private boolean addListenerToSameTask;
        private int appVersionCode;
        private boolean autoResumed;
        private int backUpUrlRetryCount;
        private java.util.List<java.lang.String> backUpUrls;
        private boolean deleteCacheIfCheckFailed;
        private boolean distinctDirectory;
        private org.json.JSONObject downloadSetting;
        private int executorGroup;
        private long expectFileLength;
        private boolean expiredRedownload;
        private java.lang.String extra;
        private java.util.List<com.ss.android.socialbase.downloader.model.HttpHeader> extraHeaders;
        private int[] extraMonitorStatus;
        private boolean force;
        private boolean headConnectionAvailable;
        private java.lang.String iconUrl;
        private boolean ignoreDataVerify;
        private int maxBytes;
        private int maxProgressCount;
        private java.lang.String md5;
        private java.lang.String mimeType;
        private int minProgressTimeMsInterval;
        private java.lang.String monitorScene;
        private java.lang.String name;
        private boolean needChunkDowngradeRetry;
        private boolean needHttpsToHttpRetry;
        private boolean needIndependentProcess;
        private boolean needRetryDelay;
        private boolean needReuseChunkRunnable;
        private boolean needReuseFirstConnection;
        private boolean onlyWifi;
        private boolean openLimitSpeed;
        private java.lang.String[] outIp;
        private int[] outSize;
        private java.lang.String packageName;
        private int retryCount;
        private java.lang.String retryDelayTimeArray;
        private java.lang.String savePath;
        private boolean showNotification;
        private boolean showNotificationForAutoResumed;
        private java.lang.String taskKey;
        private java.lang.String tempPath;
        private long throttleNetSpeed;
        private java.lang.String title;
        private long ttnetProtectTimeout;
        private java.lang.String url;
        private boolean needPostProgress = true;
        private boolean autoInstall = true;
        private boolean needDefaultHttpServiceBackUp = true;
        private com.ss.android.socialbase.downloader.constants.EnqueueType enqueueType = com.ss.android.socialbase.downloader.constants.EnqueueType.ENQUEUE_NONE;
        private boolean needSDKMonitor = true;

        public Builder() {
        }

        public Builder(java.lang.String str) {
            this.url = str;
        }

        public com.ss.android.socialbase.downloader.model.DownloadInfo.Builder addListenerToSameTask(boolean z) {
            this.addListenerToSameTask = z;
            return this;
        }

        public com.ss.android.socialbase.downloader.model.DownloadInfo.Builder autoResumed(boolean z) {
            this.autoResumed = z;
            return this;
        }

        public com.ss.android.socialbase.downloader.model.DownloadInfo.Builder backUpUrlRetryCount(int i) {
            this.backUpUrlRetryCount = i;
            return this;
        }

        public com.ss.android.socialbase.downloader.model.DownloadInfo.Builder backUpUrls(java.util.List<java.lang.String> list) {
            this.backUpUrls = list;
            return this;
        }

        public com.ss.android.socialbase.downloader.model.DownloadInfo build() {
            return new com.ss.android.socialbase.downloader.model.DownloadInfo(this, null);
        }

        public com.ss.android.socialbase.downloader.model.DownloadInfo.Builder deleteCacheIfCheckFailed(boolean z) {
            this.deleteCacheIfCheckFailed = z;
            return this;
        }

        public com.ss.android.socialbase.downloader.model.DownloadInfo.Builder distinctDirectory(boolean z) {
            this.distinctDirectory = z;
            return this;
        }

        public com.ss.android.socialbase.downloader.model.DownloadInfo.Builder downloadSetting(org.json.JSONObject jSONObject) {
            this.downloadSetting = jSONObject;
            return this;
        }

        public com.ss.android.socialbase.downloader.model.DownloadInfo.Builder enqueueType(com.ss.android.socialbase.downloader.constants.EnqueueType enqueueType) {
            this.enqueueType = enqueueType;
            return this;
        }

        public com.ss.android.socialbase.downloader.model.DownloadInfo.Builder executorGroup(int i) {
            this.executorGroup = i;
            return this;
        }

        public com.ss.android.socialbase.downloader.model.DownloadInfo.Builder expectFileLength(long j) {
            this.expectFileLength = j;
            return this;
        }

        public com.ss.android.socialbase.downloader.model.DownloadInfo.Builder expiredRedownload(boolean z) {
            this.expiredRedownload = z;
            return this;
        }

        public com.ss.android.socialbase.downloader.model.DownloadInfo.Builder extra(java.lang.String str) {
            this.extra = str;
            return this;
        }

        public com.ss.android.socialbase.downloader.model.DownloadInfo.Builder extraHeaders(java.util.List<com.ss.android.socialbase.downloader.model.HttpHeader> list) {
            this.extraHeaders = list;
            return this;
        }

        public com.ss.android.socialbase.downloader.model.DownloadInfo.Builder extraMonitorStatus(int[] iArr) {
            this.extraMonitorStatus = iArr;
            return this;
        }

        public com.ss.android.socialbase.downloader.model.DownloadInfo.Builder force(boolean z) {
            this.force = z;
            return this;
        }

        public com.ss.android.socialbase.downloader.model.DownloadInfo.Builder headConnectionAvailable(boolean z) {
            this.headConnectionAvailable = z;
            return this;
        }

        public com.ss.android.socialbase.downloader.model.DownloadInfo.Builder iconUrl(java.lang.String str) {
            this.iconUrl = str;
            return this;
        }

        public com.ss.android.socialbase.downloader.model.DownloadInfo.Builder ignoreDataVerify(boolean z) {
            this.ignoreDataVerify = z;
            return this;
        }

        public com.ss.android.socialbase.downloader.model.DownloadInfo.Builder isOpenLimitSpeed(boolean z) {
            this.openLimitSpeed = z;
            return this;
        }

        public com.ss.android.socialbase.downloader.model.DownloadInfo.Builder maxBytes(int i) {
            this.maxBytes = i;
            return this;
        }

        public com.ss.android.socialbase.downloader.model.DownloadInfo.Builder maxProgressCount(int i) {
            this.maxProgressCount = i;
            return this;
        }

        public com.ss.android.socialbase.downloader.model.DownloadInfo.Builder md5(java.lang.String str) {
            this.md5 = str;
            return this;
        }

        public com.ss.android.socialbase.downloader.model.DownloadInfo.Builder mimeType(java.lang.String str) {
            this.mimeType = str;
            return this;
        }

        public com.ss.android.socialbase.downloader.model.DownloadInfo.Builder minProgressTimeMsInterval(int i) {
            this.minProgressTimeMsInterval = i;
            return this;
        }

        public com.ss.android.socialbase.downloader.model.DownloadInfo.Builder monitorScene(java.lang.String str) {
            this.monitorScene = str;
            return this;
        }

        public com.ss.android.socialbase.downloader.model.DownloadInfo.Builder name(java.lang.String str) {
            this.name = str;
            return this;
        }

        public com.ss.android.socialbase.downloader.model.DownloadInfo.Builder needChunkDowngradeRetry(boolean z) {
            this.needChunkDowngradeRetry = z;
            return this;
        }

        public com.ss.android.socialbase.downloader.model.DownloadInfo.Builder needDefaultHttpServiceBackUp(boolean z) {
            this.needDefaultHttpServiceBackUp = z;
            return this;
        }

        public com.ss.android.socialbase.downloader.model.DownloadInfo.Builder needHttpsToHttpRetry(boolean z) {
            this.needHttpsToHttpRetry = z;
            return this;
        }

        public com.ss.android.socialbase.downloader.model.DownloadInfo.Builder needIndependentProcess(boolean z) {
            this.needIndependentProcess = z;
            return this;
        }

        public com.ss.android.socialbase.downloader.model.DownloadInfo.Builder needPostProgress(boolean z) {
            this.needPostProgress = z;
            return this;
        }

        public com.ss.android.socialbase.downloader.model.DownloadInfo.Builder needRetryDelay(boolean z) {
            this.needRetryDelay = z;
            return this;
        }

        public com.ss.android.socialbase.downloader.model.DownloadInfo.Builder needReuseChunkRunnable(boolean z) {
            this.needReuseChunkRunnable = z;
            return this;
        }

        public com.ss.android.socialbase.downloader.model.DownloadInfo.Builder needReuseFirstConnection(boolean z) {
            this.needReuseFirstConnection = z;
            return this;
        }

        public com.ss.android.socialbase.downloader.model.DownloadInfo.Builder needSDKMonitor(boolean z) {
            this.needSDKMonitor = z;
            return this;
        }

        public com.ss.android.socialbase.downloader.model.DownloadInfo.Builder onlyWifi(boolean z) {
            this.onlyWifi = z;
            return this;
        }

        public com.ss.android.socialbase.downloader.model.DownloadInfo.Builder outIp(java.lang.String[] strArr) {
            this.outIp = strArr;
            return this;
        }

        public com.ss.android.socialbase.downloader.model.DownloadInfo.Builder outSize(int[] iArr) {
            this.outSize = iArr;
            return this;
        }

        public com.ss.android.socialbase.downloader.model.DownloadInfo.Builder packageName(java.lang.String str) {
            this.packageName = str;
            return this;
        }

        public com.ss.android.socialbase.downloader.model.DownloadInfo.Builder retryCount(int i) {
            this.retryCount = i;
            return this;
        }

        public com.ss.android.socialbase.downloader.model.DownloadInfo.Builder retryDelayTimeArray(java.lang.String str) {
            this.retryDelayTimeArray = str;
            return this;
        }

        public com.ss.android.socialbase.downloader.model.DownloadInfo.Builder savePath(java.lang.String str) {
            this.savePath = str;
            return this;
        }

        public com.ss.android.socialbase.downloader.model.DownloadInfo.Builder setAutoInstall(boolean z) {
            this.autoInstall = z;
            return this;
        }

        public com.ss.android.socialbase.downloader.model.DownloadInfo.Builder showNotification(boolean z) {
            this.showNotification = z;
            return this;
        }

        public com.ss.android.socialbase.downloader.model.DownloadInfo.Builder showNotificationForAutoResumed(boolean z) {
            this.showNotificationForAutoResumed = z;
            return this;
        }

        public com.ss.android.socialbase.downloader.model.DownloadInfo.Builder taskKey(java.lang.String str) {
            this.taskKey = str;
            return this;
        }

        public com.ss.android.socialbase.downloader.model.DownloadInfo.Builder tempPath(java.lang.String str) {
            this.tempPath = str;
            return this;
        }

        public com.ss.android.socialbase.downloader.model.DownloadInfo.Builder throttleNetSpeed(long j) {
            this.throttleNetSpeed = j;
            return this;
        }

        public com.ss.android.socialbase.downloader.model.DownloadInfo.Builder title(java.lang.String str) {
            this.title = str;
            return this;
        }

        public com.ss.android.socialbase.downloader.model.DownloadInfo.Builder ttnetProtectTimeout(long j) {
            this.ttnetProtectTimeout = j;
            return this;
        }

        public com.ss.android.socialbase.downloader.model.DownloadInfo.Builder url(java.lang.String str) {
            this.url = str;
            return this;
        }
    }

    public DownloadInfo() {
        this.needDefaultHttpServiceBackUp = true;
        this.retryDelayStatus = com.ss.android.socialbase.downloader.constants.RetryDelayStatus.DELAY_RETRY_NONE;
        this.needReuseFirstConnection = false;
        this.asyncHandleStatus = com.ss.android.socialbase.downloader.constants.AsyncHandleStatus.ASYNC_HANDLE_NONE;
        this.supportPartial = true;
        this.needSDKMonitor = true;
        this.expiredRedownload = false;
        this.deleteCacheIfCheckFailed = false;
        this.successByCache = false;
        this.chunkCount = 1;
        this.isFirstDownload = true;
        this.isFirstSuccess = true;
        this.byteInvalidRetryStatus = com.ss.android.socialbase.downloader.constants.ByteInvalidRetryStatus.BYTE_INVALID_RETRY_STATUS_NONE;
        this.enqueueType = com.ss.android.socialbase.downloader.constants.EnqueueType.ENQUEUE_NONE;
        this.lastNotifyProgressTime = new java.util.concurrent.atomic.AtomicLong(0L);
        this.isAutoInstallWithoutNotification = null;
    }

    public DownloadInfo(android.database.Cursor cursor) {
        boolean z = true;
        this.needDefaultHttpServiceBackUp = true;
        com.ss.android.socialbase.downloader.constants.RetryDelayStatus retryDelayStatus = com.ss.android.socialbase.downloader.constants.RetryDelayStatus.DELAY_RETRY_NONE;
        this.retryDelayStatus = retryDelayStatus;
        this.needReuseFirstConnection = false;
        this.asyncHandleStatus = com.ss.android.socialbase.downloader.constants.AsyncHandleStatus.ASYNC_HANDLE_NONE;
        this.supportPartial = true;
        this.needSDKMonitor = true;
        this.expiredRedownload = false;
        this.deleteCacheIfCheckFailed = false;
        this.successByCache = false;
        this.chunkCount = 1;
        this.isFirstDownload = true;
        this.isFirstSuccess = true;
        this.byteInvalidRetryStatus = com.ss.android.socialbase.downloader.constants.ByteInvalidRetryStatus.BYTE_INVALID_RETRY_STATUS_NONE;
        this.enqueueType = com.ss.android.socialbase.downloader.constants.EnqueueType.ENQUEUE_NONE;
        this.lastNotifyProgressTime = new java.util.concurrent.atomic.AtomicLong(0L);
        this.isAutoInstallWithoutNotification = null;
        if (cursor == null) {
            return;
        }
        try {
            int columnIndex = cursor.getColumnIndex("_id");
            if (columnIndex != -1) {
                this.id = cursor.getInt(columnIndex);
            }
            int columnIndex2 = cursor.getColumnIndex("name");
            if (columnIndex2 != -1) {
                this.name = cursor.getString(columnIndex2);
            }
            int columnIndex3 = cursor.getColumnIndex("title");
            if (columnIndex3 != -1) {
                this.title = cursor.getString(columnIndex3);
            }
            int columnIndex4 = cursor.getColumnIndex("url");
            if (columnIndex4 != -1) {
                this.url = cursor.getString(columnIndex4);
            }
            int columnIndex5 = cursor.getColumnIndex(com.ss.android.socialbase.downloader.constants.DBDefinition.SAVE_PATH);
            if (columnIndex5 != -1) {
                this.savePath = cursor.getString(columnIndex5);
            }
            int columnIndex6 = cursor.getColumnIndex(com.ss.android.socialbase.downloader.constants.DBDefinition.TEMP_PATH);
            if (columnIndex6 != -1) {
                this.tempPath = cursor.getString(columnIndex6);
            }
            int columnIndex7 = cursor.getColumnIndex(com.ss.android.socialbase.downloader.constants.DBDefinition.CHUNK_COUNT);
            if (columnIndex7 != -1) {
                this.chunkCount = cursor.getInt(columnIndex7);
            }
            int columnIndex8 = cursor.getColumnIndex("status");
            if (columnIndex8 != -1) {
                this.status = new java.util.concurrent.atomic.AtomicInteger(cursor.getInt(columnIndex8));
            } else {
                this.status = new java.util.concurrent.atomic.AtomicInteger(0);
            }
            int columnIndex9 = cursor.getColumnIndex(com.ss.android.socialbase.downloader.constants.DBDefinition.CUR_BYTES);
            if (columnIndex9 != -1) {
                this.curBytes = new java.util.concurrent.atomic.AtomicLong(cursor.getLong(columnIndex9));
            } else {
                this.curBytes = new java.util.concurrent.atomic.AtomicLong(0L);
            }
            int columnIndex10 = cursor.getColumnIndex(com.ss.android.socialbase.downloader.constants.DBDefinition.TOTAL_BYTES);
            if (columnIndex10 != -1) {
                this.totalBytes = cursor.getLong(columnIndex10);
            }
            int columnIndex11 = cursor.getColumnIndex(com.ss.android.socialbase.downloader.constants.DBDefinition.ETAG);
            if (columnIndex11 != -1) {
                this.eTag = cursor.getString(columnIndex11);
            }
            int columnIndex12 = cursor.getColumnIndex(com.ss.android.socialbase.downloader.constants.DBDefinition.ONLY_WIFI);
            if (columnIndex12 != -1) {
                this.onlyWifi = cursor.getInt(columnIndex12) != 0;
            }
            int columnIndex13 = cursor.getColumnIndex("force");
            if (columnIndex13 != -1) {
                this.force = cursor.getInt(columnIndex13) != 0;
            }
            int columnIndex14 = cursor.getColumnIndex(com.ss.android.socialbase.downloader.constants.DBDefinition.RETRY_COUNT);
            if (columnIndex14 != -1) {
                this.retryCount = cursor.getInt(columnIndex14);
            }
            int columnIndex15 = cursor.getColumnIndex("extra");
            if (columnIndex15 != -1) {
                this.extra = cursor.getString(columnIndex15);
            }
            int columnIndex16 = cursor.getColumnIndex("mimeType");
            if (columnIndex16 != -1) {
                this.mimeType = cursor.getString(columnIndex16);
            }
            int columnIndex17 = cursor.getColumnIndex(com.ss.android.socialbase.downloader.constants.DBDefinition.NOTIFICATION_ENABLE);
            if (columnIndex17 != -1) {
                this.showNotification = cursor.getInt(columnIndex17) != 0;
            }
            int columnIndex18 = cursor.getColumnIndex(com.ss.android.socialbase.downloader.constants.DBDefinition.NOTIFICATION_VISIBILITY);
            if (columnIndex18 != -1) {
                this.notificationVisibility = cursor.getInt(columnIndex18);
            }
            int columnIndex19 = cursor.getColumnIndex(com.ss.android.socialbase.downloader.constants.DBDefinition.FIRST_DOWNLOAD);
            if (columnIndex19 != -1) {
                this.isFirstDownload = cursor.getInt(columnIndex19) == 1;
            }
            int columnIndex20 = cursor.getColumnIndex(com.ss.android.socialbase.downloader.constants.DBDefinition.FIRST_SUCCESS);
            if (columnIndex20 != -1) {
                this.isFirstSuccess = cursor.getInt(columnIndex20) == 1;
            }
            int columnIndex21 = cursor.getColumnIndex(com.ss.android.socialbase.downloader.constants.DBDefinition.NEED_HTTPS_TO_HTTP_RETRY);
            if (columnIndex21 != -1) {
                this.needHttpsToHttpRetry = cursor.getInt(columnIndex21) == 1;
            }
            int columnIndex22 = cursor.getColumnIndex(com.ss.android.socialbase.downloader.constants.DBDefinition.DOWNLOAD_TIME);
            if (columnIndex22 != -1) {
                this.downloadTime = cursor.getLong(columnIndex22);
            }
            int columnIndex23 = cursor.getColumnIndex("packageName");
            if (columnIndex23 != -1) {
                this.packageName = cursor.getString(columnIndex23);
            }
            int columnIndex24 = cursor.getColumnIndex("md5");
            if (columnIndex24 != -1) {
                this.md5 = cursor.getString(columnIndex24);
            }
            int columnIndex25 = cursor.getColumnIndex(com.ss.android.socialbase.downloader.constants.DBDefinition.RETRY_DELAY);
            if (columnIndex25 != -1) {
                this.needRetryDelay = cursor.getInt(columnIndex25) == 1;
            }
            int columnIndex26 = cursor.getColumnIndex(com.ss.android.socialbase.downloader.constants.DBDefinition.CUR_RETRY_TIME);
            if (columnIndex26 != -1) {
                this.curRetryTime = cursor.getInt(columnIndex26);
            }
            int columnIndex27 = cursor.getColumnIndex(com.ss.android.socialbase.downloader.constants.DBDefinition.RETRY_DELAY_STATUS);
            if (columnIndex27 != -1) {
                int i = cursor.getInt(columnIndex27);
                com.ss.android.socialbase.downloader.constants.RetryDelayStatus retryDelayStatus2 = com.ss.android.socialbase.downloader.constants.RetryDelayStatus.DELAY_RETRY_WAITING;
                if (i == retryDelayStatus2.ordinal()) {
                    this.retryDelayStatus = retryDelayStatus2;
                } else {
                    com.ss.android.socialbase.downloader.constants.RetryDelayStatus retryDelayStatus3 = com.ss.android.socialbase.downloader.constants.RetryDelayStatus.DELAY_RETRY_DOWNLOADING;
                    if (i == retryDelayStatus3.ordinal()) {
                        this.retryDelayStatus = retryDelayStatus3;
                    } else {
                        com.ss.android.socialbase.downloader.constants.RetryDelayStatus retryDelayStatus4 = com.ss.android.socialbase.downloader.constants.RetryDelayStatus.DELAY_RETRY_DOWNLOADED;
                        if (i == retryDelayStatus4.ordinal()) {
                            this.retryDelayStatus = retryDelayStatus4;
                        } else {
                            this.retryDelayStatus = retryDelayStatus;
                        }
                    }
                }
            }
            int columnIndex28 = cursor.getColumnIndex(com.ss.android.socialbase.downloader.constants.DBDefinition.DEFAULT_HTTP_SERVICE_BACKUP);
            if (columnIndex28 != -1) {
                this.needDefaultHttpServiceBackUp = cursor.getInt(columnIndex28) == 1;
            }
            int columnIndex29 = cursor.getColumnIndex(com.ss.android.socialbase.downloader.constants.DBDefinition.CHUNK_RUNNABLE_REUSE);
            if (columnIndex29 != -1) {
                this.needReuseChunkRunnable = cursor.getInt(columnIndex29) == 1;
            }
            int columnIndex30 = cursor.getColumnIndex(com.ss.android.socialbase.downloader.constants.DBDefinition.RETRY_DELAY_TIME_ARRAY);
            if (columnIndex30 != -1) {
                this.retryDelayTimeArray = cursor.getString(columnIndex30);
            }
            int columnIndex31 = cursor.getColumnIndex(com.ss.android.socialbase.downloader.constants.DBDefinition.CHUNK_DOWNGRADE_RETRY);
            if (columnIndex31 != -1) {
                this.needChunkDowngradeRetry = cursor.getInt(columnIndex31) == 1;
            }
            int columnIndex32 = cursor.getColumnIndex(com.ss.android.socialbase.downloader.constants.DBDefinition.BACKUP_URLS_STR);
            if (columnIndex32 != -1) {
                setBackUpUrlsStr(cursor.getString(columnIndex32));
            }
            int columnIndex33 = cursor.getColumnIndex(com.ss.android.socialbase.downloader.constants.DBDefinition.BACKUP_URL_RETRY_COUNT);
            if (columnIndex33 != -1) {
                this.backUpUrlRetryCount = cursor.getInt(columnIndex33);
            }
            int columnIndex34 = cursor.getColumnIndex(com.ss.android.socialbase.downloader.constants.DBDefinition.REAL_DOWNLOAD_TIME);
            if (columnIndex34 != -1) {
                this.realDownloadTime = cursor.getLong(columnIndex34);
            }
            int columnIndex35 = cursor.getColumnIndex(com.ss.android.socialbase.downloader.constants.DBDefinition.RETRY_SCHEDULE_MINUTES);
            if (columnIndex35 != -1) {
                this.retryScheduleMinutes = cursor.getInt(columnIndex35);
            }
            int columnIndex36 = cursor.getColumnIndex(com.ss.android.socialbase.downloader.constants.DBDefinition.INDEPENDENT_PROCESS);
            if (columnIndex36 != -1) {
                if (cursor.getInt(columnIndex36) != 1) {
                    z = false;
                }
                this.needIndependentProcess = z;
            }
            int columnIndex37 = cursor.getColumnIndex(com.ss.android.socialbase.downloader.constants.DBDefinition.AUXILIARY_JSONOBJECT_STRING);
            if (columnIndex37 != -1) {
                this.dbJsonDataString = cursor.getString(columnIndex37);
            }
            int columnIndex38 = cursor.getColumnIndex(com.ss.android.socialbase.downloader.constants.DBDefinition.ICON_URL);
            if (columnIndex38 != -1) {
                this.iconUrl = cursor.getString(columnIndex38);
            }
            int columnIndex39 = cursor.getColumnIndex(com.ss.android.socialbase.downloader.constants.DBDefinition.APP_VERSION_CODE);
            if (columnIndex39 != -1) {
                this.appVersionCode = cursor.getInt(columnIndex39);
            }
            int columnIndex40 = cursor.getColumnIndex(com.ss.android.socialbase.downloader.constants.DBDefinition.TASK_ID);
            if (columnIndex40 != -1) {
                this.taskId = cursor.getString(columnIndex40);
            }
            parseMonitorSetting();
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    public DownloadInfo(android.os.Parcel parcel) {
        this.needDefaultHttpServiceBackUp = true;
        this.retryDelayStatus = com.ss.android.socialbase.downloader.constants.RetryDelayStatus.DELAY_RETRY_NONE;
        this.needReuseFirstConnection = false;
        this.asyncHandleStatus = com.ss.android.socialbase.downloader.constants.AsyncHandleStatus.ASYNC_HANDLE_NONE;
        this.supportPartial = true;
        this.needSDKMonitor = true;
        this.expiredRedownload = false;
        this.deleteCacheIfCheckFailed = false;
        this.successByCache = false;
        this.chunkCount = 1;
        this.isFirstDownload = true;
        this.isFirstSuccess = true;
        this.byteInvalidRetryStatus = com.ss.android.socialbase.downloader.constants.ByteInvalidRetryStatus.BYTE_INVALID_RETRY_STATUS_NONE;
        this.enqueueType = com.ss.android.socialbase.downloader.constants.EnqueueType.ENQUEUE_NONE;
        this.lastNotifyProgressTime = new java.util.concurrent.atomic.AtomicLong(0L);
        this.isAutoInstallWithoutNotification = null;
        readFromParcel(parcel);
    }

    private DownloadInfo(com.ss.android.socialbase.downloader.model.DownloadInfo.Builder builder) {
        this.needDefaultHttpServiceBackUp = true;
        this.retryDelayStatus = com.ss.android.socialbase.downloader.constants.RetryDelayStatus.DELAY_RETRY_NONE;
        this.needReuseFirstConnection = false;
        this.asyncHandleStatus = com.ss.android.socialbase.downloader.constants.AsyncHandleStatus.ASYNC_HANDLE_NONE;
        this.supportPartial = true;
        this.needSDKMonitor = true;
        this.expiredRedownload = false;
        this.deleteCacheIfCheckFailed = false;
        this.successByCache = false;
        this.chunkCount = 1;
        this.isFirstDownload = true;
        this.isFirstSuccess = true;
        this.byteInvalidRetryStatus = com.ss.android.socialbase.downloader.constants.ByteInvalidRetryStatus.BYTE_INVALID_RETRY_STATUS_NONE;
        this.enqueueType = com.ss.android.socialbase.downloader.constants.EnqueueType.ENQUEUE_NONE;
        this.lastNotifyProgressTime = new java.util.concurrent.atomic.AtomicLong(0L);
        this.isAutoInstallWithoutNotification = null;
        if (builder == null) {
            return;
        }
        this.name = builder.name;
        this.title = builder.title;
        this.url = builder.url;
        java.lang.String str = builder.savePath;
        if (android.text.TextUtils.isEmpty(str)) {
            try {
                str = com.ss.android.socialbase.downloader.utils.DownloadUtils.getDownloadPath();
            } catch (java.lang.Throwable th) {
                th.printStackTrace();
            }
        }
        this.savePath = str;
        java.lang.String str2 = builder.tempPath;
        this.tempPath = str2;
        if (android.text.TextUtils.isEmpty(str2) && !com.ss.android.socialbase.downloader.utils.DownloadUtils.isSavePathSecurity(str)) {
            this.tempPath = com.ss.android.socialbase.downloader.utils.DownloadUtils.getDownloadTempPath();
        }
        safePutToDBJsonData(com.ss.android.socialbase.downloader.constants.DbJsonConstants.DBJSON_KEY_TASK_KEY, builder.taskKey);
        if (!builder.distinctDirectory) {
            com.ss.android.socialbase.downloader.logger.Logger.e(TAG, "The distinct directory option is not set, which may cause 1005 problems and file downloads being covered");
        } else if (com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.getDownloadCache().getDownloadInfo(getId()) == null) {
            this.savePath = com.ss.android.socialbase.downloader.utils.DownloadUtils.generateDistinctDirectory(this.savePath, this.url);
            this.tempPath = com.ss.android.socialbase.downloader.utils.DownloadUtils.generateDistinctDirectory(this.tempPath, this.url);
        }
        this.status = new java.util.concurrent.atomic.AtomicInteger(0);
        this.curBytes = new java.util.concurrent.atomic.AtomicLong(0L);
        this.extra = builder.extra;
        this.onlyWifi = builder.onlyWifi;
        this.extraHeaders = builder.extraHeaders;
        this.maxBytes = builder.maxBytes;
        this.retryCount = builder.retryCount;
        this.backUpUrlRetryCount = builder.backUpUrlRetryCount;
        this.force = builder.force;
        this.outIp = builder.outIp;
        this.outSize = builder.outSize;
        this.needPostProgress = builder.needPostProgress;
        this.maxProgressCount = builder.maxProgressCount;
        this.minProgressTimeMsInterval = builder.minProgressTimeMsInterval;
        this.backUpUrls = builder.backUpUrls;
        this.showNotification = builder.showNotification;
        this.mimeType = builder.mimeType;
        this.needHttpsToHttpRetry = builder.needHttpsToHttpRetry;
        this.needRetryDelay = builder.needRetryDelay;
        this.retryDelayTimeArray = builder.retryDelayTimeArray;
        this.autoResumed = builder.autoResumed;
        this.showNotificationForAutoResumed = builder.showNotificationForAutoResumed;
        this.needDefaultHttpServiceBackUp = builder.needDefaultHttpServiceBackUp;
        this.needReuseChunkRunnable = builder.needReuseChunkRunnable;
        this.packageName = builder.packageName;
        this.md5 = builder.md5;
        this.needReuseFirstConnection = builder.needReuseFirstConnection;
        this.needIndependentProcess = builder.needIndependentProcess;
        this.enqueueType = builder.enqueueType;
        this.headConnectionAvailable = builder.headConnectionAvailable;
        this.ignoreDataVerify = builder.ignoreDataVerify;
        this.addListenerToSameTask = builder.addListenerToSameTask;
        this.needChunkDowngradeRetry = builder.needChunkDowngradeRetry;
        this.iconUrl = builder.iconUrl;
        this.throttleNetSpeed = builder.throttleNetSpeed;
        this.openLimitSpeed = builder.openLimitSpeed;
        org.json.JSONObject jSONObject = builder.downloadSetting;
        if (jSONObject != null) {
            safePutToDBJsonData(com.ss.android.socialbase.downloader.constants.DbJsonConstants.DOWNLOAD_SETTING, jSONObject.toString());
        }
        safePutToDBJsonData(com.ss.android.socialbase.downloader.constants.DbJsonConstants.DBJSON_KEY_EXPECT_FILE_LENGTH, java.lang.Long.valueOf(builder.expectFileLength));
        safePutToDBJsonData(com.ss.android.socialbase.downloader.constants.DbJsonConstants.DBJSON_KEY_EXECUTOR, java.lang.Integer.valueOf(builder.executorGroup));
        safePutToDBJsonData(com.ss.android.socialbase.downloader.constants.DbJsonConstants.AUTO_INSTALL, java.lang.Integer.valueOf(builder.autoInstall ? 1 : 0));
        this.needSDKMonitor = builder.needSDKMonitor;
        this.monitorScene = builder.monitorScene;
        this.extraMonitorStatus = builder.extraMonitorStatus;
        this.expiredRedownload = builder.expiredRedownload;
        this.deleteCacheIfCheckFailed = builder.deleteCacheIfCheckFailed;
        this.ttnetProtectTimeout = builder.ttnetProtectTimeout;
        this.distinctDirectory = builder.distinctDirectory;
        if (this.expiredRedownload && this.retryCount <= 0) {
            this.retryCount = 1;
        }
        putMonitorSetting();
    }

    public /* synthetic */ DownloadInfo(com.ss.android.socialbase.downloader.model.DownloadInfo.Builder builder, com.ss.android.socialbase.downloader.model.DownloadInfo.AnonymousClass1 anonymousClass1) {
        this(builder);
    }

    private void convertEnqueueType(int i) {
        com.ss.android.socialbase.downloader.constants.EnqueueType enqueueType = com.ss.android.socialbase.downloader.constants.EnqueueType.ENQUEUE_HEAD;
        if (i == enqueueType.ordinal()) {
            this.enqueueType = enqueueType;
            return;
        }
        com.ss.android.socialbase.downloader.constants.EnqueueType enqueueType2 = com.ss.android.socialbase.downloader.constants.EnqueueType.ENQUEUE_TAIL;
        if (i == enqueueType2.ordinal()) {
            this.enqueueType = enqueueType2;
        } else {
            this.enqueueType = com.ss.android.socialbase.downloader.constants.EnqueueType.ENQUEUE_NONE;
        }
    }

    private void convertRetryDelayStatus(int i) {
        com.ss.android.socialbase.downloader.constants.RetryDelayStatus retryDelayStatus = com.ss.android.socialbase.downloader.constants.RetryDelayStatus.DELAY_RETRY_WAITING;
        if (i == retryDelayStatus.ordinal()) {
            this.retryDelayStatus = retryDelayStatus;
            return;
        }
        com.ss.android.socialbase.downloader.constants.RetryDelayStatus retryDelayStatus2 = com.ss.android.socialbase.downloader.constants.RetryDelayStatus.DELAY_RETRY_DOWNLOADING;
        if (i == retryDelayStatus2.ordinal()) {
            this.retryDelayStatus = retryDelayStatus2;
            return;
        }
        com.ss.android.socialbase.downloader.constants.RetryDelayStatus retryDelayStatus3 = com.ss.android.socialbase.downloader.constants.RetryDelayStatus.DELAY_RETRY_DOWNLOADED;
        if (i == retryDelayStatus3.ordinal()) {
            this.retryDelayStatus = retryDelayStatus3;
        } else {
            this.retryDelayStatus = com.ss.android.socialbase.downloader.constants.RetryDelayStatus.DELAY_RETRY_NONE;
        }
    }

    private org.json.JSONObject convertStrToJson(java.lang.String str) {
        try {
            if (android.text.TextUtils.isEmpty(str)) {
                return null;
            }
            return new org.json.JSONObject(str);
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    private void ensureDBJsonData() {
        if (this.dbJsonData == null) {
            synchronized (this) {
                if (this.dbJsonData == null) {
                    try {
                        if (android.text.TextUtils.isEmpty(this.dbJsonDataString)) {
                            this.dbJsonData = new org.json.JSONObject();
                        } else {
                            this.dbJsonData = new org.json.JSONObject(this.dbJsonDataString);
                            this.dbJsonDataString = null;
                        }
                    } catch (java.lang.Throwable unused) {
                        this.dbJsonData = new org.json.JSONObject();
                    }
                }
            }
        }
    }

    private void ensureSpData() {
        if (this.spData == null) {
            android.content.Context appContext = com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.getAppContext();
            if (appContext != null) {
                java.lang.String string = appContext.getSharedPreferences(com.ss.android.socialbase.downloader.constants.DownloadConstants.SP_DOWNLOAD_INFO, 0).getString(java.lang.Long.toString(getId()), "");
                if (!android.text.TextUtils.isEmpty(string)) {
                    try {
                        this.spData = new org.json.JSONObject(string);
                    } catch (org.json.JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
            if (this.spData == null) {
                this.spData = new org.json.JSONObject();
            }
        }
    }

    private void ensureTempCacheData() {
        if (this.tempCacheData == null) {
            synchronized (this) {
                if (this.tempCacheData == null) {
                    this.tempCacheData = new java.util.concurrent.ConcurrentHashMap<>();
                }
            }
        }
    }

    private java.lang.String getBackUpUrlsStr() {
        java.util.List<java.lang.String> list;
        if (this.backUpUrlsStr == null && (list = this.backUpUrls) != null && !list.isEmpty()) {
            try {
                org.json.JSONArray jSONArray = new org.json.JSONArray();
                for (java.lang.String str : this.backUpUrls) {
                    if (!android.text.TextUtils.isEmpty(str)) {
                        jSONArray.put(str);
                    }
                }
                this.backUpUrlsStr = jSONArray.toString();
            } catch (java.lang.Exception e) {
                e.printStackTrace();
            }
        }
        if (this.backUpUrlsStr == null) {
            this.backUpUrlsStr = "";
        }
        return this.backUpUrlsStr;
    }

    private java.lang.String getDBJsonDataString() {
        java.lang.String jSONObject;
        java.lang.String str = this.dbJsonDataString;
        if (str != null) {
            return str;
        }
        ensureDBJsonData();
        synchronized (this.dbJsonData) {
            jSONObject = this.dbJsonData.toString();
            this.dbJsonDataString = jSONObject;
        }
        return jSONObject;
    }

    private int getReserveWifiStatus() {
        ensureSpData();
        try {
            return this.spData.optInt("pause_reserve_on_wifi", 0);
        } catch (java.lang.Exception unused) {
            return 0;
        }
    }

    private void mergeAuxiliaryJSONObject(org.json.JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        ensureDBJsonData();
        synchronized (this.dbJsonData) {
            try {
                java.util.Iterator<java.lang.String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    java.lang.String next = keys.next();
                    java.lang.Object opt = jSONObject.opt(next);
                    if (!this.dbJsonData.has(next) && opt != null) {
                        this.dbJsonData.put(next, opt);
                    }
                }
            } catch (java.lang.Exception unused) {
            }
            this.dbJsonDataString = null;
        }
        parseMonitorSetting();
    }

    private void parseMonitorSetting() {
        ensureDBJsonData();
        this.needSDKMonitor = this.dbJsonData.optBoolean(com.ss.android.socialbase.downloader.constants.DbJsonConstants.NEED_SDK_MONITOR, false);
        this.monitorScene = this.dbJsonData.optString(com.ss.android.socialbase.downloader.constants.DbJsonConstants.MONITOR_SCENE, "");
        org.json.JSONArray optJSONArray = this.dbJsonData.optJSONArray(com.ss.android.socialbase.downloader.constants.DbJsonConstants.EXTRA_MONITOR_STATUS);
        if (optJSONArray == null || optJSONArray.length() <= 0) {
            return;
        }
        this.extraMonitorStatus = new int[optJSONArray.length()];
        for (int i = 0; i < optJSONArray.length(); i++) {
            this.extraMonitorStatus[i] = optJSONArray.optInt(i);
        }
    }

    private void putMonitorSetting() {
        safePutToDBJsonData(com.ss.android.socialbase.downloader.constants.DbJsonConstants.NEED_SDK_MONITOR, java.lang.Boolean.valueOf(this.needSDKMonitor));
        safePutToDBJsonData(com.ss.android.socialbase.downloader.constants.DbJsonConstants.MONITOR_SCENE, this.monitorScene);
        try {
            org.json.JSONArray jSONArray = new org.json.JSONArray();
            int[] iArr = this.extraMonitorStatus;
            if (iArr != null && iArr.length > 0) {
                int i = 0;
                while (true) {
                    int[] iArr2 = this.extraMonitorStatus;
                    if (i >= iArr2.length) {
                        break;
                    }
                    jSONArray.put(iArr2[i]);
                    i++;
                }
            }
            safePutToDBJsonData(com.ss.android.socialbase.downloader.constants.DbJsonConstants.EXTRA_MONITOR_STATUS, jSONArray);
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void refreshBackupUrls(boolean z) {
        java.util.List<java.lang.String> list = this.forbiddenBackupUrls;
        if (list == null || list.size() <= z) {
            return;
        }
        java.util.List<java.lang.String> list2 = this.backUpUrls;
        if (list2 == null) {
            this.backUpUrls = new java.util.ArrayList();
        } else {
            list2.clear();
        }
        this.backUpUrlUsed = false;
        this.curBackUpUrlIndex = 0;
        for (int i = z; i < this.forbiddenBackupUrls.size(); i++) {
            this.backUpUrls.add(this.forbiddenBackupUrls.get(i));
        }
    }

    private void setBackUpUrlsStr(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str) || getStatus() == -3) {
            return;
        }
        this.backUpUrlsStr = str;
        try {
            org.json.JSONArray jSONArray = new org.json.JSONArray(str);
            if (jSONArray.length() > 0) {
                java.util.ArrayList arrayList = new java.util.ArrayList();
                for (int i = 0; i < jSONArray.length(); i++) {
                    java.lang.String optString = jSONArray.optString(i);
                    if (!android.text.TextUtils.isEmpty(optString)) {
                        arrayList.add(optString);
                    }
                }
                this.backUpUrls = arrayList;
            }
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    public void addErrorBytesLog(long j, int i, java.lang.String str) {
        try {
            if (com.ss.android.socialbase.downloader.logger.Logger.debug()) {
                if (this.errorBytesLog == null) {
                    this.errorBytesLog = new java.lang.StringBuffer();
                }
                if (this.errorBytesLog.length() != 0) {
                    this.errorBytesLog.append(",");
                }
                java.lang.StringBuffer stringBuffer = this.errorBytesLog;
                stringBuffer.append("[type:");
                stringBuffer.append(i);
                stringBuffer.append(",bytes:");
                stringBuffer.append(j);
                stringBuffer.append(",method:");
                stringBuffer.append(str);
                stringBuffer.append("]");
            }
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    public void bindValue(android.database.sqlite.SQLiteStatement sQLiteStatement) {
        if (sQLiteStatement == null) {
            return;
        }
        this.bindValueCount = 0;
        sQLiteStatement.clearBindings();
        int i = this.bindValueCount + 1;
        this.bindValueCount = i;
        sQLiteStatement.bindLong(i, this.id);
        int i2 = this.bindValueCount + 1;
        this.bindValueCount = i2;
        java.lang.String str = this.url;
        if (str == null) {
            str = "";
        }
        sQLiteStatement.bindString(i2, str);
        int i3 = this.bindValueCount + 1;
        this.bindValueCount = i3;
        java.lang.String str2 = this.savePath;
        if (str2 == null) {
            str2 = "";
        }
        sQLiteStatement.bindString(i3, str2);
        int i4 = this.bindValueCount + 1;
        this.bindValueCount = i4;
        java.lang.String str3 = this.tempPath;
        if (str3 == null) {
            str3 = "";
        }
        sQLiteStatement.bindString(i4, str3);
        int i5 = this.bindValueCount + 1;
        this.bindValueCount = i5;
        java.lang.String str4 = this.name;
        if (str4 == null) {
            str4 = "";
        }
        sQLiteStatement.bindString(i5, str4);
        int i6 = this.bindValueCount + 1;
        this.bindValueCount = i6;
        sQLiteStatement.bindLong(i6, this.chunkCount);
        int i7 = this.bindValueCount + 1;
        this.bindValueCount = i7;
        sQLiteStatement.bindLong(i7, getStatus());
        int i8 = this.bindValueCount + 1;
        this.bindValueCount = i8;
        sQLiteStatement.bindLong(i8, getCurBytes());
        int i9 = this.bindValueCount + 1;
        this.bindValueCount = i9;
        sQLiteStatement.bindLong(i9, this.totalBytes);
        int i10 = this.bindValueCount + 1;
        this.bindValueCount = i10;
        java.lang.String str5 = this.eTag;
        if (str5 == null) {
            str5 = "";
        }
        sQLiteStatement.bindString(i10, str5);
        int i11 = this.bindValueCount + 1;
        this.bindValueCount = i11;
        sQLiteStatement.bindLong(i11, this.onlyWifi ? 1L : 0L);
        int i12 = this.bindValueCount + 1;
        this.bindValueCount = i12;
        sQLiteStatement.bindLong(i12, this.force ? 1L : 0L);
        int i13 = this.bindValueCount + 1;
        this.bindValueCount = i13;
        sQLiteStatement.bindLong(i13, this.retryCount);
        int i14 = this.bindValueCount + 1;
        this.bindValueCount = i14;
        java.lang.String str6 = this.extra;
        if (str6 == null) {
            str6 = "";
        }
        sQLiteStatement.bindString(i14, str6);
        int i15 = this.bindValueCount + 1;
        this.bindValueCount = i15;
        java.lang.String str7 = this.mimeType;
        if (str7 == null) {
            str7 = "";
        }
        sQLiteStatement.bindString(i15, str7);
        int i16 = this.bindValueCount + 1;
        this.bindValueCount = i16;
        java.lang.String str8 = this.title;
        if (str8 == null) {
            str8 = "";
        }
        sQLiteStatement.bindString(i16, str8);
        int i17 = this.bindValueCount + 1;
        this.bindValueCount = i17;
        sQLiteStatement.bindLong(i17, this.showNotification ? 1L : 0L);
        int i18 = this.bindValueCount + 1;
        this.bindValueCount = i18;
        sQLiteStatement.bindLong(i18, this.notificationVisibility);
        int i19 = this.bindValueCount + 1;
        this.bindValueCount = i19;
        sQLiteStatement.bindLong(i19, this.isFirstDownload ? 1L : 0L);
        int i20 = this.bindValueCount + 1;
        this.bindValueCount = i20;
        sQLiteStatement.bindLong(i20, this.isFirstSuccess ? 1L : 0L);
        int i21 = this.bindValueCount + 1;
        this.bindValueCount = i21;
        sQLiteStatement.bindLong(i21, this.needHttpsToHttpRetry ? 1L : 0L);
        int i22 = this.bindValueCount + 1;
        this.bindValueCount = i22;
        sQLiteStatement.bindLong(i22, this.downloadTime);
        int i23 = this.bindValueCount + 1;
        this.bindValueCount = i23;
        java.lang.String str9 = this.packageName;
        if (str9 == null) {
            str9 = "";
        }
        sQLiteStatement.bindString(i23, str9);
        int i24 = this.bindValueCount + 1;
        this.bindValueCount = i24;
        java.lang.String str10 = this.md5;
        if (str10 == null) {
            str10 = "";
        }
        sQLiteStatement.bindString(i24, str10);
        int i25 = this.bindValueCount + 1;
        this.bindValueCount = i25;
        sQLiteStatement.bindLong(i25, this.needRetryDelay ? 1L : 0L);
        int i26 = this.bindValueCount + 1;
        this.bindValueCount = i26;
        sQLiteStatement.bindLong(i26, this.curRetryTime);
        int i27 = this.bindValueCount + 1;
        this.bindValueCount = i27;
        sQLiteStatement.bindLong(i27, this.retryDelayStatus.ordinal());
        int i28 = this.bindValueCount + 1;
        this.bindValueCount = i28;
        sQLiteStatement.bindLong(i28, this.needDefaultHttpServiceBackUp ? 1L : 0L);
        int i29 = this.bindValueCount + 1;
        this.bindValueCount = i29;
        sQLiteStatement.bindLong(i29, this.needReuseChunkRunnable ? 1L : 0L);
        int i30 = this.bindValueCount + 1;
        this.bindValueCount = i30;
        java.lang.String str11 = this.retryDelayTimeArray;
        if (str11 == null) {
            str11 = "";
        }
        sQLiteStatement.bindString(i30, str11);
        int i31 = this.bindValueCount + 1;
        this.bindValueCount = i31;
        sQLiteStatement.bindLong(i31, this.needChunkDowngradeRetry ? 1L : 0L);
        int i32 = this.bindValueCount + 1;
        this.bindValueCount = i32;
        sQLiteStatement.bindString(i32, getBackUpUrlsStr());
        int i33 = this.bindValueCount + 1;
        this.bindValueCount = i33;
        sQLiteStatement.bindLong(i33, this.backUpUrlRetryCount);
        int i34 = this.bindValueCount + 1;
        this.bindValueCount = i34;
        sQLiteStatement.bindLong(i34, this.realDownloadTime);
        int i35 = this.bindValueCount + 1;
        this.bindValueCount = i35;
        sQLiteStatement.bindLong(i35, this.retryScheduleMinutes);
        int i36 = this.bindValueCount + 1;
        this.bindValueCount = i36;
        sQLiteStatement.bindLong(i36, this.needIndependentProcess ? 1L : 0L);
        int i37 = this.bindValueCount + 1;
        this.bindValueCount = i37;
        sQLiteStatement.bindString(i37, getDBJsonDataString());
        int i38 = this.bindValueCount + 1;
        this.bindValueCount = i38;
        java.lang.String str12 = this.iconUrl;
        if (str12 == null) {
            str12 = "";
        }
        sQLiteStatement.bindString(i38, str12);
        int i39 = this.bindValueCount + 1;
        this.bindValueCount = i39;
        sQLiteStatement.bindLong(i39, this.appVersionCode);
        int i40 = this.bindValueCount + 1;
        this.bindValueCount = i40;
        java.lang.String str13 = this.taskId;
        sQLiteStatement.bindString(i40, str13 != null ? str13 : "");
    }

    public boolean cacheExpierd() {
        if (isDownloaded()) {
            return com.ss.android.socialbase.downloader.utils.DownloadUtils.cacheExpired(this);
        }
        return true;
    }

    public boolean canNotifyProgress() {
        long j = this.lastNotifyProgressTime.get();
        return j == 0 || android.os.SystemClock.uptimeMillis() - j > 20;
    }

    public boolean canReStartAsyncTask() {
        return getStatus() != -3 && this.asyncHandleStatus == com.ss.android.socialbase.downloader.constants.AsyncHandleStatus.ASYNC_HANDLE_WAITING;
    }

    public boolean canReplaceHttpForRetry() {
        return !android.text.TextUtils.isEmpty(this.url) && this.url.startsWith("https") && this.needHttpsToHttpRetry && !this.httpsToHttpRetryUsed;
    }

    public boolean canShowNotification() {
        boolean z = this.autoResumed;
        if (!z && this.showNotification) {
            return true;
        }
        if (z) {
            return this.showNotificationForAutoResumed || this.showNotificationForNetworkResumed;
        }
        return false;
    }

    public boolean canSkipStatusHandler() {
        com.ss.android.socialbase.downloader.constants.AsyncHandleStatus asyncHandleStatus;
        int status = getStatus();
        return status == 7 || this.retryDelayStatus == com.ss.android.socialbase.downloader.constants.RetryDelayStatus.DELAY_RETRY_WAITING || status == 8 || (asyncHandleStatus = this.asyncHandleStatus) == com.ss.android.socialbase.downloader.constants.AsyncHandleStatus.ASYNC_HANDLE_WAITING || asyncHandleStatus == com.ss.android.socialbase.downloader.constants.AsyncHandleStatus.ASYNC_HANDLE_RESTART || this.byteInvalidRetryStatus == com.ss.android.socialbase.downloader.constants.ByteInvalidRetryStatus.BYTE_INVALID_RETRY_STATUS_RESTART;
    }

    public boolean canStartRetryDelayTask() {
        return isNeedRetryDelay() && getStatus() != -3 && this.retryDelayStatus == com.ss.android.socialbase.downloader.constants.RetryDelayStatus.DELAY_RETRY_WAITING;
    }

    public void changeSkipStatus() {
        com.ss.android.socialbase.downloader.constants.AsyncHandleStatus asyncHandleStatus;
        int status = getStatus();
        if (status == 7 || this.retryDelayStatus == com.ss.android.socialbase.downloader.constants.RetryDelayStatus.DELAY_RETRY_WAITING) {
            setRetryDelayStatus(com.ss.android.socialbase.downloader.constants.RetryDelayStatus.DELAY_RETRY_DOWNLOADING);
        }
        if (status == 8 || (asyncHandleStatus = this.asyncHandleStatus) == com.ss.android.socialbase.downloader.constants.AsyncHandleStatus.ASYNC_HANDLE_WAITING || asyncHandleStatus == com.ss.android.socialbase.downloader.constants.AsyncHandleStatus.ASYNC_HANDLE_RESTART) {
            setAsyncHandleStatus(com.ss.android.socialbase.downloader.constants.AsyncHandleStatus.ASYNC_HANDLE_DOWNLOADING);
        }
        if (this.byteInvalidRetryStatus == com.ss.android.socialbase.downloader.constants.ByteInvalidRetryStatus.BYTE_INVALID_RETRY_STATUS_RESTART) {
            setByteInvalidRetryStatus(com.ss.android.socialbase.downloader.constants.ByteInvalidRetryStatus.BYTE_INVALID_RETRY_STATUS_DOWNLOADING);
        }
    }

    public int checkMd5Status() {
        return com.ss.android.socialbase.downloader.utils.DownloadUtils.checkMd5Status(getSavePath(), getName(), this.md5);
    }

    public boolean checkMd5Valid() {
        return com.ss.android.socialbase.downloader.utils.DownloadUtils.checkMd5Valid(getSavePath(), getName(), this.md5);
    }

    public void clearSpData() {
        android.content.Context appContext = com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.getAppContext();
        if (appContext != null) {
            try {
                appContext.getSharedPreferences(com.ss.android.socialbase.downloader.constants.DownloadConstants.SP_DOWNLOAD_INFO, 0).edit().remove(java.lang.Integer.toString(getId())).apply();
            } catch (java.lang.Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public void copyFromCacheData(com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo, boolean z) {
        if (downloadInfo == null) {
            return;
        }
        setChunkCount(downloadInfo.getChunkCount());
        setTotalBytes(downloadInfo.getTotalBytes());
        setCurBytes(downloadInfo.getCurBytes(), true);
        this.realDownloadTime = downloadInfo.realDownloadTime;
        if (downloadInfo.canSkipStatusHandler() || canSkipStatusHandler()) {
            this.curRetryTime = downloadInfo.getCurRetryTime();
        } else {
            this.curRetryTime = 0;
            this.isForbiddenRetryed = false;
            this.backUpUrlUsed = false;
            this.curBackUpUrlIndex = 0;
            this.httpsToHttpRetryUsed = false;
        }
        seteTag(downloadInfo.geteTag());
        if (z) {
            setStatus(downloadInfo.getStatus());
        }
        this.isFirstDownload = downloadInfo.getIsFirstDownload();
        this.isFirstSuccess = downloadInfo.isFirstSuccess();
        this.retryDelayStatus = downloadInfo.getRetryDelayStatus();
        mergeAuxiliaryJSONObject(downloadInfo.dbJsonData);
    }

    public void copyTaskIdFromCacheData(com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo) {
        if (downloadInfo == null) {
            return;
        }
        this.taskId = downloadInfo.getTaskId();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equalsTask(com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo) {
        java.lang.String str;
        java.lang.String str2;
        return (downloadInfo == null || (str = this.url) == null || !str.equals(downloadInfo.getUrl()) || (str2 = this.savePath) == null || !str2.equals(downloadInfo.getSavePath())) ? false : true;
    }

    public void erase() {
        setCurBytes(0L, true);
        this.totalBytes = 0L;
        this.chunkCount = 1;
        this.downloadTime = 0L;
        this.realStartDownloadTime = 0L;
        this.realDownloadTime = 0L;
        this.curRetryTime = 0;
        this.isFirstDownload = true;
        this.isFirstSuccess = true;
        this.backUpUrlUsed = false;
        this.httpsToHttpRetryUsed = false;
        this.eTag = null;
        this.failedException = null;
        this.tempCacheData = null;
        this.packageInfoRef = null;
    }

    public void generateTaskId() {
        this.taskId = java.util.UUID.randomUUID().toString();
    }

    public long getAllConnectTime() {
        ensureDBJsonData();
        if (this.allConnectTime == null) {
            this.allConnectTime = new java.util.concurrent.atomic.AtomicLong(this.dbJsonData.optLong(com.ss.android.socialbase.downloader.constants.DbJsonConstants.DBJSON_KEY_ALL_CONNECT_TIME));
        }
        return this.allConnectTime.get();
    }

    public int getAntiHijackErrorCode(int i) {
        ensureDBJsonData();
        return this.dbJsonData.optInt(com.ss.android.socialbase.downloader.constants.DbJsonConstants.DBJSON_KEY_ANTI_HIJACK_ERROR_CODE, i);
    }

    public int getAppVersionCode() {
        return this.appVersionCode;
    }

    public com.ss.android.socialbase.downloader.constants.AsyncHandleStatus getAsyncHandleStatus() {
        return this.asyncHandleStatus;
    }

    public java.lang.String getBackUpUrl() {
        java.util.List<java.lang.String> list;
        int i;
        if (this.backUpUrlUsed && (list = this.backUpUrls) != null && list.size() > 0 && (i = this.curBackUpUrlIndex) >= 0 && i < this.backUpUrls.size()) {
            java.lang.String str = this.backUpUrls.get(this.curBackUpUrlIndex);
            if (!android.text.TextUtils.isEmpty(str)) {
                return str;
            }
        }
        return "";
    }

    public int getBackUpUrlRetryCount() {
        return this.backUpUrlRetryCount;
    }

    public java.util.List<java.lang.String> getBackUpUrls() {
        return this.backUpUrls;
    }

    public int getBindValueCount() {
        return this.bindValueCount;
    }

    public com.ss.android.socialbase.downloader.constants.ByteInvalidRetryStatus getByteInvalidRetryStatus() {
        return this.byteInvalidRetryStatus;
    }

    public java.lang.String getCacheControl() {
        ensureSpData();
        try {
            return this.spData.optString(com.ss.android.socialbase.downloader.constants.SpJsonConstants.CACHE_CONTROL, null);
        } catch (java.lang.Exception unused) {
            return null;
        }
    }

    public long getCacheExpiredTime() {
        ensureSpData();
        try {
            return this.spData.optLong(com.ss.android.socialbase.downloader.constants.SpJsonConstants.CACHE_CONTROL_EXPIRED_TIME, -1L);
        } catch (java.lang.Exception unused) {
            return -1L;
        }
    }

    public int getChunkCount() {
        return this.chunkCount;
    }

    public java.lang.String getConnectionUrl() {
        java.util.List<java.lang.String> list;
        int i;
        java.util.List<java.lang.String> list2;
        java.lang.String str = this.url;
        if (getStatus() == 8 && (list2 = this.forbiddenBackupUrls) != null && !list2.isEmpty() && !this.backUpUrlUsed) {
            return this.forbiddenBackupUrls.get(0);
        }
        if (!this.backUpUrlUsed || (list = this.backUpUrls) == null || list.size() <= 0 || (i = this.curBackUpUrlIndex) < 0 || i >= this.backUpUrls.size()) {
            return (!android.text.TextUtils.isEmpty(this.url) && this.url.startsWith("https") && this.needHttpsToHttpRetry && this.httpsToHttpRetryUsed) ? this.url.replaceFirst("https", com.alipay.sdk.m.l.a.q) : str;
        }
        java.lang.String str2 = this.backUpUrls.get(this.curBackUpUrlIndex);
        return !android.text.TextUtils.isEmpty(str2) ? str2 : str;
    }

    public int getCurBackUpUrlIndex() {
        return this.curBackUpUrlIndex;
    }

    public long getCurBytes() {
        java.util.concurrent.atomic.AtomicLong atomicLong = this.curBytes;
        if (atomicLong != null) {
            return atomicLong.get();
        }
        return 0L;
    }

    public int getCurRetryTime() {
        return this.curRetryTime;
    }

    public int getCurRetryTimeInTotal() {
        int i = this.curRetryTime;
        if (!this.backUpUrlUsed) {
            return i;
        }
        int i2 = i + this.retryCount;
        int i3 = this.curBackUpUrlIndex;
        return i3 > 0 ? i2 + (i3 * this.backUpUrlRetryCount) : i2;
    }

    public int getDBJsonInt(java.lang.String str) {
        ensureDBJsonData();
        return this.dbJsonData.optInt(str);
    }

    public java.lang.String getDBJsonString(java.lang.String str) {
        ensureDBJsonData();
        return this.dbJsonData.optString(str);
    }

    public long getDownloadPrepareTime() {
        ensureDBJsonData();
        return this.dbJsonData.optLong(com.ss.android.socialbase.downloader.constants.DbJsonConstants.DBJSON_KEY_DOWNLOAD_PREPARE_TIME);
    }

    public int getDownloadProcess() {
        if (this.totalBytes <= 0) {
            return 0;
        }
        if (getCurBytes() > this.totalBytes) {
            return 100;
        }
        return (int) ((getCurBytes() * 100) / this.totalBytes);
    }

    public java.lang.String getDownloadSettingString() {
        ensureDBJsonData();
        return this.dbJsonData.optString(com.ss.android.socialbase.downloader.constants.DbJsonConstants.DOWNLOAD_SETTING);
    }

    public double getDownloadSpeed() {
        double curBytes = getCurBytes() / 1048576.0d;
        double realDownloadTime = getRealDownloadTime() / 1000.0d;
        if (curBytes <= 0.0d || realDownloadTime <= 0.0d) {
            return -1.0d;
        }
        return curBytes / realDownloadTime;
    }

    public long getDownloadTime() {
        return this.downloadTime;
    }

    public com.ss.android.socialbase.downloader.constants.EnqueueType getEnqueueType() {
        return this.enqueueType;
    }

    public java.lang.String getErrorBytesLog() {
        java.lang.StringBuffer stringBuffer = this.errorBytesLog;
        return (stringBuffer == null || stringBuffer.length() == 0) ? "" : this.errorBytesLog.toString();
    }

    public int getExecutorGroup() {
        ensureDBJsonData();
        return this.dbJsonData.optInt(com.ss.android.socialbase.downloader.constants.DbJsonConstants.DBJSON_KEY_EXECUTOR, 2);
    }

    public long getExpectFileLength() {
        ensureDBJsonData();
        return this.dbJsonData.optLong(com.ss.android.socialbase.downloader.constants.DbJsonConstants.DBJSON_KEY_EXPECT_FILE_LENGTH);
    }

    public java.lang.String getExtra() {
        return this.extra;
    }

    public java.util.List<com.ss.android.socialbase.downloader.model.HttpHeader> getExtraHeaders() {
        return this.extraHeaders;
    }

    public int[] getExtraMonitorStatus() {
        return this.extraMonitorStatus;
    }

    public com.ss.android.socialbase.downloader.exception.BaseException getFailedException() {
        return this.failedException;
    }

    public int getFailedResumeCount() {
        ensureSpData();
        return this.spData.optInt("failed_resume_count", 0);
    }

    public java.lang.String getFilePackageName() {
        return this.filePackageName;
    }

    public long getFirstSpeedTime() {
        ensureDBJsonData();
        return this.dbJsonData.optLong(com.ss.android.socialbase.downloader.constants.DbJsonConstants.DBJSON_KEY_FIRST_SPEED_TIME);
    }

    public java.util.List<java.lang.String> getForbiddenBackupUrls() {
        return this.forbiddenBackupUrls;
    }

    public java.lang.String getHeadConnectionException() {
        return this.headConnectionException;
    }

    public int getHttpStatusCode() {
        return this.httpStatusCode;
    }

    public java.lang.String getHttpStatusMessage() {
        return this.httpStatusMessage;
    }

    public java.lang.String getIconUrl() {
        return this.iconUrl;
    }

    public int getId() {
        if (this.id == 0) {
            this.id = com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.getDownloadId(this);
        }
        return this.id;
    }

    public boolean getIsFirstDownload() {
        return this.isFirstDownload;
    }

    public long getLastDownloadTime() {
        ensureDBJsonData();
        return this.dbJsonData.optLong(com.ss.android.socialbase.downloader.constants.DbJsonConstants.DBJSON_KEY_LAST_START_DOWNLOAD_TIME, 0L);
    }

    public long getLastFailedResumeTime() {
        ensureSpData();
        return this.spData.optLong(com.ss.android.socialbase.downloader.constants.SpJsonConstants.KEY_LAST_FAILED_RESUME_TIME, 0L);
    }

    public java.lang.String getLastModified() {
        ensureSpData();
        try {
            return this.spData.optString("last-modified", null);
        } catch (java.lang.Exception unused) {
            return null;
        }
    }

    public long getLastUninstallResumeTime() {
        ensureSpData();
        return this.spData.optLong(com.ss.android.socialbase.downloader.constants.SpJsonConstants.KEY_LAST_UNINSTALL_RESUME_TIME, 0L);
    }

    public int getLinkMode() {
        ensureDBJsonData();
        return this.dbJsonData.optInt(com.ss.android.socialbase.downloader.constants.DbJsonConstants.DBJSON_KEY_LINK_MODE);
    }

    public int getMaxBytes() {
        return this.maxBytes;
    }

    public int getMaxProgressCount() {
        return this.maxProgressCount;
    }

    public java.lang.String getMd5() {
        return this.md5;
    }

    public java.lang.String getMimeType() {
        return this.mimeType;
    }

    public long getMinByteIntervalForPostToMainThread(long j) {
        int i = this.maxProgressCount;
        if (i <= 0) {
            i = 100;
        }
        long j2 = j / (i + 1);
        if (j2 <= 0) {
            return 1048576L;
        }
        return j2;
    }

    public int getMinProgressTimeMsInterval() {
        int i = this.minProgressTimeMsInterval;
        if (i < 1000) {
            return 1000;
        }
        return i;
    }

    public java.lang.String getMonitorScene() {
        return this.monitorScene;
    }

    public java.lang.String getName() {
        return this.name;
    }

    public java.lang.String getNetworkQuality() {
        return this.networkQuality;
    }

    public int getNotificationVisibility() {
        return this.notificationVisibility;
    }

    public boolean getOpenLimitSpeed() {
        return this.openLimitSpeed;
    }

    public java.lang.String[] getOutIp() {
        return this.outIp;
    }

    public int[] getOutSize() {
        return this.outSize;
    }

    public android.content.pm.PackageInfo getPackageInfo() {
        java.lang.ref.SoftReference<android.content.pm.PackageInfo> softReference = this.packageInfoRef;
        if (softReference == null) {
            return null;
        }
        return softReference.get();
    }

    public java.lang.String getPackageName() {
        return this.packageName;
    }

    public int getPausedResumeCount() {
        ensureSpData();
        return this.spData.optInt(com.ss.android.socialbase.downloader.constants.DownloadConstants.KEY_PAUSED_RESUME_COUNT, 0);
    }

    public int getPreconnectLevel() {
        ensureDBJsonData();
        return this.dbJsonData.optInt(com.ss.android.socialbase.downloader.constants.DbJsonConstants.DBJSON_KEY_PRECONNECT_LEVEL, 0);
    }

    public long getRealDownloadTime() {
        return java.util.concurrent.TimeUnit.NANOSECONDS.toMillis(this.realDownloadTime);
    }

    public int getRealStatus() {
        java.util.concurrent.atomic.AtomicInteger atomicInteger = this.status;
        if (atomicInteger != null) {
            return atomicInteger.get();
        }
        return 0;
    }

    public int getRetryCount() {
        return this.retryCount;
    }

    public com.ss.android.socialbase.downloader.constants.RetryDelayStatus getRetryDelayStatus() {
        return this.retryDelayStatus;
    }

    public java.lang.String getRetryDelayTimeArray() {
        return this.retryDelayTimeArray;
    }

    public int getRetryScheduleCount() {
        ensureDBJsonData();
        return this.dbJsonData.optInt("retry_schedule_count", 0);
    }

    public java.lang.String getSavePath() {
        return this.savePath;
    }

    public int getSpIntVal(java.lang.String str) {
        ensureSpData();
        return this.spData.optInt(str, 0);
    }

    public long getSpLongVal(java.lang.String str) {
        ensureSpData();
        return this.spData.optLong(str, 0L);
    }

    public java.lang.String getSpStringVal(java.lang.String str) {
        ensureSpData();
        return this.spData.optString(str, null);
    }

    public int getStatus() {
        java.util.concurrent.atomic.AtomicInteger atomicInteger = this.status;
        if (atomicInteger == null) {
            return 0;
        }
        int i = atomicInteger.get();
        if (i == -5) {
            return -2;
        }
        return i;
    }

    public int getStatusAtDbInit() {
        return this.statusAtDbInit;
    }

    public int getTTMd5CheckStatus() {
        ensureDBJsonData();
        return this.dbJsonData.optInt(com.ss.android.socialbase.downloader.constants.DbJsonConstants.DBJSON_KEY_TTMD5_CHECK_STATUS, -1);
    }

    public java.lang.String getTargetFilePath() {
        return com.ss.android.socialbase.downloader.utils.DownloadUtils.getTargetFilePath(this.savePath, this.name);
    }

    public java.lang.String getTaskId() {
        return this.taskId;
    }

    public java.lang.String getTaskKey() {
        ensureDBJsonData();
        return this.dbJsonData.optString(com.ss.android.socialbase.downloader.constants.DbJsonConstants.DBJSON_KEY_TASK_KEY);
    }

    public java.util.concurrent.ConcurrentHashMap<java.lang.String, java.lang.Object> getTempCacheData() {
        ensureTempCacheData();
        return this.tempCacheData;
    }

    public java.lang.String getTempFilePath() {
        return com.ss.android.socialbase.downloader.utils.DownloadUtils.getTempFilePath(this.savePath, this.tempPath, this.name);
    }

    public java.lang.String getTempName() {
        return com.ss.android.socialbase.downloader.utils.DownloadUtils.getTempFileName(this.name);
    }

    public java.lang.String getTempPath() {
        return com.ss.android.socialbase.downloader.utils.DownloadUtils.getTempFileSavePath(this.savePath, this.tempPath);
    }

    public long getThrottleNetSpeed() {
        return this.throttleNetSpeed;
    }

    public java.lang.String getTitle() {
        return android.text.TextUtils.isEmpty(this.title) ? this.name : this.title;
    }

    public long getTotalBytes() {
        return this.totalBytes;
    }

    public int getTotalRetryCount() {
        int i = this.retryCount;
        java.util.List<java.lang.String> list = this.backUpUrls;
        return (list == null || list.isEmpty()) ? i : i + (this.backUpUrlRetryCount * this.backUpUrls.size());
    }

    public long getTtnetProtectTimeout() {
        return this.ttnetProtectTimeout;
    }

    public int getUninstallResumeCount() {
        ensureSpData();
        return this.spData.optInt(com.ss.android.socialbase.downloader.constants.SpJsonConstants.KEY_UNINSTALL_RESUME_COUNT, 0);
    }

    public java.lang.String getUrl() {
        return this.url;
    }

    public java.lang.String geteTag() {
        return this.eTag;
    }

    public synchronized void handleTempSaveCallback(boolean z, com.ss.android.socialbase.downloader.exception.BaseException baseException) {
        this.isSaveTempFile = false;
        if (this.tempFileSaveCompleteCallbacks == null) {
            return;
        }
        com.ss.android.socialbase.downloader.logger.Logger.d(TAG, "handleTempSaveCallback isSuccess " + z + " callback size:" + this.tempFileSaveCompleteCallbacks.size());
        for (com.ss.android.socialbase.downloader.depend.ITempFileSaveCompleteCallback iTempFileSaveCompleteCallback : this.tempFileSaveCompleteCallbacks) {
            if (iTempFileSaveCompleteCallback != null) {
                if (z) {
                    iTempFileSaveCompleteCallback.onSuccess();
                } else {
                    iTempFileSaveCompleteCallback.onFailed(baseException);
                }
            }
        }
    }

    public boolean hasNextBackupUrl() {
        int i;
        java.util.List<java.lang.String> list = this.backUpUrls;
        if (list == null || list.size() <= 0) {
            return false;
        }
        return !this.backUpUrlUsed || ((i = this.curBackUpUrlIndex) >= 0 && i < this.backUpUrls.size() - 1);
    }

    public boolean hasPauseReservedOnWifi() {
        return (getReserveWifiStatus() & 1) > 0;
    }

    public void increaseAllConnectTime(long j) {
        if (j > 0) {
            getAllConnectTime();
            safePutToDBJsonData(com.ss.android.socialbase.downloader.constants.DbJsonConstants.DBJSON_KEY_ALL_CONNECT_TIME, java.lang.Long.valueOf(this.allConnectTime.addAndGet(j)));
        }
    }

    public void increaseCurBytes(long j) {
        this.curBytes.addAndGet(j);
    }

    public void increaseDownloadPrepareTime(long j) {
        if (j > 0) {
            safePutToDBJsonData(com.ss.android.socialbase.downloader.constants.DbJsonConstants.DBJSON_KEY_DOWNLOAD_PREPARE_TIME, java.lang.Long.valueOf(getDownloadPrepareTime() + j));
        }
    }

    public boolean isAddListenerToSameTask() {
        return this.addListenerToSameTask;
    }

    public boolean isAutoInstall() {
        ensureDBJsonData();
        return this.dbJsonData.optInt(com.ss.android.socialbase.downloader.constants.DbJsonConstants.AUTO_INSTALL, 1) == 1;
    }

    public boolean isAutoInstallWithoutNotification() {
        if (this.isAutoInstallWithoutNotification == null) {
            if (!android.text.TextUtils.isEmpty(this.extra)) {
                try {
                    this.isAutoInstallWithoutNotification = java.lang.Boolean.valueOf(new org.json.JSONObject(this.extra).optBoolean(com.ss.android.socialbase.downloader.constants.DownloadConstants.AUTO_INSTALL_WITHOUT_NOTIFICATION, false));
                } catch (org.json.JSONException unused) {
                }
            }
            this.isAutoInstallWithoutNotification = java.lang.Boolean.FALSE;
        }
        return this.isAutoInstallWithoutNotification.booleanValue();
    }

    public boolean isAutoResumed() {
        return this.autoResumed;
    }

    public boolean isBackUpUrlUsed() {
        return this.backUpUrlUsed;
    }

    public boolean isBreakpointAvailable() {
        if (isFileDataValid()) {
            return isChunkBreakpointAvailable();
        }
        return false;
    }

    public boolean isCanResumeFromBreakPointStatus() {
        int status = getStatus();
        return status == 4 || status == 3 || status == -1 || status == 5 || status == 8 || ((status == 1 || status == 2) && getCurBytes() > 0);
    }

    public boolean isChunkBreakpointAvailable() {
        com.ss.android.socialbase.downloader.downloader.IDownloadCache downloadCache;
        if (this.chunkCount > 1 && (downloadCache = com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.getDownloadCache()) != null) {
            java.util.List<com.ss.android.socialbase.downloader.model.DownloadChunk> downloadChunk = downloadCache.getDownloadChunk(getId());
            if (downloadChunk == null || downloadChunk.size() != this.chunkCount) {
                return false;
            }
            long j = 0;
            for (com.ss.android.socialbase.downloader.model.DownloadChunk downloadChunk2 : downloadChunk) {
                if (downloadChunk2 != null) {
                    j += downloadChunk2.getDownloadChunkBytes();
                }
            }
            if (j != getCurBytes()) {
                setCurBytes(j);
            }
        }
        return true;
    }

    public boolean isChunkDowngradeRetryUsed() {
        return this.chunkDowngradeRetryUsed;
    }

    public boolean isChunked() {
        return com.ss.android.socialbase.downloader.utils.DownloadUtils.isChunkedTask(this.totalBytes);
    }

    public boolean isDeleteCacheIfCheckFailed() {
        return this.deleteCacheIfCheckFailed;
    }

    public boolean isDownloadFromReserveWifi() {
        return this.mDownloadFromReserveWifi;
    }

    public boolean isDownloadOverStatus() {
        return com.ss.android.socialbase.downloader.constants.DownloadStatus.isDownloadOver(getStatus());
    }

    public boolean isDownloadWithWifiValid() {
        return !isOnlyWifi() || com.ss.android.socialbase.downloader.utils.DownloadUtils.isWifi(com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.getAppContext());
    }

    public boolean isDownloaded() {
        return com.ss.android.socialbase.downloader.utils.DownloadUtils.isFileDownloaded(this);
    }

    public boolean isDownloadingStatus() {
        return com.ss.android.socialbase.downloader.constants.DownloadStatus.isDownloading(getStatus());
    }

    public boolean isEntityInvalid() {
        return android.text.TextUtils.isEmpty(this.url) || android.text.TextUtils.isEmpty(this.name) || android.text.TextUtils.isEmpty(this.savePath);
    }

    public boolean isExpiredRedownload() {
        if (com.ss.android.socialbase.downloader.setting.DownloadSetting.obtainGlobal().optInt(com.ss.android.socialbase.downloader.setting.DownloadSettingKeys.FORCE_CLOSE_DOWNLOAD_CACHE_CHECK, 0) != 1) {
            return this.expiredRedownload;
        }
        com.ss.android.socialbase.downloader.logger.Logger.w("isExpiredRedownload force to false, reason(global setting) id=" + getId() + " name=" + getName());
        return false;
    }

    public boolean isFileDataExists() {
        if (isEntityInvalid()) {
            return false;
        }
        java.io.File file = new java.io.File(getTempPath(), getTempName());
        return file.exists() && !file.isDirectory();
    }

    public boolean isFileDataValid() {
        if (isEntityInvalid()) {
            return false;
        }
        java.io.File file = new java.io.File(getTempPath(), getTempName());
        boolean exists = file.exists();
        boolean isDirectory = file.isDirectory();
        if (exists && !isDirectory) {
            long length = file.length();
            long curBytes = getCurBytes();
            if (com.ss.android.socialbase.downloader.setting.DownloadSetting.obtainGlobal().optBugFix(com.ss.android.socialbase.downloader.setting.DownloadSettingKeys.BugFix.FIX_FILE_DATA_VALID)) {
                if (curBytes > 0) {
                    long j = this.totalBytes;
                    if (j > 0 && this.chunkCount > 0 && length >= curBytes && length <= j) {
                        return true;
                    }
                }
                com.ss.android.socialbase.downloader.logger.Logger.w(TAG, "isFileDataValid: cur = " + curBytes + ",totalBytes =" + this.totalBytes + ",fileLength=" + length);
                return false;
            }
            if (length > 0 && curBytes > 0) {
                long j2 = this.totalBytes;
                if (j2 > 0 && this.chunkCount > 0 && length >= curBytes && length <= j2 && curBytes < j2) {
                    return true;
                }
            }
            com.ss.android.socialbase.downloader.logger.Logger.w(TAG, "isFileDataValid: cur = " + curBytes + ",totalBytes =" + this.totalBytes + ",fileLength=" + length);
        }
        return false;
    }

    public boolean isFirstDownload() {
        return (!this.isFirstDownload || android.text.TextUtils.isEmpty(getTempPath()) || android.text.TextUtils.isEmpty(getTempName()) || new java.io.File(getTempPath(), getTempName()).exists()) ? false : true;
    }

    public boolean isFirstSuccess() {
        return this.isFirstSuccess;
    }

    public boolean isForbiddenRetryed() {
        return this.isForbiddenRetryed;
    }

    public boolean isForce() {
        return this.force;
    }

    public boolean isForceIgnoreRecommendSize() {
        return this.forceIgnoreRecommendSize;
    }

    public boolean isHeadConnectionAvailable() {
        return this.headConnectionAvailable;
    }

    public boolean isHttpsToHttpRetryUsed() {
        return this.httpsToHttpRetryUsed;
    }

    public boolean isIgnoreDataVerify() {
        return this.ignoreDataVerify;
    }

    public boolean isNeedChunkDowngradeRetry() {
        return this.needChunkDowngradeRetry;
    }

    public boolean isNeedDefaultHttpServiceBackUp() {
        return this.needDefaultHttpServiceBackUp;
    }

    public boolean isNeedHttpsToHttpRetry() {
        return this.needHttpsToHttpRetry;
    }

    public boolean isNeedIndependentProcess() {
        return this.needIndependentProcess;
    }

    public boolean isNeedPostProgress() {
        return this.needPostProgress;
    }

    public boolean isNeedRetryDelay() {
        return false;
    }

    public boolean isNeedReuseChunkRunnable() {
        return this.needReuseChunkRunnable;
    }

    public boolean isNeedReuseFirstConnection() {
        return this.needReuseFirstConnection;
    }

    public boolean isNeedSDKMonitor() {
        return this.needSDKMonitor;
    }

    public boolean isNewTask() {
        return getStatus() == 0;
    }

    public boolean isOnlyWifi() {
        return this.onlyWifi;
    }

    public boolean isPauseReserveOnWifi() {
        return (getReserveWifiStatus() & 2) > 0;
    }

    public boolean isPauseReserveWithWifiValid() {
        if (this.mDownloadFromReserveWifi) {
            return isPauseReserveOnWifi() && com.ss.android.socialbase.downloader.utils.DownloadUtils.isWifi(com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.getAppContext());
        }
        return true;
    }

    public boolean isRwConcurrent() {
        ensureDBJsonData();
        return this.dbJsonData.optInt("rw_concurrent", 0) == 1;
    }

    public boolean isSavePathRedirected() {
        ensureDBJsonData();
        return this.dbJsonData.optBoolean(com.ss.android.socialbase.downloader.constants.DbJsonConstants.DBJSON_KEY_IS_SAVE_PATH_REDIRECTED, false);
    }

    public synchronized boolean isSaveTempFile() {
        return this.isSaveTempFile;
    }

    public boolean isShowNotification() {
        return this.showNotification;
    }

    public boolean isShowNotificationForAutoResumed() {
        return this.showNotificationForAutoResumed;
    }

    public boolean isShowNotificationForNetworkResumed() {
        return this.showNotificationForNetworkResumed;
    }

    public boolean isSuccessByCache() {
        return this.successByCache;
    }

    public boolean isSupportPartial() {
        return this.supportPartial;
    }

    public boolean isWaitingWifiStatus() {
        com.ss.android.socialbase.downloader.exception.BaseException baseException = this.failedException;
        return baseException != null && baseException.getErrorCode() == 1013;
    }

    public void readFromParcel(android.os.Parcel parcel) {
        this.id = parcel.readInt();
        this.name = parcel.readString();
        this.title = parcel.readString();
        this.url = parcel.readString();
        this.savePath = parcel.readString();
        this.tempPath = parcel.readString();
        this.onlyWifi = parcel.readByte() != 0;
        this.extra = parcel.readString();
        this.extraHeaders = parcel.createTypedArrayList(com.ss.android.socialbase.downloader.model.HttpHeader.CREATOR);
        this.maxBytes = parcel.readInt();
        this.outIp = parcel.createStringArray();
        this.outSize = parcel.createIntArray();
        this.retryCount = parcel.readInt();
        this.backUpUrlRetryCount = parcel.readInt();
        this.force = parcel.readByte() != 0;
        this.needPostProgress = parcel.readByte() != 0;
        this.maxProgressCount = parcel.readInt();
        this.minProgressTimeMsInterval = parcel.readInt();
        this.backUpUrls = parcel.createStringArrayList();
        this.showNotification = parcel.readByte() != 0;
        this.mimeType = parcel.readString();
        this.needHttpsToHttpRetry = parcel.readByte() != 0;
        this.packageName = parcel.readString();
        this.md5 = parcel.readString();
        this.needRetryDelay = parcel.readByte() != 0;
        this.needDefaultHttpServiceBackUp = parcel.readByte() != 0;
        this.needReuseChunkRunnable = parcel.readByte() != 0;
        this.retryDelayTimeArray = parcel.readString();
        this.eTag = parcel.readString();
        this.curRetryTime = parcel.readInt();
        convertRetryDelayStatus(parcel.readInt());
        this.needReuseFirstConnection = parcel.readByte() != 0;
        this.forceIgnoreRecommendSize = parcel.readByte() != 0;
        this.networkQuality = parcel.readString();
        this.curBackUpUrlIndex = parcel.readInt();
        this.notificationVisibility = parcel.readInt();
        this.chunkCount = parcel.readInt();
        setCurBytes(parcel.readLong());
        this.totalBytes = parcel.readLong();
        setStatus(parcel.readInt());
        this.downloadTime = parcel.readLong();
        this.realDownloadTime = parcel.readLong();
        this.backUpUrlUsed = parcel.readByte() != 0;
        this.httpsToHttpRetryUsed = parcel.readByte() != 0;
        try {
            java.lang.StringBuffer stringBuffer = this.errorBytesLog;
            if (stringBuffer == null) {
                this.errorBytesLog = new java.lang.StringBuffer(parcel.readString());
            } else {
                stringBuffer.delete(0, stringBuffer.length()).append(parcel.readString());
            }
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
        this.autoResumed = parcel.readByte() != 0;
        this.showNotificationForAutoResumed = parcel.readByte() != 0;
        this.showNotificationForNetworkResumed = parcel.readByte() != 0;
        this.forbiddenBackupUrls = parcel.createStringArrayList();
        this.needIndependentProcess = parcel.readByte() != 0;
        convertEnqueueType(parcel.readInt());
        this.headConnectionAvailable = parcel.readByte() != 0;
        this.httpStatusCode = parcel.readInt();
        this.httpStatusMessage = parcel.readString();
        this.isSaveTempFile = parcel.readByte() != 0;
        this.isForbiddenRetryed = parcel.readByte() != 0;
        this.addListenerToSameTask = parcel.readByte() != 0;
        this.needChunkDowngradeRetry = parcel.readByte() != 0;
        this.chunkDowngradeRetryUsed = parcel.readByte() != 0;
        this.failedException = (com.ss.android.socialbase.downloader.exception.BaseException) parcel.readParcelable(com.ss.android.socialbase.downloader.exception.BaseException.class.getClassLoader());
        this.retryScheduleMinutes = parcel.readInt();
        this.dbJsonDataString = parcel.readString();
        this.supportPartial = parcel.readByte() != 0;
        this.iconUrl = parcel.readString();
        this.appVersionCode = parcel.readInt();
        this.taskId = parcel.readString();
        this.expiredRedownload = parcel.readByte() != 0;
        this.deleteCacheIfCheckFailed = parcel.readByte() != 0;
        this.successByCache = parcel.readByte() != 0;
        parseMonitorSetting();
    }

    public synchronized void registerTempFileSaveCallback(com.ss.android.socialbase.downloader.depend.ITempFileSaveCompleteCallback iTempFileSaveCompleteCallback) {
        if (iTempFileSaveCompleteCallback == null) {
            return;
        }
        try {
            com.ss.android.socialbase.downloader.logger.Logger.d(TAG, "registerTempFileSaveCallback");
            if (this.tempFileSaveCompleteCallbacks == null) {
                this.tempFileSaveCompleteCallbacks = new java.util.ArrayList();
            }
            if (!this.tempFileSaveCompleteCallbacks.contains(iTempFileSaveCompleteCallback)) {
                this.tempFileSaveCompleteCallbacks.add(iTempFileSaveCompleteCallback);
            }
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            iTempFileSaveCompleteCallback.onFailed(new com.ss.android.socialbase.downloader.exception.BaseException(com.ss.android.socialbase.downloader.constants.DownloadErrorCode.ERROR_TEMP_TO_TARGET_FAILED, com.ss.android.socialbase.downloader.utils.DownloadUtils.getErrorMsgWithTagPrefix(th, "registerTempFileSaveCallback")));
        }
    }

    public void reset() {
        setCurBytes(0L, true);
        this.totalBytes = 0L;
        this.chunkCount = 1;
        this.downloadTime = 0L;
        this.realStartDownloadTime = 0L;
        this.realDownloadTime = 0L;
    }

    public void resetDataForEtagEndure(java.lang.String str) {
        setCurBytes(0L, true);
        setTotalBytes(0L);
        seteTag(str);
        setChunkCount(1);
        this.downloadTime = 0L;
        this.realStartDownloadTime = 0L;
        this.realDownloadTime = 0L;
    }

    public void resetRealStartDownloadTime() {
        this.realStartDownloadTime = 0L;
    }

    public void safePutToDBJsonData(java.lang.String str, java.lang.Object obj) {
        ensureDBJsonData();
        synchronized (this.dbJsonData) {
            try {
                this.dbJsonData.put(str, obj);
            } catch (java.lang.Exception unused) {
            }
            this.dbJsonDataString = null;
        }
    }

    public void setAddListenerToSameTask(boolean z) {
        this.addListenerToSameTask = z;
    }

    public void setAntiHijackErrorCode(int i) {
        safePutToDBJsonData(com.ss.android.socialbase.downloader.constants.DbJsonConstants.DBJSON_KEY_ANTI_HIJACK_ERROR_CODE, java.lang.Integer.valueOf(i));
    }

    public void setAppVersionCode(int i) {
        this.appVersionCode = i;
    }

    public void setAsyncHandleStatus(com.ss.android.socialbase.downloader.constants.AsyncHandleStatus asyncHandleStatus) {
        this.asyncHandleStatus = asyncHandleStatus;
    }

    public void setAutoResumed(boolean z) {
        this.autoResumed = z;
    }

    public void setByteInvalidRetryStatus(com.ss.android.socialbase.downloader.constants.ByteInvalidRetryStatus byteInvalidRetryStatus) {
        this.byteInvalidRetryStatus = byteInvalidRetryStatus;
    }

    public void setCacheControl(java.lang.String str) {
        ensureSpData();
        try {
            this.spData.put(com.ss.android.socialbase.downloader.constants.SpJsonConstants.CACHE_CONTROL, str);
            updateSpData();
        } catch (java.lang.Exception unused) {
        }
    }

    public void setCacheExpiredTime(long j) {
        ensureSpData();
        try {
            this.spData.put(com.ss.android.socialbase.downloader.constants.SpJsonConstants.CACHE_CONTROL_EXPIRED_TIME, j);
            updateSpData();
        } catch (java.lang.Exception unused) {
        }
    }

    public void setChunkCount(int i) {
        this.chunkCount = i;
    }

    public void setChunkDowngradeRetryUsed(boolean z) {
        this.chunkDowngradeRetryUsed = z;
    }

    public void setCurBytes(long j) {
        java.util.concurrent.atomic.AtomicLong atomicLong = this.curBytes;
        if (atomicLong != null) {
            atomicLong.set(j);
        } else {
            this.curBytes = new java.util.concurrent.atomic.AtomicLong(j);
        }
    }

    public void setCurBytes(long j, boolean z) {
        if (z) {
            setCurBytes(j);
        } else if (j > getCurBytes()) {
            setCurBytes(j);
        }
    }

    public void setDeleteCacheIfCheckFailed() {
        this.deleteCacheIfCheckFailed = true;
    }

    public void setDownloadFromReserveWifi(boolean z) {
        this.mDownloadFromReserveWifi = z;
    }

    public void setDownloadTime(long j) {
        if (j >= 0) {
            this.downloadTime = j;
        }
    }

    public void setExtra(java.lang.String str) {
        this.extra = str;
    }

    public void setFailedException(com.ss.android.socialbase.downloader.exception.BaseException baseException) {
        this.failedException = baseException;
    }

    public void setFailedResumeCount(int i) {
        ensureSpData();
        try {
            this.spData.put("failed_resume_count", i);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    public void setFilePackageName(java.lang.String str) {
        this.filePackageName = str;
    }

    public void setFirstDownload(boolean z) {
        this.isFirstDownload = z;
    }

    public void setFirstSpeedTime(long j) {
        safePutToDBJsonData(com.ss.android.socialbase.downloader.constants.DbJsonConstants.DBJSON_KEY_FIRST_SPEED_TIME, java.lang.Long.valueOf(j));
    }

    public void setFirstSuccess(boolean z) {
        this.isFirstSuccess = z;
    }

    public void setForbiddenBackupUrls(java.util.List<java.lang.String> list, boolean z) {
        this.forbiddenBackupUrls = list;
        refreshBackupUrls(z);
    }

    public void setForbiddenRetryed() {
        this.isForbiddenRetryed = true;
    }

    public void setForceIgnoreRecommendSize(boolean z) {
        this.forceIgnoreRecommendSize = z;
    }

    public void setHeadConnectionException(java.lang.String str) {
        this.headConnectionException = str;
    }

    public void setHttpStatusCode(int i) {
        this.httpStatusCode = i;
    }

    public void setHttpStatusMessage(java.lang.String str) {
        this.httpStatusMessage = str;
    }

    public void setHttpsToHttpRetryUsed(boolean z) {
        this.httpsToHttpRetryUsed = z;
    }

    public void setIconUrl(java.lang.String str) {
        this.iconUrl = str;
    }

    public void setId(int i) {
        this.id = i;
    }

    public void setIsRwConcurrent(boolean z) {
        safePutToDBJsonData("rw_concurrent", java.lang.Integer.valueOf(z ? 1 : 0));
    }

    public synchronized void setIsSaveTempFile(boolean z) {
        this.isSaveTempFile = z;
    }

    public void setLastFailedResumeTime(long j) {
        ensureSpData();
        try {
            this.spData.put(com.ss.android.socialbase.downloader.constants.SpJsonConstants.KEY_LAST_FAILED_RESUME_TIME, j);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    public void setLastModified(java.lang.String str) {
        ensureSpData();
        try {
            this.spData.put("last-modified", str);
            updateSpData();
        } catch (java.lang.Exception unused) {
        }
    }

    public void setLastNotifyProgressTime() {
        this.lastNotifyProgressTime.set(android.os.SystemClock.uptimeMillis());
    }

    public void setLastUninstallResumeTime(long j) {
        ensureSpData();
        try {
            this.spData.put(com.ss.android.socialbase.downloader.constants.SpJsonConstants.KEY_LAST_UNINSTALL_RESUME_TIME, j);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    public void setLinkMode(int i) {
        safePutToDBJsonData(com.ss.android.socialbase.downloader.constants.DbJsonConstants.DBJSON_KEY_LINK_MODE, java.lang.Integer.valueOf(i));
    }

    public void setMd5(java.lang.String str) {
        this.md5 = str;
    }

    public void setMimeType(java.lang.String str) {
        this.mimeType = str;
    }

    public void setName(java.lang.String str) {
        this.name = str;
    }

    public void setNetworkQuality(java.lang.String str) {
        this.networkQuality = str;
    }

    public void setNotificationVisibility(int i) {
        this.notificationVisibility = i;
    }

    public void setOnlyWifi(boolean z) {
        this.onlyWifi = z;
    }

    public void setOpenLimitSpeed(boolean z) {
        this.openLimitSpeed = z;
    }

    public void setPackageInfo(android.content.pm.PackageInfo packageInfo) {
        this.packageInfoRef = new java.lang.ref.SoftReference<>(packageInfo);
    }

    public void setPackageName(java.lang.String str) {
        this.packageName = str;
    }

    public void setPausedResumeCount(int i) {
        ensureSpData();
        try {
            this.spData.put(com.ss.android.socialbase.downloader.constants.DownloadConstants.KEY_PAUSED_RESUME_COUNT, i);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    public void setPreconnectLevel(int i) {
        ensureDBJsonData();
        safePutToDBJsonData(com.ss.android.socialbase.downloader.constants.DbJsonConstants.DBJSON_KEY_PRECONNECT_LEVEL, java.lang.Integer.valueOf(i));
    }

    public void setRetryDelayStatus(com.ss.android.socialbase.downloader.constants.RetryDelayStatus retryDelayStatus) {
        this.retryDelayStatus = retryDelayStatus;
    }

    public void setRetryScheduleCount(int i) {
        safePutToDBJsonData("retry_schedule_count", java.lang.Integer.valueOf(i));
    }

    public void setSavePath(java.lang.String str) {
        this.savePath = str;
    }

    public void setSavePathRedirected(boolean z) {
        safePutToDBJsonData(com.ss.android.socialbase.downloader.constants.DbJsonConstants.DBJSON_KEY_IS_SAVE_PATH_REDIRECTED, java.lang.Boolean.valueOf(z));
    }

    public void setShowNotification(boolean z) {
        this.showNotification = z;
    }

    public void setShowNotificationForAutoResumed(boolean z) {
        this.showNotificationForAutoResumed = z;
    }

    public void setShowNotificationForNetworkResumed(boolean z) {
        this.showNotificationForNetworkResumed = z;
    }

    public void setSpValue(java.lang.String str, java.lang.String str2) {
        ensureSpData();
        try {
            this.spData.put(str, str2);
            updateSpData();
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    public void setStatus(int i) {
        java.util.concurrent.atomic.AtomicInteger atomicInteger = this.status;
        if (atomicInteger != null) {
            atomicInteger.set(i);
        } else {
            this.status = new java.util.concurrent.atomic.AtomicInteger(i);
        }
    }

    public void setStatusAtDbInit(int i) {
        this.statusAtDbInit = i;
    }

    public void setSuccessByCache(boolean z) {
        this.successByCache = z;
    }

    public void setSupportPartial(boolean z) {
        this.supportPartial = z;
    }

    public void setTTMd5CheckStatus(int i) {
        safePutToDBJsonData(com.ss.android.socialbase.downloader.constants.DbJsonConstants.DBJSON_KEY_TTMD5_CHECK_STATUS, java.lang.Integer.valueOf(i));
    }

    public void setThrottleNetSpeed(long j) {
        this.throttleNetSpeed = j;
    }

    public void setTotalBytes(long j) {
        this.totalBytes = j;
    }

    public void setUninstallResumeCount(int i) {
        ensureSpData();
        try {
            this.spData.put(com.ss.android.socialbase.downloader.constants.SpJsonConstants.KEY_UNINSTALL_RESUME_COUNT, i);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    public void setUrl(java.lang.String str) {
        this.url = str;
    }

    public void seteTag(java.lang.String str) {
        this.eTag = str;
    }

    public void startPauseReserveOnWifi() {
        ensureSpData();
        try {
            this.spData.put("pause_reserve_on_wifi", 3);
            updateSpData();
        } catch (java.lang.Exception unused) {
        }
    }

    public boolean statusInPause() {
        return getRealStatus() == -2 || getRealStatus() == -5;
    }

    public void stopPauseReserveOnWifi() {
        ensureSpData();
        try {
            this.spData.put("pause_reserve_on_wifi", 1);
            updateSpData();
        } catch (java.lang.Exception unused) {
        }
    }

    public android.content.ContentValues toContentValues() {
        android.content.ContentValues contentValues = new android.content.ContentValues();
        contentValues.put("_id", java.lang.Integer.valueOf(this.id));
        contentValues.put("url", this.url);
        contentValues.put(com.ss.android.socialbase.downloader.constants.DBDefinition.SAVE_PATH, this.savePath);
        contentValues.put(com.ss.android.socialbase.downloader.constants.DBDefinition.TEMP_PATH, this.tempPath);
        contentValues.put("name", this.name);
        contentValues.put(com.ss.android.socialbase.downloader.constants.DBDefinition.CHUNK_COUNT, java.lang.Integer.valueOf(this.chunkCount));
        contentValues.put("status", java.lang.Integer.valueOf(getStatus()));
        contentValues.put(com.ss.android.socialbase.downloader.constants.DBDefinition.CUR_BYTES, java.lang.Long.valueOf(getCurBytes()));
        contentValues.put(com.ss.android.socialbase.downloader.constants.DBDefinition.TOTAL_BYTES, java.lang.Long.valueOf(this.totalBytes));
        contentValues.put(com.ss.android.socialbase.downloader.constants.DBDefinition.ETAG, this.eTag);
        contentValues.put(com.ss.android.socialbase.downloader.constants.DBDefinition.ONLY_WIFI, java.lang.Integer.valueOf(this.onlyWifi ? 1 : 0));
        contentValues.put("force", java.lang.Integer.valueOf(this.force ? 1 : 0));
        contentValues.put(com.ss.android.socialbase.downloader.constants.DBDefinition.RETRY_COUNT, java.lang.Integer.valueOf(this.retryCount));
        contentValues.put("extra", this.extra);
        contentValues.put("mimeType", this.mimeType);
        contentValues.put("title", this.title);
        contentValues.put(com.ss.android.socialbase.downloader.constants.DBDefinition.NOTIFICATION_ENABLE, java.lang.Integer.valueOf(this.showNotification ? 1 : 0));
        contentValues.put(com.ss.android.socialbase.downloader.constants.DBDefinition.NOTIFICATION_VISIBILITY, java.lang.Integer.valueOf(this.notificationVisibility));
        contentValues.put(com.ss.android.socialbase.downloader.constants.DBDefinition.FIRST_DOWNLOAD, java.lang.Integer.valueOf(this.isFirstDownload ? 1 : 0));
        contentValues.put(com.ss.android.socialbase.downloader.constants.DBDefinition.FIRST_SUCCESS, java.lang.Integer.valueOf(this.isFirstSuccess ? 1 : 0));
        contentValues.put(com.ss.android.socialbase.downloader.constants.DBDefinition.NEED_HTTPS_TO_HTTP_RETRY, java.lang.Integer.valueOf(this.needHttpsToHttpRetry ? 1 : 0));
        contentValues.put(com.ss.android.socialbase.downloader.constants.DBDefinition.DOWNLOAD_TIME, java.lang.Long.valueOf(this.downloadTime));
        contentValues.put("packageName", this.packageName);
        contentValues.put("md5", this.md5);
        contentValues.put(com.ss.android.socialbase.downloader.constants.DBDefinition.RETRY_DELAY, java.lang.Integer.valueOf(this.needRetryDelay ? 1 : 0));
        contentValues.put(com.ss.android.socialbase.downloader.constants.DBDefinition.CUR_RETRY_TIME, java.lang.Integer.valueOf(this.curRetryTime));
        contentValues.put(com.ss.android.socialbase.downloader.constants.DBDefinition.RETRY_DELAY_STATUS, java.lang.Integer.valueOf(this.retryDelayStatus.ordinal()));
        contentValues.put(com.ss.android.socialbase.downloader.constants.DBDefinition.DEFAULT_HTTP_SERVICE_BACKUP, java.lang.Integer.valueOf(this.needDefaultHttpServiceBackUp ? 1 : 0));
        contentValues.put(com.ss.android.socialbase.downloader.constants.DBDefinition.CHUNK_RUNNABLE_REUSE, java.lang.Integer.valueOf(this.needReuseChunkRunnable ? 1 : 0));
        contentValues.put(com.ss.android.socialbase.downloader.constants.DBDefinition.RETRY_DELAY_TIME_ARRAY, this.retryDelayTimeArray);
        contentValues.put(com.ss.android.socialbase.downloader.constants.DBDefinition.CHUNK_DOWNGRADE_RETRY, java.lang.Integer.valueOf(this.needChunkDowngradeRetry ? 1 : 0));
        contentValues.put(com.ss.android.socialbase.downloader.constants.DBDefinition.BACKUP_URLS_STR, getBackUpUrlsStr());
        contentValues.put(com.ss.android.socialbase.downloader.constants.DBDefinition.BACKUP_URL_RETRY_COUNT, java.lang.Integer.valueOf(this.backUpUrlRetryCount));
        contentValues.put(com.ss.android.socialbase.downloader.constants.DBDefinition.REAL_DOWNLOAD_TIME, java.lang.Long.valueOf(this.realDownloadTime));
        contentValues.put(com.ss.android.socialbase.downloader.constants.DBDefinition.RETRY_SCHEDULE_MINUTES, java.lang.Integer.valueOf(this.retryScheduleMinutes));
        contentValues.put(com.ss.android.socialbase.downloader.constants.DBDefinition.INDEPENDENT_PROCESS, java.lang.Integer.valueOf(this.needIndependentProcess ? 1 : 0));
        contentValues.put(com.ss.android.socialbase.downloader.constants.DBDefinition.AUXILIARY_JSONOBJECT_STRING, getDBJsonDataString());
        contentValues.put(com.ss.android.socialbase.downloader.constants.DBDefinition.ICON_URL, this.iconUrl);
        contentValues.put(com.ss.android.socialbase.downloader.constants.DBDefinition.APP_VERSION_CODE, java.lang.Integer.valueOf(this.appVersionCode));
        contentValues.put(com.ss.android.socialbase.downloader.constants.DBDefinition.TASK_ID, this.taskId);
        return contentValues;
    }

    public java.lang.String toString() {
        return "DownloadInfo{id=" + this.id + ", name='" + this.name + "', title='" + this.title + "', url='" + this.url + "', savePath='" + this.savePath + "'}";
    }

    public boolean trySwitchToNextBackupUrl() {
        if (this.backUpUrlUsed) {
            this.curBackUpUrlIndex++;
        }
        java.util.List<java.lang.String> list = this.backUpUrls;
        if (list != null && list.size() != 0 && this.curBackUpUrlIndex >= 0) {
            while (this.curBackUpUrlIndex < this.backUpUrls.size()) {
                if (!android.text.TextUtils.isEmpty(this.backUpUrls.get(this.curBackUpUrlIndex))) {
                    this.backUpUrlUsed = true;
                    return true;
                }
                this.curBackUpUrlIndex++;
            }
        }
        return false;
    }

    public void updateCurRetryTime(int i) {
        int i2 = (this.backUpUrlUsed ? this.backUpUrlRetryCount : this.retryCount) - i;
        this.curRetryTime = i2;
        if (i2 < 0) {
            this.curRetryTime = 0;
        }
    }

    public void updateDownloadTime() {
        if (this.startDownloadTime == 0) {
            return;
        }
        long uptimeMillis = android.os.SystemClock.uptimeMillis() - this.startDownloadTime;
        if (this.downloadTime < 0) {
            this.downloadTime = 0L;
        }
        if (uptimeMillis > 0) {
            this.downloadTime = uptimeMillis;
        }
    }

    public void updateRealDownloadTime(boolean z) {
        long nanoTime = java.lang.System.nanoTime();
        long j = this.realStartDownloadTime;
        if (j <= 0) {
            if (z) {
                this.realStartDownloadTime = nanoTime;
                return;
            }
            return;
        }
        long j2 = nanoTime - j;
        if (z) {
            this.realStartDownloadTime = nanoTime;
        } else {
            this.realStartDownloadTime = 0L;
        }
        if (j2 > 0) {
            this.realDownloadTime += j2;
        }
    }

    public void updateRealStartDownloadTime() {
        if (this.realStartDownloadTime == 0) {
            this.realStartDownloadTime = java.lang.System.nanoTime();
        }
    }

    public void updateSpData() {
        android.content.Context appContext;
        if (this.spData == null || (appContext = com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.getAppContext()) == null) {
            return;
        }
        appContext.getSharedPreferences(com.ss.android.socialbase.downloader.constants.DownloadConstants.SP_DOWNLOAD_INFO, 0).edit().putString(java.lang.Integer.toString(getId()), this.spData.toString()).apply();
    }

    public void updateStartDownloadTime() {
        this.startDownloadTime = android.os.SystemClock.uptimeMillis();
        safePutToDBJsonData(com.ss.android.socialbase.downloader.constants.DbJsonConstants.DBJSON_KEY_LAST_START_DOWNLOAD_TIME, java.lang.Long.valueOf(java.lang.System.currentTimeMillis()));
    }

    @Override // android.os.Parcelable
    public void writeToParcel(android.os.Parcel parcel, int i) {
        parcel.writeInt(this.id);
        parcel.writeString(this.name);
        parcel.writeString(this.title);
        parcel.writeString(this.url);
        parcel.writeString(this.savePath);
        parcel.writeString(this.tempPath);
        parcel.writeByte(this.onlyWifi ? (byte) 1 : (byte) 0);
        parcel.writeString(this.extra);
        parcel.writeTypedList(this.extraHeaders);
        parcel.writeInt(this.maxBytes);
        parcel.writeStringArray(this.outIp);
        parcel.writeIntArray(this.outSize);
        parcel.writeInt(this.retryCount);
        parcel.writeInt(this.backUpUrlRetryCount);
        parcel.writeByte(this.force ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.needPostProgress ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.maxProgressCount);
        parcel.writeInt(this.minProgressTimeMsInterval);
        parcel.writeStringList(this.backUpUrls);
        parcel.writeByte(this.showNotification ? (byte) 1 : (byte) 0);
        parcel.writeString(this.mimeType);
        parcel.writeByte(this.needHttpsToHttpRetry ? (byte) 1 : (byte) 0);
        parcel.writeString(this.packageName);
        parcel.writeString(this.md5);
        parcel.writeByte(this.needRetryDelay ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.needDefaultHttpServiceBackUp ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.needReuseChunkRunnable ? (byte) 1 : (byte) 0);
        parcel.writeString(this.retryDelayTimeArray);
        parcel.writeString(this.eTag);
        parcel.writeInt(this.curRetryTime);
        parcel.writeInt(this.retryDelayStatus.ordinal());
        parcel.writeByte(this.needReuseFirstConnection ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.forceIgnoreRecommendSize ? (byte) 1 : (byte) 0);
        parcel.writeString(this.networkQuality);
        parcel.writeInt(this.curBackUpUrlIndex);
        parcel.writeInt(this.notificationVisibility);
        parcel.writeInt(this.chunkCount);
        parcel.writeLong(getCurBytes());
        parcel.writeLong(this.totalBytes);
        parcel.writeInt(getRealStatus());
        parcel.writeLong(this.downloadTime);
        parcel.writeLong(this.realDownloadTime);
        parcel.writeByte(this.backUpUrlUsed ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.httpsToHttpRetryUsed ? (byte) 1 : (byte) 0);
        java.lang.StringBuffer stringBuffer = this.errorBytesLog;
        parcel.writeString(stringBuffer != null ? stringBuffer.toString() : "");
        parcel.writeByte(this.autoResumed ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.showNotificationForAutoResumed ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.showNotificationForNetworkResumed ? (byte) 1 : (byte) 0);
        parcel.writeStringList(this.forbiddenBackupUrls);
        parcel.writeByte(this.needIndependentProcess ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.enqueueType.ordinal());
        parcel.writeByte(this.headConnectionAvailable ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.httpStatusCode);
        parcel.writeString(this.httpStatusMessage);
        parcel.writeByte(this.isSaveTempFile ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.isForbiddenRetryed ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.addListenerToSameTask ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.needChunkDowngradeRetry ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.chunkDowngradeRetryUsed ? (byte) 1 : (byte) 0);
        parcel.writeParcelable(this.failedException, i);
        parcel.writeInt(this.retryScheduleMinutes);
        parcel.writeString(getDBJsonDataString());
        parcel.writeByte(this.supportPartial ? (byte) 1 : (byte) 0);
        parcel.writeString(this.iconUrl);
        parcel.writeInt(this.appVersionCode);
        parcel.writeString(this.taskId);
        parcel.writeByte(this.expiredRedownload ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.deleteCacheIfCheckFailed ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.successByCache ? (byte) 1 : (byte) 0);
    }
}
