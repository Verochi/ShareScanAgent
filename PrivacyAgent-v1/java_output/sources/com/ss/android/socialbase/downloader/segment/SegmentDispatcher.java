package com.ss.android.socialbase.downloader.segment;

/* loaded from: classes19.dex */
public class SegmentDispatcher implements com.ss.android.socialbase.downloader.network.DownloadDnsManager.Callback, com.ss.android.socialbase.downloader.segment.ISegmentCallback {
    private static final int READ_WATCH_TIME = 2000;
    private static final java.lang.String TAG = "SegmentDispatcher";
    private final com.ss.android.socialbase.downloader.segment.BufferQueue bufferQueue;
    private long connectTimeout;
    private final boolean debug;
    private final com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo;
    private com.ss.android.socialbase.downloader.exception.BaseException failedException;
    private com.ss.android.socialbase.downloader.model.HttpResponse firstBackupUrlHttpResponse;
    private final com.ss.android.socialbase.downloader.thread.IDownloadRunnableCallback hostCallback;
    private volatile boolean isAllContentDownloaded;
    private long lastReconnectTime;
    private com.ss.android.socialbase.downloader.model.HttpResponse mainUrlHttpResponse;
    private float poorSpeedRatio;
    private long readTimeout;
    private int reconnectCount;
    private final com.ss.android.socialbase.downloader.utils.DownloadStenographer stenographer;
    private final com.ss.android.socialbase.downloader.segment.SegmentStrategy strategy;
    private long totalLength;
    private int urlIndex;
    private final com.ss.android.socialbase.downloader.thread.DownloadWatchDog watchDog;
    private final com.ss.android.socialbase.downloader.segment.MultiSegmentWriter writer;
    private volatile boolean canceled = false;
    private volatile boolean paused = false;
    private final java.util.List<com.ss.android.socialbase.downloader.segment.SegmentReader> readers = new java.util.ArrayList();
    private final java.util.List<com.ss.android.socialbase.downloader.segment.UrlRecord> urlRecords = new java.util.ArrayList();
    private volatile boolean needWaitDnsResolve = true;
    private final java.util.LinkedList<com.ss.android.socialbase.downloader.segment.Segment> toDispatchSegments = new java.util.LinkedList<>();
    private final java.util.List<com.ss.android.socialbase.downloader.segment.Segment> dispatchedSegments = new java.util.ArrayList();
    private final java.lang.Object firstConnectionLock = new java.lang.Object();
    private volatile boolean allReaderFailed = false;
    private final com.ss.android.socialbase.downloader.thread.DownloadWatchDog.IWatcher connectWatcher = new com.ss.android.socialbase.downloader.segment.SegmentDispatcher.AnonymousClass1();
    private final com.ss.android.socialbase.downloader.thread.DownloadWatchDog.IWatcher readWatcher = new com.ss.android.socialbase.downloader.segment.SegmentDispatcher.AnonymousClass2();

    /* renamed from: com.ss.android.socialbase.downloader.segment.SegmentDispatcher$1, reason: invalid class name */
    public class AnonymousClass1 implements com.ss.android.socialbase.downloader.thread.DownloadWatchDog.IWatcher {
        private int watchTimes;

        public AnonymousClass1() {
        }

        @Override // com.ss.android.socialbase.downloader.thread.DownloadWatchDog.IWatcher
        public long onScheduleWatch() {
            if (com.ss.android.socialbase.downloader.segment.SegmentDispatcher.this.canceled || com.ss.android.socialbase.downloader.segment.SegmentDispatcher.this.paused) {
                return -1L;
            }
            synchronized (com.ss.android.socialbase.downloader.segment.SegmentDispatcher.this) {
                if (com.ss.android.socialbase.downloader.segment.SegmentDispatcher.this.mainUrlHttpResponse == null && com.ss.android.socialbase.downloader.segment.SegmentDispatcher.this.firstBackupUrlHttpResponse == null) {
                    long j = com.ss.android.socialbase.downloader.segment.SegmentDispatcher.this.connectTimeout;
                    if (j <= 0) {
                        return -1L;
                    }
                    this.watchTimes++;
                    com.ss.android.socialbase.downloader.segment.SegmentReader findEarliestConnectTimeoutReader = com.ss.android.socialbase.downloader.segment.SegmentDispatcher.this.findEarliestConnectTimeoutReader(false, java.lang.System.currentTimeMillis(), j);
                    if (findEarliestConnectTimeoutReader == null) {
                        return j;
                    }
                    com.ss.android.socialbase.downloader.segment.SegmentDispatcher.this.trySwitchNextUrlForReader(findEarliestConnectTimeoutReader);
                    findEarliestConnectTimeoutReader.reconnect();
                    return ((this.watchTimes / com.ss.android.socialbase.downloader.segment.SegmentDispatcher.this.urlRecords.size()) + 1) * j;
                }
                return -1L;
            }
        }
    }

    /* renamed from: com.ss.android.socialbase.downloader.segment.SegmentDispatcher$2, reason: invalid class name */
    public class AnonymousClass2 implements com.ss.android.socialbase.downloader.thread.DownloadWatchDog.IWatcher {
        public AnonymousClass2() {
        }

        @Override // com.ss.android.socialbase.downloader.thread.DownloadWatchDog.IWatcher
        public long onScheduleWatch() {
            return com.ss.android.socialbase.downloader.segment.SegmentDispatcher.this.scheduleWatchRead();
        }
    }

    public SegmentDispatcher(@androidx.annotation.NonNull com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo, @androidx.annotation.NonNull com.ss.android.socialbase.downloader.segment.SegmentStrategy segmentStrategy, com.ss.android.socialbase.downloader.thread.IDownloadRunnableCallback iDownloadRunnableCallback) {
        this.downloadInfo = downloadInfo;
        this.strategy = segmentStrategy;
        com.ss.android.socialbase.downloader.segment.BufferQueue bufferQueue = new com.ss.android.socialbase.downloader.segment.BufferQueue(segmentStrategy.getBufferCount(), segmentStrategy.getBufferSize());
        this.bufferQueue = bufferQueue;
        this.hostCallback = iDownloadRunnableCallback;
        this.writer = new com.ss.android.socialbase.downloader.segment.MultiSegmentWriter(downloadInfo, iDownloadRunnableCallback, bufferQueue);
        this.watchDog = new com.ss.android.socialbase.downloader.thread.DownloadWatchDog();
        this.stenographer = new com.ss.android.socialbase.downloader.utils.DownloadStenographer();
        this.debug = com.ss.android.socialbase.downloader.setting.DownloadSetting.obtain(downloadInfo.getId()).optInt("debug") == 1;
    }

