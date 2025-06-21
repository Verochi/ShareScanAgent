package defpackage;

/* loaded from: classes22.dex */
public final /* synthetic */ class d50 implements java.lang.Runnable {
    public final /* synthetic */ com.google.android.exoplayer2.offline.DownloadHelper n;
    public final /* synthetic */ java.io.IOException t;

    public /* synthetic */ d50(com.google.android.exoplayer2.offline.DownloadHelper downloadHelper, java.io.IOException iOException) {
        this.n = downloadHelper;
        this.t = iOException;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.n.o(this.t);
    }
}
