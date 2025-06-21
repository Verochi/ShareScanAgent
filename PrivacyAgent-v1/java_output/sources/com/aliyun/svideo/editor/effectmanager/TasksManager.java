package com.aliyun.svideo.editor.effectmanager;

/* loaded from: classes12.dex */
public class TasksManager {
    private java.util.LinkedList<com.liulishuo.filedownloader.BaseDownloadTask> list = new java.util.LinkedList<>();
    private int mProgress = 0;
    private int mFinishProgress = 0;
    private int size = 1;
    private android.util.SparseArray<com.aliyun.svideo.downloader.FileDownloaderCallback> mCallbackList = new android.util.SparseArray<>();

    /* renamed from: com.aliyun.svideo.editor.effectmanager.TasksManager$1, reason: invalid class name */
    public class AnonymousClass1 extends com.aliyun.svideo.downloader.FileDownloaderCallback {
        public AnonymousClass1() {
        }

        @Override // com.aliyun.svideo.downloader.FileDownloaderCallback
        public void onError(com.liulishuo.filedownloader.BaseDownloadTask baseDownloadTask, java.lang.Throwable th) {
            super.onError(baseDownloadTask, th);
            if (com.aliyun.svideo.editor.effectmanager.TasksManager.this.mCallbackList.get(baseDownloadTask.getDownloadId()) != null) {
                ((com.aliyun.svideo.downloader.FileDownloaderCallback) com.aliyun.svideo.editor.effectmanager.TasksManager.this.mCallbackList.get(baseDownloadTask.getDownloadId())).onError(baseDownloadTask, th);
            }
        }

        @Override // com.aliyun.svideo.downloader.FileDownloaderCallback
        public void onFinish(int i, java.lang.String str) {
            com.aliyun.svideo.editor.effectmanager.TasksManager tasksManager = com.aliyun.svideo.editor.effectmanager.TasksManager.this;
            tasksManager.mFinishProgress = tasksManager.mProgress;
            super.onFinish(i, str);
            if (com.aliyun.svideo.editor.effectmanager.TasksManager.this.startTask() || com.aliyun.svideo.editor.effectmanager.TasksManager.this.mCallbackList.get(i) == null) {
                return;
            }
            ((com.aliyun.svideo.downloader.FileDownloaderCallback) com.aliyun.svideo.editor.effectmanager.TasksManager.this.mCallbackList.get(i)).onFinish(i, str);
        }

        @Override // com.aliyun.svideo.downloader.FileDownloaderCallback
        public void onProgress(int i, long j, long j2, long j3, int i2) {
            super.onProgress(i, j, j2, j3, i2);
            com.aliyun.svideo.editor.effectmanager.TasksManager tasksManager = com.aliyun.svideo.editor.effectmanager.TasksManager.this;
            tasksManager.mProgress = tasksManager.mFinishProgress + (i2 / com.aliyun.svideo.editor.effectmanager.TasksManager.this.size);
            if (com.aliyun.svideo.editor.effectmanager.TasksManager.this.mCallbackList.get(i) != null) {
                ((com.aliyun.svideo.downloader.FileDownloaderCallback) com.aliyun.svideo.editor.effectmanager.TasksManager.this.mCallbackList.get(i)).onProgress(i, j, j2, j3, com.aliyun.svideo.editor.effectmanager.TasksManager.this.mProgress);
            }
        }

        @Override // com.aliyun.svideo.downloader.FileDownloaderCallback
        public void onStart(int i, long j, long j2, int i2) {
            super.onStart(i, j, j2, i2);
            if (com.aliyun.svideo.editor.effectmanager.TasksManager.this.mCallbackList != null) {
                ((com.aliyun.svideo.downloader.FileDownloaderCallback) com.aliyun.svideo.editor.effectmanager.TasksManager.this.mCallbackList.get(i)).onStart(i, j, j2, i2);
            }
        }
    }

    public void addTask(int i, com.aliyun.svideo.downloader.FileDownloaderCallback fileDownloaderCallback) {
        this.mCallbackList.put(i, fileDownloaderCallback);
        com.liulishuo.filedownloader.BaseDownloadTask createTask = com.aliyun.svideo.downloader.DownloaderManager.getInstance().createTask(i, new com.aliyun.svideo.editor.effectmanager.TasksManager.AnonymousClass1());
        if (createTask != null) {
            this.list.add(createTask);
        }
        if (this.list.size() > 0) {
            this.size = this.list.size();
        }
    }

    public boolean startTask() {
        if (this.list.isEmpty()) {
            return false;
        }
        this.list.poll().start();
        return true;
    }
}
