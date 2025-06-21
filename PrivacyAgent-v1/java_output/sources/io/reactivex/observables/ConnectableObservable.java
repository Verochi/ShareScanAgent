package io.reactivex.observables;

/* loaded from: classes13.dex */
public abstract class ConnectableObservable<T> extends io.reactivex.Observable<T> {
    @io.reactivex.annotations.NonNull
    public io.reactivex.Observable<T> autoConnect() {
        return autoConnect(1);
    }

    @io.reactivex.annotations.NonNull
    public io.reactivex.Observable<T> autoConnect(int i) {
        return autoConnect(i, io.reactivex.internal.functions.Functions.emptyConsumer());
    }

    @io.reactivex.annotations.NonNull
    public io.reactivex.Observable<T> autoConnect(int i, @io.reactivex.annotations.NonNull io.reactivex.functions.Consumer<? super io.reactivex.disposables.Disposable> consumer) {
        if (i > 0) {
            return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.observable.ObservableAutoConnect(this, i, consumer));
        }
        connect(consumer);
        return io.reactivex.plugins.RxJavaPlugins.onAssembly((io.reactivex.observables.ConnectableObservable) this);
    }

    public final io.reactivex.disposables.Disposable connect() {
        io.reactivex.internal.util.ConnectConsumer connectConsumer = new io.reactivex.internal.util.ConnectConsumer();
        connect(connectConsumer);
        return connectConsumer.disposable;
    }

    public abstract void connect(@io.reactivex.annotations.NonNull io.reactivex.functions.Consumer<? super io.reactivex.disposables.Disposable> consumer);

    /* JADX WARN: Multi-variable type inference failed */
    public final io.reactivex.observables.ConnectableObservable<T> d() {
        return this instanceof io.reactivex.internal.operators.observable.ObservablePublishClassic ? io.reactivex.plugins.RxJavaPlugins.onAssembly((io.reactivex.observables.ConnectableObservable) new io.reactivex.internal.operators.observable.ObservablePublishAlt(((io.reactivex.internal.operators.observable.ObservablePublishClassic) this).publishSource())) : this;
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public io.reactivex.Observable<T> refCount() {
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.observable.ObservableRefCount(d()));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Observable<T> refCount(int i) {
        return refCount(i, 0L, java.util.concurrent.TimeUnit.NANOSECONDS, io.reactivex.schedulers.Schedulers.trampoline());
    }

    @io.reactivex.annotations.SchedulerSupport(io.reactivex.annotations.SchedulerSupport.COMPUTATION)
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Observable<T> refCount(int i, long j, java.util.concurrent.TimeUnit timeUnit) {
        return refCount(i, j, timeUnit, io.reactivex.schedulers.Schedulers.computation());
    }

    @io.reactivex.annotations.SchedulerSupport("custom")
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Observable<T> refCount(int i, long j, java.util.concurrent.TimeUnit timeUnit, io.reactivex.Scheduler scheduler) {
        io.reactivex.internal.functions.ObjectHelper.verifyPositive(i, "subscriberCount");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(timeUnit, "unit is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(scheduler, "scheduler is null");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.observable.ObservableRefCount(d(), i, j, timeUnit, scheduler));
    }

    @io.reactivex.annotations.SchedulerSupport(io.reactivex.annotations.SchedulerSupport.COMPUTATION)
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Observable<T> refCount(long j, java.util.concurrent.TimeUnit timeUnit) {
        return refCount(1, j, timeUnit, io.reactivex.schedulers.Schedulers.computation());
    }

    @io.reactivex.annotations.SchedulerSupport("custom")
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Observable<T> refCount(long j, java.util.concurrent.TimeUnit timeUnit, io.reactivex.Scheduler scheduler) {
        return refCount(1, j, timeUnit, scheduler);
    }
}
