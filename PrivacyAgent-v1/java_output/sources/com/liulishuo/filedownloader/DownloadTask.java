package com.liulishuo.filedownloader;

/* loaded from: classes23.dex */
public class DownloadTask implements com.liulishuo.filedownloader.BaseDownloadTask, com.liulishuo.filedownloader.BaseDownloadTask.IRunningTask, com.liulishuo.filedownloader.DownloadTaskHunter.ICaptureTask {
    public static final int DEFAULT_CALLBACK_PROGRESS_MIN_INTERVAL_MILLIS = 10;
    public final com.liulishuo.filedownloader.ITaskHunter a;
    public final com.liulishuo.filedownloader.ITaskHunter.IMessageHandler b;
    public int c;
    public java.util.ArrayList<com.liulishuo.filedownloader.BaseDownloadTask.FinishListener> d;
    public final java.lang.String e;
    public java.lang.String f;
    public java.lang.String g;
    public boolean h;
    public com.liulishuo.filedownloader.model.FileDownloadHeader i;
    public com.liulishuo.filedownloader.FileDownloadListener j;
    public android.util.SparseArray<java.lang.Object> k;
    public java.lang.Object l;
    public final java.lang.Object u;
    public int m = 0;
    public boolean n = false;
    public boolean o = false;
    public int p = 100;
    public int q = 10;
    public boolean r = false;

    /* renamed from: s, reason: collision with root package name */
    public volatile int f396s = 0;
    public boolean t = false;
    public final java.lang.Object v = new java.lang.Object();
    public volatile boolean w = false;

    public static final class InQueueTaskImpl implements com.liulishuo.filedownloader.BaseDownloadTask.InQueueTask {
        public final com.liulishuo.filedownloader.DownloadTask a;

        public InQueueTaskImpl(com.liulishuo.filedownloader.DownloadTask downloadTask) {
            this.a = downloadTask;
            downloadTask.t = true;
        }

        public /* synthetic */ InQueueTaskImpl(com.liulishuo.filedownloader.DownloadTask downloadTask, com.liulishuo.filedownloader.DownloadTask.AnonymousClass1 anonymousClass1) {
            this(downloadTask);
        }

        @Override // com.liulishuo.filedownloader.BaseDownloadTask.InQueueTask
        public int enqueue() {
            int id = this.a.getId();
            if (com.liulishuo.filedownloader.util.FileDownloadLog.NEED_LOG) {
                com.liulishuo.filedownloader.util.FileDownloadLog.d(this, "add the task[%d] to the queue", java.lang.Integer.valueOf(id));
            }
            com.liulishuo.filedownloader.FileDownloadList.getImpl().b(this.a);
            return id;
        }
    }

    public DownloadTask(java.lang.String str) {
        this.e = str;
        java.lang.Object obj = new java.lang.Object();
        this.u = obj;
        com.liulishuo.filedownloader.DownloadTaskHunter downloadTaskHunter = new com.liulishuo.filedownloader.DownloadTaskHunter(this, obj);
        this.a = downloadTaskHunter;
        this.b = downloadTaskHunter;
    }

    @Override // com.liulishuo.filedownloader.BaseDownloadTask
    public com.liulishuo.filedownloader.BaseDownloadTask addFinishListener(com.liulishuo.filedownloader.BaseDownloadTask.FinishListener finishListener) {
        if (this.d == null) {
            this.d = new java.util.ArrayList<>();
        }
        if (!this.d.contains(finishListener)) {
            this.d.add(finishListener);
        }
        return this;
    }

    @Override // com.liulishuo.filedownloader.BaseDownloadTask
    public com.liulishuo.filedownloader.BaseDownloadTask addHeader(java.lang.String str) {
        b();
        this.i.add(str);
        return this;
    }

    @Override // com.liulishuo.filedownloader.BaseDownloadTask
    public com.liulishuo.filedownloader.BaseDownloadTask addHeader(java.lang.String str, java.lang.String str2) {
        b();
        this.i.add(str, str2);
        return this;
    }

    @Override // com.liulishuo.filedownloader.BaseDownloadTask
    public com.liulishuo.filedownloader.BaseDownloadTask.InQueueTask asInQueueTask() {
        return new com.liulishuo.filedownloader.DownloadTask.InQueueTaskImpl(this, null);
    }

    public final void b() {
        if (this.i == null) {
            synchronized (this.v) {
                if (this.i == null) {
                    this.i = new com.liulishuo.filedownloader.model.FileDownloadHeader();
                }
            }
        }
    }

