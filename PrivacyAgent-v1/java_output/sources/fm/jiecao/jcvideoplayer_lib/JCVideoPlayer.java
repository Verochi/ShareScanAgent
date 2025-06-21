package fm.jiecao.jcvideoplayer_lib;

@android.annotation.TargetApi(14)
/* loaded from: classes9.dex */
public abstract class JCVideoPlayer extends android.widget.FrameLayout implements fm.jiecao.jcvideoplayer_lib.JCMediaPlayerListener, android.view.View.OnClickListener, android.widget.SeekBar.OnSeekBarChangeListener, android.view.View.OnTouchListener, android.view.TextureView.SurfaceTextureListener {
    public static boolean ACTION_BAR_EXIST = true;
    public static final int CURRENT_STATE_AUTO_COMPLETE = 6;
    public static final int CURRENT_STATE_ERROR = 7;
    public static final int CURRENT_STATE_NORMAL = 0;
    public static final int CURRENT_STATE_PAUSE = 5;
    public static final int CURRENT_STATE_PLAYING = 2;
    public static final int CURRENT_STATE_PLAYING_BUFFERING_START = 3;
    public static final int CURRENT_STATE_PREPARING = 1;
    public static final int FULLSCREEN_ID = 33797;
    public static final int SCREEN_LAYOUT_LIST = 1;
    public static final int SCREEN_LAYOUT_NORMAL = 0;
    public static final int SCREEN_WINDOW_FULLSCREEN = 2;
    public static final int SCREEN_WINDOW_TINY = 3;
    public static final java.lang.String TAG = "JieCaoVideoPlayer";
    public static final int THRESHOLD = 80;
    public static final int TINY_ID = 33798;
    public static boolean TOOL_BAR_EXIST = true;
    protected static java.util.Timer UPDATE_PROGRESS_TIMER = null;
    public static int VIDEO_IMAGE_DISPLAY_TYPE = 0;
    public static final int VIDEO_IMAGE_DISPLAY_TYPE_ADAPTER = 0;
    public static final int VIDEO_IMAGE_DISPLAY_TYPE_FILL_PARENT = 1;
    public static final int VIDEO_IMAGE_DISPLAY_TYPE_FILL_SCROP = 2;
    public static final int VIDEO_IMAGE_DISPLAY_TYPE_ORIGINAL = 3;
    public static boolean WIFI_TIP_DIALOG_SHOWED;
    public static int bufferPercent;
    protected static fm.jiecao.jcvideoplayer_lib.JCMediaManager jcMediaManager;
    public static android.media.AudioManager.OnAudioFocusChangeListener onAudioFocusChangeListener = new fm.jiecao.jcvideoplayer_lib.JCVideoPlayer.AnonymousClass1();
    protected int DEFAULT_MUSIC;
    protected android.widget.ImageView backButton;
    public int backUpBufferState;
    public android.view.ViewGroup bottomContainer;
    public int currentScreen;
    public int currentState;
    public android.widget.TextView currentTimeTextView;
    protected java.lang.String fullDetail;
    protected fm.jiecao.jcvideoplayer_lib.FullDetailClickCallBack fullDetailClickCallBack;
    protected fm.jiecao.jcvideoplayer_lib.FullScreenClickCallBack fullSceenClickCallBack;
    public android.widget.ImageView fullscreenButton;
    protected fm.jiecao.jcvideoplayer_lib.IVideoPlayProcessChanged iVideoPlayProcessChanged;
    protected boolean isCanSpeed;
    protected boolean isNeedControlBar;
    protected boolean isNeedControlButton;
    protected boolean isNeedCyclePlay;
    protected boolean isNeedFullButton;
    protected boolean isNeedMute;
    protected boolean isNeedScreen;
    protected boolean isNeedShowView;
    protected boolean isNeedSystemVolume;
    protected boolean isNeedTime;
    protected boolean isNeedVoice;
    protected boolean isNeedWifi;
    protected boolean isNeedWifiDialog;
    protected android.widget.ImageView iv_all_music;
    public boolean looping;
    protected android.media.AudioManager mAudioManager;
    protected boolean mChangePosition;
    protected boolean mChangeVolume;
    protected int mDownPosition;
    protected float mDownX;
    protected float mDownY;
    protected int mGestureDownVolume;
    protected android.os.Handler mHandler;
    protected fm.jiecao.jcvideoplayer_lib.JCVideoPlayer.ProgressTimerTask mProgressTimerTask;
    protected int mScreenHeight;
    protected int mScreenWidth;
    protected int mSeekTimePosition;
    protected boolean mTouchingProgressBar;
    public java.util.Map<java.lang.String, java.lang.String> mapHeadData;
    public int n;
    public java.lang.Object[] objects;
    protected java.lang.String picPath;
    public android.widget.SeekBar progressBar;
    public android.widget.RelativeLayout rl_video;
    public fm.jiecao.jcvideoplayer_lib.ClipRelativeLayout rl_video_2;
    protected android.widget.RelativeLayout rl_wifi_toast;
    public int seekToInAdvance;
    public android.widget.ImageView startButton;
    public android.view.Surface surface;
    public int t;
    protected fm.jiecao.jcvideoplayer_lib.JCResizeTextureView textureView;
    public android.view.ViewGroup textureViewContainer;
    public android.widget.ImageView thumbImageView;
    protected java.lang.String time_total;
    protected android.widget.TextView titleTextView;
    public android.view.ViewGroup topContainer;
    public android.widget.TextView totalTimeTextView;
    public android.widget.TextView tv_full_detail;
    protected android.widget.TextView tv_full_wifi;
    protected android.widget.TextView tv_time;
    public boolean u;
    public java.lang.String url;
    protected fm.jiecao.jcvideoplayer_lib.VideoPlayStateChangeCallBack videoPlayStateClickCallBack;
    public int videoRotation;
    protected java.lang.String videotitle;
    protected android.widget.ImageView voiceImageView;

    /* renamed from: fm.jiecao.jcvideoplayer_lib.JCVideoPlayer$1, reason: invalid class name */
    public class AnonymousClass1 implements android.media.AudioManager.OnAudioFocusChangeListener {
        @Override // android.media.AudioManager.OnAudioFocusChangeListener
        public void onAudioFocusChange(int i) {
            if (i != -2) {
                if (i != -1) {
                    return;
                }
                fm.jiecao.jcvideoplayer_lib.JCVideoPlayer.releaseAllVideos();
                com.moji.tool.log.MJLogger.d(fm.jiecao.jcvideoplayer_lib.JCVideoPlayer.TAG, "AUDIOFOCUS_LOSS [" + hashCode() + "]");
                return;
            }
            fm.jiecao.jcvideoplayer_lib.JCMediaManager jCMediaManager = fm.jiecao.jcvideoplayer_lib.JCVideoPlayer.jcMediaManager;
            if (jCMediaManager != null && jCMediaManager.isPlaying()) {
                fm.jiecao.jcvideoplayer_lib.JCVideoPlayer.jcMediaManager.pause();
            }
            com.moji.tool.log.MJLogger.d(fm.jiecao.jcvideoplayer_lib.JCVideoPlayer.TAG, "AUDIOFOCUS_LOSS_TRANSIENT [" + hashCode() + "]");
        }
    }

