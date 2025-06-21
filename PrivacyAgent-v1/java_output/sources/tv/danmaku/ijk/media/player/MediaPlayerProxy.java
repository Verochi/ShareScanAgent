package tv.danmaku.ijk.media.player;

/* loaded from: classes21.dex */
public class MediaPlayerProxy implements tv.danmaku.ijk.media.player.IMediaPlayer {
    protected final tv.danmaku.ijk.media.player.IMediaPlayer mBackEndMediaPlayer;

    /* renamed from: tv.danmaku.ijk.media.player.MediaPlayerProxy$1, reason: invalid class name */
    public class AnonymousClass1 implements tv.danmaku.ijk.media.player.IMediaPlayer.OnPreparedListener {
        final /* synthetic */ tv.danmaku.ijk.media.player.IMediaPlayer.OnPreparedListener val$finalListener;

        public AnonymousClass1(tv.danmaku.ijk.media.player.IMediaPlayer.OnPreparedListener onPreparedListener) {
            this.val$finalListener = onPreparedListener;
        }

        @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnPreparedListener
        public void onPrepared(tv.danmaku.ijk.media.player.IMediaPlayer iMediaPlayer) {
            this.val$finalListener.onPrepared(tv.danmaku.ijk.media.player.MediaPlayerProxy.this);
        }
    }

    /* renamed from: tv.danmaku.ijk.media.player.MediaPlayerProxy$2, reason: invalid class name */
    public class AnonymousClass2 implements tv.danmaku.ijk.media.player.IMediaPlayer.OnCompletionListener {
        final /* synthetic */ tv.danmaku.ijk.media.player.IMediaPlayer.OnCompletionListener val$finalListener;

        public AnonymousClass2(tv.danmaku.ijk.media.player.IMediaPlayer.OnCompletionListener onCompletionListener) {
            this.val$finalListener = onCompletionListener;
        }

        @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnCompletionListener
        public void onCompletion(tv.danmaku.ijk.media.player.IMediaPlayer iMediaPlayer) {
            this.val$finalListener.onCompletion(tv.danmaku.ijk.media.player.MediaPlayerProxy.this);
        }
    }

    /* renamed from: tv.danmaku.ijk.media.player.MediaPlayerProxy$3, reason: invalid class name */
    public class AnonymousClass3 implements tv.danmaku.ijk.media.player.IMediaPlayer.OnBufferingUpdateListener {
        final /* synthetic */ tv.danmaku.ijk.media.player.IMediaPlayer.OnBufferingUpdateListener val$finalListener;

        public AnonymousClass3(tv.danmaku.ijk.media.player.IMediaPlayer.OnBufferingUpdateListener onBufferingUpdateListener) {
            this.val$finalListener = onBufferingUpdateListener;
        }

        @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnBufferingUpdateListener
        public void onBufferingUpdate(tv.danmaku.ijk.media.player.IMediaPlayer iMediaPlayer, int i) {
            this.val$finalListener.onBufferingUpdate(tv.danmaku.ijk.media.player.MediaPlayerProxy.this, i);
        }
    }

    /* renamed from: tv.danmaku.ijk.media.player.MediaPlayerProxy$4, reason: invalid class name */
    public class AnonymousClass4 implements tv.danmaku.ijk.media.player.IMediaPlayer.OnSeekCompleteListener {
        final /* synthetic */ tv.danmaku.ijk.media.player.IMediaPlayer.OnSeekCompleteListener val$finalListener;

        public AnonymousClass4(tv.danmaku.ijk.media.player.IMediaPlayer.OnSeekCompleteListener onSeekCompleteListener) {
            this.val$finalListener = onSeekCompleteListener;
        }

        @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnSeekCompleteListener
        public void onSeekComplete(tv.danmaku.ijk.media.player.IMediaPlayer iMediaPlayer) {
            this.val$finalListener.onSeekComplete(tv.danmaku.ijk.media.player.MediaPlayerProxy.this);
        }
    }

