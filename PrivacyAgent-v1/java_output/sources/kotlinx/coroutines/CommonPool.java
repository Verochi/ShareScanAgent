package kotlinx.coroutines;

@kotlin.Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000e\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b/\u0010\u0012J#\u0010\t\u001a\u00020\u00062\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0000¢\u0006\u0004\b\u0007\u0010\bJ\u001c\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\n2\n\u0010\u000e\u001a\u00060\fj\u0002`\rH\u0016J\u000f\u0010\u0013\u001a\u00020\u000fH\u0000¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u0014H\u0000¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u001a\u001a\u00020\u000fH\u0000¢\u0006\u0004\b\u0019\u0010\u0012J\b\u0010\u001c\u001a\u00020\u001bH\u0016J\b\u0010\u001d\u001a\u00020\u000fH\u0016J\b\u0010\u001e\u001a\u00020\u0004H\u0002J\b\u0010\u001f\u001a\u00020\u0004H\u0002J\b\u0010!\u001a\u00020 H\u0002R\u0014\u0010%\u001a\u00020\"8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010\u0013\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b&\u0010'R\u0018\u0010(\u001a\u0004\u0018\u00010 8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b(\u0010)R\u0014\u0010\u0005\u001a\u00020 8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b*\u0010+R\u0014\u0010.\u001a\u00020\"8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b,\u0010-¨\u00060"}, d2 = {"Lkotlinx/coroutines/CommonPool;", "Lkotlinx/coroutines/ExecutorCoroutineDispatcher;", "Ljava/lang/Class;", "fjpClass", "Ljava/util/concurrent/ExecutorService;", "executor", "", "isGoodCommonPool$kotlinx_coroutines_core", "(Ljava/lang/Class;Ljava/util/concurrent/ExecutorService;)Z", "isGoodCommonPool", "Lkotlin/coroutines/CoroutineContext;", "context", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "block", "", "dispatch", "usePrivatePool$kotlinx_coroutines_core", "()V", "usePrivatePool", "", "timeout", "shutdown$kotlinx_coroutines_core", "(J)V", "shutdown", "restore$kotlinx_coroutines_core", com.alibaba.sdk.android.oss.common.RequestParameters.X_OSS_RESTORE, "", "toString", "close", "g", "e", "Ljava/util/concurrent/Executor;", "j", "", com.baidu.mobads.sdk.api.IAdInterListener.AdReqParam.AD_COUNT, "I", "requestedParallelism", "t", "Z", "pool", "Ljava/util/concurrent/Executor;", "getExecutor", "()Ljava/util/concurrent/Executor;", "k", "()I", "parallelism", "<init>", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes15.dex */
public final class CommonPool extends kotlinx.coroutines.ExecutorCoroutineDispatcher {

    @org.jetbrains.annotations.NotNull
    public static final kotlinx.coroutines.CommonPool INSTANCE = new kotlinx.coroutines.CommonPool();

    /* renamed from: n, reason: from kotlin metadata */
    public static final int requestedParallelism;

    @org.jetbrains.annotations.Nullable
    private static volatile java.util.concurrent.Executor pool;

    /* renamed from: t, reason: from kotlin metadata */
    public static boolean usePrivatePool;

    static {
        java.lang.String str;
        java.lang.Integer intOrNull;
        int intValue;
        try {
            str = java.lang.System.getProperty("kotlinx.coroutines.default.parallelism");
        } catch (java.lang.Throwable unused) {
            str = null;
        }
        if (str == null) {
            intValue = -1;
        } else {
            intOrNull = kotlin.text.StringsKt__StringNumberConversionsKt.toIntOrNull(str);
            if (intOrNull == null || intOrNull.intValue() < 1) {
                throw new java.lang.IllegalStateException(kotlin.jvm.internal.Intrinsics.stringPlus("Expected positive number in kotlinx.coroutines.default.parallelism, but has ", str).toString());
            }
            intValue = intOrNull.intValue();
        }
        requestedParallelism = intValue;
    }

    public static final java.lang.Thread f(java.util.concurrent.atomic.AtomicInteger atomicInteger, java.lang.Runnable runnable) {
        java.lang.Thread thread = new java.lang.Thread(runnable, kotlin.jvm.internal.Intrinsics.stringPlus("CommonPool-worker-", java.lang.Integer.valueOf(atomicInteger.incrementAndGet())));
        thread.setDaemon(true);
        return thread;
    }

    public static final void l() {
    }

    public static final void m(java.lang.Runnable runnable) {
        throw new java.util.concurrent.RejectedExecutionException("CommonPool was shutdown");
    }

    @Override // kotlinx.coroutines.ExecutorCoroutineDispatcher, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        throw new java.lang.IllegalStateException("Close cannot be invoked on CommonPool".toString());
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public void dispatch(@org.jetbrains.annotations.NotNull kotlin.coroutines.CoroutineContext context, @org.jetbrains.annotations.NotNull java.lang.Runnable block) {
        try {
            java.util.concurrent.Executor executor = pool;
            if (executor == null) {
                executor = j();
            }
            kotlinx.coroutines.AbstractTimeSource timeSource = kotlinx.coroutines.AbstractTimeSourceKt.getTimeSource();
            executor.execute(timeSource == null ? block : timeSource.wrapTask(block));
        } catch (java.util.concurrent.RejectedExecutionException unused) {
            kotlinx.coroutines.AbstractTimeSource timeSource2 = kotlinx.coroutines.AbstractTimeSourceKt.getTimeSource();
            if (timeSource2 != null) {
                timeSource2.unTrackTask();
            }
            kotlinx.coroutines.DefaultExecutor.INSTANCE.enqueue(block);
        }
    }