    public static class ProgressTimerTask extends java.util.TimerTask {
        public java.lang.ref.WeakReference<fm.jiecao.jcvideoplayer_lib.JCVideoPlayer> n;

        /* renamed from: fm.jiecao.jcvideoplayer_lib.JCVideoPlayer$ProgressTimerTask$1, reason: invalid class name */
        public class AnonymousClass1 implements java.lang.Runnable {
            public final /* synthetic */ fm.jiecao.jcvideoplayer_lib.JCVideoPlayer n;

            public AnonymousClass1(fm.jiecao.jcvideoplayer_lib.JCVideoPlayer jCVideoPlayer) {
                this.n = jCVideoPlayer;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (fm.jiecao.jcvideoplayer_lib.JCVideoPlayer.jcMediaManager == null) {
                    return;
                }
                this.n.setTextAndProgress(fm.jiecao.jcvideoplayer_lib.JCVideoPlayer.bufferPercent);
            }
        }

        public ProgressTimerTask(java.lang.ref.WeakReference<fm.jiecao.jcvideoplayer_lib.JCVideoPlayer> weakReference) {
            this.n = weakReference;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            fm.jiecao.jcvideoplayer_lib.JCVideoPlayer jCVideoPlayer;
            java.lang.ref.WeakReference<fm.jiecao.jcvideoplayer_lib.JCVideoPlayer> weakReference = this.n;
            if (weakReference == null || (jCVideoPlayer = weakReference.get()) == null) {
                return;
            }
            int i = jCVideoPlayer.currentState;
            if (i == 2 || i == 5 || i == 3) {
                jCVideoPlayer.mHandler.post(new fm.jiecao.jcvideoplayer_lib.JCVideoPlayer.ProgressTimerTask.AnonymousClass1(jCVideoPlayer));
            }
        }
    }

    public JCVideoPlayer(android.content.Context context) {
        super(context);
        this.DEFAULT_MUSIC = 0;
        this.currentState = -1;
        this.currentScreen = -1;
        this.backUpBufferState = -1;
        this.url = "";
        this.objects = null;
        this.looping = false;
        this.mapHeadData = new java.util.HashMap();
        this.seekToInAdvance = -1;
        this.isCanSpeed = true;
        this.isNeedMute = true;
        this.isNeedWifiDialog = true;
        this.isNeedShowView = true;
        this.isNeedVoice = true;
        this.isNeedTime = true;
        this.isNeedControlBar = true;
        this.isNeedControlButton = true;
        this.isNeedFullButton = true;
        this.isNeedScreen = true;
        this.isNeedCyclePlay = false;
        this.isNeedSystemVolume = true;
        this.fullDetailClickCallBack = null;
        this.videoPlayStateClickCallBack = null;
        this.iVideoPlayProcessChanged = null;
        this.t = -1;
        this.u = false;
        b(context);
    }

    public JCVideoPlayer(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
        this.DEFAULT_MUSIC = 0;
        this.currentState = -1;
        this.currentScreen = -1;
        this.backUpBufferState = -1;
        this.url = "";
        this.objects = null;
        this.looping = false;
        this.mapHeadData = new java.util.HashMap();
        this.seekToInAdvance = -1;
        this.isCanSpeed = true;
        this.isNeedMute = true;
        this.isNeedWifiDialog = true;
        this.isNeedShowView = true;
        this.isNeedVoice = true;
        this.isNeedTime = true;
        this.isNeedControlBar = true;
        this.isNeedControlButton = true;
        this.isNeedFullButton = true;
        this.isNeedScreen = true;
        this.isNeedCyclePlay = false;
        this.isNeedSystemVolume = true;
        this.fullDetailClickCallBack = null;
        this.videoPlayStateClickCallBack = null;
        this.iVideoPlayProcessChanged = null;
        this.t = -1;
        this.u = false;
        b(context);
    }

    private int a(android.content.Context context) {
        try {
            java.lang.Class<?> cls = java.lang.Class.forName("com.android.internal.R$dimen");
            return context.getResources().getDimensionPixelSize(java.lang.Integer.parseInt(cls.getField("status_bar_height").get(cls.newInstance()).toString()));
        } catch (java.lang.Exception e) {
            com.moji.tool.log.MJLogger.e(TAG, e);
            return -1;
        }
    }

