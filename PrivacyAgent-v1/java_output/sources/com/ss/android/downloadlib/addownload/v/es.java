package com.ss.android.downloadlib.addownload.v;

/* loaded from: classes19.dex */
public class es implements com.ss.android.downloadlib.addownload.v.x {
    private long vw(int i) {
        return com.ss.android.socialbase.downloader.setting.DownloadSetting.obtain(i).optInt("pause_optimise_mistake_click_interval", 300);
    }

    private boolean wg(int i) {
        return com.ss.android.socialbase.downloader.setting.DownloadSetting.obtain(i).optInt("pause_optimise_mistake_click_interval_switch", 0) == 1;
    }

    @Override // com.ss.android.downloadlib.addownload.v.x
    public boolean vw(com.ss.android.downloadad.api.vw.wg wgVar, int i, com.ss.android.downloadlib.addownload.v.o oVar) {
        if (wgVar == null || !wg(wgVar.tq())) {
            return false;
        }
        if (java.lang.System.currentTimeMillis() - wgVar.kn() > vw(wgVar.tq())) {
            return false;
        }
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        try {
            jSONObject.putOpt("pause_optimise_type", "mistake_click");
        } catch (org.json.JSONException e) {
            e.printStackTrace();
        }
        com.ss.android.downloadlib.v.vw.vw().vw("pause_optimise", jSONObject, wgVar);
        return true;
    }
}
