package org.greenrobot.eventbus;

/* loaded from: classes26.dex */
final class BackgroundPoster implements java.lang.Runnable, org.greenrobot.eventbus.Poster {
    public final org.greenrobot.eventbus.PendingPostQueue n = new org.greenrobot.eventbus.PendingPostQueue();
    public final org.greenrobot.eventbus.EventBus t;
    public volatile boolean u;

    public BackgroundPoster(org.greenrobot.eventbus.EventBus eventBus) {
        this.t = eventBus;
    }

    @Override // org.greenrobot.eventbus.Poster
    public void enqueue(org.greenrobot.eventbus.Subscription subscription, java.lang.Object obj) {
        org.greenrobot.eventbus.PendingPost a = org.greenrobot.eventbus.PendingPost.a(subscription, obj);
        synchronized (this) {
            this.n.a(a);
            if (!this.u) {
                this.u = true;
                this.t.c().execute(this);
            }
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        while (true) {
            try {
                org.greenrobot.eventbus.PendingPost c = this.n.c(1000);
                if (c == null) {
                    synchronized (this) {
                        c = this.n.b();
                        if (c == null) {
                            return;
                        }
                    }
                }
                this.t.e(c);
            } catch (java.lang.InterruptedException e) {
                this.t.getLogger().log(java.util.logging.Level.WARNING, java.lang.Thread.currentThread().getName() + " was interruppted", e);
                return;
            } finally {
                this.u = false;
            }
        }
    }
}
