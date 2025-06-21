package com.ss.android.socialbase.downloader.downloader;

/* loaded from: classes19.dex */
public class DownloadStatusHandler {
    private static final java.lang.String TAG = "DownloadStatusHandler";
    private final com.ss.android.socialbase.downloader.downloader.IDownloadCache downloadCache;
    private com.ss.android.socialbase.downloader.depend.IDownloadDepend downloadDepend;
    private com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo;
    private com.ss.android.socialbase.downloader.depend.IDownloadMonitorDepend downloadMonitorDepend;
    private com.ss.android.socialbase.downloader.model.DownloadTask downloadTask;
    private final boolean fixStartWithFileExistUpdateError;
    private final android.os.Handler mainThreadHandler;
    private android.util.SparseArray<com.ss.android.socialbase.downloader.depend.IDownloadListener> mainThreadListeners;
    private long minByteIntervalForSyncProgress;
    private int minTimeIntervalForSyncProgress;
    private android.util.SparseArray<com.ss.android.socialbase.downloader.depend.IDownloadListener> notificationListeners;
    private android.util.SparseArray<com.ss.android.socialbase.downloader.depend.IDownloadListener> subThreadListeners;
    private boolean forceRefreshProcess = false;
    private volatile long lastSyncProgressTime = 0;
    private final java.util.concurrent.atomic.AtomicLong msgPostDataBuffer = new java.util.concurrent.atomic.AtomicLong();
    private boolean hasSyncProgressBefore = false;

    /* renamed from: com.ss.android.socialbase.downloader.downloader.DownloadStatusHandler$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {
        public AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public void run() {
            com.ss.android.socialbase.downloader.downloader.DownloadStatusHandler.this.downloadCache.OnDownloadTaskPrepare(com.ss.android.socialbase.downloader.downloader.DownloadStatusHandler.this.downloadInfo.getId());
            com.ss.android.socialbase.downloader.downloader.DownloadStatusHandler.this.onStatusChanged(1, null);
        }
    }

    /* renamed from: com.ss.android.socialbase.downloader.downloader.DownloadStatusHandler$2, reason: invalid class name */
    public class AnonymousClass2 implements com.ss.android.socialbase.downloader.depend.ITempFileSaveCompleteCallback {
        public AnonymousClass2() {
        }

        @Override // com.ss.android.socialbase.downloader.depend.ITempFileSaveCompleteCallback
        public void onFailed(com.ss.android.socialbase.downloader.exception.BaseException baseException) {
            java.lang.String str = com.ss.android.socialbase.downloader.downloader.DownloadStatusHandler.TAG;
            java.lang.StringBuilder sb = new java.lang.StringBuilder("saveFileAsTargetName onFailed : ");
            sb.append(baseException != null ? baseException.getErrorMessage() : "");
            com.ss.android.socialbase.downloader.logger.Logger.d(str, sb.toString());
            com.ss.android.socialbase.downloader.downloader.DownloadStatusHandler.this.onError(baseException);
        }

        @Override // com.ss.android.socialbase.downloader.depend.ITempFileSaveCompleteCallback
        public void onSuccess() {
            com.ss.android.socialbase.downloader.downloader.DownloadStatusHandler.this.onSaveTempFileSuccess();
        }
    }

    public DownloadStatusHandler(com.ss.android.socialbase.downloader.model.DownloadTask downloadTask, android.os.Handler handler) {
        this.downloadTask = downloadTask;
        checkInit();
        this.mainThreadHandler = handler;
        this.downloadCache = com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.getDownloadCache();
        com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo = downloadTask.getDownloadInfo();
        if (downloadInfo != null) {
            this.fixStartWithFileExistUpdateError = com.ss.android.socialbase.downloader.setting.DownloadSetting.obtain(downloadInfo.getId()).optBugFix(com.ss.android.socialbase.downloader.setting.DownloadSettingKeys.BugFix.BUGFIX_FIX_START_WITH_FILE_EXIST_UPDATE_ERROR);
        } else {
            this.fixStartWithFileExistUpdateError = false;
        }
    }

