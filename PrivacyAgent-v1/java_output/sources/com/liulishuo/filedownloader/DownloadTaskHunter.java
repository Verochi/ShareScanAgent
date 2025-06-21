package com.liulishuo.filedownloader;

/* loaded from: classes23.dex */
public class DownloadTaskHunter implements com.liulishuo.filedownloader.ITaskHunter, com.liulishuo.filedownloader.ITaskHunter.IStarter, com.liulishuo.filedownloader.ITaskHunter.IMessageHandler, com.liulishuo.filedownloader.BaseDownloadTask.LifeCycleCallback {
    public com.liulishuo.filedownloader.IFileDownloadMessenger a;
    public final java.lang.Object b;
    public final com.liulishuo.filedownloader.DownloadTaskHunter.ICaptureTask c;
    public final com.liulishuo.filedownloader.IDownloadSpeed.Monitor f;
    public final com.liulishuo.filedownloader.IDownloadSpeed.Lookup g;
    public long h;
    public long i;
    public int j;
    public boolean k;
    public boolean l;
    public java.lang.String m;
    public volatile byte d = 0;
    public java.lang.Throwable e = null;
    public boolean n = false;

    public interface ICaptureTask {
        java.util.ArrayList<com.liulishuo.filedownloader.BaseDownloadTask.FinishListener> getFinishListenerList();

        com.liulishuo.filedownloader.model.FileDownloadHeader getHeader();

        com.liulishuo.filedownloader.BaseDownloadTask.IRunningTask getRunningTask();

        void setFileName(java.lang.String str);
    }

