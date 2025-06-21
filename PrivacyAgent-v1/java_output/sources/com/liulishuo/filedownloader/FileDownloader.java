package com.liulishuo.filedownloader;

/* loaded from: classes23.dex */
public class FileDownloader {
    public static final java.lang.Object c = new java.lang.Object();
    public static final java.lang.Object d = new java.lang.Object();
    public com.liulishuo.filedownloader.IQueuesHandler a;
    public com.liulishuo.filedownloader.ILostServiceConnectedHandler b;

    public static final class HolderClass {
        public static final com.liulishuo.filedownloader.FileDownloader a = new com.liulishuo.filedownloader.FileDownloader();
    }

    public static void disableAvoidDropFrame() {
        setGlobalPost2UIInterval(-1);
    }

    public static void enableAvoidDropFrame() {
        setGlobalPost2UIInterval(10);
    }

    public static com.liulishuo.filedownloader.FileDownloader getImpl() {
        return com.liulishuo.filedownloader.FileDownloader.HolderClass.a;
    }

    public static void init(android.content.Context context) {
        if (context == null) {
            throw new java.lang.IllegalArgumentException("the provided context must not be null!");
        }
        setup(context);
    }

    public static void init(android.content.Context context, com.liulishuo.filedownloader.services.DownloadMgrInitialParams.InitCustomMaker initCustomMaker) {
        if (com.liulishuo.filedownloader.util.FileDownloadLog.NEED_LOG) {
            com.liulishuo.filedownloader.util.FileDownloadLog.d(com.liulishuo.filedownloader.FileDownloader.class, "init Downloader with params: %s %s", context, initCustomMaker);
        }
        if (context == null) {
            throw new java.lang.IllegalArgumentException("the provided context must not be null!");
        }
        com.liulishuo.filedownloader.util.FileDownloadHelper.holdContext(context.getApplicationContext());
        com.liulishuo.filedownloader.download.CustomComponentHolder.getImpl().setInitCustomMaker(initCustomMaker);
    }

    public static boolean isEnabledAvoidDropFrame() {
        return com.liulishuo.filedownloader.FileDownloadMessageStation.isIntervalValid();
    }

    public static void setGlobalHandleSubPackageSize(int i) {
        if (i <= 0) {
            throw new java.lang.IllegalArgumentException("sub package size must more than 0");
        }
        com.liulishuo.filedownloader.FileDownloadMessageStation.g = i;
    }

    public static void setGlobalPost2UIInterval(int i) {
        com.liulishuo.filedownloader.FileDownloadMessageStation.f = i;
    }

    public static void setup(android.content.Context context) {
        com.liulishuo.filedownloader.util.FileDownloadHelper.holdContext(context.getApplicationContext());
    }

    public static com.liulishuo.filedownloader.services.DownloadMgrInitialParams.InitCustomMaker setupOnApplicationOnCreate(android.app.Application application) {
        com.liulishuo.filedownloader.util.FileDownloadHelper.holdContext(application.getApplicationContext());
        com.liulishuo.filedownloader.services.DownloadMgrInitialParams.InitCustomMaker initCustomMaker = new com.liulishuo.filedownloader.services.DownloadMgrInitialParams.InitCustomMaker();
        com.liulishuo.filedownloader.download.CustomComponentHolder.getImpl().setInitCustomMaker(initCustomMaker);
        return initCustomMaker;
    }

    public com.liulishuo.filedownloader.ILostServiceConnectedHandler a() {
        if (this.b == null) {
            synchronized (d) {
                if (this.b == null) {
                    com.liulishuo.filedownloader.LostServiceConnectedHandler lostServiceConnectedHandler = new com.liulishuo.filedownloader.LostServiceConnectedHandler();
                    this.b = lostServiceConnectedHandler;
                    addServiceConnectListener(lostServiceConnectedHandler);
                }
            }
        }
        return this.b;
    }

    public void addServiceConnectListener(com.liulishuo.filedownloader.FileDownloadConnectListener fileDownloadConnectListener) {
        com.liulishuo.filedownloader.FileDownloadEventPool.getImpl().addListener(com.liulishuo.filedownloader.event.DownloadServiceConnectChangedEvent.ID, fileDownloadConnectListener);
    }

    public com.liulishuo.filedownloader.IQueuesHandler b() {
        if (this.a == null) {
            synchronized (c) {
                if (this.a == null) {
                    this.a = new com.liulishuo.filedownloader.QueuesHandler();
                }
            }
        }
        return this.a;
    }

    public void bindService() {
        if (isServiceConnected()) {
            return;
        }
        com.liulishuo.filedownloader.FileDownloadServiceProxy.getImpl().bindStartByContext(com.liulishuo.filedownloader.util.FileDownloadHelper.getAppContext());
    }