    public final int c() {
        if (!isUsing()) {
            if (!isAttached()) {
                setAttachKeyDefault();
            }
            this.a.intoLaunchPool();
            return getId();
        }
        if (isRunning()) {
            throw new java.lang.IllegalStateException(com.liulishuo.filedownloader.util.FileDownloadUtils.formatString("This task is running %d, if you want to start the same task, please create a new one by FileDownloader.create", java.lang.Integer.valueOf(getId())));
        }
        throw new java.lang.IllegalStateException("This task is dirty to restart, If you want to reuse this task, please invoke #reuse method manually and retry to restart again." + this.a.toString());
    }

    @Override // com.liulishuo.filedownloader.BaseDownloadTask
    public boolean cancel() {
        return pause();
    }

    @Override // com.liulishuo.filedownloader.BaseDownloadTask.IRunningTask
    public void free() {
        this.a.free();
        if (com.liulishuo.filedownloader.FileDownloadList.getImpl().k(this)) {
            this.w = false;
        }
    }

    @Override // com.liulishuo.filedownloader.BaseDownloadTask.IRunningTask
    public int getAttachKey() {
        return this.f396s;
    }

    @Override // com.liulishuo.filedownloader.BaseDownloadTask
    public int getAutoRetryTimes() {
        return this.m;
    }

    @Override // com.liulishuo.filedownloader.BaseDownloadTask
    public int getCallbackProgressMinInterval() {
        return this.q;
    }

    @Override // com.liulishuo.filedownloader.BaseDownloadTask
    public int getCallbackProgressTimes() {
        return this.p;
    }

    @Override // com.liulishuo.filedownloader.BaseDownloadTask
    public int getDownloadId() {
        return getId();
    }

    @Override // com.liulishuo.filedownloader.BaseDownloadTask
    public java.lang.Throwable getErrorCause() {
        return this.a.getErrorCause();
    }

    @Override // com.liulishuo.filedownloader.BaseDownloadTask
    public java.lang.String getEtag() {
        return this.a.getEtag();
    }

    @Override // com.liulishuo.filedownloader.BaseDownloadTask
    public java.lang.Throwable getEx() {
        return getErrorCause();
    }

    @Override // com.liulishuo.filedownloader.BaseDownloadTask
    public java.lang.String getFilename() {
        return this.g;
    }

    @Override // com.liulishuo.filedownloader.DownloadTaskHunter.ICaptureTask
    public java.util.ArrayList<com.liulishuo.filedownloader.BaseDownloadTask.FinishListener> getFinishListenerList() {
        return this.d;
    }

    @Override // com.liulishuo.filedownloader.DownloadTaskHunter.ICaptureTask
    public com.liulishuo.filedownloader.model.FileDownloadHeader getHeader() {
        return this.i;
    }

    @Override // com.liulishuo.filedownloader.BaseDownloadTask
    public int getId() {
        int i = this.c;
        if (i != 0) {
            return i;
        }
        if (android.text.TextUtils.isEmpty(this.f) || android.text.TextUtils.isEmpty(this.e)) {
            return 0;
        }
        int generateId = com.liulishuo.filedownloader.util.FileDownloadUtils.generateId(this.e, this.f, this.h);
        this.c = generateId;
        return generateId;
    }

    @Override // com.liulishuo.filedownloader.BaseDownloadTask
    public long getLargeFileSoFarBytes() {
        return this.a.getSofarBytes();
    }

    @Override // com.liulishuo.filedownloader.BaseDownloadTask
    public long getLargeFileTotalBytes() {
        return this.a.getTotalBytes();
    }

    @Override // com.liulishuo.filedownloader.BaseDownloadTask
    public com.liulishuo.filedownloader.FileDownloadListener getListener() {
        return this.j;
    }

    @Override // com.liulishuo.filedownloader.BaseDownloadTask.IRunningTask
    public com.liulishuo.filedownloader.ITaskHunter.IMessageHandler getMessageHandler() {
        return this.b;
    }

    @Override // com.liulishuo.filedownloader.BaseDownloadTask.IRunningTask
    public com.liulishuo.filedownloader.BaseDownloadTask getOrigin() {
        return this;
    }

    @Override // com.liulishuo.filedownloader.BaseDownloadTask
    public java.lang.String getPath() {
        return this.f;
    }

