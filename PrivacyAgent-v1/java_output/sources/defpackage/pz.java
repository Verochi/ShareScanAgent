package defpackage;

/* loaded from: classes22.dex */
public final /* synthetic */ class pz implements com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker.Factory {
    @Override // com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker.Factory
    public final com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker createTracker(com.google.android.exoplayer2.source.hls.HlsDataSourceFactory hlsDataSourceFactory, com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy loadErrorHandlingPolicy, com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistParserFactory hlsPlaylistParserFactory) {
        return new com.google.android.exoplayer2.source.hls.playlist.DefaultHlsPlaylistTracker(hlsDataSourceFactory, loadErrorHandlingPolicy, hlsPlaylistParserFactory);
    }
}
