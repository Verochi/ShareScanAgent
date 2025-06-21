package com.ss.android.socialbase.appdownloader.v;

/* loaded from: classes19.dex */
public class wg implements com.ss.android.socialbase.downloader.downloader.IDownloadLaunchHandler {
    private java.util.List<java.lang.Integer> vw;
    private android.content.BroadcastReceiver wg;

    /* renamed from: com.ss.android.socialbase.appdownloader.v.wg$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {
        final /* synthetic */ java.util.List vw;
        final /* synthetic */ int wg;

        public AnonymousClass1(java.util.List list, int i) {
            this.vw = list;
            this.wg = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                com.ss.android.socialbase.appdownloader.v.wg.this.vw((java.util.List<com.ss.android.socialbase.downloader.model.DownloadInfo>) this.vw, this.wg);
            } catch (java.lang.Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: com.ss.android.socialbase.appdownloader.v.wg$2, reason: invalid class name */
    public class AnonymousClass2 extends android.content.BroadcastReceiver {

        /* renamed from: com.ss.android.socialbase.appdownloader.v.wg$2$1, reason: invalid class name */
        public class AnonymousClass1 implements java.lang.Runnable {
            final /* synthetic */ android.content.Context vw;

            public AnonymousClass1(android.content.Context context) {
                this.vw = context;
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (com.ss.android.socialbase.appdownloader.v.wg.this.vw != null && !com.ss.android.socialbase.appdownloader.v.wg.this.vw.isEmpty()) {
                        int size = com.ss.android.socialbase.appdownloader.v.wg.this.vw.size();
                        java.lang.Integer[] numArr = new java.lang.Integer[size];
                        com.ss.android.socialbase.appdownloader.v.wg.this.vw.toArray(numArr);
                        com.ss.android.socialbase.appdownloader.v.wg.this.vw.clear();
                        for (int i = 0; i < size; i++) {
                            com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo = com.ss.android.socialbase.downloader.downloader.Downloader.getInstance(this.vw).getDownloadInfo(numArr[i].intValue());
                            if (downloadInfo != null && (downloadInfo.getRealStatus() == -5 || (downloadInfo.getRealStatus() == -2 && downloadInfo.isPauseReserveOnWifi()))) {
                                com.ss.android.socialbase.appdownloader.v.wg.this.vw(this.vw, downloadInfo, true, 2);
                            }
                        }
                    }
                } catch (java.lang.Exception e) {
                    e.printStackTrace();
                }
            }
        }

        public AnonymousClass2() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(android.content.Context context, android.content.Intent intent) {
            com.sensorsdata.analytics.android.sdk.aop.push.PushAutoTrackHelper.onBroadcastReceiver(this, context, intent);
            android.content.Context applicationContext = context.getApplicationContext();
            if (com.ss.android.socialbase.downloader.utils.DownloadUtils.isWifi(applicationContext)) {
                com.ss.android.socialbase.downloader.logger.Logger.d("LaunchResume", "onReceive : wifi connected !!!");
                com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.getCPUThreadExecutor().execute(new com.ss.android.socialbase.appdownloader.v.wg.AnonymousClass2.AnonymousClass1(applicationContext));
                try {
                    applicationContext.unregisterReceiver(com.ss.android.socialbase.appdownloader.v.wg.this.wg);
                } catch (java.lang.Throwable th) {
                    th.printStackTrace();
                }
                com.ss.android.socialbase.appdownloader.v.wg.this.wg = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:48:0x012f  */
    /* JADX WARN: Removed duplicated region for block: B:51:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void vw(android.content.Context context, com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo, boolean z, int i) {
        boolean z2;
        com.ss.android.socialbase.appdownloader.t.bt cp;
        if (downloadInfo == null || !downloadInfo.isShowNotification()) {
            return;
        }
        int realStatus = downloadInfo.getRealStatus();
        if (realStatus != -5 || (!"application/ttpatch".equalsIgnoreCase(downloadInfo.getMimeType()) && downloadInfo.isDownloaded())) {
            if (realStatus != -3 || !vw(downloadInfo)) {
                if (realStatus == -2) {
                    if (downloadInfo.isPauseReserveOnWifi()) {
                        if (z) {
                            com.ss.android.socialbase.appdownloader.t.vw(downloadInfo, true, true);
                            downloadInfo.updateSpData();
                            downloadInfo.setDownloadFromReserveWifi(true);
                            com.ss.android.socialbase.appdownloader.t.bt cp2 = com.ss.android.socialbase.appdownloader.v.es().cp();
                            if (cp2 != null) {
                                cp2.vw(downloadInfo, true);
                            }
                            com.ss.android.socialbase.downloader.downloader.IReserveWifiStatusListener d = com.ss.android.socialbase.appdownloader.v.es().d();
                            if (d != null) {
                                d.onStatusChanged(downloadInfo, 5, i);
                                return;
                            }
                            return;
                        }
                        if (this.vw == null) {
                            this.vw = new java.util.ArrayList();
                        }
                        int id = downloadInfo.getId();
                        if (!this.vw.contains(java.lang.Integer.valueOf(id))) {
                            this.vw.add(java.lang.Integer.valueOf(id));
                        }
                        com.ss.android.socialbase.downloader.impls.RetryScheduler.getInstance().tryStartScheduleRetry(downloadInfo);
                    }
                    vw(downloadInfo, context);
                    return;
                }
                return;
            }
            com.ss.android.socialbase.downloader.setting.DownloadSetting obtain = com.ss.android.socialbase.downloader.setting.DownloadSetting.obtain(downloadInfo.getId());
            if (com.ss.android.socialbase.appdownloader.t.vw(context, downloadInfo)) {
                return;
            }
            int optInt = obtain.optInt("uninstall_resume_max_count", 0);
            double optDouble = obtain.optDouble("uninstall_resume_max_hours", 72.0d);
            double optDouble2 = obtain.optDouble("uninstall_resume_min_hours", 12.0d);
            long currentTimeMillis = java.lang.System.currentTimeMillis();
            boolean z3 = downloadInfo.getUninstallResumeCount() < optInt && ((double) (currentTimeMillis - downloadInfo.getLastDownloadTime())) < optDouble * 3600000.0d && ((double) (currentTimeMillis - downloadInfo.getLastUninstallResumeTime())) > optDouble2 * 3600000.0d;
            com.ss.android.socialbase.downloader.logger.Logger.i("LaunchResume", "uninstallResume, name = " + downloadInfo.getTitle() + ", canShowNotification = " + z3);
            if (z3) {
                com.ss.android.socialbase.downloader.notification.AbsNotificationItem notificationItem = com.ss.android.socialbase.downloader.notification.DownloadNotificationManager.getInstance().getNotificationItem(downloadInfo.getId());
                if (notificationItem == null) {
                    notificationItem = new com.ss.android.socialbase.appdownloader.yl.vw(context, downloadInfo.getId(), downloadInfo.getTitle(), downloadInfo.getSavePath(), downloadInfo.getName(), downloadInfo.getExtra());
                    com.ss.android.socialbase.downloader.notification.DownloadNotificationManager.getInstance().addNotification(notificationItem);
                } else {
                    notificationItem.updateNotificationItem(downloadInfo);
                }
                notificationItem.setTotalBytes(downloadInfo.getTotalBytes());
                notificationItem.setCurBytes(downloadInfo.getTotalBytes());
                notificationItem.refreshStatus(downloadInfo.getStatus(), null, false, false);
                downloadInfo.setLastUninstallResumeTime(currentTimeMillis);
                downloadInfo.setUninstallResumeCount(downloadInfo.getUninstallResumeCount() + 1);
                downloadInfo.updateSpData();
                return;
            }
            return;
        }
        com.ss.android.socialbase.downloader.setting.DownloadSetting obtain2 = com.ss.android.socialbase.downloader.setting.DownloadSetting.obtain(downloadInfo.getId());
        int optInt2 = obtain2.optInt("failed_resume_max_count", 0);
        double optDouble3 = obtain2.optDouble("failed_resume_max_hours", 72.0d);
        double optDouble4 = obtain2.optDouble("failed_resume_min_hours", 12.0d);
        long currentTimeMillis2 = java.lang.System.currentTimeMillis();
        boolean z4 = (downloadInfo.isPauseReserveOnWifi() && z) ? true : downloadInfo.getFailedResumeCount() < optInt2 && ((double) (currentTimeMillis2 - downloadInfo.getLastDownloadTime())) < optDouble3 * 3600000.0d && ((double) (currentTimeMillis2 - downloadInfo.getLastFailedResumeTime())) > optDouble4 * 3600000.0d;
        if (z4) {
            boolean z5 = obtain2.optInt("failed_resume_need_wifi", 1) == 1;
            boolean z6 = obtain2.optInt("failed_resume_need_wait_wifi", 0) == 1;
            if (z || !z5 || !z6) {
                com.ss.android.socialbase.appdownloader.t.vw(downloadInfo, true, z5);
                downloadInfo.setLastFailedResumeTime(currentTimeMillis2);
                downloadInfo.setFailedResumeCount(downloadInfo.getFailedResumeCount() + 1);
                downloadInfo.updateSpData();
                if (downloadInfo.isPauseReserveOnWifi() && z) {
                    downloadInfo.setDownloadFromReserveWifi(true);
                    com.ss.android.socialbase.downloader.downloader.IReserveWifiStatusListener d2 = com.ss.android.socialbase.appdownloader.v.es().d();
                    if (d2 != null) {
                        d2.onStatusChanged(downloadInfo, 5, i);
                    }
                }
                z2 = true;
                com.ss.android.socialbase.downloader.logger.Logger.i("LaunchResume", "launchResume, name = " + downloadInfo.getTitle() + ", canShowNotification = " + z4 + ", downloadResumed = " + z2);
                cp = com.ss.android.socialbase.appdownloader.v.es().cp();
                if (cp == null) {
                    cp.vw(downloadInfo, z2);
                    return;
                }
                return;
            }
            if (this.vw == null) {
                this.vw = new java.util.ArrayList();
            }
            int id2 = downloadInfo.getId();
            if (!this.vw.contains(java.lang.Integer.valueOf(id2))) {
                this.vw.add(java.lang.Integer.valueOf(id2));
            }
            downloadInfo.setOnlyWifi(true);
            com.ss.android.socialbase.downloader.impls.RetryScheduler.getInstance().tryStartScheduleRetry(downloadInfo);
        }
        z2 = false;
        com.ss.android.socialbase.downloader.logger.Logger.i("LaunchResume", "launchResume, name = " + downloadInfo.getTitle() + ", canShowNotification = " + z4 + ", downloadResumed = " + z2);
        cp = com.ss.android.socialbase.appdownloader.v.es().cp();
        if (cp == null) {
        }
    }

    private void vw(com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo, android.content.Context context) {
        com.ss.android.socialbase.downloader.setting.DownloadSetting obtain = com.ss.android.socialbase.downloader.setting.DownloadSetting.obtain(downloadInfo.getId());
        int optInt = obtain.optInt("paused_resume_max_count", 0);
        double optDouble = obtain.optDouble("paused_resume_max_hours", 72.0d);
        int pausedResumeCount = downloadInfo.getPausedResumeCount();
        if (pausedResumeCount < optInt && ((double) (java.lang.System.currentTimeMillis() - downloadInfo.getLastDownloadTime())) < optDouble * 3600000.0d) {
            com.ss.android.socialbase.downloader.notification.AbsNotificationItem notificationItem = com.ss.android.socialbase.downloader.notification.DownloadNotificationManager.getInstance().getNotificationItem(downloadInfo.getId());
            if (notificationItem == null) {
                notificationItem = new com.ss.android.socialbase.appdownloader.yl.vw(context, downloadInfo.getId(), downloadInfo.getTitle(), downloadInfo.getSavePath(), downloadInfo.getName(), downloadInfo.getExtra());
                com.ss.android.socialbase.downloader.notification.DownloadNotificationManager.getInstance().addNotification(notificationItem);
            } else {
                notificationItem.updateNotificationItem(downloadInfo);
            }
            notificationItem.setTotalBytes(downloadInfo.getTotalBytes());
            notificationItem.setCurBytes(downloadInfo.getCurBytes());
            notificationItem.refreshStatus(downloadInfo.getStatus(), null, false, false);
            downloadInfo.setPausedResumeCount(pausedResumeCount + 1);
            downloadInfo.updateSpData();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vw(java.util.List<com.ss.android.socialbase.downloader.model.DownloadInfo> list, int i) {
        if (list == null || list.isEmpty()) {
            return;
        }
        com.ss.android.socialbase.appdownloader.v.es();
        android.content.Context appContext = com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.getAppContext();
        if (appContext == null) {
            return;
        }
        boolean isWifi = com.ss.android.socialbase.downloader.utils.DownloadUtils.isWifi(appContext);
        java.util.Iterator<com.ss.android.socialbase.downloader.model.DownloadInfo> it = list.iterator();
        while (it.hasNext()) {
            vw(appContext, it.next(), isWifi, i);
        }
        java.util.List<java.lang.Integer> list2 = this.vw;
        if (list2 == null || list2.isEmpty() || this.wg != null) {
            return;
        }
        this.wg = new com.ss.android.socialbase.appdownloader.v.wg.AnonymousClass2();
        try {
            android.content.IntentFilter intentFilter = new android.content.IntentFilter();
            intentFilter.addAction(com.igexin.sdk.PushConsts.ACTION_BROADCAST_NETWORK_CHANGE);
            appContext.registerReceiver(this.wg, intentFilter);
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            this.wg = null;
        }
    }

    private boolean vw(com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo) {
        return com.ss.android.socialbase.downloader.setting.DownloadSetting.obtain(downloadInfo.getId()).optBugFix("uninstall_can_not_resume_for_force_task", false) ? com.ss.android.socialbase.downloader.utils.DownloadUtils.isFileDownloaded(downloadInfo, false, downloadInfo.getMd5()) : downloadInfo.isDownloaded();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadLaunchHandler
    public java.util.List<java.lang.String> getResumeMimeTypes() {
        return com.ss.android.socialbase.appdownloader.t.t();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadLaunchHandler
    public void onLaunchResume(java.util.List<com.ss.android.socialbase.downloader.model.DownloadInfo> list, int i) {
        if (com.ss.android.socialbase.downloader.utils.DownloadUtils.isMainThread()) {
            com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.getCPUThreadExecutor().execute(new com.ss.android.socialbase.appdownloader.v.wg.AnonymousClass1(list, i));
        } else {
            vw(list, i);
        }
    }
}
