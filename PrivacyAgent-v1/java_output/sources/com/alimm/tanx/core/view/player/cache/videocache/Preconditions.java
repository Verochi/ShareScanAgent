package com.alimm.tanx.core.view.player.cache.videocache;

/* loaded from: classes.dex */
public final class Preconditions {
    public static void checkAllNotNull(java.lang.Object... objArr) {
        for (java.lang.Object obj : objArr) {
            obj.getClass();
        }
    }

    public static void checkArgument(boolean z) {
        if (!z) {
            throw new java.lang.IllegalArgumentException();
        }
    }

    public static void checkArgument(boolean z, java.lang.String str) {
        if (!z) {
            throw new java.lang.IllegalArgumentException(str);
        }
    }

    public static <T> T checkNotNull(T t) {
        t.getClass();
        return t;
    }

    public static <T> T checkNotNull(T t, java.lang.String str) {
        if (t != null) {
            return t;
        }
        throw new java.lang.NullPointerException(str);
    }
}
