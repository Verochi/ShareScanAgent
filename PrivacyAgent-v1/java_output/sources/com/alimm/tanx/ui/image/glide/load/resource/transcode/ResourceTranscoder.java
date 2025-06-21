package com.alimm.tanx.ui.image.glide.load.resource.transcode;

/* loaded from: classes.dex */
public interface ResourceTranscoder<Z, R> {
    java.lang.String getId();

    com.alimm.tanx.ui.image.glide.load.engine.Resource<R> transcode(com.alimm.tanx.ui.image.glide.load.engine.Resource<Z> resource);
}
