package defpackage;

/* loaded from: classes30.dex */
public final /* synthetic */ class as implements android.os.Handler.Callback {
    public final /* synthetic */ com.google.android.exoplayer2.source.ConcatenatingMediaSource n;

    public /* synthetic */ as(com.google.android.exoplayer2.source.ConcatenatingMediaSource concatenatingMediaSource) {
        this.n = concatenatingMediaSource;
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(android.os.Message message) {
        boolean q;
        q = this.n.q(message);
        return q;
    }
}
