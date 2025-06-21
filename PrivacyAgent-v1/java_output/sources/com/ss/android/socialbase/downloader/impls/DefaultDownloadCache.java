package com.ss.android.socialbase.downloader.impls;

/* loaded from: classes19.dex */
public class DefaultDownloadCache implements com.ss.android.socialbase.downloader.downloader.IDownloadCache {
    private static final int MSG_RESUME = 1;
    private static final java.lang.String TAG = "DefaultDownloadCache";
    private com.ss.android.socialbase.downloader.thread.WeakDownloadHandler.IHandler IHandler = new com.ss.android.socialbase.downloader.impls.DefaultDownloadCache.AnonymousClass1();
    private final com.ss.android.socialbase.downloader.impls.DownloadCache downloadCache = new com.ss.android.socialbase.downloader.impls.DownloadCache();
    private volatile boolean hasInitSqlDownloadCache;
    private com.ss.android.socialbase.downloader.downloader.ISqlDownloadCache sqlDownloadCache;
    private volatile boolean unCompleteTaskResumed;
    private com.ss.android.socialbase.downloader.thread.WeakDownloadHandler weakHandler;

    /* renamed from: com.ss.android.socialbase.downloader.impls.DefaultDownloadCache$1, reason: invalid class name */
    public class AnonymousClass1 implements com.ss.android.socialbase.downloader.thread.WeakDownloadHandler.IHandler {

        /* renamed from: com.ss.android.socialbase.downloader.impls.DefaultDownloadCache$1$1, reason: invalid class name and collision with other inner class name */
        public class RunnableC04851 implements java.lang.Runnable {
            public RunnableC04851() {
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    com.ss.android.socialbase.downloader.impls.DefaultDownloadCache.this.resumeUnCompleteTask();
                } catch (java.lang.Exception e) {
                    e.printStackTrace();
                }
            }
        }

        public AnonymousClass1() {
        }

