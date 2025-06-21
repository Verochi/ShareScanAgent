package com.bumptech.glide.request;

/* loaded from: classes.dex */
public class ThumbnailRequestCoordinator implements com.bumptech.glide.request.RequestCoordinator, com.bumptech.glide.request.Request {
    private volatile com.bumptech.glide.request.Request full;

    @androidx.annotation.GuardedBy("requestLock")
    private com.bumptech.glide.request.RequestCoordinator.RequestState fullState;

    @androidx.annotation.GuardedBy("requestLock")
    private boolean isRunningDuringBegin;

    @androidx.annotation.Nullable
    private final com.bumptech.glide.request.RequestCoordinator parent;
    private final java.lang.Object requestLock;
    private volatile com.bumptech.glide.request.Request thumb;

    @androidx.annotation.GuardedBy("requestLock")
    private com.bumptech.glide.request.RequestCoordinator.RequestState thumbState;

    public ThumbnailRequestCoordinator(java.lang.Object obj, @androidx.annotation.Nullable com.bumptech.glide.request.RequestCoordinator requestCoordinator) {
        com.bumptech.glide.request.RequestCoordinator.RequestState requestState = com.bumptech.glide.request.RequestCoordinator.RequestState.CLEARED;
        this.fullState = requestState;
        this.thumbState = requestState;
        this.requestLock = obj;
        this.parent = requestCoordinator;
    }

    @androidx.annotation.GuardedBy("requestLock")
    private boolean parentCanNotifyCleared() {
        com.bumptech.glide.request.RequestCoordinator requestCoordinator = this.parent;
        return requestCoordinator == null || requestCoordinator.canNotifyCleared(this);
    }

    @androidx.annotation.GuardedBy("requestLock")
    private boolean parentCanNotifyStatusChanged() {
        com.bumptech.glide.request.RequestCoordinator requestCoordinator = this.parent;
        return requestCoordinator == null || requestCoordinator.canNotifyStatusChanged(this);
    }

    @androidx.annotation.GuardedBy("requestLock")
    private boolean parentCanSetImage() {
        com.bumptech.glide.request.RequestCoordinator requestCoordinator = this.parent;
        return requestCoordinator == null || requestCoordinator.canSetImage(this);
    }

    @Override // com.bumptech.glide.request.Request
    public void begin() {
        synchronized (this.requestLock) {
            this.isRunningDuringBegin = true;
            try {
                if (this.fullState != com.bumptech.glide.request.RequestCoordinator.RequestState.SUCCESS) {
                    com.bumptech.glide.request.RequestCoordinator.RequestState requestState = this.thumbState;
                    com.bumptech.glide.request.RequestCoordinator.RequestState requestState2 = com.bumptech.glide.request.RequestCoordinator.RequestState.RUNNING;
                    if (requestState != requestState2) {
                        this.thumbState = requestState2;
                        this.thumb.begin();
                    }
                }
                if (this.isRunningDuringBegin) {
                    com.bumptech.glide.request.RequestCoordinator.RequestState requestState3 = this.fullState;
                    com.bumptech.glide.request.RequestCoordinator.RequestState requestState4 = com.bumptech.glide.request.RequestCoordinator.RequestState.RUNNING;
                    if (requestState3 != requestState4) {
                        this.fullState = requestState4;
                        this.full.begin();
                    }
                }
            } finally {
                this.isRunningDuringBegin = false;
            }
        }
    }

    @Override // com.bumptech.glide.request.RequestCoordinator
    public boolean canNotifyCleared(com.bumptech.glide.request.Request request) {
        boolean z;
        synchronized (this.requestLock) {
            z = parentCanNotifyCleared() && request.equals(this.full) && this.fullState != com.bumptech.glide.request.RequestCoordinator.RequestState.PAUSED;
        }
        return z;
    }

    @Override // com.bumptech.glide.request.RequestCoordinator
    public boolean canNotifyStatusChanged(com.bumptech.glide.request.Request request) {
        boolean z;
        synchronized (this.requestLock) {
            z = parentCanNotifyStatusChanged() && request.equals(this.full) && !isAnyResourceSet();
        }
        return z;
    }

    @Override // com.bumptech.glide.request.RequestCoordinator
    public boolean canSetImage(com.bumptech.glide.request.Request request) {
        boolean z;
        synchronized (this.requestLock) {
            z = parentCanSetImage() && (request.equals(this.full) || this.fullState != com.bumptech.glide.request.RequestCoordinator.RequestState.SUCCESS);
        }
        return z;
    }

