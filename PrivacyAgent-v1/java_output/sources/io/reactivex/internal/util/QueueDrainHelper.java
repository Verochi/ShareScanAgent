package io.reactivex.internal.util;

/* loaded from: classes13.dex */
public final class QueueDrainHelper {
    public QueueDrainHelper() {
        throw new java.lang.IllegalStateException("No instances!");
    }

    public static boolean a(io.reactivex.functions.BooleanSupplier booleanSupplier) {
        try {
            return booleanSupplier.getAsBoolean();
        } catch (java.lang.Throwable th) {
            io.reactivex.exceptions.Exceptions.throwIfFatal(th);
            return true;
        }
    }

    public static <T> boolean b(long j, org.reactivestreams.Subscriber<? super T> subscriber, java.util.Queue<T> queue, java.util.concurrent.atomic.AtomicLong atomicLong, io.reactivex.functions.BooleanSupplier booleanSupplier) {
        long j2 = j & Long.MIN_VALUE;
        while (true) {
            if (j2 != j) {
                if (a(booleanSupplier)) {
                    return true;
                }
                T poll = queue.poll();
                if (poll == null) {
                    subscriber.onComplete();
                    return true;
                }
                subscriber.onNext(poll);
                j2++;
            } else {
                if (a(booleanSupplier)) {
                    return true;
                }
                if (queue.isEmpty()) {
                    subscriber.onComplete();
                    return true;
                }
                j = atomicLong.get();
                if (j == j2) {
                    long addAndGet = atomicLong.addAndGet(-(j2 & Long.MAX_VALUE));
                    if ((Long.MAX_VALUE & addAndGet) == 0) {
                        return false;
                    }
                    j = addAndGet;
                    j2 = addAndGet & Long.MIN_VALUE;
                } else {
                    continue;
                }
            }
        }
    }

    public static <T, U> boolean checkTerminated(boolean z, boolean z2, io.reactivex.Observer<?> observer, boolean z3, io.reactivex.internal.fuseable.SimpleQueue<?> simpleQueue, io.reactivex.disposables.Disposable disposable, io.reactivex.internal.util.ObservableQueueDrain<T, U> observableQueueDrain) {
        if (observableQueueDrain.cancelled()) {
            simpleQueue.clear();
            disposable.dispose();
            return true;
        }
        if (!z) {
            return false;
        }
        if (z3) {
            if (!z2) {
                return false;
            }
            if (disposable != null) {
                disposable.dispose();
            }
            java.lang.Throwable error = observableQueueDrain.error();
            if (error != null) {
                observer.onError(error);
            } else {
                observer.onComplete();
            }
            return true;
        }
        java.lang.Throwable error2 = observableQueueDrain.error();
        if (error2 != null) {
            simpleQueue.clear();
            if (disposable != null) {
                disposable.dispose();
            }
            observer.onError(error2);
            return true;
        }
        if (!z2) {
            return false;
        }
        if (disposable != null) {
            disposable.dispose();
        }
        observer.onComplete();
        return true;
    }

    public static <T, U> boolean checkTerminated(boolean z, boolean z2, org.reactivestreams.Subscriber<?> subscriber, boolean z3, io.reactivex.internal.fuseable.SimpleQueue<?> simpleQueue, io.reactivex.internal.util.QueueDrain<T, U> queueDrain) {
        if (queueDrain.cancelled()) {
            simpleQueue.clear();
            return true;
        }
        if (!z) {
            return false;
        }
        if (z3) {
            if (!z2) {
                return false;
            }
            java.lang.Throwable error = queueDrain.error();
            if (error != null) {
                subscriber.onError(error);
            } else {
                subscriber.onComplete();
            }
            return true;
        }
        java.lang.Throwable error2 = queueDrain.error();
        if (error2 != null) {
            simpleQueue.clear();
            subscriber.onError(error2);
            return true;
        }
        if (!z2) {
            return false;
        }
        subscriber.onComplete();
        return true;
    }

