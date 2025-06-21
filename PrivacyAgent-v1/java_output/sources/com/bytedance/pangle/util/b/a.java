package com.bytedance.pangle.util.b;

/* loaded from: classes.dex */
public final class a {
    final com.bytedance.pangle.util.b.b.d a;
    final com.bytedance.pangle.util.b.a.b b = new com.bytedance.pangle.util.b.a.b();

    public a(com.bytedance.pangle.util.b.b.d dVar) {
        this.a = dVar;
    }

    public static void a(java.io.File file) {
        if (file.exists() && !file.delete()) {
            throw new java.util.zip.ZipException("Could not delete temporary file");
        }
    }

    public static void a(java.io.RandomAccessFile randomAccessFile, java.io.RandomAccessFile randomAccessFile2, long j, long j2, java.lang.String str) {
        com.bytedance.pangle.util.g.a(randomAccessFile, randomAccessFile2, j, j + j2, str);
    }
}
