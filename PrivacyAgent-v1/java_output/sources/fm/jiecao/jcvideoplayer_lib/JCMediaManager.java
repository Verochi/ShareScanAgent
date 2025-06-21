package fm.jiecao.jcvideoplayer_lib;

/* loaded from: classes9.dex */
public class JCMediaManager implements tv.danmaku.ijk.media.player.IMediaPlayer.OnPreparedListener, tv.danmaku.ijk.media.player.IMediaPlayer.OnCompletionListener, tv.danmaku.ijk.media.player.IMediaPlayer.OnBufferingUpdateListener, tv.danmaku.ijk.media.player.IMediaPlayer.OnSeekCompleteListener, tv.danmaku.ijk.media.player.IMediaPlayer.OnErrorListener, tv.danmaku.ijk.media.player.IMediaPlayer.OnVideoSizeChangedListener, tv.danmaku.ijk.media.player.IMediaPlayer.OnInfoListener {
    public static java.lang.String TAG = "JCMediaManager";
    public static tv.danmaku.ijk.media.player.IjkLibLoader j = new fm.jiecao.jcvideoplayer_lib.JCMediaManager.AnonymousClass1();
    public fm.jiecao.jcvideoplayer_lib.JCResizeTextureView b;
    public fm.jiecao.jcvideoplayer_lib.JCMediaManager.MediaHandler g;
    public android.os.Handler h;
    public fm.jiecao.jcvideoplayer_lib.ScreenSwitchUtils i;
    public int c = 0;
    public int d = 0;
    public boolean e = false;
    public boolean f = false;
    public tv.danmaku.ijk.media.player.IjkMediaPlayer a = new tv.danmaku.ijk.media.player.IjkMediaPlayer(j);

    /* renamed from: fm.jiecao.jcvideoplayer_lib.JCMediaManager$1, reason: invalid class name */
    public class AnonymousClass1 implements tv.danmaku.ijk.media.player.IjkLibLoader {
        @Override // tv.danmaku.ijk.media.player.IjkLibLoader
        public void loadLibrary(java.lang.String str) throws java.lang.UnsatisfiedLinkError, java.lang.SecurityException {
            java.lang.String localFilePath = "ijkffmpeg".equals(str) ? com.moji.dynamic.DynamicLoadManager.getLocalFilePath(com.moji.tool.AppDelegate.getAppContext(), com.moji.dynamic.DynamicLoadType.FFMPEG) : "ijksdl".equals(str) ? com.moji.dynamic.DynamicLoadManager.getLocalFilePath(com.moji.tool.AppDelegate.getAppContext(), com.moji.dynamic.DynamicLoadType.IJKSDL) : "ijkplayer".equals(str) ? com.moji.dynamic.DynamicLoadManager.getLocalFilePath(com.moji.tool.AppDelegate.getAppContext(), com.moji.dynamic.DynamicLoadType.IJKPLAYER) : null;
            com.moji.tool.log.MJLogger.i(fm.jiecao.jcvideoplayer_lib.JCMediaManager.TAG, "loadLibrary:" + str + ", change to:" + localFilePath);
            if (android.text.TextUtils.isEmpty(localFilePath)) {
                java.lang.System.loadLibrary(str);
            } else {
                fm.jiecao.jcvideoplayer_lib.JCLoaderHelper.fixSoLinkError(localFilePath);
                java.lang.System.load(localFilePath);
            }
        }
    }

    /* renamed from: fm.jiecao.jcvideoplayer_lib.JCMediaManager$2, reason: invalid class name */
    public class AnonymousClass2 implements java.lang.Runnable {
        public AnonymousClass2() {
        }

        @Override // java.lang.Runnable
        public void run() {
            fm.jiecao.jcvideoplayer_lib.JCMediaPlayerListener first = fm.jiecao.jcvideoplayer_lib.JCVideoPlayerManager.getFirst();
            if (first != null) {
                first.onPrepared();
            }
        }
    }

