package defpackage;

/* loaded from: classes22.dex */
public final /* synthetic */ class g50 implements com.google.android.exoplayer2.scheduler.RequirementsWatcher.Listener {
    public final /* synthetic */ com.google.android.exoplayer2.offline.DownloadManager a;

    public /* synthetic */ g50(com.google.android.exoplayer2.offline.DownloadManager downloadManager) {
        this.a = downloadManager;
    }

    @Override // com.google.android.exoplayer2.scheduler.RequirementsWatcher.Listener
    public final void onRequirementsStateChanged(com.google.android.exoplayer2.scheduler.RequirementsWatcher requirementsWatcher, int i) {
        this.a.i(requirementsWatcher, i);
    }
}
