package io.reactivex;

/* loaded from: classes9.dex */
public interface MaybeOperator<Downstream, Upstream> {
    @io.reactivex.annotations.NonNull
    io.reactivex.MaybeObserver<? super Upstream> apply(@io.reactivex.annotations.NonNull io.reactivex.MaybeObserver<? super Downstream> maybeObserver) throws java.lang.Exception;
}
