package androidx.tracing;

/* loaded from: classes.dex */
public final class Trace {
    static final java.lang.String TAG = "Trace";
    private static java.lang.reflect.Method sAsyncTraceBeginMethod;
    private static java.lang.reflect.Method sAsyncTraceEndMethod;
    private static java.lang.reflect.Method sIsTagEnabledMethod;
    private static java.lang.reflect.Method sTraceCounterMethod;
    private static long sTraceTagApp;

    private Trace() {
    }

    @android.annotation.SuppressLint({"NewApi"})
    public static void beginAsyncSection(@androidx.annotation.NonNull java.lang.String str, int i) {
        try {
            if (sAsyncTraceBeginMethod == null) {
                androidx.tracing.TraceApi29Impl.beginAsyncSection(str, i);
                return;
            }
        } catch (java.lang.NoClassDefFoundError | java.lang.NoSuchMethodError unused) {
        }
        beginAsyncSectionFallback(str, i);
    }

    private static void beginAsyncSectionFallback(@androidx.annotation.NonNull java.lang.String str, int i) {
        try {
            if (sAsyncTraceBeginMethod == null) {
                sAsyncTraceBeginMethod = android.os.Trace.class.getMethod("asyncTraceBegin", java.lang.Long.TYPE, java.lang.String.class, java.lang.Integer.TYPE);
            }
            sAsyncTraceBeginMethod.invoke(null, java.lang.Long.valueOf(sTraceTagApp), str, java.lang.Integer.valueOf(i));
        } catch (java.lang.Exception e) {
            handleException("asyncTraceBegin", e);
        }
    }

    public static void beginSection(@androidx.annotation.NonNull java.lang.String str) {
        androidx.tracing.TraceApi18Impl.beginSection(str);
    }

    @android.annotation.SuppressLint({"NewApi"})
    public static void endAsyncSection(@androidx.annotation.NonNull java.lang.String str, int i) {
        try {
            if (sAsyncTraceEndMethod == null) {
                androidx.tracing.TraceApi29Impl.endAsyncSection(str, i);
                return;
            }
        } catch (java.lang.NoClassDefFoundError | java.lang.NoSuchMethodError unused) {
        }
        endAsyncSectionFallback(str, i);
    }

    private static void endAsyncSectionFallback(@androidx.annotation.NonNull java.lang.String str, int i) {
        try {
            if (sAsyncTraceEndMethod == null) {
                sAsyncTraceEndMethod = android.os.Trace.class.getMethod("asyncTraceEnd", java.lang.Long.TYPE, java.lang.String.class, java.lang.Integer.TYPE);
            }
            sAsyncTraceEndMethod.invoke(null, java.lang.Long.valueOf(sTraceTagApp), str, java.lang.Integer.valueOf(i));
        } catch (java.lang.Exception e) {
            handleException("asyncTraceEnd", e);
        }
    }

    public static void endSection() {
        androidx.tracing.TraceApi18Impl.endSection();
    }

    private static void handleException(@androidx.annotation.NonNull java.lang.String str, @androidx.annotation.NonNull java.lang.Exception exc) {
        if (exc instanceof java.lang.reflect.InvocationTargetException) {
            java.lang.Throwable cause = exc.getCause();
            if (!(cause instanceof java.lang.RuntimeException)) {
                throw new java.lang.RuntimeException(cause);
            }
            throw ((java.lang.RuntimeException) cause);
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("Unable to call ");
        sb.append(str);
        sb.append(" via reflection");
    }

    @android.annotation.SuppressLint({"NewApi"})
    public static boolean isEnabled() {
        boolean isEnabled;
        try {
            if (sIsTagEnabledMethod == null) {
                isEnabled = android.os.Trace.isEnabled();
                return isEnabled;
            }
        } catch (java.lang.NoClassDefFoundError | java.lang.NoSuchMethodError unused) {
        }
        return isEnabledFallback();
    }

    private static boolean isEnabledFallback() {
        try {
            if (sIsTagEnabledMethod == null) {
                sTraceTagApp = android.os.Trace.class.getField("TRACE_TAG_APP").getLong(null);
                sIsTagEnabledMethod = android.os.Trace.class.getMethod("isTagEnabled", java.lang.Long.TYPE);
            }
            return ((java.lang.Boolean) sIsTagEnabledMethod.invoke(null, java.lang.Long.valueOf(sTraceTagApp))).booleanValue();
        } catch (java.lang.Exception e) {
            handleException("isTagEnabled", e);
            return false;
        }
    }

    @android.annotation.SuppressLint({"NewApi"})
    public static void setCounter(@androidx.annotation.NonNull java.lang.String str, int i) {
        try {
            if (sTraceCounterMethod == null) {
                androidx.tracing.TraceApi29Impl.setCounter(str, i);
                return;
            }
        } catch (java.lang.NoClassDefFoundError | java.lang.NoSuchMethodError unused) {
        }
        setCounterFallback(str, i);
    }

    private static void setCounterFallback(@androidx.annotation.NonNull java.lang.String str, int i) {
        try {
            if (sTraceCounterMethod == null) {
                sTraceCounterMethod = android.os.Trace.class.getMethod("traceCounter", java.lang.Long.TYPE, java.lang.String.class, java.lang.Integer.TYPE);
            }
            sTraceCounterMethod.invoke(null, java.lang.Long.valueOf(sTraceTagApp), str, java.lang.Integer.valueOf(i));
        } catch (java.lang.Exception e) {
            handleException("traceCounter", e);
        }
    }
}
