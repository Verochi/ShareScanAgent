package com.ss.android.downloadlib.t;

/* loaded from: classes19.dex */
public class v implements com.ss.android.socialbase.appdownloader.t.bt, com.ss.android.socialbase.downloader.depend.IDownloadCacheSyncStatusListener {

    /* renamed from: com.ss.android.downloadlib.t.v$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {
        public AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public void run() {
            com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo;
            int spIntVal;
            com.ss.android.downloadlib.addownload.wg.kz.vw().wg();
            for (com.ss.android.downloadad.api.vw.wg wgVar : com.ss.android.downloadlib.addownload.wg.kz.vw().t().values()) {
                int tq = wgVar.tq();
                if (tq != 0) {
                    com.ss.android.socialbase.downloader.setting.DownloadSetting obtain = com.ss.android.socialbase.downloader.setting.DownloadSetting.obtain(tq);
                    if (obtain.optInt("notification_opt_2") == 1 && (downloadInfo = com.ss.android.socialbase.downloader.downloader.Downloader.getInstance(com.ss.android.downloadlib.addownload.z.getContext()).getDownloadInfo(tq)) != null) {
                        if (com.ss.android.downloadlib.bt.vl.wg(wgVar) && !com.ss.android.downloadlib.bt.vl.t(wgVar.yl())) {
                            int spIntVal2 = downloadInfo.getSpIntVal(com.ss.android.socialbase.downloader.constants.SpJsonConstants.RESTART_NOTIFY_OPEN_APP_COUNT);
                            if (spIntVal2 < obtain.optInt("noti_open_restart_times", 1)) {
                                com.ss.android.downloadlib.t.o.vw().yl(wgVar);
                                downloadInfo.setSpValue(com.ss.android.socialbase.downloader.constants.SpJsonConstants.RESTART_NOTIFY_OPEN_APP_COUNT, java.lang.String.valueOf(spIntVal2 + 1));
                            }
                        } else if (downloadInfo.getRealStatus() == -2) {
                            int spIntVal3 = downloadInfo.getSpIntVal(com.ss.android.socialbase.downloader.constants.SpJsonConstants.RESTART_NOTIFY_CONTINUE_COUNT);
                            if (spIntVal3 < obtain.optInt("noti_continue_restart_times", 1)) {
                                com.ss.android.downloadlib.t.o.vw().vw(wgVar);
                                downloadInfo.setSpValue(com.ss.android.socialbase.downloader.constants.SpJsonConstants.RESTART_NOTIFY_CONTINUE_COUNT, java.lang.String.valueOf(spIntVal3 + 1));
                            }
                        } else if (downloadInfo.getRealStatus() == -3 && com.ss.android.socialbase.downloader.utils.DownloadUtils.isFileDownloaded(downloadInfo) && !com.ss.android.downloadlib.bt.vl.wg(wgVar) && (spIntVal = downloadInfo.getSpIntVal(com.ss.android.socialbase.downloader.constants.SpJsonConstants.RESTART_NOTIFY_INSTALL_COUNT)) < obtain.optInt("noti_install_restart_times", 1)) {
                            com.ss.android.downloadlib.t.o.vw().t(wgVar);
                            downloadInfo.setSpValue(com.ss.android.socialbase.downloader.constants.SpJsonConstants.RESTART_NOTIFY_INSTALL_COUNT, java.lang.String.valueOf(spIntVal + 1));
                        }
                    }
                }
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.depend.IDownloadCacheSyncStatusListener
    public void onStart() {
    }

    @Override // com.ss.android.socialbase.downloader.depend.IDownloadCacheSyncStatusListener
    public void onSuccess() {
        com.ss.android.downloadlib.v.vw().vw(new com.ss.android.downloadlib.t.v.AnonymousClass1(), 5000L);
    }

    @androidx.annotation.WorkerThread
    public void vw(com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo, int i, boolean z) {
        com.ss.android.downloadlib.addownload.wg.kz.vw().wg();
        com.ss.android.downloadad.api.vw.wg vw = com.ss.android.downloadlib.addownload.wg.kz.vw().vw(downloadInfo);
        if (vw == null) {
            return;
        }
        try {
            if (z) {
                vw.t(downloadInfo.getFailedResumeCount());
            } else if (vw.b() == -1) {
                return;
            } else {
                vw.t(-1);
            }
            com.ss.android.downloadlib.addownload.wg.x.vw().vw(vw);
            org.json.JSONObject jSONObject = new org.json.JSONObject();
            jSONObject.put(com.ss.android.socialbase.downloader.constants.MonitorConstants.EXTRA_DOWNLOAD_ID, downloadInfo.getId());
            jSONObject.put("name", downloadInfo.getName());
            jSONObject.put("url", downloadInfo.getUrl());
            jSONObject.put(com.ss.android.socialbase.downloader.constants.MonitorConstants.EXTRA_DOWNLOAD_TIME, downloadInfo.getDownloadTime());
            jSONObject.put(com.ss.android.socialbase.downloader.constants.MonitorConstants.EXTRA_DOWNLOAD_STATUS, i);
            jSONObject.put(com.ss.android.socialbase.downloader.constants.MonitorConstants.EXTRA_DOWNLOAD_CUR_BYTES, downloadInfo.getCurBytes());
            jSONObject.put(com.ss.android.socialbase.downloader.constants.MonitorConstants.EXTRA_DOWNLOAD_TOTAL_BYTES, downloadInfo.getTotalBytes());
            int i2 = 1;
            jSONObject.put(com.ss.android.socialbase.downloader.constants.MonitorConstants.EXTRA_DOWNLOAD_ONLY_WIFI, downloadInfo.isOnlyWifi() ? 1 : 0);
            jSONObject.put(com.ss.android.socialbase.downloader.constants.MonitorConstants.EXTRA_DOWNLOAD_CHUNK_COUNT, downloadInfo.getChunkCount());
            if (!z) {
                i2 = 2;
            }
            jSONObject.put("launch_resumed", i2);
            jSONObject.put("failed_resume_count", downloadInfo.getFailedResumeCount());
            com.ss.android.downloadlib.v.vw.vw().vw("embeded_ad", "download_uncompleted", jSONObject, vw);
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.appdownloader.t.bt
    public void vw(com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo, boolean z) {
        if (downloadInfo == null) {
            return;
        }
        vw(downloadInfo, downloadInfo.getRealStatus(), z);
    }
}
