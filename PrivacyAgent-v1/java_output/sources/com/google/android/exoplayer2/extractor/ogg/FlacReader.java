package com.google.android.exoplayer2.extractor.ogg;

/* loaded from: classes22.dex */
final class FlacReader extends com.google.android.exoplayer2.extractor.ogg.StreamReader {

    @androidx.annotation.Nullable
    public com.google.android.exoplayer2.extractor.FlacStreamMetadata n;

    @androidx.annotation.Nullable
    public com.google.android.exoplayer2.extractor.ogg.FlacReader.FlacOggSeeker o;

    public static final class FlacOggSeeker implements com.google.android.exoplayer2.extractor.ogg.OggSeeker {
        public com.google.android.exoplayer2.extractor.FlacStreamMetadata a;
        public com.google.android.exoplayer2.extractor.FlacStreamMetadata.SeekTable b;
        public long c = -1;
        public long d = -1;

        public FlacOggSeeker(com.google.android.exoplayer2.extractor.FlacStreamMetadata flacStreamMetadata, com.google.android.exoplayer2.extractor.FlacStreamMetadata.SeekTable seekTable) {
            this.a = flacStreamMetadata;
            this.b = seekTable;
        }

        @Override // com.google.android.exoplayer2.extractor.ogg.OggSeeker
        public com.google.android.exoplayer2.extractor.SeekMap a() {
            com.google.android.exoplayer2.util.Assertions.checkState(this.c != -1);
            return new com.google.android.exoplayer2.extractor.FlacSeekTableSeekMap(this.a, this.c);
        }

        @Override // com.google.android.exoplayer2.extractor.ogg.OggSeeker
        public void b(long j) {
            long[] jArr = this.b.pointSampleNumbers;
            this.d = jArr[com.google.android.exoplayer2.util.Util.binarySearchFloor(jArr, j, true, true)];
        }

        public void c(long j) {
            this.c = j;
        }

        @Override // com.google.android.exoplayer2.extractor.ogg.OggSeeker
        public long read(com.google.android.exoplayer2.extractor.ExtractorInput extractorInput) {
            long j = this.d;
            if (j < 0) {
                return -1L;
            }
            long j2 = -(j + 2);
            this.d = -1L;
            return j2;
        }
    }

    public static boolean m(byte[] bArr) {
        return bArr[0] == -1;
    }

    public static boolean n(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray) {
        return parsableByteArray.bytesLeft() >= 5 && parsableByteArray.readUnsignedByte() == 127 && parsableByteArray.readUnsignedInt() == 1179402563;
    }

    @Override // com.google.android.exoplayer2.extractor.ogg.StreamReader
    public long e(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray) {
        if (m(parsableByteArray.getData())) {
            return l(parsableByteArray);
        }
        return -1L;
    }

    @Override // com.google.android.exoplayer2.extractor.ogg.StreamReader
    public boolean h(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray, long j, com.google.android.exoplayer2.extractor.ogg.StreamReader.SetupData setupData) {
        byte[] data = parsableByteArray.getData();
        com.google.android.exoplayer2.extractor.FlacStreamMetadata flacStreamMetadata = this.n;
        if (flacStreamMetadata == null) {
            com.google.android.exoplayer2.extractor.FlacStreamMetadata flacStreamMetadata2 = new com.google.android.exoplayer2.extractor.FlacStreamMetadata(data, 17);
            this.n = flacStreamMetadata2;
            setupData.a = flacStreamMetadata2.getFormat(java.util.Arrays.copyOfRange(data, 9, parsableByteArray.limit()), null);
            return true;
        }
        if ((data[0] & Byte.MAX_VALUE) == 3) {
            com.google.android.exoplayer2.extractor.FlacStreamMetadata.SeekTable readSeekTableMetadataBlock = com.google.android.exoplayer2.extractor.FlacMetadataReader.readSeekTableMetadataBlock(parsableByteArray);
            com.google.android.exoplayer2.extractor.FlacStreamMetadata copyWithSeekTable = flacStreamMetadata.copyWithSeekTable(readSeekTableMetadataBlock);
            this.n = copyWithSeekTable;
            this.o = new com.google.android.exoplayer2.extractor.ogg.FlacReader.FlacOggSeeker(copyWithSeekTable, readSeekTableMetadataBlock);
            return true;
        }
        if (!m(data)) {
            return true;
        }
        com.google.android.exoplayer2.extractor.ogg.FlacReader.FlacOggSeeker flacOggSeeker = this.o;
        if (flacOggSeeker != null) {
            flacOggSeeker.c(j);
            setupData.b = this.o;
        }
        return false;
    }

    @Override // com.google.android.exoplayer2.extractor.ogg.StreamReader
    public void j(boolean z) {
        super.j(z);
        if (z) {
            this.n = null;
            this.o = null;
        }
    }

    public final int l(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray) {
        int i = (parsableByteArray.getData()[2] & 255) >> 4;
        if (i == 6 || i == 7) {
            parsableByteArray.skipBytes(4);
            parsableByteArray.readUtf8EncodedLong();
        }
        int readFrameBlockSizeSamplesFromKey = com.google.android.exoplayer2.extractor.FlacFrameReader.readFrameBlockSizeSamplesFromKey(parsableByteArray, i);
        parsableByteArray.setPosition(0);
        return readFrameBlockSizeSamplesFromKey;
    }
}
