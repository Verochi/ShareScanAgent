package com.squareup.gifencoder;

/* loaded from: classes19.dex */
final class LogicalScreenDescriptorBlock {
    public static void a(java.io.OutputStream outputStream, int i, int i2, boolean z, int i3, boolean z2, int i4, int i5, int i6) throws java.io.IOException {
        com.squareup.gifencoder.Streams.c(outputStream, i);
        com.squareup.gifencoder.Streams.c(outputStream, i2);
        outputStream.write((z2 ? 8 : 0) | (z ? 128 : 0) | (i3 << 4) | i4);
        outputStream.write(i5);
        outputStream.write(i6);
    }
}
