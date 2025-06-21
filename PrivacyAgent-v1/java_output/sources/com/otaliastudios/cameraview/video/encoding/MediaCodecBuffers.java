package com.otaliastudios.cameraview.video.encoding;

@androidx.annotation.RequiresApi(18)
/* loaded from: classes19.dex */
class MediaCodecBuffers {
    public final android.media.MediaCodec a;
    public java.nio.ByteBuffer[] c = null;
    public final java.nio.ByteBuffer[] b = null;

    public MediaCodecBuffers(android.media.MediaCodec mediaCodec) {
        this.a = mediaCodec;
    }

    public java.nio.ByteBuffer a(int i) {
        return this.a.getInputBuffer(i);
    }

    public java.nio.ByteBuffer b(int i) {
        return this.a.getOutputBuffer(i);
    }

    public void c() {
    }
}