    private void checkInit() {
        com.ss.android.socialbase.downloader.model.DownloadTask downloadTask = this.downloadTask;
        if (downloadTask != null) {
            this.downloadInfo = downloadTask.getDownloadInfo();
            this.mainThreadListeners = this.downloadTask.getDownloadListeners(com.ss.android.socialbase.downloader.constants.ListenerType.MAIN);
            this.notificationListeners = this.downloadTask.getDownloadListeners(com.ss.android.socialbase.downloader.constants.ListenerType.NOTIFICATION);
            this.subThreadListeners = this.downloadTask.getDownloadListeners(com.ss.android.socialbase.downloader.constants.ListenerType.SUB);
            this.downloadDepend = this.downloadTask.getDepend();
            this.downloadMonitorDepend = this.downloadTask.getMonitorDepend();
        }
    }

    private void downloadCompleteProcess() throws com.ss.android.socialbase.downloader.exception.BaseException {
        java.util.List<com.ss.android.socialbase.downloader.depend.IDownloadCompleteHandler> downloadCompleteHandlers = this.downloadTask.getDownloadCompleteHandlers();
        if (downloadCompleteHandlers.isEmpty()) {
            return;
        }
        com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo = this.downloadInfo;
        onStatusChanged(11, null);
        this.downloadCache.updateDownloadInfo(downloadInfo);
        for (com.ss.android.socialbase.downloader.depend.IDownloadCompleteHandler iDownloadCompleteHandler : downloadCompleteHandlers) {
            try {
                if (iDownloadCompleteHandler.needHandle(downloadInfo)) {
                    iDownloadCompleteHandler.handle(downloadInfo);
                    this.downloadCache.updateDownloadInfo(downloadInfo);
                }
            } catch (com.ss.android.socialbase.downloader.exception.BaseException e) {
                throw e;
            } catch (java.lang.Throwable th) {
                throw new com.ss.android.socialbase.downloader.exception.BaseException(com.ss.android.socialbase.downloader.constants.DownloadErrorCode.ERROR_DOWNLOAD_COMPLETE_HANDLER, th);
            }
        }
    }

    private void handleError(com.ss.android.socialbase.downloader.exception.BaseException baseException) {
        android.util.Log.getStackTraceString(new java.lang.Throwable());
        if (baseException == null || baseException.getCause() == null || !(baseException.getCause() instanceof android.database.sqlite.SQLiteFullException)) {
            try {
                try {
                    this.downloadCache.OnDownloadTaskError(this.downloadInfo.getId(), this.downloadInfo.getCurBytes());
                } catch (android.database.sqlite.SQLiteException e) {
                    e.printStackTrace();
                }
            } catch (android.database.sqlite.SQLiteException unused) {
                this.downloadCache.removeDownloadTaskData(this.downloadInfo.getId());
            }
        } else {
            try {
                this.downloadCache.removeDownloadTaskData(this.downloadInfo.getId());
            } catch (android.database.sqlite.SQLiteException e2) {
                e2.printStackTrace();
            }
        }
        com.ss.android.socialbase.downloader.exception.BaseException reviseFailedException = reviseFailedException(baseException);
        this.downloadInfo.setFailedException(reviseFailedException);
        onStatusChanged(reviseFailedException instanceof com.ss.android.socialbase.downloader.exception.DownloadPauseReserveWifiException ? -2 : -1, reviseFailedException);
        if (com.ss.android.socialbase.downloader.setting.DownloadSetting.obtain(this.downloadInfo.getId()).optInt(com.ss.android.socialbase.downloader.setting.DownloadSettingKeys.RETRY_SCHEDULE, 0) > 0) {
            com.ss.android.socialbase.downloader.impls.RetryScheduler.getInstance().tryStartScheduleRetry(this.downloadInfo);
        }
    }

    private void handlePrepare() {
        java.util.concurrent.ExecutorService cPUThreadExecutor = com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.getCPUThreadExecutor();
        if (cPUThreadExecutor != null) {
            cPUThreadExecutor.execute(new com.ss.android.socialbase.downloader.downloader.DownloadStatusHandler.AnonymousClass1());
        }
    }

