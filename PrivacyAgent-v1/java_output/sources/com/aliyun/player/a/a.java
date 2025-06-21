package com.aliyun.player.a;

/* loaded from: classes.dex */
public class a extends com.aliyun.player.ApasaraExternalPlayer {
    private com.aliyun.player.ApasaraExternalPlayer.OnStatusChangedListener A;
    private com.aliyun.player.ApasaraExternalPlayer.OnVideoRenderedListener B;
    private com.aliyun.player.ApasaraExternalPlayer.OnErrorListener C;
    private com.aliyun.player.ApasaraExternalPlayer.OnEventListener D;
    private com.aliyun.player.ApasaraExternalPlayer.OnStreamInfoGetListener E;
    private com.aliyun.player.ApasaraExternalPlayer.OnStreamSwitchSucListener F;
    private com.aliyun.player.ApasaraExternalPlayer.OnCaptureScreenListener G;
    private com.aliyun.player.ApasaraExternalPlayer.OnSubtitleListener H;
    private com.aliyun.player.ApasaraExternalPlayer.OnDRMCallback I;
    private long J;
    private boolean K;
    private java.util.Map<java.lang.String, java.lang.String> L;
    private final int a;
    private android.content.Context b;
    private android.media.MediaPlayer c;
    private android.media.MediaPlayer.TrackInfo[] d;
    private android.os.Handler e;
    private com.aliyun.player.ApasaraExternalPlayer.PlayerStatus f;
    private java.lang.String g;
    private long h;
    private float i;
    private com.aliyun.player.IPlayer.ScaleMode j;
    private boolean k;
    private boolean l;
    private java.lang.String m;
    private java.lang.String n;
    private float o;
    private boolean p;
    private com.aliyun.player.ApasaraExternalPlayer.OnPreparedListener q;
    private com.aliyun.player.ApasaraExternalPlayer.OnLoopingStartListener r;

    /* renamed from: s, reason: collision with root package name */
    private com.aliyun.player.ApasaraExternalPlayer.OnCompletionListener f90s;
    private com.aliyun.player.ApasaraExternalPlayer.OnFirstFrameRenderListener t;
    private com.aliyun.player.ApasaraExternalPlayer.OnLoadStatusListener u;
    private com.aliyun.player.ApasaraExternalPlayer.OnAutoPlayStartListener v;
    private com.aliyun.player.ApasaraExternalPlayer.OnSeekStatusListener w;
    private com.aliyun.player.ApasaraExternalPlayer.OnPositionUpdateListener x;
    private com.aliyun.player.ApasaraExternalPlayer.OnBufferPositionUpdateListener y;
    private com.aliyun.player.ApasaraExternalPlayer.OnVideoSizeChangedListener z;

    /* renamed from: com.aliyun.player.a.a$a, reason: collision with other inner class name */
    public class HandlerC0052a extends android.os.Handler {
        public HandlerC0052a(android.os.Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(android.os.Message message) {
            if (message.what == 1000) {
                if (com.aliyun.player.a.a.this.f.getValue() >= com.aliyun.player.ApasaraExternalPlayer.PlayerStatus.PLAYER_PREPARED.getValue() && com.aliyun.player.a.a.this.f.getValue() <= com.aliyun.player.ApasaraExternalPlayer.PlayerStatus.PLAYER_STOPPED.getValue()) {
                    if (com.aliyun.player.a.a.this.y != null) {
                        com.aliyun.player.a.a.this.y.onBufferPositionUpdate(com.aliyun.player.a.a.this.getBufferPosition());
                    }
                    if (com.aliyun.player.a.a.this.x != null) {
                        com.aliyun.player.a.a.this.x.onPositionUpdate(com.aliyun.player.a.a.this.getPlayingPosition());
                    }
                }
                com.aliyun.player.a.a.this.b();
            }
            super.handleMessage(message);
        }
    }

    public class b implements android.media.MediaPlayer.OnBufferingUpdateListener {
        public b() {
        }

        @Override // android.media.MediaPlayer.OnBufferingUpdateListener
        public void onBufferingUpdate(android.media.MediaPlayer mediaPlayer, int i) {
            com.aliyun.player.a.a.this.h = (long) ((i * r5.getDuration()) / 100.0f);
        }
    }

    public class c implements android.media.MediaPlayer.OnCompletionListener {
        public c() {
        }

        @Override // android.media.MediaPlayer.OnCompletionListener
        public void onCompletion(android.media.MediaPlayer mediaPlayer) {
            if (com.aliyun.player.a.a.this.f90s != null) {
                com.aliyun.player.a.a.this.f90s.onCompletion();
            }
            com.aliyun.player.a.a.this.a(com.aliyun.player.ApasaraExternalPlayer.PlayerStatus.PLAYER_COMPLETION, true);
        }
    }

    public class d implements android.media.MediaPlayer.OnErrorListener {
        public d() {
        }

        @Override // android.media.MediaPlayer.OnErrorListener
        public boolean onError(android.media.MediaPlayer mediaPlayer, int i, int i2) {
            if (com.aliyun.player.a.a.this.C != null) {
                com.aliyun.player.a.a.this.C.onError(com.aliyun.player.bean.ErrorCode.ERROR_UNKNOWN.getValue(), "what=" + i + ", extra=" + i2);
            }
            com.aliyun.player.a.a.this.a(com.aliyun.player.ApasaraExternalPlayer.PlayerStatus.PLAYER_ERROR, true);
            return true;
        }
    }

    public class e implements android.media.MediaPlayer.OnInfoListener {
        public e() {
        }

        @Override // android.media.MediaPlayer.OnInfoListener
        public boolean onInfo(android.media.MediaPlayer mediaPlayer, int i, int i2) {
            if (i == 702) {
                if (com.aliyun.player.a.a.this.u == null) {
                    return false;
                }
                com.aliyun.player.a.a.this.u.onLoadingEnd();
                return false;
            }
            if (i == 701) {
                if (com.aliyun.player.a.a.this.u == null) {
                    return false;
                }
                com.aliyun.player.a.a.this.u.onLoadingStart();
                return false;
            }
            if (i != 3 || com.aliyun.player.a.a.this.t == null) {
                return false;
            }
            com.aliyun.player.a.a.this.t.onFirstFrameRender();
            return false;
        }
    }

