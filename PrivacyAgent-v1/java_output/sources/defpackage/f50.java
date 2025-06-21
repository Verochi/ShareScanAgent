package defpackage;

/* loaded from: classes22.dex */
public final /* synthetic */ class f50 implements android.os.Handler.Callback {
    public final /* synthetic */ com.google.android.exoplayer2.offline.DownloadManager n;

    public /* synthetic */ f50(com.google.android.exoplayer2.offline.DownloadManager downloadManager) {
        this.n = downloadManager;
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(android.os.Message message) {
        boolean c;
        c = this.n.c(message);
        return c;
    }
}
