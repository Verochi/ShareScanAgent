package com.ss.android.socialbase.downloader.downloader;

/* loaded from: classes19.dex */
public class DownloadResponseHandler {
    private static final boolean DEBUG = false;
    public static final int MIN_SYNC_STEP_BYTE = 65536;
    public static final long MIN_SYNC_TIME_MS = 500;
    private static java.lang.String TAG = "ResponseHandler";
    private final com.ss.android.socialbase.downloader.common.AppStatusManager appStatusManager;
    private final boolean bugfixCancelThenUpdate;
    private final com.ss.android.socialbase.downloader.thread.IDownloadRunnableCallback callback;
    private volatile boolean canceled;
    private long curOffset;
    private com.ss.android.socialbase.downloader.downloader.IDownloadCache customCache;
    private long debugReadTimeNs;
    private long debugSyncTimeNs;
    private long debugTotalTimeNs;
    private long debugWriteTimeNs;
    private com.ss.android.socialbase.downloader.impls.DownloadCache downloadCache;
    private final com.ss.android.socialbase.downloader.model.DownloadChunk downloadChunk;
    private volatile long downloadChunkContentLen;
    private final com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo;
    private volatile long endOffset;
    private com.ss.android.socialbase.downloader.exception.BaseException exception;
    private long handleStartOffset;
    private final boolean hasSyncStrategy;
    private final com.ss.android.socialbase.downloader.network.IDownloadHttpConnection httpConnection;
    private final boolean isMonitorRw;
    private com.ss.android.socialbase.downloader.model.RandomAccessOutputStream outputStream;
    private volatile boolean paused;
    private boolean rwConcurrent;
    private final com.ss.android.socialbase.downloader.setting.DownloadSetting setting;
    private com.ss.android.socialbase.downloader.downloader.ISqlDownloadCache sqlDownloadCache;
    private final long syncIntervalMsBg;
    private final long syncIntervalMsFg;
    private final java.lang.String url;
    boolean openLimitSpeed = false;
    private volatile long lastSyncBytes = 0;
    private volatile long lastSyncTimestamp = 0;

