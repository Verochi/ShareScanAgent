package com.bumptech.glide.load.resource.gif;

/* loaded from: classes.dex */
public class GifDrawableEncoder implements com.bumptech.glide.load.ResourceEncoder<com.bumptech.glide.load.resource.gif.GifDrawable> {
    private static final java.lang.String TAG = "GifEncoder";

    @Override // com.bumptech.glide.load.Encoder
    public boolean encode(@androidx.annotation.NonNull com.bumptech.glide.load.engine.Resource<com.bumptech.glide.load.resource.gif.GifDrawable> resource, @androidx.annotation.NonNull java.io.File file, @androidx.annotation.NonNull com.bumptech.glide.load.Options options) {
        try {
            com.bumptech.glide.util.ByteBufferUtil.toFile(resource.get().getBuffer(), file);
            return true;
        } catch (java.io.IOException unused) {
            return false;
        }
    }

    @Override // com.bumptech.glide.load.ResourceEncoder
    @androidx.annotation.NonNull
    public com.bumptech.glide.load.EncodeStrategy getEncodeStrategy(@androidx.annotation.NonNull com.bumptech.glide.load.Options options) {
        return com.bumptech.glide.load.EncodeStrategy.SOURCE;
    }
}