    public void bindService(java.lang.Runnable runnable) {
        if (isServiceConnected()) {
            runnable.run();
        } else {
            com.liulishuo.filedownloader.FileDownloadServiceProxy.getImpl().bindStartByContext(com.liulishuo.filedownloader.util.FileDownloadHelper.getAppContext(), runnable);
        }
    }

    public boolean clear(int i, java.lang.String str) {
        pause(i);
        if (!com.liulishuo.filedownloader.FileDownloadServiceProxy.getImpl().clearTaskData(i)) {
            return false;
        }
        java.io.File file = new java.io.File(com.liulishuo.filedownloader.util.FileDownloadUtils.getTempPath(str));
        if (file.exists()) {
            file.delete();
        }
        java.io.File file2 = new java.io.File(str);
        if (!file2.exists()) {
            return true;
        }
        file2.delete();
        return true;
    }

    public void clearAllTaskData() {
        pauseAll();
        com.liulishuo.filedownloader.FileDownloadServiceProxy.getImpl().clearAllTaskData();
    }

    public com.liulishuo.filedownloader.BaseDownloadTask create(java.lang.String str) {
        return new com.liulishuo.filedownloader.DownloadTask(str);
    }

    public long getSoFar(int i) {
        com.liulishuo.filedownloader.BaseDownloadTask.IRunningTask iRunningTask = com.liulishuo.filedownloader.FileDownloadList.getImpl().get(i);
        return iRunningTask == null ? com.liulishuo.filedownloader.FileDownloadServiceProxy.getImpl().getSofar(i) : iRunningTask.getOrigin().getLargeFileSoFarBytes();
    }

    public byte getStatus(int i, java.lang.String str) {
        com.liulishuo.filedownloader.BaseDownloadTask.IRunningTask iRunningTask = com.liulishuo.filedownloader.FileDownloadList.getImpl().get(i);
        byte status = iRunningTask == null ? com.liulishuo.filedownloader.FileDownloadServiceProxy.getImpl().getStatus(i) : iRunningTask.getOrigin().getStatus();
        if (str != null && status == 0 && com.liulishuo.filedownloader.util.FileDownloadUtils.isFilenameConverted(com.liulishuo.filedownloader.util.FileDownloadHelper.getAppContext()) && new java.io.File(str).exists()) {
            return (byte) -3;
        }
        return status;
    }

    public byte getStatus(java.lang.String str, java.lang.String str2) {
        return getStatus(com.liulishuo.filedownloader.util.FileDownloadUtils.generateId(str, str2), str2);
    }

    public byte getStatusIgnoreCompleted(int i) {
        return getStatus(i, (java.lang.String) null);
    }

    public long getTotal(int i) {
        com.liulishuo.filedownloader.BaseDownloadTask.IRunningTask iRunningTask = com.liulishuo.filedownloader.FileDownloadList.getImpl().get(i);
        return iRunningTask == null ? com.liulishuo.filedownloader.FileDownloadServiceProxy.getImpl().getTotal(i) : iRunningTask.getOrigin().getLargeFileTotalBytes();
    }

    public com.liulishuo.filedownloader.FileDownloadLine insureServiceBind() {
        return new com.liulishuo.filedownloader.FileDownloadLine();
    }

    public com.liulishuo.filedownloader.FileDownloadLineAsync insureServiceBindAsync() {
        return new com.liulishuo.filedownloader.FileDownloadLineAsync();
    }

    public boolean isServiceConnected() {
        return com.liulishuo.filedownloader.FileDownloadServiceProxy.getImpl().isConnected();
    }

    public int pause(int i) {
        java.util.List<com.liulishuo.filedownloader.BaseDownloadTask.IRunningTask> h = com.liulishuo.filedownloader.FileDownloadList.getImpl().h(i);
        if (h == null || h.isEmpty()) {
            com.liulishuo.filedownloader.util.FileDownloadLog.w(this, "request pause but not exist %d", java.lang.Integer.valueOf(i));
            return 0;
        }
        java.util.Iterator<com.liulishuo.filedownloader.BaseDownloadTask.IRunningTask> it = h.iterator();
        while (it.hasNext()) {
            it.next().getOrigin().pause();
        }
        return h.size();
    }

    public void pause(com.liulishuo.filedownloader.FileDownloadListener fileDownloadListener) {
        com.liulishuo.filedownloader.FileDownloadTaskLauncher.d().a(fileDownloadListener);
        java.util.Iterator<com.liulishuo.filedownloader.BaseDownloadTask.IRunningTask> it = com.liulishuo.filedownloader.FileDownloadList.getImpl().d(fileDownloadListener).iterator();
        while (it.hasNext()) {
            it.next().getOrigin().pause();
        }
    }

