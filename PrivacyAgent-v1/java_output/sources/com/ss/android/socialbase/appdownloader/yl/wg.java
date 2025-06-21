package com.ss.android.socialbase.appdownloader.yl;

/* loaded from: classes19.dex */
public class wg extends com.ss.android.socialbase.downloader.depend.AbsNotificationListener {
    private com.ss.android.socialbase.downloader.notification.AbsNotificationItem bt;
    private java.lang.String kz;
    private java.lang.String t;
    private java.lang.String v;
    private android.content.Context vw;
    private int wg;
    private java.lang.String yl;

    public wg(android.content.Context context, int i, java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4) {
        if (context != null) {
            this.vw = context.getApplicationContext();
        } else {
            this.vw = com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.getAppContext();
        }
        this.wg = i;
        this.t = str;
        this.v = str2;
        this.yl = str3;
        this.kz = str4;
    }

    public wg(com.ss.android.socialbase.downloader.notification.AbsNotificationItem absNotificationItem) {
        this.vw = com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.getAppContext();
        this.bt = absNotificationItem;
    }

    @Override // com.ss.android.socialbase.downloader.depend.AbsNotificationListener
    public com.ss.android.socialbase.downloader.notification.AbsNotificationItem createNotificationItem() {
        android.content.Context context;
        com.ss.android.socialbase.downloader.notification.AbsNotificationItem absNotificationItem = this.bt;
        return (absNotificationItem != null || (context = this.vw) == null) ? absNotificationItem : new com.ss.android.socialbase.appdownloader.yl.vw(context, this.wg, this.t, this.v, this.yl, this.kz);
    }

    @Override // com.ss.android.socialbase.downloader.depend.AbsNotificationListener, com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
    public void onFailed(com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo, com.ss.android.socialbase.downloader.exception.BaseException baseException) {
        if (downloadInfo == null || this.vw == null || !downloadInfo.canShowNotification() || downloadInfo.isAutoInstallWithoutNotification()) {
            return;
        }
        super.onFailed(downloadInfo, baseException);
    }

    @Override // com.ss.android.socialbase.downloader.depend.AbsNotificationListener, com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
    public void onPause(com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo) {
        if (downloadInfo == null || downloadInfo.isAutoInstallWithoutNotification()) {
            return;
        }
        super.onPause(downloadInfo);
    }

    @Override // com.ss.android.socialbase.downloader.depend.AbsNotificationListener, com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
    public void onPrepare(com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo) {
        if (downloadInfo == null || downloadInfo.isAutoInstallWithoutNotification()) {
            return;
        }
        super.onPrepare(downloadInfo);
    }

    @Override // com.ss.android.socialbase.downloader.depend.AbsNotificationListener, com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
    public void onProgress(com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo) {
        if (downloadInfo == null || downloadInfo.isAutoInstallWithoutNotification()) {
            return;
        }
        super.onProgress(downloadInfo);
    }

    @Override // com.ss.android.socialbase.downloader.depend.AbsNotificationListener, com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
    public void onStart(com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo) {
        if (downloadInfo == null || downloadInfo.isAutoInstallWithoutNotification()) {
            return;
        }
        super.onStart(downloadInfo);
    }

    @Override // com.ss.android.socialbase.downloader.depend.AbsNotificationListener, com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
    public void onSuccessed(com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo) {
        if (downloadInfo == null || this.vw == null) {
            return;
        }
        if (downloadInfo.canShowNotification() && (!downloadInfo.isAutoInstallWithoutNotification() || !downloadInfo.isAutoInstall())) {
            super.onSuccessed(downloadInfo);
        }
        if (downloadInfo.isAutoInstall()) {
            com.ss.android.socialbase.appdownloader.kz.wg.vw(downloadInfo);
        }
    }
}
