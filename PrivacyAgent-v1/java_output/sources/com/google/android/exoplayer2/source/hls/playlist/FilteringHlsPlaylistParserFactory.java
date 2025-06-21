package com.google.android.exoplayer2.source.hls.playlist;

/* loaded from: classes22.dex */
public final class FilteringHlsPlaylistParserFactory implements com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistParserFactory {
    public final com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistParserFactory a;
    public final java.util.List<com.google.android.exoplayer2.offline.StreamKey> b;

    public FilteringHlsPlaylistParserFactory(com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistParserFactory hlsPlaylistParserFactory, java.util.List<com.google.android.exoplayer2.offline.StreamKey> list) {
        this.a = hlsPlaylistParserFactory;
        this.b = list;
    }

    @Override // com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistParserFactory
    public com.google.android.exoplayer2.upstream.ParsingLoadable.Parser<com.google.android.exoplayer2.source.hls.playlist.HlsPlaylist> createPlaylistParser() {
        return new com.google.android.exoplayer2.offline.FilteringManifestParser(this.a.createPlaylistParser(), this.b);
    }

    @Override // com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistParserFactory
    public com.google.android.exoplayer2.upstream.ParsingLoadable.Parser<com.google.android.exoplayer2.source.hls.playlist.HlsPlaylist> createPlaylistParser(com.google.android.exoplayer2.source.hls.playlist.HlsMasterPlaylist hlsMasterPlaylist) {
        return new com.google.android.exoplayer2.offline.FilteringManifestParser(this.a.createPlaylistParser(hlsMasterPlaylist), this.b);
    }
}
