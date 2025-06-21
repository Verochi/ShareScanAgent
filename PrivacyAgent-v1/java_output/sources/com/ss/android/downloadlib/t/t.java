package com.ss.android.downloadlib.t;

/* loaded from: classes19.dex */
public class t implements com.ss.android.socialbase.downloader.depend.IDownloadCompleteHandler {
    private java.io.File vw(java.lang.String str, java.lang.String str2) {
        java.io.File file = new java.io.File(str2);
        java.lang.String name = file.getName();
        int lastIndexOf = name.lastIndexOf(46);
        if (lastIndexOf > 0) {
            str = name.substring(0, lastIndexOf);
        }
        return new java.io.File(file.getParent(), str + com.anythink.china.common.a.a.g);
    }

    @Override // com.ss.android.socialbase.downloader.depend.IDownloadCompleteHandler
    public void handle(com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo) throws com.ss.android.socialbase.downloader.exception.BaseException {
        com.ss.android.download.api.config.u z = com.ss.android.downloadlib.addownload.z.z();
        if (downloadInfo == null || z == null) {
            return;
        }
        java.io.File vw = vw(downloadInfo.getPackageName(), downloadInfo.getTargetFilePath());
        com.ss.android.downloadad.api.vw.wg vw2 = com.ss.android.downloadlib.addownload.wg.kz.vw().vw(downloadInfo);
        if (vw2 != null) {
            com.ss.android.downloadlib.bt.vl.vw(vw2.bt());
        }
        downloadInfo.setMimeType("application/vnd.android.package-archive");
        downloadInfo.setName(vw.getName());
        downloadInfo.setMd5(null);
    }

    @Override // com.ss.android.socialbase.downloader.depend.IDownloadCompleteHandler
    public boolean needHandle(com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo) {
        if (downloadInfo != null) {
            return com.ss.android.download.api.t.wg.vw(com.ss.android.socialbase.downloader.setting.DownloadSetting.obtain(downloadInfo.getId()), downloadInfo.getMimeType());
        }
        return false;
    }
}
