package com.bumptech.glide.load;

/* loaded from: classes.dex */
public final class ImageHeaderParserUtils {
    private static final int MARK_READ_LIMIT = 5242880;

    /* renamed from: com.bumptech.glide.load.ImageHeaderParserUtils$1, reason: invalid class name */
    public class AnonymousClass1 implements com.bumptech.glide.load.ImageHeaderParserUtils.TypeReader {
        final /* synthetic */ java.io.InputStream val$finalIs;

        public AnonymousClass1(java.io.InputStream inputStream) {
            this.val$finalIs = inputStream;
        }

        @Override // com.bumptech.glide.load.ImageHeaderParserUtils.TypeReader
        public com.bumptech.glide.load.ImageHeaderParser.ImageType getType(com.bumptech.glide.load.ImageHeaderParser imageHeaderParser) throws java.io.IOException {
            try {
                return imageHeaderParser.getType(this.val$finalIs);
            } finally {
                this.val$finalIs.reset();
            }
        }
    }

    /* renamed from: com.bumptech.glide.load.ImageHeaderParserUtils$2, reason: invalid class name */
    public class AnonymousClass2 implements com.bumptech.glide.load.ImageHeaderParserUtils.TypeReader {
        final /* synthetic */ java.nio.ByteBuffer val$buffer;

        public AnonymousClass2(java.nio.ByteBuffer byteBuffer) {
            this.val$buffer = byteBuffer;
        }

        @Override // com.bumptech.glide.load.ImageHeaderParserUtils.TypeReader
        public com.bumptech.glide.load.ImageHeaderParser.ImageType getType(com.bumptech.glide.load.ImageHeaderParser imageHeaderParser) throws java.io.IOException {
            return imageHeaderParser.getType(this.val$buffer);
        }
    }

    /* renamed from: com.bumptech.glide.load.ImageHeaderParserUtils$3, reason: invalid class name */
    public class AnonymousClass3 implements com.bumptech.glide.load.ImageHeaderParserUtils.TypeReader {
        final /* synthetic */ com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool val$byteArrayPool;
        final /* synthetic */ com.bumptech.glide.load.data.ParcelFileDescriptorRewinder val$parcelFileDescriptorRewinder;

        public AnonymousClass3(com.bumptech.glide.load.data.ParcelFileDescriptorRewinder parcelFileDescriptorRewinder, com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool arrayPool) {
            this.val$parcelFileDescriptorRewinder = parcelFileDescriptorRewinder;
            this.val$byteArrayPool = arrayPool;
        }

        @Override // com.bumptech.glide.load.ImageHeaderParserUtils.TypeReader
        public com.bumptech.glide.load.ImageHeaderParser.ImageType getType(com.bumptech.glide.load.ImageHeaderParser imageHeaderParser) throws java.io.IOException {
            com.bumptech.glide.load.resource.bitmap.RecyclableBufferedInputStream recyclableBufferedInputStream = null;
            try {
                com.bumptech.glide.load.resource.bitmap.RecyclableBufferedInputStream recyclableBufferedInputStream2 = new com.bumptech.glide.load.resource.bitmap.RecyclableBufferedInputStream(new java.io.FileInputStream(this.val$parcelFileDescriptorRewinder.rewindAndGet().getFileDescriptor()), this.val$byteArrayPool);
                try {
                    com.bumptech.glide.load.ImageHeaderParser.ImageType type = imageHeaderParser.getType(recyclableBufferedInputStream2);
                    try {
                        recyclableBufferedInputStream2.close();
                    } catch (java.io.IOException unused) {
                    }
                    this.val$parcelFileDescriptorRewinder.rewindAndGet();
                    return type;
                } catch (java.lang.Throwable th) {
                    th = th;
                    recyclableBufferedInputStream = recyclableBufferedInputStream2;
                    if (recyclableBufferedInputStream != null) {
                        try {
                            recyclableBufferedInputStream.close();
                        } catch (java.io.IOException unused2) {
                        }
                    }
                    this.val$parcelFileDescriptorRewinder.rewindAndGet();
                    throw th;
                }
            } catch (java.lang.Throwable th2) {
                th = th2;
            }
        }
    }

