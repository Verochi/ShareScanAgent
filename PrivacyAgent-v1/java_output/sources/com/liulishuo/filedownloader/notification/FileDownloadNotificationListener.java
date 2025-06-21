package com.liulishuo.filedownloader.notification;

/* loaded from: classes23.dex */
public abstract class FileDownloadNotificationListener extends com.liulishuo.filedownloader.FileDownloadListener {
    public final com.liulishuo.filedownloader.notification.FileDownloadNotificationHelper a;

    public FileDownloadNotificationListener(com.liulishuo.filedownloader.notification.FileDownloadNotificationHelper fileDownloadNotificationHelper) {
        if (fileDownloadNotificationHelper == null) {
            throw new java.lang.IllegalArgumentException("helper must not be null!");
        }
        this.a = fileDownloadNotificationHelper;
    }

    public void addNotificationItem(int i) {
        com.liulishuo.filedownloader.BaseDownloadTask.IRunningTask iRunningTask;
        if (i == 0 || (iRunningTask = com.liulishuo.filedownloader.FileDownloadList.getImpl().get(i)) == null) {
            return;
        }
        addNotificationItem(iRunningTask.getOrigin());
    }

    public void addNotificationItem(com.liulishuo.filedownloader.BaseDownloadTask baseDownloadTask) {
        com.liulishuo.filedownloader.notification.BaseNotificationItem create;
        if (disableNotification(baseDownloadTask) || (create = create(baseDownloadTask)) == null) {
            return;
        }
        this.a.add(create);
    }

    @Override // com.liulishuo.filedownloader.FileDownloadListener
    public void blockComplete(com.liulishuo.filedownloader.BaseDownloadTask baseDownloadTask) {
    }

    @Override // com.liulishuo.filedownloader.FileDownloadListener
    public void completed(com.liulishuo.filedownloader.BaseDownloadTask baseDownloadTask) {
        destroyNotification(baseDownloadTask);
    }

    public abstract com.liulishuo.filedownloader.notification.BaseNotificationItem create(com.liulishuo.filedownloader.BaseDownloadTask baseDownloadTask);

    public void destroyNotification(com.liulishuo.filedownloader.BaseDownloadTask baseDownloadTask) {
        if (disableNotification(baseDownloadTask)) {
            return;
        }
        this.a.showIndeterminate(baseDownloadTask.getId(), baseDownloadTask.getStatus());
        com.liulishuo.filedownloader.notification.BaseNotificationItem remove = this.a.remove(baseDownloadTask.getId());
        if (interceptCancel(baseDownloadTask, remove) || remove == null) {
            return;
        }
        remove.cancel();
    }

    public boolean disableNotification(com.liulishuo.filedownloader.BaseDownloadTask baseDownloadTask) {
        return false;
    }

    @Override // com.liulishuo.filedownloader.FileDownloadListener
    public void error(com.liulishuo.filedownloader.BaseDownloadTask baseDownloadTask, java.lang.Throwable th) {
        destroyNotification(baseDownloadTask);
    }

    public com.liulishuo.filedownloader.notification.FileDownloadNotificationHelper getHelper() {
        return this.a;
    }

    public boolean interceptCancel(com.liulishuo.filedownloader.BaseDownloadTask baseDownloadTask, com.liulishuo.filedownloader.notification.BaseNotificationItem baseNotificationItem) {
        return false;
    }

    @Override // com.liulishuo.filedownloader.FileDownloadListener
    public void paused(com.liulishuo.filedownloader.BaseDownloadTask baseDownloadTask, int i, int i2) {
        destroyNotification(baseDownloadTask);
    }

    @Override // com.liulishuo.filedownloader.FileDownloadListener
    public void pending(com.liulishuo.filedownloader.BaseDownloadTask baseDownloadTask, int i, int i2) {
        addNotificationItem(baseDownloadTask);
        showIndeterminate(baseDownloadTask);
    }

    @Override // com.liulishuo.filedownloader.FileDownloadListener
    public void progress(com.liulishuo.filedownloader.BaseDownloadTask baseDownloadTask, int i, int i2) {
        showProgress(baseDownloadTask, i, i2);
    }

    @Override // com.liulishuo.filedownloader.FileDownloadListener
    public void retry(com.liulishuo.filedownloader.BaseDownloadTask baseDownloadTask, java.lang.Throwable th, int i, int i2) {
        super.retry(baseDownloadTask, th, i, i2);
        showIndeterminate(baseDownloadTask);
    }

    public void showIndeterminate(com.liulishuo.filedownloader.BaseDownloadTask baseDownloadTask) {
        if (disableNotification(baseDownloadTask)) {
            return;
        }
        this.a.showIndeterminate(baseDownloadTask.getId(), baseDownloadTask.getStatus());
    }

    public void showProgress(com.liulishuo.filedownloader.BaseDownloadTask baseDownloadTask, int i, int i2) {
        if (disableNotification(baseDownloadTask)) {
            return;
        }
        this.a.showProgress(baseDownloadTask.getId(), baseDownloadTask.getSmallFileSoFarBytes(), baseDownloadTask.getSmallFileTotalBytes());
    }

    @Override // com.liulishuo.filedownloader.FileDownloadListener
    public void started(com.liulishuo.filedownloader.BaseDownloadTask baseDownloadTask) {
        super.started(baseDownloadTask);
        showIndeterminate(baseDownloadTask);
    }

    @Override // com.liulishuo.filedownloader.FileDownloadListener
    public void warn(com.liulishuo.filedownloader.BaseDownloadTask baseDownloadTask) {
    }
}
