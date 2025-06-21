package io.reactivex.internal.operators.observable;

/* loaded from: classes13.dex */
public final class ObservableLift<R, T> extends io.reactivex.internal.operators.observable.AbstractObservableWithUpstream<T, R> {
    public final io.reactivex.ObservableOperator<? extends R, ? super T> n;

    public ObservableLift(io.reactivex.ObservableSource<T> observableSource, io.reactivex.ObservableOperator<? extends R, ? super T> observableOperator) {
        super(observableSource);
        this.n = observableOperator;
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(io.reactivex.Observer<? super R> observer) {
        try {
            this.source.subscribe((io.reactivex.Observer) io.reactivex.internal.functions.ObjectHelper.requireNonNull(this.n.apply(observer), "Operator " + this.n + " returned a null Observer"));
        } catch (java.lang.NullPointerException e) {
            throw e;
        } catch (java.lang.Throwable th) {
            io.reactivex.exceptions.Exceptions.throwIfFatal(th);
            io.reactivex.plugins.RxJavaPlugins.onError(th);
            java.lang.NullPointerException nullPointerException = new java.lang.NullPointerException("Actually not, but can't throw other exceptions due to RS");
            nullPointerException.initCause(th);
            throw nullPointerException;
        }
    }
}
