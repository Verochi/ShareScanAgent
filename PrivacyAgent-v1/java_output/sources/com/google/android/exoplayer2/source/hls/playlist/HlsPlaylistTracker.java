package com.google.android.exoplayer2.source.hls.playlist;

/* loaded from: classes22.dex */
public interface HlsPlaylistTracker {

    public interface Factory {
        com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker createTracker(com.google.android.exoplayer2.source.hls.HlsDataSourceFactory hlsDataSourceFactory, com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy loadErrorHandlingPolicy, com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistParserFactory hlsPlaylistParserFactory);
    }

    public interface PlaylistEventListener {
        void onPlaylistChanged();

        boolean onPlaylistError(android.net.Uri uri, long j);
    }

    public static final class PlaylistResetException extends java.io.IOException {
        public final android.net.Uri url;

        public PlaylistResetException(android.net.Uri uri) {
            this.url = uri;
        }
    }

    public static final class PlaylistStuckException extends java.io.IOException {
        public final android.net.Uri url;

        public PlaylistStuckException(android.net.Uri uri) {
            this.url = uri;
        }
    }

    public interface PrimaryPlaylistListener {
        void onPrimaryPlaylistRefreshed(com.google.android.exoplayer2.source.hls.playlist.HlsMediaPlaylist hlsMediaPlaylist);
    }

    void addListener(com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker.PlaylistEventListener playlistEventListener);

    long getInitialStartTimeUs();

    @androidx.annotation.Nullable
    com.google.android.exoplayer2.source.hls.playlist.HlsMasterPlaylist getMasterPlaylist();

    @androidx.annotation.Nullable
    com.google.android.exoplayer2.source.hls.playlist.HlsMediaPlaylist getPlaylistSnapshot(android.net.Uri uri, boolean z);

    boolean isLive();

    boolean isSnapshotValid(android.net.Uri uri);

    void maybeThrowPlaylistRefreshError(android.net.Uri uri) throws java.io.IOException;

    void maybeThrowPrimaryPlaylistRefreshError() throws java.io.IOException;

    void refreshPlaylist(android.net.Uri uri);

    void removeListener(com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker.PlaylistEventListener playlistEventListener);

    void start(android.net.Uri uri, com.google.android.exoplayer2.source.MediaSourceEventListener.EventDispatcher eventDispatcher, com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker.PrimaryPlaylistListener primaryPlaylistListener);

    void stop();
}
