package io.reactivex.flowables;

/* loaded from: classes9.dex */
public abstract class ConnectableFlowable<T> extends io.reactivex.Flowable<T> {
    @io.reactivex.annotations.NonNull
    public io.reactivex.Flowable<T> autoConnect() {
        return autoConnect(1);
    }

    @io.reactivex.annotations.NonNull
    public io.reactivex.Flowable<T> autoConnect(int i) {
        return autoConnect(i, io.reactivex.internal.functions.Functions.emptyConsumer());
    }

    @io.reactivex.annotations.NonNull
    public io.reactivex.Flowable<T> autoConnect(int i, @io.reactivex.annotations.NonNull io.reactivex.functions.Consumer<? super io.reactivex.disposables.Disposable> consumer) {
        if (i > 0) {
            return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.flowable.FlowableAutoConnect(this, i, consumer));
        }
        connect(consumer);
        return io.reactivex.plugins.RxJavaPlugins.onAssembly((io.reactivex.flowables.ConnectableFlowable) this);
    }

    public final io.reactivex.disposables.Disposable connect() {
        io.reactivex.internal.util.ConnectConsumer connectConsumer = new io.reactivex.internal.util.ConnectConsumer();
        connect(connectConsumer);
        return connectConsumer.disposable;
    }

    public abstract void connect(@io.reactivex.annotations.NonNull io.reactivex.functions.Consumer<? super io.reactivex.disposables.Disposable> consumer);

    /* JADX WARN: Multi-variable type inference failed */
    public final io.reactivex.flowables.ConnectableFlowable<T> e() {
        if (!(this instanceof io.reactivex.internal.operators.flowable.FlowablePublishClassic)) {
            return this;
        }
        io.reactivex.internal.operators.flowable.FlowablePublishClassic flowablePublishClassic = (io.reactivex.internal.operators.flowable.FlowablePublishClassic) this;
        return io.reactivex.plugins.RxJavaPlugins.onAssembly((io.reactivex.flowables.ConnectableFlowable) new io.reactivex.internal.operators.flowable.FlowablePublishAlt(flowablePublishClassic.publishSource(), flowablePublishClassic.publishBufferSize()));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.PASS_THROUGH)
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public io.reactivex.Flowable<T> refCount() {
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.flowable.FlowableRefCount(e()));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.PASS_THROUGH)
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Flowable<T> refCount(int i) {
        return refCount(i, 0L, java.util.concurrent.TimeUnit.NANOSECONDS, io.reactivex.schedulers.Schedulers.trampoline());
    }

    @io.reactivex.annotations.SchedulerSupport(io.reactivex.annotations.SchedulerSupport.COMPUTATION)
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.PASS_THROUGH)
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Flowable<T> refCount(int i, long j, java.util.concurrent.TimeUnit timeUnit) {
        return refCount(i, j, timeUnit, io.reactivex.schedulers.Schedulers.computation());
    }

    @io.reactivex.annotations.SchedulerSupport("custom")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.PASS_THROUGH)
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Flowable<T> refCount(int i, long j, java.util.concurrent.TimeUnit timeUnit, io.reactivex.Scheduler scheduler) {
        io.reactivex.internal.functions.ObjectHelper.verifyPositive(i, "subscriberCount");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(timeUnit, "unit is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(scheduler, "scheduler is null");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.flowable.FlowableRefCount(e(), i, j, timeUnit, scheduler));
    }

    @io.reactivex.annotations.SchedulerSupport(io.reactivex.annotations.SchedulerSupport.COMPUTATION)
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.PASS_THROUGH)
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Flowable<T> refCount(long j, java.util.concurrent.TimeUnit timeUnit) {
        return refCount(1, j, timeUnit, io.reactivex.schedulers.Schedulers.computation());
    }

    @io.reactivex.annotations.SchedulerSupport("custom")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.PASS_THROUGH)
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Flowable<T> refCount(long j, java.util.concurrent.TimeUnit timeUnit, io.reactivex.Scheduler scheduler) {
        return refCount(1, j, timeUnit, scheduler);
    }
}
