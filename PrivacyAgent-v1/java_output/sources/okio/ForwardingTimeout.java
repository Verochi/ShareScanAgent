package okio;

/* loaded from: classes24.dex */
public class ForwardingTimeout extends okio.Timeout {
    private okio.Timeout delegate;

    public ForwardingTimeout(okio.Timeout timeout) {
        if (timeout == null) {
            throw new java.lang.IllegalArgumentException("delegate == null");
        }
        this.delegate = timeout;
    }

    @Override // okio.Timeout
    public okio.Timeout clearDeadline() {
        return this.delegate.clearDeadline();
    }

    @Override // okio.Timeout
    public okio.Timeout clearTimeout() {
        return this.delegate.clearTimeout();
    }

    @Override // okio.Timeout
    public long deadlineNanoTime() {
        return this.delegate.deadlineNanoTime();
    }

    @Override // okio.Timeout
    public okio.Timeout deadlineNanoTime(long j) {
        return this.delegate.deadlineNanoTime(j);
    }

    public final okio.Timeout delegate() {
        return this.delegate;
    }

    @Override // okio.Timeout
    public boolean hasDeadline() {
        return this.delegate.hasDeadline();
    }

    public final okio.ForwardingTimeout setDelegate(okio.Timeout timeout) {
        if (timeout == null) {
            throw new java.lang.IllegalArgumentException("delegate == null");
        }
        this.delegate = timeout;
        return this;
    }

    @Override // okio.Timeout
    public void throwIfReached() throws java.io.IOException {
        this.delegate.throwIfReached();
    }

    @Override // okio.Timeout
    public okio.Timeout timeout(long j, java.util.concurrent.TimeUnit timeUnit) {
        return this.delegate.timeout(j, timeUnit);
    }

    @Override // okio.Timeout
    public long timeoutNanos() {
        return this.delegate.timeoutNanos();
    }
}
