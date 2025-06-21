package com.google.android.exoplayer2.video;

/* loaded from: classes22.dex */
public class VideoDecoderOutputBuffer extends com.google.android.exoplayer2.decoder.OutputBuffer {
    public static final int COLORSPACE_BT2020 = 3;
    public static final int COLORSPACE_BT601 = 1;
    public static final int COLORSPACE_BT709 = 2;
    public static final int COLORSPACE_UNKNOWN = 0;
    public int colorspace;

    @androidx.annotation.Nullable
    public java.nio.ByteBuffer data;
    public int decoderPrivate;

    @androidx.annotation.Nullable
    public com.google.android.exoplayer2.Format format;
    public int height;
    public int mode;
    private final com.google.android.exoplayer2.decoder.OutputBuffer.Owner<com.google.android.exoplayer2.video.VideoDecoderOutputBuffer> owner;

    @androidx.annotation.Nullable
    public java.nio.ByteBuffer supplementalData;
    public int width;

    @androidx.annotation.Nullable
    public java.nio.ByteBuffer[] yuvPlanes;

    @androidx.annotation.Nullable
    public int[] yuvStrides;

    public VideoDecoderOutputBuffer(com.google.android.exoplayer2.decoder.OutputBuffer.Owner<com.google.android.exoplayer2.video.VideoDecoderOutputBuffer> owner) {
        this.owner = owner;
    }

    private static boolean isSafeToMultiply(int i, int i2) {
        return i >= 0 && i2 >= 0 && (i2 <= 0 || i < Integer.MAX_VALUE / i2);
    }

    public void init(long j, int i, @androidx.annotation.Nullable java.nio.ByteBuffer byteBuffer) {
        this.timeUs = j;
        this.mode = i;
        if (byteBuffer == null || !byteBuffer.hasRemaining()) {
            this.supplementalData = null;
            return;
        }
        addFlag(268435456);
        int limit = byteBuffer.limit();
        java.nio.ByteBuffer byteBuffer2 = this.supplementalData;
        if (byteBuffer2 == null || byteBuffer2.capacity() < limit) {
            this.supplementalData = java.nio.ByteBuffer.allocate(limit);
        } else {
            this.supplementalData.clear();
        }
        this.supplementalData.put(byteBuffer);
        this.supplementalData.flip();
        byteBuffer.position(0);
    }

    public void initForPrivateFrame(int i, int i2) {
        this.width = i;
        this.height = i2;
    }

    public boolean initForYuvFrame(int i, int i2, int i3, int i4, int i5) {
        this.width = i;
        this.height = i2;
        this.colorspace = i5;
        int i6 = (int) ((i2 + 1) / 2);
        if (isSafeToMultiply(i3, i2) && isSafeToMultiply(i4, i6)) {
            int i7 = i2 * i3;
            int i8 = i6 * i4;
            int i9 = (i8 * 2) + i7;
            if (isSafeToMultiply(i8, 2) && i9 >= i7) {
                java.nio.ByteBuffer byteBuffer = this.data;
                if (byteBuffer == null || byteBuffer.capacity() < i9) {
                    this.data = java.nio.ByteBuffer.allocateDirect(i9);
                } else {
                    this.data.position(0);
                    this.data.limit(i9);
                }
                if (this.yuvPlanes == null) {
                    this.yuvPlanes = new java.nio.ByteBuffer[3];
                }
                java.nio.ByteBuffer byteBuffer2 = this.data;
                java.nio.ByteBuffer[] byteBufferArr = this.yuvPlanes;
                java.nio.ByteBuffer slice = byteBuffer2.slice();
                byteBufferArr[0] = slice;
                slice.limit(i7);
                byteBuffer2.position(i7);
                java.nio.ByteBuffer slice2 = byteBuffer2.slice();
                byteBufferArr[1] = slice2;
                slice2.limit(i8);
                byteBuffer2.position(i7 + i8);
                java.nio.ByteBuffer slice3 = byteBuffer2.slice();
                byteBufferArr[2] = slice3;
                slice3.limit(i8);
                if (this.yuvStrides == null) {
                    this.yuvStrides = new int[3];
                }
                int[] iArr = this.yuvStrides;
                iArr[0] = i3;
                iArr[1] = i4;
                iArr[2] = i4;
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.exoplayer2.decoder.OutputBuffer
    public void release() {
        this.owner.releaseOutputBuffer(this);
    }
}
