package com.bumptech.glide.load.model;

/* loaded from: classes.dex */
public class ByteBufferFileLoader implements com.bumptech.glide.load.model.ModelLoader<java.io.File, java.nio.ByteBuffer> {
    private static final java.lang.String TAG = "ByteBufferFileLoader";

    public static final class ByteBufferFetcher implements com.bumptech.glide.load.data.DataFetcher<java.nio.ByteBuffer> {
        private final java.io.File file;

        public ByteBufferFetcher(java.io.File file) {
            this.file = file;
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        public void cancel() {
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        public void cleanup() {
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        @androidx.annotation.NonNull
        public java.lang.Class<java.nio.ByteBuffer> getDataClass() {
            return java.nio.ByteBuffer.class;
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        @androidx.annotation.NonNull
        public com.bumptech.glide.load.DataSource getDataSource() {
            return com.bumptech.glide.load.DataSource.LOCAL;
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        public void loadData(@androidx.annotation.NonNull com.bumptech.glide.Priority priority, @androidx.annotation.NonNull com.bumptech.glide.load.data.DataFetcher.DataCallback<? super java.nio.ByteBuffer> dataCallback) {
            try {
                dataCallback.onDataReady(com.bumptech.glide.util.ByteBufferUtil.fromFile(this.file));
            } catch (java.io.IOException e) {
                dataCallback.onLoadFailed(e);
            }
        }
    }

    public static class Factory implements com.bumptech.glide.load.model.ModelLoaderFactory<java.io.File, java.nio.ByteBuffer> {
        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        @androidx.annotation.NonNull
        public com.bumptech.glide.load.model.ModelLoader<java.io.File, java.nio.ByteBuffer> build(@androidx.annotation.NonNull com.bumptech.glide.load.model.MultiModelLoaderFactory multiModelLoaderFactory) {
            return new com.bumptech.glide.load.model.ByteBufferFileLoader();
        }

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        public void teardown() {
        }
    }

    @Override // com.bumptech.glide.load.model.ModelLoader
    public com.bumptech.glide.load.model.ModelLoader.LoadData<java.nio.ByteBuffer> buildLoadData(@androidx.annotation.NonNull java.io.File file, int i, int i2, @androidx.annotation.NonNull com.bumptech.glide.load.Options options) {
        return new com.bumptech.glide.load.model.ModelLoader.LoadData<>(new com.bumptech.glide.signature.ObjectKey(file), new com.bumptech.glide.load.model.ByteBufferFileLoader.ByteBufferFetcher(file));
    }

    @Override // com.bumptech.glide.load.model.ModelLoader
    public boolean handles(@androidx.annotation.NonNull java.io.File file) {
        return true;
    }
}
