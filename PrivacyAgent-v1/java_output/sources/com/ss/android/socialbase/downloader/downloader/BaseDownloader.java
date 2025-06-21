package com.ss.android.socialbase.downloader.downloader;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes19.dex */
public class BaseDownloader {
    private java.lang.String globalDefaultSavePath;
    private java.lang.String globalDefaultSaveTempPath;

    private java.io.File getGlobalSaveDir(java.lang.String str, boolean z) {
        java.io.File file = null;
        if (android.text.TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            java.io.File file2 = new java.io.File(str);
            try {
                if (!file2.exists()) {
                    file2.mkdirs();
                } else if (!file2.isDirectory()) {
                    if (!z) {
                        return null;
                    }
                    file2.delete();
                    file2.mkdirs();
                }
                return file2;
            } catch (java.lang.Throwable unused) {
                file = file2;
                return file;
            }
        } catch (java.lang.Throwable unused2) {
        }
    }

    public static com.ss.android.socialbase.downloader.model.DownloadTask with(android.content.Context context) {
        com.ss.android.socialbase.downloader.downloader.Downloader.getInstance(context);
        return new com.ss.android.socialbase.downloader.model.DownloadTask();
    }

    public void addMainThreadListener(int i, com.ss.android.socialbase.downloader.depend.IDownloadListener iDownloadListener) {
        if (iDownloadListener == null) {
            return;
        }
        com.ss.android.socialbase.downloader.downloader.DownloadProcessDispatcher.getInstance().addDownloadListener(i, iDownloadListener, com.ss.android.socialbase.downloader.constants.ListenerType.MAIN, false);
    }

    public void addNotificationListener(int i, com.ss.android.socialbase.downloader.depend.IDownloadListener iDownloadListener) {
        if (iDownloadListener == null) {
            return;
        }
        com.ss.android.socialbase.downloader.downloader.DownloadProcessDispatcher.getInstance().addDownloadListener(i, iDownloadListener, com.ss.android.socialbase.downloader.constants.ListenerType.NOTIFICATION, false);
    }

    public void addSubThreadListener(int i, com.ss.android.socialbase.downloader.depend.IDownloadListener iDownloadListener) {
        if (iDownloadListener == null) {
            return;
        }
        com.ss.android.socialbase.downloader.downloader.DownloadProcessDispatcher.getInstance().addDownloadListener(i, iDownloadListener, com.ss.android.socialbase.downloader.constants.ListenerType.SUB, false);
    }

    public boolean canResume(int i) {
        return com.ss.android.socialbase.downloader.downloader.DownloadProcessDispatcher.getInstance().canResume(i);
    }

    public void cancel(int i) {
        cancel(i, true);
    }

    public void cancel(int i, boolean z) {
        com.ss.android.socialbase.downloader.downloader.DownloadProcessDispatcher.getInstance().cancel(i, z);
    }

    public void clearDownloadData(int i) {
        com.ss.android.socialbase.downloader.downloader.DownloadProcessDispatcher.getInstance().clearDownloadData(i, true);
    }

    public void clearDownloadData(int i, boolean z) {
        com.ss.android.socialbase.downloader.downloader.DownloadProcessDispatcher.getInstance().clearDownloadData(i, z);
    }

    public void destoryDownloader() {
        com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.unRegisterDownloadReceiver();
    }

    public void forceDownloadIngoreRecommendSize(int i) {
        com.ss.android.socialbase.downloader.downloader.DownloadProcessDispatcher.getInstance().forceDownloadIngoreRecommendSize(i);
    }

    public java.util.List<com.ss.android.socialbase.downloader.model.DownloadInfo> getAllDownloadInfo() {
        return com.ss.android.socialbase.downloader.downloader.DownloadProcessDispatcher.getInstance().getAllDownloadInfo();
    }

    public long getCurBytes(int i) {
        return com.ss.android.socialbase.downloader.downloader.DownloadProcessDispatcher.getInstance().getCurBytes(i);
    }

    public com.ss.android.socialbase.downloader.depend.IDownloadFileUriProvider getDownloadFileUriProvider(int i) {
        return com.ss.android.socialbase.downloader.downloader.DownloadProcessDispatcher.getInstance().getDownloadFileUriProvider(i);
    }

