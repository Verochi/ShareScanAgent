package com.ss.android.socialbase.downloader.logger;

/* loaded from: classes19.dex */
public class Logger {
    public static final boolean DEBUG = false;
    private static final java.lang.String DOWNLOAD_TAG_PREFIX = "Downloader-";
    private static final java.lang.String TAG = "DownloaderLogger";
    private static int mLevel = 4;
    private static com.ss.android.socialbase.downloader.logger.Logger.ILogWritter sLogWritter;

    public static abstract class ILogWritter {
        public void logD(java.lang.String str, java.lang.String str2) {
        }

        public void logE(java.lang.String str, java.lang.String str2) {
        }

        public void logE(java.lang.String str, java.lang.String str2, java.lang.Throwable th) {
        }

        public void logI(java.lang.String str, java.lang.String str2) {
        }

        public void logI(java.lang.String str, java.lang.String str2, java.lang.Throwable th) {
        }

        public void logK(java.lang.String str, java.lang.String str2) {
        }

        public void logV(java.lang.String str, java.lang.String str2) {
        }

        public void logW(java.lang.String str, java.lang.String str2) {
        }

        public void logW(java.lang.String str, java.lang.String str2, java.lang.Throwable th) {
        }
    }

    public static void alertErrorInfo(java.lang.String str) {
        if (debug()) {
            throw new java.lang.IllegalStateException(str);
        }
    }

    public static void d(java.lang.String str) {
        d(TAG, str);
    }

    public static void d(java.lang.String str, java.lang.String str2) {
        if (str2 == null) {
            return;
        }
        if (mLevel <= 3) {
            downloaderTag(str);
        }
        com.ss.android.socialbase.downloader.logger.Logger.ILogWritter iLogWritter = sLogWritter;
        if (iLogWritter != null) {
            iLogWritter.logD(downloaderTag(str), str2);
        }
    }

    public static void d(java.lang.String str, java.lang.String str2, java.lang.Throwable th) {
        if (str2 == null && th == null) {
            return;
        }
        if (mLevel <= 3) {
            downloaderTag(str);
        }
        com.ss.android.socialbase.downloader.logger.Logger.ILogWritter iLogWritter = sLogWritter;
        if (iLogWritter != null) {
            iLogWritter.logD(downloaderTag(str), str2 + th);
        }
    }

    public static boolean debug() {
        return mLevel <= 3;
    }

    public static java.lang.String downloaderTag(java.lang.String str) {
        return !android.text.TextUtils.isEmpty(str) ? DOWNLOAD_TAG_PREFIX.concat(java.lang.String.valueOf(str)) : TAG;
    }

    public static void e(java.lang.String str) {
        e(TAG, str);
    }

    public static void e(java.lang.String str, java.lang.String str2) {
        if (str2 == null) {
            return;
        }
        if (mLevel <= 6) {
            downloaderTag(str);
        }
        com.ss.android.socialbase.downloader.logger.Logger.ILogWritter iLogWritter = sLogWritter;
        if (iLogWritter != null) {
            iLogWritter.logE(downloaderTag(str), str2);
        }
    }

    public static void e(java.lang.String str, java.lang.String str2, java.lang.Throwable th) {
        if (str2 == null && th == null) {
            return;
        }
        if (mLevel <= 6) {
            downloaderTag(str);
        }
        com.ss.android.socialbase.downloader.logger.Logger.ILogWritter iLogWritter = sLogWritter;
        if (iLogWritter != null) {
            iLogWritter.logE(downloaderTag(str), str2, th);
        }
    }

    public static int getLogLevel() {
        return mLevel;
    }

    private static java.lang.String getSimpleClassName(java.lang.String str) {
        int lastIndexOf = str.lastIndexOf(46);
        return lastIndexOf < 0 ? str : str.substring(lastIndexOf + 1);
    }

    public static void i(java.lang.String str) {
        i(TAG, str);
    }

