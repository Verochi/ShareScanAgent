package io.reactivex.internal.operators.observable;

/* loaded from: classes13.dex */
public final class ObservableWindowTimed<T> extends io.reactivex.internal.operators.observable.AbstractObservableWithUpstream<T, io.reactivex.Observable<T>> {
    public final long n;
    public final long t;
    public final java.util.concurrent.TimeUnit u;
    public final io.reactivex.Scheduler v;
    public final long w;
    public final int x;
    public final boolean y;

    public static final class WindowExactBoundedObserver<T> extends io.reactivex.internal.observers.QueueDrainObserver<T, java.lang.Object, io.reactivex.Observable<T>> implements io.reactivex.disposables.Disposable {
        public long A;
        public long B;
        public io.reactivex.disposables.Disposable C;
        public io.reactivex.subjects.UnicastSubject<T> D;
        public volatile boolean E;
        public final io.reactivex.internal.disposables.SequentialDisposable F;
        public final long t;
        public final java.util.concurrent.TimeUnit u;
        public final io.reactivex.Scheduler v;
        public final int w;
        public final boolean x;
        public final long y;
        public final io.reactivex.Scheduler.Worker z;

        public static final class ConsumerIndexHolder implements java.lang.Runnable {
            public final long n;
            public final io.reactivex.internal.operators.observable.ObservableWindowTimed.WindowExactBoundedObserver<?> t;

            public ConsumerIndexHolder(long j, io.reactivex.internal.operators.observable.ObservableWindowTimed.WindowExactBoundedObserver<?> windowExactBoundedObserver) {
                this.n = j;
                this.t = windowExactBoundedObserver;
            }

            @Override // java.lang.Runnable
            public void run() {
                io.reactivex.internal.operators.observable.ObservableWindowTimed.WindowExactBoundedObserver<?> windowExactBoundedObserver = this.t;
                if (((io.reactivex.internal.observers.QueueDrainObserver) windowExactBoundedObserver).cancelled) {
                    windowExactBoundedObserver.E = true;
                } else {
                    ((io.reactivex.internal.observers.QueueDrainObserver) windowExactBoundedObserver).queue.offer(this);
                }
                if (windowExactBoundedObserver.enter()) {
                    windowExactBoundedObserver.d();
                }
            }
        }

        public WindowExactBoundedObserver(io.reactivex.Observer<? super io.reactivex.Observable<T>> observer, long j, java.util.concurrent.TimeUnit timeUnit, io.reactivex.Scheduler scheduler, int i, long j2, boolean z) {
            super(observer, new io.reactivex.internal.queue.MpscLinkedQueue());
            this.F = new io.reactivex.internal.disposables.SequentialDisposable();
            this.t = j;
            this.u = timeUnit;
            this.v = scheduler;
            this.w = i;
            this.y = j2;
            this.x = z;
            if (z) {
                this.z = scheduler.createWorker();
            } else {
                this.z = null;
            }
        }

