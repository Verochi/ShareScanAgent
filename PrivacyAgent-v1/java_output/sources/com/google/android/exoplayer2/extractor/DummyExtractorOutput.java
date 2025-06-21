package com.google.android.exoplayer2.extractor;

/* loaded from: classes22.dex */
public final class DummyExtractorOutput implements com.google.android.exoplayer2.extractor.ExtractorOutput {
    @Override // com.google.android.exoplayer2.extractor.ExtractorOutput
    public void endTracks() {
    }

    @Override // com.google.android.exoplayer2.extractor.ExtractorOutput
    public void seekMap(com.google.android.exoplayer2.extractor.SeekMap seekMap) {
    }

    @Override // com.google.android.exoplayer2.extractor.ExtractorOutput
    public com.google.android.exoplayer2.extractor.TrackOutput track(int i, int i2) {
        return new com.google.android.exoplayer2.extractor.DummyTrackOutput();
    }
}
