package com.google.zxing.common.reedsolomon;

/* loaded from: classes22.dex */
public final class GenericGF {
    public static final com.google.zxing.common.reedsolomon.GenericGF AZTEC_DATA_6;
    public static final com.google.zxing.common.reedsolomon.GenericGF AZTEC_DATA_8;
    public static final com.google.zxing.common.reedsolomon.GenericGF AZTEC_PARAM;
    public static final com.google.zxing.common.reedsolomon.GenericGF DATA_MATRIX_FIELD_256;
    public static final com.google.zxing.common.reedsolomon.GenericGF MAXICODE_FIELD_64;
    public static final com.google.zxing.common.reedsolomon.GenericGF QR_CODE_FIELD_256;
    private final int[] expTable;
    private final int generatorBase;
    private final int[] logTable;
    private final com.google.zxing.common.reedsolomon.GenericGFPoly one;
    private final int primitive;
    private final int size;
    private final com.google.zxing.common.reedsolomon.GenericGFPoly zero;
    public static final com.google.zxing.common.reedsolomon.GenericGF AZTEC_DATA_12 = new com.google.zxing.common.reedsolomon.GenericGF(com.bytedance.sdk.openadsdk.TTAdConstant.INIT_FAILED_CREATE_INITIALIZER_FAILED, 4096, 1);
    public static final com.google.zxing.common.reedsolomon.GenericGF AZTEC_DATA_10 = new com.google.zxing.common.reedsolomon.GenericGF(com.ss.android.socialbase.downloader.constants.DownloadErrorCode.ERROR_CHUNK_NOT_EQUALS_CACHE, 1024, 1);

    static {
        com.google.zxing.common.reedsolomon.GenericGF genericGF = new com.google.zxing.common.reedsolomon.GenericGF(67, 64, 1);
        AZTEC_DATA_6 = genericGF;
        AZTEC_PARAM = new com.google.zxing.common.reedsolomon.GenericGF(19, 16, 1);
        QR_CODE_FIELD_256 = new com.google.zxing.common.reedsolomon.GenericGF(285, 256, 0);
        com.google.zxing.common.reedsolomon.GenericGF genericGF2 = new com.google.zxing.common.reedsolomon.GenericGF(301, 256, 1);
        DATA_MATRIX_FIELD_256 = genericGF2;
        AZTEC_DATA_8 = genericGF2;
        MAXICODE_FIELD_64 = genericGF;
    }

    public GenericGF(int i, int i2, int i3) {
        this.primitive = i;
        this.size = i2;
        this.generatorBase = i3;
        this.expTable = new int[i2];
        this.logTable = new int[i2];
        int i4 = 1;
        for (int i5 = 0; i5 < i2; i5++) {
            this.expTable[i5] = i4;
            i4 *= 2;
            if (i4 >= i2) {
                i4 = (i4 ^ i) & (i2 - 1);
            }
        }
        for (int i6 = 0; i6 < i2 - 1; i6++) {
            this.logTable[this.expTable[i6]] = i6;
        }
        this.zero = new com.google.zxing.common.reedsolomon.GenericGFPoly(this, new int[]{0});
        this.one = new com.google.zxing.common.reedsolomon.GenericGFPoly(this, new int[]{1});
    }

    public static int addOrSubtract(int i, int i2) {
        return i ^ i2;
    }

    public com.google.zxing.common.reedsolomon.GenericGFPoly buildMonomial(int i, int i2) {
        if (i < 0) {
            throw new java.lang.IllegalArgumentException();
        }
        if (i2 == 0) {
            return this.zero;
        }
        int[] iArr = new int[i + 1];
        iArr[0] = i2;
        return new com.google.zxing.common.reedsolomon.GenericGFPoly(this, iArr);
    }

    public int exp(int i) {
        return this.expTable[i];
    }

    public int getGeneratorBase() {
        return this.generatorBase;
    }

    public com.google.zxing.common.reedsolomon.GenericGFPoly getOne() {
        return this.one;
    }

    public int getSize() {
        return this.size;
    }

    public com.google.zxing.common.reedsolomon.GenericGFPoly getZero() {
        return this.zero;
    }

    public int inverse(int i) {
        if (i != 0) {
            return this.expTable[(this.size - this.logTable[i]) - 1];
        }
        throw new java.lang.ArithmeticException();
    }

    public int log(int i) {
        if (i != 0) {
            return this.logTable[i];
        }
        throw new java.lang.IllegalArgumentException();
    }

    public int multiply(int i, int i2) {
        if (i == 0 || i2 == 0) {
            return 0;
        }
        int[] iArr = this.expTable;
        int[] iArr2 = this.logTable;
        return iArr[(iArr2[i] + iArr2[i2]) % (this.size - 1)];
    }

    public java.lang.String toString() {
        return "GF(0x" + java.lang.Integer.toHexString(this.primitive) + ',' + this.size + ')';
    }
}
