package io.reactivex.internal.operators.single;

/* loaded from: classes13.dex */
public final class SingleInternalHelper {

    public enum NoSuchElementCallable implements java.util.concurrent.Callable<java.util.NoSuchElementException> {
        INSTANCE;

        @Override // java.util.concurrent.Callable
        public java.util.NoSuchElementException call() throws java.lang.Exception {
            return new java.util.NoSuchElementException();
        }
    }

    public enum ToFlowable implements io.reactivex.functions.Function<io.reactivex.SingleSource, org.reactivestreams.Publisher> {
        INSTANCE;

        @Override // io.reactivex.functions.Function
        public org.reactivestreams.Publisher apply(io.reactivex.SingleSource singleSource) {
            return new io.reactivex.internal.operators.single.SingleToFlowable(singleSource);
        }
    }

    public static final class ToFlowableIterable<T> implements java.lang.Iterable<io.reactivex.Flowable<T>> {
        public final java.lang.Iterable<? extends io.reactivex.SingleSource<? extends T>> n;

        public ToFlowableIterable(java.lang.Iterable<? extends io.reactivex.SingleSource<? extends T>> iterable) {
            this.n = iterable;
        }

        @Override // java.lang.Iterable
        public java.util.Iterator<io.reactivex.Flowable<T>> iterator() {
            return new io.reactivex.internal.operators.single.SingleInternalHelper.ToFlowableIterator(this.n.iterator());
        }
    }

    public static final class ToFlowableIterator<T> implements java.util.Iterator<io.reactivex.Flowable<T>> {
        public final java.util.Iterator<? extends io.reactivex.SingleSource<? extends T>> n;

        public ToFlowableIterator(java.util.Iterator<? extends io.reactivex.SingleSource<? extends T>> it) {
            this.n = it;
        }

        @Override // java.util.Iterator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public io.reactivex.Flowable<T> next() {
            return new io.reactivex.internal.operators.single.SingleToFlowable(this.n.next());
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.n.hasNext();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new java.lang.UnsupportedOperationException();
        }
    }

    public enum ToObservable implements io.reactivex.functions.Function<io.reactivex.SingleSource, io.reactivex.Observable> {
        INSTANCE;

        @Override // io.reactivex.functions.Function
        public io.reactivex.Observable apply(io.reactivex.SingleSource singleSource) {
            return new io.reactivex.internal.operators.single.SingleToObservable(singleSource);
        }
    }

    public SingleInternalHelper() {
        throw new java.lang.IllegalStateException("No instances!");
    }

    public static <T> java.util.concurrent.Callable<java.util.NoSuchElementException> emptyThrower() {
        return io.reactivex.internal.operators.single.SingleInternalHelper.NoSuchElementCallable.INSTANCE;
    }

    public static <T> java.lang.Iterable<? extends io.reactivex.Flowable<T>> iterableToFlowable(java.lang.Iterable<? extends io.reactivex.SingleSource<? extends T>> iterable) {
        return new io.reactivex.internal.operators.single.SingleInternalHelper.ToFlowableIterable(iterable);
    }

    public static <T> io.reactivex.functions.Function<io.reactivex.SingleSource<? extends T>, org.reactivestreams.Publisher<? extends T>> toFlowable() {
        return io.reactivex.internal.operators.single.SingleInternalHelper.ToFlowable.INSTANCE;
    }

    public static <T> io.reactivex.functions.Function<io.reactivex.SingleSource<? extends T>, io.reactivex.Observable<? extends T>> toObservable() {
        return io.reactivex.internal.operators.single.SingleInternalHelper.ToObservable.INSTANCE;
    }
}
