package com.bumptech.glide.load.resource.bitmap;

/* loaded from: classes.dex */
public class VideoDecoder<T> implements com.bumptech.glide.load.ResourceDecoder<T, android.graphics.Bitmap> {
    public static final long DEFAULT_FRAME = -1;

    @androidx.annotation.VisibleForTesting
    static final int DEFAULT_FRAME_OPTION = 2;
    private static final java.lang.String TAG = "VideoDecoder";
    private final com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool bitmapPool;
    private final com.bumptech.glide.load.resource.bitmap.VideoDecoder.MediaMetadataRetrieverFactory factory;
    private final com.bumptech.glide.load.resource.bitmap.VideoDecoder.MediaMetadataRetrieverInitializer<T> initializer;
    public static final com.bumptech.glide.load.Option<java.lang.Long> TARGET_FRAME = com.bumptech.glide.load.Option.disk("com.bumptech.glide.load.resource.bitmap.VideoBitmapDecode.TargetFrame", -1L, new com.bumptech.glide.load.resource.bitmap.VideoDecoder.AnonymousClass1());
    public static final com.bumptech.glide.load.Option<java.lang.Integer> FRAME_OPTION = com.bumptech.glide.load.Option.disk("com.bumptech.glide.load.resource.bitmap.VideoBitmapDecode.FrameOption", 2, new com.bumptech.glide.load.resource.bitmap.VideoDecoder.AnonymousClass2());
    private static final com.bumptech.glide.load.resource.bitmap.VideoDecoder.MediaMetadataRetrieverFactory DEFAULT_FACTORY = new com.bumptech.glide.load.resource.bitmap.VideoDecoder.MediaMetadataRetrieverFactory();

    /* renamed from: com.bumptech.glide.load.resource.bitmap.VideoDecoder$1, reason: invalid class name */
    public class AnonymousClass1 implements com.bumptech.glide.load.Option.CacheKeyUpdater<java.lang.Long> {
        private final java.nio.ByteBuffer buffer = java.nio.ByteBuffer.allocate(8);

        @Override // com.bumptech.glide.load.Option.CacheKeyUpdater
        public void update(@androidx.annotation.NonNull byte[] bArr, @androidx.annotation.NonNull java.lang.Long l, @androidx.annotation.NonNull java.security.MessageDigest messageDigest) {
            messageDigest.update(bArr);
            synchronized (this.buffer) {
                this.buffer.position(0);
                messageDigest.update(this.buffer.putLong(l.longValue()).array());
            }
        }
    }

    /* renamed from: com.bumptech.glide.load.resource.bitmap.VideoDecoder$2, reason: invalid class name */
    public class AnonymousClass2 implements com.bumptech.glide.load.Option.CacheKeyUpdater<java.lang.Integer> {
        private final java.nio.ByteBuffer buffer = java.nio.ByteBuffer.allocate(4);

        @Override // com.bumptech.glide.load.Option.CacheKeyUpdater
        public void update(@androidx.annotation.NonNull byte[] bArr, @androidx.annotation.NonNull java.lang.Integer num, @androidx.annotation.NonNull java.security.MessageDigest messageDigest) {
            if (num == null) {
                return;
            }
            messageDigest.update(bArr);
            synchronized (this.buffer) {
                this.buffer.position(0);
                messageDigest.update(this.buffer.putInt(num.intValue()).array());
            }
        }
    }

    public static final class AssetFileDescriptorInitializer implements com.bumptech.glide.load.resource.bitmap.VideoDecoder.MediaMetadataRetrieverInitializer<android.content.res.AssetFileDescriptor> {
        private AssetFileDescriptorInitializer() {
        }

        public /* synthetic */ AssetFileDescriptorInitializer(com.bumptech.glide.load.resource.bitmap.VideoDecoder.AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // com.bumptech.glide.load.resource.bitmap.VideoDecoder.MediaMetadataRetrieverInitializer
        public void initialize(android.media.MediaMetadataRetriever mediaMetadataRetriever, android.content.res.AssetFileDescriptor assetFileDescriptor) {
            mediaMetadataRetriever.setDataSource(assetFileDescriptor.getFileDescriptor(), assetFileDescriptor.getStartOffset(), assetFileDescriptor.getLength());
        }
    }

    @androidx.annotation.RequiresApi(23)
    public static final class ByteBufferInitializer implements com.bumptech.glide.load.resource.bitmap.VideoDecoder.MediaMetadataRetrieverInitializer<java.nio.ByteBuffer> {

