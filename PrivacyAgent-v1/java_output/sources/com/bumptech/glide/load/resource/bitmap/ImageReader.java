package com.bumptech.glide.load.resource.bitmap;

/* loaded from: classes.dex */
interface ImageReader {

    public static final class InputStreamImageReader implements com.bumptech.glide.load.resource.bitmap.ImageReader {
        private final com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool byteArrayPool;
        private final com.bumptech.glide.load.data.InputStreamRewinder dataRewinder;
        private final java.util.List<com.bumptech.glide.load.ImageHeaderParser> parsers;

        public InputStreamImageReader(java.io.InputStream inputStream, java.util.List<com.bumptech.glide.load.ImageHeaderParser> list, com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool arrayPool) {
            this.byteArrayPool = (com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool) com.bumptech.glide.util.Preconditions.checkNotNull(arrayPool);
            this.parsers = (java.util.List) com.bumptech.glide.util.Preconditions.checkNotNull(list);
            this.dataRewinder = new com.bumptech.glide.load.data.InputStreamRewinder(inputStream, arrayPool);
        }

        @Override // com.bumptech.glide.load.resource.bitmap.ImageReader
        @androidx.annotation.Nullable
        public android.graphics.Bitmap decodeBitmap(android.graphics.BitmapFactory.Options options) throws java.io.IOException {
            return android.graphics.BitmapFactory.decodeStream(this.dataRewinder.rewindAndGet(), null, options);
        }

        @Override // com.bumptech.glide.load.resource.bitmap.ImageReader
        public int getImageOrientation() throws java.io.IOException {
            return com.bumptech.glide.load.ImageHeaderParserUtils.getOrientation(this.parsers, this.dataRewinder.rewindAndGet(), this.byteArrayPool);
        }

        @Override // com.bumptech.glide.load.resource.bitmap.ImageReader
        public com.bumptech.glide.load.ImageHeaderParser.ImageType getImageType() throws java.io.IOException {
            return com.bumptech.glide.load.ImageHeaderParserUtils.getType(this.parsers, this.dataRewinder.rewindAndGet(), this.byteArrayPool);
        }

        @Override // com.bumptech.glide.load.resource.bitmap.ImageReader
        public void stopGrowingBuffers() {
            this.dataRewinder.fixMarkLimits();
        }
    }

    @androidx.annotation.RequiresApi(21)
    public static final class ParcelFileDescriptorImageReader implements com.bumptech.glide.load.resource.bitmap.ImageReader {
        private final com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool byteArrayPool;
        private final com.bumptech.glide.load.data.ParcelFileDescriptorRewinder dataRewinder;
        private final java.util.List<com.bumptech.glide.load.ImageHeaderParser> parsers;

        public ParcelFileDescriptorImageReader(android.os.ParcelFileDescriptor parcelFileDescriptor, java.util.List<com.bumptech.glide.load.ImageHeaderParser> list, com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool arrayPool) {
            this.byteArrayPool = (com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool) com.bumptech.glide.util.Preconditions.checkNotNull(arrayPool);
            this.parsers = (java.util.List) com.bumptech.glide.util.Preconditions.checkNotNull(list);
            this.dataRewinder = new com.bumptech.glide.load.data.ParcelFileDescriptorRewinder(parcelFileDescriptor);
        }

        @Override // com.bumptech.glide.load.resource.bitmap.ImageReader
        @androidx.annotation.Nullable
        public android.graphics.Bitmap decodeBitmap(android.graphics.BitmapFactory.Options options) throws java.io.IOException {
            return android.graphics.BitmapFactory.decodeFileDescriptor(this.dataRewinder.rewindAndGet().getFileDescriptor(), null, options);
        }

        @Override // com.bumptech.glide.load.resource.bitmap.ImageReader
        public int getImageOrientation() throws java.io.IOException {
            return com.bumptech.glide.load.ImageHeaderParserUtils.getOrientation(this.parsers, this.dataRewinder, this.byteArrayPool);
        }

        @Override // com.bumptech.glide.load.resource.bitmap.ImageReader
        public com.bumptech.glide.load.ImageHeaderParser.ImageType getImageType() throws java.io.IOException {
            return com.bumptech.glide.load.ImageHeaderParserUtils.getType(this.parsers, this.dataRewinder, this.byteArrayPool);
        }

        @Override // com.bumptech.glide.load.resource.bitmap.ImageReader
        public void stopGrowingBuffers() {
        }
    }

    @androidx.annotation.Nullable
    android.graphics.Bitmap decodeBitmap(android.graphics.BitmapFactory.Options options) throws java.io.IOException;

    int getImageOrientation() throws java.io.IOException;

    com.bumptech.glide.load.ImageHeaderParser.ImageType getImageType() throws java.io.IOException;

    void stopGrowingBuffers();
}
