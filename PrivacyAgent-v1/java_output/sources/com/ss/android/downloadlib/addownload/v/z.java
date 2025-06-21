package com.ss.android.downloadlib.addownload.v;

/* loaded from: classes19.dex */
public class z {
    private static com.ss.android.downloadlib.addownload.v.z vw;
    private java.util.List<com.ss.android.downloadlib.addownload.v.x> wg;

    private z() {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        this.wg = arrayList;
        arrayList.add(new com.ss.android.downloadlib.addownload.v.es());
        this.wg.add(new com.ss.android.downloadlib.addownload.v.vl());
        this.wg.add(new com.ss.android.downloadlib.addownload.v.kz());
        this.wg.add(new com.ss.android.downloadlib.addownload.v.vw());
    }

    public static com.ss.android.downloadlib.addownload.v.z vw() {
        if (vw == null) {
            synchronized (com.ss.android.downloadlib.addownload.v.z.class) {
                if (vw == null) {
                    vw = new com.ss.android.downloadlib.addownload.v.z();
                }
            }
        }
        return vw;
    }

    public void vw(com.ss.android.downloadad.api.vw.wg wgVar, int i, com.ss.android.downloadlib.addownload.v.o oVar) {
        java.util.List<com.ss.android.downloadlib.addownload.v.x> list = this.wg;
        if (list == null || list.size() == 0 || wgVar == null) {
            oVar.vw(wgVar);
            return;
        }
        com.ss.android.socialbase.downloader.model.DownloadInfo vw2 = !android.text.TextUtils.isEmpty(wgVar.ux()) ? com.ss.android.downloadlib.o.vw((android.content.Context) null).vw(wgVar.ux(), null, true) : com.ss.android.downloadlib.o.vw((android.content.Context) null).wg(wgVar.vw());
        if (vw2 == null || !"application/vnd.android.package-archive".equals(vw2.getMimeType())) {
            oVar.vw(wgVar);
            return;
        }
        boolean z = com.ss.android.socialbase.downloader.setting.DownloadSetting.obtain(wgVar.tq()).optInt("pause_optimise_switch", 0) == 1;
        for (com.ss.android.downloadlib.addownload.v.x xVar : this.wg) {
            if (z || (xVar instanceof com.ss.android.downloadlib.addownload.v.vl)) {
                if (xVar.vw(wgVar, i, oVar)) {
                    return;
                }
            }
        }
        oVar.vw(wgVar);
    }
}