    public class f implements android.media.MediaPlayer.OnPreparedListener {
        public f() {
        }

        @Override // android.media.MediaPlayer.OnPreparedListener
        public void onPrepared(android.media.MediaPlayer mediaPlayer) {
            com.aliyun.player.a.a aVar = com.aliyun.player.a.a.this;
            aVar.d = aVar.c.getTrackInfo();
            com.aliyun.player.a.a.this.a();
            if (com.aliyun.player.a.a.this.p) {
                if (com.aliyun.player.a.a.this.v != null) {
                    com.aliyun.player.a.a.this.v.onAutoPlayStart();
                }
                com.aliyun.player.a.a.this.a(com.aliyun.player.ApasaraExternalPlayer.PlayerStatus.PLAYER_PREPARED, false);
                com.aliyun.player.a.a.this.start();
            } else {
                com.aliyun.player.a.a.this.a(com.aliyun.player.ApasaraExternalPlayer.PlayerStatus.PLAYER_PREPARED, true);
                if (com.aliyun.player.a.a.this.q != null) {
                    com.aliyun.player.a.a.this.q.onPrepared();
                }
            }
            if (com.aliyun.player.a.a.this.J >= 0) {
                com.aliyun.player.a.a aVar2 = com.aliyun.player.a.a.this;
                aVar2.seekTo(aVar2.J, com.aliyun.player.a.a.this.K);
                com.aliyun.player.a.a.this.J = -1L;
            }
        }
    }

    public class g implements android.media.MediaPlayer.OnSeekCompleteListener {
        public g() {
        }

        @Override // android.media.MediaPlayer.OnSeekCompleteListener
        public void onSeekComplete(android.media.MediaPlayer mediaPlayer) {
            if (com.aliyun.player.a.a.this.w != null) {
                com.aliyun.player.a.a.this.w.onSeekEnd(false);
            }
        }
    }

    public class h implements android.media.MediaPlayer.OnTimedTextListener {
        public h() {
        }

        @Override // android.media.MediaPlayer.OnTimedTextListener
        public void onTimedText(android.media.MediaPlayer mediaPlayer, android.media.TimedText timedText) {
        }
    }

    public class i implements android.media.MediaPlayer.OnVideoSizeChangedListener {
        public i() {
        }

        @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
        public void onVideoSizeChanged(android.media.MediaPlayer mediaPlayer, int i, int i2) {
            if (com.aliyun.player.a.a.this.z != null) {
                com.aliyun.player.a.a.this.z.onVideoSizeChanged(i, i2);
            }
        }
    }

    public a() {
        this.a = 1000;
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = com.aliyun.player.ApasaraExternalPlayer.PlayerStatus.PLAYER_IDLE;
        this.g = null;
        this.h = 0L;
        this.i = 1.0f;
        this.j = com.aliyun.player.IPlayer.ScaleMode.SCALE_ASPECT_FIT;
        this.k = false;
        this.l = false;
        this.m = null;
        this.n = null;
        this.o = 1.0f;
        this.p = false;
        this.q = null;
        this.r = null;
        this.f90s = null;
        this.t = null;
        this.u = null;
        this.v = null;
        this.w = null;
        this.x = null;
        this.y = null;
        this.z = null;
        this.A = null;
        this.B = null;
        this.C = null;
        this.D = null;
        this.E = null;
        this.F = null;
        this.G = null;
        this.H = null;
        this.I = null;
        this.J = -1L;
        this.K = false;
        this.L = new java.util.HashMap();
    }

    private a(android.content.Context context, com.aliyun.player.nativeclass.Options options) {
        this.a = 1000;
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = com.aliyun.player.ApasaraExternalPlayer.PlayerStatus.PLAYER_IDLE;
        this.g = null;
        this.h = 0L;
        this.i = 1.0f;
        this.j = com.aliyun.player.IPlayer.ScaleMode.SCALE_ASPECT_FIT;
        this.k = false;
        this.l = false;
        this.m = null;
        this.n = null;
        this.o = 1.0f;
        this.p = false;
        this.q = null;
        this.r = null;
        this.f90s = null;
        this.t = null;
        this.u = null;
        this.v = null;
        this.w = null;
        this.x = null;
        this.y = null;
        this.z = null;
        this.A = null;
        this.B = null;
        this.C = null;
        this.D = null;
        this.E = null;
        this.F = null;
        this.G = null;
        this.H = null;
        this.I = null;
        this.J = -1L;
        this.K = false;
        this.L = new java.util.HashMap();
        this.b = context;
        android.os.Looper myLooper = android.os.Looper.myLooper();
        this.e = new com.aliyun.player.a.a.HandlerC0052a(myLooper == null ? android.os.Looper.getMainLooper() : myLooper);
        android.media.MediaPlayer mediaPlayer = new android.media.MediaPlayer();
        this.c = mediaPlayer;
        mediaPlayer.setOnBufferingUpdateListener(new com.aliyun.player.a.a.b());
        this.c.setOnCompletionListener(new com.aliyun.player.a.a.c());
        this.c.setOnErrorListener(new com.aliyun.player.a.a.d());
        this.c.setOnInfoListener(new com.aliyun.player.a.a.e());
        this.c.setOnPreparedListener(new com.aliyun.player.a.a.f());
        this.c.setOnSeekCompleteListener(new com.aliyun.player.a.a.g());
        this.c.setOnTimedTextListener(new com.aliyun.player.a.a.h());
        this.c.setOnVideoSizeChangedListener(new com.aliyun.player.a.a.i());
    }

