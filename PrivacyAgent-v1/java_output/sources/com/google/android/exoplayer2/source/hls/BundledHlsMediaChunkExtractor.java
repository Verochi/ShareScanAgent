package com.google.android.exoplayer2.source.hls;

/* loaded from: classes22.dex */
public final class BundledHlsMediaChunkExtractor implements com.google.android.exoplayer2.source.hls.HlsMediaChunkExtractor {
    public static final com.google.android.exoplayer2.extractor.PositionHolder d = new com.google.android.exoplayer2.extractor.PositionHolder();

    @androidx.annotation.VisibleForTesting
    public final com.google.android.exoplayer2.extractor.Extractor a;
    public final com.google.android.exoplayer2.Format b;
    public final com.google.android.exoplayer2.util.TimestampAdjuster c;

    public BundledHlsMediaChunkExtractor(com.google.android.exoplayer2.extractor.Extractor extractor, com.google.android.exoplayer2.Format format, com.google.android.exoplayer2.util.TimestampAdjuster timestampAdjuster) {
        this.a = extractor;
        this.b = format;
        this.c = timestampAdjuster;
    }

    @Override // com.google.android.exoplayer2.source.hls.HlsMediaChunkExtractor
    public void init(com.google.android.exoplayer2.extractor.ExtractorOutput extractorOutput) {
        this.a.init(extractorOutput);
    }

    @Override // com.google.android.exoplayer2.source.hls.HlsMediaChunkExtractor
    public boolean isPackedAudioExtractor() {
        com.google.android.exoplayer2.extractor.Extractor extractor = this.a;
        return (extractor instanceof com.google.android.exoplayer2.extractor.ts.AdtsExtractor) || (extractor instanceof com.google.android.exoplayer2.extractor.ts.Ac3Extractor) || (extractor instanceof com.google.android.exoplayer2.extractor.ts.Ac4Extractor) || (extractor instanceof com.google.android.exoplayer2.extractor.mp3.Mp3Extractor);
    }

    @Override // com.google.android.exoplayer2.source.hls.HlsMediaChunkExtractor
    public boolean isReusable() {
        com.google.android.exoplayer2.extractor.Extractor extractor = this.a;
        return (extractor instanceof com.google.android.exoplayer2.extractor.ts.TsExtractor) || (extractor instanceof com.google.android.exoplayer2.extractor.mp4.FragmentedMp4Extractor);
    }

    @Override // com.google.android.exoplayer2.source.hls.HlsMediaChunkExtractor
    public boolean read(com.google.android.exoplayer2.extractor.ExtractorInput extractorInput) throws java.io.IOException {
        return this.a.read(extractorInput, d) == 0;
    }

    @Override // com.google.android.exoplayer2.source.hls.HlsMediaChunkExtractor
    public com.google.android.exoplayer2.source.hls.HlsMediaChunkExtractor recreate() {
        com.google.android.exoplayer2.extractor.Extractor mp3Extractor;
        com.google.android.exoplayer2.util.Assertions.checkState(!isReusable());
        com.google.android.exoplayer2.extractor.Extractor extractor = this.a;
        if (extractor instanceof com.google.android.exoplayer2.source.hls.WebvttExtractor) {
            mp3Extractor = new com.google.android.exoplayer2.source.hls.WebvttExtractor(this.b.language, this.c);
        } else if (extractor instanceof com.google.android.exoplayer2.extractor.ts.AdtsExtractor) {
            mp3Extractor = new com.google.android.exoplayer2.extractor.ts.AdtsExtractor();
        } else if (extractor instanceof com.google.android.exoplayer2.extractor.ts.Ac3Extractor) {
            mp3Extractor = new com.google.android.exoplayer2.extractor.ts.Ac3Extractor();
        } else if (extractor instanceof com.google.android.exoplayer2.extractor.ts.Ac4Extractor) {
            mp3Extractor = new com.google.android.exoplayer2.extractor.ts.Ac4Extractor();
        } else {
            if (!(extractor instanceof com.google.android.exoplayer2.extractor.mp3.Mp3Extractor)) {
                java.lang.String simpleName = this.a.getClass().getSimpleName();
                throw new java.lang.IllegalStateException(simpleName.length() != 0 ? "Unexpected extractor type for recreation: ".concat(simpleName) : new java.lang.String("Unexpected extractor type for recreation: "));
            }
            mp3Extractor = new com.google.android.exoplayer2.extractor.mp3.Mp3Extractor();
        }
        return new com.google.android.exoplayer2.source.hls.BundledHlsMediaChunkExtractor(mp3Extractor, this.b, this.c);
    }
}
