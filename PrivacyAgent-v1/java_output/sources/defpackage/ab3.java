package defpackage;

/* loaded from: classes30.dex */
public final /* synthetic */ class ab3 implements java.lang.Runnable {
    public final /* synthetic */ com.google.android.exoplayer2.video.VideoRendererEventListener.EventDispatcher n;
    public final /* synthetic */ com.google.android.exoplayer2.decoder.DecoderCounters t;

    public /* synthetic */ ab3(com.google.android.exoplayer2.video.VideoRendererEventListener.EventDispatcher eventDispatcher, com.google.android.exoplayer2.decoder.DecoderCounters decoderCounters) {
        this.n = eventDispatcher;
        this.t = decoderCounters;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.n.j(this.t);
    }
}