    public int getDownloadId(java.lang.String str, java.lang.String str2) {
        return com.ss.android.socialbase.downloader.downloader.DownloadProcessDispatcher.getInstance().getDownloadId(str, str2);
    }

    public com.ss.android.socialbase.downloader.model.DownloadInfo getDownloadInfo(int i) {
        return com.ss.android.socialbase.downloader.downloader.DownloadProcessDispatcher.getInstance().getDownloadInfo(i);
    }

    public com.ss.android.socialbase.downloader.model.DownloadInfo getDownloadInfo(java.lang.String str, java.lang.String str2) {
        return com.ss.android.socialbase.downloader.downloader.DownloadProcessDispatcher.getInstance().getDownloadInfo(str, str2);
    }

    public java.util.List<com.ss.android.socialbase.downloader.model.DownloadInfo> getDownloadInfoList(java.lang.String str) {
        return com.ss.android.socialbase.downloader.downloader.DownloadProcessDispatcher.getInstance().getDownloadInfoList(str);
    }

    public com.ss.android.socialbase.downloader.depend.IDownloadNotificationEventListener getDownloadNotificationEventListener(int i) {
        return com.ss.android.socialbase.downloader.downloader.DownloadProcessDispatcher.getInstance().getDownloadNotificationEventListener(i);
    }

    public java.util.List<com.ss.android.socialbase.downloader.model.DownloadInfo> getDownloadingDownloadInfosWithMimeType(java.lang.String str) {
        return com.ss.android.socialbase.downloader.downloader.DownloadProcessDispatcher.getInstance().getDownloadingDownloadInfosWithMimeType(str);
    }

    public java.util.List<com.ss.android.socialbase.downloader.model.DownloadInfo> getFailedDownloadInfosWithMimeType(java.lang.String str) {
        return com.ss.android.socialbase.downloader.downloader.DownloadProcessDispatcher.getInstance().getFailedDownloadInfosWithMimeType(str);
    }

    public java.io.File getGlobalSaveDir() {
        return getGlobalSaveDir(this.globalDefaultSavePath, true);
    }

    public java.io.File getGlobalSaveTempDir() {
        return getGlobalSaveDir(this.globalDefaultSaveTempPath, false);
    }

    public com.ss.android.socialbase.downloader.downloader.IReserveWifiStatusListener getReserveWifiStatusListener() {
        return com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.getReserveWifiStatusListener();
    }

    public int getStatus(int i) {
        return com.ss.android.socialbase.downloader.downloader.DownloadProcessDispatcher.getInstance().getStatus(i);
    }

    public java.util.List<com.ss.android.socialbase.downloader.model.DownloadInfo> getSuccessedDownloadInfosWithMimeType(java.lang.String str) {
        return com.ss.android.socialbase.downloader.downloader.DownloadProcessDispatcher.getInstance().getSuccessedDownloadInfosWithMimeType(str);
    }

    public java.util.List<com.ss.android.socialbase.downloader.model.DownloadInfo> getUnCompletedDownloadInfosWithMimeType(java.lang.String str) {
        return com.ss.android.socialbase.downloader.downloader.DownloadProcessDispatcher.getInstance().getUnCompletedDownloadInfosWithMimeType(str);
    }

    public boolean isDownloadCacheSyncSuccess() {
        return com.ss.android.socialbase.downloader.downloader.DownloadProcessDispatcher.getInstance().isDownloadCacheSyncSuccess();
    }

    public boolean isDownloadServiceForeground(int i) {
        return com.ss.android.socialbase.downloader.downloader.DownloadProcessDispatcher.getInstance().getDownloadHandler(i).isServiceForeground();
    }

    public boolean isDownloadSuccessAndFileNotExist(com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo) {
        return com.ss.android.socialbase.downloader.downloader.DownloadProcessDispatcher.getInstance().isDownloadSuccessAndFileNotExist(downloadInfo);
    }

    public boolean isDownloading(int i) {
        boolean isDownloading;
        if (!com.ss.android.socialbase.downloader.utils.DownloadExpSwitchCode.isSwitchEnable(4194304)) {
            return com.ss.android.socialbase.downloader.downloader.DownloadProcessDispatcher.getInstance().isDownloading(i);
        }
        synchronized (this) {
            isDownloading = com.ss.android.socialbase.downloader.downloader.DownloadProcessDispatcher.getInstance().isDownloading(i);
        }
        return isDownloading;
    }

