package com.bumptech.glide.request.target;

/* loaded from: classes.dex */
public interface Target<R> extends com.bumptech.glide.manager.LifecycleListener {
    public static final int SIZE_ORIGINAL = Integer.MIN_VALUE;

    @androidx.annotation.Nullable
    com.bumptech.glide.request.Request getRequest();

    void getSize(@androidx.annotation.NonNull com.bumptech.glide.request.target.SizeReadyCallback sizeReadyCallback);

    void onLoadCleared(@androidx.annotation.Nullable android.graphics.drawable.Drawable drawable);

    void onLoadFailed(@androidx.annotation.Nullable android.graphics.drawable.Drawable drawable);

    void onLoadStarted(@androidx.annotation.Nullable android.graphics.drawable.Drawable drawable);

    void onResourceReady(@androidx.annotation.NonNull R r, @androidx.annotation.Nullable com.bumptech.glide.request.transition.Transition<? super R> transition);

    void removeCallback(@androidx.annotation.NonNull com.bumptech.glide.request.target.SizeReadyCallback sizeReadyCallback);

    void setRequest(@androidx.annotation.Nullable com.bumptech.glide.request.Request request);
}
