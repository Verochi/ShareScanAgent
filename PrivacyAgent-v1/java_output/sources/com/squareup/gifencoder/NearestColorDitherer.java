package com.squareup.gifencoder;

/* loaded from: classes19.dex */
public final class NearestColorDitherer implements com.squareup.gifencoder.Ditherer {
    public static final com.squareup.gifencoder.NearestColorDitherer INSTANCE = new com.squareup.gifencoder.NearestColorDitherer();

    @Override // com.squareup.gifencoder.Ditherer
    public com.squareup.gifencoder.Image dither(com.squareup.gifencoder.Image image, java.util.Set<com.squareup.gifencoder.Color> set) {
        int width = image.getWidth();
        int height = image.getHeight();
        com.squareup.gifencoder.Color[][] colorArr = (com.squareup.gifencoder.Color[][]) java.lang.reflect.Array.newInstance((java.lang.Class<?>) com.squareup.gifencoder.Color.class, height, width);
        for (int i = 0; i < height; i++) {
            for (int i2 = 0; i2 < width; i2++) {
                colorArr[i][i2] = image.getColor(i2, i).getNearestColor(set);
            }
        }
        return com.squareup.gifencoder.Image.fromColors(colorArr);
    }
}
