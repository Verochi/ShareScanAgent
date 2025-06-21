package com.ss.android.downloadlib.addownload;

/* loaded from: classes19.dex */
public class t {
    private static java.lang.String vw = "t";
    private static volatile com.ss.android.downloadlib.addownload.t wg;
    private java.util.concurrent.ConcurrentHashMap<java.lang.Long, java.lang.Runnable> t;

    /* renamed from: com.ss.android.downloadlib.addownload.t$1, reason: invalid class name */
    public class AnonymousClass1 implements com.ss.android.downloadlib.wg.v {
        final /* synthetic */ com.ss.android.download.api.download.DownloadModel t;
        final /* synthetic */ com.ss.android.downloadlib.addownload.yl vw;
        final /* synthetic */ int wg;

        public AnonymousClass1(com.ss.android.downloadlib.addownload.yl ylVar, int i, com.ss.android.download.api.download.DownloadModel downloadModel) {
            this.vw = ylVar;
            this.wg = i;
            this.t = downloadModel;
        }

        @Override // com.ss.android.downloadlib.wg.v
        public void vw(boolean z) {
            com.ss.android.downloadlib.addownload.t.this.vw(this.vw, z, this.wg, this.t);
        }
    }

    public t() {
        this.t = null;
        this.t = new java.util.concurrent.ConcurrentHashMap<>();
    }

    public static com.ss.android.downloadlib.addownload.t vw() {
        if (wg == null) {
            synchronized (com.ss.android.downloadlib.addownload.t.class) {
                if (wg == null) {
                    wg = new com.ss.android.downloadlib.addownload.t();
                }
            }
        }
        return wg;
    }

    private void vw(long j, boolean z, int i) {
        com.ss.android.downloadlib.v.vw.vw().vw(j, z, i);
        if (z) {
            com.ss.android.downloadlib.addownload.z.qm();
        }
    }

    public static boolean vw(com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo) {
        return downloadInfo == null || downloadInfo.getStatus() == 0 || downloadInfo.getStatus() == -4;
    }

    public void vw(com.ss.android.downloadlib.addownload.yl ylVar, int i, com.ss.android.download.api.download.DownloadModel downloadModel) {
        com.ss.android.downloadlib.wg.yl.vw().vw(new com.ss.android.downloadlib.addownload.t.AnonymousClass1(ylVar, i, downloadModel), wg());
    }

    public void vw(com.ss.android.downloadlib.addownload.yl ylVar, boolean z, int i, com.ss.android.download.api.download.DownloadModel downloadModel) {
        if (downloadModel instanceof com.ss.android.downloadad.api.download.AdDownloadModel) {
            ((com.ss.android.downloadad.api.download.AdDownloadModel) downloadModel).setFunnelType(3);
        }
        long id = downloadModel.getId();
        if (i == 4) {
            if (z) {
                vw(id, true, 2);
                return;
            } else {
                vw(id, false, 2);
                ylVar.wg(false);
                return;
            }
        }
        if (i == 5) {
            if (z) {
                vw(id, true, 1);
                return;
            } else {
                vw(id, false, 1);
                ylVar.t(false);
                return;
            }
        }
        if (i != 7) {
            return;
        }
        java.lang.Runnable remove = this.t.remove(java.lang.Long.valueOf(id));
        if (z) {
            com.ss.android.downloadlib.v.vw.vw().vw(id, 1);
            vw(id, true, 1);
        } else {
            if (remove != null) {
                com.ss.android.downloadlib.bt.vw().wg().post(remove);
            }
            vw(id, false, 1);
        }
    }

    public long wg() {
        return com.ss.android.downloadlib.addownload.z.x().optLong("quick_app_check_internal", 1200L);
    }
}
