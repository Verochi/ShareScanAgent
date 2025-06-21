package androidx.lifecycle;

/* loaded from: classes.dex */
public final class LiveDataReactiveStreams {

    public static final class LiveDataPublisher<T> implements org.reactivestreams.Publisher<T> {
        final androidx.lifecycle.LifecycleOwner mLifecycle;
        final androidx.lifecycle.LiveData<T> mLiveData;

        public static final class LiveDataSubscription<T> implements org.reactivestreams.Subscription, androidx.lifecycle.Observer<T> {
            volatile boolean mCanceled;

            @androidx.annotation.Nullable
            T mLatest;
            final androidx.lifecycle.LifecycleOwner mLifecycle;
            final androidx.lifecycle.LiveData<T> mLiveData;
            boolean mObserving;
            long mRequested;
            final org.reactivestreams.Subscriber<? super T> mSubscriber;

            /* renamed from: androidx.lifecycle.LiveDataReactiveStreams$LiveDataPublisher$LiveDataSubscription$1, reason: invalid class name */
            public class AnonymousClass1 implements java.lang.Runnable {
                final /* synthetic */ long val$n;

                public AnonymousClass1(long j) {
                    this.val$n = j;
                }

                @Override // java.lang.Runnable
                public void run() {
                    if (androidx.lifecycle.LiveDataReactiveStreams.LiveDataPublisher.LiveDataSubscription.this.mCanceled) {
                        return;
                    }
                    long j = this.val$n;
                    if (j <= 0) {
                        androidx.lifecycle.LiveDataReactiveStreams.LiveDataPublisher.LiveDataSubscription.this.mCanceled = true;
                        androidx.lifecycle.LiveDataReactiveStreams.LiveDataPublisher.LiveDataSubscription liveDataSubscription = androidx.lifecycle.LiveDataReactiveStreams.LiveDataPublisher.LiveDataSubscription.this;
                        if (liveDataSubscription.mObserving) {
                            liveDataSubscription.mLiveData.removeObserver(liveDataSubscription);
                            androidx.lifecycle.LiveDataReactiveStreams.LiveDataPublisher.LiveDataSubscription.this.mObserving = false;
                        }
                        androidx.lifecycle.LiveDataReactiveStreams.LiveDataPublisher.LiveDataSubscription liveDataSubscription2 = androidx.lifecycle.LiveDataReactiveStreams.LiveDataPublisher.LiveDataSubscription.this;
                        liveDataSubscription2.mLatest = null;
                        liveDataSubscription2.mSubscriber.onError(new java.lang.IllegalArgumentException("Non-positive request"));
                        return;
                    }
                    androidx.lifecycle.LiveDataReactiveStreams.LiveDataPublisher.LiveDataSubscription liveDataSubscription3 = androidx.lifecycle.LiveDataReactiveStreams.LiveDataPublisher.LiveDataSubscription.this;
                    long j2 = liveDataSubscription3.mRequested;
                    liveDataSubscription3.mRequested = j2 + j >= j2 ? j2 + j : Long.MAX_VALUE;
                    if (!liveDataSubscription3.mObserving) {
                        liveDataSubscription3.mObserving = true;
                        liveDataSubscription3.mLiveData.observe(liveDataSubscription3.mLifecycle, liveDataSubscription3);
                        return;
                    }
                    T t = liveDataSubscription3.mLatest;
                    if (t != null) {
                        liveDataSubscription3.onChanged(t);
                        androidx.lifecycle.LiveDataReactiveStreams.LiveDataPublisher.LiveDataSubscription.this.mLatest = null;
                    }
                }
            }

            /* renamed from: androidx.lifecycle.LiveDataReactiveStreams$LiveDataPublisher$LiveDataSubscription$2, reason: invalid class name */
            public class AnonymousClass2 implements java.lang.Runnable {
                public AnonymousClass2() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    androidx.lifecycle.LiveDataReactiveStreams.LiveDataPublisher.LiveDataSubscription liveDataSubscription = androidx.lifecycle.LiveDataReactiveStreams.LiveDataPublisher.LiveDataSubscription.this;
                    if (liveDataSubscription.mObserving) {
                        liveDataSubscription.mLiveData.removeObserver(liveDataSubscription);
                        androidx.lifecycle.LiveDataReactiveStreams.LiveDataPublisher.LiveDataSubscription.this.mObserving = false;
                    }
                    androidx.lifecycle.LiveDataReactiveStreams.LiveDataPublisher.LiveDataSubscription.this.mLatest = null;
                }
            }

            public LiveDataSubscription(org.reactivestreams.Subscriber<? super T> subscriber, androidx.lifecycle.LifecycleOwner lifecycleOwner, androidx.lifecycle.LiveData<T> liveData) {
                this.mSubscriber = subscriber;
                this.mLifecycle = lifecycleOwner;
                this.mLiveData = liveData;
            }

            @Override // org.reactivestreams.Subscription
            public void cancel() {
                if (this.mCanceled) {
                    return;
                }
                this.mCanceled = true;
                androidx.arch.core.executor.ArchTaskExecutor.getInstance().executeOnMainThread(new androidx.lifecycle.LiveDataReactiveStreams.LiveDataPublisher.LiveDataSubscription.AnonymousClass2());
            }

