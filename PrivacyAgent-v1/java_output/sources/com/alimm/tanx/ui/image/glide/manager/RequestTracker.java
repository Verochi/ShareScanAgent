package com.alimm.tanx.ui.image.glide.manager;

/* loaded from: classes.dex */
public class RequestTracker {
    private boolean isPaused;
    private final java.util.Set<com.alimm.tanx.ui.image.glide.request.Request> requests = java.util.Collections.newSetFromMap(new java.util.WeakHashMap());
    private final java.util.List<com.alimm.tanx.ui.image.glide.request.Request> pendingRequests = new java.util.ArrayList();

    public void addRequest(com.alimm.tanx.ui.image.glide.request.Request request) {
        this.requests.add(request);
    }

    public void clearRequests() {
        java.util.Iterator it = com.alimm.tanx.ui.image.glide.util.Util.getSnapshot(this.requests).iterator();
        while (it.hasNext()) {
            ((com.alimm.tanx.ui.image.glide.request.Request) it.next()).clear();
        }
        this.pendingRequests.clear();
    }

    public boolean isPaused() {
        return this.isPaused;
    }

    public void pauseRequests() {
        this.isPaused = true;
        for (com.alimm.tanx.ui.image.glide.request.Request request : com.alimm.tanx.ui.image.glide.util.Util.getSnapshot(this.requests)) {
            if (request.isRunning()) {
                request.pause();
                this.pendingRequests.add(request);
            }
        }
    }

    public void removeRequest(com.alimm.tanx.ui.image.glide.request.Request request) {
        this.requests.remove(request);
        this.pendingRequests.remove(request);
    }

    public void restartRequests() {
        for (com.alimm.tanx.ui.image.glide.request.Request request : com.alimm.tanx.ui.image.glide.util.Util.getSnapshot(this.requests)) {
            if (!request.isComplete() && !request.isCancelled()) {
                request.pause();
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
        for (com.alimm.tanx.ui.image.glide.request.Request request : com.alimm.tanx.ui.image.glide.util.Util.getSnapshot(this.requests)) {
            if (!request.isComplete() && !request.isCancelled() && !request.isRunning()) {
                request.begin();
            }
        }
        this.pendingRequests.clear();
    }

    public void runRequest(com.alimm.tanx.ui.image.glide.request.Request request) {
        this.requests.add(request);
        if (this.isPaused) {
            this.pendingRequests.add(request);
        } else {
            request.begin();
        }
    }
}
