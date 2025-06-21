package com.google.android.exoplayer2.extractor.ts;

/* loaded from: classes22.dex */
final class UserDataReader {
    public final java.util.List<com.google.android.exoplayer2.Format> a;
    public final com.google.android.exoplayer2.extractor.TrackOutput[] b;

    public UserDataReader(java.util.List<com.google.android.exoplayer2.Format> list) {
        this.a = list;
        this.b = new com.google.android.exoplayer2.extractor.TrackOutput[list.size()];
    }

    public void a(long j, com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray) {
        if (parsableByteArray.bytesLeft() < 9) {
            return;
        }
        int readInt = parsableByteArray.readInt();
        int readInt2 = parsableByteArray.readInt();
        int readUnsignedByte = parsableByteArray.readUnsignedByte();
        if (readInt == 434 && readInt2 == 1195456820 && readUnsignedByte == 3) {
            com.google.android.exoplayer2.extractor.CeaUtil.consumeCcData(j, parsableByteArray, this.b);
        }
    }

    public void b(com.google.android.exoplayer2.extractor.ExtractorOutput extractorOutput, com.google.android.exoplayer2.extractor.ts.TsPayloadReader.TrackIdGenerator trackIdGenerator) {
        for (int i = 0; i < this.b.length; i++) {
            trackIdGenerator.generateNewId();
            com.google.android.exoplayer2.extractor.TrackOutput track = extractorOutput.track(trackIdGenerator.getTrackId(), 3);
            com.google.android.exoplayer2.Format format = this.a.get(i);
            java.lang.String str = format.sampleMimeType;
            boolean z = "application/cea-608".equals(str) || "application/cea-708".equals(str);
            java.lang.String valueOf = java.lang.String.valueOf(str);
            com.google.android.exoplayer2.util.Assertions.checkArgument(z, valueOf.length() != 0 ? "Invalid closed caption mime type provided: ".concat(valueOf) : new java.lang.String("Invalid closed caption mime type provided: "));
            track.format(new com.google.android.exoplayer2.Format.Builder().setId(trackIdGenerator.getFormatId()).setSampleMimeType(str).setSelectionFlags(format.selectionFlags).setLanguage(format.language).setAccessibilityChannel(format.accessibilityChannel).setInitializationData(format.initializationData).build());
            this.b[i] = track;
        }
    }
}