    public static void i(java.lang.String str, java.lang.String str2) {
        if (str2 == null) {
            return;
        }
        if (mLevel <= 4) {
            downloaderTag(str);
        }
        com.ss.android.socialbase.downloader.logger.Logger.ILogWritter iLogWritter = sLogWritter;
        if (iLogWritter != null) {
            iLogWritter.logI(downloaderTag(str), str2);
        }
    }

    public static void i(java.lang.String str, java.lang.String str2, java.lang.Throwable th) {
        if (str2 == null && th == null) {
            return;
        }
        if (mLevel <= 4) {
            downloaderTag(str);
        }
        com.ss.android.socialbase.downloader.logger.Logger.ILogWritter iLogWritter = sLogWritter;
        if (iLogWritter != null) {
            iLogWritter.logI(downloaderTag(str), str2, th);
        }
    }

    public static void k(java.lang.String str) {
        k(TAG, str);
    }

    public static void k(java.lang.String str, java.lang.String str2) {
        if (mLevel <= 3) {
            downloaderTag(str);
        }
        com.ss.android.socialbase.downloader.logger.Logger.ILogWritter iLogWritter = sLogWritter;
        if (iLogWritter != null) {
            iLogWritter.logK(downloaderTag(str), str2);
        }
    }

    public static void registerLogHandler(com.ss.android.socialbase.downloader.logger.Logger.ILogWritter iLogWritter) {
        sLogWritter = iLogWritter;
    }

    public static void setLogLevel(int i) {
        mLevel = i;
    }

    public static void setLogLevelInDownloaderProcess(int i) {
        if (com.ss.android.socialbase.downloader.impls.DownloadProxy.get(true) != null) {
            mLevel = i;
        }
    }

    public static void st(java.lang.String str, int i) {
        try {
            throw new java.lang.Exception();
        } catch (java.lang.Exception e) {
            java.lang.StackTraceElement[] stackTrace = e.getStackTrace();
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            for (int i2 = 1; i2 < java.lang.Math.min(i, stackTrace.length); i2++) {
                if (i2 > 1) {
                    sb.append("\n");
                }
                sb.append(getSimpleClassName(stackTrace[i2].getClassName()));
                sb.append(".");
                sb.append(stackTrace[i2].getMethodName());
            }
            v(downloaderTag(str), sb.toString());
        }
    }

    public static void throwException(java.lang.Throwable th) {
        if (th == null) {
            return;
        }
        th.printStackTrace();
        if (debug()) {
            throw new java.lang.RuntimeException("Error! Now in debug, we alert to you to correct it !", th);
        }
    }

    public static void v(java.lang.String str) {
        v(TAG, str);
    }

    public static void v(java.lang.String str, java.lang.String str2) {
        com.ss.android.socialbase.downloader.logger.Logger.ILogWritter iLogWritter;
        if (str2 == null || (iLogWritter = sLogWritter) == null) {
            return;
        }
        iLogWritter.logV(downloaderTag(str), str2);
    }

    public static void v(java.lang.String str, java.lang.String str2, java.lang.Throwable th) {
        com.ss.android.socialbase.downloader.logger.Logger.ILogWritter iLogWritter;
        if ((str2 == null && th == null) || (iLogWritter = sLogWritter) == null) {
            return;
        }
        iLogWritter.logV(downloaderTag(str), str2 + th);
    }

    public static void w(java.lang.String str) {
        w(TAG, str);
    }

    public static void w(java.lang.String str, java.lang.String str2) {
        if (str2 == null) {
            return;
        }
        if (mLevel <= 5) {
            downloaderTag(str);
        }
        com.ss.android.socialbase.downloader.logger.Logger.ILogWritter iLogWritter = sLogWritter;
        if (iLogWritter != null) {
            iLogWritter.logW(downloaderTag(str), str2);
        }
    }

    public static void w(java.lang.String str, java.lang.String str2, java.lang.Throwable th) {
        if (str2 == null && th == null) {
            return;
        }
        if (mLevel <= 5) {
            downloaderTag(str);
        }
        com.ss.android.socialbase.downloader.logger.Logger.ILogWritter iLogWritter = sLogWritter;
        if (iLogWritter != null) {
            iLogWritter.logW(downloaderTag(str), str2, th);
        }
    }
}
