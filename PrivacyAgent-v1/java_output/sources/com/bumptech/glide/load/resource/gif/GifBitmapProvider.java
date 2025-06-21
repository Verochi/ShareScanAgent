package com.bumptech.glide.load.resource.gif;

/* loaded from: classes.dex */
public final class GifBitmapProvider implements com.bumptech.glide.gifdecoder.GifDecoder.BitmapProvider {

    @androidx.annotation.Nullable
    private final com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool arrayPool;
    private final com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool bitmapPool;

    public GifBitmapProvider(com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool bitmapPool) {
        this(bitmapPool, null);
    }

    public GifBitmapProvider(com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool bitmapPool, @androidx.annotation.Nullable com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool arrayPool) {
        this.bitmapPool = bitmapPool;
        this.arrayPool = arrayPool;
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder.BitmapProvider
    @androidx.annotation.NonNull
    public android.graphics.Bitmap obtain(int i, int i2, @androidx.annotation.NonNull android.graphics.Bitmap.Config config) {
        return this.bitmapPool.getDirty(i, i2, config);
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder.BitmapProvider
    @androidx.annotation.NonNull
    public byte[] obtainByteArray(int i) {
        com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool arrayPool = this.arrayPool;
        return arrayPool == null ? new byte[i] : (byte[]) arrayPool.get(i, byte[].class);
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder.BitmapProvider
    @androidx.annotation.NonNull
    public int[] obtainIntArray(int i) {
        com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool arrayPool = this.arrayPool;
        return arrayPool == null ? new int[i] : (int[]) arrayPool.get(i, int[].class);
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder.BitmapProvider
    public void release(@androidx.annotation.NonNull android.graphics.Bitmap bitmap) {
        this.bitmapPool.put(bitmap);
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder.BitmapProvider
    public void release(@androidx.annotation.NonNull byte[] bArr) {
        com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool arrayPool = this.arrayPool;
        if (arrayPool == null) {
            return;
        }
        arrayPool.put(bArr);
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder.BitmapProvider
    public void release(@androidx.annotation.NonNull int[] iArr) {
        com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool arrayPool = this.arrayPool;
        if (arrayPool == null) {
            return;
        }
        arrayPool.put(iArr);
    }
}
