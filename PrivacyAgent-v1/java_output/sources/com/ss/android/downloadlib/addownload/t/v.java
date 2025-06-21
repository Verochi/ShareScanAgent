package com.ss.android.downloadlib.addownload.t;

/* loaded from: classes19.dex */
public class v {
    private static volatile com.ss.android.downloadlib.addownload.t.v vw;
    private long wg = 0;
    private java.util.concurrent.ConcurrentHashMap<java.lang.String, com.ss.android.downloadlib.addownload.t.yl> t = new java.util.concurrent.ConcurrentHashMap<>();
    private java.util.HashMap<java.lang.String, java.lang.Integer> v = new java.util.HashMap<>();
    private java.util.List<java.lang.String> yl = new java.util.concurrent.CopyOnWriteArrayList();

    public static com.ss.android.downloadlib.addownload.t.v vw() {
        if (vw == null) {
            synchronized (com.ss.android.downloadlib.addownload.t.v.class) {
                if (vw == null) {
                    vw = new com.ss.android.downloadlib.addownload.t.v();
                }
            }
        }
        return vw;
    }

    @androidx.annotation.WorkerThread
    public static void vw(com.ss.android.downloadad.api.vw.wg wgVar) {
        com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo;
        if (wgVar == null || wgVar.wg() <= 0 || (downloadInfo = com.ss.android.socialbase.downloader.downloader.Downloader.getInstance(com.ss.android.downloadlib.addownload.z.getContext()).getDownloadInfo(wgVar.tq())) == null) {
            return;
        }
        vw(downloadInfo);
    }

    @androidx.annotation.WorkerThread
    public static void vw(com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo) {
        if (downloadInfo == null || com.ss.android.socialbase.downloader.setting.DownloadSetting.obtain(downloadInfo.getId()).optInt("delete_file_after_install", 0) == 0) {
            return;
        }
        try {
            java.lang.String str = downloadInfo.getSavePath() + java.io.File.separator + downloadInfo.getName();
            if (android.text.TextUtils.isEmpty(str)) {
                return;
            }
            java.io.File file = new java.io.File(str);
            if (file.isFile() && file.exists()) {
                file.delete();
            }
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    public void t() {
        this.wg = java.lang.System.currentTimeMillis();
    }

    public void vw(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return;
        }
        this.t.remove(str);
    }

    public void vw(java.lang.String str, com.ss.android.downloadlib.addownload.t.yl ylVar) {
        if (android.text.TextUtils.isEmpty(str)) {
            return;
        }
        this.t.put(str, ylVar);
    }

    public int wg(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return 0;
        }
        if (this.v == null) {
            this.v = new java.util.HashMap<>();
        }
        if (this.v.containsKey(str)) {
            return this.v.get(str).intValue();
        }
        return 0;
    }

    public long wg() {
        return this.wg;
    }
}
