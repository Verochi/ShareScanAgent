package com.aliyun.svideo.downloader;

/* loaded from: classes.dex */
class BridgeListener extends com.liulishuo.filedownloader.FileDownloadListener {
    private com.liulishuo.filedownloader.BaseDownloadTask mDownloadTask;
    private com.aliyun.svideo.downloader.FileDownloaderCallback mGlobleDownloadCallback = com.aliyun.svideo.downloader.DownloaderManager.getInstance().getGlobalDownloadCallback();
    private java.util.concurrent.CopyOnWriteArrayList<com.aliyun.svideo.downloader.FileDownloaderCallback> mListenerList = new java.util.concurrent.CopyOnWriteArrayList<>();
    private long mOldSoFarBytes;
    private long mPreviousTime;
    private long mSpeed;

    /* renamed from: com.aliyun.svideo.downloader.BridgeListener$1, reason: invalid class name */
    public class AnonymousClass1 extends android.os.AsyncTask {
        final /* synthetic */ com.aliyun.svideo.downloader.FileDownloaderCallback val$listener;
        final /* synthetic */ com.aliyun.svideo.downloader.FileDownloaderModel val$model;
        final /* synthetic */ com.liulishuo.filedownloader.BaseDownloadTask val$task;

        public AnonymousClass1(com.aliyun.svideo.downloader.FileDownloaderModel fileDownloaderModel, com.liulishuo.filedownloader.BaseDownloadTask baseDownloadTask, com.aliyun.svideo.downloader.FileDownloaderCallback fileDownloaderCallback) {
            this.val$model = fileDownloaderModel;
            this.val$task = baseDownloadTask;
            this.val$listener = fileDownloaderCallback;
        }

        @Override // android.os.AsyncTask
        public java.lang.Object doInBackground(java.lang.Object[] objArr) {
            java.lang.String path;
            boolean mkdirs;
            if (this.val$model.isunzip() != 1) {
                java.io.File file = new java.io.File(this.val$model.getPath());
                com.aliyun.svideo.downloader.DownloaderManager.getInstance().getDbController().addTask(this.val$model);
                return file;
            }
            this.val$model.setIsunzip(0);
            if (new java.io.File(this.val$task.getPath()).isDirectory()) {
                java.io.File file2 = new java.io.File(this.val$task.getPath());
                com.aliyun.svideo.downloader.DownloaderManager.getInstance().getDbController().addTask(this.val$model);
                return file2;
            }
            java.io.File file3 = new java.io.File(this.val$task.getPath());
            java.io.File file4 = new java.io.File(this.val$task.getPath() + "tmp");
            boolean renameTo = file3.renameTo(file4);
            int effectType = this.val$model.getEffectType();
            if (effectType != 1 && effectType != 2) {
                if (effectType == 3) {
                    path = file3.getParentFile().getPath();
                } else if (effectType != 6 && effectType != 9 && effectType != 10) {
                    path = com.liulishuo.filedownloader.util.FileDownloadUtils.getDefaultSaveRootPath() + java.io.File.separator + com.aliyun.common.utils.StringUtils.subString(this.val$task.getPath());
                }
                java.io.File file5 = new java.io.File(path);
                mkdirs = (file5.exists() || !file5.isDirectory()) ? file5.mkdirs() : true;
                if (!mkdirs && file4.exists() && renameTo) {
                    java.io.File process = new com.aliyun.svideo.downloader.zipprocessor.ZIPFileProcessor(file5, this.val$task.getDownloadId()).process(file4);
                    if (process == null) {
                        return process;
                    }
                    if (this.val$model.getEffectType() == 3) {
                        this.val$model.setPath(path);
                    }
                    com.aliyun.svideo.downloader.DownloaderManager.getInstance().getDbController().addTask(this.val$model);
                    return process;
                }
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                sb.append("not process file is ");
                sb.append(file4.getAbsolutePath());
                sb.append(" success is ");
                sb.append(mkdirs);
                sb.append(" isRename is ");
                sb.append(renameTo);
                return null;
            }
            path = this.val$task.getPath();
            java.io.File file52 = new java.io.File(path);
            if (file52.exists()) {
            }
            if (!mkdirs) {
            }
            java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
            sb2.append("not process file is ");
            sb2.append(file4.getAbsolutePath());
            sb2.append(" success is ");
            sb2.append(mkdirs);
            sb2.append(" isRename is ");
            sb2.append(renameTo);
            return null;
        }

