package defpackage;

/* loaded from: classes22.dex */
public final /* synthetic */ class c50 implements java.lang.Runnable {
    public final /* synthetic */ com.google.android.exoplayer2.offline.DownloadHelper n;
    public final /* synthetic */ com.google.android.exoplayer2.offline.DownloadHelper.Callback t;

    public /* synthetic */ c50(com.google.android.exoplayer2.offline.DownloadHelper downloadHelper, com.google.android.exoplayer2.offline.DownloadHelper.Callback callback) {
        this.n = downloadHelper;
        this.t = callback;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.n.q(this.t);
    }
}
