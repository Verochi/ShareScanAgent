package io.reactivex.internal.schedulers;

/* loaded from: classes13.dex */
public class SchedulerWhen extends io.reactivex.Scheduler implements io.reactivex.disposables.Disposable {
    public static final io.reactivex.disposables.Disposable w = new io.reactivex.internal.schedulers.SchedulerWhen.SubscribedDisposable();
    public static final io.reactivex.disposables.Disposable x = io.reactivex.disposables.Disposables.disposed();
    public final io.reactivex.Scheduler t;
    public final io.reactivex.processors.FlowableProcessor<io.reactivex.Flowable<io.reactivex.Completable>> u;
    public io.reactivex.disposables.Disposable v;

    public static final class CreateWorkerFunction implements io.reactivex.functions.Function<io.reactivex.internal.schedulers.SchedulerWhen.ScheduledAction, io.reactivex.Completable> {
        public final io.reactivex.Scheduler.Worker n;

        public final class WorkerCompletable extends io.reactivex.Completable {
            public final io.reactivex.internal.schedulers.SchedulerWhen.ScheduledAction n;

            public WorkerCompletable(io.reactivex.internal.schedulers.SchedulerWhen.ScheduledAction scheduledAction) {
                this.n = scheduledAction;
            }

            @Override // io.reactivex.Completable
            public void subscribeActual(io.reactivex.CompletableObserver completableObserver) {
                completableObserver.onSubscribe(this.n);
                this.n.call(io.reactivex.internal.schedulers.SchedulerWhen.CreateWorkerFunction.this.n, completableObserver);
            }
        }

        public CreateWorkerFunction(io.reactivex.Scheduler.Worker worker) {
            this.n = worker;
        }

        @Override // io.reactivex.functions.Function
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public io.reactivex.Completable apply(io.reactivex.internal.schedulers.SchedulerWhen.ScheduledAction scheduledAction) {
            return new io.reactivex.internal.schedulers.SchedulerWhen.CreateWorkerFunction.WorkerCompletable(scheduledAction);
        }
    }

    public static class DelayedAction extends io.reactivex.internal.schedulers.SchedulerWhen.ScheduledAction {
        private final java.lang.Runnable action;
        private final long delayTime;
        private final java.util.concurrent.TimeUnit unit;

        public DelayedAction(java.lang.Runnable runnable, long j, java.util.concurrent.TimeUnit timeUnit) {
            this.action = runnable;
            this.delayTime = j;
            this.unit = timeUnit;
        }

        @Override // io.reactivex.internal.schedulers.SchedulerWhen.ScheduledAction
        public io.reactivex.disposables.Disposable callActual(io.reactivex.Scheduler.Worker worker, io.reactivex.CompletableObserver completableObserver) {
            return worker.schedule(new io.reactivex.internal.schedulers.SchedulerWhen.OnCompletedAction(this.action, completableObserver), this.delayTime, this.unit);
        }
    }

    public static class ImmediateAction extends io.reactivex.internal.schedulers.SchedulerWhen.ScheduledAction {
        private final java.lang.Runnable action;

        public ImmediateAction(java.lang.Runnable runnable) {
            this.action = runnable;
        }

        @Override // io.reactivex.internal.schedulers.SchedulerWhen.ScheduledAction
        public io.reactivex.disposables.Disposable callActual(io.reactivex.Scheduler.Worker worker, io.reactivex.CompletableObserver completableObserver) {
            return worker.schedule(new io.reactivex.internal.schedulers.SchedulerWhen.OnCompletedAction(this.action, completableObserver));
        }
    }

    public static class OnCompletedAction implements java.lang.Runnable {
        public final io.reactivex.CompletableObserver n;
        public final java.lang.Runnable t;

