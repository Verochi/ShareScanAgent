package com.bumptech.glide.request;

/* loaded from: classes.dex */
public final class ErrorRequestCoordinator implements com.bumptech.glide.request.RequestCoordinator, com.bumptech.glide.request.Request {
    private volatile com.bumptech.glide.request.Request error;

    @androidx.annotation.GuardedBy("requestLock")
    private com.bumptech.glide.request.RequestCoordinator.RequestState errorState;

    @androidx.annotation.Nullable
    private final com.bumptech.glide.request.RequestCoordinator parent;
    private volatile com.bumptech.glide.request.Request primary;

    @androidx.annotation.GuardedBy("requestLock")
    private com.bumptech.glide.request.RequestCoordinator.RequestState primaryState;
    private final java.lang.Object requestLock;

    public ErrorRequestCoordinator(java.lang.Object obj, @androidx.annotation.Nullable com.bumptech.glide.request.RequestCoordinator requestCoordinator) {
        com.bumptech.glide.request.RequestCoordinator.RequestState requestState = com.bumptech.glide.request.RequestCoordinator.RequestState.CLEARED;
        this.primaryState = requestState;
        this.errorState = requestState;
        this.requestLock = obj;
        this.parent = requestCoordinator;
    }

    @androidx.annotation.GuardedBy("requestLock")
    private boolean isValidRequest(com.bumptech.glide.request.Request request) {
        return request.equals(this.primary) || (this.primaryState == com.bumptech.glide.request.RequestCoordinator.RequestState.FAILED && request.equals(this.error));
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
            com.bumptech.glide.request.RequestCoordinator.RequestState requestState = this.primaryState;
            com.bumptech.glide.request.RequestCoordinator.RequestState requestState2 = com.bumptech.glide.request.RequestCoordinator.RequestState.RUNNING;
            if (requestState != requestState2) {
                this.primaryState = requestState2;
                this.primary.begin();
            }
        }
    }

    @Override // com.bumptech.glide.request.RequestCoordinator
    public boolean canNotifyCleared(com.bumptech.glide.request.Request request) {
        boolean z;
        synchronized (this.requestLock) {
            z = parentCanNotifyCleared() && isValidRequest(request);
        }
        return z;
    }

    @Override // com.bumptech.glide.request.RequestCoordinator
    public boolean canNotifyStatusChanged(com.bumptech.glide.request.Request request) {
        boolean z;
        synchronized (this.requestLock) {
            z = parentCanNotifyStatusChanged() && isValidRequest(request);
        }
        return z;
    }

    @Override // com.bumptech.glide.request.RequestCoordinator
    public boolean canSetImage(com.bumptech.glide.request.Request request) {
        boolean z;
        synchronized (this.requestLock) {
            z = parentCanSetImage() && isValidRequest(request);
        }
        return z;
    }

    @Override // com.bumptech.glide.request.Request
    public void clear() {
        synchronized (this.requestLock) {
            com.bumptech.glide.request.RequestCoordinator.RequestState requestState = com.bumptech.glide.request.RequestCoordinator.RequestState.CLEARED;
            this.primaryState = requestState;
            this.primary.clear();
            if (this.errorState != requestState) {
                this.errorState = requestState;
                this.error.clear();
            }
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
            z = this.primary.isAnyResourceSet() || this.error.isAnyResourceSet();
        }
        return z;
    }

    @Override // com.bumptech.glide.request.Request
    public boolean isCleared() {
        boolean z;
        synchronized (this.requestLock) {
            com.bumptech.glide.request.RequestCoordinator.RequestState requestState = this.primaryState;
            com.bumptech.glide.request.RequestCoordinator.RequestState requestState2 = com.bumptech.glide.request.RequestCoordinator.RequestState.CLEARED;
            z = requestState == requestState2 && this.errorState == requestState2;
        }
        return z;
    }

    @Override // com.bumptech.glide.request.Request
    public boolean isComplete() {
        boolean z;
        synchronized (this.requestLock) {
            com.bumptech.glide.request.RequestCoordinator.RequestState requestState = this.primaryState;
            com.bumptech.glide.request.RequestCoordinator.RequestState requestState2 = com.bumptech.glide.request.RequestCoordinator.RequestState.SUCCESS;
            z = requestState == requestState2 || this.errorState == requestState2;
        }
        return z;
    }

    @Override // com.bumptech.glide.request.Request
    public boolean isEquivalentTo(com.bumptech.glide.request.Request request) {
        if (!(request instanceof com.bumptech.glide.request.ErrorRequestCoordinator)) {
            return false;
        }
        com.bumptech.glide.request.ErrorRequestCoordinator errorRequestCoordinator = (com.bumptech.glide.request.ErrorRequestCoordinator) request;
        return this.primary.isEquivalentTo(errorRequestCoordinator.primary) && this.error.isEquivalentTo(errorRequestCoordinator.error);
    }

    @Override // com.bumptech.glide.request.Request
    public boolean isRunning() {
        boolean z;
        synchronized (this.requestLock) {
            com.bumptech.glide.request.RequestCoordinator.RequestState requestState = this.primaryState;
            com.bumptech.glide.request.RequestCoordinator.RequestState requestState2 = com.bumptech.glide.request.RequestCoordinator.RequestState.RUNNING;
            z = requestState == requestState2 || this.errorState == requestState2;
        }
        return z;
    }

    @Override // com.bumptech.glide.request.RequestCoordinator
    public void onRequestFailed(com.bumptech.glide.request.Request request) {
        synchronized (this.requestLock) {
            if (request.equals(this.error)) {
                this.errorState = com.bumptech.glide.request.RequestCoordinator.RequestState.FAILED;
                com.bumptech.glide.request.RequestCoordinator requestCoordinator = this.parent;
                if (requestCoordinator != null) {
                    requestCoordinator.onRequestFailed(this);
                }
                return;
            }
            this.primaryState = com.bumptech.glide.request.RequestCoordinator.RequestState.FAILED;
            com.bumptech.glide.request.RequestCoordinator.RequestState requestState = this.errorState;
            com.bumptech.glide.request.RequestCoordinator.RequestState requestState2 = com.bumptech.glide.request.RequestCoordinator.RequestState.RUNNING;
            if (requestState != requestState2) {
                this.errorState = requestState2;
                this.error.begin();
            }
        }
    }

    @Override // com.bumptech.glide.request.RequestCoordinator
    public void onRequestSuccess(com.bumptech.glide.request.Request request) {
        synchronized (this.requestLock) {
            if (request.equals(this.primary)) {
                this.primaryState = com.bumptech.glide.request.RequestCoordinator.RequestState.SUCCESS;
            } else if (request.equals(this.error)) {
                this.errorState = com.bumptech.glide.request.RequestCoordinator.RequestState.SUCCESS;
            }
            com.bumptech.glide.request.RequestCoordinator requestCoordinator = this.parent;
            if (requestCoordinator != null) {
                requestCoordinator.onRequestSuccess(this);
            }
        }
    }

    @Override // com.bumptech.glide.request.Request
    public void pause() {
        synchronized (this.requestLock) {
            com.bumptech.glide.request.RequestCoordinator.RequestState requestState = this.primaryState;
            com.bumptech.glide.request.RequestCoordinator.RequestState requestState2 = com.bumptech.glide.request.RequestCoordinator.RequestState.RUNNING;
            if (requestState == requestState2) {
                this.primaryState = com.bumptech.glide.request.RequestCoordinator.RequestState.PAUSED;
                this.primary.pause();
            }
            if (this.errorState == requestState2) {
                this.errorState = com.bumptech.glide.request.RequestCoordinator.RequestState.PAUSED;
                this.error.pause();
            }
        }
    }

    public void setRequests(com.bumptech.glide.request.Request request, com.bumptech.glide.request.Request request2) {
        this.primary = request;
        this.error = request2;
    }
}
