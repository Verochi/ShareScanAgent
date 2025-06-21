package com.squareup.gifencoder;

/* loaded from: classes19.dex */
final class GraphicsControlExtensionBlock {
    public static void a(java.io.OutputStream outputStream, com.squareup.gifencoder.DisposalMethod disposalMethod, boolean z, boolean z2, int i, int i2) throws java.io.IOException {
        outputStream.write(33);
        outputStream.write(249);
        outputStream.write(4);
        outputStream.write((disposalMethod.ordinal() << 3) | (z ? 2 : 0) | (z2 ? 1 : 0));
        com.squareup.gifencoder.Streams.c(outputStream, i);
        outputStream.write(i2);
        outputStream.write(0);
    }
}
