package io.reactivex.internal.operators.observable;

/* loaded from: classes13.dex */
abstract class AbstractObservableWithUpstream<T, U> extends io.reactivex.Observable<U> implements io.reactivex.internal.fuseable.HasUpstreamObservableSource<T> {
    protected final io.reactivex.ObservableSource<T> source;

    public AbstractObservableWithUpstream(io.reactivex.ObservableSource<T> observableSource) {
        this.source = observableSource;
    }

    @Override // io.reactivex.internal.fuseable.HasUpstreamObservableSource
    public final io.reactivex.ObservableSource<T> source() {
        return this.source;
    }
}
