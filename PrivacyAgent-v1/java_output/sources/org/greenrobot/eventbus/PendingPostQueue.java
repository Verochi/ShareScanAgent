package org.greenrobot.eventbus;

/* loaded from: classes26.dex */
final class PendingPostQueue {
    public org.greenrobot.eventbus.PendingPost a;
    public org.greenrobot.eventbus.PendingPost b;

    public synchronized void a(org.greenrobot.eventbus.PendingPost pendingPost) {
        try {
            if (pendingPost == null) {
                throw new java.lang.NullPointerException("null cannot be enqueued");
            }
            org.greenrobot.eventbus.PendingPost pendingPost2 = this.b;
            if (pendingPost2 != null) {
                pendingPost2.c = pendingPost;
                this.b = pendingPost;
            } else {
                if (this.a != null) {
                    throw new java.lang.IllegalStateException("Head present, but no tail");
                }
                this.b = pendingPost;
                this.a = pendingPost;
            }
            notifyAll();
        } catch (java.lang.Throwable th) {
            throw th;
        }
    }

    public synchronized org.greenrobot.eventbus.PendingPost b() {
        org.greenrobot.eventbus.PendingPost pendingPost;
        pendingPost = this.a;
        if (pendingPost != null) {
            org.greenrobot.eventbus.PendingPost pendingPost2 = pendingPost.c;
            this.a = pendingPost2;
            if (pendingPost2 == null) {
                this.b = null;
            }
        }
        return pendingPost;
    }

    public synchronized org.greenrobot.eventbus.PendingPost c(int i) throws java.lang.InterruptedException {
        if (this.a == null) {
            wait(i);
        }
        return b();
    }
}
