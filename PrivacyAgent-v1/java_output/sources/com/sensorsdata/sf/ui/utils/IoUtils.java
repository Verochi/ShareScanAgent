package com.sensorsdata.sf.ui.utils;

/* loaded from: classes19.dex */
public final class IoUtils {
    static final java.nio.charset.Charset US_ASCII = java.nio.charset.Charset.forName("US-ASCII");
    static final java.nio.charset.Charset UTF_8 = java.nio.charset.Charset.forName("UTF-8");

    private IoUtils() {
    }

    public static void closeQuietly(java.io.Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (java.lang.RuntimeException e) {
                throw e;
            } catch (java.lang.Exception unused) {
            }
        }
    }

    public static void deleteContents(java.io.File file) throws java.io.IOException {
        java.io.File[] listFiles = file.listFiles();
        if (listFiles == null) {
            throw new java.io.IOException("listFiles returned null: " + file);
        }
        for (java.io.File file2 : listFiles) {
            if (file2.isDirectory()) {
                deleteContents(file2);
            }
            if (!file2.delete()) {
                throw new java.io.IOException("failed to delete file: " + file2);
            }
        }
    }
}