        public OnCompletedAction(java.lang.Runnable runnable, io.reactivex.CompletableObserver completableObserver) {
            this.t = runnable;
            this.n = completableObserver;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.t.run();
            } finally {
                this.n.onComplete();
            }
        }
    }

    public static final class QueueWorker extends io.reactivex.Scheduler.Worker {
        public final java.util.concurrent.atomic.AtomicBoolean n = new java.util.concurrent.atomic.AtomicBoolean();
        public final io.reactivex.processors.FlowableProcessor<io.reactivex.internal.schedulers.SchedulerWhen.ScheduledAction> t;
        public final io.reactivex.Scheduler.Worker u;

        public QueueWorker(io.reactivex.processors.FlowableProcessor<io.reactivex.internal.schedulers.SchedulerWhen.ScheduledAction> flowableProcessor, io.reactivex.Scheduler.Worker worker) {
            this.t = flowableProcessor;
            this.u = worker;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            if (this.n.compareAndSet(false, true)) {
                this.t.onComplete();
                this.u.dispose();
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.n.get();
        }

        @Override // io.reactivex.Scheduler.Worker
        @io.reactivex.annotations.NonNull
        public io.reactivex.disposables.Disposable schedule(@io.reactivex.annotations.NonNull java.lang.Runnable runnable) {
            io.reactivex.internal.schedulers.SchedulerWhen.ImmediateAction immediateAction = new io.reactivex.internal.schedulers.SchedulerWhen.ImmediateAction(runnable);
            this.t.onNext(immediateAction);
            return immediateAction;
        }

        @Override // io.reactivex.Scheduler.Worker
        @io.reactivex.annotations.NonNull
        public io.reactivex.disposables.Disposable schedule(@io.reactivex.annotations.NonNull java.lang.Runnable runnable, long j, @io.reactivex.annotations.NonNull java.util.concurrent.TimeUnit timeUnit) {
            io.reactivex.internal.schedulers.SchedulerWhen.DelayedAction delayedAction = new io.reactivex.internal.schedulers.SchedulerWhen.DelayedAction(runnable, j, timeUnit);
            this.t.onNext(delayedAction);
            return delayedAction;
        }
    }

    public static abstract class ScheduledAction extends java.util.concurrent.atomic.AtomicReference<io.reactivex.disposables.Disposable> implements io.reactivex.disposables.Disposable {
        public ScheduledAction() {
            super(io.reactivex.internal.schedulers.SchedulerWhen.w);
        }

        public void call(io.reactivex.Scheduler.Worker worker, io.reactivex.CompletableObserver completableObserver) {
            io.reactivex.disposables.Disposable disposable;
            io.reactivex.disposables.Disposable disposable2 = get();
            if (disposable2 != io.reactivex.internal.schedulers.SchedulerWhen.x && disposable2 == (disposable = io.reactivex.internal.schedulers.SchedulerWhen.w)) {
                io.reactivex.disposables.Disposable callActual = callActual(worker, completableObserver);
                if (compareAndSet(disposable, callActual)) {
                    return;
                }
                callActual.dispose();
            }
        }

        public abstract io.reactivex.disposables.Disposable callActual(io.reactivex.Scheduler.Worker worker, io.reactivex.CompletableObserver completableObserver);

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            io.reactivex.disposables.Disposable disposable;
            io.reactivex.disposables.Disposable disposable2 = io.reactivex.internal.schedulers.SchedulerWhen.x;
            do {
                disposable = get();
                if (disposable == io.reactivex.internal.schedulers.SchedulerWhen.x) {
                    return;
                }
            } while (!compareAndSet(disposable, disposable2));
            if (disposable != io.reactivex.internal.schedulers.SchedulerWhen.w) {
                disposable.dispose();
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return get().isDisposed();
        }
    }

    public static final class SubscribedDisposable implements io.reactivex.disposables.Disposable {
        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return false;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SchedulerWhen(io.reactivex.functions.Function<io.reactivex.Flowable<io.reactivex.Flowable<io.reactivex.Completable>>, io.reactivex.Completable> function, io.reactivex.Scheduler scheduler) {
        this.t = scheduler;
        io.reactivex.processors.FlowableProcessor serialized = io.reactivex.processors.UnicastProcessor.create().toSerialized();
        this.u = serialized;
        try {
            this.v = ((io.reactivex.Completable) function.apply(serialized)).subscribe();
        } catch (java.lang.Throwable th) {
            throw io.reactivex.internal.util.ExceptionHelper.wrapOrThrow(th);
        }
    }

    @Override // io.reactivex.Scheduler
    @io.reactivex.annotations.NonNull
    public io.reactivex.Scheduler.Worker createWorker() {
        io.reactivex.Scheduler.Worker createWorker = this.t.createWorker();
        io.reactivex.processors.FlowableProcessor<T> serialized = io.reactivex.processors.UnicastProcessor.create().toSerialized();
        io.reactivex.Flowable<io.reactivex.Completable> map = serialized.map(new io.reactivex.internal.schedulers.SchedulerWhen.CreateWorkerFunction(createWorker));
        io.reactivex.internal.schedulers.SchedulerWhen.QueueWorker queueWorker = new io.reactivex.internal.schedulers.SchedulerWhen.QueueWorker(serialized, createWorker);
        this.u.onNext(map);
        return queueWorker;
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        this.v.dispose();
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        return this.v.isDisposed();
    }
}
