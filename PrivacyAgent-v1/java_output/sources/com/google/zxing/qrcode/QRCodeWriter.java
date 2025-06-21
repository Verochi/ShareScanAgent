package com.google.zxing.qrcode;

/* loaded from: classes22.dex */
public final class QRCodeWriter implements com.google.zxing.Writer {
    private static final int QUIET_ZONE_SIZE = 4;

    private static com.google.zxing.common.BitMatrix renderResult(com.google.zxing.qrcode.encoder.QRCode qRCode, int i, int i2, int i3) {
        com.google.zxing.qrcode.encoder.ByteMatrix matrix = qRCode.getMatrix();
        if (matrix == null) {
            throw new java.lang.IllegalStateException();
        }
        int width = matrix.getWidth();
        int height = matrix.getHeight();
        int i4 = i3 * 2;
        int i5 = width + i4;
        int i6 = i4 + height;
        int max = java.lang.Math.max(i, i5);
        int max2 = java.lang.Math.max(i2, i6);
        int min = java.lang.Math.min(max / i5, max2 / i6);
        int i7 = (max - (width * min)) / 2;
        int i8 = (max2 - (height * min)) / 2;
        com.google.zxing.common.BitMatrix bitMatrix = new com.google.zxing.common.BitMatrix(max, max2);
        int i9 = 0;
        while (i9 < height) {
            int i10 = i7;
            int i11 = 0;
            while (i11 < width) {
                if (matrix.get(i11, i9) == 1) {
                    bitMatrix.setRegion(i10, i8, min, min);
                }
                i11++;
                i10 += min;
            }
            i9++;
            i8 += min;
        }
        return bitMatrix;
    }

    @Override // com.google.zxing.Writer
    public com.google.zxing.common.BitMatrix encode(java.lang.String str, com.google.zxing.BarcodeFormat barcodeFormat, int i, int i2) throws com.google.zxing.WriterException {
        return encode(str, barcodeFormat, i, i2, null);
    }

    @Override // com.google.zxing.Writer
    public com.google.zxing.common.BitMatrix encode(java.lang.String str, com.google.zxing.BarcodeFormat barcodeFormat, int i, int i2, java.util.Map<com.google.zxing.EncodeHintType, ?> map) throws com.google.zxing.WriterException {
        if (str.isEmpty()) {
            throw new java.lang.IllegalArgumentException("Found empty contents");
        }
        if (barcodeFormat != com.google.zxing.BarcodeFormat.QR_CODE) {
            throw new java.lang.IllegalArgumentException("Can only encode QR_CODE, but got " + barcodeFormat);
        }
        if (i < 0 || i2 < 0) {
            throw new java.lang.IllegalArgumentException("Requested dimensions are too small: " + i + 'x' + i2);
        }
        com.google.zxing.qrcode.decoder.ErrorCorrectionLevel errorCorrectionLevel = com.google.zxing.qrcode.decoder.ErrorCorrectionLevel.L;
        int i3 = 4;
        if (map != null) {
            com.google.zxing.EncodeHintType encodeHintType = com.google.zxing.EncodeHintType.ERROR_CORRECTION;
            if (map.containsKey(encodeHintType)) {
                errorCorrectionLevel = com.google.zxing.qrcode.decoder.ErrorCorrectionLevel.valueOf(map.get(encodeHintType).toString());
            }
            com.google.zxing.EncodeHintType encodeHintType2 = com.google.zxing.EncodeHintType.MARGIN;
            if (map.containsKey(encodeHintType2)) {
                i3 = java.lang.Integer.parseInt(map.get(encodeHintType2).toString());
            }
        }
        return renderResult(com.google.zxing.qrcode.encoder.Encoder.encode(str, errorCorrectionLevel, map), i, i2, i3);
    }
}
