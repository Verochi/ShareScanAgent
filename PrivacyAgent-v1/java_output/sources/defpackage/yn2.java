package defpackage;

/* loaded from: classes22.dex */
public final /* synthetic */ class yn2 implements java.lang.Runnable {
    public final /* synthetic */ com.google.android.exoplayer2.ui.spherical.SphericalGLSurfaceView n;
    public final /* synthetic */ android.graphics.SurfaceTexture t;

    public /* synthetic */ yn2(com.google.android.exoplayer2.ui.spherical.SphericalGLSurfaceView sphericalGLSurfaceView, android.graphics.SurfaceTexture surfaceTexture) {
        this.n = sphericalGLSurfaceView;
        this.t = surfaceTexture;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.n.e(this.t);
    }
}
