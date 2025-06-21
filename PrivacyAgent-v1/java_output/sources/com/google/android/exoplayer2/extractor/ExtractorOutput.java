package com.google.android.exoplayer2.extractor;

/* loaded from: classes22.dex */
public interface ExtractorOutput {
    public static final com.google.android.exoplayer2.extractor.ExtractorOutput PLACEHOLDER = new com.google.android.exoplayer2.extractor.ExtractorOutput.AnonymousClass1();

    /* renamed from: com.google.android.exoplayer2.extractor.ExtractorOutput$1, reason: invalid class name */
    public class AnonymousClass1 implements com.google.android.exoplayer2.extractor.ExtractorOutput {
        @Override // com.google.android.exoplayer2.extractor.ExtractorOutput
        public void endTracks() {
            throw new java.lang.UnsupportedOperationException();
        }

        @Override // com.google.android.exoplayer2.extractor.ExtractorOutput
        public void seekMap(com.google.android.exoplayer2.extractor.SeekMap seekMap) {
            throw new java.lang.UnsupportedOperationException();
        }

        @Override // com.google.android.exoplayer2.extractor.ExtractorOutput
        public com.google.android.exoplayer2.extractor.TrackOutput track(int i, int i2) {
            throw new java.lang.UnsupportedOperationException();
        }
    }

    void endTracks();

    void seekMap(com.google.android.exoplayer2.extractor.SeekMap seekMap);

    com.google.android.exoplayer2.extractor.TrackOutput track(int i, int i2);
}
