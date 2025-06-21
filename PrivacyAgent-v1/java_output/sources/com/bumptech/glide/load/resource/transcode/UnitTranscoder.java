package com.bumptech.glide.load.resource.transcode;

/* loaded from: classes.dex */
public class UnitTranscoder<Z> implements com.bumptech.glide.load.resource.transcode.ResourceTranscoder<Z, Z> {
    private static final com.bumptech.glide.load.resource.transcode.UnitTranscoder<?> UNIT_TRANSCODER = new com.bumptech.glide.load.resource.transcode.UnitTranscoder<>();

    public static <Z> com.bumptech.glide.load.resource.transcode.ResourceTranscoder<Z, Z> get() {
        return UNIT_TRANSCODER;
    }

    @Override // com.bumptech.glide.load.resource.transcode.ResourceTranscoder
    @androidx.annotation.Nullable
    public com.bumptech.glide.load.engine.Resource<Z> transcode(@androidx.annotation.NonNull com.bumptech.glide.load.engine.Resource<Z> resource, @androidx.annotation.NonNull com.bumptech.glide.load.Options options) {
        return resource;
    }
}
