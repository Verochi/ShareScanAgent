package com.ss.android.socialbase.downloader.impls;

/* loaded from: classes19.dex */
public abstract class AbsDownloadEngine implements com.ss.android.socialbase.downloader.thread.WeakDownloadHandler.IHandler {
    private static final java.lang.String TAG = "AbsDownloadEngine";
    private final android.util.SparseArray<com.ss.android.socialbase.downloader.model.DownloadTask> downloadTaskMap = new android.util.SparseArray<>();
    private final android.util.SparseArray<com.ss.android.socialbase.downloader.model.DownloadTask> successDownloadTaskMap = new android.util.SparseArray<>();
    private final android.util.SparseArray<com.ss.android.socialbase.downloader.model.DownloadTask> failedDownloadTaskMap = new android.util.SparseArray<>();
    private final android.util.SparseArray<com.ss.android.socialbase.downloader.model.DownloadTask> retryDelayDownloadTaskMap = new android.util.SparseArray<>();
    private final android.util.SparseArray<com.ss.android.socialbase.downloader.model.DownloadTask> waitingAsyncDownloadTaskMap = new android.util.SparseArray<>();
    private final android.util.SparseArray<android.util.SparseArray<com.ss.android.socialbase.downloader.model.DownloadTask>> downloadTaskWithListenerMap = new android.util.SparseArray<>();
    private final com.ss.android.socialbase.downloader.utils.LruCache<java.lang.Integer, com.ss.android.socialbase.downloader.model.DownloadTask> pengingTaskCache = new com.ss.android.socialbase.downloader.utils.LruCache<>();
    private final android.util.SparseArray<java.lang.Long> lastTaskTryDownloadTime = new android.util.SparseArray<>();
    private final java.util.concurrent.LinkedBlockingDeque<com.ss.android.socialbase.downloader.model.DownloadTask> orderedTaskQueue = new java.util.concurrent.LinkedBlockingDeque<>();
    protected final com.ss.android.socialbase.downloader.thread.WeakDownloadHandler mainHandler = new com.ss.android.socialbase.downloader.thread.WeakDownloadHandler(android.os.Looper.getMainLooper(), this);
    private final com.ss.android.socialbase.downloader.downloader.IDownloadCache downloadCache = com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.getDownloadCache();

    /* renamed from: com.ss.android.socialbase.downloader.impls.AbsDownloadEngine$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {
        final /* synthetic */ com.ss.android.socialbase.downloader.model.DownloadInfo val$downloadInfo;
        final /* synthetic */ android.util.SparseArray val$mainThreadListeners;
        final /* synthetic */ android.util.SparseArray val$notificationListeners;

        public AnonymousClass1(android.util.SparseArray sparseArray, com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo, android.util.SparseArray sparseArray2) {
            this.val$mainThreadListeners = sparseArray;
            this.val$downloadInfo = downloadInfo;
            this.val$notificationListeners = sparseArray2;
        }

