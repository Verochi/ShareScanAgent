package org.webrtc.ali.svideo;

/* loaded from: classes26.dex */
public class VideoRenderer {
    long nativeVideoRenderer;

    public interface Callbacks {
        void renderFrame(org.webrtc.ali.svideo.VideoRenderer.I420Frame i420Frame);
    }

    public static class I420Frame {
        public final int height;
        private long nativeFramePointer;
        public int rotationDegree;
        public final float[] samplingMatrix;
        public int textureId;
        public final int width;
        public final boolean yuvFrame;
        public java.nio.ByteBuffer[] yuvPlanes;
        public final int[] yuvStrides;

        public I420Frame(int i, int i2, int i3, int i4, float[] fArr, long j) {
            this.width = i;
            this.height = i2;
            this.yuvStrides = null;
            this.yuvPlanes = null;
            this.samplingMatrix = fArr;
            this.textureId = i4;
            this.yuvFrame = false;
            this.rotationDegree = i3;
            this.nativeFramePointer = j;
            if (i3 % 90 == 0) {
                return;
            }
            throw new java.lang.IllegalArgumentException("Rotation degree not multiple of 90: " + i3);
        }

        public I420Frame(int i, int i2, int i3, float[] fArr, org.webrtc.ali.svideo.VideoFrame.Buffer buffer, long j) {
            this.width = i;
            this.height = i2;
            this.rotationDegree = i3;
            if (i3 % 90 != 0) {
                throw new java.lang.IllegalArgumentException("Rotation degree not multiple of 90: " + i3);
            }
            if (buffer instanceof org.webrtc.ali.svideo.VideoFrame.TextureBuffer) {
                this.yuvFrame = false;
                this.textureId = ((org.webrtc.ali.svideo.VideoFrame.TextureBuffer) buffer).getTextureId();
                this.samplingMatrix = fArr;
                this.yuvStrides = null;
                this.yuvPlanes = null;
            } else {
                org.webrtc.ali.svideo.VideoFrame.I420Buffer i420 = buffer.toI420();
                this.yuvFrame = true;
                this.yuvStrides = new int[]{i420.getStrideY(), i420.getStrideU(), i420.getStrideV()};
                this.yuvPlanes = new java.nio.ByteBuffer[]{i420.getDataY(), i420.getDataU(), i420.getDataV()};
                this.samplingMatrix = org.webrtc.ali.svideo.RendererCommon.multiplyMatrices(fArr, org.webrtc.ali.svideo.RendererCommon.verticalFlipMatrix());
                this.textureId = 0;
            }
            this.nativeFramePointer = j;
        }

        public I420Frame(int i, int i2, int i3, int[] iArr, java.nio.ByteBuffer[] byteBufferArr, long j) {
            this.width = i;
            this.height = i2;
            this.yuvStrides = iArr;
            this.yuvPlanes = byteBufferArr;
            this.yuvFrame = true;
            this.rotationDegree = i3;
            this.nativeFramePointer = j;
            if (i3 % 90 == 0) {
                this.samplingMatrix = org.webrtc.ali.svideo.RendererCommon.verticalFlipMatrix();
                return;
            }
            throw new java.lang.IllegalArgumentException("Rotation degree not multiple of 90: " + i3);
        }

        public int rotatedHeight() {
            return this.rotationDegree % 180 == 0 ? this.height : this.width;
        }

        public int rotatedWidth() {
            return this.rotationDegree % 180 == 0 ? this.width : this.height;
        }

        public java.lang.String toString() {
            return this.width + "x" + this.height + com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR + this.yuvStrides[0] + com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR + this.yuvStrides[1] + com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR + this.yuvStrides[2];
        }
    }

    public VideoRenderer(org.webrtc.ali.svideo.VideoRenderer.Callbacks callbacks) {
        this.nativeVideoRenderer = nativeWrapVideoRenderer(callbacks);
    }

    private static native void freeWrappedVideoRenderer(long j);

    public static native void nativeCopyPlane(java.nio.ByteBuffer byteBuffer, int i, int i2, int i3, java.nio.ByteBuffer byteBuffer2, int i4);

    private static native long nativeWrapVideoRenderer(org.webrtc.ali.svideo.VideoRenderer.Callbacks callbacks);

    private static native void releaseNativeFrame(long j);

    public static void renderFrameDone(org.webrtc.ali.svideo.VideoRenderer.I420Frame i420Frame) {
        i420Frame.yuvPlanes = null;
        i420Frame.textureId = 0;
        if (i420Frame.nativeFramePointer != 0) {
            releaseNativeFrame(i420Frame.nativeFramePointer);
            i420Frame.nativeFramePointer = 0L;
        }
    }

    public void dispose() {
        long j = this.nativeVideoRenderer;
        if (j == 0) {
            return;
        }
        freeWrappedVideoRenderer(j);
        this.nativeVideoRenderer = 0L;
    }
}
