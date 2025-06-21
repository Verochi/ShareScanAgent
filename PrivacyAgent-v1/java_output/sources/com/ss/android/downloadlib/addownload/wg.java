package com.ss.android.downloadlib.addownload;

/* loaded from: classes19.dex */
public class wg {
    private static volatile com.ss.android.downloadlib.addownload.wg vw;
    private android.os.Handler wg = null;

    /* renamed from: com.ss.android.downloadlib.addownload.wg$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {
        final /* synthetic */ java.lang.String vw;

        public AnonymousClass1(java.lang.String str) {
            this.vw = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.ss.android.downloadlib.addownload.z.t().vw(3, com.ss.android.downloadlib.addownload.z.getContext(), null, "下载失败，请重试！", null, 0);
            com.ss.android.downloadlib.addownload.yl vw = com.ss.android.downloadlib.bt.vw().vw(this.vw);
            if (vw != null) {
                vw.bt();
            }
        }
    }

    public static com.ss.android.downloadlib.addownload.wg vw() {
        if (vw == null) {
            synchronized (com.ss.android.downloadlib.addownload.wg.class) {
                if (vw == null) {
                    vw = new com.ss.android.downloadlib.addownload.wg();
                }
            }
        }
        return vw;
    }

    public void vw(android.content.Context context, com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo) {
        if (wg() && downloadInfo != null) {
            try {
                java.io.File file = new java.io.File(downloadInfo.getSavePath(), downloadInfo.getName());
                if (file.isFile() && file.exists()) {
                    file.delete();
                }
            } catch (java.lang.Exception e) {
                e.printStackTrace();
            }
            if (this.wg == null) {
                this.wg = new android.os.Handler(android.os.Looper.getMainLooper());
            }
            java.lang.String url = downloadInfo.getUrl();
            com.ss.android.socialbase.downloader.downloader.Downloader.getInstance(context).clearDownloadData(downloadInfo.getId());
            this.wg.post(new com.ss.android.downloadlib.addownload.wg.AnonymousClass1(url));
        }
    }

    public boolean wg() {
        return com.ss.android.downloadlib.addownload.z.x().optInt("forbid_invalidte_download_file_install", 0) == 1;
    }
}
