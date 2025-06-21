package io.reactivex.disposables;

/* loaded from: classes9.dex */
final class SubscriptionDisposable extends io.reactivex.disposables.ReferenceDisposable<org.reactivestreams.Subscription> {
    private static final long serialVersionUID = -707001650852963139L;

    public SubscriptionDisposable(org.reactivestreams.Subscription subscription) {
        super(subscription);
    }

    @Override // io.reactivex.disposables.ReferenceDisposable
    public void onDisposed(@io.reactivex.annotations.NonNull org.reactivestreams.Subscription subscription) {
        subscription.cancel();
    }
}
