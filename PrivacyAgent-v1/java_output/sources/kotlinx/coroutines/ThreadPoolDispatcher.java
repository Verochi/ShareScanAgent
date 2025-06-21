package kotlinx.coroutines;

@kotlin.Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u0001B\u0019\b\u0000\u0012\u0006\u0010\t\u001a\u00020\u0006\u0012\u0006\u0010\f\u001a\u00020\u0004¢\u0006\u0004\b\u0017\u0010\u0018J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016R\u0014\u0010\t\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\f\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\u0010\u001a\u00020\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0016\u001a\u00020\u00118\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0019"}, d2 = {"Lkotlinx/coroutines/ThreadPoolDispatcher;", "Lkotlinx/coroutines/ExecutorCoroutineDispatcherBase;", "", "close", "", "toString", "", "t", "I", "nThreads", com.umeng.analytics.pro.bo.aN, "Ljava/lang/String;", "name", "Ljava/util/concurrent/atomic/AtomicInteger;", "v", "Ljava/util/concurrent/atomic/AtomicInteger;", "threadNo", "Ljava/util/concurrent/Executor;", com.baidu.mobads.sdk.api.IAdInterListener.AdReqParam.WIDTH, "Ljava/util/concurrent/Executor;", "getExecutor", "()Ljava/util/concurrent/Executor;", "executor", "<init>", "(ILjava/lang/String;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes15.dex */
public final class ThreadPoolDispatcher extends kotlinx.coroutines.ExecutorCoroutineDispatcherBase {

    /* renamed from: t, reason: from kotlin metadata */
    public final int nThreads;

    /* renamed from: u, reason: from kotlin metadata */
    @org.jetbrains.annotations.NotNull
    public final java.lang.String name;

    /* renamed from: v, reason: from kotlin metadata */
    @org.jetbrains.annotations.NotNull
    public final java.util.concurrent.atomic.AtomicInteger threadNo = new java.util.concurrent.atomic.AtomicInteger();

    /* renamed from: w, reason: from kotlin metadata */
    @org.jetbrains.annotations.NotNull
    public final java.util.concurrent.Executor executor;

    public ThreadPoolDispatcher(int i, @org.jetbrains.annotations.NotNull java.lang.String str) {
        this.nThreads = i;
        this.name = str;
        this.executor = java.util.concurrent.Executors.newScheduledThreadPool(i, new defpackage.k13(this));
        initFutureCancellation$kotlinx_coroutines_core();
    }

    public static final java.lang.Thread d(kotlinx.coroutines.ThreadPoolDispatcher threadPoolDispatcher, java.lang.Runnable runnable) {
        java.lang.String str;
        if (threadPoolDispatcher.nThreads == 1) {
            str = threadPoolDispatcher.name;
        } else {
            str = threadPoolDispatcher.name + '-' + threadPoolDispatcher.threadNo.incrementAndGet();
        }
        return new kotlinx.coroutines.PoolThread(threadPoolDispatcher, runnable, str);
    }

    @Override // kotlinx.coroutines.ExecutorCoroutineDispatcherBase, kotlinx.coroutines.ExecutorCoroutineDispatcher, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        ((java.util.concurrent.ExecutorService) getExecutor()).shutdown();
    }

    @Override // kotlinx.coroutines.ExecutorCoroutineDispatcher
    @org.jetbrains.annotations.NotNull
    public java.util.concurrent.Executor getExecutor() {
        return this.executor;
    }

    @Override // kotlinx.coroutines.ExecutorCoroutineDispatcherBase, kotlinx.coroutines.CoroutineDispatcher
    @org.jetbrains.annotations.NotNull
    public java.lang.String toString() {
        return "ThreadPoolDispatcher[" + this.nThreads + ", " + this.name + ']';
    }
}
