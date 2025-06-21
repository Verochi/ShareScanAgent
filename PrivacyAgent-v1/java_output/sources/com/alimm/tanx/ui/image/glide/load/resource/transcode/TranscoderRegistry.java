package com.alimm.tanx.ui.image.glide.load.resource.transcode;

/* loaded from: classes.dex */
public class TranscoderRegistry {
    private static final com.alimm.tanx.ui.image.glide.util.MultiClassKey GET_KEY = new com.alimm.tanx.ui.image.glide.util.MultiClassKey();
    private final java.util.Map<com.alimm.tanx.ui.image.glide.util.MultiClassKey, com.alimm.tanx.ui.image.glide.load.resource.transcode.ResourceTranscoder<?, ?>> factories = new java.util.HashMap();

    public <Z, R> com.alimm.tanx.ui.image.glide.load.resource.transcode.ResourceTranscoder<Z, R> get(java.lang.Class<Z> cls, java.lang.Class<R> cls2) {
        com.alimm.tanx.ui.image.glide.load.resource.transcode.ResourceTranscoder<Z, R> resourceTranscoder;
        if (cls.equals(cls2)) {
            return com.alimm.tanx.ui.image.glide.load.resource.transcode.UnitTranscoder.get();
        }
        com.alimm.tanx.ui.image.glide.util.MultiClassKey multiClassKey = GET_KEY;
        synchronized (multiClassKey) {
            multiClassKey.set(cls, cls2);
            resourceTranscoder = (com.alimm.tanx.ui.image.glide.load.resource.transcode.ResourceTranscoder) this.factories.get(multiClassKey);
        }
        if (resourceTranscoder != null) {
            return resourceTranscoder;
        }
        throw new java.lang.IllegalArgumentException("No transcoder registered for " + cls + " and " + cls2);
    }

    public <Z, R> void register(java.lang.Class<Z> cls, java.lang.Class<R> cls2, com.alimm.tanx.ui.image.glide.load.resource.transcode.ResourceTranscoder<Z, R> resourceTranscoder) {
        this.factories.put(new com.alimm.tanx.ui.image.glide.util.MultiClassKey(cls, cls2), resourceTranscoder);
    }
}
