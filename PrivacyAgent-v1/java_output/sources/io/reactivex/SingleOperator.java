package io.reactivex;

/* loaded from: classes9.dex */
public interface SingleOperator<Downstream, Upstream> {
    @io.reactivex.annotations.NonNull
    io.reactivex.SingleObserver<? super Upstream> apply(@io.reactivex.annotations.NonNull io.reactivex.SingleObserver<? super Downstream> singleObserver) throws java.lang.Exception;
}
