package com.google.android.exoplayer2.source.dash.offline;

/* loaded from: classes22.dex */
public final class DashDownloader extends com.google.android.exoplayer2.offline.SegmentDownloader<com.google.android.exoplayer2.source.dash.manifest.DashManifest> {

    /* renamed from: com.google.android.exoplayer2.source.dash.offline.DashDownloader$1, reason: invalid class name */
    public class AnonymousClass1 extends com.google.android.exoplayer2.util.RunnableFutureTask<com.google.android.exoplayer2.extractor.ChunkIndex, java.io.IOException> {
        public final /* synthetic */ int A;
        public final /* synthetic */ com.google.android.exoplayer2.source.dash.manifest.Representation B;
        public final /* synthetic */ com.google.android.exoplayer2.upstream.DataSource z;

        public AnonymousClass1(com.google.android.exoplayer2.source.dash.offline.DashDownloader dashDownloader, com.google.android.exoplayer2.upstream.DataSource dataSource, int i, com.google.android.exoplayer2.source.dash.manifest.Representation representation) {
            this.z = dataSource;
            this.A = i;
            this.B = representation;
        }

        @Override // com.google.android.exoplayer2.util.RunnableFutureTask
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public com.google.android.exoplayer2.extractor.ChunkIndex doWork() throws java.io.IOException {
            return com.google.android.exoplayer2.source.dash.DashUtil.loadChunkIndex(this.z, this.A, this.B);
        }
    }

    @java.lang.Deprecated
    public DashDownloader(android.net.Uri uri, java.util.List<com.google.android.exoplayer2.offline.StreamKey> list, com.google.android.exoplayer2.upstream.cache.CacheDataSource.Factory factory) {
        this(uri, list, factory, new defpackage.jz());
    }

    @java.lang.Deprecated
    public DashDownloader(android.net.Uri uri, java.util.List<com.google.android.exoplayer2.offline.StreamKey> list, com.google.android.exoplayer2.upstream.cache.CacheDataSource.Factory factory, java.util.concurrent.Executor executor) {
        this(new com.google.android.exoplayer2.MediaItem.Builder().setUri(uri).setStreamKeys(list).build(), factory, executor);
    }

    public DashDownloader(com.google.android.exoplayer2.MediaItem mediaItem, com.google.android.exoplayer2.upstream.ParsingLoadable.Parser<com.google.android.exoplayer2.source.dash.manifest.DashManifest> parser, com.google.android.exoplayer2.upstream.cache.CacheDataSource.Factory factory, java.util.concurrent.Executor executor) {
        super(mediaItem, parser, factory, executor);
    }

    public DashDownloader(com.google.android.exoplayer2.MediaItem mediaItem, com.google.android.exoplayer2.upstream.cache.CacheDataSource.Factory factory) {
        this(mediaItem, factory, new defpackage.jz());
    }

    public DashDownloader(com.google.android.exoplayer2.MediaItem mediaItem, com.google.android.exoplayer2.upstream.cache.CacheDataSource.Factory factory, java.util.concurrent.Executor executor) {
        this(mediaItem, new com.google.android.exoplayer2.source.dash.manifest.DashManifestParser(), factory, executor);
    }

    public static void g(long j, java.lang.String str, com.google.android.exoplayer2.source.dash.manifest.RangedUri rangedUri, java.util.ArrayList<com.google.android.exoplayer2.offline.SegmentDownloader.Segment> arrayList) {
        arrayList.add(new com.google.android.exoplayer2.offline.SegmentDownloader.Segment(j, new com.google.android.exoplayer2.upstream.DataSpec(rangedUri.resolveUri(str), rangedUri.start, rangedUri.length)));
    }

