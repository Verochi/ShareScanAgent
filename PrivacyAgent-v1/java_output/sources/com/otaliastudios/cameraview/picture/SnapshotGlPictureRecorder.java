package com.otaliastudios.cameraview.picture;

/* loaded from: classes19.dex */
public class SnapshotGlPictureRecorder extends com.otaliastudios.cameraview.picture.SnapshotPictureRecorder {
    public com.otaliastudios.cameraview.preview.RendererCameraPreview u;
    public com.otaliastudios.cameraview.size.AspectRatio v;
    public com.otaliastudios.cameraview.overlay.Overlay w;
    public boolean x;
    public com.otaliastudios.cameraview.overlay.OverlayDrawer y;
    public com.otaliastudios.cameraview.internal.GlTextureDrawer z;

    /* renamed from: com.otaliastudios.cameraview.picture.SnapshotGlPictureRecorder$1, reason: invalid class name */
    public class AnonymousClass1 implements com.otaliastudios.cameraview.preview.RendererFrameCallback {
        public AnonymousClass1() {
        }

        @Override // com.otaliastudios.cameraview.preview.RendererFrameCallback
        @com.otaliastudios.cameraview.preview.RendererThread
        public void onRendererFilterChanged(@androidx.annotation.NonNull com.otaliastudios.cameraview.filter.Filter filter) {
            com.otaliastudios.cameraview.picture.SnapshotGlPictureRecorder.this.onRendererFilterChanged(filter);
        }

        @Override // com.otaliastudios.cameraview.preview.RendererFrameCallback
        @com.otaliastudios.cameraview.preview.RendererThread
        public void onRendererFrame(@androidx.annotation.NonNull android.graphics.SurfaceTexture surfaceTexture, int i, float f, float f2) {
            com.otaliastudios.cameraview.picture.SnapshotGlPictureRecorder.this.u.removeRendererFrameCallback(this);
            com.otaliastudios.cameraview.picture.SnapshotGlPictureRecorder.this.onRendererFrame(surfaceTexture, i, f, f2);
        }

        @Override // com.otaliastudios.cameraview.preview.RendererFrameCallback
        @com.otaliastudios.cameraview.preview.RendererThread
        public void onRendererTextureCreated(int i) {
            com.otaliastudios.cameraview.picture.SnapshotGlPictureRecorder.this.onRendererTextureCreated(i);
        }
    }

    /* renamed from: com.otaliastudios.cameraview.picture.SnapshotGlPictureRecorder$2, reason: invalid class name */
    public class AnonymousClass2 implements java.lang.Runnable {
        public final /* synthetic */ android.graphics.SurfaceTexture n;
        public final /* synthetic */ int t;
        public final /* synthetic */ float u;
        public final /* synthetic */ float v;
        public final /* synthetic */ android.opengl.EGLContext w;

        public AnonymousClass2(android.graphics.SurfaceTexture surfaceTexture, int i, float f, float f2, android.opengl.EGLContext eGLContext) {
            this.n = surfaceTexture;
            this.t = i;
            this.u = f;
            this.v = f2;
            this.w = eGLContext;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.otaliastudios.cameraview.picture.SnapshotGlPictureRecorder.this.takeFrame(this.n, this.t, this.u, this.v, this.w);
        }
    }

    public SnapshotGlPictureRecorder(@androidx.annotation.NonNull com.otaliastudios.cameraview.PictureResult.Stub stub, @androidx.annotation.Nullable com.otaliastudios.cameraview.picture.PictureRecorder.PictureResultListener pictureResultListener, @androidx.annotation.NonNull com.otaliastudios.cameraview.preview.RendererCameraPreview rendererCameraPreview, @androidx.annotation.NonNull com.otaliastudios.cameraview.size.AspectRatio aspectRatio, @androidx.annotation.Nullable com.otaliastudios.cameraview.overlay.Overlay overlay) {
        super(stub, pictureResultListener);
        this.u = rendererCameraPreview;
        this.v = aspectRatio;
        this.w = overlay;
        this.x = overlay != null && overlay.drawsOn(com.otaliastudios.cameraview.overlay.Overlay.Target.PICTURE_SNAPSHOT);
    }

    @Override // com.otaliastudios.cameraview.picture.PictureRecorder
    public void dispatchResult() {
        this.v = null;
        super.dispatchResult();
    }

    @android.annotation.TargetApi(19)
    @com.otaliastudios.cameraview.preview.RendererThread
    public void onRendererFilterChanged(@androidx.annotation.NonNull com.otaliastudios.cameraview.filter.Filter filter) {
        this.z.setFilter(filter.copy());
    }

