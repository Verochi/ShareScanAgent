package com.google.android.exoplayer2.video;

/* loaded from: classes22.dex */
public class VideoDecoderGLSurfaceView extends android.opengl.GLSurfaceView {
    public final com.google.android.exoplayer2.video.VideoDecoderGLFrameRenderer n;

    public VideoDecoderGLSurfaceView(android.content.Context context) {
        this(context, null);
    }

    public VideoDecoderGLSurfaceView(android.content.Context context, @androidx.annotation.Nullable android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
        com.google.android.exoplayer2.video.VideoDecoderGLFrameRenderer videoDecoderGLFrameRenderer = new com.google.android.exoplayer2.video.VideoDecoderGLFrameRenderer(this);
        this.n = videoDecoderGLFrameRenderer;
        setPreserveEGLContextOnPause(true);
        setEGLContextClientVersion(2);
        setRenderer(videoDecoderGLFrameRenderer);
        setRenderMode(0);
    }

    public com.google.android.exoplayer2.video.VideoDecoderOutputBufferRenderer getVideoDecoderOutputBufferRenderer() {
        return this.n;
    }
}