    @Override // com.liulishuo.filedownloader.BaseDownloadTask.IRunningTask
    public java.lang.Object getPauseLock() {
        return this.u;
    }

    @Override // com.liulishuo.filedownloader.BaseDownloadTask
    public int getRetryingTimes() {
        return this.a.getRetryingTimes();
    }

    @Override // com.liulishuo.filedownloader.DownloadTaskHunter.ICaptureTask
    public com.liulishuo.filedownloader.BaseDownloadTask.IRunningTask getRunningTask() {
        return this;
    }

    @Override // com.liulishuo.filedownloader.BaseDownloadTask
    public int getSmallFileSoFarBytes() {
        if (this.a.getSofarBytes() > 2147483647L) {
            return Integer.MAX_VALUE;
        }
        return (int) this.a.getSofarBytes();
    }

    @Override // com.liulishuo.filedownloader.BaseDownloadTask
    public int getSmallFileTotalBytes() {
        if (this.a.getTotalBytes() > 2147483647L) {
            return Integer.MAX_VALUE;
        }
        return (int) this.a.getTotalBytes();
    }

    @Override // com.liulishuo.filedownloader.BaseDownloadTask
    public int getSoFarBytes() {
        return getSmallFileSoFarBytes();
    }

    @Override // com.liulishuo.filedownloader.BaseDownloadTask
    public int getSpeed() {
        return this.a.getSpeed();
    }

    @Override // com.liulishuo.filedownloader.BaseDownloadTask
    public byte getStatus() {
        return this.a.getStatus();
    }

    @Override // com.liulishuo.filedownloader.BaseDownloadTask
    public java.lang.Object getTag() {
        return this.l;
    }

    @Override // com.liulishuo.filedownloader.BaseDownloadTask
    public java.lang.Object getTag(int i) {
        android.util.SparseArray<java.lang.Object> sparseArray = this.k;
        if (sparseArray == null) {
            return null;
        }
        return sparseArray.get(i);
    }

    @Override // com.liulishuo.filedownloader.BaseDownloadTask
    public java.lang.String getTargetFilePath() {
        return com.liulishuo.filedownloader.util.FileDownloadUtils.getTargetFilePath(getPath(), isPathAsDirectory(), getFilename());
    }

    @Override // com.liulishuo.filedownloader.BaseDownloadTask
    public int getTotalBytes() {
        return getSmallFileTotalBytes();
    }

    @Override // com.liulishuo.filedownloader.BaseDownloadTask
    public java.lang.String getUrl() {
        return this.e;
    }

    @Override // com.liulishuo.filedownloader.BaseDownloadTask.IRunningTask
    public boolean is(int i) {
        return getId() == i;
    }

    @Override // com.liulishuo.filedownloader.BaseDownloadTask.IRunningTask
    public boolean is(com.liulishuo.filedownloader.FileDownloadListener fileDownloadListener) {
        return getListener() == fileDownloadListener;
    }

    @Override // com.liulishuo.filedownloader.BaseDownloadTask
    public boolean isAttached() {
        return this.f396s != 0;
    }

    @Override // com.liulishuo.filedownloader.BaseDownloadTask.IRunningTask
    public boolean isContainFinishListener() {
        java.util.ArrayList<com.liulishuo.filedownloader.BaseDownloadTask.FinishListener> arrayList = this.d;
        return arrayList != null && arrayList.size() > 0;
    }

    @Override // com.liulishuo.filedownloader.BaseDownloadTask
    public boolean isContinue() {
        return isResuming();
    }

    @Override // com.liulishuo.filedownloader.BaseDownloadTask
    public boolean isForceReDownload() {
        return this.r;
    }

    @Override // com.liulishuo.filedownloader.BaseDownloadTask
    public boolean isLargeFile() {
        return this.a.isLargeFile();
    }

    @Override // com.liulishuo.filedownloader.BaseDownloadTask.IRunningTask
    public boolean isMarkedAdded2List() {
        return this.w;
    }

    @Override // com.liulishuo.filedownloader.BaseDownloadTask.IRunningTask
    public boolean isOver() {
        return com.liulishuo.filedownloader.model.FileDownloadStatus.isOver(getStatus());
    }

    @Override // com.liulishuo.filedownloader.BaseDownloadTask
    public boolean isPathAsDirectory() {
        return this.h;
    }

    @Override // com.liulishuo.filedownloader.BaseDownloadTask
    public boolean isResuming() {
        return this.a.isResuming();
    }

