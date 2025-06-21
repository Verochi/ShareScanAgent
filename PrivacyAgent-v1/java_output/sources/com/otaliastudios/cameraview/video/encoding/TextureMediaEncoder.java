package com.otaliastudios.cameraview.video.encoding;

@androidx.annotation.RequiresApi(api = 18)
/* loaded from: classes19.dex */
public class TextureMediaEncoder extends com.otaliastudios.cameraview.video.encoding.VideoMediaEncoder<com.otaliastudios.cameraview.video.encoding.TextureConfig> {
    public static final java.lang.String FILTER_EVENT = "filter";
    public static final java.lang.String FRAME_EVENT = "frame";
    public static final com.otaliastudios.cameraview.CameraLogger x = com.otaliastudios.cameraview.CameraLogger.create(com.otaliastudios.cameraview.video.encoding.TextureMediaEncoder.class.getSimpleName());
    public int r;

    /* renamed from: s, reason: collision with root package name */
    public com.otaliastudios.opengl.core.EglCore f421s;
    public com.otaliastudios.opengl.surface.EglWindowSurface t;
    public com.otaliastudios.cameraview.internal.GlTextureDrawer u;
    public com.otaliastudios.cameraview.internal.Pool<com.otaliastudios.cameraview.video.encoding.TextureMediaEncoder.Frame> v;
    public long w;

    /* renamed from: com.otaliastudios.cameraview.video.encoding.TextureMediaEncoder$1, reason: invalid class name */
    public class AnonymousClass1 implements com.otaliastudios.cameraview.internal.Pool.Factory<com.otaliastudios.cameraview.video.encoding.TextureMediaEncoder.Frame> {
        public AnonymousClass1() {
        }

        @Override // com.otaliastudios.cameraview.internal.Pool.Factory
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public com.otaliastudios.cameraview.video.encoding.TextureMediaEncoder.Frame create() {
            return new com.otaliastudios.cameraview.video.encoding.TextureMediaEncoder.Frame(null);
        }
    }

    public static class Frame {
        public long timestampMillis;
        public long timestampNanos;
        public float[] transform;

        public Frame() {
            this.transform = new float[16];
        }

        public /* synthetic */ Frame(com.otaliastudios.cameraview.video.encoding.TextureMediaEncoder.AnonymousClass1 anonymousClass1) {
            this();
        }

        public final long b() {
            return this.timestampNanos / 1000;
        }
    }

    public TextureMediaEncoder(@androidx.annotation.NonNull com.otaliastudios.cameraview.video.encoding.TextureConfig textureConfig) {
        super(textureConfig.a());
        this.v = new com.otaliastudios.cameraview.internal.Pool<>(Integer.MAX_VALUE, new com.otaliastudios.cameraview.video.encoding.TextureMediaEncoder.AnonymousClass1());
        this.w = Long.MIN_VALUE;
    }

    @androidx.annotation.NonNull
    public com.otaliastudios.cameraview.video.encoding.TextureMediaEncoder.Frame acquireFrame() {
        if (this.v.isEmpty()) {
            throw new java.lang.RuntimeException("Need more frames than this! Please increase the pool size.");
        }
        return this.v.get();
    }

    public final void k(@androidx.annotation.NonNull com.otaliastudios.cameraview.filter.Filter filter) {
        this.u.setFilter(filter);
    }

