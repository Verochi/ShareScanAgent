package com.ss.android.socialbase.downloader.depend;

/* loaded from: classes19.dex */
public abstract class AbsNotificationListener extends com.ss.android.socialbase.downloader.depend.AbsDownloadListener implements com.ss.android.socialbase.downloader.depend.IDownloadExtListener {
    private void addNotificationItem(com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo) {
        if (downloadInfo == null || !downloadInfo.canShowNotification()) {
            return;
        }
        com.ss.android.socialbase.downloader.notification.AbsNotificationItem notificationItem = com.ss.android.socialbase.downloader.notification.DownloadNotificationManager.getInstance().getNotificationItem(downloadInfo.getId());
        if (notificationItem != null) {
            notificationItem.updateNotificationItem(downloadInfo);
        } else {
            com.ss.android.socialbase.downloader.notification.DownloadNotificationManager.getInstance().addNotification(createNotificationItem());
        }
    }

    private void updateNotification(int i, com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo, com.ss.android.socialbase.downloader.exception.BaseException baseException, boolean z) {
        if (downloadInfo == null || !downloadInfo.canShowNotification() || i == 4) {
            return;
        }
        com.ss.android.socialbase.downloader.notification.AbsNotificationItem notificationItem = com.ss.android.socialbase.downloader.notification.DownloadNotificationManager.getInstance().getNotificationItem(downloadInfo.getId());
        if (notificationItem == null) {
            notificationItem = createNotificationItem();
        }
        notificationItem.setTotalBytes(downloadInfo.getTotalBytes());
        if (i == -3) {
            notificationItem.setCurBytes(downloadInfo.getTotalBytes());
        } else {
            notificationItem.setCurBytes(downloadInfo.getCurBytes());
        }
        notificationItem.refreshStatus(i, baseException, z);
    }

    private void updateNotificationProgress(com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo) {
        if (downloadInfo != null && downloadInfo.canShowNotification() && downloadInfo.getStatus() == 4) {
            com.ss.android.socialbase.downloader.notification.AbsNotificationItem notificationItem = com.ss.android.socialbase.downloader.notification.DownloadNotificationManager.getInstance().getNotificationItem(downloadInfo.getId());
            if (notificationItem == null) {
                notificationItem = createNotificationItem();
            }
            notificationItem.refreshProgress(downloadInfo.getCurBytes(), downloadInfo.getTotalBytes());
        }
    }

    public abstract com.ss.android.socialbase.downloader.notification.AbsNotificationItem createNotificationItem();

    @Override // com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
    public void onFailed(com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo, com.ss.android.socialbase.downloader.exception.BaseException baseException) {
        super.onFailed(downloadInfo, baseException);
        updateNotification(-1, downloadInfo, baseException, false);
    }

    @Override // com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
    public void onPause(com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo) {
        super.onPause(downloadInfo);
        updateNotification(-2, downloadInfo, null, false);
    }

    @Override // com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
    public void onPrepare(com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo) {
        super.onPrepare(downloadInfo);
        addNotificationItem(downloadInfo);
        updateNotification(1, downloadInfo, null, true);
    }

    @Override // com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
    public void onProgress(com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo) {
        super.onProgress(downloadInfo);
        updateNotificationProgress(downloadInfo);
    }

    @Override // com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
    public void onStart(com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo) {
        super.onStart(downloadInfo);
        updateNotification(2, downloadInfo, null, false);
    }

    @Override // com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
    public void onSuccessed(com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo) {
        super.onSuccessed(downloadInfo);
        updateNotification(-3, downloadInfo, null, false);
    }

    @Override // com.ss.android.socialbase.downloader.depend.IDownloadExtListener
    public void onWaitingDownloadCompleteHandler(com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo) {
        if (downloadInfo == null || downloadInfo.isAutoInstallWithoutNotification()) {
            return;
        }
        updateNotification(11, downloadInfo, null, true);
    }
}
