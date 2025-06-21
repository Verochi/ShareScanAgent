package defpackage;

/* loaded from: classes22.dex */
public final /* synthetic */ class y7 implements java.lang.Runnable {
    public final /* synthetic */ com.google.android.exoplayer2.source.ads.AdsLoader n;

    public /* synthetic */ y7(com.google.android.exoplayer2.source.ads.AdsLoader adsLoader) {
        this.n = adsLoader;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.n.stop();
    }
}