    public DownloadTaskHunter(com.liulishuo.filedownloader.DownloadTaskHunter.ICaptureTask iCaptureTask, java.lang.Object obj) {
        this.b = obj;
        this.c = iCaptureTask;
        com.liulishuo.filedownloader.DownloadSpeedMonitor downloadSpeedMonitor = new com.liulishuo.filedownloader.DownloadSpeedMonitor();
        this.f = downloadSpeedMonitor;
        this.g = downloadSpeedMonitor;
        this.a = new com.liulishuo.filedownloader.FileDownloadMessenger(iCaptureTask.getRunningTask(), this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void update(com.liulishuo.filedownloader.message.MessageSnapshot messageSnapshot) {
        com.liulishuo.filedownloader.BaseDownloadTask origin = this.c.getRunningTask().getOrigin();
        byte status = messageSnapshot.getStatus();
        this.d = status;
        this.k = messageSnapshot.isLargeFile();
        if (status == -4) {
            this.f.reset();
            int f = com.liulishuo.filedownloader.FileDownloadList.getImpl().f(origin.getId());
            if (f + ((f > 1 || !origin.isPathAsDirectory()) ? 0 : com.liulishuo.filedownloader.FileDownloadList.getImpl().f(com.liulishuo.filedownloader.util.FileDownloadUtils.generateId(origin.getUrl(), origin.getTargetFilePath()))) <= 1) {
                byte status2 = com.liulishuo.filedownloader.FileDownloadServiceProxy.getImpl().getStatus(origin.getId());
                com.liulishuo.filedownloader.util.FileDownloadLog.w(this, "warn, but no mListener to receive, switch to pending %d %d", java.lang.Integer.valueOf(origin.getId()), java.lang.Integer.valueOf(status2));
                if (com.liulishuo.filedownloader.model.FileDownloadStatus.isIng(status2)) {
                    this.d = (byte) 1;
                    this.i = messageSnapshot.getLargeTotalBytes();
                    long largeSofarBytes = messageSnapshot.getLargeSofarBytes();
                    this.h = largeSofarBytes;
                    this.f.start(largeSofarBytes);
                    this.a.a(((com.liulishuo.filedownloader.message.MessageSnapshot.IWarnMessageSnapshot) messageSnapshot).turnToPending());
                    return;
                }
            }
            com.liulishuo.filedownloader.FileDownloadList.getImpl().remove(this.c.getRunningTask(), messageSnapshot);
            return;
        }
        if (status == -3) {
            this.n = messageSnapshot.isReusedDownloadedFile();
            this.h = messageSnapshot.getLargeTotalBytes();
            this.i = messageSnapshot.getLargeTotalBytes();
            com.liulishuo.filedownloader.FileDownloadList.getImpl().remove(this.c.getRunningTask(), messageSnapshot);
            return;
        }
        if (status == -1) {
            this.e = messageSnapshot.getThrowable();
            this.h = messageSnapshot.getLargeSofarBytes();
            com.liulishuo.filedownloader.FileDownloadList.getImpl().remove(this.c.getRunningTask(), messageSnapshot);
            return;
        }
        if (status == 1) {
            this.h = messageSnapshot.getLargeSofarBytes();
            this.i = messageSnapshot.getLargeTotalBytes();
            this.a.a(messageSnapshot);
            return;
        }
        if (status == 2) {
            this.i = messageSnapshot.getLargeTotalBytes();
            this.l = messageSnapshot.isResuming();
            this.m = messageSnapshot.getEtag();
            java.lang.String fileName = messageSnapshot.getFileName();
            if (fileName != null) {
                if (origin.getFilename() != null) {
                    com.liulishuo.filedownloader.util.FileDownloadLog.w(this, "already has mFilename[%s], but assign mFilename[%s] again", origin.getFilename(), fileName);
                }
                this.c.setFileName(fileName);
            }
            this.f.start(this.h);
            this.a.l(messageSnapshot);
            return;
        }
        if (status == 3) {
            this.h = messageSnapshot.getLargeSofarBytes();
            this.f.update(messageSnapshot.getLargeSofarBytes());
            this.a.d(messageSnapshot);
        } else if (status != 5) {
            if (status != 6) {
                return;
            }
            this.a.b(messageSnapshot);
        } else {
            this.h = messageSnapshot.getLargeSofarBytes();
            this.e = messageSnapshot.getThrowable();
            this.j = messageSnapshot.getRetryingTimes();
            this.f.reset();
            this.a.k(messageSnapshot);
        }
    }

    public final int a() {
        return this.c.getRunningTask().getOrigin().getId();
    }

    public final void b() throws java.io.IOException {
        java.io.File file;
        com.liulishuo.filedownloader.BaseDownloadTask origin = this.c.getRunningTask().getOrigin();
        if (origin.getPath() == null) {
            origin.setPath(com.liulishuo.filedownloader.util.FileDownloadUtils.getDefaultSaveFilePath(origin.getUrl()));
            if (com.liulishuo.filedownloader.util.FileDownloadLog.NEED_LOG) {
                com.liulishuo.filedownloader.util.FileDownloadLog.d(this, "save Path is null to %s", origin.getPath());
            }
        }
        if (origin.isPathAsDirectory()) {
            file = new java.io.File(origin.getPath());
        } else {
            java.lang.String parent = com.liulishuo.filedownloader.util.FileDownloadUtils.getParent(origin.getPath());
            if (parent == null) {
                throw new java.security.InvalidParameterException(com.liulishuo.filedownloader.util.FileDownloadUtils.formatString("the provided mPath[%s] is invalid, can't find its directory", origin.getPath()));
            }
            file = new java.io.File(parent);
        }
        if (!file.exists() && !file.mkdirs() && !file.exists()) {
            throw new java.io.IOException(com.liulishuo.filedownloader.util.FileDownloadUtils.formatString("Create parent directory failed, please make sure you have permission to create file or directory on the path: %s", file.getAbsolutePath()));
        }
    }

    @Override // com.liulishuo.filedownloader.ITaskHunter.IStarter
    public boolean equalListener(com.liulishuo.filedownloader.FileDownloadListener fileDownloadListener) {
        return this.c.getRunningTask().getOrigin().getListener() == fileDownloadListener;
    }

    @Override // com.liulishuo.filedownloader.ITaskHunter
    public void free() {
        if (com.liulishuo.filedownloader.util.FileDownloadLog.NEED_LOG) {
            com.liulishuo.filedownloader.util.FileDownloadLog.d(this, "free the task %d, when the status is %d", java.lang.Integer.valueOf(a()), java.lang.Byte.valueOf(this.d));
        }
        this.d = (byte) 0;
    }

    @Override // com.liulishuo.filedownloader.ITaskHunter
    public java.lang.Throwable getErrorCause() {
        return this.e;
    }

    @Override // com.liulishuo.filedownloader.ITaskHunter
    public java.lang.String getEtag() {
        return this.m;
    }

    @Override // com.liulishuo.filedownloader.ITaskHunter.IMessageHandler
    public com.liulishuo.filedownloader.IFileDownloadMessenger getMessenger() {
        return this.a;
    }

    @Override // com.liulishuo.filedownloader.ITaskHunter
    public int getRetryingTimes() {
        return this.j;
    }

    @Override // com.liulishuo.filedownloader.ITaskHunter
    public long getSofarBytes() {
        return this.h;
    }

    @Override // com.liulishuo.filedownloader.IDownloadSpeed.Lookup
    public int getSpeed() {
        return this.g.getSpeed();
    }

    @Override // com.liulishuo.filedownloader.ITaskHunter
    public byte getStatus() {
        return this.d;
    }

    @Override // com.liulishuo.filedownloader.ITaskHunter
    public long getTotalBytes() {
        return this.i;
    }

    @Override // com.liulishuo.filedownloader.ITaskHunter
    public void intoLaunchPool() {
        boolean z;
        synchronized (this.b) {
            if (this.d != 0) {
                com.liulishuo.filedownloader.util.FileDownloadLog.w(this, "High concurrent cause, this task %d will not input to launch pool, because of the status isn't idle : %d", java.lang.Integer.valueOf(a()), java.lang.Byte.valueOf(this.d));
                return;
            }
            this.d = (byte) 10;
            com.liulishuo.filedownloader.BaseDownloadTask.IRunningTask runningTask = this.c.getRunningTask();
            com.liulishuo.filedownloader.BaseDownloadTask origin = runningTask.getOrigin();
            if (com.liulishuo.filedownloader.FileDownloadMonitor.isValid()) {
                com.liulishuo.filedownloader.FileDownloadMonitor.getMonitor().onRequestStart(origin);
            }
            if (com.liulishuo.filedownloader.util.FileDownloadLog.NEED_LOG) {
                com.liulishuo.filedownloader.util.FileDownloadLog.v(this, "call start Url[%s], Path[%s] Listener[%s], Tag[%s]", origin.getUrl(), origin.getPath(), origin.getListener(), origin.getTag());
            }
            try {
                b();
                z = true;
            } catch (java.lang.Throwable th) {
                com.liulishuo.filedownloader.FileDownloadList.getImpl().a(runningTask);
                com.liulishuo.filedownloader.FileDownloadList.getImpl().remove(runningTask, prepareErrorMessage(th));
                z = false;
            }
            if (z) {
                com.liulishuo.filedownloader.FileDownloadTaskLauncher.d().e(this);
            }
            if (com.liulishuo.filedownloader.util.FileDownloadLog.NEED_LOG) {
                com.liulishuo.filedownloader.util.FileDownloadLog.v(this, "the task[%d] has been into the launch pool.", java.lang.Integer.valueOf(a()));
            }
        }
    }

    @Override // com.liulishuo.filedownloader.ITaskHunter
    public boolean isLargeFile() {
        return this.k;
    }

    @Override // com.liulishuo.filedownloader.ITaskHunter
    public boolean isResuming() {
        return this.l;
    }

    @Override // com.liulishuo.filedownloader.ITaskHunter
    public boolean isReusedOldFile() {
        return this.n;
    }

    @Override // com.liulishuo.filedownloader.BaseDownloadTask.LifeCycleCallback
    public void onBegin() {
        if (com.liulishuo.filedownloader.FileDownloadMonitor.isValid()) {
            com.liulishuo.filedownloader.FileDownloadMonitor.getMonitor().onTaskBegin(this.c.getRunningTask().getOrigin());
        }
        if (com.liulishuo.filedownloader.util.FileDownloadLog.NEED_LOG) {
            com.liulishuo.filedownloader.util.FileDownloadLog.v(this, "filedownloader:lifecycle:start %s by %d ", toString(), java.lang.Byte.valueOf(getStatus()));
        }
    }

    @Override // com.liulishuo.filedownloader.BaseDownloadTask.LifeCycleCallback
    public void onIng() {
        if (com.liulishuo.filedownloader.FileDownloadMonitor.isValid() && getStatus() == 6) {
            com.liulishuo.filedownloader.FileDownloadMonitor.getMonitor().onTaskStarted(this.c.getRunningTask().getOrigin());
        }
    }

    @Override // com.liulishuo.filedownloader.BaseDownloadTask.LifeCycleCallback
    public void onOver() {
        com.liulishuo.filedownloader.BaseDownloadTask origin = this.c.getRunningTask().getOrigin();
        if (com.liulishuo.filedownloader.FileDownloadMonitor.isValid()) {
            com.liulishuo.filedownloader.FileDownloadMonitor.getMonitor().onTaskOver(origin);
        }
        if (com.liulishuo.filedownloader.util.FileDownloadLog.NEED_LOG) {
            com.liulishuo.filedownloader.util.FileDownloadLog.v(this, "filedownloader:lifecycle:over %s by %d ", toString(), java.lang.Byte.valueOf(getStatus()));
        }
        this.f.end(this.h);
        if (this.c.getFinishListenerList() != null) {
            java.util.ArrayList arrayList = (java.util.ArrayList) this.c.getFinishListenerList().clone();
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                ((com.liulishuo.filedownloader.BaseDownloadTask.FinishListener) arrayList.get(i)).over(origin);
            }
        }
        com.liulishuo.filedownloader.FileDownloader.getImpl().a().taskWorkFine(this.c.getRunningTask());
    }

    @Override // com.liulishuo.filedownloader.ITaskHunter
    public boolean pause() {
        if (com.liulishuo.filedownloader.model.FileDownloadStatus.isOver(getStatus())) {
            if (com.liulishuo.filedownloader.util.FileDownloadLog.NEED_LOG) {
                com.liulishuo.filedownloader.util.FileDownloadLog.d(this, "High concurrent cause, Already is over, can't pause again, %d %d", java.lang.Byte.valueOf(getStatus()), java.lang.Integer.valueOf(this.c.getRunningTask().getOrigin().getId()));
            }
            return false;
        }
        this.d = (byte) -2;
        com.liulishuo.filedownloader.BaseDownloadTask.IRunningTask runningTask = this.c.getRunningTask();
        com.liulishuo.filedownloader.BaseDownloadTask origin = runningTask.getOrigin();
        com.liulishuo.filedownloader.FileDownloadTaskLauncher.d().b(this);
        if (com.liulishuo.filedownloader.util.FileDownloadLog.NEED_LOG) {
            com.liulishuo.filedownloader.util.FileDownloadLog.v(this, "the task[%d] has been expired from the launch pool.", java.lang.Integer.valueOf(a()));
        }
        if (com.liulishuo.filedownloader.FileDownloader.getImpl().isServiceConnected()) {
            com.liulishuo.filedownloader.FileDownloadServiceProxy.getImpl().pause(origin.getId());
        } else if (com.liulishuo.filedownloader.util.FileDownloadLog.NEED_LOG) {
            com.liulishuo.filedownloader.util.FileDownloadLog.d(this, "request pause the task[%d] to the download service, but the download service isn't connected yet.", java.lang.Integer.valueOf(origin.getId()));
        }
        com.liulishuo.filedownloader.FileDownloadList.getImpl().a(runningTask);
        com.liulishuo.filedownloader.FileDownloadList.getImpl().remove(runningTask, com.liulishuo.filedownloader.message.MessageSnapshotTaker.catchPause(origin));
        com.liulishuo.filedownloader.FileDownloader.getImpl().a().taskWorkFine(runningTask);
        return true;
    }

    @Override // com.liulishuo.filedownloader.ITaskHunter.IMessageHandler
    public com.liulishuo.filedownloader.message.MessageSnapshot prepareErrorMessage(java.lang.Throwable th) {
        this.d = (byte) -1;
        this.e = th;
        return com.liulishuo.filedownloader.message.MessageSnapshotTaker.catchException(a(), getSofarBytes(), th);
    }

    @Override // com.liulishuo.filedownloader.ITaskHunter
    public void reset() {
        this.e = null;
        this.m = null;
        this.l = false;
        this.j = 0;
        this.n = false;
        this.k = false;
        this.h = 0L;
        this.i = 0L;
        this.f.reset();
        if (com.liulishuo.filedownloader.model.FileDownloadStatus.isOver(this.d)) {
            this.a.g();
            this.a = new com.liulishuo.filedownloader.FileDownloadMessenger(this.c.getRunningTask(), this);
        } else {
            this.a.e(this.c.getRunningTask(), this);
        }
        this.d = (byte) 0;
    }

    @Override // com.liulishuo.filedownloader.IDownloadSpeed.Lookup
    public void setMinIntervalUpdateSpeed(int i) {
        this.g.setMinIntervalUpdateSpeed(i);
    }

    @Override // com.liulishuo.filedownloader.ITaskHunter.IStarter
    public void start() {
        if (this.d != 10) {
            com.liulishuo.filedownloader.util.FileDownloadLog.w(this, "High concurrent cause, this task %d will not start, because the of status isn't toLaunchPool: %d", java.lang.Integer.valueOf(a()), java.lang.Byte.valueOf(this.d));
            return;
        }
        com.liulishuo.filedownloader.BaseDownloadTask.IRunningTask runningTask = this.c.getRunningTask();
        com.liulishuo.filedownloader.BaseDownloadTask origin = runningTask.getOrigin();
        com.liulishuo.filedownloader.ILostServiceConnectedHandler a = com.liulishuo.filedownloader.FileDownloader.getImpl().a();
        try {
            if (a.dispatchTaskStart(runningTask)) {
                return;
            }
            synchronized (this.b) {
                if (this.d != 10) {
                    com.liulishuo.filedownloader.util.FileDownloadLog.w(this, "High concurrent cause, this task %d will not start, the status can't assign to toFileDownloadService, because the status isn't toLaunchPool: %d", java.lang.Integer.valueOf(a()), java.lang.Byte.valueOf(this.d));
                    return;
                }
                this.d = (byte) 11;
                com.liulishuo.filedownloader.FileDownloadList.getImpl().a(runningTask);
                if (com.liulishuo.filedownloader.util.FileDownloadHelper.inspectAndInflowDownloaded(origin.getId(), origin.getTargetFilePath(), origin.isForceReDownload(), true)) {
                    return;
                }
                boolean start = com.liulishuo.filedownloader.FileDownloadServiceProxy.getImpl().start(origin.getUrl(), origin.getPath(), origin.isPathAsDirectory(), origin.getCallbackProgressTimes(), origin.getCallbackProgressMinInterval(), origin.getAutoRetryTimes(), origin.isForceReDownload(), this.c.getHeader(), origin.isWifiRequired());
                if (this.d == -2) {
                    com.liulishuo.filedownloader.util.FileDownloadLog.w(this, "High concurrent cause, this task %d will be paused,because of the status is paused, so the pause action must be applied", java.lang.Integer.valueOf(a()));
                    if (start) {
                        com.liulishuo.filedownloader.FileDownloadServiceProxy.getImpl().pause(a());
                        return;
                    }
                    return;
                }
                if (start) {
                    a.taskWorkFine(runningTask);
                    return;
                }
                if (a.dispatchTaskStart(runningTask)) {
                    return;
                }
                com.liulishuo.filedownloader.message.MessageSnapshot prepareErrorMessage = prepareErrorMessage(new java.lang.RuntimeException("Occur Unknown Error, when request to start maybe some problem in binder, maybe the process was killed in unexpected."));
                if (com.liulishuo.filedownloader.FileDownloadList.getImpl().k(runningTask)) {
                    a.taskWorkFine(runningTask);
                    com.liulishuo.filedownloader.FileDownloadList.getImpl().a(runningTask);
                }
                com.liulishuo.filedownloader.FileDownloadList.getImpl().remove(runningTask, prepareErrorMessage);
            }
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            com.liulishuo.filedownloader.FileDownloadList.getImpl().remove(runningTask, prepareErrorMessage(th));
        }
    }

    @Override // com.liulishuo.filedownloader.ITaskHunter.IMessageHandler
    public boolean updateKeepAhead(com.liulishuo.filedownloader.message.MessageSnapshot messageSnapshot) {
        if (com.liulishuo.filedownloader.model.FileDownloadStatus.isKeepAhead(getStatus(), messageSnapshot.getStatus())) {
            update(messageSnapshot);
            return true;
        }
        if (com.liulishuo.filedownloader.util.FileDownloadLog.NEED_LOG) {
            com.liulishuo.filedownloader.util.FileDownloadLog.d(this, "can't update mStatus change by keep ahead, %d, but the current mStatus is %d, %d", java.lang.Byte.valueOf(this.d), java.lang.Byte.valueOf(getStatus()), java.lang.Integer.valueOf(a()));
        }
        return false;
    }

    @Override // com.liulishuo.filedownloader.ITaskHunter.IMessageHandler
    public boolean updateKeepFlow(com.liulishuo.filedownloader.message.MessageSnapshot messageSnapshot) {
        byte status = getStatus();
        byte status2 = messageSnapshot.getStatus();
        if (-2 == status && com.liulishuo.filedownloader.model.FileDownloadStatus.isIng(status2)) {
            if (com.liulishuo.filedownloader.util.FileDownloadLog.NEED_LOG) {
                com.liulishuo.filedownloader.util.FileDownloadLog.d(this, "High concurrent cause, callback pending, but has already be paused %d", java.lang.Integer.valueOf(a()));
            }
            return true;
        }
        if (com.liulishuo.filedownloader.model.FileDownloadStatus.isKeepFlow(status, status2)) {
            update(messageSnapshot);
            return true;
        }
        if (com.liulishuo.filedownloader.util.FileDownloadLog.NEED_LOG) {
            com.liulishuo.filedownloader.util.FileDownloadLog.d(this, "can't update mStatus change by keep flow, %d, but the current mStatus is %d, %d", java.lang.Byte.valueOf(this.d), java.lang.Byte.valueOf(getStatus()), java.lang.Integer.valueOf(a()));
        }
        return false;
    }

    @Override // com.liulishuo.filedownloader.ITaskHunter.IMessageHandler
    public boolean updateMoreLikelyCompleted(com.liulishuo.filedownloader.message.MessageSnapshot messageSnapshot) {
        if (!com.liulishuo.filedownloader.model.FileDownloadStatus.isMoreLikelyCompleted(this.c.getRunningTask().getOrigin())) {
            return false;
        }
        update(messageSnapshot);
        return true;
    }

    @Override // com.liulishuo.filedownloader.ITaskHunter.IMessageHandler
    public boolean updateSameFilePathTaskRunning(com.liulishuo.filedownloader.message.MessageSnapshot messageSnapshot) {
        if (!this.c.getRunningTask().getOrigin().isPathAsDirectory() || messageSnapshot.getStatus() != -4 || getStatus() != 2) {
            return false;
        }
        update(messageSnapshot);
        return true;
    }
}
