package com.squareup.gifencoder;

/* loaded from: classes19.dex */
final class ColorTable {
    public final java.util.Map<java.lang.Integer, com.squareup.gifencoder.Color> a;
    public final java.util.Map<com.squareup.gifencoder.Color, java.lang.Integer> b;

    public ColorTable(java.util.Map<java.lang.Integer, com.squareup.gifencoder.Color> map, java.util.Map<com.squareup.gifencoder.Color, java.lang.Integer> map2) {
        this.a = map;
        this.b = map2;
    }

    public static com.squareup.gifencoder.ColorTable a(java.util.Set<com.squareup.gifencoder.Color> set) {
        java.util.HashMap hashMap = new java.util.HashMap();
        java.util.HashMap hashMap2 = new java.util.HashMap();
        int i = 0;
        for (com.squareup.gifencoder.Color color : set) {
            if (!hashMap2.containsKey(color)) {
                hashMap.put(java.lang.Integer.valueOf(i), color);
                hashMap2.put(color, java.lang.Integer.valueOf(i));
                i++;
            }
        }
        return new com.squareup.gifencoder.ColorTable(hashMap, hashMap2);
    }

    public int[] b(com.squareup.gifencoder.Image image) {
        int numPixels = image.getNumPixels();
        int[] iArr = new int[numPixels];
        for (int i = 0; i < numPixels; i++) {
            iArr[i] = this.b.get(image.getColor(i)).intValue();
        }
        return iArr;
    }

    public int c() {
        return java.lang.Math.max(com.squareup.gifencoder.GifMath.b(d()), 2);
    }

    public final int d() {
        return this.b.size();
    }

    public void e(java.io.OutputStream outputStream) throws java.io.IOException {
        for (int i = 0; i < d(); i++) {
            com.squareup.gifencoder.Streams.b(outputStream, this.a.get(java.lang.Integer.valueOf(i)).getRgbInt());
        }
        for (int d = d(); d < c(); d++) {
            com.squareup.gifencoder.Streams.b(outputStream, 0);
        }
    }
}
