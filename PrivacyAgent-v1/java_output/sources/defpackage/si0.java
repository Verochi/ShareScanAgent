package defpackage;

/* loaded from: classes22.dex */
public final /* synthetic */ class si0 implements android.media.MediaDrm.OnKeyStatusChangeListener {
    public final /* synthetic */ com.google.android.exoplayer2.drm.FrameworkMediaDrm a;
    public final /* synthetic */ com.google.android.exoplayer2.drm.ExoMediaDrm.OnKeyStatusChangeListener b;

    public /* synthetic */ si0(com.google.android.exoplayer2.drm.FrameworkMediaDrm frameworkMediaDrm, com.google.android.exoplayer2.drm.ExoMediaDrm.OnKeyStatusChangeListener onKeyStatusChangeListener) {
        this.a = frameworkMediaDrm;
        this.b = onKeyStatusChangeListener;
    }

    @Override // android.media.MediaDrm.OnKeyStatusChangeListener
    public final void onKeyStatusChange(android.media.MediaDrm mediaDrm, byte[] bArr, java.util.List list, boolean z) {
        this.a.n(this.b, mediaDrm, bArr, list, z);
    }
}
