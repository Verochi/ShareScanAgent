package com.ss.android.socialbase.downloader.impls;

/* loaded from: classes19.dex */
public class IndependentProcessDownloadHandler implements com.ss.android.socialbase.downloader.downloader.IDownloadProxy, com.ss.android.socialbase.downloader.downloader.IDownloadServiceConnectionListener {
    private static final java.lang.String TAG = "IndependentProcessDownloadHandler";
    private volatile com.ss.android.socialbase.downloader.downloader.IDownloadAidlService aidlService;
    private com.ss.android.socialbase.downloader.downloader.IDownloadProxy downloadProxy = new com.ss.android.socialbase.downloader.impls.ProcessDownloadHandler();
    private com.ss.android.socialbase.downloader.downloader.IDownloadServiceHandler<com.ss.android.socialbase.downloader.downloader.IndependentProcessDownloadService> downloadServiceHandler;

    /* renamed from: com.ss.android.socialbase.downloader.impls.IndependentProcessDownloadHandler$1, reason: invalid class name */
    public class AnonymousClass1 implements com.ss.android.socialbase.downloader.depend.ProcessCallback {
        public AnonymousClass1() {
        }

        @Override // com.ss.android.socialbase.downloader.depend.ProcessCallback
        public void callback(int i, int i2) {
            if (i2 != 1) {
                if (i2 == 2) {
                    com.ss.android.socialbase.downloader.downloader.Downloader.getInstance(com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.getAppContext()).cancel(i);
                }
            } else {
                com.ss.android.socialbase.downloader.downloader.Downloader.getInstance(com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.getAppContext()).pause(i);
                java.util.List<com.ss.android.socialbase.downloader.model.DownloadChunk> downloadChunk = com.ss.android.socialbase.downloader.impls.DownloadProxy.get(false).getDownloadChunk(i);
                if (downloadChunk != null) {
                    com.ss.android.socialbase.downloader.impls.DownloadProxy.get(true).syncDownloadChunks(i, com.ss.android.socialbase.downloader.utils.DownloadUtils.parseHostChunkList(downloadChunk));
                }
            }
        }
    }

