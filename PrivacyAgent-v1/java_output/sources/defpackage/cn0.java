package defpackage;

/* loaded from: classes22.dex */
public final /* synthetic */ class cn0 implements java.lang.Runnable {
    public final /* synthetic */ com.google.android.exoplayer2.source.hls.HlsSampleStreamWrapper.Callback n;

    public /* synthetic */ cn0(com.google.android.exoplayer2.source.hls.HlsSampleStreamWrapper.Callback callback) {
        this.n = callback;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.n.onPrepared();
    }
}
