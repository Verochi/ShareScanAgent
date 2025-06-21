package defpackage;

/* loaded from: classes22.dex */
public final /* synthetic */ class uq2 implements java.lang.Runnable {
    public final /* synthetic */ com.google.android.exoplayer2.source.smoothstreaming.SsMediaSource n;

    public /* synthetic */ uq2(com.google.android.exoplayer2.source.smoothstreaming.SsMediaSource ssMediaSource) {
        this.n = ssMediaSource;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.n.d();
    }
}