    private boolean handleProgress(long j, boolean z) {
        boolean z2 = false;
        if (this.downloadInfo.getCurBytes() == this.downloadInfo.getTotalBytes()) {
            try {
                this.downloadCache.OnDownloadTaskProgress(this.downloadInfo.getId(), this.downloadInfo.getCurBytes());
            } catch (java.lang.Exception e) {
                e.printStackTrace();
            }
            return false;
        }
        if (this.forceRefreshProcess) {
            this.forceRefreshProcess = false;
            this.downloadInfo.setStatus(4);
        }
        if (this.downloadInfo.isNeedPostProgress() && z) {
            z2 = true;
        }
        onStatusChanged(4, null, z2);
        return z;
    }

    private void handleRetry(com.ss.android.socialbase.downloader.exception.BaseException baseException, boolean z) {
        this.downloadCache.OnDownloadTaskRetry(this.downloadInfo.getId());
        onStatusChanged(z ? 7 : 5, baseException);
    }

    private boolean needSyncProgress(long j) {
        boolean z = true;
        if (!this.hasSyncProgressBefore) {
            this.hasSyncProgressBefore = true;
            return true;
        }
        long j2 = j - this.lastSyncProgressTime;
        if (this.msgPostDataBuffer.get() < this.minByteIntervalForSyncProgress && j2 < this.minTimeIntervalForSyncProgress) {
            z = false;
        }
        if (z) {
            this.lastSyncProgressTime = j;
            this.msgPostDataBuffer.set(0L);
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onSaveTempFileSuccess() {
        try {
            com.ss.android.socialbase.downloader.logger.Logger.d(TAG, "saveFileAsTargetName onSuccess");
            try {
                downloadCompleteProcess();
                this.downloadInfo.setFirstSuccess(false);
                this.downloadInfo.setSuccessByCache(false);
                onStatusChanged(-3, null);
                this.downloadCache.OnDownloadTaskCompleted(this.downloadInfo.getId(), this.downloadInfo.getTotalBytes());
                this.downloadCache.removeAllDownloadChunk(this.downloadInfo.getId());
                this.downloadCache.removeSegments(this.downloadInfo.getId());
            } catch (com.ss.android.socialbase.downloader.exception.BaseException e) {
                onError(e);
            }
        } catch (java.lang.Throwable th) {
            onError(new com.ss.android.socialbase.downloader.exception.BaseException(1008, com.ss.android.socialbase.downloader.utils.DownloadUtils.getErrorMsgWithTagPrefix(th, "onCompleted")));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onStatusChanged(int i, com.ss.android.socialbase.downloader.exception.BaseException baseException) {
        onStatusChanged(i, baseException, true);
    }

    private void onStatusChanged(int i, com.ss.android.socialbase.downloader.exception.BaseException baseException, boolean z) {
        android.util.SparseArray<com.ss.android.socialbase.downloader.depend.IDownloadListener> sparseArray;
        android.util.SparseArray<com.ss.android.socialbase.downloader.depend.IDownloadListener> sparseArray2;
        int status = this.downloadInfo.getStatus();
        if (status == -3 && i == 4) {
            return;
        }
        checkInit();
        if (i != 4 && com.ss.android.socialbase.downloader.constants.DownloadStatus.isRealTimeUploadStatus(i)) {
            this.downloadInfo.updateRealDownloadTime(false);
            if (com.ss.android.socialbase.downloader.constants.DownloadStatus.isTimeUploadStatus(i)) {
                this.downloadInfo.updateDownloadTime();
            }
        }
        if (!this.downloadInfo.isAddListenerToSameTask()) {
            com.ss.android.socialbase.downloader.monitor.DownloadMonitorHelper.monitorSend(this.downloadTask, baseException, i);
        }
        if (i == 6) {
            this.downloadInfo.setStatus(2);
        } else if (i == -6) {
            this.downloadInfo.setStatus(-3);
        } else {
            this.downloadInfo.setStatus(i);
        }
        if (status == -3 || status == -1) {
            if (this.downloadInfo.getRetryDelayStatus() == com.ss.android.socialbase.downloader.constants.RetryDelayStatus.DELAY_RETRY_DOWNLOADING) {
                this.downloadInfo.setRetryDelayStatus(com.ss.android.socialbase.downloader.constants.RetryDelayStatus.DELAY_RETRY_DOWNLOADED);
            }
            if (this.downloadInfo.getAsyncHandleStatus() == com.ss.android.socialbase.downloader.constants.AsyncHandleStatus.ASYNC_HANDLE_DOWNLOADING) {
                this.downloadInfo.setAsyncHandleStatus(com.ss.android.socialbase.downloader.constants.AsyncHandleStatus.ASYNC_HANDLE_DOWNLOADED);
            }
            if (this.downloadInfo.getByteInvalidRetryStatus() == com.ss.android.socialbase.downloader.constants.ByteInvalidRetryStatus.BYTE_INVALID_RETRY_STATUS_DOWNLOADING) {
                this.downloadInfo.setByteInvalidRetryStatus(com.ss.android.socialbase.downloader.constants.ByteInvalidRetryStatus.BYTE_INVALID_RETRY_STATUS_DOWNLOADED);
            }
        }
        com.ss.android.socialbase.downloader.utils.DownloadListenerUtils.notifyListener(i, this.subThreadListeners, true, this.downloadInfo, baseException);
        if (i == -4) {
            return;
        }
        if (z && this.mainThreadHandler != null && (((sparseArray = this.mainThreadListeners) != null && sparseArray.size() > 0) || ((sparseArray2 = this.notificationListeners) != null && sparseArray2.size() > 0 && (this.downloadInfo.canShowNotification() || this.downloadInfo.isAutoInstallWithoutNotification())))) {
            this.mainThreadHandler.obtainMessage(i, this.downloadInfo.getId(), this.downloadTask.getHashCodeForSameTask(), baseException).sendToTarget();
            return;
        }
        com.ss.android.socialbase.downloader.impls.AbsDownloadEngine downloadEngine = com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.getDownloadEngine();
        if (downloadEngine != null) {
            downloadEngine.refreshDownloadTaskMap(this.downloadInfo.getId(), this.downloadTask.getHashCodeForSameTask(), i);
        }
    }

    private com.ss.android.socialbase.downloader.exception.BaseException reviseFailedException(com.ss.android.socialbase.downloader.exception.BaseException baseException) {
        android.content.Context appContext;
        if (com.ss.android.socialbase.downloader.setting.DownloadSetting.obtain(this.downloadInfo.getId()).optInt(com.ss.android.socialbase.downloader.setting.DownloadSettingKeys.DOWNLOAD_FAILED_CHECK_NET, 1) != 1 || !com.ss.android.socialbase.downloader.utils.DownloadUtils.isNetworkError(baseException) || (appContext = com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.getAppContext()) == null || com.ss.android.socialbase.downloader.utils.DownloadUtils.isNetworkConnected(appContext)) {
            return baseException;
        }
        return new com.ss.android.socialbase.downloader.exception.BaseException(this.downloadInfo.isOnlyWifi() ? 1013 : com.ss.android.socialbase.downloader.constants.DownloadErrorCode.ERROR_NETWORK_NOT_AVAILABLE, baseException.getErrorMessage());
    }

    public long getMinByteIntervalForSyncCache() {
        return this.minByteIntervalForSyncProgress / this.downloadInfo.getChunkCount();
    }

    public int getMinTimeIntervalForSyncCache() {
        return this.minTimeIntervalForSyncProgress / this.downloadInfo.getChunkCount();
    }

    public void handleWaitingAsyncHandler() {
        this.downloadInfo.setStatus(8);
        this.downloadInfo.setAsyncHandleStatus(com.ss.android.socialbase.downloader.constants.AsyncHandleStatus.ASYNC_HANDLE_WAITING);
        com.ss.android.socialbase.downloader.impls.AbsDownloadEngine downloadEngine = com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.getDownloadEngine();
        if (downloadEngine != null) {
            downloadEngine.refreshDownloadTaskMap(this.downloadInfo.getId(), this.downloadTask.getHashCodeForSameTask(), 8);
        }
    }

    public void onCancel() {
        onStatusChanged(-4, null);
    }

    public void onCompleteForFileExist() throws com.ss.android.socialbase.downloader.exception.BaseException {
        if (!this.fixStartWithFileExistUpdateError) {
            downloadCompleteProcess();
            com.ss.android.socialbase.downloader.logger.Logger.d(TAG, "onCompleteForFileExist");
            this.downloadInfo.setSuccessByCache(true);
            onStatusChanged(-3, null);
            this.downloadCache.OnDownloadTaskCompleted(this.downloadInfo.getId(), this.downloadInfo.getTotalBytes());
            this.downloadCache.removeAllDownloadChunk(this.downloadInfo.getId());
            this.downloadCache.removeSegments(this.downloadInfo.getId());
            return;
        }
        downloadCompleteProcess();
        com.ss.android.socialbase.downloader.logger.Logger.d(TAG, "onCompleteForFileExist");
        this.downloadInfo.setSuccessByCache(true);
        onStatusChanged(-3, null);
        this.downloadCache.OnDownloadTaskCompleted(this.downloadInfo.getId(), this.downloadInfo.getTotalBytes());
        this.downloadCache.removeAllDownloadChunk(this.downloadInfo.getId());
        this.downloadCache.updateDownloadInfo(this.downloadInfo);
        this.downloadCache.removeSegments(this.downloadInfo.getId());
    }

    public void onCompleteForFileExist(java.lang.String str) throws com.ss.android.socialbase.downloader.exception.BaseException {
        com.ss.android.socialbase.downloader.logger.Logger.d(TAG, "onCompleteForFileExist existTargetFileName is " + str + " but curName is " + this.downloadInfo.getName());
        if (this.fixStartWithFileExistUpdateError) {
            com.ss.android.socialbase.downloader.utils.DownloadUtils.copyFileFromExistFileWithSameName(this.downloadInfo, str);
            downloadCompleteProcess();
            this.downloadInfo.setSuccessByCache(true);
            onStatusChanged(-3, null);
            this.downloadCache.updateDownloadInfo(this.downloadInfo);
            return;
        }
        this.downloadCache.updateDownloadInfo(this.downloadInfo);
        com.ss.android.socialbase.downloader.utils.DownloadUtils.copyFileFromExistFileWithSameName(this.downloadInfo, str);
        this.downloadInfo.setSuccessByCache(true);
        downloadCompleteProcess();
        onStatusChanged(-3, null);
    }

    public void onCompleted() {
        this.downloadInfo.setFirstDownload(false);
        if (!this.downloadInfo.isIgnoreDataVerify() && this.downloadInfo.getCurBytes() != this.downloadInfo.getTotalBytes()) {
            com.ss.android.socialbase.downloader.logger.Logger.d(TAG, this.downloadInfo.getErrorBytesLog());
            onError(new com.ss.android.socialbase.downloader.exception.DownloadRetryNeedlessException(1027, "current bytes is not equals to total bytes, bytes changed with process : " + this.downloadInfo.getByteInvalidRetryStatus()));
            return;
        }
        if (this.downloadInfo.getCurBytes() <= 0) {
            com.ss.android.socialbase.downloader.logger.Logger.d(TAG, this.downloadInfo.getErrorBytesLog());
            onError(new com.ss.android.socialbase.downloader.exception.DownloadRetryNeedlessException(1026, "curBytes is 0, bytes changed with process : " + this.downloadInfo.getByteInvalidRetryStatus()));
            return;
        }
        if (!this.downloadInfo.isIgnoreDataVerify() && this.downloadInfo.getTotalBytes() <= 0) {
            com.ss.android.socialbase.downloader.logger.Logger.d(TAG, this.downloadInfo.getErrorBytesLog());
            onError(new com.ss.android.socialbase.downloader.exception.DownloadRetryNeedlessException(com.ss.android.socialbase.downloader.constants.DownloadErrorCode.ERROR_TOTAL_BYTES_ZERO, "TotalBytes is 0, bytes changed with process : " + this.downloadInfo.getByteInvalidRetryStatus()));
            return;
        }
        com.ss.android.socialbase.downloader.logger.Logger.d(TAG, this.downloadInfo.getName() + " onCompleted start save file as target name");
        com.ss.android.socialbase.downloader.depend.IDownloadMonitorDepend iDownloadMonitorDepend = this.downloadMonitorDepend;
        com.ss.android.socialbase.downloader.model.DownloadTask downloadTask = this.downloadTask;
        if (downloadTask != null) {
            iDownloadMonitorDepend = downloadTask.getMonitorDepend();
        }
        com.ss.android.socialbase.downloader.utils.DownloadUtils.saveFileAsTargetName(this.downloadInfo, iDownloadMonitorDepend, new com.ss.android.socialbase.downloader.downloader.DownloadStatusHandler.AnonymousClass2());
    }

    public void onError(com.ss.android.socialbase.downloader.exception.BaseException baseException) {
        this.downloadInfo.setFirstDownload(false);
        handleError(baseException);
    }

    public void onFirstConnectionSuccessed(long j, java.lang.String str, java.lang.String str2) {
        this.downloadInfo.setTotalBytes(j);
        this.downloadInfo.seteTag(str);
        if (!android.text.TextUtils.isEmpty(str2) && android.text.TextUtils.isEmpty(this.downloadInfo.getName())) {
            this.downloadInfo.setName(str2);
        }
        try {
            this.downloadCache.OnDownloadTaskConnected(this.downloadInfo.getId(), j, str, str2);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
        onStatusChanged(3, null);
        this.minByteIntervalForSyncProgress = this.downloadInfo.getMinByteIntervalForPostToMainThread(j);
        this.minTimeIntervalForSyncProgress = this.downloadInfo.getMinProgressTimeMsInterval();
        this.forceRefreshProcess = true;
        com.ss.android.socialbase.downloader.impls.RetryScheduler.getInstance().scheduleRetryWhenHasTaskConnected();
    }

    public void onIntercept() {
        this.downloadInfo.setStatus(-7);
        try {
            this.downloadCache.OnDownloadTaskIntercept(this.downloadInfo.getId());
        } catch (android.database.sqlite.SQLiteException e) {
            e.printStackTrace();
        }
        onStatusChanged(-7, null);
    }

    public void onPause() {
        this.downloadInfo.setStatus(-2);
        try {
            this.downloadCache.OnDownloadTaskPause(this.downloadInfo.getId(), this.downloadInfo.getCurBytes());
        } catch (android.database.sqlite.SQLiteException e) {
            e.printStackTrace();
        }
        onStatusChanged(-2, null);
    }

    public void onPrepare() {
        if (this.downloadInfo.canSkipStatusHandler()) {
            return;
        }
        this.downloadInfo.setStatus(1);
        handlePrepare();
    }

    public boolean onProgress(long j) {
        this.msgPostDataBuffer.addAndGet(j);
        this.downloadInfo.increaseCurBytes(j);
        long uptimeMillis = android.os.SystemClock.uptimeMillis();
        return handleProgress(uptimeMillis, needSyncProgress(uptimeMillis));
    }

    public void onRetry(com.ss.android.socialbase.downloader.exception.BaseException baseException, boolean z) {
        this.downloadInfo.setFirstDownload(false);
        this.msgPostDataBuffer.set(0L);
        handleRetry(baseException, z);
    }

    public void onSingleChunkRetry(com.ss.android.socialbase.downloader.model.DownloadChunk downloadChunk, com.ss.android.socialbase.downloader.exception.BaseException baseException, boolean z) {
        this.downloadInfo.setFirstDownload(false);
        this.msgPostDataBuffer.set(0L);
        this.downloadCache.OnDownloadTaskRetry(this.downloadInfo.getId());
        onStatusChanged(z ? 10 : 9, baseException, true);
    }

    public void onStart() {
        if (this.downloadInfo.canSkipStatusHandler()) {
            this.downloadInfo.changeSkipStatus();
            return;
        }
        this.downloadCache.onDownloadTaskStart(this.downloadInfo.getId());
        if (this.downloadInfo.isFirstDownload()) {
            onStatusChanged(6, null);
        }
        onStatusChanged(2, null);
    }
}
