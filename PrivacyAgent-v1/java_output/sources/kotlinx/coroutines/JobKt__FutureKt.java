package kotlinx.coroutines;

@kotlin.Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u001a\u0018\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0001H\u0007\u001a\u001a\u0010\u0007\u001a\u00020\u0006*\u0006\u0012\u0002\b\u00030\u00052\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0001¨\u0006\b"}, d2 = {"Lkotlinx/coroutines/Job;", "Ljava/util/concurrent/Future;", "future", "Lkotlinx/coroutines/DisposableHandle;", "b", "Lkotlinx/coroutines/CancellableContinuation;", "", "a", "kotlinx-coroutines-core"}, k = 5, mv = {1, 5, 1}, xs = "kotlinx/coroutines/JobKt")
/* loaded from: classes15.dex */
final /* synthetic */ class JobKt__FutureKt {
    public static final void a(@org.jetbrains.annotations.NotNull kotlinx.coroutines.CancellableContinuation<?> cancellableContinuation, @org.jetbrains.annotations.NotNull java.util.concurrent.Future<?> future) {
        cancellableContinuation.invokeOnCancellation(new kotlinx.coroutines.CancelFutureOnCancel(future));
    }

    @kotlinx.coroutines.InternalCoroutinesApi
    @org.jetbrains.annotations.NotNull
    public static final kotlinx.coroutines.DisposableHandle b(@org.jetbrains.annotations.NotNull kotlinx.coroutines.Job job, @org.jetbrains.annotations.NotNull java.util.concurrent.Future<?> future) {
        return job.invokeOnCompletion(new kotlinx.coroutines.CancelFutureOnCompletion(future));
    }
}
