package com.google.android.exoplayer2.extractor.ts;

/* loaded from: classes22.dex */
public final class Id3Reader implements com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader {
    public final com.google.android.exoplayer2.util.ParsableByteArray a = new com.google.android.exoplayer2.util.ParsableByteArray(10);
    public com.google.android.exoplayer2.extractor.TrackOutput b;
    public boolean c;
    public long d;
    public int e;
    public int f;

    @Override // com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader
    public void consume(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray) {
        com.google.android.exoplayer2.util.Assertions.checkStateNotNull(this.b);
        if (this.c) {
            int bytesLeft = parsableByteArray.bytesLeft();
            int i = this.f;
            if (i < 10) {
                int min = java.lang.Math.min(bytesLeft, 10 - i);
                java.lang.System.arraycopy(parsableByteArray.getData(), parsableByteArray.getPosition(), this.a.getData(), this.f, min);
                if (this.f + min == 10) {
                    this.a.setPosition(0);
                    if (73 != this.a.readUnsignedByte() || 68 != this.a.readUnsignedByte() || 51 != this.a.readUnsignedByte()) {
                        com.google.android.exoplayer2.util.Log.w("Id3Reader", "Discarding invalid ID3 tag");
                        this.c = false;
                        return;
                    } else {
                        this.a.skipBytes(3);
                        this.e = this.a.readSynchSafeInt() + 10;
                    }
                }
            }
            int min2 = java.lang.Math.min(bytesLeft, this.e - this.f);
            this.b.sampleData(parsableByteArray, min2);
            this.f += min2;
        }
    }

    @Override // com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader
    public void createTracks(com.google.android.exoplayer2.extractor.ExtractorOutput extractorOutput, com.google.android.exoplayer2.extractor.ts.TsPayloadReader.TrackIdGenerator trackIdGenerator) {
        trackIdGenerator.generateNewId();
        com.google.android.exoplayer2.extractor.TrackOutput track = extractorOutput.track(trackIdGenerator.getTrackId(), 4);
        this.b = track;
        track.format(new com.google.android.exoplayer2.Format.Builder().setId(trackIdGenerator.getFormatId()).setSampleMimeType("application/id3").build());
    }

    @Override // com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader
    public void packetFinished() {
        int i;
        com.google.android.exoplayer2.util.Assertions.checkStateNotNull(this.b);
        if (this.c && (i = this.e) != 0 && this.f == i) {
            this.b.sampleMetadata(this.d, 1, i, 0, null);
            this.c = false;
        }
    }

    @Override // com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader
    public void packetStarted(long j, int i) {
        if ((i & 4) == 0) {
            return;
        }
        this.c = true;
        this.d = j;
        this.e = 0;
        this.f = 0;
    }

    @Override // com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader
    public void seek() {
        this.c = false;
    }
}
