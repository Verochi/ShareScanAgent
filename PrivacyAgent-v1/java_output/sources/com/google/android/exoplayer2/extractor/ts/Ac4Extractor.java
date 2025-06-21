package com.google.android.exoplayer2.extractor.ts;

/* loaded from: classes22.dex */
public final class Ac4Extractor implements com.google.android.exoplayer2.extractor.Extractor {
    public static final com.google.android.exoplayer2.extractor.ExtractorsFactory FACTORY = new defpackage.u1();
    public final com.google.android.exoplayer2.extractor.ts.Ac4Reader a = new com.google.android.exoplayer2.extractor.ts.Ac4Reader();
    public final com.google.android.exoplayer2.util.ParsableByteArray b = new com.google.android.exoplayer2.util.ParsableByteArray(16384);
    public boolean c;

    public static /* synthetic */ com.google.android.exoplayer2.extractor.Extractor[] b() {
        return new com.google.android.exoplayer2.extractor.Extractor[]{new com.google.android.exoplayer2.extractor.ts.Ac4Extractor()};
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void init(com.google.android.exoplayer2.extractor.ExtractorOutput extractorOutput) {
        this.a.createTracks(extractorOutput, new com.google.android.exoplayer2.extractor.ts.TsPayloadReader.TrackIdGenerator(0, 1));
        extractorOutput.endTracks();
        extractorOutput.seekMap(new com.google.android.exoplayer2.extractor.SeekMap.Unseekable(-9223372036854775807L));
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public int read(com.google.android.exoplayer2.extractor.ExtractorInput extractorInput, com.google.android.exoplayer2.extractor.PositionHolder positionHolder) throws java.io.IOException {
        int read = extractorInput.read(this.b.getData(), 0, 16384);
        if (read == -1) {
            return -1;
        }
        this.b.setPosition(0);
        this.b.setLimit(read);
        if (!this.c) {
            this.a.packetStarted(0L, 4);
            this.c = true;
        }
        this.a.consume(this.b);
        return 0;
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void release() {
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void seek(long j, long j2) {
        this.c = false;
        this.a.seek();
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x003d, code lost:
    
        r9.resetPeekPosition();
        r4 = r4 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0046, code lost:
    
        if ((r4 - r3) < 8192) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0048, code lost:
    
        return false;
     */
    @Override // com.google.android.exoplayer2.extractor.Extractor
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean sniff(com.google.android.exoplayer2.extractor.ExtractorInput extractorInput) throws java.io.IOException {
        com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray = new com.google.android.exoplayer2.util.ParsableByteArray(10);
        int i = 0;
        while (true) {
            extractorInput.peekFully(parsableByteArray.getData(), 0, 10);
            parsableByteArray.setPosition(0);
            if (parsableByteArray.readUnsignedInt24() != 4801587) {
                break;
            }
            parsableByteArray.skipBytes(3);
            int readSynchSafeInt = parsableByteArray.readSynchSafeInt();
            i += readSynchSafeInt + 10;
            extractorInput.advancePeekPosition(readSynchSafeInt);
        }
        extractorInput.resetPeekPosition();
        extractorInput.advancePeekPosition(i);
        int i2 = i;
        while (true) {
            int i3 = 0;
            while (true) {
                extractorInput.peekFully(parsableByteArray.getData(), 0, 7);
                parsableByteArray.setPosition(0);
                int readUnsignedShort = parsableByteArray.readUnsignedShort();
                if (readUnsignedShort != 44096 && readUnsignedShort != 44097) {
                    break;
                }
                i3++;
                if (i3 >= 4) {
                    return true;
                }
                int parseAc4SyncframeSize = com.google.android.exoplayer2.audio.Ac4Util.parseAc4SyncframeSize(parsableByteArray.getData(), readUnsignedShort);
                if (parseAc4SyncframeSize == -1) {
                    return false;
                }
                extractorInput.advancePeekPosition(parseAc4SyncframeSize - 7);
            }
            extractorInput.advancePeekPosition(i2);
        }
    }
}
