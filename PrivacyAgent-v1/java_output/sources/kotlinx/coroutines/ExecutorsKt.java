package kotlinx.coroutines;

@kotlin.Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0011\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0007¢\u0006\u0002\b\u0003\u001a\u0011\u0010\u0000\u001a\u00020\u0004*\u00020\u0005H\u0007¢\u0006\u0002\b\u0003\u001a\n\u0010\u0006\u001a\u00020\u0002*\u00020\u0001¨\u0006\u0007"}, d2 = {"asCoroutineDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "Ljava/util/concurrent/Executor;", "from", "Lkotlinx/coroutines/ExecutorCoroutineDispatcher;", "Ljava/util/concurrent/ExecutorService;", "asExecutor", "kotlinx-coroutines-core"}, k = 2, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes15.dex */
public final class ExecutorsKt {
    @org.jetbrains.annotations.NotNull
    public static final java.util.concurrent.Executor asExecutor(@org.jetbrains.annotations.NotNull kotlinx.coroutines.CoroutineDispatcher coroutineDispatcher) {
        kotlinx.coroutines.ExecutorCoroutineDispatcher executorCoroutineDispatcher = coroutineDispatcher instanceof kotlinx.coroutines.ExecutorCoroutineDispatcher ? (kotlinx.coroutines.ExecutorCoroutineDispatcher) coroutineDispatcher : null;
        return executorCoroutineDispatcher == null ? new kotlinx.coroutines.DispatcherExecutor(coroutineDispatcher) : executorCoroutineDispatcher.getExecutor();
    }

    @kotlin.jvm.JvmName(name = "from")
    @org.jetbrains.annotations.NotNull
    public static final kotlinx.coroutines.CoroutineDispatcher from(@org.jetbrains.annotations.NotNull java.util.concurrent.Executor executor) {
        kotlinx.coroutines.DispatcherExecutor dispatcherExecutor = executor instanceof kotlinx.coroutines.DispatcherExecutor ? (kotlinx.coroutines.DispatcherExecutor) executor : null;
        kotlinx.coroutines.CoroutineDispatcher coroutineDispatcher = dispatcherExecutor != null ? dispatcherExecutor.dispatcher : null;
        return coroutineDispatcher == null ? new kotlinx.coroutines.ExecutorCoroutineDispatcherImpl(executor) : coroutineDispatcher;
    }

    @kotlin.jvm.JvmName(name = "from")
    @org.jetbrains.annotations.NotNull
    public static final kotlinx.coroutines.ExecutorCoroutineDispatcher from(@org.jetbrains.annotations.NotNull java.util.concurrent.ExecutorService executorService) {
        return new kotlinx.coroutines.ExecutorCoroutineDispatcherImpl(executorService);
    }
}
