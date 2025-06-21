package org.greenrobot.eventbus;

/* loaded from: classes26.dex */
final class PendingPost {
    public static final java.util.List<org.greenrobot.eventbus.PendingPost> d = new java.util.ArrayList();
    public java.lang.Object a;
    public org.greenrobot.eventbus.Subscription b;
    public org.greenrobot.eventbus.PendingPost c;

    public PendingPost(java.lang.Object obj, org.greenrobot.eventbus.Subscription subscription) {
        this.a = obj;
        this.b = subscription;
    }

    public static org.greenrobot.eventbus.PendingPost a(org.greenrobot.eventbus.Subscription subscription, java.lang.Object obj) {
        java.util.List<org.greenrobot.eventbus.PendingPost> list = d;
        synchronized (list) {
            int size = list.size();
            if (size <= 0) {
                return new org.greenrobot.eventbus.PendingPost(obj, subscription);
            }
            org.greenrobot.eventbus.PendingPost remove = list.remove(size - 1);
            remove.a = obj;
            remove.b = subscription;
            remove.c = null;
            return remove;
        }
    }

    public static void b(org.greenrobot.eventbus.PendingPost pendingPost) {
        pendingPost.a = null;
        pendingPost.b = null;
        pendingPost.c = null;
        java.util.List<org.greenrobot.eventbus.PendingPost> list = d;
        synchronized (list) {
            if (list.size() < 10000) {
                list.add(pendingPost);
            }
        }
    }
}
