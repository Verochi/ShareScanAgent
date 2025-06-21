package com.bumptech.glide.load.model;

/* loaded from: classes.dex */
public class ByteArrayLoader<Data> implements com.bumptech.glide.load.model.ModelLoader<byte[], Data> {
    private final com.bumptech.glide.load.model.ByteArrayLoader.Converter<Data> converter;

    public static class ByteBufferFactory implements com.bumptech.glide.load.model.ModelLoaderFactory<byte[], java.nio.ByteBuffer> {

        /* renamed from: com.bumptech.glide.load.model.ByteArrayLoader$ByteBufferFactory$1, reason: invalid class name */
        public class AnonymousClass1 implements com.bumptech.glide.load.model.ByteArrayLoader.Converter<java.nio.ByteBuffer> {
            public AnonymousClass1() {
            }

            @Override // com.bumptech.glide.load.model.ByteArrayLoader.Converter
            public java.nio.ByteBuffer convert(byte[] bArr) {
                return java.nio.ByteBuffer.wrap(bArr);
            }

            @Override // com.bumptech.glide.load.model.ByteArrayLoader.Converter
            public java.lang.Class<java.nio.ByteBuffer> getDataClass() {
                return java.nio.ByteBuffer.class;
            }
        }

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        @androidx.annotation.NonNull
        public com.bumptech.glide.load.model.ModelLoader<byte[], java.nio.ByteBuffer> build(@androidx.annotation.NonNull com.bumptech.glide.load.model.MultiModelLoaderFactory multiModelLoaderFactory) {
            return new com.bumptech.glide.load.model.ByteArrayLoader(new com.bumptech.glide.load.model.ByteArrayLoader.ByteBufferFactory.AnonymousClass1());
        }

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        public void teardown() {
        }
    }

    public interface Converter<Data> {
        Data convert(byte[] bArr);

        java.lang.Class<Data> getDataClass();
    }

    public static class Fetcher<Data> implements com.bumptech.glide.load.data.DataFetcher<Data> {
        private final com.bumptech.glide.load.model.ByteArrayLoader.Converter<Data> converter;
        private final byte[] model;

        public Fetcher(byte[] bArr, com.bumptech.glide.load.model.ByteArrayLoader.Converter<Data> converter) {
            this.model = bArr;
            this.converter = converter;
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        public void cancel() {
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        public void cleanup() {
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        @androidx.annotation.NonNull
        public java.lang.Class<Data> getDataClass() {
            return this.converter.getDataClass();
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        @androidx.annotation.NonNull
        public com.bumptech.glide.load.DataSource getDataSource() {
            return com.bumptech.glide.load.DataSource.LOCAL;
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        public void loadData(@androidx.annotation.NonNull com.bumptech.glide.Priority priority, @androidx.annotation.NonNull com.bumptech.glide.load.data.DataFetcher.DataCallback<? super Data> dataCallback) {
            dataCallback.onDataReady(this.converter.convert(this.model));
        }
    }

    public static class StreamFactory implements com.bumptech.glide.load.model.ModelLoaderFactory<byte[], java.io.InputStream> {

        /* renamed from: com.bumptech.glide.load.model.ByteArrayLoader$StreamFactory$1, reason: invalid class name */
        public class AnonymousClass1 implements com.bumptech.glide.load.model.ByteArrayLoader.Converter<java.io.InputStream> {
            public AnonymousClass1() {
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.bumptech.glide.load.model.ByteArrayLoader.Converter
            public java.io.InputStream convert(byte[] bArr) {
                return new java.io.ByteArrayInputStream(bArr);
            }

            @Override // com.bumptech.glide.load.model.ByteArrayLoader.Converter
            public java.lang.Class<java.io.InputStream> getDataClass() {
                return java.io.InputStream.class;
            }
        }

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        @androidx.annotation.NonNull
        public com.bumptech.glide.load.model.ModelLoader<byte[], java.io.InputStream> build(@androidx.annotation.NonNull com.bumptech.glide.load.model.MultiModelLoaderFactory multiModelLoaderFactory) {
            return new com.bumptech.glide.load.model.ByteArrayLoader(new com.bumptech.glide.load.model.ByteArrayLoader.StreamFactory.AnonymousClass1());
        }

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        public void teardown() {
        }
    }

    public ByteArrayLoader(com.bumptech.glide.load.model.ByteArrayLoader.Converter<Data> converter) {
        this.converter = converter;
    }

    @Override // com.bumptech.glide.load.model.ModelLoader
    public com.bumptech.glide.load.model.ModelLoader.LoadData<Data> buildLoadData(@androidx.annotation.NonNull byte[] bArr, int i, int i2, @androidx.annotation.NonNull com.bumptech.glide.load.Options options) {
        return new com.bumptech.glide.load.model.ModelLoader.LoadData<>(new com.bumptech.glide.signature.ObjectKey(bArr), new com.bumptech.glide.load.model.ByteArrayLoader.Fetcher(bArr, this.converter));
    }

    @Override // com.bumptech.glide.load.model.ModelLoader
    public boolean handles(@androidx.annotation.NonNull byte[] bArr) {
        return true;
    }
}
