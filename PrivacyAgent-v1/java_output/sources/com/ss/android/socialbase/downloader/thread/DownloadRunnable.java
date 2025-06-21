package com.ss.android.socialbase.downloader.thread;

/* loaded from: classes19.dex */
public class DownloadRunnable implements com.ss.android.socialbase.downloader.thread.IDownloadRunnableCallback, java.lang.Runnable {
    private static final int MAX_RESET_RETAIN_RETRY_TIMES_COUNT = 3;
    private static final java.lang.String TAG = "DownloadRunnable";
    private boolean acceptPartial;
    private boolean canResumeFromCache;
    private long curBytesNeedCheckSpaceOverFlow;
    private com.ss.android.socialbase.downloader.depend.IDownloadDiskSpaceHandler diskSpaceHandler;
    private final com.ss.android.socialbase.downloader.downloader.IDownloadCache downloadCache;
    private com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo;
    private final com.ss.android.socialbase.downloader.model.DownloadTask downloadTask;
    private volatile com.ss.android.socialbase.downloader.exception.BaseException errorException;
    private java.lang.String existTargetFileName;
    private com.ss.android.socialbase.downloader.network.IDownloadHttpConnection firstGetConnection;
    private com.ss.android.socialbase.downloader.network.IDownloadHeadHttpConnection firstHeadConnection;
    private volatile com.ss.android.socialbase.downloader.downloader.DownloadResponseHandler firstHttpResponseHandler;
    private com.ss.android.socialbase.downloader.depend.IDownloadForbiddenHandler forbiddenHandler;
    private final com.ss.android.socialbase.downloader.downloader.IChunkAdjustCalculator globalChunkAdjustCalculator;
    private final com.ss.android.socialbase.downloader.downloader.IChunkCntCalculator globalChunkCalculator;
    private final java.util.concurrent.atomic.AtomicBoolean isAlive;
    private boolean isChunked;
    private boolean isResponseFromBegin;
    private boolean isSingleChunk;
    private java.util.concurrent.Future mFuture;
    private long prepareDownloadTime;
    private java.util.concurrent.atomic.AtomicInteger retainRetryTimes;
    private com.ss.android.socialbase.downloader.downloader.IRetryDelayTimeCalculator retryDelayTimeCalculator;
    private final com.ss.android.socialbase.downloader.setting.DownloadSetting setting;
    private final com.ss.android.socialbase.downloader.downloader.DownloadStatusHandler statusHandler;
    private com.ss.android.socialbase.downloader.downloader.IChunkAdjustCalculator taskChunkAdjustCalculator;
    private com.ss.android.socialbase.downloader.downloader.IChunkCntCalculator taskChunkCalculator;
    private volatile boolean isTriedFixRangeNotSatisfiable = false;
    private final java.util.ArrayList<com.ss.android.socialbase.downloader.thread.DownloadChunkRunnable> downloadChunkRunnableList = new java.util.ArrayList<>();
    private volatile com.ss.android.socialbase.downloader.constants.RunStatus runStatus = com.ss.android.socialbase.downloader.constants.RunStatus.RUN_STATUS_NONE;
    private volatile int bytesRetryCount = 5;
    private boolean needJumpToStart = false;
    private boolean firstHeadConnectionFailed = false;
    private boolean needCheckIfModified = false;
    private int resetRetainRetryTimesCount = 0;
    private volatile com.ss.android.socialbase.downloader.segment.SegmentDispatcher segmentDispatcher = null;

    /* renamed from: com.ss.android.socialbase.downloader.thread.DownloadRunnable$1, reason: invalid class name */
    public class AnonymousClass1 extends com.ss.android.socialbase.downloader.depend.AbsDownloadForbiddenCallback {
        public AnonymousClass1() {
        }

        @Override // com.ss.android.socialbase.downloader.depend.AbsDownloadForbiddenCallback, com.ss.android.socialbase.downloader.depend.IDownloadForbiddenCallback
        public void onCallback(java.util.List<java.lang.String> list) {
            super.onCallback(list);
            com.ss.android.socialbase.downloader.thread.DownloadRunnable.this.handleForbiddenCallback(list);
        }
    }

    /* renamed from: com.ss.android.socialbase.downloader.thread.DownloadRunnable$2, reason: invalid class name */
    public class AnonymousClass2 implements com.ss.android.socialbase.downloader.depend.IDownloadDiskSpaceCallback {
        final /* synthetic */ java.util.concurrent.atomic.AtomicBoolean val$diskCleaned;

        public AnonymousClass2(java.util.concurrent.atomic.AtomicBoolean atomicBoolean) {
            this.val$diskCleaned = atomicBoolean;
        }

        @Override // com.ss.android.socialbase.downloader.depend.IDownloadDiskSpaceCallback
        public void onDiskCleaned() {
            synchronized (com.ss.android.socialbase.downloader.thread.DownloadRunnable.this) {
                this.val$diskCleaned.set(true);
                com.ss.android.socialbase.downloader.thread.DownloadRunnable.this.handleDiskSpaceCallback();
            }
        }
    }

