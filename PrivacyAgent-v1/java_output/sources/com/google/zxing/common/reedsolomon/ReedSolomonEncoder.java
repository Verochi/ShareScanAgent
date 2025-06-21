package com.google.zxing.common.reedsolomon;

/* loaded from: classes22.dex */
public final class ReedSolomonEncoder {
    private final java.util.List<com.google.zxing.common.reedsolomon.GenericGFPoly> cachedGenerators;
    private final com.google.zxing.common.reedsolomon.GenericGF field;

    public ReedSolomonEncoder(com.google.zxing.common.reedsolomon.GenericGF genericGF) {
        this.field = genericGF;
        java.util.ArrayList arrayList = new java.util.ArrayList();
        this.cachedGenerators = arrayList;
        arrayList.add(new com.google.zxing.common.reedsolomon.GenericGFPoly(genericGF, new int[]{1}));
    }

    private com.google.zxing.common.reedsolomon.GenericGFPoly buildGenerator(int i) {
        if (i >= this.cachedGenerators.size()) {
            java.util.List<com.google.zxing.common.reedsolomon.GenericGFPoly> list = this.cachedGenerators;
            com.google.zxing.common.reedsolomon.GenericGFPoly genericGFPoly = list.get(list.size() - 1);
            for (int size = this.cachedGenerators.size(); size <= i; size++) {
                com.google.zxing.common.reedsolomon.GenericGF genericGF = this.field;
                genericGFPoly = genericGFPoly.multiply(new com.google.zxing.common.reedsolomon.GenericGFPoly(genericGF, new int[]{1, genericGF.exp((size - 1) + genericGF.getGeneratorBase())}));
                this.cachedGenerators.add(genericGFPoly);
            }
        }
        return this.cachedGenerators.get(i);
    }

    public void encode(int[] iArr, int i) {
        if (i == 0) {
            throw new java.lang.IllegalArgumentException("No error correction bytes");
        }
        int length = iArr.length - i;
        if (length <= 0) {
            throw new java.lang.IllegalArgumentException("No data bytes provided");
        }
        com.google.zxing.common.reedsolomon.GenericGFPoly buildGenerator = buildGenerator(i);
        int[] iArr2 = new int[length];
        java.lang.System.arraycopy(iArr, 0, iArr2, 0, length);
        int[] coefficients = new com.google.zxing.common.reedsolomon.GenericGFPoly(this.field, iArr2).multiplyByMonomial(i, 1).divide(buildGenerator)[1].getCoefficients();
        int length2 = i - coefficients.length;
        for (int i2 = 0; i2 < length2; i2++) {
            iArr[length + i2] = 0;
        }
        java.lang.System.arraycopy(coefficients, 0, iArr, length + length2, coefficients.length);
    }
}
