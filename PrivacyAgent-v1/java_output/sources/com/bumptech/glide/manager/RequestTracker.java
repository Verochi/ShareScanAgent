package com.bumptech.glide.manager;

/* loaded from: classes.dex */
public class RequestTracker {
    private static final java.lang.String TAG = "RequestTracker";
    private boolean isPaused;
    private final java.util.Set<com.bumptech.glide.request.Request> requests = java.util.Collections.newSetFromMap(new java.util.WeakHashMap());
    private final java.util.List<com.bumptech.glide.request.Request> pendingRequests = new java.util.ArrayList();

    @androidx.annotation.VisibleForTesting
    public void addRequest(com.bumptech.glide.request.Request request) {
        this.requests.add(request);
    }

    public boolean clearAndRemove(@androidx.annotation.Nullable com.bumptech.glide.request.Request request) {
        boolean z = true;
        if (request == null) {
            return true;
        }
        boolean remove = this.requests.remove(request);
        if (!this.pendingRequests.remove(request) && !remove) {
            z = false;
        }
        if (z) {
            request.clear();
        }
        return z;
    }

    public void clearRequests() {
        java.util.Iterator it = com.bumptech.glide.util.Util.getSnapshot(this.requests).iterator();
        while (it.hasNext()) {
            clearAndRemove((com.bumptech.glide.request.Request) it.next());
        }
        this.pendingRequests.clear();
    }

    public boolean isPaused() {
        return this.isPaused;
    }

    public void pauseAllRequests() {
        this.isPaused = true;
        for (com.bumptech.glide.request.Request request : com.bumptech.glide.util.Util.getSnapshot(this.requests)) {
            if (request.isRunning() || request.isComplete()) {
                request.clear();
                this.pendingRequests.add(request);
            }
        }
    }

    public void pauseRequests() {
        this.isPaused = true;
        for (com.bumptech.glide.request.Request request : com.bumptech.glide.util.Util.getSnapshot(this.requests)) {
            if (request.isRunning()) {
                request.pause();
                this.pendingRequests.add(request);
            }
        }
    }

    public void restartRequests() {
        for (com.bumptech.glide.request.Request request : com.bumptech.glide.util.Util.getSnapshot(this.requests)) {
            if (!request.isComplete() && !request.isCleared()) {
                request.clear();
                if (this.isPaused) {
                    this.pendingRequests.add(request);
                } else {
                    request.begin();
                }
            }
        }
    }

    public void resumeRequests() {
        this.isPaused = false;
        for (com.bumptech.glide.request.Request request : com.bumptech.glide.util.Util.getSnapshot(this.requests)) {
            if (!request.isComplete() && !request.isRunning()) {
                request.begin();
            }
        }
        this.pendingRequests.clear();
    }

    public void runRequest(@androidx.annotation.NonNull com.bumptech.glide.request.Request request) {
        this.requests.add(request);
        if (!this.isPaused) {
            request.begin();
        } else {
            request.clear();
            this.pendingRequests.add(request);
        }
    }

    public java.lang.String toString() {
        return super.toString() + "{numRequests=" + this.requests.size() + ", isPaused=" + this.isPaused + com.alipay.sdk.m.u.i.d;
    }
}