    private void b(android.content.Context context) {
        android.view.View.inflate(context, getLayoutId(), this);
        try {
            jcMediaManager = fm.jiecao.jcvideoplayer_lib.JCMediaManager.getInstance();
        } catch (java.lang.Throwable th) {
            com.moji.tool.log.MJLogger.e(TAG, th);
            com.moji.tool.log.MJLogger.postCatchedException(th);
        }
        this.tv_time = (android.widget.TextView) findViewById(fm.jiecao.jcvideoplayer_lib.R.id.tv_all_time);
        this.iv_all_music = (android.widget.ImageView) findViewById(fm.jiecao.jcvideoplayer_lib.R.id.iv_all_music);
        this.backButton = (android.widget.ImageView) findViewById(fm.jiecao.jcvideoplayer_lib.R.id.back);
        this.rl_video = (android.widget.RelativeLayout) findViewById(fm.jiecao.jcvideoplayer_lib.R.id.rl_video);
        this.rl_video_2 = (fm.jiecao.jcvideoplayer_lib.ClipRelativeLayout) findViewById(fm.jiecao.jcvideoplayer_lib.R.id.rl_video_2);
        this.startButton = (android.widget.ImageView) findViewById(fm.jiecao.jcvideoplayer_lib.R.id.start);
        this.fullscreenButton = (android.widget.ImageView) findViewById(fm.jiecao.jcvideoplayer_lib.R.id.fullscreen);
        this.progressBar = (android.widget.SeekBar) findViewById(fm.jiecao.jcvideoplayer_lib.R.id.progress);
        this.currentTimeTextView = (android.widget.TextView) findViewById(fm.jiecao.jcvideoplayer_lib.R.id.current);
        this.totalTimeTextView = (android.widget.TextView) findViewById(fm.jiecao.jcvideoplayer_lib.R.id.total);
        this.bottomContainer = (android.view.ViewGroup) findViewById(fm.jiecao.jcvideoplayer_lib.R.id.layout_bottom);
        this.textureViewContainer = (android.view.ViewGroup) findViewById(fm.jiecao.jcvideoplayer_lib.R.id.surface_container);
        this.topContainer = (android.view.ViewGroup) findViewById(fm.jiecao.jcvideoplayer_lib.R.id.layout_top);
        this.titleTextView = (android.widget.TextView) findViewById(fm.jiecao.jcvideoplayer_lib.R.id.title);
        this.tv_full_detail = (android.widget.TextView) findViewById(fm.jiecao.jcvideoplayer_lib.R.id.tv_full_detail);
        this.rl_wifi_toast = (android.widget.RelativeLayout) findViewById(fm.jiecao.jcvideoplayer_lib.R.id.rl_wifi_toast);
        this.tv_full_wifi = (android.widget.TextView) findViewById(fm.jiecao.jcvideoplayer_lib.R.id.tv_full_wifi);
        this.voiceImageView = (android.widget.ImageView) findViewById(fm.jiecao.jcvideoplayer_lib.R.id.iv_voice);
        this.tv_full_detail.setOnClickListener(this);
        this.startButton.setOnClickListener(this);
        this.fullscreenButton.setOnClickListener(this);
        this.progressBar.setOnSeekBarChangeListener(this);
        this.bottomContainer.setOnClickListener(this);
        this.textureViewContainer.setOnClickListener(this);
        this.textureViewContainer.setOnTouchListener(this);
        this.mScreenWidth = getContext().getResources().getDisplayMetrics().widthPixels;
        this.mScreenHeight = getContext().getResources().getDisplayMetrics().heightPixels;
        this.mAudioManager = (android.media.AudioManager) com.moji.tool.AppDelegate.getAppContext().getSystemService("audio");
        this.mHandler = new android.os.Handler();
    }

    public static boolean backPress() {
        fm.jiecao.jcvideoplayer_lib.JCMediaManager jCMediaManager = jcMediaManager;
        if (jCMediaManager != null) {
            jCMediaManager.setIsFull(false);
            fm.jiecao.jcvideoplayer_lib.JCMediaPlayerListener first = fm.jiecao.jcvideoplayer_lib.JCVideoPlayerManager.getFirst();
            if (first != null) {
                return first.backToOtherListener();
            }
        }
        return false;
    }

    public static void goPlayFullVideo() {
        try {
            fm.jiecao.jcvideoplayer_lib.JCMediaManager jCMediaManager = jcMediaManager;
            if (jCMediaManager == null || !jCMediaManager.isFull()) {
                return;
            }
            jcMediaManager.start();
        } catch (java.lang.Exception e) {
            com.moji.tool.log.MJLogger.e("main onresum video play", e);
        }
    }

    public static void releaseAllVideos() {
        try {
            fm.jiecao.jcvideoplayer_lib.JCMediaManager jCMediaManager = jcMediaManager;
            if (jCMediaManager != null) {
                if (jCMediaManager.isFull() || jcMediaManager.isRelease()) {
                    jcMediaManager.pause();
                } else {
                    fm.jiecao.jcvideoplayer_lib.JCVideoPlayerManager.completeAll();
                    jcMediaManager.releaseMediaPlayer();
                }
            }
        } catch (java.lang.Exception e) {
            com.moji.tool.log.MJLogger.e("main pause stop video", e);
        }
    }

    @android.annotation.TargetApi(14)
    public void addTextureView() {
        com.moji.tool.log.MJLogger.d(TAG, "addTextureView [" + hashCode() + "] ");
        if (this.textureViewContainer.getChildCount() > 0) {
            this.textureViewContainer.removeAllViews();
        }
        if (jcMediaManager != null) {
            this.textureView = null;
            fm.jiecao.jcvideoplayer_lib.JCResizeTextureView jCResizeTextureView = new fm.jiecao.jcvideoplayer_lib.JCResizeTextureView(getContext());
            this.textureView = jCResizeTextureView;
            jCResizeTextureView.setVideoSize(jcMediaManager.getVideoSize());
            this.textureView.setRotation(this.videoRotation);
            this.textureView.setSurfaceTextureListener(this);
            this.textureViewContainer.addView(this.textureView, new android.widget.FrameLayout.LayoutParams(-1, -1, 17));
        }
    }

    @Override // fm.jiecao.jcvideoplayer_lib.JCMediaPlayerListener
    public void autoFullscreen(int i) {
        int i2;
        if (this.isNeedScreen && isCurrentMediaListener() && checkGlobalVisible()) {
            int i3 = this.currentState;
            if (i3 == 2 && (i2 = this.currentScreen) != 2 && i2 != 3) {
                startWindowFullscreen(i);
            } else if (i3 == 2 && this.currentScreen == 2) {
                setRotation(i);
            }
        }
    }

    @Override // fm.jiecao.jcvideoplayer_lib.JCMediaPlayerListener
    public boolean backToOtherListener() {
        fm.jiecao.jcvideoplayer_lib.JCMediaPlayerListener popListener;
        com.moji.tool.log.MJLogger.i("zdxnative", "backToOtherListener  [" + hashCode() + "]     " + this.currentState);
        if (jcMediaManager == null) {
            return false;
        }
        int i = this.currentScreen;
        if (i != 2 && i != 3) {
            return false;
        }
        if (fm.jiecao.jcvideoplayer_lib.JCVideoPlayerManager.LISTENERLIST.size() == 1 && (popListener = fm.jiecao.jcvideoplayer_lib.JCVideoPlayerManager.popListener()) != null) {
            popListener.onCompletion();
            jcMediaManager.releaseMediaPlayer();
            return true;
        }
        ((android.view.ViewGroup) fm.jiecao.jcvideoplayer_lib.JCUtils.scanForActivity(getContext()).getWindow().getDecorView()).removeView(this);
        fm.jiecao.jcvideoplayer_lib.JCVideoPlayerManager.popListener();
        fm.jiecao.jcvideoplayer_lib.JCMediaPlayerListener first = fm.jiecao.jcvideoplayer_lib.JCVideoPlayerManager.getFirst();
        if (first != null) {
            first.goBackThisListener(this.currentState);
        }
        changeVoiceBack();
        return true;
    }

