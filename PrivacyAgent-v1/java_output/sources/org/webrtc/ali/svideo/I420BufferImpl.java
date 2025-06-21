package org.webrtc.ali.svideo;

/* loaded from: classes26.dex */
class I420BufferImpl implements org.webrtc.ali.svideo.VideoFrame.I420Buffer {
    private final int height;
    private final int strideUV;
    private final java.nio.ByteBuffer u;
    private final java.nio.ByteBuffer v;
    private final int width;
    private final java.nio.ByteBuffer y;

    public I420BufferImpl(int i, int i2) {
        this.width = i;
        this.height = i2;
        int i3 = (i + 1) / 2;
        this.strideUV = i3;
        this.y = java.nio.ByteBuffer.allocateDirect(i * i2);
        int i4 = i3 * ((i2 + 1) / 2);
        this.u = java.nio.ByteBuffer.allocateDirect(i4);
        this.v = java.nio.ByteBuffer.allocateDirect(i4);
    }

    @Override // org.webrtc.ali.svideo.VideoFrame.I420Buffer
    public java.nio.ByteBuffer getDataU() {
        return this.u;
    }

    @Override // org.webrtc.ali.svideo.VideoFrame.I420Buffer
    public java.nio.ByteBuffer getDataV() {
        return this.v;
    }

    @Override // org.webrtc.ali.svideo.VideoFrame.I420Buffer
    public java.nio.ByteBuffer getDataY() {
        return this.y;
    }

    @Override // org.webrtc.ali.svideo.VideoFrame.Buffer
    public int getHeight() {
        return this.height;
    }

    @Override // org.webrtc.ali.svideo.VideoFrame.I420Buffer
    public int getStrideU() {
        return this.strideUV;
    }

    @Override // org.webrtc.ali.svideo.VideoFrame.I420Buffer
    public int getStrideV() {
        return this.strideUV;
    }

    @Override // org.webrtc.ali.svideo.VideoFrame.I420Buffer
    public int getStrideY() {
        return this.width;
    }

    @Override // org.webrtc.ali.svideo.VideoFrame.Buffer
    public int getWidth() {
        return this.width;
    }

    @Override // org.webrtc.ali.svideo.VideoFrame.Buffer
    public void release() {
    }

    @Override // org.webrtc.ali.svideo.VideoFrame.Buffer
    public void retain() {
    }

    @Override // org.webrtc.ali.svideo.VideoFrame.Buffer
    public org.webrtc.ali.svideo.VideoFrame.I420Buffer toI420() {
        return this;
    }
}
