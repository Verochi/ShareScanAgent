package com.alimm.tanx.ui.image.glide.disklrucache;

/* loaded from: classes.dex */
final class Util {
    static final java.nio.charset.Charset US_ASCII = java.nio.charset.Charset.forName("US-ASCII");
    static final java.nio.charset.Charset UTF_8 = java.nio.charset.Charset.forName("UTF-8");

    private Util() {
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
            throw new java.io.IOException("not a readable directory: " + file);
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

    public static java.lang.String readFully(java.io.Reader reader) throws java.io.IOException {
        try {
            java.io.StringWriter stringWriter = new java.io.StringWriter();
            char[] cArr = new char[1024];
            while (true) {
                int read = reader.read(cArr);
                if (read == -1) {
                    return stringWriter.toString();
                }
                stringWriter.write(cArr, 0, read);
            }
        } finally {
            reader.close();
        }
    }
}
