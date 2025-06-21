package com.ss.android.downloadlib;

/* loaded from: classes19.dex */
public class t implements com.ss.android.socialbase.appdownloader.t.o {
    private static java.lang.String vw = "t";
    private android.os.Handler wg = new android.os.Handler(android.os.Looper.getMainLooper());

    /* renamed from: com.ss.android.downloadlib.t$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {
        public AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public void run() {
            com.ss.android.downloadlib.addownload.z.t().vw(5, com.ss.android.downloadlib.addownload.z.getContext(), null, "无网络，请检查网络设置", null, 0);
        }
    }

    /* renamed from: com.ss.android.downloadlib.t$2, reason: invalid class name */
    public class AnonymousClass2 implements java.lang.Runnable {
        final /* synthetic */ com.ss.android.socialbase.downloader.setting.DownloadSetting vw;
        final /* synthetic */ com.ss.android.download.api.download.DownloadModel wg;

        public AnonymousClass2(com.ss.android.socialbase.downloader.setting.DownloadSetting downloadSetting, com.ss.android.download.api.download.DownloadModel downloadModel) {
            this.vw = downloadSetting;
            this.wg = downloadModel;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.ss.android.downloadlib.addownload.z.t().vw(2, com.ss.android.downloadlib.addownload.z.getContext(), this.wg, this.vw.optString("no_enough_space_toast_text", "您的存储空间不足，请清理后再试"), null, 0);
        }
    }

    /* renamed from: com.ss.android.downloadlib.t$3, reason: invalid class name */
    public class AnonymousClass3 implements com.ss.android.socialbase.downloader.common.AppStatusManager.AppStatusChangeListener {
        final /* synthetic */ long t;
        final /* synthetic */ double v;
        final /* synthetic */ com.ss.android.downloadad.api.vw.wg vw;
        final /* synthetic */ long wg;
        final /* synthetic */ com.ss.android.socialbase.downloader.model.DownloadInfo yl;

        public AnonymousClass3(com.ss.android.downloadad.api.vw.wg wgVar, long j, long j2, double d, com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo) {
            this.vw = wgVar;
            this.wg = j;
            this.t = j2;
            this.v = d;
            this.yl = downloadInfo;
        }

        @Override // com.ss.android.socialbase.downloader.common.AppStatusManager.AppStatusChangeListener
        public void onAppBackground() {
        }

        @Override // com.ss.android.socialbase.downloader.common.AppStatusManager.AppStatusChangeListener
        public void onAppForeground() {
            if (com.ss.android.downloadlib.bt.vl.wg(this.vw)) {
                com.ss.android.socialbase.downloader.common.AppStatusManager.getInstance().unregisterAppSwitchListener(this);
                return;
            }
            long j = this.wg;
            if (j <= -1 || this.t <= -1 || j >= this.v) {
                return;
            }
            com.ss.android.downloadlib.v.vw.vw().vw("clean_space_install", com.ss.android.downloadlib.addownload.v.vw("install_no_enough_space"), this.vw);
            if (com.ss.android.downloadlib.addownload.v.vw(this.yl, ((long) this.v) - this.wg)) {
                com.ss.android.socialbase.downloader.common.AppStatusManager.getInstance().unregisterAppSwitchListener(this);
                this.vw.bt(true);
            }
        }
    }

    private void vw(@androidx.annotation.NonNull com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo) {
        if (com.ss.android.downloadlib.bt.yl.kz(downloadInfo.getId())) {
            com.ss.android.downloadlib.v.vw().wg(new com.ss.android.downloadlib.addownload.t.wg(downloadInfo));
        }
    }

    private void vw(com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo, com.ss.android.downloadad.api.vw.wg wgVar) {
        long vw2 = com.ss.android.downloadlib.bt.vl.vw(android.os.Environment.getDataDirectory(), -1L);
        long min = java.lang.Math.min(524288000L, com.ss.android.downloadlib.bt.vl.vw(android.os.Environment.getDataDirectory()) / 10);
        long totalBytes = downloadInfo.getTotalBytes();
        double d = (totalBytes * 2.5d) + min;
        if (vw2 > -1 && totalBytes > -1) {
            double d2 = vw2;
            if (d2 < d && d - d2 > com.ss.android.downloadlib.addownload.v.wg()) {
                com.ss.android.downloadlib.addownload.v.vw(downloadInfo.getId());
            }
        }
        com.ss.android.socialbase.downloader.common.AppStatusManager.getInstance().registerAppSwitchListener(new com.ss.android.downloadlib.t.AnonymousClass3(wgVar, vw2, totalBytes, d, downloadInfo));
    }

