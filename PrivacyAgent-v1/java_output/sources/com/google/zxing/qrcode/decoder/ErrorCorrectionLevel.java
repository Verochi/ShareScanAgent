package com.google.zxing.qrcode.decoder;

/* loaded from: classes22.dex */
public enum ErrorCorrectionLevel {
    L(1),
    M(0),
    Q(3),
    H(2);

    private static final com.google.zxing.qrcode.decoder.ErrorCorrectionLevel[] FOR_BITS;
    private final int bits;

    static {
        com.google.zxing.qrcode.decoder.ErrorCorrectionLevel errorCorrectionLevel = L;
        com.google.zxing.qrcode.decoder.ErrorCorrectionLevel errorCorrectionLevel2 = M;
        com.google.zxing.qrcode.decoder.ErrorCorrectionLevel errorCorrectionLevel3 = Q;
        FOR_BITS = new com.google.zxing.qrcode.decoder.ErrorCorrectionLevel[]{errorCorrectionLevel2, errorCorrectionLevel, H, errorCorrectionLevel3};
    }

    ErrorCorrectionLevel(int i) {
        this.bits = i;
    }

    public static com.google.zxing.qrcode.decoder.ErrorCorrectionLevel forBits(int i) {
        if (i >= 0) {
            com.google.zxing.qrcode.decoder.ErrorCorrectionLevel[] errorCorrectionLevelArr = FOR_BITS;
            if (i < errorCorrectionLevelArr.length) {
                return errorCorrectionLevelArr[i];
            }
        }
        throw new java.lang.IllegalArgumentException();
    }

    public int getBits() {
        return this.bits;
    }
}
