package com.squareup.gifencoder;

/* loaded from: classes19.dex */
public final class FloydSteinbergDitherer implements com.squareup.gifencoder.Ditherer {
    public static final com.squareup.gifencoder.FloydSteinbergDitherer INSTANCE = new com.squareup.gifencoder.FloydSteinbergDitherer();
    public static final com.squareup.gifencoder.FloydSteinbergDitherer.ErrorComponent[] a = {new com.squareup.gifencoder.FloydSteinbergDitherer.ErrorComponent(1, 0, 0.4375d), new com.squareup.gifencoder.FloydSteinbergDitherer.ErrorComponent(-1, 1, 0.1875d), new com.squareup.gifencoder.FloydSteinbergDitherer.ErrorComponent(0, 1, 0.3125d), new com.squareup.gifencoder.FloydSteinbergDitherer.ErrorComponent(1, 1, 0.0625d)};

    public static final class ErrorComponent {
        public final int a;
        public final int b;
        public final double c;

        public ErrorComponent(int i, int i2, double d) {
            this.a = i;
            this.b = i2;
            this.c = d;
        }
    }

    @Override // com.squareup.gifencoder.Ditherer
    public com.squareup.gifencoder.Image dither(com.squareup.gifencoder.Image image, java.util.Set<com.squareup.gifencoder.Color> set) {
        int width = image.getWidth();
        int height = image.getHeight();
        com.squareup.gifencoder.Color[][] colorArr = (com.squareup.gifencoder.Color[][]) java.lang.reflect.Array.newInstance((java.lang.Class<?>) com.squareup.gifencoder.Color.class, height, width);
        for (int i = 0; i < height; i++) {
            for (int i2 = 0; i2 < width; i2++) {
                colorArr[i][i2] = image.getColor(i2, i);
            }
        }
        for (int i3 = 0; i3 < height; i3++) {
            for (int i4 = 0; i4 < width; i4++) {
                com.squareup.gifencoder.Color color = colorArr[i3][i4];
                com.squareup.gifencoder.Color nearestColor = color.getNearestColor(set);
                colorArr[i3][i4] = nearestColor;
                com.squareup.gifencoder.Color minus = color.minus(nearestColor);
                for (com.squareup.gifencoder.FloydSteinbergDitherer.ErrorComponent errorComponent : a) {
                    int i5 = errorComponent.a + i4;
                    int i6 = errorComponent.b + i3;
                    if (i5 >= 0 && i6 >= 0 && i5 < width && i6 < height) {
                        com.squareup.gifencoder.Color scaled = minus.scaled(errorComponent.c);
                        com.squareup.gifencoder.Color[] colorArr2 = colorArr[i6];
                        colorArr2[i5] = colorArr2[i5].plus(scaled);
                    }
                }
            }
        }
        return com.squareup.gifencoder.Image.fromColors(colorArr);
    }
}
