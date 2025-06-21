package io.reactivex.internal.operators.observable;

/* loaded from: classes13.dex */
public final class ObservableRange extends io.reactivex.Observable<java.lang.Integer> {
    public final int n;
    public final long t;

    public static final class RangeDisposable extends io.reactivex.internal.observers.BasicIntQueueDisposable<java.lang.Integer> {
        private static final long serialVersionUID = 396518478098735504L;
        final io.reactivex.Observer<? super java.lang.Integer> downstream;
        final long end;
        boolean fused;
        long index;

        public RangeDisposable(io.reactivex.Observer<? super java.lang.Integer> observer, long j, long j2) {
            this.downstream = observer;
            this.index = j;
            this.end = j2;
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public void clear() {
            this.index = this.end;
            lazySet(1);
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            set(1);
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return get() != 0;
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public boolean isEmpty() {
            return this.index == this.end;
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        @io.reactivex.annotations.Nullable
        public java.lang.Integer poll() throws java.lang.Exception {
            long j = this.index;
            if (j != this.end) {
                this.index = 1 + j;
                return java.lang.Integer.valueOf((int) j);
            }
            lazySet(1);
            return null;
        }

        @Override // io.reactivex.internal.fuseable.QueueFuseable
        public int requestFusion(int i) {
            if ((i & 1) == 0) {
                return 0;
            }
            this.fused = true;
            return 1;
        }

        public void run() {
            if (this.fused) {
                return;
            }
            io.reactivex.Observer<? super java.lang.Integer> observer = this.downstream;
            long j = this.end;
            for (long j2 = this.index; j2 != j && get() == 0; j2++) {
                observer.onNext(java.lang.Integer.valueOf((int) j2));
            }
            if (get() == 0) {
                lazySet(1);
                observer.onComplete();
            }
        }
    }

    public ObservableRange(int i, int i2) {
        this.n = i;
        this.t = i + i2;
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(io.reactivex.Observer<? super java.lang.Integer> observer) {
        io.reactivex.internal.operators.observable.ObservableRange.RangeDisposable rangeDisposable = new io.reactivex.internal.operators.observable.ObservableRange.RangeDisposable(observer, this.n, this.t);
        observer.onSubscribe(rangeDisposable);
        rangeDisposable.run();
    }
}
