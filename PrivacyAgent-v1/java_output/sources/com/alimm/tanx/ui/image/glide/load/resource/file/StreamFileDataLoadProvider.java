package com.alimm.tanx.ui.image.glide.load.resource.file;

/* loaded from: classes.dex */
public class StreamFileDataLoadProvider implements com.alimm.tanx.ui.image.glide.provider.DataLoadProvider<java.io.InputStream, java.io.File> {
    private static final com.alimm.tanx.ui.image.glide.load.resource.file.StreamFileDataLoadProvider.ErrorSourceDecoder ERROR_DECODER = new com.alimm.tanx.ui.image.glide.load.resource.file.StreamFileDataLoadProvider.ErrorSourceDecoder(null);
    private final com.alimm.tanx.ui.image.glide.load.ResourceDecoder<java.io.File, java.io.File> cacheDecoder = new com.alimm.tanx.ui.image.glide.load.resource.file.FileDecoder();
    private final com.alimm.tanx.ui.image.glide.load.Encoder<java.io.InputStream> encoder = new com.alimm.tanx.ui.image.glide.load.model.StreamEncoder();

    public static class ErrorSourceDecoder implements com.alimm.tanx.ui.image.glide.load.ResourceDecoder<java.io.InputStream, java.io.File> {
        private ErrorSourceDecoder() {
        }

        public /* synthetic */ ErrorSourceDecoder(com.alimm.tanx.ui.image.glide.load.resource.file.StreamFileDataLoadProvider.AnonymousClass1 anonymousClass1) {
        }

        @Override // com.alimm.tanx.ui.image.glide.load.ResourceDecoder
        public com.alimm.tanx.ui.image.glide.load.engine.Resource<java.io.File> decode(java.io.InputStream inputStream, int i, int i2) {
            throw new java.lang.Error("You cannot decode a File from an InputStream by default, try either #diskCacheStratey(DiskCacheStrategy.SOURCE) to avoid this call or #decoder(ResourceDecoder) to replace this Decoder");
        }

        @Override // com.alimm.tanx.ui.image.glide.load.ResourceDecoder
        public java.lang.String getId() {
            return "";
        }
    }

    @Override // com.alimm.tanx.ui.image.glide.provider.DataLoadProvider
    public com.alimm.tanx.ui.image.glide.load.ResourceDecoder<java.io.File, java.io.File> getCacheDecoder() {
        return this.cacheDecoder;
    }

    @Override // com.alimm.tanx.ui.image.glide.provider.DataLoadProvider
    public com.alimm.tanx.ui.image.glide.load.ResourceEncoder<java.io.File> getEncoder() {
        return com.alimm.tanx.ui.image.glide.load.resource.NullResourceEncoder.get();
    }

    @Override // com.alimm.tanx.ui.image.glide.provider.DataLoadProvider
    public com.alimm.tanx.ui.image.glide.load.ResourceDecoder<java.io.InputStream, java.io.File> getSourceDecoder() {
        return ERROR_DECODER;
    }

    @Override // com.alimm.tanx.ui.image.glide.provider.DataLoadProvider
    public com.alimm.tanx.ui.image.glide.load.Encoder<java.io.InputStream> getSourceEncoder() {
        return this.encoder;
    }
}