        @Override // java.lang.Runnable
        public void run() {
            android.util.SparseArray sparseArray;
            android.util.SparseArray sparseArray2 = this.val$mainThreadListeners;
            if (sparseArray2 != null) {
                synchronized (sparseArray2) {
                    for (int i = 0; i < this.val$mainThreadListeners.size(); i++) {
                        com.ss.android.socialbase.downloader.depend.IDownloadListener iDownloadListener = (com.ss.android.socialbase.downloader.depend.IDownloadListener) this.val$mainThreadListeners.get(this.val$mainThreadListeners.keyAt(i));
                        if (iDownloadListener != null) {
                            iDownloadListener.onCanceled(this.val$downloadInfo);
                        }
                    }
                }
            }
            com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo = this.val$downloadInfo;
            if (downloadInfo == null || !downloadInfo.canShowNotification() || (sparseArray = this.val$notificationListeners) == null) {
                return;
            }
            synchronized (sparseArray) {
                for (int i2 = 0; i2 < this.val$notificationListeners.size(); i2++) {
                    com.ss.android.socialbase.downloader.depend.IDownloadListener iDownloadListener2 = (com.ss.android.socialbase.downloader.depend.IDownloadListener) this.val$notificationListeners.get(this.val$notificationListeners.keyAt(i2));
                    if (iDownloadListener2 != null) {
                        iDownloadListener2.onCanceled(this.val$downloadInfo);
                    }
                }
            }
        }
    }

    /* renamed from: com.ss.android.socialbase.downloader.impls.AbsDownloadEngine$2, reason: invalid class name */
    public class AnonymousClass2 implements java.lang.Runnable {
        final /* synthetic */ int val$id;

        public AnonymousClass2(int i) {
            this.val$id = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.ss.android.socialbase.downloader.notification.DownloadNotificationManager.getInstance().cancelNotification(this.val$id);
        }
    }

    /* renamed from: com.ss.android.socialbase.downloader.impls.AbsDownloadEngine$3, reason: invalid class name */
    public class AnonymousClass3 implements java.lang.Runnable {
        final /* synthetic */ boolean val$deleteFile;
        final /* synthetic */ int val$id;

        public AnonymousClass3(int i, boolean z) {
            this.val$id = i;
            this.val$deleteFile = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.ss.android.socialbase.downloader.model.DownloadTask downloadTask;
            if (com.ss.android.socialbase.downloader.impls.AbsDownloadEngine.this.doCancel(this.val$id) == null && (downloadTask = com.ss.android.socialbase.downloader.impls.AbsDownloadEngine.this.getDownloadTask(this.val$id)) != null) {
                com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo = downloadTask.getDownloadInfo();
                android.util.SparseArray<com.ss.android.socialbase.downloader.depend.IDownloadListener> downloadListeners = downloadTask.getDownloadListeners(com.ss.android.socialbase.downloader.constants.ListenerType.SUB);
                if (downloadListeners != null) {
                    synchronized (downloadListeners) {
                        for (int i = 0; i < downloadListeners.size(); i++) {
                            com.ss.android.socialbase.downloader.depend.IDownloadListener iDownloadListener = downloadListeners.get(downloadListeners.keyAt(i));
                            if (iDownloadListener != null) {
                                iDownloadListener.onCanceled(downloadInfo);
                            }
                        }
                    }
                }
            }
            com.ss.android.socialbase.downloader.impls.AbsDownloadEngine.this.clearDownloadDataInSubThread(this.val$id, this.val$deleteFile);
        }
    }

    /* renamed from: com.ss.android.socialbase.downloader.impls.AbsDownloadEngine$4, reason: invalid class name */
    public class AnonymousClass4 implements java.lang.Runnable {
        final /* synthetic */ int val$id;

        public AnonymousClass4(int i) {
            this.val$id = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.ss.android.socialbase.downloader.notification.DownloadNotificationManager.getInstance().cancelNotification(this.val$id);
        }
    }

    /* renamed from: com.ss.android.socialbase.downloader.impls.AbsDownloadEngine$5, reason: invalid class name */
    public class AnonymousClass5 implements java.lang.Runnable {
        final /* synthetic */ boolean val$deleteFile;
        final /* synthetic */ int val$id;

        public AnonymousClass5(int i, boolean z) {
            this.val$id = i;
            this.val$deleteFile = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.ss.android.socialbase.downloader.impls.AbsDownloadEngine.this.doCancel(this.val$id);
            com.ss.android.socialbase.downloader.impls.AbsDownloadEngine.this.resetDownloadDataInSubThread(this.val$id, this.val$deleteFile);
        }
    }

    /* renamed from: com.ss.android.socialbase.downloader.impls.AbsDownloadEngine$6, reason: invalid class name */
    public class AnonymousClass6 implements java.lang.Runnable {
        final /* synthetic */ com.ss.android.socialbase.downloader.model.DownloadInfo val$downloadInfo;
        final /* synthetic */ com.ss.android.socialbase.downloader.depend.IDownloadListener val$listener;

        public AnonymousClass6(com.ss.android.socialbase.downloader.depend.IDownloadListener iDownloadListener, com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo) {
            this.val$listener = iDownloadListener;
            this.val$downloadInfo = downloadInfo;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.val$listener != null) {
                if (this.val$downloadInfo.getStatus() == -3) {
                    this.val$listener.onSuccessed(this.val$downloadInfo);
                } else if (this.val$downloadInfo.getStatus() == -1) {
                    this.val$listener.onFailed(this.val$downloadInfo, new com.ss.android.socialbase.downloader.exception.BaseException(1000, "try add listener for failed task"));
                }
            }
        }
    }

    private void cancelAlarm(com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo) {
        if (downloadInfo != null) {
            try {
                if (downloadInfo.getStatus() == 7 || downloadInfo.getRetryDelayStatus() != com.ss.android.socialbase.downloader.constants.RetryDelayStatus.DELAY_RETRY_NONE) {
                    downloadInfo.setStatus(5);
                    downloadInfo.setRetryDelayStatus(com.ss.android.socialbase.downloader.constants.RetryDelayStatus.DELAY_RETRY_NONE);
                    com.ss.android.socialbase.downloader.logger.Logger.d(TAG, "cancelAlarm");
                }
            } catch (java.lang.Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void clearDownloadDataInSubThread(int i, boolean z) {
        com.ss.android.socialbase.downloader.logger.Logger.d(TAG, "clearDownloadDataInSubThread::id=" + i + " deleteTargetFile=" + z);
        try {
            com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo = this.downloadCache.getDownloadInfo(i);
            if (downloadInfo != null) {
                if (z) {
                    com.ss.android.socialbase.downloader.utils.DownloadUtils.deleteAllDownloadFiles(downloadInfo);
                } else {
                    com.ss.android.socialbase.downloader.utils.DownloadUtils.deleteFile(downloadInfo.getTempPath(), downloadInfo.getTempName());
                }
                downloadInfo.erase();
            }
            try {
                this.downloadCache.removeDownloadTaskData(i);
            } catch (android.database.sqlite.SQLiteException e) {
                e.printStackTrace();
            }
            refreshDownloadTaskMap(i, 0, -4);
            if (this.failedDownloadTaskMap.get(i) != null) {
                this.failedDownloadTaskMap.remove(i);
            }
            if (this.successDownloadTaskMap.get(i) != null) {
                this.successDownloadTaskMap.remove(i);
            }
            this.pengingTaskCache.remove(java.lang.Integer.valueOf(i));
            com.ss.android.socialbase.downloader.setting.DownloadSetting.removeTaskDownloadSetting(i);
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    private void enqueue(com.ss.android.socialbase.downloader.model.DownloadTask downloadTask) {
        com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo;
        if (downloadTask == null || (downloadInfo = downloadTask.getDownloadInfo()) == null) {
            return;
        }
        try {
            if (this.orderedTaskQueue.isEmpty()) {
                tryDownload(downloadTask, true);
                this.orderedTaskQueue.put(downloadTask);
                return;
            }
            if (downloadInfo.getEnqueueType() != com.ss.android.socialbase.downloader.constants.EnqueueType.ENQUEUE_TAIL) {
                com.ss.android.socialbase.downloader.model.DownloadTask first = this.orderedTaskQueue.getFirst();
                if (first.getDownloadId() == downloadTask.getDownloadId() && isDownloading(downloadTask.getDownloadId())) {
                    return;
                }
                pause(first.getDownloadId());
                tryDownload(downloadTask, true);
                if (first.getDownloadId() != downloadTask.getDownloadId()) {
                    this.orderedTaskQueue.putFirst(downloadTask);
                    return;
                }
                return;
            }
            if (this.orderedTaskQueue.getFirst().getDownloadId() == downloadTask.getDownloadId() && isDownloading(downloadTask.getDownloadId())) {
                return;
            }
            java.util.Iterator<com.ss.android.socialbase.downloader.model.DownloadTask> it = this.orderedTaskQueue.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                com.ss.android.socialbase.downloader.model.DownloadTask next = it.next();
                if (next != null && next.getDownloadId() == downloadTask.getDownloadId()) {
                    it.remove();
                    break;
                }
            }
            this.orderedTaskQueue.put(downloadTask);
            new com.ss.android.socialbase.downloader.downloader.DownloadStatusHandler(downloadTask, this.mainHandler).onPrepare();
        } catch (java.lang.InterruptedException unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.ss.android.socialbase.downloader.model.DownloadTask getDownloadTask(int i) {
        com.ss.android.socialbase.downloader.model.DownloadTask downloadTask = this.downloadTaskMap.get(i);
        if (downloadTask != null) {
            return downloadTask;
        }
        com.ss.android.socialbase.downloader.model.DownloadTask downloadTask2 = this.failedDownloadTaskMap.get(i);
        if (downloadTask2 != null) {
            return downloadTask2;
        }
        com.ss.android.socialbase.downloader.model.DownloadTask downloadTask3 = this.successDownloadTaskMap.get(i);
        if (downloadTask3 != null) {
            return downloadTask3;
        }
        com.ss.android.socialbase.downloader.model.DownloadTask downloadTask4 = this.retryDelayDownloadTaskMap.get(i);
        return downloadTask4 == null ? this.waitingAsyncDownloadTaskMap.get(i) : downloadTask4;
    }

    private boolean isPauseReserveOnWifi(com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo) {
        if (downloadInfo != null && downloadInfo.statusInPause()) {
            return downloadInfo.isPauseReserveOnWifi();
        }
        return false;
    }

    private void notifyDownloadTaskStatus(int i, com.ss.android.socialbase.downloader.exception.BaseException baseException, com.ss.android.socialbase.downloader.model.DownloadTask downloadTask) {
        if (downloadTask != null) {
            com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo = downloadTask.getDownloadInfo();
            android.util.SparseArray<com.ss.android.socialbase.downloader.depend.IDownloadListener> downloadListeners = downloadTask.getDownloadListeners(com.ss.android.socialbase.downloader.constants.ListenerType.MAIN);
            android.util.SparseArray<com.ss.android.socialbase.downloader.depend.IDownloadListener> downloadListeners2 = downloadTask.getDownloadListeners(com.ss.android.socialbase.downloader.constants.ListenerType.NOTIFICATION);
            boolean z = downloadTask.canShowNotification() || downloadInfo.isAutoInstallWithoutNotification();
            com.ss.android.socialbase.downloader.utils.DownloadListenerUtils.notifyListener(i, downloadListeners, true, downloadInfo, baseException);
            com.ss.android.socialbase.downloader.utils.DownloadListenerUtils.notifyListener(i, downloadListeners2, z, downloadInfo, baseException);
        }
    }

    private void removeTask(int i, int i2) {
        com.ss.android.socialbase.downloader.logger.Logger.d(TAG, "removeTask id: " + i + " listener hasCode: " + i2);
        if (i2 == 0) {
            this.downloadTaskMap.remove(i);
            this.downloadTaskWithListenerMap.remove(i);
            return;
        }
        android.util.SparseArray<com.ss.android.socialbase.downloader.model.DownloadTask> sparseArray = this.downloadTaskWithListenerMap.get(i);
        if (sparseArray == null) {
            this.downloadTaskMap.remove(i);
            return;
        }
        sparseArray.remove(i2);
        com.ss.android.socialbase.downloader.logger.Logger.d(TAG, "after downloadTaskWithListenerMap removeTask taskArray.size: " + sparseArray.size());
        if (sparseArray.size() == 0) {
            this.downloadTaskMap.remove(i);
            this.downloadTaskWithListenerMap.remove(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resetDownloadDataInSubThread(int i, boolean z) {
        try {
            com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo = this.downloadCache.getDownloadInfo(i);
            if (downloadInfo != null) {
                com.ss.android.socialbase.downloader.utils.DownloadUtils.deleteAllDownloadFiles(downloadInfo, z);
                downloadInfo.erase();
            }
            try {
                this.downloadCache.removeAllDownloadChunk(i);
                this.downloadCache.updateDownloadInfo(downloadInfo);
            } catch (android.database.sqlite.SQLiteException e) {
                e.printStackTrace();
            }
            if (this.failedDownloadTaskMap.get(i) != null) {
                this.failedDownloadTaskMap.remove(i);
            }
            if (this.successDownloadTaskMap.get(i) != null) {
                this.successDownloadTaskMap.remove(i);
            }
            this.pengingTaskCache.remove(java.lang.Integer.valueOf(i));
            com.ss.android.socialbase.downloader.setting.DownloadSetting.removeTaskDownloadSetting(i);
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    private void tryCacheSameTaskWithListenerHashCode(com.ss.android.socialbase.downloader.model.DownloadTask downloadTask) {
        int hashCodeForSameTask = downloadTask.getHashCodeForSameTask();
        if (hashCodeForSameTask == 0 && downloadTask.isAutoSetHashCodeForSameTask()) {
            hashCodeForSameTask = downloadTask.autoCalAndGetHashCodeForSameTask();
        }
        if (hashCodeForSameTask == 0) {
            return;
        }
        android.util.SparseArray<com.ss.android.socialbase.downloader.model.DownloadTask> sparseArray = this.downloadTaskWithListenerMap.get(downloadTask.getDownloadId());
        if (sparseArray == null) {
            sparseArray = new android.util.SparseArray<>();
            this.downloadTaskWithListenerMap.put(downloadTask.getDownloadId(), sparseArray);
        }
        com.ss.android.socialbase.downloader.logger.Logger.d(TAG, "tryCacheSameTaskWithListenerHashCode id:" + downloadTask.getDownloadId() + " listener hasCode:" + hashCodeForSameTask);
        sparseArray.put(hashCodeForSameTask, downloadTask);
    }

    private void tryDownload(com.ss.android.socialbase.downloader.model.DownloadTask downloadTask, boolean z) {
        com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo;
        int i;
        com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo2;
        com.ss.android.socialbase.downloader.model.DownloadTask remove;
        if (downloadTask == null || (downloadInfo = downloadTask.getDownloadInfo()) == null) {
            return;
        }
        if (downloadInfo.isEntityInvalid()) {
            com.ss.android.socialbase.downloader.monitor.DownloadMonitorHelper.monitorSendWithTaskMonitor(downloadTask.getMonitorDepend(), downloadInfo, new com.ss.android.socialbase.downloader.exception.BaseException(1003, "downloadInfo is Invalid, url is " + downloadInfo.getUrl() + " name is " + downloadInfo.getName() + " savePath is " + downloadInfo.getSavePath()), downloadInfo.getStatus());
            return;
        }
        boolean z2 = false;
        if (com.ss.android.socialbase.downloader.setting.DownloadSetting.obtain(downloadInfo.getId()).optInt(com.ss.android.socialbase.downloader.setting.DownloadSettingKeys.NO_NET_OPT, 0) == 1 && !com.ss.android.socialbase.downloader.utils.DownloadUtils.isNetworkConnected(com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.getAppContext()) && !downloadInfo.isFirstDownload()) {
            new com.ss.android.socialbase.downloader.downloader.DownloadStatusHandler(downloadTask, this.mainHandler).onError(new com.ss.android.socialbase.downloader.exception.BaseException(com.ss.android.socialbase.downloader.constants.DownloadErrorCode.ERROR_NETWORK_NOT_AVAILABLE, "network_not_available"));
            return;
        }
        int id = downloadInfo.getId();
        if (z) {
            cancelAlarm(downloadInfo);
        }
        if (this.failedDownloadTaskMap.get(id) != null) {
            this.failedDownloadTaskMap.remove(id);
        }
        if (this.successDownloadTaskMap.get(id) != null) {
            this.successDownloadTaskMap.remove(id);
        }
        if (this.retryDelayDownloadTaskMap.get(id) != null) {
            this.retryDelayDownloadTaskMap.remove(id);
        }
        if (this.waitingAsyncDownloadTaskMap.get(id) != null) {
            this.waitingAsyncDownloadTaskMap.remove(id);
        }
        if (isDownloading(id) && !downloadInfo.canReStartAsyncTask()) {
            com.ss.android.socialbase.downloader.logger.Logger.d(TAG, "another task with same id is downloading when tryDownload");
            downloadTask.addListenerToDownloadingSameTask();
            com.ss.android.socialbase.downloader.monitor.DownloadMonitorHelper.monitorSendWithTaskMonitor(downloadTask.getMonitorDepend(), downloadInfo, new com.ss.android.socialbase.downloader.exception.BaseException(1003, "downloadInfo is isDownloading and addListenerToSameTask is false"), downloadInfo.getStatus());
            return;
        }
        com.ss.android.socialbase.downloader.logger.Logger.d(TAG, "no downloading task :".concat(java.lang.String.valueOf(id)));
        if (downloadInfo.canReStartAsyncTask()) {
            downloadInfo.setAsyncHandleStatus(com.ss.android.socialbase.downloader.constants.AsyncHandleStatus.ASYNC_HANDLE_RESTART);
        }
        if (com.ss.android.socialbase.downloader.utils.DownloadExpSwitchCode.isSwitchEnable(32768) && (remove = this.pengingTaskCache.remove(java.lang.Integer.valueOf(id))) != null) {
            downloadTask.copyListenerFromPendingTask(remove);
        }
        long uptimeMillis = android.os.SystemClock.uptimeMillis();
        com.ss.android.socialbase.downloader.model.DownloadTask downloadTask2 = this.downloadTaskMap.get(id);
        if (downloadTask2 == null || (downloadInfo2 = downloadTask2.getDownloadInfo()) == null) {
            i = 0;
        } else {
            i = downloadInfo2.getStatus();
            if (com.ss.android.socialbase.downloader.constants.DownloadStatus.isDownloading(i)) {
                z2 = true;
            }
        }
        com.ss.android.socialbase.downloader.logger.Logger.d(TAG, "can add listener " + z2 + " , oldTaskStatus is :" + i);
        if (z2) {
            downloadTask.addListenerToDownloadingSameTask();
            return;
        }
        tryCacheSameTaskWithListenerHashCode(downloadTask);
        this.downloadTaskMap.put(id, downloadTask);
        this.lastTaskTryDownloadTime.put(id, java.lang.Long.valueOf(uptimeMillis));
        doDownload(id, downloadTask);
    }

    private void tryDownloadNextTaskInQueue(int i) {
        com.ss.android.socialbase.downloader.model.DownloadTask first;
        if (this.orderedTaskQueue.isEmpty()) {
            return;
        }
        com.ss.android.socialbase.downloader.model.DownloadTask first2 = this.orderedTaskQueue.getFirst();
        if (first2 != null && first2.getDownloadId() == i) {
            this.orderedTaskQueue.poll();
        }
        if (this.orderedTaskQueue.isEmpty() || (first = this.orderedTaskQueue.getFirst()) == null) {
            return;
        }
        tryDownload(first, true);
    }

    public synchronized void addDownloadListener(int i, int i2, com.ss.android.socialbase.downloader.depend.IDownloadListener iDownloadListener, com.ss.android.socialbase.downloader.constants.ListenerType listenerType, boolean z) {
        addDownloadListener(i, i2, iDownloadListener, listenerType, z, true);
    }

    public synchronized void addDownloadListener(int i, int i2, com.ss.android.socialbase.downloader.depend.IDownloadListener iDownloadListener, com.ss.android.socialbase.downloader.constants.ListenerType listenerType, boolean z, boolean z2) {
        com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo;
        com.ss.android.socialbase.downloader.model.DownloadTask downloadTask = getDownloadTask(i);
        if (downloadTask == null) {
            if (com.ss.android.socialbase.downloader.utils.DownloadExpSwitchCode.isSwitchEnable(32768) && (downloadInfo = this.downloadCache.getDownloadInfo(i)) != null && downloadInfo.getStatus() != -3) {
                com.ss.android.socialbase.downloader.model.DownloadTask downloadTask2 = this.pengingTaskCache.get(java.lang.Integer.valueOf(i));
                if (downloadTask2 == null) {
                    downloadTask2 = new com.ss.android.socialbase.downloader.model.DownloadTask(downloadInfo);
                    this.pengingTaskCache.put(java.lang.Integer.valueOf(i), downloadTask2);
                }
                downloadTask2.addDownloadListener(i2, iDownloadListener, listenerType, z);
            }
            return;
        }
        downloadTask.addDownloadListener(i2, iDownloadListener, listenerType, z);
        com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo2 = downloadTask.getDownloadInfo();
        if (z2 && downloadInfo2 != null && !isDownloading(i) && (listenerType == com.ss.android.socialbase.downloader.constants.ListenerType.MAIN || listenerType == com.ss.android.socialbase.downloader.constants.ListenerType.NOTIFICATION)) {
            if (listenerType != com.ss.android.socialbase.downloader.constants.ListenerType.NOTIFICATION || downloadInfo2.canShowNotification()) {
                this.mainHandler.post(new com.ss.android.socialbase.downloader.impls.AbsDownloadEngine.AnonymousClass6(iDownloadListener, downloadInfo2));
            }
        }
    }

    public synchronized boolean cancel(int i, boolean z) {
        com.ss.android.socialbase.downloader.model.DownloadTask downloadTask = this.downloadTaskMap.get(i);
        if (downloadTask == null && com.ss.android.socialbase.downloader.utils.DownloadExpSwitchCode.isSwitchEnable(65536)) {
            downloadTask = getDownloadTask(i);
        }
        if (downloadTask != null) {
            if (!com.ss.android.socialbase.downloader.setting.DownloadSetting.obtain(i).optBugFix(com.ss.android.socialbase.downloader.setting.DownloadSettingKeys.BugFix.FIX_ON_CANCEL_CALL_TWICE, true)) {
                new com.ss.android.socialbase.downloader.downloader.DownloadStatusHandler(downloadTask, this.mainHandler).onCancel();
            }
            com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo = downloadTask.getDownloadInfo();
            this.mainHandler.post(new com.ss.android.socialbase.downloader.impls.AbsDownloadEngine.AnonymousClass1(downloadTask.getDownloadListeners(com.ss.android.socialbase.downloader.constants.ListenerType.MAIN), downloadInfo, downloadTask.getDownloadListeners(com.ss.android.socialbase.downloader.constants.ListenerType.NOTIFICATION)));
        }
        com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo2 = this.downloadCache.getDownloadInfo(i);
        if (com.ss.android.socialbase.downloader.utils.DownloadExpSwitchCode.isSwitchEnable(65536)) {
            if (downloadInfo2 != null) {
                downloadInfo2.setStatus(-4);
            }
        } else if (downloadInfo2 != null && com.ss.android.socialbase.downloader.constants.DownloadStatus.isDownloading(downloadInfo2.getStatus())) {
            downloadInfo2.setStatus(-4);
        }
        clearDownloadData(i, z);
        return true;
    }

    public void clearDownloadData(int i, boolean z) {
        com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo = this.downloadCache.getDownloadInfo(i);
        if (downloadInfo != null) {
            cancelAlarm(downloadInfo);
        }
        this.mainHandler.post(new com.ss.android.socialbase.downloader.impls.AbsDownloadEngine.AnonymousClass2(i));
        com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.submitCPUTask(new com.ss.android.socialbase.downloader.impls.AbsDownloadEngine.AnonymousClass3(i, z), false);
    }

    public abstract com.ss.android.socialbase.downloader.thread.DownloadRunnable doCancel(int i);

    public abstract void doDownload(int i, com.ss.android.socialbase.downloader.model.DownloadTask downloadTask);

    public abstract void doPause(int i);

    public abstract void doSetThrottleNetSpeed(int i, long j);

    public synchronized void forceDownloadIgnoreRecommendSize(int i) {
        com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo;
        com.ss.android.socialbase.downloader.model.DownloadTask downloadTask = this.downloadTaskMap.get(i);
        if (downloadTask != null && (downloadInfo = downloadTask.getDownloadInfo()) != null) {
            downloadInfo.setForceIgnoreRecommendSize(true);
            tryDownload(downloadTask);
        }
    }

    public abstract java.util.List<java.lang.Integer> getAllAliveDownloadIds();

    public synchronized com.ss.android.socialbase.downloader.depend.IDownloadFileUriProvider getDownloadFileUriProvider(int i) {
        com.ss.android.socialbase.downloader.model.DownloadTask downloadTask = this.downloadTaskMap.get(i);
        if (downloadTask != null) {
            return downloadTask.getFileUriProvider();
        }
        com.ss.android.socialbase.downloader.model.DownloadTask downloadTask2 = this.successDownloadTaskMap.get(i);
        if (downloadTask2 != null) {
            return downloadTask2.getFileUriProvider();
        }
        com.ss.android.socialbase.downloader.model.DownloadTask downloadTask3 = this.failedDownloadTaskMap.get(i);
        if (downloadTask3 != null) {
            return downloadTask3.getFileUriProvider();
        }
        com.ss.android.socialbase.downloader.model.DownloadTask downloadTask4 = this.retryDelayDownloadTaskMap.get(i);
        if (downloadTask4 != null) {
            return downloadTask4.getFileUriProvider();
        }
        com.ss.android.socialbase.downloader.model.DownloadTask downloadTask5 = this.waitingAsyncDownloadTaskMap.get(i);
        if (downloadTask5 == null) {
            return null;
        }
        return downloadTask5.getFileUriProvider();
    }

    public synchronized com.ss.android.socialbase.downloader.model.DownloadInfo getDownloadInfo(int i) {
        com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo;
        com.ss.android.socialbase.downloader.model.DownloadTask downloadTask;
        downloadInfo = this.downloadCache.getDownloadInfo(i);
        if (downloadInfo == null && (downloadTask = this.downloadTaskMap.get(i)) != null) {
            downloadInfo = downloadTask.getDownloadInfo();
        }
        return downloadInfo;
    }

    public synchronized java.util.List<com.ss.android.socialbase.downloader.model.DownloadInfo> getDownloadInfoList(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return null;
        }
        java.util.List<com.ss.android.socialbase.downloader.model.DownloadInfo> downloadInfoList = this.downloadCache.getDownloadInfoList(str);
        if (downloadInfoList != null && !downloadInfoList.isEmpty()) {
            return downloadInfoList;
        }
        java.util.ArrayList arrayList = new java.util.ArrayList();
        int size = this.downloadTaskMap.size();
        for (int i = 0; i < size; i++) {
            com.ss.android.socialbase.downloader.model.DownloadTask valueAt = this.downloadTaskMap.valueAt(i);
            if (valueAt != null && valueAt.getDownloadInfo() != null && str.equals(valueAt.getDownloadInfo().getUrl())) {
                arrayList.add(valueAt.getDownloadInfo());
            }
        }
        return arrayList;
    }

    public synchronized com.ss.android.socialbase.downloader.depend.IDownloadNotificationEventListener getDownloadNotificationEventListener(int i) {
        com.ss.android.socialbase.downloader.model.DownloadTask downloadTask = this.downloadTaskMap.get(i);
        if (downloadTask != null) {
            return downloadTask.getNotificationEventListener();
        }
        com.ss.android.socialbase.downloader.model.DownloadTask downloadTask2 = this.successDownloadTaskMap.get(i);
        if (downloadTask2 != null) {
            return downloadTask2.getNotificationEventListener();
        }
        com.ss.android.socialbase.downloader.model.DownloadTask downloadTask3 = this.failedDownloadTaskMap.get(i);
        if (downloadTask3 != null) {
            return downloadTask3.getNotificationEventListener();
        }
        com.ss.android.socialbase.downloader.model.DownloadTask downloadTask4 = this.retryDelayDownloadTaskMap.get(i);
        if (downloadTask4 != null) {
            return downloadTask4.getNotificationEventListener();
        }
        com.ss.android.socialbase.downloader.model.DownloadTask downloadTask5 = this.waitingAsyncDownloadTaskMap.get(i);
        if (downloadTask5 == null) {
            return null;
        }
        return downloadTask5.getNotificationEventListener();
    }

    public java.util.List<com.ss.android.socialbase.downloader.model.DownloadInfo> getDownloadingDownloadInfosWithMimeType(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return null;
        }
        java.util.Iterator<java.lang.Integer> it = getAllAliveDownloadIds().iterator();
        java.util.ArrayList arrayList = new java.util.ArrayList();
        while (it.hasNext()) {
            com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo = getDownloadInfo(it.next().intValue());
            if (downloadInfo != null && str.equals(downloadInfo.getMimeType())) {
                arrayList.add(downloadInfo);
            }
        }
        return arrayList;
    }

    public synchronized com.ss.android.socialbase.downloader.depend.INotificationClickCallback getNotificationClickCallback(int i) {
        com.ss.android.socialbase.downloader.model.DownloadTask downloadTask = this.downloadTaskMap.get(i);
        if (downloadTask != null) {
            return downloadTask.getNotificationClickCallback();
        }
        com.ss.android.socialbase.downloader.model.DownloadTask downloadTask2 = this.successDownloadTaskMap.get(i);
        if (downloadTask2 != null) {
            return downloadTask2.getNotificationClickCallback();
        }
        com.ss.android.socialbase.downloader.model.DownloadTask downloadTask3 = this.failedDownloadTaskMap.get(i);
        if (downloadTask3 != null) {
            return downloadTask3.getNotificationClickCallback();
        }
        com.ss.android.socialbase.downloader.model.DownloadTask downloadTask4 = this.retryDelayDownloadTaskMap.get(i);
        if (downloadTask4 != null) {
            return downloadTask4.getNotificationClickCallback();
        }
        com.ss.android.socialbase.downloader.model.DownloadTask downloadTask5 = this.waitingAsyncDownloadTaskMap.get(i);
        if (downloadTask5 == null) {
            return null;
        }
        return downloadTask5.getNotificationClickCallback();
    }

    @Override // com.ss.android.socialbase.downloader.thread.WeakDownloadHandler.IHandler
    public void handleMsg(android.os.Message message) {
        int i = message.arg1;
        int i2 = message.arg2;
        com.ss.android.socialbase.downloader.logger.Logger.d(TAG, "handleMsg id: " + i + " listener hasCode: " + i2);
        java.lang.Object obj = message.obj;
        com.ss.android.socialbase.downloader.model.DownloadTask downloadTask = null;
        com.ss.android.socialbase.downloader.exception.BaseException baseException = obj instanceof java.lang.Exception ? (com.ss.android.socialbase.downloader.exception.BaseException) obj : null;
        synchronized (this) {
            if (i2 == 0) {
                downloadTask = this.downloadTaskMap.get(i);
            } else {
                android.util.SparseArray<com.ss.android.socialbase.downloader.model.DownloadTask> sparseArray = this.downloadTaskWithListenerMap.get(i);
                if (sparseArray != null) {
                    downloadTask = sparseArray.get(i2);
                }
            }
            if (downloadTask == null) {
                return;
            }
            notifyDownloadTaskStatus(message.what, baseException, downloadTask);
            refreshDownloadTaskMap(i, i2, message.what);
        }
    }

    public abstract boolean isDownloading(int i);

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0011, code lost:
    
        if (r1.failedDownloadTaskMap.get(r2) != null) goto L8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized boolean isInDownloadTaskPool(int i) {
        if (i != 0) {
            if (this.downloadTaskMap.get(i) == null) {
            }
            return true;
        }
        return false;
    }

    public synchronized boolean pause(int i) {
        com.ss.android.socialbase.downloader.logger.Logger.d(TAG, "pause id=".concat(java.lang.String.valueOf(i)));
        com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo = this.downloadCache.getDownloadInfo(i);
        if (downloadInfo != null && downloadInfo.getStatus() == 11) {
            return false;
        }
        synchronized (this.downloadTaskMap) {
            doPause(i);
        }
        if (downloadInfo == null) {
            com.ss.android.socialbase.downloader.model.DownloadTask downloadTask = this.downloadTaskMap.get(i);
            if (downloadTask != null) {
                new com.ss.android.socialbase.downloader.downloader.DownloadStatusHandler(downloadTask, this.mainHandler).onPause();
                return true;
            }
        } else {
            cancelAlarm(downloadInfo);
            if (downloadInfo.getStatus() == 1) {
                com.ss.android.socialbase.downloader.model.DownloadTask downloadTask2 = this.downloadTaskMap.get(i);
                if (downloadTask2 != null) {
                    new com.ss.android.socialbase.downloader.downloader.DownloadStatusHandler(downloadTask2, this.mainHandler).onPause();
                    return true;
                }
            } else if (com.ss.android.socialbase.downloader.constants.DownloadStatus.isDownloading(downloadInfo.getStatus())) {
                downloadInfo.setStatus(-2);
                return true;
            }
        }
        return false;
    }

    public synchronized void refreshDownloadTaskMap(int i, int i2, int i3) {
        if (i3 != -7) {
            if (i3 == -6) {
                this.successDownloadTaskMap.put(i, this.downloadTaskMap.get(i));
                removeTask(i, i2);
                return;
            }
            if (i3 == -4) {
                removeTask(i, i2);
            } else if (i3 == -3) {
                this.successDownloadTaskMap.put(i, this.downloadTaskMap.get(i));
                removeTask(i, i2);
            } else if (i3 != -1) {
                if (i3 != 7) {
                    if (i3 == 8) {
                        com.ss.android.socialbase.downloader.model.DownloadTask downloadTask = this.downloadTaskMap.get(i);
                        if (downloadTask != null && this.waitingAsyncDownloadTaskMap.get(i) == null) {
                            this.waitingAsyncDownloadTaskMap.put(i, downloadTask);
                        }
                    }
                    return;
                }
                com.ss.android.socialbase.downloader.model.DownloadTask downloadTask2 = this.downloadTaskMap.get(i);
                if (downloadTask2 != null) {
                    if (this.retryDelayDownloadTaskMap.get(i) == null) {
                        this.retryDelayDownloadTaskMap.put(i, downloadTask2);
                    }
                    removeTask(i, i2);
                }
                tryDownloadNextTaskInQueue(i);
                return;
            }
            tryDownloadNextTaskInQueue(i);
            return;
        }
        com.ss.android.socialbase.downloader.model.DownloadTask downloadTask3 = this.downloadTaskMap.get(i);
        if (downloadTask3 != null) {
            if (this.failedDownloadTaskMap.get(i) == null) {
                this.failedDownloadTaskMap.put(i, downloadTask3);
            }
            removeTask(i, i2);
        }
        tryDownloadNextTaskInQueue(i);
    }

    public synchronized void removeDownloadListener(int i, int i2, com.ss.android.socialbase.downloader.depend.IDownloadListener iDownloadListener, com.ss.android.socialbase.downloader.constants.ListenerType listenerType, boolean z) {
        com.ss.android.socialbase.downloader.model.DownloadTask downloadTask = getDownloadTask(i);
        if (downloadTask == null) {
            downloadTask = this.pengingTaskCache.get(java.lang.Integer.valueOf(i));
        }
        if (downloadTask != null) {
            downloadTask.removeDownloadListener(i2, iDownloadListener, listenerType, z);
        }
    }

    public abstract void removeDownloadRunnable(com.ss.android.socialbase.downloader.thread.DownloadRunnable downloadRunnable);

    public void resetDownloadData(int i, boolean z) {
        com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo = this.downloadCache.getDownloadInfo(i);
        if (downloadInfo != null) {
            cancelAlarm(downloadInfo);
        }
        this.mainHandler.post(new com.ss.android.socialbase.downloader.impls.AbsDownloadEngine.AnonymousClass4(i));
        com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.submitCPUTask(new com.ss.android.socialbase.downloader.impls.AbsDownloadEngine.AnonymousClass5(i, z), false);
    }

    public synchronized boolean restart(int i) {
        com.ss.android.socialbase.downloader.model.DownloadTask downloadTask = this.failedDownloadTaskMap.get(i);
        if (downloadTask == null) {
            downloadTask = this.retryDelayDownloadTaskMap.get(i);
        }
        if (downloadTask == null) {
            return false;
        }
        com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo = downloadTask.getDownloadInfo();
        if (downloadInfo != null) {
            downloadInfo.setDownloadFromReserveWifi(false);
        }
        tryDownload(downloadTask);
        return true;
    }

    public synchronized void restartAllFailedDownloadTasks(java.util.List<java.lang.String> list) {
        com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo;
        try {
            boolean isWifi = com.ss.android.socialbase.downloader.utils.DownloadExpSwitchCode.isSwitchEnable(1048576) ? com.ss.android.socialbase.downloader.utils.DownloadUtils.isWifi(com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.getAppContext()) : true;
            for (int i = 0; i < this.failedDownloadTaskMap.size(); i++) {
                com.ss.android.socialbase.downloader.model.DownloadTask downloadTask = this.failedDownloadTaskMap.get(this.failedDownloadTaskMap.keyAt(i));
                if (downloadTask != null && (downloadInfo = downloadTask.getDownloadInfo()) != null && downloadInfo.getMimeType() != null && list.contains(downloadInfo.getMimeType()) && (!downloadInfo.isOnlyWifi() || isWifi)) {
                    downloadInfo.setAutoResumed(true);
                    downloadInfo.setShowNotificationForNetworkResumed(true);
                    tryDownload(downloadTask);
                }
            }
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    public synchronized void restartAllPauseReserveOnWifiDownloadTasks(java.util.List<java.lang.String> list) {
        com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo;
        try {
            if (com.ss.android.socialbase.downloader.utils.DownloadUtils.isWifi(com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.getAppContext())) {
                for (int i = 0; i < this.downloadTaskMap.size(); i++) {
                    com.ss.android.socialbase.downloader.model.DownloadTask downloadTask = this.downloadTaskMap.get(this.downloadTaskMap.keyAt(i));
                    if (downloadTask != null && (downloadInfo = downloadTask.getDownloadInfo()) != null && downloadInfo.getMimeType() != null && list.contains(downloadInfo.getMimeType()) && isPauseReserveOnWifi(downloadInfo)) {
                        downloadInfo.setAutoResumed(true);
                        downloadInfo.setShowNotificationForNetworkResumed(true);
                        tryDownload(downloadTask);
                        downloadInfo.setDownloadFromReserveWifi(true);
                        com.ss.android.socialbase.downloader.downloader.IReserveWifiStatusListener reserveWifiStatusListener = com.ss.android.socialbase.downloader.downloader.Downloader.getInstance(com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.getAppContext()).getReserveWifiStatusListener();
                        if (reserveWifiStatusListener != null) {
                            reserveWifiStatusListener.onStatusChanged(downloadInfo, 5, 2);
                        }
                    }
                }
            }
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    public synchronized boolean restartAsyncWaitingTask(int i) {
        com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo;
        com.ss.android.socialbase.downloader.model.DownloadTask downloadTask = this.waitingAsyncDownloadTaskMap.get(i);
        if (downloadTask == null || (downloadInfo = downloadTask.getDownloadInfo()) == null) {
            return false;
        }
        if (downloadInfo.canReStartAsyncTask()) {
            tryDownload(downloadTask);
        }
        return true;
    }

    public synchronized boolean resume(int i) {
        com.ss.android.socialbase.downloader.model.DownloadTask downloadTask = this.downloadTaskMap.get(i);
        if (downloadTask != null) {
            com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo = downloadTask.getDownloadInfo();
            if (downloadInfo != null) {
                downloadInfo.setDownloadFromReserveWifi(false);
            }
            tryDownload(downloadTask);
        } else {
            restart(i);
        }
        return true;
    }

    public synchronized boolean retryDelayStart(int i) {
        com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo;
        com.ss.android.socialbase.downloader.model.DownloadTask downloadTask = this.retryDelayDownloadTaskMap.get(i);
        if (downloadTask != null && (downloadInfo = downloadTask.getDownloadInfo()) != null) {
            if (downloadInfo.canStartRetryDelayTask()) {
                tryDownload(downloadTask, false);
            }
            return true;
        }
        com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo2 = this.downloadCache.getDownloadInfo(i);
        if (downloadInfo2 != null && downloadInfo2.canStartRetryDelayTask()) {
            tryDownload(new com.ss.android.socialbase.downloader.model.DownloadTask(downloadInfo2), false);
        }
        return false;
    }

    public synchronized void setDownloadNotificationEventListener(int i, com.ss.android.socialbase.downloader.depend.IDownloadNotificationEventListener iDownloadNotificationEventListener) {
        com.ss.android.socialbase.downloader.model.DownloadTask downloadTask = this.downloadTaskMap.get(i);
        if (downloadTask != null) {
            downloadTask.setNotificationEventListener(iDownloadNotificationEventListener);
        }
    }

    public void setThrottleNetSpeed(int i, long j) {
        com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo = this.downloadCache.getDownloadInfo(i);
        if (downloadInfo != null) {
            downloadInfo.setThrottleNetSpeed(j);
        }
        doSetThrottleNetSpeed(i, j);
    }

    public void shutDown() {
        java.util.List<java.lang.Integer> allAliveDownloadIds = getAllAliveDownloadIds();
        if (allAliveDownloadIds == null) {
            return;
        }
        java.util.Iterator<java.lang.Integer> it = allAliveDownloadIds.iterator();
        while (it.hasNext()) {
            pause(it.next().intValue());
        }
    }

    public synchronized void tryDownload(com.ss.android.socialbase.downloader.model.DownloadTask downloadTask) {
        if (downloadTask == null) {
            return;
        }
        com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo = downloadTask.getDownloadInfo();
        if (downloadInfo == null) {
            return;
        }
        downloadInfo.setDownloadFromReserveWifi(false);
        if (downloadInfo.getEnqueueType() != com.ss.android.socialbase.downloader.constants.EnqueueType.ENQUEUE_NONE) {
            enqueue(downloadTask);
        } else {
            tryDownload(downloadTask, true);
        }
    }
}
