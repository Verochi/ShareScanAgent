package com.alimm.tanx.ui.image.glide.load.resource.bitmap;

/* loaded from: classes.dex */
public abstract class Downsampler implements com.alimm.tanx.ui.image.glide.load.resource.bitmap.BitmapDecoder<java.io.InputStream> {
    private static final int MARK_POSITION = 5242880;
    private static final java.lang.String TAG = "Downsampler";
    private static final java.util.Set<com.alimm.tanx.ui.image.glide.load.resource.bitmap.ImageHeaderParser.ImageType> TYPES_THAT_USE_POOL = java.util.EnumSet.of(com.alimm.tanx.ui.image.glide.load.resource.bitmap.ImageHeaderParser.ImageType.JPEG, com.alimm.tanx.ui.image.glide.load.resource.bitmap.ImageHeaderParser.ImageType.PNG_A, com.alimm.tanx.ui.image.glide.load.resource.bitmap.ImageHeaderParser.ImageType.PNG);
    private static final java.util.Queue<android.graphics.BitmapFactory.Options> OPTIONS_QUEUE = com.alimm.tanx.ui.image.glide.util.Util.createQueue(0);
    public static final com.alimm.tanx.ui.image.glide.load.resource.bitmap.Downsampler AT_LEAST = new com.alimm.tanx.ui.image.glide.load.resource.bitmap.Downsampler.AnonymousClass1();
    public static final com.alimm.tanx.ui.image.glide.load.resource.bitmap.Downsampler AT_MOST = new com.alimm.tanx.ui.image.glide.load.resource.bitmap.Downsampler.AnonymousClass2();
    public static final com.alimm.tanx.ui.image.glide.load.resource.bitmap.Downsampler NONE = new com.alimm.tanx.ui.image.glide.load.resource.bitmap.Downsampler.AnonymousClass3();

    /* renamed from: com.alimm.tanx.ui.image.glide.load.resource.bitmap.Downsampler$1, reason: invalid class name */
    public static class AnonymousClass1 extends com.alimm.tanx.ui.image.glide.load.resource.bitmap.Downsampler {
        @Override // com.alimm.tanx.ui.image.glide.load.resource.bitmap.Downsampler, com.alimm.tanx.ui.image.glide.load.resource.bitmap.BitmapDecoder
        public /* bridge */ /* synthetic */ android.graphics.Bitmap decode(java.io.InputStream inputStream, com.alimm.tanx.ui.image.glide.load.engine.bitmap_recycle.BitmapPool bitmapPool, int i, int i2, com.alimm.tanx.ui.image.glide.load.DecodeFormat decodeFormat) throws java.lang.Exception {
            return super.decode(inputStream, bitmapPool, i, i2, decodeFormat);
        }

        @Override // com.alimm.tanx.ui.image.glide.load.resource.bitmap.BitmapDecoder
        public java.lang.String getId() {
            return "AT_LEAST.com.alimm.tanx.ui.image.glide.load.data.bitmap";
        }

        @Override // com.alimm.tanx.ui.image.glide.load.resource.bitmap.Downsampler
        public int getSampleSize(int i, int i2, int i3, int i4) {
            return java.lang.Math.min(i2 / i4, i / i3);
        }
    }

    /* renamed from: com.alimm.tanx.ui.image.glide.load.resource.bitmap.Downsampler$2, reason: invalid class name */
    public static class AnonymousClass2 extends com.alimm.tanx.ui.image.glide.load.resource.bitmap.Downsampler {
        @Override // com.alimm.tanx.ui.image.glide.load.resource.bitmap.Downsampler, com.alimm.tanx.ui.image.glide.load.resource.bitmap.BitmapDecoder
        public /* bridge */ /* synthetic */ android.graphics.Bitmap decode(java.io.InputStream inputStream, com.alimm.tanx.ui.image.glide.load.engine.bitmap_recycle.BitmapPool bitmapPool, int i, int i2, com.alimm.tanx.ui.image.glide.load.DecodeFormat decodeFormat) throws java.lang.Exception {
            return super.decode(inputStream, bitmapPool, i, i2, decodeFormat);
        }

