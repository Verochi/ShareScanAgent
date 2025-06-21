package io.reactivex.internal.schedulers;

/* loaded from: classes13.dex */
public final class RxThreadFactory extends java.util.concurrent.atomic.AtomicLong implements java.util.concurrent.ThreadFactory {
    private static final long serialVersionUID = -7789753024099756196L;
    final boolean nonBlocking;
    final java.lang.String prefix;
    final int priority;

    public static final class RxCustomThread extends java.lang.Thread implements io.reactivex.internal.schedulers.NonBlockingThread {
        public RxCustomThread(java.lang.Runnable runnable, java.lang.String str) {
            super(runnable, str);
        }
    }

    public RxThreadFactory(java.lang.String str) {
        this(str, 5, false);
    }

    public RxThreadFactory(java.lang.String str, int i) {
        this(str, i, false);
    }

    public RxThreadFactory(java.lang.String str, int i, boolean z) {
        this.prefix = str;
        this.priority = i;
        this.nonBlocking = z;
    }

    @Override // java.util.concurrent.ThreadFactory
    public java.lang.Thread newThread(java.lang.Runnable runnable) {
        java.lang.String str = this.prefix + '-' + incrementAndGet();
        java.lang.Thread rxCustomThread = this.nonBlocking ? new io.reactivex.internal.schedulers.RxThreadFactory.RxCustomThread(runnable, str) : new java.lang.Thread(runnable, str);
        rxCustomThread.setPriority(this.priority);
        rxCustomThread.setDaemon(true);
        return rxCustomThread;
    }

    @Override // java.util.concurrent.atomic.AtomicLong
    public java.lang.String toString() {
        return "RxThreadFactory[" + this.prefix + "]";
    }
}
