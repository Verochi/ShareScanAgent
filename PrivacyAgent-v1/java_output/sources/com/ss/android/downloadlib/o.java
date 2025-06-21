package com.ss.android.downloadlib;

/* loaded from: classes19.dex */
public class o {
    private static volatile com.ss.android.downloadlib.o vw;
    private long kz;
    private final com.ss.android.downloadlib.bt t;
    private final com.ss.android.downloadad.api.vw v;
    private final com.ss.android.download.api.vw wg;
    private com.ss.android.downloadad.api.wg yl;

    /* renamed from: com.ss.android.downloadlib.o$1, reason: invalid class name */
    public static class AnonymousClass1 implements java.lang.Runnable {
        final /* synthetic */ android.content.Context vw;

        public AnonymousClass1(android.content.Context context) {
            this.vw = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.ss.android.downloadlib.o unused = com.ss.android.downloadlib.o.vw = new com.ss.android.downloadlib.o(this.vw, null);
        }
    }

    /* renamed from: com.ss.android.downloadlib.o$2, reason: invalid class name */
    public class AnonymousClass2 implements java.lang.Runnable {
        final /* synthetic */ java.lang.String vw;
        final /* synthetic */ int wg;

        public AnonymousClass2(java.lang.String str, int i) {
            this.vw = str;
            this.wg = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.ss.android.downloadlib.o.this.o().vw(this.vw, this.wg);
        }
    }

    /* renamed from: com.ss.android.downloadlib.o$3, reason: invalid class name */
    public class AnonymousClass3 implements java.lang.Runnable {
        final /* synthetic */ java.lang.String vw;
        final /* synthetic */ boolean wg;

        public AnonymousClass3(java.lang.String str, boolean z) {
            this.vw = str;
            this.wg = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.ss.android.downloadlib.o.this.o().vw(this.vw, this.wg);
        }
    }

    /* renamed from: com.ss.android.downloadlib.o$4, reason: invalid class name */
    public class AnonymousClass4 implements java.lang.Runnable {
        final /* synthetic */ com.ss.android.download.api.download.DownloadStatusChangeListener t;
        final /* synthetic */ com.ss.android.download.api.download.DownloadModel v;
        final /* synthetic */ android.content.Context vw;
        final /* synthetic */ int wg;

        public AnonymousClass4(android.content.Context context, int i, com.ss.android.download.api.download.DownloadStatusChangeListener downloadStatusChangeListener, com.ss.android.download.api.download.DownloadModel downloadModel) {
            this.vw = context;
            this.wg = i;
            this.t = downloadStatusChangeListener;
            this.v = downloadModel;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.ss.android.downloadlib.o.this.o().vw(this.vw, this.wg, this.t, this.v);
        }
    }

    /* renamed from: com.ss.android.downloadlib.o$5, reason: invalid class name */
    public class AnonymousClass5 implements java.lang.Runnable {
        final /* synthetic */ com.ss.android.download.api.config.IDownloadButtonClickListener bt;
        final /* synthetic */ com.ss.android.download.api.config.OnItemClickListener kz;
        final /* synthetic */ int t;
        final /* synthetic */ com.ss.android.download.api.download.DownloadEventConfig v;
        final /* synthetic */ java.lang.String vw;
        final /* synthetic */ long wg;
        final /* synthetic */ com.ss.android.download.api.download.DownloadController yl;

        public AnonymousClass5(java.lang.String str, long j, int i, com.ss.android.download.api.download.DownloadEventConfig downloadEventConfig, com.ss.android.download.api.download.DownloadController downloadController, com.ss.android.download.api.config.OnItemClickListener onItemClickListener, com.ss.android.download.api.config.IDownloadButtonClickListener iDownloadButtonClickListener) {
            this.vw = str;
            this.wg = j;
            this.t = i;
            this.v = downloadEventConfig;
            this.yl = downloadController;
            this.kz = onItemClickListener;
            this.bt = iDownloadButtonClickListener;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.ss.android.downloadlib.o.this.o().vw(this.vw, this.wg, this.t, this.v, this.yl, this.kz, this.bt);
        }
    }