    /* renamed from: fm.jiecao.jcvideoplayer_lib.JCMediaManager$3, reason: invalid class name */
    public class AnonymousClass3 implements java.lang.Runnable {
        public AnonymousClass3() {
        }

        @Override // java.lang.Runnable
        public void run() {
            fm.jiecao.jcvideoplayer_lib.JCMediaPlayerListener first = fm.jiecao.jcvideoplayer_lib.JCVideoPlayerManager.getFirst();
            if (first != null) {
                first.onAutoCompletion();
            }
        }
    }

    /* renamed from: fm.jiecao.jcvideoplayer_lib.JCMediaManager$4, reason: invalid class name */
    public class AnonymousClass4 implements java.lang.Runnable {
        public final /* synthetic */ int n;

        public AnonymousClass4(int i) {
            this.n = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            fm.jiecao.jcvideoplayer_lib.JCMediaPlayerListener first = fm.jiecao.jcvideoplayer_lib.JCVideoPlayerManager.getFirst();
            if (first != null) {
                first.onBufferingUpdate(this.n);
            }
        }
    }

    /* renamed from: fm.jiecao.jcvideoplayer_lib.JCMediaManager$5, reason: invalid class name */
    public class AnonymousClass5 implements java.lang.Runnable {
        public AnonymousClass5() {
        }

        @Override // java.lang.Runnable
        public void run() {
            fm.jiecao.jcvideoplayer_lib.JCMediaPlayerListener first = fm.jiecao.jcvideoplayer_lib.JCVideoPlayerManager.getFirst();
            if (first != null) {
                first.onSeekComplete();
            }
        }
    }

    /* renamed from: fm.jiecao.jcvideoplayer_lib.JCMediaManager$6, reason: invalid class name */
    public class AnonymousClass6 implements java.lang.Runnable {
        public final /* synthetic */ int n;
        public final /* synthetic */ int t;

        public AnonymousClass6(int i, int i2) {
            this.n = i;
            this.t = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            fm.jiecao.jcvideoplayer_lib.JCMediaPlayerListener first = fm.jiecao.jcvideoplayer_lib.JCVideoPlayerManager.getFirst();
            if (first != null) {
                first.onError(this.n, this.t);
            }
        }
    }

    /* renamed from: fm.jiecao.jcvideoplayer_lib.JCMediaManager$7, reason: invalid class name */
    public class AnonymousClass7 implements java.lang.Runnable {
        public final /* synthetic */ int n;
        public final /* synthetic */ int t;

        public AnonymousClass7(int i, int i2) {
            this.n = i;
            this.t = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            fm.jiecao.jcvideoplayer_lib.JCMediaPlayerListener first = fm.jiecao.jcvideoplayer_lib.JCVideoPlayerManager.getFirst();
            if (first != null) {
                first.onInfo(this.n, this.t);
            }
        }
    }

    /* renamed from: fm.jiecao.jcvideoplayer_lib.JCMediaManager$8, reason: invalid class name */
    public class AnonymousClass8 implements java.lang.Runnable {
        public AnonymousClass8() {
        }

        @Override // java.lang.Runnable
        public void run() {
            fm.jiecao.jcvideoplayer_lib.JCMediaPlayerListener first = fm.jiecao.jcvideoplayer_lib.JCVideoPlayerManager.getFirst();
            if (first != null) {
                first.onVideoSizeChanged();
            }
        }
    }

    public class FuckBean {
        public java.lang.String a;
        public java.util.Map<java.lang.String, java.lang.String> b;
        public boolean c;

        public FuckBean(java.lang.String str, java.util.Map<java.lang.String, java.lang.String> map, boolean z) {
            this.a = str;
            this.b = map;
            this.c = z;
        }
    }

    @androidx.annotation.RequiresApi(api = 14)
    public class MediaHandler extends android.os.Handler {

