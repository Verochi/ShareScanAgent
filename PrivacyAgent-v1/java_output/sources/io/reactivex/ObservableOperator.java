package io.reactivex;

/* loaded from: classes9.dex */
public interface ObservableOperator<Downstream, Upstream> {
    @io.reactivex.annotations.NonNull
    io.reactivex.Observer<? super Upstream> apply(@io.reactivex.annotations.NonNull io.reactivex.Observer<? super Downstream> observer) throws java.lang.Exception;
}