    /* renamed from: com.bumptech.glide.load.ImageHeaderParserUtils$4, reason: invalid class name */
    public class AnonymousClass4 implements com.bumptech.glide.load.ImageHeaderParserUtils.OrientationReader {
        final /* synthetic */ com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool val$byteArrayPool;
        final /* synthetic */ java.io.InputStream val$finalIs;

        public AnonymousClass4(java.io.InputStream inputStream, com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool arrayPool) {
            this.val$finalIs = inputStream;
            this.val$byteArrayPool = arrayPool;
        }

        @Override // com.bumptech.glide.load.ImageHeaderParserUtils.OrientationReader
        public int getOrientation(com.bumptech.glide.load.ImageHeaderParser imageHeaderParser) throws java.io.IOException {
            try {
                return imageHeaderParser.getOrientation(this.val$finalIs, this.val$byteArrayPool);
            } finally {
                this.val$finalIs.reset();
            }
        }
    }

    /* renamed from: com.bumptech.glide.load.ImageHeaderParserUtils$5, reason: invalid class name */
    public class AnonymousClass5 implements com.bumptech.glide.load.ImageHeaderParserUtils.OrientationReader {
        final /* synthetic */ com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool val$byteArrayPool;
        final /* synthetic */ com.bumptech.glide.load.data.ParcelFileDescriptorRewinder val$parcelFileDescriptorRewinder;

        public AnonymousClass5(com.bumptech.glide.load.data.ParcelFileDescriptorRewinder parcelFileDescriptorRewinder, com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool arrayPool) {
            this.val$parcelFileDescriptorRewinder = parcelFileDescriptorRewinder;
            this.val$byteArrayPool = arrayPool;
        }

        @Override // com.bumptech.glide.load.ImageHeaderParserUtils.OrientationReader
        public int getOrientation(com.bumptech.glide.load.ImageHeaderParser imageHeaderParser) throws java.io.IOException {
            com.bumptech.glide.load.resource.bitmap.RecyclableBufferedInputStream recyclableBufferedInputStream = null;
            try {
                com.bumptech.glide.load.resource.bitmap.RecyclableBufferedInputStream recyclableBufferedInputStream2 = new com.bumptech.glide.load.resource.bitmap.RecyclableBufferedInputStream(new java.io.FileInputStream(this.val$parcelFileDescriptorRewinder.rewindAndGet().getFileDescriptor()), this.val$byteArrayPool);
                try {
                    int orientation = imageHeaderParser.getOrientation(recyclableBufferedInputStream2, this.val$byteArrayPool);
                    try {
                        recyclableBufferedInputStream2.close();
                    } catch (java.io.IOException unused) {
                    }
                    this.val$parcelFileDescriptorRewinder.rewindAndGet();
                    return orientation;
                } catch (java.lang.Throwable th) {
                    th = th;
                    recyclableBufferedInputStream = recyclableBufferedInputStream2;
                    if (recyclableBufferedInputStream != null) {
                        try {
                            recyclableBufferedInputStream.close();
                        } catch (java.io.IOException unused2) {
                        }
                    }
                    this.val$parcelFileDescriptorRewinder.rewindAndGet();
                    throw th;
                }
            } catch (java.lang.Throwable th2) {
                th = th2;
            }
        }
    }

    public interface OrientationReader {
        int getOrientation(com.bumptech.glide.load.ImageHeaderParser imageHeaderParser) throws java.io.IOException;
    }

    public interface TypeReader {
        com.bumptech.glide.load.ImageHeaderParser.ImageType getType(com.bumptech.glide.load.ImageHeaderParser imageHeaderParser) throws java.io.IOException;
    }

    private ImageHeaderParserUtils() {
    }

    @androidx.annotation.RequiresApi(21)
    public static int getOrientation(@androidx.annotation.NonNull java.util.List<com.bumptech.glide.load.ImageHeaderParser> list, @androidx.annotation.NonNull com.bumptech.glide.load.data.ParcelFileDescriptorRewinder parcelFileDescriptorRewinder, @androidx.annotation.NonNull com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool arrayPool) throws java.io.IOException {
        return getOrientationInternal(list, new com.bumptech.glide.load.ImageHeaderParserUtils.AnonymousClass5(parcelFileDescriptorRewinder, arrayPool));
    }

