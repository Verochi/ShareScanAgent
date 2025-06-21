package com.ss.android.downloadlib.kz;

/* loaded from: classes19.dex */
public class t implements com.ss.android.socialbase.appdownloader.t.es {
    private static volatile com.ss.android.downloadlib.kz.t vw;
    private java.util.List<com.ss.android.socialbase.appdownloader.t.es> wg;

    /* renamed from: com.ss.android.downloadlib.kz.t$1, reason: invalid class name */
    public class AnonymousClass1 implements com.ss.android.socialbase.appdownloader.t.x {
        final /* synthetic */ com.ss.android.socialbase.appdownloader.t.x t;
        final /* synthetic */ int vw;
        final /* synthetic */ com.ss.android.socialbase.downloader.model.DownloadInfo wg;

        public AnonymousClass1(int i, com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo, com.ss.android.socialbase.appdownloader.t.x xVar) {
            this.vw = i;
            this.wg = downloadInfo;
            this.t = xVar;
        }

        @Override // com.ss.android.socialbase.appdownloader.t.x
        public void vw() {
            com.ss.android.downloadlib.kz.t.this.vw(this.wg, this.vw + 1, this.t);
        }
    }

    private t() {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        this.wg = arrayList;
        arrayList.add(new com.ss.android.downloadlib.kz.wg());
        this.wg.add(new com.ss.android.downloadlib.kz.vw());
    }

    public static com.ss.android.downloadlib.kz.t vw() {
        if (vw == null) {
            synchronized (com.ss.android.downloadlib.kz.t.class) {
                if (vw == null) {
                    vw = new com.ss.android.downloadlib.kz.t();
                }
            }
        }
        return vw;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vw(com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo, int i, com.ss.android.socialbase.appdownloader.t.x xVar) {
        if (i == this.wg.size() || i < 0) {
            xVar.vw();
        } else {
            this.wg.get(i).vw(downloadInfo, new com.ss.android.downloadlib.kz.t.AnonymousClass1(i, downloadInfo, xVar));
        }
    }

    @Override // com.ss.android.socialbase.appdownloader.t.es
    public void vw(com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo, com.ss.android.socialbase.appdownloader.t.x xVar) {
        if (downloadInfo != null && this.wg.size() != 0) {
            vw(downloadInfo, 0, xVar);
        } else if (xVar != null) {
            xVar.vw();
        }
    }
}