    public DownloadRunnable(com.ss.android.socialbase.downloader.model.DownloadTask downloadTask, android.os.Handler handler) {
        this.downloadTask = downloadTask;
        if (downloadTask != null) {
            this.downloadInfo = downloadTask.getDownloadInfo();
            this.taskChunkCalculator = downloadTask.getChunkStrategy();
            this.taskChunkAdjustCalculator = downloadTask.getChunkAdjustCalculator();
            this.forbiddenHandler = downloadTask.getForbiddenHandler();
            this.diskSpaceHandler = downloadTask.getDiskSpaceHandler();
            this.retryDelayTimeCalculator = getRetryDelayTimeCalculator(downloadTask);
            this.setting = com.ss.android.socialbase.downloader.setting.DownloadSetting.obtain(this.downloadInfo.getId());
        } else {
            this.setting = com.ss.android.socialbase.downloader.setting.DownloadSetting.obtainGlobal();
        }
        updateRetainRetryTimes();
        this.downloadCache = com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.getDownloadCache();
        this.globalChunkCalculator = com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.getChunkCntCalculator();
        this.globalChunkAdjustCalculator = com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.getChunkAdjustCalculator();
        this.statusHandler = new com.ss.android.socialbase.downloader.downloader.DownloadStatusHandler(downloadTask, handler);
        this.isAlive = new java.util.concurrent.atomic.AtomicBoolean(true);
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x005c, code lost:
    
        if (r9 <= 0) goto L18;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private int calculateChunkCount(long j, java.util.List<com.ss.android.socialbase.downloader.model.DownloadChunk> list) {
        int i;
        if (isMultiChunkDownloadAvailable()) {
            if (this.canResumeFromCache) {
                i = list != null ? list.size() : this.downloadInfo.getChunkCount();
            } else {
                com.ss.android.socialbase.downloader.downloader.IChunkCntCalculator iChunkCntCalculator = this.taskChunkCalculator;
                int calculateChunkCount = iChunkCntCalculator != null ? iChunkCntCalculator.calculateChunkCount(j) : this.globalChunkCalculator.calculateChunkCount(j);
                com.ss.android.socialbase.downloader.network.NetworkQuality currentNetworkQuality = com.ss.android.socialbase.downloader.network.NetTrafficManager.getInstance().getCurrentNetworkQuality();
                com.ss.android.socialbase.downloader.logger.Logger.d(TAG, java.lang.String.format("NetworkQuality is : %s", currentNetworkQuality.name()));
                this.downloadInfo.setNetworkQuality(currentNetworkQuality.name());
                com.ss.android.socialbase.downloader.downloader.IChunkAdjustCalculator iChunkAdjustCalculator = this.taskChunkAdjustCalculator;
                i = iChunkAdjustCalculator != null ? iChunkAdjustCalculator.calculateChunkCount(calculateChunkCount, currentNetworkQuality) : this.globalChunkAdjustCalculator.calculateChunkCount(calculateChunkCount, currentNetworkQuality);
            }
        }
        i = 1;
        if (com.ss.android.socialbase.downloader.logger.Logger.debug()) {
            com.ss.android.socialbase.downloader.logger.Logger.d(TAG, java.lang.String.format("chunk count : %s for %s contentLen:%s", java.lang.String.valueOf(i), this.downloadInfo.getName(), java.lang.String.valueOf(j)));
        }
        return i;
    }

    private void cancelAllChunkRunnable() {
        try {
            java.util.Iterator it = ((java.util.ArrayList) this.downloadChunkRunnableList.clone()).iterator();
            while (it.hasNext()) {
                com.ss.android.socialbase.downloader.thread.DownloadChunkRunnable downloadChunkRunnable = (com.ss.android.socialbase.downloader.thread.DownloadChunkRunnable) it.next();
                if (downloadChunkRunnable != null) {
                    downloadChunkRunnable.cancel();
                }
            }
        } catch (java.lang.Throwable th) {
            com.ss.android.socialbase.downloader.logger.Logger.i(TAG, "cancelAllChunkRunnable: " + th.toString());
        }
    }

    private boolean checkCompletedByteValid() {
        if (this.downloadInfo.isChunked()) {
            com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo = this.downloadInfo;
            downloadInfo.setTotalBytes(downloadInfo.getCurBytes());
        }
        com.ss.android.socialbase.downloader.logger.Logger.i(TAG, "checkCompletedByteValid: downloadInfo.getCurBytes() = " + this.downloadInfo.getCurBytes() + ",  downloadInfo.getTotalBytes() = " + this.downloadInfo.getTotalBytes());
        if (this.downloadInfo.getCurBytes() > 0) {
            if (this.downloadInfo.isIgnoreDataVerify()) {
                return true;
            }
            if (this.downloadInfo.getTotalBytes() > 0 && this.downloadInfo.getCurBytes() == this.downloadInfo.getTotalBytes()) {
                return true;
            }
        }
        this.downloadInfo.setByteInvalidRetryStatus(com.ss.android.socialbase.downloader.constants.ByteInvalidRetryStatus.BYTE_INVALID_RETRY_STATUS_RESTART);
        this.downloadInfo.reset();
        this.downloadCache.updateDownloadInfo(this.downloadInfo);
        this.downloadCache.removeAllDownloadChunk(this.downloadInfo.getId());
        this.downloadCache.removeSegments(this.downloadInfo.getId());
        com.ss.android.socialbase.downloader.utils.DownloadUtils.deleteAllDownloadFiles(this.downloadInfo);
        return false;
    }

    private void checkHasAnotherSameTask() throws com.ss.android.socialbase.downloader.exception.RetryThrowable, com.ss.android.socialbase.downloader.exception.BaseException {
        com.ss.android.socialbase.downloader.impls.AbsDownloadEngine downloadEngine;
        int id = this.downloadInfo.getId();
        int downloadId = com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.getDownloadId(this.downloadInfo);
        if (this.downloadInfo.isDownloaded() && !this.downloadInfo.isExpiredRedownload() && !this.needCheckIfModified) {
            throw new com.ss.android.socialbase.downloader.exception.BaseException(1009, "file has downloaded");
        }
        com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo = this.downloadCache.getDownloadInfo(downloadId);
        if (downloadInfo == null || (downloadEngine = com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.getDownloadEngine()) == null || downloadInfo.getId() == id || !downloadInfo.equalsTask(this.downloadInfo)) {
            return;
        }
        if (downloadEngine.isDownloading(downloadInfo.getId())) {
            this.downloadCache.removeDownloadTaskData(id);
            throw new com.ss.android.socialbase.downloader.exception.BaseException(1025, "another same task is downloading");
        }
        java.util.List<com.ss.android.socialbase.downloader.model.DownloadChunk> downloadChunk = this.downloadCache.getDownloadChunk(downloadId);
        com.ss.android.socialbase.downloader.utils.DownloadUtils.deleteAllDownloadFiles(this.downloadInfo);
        this.downloadCache.removeDownloadTaskData(downloadId);
        if (downloadInfo.isBreakpointAvailable()) {
            this.downloadInfo.copyFromCacheData(downloadInfo, false);
            this.downloadCache.updateDownloadInfo(this.downloadInfo);
            if (downloadChunk != null) {
                for (com.ss.android.socialbase.downloader.model.DownloadChunk downloadChunk2 : downloadChunk) {
                    downloadChunk2.setId(id);
                    this.downloadCache.addDownloadChunk(downloadChunk2);
                }
            }
            throw new com.ss.android.socialbase.downloader.exception.RetryThrowable("retry task because id generator changed");
        }
    }

    private boolean checkIsStoppedByUser() {
        if (!isStoppedStatus() && this.downloadInfo.getStatus() != -2) {
            return false;
        }
        if (isStoppedStatus()) {
            return true;
        }
        if (this.downloadInfo.getStatus() == -2) {
            this.runStatus = com.ss.android.socialbase.downloader.constants.RunStatus.RUN_STATUS_PAUSE;
            return true;
        }
        if (this.downloadInfo.getStatus() != -4) {
            return true;
        }
        this.runStatus = com.ss.android.socialbase.downloader.constants.RunStatus.RUN_STATUS_CANCELED;
        return true;
    }

    private boolean checkNeedRetryDelay() {
        return false;
    }

    private void checkSavePathValid() throws com.ss.android.socialbase.downloader.exception.BaseException {
        if (android.text.TextUtils.isEmpty(this.downloadInfo.getSavePath())) {
            throw new com.ss.android.socialbase.downloader.exception.BaseException(1028, "download savePath can not be empty");
        }
        if (android.text.TextUtils.isEmpty(this.downloadInfo.getName())) {
            throw new com.ss.android.socialbase.downloader.exception.BaseException(1029, "download name can not be empty");
        }
        java.io.File file = new java.io.File(this.downloadInfo.getSavePath());
        if (file.exists()) {
            if (file.isDirectory()) {
                return;
            }
            if (!com.ss.android.socialbase.downloader.utils.DownloadSettingsUtils.isOptimizeSavePath(this.downloadInfo)) {
                throw new com.ss.android.socialbase.downloader.exception.BaseException(com.ss.android.socialbase.downloader.constants.DownloadErrorCode.ERROR_SAVE_PATH_NOT_DIRECTORY, "download savePath is not a directory:" + this.downloadInfo.getSavePath());
            }
            file.delete();
            if (file.mkdirs() || file.exists()) {
                return;
            }
            throw new com.ss.android.socialbase.downloader.exception.BaseException(com.ss.android.socialbase.downloader.constants.DownloadErrorCode.ERROR_SAVE_PATH_NOT_DIRECTORY, "download savePath is not directory:path=" + this.downloadInfo.getSavePath());
        }
        boolean mkdirs = file.mkdirs();
        if (mkdirs || file.exists()) {
            return;
        }
        int i = 0;
        if (com.ss.android.socialbase.downloader.setting.DownloadSetting.obtain(this.downloadInfo.getId()).optInt(com.ss.android.socialbase.downloader.setting.DownloadSettingKeys.OPT_MKDIR_FAILED, 0) != 1) {
            throw new com.ss.android.socialbase.downloader.exception.BaseException(1030, "download savePath directory can not created:" + this.downloadInfo.getSavePath());
        }
        while (!mkdirs) {
            int i2 = i + 1;
            if (i >= 3) {
                break;
            }
            try {
                java.lang.Thread.sleep(10L);
                mkdirs = file.mkdirs();
                i = i2;
            } catch (java.lang.InterruptedException unused) {
            }
        }
        if (mkdirs || file.exists()) {
            return;
        }
        if (com.ss.android.socialbase.downloader.utils.DownloadUtils.getAvailableSpaceBytes(this.downloadInfo.getSavePath()) < 16384) {
            throw new com.ss.android.socialbase.downloader.exception.BaseException(1006, "download savePath directory can not created:" + this.downloadInfo.getSavePath());
        }
        throw new com.ss.android.socialbase.downloader.exception.BaseException(1030, "download savePath directory can not created:" + this.downloadInfo.getSavePath());
    }

    private void checkSpaceOverflowInProgress() throws com.ss.android.socialbase.downloader.exception.BaseException {
        long j;
        int optInt;
        try {
            j = com.ss.android.socialbase.downloader.utils.DownloadUtils.getAvailableSpaceBytes(this.downloadInfo.getTempPath());
        } catch (com.ss.android.socialbase.downloader.exception.BaseException unused) {
            j = 0;
        }
        java.lang.String str = TAG;
        com.ss.android.socialbase.downloader.logger.Logger.i(str, "checkSpaceOverflowInProgress: available = " + com.ss.android.socialbase.downloader.utils.DownloadUtils.byteToMb(j) + "MB");
        if (j > 0) {
            long totalBytes = this.downloadInfo.getTotalBytes() - this.downloadInfo.getCurBytes();
            if (j < totalBytes && (optInt = com.ss.android.socialbase.downloader.setting.DownloadSetting.obtain(this.downloadInfo.getId()).optInt(com.ss.android.socialbase.downloader.setting.DownloadSettingKeys.SPACE_FILL_MIN_KEEP_MB, 100)) > 0) {
                long j2 = j - (optInt * 1048576);
                com.ss.android.socialbase.downloader.logger.Logger.i(str, "checkSpaceOverflowInProgress: minKeep  = " + optInt + "MB, canDownload = " + com.ss.android.socialbase.downloader.utils.DownloadUtils.byteToMb(j2) + "MB");
                if (j2 > 0) {
                    this.curBytesNeedCheckSpaceOverFlow = this.downloadInfo.getCurBytes() + j2 + 1048576;
                    return;
                } else {
                    this.curBytesNeedCheckSpaceOverFlow = 0L;
                    throw new com.ss.android.socialbase.downloader.exception.DownloadOutOfSpaceException(j, totalBytes);
                }
            }
        }
        this.curBytesNeedCheckSpaceOverFlow = 0L;
    }

    /* JADX WARN: Code restructure failed: missing block: B:95:0x00f1, code lost:
    
        if (r9.setting.optBugFix(com.ss.android.socialbase.downloader.setting.DownloadSettingKeys.BugFix.FIX_FILE_EXIST_UPDATE_DOWNLOAD_INFO) != false) goto L80;
     */
    /* JADX WARN: Not initialized variable reg: 4, insn: 0x00e9: IF  (r4 I:??[int, boolean, OBJECT, ARRAY, byte, short, char]) == (0 ??[int, boolean, OBJECT, ARRAY, byte, short, char])  -> B:89:0x00f3, block:B:88:0x00e9 */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00aa A[Catch: all -> 0x00e6, TryCatch #4 {all -> 0x00e6, blocks: (B:33:0x00a6, B:35:0x00aa, B:37:0x00ae, B:69:0x00e5), top: B:2:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:50:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void checkTaskCache() throws com.ss.android.socialbase.downloader.exception.DownloadFileExistException {
        boolean z;
        boolean z2;
        com.ss.android.socialbase.downloader.model.DownloadTask downloadTask;
        boolean z3 = false;
        try {
            try {
                int id = this.downloadInfo.getId();
                if (this.downloadCache != null) {
                    if (com.ss.android.socialbase.downloader.utils.DownloadExpSwitchCode.isSwitchEnable(2048)) {
                        this.downloadCache.ensureDownloadCacheSyncSuccess();
                    }
                    com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo = this.downloadCache.getDownloadInfo(id);
                    z2 = true;
                    if (downloadInfo != null && !downloadInfo.isNewTask()) {
                        java.lang.String savePath = this.downloadInfo.getSavePath();
                        java.lang.String md5 = this.downloadInfo.getMd5();
                        this.downloadInfo.copyFromCacheData(downloadInfo, true);
                        boolean z4 = com.ss.android.socialbase.downloader.utils.DownloadExpSwitchCode.isSwitchEnable(4096) && downloadInfo != this.downloadInfo;
                        try {
                            if (savePath.equals(downloadInfo.getSavePath()) && com.ss.android.socialbase.downloader.utils.DownloadUtils.isFileDownloaded(downloadInfo, false, md5)) {
                                try {
                                    throw new com.ss.android.socialbase.downloader.exception.DownloadFileExistException(downloadInfo.getName());
                                } catch (com.ss.android.socialbase.downloader.exception.DownloadFileExistException e) {
                                    throw e;
                                } catch (java.lang.Throwable th) {
                                    th = th;
                                    z3 = z4;
                                    downloadTask = this.downloadTask;
                                    if (downloadTask != null && this.downloadInfo != null) {
                                        com.ss.android.socialbase.downloader.monitor.DownloadMonitorHelper.monitorSendWithTaskMonitor(downloadTask.getMonitorDepend(), this.downloadInfo, new com.ss.android.socialbase.downloader.exception.BaseException(1003, com.ss.android.socialbase.downloader.utils.DownloadUtils.getErrorMsgWithTagPrefix(th, "checkTaskCache")), this.downloadInfo.getStatus());
                                    }
                                    if (z3) {
                                        if (z2) {
                                            try {
                                                if (!this.setting.optBugFix(com.ss.android.socialbase.downloader.setting.DownloadSettingKeys.BugFix.FIX_FILE_EXIST_UPDATE_DOWNLOAD_INFO)) {
                                                    return;
                                                }
                                            } catch (android.database.sqlite.SQLiteException e2) {
                                                e2.printStackTrace();
                                                return;
                                            }
                                        }
                                        this.downloadCache.updateDownloadInfo(this.downloadInfo);
                                        return;
                                    }
                                    return;
                                }
                            }
                            if (com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.getDownloadId(downloadInfo) != id) {
                                try {
                                    this.downloadCache.removeDownloadTaskData(id);
                                } catch (android.database.sqlite.SQLiteException e3) {
                                    e3.printStackTrace();
                                }
                            } else {
                                z2 = z4;
                            }
                        } catch (com.ss.android.socialbase.downloader.exception.DownloadFileExistException e4) {
                            e = e4;
                            throw e;
                        } catch (java.lang.Throwable th2) {
                            th = th2;
                            z3 = z4;
                            z2 = false;
                            downloadTask = this.downloadTask;
                            if (downloadTask != null) {
                            }
                            if (z3) {
                            }
                        }
                    }
                    this.downloadInfo.reset();
                } else {
                    z2 = false;
                }
            } catch (java.lang.Throwable th3) {
                if (0 != 0) {
                    if (z) {
                        try {
                        } catch (android.database.sqlite.SQLiteException e5) {
                            e5.printStackTrace();
                        }
                    }
                    this.downloadCache.updateDownloadInfo(this.downloadInfo);
                }
                throw th3;
            }
        } catch (com.ss.android.socialbase.downloader.exception.DownloadFileExistException e6) {
            e = e6;
        } catch (java.lang.Throwable th4) {
            th = th4;
        }
        try {
            updateRetainRetryTimes();
            if (z2) {
                try {
                    this.downloadCache.updateDownloadInfo(this.downloadInfo);
                } catch (android.database.sqlite.SQLiteException e7) {
                    e7.printStackTrace();
                }
            }
        } catch (com.ss.android.socialbase.downloader.exception.DownloadFileExistException e8) {
            e = e8;
            throw e;
        } catch (java.lang.Throwable th5) {
            th = th5;
            z3 = z2;
            z2 = false;
            downloadTask = this.downloadTask;
            if (downloadTask != null) {
                com.ss.android.socialbase.downloader.monitor.DownloadMonitorHelper.monitorSendWithTaskMonitor(downloadTask.getMonitorDepend(), this.downloadInfo, new com.ss.android.socialbase.downloader.exception.BaseException(1003, com.ss.android.socialbase.downloader.utils.DownloadUtils.getErrorMsgWithTagPrefix(th, "checkTaskCache")), this.downloadInfo.getStatus());
            }
            if (z3) {
            }
        }
    }

    private void checkTaskCanResume() {
        long curByte = com.ss.android.socialbase.downloader.utils.DownloadUtils.getCurByte(this.downloadInfo);
        long curBytes = this.downloadInfo.getCurBytes();
        if (curByte != curBytes) {
            com.ss.android.socialbase.downloader.logger.Logger.w(TAG, "checkTaskCanResume: offset = " + curByte + ", curBytes = " + curBytes);
        }
        this.downloadInfo.setCurBytes(curByte);
        boolean z = curByte > 0;
        this.canResumeFromCache = z;
        if (z || this.needCheckIfModified) {
            return;
        }
        com.ss.android.socialbase.downloader.logger.Logger.i(TAG, "checkTaskCanResume: deleteAllDownloadFiles");
        this.downloadCache.removeAllDownloadChunk(this.downloadInfo.getId());
        this.downloadCache.removeSegments(this.downloadInfo.getId());
        com.ss.android.socialbase.downloader.utils.DownloadUtils.deleteAllDownloadFiles(this.downloadInfo);
    }

    private boolean checkTaskStatusValid() {
        int status = this.downloadInfo.getStatus();
        if (status == 1 || this.downloadInfo.canSkipStatusHandler()) {
            return true;
        }
        if (status == -2 || status == -4) {
            return false;
        }
        onError(new com.ss.android.socialbase.downloader.exception.BaseException(1000, "The download Task can't start, because its status is not prepare:".concat(java.lang.String.valueOf(status))));
        return false;
    }

    private void checkWifiTaskValid() throws com.ss.android.socialbase.downloader.exception.DownloadRetryNeedlessException {
        if (this.downloadInfo.isOnlyWifi() && !com.ss.android.socialbase.downloader.utils.DownloadUtils.checkPermission(com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.getAppContext(), "android.permission.ACCESS_NETWORK_STATE")) {
            throw new com.ss.android.socialbase.downloader.exception.DownloadRetryNeedlessException(1019, java.lang.String.format("download task need permission:%s", "android.permission.ACCESS_NETWORK_STATE"));
        }
        if (!this.downloadInfo.isDownloadWithWifiValid()) {
            throw new com.ss.android.socialbase.downloader.exception.DownloadOnlyWifiException();
        }
        if (!this.downloadInfo.isPauseReserveWithWifiValid()) {
            throw new com.ss.android.socialbase.downloader.exception.DownloadPauseReserveWifiException();
        }
    }

    private void clearCurrentDownloadData() {
        com.ss.android.socialbase.downloader.logger.Logger.w(TAG, "clearCurrentDownloadData::" + android.util.Log.getStackTraceString(new java.lang.Throwable()));
        try {
            this.downloadCache.removeAllDownloadChunk(this.downloadInfo.getId());
            this.downloadCache.removeSegments(this.downloadInfo.getId());
            com.ss.android.socialbase.downloader.utils.DownloadUtils.deleteAllDownloadFiles(this.downloadInfo);
            this.canResumeFromCache = false;
            this.downloadInfo.resetDataForEtagEndure("");
            this.downloadCache.updateDownloadInfo(this.downloadInfo);
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    private void closeConnection() {
        closeFirstHeadConnection();
        closeFirstConnection();
    }

    private void closeFirstConnection() {
        com.ss.android.socialbase.downloader.network.IDownloadHttpConnection iDownloadHttpConnection = this.firstGetConnection;
        if (iDownloadHttpConnection != null) {
            iDownloadHttpConnection.end();
            this.firstGetConnection = null;
        }
    }

    private void closeFirstHeadConnection() {
        com.ss.android.socialbase.downloader.network.IDownloadHeadHttpConnection iDownloadHeadHttpConnection = this.firstHeadConnection;
        if (iDownloadHeadHttpConnection != null) {
            iDownloadHeadHttpConnection.cancel();
            this.firstHeadConnection = null;
        }
    }

    public static com.ss.android.socialbase.downloader.model.DownloadChunk createFirstDownloadChunk(com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo, long j) {
        return new com.ss.android.socialbase.downloader.model.DownloadChunk.Builder(downloadInfo.getId()).chunkIndex(-1).startOffset(0L).oldOffset(j).currentOffset(j).endOffset(0L).contentLength(downloadInfo.getTotalBytes() - j).build();
    }

    private void createFirstGetConnection(java.lang.String str, java.util.List<com.ss.android.socialbase.downloader.model.HttpHeader> list) throws com.ss.android.socialbase.downloader.exception.BaseException, com.ss.android.socialbase.downloader.exception.RetryThrowable {
        com.ss.android.socialbase.downloader.network.IDownloadHttpConnection iDownloadHttpConnection;
        if (this.firstGetConnection != null) {
            return;
        }
        com.ss.android.socialbase.downloader.network.connectionpool.FakeDownloadHttpConnection cachedDownloadConnection = this.downloadInfo.getChunkCount() == 1 ? com.ss.android.socialbase.downloader.network.connectionpool.DownloadConnectionPool.getInstance().getCachedDownloadConnection(str, list) : null;
        try {
            if (cachedDownloadConnection != null) {
                setHttpResponseStatus(this.firstGetConnection);
                this.downloadInfo.setPreconnectLevel(2);
                this.firstGetConnection = cachedDownloadConnection;
            } else {
                try {
                    iDownloadHttpConnection = com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.downloadWithConnection(this.downloadInfo.isNeedDefaultHttpServiceBackUp(), this.downloadInfo.getMaxBytes(), str, null, list, this.setting.optInt(com.ss.android.socialbase.downloader.setting.DownloadSettingKeys.NET_LIB_STRATEGY), this.setting.optInt(com.ss.android.socialbase.downloader.setting.DownloadSettingKeys.MONITOR_DOWNLOAD_CONNECT, 0) > 0, this.downloadInfo);
                    this.firstGetConnection = iDownloadHttpConnection;
                } catch (com.ss.android.socialbase.downloader.exception.BaseException e) {
                    throw e;
                } catch (java.lang.Throwable th) {
                    if (this.downloadInfo.isExpiredRedownload() && com.ss.android.socialbase.downloader.utils.DownloadUtils.isResponseCode304Error(th) && com.ss.android.socialbase.downloader.utils.DownloadUtils.hasDownloadCacheHeader(list)) {
                        com.ss.android.socialbase.downloader.logger.Logger.d(TAG, "dcache=execepiton responseCode=304 lastModified not changed, use local file.. old cacheControl=" + this.downloadInfo.getCacheControl());
                        long parserMaxAge = com.ss.android.socialbase.downloader.utils.DownloadUtils.parserMaxAge(this.downloadInfo.getCacheControl());
                        if (parserMaxAge <= 0) {
                            parserMaxAge = com.ss.android.socialbase.downloader.setting.DownloadSetting.obtain(this.downloadInfo.getId()).optInt(com.ss.android.socialbase.downloader.setting.DownloadSettingKeys.DEFAULT_304_MAX_AGE, 300);
                        }
                        this.downloadInfo.setCacheExpiredTime(java.lang.System.currentTimeMillis() + (parserMaxAge * 1000));
                        throw new com.ss.android.socialbase.downloader.exception.DownloadFileExistException(this.existTargetFileName);
                    }
                    if (com.ss.android.socialbase.downloader.utils.DownloadUtils.isResponseCode416Error(th)) {
                        handleResponseCodeError("", "http code 416");
                    } else if (com.ss.android.socialbase.downloader.utils.DownloadUtils.isResponseCode412Error(th)) {
                        handleResponseCodeError("", "http code 412");
                    } else {
                        com.ss.android.socialbase.downloader.utils.DownloadUtils.parseException(th, "CreateFirstConnection");
                    }
                    iDownloadHttpConnection = this.firstGetConnection;
                }
                setHttpResponseStatus(iDownloadHttpConnection);
            }
            if (this.firstGetConnection == null) {
                throw new com.ss.android.socialbase.downloader.exception.BaseException(1022, new java.io.IOException("download can't continue, firstConnection is null"));
            }
        } catch (java.lang.Throwable th2) {
            setHttpResponseStatus(this.firstGetConnection);
            throw th2;
        }
    }

    private void createFirstHeadConnection(java.lang.String str, java.util.List<com.ss.android.socialbase.downloader.model.HttpHeader> list, long j) throws com.ss.android.socialbase.downloader.exception.BaseException, com.ss.android.socialbase.downloader.exception.RetryThrowable {
        com.ss.android.socialbase.downloader.network.connectionpool.FakeDownloadHeadHttpConnection cachedHeadConnection;
        boolean z = true;
        if (this.downloadInfo.getChunkCount() == 1 && (cachedHeadConnection = com.ss.android.socialbase.downloader.network.connectionpool.DownloadConnectionPool.getInstance().getCachedHeadConnection(str, list)) != null) {
            this.firstHeadConnection = cachedHeadConnection;
            this.downloadInfo.setPreconnectLevel(1);
        }
        if (this.firstHeadConnection == null && !this.firstHeadConnectionFailed && this.downloadInfo.isHeadConnectionAvailable()) {
            try {
                int optInt = this.setting.optInt(com.ss.android.socialbase.downloader.setting.DownloadSettingKeys.NET_LIB_STRATEGY);
                if (this.setting.optInt(com.ss.android.socialbase.downloader.setting.DownloadSettingKeys.MONITOR_DOWNLOAD_CONNECT, 0) <= 0) {
                    z = false;
                }
                this.firstHeadConnection = com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.downloadWithHeadConnection(str, list, optInt, z, this.downloadInfo);
            } catch (java.lang.Throwable th) {
                this.downloadInfo.setHeadConnectionException(com.ss.android.socialbase.downloader.utils.DownloadUtils.getThrowableMsg(th));
            }
        }
    }

    private void doFirstConnect(java.lang.String str, java.util.List<com.ss.android.socialbase.downloader.model.HttpHeader> list, long j) throws com.ss.android.socialbase.downloader.exception.BaseException, com.ss.android.socialbase.downloader.exception.RetryThrowable {
        createFirstHeadConnection(str, list, j);
        com.ss.android.socialbase.downloader.network.IDownloadHeadHttpConnection iDownloadHeadHttpConnection = this.firstHeadConnection;
        if (iDownloadHeadHttpConnection != null) {
            try {
                handleFirstConnection(str, iDownloadHeadHttpConnection, j);
            } catch (java.lang.Throwable unused) {
                this.firstHeadConnectionFailed = true;
            }
        }
        if (this.firstHeadConnection == null || this.firstHeadConnectionFailed) {
            createFirstGetConnection(str, list);
            handleFirstConnection(str, this.firstGetConnection, j);
        }
    }

    private boolean doTaskStatusHandle() {
        if (this.runStatus == com.ss.android.socialbase.downloader.constants.RunStatus.RUN_STATUS_ERROR) {
            this.statusHandler.onError(this.errorException);
        } else if (this.runStatus == com.ss.android.socialbase.downloader.constants.RunStatus.RUN_STATUS_CANCELED) {
            this.statusHandler.onCancel();
        } else if (this.runStatus == com.ss.android.socialbase.downloader.constants.RunStatus.RUN_STATUS_PAUSE) {
            this.statusHandler.onPause();
        } else if (this.runStatus == com.ss.android.socialbase.downloader.constants.RunStatus.RUN_STATUS_END_RIGHT_NOW) {
            try {
                this.statusHandler.onCompleteForFileExist();
            } catch (com.ss.android.socialbase.downloader.exception.BaseException e) {
                this.statusHandler.onError(e);
            }
        } else if (this.runStatus == com.ss.android.socialbase.downloader.constants.RunStatus.RUN_STATUS_END_FOR_FILE_EXIST) {
            try {
                this.statusHandler.onCompleteForFileExist(this.existTargetFileName);
            } catch (com.ss.android.socialbase.downloader.exception.BaseException e2) {
                this.statusHandler.onError(e2);
            }
        } else {
            if (this.runStatus == com.ss.android.socialbase.downloader.constants.RunStatus.RUN_STATUS_ALL_CHUNK_RETRY_WITH_RESET) {
                this.statusHandler.onRetry(this.errorException, false);
                return false;
            }
            if (this.runStatus == com.ss.android.socialbase.downloader.constants.RunStatus.RUN_STATUS_WAITING_ASYNC_HANDLER) {
                return true;
            }
            com.ss.android.socialbase.downloader.constants.RunStatus runStatus = this.runStatus;
            com.ss.android.socialbase.downloader.constants.RunStatus runStatus2 = com.ss.android.socialbase.downloader.constants.RunStatus.RUN_STATUS_RETRY_DELAY;
            if (runStatus == runStatus2 && !isAllChunkDownloadComplete()) {
                com.ss.android.socialbase.downloader.logger.Logger.d(TAG, "doTaskStatusHandle retryDelay");
                startRetryDelayAlarm();
                return this.runStatus == runStatus2;
            }
            try {
                if (!checkCompletedByteValid()) {
                    return false;
                }
                this.statusHandler.onCompleted();
                com.ss.android.socialbase.downloader.impls.RetryScheduler.getInstance().scheduleRetryWhenHasTaskSucceed();
            } catch (java.lang.Throwable th) {
                onError(new com.ss.android.socialbase.downloader.exception.BaseException(1008, com.ss.android.socialbase.downloader.utils.DownloadUtils.getErrorMsgWithTagPrefix(th, "doTaskStatusHandle onComplete")));
            }
        }
        return true;
    }

    private void downloadInner() {
        boolean z;
        java.util.List<com.ss.android.socialbase.downloader.model.DownloadChunk> downloadChunk;
        try {
            this.runStatus = com.ss.android.socialbase.downloader.constants.RunStatus.RUN_STATUS_NONE;
            this.downloadInfo.updateStartDownloadTime();
            this.downloadInfo.resetRealStartDownloadTime();
            long currentTimeMillis = java.lang.System.currentTimeMillis();
            this.downloadInfo.setFirstSpeedTime(-1L);
            try {
                checkTaskCache();
                z = false;
            } catch (com.ss.android.socialbase.downloader.exception.DownloadFileExistException e) {
                com.ss.android.socialbase.downloader.logger.Logger.d(TAG, "file exist " + e.getExistTargetFileName());
                this.existTargetFileName = e.getExistTargetFileName();
                z = true;
            }
            if (!this.needJumpToStart) {
                this.statusHandler.onStart();
            }
            this.needJumpToStart = false;
            if (checkIsStoppedByUser()) {
                return;
            }
            if (!android.text.TextUtils.isEmpty(this.existTargetFileName) && z) {
                if (this.downloadInfo.isExpiredRedownload()) {
                    this.needCheckIfModified = com.ss.android.socialbase.downloader.utils.DownloadUtils.cacheExpired(this.downloadInfo);
                }
                if (!this.needCheckIfModified) {
                    finishWithFileExist();
                    return;
                }
            }
            while (!checkIsStoppedByUser()) {
                try {
                    try {
                        try {
                            checkSavePathValid();
                            checkHasAnotherSameTask();
                            checkWifiTaskValid();
                            downloadChunk = this.downloadCache.getDownloadChunk(this.downloadInfo.getId());
                            checkTaskCanResume();
                        } catch (java.lang.Throwable th) {
                            com.ss.android.socialbase.downloader.logger.Logger.w(TAG, "downloadInner: throwable =  ".concat(java.lang.String.valueOf(th)));
                            if (this.runStatus != com.ss.android.socialbase.downloader.constants.RunStatus.RUN_STATUS_PAUSE) {
                                onError(new com.ss.android.socialbase.downloader.exception.BaseException(com.ss.android.socialbase.downloader.constants.DownloadErrorCode.ERROR_DOWNLOAD_RUNNABLE_UNKNOWN, th));
                            }
                        }
                    } catch (com.ss.android.socialbase.downloader.exception.DownloadFileExistException unused) {
                        finishWithFileExist();
                    }
                } catch (com.ss.android.socialbase.downloader.exception.BaseException e2) {
                    com.ss.android.socialbase.downloader.logger.Logger.w(TAG, "downloadInner: baseException = ".concat(java.lang.String.valueOf(e2)));
                    if (this.runStatus != com.ss.android.socialbase.downloader.constants.RunStatus.RUN_STATUS_PAUSE) {
                        if (e2.getErrorCode() != 1025 && e2.getErrorCode() != 1009) {
                            if (canRetry(e2)) {
                                if (com.ss.android.socialbase.downloader.utils.DownloadUtils.isHttpDataDirtyError(e2)) {
                                    clearCurrentDownloadData();
                                }
                                if (onRetry(e2, 0L) == com.ss.android.socialbase.downloader.exception.RetryCheckStatus.RETURN) {
                                    closeConnection();
                                    return;
                                }
                                closeConnection();
                            } else {
                                onError(e2);
                            }
                        }
                        this.runStatus = com.ss.android.socialbase.downloader.constants.RunStatus.RUN_STATUS_END_RIGHT_NOW;
                        closeConnection();
                        return;
                    }
                } catch (com.ss.android.socialbase.downloader.exception.RetryThrowable e3) {
                    try {
                        com.ss.android.socialbase.downloader.logger.Logger.w(TAG, "downloadInner: retry throwable for " + e3.getErrorMsg());
                        if (this.runStatus != com.ss.android.socialbase.downloader.constants.RunStatus.RUN_STATUS_PAUSE) {
                            java.util.concurrent.atomic.AtomicInteger atomicInteger = this.retainRetryTimes;
                            if (atomicInteger != null && atomicInteger.get() > 0) {
                                this.downloadInfo.updateCurRetryTime(this.retainRetryTimes.decrementAndGet());
                                this.downloadInfo.setStatus(5);
                            } else if (this.retainRetryTimes == null) {
                                onError(new com.ss.android.socialbase.downloader.exception.BaseException(com.ss.android.socialbase.downloader.constants.DownloadErrorCode.ERROR_RETAIN_RETRY_TIME_IS_NULL, "retry for Throwable, but retain retry time is NULL, last error is" + e3.getErrorMsg()));
                            } else if (this.downloadInfo.trySwitchToNextBackupUrl()) {
                                this.downloadInfo.setStatus(5);
                                this.retainRetryTimes.set(this.downloadInfo.getRetryCount());
                                this.downloadInfo.updateCurRetryTime(this.retainRetryTimes.get());
                            } else {
                                onError(new com.ss.android.socialbase.downloader.exception.BaseException(1018, java.lang.String.format("retry for Throwable, but retry Time %s all used, last error is %s", java.lang.String.valueOf(this.downloadInfo.getRetryCount()), e3.getErrorMsg())));
                            }
                            closeConnection();
                        }
                    } catch (java.lang.Throwable th2) {
                        closeConnection();
                        throw th2;
                    }
                }
                if (downloadSegments()) {
                    com.ss.android.socialbase.downloader.logger.Logger.i(TAG, "downloadSegments return");
                    closeConnection();
                    return;
                }
                java.lang.String connectionUrl = this.downloadInfo.getConnectionUrl();
                if (checkIsStoppedByUser()) {
                    closeConnection();
                    return;
                }
                long firstOffset = this.canResumeFromCache ? com.ss.android.socialbase.downloader.utils.DownloadUtils.getFirstOffset(this.downloadInfo) : 0L;
                com.ss.android.socialbase.downloader.model.DownloadChunk createFirstDownloadChunk = createFirstDownloadChunk(this.downloadInfo, firstOffset);
                java.util.List<com.ss.android.socialbase.downloader.model.HttpHeader> extraHeaders = getExtraHeaders(createFirstDownloadChunk);
                com.ss.android.socialbase.downloader.utils.DownloadUtils.addThrottleNetSpeed(extraHeaders, this.downloadInfo);
                com.ss.android.socialbase.downloader.utils.DownloadUtils.addTTNetProtectTimeout(extraHeaders, this.downloadInfo);
                this.downloadInfo.setPreconnectLevel(0);
                long currentTimeMillis2 = java.lang.System.currentTimeMillis();
                try {
                    doFirstConnect(connectionUrl, extraHeaders, firstOffset);
                    this.downloadInfo.increaseAllConnectTime(java.lang.System.currentTimeMillis() - currentTimeMillis2);
                    if (checkIsStoppedByUser()) {
                        closeConnection();
                        return;
                    }
                    long totalBytes = this.downloadInfo.getTotalBytes();
                    checkSpaceOverflow(totalBytes);
                    int calculateChunkCount = calculateChunkCount(totalBytes, downloadChunk);
                    if (checkIsStoppedByUser()) {
                        closeConnection();
                        return;
                    }
                    if (calculateChunkCount <= 0) {
                        throw new com.ss.android.socialbase.downloader.exception.BaseException(1032, "chunkCount is 0");
                    }
                    boolean z2 = calculateChunkCount == 1;
                    this.isSingleChunk = z2;
                    if (z2) {
                        if (this.firstGetConnection == null) {
                            try {
                                currentTimeMillis2 = java.lang.System.currentTimeMillis();
                                createFirstGetConnection(connectionUrl, extraHeaders);
                                this.downloadInfo.increaseAllConnectTime(java.lang.System.currentTimeMillis() - currentTimeMillis2);
                            } finally {
                            }
                        }
                        if (checkIsStoppedByUser()) {
                            closeConnection();
                            return;
                        } else {
                            this.downloadInfo.setFirstSpeedTime(java.lang.System.currentTimeMillis() - currentTimeMillis);
                            resetRetainRetryTimes();
                            handleResponseWithSingleChunk(createFirstDownloadChunk, connectionUrl, this.firstGetConnection);
                        }
                    } else {
                        if (!this.downloadInfo.isNeedReuseFirstConnection()) {
                            closeFirstConnection();
                        }
                        if (checkIsStoppedByUser()) {
                            closeConnection();
                            return;
                        }
                        resetRetainRetryTimes();
                        this.downloadInfo.setFirstSpeedTime(java.lang.System.currentTimeMillis() - currentTimeMillis);
                        if (this.canResumeFromCache) {
                            handleResponseWithMultiChunkFromResume(calculateChunkCount, downloadChunk);
                        } else {
                            handleResponseMultiChunkFromBegin(totalBytes, calculateChunkCount);
                        }
                    }
                    closeConnection();
                    return;
                } finally {
                }
            }
        } finally {
            endDownloadRunnable();
        }
    }

    private boolean downloadSegments() throws com.ss.android.socialbase.downloader.exception.BaseException, java.lang.InterruptedException {
        if (this.downloadInfo.isExpiredRedownload() || this.downloadInfo.getChunkCount() != 1 || this.downloadInfo.getThrottleNetSpeed() > 0) {
            return false;
        }
        org.json.JSONObject optJSONObject = com.ss.android.socialbase.downloader.setting.DownloadSetting.obtain(this.downloadInfo.getId()).optJSONObject(com.ss.android.socialbase.downloader.setting.DownloadSettingKeys.SEGMENT_CONFIG);
        java.util.List<com.ss.android.socialbase.downloader.segment.Segment> segments = this.downloadCache.getSegments(this.downloadInfo.getId());
        if (this.downloadInfo.getCurBytes() > 0) {
            if (segments == null || segments.isEmpty()) {
                return false;
            }
            if (optJSONObject == null) {
                optJSONObject = new org.json.JSONObject();
            }
        }
        if (optJSONObject == null) {
            return false;
        }
        this.segmentDispatcher = new com.ss.android.socialbase.downloader.segment.SegmentDispatcher(this.downloadInfo, com.ss.android.socialbase.downloader.segment.SegmentStrategy.from(optJSONObject), this);
        if (!checkIsStoppedByUser()) {
            return this.segmentDispatcher.downloadSegments(segments);
        }
        com.ss.android.socialbase.downloader.logger.Logger.i(TAG, "downloadSegments: is stopped by user");
        if (this.runStatus == com.ss.android.socialbase.downloader.constants.RunStatus.RUN_STATUS_CANCELED) {
            this.segmentDispatcher.cancel();
        } else {
            this.segmentDispatcher.pause();
        }
        return true;
    }

    private void endDownloadRunnable() {
        boolean z;
        boolean z2;
        com.ss.android.socialbase.downloader.logger.Logger.d(TAG, "endDownloadRunnable::runStatus=" + this.runStatus);
        boolean z3 = (this.runStatus == com.ss.android.socialbase.downloader.constants.RunStatus.RUN_STATUS_PAUSE || this.runStatus == com.ss.android.socialbase.downloader.constants.RunStatus.RUN_STATUS_CANCELED) ? false : true;
        try {
            z = doTaskStatusHandle();
            z2 = false;
        } catch (java.lang.Exception e) {
            if (e instanceof com.ss.android.socialbase.downloader.exception.BaseException) {
                this.statusHandler.onError((com.ss.android.socialbase.downloader.exception.BaseException) e);
            } else {
                this.statusHandler.onError(new com.ss.android.socialbase.downloader.exception.BaseException(com.ss.android.socialbase.downloader.constants.DownloadErrorCode.ERROR_DOWNLOAD_FINALLY_UNKNOWN, e));
            }
            z = true;
            z2 = true;
        }
        if (!z && !z2) {
            this.needJumpToStart = true;
            com.ss.android.socialbase.downloader.logger.Logger.d(TAG, "jump to restart");
            return;
        }
        this.isAlive.set(false);
        if (z3) {
            try {
                com.ss.android.socialbase.downloader.impls.AbsDownloadEngine downloadEngine = com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.getDownloadEngine();
                if (downloadEngine != null) {
                    downloadEngine.removeDownloadRunnable(this);
                }
            } catch (java.lang.Throwable th) {
                th.printStackTrace();
                com.ss.android.socialbase.downloader.depend.IDownloadMonitorDepend monitorDepend = this.downloadTask.getMonitorDepend();
                com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo = this.downloadInfo;
                com.ss.android.socialbase.downloader.exception.BaseException baseException = new com.ss.android.socialbase.downloader.exception.BaseException(1014, com.ss.android.socialbase.downloader.utils.DownloadUtils.getErrorMsgWithTagPrefix(th, "removeDownloadRunnable"));
                com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo2 = this.downloadInfo;
                com.ss.android.socialbase.downloader.monitor.DownloadMonitorHelper.monitorSendWithTaskMonitor(monitorDepend, downloadInfo, baseException, downloadInfo2 != null ? downloadInfo2.getStatus() : 0);
            }
        }
    }

    private void finishWithFileExist() {
        com.ss.android.socialbase.downloader.logger.Logger.d(TAG, "finishWithFileExist");
        if (com.ss.android.socialbase.downloader.setting.DownloadSetting.obtainGlobal().optBugFix(com.ss.android.socialbase.downloader.setting.DownloadSettingKeys.BugFix.FIX_END_FOR_FILE_EXIST_ERROR, true)) {
            if (this.existTargetFileName.equals(this.downloadInfo.getName())) {
                this.runStatus = com.ss.android.socialbase.downloader.constants.RunStatus.RUN_STATUS_END_RIGHT_NOW;
                return;
            } else {
                this.runStatus = com.ss.android.socialbase.downloader.constants.RunStatus.RUN_STATUS_END_FOR_FILE_EXIST;
                return;
            }
        }
        if (this.existTargetFileName.equals(this.downloadInfo.getTargetFilePath())) {
            this.runStatus = com.ss.android.socialbase.downloader.constants.RunStatus.RUN_STATUS_END_RIGHT_NOW;
        } else {
            this.runStatus = com.ss.android.socialbase.downloader.constants.RunStatus.RUN_STATUS_END_FOR_FILE_EXIST;
        }
    }

    private long getDelayTime() {
        return this.retryDelayTimeCalculator.calculateRetryDelayTime(this.downloadInfo.getCurRetryTimeInTotal(), this.downloadInfo.getTotalRetryCount());
    }

    private java.util.List<com.ss.android.socialbase.downloader.model.HttpHeader> getExtraHeaders(com.ss.android.socialbase.downloader.model.DownloadChunk downloadChunk) {
        java.util.List<com.ss.android.socialbase.downloader.model.HttpHeader> addRangeHeader = com.ss.android.socialbase.downloader.utils.DownloadUtils.addRangeHeader(this.downloadInfo.getExtraHeaders(), this.downloadInfo.geteTag(), downloadChunk);
        if (this.downloadInfo.isExpiredRedownload() && this.needCheckIfModified && this.downloadInfo.getLastModified() != null) {
            addRangeHeader.add(new com.ss.android.socialbase.downloader.model.HttpHeader(com.ss.android.socialbase.downloader.utils.DownloadUtils.IF_MODIFIED_SINCE, this.downloadInfo.getLastModified()));
            addRangeHeader.add(new com.ss.android.socialbase.downloader.model.HttpHeader(com.ss.android.socialbase.downloader.utils.DownloadUtils.HEADER_TAG_DOWNLOAD_CACHE, com.ss.android.socialbase.downloader.utils.DownloadUtils.HEADER_TAG_DOWNLOAD_CACHE));
            com.ss.android.socialbase.downloader.logger.Logger.d(TAG, "dcache::add head IF_MODIFIED_SINCE=" + this.downloadInfo.getLastModified());
        }
        return addRangeHeader;
    }

    private com.ss.android.socialbase.downloader.downloader.IRetryDelayTimeCalculator getRetryDelayTimeCalculator(com.ss.android.socialbase.downloader.model.DownloadTask downloadTask) {
        com.ss.android.socialbase.downloader.downloader.IRetryDelayTimeCalculator retryDelayTimeCalculator = downloadTask.getRetryDelayTimeCalculator();
        if (retryDelayTimeCalculator != null) {
            return retryDelayTimeCalculator;
        }
        com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo = downloadTask.getDownloadInfo();
        if (downloadInfo != null) {
            java.lang.String retryDelayTimeArray = downloadInfo.getRetryDelayTimeArray();
            if (!android.text.TextUtils.isEmpty(retryDelayTimeArray)) {
                return new com.ss.android.socialbase.downloader.impls.RetryDelayTimeParamCalculator(retryDelayTimeArray);
            }
        }
        return com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.getRetryDelayTimeCalculator();
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00e0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private com.ss.android.socialbase.downloader.model.DownloadChunk getUnCompletedSubChunk(com.ss.android.socialbase.downloader.model.DownloadChunk downloadChunk, int i) {
        boolean z;
        int i2;
        com.ss.android.socialbase.downloader.model.DownloadChunk downloadChunk2 = null;
        if (!downloadChunk.isHostChunk()) {
            return null;
        }
        long retainLength = downloadChunk.getRetainLength(true);
        com.ss.android.socialbase.downloader.logger.Logger.d(TAG, "reuseChunk retainLen:" + retainLength + " chunkIndex:" + i);
        if (!downloadChunk.hasChunkDivided() && retainLength > com.ss.android.socialbase.downloader.constants.DownloadConstants.MIN_CHUNK_REUSE_SIZE && this.downloadInfo.isNeedReuseChunkRunnable()) {
            java.util.List<com.ss.android.socialbase.downloader.model.DownloadChunk> divideChunkForReuse = downloadChunk.divideChunkForReuse(this.downloadInfo.getChunkCount(), this.downloadInfo.getTotalBytes());
            if (divideChunkForReuse != null) {
                java.util.Iterator<com.ss.android.socialbase.downloader.model.DownloadChunk> it = divideChunkForReuse.iterator();
                while (it.hasNext()) {
                    this.downloadCache.addSubDownloadChunk(it.next());
                }
            }
        } else if (!downloadChunk.hasChunkDivided()) {
            z = false;
            if (z && downloadChunk.hasChunkDivided()) {
                for (i2 = 1; i2 < downloadChunk.getSubChunkList().size(); i2++) {
                    com.ss.android.socialbase.downloader.model.DownloadChunk downloadChunk3 = downloadChunk.getSubChunkList().get(i2);
                    if (downloadChunk3 != null) {
                        com.ss.android.socialbase.downloader.logger.Logger.d(TAG, "check can checkUnCompletedChunk -- chunkIndex:" + downloadChunk3.getChunkIndex() + " currentOffset:" + downloadChunk3.getCurrentOffset() + "  startOffset:" + downloadChunk3.getStartOffset() + " contentLen:" + downloadChunk3.getContentLength());
                        if (downloadChunk3.getChunkIndex() < 0 || (!downloadChunk3.hasNoBytesDownload() && !downloadChunk3.isDownloading())) {
                            downloadChunk2 = downloadChunk3;
                            break;
                        }
                    }
                }
                if (downloadChunk2 != null) {
                    long currentOffset = downloadChunk.getCurrentOffset();
                    com.ss.android.socialbase.downloader.logger.Logger.d(TAG, "unComplete chunk " + downloadChunk.getChunkIndex() + " curOffset:" + currentOffset + " reuseChunk chunkIndex:" + i + " for subChunk:" + downloadChunk2.getChunkIndex());
                    this.downloadCache.updateSubDownloadChunkIndex(downloadChunk2.getId(), downloadChunk2.getChunkIndex(), downloadChunk2.getHostChunkIndex(), i);
                    downloadChunk2.setChunkIndex(i);
                    downloadChunk2.setDownloading(true);
                }
            }
            return downloadChunk2;
        }
        z = true;
        if (z) {
            while (i2 < downloadChunk.getSubChunkList().size()) {
            }
            if (downloadChunk2 != null) {
            }
        }
        return downloadChunk2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleDiskSpaceCallback() {
        com.ss.android.socialbase.downloader.impls.AbsDownloadEngine downloadEngine;
        if (checkIsStoppedByUser() || (downloadEngine = com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.getDownloadEngine()) == null) {
            return;
        }
        downloadEngine.restartAsyncWaitingTask(this.downloadInfo.getId());
    }

    private void handleFirstResponse() throws com.ss.android.socialbase.downloader.exception.BaseException {
        if (this.firstHttpResponseHandler != null) {
            if (this.runStatus == com.ss.android.socialbase.downloader.constants.RunStatus.RUN_STATUS_CANCELED) {
                this.downloadInfo.setStatus(-4);
                this.firstHttpResponseHandler.cancel();
            } else if (this.runStatus != com.ss.android.socialbase.downloader.constants.RunStatus.RUN_STATUS_PAUSE) {
                this.firstHttpResponseHandler.handleResponse();
            } else {
                this.downloadInfo.setStatus(-2);
                this.firstHttpResponseHandler.pause();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleForbiddenCallback(java.util.List<java.lang.String> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        this.downloadInfo.setForbiddenBackupUrls(list, this.runStatus == com.ss.android.socialbase.downloader.constants.RunStatus.RUN_STATUS_WAITING_ASYNC_HANDLER);
        com.ss.android.socialbase.downloader.impls.AbsDownloadEngine downloadEngine = com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.getDownloadEngine();
        if (downloadEngine != null) {
            downloadEngine.restartAsyncWaitingTask(this.downloadInfo.getId());
        }
    }

    private void handleResponseCodeError(java.lang.String str, java.lang.String str2) throws com.ss.android.socialbase.downloader.exception.RetryThrowable {
        this.downloadCache.removeAllDownloadChunk(this.downloadInfo.getId());
        this.downloadCache.removeSegments(this.downloadInfo.getId());
        com.ss.android.socialbase.downloader.utils.DownloadUtils.deleteAllDownloadFiles(this.downloadInfo);
        this.canResumeFromCache = false;
        this.downloadInfo.resetDataForEtagEndure(str);
        this.downloadCache.updateDownloadInfo(this.downloadInfo);
        throw new com.ss.android.socialbase.downloader.exception.RetryThrowable(str2);
    }

    private void handleResponseMultiChunkFromBegin(long j, int i) throws com.ss.android.socialbase.downloader.exception.BaseException {
        long j2 = j / i;
        int id = this.downloadInfo.getId();
        java.util.ArrayList arrayList = new java.util.ArrayList();
        int i2 = 0;
        long j3 = 0;
        while (i2 < i) {
            com.ss.android.socialbase.downloader.model.DownloadChunk build = new com.ss.android.socialbase.downloader.model.DownloadChunk.Builder(id).chunkIndex(i2).startOffset(j3).oldOffset(j3).currentOffset(j3).endOffset(i2 == i + (-1) ? 0L : (j3 + j2) - 1).build();
            arrayList.add(build);
            this.downloadCache.addDownloadChunk(build);
            j3 += j2;
            i2++;
        }
        this.downloadInfo.setChunkCount(i);
        this.downloadCache.updateChunkCount(id, i);
        handleResponseWithMultiChunk(arrayList, j);
    }

    private void handleResponseWithMultiChunk(java.util.List<com.ss.android.socialbase.downloader.model.DownloadChunk> list, long j) throws com.ss.android.socialbase.downloader.exception.BaseException {
        for (com.ss.android.socialbase.downloader.model.DownloadChunk downloadChunk : list) {
            if (downloadChunk != null) {
                long currentOffset = downloadChunk.getEndOffset() == 0 ? j - downloadChunk.getCurrentOffset() : (downloadChunk.getEndOffset() - downloadChunk.getCurrentOffset()) + 1;
                if (currentOffset > 0) {
                    downloadChunk.setContentLength(currentOffset);
                    if (!this.downloadInfo.isNeedReuseFirstConnection() || this.firstGetConnection == null || (this.downloadInfo.isHeadConnectionAvailable() && !this.firstHeadConnectionFailed)) {
                        this.downloadChunkRunnableList.add(new com.ss.android.socialbase.downloader.thread.DownloadChunkRunnable(downloadChunk, this.downloadTask, this));
                    } else if (downloadChunk.getChunkIndex() == 0) {
                        this.downloadChunkRunnableList.add(new com.ss.android.socialbase.downloader.thread.DownloadChunkRunnable(downloadChunk, this.downloadTask, this.firstGetConnection, this));
                    } else if (downloadChunk.getChunkIndex() > 0) {
                        this.downloadChunkRunnableList.add(new com.ss.android.socialbase.downloader.thread.DownloadChunkRunnable(downloadChunk, this.downloadTask, this));
                    }
                }
            }
        }
        if (!com.ss.android.socialbase.downloader.utils.DownloadExpSwitchCode.isSwitchEnable(64)) {
            java.util.ArrayList arrayList = new java.util.ArrayList(this.downloadChunkRunnableList.size());
            java.util.Iterator<com.ss.android.socialbase.downloader.thread.DownloadChunkRunnable> it = this.downloadChunkRunnableList.iterator();
            while (it.hasNext()) {
                com.ss.android.socialbase.downloader.thread.DownloadChunkRunnable next = it.next();
                if (this.runStatus == com.ss.android.socialbase.downloader.constants.RunStatus.RUN_STATUS_CANCELED) {
                    next.cancel();
                } else if (this.runStatus == com.ss.android.socialbase.downloader.constants.RunStatus.RUN_STATUS_PAUSE) {
                    next.pause();
                } else {
                    arrayList.add(java.util.concurrent.Executors.callable(next));
                }
            }
            if (checkIsStoppedByUser()) {
                return;
            }
            try {
                com.ss.android.socialbase.downloader.impls.DefaultDownloadEngine.invokeFutureTasks(arrayList);
                return;
            } catch (java.lang.InterruptedException e) {
                throw new com.ss.android.socialbase.downloader.exception.BaseException(1020, e);
            }
        }
        java.util.ArrayList arrayList2 = new java.util.ArrayList(this.downloadChunkRunnableList.size());
        java.util.Iterator<com.ss.android.socialbase.downloader.thread.DownloadChunkRunnable> it2 = this.downloadChunkRunnableList.iterator();
        while (it2.hasNext()) {
            com.ss.android.socialbase.downloader.thread.DownloadChunkRunnable next2 = it2.next();
            if (this.runStatus == com.ss.android.socialbase.downloader.constants.RunStatus.RUN_STATUS_CANCELED) {
                next2.cancel();
            } else if (this.runStatus == com.ss.android.socialbase.downloader.constants.RunStatus.RUN_STATUS_PAUSE) {
                next2.pause();
            } else {
                arrayList2.add(next2);
            }
        }
        try {
            java.util.List<java.util.concurrent.Future> executeFutureTasks = com.ss.android.socialbase.downloader.impls.DefaultDownloadEngine.executeFutureTasks(arrayList2);
            for (java.lang.Runnable runnable = (java.lang.Runnable) arrayList2.remove(0); runnable != null; runnable = com.ss.android.socialbase.downloader.impls.DefaultDownloadEngine.getUnstartedTask(executeFutureTasks)) {
                if (checkIsStoppedByUser()) {
                    return;
                }
                try {
                    runnable.run();
                } catch (java.lang.Throwable th) {
                    th.printStackTrace();
                }
            }
            if (executeFutureTasks == null || executeFutureTasks.isEmpty()) {
                return;
            }
            for (java.util.concurrent.Future future : executeFutureTasks) {
                if (future != null && !future.isDone()) {
                    try {
                        future.get();
                    } catch (java.lang.Throwable unused) {
                    }
                }
            }
        } catch (java.lang.Throwable unused2) {
        }
    }

    private void handleResponseWithMultiChunkFromResume(int i, java.util.List<com.ss.android.socialbase.downloader.model.DownloadChunk> list) throws com.ss.android.socialbase.downloader.exception.BaseException {
        if (list.size() != i) {
            throw new com.ss.android.socialbase.downloader.exception.BaseException(com.ss.android.socialbase.downloader.constants.DownloadErrorCode.ERROR_CHUNK_NOT_EQUALS_CACHE, new java.lang.IllegalArgumentException());
        }
        handleResponseWithMultiChunk(list, this.downloadInfo.getTotalBytes());
    }

    private void handleResponseWithSingleChunk(com.ss.android.socialbase.downloader.model.DownloadChunk downloadChunk, java.lang.String str, com.ss.android.socialbase.downloader.network.IDownloadHttpConnection iDownloadHttpConnection) throws com.ss.android.socialbase.downloader.exception.BaseException {
        downloadChunk.setContentLength(this.downloadInfo.getTotalBytes() - downloadChunk.getCurrentOffset());
        this.downloadInfo.setChunkCount(1);
        this.downloadCache.updateChunkCount(this.downloadInfo.getId(), 1);
        this.firstHttpResponseHandler = new com.ss.android.socialbase.downloader.downloader.DownloadResponseHandler(this.downloadInfo, str, iDownloadHttpConnection, downloadChunk, this);
        handleFirstResponse();
    }

    private boolean handleRetryTime(com.ss.android.socialbase.downloader.exception.BaseException baseException) {
        java.util.concurrent.atomic.AtomicInteger atomicInteger = this.retainRetryTimes;
        boolean z = true;
        if (atomicInteger == null) {
            onError(new com.ss.android.socialbase.downloader.exception.BaseException(com.ss.android.socialbase.downloader.constants.DownloadErrorCode.ERROR_RETAIN_RETRY_TIME_IS_NULL, "retry for exception, but retain retry time is null, last error is :" + baseException.getErrorMessage()));
            return true;
        }
        if (atomicInteger.get() <= 0 || (baseException != null && baseException.getErrorCode() == 1070)) {
            if (this.downloadInfo.trySwitchToNextBackupUrl()) {
                this.retainRetryTimes.set(this.downloadInfo.getBackUpUrlRetryCount());
                this.downloadInfo.updateCurRetryTime(this.retainRetryTimes.get());
            } else {
                if (baseException == null || ((baseException.getErrorCode() != 1011 && (baseException.getCause() == null || !(baseException.getCause() instanceof javax.net.ssl.SSLHandshakeException))) || !this.downloadInfo.canReplaceHttpForRetry())) {
                    onError(new com.ss.android.socialbase.downloader.exception.BaseException(baseException.getErrorCode(), java.lang.String.format("retry for exception, but current retry time : %s , retry Time %s all used, last error is %s", java.lang.String.valueOf(this.retainRetryTimes), java.lang.String.valueOf(this.downloadInfo.getRetryCount()), baseException.getErrorMessage())));
                    return true;
                }
                this.retainRetryTimes.set(this.downloadInfo.getRetryCount());
                this.downloadInfo.updateCurRetryTime(this.retainRetryTimes.get());
                this.downloadInfo.setHttpsToHttpRetryUsed(true);
            }
            z = false;
        }
        if (this.runStatus != com.ss.android.socialbase.downloader.constants.RunStatus.RUN_STATUS_RETRY_DELAY && z) {
            this.downloadInfo.updateCurRetryTime(this.retainRetryTimes.decrementAndGet());
        }
        return false;
    }

    private boolean isAllChunkDownloadComplete() {
        if (this.downloadInfo.getChunkCount() <= 1) {
            return this.downloadInfo.getCurBytes() > 0 && this.downloadInfo.getCurBytes() == this.downloadInfo.getTotalBytes();
        }
        java.util.List<com.ss.android.socialbase.downloader.model.DownloadChunk> downloadChunk = this.downloadCache.getDownloadChunk(this.downloadInfo.getId());
        if (downloadChunk == null || downloadChunk.size() <= 1) {
            return false;
        }
        for (com.ss.android.socialbase.downloader.model.DownloadChunk downloadChunk2 : downloadChunk) {
            if (downloadChunk2 == null || !downloadChunk2.hasNoBytesDownload()) {
                return false;
            }
        }
        return true;
    }

    private boolean isMultiChunkDownloadAvailable() {
        com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo = this.downloadInfo;
        return (downloadInfo == null || downloadInfo.isExpiredRedownload() || (this.canResumeFromCache && this.downloadInfo.getChunkCount() <= 1) || this.downloadInfo.isChunkDowngradeRetryUsed() || !this.acceptPartial || this.isChunked) ? false : true;
    }

    private boolean isResponseCodeError(int i, java.lang.String str, java.lang.String str2) {
        if (i == 412) {
            return true;
        }
        if (android.text.TextUtils.isEmpty(str) || android.text.TextUtils.isEmpty(str2) || str.equals(str2) || !(this.isResponseFromBegin || this.acceptPartial)) {
            return (i == 201 || i == 416) && this.downloadInfo.getCurBytes() > 0;
        }
        return true;
    }

    private boolean isStoppedStatus() {
        return this.runStatus == com.ss.android.socialbase.downloader.constants.RunStatus.RUN_STATUS_CANCELED || this.runStatus == com.ss.android.socialbase.downloader.constants.RunStatus.RUN_STATUS_PAUSE;
    }

    private void resetRetainRetryTimes() {
        if (com.ss.android.socialbase.downloader.setting.DownloadSetting.obtain(this.downloadInfo.getId()).optInt(com.ss.android.socialbase.downloader.setting.DownloadSettingKeys.RESET_RETAIN_RETRY_TIMES, 0) != 1 || this.resetRetainRetryTimesCount >= 3) {
            return;
        }
        this.retainRetryTimes.set(this.downloadInfo.isBackUpUrlUsed() ? this.downloadInfo.getBackUpUrlRetryCount() : this.downloadInfo.getRetryCount());
        this.resetRetainRetryTimesCount++;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0058 A[LOOP:0: B:26:0x0058->B:41:0x0058, LOOP_START] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void runInner() {
        android.os.Process.setThreadPriority(10);
        try {
            com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo = this.downloadInfo;
            if (downloadInfo != null && this.prepareDownloadTime > 0) {
                downloadInfo.increaseDownloadPrepareTime(java.lang.System.currentTimeMillis() - this.prepareDownloadTime);
            }
        } catch (java.lang.Throwable unused) {
        }
        try {
            com.ss.android.socialbase.downloader.depend.IDownloadInterceptor interceptor = this.downloadTask.getInterceptor();
            if (interceptor != null) {
                if (interceptor.intercepte()) {
                    this.statusHandler.onIntercept();
                    return;
                }
            }
        } finally {
            if (checkTaskStatusValid()) {
            }
        }
        if (checkTaskStatusValid()) {
            com.ss.android.socialbase.downloader.depend.IDownloadMonitorDepend monitorDepend = this.downloadTask.getMonitorDepend();
            com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo2 = this.downloadInfo;
            com.ss.android.socialbase.downloader.exception.BaseException baseException = new com.ss.android.socialbase.downloader.exception.BaseException(1003, "task status is invalid");
            com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo3 = this.downloadInfo;
            com.ss.android.socialbase.downloader.monitor.DownloadMonitorHelper.monitorSendWithTaskMonitor(monitorDepend, downloadInfo2, baseException, downloadInfo3 != null ? downloadInfo3.getStatus() : 0);
            return;
        }
        while (true) {
            downloadInner();
            if (!this.needJumpToStart) {
                return;
            }
            if (this.bytesRetryCount > 0) {
                this.bytesRetryCount--;
            } else {
                if (this.downloadInfo.getCurBytes() != this.downloadInfo.getTotalBytes()) {
                    com.ss.android.socialbase.downloader.logger.Logger.d(TAG, this.downloadInfo.getErrorBytesLog());
                    this.statusHandler.onError(new com.ss.android.socialbase.downloader.exception.DownloadRetryNeedlessException(1027, "current bytes is not equals to total bytes, bytes invalid retry status is : " + this.downloadInfo.getByteInvalidRetryStatus()));
                    return;
                }
                if (this.downloadInfo.getCurBytes() <= 0) {
                    com.ss.android.socialbase.downloader.logger.Logger.d(TAG, this.downloadInfo.getErrorBytesLog());
                    this.statusHandler.onError(new com.ss.android.socialbase.downloader.exception.DownloadRetryNeedlessException(1026, "curBytes is 0, bytes invalid retry status is : " + this.downloadInfo.getByteInvalidRetryStatus()));
                    return;
                }
                if (this.downloadInfo.getTotalBytes() <= 0) {
                    com.ss.android.socialbase.downloader.logger.Logger.d(TAG, this.downloadInfo.getErrorBytesLog());
                    this.statusHandler.onError(new com.ss.android.socialbase.downloader.exception.DownloadRetryNeedlessException(com.ss.android.socialbase.downloader.constants.DownloadErrorCode.ERROR_TOTAL_BYTES_ZERO, "TotalBytes is 0, bytes invalid retry status is : " + this.downloadInfo.getByteInvalidRetryStatus()));
                    return;
                }
            }
        }
    }

    private void startRetryDelayAlarm() {
        this.runStatus = com.ss.android.socialbase.downloader.constants.RunStatus.RUN_STATUS_NONE;
    }

    private void updateRetainRetryTimes() {
        com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo = this.downloadInfo;
        if (downloadInfo == null) {
            return;
        }
        int retryCount = downloadInfo.getRetryCount() - this.downloadInfo.getCurRetryTime();
        if (retryCount < 0) {
            retryCount = 0;
        }
        java.util.concurrent.atomic.AtomicInteger atomicInteger = this.retainRetryTimes;
        if (atomicInteger == null) {
            this.retainRetryTimes = new java.util.concurrent.atomic.AtomicInteger(retryCount);
        } else {
            atomicInteger.set(retryCount);
        }
    }

    @Override // com.ss.android.socialbase.downloader.thread.IDownloadRunnableCallback
    public boolean canRetry(com.ss.android.socialbase.downloader.exception.BaseException baseException) {
        if (this.segmentDispatcher != null && com.ss.android.socialbase.downloader.utils.DownloadUtils.isNetworkError(baseException) && this.retainRetryTimes.get() < this.downloadInfo.getRetryCount()) {
            return false;
        }
        if (!com.ss.android.socialbase.downloader.utils.DownloadUtils.isResponseCodeError(baseException)) {
            java.util.concurrent.atomic.AtomicInteger atomicInteger = this.retainRetryTimes;
            return ((atomicInteger != null && atomicInteger.get() > 0) || this.downloadInfo.hasNextBackupUrl() || (baseException != null && ((baseException.getErrorCode() == 1011 || (baseException.getCause() != null && (baseException.getCause() instanceof javax.net.ssl.SSLHandshakeException))) && this.downloadInfo.canReplaceHttpForRetry()))) && !(baseException instanceof com.ss.android.socialbase.downloader.exception.DownloadRetryNeedlessException);
        }
        if (this.isSingleChunk && !this.isTriedFixRangeNotSatisfiable) {
            com.ss.android.socialbase.downloader.utils.DownloadUtils.deleteAllDownloadFiles(this.downloadInfo);
            this.isTriedFixRangeNotSatisfiable = true;
        }
        return true;
    }

    public void cancel() {
        com.ss.android.socialbase.downloader.constants.RunStatus runStatus = com.ss.android.socialbase.downloader.constants.RunStatus.RUN_STATUS_CANCELED;
        this.runStatus = runStatus;
        if (this.segmentDispatcher != null) {
            this.segmentDispatcher.cancel();
        }
        if (this.firstHttpResponseHandler != null) {
            this.firstHttpResponseHandler.cancel();
        }
        if (this.segmentDispatcher == null && this.firstHttpResponseHandler == null) {
            closeConnection();
            this.runStatus = runStatus;
            endDownloadRunnable();
        }
        cancelAllChunkRunnable();
    }

    /* JADX WARN: Can't wrap try/catch for region: R(11:6|7|8|(4:10|(1:12)|13|(2:15|(4:17|(2:19|(1:21)(2:56|57))(1:58)|22|(8:24|(1:26)|27|28|29|30|31|32))(2:59|(6:61|28|29|30|31|32)(4:62|(1:64)(1:67)|65|66))))(2:69|(4:71|(1:73)(1:76)|74|75)(2:77|(2:79|80)))|68|27|28|29|30|31|32) */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0162, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0164, code lost:
    
        com.ss.android.socialbase.downloader.logger.Logger.e(com.ss.android.socialbase.downloader.thread.DownloadRunnable.TAG, "checkSpaceOverflow: setLength1 e = " + r0 + ", mustSetLength = " + r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0183, code lost:
    
        if (r5 >= r24) goto L70;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x018f, code lost:
    
        r7.setLength(r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x0193, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x0195, code lost:
    
        com.ss.android.socialbase.downloader.logger.Logger.e(com.ss.android.socialbase.downloader.thread.DownloadRunnable.TAG, "checkSpaceOverflow: setLength2 ex = " + r0 + ", mustSetLength = " + r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x01ae, code lost:
    
        if (r4 == false) goto L67;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x01b6, code lost:
    
        throw new com.ss.android.socialbase.downloader.exception.BaseException(com.ss.android.socialbase.downloader.constants.DownloadErrorCode.ERROR_OUTPUT_STREAM_SET_LENGTH_IO, r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x01b7, code lost:
    
        if (r4 != false) goto L74;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x01c8, code lost:
    
        throw new com.ss.android.socialbase.downloader.exception.BaseException(com.ss.android.socialbase.downloader.constants.DownloadErrorCode.ERROR_OUTPUT_STREAM_SET_LENGTH_IO, r0);
     */
    @Override // com.ss.android.socialbase.downloader.thread.IDownloadRunnableCallback
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void checkSpaceOverflow(long j) throws com.ss.android.socialbase.downloader.exception.BaseException {
        long j2;
        boolean z;
        long j3;
        java.lang.String tempPath = this.downloadInfo.getTempPath();
        java.lang.String tempName = this.downloadInfo.getTempName();
        if (com.ss.android.socialbase.downloader.utils.DownloadUtils.isChunkedTask(j)) {
            return;
        }
        com.ss.android.socialbase.downloader.model.RandomAccessOutputStream createOutputStream = com.ss.android.socialbase.downloader.utils.DownloadUtils.createOutputStream(this.downloadInfo, tempPath, tempName, -1);
        try {
            long length = new java.io.File(tempPath, tempName).length();
            long j4 = j - length;
            long availableSpaceBytes = com.ss.android.socialbase.downloader.utils.DownloadUtils.getAvailableSpaceBytes(tempPath);
            com.ss.android.socialbase.downloader.setting.DownloadSetting obtain = com.ss.android.socialbase.downloader.setting.DownloadSetting.obtain(this.downloadInfo.getId());
            if (obtain.optInt(com.ss.android.socialbase.downloader.setting.DownloadSettingKeys.SPACE_FILL_PART_DOWNLOAD, 0) == 1) {
                this.curBytesNeedCheckSpaceOverFlow = 0L;
                if (j4 <= 0) {
                    j4 = this.downloadInfo.getTotalBytes() - this.downloadInfo.getCurBytes();
                }
                if (availableSpaceBytes < j4) {
                    java.lang.String str = TAG;
                    com.ss.android.socialbase.downloader.logger.Logger.w(str, "checkSpaceOverflow: contentLength = " + com.ss.android.socialbase.downloader.utils.DownloadUtils.byteToMb(j) + "MB, downloaded = " + com.ss.android.socialbase.downloader.utils.DownloadUtils.byteToMb(length) + "MB, required = " + com.ss.android.socialbase.downloader.utils.DownloadUtils.byteToMb(j4) + "MB, available = " + com.ss.android.socialbase.downloader.utils.DownloadUtils.byteToMb(availableSpaceBytes) + "MB");
                    if (availableSpaceBytes <= 0) {
                        if (obtain.optInt(com.ss.android.socialbase.downloader.setting.DownloadSettingKeys.DOWNLOAD_WHEN_SPACE_NEGATIVE, 0) != 1) {
                            java.lang.StringBuilder sb = new java.lang.StringBuilder("availableSpace ");
                            sb.append(availableSpaceBytes == 0 ? com.huawei.hms.framework.common.ContainerUtils.KEY_VALUE_DELIMITER : "<");
                            sb.append(" 0");
                            throw new com.ss.android.socialbase.downloader.exception.BaseException(com.ss.android.socialbase.downloader.constants.DownloadErrorCode.ERROR_GET_AVAILABLE_SPACE, sb.toString());
                        }
                        j2 = j;
                        z = false;
                        createOutputStream.setLength(j);
                        com.ss.android.socialbase.downloader.utils.DownloadUtils.safeClose(createOutputStream);
                    }
                    int optInt = obtain.optInt(com.ss.android.socialbase.downloader.setting.DownloadSettingKeys.SPACE_FILL_MIN_KEEP_MB, 100);
                    if (optInt > 0) {
                        long j5 = availableSpaceBytes - (optInt * 1048576);
                        com.ss.android.socialbase.downloader.logger.Logger.w(str, "checkSpaceOverflow: minKeep = " + optInt + "MB, canDownload = " + com.ss.android.socialbase.downloader.utils.DownloadUtils.byteToMb(j5) + "MB");
                        if (j5 <= 0) {
                            throw new com.ss.android.socialbase.downloader.exception.DownloadOutOfSpaceException(availableSpaceBytes, j4);
                        }
                        this.curBytesNeedCheckSpaceOverFlow = this.downloadInfo.getCurBytes() + j5;
                        j3 = j5;
                    } else {
                        j3 = availableSpaceBytes;
                    }
                    if (length < j) {
                        j2 = j3 + length;
                        if (j2 > j) {
                        }
                        z = true;
                        createOutputStream.setLength(j);
                        com.ss.android.socialbase.downloader.utils.DownloadUtils.safeClose(createOutputStream);
                    }
                }
            } else {
                if (availableSpaceBytes <= 0) {
                    java.lang.StringBuilder sb2 = new java.lang.StringBuilder("availableSpace ");
                    sb2.append(availableSpaceBytes == 0 ? com.huawei.hms.framework.common.ContainerUtils.KEY_VALUE_DELIMITER : "<");
                    sb2.append(" 0");
                    throw new com.ss.android.socialbase.downloader.exception.BaseException(com.ss.android.socialbase.downloader.constants.DownloadErrorCode.ERROR_GET_AVAILABLE_SPACE, sb2.toString());
                }
                if (availableSpaceBytes < j4) {
                    throw new com.ss.android.socialbase.downloader.exception.DownloadOutOfSpaceException(availableSpaceBytes, j4);
                }
            }
            j2 = j;
            z = true;
            createOutputStream.setLength(j);
            com.ss.android.socialbase.downloader.utils.DownloadUtils.safeClose(createOutputStream);
        } catch (java.lang.Throwable th) {
            com.ss.android.socialbase.downloader.utils.DownloadUtils.safeClose(createOutputStream);
            throw th;
        }
    }

    public int getDownloadId() {
        com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo = this.downloadInfo;
        if (downloadInfo != null) {
            return downloadInfo.getId();
        }
        return 0;
    }

    public com.ss.android.socialbase.downloader.model.DownloadTask getDownloadTask() {
        return this.downloadTask;
    }

    public java.util.concurrent.Future getFuture() {
        return this.mFuture;
    }

    @Override // com.ss.android.socialbase.downloader.thread.IDownloadRunnableCallback
    public synchronized com.ss.android.socialbase.downloader.model.DownloadChunk getUnCompletedSubChunk(int i) {
        com.ss.android.socialbase.downloader.model.DownloadChunk unCompletedSubChunk;
        if (this.downloadInfo.getChunkCount() < 2) {
            return null;
        }
        java.util.List<com.ss.android.socialbase.downloader.model.DownloadChunk> downloadChunk = this.downloadCache.getDownloadChunk(this.downloadInfo.getId());
        if (downloadChunk != null && !downloadChunk.isEmpty()) {
            for (int i2 = 0; i2 < downloadChunk.size(); i2++) {
                com.ss.android.socialbase.downloader.model.DownloadChunk downloadChunk2 = downloadChunk.get(i2);
                if (downloadChunk2 != null && (unCompletedSubChunk = getUnCompletedSubChunk(downloadChunk2, i)) != null) {
                    return unCompletedSubChunk;
                }
            }
            return null;
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:101:0x026b, code lost:
    
        if (r19.setting.optBugFix(com.ss.android.socialbase.downloader.setting.DownloadSettingKeys.BugFix.FIX_GET_TOTAL_BYTES, true) == false) goto L106;
     */
    /* JADX WARN: Code restructure failed: missing block: B:102:0x026d, code lost:
    
        r3 = com.ss.android.socialbase.downloader.utils.DownloadUtils.parseContentRangeOfInstanceLength(r8);
        com.ss.android.socialbase.downloader.logger.Logger.i(r14, "firstConnection: 1 totalLength = " + r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:128:0x0283, code lost:
    
        r12 = r22 + r3;
        com.ss.android.socialbase.downloader.logger.Logger.e(r14, "firstConnection: 2 totalLength = " + r12 + ", contentLength = " + r3);
        r3 = r12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0134, code lost:
    
        com.ss.android.socialbase.downloader.utils.DownloadUtils.deleteAllDownloadFiles(r19.downloadInfo);
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x0245, code lost:
    
        r8 = com.ss.android.socialbase.downloader.utils.DownloadUtils.getRespHeadFieldIgnoreCase(r11, "Content-Range");
        com.ss.android.socialbase.downloader.logger.Logger.i(r14, "firstConnection: contentRange = " + r8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x0260, code lost:
    
        if (android.text.TextUtils.isEmpty(r8) != false) goto L106;
     */
    @Override // com.ss.android.socialbase.downloader.thread.IDownloadRunnableCallback
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void handleFirstConnection(java.lang.String str, com.ss.android.socialbase.downloader.network.IDownloadHeadHttpConnection iDownloadHeadHttpConnection, long j) throws com.ss.android.socialbase.downloader.exception.BaseException, com.ss.android.socialbase.downloader.exception.RetryThrowable {
        com.ss.android.socialbase.downloader.network.IDownloadHeadHttpConnection iDownloadHeadHttpConnection2;
        boolean z;
        if (iDownloadHeadHttpConnection == null) {
            return;
        }
        try {
            com.ss.android.socialbase.downloader.model.HttpResponse httpResponse = new com.ss.android.socialbase.downloader.model.HttpResponse(str, iDownloadHeadHttpConnection);
            int i = httpResponse.responseCode;
            java.lang.String contentType = httpResponse.getContentType();
            if (android.text.TextUtils.isEmpty(this.downloadInfo.getMimeType()) && !android.text.TextUtils.isEmpty(contentType)) {
                this.downloadInfo.setMimeType(contentType);
            }
            boolean acceptPartial = httpResponse.acceptPartial();
            this.acceptPartial = acceptPartial;
            this.downloadInfo.setSupportPartial(acceptPartial);
            this.isResponseFromBegin = httpResponse.isResponseDataFromBegin();
            java.lang.String str2 = this.downloadInfo.geteTag();
            java.lang.String etag = httpResponse.getEtag();
            java.lang.String lastModified = httpResponse.getLastModified();
            java.lang.String cacheControl = httpResponse.getCacheControl();
            java.lang.String str3 = TAG;
            com.ss.android.socialbase.downloader.logger.Logger.d(str3, "dcache=responseCode=" + i + " last_modified=" + lastModified + " CACHE_CONTROL=" + cacheControl + " max-age=" + httpResponse.getMaxAge() + " isDeleteCacheIfCheckFailed=" + this.downloadInfo.isDeleteCacheIfCheckFailed());
            java.lang.StringBuilder sb = new java.lang.StringBuilder("dcache=firstOffset=");
            sb.append(j);
            sb.append(" cur=");
            sb.append(lastModified);
            sb.append(" before=");
            sb.append(this.downloadInfo.getLastModified());
            sb.append(" cur=");
            java.lang.String str4 = etag;
            sb.append(httpResponse.getTotalLength());
            sb.append(" before=");
            sb.append(this.downloadInfo.getTotalBytes());
            com.ss.android.socialbase.downloader.logger.Logger.d(str3, sb.toString());
            if (!android.text.TextUtils.isEmpty(cacheControl)) {
                this.downloadInfo.setCacheControl(cacheControl);
                if (httpResponse.getMaxAge() > 0) {
                    this.downloadInfo.setCacheExpiredTime(java.lang.System.currentTimeMillis() + (httpResponse.getMaxAge() * 1000));
                }
            }
            if (this.downloadInfo.isExpiredRedownload() && this.needCheckIfModified && !android.text.TextUtils.isEmpty(this.existTargetFileName)) {
                if (i != 304) {
                    z = false;
                    if ((!android.text.TextUtils.isEmpty(this.downloadInfo.getLastModified()) || !this.downloadInfo.isDeleteCacheIfCheckFailed()) && android.text.TextUtils.equals(lastModified, this.downloadInfo.getLastModified())) {
                    }
                    com.ss.android.socialbase.downloader.logger.Logger.d(str3, "dcache=responseCode=" + i + " lastModified not changed, use local file  " + lastModified);
                    throw new com.ss.android.socialbase.downloader.exception.DownloadFileExistException(this.existTargetFileName);
                }
                z = true;
                com.ss.android.socialbase.downloader.logger.Logger.d(str3, "dcache=responseCode=" + i + " lastModified not changed, use local file  " + lastModified);
                throw new com.ss.android.socialbase.downloader.exception.DownloadFileExistException(this.existTargetFileName);
            }
            if (j > 0 && this.downloadInfo.isExpiredRedownload() && !android.text.TextUtils.equals(lastModified, this.downloadInfo.getLastModified())) {
                com.ss.android.socialbase.downloader.logger.Logger.d(str3, "dcache cdn file change, so retry");
                handleResponseCodeError("", "cdn file changed");
            }
            if (!android.text.TextUtils.isEmpty(lastModified)) {
                this.downloadInfo.setLastModified(lastModified);
            }
            if (isResponseCodeError(i, str2, str4)) {
                iDownloadHeadHttpConnection2 = iDownloadHeadHttpConnection;
                if (!(iDownloadHeadHttpConnection2 instanceof com.ss.android.socialbase.downloader.network.IDownloadHttpConnection)) {
                    throw new com.ss.android.socialbase.downloader.exception.DownloadHttpException(1002, i, "");
                }
                if (!android.text.TextUtils.isEmpty(str2) && str2.equals(str4)) {
                    str4 = "";
                }
                handleResponseCodeError(str4, "eTag of server file changed");
            } else {
                iDownloadHeadHttpConnection2 = iDownloadHeadHttpConnection;
            }
            if (!this.acceptPartial && !this.isResponseFromBegin) {
                if (i == 403) {
                    throw new com.ss.android.socialbase.downloader.exception.BaseException(com.ss.android.socialbase.downloader.constants.DownloadErrorCode.ERROR_DOWNLOAD_FORBIDDEN, "response code error : 403");
                }
                throw new com.ss.android.socialbase.downloader.exception.DownloadHttpException(1004, i, "response code error : " + i);
            }
            if (this.isResponseFromBegin && j > 0) {
                if (!(iDownloadHeadHttpConnection2 instanceof com.ss.android.socialbase.downloader.network.IDownloadHttpConnection)) {
                    throw new com.ss.android.socialbase.downloader.exception.BaseException(1004, "isResponseFromBegin but firstOffset > 0");
                }
                handleResponseCodeError("", "http head request not support");
            }
            java.lang.String str5 = str4;
            long contentLength = httpResponse.getContentLength();
            if (!(iDownloadHeadHttpConnection2 instanceof com.ss.android.socialbase.downloader.network.IDownloadHttpConnection) && contentLength < 0 && com.ss.android.socialbase.downloader.utils.DownloadSettingsUtils.isOptimizeHeadRequest(this.downloadInfo)) {
                throw new com.ss.android.socialbase.downloader.exception.BaseException(1004, "");
            }
            java.lang.String fileNameFromConnection = android.text.TextUtils.isEmpty(this.downloadInfo.getName()) ? com.ss.android.socialbase.downloader.utils.DownloadUtils.getFileNameFromConnection(iDownloadHeadHttpConnection2, this.downloadInfo.getUrl()) : "";
            boolean isChunked = httpResponse.isChunked();
            this.isChunked = isChunked;
            if (!isChunked && contentLength == 0 && !(iDownloadHeadHttpConnection2 instanceof com.ss.android.socialbase.downloader.network.IDownloadHttpConnection)) {
                throw new com.ss.android.socialbase.downloader.exception.BaseException(1004, "");
            }
            long j2 = -1;
            if (!android.text.TextUtils.isEmpty(this.downloadInfo.getTaskKey()) && this.downloadInfo.getTotalBytes() > 0 && j2 != this.downloadInfo.getTotalBytes()) {
                if (!(iDownloadHeadHttpConnection2 instanceof com.ss.android.socialbase.downloader.network.IDownloadHttpConnection)) {
                    throw new com.ss.android.socialbase.downloader.exception.DownloadHttpException(1002, i, "");
                }
                handleResponseCodeError("", "file totalLength changed");
            }
            if (checkIsStoppedByUser()) {
                return;
            }
            if (this.downloadInfo.getExpectFileLength() > 0 && com.ss.android.socialbase.downloader.setting.DownloadSetting.obtain(this.downloadInfo.getId()).optInt(com.ss.android.socialbase.downloader.setting.DownloadSettingKeys.FORCE_CHECK_FILE_LENGTH) == 1 && this.downloadInfo.getExpectFileLength() != j2) {
                throw new com.ss.android.socialbase.downloader.exception.BaseException(com.ss.android.socialbase.downloader.constants.DownloadErrorCode.ERROR_CHECK_FILE_LENGTH_FAILED, "expectFileLength = " + this.downloadInfo.getExpectFileLength() + " , totalLength = " + j2);
            }
            this.statusHandler.onFirstConnectionSuccessed(j2, str5, fileNameFromConnection);
        } catch (com.ss.android.socialbase.downloader.exception.BaseException e) {
            throw e;
        } catch (com.ss.android.socialbase.downloader.exception.RetryThrowable e2) {
            throw e2;
        } catch (java.lang.Throwable th) {
            com.ss.android.socialbase.downloader.utils.DownloadUtils.parseException(th, "HandleFirstConnection");
        }
    }

    public boolean isAlive() {
        return this.isAlive.get();
    }

    @Override // com.ss.android.socialbase.downloader.thread.IDownloadRunnableCallback
    public void onAllChunkRetryWithReset(com.ss.android.socialbase.downloader.exception.BaseException baseException, boolean z) {
        com.ss.android.socialbase.downloader.logger.Logger.d(TAG, "onAllChunkRetryWithReset");
        this.runStatus = com.ss.android.socialbase.downloader.constants.RunStatus.RUN_STATUS_ALL_CHUNK_RETRY_WITH_RESET;
        this.errorException = baseException;
        cancelAllChunkRunnable();
        if (z ? handleRetryTime(baseException) : false) {
            return;
        }
        clearCurrentDownloadData();
    }

    @Override // com.ss.android.socialbase.downloader.thread.IDownloadRunnableCallback
    public void onChunkDowngradeRetry(com.ss.android.socialbase.downloader.exception.BaseException baseException) {
        com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo = this.downloadInfo;
        if (downloadInfo != null) {
            downloadInfo.setChunkDowngradeRetryUsed(true);
        }
        onAllChunkRetryWithReset(baseException, false);
    }

    @Override // com.ss.android.socialbase.downloader.thread.IDownloadRunnableCallback
    public void onCompleted(com.ss.android.socialbase.downloader.thread.DownloadChunkRunnable downloadChunkRunnable) {
        if (this.isSingleChunk) {
            return;
        }
        synchronized (this) {
            this.downloadChunkRunnableList.remove(downloadChunkRunnable);
        }
    }

    @Override // com.ss.android.socialbase.downloader.thread.IDownloadRunnableCallback
    public void onError(com.ss.android.socialbase.downloader.exception.BaseException baseException) {
        com.ss.android.socialbase.downloader.logger.Logger.d(TAG, "onError:" + baseException.getMessage());
        this.runStatus = com.ss.android.socialbase.downloader.constants.RunStatus.RUN_STATUS_ERROR;
        this.errorException = baseException;
        cancelAllChunkRunnable();
    }

    @Override // com.ss.android.socialbase.downloader.thread.IDownloadRunnableCallback
    public boolean onProgress(long j) throws com.ss.android.socialbase.downloader.exception.BaseException {
        if (this.curBytesNeedCheckSpaceOverFlow > 0 && this.downloadInfo.getCurBytes() > this.curBytesNeedCheckSpaceOverFlow) {
            checkSpaceOverflowInProgress();
        }
        return this.statusHandler.onProgress(j);
    }

    @Override // com.ss.android.socialbase.downloader.thread.IDownloadRunnableCallback
    public com.ss.android.socialbase.downloader.exception.RetryCheckStatus onRetry(com.ss.android.socialbase.downloader.exception.BaseException baseException, long j) {
        long j2;
        long totalBytes;
        boolean z;
        this.errorException = baseException;
        this.downloadInfo.increaseCurBytes(-j);
        this.downloadCache.updateDownloadInfo(this.downloadInfo);
        if (isStoppedStatus()) {
            return com.ss.android.socialbase.downloader.exception.RetryCheckStatus.RETURN;
        }
        if (baseException != null && baseException.getErrorCode() == 1047) {
            if (this.forbiddenHandler != null && !this.downloadInfo.isForbiddenRetryed()) {
                com.ss.android.socialbase.downloader.thread.DownloadRunnable.AnonymousClass1 anonymousClass1 = new com.ss.android.socialbase.downloader.thread.DownloadRunnable.AnonymousClass1();
                boolean onForbidden = this.forbiddenHandler.onForbidden(anonymousClass1);
                this.downloadInfo.setForbiddenRetryed();
                if (onForbidden) {
                    if (!anonymousClass1.hasCallback()) {
                        cancelAllChunkRunnable();
                        this.statusHandler.handleWaitingAsyncHandler();
                        this.runStatus = com.ss.android.socialbase.downloader.constants.RunStatus.RUN_STATUS_WAITING_ASYNC_HANDLER;
                        return com.ss.android.socialbase.downloader.exception.RetryCheckStatus.RETURN;
                    }
                    z = true;
                }
            } else if (handleRetryTime(baseException)) {
                return com.ss.android.socialbase.downloader.exception.RetryCheckStatus.RETURN;
            }
            z = false;
        } else if (!com.ss.android.socialbase.downloader.utils.DownloadUtils.isInsufficientSpaceError(baseException)) {
            if (handleRetryTime(baseException)) {
                return com.ss.android.socialbase.downloader.exception.RetryCheckStatus.RETURN;
            }
            z = false;
        } else {
            if (this.diskSpaceHandler == null) {
                onError(baseException);
                return com.ss.android.socialbase.downloader.exception.RetryCheckStatus.RETURN;
            }
            java.util.concurrent.atomic.AtomicBoolean atomicBoolean = new java.util.concurrent.atomic.AtomicBoolean(false);
            com.ss.android.socialbase.downloader.thread.DownloadRunnable.AnonymousClass2 anonymousClass2 = new com.ss.android.socialbase.downloader.thread.DownloadRunnable.AnonymousClass2(atomicBoolean);
            if (baseException instanceof com.ss.android.socialbase.downloader.exception.DownloadOutOfSpaceException) {
                com.ss.android.socialbase.downloader.exception.DownloadOutOfSpaceException downloadOutOfSpaceException = (com.ss.android.socialbase.downloader.exception.DownloadOutOfSpaceException) baseException;
                j2 = downloadOutOfSpaceException.getAvaliableSpaceBytes();
                totalBytes = downloadOutOfSpaceException.getRequiredSpaceBytes();
            } else {
                j2 = -1;
                totalBytes = this.downloadInfo.getTotalBytes();
            }
            synchronized (this) {
                if (!this.diskSpaceHandler.cleanUpDisk(j2, totalBytes, anonymousClass2)) {
                    if (this.runStatus == com.ss.android.socialbase.downloader.constants.RunStatus.RUN_STATUS_WAITING_ASYNC_HANDLER) {
                        return com.ss.android.socialbase.downloader.exception.RetryCheckStatus.RETURN;
                    }
                    onError(baseException);
                    return com.ss.android.socialbase.downloader.exception.RetryCheckStatus.RETURN;
                }
                if (!com.ss.android.socialbase.downloader.setting.DownloadSetting.obtain(this.downloadInfo.getId()).optBugFix(com.ss.android.socialbase.downloader.setting.DownloadSettingKeys.BugFix.NOT_DELETE_WHEN_CLEAN_SPACE, false)) {
                    checkCompletedByteValid();
                }
                if (!atomicBoolean.get()) {
                    com.ss.android.socialbase.downloader.constants.RunStatus runStatus = this.runStatus;
                    com.ss.android.socialbase.downloader.constants.RunStatus runStatus2 = com.ss.android.socialbase.downloader.constants.RunStatus.RUN_STATUS_WAITING_ASYNC_HANDLER;
                    if (runStatus != runStatus2) {
                        this.runStatus = runStatus2;
                        cancelAllChunkRunnable();
                        this.statusHandler.handleWaitingAsyncHandler();
                    }
                    return com.ss.android.socialbase.downloader.exception.RetryCheckStatus.RETURN;
                }
                if (handleRetryTime(baseException)) {
                    return com.ss.android.socialbase.downloader.exception.RetryCheckStatus.RETURN;
                }
                z = true;
            }
        }
        if (!z && checkNeedRetryDelay()) {
            cancelAllChunkRunnable();
        }
        com.ss.android.socialbase.downloader.downloader.DownloadStatusHandler downloadStatusHandler = this.statusHandler;
        com.ss.android.socialbase.downloader.constants.RunStatus runStatus3 = this.runStatus;
        com.ss.android.socialbase.downloader.constants.RunStatus runStatus4 = com.ss.android.socialbase.downloader.constants.RunStatus.RUN_STATUS_RETRY_DELAY;
        downloadStatusHandler.onRetry(baseException, runStatus3 == runStatus4);
        return this.runStatus == runStatus4 ? com.ss.android.socialbase.downloader.exception.RetryCheckStatus.RETURN : com.ss.android.socialbase.downloader.exception.RetryCheckStatus.CONTINUE;
    }

    @Override // com.ss.android.socialbase.downloader.thread.IDownloadRunnableCallback
    public com.ss.android.socialbase.downloader.exception.RetryCheckStatus onSingleChunkRetry(com.ss.android.socialbase.downloader.model.DownloadChunk downloadChunk, com.ss.android.socialbase.downloader.exception.BaseException baseException, long j) {
        if (isStoppedStatus()) {
            return com.ss.android.socialbase.downloader.exception.RetryCheckStatus.RETURN;
        }
        if (baseException != null && (baseException.getErrorCode() == 1047 || com.ss.android.socialbase.downloader.utils.DownloadUtils.isInsufficientSpaceError(baseException))) {
            return onRetry(baseException, j);
        }
        this.errorException = baseException;
        this.downloadInfo.increaseCurBytes(-j);
        this.downloadCache.updateDownloadInfo(this.downloadInfo);
        if (handleRetryTime(baseException)) {
            return com.ss.android.socialbase.downloader.exception.RetryCheckStatus.RETURN;
        }
        com.ss.android.socialbase.downloader.downloader.DownloadStatusHandler downloadStatusHandler = this.statusHandler;
        com.ss.android.socialbase.downloader.constants.RunStatus runStatus = this.runStatus;
        com.ss.android.socialbase.downloader.constants.RunStatus runStatus2 = com.ss.android.socialbase.downloader.constants.RunStatus.RUN_STATUS_RETRY_DELAY;
        downloadStatusHandler.onSingleChunkRetry(downloadChunk, baseException, runStatus == runStatus2);
        if (this.runStatus != runStatus2 && this.downloadInfo.isNeedRetryDelay()) {
            long delayTime = getDelayTime();
            if (delayTime > 0) {
                com.ss.android.socialbase.downloader.logger.Logger.i(TAG, "onSingleChunkRetry with delay time ".concat(java.lang.String.valueOf(delayTime)));
                try {
                    java.lang.Thread.sleep(delayTime);
                } catch (java.lang.Throwable th) {
                    com.ss.android.socialbase.downloader.logger.Logger.w(TAG, "onSingleChunkRetry:" + th.getMessage());
                }
            }
        }
        return com.ss.android.socialbase.downloader.exception.RetryCheckStatus.CONTINUE;
    }

    public void pause() {
        com.ss.android.socialbase.downloader.constants.RunStatus runStatus = com.ss.android.socialbase.downloader.constants.RunStatus.RUN_STATUS_PAUSE;
        this.runStatus = runStatus;
        if (this.segmentDispatcher != null) {
            this.segmentDispatcher.pause();
        }
        if (this.firstHttpResponseHandler != null) {
            this.firstHttpResponseHandler.pause();
        }
        if (this.segmentDispatcher == null && this.firstHttpResponseHandler == null) {
            closeConnection();
            this.runStatus = runStatus;
            endDownloadRunnable();
        }
        try {
            java.util.Iterator it = ((java.util.ArrayList) this.downloadChunkRunnableList.clone()).iterator();
            while (it.hasNext()) {
                com.ss.android.socialbase.downloader.thread.DownloadChunkRunnable downloadChunkRunnable = (com.ss.android.socialbase.downloader.thread.DownloadChunkRunnable) it.next();
                if (downloadChunkRunnable != null) {
                    downloadChunkRunnable.pause();
                }
            }
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    public void prepareDownload() {
        this.prepareDownloadTime = java.lang.System.currentTimeMillis();
        this.statusHandler.onPrepare();
    }

    @Override // java.lang.Runnable
    public void run() {
        com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.onDownloadTaskStart(this.downloadTask, 3);
        try {
            com.ss.android.socialbase.downloader.network.DeviceBandwidthSampler.getInstance().startSampling();
            runInner();
            com.ss.android.socialbase.downloader.network.DeviceBandwidthSampler.getInstance().stopSampling();
            com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.onDownloadTaskFinish(this.downloadTask, 3);
        } catch (java.lang.Throwable th) {
            com.ss.android.socialbase.downloader.network.DeviceBandwidthSampler.getInstance().stopSampling();
            throw th;
        }
    }

    public void setFuture(java.util.concurrent.Future future) {
        this.mFuture = future;
    }

    /* JADX WARN: Removed duplicated region for block: B:4:0x001d  */
    /* JADX WARN: Removed duplicated region for block: B:7:? A[RETURN, SYNTHETIC] */
    @Override // com.ss.android.socialbase.downloader.thread.IDownloadRunnableCallback
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void setHttpResponseStatus(com.ss.android.socialbase.downloader.network.IDownloadHeadHttpConnection iDownloadHeadHttpConnection) {
        boolean z;
        if (iDownloadHeadHttpConnection != null) {
            try {
                int responseCode = iDownloadHeadHttpConnection.getResponseCode();
                this.downloadInfo.setHttpStatusCode(responseCode);
                this.downloadInfo.setHttpStatusMessage(com.ss.android.socialbase.downloader.utils.DownloadHttpUtils.httpCodeToMessage(responseCode));
                z = true;
            } catch (java.lang.Throwable th) {
                th.printStackTrace();
            }
            if (z) {
                this.downloadInfo.setHttpStatusCode(-1);
                this.downloadInfo.setHttpStatusMessage("");
                return;
            }
            return;
        }
        z = false;
        if (z) {
        }
    }

    public void setThrottleNetSpeed(long j) {
        com.ss.android.socialbase.downloader.network.IDownloadHttpConnection iDownloadHttpConnection = this.firstGetConnection;
        if (iDownloadHttpConnection != null && (iDownloadHttpConnection instanceof com.ss.android.socialbase.downloader.network.AbsDownloadHttpConnection)) {
            try {
                ((com.ss.android.socialbase.downloader.network.AbsDownloadHttpConnection) iDownloadHttpConnection).setThrottleNetSpeedWhenRunning(j);
            } catch (java.lang.Throwable th) {
                th.printStackTrace();
            }
        }
    }
}
