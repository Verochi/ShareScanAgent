package org.greenrobot.eventbus;

/* loaded from: classes26.dex */
public interface Logger {

    public static class Default {
        public static java.lang.Object a() {
            try {
                return android.os.Looper.getMainLooper();
            } catch (java.lang.RuntimeException unused) {
                return null;
            }
        }

        public static org.greenrobot.eventbus.Logger get() {
            return (!org.greenrobot.eventbus.android.AndroidLogger.isAndroidLogAvailable() || a() == null) ? new org.greenrobot.eventbus.Logger.SystemOutLogger() : new org.greenrobot.eventbus.android.AndroidLogger("EventBus");
        }
    }

    public static class JavaLogger implements org.greenrobot.eventbus.Logger {
        protected final java.util.logging.Logger logger;

        public JavaLogger(java.lang.String str) {
            this.logger = java.util.logging.Logger.getLogger(str);
        }

        @Override // org.greenrobot.eventbus.Logger
        public void log(java.util.logging.Level level, java.lang.String str) {
            this.logger.log(level, str);
        }

        @Override // org.greenrobot.eventbus.Logger
        public void log(java.util.logging.Level level, java.lang.String str, java.lang.Throwable th) {
            this.logger.log(level, str, th);
        }
    }

    public static class SystemOutLogger implements org.greenrobot.eventbus.Logger {
        @Override // org.greenrobot.eventbus.Logger
        public void log(java.util.logging.Level level, java.lang.String str) {
            java.lang.System.out.println("[" + level + "] " + str);
        }

        @Override // org.greenrobot.eventbus.Logger
        public void log(java.util.logging.Level level, java.lang.String str, java.lang.Throwable th) {
            java.lang.System.out.println("[" + level + "] " + str);
            th.printStackTrace(java.lang.System.out);
        }
    }

    void log(java.util.logging.Level level, java.lang.String str);

    void log(java.util.logging.Level level, java.lang.String str, java.lang.Throwable th);
}
