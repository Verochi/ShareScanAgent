package androidx.tracing;

@androidx.annotation.RequiresApi(18)
/* loaded from: classes.dex */
final class TraceApi18Impl {
    private TraceApi18Impl() {
    }

    public static void beginSection(@androidx.annotation.NonNull java.lang.String str) {
        android.os.Trace.beginSection(str);
    }

    public static void endSection() {
        android.os.Trace.endSection();
    }
}
