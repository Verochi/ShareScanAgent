package com.zx.a.I8b7;

/* loaded from: classes19.dex */
public class c2 {
    public static <T> java.util.List<T> a(java.util.List<T> list) {
        return java.util.Collections.unmodifiableList(new java.util.ArrayList(list));
    }

    public static void a(java.io.Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (java.lang.RuntimeException e) {
                throw e;
            } catch (java.lang.Throwable unused) {
            }
        }
    }
}
