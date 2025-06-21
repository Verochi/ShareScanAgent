package com.squareup.gifencoder;

/* loaded from: classes19.dex */
public final class Image {
    public final com.squareup.gifencoder.Color[][] a;

    public Image(com.squareup.gifencoder.Color[][] colorArr) {
        this.a = colorArr;
    }

    public static com.squareup.gifencoder.Image fromColors(com.squareup.gifencoder.Color[][] colorArr) {
        return new com.squareup.gifencoder.Image(colorArr);
    }

    public static com.squareup.gifencoder.Image fromRgb(int[] iArr, int i) {
        if (iArr.length % i != 0) {
            throw new java.lang.IllegalArgumentException("the given width does not divide the number of pixels");
        }
        int length = iArr.length / i;
        com.squareup.gifencoder.Color[][] colorArr = (com.squareup.gifencoder.Color[][]) java.lang.reflect.Array.newInstance((java.lang.Class<?>) com.squareup.gifencoder.Color.class, length, i);
        for (int i2 = 0; i2 < length; i2++) {
            for (int i3 = 0; i3 < i; i3++) {
                colorArr[i2][i3] = com.squareup.gifencoder.Color.fromRgbInt(iArr[(i2 * i) + i3]);
            }
        }
        return new com.squareup.gifencoder.Image(colorArr);
    }

    public static com.squareup.gifencoder.Image fromRgb(int[][] iArr) {
        int length = iArr.length;
        int length2 = iArr[0].length;
        com.squareup.gifencoder.Color[][] colorArr = (com.squareup.gifencoder.Color[][]) java.lang.reflect.Array.newInstance((java.lang.Class<?>) com.squareup.gifencoder.Color.class, length, length2);
        for (int i = 0; i < length; i++) {
            if (iArr[i].length != length2) {
                throw new java.lang.IllegalArgumentException("rows lengths do not match in RGB array");
            }
            for (int i2 = 0; i2 < length2; i2++) {
                colorArr[i][i2] = com.squareup.gifencoder.Color.fromRgbInt(iArr[i][i2]);
            }
        }
        return new com.squareup.gifencoder.Image(colorArr);
    }

    public com.squareup.gifencoder.Multiset<com.squareup.gifencoder.Color> a() {
        com.squareup.gifencoder.HashMultiset hashMultiset = new com.squareup.gifencoder.HashMultiset();
        for (int i = 0; i < getNumPixels(); i++) {
            hashMultiset.add(getColor(i));
        }
        return hashMultiset;
    }

    public com.squareup.gifencoder.Color getColor(int i) {
        return this.a[i / getWidth()][i % getWidth()];
    }

    public com.squareup.gifencoder.Color getColor(int i, int i2) {
        return this.a[i2][i];
    }

    public int getHeight() {
        return this.a.length;
    }

    public int getNumPixels() {
        return getWidth() * getHeight();
    }

    public int getWidth() {
        return this.a[0].length;
    }
}
