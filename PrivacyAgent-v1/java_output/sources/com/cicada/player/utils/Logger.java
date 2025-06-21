package com.cicada.player.utils;

/* loaded from: classes31.dex */
public class Logger {
    private static java.lang.String TAG = "Logger";
    private static android.content.Context sAppContext;
    private static volatile com.cicada.player.utils.Logger sInstance;
    private final java.lang.Object logCallbackLock = new java.lang.Object();
    private com.cicada.player.utils.Logger.OnLogCallback mLogCallback = null;
    private boolean mEnableConsoleLog = true;
    private com.cicada.player.utils.Logger.LogLevel mCurrentLogLevel = com.cicada.player.utils.Logger.LogLevel.AF_LOG_LEVEL_INFO;

    /* renamed from: com.cicada.player.utils.Logger$1, reason: invalid class name */
    /* loaded from: classes22.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$cicada$player$utils$Logger$LogOption;

        static {
            int[] iArr = new int[com.cicada.player.utils.Logger.LogOption.values().length];
            $SwitchMap$com$cicada$player$utils$Logger$LogOption = iArr;
            try {
                iArr[com.cicada.player.utils.Logger.LogOption.FRAME_LEVEL_LOGGING_ENABLED.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
            }
        }
    }

    /* loaded from: classes22.dex */
    public enum LogLevel {
        AF_LOG_LEVEL_NONE(0),
        AF_LOG_LEVEL_FATAL(8),
        AF_LOG_LEVEL_ERROR(16),
        AF_LOG_LEVEL_WARNING(24),
        AF_LOG_LEVEL_INFO(32),
        AF_LOG_LEVEL_DEBUG(48),
        AF_LOG_LEVEL_TRACE(56);

        private int mValue;

        LogLevel(int i) {
            this.mValue = i;
        }

        public static com.cicada.player.utils.Logger.LogLevel convert(int i) {
            com.cicada.player.utils.Logger.LogLevel logLevel = AF_LOG_LEVEL_NONE;
            for (com.cicada.player.utils.Logger.LogLevel logLevel2 : values()) {
                if (logLevel2.getValue() == i) {
                    return logLevel2;
                }
            }
            return logLevel;
        }

        public int getValue() {
            return this.mValue;
        }
    }

    /* loaded from: classes22.dex */
    public enum LogOption {
        FRAME_LEVEL_LOGGING_ENABLED(1);

        private final int key;

        LogOption(int i) {
            this.key = i;
        }

        public int getKey() {
            return this.key;
        }
    }

    /* loaded from: classes22.dex */
    public interface OnLogCallback {
        void onLog(com.cicada.player.utils.Logger.LogLevel logLevel, java.lang.String str);
    }

    static {
        com.aliyun.utils.f.f();
        sInstance = null;
        sAppContext = null;
    }

    private Logger() {
    }

    private void callback(com.cicada.player.utils.Logger.LogLevel logLevel, java.lang.String str) {
        synchronized (this.logCallbackLock) {
            com.cicada.player.utils.Logger.OnLogCallback onLogCallback = this.mLogCallback;
            if (onLogCallback != null) {
                onLogCallback.onLog(logLevel, str);
            }
        }
    }

    public static void d(java.lang.String str, java.lang.String str2) {
        log(com.cicada.player.utils.Logger.LogLevel.AF_LOG_LEVEL_DEBUG, str, str2);
    }

    public static void e(java.lang.String str, java.lang.String str2) {
        log(com.cicada.player.utils.Logger.LogLevel.AF_LOG_LEVEL_ERROR, str, str2);
    }

    public static com.cicada.player.utils.Logger getInstance(android.content.Context context) {
        if (sInstance == null) {
            synchronized (com.cicada.player.utils.Logger.class) {
                if (sInstance == null) {
                    sInstance = new com.cicada.player.utils.Logger();
                    sInstance.setLogLevel(com.cicada.player.utils.Logger.LogLevel.AF_LOG_LEVEL_INFO);
                    if (context != null) {
                        sAppContext = context.getApplicationContext();
                    }
                }
            }
        }
        return sInstance;
    }