    public synchronized void cancelProgressTimer() {
        java.util.Timer timer = UPDATE_PROGRESS_TIMER;
        if (timer != null) {
            timer.cancel();
        }
        fm.jiecao.jcvideoplayer_lib.JCVideoPlayer.ProgressTimerTask progressTimerTask = this.mProgressTimerTask;
        if (progressTimerTask != null) {
            progressTimerTask.cancel();
        }
    }

    @Override // fm.jiecao.jcvideoplayer_lib.JCMediaPlayerListener
    public void changeSystemVoice(int i) {
        if (this.isNeedSystemVolume) {
            if (checkGlobalVisible()) {
                jcMediaManager.setVolume(i, i);
            }
            if (i == 0 || !checkGlobalVisible()) {
                jcMediaManager.setIsMute(true);
                releaseMusicFocus();
                this.voiceImageView.setImageResource(fm.jiecao.jcvideoplayer_lib.R.drawable.voice_stop_click_selector);
                this.iv_all_music.setImageResource(fm.jiecao.jcvideoplayer_lib.R.drawable.music_pre_stop);
                return;
            }
            jcMediaManager.setIsMute(false);
            this.voiceImageView.setImageResource(fm.jiecao.jcvideoplayer_lib.R.drawable.voice_start_click_selector);
            this.iv_all_music.setImageResource(fm.jiecao.jcvideoplayer_lib.R.drawable.music_pre_play);
            getMusicFocus();
        }
    }

    public void changeVideoState() {
        changeVideoState(false);
    }

    public void changeVideoState(boolean z) {
        if (android.text.TextUtils.isEmpty(this.url)) {
            com.moji.tool.log.MJLogger.w(TAG, "changeVideoState invalid url:" + this.url);
            if (z) {
                com.moji.tool.toast.PatchedToast.makeText(getContext(), getResources().getString(fm.jiecao.jcvideoplayer_lib.R.string.no_url), 0).show();
            }
            setUiWitStateAndScreen(7);
            return;
        }
        int i = this.currentState;
        if (i == 0 || i == 7) {
            if (!this.isNeedWifi && !this.url.startsWith("file") && com.moji.tool.DeviceTool.isConnected() && !com.moji.tool.DeviceTool.isConnectWifi() && !WIFI_TIP_DIALOG_SHOWED && this.isNeedWifiDialog) {
                showWifiDialog();
                return;
            }
            prepareVideo();
        } else if (i == 2) {
            stopVideoPlay();
        } else if (i == 5 || i == 1) {
            startVideoPlay();
        } else if (i == 6) {
            prepareVideo();
        }
        changeVoiceBack();
    }

    public void changeVoiceBack() {
        fm.jiecao.jcvideoplayer_lib.JCMediaManager jCMediaManager = jcMediaManager;
        if (jCMediaManager == null || jCMediaManager.isMute()) {
            this.voiceImageView.setImageResource(fm.jiecao.jcvideoplayer_lib.R.drawable.voice_stop_click_selector);
            this.iv_all_music.setImageResource(fm.jiecao.jcvideoplayer_lib.R.drawable.music_pre_stop);
        } else {
            this.voiceImageView.setImageResource(fm.jiecao.jcvideoplayer_lib.R.drawable.voice_start_click_selector);
            this.iv_all_music.setImageResource(fm.jiecao.jcvideoplayer_lib.R.drawable.music_pre_play);
        }
    }

    public boolean checkGlobalVisible() {
        return getGlobalVisibleRect(new android.graphics.Rect());
    }

    public void checkVisibleWhenPrepare(boolean z) {
        this.u = z;
    }

    public void clearFullscreenLayout() {
        android.view.ViewGroup viewGroup = (android.view.ViewGroup) fm.jiecao.jcvideoplayer_lib.JCUtils.scanForActivity(getContext()).getWindow().getDecorView();
        android.view.View findViewById = viewGroup.findViewById(FULLSCREEN_ID);
        android.view.View findViewById2 = viewGroup.findViewById(TINY_ID);
        if (findViewById != null) {
            viewGroup.removeView(findViewById);
        }
        if (findViewById2 != null) {
            viewGroup.removeView(findViewById2);
        }
    }

    public void dismissVolumeDialog() {
    }

    public int getCurrentPositionWhenPlaying() {
        fm.jiecao.jcvideoplayer_lib.JCMediaManager jCMediaManager = jcMediaManager;
        if (jCMediaManager == null) {
            return 0;
        }
        int i = this.currentState;
        if (i != 2 && i != 5 && i != 3) {
            return 0;
        }
        try {
            return jCMediaManager.getCurrentPosition();
        } catch (java.lang.IllegalStateException e) {
            com.moji.tool.log.MJLogger.e(TAG, e);
            return 0;
        }
    }

    public int getDuration() {
        fm.jiecao.jcvideoplayer_lib.JCMediaManager jCMediaManager = jcMediaManager;
        if (jCMediaManager == null) {
            return 0;
        }
        try {
            return jCMediaManager.getDuration();
        } catch (java.lang.IllegalStateException e) {
            com.moji.tool.log.MJLogger.e(TAG, e);
            return 0;
        }
    }

    public abstract int getLayoutId();

    public void getMusicFocus() {
        this.mAudioManager.requestAudioFocus(onAudioFocusChangeListener, 3, 2);
    }

    @Override // fm.jiecao.jcvideoplayer_lib.JCMediaPlayerListener
    public int getScreenType() {
        return this.currentScreen;
    }

    @Override // fm.jiecao.jcvideoplayer_lib.JCMediaPlayerListener
    public int getState() {
        return this.currentState;
    }

    @Override // fm.jiecao.jcvideoplayer_lib.JCMediaPlayerListener
    public java.lang.String getUrl() {
        return this.url;
    }

    @Override // fm.jiecao.jcvideoplayer_lib.JCMediaPlayerListener
    public void goBackThisListener(int i) {
        changeVoiceBack();
        fm.jiecao.jcvideoplayer_lib.JCMediaManager jCMediaManager = jcMediaManager;
        if (jCMediaManager != null) {
            jCMediaManager.setIsFull(false);
            this.currentState = i;
        }
        setUiWitStateAndScreen(this.currentState);
        addTextureView();
    }

    public void hideThumbImageView() {
    }

    public boolean isCurrentMediaListener() {
        fm.jiecao.jcvideoplayer_lib.JCMediaPlayerListener first = fm.jiecao.jcvideoplayer_lib.JCVideoPlayerManager.getFirst();
        return first != null && first == this;
    }

    public boolean isFullScreenDefaultMute() {
        return false;
    }