    /* renamed from: com.ss.android.socialbase.downloader.downloader.DownloadResponseHandler$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {
        public AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                com.ss.android.socialbase.downloader.downloader.DownloadResponseHandler.this.httpConnection.end();
            } catch (java.lang.Throwable unused) {
            }
        }
    }

    public DownloadResponseHandler(com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo, java.lang.String str, com.ss.android.socialbase.downloader.network.IDownloadHttpConnection iDownloadHttpConnection, com.ss.android.socialbase.downloader.model.DownloadChunk downloadChunk, com.ss.android.socialbase.downloader.thread.IDownloadRunnableCallback iDownloadRunnableCallback) {
        this.downloadInfo = downloadInfo;
        this.url = str;
        com.ss.android.socialbase.downloader.downloader.IDownloadCache downloadCache = com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.getDownloadCache();
        this.customCache = downloadCache;
        if (downloadCache instanceof com.ss.android.socialbase.downloader.impls.DefaultDownloadCache) {
            com.ss.android.socialbase.downloader.impls.DefaultDownloadCache defaultDownloadCache = (com.ss.android.socialbase.downloader.impls.DefaultDownloadCache) downloadCache;
            this.downloadCache = defaultDownloadCache.getDownloadCache();
            this.sqlDownloadCache = defaultDownloadCache.getSqlDownloadCache();
        }
        this.httpConnection = iDownloadHttpConnection;
        this.downloadChunk = downloadChunk;
        this.callback = iDownloadRunnableCallback;
        long currentOffset = downloadChunk.getCurrentOffset();
        this.curOffset = currentOffset;
        this.handleStartOffset = currentOffset;
        if (downloadChunk.isHostChunk()) {
            this.downloadChunkContentLen = downloadChunk.getContentLength();
        } else {
            this.downloadChunkContentLen = downloadChunk.getRetainLength(false);
        }
        this.endOffset = downloadChunk.getEndOffset();
        this.appStatusManager = com.ss.android.socialbase.downloader.common.AppStatusManager.getInstance();
        com.ss.android.socialbase.downloader.setting.DownloadSetting obtain = com.ss.android.socialbase.downloader.setting.DownloadSetting.obtain(downloadInfo.getId());
        this.setting = obtain;
        boolean z = obtain.optInt(com.ss.android.socialbase.downloader.setting.DownloadSettingKeys.SYNC_STRATEGY, 0) == 1;
        this.hasSyncStrategy = z;
        if (z) {
            long optInt = obtain.optInt(com.ss.android.socialbase.downloader.setting.DownloadSettingKeys.SYNC_INTERVAL_MS_FG, 5000);
            long optInt2 = obtain.optInt(com.ss.android.socialbase.downloader.setting.DownloadSettingKeys.SYNC_INTERVAL_MS_BG, 1000);
            this.syncIntervalMsFg = java.lang.Math.max(optInt, 500L);
            this.syncIntervalMsBg = java.lang.Math.max(optInt2, 500L);
        } else {
            this.syncIntervalMsFg = 0L;
            this.syncIntervalMsBg = 0L;
        }
        this.isMonitorRw = obtain.optInt(com.ss.android.socialbase.downloader.setting.DownloadSettingKeys.MONITOR_RW) == 1;
        this.bugfixCancelThenUpdate = com.ss.android.socialbase.downloader.utils.DownloadExpSwitchCode.isSwitchEnable(65536);
    }

    private boolean canReuseConnection() {
        return this.downloadInfo.isNeedReuseFirstConnection() && this.downloadChunk.isReuseingFirstConnection();
    }

    private void cancelConnection() {
        java.util.concurrent.ExecutorService cPUThreadExecutor;
        if (this.httpConnection == null || (cPUThreadExecutor = com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.getCPUThreadExecutor()) == null) {
            return;
        }
        cPUThreadExecutor.execute(new com.ss.android.socialbase.downloader.downloader.DownloadResponseHandler.AnonymousClass1());
    }

    private void checkAndSync(boolean z) {
        long uptimeMillis = android.os.SystemClock.uptimeMillis();
        long j = uptimeMillis - this.lastSyncTimestamp;
        if (this.hasSyncStrategy) {
            if (j <= (this.appStatusManager.isAppForeground() ? this.syncIntervalMsFg : this.syncIntervalMsBg)) {
                return;
            }
        } else {
            long j2 = this.curOffset - this.lastSyncBytes;
            if (!z && !isNeedSync(j2, j)) {
                return;
            }
        }
        sync();
        this.lastSyncTimestamp = uptimeMillis;
    }

    private com.ss.android.socialbase.downloader.reader.IStreamReader createStreamReader(java.io.InputStream inputStream) {
        int writeBufferSize = com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.getWriteBufferSize();
        if (this.setting.optInt("rw_concurrent", 0) == 1 && this.downloadInfo.getChunkCount() == 1 && this.downloadInfo.getTotalBytes() > 20971520) {
            try {
                com.ss.android.socialbase.downloader.reader.AsyncStreamReader asyncStreamReader = new com.ss.android.socialbase.downloader.reader.AsyncStreamReader(inputStream, writeBufferSize, this.setting.optInt(com.ss.android.socialbase.downloader.setting.DownloadSettingKeys.RW_CONCURRENT_MAX_BUFFER_COUNT, 4));
                this.rwConcurrent = true;
                return asyncStreamReader;
            } catch (java.lang.Throwable th) {
                th.printStackTrace();
            }
        }
        com.ss.android.socialbase.downloader.reader.SyncStreamReader syncStreamReader = new com.ss.android.socialbase.downloader.reader.SyncStreamReader(inputStream, writeBufferSize);
        this.rwConcurrent = false;
        return syncStreamReader;
    }

    private boolean isNeedSync(long j, long j2) {
        return j > 65536 && j2 > 500;
    }

    private boolean isStoppedStatus() {
        return this.paused || this.canceled;
    }

    private void sync() {
        boolean z;
        long nanoTime = this.isMonitorRw ? java.lang.System.nanoTime() : 0L;
        try {
            this.outputStream.flushAndSync();
            z = true;
        } catch (java.lang.Exception unused) {
            z = false;
        }
        if (z) {
            this.downloadInfo.updateRealDownloadTime(true);
            boolean z2 = this.downloadInfo.getChunkCount() > 1;
            com.ss.android.socialbase.downloader.downloader.IDownloadProxy iDownloadProxy = com.ss.android.socialbase.downloader.impls.DownloadProxy.get(com.ss.android.socialbase.downloader.utils.DownloadUtils.needNotifyDownloaderProcess());
            if (z2) {
                updateDownloadChunk(this.sqlDownloadCache);
                if (iDownloadProxy != null) {
                    iDownloadProxy.updateDownloadInfo(this.downloadInfo);
                } else {
                    this.sqlDownloadCache.OnDownloadTaskProgress(this.downloadInfo.getId(), this.downloadInfo.getCurBytes());
                }
            } else if (iDownloadProxy != null) {
                iDownloadProxy.updateDownloadInfo(this.downloadInfo);
            } else {
                this.sqlDownloadCache.OnDownloadTaskProgress(this.downloadChunk.getId(), this.curOffset);
            }
            this.lastSyncBytes = this.curOffset;
        }
        if (this.isMonitorRw) {
            this.debugSyncTimeNs += java.lang.System.nanoTime() - nanoTime;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:36:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void updateDownloadChunk(com.ss.android.socialbase.downloader.downloader.IDownloadCache iDownloadCache) {
        com.ss.android.socialbase.downloader.downloader.IDownloadProxy iDownloadProxy;
        com.ss.android.socialbase.downloader.model.DownloadChunk downloadChunk;
        boolean z;
        if (iDownloadCache == null) {
            return;
        }
        boolean z2 = iDownloadCache instanceof com.ss.android.socialbase.downloader.db.SqlDownloadCache;
        if (z2) {
            iDownloadProxy = com.ss.android.socialbase.downloader.impls.DownloadProxy.get(com.ss.android.socialbase.downloader.utils.DownloadUtils.needNotifyDownloaderProcess());
            if (iDownloadProxy == null) {
                return;
            }
        } else {
            iDownloadProxy = null;
        }
        com.ss.android.socialbase.downloader.downloader.IDownloadProxy iDownloadProxy2 = iDownloadProxy;
        com.ss.android.socialbase.downloader.model.DownloadChunk firstReuseChunk = this.downloadChunk.isHostChunk() ? this.downloadChunk.getFirstReuseChunk() : this.downloadChunk;
        if (firstReuseChunk == null) {
            if (this.downloadChunk.isHostChunk()) {
                if (!z2 || iDownloadProxy2 == null) {
                    iDownloadCache.updateDownloadChunk(this.downloadChunk.getId(), this.downloadChunk.getChunkIndex(), this.curOffset);
                    return;
                } else {
                    iDownloadProxy2.updateDownloadChunk(this.downloadChunk.getId(), this.downloadChunk.getChunkIndex(), this.curOffset);
                    return;
                }
            }
            return;
        }
        firstReuseChunk.setCurrentOffset(this.curOffset);
        if (!z2 || iDownloadProxy2 == null) {
            downloadChunk = firstReuseChunk;
            iDownloadCache.updateSubDownloadChunk(firstReuseChunk.getId(), firstReuseChunk.getChunkIndex(), firstReuseChunk.getHostChunkIndex(), this.curOffset);
        } else {
            iDownloadProxy2.updateSubDownloadChunk(firstReuseChunk.getId(), firstReuseChunk.getChunkIndex(), firstReuseChunk.getHostChunkIndex(), this.curOffset);
            downloadChunk = firstReuseChunk;
        }
        if (!downloadChunk.canRefreshCurOffsetForReuseChunk()) {
            return;
        }
        if (downloadChunk.hasNoBytesDownload()) {
            long nextChunkCurOffset = downloadChunk.getNextChunkCurOffset();
            if (nextChunkCurOffset > this.curOffset) {
                if (!z2 || iDownloadProxy2 == null) {
                    iDownloadCache.updateDownloadChunk(downloadChunk.getId(), downloadChunk.getHostChunkIndex(), nextChunkCurOffset);
                } else {
                    iDownloadProxy2.updateDownloadChunk(downloadChunk.getId(), downloadChunk.getHostChunkIndex(), nextChunkCurOffset);
                }
                z = true;
                if (z) {
                    if (!z2 || iDownloadProxy2 == null) {
                        iDownloadCache.updateDownloadChunk(downloadChunk.getId(), downloadChunk.getHostChunkIndex(), this.curOffset);
                        return;
                    } else {
                        iDownloadProxy2.updateDownloadChunk(downloadChunk.getId(), downloadChunk.getHostChunkIndex(), this.curOffset);
                        return;
                    }
                }
                return;
            }
        }
        z = false;
        if (z) {
        }
    }

    public void cancel() {
        if (this.canceled) {
            return;
        }
        synchronized (this.callback) {
            this.canceled = true;
        }
        cancelConnection();
    }

    public long getCurOffset() {
        return this.curOffset;
    }

    public long getLastSyncBytes() {
        return this.lastSyncBytes;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:140:0x02bf A[Catch: all -> 0x04ab, TRY_ENTER, TryCatch #4 {all -> 0x04ab, blocks: (B:140:0x02bf, B:141:0x02c6, B:175:0x0338, B:177:0x033e, B:179:0x0341, B:211:0x042d, B:212:0x042f, B:227:0x0436, B:229:0x044f, B:260:0x049f, B:262:0x04a5, B:263:0x04a8, B:264:0x04aa), top: B:8:0x002b, inners: #19 }] */
    /* JADX WARN: Removed duplicated region for block: B:143:0x02db  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x0338 A[Catch: all -> 0x04ab, TRY_ENTER, TryCatch #4 {all -> 0x04ab, blocks: (B:140:0x02bf, B:141:0x02c6, B:175:0x0338, B:177:0x033e, B:179:0x0341, B:211:0x042d, B:212:0x042f, B:227:0x0436, B:229:0x044f, B:260:0x049f, B:262:0x04a5, B:263:0x04a8, B:264:0x04aa), top: B:8:0x002b, inners: #19 }] */
    /* JADX WARN: Removed duplicated region for block: B:262:0x04a5 A[Catch: all -> 0x04ab, TryCatch #4 {all -> 0x04ab, blocks: (B:140:0x02bf, B:141:0x02c6, B:175:0x0338, B:177:0x033e, B:179:0x0341, B:211:0x042d, B:212:0x042f, B:227:0x0436, B:229:0x044f, B:260:0x049f, B:262:0x04a5, B:263:0x04a8, B:264:0x04aa), top: B:8:0x002b, inners: #19 }] */
    /* JADX WARN: Removed duplicated region for block: B:84:0x03bf A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:86:0x03c0  */
    /* JADX WARN: Type inference failed for: r2v0, types: [long] */
    /* JADX WARN: Type inference failed for: r2v15 */
    /* JADX WARN: Type inference failed for: r2v16 */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v27, types: [int] */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v4, types: [int] */
    /* JADX WARN: Type inference failed for: r2v44 */
    /* JADX WARN: Type inference failed for: r2v46 */
    /* JADX WARN: Type inference failed for: r2v47 */
    /* JADX WARN: Type inference failed for: r2v61 */
    /* JADX WARN: Type inference failed for: r2v77 */
    /* JADX WARN: Type inference failed for: r2v79 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void handleResponse() throws com.ss.android.socialbase.downloader.exception.BaseException {
        long j;
        long j2;
        boolean z;
        char c;
        char c2;
        com.ss.android.socialbase.downloader.reader.IStreamReader iStreamReader;
        int i;
        boolean z2;
        boolean z3;
        com.ss.android.socialbase.downloader.network.IDownloadHttpConnection iDownloadHttpConnection;
        java.lang.String str;
        com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo;
        com.ss.android.socialbase.downloader.setting.DownloadSetting downloadSetting;
        com.ss.android.socialbase.downloader.setting.DownloadSetting downloadSetting2;
        com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo2;
        java.lang.String str2;
        com.ss.android.socialbase.downloader.network.IDownloadHttpConnection iDownloadHttpConnection2;
        char c3;
        int i2;
        java.io.InputStream inputStream;
        long j3;
        long j4;
        long currentTimeMillis;
        long j5;
        long j6;
        if (isStoppedStatus() || this.downloadChunk == null) {
            return;
        }
        int contentLength = com.ss.android.socialbase.downloader.utils.DownloadUtils.getContentLength(this.httpConnection);
        if (contentLength == 0) {
            throw new com.ss.android.socialbase.downloader.exception.DownloadRetryNeedlessException(1004, "the content-length is 0");
        }
        long startOffset = this.downloadChunk.getStartOffset();
        long nanoTime = java.lang.System.nanoTime();
        boolean z4 = this.isMonitorRw;
        boolean z5 = this.httpConnection instanceof com.ss.android.socialbase.downloader.network.AbsDownloadHttpConnection;
        int i3 = 1;
        try {
            try {
                com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo3 = this.downloadInfo;
                i2 = -1;
                com.ss.android.socialbase.downloader.model.RandomAccessOutputStream createOutputStream = com.ss.android.socialbase.downloader.utils.DownloadUtils.createOutputStream(downloadInfo3, downloadInfo3.getTempPath(), this.downloadInfo.getTempName(), this.setting.optInt(com.ss.android.socialbase.downloader.setting.DownloadSettingKeys.FLUSH_BUFFER_SIZE_BYTE, -1));
                this.outputStream = createOutputStream;
                try {
                    try {
                        createOutputStream.seek(this.curOffset);
                        inputStream = this.httpConnection.getInputStream();
                    } catch (java.io.IOException e) {
                        throw new com.ss.android.socialbase.downloader.exception.BaseException(com.ss.android.socialbase.downloader.constants.DownloadErrorCode.ERROR_RANDOM_ACCESS_SEEK_IO, e);
                    }
                } catch (com.ss.android.socialbase.downloader.exception.BaseException e2) {
                    e = e2;
                    iStreamReader = null;
                    i = contentLength;
                    com.ss.android.socialbase.downloader.logger.Logger.w(TAG, "handleResponse: BaseException e = ".concat(java.lang.String.valueOf(e)));
                    if (this.setting.optBugFix(com.ss.android.socialbase.downloader.setting.DownloadSettingKeys.BugFix.IGNORE_BASE_EX_ON_STOP_STATUS)) {
                    }
                    if (com.ss.android.socialbase.downloader.logger.Logger.debug()) {
                    }
                    this.exception = e;
                    throw e;
                } catch (java.lang.Throwable th) {
                    th = th;
                    iStreamReader = null;
                    contentLength = contentLength;
                    if (z5) {
                    }
                    com.ss.android.socialbase.downloader.logger.Logger.w(TAG, "handleResponse: e = ".concat(java.lang.String.valueOf(th)));
                    if (isStoppedStatus()) {
                    }
                }
            } catch (java.lang.Throwable th2) {
                com.ss.android.socialbase.downloader.network.IDownloadHttpConnection iDownloadHttpConnection3 = this.httpConnection;
                if (iDownloadHttpConnection3 != null) {
                    iDownloadHttpConnection3.end();
                }
                if (iStreamReader != null) {
                    iStreamReader.close();
                }
                try {
                    if (this.bugfixCancelThenUpdate) {
                        synchronized (this.callback) {
                            if (!this.canceled) {
                                updateDownloadChunk(this.downloadCache);
                                if (this.outputStream != null) {
                                    sync();
                                }
                            }
                        }
                    } else {
                        updateDownloadChunk(this.downloadCache);
                        if (this.outputStream != null) {
                            sync();
                        }
                    }
                    java.io.Closeable[] closeableArr = new java.io.Closeable[contentLength];
                    closeableArr[c] = this.outputStream;
                    com.ss.android.socialbase.downloader.utils.DownloadUtils.safeClose(closeableArr);
                    this.debugTotalTimeNs = java.lang.System.nanoTime() - nanoTime;
                    com.ss.android.socialbase.downloader.monitor.DownloadMonitorHelper.monitorDownloadIO(this.setting, this.downloadInfo, this.url, this.httpConnection, this.paused, this.canceled, this.exception, this.curOffset - this.handleStartOffset, this.debugTotalTimeNs, z, this.debugReadTimeNs, this.debugWriteTimeNs, this.debugSyncTimeNs, null);
                    throw th2;
                } catch (java.lang.Throwable th3) {
                    java.io.Closeable[] closeableArr2 = new java.io.Closeable[contentLength];
                    closeableArr2[c] = this.outputStream;
                    com.ss.android.socialbase.downloader.utils.DownloadUtils.safeClose(closeableArr2);
                    throw th3;
                }
            }
        } catch (com.ss.android.socialbase.downloader.exception.BaseException e3) {
            e = e3;
            z = z4;
            contentLength = 1;
            c2 = 0;
        } catch (java.lang.Throwable th4) {
            th = th4;
            j = contentLength;
            j2 = startOffset;
            z = z4;
            contentLength = 1;
            c = 0;
        }
        if (inputStream == null) {
            throw new com.ss.android.socialbase.downloader.exception.BaseException(com.ss.android.socialbase.downloader.constants.DownloadErrorCode.ERROR_NETWORK_NO_INPUT_STREAM, new java.io.IOException("inputStream is null"));
        }
        this.downloadInfo.updateRealStartDownloadTime();
        iStreamReader = createStreamReader(inputStream);
        try {
            this.downloadInfo.setIsRwConcurrent(this.rwConcurrent);
            this.openLimitSpeed = this.downloadInfo.getOpenLimitSpeed();
            long j7 = com.ss.android.socialbase.downloader.constants.DownloadConstants.LIMIT_SPEED_EVERTS_ECOND;
            j3 = com.ss.android.socialbase.downloader.constants.DownloadConstants.LIMIT_INTERVSL;
            j4 = j7 / (1000 / j3);
            currentTimeMillis = java.lang.System.currentTimeMillis();
            j5 = 0;
            j6 = 0;
            contentLength = contentLength;
        } catch (com.ss.android.socialbase.downloader.exception.BaseException e4) {
            e = e4;
            z = z4;
        } catch (java.lang.Throwable th5) {
            th = th5;
            j = contentLength;
            j2 = startOffset;
            z = z4;
        }
        while (!isStoppedStatus()) {
            z = z4;
            if (z) {
                try {
                    try {
                        j5 = java.lang.System.nanoTime();
                    } catch (java.lang.Throwable th6) {
                        th = th6;
                        j = contentLength;
                        j2 = startOffset;
                        contentLength = 1;
                        c = 0;
                        if (z5) {
                            ((com.ss.android.socialbase.downloader.network.AbsDownloadHttpConnection) this.httpConnection).onThrowable(th);
                        }
                        com.ss.android.socialbase.downloader.logger.Logger.w(TAG, "handleResponse: e = ".concat(java.lang.String.valueOf(th)));
                        if (isStoppedStatus()) {
                            com.ss.android.socialbase.downloader.network.IDownloadHttpConnection iDownloadHttpConnection4 = this.httpConnection;
                            if (iDownloadHttpConnection4 != null) {
                                iDownloadHttpConnection4.end();
                            }
                            if (iStreamReader != null) {
                                iStreamReader.close();
                            }
                            try {
                                if (this.bugfixCancelThenUpdate) {
                                    synchronized (this.callback) {
                                        if (!this.canceled) {
                                            updateDownloadChunk(this.downloadCache);
                                            if (this.outputStream != null) {
                                                sync();
                                            }
                                        }
                                    }
                                } else {
                                    updateDownloadChunk(this.downloadCache);
                                    if (this.outputStream != null) {
                                        sync();
                                    }
                                }
                                java.io.Closeable[] closeableArr3 = new java.io.Closeable[contentLength];
                                closeableArr3[c] = this.outputStream;
                                com.ss.android.socialbase.downloader.utils.DownloadUtils.safeClose(closeableArr3);
                                this.debugTotalTimeNs = java.lang.System.nanoTime() - nanoTime;
                                downloadSetting = this.setting;
                                downloadInfo = this.downloadInfo;
                                str = this.url;
                                iDownloadHttpConnection = this.httpConnection;
                                z3 = this.paused;
                                z2 = this.canceled;
                                com.ss.android.socialbase.downloader.monitor.DownloadMonitorHelper.monitorDownloadIO(downloadSetting, downloadInfo, str, iDownloadHttpConnection, z3, z2, this.exception, this.curOffset - this.handleStartOffset, this.debugTotalTimeNs, z, this.debugReadTimeNs, this.debugWriteTimeNs, this.debugSyncTimeNs, null);
                            } catch (java.lang.Throwable th7) {
                                java.io.Closeable[] closeableArr4 = new java.io.Closeable[contentLength];
                                closeableArr4[c] = this.outputStream;
                                com.ss.android.socialbase.downloader.utils.DownloadUtils.safeClose(closeableArr4);
                                throw th7;
                            }
                        }
                        if (com.ss.android.socialbase.downloader.logger.Logger.debug()) {
                            th.printStackTrace();
                        }
                        try {
                            com.ss.android.socialbase.downloader.utils.DownloadUtils.parseException(th, "ResponseHandler");
                            com.ss.android.socialbase.downloader.network.IDownloadHttpConnection iDownloadHttpConnection5 = this.httpConnection;
                            if (iDownloadHttpConnection5 != null) {
                                iDownloadHttpConnection5.end();
                            }
                            if (iStreamReader != null) {
                                iStreamReader.close();
                            }
                            try {
                                if (this.bugfixCancelThenUpdate) {
                                    synchronized (this.callback) {
                                        if (!this.canceled) {
                                            updateDownloadChunk(this.downloadCache);
                                            if (this.outputStream != null) {
                                                sync();
                                            }
                                        }
                                    }
                                } else {
                                    updateDownloadChunk(this.downloadCache);
                                    if (this.outputStream != null) {
                                        sync();
                                    }
                                }
                                java.io.Closeable[] closeableArr5 = new java.io.Closeable[contentLength];
                                closeableArr5[c] = this.outputStream;
                                com.ss.android.socialbase.downloader.utils.DownloadUtils.safeClose(closeableArr5);
                                this.debugTotalTimeNs = java.lang.System.nanoTime() - nanoTime;
                                downloadSetting2 = this.setting;
                                downloadInfo2 = this.downloadInfo;
                                str2 = this.url;
                                iDownloadHttpConnection2 = this.httpConnection;
                                c3 = contentLength;
                                com.ss.android.socialbase.downloader.monitor.DownloadMonitorHelper.monitorDownloadIO(downloadSetting2, downloadInfo2, str2, iDownloadHttpConnection2, this.paused, this.canceled, this.exception, this.curOffset - this.handleStartOffset, this.debugTotalTimeNs, z, this.debugReadTimeNs, this.debugWriteTimeNs, this.debugSyncTimeNs, null);
                                if (this.downloadInfo.isIgnoreDataVerify()) {
                                }
                            } catch (java.lang.Throwable th8) {
                                java.io.Closeable[] closeableArr6 = new java.io.Closeable[contentLength];
                                closeableArr6[c] = this.outputStream;
                                com.ss.android.socialbase.downloader.utils.DownloadUtils.safeClose(closeableArr6);
                                throw th8;
                            }
                        } catch (com.ss.android.socialbase.downloader.exception.BaseException e5) {
                            this.exception = e5;
                            throw e5;
                        }
                    }
                } catch (com.ss.android.socialbase.downloader.exception.BaseException e6) {
                    e = e6;
                    i = 1;
                    c2 = 0;
                    com.ss.android.socialbase.downloader.logger.Logger.w(TAG, "handleResponse: BaseException e = ".concat(java.lang.String.valueOf(e)));
                    if (this.setting.optBugFix(com.ss.android.socialbase.downloader.setting.DownloadSettingKeys.BugFix.IGNORE_BASE_EX_ON_STOP_STATUS) || !isStoppedStatus()) {
                        if (com.ss.android.socialbase.downloader.logger.Logger.debug()) {
                            e.printStackTrace();
                        }
                        this.exception = e;
                        throw e;
                    }
                    com.ss.android.socialbase.downloader.network.IDownloadHttpConnection iDownloadHttpConnection6 = this.httpConnection;
                    if (iDownloadHttpConnection6 != null) {
                        iDownloadHttpConnection6.end();
                    }
                    if (iStreamReader != null) {
                        iStreamReader.close();
                    }
                    try {
                        if (this.bugfixCancelThenUpdate) {
                            synchronized (this.callback) {
                                if (!this.canceled) {
                                    updateDownloadChunk(this.downloadCache);
                                    if (this.outputStream != null) {
                                        sync();
                                    }
                                }
                            }
                        } else {
                            updateDownloadChunk(this.downloadCache);
                            if (this.outputStream != null) {
                                sync();
                            }
                        }
                        java.io.Closeable[] closeableArr7 = new java.io.Closeable[i];
                        closeableArr7[c2] = this.outputStream;
                        com.ss.android.socialbase.downloader.utils.DownloadUtils.safeClose(closeableArr7);
                        this.debugTotalTimeNs = java.lang.System.nanoTime() - nanoTime;
                        downloadSetting = this.setting;
                        downloadInfo = this.downloadInfo;
                        str = this.url;
                        iDownloadHttpConnection = this.httpConnection;
                        z3 = this.paused;
                        z2 = this.canceled;
                        com.ss.android.socialbase.downloader.monitor.DownloadMonitorHelper.monitorDownloadIO(downloadSetting, downloadInfo, str, iDownloadHttpConnection, z3, z2, this.exception, this.curOffset - this.handleStartOffset, this.debugTotalTimeNs, z, this.debugReadTimeNs, this.debugWriteTimeNs, this.debugSyncTimeNs, null);
                    } catch (java.lang.Throwable th9) {
                        java.io.Closeable[] closeableArr8 = new java.io.Closeable[i];
                        closeableArr8[c2] = this.outputStream;
                        com.ss.android.socialbase.downloader.utils.DownloadUtils.safeClose(closeableArr8);
                        throw th9;
                    }
                }
            }
            com.ss.android.socialbase.downloader.segment.Buffer read = iStreamReader.read();
            if (z) {
                this.debugReadTimeNs += java.lang.System.nanoTime() - j5;
            }
            int i4 = read.size;
            if (i4 != i2) {
                if (this.downloadInfo.isIgnoreDataVerify()) {
                    j = contentLength;
                    j2 = startOffset;
                } else {
                    j2 = startOffset;
                    try {
                        if (this.downloadChunkContentLen > this.curOffset - this.handleStartOffset) {
                            j = contentLength;
                            try {
                                if (this.downloadChunkContentLen < (this.curOffset - this.handleStartOffset) + i4) {
                                    i4 = (int) (this.downloadChunkContentLen - (this.curOffset - this.handleStartOffset));
                                }
                            } catch (java.lang.Throwable th10) {
                                th = th10;
                                contentLength = 1;
                                c = 0;
                                if (z5) {
                                }
                                com.ss.android.socialbase.downloader.logger.Logger.w(TAG, "handleResponse: e = ".concat(java.lang.String.valueOf(th)));
                                if (isStoppedStatus()) {
                                }
                            }
                        } else {
                            j = contentLength;
                        }
                    } catch (java.lang.Throwable th11) {
                        th = th11;
                        j = contentLength;
                    }
                }
                if (z) {
                    j5 = java.lang.System.nanoTime();
                }
                this.outputStream.write(read.data, 0, i4);
                if (z) {
                    this.debugWriteTimeNs += java.lang.System.nanoTime() - j5;
                }
                iStreamReader.recycle(read);
                long j8 = i4;
                this.curOffset += j8;
                j6 += j8;
                synchronized (this.callback) {
                    if (!this.bugfixCancelThenUpdate || !this.canceled) {
                        boolean onProgress = this.callback.onProgress(j8);
                        updateDownloadChunk(this.downloadCache);
                        checkAndSync(onProgress);
                    }
                }
                if (!this.downloadInfo.isDownloadWithWifiValid()) {
                    throw new com.ss.android.socialbase.downloader.exception.DownloadOnlyWifiException();
                }
                if (!this.downloadInfo.isPauseReserveWithWifiValid()) {
                    throw new com.ss.android.socialbase.downloader.exception.DownloadPauseReserveWifiException();
                }
                if (this.downloadInfo.isIgnoreDataVerify() || this.downloadChunkContentLen < 0 || this.downloadChunkContentLen > this.curOffset - this.handleStartOffset) {
                    if (this.openLimitSpeed && j6 > j4) {
                        long currentTimeMillis2 = java.lang.System.currentTimeMillis() - currentTimeMillis;
                        if (currentTimeMillis2 < j3) {
                            try {
                                java.lang.Thread.sleep(j3 - currentTimeMillis2);
                            } catch (java.lang.InterruptedException e7) {
                                e7.printStackTrace();
                            }
                        }
                        currentTimeMillis = java.lang.System.currentTimeMillis();
                        j6 = 0;
                    }
                    z4 = z;
                    contentLength = j;
                    startOffset = j2;
                    i2 = -1;
                    i3 = 1;
                }
            } else {
                j = contentLength;
                j2 = startOffset;
            }
            com.ss.android.socialbase.downloader.network.IDownloadHttpConnection iDownloadHttpConnection7 = this.httpConnection;
            if (iDownloadHttpConnection7 != null) {
                iDownloadHttpConnection7.end();
            }
            iStreamReader.close();
            try {
                if (this.bugfixCancelThenUpdate) {
                    synchronized (this.callback) {
                        if (!this.canceled) {
                            updateDownloadChunk(this.downloadCache);
                            if (this.outputStream != null) {
                                sync();
                            }
                        }
                    }
                } else {
                    updateDownloadChunk(this.downloadCache);
                    if (this.outputStream != null) {
                        sync();
                    }
                }
                c3 = 1;
                com.ss.android.socialbase.downloader.utils.DownloadUtils.safeClose(this.outputStream);
                this.debugTotalTimeNs = java.lang.System.nanoTime() - nanoTime;
                downloadSetting2 = this.setting;
                downloadInfo2 = this.downloadInfo;
                str2 = this.url;
                iDownloadHttpConnection2 = this.httpConnection;
                c = 0;
                com.ss.android.socialbase.downloader.monitor.DownloadMonitorHelper.monitorDownloadIO(downloadSetting2, downloadInfo2, str2, iDownloadHttpConnection2, this.paused, this.canceled, this.exception, this.curOffset - this.handleStartOffset, this.debugTotalTimeNs, z, this.debugReadTimeNs, this.debugWriteTimeNs, this.debugSyncTimeNs, null);
                if (this.downloadInfo.isIgnoreDataVerify()) {
                    long j9 = this.curOffset - this.handleStartOffset;
                    if (j9 < 0 || this.downloadChunkContentLen < 0 || this.downloadChunkContentLen == j9) {
                        return;
                    }
                    java.lang.Object[] objArr = new java.lang.Object[7];
                    objArr[c] = java.lang.Long.valueOf(j9);
                    objArr[c3] = java.lang.Long.valueOf(j);
                    objArr[2] = java.lang.Long.valueOf(this.downloadChunkContentLen);
                    objArr[3] = java.lang.Long.valueOf(j2);
                    objArr[4] = java.lang.Long.valueOf(this.endOffset);
                    objArr[5] = java.lang.Long.valueOf(this.curOffset);
                    objArr[6] = java.lang.Long.valueOf(this.handleStartOffset);
                    throw new com.ss.android.socialbase.downloader.exception.BaseException(com.ss.android.socialbase.downloader.constants.DownloadErrorCode.ERROR_RESPONSE_DATA_NOT_EQUALS, java.lang.String.format("handle data length[%d] != content length[%d] downloadChunkContentLen[%d], range[%d, %d) , current offset[%d] , handle start from %d", objArr));
                }
                return;
            } catch (java.lang.Throwable th12) {
                com.ss.android.socialbase.downloader.utils.DownloadUtils.safeClose(this.outputStream);
                throw th12;
            }
        }
        com.ss.android.socialbase.downloader.network.IDownloadHttpConnection iDownloadHttpConnection8 = this.httpConnection;
        if (iDownloadHttpConnection8 != null) {
            iDownloadHttpConnection8.end();
        }
        if (iStreamReader != null) {
            iStreamReader.close();
        }
        try {
            if (this.bugfixCancelThenUpdate) {
                synchronized (this.callback) {
                    if (!this.canceled) {
                        updateDownloadChunk(this.downloadCache);
                        if (this.outputStream != null) {
                            sync();
                        }
                    }
                }
            } else {
                updateDownloadChunk(this.downloadCache);
                if (this.outputStream != null) {
                    sync();
                }
            }
            java.io.Closeable[] closeableArr9 = new java.io.Closeable[i3];
            closeableArr9[0] = this.outputStream;
            com.ss.android.socialbase.downloader.utils.DownloadUtils.safeClose(closeableArr9);
            this.debugTotalTimeNs = java.lang.System.nanoTime() - nanoTime;
            downloadSetting = this.setting;
            downloadInfo = this.downloadInfo;
            str = this.url;
            iDownloadHttpConnection = this.httpConnection;
            z3 = this.paused;
            z = z4;
            z2 = this.canceled;
            com.ss.android.socialbase.downloader.monitor.DownloadMonitorHelper.monitorDownloadIO(downloadSetting, downloadInfo, str, iDownloadHttpConnection, z3, z2, this.exception, this.curOffset - this.handleStartOffset, this.debugTotalTimeNs, z, this.debugReadTimeNs, this.debugWriteTimeNs, this.debugSyncTimeNs, null);
        } catch (java.lang.Throwable th13) {
            java.io.Closeable[] closeableArr10 = new java.io.Closeable[i3];
            closeableArr10[0] = this.outputStream;
            com.ss.android.socialbase.downloader.utils.DownloadUtils.safeClose(closeableArr10);
            throw th13;
        }
    }

    public void pause() {
        if (this.paused) {
            return;
        }
        this.paused = true;
        cancelConnection();
    }

    public void setChunkOffset(long j, long j2, long j3) {
        this.curOffset = j;
        this.handleStartOffset = j;
        this.endOffset = j2;
        this.downloadChunkContentLen = j3;
    }

    public void setEndOffset(long j, long j2) {
        this.endOffset = j;
        this.downloadChunkContentLen = j2;
    }
}