    private static com.cicada.player.utils.Logger.LogLevel getLevel(int i) {
        if (i == 0) {
            return com.cicada.player.utils.Logger.LogLevel.AF_LOG_LEVEL_NONE;
        }
        if (i == 8) {
            return com.cicada.player.utils.Logger.LogLevel.AF_LOG_LEVEL_FATAL;
        }
        if (i == 16) {
            return com.cicada.player.utils.Logger.LogLevel.AF_LOG_LEVEL_ERROR;
        }
        if (i == 24) {
            return com.cicada.player.utils.Logger.LogLevel.AF_LOG_LEVEL_WARNING;
        }
        if (i == 32) {
            return com.cicada.player.utils.Logger.LogLevel.AF_LOG_LEVEL_INFO;
        }
        if (i != 48 && i == 56) {
            return com.cicada.player.utils.Logger.LogLevel.AF_LOG_LEVEL_TRACE;
        }
        return com.cicada.player.utils.Logger.LogLevel.AF_LOG_LEVEL_DEBUG;
    }

    public static void i(java.lang.String str, java.lang.String str2) {
        log(com.cicada.player.utils.Logger.LogLevel.AF_LOG_LEVEL_INFO, str, str2);
    }

    public static void loadClass() {
    }

    private static void log(com.cicada.player.utils.Logger.LogLevel logLevel, java.lang.String str, java.lang.String str2) {
        com.cicada.player.utils.Logger.LogLevel logLevel2 = getInstance(sAppContext).mCurrentLogLevel;
        boolean z = getInstance(sAppContext).mEnableConsoleLog;
        if (logLevel2 == com.cicada.player.utils.Logger.LogLevel.AF_LOG_LEVEL_NONE || logLevel2.getValue() < logLevel.getValue() || !z) {
            return;
        }
        nLogPrint(logLevel.getValue(), str, str2);
    }

    private static native void nEnableConsoleLog(boolean z);

    private static native int nGetLogLevel();

    private static native void nLogPrint(int i, java.lang.String str, java.lang.String str2);

    private static void nOnLogCallback(int i, byte[] bArr) {
        com.cicada.player.utils.Logger.LogLevel level = getLevel(i);
        java.lang.String trim = new java.lang.String(bArr).trim();
        android.content.Context context = sAppContext;
        if (context != null) {
            getInstance(context).callback(level, trim);
        }
    }

    private static native void nSetLogLevel(int i);

    private static native void nSetLogOption(java.lang.String str, int i);

    public static void v(java.lang.String str, java.lang.String str2) {
        log(com.cicada.player.utils.Logger.LogLevel.AF_LOG_LEVEL_TRACE, str, str2);
    }

    public static void w(java.lang.String str, java.lang.String str2) {
        log(com.cicada.player.utils.Logger.LogLevel.AF_LOG_LEVEL_WARNING, str, str2);
    }

    public void enableConsoleLog(boolean z) {
        if (com.aliyun.utils.f.b()) {
            this.mEnableConsoleLog = z;
            nEnableConsoleLog(z);
        }
    }

    public com.cicada.player.utils.Logger.OnLogCallback getLogCallback() {
        com.cicada.player.utils.Logger.OnLogCallback onLogCallback;
        synchronized (this.logCallbackLock) {
            onLogCallback = this.mLogCallback;
        }
        return onLogCallback;
    }

    public com.cicada.player.utils.Logger.LogLevel getLogLevel() {
        return !com.aliyun.utils.f.b() ? com.cicada.player.utils.Logger.LogLevel.AF_LOG_LEVEL_INFO : com.cicada.player.utils.Logger.LogLevel.convert(nGetLogLevel());
    }

    public void setLogCallback(com.cicada.player.utils.Logger.OnLogCallback onLogCallback) {
        synchronized (this.logCallbackLock) {
            this.mLogCallback = onLogCallback;
        }
    }

    public void setLogLevel(com.cicada.player.utils.Logger.LogLevel logLevel) {
        if (com.aliyun.utils.f.b()) {
            this.mCurrentLogLevel = logLevel;
            nSetLogLevel(logLevel.getValue());
        }
    }

    public void setLogOption(com.cicada.player.utils.Logger.LogOption logOption, int i) {
        if (com.aliyun.utils.f.b() && com.cicada.player.utils.Logger.AnonymousClass1.$SwitchMap$com$cicada$player$utils$Logger$LogOption[logOption.ordinal()] == 1) {
            nSetLogOption("frame_level_logging_enabled", i);
        }
    }
}
