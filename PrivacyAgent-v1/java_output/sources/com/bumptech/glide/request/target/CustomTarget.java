package com.bumptech.glide.request.target;

/* loaded from: classes.dex */
public abstract class CustomTarget<T> implements com.bumptech.glide.request.target.Target<T> {
    private final int height;

    @androidx.annotation.Nullable
    private com.bumptech.glide.request.Request request;
    private final int width;

    public CustomTarget() {
        this(Integer.MIN_VALUE, Integer.MIN_VALUE);
    }

    public CustomTarget(int i, int i2) {
        if (com.bumptech.glide.util.Util.isValidDimensions(i, i2)) {
            this.width = i;
            this.height = i2;
            return;
        }
        throw new java.lang.IllegalArgumentException("Width and height must both be > 0 or Target#SIZE_ORIGINAL, but given width: " + i + " and height: " + i2);
    }

    @Override // com.bumptech.glide.request.target.Target
    @androidx.annotation.Nullable
    public final com.bumptech.glide.request.Request getRequest() {
        return this.request;
    }

    @Override // com.bumptech.glide.request.target.Target
    public final void getSize(@androidx.annotation.NonNull com.bumptech.glide.request.target.SizeReadyCallback sizeReadyCallback) {
        sizeReadyCallback.onSizeReady(this.width, this.height);
    }

    @Override // com.bumptech.glide.manager.LifecycleListener
    public void onDestroy() {
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
    public final void removeCallback(@androidx.annotation.NonNull com.bumptech.glide.request.target.SizeReadyCallback sizeReadyCallback) {
    }

    @Override // com.bumptech.glide.request.target.Target
    public final void setRequest(@androidx.annotation.Nullable com.bumptech.glide.request.Request request) {
        this.request = request;
    }
}
