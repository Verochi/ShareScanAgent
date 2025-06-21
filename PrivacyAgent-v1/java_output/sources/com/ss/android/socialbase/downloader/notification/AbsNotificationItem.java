package com.ss.android.socialbase.downloader.notification;

/* loaded from: classes19.dex */
public abstract class AbsNotificationItem {
    private int clickInstallTimes;
    private long curBytes;
    private java.lang.String description;
    private long firstShowTime;
    private int id;
    protected android.app.Notification notification;
    private boolean ongoing;
    private int status = 0;
    private java.lang.String title;
    private long totalBytes;

    public AbsNotificationItem(int i, java.lang.String str) {
        this.id = i;
        this.title = str;
    }

    public void cancel() {
        if (this.id == 0) {
            return;
        }
        com.ss.android.socialbase.downloader.notification.DownloadNotificationManager.getInstance().cancel(this.id);
    }

    public int getClickInstallTimes() {
        return this.clickInstallTimes;
    }

    public long getCurBytes() {
        return this.curBytes;
    }

    public java.lang.String getDescription() {
        return this.description;
    }

    public long getFirstShowTime() {
        if (this.firstShowTime == 0) {
            this.firstShowTime = java.lang.System.currentTimeMillis();
        }
        return this.firstShowTime;
    }

    public int getId() {
        return this.id;
    }

    public android.app.Notification getNotification() {
        return this.notification;
    }

    public int getStatus() {
        return this.status;
    }

    public java.lang.String getTitle() {
        return this.title;
    }

    public long getTotalBytes() {
        return this.totalBytes;
    }

    public boolean isOngoing() {
        return this.ongoing;
    }

    public void notify(android.app.Notification notification) {
        if (this.id == 0 || notification == null) {
            return;
        }
        com.ss.android.socialbase.downloader.notification.DownloadNotificationManager.getInstance().notifyByService(this.id, this.status, notification);
    }

    public synchronized void recordClickInstall() {
        this.clickInstallTimes++;
    }

    public void refreshProgress(long j, long j2) {
        this.curBytes = j;
        this.totalBytes = j2;
        this.status = 4;
        updateNotification(null, false);
    }

    public void refreshStatus(int i, com.ss.android.socialbase.downloader.exception.BaseException baseException, boolean z) {
        refreshStatus(i, baseException, z, false);
    }

    public void refreshStatus(int i, com.ss.android.socialbase.downloader.exception.BaseException baseException, boolean z, boolean z2) {
        if (z2 || this.status != i) {
            this.status = i;
            updateNotification(baseException, z);
        }
    }

    public void setCurBytes(long j) {
        this.curBytes = j;
    }

    public void setDescription(java.lang.String str) {
        this.description = str;
    }

    public void setId(int i) {
        this.id = i;
    }

    public void setOngoing(boolean z) {
        this.ongoing = z;
    }

    public void setTitle(java.lang.String str) {
        this.title = str;
    }

    public void setTotalBytes(long j) {
        this.totalBytes = j;
    }

    public abstract void updateNotification(com.ss.android.socialbase.downloader.exception.BaseException baseException, boolean z);

    public void updateNotificationItem(com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo) {
        if (downloadInfo == null) {
            return;
        }
        this.id = downloadInfo.getId();
        this.title = downloadInfo.getTitle();
    }
}
