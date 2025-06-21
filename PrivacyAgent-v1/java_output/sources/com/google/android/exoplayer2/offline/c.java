package com.google.android.exoplayer2.offline;

/* loaded from: classes22.dex */
public final /* synthetic */ class c implements java.lang.Runnable {
    public final /* synthetic */ com.google.android.exoplayer2.offline.DownloadService.DownloadManagerHelper n;
    public final /* synthetic */ com.google.android.exoplayer2.offline.DownloadService t;

    public /* synthetic */ c(com.google.android.exoplayer2.offline.DownloadService.DownloadManagerHelper downloadManagerHelper, com.google.android.exoplayer2.offline.DownloadService downloadService) {
        this.n = downloadManagerHelper;
        this.t = downloadService;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.n.e(this.t);
    }
}
