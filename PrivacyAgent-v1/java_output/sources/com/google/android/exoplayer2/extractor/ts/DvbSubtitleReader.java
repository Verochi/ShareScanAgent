package com.google.android.exoplayer2.extractor.ts;

/* loaded from: classes22.dex */
public final class DvbSubtitleReader implements com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader {
    public final java.util.List<com.google.android.exoplayer2.extractor.ts.TsPayloadReader.DvbSubtitleInfo> a;
    public final com.google.android.exoplayer2.extractor.TrackOutput[] b;
    public boolean c;
    public int d;
    public int e;
    public long f;

    public DvbSubtitleReader(java.util.List<com.google.android.exoplayer2.extractor.ts.TsPayloadReader.DvbSubtitleInfo> list) {
        this.a = list;
        this.b = new com.google.android.exoplayer2.extractor.TrackOutput[list.size()];
    }

    public final boolean a(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray, int i) {
        if (parsableByteArray.bytesLeft() == 0) {
            return false;
        }
        if (parsableByteArray.readUnsignedByte() != i) {
            this.c = false;
        }
        this.d--;
        return this.c;
    }

    @Override // com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader
    public void consume(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray) {
        if (this.c) {
            if (this.d != 2 || a(parsableByteArray, 32)) {
                if (this.d != 1 || a(parsableByteArray, 0)) {
                    int position = parsableByteArray.getPosition();
                    int bytesLeft = parsableByteArray.bytesLeft();
                    for (com.google.android.exoplayer2.extractor.TrackOutput trackOutput : this.b) {
                        parsableByteArray.setPosition(position);
                        trackOutput.sampleData(parsableByteArray, bytesLeft);
                    }
                    this.e += bytesLeft;
                }
            }
        }
    }

    @Override // com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader
    public void createTracks(com.google.android.exoplayer2.extractor.ExtractorOutput extractorOutput, com.google.android.exoplayer2.extractor.ts.TsPayloadReader.TrackIdGenerator trackIdGenerator) {
        for (int i = 0; i < this.b.length; i++) {
            com.google.android.exoplayer2.extractor.ts.TsPayloadReader.DvbSubtitleInfo dvbSubtitleInfo = this.a.get(i);
            trackIdGenerator.generateNewId();
            com.google.android.exoplayer2.extractor.TrackOutput track = extractorOutput.track(trackIdGenerator.getTrackId(), 3);
            track.format(new com.google.android.exoplayer2.Format.Builder().setId(trackIdGenerator.getFormatId()).setSampleMimeType("application/dvbsubs").setInitializationData(java.util.Collections.singletonList(dvbSubtitleInfo.initializationData)).setLanguage(dvbSubtitleInfo.language).build());
            this.b[i] = track;
        }
    }

    @Override // com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader
    public void packetFinished() {
        if (this.c) {
            for (com.google.android.exoplayer2.extractor.TrackOutput trackOutput : this.b) {
                trackOutput.sampleMetadata(this.f, 1, this.e, 0, null);
            }
            this.c = false;
        }
    }

    @Override // com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader
    public void packetStarted(long j, int i) {
        if ((i & 4) == 0) {
            return;
        }
        this.c = true;
        this.f = j;
        this.e = 0;
        this.d = 2;
    }

    @Override // com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader
    public void seek() {
        this.c = false;
    }
}
