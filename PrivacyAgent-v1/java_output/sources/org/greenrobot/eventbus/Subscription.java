package org.greenrobot.eventbus;

/* loaded from: classes26.dex */
final class Subscription {
    public final java.lang.Object a;
    public final org.greenrobot.eventbus.SubscriberMethod b;
    public volatile boolean c = true;

    public Subscription(java.lang.Object obj, org.greenrobot.eventbus.SubscriberMethod subscriberMethod) {
        this.a = obj;
        this.b = subscriberMethod;
    }

    public boolean equals(java.lang.Object obj) {
        if (!(obj instanceof org.greenrobot.eventbus.Subscription)) {
            return false;
        }
        org.greenrobot.eventbus.Subscription subscription = (org.greenrobot.eventbus.Subscription) obj;
        return this.a == subscription.a && this.b.equals(subscription.b);
    }

    public int hashCode() {
        return this.a.hashCode() + this.b.f.hashCode();
    }
}
