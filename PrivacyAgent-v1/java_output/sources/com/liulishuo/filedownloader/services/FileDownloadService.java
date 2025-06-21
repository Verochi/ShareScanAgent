package com.liulishuo.filedownloader.services;

@android.annotation.SuppressLint({"Registered"})
/* loaded from: classes23.dex */
public class FileDownloadService extends android.app.Service {
    public com.liulishuo.filedownloader.services.IFileDownloadServiceHandler n;
    public com.liulishuo.filedownloader.PauseAllMarker t;

    public static class SeparateProcessService extends com.liulishuo.filedownloader.services.FileDownloadService {
    }

    public static class SharedMainProcessService extends com.liulishuo.filedownloader.services.FileDownloadService {
    }

    public final void a(android.content.Intent intent) {
        if (intent != null && intent.getBooleanExtra(com.liulishuo.filedownloader.util.ExtraKeys.IS_FOREGROUND, false)) {
            com.liulishuo.filedownloader.services.ForegroundServiceConfig foregroundConfigInstance = com.liulishuo.filedownloader.download.CustomComponentHolder.getImpl().getForegroundConfigInstance();
            if (foregroundConfigInstance.isNeedRecreateChannelId() && android.os.Build.VERSION.SDK_INT >= 26) {
                android.app.NotificationChannel notificationChannel = new android.app.NotificationChannel(foregroundConfigInstance.getNotificationChannelId(), foregroundConfigInstance.getNotificationChannelName(), 2);
                android.app.NotificationManager notificationManager = (android.app.NotificationManager) getSystemService(com.huawei.hms.push.constant.RemoteMessageConst.NOTIFICATION);
                if (notificationManager == null) {
                    return;
                } else {
                    notificationManager.createNotificationChannel(notificationChannel);
                }
            }
            startForeground(foregroundConfigInstance.getNotificationId(), foregroundConfigInstance.getNotification(this));
            if (com.liulishuo.filedownloader.util.FileDownloadLog.NEED_LOG) {
                com.liulishuo.filedownloader.util.FileDownloadLog.d(this, "run service foreground with config: %s", foregroundConfigInstance);
            }
        }
    }

    @Override // android.app.Service
    public android.os.IBinder onBind(android.content.Intent intent) {
        return this.n.onBind(intent);
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        com.liulishuo.filedownloader.util.FileDownloadHelper.holdContext(this);
        try {
            com.liulishuo.filedownloader.util.FileDownloadUtils.setMinProgressStep(com.liulishuo.filedownloader.util.FileDownloadProperties.getImpl().downloadMinProgressStep);
            com.liulishuo.filedownloader.util.FileDownloadUtils.setMinProgressTime(com.liulishuo.filedownloader.util.FileDownloadProperties.getImpl().downloadMinProgressTime);
        } catch (java.lang.IllegalAccessException e) {
            e.printStackTrace();
        }
        com.liulishuo.filedownloader.services.FileDownloadManager fileDownloadManager = new com.liulishuo.filedownloader.services.FileDownloadManager();
        if (com.liulishuo.filedownloader.util.FileDownloadProperties.getImpl().processNonSeparate) {
            this.n = new com.liulishuo.filedownloader.services.FDServiceSharedHandler(new java.lang.ref.WeakReference(this), fileDownloadManager);
        } else {
            this.n = new com.liulishuo.filedownloader.services.FDServiceSeparateHandler(new java.lang.ref.WeakReference(this), fileDownloadManager);
        }
        com.liulishuo.filedownloader.PauseAllMarker.clearMarker();
        com.liulishuo.filedownloader.PauseAllMarker pauseAllMarker = new com.liulishuo.filedownloader.PauseAllMarker((com.liulishuo.filedownloader.i.IFileDownloadIPCService) this.n);
        this.t = pauseAllMarker;
        pauseAllMarker.startPauseAllLooperCheck();
    }

    @Override // android.app.Service
    public void onDestroy() {
        this.t.stopPauseAllLooperCheck();
        stopForeground(true);
        super.onDestroy();
    }

    @Override // android.app.Service
    public int onStartCommand(android.content.Intent intent, int i, int i2) {
        com.sensorsdata.analytics.android.sdk.aop.push.PushAutoTrackHelper.onServiceStartCommand(this, intent, i, i2);
        this.n.onStartCommand(intent, i, i2);
        a(intent);
        return 1;
    }
}
