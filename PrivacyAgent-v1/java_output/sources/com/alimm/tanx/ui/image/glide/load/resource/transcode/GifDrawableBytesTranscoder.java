package com.alimm.tanx.ui.image.glide.load.resource.transcode;

/* loaded from: classes.dex */
public class GifDrawableBytesTranscoder implements com.alimm.tanx.ui.image.glide.load.resource.transcode.ResourceTranscoder<com.alimm.tanx.ui.image.glide.load.resource.gif.GifDrawable, byte[]> {
    @Override // com.alimm.tanx.ui.image.glide.load.resource.transcode.ResourceTranscoder
    public java.lang.String getId() {
        return "GifDrawableBytesTranscoder.com.alimm.tanx.ui.image.glide.load.resource.transcode";
    }

    @Override // com.alimm.tanx.ui.image.glide.load.resource.transcode.ResourceTranscoder
    public com.alimm.tanx.ui.image.glide.load.engine.Resource<byte[]> transcode(com.alimm.tanx.ui.image.glide.load.engine.Resource<com.alimm.tanx.ui.image.glide.load.resource.gif.GifDrawable> resource) {
        return new com.alimm.tanx.ui.image.glide.load.resource.bytes.BytesResource(resource.get().getData());
    }
}
