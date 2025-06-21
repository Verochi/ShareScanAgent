package com.google.android.exoplayer2.source.hls;

/* loaded from: classes22.dex */
public final class DefaultHlsExtractorFactory implements com.google.android.exoplayer2.source.hls.HlsExtractorFactory {
    public static final int[] c = {8, 13, 11, 2, 0, 1, 7};
    public final int a;
    public final boolean b;

    public DefaultHlsExtractorFactory() {
        this(0, true);
    }

    public DefaultHlsExtractorFactory(int i, boolean z) {
        this.a = i;
        this.b = z;
    }

    public static void a(int i, java.util.List<java.lang.Integer> list) {
        if (i == -1 || list.contains(java.lang.Integer.valueOf(i))) {
            return;
        }
        list.add(java.lang.Integer.valueOf(i));
    }

    public static com.google.android.exoplayer2.extractor.mp4.FragmentedMp4Extractor c(com.google.android.exoplayer2.util.TimestampAdjuster timestampAdjuster, com.google.android.exoplayer2.Format format, @androidx.annotation.Nullable java.util.List<com.google.android.exoplayer2.Format> list) {
        int i = e(format) ? 4 : 0;
        if (list == null) {
            list = java.util.Collections.emptyList();
        }
        return new com.google.android.exoplayer2.extractor.mp4.FragmentedMp4Extractor(i, timestampAdjuster, null, list);
    }

    public static com.google.android.exoplayer2.extractor.ts.TsExtractor d(int i, boolean z, com.google.android.exoplayer2.Format format, @androidx.annotation.Nullable java.util.List<com.google.android.exoplayer2.Format> list, com.google.android.exoplayer2.util.TimestampAdjuster timestampAdjuster) {
        int i2 = i | 16;
        if (list != null) {
            i2 |= 32;
        } else {
            list = z ? java.util.Collections.singletonList(new com.google.android.exoplayer2.Format.Builder().setSampleMimeType("application/cea-608").build()) : java.util.Collections.emptyList();
        }
        java.lang.String str = format.codecs;
        if (!android.text.TextUtils.isEmpty(str)) {
            if (!"audio/mp4a-latm".equals(com.google.android.exoplayer2.util.MimeTypes.getAudioMediaMimeType(str))) {
                i2 |= 2;
            }
            if (!"video/avc".equals(com.google.android.exoplayer2.util.MimeTypes.getVideoMediaMimeType(str))) {
                i2 |= 4;
            }
        }
        return new com.google.android.exoplayer2.extractor.ts.TsExtractor(2, timestampAdjuster, new com.google.android.exoplayer2.extractor.ts.DefaultTsPayloadReaderFactory(i2, list));
    }

    public static boolean e(com.google.android.exoplayer2.Format format) {
        com.google.android.exoplayer2.metadata.Metadata metadata = format.metadata;
        if (metadata == null) {
            return false;
        }
        for (int i = 0; i < metadata.length(); i++) {
            if (metadata.get(i) instanceof com.google.android.exoplayer2.source.hls.HlsTrackMetadataEntry) {
                return !((com.google.android.exoplayer2.source.hls.HlsTrackMetadataEntry) r2).variantInfos.isEmpty();
            }
        }
        return false;
    }

    public static boolean f(com.google.android.exoplayer2.extractor.Extractor extractor, com.google.android.exoplayer2.extractor.ExtractorInput extractorInput) throws java.io.IOException {
        try {
            boolean sniff = extractor.sniff(extractorInput);
            extractorInput.resetPeekPosition();
            return sniff;
        } catch (java.io.EOFException unused) {
            extractorInput.resetPeekPosition();
            return false;
        } catch (java.lang.Throwable th) {
            extractorInput.resetPeekPosition();
            throw th;
        }
    }