        /* renamed from: fm.jiecao.jcvideoplayer_lib.JCMediaManager$MediaHandler$1, reason: invalid class name */
        public class AnonymousClass1 implements java.lang.Runnable {
            public AnonymousClass1() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (fm.jiecao.jcvideoplayer_lib.JCMediaManager.this.b != null) {
                    fm.jiecao.jcvideoplayer_lib.JCMediaManager.this.b.requestLayout();
                }
            }
        }

        /* renamed from: fm.jiecao.jcvideoplayer_lib.JCMediaManager$MediaHandler$2, reason: invalid class name */
        public class AnonymousClass2 implements java.lang.Runnable {
            public AnonymousClass2() {
            }

            @Override // java.lang.Runnable
            public void run() {
                fm.jiecao.jcvideoplayer_lib.JCVideoPlayer.releaseAllVideos();
            }
        }

        public MediaHandler(android.os.Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(android.os.Message message) {
            super.handleMessage(message);
            switch (message.what) {
                case 0:
                    try {
                        fm.jiecao.jcvideoplayer_lib.JCMediaManager.this.c = 0;
                        fm.jiecao.jcvideoplayer_lib.JCMediaManager.this.d = 0;
                        if (fm.jiecao.jcvideoplayer_lib.JCMediaManager.this.a != null) {
                            fm.jiecao.jcvideoplayer_lib.JCMediaManager.this.a.release();
                        }
                        fm.jiecao.jcvideoplayer_lib.JCMediaManager.this.a = new tv.danmaku.ijk.media.player.IjkMediaPlayer(fm.jiecao.jcvideoplayer_lib.JCMediaManager.j);
                        fm.jiecao.jcvideoplayer_lib.JCMediaManager.this.a.setAudioStreamType(3);
                        tv.danmaku.ijk.media.player.IjkMediaPlayer ijkMediaPlayer = fm.jiecao.jcvideoplayer_lib.JCMediaManager.this.a;
                        java.lang.Object obj = message.obj;
                        ijkMediaPlayer.setDataSource(((fm.jiecao.jcvideoplayer_lib.JCMediaManager.FuckBean) obj).a, ((fm.jiecao.jcvideoplayer_lib.JCMediaManager.FuckBean) obj).b);
                        fm.jiecao.jcvideoplayer_lib.JCMediaManager.this.a.setLooping(((fm.jiecao.jcvideoplayer_lib.JCMediaManager.FuckBean) message.obj).c);
                        fm.jiecao.jcvideoplayer_lib.JCMediaManager.this.a.setOnPreparedListener(fm.jiecao.jcvideoplayer_lib.JCMediaManager.this);
                        fm.jiecao.jcvideoplayer_lib.JCMediaManager.this.a.setOnCompletionListener(fm.jiecao.jcvideoplayer_lib.JCMediaManager.this);
                        fm.jiecao.jcvideoplayer_lib.JCMediaManager.this.a.setOnBufferingUpdateListener(fm.jiecao.jcvideoplayer_lib.JCMediaManager.this);
                        fm.jiecao.jcvideoplayer_lib.JCMediaManager.this.a.setScreenOnWhilePlaying(true);
                        fm.jiecao.jcvideoplayer_lib.JCMediaManager.this.a.setOnSeekCompleteListener(fm.jiecao.jcvideoplayer_lib.JCMediaManager.this);
                        fm.jiecao.jcvideoplayer_lib.JCMediaManager.this.a.setOnErrorListener(fm.jiecao.jcvideoplayer_lib.JCMediaManager.this);
                        fm.jiecao.jcvideoplayer_lib.JCMediaManager.this.a.setOnInfoListener(fm.jiecao.jcvideoplayer_lib.JCMediaManager.this);
                        fm.jiecao.jcvideoplayer_lib.JCMediaManager.this.a.setOnVideoSizeChangedListener(fm.jiecao.jcvideoplayer_lib.JCMediaManager.this);
                        if (fm.jiecao.jcvideoplayer_lib.JCMediaManager.this.f) {
                            fm.jiecao.jcvideoplayer_lib.JCMediaManager.this.a.setVolume(0.0f, 0.0f);
                        }
                        fm.jiecao.jcvideoplayer_lib.JCMediaManager.this.a.prepareAsync();
                        break;
                    } catch (java.lang.Throwable th) {
                        com.moji.tool.log.MJLogger.postCatchedException(th);
                    }
                case 1:
                    if (message.obj == null && fm.jiecao.jcvideoplayer_lib.JCMediaManager.this.a != null) {
                        fm.jiecao.jcvideoplayer_lib.JCMediaManager.this.a.setSurface(null);
                        break;
                    } else {
                        android.view.Surface surface = (android.view.Surface) message.obj;
                        if (surface.isValid()) {
                            com.moji.tool.log.MJLogger.i(fm.jiecao.jcvideoplayer_lib.JCMediaManager.TAG, "set surface");
                            if (fm.jiecao.jcvideoplayer_lib.JCMediaManager.this.a != null) {
                                fm.jiecao.jcvideoplayer_lib.JCMediaManager.this.a.setSurface(surface);
                            }
                            fm.jiecao.jcvideoplayer_lib.JCMediaManager.this.h.post(new fm.jiecao.jcvideoplayer_lib.JCMediaManager.MediaHandler.AnonymousClass1());
                            break;
                        }
                    }
                    break;
                case 2:
                    if (fm.jiecao.jcvideoplayer_lib.JCMediaManager.this.a != null) {
                        fm.jiecao.jcvideoplayer_lib.JCMediaManager.this.a.reset();
                        fm.jiecao.jcvideoplayer_lib.JCMediaManager.this.a.release();
                    }
                    fm.jiecao.jcvideoplayer_lib.JCMediaManager.this.stopScreenSwitch();
                    fm.jiecao.jcvideoplayer_lib.JCMediaManager.this.b = null;
                    if (fm.jiecao.jcvideoplayer_lib.JCMediaManager.this.a == null) {
                        com.moji.tool.log.MJLogger.i(fm.jiecao.jcvideoplayer_lib.JCMediaManager.TAG, "mediaPlayer = null");
                    } else {
                        com.moji.tool.log.MJLogger.i(fm.jiecao.jcvideoplayer_lib.JCMediaManager.TAG, "mediaPlayer != null");
                    }
                    fm.jiecao.jcvideoplayer_lib.JCMediaManager.this.a = null;
                    break;
                case 3:
                    if (!fm.jiecao.jcvideoplayer_lib.JCMediaManager.this.isRelease()) {
                        com.moji.preferences.ActivityLifePrefer activityLifePrefer = com.moji.preferences.ActivityLifePrefer.getInstance();
                        if (activityLifePrefer.getStartCount() <= activityLifePrefer.getStopCount()) {
                            fm.jiecao.jcvideoplayer_lib.JCMediaManager.this.h.post(new fm.jiecao.jcvideoplayer_lib.JCMediaManager.MediaHandler.AnonymousClass2());
                            break;
                        } else {
                            fm.jiecao.jcvideoplayer_lib.JCMediaManager.this.a.start();
                            break;
                        }
                    }
                    break;
                case 4:
                    if (!fm.jiecao.jcvideoplayer_lib.JCMediaManager.this.isRelease()) {
                        fm.jiecao.jcvideoplayer_lib.JCMediaManager.this.a.pause();
                        break;
                    }
                    break;
                case 5:
                    if (!fm.jiecao.jcvideoplayer_lib.JCMediaManager.this.isRelease()) {
                        fm.jiecao.jcvideoplayer_lib.JCMediaManager.this.a.seekTo(((java.lang.Long) message.obj).longValue());
                        break;
                    }
                    break;
                case 6:
                    if (!fm.jiecao.jcvideoplayer_lib.JCMediaManager.this.isRelease()) {
                        fm.jiecao.jcvideoplayer_lib.JCMediaManager.this.a.setVolume(message.arg1, message.arg2);
                        break;
                    }
                    break;
            }
        }
    }

