package okio;

/* loaded from: classes24.dex */
public class AsyncTimeout extends okio.Timeout {
    private static final long IDLE_TIMEOUT_MILLIS;
    private static final long IDLE_TIMEOUT_NANOS;
    private static final int TIMEOUT_WRITE_SIZE = 65536;

    @javax.annotation.Nullable
    static okio.AsyncTimeout head;
    private boolean inQueue;

    @javax.annotation.Nullable
    private okio.AsyncTimeout next;
    private long timeoutAt;

    /* renamed from: okio.AsyncTimeout$1, reason: invalid class name */
    public class AnonymousClass1 implements okio.Sink {
        final /* synthetic */ okio.Sink val$sink;

        public AnonymousClass1(okio.Sink sink) {
            this.val$sink = sink;
        }

        @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws java.io.IOException {
            okio.AsyncTimeout.this.enter();
            try {
                try {
                    this.val$sink.close();
                    okio.AsyncTimeout.this.exit(true);
                } catch (java.io.IOException e) {
                    throw okio.AsyncTimeout.this.exit(e);
                }
            } catch (java.lang.Throwable th) {
                okio.AsyncTimeout.this.exit(false);
                throw th;
            }
        }

        @Override // okio.Sink, java.io.Flushable
        public void flush() throws java.io.IOException {
            okio.AsyncTimeout.this.enter();
            try {
                try {
                    this.val$sink.flush();
                    okio.AsyncTimeout.this.exit(true);
                } catch (java.io.IOException e) {
                    throw okio.AsyncTimeout.this.exit(e);
                }
            } catch (java.lang.Throwable th) {
                okio.AsyncTimeout.this.exit(false);
                throw th;
            }
        }

        @Override // okio.Sink
        public okio.Timeout timeout() {
            return okio.AsyncTimeout.this;
        }

        public java.lang.String toString() {
            return "AsyncTimeout.sink(" + this.val$sink + ")";
        }

        @Override // okio.Sink
        public void write(okio.Buffer buffer, long j) throws java.io.IOException {
            okio.Util.checkOffsetAndCount(buffer.size, 0L, j);
            while (true) {
                long j2 = 0;
                if (j <= 0) {
                    return;
                }
                okio.Segment segment = buffer.head;
                while (true) {
                    if (j2 >= 65536) {
                        break;
                    }
                    j2 += segment.limit - segment.pos;
                    if (j2 >= j) {
                        j2 = j;
                        break;
                    }
                    segment = segment.next;
                }
                okio.AsyncTimeout.this.enter();
                try {
                    try {
                        this.val$sink.write(buffer, j2);
                        j -= j2;
                        okio.AsyncTimeout.this.exit(true);
                    } catch (java.io.IOException e) {
                        throw okio.AsyncTimeout.this.exit(e);
                    }
                } catch (java.lang.Throwable th) {
                    okio.AsyncTimeout.this.exit(false);
                    throw th;
                }
            }
        }
    }

    /* renamed from: okio.AsyncTimeout$2, reason: invalid class name */
    public class AnonymousClass2 implements okio.Source {
        final /* synthetic */ okio.Source val$source;

        public AnonymousClass2(okio.Source source) {
            this.val$source = source;
        }

        @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws java.io.IOException {
            okio.AsyncTimeout.this.enter();
            try {
                try {
                    this.val$source.close();
                    okio.AsyncTimeout.this.exit(true);
                } catch (java.io.IOException e) {
                    throw okio.AsyncTimeout.this.exit(e);
                }
            } catch (java.lang.Throwable th) {
                okio.AsyncTimeout.this.exit(false);
                throw th;
            }
        }

        @Override // okio.Source
        public long read(okio.Buffer buffer, long j) throws java.io.IOException {
            okio.AsyncTimeout.this.enter();
            try {
                try {
                    long read = this.val$source.read(buffer, j);
                    okio.AsyncTimeout.this.exit(true);
                    return read;
                } catch (java.io.IOException e) {
                    throw okio.AsyncTimeout.this.exit(e);
                }
            } catch (java.lang.Throwable th) {
                okio.AsyncTimeout.this.exit(false);
                throw th;
            }
        }

        @Override // okio.Source
        public okio.Timeout timeout() {
            return okio.AsyncTimeout.this;
        }

        public java.lang.String toString() {
            return "AsyncTimeout.source(" + this.val$source + ")";
        }
    }

    public static final class Watchdog extends java.lang.Thread {
        public Watchdog() {
            super("Okio Watchdog");
            setDaemon(true);
        }