        /* renamed from: com.bumptech.glide.load.resource.bitmap.VideoDecoder$ByteBufferInitializer$1, reason: invalid class name */
        public class AnonymousClass1 extends android.media.MediaDataSource {
            final /* synthetic */ java.nio.ByteBuffer val$data;

            public AnonymousClass1(java.nio.ByteBuffer byteBuffer) {
                this.val$data = byteBuffer;
            }

            @Override // java.io.Closeable, java.lang.AutoCloseable
            public void close() {
            }

            @Override // android.media.MediaDataSource
            public long getSize() {
                return this.val$data.limit();
            }

            @Override // android.media.MediaDataSource
            public int readAt(long j, byte[] bArr, int i, int i2) {
                if (j >= this.val$data.limit()) {
                    return -1;
                }
                this.val$data.position((int) j);
                int min = java.lang.Math.min(i2, this.val$data.remaining());
                this.val$data.get(bArr, i, min);
                return min;
            }
        }

        @Override // com.bumptech.glide.load.resource.bitmap.VideoDecoder.MediaMetadataRetrieverInitializer
        public void initialize(android.media.MediaMetadataRetriever mediaMetadataRetriever, java.nio.ByteBuffer byteBuffer) {
            mediaMetadataRetriever.setDataSource(new com.bumptech.glide.load.resource.bitmap.VideoDecoder.ByteBufferInitializer.AnonymousClass1(byteBuffer));
        }
    }

    @androidx.annotation.VisibleForTesting
    public static class MediaMetadataRetrieverFactory {
        public android.media.MediaMetadataRetriever build() {
            return new android.media.MediaMetadataRetriever();
        }
    }

    @androidx.annotation.VisibleForTesting
    public interface MediaMetadataRetrieverInitializer<T> {
        void initialize(android.media.MediaMetadataRetriever mediaMetadataRetriever, T t);
    }

    public static final class ParcelFileDescriptorInitializer implements com.bumptech.glide.load.resource.bitmap.VideoDecoder.MediaMetadataRetrieverInitializer<android.os.ParcelFileDescriptor> {
        @Override // com.bumptech.glide.load.resource.bitmap.VideoDecoder.MediaMetadataRetrieverInitializer
        public void initialize(android.media.MediaMetadataRetriever mediaMetadataRetriever, android.os.ParcelFileDescriptor parcelFileDescriptor) {
            mediaMetadataRetriever.setDataSource(parcelFileDescriptor.getFileDescriptor());
        }
    }

    public VideoDecoder(com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool bitmapPool, com.bumptech.glide.load.resource.bitmap.VideoDecoder.MediaMetadataRetrieverInitializer<T> mediaMetadataRetrieverInitializer) {
        this(bitmapPool, mediaMetadataRetrieverInitializer, DEFAULT_FACTORY);
    }

    @androidx.annotation.VisibleForTesting
    public VideoDecoder(com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool bitmapPool, com.bumptech.glide.load.resource.bitmap.VideoDecoder.MediaMetadataRetrieverInitializer<T> mediaMetadataRetrieverInitializer, com.bumptech.glide.load.resource.bitmap.VideoDecoder.MediaMetadataRetrieverFactory mediaMetadataRetrieverFactory) {
        this.bitmapPool = bitmapPool;
        this.initializer = mediaMetadataRetrieverInitializer;
        this.factory = mediaMetadataRetrieverFactory;
    }

    public static com.bumptech.glide.load.ResourceDecoder<android.content.res.AssetFileDescriptor, android.graphics.Bitmap> asset(com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool bitmapPool) {
        return new com.bumptech.glide.load.resource.bitmap.VideoDecoder(bitmapPool, new com.bumptech.glide.load.resource.bitmap.VideoDecoder.AssetFileDescriptorInitializer(null));
    }

    @androidx.annotation.RequiresApi(api = 23)
    public static com.bumptech.glide.load.ResourceDecoder<java.nio.ByteBuffer, android.graphics.Bitmap> byteBuffer(com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool bitmapPool) {
        return new com.bumptech.glide.load.resource.bitmap.VideoDecoder(bitmapPool, new com.bumptech.glide.load.resource.bitmap.VideoDecoder.ByteBufferInitializer());
    }