    public void pauseAll() {
        com.liulishuo.filedownloader.FileDownloadTaskLauncher.d().c();
        for (com.liulishuo.filedownloader.BaseDownloadTask.IRunningTask iRunningTask : com.liulishuo.filedownloader.FileDownloadList.getImpl().e()) {
            iRunningTask.getOrigin().pause();
        }
        if (com.liulishuo.filedownloader.FileDownloadServiceProxy.getImpl().isConnected()) {
            com.liulishuo.filedownloader.FileDownloadServiceProxy.getImpl().pauseAllTasks();
        } else {
            com.liulishuo.filedownloader.PauseAllMarker.createMarker();
        }
    }

    public void removeServiceConnectListener(com.liulishuo.filedownloader.FileDownloadConnectListener fileDownloadConnectListener) {
        com.liulishuo.filedownloader.FileDownloadEventPool.getImpl().removeListener(com.liulishuo.filedownloader.event.DownloadServiceConnectChangedEvent.ID, fileDownloadConnectListener);
    }

    public int replaceListener(int i, com.liulishuo.filedownloader.FileDownloadListener fileDownloadListener) {
        com.liulishuo.filedownloader.BaseDownloadTask.IRunningTask iRunningTask = com.liulishuo.filedownloader.FileDownloadList.getImpl().get(i);
        if (iRunningTask == null) {
            return 0;
        }
        iRunningTask.getOrigin().setListener(fileDownloadListener);
        return iRunningTask.getOrigin().getId();
    }

    public int replaceListener(java.lang.String str, com.liulishuo.filedownloader.FileDownloadListener fileDownloadListener) {
        return replaceListener(str, com.liulishuo.filedownloader.util.FileDownloadUtils.getDefaultSaveFilePath(str), fileDownloadListener);
    }

    public int replaceListener(java.lang.String str, java.lang.String str2, com.liulishuo.filedownloader.FileDownloadListener fileDownloadListener) {
        return replaceListener(com.liulishuo.filedownloader.util.FileDownloadUtils.generateId(str, str2), fileDownloadListener);
    }

    public boolean setMaxNetworkThreadCount(int i) {
        if (com.liulishuo.filedownloader.FileDownloadList.getImpl().j()) {
            return com.liulishuo.filedownloader.FileDownloadServiceProxy.getImpl().setMaxNetworkThreadCount(i);
        }
        com.liulishuo.filedownloader.util.FileDownloadLog.w(this, "Can't change the max network thread count, because there are actively executing tasks in FileDownloader, please try again after all actively executing tasks are completed or invoking FileDownloader#pauseAll directly.", new java.lang.Object[0]);
        return false;
    }

    public boolean setTaskCompleted(java.lang.String str, java.lang.String str2, long j) {
        com.liulishuo.filedownloader.util.FileDownloadLog.w(this, "If you invoked this method, please remove it directly feel free, it doesn't need any longer", new java.lang.Object[0]);
        return true;
    }

    public boolean setTaskCompleted(java.util.List<com.liulishuo.filedownloader.model.FileDownloadTaskAtom> list) {
        com.liulishuo.filedownloader.util.FileDownloadLog.w(this, "If you invoked this method, please remove it directly feel free, it doesn't need any longer", new java.lang.Object[0]);
        return true;
    }

    public boolean start(com.liulishuo.filedownloader.FileDownloadListener fileDownloadListener, boolean z) {
        if (fileDownloadListener != null) {
            return z ? b().startQueueSerial(fileDownloadListener) : b().startQueueParallel(fileDownloadListener);
        }
        com.liulishuo.filedownloader.util.FileDownloadLog.w(this, "Tasks with the listener can't start, because the listener provided is null: [null, %B]", java.lang.Boolean.valueOf(z));
        return false;
    }

    public void startForeground(int i, android.app.Notification notification) {
        com.liulishuo.filedownloader.FileDownloadServiceProxy.getImpl().startForeground(i, notification);
    }

    public void stopForeground(boolean z) {
        com.liulishuo.filedownloader.FileDownloadServiceProxy.getImpl().stopForeground(z);
    }

    public void unBindService() {
        if (isServiceConnected()) {
            com.liulishuo.filedownloader.FileDownloadServiceProxy.getImpl().unbindByContext(com.liulishuo.filedownloader.util.FileDownloadHelper.getAppContext());
        }
    }

    public boolean unBindServiceIfIdle() {
        if (!isServiceConnected() || !com.liulishuo.filedownloader.FileDownloadList.getImpl().j() || !com.liulishuo.filedownloader.FileDownloadServiceProxy.getImpl().isIdle()) {
            return false;
        }
        unBindService();
        return true;
    }
}