        @Override // android.os.AsyncTask
        public void onPostExecute(java.lang.Object obj) {
            super.onPostExecute(obj);
            this.val$listener.onFinish(this.val$task.getDownloadId(), this.val$task.getPath());
            com.aliyun.svideo.downloader.BridgeListener.this.removeDownloadListener(this.val$listener);
        }
    }

    private void nextTask(int i) {
        com.aliyun.svideo.downloader.DownloaderManager.getInstance().removeDownloadingTask(i);
        com.aliyun.svideo.downloader.FileDownloaderModel nextTask = com.aliyun.svideo.downloader.DownloaderManager.getInstance().nextTask();
        if (nextTask != null) {
            com.aliyun.svideo.downloader.DownloaderManager.getInstance().startTask(nextTask.getTaskId());
        }
    }

    public void addDownloadListener(com.aliyun.svideo.downloader.FileDownloaderCallback fileDownloaderCallback) {
        if (fileDownloaderCallback == null || this.mListenerList.contains(fileDownloaderCallback)) {
            return;
        }
        this.mListenerList.add(fileDownloaderCallback);
    }

    @Override // com.liulishuo.filedownloader.FileDownloadListener
    public void blockComplete(com.liulishuo.filedownloader.BaseDownloadTask baseDownloadTask) {
    }

    @Override // com.liulishuo.filedownloader.FileDownloadListener
    public void completed(com.liulishuo.filedownloader.BaseDownloadTask baseDownloadTask) {
        com.aliyun.svideo.downloader.FileDownloaderModel fileDownloaderModelById;
        java.util.Iterator<com.aliyun.svideo.downloader.FileDownloaderCallback> it = this.mListenerList.iterator();
        while (it.hasNext()) {
            com.aliyun.svideo.downloader.FileDownloaderCallback next = it.next();
            if (next != null && (fileDownloaderModelById = com.aliyun.svideo.downloader.DownloaderManager.getInstance().getFileDownloaderModelById(baseDownloadTask.getId())) != null) {
                new com.aliyun.svideo.downloader.BridgeListener.AnonymousClass1(fileDownloaderModelById, baseDownloadTask, next).executeOnExecutor(android.os.AsyncTask.SERIAL_EXECUTOR, new java.lang.Object[0]);
            }
        }
        com.aliyun.svideo.downloader.FileDownloaderCallback fileDownloaderCallback = this.mGlobleDownloadCallback;
        if (fileDownloaderCallback != null) {
            fileDownloaderCallback.onFinish(baseDownloadTask.getDownloadId(), baseDownloadTask.getPath());
        }
        nextTask(baseDownloadTask.getDownloadId());
    }

    @Override // com.liulishuo.filedownloader.FileDownloadListener
    public void connected(com.liulishuo.filedownloader.BaseDownloadTask baseDownloadTask, java.lang.String str, boolean z, int i, int i2) {
        super.connected(baseDownloadTask, str, z, i, i2);
        int i3 = i2 != 0 ? (int) ((i / i2) * 100.0f) : 0;
        java.util.Iterator<com.aliyun.svideo.downloader.FileDownloaderCallback> it = this.mListenerList.iterator();
        while (it.hasNext()) {
            com.aliyun.svideo.downloader.FileDownloaderCallback next = it.next();
            if (next != null) {
                next.onStart(baseDownloadTask.getDownloadId(), i, i2, i3);
            }
        }
        com.aliyun.svideo.downloader.FileDownloaderCallback fileDownloaderCallback = this.mGlobleDownloadCallback;
        if (fileDownloaderCallback != null) {
            fileDownloaderCallback.onStart(baseDownloadTask.getDownloadId(), i, i2, i3);
        }
        this.mOldSoFarBytes = i;
        this.mPreviousTime = java.lang.System.currentTimeMillis();
    }

    @Override // com.liulishuo.filedownloader.FileDownloadListener
    public void error(com.liulishuo.filedownloader.BaseDownloadTask baseDownloadTask, java.lang.Throwable th) {
        baseDownloadTask.getLargeFileTotalBytes();
        baseDownloadTask.getLargeFileSoFarBytes();
        java.util.Iterator<com.aliyun.svideo.downloader.FileDownloaderCallback> it = this.mListenerList.iterator();
        while (it.hasNext()) {
            com.aliyun.svideo.downloader.FileDownloaderCallback next = it.next();
            if (next != null) {
                next.onError(baseDownloadTask, th);
            }
        }
        com.aliyun.svideo.downloader.FileDownloaderCallback fileDownloaderCallback = this.mGlobleDownloadCallback;
        if (fileDownloaderCallback != null) {
            fileDownloaderCallback.onError(baseDownloadTask, th);
        }
    }

