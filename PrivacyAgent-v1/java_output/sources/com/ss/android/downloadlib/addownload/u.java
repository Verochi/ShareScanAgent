package com.ss.android.downloadlib.addownload;

/* loaded from: classes19.dex */
public class u {
    private static com.ss.android.downloadlib.addownload.vw.v vw;
    private static com.ss.android.downloadlib.addownload.vw.t wg;

    /* renamed from: com.ss.android.downloadlib.addownload.u$1, reason: invalid class name */
    public static class AnonymousClass1 implements com.ss.android.downloadlib.addownload.vw.v {
        final /* synthetic */ com.ss.android.downloadad.api.vw.wg t;
        final /* synthetic */ com.ss.android.downloadlib.addownload.v.o v;
        final /* synthetic */ int vw;
        final /* synthetic */ boolean wg;

        public AnonymousClass1(int i, boolean z, com.ss.android.downloadad.api.vw.wg wgVar, com.ss.android.downloadlib.addownload.v.o oVar) {
            this.vw = i;
            this.wg = z;
            this.t = wgVar;
            this.v = oVar;
        }

        @Override // com.ss.android.downloadlib.addownload.vw.v
        public void vw() {
            com.ss.android.downloadlib.addownload.u.vw((com.ss.android.downloadlib.addownload.vw.v) null);
            com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo = com.ss.android.socialbase.downloader.downloader.Downloader.getInstance(com.ss.android.downloadlib.addownload.z.getContext()).getDownloadInfo(this.vw);
            if (downloadInfo != null) {
                downloadInfo.startPauseReserveOnWifi();
                com.ss.android.socialbase.downloader.impls.RetryScheduler.getInstance().tryStartScheduleRetry(downloadInfo);
                if (this.wg) {
                    com.ss.android.downloadlib.v.vw.vw().vw("cancel_pause_reserve_wifi_confirm", this.t);
                } else {
                    com.ss.android.downloadlib.v.vw.vw().wg("pause_reserve_wifi_confirm", this.t);
                }
            }
            this.v.vw(this.t);
        }

        @Override // com.ss.android.downloadlib.addownload.vw.v
        public void wg() {
            com.ss.android.downloadlib.addownload.u.vw((com.ss.android.downloadlib.addownload.vw.v) null);
            com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo = com.ss.android.socialbase.downloader.downloader.Downloader.getInstance(com.ss.android.downloadlib.addownload.z.getContext()).getDownloadInfo(this.vw);
            if (downloadInfo != null) {
                downloadInfo.stopPauseReserveOnWifi();
            }
            if (this.wg) {
                com.ss.android.downloadlib.v.vw.vw().vw("cancel_pause_reserve_wifi_cancel", this.t);
            } else {
                com.ss.android.downloadlib.v.vw.vw().wg("pause_reserve_wifi_cancel", this.t);
            }
            this.v.vw(this.t);
        }
    }

    /* renamed from: com.ss.android.downloadlib.addownload.u$2, reason: invalid class name */
    public static class AnonymousClass2 implements com.ss.android.downloadlib.addownload.vw.t {
        final /* synthetic */ com.ss.android.downloadad.api.vw.wg vw;
        final /* synthetic */ com.ss.android.downloadlib.addownload.vw.t wg;

        public AnonymousClass2(com.ss.android.downloadad.api.vw.wg wgVar, com.ss.android.downloadlib.addownload.vw.t tVar) {
            this.vw = wgVar;
            this.wg = tVar;
        }

        @Override // com.ss.android.downloadlib.addownload.vw.t
        public void delete() {
            com.ss.android.downloadlib.v.vw.vw().vw("cancel_pause_reserve_wifi_delete", this.vw);
            this.wg.delete();
        }
    }

    public static com.ss.android.downloadlib.addownload.vw.v vw() {
        return vw;
    }

    public static void vw(com.ss.android.downloadlib.addownload.vw.t tVar) {
        wg = tVar;
    }

    public static void vw(com.ss.android.downloadlib.addownload.vw.v vVar) {
        vw = vVar;
    }

    public static boolean vw(int i) {
        return i == 1 || i == 2 || i == 3 || i == 4 || i == 5 || i == 7 || i == 8;
    }

    public static boolean vw(com.ss.android.downloadad.api.vw.wg wgVar, com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo, int i, com.ss.android.downloadlib.addownload.v.o oVar, boolean z, com.ss.android.downloadlib.addownload.vw.t tVar) {
        if (wgVar == null) {
            com.ss.android.downloadlib.yl.t.vw().vw("tryReverseWifi nativeModel null");
            return false;
        }
        if (downloadInfo == null) {
            com.ss.android.downloadlib.yl.t.vw().vw("tryReverseWifi info null");
            return false;
        }
        int id = downloadInfo.getId();
        boolean t = z ? com.ss.android.downloadlib.bt.yl.t(wgVar) : com.ss.android.downloadlib.bt.yl.wg(wgVar);
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        try {
            jSONObject.putOpt("switch_status", java.lang.Integer.valueOf(t ? 1 : 0));
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
        if (z) {
            com.ss.android.downloadlib.v.vw.vw().vw("cancel_pause_reserve_wifi_switch_status", jSONObject, wgVar);
        } else {
            com.ss.android.downloadlib.v.vw.vw().vw("pause_reserve_wifi_switch_status", jSONObject, wgVar);
        }
        if (!t || !vw(i) || com.ss.android.socialbase.downloader.utils.DownloadUtils.isWifi(com.ss.android.downloadlib.addownload.z.getContext())) {
            return false;
        }
        if (!z && downloadInfo.hasPauseReservedOnWifi()) {
            return false;
        }
        vw(new com.ss.android.downloadlib.addownload.u.AnonymousClass1(id, z, wgVar, oVar));
        if (z && tVar != null) {
            vw(new com.ss.android.downloadlib.addownload.u.AnonymousClass2(wgVar, tVar));
        }
        if (z) {
            com.ss.android.downloadlib.activity.TTDelegateActivity.vw(wgVar, "删除");
        } else {
            com.ss.android.downloadlib.activity.TTDelegateActivity.wg(wgVar);
        }
        return true;
    }

    public static com.ss.android.downloadlib.addownload.vw.t wg() {
        return wg;
    }
}
