package com.google.android.exoplayer2.extractor.ts;

/* loaded from: classes22.dex */
public final class Ac4Reader implements com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader {
    public final com.google.android.exoplayer2.util.ParsableBitArray a;
    public final com.google.android.exoplayer2.util.ParsableByteArray b;

    @androidx.annotation.Nullable
    public final java.lang.String c;
    public java.lang.String d;
    public com.google.android.exoplayer2.extractor.TrackOutput e;
    public int f;
    public int g;
    public boolean h;
    public boolean i;
    public long j;
    public com.google.android.exoplayer2.Format k;
    public int l;
    public long m;

    public Ac4Reader() {
        this(null);
    }

    public Ac4Reader(@androidx.annotation.Nullable java.lang.String str) {
        com.google.android.exoplayer2.util.ParsableBitArray parsableBitArray = new com.google.android.exoplayer2.util.ParsableBitArray(new byte[16]);
        this.a = parsableBitArray;
        this.b = new com.google.android.exoplayer2.util.ParsableByteArray(parsableBitArray.data);
        this.f = 0;
        this.g = 0;
        this.h = false;
        this.i = false;
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
        com.google.android.exoplayer2.audio.Ac4Util.SyncFrameInfo parseAc4SyncframeInfo = com.google.android.exoplayer2.audio.Ac4Util.parseAc4SyncframeInfo(this.a);
        com.google.android.exoplayer2.Format format = this.k;
        if (format == null || parseAc4SyncframeInfo.channelCount != format.channelCount || parseAc4SyncframeInfo.sampleRate != format.sampleRate || !com.google.android.exoplayer2.util.MimeTypes.AUDIO_AC4.equals(format.sampleMimeType)) {
            com.google.android.exoplayer2.Format build = new com.google.android.exoplayer2.Format.Builder().setId(this.d).setSampleMimeType(com.google.android.exoplayer2.util.MimeTypes.AUDIO_AC4).setChannelCount(parseAc4SyncframeInfo.channelCount).setSampleRate(parseAc4SyncframeInfo.sampleRate).setLanguage(this.c).build();
            this.k = build;
            this.e.format(build);
        }
        this.l = parseAc4SyncframeInfo.frameSize;
        this.j = (parseAc4SyncframeInfo.sampleCount * 1000000) / this.k.sampleRate;
    }

    public final boolean c(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray) {
        int readUnsignedByte;
        while (true) {
            if (parsableByteArray.bytesLeft() <= 0) {
                return false;
            }
            if (this.h) {
                readUnsignedByte = parsableByteArray.readUnsignedByte();
                this.h = readUnsignedByte == 172;
                if (readUnsignedByte == 64 || readUnsignedByte == 65) {
                    break;
                }
            } else {
                this.h = parsableByteArray.readUnsignedByte() == 172;
            }
        }
        this.i = readUnsignedByte == 65;
        return true;
    }

    @Override // com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader
    public void consume(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray) {
        com.google.android.exoplayer2.util.Assertions.checkStateNotNull(this.e);
        while (parsableByteArray.bytesLeft() > 0) {
            int i = this.f;
            if (i != 0) {
                if (i != 1) {
                    if (i == 2) {
                        int min = java.lang.Math.min(parsableByteArray.bytesLeft(), this.l - this.g);
                        this.e.sampleData(parsableByteArray, min);
                        int i2 = this.g + min;
                        this.g = i2;
                        int i3 = this.l;
                        if (i2 == i3) {
                            this.e.sampleMetadata(this.m, 1, i3, 0, null);
                            this.m += this.j;
                            this.f = 0;
                        }
                    }
                } else if (a(parsableByteArray, this.b.getData(), 16)) {
                    b();
                    this.b.setPosition(0);
                    this.e.sampleData(this.b, 16);
                    this.f = 2;
                }
            } else if (c(parsableByteArray)) {
                this.f = 1;
                this.b.getData()[0] = -84;
                this.b.getData()[1] = (byte) (this.i ? 65 : 64);
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
        this.m = j;
    }

    @Override // com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader
    public void seek() {
        this.f = 0;
        this.g = 0;
        this.h = false;
        this.i = false;
    }
}
