package com.google.android.exoplayer2.extractor.ts;

/* loaded from: classes22.dex */
final class TsDurationReader {
    public final int a;
    public boolean d;
    public boolean e;
    public boolean f;
    public final com.google.android.exoplayer2.util.TimestampAdjuster b = new com.google.android.exoplayer2.util.TimestampAdjuster(0);
    public long g = -9223372036854775807L;
    public long h = -9223372036854775807L;
    public long i = -9223372036854775807L;
    public final com.google.android.exoplayer2.util.ParsableByteArray c = new com.google.android.exoplayer2.util.ParsableByteArray();

    public TsDurationReader(int i) {
        this.a = i;
    }

    public final int a(com.google.android.exoplayer2.extractor.ExtractorInput extractorInput) {
        this.c.reset(com.google.android.exoplayer2.util.Util.EMPTY_BYTE_ARRAY);
        this.d = true;
        extractorInput.resetPeekPosition();
        return 0;
    }

    public long b() {
        return this.i;
    }

    public com.google.android.exoplayer2.util.TimestampAdjuster c() {
        return this.b;
    }

    public boolean d() {
        return this.d;
    }

    public int e(com.google.android.exoplayer2.extractor.ExtractorInput extractorInput, com.google.android.exoplayer2.extractor.PositionHolder positionHolder, int i) throws java.io.IOException {
        if (i <= 0) {
            return a(extractorInput);
        }
        if (!this.f) {
            return h(extractorInput, positionHolder, i);
        }
        if (this.h == -9223372036854775807L) {
            return a(extractorInput);
        }
        if (!this.e) {
            return f(extractorInput, positionHolder, i);
        }
        long j = this.g;
        if (j == -9223372036854775807L) {
            return a(extractorInput);
        }
        this.i = this.b.adjustTsTimestamp(this.h) - this.b.adjustTsTimestamp(j);
        return a(extractorInput);
    }

    public final int f(com.google.android.exoplayer2.extractor.ExtractorInput extractorInput, com.google.android.exoplayer2.extractor.PositionHolder positionHolder, int i) throws java.io.IOException {
        int min = (int) java.lang.Math.min(this.a, extractorInput.getLength());
        long j = 0;
        if (extractorInput.getPosition() != j) {
            positionHolder.position = j;
            return 1;
        }
        this.c.reset(min);
        extractorInput.resetPeekPosition();
        extractorInput.peekFully(this.c.getData(), 0, min);
        this.g = g(this.c, i);
        this.e = true;
        return 0;
    }

    public final long g(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray, int i) {
        int limit = parsableByteArray.limit();
        for (int position = parsableByteArray.getPosition(); position < limit; position++) {
            if (parsableByteArray.getData()[position] == 71) {
                long readPcrFromPacket = com.google.android.exoplayer2.extractor.ts.TsUtil.readPcrFromPacket(parsableByteArray, position, i);
                if (readPcrFromPacket != -9223372036854775807L) {
                    return readPcrFromPacket;
                }
            }
        }
        return -9223372036854775807L;
    }

    public final int h(com.google.android.exoplayer2.extractor.ExtractorInput extractorInput, com.google.android.exoplayer2.extractor.PositionHolder positionHolder, int i) throws java.io.IOException {
        long length = extractorInput.getLength();
        int min = (int) java.lang.Math.min(this.a, length);
        long j = length - min;
        if (extractorInput.getPosition() != j) {
            positionHolder.position = j;
            return 1;
        }
        this.c.reset(min);
        extractorInput.resetPeekPosition();
        extractorInput.peekFully(this.c.getData(), 0, min);
        this.h = i(this.c, i);
        this.f = true;
        return 0;
    }

    public final long i(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray, int i) {
        int position = parsableByteArray.getPosition();
        int limit = parsableByteArray.limit();
        while (true) {
            limit--;
            if (limit < position) {
                return -9223372036854775807L;
            }
            if (parsableByteArray.getData()[limit] == 71) {
                long readPcrFromPacket = com.google.android.exoplayer2.extractor.ts.TsUtil.readPcrFromPacket(parsableByteArray, limit, i);
                if (readPcrFromPacket != -9223372036854775807L) {
                    return readPcrFromPacket;
                }
            }
        }
    }
}