    public static class SingleHolder {
        public static final fm.jiecao.jcvideoplayer_lib.JCMediaManager a = new fm.jiecao.jcvideoplayer_lib.JCMediaManager();
    }

    public JCMediaManager() {
        android.os.HandlerThread handlerThread = new android.os.HandlerThread(TAG);
        handlerThread.start();
        this.g = new fm.jiecao.jcvideoplayer_lib.JCMediaManager.MediaHandler(handlerThread.getLooper());
        this.h = new android.os.Handler();
        this.i = fm.jiecao.jcvideoplayer_lib.ScreenSwitchUtils.init(com.moji.tool.AppDelegate.getAppContext());
    }

    public static synchronized fm.jiecao.jcvideoplayer_lib.JCMediaManager getInstance() {
        fm.jiecao.jcvideoplayer_lib.JCMediaManager jCMediaManager;
        synchronized (fm.jiecao.jcvideoplayer_lib.JCMediaManager.class) {
            jCMediaManager = fm.jiecao.jcvideoplayer_lib.JCMediaManager.SingleHolder.a;
        }
        return jCMediaManager;
    }

    public int getCurrentPosition() {
        tv.danmaku.ijk.media.player.IjkMediaPlayer ijkMediaPlayer = this.a;
        if (ijkMediaPlayer != null) {
            return (int) ijkMediaPlayer.getCurrentPosition();
        }
        return 0;
    }

