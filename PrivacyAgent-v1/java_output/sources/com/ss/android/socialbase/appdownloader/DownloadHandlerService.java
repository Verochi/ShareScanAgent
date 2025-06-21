package com.ss.android.socialbase.appdownloader;

/* loaded from: classes19.dex */
public class DownloadHandlerService extends android.app.Service {
    private static final java.lang.String vw = "DownloadHandlerService";

    /* renamed from: com.ss.android.socialbase.appdownloader.DownloadHandlerService$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {
        public AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                java.util.ArrayList arrayList = new java.util.ArrayList();
                arrayList.add("application/vnd.android.package-archive");
                arrayList.add(com.ss.android.socialbase.downloader.constants.DownloadConstants.MIME_PLG);
                com.ss.android.socialbase.downloader.downloader.Downloader.getInstance(com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.getAppContext()).restartAllFailedDownloadTasks(arrayList);
            } catch (java.lang.Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: com.ss.android.socialbase.appdownloader.DownloadHandlerService$2, reason: invalid class name */
    public static class AnonymousClass2 implements java.lang.Runnable {
        final /* synthetic */ com.ss.android.socialbase.downloader.depend.IDownloadNotificationEventListener t;
        final /* synthetic */ com.ss.android.socialbase.downloader.model.DownloadInfo vw;
        final /* synthetic */ com.ss.android.socialbase.appdownloader.t.v wg;

        public AnonymousClass2(com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo, com.ss.android.socialbase.appdownloader.t.v vVar, com.ss.android.socialbase.downloader.depend.IDownloadNotificationEventListener iDownloadNotificationEventListener) {
            this.vw = downloadInfo;
            this.wg = vVar;
            this.t = iDownloadNotificationEventListener;
        }