    @Override // com.google.android.exoplayer2.offline.SegmentDownloader
    public java.util.List<com.google.android.exoplayer2.offline.SegmentDownloader.Segment> getSegments(com.google.android.exoplayer2.upstream.DataSource dataSource, com.google.android.exoplayer2.source.dash.manifest.DashManifest dashManifest, boolean z) throws java.io.IOException, java.lang.InterruptedException {
        java.util.ArrayList<com.google.android.exoplayer2.offline.SegmentDownloader.Segment> arrayList = new java.util.ArrayList<>();
        for (int i = 0; i < dashManifest.getPeriodCount(); i++) {
            com.google.android.exoplayer2.source.dash.manifest.Period period = dashManifest.getPeriod(i);
            long msToUs = com.google.android.exoplayer2.C.msToUs(period.startMs);
            long periodDurationUs = dashManifest.getPeriodDurationUs(i);
            int i2 = 0;
            for (java.util.List<com.google.android.exoplayer2.source.dash.manifest.AdaptationSet> list = period.adaptationSets; i2 < list.size(); list = list) {
                h(dataSource, list.get(i2), msToUs, periodDurationUs, z, arrayList);
                i2++;
            }
        }
        return arrayList;
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x0089 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0084 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void h(com.google.android.exoplayer2.upstream.DataSource dataSource, com.google.android.exoplayer2.source.dash.manifest.AdaptationSet adaptationSet, long j, long j2, boolean z, java.util.ArrayList<com.google.android.exoplayer2.offline.SegmentDownloader.Segment> arrayList) throws java.io.IOException, java.lang.InterruptedException {
        com.google.android.exoplayer2.source.dash.DashSegmentIndex i;
        com.google.android.exoplayer2.source.dash.manifest.AdaptationSet adaptationSet2 = adaptationSet;
        int i2 = 0;
        while (i2 < adaptationSet2.representations.size()) {
            com.google.android.exoplayer2.source.dash.manifest.Representation representation = adaptationSet2.representations.get(i2);
            try {
                try {
                    i = i(dataSource, adaptationSet2.type, representation, z);
                } catch (java.io.IOException e) {
                    e = e;
                    if (z) {
                        throw e;
                    }
                    i2++;
                    adaptationSet2 = adaptationSet;
                }
            } catch (java.io.IOException e2) {
                e = e2;
            }
            if (i != null) {
                int segmentCount = i.getSegmentCount(j2);
                if (segmentCount == -1) {
                    throw new com.google.android.exoplayer2.offline.DownloadException("Unbounded segment index");
                }
                java.lang.String str = representation.baseUrl;
                com.google.android.exoplayer2.source.dash.manifest.RangedUri initializationUri = representation.getInitializationUri();
                if (initializationUri != null) {
                    g(j, str, initializationUri, arrayList);
                }
                com.google.android.exoplayer2.source.dash.manifest.RangedUri indexUri = representation.getIndexUri();
                if (indexUri != null) {
                    g(j, str, indexUri, arrayList);
                }
                long firstSegmentNum = i.getFirstSegmentNum();
                for (long j3 = (segmentCount + firstSegmentNum) - 1; firstSegmentNum <= j3; j3 = j3) {
                    g(j + i.getTimeUs(firstSegmentNum), str, i.getSegmentUrl(firstSegmentNum), arrayList);
                    firstSegmentNum++;
                }
                i2++;
                adaptationSet2 = adaptationSet;
            } else {
                try {
                    throw new com.google.android.exoplayer2.offline.DownloadException("Missing segment index");
                } catch (java.io.IOException e3) {
                    e = e3;
                    if (z) {
                    }
                }
            }
        }
    }

    @androidx.annotation.Nullable
    public final com.google.android.exoplayer2.source.dash.DashSegmentIndex i(com.google.android.exoplayer2.upstream.DataSource dataSource, int i, com.google.android.exoplayer2.source.dash.manifest.Representation representation, boolean z) throws java.io.IOException, java.lang.InterruptedException {
        com.google.android.exoplayer2.source.dash.DashSegmentIndex index = representation.getIndex();
        if (index != null) {
            return index;
        }
        com.google.android.exoplayer2.extractor.ChunkIndex chunkIndex = (com.google.android.exoplayer2.extractor.ChunkIndex) execute(new com.google.android.exoplayer2.source.dash.offline.DashDownloader.AnonymousClass1(this, dataSource, i, representation), z);
        if (chunkIndex == null) {
            return null;
        }
        return new com.google.android.exoplayer2.source.dash.DashWrappingSegmentIndex(chunkIndex, representation.presentationTimeOffsetUs);
    }
}
