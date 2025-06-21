package okio;

/* loaded from: classes24.dex */
final class PushableTimeout extends okio.Timeout {
    private long originalDeadlineNanoTime;
    private boolean originalHasDeadline;
    private long originalTimeoutNanos;
    private okio.Timeout pushed;

    public void pop() {
        this.pushed.timeout(this.originalTimeoutNanos, java.util.concurrent.TimeUnit.NANOSECONDS);
        if (this.originalHasDeadline) {
            this.pushed.deadlineNanoTime(this.originalDeadlineNanoTime);
        } else {
            this.pushed.clearDeadline();
        }
    }

    public void push(okio.Timeout timeout) {
        this.pushed = timeout;
        boolean hasDeadline = timeout.hasDeadline();
        this.originalHasDeadline = hasDeadline;
        this.originalDeadlineNanoTime = hasDeadline ? timeout.deadlineNanoTime() : -1L;
        long timeoutNanos = timeout.timeoutNanos();
        this.originalTimeoutNanos = timeoutNanos;
        timeout.timeout(okio.Timeout.minTimeout(timeoutNanos, timeoutNanos()), java.util.concurrent.TimeUnit.NANOSECONDS);
        if (this.originalHasDeadline && hasDeadline()) {
            timeout.deadlineNanoTime(java.lang.Math.min(deadlineNanoTime(), this.originalDeadlineNanoTime));
        } else if (hasDeadline()) {
            timeout.deadlineNanoTime(deadlineNanoTime());
        }
    }
}
