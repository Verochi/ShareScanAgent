package com.google.android.exoplayer2.extractor;

/* loaded from: classes22.dex */
public final class FlacMetadataReader {

    public static final class FlacStreamMetadataHolder {

        @androidx.annotation.Nullable
        public com.google.android.exoplayer2.extractor.FlacStreamMetadata flacStreamMetadata;

        public FlacStreamMetadataHolder(@androidx.annotation.Nullable com.google.android.exoplayer2.extractor.FlacStreamMetadata flacStreamMetadata) {
            this.flacStreamMetadata = flacStreamMetadata;
        }
    }

    public static com.google.android.exoplayer2.metadata.flac.PictureFrame a(com.google.android.exoplayer2.extractor.ExtractorInput extractorInput, int i) throws java.io.IOException {
        com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray = new com.google.android.exoplayer2.util.ParsableByteArray(i);
        extractorInput.readFully(parsableByteArray.getData(), 0, i);
        parsableByteArray.skipBytes(4);
        int readInt = parsableByteArray.readInt();
        java.lang.String readString = parsableByteArray.readString(parsableByteArray.readInt(), com.google.common.base.Charsets.US_ASCII);
        java.lang.String readString2 = parsableByteArray.readString(parsableByteArray.readInt());
        int readInt2 = parsableByteArray.readInt();
        int readInt3 = parsableByteArray.readInt();
        int readInt4 = parsableByteArray.readInt();
        int readInt5 = parsableByteArray.readInt();
        int readInt6 = parsableByteArray.readInt();
        byte[] bArr = new byte[readInt6];
        parsableByteArray.readBytes(bArr, 0, readInt6);
        return new com.google.android.exoplayer2.metadata.flac.PictureFrame(readInt, readString, readString2, readInt2, readInt3, readInt4, readInt5, bArr);
    }

    public static com.google.android.exoplayer2.extractor.FlacStreamMetadata.SeekTable b(com.google.android.exoplayer2.extractor.ExtractorInput extractorInput, int i) throws java.io.IOException {
        com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray = new com.google.android.exoplayer2.util.ParsableByteArray(i);
        extractorInput.readFully(parsableByteArray.getData(), 0, i);
        return readSeekTableMetadataBlock(parsableByteArray);
    }

    public static com.google.android.exoplayer2.extractor.FlacStreamMetadata c(com.google.android.exoplayer2.extractor.ExtractorInput extractorInput) throws java.io.IOException {
        byte[] bArr = new byte[38];
        extractorInput.readFully(bArr, 0, 38);
        return new com.google.android.exoplayer2.extractor.FlacStreamMetadata(bArr, 4);
    }

    public static boolean checkAndPeekStreamMarker(com.google.android.exoplayer2.extractor.ExtractorInput extractorInput) throws java.io.IOException {
        com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray = new com.google.android.exoplayer2.util.ParsableByteArray(4);
        extractorInput.peekFully(parsableByteArray.getData(), 0, 4);
        return parsableByteArray.readUnsignedInt() == 1716281667;
    }

    public static java.util.List<java.lang.String> d(com.google.android.exoplayer2.extractor.ExtractorInput extractorInput, int i) throws java.io.IOException {
        com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray = new com.google.android.exoplayer2.util.ParsableByteArray(i);
        extractorInput.readFully(parsableByteArray.getData(), 0, i);
        parsableByteArray.skipBytes(4);
        return java.util.Arrays.asList(com.google.android.exoplayer2.extractor.VorbisUtil.readVorbisCommentHeader(parsableByteArray, false, false).comments);
    }

    public static int getFrameStartMarker(com.google.android.exoplayer2.extractor.ExtractorInput extractorInput) throws java.io.IOException {
        extractorInput.resetPeekPosition();
        com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray = new com.google.android.exoplayer2.util.ParsableByteArray(2);
        extractorInput.peekFully(parsableByteArray.getData(), 0, 2);
        int readUnsignedShort = parsableByteArray.readUnsignedShort();
        if ((readUnsignedShort >> 2) == 16382) {
            extractorInput.resetPeekPosition();
            return readUnsignedShort;
        }
        extractorInput.resetPeekPosition();
        throw new com.google.android.exoplayer2.ParserException("First frame does not start with sync code.");
    }

