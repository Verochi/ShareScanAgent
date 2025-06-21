package io.reactivex.internal.operators.observable;

/* loaded from: classes13.dex */
public final class ObservableTakeLastTimed<T> extends io.reactivex.internal.operators.observable.AbstractObservableWithUpstream<T, T> {
    public final long n;
    public final long t;
    public final java.util.concurrent.TimeUnit u;
    public final io.reactivex.Scheduler v;
    public final int w;
    public final boolean x;

    public static final class TakeLastTimedObserver<T> extends java.util.concurrent.atomic.AtomicBoolean implements io.reactivex.Observer<T>, io.reactivex.disposables.Disposable {
        private static final long serialVersionUID = -5677354903406201275L;
        volatile boolean cancelled;
        final long count;
        final boolean delayError;
        final io.reactivex.Observer<? super T> downstream;
        java.lang.Throwable error;
        final io.reactivex.internal.queue.SpscLinkedArrayQueue<java.lang.Object> queue;
        final io.reactivex.Scheduler scheduler;
        final long time;
        final java.util.concurrent.TimeUnit unit;
        io.reactivex.disposables.Disposable upstream;

        public TakeLastTimedObserver(io.reactivex.Observer<? super T> observer, long j, long j2, java.util.concurrent.TimeUnit timeUnit, io.reactivex.Scheduler scheduler, int i, boolean z) {
            this.downstream = observer;
            this.count = j;
            this.time = j2;
            this.unit = timeUnit;
            this.scheduler = scheduler;
            this.queue = new io.reactivex.internal.queue.SpscLinkedArrayQueue<>(i);
            this.delayError = z;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            if (this.cancelled) {
                return;
            }
            this.cancelled = true;
            this.upstream.dispose();
            if (compareAndSet(false, true)) {
                this.queue.clear();
            }
        }

        public void drain() {
            java.lang.Throwable th;
            if (compareAndSet(false, true)) {
                io.reactivex.Observer<? super T> observer = this.downstream;
                io.reactivex.internal.queue.SpscLinkedArrayQueue<java.lang.Object> spscLinkedArrayQueue = this.queue;
                boolean z = this.delayError;
                long now = this.scheduler.now(this.unit) - this.time;
                while (!this.cancelled) {
                    if (!z && (th = this.error) != null) {
                        spscLinkedArrayQueue.clear();
                        observer.onError(th);
                        return;
                    }
                    java.lang.Object poll = spscLinkedArrayQueue.poll();
                    if (poll == null) {
                        java.lang.Throwable th2 = this.error;
                        if (th2 != null) {
                            observer.onError(th2);
                            return;
                        } else {
                            observer.onComplete();
                            return;
                        }
                    }
                    java.lang.Object poll2 = spscLinkedArrayQueue.poll();
                    if (((java.lang.Long) poll).longValue() >= now) {
                        observer.onNext(poll2);
                    }
                }
                spscLinkedArrayQueue.clear();
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.cancelled;
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            drain();
        }

        @Override // io.reactivex.Observer
        public void onError(java.lang.Throwable th) {
            this.error = th;
            drain();
        }

        @Override // io.reactivex.Observer
        public void onNext(T t) {
            io.reactivex.internal.queue.SpscLinkedArrayQueue<java.lang.Object> spscLinkedArrayQueue = this.queue;
            long now = this.scheduler.now(this.unit);
            long j = this.time;
            long j2 = this.count;
            boolean z = j2 == Long.MAX_VALUE;
            spscLinkedArrayQueue.offer(java.lang.Long.valueOf(now), t);
            while (!spscLinkedArrayQueue.isEmpty()) {
                if (((java.lang.Long) spscLinkedArrayQueue.peek()).longValue() > now - j && (z || (spscLinkedArrayQueue.size() >> 1) <= j2)) {
                    return;
                }
                spscLinkedArrayQueue.poll();
                spscLinkedArrayQueue.poll();
            }
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(io.reactivex.disposables.Disposable disposable) {
            if (io.reactivex.internal.disposables.DisposableHelper.validate(this.upstream, disposable)) {
                this.upstream = disposable;
                this.downstream.onSubscribe(this);
            }
        }
    }

    public ObservableTakeLastTimed(io.reactivex.ObservableSource<T> observableSource, long j, long j2, java.util.concurrent.TimeUnit timeUnit, io.reactivex.Scheduler scheduler, int i, boolean z) {
        super(observableSource);
        this.n = j;
        this.t = j2;
        this.u = timeUnit;
        this.v = scheduler;
        this.w = i;
        this.x = z;
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(io.reactivex.Observer<? super T> observer) {
        this.source.subscribe(new io.reactivex.internal.operators.observable.ObservableTakeLastTimed.TakeLastTimedObserver(observer, this.n, this.t, this.u, this.v, this.w, this.x));
    }
}
