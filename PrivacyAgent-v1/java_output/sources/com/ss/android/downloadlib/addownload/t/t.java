package com.ss.android.downloadlib.addownload.t;

/* loaded from: classes19.dex */
public class t {
    public static void vw() {
        java.util.List<com.ss.android.socialbase.downloader.model.DownloadInfo> vw = com.ss.android.socialbase.appdownloader.v.es().vw(com.ss.android.downloadlib.addownload.z.getContext());
        if (vw == null || vw.size() <= 0) {
            return;
        }
        for (int i = 0; i < vw.size(); i++) {
            com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo = vw.get(i);
            java.io.File file = new java.io.File(downloadInfo.getTempPath(), downloadInfo.getTempName());
            long lastModified = file.lastModified();
            long optInt = com.ss.android.socialbase.downloader.setting.DownloadSetting.obtain(downloadInfo.getId()).optInt("download_file_expire_hours", 0) * 3600000;
            if (optInt <= 0) {
                optInt = 604800000;
            }
            if (file.isFile() && file.exists() && java.lang.System.currentTimeMillis() - lastModified >= optInt) {
                vw(file);
                com.ss.android.socialbase.downloader.downloader.Downloader.getInstance(com.ss.android.downloadlib.addownload.z.getContext()).clearDownloadData(downloadInfo.getId());
            }
        }
    }

    public static void vw(android.content.Context context) {
        java.io.File externalCacheDir;
        if (context == null || (externalCacheDir = context.getExternalCacheDir()) == null) {
            return;
        }
        try {
            vw(externalCacheDir.getPath());
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0030 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void vw(java.io.File file) {
        java.io.FileOutputStream fileOutputStream;
        java.lang.Exception e;
        java.io.FileOutputStream fileOutputStream2 = null;
        try {
            try {
                fileOutputStream = new java.io.FileOutputStream(file);
                try {
                    fileOutputStream.write("1".getBytes());
                    fileOutputStream.close();
                } catch (java.lang.Exception e2) {
                    e = e2;
                    e.printStackTrace();
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (java.lang.Exception e3) {
                            e3.printStackTrace();
                        }
                    }
                    file.delete();
                }
            } catch (java.lang.Throwable th) {
                th = th;
                fileOutputStream2 = fileOutputStream;
                if (fileOutputStream2 != null) {
                    try {
                        fileOutputStream2.close();
                    } catch (java.lang.Exception e4) {
                        e4.printStackTrace();
                    }
                }
                throw th;
            }
        } catch (java.lang.Exception e5) {
            fileOutputStream = null;
            e = e5;
        } catch (java.lang.Throwable th2) {
            th = th2;
            if (fileOutputStream2 != null) {
            }
            throw th;
        }
        file.delete();
    }

    private static void vw(java.lang.String str) {
        java.io.File file = new java.io.File(str);
        if (file.exists()) {
            if (file.isFile()) {
                file.delete();
                return;
            }
            java.lang.String[] list = file.list();
            if (list == null) {
                return;
            }
            for (java.lang.String str2 : list) {
                if (str2 != null) {
                    java.lang.String str3 = java.io.File.separator;
                    java.lang.String str4 = str.endsWith(str3) ? str + str2 : str + str3 + str2;
                    java.io.File file2 = new java.io.File(str4);
                    if (file2.isFile()) {
                        file2.delete();
                    }
                    if (file2.isDirectory()) {
                        vw(str4);
                    }
                }
            }
            file.delete();
        }
    }

    public static void wg() {
        java.util.List successedDownloadInfosWithMimeType = com.ss.android.socialbase.downloader.downloader.Downloader.getInstance(com.ss.android.downloadlib.addownload.z.getContext()).getSuccessedDownloadInfosWithMimeType("application/vnd.android.package-archive");
        if (successedDownloadInfosWithMimeType == null || successedDownloadInfosWithMimeType.isEmpty()) {
            return;
        }
        for (int i = 0; i < successedDownloadInfosWithMimeType.size(); i++) {
            com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo = (com.ss.android.socialbase.downloader.model.DownloadInfo) successedDownloadInfosWithMimeType.get(i);
            if (downloadInfo != null) {
                java.lang.String str = downloadInfo.getSavePath() + java.io.File.separator + downloadInfo.getName();
                java.io.File file = new java.io.File(str);
                if (file.exists()) {
                    long currentTimeMillis = java.lang.System.currentTimeMillis() - file.lastModified();
                    long optInt = com.ss.android.socialbase.downloader.setting.DownloadSetting.obtain(downloadInfo.getId()).optInt("download_complete_file_expire_hours", 0) * 3600000;
                    if (optInt <= 0) {
                        optInt = 604800000;
                    }
                    boolean z = true;
                    if (currentTimeMillis < optInt && !com.ss.android.downloadlib.bt.vl.kz(com.ss.android.downloadlib.addownload.z.getContext(), str)) {
                        z = false;
                    }
                    if (z) {
                        vw(file);
                    }
                }
            }
        }
    }
}
