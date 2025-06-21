package com.ss.android.socialbase.downloader.notification;

/* loaded from: classes19.dex */
public class DownloadNotificationManager {
    private static final java.lang.String KEY_NOTIFS_STRING = "notifs_string";
    private static volatile com.ss.android.socialbase.downloader.notification.DownloadNotificationManager instance;
    private static final java.lang.Object sLock = new java.lang.Object();
    private final long PROGRESS_NOTIFY_DURATION = 1000;
    private final java.util.Map<java.lang.Integer, java.lang.Long> PROGRESS_NOTIFY_LAST_TIME_INFO = new java.util.HashMap();
    private final java.util.Set<java.lang.String> notificationTagSet = new java.util.HashSet();
    private final android.util.SparseArray<com.ss.android.socialbase.downloader.notification.AbsNotificationItem> notificationItemArray = new android.util.SparseArray<>();

    private DownloadNotificationManager() {
    }

    public static com.ss.android.socialbase.downloader.notification.DownloadNotificationManager getInstance() {
        if (instance == null) {
            synchronized (com.ss.android.socialbase.downloader.notification.DownloadNotificationManager.class) {
                if (instance == null) {
                    instance = new com.ss.android.socialbase.downloader.notification.DownloadNotificationManager();
                }
            }
        }
        return instance;
    }

    public static boolean isCompleteAndVisible(com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo) {
        return downloadInfo.isDownloadOverStatus() && isCompleteVisibility(downloadInfo.getNotificationVisibility());
    }

    public static boolean isCompleteVisibility(int i) {
        return i == 1 || i == 3;
    }

    public void addNotification(com.ss.android.socialbase.downloader.notification.AbsNotificationItem absNotificationItem) {
        if (absNotificationItem == null) {
            return;
        }
        synchronized (this.notificationItemArray) {
            this.notificationItemArray.put(absNotificationItem.getId(), absNotificationItem);
        }
    }

    public void cancel(int i) {
        android.content.Context appContext = com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.getAppContext();
        if (appContext == null || i == 0) {
            return;
        }
        try {
            android.content.Intent intent = new android.content.Intent(appContext, (java.lang.Class<?>) com.ss.android.socialbase.downloader.notification.DownloadNotificationService.class);
            intent.setAction(com.ss.android.socialbase.downloader.constants.NotificationConstants.ACTION_NOTIFICATION_CANCEL);
            intent.putExtra(com.ss.android.socialbase.downloader.constants.NotificationConstants.EXTRA_NOTIFICATION_ID, i);
            appContext.startService(intent);
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    public void cancelCompleteNotification(com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo) {
        if (isCompleteAndVisible(downloadInfo)) {
            cancelNotification(downloadInfo.getId());
        }
    }

    public void cancelNotification(int i) {
        removeNotification(i);
        if (i != 0) {
            getInstance().cancel(i);
        }
    }

    public void clearNotification() {
        android.util.SparseArray<com.ss.android.socialbase.downloader.notification.AbsNotificationItem> clone;
        synchronized (this.notificationItemArray) {
            clone = this.notificationItemArray.clone();
            this.notificationItemArray.clear();
        }
        for (int i = 0; i < clone.size(); i++) {
            clone.get(clone.keyAt(i)).cancel();
        }
    }

    public android.util.SparseArray<com.ss.android.socialbase.downloader.notification.AbsNotificationItem> getAllNotificationItems() {
        android.util.SparseArray<com.ss.android.socialbase.downloader.notification.AbsNotificationItem> sparseArray;
        synchronized (this.notificationItemArray) {
            sparseArray = this.notificationItemArray;
        }
        return sparseArray;
    }

    public com.ss.android.socialbase.downloader.notification.AbsNotificationItem getNotificationItem(int i) {
        com.ss.android.socialbase.downloader.notification.AbsNotificationItem absNotificationItem;
        if (i == 0) {
            return null;
        }
        synchronized (this.notificationItemArray) {
            absNotificationItem = this.notificationItemArray.get(i);
        }
        return absNotificationItem;
    }

    public void hideNotification(int i) {
        com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo = com.ss.android.socialbase.downloader.downloader.Downloader.getInstance(com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.getAppContext()).getDownloadInfo(i);
        if (downloadInfo == null) {
            return;
        }
        updateNotificationState(downloadInfo);
        cancelCompleteNotification(downloadInfo);
    }

    public void notifyByService(int i, int i2, android.app.Notification notification) {
        android.content.Context appContext = com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.getAppContext();
        if (appContext == null || i == 0 || notification == null) {
            return;
        }
        if (i2 == 4) {
            synchronized (this.PROGRESS_NOTIFY_LAST_TIME_INFO) {
                java.lang.Long l = this.PROGRESS_NOTIFY_LAST_TIME_INFO.get(java.lang.Integer.valueOf(i));
                long currentTimeMillis = java.lang.System.currentTimeMillis();
                if (l != null && java.lang.Math.abs(currentTimeMillis - l.longValue()) < 1000) {
                    return;
                } else {
                    this.PROGRESS_NOTIFY_LAST_TIME_INFO.put(java.lang.Integer.valueOf(i), java.lang.Long.valueOf(currentTimeMillis));
                }
            }
        }
        try {
            android.content.Intent intent = new android.content.Intent(appContext, (java.lang.Class<?>) com.ss.android.socialbase.downloader.notification.DownloadNotificationService.class);
            intent.setAction(com.ss.android.socialbase.downloader.constants.NotificationConstants.ACTION_NOTIFICATION_NOTIFY);
            intent.putExtra(com.ss.android.socialbase.downloader.constants.NotificationConstants.EXTRA_NOTIFICATION_STATUS, i2);
            intent.putExtra(com.ss.android.socialbase.downloader.constants.NotificationConstants.EXTRA_NOTIFICATION_ID, i);
            intent.putExtra(com.ss.android.socialbase.downloader.constants.NotificationConstants.EXTRA_NOTIFICATION, notification);
            appContext.startService(intent);
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    public com.ss.android.socialbase.downloader.notification.AbsNotificationItem removeNotification(int i) {
        com.ss.android.socialbase.downloader.notification.AbsNotificationItem absNotificationItem;
        if (i == 0) {
            return null;
        }
        synchronized (this.notificationItemArray) {
            absNotificationItem = this.notificationItemArray.get(i);
            if (absNotificationItem != null) {
                this.notificationItemArray.remove(i);
                com.ss.android.socialbase.downloader.logger.Logger.d("removeNotificationId ".concat(java.lang.String.valueOf(i)));
            }
        }
        return absNotificationItem;
    }

    public void updateNotificationState(com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo) {
        com.ss.android.socialbase.downloader.downloader.IDownloadCache downloadCache = com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.getDownloadCache();
        if (downloadCache != null && downloadInfo.isDownloadOverStatus()) {
            downloadInfo.setNotificationVisibility(3);
            try {
                downloadCache.updateDownloadInfo(downloadInfo);
            } catch (android.database.sqlite.SQLiteException e) {
                e.printStackTrace();
            }
        }
    }
}