    @androidx.annotation.Nullable
    public final com.google.android.exoplayer2.extractor.Extractor b(int i, com.google.android.exoplayer2.Format format, @androidx.annotation.Nullable java.util.List<com.google.android.exoplayer2.Format> list, com.google.android.exoplayer2.util.TimestampAdjuster timestampAdjuster) {
        if (i == 0) {
            return new com.google.android.exoplayer2.extractor.ts.Ac3Extractor();
        }
        if (i == 1) {
            return new com.google.android.exoplayer2.extractor.ts.Ac4Extractor();
        }
        if (i == 2) {
            return new com.google.android.exoplayer2.extractor.ts.AdtsExtractor();
        }
        if (i == 7) {
            return new com.google.android.exoplayer2.extractor.mp3.Mp3Extractor(0, 0L);
        }
        if (i == 8) {
            return c(timestampAdjuster, format, list);
        }
        if (i == 11) {
            return d(this.a, this.b, format, list, timestampAdjuster);
        }
        if (i != 13) {
            return null;
        }
        return new com.google.android.exoplayer2.source.hls.WebvttExtractor(format.language, timestampAdjuster);
    }

    @Override // com.google.android.exoplayer2.source.hls.HlsExtractorFactory
    public com.google.android.exoplayer2.source.hls.BundledHlsMediaChunkExtractor createExtractor(android.net.Uri uri, com.google.android.exoplayer2.Format format, @androidx.annotation.Nullable java.util.List<com.google.android.exoplayer2.Format> list, com.google.android.exoplayer2.util.TimestampAdjuster timestampAdjuster, java.util.Map<java.lang.String, java.util.List<java.lang.String>> map, com.google.android.exoplayer2.extractor.ExtractorInput extractorInput) throws java.io.IOException {
        int inferFileTypeFromMimeType = com.google.android.exoplayer2.util.FileTypes.inferFileTypeFromMimeType(format.sampleMimeType);
        int inferFileTypeFromResponseHeaders = com.google.android.exoplayer2.util.FileTypes.inferFileTypeFromResponseHeaders(map);
        int inferFileTypeFromUri = com.google.android.exoplayer2.util.FileTypes.inferFileTypeFromUri(uri);
        int[] iArr = c;
        java.util.ArrayList arrayList = new java.util.ArrayList(iArr.length);
        a(inferFileTypeFromMimeType, arrayList);
        a(inferFileTypeFromResponseHeaders, arrayList);
        a(inferFileTypeFromUri, arrayList);
        for (int i : iArr) {
            a(i, arrayList);
        }
        extractorInput.resetPeekPosition();
        com.google.android.exoplayer2.extractor.Extractor extractor = null;
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            int intValue = ((java.lang.Integer) arrayList.get(i2)).intValue();
            com.google.android.exoplayer2.extractor.Extractor extractor2 = (com.google.android.exoplayer2.extractor.Extractor) com.google.android.exoplayer2.util.Assertions.checkNotNull(b(intValue, format, list, timestampAdjuster));
            if (f(extractor2, extractorInput)) {
                return new com.google.android.exoplayer2.source.hls.BundledHlsMediaChunkExtractor(extractor2, format, timestampAdjuster);
            }
            if (intValue == 11) {
                extractor = extractor2;
            }
        }
        return new com.google.android.exoplayer2.source.hls.BundledHlsMediaChunkExtractor((com.google.android.exoplayer2.extractor.Extractor) com.google.android.exoplayer2.util.Assertions.checkNotNull(extractor), format, timestampAdjuster);
    }

    @Override // com.google.android.exoplayer2.source.hls.HlsExtractorFactory
    public /* bridge */ /* synthetic */ com.google.android.exoplayer2.source.hls.HlsMediaChunkExtractor createExtractor(android.net.Uri uri, com.google.android.exoplayer2.Format format, @androidx.annotation.Nullable java.util.List list, com.google.android.exoplayer2.util.TimestampAdjuster timestampAdjuster, java.util.Map map, com.google.android.exoplayer2.extractor.ExtractorInput extractorInput) throws java.io.IOException {
        return createExtractor(uri, format, (java.util.List<com.google.android.exoplayer2.Format>) list, timestampAdjuster, (java.util.Map<java.lang.String, java.util.List<java.lang.String>>) map, extractorInput);
    }
}
