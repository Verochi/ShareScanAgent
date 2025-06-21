package org.reactivestreams;

/* loaded from: classes26.dex */
public final class FlowAdapters {

    public static final class FlowPublisherFromReactive<T> implements java.util.concurrent.Flow.Publisher<T> {
        public final org.reactivestreams.Publisher<? extends T> a;

        public FlowPublisherFromReactive(org.reactivestreams.Publisher<? extends T> publisher) {
            this.a = publisher;
        }

        @Override // java.util.concurrent.Flow.Publisher
        public void subscribe(java.util.concurrent.Flow.Subscriber<? super T> subscriber) {
            this.a.subscribe(subscriber == null ? null : new org.reactivestreams.FlowAdapters.ReactiveToFlowSubscriber(subscriber));
        }
    }

    public static final class FlowToReactiveProcessor<T, U> implements java.util.concurrent.Flow.Processor<T, U> {
        public final org.reactivestreams.Processor<? super T, ? extends U> a;

        public FlowToReactiveProcessor(org.reactivestreams.Processor<? super T, ? extends U> processor) {
            this.a = processor;
        }

        @Override // java.util.concurrent.Flow.Subscriber
        public void onComplete() {
            this.a.onComplete();
        }

        @Override // java.util.concurrent.Flow.Subscriber
        public void onError(java.lang.Throwable th) {
            this.a.onError(th);
        }

        @Override // java.util.concurrent.Flow.Subscriber
        public void onNext(T t) {
            this.a.onNext(t);
        }

        @Override // java.util.concurrent.Flow.Subscriber
        public void onSubscribe(java.util.concurrent.Flow.Subscription subscription) {
            this.a.onSubscribe(subscription == null ? null : new org.reactivestreams.FlowAdapters.ReactiveToFlowSubscription(subscription));
        }

        @Override // java.util.concurrent.Flow.Publisher
        public void subscribe(java.util.concurrent.Flow.Subscriber<? super U> subscriber) {
            this.a.subscribe(subscriber == null ? null : new org.reactivestreams.FlowAdapters.ReactiveToFlowSubscriber(subscriber));
        }
    }

    public static final class FlowToReactiveSubscriber<T> implements java.util.concurrent.Flow.Subscriber<T> {
        public final org.reactivestreams.Subscriber<? super T> a;

        public FlowToReactiveSubscriber(org.reactivestreams.Subscriber<? super T> subscriber) {
            this.a = subscriber;
        }

        @Override // java.util.concurrent.Flow.Subscriber
        public void onComplete() {
            this.a.onComplete();
        }

        @Override // java.util.concurrent.Flow.Subscriber
        public void onError(java.lang.Throwable th) {
            this.a.onError(th);
        }

        @Override // java.util.concurrent.Flow.Subscriber
        public void onNext(T t) {
            this.a.onNext(t);
        }

        @Override // java.util.concurrent.Flow.Subscriber
        public void onSubscribe(java.util.concurrent.Flow.Subscription subscription) {
            this.a.onSubscribe(subscription == null ? null : new org.reactivestreams.FlowAdapters.ReactiveToFlowSubscription(subscription));
        }
    }

    public static final class FlowToReactiveSubscription implements java.util.concurrent.Flow.Subscription {
        public final org.reactivestreams.Subscription a;

        public FlowToReactiveSubscription(org.reactivestreams.Subscription subscription) {
            this.a = subscription;
        }

        @Override // java.util.concurrent.Flow.Subscription
        public void cancel() {
            this.a.cancel();
        }

        @Override // java.util.concurrent.Flow.Subscription
        public void request(long j) {
            this.a.request(j);
        }
    }

    public static final class ReactivePublisherFromFlow<T> implements org.reactivestreams.Publisher<T> {
        public final java.util.concurrent.Flow.Publisher<? extends T> n;

        public ReactivePublisherFromFlow(java.util.concurrent.Flow.Publisher<? extends T> publisher) {
            this.n = publisher;
        }

        @Override // org.reactivestreams.Publisher
        public void subscribe(org.reactivestreams.Subscriber<? super T> subscriber) {
            this.n.subscribe(subscriber == null ? null : new org.reactivestreams.FlowAdapters.FlowToReactiveSubscriber(subscriber));
        }
    }

    public static final class ReactiveToFlowProcessor<T, U> implements org.reactivestreams.Processor<T, U> {
        public final java.util.concurrent.Flow.Processor<? super T, ? extends U> n;

        public ReactiveToFlowProcessor(java.util.concurrent.Flow.Processor<? super T, ? extends U> processor) {
            this.n = processor;
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.n.onComplete();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(java.lang.Throwable th) {
            this.n.onError(th);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            this.n.onNext(t);
        }

        @Override // org.reactivestreams.Subscriber
        public void onSubscribe(org.reactivestreams.Subscription subscription) {
            this.n.onSubscribe(subscription == null ? null : new org.reactivestreams.FlowAdapters.FlowToReactiveSubscription(subscription));
        }

        @Override // org.reactivestreams.Publisher
        public void subscribe(org.reactivestreams.Subscriber<? super U> subscriber) {
            this.n.subscribe(subscriber == null ? null : new org.reactivestreams.FlowAdapters.FlowToReactiveSubscriber(subscriber));
        }
    }

