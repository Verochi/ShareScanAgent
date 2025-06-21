package com.ss.android.downloadlib;

/* loaded from: classes19.dex */
class yl implements com.ss.android.download.api.vw {

    /* renamed from: com.ss.android.downloadlib.yl$1, reason: invalid class name */
    public class AnonymousClass1 implements com.ss.android.socialbase.downloader.common.AppStatusManager.InnerAppStatusChangeCaller {
        final /* synthetic */ com.ss.android.download.api.config.wg vw;

        public AnonymousClass1(com.ss.android.download.api.config.wg wgVar) {
            this.vw = wgVar;
        }

        @Override // com.ss.android.socialbase.downloader.common.AppStatusManager.InnerAppStatusChangeCaller
        public boolean isAppInBackground() {
            return this.vw.vw();
        }
    }

    /* renamed from: com.ss.android.downloadlib.yl$2, reason: invalid class name */
    public class AnonymousClass2 implements com.ss.android.socialbase.downloader.depend.INotificationClickCallback {
        public AnonymousClass2() {
        }

        private boolean vw(com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo) {
            com.ss.android.download.api.config.qm tq = com.ss.android.downloadlib.addownload.z.tq();
            if (tq == null) {
                return false;
            }
            com.ss.android.downloadad.api.vw.wg vw = com.ss.android.downloadlib.addownload.wg.kz.vw().vw(downloadInfo);
            java.lang.String vw2 = (vw == null || !vw.t()) ? com.ss.android.downloadlib.addownload.x.vw(downloadInfo) : com.ss.android.socialbase.downloader.setting.DownloadSetting.obtain(downloadInfo.getId()).optString("ad_notification_jump_url", null);
            if (android.text.TextUtils.isEmpty(vw2)) {
                return false;
            }
            return tq.vw(com.ss.android.downloadlib.addownload.z.getContext(), vw2);
        }

        @Override // com.ss.android.socialbase.downloader.depend.INotificationClickCallback
        public boolean onClickWhenInstalled(com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo) {
            if (downloadInfo == null) {
                return false;
            }
            com.ss.android.downloadad.api.vw.wg vw = com.ss.android.downloadlib.addownload.wg.kz.vw().vw(downloadInfo);
            if (vw != null) {
                com.ss.android.downloadlib.wg.vw.vw(vw);
            } else {
                com.ss.android.downloadlib.bt.x.wg(com.ss.android.downloadlib.addownload.z.getContext(), downloadInfo.getPackageName());
            }
            com.ss.android.socialbase.downloader.notification.DownloadNotificationManager.getInstance().cancelNotification(downloadInfo.getId());
            return true;
        }

        @Override // com.ss.android.socialbase.downloader.depend.INotificationClickCallback
        public boolean onClickWhenSuccess(com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo) {
            return false;
        }

        @Override // com.ss.android.socialbase.downloader.depend.INotificationClickCallback
        public boolean onClickWhenUnSuccess(com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo) {
            com.ss.android.socialbase.downloader.setting.DownloadSetting obtain = com.ss.android.socialbase.downloader.setting.DownloadSetting.obtain(downloadInfo.getId());
            if (obtain.optInt("notification_opt_2") != 1) {
                boolean vw = vw(downloadInfo);
                if (obtain.optInt("disable_delete_dialog", 0) == 1) {
                    return true;
                }
                return vw;
            }
            if (downloadInfo.getStatus() == -2) {
                com.ss.android.socialbase.appdownloader.DownloadHandlerService.vw(com.ss.android.downloadlib.addownload.z.getContext(), downloadInfo, com.ss.android.socialbase.appdownloader.v.es().wg(), com.ss.android.socialbase.downloader.downloader.Downloader.getInstance(com.ss.android.downloadlib.addownload.z.getContext()).getDownloadNotificationEventListener(downloadInfo.getId()));
            }
            return true;
        }
    }

    /* renamed from: com.ss.android.downloadlib.yl$3, reason: invalid class name */
    public class AnonymousClass3 implements java.lang.Runnable {
        public AnonymousClass3() {
        }

