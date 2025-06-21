package org.greenrobot.eventbus;

/* loaded from: classes26.dex */
class AsyncPoster implements java.lang.Runnable, org.greenrobot.eventbus.Poster {
    public final org.greenrobot.eventbus.PendingPostQueue n = new org.greenrobot.eventbus.PendingPostQueue();
    public final org.greenrobot.eventbus.EventBus t;

    public AsyncPoster(org.greenrobot.eventbus.EventBus eventBus) {
        this.t = eventBus;
    }

    @Override // org.greenrobot.eventbus.Poster
    public void enqueue(org.greenrobot.eventbus.Subscription subscription, java.lang.Object obj) {
        this.n.a(org.greenrobot.eventbus.PendingPost.a(subscription, obj));
        this.t.c().execute(this);
    }

    @Override // java.lang.Runnable
    public void run() {
        org.greenrobot.eventbus.PendingPost b = this.n.b();
        if (b == null) {
            throw new java.lang.IllegalStateException("No pending post available");
        }
        this.t.e(b);
    }
}
