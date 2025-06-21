package com.squareup.gifencoder;

/* loaded from: classes19.dex */
public final class UniformQuantizer implements com.squareup.gifencoder.ColorQuantizer {
    public static final com.squareup.gifencoder.UniformQuantizer INSTANCE = new com.squareup.gifencoder.UniformQuantizer();

    @Override // com.squareup.gifencoder.ColorQuantizer
    public java.util.Set<com.squareup.gifencoder.Color> quantize(com.squareup.gifencoder.Multiset<com.squareup.gifencoder.Color> multiset, int i) {
        int pow = (int) java.lang.Math.pow(i, 0.3333333333333333d);
        int i2 = pow + 1;
        int i3 = (pow * i2) * pow <= i ? i2 : pow;
        if (i2 * i3 * pow > i) {
            i2 = pow;
        }
        java.util.HashSet hashSet = new java.util.HashSet();
        for (int i4 = 0; i4 < i2; i4++) {
            for (int i5 = 0; i5 < i3; i5++) {
                for (int i6 = 0; i6 < pow; i6++) {
                    hashSet.add(new com.squareup.gifencoder.Color(i4 / (i2 - 1.0d), i5 / (i3 - 1.0d), i6 / (pow - 1.0d)));
                }
            }
        }
        return hashSet;
    }
}
