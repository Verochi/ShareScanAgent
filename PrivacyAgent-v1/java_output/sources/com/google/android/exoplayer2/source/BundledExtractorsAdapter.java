package com.google.android.exoplayer2.source;

/* loaded from: classes22.dex */
final class BundledExtractorsAdapter implements com.google.android.exoplayer2.source.ProgressiveMediaExtractor {
    public final com.google.android.exoplayer2.extractor.ExtractorsFactory a;

    @androidx.annotation.Nullable
    public com.google.android.exoplayer2.extractor.Extractor b;

    @androidx.annotation.Nullable
    public com.google.android.exoplayer2.extractor.ExtractorInput c;

    public BundledExtractorsAdapter(com.google.android.exoplayer2.extractor.ExtractorsFactory extractorsFactory) {
        this.a = extractorsFactory;
    }

    @Override // com.google.android.exoplayer2.source.ProgressiveMediaExtractor
    public int a(com.google.android.exoplayer2.extractor.PositionHolder positionHolder) throws java.io.IOException {
        return ((com.google.android.exoplayer2.extractor.Extractor) com.google.android.exoplayer2.util.Assertions.checkNotNull(this.b)).read((com.google.android.exoplayer2.extractor.ExtractorInput) com.google.android.exoplayer2.util.Assertions.checkNotNull(this.c), positionHolder);
    }

    @Override // com.google.android.exoplayer2.source.ProgressiveMediaExtractor
    public long b() {
        com.google.android.exoplayer2.extractor.ExtractorInput extractorInput = this.c;
        if (extractorInput != null) {
            return extractorInput.getPosition();
        }
        return -1L;
    }

    @Override // com.google.android.exoplayer2.source.ProgressiveMediaExtractor
    public void c() {
        com.google.android.exoplayer2.extractor.Extractor extractor = this.b;
        if (extractor instanceof com.google.android.exoplayer2.extractor.mp3.Mp3Extractor) {
            ((com.google.android.exoplayer2.extractor.mp3.Mp3Extractor) extractor).disableSeeking();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x003f, code lost:
    
        if (r6.getPosition() != r11) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0065, code lost:
    
        r1 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0062, code lost:
    
        if (r6.getPosition() != r11) goto L33;
     */
    @Override // com.google.android.exoplayer2.source.ProgressiveMediaExtractor
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void d(com.google.android.exoplayer2.upstream.DataReader dataReader, android.net.Uri uri, java.util.Map<java.lang.String, java.util.List<java.lang.String>> map, long j, long j2, com.google.android.exoplayer2.extractor.ExtractorOutput extractorOutput) throws java.io.IOException {
        com.google.android.exoplayer2.extractor.DefaultExtractorInput defaultExtractorInput = new com.google.android.exoplayer2.extractor.DefaultExtractorInput(dataReader, j, j2);
        this.c = defaultExtractorInput;
        if (this.b != null) {
            return;
        }
        com.google.android.exoplayer2.extractor.Extractor[] createExtractors = this.a.createExtractors(uri, map);
        if (createExtractors.length == 1) {
            this.b = createExtractors[0];
        } else {
            int length = createExtractors.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    break;
                }
                com.google.android.exoplayer2.extractor.Extractor extractor = createExtractors[i];
                try {
                } catch (java.io.EOFException unused) {
                    if (this.b == null) {
                    }
                } catch (java.lang.Throwable th) {
                    com.google.android.exoplayer2.util.Assertions.checkState(this.b != null || defaultExtractorInput.getPosition() == j);
                    defaultExtractorInput.resetPeekPosition();
                    throw th;
                }
                if (extractor.sniff(defaultExtractorInput)) {
                    this.b = extractor;
                    com.google.android.exoplayer2.util.Assertions.checkState(true);
                    defaultExtractorInput.resetPeekPosition();
                    break;
                } else {
                    if (this.b == null) {
                    }
                    boolean z = true;
                    com.google.android.exoplayer2.util.Assertions.checkState(z);
                    defaultExtractorInput.resetPeekPosition();
                    i++;
                }
            }
            if (this.b == null) {
                java.lang.String commaDelimitedSimpleClassNames = com.google.android.exoplayer2.util.Util.getCommaDelimitedSimpleClassNames(createExtractors);
                java.lang.StringBuilder sb = new java.lang.StringBuilder(java.lang.String.valueOf(commaDelimitedSimpleClassNames).length() + 58);
                sb.append("None of the available extractors (");
                sb.append(commaDelimitedSimpleClassNames);
                sb.append(") could read the stream.");
                throw new com.google.android.exoplayer2.source.UnrecognizedInputFormatException(sb.toString(), (android.net.Uri) com.google.android.exoplayer2.util.Assertions.checkNotNull(uri));
            }
        }
        this.b.init(extractorOutput);
    }

    @Override // com.google.android.exoplayer2.source.ProgressiveMediaExtractor
    public void release() {
        com.google.android.exoplayer2.extractor.Extractor extractor = this.b;
        if (extractor != null) {
            extractor.release();
            this.b = null;
        }
        this.c = null;
    }

    @Override // com.google.android.exoplayer2.source.ProgressiveMediaExtractor
    public void seek(long j, long j2) {
        ((com.google.android.exoplayer2.extractor.Extractor) com.google.android.exoplayer2.util.Assertions.checkNotNull(this.b)).seek(j, j2);
    }
}
