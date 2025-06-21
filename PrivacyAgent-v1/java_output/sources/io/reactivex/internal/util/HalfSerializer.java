package io.reactivex.internal.util;

/* loaded from: classes13.dex */
public final class HalfSerializer {
    public HalfSerializer() {
        throw new java.lang.IllegalStateException("No instances!");
    }

    public static void onComplete(io.reactivex.Observer<?> observer, java.util.concurrent.atomic.AtomicInteger atomicInteger, io.reactivex.internal.util.AtomicThrowable atomicThrowable) {
        if (atomicInteger.getAndIncrement() == 0) {
            java.lang.Throwable terminate = atomicThrowable.terminate();
            if (terminate != null) {
                observer.onError(terminate);
            } else {
                observer.onComplete();
            }
        }
    }

    public static void onComplete(org.reactivestreams.Subscriber<?> subscriber, java.util.concurrent.atomic.AtomicInteger atomicInteger, io.reactivex.internal.util.AtomicThrowable atomicThrowable) {
        if (atomicInteger.getAndIncrement() == 0) {
            java.lang.Throwable terminate = atomicThrowable.terminate();
            if (terminate != null) {
                subscriber.onError(terminate);
            } else {
                subscriber.onComplete();
            }
        }
    }

    public static void onError(io.reactivex.Observer<?> observer, java.lang.Throwable th, java.util.concurrent.atomic.AtomicInteger atomicInteger, io.reactivex.internal.util.AtomicThrowable atomicThrowable) {
        if (!atomicThrowable.addThrowable(th)) {
            io.reactivex.plugins.RxJavaPlugins.onError(th);
        } else if (atomicInteger.getAndIncrement() == 0) {
            observer.onError(atomicThrowable.terminate());
        }
    }

    public static void onError(org.reactivestreams.Subscriber<?> subscriber, java.lang.Throwable th, java.util.concurrent.atomic.AtomicInteger atomicInteger, io.reactivex.internal.util.AtomicThrowable atomicThrowable) {
        if (!atomicThrowable.addThrowable(th)) {
            io.reactivex.plugins.RxJavaPlugins.onError(th);
        } else if (atomicInteger.getAndIncrement() == 0) {
            subscriber.onError(atomicThrowable.terminate());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> void onNext(io.reactivex.Observer<? super T> observer, T t, java.util.concurrent.atomic.AtomicInteger atomicInteger, io.reactivex.internal.util.AtomicThrowable atomicThrowable) {
        if (atomicInteger.get() == 0 && atomicInteger.compareAndSet(0, 1)) {
            observer.onNext(t);
            if (atomicInteger.decrementAndGet() != 0) {
                java.lang.Throwable terminate = atomicThrowable.terminate();
                if (terminate != null) {
                    observer.onError(terminate);
                } else {
                    observer.onComplete();
                }
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> void onNext(org.reactivestreams.Subscriber<? super T> subscriber, T t, java.util.concurrent.atomic.AtomicInteger atomicInteger, io.reactivex.internal.util.AtomicThrowable atomicThrowable) {
        if (atomicInteger.get() == 0 && atomicInteger.compareAndSet(0, 1)) {
            subscriber.onNext(t);
            if (atomicInteger.decrementAndGet() != 0) {
                java.lang.Throwable terminate = atomicThrowable.terminate();
                if (terminate != null) {
                    subscriber.onError(terminate);
                } else {
                    subscriber.onComplete();
                }
            }
        }
    }
}