    @Override // fm.jiecao.jcvideoplayer_lib.JCMediaPlayerListener
    public void onAutoCompletion() {
        playStateChange(6);
        fm.jiecao.jcvideoplayer_lib.VideoPlayStateChangeCallBack videoPlayStateChangeCallBack = this.videoPlayStateClickCallBack;
        if (videoPlayStateChangeCallBack != null) {
            videoPlayStateChangeCallBack.palyStateChange(6);
        }
        if (!this.isNeedCyclePlay || !checkGlobalVisible()) {
            fm.jiecao.jcvideoplayer_lib.JCVideoPlayerManager.completeAll();
            return;
        }
        fm.jiecao.jcvideoplayer_lib.JCMediaManager jCMediaManager = jcMediaManager;
        if (jCMediaManager == null || jCMediaManager.isRelease()) {
            return;
        }
        jcMediaManager.seekTo(0L);
        startVideoPlay();
    }

    @Override // fm.jiecao.jcvideoplayer_lib.JCMediaPlayerListener
    public void onBufferingUpdate(int i) {
        int i2;
        if (jcMediaManager == null || (i2 = this.currentState) == 0 || i2 == 1) {
            return;
        }
        bufferPercent = i;
        setTextAndProgress(i);
    }

    @Override // android.view.View.OnClickListener
    @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
    public void onClick(android.view.View view) {
        int id = view.getId();
        if (id == fm.jiecao.jcvideoplayer_lib.R.id.start) {
            com.moji.tool.log.MJLogger.i(TAG, "onClick start [" + hashCode() + "] ");
            changeVideoState(true);
        } else if (id == fm.jiecao.jcvideoplayer_lib.R.id.fullscreen) {
            com.moji.tool.log.MJLogger.i(TAG, "onClick fullscreen [" + hashCode() + "] ");
            if (this.currentState == 6) {
                com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
                return;
            }
            if (this.currentScreen == 2) {
                backPress();
            } else {
                com.moji.tool.log.MJLogger.d(TAG, "toFullscreenActivity [" + hashCode() + "] ");
                startWindowFullscreen(90);
                fm.jiecao.jcvideoplayer_lib.FullScreenClickCallBack fullScreenClickCallBack = this.fullSceenClickCallBack;
                if (fullScreenClickCallBack != null) {
                    fullScreenClickCallBack.onClick();
                }
            }
        } else if (id == fm.jiecao.jcvideoplayer_lib.R.id.surface_container && this.currentState == 7) {
            com.moji.tool.log.MJLogger.i(TAG, "onClick surfaceContainer State=Error [" + hashCode() + "] ");
            prepareVideo();
        } else if (id == fm.jiecao.jcvideoplayer_lib.R.id.tv_full_detail) {
            this.bottomContainer.setVisibility(8);
            this.startButton.setVisibility(8);
            this.topContainer.setVisibility(8);
            fm.jiecao.jcvideoplayer_lib.FullDetailClickCallBack fullDetailClickCallBack = this.fullDetailClickCallBack;
            if (fullDetailClickCallBack != null) {
                fullDetailClickCallBack.onClick();
            }
        }
        com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    @Override // fm.jiecao.jcvideoplayer_lib.JCMediaPlayerListener
    public void onCompletion() {
        setUiWitStateAndScreen(0);
        if (this.textureViewContainer.getChildCount() > 0) {
            this.textureViewContainer.removeAllViews();
        }
        fm.jiecao.jcvideoplayer_lib.JCMediaManager jCMediaManager = jcMediaManager;
        if (jCMediaManager != null) {
            jCMediaManager.resetVideoSize();
            bufferPercent = 0;
            this.videoRotation = 0;
            jcMediaManager.setIsFull(false);
        }
        releaseMusicFocus();
        fm.jiecao.jcvideoplayer_lib.JCUtils.scanForActivity(getContext()).getWindow().clearFlags(128);
        clearFullscreenLayout();
    }

    @Override // fm.jiecao.jcvideoplayer_lib.JCMediaPlayerListener
    public void onError(int i, int i2) {
        if (i == 38 || i == -38) {
            return;
        }
        setUiWitStateAndScreen(7);
    }

    public void onFullScreenViewCreated(fm.jiecao.jcvideoplayer_lib.JCVideoPlayer jCVideoPlayer) {
    }

    @Override // fm.jiecao.jcvideoplayer_lib.JCMediaPlayerListener
    public void onInfo(int i, int i2) {
        if (jcMediaManager == null) {
            return;
        }
        if (i == 701) {
            this.backUpBufferState = this.currentState;
            setUiWitStateAndScreen(3);
            return;
        }
        if (i != 702) {
            if (i == 10001) {
                this.videoRotation = i2;
                this.textureView.setRotation(i2);
                return;
            }
            return;
        }
        int i3 = this.backUpBufferState;
        if (i3 != -1) {
            setUiWitStateAndScreen(i3);
            this.backUpBufferState = -1;
        }
    }

    @Override // fm.jiecao.jcvideoplayer_lib.JCMediaPlayerListener
    public void onPrepared() {
        com.moji.tool.log.MJLogger.i(TAG, "onPrepared  [" + hashCode() + "] ");
        fm.jiecao.jcvideoplayer_lib.JCMediaManager jCMediaManager = jcMediaManager;
        if (jCMediaManager != null && !jCMediaManager.isRelease()) {
            if (this.currentState != 1) {
                return;
            }
            jcMediaManager.start();
            hideThumbImageView();
            int i = this.seekToInAdvance;
            if (i != -1) {
                jcMediaManager.seekTo(i);
                this.seekToInAdvance = -1;
            }
        }
        setUiWitStateAndScreen(2);
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onProgressChanged(android.widget.SeekBar seekBar, int i, boolean z) {
        fm.jiecao.jcvideoplayer_lib.IVideoPlayProcessChanged iVideoPlayProcessChanged = this.iVideoPlayProcessChanged;
        if (iVideoPlayProcessChanged != null) {
            iVideoPlayProcessChanged.onProcessChanged(i);
        }
    }

    @Override // fm.jiecao.jcvideoplayer_lib.JCMediaPlayerListener
    public void onScrollChange() {
    }

    @Override // fm.jiecao.jcvideoplayer_lib.JCMediaPlayerListener
    public void onSeekComplete() {
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onStartTrackingTouch(android.widget.SeekBar seekBar) {
        cancelProgressTimer();
        for (android.view.ViewParent parent = getParent(); parent != null; parent = parent.getParent()) {
            parent.requestDisallowInterceptTouchEvent(true);
        }
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
    public void onStopTrackingTouch(android.widget.SeekBar seekBar) {
        startProgressTimer();
        for (android.view.ViewParent parent = getParent(); parent != null; parent = parent.getParent()) {
            parent.requestDisallowInterceptTouchEvent(false);
        }
        if (jcMediaManager == null) {
            com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(seekBar);
            return;
        }
        int i = this.currentState;
        if ((i != 2 && i != 5) || !this.isCanSpeed) {
            com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(seekBar);
            return;
        }
        jcMediaManager.seekTo((seekBar.getProgress() * getDuration()) / 100);
        com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(seekBar);
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(android.graphics.SurfaceTexture surfaceTexture, int i, int i2) {
        if (jcMediaManager == null) {
            return;
        }
        android.view.Surface surface = new android.view.Surface(surfaceTexture);
        this.surface = surface;
        jcMediaManager.setDisplay(surface, this.textureView);
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(android.graphics.SurfaceTexture surfaceTexture) {
        android.view.Surface surface = this.surface;
        if (surface != null) {
            surface.release();
        }
        surfaceTexture.release();
        return true;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(android.graphics.SurfaceTexture surfaceTexture, int i, int i2) {
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(android.graphics.SurfaceTexture surfaceTexture) {
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(android.view.View view, android.view.MotionEvent motionEvent) {
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        if (view.getId() == fm.jiecao.jcvideoplayer_lib.R.id.surface_container) {
            int action = motionEvent.getAction();
            if (action == 0) {
                com.moji.tool.log.MJLogger.i(TAG, "onTouch surfaceContainer actionDown [" + hashCode() + "] ");
                this.mTouchingProgressBar = true;
                this.mDownX = x;
                this.mDownY = y;
                this.mChangeVolume = false;
                this.mChangePosition = false;
            } else if (action == 1) {
                com.moji.tool.log.MJLogger.i(TAG, "onTouch surfaceContainer actionUp [" + hashCode() + "] ");
                this.mTouchingProgressBar = false;
                dismissVolumeDialog();
                if (this.mChangePosition) {
                    fm.jiecao.jcvideoplayer_lib.JCMediaManager jCMediaManager = jcMediaManager;
                    if (jCMediaManager != null) {
                        jCMediaManager.seekTo(this.mSeekTimePosition);
                    }
                    int duration = getDuration();
                    this.progressBar.setProgress((this.mSeekTimePosition * 100) / (duration != 0 ? duration : 1));
                }
                startProgressTimer();
            } else if (action == 2) {
                com.moji.tool.log.MJLogger.i(TAG, "onTouch surfaceContainer actionMove [" + hashCode() + "] ");
                float f = x - this.mDownX;
                float f2 = y - this.mDownY;
                float abs = java.lang.Math.abs(f);
                float abs2 = java.lang.Math.abs(f2);
                if (this.currentScreen == 2 && !this.mChangePosition && !this.mChangeVolume && (abs > 80.0f || abs2 > 80.0f)) {
                    cancelProgressTimer();
                    if (abs < 80.0f) {
                        this.mChangeVolume = true;
                        this.mGestureDownVolume = this.mAudioManager.getStreamVolume(3);
                    } else if (this.currentState != 7) {
                        this.mChangePosition = true;
                        this.mDownPosition = getCurrentPositionWhenPlaying();
                    }
                }
                if (this.mChangePosition) {
                    int duration2 = getDuration();
                    int i = (int) (this.mDownPosition + ((f * duration2) / this.mScreenWidth));
                    this.mSeekTimePosition = i;
                    if (i > duration2) {
                        this.mSeekTimePosition = duration2;
                    }
                }
                if (this.mChangeVolume) {
                    float f3 = -f2;
                    this.mAudioManager.setStreamVolume(3, this.mGestureDownVolume + ((int) (((this.mAudioManager.getStreamMaxVolume(3) * f3) * 3.0f) / this.mScreenHeight)), 0);
                    showVolumeDialog(-f3, (int) (((this.mGestureDownVolume * 100) / r9) + (((3.0f * f3) * 100.0f) / this.mScreenHeight)));
                }
            }
        }
        return false;
    }

    @Override // fm.jiecao.jcvideoplayer_lib.JCMediaPlayerListener
    public void onVideoSizeChanged() {
        fm.jiecao.jcvideoplayer_lib.JCMediaManager jCMediaManager = jcMediaManager;
        if (jCMediaManager == null) {
            return;
        }
        this.textureView.setVideoSize(jCMediaManager.getVideoSize());
    }

    public void pauseVideoPlay() {
        stopVideoPlay();
    }

    public void playStateChange(int i) {
    }

    public void prepareVideo() {
        int i;
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append(" checkVisibleWhenPrepare    ");
        sb.append(this.u);
        sb.append("       ");
        sb.append(!checkGlobalVisible());
        com.moji.tool.log.MJLogger.d("zdxvideo1", sb.toString());
        fm.jiecao.jcvideoplayer_lib.JCVideoPlayerManager.completeAll();
        fm.jiecao.jcvideoplayer_lib.JCVideoPlayerManager.putListener(this);
        addTextureView();
        jcMediaManager.setIsMute(false);
        if (this.isNeedMute && ((i = this.currentScreen) == 0 || i == 1)) {
            jcMediaManager.setVolume(0, 0);
            releaseMusicFocus();
            jcMediaManager.setIsMute(true);
        }
        getMusicFocus();
        fm.jiecao.jcvideoplayer_lib.JCUtils.scanForActivity(getContext()).getWindow().addFlags(128);
        fm.jiecao.jcvideoplayer_lib.JCVideoPlayerManager.putScrollListener(this);
        fm.jiecao.jcvideoplayer_lib.JCMediaManager jCMediaManager = jcMediaManager;
        if (jCMediaManager != null) {
            jCMediaManager.prepare(this.url, this.mapHeadData, this.looping);
        }
        setUiWitStateAndScreen(1);
    }

    public void release() {
        releaseAllVideos();
    }

    public void releaseMusicFocus() {
        this.mAudioManager.abandonAudioFocus(onAudioFocusChangeListener);
    }

    public void resetProgressAndTime() {
        this.progressBar.setProgress(0);
        this.progressBar.setSecondaryProgress(0);
        this.currentTimeTextView.setText(fm.jiecao.jcvideoplayer_lib.JCUtils.stringForTime(0));
        this.tv_time.setText(fm.jiecao.jcvideoplayer_lib.JCUtils.stringForTotalTime(this.time_total));
        this.totalTimeTextView.setText(fm.jiecao.jcvideoplayer_lib.JCUtils.stringForTime(0));
    }

    public void resumeVideoPlay() {
        getMusicFocus();
        this.thumbImageView.setVisibility(8);
        fm.jiecao.jcvideoplayer_lib.JCMediaManager jCMediaManager = jcMediaManager;
        if (jCMediaManager != null && !jCMediaManager.isRelease()) {
            jcMediaManager.start();
        }
        setUiWitStateAndScreen(2);
    }

    public abstract void setAllControlsVisible(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8);

    public void setPreviewImage(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return;
        }
        this.picPath = str;
        if (com.moji.tool.Utils.activityIsAlive(this.thumbImageView)) {
            com.bumptech.glide.Glide.with(this.thumbImageView).load(str).into(this.thumbImageView);
        }
    }

    public void setPreviewImageWithCorner(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return;
        }
        this.picPath = str;
        if (com.moji.tool.Utils.activityIsAlive(this.thumbImageView)) {
            com.bumptech.glide.Glide.with(this.thumbImageView).load(str).transform(new com.bumptech.glide.load.resource.bitmap.RoundedCorners(com.moji.tool.DeviceTool.dp2px(2.0f))).into(this.thumbImageView);
        }
    }

    public void setPreviewImageWithCorner(java.lang.String str, @androidx.annotation.Px int i, @androidx.annotation.Nullable android.graphics.drawable.Drawable drawable) {
        if (android.text.TextUtils.isEmpty(str)) {
            this.thumbImageView.setImageDrawable(drawable);
            return;
        }
        this.picPath = str;
        if (com.moji.tool.Utils.activityIsAlive(this.thumbImageView)) {
            com.bumptech.glide.Glide.with(this.thumbImageView).load(str).transform(new com.bumptech.glide.load.resource.bitmap.RoundedCorners(i)).placeholder(drawable).into(this.thumbImageView);
        }
    }

    public void setProgressAndTime(int i, int i2, int i3, int i4) {
        if (!this.mTouchingProgressBar && i != 0) {
            this.progressBar.setProgress(i);
        }
        if (i2 > 95) {
            i2 = 100;
        }
        if (i2 != 0) {
            this.progressBar.setSecondaryProgress(i2);
        }
        if (i3 != 0) {
            this.currentTimeTextView.setText(fm.jiecao.jcvideoplayer_lib.JCUtils.stringForTime(i3 < i4 ? i3 : i4));
        }
        int i5 = i4 - i3;
        if (i5 < 0) {
            this.tv_time.setVisibility(8);
        } else if (i5 == 0) {
            this.tv_time.setText(fm.jiecao.jcvideoplayer_lib.JCUtils.stringForTotalTime(this.time_total));
        } else {
            this.tv_time.setText(fm.jiecao.jcvideoplayer_lib.JCUtils.stringForTime(i5));
        }
        this.totalTimeTextView.setText(fm.jiecao.jcvideoplayer_lib.JCUtils.stringForTime(i4));
    }

    public void setTextAndProgress(int i) {
        int currentPositionWhenPlaying = getCurrentPositionWhenPlaying();
        int duration = getDuration();
        setProgressAndTime((currentPositionWhenPlaying * 100) / (duration == 0 ? 1 : duration), i, currentPositionWhenPlaying, duration);
    }

    public void setUiWitStateAndScreen(int i) {
        if (jcMediaManager == null) {
            return;
        }
        if (this.videoPlayStateClickCallBack != null) {
            playStateChange(i);
            this.videoPlayStateClickCallBack.palyStateChange(i);
        }
        this.currentState = i;
        if (jcMediaManager.isMute()) {
            jcMediaManager.setVolume(0, 0);
            releaseMusicFocus();
        }
        int i2 = this.currentState;
        if (i2 == 0) {
            if (isCurrentMediaListener()) {
                cancelProgressTimer();
                jcMediaManager.releaseMediaPlayer();
            }
            jcMediaManager.stopScreenSwitch();
            return;
        }
        if (i2 == 1) {
            resetProgressAndTime();
            return;
        }
        if (i2 == 2 || i2 == 3) {
            jcMediaManager.startScreenSwitch(this.isNeedScreen);
            startProgressTimer();
            return;
        }
        if (i2 == 5) {
            jcMediaManager.stopScreenSwitch();
            startProgressTimer();
            return;
        }
        if (i2 == 6) {
            jcMediaManager.stopScreenSwitch();
            cancelProgressTimer();
            this.progressBar.setProgress(100);
            this.currentTimeTextView.setText(this.totalTimeTextView.getText());
            this.tv_time.setText(fm.jiecao.jcvideoplayer_lib.JCUtils.stringForTotalTime(this.time_total));
            return;
        }
        if (i2 != 7) {
            return;
        }
        jcMediaManager.stopScreenSwitch();
        cancelProgressTimer();
        if (isCurrentMediaListener()) {
            jcMediaManager.releaseMediaPlayer();
            int i3 = this.n;
            if (i3 < 3) {
                this.n = i3 + 1;
                prepareVideo();
            }
        }
    }

    public boolean setUp(java.lang.String str, int i, java.lang.Object... objArr) {
        if (jcMediaManager == null) {
            com.moji.tool.log.MJLogger.w(TAG, "setUp invalid state, jcMediaManager instance null");
            return false;
        }
        if (!android.text.TextUtils.isEmpty(this.url) && android.text.TextUtils.equals(this.url, str)) {
            com.moji.tool.log.MJLogger.w(TAG, "setUp url not changed, new url:" + str + ", now url:" + this.url);
            return false;
        }
        fm.jiecao.jcvideoplayer_lib.JCVideoPlayerManager.checkAndPutListener(this);
        this.t = -1;
        java.lang.ref.WeakReference<fm.jiecao.jcvideoplayer_lib.JCMediaPlayerListener> weakReference = fm.jiecao.jcvideoplayer_lib.JCVideoPlayerManager.CURRENT_SCROLL_LISTENER;
        if (weakReference != null && weakReference.get() != null) {
            this.t = 0;
            if (this == fm.jiecao.jcvideoplayer_lib.JCVideoPlayerManager.CURRENT_SCROLL_LISTENER.get()) {
                this.t = 1;
                if (((fm.jiecao.jcvideoplayer_lib.JCVideoPlayer) fm.jiecao.jcvideoplayer_lib.JCVideoPlayerManager.CURRENT_SCROLL_LISTENER.get()).currentState == 2) {
                    this.t = 2;
                }
            }
        }
        com.moji.tool.log.MJLogger.i(TAG, "setUp step:" + this.t);
        this.url = str;
        this.objects = objArr;
        this.currentScreen = i;
        setUiWitStateAndScreen(0);
        if (str.equals(jcMediaManager.getDataSource())) {
            fm.jiecao.jcvideoplayer_lib.JCVideoPlayerManager.putScrollListener(this);
        }
        return true;
    }

    public void setVideoImageDisplayType(int i) {
        VIDEO_IMAGE_DISPLAY_TYPE = i;
        fm.jiecao.jcvideoplayer_lib.JCResizeTextureView jCResizeTextureView = this.textureView;
        if (jCResizeTextureView != null) {
            jCResizeTextureView.requestLayout();
        }
    }

    public void showVolumeDialog(float f, int i) {
    }

    public void showWifiDialog() {
    }

    public synchronized void startProgressTimer() {
        cancelProgressTimer();
        UPDATE_PROGRESS_TIMER = new java.util.Timer();
        fm.jiecao.jcvideoplayer_lib.JCVideoPlayer.ProgressTimerTask progressTimerTask = new fm.jiecao.jcvideoplayer_lib.JCVideoPlayer.ProgressTimerTask(new java.lang.ref.WeakReference(this));
        this.mProgressTimerTask = progressTimerTask;
        UPDATE_PROGRESS_TIMER.schedule(progressTimerTask, 0L, 300L);
    }

    public void startVideoPlay() {
        getMusicFocus();
        this.thumbImageView.setVisibility(8);
        fm.jiecao.jcvideoplayer_lib.JCMediaManager jCMediaManager = jcMediaManager;
        if (jCMediaManager != null && !jCMediaManager.isRelease()) {
            jcMediaManager.start();
        }
        setUiWitStateAndScreen(2);
    }

    public void startWindowFullscreen(int i) {
        int i2;
        android.view.WindowInsets rootWindowInsets;
        android.view.ViewGroup viewGroup = (android.view.ViewGroup) fm.jiecao.jcvideoplayer_lib.JCUtils.scanForActivity(getContext()).getWindow().getDecorView();
        android.view.View findViewById = viewGroup.findViewById(FULLSCREEN_ID);
        if (findViewById != null) {
            viewGroup.removeView(findViewById);
        }
        if (this.textureViewContainer.getChildCount() > 0) {
            this.textureViewContainer.removeAllViews();
        }
        try {
            fm.jiecao.jcvideoplayer_lib.JCVideoPlayer jCVideoPlayer = (fm.jiecao.jcvideoplayer_lib.JCVideoPlayer) getClass().getConstructor(android.content.Context.class).newInstance(getContext());
            jCVideoPlayer.setId(FULLSCREEN_ID);
            jCVideoPlayer.fullDetailClickCallBack = this.fullDetailClickCallBack;
            jCVideoPlayer.isNeedWifi = this.isNeedWifi;
            jCVideoPlayer.videoPlayStateClickCallBack = this.videoPlayStateClickCallBack;
            android.view.WindowManager windowManager = (android.view.WindowManager) getContext().getSystemService("window");
            android.util.DisplayMetrics displayMetrics = new android.util.DisplayMetrics();
            windowManager.getDefaultDisplay().getRealMetrics(displayMetrics);
            int i3 = displayMetrics.widthPixels;
            int i4 = displayMetrics.heightPixels;
            int a = a(getContext());
            if (-1 != a) {
                android.widget.LinearLayout.LayoutParams layoutParams = (android.widget.LinearLayout.LayoutParams) jCVideoPlayer.voiceImageView.getLayoutParams();
                layoutParams.setMargins(a, 0, 0, 0);
                jCVideoPlayer.voiceImageView.setLayoutParams(layoutParams);
                jCVideoPlayer.rl_video_2.setBackgroundColor(android.graphics.Color.parseColor("#000000"));
                android.widget.RelativeLayout.LayoutParams layoutParams2 = (android.widget.RelativeLayout.LayoutParams) jCVideoPlayer.backButton.getLayoutParams();
                layoutParams2.setMargins(a, 0, 0, 0);
                jCVideoPlayer.backButton.setLayoutParams(layoutParams2);
                android.widget.RelativeLayout.LayoutParams layoutParams3 = (android.widget.RelativeLayout.LayoutParams) jCVideoPlayer.bottomContainer.getLayoutParams();
                layoutParams3.setMargins(0, 0, a, 0);
                jCVideoPlayer.bottomContainer.setLayoutParams(layoutParams3);
            }
            boolean isFullScreenDefaultMute = isFullScreenDefaultMute();
            jcMediaManager.setIsMute(isFullScreenDefaultMute);
            if (android.os.Build.VERSION.SDK_INT >= 28) {
                rootWindowInsets = this.rl_video.getRootView().getRootWindowInsets();
                i2 = com.moji.tool.DeviceTool.getTopDisPlayCutoutHeight(rootWindowInsets);
            } else {
                i2 = 0;
            }
            android.widget.FrameLayout.LayoutParams layoutParams4 = new android.widget.FrameLayout.LayoutParams(i4, i3);
            int i5 = i3 - i4;
            layoutParams4.setMargins(i5 / 2, ((-i5) / 2) + i2, 0, 0);
            viewGroup.addView(jCVideoPlayer, layoutParams4);
            jCVideoPlayer.setUp(this.url, 2, this.objects);
            if (com.moji.tool.Utils.activityIsAlive(this.thumbImageView)) {
                com.bumptech.glide.Glide.with(jCVideoPlayer.thumbImageView).load(this.picPath).into(jCVideoPlayer.thumbImageView);
            }
            jCVideoPlayer.setUiWitStateAndScreen(this.currentState);
            jCVideoPlayer.addTextureView();
            jCVideoPlayer.setRotation(i);
            fm.jiecao.jcvideoplayer_lib.JCVideoPlayerManager.putListener(jCVideoPlayer);
            if (isFullScreenDefaultMute) {
                jcMediaManager.setVolume(0, 0);
            } else {
                int streamVolume = this.mAudioManager.getStreamVolume(3);
                jcMediaManager.setVolume(streamVolume, streamVolume);
            }
            getMusicFocus();
            onFullScreenViewCreated(jCVideoPlayer);
        } catch (java.lang.InstantiationException e) {
            com.moji.tool.log.MJLogger.e(TAG, e);
        } catch (java.lang.Exception e2) {
            com.moji.tool.log.MJLogger.e(TAG, e2);
        }
    }

    public void stopVideoPlay() {
        com.moji.tool.log.MJLogger.d(TAG, "pauseVideo [" + hashCode() + "] ");
        fm.jiecao.jcvideoplayer_lib.JCMediaManager jCMediaManager = jcMediaManager;
        if (jCMediaManager != null && !jCMediaManager.isRelease()) {
            jcMediaManager.pause();
            setUiWitStateAndScreen(5);
        }
        releaseMusicFocus();
    }
}