    public static <T> io.reactivex.internal.fuseable.SimpleQueue<T> createQueue(int i) {
        return i < 0 ? new io.reactivex.internal.queue.SpscLinkedArrayQueue(-i) : new io.reactivex.internal.queue.SpscArrayQueue(i);
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0033, code lost:
    
        r1 = r15.leave(-r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0038, code lost:
    
        if (r1 != 0) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x003a, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static <T, U> void drainLoop(io.reactivex.internal.fuseable.SimplePlainQueue<T> simplePlainQueue, io.reactivex.Observer<? super U> observer, boolean z, io.reactivex.disposables.Disposable disposable, io.reactivex.internal.util.ObservableQueueDrain<T, U> observableQueueDrain) {
        int i = 1;
        while (!checkTerminated(observableQueueDrain.done(), simplePlainQueue.isEmpty(), observer, z, simplePlainQueue, disposable, observableQueueDrain)) {
            while (true) {
                boolean done = observableQueueDrain.done();
                T poll = simplePlainQueue.poll();
                boolean z2 = poll == null;
                if (checkTerminated(done, z2, observer, z, simplePlainQueue, disposable, observableQueueDrain)) {
                    return;
                }
                if (z2) {
                    break;
                } else {
                    observableQueueDrain.accept(observer, poll);
                }
            }
        }
    }

    public static <T, U> void drainMaxLoop(io.reactivex.internal.fuseable.SimplePlainQueue<T> simplePlainQueue, org.reactivestreams.Subscriber<? super U> subscriber, boolean z, io.reactivex.disposables.Disposable disposable, io.reactivex.internal.util.QueueDrain<T, U> queueDrain) {
        int i = 1;
        while (true) {
            boolean done = queueDrain.done();
            T poll = simplePlainQueue.poll();
            boolean z2 = poll == null;
            if (checkTerminated(done, z2, subscriber, z, simplePlainQueue, queueDrain)) {
                if (disposable != null) {
                    disposable.dispose();
                    return;
                }
                return;
            } else if (z2) {
                i = queueDrain.leave(-i);
                if (i == 0) {
                    return;
                }
            } else {
                long requested = queueDrain.requested();
                if (requested == 0) {
                    simplePlainQueue.clear();
                    if (disposable != null) {
                        disposable.dispose();
                    }
                    subscriber.onError(new io.reactivex.exceptions.MissingBackpressureException("Could not emit value due to lack of requests."));
                    return;
                }
                if (queueDrain.accept(subscriber, poll) && requested != Long.MAX_VALUE) {
                    queueDrain.produced(1L);
                }
            }
        }
    }

    public static <T> void postComplete(org.reactivestreams.Subscriber<? super T> subscriber, java.util.Queue<T> queue, java.util.concurrent.atomic.AtomicLong atomicLong, io.reactivex.functions.BooleanSupplier booleanSupplier) {
        long j;
        long j2;
        if (queue.isEmpty()) {
            subscriber.onComplete();
            return;
        }
        if (b(atomicLong.get(), subscriber, queue, atomicLong, booleanSupplier)) {
            return;
        }
        do {
            j = atomicLong.get();
            if ((j & Long.MIN_VALUE) != 0) {
                return;
            } else {
                j2 = j | Long.MIN_VALUE;
            }
        } while (!atomicLong.compareAndSet(j, j2));
        if (j != 0) {
            b(j2, subscriber, queue, atomicLong, booleanSupplier);
        }
    }

    public static <T> boolean postCompleteRequest(long j, org.reactivestreams.Subscriber<? super T> subscriber, java.util.Queue<T> queue, java.util.concurrent.atomic.AtomicLong atomicLong, io.reactivex.functions.BooleanSupplier booleanSupplier) {
        long j2;
        do {
            j2 = atomicLong.get();
        } while (!atomicLong.compareAndSet(j2, io.reactivex.internal.util.BackpressureHelper.addCap(Long.MAX_VALUE & j2, j) | (j2 & Long.MIN_VALUE)));
        if (j2 != Long.MIN_VALUE) {
            return false;
        }
        b(j | Long.MIN_VALUE, subscriber, queue, atomicLong, booleanSupplier);
        return true;
    }

    public static void request(org.reactivestreams.Subscription subscription, int i) {
        subscription.request(i < 0 ? Long.MAX_VALUE : i);
    }
}