    @android.annotation.TargetApi(19)
    @com.otaliastudios.cameraview.preview.RendererThread
    public void onRendererFrame(@androidx.annotation.NonNull android.graphics.SurfaceTexture surfaceTexture, int i, float f, float f2) {
        com.otaliastudios.cameraview.internal.WorkerHandler.execute(new com.otaliastudios.cameraview.picture.SnapshotGlPictureRecorder.AnonymousClass2(surfaceTexture, i, f, f2, android.opengl.EGL14.eglGetCurrentContext()));
    }

    @android.annotation.TargetApi(19)
    @com.otaliastudios.cameraview.preview.RendererThread
    public void onRendererTextureCreated(int i) {
        this.z = new com.otaliastudios.cameraview.internal.GlTextureDrawer(i);
        android.graphics.Rect computeCrop = com.otaliastudios.cameraview.internal.CropHelper.computeCrop(this.n.size, this.v);
        this.n.size = new com.otaliastudios.cameraview.size.Size(computeCrop.width(), computeCrop.height());
        if (this.x) {
            this.y = new com.otaliastudios.cameraview.overlay.OverlayDrawer(this.w, this.n.size);
        }
    }

    @Override // com.otaliastudios.cameraview.picture.PictureRecorder
    @android.annotation.TargetApi(19)
    public void take() {
        this.u.addRendererFrameCallback(new com.otaliastudios.cameraview.picture.SnapshotGlPictureRecorder.AnonymousClass1());
    }

    @android.annotation.TargetApi(19)
    @androidx.annotation.WorkerThread
    public void takeFrame(@androidx.annotation.NonNull android.graphics.SurfaceTexture surfaceTexture, int i, float f, float f2, @androidx.annotation.NonNull android.opengl.EGLContext eGLContext) {
        android.graphics.SurfaceTexture surfaceTexture2 = new android.graphics.SurfaceTexture(9999);
        surfaceTexture2.setDefaultBufferSize(this.n.size.getWidth(), this.n.size.getHeight());
        com.otaliastudios.opengl.core.EglCore eglCore = new com.otaliastudios.opengl.core.EglCore(eGLContext, 1);
        com.otaliastudios.opengl.surface.EglWindowSurface eglWindowSurface = new com.otaliastudios.opengl.surface.EglWindowSurface(eglCore, surfaceTexture2);
        eglWindowSurface.makeCurrent();
        float[] textureTransform = this.z.getTextureTransform();
        surfaceTexture.getTransformMatrix(textureTransform);
        android.opengl.Matrix.translateM(textureTransform, 0, (1.0f - f) / 2.0f, (1.0f - f2) / 2.0f, 0.0f);
        android.opengl.Matrix.scaleM(textureTransform, 0, f, f2, 1.0f);
        android.opengl.Matrix.translateM(textureTransform, 0, 0.5f, 0.5f, 0.0f);
        android.opengl.Matrix.rotateM(textureTransform, 0, i + this.n.rotation, 0.0f, 0.0f, 1.0f);
        android.opengl.Matrix.scaleM(textureTransform, 0, 1.0f, -1.0f, 1.0f);
        android.opengl.Matrix.translateM(textureTransform, 0, -0.5f, -0.5f, 0.0f);
        if (this.x) {
            this.y.draw(com.otaliastudios.cameraview.overlay.Overlay.Target.PICTURE_SNAPSHOT);
            android.opengl.Matrix.translateM(this.y.getTransform(), 0, 0.5f, 0.5f, 0.0f);
            android.opengl.Matrix.rotateM(this.y.getTransform(), 0, this.n.rotation, 0.0f, 0.0f, 1.0f);
            android.opengl.Matrix.scaleM(this.y.getTransform(), 0, 1.0f, -1.0f, 1.0f);
            android.opengl.Matrix.translateM(this.y.getTransform(), 0, -0.5f, -0.5f, 0.0f);
        }
        this.n.rotation = 0;
        long timestamp = surfaceTexture.getTimestamp() / 1000;
        com.otaliastudios.cameraview.picture.SnapshotPictureRecorder.LOG.i("takeFrame:", "timestampUs:", java.lang.Long.valueOf(timestamp));
        this.z.draw(timestamp);
        if (this.x) {
            this.y.render(timestamp);
        }
        this.n.data = eglWindowSurface.toByteArray(android.graphics.Bitmap.CompressFormat.JPEG);
        eglWindowSurface.release();
        this.z.release();
        surfaceTexture2.release();
        if (this.x) {
            this.y.release();
        }
        eglCore.release$egloo_metadata_release();
        dispatchResult();
    }
}
