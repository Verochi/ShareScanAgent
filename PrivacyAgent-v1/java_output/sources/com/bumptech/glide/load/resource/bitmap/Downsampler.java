package com.bumptech.glide.load.resource.bitmap;

/* loaded from: classes.dex */
public final class Downsampler {
    public static final com.bumptech.glide.load.Option<java.lang.Boolean> ALLOW_HARDWARE_CONFIG;
    private static final com.bumptech.glide.load.resource.bitmap.Downsampler.DecodeCallbacks EMPTY_CALLBACKS;
    public static final com.bumptech.glide.load.Option<java.lang.Boolean> FIX_BITMAP_SIZE_TO_REQUESTED_DIMENSIONS;
    private static final java.lang.String ICO_MIME_TYPE = "image/x-ico";
    private static final java.util.Set<java.lang.String> NO_DOWNSAMPLE_PRE_N_MIME_TYPES;
    private static final java.util.Queue<android.graphics.BitmapFactory.Options> OPTIONS_QUEUE;
    static final java.lang.String TAG = "Downsampler";
    private static final java.util.Set<com.bumptech.glide.load.ImageHeaderParser.ImageType> TYPES_THAT_USE_POOL_PRE_KITKAT;
    private static final java.lang.String WBMP_MIME_TYPE = "image/vnd.wap.wbmp";
    private final com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool bitmapPool;
    private final com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool byteArrayPool;
    private final android.util.DisplayMetrics displayMetrics;
    private final com.bumptech.glide.load.resource.bitmap.HardwareConfigState hardwareConfigState = com.bumptech.glide.load.resource.bitmap.HardwareConfigState.getInstance();
    private final java.util.List<com.bumptech.glide.load.ImageHeaderParser> parsers;
    public static final com.bumptech.glide.load.Option<com.bumptech.glide.load.DecodeFormat> DECODE_FORMAT = com.bumptech.glide.load.Option.memory("com.bumptech.glide.load.resource.bitmap.Downsampler.DecodeFormat", com.bumptech.glide.load.DecodeFormat.DEFAULT);
    public static final com.bumptech.glide.load.Option<com.bumptech.glide.load.PreferredColorSpace> PREFERRED_COLOR_SPACE = com.bumptech.glide.load.Option.memory("com.bumptech.glide.load.resource.bitmap.Downsampler.PreferredColorSpace", com.bumptech.glide.load.PreferredColorSpace.SRGB);

    @java.lang.Deprecated
    public static final com.bumptech.glide.load.Option<com.bumptech.glide.load.resource.bitmap.DownsampleStrategy> DOWNSAMPLE_STRATEGY = com.bumptech.glide.load.resource.bitmap.DownsampleStrategy.OPTION;

    /* renamed from: com.bumptech.glide.load.resource.bitmap.Downsampler$1, reason: invalid class name */
    public class AnonymousClass1 implements com.bumptech.glide.load.resource.bitmap.Downsampler.DecodeCallbacks {
        @Override // com.bumptech.glide.load.resource.bitmap.Downsampler.DecodeCallbacks
        public void onDecodeComplete(com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool bitmapPool, android.graphics.Bitmap bitmap) {
        }

        @Override // com.bumptech.glide.load.resource.bitmap.Downsampler.DecodeCallbacks
        public void onObtainBounds() {
        }
    }

    public interface DecodeCallbacks {
        void onDecodeComplete(com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool bitmapPool, android.graphics.Bitmap bitmap) throws java.io.IOException;

        void onObtainBounds();
    }

    static {
        java.lang.Boolean bool = java.lang.Boolean.FALSE;
        FIX_BITMAP_SIZE_TO_REQUESTED_DIMENSIONS = com.bumptech.glide.load.Option.memory("com.bumptech.glide.load.resource.bitmap.Downsampler.FixBitmapSize", bool);
        ALLOW_HARDWARE_CONFIG = com.bumptech.glide.load.Option.memory("com.bumptech.glide.load.resource.bitmap.Downsampler.AllowHardwareDecode", bool);
        NO_DOWNSAMPLE_PRE_N_MIME_TYPES = java.util.Collections.unmodifiableSet(new java.util.HashSet(java.util.Arrays.asList(WBMP_MIME_TYPE, ICO_MIME_TYPE)));
        EMPTY_CALLBACKS = new com.bumptech.glide.load.resource.bitmap.Downsampler.AnonymousClass1();
        TYPES_THAT_USE_POOL_PRE_KITKAT = java.util.Collections.unmodifiableSet(java.util.EnumSet.of(com.bumptech.glide.load.ImageHeaderParser.ImageType.JPEG, com.bumptech.glide.load.ImageHeaderParser.ImageType.PNG_A, com.bumptech.glide.load.ImageHeaderParser.ImageType.PNG));
        OPTIONS_QUEUE = com.bumptech.glide.util.Util.createQueue(0);
    }

