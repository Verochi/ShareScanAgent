package com.alimm.tanx.ui.image.glide.load.engine;

/* loaded from: classes.dex */
class EngineKey implements com.alimm.tanx.ui.image.glide.load.Key {
    private static final java.lang.String EMPTY_LOG_STRING = "";
    private final com.alimm.tanx.ui.image.glide.load.ResourceDecoder cacheDecoder;
    private final com.alimm.tanx.ui.image.glide.load.ResourceDecoder decoder;
    private final com.alimm.tanx.ui.image.glide.load.ResourceEncoder encoder;
    private int hashCode;
    private final int height;
    private final java.lang.String id;
    private com.alimm.tanx.ui.image.glide.load.Key originalKey;
    private final com.alimm.tanx.ui.image.glide.load.Key signature;
    private final com.alimm.tanx.ui.image.glide.load.Encoder sourceEncoder;
    private java.lang.String stringKey;
    private final com.alimm.tanx.ui.image.glide.load.resource.transcode.ResourceTranscoder transcoder;
    private final com.alimm.tanx.ui.image.glide.load.Transformation transformation;
    private final int width;

    public EngineKey(java.lang.String str, com.alimm.tanx.ui.image.glide.load.Key key, int i, int i2, com.alimm.tanx.ui.image.glide.load.ResourceDecoder resourceDecoder, com.alimm.tanx.ui.image.glide.load.ResourceDecoder resourceDecoder2, com.alimm.tanx.ui.image.glide.load.Transformation transformation, com.alimm.tanx.ui.image.glide.load.ResourceEncoder resourceEncoder, com.alimm.tanx.ui.image.glide.load.resource.transcode.ResourceTranscoder resourceTranscoder, com.alimm.tanx.ui.image.glide.load.Encoder encoder) {
        this.id = str;
        this.signature = key;
        this.width = i;
        this.height = i2;
        this.cacheDecoder = resourceDecoder;
        this.decoder = resourceDecoder2;
        this.transformation = transformation;
        this.encoder = resourceEncoder;
        this.transcoder = resourceTranscoder;
        this.sourceEncoder = encoder;
    }

