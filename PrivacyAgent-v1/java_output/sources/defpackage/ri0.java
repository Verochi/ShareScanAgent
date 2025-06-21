package defpackage;

/* loaded from: classes22.dex */
public final /* synthetic */ class ri0 implements com.google.android.exoplayer2.drm.ExoMediaDrm.Provider {
    @Override // com.google.android.exoplayer2.drm.ExoMediaDrm.Provider
    public final com.google.android.exoplayer2.drm.ExoMediaDrm acquireExoMediaDrm(java.util.UUID uuid) {
        com.google.android.exoplayer2.drm.ExoMediaDrm o;
        o = com.google.android.exoplayer2.drm.FrameworkMediaDrm.o(uuid);
        return o;
    }
}