    public Downsampler(java.util.List<com.bumptech.glide.load.ImageHeaderParser> list, android.util.DisplayMetrics displayMetrics, com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool bitmapPool, com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool arrayPool) {
        this.parsers = list;
        this.displayMetrics = (android.util.DisplayMetrics) com.bumptech.glide.util.Preconditions.checkNotNull(displayMetrics);
        this.bitmapPool = (com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool) com.bumptech.glide.util.Preconditions.checkNotNull(bitmapPool);
        this.byteArrayPool = (com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool) com.bumptech.glide.util.Preconditions.checkNotNull(arrayPool);
    }

    private static int adjustTargetDensityForError(double d) {
        return round((d / (r1 / r0)) * round(getDensityMultiplier(d) * d));
    }

    private void calculateConfig(com.bumptech.glide.load.resource.bitmap.ImageReader imageReader, com.bumptech.glide.load.DecodeFormat decodeFormat, boolean z, boolean z2, android.graphics.BitmapFactory.Options options, int i, int i2) {
        boolean z3;
        if (this.hardwareConfigState.setHardwareConfigIfAllowed(i, i2, options, z, z2)) {
            return;
        }
        if (decodeFormat == com.bumptech.glide.load.DecodeFormat.PREFER_ARGB_8888) {
            options.inPreferredConfig = android.graphics.Bitmap.Config.ARGB_8888;
            return;
        }
        try {
            z3 = imageReader.getImageType().hasAlpha();
        } catch (java.io.IOException unused) {
            if (android.util.Log.isLoggable(TAG, 3)) {
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                sb.append("Cannot determine whether the image has alpha or not from header, format ");
                sb.append(decodeFormat);
            }
            z3 = false;
        }
        android.graphics.Bitmap.Config config = z3 ? android.graphics.Bitmap.Config.ARGB_8888 : android.graphics.Bitmap.Config.RGB_565;
        options.inPreferredConfig = config;
        if (config == android.graphics.Bitmap.Config.RGB_565) {
            options.inDither = true;
        }
    }

