package com.alimm.tanx.ui.image.glide.request.target;

/* loaded from: classes.dex */
public interface Target<R> extends com.alimm.tanx.ui.image.glide.manager.LifecycleListener {
    public static final int SIZE_ORIGINAL = Integer.MIN_VALUE;

    com.alimm.tanx.ui.image.glide.request.Request getRequest();

    void getSize(com.alimm.tanx.ui.image.glide.request.target.SizeReadyCallback sizeReadyCallback);

    void onLoadCleared(android.graphics.drawable.Drawable drawable);

    void onLoadFailed(java.lang.Exception exc, android.graphics.drawable.Drawable drawable);

    void onLoadStarted(android.graphics.drawable.Drawable drawable);

    void onResourceReady(R r, com.alimm.tanx.ui.image.glide.request.animation.GlideAnimation<? super R> glideAnimation);

    void setRequest(com.alimm.tanx.ui.image.glide.request.Request request);
}
