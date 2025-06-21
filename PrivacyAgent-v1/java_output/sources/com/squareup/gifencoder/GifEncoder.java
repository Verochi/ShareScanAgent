package com.squareup.gifencoder;

/* loaded from: classes19.dex */
public final class GifEncoder {
    public final java.io.OutputStream a;
    public final int b;
    public final int c;

    public GifEncoder(java.io.OutputStream outputStream, int i, int i2, int i3) throws java.io.IOException {
        this.a = outputStream;
        this.b = i;
        this.c = i2;
        com.squareup.gifencoder.HeaderBlock.a(outputStream);
        com.squareup.gifencoder.LogicalScreenDescriptorBlock.a(outputStream, i, i2, false, 1, false, 0, 0, 0);
        com.squareup.gifencoder.NetscapeLoopingExtensionBlock.a(outputStream, i3);
    }

    public static int a(int i) {
        int i2 = 0;
        while (true) {
            int i3 = i2 + 1;
            if ((1 << i3) >= i) {
                return i2;
            }
            i2 = i3;
        }
    }

    public com.squareup.gifencoder.GifEncoder addImage(int[] iArr, int i, com.squareup.gifencoder.ImageOptions imageOptions) throws java.io.IOException {
        addImage(com.squareup.gifencoder.Image.fromRgb(iArr, i), imageOptions);
        return this;
    }

    public com.squareup.gifencoder.GifEncoder addImage(int[][] iArr, com.squareup.gifencoder.ImageOptions imageOptions) throws java.io.IOException {
        addImage(com.squareup.gifencoder.Image.fromRgb(iArr), imageOptions);
        return this;
    }

    public synchronized void addImage(com.squareup.gifencoder.Image image, com.squareup.gifencoder.ImageOptions imageOptions) throws java.io.IOException {
        com.squareup.gifencoder.Image image2;
        if (imageOptions.a + image.getWidth() > this.b || imageOptions.b + image.getHeight() > this.c) {
            throw new java.lang.IllegalArgumentException("Image does not fit in screen.");
        }
        com.squareup.gifencoder.Multiset<com.squareup.gifencoder.Color> a = image.a();
        java.util.Set<com.squareup.gifencoder.Color> distinctElements = a.getDistinctElements();
        if (distinctElements.size() > 256) {
            distinctElements = imageOptions.c.quantize(a, 256);
            image2 = imageOptions.d.dither(image, distinctElements);
        } else {
            image2 = image;
        }
        com.squareup.gifencoder.ColorTable a2 = com.squareup.gifencoder.ColorTable.a(distinctElements);
        int c = a2.c();
        int[] b = a2.b(image2);
        com.squareup.gifencoder.GraphicsControlExtensionBlock.a(this.a, imageOptions.e, false, false, imageOptions.f, 0);
        com.squareup.gifencoder.ImageDescriptorBlock.a(this.a, imageOptions.a, imageOptions.b, image2.getWidth(), image2.getHeight(), true, false, false, a(c));
        a2.e(this.a);
        com.squareup.gifencoder.LzwEncoder lzwEncoder = new com.squareup.gifencoder.LzwEncoder(c);
        com.squareup.gifencoder.ImageDataBlock.a(this.a, lzwEncoder.f(), lzwEncoder.e(b));
    }

    public synchronized void finishEncoding() throws java.io.IOException {
        this.a.write(59);
    }
}
