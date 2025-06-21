package com.anythink.expressad.exoplayer.k;

/* loaded from: classes12.dex */
public final class ad {
    private ad() {
    }

    public static void a() {
        if (com.anythink.expressad.exoplayer.k.af.a >= 18) {
            android.os.Trace.endSection();
        }
    }

    public static void a(java.lang.String str) {
        if (com.anythink.expressad.exoplayer.k.af.a >= 18) {
            android.os.Trace.beginSection(str);
        }
    }

    @android.annotation.TargetApi(18)
    private static void b() {
        android.os.Trace.endSection();
    }

    @android.annotation.TargetApi(18)
    private static void b(java.lang.String str) {
        android.os.Trace.beginSection(str);
    }
}
