package com.alimm.tanx.ui.image.glide.util;

/* loaded from: classes.dex */
public final class ByteArrayPool {
    private static final com.alimm.tanx.ui.image.glide.util.ByteArrayPool BYTE_ARRAY_POOL = new com.alimm.tanx.ui.image.glide.util.ByteArrayPool();
    private static final int MAX_BYTE_ARRAY_COUNT = 32;
    private static final int MAX_SIZE = 2146304;
    private static final java.lang.String TAG = "ByteArrayPool";
    private static final int TEMP_BYTES_SIZE = 65536;
    private final java.util.Queue<byte[]> tempQueue = com.alimm.tanx.ui.image.glide.util.Util.createQueue(0);

    private ByteArrayPool() {
    }

    public static com.alimm.tanx.ui.image.glide.util.ByteArrayPool get() {
        return BYTE_ARRAY_POOL;
    }

    public void clear() {
        synchronized (this.tempQueue) {
            this.tempQueue.clear();
        }
    }

    public byte[] getBytes() {
        byte[] poll;
        synchronized (this.tempQueue) {
            poll = this.tempQueue.poll();
        }
        return poll == null ? new byte[65536] : poll;
    }

    public boolean releaseBytes(byte[] bArr) {
        boolean z = false;
        if (bArr.length != 65536) {
            return false;
        }
        synchronized (this.tempQueue) {
            if (this.tempQueue.size() < 32) {
                this.tempQueue.offer(bArr);
                z = true;
            }
        }
        return z;
    }
}
