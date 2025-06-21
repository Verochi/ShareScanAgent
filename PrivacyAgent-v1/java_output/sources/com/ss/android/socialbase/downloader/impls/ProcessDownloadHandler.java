package com.ss.android.socialbase.downloader.impls;

/* loaded from: classes19.dex */
public class ProcessDownloadHandler implements com.ss.android.socialbase.downloader.downloader.IDownloadProxy {
    private final boolean bugFixServiceAlive;
    private final com.ss.android.socialbase.downloader.downloader.IDownloadCache downloadCache;
    private final com.ss.android.socialbase.downloader.impls.AbsDownloadEngine downloadEngine;
    private final com.ss.android.socialbase.downloader.downloader.IDownloadServiceHandler downloadServiceHandler;

    public ProcessDownloadHandler() {
        this(false);
    }

    public ProcessDownloadHandler(boolean z) {
        this.downloadEngine = com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.getDownloadEngine();
        this.downloadCache = com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.getDownloadCache();
        if (z) {
            this.downloadServiceHandler = com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.getIndependentDownloadServiceHandler();
        } else {
            this.downloadServiceHandler = com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.getDownloadServiceHandler();
        }
        this.bugFixServiceAlive = com.ss.android.socialbase.downloader.setting.DownloadSetting.obtainGlobal().optBugFix(com.ss.android.socialbase.downloader.setting.DownloadSettingKeys.BugFix.SERVICE_ALIVE, false);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public void addDownloadChunk(com.ss.android.socialbase.downloader.model.DownloadChunk downloadChunk) {
        this.downloadCache.addDownloadChunk(downloadChunk);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public void addDownloadListener(int i, int i2, com.ss.android.socialbase.downloader.depend.IDownloadListener iDownloadListener, com.ss.android.socialbase.downloader.constants.ListenerType listenerType, boolean z) {
        com.ss.android.socialbase.downloader.impls.AbsDownloadEngine absDownloadEngine = this.downloadEngine;
        if (absDownloadEngine != null) {
            absDownloadEngine.addDownloadListener(i, i2, iDownloadListener, listenerType, z);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public void addDownloadListener(int i, int i2, com.ss.android.socialbase.downloader.depend.IDownloadListener iDownloadListener, com.ss.android.socialbase.downloader.constants.ListenerType listenerType, boolean z, boolean z2) {
        com.ss.android.socialbase.downloader.impls.AbsDownloadEngine absDownloadEngine = this.downloadEngine;
        if (absDownloadEngine != null) {
            absDownloadEngine.addDownloadListener(i, i2, iDownloadListener, listenerType, z, z2);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public void addProcessCallback(com.ss.android.socialbase.downloader.depend.ProcessCallback processCallback) {
        com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.addProcessCallback(processCallback);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public boolean canResume(int i) {
        com.ss.android.socialbase.downloader.impls.AbsDownloadEngine absDownloadEngine = this.downloadEngine;
        if (absDownloadEngine != null) {
            return absDownloadEngine.isInDownloadTaskPool(i);
        }
        return false;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public void cancel(int i, boolean z) {
        com.ss.android.socialbase.downloader.impls.AbsDownloadEngine absDownloadEngine = this.downloadEngine;
        if (absDownloadEngine != null) {
            absDownloadEngine.cancel(i, z);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public void clearData() {
        this.downloadCache.clearData();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public void clearDownloadData(int i, boolean z) {
        com.ss.android.socialbase.downloader.impls.AbsDownloadEngine absDownloadEngine = this.downloadEngine;
        if (absDownloadEngine != null) {
            absDownloadEngine.clearDownloadData(i, z);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public void dispatchProcessCallback(int i, int i2) {
        if (com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.getProcessCallbacks() != null) {
            for (com.ss.android.socialbase.downloader.depend.ProcessCallback processCallback : com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.getProcessCallbacks()) {
                if (processCallback != null) {
                    processCallback.callback(i2, i);
                }
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public void forceDownloadIngoreRecommendSize(int i) {
        com.ss.android.socialbase.downloader.impls.AbsDownloadEngine absDownloadEngine = this.downloadEngine;
        if (absDownloadEngine != null) {
            absDownloadEngine.forceDownloadIgnoreRecommendSize(i);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public java.util.List<com.ss.android.socialbase.downloader.model.DownloadInfo> getAllDownloadInfo() {
        com.ss.android.socialbase.downloader.downloader.IDownloadCache iDownloadCache = this.downloadCache;
        if (iDownloadCache != null) {
            return iDownloadCache.getAllDownloadInfo();
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public long getCurBytes(int i) {
        com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo;
        com.ss.android.socialbase.downloader.downloader.IDownloadCache iDownloadCache = this.downloadCache;
        if (iDownloadCache == null || (downloadInfo = iDownloadCache.getDownloadInfo(i)) == null) {
            return 0L;
        }
        int chunkCount = downloadInfo.getChunkCount();
        if (chunkCount <= 1) {
            return downloadInfo.getCurBytes();
        }
        java.util.List<com.ss.android.socialbase.downloader.model.DownloadChunk> downloadChunk = this.downloadCache.getDownloadChunk(i);
        if (downloadChunk == null || downloadChunk.size() != chunkCount) {
            return 0L;
        }
        return com.ss.android.socialbase.downloader.utils.DownloadUtils.getTotalOffset(downloadChunk);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public java.util.List<com.ss.android.socialbase.downloader.model.DownloadChunk> getDownloadChunk(int i) {
        return this.downloadCache.getDownloadChunk(i);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public com.ss.android.socialbase.downloader.depend.IDownloadFileUriProvider getDownloadFileUriProvider(int i) {
        com.ss.android.socialbase.downloader.impls.AbsDownloadEngine absDownloadEngine = this.downloadEngine;
        if (absDownloadEngine != null) {
            return absDownloadEngine.getDownloadFileUriProvider(i);
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public int getDownloadId(java.lang.String str, java.lang.String str2) {
        return com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.getDownloadId(str, str2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public com.ss.android.socialbase.downloader.model.DownloadInfo getDownloadInfo(int i) {
        com.ss.android.socialbase.downloader.impls.AbsDownloadEngine absDownloadEngine = this.downloadEngine;
        if (absDownloadEngine != null) {
            return absDownloadEngine.getDownloadInfo(i);
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public com.ss.android.socialbase.downloader.model.DownloadInfo getDownloadInfo(java.lang.String str, java.lang.String str2) {
        return getDownloadInfo(com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.getDownloadId(str, str2));
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public java.util.List<com.ss.android.socialbase.downloader.model.DownloadInfo> getDownloadInfoList(java.lang.String str) {
        com.ss.android.socialbase.downloader.impls.AbsDownloadEngine absDownloadEngine = this.downloadEngine;
        if (absDownloadEngine != null) {
            return absDownloadEngine.getDownloadInfoList(str);
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public com.ss.android.socialbase.downloader.depend.IDownloadNotificationEventListener getDownloadNotificationEventListener(int i) {
        com.ss.android.socialbase.downloader.impls.AbsDownloadEngine absDownloadEngine = this.downloadEngine;
        if (absDownloadEngine != null) {
            return absDownloadEngine.getDownloadNotificationEventListener(i);
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public int getDownloadWithIndependentProcessStatus(int i) {
        return com.ss.android.socialbase.downloader.downloader.DownloadProcessDispatcher.getInstance().getDownloadWithIndependentProcessStatus(i);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public java.util.List<com.ss.android.socialbase.downloader.model.DownloadInfo> getDownloadingDownloadInfosWithMimeType(java.lang.String str) {
        com.ss.android.socialbase.downloader.impls.AbsDownloadEngine absDownloadEngine = this.downloadEngine;
        if (absDownloadEngine != null) {
            return absDownloadEngine.getDownloadingDownloadInfosWithMimeType(str);
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public java.util.List<com.ss.android.socialbase.downloader.model.DownloadInfo> getFailedDownloadInfosWithMimeType(java.lang.String str) {
        com.ss.android.socialbase.downloader.downloader.IDownloadCache iDownloadCache = this.downloadCache;
        if (iDownloadCache != null) {
            return iDownloadCache.getFailedDownloadInfosWithMimeType(str);
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public com.ss.android.socialbase.downloader.depend.INotificationClickCallback getNotificationClickCallback(int i) {
        com.ss.android.socialbase.downloader.impls.AbsDownloadEngine absDownloadEngine = this.downloadEngine;
        com.ss.android.socialbase.downloader.depend.INotificationClickCallback notificationClickCallback = absDownloadEngine != null ? absDownloadEngine.getNotificationClickCallback(i) : null;
        return notificationClickCallback == null ? com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.getNotificationClickCallback() : notificationClickCallback;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public int getStatus(int i) {
        com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo;
        com.ss.android.socialbase.downloader.impls.AbsDownloadEngine absDownloadEngine = this.downloadEngine;
        if (absDownloadEngine == null || (downloadInfo = absDownloadEngine.getDownloadInfo(i)) == null) {
            return 0;
        }
        return downloadInfo.getStatus();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public java.util.List<com.ss.android.socialbase.downloader.model.DownloadInfo> getSuccessedDownloadInfosWithMimeType(java.lang.String str) {
        com.ss.android.socialbase.downloader.downloader.IDownloadCache iDownloadCache = this.downloadCache;
        if (iDownloadCache != null) {
            return iDownloadCache.getSuccessedDownloadInfosWithMimeType(str);
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public java.util.List<com.ss.android.socialbase.downloader.model.DownloadInfo> getUnCompletedDownloadInfosWithMimeType(java.lang.String str) {
        com.ss.android.socialbase.downloader.downloader.IDownloadCache iDownloadCache = this.downloadCache;
        if (iDownloadCache != null) {
            return iDownloadCache.getUnCompletedDownloadInfosWithMimeType(str);
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public boolean isDownloadCacheSyncSuccess() {
        return this.downloadCache.isDownloadCacheSyncSuccess();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public boolean isDownloadSuccessAndFileNotExist(com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo) {
        if (downloadInfo == null) {
            return false;
        }
        boolean isDownloadSuccessAndFileNotExist = com.ss.android.socialbase.downloader.utils.DownloadUtils.isDownloadSuccessAndFileNotExist(downloadInfo.getStatus(), downloadInfo.getSavePath(), downloadInfo.getName());
        if (isDownloadSuccessAndFileNotExist) {
            if (com.ss.android.socialbase.downloader.utils.DownloadExpSwitchCode.isSwitchEnable(com.ss.android.socialbase.downloader.utils.DownloadExpSwitchCode.BACK_CLEAR_DATA)) {
                clearDownloadData(downloadInfo.getId(), true);
            } else {
                resetDownloadData(downloadInfo.getId(), true);
            }
        }
        return isDownloadSuccessAndFileNotExist;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public boolean isDownloading(int i) {
        com.ss.android.socialbase.downloader.impls.AbsDownloadEngine absDownloadEngine = this.downloadEngine;
        if (absDownloadEngine != null) {
            return absDownloadEngine.isDownloading(i);
        }
        return false;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public boolean isHttpServiceInit() {
        return com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.isHttpServiceInit();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public boolean isServiceAlive() {
        com.ss.android.socialbase.downloader.downloader.IDownloadServiceHandler iDownloadServiceHandler;
        return this.bugFixServiceAlive && (iDownloadServiceHandler = this.downloadServiceHandler) != null && iDownloadServiceHandler.isServiceAlive();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public boolean isServiceForeground() {
        com.ss.android.socialbase.downloader.downloader.IDownloadServiceHandler iDownloadServiceHandler = this.downloadServiceHandler;
        if (iDownloadServiceHandler != null) {
            return iDownloadServiceHandler.isServiceForeground();
        }
        return false;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public void pause(int i) {
        com.ss.android.socialbase.downloader.impls.AbsDownloadEngine absDownloadEngine = this.downloadEngine;
        if (absDownloadEngine != null) {
            absDownloadEngine.pause(i);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public void pauseAll() {
        com.ss.android.socialbase.downloader.impls.AbsDownloadEngine absDownloadEngine = this.downloadEngine;
        if (absDownloadEngine != null) {
            absDownloadEngine.shutDown();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public void removeAllDownloadChunk(int i) {
        this.downloadCache.removeAllDownloadChunk(i);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public boolean removeDownloadInfo(int i) {
        return this.downloadCache.removeDownloadInfo(i);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public void removeDownloadListener(int i, int i2, com.ss.android.socialbase.downloader.depend.IDownloadListener iDownloadListener, com.ss.android.socialbase.downloader.constants.ListenerType listenerType, boolean z) {
        com.ss.android.socialbase.downloader.impls.AbsDownloadEngine absDownloadEngine = this.downloadEngine;
        if (absDownloadEngine != null) {
            absDownloadEngine.removeDownloadListener(i, i2, iDownloadListener, listenerType, z);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public boolean removeDownloadTaskData(int i) {
        return this.downloadCache.removeDownloadTaskData(i);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public void resetDownloadData(int i, boolean z) {
        com.ss.android.socialbase.downloader.impls.AbsDownloadEngine absDownloadEngine = this.downloadEngine;
        if (absDownloadEngine != null) {
            absDownloadEngine.resetDownloadData(i, z);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public void restart(int i) {
        com.ss.android.socialbase.downloader.impls.AbsDownloadEngine absDownloadEngine = this.downloadEngine;
        if (absDownloadEngine != null) {
            absDownloadEngine.restart(i);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public void restartAllFailedDownloadTasks(java.util.List<java.lang.String> list) {
        com.ss.android.socialbase.downloader.impls.AbsDownloadEngine absDownloadEngine = this.downloadEngine;
        if (absDownloadEngine != null) {
            absDownloadEngine.restartAllFailedDownloadTasks(list);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public void restartAllPauseReserveOnWifiDownloadTasks(java.util.List<java.lang.String> list) {
        com.ss.android.socialbase.downloader.impls.AbsDownloadEngine absDownloadEngine = this.downloadEngine;
        if (absDownloadEngine != null) {
            absDownloadEngine.restartAllPauseReserveOnWifiDownloadTasks(list);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public void resume(int i) {
        com.ss.android.socialbase.downloader.impls.AbsDownloadEngine absDownloadEngine = this.downloadEngine;
        if (absDownloadEngine != null) {
            absDownloadEngine.resume(i);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public boolean retryDelayStart(int i) {
        com.ss.android.socialbase.downloader.impls.AbsDownloadEngine absDownloadEngine = this.downloadEngine;
        if (absDownloadEngine != null) {
            return absDownloadEngine.retryDelayStart(i);
        }
        return false;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public void setDownloadNotificationEventListener(int i, com.ss.android.socialbase.downloader.depend.IDownloadNotificationEventListener iDownloadNotificationEventListener) {
        com.ss.android.socialbase.downloader.impls.AbsDownloadEngine absDownloadEngine = this.downloadEngine;
        if (absDownloadEngine != null) {
            absDownloadEngine.setDownloadNotificationEventListener(i, iDownloadNotificationEventListener);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public void setDownloadWithIndependentProcessStatus(int i, boolean z) {
        com.ss.android.socialbase.downloader.downloader.DownloadProcessDispatcher.getInstance().setDownloadWithIndependentProcessStatus(i, z);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public void setLogLevel(int i) {
        com.ss.android.socialbase.downloader.logger.Logger.setLogLevel(i);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public void setThrottleNetSpeed(int i, long j) {
        com.ss.android.socialbase.downloader.impls.AbsDownloadEngine absDownloadEngine = this.downloadEngine;
        if (absDownloadEngine != null) {
            absDownloadEngine.setThrottleNetSpeed(i, j);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public void startForeground(int i, android.app.Notification notification) {
        com.ss.android.socialbase.downloader.downloader.IDownloadServiceHandler iDownloadServiceHandler = this.downloadServiceHandler;
        if (iDownloadServiceHandler != null) {
            iDownloadServiceHandler.startForeground(i, notification);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public void startService() {
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public void stopForeground(boolean z, boolean z2) {
        com.ss.android.socialbase.downloader.downloader.IDownloadServiceHandler iDownloadServiceHandler = this.downloadServiceHandler;
        if (iDownloadServiceHandler != null) {
            iDownloadServiceHandler.stopForeground(z2);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public void syncDownloadChunks(int i, java.util.List<com.ss.android.socialbase.downloader.model.DownloadChunk> list) {
        this.downloadCache.syncDownloadChunks(i, list);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public void syncDownloadInfo(com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo) {
        this.downloadCache.syncDownloadInfo(downloadInfo);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public void syncDownloadInfoFromOtherCache(int i, java.util.List<com.ss.android.socialbase.downloader.model.DownloadChunk> list) {
        this.downloadCache.syncDownloadInfoFromOtherCache(i, list);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public void tryDownload(com.ss.android.socialbase.downloader.model.DownloadTask downloadTask) {
        com.ss.android.socialbase.downloader.downloader.IDownloadServiceHandler iDownloadServiceHandler = this.downloadServiceHandler;
        if (iDownloadServiceHandler != null) {
            iDownloadServiceHandler.tryDownload(downloadTask);
        } else if (downloadTask != null) {
            com.ss.android.socialbase.downloader.monitor.DownloadMonitorHelper.monitorSendWithTaskMonitor(downloadTask.getMonitorDepend(), downloadTask.getDownloadInfo(), new com.ss.android.socialbase.downloader.exception.BaseException(1003, "downloadServiceHandler is null"), downloadTask.getDownloadInfo() != null ? downloadTask.getDownloadInfo().getStatus() : 0);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public void tryDownloadWithEngine(com.ss.android.socialbase.downloader.model.DownloadTask downloadTask) {
        com.ss.android.socialbase.downloader.downloader.IDownloadServiceHandler iDownloadServiceHandler = this.downloadServiceHandler;
        if (iDownloadServiceHandler != null) {
            iDownloadServiceHandler.tryDownloadWithEngine(downloadTask);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public void updateDownloadChunk(int i, int i2, long j) {
        this.downloadCache.updateDownloadChunk(i, i2, j);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public boolean updateDownloadInfo(com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo) {
        return this.downloadCache.updateDownloadInfo(downloadInfo);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public void updateSubDownloadChunk(int i, int i2, int i3, long j) {
        this.downloadCache.updateSubDownloadChunk(i, i2, i3, j);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public void updateSubDownloadChunkIndex(int i, int i2, int i3, int i4) {
        this.downloadCache.updateSubDownloadChunkIndex(i, i2, i3, i4);
    }
}
