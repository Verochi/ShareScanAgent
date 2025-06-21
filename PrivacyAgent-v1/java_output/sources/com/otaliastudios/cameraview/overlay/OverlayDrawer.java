package com.otaliastudios.cameraview.overlay;

/* loaded from: classes19.dex */
public class OverlayDrawer {
    public static final com.otaliastudios.cameraview.CameraLogger g = com.otaliastudios.cameraview.CameraLogger.create(com.otaliastudios.cameraview.overlay.OverlayDrawer.class.getSimpleName());
    public com.otaliastudios.cameraview.overlay.Overlay a;
    public android.graphics.SurfaceTexture b;
    public android.view.Surface c;
    public com.otaliastudios.cameraview.internal.Issue514Workaround e;
    public final java.lang.Object f = new java.lang.Object();

    @androidx.annotation.VisibleForTesting
    public com.otaliastudios.cameraview.internal.GlTextureDrawer d = new com.otaliastudios.cameraview.internal.GlTextureDrawer();

    public OverlayDrawer(@androidx.annotation.NonNull com.otaliastudios.cameraview.overlay.Overlay overlay, @androidx.annotation.NonNull com.otaliastudios.cameraview.size.Size size) {
        this.a = overlay;
        android.graphics.SurfaceTexture surfaceTexture = new android.graphics.SurfaceTexture(this.d.getTexture().getId());
        this.b = surfaceTexture;
        surfaceTexture.setDefaultBufferSize(size.getWidth(), size.getHeight());
        this.c = new android.view.Surface(this.b);
        this.e = new com.otaliastudios.cameraview.internal.Issue514Workaround(this.d.getTexture().getId());
    }

    public void draw(@androidx.annotation.NonNull com.otaliastudios.cameraview.overlay.Overlay.Target target) {
        try {
            android.graphics.Canvas lockCanvas = this.c.lockCanvas(null);
            lockCanvas.drawColor(0, android.graphics.PorterDuff.Mode.CLEAR);
            this.a.drawOn(target, lockCanvas);
            this.c.unlockCanvasAndPost(lockCanvas);
        } catch (android.view.Surface.OutOfResourcesException e) {
            g.w("Got Surface.OutOfResourcesException while drawing video overlays", e);
        }
        synchronized (this.f) {
            this.e.beforeOverlayUpdateTexImage();
            this.b.updateTexImage();
        }
        this.b.getTransformMatrix(this.d.getTextureTransform());
    }

    public float[] getTransform() {
        return this.d.getTextureTransform();
    }

    public void release() {
        com.otaliastudios.cameraview.internal.Issue514Workaround issue514Workaround = this.e;
        if (issue514Workaround != null) {
            issue514Workaround.end();
            this.e = null;
        }
        android.graphics.SurfaceTexture surfaceTexture = this.b;
        if (surfaceTexture != null) {
            surfaceTexture.release();
            this.b = null;
        }
        android.view.Surface surface = this.c;
        if (surface != null) {
            surface.release();
            this.c = null;
        }
        com.otaliastudios.cameraview.internal.GlTextureDrawer glTextureDrawer = this.d;
        if (glTextureDrawer != null) {
            glTextureDrawer.release();
            this.d = null;
        }
    }

    public void render(long j) {
        android.opengl.GLES20.glDisable(com.badlogic.gdx.graphics.GL20.GL_CULL_FACE);
        android.opengl.GLES20.glDisable(com.badlogic.gdx.graphics.GL20.GL_DEPTH_TEST);
        android.opengl.GLES20.glEnable(com.badlogic.gdx.graphics.GL20.GL_BLEND);
        android.opengl.GLES20.glBlendFunc(com.badlogic.gdx.graphics.GL20.GL_SRC_ALPHA, com.badlogic.gdx.graphics.GL20.GL_ONE_MINUS_SRC_ALPHA);
        synchronized (this.f) {
            this.d.draw(j);
        }
    }
}