    /* renamed from: tv.danmaku.ijk.media.player.MediaPlayerProxy$5, reason: invalid class name */
    public class AnonymousClass5 implements tv.danmaku.ijk.media.player.IMediaPlayer.OnVideoSizeChangedListener {
        final /* synthetic */ tv.danmaku.ijk.media.player.IMediaPlayer.OnVideoSizeChangedListener val$finalListener;

        public AnonymousClass5(tv.danmaku.ijk.media.player.IMediaPlayer.OnVideoSizeChangedListener onVideoSizeChangedListener) {
            this.val$finalListener = onVideoSizeChangedListener;
        }

        @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnVideoSizeChangedListener
        public void onVideoSizeChanged(tv.danmaku.ijk.media.player.IMediaPlayer iMediaPlayer, int i, int i2, int i3, int i4) {
            this.val$finalListener.onVideoSizeChanged(tv.danmaku.ijk.media.player.MediaPlayerProxy.this, i, i2, i3, i4);
        }
    }

    /* renamed from: tv.danmaku.ijk.media.player.MediaPlayerProxy$6, reason: invalid class name */
    public class AnonymousClass6 implements tv.danmaku.ijk.media.player.IMediaPlayer.OnErrorListener {
        final /* synthetic */ tv.danmaku.ijk.media.player.IMediaPlayer.OnErrorListener val$finalListener;

        public AnonymousClass6(tv.danmaku.ijk.media.player.IMediaPlayer.OnErrorListener onErrorListener) {
            this.val$finalListener = onErrorListener;
        }

        @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnErrorListener
        public boolean onError(tv.danmaku.ijk.media.player.IMediaPlayer iMediaPlayer, int i, int i2) {
            return this.val$finalListener.onError(tv.danmaku.ijk.media.player.MediaPlayerProxy.this, i, i2);
        }
    }

    /* renamed from: tv.danmaku.ijk.media.player.MediaPlayerProxy$7, reason: invalid class name */
    public class AnonymousClass7 implements tv.danmaku.ijk.media.player.IMediaPlayer.OnInfoListener {
        final /* synthetic */ tv.danmaku.ijk.media.player.IMediaPlayer.OnInfoListener val$finalListener;

        public AnonymousClass7(tv.danmaku.ijk.media.player.IMediaPlayer.OnInfoListener onInfoListener) {
            this.val$finalListener = onInfoListener;
        }

        @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnInfoListener
        public boolean onInfo(tv.danmaku.ijk.media.player.IMediaPlayer iMediaPlayer, int i, int i2) {
            return this.val$finalListener.onInfo(tv.danmaku.ijk.media.player.MediaPlayerProxy.this, i, i2);
        }
    }

    /* renamed from: tv.danmaku.ijk.media.player.MediaPlayerProxy$8, reason: invalid class name */
    public class AnonymousClass8 implements tv.danmaku.ijk.media.player.IMediaPlayer.OnTimedTextListener {
        final /* synthetic */ tv.danmaku.ijk.media.player.IMediaPlayer.OnTimedTextListener val$finalListener;

        public AnonymousClass8(tv.danmaku.ijk.media.player.IMediaPlayer.OnTimedTextListener onTimedTextListener) {
            this.val$finalListener = onTimedTextListener;
        }

        @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnTimedTextListener
        public void onTimedText(tv.danmaku.ijk.media.player.IMediaPlayer iMediaPlayer, tv.danmaku.ijk.media.player.IjkTimedText ijkTimedText) {
            this.val$finalListener.onTimedText(tv.danmaku.ijk.media.player.MediaPlayerProxy.this, ijkTimedText);
        }
    }

