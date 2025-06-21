package com.ss.android.socialbase.downloader.segment;

/* loaded from: classes19.dex */
class SegmentReader implements java.lang.Runnable {
    private static final int SEGMENT_APPLY_RETRY_MAX_COUNT = 50;
    private static final int SWITCH_URL_MAX_COUNT = 30;
    private static final java.lang.String TAG = "SegmentReader";
    private volatile boolean changeSegment;
    private volatile boolean closed;
    volatile long connectEndTime;
    volatile long connectStartTime;
    java.lang.String curHostIp;
    java.lang.String curHostRealIp;
    private int curRetryCount;
    volatile com.ss.android.socialbase.downloader.segment.Segment curSegment;
    java.lang.String curUrl;
    private final com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo;
    private volatile long endOffsetInConnection;
    private boolean exited;
    private boolean failed;
    private com.ss.android.socialbase.downloader.exception.BaseException failedException;
    private java.util.concurrent.Future future;
    private final com.ss.android.socialbase.downloader.segment.ISegmentCallback host;
    private com.ss.android.socialbase.downloader.network.IDownloadHttpConnection httpConnection;
    private com.ss.android.socialbase.downloader.model.HttpResponse httpResponse;
    private boolean httpsToHttpRetryUsed;
    private long lastConnectStartTime;
    private final com.ss.android.socialbase.downloader.segment.IBufferPool pool;
    private volatile long readBytes;
    volatile long readEndTime;
    volatile long readStartTime;
    private volatile boolean reconnect;
    private int retryCount;
    private int segmentApplyRetryTimes;
    private volatile long segmentNewEndOffset;
    private final com.ss.android.socialbase.downloader.setting.DownloadSetting setting;
    private long startOffsetInConnection;
    private com.ss.android.socialbase.downloader.utils.DownloadStenographer stenographer;
    private int switchUrlTimes;
    private java.lang.Thread thread;
    private volatile boolean threadDirty;
    final int threadIndex;
    com.ss.android.socialbase.downloader.segment.UrlRecord urlRecord;
    private final java.util.List<com.ss.android.socialbase.downloader.segment.Segment> succeedSegments = new java.util.ArrayList();
    private volatile long curSegmentReadOffset = -1;

    public SegmentReader(com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo, com.ss.android.socialbase.downloader.segment.SegmentDispatcher segmentDispatcher, com.ss.android.socialbase.downloader.segment.IBufferPool iBufferPool, com.ss.android.socialbase.downloader.segment.UrlRecord urlRecord, int i) {
        this.downloadInfo = downloadInfo;
        this.host = segmentDispatcher;
        this.pool = iBufferPool;
        this.setting = com.ss.android.socialbase.downloader.setting.DownloadSetting.obtain(downloadInfo.getId());
        this.urlRecord = urlRecord;
        this.threadIndex = i;
    }

    private boolean checkCanUseHttpsToHttpRetry(com.ss.android.socialbase.downloader.exception.BaseException baseException) {
        if (!com.ss.android.socialbase.downloader.utils.DownloadUtils.isHttpsError(baseException)) {
            return false;
        }
        java.lang.String str = this.urlRecord.url;
        if (android.text.TextUtils.isEmpty(str) || !str.startsWith("https") || !this.downloadInfo.isNeedHttpsToHttpRetry() || this.httpsToHttpRetryUsed) {
            return false;
        }
        this.httpsToHttpRetryUsed = true;
        resetRetryTimes();
        return true;
    }

    private void closeConnection() {
        com.ss.android.socialbase.downloader.network.IDownloadHttpConnection iDownloadHttpConnection = this.httpConnection;
        if (iDownloadHttpConnection != null) {
            try {
                com.ss.android.socialbase.downloader.logger.Logger.i(TAG, "closeConnection: thread = " + this.threadIndex);
                iDownloadHttpConnection.end();
                iDownloadHttpConnection.cancel();
            } catch (java.lang.Throwable unused) {
            }
        }
    }

