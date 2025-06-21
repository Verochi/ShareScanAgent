package com.ss.android.downloadlib.addownload.wg;

/* loaded from: classes19.dex */
public class o {
    private static volatile com.ss.android.downloadlib.addownload.wg.o vw;

    private o() {
    }

    public static com.ss.android.downloadlib.addownload.wg.o vw() {
        if (vw == null) {
            synchronized (com.ss.android.downloadlib.addownload.wg.v.class) {
                if (vw == null) {
                    vw = new com.ss.android.downloadlib.addownload.wg.o();
                }
            }
        }
        return vw;
    }

    public void vw(int i, int i2, com.ss.android.downloadad.api.vw.wg wgVar) {
        if (wgVar == null) {
            return;
        }
        com.ss.android.socialbase.downloader.setting.DownloadSetting obtain = com.ss.android.socialbase.downloader.setting.DownloadSetting.obtain(wgVar.tq());
        if (obtain.optInt("report_api_hijack", 0) == 0) {
            return;
        }
        int i3 = i2 - i;
        if (i <= 0 || i3 <= obtain.optInt("check_api_hijack_version_code_diff", 500)) {
            return;
        }
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        try {
            jSONObject.put("version_code_diff", i3);
            jSONObject.put("installed_version_code", i2);
            jSONObject.put("hijack_type", 1);
        } catch (org.json.JSONException e) {
            e.printStackTrace();
        }
        com.ss.android.downloadlib.v.vw.vw().wg("api_hijack", jSONObject, wgVar);
    }
}
