package com.ss.android.socialbase.downloader.thread;

/* loaded from: classes19.dex */
public class DownloadChunkRunnable implements java.lang.Runnable {
    private static final java.lang.String TAG = "DownloadChunkRunnable";
    private final com.ss.android.socialbase.downloader.thread.IDownloadRunnableCallback callback;
    private volatile boolean canceled;
    private com.ss.android.socialbase.downloader.model.DownloadChunk curDownloadChunk;
    private com.ss.android.socialbase.downloader.downloader.IDownloadCache downloadCache;
    private com.ss.android.socialbase.downloader.model.DownloadChunk downloadChunk;
    private com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo;
    private com.ss.android.socialbase.downloader.downloader.DownloadResponseHandler downloadResponseHandler;
    private final com.ss.android.socialbase.downloader.model.DownloadTask downloadTask;
    private com.ss.android.socialbase.downloader.network.IDownloadHttpConnection httpConnection;
    private boolean isHttpConnectionInject;
    private volatile boolean paused;

    public DownloadChunkRunnable(com.ss.android.socialbase.downloader.model.DownloadChunk downloadChunk, com.ss.android.socialbase.downloader.model.DownloadTask downloadTask, com.ss.android.socialbase.downloader.network.IDownloadHttpConnection iDownloadHttpConnection, com.ss.android.socialbase.downloader.thread.IDownloadRunnableCallback iDownloadRunnableCallback) {
        this(downloadChunk, downloadTask, iDownloadRunnableCallback);
        this.httpConnection = iDownloadHttpConnection;
    }

    public DownloadChunkRunnable(com.ss.android.socialbase.downloader.model.DownloadChunk downloadChunk, com.ss.android.socialbase.downloader.model.DownloadTask downloadTask, com.ss.android.socialbase.downloader.thread.IDownloadRunnableCallback iDownloadRunnableCallback) {
        this.isHttpConnectionInject = false;
        this.downloadChunk = downloadChunk;
        this.downloadTask = downloadTask;
        if (downloadTask != null) {
            this.downloadInfo = downloadTask.getDownloadInfo();
        }
        this.callback = iDownloadRunnableCallback;
        this.downloadCache = com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.getDownloadCache();
        this.downloadChunk.setChunkRunnable(this);
    }

