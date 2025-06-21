package com.google.android.exoplayer2.extractor.ts;

/* loaded from: classes22.dex */
public final class DtsReader implements com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader {

    @androidx.annotation.Nullable
    public final java.lang.String b;
    public java.lang.String c;
    public com.google.android.exoplayer2.extractor.TrackOutput d;
    public int f;
    public int g;
    public long h;
    public com.google.android.exoplayer2.Format i;
    public int j;
    public long k;
    public final com.google.android.exoplayer2.util.ParsableByteArray a = new com.google.android.exoplayer2.util.ParsableByteArray(new byte[18]);
    public int e = 0;

    public DtsReader(@androidx.annotation.Nullable java.lang.String str) {
        this.b = str;
    }

    public final boolean a(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray, byte[] bArr, int i) {
        int min = java.lang.Math.min(parsableByteArray.bytesLeft(), i - this.f);
        parsableByteArray.readBytes(bArr, this.f, min);
        int i2 = this.f + min;
        this.f = i2;
        return i2 == i;
    }

    @org.checkerframework.checker.nullness.qual.RequiresNonNull({"output"})
    public final void b() {
        byte[] data = this.a.getData();
        if (this.i == null) {
            com.google.android.exoplayer2.Format parseDtsFormat = com.google.android.exoplayer2.audio.DtsUtil.parseDtsFormat(data, this.c, this.b, null);
            this.i = parseDtsFormat;
            this.d.format(parseDtsFormat);
        }
        this.j = com.google.android.exoplayer2.audio.DtsUtil.getDtsFrameSize(data);
        this.h = (int) ((com.google.android.exoplayer2.audio.DtsUtil.parseDtsAudioSampleCount(data) * 1000000) / this.i.sampleRate);
    }

    public final boolean c(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray) {
        while (parsableByteArray.bytesLeft() > 0) {
            int i = this.g << 8;
            this.g = i;
            int readUnsignedByte = i | parsableByteArray.readUnsignedByte();
            this.g = readUnsignedByte;
            if (com.google.android.exoplayer2.audio.DtsUtil.isSyncWord(readUnsignedByte)) {
                byte[] data = this.a.getData();
                int i2 = this.g;
                data[0] = (byte) ((i2 >> 24) & 255);
                data[1] = (byte) ((i2 >> 16) & 255);
                data[2] = (byte) ((i2 >> 8) & 255);
                data[3] = (byte) (i2 & 255);
                this.f = 4;
                this.g = 0;
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader
    public void consume(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray) {
        com.google.android.exoplayer2.util.Assertions.checkStateNotNull(this.d);
        while (parsableByteArray.bytesLeft() > 0) {
            int i = this.e;
            if (i != 0) {
                if (i != 1) {
                    if (i != 2) {
                        throw new java.lang.IllegalStateException();
                    }
                    int min = java.lang.Math.min(parsableByteArray.bytesLeft(), this.j - this.f);
                    this.d.sampleData(parsableByteArray, min);
                    int i2 = this.f + min;
                    this.f = i2;
                    int i3 = this.j;
                    if (i2 == i3) {
                        this.d.sampleMetadata(this.k, 1, i3, 0, null);
                        this.k += this.h;
                        this.e = 0;
                    }
                } else if (a(parsableByteArray, this.a.getData(), 18)) {
                    b();
                    this.a.setPosition(0);
                    this.d.sampleData(this.a, 18);
                    this.e = 2;
                }
            } else if (c(parsableByteArray)) {
                this.e = 1;
            }
        }
    }

    @Override // com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader
    public void createTracks(com.google.android.exoplayer2.extractor.ExtractorOutput extractorOutput, com.google.android.exoplayer2.extractor.ts.TsPayloadReader.TrackIdGenerator trackIdGenerator) {
        trackIdGenerator.generateNewId();
        this.c = trackIdGenerator.getFormatId();
        this.d = extractorOutput.track(trackIdGenerator.getTrackId(), 1);
    }

    @Override // com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader
    public void packetFinished() {
    }

    @Override // com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader
    public void packetStarted(long j, int i) {
        this.k = j;
    }

    @Override // com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader
    public void seek() {
        this.e = 0;
        this.f = 0;
        this.g = 0;
    }
}
