package com.ss.android.socialbase.downloader.impls;

/* loaded from: classes19.dex */
public class IndependentDownloadBinder extends com.ss.android.socialbase.downloader.downloader.IDownloadAidlService.Stub {
    private static final java.lang.String TAG = "IndependentDownloadBinder";
    private final com.ss.android.socialbase.downloader.downloader.IDownloadProxy downloadProxy = new com.ss.android.socialbase.downloader.impls.ProcessDownloadHandler(true);

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
    public void addDownloadChunk(com.ss.android.socialbase.downloader.model.DownloadChunk downloadChunk) throws android.os.RemoteException {
        com.ss.android.socialbase.downloader.downloader.IDownloadProxy iDownloadProxy = this.downloadProxy;
        if (iDownloadProxy == null) {
            return;
        }
        iDownloadProxy.addDownloadChunk(downloadChunk);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
    public void addDownloadListener(int i, int i2, com.ss.android.socialbase.downloader.depend.IDownloadAidlListener iDownloadAidlListener, int i3, boolean z) throws android.os.RemoteException {
        com.ss.android.socialbase.downloader.downloader.IDownloadProxy iDownloadProxy = this.downloadProxy;
        if (iDownloadProxy == null) {
            return;
        }
        iDownloadProxy.addDownloadListener(i, i2, com.ss.android.socialbase.downloader.utils.IPCUtils.convertListenerFromAidl(iDownloadAidlListener), com.ss.android.socialbase.downloader.utils.DownloadUtils.convertListenerType(i3), z);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
    public void addDownloadListener1(int i, int i2, com.ss.android.socialbase.downloader.depend.IDownloadAidlListener iDownloadAidlListener, int i3, boolean z, boolean z2) throws android.os.RemoteException {
        com.ss.android.socialbase.downloader.downloader.IDownloadProxy iDownloadProxy = this.downloadProxy;
        if (iDownloadProxy == null) {
            return;
        }
        iDownloadProxy.addDownloadListener(i, i2, com.ss.android.socialbase.downloader.utils.IPCUtils.convertListenerFromAidl(iDownloadAidlListener), com.ss.android.socialbase.downloader.utils.DownloadUtils.convertListenerType(i3), z, z2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
    public void addProcessCallback(com.ss.android.socialbase.downloader.depend.ProcessAidlCallback processAidlCallback) throws android.os.RemoteException {
        com.ss.android.socialbase.downloader.downloader.IDownloadProxy iDownloadProxy = this.downloadProxy;
        if (iDownloadProxy == null) {
            return;
        }
        iDownloadProxy.addProcessCallback(com.ss.android.socialbase.downloader.utils.IPCUtils.convertProcessAidlCallbackFromAidl(processAidlCallback));
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
    public boolean canResume(int i) throws android.os.RemoteException {
        com.ss.android.socialbase.downloader.downloader.IDownloadProxy iDownloadProxy = this.downloadProxy;
        if (iDownloadProxy == null) {
            return false;
        }
        return iDownloadProxy.canResume(i);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
    public void cancel(int i, boolean z) throws android.os.RemoteException {
        com.ss.android.socialbase.downloader.downloader.IDownloadProxy iDownloadProxy = this.downloadProxy;
        if (iDownloadProxy == null) {
            return;
        }
        iDownloadProxy.cancel(i, z);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
    public void clearData() throws android.os.RemoteException {
        com.ss.android.socialbase.downloader.downloader.IDownloadProxy iDownloadProxy = this.downloadProxy;
        if (iDownloadProxy == null) {
            return;
        }
        iDownloadProxy.clearData();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
    public void clearDownloadData(int i, boolean z) throws android.os.RemoteException {
        com.ss.android.socialbase.downloader.downloader.IDownloadProxy iDownloadProxy = this.downloadProxy;
        if (iDownloadProxy == null) {
            return;
        }
        iDownloadProxy.clearDownloadData(i, z);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
    public void dispatchProcessCallback(int i, int i2) throws android.os.RemoteException {
        com.ss.android.socialbase.downloader.downloader.IDownloadProxy iDownloadProxy = this.downloadProxy;
        if (iDownloadProxy == null) {
            return;
        }
        iDownloadProxy.dispatchProcessCallback(i, i2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
    public void forceDownloadIngoreRecommendSize(int i) throws android.os.RemoteException {
        com.ss.android.socialbase.downloader.downloader.IDownloadProxy iDownloadProxy = this.downloadProxy;
        if (iDownloadProxy == null) {
            return;
        }
        iDownloadProxy.forceDownloadIngoreRecommendSize(i);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
    public java.util.List<com.ss.android.socialbase.downloader.model.DownloadInfo> getAllDownloadInfo() throws android.os.RemoteException {
        com.ss.android.socialbase.downloader.downloader.IDownloadProxy iDownloadProxy = this.downloadProxy;
        if (iDownloadProxy == null) {
            return null;
        }
        return iDownloadProxy.getAllDownloadInfo();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
    public long getCurBytes(int i) throws android.os.RemoteException {
        com.ss.android.socialbase.downloader.downloader.IDownloadProxy iDownloadProxy = this.downloadProxy;
        if (iDownloadProxy == null) {
            return 0L;
        }
        return iDownloadProxy.getCurBytes(i);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
    public java.util.List<com.ss.android.socialbase.downloader.model.DownloadChunk> getDownloadChunk(int i) throws android.os.RemoteException {
        com.ss.android.socialbase.downloader.downloader.IDownloadProxy iDownloadProxy = this.downloadProxy;
        if (iDownloadProxy == null) {
            return null;
        }
        return iDownloadProxy.getDownloadChunk(i);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
    public com.ss.android.socialbase.downloader.depend.IDownloadAidlFileProvider getDownloadFileUriProvider(int i) throws android.os.RemoteException {
        com.ss.android.socialbase.downloader.downloader.IDownloadProxy iDownloadProxy = this.downloadProxy;
        if (iDownloadProxy == null) {
            return null;
        }
        return com.ss.android.socialbase.downloader.utils.IPCUtils.convertFileProviderToAidl(iDownloadProxy.getDownloadFileUriProvider(i));
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
    public int getDownloadId(java.lang.String str, java.lang.String str2) throws android.os.RemoteException {
        com.ss.android.socialbase.downloader.downloader.IDownloadProxy iDownloadProxy = this.downloadProxy;
        if (iDownloadProxy == null) {
            return 0;
        }
        return iDownloadProxy.getDownloadId(str, str2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
    public com.ss.android.socialbase.downloader.model.DownloadInfo getDownloadInfo(int i) throws android.os.RemoteException {
        com.ss.android.socialbase.downloader.downloader.IDownloadProxy iDownloadProxy = this.downloadProxy;
        if (iDownloadProxy == null) {
            return null;
        }
        return iDownloadProxy.getDownloadInfo(i);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
    public com.ss.android.socialbase.downloader.model.DownloadInfo getDownloadInfoByUrlAndPath(java.lang.String str, java.lang.String str2) throws android.os.RemoteException {
        com.ss.android.socialbase.downloader.downloader.IDownloadProxy iDownloadProxy = this.downloadProxy;
        if (iDownloadProxy == null) {
            return null;
        }
        return iDownloadProxy.getDownloadInfo(str, str2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
    public java.util.List<com.ss.android.socialbase.downloader.model.DownloadInfo> getDownloadInfoList(java.lang.String str) throws android.os.RemoteException {
        com.ss.android.socialbase.downloader.downloader.IDownloadProxy iDownloadProxy = this.downloadProxy;
        if (iDownloadProxy == null) {
            return null;
        }
        return iDownloadProxy.getDownloadInfoList(str);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
    public com.ss.android.socialbase.downloader.depend.IDownloadNotificationEventAidlListener getDownloadNotificationEventListener(int i) throws android.os.RemoteException {
        com.ss.android.socialbase.downloader.downloader.IDownloadProxy iDownloadProxy = this.downloadProxy;
        if (iDownloadProxy == null) {
            return null;
        }
        return com.ss.android.socialbase.downloader.utils.IPCUtils.convertDownloadNotificationEventListenerToAidl(iDownloadProxy.getDownloadNotificationEventListener(i));
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
    public int getDownloadWithIndependentProcessStatus(int i) throws android.os.RemoteException {
        return com.ss.android.socialbase.downloader.downloader.DownloadProcessDispatcher.getInstance().getDownloadWithIndependentProcessStatusInner(i);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
    public java.util.List<com.ss.android.socialbase.downloader.model.DownloadInfo> getDownloadingDownloadInfosWithMimeType(java.lang.String str) throws android.os.RemoteException {
        com.ss.android.socialbase.downloader.downloader.IDownloadProxy iDownloadProxy = this.downloadProxy;
        if (iDownloadProxy == null) {
            return null;
        }
        return iDownloadProxy.getDownloadingDownloadInfosWithMimeType(str);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
    public java.util.List<com.ss.android.socialbase.downloader.model.DownloadInfo> getFailedDownloadInfosWithMimeType(java.lang.String str) throws android.os.RemoteException {
        com.ss.android.socialbase.downloader.downloader.IDownloadProxy iDownloadProxy = this.downloadProxy;
        if (iDownloadProxy == null) {
            return null;
        }
        return iDownloadProxy.getFailedDownloadInfosWithMimeType(str);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
    public com.ss.android.socialbase.downloader.depend.INotificationClickAidlCallback getNotificationClickCallback(int i) throws android.os.RemoteException {
        com.ss.android.socialbase.downloader.downloader.IDownloadProxy iDownloadProxy = this.downloadProxy;
        if (iDownloadProxy == null) {
            return null;
        }
        return com.ss.android.socialbase.downloader.utils.IPCUtils.convertNotificationClickCallbackToAidl(iDownloadProxy.getNotificationClickCallback(i));
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
    public int getStatus(int i) throws android.os.RemoteException {
        com.ss.android.socialbase.downloader.downloader.IDownloadProxy iDownloadProxy = this.downloadProxy;
        if (iDownloadProxy == null) {
            return 0;
        }
        return iDownloadProxy.getStatus(i);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
    public java.util.List<com.ss.android.socialbase.downloader.model.DownloadInfo> getSuccessedDownloadInfosWithMimeType(java.lang.String str) throws android.os.RemoteException {
        com.ss.android.socialbase.downloader.downloader.IDownloadProxy iDownloadProxy = this.downloadProxy;
        if (iDownloadProxy == null) {
            return null;
        }
        return iDownloadProxy.getSuccessedDownloadInfosWithMimeType(str);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
    public java.util.List<com.ss.android.socialbase.downloader.model.DownloadInfo> getUnCompletedDownloadInfosWithMimeType(java.lang.String str) throws android.os.RemoteException {
        com.ss.android.socialbase.downloader.downloader.IDownloadProxy iDownloadProxy = this.downloadProxy;
        if (iDownloadProxy == null) {
            return null;
        }
        return iDownloadProxy.getUnCompletedDownloadInfosWithMimeType(str);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
    public boolean isDownloadCacheSyncSuccess() throws android.os.RemoteException {
        com.ss.android.socialbase.downloader.downloader.IDownloadProxy iDownloadProxy = this.downloadProxy;
        if (iDownloadProxy == null) {
            return false;
        }
        return iDownloadProxy.isDownloadCacheSyncSuccess();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
    public boolean isDownloadSuccessAndFileNotExist(com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo) throws android.os.RemoteException {
        com.ss.android.socialbase.downloader.downloader.IDownloadProxy iDownloadProxy = this.downloadProxy;
        if (iDownloadProxy == null) {
            return false;
        }
        return iDownloadProxy.isDownloadSuccessAndFileNotExist(downloadInfo);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
    public boolean isDownloading(int i) throws android.os.RemoteException {
        com.ss.android.socialbase.downloader.downloader.IDownloadProxy iDownloadProxy = this.downloadProxy;
        if (iDownloadProxy == null) {
            return false;
        }
        return iDownloadProxy.isDownloading(i);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
    public boolean isHttpServiceInit() throws android.os.RemoteException {
        com.ss.android.socialbase.downloader.downloader.IDownloadProxy iDownloadProxy = this.downloadProxy;
        if (iDownloadProxy == null) {
            return false;
        }
        return iDownloadProxy.isHttpServiceInit();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
    public boolean isServiceForeground() throws android.os.RemoteException {
        com.ss.android.socialbase.downloader.downloader.IDownloadProxy iDownloadProxy = this.downloadProxy;
        if (iDownloadProxy == null) {
            return false;
        }
        return iDownloadProxy.isServiceForeground();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
    public void pause(int i) throws android.os.RemoteException {
        com.ss.android.socialbase.downloader.downloader.IDownloadProxy iDownloadProxy = this.downloadProxy;
        if (iDownloadProxy == null) {
            return;
        }
        iDownloadProxy.pause(i);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
    public void pauseAll() throws android.os.RemoteException {
        com.ss.android.socialbase.downloader.downloader.IDownloadProxy iDownloadProxy = this.downloadProxy;
        if (iDownloadProxy == null) {
            return;
        }
        iDownloadProxy.pauseAll();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
    public void removeAllDownloadChunk(int i) throws android.os.RemoteException {
        com.ss.android.socialbase.downloader.downloader.IDownloadProxy iDownloadProxy = this.downloadProxy;
        if (iDownloadProxy == null) {
            return;
        }
        iDownloadProxy.removeAllDownloadChunk(i);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
    public boolean removeDownloadInfo(int i) throws android.os.RemoteException {
        com.ss.android.socialbase.downloader.downloader.IDownloadProxy iDownloadProxy = this.downloadProxy;
        if (iDownloadProxy == null) {
            return false;
        }
        return iDownloadProxy.removeDownloadInfo(i);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
    public void removeDownloadListener(int i, int i2, com.ss.android.socialbase.downloader.depend.IDownloadAidlListener iDownloadAidlListener, int i3, boolean z) throws android.os.RemoteException {
        com.ss.android.socialbase.downloader.downloader.IDownloadProxy iDownloadProxy = this.downloadProxy;
        if (iDownloadProxy == null) {
            return;
        }
        iDownloadProxy.removeDownloadListener(i, i2, com.ss.android.socialbase.downloader.utils.IPCUtils.convertListenerFromAidl(iDownloadAidlListener), com.ss.android.socialbase.downloader.utils.DownloadUtils.convertListenerType(i3), z);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
    public boolean removeDownloadTaskData(int i) throws android.os.RemoteException {
        com.ss.android.socialbase.downloader.downloader.IDownloadProxy iDownloadProxy = this.downloadProxy;
        if (iDownloadProxy == null) {
            return false;
        }
        return iDownloadProxy.removeDownloadTaskData(i);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
    public void resetDownloadData(int i, boolean z) throws android.os.RemoteException {
        com.ss.android.socialbase.downloader.downloader.IDownloadProxy iDownloadProxy = this.downloadProxy;
        if (iDownloadProxy == null) {
            return;
        }
        iDownloadProxy.clearDownloadData(i, z);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
    public void restart(int i) throws android.os.RemoteException {
        com.ss.android.socialbase.downloader.downloader.IDownloadProxy iDownloadProxy = this.downloadProxy;
        if (iDownloadProxy == null) {
            return;
        }
        iDownloadProxy.restart(i);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
    public void restartAllFailedDownloadTasks(java.util.List<java.lang.String> list) throws android.os.RemoteException {
        com.ss.android.socialbase.downloader.downloader.IDownloadProxy iDownloadProxy = this.downloadProxy;
        if (iDownloadProxy == null) {
            return;
        }
        iDownloadProxy.restartAllFailedDownloadTasks(list);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
    public void restartAllPauseReserveOnWifiDownloadTasks(java.util.List<java.lang.String> list) throws android.os.RemoteException {
        com.ss.android.socialbase.downloader.downloader.IDownloadProxy iDownloadProxy = this.downloadProxy;
        if (iDownloadProxy != null) {
            iDownloadProxy.restartAllPauseReserveOnWifiDownloadTasks(list);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
    public void resume(int i) throws android.os.RemoteException {
        com.ss.android.socialbase.downloader.downloader.IDownloadProxy iDownloadProxy = this.downloadProxy;
        if (iDownloadProxy == null) {
            return;
        }
        iDownloadProxy.resume(i);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
    public boolean retryDelayStart(int i) throws android.os.RemoteException {
        com.ss.android.socialbase.downloader.downloader.IDownloadProxy iDownloadProxy = this.downloadProxy;
        if (iDownloadProxy == null) {
            return false;
        }
        return iDownloadProxy.retryDelayStart(i);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
    public void setDownloadNotificationEventListener(int i, com.ss.android.socialbase.downloader.depend.IDownloadNotificationEventAidlListener iDownloadNotificationEventAidlListener) throws android.os.RemoteException {
        com.ss.android.socialbase.downloader.downloader.IDownloadProxy iDownloadProxy = this.downloadProxy;
        if (iDownloadProxy == null) {
            return;
        }
        iDownloadProxy.setDownloadNotificationEventListener(i, com.ss.android.socialbase.downloader.utils.IPCUtils.convertDownloadNotificationEventListenerFromAidl(iDownloadNotificationEventAidlListener));
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
    public void setDownloadWithIndependentProcessStatus(int i, boolean z) throws android.os.RemoteException {
        com.ss.android.socialbase.downloader.downloader.DownloadProcessDispatcher.getInstance().setDownloadIndependentProcessStatus(i, z);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
    public void setLogLevel(int i) throws android.os.RemoteException {
        com.ss.android.socialbase.downloader.downloader.IDownloadProxy iDownloadProxy = this.downloadProxy;
        if (iDownloadProxy == null) {
            return;
        }
        iDownloadProxy.setLogLevel(i);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
    public void setThrottleNetSpeed(int i, long j) throws android.os.RemoteException {
        com.ss.android.socialbase.downloader.downloader.IDownloadProxy iDownloadProxy = this.downloadProxy;
        if (iDownloadProxy == null) {
            return;
        }
        iDownloadProxy.setThrottleNetSpeed(i, j);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
    public void startForeground(int i, android.app.Notification notification) throws android.os.RemoteException {
        com.ss.android.socialbase.downloader.downloader.IDownloadProxy iDownloadProxy = this.downloadProxy;
        if (iDownloadProxy == null) {
            return;
        }
        iDownloadProxy.startForeground(i, notification);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
    public void stopForeground(boolean z) throws android.os.RemoteException {
        com.ss.android.socialbase.downloader.downloader.IDownloadProxy iDownloadProxy = this.downloadProxy;
        if (iDownloadProxy == null) {
            return;
        }
        iDownloadProxy.stopForeground(true, z);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
    public void syncDownloadChunks(int i, java.util.List<com.ss.android.socialbase.downloader.model.DownloadChunk> list) throws android.os.RemoteException {
        com.ss.android.socialbase.downloader.downloader.IDownloadProxy iDownloadProxy = this.downloadProxy;
        if (iDownloadProxy == null) {
            return;
        }
        iDownloadProxy.syncDownloadChunks(i, list);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
    public void syncDownloadInfoFromOtherCache(int i, java.util.List<com.ss.android.socialbase.downloader.model.DownloadChunk> list) throws android.os.RemoteException {
        com.ss.android.socialbase.downloader.downloader.IDownloadProxy iDownloadProxy = this.downloadProxy;
        if (iDownloadProxy == null) {
            return;
        }
        iDownloadProxy.syncDownloadInfoFromOtherCache(i, list);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
    public void tryDownload(com.ss.android.socialbase.downloader.model.DownloadAidlTask downloadAidlTask) throws android.os.RemoteException {
        com.ss.android.socialbase.downloader.downloader.IDownloadProxy iDownloadProxy = this.downloadProxy;
        if (iDownloadProxy == null) {
            return;
        }
        iDownloadProxy.tryDownloadWithEngine(com.ss.android.socialbase.downloader.utils.IPCUtils.convertDownloadTaskFromAidl(downloadAidlTask));
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
    public void updateDownloadChunk(int i, int i2, long j) throws android.os.RemoteException {
        com.ss.android.socialbase.downloader.downloader.IDownloadProxy iDownloadProxy = this.downloadProxy;
        if (iDownloadProxy == null) {
            return;
        }
        iDownloadProxy.updateDownloadChunk(i, i2, j);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
    public boolean updateDownloadInfo(com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo) throws android.os.RemoteException {
        com.ss.android.socialbase.downloader.downloader.IDownloadProxy iDownloadProxy = this.downloadProxy;
        if (iDownloadProxy == null) {
            return false;
        }
        return iDownloadProxy.updateDownloadInfo(downloadInfo);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
    public void updateSubDownloadChunk(int i, int i2, int i3, long j) throws android.os.RemoteException {
        com.ss.android.socialbase.downloader.downloader.IDownloadProxy iDownloadProxy = this.downloadProxy;
        if (iDownloadProxy == null) {
            return;
        }
        iDownloadProxy.updateSubDownloadChunk(i, i2, i3, j);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
    public void updateSubDownloadChunkIndex(int i, int i2, int i3, int i4) throws android.os.RemoteException {
        com.ss.android.socialbase.downloader.downloader.IDownloadProxy iDownloadProxy = this.downloadProxy;
        if (iDownloadProxy == null) {
            return;
        }
        iDownloadProxy.updateSubDownloadChunkIndex(i, i2, i3, i4);
    }
}
