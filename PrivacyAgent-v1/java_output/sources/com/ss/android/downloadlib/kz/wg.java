package com.ss.android.downloadlib.kz;

/* loaded from: classes19.dex */
public class wg implements com.ss.android.socialbase.appdownloader.t.es {
    @Override // com.ss.android.socialbase.appdownloader.t.es
    public void vw(com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo, com.ss.android.socialbase.appdownloader.t.x xVar) {
        com.ss.android.downloadad.api.vw.wg vw;
        if (downloadInfo != null && (vw = com.ss.android.downloadlib.addownload.wg.kz.vw().vw(downloadInfo)) != null) {
            downloadInfo.setLinkMode(vw.a());
        }
        if (xVar != null) {
            xVar.vw();
        }
    }
}
