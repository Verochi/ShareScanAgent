package com.squareup.gifencoder;

/* loaded from: classes19.dex */
final class NetscapeLoopingExtensionBlock {
    public static void a(java.io.OutputStream outputStream, int i) throws java.io.IOException {
        outputStream.write(33);
        outputStream.write(255);
        outputStream.write(11);
        com.squareup.gifencoder.Streams.a(outputStream, "NETSCAPE2.0");
        outputStream.write(3);
        outputStream.write(1);
        com.squareup.gifencoder.Streams.c(outputStream, i);
        outputStream.write(0);
    }
}
