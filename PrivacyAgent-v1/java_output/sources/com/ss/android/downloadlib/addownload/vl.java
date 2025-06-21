package com.ss.android.downloadlib.addownload;

/* loaded from: classes19.dex */
public class vl implements com.ss.android.socialbase.downloader.downloader.IReserveWifiStatusListener {
    @Override // com.ss.android.socialbase.downloader.downloader.IReserveWifiStatusListener
    public void onStatusChanged(com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo, int i, int i2) {
        com.ss.android.downloadad.api.vw.wg vw = com.ss.android.downloadlib.addownload.wg.kz.vw().vw(downloadInfo);
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        try {
            jSONObject.putOpt("reserve_wifi_source", java.lang.Integer.valueOf(i2));
            jSONObject.putOpt("reserve_wifi_status", java.lang.Integer.valueOf(i));
        } catch (org.json.JSONException e) {
            e.printStackTrace();
        }
        com.ss.android.downloadlib.v.vw.vw().vw("pause_reserve_wifi", jSONObject, vw);
    }
}
