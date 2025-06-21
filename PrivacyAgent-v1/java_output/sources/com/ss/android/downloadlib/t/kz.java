package com.ss.android.downloadlib.t;

/* loaded from: classes19.dex */
public class kz implements com.ss.android.socialbase.appdownloader.t.v {
    private android.content.Context vw;

    public kz(android.content.Context context) {
        this.vw = context.getApplicationContext();
    }

    @Override // com.ss.android.socialbase.appdownloader.t.v
    public void vw(int i, int i2, java.lang.String str, int i3, long j) {
        com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo;
        com.ss.android.downloadad.api.vw.wg vw;
        android.content.Context context = this.vw;
        if (context == null || (downloadInfo = com.ss.android.socialbase.downloader.downloader.Downloader.getInstance(context).getDownloadInfo(i)) == null || downloadInfo.getStatus() == 0 || (vw = com.ss.android.downloadlib.addownload.wg.kz.vw().vw(downloadInfo)) == null) {
            return;
        }
        if (i2 == 1) {
            com.ss.android.downloadlib.vw.vw(downloadInfo, vw);
            if ("application/vnd.android.package-archive".equals(downloadInfo.getMimeType())) {
                com.ss.android.downloadlib.addownload.vw.vw().vw(downloadInfo, vw.wg(), vw.vl(), vw.yl(), downloadInfo.getTitle(), vw.v(), downloadInfo.getTargetFilePath());
                return;
            }
            return;
        }
        if (i2 == 3) {
            com.ss.android.downloadlib.v.vw.vw().vw("download_notification", "download_notification_install", com.ss.android.downloadlib.vw.wg(new org.json.JSONObject(), downloadInfo), vw);
            return;
        }
        if (i2 == 5) {
            com.ss.android.downloadlib.v.vw.vw().vw("download_notification", "download_notification_pause", vw);
        } else if (i2 == 6) {
            com.ss.android.downloadlib.v.vw.vw().vw("download_notification", "download_notification_continue", vw);
        } else {
            if (i2 != 7) {
                return;
            }
            com.ss.android.downloadlib.v.vw.vw().vw("download_notification", "download_notification_click", vw);
        }
    }

    @Override // com.ss.android.socialbase.appdownloader.t.v
    public void vw(int i, int i2, java.lang.String str, java.lang.String str2, java.lang.String str3) {
        com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo;
        android.content.Context context = this.vw;
        if (context == null || (downloadInfo = com.ss.android.socialbase.downloader.downloader.Downloader.getInstance(context).getDownloadInfo(i)) == null || downloadInfo.getStatus() != -3) {
            return;
        }
        downloadInfo.setPackageName(str2);
        com.ss.android.downloadlib.addownload.wg.vw().vw(this.vw, downloadInfo);
    }

    @Override // com.ss.android.socialbase.appdownloader.t.v
    public void vw(android.content.Context context, java.lang.String str) {
        com.ss.android.downloadlib.vw.vw().vw(str);
    }

    @Override // com.ss.android.socialbase.appdownloader.t.v
    public void vw(com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo) {
        if (downloadInfo == null) {
            return;
        }
        com.ss.android.downloadlib.bt.vw().vw(downloadInfo);
        if (com.ss.android.socialbase.downloader.setting.DownloadSetting.obtain(downloadInfo.getId()).optInt("report_download_cancel", 1) == 1) {
            com.ss.android.downloadlib.v.vw.vw().vw(downloadInfo, new com.ss.android.socialbase.downloader.exception.BaseException(1012, ""));
        } else {
            com.ss.android.downloadlib.v.vw.vw().wg(downloadInfo, new com.ss.android.socialbase.downloader.exception.BaseException(1012, ""));
        }
    }

    @Override // com.ss.android.socialbase.appdownloader.t.v
    public boolean vw() {
        return com.ss.android.downloadlib.addownload.wg.vw().wg();
    }

    @Override // com.ss.android.socialbase.appdownloader.t.v
    public boolean vw(int i, boolean z) {
        if (com.ss.android.downloadlib.addownload.z.d() != null) {
            return com.ss.android.downloadlib.addownload.z.d().vw(z);
        }
        return false;
    }
}
