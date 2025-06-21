package com.google.android.exoplayer2.ui.spherical;

/* loaded from: classes22.dex */
final class SceneRenderer implements com.google.android.exoplayer2.video.VideoFrameMetadataListener, com.google.android.exoplayer2.video.spherical.CameraMotionListener {
    public int i;
    public android.graphics.SurfaceTexture j;

    @androidx.annotation.Nullable
    public byte[] m;
    public final java.util.concurrent.atomic.AtomicBoolean a = new java.util.concurrent.atomic.AtomicBoolean();
    public final java.util.concurrent.atomic.AtomicBoolean b = new java.util.concurrent.atomic.AtomicBoolean(true);
    public final com.google.android.exoplayer2.ui.spherical.ProjectionRenderer c = new com.google.android.exoplayer2.ui.spherical.ProjectionRenderer();
    public final com.google.android.exoplayer2.video.spherical.FrameRotationQueue d = new com.google.android.exoplayer2.video.spherical.FrameRotationQueue();
    public final com.google.android.exoplayer2.util.TimedValueQueue<java.lang.Long> e = new com.google.android.exoplayer2.util.TimedValueQueue<>();
    public final com.google.android.exoplayer2.util.TimedValueQueue<com.google.android.exoplayer2.video.spherical.Projection> f = new com.google.android.exoplayer2.util.TimedValueQueue<>();
    public final float[] g = new float[16];
    public final float[] h = new float[16];
    public volatile int k = 0;
    public int l = -1;

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d(android.graphics.SurfaceTexture surfaceTexture) {
        this.a.set(true);
    }

    public void b(float[] fArr, boolean z) {
        android.opengl.GLES20.glClear(16384);
        com.google.android.exoplayer2.util.GlUtil.checkGlError();
        if (this.a.compareAndSet(true, false)) {
            ((android.graphics.SurfaceTexture) com.google.android.exoplayer2.util.Assertions.checkNotNull(this.j)).updateTexImage();
            com.google.android.exoplayer2.util.GlUtil.checkGlError();
            if (this.b.compareAndSet(true, false)) {
                android.opengl.Matrix.setIdentityM(this.g, 0);
            }
            long timestamp = this.j.getTimestamp();
            java.lang.Long poll = this.e.poll(timestamp);
            if (poll != null) {
                this.d.pollRotationMatrix(this.g, poll.longValue());
            }
            com.google.android.exoplayer2.video.spherical.Projection pollFloor = this.f.pollFloor(timestamp);
            if (pollFloor != null) {
                this.c.d(pollFloor);
            }
        }
        android.opengl.Matrix.multiplyMM(this.h, 0, fArr, 0, this.g, 0);
        this.c.a(this.i, this.h, z);
    }

    public android.graphics.SurfaceTexture c() {
        android.opengl.GLES20.glClearColor(0.5f, 0.5f, 0.5f, 1.0f);
        com.google.android.exoplayer2.util.GlUtil.checkGlError();
        this.c.b();
        com.google.android.exoplayer2.util.GlUtil.checkGlError();
        this.i = com.google.android.exoplayer2.util.GlUtil.createExternalTexture();
        android.graphics.SurfaceTexture surfaceTexture = new android.graphics.SurfaceTexture(this.i);
        this.j = surfaceTexture;
        surfaceTexture.setOnFrameAvailableListener(new com.google.android.exoplayer2.ui.spherical.a(this));
        return this.j;
    }

    public void e(int i) {
        this.k = i;
    }

    public final void f(@androidx.annotation.Nullable byte[] bArr, int i, long j) {
        byte[] bArr2 = this.m;
        int i2 = this.l;
        this.m = bArr;
        if (i == -1) {
            i = this.k;
        }
        this.l = i;
        if (i2 == i && java.util.Arrays.equals(bArr2, this.m)) {
            return;
        }
        byte[] bArr3 = this.m;
        com.google.android.exoplayer2.video.spherical.Projection decode = bArr3 != null ? com.google.android.exoplayer2.video.spherical.ProjectionDecoder.decode(bArr3, this.l) : null;
        if (decode == null || !com.google.android.exoplayer2.ui.spherical.ProjectionRenderer.c(decode)) {
            decode = com.google.android.exoplayer2.video.spherical.Projection.createEquirectangular(this.l);
        }
        this.f.add(j, decode);
    }

    @Override // com.google.android.exoplayer2.video.spherical.CameraMotionListener
    public void onCameraMotion(long j, float[] fArr) {
        this.d.setRotation(j, fArr);
    }

    @Override // com.google.android.exoplayer2.video.spherical.CameraMotionListener
    public void onCameraMotionReset() {
        this.e.clear();
        this.d.reset();
        this.b.set(true);
    }

    @Override // com.google.android.exoplayer2.video.VideoFrameMetadataListener
    public void onVideoFrameAboutToBeRendered(long j, long j2, com.google.android.exoplayer2.Format format, @androidx.annotation.Nullable android.media.MediaFormat mediaFormat) {
        this.e.add(j2, java.lang.Long.valueOf(j));
        f(format.projectionData, format.stereoMode, j2);
    }
}
