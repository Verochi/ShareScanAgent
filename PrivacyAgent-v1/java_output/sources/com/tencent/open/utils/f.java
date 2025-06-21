package com.tencent.open.utils;

/* loaded from: classes19.dex */
public final class f {
    private static android.content.Context a;

    public static final android.content.Context a() {
        android.content.Context context = a;
        if (context == null) {
            return null;
        }
        return context;
    }

    public static final java.io.File a(java.lang.String str) {
        return com.tencent.open.utils.l.h(a(), str);
    }

    public static final void a(android.content.Context context) {
        a = context;
    }

    public static final java.lang.String b() {
        return a() == null ? "" : a().getPackageName();
    }

    public static final java.io.File c() {
        if (a() == null) {
            return null;
        }
        return a().getFilesDir();
    }

    public static final java.io.File d() {
        android.content.Context a2 = a();
        if (a2 != null) {
            return a2.getCacheDir();
        }
        return null;
    }

    public static final java.io.File e() {
        return a((java.lang.String) null);
    }
}
