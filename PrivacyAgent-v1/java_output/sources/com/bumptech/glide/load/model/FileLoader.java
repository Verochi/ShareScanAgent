package com.bumptech.glide.load.model;

/* loaded from: classes.dex */
public class FileLoader<Data> implements com.bumptech.glide.load.model.ModelLoader<java.io.File, Data> {
    private static final java.lang.String TAG = "FileLoader";
    private final com.bumptech.glide.load.model.FileLoader.FileOpener<Data> fileOpener;

    public static class Factory<Data> implements com.bumptech.glide.load.model.ModelLoaderFactory<java.io.File, Data> {
        private final com.bumptech.glide.load.model.FileLoader.FileOpener<Data> opener;

        public Factory(com.bumptech.glide.load.model.FileLoader.FileOpener<Data> fileOpener) {
            this.opener = fileOpener;
        }

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        @androidx.annotation.NonNull
        public final com.bumptech.glide.load.model.ModelLoader<java.io.File, Data> build(@androidx.annotation.NonNull com.bumptech.glide.load.model.MultiModelLoaderFactory multiModelLoaderFactory) {
            return new com.bumptech.glide.load.model.FileLoader(this.opener);
        }

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        public final void teardown() {
        }
    }

    public static class FileDescriptorFactory extends com.bumptech.glide.load.model.FileLoader.Factory<android.os.ParcelFileDescriptor> {

        /* renamed from: com.bumptech.glide.load.model.FileLoader$FileDescriptorFactory$1, reason: invalid class name */
        public class AnonymousClass1 implements com.bumptech.glide.load.model.FileLoader.FileOpener<android.os.ParcelFileDescriptor> {
            @Override // com.bumptech.glide.load.model.FileLoader.FileOpener
            public void close(android.os.ParcelFileDescriptor parcelFileDescriptor) throws java.io.IOException {
                parcelFileDescriptor.close();
            }

            @Override // com.bumptech.glide.load.model.FileLoader.FileOpener
            public java.lang.Class<android.os.ParcelFileDescriptor> getDataClass() {
                return android.os.ParcelFileDescriptor.class;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.bumptech.glide.load.model.FileLoader.FileOpener
            public android.os.ParcelFileDescriptor open(java.io.File file) throws java.io.FileNotFoundException {
                return android.os.ParcelFileDescriptor.open(file, 268435456);
            }
        }

        public FileDescriptorFactory() {
            super(new com.bumptech.glide.load.model.FileLoader.FileDescriptorFactory.AnonymousClass1());
        }
    }

    public static final class FileFetcher<Data> implements com.bumptech.glide.load.data.DataFetcher<Data> {
        private Data data;
        private final java.io.File file;
        private final com.bumptech.glide.load.model.FileLoader.FileOpener<Data> opener;

        public FileFetcher(java.io.File file, com.bumptech.glide.load.model.FileLoader.FileOpener<Data> fileOpener) {
            this.file = file;
            this.opener = fileOpener;
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        public void cancel() {
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        public void cleanup() {
            Data data = this.data;
            if (data != null) {
                try {
                    this.opener.close(data);
                } catch (java.io.IOException unused) {
                }
            }
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        @androidx.annotation.NonNull
        public java.lang.Class<Data> getDataClass() {
            return this.opener.getDataClass();
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
                Data open = this.opener.open(this.file);
                this.data = open;
                dataCallback.onDataReady(open);
            } catch (java.io.FileNotFoundException e) {
                dataCallback.onLoadFailed(e);
            }
        }
    }

    public interface FileOpener<Data> {
        void close(Data data) throws java.io.IOException;

        java.lang.Class<Data> getDataClass();

        Data open(java.io.File file) throws java.io.FileNotFoundException;
    }

    public static class StreamFactory extends com.bumptech.glide.load.model.FileLoader.Factory<java.io.InputStream> {

        /* renamed from: com.bumptech.glide.load.model.FileLoader$StreamFactory$1, reason: invalid class name */
        public class AnonymousClass1 implements com.bumptech.glide.load.model.FileLoader.FileOpener<java.io.InputStream> {
            @Override // com.bumptech.glide.load.model.FileLoader.FileOpener
            public void close(java.io.InputStream inputStream) throws java.io.IOException {
                inputStream.close();
            }

            @Override // com.bumptech.glide.load.model.FileLoader.FileOpener
            public java.lang.Class<java.io.InputStream> getDataClass() {
                return java.io.InputStream.class;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.bumptech.glide.load.model.FileLoader.FileOpener
            public java.io.InputStream open(java.io.File file) throws java.io.FileNotFoundException {
                return new java.io.FileInputStream(file);
            }
        }

        public StreamFactory() {
            super(new com.bumptech.glide.load.model.FileLoader.StreamFactory.AnonymousClass1());
        }
    }

    public FileLoader(com.bumptech.glide.load.model.FileLoader.FileOpener<Data> fileOpener) {
        this.fileOpener = fileOpener;
    }

    @Override // com.bumptech.glide.load.model.ModelLoader
    public com.bumptech.glide.load.model.ModelLoader.LoadData<Data> buildLoadData(@androidx.annotation.NonNull java.io.File file, int i, int i2, @androidx.annotation.NonNull com.bumptech.glide.load.Options options) {
        return new com.bumptech.glide.load.model.ModelLoader.LoadData<>(new com.bumptech.glide.signature.ObjectKey(file), new com.bumptech.glide.load.model.FileLoader.FileFetcher(file, this.fileOpener));
    }

    @Override // com.bumptech.glide.load.model.ModelLoader
    public boolean handles(@androidx.annotation.NonNull java.io.File file) {
        return true;
    }
}
