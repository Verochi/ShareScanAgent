package com.google.zxing.qrcode.encoder;

/* loaded from: classes22.dex */
public final class Encoder {
    private static final int[] ALPHANUMERIC_TABLE = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 36, -1, -1, -1, 37, 38, -1, -1, -1, -1, 39, 40, -1, 41, 42, 43, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 44, -1, -1, -1, -1, -1, -1, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, -1, -1, -1, -1, -1};
    static final java.lang.String DEFAULT_BYTE_MODE_ENCODING = "ISO-8859-1";

    /* renamed from: com.google.zxing.qrcode.encoder.Encoder$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$zxing$qrcode$decoder$Mode;

        static {
            int[] iArr = new int[com.google.zxing.qrcode.decoder.Mode.values().length];
            $SwitchMap$com$google$zxing$qrcode$decoder$Mode = iArr;
            try {
                iArr[com.google.zxing.qrcode.decoder.Mode.NUMERIC.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$google$zxing$qrcode$decoder$Mode[com.google.zxing.qrcode.decoder.Mode.ALPHANUMERIC.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$google$zxing$qrcode$decoder$Mode[com.google.zxing.qrcode.decoder.Mode.BYTE.ordinal()] = 3;
            } catch (java.lang.NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$google$zxing$qrcode$decoder$Mode[com.google.zxing.qrcode.decoder.Mode.KANJI.ordinal()] = 4;
            } catch (java.lang.NoSuchFieldError unused4) {
            }
        }
    }

    private Encoder() {
    }

    public static void append8BitBytes(java.lang.String str, com.google.zxing.common.BitArray bitArray, java.lang.String str2) throws com.google.zxing.WriterException {
        try {
            for (byte b : str.getBytes(str2)) {
                bitArray.appendBits(b, 8);
            }
        } catch (java.io.UnsupportedEncodingException e) {
            throw new com.google.zxing.WriterException(e);
        }
    }

    public static void appendAlphanumericBytes(java.lang.CharSequence charSequence, com.google.zxing.common.BitArray bitArray) throws com.google.zxing.WriterException {
        int length = charSequence.length();
        int i = 0;
        while (i < length) {
            int alphanumericCode = getAlphanumericCode(charSequence.charAt(i));
            if (alphanumericCode == -1) {
                throw new com.google.zxing.WriterException();
            }
            int i2 = i + 1;
            if (i2 < length) {
                int alphanumericCode2 = getAlphanumericCode(charSequence.charAt(i2));
                if (alphanumericCode2 == -1) {
                    throw new com.google.zxing.WriterException();
                }
                bitArray.appendBits((alphanumericCode * 45) + alphanumericCode2, 11);
                i += 2;
            } else {
                bitArray.appendBits(alphanumericCode, 6);
                i = i2;
            }
        }
    }

    public static void appendBytes(java.lang.String str, com.google.zxing.qrcode.decoder.Mode mode, com.google.zxing.common.BitArray bitArray, java.lang.String str2) throws com.google.zxing.WriterException {
        int i = com.google.zxing.qrcode.encoder.Encoder.AnonymousClass1.$SwitchMap$com$google$zxing$qrcode$decoder$Mode[mode.ordinal()];
        if (i == 1) {
            appendNumericBytes(str, bitArray);
            return;
        }
        if (i == 2) {
            appendAlphanumericBytes(str, bitArray);
            return;
        }
        if (i == 3) {
            append8BitBytes(str, bitArray, str2);
        } else {
            if (i == 4) {
                appendKanjiBytes(str, bitArray);
                return;
            }
            throw new com.google.zxing.WriterException("Invalid mode: " + mode);
        }
    }

    private static void appendECI(com.google.zxing.common.CharacterSetECI characterSetECI, com.google.zxing.common.BitArray bitArray) {
        bitArray.appendBits(com.google.zxing.qrcode.decoder.Mode.ECI.getBits(), 4);
        bitArray.appendBits(characterSetECI.getValue(), 8);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0035 A[LOOP:0: B:4:0x0008->B:11:0x0035, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0044 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void appendKanjiBytes(java.lang.String str, com.google.zxing.common.BitArray bitArray) throws com.google.zxing.WriterException {
        int i;
        try {
            byte[] bytes = str.getBytes("Shift_JIS");
            int length = bytes.length;
            for (int i2 = 0; i2 < length; i2 += 2) {
                int i3 = ((bytes[i2] & 255) << 8) | (bytes[i2 + 1] & 255);
                int i4 = 33088;
                if (i3 < 33088 || i3 > 40956) {
                    if (i3 < 57408 || i3 > 60351) {
                        i = -1;
                        if (i != -1) {
                            throw new com.google.zxing.WriterException("Invalid byte sequence");
                        }
                        bitArray.appendBits(((i >> 8) * 192) + (i & 255), 13);
                    } else {
                        i4 = 49472;
                    }
                }
                i = i3 - i4;
                if (i != -1) {
                }
            }
        } catch (java.io.UnsupportedEncodingException e) {
            throw new com.google.zxing.WriterException(e);
        }
    }

    public static void appendLengthInfo(int i, com.google.zxing.qrcode.decoder.Version version, com.google.zxing.qrcode.decoder.Mode mode, com.google.zxing.common.BitArray bitArray) throws com.google.zxing.WriterException {
        int characterCountBits = mode.getCharacterCountBits(version);
        int i2 = 1 << characterCountBits;
        if (i < i2) {
            bitArray.appendBits(i, characterCountBits);
            return;
        }
        throw new com.google.zxing.WriterException(i + " is bigger than " + (i2 - 1));
    }

    public static void appendModeInfo(com.google.zxing.qrcode.decoder.Mode mode, com.google.zxing.common.BitArray bitArray) {
        bitArray.appendBits(mode.getBits(), 4);
    }

    public static void appendNumericBytes(java.lang.CharSequence charSequence, com.google.zxing.common.BitArray bitArray) {
        int length = charSequence.length();
        int i = 0;
        while (i < length) {
            int charAt = charSequence.charAt(i) - '0';
            int i2 = i + 2;
            if (i2 < length) {
                bitArray.appendBits((charAt * 100) + ((charSequence.charAt(i + 1) - '0') * 10) + (charSequence.charAt(i2) - '0'), 10);
                i += 3;
            } else {
                i++;
                if (i < length) {
                    bitArray.appendBits((charAt * 10) + (charSequence.charAt(i) - '0'), 7);
                    i = i2;
                } else {
                    bitArray.appendBits(charAt, 4);
                }
            }
        }
    }

    private static int calculateBitsNeeded(com.google.zxing.qrcode.decoder.Mode mode, com.google.zxing.common.BitArray bitArray, com.google.zxing.common.BitArray bitArray2, com.google.zxing.qrcode.decoder.Version version) {
        return bitArray.getSize() + mode.getCharacterCountBits(version) + bitArray2.getSize();
    }

    private static int calculateMaskPenalty(com.google.zxing.qrcode.encoder.ByteMatrix byteMatrix) {
        return com.google.zxing.qrcode.encoder.MaskUtil.applyMaskPenaltyRule1(byteMatrix) + com.google.zxing.qrcode.encoder.MaskUtil.applyMaskPenaltyRule2(byteMatrix) + com.google.zxing.qrcode.encoder.MaskUtil.applyMaskPenaltyRule3(byteMatrix) + com.google.zxing.qrcode.encoder.MaskUtil.applyMaskPenaltyRule4(byteMatrix);
    }

    private static int chooseMaskPattern(com.google.zxing.common.BitArray bitArray, com.google.zxing.qrcode.decoder.ErrorCorrectionLevel errorCorrectionLevel, com.google.zxing.qrcode.decoder.Version version, com.google.zxing.qrcode.encoder.ByteMatrix byteMatrix) throws com.google.zxing.WriterException {
        int i = Integer.MAX_VALUE;
        int i2 = -1;
        for (int i3 = 0; i3 < 8; i3++) {
            com.google.zxing.qrcode.encoder.MatrixUtil.buildMatrix(bitArray, errorCorrectionLevel, version, i3, byteMatrix);
            int calculateMaskPenalty = calculateMaskPenalty(byteMatrix);
            if (calculateMaskPenalty < i) {
                i2 = i3;
                i = calculateMaskPenalty;
            }
        }
        return i2;
    }

    public static com.google.zxing.qrcode.decoder.Mode chooseMode(java.lang.String str) {
        return chooseMode(str, null);
    }

    private static com.google.zxing.qrcode.decoder.Mode chooseMode(java.lang.String str, java.lang.String str2) {
        if ("Shift_JIS".equals(str2) && isOnlyDoubleByteKanji(str)) {
            return com.google.zxing.qrcode.decoder.Mode.KANJI;
        }
        boolean z = false;
        boolean z2 = false;
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if (charAt >= '0' && charAt <= '9') {
                z2 = true;
            } else {
                if (getAlphanumericCode(charAt) == -1) {
                    return com.google.zxing.qrcode.decoder.Mode.BYTE;
                }
                z = true;
            }
        }
        return z ? com.google.zxing.qrcode.decoder.Mode.ALPHANUMERIC : z2 ? com.google.zxing.qrcode.decoder.Mode.NUMERIC : com.google.zxing.qrcode.decoder.Mode.BYTE;
    }

    private static com.google.zxing.qrcode.decoder.Version chooseVersion(int i, com.google.zxing.qrcode.decoder.ErrorCorrectionLevel errorCorrectionLevel) throws com.google.zxing.WriterException {
        for (int i2 = 1; i2 <= 40; i2++) {
            com.google.zxing.qrcode.decoder.Version versionForNumber = com.google.zxing.qrcode.decoder.Version.getVersionForNumber(i2);
            if (willFit(i, versionForNumber, errorCorrectionLevel)) {
                return versionForNumber;
            }
        }
        throw new com.google.zxing.WriterException("Data too big");
    }

    public static com.google.zxing.qrcode.encoder.QRCode encode(java.lang.String str, com.google.zxing.qrcode.decoder.ErrorCorrectionLevel errorCorrectionLevel) throws com.google.zxing.WriterException {
        return encode(str, errorCorrectionLevel, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x007f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static com.google.zxing.qrcode.encoder.QRCode encode(java.lang.String str, com.google.zxing.qrcode.decoder.ErrorCorrectionLevel errorCorrectionLevel, java.util.Map<com.google.zxing.EncodeHintType, ?> map) throws com.google.zxing.WriterException {
        com.google.zxing.qrcode.decoder.Version recommendVersion;
        com.google.zxing.common.CharacterSetECI characterSetECIByName;
        boolean z = map != null && map.containsKey(com.google.zxing.EncodeHintType.CHARACTER_SET);
        java.lang.String obj = z ? map.get(com.google.zxing.EncodeHintType.CHARACTER_SET).toString() : "ISO-8859-1";
        com.google.zxing.qrcode.decoder.Mode chooseMode = chooseMode(str, obj);
        com.google.zxing.common.BitArray bitArray = new com.google.zxing.common.BitArray();
        com.google.zxing.qrcode.decoder.Mode mode = com.google.zxing.qrcode.decoder.Mode.BYTE;
        if (chooseMode == mode && z && (characterSetECIByName = com.google.zxing.common.CharacterSetECI.getCharacterSetECIByName(obj)) != null) {
            appendECI(characterSetECIByName, bitArray);
        }
        appendModeInfo(chooseMode, bitArray);
        com.google.zxing.common.BitArray bitArray2 = new com.google.zxing.common.BitArray();
        appendBytes(str, chooseMode, bitArray2, obj);
        if (map != null) {
            com.google.zxing.EncodeHintType encodeHintType = com.google.zxing.EncodeHintType.QR_VERSION;
            if (map.containsKey(encodeHintType)) {
                recommendVersion = com.google.zxing.qrcode.decoder.Version.getVersionForNumber(java.lang.Integer.parseInt(map.get(encodeHintType).toString()));
                if (!willFit(calculateBitsNeeded(chooseMode, bitArray, bitArray2, recommendVersion), recommendVersion, errorCorrectionLevel)) {
                    throw new com.google.zxing.WriterException("Data too big for requested version");
                }
                com.google.zxing.common.BitArray bitArray3 = new com.google.zxing.common.BitArray();
                bitArray3.appendBitArray(bitArray);
                appendLengthInfo(chooseMode != mode ? bitArray2.getSizeInBytes() : str.length(), recommendVersion, chooseMode, bitArray3);
                bitArray3.appendBitArray(bitArray2);
                com.google.zxing.qrcode.decoder.Version.ECBlocks eCBlocksForLevel = recommendVersion.getECBlocksForLevel(errorCorrectionLevel);
                int totalCodewords = recommendVersion.getTotalCodewords() - eCBlocksForLevel.getTotalECCodewords();
                terminateBits(totalCodewords, bitArray3);
                com.google.zxing.common.BitArray interleaveWithECBytes = interleaveWithECBytes(bitArray3, recommendVersion.getTotalCodewords(), totalCodewords, eCBlocksForLevel.getNumBlocks());
                com.google.zxing.qrcode.encoder.QRCode qRCode = new com.google.zxing.qrcode.encoder.QRCode();
                qRCode.setECLevel(errorCorrectionLevel);
                qRCode.setMode(chooseMode);
                qRCode.setVersion(recommendVersion);
                int dimensionForVersion = recommendVersion.getDimensionForVersion();
                com.google.zxing.qrcode.encoder.ByteMatrix byteMatrix = new com.google.zxing.qrcode.encoder.ByteMatrix(dimensionForVersion, dimensionForVersion);
                int chooseMaskPattern = chooseMaskPattern(interleaveWithECBytes, errorCorrectionLevel, recommendVersion, byteMatrix);
                qRCode.setMaskPattern(chooseMaskPattern);
                com.google.zxing.qrcode.encoder.MatrixUtil.buildMatrix(interleaveWithECBytes, errorCorrectionLevel, recommendVersion, chooseMaskPattern, byteMatrix);
                qRCode.setMatrix(byteMatrix);
                return qRCode;
            }
        }
        recommendVersion = recommendVersion(errorCorrectionLevel, chooseMode, bitArray, bitArray2);
        com.google.zxing.common.BitArray bitArray32 = new com.google.zxing.common.BitArray();
        bitArray32.appendBitArray(bitArray);
        appendLengthInfo(chooseMode != mode ? bitArray2.getSizeInBytes() : str.length(), recommendVersion, chooseMode, bitArray32);
        bitArray32.appendBitArray(bitArray2);
        com.google.zxing.qrcode.decoder.Version.ECBlocks eCBlocksForLevel2 = recommendVersion.getECBlocksForLevel(errorCorrectionLevel);
        int totalCodewords2 = recommendVersion.getTotalCodewords() - eCBlocksForLevel2.getTotalECCodewords();
        terminateBits(totalCodewords2, bitArray32);
        com.google.zxing.common.BitArray interleaveWithECBytes2 = interleaveWithECBytes(bitArray32, recommendVersion.getTotalCodewords(), totalCodewords2, eCBlocksForLevel2.getNumBlocks());
        com.google.zxing.qrcode.encoder.QRCode qRCode2 = new com.google.zxing.qrcode.encoder.QRCode();
        qRCode2.setECLevel(errorCorrectionLevel);
        qRCode2.setMode(chooseMode);
        qRCode2.setVersion(recommendVersion);
        int dimensionForVersion2 = recommendVersion.getDimensionForVersion();
        com.google.zxing.qrcode.encoder.ByteMatrix byteMatrix2 = new com.google.zxing.qrcode.encoder.ByteMatrix(dimensionForVersion2, dimensionForVersion2);
        int chooseMaskPattern2 = chooseMaskPattern(interleaveWithECBytes2, errorCorrectionLevel, recommendVersion, byteMatrix2);
        qRCode2.setMaskPattern(chooseMaskPattern2);
        com.google.zxing.qrcode.encoder.MatrixUtil.buildMatrix(interleaveWithECBytes2, errorCorrectionLevel, recommendVersion, chooseMaskPattern2, byteMatrix2);
        qRCode2.setMatrix(byteMatrix2);
        return qRCode2;
    }

    public static byte[] generateECBytes(byte[] bArr, int i) {
        int length = bArr.length;
        int[] iArr = new int[length + i];
        for (int i2 = 0; i2 < length; i2++) {
            iArr[i2] = bArr[i2] & 255;
        }
        new com.google.zxing.common.reedsolomon.ReedSolomonEncoder(com.google.zxing.common.reedsolomon.GenericGF.QR_CODE_FIELD_256).encode(iArr, i);
        byte[] bArr2 = new byte[i];
        for (int i3 = 0; i3 < i; i3++) {
            bArr2[i3] = (byte) iArr[length + i3];
        }
        return bArr2;
    }

    public static int getAlphanumericCode(int i) {
        int[] iArr = ALPHANUMERIC_TABLE;
        if (i < iArr.length) {
            return iArr[i];
        }
        return -1;
    }

    public static void getNumDataBytesAndNumECBytesForBlockID(int i, int i2, int i3, int i4, int[] iArr, int[] iArr2) throws com.google.zxing.WriterException {
        if (i4 >= i3) {
            throw new com.google.zxing.WriterException("Block ID too large");
        }
        int i5 = i % i3;
        int i6 = i3 - i5;
        int i7 = i / i3;
        int i8 = i7 + 1;
        int i9 = i2 / i3;
        int i10 = i9 + 1;
        int i11 = i7 - i9;
        int i12 = i8 - i10;
        if (i11 != i12) {
            throw new com.google.zxing.WriterException("EC bytes mismatch");
        }
        if (i3 != i6 + i5) {
            throw new com.google.zxing.WriterException("RS blocks mismatch");
        }
        if (i != ((i9 + i11) * i6) + ((i10 + i12) * i5)) {
            throw new com.google.zxing.WriterException("Total bytes mismatch");
        }
        if (i4 < i6) {
            iArr[0] = i9;
            iArr2[0] = i11;
        } else {
            iArr[0] = i10;
            iArr2[0] = i12;
        }
    }

    public static com.google.zxing.common.BitArray interleaveWithECBytes(com.google.zxing.common.BitArray bitArray, int i, int i2, int i3) throws com.google.zxing.WriterException {
        if (bitArray.getSizeInBytes() != i2) {
            throw new com.google.zxing.WriterException("Number of bits and data bytes does not match");
        }
        java.util.ArrayList arrayList = new java.util.ArrayList(i3);
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        for (int i7 = 0; i7 < i3; i7++) {
            int[] iArr = new int[1];
            int[] iArr2 = new int[1];
            getNumDataBytesAndNumECBytesForBlockID(i, i2, i3, i7, iArr, iArr2);
            int i8 = iArr[0];
            byte[] bArr = new byte[i8];
            bitArray.toBytes(i4 * 8, bArr, 0, i8);
            byte[] generateECBytes = generateECBytes(bArr, iArr2[0]);
            arrayList.add(new com.google.zxing.qrcode.encoder.BlockPair(bArr, generateECBytes));
            i5 = java.lang.Math.max(i5, i8);
            i6 = java.lang.Math.max(i6, generateECBytes.length);
            i4 += iArr[0];
        }
        if (i2 != i4) {
            throw new com.google.zxing.WriterException("Data bytes does not match offset");
        }
        com.google.zxing.common.BitArray bitArray2 = new com.google.zxing.common.BitArray();
        for (int i9 = 0; i9 < i5; i9++) {
            java.util.Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                byte[] dataBytes = ((com.google.zxing.qrcode.encoder.BlockPair) it.next()).getDataBytes();
                if (i9 < dataBytes.length) {
                    bitArray2.appendBits(dataBytes[i9], 8);
                }
            }
        }
        for (int i10 = 0; i10 < i6; i10++) {
            java.util.Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                byte[] errorCorrectionBytes = ((com.google.zxing.qrcode.encoder.BlockPair) it2.next()).getErrorCorrectionBytes();
                if (i10 < errorCorrectionBytes.length) {
                    bitArray2.appendBits(errorCorrectionBytes[i10], 8);
                }
            }
        }
        if (i == bitArray2.getSizeInBytes()) {
            return bitArray2;
        }
        throw new com.google.zxing.WriterException("Interleaving error: " + i + " and " + bitArray2.getSizeInBytes() + " differ.");
    }

    private static boolean isOnlyDoubleByteKanji(java.lang.String str) {
        try {
            byte[] bytes = str.getBytes("Shift_JIS");
            int length = bytes.length;
            if (length % 2 != 0) {
                return false;
            }
            for (int i = 0; i < length; i += 2) {
                int i2 = bytes[i] & 255;
                if ((i2 < 129 || i2 > 159) && (i2 < 224 || i2 > 235)) {
                    return false;
                }
            }
            return true;
        } catch (java.io.UnsupportedEncodingException unused) {
            return false;
        }
    }

    private static com.google.zxing.qrcode.decoder.Version recommendVersion(com.google.zxing.qrcode.decoder.ErrorCorrectionLevel errorCorrectionLevel, com.google.zxing.qrcode.decoder.Mode mode, com.google.zxing.common.BitArray bitArray, com.google.zxing.common.BitArray bitArray2) throws com.google.zxing.WriterException {
        return chooseVersion(calculateBitsNeeded(mode, bitArray, bitArray2, chooseVersion(calculateBitsNeeded(mode, bitArray, bitArray2, com.google.zxing.qrcode.decoder.Version.getVersionForNumber(1)), errorCorrectionLevel)), errorCorrectionLevel);
    }

    public static void terminateBits(int i, com.google.zxing.common.BitArray bitArray) throws com.google.zxing.WriterException {
        int i2 = i * 8;
        if (bitArray.getSize() > i2) {
            throw new com.google.zxing.WriterException("data bits cannot fit in the QR Code" + bitArray.getSize() + " > " + i2);
        }
        for (int i3 = 0; i3 < 4 && bitArray.getSize() < i2; i3++) {
            bitArray.appendBit(false);
        }
        int size = bitArray.getSize() & 7;
        if (size > 0) {
            while (size < 8) {
                bitArray.appendBit(false);
                size++;
            }
        }
        int sizeInBytes = i - bitArray.getSizeInBytes();
        for (int i4 = 0; i4 < sizeInBytes; i4++) {
            bitArray.appendBits((i4 & 1) == 0 ? 236 : 17, 8);
        }
        if (bitArray.getSize() != i2) {
            throw new com.google.zxing.WriterException("Bits size does not equal capacity");
        }
    }

    private static boolean willFit(int i, com.google.zxing.qrcode.decoder.Version version, com.google.zxing.qrcode.decoder.ErrorCorrectionLevel errorCorrectionLevel) {
        return version.getTotalCodewords() - version.getECBlocksForLevel(errorCorrectionLevel).getTotalECCodewords() >= (i + 7) / 8;
    }
}
