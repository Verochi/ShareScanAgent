package org.webrtc.ali.svideo;

/* loaded from: classes26.dex */
public class Logging {
    private static volatile boolean loggingEnabled;
    private static volatile boolean tracingEnabled;
    private static final java.util.logging.Logger fallbackLogger = createFallbackLogger();
    private static volatile org.webrtc.ali.svideo.Logging.NativeLibStatus nativeLibStatus = org.webrtc.ali.svideo.Logging.NativeLibStatus.UNINITIALIZED;

    /* renamed from: org.webrtc.ali.svideo.Logging$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$webrtc$ali$svideo$Logging$Severity;

        static {
            int[] iArr = new int[org.webrtc.ali.svideo.Logging.Severity.values().length];
            $SwitchMap$org$webrtc$ali$svideo$Logging$Severity = iArr;
            try {
                iArr[org.webrtc.ali.svideo.Logging.Severity.LS_ERROR.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$webrtc$ali$svideo$Logging$Severity[org.webrtc.ali.svideo.Logging.Severity.LS_WARNING.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$webrtc$ali$svideo$Logging$Severity[org.webrtc.ali.svideo.Logging.Severity.LS_INFO.ordinal()] = 3;
            } catch (java.lang.NoSuchFieldError unused3) {
            }
        }
    }

    public enum NativeLibStatus {
        UNINITIALIZED,
        LOADED,
        FAILED
    }

    public enum Severity {
        LS_SENSITIVE,
        LS_VERBOSE,
        LS_INFO,
        LS_WARNING,
        LS_ERROR,
        LS_NONE
    }

    public enum TraceLevel {
        TRACE_NONE(0),
        TRACE_STATEINFO(1),
        TRACE_WARNING(2),
        TRACE_ERROR(4),
        TRACE_CRITICAL(8),
        TRACE_APICALL(16),
        TRACE_DEFAULT(255),
        TRACE_MODULECALL(32),
        TRACE_MEMORY(256),
        TRACE_TIMER(512),
        TRACE_STREAM(1024),
        TRACE_DEBUG(2048),
        TRACE_INFO(4096),
        TRACE_TERSEINFO(8192),
        TRACE_ALL(65535);

        public final int level;

        TraceLevel(int i) {
            this.level = i;
        }
    }

    private static java.util.logging.Logger createFallbackLogger() {
        java.util.logging.Logger logger = java.util.logging.Logger.getLogger("org.webrtc.Logging");
        logger.setLevel(java.util.logging.Level.ALL);
        return logger;
    }

    public static void d(java.lang.String str, java.lang.String str2) {
        log(org.webrtc.ali.svideo.Logging.Severity.LS_INFO, str, str2);
    }

    public static void e(java.lang.String str, java.lang.String str2) {
        log(org.webrtc.ali.svideo.Logging.Severity.LS_ERROR, str, str2);
    }

    public static void e(java.lang.String str, java.lang.String str2, java.lang.Throwable th) {
        org.webrtc.ali.svideo.Logging.Severity severity = org.webrtc.ali.svideo.Logging.Severity.LS_ERROR;
        log(severity, str, str2);
        log(severity, str, th.toString());
        log(severity, str, getStackTraceString(th));
    }

    public static void enableLogThreads() {
        if (loadNativeLibrary()) {
            nativeEnableLogThreads();
        } else {
            fallbackLogger.log(java.util.logging.Level.WARNING, "Cannot enable log thread because native lib not loaded.");
        }
    }

    public static void enableLogTimeStamps() {
        if (loadNativeLibrary()) {
            nativeEnableLogTimeStamps();
        } else {
            fallbackLogger.log(java.util.logging.Level.WARNING, "Cannot enable log timestamps because native lib not loaded.");
        }
    }

    public static synchronized void enableLogToDebugOutput(org.webrtc.ali.svideo.Logging.Severity severity) {
        synchronized (org.webrtc.ali.svideo.Logging.class) {
            if (!loadNativeLibrary()) {
                fallbackLogger.log(java.util.logging.Level.WARNING, "Cannot enable logging because native lib not loaded.");
            } else {
                nativeEnableLogToDebugOutput(severity.ordinal());
                loggingEnabled = true;
            }
        }
    }

    public static synchronized void enableTracing(java.lang.String str, java.util.EnumSet<org.webrtc.ali.svideo.Logging.TraceLevel> enumSet) {
        synchronized (org.webrtc.ali.svideo.Logging.class) {
            if (!loadNativeLibrary()) {
                fallbackLogger.log(java.util.logging.Level.WARNING, "Cannot enable tracing because native lib not loaded.");
                return;
            }
            if (tracingEnabled) {
                return;
            }
            java.util.Iterator<E> it = enumSet.iterator();
            int i = 0;
            while (it.hasNext()) {
                i |= ((org.webrtc.ali.svideo.Logging.TraceLevel) it.next()).level;
            }
            nativeEnableTracing(str, i);
            tracingEnabled = true;
        }
    }

    private static java.lang.String getStackTraceString(java.lang.Throwable th) {
        if (th == null) {
            return "";
        }
        java.io.StringWriter stringWriter = new java.io.StringWriter();
        th.printStackTrace(new java.io.PrintWriter(stringWriter));
        return stringWriter.toString();
    }

    private static boolean loadNativeLibrary() {
        if (nativeLibStatus == org.webrtc.ali.svideo.Logging.NativeLibStatus.UNINITIALIZED) {
            try {
                nativeLibStatus = org.webrtc.ali.svideo.Logging.NativeLibStatus.FAILED;
            } catch (java.lang.UnsatisfiedLinkError e) {
                nativeLibStatus = org.webrtc.ali.svideo.Logging.NativeLibStatus.FAILED;
                fallbackLogger.log(java.util.logging.Level.WARNING, "Failed to load jingle_peerconnection_so: ", (java.lang.Throwable) e);
            }
        }
        return nativeLibStatus == org.webrtc.ali.svideo.Logging.NativeLibStatus.LOADED;
    }

    public static void log(org.webrtc.ali.svideo.Logging.Severity severity, java.lang.String str, java.lang.String str2) {
        if (loggingEnabled) {
            nativeLog(severity.ordinal(), str, str2);
            return;
        }
        int i = org.webrtc.ali.svideo.Logging.AnonymousClass1.$SwitchMap$org$webrtc$ali$svideo$Logging$Severity[severity.ordinal()];
        java.util.logging.Level level = i != 1 ? i != 2 ? i != 3 ? java.util.logging.Level.FINE : java.util.logging.Level.INFO : java.util.logging.Level.WARNING : java.util.logging.Level.SEVERE;
        fallbackLogger.log(level, str + ": " + str2);
    }

    private static native void nativeEnableLogThreads();

    private static native void nativeEnableLogTimeStamps();

    private static native void nativeEnableLogToDebugOutput(int i);

    private static native void nativeEnableTracing(java.lang.String str, int i);

    private static native void nativeLog(int i, java.lang.String str, java.lang.String str2);

    public static void v(java.lang.String str, java.lang.String str2) {
        log(org.webrtc.ali.svideo.Logging.Severity.LS_VERBOSE, str, str2);
    }

    public static void w(java.lang.String str, java.lang.String str2) {
        log(org.webrtc.ali.svideo.Logging.Severity.LS_WARNING, str, str2);
    }

    public static void w(java.lang.String str, java.lang.String str2, java.lang.Throwable th) {
        org.webrtc.ali.svideo.Logging.Severity severity = org.webrtc.ali.svideo.Logging.Severity.LS_WARNING;
        log(severity, str, str2);
        log(severity, str, th.toString());
        log(severity, str, getStackTraceString(th));
    }
}
