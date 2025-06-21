package com.alimm.tanx.ui.image.glide.request.target;

/* loaded from: classes.dex */
public class GlideDrawableImageViewTarget extends com.alimm.tanx.ui.image.glide.request.target.ImageViewTarget<com.alimm.tanx.ui.image.glide.load.resource.drawable.GlideDrawable> {
    private static final float SQUARE_RATIO_MARGIN = 0.05f;
    private int maxLoopCount;
    private com.alimm.tanx.ui.image.glide.load.resource.drawable.GlideDrawable resource;

    public GlideDrawableImageViewTarget(android.widget.ImageView imageView) {
        super(imageView);
        this.maxLoopCount = -1;
    }

    public GlideDrawableImageViewTarget(android.widget.ImageView imageView, int i) {
        super(imageView);
        this.maxLoopCount = i;
    }

    public void onResourceReady(com.alimm.tanx.ui.image.glide.load.resource.drawable.GlideDrawable glideDrawable, com.alimm.tanx.ui.image.glide.request.animation.GlideAnimation<? super com.alimm.tanx.ui.image.glide.load.resource.drawable.GlideDrawable> glideAnimation) {
        if (!glideDrawable.isAnimated()) {
            float intrinsicWidth = glideDrawable.getIntrinsicWidth() / glideDrawable.getIntrinsicHeight();
            if (java.lang.Math.abs((((android.widget.ImageView) this.view).getWidth() / ((android.widget.ImageView) this.view).getHeight()) - 1.0f) <= SQUARE_RATIO_MARGIN && java.lang.Math.abs(intrinsicWidth - 1.0f) <= SQUARE_RATIO_MARGIN) {
                glideDrawable = new com.alimm.tanx.ui.image.glide.request.target.SquaringDrawable(glideDrawable, ((android.widget.ImageView) this.view).getWidth());
            }
        }
        super.onResourceReady((com.alimm.tanx.ui.image.glide.request.target.GlideDrawableImageViewTarget) glideDrawable, (com.alimm.tanx.ui.image.glide.request.animation.GlideAnimation<? super com.alimm.tanx.ui.image.glide.request.target.GlideDrawableImageViewTarget>) glideAnimation);
        this.resource = glideDrawable;
        glideDrawable.setLoopCount(this.maxLoopCount);
        glideDrawable.start();
    }

    @Override // com.alimm.tanx.ui.image.glide.request.target.ImageViewTarget, com.alimm.tanx.ui.image.glide.request.target.Target
    public /* bridge */ /* synthetic */ void onResourceReady(java.lang.Object obj, com.alimm.tanx.ui.image.glide.request.animation.GlideAnimation glideAnimation) {
        onResourceReady((com.alimm.tanx.ui.image.glide.load.resource.drawable.GlideDrawable) obj, (com.alimm.tanx.ui.image.glide.request.animation.GlideAnimation<? super com.alimm.tanx.ui.image.glide.load.resource.drawable.GlideDrawable>) glideAnimation);
    }

    @Override // com.alimm.tanx.ui.image.glide.request.target.BaseTarget, com.alimm.tanx.ui.image.glide.manager.LifecycleListener
    public void onStart() {
        com.alimm.tanx.ui.image.glide.load.resource.drawable.GlideDrawable glideDrawable = this.resource;
        if (glideDrawable != null) {
            glideDrawable.start();
        }
    }

    @Override // com.alimm.tanx.ui.image.glide.request.target.BaseTarget, com.alimm.tanx.ui.image.glide.manager.LifecycleListener
    public void onStop() {
        com.alimm.tanx.ui.image.glide.load.resource.drawable.GlideDrawable glideDrawable = this.resource;
        if (glideDrawable != null) {
            glideDrawable.stop();
        }
    }

    @Override // com.alimm.tanx.ui.image.glide.request.target.ImageViewTarget
    public void setResource(com.alimm.tanx.ui.image.glide.load.resource.drawable.GlideDrawable glideDrawable) {
        ((android.widget.ImageView) this.view).setImageDrawable(glideDrawable);
    }
}
