package com.ss.android.downloadlib.addownload.v;

/* loaded from: classes19.dex */
public class t implements com.ss.android.downloadlib.addownload.v.bt {
    private static com.ss.android.downloadlib.addownload.vw.v vw;
    private static com.ss.android.downloadlib.addownload.vw.t wg;

    /* renamed from: com.ss.android.downloadlib.addownload.v.t$1, reason: invalid class name */
    public class AnonymousClass1 implements com.ss.android.downloadlib.addownload.vw.v {
        final /* synthetic */ int t;
        final /* synthetic */ com.ss.android.downloadad.api.vw.wg v;
        final /* synthetic */ int vw;
        final /* synthetic */ int wg;
        final /* synthetic */ com.ss.android.downloadlib.addownload.v.o yl;

        public AnonymousClass1(int i, int i2, int i3, com.ss.android.downloadad.api.vw.wg wgVar, com.ss.android.downloadlib.addownload.v.o oVar) {
            this.vw = i;
            this.wg = i2;
            this.t = i3;
            this.v = wgVar;
            this.yl = oVar;
        }

        @Override // com.ss.android.downloadlib.addownload.vw.v
        public void vw() {
            com.ss.android.downloadlib.addownload.vw.v unused = com.ss.android.downloadlib.addownload.v.t.vw = null;
            com.ss.android.downloadlib.addownload.v.t.this.vw(this.vw, this.wg, this.t, this.v, "download_percent_cancel", "confirm");
        }

        @Override // com.ss.android.downloadlib.addownload.vw.v
        public void wg() {
            com.ss.android.downloadlib.addownload.vw.v unused = com.ss.android.downloadlib.addownload.v.t.vw = null;
            com.ss.android.downloadlib.addownload.v.t.this.vw(this.vw, this.wg, this.t, this.v, "download_percent_cancel", com.anythink.expressad.d.a.b.dO);
            this.yl.vw(this.v);
        }
    }

    /* renamed from: com.ss.android.downloadlib.addownload.v.t$2, reason: invalid class name */
    public class AnonymousClass2 implements com.ss.android.downloadlib.addownload.vw.t {
        final /* synthetic */ int t;
        final /* synthetic */ com.ss.android.downloadad.api.vw.wg v;
        final /* synthetic */ int vw;
        final /* synthetic */ int wg;
        final /* synthetic */ com.ss.android.downloadlib.addownload.vw.t yl;

        public AnonymousClass2(int i, int i2, int i3, com.ss.android.downloadad.api.vw.wg wgVar, com.ss.android.downloadlib.addownload.vw.t tVar) {
            this.vw = i;
            this.wg = i2;
            this.t = i3;
            this.v = wgVar;
            this.yl = tVar;
        }

        @Override // com.ss.android.downloadlib.addownload.vw.t
        public void delete() {
            com.ss.android.downloadlib.addownload.vw.v unused = com.ss.android.downloadlib.addownload.v.t.vw = null;
            com.ss.android.downloadlib.addownload.v.t.this.vw(this.vw, this.wg, this.t, this.v, "download_percent_cancel", "delete");
            this.yl.delete();
        }
    }

    private int vw(int i) {
        return com.ss.android.socialbase.downloader.setting.DownloadSetting.obtain(i).optInt("cancel_pause_optimise_download_percent_value", 50);
    }

    public static com.ss.android.downloadlib.addownload.vw.v vw() {
        return vw;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vw(int i, int i2, int i3, com.ss.android.downloadad.api.vw.wg wgVar, java.lang.String str, java.lang.String str2) {
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        try {
            jSONObject.putOpt("pause_optimise_type", str);
            jSONObject.putOpt("pause_optimise_action", str2);
            jSONObject.putOpt("download_percent", java.lang.Integer.valueOf(i));
            jSONObject.putOpt("download_current_bytes", java.lang.Integer.valueOf(i2));
            jSONObject.putOpt("download_total_bytes", java.lang.Integer.valueOf(i3));
        } catch (org.json.JSONException e) {
            e.printStackTrace();
        }
        com.ss.android.downloadlib.v.vw.vw().vw("pause_cancel_optimise", jSONObject, wgVar);
    }

    public static void vw(com.ss.android.downloadlib.addownload.vw.t tVar) {
        wg = tVar;
    }

    private boolean vw(com.ss.android.downloadad.api.vw.vw vwVar) {
        return com.ss.android.downloadlib.bt.yl.vw(vwVar).optInt("cancel_pause_optimise_download_percent_retain_switch", 0) == 1 && vwVar.k();
    }

    public static com.ss.android.downloadlib.addownload.vw.t wg() {
        return wg;
    }

    @Override // com.ss.android.downloadlib.addownload.v.bt
    public boolean vw(com.ss.android.downloadad.api.vw.wg wgVar, int i, com.ss.android.downloadlib.addownload.v.o oVar, com.ss.android.downloadlib.addownload.vw.t tVar) {
        if (wgVar == null || !vw(wgVar)) {
            return false;
        }
        com.ss.android.socialbase.downloader.model.DownloadInfo vw2 = !android.text.TextUtils.isEmpty(wgVar.ux()) ? com.ss.android.downloadlib.o.vw(com.ss.android.downloadlib.addownload.z.getContext()).vw(wgVar.ux(), null, true) : com.ss.android.downloadlib.o.vw(com.ss.android.downloadlib.addownload.z.getContext()).wg(wgVar.vw());
        if (vw2 == null) {
            return false;
        }
        long curBytes = vw2.getCurBytes();
        long totalBytes = vw2.getTotalBytes();
        if (curBytes < 0 || totalBytes <= 0) {
            return false;
        }
        int vw3 = com.ss.android.downloadlib.addownload.es.vw(vw2.getId(), (int) ((100 * curBytes) / totalBytes));
        int i2 = (int) (curBytes / 1048576);
        boolean z = vw3 > vw(wgVar.tq());
        vw = new com.ss.android.downloadlib.addownload.v.t.AnonymousClass1(vw3, i2, i2, wgVar, oVar);
        java.lang.String vw4 = com.ss.android.downloadlib.bt.vl.vw(com.ss.android.downloadlib.addownload.es.vw(wgVar.tq(), curBytes, totalBytes));
        java.lang.String format = z ? java.lang.String.format("该任务已下载%s，仅需%s即可下载完成，是否继续？", vw4, com.ss.android.downloadlib.bt.vl.vw(totalBytes - curBytes)) : java.lang.String.format("该任务已下载%s，即将下载完成，是否继续下载？", vw4);
        if (tVar != null) {
            vw(new com.ss.android.downloadlib.addownload.v.t.AnonymousClass2(vw3, i2, i2, wgVar, tVar));
        }
        com.ss.android.downloadlib.activity.TTDelegateActivity.wg(wgVar, format, "继续", "暂停", "删除");
        return true;
    }
}
