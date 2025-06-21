package com.google.android.exoplayer2.extractor.ts;

/* loaded from: classes22.dex */
final class PsDurationReader {
    public boolean c;
    public boolean d;
    public boolean e;
    public final com.google.android.exoplayer2.util.TimestampAdjuster a = new com.google.android.exoplayer2.util.TimestampAdjuster(0);
    public long f = -9223372036854775807L;
    public long g = -9223372036854775807L;
    public long h = -9223372036854775807L;
    public final com.google.android.exoplayer2.util.ParsableByteArray b = new com.google.android.exoplayer2.util.ParsableByteArray();

    public static boolean a(byte[] bArr) {
        return (bArr[0] & 196) == 68 && (bArr[2] & 4) == 4 && (bArr[4] & 4) == 4 && (bArr[5] & 1) == 1 && (bArr[8] & 3) == 3;
    }

    public static long l(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray) {
        int position = parsableByteArray.getPosition();
        if (parsableByteArray.bytesLeft() < 9) {
            return -9223372036854775807L;
        }
        byte[] bArr = new byte[9];
        parsableByteArray.readBytes(bArr, 0, 9);
        parsableByteArray.setPosition(position);
        if (a(bArr)) {
            return m(bArr);
        }
        return -9223372036854775807L;
    }

    public static long m(byte[] bArr) {
        byte b = bArr[0];
        long j = (((b & 56) >> 3) << 30) | ((b & 3) << 28) | ((bArr[1] & 255) << 20);
        byte b2 = bArr[2];
        return j | (((b2 & 248) >> 3) << 15) | ((b2 & 3) << 13) | ((bArr[3] & 255) << 5) | ((bArr[4] & 248) >> 3);
    }

    public final int b(com.google.android.exoplayer2.extractor.ExtractorInput extractorInput) {
        this.b.reset(com.google.android.exoplayer2.util.Util.EMPTY_BYTE_ARRAY);
        this.c = true;
        extractorInput.resetPeekPosition();
        return 0;
    }

    public long c() {
        return this.h;
    }

    public com.google.android.exoplayer2.util.TimestampAdjuster d() {
        return this.a;
    }

    public boolean e() {
        return this.c;
    }

    public final int f(byte[] bArr, int i) {
        return (bArr[i + 3] & 255) | ((bArr[i] & 255) << 24) | ((bArr[i + 1] & 255) << 16) | ((bArr[i + 2] & 255) << 8);
    }

    public int g(com.google.android.exoplayer2.extractor.ExtractorInput extractorInput, com.google.android.exoplayer2.extractor.PositionHolder positionHolder) throws java.io.IOException {
        if (!this.e) {
            return j(extractorInput, positionHolder);
        }
        if (this.g == -9223372036854775807L) {
            return b(extractorInput);
        }
        if (!this.d) {
            return h(extractorInput, positionHolder);
        }
        long j = this.f;
        if (j == -9223372036854775807L) {
            return b(extractorInput);
        }
        this.h = this.a.adjustTsTimestamp(this.g) - this.a.adjustTsTimestamp(j);
        return b(extractorInput);
    }

    public final int h(com.google.android.exoplayer2.extractor.ExtractorInput extractorInput, com.google.android.exoplayer2.extractor.PositionHolder positionHolder) throws java.io.IOException {
        int min = (int) java.lang.Math.min(com.google.android.exoplayer2.audio.SilenceSkippingAudioProcessor.DEFAULT_PADDING_SILENCE_US, extractorInput.getLength());
        long j = 0;
        if (extractorInput.getPosition() != j) {
            positionHolder.position = j;
            return 1;
        }
        this.b.reset(min);
        extractorInput.resetPeekPosition();
        extractorInput.peekFully(this.b.getData(), 0, min);
        this.f = i(this.b);
        this.d = true;
        return 0;
    }

    public final long i(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray) {
        int limit = parsableByteArray.limit();
        for (int position = parsableByteArray.getPosition(); position < limit - 3; position++) {
            if (f(parsableByteArray.getData(), position) == 442) {
                parsableByteArray.setPosition(position + 4);
                long l = l(parsableByteArray);
                if (l != -9223372036854775807L) {
                    return l;
                }
            }
        }
        return -9223372036854775807L;
    }

    public final int j(com.google.android.exoplayer2.extractor.ExtractorInput extractorInput, com.google.android.exoplayer2.extractor.PositionHolder positionHolder) throws java.io.IOException {
        long length = extractorInput.getLength();
        int min = (int) java.lang.Math.min(com.google.android.exoplayer2.audio.SilenceSkippingAudioProcessor.DEFAULT_PADDING_SILENCE_US, length);
        long j = length - min;
        if (extractorInput.getPosition() != j) {
            positionHolder.position = j;
            return 1;
        }
        this.b.reset(min);
        extractorInput.resetPeekPosition();
        extractorInput.peekFully(this.b.getData(), 0, min);
        this.g = k(this.b);
        this.e = true;
        return 0;
    }

    public final long k(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray) {
        int position = parsableByteArray.getPosition();
        for (int limit = parsableByteArray.limit() - 4; limit >= position; limit--) {
            if (f(parsableByteArray.getData(), limit) == 442) {
                parsableByteArray.setPosition(limit + 4);
                long l = l(parsableByteArray);
                if (l != -9223372036854775807L) {
                    return l;
                }
            }
        }
        return -9223372036854775807L;
    }
}
