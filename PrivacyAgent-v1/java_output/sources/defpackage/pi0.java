package defpackage;

/* loaded from: classes22.dex */
public final /* synthetic */ class pi0 implements android.media.MediaDrm.OnExpirationUpdateListener {
    public final /* synthetic */ com.google.android.exoplayer2.drm.FrameworkMediaDrm a;
    public final /* synthetic */ com.google.android.exoplayer2.drm.ExoMediaDrm.OnExpirationUpdateListener b;

    public /* synthetic */ pi0(com.google.android.exoplayer2.drm.FrameworkMediaDrm frameworkMediaDrm, com.google.android.exoplayer2.drm.ExoMediaDrm.OnExpirationUpdateListener onExpirationUpdateListener) {
        this.a = frameworkMediaDrm;
        this.b = onExpirationUpdateListener;
    }

    @Override // android.media.MediaDrm.OnExpirationUpdateListener
    public final void onExpirationUpdate(android.media.MediaDrm mediaDrm, byte[] bArr, long j) {
        this.a.m(this.b, mediaDrm, bArr, j);
    }
}
