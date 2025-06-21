package com.ss.android.socialbase.downloader.model;

/* loaded from: classes19.dex */
public class DownloadTask {
    private boolean autoSetHashCodeForSameTask;
    private com.ss.android.socialbase.downloader.downloader.IChunkAdjustCalculator chunkAdjustCalculator;
    private com.ss.android.socialbase.downloader.downloader.IChunkCntCalculator chunkStrategy;
    private com.ss.android.socialbase.downloader.depend.IDownloadDepend depend;
    private com.ss.android.socialbase.downloader.depend.IDownloadDiskSpaceHandler diskSpaceHandler;
    private final java.util.List<com.ss.android.socialbase.downloader.depend.IDownloadCompleteHandler> downloadCompleteHandlers;
    private com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo;
    private com.ss.android.socialbase.downloader.model.DownloadInfo.Builder downloadInfoBuilder;
    private com.ss.android.socialbase.downloader.depend.IDownloadFileUriProvider fileUriProvider;
    private com.ss.android.socialbase.downloader.depend.IDownloadForbiddenHandler forbiddenHandler;
    private int hashCodeForSameTask;
    private com.ss.android.socialbase.downloader.depend.IDownloadInterceptor interceptor;
    private final android.util.SparseArray<com.ss.android.socialbase.downloader.depend.IDownloadListener> mainThreadListeners;
    private com.ss.android.socialbase.downloader.depend.IDownloadMonitorDepend monitorDepend;
    private boolean needDelayForCacheSync;
    private com.ss.android.socialbase.downloader.depend.INotificationClickCallback notificationClickCallback;
    private com.ss.android.socialbase.downloader.depend.IDownloadNotificationEventListener notificationEventListener;
    private final android.util.SparseArray<com.ss.android.socialbase.downloader.depend.IDownloadListener> notificationListeners;
    private com.ss.android.socialbase.downloader.downloader.IRetryDelayTimeCalculator retryDelayTimeCalculator;
    private final android.util.SparseArray<com.ss.android.socialbase.downloader.constants.ListenerType> singleListenerHashCodeMap;
    private final java.util.Map<com.ss.android.socialbase.downloader.constants.ListenerType, com.ss.android.socialbase.downloader.depend.IDownloadListener> singleListenerMap;
    private final android.util.SparseArray<com.ss.android.socialbase.downloader.depend.IDownloadListener> subThreadListeners;

    /* renamed from: com.ss.android.socialbase.downloader.model.DownloadTask$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {
        final /* synthetic */ com.ss.android.socialbase.downloader.downloader.IDownloadStartCallback val$downloadStartCallback;

        public AnonymousClass1(com.ss.android.socialbase.downloader.downloader.IDownloadStartCallback iDownloadStartCallback) {
            this.val$downloadStartCallback = iDownloadStartCallback;
        }

