package com.alimm.tanx.ui.image.glide.request;

/* loaded from: classes.dex */
public class ThumbnailRequestCoordinator implements com.alimm.tanx.ui.image.glide.request.RequestCoordinator, com.alimm.tanx.ui.image.glide.request.Request {
    private com.alimm.tanx.ui.image.glide.request.RequestCoordinator coordinator;
    private com.alimm.tanx.ui.image.glide.request.Request full;
    private com.alimm.tanx.ui.image.glide.request.Request thumb;

    public ThumbnailRequestCoordinator() {
        this(null);
    }

    public ThumbnailRequestCoordinator(com.alimm.tanx.ui.image.glide.request.RequestCoordinator requestCoordinator) {
        this.coordinator = requestCoordinator;
    }

    private boolean parentCanNotifyStatusChanged() {
        com.alimm.tanx.ui.image.glide.request.RequestCoordinator requestCoordinator = this.coordinator;
        return requestCoordinator == null || requestCoordinator.canNotifyStatusChanged(this);
    }

    private boolean parentCanSetImage() {
        com.alimm.tanx.ui.image.glide.request.RequestCoordinator requestCoordinator = this.coordinator;
        return requestCoordinator == null || requestCoordinator.canSetImage(this);
    }

    private boolean parentIsAnyResourceSet() {
        com.alimm.tanx.ui.image.glide.request.RequestCoordinator requestCoordinator = this.coordinator;
        return requestCoordinator != null && requestCoordinator.isAnyResourceSet();
    }

    @Override // com.alimm.tanx.ui.image.glide.request.Request
    public void begin() {
        if (!this.thumb.isRunning()) {
            this.thumb.begin();
        }
        if (this.full.isRunning()) {
            return;
        }
        this.full.begin();
    }

    @Override // com.alimm.tanx.ui.image.glide.request.RequestCoordinator
    public boolean canNotifyStatusChanged(com.alimm.tanx.ui.image.glide.request.Request request) {
        return parentCanNotifyStatusChanged() && request.equals(this.full) && !isAnyResourceSet();
    }

    @Override // com.alimm.tanx.ui.image.glide.request.RequestCoordinator
    public boolean canSetImage(com.alimm.tanx.ui.image.glide.request.Request request) {
        return parentCanSetImage() && (request.equals(this.full) || !this.full.isResourceSet());
    }

    @Override // com.alimm.tanx.ui.image.glide.request.Request
    public void clear() {
        this.thumb.clear();
        this.full.clear();
    }

    @Override // com.alimm.tanx.ui.image.glide.request.RequestCoordinator
    public boolean isAnyResourceSet() {
        return parentIsAnyResourceSet() || isResourceSet();
    }

    @Override // com.alimm.tanx.ui.image.glide.request.Request
    public boolean isCancelled() {
        return this.full.isCancelled();
    }

    @Override // com.alimm.tanx.ui.image.glide.request.Request
    public boolean isComplete() {
        return this.full.isComplete() || this.thumb.isComplete();
    }

    @Override // com.alimm.tanx.ui.image.glide.request.Request
    public boolean isFailed() {
        return this.full.isFailed();
    }

    @Override // com.alimm.tanx.ui.image.glide.request.Request
    public boolean isPaused() {
        return this.full.isPaused();
    }

    @Override // com.alimm.tanx.ui.image.glide.request.Request
    public boolean isResourceSet() {
        return this.full.isResourceSet() || this.thumb.isResourceSet();
    }

    @Override // com.alimm.tanx.ui.image.glide.request.Request
    public boolean isRunning() {
        return this.full.isRunning();
    }

    @Override // com.alimm.tanx.ui.image.glide.request.RequestCoordinator
    public void onRequestSuccess(com.alimm.tanx.ui.image.glide.request.Request request) {
        if (request.equals(this.thumb)) {
            return;
        }
        com.alimm.tanx.ui.image.glide.request.RequestCoordinator requestCoordinator = this.coordinator;
        if (requestCoordinator != null) {
            requestCoordinator.onRequestSuccess(this);
        }
        if (this.thumb.isComplete()) {
            return;
        }
        this.thumb.clear();
    }

    @Override // com.alimm.tanx.ui.image.glide.request.Request
    public void pause() {
        this.full.pause();
        this.thumb.pause();
    }

    @Override // com.alimm.tanx.ui.image.glide.request.Request
    public void recycle() {
        this.full.recycle();
        this.thumb.recycle();
    }

    public void setRequests(com.alimm.tanx.ui.image.glide.request.Request request, com.alimm.tanx.ui.image.glide.request.Request request2) {
        this.full = request;
        this.thumb = request2;
    }
}