        @Override // com.alimm.tanx.ui.image.glide.load.resource.bitmap.BitmapDecoder
        public java.lang.String getId() {
            return "AT_MOST.com.alimm.tanx.ui.image.glide.load.data.bitmap";
        }

        @Override // com.alimm.tanx.ui.image.glide.load.resource.bitmap.Downsampler
        public int getSampleSize(int i, int i2, int i3, int i4) {
            int ceil = (int) java.lang.Math.ceil(java.lang.Math.max(i2 / i4, i / i3));
            int max = java.lang.Math.max(1, java.lang.Integer.highestOneBit(ceil));
            return max << (max >= ceil ? 0 : 1);
        }
    }

    /* renamed from: com.alimm.tanx.ui.image.glide.load.resource.bitmap.Downsampler$3, reason: invalid class name */
    public static class AnonymousClass3 extends com.alimm.tanx.ui.image.glide.load.resource.bitmap.Downsampler {
        @Override // com.alimm.tanx.ui.image.glide.load.resource.bitmap.Downsampler, com.alimm.tanx.ui.image.glide.load.resource.bitmap.BitmapDecoder
        public /* bridge */ /* synthetic */ android.graphics.Bitmap decode(java.io.InputStream inputStream, com.alimm.tanx.ui.image.glide.load.engine.bitmap_recycle.BitmapPool bitmapPool, int i, int i2, com.alimm.tanx.ui.image.glide.load.DecodeFormat decodeFormat) throws java.lang.Exception {
            return super.decode(inputStream, bitmapPool, i, i2, decodeFormat);
        }

        @Override // com.alimm.tanx.ui.image.glide.load.resource.bitmap.BitmapDecoder
        public java.lang.String getId() {
            return "NONE.com.alimm.tanx.ui.image.glide.load.data.bitmap";
        }

        @Override // com.alimm.tanx.ui.image.glide.load.resource.bitmap.Downsampler
        public int getSampleSize(int i, int i2, int i3, int i4) {
            return 0;
        }
    }

    private static android.graphics.Bitmap decodeStream(com.alimm.tanx.ui.image.glide.util.MarkEnforcingInputStream markEnforcingInputStream, com.alimm.tanx.ui.image.glide.load.resource.bitmap.RecyclableBufferedInputStream recyclableBufferedInputStream, android.graphics.BitmapFactory.Options options) {
        if (options.inJustDecodeBounds) {
            markEnforcingInputStream.mark(MARK_POSITION);
        } else {
            recyclableBufferedInputStream.fixMarkLimit();
        }
        android.graphics.Bitmap decodeStream = android.graphics.BitmapFactory.decodeStream(markEnforcingInputStream, null, options);
        try {
            if (options.inJustDecodeBounds) {
                markEnforcingInputStream.reset();
            }
        } catch (java.io.IOException unused) {
            if (android.util.Log.isLoggable(TAG, 6)) {
                java.lang.StringBuilder tanxu_do2 = tanxu_do.tanxu_do.tanxu_do.tanxu_do.tanxu_do.tanxu_do("Exception loading inDecodeBounds=");
                tanxu_do2.append(options.inJustDecodeBounds);
                tanxu_do2.append(" sample=");
                tanxu_do2.append(options.inSampleSize);
            }
        }
        return decodeStream;
    }

    private android.graphics.Bitmap downsampleWithSize(com.alimm.tanx.ui.image.glide.util.MarkEnforcingInputStream markEnforcingInputStream, com.alimm.tanx.ui.image.glide.load.resource.bitmap.RecyclableBufferedInputStream recyclableBufferedInputStream, android.graphics.BitmapFactory.Options options, com.alimm.tanx.ui.image.glide.load.engine.bitmap_recycle.BitmapPool bitmapPool, int i, int i2, int i3, com.alimm.tanx.ui.image.glide.load.DecodeFormat decodeFormat) {
        android.graphics.Bitmap.Config config = getConfig(markEnforcingInputStream, decodeFormat);
        options.inSampleSize = i3;
        options.inPreferredConfig = config;
        if (shouldUsePool(markEnforcingInputStream)) {
            double d = i3;
            setInBitmap(options, bitmapPool.getDirty((int) java.lang.Math.ceil(i / d), (int) java.lang.Math.ceil(i2 / d), config));
        }
        return decodeStream(markEnforcingInputStream, recyclableBufferedInputStream, options);
    }

