package com.squareup.gifencoder;

/* loaded from: classes19.dex */
final class ImageDataBlock {
    public static void a(java.io.OutputStream outputStream, int i, byte[] bArr) throws java.io.IOException {
        outputStream.write(i);
        int i2 = 0;
        while (i2 < bArr.length) {
            int min = java.lang.Math.min(bArr.length - i2, 255);
            outputStream.write(min);
            outputStream.write(bArr, i2, min);
            i2 += min;
        }
        outputStream.write(0);
    }
}