    @androidx.annotation.Nullable
    public static com.google.android.exoplayer2.metadata.Metadata peekId3Metadata(com.google.android.exoplayer2.extractor.ExtractorInput extractorInput, boolean z) throws java.io.IOException {
        com.google.android.exoplayer2.metadata.Metadata peekId3Data = new com.google.android.exoplayer2.extractor.Id3Peeker().peekId3Data(extractorInput, z ? null : com.google.android.exoplayer2.metadata.id3.Id3Decoder.NO_FRAMES_PREDICATE);
        if (peekId3Data == null || peekId3Data.length() == 0) {
            return null;
        }
        return peekId3Data;
    }

    @androidx.annotation.Nullable
    public static com.google.android.exoplayer2.metadata.Metadata readId3Metadata(com.google.android.exoplayer2.extractor.ExtractorInput extractorInput, boolean z) throws java.io.IOException {
        extractorInput.resetPeekPosition();
        long peekPosition = extractorInput.getPeekPosition();
        com.google.android.exoplayer2.metadata.Metadata peekId3Metadata = peekId3Metadata(extractorInput, z);
        extractorInput.skipFully((int) (extractorInput.getPeekPosition() - peekPosition));
        return peekId3Metadata;
    }

    public static boolean readMetadataBlock(com.google.android.exoplayer2.extractor.ExtractorInput extractorInput, com.google.android.exoplayer2.extractor.FlacMetadataReader.FlacStreamMetadataHolder flacStreamMetadataHolder) throws java.io.IOException {
        extractorInput.resetPeekPosition();
        com.google.android.exoplayer2.util.ParsableBitArray parsableBitArray = new com.google.android.exoplayer2.util.ParsableBitArray(new byte[4]);
        extractorInput.peekFully(parsableBitArray.data, 0, 4);
        boolean readBit = parsableBitArray.readBit();
        int readBits = parsableBitArray.readBits(7);
        int readBits2 = parsableBitArray.readBits(24) + 4;
        if (readBits == 0) {
            flacStreamMetadataHolder.flacStreamMetadata = c(extractorInput);
        } else {
            com.google.android.exoplayer2.extractor.FlacStreamMetadata flacStreamMetadata = flacStreamMetadataHolder.flacStreamMetadata;
            if (flacStreamMetadata == null) {
                throw new java.lang.IllegalArgumentException();
            }
            if (readBits == 3) {
                flacStreamMetadataHolder.flacStreamMetadata = flacStreamMetadata.copyWithSeekTable(b(extractorInput, readBits2));
            } else if (readBits == 4) {
                flacStreamMetadataHolder.flacStreamMetadata = flacStreamMetadata.copyWithVorbisComments(d(extractorInput, readBits2));
            } else if (readBits == 6) {
                flacStreamMetadataHolder.flacStreamMetadata = flacStreamMetadata.copyWithPictureFrames(java.util.Collections.singletonList(a(extractorInput, readBits2)));
            } else {
                extractorInput.skipFully(readBits2);
            }
        }
        return readBit;
    }

    public static com.google.android.exoplayer2.extractor.FlacStreamMetadata.SeekTable readSeekTableMetadataBlock(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray) {
        parsableByteArray.skipBytes(1);
        int readUnsignedInt24 = parsableByteArray.readUnsignedInt24();
        long position = parsableByteArray.getPosition() + readUnsignedInt24;
        int i = readUnsignedInt24 / 18;
        long[] jArr = new long[i];
        long[] jArr2 = new long[i];
        int i2 = 0;
        while (true) {
            if (i2 >= i) {
                break;
            }
            long readLong = parsableByteArray.readLong();
            if (readLong == -1) {
                jArr = java.util.Arrays.copyOf(jArr, i2);
                jArr2 = java.util.Arrays.copyOf(jArr2, i2);
                break;
            }
            jArr[i2] = readLong;
            jArr2[i2] = parsableByteArray.readLong();
            parsableByteArray.skipBytes(2);
            i2++;
        }
        parsableByteArray.skipBytes((int) (position - parsableByteArray.getPosition()));
        return new com.google.android.exoplayer2.extractor.FlacStreamMetadata.SeekTable(jArr, jArr2);
    }

    public static void readStreamMarker(com.google.android.exoplayer2.extractor.ExtractorInput extractorInput) throws java.io.IOException {
        com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray = new com.google.android.exoplayer2.util.ParsableByteArray(4);
        extractorInput.readFully(parsableByteArray.getData(), 0, 4);
        if (parsableByteArray.readUnsignedInt() != 1716281667) {
            throw new com.google.android.exoplayer2.ParserException("Failed to read FLAC stream marker.");
        }
    }
}
