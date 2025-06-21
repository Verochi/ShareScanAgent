package com.ss.android.downloadlib.t;

/* loaded from: classes19.dex */
public class wg implements com.ss.android.socialbase.downloader.depend.IDownloadCompleteHandler {
    @Override // com.ss.android.socialbase.downloader.depend.IDownloadCompleteHandler
    public void handle(com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo) throws com.ss.android.socialbase.downloader.exception.BaseException {
        android.content.pm.PackageInfo vw = com.ss.android.socialbase.appdownloader.t.vw(com.ss.android.downloadlib.addownload.z.getContext(), downloadInfo, downloadInfo.getSavePath(), downloadInfo.getName());
        if (vw != null) {
            downloadInfo.setAppVersionCode(vw.versionCode);
        }
    }

    @Override // com.ss.android.socialbase.downloader.depend.IDownloadCompleteHandler
    public boolean needHandle(com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo) {
        return downloadInfo != null && com.ss.android.downloadlib.bt.yl.wg() && downloadInfo.getPackageInfo() == null;
    }
}
