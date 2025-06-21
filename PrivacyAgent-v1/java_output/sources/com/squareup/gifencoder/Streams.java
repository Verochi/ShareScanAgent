package com.squareup.gifencoder;

/* loaded from: classes19.dex */
final class Streams {
    public static void a(java.io.OutputStream outputStream, java.lang.String str) throws java.io.IOException {
        for (char c : str.toCharArray()) {
            outputStream.write(c);
        }
    }

    public static void b(java.io.OutputStream outputStream, int i) throws java.io.IOException {
        outputStream.write(i >>> 16);
        outputStream.write(i >>> 8);
        outputStream.write(i);
    }

    public static void c(java.io.OutputStream outputStream, int i) throws java.io.IOException {
        outputStream.write(i);
        outputStream.write(i >>> 8);
    }
}
