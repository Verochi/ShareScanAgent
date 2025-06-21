package com.google.android.exoplayer2.extractor.ts;

/* loaded from: classes22.dex */
final class PsBinarySearchSeeker extends com.google.android.exoplayer2.extractor.BinarySearchSeeker {

    public static final class PsScrSeeker implements com.google.android.exoplayer2.extractor.BinarySearchSeeker.TimestampSeeker {
        public final com.google.android.exoplayer2.util.TimestampAdjuster a;
        public final com.google.android.exoplayer2.util.ParsableByteArray b;

        public PsScrSeeker(com.google.android.exoplayer2.util.TimestampAdjuster timestampAdjuster) {
            this.a = timestampAdjuster;
            this.b = new com.google.android.exoplayer2.util.ParsableByteArray();
        }

        public /* synthetic */ PsScrSeeker(com.google.android.exoplayer2.util.TimestampAdjuster timestampAdjuster, com.google.android.exoplayer2.extractor.ts.PsBinarySearchSeeker.AnonymousClass1 anonymousClass1) {
            this(timestampAdjuster);
        }

        public static void b(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray) {
            int b;
            int limit = parsableByteArray.limit();
            if (parsableByteArray.bytesLeft() < 10) {
                parsableByteArray.setPosition(limit);
                return;
            }
            parsableByteArray.skipBytes(9);
            int readUnsignedByte = parsableByteArray.readUnsignedByte() & 7;
            if (parsableByteArray.bytesLeft() < readUnsignedByte) {
                parsableByteArray.setPosition(limit);
                return;
            }
            parsableByteArray.skipBytes(readUnsignedByte);
            if (parsableByteArray.bytesLeft() < 4) {
                parsableByteArray.setPosition(limit);
                return;
            }
            if (com.google.android.exoplayer2.extractor.ts.PsBinarySearchSeeker.b(parsableByteArray.getData(), parsableByteArray.getPosition()) == 443) {
                parsableByteArray.skipBytes(4);
                int readUnsignedShort = parsableByteArray.readUnsignedShort();
                if (parsableByteArray.bytesLeft() < readUnsignedShort) {
                    parsableByteArray.setPosition(limit);
                    return;
                }
                parsableByteArray.skipBytes(readUnsignedShort);
            }
            while (parsableByteArray.bytesLeft() >= 4 && (b = com.google.android.exoplayer2.extractor.ts.PsBinarySearchSeeker.b(parsableByteArray.getData(), parsableByteArray.getPosition())) != 442 && b != 441 && (b >>> 8) == 1) {
                parsableByteArray.skipBytes(4);
                if (parsableByteArray.bytesLeft() < 2) {
                    parsableByteArray.setPosition(limit);
                    return;
                }
                parsableByteArray.setPosition(java.lang.Math.min(parsableByteArray.limit(), parsableByteArray.getPosition() + parsableByteArray.readUnsignedShort()));
            }
        }

        public final com.google.android.exoplayer2.extractor.BinarySearchSeeker.TimestampSearchResult a(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray, long j, long j2) {
            int i = -1;
            long j3 = -9223372036854775807L;
            int i2 = -1;
            while (parsableByteArray.bytesLeft() >= 4) {
                if (com.google.android.exoplayer2.extractor.ts.PsBinarySearchSeeker.b(parsableByteArray.getData(), parsableByteArray.getPosition()) != 442) {
                    parsableByteArray.skipBytes(1);
                } else {
                    parsableByteArray.skipBytes(4);
                    long l = com.google.android.exoplayer2.extractor.ts.PsDurationReader.l(parsableByteArray);
                    if (l != -9223372036854775807L) {
                        long adjustTsTimestamp = this.a.adjustTsTimestamp(l);
                        if (adjustTsTimestamp > j) {
                            return j3 == -9223372036854775807L ? com.google.android.exoplayer2.extractor.BinarySearchSeeker.TimestampSearchResult.overestimatedResult(adjustTsTimestamp, j2) : com.google.android.exoplayer2.extractor.BinarySearchSeeker.TimestampSearchResult.targetFoundResult(j2 + i2);
                        }
                        if (100000 + adjustTsTimestamp > j) {
                            return com.google.android.exoplayer2.extractor.BinarySearchSeeker.TimestampSearchResult.targetFoundResult(j2 + parsableByteArray.getPosition());
                        }
                        i2 = parsableByteArray.getPosition();
                        j3 = adjustTsTimestamp;
                    }
                    b(parsableByteArray);
                    i = parsableByteArray.getPosition();
                }
            }
            return j3 != -9223372036854775807L ? com.google.android.exoplayer2.extractor.BinarySearchSeeker.TimestampSearchResult.underestimatedResult(j3, j2 + i) : com.google.android.exoplayer2.extractor.BinarySearchSeeker.TimestampSearchResult.NO_TIMESTAMP_IN_RANGE_RESULT;
        }

        @Override // com.google.android.exoplayer2.extractor.BinarySearchSeeker.TimestampSeeker
        public void onSeekFinished() {
            this.b.reset(com.google.android.exoplayer2.util.Util.EMPTY_BYTE_ARRAY);
        }

        @Override // com.google.android.exoplayer2.extractor.BinarySearchSeeker.TimestampSeeker
        public com.google.android.exoplayer2.extractor.BinarySearchSeeker.TimestampSearchResult searchForTimestamp(com.google.android.exoplayer2.extractor.ExtractorInput extractorInput, long j) throws java.io.IOException {
            long position = extractorInput.getPosition();
            int min = (int) java.lang.Math.min(com.google.android.exoplayer2.audio.SilenceSkippingAudioProcessor.DEFAULT_PADDING_SILENCE_US, extractorInput.getLength() - position);
            this.b.reset(min);
            extractorInput.peekFully(this.b.getData(), 0, min);
            return a(this.b, j, position);
        }
    }

    public PsBinarySearchSeeker(com.google.android.exoplayer2.util.TimestampAdjuster timestampAdjuster, long j, long j2) {
        super(new com.google.android.exoplayer2.extractor.BinarySearchSeeker.DefaultSeekTimestampConverter(), new com.google.android.exoplayer2.extractor.ts.PsBinarySearchSeeker.PsScrSeeker(timestampAdjuster, null), j, 0L, j + 1, 0L, j2, 188L, 1000);
    }

    public static int b(byte[] bArr, int i) {
        return (bArr[i + 3] & 255) | ((bArr[i] & 255) << 24) | ((bArr[i + 1] & 255) << 16) | ((bArr[i + 2] & 255) << 8);
    }
}
