package com.google.android.exoplayer2.extractor.wav;

/* loaded from: classes22.dex */
final class WavHeaderReader {

    public static final class ChunkHeader {
        public final int a;
        public final long b;

        public ChunkHeader(int i, long j) {
            this.a = i;
            this.b = j;
        }

        public static com.google.android.exoplayer2.extractor.wav.WavHeaderReader.ChunkHeader a(com.google.android.exoplayer2.extractor.ExtractorInput extractorInput, com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray) throws java.io.IOException {
            extractorInput.peekFully(parsableByteArray.getData(), 0, 8);
            parsableByteArray.setPosition(0);
            return new com.google.android.exoplayer2.extractor.wav.WavHeaderReader.ChunkHeader(parsableByteArray.readInt(), parsableByteArray.readLittleEndianUnsignedInt());
        }
    }

    @androidx.annotation.Nullable
    public static com.google.android.exoplayer2.extractor.wav.WavHeader a(com.google.android.exoplayer2.extractor.ExtractorInput extractorInput) throws java.io.IOException {
        byte[] bArr;
        com.google.android.exoplayer2.util.Assertions.checkNotNull(extractorInput);
        com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray = new com.google.android.exoplayer2.util.ParsableByteArray(16);
        if (com.google.android.exoplayer2.extractor.wav.WavHeaderReader.ChunkHeader.a(extractorInput, parsableByteArray).a != 1380533830) {
            return null;
        }
        extractorInput.peekFully(parsableByteArray.getData(), 0, 4);
        parsableByteArray.setPosition(0);
        int readInt = parsableByteArray.readInt();
        if (readInt != 1463899717) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder(36);
            sb.append("Unsupported RIFF format: ");
            sb.append(readInt);
            com.google.android.exoplayer2.util.Log.e("WavHeaderReader", sb.toString());
            return null;
        }
        com.google.android.exoplayer2.extractor.wav.WavHeaderReader.ChunkHeader a = com.google.android.exoplayer2.extractor.wav.WavHeaderReader.ChunkHeader.a(extractorInput, parsableByteArray);
        while (a.a != 1718449184) {
            extractorInput.advancePeekPosition((int) a.b);
            a = com.google.android.exoplayer2.extractor.wav.WavHeaderReader.ChunkHeader.a(extractorInput, parsableByteArray);
        }
        com.google.android.exoplayer2.util.Assertions.checkState(a.b >= 16);
        extractorInput.peekFully(parsableByteArray.getData(), 0, 16);
        parsableByteArray.setPosition(0);
        int readLittleEndianUnsignedShort = parsableByteArray.readLittleEndianUnsignedShort();
        int readLittleEndianUnsignedShort2 = parsableByteArray.readLittleEndianUnsignedShort();
        int readLittleEndianUnsignedIntToInt = parsableByteArray.readLittleEndianUnsignedIntToInt();
        int readLittleEndianUnsignedIntToInt2 = parsableByteArray.readLittleEndianUnsignedIntToInt();
        int readLittleEndianUnsignedShort3 = parsableByteArray.readLittleEndianUnsignedShort();
        int readLittleEndianUnsignedShort4 = parsableByteArray.readLittleEndianUnsignedShort();
        int i = ((int) a.b) - 16;
        if (i > 0) {
            byte[] bArr2 = new byte[i];
            extractorInput.peekFully(bArr2, 0, i);
            bArr = bArr2;
        } else {
            bArr = com.google.android.exoplayer2.util.Util.EMPTY_BYTE_ARRAY;
        }
        return new com.google.android.exoplayer2.extractor.wav.WavHeader(readLittleEndianUnsignedShort, readLittleEndianUnsignedShort2, readLittleEndianUnsignedIntToInt, readLittleEndianUnsignedIntToInt2, readLittleEndianUnsignedShort3, readLittleEndianUnsignedShort4, bArr);
    }

    public static android.util.Pair<java.lang.Long, java.lang.Long> b(com.google.android.exoplayer2.extractor.ExtractorInput extractorInput) throws java.io.IOException {
        com.google.android.exoplayer2.util.Assertions.checkNotNull(extractorInput);
        extractorInput.resetPeekPosition();
        com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray = new com.google.android.exoplayer2.util.ParsableByteArray(8);
        com.google.android.exoplayer2.extractor.wav.WavHeaderReader.ChunkHeader a = com.google.android.exoplayer2.extractor.wav.WavHeaderReader.ChunkHeader.a(extractorInput, parsableByteArray);
        while (true) {
            int i = a.a;
            if (i == 1684108385) {
                extractorInput.skipFully(8);
                long position = extractorInput.getPosition();
                long j = a.b + position;
                long length = extractorInput.getLength();
                if (length != -1 && j > length) {
                    java.lang.StringBuilder sb = new java.lang.StringBuilder(69);
                    sb.append("Data exceeds input length: ");
                    sb.append(j);
                    sb.append(", ");
                    sb.append(length);
                    com.google.android.exoplayer2.util.Log.w("WavHeaderReader", sb.toString());
                    j = length;
                }
                return android.util.Pair.create(java.lang.Long.valueOf(position), java.lang.Long.valueOf(j));
            }
            if (i != 1380533830 && i != 1718449184) {
                java.lang.StringBuilder sb2 = new java.lang.StringBuilder(39);
                sb2.append("Ignoring unknown WAV chunk: ");
                sb2.append(i);
                com.google.android.exoplayer2.util.Log.w("WavHeaderReader", sb2.toString());
            }
            long j2 = a.b + 8;
            if (a.a == 1380533830) {
                j2 = 12;
            }
            if (j2 > 2147483647L) {
                int i2 = a.a;
                java.lang.StringBuilder sb3 = new java.lang.StringBuilder(51);
                sb3.append("Chunk is too large (~2GB+) to skip; id: ");
                sb3.append(i2);
                throw new com.google.android.exoplayer2.ParserException(sb3.toString());
            }
            extractorInput.skipFully((int) j2);
            a = com.google.android.exoplayer2.extractor.wav.WavHeaderReader.ChunkHeader.a(extractorInput, parsableByteArray);
        }
    }
}
