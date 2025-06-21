package androidx.tracing;

@androidx.annotation.RequiresApi(29)
/* loaded from: classes.dex */
final class TraceApi29Impl {
    private TraceApi29Impl() {
    }

    public static void beginAsyncSection(@androidx.annotation.NonNull java.lang.String str, int i) {
        android.os.Trace.beginAsyncSection(str, i);
    }

    public static void endAsyncSection(@androidx.annotation.NonNull java.lang.String str, int i) {
        android.os.Trace.endAsyncSection(str, i);
    }

    public static void setCounter(@androidx.annotation.NonNull java.lang.String str, int i) {
        android.os.Trace.setCounter(str, i);
    }
}