        public void c() {
            io.reactivex.internal.disposables.DisposableHelper.dispose(this.F);
            io.reactivex.Scheduler.Worker worker = this.z;
            if (worker != null) {
                worker.dispose();
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r2v0, types: [io.reactivex.subjects.UnicastSubject<T>] */
        public void d() {
            io.reactivex.internal.queue.MpscLinkedQueue mpscLinkedQueue = (io.reactivex.internal.queue.MpscLinkedQueue) this.queue;
            io.reactivex.Observer<? super V> observer = this.downstream;
            io.reactivex.subjects.UnicastSubject<T> unicastSubject = this.D;
            int i = 1;
            while (!this.E) {
                boolean z = this.done;
                java.lang.Object poll = mpscLinkedQueue.poll();
                boolean z2 = poll == null;
                boolean z3 = poll instanceof io.reactivex.internal.operators.observable.ObservableWindowTimed.WindowExactBoundedObserver.ConsumerIndexHolder;
                if (z && (z2 || z3)) {
                    this.D = null;
                    mpscLinkedQueue.clear();
                    java.lang.Throwable th = this.error;
                    if (th != null) {
                        unicastSubject.onError(th);
                    } else {
                        unicastSubject.onComplete();
                    }
                    c();
                    return;
                }
                if (z2) {
                    i = leave(-i);
                    if (i == 0) {
                        return;
                    }
                } else if (z3) {
                    io.reactivex.internal.operators.observable.ObservableWindowTimed.WindowExactBoundedObserver.ConsumerIndexHolder consumerIndexHolder = (io.reactivex.internal.operators.observable.ObservableWindowTimed.WindowExactBoundedObserver.ConsumerIndexHolder) poll;
                    if (!this.x || this.B == consumerIndexHolder.n) {
                        unicastSubject.onComplete();
                        this.A = 0L;
                        unicastSubject = (io.reactivex.subjects.UnicastSubject<T>) io.reactivex.subjects.UnicastSubject.create(this.w);
                        this.D = unicastSubject;
                        observer.onNext(unicastSubject);
                    }
                } else {
                    unicastSubject.onNext(io.reactivex.internal.util.NotificationLite.getValue(poll));
                    long j = this.A + 1;
                    if (j >= this.y) {
                        this.B++;
                        this.A = 0L;
                        unicastSubject.onComplete();
                        unicastSubject = (io.reactivex.subjects.UnicastSubject<T>) io.reactivex.subjects.UnicastSubject.create(this.w);
                        this.D = unicastSubject;
                        this.downstream.onNext(unicastSubject);
                        if (this.x) {
                            io.reactivex.disposables.Disposable disposable = this.F.get();
                            disposable.dispose();
                            io.reactivex.Scheduler.Worker worker = this.z;
                            io.reactivex.internal.operators.observable.ObservableWindowTimed.WindowExactBoundedObserver.ConsumerIndexHolder consumerIndexHolder2 = new io.reactivex.internal.operators.observable.ObservableWindowTimed.WindowExactBoundedObserver.ConsumerIndexHolder(this.B, this);
                            long j2 = this.t;
                            io.reactivex.disposables.Disposable schedulePeriodically = worker.schedulePeriodically(consumerIndexHolder2, j2, j2, this.u);
                            if (!this.F.compareAndSet(disposable, schedulePeriodically)) {
                                schedulePeriodically.dispose();
                            }
                        }
                    } else {
                        this.A = j;
                    }
                }
            }
            this.C.dispose();
            mpscLinkedQueue.clear();
            c();
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.cancelled = true;
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.cancelled;
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            this.done = true;
            if (enter()) {
                d();
            }
            this.downstream.onComplete();
        }

        @Override // io.reactivex.Observer
        public void onError(java.lang.Throwable th) {
            this.error = th;
            this.done = true;
            if (enter()) {
                d();
            }
            this.downstream.onError(th);
        }

        @Override // io.reactivex.Observer
        public void onNext(T t) {
            if (this.E) {
                return;
            }
            if (fastEnter()) {
                io.reactivex.subjects.UnicastSubject<T> unicastSubject = this.D;
                unicastSubject.onNext(t);
                long j = this.A + 1;
                if (j >= this.y) {
                    this.B++;
                    this.A = 0L;
                    unicastSubject.onComplete();
                    io.reactivex.subjects.UnicastSubject<T> create = io.reactivex.subjects.UnicastSubject.create(this.w);
                    this.D = create;
                    this.downstream.onNext(create);
                    if (this.x) {
                        this.F.get().dispose();
                        io.reactivex.Scheduler.Worker worker = this.z;
                        io.reactivex.internal.operators.observable.ObservableWindowTimed.WindowExactBoundedObserver.ConsumerIndexHolder consumerIndexHolder = new io.reactivex.internal.operators.observable.ObservableWindowTimed.WindowExactBoundedObserver.ConsumerIndexHolder(this.B, this);
                        long j2 = this.t;
                        io.reactivex.internal.disposables.DisposableHelper.replace(this.F, worker.schedulePeriodically(consumerIndexHolder, j2, j2, this.u));
                    }
                } else {
                    this.A = j;
                }
                if (leave(-1) == 0) {
                    return;
                }
            } else {
                this.queue.offer(io.reactivex.internal.util.NotificationLite.next(t));
                if (!enter()) {
                    return;
                }
            }
            d();
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(io.reactivex.disposables.Disposable disposable) {
            io.reactivex.disposables.Disposable schedulePeriodicallyDirect;
            if (io.reactivex.internal.disposables.DisposableHelper.validate(this.C, disposable)) {
                this.C = disposable;
                io.reactivex.Observer<? super V> observer = this.downstream;
                observer.onSubscribe(this);
                if (this.cancelled) {
                    return;
                }
                io.reactivex.subjects.UnicastSubject<T> create = io.reactivex.subjects.UnicastSubject.create(this.w);
                this.D = create;
                observer.onNext(create);
                io.reactivex.internal.operators.observable.ObservableWindowTimed.WindowExactBoundedObserver.ConsumerIndexHolder consumerIndexHolder = new io.reactivex.internal.operators.observable.ObservableWindowTimed.WindowExactBoundedObserver.ConsumerIndexHolder(this.B, this);
                if (this.x) {
                    io.reactivex.Scheduler.Worker worker = this.z;
                    long j = this.t;
                    schedulePeriodicallyDirect = worker.schedulePeriodically(consumerIndexHolder, j, j, this.u);
                } else {
                    io.reactivex.Scheduler scheduler = this.v;
                    long j2 = this.t;
                    schedulePeriodicallyDirect = scheduler.schedulePeriodicallyDirect(consumerIndexHolder, j2, j2, this.u);
                }
                this.F.replace(schedulePeriodicallyDirect);
            }
        }
    }

    public static final class WindowExactUnboundedObserver<T> extends io.reactivex.internal.observers.QueueDrainObserver<T, java.lang.Object, io.reactivex.Observable<T>> implements io.reactivex.disposables.Disposable, java.lang.Runnable {
        public static final java.lang.Object B = new java.lang.Object();
        public volatile boolean A;
        public final long t;
        public final java.util.concurrent.TimeUnit u;
        public final io.reactivex.Scheduler v;
        public final int w;
        public io.reactivex.disposables.Disposable x;
        public io.reactivex.subjects.UnicastSubject<T> y;
        public final io.reactivex.internal.disposables.SequentialDisposable z;

        public WindowExactUnboundedObserver(io.reactivex.Observer<? super io.reactivex.Observable<T>> observer, long j, java.util.concurrent.TimeUnit timeUnit, io.reactivex.Scheduler scheduler, int i) {
            super(observer, new io.reactivex.internal.queue.MpscLinkedQueue());
            this.z = new io.reactivex.internal.disposables.SequentialDisposable();
            this.t = j;
            this.u = timeUnit;
            this.v = scheduler;
            this.w = i;
        }

        /* JADX WARN: Code restructure failed: missing block: B:10:0x0023, code lost:
        
            r2.onError(r0);
         */
        /* JADX WARN: Code restructure failed: missing block: B:11:0x002a, code lost:
        
            r7.z.dispose();
         */
        /* JADX WARN: Code restructure failed: missing block: B:12:0x002f, code lost:
        
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:14:0x0027, code lost:
        
            r2.onComplete();
         */
        /* JADX WARN: Code restructure failed: missing block: B:8:0x0019, code lost:
        
            r7.y = null;
            r0.clear();
            r0 = r7.error;
         */
        /* JADX WARN: Code restructure failed: missing block: B:9:0x0021, code lost:
        
            if (r0 == null) goto L11;
         */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r2v0, types: [io.reactivex.subjects.UnicastSubject<T>] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void a() {
            io.reactivex.internal.queue.MpscLinkedQueue mpscLinkedQueue = (io.reactivex.internal.queue.MpscLinkedQueue) this.queue;
            io.reactivex.Observer<? super V> observer = this.downstream;
            io.reactivex.subjects.UnicastSubject<T> unicastSubject = this.y;
            int i = 1;
            while (true) {
                boolean z = this.A;
                boolean z2 = this.done;
                java.lang.Object poll = mpscLinkedQueue.poll();
                if (!z2 || (poll != null && poll != B)) {
                    if (poll == null) {
                        i = leave(-i);
                        if (i == 0) {
                            return;
                        }
                    } else if (poll == B) {
                        unicastSubject.onComplete();
                        if (z) {
                            this.x.dispose();
                        } else {
                            unicastSubject = (io.reactivex.subjects.UnicastSubject<T>) io.reactivex.subjects.UnicastSubject.create(this.w);
                            this.y = unicastSubject;
                            observer.onNext(unicastSubject);
                        }
                    } else {
                        unicastSubject.onNext(io.reactivex.internal.util.NotificationLite.getValue(poll));
                    }
                }
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.cancelled = true;
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.cancelled;
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            this.done = true;
            if (enter()) {
                a();
            }
            this.downstream.onComplete();
        }

        @Override // io.reactivex.Observer
        public void onError(java.lang.Throwable th) {
            this.error = th;
            this.done = true;
            if (enter()) {
                a();
            }
            this.downstream.onError(th);
        }

        @Override // io.reactivex.Observer
        public void onNext(T t) {
            if (this.A) {
                return;
            }
            if (fastEnter()) {
                this.y.onNext(t);
                if (leave(-1) == 0) {
                    return;
                }
            } else {
                this.queue.offer(io.reactivex.internal.util.NotificationLite.next(t));
                if (!enter()) {
                    return;
                }
            }
            a();
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(io.reactivex.disposables.Disposable disposable) {
            if (io.reactivex.internal.disposables.DisposableHelper.validate(this.x, disposable)) {
                this.x = disposable;
                this.y = io.reactivex.subjects.UnicastSubject.create(this.w);
                io.reactivex.Observer<? super V> observer = this.downstream;
                observer.onSubscribe(this);
                observer.onNext(this.y);
                if (this.cancelled) {
                    return;
                }
                io.reactivex.Scheduler scheduler = this.v;
                long j = this.t;
                this.z.replace(scheduler.schedulePeriodicallyDirect(this, j, j, this.u));
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.cancelled) {
                this.A = true;
            }
            this.queue.offer(B);
            if (enter()) {
                a();
            }
        }
    }

    public static final class WindowSkipObserver<T> extends io.reactivex.internal.observers.QueueDrainObserver<T, java.lang.Object, io.reactivex.Observable<T>> implements io.reactivex.disposables.Disposable, java.lang.Runnable {
        public volatile boolean A;
        public final long t;
        public final long u;
        public final java.util.concurrent.TimeUnit v;
        public final io.reactivex.Scheduler.Worker w;
        public final int x;
        public final java.util.List<io.reactivex.subjects.UnicastSubject<T>> y;
        public io.reactivex.disposables.Disposable z;

        public final class CompletionTask implements java.lang.Runnable {
            public final io.reactivex.subjects.UnicastSubject<T> n;

            public CompletionTask(io.reactivex.subjects.UnicastSubject<T> unicastSubject) {
                this.n = unicastSubject;
            }

            @Override // java.lang.Runnable
            public void run() {
                io.reactivex.internal.operators.observable.ObservableWindowTimed.WindowSkipObserver.this.a(this.n);
            }
        }

        public static final class SubjectWork<T> {
            public final io.reactivex.subjects.UnicastSubject<T> a;
            public final boolean b;

            public SubjectWork(io.reactivex.subjects.UnicastSubject<T> unicastSubject, boolean z) {
                this.a = unicastSubject;
                this.b = z;
            }
        }

        public WindowSkipObserver(io.reactivex.Observer<? super io.reactivex.Observable<T>> observer, long j, long j2, java.util.concurrent.TimeUnit timeUnit, io.reactivex.Scheduler.Worker worker, int i) {
            super(observer, new io.reactivex.internal.queue.MpscLinkedQueue());
            this.t = j;
            this.u = j2;
            this.v = timeUnit;
            this.w = worker;
            this.x = i;
            this.y = new java.util.LinkedList();
        }

        public void a(io.reactivex.subjects.UnicastSubject<T> unicastSubject) {
            this.queue.offer(new io.reactivex.internal.operators.observable.ObservableWindowTimed.WindowSkipObserver.SubjectWork(unicastSubject, false));
            if (enter()) {
                b();
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public void b() {
            io.reactivex.internal.queue.MpscLinkedQueue mpscLinkedQueue = (io.reactivex.internal.queue.MpscLinkedQueue) this.queue;
            io.reactivex.Observer<? super V> observer = this.downstream;
            java.util.List<io.reactivex.subjects.UnicastSubject<T>> list = this.y;
            int i = 1;
            while (!this.A) {
                boolean z = this.done;
                java.lang.Object poll = mpscLinkedQueue.poll();
                boolean z2 = poll == null;
                boolean z3 = poll instanceof io.reactivex.internal.operators.observable.ObservableWindowTimed.WindowSkipObserver.SubjectWork;
                if (z && (z2 || z3)) {
                    mpscLinkedQueue.clear();
                    java.lang.Throwable th = this.error;
                    if (th != null) {
                        java.util.Iterator<io.reactivex.subjects.UnicastSubject<T>> it = list.iterator();
                        while (it.hasNext()) {
                            it.next().onError(th);
                        }
                    } else {
                        java.util.Iterator<io.reactivex.subjects.UnicastSubject<T>> it2 = list.iterator();
                        while (it2.hasNext()) {
                            it2.next().onComplete();
                        }
                    }
                    list.clear();
                    this.w.dispose();
                    return;
                }
                if (z2) {
                    i = leave(-i);
                    if (i == 0) {
                        return;
                    }
                } else if (z3) {
                    io.reactivex.internal.operators.observable.ObservableWindowTimed.WindowSkipObserver.SubjectWork subjectWork = (io.reactivex.internal.operators.observable.ObservableWindowTimed.WindowSkipObserver.SubjectWork) poll;
                    if (!subjectWork.b) {
                        list.remove(subjectWork.a);
                        subjectWork.a.onComplete();
                        if (list.isEmpty() && this.cancelled) {
                            this.A = true;
                        }
                    } else if (!this.cancelled) {
                        io.reactivex.subjects.UnicastSubject<T> create = io.reactivex.subjects.UnicastSubject.create(this.x);
                        list.add(create);
                        observer.onNext(create);
                        this.w.schedule(new io.reactivex.internal.operators.observable.ObservableWindowTimed.WindowSkipObserver.CompletionTask(create), this.t, this.v);
                    }
                } else {
                    java.util.Iterator<io.reactivex.subjects.UnicastSubject<T>> it3 = list.iterator();
                    while (it3.hasNext()) {
                        it3.next().onNext(poll);
                    }
                }
            }
            this.z.dispose();
            mpscLinkedQueue.clear();
            list.clear();
            this.w.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.cancelled = true;
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.cancelled;
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            this.done = true;
            if (enter()) {
                b();
            }
            this.downstream.onComplete();
        }

        @Override // io.reactivex.Observer
        public void onError(java.lang.Throwable th) {
            this.error = th;
            this.done = true;
            if (enter()) {
                b();
            }
            this.downstream.onError(th);
        }

        @Override // io.reactivex.Observer
        public void onNext(T t) {
            if (fastEnter()) {
                java.util.Iterator<io.reactivex.subjects.UnicastSubject<T>> it = this.y.iterator();
                while (it.hasNext()) {
                    it.next().onNext(t);
                }
                if (leave(-1) == 0) {
                    return;
                }
            } else {
                this.queue.offer(t);
                if (!enter()) {
                    return;
                }
            }
            b();
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(io.reactivex.disposables.Disposable disposable) {
            if (io.reactivex.internal.disposables.DisposableHelper.validate(this.z, disposable)) {
                this.z = disposable;
                this.downstream.onSubscribe(this);
                if (this.cancelled) {
                    return;
                }
                io.reactivex.subjects.UnicastSubject<T> create = io.reactivex.subjects.UnicastSubject.create(this.x);
                this.y.add(create);
                this.downstream.onNext(create);
                this.w.schedule(new io.reactivex.internal.operators.observable.ObservableWindowTimed.WindowSkipObserver.CompletionTask(create), this.t, this.v);
                io.reactivex.Scheduler.Worker worker = this.w;
                long j = this.u;
                worker.schedulePeriodically(this, j, j, this.v);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            io.reactivex.internal.operators.observable.ObservableWindowTimed.WindowSkipObserver.SubjectWork subjectWork = new io.reactivex.internal.operators.observable.ObservableWindowTimed.WindowSkipObserver.SubjectWork(io.reactivex.subjects.UnicastSubject.create(this.x), true);
            if (!this.cancelled) {
                this.queue.offer(subjectWork);
            }
            if (enter()) {
                b();
            }
        }
    }

    public ObservableWindowTimed(io.reactivex.ObservableSource<T> observableSource, long j, long j2, java.util.concurrent.TimeUnit timeUnit, io.reactivex.Scheduler scheduler, long j3, int i, boolean z) {
        super(observableSource);
        this.n = j;
        this.t = j2;
        this.u = timeUnit;
        this.v = scheduler;
        this.w = j3;
        this.x = i;
        this.y = z;
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(io.reactivex.Observer<? super io.reactivex.Observable<T>> observer) {
        io.reactivex.observers.SerializedObserver serializedObserver = new io.reactivex.observers.SerializedObserver(observer);
        long j = this.n;
        long j2 = this.t;
        if (j != j2) {
            this.source.subscribe(new io.reactivex.internal.operators.observable.ObservableWindowTimed.WindowSkipObserver(serializedObserver, j, j2, this.u, this.v.createWorker(), this.x));
            return;
        }
        long j3 = this.w;
        if (j3 == Long.MAX_VALUE) {
            this.source.subscribe(new io.reactivex.internal.operators.observable.ObservableWindowTimed.WindowExactUnboundedObserver(serializedObserver, this.n, this.u, this.v, this.x));
        } else {
            this.source.subscribe(new io.reactivex.internal.operators.observable.ObservableWindowTimed.WindowExactBoundedObserver(serializedObserver, j, this.u, this.v, this.x, j3, this.y));
        }
    }
}
