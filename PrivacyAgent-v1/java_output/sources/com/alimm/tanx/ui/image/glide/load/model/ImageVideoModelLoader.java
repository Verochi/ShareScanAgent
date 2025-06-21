package com.alimm.tanx.ui.image.glide.load.model;

/* loaded from: classes.dex */
public class ImageVideoModelLoader<A> implements com.alimm.tanx.ui.image.glide.load.model.ModelLoader<A, com.alimm.tanx.ui.image.glide.load.model.ImageVideoWrapper> {
    private static final java.lang.String TAG = "IVML";
    private final com.alimm.tanx.ui.image.glide.load.model.ModelLoader<A, android.os.ParcelFileDescriptor> fileDescriptorLoader;
    private final com.alimm.tanx.ui.image.glide.load.model.ModelLoader<A, java.io.InputStream> streamLoader;

    public static class ImageVideoFetcher implements com.alimm.tanx.ui.image.glide.load.data.DataFetcher<com.alimm.tanx.ui.image.glide.load.model.ImageVideoWrapper> {
        private final com.alimm.tanx.ui.image.glide.load.data.DataFetcher<android.os.ParcelFileDescriptor> fileDescriptorFetcher;
        private final com.alimm.tanx.ui.image.glide.load.data.DataFetcher<java.io.InputStream> streamFetcher;

        public ImageVideoFetcher(com.alimm.tanx.ui.image.glide.load.data.DataFetcher<java.io.InputStream> dataFetcher, com.alimm.tanx.ui.image.glide.load.data.DataFetcher<android.os.ParcelFileDescriptor> dataFetcher2) {
            this.streamFetcher = dataFetcher;
            this.fileDescriptorFetcher = dataFetcher2;
        }

        @Override // com.alimm.tanx.ui.image.glide.load.data.DataFetcher
        public void cancel() {
            com.alimm.tanx.ui.image.glide.load.data.DataFetcher<java.io.InputStream> dataFetcher = this.streamFetcher;
            if (dataFetcher != null) {
                dataFetcher.cancel();
            }
            com.alimm.tanx.ui.image.glide.load.data.DataFetcher<android.os.ParcelFileDescriptor> dataFetcher2 = this.fileDescriptorFetcher;
            if (dataFetcher2 != null) {
                dataFetcher2.cancel();
            }
        }

        @Override // com.alimm.tanx.ui.image.glide.load.data.DataFetcher
        public void cleanup() {
            com.alimm.tanx.ui.image.glide.load.data.DataFetcher<java.io.InputStream> dataFetcher = this.streamFetcher;
            if (dataFetcher != null) {
                dataFetcher.cleanup();
            }
            com.alimm.tanx.ui.image.glide.load.data.DataFetcher<android.os.ParcelFileDescriptor> dataFetcher2 = this.fileDescriptorFetcher;
            if (dataFetcher2 != null) {
                dataFetcher2.cleanup();
            }
        }

        @Override // com.alimm.tanx.ui.image.glide.load.data.DataFetcher
        public java.lang.String getId() {
            com.alimm.tanx.ui.image.glide.load.data.DataFetcher<java.io.InputStream> dataFetcher = this.streamFetcher;
            return dataFetcher != null ? dataFetcher.getId() : this.fileDescriptorFetcher.getId();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        /* JADX WARN: Removed duplicated region for block: B:9:0x0018 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        @Override // com.alimm.tanx.ui.image.glide.load.data.DataFetcher
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public com.alimm.tanx.ui.image.glide.load.model.ImageVideoWrapper loadData(com.alimm.tanx.ui.image.glide.Priority priority) throws java.lang.Exception {
            java.io.InputStream loadData;
            com.alimm.tanx.ui.image.glide.load.data.DataFetcher<android.os.ParcelFileDescriptor> dataFetcher;
            com.alimm.tanx.ui.image.glide.load.data.DataFetcher<java.io.InputStream> dataFetcher2 = this.streamFetcher;
            android.os.ParcelFileDescriptor parcelFileDescriptor = null;
            if (dataFetcher2 != null) {
                try {
                    loadData = dataFetcher2.loadData(priority);
                } catch (java.lang.Exception e) {
                    if (this.fileDescriptorFetcher == null) {
                        throw e;
                    }
                }
                dataFetcher = this.fileDescriptorFetcher;
                if (dataFetcher != null) {
                    try {
                        parcelFileDescriptor = dataFetcher.loadData(priority);
                    } catch (java.lang.Exception e2) {
                        if (loadData == null) {
                            throw e2;
                        }
                    }
                }
                return new com.alimm.tanx.ui.image.glide.load.model.ImageVideoWrapper(loadData, parcelFileDescriptor);
            }
            loadData = null;
            dataFetcher = this.fileDescriptorFetcher;
            if (dataFetcher != null) {
            }
            return new com.alimm.tanx.ui.image.glide.load.model.ImageVideoWrapper(loadData, parcelFileDescriptor);
        }
    }

    public ImageVideoModelLoader(com.alimm.tanx.ui.image.glide.load.model.ModelLoader<A, java.io.InputStream> modelLoader, com.alimm.tanx.ui.image.glide.load.model.ModelLoader<A, android.os.ParcelFileDescriptor> modelLoader2) {
        if (modelLoader == null && modelLoader2 == null) {
            throw new java.lang.NullPointerException("At least one of streamLoader and fileDescriptorLoader must be non null");
        }
        this.streamLoader = modelLoader;
        this.fileDescriptorLoader = modelLoader2;
    }

    @Override // com.alimm.tanx.ui.image.glide.load.model.ModelLoader
    public com.alimm.tanx.ui.image.glide.load.data.DataFetcher<com.alimm.tanx.ui.image.glide.load.model.ImageVideoWrapper> getResourceFetcher(A a, int i, int i2) {
        com.alimm.tanx.ui.image.glide.load.model.ModelLoader<A, java.io.InputStream> modelLoader = this.streamLoader;
        com.alimm.tanx.ui.image.glide.load.data.DataFetcher<java.io.InputStream> resourceFetcher = modelLoader != null ? modelLoader.getResourceFetcher(a, i, i2) : null;
        com.alimm.tanx.ui.image.glide.load.model.ModelLoader<A, android.os.ParcelFileDescriptor> modelLoader2 = this.fileDescriptorLoader;
        com.alimm.tanx.ui.image.glide.load.data.DataFetcher<android.os.ParcelFileDescriptor> resourceFetcher2 = modelLoader2 != null ? modelLoader2.getResourceFetcher(a, i, i2) : null;
        if (resourceFetcher == null && resourceFetcher2 == null) {
            return null;
        }
        return new com.alimm.tanx.ui.image.glide.load.model.ImageVideoModelLoader.ImageVideoFetcher(resourceFetcher, resourceFetcher2);
    }
}
