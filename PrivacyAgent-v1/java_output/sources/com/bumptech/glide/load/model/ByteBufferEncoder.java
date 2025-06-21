package com.bumptech.glide.load.model;

/* loaded from: classes.dex */
public class ByteBufferEncoder implements com.bumptech.glide.load.Encoder<java.nio.ByteBuffer> {
    private static final java.lang.String TAG = "ByteBufferEncoder";

    @Override // com.bumptech.glide.load.Encoder
    public boolean encode(@androidx.annotation.NonNull java.nio.ByteBuffer byteBuffer, @androidx.annotation.NonNull java.io.File file, @androidx.annotation.NonNull com.bumptech.glide.load.Options options) {
        try {
            com.bumptech.glide.util.ByteBufferUtil.toFile(byteBuffer, file);
            return true;
        } catch (java.io.IOException unused) {
            return false;
        }
    }
}
