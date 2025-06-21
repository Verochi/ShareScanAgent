package com.ss.android.socialbase.downloader.impls;

/* loaded from: classes19.dex */
public class IndependentDownloadServiceHandler extends com.ss.android.socialbase.downloader.downloader.AbsDownloadServiceHandler implements android.content.ServiceConnection {
    private static final java.lang.String TAG = "IndependentDownloadServiceHandler";
    private com.ss.android.socialbase.downloader.downloader.IDownloadAidlService aidlService;
    private com.ss.android.socialbase.downloader.downloader.IDownloadServiceConnectionListener connectionListener;
    private int logLevel = -1;

    private void resumePendingTaskForIndependent() {
        android.util.SparseArray<java.util.List<com.ss.android.socialbase.downloader.model.DownloadTask>> clone;
        try {
            synchronized (this.pendingTasks) {
                clone = this.pendingTasks.clone();
                this.pendingTasks.clear();
            }
            if (clone == null || clone.size() <= 0 || com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.getDownloadEngine() == null) {
                return;
            }
            for (int i = 0; i < clone.size(); i++) {
                java.util.List<com.ss.android.socialbase.downloader.model.DownloadTask> list = clone.get(clone.keyAt(i));
                if (list != null) {
                    java.util.Iterator<com.ss.android.socialbase.downloader.model.DownloadTask> it = list.iterator();
                    while (it.hasNext()) {
                        try {
                            this.aidlService.tryDownload(com.ss.android.socialbase.downloader.utils.IPCUtils.convertDownloadTaskToAidl(it.next()));
                        } catch (android.os.RemoteException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        } catch (java.lang.Throwable th) {
            com.ss.android.socialbase.downloader.logger.Logger.e(TAG, "resumePendingTaskForIndependent failed", th);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.AbsDownloadServiceHandler, com.ss.android.socialbase.downloader.downloader.IDownloadServiceHandler
    public android.os.IBinder onBind(android.content.Intent intent) {
        if (intent != null && intent.getBooleanExtra(com.ss.android.socialbase.downloader.constants.DownloadConstants.KEY_FIX_DOWNLOADER_DB_SIGBUS, false)) {
            com.ss.android.socialbase.downloader.setting.DownloadSetting.setGlobalBugFix(com.ss.android.socialbase.downloader.setting.DownloadSettingKeys.BugFix.BUGFIX_SIGBUS_DOWNLOADER_DB, true);
        }
        com.ss.android.socialbase.downloader.logger.Logger.d(TAG, "onBind IndependentDownloadBinder");
        return new com.ss.android.socialbase.downloader.impls.IndependentDownloadBinder();
    }

    @Override // android.content.ServiceConnection
    public void onBindingDied(android.content.ComponentName componentName) {
        this.aidlService = null;
        com.ss.android.socialbase.downloader.downloader.IDownloadServiceConnectionListener iDownloadServiceConnectionListener = this.connectionListener;
        if (iDownloadServiceConnectionListener != null) {
            iDownloadServiceConnectionListener.onServiceDisConnection();
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(android.content.ComponentName componentName, android.os.IBinder iBinder) {
        java.lang.String str = TAG;
        com.ss.android.socialbase.downloader.logger.Logger.d(str, "onServiceConnected ");
        this.aidlService = com.ss.android.socialbase.downloader.downloader.IDownloadAidlService.Stub.asInterface(iBinder);
        com.ss.android.socialbase.downloader.downloader.IDownloadServiceConnectionListener iDownloadServiceConnectionListener = this.connectionListener;
        if (iDownloadServiceConnectionListener != null) {
            iDownloadServiceConnectionListener.onServiceConnection(iBinder);
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder("onServiceConnected aidlService!=null");
        sb.append(this.aidlService != null);
        sb.append(" pendingTasks.size:");
        sb.append(this.pendingTasks.size());
        com.ss.android.socialbase.downloader.logger.Logger.d(str, sb.toString());
        if (this.aidlService != null) {
            com.ss.android.socialbase.downloader.downloader.DownloadProcessDispatcher.getInstance().dispatchDownloaderProcessConnectedEvent();
            this.isServiceAlive = true;
            this.isInvokeStartService = false;
            int i = this.logLevel;
            if (i != -1) {
                try {
                    this.aidlService.setLogLevel(i);
                } catch (android.os.RemoteException e) {
                    e.printStackTrace();
                }
            }
            if (this.aidlService != null) {
                resumePendingTaskForIndependent();
            }
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(android.content.ComponentName componentName) {
        com.ss.android.socialbase.downloader.logger.Logger.d(TAG, "onServiceDisconnected ");
        this.aidlService = null;
        this.isServiceAlive = false;
        com.ss.android.socialbase.downloader.downloader.IDownloadServiceConnectionListener iDownloadServiceConnectionListener = this.connectionListener;
        if (iDownloadServiceConnectionListener != null) {
            iDownloadServiceConnectionListener.onServiceDisConnection();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.AbsDownloadServiceHandler, com.ss.android.socialbase.downloader.downloader.IDownloadServiceHandler
    public void setLogLevel(int i) {
        com.ss.android.socialbase.downloader.downloader.IDownloadAidlService iDownloadAidlService = this.aidlService;
        if (iDownloadAidlService == null) {
            this.logLevel = i;
            return;
        }
        try {
            iDownloadAidlService.setLogLevel(i);
        } catch (android.os.RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.AbsDownloadServiceHandler, com.ss.android.socialbase.downloader.downloader.IDownloadServiceHandler
    public void setServiceConnectionListener(com.ss.android.socialbase.downloader.downloader.IDownloadServiceConnectionListener iDownloadServiceConnectionListener) {
        this.connectionListener = iDownloadServiceConnectionListener;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.AbsDownloadServiceHandler, com.ss.android.socialbase.downloader.downloader.IDownloadServiceHandler
    public void startService() {
        if (this.aidlService == null) {
            startService(com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.getAppContext(), this);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.AbsDownloadServiceHandler
    public void startService(android.content.Context context, android.content.ServiceConnection serviceConnection) {
        try {
            com.ss.android.socialbase.downloader.logger.Logger.d(TAG, "bindService");
            android.content.Intent intent = new android.content.Intent(context, (java.lang.Class<?>) com.ss.android.socialbase.downloader.downloader.IndependentProcessDownloadService.class);
            if (com.ss.android.socialbase.downloader.utils.DownloadUtils.isMainProcess()) {
                intent.putExtra(com.ss.android.socialbase.downloader.constants.DownloadConstants.KEY_FIX_DOWNLOADER_DB_SIGBUS, com.ss.android.socialbase.downloader.setting.DownloadSetting.obtainGlobal().optBugFix(com.ss.android.socialbase.downloader.setting.DownloadSettingKeys.BugFix.BUGFIX_SIGBUS_DOWNLOADER_DB));
            }
            if (serviceConnection != null) {
                context.bindService(intent, serviceConnection, 1);
            }
            context.startService(intent);
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.AbsDownloadServiceHandler
    public void stopService(android.content.Context context, android.content.ServiceConnection serviceConnection) {
        com.ss.android.socialbase.downloader.logger.Logger.d(TAG, "stopService");
        this.isServiceAlive = false;
        android.content.Intent intent = new android.content.Intent(context, (java.lang.Class<?>) com.ss.android.socialbase.downloader.downloader.IndependentProcessDownloadService.class);
        if (serviceConnection != null) {
            context.unbindService(serviceConnection);
        }
        context.stopService(intent);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.AbsDownloadServiceHandler, com.ss.android.socialbase.downloader.downloader.IDownloadServiceHandler
    public void tryDownload(com.ss.android.socialbase.downloader.model.DownloadTask downloadTask) {
        if (downloadTask == null) {
            return;
        }
        java.lang.String str = TAG;
        java.lang.StringBuilder sb = new java.lang.StringBuilder("tryDownload aidlService == null:");
        sb.append(this.aidlService == null);
        com.ss.android.socialbase.downloader.logger.Logger.d(str, sb.toString());
        if (this.aidlService == null) {
            pendDownloadTask(downloadTask);
            startService(com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.getAppContext(), this);
            return;
        }
        resumePendingTaskForIndependent();
        try {
            this.aidlService.tryDownload(com.ss.android.socialbase.downloader.utils.IPCUtils.convertDownloadTaskToAidl(downloadTask));
        } catch (android.os.RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.AbsDownloadServiceHandler, com.ss.android.socialbase.downloader.downloader.IDownloadServiceHandler
    public void tryDownloadWithEngine(com.ss.android.socialbase.downloader.model.DownloadTask downloadTask) {
        if (downloadTask == null) {
            return;
        }
        com.ss.android.socialbase.downloader.downloader.DownloadProcessDispatcher.getInstance().setDownloadWithIndependentProcessStatus(downloadTask.getDownloadId(), true);
        com.ss.android.socialbase.downloader.impls.AbsDownloadEngine downloadEngine = com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.getDownloadEngine();
        if (downloadEngine != null) {
            downloadEngine.tryDownload(downloadTask);
        }
    }
}
