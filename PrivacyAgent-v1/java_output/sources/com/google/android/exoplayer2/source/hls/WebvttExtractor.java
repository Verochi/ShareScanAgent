package com.google.android.exoplayer2.source.hls;

/* loaded from: classes22.dex */
public final class WebvttExtractor implements com.google.android.exoplayer2.extractor.Extractor {
    public static final java.util.regex.Pattern g = java.util.regex.Pattern.compile("LOCAL:([^,]+)");
    public static final java.util.regex.Pattern h = java.util.regex.Pattern.compile("MPEGTS:(-?\\d+)");

    @androidx.annotation.Nullable
    public final java.lang.String a;
    public final com.google.android.exoplayer2.util.TimestampAdjuster b;
    public com.google.android.exoplayer2.extractor.ExtractorOutput d;
    public int f;
    public final com.google.android.exoplayer2.util.ParsableByteArray c = new com.google.android.exoplayer2.util.ParsableByteArray();
    public byte[] e = new byte[1024];

    public WebvttExtractor(@androidx.annotation.Nullable java.lang.String str, com.google.android.exoplayer2.util.TimestampAdjuster timestampAdjuster) {
        this.a = str;
        this.b = timestampAdjuster;
    }

    @org.checkerframework.checker.nullness.qual.RequiresNonNull({"output"})
    public final com.google.android.exoplayer2.extractor.TrackOutput a(long j) {
        com.google.android.exoplayer2.extractor.TrackOutput track = this.d.track(0, 3);
        track.format(new com.google.android.exoplayer2.Format.Builder().setSampleMimeType("text/vtt").setLanguage(this.a).setSubsampleOffsetUs(j).build());
        this.d.endTracks();
        return track;
    }

    @org.checkerframework.checker.nullness.qual.RequiresNonNull({"output"})
    public final void b() throws com.google.android.exoplayer2.ParserException {
        com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray = new com.google.android.exoplayer2.util.ParsableByteArray(this.e);
        com.google.android.exoplayer2.text.webvtt.WebvttParserUtil.validateWebvttHeaderLine(parsableByteArray);
        long j = 0;
        long j2 = 0;
        for (java.lang.String readLine = parsableByteArray.readLine(); !android.text.TextUtils.isEmpty(readLine); readLine = parsableByteArray.readLine()) {
            if (readLine.startsWith("X-TIMESTAMP-MAP")) {
                java.util.regex.Matcher matcher = g.matcher(readLine);
                if (!matcher.find()) {
                    throw new com.google.android.exoplayer2.ParserException(readLine.length() != 0 ? "X-TIMESTAMP-MAP doesn't contain local timestamp: ".concat(readLine) : new java.lang.String("X-TIMESTAMP-MAP doesn't contain local timestamp: "));
                }
                java.util.regex.Matcher matcher2 = h.matcher(readLine);
                if (!matcher2.find()) {
                    throw new com.google.android.exoplayer2.ParserException(readLine.length() != 0 ? "X-TIMESTAMP-MAP doesn't contain media timestamp: ".concat(readLine) : new java.lang.String("X-TIMESTAMP-MAP doesn't contain media timestamp: "));
                }
                j2 = com.google.android.exoplayer2.text.webvtt.WebvttParserUtil.parseTimestampUs((java.lang.String) com.google.android.exoplayer2.util.Assertions.checkNotNull(matcher.group(1)));
                j = com.google.android.exoplayer2.util.TimestampAdjuster.ptsToUs(java.lang.Long.parseLong((java.lang.String) com.google.android.exoplayer2.util.Assertions.checkNotNull(matcher2.group(1))));
            }
        }
        java.util.regex.Matcher findNextCueHeader = com.google.android.exoplayer2.text.webvtt.WebvttParserUtil.findNextCueHeader(parsableByteArray);
        if (findNextCueHeader == null) {
            a(0L);
            return;
        }
        long parseTimestampUs = com.google.android.exoplayer2.text.webvtt.WebvttParserUtil.parseTimestampUs((java.lang.String) com.google.android.exoplayer2.util.Assertions.checkNotNull(findNextCueHeader.group(1)));
        long adjustTsTimestamp = this.b.adjustTsTimestamp(com.google.android.exoplayer2.util.TimestampAdjuster.usToWrappedPts((j + parseTimestampUs) - j2));
        com.google.android.exoplayer2.extractor.TrackOutput a = a(adjustTsTimestamp - parseTimestampUs);
        this.c.reset(this.e, this.f);
        a.sampleData(this.c, this.f);
        a.sampleMetadata(adjustTsTimestamp, 1, this.f, 0, null);
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void init(com.google.android.exoplayer2.extractor.ExtractorOutput extractorOutput) {
        this.d = extractorOutput;
        extractorOutput.seekMap(new com.google.android.exoplayer2.extractor.SeekMap.Unseekable(-9223372036854775807L));
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public int read(com.google.android.exoplayer2.extractor.ExtractorInput extractorInput, com.google.android.exoplayer2.extractor.PositionHolder positionHolder) throws java.io.IOException {
        com.google.android.exoplayer2.util.Assertions.checkNotNull(this.d);
        int length = (int) extractorInput.getLength();
        int i = this.f;
        byte[] bArr = this.e;
        if (i == bArr.length) {
            this.e = java.util.Arrays.copyOf(bArr, ((length != -1 ? length : bArr.length) * 3) / 2);
        }
        byte[] bArr2 = this.e;
        int i2 = this.f;
        int read = extractorInput.read(bArr2, i2, bArr2.length - i2);
        if (read != -1) {
            int i3 = this.f + read;
            this.f = i3;
            if (length == -1 || i3 != length) {
                return 0;
            }
        }
        b();
        return -1;
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void release() {
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void seek(long j, long j2) {
        throw new java.lang.IllegalStateException();
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public boolean sniff(com.google.android.exoplayer2.extractor.ExtractorInput extractorInput) throws java.io.IOException {
        extractorInput.peekFully(this.e, 0, 6, false);
        this.c.reset(this.e, 6);
        if (com.google.android.exoplayer2.text.webvtt.WebvttParserUtil.isWebvttHeaderLine(this.c)) {
            return true;
        }
        extractorInput.peekFully(this.e, 6, 3, false);
        this.c.reset(this.e, 9);
        return com.google.android.exoplayer2.text.webvtt.WebvttParserUtil.isWebvttHeaderLine(this.c);
    }
}