    /* renamed from: com.ss.android.downloadlib.o$6, reason: invalid class name */
    public class AnonymousClass6 implements java.lang.Runnable {
        final /* synthetic */ int t;
        final /* synthetic */ com.ss.android.download.api.download.DownloadEventConfig v;
        final /* synthetic */ java.lang.String vw;
        final /* synthetic */ long wg;
        final /* synthetic */ com.ss.android.download.api.download.DownloadController yl;

        public AnonymousClass6(java.lang.String str, long j, int i, com.ss.android.download.api.download.DownloadEventConfig downloadEventConfig, com.ss.android.download.api.download.DownloadController downloadController) {
            this.vw = str;
            this.wg = j;
            this.t = i;
            this.v = downloadEventConfig;
            this.yl = downloadController;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.ss.android.downloadlib.o.this.o().vw(this.vw, this.wg, this.t, this.v, this.yl);
        }
    }

    /* renamed from: com.ss.android.downloadlib.o$7, reason: invalid class name */
    public class AnonymousClass7 implements java.lang.Runnable {
        final /* synthetic */ com.ss.android.download.api.config.IDownloadButtonClickListener kz;
        final /* synthetic */ int t;
        final /* synthetic */ com.ss.android.download.api.download.DownloadEventConfig v;
        final /* synthetic */ java.lang.String vw;
        final /* synthetic */ long wg;
        final /* synthetic */ com.ss.android.download.api.download.DownloadController yl;

        public AnonymousClass7(java.lang.String str, long j, int i, com.ss.android.download.api.download.DownloadEventConfig downloadEventConfig, com.ss.android.download.api.download.DownloadController downloadController, com.ss.android.download.api.config.IDownloadButtonClickListener iDownloadButtonClickListener) {
            this.vw = str;
            this.wg = j;
            this.t = i;
            this.v = downloadEventConfig;
            this.yl = downloadController;
            this.kz = iDownloadButtonClickListener;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.ss.android.downloadlib.o.this.o().vw(this.vw, this.wg, this.t, this.v, this.yl, this.kz);
        }
    }

    private o(android.content.Context context) {
        this.t = com.ss.android.downloadlib.bt.vw();
        this.wg = new com.ss.android.downloadlib.yl();
        this.kz = java.lang.System.currentTimeMillis();
        wg(context);
        this.v = com.ss.android.downloadlib.vw.vw();
    }

