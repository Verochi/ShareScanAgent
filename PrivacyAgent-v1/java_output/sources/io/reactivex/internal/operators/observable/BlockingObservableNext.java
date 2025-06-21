package io.reactivex.internal.operators.observable;

/* loaded from: classes13.dex */
public final class BlockingObservableNext<T> implements java.lang.Iterable<T> {
    public final io.reactivex.ObservableSource<T> n;

    public static final class NextIterator<T> implements java.util.Iterator<T> {
        public final io.reactivex.internal.operators.observable.BlockingObservableNext.NextObserver<T> n;
        public final io.reactivex.ObservableSource<T> t;
        public T u;
        public boolean v = true;
        public boolean w = true;
        public java.lang.Throwable x;
        public boolean y;

        public NextIterator(io.reactivex.ObservableSource<T> observableSource, io.reactivex.internal.operators.observable.BlockingObservableNext.NextObserver<T> nextObserver) {
            this.t = observableSource;
            this.n = nextObserver;
        }

        public final boolean a() {
            if (!this.y) {
                this.y = true;
                this.n.b();
                new io.reactivex.internal.operators.observable.ObservableMaterialize(this.t).subscribe(this.n);
            }
            try {
                io.reactivex.Notification<T> c = this.n.c();
                if (c.isOnNext()) {
                    this.w = false;
                    this.u = c.getValue();
                    return true;
                }
                this.v = false;
                if (c.isOnComplete()) {
                    return false;
                }
                java.lang.Throwable error = c.getError();
                this.x = error;
                throw io.reactivex.internal.util.ExceptionHelper.wrapOrThrow(error);
            } catch (java.lang.InterruptedException e) {
                this.n.dispose();
                this.x = e;
                throw io.reactivex.internal.util.ExceptionHelper.wrapOrThrow(e);
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            java.lang.Throwable th = this.x;
            if (th != null) {
                throw io.reactivex.internal.util.ExceptionHelper.wrapOrThrow(th);
            }
            if (this.v) {
                return !this.w || a();
            }
            return false;
        }

        @Override // java.util.Iterator
        public T next() {
            java.lang.Throwable th = this.x;
            if (th != null) {
                throw io.reactivex.internal.util.ExceptionHelper.wrapOrThrow(th);
            }
            if (!hasNext()) {
                throw new java.util.NoSuchElementException("No more elements");
            }
            this.w = true;
            return this.u;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new java.lang.UnsupportedOperationException("Read only iterator");
        }
    }

    public static final class NextObserver<T> extends io.reactivex.observers.DisposableObserver<io.reactivex.Notification<T>> {
        public final java.util.concurrent.BlockingQueue<io.reactivex.Notification<T>> t = new java.util.concurrent.ArrayBlockingQueue(1);
        public final java.util.concurrent.atomic.AtomicInteger u = new java.util.concurrent.atomic.AtomicInteger();

        @Override // io.reactivex.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onNext(io.reactivex.Notification<T> notification) {
            if (this.u.getAndSet(0) == 1 || !notification.isOnNext()) {
                while (!this.t.offer(notification)) {
                    io.reactivex.Notification<T> poll = this.t.poll();
                    if (poll != null && !poll.isOnNext()) {
                        notification = poll;
                    }
                }
            }
        }

        public void b() {
            this.u.set(1);
        }

        public io.reactivex.Notification<T> c() throws java.lang.InterruptedException {
            b();
            io.reactivex.internal.util.BlockingHelper.verifyNonBlocking();
            return this.t.take();
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
        }

        @Override // io.reactivex.Observer
        public void onError(java.lang.Throwable th) {
            io.reactivex.plugins.RxJavaPlugins.onError(th);
        }
    }

    public BlockingObservableNext(io.reactivex.ObservableSource<T> observableSource) {
        this.n = observableSource;
    }

    @Override // java.lang.Iterable
    public java.util.Iterator<T> iterator() {
        return new io.reactivex.internal.operators.observable.BlockingObservableNext.NextIterator(this.n, new io.reactivex.internal.operators.observable.BlockingObservableNext.NextObserver());
    }
}