    public java.lang.String getDataSource() {
        if (this.a == null) {
            com.moji.tool.log.MJLogger.i(TAG, "getDataSource:null");
            return null;
        }
        try {
            com.moji.tool.log.MJLogger.i(TAG, "getDataSource:not null");
            return this.a.getDataSource();
        } catch (java.lang.Exception e) {
            com.moji.tool.log.MJLogger.e(TAG, "getDataSource error:" + e.getMessage());
            return null;
        }
    }

    public int getDuration() {
        tv.danmaku.ijk.media.player.IjkMediaPlayer ijkMediaPlayer = this.a;
        if (ijkMediaPlayer != null) {
            return (int) ijkMediaPlayer.getDuration();
        }
        return 0;
    }

    public android.graphics.Point getVideoSize() {
        if (this.c == 0 || this.d == 0) {
            return null;
        }
        return new android.graphics.Point(this.c, this.d);
    }

    public boolean isFull() {
        return this.e;
    }

    public boolean isMute() {
        return this.f;
    }

    public boolean isPlaying() {
        if (this.a != null) {
            com.moji.tool.log.MJLogger.i(TAG, "isPlaying:not null");
            return this.a.isPlaying();
        }
        com.moji.tool.log.MJLogger.i(TAG, "isPlaying:null");
        return false;
    }

