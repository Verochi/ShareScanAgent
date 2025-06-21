package defpackage;

/* loaded from: classes22.dex */
public final /* synthetic */ class lz implements com.google.android.exoplayer2.util.Consumer {
    @Override // com.google.android.exoplayer2.util.Consumer
    public final void accept(java.lang.Object obj) {
        ((com.google.android.exoplayer2.drm.DrmSessionEventListener.EventDispatcher) obj).drmKeysRemoved();
    }
}