    public final java.util.concurrent.ExecutorService e() {
        return java.util.concurrent.Executors.newFixedThreadPool(k(), new defpackage.rr(new java.util.concurrent.atomic.AtomicInteger()));
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x003f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final java.util.concurrent.ExecutorService g() {
        java.lang.Class<?> cls;
        java.util.concurrent.ExecutorService executorService;
        java.lang.Object invoke;
        if (java.lang.System.getSecurityManager() != null) {
            return e();
        }
        java.util.concurrent.ExecutorService executorService2 = null;
        try {
            cls = java.lang.Class.forName("java.util.concurrent.ForkJoinPool");
        } catch (java.lang.Throwable unused) {
            cls = null;
        }
        if (cls == null) {
            return e();
        }
        if (!usePrivatePool && requestedParallelism < 0) {
            try {
                invoke = cls.getMethod("commonPool", new java.lang.Class[0]).invoke(null, new java.lang.Object[0]);
            } catch (java.lang.Throwable unused2) {
            }
            if (invoke instanceof java.util.concurrent.ExecutorService) {
                executorService = (java.util.concurrent.ExecutorService) invoke;
                if (executorService != null) {
                    if (!INSTANCE.isGoodCommonPool$kotlinx_coroutines_core(cls, executorService)) {
                        executorService = null;
                    }
                    if (executorService != null) {
                        return executorService;
                    }
                }
            }
            executorService = null;
            if (executorService != null) {
            }
        }
        try {
            java.lang.Object newInstance = cls.getConstructor(java.lang.Integer.TYPE).newInstance(java.lang.Integer.valueOf(INSTANCE.k()));
            if (newInstance instanceof java.util.concurrent.ExecutorService) {
                executorService2 = (java.util.concurrent.ExecutorService) newInstance;
            }
        } catch (java.lang.Throwable unused3) {
        }
        return executorService2 == null ? e() : executorService2;
    }

    @Override // kotlinx.coroutines.ExecutorCoroutineDispatcher
    @org.jetbrains.annotations.NotNull
    public java.util.concurrent.Executor getExecutor() {
        java.util.concurrent.Executor executor = pool;
        return executor == null ? j() : executor;
    }

    public final boolean isGoodCommonPool$kotlinx_coroutines_core(@org.jetbrains.annotations.NotNull java.lang.Class<?> fjpClass, @org.jetbrains.annotations.NotNull java.util.concurrent.ExecutorService executor) {
        executor.submit(new defpackage.sr());
        java.lang.Integer num = null;
        try {
            java.lang.Object invoke = fjpClass.getMethod("getPoolSize", new java.lang.Class[0]).invoke(executor, new java.lang.Object[0]);
            if (invoke instanceof java.lang.Integer) {
                num = (java.lang.Integer) invoke;
            }
        } catch (java.lang.Throwable unused) {
        }
        return num != null && num.intValue() >= 1;
    }

    public final synchronized java.util.concurrent.Executor j() {
        java.util.concurrent.Executor executor;
        executor = pool;
        if (executor == null) {
            executor = g();
            pool = executor;
        }
        return executor;
    }

    public final int k() {
        int coerceAtLeast;
        java.lang.Integer valueOf = java.lang.Integer.valueOf(requestedParallelism);
        if (!(valueOf.intValue() > 0)) {
            valueOf = null;
        }
        if (valueOf != null) {
            return valueOf.intValue();
        }
        coerceAtLeast = kotlin.ranges.RangesKt___RangesKt.coerceAtLeast(java.lang.Runtime.getRuntime().availableProcessors() - 1, 1);
        return coerceAtLeast;
    }

    public final synchronized void restore$kotlinx_coroutines_core() {
        shutdown$kotlinx_coroutines_core(0L);
        usePrivatePool = false;
        pool = null;
    }

    public final synchronized void shutdown$kotlinx_coroutines_core(long timeout) {
        java.util.concurrent.Executor executor = pool;
        java.util.concurrent.ExecutorService executorService = executor instanceof java.util.concurrent.ExecutorService ? (java.util.concurrent.ExecutorService) executor : null;
        if (executorService != null) {
            executorService.shutdown();
            if (timeout > 0) {
                executorService.awaitTermination(timeout, java.util.concurrent.TimeUnit.MILLISECONDS);
            }
            java.util.Iterator<T> it = executorService.shutdownNow().iterator();
            while (it.hasNext()) {
                kotlinx.coroutines.DefaultExecutor.INSTANCE.enqueue((java.lang.Runnable) it.next());
            }
        }
        pool = new defpackage.tr();
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    @org.jetbrains.annotations.NotNull
    public java.lang.String toString() {
        return "CommonPool";
    }

    public final synchronized void usePrivatePool$kotlinx_coroutines_core() {
        shutdown$kotlinx_coroutines_core(0L);
        usePrivatePool = true;
        pool = null;
    }
}
