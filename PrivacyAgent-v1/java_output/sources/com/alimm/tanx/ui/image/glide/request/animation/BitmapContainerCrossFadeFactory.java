package com.alimm.tanx.ui.image.glide.request.animation;

/* loaded from: classes.dex */
public abstract class BitmapContainerCrossFadeFactory<T> implements com.alimm.tanx.ui.image.glide.request.animation.GlideAnimationFactory<T> {
    private final com.alimm.tanx.ui.image.glide.request.animation.GlideAnimationFactory<android.graphics.drawable.Drawable> realFactory;

    public class BitmapGlideAnimation implements com.alimm.tanx.ui.image.glide.request.animation.GlideAnimation<T> {
        private final com.alimm.tanx.ui.image.glide.request.animation.GlideAnimation<android.graphics.drawable.Drawable> transition;

        public BitmapGlideAnimation(com.alimm.tanx.ui.image.glide.request.animation.GlideAnimation<android.graphics.drawable.Drawable> glideAnimation) {
            this.transition = glideAnimation;
        }

        @Override // com.alimm.tanx.ui.image.glide.request.animation.GlideAnimation
        public boolean animate(T t, com.alimm.tanx.ui.image.glide.request.animation.GlideAnimation.ViewAdapter viewAdapter) {
            return this.transition.animate(new android.graphics.drawable.BitmapDrawable(viewAdapter.getView().getResources(), com.alimm.tanx.ui.image.glide.request.animation.BitmapContainerCrossFadeFactory.this.getBitmap(t)), viewAdapter);
        }
    }

    public BitmapContainerCrossFadeFactory() {
        this.realFactory = new com.alimm.tanx.ui.image.glide.request.animation.DrawableCrossFadeFactory();
    }

    public BitmapContainerCrossFadeFactory(int i) {
        this.realFactory = new com.alimm.tanx.ui.image.glide.request.animation.DrawableCrossFadeFactory(i);
    }

    public BitmapContainerCrossFadeFactory(android.content.Context context, int i, int i2) {
        this.realFactory = new com.alimm.tanx.ui.image.glide.request.animation.DrawableCrossFadeFactory(context, i, i2);
    }

    public BitmapContainerCrossFadeFactory(android.view.animation.Animation animation, int i) {
        this.realFactory = new com.alimm.tanx.ui.image.glide.request.animation.DrawableCrossFadeFactory(animation, i);
    }

    public BitmapContainerCrossFadeFactory(com.alimm.tanx.ui.image.glide.request.animation.GlideAnimationFactory<android.graphics.drawable.Drawable> glideAnimationFactory) {
        this.realFactory = glideAnimationFactory;
    }

    @Override // com.alimm.tanx.ui.image.glide.request.animation.GlideAnimationFactory
    public com.alimm.tanx.ui.image.glide.request.animation.GlideAnimation<T> build(boolean z, boolean z2) {
        return new com.alimm.tanx.ui.image.glide.request.animation.BitmapContainerCrossFadeFactory.BitmapGlideAnimation(this.realFactory.build(z, z2));
    }

    public abstract android.graphics.Bitmap getBitmap(T t);
}
