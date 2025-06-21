package io.reactivex.internal.operators.flowable;

/* loaded from: classes10.dex */
public final class FlowableLift<R, T> extends io.reactivex.internal.operators.flowable.AbstractFlowableWithUpstream<T, R> {
    public final io.reactivex.FlowableOperator<? extends R, ? super T> t;

    public FlowableLift(io.reactivex.Flowable<T> flowable, io.reactivex.FlowableOperator<? extends R, ? super T> flowableOperator) {
        super(flowable);
        this.t = flowableOperator;
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(org.reactivestreams.Subscriber<? super R> subscriber) {
        try {
            org.reactivestreams.Subscriber<? super java.lang.Object> apply = this.t.apply(subscriber);
            if (apply != null) {
                this.source.subscribe(apply);
                return;
            }
            throw new java.lang.NullPointerException("Operator " + this.t + " returned a null Subscriber");
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
