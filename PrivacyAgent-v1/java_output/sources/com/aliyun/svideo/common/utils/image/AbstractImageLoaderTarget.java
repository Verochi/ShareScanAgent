package com.aliyun.svideo.common.utils.image;

/* loaded from: classes.dex */
public abstract class AbstractImageLoaderTarget<R> {
    public void onLoadCleared(@androidx.annotation.Nullable android.graphics.drawable.Drawable drawable) {
    }

    public void onLoadFailed(@androidx.annotation.Nullable android.graphics.drawable.Drawable drawable) {
    }

    public void onLoadStarted() {
    }

    public abstract void onResourceReady(@androidx.annotation.NonNull R r);
}
