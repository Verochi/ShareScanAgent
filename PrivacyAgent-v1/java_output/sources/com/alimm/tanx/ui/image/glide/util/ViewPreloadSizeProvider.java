package com.alimm.tanx.ui.image.glide.util;

/* loaded from: classes.dex */
public class ViewPreloadSizeProvider<T> implements com.alimm.tanx.ui.image.glide.ListPreloader.PreloadSizeProvider<T>, com.alimm.tanx.ui.image.glide.request.target.SizeReadyCallback {
    private int[] size;
    private com.alimm.tanx.ui.image.glide.util.ViewPreloadSizeProvider.SizeViewTarget viewTarget;

    public static final class SizeViewTarget extends com.alimm.tanx.ui.image.glide.request.target.ViewTarget<android.view.View, java.lang.Object> {
        public SizeViewTarget(android.view.View view, com.alimm.tanx.ui.image.glide.request.target.SizeReadyCallback sizeReadyCallback) {
            super(view);
            getSize(sizeReadyCallback);
        }

        @Override // com.alimm.tanx.ui.image.glide.request.target.Target
        public void onResourceReady(java.lang.Object obj, com.alimm.tanx.ui.image.glide.request.animation.GlideAnimation glideAnimation) {
        }
    }

    public ViewPreloadSizeProvider() {
    }

    public ViewPreloadSizeProvider(android.view.View view) {
        setView(view);
    }

    @Override // com.alimm.tanx.ui.image.glide.ListPreloader.PreloadSizeProvider
    public int[] getPreloadSize(T t, int i, int i2) {
        int[] iArr = this.size;
        if (iArr == null) {
            return null;
        }
        return java.util.Arrays.copyOf(iArr, iArr.length);
    }

    @Override // com.alimm.tanx.ui.image.glide.request.target.SizeReadyCallback
    public void onSizeReady(int i, int i2) {
        this.size = new int[]{i, i2};
        this.viewTarget = null;
    }

    public void setView(android.view.View view) {
        if (this.size == null && this.viewTarget == null) {
            this.viewTarget = new com.alimm.tanx.ui.image.glide.util.ViewPreloadSizeProvider.SizeViewTarget(view, this);
        }
    }
}