        /* JADX WARN: Code restructure failed: missing block: B:19:0x0015, code lost:
        
            r1.timedOut();
         */
        @Override // java.lang.Thread, java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void run() {
            while (true) {
                synchronized (okio.AsyncTimeout.class) {
                    okio.AsyncTimeout awaitTimeout = okio.AsyncTimeout.awaitTimeout();
                    if (awaitTimeout != null) {
                        if (awaitTimeout == okio.AsyncTimeout.head) {
                            okio.AsyncTimeout.head = null;
                            return;
                        }
                    }
                }
            }
        }
    }

    static {
        long millis = java.util.concurrent.TimeUnit.SECONDS.toMillis(60L);
        IDLE_TIMEOUT_MILLIS = millis;
        IDLE_TIMEOUT_NANOS = java.util.concurrent.TimeUnit.MILLISECONDS.toNanos(millis);
    }

    @javax.annotation.Nullable
    public static okio.AsyncTimeout awaitTimeout() throws java.lang.InterruptedException {
        okio.AsyncTimeout asyncTimeout = head.next;
        if (asyncTimeout == null) {
            long nanoTime = java.lang.System.nanoTime();
            okio.AsyncTimeout.class.wait(IDLE_TIMEOUT_MILLIS);
            if (head.next != null || java.lang.System.nanoTime() - nanoTime < IDLE_TIMEOUT_NANOS) {
                return null;
            }
            return head;
        }
        long remainingNanos = asyncTimeout.remainingNanos(java.lang.System.nanoTime());
        if (remainingNanos > 0) {
            long j = remainingNanos / 1000000;
            okio.AsyncTimeout.class.wait(j, (int) (remainingNanos - (1000000 * j)));
            return null;
        }
        head.next = asyncTimeout.next;
        asyncTimeout.next = null;
        return asyncTimeout;
    }

    private static synchronized boolean cancelScheduledTimeout(okio.AsyncTimeout asyncTimeout) {
        synchronized (okio.AsyncTimeout.class) {
            okio.AsyncTimeout asyncTimeout2 = head;
            while (asyncTimeout2 != null) {
                okio.AsyncTimeout asyncTimeout3 = asyncTimeout2.next;
                if (asyncTimeout3 == asyncTimeout) {
                    asyncTimeout2.next = asyncTimeout.next;
                    asyncTimeout.next = null;
                    return false;
                }
                asyncTimeout2 = asyncTimeout3;
            }
            return true;
        }
    }

    private long remainingNanos(long j) {
        return this.timeoutAt - j;
    }

    private static synchronized void scheduleTimeout(okio.AsyncTimeout asyncTimeout, long j, boolean z) {
        synchronized (okio.AsyncTimeout.class) {
            if (head == null) {
                head = new okio.AsyncTimeout();
                new okio.AsyncTimeout.Watchdog().start();
            }
            long nanoTime = java.lang.System.nanoTime();
            if (j != 0 && z) {
                asyncTimeout.timeoutAt = java.lang.Math.min(j, asyncTimeout.deadlineNanoTime() - nanoTime) + nanoTime;
            } else if (j != 0) {
                asyncTimeout.timeoutAt = j + nanoTime;
            } else {
                if (!z) {
                    throw new java.lang.AssertionError();
                }
                asyncTimeout.timeoutAt = asyncTimeout.deadlineNanoTime();
            }
            long remainingNanos = asyncTimeout.remainingNanos(nanoTime);
            okio.AsyncTimeout asyncTimeout2 = head;
            while (true) {
                okio.AsyncTimeout asyncTimeout3 = asyncTimeout2.next;
                if (asyncTimeout3 == null || remainingNanos < asyncTimeout3.remainingNanos(nanoTime)) {
                    break;
                } else {
                    asyncTimeout2 = asyncTimeout2.next;
                }
            }
            asyncTimeout.next = asyncTimeout2.next;
            asyncTimeout2.next = asyncTimeout;
            if (asyncTimeout2 == head) {
                okio.AsyncTimeout.class.notify();
            }
        }
    }

    public final void enter() {
        if (this.inQueue) {
            throw new java.lang.IllegalStateException("Unbalanced enter/exit");
        }
        long timeoutNanos = timeoutNanos();
        boolean hasDeadline = hasDeadline();
        if (timeoutNanos != 0 || hasDeadline) {
            this.inQueue = true;
            scheduleTimeout(this, timeoutNanos, hasDeadline);
        }
    }

    public final java.io.IOException exit(java.io.IOException iOException) throws java.io.IOException {
        return !exit() ? iOException : newTimeoutException(iOException);
    }

    public final void exit(boolean z) throws java.io.IOException {
        if (exit() && z) {
            throw newTimeoutException(null);
        }
    }

    public final boolean exit() {
        if (!this.inQueue) {
            return false;
        }
        this.inQueue = false;
        return cancelScheduledTimeout(this);
    }

    public java.io.IOException newTimeoutException(@javax.annotation.Nullable java.io.IOException iOException) {
        java.io.InterruptedIOException interruptedIOException = new java.io.InterruptedIOException("timeout");
        if (iOException != null) {
            interruptedIOException.initCause(iOException);
        }
        return interruptedIOException;
    }

    public final okio.Sink sink(okio.Sink sink) {
        return new okio.AsyncTimeout.AnonymousClass1(sink);
    }

    public final okio.Source source(okio.Source source) {
        return new okio.AsyncTimeout.AnonymousClass2(source);
    }

    public void timedOut() {
    }
}
