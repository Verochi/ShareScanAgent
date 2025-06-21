package com.ss.android.socialbase.downloader.downloader;

/* loaded from: classes19.dex */
public class DownloadProcessDispatcher {
    private static volatile com.ss.android.socialbase.downloader.downloader.DownloadProcessDispatcher instance;
    private volatile android.util.SparseArray<java.lang.Boolean> independentMap = new android.util.SparseArray<>();
    private android.os.Handler mainThreadHandler = new android.os.Handler(android.os.Looper.getMainLooper());
    private volatile java.util.List<com.ss.android.socialbase.downloader.depend.IDownloaderProcessConnectedListener> processConnectedListeners = new java.util.ArrayList();

    /* renamed from: com.ss.android.socialbase.downloader.downloader.DownloadProcessDispatcher$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {
        final /* synthetic */ com.ss.android.socialbase.downloader.downloader.IDownloadProxy val$downloadProxy;
        final /* synthetic */ com.ss.android.socialbase.downloader.model.DownloadTask val$downloadTask;

        public AnonymousClass1(com.ss.android.socialbase.downloader.downloader.IDownloadProxy iDownloadProxy, com.ss.android.socialbase.downloader.model.DownloadTask downloadTask) {
            this.val$downloadProxy = iDownloadProxy;
            this.val$downloadTask = downloadTask;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.val$downloadProxy.tryDownload(this.val$downloadTask);
        }
    }

    private com.ss.android.socialbase.downloader.downloader.IDownloadProxy getDownloadHandler(com.ss.android.socialbase.downloader.model.DownloadTask downloadTask) {
        com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo;
        java.util.List<com.ss.android.socialbase.downloader.model.DownloadChunk> downloadChunk;
        if (downloadTask == null || (downloadInfo = downloadTask.getDownloadInfo()) == null) {
            return null;
        }
        boolean isNeedIndependentProcess = downloadInfo.isNeedIndependentProcess();
        if (com.ss.android.socialbase.downloader.utils.DownloadUtils.isDownloaderProcess() || !com.ss.android.socialbase.downloader.utils.DownloadUtils.isMainProcess()) {
            isNeedIndependentProcess = true;
        }
        int downloadWithIndependentProcessStatus = getDownloadWithIndependentProcessStatus(downloadInfo.getId());
        if (downloadWithIndependentProcessStatus >= 0 && downloadWithIndependentProcessStatus != isNeedIndependentProcess) {
            try {
                if (downloadWithIndependentProcessStatus == 1) {
                    if (com.ss.android.socialbase.downloader.utils.DownloadUtils.isMainProcess()) {
                        com.ss.android.socialbase.downloader.impls.DownloadProxy.get(true).pause(downloadInfo.getId());
                        com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo2 = com.ss.android.socialbase.downloader.impls.DownloadProxy.get(true).getDownloadInfo(downloadInfo.getId());
                        if (downloadInfo2 != null) {
                            com.ss.android.socialbase.downloader.impls.DownloadProxy.get(false).syncDownloadInfo(downloadInfo2);
                        }
                        if (downloadInfo2.getChunkCount() > 1 && (downloadChunk = com.ss.android.socialbase.downloader.impls.DownloadProxy.get(true).getDownloadChunk(downloadInfo.getId())) != null) {
                            com.ss.android.socialbase.downloader.impls.DownloadProxy.get(false).syncDownloadChunks(downloadInfo.getId(), com.ss.android.socialbase.downloader.utils.DownloadUtils.parseHostChunkList(downloadChunk));
                        }
                    }
                } else if (com.ss.android.socialbase.downloader.utils.DownloadUtils.isMainProcess()) {
                    com.ss.android.socialbase.downloader.impls.DownloadProxy.get(false).pause(downloadInfo.getId());
                    java.util.List<com.ss.android.socialbase.downloader.model.DownloadChunk> downloadChunk2 = com.ss.android.socialbase.downloader.impls.DownloadProxy.get(false).getDownloadChunk(downloadInfo.getId());
                    if (downloadChunk2 != null) {
                        com.ss.android.socialbase.downloader.impls.DownloadProxy.get(true).syncDownloadChunks(downloadInfo.getId(), com.ss.android.socialbase.downloader.utils.DownloadUtils.parseHostChunkList(downloadChunk2));
                    }
                } else {
                    downloadTask.setNeedDelayForCacheSync(true);
                    com.ss.android.socialbase.downloader.impls.DownloadProxy.get(true).dispatchProcessCallback(1, downloadInfo.getId());
                }
            } catch (java.lang.Throwable unused) {
            }
        }
        setDownloadWithIndependentProcessStatus(downloadInfo.getId(), isNeedIndependentProcess);
        return com.ss.android.socialbase.downloader.impls.DownloadProxy.get(isNeedIndependentProcess);
    }

    public static com.ss.android.socialbase.downloader.downloader.DownloadProcessDispatcher getInstance() {
        if (instance == null) {
            synchronized (com.ss.android.socialbase.downloader.downloader.DownloadProcessDispatcher.class) {
                instance = new com.ss.android.socialbase.downloader.downloader.DownloadProcessDispatcher();
            }
        }
        return instance;
    }

    private java.util.List<com.ss.android.socialbase.downloader.model.DownloadInfo> handleDownloadInfos(java.util.List<com.ss.android.socialbase.downloader.model.DownloadInfo> list, java.util.List<com.ss.android.socialbase.downloader.model.DownloadInfo> list2, android.util.SparseArray<com.ss.android.socialbase.downloader.model.DownloadInfo> sparseArray) {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        if (list != null) {
            for (com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo : list) {
                if (downloadInfo != null && sparseArray.get(downloadInfo.getId()) == null) {
                    sparseArray.put(downloadInfo.getId(), downloadInfo);
                }
            }
        }
        if (list2 != null) {
            for (com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo2 : list2) {
                if (downloadInfo2 != null && sparseArray.get(downloadInfo2.getId()) == null) {
                    sparseArray.put(downloadInfo2.getId(), downloadInfo2);
                }
            }
        }
        for (int i = 0; i < sparseArray.size(); i++) {
            arrayList.add(sparseArray.get(sparseArray.keyAt(i)));
        }
        return arrayList;
    }

    public void addDownloadListener(int i, com.ss.android.socialbase.downloader.depend.IDownloadListener iDownloadListener, com.ss.android.socialbase.downloader.constants.ListenerType listenerType, boolean z) {
        com.ss.android.socialbase.downloader.downloader.IDownloadProxy downloadHandler = getDownloadHandler(i);
        if (downloadHandler == null) {
            return;
        }
        downloadHandler.addDownloadListener(i, iDownloadListener.hashCode(), iDownloadListener, listenerType, z);
    }

    public void addDownloadListener(int i, com.ss.android.socialbase.downloader.depend.IDownloadListener iDownloadListener, com.ss.android.socialbase.downloader.constants.ListenerType listenerType, boolean z, boolean z2) {
        com.ss.android.socialbase.downloader.downloader.IDownloadProxy downloadHandler = getDownloadHandler(i);
        if (downloadHandler == null) {
            return;
        }
        downloadHandler.addDownloadListener(i, iDownloadListener.hashCode(), iDownloadListener, listenerType, z, z2);
    }

    public boolean canResume(int i) {
        com.ss.android.socialbase.downloader.downloader.IDownloadProxy downloadHandler = getDownloadHandler(i);
        if (downloadHandler == null) {
            return false;
        }
        return downloadHandler.canResume(i);
    }

    public void cancel(int i, boolean z) {
        if (!com.ss.android.socialbase.downloader.utils.DownloadUtils.isMainProcess()) {
            com.ss.android.socialbase.downloader.downloader.IDownloadProxy downloadHandler = getDownloadHandler(i);
            if (downloadHandler != null) {
                downloadHandler.cancel(i, z);
            }
            com.ss.android.socialbase.downloader.impls.DownloadProxy.get(true).dispatchProcessCallback(2, i);
            return;
        }
        if (com.ss.android.socialbase.downloader.utils.DownloadExpSwitchCode.isSwitchEnable(8388608)) {
            com.ss.android.socialbase.downloader.downloader.IDownloadProxy iDownloadProxy = com.ss.android.socialbase.downloader.impls.DownloadProxy.get(true);
            if (iDownloadProxy != null) {
                iDownloadProxy.cancel(i, z);
            }
            com.ss.android.socialbase.downloader.downloader.IDownloadProxy iDownloadProxy2 = com.ss.android.socialbase.downloader.impls.DownloadProxy.get(false);
            if (iDownloadProxy2 != null) {
                iDownloadProxy2.cancel(i, z);
                return;
            }
            return;
        }
        com.ss.android.socialbase.downloader.downloader.IDownloadProxy iDownloadProxy3 = com.ss.android.socialbase.downloader.impls.DownloadProxy.get(false);
        if (iDownloadProxy3 != null) {
            iDownloadProxy3.cancel(i, z);
        }
        com.ss.android.socialbase.downloader.downloader.IDownloadProxy iDownloadProxy4 = com.ss.android.socialbase.downloader.impls.DownloadProxy.get(true);
        if (iDownloadProxy4 != null) {
            iDownloadProxy4.cancel(i, z);
        }
    }

    public void clearDownloadData(int i, boolean z) {
        com.ss.android.socialbase.downloader.downloader.IDownloadProxy downloadHandler = getDownloadHandler(i);
        if (downloadHandler == null) {
            return;
        }
        downloadHandler.clearDownloadData(i, z);
    }

    public void dispatchDownloaderProcessConnectedEvent() {
        synchronized (this.processConnectedListeners) {
            for (com.ss.android.socialbase.downloader.depend.IDownloaderProcessConnectedListener iDownloaderProcessConnectedListener : this.processConnectedListeners) {
                if (iDownloaderProcessConnectedListener != null) {
                    iDownloaderProcessConnectedListener.onConnected();
                }
            }
        }
    }

    public void forceDownloadIngoreRecommendSize(int i) {
        com.ss.android.socialbase.downloader.downloader.IDownloadProxy downloadHandler = getDownloadHandler(i);
        if (downloadHandler == null) {
            return;
        }
        downloadHandler.forceDownloadIngoreRecommendSize(i);
    }

    public java.util.List<com.ss.android.socialbase.downloader.model.DownloadInfo> getAllDownloadInfo() {
        android.util.SparseArray<com.ss.android.socialbase.downloader.model.DownloadInfo> sparseArray = new android.util.SparseArray<>();
        com.ss.android.socialbase.downloader.downloader.IDownloadProxy iDownloadProxy = com.ss.android.socialbase.downloader.impls.DownloadProxy.get(false);
        java.util.List<com.ss.android.socialbase.downloader.model.DownloadInfo> allDownloadInfo = iDownloadProxy != null ? iDownloadProxy.getAllDownloadInfo() : null;
        com.ss.android.socialbase.downloader.downloader.IDownloadProxy iDownloadProxy2 = com.ss.android.socialbase.downloader.impls.DownloadProxy.get(true);
        return handleDownloadInfos(allDownloadInfo, iDownloadProxy2 != null ? iDownloadProxy2.getAllDownloadInfo() : null, sparseArray);
    }

    public long getCurBytes(int i) {
        com.ss.android.socialbase.downloader.downloader.IDownloadProxy downloadHandler = getDownloadHandler(i);
        if (downloadHandler == null) {
            return 0L;
        }
        return downloadHandler.getCurBytes(i);
    }

    public com.ss.android.socialbase.downloader.depend.IDownloadFileUriProvider getDownloadFileUriProvider(int i) {
        com.ss.android.socialbase.downloader.downloader.IDownloadProxy downloadHandler = getDownloadHandler(i);
        if (downloadHandler == null) {
            return null;
        }
        return downloadHandler.getDownloadFileUriProvider(i);
    }

    public com.ss.android.socialbase.downloader.downloader.IDownloadProxy getDownloadHandler(int i) {
        return com.ss.android.socialbase.downloader.impls.DownloadProxy.get(getDownloadWithIndependentProcessStatus(i) == 1 && !com.ss.android.socialbase.downloader.utils.DownloadUtils.isDownloaderProcess());
    }

    public int getDownloadId(java.lang.String str, java.lang.String str2) {
        return com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.getDownloadId(str, str2);
    }

    public com.ss.android.socialbase.downloader.model.DownloadInfo getDownloadInfo(int i) {
        com.ss.android.socialbase.downloader.downloader.IDownloadProxy downloadHandler = getDownloadHandler(i);
        if (downloadHandler == null) {
            return null;
        }
        return downloadHandler.getDownloadInfo(i);
    }

    public com.ss.android.socialbase.downloader.model.DownloadInfo getDownloadInfo(java.lang.String str, java.lang.String str2) {
        int downloadId = getDownloadId(str, str2);
        com.ss.android.socialbase.downloader.downloader.IDownloadProxy downloadHandler = getDownloadHandler(downloadId);
        if (downloadHandler == null) {
            return null;
        }
        return downloadHandler.getDownloadInfo(downloadId);
    }

    public java.util.List<com.ss.android.socialbase.downloader.model.DownloadInfo> getDownloadInfoList(java.lang.String str) {
        java.util.List<com.ss.android.socialbase.downloader.model.DownloadInfo> downloadInfoList = com.ss.android.socialbase.downloader.impls.DownloadProxy.get(false).getDownloadInfoList(str);
        java.util.List<com.ss.android.socialbase.downloader.model.DownloadInfo> downloadInfoList2 = com.ss.android.socialbase.downloader.impls.DownloadProxy.get(true).getDownloadInfoList(str);
        if (downloadInfoList == null && downloadInfoList2 == null) {
            return null;
        }
        if (downloadInfoList == null || downloadInfoList2 == null) {
            return downloadInfoList != null ? downloadInfoList : downloadInfoList2;
        }
        java.util.ArrayList arrayList = new java.util.ArrayList(downloadInfoList);
        arrayList.addAll(downloadInfoList2);
        return arrayList;
    }

    public com.ss.android.socialbase.downloader.depend.IDownloadNotificationEventListener getDownloadNotificationEventListener(int i) {
        com.ss.android.socialbase.downloader.downloader.IDownloadProxy downloadHandler = getDownloadHandler(i);
        if (downloadHandler == null) {
            return null;
        }
        return downloadHandler.getDownloadNotificationEventListener(i);
    }

    public int getDownloadWithIndependentProcessStatus(int i) {
        if (com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.supportMultiProc()) {
            return (com.ss.android.socialbase.downloader.utils.DownloadUtils.isDownloaderProcess() || !com.ss.android.socialbase.downloader.impls.DownloadProxy.get(true).isServiceAlive()) ? getDownloadWithIndependentProcessStatusInner(i) : com.ss.android.socialbase.downloader.impls.DownloadProxy.get(true).getDownloadWithIndependentProcessStatus(i);
        }
        return -1;
    }

    public synchronized int getDownloadWithIndependentProcessStatusInner(int i) {
        if (this.independentMap.get(i) == null) {
            return -1;
        }
        return this.independentMap.get(i).booleanValue() ? 1 : 0;
    }

    public java.util.List<com.ss.android.socialbase.downloader.model.DownloadInfo> getDownloadingDownloadInfosWithMimeType(java.lang.String str) {
        android.util.SparseArray<com.ss.android.socialbase.downloader.model.DownloadInfo> sparseArray = new android.util.SparseArray<>();
        com.ss.android.socialbase.downloader.downloader.IDownloadProxy iDownloadProxy = com.ss.android.socialbase.downloader.impls.DownloadProxy.get(false);
        java.util.List<com.ss.android.socialbase.downloader.model.DownloadInfo> downloadingDownloadInfosWithMimeType = iDownloadProxy != null ? iDownloadProxy.getDownloadingDownloadInfosWithMimeType(str) : null;
        com.ss.android.socialbase.downloader.downloader.IDownloadProxy iDownloadProxy2 = com.ss.android.socialbase.downloader.impls.DownloadProxy.get(true);
        return handleDownloadInfos(downloadingDownloadInfosWithMimeType, iDownloadProxy2 != null ? iDownloadProxy2.getDownloadingDownloadInfosWithMimeType(str) : null, sparseArray);
    }

    public java.util.List<com.ss.android.socialbase.downloader.model.DownloadInfo> getFailedDownloadInfosWithMimeType(java.lang.String str) {
        android.util.SparseArray<com.ss.android.socialbase.downloader.model.DownloadInfo> sparseArray = new android.util.SparseArray<>();
        com.ss.android.socialbase.downloader.downloader.IDownloadProxy iDownloadProxy = com.ss.android.socialbase.downloader.impls.DownloadProxy.get(false);
        java.util.List<com.ss.android.socialbase.downloader.model.DownloadInfo> failedDownloadInfosWithMimeType = iDownloadProxy != null ? iDownloadProxy.getFailedDownloadInfosWithMimeType(str) : null;
        com.ss.android.socialbase.downloader.downloader.IDownloadProxy iDownloadProxy2 = com.ss.android.socialbase.downloader.impls.DownloadProxy.get(true);
        return handleDownloadInfos(failedDownloadInfosWithMimeType, iDownloadProxy2 != null ? iDownloadProxy2.getFailedDownloadInfosWithMimeType(str) : null, sparseArray);
    }

    public com.ss.android.socialbase.downloader.depend.INotificationClickCallback getNotificationClickCallback(int i) {
        com.ss.android.socialbase.downloader.downloader.IDownloadProxy downloadHandler = getDownloadHandler(i);
        if (downloadHandler == null) {
            return null;
        }
        return downloadHandler.getNotificationClickCallback(i);
    }

    public int getStatus(int i) {
        com.ss.android.socialbase.downloader.downloader.IDownloadProxy downloadHandler = getDownloadHandler(i);
        if (downloadHandler == null) {
            return 0;
        }
        return downloadHandler.getStatus(i);
    }

    public java.util.List<com.ss.android.socialbase.downloader.model.DownloadInfo> getSuccessedDownloadInfosWithMimeType(java.lang.String str) {
        android.util.SparseArray<com.ss.android.socialbase.downloader.model.DownloadInfo> sparseArray = new android.util.SparseArray<>();
        com.ss.android.socialbase.downloader.downloader.IDownloadProxy iDownloadProxy = com.ss.android.socialbase.downloader.impls.DownloadProxy.get(false);
        java.util.List<com.ss.android.socialbase.downloader.model.DownloadInfo> successedDownloadInfosWithMimeType = iDownloadProxy != null ? iDownloadProxy.getSuccessedDownloadInfosWithMimeType(str) : null;
        com.ss.android.socialbase.downloader.downloader.IDownloadProxy iDownloadProxy2 = com.ss.android.socialbase.downloader.impls.DownloadProxy.get(true);
        return handleDownloadInfos(successedDownloadInfosWithMimeType, iDownloadProxy2 != null ? iDownloadProxy2.getSuccessedDownloadInfosWithMimeType(str) : null, sparseArray);
    }

    public java.util.List<com.ss.android.socialbase.downloader.model.DownloadInfo> getUnCompletedDownloadInfosWithMimeType(java.lang.String str) {
        android.util.SparseArray<com.ss.android.socialbase.downloader.model.DownloadInfo> sparseArray = new android.util.SparseArray<>();
        com.ss.android.socialbase.downloader.downloader.IDownloadProxy iDownloadProxy = com.ss.android.socialbase.downloader.impls.DownloadProxy.get(false);
        java.util.List<com.ss.android.socialbase.downloader.model.DownloadInfo> unCompletedDownloadInfosWithMimeType = iDownloadProxy != null ? iDownloadProxy.getUnCompletedDownloadInfosWithMimeType(str) : null;
        com.ss.android.socialbase.downloader.downloader.IDownloadProxy iDownloadProxy2 = com.ss.android.socialbase.downloader.impls.DownloadProxy.get(true);
        return handleDownloadInfos(unCompletedDownloadInfosWithMimeType, iDownloadProxy2 != null ? iDownloadProxy2.getUnCompletedDownloadInfosWithMimeType(str) : null, sparseArray);
    }

    public boolean isDownloadCacheSyncSuccess() {
        com.ss.android.socialbase.downloader.downloader.IDownloadProxy iDownloadProxy = com.ss.android.socialbase.downloader.impls.DownloadProxy.get(false);
        if (iDownloadProxy != null) {
            return iDownloadProxy.isDownloadCacheSyncSuccess();
        }
        return false;
    }

    public boolean isDownloadSuccessAndFileNotExist(com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo) {
        com.ss.android.socialbase.downloader.downloader.IDownloadProxy downloadHandler;
        if (downloadInfo == null || (downloadHandler = getDownloadHandler(downloadInfo.getId())) == null) {
            return false;
        }
        return downloadHandler.isDownloadSuccessAndFileNotExist(downloadInfo);
    }

    public boolean isDownloading(int i) {
        com.ss.android.socialbase.downloader.downloader.IDownloadProxy downloadHandler = getDownloadHandler(i);
        if (downloadHandler == null) {
            return false;
        }
        return downloadHandler.isDownloading(i);
    }

    public boolean isHttpServiceInit() {
        return com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.isHttpServiceInit();
    }

    public void pause(int i) {
        com.ss.android.socialbase.downloader.downloader.IDownloadProxy downloadHandler = getDownloadHandler(i);
        if (downloadHandler == null) {
            return;
        }
        downloadHandler.pause(i);
    }

    public void pauseAll() {
        com.ss.android.socialbase.downloader.downloader.IDownloadProxy iDownloadProxy = com.ss.android.socialbase.downloader.impls.DownloadProxy.get(false);
        if (iDownloadProxy != null) {
            iDownloadProxy.pauseAll();
        }
        com.ss.android.socialbase.downloader.downloader.IDownloadProxy iDownloadProxy2 = com.ss.android.socialbase.downloader.impls.DownloadProxy.get(true);
        if (iDownloadProxy2 != null) {
            iDownloadProxy2.pauseAll();
        }
    }

    public void recordTaskProcessIndependent(int i) {
        if (i == 0) {
            return;
        }
        setDownloadIndependentProcessStatus(i, true);
        com.ss.android.socialbase.downloader.downloader.IDownloadProxy iDownloadProxy = com.ss.android.socialbase.downloader.impls.DownloadProxy.get(true);
        if (iDownloadProxy == null) {
            return;
        }
        iDownloadProxy.startService();
    }

    public void registerDownloadCacheSyncListener(com.ss.android.socialbase.downloader.depend.IDownloadCacheSyncStatusListener iDownloadCacheSyncStatusListener) {
        com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.registerDownloadCacheSyncListener(iDownloadCacheSyncStatusListener);
    }

    public void registerDownloaderProcessConnectedListener(com.ss.android.socialbase.downloader.depend.IDownloaderProcessConnectedListener iDownloaderProcessConnectedListener) {
        if (iDownloaderProcessConnectedListener == null) {
            return;
        }
        if (com.ss.android.socialbase.downloader.utils.DownloadUtils.isDownloaderProcess()) {
            iDownloaderProcessConnectedListener.onConnected();
            return;
        }
        if (com.ss.android.socialbase.downloader.impls.DownloadProxy.get(true).isServiceAlive()) {
            iDownloaderProcessConnectedListener.onConnected();
        }
        synchronized (this.processConnectedListeners) {
            if (!this.processConnectedListeners.contains(iDownloaderProcessConnectedListener)) {
                this.processConnectedListeners.add(iDownloaderProcessConnectedListener);
            }
        }
    }

    public void removeDownloadListener(int i, com.ss.android.socialbase.downloader.depend.IDownloadListener iDownloadListener, com.ss.android.socialbase.downloader.constants.ListenerType listenerType, boolean z) {
        com.ss.android.socialbase.downloader.downloader.IDownloadProxy downloadHandler = getDownloadHandler(i);
        if (downloadHandler == null) {
            return;
        }
        downloadHandler.removeDownloadListener(i, iDownloadListener == null ? 0 : iDownloadListener.hashCode(), iDownloadListener, listenerType, z);
    }

    public void restart(int i) {
        com.ss.android.socialbase.downloader.downloader.IDownloadProxy downloadHandler = getDownloadHandler(i);
        if (downloadHandler == null) {
            return;
        }
        downloadHandler.restart(i);
    }

    public void restartAllFailedDownloadTasks(java.util.List<java.lang.String> list) {
        com.ss.android.socialbase.downloader.downloader.IDownloadProxy iDownloadProxy = com.ss.android.socialbase.downloader.impls.DownloadProxy.get(false);
        if (iDownloadProxy != null) {
            iDownloadProxy.restartAllFailedDownloadTasks(list);
        }
        com.ss.android.socialbase.downloader.downloader.IDownloadProxy iDownloadProxy2 = com.ss.android.socialbase.downloader.impls.DownloadProxy.get(true);
        if (iDownloadProxy2 != null) {
            iDownloadProxy2.restartAllFailedDownloadTasks(list);
        }
    }

    public void restartAllPauseReserveOnWifiDownloadTasks(java.util.List<java.lang.String> list) {
        com.ss.android.socialbase.downloader.downloader.IDownloadProxy iDownloadProxy = com.ss.android.socialbase.downloader.impls.DownloadProxy.get(false);
        if (iDownloadProxy != null) {
            iDownloadProxy.restartAllPauseReserveOnWifiDownloadTasks(list);
        }
        com.ss.android.socialbase.downloader.downloader.IDownloadProxy iDownloadProxy2 = com.ss.android.socialbase.downloader.impls.DownloadProxy.get(true);
        if (iDownloadProxy2 != null) {
            iDownloadProxy2.restartAllPauseReserveOnWifiDownloadTasks(list);
        }
    }

    public void resume(int i) {
        com.ss.android.socialbase.downloader.downloader.IDownloadProxy downloadHandler = getDownloadHandler(i);
        if (downloadHandler == null) {
            return;
        }
        downloadHandler.resume(i);
    }

    public boolean retryDelayStart(int i) {
        com.ss.android.socialbase.downloader.downloader.IDownloadProxy downloadHandler = getDownloadHandler(i);
        if (downloadHandler == null) {
            return false;
        }
        return downloadHandler.retryDelayStart(i);
    }

    public synchronized void setDownloadIndependentProcessStatus(int i, boolean z) {
        this.independentMap.put(i, z ? java.lang.Boolean.TRUE : java.lang.Boolean.FALSE);
    }

    public void setDownloadNotificationEventListener(int i, com.ss.android.socialbase.downloader.depend.IDownloadNotificationEventListener iDownloadNotificationEventListener) {
        com.ss.android.socialbase.downloader.downloader.IDownloadProxy downloadHandler = getDownloadHandler(i);
        if (downloadHandler == null) {
            return;
        }
        downloadHandler.setDownloadNotificationEventListener(i, iDownloadNotificationEventListener);
    }

    public void setDownloadWithIndependentProcessStatus(int i, boolean z) {
        setDownloadIndependentProcessStatus(i, z);
        if (com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.supportMultiProc() && !com.ss.android.socialbase.downloader.utils.DownloadUtils.isDownloaderProcess() && com.ss.android.socialbase.downloader.impls.DownloadProxy.get(true).isServiceAlive()) {
            com.ss.android.socialbase.downloader.impls.DownloadProxy.get(true).setDownloadWithIndependentProcessStatus(i, z);
        }
        if (com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.isDownloadInMultiProcess() || com.ss.android.socialbase.downloader.utils.DownloadUtils.isDownloaderProcess() || com.ss.android.socialbase.downloader.utils.DownloadUtils.isMainProcess()) {
            return;
        }
        try {
            android.content.Intent intent = new android.content.Intent(com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.getAppContext(), (java.lang.Class<?>) com.ss.android.socialbase.downloader.impls.DownloadHandleService.class);
            intent.setAction(com.ss.android.socialbase.downloader.constants.DownloadConstants.ACTION_DOWNLOAD_PROCESS_NOTIFY);
            intent.putExtra(com.ss.android.socialbase.downloader.constants.DownloadConstants.EXTRA_DOWNLOAD_ID, i);
            com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.getAppContext().startService(intent);
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    public void setLogLevel(int i) {
        com.ss.android.socialbase.downloader.downloader.IDownloadProxy iDownloadProxy = com.ss.android.socialbase.downloader.impls.DownloadProxy.get(false);
        if (iDownloadProxy != null) {
            iDownloadProxy.setLogLevel(i);
        }
        com.ss.android.socialbase.downloader.downloader.IDownloadProxy iDownloadProxy2 = com.ss.android.socialbase.downloader.impls.DownloadProxy.get(true);
        if (iDownloadProxy2 != null) {
            iDownloadProxy2.setLogLevel(i);
        }
    }

    public void setThrottleNetSpeed(int i, long j) {
        com.ss.android.socialbase.downloader.downloader.IDownloadProxy downloadHandler = getDownloadHandler(i);
        if (downloadHandler == null) {
            return;
        }
        downloadHandler.setThrottleNetSpeed(i, j);
    }

    public void tryDownload(com.ss.android.socialbase.downloader.model.DownloadTask downloadTask) {
        com.ss.android.socialbase.downloader.downloader.IDownloadProxy downloadHandler = getDownloadHandler(downloadTask);
        if (downloadHandler == null) {
            if (downloadTask != null) {
                com.ss.android.socialbase.downloader.monitor.DownloadMonitorHelper.monitorSendWithTaskMonitor(downloadTask.getMonitorDepend(), downloadTask.getDownloadInfo(), new com.ss.android.socialbase.downloader.exception.BaseException(1003, "tryDownload but getDownloadHandler failed"), downloadTask.getDownloadInfo() != null ? downloadTask.getDownloadInfo().getStatus() : 0);
            }
        } else if (downloadTask.isNeedDelayForCacheSync()) {
            this.mainThreadHandler.postDelayed(new com.ss.android.socialbase.downloader.downloader.DownloadProcessDispatcher.AnonymousClass1(downloadHandler, downloadTask), 500L);
        } else {
            downloadHandler.tryDownload(downloadTask);
        }
    }

    public void unRegisterDownloadCacheSyncListener(com.ss.android.socialbase.downloader.depend.IDownloadCacheSyncStatusListener iDownloadCacheSyncStatusListener) {
        com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.unRegisterDownloadCacheSyncListener(iDownloadCacheSyncStatusListener);
    }

    public void unRegisterDownloaderProcessConnectedListener(com.ss.android.socialbase.downloader.depend.IDownloaderProcessConnectedListener iDownloaderProcessConnectedListener) {
        if (iDownloaderProcessConnectedListener == null) {
            return;
        }
        synchronized (this.processConnectedListeners) {
            if (this.processConnectedListeners.contains(iDownloaderProcessConnectedListener)) {
                this.processConnectedListeners.remove(iDownloaderProcessConnectedListener);
            }
        }
    }
}
