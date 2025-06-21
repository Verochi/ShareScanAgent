package com.alimm.tanx.ui.image.glide.load.model.stream;

/* loaded from: classes.dex */
public class StreamByteArrayLoader implements com.alimm.tanx.ui.image.glide.load.model.stream.StreamModelLoader<byte[]> {
    private final java.lang.String id;

    public static class Factory implements com.alimm.tanx.ui.image.glide.load.model.ModelLoaderFactory<byte[], java.io.InputStream> {
        @Override // com.alimm.tanx.ui.image.glide.load.model.ModelLoaderFactory
        public com.alimm.tanx.ui.image.glide.load.model.ModelLoader<byte[], java.io.InputStream> build(android.content.Context context, com.alimm.tanx.ui.image.glide.load.model.GenericLoaderFactory genericLoaderFactory) {
            return new com.alimm.tanx.ui.image.glide.load.model.stream.StreamByteArrayLoader();
        }

        @Override // com.alimm.tanx.ui.image.glide.load.model.ModelLoaderFactory
        public void teardown() {
        }
    }

    public StreamByteArrayLoader() {
        this.id = "";
    }

    @java.lang.Deprecated
    public StreamByteArrayLoader(java.lang.String str) {
        this.id = str;
    }

    @Override // com.alimm.tanx.ui.image.glide.load.model.ModelLoader
    public com.alimm.tanx.ui.image.glide.load.data.DataFetcher<java.io.InputStream> getResourceFetcher(byte[] bArr, int i, int i2) {
        return new com.alimm.tanx.ui.image.glide.load.data.ByteArrayFetcher(bArr, this.id);
    }
}
