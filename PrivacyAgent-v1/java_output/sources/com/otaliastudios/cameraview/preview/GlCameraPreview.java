package com.otaliastudios.cameraview.preview;

/* loaded from: classes19.dex */
public class GlCameraPreview extends com.otaliastudios.cameraview.preview.CameraPreview<android.opengl.GLSurfaceView, android.graphics.SurfaceTexture> implements com.otaliastudios.cameraview.preview.FilterCameraPreview, com.otaliastudios.cameraview.preview.RendererCameraPreview {
    public boolean d;
    public android.graphics.SurfaceTexture e;
    public com.otaliastudios.cameraview.internal.GlTextureDrawer f;
    public final java.util.Set<com.otaliastudios.cameraview.preview.RendererFrameCallback> g;

    @androidx.annotation.VisibleForTesting
    public float h;

    @androidx.annotation.VisibleForTesting
    public float i;
    public android.view.View j;
    public com.otaliastudios.cameraview.filter.Filter k;

    /* renamed from: com.otaliastudios.cameraview.preview.GlCameraPreview$1, reason: invalid class name */
    public class AnonymousClass1 implements android.view.SurfaceHolder.Callback {
        public final /* synthetic */ android.opengl.GLSurfaceView n;
        public final /* synthetic */ com.otaliastudios.cameraview.preview.GlCameraPreview.Renderer t;

        /* renamed from: com.otaliastudios.cameraview.preview.GlCameraPreview$1$1, reason: invalid class name and collision with other inner class name */
        public class RunnableC04311 implements java.lang.Runnable {
            public RunnableC04311() {
            }

            @Override // java.lang.Runnable
            public void run() {
                com.otaliastudios.cameraview.preview.GlCameraPreview.AnonymousClass1.this.t.onSurfaceDestroyed();
            }
        }