        @Override // java.lang.Runnable
        public void run() {
            int download = com.ss.android.socialbase.downloader.model.DownloadTask.this.download();
            com.ss.android.socialbase.downloader.downloader.IDownloadStartCallback iDownloadStartCallback = this.val$downloadStartCallback;
            if (iDownloadStartCallback != null) {
                iDownloadStartCallback.onStart(download);
            }
        }
    }

    /* renamed from: com.ss.android.socialbase.downloader.model.DownloadTask$2, reason: invalid class name */
    public class AnonymousClass2 implements com.ss.android.socialbase.downloader.downloader.IChunkCntCalculator {
        public AnonymousClass2() {
        }

        @Override // com.ss.android.socialbase.downloader.downloader.IChunkCntCalculator
        public int calculateChunkCount(long j) {
            return 1;
        }
    }

    public DownloadTask() {
        this.singleListenerMap = new java.util.concurrent.ConcurrentHashMap();
        this.singleListenerHashCodeMap = new android.util.SparseArray<>();
        this.needDelayForCacheSync = false;
        this.downloadCompleteHandlers = new java.util.ArrayList();
        this.autoSetHashCodeForSameTask = true;
        this.downloadInfoBuilder = new com.ss.android.socialbase.downloader.model.DownloadInfo.Builder();
        this.mainThreadListeners = new android.util.SparseArray<>();
        this.subThreadListeners = new android.util.SparseArray<>();
        this.notificationListeners = new android.util.SparseArray<>();
    }

    public DownloadTask(com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo) {
        this();
        this.downloadInfo = downloadInfo;
    }

    private void addAll(android.util.SparseArray sparseArray, android.util.SparseArray sparseArray2) {
        if (sparseArray == null || sparseArray2 == null) {
            return;
        }
        int size = sparseArray.size();
        for (int i = 0; i < size; i++) {
            int keyAt = sparseArray.keyAt(i);
            sparseArray2.put(keyAt, sparseArray.get(keyAt));
        }
    }

    private void addListenerToDownloadingSameTask(com.ss.android.socialbase.downloader.constants.ListenerType listenerType) {
        android.util.SparseArray<com.ss.android.socialbase.downloader.depend.IDownloadListener> downloadListeners = getDownloadListeners(listenerType);
        synchronized (downloadListeners) {
            for (int i = 0; i < downloadListeners.size(); i++) {
                com.ss.android.socialbase.downloader.depend.IDownloadListener iDownloadListener = downloadListeners.get(downloadListeners.keyAt(i));
                if (iDownloadListener != null) {
                    com.ss.android.socialbase.downloader.downloader.DownloadProcessDispatcher.getInstance().addDownloadListener(getDownloadId(), iDownloadListener, listenerType, false);
                }
            }
        }
    }

    private void copyListeners(android.util.SparseArray<com.ss.android.socialbase.downloader.depend.IDownloadListener> sparseArray, android.util.SparseArray<com.ss.android.socialbase.downloader.depend.IDownloadListener> sparseArray2) {
        sparseArray.clear();
        for (int i = 0; i < sparseArray2.size(); i++) {
            int keyAt = sparseArray2.keyAt(i);
            com.ss.android.socialbase.downloader.depend.IDownloadListener iDownloadListener = sparseArray2.get(keyAt);
            if (iDownloadListener != null) {
                sparseArray.put(keyAt, iDownloadListener);
            }
        }
    }

    private void removeAll(android.util.SparseArray sparseArray, android.util.SparseArray sparseArray2) {
        if (sparseArray == null || sparseArray2 == null) {
            return;
        }
        int size = sparseArray2.size();
        for (int i = 0; i < size; i++) {
            sparseArray.remove(sparseArray2.keyAt(i));
        }
    }

    private void setChunkCalculator() {
        if (this.downloadInfo.getThrottleNetSpeed() > 0) {
            chunkStategy(new com.ss.android.socialbase.downloader.model.DownloadTask.AnonymousClass2());
        }
    }

    public com.ss.android.socialbase.downloader.model.DownloadTask addDownloadCompleteHandler(com.ss.android.socialbase.downloader.depend.IDownloadCompleteHandler iDownloadCompleteHandler) {
        synchronized (this.downloadCompleteHandlers) {
            if (iDownloadCompleteHandler != null) {
                if (!this.downloadCompleteHandlers.contains(iDownloadCompleteHandler)) {
                    this.downloadCompleteHandlers.add(iDownloadCompleteHandler);
                    return this;
                }
            }
            return this;
        }
    }

    public void addDownloadListener(int i, com.ss.android.socialbase.downloader.depend.IDownloadListener iDownloadListener, com.ss.android.socialbase.downloader.constants.ListenerType listenerType, boolean z) {
        java.util.Map<com.ss.android.socialbase.downloader.constants.ListenerType, com.ss.android.socialbase.downloader.depend.IDownloadListener> map;
        if (iDownloadListener == null) {
            return;
        }
        if (z && (map = this.singleListenerMap) != null) {
            map.put(listenerType, iDownloadListener);
            synchronized (this.singleListenerHashCodeMap) {
                this.singleListenerHashCodeMap.put(i, listenerType);
            }
        }
        android.util.SparseArray<com.ss.android.socialbase.downloader.depend.IDownloadListener> downloadListeners = getDownloadListeners(listenerType);
        if (downloadListeners == null) {
            return;
        }
        synchronized (downloadListeners) {
            downloadListeners.put(i, iDownloadListener);
        }
    }

    public void addListenerToDownloadingSameTask() {
        com.ss.android.socialbase.downloader.logger.Logger.d("DownloadTask", "same task just tryDownloading, so add listener in last task instead of tryDownload");
        com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo = this.downloadInfo;
        if (downloadInfo != null && !downloadInfo.isAddListenerToSameTask()) {
            this.downloadInfo.setAddListenerToSameTask(true);
        }
        addListenerToDownloadingSameTask(com.ss.android.socialbase.downloader.constants.ListenerType.MAIN);
        addListenerToDownloadingSameTask(com.ss.android.socialbase.downloader.constants.ListenerType.SUB);
        com.ss.android.socialbase.downloader.monitor.DownloadMonitorHelper.monitorSendWithTaskMonitor(this.monitorDepend, this.downloadInfo, new com.ss.android.socialbase.downloader.exception.BaseException(1003, "has another same task, add Listener to old task"), 0);
    }

    public com.ss.android.socialbase.downloader.model.DownloadTask addListenerToSameTask(boolean z) {
        this.downloadInfoBuilder.addListenerToSameTask(z);
        return this;
    }

    public void asyncDownload(com.ss.android.socialbase.downloader.downloader.IDownloadStartCallback iDownloadStartCallback) {
        com.ss.android.socialbase.downloader.thread.DownloadThreadPool.executeOP(new com.ss.android.socialbase.downloader.model.DownloadTask.AnonymousClass1(iDownloadStartCallback));
    }

    public synchronized int autoCalAndGetHashCodeForSameTask() {
        com.ss.android.socialbase.downloader.depend.IDownloadListener singleDownloadListener = getSingleDownloadListener(com.ss.android.socialbase.downloader.constants.ListenerType.MAIN);
        if (singleDownloadListener == null) {
            singleDownloadListener = getSingleDownloadListener(com.ss.android.socialbase.downloader.constants.ListenerType.SUB);
        }
        if (singleDownloadListener != null) {
            this.hashCodeForSameTask = singleDownloadListener.hashCode();
        }
        return this.hashCodeForSameTask;
    }

    public com.ss.android.socialbase.downloader.model.DownloadTask autoResumed(boolean z) {
        this.downloadInfoBuilder.autoResumed(z);
        return this;
    }

    public com.ss.android.socialbase.downloader.model.DownloadTask autoSetHashCodeForSameTask(boolean z) {
        this.autoSetHashCodeForSameTask = z;
        return this;
    }

    public com.ss.android.socialbase.downloader.model.DownloadTask backUpUrlRetryCount(int i) {
        this.downloadInfoBuilder.backUpUrlRetryCount(i);
        return this;
    }

    public com.ss.android.socialbase.downloader.model.DownloadTask backUpUrls(java.util.List<java.lang.String> list) {
        this.downloadInfoBuilder.backUpUrls(list);
        return this;
    }

    public boolean canShowNotification() {
        com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo = this.downloadInfo;
        if (downloadInfo != null) {
            return downloadInfo.canShowNotification();
        }
        return false;
    }

    public com.ss.android.socialbase.downloader.model.DownloadTask chunkAdjustCalculator(com.ss.android.socialbase.downloader.downloader.IChunkAdjustCalculator iChunkAdjustCalculator) {
        this.chunkAdjustCalculator = iChunkAdjustCalculator;
        return this;
    }

    public com.ss.android.socialbase.downloader.model.DownloadTask chunkStategy(com.ss.android.socialbase.downloader.downloader.IChunkCntCalculator iChunkCntCalculator) {
        this.chunkStrategy = iChunkCntCalculator;
        return this;
    }

    public void copyInterfaceFromNewTask(com.ss.android.socialbase.downloader.model.DownloadTask downloadTask) {
        this.chunkAdjustCalculator = downloadTask.chunkAdjustCalculator;
        this.chunkStrategy = downloadTask.chunkStrategy;
        this.singleListenerMap.clear();
        this.singleListenerMap.putAll(downloadTask.singleListenerMap);
        synchronized (this.mainThreadListeners) {
            this.mainThreadListeners.clear();
            addAll(downloadTask.mainThreadListeners, this.mainThreadListeners);
        }
        synchronized (this.subThreadListeners) {
            this.subThreadListeners.clear();
            addAll(downloadTask.subThreadListeners, this.subThreadListeners);
        }
        synchronized (this.notificationListeners) {
            this.notificationListeners.clear();
            addAll(downloadTask.notificationListeners, this.notificationListeners);
        }
        this.notificationEventListener = downloadTask.notificationEventListener;
        this.interceptor = downloadTask.interceptor;
        this.depend = downloadTask.depend;
        this.monitorDepend = downloadTask.monitorDepend;
        this.forbiddenHandler = downloadTask.forbiddenHandler;
        this.diskSpaceHandler = downloadTask.diskSpaceHandler;
        this.retryDelayTimeCalculator = downloadTask.retryDelayTimeCalculator;
        this.notificationClickCallback = downloadTask.notificationClickCallback;
        this.fileUriProvider = downloadTask.fileUriProvider;
        synchronized (this.downloadCompleteHandlers) {
            this.downloadCompleteHandlers.clear();
            this.downloadCompleteHandlers.addAll(downloadTask.downloadCompleteHandlers);
        }
    }

    public void copyListenerFromPendingTask(com.ss.android.socialbase.downloader.model.DownloadTask downloadTask) {
        for (java.util.Map.Entry<com.ss.android.socialbase.downloader.constants.ListenerType, com.ss.android.socialbase.downloader.depend.IDownloadListener> entry : downloadTask.singleListenerMap.entrySet()) {
            if (entry != null && !this.singleListenerMap.containsKey(entry.getKey())) {
                this.singleListenerMap.put(entry.getKey(), entry.getValue());
            }
        }
        try {
            if (downloadTask.mainThreadListeners.size() != 0) {
                synchronized (this.mainThreadListeners) {
                    removeAll(this.mainThreadListeners, downloadTask.mainThreadListeners);
                    addAll(downloadTask.mainThreadListeners, this.mainThreadListeners);
                }
            }
            if (downloadTask.subThreadListeners.size() != 0) {
                synchronized (this.subThreadListeners) {
                    removeAll(this.subThreadListeners, downloadTask.subThreadListeners);
                    addAll(downloadTask.subThreadListeners, this.subThreadListeners);
                }
            }
            if (downloadTask.notificationListeners.size() != 0) {
                synchronized (this.notificationListeners) {
                    removeAll(this.notificationListeners, downloadTask.notificationListeners);
                    addAll(downloadTask.notificationListeners, this.notificationListeners);
                }
            }
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    public com.ss.android.socialbase.downloader.model.DownloadTask deleteCacheIfCheckFailed(boolean z) {
        this.downloadInfoBuilder.deleteCacheIfCheckFailed(z);
        return this;
    }

    public com.ss.android.socialbase.downloader.model.DownloadTask depend(com.ss.android.socialbase.downloader.depend.IDownloadDepend iDownloadDepend) {
        this.depend = iDownloadDepend;
        return this;
    }

    public com.ss.android.socialbase.downloader.model.DownloadTask diskSpaceHandler(com.ss.android.socialbase.downloader.depend.IDownloadDiskSpaceHandler iDownloadDiskSpaceHandler) {
        this.diskSpaceHandler = iDownloadDiskSpaceHandler;
        return this;
    }

    public com.ss.android.socialbase.downloader.model.DownloadTask distinctDirectory(boolean z) {
        this.downloadInfoBuilder.distinctDirectory(z);
        return this;
    }

    public int download() {
        this.downloadInfo = this.downloadInfoBuilder.build();
        com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo = com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.getDownloadCache().getDownloadInfo(this.downloadInfo.getId());
        if (downloadInfo == null) {
            this.downloadInfo.generateTaskId();
            com.ss.android.socialbase.downloader.monitor.DownloadMonitorHelper.monitorSend(this, null, 0);
        } else {
            this.downloadInfo.copyTaskIdFromCacheData(downloadInfo);
        }
        setChunkCalculator();
        com.ss.android.socialbase.downloader.downloader.DownloadProcessDispatcher.getInstance().tryDownload(this);
        com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo2 = this.downloadInfo;
        if (downloadInfo2 == null) {
            return 0;
        }
        return downloadInfo2.getId();
    }

    public com.ss.android.socialbase.downloader.model.DownloadTask downloadSetting(org.json.JSONObject jSONObject) {
        this.downloadInfoBuilder.downloadSetting(jSONObject);
        return this;
    }

    public com.ss.android.socialbase.downloader.model.DownloadTask enqueueType(com.ss.android.socialbase.downloader.constants.EnqueueType enqueueType) {
        this.downloadInfoBuilder.enqueueType(enqueueType);
        return this;
    }

    public com.ss.android.socialbase.downloader.model.DownloadTask executorGroup(@com.ss.android.socialbase.downloader.constants.ExecutorGroup int i) {
        this.downloadInfoBuilder.executorGroup(i);
        return this;
    }

    public com.ss.android.socialbase.downloader.model.DownloadTask expectFileLength(long j) {
        this.downloadInfoBuilder.expectFileLength(j);
        return this;
    }

    public com.ss.android.socialbase.downloader.model.DownloadTask expiredRedownload(boolean z) {
        this.downloadInfoBuilder.expiredRedownload(z);
        return this;
    }

    public com.ss.android.socialbase.downloader.model.DownloadTask extra(java.lang.String str) {
        this.downloadInfoBuilder.extra(str);
        return this;
    }

    public com.ss.android.socialbase.downloader.model.DownloadTask extraHeaders(java.util.List<com.ss.android.socialbase.downloader.model.HttpHeader> list) {
        this.downloadInfoBuilder.extraHeaders(list);
        return this;
    }

    public com.ss.android.socialbase.downloader.model.DownloadTask extraMonitorStatus(int[] iArr) {
        this.downloadInfoBuilder.extraMonitorStatus(iArr);
        return this;
    }

    public com.ss.android.socialbase.downloader.model.DownloadTask fileUriProvider(com.ss.android.socialbase.downloader.depend.IDownloadFileUriProvider iDownloadFileUriProvider) {
        this.fileUriProvider = iDownloadFileUriProvider;
        return this;
    }

    public com.ss.android.socialbase.downloader.model.DownloadTask forbiddenHandler(com.ss.android.socialbase.downloader.depend.IDownloadForbiddenHandler iDownloadForbiddenHandler) {
        this.forbiddenHandler = iDownloadForbiddenHandler;
        return this;
    }

    public com.ss.android.socialbase.downloader.model.DownloadTask force(boolean z) {
        this.downloadInfoBuilder.force(z);
        return this;
    }

    public com.ss.android.socialbase.downloader.downloader.IChunkAdjustCalculator getChunkAdjustCalculator() {
        return this.chunkAdjustCalculator;
    }

    public com.ss.android.socialbase.downloader.downloader.IChunkCntCalculator getChunkStrategy() {
        return this.chunkStrategy;
    }

    public com.ss.android.socialbase.downloader.depend.IDownloadDepend getDepend() {
        return this.depend;
    }

    public com.ss.android.socialbase.downloader.depend.IDownloadDiskSpaceHandler getDiskSpaceHandler() {
        return this.diskSpaceHandler;
    }

    public com.ss.android.socialbase.downloader.depend.IDownloadCompleteHandler getDownloadCompleteHandlerByIndex(int i) {
        synchronized (this.downloadCompleteHandlers) {
            if (i >= this.downloadCompleteHandlers.size()) {
                return null;
            }
            return this.downloadCompleteHandlers.get(i);
        }
    }

    @androidx.annotation.NonNull
    public java.util.List<com.ss.android.socialbase.downloader.depend.IDownloadCompleteHandler> getDownloadCompleteHandlers() {
        return this.downloadCompleteHandlers;
    }

    public int getDownloadId() {
        com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo = this.downloadInfo;
        if (downloadInfo == null) {
            return 0;
        }
        return downloadInfo.getId();
    }

    public com.ss.android.socialbase.downloader.model.DownloadInfo getDownloadInfo() {
        return this.downloadInfo;
    }

    public com.ss.android.socialbase.downloader.depend.IDownloadListener getDownloadListenerByIndex(com.ss.android.socialbase.downloader.constants.ListenerType listenerType, int i) {
        android.util.SparseArray<com.ss.android.socialbase.downloader.depend.IDownloadListener> downloadListeners = getDownloadListeners(listenerType);
        if (downloadListeners == null || i < 0) {
            return null;
        }
        synchronized (downloadListeners) {
            if (i >= downloadListeners.size()) {
                return null;
            }
            return downloadListeners.get(downloadListeners.keyAt(i));
        }
    }

    public int getDownloadListenerSize(com.ss.android.socialbase.downloader.constants.ListenerType listenerType) {
        int size;
        android.util.SparseArray<com.ss.android.socialbase.downloader.depend.IDownloadListener> downloadListeners = getDownloadListeners(listenerType);
        if (downloadListeners == null) {
            return 0;
        }
        synchronized (downloadListeners) {
            size = downloadListeners.size();
        }
        return size;
    }

    public android.util.SparseArray<com.ss.android.socialbase.downloader.depend.IDownloadListener> getDownloadListeners(com.ss.android.socialbase.downloader.constants.ListenerType listenerType) {
        if (listenerType == com.ss.android.socialbase.downloader.constants.ListenerType.MAIN) {
            return this.mainThreadListeners;
        }
        if (listenerType == com.ss.android.socialbase.downloader.constants.ListenerType.SUB) {
            return this.subThreadListeners;
        }
        if (listenerType == com.ss.android.socialbase.downloader.constants.ListenerType.NOTIFICATION) {
            return this.notificationListeners;
        }
        return null;
    }

    public com.ss.android.socialbase.downloader.depend.IDownloadFileUriProvider getFileUriProvider() {
        return this.fileUriProvider;
    }

    public com.ss.android.socialbase.downloader.depend.IDownloadForbiddenHandler getForbiddenHandler() {
        return this.forbiddenHandler;
    }

    public int getHashCodeForSameTask() {
        return this.hashCodeForSameTask;
    }

    public com.ss.android.socialbase.downloader.depend.IDownloadInterceptor getInterceptor() {
        return this.interceptor;
    }

    public com.ss.android.socialbase.downloader.depend.IDownloadMonitorDepend getMonitorDepend() {
        return this.monitorDepend;
    }

    public com.ss.android.socialbase.downloader.depend.INotificationClickCallback getNotificationClickCallback() {
        return this.notificationClickCallback;
    }

    public com.ss.android.socialbase.downloader.depend.IDownloadNotificationEventListener getNotificationEventListener() {
        return this.notificationEventListener;
    }

    public com.ss.android.socialbase.downloader.downloader.IRetryDelayTimeCalculator getRetryDelayTimeCalculator() {
        return this.retryDelayTimeCalculator;
    }

    public com.ss.android.socialbase.downloader.depend.IDownloadListener getSingleDownloadListener(com.ss.android.socialbase.downloader.constants.ListenerType listenerType) {
        return this.singleListenerMap.get(listenerType);
    }

    public com.ss.android.socialbase.downloader.model.DownloadTask hashCodeForSameTask(int i) {
        this.hashCodeForSameTask = i;
        return this;
    }

    public com.ss.android.socialbase.downloader.model.DownloadTask headConnectionAvailable(boolean z) {
        this.downloadInfoBuilder.headConnectionAvailable(z);
        return this;
    }

    public com.ss.android.socialbase.downloader.model.DownloadTask iconUrl(java.lang.String str) {
        this.downloadInfoBuilder.iconUrl(str);
        return this;
    }

    public com.ss.android.socialbase.downloader.model.DownloadTask ignoreDataVerify(boolean z) {
        this.downloadInfoBuilder.ignoreDataVerify(z);
        return this;
    }

    public com.ss.android.socialbase.downloader.model.DownloadTask interceptor(com.ss.android.socialbase.downloader.depend.IDownloadInterceptor iDownloadInterceptor) {
        this.interceptor = iDownloadInterceptor;
        return this;
    }

    public boolean isAutoSetHashCodeForSameTask() {
        return this.autoSetHashCodeForSameTask;
    }

    public boolean isNeedDelayForCacheSync() {
        return this.needDelayForCacheSync;
    }

    public com.ss.android.socialbase.downloader.model.DownloadTask isOpenLimitSpeed(boolean z) {
        this.downloadInfoBuilder.isOpenLimitSpeed(z);
        return this;
    }

    public com.ss.android.socialbase.downloader.model.DownloadTask mainThreadListener(com.ss.android.socialbase.downloader.depend.IDownloadListener iDownloadListener) {
        return iDownloadListener == null ? this : mainThreadListenerWithHashCode(iDownloadListener.hashCode(), iDownloadListener);
    }

    public com.ss.android.socialbase.downloader.model.DownloadTask mainThreadListenerWithHashCode(int i, com.ss.android.socialbase.downloader.depend.IDownloadListener iDownloadListener) {
        if (iDownloadListener != null) {
            synchronized (this.mainThreadListeners) {
                this.mainThreadListeners.put(i, iDownloadListener);
            }
            java.util.Map<com.ss.android.socialbase.downloader.constants.ListenerType, com.ss.android.socialbase.downloader.depend.IDownloadListener> map = this.singleListenerMap;
            com.ss.android.socialbase.downloader.constants.ListenerType listenerType = com.ss.android.socialbase.downloader.constants.ListenerType.MAIN;
            map.put(listenerType, iDownloadListener);
            synchronized (this.singleListenerHashCodeMap) {
                this.singleListenerHashCodeMap.put(i, listenerType);
            }
        }
        return this;
    }

    public com.ss.android.socialbase.downloader.model.DownloadTask maxBytes(int i) {
        this.downloadInfoBuilder.maxBytes(i);
        return this;
    }

    public com.ss.android.socialbase.downloader.model.DownloadTask maxProgressCount(int i) {
        this.downloadInfoBuilder.maxProgressCount(i);
        return this;
    }

    public com.ss.android.socialbase.downloader.model.DownloadTask md5(java.lang.String str) {
        this.downloadInfoBuilder.md5(str);
        return this;
    }

    public com.ss.android.socialbase.downloader.model.DownloadTask mimeType(java.lang.String str) {
        this.downloadInfoBuilder.mimeType(str);
        return this;
    }

    public com.ss.android.socialbase.downloader.model.DownloadTask minProgressTimeMsInterval(int i) {
        this.downloadInfoBuilder.minProgressTimeMsInterval(i);
        return this;
    }

    public com.ss.android.socialbase.downloader.model.DownloadTask monitorDepend(com.ss.android.socialbase.downloader.depend.IDownloadMonitorDepend iDownloadMonitorDepend) {
        this.monitorDepend = iDownloadMonitorDepend;
        return this;
    }

    public com.ss.android.socialbase.downloader.model.DownloadTask monitorScene(java.lang.String str) {
        this.downloadInfoBuilder.monitorScene(str);
        return this;
    }

    public com.ss.android.socialbase.downloader.model.DownloadTask name(java.lang.String str) {
        this.downloadInfoBuilder.name(str);
        return this;
    }

    public com.ss.android.socialbase.downloader.model.DownloadTask needChunkDowngradeRetry(boolean z) {
        this.downloadInfoBuilder.needChunkDowngradeRetry(z);
        return this;
    }

    public com.ss.android.socialbase.downloader.model.DownloadTask needDefaultHttpServiceBackUp(boolean z) {
        this.downloadInfoBuilder.needDefaultHttpServiceBackUp(z);
        return this;
    }

    public com.ss.android.socialbase.downloader.model.DownloadTask needHttpsToHttpRetry(boolean z) {
        this.downloadInfoBuilder.needHttpsToHttpRetry(z);
        return this;
    }

    public com.ss.android.socialbase.downloader.model.DownloadTask needIndependentProcess(boolean z) {
        this.downloadInfoBuilder.needIndependentProcess(z);
        return this;
    }

    public com.ss.android.socialbase.downloader.model.DownloadTask needPostProgress(boolean z) {
        this.downloadInfoBuilder.needPostProgress(z);
        return this;
    }

    public com.ss.android.socialbase.downloader.model.DownloadTask needRetryDelay(boolean z) {
        this.downloadInfoBuilder.needRetryDelay(z);
        return this;
    }

    public com.ss.android.socialbase.downloader.model.DownloadTask needReuseChunkRunnable(boolean z) {
        this.downloadInfoBuilder.needReuseChunkRunnable(z);
        return this;
    }

    public com.ss.android.socialbase.downloader.model.DownloadTask needReuseFirstConnection(boolean z) {
        this.downloadInfoBuilder.needReuseFirstConnection(z);
        return this;
    }

    public com.ss.android.socialbase.downloader.model.DownloadTask needSDKMonitor(boolean z) {
        this.downloadInfoBuilder.needSDKMonitor(z);
        return this;
    }

    @java.lang.Deprecated
    public com.ss.android.socialbase.downloader.model.DownloadTask newSaveTempFileEnable(boolean z) {
        return this;
    }

    public com.ss.android.socialbase.downloader.model.DownloadTask notificationClickCallback(com.ss.android.socialbase.downloader.depend.INotificationClickCallback iNotificationClickCallback) {
        this.notificationClickCallback = iNotificationClickCallback;
        return this;
    }

    public com.ss.android.socialbase.downloader.model.DownloadTask notificationEventListener(com.ss.android.socialbase.downloader.depend.IDownloadNotificationEventListener iDownloadNotificationEventListener) {
        this.notificationEventListener = iDownloadNotificationEventListener;
        return this;
    }

    public com.ss.android.socialbase.downloader.model.DownloadTask notificationListener(com.ss.android.socialbase.downloader.depend.IDownloadListener iDownloadListener) {
        return iDownloadListener == null ? this : notificationListenerWithHashCode(iDownloadListener.hashCode(), iDownloadListener);
    }

    public com.ss.android.socialbase.downloader.model.DownloadTask notificationListenerWithHashCode(int i, com.ss.android.socialbase.downloader.depend.IDownloadListener iDownloadListener) {
        if (iDownloadListener != null) {
            synchronized (this.notificationListeners) {
                this.notificationListeners.put(i, iDownloadListener);
            }
            java.util.Map<com.ss.android.socialbase.downloader.constants.ListenerType, com.ss.android.socialbase.downloader.depend.IDownloadListener> map = this.singleListenerMap;
            com.ss.android.socialbase.downloader.constants.ListenerType listenerType = com.ss.android.socialbase.downloader.constants.ListenerType.NOTIFICATION;
            map.put(listenerType, iDownloadListener);
            synchronized (this.singleListenerHashCodeMap) {
                this.singleListenerHashCodeMap.put(i, listenerType);
            }
        }
        return this;
    }

    public com.ss.android.socialbase.downloader.model.DownloadTask onlyWifi(boolean z) {
        this.downloadInfoBuilder.onlyWifi(z);
        return this;
    }

    public com.ss.android.socialbase.downloader.model.DownloadTask outIp(java.lang.String[] strArr) {
        this.downloadInfoBuilder.outIp(strArr);
        return this;
    }

    public com.ss.android.socialbase.downloader.model.DownloadTask outSize(int[] iArr) {
        this.downloadInfoBuilder.outSize(iArr);
        return this;
    }

    public com.ss.android.socialbase.downloader.model.DownloadTask packageName(java.lang.String str) {
        this.downloadInfoBuilder.packageName(str);
        return this;
    }

    public void removeDownloadListener(int i, com.ss.android.socialbase.downloader.depend.IDownloadListener iDownloadListener, com.ss.android.socialbase.downloader.constants.ListenerType listenerType, boolean z) {
        int indexOfValue;
        android.util.SparseArray<com.ss.android.socialbase.downloader.depend.IDownloadListener> downloadListeners = getDownloadListeners(listenerType);
        if (downloadListeners == null) {
            if (z && this.singleListenerMap.containsKey(listenerType)) {
                this.singleListenerMap.remove(listenerType);
                return;
            }
            return;
        }
        synchronized (downloadListeners) {
            if (z) {
                if (this.singleListenerMap.containsKey(listenerType)) {
                    iDownloadListener = this.singleListenerMap.get(listenerType);
                    this.singleListenerMap.remove(listenerType);
                }
                if (iDownloadListener != null && (indexOfValue = downloadListeners.indexOfValue(iDownloadListener)) >= 0 && indexOfValue < downloadListeners.size()) {
                    downloadListeners.removeAt(indexOfValue);
                }
            } else {
                downloadListeners.remove(i);
                synchronized (this.singleListenerHashCodeMap) {
                    com.ss.android.socialbase.downloader.constants.ListenerType listenerType2 = this.singleListenerHashCodeMap.get(i);
                    if (listenerType2 != null && this.singleListenerMap.containsKey(listenerType2)) {
                        this.singleListenerMap.remove(listenerType2);
                        this.singleListenerHashCodeMap.remove(i);
                    }
                }
            }
        }
    }

    public com.ss.android.socialbase.downloader.model.DownloadTask retryCount(int i) {
        this.downloadInfoBuilder.retryCount(i);
        return this;
    }

    public com.ss.android.socialbase.downloader.model.DownloadTask retryDelayTimeArray(java.lang.String str) {
        this.downloadInfoBuilder.retryDelayTimeArray(str);
        return this;
    }

    public com.ss.android.socialbase.downloader.model.DownloadTask retryDelayTimeCalculator(com.ss.android.socialbase.downloader.downloader.IRetryDelayTimeCalculator iRetryDelayTimeCalculator) {
        this.retryDelayTimeCalculator = iRetryDelayTimeCalculator;
        return this;
    }

    public com.ss.android.socialbase.downloader.model.DownloadTask savePath(java.lang.String str) {
        this.downloadInfoBuilder.savePath(str);
        return this;
    }

    public com.ss.android.socialbase.downloader.model.DownloadTask setAutoInstall(boolean z) {
        this.downloadInfoBuilder.setAutoInstall(z);
        return this;
    }

    public com.ss.android.socialbase.downloader.model.DownloadTask setDownloadCompleteHandlers(java.util.List<com.ss.android.socialbase.downloader.depend.IDownloadCompleteHandler> list) {
        if (list != null && !list.isEmpty()) {
            java.util.Iterator<com.ss.android.socialbase.downloader.depend.IDownloadCompleteHandler> it = list.iterator();
            while (it.hasNext()) {
                addDownloadCompleteHandler(it.next());
            }
        }
        return this;
    }

    public void setDownloadListeners(android.util.SparseArray<com.ss.android.socialbase.downloader.depend.IDownloadListener> sparseArray, com.ss.android.socialbase.downloader.constants.ListenerType listenerType) {
        if (sparseArray == null) {
            return;
        }
        try {
            if (listenerType == com.ss.android.socialbase.downloader.constants.ListenerType.MAIN) {
                synchronized (this.mainThreadListeners) {
                    copyListeners(this.mainThreadListeners, sparseArray);
                }
                return;
            } else if (listenerType == com.ss.android.socialbase.downloader.constants.ListenerType.SUB) {
                synchronized (this.subThreadListeners) {
                    copyListeners(this.subThreadListeners, sparseArray);
                }
                return;
            } else {
                if (listenerType == com.ss.android.socialbase.downloader.constants.ListenerType.NOTIFICATION) {
                    synchronized (this.notificationListeners) {
                        copyListeners(this.notificationListeners, sparseArray);
                    }
                    return;
                }
                return;
            }
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
        th.printStackTrace();
    }

    public void setNeedDelayForCacheSync(boolean z) {
        this.needDelayForCacheSync = z;
    }

    public void setNotificationEventListener(com.ss.android.socialbase.downloader.depend.IDownloadNotificationEventListener iDownloadNotificationEventListener) {
        this.notificationEventListener = iDownloadNotificationEventListener;
    }

    public com.ss.android.socialbase.downloader.model.DownloadTask showNotification(boolean z) {
        this.downloadInfoBuilder.showNotification(z);
        return this;
    }

    public com.ss.android.socialbase.downloader.model.DownloadTask showNotificationForAutoResumed(boolean z) {
        this.downloadInfoBuilder.showNotificationForAutoResumed(z);
        return this;
    }

    public com.ss.android.socialbase.downloader.model.DownloadTask subThreadListener(com.ss.android.socialbase.downloader.depend.IDownloadListener iDownloadListener) {
        return iDownloadListener == null ? this : subThreadListenerWithHashCode(iDownloadListener.hashCode(), iDownloadListener);
    }

    public com.ss.android.socialbase.downloader.model.DownloadTask subThreadListenerWithHashCode(int i, com.ss.android.socialbase.downloader.depend.IDownloadListener iDownloadListener) {
        if (iDownloadListener != null) {
            synchronized (this.subThreadListeners) {
                this.subThreadListeners.put(i, iDownloadListener);
            }
            java.util.Map<com.ss.android.socialbase.downloader.constants.ListenerType, com.ss.android.socialbase.downloader.depend.IDownloadListener> map = this.singleListenerMap;
            com.ss.android.socialbase.downloader.constants.ListenerType listenerType = com.ss.android.socialbase.downloader.constants.ListenerType.SUB;
            map.put(listenerType, iDownloadListener);
            synchronized (this.singleListenerHashCodeMap) {
                this.singleListenerHashCodeMap.put(i, listenerType);
            }
        }
        return this;
    }

    public com.ss.android.socialbase.downloader.model.DownloadTask taskKey(java.lang.String str) {
        this.downloadInfoBuilder.taskKey(str);
        return this;
    }

    public com.ss.android.socialbase.downloader.model.DownloadTask tempPath(java.lang.String str) {
        this.downloadInfoBuilder.tempPath(str);
        return this;
    }

    public com.ss.android.socialbase.downloader.model.DownloadTask throttleNetSpeed(long j) {
        this.downloadInfoBuilder.throttleNetSpeed(j);
        return this;
    }

    public com.ss.android.socialbase.downloader.model.DownloadTask title(java.lang.String str) {
        this.downloadInfoBuilder.title(str);
        return this;
    }

    public com.ss.android.socialbase.downloader.model.DownloadTask ttnetProtectTimeout(long j) {
        this.downloadInfoBuilder.ttnetProtectTimeout(j);
        return this;
    }

    public com.ss.android.socialbase.downloader.model.DownloadTask url(java.lang.String str) {
        this.downloadInfoBuilder.url(str);
        return this;
    }
}