    private static android.graphics.Bitmap.Config getConfig(java.io.InputStream inputStream, com.alimm.tanx.ui.image.glide.load.DecodeFormat decodeFormat) {
        boolean z;
        if (decodeFormat == com.alimm.tanx.ui.image.glide.load.DecodeFormat.ALWAYS_ARGB_8888 || decodeFormat == com.alimm.tanx.ui.image.glide.load.DecodeFormat.PREFER_ARGB_8888) {
            return android.graphics.Bitmap.Config.ARGB_8888;
        }
        inputStream.mark(1024);
        try {
            try {
                z = new com.alimm.tanx.ui.image.glide.load.resource.bitmap.ImageHeaderParser(inputStream).hasAlpha();
            } catch (java.io.IOException unused) {
                if (android.util.Log.isLoggable(TAG, 5)) {
                    java.lang.StringBuilder sb = new java.lang.StringBuilder();
                    sb.append("Cannot determine whether the image has alpha or not from header for format ");
                    sb.append(decodeFormat);
                }
                try {
                    inputStream.reset();
                } catch (java.io.IOException unused2) {
                }
                z = false;
            }
            return z ? android.graphics.Bitmap.Config.ARGB_8888 : android.graphics.Bitmap.Config.RGB_565;
        } finally {
            try {
                inputStream.reset();
            } catch (java.io.IOException unused3) {
            }
        }
    }

    @android.annotation.TargetApi(11)
    private static synchronized android.graphics.BitmapFactory.Options getDefaultOptions() {
        android.graphics.BitmapFactory.Options poll;
        synchronized (com.alimm.tanx.ui.image.glide.load.resource.bitmap.Downsampler.class) {
            java.util.Queue<android.graphics.BitmapFactory.Options> queue = OPTIONS_QUEUE;
            synchronized (queue) {
                poll = queue.poll();
            }
            if (poll == null) {
                poll = new android.graphics.BitmapFactory.Options();
                resetOptions(poll);
            }
        }
        return poll;
    }

    private int getRoundedSampleSize(int i, int i2, int i3, int i4, int i5) {
        if (i5 == Integer.MIN_VALUE) {
            i5 = i3;
        }
        if (i4 == Integer.MIN_VALUE) {
            i4 = i2;
        }
        int sampleSize = (i == 90 || i == 270) ? getSampleSize(i3, i2, i4, i5) : getSampleSize(i2, i3, i4, i5);
        return java.lang.Math.max(1, sampleSize == 0 ? 0 : java.lang.Integer.highestOneBit(sampleSize));
    }

    private static void releaseOptions(android.graphics.BitmapFactory.Options options) {
        resetOptions(options);
        java.util.Queue<android.graphics.BitmapFactory.Options> queue = OPTIONS_QUEUE;
        synchronized (queue) {
            queue.offer(options);
        }
    }

    @android.annotation.TargetApi(11)
    private static void resetOptions(android.graphics.BitmapFactory.Options options) {
        options.inTempStorage = null;
        options.inDither = false;
        options.inScaled = false;
        options.inSampleSize = 1;
        options.inPreferredConfig = null;
        options.inJustDecodeBounds = false;
        options.outWidth = 0;
        options.outHeight = 0;
        options.outMimeType = null;
        options.inBitmap = null;
        options.inMutable = true;
    }

    @android.annotation.TargetApi(11)
    private static void setInBitmap(android.graphics.BitmapFactory.Options options, android.graphics.Bitmap bitmap) {
        options.inBitmap = bitmap;
    }

    private static boolean shouldUsePool(java.io.InputStream inputStream) {
        return true;
    }