    private void addIpListLocked(java.lang.String str, java.util.List<com.ss.android.socialbase.downloader.segment.UrlRecord> list) {
        int indexOfUrl;
        if (this.debug) {
            java.util.Iterator<com.ss.android.socialbase.downloader.segment.UrlRecord> it = list.iterator();
            while (it.hasNext()) {
                "addIpListLocked: urlRecord = ".concat(java.lang.String.valueOf(it.next()));
            }
        }
        int ipStrategy = this.strategy.getIpStrategy();
        if ((ipStrategy == 1 || ipStrategy == 3) && (indexOfUrl = indexOfUrl(str)) >= 0 && indexOfUrl < this.urlRecords.size()) {
            this.urlRecords.addAll(indexOfUrl + 1, list);
        } else {
            this.urlRecords.addAll(list);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x0097, code lost:
    
        if ((r10.getCurrentOffsetRead() - r25.getCurrentOffsetRead()) < (r13 / 2)) goto L32;
     */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00dc  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void applySegmentLocked(com.ss.android.socialbase.downloader.segment.SegmentReader segmentReader, com.ss.android.socialbase.downloader.segment.Segment segment) throws com.ss.android.socialbase.downloader.segment.SegmentApplyException {
        com.ss.android.socialbase.downloader.segment.Segment segment2;
        long j;
        long endOffset;
        boolean z;
        com.ss.android.socialbase.downloader.logger.Logger.i(TAG, "applySegment: start ".concat(java.lang.String.valueOf(segment)));
        if (segment.owner == segmentReader) {
            com.ss.android.socialbase.downloader.logger.Logger.i(TAG, "applySegment: " + segmentReader + " is already the owner of " + segment);
            return;
        }
        if (segment.owner != null) {
            com.ss.android.socialbase.downloader.logger.Logger.e(TAG, "applySegment: " + segment + " is already has an owner:" + segment.owner);
            throw new com.ss.android.socialbase.downloader.segment.SegmentApplyException(1, "segment already has an owner");
        }
        if (segmentReader.getStartOffsetInConnection() != segment.getCurrentOffsetRead()) {
            throw new com.ss.android.socialbase.downloader.segment.SegmentApplyException(5, "applySegment");
        }
        long startOffset = segment.getStartOffset();
        int indexOfSegmentLocked = indexOfSegmentLocked(startOffset);
        if (indexOfSegmentLocked == -1 || (segment2 = this.dispatchedSegments.get(indexOfSegmentLocked)) == null) {
            com.ss.android.socialbase.downloader.logger.Logger.e(TAG, "applySegment: " + segment + " not exist! segmentIndex = " + indexOfSegmentLocked);
            throw new com.ss.android.socialbase.downloader.segment.SegmentApplyException(2, "segment not exist");
        }
        if (segment2 != segment) {
            if (segment2.getStartOffset() == segment.getStartOffset()) {
                long remainReadBytes = getRemainReadBytes(segment2);
                if (remainReadBytes > 0) {
                    com.ss.android.socialbase.downloader.segment.SegmentReader segmentReader2 = segment2.owner;
                    if (segmentReader2 != null) {
                        if (remainReadBytes < android.support.v4.media.session.PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED) {
                            j = startOffset;
                            if (segmentReader.readStartTime - segmentReader2.readStartTime > 1000) {
                            }
                        } else {
                            j = startOffset;
                        }
                        "applySegmentLocked: has same segment, but owner is normal, abort. segmentInList = ".concat(java.lang.String.valueOf(segment2));
                        z = false;
                        if (!z) {
                            com.ss.android.socialbase.downloader.logger.Logger.e(TAG, "applySegment: " + segment + " not exist! but has another same segment, segmentInList = " + segment2);
                            throw new com.ss.android.socialbase.downloader.segment.SegmentApplyException(2, "segment not exist, but has another same segment");
                        }
                    } else {
                        j = startOffset;
                    }
                    if (segmentReader2 != null) {
                        "applySegmentLocked: has same segment,and owner too slow, segmentInList = ".concat(java.lang.String.valueOf(segment2));
                        segmentReader2.reconnect(true);
                    } else {
                        "applySegmentLocked: has same segment and no owner, segmentInList = ".concat(java.lang.String.valueOf(segment2));
                    }
                    segment.setEndOffset(segment2.getEndOffset());
                    segment.setCompetitor(segment2.getCompetitor());
                    this.dispatchedSegments.set(indexOfSegmentLocked, segment);
                    z = true;
                    if (!z) {
                    }
                }
            }
            j = startOffset;
            z = false;
            if (!z) {
            }
        } else {
            j = startOffset;
        }
        long downloadBytes = segment.getDownloadBytes();
        int i = indexOfSegmentLocked - 1;
        while (true) {
            if (i < 0) {
                break;
            }
            com.ss.android.socialbase.downloader.segment.Segment segment3 = this.dispatchedSegments.get(i);
            long endOffset2 = segment3.getEndOffset();
            if (endOffset2 <= 0 || endOffset2 >= j) {
                if (downloadBytes <= 0 && segment3.getCurrentOffsetRead() > j) {
                    com.ss.android.socialbase.downloader.logger.Logger.e(TAG, "applySegment:prev's current has over this start, prev = " + segment3 + ", segment = " + segment);
                    this.dispatchedSegments.remove(segment);
                    throw new com.ss.android.socialbase.downloader.segment.SegmentApplyException(3, "prev overstep");
                }
                if (segment3.owner == null) {
                    segment3.setEndOffset(j - 1);
                    com.ss.android.socialbase.downloader.logger.Logger.i(TAG, "applySegment: prev set end, prev = ".concat(java.lang.String.valueOf(segment3)));
                    if (segment3.getDownloadBytes() > 0) {
                        break;
                    }
                } else {
                    long j2 = j - 1;
                    if (!segment3.owner.adjustSegmentEndOffset(j2)) {
                        com.ss.android.socialbase.downloader.logger.Logger.e(TAG, "applySegment: adjustSegmentEndOffset filed, prev = ".concat(java.lang.String.valueOf(segment3)));
                        throw new com.ss.android.socialbase.downloader.segment.SegmentApplyException(4, "prev end adjust fail");
                    }
                    segment3.setEndOffset(j2);
                    com.ss.android.socialbase.downloader.logger.Logger.i(TAG, "applySegment: adjustSegmentEndOffset succeed, prev = ".concat(java.lang.String.valueOf(segment3)));
                }
            }
            i--;
        }
        int size = this.dispatchedSegments.size();
        for (int i2 = indexOfSegmentLocked + 1; i2 < size; i2++) {
            com.ss.android.socialbase.downloader.segment.Segment segment4 = this.dispatchedSegments.get(i2);
            if (segment4.getDownloadBytes() > 0 || segment4.owner != null) {
                long endOffset3 = segment.getEndOffset();
                long startOffset2 = segment4.getStartOffset();
                if (endOffset3 <= 0 || endOffset3 >= startOffset2) {
                    long j3 = startOffset2 - 1;
                    segment.setEndOffset(j3);
                    com.ss.android.socialbase.downloader.logger.Logger.i(TAG, "applySegment: segment set end:" + j3 + ", later = " + segment4);
                }
                endOffset = segment.getEndOffset();
                if (endOffset <= 0 && (j > endOffset || segment.getCurrentOffsetRead() > endOffset)) {
                    throw new com.ss.android.socialbase.downloader.segment.SegmentApplyException(6, "applySegment: ".concat(java.lang.String.valueOf(segment)));
                }
                segment.owner = segmentReader;
                com.ss.android.socialbase.downloader.logger.Logger.i(TAG, "applySegment: OK ".concat(java.lang.String.valueOf(segment)));
            }
        }
        endOffset = segment.getEndOffset();
        if (endOffset <= 0) {
        }
        segment.owner = segmentReader;
        com.ss.android.socialbase.downloader.logger.Logger.i(TAG, "applySegment: OK ".concat(java.lang.String.valueOf(segment)));
    }

    private void arrangeSegmentLocked(java.util.List<com.ss.android.socialbase.downloader.segment.Segment> list, com.ss.android.socialbase.downloader.segment.Segment segment, boolean z) {
        long startOffset = segment.getStartOffset();
        int size = list.size();
        int i = 0;
        while (i < size && startOffset >= list.get(i).getStartOffset()) {
            i++;
        }
        list.add(i, segment);
        if (z) {
            segment.setIndex(size);
        }
    }

    private java.util.List<com.ss.android.socialbase.downloader.segment.UrlRecord> assembleIpAddress(java.lang.String str, java.util.List<java.net.InetAddress> list) {
        boolean z;
        if (list != null && !list.isEmpty()) {
            java.util.LinkedHashMap linkedHashMap = new java.util.LinkedHashMap();
            int i = 0;
            for (java.net.InetAddress inetAddress : list) {
                if (inetAddress != null) {
                    java.lang.String hostAddress = inetAddress.getHostAddress();
                    if (!android.text.TextUtils.isEmpty(hostAddress)) {
                        if (this.debug) {
                            "onDnsResolved: ip = ".concat(java.lang.String.valueOf(hostAddress));
                        }
                        com.ss.android.socialbase.downloader.segment.UrlRecord urlRecord = new com.ss.android.socialbase.downloader.segment.UrlRecord(str, hostAddress);
                        java.util.LinkedList linkedList = (java.util.LinkedList) linkedHashMap.get(urlRecord.ipFamily);
                        if (linkedList == null) {
                            linkedList = new java.util.LinkedList();
                            linkedHashMap.put(urlRecord.ipFamily, linkedList);
                        }
                        linkedList.add(urlRecord);
                        i++;
                    }
                }
            }
            if (i > 0) {
                java.util.ArrayList arrayList = new java.util.ArrayList();
                do {
                    java.util.Iterator it = linkedHashMap.entrySet().iterator();
                    z = false;
                    while (it.hasNext()) {
                        java.util.LinkedList linkedList2 = (java.util.LinkedList) ((java.util.Map.Entry) it.next()).getValue();
                        if (linkedList2 != null && !linkedList2.isEmpty()) {
                            arrayList.add((com.ss.android.socialbase.downloader.segment.UrlRecord) linkedList2.pollFirst());
                            i--;
                            z = true;
                        }
                    }
                    if (i <= 0) {
                        break;
                    }
                } while (z);
                return arrayList;
            }
        }
        return null;
    }

    private void checkDownloadedBytesLocked(java.util.List<com.ss.android.socialbase.downloader.segment.Segment> list) {
        long downloadedBytes = com.ss.android.socialbase.downloader.segment.SegmentUtils.getDownloadedBytes(list);
        com.ss.android.socialbase.downloader.logger.Logger.i(TAG, "checkDownloadBytes: getCurBytes = " + this.downloadInfo.getCurBytes() + ", totalBytes = " + this.downloadInfo.getTotalBytes() + ", downloadedBytes = " + downloadedBytes);
        if (downloadedBytes > this.downloadInfo.getTotalBytes() && this.downloadInfo.getTotalBytes() > 0) {
            downloadedBytes = this.downloadInfo.getTotalBytes();
        }
        if (this.downloadInfo.getCurBytes() == this.downloadInfo.getTotalBytes() || this.downloadInfo.getCurBytes() == downloadedBytes) {
            return;
        }
        this.downloadInfo.setCurBytes(downloadedBytes);
    }

    private void checkSegmentHttpResponseLocked(com.ss.android.socialbase.downloader.segment.SegmentReader segmentReader, com.ss.android.socialbase.downloader.segment.Segment segment, com.ss.android.socialbase.downloader.segment.UrlRecord urlRecord, com.ss.android.socialbase.downloader.model.HttpResponse httpResponse) throws com.ss.android.socialbase.downloader.exception.BaseException, com.ss.android.socialbase.downloader.exception.RetryThrowable {
        com.ss.android.socialbase.downloader.segment.SegmentReader segmentReader2 = segment.owner;
        if (segmentReader2 != null && segmentReader2 != segmentReader) {
            throw new com.ss.android.socialbase.downloader.segment.SegmentApplyException(1, "segment already has an owner");
        }
        if (segmentReader.getStartOffsetInConnection() != segment.getCurrentOffsetRead()) {
            throw new com.ss.android.socialbase.downloader.segment.SegmentApplyException(5, "applySegment");
        }
        if (!httpResponse.acceptPartial()) {
            if (segment.getCurrentOffsetRead() > 0) {
                throw new com.ss.android.socialbase.downloader.exception.DownloadHttpException(1004, httpResponse.responseCode, "1: response code error : " + httpResponse.responseCode + " segment=" + segment);
            }
            com.ss.android.socialbase.downloader.logger.Logger.e(TAG, "parseHttpResponse: segment.getCurrentOffsetRead = " + segment.getCurrentOffsetRead());
            if (!httpResponse.isResponseDataFromBegin()) {
                throw new com.ss.android.socialbase.downloader.exception.DownloadHttpException(1004, httpResponse.responseCode, "2: response code error : " + httpResponse.responseCode + " segment=" + segment);
            }
        }
        if (!urlRecord.isMainUrl) {
            validateHttpResponse(httpResponse);
            if (this.firstBackupUrlHttpResponse == null) {
                this.firstBackupUrlHttpResponse = httpResponse;
                if (this.downloadInfo.getTotalBytes() <= 0) {
                    long totalLength = httpResponse.getTotalLength();
                    com.ss.android.socialbase.downloader.logger.Logger.i(TAG, "checkSegmentHttpResponse:len=" + totalLength + ",url=" + urlRecord.url);
                    this.downloadInfo.setTotalBytes(totalLength);
                }
                synchronized (this.firstConnectionLock) {
                    this.firstConnectionLock.notify();
                }
                return;
            }
            return;
        }
        if (this.mainUrlHttpResponse == null) {
            this.mainUrlHttpResponse = httpResponse;
            synchronized (this.firstConnectionLock) {
                this.firstConnectionLock.notify();
            }
            com.ss.android.socialbase.downloader.thread.IDownloadRunnableCallback iDownloadRunnableCallback = this.hostCallback;
            if (iDownloadRunnableCallback != null) {
                iDownloadRunnableCallback.handleFirstConnection(urlRecord.url, httpResponse.connection, segment.getCurrentOffsetRead());
            }
            long totalLength2 = httpResponse.getTotalLength();
            if (totalLength2 > 0) {
                for (com.ss.android.socialbase.downloader.segment.Segment segment2 : this.dispatchedSegments) {
                    if (segment2.getEndOffset() <= 0 || segment2.getEndOffset() > totalLength2 - 1) {
                        segment2.setEndOffset(totalLength2 - 1);
                    }
                }
            }
        }
    }

    private void clearCoveredSegmentLocked() {
        int size;
        if (this.totalLength > 0 && (size = this.dispatchedSegments.size()) > 1) {
            java.util.ArrayList<com.ss.android.socialbase.downloader.segment.Segment> arrayList = null;
            int i = 0;
            for (int i2 = 1; i2 < size; i2++) {
                com.ss.android.socialbase.downloader.segment.Segment segment = this.dispatchedSegments.get(i);
                com.ss.android.socialbase.downloader.segment.Segment segment2 = this.dispatchedSegments.get(i2);
                if (segment.getCurrentOffsetRead() > segment2.getStartOffset() && segment2.getDownloadBytes() <= 0 && segment2.owner == null) {
                    if (arrayList == null) {
                        arrayList = new java.util.ArrayList(1);
                    }
                    arrayList.add(segment2);
                    if (this.debug) {
                        java.lang.StringBuilder sb = new java.lang.StringBuilder("clearCovered, covered = ");
                        sb.append(segment2);
                        sb.append(", prev = ");
                        sb.append(segment);
                    }
                } else if (segment2.getCurrentOffsetRead() > segment.getCurrentOffsetRead()) {
                    i++;
                }
            }
            if (arrayList != null) {
                for (com.ss.android.socialbase.downloader.segment.Segment segment3 : arrayList) {
                    this.dispatchedSegments.remove(segment3);
                    for (com.ss.android.socialbase.downloader.segment.SegmentReader segmentReader : this.readers) {
                        if (segmentReader.curSegment == segment3) {
                            if (this.debug) {
                                java.lang.StringBuilder sb2 = new java.lang.StringBuilder("clearCoveredSegmentLocked: reconnect, segment = ");
                                sb2.append(segment3);
                                sb2.append(", threadIndex = ");
                                sb2.append(segmentReader.threadIndex);
                            }
                            segmentReader.reconnect(true);
                        }
                    }
                }
            }
        }
    }

    private void dispatchReadThread() {
        int i;
        if (this.totalLength <= 0 || this.needWaitDnsResolve) {
            i = 1;
        } else {
            i = this.strategy.getThreadCount();
            int segmentMinInitSize = (int) (this.totalLength / this.strategy.getSegmentMinInitSize());
            if (i > segmentMinInitSize) {
                i = segmentMinInitSize;
            }
        }
        com.ss.android.socialbase.downloader.logger.Logger.i(TAG, "dispatchReadThread: totalLength = " + this.totalLength + ", threadCount = " + i);
        int i2 = i > 0 ? i : 1;
        synchronized (this) {
            do {
                if (this.readers.size() >= i2) {
                    break;
                }
                if (!this.paused && !this.canceled) {
                    dispatchReadThreadOnce(obtainUrl());
                }
                return;
            } while (!this.strategy.segmentOneByOne());
        }
    }

    private void dispatchReadThreadOnce(com.ss.android.socialbase.downloader.segment.UrlRecord urlRecord) {
        com.ss.android.socialbase.downloader.segment.SegmentReader segmentReader = new com.ss.android.socialbase.downloader.segment.SegmentReader(this.downloadInfo, this, this.bufferQueue, urlRecord, this.readers.size());
        this.readers.add(segmentReader);
        segmentReader.setFuture(com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.getChunkDownloadThreadExecutorService().submit(segmentReader));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.ss.android.socialbase.downloader.segment.SegmentReader findEarliestConnectTimeoutReader(boolean z, long j, long j2) {
        com.ss.android.socialbase.downloader.segment.SegmentReader segmentReader = null;
        for (com.ss.android.socialbase.downloader.segment.SegmentReader segmentReader2 : this.readers) {
            if (segmentReader2.threadIndex != 0 || z) {
                if (segmentReader2.connectStartTime > 0 && segmentReader2.connectEndTime <= 0 && j - segmentReader2.connectStartTime > j2 && (segmentReader == null || segmentReader2.connectStartTime < segmentReader.connectStartTime)) {
                    segmentReader = segmentReader2;
                }
            }
        }
        return segmentReader;
    }

    private com.ss.android.socialbase.downloader.segment.UrlRecord findNextUrlLocked(com.ss.android.socialbase.downloader.segment.SegmentReader segmentReader) {
        com.ss.android.socialbase.downloader.segment.UrlRecord urlRecord;
        java.util.Iterator<com.ss.android.socialbase.downloader.segment.UrlRecord> it = this.urlRecords.iterator();
        com.ss.android.socialbase.downloader.segment.UrlRecord urlRecord2 = null;
        while (true) {
            if (!it.hasNext()) {
                urlRecord = null;
                break;
            }
            urlRecord = it.next();
            if (urlRecord != segmentReader.urlRecord && !urlRecord.isCurrentFailed()) {
                if (urlRecord2 == null) {
                    urlRecord2 = urlRecord;
                }
                if (urlRecord.getCurrentUsers() <= 0) {
                    break;
                }
            }
        }
        if (this.strategy.urlBalance()) {
            if (urlRecord != null) {
                return urlRecord;
            }
            if (this.strategy.urlBalanceStrictly()) {
                return null;
            }
        }
        return urlRecord2;
    }

    private com.ss.android.socialbase.downloader.segment.SegmentReader findPoorReadThread(long j, long j2, long j3, int i) {
        long j4 = Long.MAX_VALUE;
        int i2 = 0;
        com.ss.android.socialbase.downloader.segment.SegmentReader segmentReader = null;
        for (com.ss.android.socialbase.downloader.segment.SegmentReader segmentReader2 : this.readers) {
            long j5 = 0;
            if (segmentReader2.readStartTime > 0) {
                int i3 = i2 + 1;
                if (segmentReader2.readStartTime < j) {
                    long recentDownloadSpeed = segmentReader2.getRecentDownloadSpeed(j, j2);
                    if (this.debug) {
                        java.lang.StringBuilder sb = new java.lang.StringBuilder("findPoorReadThread: speed = ");
                        sb.append(recentDownloadSpeed);
                        sb.append(", threadIndex = ");
                        sb.append(segmentReader2.threadIndex);
                        j5 = 0;
                    }
                    if (recentDownloadSpeed >= j5 && recentDownloadSpeed < j4) {
                        j4 = recentDownloadSpeed;
                        segmentReader = segmentReader2;
                    }
                }
                i2 = i3;
            }
        }
        if (segmentReader == null || i2 < i || j4 >= j3) {
            return null;
        }
        com.ss.android.socialbase.downloader.logger.Logger.i(TAG, "findPoorReadThread: ----------- minSpeed = " + j4 + ", threadIndex = " + segmentReader.threadIndex);
        return segmentReader;
    }

    private boolean findPoorReadThreadAndReconnect(long j, long j2) {
        long j3 = j - j2;
        long recentDownloadSpeed = this.stenographer.getRecentDownloadSpeed(j3, j);
        int size = this.readers.size();
        if (size > 0) {
            recentDownloadSpeed /= size;
        }
        com.ss.android.socialbase.downloader.segment.SegmentReader findPoorReadThread = findPoorReadThread(j3, j, (long) java.lang.Math.max(10.0f, recentDownloadSpeed * this.poorSpeedRatio), size / 2);
        if (findPoorReadThread != null) {
            trySwitchNextUrlForReader(findPoorReadThread);
            com.ss.android.socialbase.downloader.logger.Logger.w(TAG, "handlePoorReadThread: reconnect for poor speed, threadIndex = " + findPoorReadThread.threadIndex);
            findPoorReadThread.reconnect();
            return true;
        }
        com.ss.android.socialbase.downloader.segment.SegmentReader findEarliestConnectTimeoutReader = findEarliestConnectTimeoutReader(true, j, j2);
        if (findEarliestConnectTimeoutReader == null) {
            return false;
        }
        trySwitchNextUrlForReader(findEarliestConnectTimeoutReader);
        com.ss.android.socialbase.downloader.logger.Logger.w(TAG, "handlePoorReadThread: reconnect for connect timeout, threadIndex = " + findEarliestConnectTimeoutReader.threadIndex);
        findEarliestConnectTimeoutReader.reconnect();
        return true;
    }

    private void fixSegmentsLocked(java.util.List<com.ss.android.socialbase.downloader.segment.Segment> list) {
        com.ss.android.socialbase.downloader.segment.Segment segment = list.get(0);
        long startOffset = segment.getStartOffset();
        if (startOffset > 0) {
            com.ss.android.socialbase.downloader.segment.Segment segment2 = new com.ss.android.socialbase.downloader.segment.Segment(0L, startOffset - 1);
            java.lang.StringBuilder sb = new java.lang.StringBuilder("fixSegmentsLocked: first = ");
            sb.append(segment);
            sb.append(", add new first = ");
            sb.append(segment2);
            arrangeSegmentLocked(list, segment2, true);
        }
        java.util.Iterator<com.ss.android.socialbase.downloader.segment.Segment> it = list.iterator();
        if (it.hasNext()) {
            com.ss.android.socialbase.downloader.segment.Segment next = it.next();
            while (it.hasNext()) {
                com.ss.android.socialbase.downloader.segment.Segment next2 = it.next();
                if (next.getEndOffset() < next2.getStartOffset() - 1) {
                    com.ss.android.socialbase.downloader.logger.Logger.w(TAG, "fixSegment: segment = " + next + ", new end = " + (next2.getStartOffset() - 1));
                    next.setEndOffset(next2.getStartOffset() - 1);
                }
                next = next2;
            }
        }
        com.ss.android.socialbase.downloader.segment.Segment segment3 = list.get(list.size() - 1);
        long totalBytes = this.downloadInfo.getTotalBytes();
        if (totalBytes <= 0 || (segment3.getEndOffset() != -1 && segment3.getEndOffset() < totalBytes - 1)) {
            com.ss.android.socialbase.downloader.logger.Logger.w(TAG, "fixSegment: last segment = " + segment3 + ", new end=-1");
            segment3.setEndOffset(-1L);
        }
    }

    private float getDownloadRatio(com.ss.android.socialbase.downloader.segment.SegmentReader segmentReader, com.ss.android.socialbase.downloader.segment.UrlRecord urlRecord) {
        long readBytes = segmentReader.getReadBytes();
        int size = this.readers.size();
        if (size <= 1) {
            size = this.strategy.getThreadCount();
        }
        float f = 1.0f;
        if (readBytes <= 0) {
            float mainRatio = this.strategy.getMainRatio();
            if (mainRatio <= 0.0f || mainRatio >= 1.0f) {
                mainRatio = 1.0f / size;
            }
            if (segmentReader.threadIndex == 0) {
                return mainRatio;
            }
            if (size > 1) {
                f = 1.0f - mainRatio;
                size--;
            }
        } else {
            long totalReadBytes = getTotalReadBytes();
            if (totalReadBytes > readBytes) {
                return readBytes / totalReadBytes;
            }
        }
        return f / size;
    }

    private long getRemainReadBytes(com.ss.android.socialbase.downloader.segment.Segment segment) {
        long remainReadBytes = segment.getRemainReadBytes();
        if (remainReadBytes != -1) {
            return remainReadBytes;
        }
        long j = this.totalLength;
        return j > 0 ? j - segment.getCurrentOffsetRead() : remainReadBytes;
    }

    private long getTotalReadBytes() {
        java.util.Iterator<com.ss.android.socialbase.downloader.segment.SegmentReader> it = this.readers.iterator();
        long j = 0;
        while (it.hasNext()) {
            j += it.next().getReadBytes();
        }
        return j;
    }

    private long getUnconfirmedRemainBytes(int i, int i2) {
        com.ss.android.socialbase.downloader.segment.Segment segment = this.dispatchedSegments.get(i);
        long remainReadBytes = getRemainReadBytes(segment);
        int i3 = i + 1;
        com.ss.android.socialbase.downloader.segment.Segment segment2 = i3 < i2 ? this.dispatchedSegments.get(i3) : null;
        if (segment2 == null) {
            return remainReadBytes;
        }
        long startOffset = segment2.getStartOffset() - segment.getCurrentOffsetRead();
        return remainReadBytes == -1 ? startOffset : java.lang.Math.min(remainReadBytes, startOffset);
    }

    private int indexOfSegmentLocked(long j) {
        int size = this.dispatchedSegments.size();
        for (int i = 0; i < size; i++) {
            com.ss.android.socialbase.downloader.segment.Segment segment = this.dispatchedSegments.get(i);
            if (segment.getStartOffset() == j) {
                return i;
            }
            if (segment.getStartOffset() > j) {
                return -1;
            }
        }
        return -1;
    }

    private int indexOfUrl(java.lang.String str) {
        int size = this.urlRecords.size();
        for (int i = 0; i < size; i++) {
            if (android.text.TextUtils.equals(this.urlRecords.get(i).url, str)) {
                return i;
            }
        }
        return -1;
    }

    private void initDns() {
        java.util.List<java.lang.String> backUpUrls;
        int ipStrategy = this.strategy.getIpStrategy();
        if (ipStrategy <= 0) {
            this.needWaitDnsResolve = false;
            dispatchReadThread();
            return;
        }
        com.ss.android.socialbase.downloader.network.DownloadDnsManager downloadDnsManager = com.ss.android.socialbase.downloader.network.DownloadDnsManager.getInstance();
        downloadDnsManager.resolveDnsAsync(this.downloadInfo.getUrl(), this, 2000L);
        if (ipStrategy <= 2 || (backUpUrls = this.downloadInfo.getBackUpUrls()) == null) {
            return;
        }
        for (java.lang.String str : backUpUrls) {
            if (!android.text.TextUtils.isEmpty(str)) {
                downloadDnsManager.resolveDnsAsync(str, this, 2000L);
            }
        }
    }

    private void initSegments(java.util.List<com.ss.android.socialbase.downloader.segment.Segment> list) {
        long totalBytes = this.downloadInfo.getTotalBytes();
        this.totalLength = totalBytes;
        if (totalBytes <= 0) {
            this.totalLength = this.downloadInfo.getExpectFileLength();
            com.ss.android.socialbase.downloader.logger.Logger.i(TAG, "initSegments: getExpectFileLength = " + this.totalLength);
        }
        synchronized (this) {
            this.toDispatchSegments.clear();
            if (list != null && !list.isEmpty()) {
                java.util.Iterator<com.ss.android.socialbase.downloader.segment.Segment> it = list.iterator();
                while (it.hasNext()) {
                    arrangeSegmentLocked(this.toDispatchSegments, new com.ss.android.socialbase.downloader.segment.Segment(it.next()), false);
                }
                fixSegmentsLocked(this.toDispatchSegments);
                checkDownloadedBytesLocked(this.toDispatchSegments);
                com.ss.android.socialbase.downloader.logger.Logger.i(TAG, "initSegments: totalLength = " + this.totalLength);
            }
            arrangeSegmentLocked(this.toDispatchSegments, new com.ss.android.socialbase.downloader.segment.Segment(0L, -1L), false);
            com.ss.android.socialbase.downloader.logger.Logger.i(TAG, "initSegments: totalLength = " + this.totalLength);
        }
    }

    private void initUrlRecords() {
        this.urlRecords.add(new com.ss.android.socialbase.downloader.segment.UrlRecord(this.downloadInfo.getUrl(), true));
        java.util.List<java.lang.String> backUpUrls = this.downloadInfo.getBackUpUrls();
        if (backUpUrls != null) {
            for (java.lang.String str : backUpUrls) {
                if (!android.text.TextUtils.isEmpty(str)) {
                    this.urlRecords.add(new com.ss.android.socialbase.downloader.segment.UrlRecord(str, false));
                }
            }
        }
        this.strategy.updateUrlCount(this.urlRecords.size());
    }

    private void initWatchDog() {
        com.ss.android.socialbase.downloader.segment.SegmentStrategy segmentStrategy = this.strategy;
        this.connectTimeout = segmentStrategy.getConnectTimeout();
        this.readTimeout = segmentStrategy.getReadTimeout();
        this.poorSpeedRatio = segmentStrategy.getPoorSpeedRatio();
        int i = this.reconnectCount;
        if (i > 0) {
            this.watchDog.addWatcher(this.connectWatcher, i);
        }
    }

    private void initWatchDog2() {
        if (this.readTimeout > 0) {
            this.lastReconnectTime = java.lang.System.currentTimeMillis();
            this.watchDog.addWatcher(this.readWatcher, 0L);
        }
    }

    private boolean isAllContentDownloaded() {
        long j = this.totalLength;
        if (j <= 0) {
            this.isAllContentDownloaded = false;
            return false;
        }
        synchronized (this) {
            long firstOffset = com.ss.android.socialbase.downloader.segment.SegmentUtils.getFirstOffset(this.dispatchedSegments);
            com.ss.android.socialbase.downloader.logger.Logger.i(TAG, "isAllContentDownloaded: firstOffset = ".concat(java.lang.String.valueOf(firstOffset)));
            if (firstOffset >= j) {
                this.isAllContentDownloaded = true;
                return true;
            }
            this.isAllContentDownloaded = false;
            return false;
        }
    }

    private boolean isAllReaderFailedLocked() {
        java.util.Iterator<com.ss.android.socialbase.downloader.segment.SegmentReader> it = this.readers.iterator();
        while (it.hasNext()) {
            if (!it.next().isFailed()) {
                return false;
            }
        }
        return true;
    }

    private boolean isDownloadSpeedPoor(com.ss.android.socialbase.downloader.segment.SegmentReader segmentReader, long j, long j2, long j3, double d) {
        if (segmentReader.readStartTime <= 0) {
            return false;
        }
        long recentDownloadSpeed = this.stenographer.getRecentDownloadSpeed(j, j2);
        int size = this.readers.size();
        long j4 = size > 0 ? recentDownloadSpeed / size : recentDownloadSpeed;
        long recentDownloadSpeed2 = segmentReader.getRecentDownloadSpeed(j, j2);
        if (recentDownloadSpeed2 >= j3 && recentDownloadSpeed2 >= j4 * d) {
            return false;
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder("isDownloadSpeedPoor: totalSpeed = ");
        sb.append(recentDownloadSpeed);
        sb.append(", threadAvgSpeed = ");
        sb.append(j4);
        sb.append(", poorSpeed = ");
        sb.append(j3);
        sb.append(", speed = ");
        sb.append(recentDownloadSpeed2);
        sb.append(",threadIndex = ");
        sb.append(segmentReader.threadIndex);
        return true;
    }

    private void markProgress(long j) {
        this.stenographer.markProgress(this.downloadInfo.getCurBytes(), j);
        java.util.Iterator<com.ss.android.socialbase.downloader.segment.SegmentReader> it = this.readers.iterator();
        while (it.hasNext()) {
            it.next().markProgress(j);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x00b7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private com.ss.android.socialbase.downloader.segment.Segment obtainChildSegmentFromMaxRemain(com.ss.android.socialbase.downloader.segment.SegmentReader segmentReader, com.ss.android.socialbase.downloader.segment.UrlRecord urlRecord) {
        java.lang.String str;
        float f;
        float f2;
        int size = this.dispatchedSegments.size();
        long j = -1;
        int i = -1;
        for (int i2 = 0; i2 < size; i2++) {
            long unconfirmedRemainBytes = getUnconfirmedRemainBytes(i2, size);
            if (unconfirmedRemainBytes > j) {
                i = i2;
                j = unconfirmedRemainBytes;
            }
        }
        long segmentMinSize = this.strategy.getSegmentMinSize();
        long segmentMaxSize = this.strategy.getSegmentMaxSize();
        if (i < 0 || j <= segmentMinSize) {
            return null;
        }
        com.ss.android.socialbase.downloader.segment.Segment segment = this.dispatchedSegments.get(i);
        int ratioSegmentStrategy = this.dispatchedSegments.size() < this.readers.size() ? 2 : this.strategy.getRatioSegmentStrategy();
        if (ratioSegmentStrategy == 1) {
            com.ss.android.socialbase.downloader.segment.SegmentReader segmentReader2 = segment.owner;
            if (segmentReader2 != null) {
                long currentTimeMillis = java.lang.System.currentTimeMillis();
                long j2 = currentTimeMillis - moji.com.mjweatherservicebase.view.sliderbanner.MJAutoSlideBannerView.DELAYED_TIME;
                long recentDownloadSpeed = segmentReader2.getRecentDownloadSpeed(j2, currentTimeMillis);
                long recentDownloadSpeed2 = segmentReader.getRecentDownloadSpeed(j2, currentTimeMillis);
                float f3 = (recentDownloadSpeed <= 0 || recentDownloadSpeed2 <= 0) ? -1.0f : recentDownloadSpeed2 / (recentDownloadSpeed + recentDownloadSpeed2);
                if (f3 == -1.0f) {
                    long readBytes = segmentReader2.getReadBytes();
                    f = f3;
                    long readBytes2 = segmentReader.getReadBytes();
                    if (readBytes > 0 && readBytes2 > 0) {
                        f2 = readBytes2 / (readBytes + readBytes2);
                        if (f2 > 0.0f) {
                            float f4 = f2 * 0.9f;
                            long j3 = (long) (j * f4);
                            if (j3 < segmentMinSize) {
                                j3 = segmentMinSize;
                            }
                            if (segmentMaxSize <= 0 || j3 <= segmentMaxSize) {
                                segmentMaxSize = j3;
                            }
                            long j4 = segmentMinSize / 2;
                            long j5 = j - j4;
                            if (segmentMaxSize > j5) {
                                segmentMaxSize = j5;
                            } else if (segmentMaxSize < j4) {
                                segmentMaxSize = j4;
                            }
                            com.ss.android.socialbase.downloader.segment.Segment segment2 = new com.ss.android.socialbase.downloader.segment.Segment(segment.getCurrentOffsetRead() + (j - segmentMaxSize), segment.getEndOffset());
                            com.ss.android.socialbase.downloader.logger.Logger.i(TAG, "obtainSegment: parent = " + segment + ", child = " + segment2 + ", maxRemainBytes = " + j + ", childLength = " + segmentMaxSize + ", ratio = " + f4 + ", threadIndex = " + segmentReader.threadIndex);
                            return segment2;
                        }
                    }
                } else {
                    f = f3;
                }
                f2 = f;
                if (f2 > 0.0f) {
                }
            }
            str = TAG;
        } else {
            if (ratioSegmentStrategy == 2) {
                long curBytes = this.totalLength - this.downloadInfo.getCurBytes();
                float downloadRatio = getDownloadRatio(segmentReader, urlRecord);
                long j6 = (long) (curBytes * downloadRatio);
                if (j6 < segmentMinSize) {
                    j6 = segmentMinSize;
                }
                if (segmentMaxSize <= 0 || j6 <= segmentMaxSize) {
                    segmentMaxSize = j6;
                }
                long j7 = segmentMinSize / 2;
                long j8 = j - j7;
                if (segmentMaxSize > j8) {
                    segmentMaxSize = j8;
                } else if (segmentMaxSize < j7) {
                    segmentMaxSize = j7;
                }
                com.ss.android.socialbase.downloader.segment.Segment segment3 = new com.ss.android.socialbase.downloader.segment.Segment(segment.getCurrentOffsetRead() + (j - segmentMaxSize), segment.getEndOffset());
                com.ss.android.socialbase.downloader.logger.Logger.i(TAG, "obtainSegment: parent = " + segment + ", child = " + segment3 + ", maxRemainBytes = " + j + ", childLength = " + segmentMaxSize + ", ratio = " + downloadRatio + ", threadIndex = " + segmentReader.threadIndex);
                return segment3;
            }
            str = TAG;
        }
        com.ss.android.socialbase.downloader.segment.Segment segment4 = new com.ss.android.socialbase.downloader.segment.Segment(segment.getCurrentOffsetRead() + (j / 2), segment.getEndOffset());
        com.ss.android.socialbase.downloader.logger.Logger.i(str, "obtainSegment: parent = " + segment + ",child = " + segment4);
        return segment4;
    }

    private com.ss.android.socialbase.downloader.segment.Segment obtainLeastCompetitorSegment() {
        int competitor;
        com.ss.android.socialbase.downloader.segment.Segment segment = null;
        int i = Integer.MAX_VALUE;
        for (com.ss.android.socialbase.downloader.segment.Segment segment2 : this.dispatchedSegments) {
            if (getRemainReadBytes(segment2) > 0 && (competitor = segment2.getCompetitor()) < i) {
                segment = segment2;
                i = competitor;
            }
        }
        return segment;
    }

    private com.ss.android.socialbase.downloader.segment.Segment obtainSegmentLocked(com.ss.android.socialbase.downloader.segment.SegmentReader segmentReader, com.ss.android.socialbase.downloader.segment.UrlRecord urlRecord) {
        while (!this.toDispatchSegments.isEmpty()) {
            com.ss.android.socialbase.downloader.segment.Segment poll = this.toDispatchSegments.poll();
            if (poll != null) {
                arrangeSegmentLocked(this.dispatchedSegments, poll, true);
                if (getRemainReadBytes(poll) > 0 || this.totalLength <= 0) {
                    return poll;
                }
            }
        }
        clearCoveredSegmentLocked();
        com.ss.android.socialbase.downloader.segment.Segment obtainChildSegmentFromMaxRemain = obtainChildSegmentFromMaxRemain(segmentReader, urlRecord);
        if (obtainChildSegmentFromMaxRemain != null && getRemainReadBytes(obtainChildSegmentFromMaxRemain) > 0) {
            arrangeSegmentLocked(this.dispatchedSegments, obtainChildSegmentFromMaxRemain, true);
            return obtainChildSegmentFromMaxRemain;
        }
        com.ss.android.socialbase.downloader.segment.Segment obtainSegmentWhenNoNewSegment = obtainSegmentWhenNoNewSegment();
        if (obtainSegmentWhenNoNewSegment != null) {
            return obtainSegmentWhenNoNewSegment;
        }
        return null;
    }

    private com.ss.android.socialbase.downloader.segment.Segment obtainSegmentWhenNoNewSegment() {
        int i = 0;
        while (true) {
            com.ss.android.socialbase.downloader.segment.Segment obtainLeastCompetitorSegment = obtainLeastCompetitorSegment();
            if (obtainLeastCompetitorSegment == null) {
                return null;
            }
            com.ss.android.socialbase.downloader.segment.SegmentReader segmentReader = obtainLeastCompetitorSegment.owner;
            if (segmentReader == null) {
                return obtainLeastCompetitorSegment;
            }
            if (obtainLeastCompetitorSegment.getCompetitor() >= 2) {
                return null;
            }
            long currentTimeMillis = java.lang.System.currentTimeMillis();
            markProgress(currentTimeMillis);
            if (currentTimeMillis - segmentReader.readStartTime > 2000 && isDownloadSpeedPoor(segmentReader, currentTimeMillis - 2000, currentTimeMillis, 500L, 1.0d)) {
                if (this.debug) {
                    java.lang.StringBuilder sb = new java.lang.StringBuilder("obtainSegmentWhenNoNewSegment: isDownloadSpeedPoor segment = ");
                    sb.append(obtainLeastCompetitorSegment);
                    sb.append(", owner.threadIndex = ");
                    sb.append(segmentReader.threadIndex);
                }
                return obtainLeastCompetitorSegment;
            }
            int i2 = i + 1;
            if (i > 2) {
                if (this.debug) {
                    "obtainSegmentWhenNoNewSegment: waitCount > 2, return segment = ".concat(java.lang.String.valueOf(obtainLeastCompetitorSegment));
                }
                return obtainLeastCompetitorSegment;
            }
            try {
                synchronized (this) {
                    wait(500L);
                }
                i = i2;
            } catch (java.lang.InterruptedException unused) {
                return null;
            }
        }
    }

    private com.ss.android.socialbase.downloader.segment.UrlRecord obtainUrl() {
        com.ss.android.socialbase.downloader.segment.UrlRecord urlRecord;
        synchronized (this) {
            int size = this.urlIndex % this.urlRecords.size();
            if (this.strategy.urlBalance()) {
                this.urlIndex++;
            }
            urlRecord = this.urlRecords.get(size);
        }
        return urlRecord;
    }

    private void onComplete() {
        com.ss.android.socialbase.downloader.logger.Logger.i(TAG, "onComplete");
        this.bufferQueue.close();
        synchronized (this.firstConnectionLock) {
            this.firstConnectionLock.notify();
        }
    }

    private void onError(com.ss.android.socialbase.downloader.exception.BaseException baseException) {
        com.ss.android.socialbase.downloader.logger.Logger.e(TAG, "onError, e = ".concat(java.lang.String.valueOf(baseException)));
        this.failedException = baseException;
        this.bufferQueue.close();
        synchronized (this) {
            java.util.Iterator<com.ss.android.socialbase.downloader.segment.SegmentReader> it = this.readers.iterator();
            while (it.hasNext()) {
                it.next().close();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long scheduleWatchRead() {
        if (this.canceled || this.paused) {
            return -1L;
        }
        long currentTimeMillis = java.lang.System.currentTimeMillis();
        synchronized (this) {
            markProgress(currentTimeMillis);
            long readTimeout = this.strategy.getReadTimeout();
            if (readTimeout > 0) {
                long j = this.lastReconnectTime;
                if (j > 0 && currentTimeMillis - j > readTimeout && findPoorReadThreadAndReconnect(currentTimeMillis, readTimeout)) {
                    this.lastReconnectTime = currentTimeMillis;
                    this.reconnectCount++;
                }
            }
        }
        return 2000L;
    }

    private void switchToNextUrl() {
        synchronized (this) {
            this.urlIndex++;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean trySwitchNextUrlForReader(com.ss.android.socialbase.downloader.segment.SegmentReader segmentReader) {
        synchronized (this) {
            com.ss.android.socialbase.downloader.segment.UrlRecord findNextUrlLocked = findNextUrlLocked(segmentReader);
            if (findNextUrlLocked == null) {
                return false;
            }
            return segmentReader.switchUrlRecord(findNextUrlLocked);
        }
    }

    private void validateHttpResponse(com.ss.android.socialbase.downloader.model.HttpResponse httpResponse) throws com.ss.android.socialbase.downloader.exception.BaseException {
        com.ss.android.socialbase.downloader.model.HttpResponse httpResponse2 = this.mainUrlHttpResponse;
        if (httpResponse2 == null && (httpResponse2 = this.firstBackupUrlHttpResponse) == null) {
            return;
        }
        long totalLength = httpResponse.getTotalLength();
        long totalLength2 = httpResponse2.getTotalLength();
        if (totalLength != totalLength2) {
            java.lang.String str = "total len not equals,len=" + totalLength + ",sLen=" + totalLength2 + ",code=" + httpResponse.responseCode + ",sCode=" + httpResponse2.responseCode + ",range=" + httpResponse.getContentRange() + ",sRange = " + httpResponse2.getContentRange() + ",url = " + httpResponse.url + ",sUrl=" + httpResponse2.url;
            com.ss.android.socialbase.downloader.logger.Logger.e(TAG, str);
            if (totalLength > 0 && totalLength2 > 0) {
                throw new com.ss.android.socialbase.downloader.exception.BaseException(com.ss.android.socialbase.downloader.constants.DownloadErrorCode.ERROR_BAD_URL, str);
            }
        }
        java.lang.String etag = httpResponse.getEtag();
        java.lang.String etag2 = httpResponse2.getEtag();
        if (android.text.TextUtils.equals(etag, etag2)) {
            return;
        }
        java.lang.String str2 = "etag not equals with main url, etag = " + etag + ", mainEtag = " + etag2;
        com.ss.android.socialbase.downloader.logger.Logger.e(TAG, str2);
        if (!android.text.TextUtils.isEmpty(etag) && !android.text.TextUtils.isEmpty(etag2) && !etag.equalsIgnoreCase(etag2)) {
            throw new com.ss.android.socialbase.downloader.exception.BaseException(com.ss.android.socialbase.downloader.constants.DownloadErrorCode.ERROR_BAD_URL, str2);
        }
    }

    private void waitFirstConnection() throws com.ss.android.socialbase.downloader.exception.BaseException, java.lang.InterruptedException {
        com.ss.android.socialbase.downloader.exception.BaseException baseException;
        synchronized (this.firstConnectionLock) {
            if (this.mainUrlHttpResponse == null && this.firstBackupUrlHttpResponse == null) {
                this.firstConnectionLock.wait();
            }
        }
        if (this.mainUrlHttpResponse == null && this.firstBackupUrlHttpResponse == null && (baseException = this.failedException) != null) {
            throw baseException;
        }
    }

    private void writeSegments() throws com.ss.android.socialbase.downloader.exception.BaseException {
        try {
            this.writer.loopAndWrite(this.bufferQueue);
        } catch (com.ss.android.socialbase.downloader.segment.StreamClosedException unused) {
        } catch (com.ss.android.socialbase.downloader.exception.BaseException e) {
            com.ss.android.socialbase.downloader.logger.Logger.e(TAG, "dispatchSegments: loopAndWrite e = ".concat(java.lang.String.valueOf(e)));
            onError(e);
            throw e;
        }
        if (this.paused || this.canceled) {
            return;
        }
        try {
            synchronized (this) {
                while (!this.toDispatchSegments.isEmpty()) {
                    com.ss.android.socialbase.downloader.segment.Segment poll = this.toDispatchSegments.poll();
                    if (poll != null) {
                        arrangeSegmentLocked(this.dispatchedSegments, poll, true);
                    }
                }
                checkDownloadedBytesLocked(this.dispatchedSegments);
            }
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
        if (!this.allReaderFailed || this.failedException == null) {
            if (this.downloadInfo.getCurBytes() != this.downloadInfo.getTotalBytes()) {
                com.ss.android.socialbase.downloader.monitor.DownloadMonitorHelper.monitorSegmentsError(this.downloadInfo, this.dispatchedSegments);
            }
            com.ss.android.socialbase.downloader.logger.Logger.i(TAG, "dispatchSegments::download finished");
        } else {
            com.ss.android.socialbase.downloader.logger.Logger.e(TAG, "dispatchSegments: loopAndWrite  failedException = " + this.failedException);
            throw this.failedException;
        }
    }

    @Override // com.ss.android.socialbase.downloader.segment.ISegmentCallback
    public void applySegment(com.ss.android.socialbase.downloader.segment.SegmentReader segmentReader, com.ss.android.socialbase.downloader.segment.Segment segment) throws com.ss.android.socialbase.downloader.exception.BaseException {
        synchronized (this) {
            applySegmentLocked(segmentReader, segment);
        }
    }

    public void cancel() {
        com.ss.android.socialbase.downloader.logger.Logger.i(TAG, com.anythink.expressad.d.a.b.dO);
        this.canceled = true;
        synchronized (this) {
            java.util.Iterator<com.ss.android.socialbase.downloader.segment.SegmentReader> it = this.readers.iterator();
            while (it.hasNext()) {
                it.next().close();
            }
        }
        this.writer.cancel();
        this.bufferQueue.close();
    }

    @Override // com.ss.android.socialbase.downloader.segment.ISegmentCallback
    public com.ss.android.socialbase.downloader.segment.IOutput createOutput(com.ss.android.socialbase.downloader.segment.SegmentReader segmentReader, com.ss.android.socialbase.downloader.segment.Segment segment) throws com.ss.android.socialbase.downloader.exception.BaseException {
        com.ss.android.socialbase.downloader.segment.IOutput stub;
        synchronized (this) {
            com.ss.android.socialbase.downloader.segment.SegmentOutput segmentOutput = new com.ss.android.socialbase.downloader.segment.SegmentOutput(this.downloadInfo, this.bufferQueue, segment);
            this.writer.assignOutput(segmentOutput);
            stub = segmentOutput.getStub();
        }
        return stub;
    }

    public boolean downloadSegments(java.util.List<com.ss.android.socialbase.downloader.segment.Segment> list) throws com.ss.android.socialbase.downloader.exception.BaseException, java.lang.InterruptedException {
        try {
            initUrlRecords();
            initSegments(list);
            dispatchReadThread();
            initWatchDog();
            initDns();
            long currentTimeMillis = java.lang.System.currentTimeMillis();
            try {
                waitFirstConnection();
                long currentTimeMillis2 = java.lang.System.currentTimeMillis() - currentTimeMillis;
                this.downloadInfo.increaseAllConnectTime(currentTimeMillis2);
                this.downloadInfo.setFirstSpeedTime(currentTimeMillis2);
                if (!this.paused && !this.canceled) {
                    this.hostCallback.checkSpaceOverflow(this.totalLength);
                    initWatchDog2();
                    writeSegments();
                    return true;
                }
                if (!this.paused && !this.canceled) {
                    com.ss.android.socialbase.downloader.logger.Logger.i(TAG, "finally pause");
                    pause();
                }
                this.watchDog.release();
                return true;
            } catch (java.lang.Throwable th) {
                long currentTimeMillis3 = java.lang.System.currentTimeMillis() - currentTimeMillis;
                this.downloadInfo.increaseAllConnectTime(currentTimeMillis3);
                this.downloadInfo.setFirstSpeedTime(currentTimeMillis3);
                throw th;
            }
        } finally {
            if (!this.paused && !this.canceled) {
                com.ss.android.socialbase.downloader.logger.Logger.i(TAG, "finally pause");
                pause();
            }
            this.watchDog.release();
        }
    }

    @Override // com.ss.android.socialbase.downloader.segment.ISegmentCallback
    public com.ss.android.socialbase.downloader.segment.Segment obtainSegment(com.ss.android.socialbase.downloader.segment.SegmentReader segmentReader, com.ss.android.socialbase.downloader.segment.UrlRecord urlRecord) {
        if (this.canceled || this.paused) {
            return null;
        }
        synchronized (this) {
            com.ss.android.socialbase.downloader.segment.Segment obtainSegmentLocked = obtainSegmentLocked(segmentReader, urlRecord);
            if (obtainSegmentLocked != null) {
                obtainSegmentLocked.increaseCompetitor();
                if (obtainSegmentLocked.getCompetitor() > 1) {
                    return new com.ss.android.socialbase.downloader.segment.Segment(obtainSegmentLocked);
                }
            }
            return obtainSegmentLocked;
        }
    }

    @Override // com.ss.android.socialbase.downloader.network.DownloadDnsManager.Callback
    public void onDnsResolved(java.lang.String str, java.util.List<java.net.InetAddress> list) {
        java.util.List<com.ss.android.socialbase.downloader.segment.UrlRecord> list2;
        if (this.paused || this.canceled) {
            return;
        }
        try {
            list2 = assembleIpAddress(str, list);
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            list2 = null;
        }
        synchronized (this) {
            if (list2 != null) {
                addIpListLocked(str, list2);
            }
            this.needWaitDnsResolve = false;
            this.strategy.updateUrlCount(this.urlRecords.size());
            dispatchReadThread();
        }
    }

    @Override // com.ss.android.socialbase.downloader.segment.ISegmentCallback
    public void onReaderExit(com.ss.android.socialbase.downloader.segment.SegmentReader segmentReader) {
        com.ss.android.socialbase.downloader.logger.Logger.i(TAG, "onReaderExit: threadIndex = " + segmentReader.threadIndex);
        synchronized (this) {
            segmentReader.setExited(true);
            this.readers.remove(segmentReader);
            clearCoveredSegmentLocked();
            if (!this.readers.isEmpty()) {
                if (isAllContentDownloaded()) {
                    java.util.Iterator<com.ss.android.socialbase.downloader.segment.SegmentReader> it = this.readers.iterator();
                    while (it.hasNext()) {
                        it.next().close();
                    }
                }
            }
            onComplete();
        }
    }

    @Override // com.ss.android.socialbase.downloader.segment.ISegmentCallback
    public void onReaderRun(com.ss.android.socialbase.downloader.segment.SegmentReader segmentReader) {
        if (this.debug) {
            com.ss.android.socialbase.downloader.logger.Logger.i(TAG, "onReaderRun, threadIndex = " + segmentReader.threadIndex);
        }
    }

    @Override // com.ss.android.socialbase.downloader.segment.ISegmentCallback
    public void onSegmentConnected(com.ss.android.socialbase.downloader.segment.SegmentReader segmentReader, com.ss.android.socialbase.downloader.segment.Segment segment, com.ss.android.socialbase.downloader.segment.UrlRecord urlRecord, com.ss.android.socialbase.downloader.model.HttpResponse httpResponse) throws com.ss.android.socialbase.downloader.exception.BaseException, com.ss.android.socialbase.downloader.exception.RetryThrowable {
        synchronized (this) {
            if (this.canceled || this.paused) {
                throw new com.ss.android.socialbase.downloader.segment.StreamClosedException("connected");
            }
            checkSegmentHttpResponseLocked(segmentReader, segment, urlRecord, httpResponse);
            segmentReader.setFailed(false);
            if (this.totalLength <= 0) {
                long totalBytes = this.downloadInfo.getTotalBytes();
                this.totalLength = totalBytes;
                if (totalBytes <= 0) {
                    this.totalLength = httpResponse.getTotalLength();
                }
                dispatchReadThread();
            } else if (this.strategy.segmentOneByOne()) {
                dispatchReadThread();
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.segment.ISegmentCallback
    public void onSegmentFailed(com.ss.android.socialbase.downloader.segment.SegmentReader segmentReader, com.ss.android.socialbase.downloader.segment.UrlRecord urlRecord, com.ss.android.socialbase.downloader.segment.Segment segment, com.ss.android.socialbase.downloader.exception.BaseException baseException) {
        synchronized (this) {
            com.ss.android.socialbase.downloader.logger.Logger.e(TAG, "onSegmentFailed: segment = " + segment + ", e = " + baseException);
            segmentReader.setFailed(true);
            if (segmentReader.threadIndex == 0) {
                this.failedException = baseException;
            }
            if (isAllReaderFailedLocked()) {
                if (this.failedException == null) {
                    this.failedException = baseException;
                }
                this.allReaderFailed = true;
                onError(this.failedException);
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.segment.ISegmentCallback
    public void onSegmentRetry(com.ss.android.socialbase.downloader.segment.SegmentReader segmentReader, com.ss.android.socialbase.downloader.segment.UrlRecord urlRecord, com.ss.android.socialbase.downloader.segment.Segment segment, com.ss.android.socialbase.downloader.exception.BaseException baseException, int i, int i2) {
        boolean isResponseCodeError = com.ss.android.socialbase.downloader.utils.DownloadUtils.isResponseCodeError(baseException);
        int errorCode = baseException.getErrorCode();
        if (errorCode == 1047 || errorCode == 1074 || errorCode == 1055) {
            isResponseCodeError = true;
        }
        if (isResponseCodeError || i >= i2) {
            trySwitchNextUrlForReader(segmentReader);
        }
    }

    public void pause() {
        com.ss.android.socialbase.downloader.logger.Logger.i(TAG, "pause1");
        this.paused = true;
        synchronized (this) {
            java.util.Iterator<com.ss.android.socialbase.downloader.segment.SegmentReader> it = this.readers.iterator();
            while (it.hasNext()) {
                it.next().close();
            }
        }
        this.writer.pause();
        this.bufferQueue.close();
    }

    @Override // com.ss.android.socialbase.downloader.segment.ISegmentCallback
    public void unApplySegment(com.ss.android.socialbase.downloader.segment.SegmentReader segmentReader, com.ss.android.socialbase.downloader.segment.Segment segment) {
        synchronized (this) {
            if (segment.owner == segmentReader) {
                com.ss.android.socialbase.downloader.logger.Logger.i(TAG, "unApplySegment ".concat(java.lang.String.valueOf(segment)));
                segment.setCurrentOffsetRead(segmentReader.getCurSegmentReadOffset());
                segment.owner = null;
                segmentReader.updateReadBytes();
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.segment.ISegmentCallback
    public void unObtainSegment(com.ss.android.socialbase.downloader.segment.SegmentReader segmentReader, com.ss.android.socialbase.downloader.segment.Segment segment) {
        synchronized (this) {
            segment.decreaseCompetitor();
        }
    }
}
