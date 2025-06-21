package com.alimm.tanx.ui.image.glide.load.resource.bitmap;

/* loaded from: classes.dex */
public interface BitmapDecoder<T> {
    android.graphics.Bitmap decode(T t, com.alimm.tanx.ui.image.glide.load.engine.bitmap_recycle.BitmapPool bitmapPool, int i, int i2, com.alimm.tanx.ui.image.glide.load.DecodeFormat decodeFormat) throws java.lang.Exception;

    java.lang.String getId();
}
