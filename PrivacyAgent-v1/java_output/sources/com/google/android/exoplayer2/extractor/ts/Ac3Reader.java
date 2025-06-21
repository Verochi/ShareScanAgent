package com.google.android.exoplayer2.extractor.ts;

/* loaded from: classes22.dex */
public final class Ac3Reader implements com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader {
    public final com.google.android.exoplayer2.util.ParsableBitArray a;
    public final com.google.android.exoplayer2.util.ParsableByteArray b;

    @androidx.annotation.Nullable
    public final java.lang.String c;
    public java.lang.String d;
    public com.google.android.exoplayer2.extractor.TrackOutput e;
    public int f;
    public int g;
    public boolean h;
    public long i;
    public com.google.android.exoplayer2.Format j;
    public int k;
    public long l;

    public Ac3Reader() {
        this(null);
    }

    public Ac3Reader(@androidx.annotation.Nullable java.lang.String str) {
        com.google.android.exoplayer2.util.ParsableBitArray parsableBitArray = new com.google.android.exoplayer2.util.ParsableBitArray(new byte[128]);
        this.a = parsableBitArray;
        this.b = new com.google.android.exoplayer2.util.ParsableByteArray(parsableBitArray.data);
        this.f = 0;
        this.c = str;
    }

    public final boolean a(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray, byte[] bArr, int i) {
        int min = java.lang.Math.min(parsableByteArray.bytesLeft(), i - this.g);
        parsableByteArray.readBytes(bArr, this.g, min);
        int i2 = this.g + min;
        this.g = i2;
        return i2 == i;
    }

    @org.checkerframework.checker.nullness.qual.RequiresNonNull({"output"})
    public final void b() {
        this.a.setPosition(0);
        com.google.android.exoplayer2.audio.Ac3Util.SyncFrameInfo parseAc3SyncframeInfo = com.google.android.exoplayer2.audio.Ac3Util.parseAc3SyncframeInfo(this.a);
        com.google.android.exoplayer2.Format format = this.j;
        if (format == null || parseAc3SyncframeInfo.channelCount != format.channelCount || parseAc3SyncframeInfo.sampleRate != format.sampleRate || !com.google.android.exoplayer2.util.Util.areEqual(parseAc3SyncframeInfo.mimeType, format.sampleMimeType)) {
            com.google.android.exoplayer2.Format build = new com.google.android.exoplayer2.Format.Builder().setId(this.d).setSampleMimeType(parseAc3SyncframeInfo.mimeType).setChannelCount(parseAc3SyncframeInfo.channelCount).setSampleRate(parseAc3SyncframeInfo.sampleRate).setLanguage(this.c).build();
            this.j = build;
            this.e.format(build);
        }
        this.k = parseAc3SyncframeInfo.frameSize;
        this.i = (parseAc3SyncframeInfo.sampleCount * 1000000) / this.j.sampleRate;
    }

    public final boolean c(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray) {
        while (true) {
            if (parsableByteArray.bytesLeft() <= 0) {
                return false;
            }
            if (this.h) {
                int readUnsignedByte = parsableByteArray.readUnsignedByte();
                if (readUnsignedByte == 119) {
                    this.h = false;
                    return true;
                }
                this.h = readUnsignedByte == 11;
            } else {
                this.h = parsableByteArray.readUnsignedByte() == 11;
            }
        }
    }

    @Override // com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader
    public void consume(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray) {
        com.google.android.exoplayer2.util.Assertions.checkStateNotNull(this.e);
        while (parsableByteArray.bytesLeft() > 0) {
            int i = this.f;
            if (i != 0) {
                if (i != 1) {
                    if (i == 2) {
                        int min = java.lang.Math.min(parsableByteArray.bytesLeft(), this.k - this.g);
                        this.e.sampleData(parsableByteArray, min);
                        int i2 = this.g + min;
                        this.g = i2;
                        int i3 = this.k;
                        if (i2 == i3) {
                            this.e.sampleMetadata(this.l, 1, i3, 0, null);
                            this.l += this.i;
                            this.f = 0;
                        }
                    }
                } else if (a(parsableByteArray, this.b.getData(), 128)) {
                    b();
                    this.b.setPosition(0);
                    this.e.sampleData(this.b, 128);
                    this.f = 2;
                }
            } else if (c(parsableByteArray)) {
                this.f = 1;
                this.b.getData()[0] = 11;
                this.b.getData()[1] = 119;
                this.g = 2;
            }
        }
    }

    @Override // com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader
    public void createTracks(com.google.android.exoplayer2.extractor.ExtractorOutput extractorOutput, com.google.android.exoplayer2.extractor.ts.TsPayloadReader.TrackIdGenerator trackIdGenerator) {
        trackIdGenerator.generateNewId();
        this.d = trackIdGenerator.getFormatId();
        this.e = extractorOutput.track(trackIdGenerator.getTrackId(), 1);
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
        this.h = false;
    }
}
