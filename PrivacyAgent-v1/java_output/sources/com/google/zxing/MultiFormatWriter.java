package com.google.zxing;

/* loaded from: classes22.dex */
public final class MultiFormatWriter implements com.google.zxing.Writer {

    /* renamed from: com.google.zxing.MultiFormatWriter$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$zxing$BarcodeFormat;

        static {
            int[] iArr = new int[com.google.zxing.BarcodeFormat.values().length];
            $SwitchMap$com$google$zxing$BarcodeFormat = iArr;
            try {
                iArr[com.google.zxing.BarcodeFormat.QR_CODE.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
            }
        }
    }

    @Override // com.google.zxing.Writer
    public com.google.zxing.common.BitMatrix encode(java.lang.String str, com.google.zxing.BarcodeFormat barcodeFormat, int i, int i2) throws com.google.zxing.WriterException {
        return encode(str, barcodeFormat, i, i2, null);
    }

    @Override // com.google.zxing.Writer
    public com.google.zxing.common.BitMatrix encode(java.lang.String str, com.google.zxing.BarcodeFormat barcodeFormat, int i, int i2, java.util.Map<com.google.zxing.EncodeHintType, ?> map) throws com.google.zxing.WriterException {
        if (com.google.zxing.MultiFormatWriter.AnonymousClass1.$SwitchMap$com$google$zxing$BarcodeFormat[barcodeFormat.ordinal()] == 1) {
            return new com.google.zxing.qrcode.QRCodeWriter().encode(str, barcodeFormat, i, i2, map);
        }
        throw new java.lang.IllegalArgumentException("No encoder available for format " + barcodeFormat);
    }
}
