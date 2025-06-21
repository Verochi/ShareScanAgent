package tv.danmaku.ijk.media.player;

/* loaded from: classes21.dex */
public interface IMediaPlayer {
    public static final int MEDIA_ERROR_IO = -1004;
    public static final int MEDIA_ERROR_MALFORMED = -1007;
    public static final int MEDIA_ERROR_NOT_VALID_FOR_PROGRESSIVE_PLAYBACK = 200;
    public static final int MEDIA_ERROR_SERVER_DIED = 100;
    public static final int MEDIA_ERROR_TIMED_OUT = -110;
    public static final int MEDIA_ERROR_UNKNOWN = 1;
    public static final int MEDIA_ERROR_UNSUPPORTED = -1010;
    public static final int MEDIA_INFO_AUDIO_DECODED_START = 10003;
    public static final int MEDIA_INFO_AUDIO_RENDERING_START = 10002;
    public static final int MEDIA_INFO_AUDIO_SEEK_RENDERING_START = 10009;
    public static final int MEDIA_INFO_BAD_INTERLEAVING = 800;
    public static final int MEDIA_INFO_BUFFERING_END = 702;
    public static final int MEDIA_INFO_BUFFERING_START = 701;
    public static final int MEDIA_INFO_COMPONENT_OPEN = 10007;
    public static final int MEDIA_INFO_FIND_STREAM_INFO = 10006;
    public static final int MEDIA_INFO_MEDIA_ACCURATE_SEEK_COMPLETE = 10100;
    public static final int MEDIA_INFO_METADATA_UPDATE = 802;
    public static final int MEDIA_INFO_NETWORK_BANDWIDTH = 703;
    public static final int MEDIA_INFO_NOT_SEEKABLE = 801;
    public static final int MEDIA_INFO_OPEN_INPUT = 10005;
    public static final int MEDIA_INFO_STARTED_AS_NEXT = 2;
    public static final int MEDIA_INFO_SUBTITLE_TIMED_OUT = 902;
    public static final int MEDIA_INFO_TIMED_TEXT_ERROR = 900;
    public static final int MEDIA_INFO_UNKNOWN = 1;
    public static final int MEDIA_INFO_UNSUPPORTED_SUBTITLE = 901;
    public static final int MEDIA_INFO_VIDEO_DECODED_START = 10004;
    public static final int MEDIA_INFO_VIDEO_RENDERING_START = 3;
    public static final int MEDIA_INFO_VIDEO_ROTATION_CHANGED = 10001;
    public static final int MEDIA_INFO_VIDEO_SEEK_RENDERING_START = 10008;
    public static final int MEDIA_INFO_VIDEO_TRACK_LAGGING = 700;

    public interface OnBufferingUpdateListener {
        void onBufferingUpdate(tv.danmaku.ijk.media.player.IMediaPlayer iMediaPlayer, int i);
    }

    public interface OnCompletionListener {
        void onCompletion(tv.danmaku.ijk.media.player.IMediaPlayer iMediaPlayer);
    }

    public interface OnErrorListener {
        boolean onError(tv.danmaku.ijk.media.player.IMediaPlayer iMediaPlayer, int i, int i2);
    }

    public interface OnInfoListener {
        boolean onInfo(tv.danmaku.ijk.media.player.IMediaPlayer iMediaPlayer, int i, int i2);
    }

    public interface OnPreparedListener {
        void onPrepared(tv.danmaku.ijk.media.player.IMediaPlayer iMediaPlayer);
    }

    public interface OnSeekCompleteListener {
        void onSeekComplete(tv.danmaku.ijk.media.player.IMediaPlayer iMediaPlayer);
    }

    public interface OnTimedTextListener {
        void onTimedText(tv.danmaku.ijk.media.player.IMediaPlayer iMediaPlayer, tv.danmaku.ijk.media.player.IjkTimedText ijkTimedText);
    }

    public interface OnVideoSizeChangedListener {
        void onVideoSizeChanged(tv.danmaku.ijk.media.player.IMediaPlayer iMediaPlayer, int i, int i2, int i3, int i4);
    }

    int getAudioSessionId();

    long getCurrentPosition();

    java.lang.String getDataSource();

    long getDuration();

    tv.danmaku.ijk.media.player.MediaInfo getMediaInfo();

    tv.danmaku.ijk.media.player.misc.ITrackInfo[] getTrackInfo();

    int getVideoHeight();

    int getVideoSarDen();

    int getVideoSarNum();

    int getVideoWidth();

    boolean isLooping();

    @java.lang.Deprecated
    boolean isPlayable();

    boolean isPlaying();

    void pause() throws java.lang.IllegalStateException;

    void prepareAsync() throws java.lang.IllegalStateException;

    void release();

    void reset();

    void seekTo(long j) throws java.lang.IllegalStateException;

    void setAudioStreamType(int i);

    void setDataSource(android.content.Context context, android.net.Uri uri) throws java.io.IOException, java.lang.IllegalArgumentException, java.lang.SecurityException, java.lang.IllegalStateException;

    @android.annotation.TargetApi(14)
    void setDataSource(android.content.Context context, android.net.Uri uri, java.util.Map<java.lang.String, java.lang.String> map) throws java.io.IOException, java.lang.IllegalArgumentException, java.lang.SecurityException, java.lang.IllegalStateException;

    void setDataSource(java.io.FileDescriptor fileDescriptor) throws java.io.IOException, java.lang.IllegalArgumentException, java.lang.IllegalStateException;

    void setDataSource(java.lang.String str) throws java.io.IOException, java.lang.IllegalArgumentException, java.lang.SecurityException, java.lang.IllegalStateException;

    void setDataSource(tv.danmaku.ijk.media.player.misc.IMediaDataSource iMediaDataSource);

    void setDisplay(android.view.SurfaceHolder surfaceHolder);

    @java.lang.Deprecated
    void setKeepInBackground(boolean z);

    @java.lang.Deprecated
    void setLogEnabled(boolean z);

    void setLooping(boolean z);

    void setOnBufferingUpdateListener(tv.danmaku.ijk.media.player.IMediaPlayer.OnBufferingUpdateListener onBufferingUpdateListener);

    void setOnCompletionListener(tv.danmaku.ijk.media.player.IMediaPlayer.OnCompletionListener onCompletionListener);

    void setOnErrorListener(tv.danmaku.ijk.media.player.IMediaPlayer.OnErrorListener onErrorListener);

    void setOnInfoListener(tv.danmaku.ijk.media.player.IMediaPlayer.OnInfoListener onInfoListener);

    void setOnPreparedListener(tv.danmaku.ijk.media.player.IMediaPlayer.OnPreparedListener onPreparedListener);

    void setOnSeekCompleteListener(tv.danmaku.ijk.media.player.IMediaPlayer.OnSeekCompleteListener onSeekCompleteListener);

    void setOnTimedTextListener(tv.danmaku.ijk.media.player.IMediaPlayer.OnTimedTextListener onTimedTextListener);

    void setOnVideoSizeChangedListener(tv.danmaku.ijk.media.player.IMediaPlayer.OnVideoSizeChangedListener onVideoSizeChangedListener);

    void setScreenOnWhilePlaying(boolean z);

    void setSurface(android.view.Surface surface);

    void setVolume(float f, float f2);

    @java.lang.Deprecated
    void setWakeMode(android.content.Context context, int i);

    void start() throws java.lang.IllegalStateException;

    void stop() throws java.lang.IllegalStateException;
}
