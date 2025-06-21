package com.ss.android.socialbase.downloader.reader;

/* loaded from: classes19.dex */
public class AsyncStreamReader implements com.ss.android.socialbase.downloader.reader.IStreamReader {
    private static final java.lang.String TAG = "AsyncStreamReader";
    private int bufferCount;
    private final int bufferSize;
    private volatile boolean closed;
    private final java.io.InputStream inputStream;
    private final int maxBufferCount;
    private volatile java.util.concurrent.Future rFuture;
    private com.ss.android.socialbase.downloader.segment.Buffer rHead;
    private com.ss.android.socialbase.downloader.segment.Buffer rSafe;
    private com.ss.android.socialbase.downloader.segment.Buffer rTail;
    private volatile boolean terminated;
    private volatile java.lang.Throwable throwable;
    private com.ss.android.socialbase.downloader.segment.Buffer wHead;
    private com.ss.android.socialbase.downloader.segment.Buffer wSafe;
    private com.ss.android.socialbase.downloader.segment.Buffer wTail;
    private final java.lang.Object rLock = new java.lang.Object();
    private final java.lang.Object wLock = new java.lang.Object();
    private final java.lang.Runnable rRunnable = new com.ss.android.socialbase.downloader.reader.AsyncStreamReader.AnonymousClass1();

    /* renamed from: com.ss.android.socialbase.downloader.reader.AsyncStreamReader$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {
        public AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public void run() {
            com.ss.android.socialbase.downloader.segment.Buffer dequeueReadBuffer;
            android.os.Process.setThreadPriority(10);
            do {
                try {
                    dequeueReadBuffer = com.ss.android.socialbase.downloader.reader.AsyncStreamReader.this.dequeueReadBuffer();
                    dequeueReadBuffer.size = com.ss.android.socialbase.downloader.reader.AsyncStreamReader.this.inputStream.read(dequeueReadBuffer.data);
                    com.ss.android.socialbase.downloader.reader.AsyncStreamReader.this.enqueueWriteBuffer(dequeueReadBuffer);
                } catch (java.lang.Throwable th) {
                    try {
                        com.ss.android.socialbase.downloader.reader.AsyncStreamReader.this.throwable = th;
                        th.printStackTrace();
                        synchronized (com.ss.android.socialbase.downloader.reader.AsyncStreamReader.this.wLock) {
                            com.ss.android.socialbase.downloader.reader.AsyncStreamReader.this.terminated = true;
                            com.ss.android.socialbase.downloader.reader.AsyncStreamReader.this.wLock.notify();
                            com.ss.android.socialbase.downloader.utils.DownloadUtils.safeClose(com.ss.android.socialbase.downloader.reader.AsyncStreamReader.this.inputStream);
                            return;
                        }
                    } catch (java.lang.Throwable th2) {
                        synchronized (com.ss.android.socialbase.downloader.reader.AsyncStreamReader.this.wLock) {
                            com.ss.android.socialbase.downloader.reader.AsyncStreamReader.this.terminated = true;
                            com.ss.android.socialbase.downloader.reader.AsyncStreamReader.this.wLock.notify();
                            com.ss.android.socialbase.downloader.utils.DownloadUtils.safeClose(com.ss.android.socialbase.downloader.reader.AsyncStreamReader.this.inputStream);
                            throw th2;
                        }
                    }
                }
            } while (dequeueReadBuffer.size != -1);
            synchronized (com.ss.android.socialbase.downloader.reader.AsyncStreamReader.this.wLock) {
                com.ss.android.socialbase.downloader.reader.AsyncStreamReader.this.terminated = true;
                com.ss.android.socialbase.downloader.reader.AsyncStreamReader.this.wLock.notify();
            }
            com.ss.android.socialbase.downloader.utils.DownloadUtils.safeClose(com.ss.android.socialbase.downloader.reader.AsyncStreamReader.this.inputStream);
        }
    }

    public AsyncStreamReader(java.io.InputStream inputStream, int i, int i2) throws java.lang.Throwable {
        this.inputStream = inputStream;
        this.bufferSize = i;
        if (i2 <= 0) {
            i2 = 1;
        } else if (i2 > 64) {
            i2 = 64;
        }
        this.maxBufferCount = i2;
        start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.ss.android.socialbase.downloader.segment.Buffer dequeueReadBuffer() throws com.ss.android.socialbase.downloader.segment.StreamClosedException, java.lang.InterruptedException {
        int i;
        com.ss.android.socialbase.downloader.segment.Buffer buffer = this.rSafe;
        if (buffer != null) {
            if (this.closed) {
                throw new com.ss.android.socialbase.downloader.segment.StreamClosedException("");
            }
            this.rSafe = buffer.next;
            buffer.next = null;
            return buffer;
        }
        synchronized (this.rLock) {
            if (this.closed) {
                throw new com.ss.android.socialbase.downloader.segment.StreamClosedException("");
            }
            com.ss.android.socialbase.downloader.segment.Buffer buffer2 = this.rHead;
            if (buffer2 == null && (i = this.bufferCount) < this.maxBufferCount) {
                this.bufferCount = i + 1;
                return new com.ss.android.socialbase.downloader.segment.Buffer(this.bufferSize);
            }
            while (buffer2 == null) {
                this.rLock.wait();
                if (this.closed) {
                    throw new com.ss.android.socialbase.downloader.segment.StreamClosedException("");
                }
                buffer2 = this.rHead;
            }
            this.rSafe = buffer2.next;
            this.rTail = null;
            this.rHead = null;
            buffer2.next = null;
            return buffer2;
        }
    }

    private com.ss.android.socialbase.downloader.segment.Buffer dequeueWriteBuffer() throws com.ss.android.socialbase.downloader.exception.BaseException, java.lang.InterruptedException {
        com.ss.android.socialbase.downloader.segment.Buffer buffer;
        com.ss.android.socialbase.downloader.segment.Buffer buffer2 = this.wSafe;
        if (buffer2 != null) {
            this.wSafe = buffer2.next;
            buffer2.next = null;
            return buffer2;
        }
        synchronized (this.wLock) {
            buffer = this.wHead;
            if (buffer == null) {
                do {
                    if (this.terminated) {
                        handleTerminated();
                    }
                    this.wLock.wait();
                    buffer = this.wHead;
                } while (buffer == null);
            }
            this.wSafe = buffer.next;
            this.wTail = null;
            this.wHead = null;
            buffer.next = null;
        }
        return buffer;
    }

    private void enqueueReadBuffer(com.ss.android.socialbase.downloader.segment.Buffer buffer) {
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

    /* JADX INFO: Access modifiers changed from: private */
    public void enqueueWriteBuffer(com.ss.android.socialbase.downloader.segment.Buffer buffer) {
        synchronized (this.wLock) {
            com.ss.android.socialbase.downloader.segment.Buffer buffer2 = this.wTail;
            if (buffer2 == null) {
                this.wTail = buffer;
                this.wHead = buffer;
                this.wLock.notify();
            } else {
                buffer2.next = buffer;
                this.wTail = buffer;
            }
        }
    }

