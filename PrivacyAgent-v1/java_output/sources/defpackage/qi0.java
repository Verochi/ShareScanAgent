package defpackage;

/* loaded from: classes22.dex */
public final /* synthetic */ class qi0 implements android.media.MediaDrm.OnEventListener {
    public final /* synthetic */ com.google.android.exoplayer2.drm.FrameworkMediaDrm a;
    public final /* synthetic */ com.google.android.exoplayer2.drm.ExoMediaDrm.OnEventListener b;

    public /* synthetic */ qi0(com.google.android.exoplayer2.drm.FrameworkMediaDrm frameworkMediaDrm, com.google.android.exoplayer2.drm.ExoMediaDrm.OnEventListener onEventListener) {
        this.a = frameworkMediaDrm;
        this.b = onEventListener;
    }

    @Override // android.media.MediaDrm.OnEventListener
    public final void onEvent(android.media.MediaDrm mediaDrm, byte[] bArr, int i, int i2, byte[] bArr2) {
        this.a.l(this.b, mediaDrm, bArr, i, i2, bArr2);
    }
}
