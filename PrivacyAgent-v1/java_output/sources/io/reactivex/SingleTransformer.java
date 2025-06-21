package io.reactivex;

/* loaded from: classes9.dex */
public interface SingleTransformer<Upstream, Downstream> {
    @io.reactivex.annotations.NonNull
    io.reactivex.SingleSource<Downstream> apply(@io.reactivex.annotations.NonNull io.reactivex.Single<Upstream> single);
}
