package io.reactivex;

/* loaded from: classes9.dex */
public interface ObservableTransformer<Upstream, Downstream> {
    @io.reactivex.annotations.NonNull
    io.reactivex.ObservableSource<Downstream> apply(@io.reactivex.annotations.NonNull io.reactivex.Observable<Upstream> observable);
}
