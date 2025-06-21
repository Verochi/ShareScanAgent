package com.ss.android.socialbase.downloader.segment;

/* loaded from: classes19.dex */
class BufferQueue implements com.ss.android.socialbase.downloader.segment.IBufferPool, com.ss.android.socialbase.downloader.segment.IInput, com.ss.android.socialbase.downloader.segment.IOutput {
    private static final int MIN_BUFFER_COUNT = 64;
    private static final int MIN_BUFFER_SIZE = 8192;
    private int bufferCount;
    private final int bufferSize;
    private volatile boolean closed;
    private final int maxBufferCount;
    private com.ss.android.socialbase.downloader.segment.Buffer rHead;
    private com.ss.android.socialbase.downloader.segment.Buffer rSafe;
    private com.ss.android.socialbase.downloader.segment.Buffer rTail;
    private com.ss.android.socialbase.downloader.segment.Buffer wHead;
    private com.ss.android.socialbase.downloader.segment.Buffer wTail;
    private final java.lang.Object wLock = new java.lang.Object();
    private final java.lang.Object rLock = new java.lang.Object();

    public BufferQueue(int i, int i2) {
        i = i < 64 ? 64 : i;
        i2 = i2 < 8192 ? 8192 : i2;
        this.maxBufferCount = i;
        this.bufferSize = i2;
    }

    public void close() {
        this.closed = true;
        synchronized (this.wLock) {
            this.wLock.notifyAll();
        }
        synchronized (this.rLock) {
            this.rLock.notifyAll();
        }
    }

    @Override // com.ss.android.socialbase.downloader.segment.IBufferPool
    @androidx.annotation.NonNull
    public com.ss.android.socialbase.downloader.segment.Buffer obtain() throws com.ss.android.socialbase.downloader.segment.StreamClosedException, java.lang.InterruptedException {
        synchronized (this.wLock) {
            if (this.closed) {
                throw new com.ss.android.socialbase.downloader.segment.StreamClosedException("obtain");
            }
            com.ss.android.socialbase.downloader.segment.Buffer buffer = this.wHead;
            if (buffer == null) {
                int i = this.bufferCount;
                if (i < this.maxBufferCount) {
                    this.bufferCount = i + 1;
                    return new com.ss.android.socialbase.downloader.segment.Buffer(this.bufferSize);
                }
                do {
                    this.wLock.wait();
                    if (this.closed) {
                        throw new com.ss.android.socialbase.downloader.segment.StreamClosedException("obtain");
                    }
                    buffer = this.wHead;
                } while (buffer == null);
            }
            this.wHead = buffer.next;
            if (buffer == this.wTail) {
                this.wTail = null;
            }
            buffer.next = null;
            return buffer;
        }
    }

    @Override // com.ss.android.socialbase.downloader.segment.IInput
    @androidx.annotation.NonNull
    public com.ss.android.socialbase.downloader.segment.Buffer read() throws com.ss.android.socialbase.downloader.segment.StreamClosedException, java.lang.InterruptedException {
        com.ss.android.socialbase.downloader.segment.Buffer buffer;
        com.ss.android.socialbase.downloader.segment.Buffer buffer2 = this.rSafe;
        if (buffer2 != null) {
            this.rSafe = buffer2.next;
            buffer2.next = null;
            return buffer2;
        }
        synchronized (this.rLock) {
            buffer = this.rHead;
            while (buffer == null) {
                if (this.closed) {
                    throw new com.ss.android.socialbase.downloader.segment.StreamClosedException("read");
                }
                this.rLock.wait();
                buffer = this.rHead;
            }
            this.rSafe = buffer.next;
            this.rTail = null;
            this.rHead = null;
            buffer.next = null;
        }
        return buffer;
    }

    @Override // com.ss.android.socialbase.downloader.segment.IBufferPool
    public void recycle(@androidx.annotation.NonNull com.ss.android.socialbase.downloader.segment.Buffer buffer) {
        synchronized (this.wLock) {
            com.ss.android.socialbase.downloader.segment.Buffer buffer2 = this.wTail;
            if (buffer2 == null) {
                this.wTail = buffer;
                this.wHead = buffer;
            } else {
                buffer2.next = buffer;
                this.wTail = buffer;
            }
            this.wLock.notify();
        }
    }

    @Override // com.ss.android.socialbase.downloader.segment.IOutput
    public void write(@androidx.annotation.NonNull com.ss.android.socialbase.downloader.segment.Buffer buffer) {
        synchronized (this.rLock) {
            com.ss.android.socialbase.downloader.segment.Buffer buffer2 = this.rTail;
            if (buffer2 == null) {
                this.rTail = buffer;
                this.rHead = buffer;
                this.rLock.notify();
            } else {
                buffer2.next = buffer;
                this.rTail = buffer;
            }
        }
    }
}
