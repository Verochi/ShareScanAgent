package com.google.android.exoplayer2.extractor;

/* loaded from: classes22.dex */
public final class FlacFrameReader {

    public static final class SampleNumberHolder {
        public long sampleNumber;
    }

    public static boolean a(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray, com.google.android.exoplayer2.extractor.FlacStreamMetadata flacStreamMetadata, int i) {
        int readFrameBlockSizeSamplesFromKey = readFrameBlockSizeSamplesFromKey(parsableByteArray, i);
        return readFrameBlockSizeSamplesFromKey != -1 && readFrameBlockSizeSamplesFromKey <= flacStreamMetadata.maxBlockSizeSamples;
    }

    public static boolean b(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray, int i) {
        return parsableByteArray.readUnsignedByte() == com.google.android.exoplayer2.util.Util.crc8(parsableByteArray.getData(), i, parsableByteArray.getPosition() - 1, 0);
    }

    public static boolean c(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray, com.google.android.exoplayer2.extractor.FlacStreamMetadata flacStreamMetadata, boolean z, com.google.android.exoplayer2.extractor.FlacFrameReader.SampleNumberHolder sampleNumberHolder) {
        try {
            long readUtf8EncodedLong = parsableByteArray.readUtf8EncodedLong();
            if (!z) {
                readUtf8EncodedLong *= flacStreamMetadata.maxBlockSizeSamples;
            }
            sampleNumberHolder.sampleNumber = readUtf8EncodedLong;
            return true;
        } catch (java.lang.NumberFormatException unused) {
            return false;
        }
    }

    public static boolean checkAndReadFrameHeader(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray, com.google.android.exoplayer2.extractor.FlacStreamMetadata flacStreamMetadata, int i, com.google.android.exoplayer2.extractor.FlacFrameReader.SampleNumberHolder sampleNumberHolder) {
        int position = parsableByteArray.getPosition();
        long readUnsignedInt = parsableByteArray.readUnsignedInt();
        long j = readUnsignedInt >>> 16;
        if (j != i) {
            return false;
        }
        return f((int) (15 & (readUnsignedInt >> 4)), flacStreamMetadata) && e((int) ((readUnsignedInt >> 1) & 7), flacStreamMetadata) && !(((readUnsignedInt & 1) > 1L ? 1 : ((readUnsignedInt & 1) == 1L ? 0 : -1)) == 0) && c(parsableByteArray, flacStreamMetadata, ((j & 1) > 1L ? 1 : ((j & 1) == 1L ? 0 : -1)) == 0, sampleNumberHolder) && a(parsableByteArray, flacStreamMetadata, (int) ((readUnsignedInt >> 12) & 15)) && d(parsableByteArray, flacStreamMetadata, (int) ((readUnsignedInt >> 8) & 15)) && b(parsableByteArray, position);
    }

    public static boolean checkFrameHeaderFromPeek(com.google.android.exoplayer2.extractor.ExtractorInput extractorInput, com.google.android.exoplayer2.extractor.FlacStreamMetadata flacStreamMetadata, int i, com.google.android.exoplayer2.extractor.FlacFrameReader.SampleNumberHolder sampleNumberHolder) throws java.io.IOException {
        long peekPosition = extractorInput.getPeekPosition();
        byte[] bArr = new byte[2];
        extractorInput.peekFully(bArr, 0, 2);
        if ((((bArr[0] & 255) << 8) | (bArr[1] & 255)) != i) {
            extractorInput.resetPeekPosition();
            extractorInput.advancePeekPosition((int) (peekPosition - extractorInput.getPosition()));
            return false;
        }
        com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray = new com.google.android.exoplayer2.util.ParsableByteArray(16);
        java.lang.System.arraycopy(bArr, 0, parsableByteArray.getData(), 0, 2);
        parsableByteArray.setLimit(com.google.android.exoplayer2.extractor.ExtractorUtil.a(extractorInput, parsableByteArray.getData(), 2, 14));
        extractorInput.resetPeekPosition();
        extractorInput.advancePeekPosition((int) (peekPosition - extractorInput.getPosition()));
        return checkAndReadFrameHeader(parsableByteArray, flacStreamMetadata, i, sampleNumberHolder);
    }

    public static boolean d(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray, com.google.android.exoplayer2.extractor.FlacStreamMetadata flacStreamMetadata, int i) {
        int i2 = flacStreamMetadata.sampleRate;
        if (i == 0) {
            return true;
        }
        if (i <= 11) {
            return i == flacStreamMetadata.sampleRateLookupKey;
        }
        if (i == 12) {
            return parsableByteArray.readUnsignedByte() * 1000 == i2;
        }
        if (i > 14) {
            return false;
        }
        int readUnsignedShort = parsableByteArray.readUnsignedShort();
        if (i == 14) {
            readUnsignedShort *= 10;
        }
        return readUnsignedShort == i2;
    }

    public static boolean e(int i, com.google.android.exoplayer2.extractor.FlacStreamMetadata flacStreamMetadata) {
        return i == 0 || i == flacStreamMetadata.bitsPerSampleLookupKey;
    }

    public static boolean f(int i, com.google.android.exoplayer2.extractor.FlacStreamMetadata flacStreamMetadata) {
        return i <= 7 ? i == flacStreamMetadata.channels - 1 : i <= 10 && flacStreamMetadata.channels == 2;
    }

    public static long getFirstSampleNumber(com.google.android.exoplayer2.extractor.ExtractorInput extractorInput, com.google.android.exoplayer2.extractor.FlacStreamMetadata flacStreamMetadata) throws java.io.IOException {
        extractorInput.resetPeekPosition();
        extractorInput.advancePeekPosition(1);
        byte[] bArr = new byte[1];
        extractorInput.peekFully(bArr, 0, 1);
        boolean z = (bArr[0] & 1) == 1;
        extractorInput.advancePeekPosition(2);
        int i = z ? 7 : 6;
        com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray = new com.google.android.exoplayer2.util.ParsableByteArray(i);
        parsableByteArray.setLimit(com.google.android.exoplayer2.extractor.ExtractorUtil.a(extractorInput, parsableByteArray.getData(), 0, i));
        extractorInput.resetPeekPosition();
        com.google.android.exoplayer2.extractor.FlacFrameReader.SampleNumberHolder sampleNumberHolder = new com.google.android.exoplayer2.extractor.FlacFrameReader.SampleNumberHolder();
        if (c(parsableByteArray, flacStreamMetadata, z, sampleNumberHolder)) {
            return sampleNumberHolder.sampleNumber;
        }
        throw new com.google.android.exoplayer2.ParserException();
    }

    public static int readFrameBlockSizeSamplesFromKey(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray, int i) {
        switch (i) {
            case 1:
                return 192;
            case 2:
            case 3:
            case 4:
            case 5:
                return 576 << (i - 2);
            case 6:
                return parsableByteArray.readUnsignedByte() + 1;
            case 7:
                return parsableByteArray.readUnsignedShort() + 1;
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
                return 256 << (i - 8);
            default:
                return -1;
        }
    }
}
