package com.ss.android.socialbase.downloader.segment;

/* loaded from: classes19.dex */
class MultiSegmentWriter {
    private static final boolean DEBUG = false;
    private static final int MIN_CACHE_BYTES = 65536;
    private static final int MIN_CACHE_TIME_MS = 100;
    private static final int MIN_SYNC_STEP_BYTE = 65536;
    private static final long MIN_SYNC_TIME_MS = 500;
    private static final java.lang.String TAG = "MultiSegmentWriter";
    private final com.ss.android.socialbase.downloader.thread.IDownloadRunnableCallback callback;
    private final com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo;
    private com.ss.android.socialbase.downloader.exception.BaseException exception;
    private final boolean hasSyncStrategy;
    private final boolean isMonitorRw;
    private final com.ss.android.socialbase.downloader.segment.IBufferPool pool;
    private final com.ss.android.socialbase.downloader.setting.DownloadSetting setting;
    private final long syncIntervalMsBg;
    private final long syncIntervalMsFg;
    private long syncTimeNs;
    private final java.util.List<com.ss.android.socialbase.downloader.segment.SegmentOutput> outputs = new java.util.LinkedList();
    private final java.util.List<com.ss.android.socialbase.downloader.segment.SegmentOutput> doneOutputs = new java.util.ArrayList();
    private volatile boolean threadDirty = false;
    private volatile boolean paused = false;
    private volatile boolean canceled = false;
    private volatile long lastSyncBytes = 0;
    private volatile long lastSyncTimestamp = 0;
    private final com.ss.android.socialbase.downloader.downloader.IDownloadCache downloadCache = com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.getDownloadCache();
    private final com.ss.android.socialbase.downloader.common.AppStatusManager appStatusManager = com.ss.android.socialbase.downloader.common.AppStatusManager.getInstance();

    public MultiSegmentWriter(com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo, com.ss.android.socialbase.downloader.thread.IDownloadRunnableCallback iDownloadRunnableCallback, com.ss.android.socialbase.downloader.segment.IBufferPool iBufferPool) {
        this.downloadInfo = downloadInfo;
        this.callback = iDownloadRunnableCallback;
        this.pool = iBufferPool;
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
    }

    private void checkAndSync(long j, boolean z) throws java.io.IOException {
        long j2 = j - this.lastSyncTimestamp;
        if (this.hasSyncStrategy) {
            if (j2 <= (this.appStatusManager.isAppForeground() ? this.syncIntervalMsFg : this.syncIntervalMsBg)) {
                return;
            }
        } else {
            long curBytes = this.downloadInfo.getCurBytes() - this.lastSyncBytes;
            if (!z && !isNeedSync(curBytes, j2)) {
                return;
            }
        }
        flushAndSync();
        this.lastSyncTimestamp = j;
    }

    private void close(java.util.List<com.ss.android.socialbase.downloader.segment.SegmentOutput> list) {
        java.util.Iterator<com.ss.android.socialbase.downloader.segment.SegmentOutput> it = list.iterator();
        while (it.hasNext()) {
            it.next().close();
        }
    }

    private void flush(java.util.List<com.ss.android.socialbase.downloader.segment.SegmentOutput> list) throws java.io.IOException {
        java.util.Iterator<com.ss.android.socialbase.downloader.segment.SegmentOutput> it = list.iterator();
        while (it.hasNext()) {
            it.next().flush();
        }
    }

    private void flushAndSync() throws java.io.IOException {
        boolean z;
        boolean z2 = this.isMonitorRw;
        long nanoTime = z2 ? java.lang.System.nanoTime() : 0L;
        com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo = this.downloadInfo;
        com.ss.android.socialbase.downloader.downloader.IDownloadCache iDownloadCache = this.downloadCache;
        java.util.List<com.ss.android.socialbase.downloader.segment.SegmentOutput> list = this.outputs;
        java.util.List<com.ss.android.socialbase.downloader.segment.SegmentOutput> list2 = this.doneOutputs;
        java.util.Map<java.lang.Long, com.ss.android.socialbase.downloader.segment.Segment> segmentMap = iDownloadCache.getSegmentMap(downloadInfo.getId());
        if (segmentMap == null) {
            segmentMap = new java.util.HashMap<>(4);
        }
        synchronized (this) {
            flush(list);
            try {
                sync(list);
                z = true;
            } catch (java.lang.Throwable th) {
                th.printStackTrace();
                z = false;
            }
            updateSegmentToMap(list, segmentMap);
            if (list2.size() > 0) {
                close(list2);
                list.removeAll(list2);
                list2.clear();
            }
        }
        if (z) {
            downloadInfo.updateRealDownloadTime(true);
            iDownloadCache.updateSegments(downloadInfo.getId(), segmentMap);
            iDownloadCache.updateDownloadInfo(downloadInfo);
            this.lastSyncBytes = downloadInfo.getCurBytes();
        }
        if (z2) {
            this.syncTimeNs += java.lang.System.nanoTime() - nanoTime;
        }
    }