    private static void calculateScaling(com.bumptech.glide.load.ImageHeaderParser.ImageType imageType, com.bumptech.glide.load.resource.bitmap.ImageReader imageReader, com.bumptech.glide.load.resource.bitmap.Downsampler.DecodeCallbacks decodeCallbacks, com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool bitmapPool, com.bumptech.glide.load.resource.bitmap.DownsampleStrategy downsampleStrategy, int i, int i2, int i3, int i4, int i5, android.graphics.BitmapFactory.Options options) throws java.io.IOException {
        int i6;
        int i7;
        int i8;
        int floor;
        double floor2;
        int i9;
        if (i2 <= 0 || i3 <= 0) {
            if (android.util.Log.isLoggable(TAG, 3)) {
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                sb.append("Unable to determine dimensions for: ");
                sb.append(imageType);
                sb.append(" with target [");
                sb.append(i4);
                sb.append("x");
                sb.append(i5);
                sb.append("]");
                return;
            }
            return;
        }
        if (isRotationRequired(i)) {
            i7 = i2;
            i6 = i3;
        } else {
            i6 = i2;
            i7 = i3;
        }
        float scaleFactor = downsampleStrategy.getScaleFactor(i6, i7, i4, i5);
        if (scaleFactor <= 0.0f) {
            throw new java.lang.IllegalArgumentException("Cannot scale with factor: " + scaleFactor + " from: " + downsampleStrategy + ", source: [" + i2 + "x" + i3 + "], target: [" + i4 + "x" + i5 + "]");
        }
        com.bumptech.glide.load.resource.bitmap.DownsampleStrategy.SampleSizeRounding sampleSizeRounding = downsampleStrategy.getSampleSizeRounding(i6, i7, i4, i5);
        if (sampleSizeRounding == null) {
            throw new java.lang.IllegalArgumentException("Cannot round with null rounding");
        }
        float f = i6;
        float f2 = i7;
        int round = i6 / round(scaleFactor * f);
        int round2 = i7 / round(scaleFactor * f2);
        com.bumptech.glide.load.resource.bitmap.DownsampleStrategy.SampleSizeRounding sampleSizeRounding2 = com.bumptech.glide.load.resource.bitmap.DownsampleStrategy.SampleSizeRounding.MEMORY;
        int max = sampleSizeRounding == sampleSizeRounding2 ? java.lang.Math.max(round, round2) : java.lang.Math.min(round, round2);
        int i10 = android.os.Build.VERSION.SDK_INT;
        if (i10 > 23 || !NO_DOWNSAMPLE_PRE_N_MIME_TYPES.contains(options.outMimeType)) {
            int max2 = java.lang.Math.max(1, java.lang.Integer.highestOneBit(max));
            if (sampleSizeRounding == sampleSizeRounding2 && max2 < 1.0f / scaleFactor) {
                max2 <<= 1;
            }
            i8 = max2;
        } else {
            i8 = 1;
        }
        options.inSampleSize = i8;
        if (imageType == com.bumptech.glide.load.ImageHeaderParser.ImageType.JPEG) {
            float min = java.lang.Math.min(i8, 8);
            floor = (int) java.lang.Math.ceil(f / min);
            i9 = (int) java.lang.Math.ceil(f2 / min);
            int i11 = i8 / 8;
            if (i11 > 0) {
                floor /= i11;
                i9 /= i11;
            }
        } else {
            if (imageType == com.bumptech.glide.load.ImageHeaderParser.ImageType.PNG || imageType == com.bumptech.glide.load.ImageHeaderParser.ImageType.PNG_A) {
                float f3 = i8;
                floor = (int) java.lang.Math.floor(f / f3);
                floor2 = java.lang.Math.floor(f2 / f3);
            } else if (imageType == com.bumptech.glide.load.ImageHeaderParser.ImageType.WEBP || imageType == com.bumptech.glide.load.ImageHeaderParser.ImageType.WEBP_A) {
                if (i10 >= 24) {
                    float f4 = i8;
                    floor = java.lang.Math.round(f / f4);
                    i9 = java.lang.Math.round(f2 / f4);
                } else {
                    float f5 = i8;
                    floor = (int) java.lang.Math.floor(f / f5);
                    floor2 = java.lang.Math.floor(f2 / f5);
                }
            } else if (i6 % i8 == 0 && i7 % i8 == 0) {
                floor = i6 / i8;
                i9 = i7 / i8;
            } else {
                int[] dimensions = getDimensions(imageReader, options, decodeCallbacks, bitmapPool);
                floor = dimensions[0];
                i9 = dimensions[1];
            }
            i9 = (int) floor2;
        }
        double scaleFactor2 = downsampleStrategy.getScaleFactor(floor, i9, i4, i5);
        options.inTargetDensity = adjustTargetDensityForError(scaleFactor2);
        options.inDensity = getDensityMultiplier(scaleFactor2);
        if (isScaling(options)) {
            options.inScaled = true;
        } else {
            options.inTargetDensity = 0;
            options.inDensity = 0;
        }
        if (android.util.Log.isLoggable(TAG, 2)) {
            java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
            sb2.append("Calculate scaling, source: [");
            sb2.append(i2);
            sb2.append("x");
            sb2.append(i3);
            sb2.append("], degreesToRotate: ");
            sb2.append(i);
            sb2.append(", target: [");
            sb2.append(i4);
            sb2.append("x");
            sb2.append(i5);
            sb2.append("], power of two scaled: [");
            sb2.append(floor);
            sb2.append("x");
            sb2.append(i9);
            sb2.append("], exact scale factor: ");
            sb2.append(scaleFactor);
            sb2.append(", power of 2 sample size: ");
            sb2.append(i8);
            sb2.append(", adjusted scale factor: ");
            sb2.append(scaleFactor2);
            sb2.append(", target density: ");
            sb2.append(options.inTargetDensity);
            sb2.append(", density: ");
            sb2.append(options.inDensity);
        }
    }

