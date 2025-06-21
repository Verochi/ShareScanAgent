package com.google.android.exoplayer2.drm;

/* loaded from: classes22.dex */
public final /* synthetic */ class a implements com.google.android.exoplayer2.util.Consumer {
    public final /* synthetic */ java.lang.Exception a;

    public /* synthetic */ a(java.lang.Exception exc) {
        this.a = exc;
    }

    @Override // com.google.android.exoplayer2.util.Consumer
    public final void accept(java.lang.Object obj) {
        ((com.google.android.exoplayer2.drm.DrmSessionEventListener.EventDispatcher) obj).drmSessionManagerError(this.a);
    }
}
