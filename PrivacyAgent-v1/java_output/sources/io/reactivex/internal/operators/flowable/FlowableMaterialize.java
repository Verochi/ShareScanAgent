package io.reactivex.internal.operators.flowable;

/* loaded from: classes10.dex */
public final class FlowableMaterialize<T> extends io.reactivex.internal.operators.flowable.AbstractFlowableWithUpstream<T, io.reactivex.Notification<T>> {

    public static final class MaterializeSubscriber<T> extends io.reactivex.internal.subscribers.SinglePostCompleteSubscriber<T, io.reactivex.Notification<T>> {
        private static final long serialVersionUID = -3740826063558713822L;

        public MaterializeSubscriber(org.reactivestreams.Subscriber<? super io.reactivex.Notification<T>> subscriber) {
            super(subscriber);
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            complete(io.reactivex.Notification.createOnComplete());
        }

        @Override // io.reactivex.internal.subscribers.SinglePostCompleteSubscriber
        public void onDrop(io.reactivex.Notification<T> notification) {
            if (notification.isOnError()) {
                io.reactivex.plugins.RxJavaPlugins.onError(notification.getError());
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(java.lang.Throwable th) {
            complete(io.reactivex.Notification.createOnError(th));
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            this.produced++;
            this.downstream.onNext(io.reactivex.Notification.createOnNext(t));
        }
    }

    public FlowableMaterialize(io.reactivex.Flowable<T> flowable) {
        super(flowable);
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(org.reactivestreams.Subscriber<? super io.reactivex.Notification<T>> subscriber) {
        this.source.subscribe((io.reactivex.FlowableSubscriber) new io.reactivex.internal.operators.flowable.FlowableMaterialize.MaterializeSubscriber(subscriber));
    }
}
