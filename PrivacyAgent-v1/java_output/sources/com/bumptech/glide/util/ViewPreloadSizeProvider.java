package com.bumptech.glide.util;

/* loaded from: classes.dex */
public class ViewPreloadSizeProvider<T> implements com.bumptech.glide.ListPreloader.PreloadSizeProvider<T>, com.bumptech.glide.request.target.SizeReadyCallback {
    private int[] size;
    private com.bumptech.glide.util.ViewPreloadSizeProvider.SizeViewTarget viewTarget;

    public static final class SizeViewTarget extends com.bumptech.glide.request.target.CustomViewTarget<android.view.View, java.lang.Object> {
        public SizeViewTarget(@androidx.annotation.NonNull android.view.View view) {
            super(view);
        }

        @Override // com.bumptech.glide.request.target.Target
        public void onLoadFailed(@androidx.annotation.Nullable android.graphics.drawable.Drawable drawable) {
        }

        @Override // com.bumptech.glide.request.target.CustomViewTarget
        public void onResourceCleared(@androidx.annotation.Nullable android.graphics.drawable.Drawable drawable) {
        }

        @Override // com.bumptech.glide.request.target.Target
        public void onResourceReady(@androidx.annotation.NonNull java.lang.Object obj, @androidx.annotation.Nullable com.bumptech.glide.request.transition.Transition<? super java.lang.Object> transition) {
        }
    }

    public ViewPreloadSizeProvider() {
    }

    public ViewPreloadSizeProvider(@androidx.annotation.NonNull android.view.View view) {
        com.bumptech.glide.util.ViewPreloadSizeProvider.SizeViewTarget sizeViewTarget = new com.bumptech.glide.util.ViewPreloadSizeProvider.SizeViewTarget(view);
        this.viewTarget = sizeViewTarget;
        sizeViewTarget.getSize(this);
    }

    @Override // com.bumptech.glide.ListPreloader.PreloadSizeProvider
    @androidx.annotation.Nullable
    public int[] getPreloadSize(@androidx.annotation.NonNull T t, int i, int i2) {
        int[] iArr = this.size;
        if (iArr == null) {
            return null;
        }
        return java.util.Arrays.copyOf(iArr, iArr.length);
    }

    @Override // com.bumptech.glide.request.target.SizeReadyCallback
    public void onSizeReady(int i, int i2) {
        this.size = new int[]{i, i2};
        this.viewTarget = null;
    }

    public void setView(@androidx.annotation.NonNull android.view.View view) {
        if (this.size == null && this.viewTarget == null) {
            com.bumptech.glide.util.ViewPreloadSizeProvider.SizeViewTarget sizeViewTarget = new com.bumptech.glide.util.ViewPreloadSizeProvider.SizeViewTarget(view);
            this.viewTarget = sizeViewTarget;
            sizeViewTarget.getSize(this);
        }
    }
}