    @Override // com.liulishuo.filedownloader.BaseDownloadTask
    public boolean isReusedOldFile() {
        return this.a.isReusedOldFile();
    }

    @Override // com.liulishuo.filedownloader.BaseDownloadTask
    public boolean isRunning() {
        if (com.liulishuo.filedownloader.FileDownloader.getImpl().a().isInWaitingList(this)) {
            return true;
        }
        return com.liulishuo.filedownloader.model.FileDownloadStatus.isIng(getStatus());
    }

    @Override // com.liulishuo.filedownloader.BaseDownloadTask
    public boolean isSyncCallback() {
        return this.n;
    }

    @Override // com.liulishuo.filedownloader.BaseDownloadTask
    public boolean isUsing() {
        return this.a.getStatus() != 0;
    }

    @Override // com.liulishuo.filedownloader.BaseDownloadTask
    public boolean isWifiRequired() {
        return this.o;
    }

    @Override // com.liulishuo.filedownloader.BaseDownloadTask.IRunningTask
    public void markAdded2List() {
        this.w = true;
    }

    @Override // com.liulishuo.filedownloader.BaseDownloadTask
    public boolean pause() {
        boolean pause;
        synchronized (this.u) {
            pause = this.a.pause();
        }
        return pause;
    }

    @Override // com.liulishuo.filedownloader.BaseDownloadTask
    public int ready() {
        return asInQueueTask().enqueue();
    }

    @Override // com.liulishuo.filedownloader.BaseDownloadTask
    public com.liulishuo.filedownloader.BaseDownloadTask removeAllHeaders(java.lang.String str) {
        if (this.i == null) {
            synchronized (this.v) {
                if (this.i == null) {
                    return this;
                }
            }
        }
        this.i.removeAll(str);
        return this;
    }

    @Override // com.liulishuo.filedownloader.BaseDownloadTask
    public boolean removeFinishListener(com.liulishuo.filedownloader.BaseDownloadTask.FinishListener finishListener) {
        java.util.ArrayList<com.liulishuo.filedownloader.BaseDownloadTask.FinishListener> arrayList = this.d;
        return arrayList != null && arrayList.remove(finishListener);
    }

    @Override // com.liulishuo.filedownloader.BaseDownloadTask
    public boolean reuse() {
        if (isRunning()) {
            com.liulishuo.filedownloader.util.FileDownloadLog.w(this, "This task[%d] is running, if you want start the same task, please create a new one by FileDownloader#create", java.lang.Integer.valueOf(getId()));
            return false;
        }
        this.f396s = 0;
        this.t = false;
        this.w = false;
        this.a.reset();
        return true;
    }

    @Override // com.liulishuo.filedownloader.BaseDownloadTask.IRunningTask
    public void setAttachKeyByQueue(int i) {
        this.f396s = i;
    }

    @Override // com.liulishuo.filedownloader.BaseDownloadTask.IRunningTask
    public void setAttachKeyDefault() {
        this.f396s = getListener() != null ? getListener().hashCode() : hashCode();
    }

    @Override // com.liulishuo.filedownloader.BaseDownloadTask
    public com.liulishuo.filedownloader.BaseDownloadTask setAutoRetryTimes(int i) {
        this.m = i;
        return this;
    }

    @Override // com.liulishuo.filedownloader.BaseDownloadTask
    public com.liulishuo.filedownloader.BaseDownloadTask setCallbackProgressIgnored() {
        return setCallbackProgressTimes(-1);
    }

    @Override // com.liulishuo.filedownloader.BaseDownloadTask
    public com.liulishuo.filedownloader.BaseDownloadTask setCallbackProgressMinInterval(int i) {
        this.q = i;
        return this;
    }

    @Override // com.liulishuo.filedownloader.BaseDownloadTask
    public com.liulishuo.filedownloader.BaseDownloadTask setCallbackProgressTimes(int i) {
        this.p = i;
        return this;
    }

    @Override // com.liulishuo.filedownloader.DownloadTaskHunter.ICaptureTask
    public void setFileName(java.lang.String str) {
        this.g = str;
    }

    @Override // com.liulishuo.filedownloader.BaseDownloadTask
    public com.liulishuo.filedownloader.BaseDownloadTask setFinishListener(com.liulishuo.filedownloader.BaseDownloadTask.FinishListener finishListener) {
        addFinishListener(finishListener);
        return this;
    }

