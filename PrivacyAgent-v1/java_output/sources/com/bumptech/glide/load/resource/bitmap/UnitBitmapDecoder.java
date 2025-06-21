package com.bumptech.glide.load.resource.bitmap;

/* loaded from: classes.dex */
public final class UnitBitmapDecoder implements com.bumptech.glide.load.ResourceDecoder<android.graphics.Bitmap, android.graphics.Bitmap> {

    public static final class NonOwnedBitmapResource implements com.bumptech.glide.load.engine.Resource<android.graphics.Bitmap> {
        private final android.graphics.Bitmap bitmap;

        public NonOwnedBitmapResource(@androidx.annotation.NonNull android.graphics.Bitmap bitmap) {
            this.bitmap = bitmap;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.bumptech.glide.load.engine.Resource
        @androidx.annotation.NonNull
        public android.graphics.Bitmap get() {
            return this.bitmap;
        }

        @Override // com.bumptech.glide.load.engine.Resource
        @androidx.annotation.NonNull
        public java.lang.Class<android.graphics.Bitmap> getResourceClass() {
            return android.graphics.Bitmap.class;
        }

        @Override // com.bumptech.glide.load.engine.Resource
        public int getSize() {
            return com.bumptech.glide.util.Util.getBitmapByteSize(this.bitmap);
        }

        @Override // com.bumptech.glide.load.engine.Resource
        public void recycle() {
        }
    }

    @Override // com.bumptech.glide.load.ResourceDecoder
    public com.bumptech.glide.load.engine.Resource<android.graphics.Bitmap> decode(@androidx.annotation.NonNull android.graphics.Bitmap bitmap, int i, int i2, @androidx.annotation.NonNull com.bumptech.glide.load.Options options) {
        return new com.bumptech.glide.load.resource.bitmap.UnitBitmapDecoder.NonOwnedBitmapResource(bitmap);
    }

    @Override // com.bumptech.glide.load.ResourceDecoder
    public boolean handles(@androidx.annotation.NonNull android.graphics.Bitmap bitmap, @androidx.annotation.NonNull com.bumptech.glide.load.Options options) {
        return true;
    }
}