    public boolean isHttpServiceInit() {
        return com.ss.android.socialbase.downloader.downloader.DownloadProcessDispatcher.getInstance().isHttpServiceInit();
    }

    public void pause(int i) {
        com.ss.android.socialbase.downloader.downloader.DownloadProcessDispatcher.getInstance().pause(i);
    }

    public void pauseAll() {
        com.ss.android.socialbase.downloader.downloader.DownloadProcessDispatcher.getInstance().pauseAll();
    }

    public void registerDownloadCacheSyncListener(com.ss.android.socialbase.downloader.depend.IDownloadCacheSyncStatusListener iDownloadCacheSyncStatusListener) {
        com.ss.android.socialbase.downloader.downloader.DownloadProcessDispatcher.getInstance().registerDownloadCacheSyncListener(iDownloadCacheSyncStatusListener);
    }

    public void registerDownloaderProcessConnectedListener(com.ss.android.socialbase.downloader.depend.IDownloaderProcessConnectedListener iDownloaderProcessConnectedListener) {
        com.ss.android.socialbase.downloader.downloader.DownloadProcessDispatcher.getInstance().registerDownloaderProcessConnectedListener(iDownloaderProcessConnectedListener);
    }

    public void removeMainThreadListener(int i, com.ss.android.socialbase.downloader.depend.IDownloadListener iDownloadListener) {
        if (iDownloadListener == null) {
            return;
        }
        com.ss.android.socialbase.downloader.downloader.DownloadProcessDispatcher.getInstance().removeDownloadListener(i, iDownloadListener, com.ss.android.socialbase.downloader.constants.ListenerType.MAIN, false);
    }

    public void removeNotificationListener(int i, com.ss.android.socialbase.downloader.depend.IDownloadListener iDownloadListener) {
        if (iDownloadListener == null) {
            return;
        }
        com.ss.android.socialbase.downloader.downloader.DownloadProcessDispatcher.getInstance().removeDownloadListener(i, iDownloadListener, com.ss.android.socialbase.downloader.constants.ListenerType.NOTIFICATION, false);
    }

    public void removeSubThreadListener(int i, com.ss.android.socialbase.downloader.depend.IDownloadListener iDownloadListener) {
        if (iDownloadListener == null) {
            return;
        }
        com.ss.android.socialbase.downloader.downloader.DownloadProcessDispatcher.getInstance().removeDownloadListener(i, iDownloadListener, com.ss.android.socialbase.downloader.constants.ListenerType.SUB, false);
    }

    @java.lang.Deprecated
    public void removeTaskMainListener(int i) {
        com.ss.android.socialbase.downloader.downloader.DownloadProcessDispatcher.getInstance().removeDownloadListener(i, null, com.ss.android.socialbase.downloader.constants.ListenerType.MAIN, true);
    }

    @java.lang.Deprecated
    public void removeTaskNotificationListener(int i) {
        com.ss.android.socialbase.downloader.downloader.DownloadProcessDispatcher.getInstance().removeDownloadListener(i, null, com.ss.android.socialbase.downloader.constants.ListenerType.NOTIFICATION, true);
    }

    @java.lang.Deprecated
    public void removeTaskSubListener(int i) {
        com.ss.android.socialbase.downloader.downloader.DownloadProcessDispatcher.getInstance().removeDownloadListener(i, null, com.ss.android.socialbase.downloader.constants.ListenerType.SUB, true);
    }

    public void restart(int i) {
        com.ss.android.socialbase.downloader.downloader.DownloadProcessDispatcher.getInstance().restart(i);
    }

    public void restartAllFailedDownloadTasks(java.util.List<java.lang.String> list) {
        com.ss.android.socialbase.downloader.downloader.DownloadProcessDispatcher.getInstance().restartAllFailedDownloadTasks(list);
    }

    public void restartAllPauseReserveOnWifiDownloadTasks(java.util.List<java.lang.String> list) {
        com.ss.android.socialbase.downloader.downloader.DownloadProcessDispatcher.getInstance().restartAllPauseReserveOnWifiDownloadTasks(list);
    }