    @Override // com.liulishuo.filedownloader.BaseDownloadTask
    public com.liulishuo.filedownloader.BaseDownloadTask setForceReDownload(boolean z) {
        this.r = z;
        return this;
    }

    @Override // com.liulishuo.filedownloader.BaseDownloadTask
    public com.liulishuo.filedownloader.BaseDownloadTask setListener(com.liulishuo.filedownloader.FileDownloadListener fileDownloadListener) {
        this.j = fileDownloadListener;
        if (com.liulishuo.filedownloader.util.FileDownloadLog.NEED_LOG) {
            com.liulishuo.filedownloader.util.FileDownloadLog.d(this, "setListener %s", fileDownloadListener);
        }
        return this;
    }

    @Override // com.liulishuo.filedownloader.BaseDownloadTask
    public com.liulishuo.filedownloader.BaseDownloadTask setMinIntervalUpdateSpeed(int i) {
        this.a.setMinIntervalUpdateSpeed(i);
        return this;
    }

    @Override // com.liulishuo.filedownloader.BaseDownloadTask
    public com.liulishuo.filedownloader.BaseDownloadTask setPath(java.lang.String str) {
        return setPath(str, false);
    }

    @Override // com.liulishuo.filedownloader.BaseDownloadTask
    public com.liulishuo.filedownloader.BaseDownloadTask setPath(java.lang.String str, boolean z) {
        this.f = str;
        if (com.liulishuo.filedownloader.util.FileDownloadLog.NEED_LOG) {
            com.liulishuo.filedownloader.util.FileDownloadLog.d(this, "setPath %s", str);
        }
        this.h = z;
        if (z) {
            this.g = null;
        } else {
            this.g = new java.io.File(str).getName();
        }
        return this;
    }

    @Override // com.liulishuo.filedownloader.BaseDownloadTask
    public com.liulishuo.filedownloader.BaseDownloadTask setSyncCallback(boolean z) {
        this.n = z;
        return this;
    }

    @Override // com.liulishuo.filedownloader.BaseDownloadTask
    public com.liulishuo.filedownloader.BaseDownloadTask setTag(int i, java.lang.Object obj) {
        if (this.k == null) {
            this.k = new android.util.SparseArray<>(2);
        }
        this.k.put(i, obj);
        return this;
    }

    @Override // com.liulishuo.filedownloader.BaseDownloadTask
    public com.liulishuo.filedownloader.BaseDownloadTask setTag(java.lang.Object obj) {
        this.l = obj;
        if (com.liulishuo.filedownloader.util.FileDownloadLog.NEED_LOG) {
            com.liulishuo.filedownloader.util.FileDownloadLog.d(this, "setTag %s", obj);
        }
        return this;
    }

    @Override // com.liulishuo.filedownloader.BaseDownloadTask
    public com.liulishuo.filedownloader.BaseDownloadTask setWifiRequired(boolean z) {
        this.o = z;
        return this;
    }

    @Override // com.liulishuo.filedownloader.BaseDownloadTask
    public int start() {
        if (this.t) {
            throw new java.lang.IllegalStateException("If you start the task manually, it means this task doesn't belong to a queue, so you must not invoke BaseDownloadTask#ready() or InQueueTask#enqueue() before you start() this method. For detail: If this task doesn't belong to a queue, what is just an isolated task, you just need to invoke BaseDownloadTask#start() to start this task, that's all. In other words, If this task doesn't belong to a queue, you must not invoke BaseDownloadTask#ready() method or InQueueTask#enqueue() method before invoke BaseDownloadTask#start(), If you do that and if there is the same listener object to start a queue in another thread, this task may be assembled by the queue, in that case, when you invoke BaseDownloadTask#start() manually to start this task or this task is started by the queue, there is an exception buried in there, because this task object is started two times without declare BaseDownloadTask#reuse() : 1. you invoke BaseDownloadTask#start() manually;  2. the queue start this task automatically.");
        }
        return c();
    }

    @Override // com.liulishuo.filedownloader.BaseDownloadTask.IRunningTask
    public void startTaskByQueue() {
        c();
    }

    @Override // com.liulishuo.filedownloader.BaseDownloadTask.IRunningTask
    public void startTaskByRescue() {
        c();
    }

    public java.lang.String toString() {
        return com.liulishuo.filedownloader.util.FileDownloadUtils.formatString("%d@%s", java.lang.Integer.valueOf(getId()), super.toString());
    }
}
