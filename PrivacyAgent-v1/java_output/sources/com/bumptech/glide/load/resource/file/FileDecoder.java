package com.bumptech.glide.load.resource.file;

/* loaded from: classes.dex */
public class FileDecoder implements com.bumptech.glide.load.ResourceDecoder<java.io.File, java.io.File> {
    @Override // com.bumptech.glide.load.ResourceDecoder
    public com.bumptech.glide.load.engine.Resource<java.io.File> decode(@androidx.annotation.NonNull java.io.File file, int i, int i2, @androidx.annotation.NonNull com.bumptech.glide.load.Options options) {
        return new com.bumptech.glide.load.resource.file.FileResource(file);
    }

    @Override // com.bumptech.glide.load.ResourceDecoder
    public boolean handles(@androidx.annotation.NonNull java.io.File file, @androidx.annotation.NonNull com.bumptech.glide.load.Options options) {
        return true;
    }
}
