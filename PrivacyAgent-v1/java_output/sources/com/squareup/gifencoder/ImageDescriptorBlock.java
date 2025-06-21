package com.squareup.gifencoder;

/* loaded from: classes19.dex */
final class ImageDescriptorBlock {
    public static void a(java.io.OutputStream outputStream, int i, int i2, int i3, int i4, boolean z, boolean z2, boolean z3, int i5) throws java.io.IOException {
        outputStream.write(44);
        com.squareup.gifencoder.Streams.c(outputStream, i);
        com.squareup.gifencoder.Streams.c(outputStream, i2);
        com.squareup.gifencoder.Streams.c(outputStream, i3);
        com.squareup.gifencoder.Streams.c(outputStream, i4);
        outputStream.write((z3 ? 32 : 0) | (z ? 128 : 0) | (z2 ? 64 : 0) | i5);
    }
}
