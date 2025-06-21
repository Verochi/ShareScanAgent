package com.google.android.exoplayer2.video.spherical;

/* loaded from: classes22.dex */
public final class CameraMotionRenderer extends com.google.android.exoplayer2.BaseRenderer {
    public final com.google.android.exoplayer2.decoder.DecoderInputBuffer E;
    public final com.google.android.exoplayer2.util.ParsableByteArray F;
    public long G;

    @androidx.annotation.Nullable
    public com.google.android.exoplayer2.video.spherical.CameraMotionListener H;
    public long I;

    public CameraMotionRenderer() {
        super(5);
        this.E = new com.google.android.exoplayer2.decoder.DecoderInputBuffer(1);
        this.F = new com.google.android.exoplayer2.util.ParsableByteArray();
    }

    @androidx.annotation.Nullable
    public final float[] a(java.nio.ByteBuffer byteBuffer) {
        if (byteBuffer.remaining() != 16) {
            return null;
        }
        this.F.reset(byteBuffer.array(), byteBuffer.limit());
        this.F.setPosition(byteBuffer.arrayOffset() + 4);
        float[] fArr = new float[3];
        for (int i = 0; i < 3; i++) {
            fArr[i] = java.lang.Float.intBitsToFloat(this.F.readLittleEndianInt());
        }
        return fArr;
    }

    public final void b() {
        com.google.android.exoplayer2.video.spherical.CameraMotionListener cameraMotionListener = this.H;
        if (cameraMotionListener != null) {
            cameraMotionListener.onCameraMotionReset();
        }
    }

    @Override // com.google.android.exoplayer2.Renderer, com.google.android.exoplayer2.RendererCapabilities
    public java.lang.String getName() {
        return "CameraMotionRenderer";
    }

    @Override // com.google.android.exoplayer2.BaseRenderer, com.google.android.exoplayer2.PlayerMessage.Target
    public void handleMessage(int i, @androidx.annotation.Nullable java.lang.Object obj) throws com.google.android.exoplayer2.ExoPlaybackException {
        if (i == 7) {
            this.H = (com.google.android.exoplayer2.video.spherical.CameraMotionListener) obj;
        } else {
            super.handleMessage(i, obj);
        }
    }

    @Override // com.google.android.exoplayer2.Renderer
    public boolean isEnded() {
        return hasReadStreamToEnd();
    }

    @Override // com.google.android.exoplayer2.Renderer
    public boolean isReady() {
        return true;
    }

    @Override // com.google.android.exoplayer2.BaseRenderer
    public void onDisabled() {
        b();
    }

    @Override // com.google.android.exoplayer2.BaseRenderer
    public void onPositionReset(long j, boolean z) {
        this.I = Long.MIN_VALUE;
        b();
    }

    @Override // com.google.android.exoplayer2.BaseRenderer
    public void onStreamChanged(com.google.android.exoplayer2.Format[] formatArr, long j, long j2) {
        this.G = j2;
    }

    @Override // com.google.android.exoplayer2.Renderer
    public void render(long j, long j2) {
        while (!hasReadStreamToEnd() && this.I < 100000 + j) {
            this.E.clear();
            if (readSource(getFormatHolder(), this.E, false) != -4 || this.E.isEndOfStream()) {
                return;
            }
            com.google.android.exoplayer2.decoder.DecoderInputBuffer decoderInputBuffer = this.E;
            this.I = decoderInputBuffer.timeUs;
            if (this.H != null && !decoderInputBuffer.isDecodeOnly()) {
                this.E.flip();
                float[] a = a((java.nio.ByteBuffer) com.google.android.exoplayer2.util.Util.castNonNull(this.E.data));
                if (a != null) {
                    ((com.google.android.exoplayer2.video.spherical.CameraMotionListener) com.google.android.exoplayer2.util.Util.castNonNull(this.H)).onCameraMotion(this.I - this.G, a);
                }
            }
        }
    }

    @Override // com.google.android.exoplayer2.RendererCapabilities
    public int supportsFormat(com.google.android.exoplayer2.Format format) {
        return "application/x-camera-motion".equals(format.sampleMimeType) ? defpackage.ub2.a(4) : defpackage.ub2.a(0);
    }
}
