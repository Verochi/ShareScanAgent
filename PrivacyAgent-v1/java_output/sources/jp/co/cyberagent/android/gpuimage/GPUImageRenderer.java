package jp.co.cyberagent.android.gpuimage;

/* loaded from: classes14.dex */
public class GPUImageRenderer implements android.opengl.GLSurfaceView.Renderer, jp.co.cyberagent.android.gpuimage.GLTextureView.Renderer, android.hardware.Camera.PreviewCallback {
    public static final float[] CUBE = {-1.0f, -1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, 1.0f};
    public int A;
    public int B;
    public int C;
    public jp.co.cyberagent.android.gpuimage.util.Rotation F;
    public boolean G;
    public boolean H;
    public jp.co.cyberagent.android.gpuimage.filter.GPUImageFilter n;
    public final java.nio.FloatBuffer v;
    public final java.nio.FloatBuffer w;
    public java.nio.IntBuffer x;
    public int y;
    public int z;
    public final java.lang.Object surfaceChangedWaiter = new java.lang.Object();
    public int t = -1;
    public android.graphics.SurfaceTexture u = null;
    public jp.co.cyberagent.android.gpuimage.GPUImage.ScaleType I = jp.co.cyberagent.android.gpuimage.GPUImage.ScaleType.CENTER_CROP;
    public float J = 0.0f;
    public float K = 0.0f;
    public float L = 0.0f;
    public final java.util.Queue<java.lang.Runnable> D = new java.util.LinkedList();
    public final java.util.Queue<java.lang.Runnable> E = new java.util.LinkedList();

    /* renamed from: jp.co.cyberagent.android.gpuimage.GPUImageRenderer$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {
        public final /* synthetic */ android.hardware.Camera n;

        public AnonymousClass1(android.hardware.Camera camera) {
            this.n = camera;
        }

