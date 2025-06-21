package com.google.android.exoplayer2.mediacodec;

/* loaded from: classes22.dex */
public final /* synthetic */ class a implements java.lang.Runnable {
    public final /* synthetic */ com.google.android.exoplayer2.mediacodec.AsynchronousMediaCodecAdapter n;

    public /* synthetic */ a(com.google.android.exoplayer2.mediacodec.AsynchronousMediaCodecAdapter asynchronousMediaCodecAdapter) {
        this.n = asynchronousMediaCodecAdapter;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.n.f();
    }
}