    private void closeConnection() {
        com.ss.android.socialbase.downloader.network.IDownloadHttpConnection iDownloadHttpConnection = this.httpConnection;
        if (iDownloadHttpConnection != null) {
            iDownloadHttpConnection.end();
            this.httpConnection = null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:131:0x01d7 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:169:0x00fa A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:184:0x0194 A[Catch: all -> 0x01ad, BaseException -> 0x01af, TRY_LEAVE, TryCatch #4 {BaseException -> 0x01af, blocks: (B:55:0x013f, B:57:0x0146, B:61:0x0152, B:62:0x0158, B:167:0x0177, B:168:0x0185, B:182:0x0190, B:184:0x0194, B:195:0x01a9, B:196:0x01ac), top: B:54:0x013f }] */
    /* JADX WARN: Removed duplicated region for block: B:198:? A[Catch: all -> 0x01ad, BaseException -> 0x01af, SYNTHETIC, TRY_LEAVE, TryCatch #4 {BaseException -> 0x01af, blocks: (B:55:0x013f, B:57:0x0146, B:61:0x0152, B:62:0x0158, B:167:0x0177, B:168:0x0185, B:182:0x0190, B:184:0x0194, B:195:0x01a9, B:196:0x01ac), top: B:54:0x013f }] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00fe A[Catch: all -> 0x01b1, BaseException -> 0x01cd, TRY_ENTER, TryCatch #1 {BaseException -> 0x01cd, blocks: (B:22:0x004e, B:24:0x0058, B:27:0x0063, B:46:0x00f4, B:48:0x00fe, B:50:0x0102, B:52:0x0130, B:202:0x00da), top: B:21:0x004e }] */
    /* JADX WARN: Removed duplicated region for block: B:74:0x01db A[Catch: all -> 0x029e, TRY_ENTER, TryCatch #16 {all -> 0x029e, blocks: (B:72:0x01d1, B:74:0x01db, B:128:0x01e1, B:76:0x01ea, B:78:0x01f2, B:109:0x01f8, B:81:0x0203, B:83:0x0207, B:85:0x020f, B:87:0x0220, B:89:0x0246, B:91:0x024c, B:92:0x0259, B:94:0x0261, B:99:0x0253, B:102:0x022d, B:104:0x0239, B:113:0x026c, B:115:0x0274, B:117:0x027c, B:119:0x0284, B:121:0x028c, B:124:0x0295, B:140:0x01b3, B:145:0x01bd, B:150:0x01c4), top: B:71:0x01d1, inners: #14 }] */
    /* JADX WARN: Removed duplicated region for block: B:91:0x024c A[Catch: all -> 0x029e, TryCatch #16 {all -> 0x029e, blocks: (B:72:0x01d1, B:74:0x01db, B:128:0x01e1, B:76:0x01ea, B:78:0x01f2, B:109:0x01f8, B:81:0x0203, B:83:0x0207, B:85:0x020f, B:87:0x0220, B:89:0x0246, B:91:0x024c, B:92:0x0259, B:94:0x0261, B:99:0x0253, B:102:0x022d, B:104:0x0239, B:113:0x026c, B:115:0x0274, B:117:0x027c, B:119:0x0284, B:121:0x028c, B:124:0x0295, B:140:0x01b3, B:145:0x01bd, B:150:0x01c4), top: B:71:0x01d1, inners: #14 }] */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0261 A[Catch: all -> 0x029e, TRY_ENTER, TRY_LEAVE, TryCatch #16 {all -> 0x029e, blocks: (B:72:0x01d1, B:74:0x01db, B:128:0x01e1, B:76:0x01ea, B:78:0x01f2, B:109:0x01f8, B:81:0x0203, B:83:0x0207, B:85:0x020f, B:87:0x0220, B:89:0x0246, B:91:0x024c, B:92:0x0259, B:94:0x0261, B:99:0x0253, B:102:0x022d, B:104:0x0239, B:113:0x026c, B:115:0x0274, B:117:0x027c, B:119:0x0284, B:121:0x028c, B:124:0x0295, B:140:0x01b3, B:145:0x01bd, B:150:0x01c4), top: B:71:0x01d1, inners: #14 }] */
    /* JADX WARN: Removed duplicated region for block: B:96:0x025d A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0253 A[Catch: all -> 0x029e, TryCatch #16 {all -> 0x029e, blocks: (B:72:0x01d1, B:74:0x01db, B:128:0x01e1, B:76:0x01ea, B:78:0x01f2, B:109:0x01f8, B:81:0x0203, B:83:0x0207, B:85:0x020f, B:87:0x0220, B:89:0x0246, B:91:0x024c, B:92:0x0259, B:94:0x0261, B:99:0x0253, B:102:0x022d, B:104:0x0239, B:113:0x026c, B:115:0x0274, B:117:0x027c, B:119:0x0284, B:121:0x028c, B:124:0x0295, B:140:0x01b3, B:145:0x01bd, B:150:0x01c4), top: B:71:0x01d1, inners: #14 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean downloadChunkInner(com.ss.android.socialbase.downloader.model.DownloadChunk downloadChunk) {
        com.ss.android.socialbase.downloader.model.DownloadChunk downloadChunk2;
        boolean z;
        long j;
        long j2;
        com.ss.android.socialbase.downloader.network.IDownloadHttpConnection iDownloadHttpConnection;
        while (true) {
            if (!downloadChunk.isHostChunk() || !downloadChunk.hasChunkDivided() || (downloadChunk2 = downloadChunk.getFirstReuseChunk()) == null || downloadChunk2.getChunkIndex() != downloadChunk.getChunkIndex()) {
                downloadChunk2 = null;
            }
            com.ss.android.socialbase.downloader.model.DownloadChunk downloadChunk3 = downloadChunk2;
            if (downloadChunk3 != null && downloadChunk3.hasNoBytesDownload()) {
                return true;
            }
            long currentOffset = downloadChunk.getCurrentOffset();
            long endOffset = downloadChunk.getEndOffset();
            long currentOffset2 = downloadChunk.getCurrentOffset();
            if (downloadChunk3 != null) {
                currentOffset2 = downloadChunk3.getCurrentOffset();
                currentOffset = downloadChunk3.getCurrentOffset();
                endOffset = downloadChunk3.getEndOffset();
            }
            long j3 = currentOffset;
            long j4 = endOffset;
            long j5 = 0;
            boolean z2 = false;
            try {
                try {
                    if (isStoppedStatus()) {
                        return false;
                    }
                    java.lang.String url = getUrl();
                    boolean z3 = this.httpConnection != null;
                    this.isHttpConnectionInject = z3;
                    downloadChunk.setReuseingFirstConnection(z3);
                    try {
                        if (!this.isHttpConnectionInject) {
                            java.util.List<com.ss.android.socialbase.downloader.model.HttpHeader> addRangeHeader = com.ss.android.socialbase.downloader.utils.DownloadUtils.addRangeHeader(this.downloadInfo.getExtraHeaders(), this.downloadInfo.geteTag(), j3, j4);
                            addRangeHeader.add(new com.ss.android.socialbase.downloader.model.HttpHeader("Chunk-Index", java.lang.String.valueOf(downloadChunk.getChunkIndex())));
                            com.ss.android.socialbase.downloader.utils.DownloadUtils.addThrottleNetSpeed(addRangeHeader, this.downloadInfo);
                            com.ss.android.socialbase.downloader.utils.DownloadUtils.addTTNetProtectTimeout(addRangeHeader, this.downloadInfo);
                            this.httpConnection = com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.downloadWithConnection(this.downloadInfo.isNeedDefaultHttpServiceBackUp(), this.downloadInfo.getMaxBytes(), url, addRangeHeader);
                        }
                        try {
                            com.ss.android.socialbase.downloader.network.IDownloadHttpConnection iDownloadHttpConnection2 = this.httpConnection;
                            if (iDownloadHttpConnection2 != null && this.callback != null) {
                                try {
                                    int responseCode = iDownloadHttpConnection2.getResponseCode();
                                    if (responseCode < 200 || responseCode >= 300) {
                                        this.callback.setHttpResponseStatus(this.httpConnection);
                                    }
                                } catch (java.lang.Throwable th) {
                                    th = th;
                                    th.printStackTrace();
                                    if (isStoppedStatus()) {
                                    }
                                }
                            }
                        } catch (com.ss.android.socialbase.downloader.exception.BaseException e) {
                            e = e;
                            j = currentOffset2;
                            z = false;
                            try {
                                if (isStoppedStatus()) {
                                }
                            } finally {
                                closeConnection();
                            }
                        }
                    } catch (com.ss.android.socialbase.downloader.exception.BaseException e2) {
                        try {
                            throw e2;
                        } catch (java.lang.Throwable th2) {
                            th = th2;
                            java.lang.Throwable th3 = th;
                            iDownloadHttpConnection = this.httpConnection;
                            if (iDownloadHttpConnection != null) {
                            }
                        }
                    } catch (java.lang.Throwable th4) {
                        try {
                            com.ss.android.socialbase.downloader.utils.DownloadUtils.parseException(th4, "ChunkRunnableConnection");
                            com.ss.android.socialbase.downloader.network.IDownloadHttpConnection iDownloadHttpConnection3 = this.httpConnection;
                            if (iDownloadHttpConnection3 != null && this.callback != null) {
                                try {
                                    int responseCode2 = iDownloadHttpConnection3.getResponseCode();
                                    if (responseCode2 < 200 || responseCode2 >= 300) {
                                        this.callback.setHttpResponseStatus(this.httpConnection);
                                    }
                                } catch (java.lang.Throwable th5) {
                                    th = th5;
                                    th.printStackTrace();
                                    if (isStoppedStatus()) {
                                    }
                                }
                            }
                        } catch (java.lang.Throwable th6) {
                            th = th6;
                            java.lang.Throwable th32 = th;
                            iDownloadHttpConnection = this.httpConnection;
                            if (iDownloadHttpConnection != null) {
                                throw th32;
                            }
                            if (this.callback == null) {
                                throw th32;
                            }
                            try {
                                int responseCode3 = iDownloadHttpConnection.getResponseCode();
                                if (responseCode3 >= 200 && responseCode3 < 300) {
                                    throw th32;
                                }
                                this.callback.setHttpResponseStatus(this.httpConnection);
                                throw th32;
                            } catch (java.lang.Throwable th7) {
                                th7.printStackTrace();
                                throw th32;
                            }
                        }
                    }
                    if (isStoppedStatus()) {
                        return false;
                    }
                    com.ss.android.socialbase.downloader.network.IDownloadHttpConnection iDownloadHttpConnection4 = this.httpConnection;
                    if (iDownloadHttpConnection4 == null) {
                        throw new com.ss.android.socialbase.downloader.exception.BaseException(1022, new java.io.IOException("download can't continue, chunk connection is null"));
                    }
                    if (!this.isHttpConnectionInject) {
                        try {
                            int responseCode4 = iDownloadHttpConnection4.getResponseCode();
                            if (!com.ss.android.socialbase.downloader.utils.DownloadUtils.isResponseCodeValid(responseCode4)) {
                                throw new com.ss.android.socialbase.downloader.exception.BaseException(1002, java.lang.String.format("Http response error , code is : %s ", java.lang.String.valueOf(responseCode4)));
                            }
                        } catch (com.ss.android.socialbase.downloader.exception.BaseException e3) {
                            throw e3;
                        } catch (java.lang.Throwable th8) {
                            com.ss.android.socialbase.downloader.utils.DownloadUtils.parseException(th8, "ChunkRunnableGetResponseCode");
                        }
                    }
                    z = false;
                    j = currentOffset2;
                    try {
                        try {
                            this.downloadResponseHandler = new com.ss.android.socialbase.downloader.downloader.DownloadResponseHandler(this.downloadInfo, url, this.httpConnection, downloadChunk, this.callback);
                            if (downloadChunk3 != null) {
                                long retainLength = downloadChunk3.getRetainLength(false);
                                if (j4 != 0 && j4 >= j3) {
                                    retainLength = (j4 - j3) + 1;
                                }
                                this.downloadResponseHandler.setChunkOffset(downloadChunk3.getCurrentOffset(), downloadChunk3.getEndOffset(), retainLength);
                            }
                            try {
                                this.downloadResponseHandler.handleResponse();
                                return true;
                            } catch (com.ss.android.socialbase.downloader.exception.BaseException e4) {
                                e = e4;
                                z2 = true;
                                if (isStoppedStatus()) {
                                    return true;
                                }
                                if (com.ss.android.socialbase.downloader.utils.DownloadUtils.isResponseCodeError(e)) {
                                    this.callback.onAllChunkRetryWithReset(e, z);
                                    return z;
                                }
                                if (!this.callback.canRetry(e)) {
                                    if (!this.downloadInfo.isNeedChunkDowngradeRetry() || this.downloadInfo.isChunkDowngradeRetryUsed() || this.downloadInfo.getChunkCount() <= 1 || !com.ss.android.socialbase.downloader.utils.DownloadUtils.canChunkDowngradeRetry(e, this.downloadInfo)) {
                                        this.callback.onError(e);
                                        return z;
                                    }
                                    this.callback.onChunkDowngradeRetry(e);
                                    return z;
                                }
                                if (com.ss.android.socialbase.downloader.utils.DownloadUtils.isHttpDataDirtyError(e)) {
                                    this.callback.onAllChunkRetryWithReset(e, true);
                                    return z;
                                }
                                if (z2) {
                                    if (this.downloadResponseHandler == null) {
                                        this.callback.onError(e);
                                        return z;
                                    }
                                    if (com.ss.android.socialbase.downloader.utils.DownloadExpSwitchCode.isSwitchEnable(32)) {
                                        j2 = this.downloadResponseHandler.getCurOffset() - this.downloadResponseHandler.getLastSyncBytes();
                                        if (j2 > 0) {
                                            revertDownloadChunk(downloadChunk, this.downloadResponseHandler.getLastSyncBytes());
                                        } else if (j2 < 0) {
                                        }
                                        if ((!com.ss.android.socialbase.downloader.utils.DownloadExpSwitchCode.isSwitchEnable(16) ? this.callback.onSingleChunkRetry(downloadChunk, e, j2) : this.callback.onRetry(e, j2)) != com.ss.android.socialbase.downloader.exception.RetryCheckStatus.RETURN) {
                                            return z;
                                        }
                                        downloadChunk.setReuseingFirstConnection(z);
                                        closeConnection();
                                    } else {
                                        j5 = this.downloadResponseHandler.getCurOffset() - j;
                                        revertDownloadChunk(downloadChunk, j);
                                    }
                                }
                                j2 = j5;
                                if ((!com.ss.android.socialbase.downloader.utils.DownloadExpSwitchCode.isSwitchEnable(16) ? this.callback.onSingleChunkRetry(downloadChunk, e, j2) : this.callback.onRetry(e, j2)) != com.ss.android.socialbase.downloader.exception.RetryCheckStatus.RETURN) {
                                }
                            }
                        } catch (com.ss.android.socialbase.downloader.exception.BaseException e5) {
                            e = e5;
                            z2 = false;
                            if (isStoppedStatus()) {
                            }
                        }
                    } catch (java.lang.Throwable th9) {
                        th = th9;
                        if (isStoppedStatus()) {
                            return true;
                        }
                        try {
                            com.ss.android.socialbase.downloader.utils.DownloadUtils.parseException(th, "downloadChunkInner");
                        } catch (com.ss.android.socialbase.downloader.exception.BaseException e6) {
                            this.callback.onError(e6);
                        }
                        return z;
                    }
                } catch (com.ss.android.socialbase.downloader.exception.BaseException e7) {
                    e = e7;
                    j = currentOffset2;
                    z = false;
                }
            } catch (java.lang.Throwable th10) {
                th = th10;
                z = false;
            }
        }
    }

    private java.lang.String getUrl() {
        return this.downloadInfo.getConnectionUrl();
    }

    private boolean isStoppedStatus() {
        return this.paused || this.canceled;
    }

    private void revertDownloadChunk(com.ss.android.socialbase.downloader.model.DownloadChunk downloadChunk, long j) {
        com.ss.android.socialbase.downloader.model.DownloadChunk firstReuseChunk = downloadChunk.isHostChunk() ? downloadChunk.getFirstReuseChunk() : downloadChunk;
        if (firstReuseChunk == null) {
            if (downloadChunk.isHostChunk()) {
                this.downloadCache.updateDownloadChunk(downloadChunk.getId(), downloadChunk.getChunkIndex(), j);
            }
        } else {
            if (firstReuseChunk.canRefreshCurOffsetForReuseChunk()) {
                this.downloadCache.updateDownloadChunk(firstReuseChunk.getId(), firstReuseChunk.getHostChunkIndex(), j);
            }
            firstReuseChunk.setCurrentOffset(j);
            this.downloadCache.updateSubDownloadChunk(firstReuseChunk.getId(), firstReuseChunk.getChunkIndex(), firstReuseChunk.getHostChunkIndex(), j);
        }
    }

    public void cancel() {
        this.canceled = true;
        com.ss.android.socialbase.downloader.downloader.DownloadResponseHandler downloadResponseHandler = this.downloadResponseHandler;
        if (downloadResponseHandler != null) {
            downloadResponseHandler.cancel();
        }
    }

    public int getChunkIndex() {
        return this.downloadChunk.getChunkIndex();
    }

    public void pause() {
        this.paused = true;
        com.ss.android.socialbase.downloader.downloader.DownloadResponseHandler downloadResponseHandler = this.downloadResponseHandler;
        if (downloadResponseHandler != null) {
            downloadResponseHandler.pause();
        }
    }

    public void refreshResponseHandleOffset(long j, long j2) {
        com.ss.android.socialbase.downloader.downloader.DownloadResponseHandler downloadResponseHandler = this.downloadResponseHandler;
        if (downloadResponseHandler == null) {
            return;
        }
        downloadResponseHandler.setEndOffset(j, j2);
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x0017, code lost:
    
        r3.curDownloadChunk.setDownloading(false);
     */
    @Override // java.lang.Runnable
    @android.annotation.SuppressLint({"DefaultLocale"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void run() {
        android.os.Process.setThreadPriority(10);
        this.curDownloadChunk = this.downloadChunk;
        while (true) {
            try {
                this.curDownloadChunk.setChunkRunnable(this);
                if (!downloadChunkInner(this.curDownloadChunk)) {
                    break;
                }
                this.curDownloadChunk.setDownloading(false);
                if (!isStoppedStatus()) {
                    this.curDownloadChunk = this.callback.getUnCompletedSubChunk(this.curDownloadChunk.getChunkIndex());
                    if (isStoppedStatus() || this.curDownloadChunk == null) {
                        break;
                    }
                    try {
                        java.lang.Thread.sleep(50L);
                    } catch (java.lang.Throwable th) {
                        th.printStackTrace();
                    }
                } else {
                    break;
                }
            } finally {
                com.ss.android.socialbase.downloader.model.DownloadChunk downloadChunk = this.curDownloadChunk;
                if (downloadChunk != null) {
                    downloadChunk.setDownloading(false);
                }
                closeConnection();
                this.callback.onCompleted(this);
            }
        }
    }
}
