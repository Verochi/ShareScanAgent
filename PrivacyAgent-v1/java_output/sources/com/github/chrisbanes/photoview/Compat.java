package com.github.chrisbanes.photoview;

/* loaded from: classes22.dex */
class Compat {
    public static void a(android.view.View view, java.lang.Runnable runnable) {
        b(view, runnable);
    }

    @android.annotation.TargetApi(16)
    public static void b(android.view.View view, java.lang.Runnable runnable) {
        view.postOnAnimation(runnable);
    }
}
