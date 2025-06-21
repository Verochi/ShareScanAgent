package androidx.core.view;

/* loaded from: classes.dex */
public final class DisplayCompat {
    private static final int DISPLAY_SIZE_4K_HEIGHT = 2160;
    private static final int DISPLAY_SIZE_4K_WIDTH = 3840;

    @androidx.annotation.RequiresApi(17)
    public static class Api17Impl {
        private Api17Impl() {
        }

        public static void getRealSize(android.view.Display display, android.graphics.Point point) {
            display.getRealSize(point);
        }
    }

    @androidx.annotation.RequiresApi(23)
    public static class Api23Impl {
        private Api23Impl() {
        }

        @androidx.annotation.NonNull
        public static androidx.core.view.DisplayCompat.ModeCompat getMode(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.NonNull android.view.Display display) {
            android.view.Display.Mode mode;
            mode = display.getMode();
            android.graphics.Point currentDisplaySizeFromWorkarounds = androidx.core.view.DisplayCompat.getCurrentDisplaySizeFromWorkarounds(context, display);
            return (currentDisplaySizeFromWorkarounds == null || physicalSizeEquals(mode, currentDisplaySizeFromWorkarounds)) ? new androidx.core.view.DisplayCompat.ModeCompat(mode, true) : new androidx.core.view.DisplayCompat.ModeCompat(mode, currentDisplaySizeFromWorkarounds);
        }

        @androidx.annotation.NonNull
        @android.annotation.SuppressLint({"ArrayReturn"})
        public static androidx.core.view.DisplayCompat.ModeCompat[] getSupportedModes(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.NonNull android.view.Display display) {
            android.view.Display.Mode[] supportedModes;
            android.view.Display.Mode mode;
            supportedModes = display.getSupportedModes();
            androidx.core.view.DisplayCompat.ModeCompat[] modeCompatArr = new androidx.core.view.DisplayCompat.ModeCompat[supportedModes.length];
            mode = display.getMode();
            android.graphics.Point currentDisplaySizeFromWorkarounds = androidx.core.view.DisplayCompat.getCurrentDisplaySizeFromWorkarounds(context, display);
            if (currentDisplaySizeFromWorkarounds == null || physicalSizeEquals(mode, currentDisplaySizeFromWorkarounds)) {
                for (int i = 0; i < supportedModes.length; i++) {
                    modeCompatArr[i] = new androidx.core.view.DisplayCompat.ModeCompat(supportedModes[i], physicalSizeEquals(supportedModes[i], mode));
                }
            } else {
                for (int i2 = 0; i2 < supportedModes.length; i2++) {
                    modeCompatArr[i2] = physicalSizeEquals(supportedModes[i2], mode) ? new androidx.core.view.DisplayCompat.ModeCompat(supportedModes[i2], currentDisplaySizeFromWorkarounds) : new androidx.core.view.DisplayCompat.ModeCompat(supportedModes[i2], false);
                }
            }
            return modeCompatArr;
        }

        public static boolean isCurrentModeTheLargestMode(@androidx.annotation.NonNull android.view.Display display) {
            android.view.Display.Mode mode;
            android.view.Display.Mode[] supportedModes;
            int physicalHeight;
            int physicalHeight2;
            int physicalWidth;
            int physicalWidth2;
            mode = display.getMode();
            supportedModes = display.getSupportedModes();
            for (int i = 0; i < supportedModes.length; i++) {
                physicalHeight = mode.getPhysicalHeight();
                physicalHeight2 = supportedModes[i].getPhysicalHeight();
                if (physicalHeight >= physicalHeight2) {
                    physicalWidth = mode.getPhysicalWidth();
                    physicalWidth2 = supportedModes[i].getPhysicalWidth();
                    if (physicalWidth >= physicalWidth2) {
                    }
                }
                return false;
            }
            return true;
        }

