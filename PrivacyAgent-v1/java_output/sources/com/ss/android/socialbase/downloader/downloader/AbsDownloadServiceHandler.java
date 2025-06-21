package com.ss.android.socialbase.downloader.downloader;

/* loaded from: classes19.dex */
public abstract class AbsDownloadServiceHandler implements com.ss.android.socialbase.downloader.downloader.IDownloadServiceHandler {
    private static final java.lang.String TAG = "AbsDownloadServiceHandler";
    private java.lang.ref.WeakReference<android.app.Service> downloadService;
    protected volatile boolean isServiceForeground;
    protected final android.util.SparseArray<java.util.List<com.ss.android.socialbase.downloader.model.DownloadTask>> pendingTasks = new android.util.SparseArray<>();
    protected volatile boolean isServiceAlive = false;
    protected volatile boolean isInvokeStartService = false;
    private android.os.Handler handler = new android.os.Handler(android.os.Looper.getMainLooper());
    private java.lang.Runnable debounceStartServiceRunnable = new com.ss.android.socialbase.downloader.downloader.AbsDownloadServiceHandler.AnonymousClass1();

    /* renamed from: com.ss.android.socialbase.downloader.downloader.AbsDownloadServiceHandler$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {
        public AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (com.ss.android.socialbase.downloader.logger.Logger.debug()) {
                com.ss.android.socialbase.downloader.logger.Logger.d(com.ss.android.socialbase.downloader.downloader.AbsDownloadServiceHandler.TAG, "tryDownload: 2 try");
            }
            if (com.ss.android.socialbase.downloader.downloader.AbsDownloadServiceHandler.this.isServiceAlive) {
                return;
            }
            if (com.ss.android.socialbase.downloader.logger.Logger.debug()) {
                com.ss.android.socialbase.downloader.logger.Logger.d(com.ss.android.socialbase.downloader.downloader.AbsDownloadServiceHandler.TAG, "tryDownload: 2 error");
            }
            com.ss.android.socialbase.downloader.downloader.AbsDownloadServiceHandler.this.startService(com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.getAppContext(), null);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadServiceHandler
    public boolean isServiceAlive() {
        return this.isServiceAlive;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadServiceHandler
    public boolean isServiceForeground() {
        com.ss.android.socialbase.downloader.logger.Logger.i(TAG, "isServiceForeground = " + this.isServiceForeground);
        return this.isServiceForeground;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadServiceHandler
    public android.os.IBinder onBind(android.content.Intent intent) {
        com.ss.android.socialbase.downloader.logger.Logger.d(TAG, "onBind Abs");
        return new android.os.Binder();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadServiceHandler
    public void onDestroy() {
        this.isServiceAlive = false;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadServiceHandler
    public void onStartCommand(android.content.Intent intent, int i, int i2) {
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadServiceHandler
    public void onStartCommandOnMainThread() {
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadServiceHandler
    public void pendDownloadTask(com.ss.android.socialbase.downloader.model.DownloadTask downloadTask) {
        if (downloadTask == null) {
            return;
        }
        int downloadId = downloadTask.getDownloadId();
        synchronized (this.pendingTasks) {
            java.lang.String str = TAG;
            com.ss.android.socialbase.downloader.logger.Logger.d(str, "pendDownloadTask pendingTasks.size:" + this.pendingTasks.size() + " downloadId:" + downloadId);
            java.util.List<com.ss.android.socialbase.downloader.model.DownloadTask> list = this.pendingTasks.get(downloadId);
            if (list == null) {
                list = new java.util.ArrayList<>();
                this.pendingTasks.put(downloadId, list);
            }
            com.ss.android.socialbase.downloader.logger.Logger.d(str, "before pendDownloadTask taskArray.size:" + list.size());
            list.add(downloadTask);
            com.ss.android.socialbase.downloader.logger.Logger.d(str, "after pendDownloadTask pendingTasks.size:" + this.pendingTasks.size());
        }
    }

    public void resumePendingTask() {
        android.util.SparseArray<java.util.List<com.ss.android.socialbase.downloader.model.DownloadTask>> clone;
        synchronized (this.pendingTasks) {
            com.ss.android.socialbase.downloader.logger.Logger.d(TAG, "resumePendingTask pendingTasks.size:" + this.pendingTasks.size());
            clone = this.pendingTasks.clone();
            this.pendingTasks.clear();
        }
        com.ss.android.socialbase.downloader.impls.AbsDownloadEngine downloadEngine = com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.getDownloadEngine();
        if (downloadEngine != null) {
            for (int i = 0; i < clone.size(); i++) {
                java.util.List<com.ss.android.socialbase.downloader.model.DownloadTask> list = clone.get(clone.keyAt(i));
                if (list != null) {
                    for (com.ss.android.socialbase.downloader.model.DownloadTask downloadTask : list) {
                        com.ss.android.socialbase.downloader.logger.Logger.d(TAG, "resumePendingTask key:" + downloadTask.getDownloadId());
                        downloadEngine.tryDownload(downloadTask);
                    }
                }
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadServiceHandler
    public void setDownloadService(java.lang.ref.WeakReference weakReference) {
        this.downloadService = weakReference;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadServiceHandler
    public void setLogLevel(int i) {
        com.ss.android.socialbase.downloader.logger.Logger.setLogLevel(i);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadServiceHandler
    public void setServiceConnectionListener(com.ss.android.socialbase.downloader.downloader.IDownloadServiceConnectionListener iDownloadServiceConnectionListener) {
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadServiceHandler
    public void startForeground(int i, android.app.Notification notification) {
        java.lang.ref.WeakReference<android.app.Service> weakReference = this.downloadService;
        if (weakReference == null || weakReference.get() == null) {
            com.ss.android.socialbase.downloader.logger.Logger.w(TAG, "startForeground: downloadService is null, do nothing!");
            return;
        }
        com.ss.android.socialbase.downloader.logger.Logger.i(TAG, "startForeground  id = " + i + ", service = " + this.downloadService.get() + ",  isServiceAlive = " + this.isServiceAlive);
        try {
            this.downloadService.get().startForeground(i, notification);
            this.isServiceForeground = true;
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadServiceHandler
    public void startService() {
        if (this.isServiceAlive) {
            return;
        }
        if (com.ss.android.socialbase.downloader.logger.Logger.debug()) {
            com.ss.android.socialbase.downloader.logger.Logger.d(TAG, "startService");
        }
        startService(com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.getAppContext(), null);
    }

    public void startService(android.content.Context context, android.content.ServiceConnection serviceConnection) {
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadServiceHandler
    public void stopForeground(boolean z) {
        java.lang.ref.WeakReference<android.app.Service> weakReference = this.downloadService;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        com.ss.android.socialbase.downloader.logger.Logger.i(TAG, "stopForeground  service = " + this.downloadService.get() + ",  isServiceAlive = " + this.isServiceAlive);
        try {
            this.isServiceForeground = false;
            this.downloadService.get().stopForeground(z);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    public void stopService(android.content.Context context, android.content.ServiceConnection serviceConnection) {
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadServiceHandler
    public void tryDownload(com.ss.android.socialbase.downloader.model.DownloadTask downloadTask) {
        if (downloadTask == null) {
            return;
        }
        if (this.isServiceAlive) {
            java.lang.String str = TAG;
            com.ss.android.socialbase.downloader.logger.Logger.d(str, "tryDownload when isServiceAlive");
            resumePendingTask();
            com.ss.android.socialbase.downloader.impls.AbsDownloadEngine downloadEngine = com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.getDownloadEngine();
            if (downloadEngine != null) {
                com.ss.android.socialbase.downloader.logger.Logger.d(str, "tryDownload current task: " + downloadTask.getDownloadId());
                downloadEngine.tryDownload(downloadTask);
                return;
            }
            return;
        }
        if (com.ss.android.socialbase.downloader.logger.Logger.debug()) {
            com.ss.android.socialbase.downloader.logger.Logger.d(TAG, "tryDownload but service is not alive");
        }
        if (!com.ss.android.socialbase.downloader.utils.DownloadExpSwitchCode.isSwitchEnable(262144)) {
            pendDownloadTask(downloadTask);
            startService(com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.getAppContext(), null);
            return;
        }
        pendDownloadTask(downloadTask);
        if (this.isInvokeStartService) {
            this.handler.removeCallbacks(this.debounceStartServiceRunnable);
            this.handler.postDelayed(this.debounceStartServiceRunnable, 10L);
        } else {
            if (com.ss.android.socialbase.downloader.logger.Logger.debug()) {
                com.ss.android.socialbase.downloader.logger.Logger.d(TAG, "tryDownload: 1");
            }
            startService(com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.getAppContext(), null);
            this.isInvokeStartService = true;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadServiceHandler
    public void tryDownloadWithEngine(com.ss.android.socialbase.downloader.model.DownloadTask downloadTask) {
    }
}
