package com.bumptech.glide.load.resource.drawable;

/* loaded from: classes.dex */
public class UnitDrawableDecoder implements com.bumptech.glide.load.ResourceDecoder<android.graphics.drawable.Drawable, android.graphics.drawable.Drawable> {
    @Override // com.bumptech.glide.load.ResourceDecoder
    @androidx.annotation.Nullable
    public com.bumptech.glide.load.engine.Resource<android.graphics.drawable.Drawable> decode(@androidx.annotation.NonNull android.graphics.drawable.Drawable drawable, int i, int i2, @androidx.annotation.NonNull com.bumptech.glide.load.Options options) {
        return com.bumptech.glide.load.resource.drawable.NonOwnedDrawableResource.newInstance(drawable);
    }

    @Override // com.bumptech.glide.load.ResourceDecoder
    public boolean handles(@androidx.annotation.NonNull android.graphics.drawable.Drawable drawable, @androidx.annotation.NonNull com.bumptech.glide.load.Options options) {
        return true;
    }
}
