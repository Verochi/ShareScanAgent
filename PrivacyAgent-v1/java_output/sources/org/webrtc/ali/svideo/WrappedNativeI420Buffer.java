package org.webrtc.ali.svideo;

/* loaded from: classes26.dex */
class WrappedNativeI420Buffer implements org.webrtc.ali.svideo.VideoFrame.I420Buffer {
    private final java.nio.ByteBuffer dataU;
    private final java.nio.ByteBuffer dataV;
    private final java.nio.ByteBuffer dataY;
    private final int height;
    private final long nativeBuffer;
    private final int strideU;
    private final int strideV;
    private final int strideY;
    private final int width;

    public WrappedNativeI420Buffer(int i, int i2, java.nio.ByteBuffer byteBuffer, int i3, java.nio.ByteBuffer byteBuffer2, int i4, java.nio.ByteBuffer byteBuffer3, int i5, long j) {
        this.width = i;
        this.height = i2;
        this.dataY = byteBuffer;
        this.strideY = i3;
        this.dataU = byteBuffer2;
        this.strideU = i4;
        this.dataV = byteBuffer3;
        this.strideV = i5;
        this.nativeBuffer = j;
    }

    private static native long nativeAddRef(long j);

    private static native long nativeRelease(long j);

    @Override // org.webrtc.ali.svideo.VideoFrame.I420Buffer
    public java.nio.ByteBuffer getDataU() {
        return this.dataU;
    }

    @Override // org.webrtc.ali.svideo.VideoFrame.I420Buffer
    public java.nio.ByteBuffer getDataV() {
        return this.dataV;
    }

    @Override // org.webrtc.ali.svideo.VideoFrame.I420Buffer
    public java.nio.ByteBuffer getDataY() {
        return this.dataY;
    }

    @Override // org.webrtc.ali.svideo.VideoFrame.Buffer
    public int getHeight() {
        return this.height;
    }

    @Override // org.webrtc.ali.svideo.VideoFrame.I420Buffer
    public int getStrideU() {
        return this.strideU;
    }

    @Override // org.webrtc.ali.svideo.VideoFrame.I420Buffer
    public int getStrideV() {
        return this.strideV;
    }

    @Override // org.webrtc.ali.svideo.VideoFrame.I420Buffer
    public int getStrideY() {
        return this.strideY;
    }

    @Override // org.webrtc.ali.svideo.VideoFrame.Buffer
    public int getWidth() {
        return this.width;
    }

    @Override // org.webrtc.ali.svideo.VideoFrame.Buffer
    public void release() {
        nativeRelease(this.nativeBuffer);
    }

    @Override // org.webrtc.ali.svideo.VideoFrame.Buffer
    public void retain() {
        nativeAddRef(this.nativeBuffer);
    }

    @Override // org.webrtc.ali.svideo.VideoFrame.Buffer
    public org.webrtc.ali.svideo.VideoFrame.I420Buffer toI420() {
        return this;
    }
}
