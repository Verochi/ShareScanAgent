package com.google.android.exoplayer2.extractor.ts;

/* loaded from: classes22.dex */
public final class MpegAudioReader implements com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader {
    public final com.google.android.exoplayer2.util.ParsableByteArray a;
    public final com.google.android.exoplayer2.audio.MpegAudioUtil.Header b;

    @androidx.annotation.Nullable
    public final java.lang.String c;
    public com.google.android.exoplayer2.extractor.TrackOutput d;
    public java.lang.String e;
    public int f;
    public int g;
    public boolean h;
    public boolean i;
    public long j;
    public int k;
    public long l;

    public MpegAudioReader() {
        this(null);
    }

    public MpegAudioReader(@androidx.annotation.Nullable java.lang.String str) {
        this.f = 0;
        com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray = new com.google.android.exoplayer2.util.ParsableByteArray(4);
        this.a = parsableByteArray;
        parsableByteArray.getData()[0] = -1;
        this.b = new com.google.android.exoplayer2.audio.MpegAudioUtil.Header();
        this.c = str;
    }

    public final void a(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray) {
        byte[] data = parsableByteArray.getData();
        int limit = parsableByteArray.limit();
        for (int position = parsableByteArray.getPosition(); position < limit; position++) {
            byte b = data[position];
            boolean z = (b & 255) == 255;
            boolean z2 = this.i && (b & 224) == 224;
            this.i = z;
            if (z2) {
                parsableByteArray.setPosition(position + 1);
                this.i = false;
                this.a.getData()[1] = data[position];
                this.g = 2;
                this.f = 1;
                return;
            }
        }
        parsableByteArray.setPosition(limit);
    }

    @org.checkerframework.checker.nullness.qual.RequiresNonNull({"output"})
    public final void b(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray) {
        int min = java.lang.Math.min(parsableByteArray.bytesLeft(), this.k - this.g);
        this.d.sampleData(parsableByteArray, min);
        int i = this.g + min;
        this.g = i;
        int i2 = this.k;
        if (i < i2) {
            return;
        }
        this.d.sampleMetadata(this.l, 1, i2, 0, null);
        this.l += this.j;
        this.g = 0;
        this.f = 0;
    }

    @org.checkerframework.checker.nullness.qual.RequiresNonNull({"output"})
    public final void c(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray) {
        int min = java.lang.Math.min(parsableByteArray.bytesLeft(), 4 - this.g);
        parsableByteArray.readBytes(this.a.getData(), this.g, min);
        int i = this.g + min;
        this.g = i;
        if (i < 4) {
            return;
        }
        this.a.setPosition(0);
        if (!this.b.setForHeaderData(this.a.readInt())) {
            this.g = 0;
            this.f = 1;
            return;
        }
        this.k = this.b.frameSize;
        if (!this.h) {
            this.j = (r8.samplesPerFrame * 1000000) / r8.sampleRate;
            this.d.format(new com.google.android.exoplayer2.Format.Builder().setId(this.e).setSampleMimeType(this.b.mimeType).setMaxInputSize(4096).setChannelCount(this.b.channels).setSampleRate(this.b.sampleRate).setLanguage(this.c).build());
            this.h = true;
        }
        this.a.setPosition(0);
        this.d.sampleData(this.a, 4);
        this.f = 2;
    }

    @Override // com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader
    public void consume(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray) {
        com.google.android.exoplayer2.util.Assertions.checkStateNotNull(this.d);
        while (parsableByteArray.bytesLeft() > 0) {
            int i = this.f;
            if (i == 0) {
                a(parsableByteArray);
            } else if (i == 1) {
                c(parsableByteArray);
            } else {
                if (i != 2) {
                    throw new java.lang.IllegalStateException();
                }
                b(parsableByteArray);
            }
        }
    }

    @Override // com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader
    public void createTracks(com.google.android.exoplayer2.extractor.ExtractorOutput extractorOutput, com.google.android.exoplayer2.extractor.ts.TsPayloadReader.TrackIdGenerator trackIdGenerator) {
        trackIdGenerator.generateNewId();
        this.e = trackIdGenerator.getFormatId();
        this.d = extractorOutput.track(trackIdGenerator.getTrackId(), 1);
    }

    @Override // com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader
    public void packetFinished() {
    }

    @Override // com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader
    public void packetStarted(long j, int i) {
        this.l = j;
    }

    @Override // com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader
    public void seek() {
        this.f = 0;
        this.g = 0;
        this.i = false;
    }
}
