package org.webrtc.ali.svideo;

/* loaded from: classes26.dex */
public class VideoFrame {
    private final org.webrtc.ali.svideo.VideoFrame.Buffer buffer;
    private final int rotation;
    private final long timestampNs;
    private final android.graphics.Matrix transformMatrix;

    public interface Buffer {
        int getHeight();

        int getWidth();

        void release();

        void retain();

        org.webrtc.ali.svideo.VideoFrame.I420Buffer toI420();
    }

    public interface I420Buffer extends org.webrtc.ali.svideo.VideoFrame.Buffer {
        java.nio.ByteBuffer getDataU();

        java.nio.ByteBuffer getDataV();

        java.nio.ByteBuffer getDataY();

        int getStrideU();

        int getStrideV();

        int getStrideY();
    }

    public interface TextureBuffer extends org.webrtc.ali.svideo.VideoFrame.Buffer {

        public enum Type {
            OES,
            RGB
        }

        int getTextureId();

        org.webrtc.ali.svideo.VideoFrame.TextureBuffer.Type getType();
    }

    public VideoFrame(org.webrtc.ali.svideo.VideoFrame.Buffer buffer, int i, long j, android.graphics.Matrix matrix) {
        if (buffer == null) {
            throw new java.lang.IllegalArgumentException("buffer not allowed to be null");
        }
        if (matrix == null) {
            throw new java.lang.IllegalArgumentException("transformMatrix not allowed to be null");
        }
        this.buffer = buffer;
        this.rotation = i;
        this.timestampNs = j;
        this.transformMatrix = matrix;
    }

    public org.webrtc.ali.svideo.VideoFrame.Buffer getBuffer() {
        return this.buffer;
    }

    public int getHeight() {
        return this.buffer.getHeight();
    }

    public int getRotation() {
        return this.rotation;
    }

    public long getTimestampNs() {
        return this.timestampNs;
    }

    public android.graphics.Matrix getTransformMatrix() {
        return this.transformMatrix;
    }

    public int getWidth() {
        return this.buffer.getWidth();
    }

    public void release() {
        this.buffer.release();
    }

    public void retain() {
        this.buffer.retain();
    }
}