    private com.bumptech.glide.load.engine.Resource<android.graphics.Bitmap> decode(com.bumptech.glide.load.resource.bitmap.ImageReader imageReader, int i, int i2, com.bumptech.glide.load.Options options, com.bumptech.glide.load.resource.bitmap.Downsampler.DecodeCallbacks decodeCallbacks) throws java.io.IOException {
        byte[] bArr = (byte[]) this.byteArrayPool.get(65536, byte[].class);
        android.graphics.BitmapFactory.Options defaultOptions = getDefaultOptions();
        defaultOptions.inTempStorage = bArr;
        com.bumptech.glide.load.DecodeFormat decodeFormat = (com.bumptech.glide.load.DecodeFormat) options.get(DECODE_FORMAT);
        com.bumptech.glide.load.PreferredColorSpace preferredColorSpace = (com.bumptech.glide.load.PreferredColorSpace) options.get(PREFERRED_COLOR_SPACE);
        com.bumptech.glide.load.resource.bitmap.DownsampleStrategy downsampleStrategy = (com.bumptech.glide.load.resource.bitmap.DownsampleStrategy) options.get(com.bumptech.glide.load.resource.bitmap.DownsampleStrategy.OPTION);
        boolean booleanValue = ((java.lang.Boolean) options.get(FIX_BITMAP_SIZE_TO_REQUESTED_DIMENSIONS)).booleanValue();
        com.bumptech.glide.load.Option<java.lang.Boolean> option = ALLOW_HARDWARE_CONFIG;
        try {
            return com.bumptech.glide.load.resource.bitmap.BitmapResource.obtain(decodeFromWrappedStreams(imageReader, defaultOptions, downsampleStrategy, decodeFormat, preferredColorSpace, options.get(option) != null && ((java.lang.Boolean) options.get(option)).booleanValue(), i, i2, booleanValue, decodeCallbacks), this.bitmapPool);
        } finally {
            releaseOptions(defaultOptions);
            this.byteArrayPool.put(bArr);
        }
    }