        /* JADX WARN: Code restructure failed: missing block: B:4:0x000e, code lost:
        
            if (r0 != r3.y) goto L6;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public static boolean physicalSizeEquals(android.view.Display.Mode mode, android.graphics.Point point) {
            int physicalWidth;
            int physicalWidth2;
            int physicalHeight;
            int physicalHeight2;
            physicalWidth = mode.getPhysicalWidth();
            if (physicalWidth == point.x) {
                physicalHeight2 = mode.getPhysicalHeight();
            }
            physicalWidth2 = mode.getPhysicalWidth();
            if (physicalWidth2 == point.y) {
                physicalHeight = mode.getPhysicalHeight();
                if (physicalHeight == point.x) {
                    return true;
                }
            }
            return false;
        }

        public static boolean physicalSizeEquals(android.view.Display.Mode mode, android.view.Display.Mode mode2) {
            int physicalWidth;
            int physicalWidth2;
            int physicalHeight;
            int physicalHeight2;
            physicalWidth = mode.getPhysicalWidth();
            physicalWidth2 = mode2.getPhysicalWidth();
            if (physicalWidth == physicalWidth2) {
                physicalHeight = mode.getPhysicalHeight();
                physicalHeight2 = mode2.getPhysicalHeight();
                if (physicalHeight == physicalHeight2) {
                    return true;
                }
            }
            return false;
        }
    }

    public static final class ModeCompat {
        private final boolean mIsNative;
        private final android.view.Display.Mode mMode;
        private final android.graphics.Point mPhysicalSize;

        public ModeCompat(@androidx.annotation.NonNull android.graphics.Point point) {
            androidx.core.util.Preconditions.checkNotNull(point, "physicalSize == null");
            this.mPhysicalSize = point;
            this.mMode = null;
            this.mIsNative = true;
        }

        @androidx.annotation.RequiresApi(23)
        public ModeCompat(@androidx.annotation.NonNull android.view.Display.Mode mode, @androidx.annotation.NonNull android.graphics.Point point) {
            androidx.core.util.Preconditions.checkNotNull(mode, "mode == null, can't wrap a null reference");
            androidx.core.util.Preconditions.checkNotNull(point, "physicalSize == null");
            this.mPhysicalSize = point;
            this.mMode = mode;
            this.mIsNative = true;
        }

        @androidx.annotation.RequiresApi(23)
        public ModeCompat(@androidx.annotation.NonNull android.view.Display.Mode mode, boolean z) {
            int physicalWidth;
            int physicalHeight;
            androidx.core.util.Preconditions.checkNotNull(mode, "mode == null, can't wrap a null reference");
            physicalWidth = mode.getPhysicalWidth();
            physicalHeight = mode.getPhysicalHeight();
            this.mPhysicalSize = new android.graphics.Point(physicalWidth, physicalHeight);
            this.mMode = mode;
            this.mIsNative = z;
        }

        public int getPhysicalHeight() {
            return this.mPhysicalSize.y;
        }

        public int getPhysicalWidth() {
            return this.mPhysicalSize.x;
        }

        public boolean isNative() {
            return this.mIsNative;
        }

        @androidx.annotation.Nullable
        @androidx.annotation.RequiresApi(23)
        public android.view.Display.Mode toMode() {
            return this.mMode;
        }
    }

    private DisplayCompat() {
    }

    public static android.graphics.Point getCurrentDisplaySizeFromWorkarounds(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.NonNull android.view.Display display) {
        android.graphics.Point parsePhysicalDisplaySizeFromSystemProperties = android.os.Build.VERSION.SDK_INT < 28 ? parsePhysicalDisplaySizeFromSystemProperties("sys.display-size", display) : parsePhysicalDisplaySizeFromSystemProperties("vendor.display-size", display);
        if (parsePhysicalDisplaySizeFromSystemProperties != null) {
            return parsePhysicalDisplaySizeFromSystemProperties;
        }
        if (isSonyBravia4kTv(context) && isCurrentModeTheLargestMode(display)) {
            return new android.graphics.Point(DISPLAY_SIZE_4K_WIDTH, DISPLAY_SIZE_4K_HEIGHT);
        }
        return null;
    }

    @androidx.annotation.NonNull
    private static android.graphics.Point getDisplaySize(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.NonNull android.view.Display display) {
        android.graphics.Point currentDisplaySizeFromWorkarounds = getCurrentDisplaySizeFromWorkarounds(context, display);
        if (currentDisplaySizeFromWorkarounds != null) {
            return currentDisplaySizeFromWorkarounds;
        }
        android.graphics.Point point = new android.graphics.Point();
        androidx.core.view.DisplayCompat.Api17Impl.getRealSize(display, point);
        return point;
    }

    @androidx.annotation.NonNull
    @androidx.annotation.VisibleForTesting
    public static androidx.core.view.DisplayCompat.ModeCompat getMode(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.NonNull android.view.Display display) {
        return android.os.Build.VERSION.SDK_INT >= 23 ? androidx.core.view.DisplayCompat.Api23Impl.getMode(context, display) : new androidx.core.view.DisplayCompat.ModeCompat(getDisplaySize(context, display));
    }

    @androidx.annotation.NonNull
    @android.annotation.SuppressLint({"ArrayReturn"})
    public static androidx.core.view.DisplayCompat.ModeCompat[] getSupportedModes(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.NonNull android.view.Display display) {
        return android.os.Build.VERSION.SDK_INT >= 23 ? androidx.core.view.DisplayCompat.Api23Impl.getSupportedModes(context, display) : new androidx.core.view.DisplayCompat.ModeCompat[]{getMode(context, display)};
    }

    @androidx.annotation.Nullable
    private static java.lang.String getSystemProperty(java.lang.String str) {
        try {
            java.lang.Class<?> cls = java.lang.Class.forName("android.os.SystemProperties");
            return (java.lang.String) cls.getMethod(com.ss.android.socialbase.downloader.constants.MonitorConstants.CONNECT_TYPE_GET, java.lang.String.class).invoke(cls, str);
        } catch (java.lang.Exception unused) {
            return null;
        }
    }

    public static boolean isCurrentModeTheLargestMode(@androidx.annotation.NonNull android.view.Display display) {
        if (android.os.Build.VERSION.SDK_INT >= 23) {
            return androidx.core.view.DisplayCompat.Api23Impl.isCurrentModeTheLargestMode(display);
        }
        return true;
    }

    private static boolean isSonyBravia4kTv(@androidx.annotation.NonNull android.content.Context context) {
        return isTv(context) && "Sony".equals(android.os.Build.MANUFACTURER) && android.os.Build.MODEL.startsWith("BRAVIA") && context.getPackageManager().hasSystemFeature("com.sony.dtv.hardware.panel.qfhd");
    }

    private static boolean isTv(@androidx.annotation.NonNull android.content.Context context) {
        android.app.UiModeManager uiModeManager = (android.app.UiModeManager) context.getSystemService("uimode");
        return uiModeManager != null && uiModeManager.getCurrentModeType() == 4;
    }

    private static android.graphics.Point parseDisplaySize(@androidx.annotation.NonNull java.lang.String str) throws java.lang.NumberFormatException {
        java.lang.String[] split = str.trim().split("x", -1);
        if (split.length == 2) {
            int parseInt = java.lang.Integer.parseInt(split[0]);
            int parseInt2 = java.lang.Integer.parseInt(split[1]);
            if (parseInt > 0 && parseInt2 > 0) {
                return new android.graphics.Point(parseInt, parseInt2);
            }
        }
        throw new java.lang.NumberFormatException();
    }

    @androidx.annotation.Nullable
    private static android.graphics.Point parsePhysicalDisplaySizeFromSystemProperties(@androidx.annotation.NonNull java.lang.String str, @androidx.annotation.NonNull android.view.Display display) {
        if (display.getDisplayId() != 0) {
            return null;
        }
        java.lang.String systemProperty = getSystemProperty(str);
        if (android.text.TextUtils.isEmpty(systemProperty)) {
            return null;
        }
        try {
            return parseDisplaySize(systemProperty);
        } catch (java.lang.NumberFormatException unused) {
            return null;
        }
    }
}
