package com.otaliastudios.cameraview.frame;

/* loaded from: classes19.dex */
public class ByteBufferFrameManager extends com.otaliastudios.cameraview.frame.FrameManager<byte[]> {
    public java.util.concurrent.LinkedBlockingQueue<byte[]> h;
    public com.otaliastudios.cameraview.frame.ByteBufferFrameManager.BufferCallback i;
    public final int j;

    public interface BufferCallback {
        void onBufferAvailable(@androidx.annotation.NonNull byte[] bArr);
    }

    public ByteBufferFrameManager(int i, @androidx.annotation.Nullable com.otaliastudios.cameraview.frame.ByteBufferFrameManager.BufferCallback bufferCallback) {
        super(i, byte[].class);
        if (bufferCallback != null) {
            this.i = bufferCallback;
            this.j = 0;
        } else {
            this.h = new java.util.concurrent.LinkedBlockingQueue<>(i);
            this.j = 1;
        }
    }

    @androidx.annotation.Nullable
    public byte[] getBuffer() {
        if (this.j == 1) {
            return this.h.poll();
        }
        throw new java.lang.IllegalStateException("Can't call getBuffer() when not in BUFFER_MODE_ENQUEUE.");
    }

    public void onBufferUnused(@androidx.annotation.NonNull byte[] bArr) {
        if (this.j != 1) {
            throw new java.lang.IllegalStateException("Can't call onBufferUnused() when not in BUFFER_MODE_ENQUEUE.");
        }
        if (isSetUp()) {
            this.h.offer(bArr);
        } else {
            com.otaliastudios.cameraview.frame.FrameManager.LOG.w("onBufferUnused: buffer was returned but we're not set up anymore.");
        }
    }

    @Override // com.otaliastudios.cameraview.frame.FrameManager
    @androidx.annotation.NonNull
    public byte[] onCloneFrameData(@androidx.annotation.NonNull byte[] bArr) {
        byte[] bArr2 = new byte[bArr.length];
        java.lang.System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        return bArr2;
    }

    @Override // com.otaliastudios.cameraview.frame.FrameManager
    public void onFrameDataReleased(@androidx.annotation.NonNull byte[] bArr, boolean z) {
        if (z && bArr.length == getFrameBytes()) {
            if (this.j == 0) {
                this.i.onBufferAvailable(bArr);
            } else {
                this.h.offer(bArr);
            }
        }
    }

    @Override // com.otaliastudios.cameraview.frame.FrameManager
    public void release() {
        super.release();
        if (this.j == 1) {
            this.h.clear();
        }
    }

    @Override // com.otaliastudios.cameraview.frame.FrameManager
    public void setUp(int i, @androidx.annotation.NonNull com.otaliastudios.cameraview.size.Size size, @androidx.annotation.NonNull com.otaliastudios.cameraview.engine.offset.Angles angles) {
        super.setUp(i, size, angles);
        int frameBytes = getFrameBytes();
        for (int i2 = 0; i2 < getPoolSize(); i2++) {
            if (this.j == 0) {
                this.i.onBufferAvailable(new byte[frameBytes]);
            } else {
                this.h.offer(new byte[frameBytes]);
            }
        }
    }
}
