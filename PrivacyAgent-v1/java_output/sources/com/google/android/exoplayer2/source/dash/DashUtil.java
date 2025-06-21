package com.google.android.exoplayer2.source.dash;

/* loaded from: classes22.dex */
public final class DashUtil {
    @androidx.annotation.Nullable
    public static com.google.android.exoplayer2.source.dash.manifest.Representation a(com.google.android.exoplayer2.source.dash.manifest.Period period, int i) {
        int adaptationSetIndex = period.getAdaptationSetIndex(i);
        if (adaptationSetIndex == -1) {
            return null;
        }
        java.util.List<com.google.android.exoplayer2.source.dash.manifest.Representation> list = period.adaptationSets.get(adaptationSetIndex).representations;
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    public static void b(com.google.android.exoplayer2.source.chunk.ChunkExtractor chunkExtractor, com.google.android.exoplayer2.upstream.DataSource dataSource, com.google.android.exoplayer2.source.dash.manifest.Representation representation, boolean z) throws java.io.IOException {
        com.google.android.exoplayer2.source.dash.manifest.RangedUri rangedUri = (com.google.android.exoplayer2.source.dash.manifest.RangedUri) com.google.android.exoplayer2.util.Assertions.checkNotNull(representation.getInitializationUri());
        if (z) {
            com.google.android.exoplayer2.source.dash.manifest.RangedUri indexUri = representation.getIndexUri();
            if (indexUri == null) {
                return;
            }
            com.google.android.exoplayer2.source.dash.manifest.RangedUri attemptMerge = rangedUri.attemptMerge(indexUri, representation.baseUrl);
            if (attemptMerge == null) {
                c(dataSource, representation, chunkExtractor, rangedUri);
                rangedUri = indexUri;
            } else {
                rangedUri = attemptMerge;
            }
        }
        c(dataSource, representation, chunkExtractor, rangedUri);
    }

    public static com.google.android.exoplayer2.upstream.DataSpec buildDataSpec(com.google.android.exoplayer2.source.dash.manifest.Representation representation, com.google.android.exoplayer2.source.dash.manifest.RangedUri rangedUri) {
        return new com.google.android.exoplayer2.upstream.DataSpec.Builder().setUri(rangedUri.resolveUri(representation.baseUrl)).setPosition(rangedUri.start).setLength(rangedUri.length).setKey(representation.getCacheKey()).build();
    }

    public static void c(com.google.android.exoplayer2.upstream.DataSource dataSource, com.google.android.exoplayer2.source.dash.manifest.Representation representation, com.google.android.exoplayer2.source.chunk.ChunkExtractor chunkExtractor, com.google.android.exoplayer2.source.dash.manifest.RangedUri rangedUri) throws java.io.IOException {
        new com.google.android.exoplayer2.source.chunk.InitializationChunk(dataSource, buildDataSpec(representation, rangedUri), representation.format, 0, null, chunkExtractor).load();
    }

    public static com.google.android.exoplayer2.source.chunk.ChunkExtractor d(int i, com.google.android.exoplayer2.Format format) {
        java.lang.String str = format.containerMimeType;
        return new com.google.android.exoplayer2.source.chunk.BundledChunkExtractor(str != null && (str.startsWith("video/webm") || str.startsWith("audio/webm")) ? new com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor() : new com.google.android.exoplayer2.extractor.mp4.FragmentedMp4Extractor(), i, format);
    }

    @androidx.annotation.Nullable
    public static com.google.android.exoplayer2.extractor.ChunkIndex loadChunkIndex(com.google.android.exoplayer2.upstream.DataSource dataSource, int i, com.google.android.exoplayer2.source.dash.manifest.Representation representation) throws java.io.IOException {
        if (representation.getInitializationUri() == null) {
            return null;
        }
        com.google.android.exoplayer2.source.chunk.ChunkExtractor d = d(i, representation.format);
        try {
            b(d, dataSource, representation, true);
            d.release();
            return d.getChunkIndex();
        } catch (java.lang.Throwable th) {
            d.release();
            throw th;
        }
    }

    @androidx.annotation.Nullable
    public static com.google.android.exoplayer2.Format loadFormatWithDrmInitData(com.google.android.exoplayer2.upstream.DataSource dataSource, com.google.android.exoplayer2.source.dash.manifest.Period period) throws java.io.IOException {
        int i = 2;
        com.google.android.exoplayer2.source.dash.manifest.Representation a = a(period, 2);
        if (a == null) {
            i = 1;
            a = a(period, 1);
            if (a == null) {
                return null;
            }
        }
        com.google.android.exoplayer2.Format format = a.format;
        com.google.android.exoplayer2.Format loadSampleFormat = loadSampleFormat(dataSource, i, a);
        return loadSampleFormat == null ? format : loadSampleFormat.withManifestFormatInfo(format);
    }

    public static com.google.android.exoplayer2.source.dash.manifest.DashManifest loadManifest(com.google.android.exoplayer2.upstream.DataSource dataSource, android.net.Uri uri) throws java.io.IOException {
        return (com.google.android.exoplayer2.source.dash.manifest.DashManifest) com.google.android.exoplayer2.upstream.ParsingLoadable.load(dataSource, new com.google.android.exoplayer2.source.dash.manifest.DashManifestParser(), uri, 4);
    }

    @androidx.annotation.Nullable
    public static com.google.android.exoplayer2.Format loadSampleFormat(com.google.android.exoplayer2.upstream.DataSource dataSource, int i, com.google.android.exoplayer2.source.dash.manifest.Representation representation) throws java.io.IOException {
        if (representation.getInitializationUri() == null) {
            return null;
        }
        com.google.android.exoplayer2.source.chunk.ChunkExtractor d = d(i, representation.format);
        try {
            b(d, dataSource, representation, false);
            d.release();
            return ((com.google.android.exoplayer2.Format[]) com.google.android.exoplayer2.util.Assertions.checkStateNotNull(d.getSampleFormats()))[0];
        } catch (java.lang.Throwable th) {
            d.release();
            throw th;
        }
    }
}
