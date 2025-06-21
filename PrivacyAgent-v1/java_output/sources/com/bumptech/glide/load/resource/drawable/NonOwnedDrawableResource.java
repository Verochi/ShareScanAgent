package com.bumptech.glide.load.resource.drawable;

/* loaded from: classes.dex */
final class NonOwnedDrawableResource extends com.bumptech.glide.load.resource.drawable.DrawableResource<android.graphics.drawable.Drawable> {
    private NonOwnedDrawableResource(android.graphics.drawable.Drawable drawable) {
        super(drawable);
    }

    @androidx.annotation.Nullable
    public static com.bumptech.glide.load.engine.Resource<android.graphics.drawable.Drawable> newInstance(@androidx.annotation.Nullable android.graphics.drawable.Drawable drawable) {
        if (drawable != null) {
            return new com.bumptech.glide.load.resource.drawable.NonOwnedDrawableResource(drawable);
        }
        return null;
    }

    @Override // com.bumptech.glide.load.engine.Resource
    @androidx.annotation.NonNull
    public java.lang.Class<android.graphics.drawable.Drawable> getResourceClass() {
        return this.drawable.getClass();
    }

    @Override // com.bumptech.glide.load.engine.Resource
    public int getSize() {
        return java.lang.Math.max(1, this.drawable.getIntrinsicWidth() * this.drawable.getIntrinsicHeight() * 4);
    }

    @Override // com.bumptech.glide.load.engine.Resource
    public void recycle() {
    }
}