    @Override // com.bumptech.glide.request.Request
    public void clear() {
        synchronized (this.requestLock) {
            this.isRunningDuringBegin = false;
            com.bumptech.glide.request.RequestCoordinator.RequestState requestState = com.bumptech.glide.request.RequestCoordinator.RequestState.CLEARED;
            this.fullState = requestState;
            this.thumbState = requestState;
            this.thumb.clear();
            this.full.clear();
        }
    }

    @Override // com.bumptech.glide.request.RequestCoordinator
    public com.bumptech.glide.request.RequestCoordinator getRoot() {
        com.bumptech.glide.request.RequestCoordinator root;
        synchronized (this.requestLock) {
            com.bumptech.glide.request.RequestCoordinator requestCoordinator = this.parent;
            root = requestCoordinator != null ? requestCoordinator.getRoot() : this;
        }
        return root;
    }

    @Override // com.bumptech.glide.request.RequestCoordinator, com.bumptech.glide.request.Request
    public boolean isAnyResourceSet() {
        boolean z;
        synchronized (this.requestLock) {
            z = this.thumb.isAnyResourceSet() || this.full.isAnyResourceSet();
        }
        return z;
    }

    @Override // com.bumptech.glide.request.Request
    public boolean isCleared() {
        boolean z;
        synchronized (this.requestLock) {
            z = this.fullState == com.bumptech.glide.request.RequestCoordinator.RequestState.CLEARED;
        }
        return z;
    }

    @Override // com.bumptech.glide.request.Request
    public boolean isComplete() {
        boolean z;
        synchronized (this.requestLock) {
            z = this.fullState == com.bumptech.glide.request.RequestCoordinator.RequestState.SUCCESS;
        }
        return z;
    }

    @Override // com.bumptech.glide.request.Request
    public boolean isEquivalentTo(com.bumptech.glide.request.Request request) {
        if (!(request instanceof com.bumptech.glide.request.ThumbnailRequestCoordinator)) {
            return false;
        }
        com.bumptech.glide.request.ThumbnailRequestCoordinator thumbnailRequestCoordinator = (com.bumptech.glide.request.ThumbnailRequestCoordinator) request;
        if (this.full == null) {
            if (thumbnailRequestCoordinator.full != null) {
                return false;
            }
        } else if (!this.full.isEquivalentTo(thumbnailRequestCoordinator.full)) {
            return false;
        }
        if (this.thumb == null) {
            if (thumbnailRequestCoordinator.thumb != null) {
                return false;
            }
        } else if (!this.thumb.isEquivalentTo(thumbnailRequestCoordinator.thumb)) {
            return false;
        }
        return true;
    }

    @Override // com.bumptech.glide.request.Request
    public boolean isRunning() {
        boolean z;
        synchronized (this.requestLock) {
            z = this.fullState == com.bumptech.glide.request.RequestCoordinator.RequestState.RUNNING;
        }
        return z;
    }

    @Override // com.bumptech.glide.request.RequestCoordinator
    public void onRequestFailed(com.bumptech.glide.request.Request request) {
        synchronized (this.requestLock) {
            if (!request.equals(this.full)) {
                this.thumbState = com.bumptech.glide.request.RequestCoordinator.RequestState.FAILED;
                return;
            }
            this.fullState = com.bumptech.glide.request.RequestCoordinator.RequestState.FAILED;
            com.bumptech.glide.request.RequestCoordinator requestCoordinator = this.parent;
            if (requestCoordinator != null) {
                requestCoordinator.onRequestFailed(this);
            }
        }
    }

    @Override // com.bumptech.glide.request.RequestCoordinator
    public void onRequestSuccess(com.bumptech.glide.request.Request request) {
        synchronized (this.requestLock) {
            if (request.equals(this.thumb)) {
                this.thumbState = com.bumptech.glide.request.RequestCoordinator.RequestState.SUCCESS;
                return;
            }
            this.fullState = com.bumptech.glide.request.RequestCoordinator.RequestState.SUCCESS;
            com.bumptech.glide.request.RequestCoordinator requestCoordinator = this.parent;
            if (requestCoordinator != null) {
                requestCoordinator.onRequestSuccess(this);
            }
            if (!this.thumbState.isComplete()) {
                this.thumb.clear();
            }
        }
    }

    @Override // com.bumptech.glide.request.Request
    public void pause() {
        synchronized (this.requestLock) {
            if (!this.thumbState.isComplete()) {
                this.thumbState = com.bumptech.glide.request.RequestCoordinator.RequestState.PAUSED;
                this.thumb.pause();
            }
            if (!this.fullState.isComplete()) {
                this.fullState = com.bumptech.glide.request.RequestCoordinator.RequestState.PAUSED;
                this.full.pause();
            }
        }
    }

    public void setRequests(com.bumptech.glide.request.Request request, com.bumptech.glide.request.Request request2) {
        this.full = request;
        this.thumb = request2;
    }
}