    private com.aliyun.player.nativeclass.TrackInfo a(android.media.MediaPlayer.TrackInfo trackInfo, int i2) {
        com.aliyun.player.nativeclass.TrackInfo trackInfo2 = new com.aliyun.player.nativeclass.TrackInfo();
        trackInfo2.index = i2;
        int trackType = trackInfo.getTrackType();
        trackInfo2.mType = trackType == 2 ? com.aliyun.player.nativeclass.TrackInfo.Type.TYPE_AUDIO : trackType == 1 ? com.aliyun.player.nativeclass.TrackInfo.Type.TYPE_VIDEO : trackType == 4 ? com.aliyun.player.nativeclass.TrackInfo.Type.TYPE_SUBTITLE : com.aliyun.player.nativeclass.TrackInfo.Type.TYPE_VOD;
        trackInfo2.description = trackInfo.getLanguage();
        return trackInfo2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        if (this.E == null || this.d == null) {
            return;
        }
        com.aliyun.player.nativeclass.MediaInfo mediaInfo = new com.aliyun.player.nativeclass.MediaInfo();
        com.aliyun.player.nativeclass.TrackInfo[] trackInfoArr = new com.aliyun.player.nativeclass.TrackInfo[this.d.length];
        int i2 = 0;
        while (true) {
            android.media.MediaPlayer.TrackInfo[] trackInfoArr2 = this.d;
            if (i2 >= trackInfoArr2.length) {
                mediaInfo.setTrackInfos(trackInfoArr);
                mediaInfo.setDuration((int) getDuration());
                this.E.OnStreamInfoGet(mediaInfo);
                return;
            }
            trackInfoArr[i2] = a(trackInfoArr2[i2], i2);
            i2++;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.aliyun.player.ApasaraExternalPlayer.PlayerStatus playerStatus, boolean z) {
        com.aliyun.player.ApasaraExternalPlayer.OnStatusChangedListener onStatusChangedListener;
        if (this.f != playerStatus) {
            this.f = playerStatus;
            if (z && (onStatusChangedListener = this.A) != null) {
                onStatusChangedListener.onStatusChanged(playerStatus.getValue(), playerStatus.getValue());
            }
        }
        b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        this.e.removeMessages(1000);
        if (this.f.getValue() < com.aliyun.player.ApasaraExternalPlayer.PlayerStatus.PLAYER_PREPARED.getValue() || this.f.getValue() > com.aliyun.player.ApasaraExternalPlayer.PlayerStatus.PLAYER_STOPPED.getValue()) {
            return;
        }
        this.e.sendEmptyMessageDelayed(1000, 500L);
    }

    private void c() {
        if (this.c == null) {
            return;
        }
        java.util.HashMap hashMap = new java.util.HashMap();
        java.lang.String str = this.m;
        if (str != null) {
            hashMap.put(com.google.common.net.HttpHeaders.REFERER, str);
        }
        java.lang.String str2 = this.n;
        if (str2 != null) {
            hashMap.put("User-Agent", str2);
        }
        hashMap.putAll(this.L);
        try {
            this.c.setDataSource(this.b, android.net.Uri.parse(this.g), hashMap);
        } catch (java.io.IOException e2) {
            e2.printStackTrace();
            com.aliyun.player.ApasaraExternalPlayer.OnErrorListener onErrorListener = this.C;
            if (onErrorListener != null) {
                onErrorListener.onError(com.aliyun.player.bean.ErrorCode.ERROR_GENERAL_EIO.getValue(), "set dataSource error :" + e2.getMessage());
            }
        }
    }

    @Override // com.aliyun.player.ApasaraExternalPlayer
    public void addCustomHttpHeader(java.lang.String str) {
        com.cicada.player.utils.Logger.v("MediaPlayer", "addCustomHttpHeader() " + str);
        if (!android.text.TextUtils.isEmpty(str) || str.contains(com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR)) {
            java.lang.String[] split = str.split(com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR);
            this.L.put(split[0], split[1]);
        }
    }

    @Override // com.aliyun.player.ApasaraExternalPlayer
    public void addExtSubtitle(java.lang.String str) {
        com.cicada.player.utils.Logger.v("MediaPlayer", "addExtSubtitle() " + str);
    }

    @Override // com.aliyun.player.ApasaraExternalPlayer
    public void captureScreen() {
        com.cicada.player.utils.Logger.v("MediaPlayer", "captureScreen() ");
    }

    @Override // com.aliyun.player.ApasaraExternalPlayer
    public com.aliyun.player.ApasaraExternalPlayer create(android.content.Context context, com.aliyun.player.nativeclass.Options options) {
        return new com.aliyun.player.a.a(context, options);
    }

    @Override // com.aliyun.player.ApasaraExternalPlayer
    public void enterBackGround(boolean z) {
        com.cicada.player.utils.Logger.v("MediaPlayer", "enterBackGround() " + z);
    }

    @Override // com.aliyun.player.ApasaraExternalPlayer
    public long getBufferPosition() {
        com.cicada.player.utils.Logger.v("MediaPlayer", "getBufferPosition() ");
        return this.h;
    }

    @Override // com.aliyun.player.ApasaraExternalPlayer
    public int getCurrentStreamIndex(com.aliyun.player.ApasaraExternalPlayer.StreamType streamType) {
        android.media.MediaPlayer mediaPlayer;
        com.cicada.player.utils.Logger.v("MediaPlayer", "getCurrentStreamIndex() " + streamType);
        com.aliyun.player.ApasaraExternalPlayer.PlayerStatus playerStatus = this.f;
        int i2 = 0;
        if (!(playerStatus == com.aliyun.player.ApasaraExternalPlayer.PlayerStatus.PLAYER_PREPARED || playerStatus == com.aliyun.player.ApasaraExternalPlayer.PlayerStatus.PLAYER_PLAYING || playerStatus == com.aliyun.player.ApasaraExternalPlayer.PlayerStatus.PLAYER_PAUSED || playerStatus == com.aliyun.player.ApasaraExternalPlayer.PlayerStatus.PLAYER_STOPPED || playerStatus == com.aliyun.player.ApasaraExternalPlayer.PlayerStatus.PLAYER_COMPLETION) || (mediaPlayer = this.c) == null) {
            return -1;
        }
        if (streamType == com.aliyun.player.ApasaraExternalPlayer.StreamType.ST_TYPE_AUDIO) {
            i2 = 2;
        } else if (streamType == com.aliyun.player.ApasaraExternalPlayer.StreamType.ST_TYPE_VIDEO) {
            i2 = 1;
        } else if (streamType == com.aliyun.player.ApasaraExternalPlayer.StreamType.ST_TYPE_SUB) {
            i2 = 4;
        }
        return mediaPlayer.getSelectedTrack(i2);
    }

    @Override // com.aliyun.player.ApasaraExternalPlayer
    public com.aliyun.player.nativeclass.TrackInfo getCurrentStreamInfo(com.aliyun.player.ApasaraExternalPlayer.StreamType streamType) {
        android.media.MediaPlayer.TrackInfo[] trackInfoArr;
        com.cicada.player.utils.Logger.v("MediaPlayer", "getCurrentStreamInfo() " + streamType);
        int currentStreamIndex = getCurrentStreamIndex(streamType);
        if (currentStreamIndex < 0 || (trackInfoArr = this.d) == null || currentStreamIndex >= trackInfoArr.length) {
            return null;
        }
        return a(trackInfoArr[currentStreamIndex], currentStreamIndex);
    }

    @Override // com.aliyun.player.ApasaraExternalPlayer
    public com.aliyun.player.ApasaraExternalPlayer.DecoderType getDecoderType() {
        com.cicada.player.utils.Logger.v("MediaPlayer", "getDecoderType() ");
        return com.aliyun.player.ApasaraExternalPlayer.DecoderType.DT_HARDWARE;
    }

    @Override // com.aliyun.player.ApasaraExternalPlayer
    public long getDuration() {
        android.media.MediaPlayer mediaPlayer;
        com.cicada.player.utils.Logger.v("MediaPlayer", "getDuration() ");
        com.aliyun.player.ApasaraExternalPlayer.PlayerStatus playerStatus = this.f;
        if ((playerStatus == com.aliyun.player.ApasaraExternalPlayer.PlayerStatus.PLAYER_PREPARED || playerStatus == com.aliyun.player.ApasaraExternalPlayer.PlayerStatus.PLAYER_PLAYING || playerStatus == com.aliyun.player.ApasaraExternalPlayer.PlayerStatus.PLAYER_PAUSED || playerStatus == com.aliyun.player.ApasaraExternalPlayer.PlayerStatus.PLAYER_STOPPED || playerStatus == com.aliyun.player.ApasaraExternalPlayer.PlayerStatus.PLAYER_COMPLETION) && (mediaPlayer = this.c) != null) {
            return java.lang.Math.max(playerStatus != com.aliyun.player.ApasaraExternalPlayer.PlayerStatus.PLAYER_ERROR ? mediaPlayer.getDuration() : 0, 0);
        }
        return 0L;
    }

    @Override // com.aliyun.player.ApasaraExternalPlayer
    public long getMasterClockPts() {
        com.cicada.player.utils.Logger.v("MediaPlayer", "getMasterClockPts() ");
        return 0L;
    }

    @Override // com.aliyun.player.ApasaraExternalPlayer
    public com.aliyun.player.IPlayer.MirrorMode getMirrorMode() {
        com.cicada.player.utils.Logger.v("MediaPlayer", "getMirrorMode() ");
        return com.aliyun.player.IPlayer.MirrorMode.MIRROR_MODE_NONE;
    }

    @Override // com.aliyun.player.ApasaraExternalPlayer
    public java.lang.String getName() {
        return "MediaPlayer";
    }

    @Override // com.aliyun.player.ApasaraExternalPlayer
    public java.lang.String getOption(java.lang.String str) {
        com.cicada.player.utils.Logger.v("MediaPlayer", "getOption() " + str);
        return null;
    }

    @Override // com.aliyun.player.ApasaraExternalPlayer
    public com.aliyun.player.ApasaraExternalPlayer.PlayerStatus getPlayerStatus() {
        com.cicada.player.utils.Logger.v("MediaPlayer", "getPlayerStatus() ");
        return this.f;
    }

    @Override // com.aliyun.player.ApasaraExternalPlayer
    public long getPlayingPosition() {
        android.media.MediaPlayer mediaPlayer;
        com.cicada.player.utils.Logger.v("MediaPlayer", "getPlayingPosition() ");
        long j = this.J;
        if (j >= 0) {
            return j;
        }
        com.aliyun.player.ApasaraExternalPlayer.PlayerStatus playerStatus = this.f;
        if ((playerStatus == com.aliyun.player.ApasaraExternalPlayer.PlayerStatus.PLAYER_PREPARED || playerStatus == com.aliyun.player.ApasaraExternalPlayer.PlayerStatus.PLAYER_PLAYING || playerStatus == com.aliyun.player.ApasaraExternalPlayer.PlayerStatus.PLAYER_PAUSED || playerStatus == com.aliyun.player.ApasaraExternalPlayer.PlayerStatus.PLAYER_STOPPED || playerStatus == com.aliyun.player.ApasaraExternalPlayer.PlayerStatus.PLAYER_COMPLETION || playerStatus == com.aliyun.player.ApasaraExternalPlayer.PlayerStatus.PLAYER_IDLE || playerStatus == com.aliyun.player.ApasaraExternalPlayer.PlayerStatus.PLAYER_INITIALZED) && (mediaPlayer = this.c) != null) {
            return mediaPlayer.getCurrentPosition();
        }
        return 0L;
    }

    @Override // com.aliyun.player.ApasaraExternalPlayer
    public long getPropertyInt(com.aliyun.player.ApasaraExternalPlayer.PropertyKey propertyKey) {
        com.cicada.player.utils.Logger.v("MediaPlayer", "getPropertyInt() " + propertyKey);
        return 0L;
    }

    @Override // com.aliyun.player.ApasaraExternalPlayer
    public long getPropertyLong(com.aliyun.player.ApasaraExternalPlayer.PropertyKey propertyKey) {
        com.cicada.player.utils.Logger.v("MediaPlayer", "getPropertyLong() " + propertyKey);
        return 0L;
    }

    @Override // com.aliyun.player.ApasaraExternalPlayer
    public java.lang.String getPropertyString(com.aliyun.player.ApasaraExternalPlayer.PropertyKey propertyKey) {
        com.cicada.player.utils.Logger.v("MediaPlayer", "getPropertyString() " + propertyKey);
        return null;
    }

    @Override // com.aliyun.player.ApasaraExternalPlayer
    public com.aliyun.player.IPlayer.RotateMode getRotateMode() {
        com.cicada.player.utils.Logger.v("MediaPlayer", "getRotateMode() ");
        return com.aliyun.player.IPlayer.RotateMode.ROTATE_0;
    }

    @Override // com.aliyun.player.ApasaraExternalPlayer
    public com.aliyun.player.IPlayer.ScaleMode getScaleMode() {
        com.cicada.player.utils.Logger.v("MediaPlayer", "getScaleMode() ");
        return com.aliyun.player.IPlayer.ScaleMode.SCALE_TO_FILL;
    }

    @Override // com.aliyun.player.ApasaraExternalPlayer
    public float getSpeed() {
        com.cicada.player.utils.Logger.v("MediaPlayer", "getSpeed() ");
        return this.o;
    }

    @Override // com.aliyun.player.ApasaraExternalPlayer
    public float getVideoDecodeFps() {
        com.cicada.player.utils.Logger.v("MediaPlayer", "getVideoDecodeFps() ");
        return 0.0f;
    }

    @Override // com.aliyun.player.ApasaraExternalPlayer
    public int getVideoHeight() {
        android.media.MediaPlayer mediaPlayer;
        com.cicada.player.utils.Logger.v("MediaPlayer", "getVideoHeight() ");
        if ((this.f != com.aliyun.player.ApasaraExternalPlayer.PlayerStatus.PLAYER_ERROR) && (mediaPlayer = this.c) != null) {
            return mediaPlayer.getVideoHeight();
        }
        return 0;
    }

    @Override // com.aliyun.player.ApasaraExternalPlayer
    public float getVideoRenderFps() {
        com.cicada.player.utils.Logger.v("MediaPlayer", "getVideoRenderFps() ");
        return 0.0f;
    }

    @Override // com.aliyun.player.ApasaraExternalPlayer
    public int getVideoRotation() {
        com.cicada.player.utils.Logger.v("MediaPlayer", "getVideoRotation() ");
        return 0;
    }

    @Override // com.aliyun.player.ApasaraExternalPlayer
    public int getVideoWidth() {
        android.media.MediaPlayer mediaPlayer;
        com.cicada.player.utils.Logger.v("MediaPlayer", "getVideoWidth() ");
        if ((this.f != com.aliyun.player.ApasaraExternalPlayer.PlayerStatus.PLAYER_ERROR) && (mediaPlayer = this.c) != null) {
            return mediaPlayer.getVideoWidth();
        }
        return 0;
    }

    @Override // com.aliyun.player.ApasaraExternalPlayer
    public float getVolume() {
        com.cicada.player.utils.Logger.v("MediaPlayer", "getVolume() ");
        return this.i;
    }

    @Override // com.aliyun.player.ApasaraExternalPlayer
    public int invokeComponent(java.lang.String str) {
        com.cicada.player.utils.Logger.v("MediaPlayer", "invokeComponent() " + str);
        return 0;
    }

    @Override // com.aliyun.player.ApasaraExternalPlayer
    public boolean isAutoPlay() {
        com.cicada.player.utils.Logger.v("MediaPlayer", "isAutoPlay() ");
        return this.p;
    }

    @Override // com.aliyun.player.ApasaraExternalPlayer
    public boolean isLooping() {
        com.cicada.player.utils.Logger.v("MediaPlayer", "isLooping() ");
        android.media.MediaPlayer mediaPlayer = this.c;
        if (mediaPlayer != null) {
            return mediaPlayer.isLooping();
        }
        return false;
    }

    @Override // com.aliyun.player.ApasaraExternalPlayer
    public boolean isMute() {
        com.cicada.player.utils.Logger.v("MediaPlayer", "isMute() ");
        return this.k;
    }

    @Override // com.aliyun.player.ApasaraExternalPlayer
    public boolean isSupport(com.aliyun.player.nativeclass.Options options) {
        return options != null && "MediaPlayer".equals(options.get("name"));
    }

    @Override // com.aliyun.player.ApasaraExternalPlayer
    public void mute(boolean z) {
        android.media.MediaPlayer mediaPlayer;
        com.cicada.player.utils.Logger.v("MediaPlayer", "mute() " + z);
        this.k = z;
        if ((this.f != com.aliyun.player.ApasaraExternalPlayer.PlayerStatus.PLAYER_ERROR) && (mediaPlayer = this.c) != null) {
            float f2 = z ? 0.0f : this.i;
            mediaPlayer.setVolume(f2, f2);
        }
    }

    @Override // com.aliyun.player.ApasaraExternalPlayer
    public void pause() {
        android.media.MediaPlayer mediaPlayer;
        com.cicada.player.utils.Logger.v("MediaPlayer", "pause() ");
        com.aliyun.player.ApasaraExternalPlayer.PlayerStatus playerStatus = this.f;
        if ((playerStatus == com.aliyun.player.ApasaraExternalPlayer.PlayerStatus.PLAYER_PLAYING || playerStatus == com.aliyun.player.ApasaraExternalPlayer.PlayerStatus.PLAYER_PAUSED || playerStatus == com.aliyun.player.ApasaraExternalPlayer.PlayerStatus.PLAYER_COMPLETION) && (mediaPlayer = this.c) != null) {
            mediaPlayer.pause();
            a(com.aliyun.player.ApasaraExternalPlayer.PlayerStatus.PLAYER_PAUSED, true);
        }
    }

    @Override // com.aliyun.player.ApasaraExternalPlayer
    public void prepare() {
        com.cicada.player.utils.Logger.v("MediaPlayer", "prepare() ");
        android.media.MediaPlayer mediaPlayer = this.c;
        if (mediaPlayer != null) {
            mediaPlayer.reset();
            c();
            setScaleMode(this.j);
            setSpeed(this.o);
            setLooping(this.l);
            mute(this.k);
            setVolume(this.i);
            a(com.aliyun.player.ApasaraExternalPlayer.PlayerStatus.PLAYER_PREPARING, true);
            this.c.prepareAsync();
        }
    }

    @Override // com.aliyun.player.ApasaraExternalPlayer
    public void reLoad() {
        com.cicada.player.utils.Logger.v("MediaPlayer", "reLoad() ");
    }

    @Override // com.aliyun.player.ApasaraExternalPlayer
    public void release() {
        com.cicada.player.utils.Logger.v("MediaPlayer", "release() ");
        a(com.aliyun.player.ApasaraExternalPlayer.PlayerStatus.PLAYER_IDLE, false);
        android.media.MediaPlayer mediaPlayer = this.c;
        if (mediaPlayer != null) {
            mediaPlayer.release();
        }
        this.c = null;
    }

    @Override // com.aliyun.player.ApasaraExternalPlayer
    public void removeAllCustomHttpHeader() {
        com.cicada.player.utils.Logger.v("MediaPlayer", "removeAllCustomHttpHeader() ");
        this.L.clear();
    }

    @Override // com.aliyun.player.ApasaraExternalPlayer
    public void seekTo(long j, boolean z) {
        com.cicada.player.utils.Logger.v("MediaPlayer", "seekTo() " + j + " , accurate = " + z);
        com.aliyun.player.ApasaraExternalPlayer.PlayerStatus playerStatus = this.f;
        if (!(playerStatus == com.aliyun.player.ApasaraExternalPlayer.PlayerStatus.PLAYER_PREPARED || playerStatus == com.aliyun.player.ApasaraExternalPlayer.PlayerStatus.PLAYER_PLAYING || playerStatus == com.aliyun.player.ApasaraExternalPlayer.PlayerStatus.PLAYER_PAUSED || playerStatus == com.aliyun.player.ApasaraExternalPlayer.PlayerStatus.PLAYER_COMPLETION)) {
            this.J = j;
            this.K = z;
            return;
        }
        android.media.MediaPlayer mediaPlayer = this.c;
        if (mediaPlayer != null) {
            if (android.os.Build.VERSION.SDK_INT < 26 || !z) {
                mediaPlayer.seekTo((int) j);
            } else {
                mediaPlayer.seekTo(j, 3);
            }
            com.aliyun.player.ApasaraExternalPlayer.OnSeekStatusListener onSeekStatusListener = this.w;
            if (onSeekStatusListener != null) {
                onSeekStatusListener.onSeekStart(false);
            }
        }
    }

    @Override // com.aliyun.player.ApasaraExternalPlayer
    public int selectExtSubtitle(int i2, boolean z) {
        com.cicada.player.utils.Logger.v("MediaPlayer", "selectExtSubtitle() " + i2 + " , bSelect = " + z);
        return 0;
    }

    @Override // com.aliyun.player.ApasaraExternalPlayer
    public void setAutoPlay(boolean z) {
        com.cicada.player.utils.Logger.v("MediaPlayer", "setAutoPlay() " + z);
        this.p = z;
    }

    @Override // com.aliyun.player.ApasaraExternalPlayer
    public void setDataSource(java.lang.String str) {
        com.cicada.player.utils.Logger.v("MediaPlayer", "setDataSource() " + str);
        this.g = str;
        if (this.c != null) {
            a(com.aliyun.player.ApasaraExternalPlayer.PlayerStatus.PLAYER_INITIALZED, true);
        }
    }

    @Override // com.aliyun.player.ApasaraExternalPlayer
    public void setDecoderType(com.aliyun.player.ApasaraExternalPlayer.DecoderType decoderType) {
        com.cicada.player.utils.Logger.v("MediaPlayer", "setDecoderType() " + decoderType);
    }

    @Override // com.aliyun.player.ApasaraExternalPlayer
    public void setDrmCallback(com.aliyun.player.ApasaraExternalPlayer.OnDRMCallback onDRMCallback) {
        this.I = onDRMCallback;
    }

    @Override // com.aliyun.player.ApasaraExternalPlayer
    public void setDropBufferThreshold(int i2) {
        com.cicada.player.utils.Logger.v("MediaPlayer", "setDropBufferThreshold() " + i2);
    }

    @Override // com.aliyun.player.ApasaraExternalPlayer
    public void setLooping(boolean z) {
        android.media.MediaPlayer mediaPlayer;
        com.cicada.player.utils.Logger.v("MediaPlayer", "setLooping() " + z);
        this.l = z;
        if ((this.f != com.aliyun.player.ApasaraExternalPlayer.PlayerStatus.PLAYER_ERROR) && (mediaPlayer = this.c) != null) {
            mediaPlayer.setLooping(z);
        }
    }

    @Override // com.aliyun.player.ApasaraExternalPlayer
    public void setMirrorMode(com.aliyun.player.IPlayer.MirrorMode mirrorMode) {
        com.cicada.player.utils.Logger.v("MediaPlayer", "setMirrorMode() " + mirrorMode);
    }

    @Override // com.aliyun.player.ApasaraExternalPlayer
    public void setOnAutoPlayStartListener(com.aliyun.player.ApasaraExternalPlayer.OnAutoPlayStartListener onAutoPlayStartListener) {
        this.v = onAutoPlayStartListener;
    }

    @Override // com.aliyun.player.ApasaraExternalPlayer
    public void setOnBufferPositionUpdateListener(com.aliyun.player.ApasaraExternalPlayer.OnBufferPositionUpdateListener onBufferPositionUpdateListener) {
        this.y = onBufferPositionUpdateListener;
    }

    @Override // com.aliyun.player.ApasaraExternalPlayer
    public void setOnCaptureScreenListener(com.aliyun.player.ApasaraExternalPlayer.OnCaptureScreenListener onCaptureScreenListener) {
        this.G = onCaptureScreenListener;
    }

    @Override // com.aliyun.player.ApasaraExternalPlayer
    public void setOnCompletionListener(com.aliyun.player.ApasaraExternalPlayer.OnCompletionListener onCompletionListener) {
        this.f90s = onCompletionListener;
    }

    @Override // com.aliyun.player.ApasaraExternalPlayer
    public void setOnErrorListener(com.aliyun.player.ApasaraExternalPlayer.OnErrorListener onErrorListener) {
        this.C = onErrorListener;
    }

    @Override // com.aliyun.player.ApasaraExternalPlayer
    public void setOnEventListener(com.aliyun.player.ApasaraExternalPlayer.OnEventListener onEventListener) {
        this.D = onEventListener;
    }

    @Override // com.aliyun.player.ApasaraExternalPlayer
    public void setOnFirstFrameRenderListener(com.aliyun.player.ApasaraExternalPlayer.OnFirstFrameRenderListener onFirstFrameRenderListener) {
        this.t = onFirstFrameRenderListener;
    }

    @Override // com.aliyun.player.ApasaraExternalPlayer
    public void setOnLoadStatusListener(com.aliyun.player.ApasaraExternalPlayer.OnLoadStatusListener onLoadStatusListener) {
        this.u = onLoadStatusListener;
    }

    @Override // com.aliyun.player.ApasaraExternalPlayer
    public void setOnLoopingStartListener(com.aliyun.player.ApasaraExternalPlayer.OnLoopingStartListener onLoopingStartListener) {
        this.r = onLoopingStartListener;
    }

    @Override // com.aliyun.player.ApasaraExternalPlayer
    public void setOnPositionUpdateListener(com.aliyun.player.ApasaraExternalPlayer.OnPositionUpdateListener onPositionUpdateListener) {
        this.x = onPositionUpdateListener;
    }

    @Override // com.aliyun.player.ApasaraExternalPlayer
    public void setOnPreparedListener(com.aliyun.player.ApasaraExternalPlayer.OnPreparedListener onPreparedListener) {
        this.q = onPreparedListener;
    }

    @Override // com.aliyun.player.ApasaraExternalPlayer
    public void setOnSeekStatusListener(com.aliyun.player.ApasaraExternalPlayer.OnSeekStatusListener onSeekStatusListener) {
        this.w = onSeekStatusListener;
    }

    @Override // com.aliyun.player.ApasaraExternalPlayer
    public void setOnStatusChangedListener(com.aliyun.player.ApasaraExternalPlayer.OnStatusChangedListener onStatusChangedListener) {
        this.A = onStatusChangedListener;
    }

    @Override // com.aliyun.player.ApasaraExternalPlayer
    public void setOnStreamInfoGetListener(com.aliyun.player.ApasaraExternalPlayer.OnStreamInfoGetListener onStreamInfoGetListener) {
        this.E = onStreamInfoGetListener;
    }

    @Override // com.aliyun.player.ApasaraExternalPlayer
    public void setOnStreamSwitchSucListener(com.aliyun.player.ApasaraExternalPlayer.OnStreamSwitchSucListener onStreamSwitchSucListener) {
        this.F = onStreamSwitchSucListener;
    }

    @Override // com.aliyun.player.ApasaraExternalPlayer
    public void setOnSubtitleListener(com.aliyun.player.ApasaraExternalPlayer.OnSubtitleListener onSubtitleListener) {
        this.H = onSubtitleListener;
    }

    @Override // com.aliyun.player.ApasaraExternalPlayer
    public void setOnVideoRenderedListener(com.aliyun.player.ApasaraExternalPlayer.OnVideoRenderedListener onVideoRenderedListener) {
        this.B = onVideoRenderedListener;
    }

    @Override // com.aliyun.player.ApasaraExternalPlayer
    public void setOnVideoSizeChangedListener(com.aliyun.player.ApasaraExternalPlayer.OnVideoSizeChangedListener onVideoSizeChangedListener) {
        this.z = onVideoSizeChangedListener;
    }

    @Override // com.aliyun.player.ApasaraExternalPlayer
    public int setOption(java.lang.String str, java.lang.String str2) {
        com.cicada.player.utils.Logger.v("MediaPlayer", "setOption() " + str + " : " + str2);
        return 0;
    }

    @Override // com.aliyun.player.ApasaraExternalPlayer
    public void setRefer(java.lang.String str) {
        com.cicada.player.utils.Logger.v("MediaPlayer", "setRefer() " + str);
        this.m = str;
    }

    @Override // com.aliyun.player.ApasaraExternalPlayer
    public void setRotateMode(com.aliyun.player.IPlayer.RotateMode rotateMode) {
        com.cicada.player.utils.Logger.v("MediaPlayer", "setRotateMode() " + rotateMode);
    }

    @Override // com.aliyun.player.ApasaraExternalPlayer
    public void setScaleMode(com.aliyun.player.IPlayer.ScaleMode scaleMode) {
        android.media.MediaPlayer mediaPlayer;
        com.cicada.player.utils.Logger.v("MediaPlayer", "setScaleMode() " + scaleMode);
        this.j = scaleMode;
        com.aliyun.player.ApasaraExternalPlayer.PlayerStatus playerStatus = this.f;
        if (((playerStatus == com.aliyun.player.ApasaraExternalPlayer.PlayerStatus.PLAYER_ERROR || playerStatus == com.aliyun.player.ApasaraExternalPlayer.PlayerStatus.PLAYER_IDLE) ? false : true) && (mediaPlayer = this.c) != null) {
            if (scaleMode == com.aliyun.player.IPlayer.ScaleMode.SCALE_ASPECT_FILL) {
                mediaPlayer.setVideoScalingMode(2);
            } else {
                mediaPlayer.setVideoScalingMode(1);
            }
        }
    }

    @Override // com.aliyun.player.ApasaraExternalPlayer
    public void setSpeed(float f2) {
        com.cicada.player.utils.Logger.v("MediaPlayer", "setSpeed() " + f2);
        this.o = f2;
        com.aliyun.player.ApasaraExternalPlayer.PlayerStatus playerStatus = this.f;
        if (((playerStatus == com.aliyun.player.ApasaraExternalPlayer.PlayerStatus.PLAYER_IDLE || playerStatus == com.aliyun.player.ApasaraExternalPlayer.PlayerStatus.PLAYER_STOPPED) ? false : true) && this.c != null && android.os.Build.VERSION.SDK_INT >= 23) {
            android.media.PlaybackParams playbackParams = new android.media.PlaybackParams();
            playbackParams.setSpeed(f2);
            this.c.setPlaybackParams(playbackParams);
        }
    }

    @Override // com.aliyun.player.ApasaraExternalPlayer
    public void setSurface(android.view.Surface surface) {
        com.cicada.player.utils.Logger.v("MediaPlayer", "setSurface() " + surface);
        android.media.MediaPlayer mediaPlayer = this.c;
        if (mediaPlayer != null) {
            mediaPlayer.setSurface(surface);
        }
    }

    @Override // com.aliyun.player.ApasaraExternalPlayer
    public void setTimeout(int i2) {
        com.cicada.player.utils.Logger.v("MediaPlayer", "setTimeout() " + i2);
    }

    @Override // com.aliyun.player.ApasaraExternalPlayer
    public void setUserAgent(java.lang.String str) {
        com.cicada.player.utils.Logger.v("MediaPlayer", "setUserAgent() " + str);
        this.n = str;
    }

    @Override // com.aliyun.player.ApasaraExternalPlayer
    public void setVideoBackgroundColor(long j) {
        com.cicada.player.utils.Logger.v("MediaPlayer", "setVideoBackgroundColor() " + j);
    }

    @Override // com.aliyun.player.ApasaraExternalPlayer
    public void setVolume(float f2) {
        android.media.MediaPlayer mediaPlayer;
        com.cicada.player.utils.Logger.v("MediaPlayer", "setVolume() " + f2);
        this.i = f2;
        if (!(this.f != com.aliyun.player.ApasaraExternalPlayer.PlayerStatus.PLAYER_ERROR) || this.k || (mediaPlayer = this.c) == null) {
            return;
        }
        mediaPlayer.setVolume(f2, f2);
    }

    @Override // com.aliyun.player.ApasaraExternalPlayer
    public void start() {
        android.media.MediaPlayer mediaPlayer;
        com.cicada.player.utils.Logger.v("MediaPlayer", "start() ");
        com.aliyun.player.ApasaraExternalPlayer.PlayerStatus playerStatus = this.f;
        if ((playerStatus == com.aliyun.player.ApasaraExternalPlayer.PlayerStatus.PLAYER_PREPARED || playerStatus == com.aliyun.player.ApasaraExternalPlayer.PlayerStatus.PLAYER_PLAYING || playerStatus == com.aliyun.player.ApasaraExternalPlayer.PlayerStatus.PLAYER_PAUSED || playerStatus == com.aliyun.player.ApasaraExternalPlayer.PlayerStatus.PLAYER_COMPLETION) && (mediaPlayer = this.c) != null) {
            mediaPlayer.start();
            a(com.aliyun.player.ApasaraExternalPlayer.PlayerStatus.PLAYER_PLAYING, true);
        }
    }

    @Override // com.aliyun.player.ApasaraExternalPlayer
    public void stop() {
        android.media.MediaPlayer mediaPlayer;
        com.aliyun.player.ApasaraExternalPlayer.PlayerStatus playerStatus;
        com.cicada.player.utils.Logger.v("MediaPlayer", "stop() ");
        com.aliyun.player.ApasaraExternalPlayer.PlayerStatus playerStatus2 = this.f;
        if (!(playerStatus2 == com.aliyun.player.ApasaraExternalPlayer.PlayerStatus.PLAYER_PREPARED || playerStatus2 == com.aliyun.player.ApasaraExternalPlayer.PlayerStatus.PLAYER_PLAYING || playerStatus2 == com.aliyun.player.ApasaraExternalPlayer.PlayerStatus.PLAYER_PAUSED || playerStatus2 == com.aliyun.player.ApasaraExternalPlayer.PlayerStatus.PLAYER_STOPPED || playerStatus2 == com.aliyun.player.ApasaraExternalPlayer.PlayerStatus.PLAYER_COMPLETION) || (mediaPlayer = this.c) == null || playerStatus2 == (playerStatus = com.aliyun.player.ApasaraExternalPlayer.PlayerStatus.PLAYER_STOPPED)) {
            return;
        }
        mediaPlayer.stop();
        a(playerStatus, true);
    }

    @Override // com.aliyun.player.ApasaraExternalPlayer
    public com.aliyun.player.ApasaraExternalPlayer.StreamType switchStream(int i2) {
        android.media.MediaPlayer mediaPlayer;
        com.cicada.player.utils.Logger.v("MediaPlayer", "switchStream() " + i2);
        com.aliyun.player.ApasaraExternalPlayer.PlayerStatus playerStatus = this.f;
        if ((playerStatus == com.aliyun.player.ApasaraExternalPlayer.PlayerStatus.PLAYER_PREPARED || playerStatus == com.aliyun.player.ApasaraExternalPlayer.PlayerStatus.PLAYER_PLAYING || playerStatus == com.aliyun.player.ApasaraExternalPlayer.PlayerStatus.PLAYER_PAUSED || playerStatus == com.aliyun.player.ApasaraExternalPlayer.PlayerStatus.PLAYER_STOPPED || playerStatus == com.aliyun.player.ApasaraExternalPlayer.PlayerStatus.PLAYER_COMPLETION) && (mediaPlayer = this.c) != null) {
            mediaPlayer.selectTrack(i2);
            android.media.MediaPlayer.TrackInfo[] trackInfoArr = this.d;
            if (trackInfoArr == null) {
                return com.aliyun.player.ApasaraExternalPlayer.StreamType.ST_TYPE_UNKNOWN;
            }
            int trackType = trackInfoArr[i2].getTrackType();
            return trackType == 2 ? com.aliyun.player.ApasaraExternalPlayer.StreamType.ST_TYPE_AUDIO : trackType == 4 ? com.aliyun.player.ApasaraExternalPlayer.StreamType.ST_TYPE_SUB : trackType == 1 ? com.aliyun.player.ApasaraExternalPlayer.StreamType.ST_TYPE_VIDEO : trackType == 0 ? com.aliyun.player.ApasaraExternalPlayer.StreamType.ST_TYPE_UNKNOWN : com.aliyun.player.ApasaraExternalPlayer.StreamType.ST_TYPE_UNKNOWN;
        }
        return com.aliyun.player.ApasaraExternalPlayer.StreamType.ST_TYPE_UNKNOWN;
    }
}