        @Override // java.lang.Runnable
        public void run() {
            android.content.pm.PackageInfo vw;
            try {
                java.io.File file = new java.io.File(this.vw.getSavePath(), this.vw.getName());
                if (file.exists()) {
                    try {
                        java.lang.String str = (com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.getAppContext() == null || (vw = com.ss.android.socialbase.appdownloader.t.vw(this.vw, file)) == null) ? "" : vw.packageName;
                        com.ss.android.socialbase.appdownloader.t.v vVar = this.wg;
                        if (vVar != null) {
                            vVar.vw(this.vw.getId(), 3, str, -3, this.vw.getDownloadTime());
                        }
                        com.ss.android.socialbase.downloader.depend.IDownloadNotificationEventListener iDownloadNotificationEventListener = this.t;
                        if (iDownloadNotificationEventListener != null) {
                            iDownloadNotificationEventListener.onNotificationEvent(3, this.vw, str, "");
                        }
                    } catch (java.lang.Exception e) {
                        e.printStackTrace();
                    }
                }
            } catch (java.lang.Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    private static void vw(android.content.Context context, int i, boolean z) {
        boolean z2;
        com.ss.android.socialbase.downloader.depend.INotificationClickCallback notificationClickCallback;
        com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo;
        if (z && (notificationClickCallback = com.ss.android.socialbase.downloader.downloader.DownloadProcessDispatcher.getInstance().getNotificationClickCallback(i)) != null) {
            try {
                downloadInfo = com.ss.android.socialbase.downloader.downloader.Downloader.getInstance(context).getDownloadInfo(i);
            } catch (java.lang.Throwable th) {
                th.printStackTrace();
            }
            if (downloadInfo != null) {
                z2 = notificationClickCallback.onClickWhenSuccess(downloadInfo);
                if (z2 && com.ss.android.socialbase.appdownloader.t.vw(context, i, true) == 0) {
                    android.widget.Toast.makeText(context, "Open Fail!", 0).show();
                }
                return;
            }
        }
        z2 = false;
        if (z2) {
            return;
        }
        android.widget.Toast.makeText(context, "Open Fail!", 0).show();
    }

    private static void vw(android.content.Context context, com.ss.android.socialbase.appdownloader.t.v vVar, com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo) {
        if (downloadInfo == null) {
            return;
        }
        com.ss.android.socialbase.downloader.depend.IDownloadNotificationEventListener downloadNotificationEventListener = com.ss.android.socialbase.downloader.downloader.Downloader.getInstance(context).getDownloadNotificationEventListener(downloadInfo.getId());
        if (vVar == null && downloadNotificationEventListener == null) {
            return;
        }
        com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.getCPUThreadExecutor().execute(new com.ss.android.socialbase.appdownloader.DownloadHandlerService.AnonymousClass2(downloadInfo, vVar, downloadNotificationEventListener));
    }

    private static void vw(android.content.Context context, com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo) {
        if (com.ss.android.socialbase.downloader.utils.DownloadUtils.isWifi(context.getApplicationContext()) && downloadInfo.isPauseReserveOnWifi()) {
            downloadInfo.stopPauseReserveOnWifi();
        }
    }

    public static void vw(android.content.Context context, com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo, com.ss.android.socialbase.appdownloader.t.v vVar, com.ss.android.socialbase.downloader.depend.IDownloadNotificationEventListener iDownloadNotificationEventListener) {
        com.ss.android.socialbase.downloader.notification.AbsNotificationItem notificationItem;
        int id = downloadInfo.getId();
        com.ss.android.socialbase.downloader.depend.INotificationClickCallback notificationClickCallback = com.ss.android.socialbase.downloader.downloader.DownloadProcessDispatcher.getInstance().getNotificationClickCallback(id);
        if ("application/vnd.android.package-archive".equals(downloadInfo.getMimeType()) && notificationClickCallback != null && com.ss.android.socialbase.appdownloader.t.vw(context, downloadInfo) && notificationClickCallback.onClickWhenInstalled(downloadInfo)) {
        }
        boolean z = false;
        switch (downloadInfo.getStatus()) {
            case -4:
            case -1:
                if (com.ss.android.socialbase.downloader.setting.DownloadSetting.obtain(id).optInt(com.ss.android.socialbase.downloader.setting.DownloadSettingKeys.OPT_NOTIFICATION_UI) >= 2 && downloadInfo.isOnlyWifi()) {
                    downloadInfo.setOnlyWifi(false);
                }
                com.ss.android.socialbase.downloader.downloader.Downloader.getInstance(context).restart(id);
                break;
            case -3:
                vw(com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.getAppContext(), id, true);
                vw(context, vVar, downloadInfo);
                if (com.ss.android.socialbase.downloader.setting.DownloadSetting.obtain(id).optInt("notification_click_install_auto_cancel", 1) != 0 || (notificationItem = com.ss.android.socialbase.downloader.notification.DownloadNotificationManager.getInstance().getNotificationItem(id)) == null) {
                    z = true;
                } else {
                    notificationItem.recordClickInstall();
                    notificationItem.refreshStatus(-3, null, false, true);
                }
                if (z) {
                    com.ss.android.socialbase.downloader.notification.DownloadNotificationManager.getInstance().hideNotification(id);
                    break;
                }
                break;
            case -2:
                if (com.ss.android.socialbase.downloader.downloader.DownloadProcessDispatcher.getInstance().canResume(id)) {
                    com.ss.android.socialbase.downloader.downloader.Downloader.getInstance(context).resume(id);
                } else {
                    com.ss.android.socialbase.appdownloader.t.vw(downloadInfo, true, false);
                }
                if (vVar != null) {
                    vVar.vw(id, 6, "", downloadInfo.getStatus(), downloadInfo.getDownloadTime());
                }
                if (iDownloadNotificationEventListener != null) {
                    iDownloadNotificationEventListener.onNotificationEvent(6, downloadInfo, "", "");
                    break;
                }
                break;
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
                com.ss.android.socialbase.downloader.downloader.Downloader.getInstance(context).pause(id);
                vw(context, downloadInfo);
                if (vVar != null) {
                    vVar.vw(id, 5, "", downloadInfo.getStatus(), downloadInfo.getDownloadTime());
                }
                if (iDownloadNotificationEventListener != null) {
                    iDownloadNotificationEventListener.onNotificationEvent(5, downloadInfo, "", "");
                    break;
                }
                break;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:5:0x001a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void vw(@androidx.annotation.NonNull com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo, com.ss.android.socialbase.appdownloader.t.v vVar, com.ss.android.socialbase.downloader.depend.IDownloadNotificationEventListener iDownloadNotificationEventListener) {
        boolean onClickWhenUnSuccess;
        int id = downloadInfo.getId();
        com.ss.android.socialbase.downloader.depend.INotificationClickCallback notificationClickCallback = com.ss.android.socialbase.downloader.downloader.DownloadProcessDispatcher.getInstance().getNotificationClickCallback(id);
        if (notificationClickCallback != null) {
            try {
                onClickWhenUnSuccess = notificationClickCallback.onClickWhenUnSuccess(downloadInfo);
            } catch (java.lang.Throwable th) {
                th.printStackTrace();
            }
            if (onClickWhenUnSuccess) {
                android.content.Intent intent = new android.content.Intent(this, (java.lang.Class<?>) com.ss.android.socialbase.appdownloader.view.DownloadTaskDeleteActivity.class);
                intent.putExtra("extra_click_download_ids", id);
                intent.addFlags(268435456);
                startActivity(intent);
                com.ss.android.socialbase.downloader.notification.DownloadNotificationManager.getInstance().hideNotification(id);
                downloadInfo.updateDownloadTime();
                if (vVar != null) {
                    vVar.vw(id, 7, "", downloadInfo.getStatus(), downloadInfo.getDownloadTime());
                }
                if (iDownloadNotificationEventListener != null) {
                    iDownloadNotificationEventListener.onNotificationEvent(7, downloadInfo, "", "");
                    return;
                }
                return;
            }
            return;
        }
        onClickWhenUnSuccess = false;
        if (onClickWhenUnSuccess) {
        }
    }

    private boolean vw(android.content.Intent intent) {
        if (intent == null) {
            return false;
        }
        java.lang.String action = intent.getAction();
        if (android.text.TextUtils.isEmpty(action)) {
            return false;
        }
        int intExtra = intent.getIntExtra("extra_click_download_ids", 0);
        intent.getIntExtra("extra_click_download_type", 0);
        com.ss.android.socialbase.appdownloader.t.v wg = com.ss.android.socialbase.appdownloader.v.es().wg();
        com.ss.android.socialbase.downloader.depend.IDownloadNotificationEventListener downloadNotificationEventListener = com.ss.android.socialbase.downloader.downloader.Downloader.getInstance(this).getDownloadNotificationEventListener(intExtra);
        if (intent.getBooleanExtra("extra_from_notification", false) && com.ss.android.socialbase.downloader.setting.DownloadSetting.obtain(intExtra).optInt("notification_opt_2") == 1) {
            com.ss.android.socialbase.downloader.notification.DownloadNotificationManager.getInstance().cancelNotification(intExtra);
        }
        com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo = com.ss.android.socialbase.downloader.downloader.Downloader.getInstance(this).getDownloadInfo(intExtra);
        if (downloadInfo == null) {
            return false;
        }
        if (action.equals("android.ss.intent.action.DOWNLOAD_CLICK_CONTENT")) {
            vw(downloadInfo, wg, downloadNotificationEventListener);
        } else if (action.equals("android.ss.intent.action.DOWNLOAD_OPEN")) {
            vw(this, downloadInfo, wg, downloadNotificationEventListener);
        } else if (action.equals("android.ss.intent.action.DOWNLOAD_CLICK_BTN")) {
            if (downloadInfo.getStatus() == 0) {
                return false;
            }
            vw(this, downloadInfo, wg, downloadNotificationEventListener);
            if (downloadInfo.isDownloadOverStatus() && com.ss.android.socialbase.downloader.setting.DownloadSetting.obtain(intExtra).optInt(com.ss.android.socialbase.downloader.setting.DownloadSettingKeys.NO_HIDE_NOTIFICATION, 0) == 0) {
                if (!(com.ss.android.socialbase.downloader.setting.DownloadSetting.obtain(intExtra).optInt(com.ss.android.socialbase.downloader.setting.DownloadSettingKeys.OPT_NOTIFICATION_UI) >= 2 && downloadInfo.getStatus() == -1)) {
                    com.ss.android.socialbase.downloader.notification.DownloadNotificationManager.getInstance().hideNotification(intExtra);
                    com.ss.android.socialbase.downloader.notification.DownloadNotificationManager.getInstance().cancelNotification(intExtra);
                }
            }
        } else if (action.equals("android.ss.intent.action.DOWNLOAD_DELETE")) {
            wg(downloadInfo, wg, downloadNotificationEventListener);
        } else if (action.equals("android.ss.intent.action.DOWNLOAD_HIDE")) {
            com.ss.android.socialbase.downloader.notification.DownloadNotificationManager.getInstance().hideNotification(intExtra);
        } else if (action.equals("android.intent.action.BOOT_COMPLETED") || action.equals("android.intent.action.MEDIA_MOUNTED")) {
            com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.getCPUThreadExecutor().execute(new com.ss.android.socialbase.appdownloader.DownloadHandlerService.AnonymousClass1());
            return true;
        }
        return false;
    }

    private void wg(@androidx.annotation.NonNull com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo, com.ss.android.socialbase.appdownloader.t.v vVar, com.ss.android.socialbase.downloader.depend.IDownloadNotificationEventListener iDownloadNotificationEventListener) {
        int id = downloadInfo.getId();
        android.content.Intent intent = new android.content.Intent(this, (java.lang.Class<?>) com.ss.android.socialbase.appdownloader.view.DownloadTaskDeleteActivity.class);
        intent.putExtra("extra_click_download_ids", id);
        intent.addFlags(268435456);
        startActivity(intent);
        com.ss.android.socialbase.downloader.notification.DownloadNotificationManager.getInstance().hideNotification(id);
        downloadInfo.updateDownloadTime();
        if (vVar != null) {
            vVar.vw(id, 7, "", downloadInfo.getStatus(), downloadInfo.getDownloadTime());
        }
        if (iDownloadNotificationEventListener != null) {
            iDownloadNotificationEventListener.onNotificationEvent(7, downloadInfo, "", "");
        }
    }

    @Override // android.app.Service
    public android.os.IBinder onBind(android.content.Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.setAppContext(this);
    }

    @Override // android.app.Service
    public int onStartCommand(android.content.Intent intent, int i, int i2) {
        com.sensorsdata.analytics.android.sdk.aop.push.PushAutoTrackHelper.onServiceStartCommand(this, intent, i, i2);
        super.onStartCommand(intent, i, i2);
        if (com.ss.android.socialbase.downloader.logger.Logger.debug()) {
            com.ss.android.socialbase.downloader.logger.Logger.d(vw, "onStartCommand");
        }
        vw(intent);
        stopSelf();
        return 2;
    }
}
