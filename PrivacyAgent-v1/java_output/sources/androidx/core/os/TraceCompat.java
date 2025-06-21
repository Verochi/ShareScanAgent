package androidx.core.os;

@java.lang.Deprecated
/* loaded from: classes.dex */
public final class TraceCompat {
    private static final java.lang.String TAG = "TraceCompat";
    private static java.lang.reflect.Method sAsyncTraceBeginMethod;
    private static java.lang.reflect.Method sAsyncTraceEndMethod;
    private static java.lang.reflect.Method sIsTagEnabledMethod;
    private static java.lang.reflect.Method sTraceCounterMethod;
    private static long sTraceTagApp;

    static {
        if (android.os.Build.VERSION.SDK_INT < 29) {
            try {
                sTraceTagApp = android.os.Trace.class.getField("TRACE_TAG_APP").getLong(null);
                java.lang.Class cls = java.lang.Long.TYPE;
                sIsTagEnabledMethod = android.os.Trace.class.getMethod("isTagEnabled", cls);
                java.lang.Class cls2 = java.lang.Integer.TYPE;
                sAsyncTraceBeginMethod = android.os.Trace.class.getMethod("asyncTraceBegin", cls, java.lang.String.class, cls2);
                sAsyncTraceEndMethod = android.os.Trace.class.getMethod("asyncTraceEnd", cls, java.lang.String.class, cls2);
                sTraceCounterMethod = android.os.Trace.class.getMethod("traceCounter", cls, java.lang.String.class, cls2);
            } catch (java.lang.Exception unused) {
            }
        }
    }

    private TraceCompat() {
    }

    public static void beginAsyncSection(@androidx.annotation.NonNull java.lang.String str, int i) {
        if (android.os.Build.VERSION.SDK_INT >= 29) {
            android.os.Trace.beginAsyncSection(str, i);
        } else {
            try {
                sAsyncTraceBeginMethod.invoke(null, java.lang.Long.valueOf(sTraceTagApp), str, java.lang.Integer.valueOf(i));
            } catch (java.lang.Exception unused) {
            }
        }
    }

    public static void beginSection(@androidx.annotation.NonNull java.lang.String str) {
        android.os.Trace.beginSection(str);
    }

    public static void endAsyncSection(@androidx.annotation.NonNull java.lang.String str, int i) {
        if (android.os.Build.VERSION.SDK_INT >= 29) {
            android.os.Trace.endAsyncSection(str, i);
        } else {
            try {
                sAsyncTraceEndMethod.invoke(null, java.lang.Long.valueOf(sTraceTagApp), str, java.lang.Integer.valueOf(i));
            } catch (java.lang.Exception unused) {
            }
        }
    }

    public static void endSection() {
        android.os.Trace.endSection();
    }

    public static boolean isEnabled() {
        boolean isEnabled;
        if (android.os.Build.VERSION.SDK_INT >= 29) {
            isEnabled = android.os.Trace.isEnabled();
            return isEnabled;
        }
        try {
            return ((java.lang.Boolean) sIsTagEnabledMethod.invoke(null, java.lang.Long.valueOf(sTraceTagApp))).booleanValue();
        } catch (java.lang.Exception unused) {
            return false;
        }
    }

    public static void setCounter(@androidx.annotation.NonNull java.lang.String str, int i) {
        if (android.os.Build.VERSION.SDK_INT >= 29) {
            android.os.Trace.setCounter(str, i);
        } else {
            try {
                sTraceCounterMethod.invoke(null, java.lang.Long.valueOf(sTraceTagApp), str, java.lang.Integer.valueOf(i));
            } catch (java.lang.Exception unused) {
            }
        }
    }
}
