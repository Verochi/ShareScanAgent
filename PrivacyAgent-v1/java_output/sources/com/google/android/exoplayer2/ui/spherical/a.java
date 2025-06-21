package com.google.android.exoplayer2.ui.spherical;

/* loaded from: classes22.dex */
public final /* synthetic */ class a implements android.graphics.SurfaceTexture.OnFrameAvailableListener {
    public final /* synthetic */ com.google.android.exoplayer2.ui.spherical.SceneRenderer n;

    public /* synthetic */ a(com.google.android.exoplayer2.ui.spherical.SceneRenderer sceneRenderer) {
        this.n = sceneRenderer;
    }

    @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
    public final void onFrameAvailable(android.graphics.SurfaceTexture surfaceTexture) {
        this.n.d(surfaceTexture);
    }
}
