package com.xiaomi.push;

/* loaded from: classes19.dex */
public final class s {
    public static void a() {
        if (android.os.Looper.getMainLooper().getThread() == java.lang.Thread.currentThread()) {
            throw new java.lang.RuntimeException("can't do this on ui thread");
        }
    }
}
