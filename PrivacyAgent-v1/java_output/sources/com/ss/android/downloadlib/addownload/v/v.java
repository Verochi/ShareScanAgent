package com.ss.android.downloadlib.addownload.v;

/* loaded from: classes19.dex */
public class v {
    private static com.ss.android.downloadlib.addownload.v.v vw;
    private java.util.List<com.ss.android.downloadlib.addownload.v.bt> wg;

    private v() {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        this.wg = arrayList;
        arrayList.add(new com.ss.android.downloadlib.addownload.v.yl());
        this.wg.add(new com.ss.android.downloadlib.addownload.v.wg());
        this.wg.add(new com.ss.android.downloadlib.addownload.v.t());
    }

    public static com.ss.android.downloadlib.addownload.v.v vw() {
        if (vw == null) {
            synchronized (com.ss.android.downloadlib.addownload.v.z.class) {
                if (vw == null) {
                    vw = new com.ss.android.downloadlib.addownload.v.v();
                }
            }
        }
        return vw;
    }

    public void vw(com.ss.android.downloadad.api.vw.wg wgVar, int i, com.ss.android.downloadlib.addownload.v.o oVar, com.ss.android.downloadlib.addownload.vw.t tVar) {
        java.util.List<com.ss.android.downloadlib.addownload.v.bt> list = this.wg;
        if (list == null || list.size() == 0 || wgVar == null) {
            oVar.vw(wgVar);
        }
        com.ss.android.socialbase.downloader.model.DownloadInfo vw2 = !android.text.TextUtils.isEmpty(wgVar.ux()) ? com.ss.android.downloadlib.o.vw(com.ss.android.downloadlib.addownload.z.getContext()).vw(wgVar.ux(), null, true) : com.ss.android.downloadlib.o.vw(com.ss.android.downloadlib.addownload.z.getContext()).wg(wgVar.vw());
        if (vw2 == null) {
            vw2 = com.ss.android.socialbase.downloader.downloader.Downloader.getInstance(com.ss.android.downloadlib.addownload.z.getContext()).getDownloadInfo(wgVar.tq());
        }
        if (vw2 == null || !"application/vnd.android.package-archive".equals(vw2.getMimeType())) {
            oVar.vw(wgVar);
            return;
        }
        if (new com.ss.android.downloadlib.addownload.v.es().vw(wgVar, i, oVar)) {
            return;
        }
        java.util.Iterator<com.ss.android.downloadlib.addownload.v.bt> it = this.wg.iterator();
        while (it.hasNext()) {
            if (it.next().vw(wgVar, i, oVar, tVar)) {
                return;
            }
        }
        oVar.vw(wgVar);
    }
}
