package com.igexin.base.util;

/* loaded from: classes22.dex */
public class IOUtils {
    public static void close(java.io.Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (java.io.IOException e) {
                e.printStackTrace();
            }
        }
    }
}
