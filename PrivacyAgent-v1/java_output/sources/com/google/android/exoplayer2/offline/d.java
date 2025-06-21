package com.google.android.exoplayer2.offline;

/* loaded from: classes22.dex */
public final /* synthetic */ class d implements java.lang.Runnable {
    public final /* synthetic */ com.google.android.exoplayer2.offline.DownloadService.ForegroundNotificationUpdater n;

    public /* synthetic */ d(com.google.android.exoplayer2.offline.DownloadService.ForegroundNotificationUpdater foregroundNotificationUpdater) {
        this.n = foregroundNotificationUpdater;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.n.update();
    }
}