    @Override // com.ss.android.socialbase.appdownloader.t.o
    public void vw(com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo, com.ss.android.socialbase.downloader.exception.BaseException baseException, int i) {
        com.ss.android.socialbase.downloader.exception.BaseException baseException2;
        com.ss.android.download.api.download.DownloadModel vw2;
        if (downloadInfo == null) {
            return;
        }
        if (i == -1 && baseException != null) {
            org.json.JSONObject jSONObject = new org.json.JSONObject();
            com.ss.android.downloadlib.bt.kz.t(downloadInfo, jSONObject);
            com.ss.android.downloadlib.vw.vw(jSONObject, downloadInfo);
            com.ss.android.downloadlib.bt.z.vw("download_failed", jSONObject.toString());
        }
        com.ss.android.downloadad.api.vw.wg vw3 = com.ss.android.downloadlib.addownload.wg.kz.vw().vw(downloadInfo);
        if (vw3 == null) {
            return;
        }
        try {
            if (i != -1) {
                if (i == -3) {
                    com.ss.android.downloadlib.vw.vw(downloadInfo, vw3);
                    return;
                }
                if (i == 2001) {
                    com.ss.android.downloadlib.vw.vw().vw(downloadInfo, vw3, 2001);
                    return;
                } else {
                    if (i == 11) {
                        com.ss.android.downloadlib.vw.vw().vw(downloadInfo, vw3, 2000);
                        if (vw3.jb()) {
                            return;
                        }
                        vw(downloadInfo, vw3);
                        return;
                    }
                    return;
                }
            }
            if (baseException != null) {
                if (com.ss.android.socialbase.downloader.setting.DownloadSetting.obtain(downloadInfo.getId()).optInt("toast_without_network", 0) == 1 && baseException.getErrorCode() == 1049) {
                    this.wg.post(new com.ss.android.downloadlib.t.AnonymousClass1());
                }
                if (com.ss.android.socialbase.downloader.utils.DownloadUtils.isInsufficientSpaceError(baseException)) {
                    if (com.ss.android.downloadlib.addownload.z.u() != null) {
                        com.ss.android.downloadlib.addownload.z.u();
                        vw3.wg();
                    }
                    com.ss.android.downloadlib.v.vw.vw().vw("download_failed_for_space", vw3);
                    if (!vw3.xs()) {
                        com.ss.android.downloadlib.v.vw.vw().vw("download_can_restart", vw3);
                        vw(downloadInfo);
                    }
                    if ((com.ss.android.downloadlib.addownload.z.u() == null || !com.ss.android.downloadlib.addownload.z.u().t()) && (vw2 = com.ss.android.downloadlib.addownload.wg.kz.vw().vw(vw3.wg())) != null && vw2.isShowToast()) {
                        com.ss.android.socialbase.downloader.setting.DownloadSetting obtain = com.ss.android.socialbase.downloader.setting.DownloadSetting.obtain(downloadInfo.getId());
                        if (obtain.optInt("show_no_enough_space_toast", 0) == 1) {
                            this.wg.post(new com.ss.android.downloadlib.t.AnonymousClass2(obtain, vw2));
                        }
                    }
                }
                baseException2 = new com.ss.android.socialbase.downloader.exception.BaseException(baseException.getErrorCode(), com.ss.android.downloadlib.bt.vl.vw(baseException.getMessage(), com.ss.android.downloadlib.addownload.z.x().optInt(com.ss.android.socialbase.downloader.setting.DownloadSettingKeys.KEY_EXCEPTION_MSG_LENGTH, 500)));
            } else {
                baseException2 = null;
            }
            com.ss.android.downloadlib.v.vw.vw().wg(downloadInfo, baseException2);
            com.ss.android.downloadlib.bt.vw().vw(downloadInfo, baseException, "");
        } catch (java.lang.Exception e) {
            com.ss.android.downloadlib.addownload.z.q().vw(e, "onAppDownloadMonitorSend");
        }
    }
}
