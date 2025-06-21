package io.reactivex.processors;

/* loaded from: classes13.dex */
public abstract class FlowableProcessor<T> extends io.reactivex.Flowable<T> implements org.reactivestreams.Processor<T, T>, io.reactivex.FlowableSubscriber<T> {
    @io.reactivex.annotations.Nullable
    public abstract java.lang.Throwable getThrowable();

    public abstract boolean hasComplete();

    public abstract boolean hasSubscribers();

    public abstract boolean hasThrowable();

    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public final io.reactivex.processors.FlowableProcessor<T> toSerialized() {
        return this instanceof io.reactivex.processors.SerializedProcessor ? this : new io.reactivex.processors.SerializedProcessor(this);
    }
}
