package com.bumptech.glide.load.resource.transcode;

/* loaded from: classes.dex */
public class BitmapDrawableTranscoder implements com.bumptech.glide.load.resource.transcode.ResourceTranscoder<android.graphics.Bitmap, android.graphics.drawable.BitmapDrawable> {
    private final android.content.res.Resources resources;

    public BitmapDrawableTranscoder(@androidx.annotation.NonNull android.content.Context context) {
        this(context.getResources());
    }

    public BitmapDrawableTranscoder(@androidx.annotation.NonNull android.content.res.Resources resources) {
        this.resources = (android.content.res.Resources) com.bumptech.glide.util.Preconditions.checkNotNull(resources);
    }

    @java.lang.Deprecated
    public BitmapDrawableTranscoder(@androidx.annotation.NonNull android.content.res.Resources resources, com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool bitmapPool) {
        this(resources);
    }

    @Override // com.bumptech.glide.load.resource.transcode.ResourceTranscoder
    @androidx.annotation.Nullable
    public com.bumptech.glide.load.engine.Resource<android.graphics.drawable.BitmapDrawable> transcode(@androidx.annotation.NonNull com.bumptech.glide.load.engine.Resource<android.graphics.Bitmap> resource, @androidx.annotation.NonNull com.bumptech.glide.load.Options options) {
        return com.bumptech.glide.load.resource.bitmap.LazyBitmapDrawableResource.obtain(this.resources, resource);
    }
}