    private android.graphics.Bitmap decodeFromWrappedStreams(com.bumptech.glide.load.resource.bitmap.ImageReader imageReader, android.graphics.BitmapFactory.Options options, com.bumptech.glide.load.resource.bitmap.DownsampleStrategy downsampleStrategy, com.bumptech.glide.load.DecodeFormat decodeFormat, com.bumptech.glide.load.PreferredColorSpace preferredColorSpace, boolean z, int i, int i2, boolean z2, com.bumptech.glide.load.resource.bitmap.Downsampler.DecodeCallbacks decodeCallbacks) throws java.io.IOException {
        int i3;
        int i4;
        java.lang.String str;
        android.graphics.ColorSpace.Named named;
        android.graphics.ColorSpace colorSpace;
        int i5;
        android.graphics.ColorSpace colorSpace2;
        android.graphics.ColorSpace colorSpace3;
        android.graphics.ColorSpace colorSpace4;
        boolean isWideGamut;
        int round;
        int round2;
        long logTime = com.bumptech.glide.util.LogTime.getLogTime();
        int[] dimensions = getDimensions(imageReader, options, decodeCallbacks, this.bitmapPool);
        boolean z3 = false;
        int i6 = dimensions[0];
        int i7 = dimensions[1];
        java.lang.String str2 = options.outMimeType;
        boolean z4 = (i6 == -1 || i7 == -1) ? false : z;
        int imageOrientation = imageReader.getImageOrientation();
        int exifOrientationDegrees = com.bumptech.glide.load.resource.bitmap.TransformationUtils.getExifOrientationDegrees(imageOrientation);
        boolean isExifOrientationRequired = com.bumptech.glide.load.resource.bitmap.TransformationUtils.isExifOrientationRequired(imageOrientation);
        if (i == Integer.MIN_VALUE) {
            i3 = i2;
            i4 = isRotationRequired(exifOrientationDegrees) ? i7 : i6;
        } else {
            i3 = i2;
            i4 = i;
        }
        int i8 = i3 == Integer.MIN_VALUE ? isRotationRequired(exifOrientationDegrees) ? i6 : i7 : i3;
        com.bumptech.glide.load.ImageHeaderParser.ImageType imageType = imageReader.getImageType();
        calculateScaling(imageType, imageReader, decodeCallbacks, this.bitmapPool, downsampleStrategy, exifOrientationDegrees, i6, i7, i4, i8, options);
        calculateConfig(imageReader, decodeFormat, z4, isExifOrientationRequired, options, i4, i8);
        int i9 = android.os.Build.VERSION.SDK_INT;
        int i10 = options.inSampleSize;
        if (shouldUsePool(imageType)) {
            if (i6 < 0 || i7 < 0 || !z2) {
                float f = isScaling(options) ? options.inTargetDensity / options.inDensity : 1.0f;
                int i11 = options.inSampleSize;
                float f2 = i11;
                int ceil = (int) java.lang.Math.ceil(i6 / f2);
                int ceil2 = (int) java.lang.Math.ceil(i7 / f2);
                round = java.lang.Math.round(ceil * f);
                round2 = java.lang.Math.round(ceil2 * f);
                str = TAG;
                if (android.util.Log.isLoggable(str, 2)) {
                    java.lang.StringBuilder sb = new java.lang.StringBuilder();
                    sb.append("Calculated target [");
                    sb.append(round);
                    sb.append("x");
                    sb.append(round2);
                    sb.append("] for source [");
                    sb.append(i6);
                    sb.append("x");
                    sb.append(i7);
                    sb.append("], sampleSize: ");
                    sb.append(i11);
                    sb.append(", targetDensity: ");
                    sb.append(options.inTargetDensity);
                    sb.append(", density: ");
                    sb.append(options.inDensity);
                    sb.append(", density multiplier: ");
                    sb.append(f);
                }
            } else {
                str = TAG;
                round = i4;
                round2 = i8;
            }
            if (round > 0 && round2 > 0) {
                setInBitmap(options, this.bitmapPool, round, round2);
            }
        } else {
            str = TAG;
        }
        if (i9 >= 28) {
            if (preferredColorSpace == com.bumptech.glide.load.PreferredColorSpace.DISPLAY_P3) {
                colorSpace3 = options.outColorSpace;
                if (colorSpace3 != null) {
                    colorSpace4 = options.outColorSpace;
                    isWideGamut = colorSpace4.isWideGamut();
                    if (isWideGamut) {
                        z3 = true;
                    }
                }
            }
            colorSpace2 = android.graphics.ColorSpace.get(z3 ? android.graphics.ColorSpace.Named.DISPLAY_P3 : android.graphics.ColorSpace.Named.SRGB);
            options.inPreferredColorSpace = colorSpace2;
        } else if (i9 >= 26) {
            named = android.graphics.ColorSpace.Named.SRGB;
            colorSpace = android.graphics.ColorSpace.get(named);
            options.inPreferredColorSpace = colorSpace;
        }
        android.graphics.Bitmap decodeStream = decodeStream(imageReader, options, decodeCallbacks, this.bitmapPool);
        decodeCallbacks.onDecodeComplete(this.bitmapPool, decodeStream);
        if (android.util.Log.isLoggable(str, 2)) {
            i5 = imageOrientation;
            logDecode(i6, i7, str2, options, decodeStream, i, i2, logTime);
        } else {
            i5 = imageOrientation;
        }
        if (decodeStream == null) {
            return null;
        }
        decodeStream.setDensity(this.displayMetrics.densityDpi);
        android.graphics.Bitmap rotateImageExif = com.bumptech.glide.load.resource.bitmap.TransformationUtils.rotateImageExif(this.bitmapPool, decodeStream, i5);
        if (decodeStream.equals(rotateImageExif)) {
            return rotateImageExif;
        }
        this.bitmapPool.put(decodeStream);
        return rotateImageExif;
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:?, code lost:
    
        throw r0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static android.graphics.Bitmap decodeStream(com.bumptech.glide.load.resource.bitmap.ImageReader imageReader, android.graphics.BitmapFactory.Options options, com.bumptech.glide.load.resource.bitmap.Downsampler.DecodeCallbacks decodeCallbacks, com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool bitmapPool) throws java.io.IOException {
        if (!options.inJustDecodeBounds) {
            decodeCallbacks.onObtainBounds();
            imageReader.stopGrowingBuffers();
        }
        int i = options.outWidth;
        int i2 = options.outHeight;
        java.lang.String str = options.outMimeType;
        com.bumptech.glide.load.resource.bitmap.TransformationUtils.getBitmapDrawableLock().lock();
        try {
            try {
                android.graphics.Bitmap decodeBitmap = imageReader.decodeBitmap(options);
                com.bumptech.glide.load.resource.bitmap.TransformationUtils.getBitmapDrawableLock().unlock();
                return decodeBitmap;
            } catch (java.lang.IllegalArgumentException e) {
                java.io.IOException newIoExceptionForInBitmapAssertion = newIoExceptionForInBitmapAssertion(e, i, i2, str, options);
                android.util.Log.isLoggable(TAG, 3);
                android.graphics.Bitmap bitmap = options.inBitmap;
                if (bitmap == null) {
                    throw newIoExceptionForInBitmapAssertion;
                }
                try {
                    bitmapPool.put(bitmap);
                    options.inBitmap = null;
                    android.graphics.Bitmap decodeStream = decodeStream(imageReader, options, decodeCallbacks, bitmapPool);
                    com.bumptech.glide.load.resource.bitmap.TransformationUtils.getBitmapDrawableLock().unlock();
                    return decodeStream;
                } catch (java.io.IOException unused) {
                    throw newIoExceptionForInBitmapAssertion;
                }
            }
        } catch (java.lang.Throwable th) {
            com.bumptech.glide.load.resource.bitmap.TransformationUtils.getBitmapDrawableLock().unlock();
            throw th;
        }
    }

    @androidx.annotation.Nullable
    @android.annotation.TargetApi(19)
    private static java.lang.String getBitmapString(android.graphics.Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        return "[" + bitmap.getWidth() + "x" + bitmap.getHeight() + "] " + bitmap.getConfig() + (" (" + bitmap.getAllocationByteCount() + ")");
    }

    private static synchronized android.graphics.BitmapFactory.Options getDefaultOptions() {
        android.graphics.BitmapFactory.Options poll;
        synchronized (com.bumptech.glide.load.resource.bitmap.Downsampler.class) {
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

    private static int getDensityMultiplier(double d) {
        if (d > 1.0d) {
            d = 1.0d / d;
        }
        return (int) java.lang.Math.round(d * 2.147483647E9d);
    }

    private static int[] getDimensions(com.bumptech.glide.load.resource.bitmap.ImageReader imageReader, android.graphics.BitmapFactory.Options options, com.bumptech.glide.load.resource.bitmap.Downsampler.DecodeCallbacks decodeCallbacks, com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool bitmapPool) throws java.io.IOException {
        options.inJustDecodeBounds = true;
        decodeStream(imageReader, options, decodeCallbacks, bitmapPool);
        options.inJustDecodeBounds = false;
        return new int[]{options.outWidth, options.outHeight};
    }

    private static java.lang.String getInBitmapString(android.graphics.BitmapFactory.Options options) {
        return getBitmapString(options.inBitmap);
    }

    private static boolean isRotationRequired(int i) {
        return i == 90 || i == 270;
    }

    private static boolean isScaling(android.graphics.BitmapFactory.Options options) {
        int i;
        int i2 = options.inTargetDensity;
        return i2 > 0 && (i = options.inDensity) > 0 && i2 != i;
    }

    private static void logDecode(int i, int i2, java.lang.String str, android.graphics.BitmapFactory.Options options, android.graphics.Bitmap bitmap, int i3, int i4, long j) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("Decoded ");
        sb.append(getBitmapString(bitmap));
        sb.append(" from [");
        sb.append(i);
        sb.append("x");
        sb.append(i2);
        sb.append("] ");
        sb.append(str);
        sb.append(" with inBitmap ");
        sb.append(getInBitmapString(options));
        sb.append(" for [");
        sb.append(i3);
        sb.append("x");
        sb.append(i4);
        sb.append("], sample size: ");
        sb.append(options.inSampleSize);
        sb.append(", density: ");
        sb.append(options.inDensity);
        sb.append(", target density: ");
        sb.append(options.inTargetDensity);
        sb.append(", thread: ");
        sb.append(java.lang.Thread.currentThread().getName());
        sb.append(", duration: ");
        sb.append(com.bumptech.glide.util.LogTime.getElapsedMillis(j));
    }

    private static java.io.IOException newIoExceptionForInBitmapAssertion(java.lang.IllegalArgumentException illegalArgumentException, int i, int i2, java.lang.String str, android.graphics.BitmapFactory.Options options) {
        return new java.io.IOException("Exception decoding bitmap, outWidth: " + i + ", outHeight: " + i2 + ", outMimeType: " + str + ", inBitmap: " + getInBitmapString(options), illegalArgumentException);
    }

    private static void releaseOptions(android.graphics.BitmapFactory.Options options) {
        resetOptions(options);
        java.util.Queue<android.graphics.BitmapFactory.Options> queue = OPTIONS_QUEUE;
        synchronized (queue) {
            queue.offer(options);
        }
    }

    private static void resetOptions(android.graphics.BitmapFactory.Options options) {
        options.inTempStorage = null;
        options.inDither = false;
        options.inScaled = false;
        options.inSampleSize = 1;
        options.inPreferredConfig = null;
        options.inJustDecodeBounds = false;
        options.inDensity = 0;
        options.inTargetDensity = 0;
        if (android.os.Build.VERSION.SDK_INT >= 26) {
            options.inPreferredColorSpace = null;
            options.outColorSpace = null;
            options.outConfig = null;
        }
        options.outWidth = 0;
        options.outHeight = 0;
        options.outMimeType = null;
        options.inBitmap = null;
        options.inMutable = true;
    }

    private static int round(double d) {
        return (int) (d + 0.5d);
    }

    @android.annotation.TargetApi(26)
    private static void setInBitmap(android.graphics.BitmapFactory.Options options, com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool bitmapPool, int i, int i2) {
        android.graphics.Bitmap.Config config;
        android.graphics.Bitmap.Config config2;
        if (android.os.Build.VERSION.SDK_INT >= 26) {
            android.graphics.Bitmap.Config config3 = options.inPreferredConfig;
            config2 = android.graphics.Bitmap.Config.HARDWARE;
            if (config3 == config2) {
                return;
            } else {
                config = options.outConfig;
            }
        } else {
            config = null;
        }
        if (config == null) {
            config = options.inPreferredConfig;
        }
        options.inBitmap = bitmapPool.getDirty(i, i2, config);
    }

    private boolean shouldUsePool(com.bumptech.glide.load.ImageHeaderParser.ImageType imageType) {
        return true;
    }

    @androidx.annotation.RequiresApi(21)
    public com.bumptech.glide.load.engine.Resource<android.graphics.Bitmap> decode(android.os.ParcelFileDescriptor parcelFileDescriptor, int i, int i2, com.bumptech.glide.load.Options options) throws java.io.IOException {
        return decode(new com.bumptech.glide.load.resource.bitmap.ImageReader.ParcelFileDescriptorImageReader(parcelFileDescriptor, this.parsers, this.byteArrayPool), i, i2, options, EMPTY_CALLBACKS);
    }

    public com.bumptech.glide.load.engine.Resource<android.graphics.Bitmap> decode(java.io.InputStream inputStream, int i, int i2, com.bumptech.glide.load.Options options) throws java.io.IOException {
        return decode(inputStream, i, i2, options, EMPTY_CALLBACKS);
    }

    public com.bumptech.glide.load.engine.Resource<android.graphics.Bitmap> decode(java.io.InputStream inputStream, int i, int i2, com.bumptech.glide.load.Options options, com.bumptech.glide.load.resource.bitmap.Downsampler.DecodeCallbacks decodeCallbacks) throws java.io.IOException {
        return decode(new com.bumptech.glide.load.resource.bitmap.ImageReader.InputStreamImageReader(inputStream, this.parsers, this.byteArrayPool), i, i2, options, decodeCallbacks);
    }

    public boolean handles(android.os.ParcelFileDescriptor parcelFileDescriptor) {
        return com.bumptech.glide.load.data.ParcelFileDescriptorRewinder.isSupported();
    }

    public boolean handles(java.io.InputStream inputStream) {
        return true;
    }

    public boolean handles(java.nio.ByteBuffer byteBuffer) {
        return true;
    }
}