        public AnonymousClass1(android.opengl.GLSurfaceView gLSurfaceView, com.otaliastudios.cameraview.preview.GlCameraPreview.Renderer renderer) {
            this.n = gLSurfaceView;
            this.t = renderer;
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceChanged(android.view.SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceCreated(android.view.SurfaceHolder surfaceHolder) {
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceDestroyed(android.view.SurfaceHolder surfaceHolder) {
            com.otaliastudios.cameraview.preview.GlCameraPreview.this.dispatchOnSurfaceDestroyed();
            this.n.queueEvent(new com.otaliastudios.cameraview.preview.GlCameraPreview.AnonymousClass1.RunnableC04311());
            com.otaliastudios.cameraview.preview.GlCameraPreview.this.d = false;
        }
    }

    /* renamed from: com.otaliastudios.cameraview.preview.GlCameraPreview$2, reason: invalid class name */
    public class AnonymousClass2 implements java.lang.Runnable {
        public final /* synthetic */ com.otaliastudios.cameraview.preview.RendererFrameCallback n;

        public AnonymousClass2(com.otaliastudios.cameraview.preview.RendererFrameCallback rendererFrameCallback) {
            this.n = rendererFrameCallback;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.otaliastudios.cameraview.preview.GlCameraPreview.this.g.add(this.n);
            if (com.otaliastudios.cameraview.preview.GlCameraPreview.this.f != null) {
                this.n.onRendererTextureCreated(com.otaliastudios.cameraview.preview.GlCameraPreview.this.f.getTexture().getId());
            }
            this.n.onRendererFilterChanged(com.otaliastudios.cameraview.preview.GlCameraPreview.this.k);
        }
    }

    /* renamed from: com.otaliastudios.cameraview.preview.GlCameraPreview$3, reason: invalid class name */
    public class AnonymousClass3 implements java.lang.Runnable {
        public final /* synthetic */ com.otaliastudios.cameraview.filter.Filter n;

        public AnonymousClass3(com.otaliastudios.cameraview.filter.Filter filter) {
            this.n = filter;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (com.otaliastudios.cameraview.preview.GlCameraPreview.this.f != null) {
                com.otaliastudios.cameraview.preview.GlCameraPreview.this.f.setFilter(this.n);
            }
            java.util.Iterator it = com.otaliastudios.cameraview.preview.GlCameraPreview.this.g.iterator();
            while (it.hasNext()) {
                ((com.otaliastudios.cameraview.preview.RendererFrameCallback) it.next()).onRendererFilterChanged(this.n);
            }
        }
    }

    public class Renderer implements android.opengl.GLSurfaceView.Renderer {

        /* renamed from: com.otaliastudios.cameraview.preview.GlCameraPreview$Renderer$1, reason: invalid class name */
        public class AnonymousClass1 implements java.lang.Runnable {
            public final /* synthetic */ int n;

            public AnonymousClass1(int i) {
                this.n = i;
            }

            @Override // java.lang.Runnable
            public void run() {
                java.util.Iterator it = com.otaliastudios.cameraview.preview.GlCameraPreview.this.g.iterator();
                while (it.hasNext()) {
                    ((com.otaliastudios.cameraview.preview.RendererFrameCallback) it.next()).onRendererTextureCreated(this.n);
                }
            }
        }

        /* renamed from: com.otaliastudios.cameraview.preview.GlCameraPreview$Renderer$2, reason: invalid class name */
        public class AnonymousClass2 implements android.graphics.SurfaceTexture.OnFrameAvailableListener {
            public AnonymousClass2() {
            }

            @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
            public void onFrameAvailable(android.graphics.SurfaceTexture surfaceTexture) {
                com.otaliastudios.cameraview.preview.GlCameraPreview.this.getView().requestRender();
            }
        }

        public Renderer() {
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        @com.otaliastudios.cameraview.preview.RendererThread
        public void onDrawFrame(javax.microedition.khronos.opengles.GL10 gl10) {
            if (com.otaliastudios.cameraview.preview.GlCameraPreview.this.e == null) {
                return;
            }
            com.otaliastudios.cameraview.preview.GlCameraPreview glCameraPreview = com.otaliastudios.cameraview.preview.GlCameraPreview.this;
            if (glCameraPreview.mInputStreamWidth <= 0 || glCameraPreview.mInputStreamHeight <= 0) {
                return;
            }
            float[] textureTransform = glCameraPreview.f.getTextureTransform();
            com.otaliastudios.cameraview.preview.GlCameraPreview.this.e.updateTexImage();
            com.otaliastudios.cameraview.preview.GlCameraPreview.this.e.getTransformMatrix(textureTransform);
            if (com.otaliastudios.cameraview.preview.GlCameraPreview.this.mDrawRotation != 0) {
                android.opengl.Matrix.translateM(textureTransform, 0, 0.5f, 0.5f, 0.0f);
                android.opengl.Matrix.rotateM(textureTransform, 0, com.otaliastudios.cameraview.preview.GlCameraPreview.this.mDrawRotation, 0.0f, 0.0f, 1.0f);
                android.opengl.Matrix.translateM(textureTransform, 0, -0.5f, -0.5f, 0.0f);
            }
            if (com.otaliastudios.cameraview.preview.GlCameraPreview.this.isCropping()) {
                com.otaliastudios.cameraview.preview.GlCameraPreview glCameraPreview2 = com.otaliastudios.cameraview.preview.GlCameraPreview.this;
                android.opengl.Matrix.translateM(textureTransform, 0, (1.0f - glCameraPreview2.h) / 2.0f, (1.0f - glCameraPreview2.i) / 2.0f, 0.0f);
                com.otaliastudios.cameraview.preview.GlCameraPreview glCameraPreview3 = com.otaliastudios.cameraview.preview.GlCameraPreview.this;
                android.opengl.Matrix.scaleM(textureTransform, 0, glCameraPreview3.h, glCameraPreview3.i, 1.0f);
            }
            com.otaliastudios.cameraview.preview.GlCameraPreview.this.f.draw(com.otaliastudios.cameraview.preview.GlCameraPreview.this.e.getTimestamp() / 1000);
            for (com.otaliastudios.cameraview.preview.RendererFrameCallback rendererFrameCallback : com.otaliastudios.cameraview.preview.GlCameraPreview.this.g) {
                android.graphics.SurfaceTexture surfaceTexture = com.otaliastudios.cameraview.preview.GlCameraPreview.this.e;
                com.otaliastudios.cameraview.preview.GlCameraPreview glCameraPreview4 = com.otaliastudios.cameraview.preview.GlCameraPreview.this;
                rendererFrameCallback.onRendererFrame(surfaceTexture, glCameraPreview4.mDrawRotation, glCameraPreview4.h, glCameraPreview4.i);
            }
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        @com.otaliastudios.cameraview.preview.RendererThread
        public void onSurfaceChanged(javax.microedition.khronos.opengles.GL10 gl10, int i, int i2) {
            gl10.glViewport(0, 0, i, i2);
            com.otaliastudios.cameraview.preview.GlCameraPreview.this.k.setSize(i, i2);
            if (!com.otaliastudios.cameraview.preview.GlCameraPreview.this.d) {
                com.otaliastudios.cameraview.preview.GlCameraPreview.this.dispatchOnSurfaceAvailable(i, i2);
                com.otaliastudios.cameraview.preview.GlCameraPreview.this.d = true;
                return;
            }
            com.otaliastudios.cameraview.preview.GlCameraPreview glCameraPreview = com.otaliastudios.cameraview.preview.GlCameraPreview.this;
            if (i == glCameraPreview.mOutputSurfaceWidth && i2 == glCameraPreview.mOutputSurfaceHeight) {
                return;
            }
            glCameraPreview.dispatchOnSurfaceSizeChanged(i, i2);
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        @com.otaliastudios.cameraview.preview.RendererThread
        public void onSurfaceCreated(javax.microedition.khronos.opengles.GL10 gl10, javax.microedition.khronos.egl.EGLConfig eGLConfig) {
            if (com.otaliastudios.cameraview.preview.GlCameraPreview.this.k == null) {
                com.otaliastudios.cameraview.preview.GlCameraPreview.this.k = new com.otaliastudios.cameraview.filter.NoFilter();
            }
            com.otaliastudios.cameraview.preview.GlCameraPreview.this.f = new com.otaliastudios.cameraview.internal.GlTextureDrawer();
            com.otaliastudios.cameraview.preview.GlCameraPreview.this.f.setFilter(com.otaliastudios.cameraview.preview.GlCameraPreview.this.k);
            int id = com.otaliastudios.cameraview.preview.GlCameraPreview.this.f.getTexture().getId();
            com.otaliastudios.cameraview.preview.GlCameraPreview.this.e = new android.graphics.SurfaceTexture(id);
            com.otaliastudios.cameraview.preview.GlCameraPreview.this.getView().queueEvent(new com.otaliastudios.cameraview.preview.GlCameraPreview.Renderer.AnonymousClass1(id));
            com.otaliastudios.cameraview.preview.GlCameraPreview.this.e.setOnFrameAvailableListener(new com.otaliastudios.cameraview.preview.GlCameraPreview.Renderer.AnonymousClass2());
        }

        @com.otaliastudios.cameraview.preview.RendererThread
        public void onSurfaceDestroyed() {
            if (com.otaliastudios.cameraview.preview.GlCameraPreview.this.e != null) {
                com.otaliastudios.cameraview.preview.GlCameraPreview.this.e.setOnFrameAvailableListener(null);
                com.otaliastudios.cameraview.preview.GlCameraPreview.this.e.release();
                com.otaliastudios.cameraview.preview.GlCameraPreview.this.e = null;
            }
            if (com.otaliastudios.cameraview.preview.GlCameraPreview.this.f != null) {
                com.otaliastudios.cameraview.preview.GlCameraPreview.this.f.release();
                com.otaliastudios.cameraview.preview.GlCameraPreview.this.f = null;
            }
        }
    }

    public GlCameraPreview(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.NonNull android.view.ViewGroup viewGroup) {
        super(context, viewGroup);
        this.g = new java.util.concurrent.CopyOnWriteArraySet();
        this.h = 1.0f;
        this.i = 1.0f;
    }

    @Override // com.otaliastudios.cameraview.preview.RendererCameraPreview
    public void addRendererFrameCallback(@androidx.annotation.NonNull com.otaliastudios.cameraview.preview.RendererFrameCallback rendererFrameCallback) {
        getView().queueEvent(new com.otaliastudios.cameraview.preview.GlCameraPreview.AnonymousClass2(rendererFrameCallback));
    }

    @Override // com.otaliastudios.cameraview.preview.CameraPreview
    public void crop(@androidx.annotation.Nullable com.otaliastudios.cameraview.preview.CameraPreview.CropCallback cropCallback) {
        int i;
        int i2;
        float f;
        float f2;
        if (this.mInputStreamWidth > 0 && this.mInputStreamHeight > 0 && (i = this.mOutputSurfaceWidth) > 0 && (i2 = this.mOutputSurfaceHeight) > 0) {
            com.otaliastudios.cameraview.size.AspectRatio of = com.otaliastudios.cameraview.size.AspectRatio.of(i, i2);
            com.otaliastudios.cameraview.size.AspectRatio of2 = com.otaliastudios.cameraview.size.AspectRatio.of(this.mInputStreamWidth, this.mInputStreamHeight);
            if (of.toFloat() >= of2.toFloat()) {
                f2 = of.toFloat() / of2.toFloat();
                f = 1.0f;
            } else {
                f = of2.toFloat() / of.toFloat();
                f2 = 1.0f;
            }
            this.mCropping = f > 1.02f || f2 > 1.02f;
            this.h = 1.0f / f;
            this.i = 1.0f / f2;
            getView().requestRender();
        }
        if (cropCallback != null) {
            cropCallback.onCrop();
        }
    }

    @Override // com.otaliastudios.cameraview.preview.FilterCameraPreview
    @androidx.annotation.NonNull
    public com.otaliastudios.cameraview.filter.Filter getCurrentFilter() {
        return this.k;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.otaliastudios.cameraview.preview.CameraPreview
    @androidx.annotation.NonNull
    public android.graphics.SurfaceTexture getOutput() {
        return this.e;
    }

    @Override // com.otaliastudios.cameraview.preview.CameraPreview
    @androidx.annotation.NonNull
    public java.lang.Class<android.graphics.SurfaceTexture> getOutputClass() {
        return android.graphics.SurfaceTexture.class;
    }

    @Override // com.otaliastudios.cameraview.preview.CameraPreview
    @androidx.annotation.NonNull
    public android.view.View getRootView() {
        return this.j;
    }

    public int getTextureId() {
        com.otaliastudios.cameraview.internal.GlTextureDrawer glTextureDrawer = this.f;
        if (glTextureDrawer != null) {
            return glTextureDrawer.getTexture().getId();
        }
        return -1;
    }

    @androidx.annotation.NonNull
    public com.otaliastudios.cameraview.preview.GlCameraPreview.Renderer instantiateRenderer() {
        return new com.otaliastudios.cameraview.preview.GlCameraPreview.Renderer();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.otaliastudios.cameraview.preview.CameraPreview
    @androidx.annotation.NonNull
    public android.opengl.GLSurfaceView onCreateView(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.NonNull android.view.ViewGroup viewGroup) {
        android.view.ViewGroup viewGroup2 = (android.view.ViewGroup) android.view.LayoutInflater.from(context).inflate(com.otaliastudios.cameraview.R.layout.cameraview_gl_view, viewGroup, false);
        android.opengl.GLSurfaceView gLSurfaceView = (android.opengl.GLSurfaceView) viewGroup2.findViewById(com.otaliastudios.cameraview.R.id.gl_surface_view);
        com.otaliastudios.cameraview.preview.GlCameraPreview.Renderer instantiateRenderer = instantiateRenderer();
        gLSurfaceView.setEGLContextClientVersion(2);
        gLSurfaceView.setRenderer(instantiateRenderer);
        gLSurfaceView.setRenderMode(0);
        gLSurfaceView.getHolder().addCallback(new com.otaliastudios.cameraview.preview.GlCameraPreview.AnonymousClass1(gLSurfaceView, instantiateRenderer));
        viewGroup.addView(viewGroup2, 0);
        this.j = viewGroup2;
        return gLSurfaceView;
    }

    @Override // com.otaliastudios.cameraview.preview.CameraPreview
    public void onDestroy() {
        super.onDestroy();
        this.g.clear();
    }

    @Override // com.otaliastudios.cameraview.preview.CameraPreview
    public void onPause() {
        super.onPause();
        getView().onPause();
    }

    @Override // com.otaliastudios.cameraview.preview.CameraPreview
    public void onResume() {
        super.onResume();
        getView().onResume();
    }

    @Override // com.otaliastudios.cameraview.preview.RendererCameraPreview
    public void removeRendererFrameCallback(@androidx.annotation.NonNull com.otaliastudios.cameraview.preview.RendererFrameCallback rendererFrameCallback) {
        this.g.remove(rendererFrameCallback);
    }

    @Override // com.otaliastudios.cameraview.preview.FilterCameraPreview
    public void setFilter(@androidx.annotation.NonNull com.otaliastudios.cameraview.filter.Filter filter) {
        this.k = filter;
        if (hasSurface()) {
            filter.setSize(this.mOutputSurfaceWidth, this.mOutputSurfaceHeight);
        }
        getView().queueEvent(new com.otaliastudios.cameraview.preview.GlCameraPreview.AnonymousClass3(filter));
    }

    @Override // com.otaliastudios.cameraview.preview.CameraPreview
    public boolean supportsCropping() {
        return true;
    }
}
