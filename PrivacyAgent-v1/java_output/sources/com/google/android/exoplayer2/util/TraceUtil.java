package com.google.android.exoplayer2.util;

/* loaded from: classes22.dex */
public final class TraceUtil {
    @androidx.annotation.RequiresApi(18)
    public static void a(java.lang.String str) {
        android.os.Trace.beginSection(str);
    }

    @androidx.annotation.RequiresApi(18)
    public static void b() {
        android.os.Trace.endSection();
    }

    public static void beginSection(java.lang.String str) {
        if (com.google.android.exoplayer2.util.Util.SDK_INT >= 18) {
            a(str);
        }
    }

    public static void endSection() {
        if (com.google.android.exoplayer2.util.Util.SDK_INT >= 18) {
            b();
        }
    }
}
