package com.alimm.tanx.ui.image.glide.request.target;

/* loaded from: classes.dex */
public abstract class BaseTarget<Z> implements com.alimm.tanx.ui.image.glide.request.target.Target<Z> {
    private com.alimm.tanx.ui.image.glide.request.Request request;

    @Override // com.alimm.tanx.ui.image.glide.request.target.Target
    public com.alimm.tanx.ui.image.glide.request.Request getRequest() {
        return this.request;
    }

    @Override // com.alimm.tanx.ui.image.glide.manager.LifecycleListener
    public void onDestroy() {
    }

    @Override // com.alimm.tanx.ui.image.glide.request.target.Target
    public void onLoadCleared(android.graphics.drawable.Drawable drawable) {
    }

    @Override // com.alimm.tanx.ui.image.glide.request.target.Target
    public void onLoadFailed(java.lang.Exception exc, android.graphics.drawable.Drawable drawable) {
    }

    @Override // com.alimm.tanx.ui.image.glide.request.target.Target
    public void onLoadStarted(android.graphics.drawable.Drawable drawable) {
    }

    @Override // com.alimm.tanx.ui.image.glide.manager.LifecycleListener
    public void onStart() {
    }

    @Override // com.alimm.tanx.ui.image.glide.manager.LifecycleListener
    public void onStop() {
    }

    @Override // com.alimm.tanx.ui.image.glide.request.target.Target
    public void setRequest(com.alimm.tanx.ui.image.glide.request.Request request) {
        this.request = request;
    }
}