    public void resume(int i) {
        com.ss.android.socialbase.downloader.downloader.DownloadProcessDispatcher.getInstance().resume(i);
    }

    public void setDefaultSavePath(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return;
        }
        this.globalDefaultSavePath = str;
    }

    public void setDefaultSaveTempPath(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return;
        }
        this.globalDefaultSaveTempPath = str;
    }

    public void setDownloadInMultiProcess() {
        if (!com.ss.android.socialbase.downloader.utils.DownloadExpSwitchCode.isSwitchEnable(4194304)) {
            com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.setDownloadInMultiProcess();
        } else {
            synchronized (this) {
                com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.setDownloadInMultiProcess();
            }
        }
    }

    public void setDownloadNotificationEventListener(int i, com.ss.android.socialbase.downloader.depend.IDownloadNotificationEventListener iDownloadNotificationEventListener) {
        com.ss.android.socialbase.downloader.downloader.DownloadProcessDispatcher.getInstance().setDownloadNotificationEventListener(i, iDownloadNotificationEventListener);
    }

    public void setLogLevel(int i) {
        com.ss.android.socialbase.downloader.downloader.DownloadProcessDispatcher.getInstance().setLogLevel(i);
    }

    @java.lang.Deprecated
    public void setMainThreadListener(int i, com.ss.android.socialbase.downloader.depend.IDownloadListener iDownloadListener) {
        if (iDownloadListener == null) {
            return;
        }
        com.ss.android.socialbase.downloader.downloader.DownloadProcessDispatcher.getInstance().addDownloadListener(i, iDownloadListener, com.ss.android.socialbase.downloader.constants.ListenerType.MAIN, true);
    }

    @java.lang.Deprecated
    public void setMainThreadListener(int i, com.ss.android.socialbase.downloader.depend.IDownloadListener iDownloadListener, boolean z) {
        if (iDownloadListener == null) {
            return;
        }
        com.ss.android.socialbase.downloader.downloader.DownloadProcessDispatcher.getInstance().addDownloadListener(i, iDownloadListener, com.ss.android.socialbase.downloader.constants.ListenerType.MAIN, true, z);
    }

    @java.lang.Deprecated
    public void setNotificationListener(int i, com.ss.android.socialbase.downloader.depend.IDownloadListener iDownloadListener) {
        if (iDownloadListener == null) {
            return;
        }
        com.ss.android.socialbase.downloader.downloader.DownloadProcessDispatcher.getInstance().addDownloadListener(i, iDownloadListener, com.ss.android.socialbase.downloader.constants.ListenerType.NOTIFICATION, true);
    }

    public void setReserveWifiStatusListener(com.ss.android.socialbase.downloader.downloader.IReserveWifiStatusListener iReserveWifiStatusListener) {
        com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.setReserveWifiStatusListener(iReserveWifiStatusListener);
    }

    @java.lang.Deprecated
    public void setSubThreadListener(int i, com.ss.android.socialbase.downloader.depend.IDownloadListener iDownloadListener) {
        if (iDownloadListener == null) {
            return;
        }
        com.ss.android.socialbase.downloader.downloader.DownloadProcessDispatcher.getInstance().addDownloadListener(i, iDownloadListener, com.ss.android.socialbase.downloader.constants.ListenerType.SUB, true);
    }

    public void setThrottleNetSpeed(int i, long j) {
        com.ss.android.socialbase.downloader.downloader.DownloadProcessDispatcher.getInstance().setThrottleNetSpeed(i, j);
    }

    public void unRegisterDownloadCacheSyncListener(com.ss.android.socialbase.downloader.depend.IDownloadCacheSyncStatusListener iDownloadCacheSyncStatusListener) {
        com.ss.android.socialbase.downloader.downloader.DownloadProcessDispatcher.getInstance().unRegisterDownloadCacheSyncListener(iDownloadCacheSyncStatusListener);
    }

    public void unRegisterDownloaderProcessConnectedListener(com.ss.android.socialbase.downloader.depend.IDownloaderProcessConnectedListener iDownloaderProcessConnectedListener) {
        com.ss.android.socialbase.downloader.downloader.DownloadProcessDispatcher.getInstance().unRegisterDownloaderProcessConnectedListener(iDownloaderProcessConnectedListener);
    }
}