    private void handleTerminated() throws com.ss.android.socialbase.downloader.exception.BaseException {
        java.lang.Throwable th = this.throwable;
        if (th != null) {
            if (th instanceof com.ss.android.socialbase.downloader.segment.StreamClosedException) {
                throw new com.ss.android.socialbase.downloader.exception.BaseException(com.ss.android.socialbase.downloader.constants.DownloadErrorCode.ERROR_STREAM_CLOSED, "async reader closed!");
            }
            com.ss.android.socialbase.downloader.utils.DownloadUtils.parseException(th, "async_read");
        }
        throw new com.ss.android.socialbase.downloader.exception.BaseException(com.ss.android.socialbase.downloader.constants.DownloadErrorCode.ERROR_STREAM_TERMINATED, "async reader terminated!");
    }

    private void start() throws java.lang.Throwable {
        this.rFuture = com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.getChunkDownloadThreadExecutorService().submit(this.rRunnable);
    }

    @Override // com.ss.android.socialbase.downloader.reader.IStreamReader
    public void close() {
        synchronized (this.rLock) {
            this.closed = true;
            this.rLock.notify();
        }
        java.util.concurrent.Future future = this.rFuture;
        if (future != null) {
            try {
                future.cancel(true);
            } catch (java.lang.Throwable unused) {
            }
            this.rFuture = null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.reader.IStreamReader
    public com.ss.android.socialbase.downloader.segment.Buffer read() throws com.ss.android.socialbase.downloader.exception.BaseException, java.lang.InterruptedException {
        return dequeueWriteBuffer();
    }

    @Override // com.ss.android.socialbase.downloader.reader.IStreamReader
    public void recycle(com.ss.android.socialbase.downloader.segment.Buffer buffer) {
        enqueueReadBuffer(buffer);
    }
}