    private boolean isNeedSync(long j, long j2) {
        return j > 65536 && j2 > 500;
    }

    private void outputDone(com.ss.android.socialbase.downloader.segment.IOutput iOutput) {
        synchronized (this) {
            this.doneOutputs.add((com.ss.android.socialbase.downloader.segment.SegmentOutput) iOutput);
        }
    }

    private void sync(java.util.List<com.ss.android.socialbase.downloader.segment.SegmentOutput> list) throws java.io.IOException {
        java.util.Iterator<com.ss.android.socialbase.downloader.segment.SegmentOutput> it = list.iterator();
        while (it.hasNext()) {
            it.next().sync();
        }
    }

    private void updateSegmentToMap(java.util.List<com.ss.android.socialbase.downloader.segment.SegmentOutput> list, java.util.Map<java.lang.Long, com.ss.android.socialbase.downloader.segment.Segment> map) {
        java.util.Iterator<com.ss.android.socialbase.downloader.segment.SegmentOutput> it = list.iterator();
        while (it.hasNext()) {
            com.ss.android.socialbase.downloader.segment.Segment segment = it.next().getSegment();
            com.ss.android.socialbase.downloader.segment.Segment segment2 = map.get(java.lang.Long.valueOf(segment.getStartOffset()));
            if (segment2 == null) {
                map.put(java.lang.Long.valueOf(segment.getStartOffset()), new com.ss.android.socialbase.downloader.segment.Segment(segment));
            } else {
                segment2.setCurrentOffset(segment.getCurrentOffset());
                segment2.setEndOffset(segment.getEndOffset());
            }
        }
    }

    public void assignOutput(com.ss.android.socialbase.downloader.segment.SegmentOutput segmentOutput) {
        synchronized (this) {
            this.outputs.add(segmentOutput);
        }
    }

    public void cancel() {
        this.canceled = true;
        this.threadDirty = true;
    }

    public long getLastSyncBytes() {
        return this.lastSyncBytes;
    }

