package com.ss.android.downloadlib.t;

/* loaded from: classes19.dex */
public class o {

    /* renamed from: com.ss.android.downloadlib.t.o$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {
        final /* synthetic */ int vw;
        final /* synthetic */ com.ss.android.downloadad.api.vw.wg wg;

        public AnonymousClass1(int i, com.ss.android.downloadad.api.vw.wg wgVar) {
            this.vw = i;
            this.wg = wgVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo = com.ss.android.socialbase.downloader.downloader.Downloader.getInstance(com.ss.android.downloadlib.addownload.z.getContext()).getDownloadInfo(this.vw);
            org.json.JSONObject jSONObject = new org.json.JSONObject();
            com.ss.android.downloadlib.bt.vl.vw(jSONObject, "ttdownloader_type", (java.lang.Object) 1);
            com.ss.android.downloadlib.bt.kz.t(downloadInfo, jSONObject);
            if (downloadInfo == null || -2 != downloadInfo.getRealStatus() || downloadInfo.isPauseReserveOnWifi()) {
                com.ss.android.downloadlib.bt.vl.vw(jSONObject, "error_code", (java.lang.Object) 1001);
            } else {
                com.ss.android.downloadlib.t.o.this.vw(this.vw, this.wg, jSONObject);
            }
            com.ss.android.downloadlib.v.vw.vw().wg("download_notification_try_show", jSONObject, this.wg);
        }
    }

    /* renamed from: com.ss.android.downloadlib.t.o$2, reason: invalid class name */
    public class AnonymousClass2 implements java.lang.Runnable {
        final /* synthetic */ int vw;
        final /* synthetic */ com.ss.android.downloadad.api.vw.wg wg;

        public AnonymousClass2(int i, com.ss.android.downloadad.api.vw.wg wgVar) {
            this.vw = i;
            this.wg = wgVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo = com.ss.android.socialbase.downloader.downloader.Downloader.getInstance(com.ss.android.downloadlib.addownload.z.getContext()).getDownloadInfo(this.vw);
            org.json.JSONObject jSONObject = new org.json.JSONObject();
            com.ss.android.downloadlib.bt.vl.vw(jSONObject, "ttdownloader_type", (java.lang.Object) 2);
            com.ss.android.downloadlib.bt.kz.t(downloadInfo, jSONObject);
            if (com.ss.android.downloadlib.bt.vl.wg(this.wg)) {
                com.ss.android.downloadlib.bt.vl.vw(jSONObject, "error_code", (java.lang.Object) 1002);
            } else {
                com.ss.android.downloadlib.t.o.this.vw(this.vw, this.wg, jSONObject);
            }
            com.ss.android.downloadlib.v.vw.vw().wg("download_notification_try_show", jSONObject, this.wg);
        }
    }

    /* renamed from: com.ss.android.downloadlib.t.o$3, reason: invalid class name */
    public class AnonymousClass3 implements java.lang.Runnable {
        final /* synthetic */ int vw;
        final /* synthetic */ com.ss.android.downloadad.api.vw.wg wg;

        public AnonymousClass3(int i, com.ss.android.downloadad.api.vw.wg wgVar) {
            this.vw = i;
            this.wg = wgVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo = com.ss.android.socialbase.downloader.downloader.Downloader.getInstance(com.ss.android.downloadlib.addownload.z.getContext()).getDownloadInfo(this.vw);
            org.json.JSONObject jSONObject = new org.json.JSONObject();
            com.ss.android.downloadlib.bt.vl.vw(jSONObject, "ttdownloader_type", (java.lang.Object) 3);
            com.ss.android.downloadlib.bt.kz.t(downloadInfo, jSONObject);
            if (com.ss.android.downloadlib.bt.vl.t(this.wg.yl())) {
                com.ss.android.downloadlib.bt.vl.vw(jSONObject, "error_code", (java.lang.Object) 1003);
            } else {
                com.ss.android.downloadlib.t.o.this.vw(this.vw, this.wg, jSONObject);
            }
            com.ss.android.downloadlib.v.vw.vw().wg("download_notification_try_show", jSONObject, this.wg);
        }
    }

    public static class vw {
        private static com.ss.android.downloadlib.t.o vw = new com.ss.android.downloadlib.t.o(null);
    }

    private o() {
    }

    public /* synthetic */ o(com.ss.android.downloadlib.t.o.AnonymousClass1 anonymousClass1) {
        this();
    }

    private void t(@androidx.annotation.NonNull com.ss.android.downloadad.api.vw.wg wgVar, long j) {
        int tq = wgVar.tq();
        if (com.ss.android.socialbase.downloader.setting.DownloadSetting.obtain(tq).optInt("notification_opt_2") != 1) {
            return;
        }
        vw(tq);
        com.ss.android.downloadlib.v.vw().vw(new com.ss.android.downloadlib.t.o.AnonymousClass2(tq, wgVar), j * 1000);
    }

    public static com.ss.android.downloadlib.t.o vw() {
        return com.ss.android.downloadlib.t.o.vw.vw;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vw(int i, com.ss.android.downloadad.api.vw.wg wgVar, org.json.JSONObject jSONObject) {
        if (!com.ss.android.socialbase.appdownloader.yl.v.vw()) {
            com.ss.android.downloadlib.bt.vl.vw(jSONObject, "error_code", (java.lang.Object) 1004);
            return;
        }
        com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo = com.ss.android.socialbase.downloader.downloader.Downloader.getInstance(com.ss.android.downloadlib.addownload.z.getContext()).getDownloadInfo(i);
        if (downloadInfo == null) {
            com.ss.android.downloadlib.bt.vl.vw(jSONObject, "error_code", (java.lang.Object) 1005);
            return;
        }
        if (com.ss.android.socialbase.downloader.notification.DownloadNotificationManager.getInstance().getNotificationItem(i) != null) {
            com.ss.android.socialbase.downloader.notification.DownloadNotificationManager.getInstance().cancelNotification(i);
        }
        com.ss.android.socialbase.appdownloader.yl.vw vwVar = new com.ss.android.socialbase.appdownloader.yl.vw(com.ss.android.downloadlib.addownload.z.getContext(), i, downloadInfo.getTitle(), downloadInfo.getSavePath(), downloadInfo.getName(), downloadInfo.getExtra());
        vwVar.setCurBytes(downloadInfo.getCurBytes());
        vwVar.setTotalBytes(downloadInfo.getTotalBytes());
        vwVar.refreshStatus(downloadInfo.getStatus(), null, false, false);
        com.ss.android.socialbase.downloader.notification.DownloadNotificationManager.getInstance().addNotification(vwVar);
        vwVar.updateNotification(null, false);
        com.ss.android.downloadlib.v.vw.vw().wg("download_notification_show", jSONObject, wgVar);
    }

    private void wg(@androidx.annotation.NonNull com.ss.android.downloadad.api.vw.wg wgVar, long j) {
        int tq = wgVar.tq();
        if (com.ss.android.socialbase.downloader.setting.DownloadSetting.obtain(tq).optInt("notification_opt_2") != 1) {
            return;
        }
        vw(tq);
        com.ss.android.downloadlib.v.vw().vw(new com.ss.android.downloadlib.t.o.AnonymousClass1(tq, wgVar), j * 1000);
    }

    public void kz(@androidx.annotation.NonNull com.ss.android.downloadad.api.vw.wg wgVar) {
        vw(wgVar, com.ss.android.socialbase.downloader.setting.DownloadSetting.obtain(wgVar.tq()).optInt("noti_open_delay_secs", 5));
    }

    public void t(@androidx.annotation.NonNull com.ss.android.downloadad.api.vw.wg wgVar) {
        t(wgVar, 5L);
    }

    public void v(@androidx.annotation.NonNull com.ss.android.downloadad.api.vw.wg wgVar) {
        t(wgVar, com.ss.android.socialbase.downloader.setting.DownloadSetting.obtain(wgVar.tq()).optInt("noti_install_delay_secs", 5));
    }

    public void vw(int i) {
        com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo;
        if (com.ss.android.socialbase.appdownloader.yl.t.vw().vw(i) != null || (downloadInfo = com.ss.android.socialbase.downloader.downloader.Downloader.getInstance(com.ss.android.downloadlib.addownload.z.getContext()).getDownloadInfo(i)) == null) {
            return;
        }
        com.ss.android.socialbase.appdownloader.yl.t.vw().vw(i, downloadInfo.getIconUrl());
    }

    public void vw(com.ss.android.downloadad.api.vw.wg wgVar) {
        wg(wgVar, 5L);
    }

    public void vw(@androidx.annotation.NonNull com.ss.android.downloadad.api.vw.wg wgVar, long j) {
        int tq = wgVar.tq();
        if (com.ss.android.socialbase.downloader.setting.DownloadSetting.obtain(tq).optInt("notification_opt_2") != 1) {
            return;
        }
        vw(tq);
        com.ss.android.downloadlib.v.vw().vw(new com.ss.android.downloadlib.t.o.AnonymousClass3(tq, wgVar), j * 1000);
    }

    public void wg(com.ss.android.downloadad.api.vw.wg wgVar) {
        if (wgVar == null) {
            return;
        }
        wg(wgVar, com.ss.android.socialbase.downloader.setting.DownloadSetting.obtain(wgVar.tq()).optInt("noti_continue_delay_secs", 5));
    }

    public void yl(@androidx.annotation.NonNull com.ss.android.downloadad.api.vw.wg wgVar) {
        vw(wgVar, 5L);
    }
}