    public static final class ReactiveToFlowSubscriber<T> implements org.reactivestreams.Subscriber<T> {
        public final java.util.concurrent.Flow.Subscriber<? super T> n;

        public ReactiveToFlowSubscriber(java.util.concurrent.Flow.Subscriber<? super T> subscriber) {
            this.n = subscriber;
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.n.onComplete();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(java.lang.Throwable th) {
            this.n.onError(th);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            this.n.onNext(t);
        }

        @Override // org.reactivestreams.Subscriber
        public void onSubscribe(org.reactivestreams.Subscription subscription) {
            this.n.onSubscribe(subscription == null ? null : new org.reactivestreams.FlowAdapters.FlowToReactiveSubscription(subscription));
        }
    }

    public static final class ReactiveToFlowSubscription implements org.reactivestreams.Subscription {
        public final java.util.concurrent.Flow.Subscription n;

        public ReactiveToFlowSubscription(java.util.concurrent.Flow.Subscription subscription) {
            this.n = subscription;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.n.cancel();
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            this.n.request(j);
        }
    }

    public FlowAdapters() {
        throw new java.lang.IllegalStateException("No instances!");
    }

    public static <T, U> java.util.concurrent.Flow.Processor<T, U> toFlowProcessor(org.reactivestreams.Processor<? super T, ? extends U> processor) {
        java.util.Objects.requireNonNull(processor, "reactiveStreamsProcessor");
        return processor instanceof org.reactivestreams.FlowAdapters.ReactiveToFlowProcessor ? ((org.reactivestreams.FlowAdapters.ReactiveToFlowProcessor) processor).n : processor instanceof java.util.concurrent.Flow.Processor ? (java.util.concurrent.Flow.Processor) processor : new org.reactivestreams.FlowAdapters.FlowToReactiveProcessor(processor);
    }

    public static <T> java.util.concurrent.Flow.Publisher<T> toFlowPublisher(org.reactivestreams.Publisher<? extends T> publisher) {
        java.util.Objects.requireNonNull(publisher, "reactiveStreamsPublisher");
        return publisher instanceof org.reactivestreams.FlowAdapters.ReactivePublisherFromFlow ? ((org.reactivestreams.FlowAdapters.ReactivePublisherFromFlow) publisher).n : publisher instanceof java.util.concurrent.Flow.Publisher ? (java.util.concurrent.Flow.Publisher) publisher : new org.reactivestreams.FlowAdapters.FlowPublisherFromReactive(publisher);
    }

    public static <T> java.util.concurrent.Flow.Subscriber<T> toFlowSubscriber(org.reactivestreams.Subscriber<T> subscriber) {
        java.util.Objects.requireNonNull(subscriber, "reactiveStreamsSubscriber");
        return subscriber instanceof org.reactivestreams.FlowAdapters.ReactiveToFlowSubscriber ? ((org.reactivestreams.FlowAdapters.ReactiveToFlowSubscriber) subscriber).n : subscriber instanceof java.util.concurrent.Flow.Subscriber ? (java.util.concurrent.Flow.Subscriber) subscriber : new org.reactivestreams.FlowAdapters.FlowToReactiveSubscriber(subscriber);
    }

    public static <T, U> org.reactivestreams.Processor<T, U> toProcessor(java.util.concurrent.Flow.Processor<? super T, ? extends U> processor) {
        java.util.Objects.requireNonNull(processor, "flowProcessor");
        return processor instanceof org.reactivestreams.FlowAdapters.FlowToReactiveProcessor ? ((org.reactivestreams.FlowAdapters.FlowToReactiveProcessor) processor).a : processor instanceof org.reactivestreams.Processor ? (org.reactivestreams.Processor) processor : new org.reactivestreams.FlowAdapters.ReactiveToFlowProcessor(processor);
    }

    public static <T> org.reactivestreams.Publisher<T> toPublisher(java.util.concurrent.Flow.Publisher<? extends T> publisher) {
        java.util.Objects.requireNonNull(publisher, "flowPublisher");
        return publisher instanceof org.reactivestreams.FlowAdapters.FlowPublisherFromReactive ? ((org.reactivestreams.FlowAdapters.FlowPublisherFromReactive) publisher).a : publisher instanceof org.reactivestreams.Publisher ? (org.reactivestreams.Publisher) publisher : new org.reactivestreams.FlowAdapters.ReactivePublisherFromFlow(publisher);
    }

    public static <T> org.reactivestreams.Subscriber<T> toSubscriber(java.util.concurrent.Flow.Subscriber<T> subscriber) {
        java.util.Objects.requireNonNull(subscriber, "flowSubscriber");
        return subscriber instanceof org.reactivestreams.FlowAdapters.FlowToReactiveSubscriber ? ((org.reactivestreams.FlowAdapters.FlowToReactiveSubscriber) subscriber).a : subscriber instanceof org.reactivestreams.Subscriber ? (org.reactivestreams.Subscriber) subscriber : new org.reactivestreams.FlowAdapters.ReactiveToFlowSubscriber(subscriber);
    }
}
