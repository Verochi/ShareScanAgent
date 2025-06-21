package com.bumptech.glide.load.resource.transcode;

/* loaded from: classes.dex */
public class GifDrawableBytesTranscoder implements com.bumptech.glide.load.resource.transcode.ResourceTranscoder<com.bumptech.glide.load.resource.gif.GifDrawable, byte[]> {
    @Override // com.bumptech.glide.load.resource.transcode.ResourceTranscoder
    @androidx.annotation.Nullable
    public com.bumptech.glide.load.engine.Resource<byte[]> transcode(@androidx.annotation.NonNull com.bumptech.glide.load.engine.Resource<com.bumptech.glide.load.resource.gif.GifDrawable> resource, @androidx.annotation.NonNull com.bumptech.glide.load.Options options) {
        return new com.bumptech.glide.load.resource.bytes.BytesResource(com.bumptech.glide.util.ByteBufferUtil.toBytes(resource.get().getBuffer()));
    }
}
