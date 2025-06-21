package com.ss.android.downloadlib.addownload.t;

/* loaded from: classes19.dex */
public class wg implements java.lang.Runnable {
    private com.ss.android.socialbase.downloader.model.DownloadInfo vw;

    /* renamed from: com.ss.android.downloadlib.addownload.t.wg$1, reason: invalid class name */
    public class AnonymousClass1 implements com.ss.android.downloadlib.addownload.t.yl {
        final /* synthetic */ com.ss.android.downloadad.api.vw.wg vw;

        public AnonymousClass1(com.ss.android.downloadad.api.vw.wg wgVar) {
            this.vw = wgVar;
        }
    }

    public wg(com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo) {
        this.vw = downloadInfo;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.ss.android.downloadad.api.vw.wg vw;
        if (this.vw == null || (vw = com.ss.android.downloadlib.addownload.wg.kz.vw().vw(this.vw)) == null) {
            return;
        }
        com.ss.android.downloadlib.v.vw.vw().vw("cleanspace_task", vw);
        long longValue = java.lang.Double.valueOf((com.ss.android.downloadlib.bt.yl.vw(this.vw.getId()) + 1.0d) * this.vw.getTotalBytes()).longValue() - this.vw.getCurBytes();
        long wg = com.ss.android.downloadlib.bt.vl.wg(0L);
        if (com.ss.android.downloadlib.addownload.z.u() != null) {
            com.ss.android.downloadlib.addownload.z.u();
        }
        com.ss.android.downloadlib.addownload.t.t.vw();
        com.ss.android.downloadlib.addownload.t.t.wg();
        if (com.ss.android.downloadlib.bt.yl.bt(vw.tq())) {
            com.ss.android.downloadlib.addownload.t.t.vw(com.ss.android.downloadlib.addownload.z.getContext());
        }
        long wg2 = com.ss.android.downloadlib.bt.vl.wg(0L);
        if (wg2 >= longValue) {
            vw.vl("1");
            com.ss.android.downloadlib.addownload.wg.x.vw().vw(vw);
            org.json.JSONObject jSONObject = new org.json.JSONObject();
            try {
                jSONObject.putOpt("quite_clean_size", java.lang.Long.valueOf(wg2 - wg));
            } catch (org.json.JSONException e) {
                e.printStackTrace();
            }
            com.ss.android.downloadlib.v.vw.vw().vw("cleanspace_download_after_quite_clean", jSONObject, vw);
            com.ss.android.socialbase.downloader.downloader.Downloader.getInstance(com.ss.android.downloadlib.addownload.z.getContext()).restart(this.vw.getId());
            return;
        }
        if (com.ss.android.downloadlib.addownload.z.u() != null) {
            vw.v(false);
            com.ss.android.downloadlib.addownload.t.v.vw().vw(vw.vw(), new com.ss.android.downloadlib.addownload.t.wg.AnonymousClass1(vw));
            if (com.ss.android.downloadlib.addownload.z.u().vw(this.vw.getId(), this.vw.getUrl(), true, longValue)) {
                vw.yl(true);
                return;
            }
            return;
        }
        org.json.JSONObject jSONObject2 = new org.json.JSONObject();
        try {
            jSONObject2.putOpt("show_dialog_result", 3);
        } catch (org.json.JSONException e2) {
            e2.printStackTrace();
        }
        com.ss.android.downloadlib.v.vw.vw().vw("cleanspace_window_show", jSONObject2, vw);
    }
}