            @Override // androidx.lifecycle.Observer
            public void onChanged(@androidx.annotation.Nullable T t) {
                if (this.mCanceled) {
                    return;
                }
                if (this.mRequested <= 0) {
                    this.mLatest = t;
                    return;
                }
                this.mLatest = null;
                this.mSubscriber.onNext(t);
                long j = this.mRequested;
                if (j != Long.MAX_VALUE) {
                    this.mRequested = j - 1;
                }
            }

            @Override // org.reactivestreams.Subscription
            public void request(long j) {
                if (this.mCanceled) {
                    return;
                }
                androidx.arch.core.executor.ArchTaskExecutor.getInstance().executeOnMainThread(new androidx.lifecycle.LiveDataReactiveStreams.LiveDataPublisher.LiveDataSubscription.AnonymousClass1(j));
            }
        }

        public LiveDataPublisher(androidx.lifecycle.LifecycleOwner lifecycleOwner, androidx.lifecycle.LiveData<T> liveData) {
            this.mLifecycle = lifecycleOwner;
            this.mLiveData = liveData;
        }

        @Override // org.reactivestreams.Publisher
        public void subscribe(org.reactivestreams.Subscriber<? super T> subscriber) {
            subscriber.onSubscribe(new androidx.lifecycle.LiveDataReactiveStreams.LiveDataPublisher.LiveDataSubscription(subscriber, this.mLifecycle, this.mLiveData));
        }
    }

    public static class PublisherLiveData<T> extends androidx.lifecycle.LiveData<T> {
        private final org.reactivestreams.Publisher<T> mPublisher;
        final java.util.concurrent.atomic.AtomicReference<androidx.lifecycle.LiveDataReactiveStreams.PublisherLiveData<T>.LiveDataSubscriber> mSubscriber = new java.util.concurrent.atomic.AtomicReference<>();

        public final class LiveDataSubscriber extends java.util.concurrent.atomic.AtomicReference<org.reactivestreams.Subscription> implements org.reactivestreams.Subscriber<T> {

            /* renamed from: androidx.lifecycle.LiveDataReactiveStreams$PublisherLiveData$LiveDataSubscriber$1, reason: invalid class name */
            public class AnonymousClass1 implements java.lang.Runnable {
                final /* synthetic */ java.lang.Throwable val$ex;

                public AnonymousClass1(java.lang.Throwable th) {
                    this.val$ex = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw new java.lang.RuntimeException("LiveData does not handle errors. Errors from publishers should be handled upstream and propagated as state", this.val$ex);
                }
            }

            public LiveDataSubscriber() {
            }

            public void cancelSubscription() {
                org.reactivestreams.Subscription subscription = get();
                if (subscription != null) {
                    subscription.cancel();
                }
            }

            @Override // org.reactivestreams.Subscriber
            public void onComplete() {
                defpackage.xv0.a(androidx.lifecycle.LiveDataReactiveStreams.PublisherLiveData.this.mSubscriber, this, null);
            }

            @Override // org.reactivestreams.Subscriber
            public void onError(java.lang.Throwable th) {
                defpackage.xv0.a(androidx.lifecycle.LiveDataReactiveStreams.PublisherLiveData.this.mSubscriber, this, null);
                androidx.arch.core.executor.ArchTaskExecutor.getInstance().executeOnMainThread(new androidx.lifecycle.LiveDataReactiveStreams.PublisherLiveData.LiveDataSubscriber.AnonymousClass1(th));
            }

            @Override // org.reactivestreams.Subscriber
            public void onNext(T t) {
                androidx.lifecycle.LiveDataReactiveStreams.PublisherLiveData.this.postValue(t);
            }

            @Override // org.reactivestreams.Subscriber
            public void onSubscribe(org.reactivestreams.Subscription subscription) {
                if (compareAndSet(null, subscription)) {
                    subscription.request(Long.MAX_VALUE);
                } else {
                    subscription.cancel();
                }
            }
        }

        public PublisherLiveData(@androidx.annotation.NonNull org.reactivestreams.Publisher<T> publisher) {
            this.mPublisher = publisher;
        }

        @Override // androidx.lifecycle.LiveData
        public void onActive() {
            super.onActive();
            androidx.lifecycle.LiveDataReactiveStreams.PublisherLiveData<T>.LiveDataSubscriber liveDataSubscriber = new androidx.lifecycle.LiveDataReactiveStreams.PublisherLiveData.LiveDataSubscriber();
            this.mSubscriber.set(liveDataSubscriber);
            this.mPublisher.subscribe(liveDataSubscriber);
        }

        @Override // androidx.lifecycle.LiveData
        public void onInactive() {
            super.onInactive();
            androidx.lifecycle.LiveDataReactiveStreams.PublisherLiveData<T>.LiveDataSubscriber andSet = this.mSubscriber.getAndSet(null);
            if (andSet != null) {
                andSet.cancelSubscription();
            }
        }
    }

    private LiveDataReactiveStreams() {
    }

    @androidx.annotation.NonNull
    public static <T> androidx.lifecycle.LiveData<T> fromPublisher(@androidx.annotation.NonNull org.reactivestreams.Publisher<T> publisher) {
        return new androidx.lifecycle.LiveDataReactiveStreams.PublisherLiveData(publisher);
    }

    @androidx.annotation.NonNull
    public static <T> org.reactivestreams.Publisher<T> toPublisher(@androidx.annotation.NonNull androidx.lifecycle.LifecycleOwner lifecycleOwner, @androidx.annotation.NonNull androidx.lifecycle.LiveData<T> liveData) {
        return new androidx.lifecycle.LiveDataReactiveStreams.LiveDataPublisher(lifecycleOwner, liveData);
    }
}
