package defpackage;

/* loaded from: classes22.dex */
public final /* synthetic */ class le implements java.lang.Runnable {
    public final /* synthetic */ com.google.android.exoplayer2.audio.AudioRendererEventListener.EventDispatcher n;
    public final /* synthetic */ com.google.android.exoplayer2.decoder.DecoderCounters t;

    public /* synthetic */ le(com.google.android.exoplayer2.audio.AudioRendererEventListener.EventDispatcher eventDispatcher, com.google.android.exoplayer2.decoder.DecoderCounters decoderCounters) {
        this.n = eventDispatcher;
        this.t = decoderCounters;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.n.l(this.t);
    }
}
