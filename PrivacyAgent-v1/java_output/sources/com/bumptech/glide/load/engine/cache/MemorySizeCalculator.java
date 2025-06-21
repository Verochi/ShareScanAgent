package com.bumptech.glide.load.engine.cache;

/* loaded from: classes.dex */
public final class MemorySizeCalculator {

    @androidx.annotation.VisibleForTesting
    static final int BYTES_PER_ARGB_8888_PIXEL = 4;
    private static final int LOW_MEMORY_BYTE_ARRAY_POOL_DIVISOR = 2;
    private static final java.lang.String TAG = "MemorySizeCalculator";
    private final int arrayPoolSize;
    private final int bitmapPoolSize;
    private final android.content.Context context;
    private final int memoryCacheSize;

    public static final class Builder {
        static final int ARRAY_POOL_SIZE_BYTES = 4194304;
        static final int BITMAP_POOL_TARGET_SCREENS;
        static final float LOW_MEMORY_MAX_SIZE_MULTIPLIER = 0.33f;
        static final float MAX_SIZE_MULTIPLIER = 0.4f;

        @androidx.annotation.VisibleForTesting
        static final int MEMORY_CACHE_TARGET_SCREENS = 2;
        android.app.ActivityManager activityManager;
        float bitmapPoolScreens;
        final android.content.Context context;
        com.bumptech.glide.load.engine.cache.MemorySizeCalculator.ScreenDimensions screenDimensions;
        float memoryCacheScreens = 2.0f;
        float maxSizeMultiplier = MAX_SIZE_MULTIPLIER;
        float lowMemoryMaxSizeMultiplier = LOW_MEMORY_MAX_SIZE_MULTIPLIER;
        int arrayPoolSizeBytes = 4194304;

        static {
            BITMAP_POOL_TARGET_SCREENS = android.os.Build.VERSION.SDK_INT < 26 ? 4 : 1;
        }

        public Builder(android.content.Context context) {
            this.bitmapPoolScreens = BITMAP_POOL_TARGET_SCREENS;
            this.context = context;
            this.activityManager = (android.app.ActivityManager) context.getSystemService("activity");
            this.screenDimensions = new com.bumptech.glide.load.engine.cache.MemorySizeCalculator.DisplayMetricsScreenDimensions(context.getResources().getDisplayMetrics());
            if (android.os.Build.VERSION.SDK_INT < 26 || !com.bumptech.glide.load.engine.cache.MemorySizeCalculator.isLowMemoryDevice(this.activityManager)) {
                return;
            }
            this.bitmapPoolScreens = 0.0f;
        }

        public com.bumptech.glide.load.engine.cache.MemorySizeCalculator build() {
            return new com.bumptech.glide.load.engine.cache.MemorySizeCalculator(this);
        }

        @androidx.annotation.VisibleForTesting
        public com.bumptech.glide.load.engine.cache.MemorySizeCalculator.Builder setActivityManager(android.app.ActivityManager activityManager) {
            this.activityManager = activityManager;
            return this;
        }

        public com.bumptech.glide.load.engine.cache.MemorySizeCalculator.Builder setArrayPoolSize(int i) {
            this.arrayPoolSizeBytes = i;
            return this;
        }

        public com.bumptech.glide.load.engine.cache.MemorySizeCalculator.Builder setBitmapPoolScreens(float f) {
            com.bumptech.glide.util.Preconditions.checkArgument(f >= 0.0f, "Bitmap pool screens must be greater than or equal to 0");
            this.bitmapPoolScreens = f;
            return this;
        }

        public com.bumptech.glide.load.engine.cache.MemorySizeCalculator.Builder setLowMemoryMaxSizeMultiplier(float f) {
            com.bumptech.glide.util.Preconditions.checkArgument(f >= 0.0f && f <= 1.0f, "Low memory max size multiplier must be between 0 and 1");
            this.lowMemoryMaxSizeMultiplier = f;
            return this;
        }

        public com.bumptech.glide.load.engine.cache.MemorySizeCalculator.Builder setMaxSizeMultiplier(float f) {
            com.bumptech.glide.util.Preconditions.checkArgument(f >= 0.0f && f <= 1.0f, "Size multiplier must be between 0 and 1");
            this.maxSizeMultiplier = f;
            return this;
        }

