package io.reactivex.internal.operators.observable;

/* loaded from: classes13.dex */
public final class ObservableAmb<T> extends io.reactivex.Observable<T> {
    public final io.reactivex.ObservableSource<? extends T>[] n;
    public final java.lang.Iterable<? extends io.reactivex.ObservableSource<? extends T>> t;

    public static final class AmbCoordinator<T> implements io.reactivex.disposables.Disposable {
        public final io.reactivex.Observer<? super T> n;
        public final io.reactivex.internal.operators.observable.ObservableAmb.AmbInnerObserver<T>[] t;
        public final java.util.concurrent.atomic.AtomicInteger u = new java.util.concurrent.atomic.AtomicInteger();

        public AmbCoordinator(io.reactivex.Observer<? super T> observer, int i) {
            this.n = observer;
            this.t = new io.reactivex.internal.operators.observable.ObservableAmb.AmbInnerObserver[i];
        }

        public void a(io.reactivex.ObservableSource<? extends T>[] observableSourceArr) {
            io.reactivex.internal.operators.observable.ObservableAmb.AmbInnerObserver<T>[] ambInnerObserverArr = this.t;
            int length = ambInnerObserverArr.length;
            int i = 0;
            while (i < length) {
                int i2 = i + 1;
                ambInnerObserverArr[i] = new io.reactivex.internal.operators.observable.ObservableAmb.AmbInnerObserver<>(this, i2, this.n);
                i = i2;
            }
            this.u.lazySet(0);
            this.n.onSubscribe(this);
            for (int i3 = 0; i3 < length && this.u.get() == 0; i3++) {
                observableSourceArr[i3].subscribe(ambInnerObserverArr[i3]);
            }
        }

        public boolean b(int i) {
            int i2 = this.u.get();
            int i3 = 0;
            if (i2 != 0) {
                return i2 == i;
            }
            if (!this.u.compareAndSet(0, i)) {
                return false;
            }
            io.reactivex.internal.operators.observable.ObservableAmb.AmbInnerObserver<T>[] ambInnerObserverArr = this.t;
            int length = ambInnerObserverArr.length;
            while (i3 < length) {
                int i4 = i3 + 1;
                if (i4 != i) {
                    ambInnerObserverArr[i3].dispose();
                }
                i3 = i4;
            }
            return true;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            if (this.u.get() != -1) {
                this.u.lazySet(-1);
                for (io.reactivex.internal.operators.observable.ObservableAmb.AmbInnerObserver<T> ambInnerObserver : this.t) {
                    ambInnerObserver.dispose();
                }
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.u.get() == -1;
        }
    }

    public static final class AmbInnerObserver<T> extends java.util.concurrent.atomic.AtomicReference<io.reactivex.disposables.Disposable> implements io.reactivex.Observer<T> {
        private static final long serialVersionUID = -1185974347409665484L;
        final io.reactivex.Observer<? super T> downstream;
        final int index;
        final io.reactivex.internal.operators.observable.ObservableAmb.AmbCoordinator<T> parent;
        boolean won;

        public AmbInnerObserver(io.reactivex.internal.operators.observable.ObservableAmb.AmbCoordinator<T> ambCoordinator, int i, io.reactivex.Observer<? super T> observer) {
            this.parent = ambCoordinator;
            this.index = i;
            this.downstream = observer;
        }

        public void dispose() {
            io.reactivex.internal.disposables.DisposableHelper.dispose(this);
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            if (this.won) {
                this.downstream.onComplete();
            } else if (this.parent.b(this.index)) {
                this.won = true;
                this.downstream.onComplete();
            }
        }

        @Override // io.reactivex.Observer
        public void onError(java.lang.Throwable th) {
            if (this.won) {
                this.downstream.onError(th);
            } else if (!this.parent.b(this.index)) {
                io.reactivex.plugins.RxJavaPlugins.onError(th);
            } else {
                this.won = true;
                this.downstream.onError(th);
            }
        }

        @Override // io.reactivex.Observer
        public void onNext(T t) {
            if (this.won) {
                this.downstream.onNext(t);
            } else if (!this.parent.b(this.index)) {
                get().dispose();
            } else {
                this.won = true;
                this.downstream.onNext(t);
            }
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(io.reactivex.disposables.Disposable disposable) {
            io.reactivex.internal.disposables.DisposableHelper.setOnce(this, disposable);
        }
    }

    public ObservableAmb(io.reactivex.ObservableSource<? extends T>[] observableSourceArr, java.lang.Iterable<? extends io.reactivex.ObservableSource<? extends T>> iterable) {
        this.n = observableSourceArr;
        this.t = iterable;
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(io.reactivex.Observer<? super T> observer) {
        int length;
        io.reactivex.ObservableSource<? extends T>[] observableSourceArr = this.n;
        if (observableSourceArr == null) {
            observableSourceArr = new io.reactivex.ObservableSource[8];
            try {
                length = 0;
                for (io.reactivex.ObservableSource<? extends T> observableSource : this.t) {
                    if (observableSource == null) {
                        io.reactivex.internal.disposables.EmptyDisposable.error(new java.lang.NullPointerException("One of the sources is null"), observer);
                        return;
                    }
                    if (length == observableSourceArr.length) {
                        io.reactivex.ObservableSource<? extends T>[] observableSourceArr2 = new io.reactivex.ObservableSource[(length >> 2) + length];
                        java.lang.System.arraycopy(observableSourceArr, 0, observableSourceArr2, 0, length);
                        observableSourceArr = observableSourceArr2;
                    }
                    int i = length + 1;
                    observableSourceArr[length] = observableSource;
                    length = i;
                }
            } catch (java.lang.Throwable th) {
                io.reactivex.exceptions.Exceptions.throwIfFatal(th);
                io.reactivex.internal.disposables.EmptyDisposable.error(th, observer);
                return;
            }
        } else {
            length = observableSourceArr.length;
        }
        if (length == 0) {
            io.reactivex.internal.disposables.EmptyDisposable.complete(observer);
        } else if (length == 1) {
            observableSourceArr[0].subscribe(observer);
        } else {
            new io.reactivex.internal.operators.observable.ObservableAmb.AmbCoordinator(observer, length).a(observableSourceArr);
        }
    }
}
