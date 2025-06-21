package com.alimm.tanx.ui.image.glide.load.engine.cache;

/* loaded from: classes.dex */
public class MemorySizeCalculator {
    static final int BITMAP_POOL_TARGET_SCREENS = 4;
    static final int BYTES_PER_ARGB_8888_PIXEL = 4;
    static final float LOW_MEMORY_MAX_SIZE_MULTIPLIER = 0.33f;
    static final float MAX_SIZE_MULTIPLIER = 0.4f;
    static final int MEMORY_CACHE_TARGET_SCREENS = 2;
    private static final java.lang.String TAG = "MemorySizeCalculator";
    private final int bitmapPoolSize;
    private final android.content.Context context;
    private final int memoryCacheSize;

    public static class DisplayMetricsScreenDimensions implements com.alimm.tanx.ui.image.glide.load.engine.cache.MemorySizeCalculator.ScreenDimensions {
        private final android.util.DisplayMetrics displayMetrics;

        public DisplayMetricsScreenDimensions(android.util.DisplayMetrics displayMetrics) {
            this.displayMetrics = displayMetrics;
        }

        @Override // com.alimm.tanx.ui.image.glide.load.engine.cache.MemorySizeCalculator.ScreenDimensions
        public int getHeightPixels() {
            return this.displayMetrics.heightPixels;
        }

        @Override // com.alimm.tanx.ui.image.glide.load.engine.cache.MemorySizeCalculator.ScreenDimensions
        public int getWidthPixels() {
            return this.displayMetrics.widthPixels;
        }
    }

    public interface ScreenDimensions {
        int getHeightPixels();

        int getWidthPixels();
    }

    public MemorySizeCalculator(android.content.Context context) {
        this(context, (android.app.ActivityManager) context.getSystemService("activity"), new com.alimm.tanx.ui.image.glide.load.engine.cache.MemorySizeCalculator.DisplayMetricsScreenDimensions(context.getResources().getDisplayMetrics()));
    }

    public MemorySizeCalculator(android.content.Context context, android.app.ActivityManager activityManager, com.alimm.tanx.ui.image.glide.load.engine.cache.MemorySizeCalculator.ScreenDimensions screenDimensions) {
        this.context = context;
        int maxSize = getMaxSize(activityManager);
        int widthPixels = screenDimensions.getWidthPixels() * screenDimensions.getHeightPixels() * 4;
        int i = widthPixels * 4;
        int i2 = widthPixels * 2;
        int i3 = i2 + i;
        if (i3 <= maxSize) {
            this.memoryCacheSize = i2;
            this.bitmapPoolSize = i;
        } else {
            int round = java.lang.Math.round(maxSize / 6.0f);
            this.memoryCacheSize = round * 2;
            this.bitmapPoolSize = round * 4;
        }
        if (android.util.Log.isLoggable(TAG, 3)) {
            java.lang.StringBuilder tanxu_do2 = tanxu_do.tanxu_do.tanxu_do.tanxu_do.tanxu_do.tanxu_do("Calculated memory cache size: ");
            tanxu_do2.append(toMb(this.memoryCacheSize));
            tanxu_do2.append(" pool size: ");
            tanxu_do2.append(toMb(this.bitmapPoolSize));
            tanxu_do2.append(" memory class limited? ");
            tanxu_do2.append(i3 > maxSize);
            tanxu_do2.append(" max size: ");
            tanxu_do2.append(toMb(maxSize));
            tanxu_do2.append(" memoryClass: ");
            tanxu_do2.append(activityManager.getMemoryClass());
            tanxu_do2.append(" isLowMemoryDevice: ");
            tanxu_do2.append(isLowMemoryDevice(activityManager));
        }
    }

    private static int getMaxSize(android.app.ActivityManager activityManager) {
        return java.lang.Math.round(activityManager.getMemoryClass() * 1024 * 1024 * (isLowMemoryDevice(activityManager) ? LOW_MEMORY_MAX_SIZE_MULTIPLIER : MAX_SIZE_MULTIPLIER));
    }

    @android.annotation.TargetApi(19)
    private static boolean isLowMemoryDevice(android.app.ActivityManager activityManager) {
        return activityManager.isLowRamDevice();
    }

    private java.lang.String toMb(int i) {
        return android.text.format.Formatter.formatFileSize(this.context, i);
    }

    public int getBitmapPoolSize() {
        return this.bitmapPoolSize;
    }

    public int getMemoryCacheSize() {
        return this.memoryCacheSize;
    }
}