        public com.bumptech.glide.load.engine.cache.MemorySizeCalculator.Builder setMemoryCacheScreens(float f) {
            com.bumptech.glide.util.Preconditions.checkArgument(f >= 0.0f, "Memory cache screens must be greater than or equal to 0");
            this.memoryCacheScreens = f;
            return this;
        }

        @androidx.annotation.VisibleForTesting
        public com.bumptech.glide.load.engine.cache.MemorySizeCalculator.Builder setScreenDimensions(com.bumptech.glide.load.engine.cache.MemorySizeCalculator.ScreenDimensions screenDimensions) {
            this.screenDimensions = screenDimensions;
            return this;
        }
    }

    public static final class DisplayMetricsScreenDimensions implements com.bumptech.glide.load.engine.cache.MemorySizeCalculator.ScreenDimensions {
        private final android.util.DisplayMetrics displayMetrics;

        public DisplayMetricsScreenDimensions(android.util.DisplayMetrics displayMetrics) {
            this.displayMetrics = displayMetrics;
        }

        @Override // com.bumptech.glide.load.engine.cache.MemorySizeCalculator.ScreenDimensions
        public int getHeightPixels() {
            return this.displayMetrics.heightPixels;
        }

        @Override // com.bumptech.glide.load.engine.cache.MemorySizeCalculator.ScreenDimensions
        public int getWidthPixels() {
            return this.displayMetrics.widthPixels;
        }
    }

    public interface ScreenDimensions {
        int getHeightPixels();

        int getWidthPixels();
    }

    public MemorySizeCalculator(com.bumptech.glide.load.engine.cache.MemorySizeCalculator.Builder builder) {
        this.context = builder.context;
        int i = isLowMemoryDevice(builder.activityManager) ? builder.arrayPoolSizeBytes / 2 : builder.arrayPoolSizeBytes;
        this.arrayPoolSize = i;
        int maxSize = getMaxSize(builder.activityManager, builder.maxSizeMultiplier, builder.lowMemoryMaxSizeMultiplier);
        float widthPixels = builder.screenDimensions.getWidthPixels() * builder.screenDimensions.getHeightPixels() * 4;
        int round = java.lang.Math.round(builder.bitmapPoolScreens * widthPixels);
        int round2 = java.lang.Math.round(widthPixels * builder.memoryCacheScreens);
        int i2 = maxSize - i;
        int i3 = round2 + round;
        if (i3 <= i2) {
            this.memoryCacheSize = round2;
            this.bitmapPoolSize = round;
        } else {
            float f = i2;
            float f2 = builder.bitmapPoolScreens;
            float f3 = builder.memoryCacheScreens;
            float f4 = f / (f2 + f3);
            this.memoryCacheSize = java.lang.Math.round(f3 * f4);
            this.bitmapPoolSize = java.lang.Math.round(f4 * builder.bitmapPoolScreens);
        }
        if (android.util.Log.isLoggable(TAG, 3)) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("Calculation complete, Calculated memory cache size: ");
            sb.append(toMb(this.memoryCacheSize));
            sb.append(", pool size: ");
            sb.append(toMb(this.bitmapPoolSize));
            sb.append(", byte array size: ");
            sb.append(toMb(i));
            sb.append(", memory class limited? ");
            sb.append(i3 > maxSize);
            sb.append(", max size: ");
            sb.append(toMb(maxSize));
            sb.append(", memoryClass: ");
            sb.append(builder.activityManager.getMemoryClass());
            sb.append(", isLowMemoryDevice: ");
            sb.append(isLowMemoryDevice(builder.activityManager));
        }
    }

    private static int getMaxSize(android.app.ActivityManager activityManager, float f, float f2) {
        float memoryClass = activityManager.getMemoryClass() * 1024 * 1024;
        if (isLowMemoryDevice(activityManager)) {
            f = f2;
        }
        return java.lang.Math.round(memoryClass * f);
    }

    @android.annotation.TargetApi(19)
    public static boolean isLowMemoryDevice(android.app.ActivityManager activityManager) {
        return activityManager.isLowRamDevice();
    }

    private java.lang.String toMb(int i) {
        return android.text.format.Formatter.formatFileSize(this.context, i);
    }

    public int getArrayPoolSizeInBytes() {
        return this.arrayPoolSize;
    }

    public int getBitmapPoolSize() {
        return this.bitmapPoolSize;
    }

    public int getMemoryCacheSize() {
        return this.memoryCacheSize;
    }
}