        @Override // java.lang.Runnable
        public void run() {
            int[] iArr = new int[1];
            android.opengl.GLES20.glGenTextures(1, iArr, 0);
            jp.co.cyberagent.android.gpuimage.GPUImageRenderer.this.u = new android.graphics.SurfaceTexture(iArr[0]);
            try {
                this.n.setPreviewTexture(jp.co.cyberagent.android.gpuimage.GPUImageRenderer.this.u);
                this.n.setPreviewCallback(jp.co.cyberagent.android.gpuimage.GPUImageRenderer.this);
                this.n.startPreview();
            } catch (java.io.IOException e) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: jp.co.cyberagent.android.gpuimage.GPUImageRenderer$2, reason: invalid class name */
    public class AnonymousClass2 implements java.lang.Runnable {
        public final /* synthetic */ jp.co.cyberagent.android.gpuimage.filter.GPUImageFilter n;

        public AnonymousClass2(jp.co.cyberagent.android.gpuimage.filter.GPUImageFilter gPUImageFilter) {
            this.n = gPUImageFilter;
        }

        @Override // java.lang.Runnable
        public void run() {
            jp.co.cyberagent.android.gpuimage.filter.GPUImageFilter gPUImageFilter = jp.co.cyberagent.android.gpuimage.GPUImageRenderer.this.n;
            jp.co.cyberagent.android.gpuimage.GPUImageRenderer.this.n = this.n;
            if (gPUImageFilter != null) {
                gPUImageFilter.destroy();
            }
            jp.co.cyberagent.android.gpuimage.GPUImageRenderer.this.n.ifNeedInit();
            android.opengl.GLES20.glUseProgram(jp.co.cyberagent.android.gpuimage.GPUImageRenderer.this.n.getProgram());
            jp.co.cyberagent.android.gpuimage.GPUImageRenderer.this.n.onOutputSizeChanged(jp.co.cyberagent.android.gpuimage.GPUImageRenderer.this.y, jp.co.cyberagent.android.gpuimage.GPUImageRenderer.this.z);
        }
    }

    /* renamed from: jp.co.cyberagent.android.gpuimage.GPUImageRenderer$3, reason: invalid class name */
    public class AnonymousClass3 implements java.lang.Runnable {
        public AnonymousClass3() {
        }

        @Override // java.lang.Runnable
        public void run() {
            android.opengl.GLES20.glDeleteTextures(1, new int[]{jp.co.cyberagent.android.gpuimage.GPUImageRenderer.this.t}, 0);
            jp.co.cyberagent.android.gpuimage.GPUImageRenderer.this.t = -1;
        }
    }

    /* renamed from: jp.co.cyberagent.android.gpuimage.GPUImageRenderer$4, reason: invalid class name */
    public class AnonymousClass4 implements java.lang.Runnable {
        public final /* synthetic */ android.graphics.Bitmap n;
        public final /* synthetic */ boolean t;

        public AnonymousClass4(android.graphics.Bitmap bitmap, boolean z) {
            this.n = bitmap;
            this.t = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            android.graphics.Bitmap bitmap = null;
            if (this.n.getWidth() % 2 == 1) {
                android.graphics.Bitmap createBitmap = android.graphics.Bitmap.createBitmap(this.n.getWidth() + 1, this.n.getHeight(), android.graphics.Bitmap.Config.ARGB_8888);
                android.graphics.Canvas canvas = new android.graphics.Canvas(createBitmap);
                canvas.drawARGB(0, 0, 0, 0);
                canvas.drawBitmap(this.n, 0.0f, 0.0f, (android.graphics.Paint) null);
                jp.co.cyberagent.android.gpuimage.GPUImageRenderer.this.C = 1;
                bitmap = createBitmap;
            } else {
                jp.co.cyberagent.android.gpuimage.GPUImageRenderer.this.C = 0;
            }
            jp.co.cyberagent.android.gpuimage.GPUImageRenderer gPUImageRenderer = jp.co.cyberagent.android.gpuimage.GPUImageRenderer.this;
            gPUImageRenderer.t = jp.co.cyberagent.android.gpuimage.util.OpenGlUtils.loadTexture(bitmap != null ? bitmap : this.n, gPUImageRenderer.t, this.t);
            if (bitmap != null) {
                bitmap.recycle();
            }
            jp.co.cyberagent.android.gpuimage.GPUImageRenderer.this.A = this.n.getWidth();
            jp.co.cyberagent.android.gpuimage.GPUImageRenderer.this.B = this.n.getHeight();
            jp.co.cyberagent.android.gpuimage.GPUImageRenderer.this.n();
        }
    }

    public GPUImageRenderer(jp.co.cyberagent.android.gpuimage.filter.GPUImageFilter gPUImageFilter) {
        this.n = gPUImageFilter;
        float[] fArr = CUBE;
        java.nio.FloatBuffer asFloatBuffer = java.nio.ByteBuffer.allocateDirect(fArr.length * 4).order(java.nio.ByteOrder.nativeOrder()).asFloatBuffer();
        this.v = asFloatBuffer;
        asFloatBuffer.put(fArr).position(0);
        this.w = java.nio.ByteBuffer.allocateDirect(jp.co.cyberagent.android.gpuimage.util.TextureRotationUtil.TEXTURE_NO_ROTATION.length * 4).order(java.nio.ByteOrder.nativeOrder()).asFloatBuffer();
        setRotation(jp.co.cyberagent.android.gpuimage.util.Rotation.NORMAL, false, false);
    }

    public void deleteImage() {
        runOnDraw(new jp.co.cyberagent.android.gpuimage.GPUImageRenderer.AnonymousClass3());
    }

    public int getFrameHeight() {
        return this.z;
    }

    public int getFrameWidth() {
        return this.y;
    }

    public jp.co.cyberagent.android.gpuimage.util.Rotation getRotation() {
        return this.F;
    }

    public boolean isFlippedHorizontally() {
        return this.G;
    }

    public boolean isFlippedVertically() {
        return this.H;
    }

    public final float m(float f, float f2) {
        return f == 0.0f ? f2 : 1.0f - f2;
    }

    public final void n() {
        int i = this.y;
        float f = i;
        int i2 = this.z;
        float f2 = i2;
        jp.co.cyberagent.android.gpuimage.util.Rotation rotation = this.F;
        if (rotation == jp.co.cyberagent.android.gpuimage.util.Rotation.ROTATION_270 || rotation == jp.co.cyberagent.android.gpuimage.util.Rotation.ROTATION_90) {
            f = i2;
            f2 = i;
        }
        float max = java.lang.Math.max(f / this.A, f2 / this.B);
        float round = java.lang.Math.round(this.A * max) / f;
        float round2 = java.lang.Math.round(this.B * max) / f2;
        float[] fArr = CUBE;
        float[] rotation2 = jp.co.cyberagent.android.gpuimage.util.TextureRotationUtil.getRotation(this.F, this.G, this.H);
        if (this.I == jp.co.cyberagent.android.gpuimage.GPUImage.ScaleType.CENTER_CROP) {
            float f3 = (1.0f - (1.0f / round)) / 2.0f;
            float f4 = (1.0f - (1.0f / round2)) / 2.0f;
            rotation2 = new float[]{m(rotation2[0], f3), m(rotation2[1], f4), m(rotation2[2], f3), m(rotation2[3], f4), m(rotation2[4], f3), m(rotation2[5], f4), m(rotation2[6], f3), m(rotation2[7], f4)};
        } else {
            fArr = new float[]{fArr[0] / round2, fArr[1] / round, fArr[2] / round2, fArr[3] / round, fArr[4] / round2, fArr[5] / round, fArr[6] / round2, fArr[7] / round};
        }
        this.v.clear();
        this.v.put(fArr).position(0);
        this.w.clear();
        this.w.put(rotation2).position(0);
    }

    public final void o(java.util.Queue<java.lang.Runnable> queue) {
        synchronized (queue) {
            while (!queue.isEmpty()) {
                queue.poll().run();
            }
        }
    }

    @Override // android.opengl.GLSurfaceView.Renderer, jp.co.cyberagent.android.gpuimage.GLTextureView.Renderer
    public void onDrawFrame(javax.microedition.khronos.opengles.GL10 gl10) {
        android.opengl.GLES20.glClear(com.uc.crashsdk.export.LogType.UNEXP_RESTART);
        o(this.D);
        this.n.onDraw(this.t, this.v, this.w);
        o(this.E);
        android.graphics.SurfaceTexture surfaceTexture = this.u;
        if (surfaceTexture != null) {
            surfaceTexture.updateTexImage();
        }
    }

    public void onPreviewFrame(byte[] bArr, int i, int i2) {
        if (this.x == null) {
            this.x = java.nio.IntBuffer.allocate(i * i2);
        }
    }

    @Override // android.hardware.Camera.PreviewCallback
    public void onPreviewFrame(byte[] bArr, android.hardware.Camera camera) {
        android.hardware.Camera.Size previewSize = camera.getParameters().getPreviewSize();
        onPreviewFrame(bArr, previewSize.width, previewSize.height);
    }

    @Override // android.opengl.GLSurfaceView.Renderer, jp.co.cyberagent.android.gpuimage.GLTextureView.Renderer
    public void onSurfaceChanged(javax.microedition.khronos.opengles.GL10 gl10, int i, int i2) {
        this.y = i;
        this.z = i2;
        android.opengl.GLES20.glViewport(0, 0, i, i2);
        android.opengl.GLES20.glUseProgram(this.n.getProgram());
        this.n.onOutputSizeChanged(i, i2);
        n();
        synchronized (this.surfaceChangedWaiter) {
            this.surfaceChangedWaiter.notifyAll();
        }
    }

    @Override // android.opengl.GLSurfaceView.Renderer, jp.co.cyberagent.android.gpuimage.GLTextureView.Renderer
    public void onSurfaceCreated(javax.microedition.khronos.opengles.GL10 gl10, javax.microedition.khronos.egl.EGLConfig eGLConfig) {
        android.opengl.GLES20.glClearColor(this.J, this.K, this.L, 1.0f);
        android.opengl.GLES20.glDisable(com.badlogic.gdx.graphics.GL20.GL_DEPTH_TEST);
        this.n.ifNeedInit();
    }

    public void runOnDraw(java.lang.Runnable runnable) {
        synchronized (this.D) {
            this.D.add(runnable);
        }
    }

    public void runOnDrawEnd(java.lang.Runnable runnable) {
        synchronized (this.E) {
            this.E.add(runnable);
        }
    }

    public void setBackgroundColor(float f, float f2, float f3) {
        this.J = f;
        this.K = f2;
        this.L = f3;
    }

    public void setFilter(jp.co.cyberagent.android.gpuimage.filter.GPUImageFilter gPUImageFilter) {
        runOnDraw(new jp.co.cyberagent.android.gpuimage.GPUImageRenderer.AnonymousClass2(gPUImageFilter));
    }

    public void setImageBitmap(android.graphics.Bitmap bitmap) {
        setImageBitmap(bitmap, true);
    }

    public void setImageBitmap(android.graphics.Bitmap bitmap, boolean z) {
        if (bitmap == null) {
            return;
        }
        runOnDraw(new jp.co.cyberagent.android.gpuimage.GPUImageRenderer.AnonymousClass4(bitmap, z));
    }

    public void setRotation(jp.co.cyberagent.android.gpuimage.util.Rotation rotation) {
        this.F = rotation;
        n();
    }

    public void setRotation(jp.co.cyberagent.android.gpuimage.util.Rotation rotation, boolean z, boolean z2) {
        this.G = z;
        this.H = z2;
        setRotation(rotation);
    }

    public void setRotationCamera(jp.co.cyberagent.android.gpuimage.util.Rotation rotation, boolean z, boolean z2) {
        setRotation(rotation, z2, z);
    }

    public void setScaleType(jp.co.cyberagent.android.gpuimage.GPUImage.ScaleType scaleType) {
        this.I = scaleType;
    }

    public void setUpSurfaceTexture(android.hardware.Camera camera) {
        runOnDraw(new jp.co.cyberagent.android.gpuimage.GPUImageRenderer.AnonymousClass1(camera));
    }
}