        @Override // com.ss.android.socialbase.downloader.thread.WeakDownloadHandler.IHandler
        public void handleMsg(android.os.Message message) {
            if (message.what == 1) {
                com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.getCPUThreadExecutor().execute(new com.ss.android.socialbase.downloader.impls.DefaultDownloadCache.AnonymousClass1.RunnableC04851());
            }
        }
    }

    /* renamed from: com.ss.android.socialbase.downloader.impls.DefaultDownloadCache$2, reason: invalid class name */
    public class AnonymousClass2 implements com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.IndependentHolderCreator.OnMainProcessRebindErrorListener {
        public AnonymousClass2() {
        }

        @Override // com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.IndependentHolderCreator.OnMainProcessRebindErrorListener
        public void onRebindError() {
            com.ss.android.socialbase.downloader.impls.DefaultDownloadCache.this.sqlDownloadCache = new com.ss.android.socialbase.downloader.db.SqlDownloadCache();
        }
    }

    /* renamed from: com.ss.android.socialbase.downloader.impls.DefaultDownloadCache$3, reason: invalid class name */
    public class AnonymousClass3 implements com.ss.android.socialbase.downloader.db.SqlCacheLoadCompleteCallback {
        final /* synthetic */ android.util.SparseArray val$copyDownloadChunkMap;
        final /* synthetic */ android.util.SparseArray val$copyDownloadInfoMap;

        public AnonymousClass3(android.util.SparseArray sparseArray, android.util.SparseArray sparseArray2) {
            this.val$copyDownloadInfoMap = sparseArray;
            this.val$copyDownloadChunkMap = sparseArray2;
        }

        @Override // com.ss.android.socialbase.downloader.db.SqlCacheLoadCompleteCallback
        public void callback() {
            synchronized (com.ss.android.socialbase.downloader.impls.DefaultDownloadCache.this.downloadCache) {
                android.util.SparseArray<com.ss.android.socialbase.downloader.model.DownloadInfo> downloadInfoMap = com.ss.android.socialbase.downloader.impls.DefaultDownloadCache.this.downloadCache.getDownloadInfoMap();
                if (this.val$copyDownloadInfoMap != null) {
                    for (int i = 0; i < this.val$copyDownloadInfoMap.size(); i++) {
                        int keyAt = this.val$copyDownloadInfoMap.keyAt(i);
                        if (keyAt != 0) {
                            downloadInfoMap.put(keyAt, (com.ss.android.socialbase.downloader.model.DownloadInfo) this.val$copyDownloadInfoMap.get(keyAt));
                        }
                    }
                }
                android.util.SparseArray<java.util.List<com.ss.android.socialbase.downloader.model.DownloadChunk>> chunkListMap = com.ss.android.socialbase.downloader.impls.DefaultDownloadCache.this.downloadCache.getChunkListMap();
                if (this.val$copyDownloadChunkMap != null) {
                    for (int i2 = 0; i2 < this.val$copyDownloadChunkMap.size(); i2++) {
                        int keyAt2 = this.val$copyDownloadChunkMap.keyAt(i2);
                        if (keyAt2 != 0) {
                            chunkListMap.put(keyAt2, (java.util.List) this.val$copyDownloadChunkMap.get(keyAt2));
                        }
                    }
                }
            }
            com.ss.android.socialbase.downloader.impls.DefaultDownloadCache.this.onDownloadCacheSyncSuccess();
            com.ss.android.socialbase.downloader.impls.DefaultDownloadCache.this.resumeUnCompleteTaskMayDelayed();
            com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.onDownloadCacheSyncCallback(com.ss.android.socialbase.downloader.constants.DownloadCacheSyncStatus.SYNC_SUCCESS);
        }
    }

    public DefaultDownloadCache() {
        this.weakHandler = null;
        if (!com.ss.android.socialbase.downloader.setting.DownloadSetting.obtainGlobal().optBugFix(com.ss.android.socialbase.downloader.setting.DownloadSettingKeys.BugFix.BUGFIX_SIGBUS_DOWNLOADER_DB)) {
            this.sqlDownloadCache = new com.ss.android.socialbase.downloader.db.SqlDownloadCache();
        } else if (com.ss.android.socialbase.downloader.utils.DownloadUtils.isMainProcess() || !com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.supportMultiProc()) {
            this.sqlDownloadCache = new com.ss.android.socialbase.downloader.db.SqlDownloadCache();
        } else {
            this.sqlDownloadCache = com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.getIndependentHolderCreator().createCache(new com.ss.android.socialbase.downloader.impls.DefaultDownloadCache.AnonymousClass2());
        }
        this.hasInitSqlDownloadCache = false;
        this.weakHandler = new com.ss.android.socialbase.downloader.thread.WeakDownloadHandler(android.os.Looper.getMainLooper(), this.IHandler);
        init();
    }

    private boolean isPauseReserveOnWifi(com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo) {
        if (downloadInfo != null && downloadInfo.statusInPause()) {
            return downloadInfo.isPauseReserveOnWifi();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onDownloadCacheSyncSuccess() {
        synchronized (this) {
            this.hasInitSqlDownloadCache = true;
            notifyAll();
        }
    }

    private void updateDownloadInfoInDB(com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo) {
        updateDownloadInfoInDB(downloadInfo, true);
    }

    private void updateDownloadInfoInDB(com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo, boolean z) {
        if (downloadInfo == null) {
            return;
        }
        if (!com.ss.android.socialbase.downloader.utils.DownloadUtils.needNotifyDownloaderProcess()) {
            this.sqlDownloadCache.updateDownloadInfo(downloadInfo);
            return;
        }
        if (z) {
            com.ss.android.socialbase.downloader.downloader.IDownloadProxy iDownloadProxy = com.ss.android.socialbase.downloader.impls.DownloadProxy.get(true);
            if (iDownloadProxy != null) {
                iDownloadProxy.updateDownloadInfo(downloadInfo);
            } else {
                this.sqlDownloadCache.updateDownloadInfo(downloadInfo);
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public com.ss.android.socialbase.downloader.model.DownloadInfo OnDownloadTaskCancel(int i, long j) {
        com.ss.android.socialbase.downloader.model.DownloadInfo OnDownloadTaskCancel = this.downloadCache.OnDownloadTaskCancel(i, j);
        syncDownloadInfoFromOtherCache(i, null);
        return OnDownloadTaskCancel;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public com.ss.android.socialbase.downloader.model.DownloadInfo OnDownloadTaskCompleted(int i, long j) {
        com.ss.android.socialbase.downloader.model.DownloadInfo OnDownloadTaskCompleted = this.downloadCache.OnDownloadTaskCompleted(i, j);
        syncDownloadInfoFromOtherCache(i, null);
        return OnDownloadTaskCompleted;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public com.ss.android.socialbase.downloader.model.DownloadInfo OnDownloadTaskConnected(int i, long j, java.lang.String str, java.lang.String str2) {
        com.ss.android.socialbase.downloader.model.DownloadInfo OnDownloadTaskConnected = this.downloadCache.OnDownloadTaskConnected(i, j, str, str2);
        updateDownloadInfoInDB(OnDownloadTaskConnected);
        return OnDownloadTaskConnected;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public com.ss.android.socialbase.downloader.model.DownloadInfo OnDownloadTaskError(int i, long j) {
        com.ss.android.socialbase.downloader.model.DownloadInfo OnDownloadTaskError = this.downloadCache.OnDownloadTaskError(i, j);
        syncDownloadInfoFromOtherCache(i, null);
        return OnDownloadTaskError;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public com.ss.android.socialbase.downloader.model.DownloadInfo OnDownloadTaskIntercept(int i) {
        com.ss.android.socialbase.downloader.model.DownloadInfo OnDownloadTaskIntercept = this.downloadCache.OnDownloadTaskIntercept(i);
        updateDownloadInfoInDB(OnDownloadTaskIntercept);
        return OnDownloadTaskIntercept;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public com.ss.android.socialbase.downloader.model.DownloadInfo OnDownloadTaskPause(int i, long j) {
        com.ss.android.socialbase.downloader.model.DownloadInfo OnDownloadTaskPause = this.downloadCache.OnDownloadTaskPause(i, j);
        syncDownloadInfoFromOtherCache(i, null);
        return OnDownloadTaskPause;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public com.ss.android.socialbase.downloader.model.DownloadInfo OnDownloadTaskPrepare(int i) {
        com.ss.android.socialbase.downloader.model.DownloadInfo OnDownloadTaskPrepare = this.downloadCache.OnDownloadTaskPrepare(i);
        updateDownloadInfoInDB(OnDownloadTaskPrepare);
        return OnDownloadTaskPrepare;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public com.ss.android.socialbase.downloader.model.DownloadInfo OnDownloadTaskProgress(int i, long j) {
        com.ss.android.socialbase.downloader.model.DownloadInfo OnDownloadTaskProgress = this.downloadCache.OnDownloadTaskProgress(i, j);
        updateDownloadInfoInDB(OnDownloadTaskProgress, false);
        return OnDownloadTaskProgress;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public com.ss.android.socialbase.downloader.model.DownloadInfo OnDownloadTaskRetry(int i) {
        com.ss.android.socialbase.downloader.model.DownloadInfo OnDownloadTaskRetry = this.downloadCache.OnDownloadTaskRetry(i);
        updateDownloadInfoInDB(OnDownloadTaskRetry);
        return OnDownloadTaskRetry;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public void addDownloadChunk(com.ss.android.socialbase.downloader.model.DownloadChunk downloadChunk) {
        synchronized (this.downloadCache) {
            this.downloadCache.addDownloadChunk(downloadChunk);
        }
        if (!com.ss.android.socialbase.downloader.utils.DownloadUtils.needNotifyDownloaderProcess()) {
            this.sqlDownloadCache.addDownloadChunk(downloadChunk);
            return;
        }
        com.ss.android.socialbase.downloader.downloader.IDownloadProxy iDownloadProxy = com.ss.android.socialbase.downloader.impls.DownloadProxy.get(true);
        if (iDownloadProxy != null) {
            iDownloadProxy.addDownloadChunk(downloadChunk);
        } else {
            this.sqlDownloadCache.addDownloadChunk(downloadChunk);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public void addSubDownloadChunk(com.ss.android.socialbase.downloader.model.DownloadChunk downloadChunk) {
        if (!com.ss.android.socialbase.downloader.utils.DownloadUtils.needNotifyDownloaderProcess()) {
            this.sqlDownloadCache.addDownloadChunk(downloadChunk);
            return;
        }
        com.ss.android.socialbase.downloader.downloader.IDownloadProxy iDownloadProxy = com.ss.android.socialbase.downloader.impls.DownloadProxy.get(true);
        if (iDownloadProxy != null) {
            iDownloadProxy.addDownloadChunk(downloadChunk);
        } else {
            this.sqlDownloadCache.addDownloadChunk(downloadChunk);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public boolean cacheExist(int i) {
        return getDownloadInfo(i) != null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public void clearData() {
        try {
            this.downloadCache.clearData();
        } catch (android.database.sqlite.SQLiteException e) {
            e.printStackTrace();
        }
        if (!com.ss.android.socialbase.downloader.utils.DownloadUtils.needNotifyDownloaderProcess()) {
            this.sqlDownloadCache.clearData();
            return;
        }
        com.ss.android.socialbase.downloader.downloader.IDownloadProxy iDownloadProxy = com.ss.android.socialbase.downloader.impls.DownloadProxy.get(true);
        if (iDownloadProxy != null) {
            iDownloadProxy.clearData();
        } else {
            this.sqlDownloadCache.clearData();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public boolean ensureDownloadCacheSyncSuccess() {
        if (this.hasInitSqlDownloadCache) {
            return true;
        }
        synchronized (this) {
            if (!this.hasInitSqlDownloadCache) {
                com.ss.android.socialbase.downloader.logger.Logger.w(TAG, "ensureDownloadCacheSyncSuccess: waiting start!!!!");
                try {
                    wait(5000L);
                } catch (java.lang.InterruptedException e) {
                    e.printStackTrace();
                }
                com.ss.android.socialbase.downloader.logger.Logger.w(TAG, "ensureDownloadCacheSyncSuccess: waiting end!!!!");
            }
        }
        return this.hasInitSqlDownloadCache;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public java.util.List<com.ss.android.socialbase.downloader.model.DownloadInfo> getAllDownloadInfo() {
        return this.downloadCache.getAllDownloadInfo();
    }

    public com.ss.android.socialbase.downloader.impls.DownloadCache getDownloadCache() {
        return this.downloadCache;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public java.util.List<com.ss.android.socialbase.downloader.model.DownloadChunk> getDownloadChunk(int i) {
        return this.downloadCache.getDownloadChunk(i);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public com.ss.android.socialbase.downloader.model.DownloadInfo getDownloadInfo(int i) {
        return this.downloadCache.getDownloadInfo(i);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public java.util.List<com.ss.android.socialbase.downloader.model.DownloadInfo> getDownloadInfoList(java.lang.String str) {
        return this.downloadCache.getDownloadInfoList(str);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public java.util.List<com.ss.android.socialbase.downloader.model.DownloadInfo> getFailedDownloadInfosWithMimeType(java.lang.String str) {
        return this.downloadCache.getFailedDownloadInfosWithMimeType(str);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public java.util.Map<java.lang.Long, com.ss.android.socialbase.downloader.segment.Segment> getSegmentMap(int i) {
        java.util.Map<java.lang.Long, com.ss.android.socialbase.downloader.segment.Segment> segmentMap = this.downloadCache.getSegmentMap(i);
        if (segmentMap != null && !segmentMap.isEmpty()) {
            return segmentMap;
        }
        java.util.Map<java.lang.Long, com.ss.android.socialbase.downloader.segment.Segment> segmentMap2 = this.sqlDownloadCache.getSegmentMap(i);
        this.downloadCache.updateSegments(i, segmentMap2);
        return segmentMap2;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public java.util.List<com.ss.android.socialbase.downloader.segment.Segment> getSegments(int i) {
        java.util.List<com.ss.android.socialbase.downloader.segment.Segment> segments = this.downloadCache.getSegments(i);
        return (segments == null || segments.size() == 0) ? this.sqlDownloadCache.getSegments(i) : segments;
    }

    public com.ss.android.socialbase.downloader.downloader.ISqlDownloadCache getSqlDownloadCache() {
        return this.sqlDownloadCache;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public java.util.List<com.ss.android.socialbase.downloader.model.DownloadInfo> getSuccessedDownloadInfosWithMimeType(java.lang.String str) {
        return this.downloadCache.getSuccessedDownloadInfosWithMimeType(str);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public java.util.List<com.ss.android.socialbase.downloader.model.DownloadInfo> getUnCompletedDownloadInfosWithMimeType(java.lang.String str) {
        return this.downloadCache.getUnCompletedDownloadInfosWithMimeType(str);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public void init() {
        java.util.List<com.ss.android.socialbase.downloader.model.DownloadChunk> list;
        com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo;
        com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.onDownloadCacheSyncCallback(com.ss.android.socialbase.downloader.constants.DownloadCacheSyncStatus.SYNC_START);
        android.util.SparseArray<com.ss.android.socialbase.downloader.model.DownloadInfo> sparseArray = new android.util.SparseArray<>();
        android.util.SparseArray<java.util.List<com.ss.android.socialbase.downloader.model.DownloadChunk>> sparseArray2 = new android.util.SparseArray<>();
        synchronized (this.downloadCache) {
            android.util.SparseArray<com.ss.android.socialbase.downloader.model.DownloadInfo> downloadInfoMap = this.downloadCache.getDownloadInfoMap();
            for (int i = 0; i < downloadInfoMap.size(); i++) {
                int keyAt = downloadInfoMap.keyAt(i);
                if (keyAt != 0 && (downloadInfo = downloadInfoMap.get(keyAt)) != null) {
                    sparseArray.put(keyAt, downloadInfo);
                }
            }
            android.util.SparseArray<java.util.List<com.ss.android.socialbase.downloader.model.DownloadChunk>> chunkListMap = this.downloadCache.getChunkListMap();
            for (int i2 = 0; i2 < chunkListMap.size(); i2++) {
                int keyAt2 = chunkListMap.keyAt(i2);
                if (keyAt2 != 0 && (list = chunkListMap.get(keyAt2)) != null) {
                    sparseArray2.put(keyAt2, new java.util.concurrent.CopyOnWriteArrayList(list));
                }
            }
        }
        this.sqlDownloadCache.init(sparseArray, sparseArray2, new com.ss.android.socialbase.downloader.impls.DefaultDownloadCache.AnonymousClass3(sparseArray, sparseArray2));
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public boolean isDownloadCacheSyncSuccess() {
        return this.hasInitSqlDownloadCache;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public com.ss.android.socialbase.downloader.model.DownloadInfo onDownloadTaskStart(int i) {
        com.ss.android.socialbase.downloader.model.DownloadInfo onDownloadTaskStart = this.downloadCache.onDownloadTaskStart(i);
        updateDownloadInfoInDB(onDownloadTaskStart);
        return onDownloadTaskStart;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public void removeAllDownloadChunk(int i) {
        this.downloadCache.removeAllDownloadChunk(i);
        if (!com.ss.android.socialbase.downloader.utils.DownloadUtils.needNotifyDownloaderProcess()) {
            this.sqlDownloadCache.removeAllDownloadChunk(i);
            return;
        }
        com.ss.android.socialbase.downloader.downloader.IDownloadProxy iDownloadProxy = com.ss.android.socialbase.downloader.impls.DownloadProxy.get(true);
        if (iDownloadProxy != null) {
            iDownloadProxy.removeAllDownloadChunk(i);
        } else {
            this.sqlDownloadCache.removeAllDownloadChunk(i);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public boolean removeDownloadInfo(int i) {
        try {
            if (com.ss.android.socialbase.downloader.utils.DownloadUtils.needNotifyDownloaderProcess()) {
                com.ss.android.socialbase.downloader.downloader.IDownloadProxy iDownloadProxy = com.ss.android.socialbase.downloader.impls.DownloadProxy.get(true);
                if (iDownloadProxy != null) {
                    iDownloadProxy.removeDownloadInfo(i);
                } else {
                    this.sqlDownloadCache.removeDownloadInfo(i);
                }
            } else {
                this.sqlDownloadCache.removeDownloadInfo(i);
            }
        } catch (android.database.sqlite.SQLiteException e) {
            e.printStackTrace();
        }
        return this.downloadCache.removeDownloadInfo(i);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public boolean removeDownloadTaskData(int i) {
        if (com.ss.android.socialbase.downloader.utils.DownloadUtils.needNotifyDownloaderProcess()) {
            com.ss.android.socialbase.downloader.downloader.IDownloadProxy iDownloadProxy = com.ss.android.socialbase.downloader.impls.DownloadProxy.get(true);
            if (iDownloadProxy != null) {
                iDownloadProxy.removeDownloadTaskData(i);
            } else {
                this.sqlDownloadCache.removeDownloadTaskData(i);
            }
        } else {
            this.sqlDownloadCache.removeDownloadTaskData(i);
        }
        return this.downloadCache.removeDownloadTaskData(i);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public void removeSegments(int i) {
        this.downloadCache.removeSegments(i);
        this.sqlDownloadCache.removeSegments(i);
    }

    public void resumeUnCompleteTask() {
        java.util.List<java.lang.String> list;
        java.util.ArrayList arrayList;
        com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo;
        com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo2;
        if (this.hasInitSqlDownloadCache) {
            if (this.unCompleteTaskResumed) {
                com.ss.android.socialbase.downloader.logger.Logger.d(TAG, "resumeUnCompleteTask: has resumed, return!!!");
                return;
            }
            this.unCompleteTaskResumed = true;
            if (com.ss.android.socialbase.downloader.utils.DownloadUtils.isMainProcess()) {
                com.ss.android.socialbase.downloader.downloader.IDownloadLaunchHandler downloadLaunchHandler = com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.getDownloadLaunchHandler();
                if (downloadLaunchHandler != null) {
                    list = downloadLaunchHandler.getResumeMimeTypes();
                    arrayList = (list == null || list.isEmpty()) ? null : new java.util.ArrayList();
                } else {
                    list = null;
                    arrayList = null;
                }
                android.util.SparseArray sparseArray = new android.util.SparseArray();
                synchronized (this) {
                    android.util.SparseArray<com.ss.android.socialbase.downloader.model.DownloadInfo> downloadInfoMap = this.downloadCache.getDownloadInfoMap();
                    for (int i = 0; i < downloadInfoMap.size(); i++) {
                        int keyAt = downloadInfoMap.keyAt(i);
                        if (keyAt != 0 && (downloadInfo2 = downloadInfoMap.get(keyAt)) != null) {
                            sparseArray.put(keyAt, downloadInfo2);
                        }
                    }
                }
                if (sparseArray.size() == 0) {
                    return;
                }
                for (int i2 = 0; i2 < sparseArray.size(); i2++) {
                    int keyAt2 = sparseArray.keyAt(i2);
                    if (keyAt2 != 0 && (downloadInfo = (com.ss.android.socialbase.downloader.model.DownloadInfo) sparseArray.get(keyAt2)) != null) {
                        int realStatus = downloadInfo.getRealStatus();
                        int statusAtDbInit = downloadInfo.getStatusAtDbInit();
                        if (statusAtDbInit > 0 && statusAtDbInit <= 11) {
                            com.ss.android.socialbase.downloader.monitor.DownloadMonitorHelper.monitorSendWithGlobalSdkMonitor(com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.getDownloadMonitorListener(), downloadInfo, null, -5);
                        }
                        if (list != null && arrayList != null && downloadInfo.getMimeType() != null && list.contains(downloadInfo.getMimeType()) && (com.ss.android.socialbase.downloader.setting.DownloadSetting.obtain(downloadInfo.getId()).optInt(com.ss.android.socialbase.downloader.setting.DownloadSettingKeys.OPT_NOTIFICATION_UI) >= 2 || realStatus != -2 || downloadInfo.isPauseReserveOnWifi())) {
                            downloadInfo.setDownloadFromReserveWifi(false);
                            arrayList.add(downloadInfo);
                        }
                    }
                }
                if (downloadLaunchHandler == null || arrayList == null || arrayList.isEmpty()) {
                    return;
                }
                downloadLaunchHandler.onLaunchResume(arrayList, 1);
            }
        }
    }

    public void resumeUnCompleteTaskMayDelayed() {
        this.weakHandler.sendMessageDelayed(this.weakHandler.obtainMessage(1), com.ss.android.socialbase.downloader.setting.DownloadSetting.obtainGlobal().optBugFix(com.ss.android.socialbase.downloader.setting.DownloadSettingKeys.BugFix.FIX_TASK_RESUME_DELAY) ? moji.com.mjweatherservicebase.view.sliderbanner.MJAutoSlideBannerView.DELAYED_TIME : android.os.Build.VERSION.SDK_INT >= 23 ? 1000L : 5000L);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public void syncDownloadChunks(int i, java.util.List<com.ss.android.socialbase.downloader.model.DownloadChunk> list) {
        if (list == null || list.size() == 0) {
            return;
        }
        this.downloadCache.syncDownloadChunks(i, list);
        if (com.ss.android.socialbase.downloader.utils.DownloadUtils.isDownloaderProcess()) {
            this.sqlDownloadCache.syncDownloadInfoFromOtherCache(i, list);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public void syncDownloadInfo(com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo) {
        if (downloadInfo == null) {
            return;
        }
        this.downloadCache.updateDownloadInfo(downloadInfo);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public void syncDownloadInfoFromOtherCache(int i, java.util.List<com.ss.android.socialbase.downloader.model.DownloadChunk> list) {
        try {
            updateDownloadInfo(this.downloadCache.getDownloadInfo(i));
            if (list == null) {
                list = this.downloadCache.getDownloadChunk(i);
            }
            if (!com.ss.android.socialbase.downloader.utils.DownloadUtils.needNotifyDownloaderProcess()) {
                this.sqlDownloadCache.syncDownloadInfoFromOtherCache(i, list);
                return;
            }
            com.ss.android.socialbase.downloader.downloader.IDownloadProxy iDownloadProxy = com.ss.android.socialbase.downloader.impls.DownloadProxy.get(true);
            if (iDownloadProxy != null) {
                iDownloadProxy.syncDownloadInfoFromOtherCache(i, list);
            } else {
                this.sqlDownloadCache.syncDownloadInfoFromOtherCache(i, list);
            }
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public com.ss.android.socialbase.downloader.model.DownloadInfo updateChunkCount(int i, int i2) {
        com.ss.android.socialbase.downloader.model.DownloadInfo updateChunkCount = this.downloadCache.updateChunkCount(i, i2);
        updateDownloadInfoInDB(updateChunkCount);
        return updateChunkCount;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public void updateDownloadChunk(int i, int i2, long j) {
        this.downloadCache.updateDownloadChunk(i, i2, j);
        if (!com.ss.android.socialbase.downloader.utils.DownloadUtils.needNotifyDownloaderProcess()) {
            this.sqlDownloadCache.updateDownloadChunk(i, i2, j);
            return;
        }
        com.ss.android.socialbase.downloader.downloader.IDownloadProxy iDownloadProxy = com.ss.android.socialbase.downloader.impls.DownloadProxy.get(true);
        if (iDownloadProxy != null) {
            iDownloadProxy.updateDownloadChunk(i, i2, j);
        } else {
            this.sqlDownloadCache.updateDownloadChunk(i, i2, j);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public boolean updateDownloadInfo(com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo) {
        if (downloadInfo == null) {
            return false;
        }
        boolean updateDownloadInfo = this.downloadCache.updateDownloadInfo(downloadInfo);
        updateDownloadInfoInDB(downloadInfo);
        return updateDownloadInfo;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public boolean updateSegments(int i, java.util.Map<java.lang.Long, com.ss.android.socialbase.downloader.segment.Segment> map) {
        this.downloadCache.updateSegments(i, map);
        this.sqlDownloadCache.updateSegments(i, map);
        return false;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public void updateSubDownloadChunk(int i, int i2, int i3, long j) {
        if (!com.ss.android.socialbase.downloader.utils.DownloadUtils.needNotifyDownloaderProcess()) {
            this.sqlDownloadCache.updateSubDownloadChunk(i, i2, i3, j);
            return;
        }
        com.ss.android.socialbase.downloader.downloader.IDownloadProxy iDownloadProxy = com.ss.android.socialbase.downloader.impls.DownloadProxy.get(true);
        if (iDownloadProxy != null) {
            iDownloadProxy.updateSubDownloadChunk(i, i2, i3, j);
        } else {
            this.sqlDownloadCache.updateSubDownloadChunk(i, i2, i3, j);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public void updateSubDownloadChunkIndex(int i, int i2, int i3, int i4) {
        if (!com.ss.android.socialbase.downloader.utils.DownloadUtils.needNotifyDownloaderProcess()) {
            this.sqlDownloadCache.updateSubDownloadChunkIndex(i, i2, i3, i4);
            return;
        }
        com.ss.android.socialbase.downloader.downloader.IDownloadProxy iDownloadProxy = com.ss.android.socialbase.downloader.impls.DownloadProxy.get(true);
        if (iDownloadProxy != null) {
            iDownloadProxy.updateSubDownloadChunkIndex(i, i2, i3, i4);
        } else {
            this.sqlDownloadCache.updateSubDownloadChunkIndex(i, i2, i3, i4);
        }
    }
}
