package com.google.android.exoplayer2.source.hls.offline;

/* loaded from: classes22.dex */
public final class HlsDownloader extends com.google.android.exoplayer2.offline.SegmentDownloader<com.google.android.exoplayer2.source.hls.playlist.HlsPlaylist> {
    @java.lang.Deprecated
    public HlsDownloader(android.net.Uri uri, java.util.List<com.google.android.exoplayer2.offline.StreamKey> list, com.google.android.exoplayer2.upstream.cache.CacheDataSource.Factory factory) {
        this(uri, list, factory, new defpackage.jz());
    }

    @java.lang.Deprecated
    public HlsDownloader(android.net.Uri uri, java.util.List<com.google.android.exoplayer2.offline.StreamKey> list, com.google.android.exoplayer2.upstream.cache.CacheDataSource.Factory factory, java.util.concurrent.Executor executor) {
        this(new com.google.android.exoplayer2.MediaItem.Builder().setUri(uri).setStreamKeys(list).build(), factory, executor);
    }

    public HlsDownloader(com.google.android.exoplayer2.MediaItem mediaItem, com.google.android.exoplayer2.upstream.ParsingLoadable.Parser<com.google.android.exoplayer2.source.hls.playlist.HlsPlaylist> parser, com.google.android.exoplayer2.upstream.cache.CacheDataSource.Factory factory, java.util.concurrent.Executor executor) {
        super(mediaItem, parser, factory, executor);
    }

    public HlsDownloader(com.google.android.exoplayer2.MediaItem mediaItem, com.google.android.exoplayer2.upstream.cache.CacheDataSource.Factory factory) {
        this(mediaItem, factory, new defpackage.jz());
    }

    public HlsDownloader(com.google.android.exoplayer2.MediaItem mediaItem, com.google.android.exoplayer2.upstream.cache.CacheDataSource.Factory factory, java.util.concurrent.Executor executor) {
        this(mediaItem, new com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistParser(), factory, executor);
    }

    public final void g(java.util.List<android.net.Uri> list, java.util.List<com.google.android.exoplayer2.upstream.DataSpec> list2) {
        for (int i = 0; i < list.size(); i++) {
            list2.add(com.google.android.exoplayer2.offline.SegmentDownloader.getCompressibleDataSpec(list.get(i)));
        }
    }

    @Override // com.google.android.exoplayer2.offline.SegmentDownloader
    public java.util.List<com.google.android.exoplayer2.offline.SegmentDownloader.Segment> getSegments(com.google.android.exoplayer2.upstream.DataSource dataSource, com.google.android.exoplayer2.source.hls.playlist.HlsPlaylist hlsPlaylist, boolean z) throws java.io.IOException, java.lang.InterruptedException {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        if (hlsPlaylist instanceof com.google.android.exoplayer2.source.hls.playlist.HlsMasterPlaylist) {
            g(((com.google.android.exoplayer2.source.hls.playlist.HlsMasterPlaylist) hlsPlaylist).mediaPlaylistUrls, arrayList);
        } else {
            arrayList.add(com.google.android.exoplayer2.offline.SegmentDownloader.getCompressibleDataSpec(android.net.Uri.parse(hlsPlaylist.baseUri)));
        }
        java.util.ArrayList<com.google.android.exoplayer2.offline.SegmentDownloader.Segment> arrayList2 = new java.util.ArrayList<>();
        java.util.HashSet<android.net.Uri> hashSet = new java.util.HashSet<>();
        java.util.Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            com.google.android.exoplayer2.upstream.DataSpec dataSpec = (com.google.android.exoplayer2.upstream.DataSpec) it.next();
            arrayList2.add(new com.google.android.exoplayer2.offline.SegmentDownloader.Segment(0L, dataSpec));
            try {
                com.google.android.exoplayer2.source.hls.playlist.HlsMediaPlaylist hlsMediaPlaylist = (com.google.android.exoplayer2.source.hls.playlist.HlsMediaPlaylist) getManifest(dataSource, dataSpec, z);
                java.util.List<com.google.android.exoplayer2.source.hls.playlist.HlsMediaPlaylist.Segment> list = hlsMediaPlaylist.segments;
                com.google.android.exoplayer2.source.hls.playlist.HlsMediaPlaylist.Segment segment = null;
                for (int i = 0; i < list.size(); i++) {
                    com.google.android.exoplayer2.source.hls.playlist.HlsMediaPlaylist.Segment segment2 = list.get(i);
                    com.google.android.exoplayer2.source.hls.playlist.HlsMediaPlaylist.Segment segment3 = segment2.initializationSegment;
                    if (segment3 != null && segment3 != segment) {
                        h(hlsMediaPlaylist, segment3, hashSet, arrayList2);
                        segment = segment3;
                    }
                    h(hlsMediaPlaylist, segment2, hashSet, arrayList2);
                }
            } catch (java.io.IOException e) {
                if (!z) {
                    throw e;
                }
            }
        }
        return arrayList2;
    }

    public final void h(com.google.android.exoplayer2.source.hls.playlist.HlsMediaPlaylist hlsMediaPlaylist, com.google.android.exoplayer2.source.hls.playlist.HlsMediaPlaylist.Segment segment, java.util.HashSet<android.net.Uri> hashSet, java.util.ArrayList<com.google.android.exoplayer2.offline.SegmentDownloader.Segment> arrayList) {
        java.lang.String str = hlsMediaPlaylist.baseUri;
        long j = hlsMediaPlaylist.startTimeUs + segment.relativeStartTimeUs;
        java.lang.String str2 = segment.fullSegmentEncryptionKeyUri;
        if (str2 != null) {
            android.net.Uri resolveToUri = com.google.android.exoplayer2.util.UriUtil.resolveToUri(str, str2);
            if (hashSet.add(resolveToUri)) {
                arrayList.add(new com.google.android.exoplayer2.offline.SegmentDownloader.Segment(j, com.google.android.exoplayer2.offline.SegmentDownloader.getCompressibleDataSpec(resolveToUri)));
            }
        }
        arrayList.add(new com.google.android.exoplayer2.offline.SegmentDownloader.Segment(j, new com.google.android.exoplayer2.upstream.DataSpec(com.google.android.exoplayer2.util.UriUtil.resolveToUri(str, segment.url), segment.byteRangeOffset, segment.byteRangeLength)));
    }
}
