package io.reactivex.internal.operators.observable;

/* loaded from: classes13.dex */
public final class BlockingObservableIterable<T> implements java.lang.Iterable<T> {
    public final io.reactivex.ObservableSource<? extends T> n;
    public final int t;

    public static final class BlockingObservableIterator<T> extends java.util.concurrent.atomic.AtomicReference<io.reactivex.disposables.Disposable> implements io.reactivex.Observer<T>, java.util.Iterator<T>, io.reactivex.disposables.Disposable {
        private static final long serialVersionUID = 6695226475494099826L;
        final java.util.concurrent.locks.Condition condition;
        volatile boolean done;
        volatile java.lang.Throwable error;
        final java.util.concurrent.locks.Lock lock;
        final io.reactivex.internal.queue.SpscLinkedArrayQueue<T> queue;

        public BlockingObservableIterator(int i) {
            this.queue = new io.reactivex.internal.queue.SpscLinkedArrayQueue<>(i);
            java.util.concurrent.locks.ReentrantLock reentrantLock = new java.util.concurrent.locks.ReentrantLock();
            this.lock = reentrantLock;
            this.condition = reentrantLock.newCondition();
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            io.reactivex.internal.disposables.DisposableHelper.dispose(this);
            signalConsumer();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            while (!isDisposed()) {
                boolean z = this.done;
                boolean isEmpty = this.queue.isEmpty();
                if (z) {
                    java.lang.Throwable th = this.error;
                    if (th != null) {
                        throw io.reactivex.internal.util.ExceptionHelper.wrapOrThrow(th);
                    }
                    if (isEmpty) {
                        return false;
                    }
                }
                if (!isEmpty) {
                    return true;
                }
                try {
                    io.reactivex.internal.util.BlockingHelper.verifyNonBlocking();
                    this.lock.lock();
                    while (!this.done && this.queue.isEmpty() && !isDisposed()) {
                        try {
                            this.condition.await();
                        } finally {
                        }
                    }
                    this.lock.unlock();
                } catch (java.lang.InterruptedException e) {
                    io.reactivex.internal.disposables.DisposableHelper.dispose(this);
                    signalConsumer();
                    throw io.reactivex.internal.util.ExceptionHelper.wrapOrThrow(e);
                }
            }
            java.lang.Throwable th2 = this.error;
            if (th2 == null) {
                return false;
            }
            throw io.reactivex.internal.util.ExceptionHelper.wrapOrThrow(th2);
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return io.reactivex.internal.disposables.DisposableHelper.isDisposed(get());
        }

        @Override // java.util.Iterator
        public T next() {
            if (hasNext()) {
                return this.queue.poll();
            }
            throw new java.util.NoSuchElementException();
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            this.done = true;
            signalConsumer();
        }

        @Override // io.reactivex.Observer
        public void onError(java.lang.Throwable th) {
            this.error = th;
            this.done = true;
            signalConsumer();
        }

        @Override // io.reactivex.Observer
        public void onNext(T t) {
            this.queue.offer(t);
            signalConsumer();
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(io.reactivex.disposables.Disposable disposable) {
            io.reactivex.internal.disposables.DisposableHelper.setOnce(this, disposable);
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new java.lang.UnsupportedOperationException("remove");
        }

        public void signalConsumer() {
            this.lock.lock();
            try {
                this.condition.signalAll();
            } finally {
                this.lock.unlock();
            }
        }
    }

    public BlockingObservableIterable(io.reactivex.ObservableSource<? extends T> observableSource, int i) {
        this.n = observableSource;
        this.t = i;
    }

    @Override // java.lang.Iterable
    public java.util.Iterator<T> iterator() {
        io.reactivex.internal.operators.observable.BlockingObservableIterable.BlockingObservableIterator blockingObservableIterator = new io.reactivex.internal.operators.observable.BlockingObservableIterable.BlockingObservableIterator(this.t);
        this.n.subscribe(blockingObservableIterator);
        return blockingObservableIterator;
    }
}