    @Override // com.alimm.tanx.ui.image.glide.load.Key
    public boolean equals(java.lang.Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || com.alimm.tanx.ui.image.glide.load.engine.EngineKey.class != obj.getClass()) {
            return false;
        }
        com.alimm.tanx.ui.image.glide.load.engine.EngineKey engineKey = (com.alimm.tanx.ui.image.glide.load.engine.EngineKey) obj;
        if (!this.id.equals(engineKey.id) || !this.signature.equals(engineKey.signature) || this.height != engineKey.height || this.width != engineKey.width) {
            return false;
        }
        com.alimm.tanx.ui.image.glide.load.Transformation transformation = this.transformation;
        if ((transformation == null) ^ (engineKey.transformation == null)) {
            return false;
        }
        if (transformation != null && !transformation.getId().equals(engineKey.transformation.getId())) {
            return false;
        }
        com.alimm.tanx.ui.image.glide.load.ResourceDecoder resourceDecoder = this.decoder;
        if ((resourceDecoder == null) ^ (engineKey.decoder == null)) {
            return false;
        }
        if (resourceDecoder != null && !resourceDecoder.getId().equals(engineKey.decoder.getId())) {
            return false;
        }
        com.alimm.tanx.ui.image.glide.load.ResourceDecoder resourceDecoder2 = this.cacheDecoder;
        if ((resourceDecoder2 == null) ^ (engineKey.cacheDecoder == null)) {
            return false;
        }
        if (resourceDecoder2 != null && !resourceDecoder2.getId().equals(engineKey.cacheDecoder.getId())) {
            return false;
        }
        com.alimm.tanx.ui.image.glide.load.ResourceEncoder resourceEncoder = this.encoder;
        if ((resourceEncoder == null) ^ (engineKey.encoder == null)) {
            return false;
        }
        if (resourceEncoder != null && !resourceEncoder.getId().equals(engineKey.encoder.getId())) {
            return false;
        }
        com.alimm.tanx.ui.image.glide.load.resource.transcode.ResourceTranscoder resourceTranscoder = this.transcoder;
        if ((resourceTranscoder == null) ^ (engineKey.transcoder == null)) {
            return false;
        }
        if (resourceTranscoder != null && !resourceTranscoder.getId().equals(engineKey.transcoder.getId())) {
            return false;
        }
        com.alimm.tanx.ui.image.glide.load.Encoder encoder = this.sourceEncoder;
        if ((encoder == null) ^ (engineKey.sourceEncoder == null)) {
            return false;
        }
        return encoder == null || encoder.getId().equals(engineKey.sourceEncoder.getId());
    }

    public com.alimm.tanx.ui.image.glide.load.Key getOriginalKey() {
        if (this.originalKey == null) {
            this.originalKey = new com.alimm.tanx.ui.image.glide.load.engine.OriginalKey(this.id, this.signature);
        }
        return this.originalKey;
    }

    @Override // com.alimm.tanx.ui.image.glide.load.Key
    public int hashCode() {
        if (this.hashCode == 0) {
            int hashCode = this.id.hashCode();
            this.hashCode = hashCode;
            int hashCode2 = ((((this.signature.hashCode() + (hashCode * 31)) * 31) + this.width) * 31) + this.height;
            this.hashCode = hashCode2;
            int i = hashCode2 * 31;
            com.alimm.tanx.ui.image.glide.load.ResourceDecoder resourceDecoder = this.cacheDecoder;
            int hashCode3 = i + (resourceDecoder != null ? resourceDecoder.getId().hashCode() : 0);
            this.hashCode = hashCode3;
            int i2 = hashCode3 * 31;
            com.alimm.tanx.ui.image.glide.load.ResourceDecoder resourceDecoder2 = this.decoder;
            int hashCode4 = i2 + (resourceDecoder2 != null ? resourceDecoder2.getId().hashCode() : 0);
            this.hashCode = hashCode4;
            int i3 = hashCode4 * 31;
            com.alimm.tanx.ui.image.glide.load.Transformation transformation = this.transformation;
            int hashCode5 = i3 + (transformation != null ? transformation.getId().hashCode() : 0);
            this.hashCode = hashCode5;
            int i4 = hashCode5 * 31;
            com.alimm.tanx.ui.image.glide.load.ResourceEncoder resourceEncoder = this.encoder;
            int hashCode6 = i4 + (resourceEncoder != null ? resourceEncoder.getId().hashCode() : 0);
            this.hashCode = hashCode6;
            int i5 = hashCode6 * 31;
            com.alimm.tanx.ui.image.glide.load.resource.transcode.ResourceTranscoder resourceTranscoder = this.transcoder;
            int hashCode7 = i5 + (resourceTranscoder != null ? resourceTranscoder.getId().hashCode() : 0);
            this.hashCode = hashCode7;
            int i6 = hashCode7 * 31;
            com.alimm.tanx.ui.image.glide.load.Encoder encoder = this.sourceEncoder;
            this.hashCode = i6 + (encoder != null ? encoder.getId().hashCode() : 0);
        }
        return this.hashCode;
    }

    public java.lang.String toString() {
        if (this.stringKey == null) {
            java.lang.StringBuilder tanxu_do2 = tanxu_do.tanxu_do.tanxu_do.tanxu_do.tanxu_do.tanxu_do("EngineKey{");
            tanxu_do2.append(this.id);
            tanxu_do2.append('+');
            tanxu_do2.append(this.signature);
            tanxu_do2.append("+[");
            tanxu_do2.append(this.width);
            tanxu_do2.append('x');
            tanxu_do2.append(this.height);
            tanxu_do2.append("]+");
            tanxu_do2.append('\'');
            com.alimm.tanx.ui.image.glide.load.ResourceDecoder resourceDecoder = this.cacheDecoder;
            tanxu_do2.append(resourceDecoder != null ? resourceDecoder.getId() : EMPTY_LOG_STRING);
            tanxu_do2.append('\'');
            tanxu_do2.append('+');
            tanxu_do2.append('\'');
            com.alimm.tanx.ui.image.glide.load.ResourceDecoder resourceDecoder2 = this.decoder;
            tanxu_do2.append(resourceDecoder2 != null ? resourceDecoder2.getId() : EMPTY_LOG_STRING);
            tanxu_do2.append('\'');
            tanxu_do2.append('+');
            tanxu_do2.append('\'');
            com.alimm.tanx.ui.image.glide.load.Transformation transformation = this.transformation;
            tanxu_do2.append(transformation != null ? transformation.getId() : EMPTY_LOG_STRING);
            tanxu_do2.append('\'');
            tanxu_do2.append('+');
            tanxu_do2.append('\'');
            com.alimm.tanx.ui.image.glide.load.ResourceEncoder resourceEncoder = this.encoder;
            tanxu_do2.append(resourceEncoder != null ? resourceEncoder.getId() : EMPTY_LOG_STRING);
            tanxu_do2.append('\'');
            tanxu_do2.append('+');
            tanxu_do2.append('\'');
            com.alimm.tanx.ui.image.glide.load.resource.transcode.ResourceTranscoder resourceTranscoder = this.transcoder;
            tanxu_do2.append(resourceTranscoder != null ? resourceTranscoder.getId() : EMPTY_LOG_STRING);
            tanxu_do2.append('\'');
            tanxu_do2.append('+');
            tanxu_do2.append('\'');
            com.alimm.tanx.ui.image.glide.load.Encoder encoder = this.sourceEncoder;
            tanxu_do2.append(encoder != null ? encoder.getId() : EMPTY_LOG_STRING);
            tanxu_do2.append('\'');
            tanxu_do2.append('}');
            this.stringKey = tanxu_do2.toString();
        }
        return this.stringKey;
    }

    @Override // com.alimm.tanx.ui.image.glide.load.Key
    public void updateDiskCacheKey(java.security.MessageDigest messageDigest) throws java.io.UnsupportedEncodingException {
        byte[] array = java.nio.ByteBuffer.allocate(8).putInt(this.width).putInt(this.height).array();
        this.signature.updateDiskCacheKey(messageDigest);
        messageDigest.update(this.id.getBytes("UTF-8"));
        messageDigest.update(array);
        com.alimm.tanx.ui.image.glide.load.ResourceDecoder resourceDecoder = this.cacheDecoder;
        messageDigest.update((resourceDecoder != null ? resourceDecoder.getId() : "").getBytes("UTF-8"));
        com.alimm.tanx.ui.image.glide.load.ResourceDecoder resourceDecoder2 = this.decoder;
        messageDigest.update((resourceDecoder2 != null ? resourceDecoder2.getId() : "").getBytes("UTF-8"));
        com.alimm.tanx.ui.image.glide.load.Transformation transformation = this.transformation;
        messageDigest.update((transformation != null ? transformation.getId() : "").getBytes("UTF-8"));
        com.alimm.tanx.ui.image.glide.load.ResourceEncoder resourceEncoder = this.encoder;
        messageDigest.update((resourceEncoder != null ? resourceEncoder.getId() : "").getBytes("UTF-8"));
        com.alimm.tanx.ui.image.glide.load.Encoder encoder = this.sourceEncoder;
        messageDigest.update((encoder != null ? encoder.getId() : "").getBytes("UTF-8"));
    }
}
