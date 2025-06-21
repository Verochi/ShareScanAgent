package com.bumptech.glide.request.target;

@java.lang.Deprecated
/* loaded from: classes.dex */
public abstract class BaseTarget<Z> implements com.bumptech.glide.request.target.Target<Z> {
    private com.bumptech.glide.request.Request request;

    @Override // com.bumptech.glide.request.target.Target
    @androidx.annotation.Nullable
    public com.bumptech.glide.request.Request getRequest() {
        return this.request;
    }

    @Override // com.bumptech.glide.manager.LifecycleListener
    public void onDestroy() {
    }

    @Override // com.bumptech.glide.request.target.Target
    public void onLoadCleared(@androidx.annotation.Nullable android.graphics.drawable.Drawable drawable) {
    }

    @Override // com.bumptech.glide.request.target.Target
    public void onLoadFailed(@androidx.annotation.Nullable android.graphics.drawable.Drawable drawable) {
    }

    @Override // com.bumptech.glide.request.target.Target
    public void onLoadStarted(@androidx.annotation.Nullable android.graphics.drawable.Drawable drawable) {
    }

    @Override // com.bumptech.glide.manager.LifecycleListener
    public void onStart() {
    }

    @Override // com.bumptech.glide.manager.LifecycleListener
    public void onStop() {
    }

    @Override // com.bumptech.glide.request.target.Target
    public void setRequest(@androidx.annotation.Nullable com.bumptech.glide.request.Request request) {
        this.request = request;
    }
}