    public final void l(@androidx.annotation.NonNull com.otaliastudios.cameraview.video.encoding.TextureMediaEncoder.Frame frame) {
        if (!shouldRenderFrame(frame.b())) {
            this.v.recycle(frame);
            return;
        }
        if (this.mFrameNumber == 1) {
            notifyFirstFrameMillis(frame.timestampMillis);
        }
        if (this.w == Long.MIN_VALUE) {
            this.w = frame.b();
        }
        if (!hasReachedMaxLength()) {
            if (frame.b() - this.w > getMaxLengthUs()) {
                x.w("onEvent -", "frameNumber:", java.lang.Integer.valueOf(this.mFrameNumber), "timestampUs:", java.lang.Long.valueOf(frame.b()), "firstTimeUs:", java.lang.Long.valueOf(this.w), "- reached max length! deltaUs:", java.lang.Long.valueOf(frame.b() - this.w));
                notifyMaxLengthReached();
            }
        }
        com.otaliastudios.cameraview.CameraLogger cameraLogger = x;
        cameraLogger.i("onEvent -", "frameNumber:", java.lang.Integer.valueOf(this.mFrameNumber), "timestampUs:", java.lang.Long.valueOf(frame.b()), "hasReachedMaxLength:", java.lang.Boolean.valueOf(hasReachedMaxLength()), "thread:", java.lang.Thread.currentThread(), "- draining.");
        drainOutput(false);
        cameraLogger.i("onEvent -", "frameNumber:", java.lang.Integer.valueOf(this.mFrameNumber), "timestampUs:", java.lang.Long.valueOf(frame.b()), "hasReachedMaxLength:", java.lang.Boolean.valueOf(hasReachedMaxLength()), "thread:", java.lang.Thread.currentThread(), "- drawing.");
        float[] fArr = frame.transform;
        C c = this.mConfig;
        float f = ((com.otaliastudios.cameraview.video.encoding.TextureConfig) c).scaleX;
        float f2 = ((com.otaliastudios.cameraview.video.encoding.TextureConfig) c).scaleY;
        android.opengl.Matrix.translateM(fArr, 0, (1.0f - f) / 2.0f, (1.0f - f2) / 2.0f, 0.0f);
        android.opengl.Matrix.scaleM(fArr, 0, f, f2, 1.0f);
        android.opengl.Matrix.translateM(fArr, 0, 0.5f, 0.5f, 0.0f);
        android.opengl.Matrix.rotateM(fArr, 0, this.r, 0.0f, 0.0f, 1.0f);
        android.opengl.Matrix.translateM(fArr, 0, -0.5f, -0.5f, 0.0f);
        if (((com.otaliastudios.cameraview.video.encoding.TextureConfig) this.mConfig).b()) {
            C c2 = this.mConfig;
            ((com.otaliastudios.cameraview.video.encoding.TextureConfig) c2).overlayDrawer.draw(((com.otaliastudios.cameraview.video.encoding.TextureConfig) c2).overlayTarget);
            android.opengl.Matrix.translateM(((com.otaliastudios.cameraview.video.encoding.TextureConfig) this.mConfig).overlayDrawer.getTransform(), 0, 0.5f, 0.5f, 0.0f);
            android.opengl.Matrix.rotateM(((com.otaliastudios.cameraview.video.encoding.TextureConfig) this.mConfig).overlayDrawer.getTransform(), 0, ((com.otaliastudios.cameraview.video.encoding.TextureConfig) this.mConfig).overlayRotation, 0.0f, 0.0f, 1.0f);
            android.opengl.Matrix.translateM(((com.otaliastudios.cameraview.video.encoding.TextureConfig) this.mConfig).overlayDrawer.getTransform(), 0, -0.5f, -0.5f, 0.0f);
        }
        cameraLogger.i("onEvent -", "frameNumber:", java.lang.Integer.valueOf(this.mFrameNumber), "timestampUs:", java.lang.Long.valueOf(frame.b()), "hasReachedMaxLength:", java.lang.Boolean.valueOf(hasReachedMaxLength()), "thread:", java.lang.Thread.currentThread(), "- gl rendering.");
        this.u.setTextureTransform(fArr);
        this.u.draw(frame.b());
        if (((com.otaliastudios.cameraview.video.encoding.TextureConfig) this.mConfig).b()) {
            ((com.otaliastudios.cameraview.video.encoding.TextureConfig) this.mConfig).overlayDrawer.render(frame.b());
        }
        this.t.setPresentationTime(frame.timestampNanos);
        this.t.swapBuffers();
        this.v.recycle(frame);
        cameraLogger.i("onEvent -", "frameNumber:", java.lang.Integer.valueOf(this.mFrameNumber), "timestampUs:", java.lang.Long.valueOf(frame.b()), "hasReachedMaxLength:", java.lang.Boolean.valueOf(hasReachedMaxLength()), "thread:", java.lang.Thread.currentThread(), "- gl rendered.");
    }

    @Override // com.otaliastudios.cameraview.video.encoding.MediaEncoder
    @com.otaliastudios.cameraview.video.encoding.EncoderThread
    public void onEvent(@androidx.annotation.NonNull java.lang.String str, @androidx.annotation.Nullable java.lang.Object obj) {
        str.hashCode();
        if (str.equals("filter")) {
            k((com.otaliastudios.cameraview.filter.Filter) obj);
        } else if (str.equals(FRAME_EVENT)) {
            l((com.otaliastudios.cameraview.video.encoding.TextureMediaEncoder.Frame) obj);
        }
    }

    @Override // com.otaliastudios.cameraview.video.encoding.VideoMediaEncoder, com.otaliastudios.cameraview.video.encoding.MediaEncoder
    @com.otaliastudios.cameraview.video.encoding.EncoderThread
    public void onPrepare(@androidx.annotation.NonNull com.otaliastudios.cameraview.video.encoding.MediaEncoderEngine.Controller controller, long j) {
        C c = this.mConfig;
        this.r = ((com.otaliastudios.cameraview.video.encoding.TextureConfig) c).rotation;
        ((com.otaliastudios.cameraview.video.encoding.TextureConfig) c).rotation = 0;
        super.onPrepare(controller, j);
        this.f421s = new com.otaliastudios.opengl.core.EglCore(((com.otaliastudios.cameraview.video.encoding.TextureConfig) this.mConfig).eglContext, 1);
        com.otaliastudios.opengl.surface.EglWindowSurface eglWindowSurface = new com.otaliastudios.opengl.surface.EglWindowSurface(this.f421s, this.mSurface, true);
        this.t = eglWindowSurface;
        eglWindowSurface.makeCurrent();
        this.u = new com.otaliastudios.cameraview.internal.GlTextureDrawer(((com.otaliastudios.cameraview.video.encoding.TextureConfig) this.mConfig).textureId);
    }

    @Override // com.otaliastudios.cameraview.video.encoding.MediaEncoder
    public void onStopped() {
        super.onStopped();
        this.v.clear();
        com.otaliastudios.opengl.surface.EglWindowSurface eglWindowSurface = this.t;
        if (eglWindowSurface != null) {
            eglWindowSurface.release();
            this.t = null;
        }
        com.otaliastudios.cameraview.internal.GlTextureDrawer glTextureDrawer = this.u;
        if (glTextureDrawer != null) {
            glTextureDrawer.release();
            this.u = null;
        }
        com.otaliastudios.opengl.core.EglCore eglCore = this.f421s;
        if (eglCore != null) {
            eglCore.release$egloo_metadata_release();
            this.f421s = null;
        }
    }

    @Override // com.otaliastudios.cameraview.video.encoding.VideoMediaEncoder
    public boolean shouldRenderFrame(long j) {
        if (!super.shouldRenderFrame(j)) {
            x.i("shouldRenderFrame - Dropping frame because of super()");
            return false;
        }
        if (this.mFrameNumber <= 10 || getPendingEvents(FRAME_EVENT) <= 2) {
            return true;
        }
        x.i("shouldRenderFrame - Dropping, we already have too many pending events:", java.lang.Integer.valueOf(getPendingEvents(FRAME_EVENT)));
        return false;
    }
}
