package com.bumptech.glide.load.model;

/* loaded from: classes.dex */
public final class DataUrlLoader<Model, Data> implements com.bumptech.glide.load.model.ModelLoader<Model, Data> {
    private static final java.lang.String BASE64_TAG = ";base64";
    private static final java.lang.String DATA_SCHEME_IMAGE = "data:image";
    private final com.bumptech.glide.load.model.DataUrlLoader.DataDecoder<Data> dataDecoder;

    public interface DataDecoder<Data> {
        void close(Data data) throws java.io.IOException;

        Data decode(java.lang.String str) throws java.lang.IllegalArgumentException;

        java.lang.Class<Data> getDataClass();
    }

    public static final class DataUriFetcher<Data> implements com.bumptech.glide.load.data.DataFetcher<Data> {
        private Data data;
        private final java.lang.String dataUri;
        private final com.bumptech.glide.load.model.DataUrlLoader.DataDecoder<Data> reader;

        public DataUriFetcher(java.lang.String str, com.bumptech.glide.load.model.DataUrlLoader.DataDecoder<Data> dataDecoder) {
            this.dataUri = str;
            this.reader = dataDecoder;
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        public void cancel() {
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        public void cleanup() {
            try {
                this.reader.close(this.data);
            } catch (java.io.IOException unused) {
            }
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        @androidx.annotation.NonNull
        public java.lang.Class<Data> getDataClass() {
            return this.reader.getDataClass();
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        @androidx.annotation.NonNull
        public com.bumptech.glide.load.DataSource getDataSource() {
            return com.bumptech.glide.load.DataSource.LOCAL;
        }

        /* JADX WARN: Type inference failed for: r2v3, types: [Data, java.lang.Object] */
        @Override // com.bumptech.glide.load.data.DataFetcher
        public void loadData(@androidx.annotation.NonNull com.bumptech.glide.Priority priority, @androidx.annotation.NonNull com.bumptech.glide.load.data.DataFetcher.DataCallback<? super Data> dataCallback) {
            try {
                Data decode = this.reader.decode(this.dataUri);
                this.data = decode;
                dataCallback.onDataReady(decode);
            } catch (java.lang.IllegalArgumentException e) {
                dataCallback.onLoadFailed(e);
            }
        }
    }

    public static final class StreamFactory<Model> implements com.bumptech.glide.load.model.ModelLoaderFactory<Model, java.io.InputStream> {
        private final com.bumptech.glide.load.model.DataUrlLoader.DataDecoder<java.io.InputStream> opener = new com.bumptech.glide.load.model.DataUrlLoader.StreamFactory.AnonymousClass1();

        /* renamed from: com.bumptech.glide.load.model.DataUrlLoader$StreamFactory$1, reason: invalid class name */
        public class AnonymousClass1 implements com.bumptech.glide.load.model.DataUrlLoader.DataDecoder<java.io.InputStream> {
            public AnonymousClass1() {
            }

            @Override // com.bumptech.glide.load.model.DataUrlLoader.DataDecoder
            public void close(java.io.InputStream inputStream) throws java.io.IOException {
                inputStream.close();
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.bumptech.glide.load.model.DataUrlLoader.DataDecoder
            public java.io.InputStream decode(java.lang.String str) {
                if (!str.startsWith(com.bumptech.glide.load.model.DataUrlLoader.DATA_SCHEME_IMAGE)) {
                    throw new java.lang.IllegalArgumentException("Not a valid image data URL.");
                }
                int indexOf = str.indexOf(44);
                if (indexOf == -1) {
                    throw new java.lang.IllegalArgumentException("Missing comma in data URL.");
                }
                if (str.substring(0, indexOf).endsWith(com.bumptech.glide.load.model.DataUrlLoader.BASE64_TAG)) {
                    return new java.io.ByteArrayInputStream(android.util.Base64.decode(str.substring(indexOf + 1), 0));
                }
                throw new java.lang.IllegalArgumentException("Not a base64 image data URL.");
            }

            @Override // com.bumptech.glide.load.model.DataUrlLoader.DataDecoder
            public java.lang.Class<java.io.InputStream> getDataClass() {
                return java.io.InputStream.class;
            }
        }

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        @androidx.annotation.NonNull
        public com.bumptech.glide.load.model.ModelLoader<Model, java.io.InputStream> build(@androidx.annotation.NonNull com.bumptech.glide.load.model.MultiModelLoaderFactory multiModelLoaderFactory) {
            return new com.bumptech.glide.load.model.DataUrlLoader(this.opener);
        }

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        public void teardown() {
        }
    }

    public DataUrlLoader(com.bumptech.glide.load.model.DataUrlLoader.DataDecoder<Data> dataDecoder) {
        this.dataDecoder = dataDecoder;
    }

    @Override // com.bumptech.glide.load.model.ModelLoader
    public com.bumptech.glide.load.model.ModelLoader.LoadData<Data> buildLoadData(@androidx.annotation.NonNull Model model, int i, int i2, @androidx.annotation.NonNull com.bumptech.glide.load.Options options) {
        return new com.bumptech.glide.load.model.ModelLoader.LoadData<>(new com.bumptech.glide.signature.ObjectKey(model), new com.bumptech.glide.load.model.DataUrlLoader.DataUriFetcher(model.toString(), this.dataDecoder));
    }

    @Override // com.bumptech.glide.load.model.ModelLoader
    public boolean handles(@androidx.annotation.NonNull Model model) {
        return model.toString().startsWith(DATA_SCHEME_IMAGE);
    }
}
