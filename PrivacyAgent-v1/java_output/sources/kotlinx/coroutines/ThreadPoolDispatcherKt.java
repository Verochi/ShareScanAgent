package kotlinx.coroutines;

@kotlin.Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0007\u001a\u0010\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0005H\u0007¨\u0006\u0007"}, d2 = {"newFixedThreadPoolContext", "Lkotlinx/coroutines/ExecutorCoroutineDispatcher;", "nThreads", "", "name", "", "newSingleThreadContext", "kotlinx-coroutines-core"}, k = 2, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes15.dex */
public final class ThreadPoolDispatcherKt {
    @kotlinx.coroutines.ObsoleteCoroutinesApi
    @org.jetbrains.annotations.NotNull
    public static final kotlinx.coroutines.ExecutorCoroutineDispatcher newFixedThreadPoolContext(int i, @org.jetbrains.annotations.NotNull java.lang.String str) {
        if (i >= 1) {
            return new kotlinx.coroutines.ThreadPoolDispatcher(i, str);
        }
        throw new java.lang.IllegalArgumentException(("Expected at least one thread, but " + i + " specified").toString());
    }

    @kotlinx.coroutines.ObsoleteCoroutinesApi
    @org.jetbrains.annotations.NotNull
    public static final kotlinx.coroutines.ExecutorCoroutineDispatcher newSingleThreadContext(@org.jetbrains.annotations.NotNull java.lang.String str) {
        return newFixedThreadPoolContext(1, str);
    }
}
