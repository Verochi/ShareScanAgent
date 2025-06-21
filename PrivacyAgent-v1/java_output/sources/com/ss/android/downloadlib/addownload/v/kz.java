package com.ss.android.downloadlib.addownload.v;

/* loaded from: classes19.dex */
public class kz implements com.ss.android.downloadlib.addownload.v.x {
    private static com.ss.android.downloadlib.addownload.vw.v vw;

    /* renamed from: com.ss.android.downloadlib.addownload.v.kz$1, reason: invalid class name */
    public class AnonymousClass1 implements com.ss.android.downloadlib.addownload.vw.v {
        final /* synthetic */ com.ss.android.downloadad.api.vw.wg vw;
        final /* synthetic */ com.ss.android.downloadlib.addownload.v.o wg;

        public AnonymousClass1(com.ss.android.downloadad.api.vw.wg wgVar, com.ss.android.downloadlib.addownload.v.o oVar) {
            this.vw = wgVar;
            this.wg = oVar;
        }

        @Override // com.ss.android.downloadlib.addownload.vw.v
        public void vw() {
            com.ss.android.downloadlib.addownload.vw.v unused = com.ss.android.downloadlib.addownload.v.kz.vw = null;
            org.json.JSONObject jSONObject = new org.json.JSONObject();
            try {
                jSONObject.putOpt("pause_optimise_type", "download_percent");
                jSONObject.putOpt("pause_optimise_action", "confirm");
            } catch (org.json.JSONException e) {
                e.printStackTrace();
            }
            com.ss.android.downloadlib.v.vw.vw().vw("pause_optimise", jSONObject, this.vw);
        }

        @Override // com.ss.android.downloadlib.addownload.vw.v
        public void wg() {
            com.ss.android.downloadlib.addownload.vw.v unused = com.ss.android.downloadlib.addownload.v.kz.vw = null;
            org.json.JSONObject jSONObject = new org.json.JSONObject();
            try {
                jSONObject.putOpt("pause_optimise_type", "download_percent");
                jSONObject.putOpt("pause_optimise_action", com.anythink.expressad.d.a.b.dO);
            } catch (org.json.JSONException e) {
                e.printStackTrace();
            }
            com.ss.android.downloadlib.v.vw.vw().vw("pause_optimise", jSONObject, this.vw);
            this.wg.vw(this.vw);
        }
    }

    private int vw(int i) {
        return com.ss.android.socialbase.downloader.setting.DownloadSetting.obtain(i).optInt("pause_optimise_download_percent", 50);
    }

    public static com.ss.android.downloadlib.addownload.vw.v vw() {
        return vw;
    }

    private boolean vw(com.ss.android.downloadad.api.vw.vw vwVar) {
        return com.ss.android.downloadlib.bt.yl.vw(vwVar).optInt("pause_optimise_download_percent_switch", 0) == 1 && vwVar.k();
    }

    @Override // com.ss.android.downloadlib.addownload.v.x
    public boolean vw(com.ss.android.downloadad.api.vw.wg wgVar, int i, com.ss.android.downloadlib.addownload.v.o oVar) {
        if (wgVar == null || wgVar.hp() || !vw(wgVar)) {
            return false;
        }
        com.ss.android.socialbase.downloader.model.DownloadInfo vw2 = !android.text.TextUtils.isEmpty(wgVar.ux()) ? com.ss.android.downloadlib.o.vw(com.ss.android.downloadlib.addownload.z.getContext()).vw(wgVar.ux(), null, true) : com.ss.android.downloadlib.o.vw(com.ss.android.downloadlib.addownload.z.getContext()).wg(wgVar.vw());
        if (vw2 == null) {
            return false;
        }
        long curBytes = vw2.getCurBytes();
        long totalBytes = vw2.getTotalBytes();
        if (curBytes > 0 && totalBytes > 0) {
            int vw3 = com.ss.android.downloadlib.addownload.es.vw(vw2.getId(), (int) ((curBytes * 100) / totalBytes));
            if (vw3 > vw(wgVar.tq())) {
                vw = new com.ss.android.downloadlib.addownload.v.kz.AnonymousClass1(wgVar, oVar);
                com.ss.android.downloadlib.activity.TTDelegateActivity.wg(wgVar, java.lang.String.format("已下载%s%%，即将下载完成，是否继续下载？", java.lang.Integer.valueOf(vw3)), "继续", "暂停");
                wgVar.d(true);
                return true;
            }
        }
        return false;
    }
}
