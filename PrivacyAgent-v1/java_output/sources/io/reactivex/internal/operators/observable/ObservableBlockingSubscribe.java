package io.reactivex.internal.operators.observable;

/* loaded from: classes13.dex */
public final class ObservableBlockingSubscribe {
    public ObservableBlockingSubscribe() {
        throw new java.lang.IllegalStateException("No instances!");
    }

    public static <T> void subscribe(io.reactivex.ObservableSource<? extends T> observableSource) {
        io.reactivex.internal.util.BlockingIgnoringReceiver blockingIgnoringReceiver = new io.reactivex.internal.util.BlockingIgnoringReceiver();
        io.reactivex.internal.observers.LambdaObserver lambdaObserver = new io.reactivex.internal.observers.LambdaObserver(io.reactivex.internal.functions.Functions.emptyConsumer(), blockingIgnoringReceiver, blockingIgnoringReceiver, io.reactivex.internal.functions.Functions.emptyConsumer());
        observableSource.subscribe(lambdaObserver);
        io.reactivex.internal.util.BlockingHelper.awaitForComplete(blockingIgnoringReceiver, lambdaObserver);
        java.lang.Throwable th = blockingIgnoringReceiver.error;
        if (th != null) {
            throw io.reactivex.internal.util.ExceptionHelper.wrapOrThrow(th);
        }
    }

    public static <T> void subscribe(io.reactivex.ObservableSource<? extends T> observableSource, io.reactivex.Observer<? super T> observer) {
        java.util.concurrent.LinkedBlockingQueue linkedBlockingQueue = new java.util.concurrent.LinkedBlockingQueue();
        io.reactivex.internal.observers.BlockingObserver blockingObserver = new io.reactivex.internal.observers.BlockingObserver(linkedBlockingQueue);
        observer.onSubscribe(blockingObserver);
        observableSource.subscribe(blockingObserver);
        while (!blockingObserver.isDisposed()) {
            java.lang.Object poll = linkedBlockingQueue.poll();
            if (poll == null) {
                try {
                    poll = linkedBlockingQueue.take();
                } catch (java.lang.InterruptedException e) {
                    blockingObserver.dispose();
                    observer.onError(e);
                    return;
                }
            }
            if (blockingObserver.isDisposed() || poll == io.reactivex.internal.observers.BlockingObserver.TERMINATED || io.reactivex.internal.util.NotificationLite.acceptFull(poll, observer)) {
                return;
            }
        }
    }

    public static <T> void subscribe(io.reactivex.ObservableSource<? extends T> observableSource, io.reactivex.functions.Consumer<? super T> consumer, io.reactivex.functions.Consumer<? super java.lang.Throwable> consumer2, io.reactivex.functions.Action action) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(consumer, "onNext is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(consumer2, "onError is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(action, "onComplete is null");
        subscribe(observableSource, new io.reactivex.internal.observers.LambdaObserver(consumer, consumer2, action, io.reactivex.internal.functions.Functions.emptyConsumer()));
    }
}