    public com.liulishuo.filedownloader.BaseDownloadTask getDownloadTask() {
        return this.mDownloadTask;
    }

    public long getSpeed() {
        return this.mSpeed;
    }

    @Override // com.liulishuo.filedownloader.FileDownloadListener
    public void paused(com.liulishuo.filedownloader.BaseDownloadTask baseDownloadTask, int i, int i2) {
        stop(baseDownloadTask.getDownloadId(), i, i2);
    }

    @Override // com.liulishuo.filedownloader.FileDownloadListener
    public void pending(com.liulishuo.filedownloader.BaseDownloadTask baseDownloadTask, int i, int i2) {
        int i3 = i2 != 0 ? (int) ((i / i2) * 100.0f) : 0;
        java.util.Iterator<com.aliyun.svideo.downloader.FileDownloaderCallback> it = this.mListenerList.iterator();
        while (it.hasNext()) {
            com.aliyun.svideo.downloader.FileDownloaderCallback next = it.next();
            if (next != null) {
                next.onStart(baseDownloadTask.getDownloadId(), i, i2, i3);
            }
        }
        com.aliyun.svideo.downloader.FileDownloaderCallback fileDownloaderCallback = this.mGlobleDownloadCallback;
        if (fileDownloaderCallback != null) {
            fileDownloaderCallback.onStart(baseDownloadTask.getDownloadId(), i, i2, i3);
        }
    }

    @Override // com.liulishuo.filedownloader.FileDownloadListener
    public void progress(com.liulishuo.filedownloader.BaseDownloadTask baseDownloadTask, int i, int i2) {
        long j;
        int i3 = i2 != 0 ? (int) ((i / i2) * 100.0f) : 0;
        long currentTimeMillis = (java.lang.System.currentTimeMillis() - this.mPreviousTime) / 1000;
        if (currentTimeMillis == 0) {
            currentTimeMillis++;
        }
        long j2 = i;
        long j3 = (j2 - this.mOldSoFarBytes) / currentTimeMillis;
        java.util.Iterator<com.aliyun.svideo.downloader.FileDownloaderCallback> it = this.mListenerList.iterator();
        while (it.hasNext()) {
            com.aliyun.svideo.downloader.FileDownloaderCallback next = it.next();
            if (next != null) {
                j = j3;
                next.onProgress(baseDownloadTask.getDownloadId(), j2, i2, j3, i3);
            } else {
                j = j3;
            }
            j3 = j;
        }
        this.mSpeed = j3;
        com.aliyun.svideo.downloader.FileDownloaderCallback fileDownloaderCallback = this.mGlobleDownloadCallback;
        if (fileDownloaderCallback != null) {
            fileDownloaderCallback.onProgress(baseDownloadTask.getDownloadId(), j2, i2, j3, i3);
        }
    }

    public void removeAllDownloadListener() {
        this.mListenerList.clear();
    }

    public void removeDownloadListener(com.aliyun.svideo.downloader.FileDownloaderCallback fileDownloaderCallback) {
        if (fileDownloaderCallback == null || !this.mListenerList.contains(fileDownloaderCallback)) {
            return;
        }
        this.mListenerList.remove(fileDownloaderCallback);
    }

    public void setDownloadTask(com.liulishuo.filedownloader.BaseDownloadTask baseDownloadTask) {
        this.mDownloadTask = baseDownloadTask;
    }

    public void stop(int i, long j, long j2) {
        int i2 = j2 != 0 ? (int) ((j / j2) * 100.0f) : 0;
        java.util.Iterator<com.aliyun.svideo.downloader.FileDownloaderCallback> it = this.mListenerList.iterator();
        while (it.hasNext()) {
            com.aliyun.svideo.downloader.FileDownloaderCallback next = it.next();
            if (next != null) {
                next.onStop(i, j, j2, i2);
            }
        }
        com.aliyun.svideo.downloader.FileDownloaderCallback fileDownloaderCallback = this.mGlobleDownloadCallback;
        if (fileDownloaderCallback != null) {
            fileDownloaderCallback.onStop(i, j, j2, i2);
        }
        nextTask(i);
    }

    public void wait(int i) {
        java.util.Iterator<com.aliyun.svideo.downloader.FileDownloaderCallback> it = this.mListenerList.iterator();
        while (it.hasNext()) {
            com.aliyun.svideo.downloader.FileDownloaderCallback next = it.next();
            if (next != null) {
                next.onWait(i);
            }
        }
    }

    @Override // com.liulishuo.filedownloader.FileDownloadListener
    public void warn(com.liulishuo.filedownloader.BaseDownloadTask baseDownloadTask) {
    }
}
