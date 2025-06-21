package org.greenrobot.eventbus;

/* loaded from: classes26.dex */
public class HandlerPoster extends android.os.Handler implements org.greenrobot.eventbus.Poster {
    public final org.greenrobot.eventbus.PendingPostQueue n;
    public final int t;
    public final org.greenrobot.eventbus.EventBus u;
    public boolean v;

    public HandlerPoster(org.greenrobot.eventbus.EventBus eventBus, android.os.Looper looper, int i) {
        super(looper);
        this.u = eventBus;
        this.t = i;
        this.n = new org.greenrobot.eventbus.PendingPostQueue();
    }

    @Override // org.greenrobot.eventbus.Poster
    public void enqueue(org.greenrobot.eventbus.Subscription subscription, java.lang.Object obj) {
        org.greenrobot.eventbus.PendingPost a = org.greenrobot.eventbus.PendingPost.a(subscription, obj);
        synchronized (this) {
            this.n.a(a);
            if (!this.v) {
                this.v = true;
                if (!sendMessage(obtainMessage())) {
                    throw new org.greenrobot.eventbus.EventBusException("Could not send handler message");
                }
            }
        }
    }

    @Override // android.os.Handler
    public void handleMessage(android.os.Message message) {
        try {
            long uptimeMillis = android.os.SystemClock.uptimeMillis();
            do {
                org.greenrobot.eventbus.PendingPost b = this.n.b();
                if (b == null) {
                    synchronized (this) {
                        b = this.n.b();
                        if (b == null) {
                            return;
                        }
                    }
                }
                this.u.e(b);
            } while (android.os.SystemClock.uptimeMillis() - uptimeMillis < this.t);
            if (!sendMessage(obtainMessage())) {
                throw new org.greenrobot.eventbus.EventBusException("Could not send handler message");
            }
            this.v = true;
        } finally {
            this.v = false;
        }
    }
}