    private void createConnection(com.ss.android.socialbase.downloader.segment.Segment segment) throws com.ss.android.socialbase.downloader.exception.BaseException {
        java.lang.String str;
        java.lang.String str2;
        com.ss.android.socialbase.downloader.network.IDownloadHttpConnection downloadWithConnection;
        try {
            try {
                long currentTimeMillis = java.lang.System.currentTimeMillis();
                this.connectEndTime = 0L;
                this.connectStartTime = currentTimeMillis;
                this.startOffsetInConnection = segment.getCurrentOffsetRead();
                this.endOffsetInConnection = segment.getEndOffset();
                if (this.endOffsetInConnection > 0 && this.startOffsetInConnection > this.endOffsetInConnection) {
                    throw new com.ss.android.socialbase.downloader.segment.SegmentApplyException(6, "createConn, ".concat(java.lang.String.valueOf(segment)));
                }
                this.stenographer = new com.ss.android.socialbase.downloader.utils.DownloadStenographer();
                java.util.List<com.ss.android.socialbase.downloader.model.HttpHeader> addRangeHeader = com.ss.android.socialbase.downloader.utils.DownloadUtils.addRangeHeader(this.downloadInfo.getExtraHeaders(), this.downloadInfo.geteTag(), this.startOffsetInConnection, this.endOffsetInConnection);
                addRangeHeader.add(new com.ss.android.socialbase.downloader.model.HttpHeader("Segment-Index", java.lang.String.valueOf(segment.getIndex())));
                addRangeHeader.add(new com.ss.android.socialbase.downloader.model.HttpHeader("Thread-Index", java.lang.String.valueOf(this.threadIndex)));
                com.ss.android.socialbase.downloader.utils.DownloadUtils.addThrottleNetSpeed(addRangeHeader, this.downloadInfo);
                com.ss.android.socialbase.downloader.utils.DownloadUtils.addTTNetProtectTimeout(addRangeHeader, this.downloadInfo);
                str = this.urlRecord.url;
                if (this.httpsToHttpRetryUsed && !android.text.TextUtils.isEmpty(str) && str.startsWith("https")) {
                    str = str.replaceFirst("https", com.alipay.sdk.m.l.a.q);
                }
                str2 = this.urlRecord.ip;
                com.ss.android.socialbase.downloader.logger.Logger.i(TAG, "createConnectionBegin: url = " + str + ", ip = " + str2 + ", segment = " + segment + ", threadIndex = " + this.threadIndex);
                this.curUrl = str;
                this.curHostIp = str2;
                downloadWithConnection = com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.downloadWithConnection(this.downloadInfo.isNeedDefaultHttpServiceBackUp(), this.downloadInfo.getMaxBytes(), str, str2, addRangeHeader, 0, currentTimeMillis - this.lastConnectStartTime > 3000 && this.setting.optInt(com.ss.android.socialbase.downloader.setting.DownloadSettingKeys.MONITOR_DOWNLOAD_CONNECT) > 0, this.downloadInfo);
            } finally {
                this.connectEndTime = java.lang.System.currentTimeMillis();
            }
        } catch (com.ss.android.socialbase.downloader.exception.BaseException e) {
            throw e;
        } catch (java.lang.Throwable th) {
            com.ss.android.socialbase.downloader.utils.DownloadUtils.parseException(th, "createConn");
        }
        if (downloadWithConnection == null) {
            throw new com.ss.android.socialbase.downloader.exception.BaseException(1022, new java.io.IOException("download can't continue, chunk connection is null"));
        }
        this.httpConnection = downloadWithConnection;
        this.httpResponse = new com.ss.android.socialbase.downloader.model.HttpResponse(str, downloadWithConnection);
        if (this.closed) {
            throw new com.ss.android.socialbase.downloader.segment.StreamClosedException("createConn");
        }
        if (downloadWithConnection instanceof com.ss.android.socialbase.downloader.network.AbsDownloadHttpConnection) {
            this.curHostRealIp = ((com.ss.android.socialbase.downloader.network.AbsDownloadHttpConnection) downloadWithConnection).getHostIp();
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder("createConnectionSuccess: url = ");
        sb.append(str);
        sb.append(", ip = ");
        sb.append(str2);
        sb.append(", hostRealIp = ");
        sb.append(this.curHostRealIp);
        sb.append(", threadIndex = ");
        sb.append(this.threadIndex);
    }

    private void doConnect(com.ss.android.socialbase.downloader.segment.Segment segment) throws com.ss.android.socialbase.downloader.exception.BaseException, com.ss.android.socialbase.downloader.exception.RetryThrowable {
        createConnection(segment);
        this.host.onSegmentConnected(this, segment, this.urlRecord, this.httpResponse);
        this.urlRecord.recordSucceed();
    }

    private boolean download(com.ss.android.socialbase.downloader.segment.Segment segment) throws com.ss.android.socialbase.downloader.exception.BaseException {
        initParams();
        while (true) {
            try {
                try {
                    doConnect(segment);
                    loopAndRead(segment);
                    releaseDownload();
                    return true;
                } catch (com.ss.android.socialbase.downloader.segment.SegmentApplyException e) {
                    this.failedException = e;
                    throw e;
                }
            } catch (java.lang.Throwable th) {
                try {
                    com.ss.android.socialbase.downloader.logger.Logger.e(TAG, "download: e = " + th + ", threadIndex = " + this.threadIndex + ", reconnect = " + this.reconnect + ", closed = " + this.closed);
                    if (this.closed) {
                        releaseDownload();
                        return false;
                    }
                    if (this.reconnect) {
                        this.reconnect = false;
                        try {
                            java.lang.Thread.interrupted();
                        } catch (java.lang.Throwable th2) {
                            th2.printStackTrace();
                        }
                        if (this.changeSegment) {
                            this.changeSegment = false;
                            throw new com.ss.android.socialbase.downloader.segment.SegmentApplyException(5, "download");
                        }
                    } else {
                        th.printStackTrace();
                        if (th instanceof com.ss.android.socialbase.downloader.exception.BaseException) {
                            e = th;
                        } else {
                            try {
                                com.ss.android.socialbase.downloader.utils.DownloadUtils.parseException(th, "download");
                                e = null;
                            } catch (com.ss.android.socialbase.downloader.exception.BaseException e2) {
                                e = e2;
                            }
                        }
                        if (e == null || !handleFailedAndCheckRetry(segment, e)) {
                            releaseDownload();
                            return false;
                        }
                    }
                    releaseDownload();
                } catch (java.lang.Throwable th3) {
                    releaseDownload();
                    throw th3;
                }
            }
        }
        releaseDownload();
        return false;
    }

    private boolean handleFailedAndCheckRetry(com.ss.android.socialbase.downloader.segment.Segment segment, com.ss.android.socialbase.downloader.exception.BaseException baseException) {
        com.ss.android.socialbase.downloader.logger.Logger.e(TAG, "handleDownloadFailed:  e = " + baseException + ", curRetryCount = " + this.curRetryCount + ", retryCount = " + this.retryCount);
        this.failedException = baseException;
        this.urlRecord.recordFailed();
        this.host.onSegmentRetry(this, this.urlRecord, segment, baseException, this.curRetryCount, this.retryCount);
        int i = this.curRetryCount;
        if (i < this.retryCount) {
            this.curRetryCount = i + 1;
            return true;
        }
        if (checkCanUseHttpsToHttpRetry(baseException)) {
            return true;
        }
        this.host.onSegmentFailed(this, this.urlRecord, segment, baseException);
        return false;
    }

    private void initParams() {
        this.httpsToHttpRetryUsed = false;
        resetRetryTimes();
    }

    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't find top splitter block for handler:B:122:0x0156
        	at jadx.core.utils.BlockUtils.getTopSplitterForHandler(BlockUtils.java:1179)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.collectHandlerRegions(ExcHandlersRegionMaker.java:53)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.process(ExcHandlersRegionMaker.java:38)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:27)
        */
    /* JADX WARN: Removed duplicated region for block: B:220:0x0352  */
    /* JADX WARN: Removed duplicated region for block: B:223:0x035f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void loopAndRead(com.ss.android.socialbase.downloader.segment.Segment r32) throws com.ss.android.socialbase.downloader.exception.BaseException {
        /*
            Method dump skipped, instructions count: 925
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.downloader.segment.SegmentReader.loopAndRead(com.ss.android.socialbase.downloader.segment.Segment):void");
    }

    private com.ss.android.socialbase.downloader.segment.Buffer probeFirstBuffer(com.ss.android.socialbase.downloader.segment.IBufferPool iBufferPool, java.io.InputStream inputStream) throws java.lang.InterruptedException, com.ss.android.socialbase.downloader.exception.BaseException, java.io.IOException {
        int i;
        com.ss.android.socialbase.downloader.segment.Buffer obtain = iBufferPool.obtain();
        try {
            i = inputStream.read(obtain.data);
        } catch (java.lang.Throwable th) {
            th = th;
            i = -1;
        }
        try {
            if (i == -1) {
                throw new com.ss.android.socialbase.downloader.exception.BaseException(com.ss.android.socialbase.downloader.constants.DownloadErrorCode.ERROR_PROBE_FIRST_BUFFER, com.umeng.analytics.pro.ay.f444s);
            }
            obtain.size = i;
            if (i == -1) {
                iBufferPool.recycle(obtain);
            }
            return obtain;
        } catch (java.lang.Throwable th2) {
            th = th2;
            if (i == -1) {
                iBufferPool.recycle(obtain);
            }
            throw th;
        }
    }

    private long refreshSegmentEndOffset() {
        long j = this.segmentNewEndOffset;
        this.segmentNewEndOffset = 0L;
        if (j <= 0) {
            return Long.MAX_VALUE;
        }
        return j;
    }

    private void releaseDownload() {
        this.lastConnectStartTime = this.connectStartTime;
        this.connectStartTime = -1L;
        this.connectEndTime = -1L;
        this.readStartTime = -1L;
        this.readEndTime = -1L;
        closeConnection();
    }

    private void resetRetryTimes() {
        this.retryCount = this.urlRecord.isMainUrl ? this.downloadInfo.getRetryCount() : this.downloadInfo.getBackUpUrlRetryCount();
        this.curRetryCount = 0;
    }

    public boolean adjustSegmentEndOffset(long j) {
        long j2 = this.endOffsetInConnection;
        if (j <= 0 && j2 > 0) {
            return false;
        }
        if (j > j2 && j2 > 0) {
            return false;
        }
        this.segmentNewEndOffset = j;
        this.threadDirty = true;
        return true;
    }

    public void close() {
        com.ss.android.socialbase.downloader.logger.Logger.i(TAG, "close: threadIndex = " + this.threadIndex);
        synchronized (this) {
            this.closed = true;
            this.threadDirty = true;
        }
        closeConnection();
        java.util.concurrent.Future future = this.future;
        if (future != null) {
            this.future = null;
            try {
                future.cancel(true);
            } catch (java.lang.Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public int getCurRetryCount() {
        return this.curRetryCount;
    }

    public long getCurSegmentDownloadSpeed(long j) {
        long j2 = this.readStartTime;
        if (j2 <= 0) {
            return -1L;
        }
        long j3 = j - j2;
        if (j3 <= 0) {
            return -1L;
        }
        long j4 = this.curSegmentReadOffset;
        long j5 = this.startOffsetInConnection;
        if (j5 < 0 || j4 < j5) {
            return 0L;
        }
        return (j4 - j5) / j3;
    }

    public long getCurSegmentReadOffset() {
        return this.curSegmentReadOffset;
    }

    public com.ss.android.socialbase.downloader.exception.BaseException getFailedException() {
        return this.failedException;
    }

    public long getReadBytes() {
        long readingBytes;
        synchronized (this.host) {
            readingBytes = this.readBytes + getReadingBytes();
        }
        return readingBytes;
    }

    public long getReadingBytes() {
        synchronized (this.host) {
            long j = this.curSegmentReadOffset;
            long j2 = this.startOffsetInConnection;
            if (j2 < 0 || j <= j2) {
                return 0L;
            }
            return j - j2;
        }
    }

    public long getRecentDownloadSpeed(long j, long j2) {
        com.ss.android.socialbase.downloader.utils.DownloadStenographer downloadStenographer = this.stenographer;
        if (downloadStenographer == null) {
            return -1L;
        }
        return downloadStenographer.getRecentDownloadSpeed(j, j2);
    }

    public int getRetryCount() {
        return this.retryCount;
    }

    public long getStartOffsetInConnection() {
        return this.startOffsetInConnection;
    }

    public boolean isExited() {
        return this.exited;
    }

    public boolean isFailed() {
        return this.failed;
    }

    public void markProgress(long j) {
        long j2 = this.curSegmentReadOffset;
        com.ss.android.socialbase.downloader.utils.DownloadStenographer downloadStenographer = this.stenographer;
        if (j2 < 0 || downloadStenographer == null) {
            return;
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder("markProgress: curSegmentReadOffset = ");
        sb.append(j2);
        sb.append(", threadIndex = ");
        sb.append(this.threadIndex);
        downloadStenographer.markProgress(j2, j);
    }

    public void reconnect() {
        reconnect(false);
    }

    public void reconnect(boolean z) {
        com.ss.android.socialbase.downloader.logger.Logger.i(TAG, "reconnect: threadIndex = " + this.threadIndex);
        synchronized (this) {
            this.changeSegment = z;
            this.reconnect = true;
            this.threadDirty = true;
        }
        closeConnection();
        java.lang.Thread thread = this.thread;
        if (thread != null) {
            try {
                new java.lang.StringBuilder("reconnect: t.interrupt threadIndex = ").append(this.threadIndex);
                thread.interrupt();
            } catch (java.lang.Throwable unused) {
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0075, code lost:
    
        r5.curSegment = null;
        r2 = r5.host;
     */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void run() {
        com.ss.android.socialbase.downloader.segment.Segment obtainSegment;
        com.ss.android.socialbase.downloader.segment.ISegmentCallback iSegmentCallback;
        com.ss.android.socialbase.downloader.segment.ISegmentCallback iSegmentCallback2;
        android.os.Process.setThreadPriority(10);
        try {
            this.thread = java.lang.Thread.currentThread();
            this.host.onReaderRun(this);
            this.urlRecord.recordUse(this);
            while (true) {
                obtainSegment = this.host.obtainSegment(this, this.urlRecord);
                if (obtainSegment == null) {
                    com.ss.android.socialbase.downloader.logger.Logger.i(TAG, "no more segment, thread_index = " + this.threadIndex);
                    break;
                }
                this.curSegment = obtainSegment;
                try {
                    try {
                    } catch (com.ss.android.socialbase.downloader.segment.SegmentApplyException e) {
                        com.ss.android.socialbase.downloader.logger.Logger.e(TAG, "run: SegmentApplyException, e = ".concat(java.lang.String.valueOf(e)));
                        int i = this.segmentApplyRetryTimes;
                        if (i >= 50) {
                            com.ss.android.socialbase.downloader.logger.Logger.e(TAG, "segment apply failed " + this.segmentApplyRetryTimes + "times, thread_index = " + this.threadIndex);
                            this.curSegment = null;
                            iSegmentCallback = this.host;
                            break;
                        }
                        this.segmentApplyRetryTimes = i + 1;
                        this.curSegment = null;
                        iSegmentCallback2 = this.host;
                    }
                    if (!download(obtainSegment)) {
                        if (!this.closed) {
                            com.ss.android.socialbase.downloader.logger.Logger.e(TAG, "download segment failed, segment = " + obtainSegment + ", thread_index = " + this.threadIndex + ", failedException = " + this.failedException);
                            break;
                        }
                        break;
                    }
                    this.succeedSegments.add(obtainSegment);
                    this.curSegment = null;
                    iSegmentCallback2 = this.host;
                    iSegmentCallback2.unObtainSegment(this, obtainSegment);
                } catch (java.lang.Throwable th) {
                    this.curSegment = null;
                    this.host.unObtainSegment(this, obtainSegment);
                    throw th;
                }
            }
            iSegmentCallback.unObtainSegment(this, obtainSegment);
        } catch (java.lang.Throwable th2) {
            try {
                th2.printStackTrace();
                try {
                    this.urlRecord.recordUnUse(this);
                    this.host.onReaderExit(this);
                } catch (java.lang.Throwable unused) {
                }
                this.thread = null;
            } finally {
                try {
                    this.urlRecord.recordUnUse(this);
                    this.host.onReaderExit(this);
                } catch (java.lang.Throwable unused2) {
                }
                this.thread = null;
            }
        }
    }

    public void setExited(boolean z) {
        this.exited = z;
    }

    public void setFailed(boolean z) {
        this.failed = z;
    }

    public void setFuture(java.util.concurrent.Future future) {
        this.future = future;
    }

    public boolean switchUrlRecord(com.ss.android.socialbase.downloader.segment.UrlRecord urlRecord) {
        int i = this.switchUrlTimes;
        if (i >= 30) {
            return false;
        }
        this.switchUrlTimes = i + 1;
        com.ss.android.socialbase.downloader.segment.UrlRecord urlRecord2 = this.urlRecord;
        if (urlRecord2 != null) {
            urlRecord2.recordUnUse(this);
        }
        urlRecord.recordUse(this);
        this.urlRecord = urlRecord;
        resetRetryTimes();
        return true;
    }

    public void updateReadBytes() {
        com.ss.android.socialbase.downloader.segment.UrlRecord urlRecord = this.urlRecord;
        try {
            synchronized (this.host) {
                long readingBytes = getReadingBytes();
                if (readingBytes > 0) {
                    this.readBytes += readingBytes;
                    urlRecord.increaseDownloadBytes(readingBytes);
                }
                this.curSegmentReadOffset = -1L;
            }
        } catch (java.lang.Throwable unused) {
        }
    }
}