    public /* synthetic */ o(android.content.Context context, com.ss.android.downloadlib.o.AnonymousClass1 anonymousClass1) {
        this(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.ss.android.downloadlib.bt o() {
        return this.t;
    }

    public static com.ss.android.downloadlib.o vw(android.content.Context context) {
        if (vw == null) {
            synchronized (com.ss.android.downloadlib.o.class) {
                if (vw == null) {
                    com.ss.android.downloadlib.yl.wg.vw(new com.ss.android.downloadlib.o.AnonymousClass1(context));
                }
            }
        }
        return vw;
    }

    private void wg(android.content.Context context) {
        com.ss.android.downloadlib.addownload.z.vw(context);
        com.ss.android.socialbase.downloader.downloader.Downloader.getInstance(com.ss.android.downloadlib.addownload.z.getContext());
        com.ss.android.downloadlib.addownload.wg.kz.vw().wg();
        com.ss.android.socialbase.appdownloader.v.es().vw(com.ss.android.downloadlib.addownload.z.getContext(), "misc_config", new com.ss.android.downloadlib.t.bt(), new com.ss.android.downloadlib.t.kz(context), new com.ss.android.downloadlib.t());
        com.ss.android.downloadlib.t.v vVar = new com.ss.android.downloadlib.t.v();
        com.ss.android.socialbase.appdownloader.v.es().vw(vVar);
        com.ss.android.socialbase.downloader.downloader.Downloader.getInstance(context).registerDownloadCacheSyncListener(vVar);
        com.ss.android.socialbase.appdownloader.v.es().vw(new com.ss.android.downloadlib.addownload.vl());
        com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.setDownloadEventListener(new com.ss.android.downloadlib.t.yl());
        com.ss.android.socialbase.appdownloader.v.es().vw(com.ss.android.downloadlib.kz.t.vw());
    }

    public void bt() {
        com.ss.android.downloadlib.v.vw().yl();
    }

    public java.lang.String kz() {
        return com.ss.android.downloadlib.addownload.z.cp();
    }

    public void t() {
        this.kz = java.lang.System.currentTimeMillis();
    }

    public com.ss.android.downloadad.api.vw v() {
        return this.v;
    }

    public com.ss.android.download.api.vw vw() {
        return this.wg;
    }

    public com.ss.android.download.api.vw vw(java.lang.String str) {
        com.ss.android.download.api.config.kz wg = com.ss.android.downloadlib.kz.vw().wg();
        return (wg == null || !wg.vw(str)) ? this.wg : wg.wg(str);
    }

    public com.ss.android.socialbase.downloader.model.DownloadInfo vw(java.lang.String str, java.lang.String str2, boolean z) {
        return (android.text.TextUtils.isEmpty(str2) && z) ? wg(str) : com.ss.android.socialbase.downloader.downloader.Downloader.getInstance(com.ss.android.downloadlib.addownload.z.getContext()).getDownloadInfo(str, str2);
    }

    @androidx.annotation.MainThread
    public void vw(android.content.Context context, int i, com.ss.android.download.api.download.DownloadStatusChangeListener downloadStatusChangeListener, com.ss.android.download.api.download.DownloadModel downloadModel) {
        com.ss.android.downloadlib.yl.wg.vw(new com.ss.android.downloadlib.o.AnonymousClass4(context, i, downloadStatusChangeListener, downloadModel));
    }

    public void vw(com.ss.android.download.api.download.vw.vw vwVar) {
        o().vw(vwVar);
    }

    @androidx.annotation.MainThread
    public void vw(java.lang.String str, int i) {
        com.ss.android.downloadlib.yl.wg.vw(new com.ss.android.downloadlib.o.AnonymousClass2(str, i));
    }

    @androidx.annotation.MainThread
    public void vw(java.lang.String str, long j, int i, com.ss.android.download.api.download.DownloadEventConfig downloadEventConfig, com.ss.android.download.api.download.DownloadController downloadController) {
        com.ss.android.downloadlib.yl.wg.vw(new com.ss.android.downloadlib.o.AnonymousClass6(str, j, i, downloadEventConfig, downloadController));
    }

    @androidx.annotation.MainThread
    public void vw(java.lang.String str, long j, int i, com.ss.android.download.api.download.DownloadEventConfig downloadEventConfig, com.ss.android.download.api.download.DownloadController downloadController, com.ss.android.download.api.config.IDownloadButtonClickListener iDownloadButtonClickListener) {
        com.ss.android.downloadlib.yl.wg.vw(new com.ss.android.downloadlib.o.AnonymousClass7(str, j, i, downloadEventConfig, downloadController, iDownloadButtonClickListener));
    }

    @androidx.annotation.MainThread
    public void vw(java.lang.String str, long j, int i, com.ss.android.download.api.download.DownloadEventConfig downloadEventConfig, com.ss.android.download.api.download.DownloadController downloadController, com.ss.android.download.api.config.OnItemClickListener onItemClickListener, com.ss.android.download.api.config.IDownloadButtonClickListener iDownloadButtonClickListener) {
        com.ss.android.downloadlib.yl.wg.vw(new com.ss.android.downloadlib.o.AnonymousClass5(str, j, i, downloadEventConfig, downloadController, onItemClickListener, iDownloadButtonClickListener));
    }

    @androidx.annotation.MainThread
    public void vw(java.lang.String str, boolean z) {
        com.ss.android.downloadlib.yl.wg.vw(new com.ss.android.downloadlib.o.AnonymousClass3(str, z));
    }

    public long wg() {
        return this.kz;
    }

    public com.ss.android.socialbase.downloader.model.DownloadInfo wg(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return null;
        }
        return com.ss.android.socialbase.appdownloader.v.es().vw(com.ss.android.downloadlib.addownload.z.getContext(), str);
    }

    public com.ss.android.downloadad.api.wg yl() {
        if (this.yl == null) {
            this.yl = com.ss.android.downloadlib.wg.vw();
        }
        return this.yl;
    }
}