    @Override // com.alimm.tanx.ui.image.glide.load.resource.bitmap.BitmapDecoder
    public android.graphics.Bitmap decode(java.io.InputStream inputStream, com.alimm.tanx.ui.image.glide.load.engine.bitmap_recycle.BitmapPool bitmapPool, int i, int i2, com.alimm.tanx.ui.image.glide.load.DecodeFormat decodeFormat) {
        int i3;
        android.graphics.Bitmap bitmap;
        com.alimm.tanx.ui.image.glide.util.ByteArrayPool byteArrayPool = com.alimm.tanx.ui.image.glide.util.ByteArrayPool.get();
        byte[] bytes = byteArrayPool.getBytes();
        byte[] bytes2 = byteArrayPool.getBytes();
        android.graphics.BitmapFactory.Options defaultOptions = getDefaultOptions();
        com.alimm.tanx.ui.image.glide.load.resource.bitmap.RecyclableBufferedInputStream recyclableBufferedInputStream = new com.alimm.tanx.ui.image.glide.load.resource.bitmap.RecyclableBufferedInputStream(inputStream, bytes2);
        com.alimm.tanx.ui.image.glide.util.ExceptionCatchingInputStream obtain = com.alimm.tanx.ui.image.glide.util.ExceptionCatchingInputStream.obtain(recyclableBufferedInputStream);
        com.alimm.tanx.ui.image.glide.util.MarkEnforcingInputStream markEnforcingInputStream = new com.alimm.tanx.ui.image.glide.util.MarkEnforcingInputStream(obtain);
        try {
            obtain.mark(MARK_POSITION);
            try {
                try {
                    int orientation = new com.alimm.tanx.ui.image.glide.load.resource.bitmap.ImageHeaderParser(obtain).getOrientation();
                    try {
                        obtain.reset();
                    } catch (java.io.IOException unused) {
                        android.util.Log.isLoggable(TAG, 5);
                    }
                    i3 = orientation;
                } catch (java.io.IOException unused2) {
                    android.util.Log.isLoggable(TAG, 5);
                    i3 = 0;
                }
                defaultOptions.inTempStorage = bytes;
                int[] dimensions = getDimensions(markEnforcingInputStream, recyclableBufferedInputStream, defaultOptions);
                int i4 = dimensions[0];
                int i5 = dimensions[1];
                android.graphics.Bitmap downsampleWithSize = downsampleWithSize(markEnforcingInputStream, recyclableBufferedInputStream, defaultOptions, bitmapPool, i4, i5, getRoundedSampleSize(com.alimm.tanx.ui.image.glide.load.resource.bitmap.TransformationUtils.getExifOrientationDegrees(i3), i4, i5, i, i2), decodeFormat);
                java.io.IOException exception = obtain.getException();
                if (exception != null) {
                    throw new java.lang.RuntimeException(exception);
                }
                if (downsampleWithSize != null) {
                    bitmap = com.alimm.tanx.ui.image.glide.load.resource.bitmap.TransformationUtils.rotateImageExif(downsampleWithSize, bitmapPool, i3);
                    if (!downsampleWithSize.equals(bitmap) && !bitmapPool.put(downsampleWithSize)) {
                        downsampleWithSize.recycle();
                    }
                } else {
                    bitmap = null;
                }
                return bitmap;
            } finally {
                try {
                    obtain.reset();
                } catch (java.io.IOException unused3) {
                    android.util.Log.isLoggable(TAG, 5);
                }
            }
        } finally {
            byteArrayPool.releaseBytes(bytes);
            byteArrayPool.releaseBytes(bytes2);
            obtain.release();
            releaseOptions(defaultOptions);
        }
    }

    public int[] getDimensions(com.alimm.tanx.ui.image.glide.util.MarkEnforcingInputStream markEnforcingInputStream, com.alimm.tanx.ui.image.glide.load.resource.bitmap.RecyclableBufferedInputStream recyclableBufferedInputStream, android.graphics.BitmapFactory.Options options) {
        options.inJustDecodeBounds = true;
        decodeStream(markEnforcingInputStream, recyclableBufferedInputStream, options);
        options.inJustDecodeBounds = false;
        return new int[]{options.outWidth, options.outHeight};
    }

    public abstract int getSampleSize(int i, int i2, int i3, int i4);
}