    public MediaPlayerProxy(tv.danmaku.ijk.media.player.IMediaPlayer iMediaPlayer) {
        this.mBackEndMediaPlayer = iMediaPlayer;
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public int getAudioSessionId() {
        return this.mBackEndMediaPlayer.getAudioSessionId();
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public long getCurrentPosition() {
        return this.mBackEndMediaPlayer.getCurrentPosition();
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public java.lang.String getDataSource() {
        return this.mBackEndMediaPlayer.getDataSource();
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public long getDuration() {
        return this.mBackEndMediaPlayer.getDuration();
    }

    public tv.danmaku.ijk.media.player.IMediaPlayer getInternalMediaPlayer() {
        return this.mBackEndMediaPlayer;
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public tv.danmaku.ijk.media.player.MediaInfo getMediaInfo() {
        return this.mBackEndMediaPlayer.getMediaInfo();
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public tv.danmaku.ijk.media.player.misc.ITrackInfo[] getTrackInfo() {
        return this.mBackEndMediaPlayer.getTrackInfo();
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public int getVideoHeight() {
        return this.mBackEndMediaPlayer.getVideoHeight();
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public int getVideoSarDen() {
        return this.mBackEndMediaPlayer.getVideoSarDen();
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public int getVideoSarNum() {
        return this.mBackEndMediaPlayer.getVideoSarNum();
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public int getVideoWidth() {
        return this.mBackEndMediaPlayer.getVideoWidth();
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public boolean isLooping() {
        return this.mBackEndMediaPlayer.isLooping();
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public boolean isPlayable() {
        return false;
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public boolean isPlaying() {
        return this.mBackEndMediaPlayer.isPlaying();
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void pause() throws java.lang.IllegalStateException {
        this.mBackEndMediaPlayer.pause();
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void prepareAsync() throws java.lang.IllegalStateException {
        this.mBackEndMediaPlayer.prepareAsync();
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void release() {
        this.mBackEndMediaPlayer.release();
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void reset() {
        this.mBackEndMediaPlayer.reset();
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void seekTo(long j) throws java.lang.IllegalStateException {
        this.mBackEndMediaPlayer.seekTo(j);
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setAudioStreamType(int i) {
        this.mBackEndMediaPlayer.setAudioStreamType(i);
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setDataSource(android.content.Context context, android.net.Uri uri) throws java.io.IOException, java.lang.IllegalArgumentException, java.lang.SecurityException, java.lang.IllegalStateException {
        this.mBackEndMediaPlayer.setDataSource(context, uri);
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    @android.annotation.TargetApi(14)
    public void setDataSource(android.content.Context context, android.net.Uri uri, java.util.Map<java.lang.String, java.lang.String> map) throws java.io.IOException, java.lang.IllegalArgumentException, java.lang.SecurityException, java.lang.IllegalStateException {
        this.mBackEndMediaPlayer.setDataSource(context, uri, map);
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setDataSource(java.io.FileDescriptor fileDescriptor) throws java.io.IOException, java.lang.IllegalArgumentException, java.lang.IllegalStateException {
        this.mBackEndMediaPlayer.setDataSource(fileDescriptor);
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setDataSource(java.lang.String str) throws java.io.IOException, java.lang.IllegalArgumentException, java.lang.SecurityException, java.lang.IllegalStateException {
        this.mBackEndMediaPlayer.setDataSource(str);
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setDataSource(tv.danmaku.ijk.media.player.misc.IMediaDataSource iMediaDataSource) {
        this.mBackEndMediaPlayer.setDataSource(iMediaDataSource);
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setDisplay(android.view.SurfaceHolder surfaceHolder) {
        this.mBackEndMediaPlayer.setDisplay(surfaceHolder);
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setKeepInBackground(boolean z) {
        this.mBackEndMediaPlayer.setKeepInBackground(z);
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setLogEnabled(boolean z) {
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setLooping(boolean z) {
        this.mBackEndMediaPlayer.setLooping(z);
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setOnBufferingUpdateListener(tv.danmaku.ijk.media.player.IMediaPlayer.OnBufferingUpdateListener onBufferingUpdateListener) {
        if (onBufferingUpdateListener != null) {
            this.mBackEndMediaPlayer.setOnBufferingUpdateListener(new tv.danmaku.ijk.media.player.MediaPlayerProxy.AnonymousClass3(onBufferingUpdateListener));
        } else {
            this.mBackEndMediaPlayer.setOnBufferingUpdateListener(null);
        }
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setOnCompletionListener(tv.danmaku.ijk.media.player.IMediaPlayer.OnCompletionListener onCompletionListener) {
        if (onCompletionListener != null) {
            this.mBackEndMediaPlayer.setOnCompletionListener(new tv.danmaku.ijk.media.player.MediaPlayerProxy.AnonymousClass2(onCompletionListener));
        } else {
            this.mBackEndMediaPlayer.setOnCompletionListener(null);
        }
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setOnErrorListener(tv.danmaku.ijk.media.player.IMediaPlayer.OnErrorListener onErrorListener) {
        if (onErrorListener != null) {
            this.mBackEndMediaPlayer.setOnErrorListener(new tv.danmaku.ijk.media.player.MediaPlayerProxy.AnonymousClass6(onErrorListener));
        } else {
            this.mBackEndMediaPlayer.setOnErrorListener(null);
        }
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setOnInfoListener(tv.danmaku.ijk.media.player.IMediaPlayer.OnInfoListener onInfoListener) {
        if (onInfoListener != null) {
            this.mBackEndMediaPlayer.setOnInfoListener(new tv.danmaku.ijk.media.player.MediaPlayerProxy.AnonymousClass7(onInfoListener));
        } else {
            this.mBackEndMediaPlayer.setOnInfoListener(null);
        }
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setOnPreparedListener(tv.danmaku.ijk.media.player.IMediaPlayer.OnPreparedListener onPreparedListener) {
        if (onPreparedListener != null) {
            this.mBackEndMediaPlayer.setOnPreparedListener(new tv.danmaku.ijk.media.player.MediaPlayerProxy.AnonymousClass1(onPreparedListener));
        } else {
            this.mBackEndMediaPlayer.setOnPreparedListener(null);
        }
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setOnSeekCompleteListener(tv.danmaku.ijk.media.player.IMediaPlayer.OnSeekCompleteListener onSeekCompleteListener) {
        if (onSeekCompleteListener != null) {
            this.mBackEndMediaPlayer.setOnSeekCompleteListener(new tv.danmaku.ijk.media.player.MediaPlayerProxy.AnonymousClass4(onSeekCompleteListener));
        } else {
            this.mBackEndMediaPlayer.setOnSeekCompleteListener(null);
        }
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setOnTimedTextListener(tv.danmaku.ijk.media.player.IMediaPlayer.OnTimedTextListener onTimedTextListener) {
        if (onTimedTextListener != null) {
            this.mBackEndMediaPlayer.setOnTimedTextListener(new tv.danmaku.ijk.media.player.MediaPlayerProxy.AnonymousClass8(onTimedTextListener));
        } else {
            this.mBackEndMediaPlayer.setOnTimedTextListener(null);
        }
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setOnVideoSizeChangedListener(tv.danmaku.ijk.media.player.IMediaPlayer.OnVideoSizeChangedListener onVideoSizeChangedListener) {
        if (onVideoSizeChangedListener != null) {
            this.mBackEndMediaPlayer.setOnVideoSizeChangedListener(new tv.danmaku.ijk.media.player.MediaPlayerProxy.AnonymousClass5(onVideoSizeChangedListener));
        } else {
            this.mBackEndMediaPlayer.setOnVideoSizeChangedListener(null);
        }
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setScreenOnWhilePlaying(boolean z) {
        this.mBackEndMediaPlayer.setScreenOnWhilePlaying(z);
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    @android.annotation.TargetApi(14)
    public void setSurface(android.view.Surface surface) {
        this.mBackEndMediaPlayer.setSurface(surface);
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setVolume(float f, float f2) {
        this.mBackEndMediaPlayer.setVolume(f, f2);
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setWakeMode(android.content.Context context, int i) {
        this.mBackEndMediaPlayer.setWakeMode(context, i);
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void start() throws java.lang.IllegalStateException {
        this.mBackEndMediaPlayer.start();
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void stop() throws java.lang.IllegalStateException {
        this.mBackEndMediaPlayer.stop();
    }
}
