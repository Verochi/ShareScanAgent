package com.google.android.exoplayer2.extractor.ts;

/* loaded from: classes22.dex */
public interface SectionPayloadReader {
    void consume(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray);

    void init(com.google.android.exoplayer2.util.TimestampAdjuster timestampAdjuster, com.google.android.exoplayer2.extractor.ExtractorOutput extractorOutput, com.google.android.exoplayer2.extractor.ts.TsPayloadReader.TrackIdGenerator trackIdGenerator);
}
