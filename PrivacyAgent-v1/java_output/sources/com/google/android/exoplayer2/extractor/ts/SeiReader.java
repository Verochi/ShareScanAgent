package com.google.android.exoplayer2.extractor.ts;

/* loaded from: classes22.dex */
public final class SeiReader {
    public final java.util.List<com.google.android.exoplayer2.Format> a;
    public final com.google.android.exoplayer2.extractor.TrackOutput[] b;

    public SeiReader(java.util.List<com.google.android.exoplayer2.Format> list) {
        this.a = list;
        this.b = new com.google.android.exoplayer2.extractor.TrackOutput[list.size()];
    }

    public void consume(long j, com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray) {
        com.google.android.exoplayer2.extractor.CeaUtil.consume(j, parsableByteArray, this.b);
    }

    public void createTracks(com.google.android.exoplayer2.extractor.ExtractorOutput extractorOutput, com.google.android.exoplayer2.extractor.ts.TsPayloadReader.TrackIdGenerator trackIdGenerator) {
        for (int i = 0; i < this.b.length; i++) {
            trackIdGenerator.generateNewId();
            com.google.android.exoplayer2.extractor.TrackOutput track = extractorOutput.track(trackIdGenerator.getTrackId(), 3);
            com.google.android.exoplayer2.Format format = this.a.get(i);
            java.lang.String str = format.sampleMimeType;
            boolean z = "application/cea-608".equals(str) || "application/cea-708".equals(str);
            java.lang.String valueOf = java.lang.String.valueOf(str);
            com.google.android.exoplayer2.util.Assertions.checkArgument(z, valueOf.length() != 0 ? "Invalid closed caption mime type provided: ".concat(valueOf) : new java.lang.String("Invalid closed caption mime type provided: "));
            java.lang.String str2 = format.id;
            if (str2 == null) {
                str2 = trackIdGenerator.getFormatId();
            }
            track.format(new com.google.android.exoplayer2.Format.Builder().setId(str2).setSampleMimeType(str).setSelectionFlags(format.selectionFlags).setLanguage(format.language).setAccessibilityChannel(format.accessibilityChannel).setInitializationData(format.initializationData).build());
            this.b[i] = track;
        }
    }
}
