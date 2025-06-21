package com.ss.android.downloadlib.addownload.t;

/* loaded from: classes19.dex */
public class vw implements com.ss.android.socialbase.downloader.depend.IDownloadDiskSpaceHandler {
    private int vw;

    private void vw() {
        com.ss.android.downloadlib.addownload.z.j();
        com.ss.android.downloadlib.addownload.t.t.vw();
        com.ss.android.downloadlib.addownload.t.t.wg();
    }

    private void vw(long j, long j2, long j3, long j4, long j5) {
        com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo = com.ss.android.socialbase.downloader.downloader.Downloader.getInstance(com.ss.android.downloadlib.addownload.z.getContext()).getDownloadInfo(this.vw);
        if (downloadInfo == null) {
            return;
        }
        try {
            com.ss.android.downloadlib.vw.vw().vw(downloadInfo, j, j2, j3, j4, j5, j2 > j3);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    private boolean vw(com.ss.android.socialbase.downloader.setting.DownloadSetting downloadSetting) {
        if (downloadSetting.optInt("clear_space_use_disk_handler", 0) != 1) {
            return false;
        }
        return java.lang.System.currentTimeMillis() - com.ss.android.downloadlib.addownload.t.v.vw().wg() >= downloadSetting.optLong("clear_space_min_time_interval", 600000L);
    }

    private long wg(com.ss.android.socialbase.downloader.setting.DownloadSetting downloadSetting) {
        long optLong = downloadSetting.optLong("clear_space_sleep_time", 0L);
        if (optLong <= 0) {
            return 0L;
        }
        if (optLong > 5000) {
            optLong = 5000;
        }
        com.ss.android.downloadlib.bt.z.wg("AppDownloadDiskSpaceHandler", "waiting for space clear, sleepTime = ".concat(java.lang.String.valueOf(optLong)), null);
        try {
            java.lang.Thread.sleep(optLong);
        } catch (java.lang.InterruptedException e) {
            e.printStackTrace();
        }
        com.ss.android.downloadlib.bt.z.wg("AppDownloadDiskSpaceHandler", "waiting end!", null);
        return optLong;
    }

    @Override // com.ss.android.socialbase.downloader.depend.IDownloadDiskSpaceHandler
    public boolean cleanUpDisk(long j, long j2, com.ss.android.socialbase.downloader.depend.IDownloadDiskSpaceCallback iDownloadDiskSpaceCallback) {
        long j3;
        com.ss.android.socialbase.downloader.setting.DownloadSetting obtain = com.ss.android.socialbase.downloader.setting.DownloadSetting.obtain(this.vw);
        if (!vw(obtain)) {
            return false;
        }
        long currentTimeMillis = java.lang.System.currentTimeMillis();
        com.ss.android.downloadlib.addownload.t.v.vw().t();
        long wg = com.ss.android.downloadlib.bt.vl.wg(0L);
        vw();
        long wg2 = com.ss.android.downloadlib.bt.vl.wg(0L);
        long currentTimeMillis2 = java.lang.System.currentTimeMillis() - currentTimeMillis;
        if (wg2 < j2) {
            long wg3 = wg(obtain);
            if (wg3 > 0) {
                wg2 = com.ss.android.downloadlib.bt.vl.wg(0L);
            }
            j3 = wg3;
        } else {
            j3 = 0;
        }
        com.ss.android.downloadlib.bt.z.wg("AppDownloadDiskSpaceHandler", "cleanUpDisk, byteRequired = " + j2 + ", byteAvailableAfter = " + wg2 + ", cleaned = " + (wg2 - wg), null);
        long j4 = wg2;
        vw(wg, wg2, j2, currentTimeMillis2, j3);
        if (j4 < j2) {
            return false;
        }
        if (iDownloadDiskSpaceCallback == null) {
            return true;
        }
        iDownloadDiskSpaceCallback.onDiskCleaned();
        return true;
    }

    public void vw(int i) {
        this.vw = i;
    }
}
