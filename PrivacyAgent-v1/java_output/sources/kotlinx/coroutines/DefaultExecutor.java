package kotlinx.coroutines;

@kotlin.Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\f\bÀ\u0002\u0018\u00002\u00020\u00012\u00060\u0002j\u0002`\u0003B\t\b\u0002¢\u0006\u0004\b+\u0010\u000eJ$\u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\n\u0010\u0006\u001a\u00060\u0002j\u0002`\u00032\u0006\u0010\b\u001a\u00020\u0007H\u0016J\b\u0010\f\u001a\u00020\u000bH\u0016J\u000f\u0010\u000f\u001a\u00020\u000bH\u0000¢\u0006\u0004\b\r\u0010\u000eJ\u000e\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u0004J\b\u0010\u0013\u001a\u00020\u0012H\u0002J\b\u0010\u0015\u001a\u00020\u0014H\u0002J\b\u0010\u0016\u001a\u00020\u000bH\u0002R\u0014\u0010\u0018\u001a\u00020\u00178\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001c\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u001e\u0010\u001d\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u0012\u0004\b\u001f\u0010\u000eR\u0016\u0010!\u001a\u00020 8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b!\u0010\"R\u0014\u0010%\u001a\u00020\u00128TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b#\u0010$R\u0014\u0010(\u001a\u00020\u00148@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b&\u0010'R\u0014\u0010*\u001a\u00020\u00148BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b)\u0010'¨\u0006,"}, d2 = {"Lkotlinx/coroutines/DefaultExecutor;", "Lkotlinx/coroutines/EventLoopImplBase;", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "", "timeMillis", "block", "Lkotlin/coroutines/CoroutineContext;", "context", "Lkotlinx/coroutines/DisposableHandle;", "invokeOnTimeout", "", "run", "ensureStarted$kotlinx_coroutines_core", "()V", "ensureStarted", "timeout", "shutdown", "Ljava/lang/Thread;", "l", "", com.baidu.mobads.sdk.api.IAdInterListener.AdReqParam.AD_COUNT, "k", "", "THREAD_NAME", "Ljava/lang/String;", "x", "J", "KEEP_ALIVE_NANOS", "_thread", "Ljava/lang/Thread;", "get_thread$annotations", "", "debugStatus", "I", "getThread", "()Ljava/lang/Thread;", "thread", "isThreadPresent$kotlinx_coroutines_core", "()Z", "isThreadPresent", com.anythink.expressad.d.a.b.dH, "isShutdownRequested", "<init>", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes15.dex */
public final class DefaultExecutor extends kotlinx.coroutines.EventLoopImplBase implements java.lang.Runnable {

    @org.jetbrains.annotations.NotNull
    public static final kotlinx.coroutines.DefaultExecutor INSTANCE;

    @org.jetbrains.annotations.NotNull
    public static final java.lang.String THREAD_NAME = "kotlinx.coroutines.DefaultExecutor";

    @org.jetbrains.annotations.Nullable
    private static volatile java.lang.Thread _thread;
    private static volatile int debugStatus;

    /* renamed from: x, reason: from kotlin metadata */
    public static final long KEEP_ALIVE_NANOS;

    static {
        java.lang.Long l;
        kotlinx.coroutines.DefaultExecutor defaultExecutor = new kotlinx.coroutines.DefaultExecutor();
        INSTANCE = defaultExecutor;
        kotlinx.coroutines.EventLoop.incrementUseCount$default(defaultExecutor, false, 1, null);
        java.util.concurrent.TimeUnit timeUnit = java.util.concurrent.TimeUnit.MILLISECONDS;
        try {
            l = java.lang.Long.getLong("kotlinx.coroutines.DefaultExecutor.keepAlive", 1000L);
        } catch (java.lang.SecurityException unused) {
            l = 1000L;
        }
        KEEP_ALIVE_NANOS = timeUnit.toNanos(l.longValue());
    }

    public final synchronized void ensureStarted$kotlinx_coroutines_core() {
        debugStatus = 0;
        l();
        while (debugStatus == 0) {
            wait();
        }
    }

    @Override // kotlinx.coroutines.EventLoopImplPlatform
    @org.jetbrains.annotations.NotNull
    public java.lang.Thread getThread() {
        java.lang.Thread thread = _thread;
        return thread == null ? l() : thread;
    }

    @Override // kotlinx.coroutines.EventLoopImplBase, kotlinx.coroutines.Delay
    @org.jetbrains.annotations.NotNull
    public kotlinx.coroutines.DisposableHandle invokeOnTimeout(long timeMillis, @org.jetbrains.annotations.NotNull java.lang.Runnable block, @org.jetbrains.annotations.NotNull kotlin.coroutines.CoroutineContext context) {
        return scheduleInvokeOnTimeout(timeMillis, block);
    }

    public final boolean isThreadPresent$kotlinx_coroutines_core() {
        return _thread != null;
    }

    public final synchronized void k() {
        if (m()) {
            debugStatus = 3;
            resetAll();
            notifyAll();
        }
    }

    public final synchronized java.lang.Thread l() {
        java.lang.Thread thread;
        thread = _thread;
        if (thread == null) {
            thread = new java.lang.Thread(this, THREAD_NAME);
            _thread = thread;
            thread.setDaemon(true);
            thread.start();
        }
        return thread;
    }

    public final boolean m() {
        int i = debugStatus;
        return i == 2 || i == 3;
    }

    public final synchronized boolean n() {
        if (m()) {
            return false;
        }
        debugStatus = 1;
        notifyAll();
        return true;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean isEmpty;
        kotlinx.coroutines.ThreadLocalEventLoop.INSTANCE.setEventLoop$kotlinx_coroutines_core(this);
        kotlinx.coroutines.AbstractTimeSource timeSource = kotlinx.coroutines.AbstractTimeSourceKt.getTimeSource();
        if (timeSource != null) {
            timeSource.registerTimeLoopThread();
        }
        try {
            if (!n()) {
                if (isEmpty) {
                    return;
                } else {
                    return;
                }
            }
            long j = Long.MAX_VALUE;
            while (true) {
                java.lang.Thread.interrupted();
                long processNextEvent = processNextEvent();
                if (processNextEvent == Long.MAX_VALUE) {
                    kotlinx.coroutines.AbstractTimeSource timeSource2 = kotlinx.coroutines.AbstractTimeSourceKt.getTimeSource();
                    long nanoTime = timeSource2 == null ? java.lang.System.nanoTime() : timeSource2.nanoTime();
                    if (j == Long.MAX_VALUE) {
                        j = KEEP_ALIVE_NANOS + nanoTime;
                    }
                    long j2 = j - nanoTime;
                    if (j2 <= 0) {
                        _thread = null;
                        k();
                        kotlinx.coroutines.AbstractTimeSource timeSource3 = kotlinx.coroutines.AbstractTimeSourceKt.getTimeSource();
                        if (timeSource3 != null) {
                            timeSource3.unregisterTimeLoopThread();
                        }
                        if (isEmpty()) {
                            return;
                        }
                        getThread();
                        return;
                    }
                    processNextEvent = kotlin.ranges.RangesKt___RangesKt.coerceAtMost(processNextEvent, j2);
                } else {
                    j = Long.MAX_VALUE;
                }
                if (processNextEvent > 0) {
                    if (m()) {
                        _thread = null;
                        k();
                        kotlinx.coroutines.AbstractTimeSource timeSource4 = kotlinx.coroutines.AbstractTimeSourceKt.getTimeSource();
                        if (timeSource4 != null) {
                            timeSource4.unregisterTimeLoopThread();
                        }
                        if (isEmpty()) {
                            return;
                        }
                        getThread();
                        return;
                    }
                    kotlinx.coroutines.AbstractTimeSource timeSource5 = kotlinx.coroutines.AbstractTimeSourceKt.getTimeSource();
                    if (timeSource5 == null) {
                        java.util.concurrent.locks.LockSupport.parkNanos(this, processNextEvent);
                    } else {
                        timeSource5.parkNanos(this, processNextEvent);
                    }
                }
            }
        } finally {
            _thread = null;
            k();
            kotlinx.coroutines.AbstractTimeSource timeSource6 = kotlinx.coroutines.AbstractTimeSourceKt.getTimeSource();
            if (timeSource6 != null) {
                timeSource6.unregisterTimeLoopThread();
            }
            if (!isEmpty()) {
                getThread();
            }
        }
    }

    public final synchronized void shutdown(long timeout) {
        long currentTimeMillis = java.lang.System.currentTimeMillis() + timeout;
        if (!m()) {
            debugStatus = 2;
        }
        while (debugStatus != 3 && _thread != null) {
            java.lang.Thread thread = _thread;
            if (thread != null) {
                kotlinx.coroutines.AbstractTimeSource timeSource = kotlinx.coroutines.AbstractTimeSourceKt.getTimeSource();
                if (timeSource == null) {
                    java.util.concurrent.locks.LockSupport.unpark(thread);
                } else {
                    timeSource.unpark(thread);
                }
            }
            if (currentTimeMillis - java.lang.System.currentTimeMillis() <= 0) {
                break;
            } else {
                wait(timeout);
            }
        }
        debugStatus = 0;
    }
}
