package com.alimm.tanx.ui.image.glide.util;

/* loaded from: classes.dex */
public class ExceptionCatchingInputStream extends java.io.InputStream {
    private static final java.util.Queue<com.alimm.tanx.ui.image.glide.util.ExceptionCatchingInputStream> QUEUE = com.alimm.tanx.ui.image.glide.util.Util.createQueue(0);
    private java.io.IOException exception;
    private java.io.InputStream wrapped;

    public static void clearQueue() {
        while (true) {
            java.util.Queue<com.alimm.tanx.ui.image.glide.util.ExceptionCatchingInputStream> queue = QUEUE;
            if (queue.isEmpty()) {
                return;
            } else {
                queue.remove();
            }
        }
    }

    public static com.alimm.tanx.ui.image.glide.util.ExceptionCatchingInputStream obtain(java.io.InputStream inputStream) {
        com.alimm.tanx.ui.image.glide.util.ExceptionCatchingInputStream poll;
        java.util.Queue<com.alimm.tanx.ui.image.glide.util.ExceptionCatchingInputStream> queue = QUEUE;
        synchronized (queue) {
            poll = queue.poll();
        }
        if (poll == null) {
            poll = new com.alimm.tanx.ui.image.glide.util.ExceptionCatchingInputStream();
        }
        poll.setInputStream(inputStream);
        return poll;
    }

    @Override // java.io.InputStream
    public int available() throws java.io.IOException {
        return this.wrapped.available();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws java.io.IOException {
        this.wrapped.close();
    }

    public java.io.IOException getException() {
        return this.exception;
    }

    @Override // java.io.InputStream
    public void mark(int i) {
        this.wrapped.mark(i);
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        return this.wrapped.markSupported();
    }

    @Override // java.io.InputStream
    public int read() throws java.io.IOException {
        try {
            return this.wrapped.read();
        } catch (java.io.IOException e) {
            this.exception = e;
            return -1;
        }
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) throws java.io.IOException {
        try {
            return this.wrapped.read(bArr);
        } catch (java.io.IOException e) {
            this.exception = e;
            return -1;
        }
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws java.io.IOException {
        try {
            return this.wrapped.read(bArr, i, i2);
        } catch (java.io.IOException e) {
            this.exception = e;
            return -1;
        }
    }

    public void release() {
        this.exception = null;
        this.wrapped = null;
        java.util.Queue<com.alimm.tanx.ui.image.glide.util.ExceptionCatchingInputStream> queue = QUEUE;
        synchronized (queue) {
            queue.offer(this);
        }
    }

    @Override // java.io.InputStream
    public synchronized void reset() throws java.io.IOException {
        this.wrapped.reset();
    }

    public void setInputStream(java.io.InputStream inputStream) {
        this.wrapped = inputStream;
    }

    @Override // java.io.InputStream
    public long skip(long j) throws java.io.IOException {
        try {
            return this.wrapped.skip(j);
        } catch (java.io.IOException e) {
            this.exception = e;
            return 0L;
        }
    }
}
