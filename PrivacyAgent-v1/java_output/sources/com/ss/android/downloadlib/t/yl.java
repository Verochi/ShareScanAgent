package com.ss.android.downloadlib.t;

/* loaded from: classes19.dex */
public class yl implements com.ss.android.socialbase.downloader.monitor.InnerEventListener {
    @Override // com.ss.android.socialbase.downloader.monitor.InnerEventListener
    public void onEvent(int i, java.lang.String str, org.json.JSONObject jSONObject) {
        com.ss.android.downloadad.api.vw.wg vw;
        com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo = com.ss.android.socialbase.downloader.downloader.Downloader.getInstance(com.ss.android.downloadlib.addownload.z.getContext()).getDownloadInfo(i);
        if (downloadInfo == null || (vw = com.ss.android.downloadlib.addownload.wg.kz.vw().vw(downloadInfo)) == null) {
            return;
        }
        if (com.ss.android.socialbase.downloader.constants.MonitorConstants.EventLabel.INSTALL_VIEW_RESULT.equals(str)) {
            jSONObject = com.ss.android.downloadlib.bt.vl.vw(jSONObject);
            com.ss.android.downloadlib.vw.vw(jSONObject, downloadInfo);
            com.ss.android.downloadlib.bt.vl.vw(jSONObject, "model_id", java.lang.Long.valueOf(vw.wg()));
        }
        com.ss.android.downloadlib.v.vw.vw().wg(str, jSONObject, vw);
    }

    @Override // com.ss.android.socialbase.downloader.monitor.InnerEventListener
    public void onUnityEvent(int i, java.lang.String str, org.json.JSONObject jSONObject) {
        com.ss.android.downloadad.api.vw.wg vw;
        com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo = com.ss.android.socialbase.downloader.downloader.Downloader.getInstance(com.ss.android.downloadlib.addownload.z.getContext()).getDownloadInfo(i);
        if (downloadInfo == null || (vw = com.ss.android.downloadlib.addownload.wg.kz.vw().vw(downloadInfo)) == null) {
            return;
        }
        com.ss.android.downloadlib.v.vw.vw().vw(str, jSONObject, vw);
    }
}