        @Override // java.lang.Runnable
        public void run() {
            com.ss.android.socialbase.appdownloader.kz.yl.vw("");
            if (com.ss.android.socialbase.appdownloader.kz.yl.d()) {
                com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.setNotAutoRebootService(true);
            }
            if (com.ss.android.socialbase.downloader.setting.DownloadSetting.obtainGlobal().optInt("disable_security_init", 1) == 1) {
                com.ss.android.socialbase.appdownloader.kz.kz.vw(com.ss.android.downloadlib.addownload.z.getContext());
            }
        }
    }

    @Override // com.ss.android.download.api.vw
    public com.ss.android.download.api.vw vw(@androidx.annotation.NonNull com.ss.android.download.api.config.bt btVar) {
        com.ss.android.downloadlib.addownload.z.vw(btVar);
        return this;
    }

    @Override // com.ss.android.download.api.vw
    public com.ss.android.download.api.vw vw(@androidx.annotation.NonNull com.ss.android.download.api.config.es esVar) {
        com.ss.android.downloadlib.addownload.z.vw(esVar);
        return this;
    }

    @Override // com.ss.android.download.api.vw
    public com.ss.android.download.api.vw vw(com.ss.android.download.api.config.k kVar) {
        com.ss.android.downloadlib.addownload.z.vw(kVar);
        return this;
    }

    @Override // com.ss.android.download.api.vw
    public com.ss.android.download.api.vw vw(@androidx.annotation.NonNull com.ss.android.download.api.config.o oVar) {
        com.ss.android.downloadlib.addownload.z.vw(oVar);
        return this;
    }

    @Override // com.ss.android.download.api.vw
    public com.ss.android.download.api.vw vw(@androidx.annotation.NonNull com.ss.android.download.api.config.vl vlVar) {
        com.ss.android.downloadlib.addownload.z.vw(vlVar);
        return this;
    }

    @Override // com.ss.android.download.api.vw
    public com.ss.android.download.api.vw vw(@androidx.annotation.NonNull com.ss.android.download.api.config.wg wgVar) {
        com.ss.android.downloadlib.addownload.z.vw(wgVar);
        com.ss.android.socialbase.downloader.common.AppStatusManager.getInstance().setInnerAppStatusChangeCaller(new com.ss.android.downloadlib.yl.AnonymousClass1(wgVar));
        return this;
    }

    @Override // com.ss.android.download.api.vw
    public com.ss.android.download.api.vw vw(@androidx.annotation.NonNull com.ss.android.download.api.config.x xVar) {
        com.ss.android.downloadlib.addownload.z.vw(xVar);
        return this;
    }

    @Override // com.ss.android.download.api.vw
    public com.ss.android.download.api.vw vw(@androidx.annotation.NonNull com.ss.android.download.api.model.vw vwVar) {
        com.ss.android.downloadlib.addownload.z.vw(vwVar);
        return this;
    }

    @Override // com.ss.android.download.api.vw
    public com.ss.android.download.api.vw vw(com.ss.android.socialbase.downloader.downloader.DownloaderBuilder downloaderBuilder) {
        if (downloaderBuilder.getNotificationClickCallback() == null) {
            downloaderBuilder.notificationClickCallback(new com.ss.android.downloadlib.yl.AnonymousClass2());
        }
        downloaderBuilder.addDownloadCompleteHandler(new com.ss.android.downloadlib.t.t());
        com.ss.android.socialbase.downloader.downloader.Downloader.initOrCover(downloaderBuilder, true);
        return this;
    }

    @Override // com.ss.android.download.api.vw
    public com.ss.android.download.api.vw vw(java.lang.String str) {
        com.ss.android.downloadlib.addownload.z.vw(str);
        return this;
    }

    @Override // com.ss.android.download.api.vw
    public void vw() {
        if (!com.ss.android.downloadlib.addownload.z.h()) {
            com.ss.android.downloadlib.yl.t.vw().vw("ttdownloader init error");
        }
        com.ss.android.downloadlib.addownload.z.vw(com.ss.android.downloadlib.yl.t.vw());
        try {
            com.ss.android.socialbase.appdownloader.v.es().wg(com.ss.android.downloadlib.addownload.z.n());
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
        com.ss.android.socialbase.appdownloader.v.es().vw(com.ss.android.downloadlib.vw.vw());
        com.ss.android.downloadlib.v.vw().wg(new com.ss.android.downloadlib.yl.AnonymousClass3());
    }
}
