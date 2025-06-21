package com.alimm.tanx.ui.image.glide.request.target;

/* loaded from: classes.dex */
public class BitmapImageViewTarget extends com.alimm.tanx.ui.image.glide.request.target.ImageViewTarget<android.graphics.Bitmap> {
    public BitmapImageViewTarget(android.widget.ImageView imageView) {
        super(imageView);
    }

    @Override // com.alimm.tanx.ui.image.glide.request.target.ImageViewTarget
    public void setResource(android.graphics.Bitmap bitmap) {
        ((android.widget.ImageView) this.view).setImageBitmap(bitmap);
    }
}
