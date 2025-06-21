package com.google.android.exoplayer2;

/* loaded from: classes22.dex */
public final /* synthetic */ class a implements java.lang.Runnable {
    public final /* synthetic */ com.google.android.exoplayer2.AudioFocusManager.AudioFocusListener n;
    public final /* synthetic */ int t;

    public /* synthetic */ a(com.google.android.exoplayer2.AudioFocusManager.AudioFocusListener audioFocusListener, int i) {
        this.n = audioFocusListener;
        this.t = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.n.b(this.t);
    }
}