    public IndependentProcessDownloadHandler() {
        com.ss.android.socialbase.downloader.downloader.IDownloadServiceHandler<com.ss.android.socialbase.downloader.downloader.IndependentProcessDownloadService> independentDownloadServiceHandler = com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.getIndependentDownloadServiceHandler();
        this.downloadServiceHandler = independentDownloadServiceHandler;
        independentDownloadServiceHandler.setServiceConnectionListener(this);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public void addDownloadChunk(com.ss.android.socialbase.downloader.model.DownloadChunk downloadChunk) {
        if (this.aidlService == null) {
            this.downloadProxy.addDownloadChunk(downloadChunk);
            return;
        }
        try {
            this.aidlService.addDownloadChunk(downloadChunk);
        } catch (android.os.RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public void addDownloadListener(int i, int i2, com.ss.android.socialbase.downloader.depend.IDownloadListener iDownloadListener, com.ss.android.socialbase.downloader.constants.ListenerType listenerType, boolean z) {
        if (this.aidlService == null) {
            return;
        }
        try {
            this.aidlService.addDownloadListener(i, i2, com.ss.android.socialbase.downloader.utils.IPCUtils.convertListenerToAidl(iDownloadListener, listenerType != com.ss.android.socialbase.downloader.constants.ListenerType.SUB), listenerType.ordinal(), z);
        } catch (android.os.RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public void addDownloadListener(int i, int i2, com.ss.android.socialbase.downloader.depend.IDownloadListener iDownloadListener, com.ss.android.socialbase.downloader.constants.ListenerType listenerType, boolean z, boolean z2) {
        if (this.aidlService == null) {
            return;
        }
        try {
            this.aidlService.addDownloadListener1(i, i2, com.ss.android.socialbase.downloader.utils.IPCUtils.convertListenerToAidl(iDownloadListener, listenerType != com.ss.android.socialbase.downloader.constants.ListenerType.SUB), listenerType.ordinal(), z, z2);
        } catch (android.os.RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public void addProcessCallback(com.ss.android.socialbase.downloader.depend.ProcessCallback processCallback) {
        if (this.aidlService != null) {
            try {
                this.aidlService.addProcessCallback(com.ss.android.socialbase.downloader.utils.IPCUtils.convertProcessCallbackToAidl(processCallback));
            } catch (android.os.RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public boolean canResume(int i) {
        if (this.aidlService == null) {
            return false;
        }
        try {
            return this.aidlService.canResume(i);
        } catch (android.os.RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public void cancel(int i, boolean z) {
        if (this.aidlService == null) {
            return;
        }
        try {
            this.aidlService.cancel(i, z);
        } catch (android.os.RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public void clearData() {
        if (this.aidlService == null) {
            this.downloadProxy.clearData();
            return;
        }
        try {
            this.aidlService.clearData();
        } catch (android.os.RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public void clearDownloadData(int i, boolean z) {
        if (this.aidlService == null) {
            this.downloadProxy.clearDownloadData(i, z);
            return;
        }
        try {
            this.aidlService.clearDownloadData(i, z);
        } catch (android.os.RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public void dispatchProcessCallback(int i, int i2) {
        if (this.aidlService != null) {
            try {
                this.aidlService.dispatchProcessCallback(i, i2);
            } catch (android.os.RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public void forceDownloadIngoreRecommendSize(int i) {
        if (this.aidlService == null) {
            this.downloadProxy.forceDownloadIngoreRecommendSize(i);
            return;
        }
        try {
            this.aidlService.forceDownloadIngoreRecommendSize(i);
        } catch (android.os.RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public java.util.List<com.ss.android.socialbase.downloader.model.DownloadInfo> getAllDownloadInfo() {
        if (this.aidlService == null) {
            return this.downloadProxy.getAllDownloadInfo();
        }
        try {
            return this.aidlService.getAllDownloadInfo();
        } catch (android.os.RemoteException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public long getCurBytes(int i) {
        if (this.aidlService == null) {
            return 0L;
        }
        try {
            return this.aidlService.getCurBytes(i);
        } catch (android.os.RemoteException e) {
            e.printStackTrace();
            return 0L;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public java.util.List<com.ss.android.socialbase.downloader.model.DownloadChunk> getDownloadChunk(int i) {
        if (this.aidlService == null) {
            return this.downloadProxy.getDownloadChunk(i);
        }
        try {
            return this.aidlService.getDownloadChunk(i);
        } catch (android.os.RemoteException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public com.ss.android.socialbase.downloader.depend.IDownloadFileUriProvider getDownloadFileUriProvider(int i) {
        if (this.aidlService == null) {
            return null;
        }
        try {
            return com.ss.android.socialbase.downloader.utils.IPCUtils.convertFileProviderFromAidl(this.aidlService.getDownloadFileUriProvider(i));
        } catch (android.os.RemoteException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public int getDownloadId(java.lang.String str, java.lang.String str2) {
        return com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.getDownloadId(str, str2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public com.ss.android.socialbase.downloader.model.DownloadInfo getDownloadInfo(int i) {
        if (this.aidlService == null) {
            return this.downloadProxy.getDownloadInfo(i);
        }
        try {
            return this.aidlService.getDownloadInfo(i);
        } catch (android.os.RemoteException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public com.ss.android.socialbase.downloader.model.DownloadInfo getDownloadInfo(java.lang.String str, java.lang.String str2) {
        return getDownloadInfo(getDownloadId(str, str2));
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public java.util.List<com.ss.android.socialbase.downloader.model.DownloadInfo> getDownloadInfoList(java.lang.String str) {
        if (this.aidlService == null) {
            return this.downloadProxy.getDownloadInfoList(str);
        }
        try {
            return this.aidlService.getDownloadInfoList(str);
        } catch (android.os.RemoteException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public com.ss.android.socialbase.downloader.depend.IDownloadNotificationEventListener getDownloadNotificationEventListener(int i) {
        if (this.aidlService == null) {
            return null;
        }
        try {
            return com.ss.android.socialbase.downloader.utils.IPCUtils.convertDownloadNotificationEventListenerFromAidl(this.aidlService.getDownloadNotificationEventListener(i));
        } catch (android.os.RemoteException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public int getDownloadWithIndependentProcessStatus(int i) {
        if (this.aidlService == null) {
            return com.ss.android.socialbase.downloader.downloader.DownloadProcessDispatcher.getInstance().getDownloadWithIndependentProcessStatusInner(i);
        }
        try {
            return this.aidlService.getDownloadWithIndependentProcessStatus(i);
        } catch (android.os.RemoteException e) {
            e.printStackTrace();
            return -1;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public java.util.List<com.ss.android.socialbase.downloader.model.DownloadInfo> getDownloadingDownloadInfosWithMimeType(java.lang.String str) {
        if (this.aidlService == null) {
            return null;
        }
        try {
            return this.aidlService.getDownloadingDownloadInfosWithMimeType(str);
        } catch (android.os.RemoteException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public java.util.List<com.ss.android.socialbase.downloader.model.DownloadInfo> getFailedDownloadInfosWithMimeType(java.lang.String str) {
        if (this.aidlService == null) {
            return this.downloadProxy.getFailedDownloadInfosWithMimeType(str);
        }
        try {
            return this.aidlService.getFailedDownloadInfosWithMimeType(str);
        } catch (android.os.RemoteException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public com.ss.android.socialbase.downloader.depend.INotificationClickCallback getNotificationClickCallback(int i) {
        if (this.aidlService == null) {
            return null;
        }
        try {
            return com.ss.android.socialbase.downloader.utils.IPCUtils.convertNotificationClickCallbackFromAidl(this.aidlService.getNotificationClickCallback(i));
        } catch (android.os.RemoteException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public int getStatus(int i) {
        if (this.aidlService == null) {
            return 0;
        }
        try {
            return this.aidlService.getStatus(i);
        } catch (android.os.RemoteException e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public java.util.List<com.ss.android.socialbase.downloader.model.DownloadInfo> getSuccessedDownloadInfosWithMimeType(java.lang.String str) {
        if (this.aidlService == null) {
            return this.downloadProxy.getSuccessedDownloadInfosWithMimeType(str);
        }
        try {
            return this.aidlService.getSuccessedDownloadInfosWithMimeType(str);
        } catch (android.os.RemoteException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public java.util.List<com.ss.android.socialbase.downloader.model.DownloadInfo> getUnCompletedDownloadInfosWithMimeType(java.lang.String str) {
        if (this.aidlService == null) {
            return this.downloadProxy.getUnCompletedDownloadInfosWithMimeType(str);
        }
        try {
            return this.aidlService.getUnCompletedDownloadInfosWithMimeType(str);
        } catch (android.os.RemoteException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public boolean isDownloadCacheSyncSuccess() {
        if (this.aidlService == null) {
            return this.downloadProxy.isDownloadCacheSyncSuccess();
        }
        try {
            return this.aidlService.isDownloadCacheSyncSuccess();
        } catch (android.os.RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public boolean isDownloadSuccessAndFileNotExist(com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo) {
        if (this.aidlService == null) {
            return this.downloadProxy.isDownloadSuccessAndFileNotExist(downloadInfo);
        }
        try {
            this.aidlService.isDownloadSuccessAndFileNotExist(downloadInfo);
            return false;
        } catch (android.os.RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public boolean isDownloading(int i) {
        if (this.aidlService == null) {
            return false;
        }
        try {
            return this.aidlService.isDownloading(i);
        } catch (android.os.RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public boolean isHttpServiceInit() {
        return com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.isHttpServiceInit();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public boolean isServiceAlive() {
        return this.aidlService != null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public boolean isServiceForeground() {
        if (this.aidlService == null) {
            com.ss.android.socialbase.downloader.logger.Logger.w(TAG, "isServiceForeground, aidlService is null");
            return false;
        }
        com.ss.android.socialbase.downloader.logger.Logger.i(TAG, "aidlService.isServiceForeground");
        try {
            return this.aidlService.isServiceForeground();
        } catch (android.os.RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadServiceConnectionListener
    public void onServiceConnection(android.os.IBinder iBinder) {
        this.aidlService = com.ss.android.socialbase.downloader.downloader.IDownloadAidlService.Stub.asInterface(iBinder);
        if (com.ss.android.socialbase.downloader.utils.DownloadUtils.isMainProcess()) {
            addProcessCallback(new com.ss.android.socialbase.downloader.impls.IndependentProcessDownloadHandler.AnonymousClass1());
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadServiceConnectionListener
    public void onServiceDisConnection() {
        this.aidlService = null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public void pause(int i) {
        if (this.aidlService == null) {
            return;
        }
        try {
            this.aidlService.pause(i);
        } catch (android.os.RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public void pauseAll() {
        if (this.aidlService == null) {
            return;
        }
        try {
            this.aidlService.pauseAll();
        } catch (android.os.RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public void removeAllDownloadChunk(int i) {
        if (this.aidlService == null) {
            this.downloadProxy.removeAllDownloadChunk(i);
            return;
        }
        try {
            this.aidlService.removeAllDownloadChunk(i);
        } catch (android.os.RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public boolean removeDownloadInfo(int i) {
        if (this.aidlService == null) {
            return this.downloadProxy.removeDownloadInfo(i);
        }
        try {
            return this.aidlService.removeDownloadInfo(i);
        } catch (android.os.RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public void removeDownloadListener(int i, int i2, com.ss.android.socialbase.downloader.depend.IDownloadListener iDownloadListener, com.ss.android.socialbase.downloader.constants.ListenerType listenerType, boolean z) {
        if (this.aidlService == null) {
            return;
        }
        try {
            this.aidlService.removeDownloadListener(i, i2, com.ss.android.socialbase.downloader.utils.IPCUtils.convertListenerToAidl(iDownloadListener, listenerType != com.ss.android.socialbase.downloader.constants.ListenerType.SUB), listenerType.ordinal(), z);
        } catch (android.os.RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public boolean removeDownloadTaskData(int i) {
        if (this.aidlService == null) {
            return this.downloadProxy.removeDownloadTaskData(i);
        }
        try {
            return this.aidlService.removeDownloadTaskData(i);
        } catch (android.os.RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public void resetDownloadData(int i, boolean z) {
        if (this.aidlService == null) {
            this.downloadProxy.resetDownloadData(i, z);
            return;
        }
        try {
            this.aidlService.resetDownloadData(i, z);
        } catch (android.os.RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public void restart(int i) {
        if (this.aidlService == null) {
            return;
        }
        try {
            this.aidlService.restart(i);
        } catch (android.os.RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public void restartAllFailedDownloadTasks(java.util.List<java.lang.String> list) {
        if (this.aidlService == null) {
            this.downloadProxy.restartAllFailedDownloadTasks(list);
            return;
        }
        try {
            this.aidlService.restartAllFailedDownloadTasks(list);
        } catch (android.os.RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public void restartAllPauseReserveOnWifiDownloadTasks(java.util.List<java.lang.String> list) {
        if (this.aidlService == null) {
            this.downloadProxy.restartAllPauseReserveOnWifiDownloadTasks(list);
            return;
        }
        try {
            this.aidlService.restartAllPauseReserveOnWifiDownloadTasks(list);
        } catch (android.os.RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public void resume(int i) {
        if (this.aidlService == null) {
            return;
        }
        try {
            this.aidlService.resume(i);
        } catch (android.os.RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public boolean retryDelayStart(int i) {
        if (this.aidlService == null) {
            return false;
        }
        try {
            return this.aidlService.retryDelayStart(i);
        } catch (android.os.RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public void setDownloadNotificationEventListener(int i, com.ss.android.socialbase.downloader.depend.IDownloadNotificationEventListener iDownloadNotificationEventListener) {
        if (this.aidlService != null) {
            try {
                this.aidlService.setDownloadNotificationEventListener(i, com.ss.android.socialbase.downloader.utils.IPCUtils.convertDownloadNotificationEventListenerToAidl(iDownloadNotificationEventListener));
            } catch (android.os.RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public void setDownloadWithIndependentProcessStatus(int i, boolean z) {
        if (this.aidlService == null) {
            return;
        }
        try {
            this.aidlService.setDownloadWithIndependentProcessStatus(i, z);
        } catch (android.os.RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public void setLogLevel(int i) {
        com.ss.android.socialbase.downloader.downloader.IDownloadServiceHandler<com.ss.android.socialbase.downloader.downloader.IndependentProcessDownloadService> iDownloadServiceHandler = this.downloadServiceHandler;
        if (iDownloadServiceHandler != null) {
            iDownloadServiceHandler.setLogLevel(i);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public void setThrottleNetSpeed(int i, long j) {
        if (this.aidlService == null) {
            return;
        }
        try {
            this.aidlService.setThrottleNetSpeed(i, j);
        } catch (android.os.RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public void startForeground(int i, android.app.Notification notification) {
        if (this.aidlService == null) {
            com.ss.android.socialbase.downloader.logger.Logger.w(TAG, "startForeground, aidlService is null");
            return;
        }
        com.ss.android.socialbase.downloader.logger.Logger.i(TAG, "aidlService.startForeground, id = ".concat(java.lang.String.valueOf(i)));
        try {
            this.aidlService.startForeground(i, notification);
        } catch (android.os.RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public void startService() {
        com.ss.android.socialbase.downloader.downloader.IDownloadServiceHandler<com.ss.android.socialbase.downloader.downloader.IndependentProcessDownloadService> iDownloadServiceHandler = this.downloadServiceHandler;
        if (iDownloadServiceHandler != null) {
            iDownloadServiceHandler.startService();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public void stopForeground(boolean z, boolean z2) {
        if (this.aidlService == null) {
            com.ss.android.socialbase.downloader.logger.Logger.w(TAG, "stopForeground, aidlService is null");
            return;
        }
        com.ss.android.socialbase.downloader.logger.Logger.i(TAG, "aidlService.stopForeground");
        try {
            this.aidlService.stopForeground(z2);
        } catch (android.os.RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public void syncDownloadChunks(int i, java.util.List<com.ss.android.socialbase.downloader.model.DownloadChunk> list) {
        if (this.aidlService == null) {
            return;
        }
        try {
            this.aidlService.syncDownloadChunks(i, list);
        } catch (android.os.RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public void syncDownloadInfo(com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo) {
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public void syncDownloadInfoFromOtherCache(int i, java.util.List<com.ss.android.socialbase.downloader.model.DownloadChunk> list) {
        if (this.aidlService == null) {
            this.downloadProxy.syncDownloadInfoFromOtherCache(i, list);
            return;
        }
        try {
            this.aidlService.syncDownloadInfoFromOtherCache(i, list);
        } catch (android.os.RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public void tryDownload(com.ss.android.socialbase.downloader.model.DownloadTask downloadTask) {
        com.ss.android.socialbase.downloader.downloader.IDownloadServiceHandler<com.ss.android.socialbase.downloader.downloader.IndependentProcessDownloadService> iDownloadServiceHandler;
        if (downloadTask == null || (iDownloadServiceHandler = this.downloadServiceHandler) == null) {
            return;
        }
        iDownloadServiceHandler.tryDownload(downloadTask);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public void tryDownloadWithEngine(com.ss.android.socialbase.downloader.model.DownloadTask downloadTask) {
        com.ss.android.socialbase.downloader.downloader.IDownloadServiceHandler<com.ss.android.socialbase.downloader.downloader.IndependentProcessDownloadService> iDownloadServiceHandler;
        if (downloadTask == null || (iDownloadServiceHandler = this.downloadServiceHandler) == null) {
            return;
        }
        iDownloadServiceHandler.tryDownloadWithEngine(downloadTask);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public void updateDownloadChunk(int i, int i2, long j) {
        if (this.aidlService == null) {
            this.downloadProxy.updateDownloadChunk(i, i2, j);
            return;
        }
        try {
            this.aidlService.updateDownloadChunk(i, i2, j);
        } catch (android.os.RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public boolean updateDownloadInfo(com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo) {
        if (this.aidlService == null) {
            return this.downloadProxy.updateDownloadInfo(downloadInfo);
        }
        try {
            return this.aidlService.updateDownloadInfo(downloadInfo);
        } catch (android.os.RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public void updateSubDownloadChunk(int i, int i2, int i3, long j) {
        if (this.aidlService == null) {
            this.downloadProxy.updateSubDownloadChunk(i, i2, i3, j);
            return;
        }
        try {
            this.aidlService.updateSubDownloadChunk(i, i2, i3, j);
        } catch (android.os.RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public void updateSubDownloadChunkIndex(int i, int i2, int i3, int i4) {
        if (this.aidlService == null) {
            this.downloadProxy.updateSubDownloadChunkIndex(i, i2, i3, i4);
            return;
        }
        try {
            this.aidlService.updateSubDownloadChunkIndex(i, i2, i3, i4);
        } catch (android.os.RemoteException e) {
            e.printStackTrace();
        }
    }
}