    /* JADX WARN: Code restructure failed: missing block: B:183:0x028d, code lost:
    
        r3.onProgress(r15);
     */
    /* JADX WARN: Code restructure failed: missing block: B:263:0x00b8, code lost:
    
        if (r13 <= 0) goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:266:0x00bb, code lost:
    
        r3.onProgress(r13);
     */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0398 A[Catch: all -> 0x03ad, TryCatch #5 {all -> 0x03ad, blocks: (B:124:0x01e8, B:126:0x01ec, B:129:0x01f2, B:131:0x01f8, B:132:0x01fb, B:134:0x020a, B:178:0x0287, B:179:0x0289, B:68:0x0309, B:70:0x0313, B:72:0x0317, B:115:0x0392, B:117:0x0398, B:118:0x039b, B:119:0x03ac), top: B:6:0x0027, inners: #6 }] */
    /* JADX WARN: Removed duplicated region for block: B:126:0x01ec A[Catch: all -> 0x03ad, TryCatch #5 {all -> 0x03ad, blocks: (B:124:0x01e8, B:126:0x01ec, B:129:0x01f2, B:131:0x01f8, B:132:0x01fb, B:134:0x020a, B:178:0x0287, B:179:0x0289, B:68:0x0309, B:70:0x0313, B:72:0x0317, B:115:0x0392, B:117:0x0398, B:118:0x039b, B:119:0x03ac), top: B:6:0x0027, inners: #6 }] */
    /* JADX WARN: Removed duplicated region for block: B:131:0x01f8 A[Catch: all -> 0x03ad, TryCatch #5 {all -> 0x03ad, blocks: (B:124:0x01e8, B:126:0x01ec, B:129:0x01f2, B:131:0x01f8, B:132:0x01fb, B:134:0x020a, B:178:0x0287, B:179:0x0289, B:68:0x0309, B:70:0x0313, B:72:0x0317, B:115:0x0392, B:117:0x0398, B:118:0x039b, B:119:0x03ac), top: B:6:0x0027, inners: #6 }] */
    /* JADX WARN: Removed duplicated region for block: B:136:0x0211  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x0233 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:171:0x021b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:190:0x02ae A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:216:0x0296 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x03c1  */
    /* JADX WARN: Removed duplicated region for block: B:273:0x00dc A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x03e4 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x03cb A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0313 A[Catch: all -> 0x03ad, TryCatch #5 {all -> 0x03ad, blocks: (B:124:0x01e8, B:126:0x01ec, B:129:0x01f2, B:131:0x01f8, B:132:0x01fb, B:134:0x020a, B:178:0x0287, B:179:0x0289, B:68:0x0309, B:70:0x0313, B:72:0x0317, B:115:0x0392, B:117:0x0398, B:118:0x039b, B:119:0x03ac), top: B:6:0x0027, inners: #6 }] */
    /* JADX WARN: Removed duplicated region for block: B:84:0x033f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void loopAndWrite(com.ss.android.socialbase.downloader.segment.IInput iInput) throws com.ss.android.socialbase.downloader.exception.BaseException {
        com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo;
        long curBytes;
        long nanoTime;
        boolean z;
        boolean z2;
        long j;
        long j2;
        long j3;
        long j4;
        java.lang.Throwable th;
        int i;
        java.lang.Throwable th2;
        java.lang.Throwable th3;
        java.lang.Throwable th4;
        java.lang.Throwable th5;
        com.ss.android.socialbase.downloader.segment.Buffer read;
        java.lang.Throwable th6;
        if (this.paused || this.canceled) {
            return;
        }
        com.ss.android.socialbase.downloader.network.DeviceBandwidthSampler.updateWifiStatus();
        this.exception = null;
        downloadInfo = this.downloadInfo;
        com.ss.android.socialbase.downloader.thread.IDownloadRunnableCallback iDownloadRunnableCallback = this.callback;
        com.ss.android.socialbase.downloader.segment.IBufferPool iBufferPool = this.pool;
        curBytes = downloadInfo.getCurBytes();
        nanoTime = java.lang.System.nanoTime();
        z = this.isMonitorRw;
        long j5 = 0;
        z2 = true;
        int i2 = 0;
        boolean z3 = false;
        try {
            try {
                downloadInfo.updateRealStartDownloadTime();
                long j6 = 0;
                long j7 = 0;
                long j8 = 0;
                int i3 = 0;
                while (true) {
                    if (z) {
                        try {
                            j6 = java.lang.System.nanoTime();
                        } catch (com.ss.android.socialbase.downloader.segment.StreamClosedException e) {
                            e = e;
                            i2 = i3;
                            j4 = j7;
                            try {
                                this.exception = e;
                                throw e;
                            } catch (java.lang.Throwable th7) {
                                th = th7;
                                j2 = j5;
                                j = j4;
                                if (i2 > 0) {
                                }
                                if (!this.canceled) {
                                }
                                th5 = null;
                                synchronized (this) {
                                }
                            }
                        } catch (com.ss.android.socialbase.downloader.exception.BaseException e2) {
                            e = e2;
                            j2 = j5;
                            i = i3;
                            j3 = j7;
                            if (this.setting.optBugFix(com.ss.android.socialbase.downloader.setting.DownloadSettingKeys.BugFix.IGNORE_BASE_EX_ON_STOP_STATUS) || !(this.paused || this.canceled)) {
                                if (com.ss.android.socialbase.downloader.logger.Logger.debug()) {
                                    e.printStackTrace();
                                }
                                com.ss.android.socialbase.downloader.logger.Logger.w(TAG, "loopAndWrite:  BaseException e = ".concat(java.lang.String.valueOf(e)));
                                this.exception = e;
                                throw e;
                            }
                            if (i > 0) {
                                try {
                                    iDownloadRunnableCallback.onProgress(i);
                                } catch (java.lang.Throwable unused) {
                                }
                            }
                            if (!this.canceled) {
                                try {
                                    flushAndSync();
                                } catch (java.lang.Throwable th8) {
                                    th4 = th8;
                                    com.ss.android.socialbase.downloader.logger.Logger.w(TAG, "loopAndWrite: finally sync, e = ".concat(java.lang.String.valueOf(th4)));
                                    synchronized (this) {
                                        close(this.outputs);
                                        this.outputs.clear();
                                    }
                                    com.ss.android.socialbase.downloader.monitor.DownloadMonitorHelper.monitorDownloadIO(this.setting, downloadInfo, downloadInfo.getUrl(), null, this.paused, this.canceled, this.exception, downloadInfo.getCurBytes() - curBytes, java.lang.System.nanoTime() - nanoTime, z, j2, j3, this.syncTimeNs, null);
                                    if (th4 != null) {
                                        if (!this.paused && !this.canceled && this.exception == null) {
                                            z2 = false;
                                        }
                                        if (z2) {
                                            return;
                                        }
                                        try {
                                            com.ss.android.socialbase.downloader.utils.DownloadUtils.parseException(th4, "loopAndWrite_finally");
                                            return;
                                        } catch (com.ss.android.socialbase.downloader.exception.BaseException e3) {
                                            this.exception = e3;
                                            throw e3;
                                        }
                                    }
                                    return;
                                }
                            }
                            th4 = null;
                            synchronized (this) {
                            }
                        } catch (java.lang.Throwable th9) {
                            th = th9;
                            j2 = j5;
                            i2 = i3;
                            j = j7;
                            if (!this.paused && !this.canceled) {
                                if (com.ss.android.socialbase.downloader.logger.Logger.debug()) {
                                    th.printStackTrace();
                                }
                                com.ss.android.socialbase.downloader.logger.Logger.w(TAG, "loopAndWrite:  e = ".concat(java.lang.String.valueOf(th)));
                                try {
                                    com.ss.android.socialbase.downloader.utils.DownloadUtils.parseException(th, "loopAndWrite");
                                    if (i2 > 0) {
                                        try {
                                            iDownloadRunnableCallback.onProgress(i2);
                                        } catch (java.lang.Throwable unused2) {
                                        }
                                    }
                                    if (!this.canceled) {
                                        try {
                                            flushAndSync();
                                        } catch (java.lang.Throwable th10) {
                                            th3 = th10;
                                            com.ss.android.socialbase.downloader.logger.Logger.w(TAG, "loopAndWrite: finally sync, e = ".concat(java.lang.String.valueOf(th3)));
                                            synchronized (this) {
                                                close(this.outputs);
                                                this.outputs.clear();
                                            }
                                            com.ss.android.socialbase.downloader.monitor.DownloadMonitorHelper.monitorDownloadIO(this.setting, downloadInfo, downloadInfo.getUrl(), null, this.paused, this.canceled, this.exception, downloadInfo.getCurBytes() - curBytes, java.lang.System.nanoTime() - nanoTime, z, j2, j, this.syncTimeNs, null);
                                            if (th3 != null) {
                                                if (!this.paused && !this.canceled && this.exception == null) {
                                                    z2 = false;
                                                }
                                                if (z2) {
                                                    return;
                                                }
                                                try {
                                                    com.ss.android.socialbase.downloader.utils.DownloadUtils.parseException(th3, "loopAndWrite_finally");
                                                    return;
                                                } catch (com.ss.android.socialbase.downloader.exception.BaseException e4) {
                                                    this.exception = e4;
                                                    throw e4;
                                                }
                                            }
                                            return;
                                        }
                                    }
                                    th3 = null;
                                    synchronized (this) {
                                    }
                                } catch (com.ss.android.socialbase.downloader.exception.BaseException e5) {
                                    this.exception = e5;
                                    throw e5;
                                }
                            }
                            if (!this.canceled) {
                                try {
                                    flushAndSync();
                                } catch (java.lang.Throwable th11) {
                                    th2 = th11;
                                    com.ss.android.socialbase.downloader.logger.Logger.w(TAG, "loopAndWrite: finally sync, e = ".concat(java.lang.String.valueOf(th2)));
                                    synchronized (this) {
                                        close(this.outputs);
                                        this.outputs.clear();
                                    }
                                    com.ss.android.socialbase.downloader.monitor.DownloadMonitorHelper.monitorDownloadIO(this.setting, downloadInfo, downloadInfo.getUrl(), null, this.paused, this.canceled, this.exception, downloadInfo.getCurBytes() - curBytes, java.lang.System.nanoTime() - nanoTime, z, j2, j, this.syncTimeNs, null);
                                    if (th2 != null) {
                                        if (!this.paused && !this.canceled && this.exception == null) {
                                            z2 = false;
                                        }
                                        if (z2) {
                                            return;
                                        }
                                        try {
                                            com.ss.android.socialbase.downloader.utils.DownloadUtils.parseException(th2, "loopAndWrite_finally");
                                            return;
                                        } catch (com.ss.android.socialbase.downloader.exception.BaseException e6) {
                                            this.exception = e6;
                                            throw e6;
                                        }
                                    }
                                    return;
                                }
                            }
                            th2 = null;
                            synchronized (this) {
                            }
                        }
                    }
                    try {
                        read = iInput.read();
                        if (z) {
                            j5 += java.lang.System.nanoTime() - j6;
                        }
                        j2 = j5;
                    } catch (com.ss.android.socialbase.downloader.segment.StreamClosedException e7) {
                        e = e7;
                        i2 = i3;
                        j4 = j7;
                    } catch (com.ss.android.socialbase.downloader.exception.BaseException e8) {
                        e = e8;
                        j2 = j5;
                    } catch (java.lang.Throwable th12) {
                        th = th12;
                        j2 = j5;
                    }
                    try {
                        int i4 = read.size;
                        if (i4 == -1) {
                            try {
                                outputDone(read.output);
                                iBufferPool.recycle(read);
                                j5 = j2;
                            } catch (com.ss.android.socialbase.downloader.segment.StreamClosedException e9) {
                                e = e9;
                                i2 = i3;
                                j4 = j7;
                                j5 = j2;
                                this.exception = e;
                                throw e;
                            } catch (com.ss.android.socialbase.downloader.exception.BaseException e10) {
                                e = e10;
                                i = i3;
                                j3 = j7;
                                if (this.setting.optBugFix(com.ss.android.socialbase.downloader.setting.DownloadSettingKeys.BugFix.IGNORE_BASE_EX_ON_STOP_STATUS)) {
                                }
                                if (com.ss.android.socialbase.downloader.logger.Logger.debug()) {
                                }
                                com.ss.android.socialbase.downloader.logger.Logger.w(TAG, "loopAndWrite:  BaseException e = ".concat(java.lang.String.valueOf(e)));
                                this.exception = e;
                                throw e;
                            } catch (java.lang.Throwable th13) {
                                th = th13;
                                i2 = i3;
                                j = j7;
                                if (!this.paused) {
                                    if (com.ss.android.socialbase.downloader.logger.Logger.debug()) {
                                    }
                                    com.ss.android.socialbase.downloader.logger.Logger.w(TAG, "loopAndWrite:  e = ".concat(java.lang.String.valueOf(th)));
                                    com.ss.android.socialbase.downloader.utils.DownloadUtils.parseException(th, "loopAndWrite");
                                    if (i2 > 0) {
                                    }
                                    if (!this.canceled) {
                                    }
                                    th3 = null;
                                    synchronized (this) {
                                    }
                                }
                                if (!this.canceled) {
                                }
                                th2 = null;
                                synchronized (this) {
                                }
                            }
                        } else {
                            if (z) {
                                j6 = java.lang.System.nanoTime();
                            }
                            read.output.write(read);
                            if (z) {
                                j7 += java.lang.System.nanoTime() - j6;
                            }
                            j4 = j7;
                            try {
                                iBufferPool.recycle(read);
                                if (this.threadDirty) {
                                    if (this.paused) {
                                        break;
                                    }
                                    try {
                                        if (this.canceled) {
                                            break;
                                        } else {
                                            this.threadDirty = z3;
                                        }
                                    } catch (com.ss.android.socialbase.downloader.segment.StreamClosedException e11) {
                                        e = e11;
                                        i2 = i3;
                                        j5 = j2;
                                        this.exception = e;
                                        throw e;
                                    } catch (com.ss.android.socialbase.downloader.exception.BaseException e12) {
                                        e = e12;
                                        i = i3;
                                        j3 = j4;
                                        if (this.setting.optBugFix(com.ss.android.socialbase.downloader.setting.DownloadSettingKeys.BugFix.IGNORE_BASE_EX_ON_STOP_STATUS)) {
                                        }
                                        if (com.ss.android.socialbase.downloader.logger.Logger.debug()) {
                                        }
                                        com.ss.android.socialbase.downloader.logger.Logger.w(TAG, "loopAndWrite:  BaseException e = ".concat(java.lang.String.valueOf(e)));
                                        this.exception = e;
                                        throw e;
                                    } catch (java.lang.Throwable th14) {
                                        th = th14;
                                        i2 = i3;
                                        j = j4;
                                        if (!this.paused) {
                                        }
                                        if (!this.canceled) {
                                        }
                                        th2 = null;
                                        synchronized (this) {
                                        }
                                    }
                                }
                                i3 += i4;
                                if (i3 >= 65536) {
                                    try {
                                        long uptimeMillis = android.os.SystemClock.uptimeMillis();
                                        if (uptimeMillis - j8 > 100) {
                                            long j9 = j6;
                                            try {
                                                checkAndSync(uptimeMillis, iDownloadRunnableCallback.onProgress(i3));
                                                if (!com.ss.android.socialbase.downloader.network.DeviceBandwidthSampler.isWifi) {
                                                    if (downloadInfo.isOnlyWifi()) {
                                                        throw new com.ss.android.socialbase.downloader.exception.DownloadOnlyWifiException();
                                                    }
                                                    if (downloadInfo.isDownloadFromReserveWifi() && downloadInfo.isPauseReserveOnWifi()) {
                                                        throw new com.ss.android.socialbase.downloader.exception.DownloadPauseReserveWifiException();
                                                    }
                                                }
                                                j8 = uptimeMillis;
                                                j5 = j2;
                                                j7 = j4;
                                                j6 = j9;
                                                i3 = 0;
                                                z3 = false;
                                            } catch (com.ss.android.socialbase.downloader.segment.StreamClosedException e13) {
                                                e = e13;
                                                j5 = j2;
                                                i2 = 0;
                                                this.exception = e;
                                                throw e;
                                            } catch (com.ss.android.socialbase.downloader.exception.BaseException e14) {
                                                e = e14;
                                                j3 = j4;
                                                i = 0;
                                                if (this.setting.optBugFix(com.ss.android.socialbase.downloader.setting.DownloadSettingKeys.BugFix.IGNORE_BASE_EX_ON_STOP_STATUS)) {
                                                }
                                                if (com.ss.android.socialbase.downloader.logger.Logger.debug()) {
                                                }
                                                com.ss.android.socialbase.downloader.logger.Logger.w(TAG, "loopAndWrite:  BaseException e = ".concat(java.lang.String.valueOf(e)));
                                                this.exception = e;
                                                throw e;
                                            } catch (java.lang.Throwable th15) {
                                                th = th15;
                                                j = j4;
                                                i2 = 0;
                                                if (!this.paused) {
                                                }
                                                if (!this.canceled) {
                                                }
                                                th2 = null;
                                                synchronized (this) {
                                                }
                                            }
                                        }
                                    } catch (com.ss.android.socialbase.downloader.segment.StreamClosedException e15) {
                                        e = e15;
                                        i2 = i3;
                                        j5 = j2;
                                        this.exception = e;
                                        throw e;
                                    } catch (com.ss.android.socialbase.downloader.exception.BaseException e16) {
                                        e = e16;
                                        i = i3;
                                        j3 = j4;
                                        if (this.setting.optBugFix(com.ss.android.socialbase.downloader.setting.DownloadSettingKeys.BugFix.IGNORE_BASE_EX_ON_STOP_STATUS)) {
                                        }
                                        if (com.ss.android.socialbase.downloader.logger.Logger.debug()) {
                                        }
                                        com.ss.android.socialbase.downloader.logger.Logger.w(TAG, "loopAndWrite:  BaseException e = ".concat(java.lang.String.valueOf(e)));
                                        this.exception = e;
                                        throw e;
                                    } catch (java.lang.Throwable th16) {
                                        th = th16;
                                        i2 = i3;
                                        j = j4;
                                        if (!this.paused) {
                                        }
                                        if (!this.canceled) {
                                        }
                                        th2 = null;
                                        synchronized (this) {
                                        }
                                    }
                                }
                                j5 = j2;
                                j7 = j4;
                                j6 = j6;
                                z3 = false;
                            } catch (com.ss.android.socialbase.downloader.segment.StreamClosedException e17) {
                                e = e17;
                            } catch (com.ss.android.socialbase.downloader.exception.BaseException e18) {
                                e = e18;
                            } catch (java.lang.Throwable th17) {
                                th = th17;
                            }
                        }
                    } catch (com.ss.android.socialbase.downloader.segment.StreamClosedException e19) {
                        e = e19;
                        i2 = i3;
                        j4 = j7;
                    } catch (com.ss.android.socialbase.downloader.exception.BaseException e20) {
                        e = e20;
                        i = i3;
                        j3 = j7;
                        if (this.setting.optBugFix(com.ss.android.socialbase.downloader.setting.DownloadSettingKeys.BugFix.IGNORE_BASE_EX_ON_STOP_STATUS)) {
                        }
                        if (com.ss.android.socialbase.downloader.logger.Logger.debug()) {
                        }
                        com.ss.android.socialbase.downloader.logger.Logger.w(TAG, "loopAndWrite:  BaseException e = ".concat(java.lang.String.valueOf(e)));
                        this.exception = e;
                        throw e;
                    } catch (java.lang.Throwable th18) {
                        th = th18;
                        i2 = i3;
                        j = j7;
                        if (!this.paused) {
                        }
                        if (!this.canceled) {
                        }
                        th2 = null;
                        synchronized (this) {
                        }
                    }
                }
            } catch (java.lang.Throwable th19) {
                th = th19;
                if (i2 > 0) {
                    try {
                        iDownloadRunnableCallback.onProgress(i2);
                    } catch (java.lang.Throwable unused3) {
                    }
                }
                if (!this.canceled) {
                    try {
                        flushAndSync();
                    } catch (java.lang.Throwable th20) {
                        com.ss.android.socialbase.downloader.logger.Logger.w(TAG, "loopAndWrite: finally sync, e = ".concat(java.lang.String.valueOf(th20)));
                        th5 = th20;
                        synchronized (this) {
                        }
                    }
                }
                th5 = null;
                synchronized (this) {
                    close(this.outputs);
                    this.outputs.clear();
                }
                com.ss.android.socialbase.downloader.monitor.DownloadMonitorHelper.monitorDownloadIO(this.setting, downloadInfo, downloadInfo.getUrl(), null, this.paused, this.canceled, this.exception, downloadInfo.getCurBytes() - curBytes, java.lang.System.nanoTime() - nanoTime, z, j2, j, this.syncTimeNs, null);
                if (th5 == null) {
                    throw th;
                }
                if (!this.paused && !this.canceled && this.exception == null) {
                    z2 = false;
                }
                if (z2) {
                    throw th;
                }
                try {
                    com.ss.android.socialbase.downloader.utils.DownloadUtils.parseException(th5, "loopAndWrite_finally");
                    throw th;
                } catch (com.ss.android.socialbase.downloader.exception.BaseException e21) {
                    this.exception = e21;
                    throw e21;
                }
            }
        } catch (com.ss.android.socialbase.downloader.segment.StreamClosedException e22) {
            e = e22;
            j4 = 0;
        } catch (com.ss.android.socialbase.downloader.exception.BaseException e23) {
            e = e23;
            j3 = 0;
            j2 = 0;
        } catch (java.lang.Throwable th21) {
            th = th21;
            j = 0;
            j2 = 0;
        }
        if (!this.canceled) {
            try {
                flushAndSync();
            } catch (java.lang.Throwable th22) {
                th6 = th22;
                com.ss.android.socialbase.downloader.logger.Logger.w(TAG, "loopAndWrite: finally sync, e = ".concat(java.lang.String.valueOf(th6)));
                synchronized (this) {
                    close(this.outputs);
                    this.outputs.clear();
                }
                com.ss.android.socialbase.downloader.monitor.DownloadMonitorHelper.monitorDownloadIO(this.setting, downloadInfo, downloadInfo.getUrl(), null, this.paused, this.canceled, this.exception, downloadInfo.getCurBytes() - curBytes, java.lang.System.nanoTime() - nanoTime, z, j2, j4, this.syncTimeNs, null);
                if (th6 != null) {
                    if (!this.paused && !this.canceled && this.exception == null) {
                        z2 = false;
                    }
                    if (z2) {
                        return;
                    }
                    try {
                        com.ss.android.socialbase.downloader.utils.DownloadUtils.parseException(th6, "loopAndWrite_finally");
                        return;
                    } catch (com.ss.android.socialbase.downloader.exception.BaseException e24) {
                        this.exception = e24;
                        throw e24;
                    }
                }
                return;
            }
        }
        th6 = null;
        synchronized (this) {
        }
    }

    public void pause() {
        this.paused = true;
        this.threadDirty = true;
    }
}
