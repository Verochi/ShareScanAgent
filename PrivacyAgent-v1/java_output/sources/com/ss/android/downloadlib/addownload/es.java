package com.ss.android.downloadlib.addownload;

/* loaded from: classes19.dex */
public class es {
    public static int vw(int i, int i2) {
        return (i2 <= 0 || i2 >= 100 || !vw(i)) ? i2 : (int) (java.lang.Math.sqrt(i2) * 10.0d);
    }

    public static long vw(int i, long j, long j2) {
        if (!vw(i)) {
            return j;
        }
        if (j <= 0) {
            return 0L;
        }
        return j2 <= 0 ? j : (j2 * vw(i, (int) ((j * 100) / j2))) / 100;
    }

    public static com.ss.android.download.api.model.DownloadShortInfo vw(com.ss.android.download.api.model.DownloadShortInfo downloadShortInfo) {
        if (downloadShortInfo != null && vw((int) downloadShortInfo.id)) {
            downloadShortInfo.currentBytes = vw((int) downloadShortInfo.id, downloadShortInfo.currentBytes, downloadShortInfo.totalBytes);
        }
        return downloadShortInfo;
    }

    private static boolean vw(int i) {
        return com.ss.android.socialbase.downloader.setting.DownloadSetting.obtain(i).optInt("pause_optimise_pretend_download_percent_switch", 0) == 1 && com.ss.android.socialbase.downloader.setting.DownloadSetting.obtain(i).optInt("pause_optimise_switch", 0) == 1;
    }
}
