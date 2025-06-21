package com.alimm.tanx.ui.image.glide.request.animation;

/* loaded from: classes.dex */
public class BitmapCrossFadeFactory extends com.alimm.tanx.ui.image.glide.request.animation.BitmapContainerCrossFadeFactory<android.graphics.Bitmap> {
    public BitmapCrossFadeFactory() {
    }

    public BitmapCrossFadeFactory(int i) {
        super(i);
    }

    public BitmapCrossFadeFactory(android.content.Context context, int i, int i2) {
        super(context, i, i2);
    }

    public BitmapCrossFadeFactory(android.view.animation.Animation animation, int i) {
        super(animation, i);
    }

    public BitmapCrossFadeFactory(com.alimm.tanx.ui.image.glide.request.animation.GlideAnimationFactory<android.graphics.drawable.Drawable> glideAnimationFactory) {
        super(glideAnimationFactory);
    }

    @Override // com.alimm.tanx.ui.image.glide.request.animation.BitmapContainerCrossFadeFactory
    public android.graphics.Bitmap getBitmap(android.graphics.Bitmap bitmap) {
        return bitmap;
    }
}