    public boolean isRelease() {
        return this.a == null;
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnBufferingUpdateListener
    public void onBufferingUpdate(tv.danmaku.ijk.media.player.IMediaPlayer iMediaPlayer, int i) {
        this.h.post(new fm.jiecao.jcvideoplayer_lib.JCMediaManager.AnonymousClass4(i));
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnCompletionListener
    public void onCompletion(tv.danmaku.ijk.media.player.IMediaPlayer iMediaPlayer) {
        this.h.post(new fm.jiecao.jcvideoplayer_lib.JCMediaManager.AnonymousClass3());
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnErrorListener
    public boolean onError(tv.danmaku.ijk.media.player.IMediaPlayer iMediaPlayer, int i, int i2) {
        this.h.post(new fm.jiecao.jcvideoplayer_lib.JCMediaManager.AnonymousClass6(i, i2));
        return true;
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnInfoListener
    public boolean onInfo(tv.danmaku.ijk.media.player.IMediaPlayer iMediaPlayer, int i, int i2) {
        this.h.post(new fm.jiecao.jcvideoplayer_lib.JCMediaManager.AnonymousClass7(i, i2));
        return false;
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnPreparedListener
    public void onPrepared(tv.danmaku.ijk.media.player.IMediaPlayer iMediaPlayer) {
        this.h.post(new fm.jiecao.jcvideoplayer_lib.JCMediaManager.AnonymousClass2());
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnSeekCompleteListener
    public void onSeekComplete(tv.danmaku.ijk.media.player.IMediaPlayer iMediaPlayer) {
        this.h.post(new fm.jiecao.jcvideoplayer_lib.JCMediaManager.AnonymousClass5());
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnVideoSizeChangedListener
    public void onVideoSizeChanged(tv.danmaku.ijk.media.player.IMediaPlayer iMediaPlayer, int i, int i2, int i3, int i4) {
        this.c = iMediaPlayer.getVideoWidth();
        this.d = iMediaPlayer.getVideoHeight();
        this.h.post(new fm.jiecao.jcvideoplayer_lib.JCMediaManager.AnonymousClass8());
    }

    public void pause() {
        if (this.a == null) {
            com.moji.tool.log.MJLogger.i(TAG, "pause:null");
        } else {
            com.moji.tool.log.MJLogger.i(TAG, "pause:not null");
            this.g.sendEmptyMessage(4);
        }
    }

    public void prepare(java.lang.String str, java.util.Map<java.lang.String, java.lang.String> map, boolean z) {
        if (android.text.TextUtils.isEmpty(str)) {
            return;
        }
        android.os.Message message = new android.os.Message();
        message.what = 0;
        message.obj = new fm.jiecao.jcvideoplayer_lib.JCMediaManager.FuckBean(str, map, z);
        this.g.sendMessage(message);
    }

    public void releaseMediaPlayer() {
        android.os.Message message = new android.os.Message();
        message.what = 2;
        this.g.sendMessage(message);
    }

    public void resetVideoSize() {
        this.d = 0;
        this.c = 0;
    }

    public void seekTo(long j2) {
        if (this.a == null) {
            com.moji.tool.log.MJLogger.i(TAG, "seekTo:null");
            return;
        }
        com.moji.tool.log.MJLogger.i(TAG, "seekTo:not null");
        android.os.Message message = new android.os.Message();
        message.what = 5;
        message.obj = java.lang.Long.valueOf(j2);
        this.g.sendMessage(message);
    }

    public void setDisplay(android.view.Surface surface, fm.jiecao.jcvideoplayer_lib.JCResizeTextureView jCResizeTextureView) {
        this.b = jCResizeTextureView;
        android.os.Message message = new android.os.Message();
        message.what = 1;
        message.obj = surface;
        this.g.sendMessage(message);
    }

    public void setIsFull(boolean z) {
        this.e = z;
    }

    public void setIsMute(boolean z) {
        this.f = z;
    }

    public void setVolume(int i, int i2) {
        if (this.a == null) {
            com.moji.tool.log.MJLogger.i(TAG, "setVolume:null");
            return;
        }
        com.moji.tool.log.MJLogger.i(TAG, "setVolume:not null");
        android.os.Message message = new android.os.Message();
        message.what = 6;
        message.arg1 = i;
        message.arg2 = i2;
        this.g.sendMessage(message);
    }

    public void start() {
        if (this.a == null) {
            com.moji.tool.log.MJLogger.i(TAG, "start:null");
        } else {
            com.moji.tool.log.MJLogger.i(TAG, "start:not null");
            this.g.sendEmptyMessage(3);
        }
    }

    public void startScreenSwitch(boolean z) {
        this.i.start(z);
    }

    public void stopScreenSwitch() {
        this.i.stop();
    }
}
