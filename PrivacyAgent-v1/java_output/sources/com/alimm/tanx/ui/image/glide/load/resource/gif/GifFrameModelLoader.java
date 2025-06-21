package com.alimm.tanx.ui.image.glide.load.resource.gif;

/* loaded from: classes.dex */
class GifFrameModelLoader implements com.alimm.tanx.ui.image.glide.load.model.ModelLoader<com.alimm.tanx.ui.image.glide.gifdecoder.GifDecoder, com.alimm.tanx.ui.image.glide.gifdecoder.GifDecoder> {

    public static class GifFrameDataFetcher implements com.alimm.tanx.ui.image.glide.load.data.DataFetcher<com.alimm.tanx.ui.image.glide.gifdecoder.GifDecoder> {
        private final com.alimm.tanx.ui.image.glide.gifdecoder.GifDecoder decoder;

        public GifFrameDataFetcher(com.alimm.tanx.ui.image.glide.gifdecoder.GifDecoder gifDecoder) {
            this.decoder = gifDecoder;
        }

        @Override // com.alimm.tanx.ui.image.glide.load.data.DataFetcher
        public void cancel() {
        }

        @Override // com.alimm.tanx.ui.image.glide.load.data.DataFetcher
        public void cleanup() {
        }

        @Override // com.alimm.tanx.ui.image.glide.load.data.DataFetcher
        public java.lang.String getId() {
            return java.lang.String.valueOf(this.decoder.getCurrentFrameIndex());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.alimm.tanx.ui.image.glide.load.data.DataFetcher
        public com.alimm.tanx.ui.image.glide.gifdecoder.GifDecoder loadData(com.alimm.tanx.ui.image.glide.Priority priority) {
            return this.decoder;
        }
    }

    @Override // com.alimm.tanx.ui.image.glide.load.model.ModelLoader
    public com.alimm.tanx.ui.image.glide.load.data.DataFetcher<com.alimm.tanx.ui.image.glide.gifdecoder.GifDecoder> getResourceFetcher(com.alimm.tanx.ui.image.glide.gifdecoder.GifDecoder gifDecoder, int i, int i2) {
        return new com.alimm.tanx.ui.image.glide.load.resource.gif.GifFrameModelLoader.GifFrameDataFetcher(gifDecoder);
    }
}
