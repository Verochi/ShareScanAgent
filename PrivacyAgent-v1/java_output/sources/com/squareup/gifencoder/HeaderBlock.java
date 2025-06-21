package com.squareup.gifencoder;

/* loaded from: classes19.dex */
final class HeaderBlock {
    public static void a(java.io.OutputStream outputStream) throws java.io.IOException {
        com.squareup.gifencoder.Streams.a(outputStream, "GIF");
        com.squareup.gifencoder.Streams.a(outputStream, "89a");
    }
}
