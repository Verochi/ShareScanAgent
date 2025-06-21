package com.bumptech.glide.load.resource.bitmap;

/* loaded from: classes.dex */
public final class HardwareConfigState {
    private static final java.io.File FD_SIZE_LIST = new java.io.File("/proc/self/fd");
    private static final int MAXIMUM_FDS_FOR_HARDWARE_CONFIGS_O = 700;
    private static final int MAXIMUM_FDS_FOR_HARDWARE_CONFIGS_P = 20000;
    private static final int MINIMUM_DECODES_BETWEEN_FD_CHECKS = 50;

    @androidx.annotation.VisibleForTesting
    static final int MIN_HARDWARE_DIMENSION_O = 128;
    private static final int MIN_HARDWARE_DIMENSION_P = 0;
    private static volatile com.bumptech.glide.load.resource.bitmap.HardwareConfigState instance;

    @androidx.annotation.GuardedBy("this")
    private int decodesSinceLastFdCheck;
    private final int fdCountLimit;

    @androidx.annotation.GuardedBy("this")
    private boolean isFdSizeBelowHardwareLimit = true;
    private final boolean isHardwareConfigAllowedByDeviceModel = isHardwareConfigAllowedByDeviceModel();
    private final int minHardwareDimension;

    @androidx.annotation.VisibleForTesting
    public HardwareConfigState() {
        if (android.os.Build.VERSION.SDK_INT >= 28) {
            this.fdCountLimit = 20000;
            this.minHardwareDimension = 0;
        } else {
            this.fdCountLimit = 700;
            this.minHardwareDimension = 128;
        }
    }

    public static com.bumptech.glide.load.resource.bitmap.HardwareConfigState getInstance() {
        if (instance == null) {
            synchronized (com.bumptech.glide.load.resource.bitmap.HardwareConfigState.class) {
                if (instance == null) {
                    instance = new com.bumptech.glide.load.resource.bitmap.HardwareConfigState();
                }
            }
        }
        return instance;
    }

    private synchronized boolean isFdSizeBelowHardwareLimit() {
        boolean z = true;
        int i = this.decodesSinceLastFdCheck + 1;
        this.decodesSinceLastFdCheck = i;
        if (i >= 50) {
            this.decodesSinceLastFdCheck = 0;
            int length = FD_SIZE_LIST.list().length;
            if (length >= this.fdCountLimit) {
                z = false;
            }
            this.isFdSizeBelowHardwareLimit = z;
            if (!z && android.util.Log.isLoggable("Downsampler", 5)) {
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                sb.append("Excluding HARDWARE bitmap config because we're over the file descriptor limit, file descriptors ");
                sb.append(length);
                sb.append(", limit ");
                sb.append(this.fdCountLimit);
            }
        }
        return this.isFdSizeBelowHardwareLimit;
    }

    private static boolean isHardwareConfigAllowedByDeviceModel() {
        java.lang.String str = android.os.Build.MODEL;
        if (str == null || str.length() < 7) {
            return true;
        }
        java.lang.String substring = str.substring(0, 7);
        substring.hashCode();
        switch (substring) {
            case "SM-A520":
            case "SM-G930":
            case "SM-G935":
            case "SM-G960":
            case "SM-G965":
            case "SM-J720":
            case "SM-N935":
                if (android.os.Build.VERSION.SDK_INT != 26) {
                }
                break;
        }
        return true;
    }

    public boolean isHardwareConfigAllowed(int i, int i2, boolean z, boolean z2) {
        int i3;
        return z && this.isHardwareConfigAllowedByDeviceModel && android.os.Build.VERSION.SDK_INT >= 26 && !z2 && i >= (i3 = this.minHardwareDimension) && i2 >= i3 && isFdSizeBelowHardwareLimit();
    }

    @android.annotation.TargetApi(26)
    public boolean setHardwareConfigIfAllowed(int i, int i2, android.graphics.BitmapFactory.Options options, boolean z, boolean z2) {
        android.graphics.Bitmap.Config config;
        boolean isHardwareConfigAllowed = isHardwareConfigAllowed(i, i2, z, z2);
        if (isHardwareConfigAllowed) {
            config = android.graphics.Bitmap.Config.HARDWARE;
            options.inPreferredConfig = config;
            options.inMutable = false;
        }
        return isHardwareConfigAllowed;
    }
}
