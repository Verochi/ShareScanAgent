package io.reactivex.disposables;

/* loaded from: classes9.dex */
public final class Disposables {
    public Disposables() {
        throw new java.lang.IllegalStateException("No instances!");
    }

    @io.reactivex.annotations.NonNull
    public static io.reactivex.disposables.Disposable disposed() {
        return io.reactivex.internal.disposables.EmptyDisposable.INSTANCE;
    }

    @io.reactivex.annotations.NonNull
    public static io.reactivex.disposables.Disposable empty() {
        return fromRunnable(io.reactivex.internal.functions.Functions.EMPTY_RUNNABLE);
    }

    @io.reactivex.annotations.NonNull
    public static io.reactivex.disposables.Disposable fromAction(@io.reactivex.annotations.NonNull io.reactivex.functions.Action action) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(action, "run is null");
        return new io.reactivex.disposables.ActionDisposable(action);
    }

    @io.reactivex.annotations.NonNull
    public static io.reactivex.disposables.Disposable fromFuture(@io.reactivex.annotations.NonNull java.util.concurrent.Future<?> future) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(future, "future is null");
        return fromFuture(future, true);
    }

    @io.reactivex.annotations.NonNull
    public static io.reactivex.disposables.Disposable fromFuture(@io.reactivex.annotations.NonNull java.util.concurrent.Future<?> future, boolean z) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(future, "future is null");
        return new io.reactivex.disposables.FutureDisposable(future, z);
    }

    @io.reactivex.annotations.NonNull
    public static io.reactivex.disposables.Disposable fromRunnable(@io.reactivex.annotations.NonNull java.lang.Runnable runnable) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(runnable, "run is null");
        return new io.reactivex.disposables.RunnableDisposable(runnable);
    }

    @io.reactivex.annotations.NonNull
    public static io.reactivex.disposables.Disposable fromSubscription(@io.reactivex.annotations.NonNull org.reactivestreams.Subscription subscription) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(subscription, "subscription is null");
        return new io.reactivex.disposables.SubscriptionDisposable(subscription);
    }
}
