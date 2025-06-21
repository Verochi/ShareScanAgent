package com.alimm.tanx.ui.image.glide.load.resource.transcode;

/* loaded from: classes.dex */
public class UnitTranscoder<Z> implements com.alimm.tanx.ui.image.glide.load.resource.transcode.ResourceTranscoder<Z, Z> {
    private static final com.alimm.tanx.ui.image.glide.load.resource.transcode.UnitTranscoder<?> UNIT_TRANSCODER = new com.alimm.tanx.ui.image.glide.load.resource.transcode.UnitTranscoder<>();

    public static <Z> com.alimm.tanx.ui.image.glide.load.resource.transcode.ResourceTranscoder<Z, Z> get() {
        return UNIT_TRANSCODER;
    }

    @Override // com.alimm.tanx.ui.image.glide.load.resource.transcode.ResourceTranscoder
    public java.lang.String getId() {
        return "";
    }

    @Override // com.alimm.tanx.ui.image.glide.load.resource.transcode.ResourceTranscoder
    public com.alimm.tanx.ui.image.glide.load.engine.Resource<Z> transcode(com.alimm.tanx.ui.image.glide.load.engine.Resource<Z> resource) {
        return resource;
    }
}