    @androidx.annotation.Nullable
    private static android.graphics.Bitmap decodeFrame(android.media.MediaMetadataRetriever mediaMetadataRetriever, long j, int i, int i2, int i3, com.bumptech.glide.load.resource.bitmap.DownsampleStrategy downsampleStrategy) {
        android.graphics.Bitmap decodeScaledFrame = (android.os.Build.VERSION.SDK_INT < 27 || i2 == Integer.MIN_VALUE || i3 == Integer.MIN_VALUE || downsampleStrategy == com.bumptech.glide.load.resource.bitmap.DownsampleStrategy.NONE) ? null : decodeScaledFrame(mediaMetadataRetriever, j, i, i2, i3, downsampleStrategy);
        return decodeScaledFrame == null ? decodeOriginalFrame(mediaMetadataRetriever, j, i) : decodeScaledFrame;
    }

    private static android.graphics.Bitmap decodeOriginalFrame(android.media.MediaMetadataRetriever mediaMetadataRetriever, long j, int i) {
        return mediaMetadataRetriever.getFrameAtTime(j, i);
    }

    @android.annotation.TargetApi(27)
    private static android.graphics.Bitmap decodeScaledFrame(android.media.MediaMetadataRetriever mediaMetadataRetriever, long j, int i, int i2, int i3, com.bumptech.glide.load.resource.bitmap.DownsampleStrategy downsampleStrategy) {
        android.graphics.Bitmap scaledFrameAtTime;
        try {
            int parseInt = java.lang.Integer.parseInt(mediaMetadataRetriever.extractMetadata(18));
            int parseInt2 = java.lang.Integer.parseInt(mediaMetadataRetriever.extractMetadata(19));
            int parseInt3 = java.lang.Integer.parseInt(mediaMetadataRetriever.extractMetadata(24));
            if (parseInt3 == 90 || parseInt3 == 270) {
                parseInt2 = parseInt;
                parseInt = parseInt2;
            }
            float scaleFactor = downsampleStrategy.getScaleFactor(parseInt, parseInt2, i2, i3);
            scaledFrameAtTime = mediaMetadataRetriever.getScaledFrameAtTime(j, i, java.lang.Math.round(parseInt * scaleFactor), java.lang.Math.round(scaleFactor * parseInt2));
            return scaledFrameAtTime;
        } catch (java.lang.Throwable unused) {
            return null;
        }
    }

    public static com.bumptech.glide.load.ResourceDecoder<android.os.ParcelFileDescriptor, android.graphics.Bitmap> parcel(com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool bitmapPool) {
        return new com.bumptech.glide.load.resource.bitmap.VideoDecoder(bitmapPool, new com.bumptech.glide.load.resource.bitmap.VideoDecoder.ParcelFileDescriptorInitializer());
    }

    @Override // com.bumptech.glide.load.ResourceDecoder
    public com.bumptech.glide.load.engine.Resource<android.graphics.Bitmap> decode(@androidx.annotation.NonNull T t, int i, int i2, @androidx.annotation.NonNull com.bumptech.glide.load.Options options) throws java.io.IOException {
        long longValue = ((java.lang.Long) options.get(TARGET_FRAME)).longValue();
        if (longValue < 0 && longValue != -1) {
            throw new java.lang.IllegalArgumentException("Requested frame must be non-negative, or DEFAULT_FRAME, given: " + longValue);
        }
        java.lang.Integer num = (java.lang.Integer) options.get(FRAME_OPTION);
        if (num == null) {
            num = 2;
        }
        com.bumptech.glide.load.resource.bitmap.DownsampleStrategy downsampleStrategy = (com.bumptech.glide.load.resource.bitmap.DownsampleStrategy) options.get(com.bumptech.glide.load.resource.bitmap.DownsampleStrategy.OPTION);
        if (downsampleStrategy == null) {
            downsampleStrategy = com.bumptech.glide.load.resource.bitmap.DownsampleStrategy.DEFAULT;
        }
        com.bumptech.glide.load.resource.bitmap.DownsampleStrategy downsampleStrategy2 = downsampleStrategy;
        android.media.MediaMetadataRetriever build = this.factory.build();
        try {
            try {
                this.initializer.initialize(build, t);
                android.graphics.Bitmap decodeFrame = decodeFrame(build, longValue, num.intValue(), i, i2, downsampleStrategy2);
                build.release();
                return com.bumptech.glide.load.resource.bitmap.BitmapResource.obtain(decodeFrame, this.bitmapPool);
            } catch (java.lang.RuntimeException e) {
                throw new java.io.IOException(e);
            }
        } catch (java.lang.Throwable th) {
            build.release();
            throw th;
        }
    }

    @Override // com.bumptech.glide.load.ResourceDecoder
    public boolean handles(@androidx.annotation.NonNull T t, @androidx.annotation.NonNull com.bumptech.glide.load.Options options) {
        return true;
    }
}
