package com.ss.android.downloadlib.kz;

/* loaded from: classes19.dex */
public class vw implements com.ss.android.socialbase.appdownloader.t.es {

    /* renamed from: com.ss.android.downloadlib.kz.vw$1, reason: invalid class name */
    public class AnonymousClass1 implements com.ss.android.downloadlib.guide.install.vw {
        final /* synthetic */ com.ss.android.socialbase.appdownloader.t.x vw;

        public AnonymousClass1(com.ss.android.socialbase.appdownloader.t.x xVar) {
            this.vw = xVar;
        }

        @Override // com.ss.android.downloadlib.guide.install.vw
        public void vw() {
            this.vw.vw();
        }
    }

    /* renamed from: com.ss.android.downloadlib.kz.vw$2, reason: invalid class name */
    public class AnonymousClass2 implements com.ss.android.downloadlib.guide.install.vw {
        final /* synthetic */ com.ss.android.socialbase.downloader.model.DownloadInfo vw;
        final /* synthetic */ com.ss.android.downloadlib.guide.install.vw wg;

        public AnonymousClass2(com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo, com.ss.android.downloadlib.guide.install.vw vwVar) {
            this.vw = downloadInfo;
            this.wg = vwVar;
        }

        @Override // com.ss.android.downloadlib.guide.install.vw
        public void vw() {
            com.ss.android.downloadlib.kz.vw.this.wg(this.vw, this.wg);
        }
    }

    /* renamed from: com.ss.android.downloadlib.kz.vw$3, reason: invalid class name */
    public class AnonymousClass3 implements com.ss.android.downloadlib.guide.install.vw {
        final /* synthetic */ com.ss.android.downloadlib.guide.install.vw vw;

        public AnonymousClass3(com.ss.android.downloadlib.guide.install.vw vwVar) {
            this.vw = vwVar;
        }

        @Override // com.ss.android.downloadlib.guide.install.vw
        public void vw() {
            this.vw.vw();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wg(com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo, @androidx.annotation.NonNull com.ss.android.downloadlib.guide.install.vw vwVar) {
        com.ss.android.downloadad.api.vw.wg vw = com.ss.android.downloadlib.addownload.wg.kz.vw().vw(downloadInfo);
        boolean vw2 = com.ss.android.downloadlib.wg.kz.vw(vw);
        boolean wg = com.ss.android.downloadlib.wg.kz.wg(vw);
        if (vw2 && wg) {
            com.ss.android.downloadlib.wg.t.vw(vw, new com.ss.android.downloadlib.kz.vw.AnonymousClass3(vwVar));
        } else {
            vwVar.vw();
        }
    }

    public void vw(com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo, @androidx.annotation.NonNull com.ss.android.downloadlib.guide.install.vw vwVar) {
        com.ss.android.downloadad.api.vw.wg vw = com.ss.android.downloadlib.addownload.wg.kz.vw().vw(downloadInfo);
        if (vw == null || !com.ss.android.downloadlib.wg.x.vw(vw)) {
            wg(downloadInfo, vwVar);
        } else {
            com.ss.android.downloadlib.activity.TTDelegateActivity.vw(vw, new com.ss.android.downloadlib.kz.vw.AnonymousClass2(downloadInfo, vwVar));
        }
    }

    @Override // com.ss.android.socialbase.appdownloader.t.es
    public void vw(com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo, com.ss.android.socialbase.appdownloader.t.x xVar) {
        vw(downloadInfo, new com.ss.android.downloadlib.kz.vw.AnonymousClass1(xVar));
    }
}
