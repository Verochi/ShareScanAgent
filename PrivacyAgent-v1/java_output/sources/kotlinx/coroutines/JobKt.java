package kotlinx.coroutines;

@kotlin.Metadata(d1 = {"kotlinx/coroutines/JobKt__FutureKt", "kotlinx/coroutines/JobKt__JobKt"}, k = 4, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes15.dex */
public final class JobKt {
    @kotlinx.coroutines.InternalCoroutinesApi
    @org.jetbrains.annotations.NotNull
    public static final kotlinx.coroutines.DisposableHandle DisposableHandle(@org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function0<kotlin.Unit> function0) {
        return kotlinx.coroutines.JobKt__JobKt.a(function0);
    }

    @org.jetbrains.annotations.NotNull
    public static final kotlinx.coroutines.CompletableJob Job(@org.jetbrains.annotations.Nullable kotlinx.coroutines.Job job) {
        return kotlinx.coroutines.JobKt__JobKt.b(job);
    }

    public static final void cancel(@org.jetbrains.annotations.NotNull kotlin.coroutines.CoroutineContext coroutineContext, @org.jetbrains.annotations.Nullable java.util.concurrent.CancellationException cancellationException) {
        kotlinx.coroutines.JobKt__JobKt.g(coroutineContext, cancellationException);
    }

    public static final void cancel(@org.jetbrains.annotations.NotNull kotlinx.coroutines.Job job, @org.jetbrains.annotations.NotNull java.lang.String str, @org.jetbrains.annotations.Nullable java.lang.Throwable th) {
        kotlinx.coroutines.JobKt__JobKt.h(job, str, th);
    }

    @org.jetbrains.annotations.Nullable
    public static final java.lang.Object cancelAndJoin(@org.jetbrains.annotations.NotNull kotlinx.coroutines.Job job, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return kotlinx.coroutines.JobKt__JobKt.m(job, continuation);
    }

    public static final void cancelChildren(@org.jetbrains.annotations.NotNull kotlin.coroutines.CoroutineContext coroutineContext, @org.jetbrains.annotations.Nullable java.util.concurrent.CancellationException cancellationException) {
        kotlinx.coroutines.JobKt__JobKt.p(coroutineContext, cancellationException);
    }

    public static final void cancelChildren(@org.jetbrains.annotations.NotNull kotlinx.coroutines.Job job, @org.jetbrains.annotations.Nullable java.util.concurrent.CancellationException cancellationException) {
        kotlinx.coroutines.JobKt__JobKt.s(job, cancellationException);
    }

    public static final void cancelFutureOnCancellation(@org.jetbrains.annotations.NotNull kotlinx.coroutines.CancellableContinuation<?> cancellableContinuation, @org.jetbrains.annotations.NotNull java.util.concurrent.Future<?> future) {
        kotlinx.coroutines.JobKt__FutureKt.a(cancellableContinuation, future);
    }

    @kotlinx.coroutines.InternalCoroutinesApi
    @org.jetbrains.annotations.NotNull
    public static final kotlinx.coroutines.DisposableHandle cancelFutureOnCompletion(@org.jetbrains.annotations.NotNull kotlinx.coroutines.Job job, @org.jetbrains.annotations.NotNull java.util.concurrent.Future<?> future) {
        return kotlinx.coroutines.JobKt__FutureKt.b(job, future);
    }

    @org.jetbrains.annotations.NotNull
    public static final kotlinx.coroutines.DisposableHandle disposeOnCompletion(@org.jetbrains.annotations.NotNull kotlinx.coroutines.Job job, @org.jetbrains.annotations.NotNull kotlinx.coroutines.DisposableHandle disposableHandle) {
        return kotlinx.coroutines.JobKt__JobKt.x(job, disposableHandle);
    }

    public static final void ensureActive(@org.jetbrains.annotations.NotNull kotlin.coroutines.CoroutineContext coroutineContext) {
        kotlinx.coroutines.JobKt__JobKt.y(coroutineContext);
    }

    public static final void ensureActive(@org.jetbrains.annotations.NotNull kotlinx.coroutines.Job job) {
        kotlinx.coroutines.JobKt__JobKt.z(job);
    }

    @org.jetbrains.annotations.NotNull
    public static final kotlinx.coroutines.Job getJob(@org.jetbrains.annotations.NotNull kotlin.coroutines.CoroutineContext coroutineContext) {
        return kotlinx.coroutines.JobKt__JobKt.A(coroutineContext);
    }

    public static final boolean isActive(@org.jetbrains.annotations.NotNull kotlin.coroutines.CoroutineContext coroutineContext) {
        return kotlinx.coroutines.JobKt__JobKt.B(coroutineContext);
    }
}