    public static int getOrientation(@androidx.annotation.NonNull java.util.List<com.bumptech.glide.load.ImageHeaderParser> list, @androidx.annotation.Nullable java.io.InputStream inputStream, @androidx.annotation.NonNull com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool arrayPool) throws java.io.IOException {
        if (inputStream == null) {
            return -1;
        }
        if (!inputStream.markSupported()) {
            inputStream = new com.bumptech.glide.load.resource.bitmap.RecyclableBufferedInputStream(inputStream, arrayPool);
        }
        inputStream.mark(MARK_READ_LIMIT);
        return getOrientationInternal(list, new com.bumptech.glide.load.ImageHeaderParserUtils.AnonymousClass4(inputStream, arrayPool));
    }

    private static int getOrientationInternal(@androidx.annotation.NonNull java.util.List<com.bumptech.glide.load.ImageHeaderParser> list, com.bumptech.glide.load.ImageHeaderParserUtils.OrientationReader orientationReader) throws java.io.IOException {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            int orientation = orientationReader.getOrientation(list.get(i));
            if (orientation != -1) {
                return orientation;
            }
        }
        return -1;
    }

    @androidx.annotation.NonNull
    @androidx.annotation.RequiresApi(21)
    public static com.bumptech.glide.load.ImageHeaderParser.ImageType getType(@androidx.annotation.NonNull java.util.List<com.bumptech.glide.load.ImageHeaderParser> list, @androidx.annotation.NonNull com.bumptech.glide.load.data.ParcelFileDescriptorRewinder parcelFileDescriptorRewinder, @androidx.annotation.NonNull com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool arrayPool) throws java.io.IOException {
        return getTypeInternal(list, new com.bumptech.glide.load.ImageHeaderParserUtils.AnonymousClass3(parcelFileDescriptorRewinder, arrayPool));
    }

    @androidx.annotation.NonNull
    public static com.bumptech.glide.load.ImageHeaderParser.ImageType getType(@androidx.annotation.NonNull java.util.List<com.bumptech.glide.load.ImageHeaderParser> list, @androidx.annotation.Nullable java.io.InputStream inputStream, @androidx.annotation.NonNull com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool arrayPool) throws java.io.IOException {
        if (inputStream == null) {
            return com.bumptech.glide.load.ImageHeaderParser.ImageType.UNKNOWN;
        }
        if (!inputStream.markSupported()) {
            inputStream = new com.bumptech.glide.load.resource.bitmap.RecyclableBufferedInputStream(inputStream, arrayPool);
        }
        inputStream.mark(MARK_READ_LIMIT);
        return getTypeInternal(list, new com.bumptech.glide.load.ImageHeaderParserUtils.AnonymousClass1(inputStream));
    }

    @androidx.annotation.NonNull
    public static com.bumptech.glide.load.ImageHeaderParser.ImageType getType(@androidx.annotation.NonNull java.util.List<com.bumptech.glide.load.ImageHeaderParser> list, @androidx.annotation.Nullable java.nio.ByteBuffer byteBuffer) throws java.io.IOException {
        return byteBuffer == null ? com.bumptech.glide.load.ImageHeaderParser.ImageType.UNKNOWN : getTypeInternal(list, new com.bumptech.glide.load.ImageHeaderParserUtils.AnonymousClass2(byteBuffer));
    }

    @androidx.annotation.NonNull
    private static com.bumptech.glide.load.ImageHeaderParser.ImageType getTypeInternal(@androidx.annotation.NonNull java.util.List<com.bumptech.glide.load.ImageHeaderParser> list, com.bumptech.glide.load.ImageHeaderParserUtils.TypeReader typeReader) throws java.io.IOException {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            com.bumptech.glide.load.ImageHeaderParser.ImageType type = typeReader.getType(list.get(i));
            if (type != com.bumptech.glide.load.ImageHeaderParser.ImageType.UNKNOWN) {
                return type;
            }
        }
        return com.bumptech.glide.load.ImageHeaderParser.ImageType.UNKNOWN;
    }
}
