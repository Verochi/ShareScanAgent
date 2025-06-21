package okio;

/* loaded from: classes24.dex */
public class Timeout {
    public static final okio.Timeout NONE = new okio.Timeout.AnonymousClass1();
    private long deadlineNanoTime;
    private boolean hasDeadline;
    private long timeoutNanos;

    /* renamed from: okio.Timeout$1, reason: invalid class name */
    public class AnonymousClass1 extends okio.Timeout {
        @Override // okio.Timeout
        public okio.Timeout deadlineNanoTime(long j) {
            return this;
        }

        @Override // okio.Timeout
        public void throwIfReached() throws java.io.IOException {
        }

        @Override // okio.Timeout
        public okio.Timeout timeout(long j, java.util.concurrent.TimeUnit timeUnit) {
            return this;
        }
    }

    public static long minTimeout(long j, long j2) {
        return j == 0 ? j2 : (j2 != 0 && j >= j2) ? j2 : j;
    }

    public okio.Timeout clearDeadline() {
        this.hasDeadline = false;
        return this;
    }

    public okio.Timeout clearTimeout() {
        this.timeoutNanos = 0L;
        return this;
    }

    public final okio.Timeout deadline(long j, java.util.concurrent.TimeUnit timeUnit) {
        if (j > 0) {
            if (timeUnit != null) {
                return deadlineNanoTime(java.lang.System.nanoTime() + timeUnit.toNanos(j));
            }
            throw new java.lang.IllegalArgumentException("unit == null");
        }
        throw new java.lang.IllegalArgumentException("duration <= 0: " + j);
    }

    public long deadlineNanoTime() {
        if (this.hasDeadline) {
            return this.deadlineNanoTime;
        }
        throw new java.lang.IllegalStateException("No deadline");
    }

    public okio.Timeout deadlineNanoTime(long j) {
        this.hasDeadline = true;
        this.deadlineNanoTime = j;
        return this;
    }

    public boolean hasDeadline() {
        return this.hasDeadline;
    }

    public void throwIfReached() throws java.io.IOException {
        if (java.lang.Thread.interrupted()) {
            java.lang.Thread.currentThread().interrupt();
            throw new java.io.InterruptedIOException("interrupted");
        }
        if (this.hasDeadline && this.deadlineNanoTime - java.lang.System.nanoTime() <= 0) {
            throw new java.io.InterruptedIOException("deadline reached");
        }
    }

    public okio.Timeout timeout(long j, java.util.concurrent.TimeUnit timeUnit) {
        if (j >= 0) {
            if (timeUnit == null) {
                throw new java.lang.IllegalArgumentException("unit == null");
            }
            this.timeoutNanos = timeUnit.toNanos(j);
            return this;
        }
        throw new java.lang.IllegalArgumentException("timeout < 0: " + j);
    }

    public long timeoutNanos() {
        return this.timeoutNanos;
    }

    public final void waitUntilNotified(java.lang.Object obj) throws java.io.InterruptedIOException {
        try {
            boolean hasDeadline = hasDeadline();
            long timeoutNanos = timeoutNanos();
            long j = 0;
            if (!hasDeadline && timeoutNanos == 0) {
                obj.wait();
                return;
            }
            long nanoTime = java.lang.System.nanoTime();
            if (hasDeadline && timeoutNanos != 0) {
                timeoutNanos = java.lang.Math.min(timeoutNanos, deadlineNanoTime() - nanoTime);
            } else if (hasDeadline) {
                timeoutNanos = deadlineNanoTime() - nanoTime;
            }
            if (timeoutNanos > 0) {
                long j2 = timeoutNanos / 1000000;
                java.lang.Long.signum(j2);
                obj.wait(j2, (int) (timeoutNanos - (1000000 * j2)));
                j = java.lang.System.nanoTime() - nanoTime;
            }
            if (j >= timeoutNanos) {
                throw new java.io.InterruptedIOException("timeout");
            }
        } catch (java.lang.InterruptedException unused) {
            java.lang.Thread.currentThread().interrupt();
            throw new java.io.InterruptedIOException("interrupted");
        }
    }
}
