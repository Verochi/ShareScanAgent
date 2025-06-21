package io.reactivex;

/* loaded from: classes9.dex */
public interface FlowableOperator<Downstream, Upstream> {
    @io.reactivex.annotations.NonNull
    org.reactivestreams.Subscriber<? super Upstream> apply(@io.reactivex.annotations.NonNull org.reactivestreams.Subscriber<? super Downstream> subscriber) throws java.lang.Exception;
}
