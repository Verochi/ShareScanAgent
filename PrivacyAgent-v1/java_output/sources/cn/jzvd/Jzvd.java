package cn.jzvd;

/* loaded from: classes.dex */
public abstract class Jzvd extends android.widget.FrameLayout implements android.view.View.OnClickListener, android.widget.SeekBar.OnSeekBarChangeListener, android.view.View.OnTouchListener {
    public static final int FULLSCREEN_ORIENTATION = 6;
    public static final int NORMAL_ORIENTATION = 1;
    public static final float PROGRESS_DRAG_RATE = 1.0f;
    public static final boolean SAVE_PROGRESS = false;
    public static final int SCREEN_FULLSCREEN = 1;
    public static final int SCREEN_NORMAL = 0;
    public static final int SCREEN_TINY = 2;
    public static final int STATE_AUTO_COMPLETE = 7;
    public static final int STATE_ERROR = 8;
    public static final int STATE_IDLE = -1;
    public static final int STATE_NORMAL = 0;
    public static final int STATE_PAUSE = 6;
    public static final int STATE_PLAYING = 5;
    public static final int STATE_PREPARED = 4;
    public static final int STATE_PREPARING = 1;
    public static final int STATE_PREPARING_CHANGE_URL = 2;
    public static final int STATE_PREPARING_PLAYING = 3;
    public static final int STATE_RELEASE = 9;
    public static final java.lang.String TAG = "JZVD";
    public static final int THRESHOLD = 80;
    public static final boolean TOOL_BAR_EXIST = true;
    public static final int VIDEO_IMAGE_DISPLAY_TYPE_ADAPTER = 0;
    public static final int VIDEO_IMAGE_DISPLAY_TYPE_FILL_PARENT = 1;
    public static final int VIDEO_IMAGE_DISPLAY_TYPE_FILL_SCROP = 2;
    public static final int VIDEO_IMAGE_DISPLAY_TYPE_ORIGINAL = 3;
    public static boolean WIFI_TIP_DIALOG_SHOWED;
    protected java.util.Timer UPDATE_PROGRESS_TIMER;
    public int backUpBufferState;
    protected int blockHeight;
    protected int blockIndex;
    protected android.view.ViewGroup.LayoutParams blockLayoutParams;
    protected int blockWidth;
    public android.view.ViewGroup bottomContainer;
    public android.widget.TextView currentTimeTextView;
    public android.widget.ImageView fullscreenButton;
    protected long goBackFullscreenTime;
    protected long gotoFullscreenTime;
    public int heightRatio;
    public boolean isSeekBarTrack;
    public cn.jzvd.JZDataSource jzDataSource;
    protected android.content.Context jzvdContext;
    protected android.media.AudioManager mAudioManager;
    protected boolean mChangeBrightness;
    protected boolean mChangePosition;
    protected boolean mChangeVolume;
    protected long mCurrentPosition;
    protected float mDownX;
    protected float mDownY;
    protected float mGestureDownBrightness;
    protected long mGestureDownPosition;
    protected int mGestureDownVolume;
    protected cn.jzvd.Jzvd.ProgressTimerTask mProgressTimerTask;
    protected int mScreenHeight;
    protected int mScreenWidth;
    protected long mSeekTimePosition;
    protected android.view.View mSurfaceContainerParent;
    protected boolean mTouchingProgressBar;
    protected long mVideoDuration;
    public cn.jzvd.JZMediaInterface mediaInterface;
    public java.lang.Class mediaInterfaceClass;
    public final java.util.LinkedList<android.view.ViewGroup> n;
    public boolean needRepeat;
    public boolean preloading;
    public android.widget.SeekBar progressBar;
    public int screen;
    public long seekToInAdvance;
    public int seekToManulPosition;
    public android.widget.ImageView startButton;
    public int state;
    public int t;
    public cn.jzvd.JZTextureView textureView;
    public android.view.ViewGroup textureViewContainer;
    public android.view.ViewGroup topContainer;
    public android.widget.TextView totalTimeTextView;
    public cn.jzvd.Jzvd.OnAliyunPositionChangeListener u;
    public int videoRotation;
    public int widthRatio;

    public interface OnAliyunPositionChangeListener {
        void onPositionChange(long j);
    }

    public class ProgressTimerTask extends java.util.TimerTask {
        public ProgressTimerTask() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b() {
            long currentPositionWhenPlaying = cn.jzvd.Jzvd.this.getCurrentPositionWhenPlaying();
            long duration = cn.jzvd.Jzvd.this.getDuration();
            cn.jzvd.Jzvd.this.onProgress((int) ((100 * currentPositionWhenPlaying) / (duration == 0 ? 1L : duration)), currentPositionWhenPlaying, duration);
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            cn.jzvd.Jzvd jzvd = cn.jzvd.Jzvd.this;
            if (jzvd.state == 5) {
                jzvd.post(new defpackage.mu0(this));
            }
        }
    }

    public Jzvd(android.content.Context context) {
        super(context);
        this.backUpBufferState = -1;
        this.n = new java.util.LinkedList<>();
        this.isSeekBarTrack = false;
        this.state = -1;
        this.screen = -1;
        this.widthRatio = 0;
        this.heightRatio = 0;
        this.videoRotation = 0;
        this.seekToManulPosition = -1;
        this.seekToInAdvance = 0L;
        this.preloading = false;
        this.goBackFullscreenTime = 0L;
        this.gotoFullscreenTime = 0L;
        this.needRepeat = false;
        this.t = 0;
        init(context);
    }

    public Jzvd(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
        this.backUpBufferState = -1;
        this.n = new java.util.LinkedList<>();
        this.isSeekBarTrack = false;
        this.state = -1;
        this.screen = -1;
        this.widthRatio = 0;
        this.heightRatio = 0;
        this.videoRotation = 0;
        this.seekToManulPosition = -1;
        this.seekToInAdvance = 0L;
        this.preloading = false;
        this.goBackFullscreenTime = 0L;
        this.gotoFullscreenTime = 0L;
        this.needRepeat = false;
        this.t = 0;
        init(context);
    }

    public boolean backPress() {
        com.moji.tool.log.MJLogger.i("JZVD", "backPress");
        if (!this.n.isEmpty()) {
            gotoNormalScreen();
            return true;
        }
        if (this.screen == 0) {
            return false;
        }
        clearFloatScreen();
        return true;
    }

    public void cancelProgressTimer() {
        cn.jzvd.Jzvd.ProgressTimerTask progressTimerTask = this.mProgressTimerTask;
        if (progressTimerTask != null) {
            progressTimerTask.cancel();
            this.mProgressTimerTask = null;
        }
        java.util.Timer timer = this.UPDATE_PROGRESS_TIMER;
        if (timer != null) {
            timer.cancel();
            this.UPDATE_PROGRESS_TIMER.purge();
            this.UPDATE_PROGRESS_TIMER = null;
        }
    }

    public void changeUrl(cn.jzvd.JZDataSource jZDataSource, long j) {
        this.jzDataSource = jZDataSource;
        this.seekToInAdvance = j;
        onStatePreparingChangeUrl();
    }

    public void clearFloatScreen() {
        cn.jzvd.JZUtils.showStatusBar(getContext());
        cn.jzvd.JZUtils.setRequestedOrientation(getContext(), 1);
        cn.jzvd.JZUtils.showSystemUI(getContext());
        ((android.view.ViewGroup) cn.jzvd.JZUtils.scanForActivity(getContext()).getWindow().getDecorView()).removeView(this);
        cn.jzvd.JZMediaInterface jZMediaInterface = this.mediaInterface;
        if (jZMediaInterface != null) {
            jZMediaInterface.release();
            this.mediaInterface = null;
        }
    }

    public void clickFullscreen() {
        com.moji.tool.log.MJLogger.i("JZVD", "onClick fullscreen [" + hashCode() + "] ");
        if (this.state == 7) {
            return;
        }
        if (this.screen == 1) {
            backPress();
            return;
        }
        com.moji.tool.log.MJLogger.d("JZVD", "toFullscreenActivity [" + hashCode() + "] ");
        gotoFullscreen();
    }

    public void clickStart() {
        com.moji.tool.log.MJLogger.i("JZVD", "onClick start [" + hashCode() + "] ");
        cn.jzvd.JZDataSource jZDataSource = this.jzDataSource;
        if (jZDataSource == null || jZDataSource.urlsMap.isEmpty() || this.jzDataSource.getCurrentUrl() == null) {
            return;
        }
        int i = this.state;
        if (i == 0) {
            if (this.jzDataSource.getCurrentUrl().toString().startsWith("file") || this.jzDataSource.getCurrentUrl().toString().startsWith(net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR) || cn.jzvd.JZUtils.isWifiConnected(getContext()) || WIFI_TIP_DIALOG_SHOWED) {
                startVideo();
                return;
            } else {
                showWifiDialog();
                return;
            }
        }
        if (i == 5) {
            com.moji.tool.log.MJLogger.d("JZVD", "pauseVideo [" + hashCode() + "] ");
            this.mediaInterface.pause(true);
            return;
        }
        if (i == 6) {
            this.mediaInterface.start();
            onStatePlaying();
            org.greenrobot.eventbus.EventBus.getDefault().post(new cn.jzvd.ShortVideoReplayEvent());
        } else if (i == 7) {
            startVideo();
        } else if (i == 8) {
            com.moji.tool.ToastTool.showToast("视频无法播放");
        }
    }

    public void cloneAJzvd(android.view.ViewGroup viewGroup) {
        try {
            cn.jzvd.Jzvd jzvd = (cn.jzvd.Jzvd) getClass().getConstructor(android.content.Context.class).newInstance(getContext());
            jzvd.setId(getId());
            jzvd.setMinimumWidth(this.blockWidth);
            jzvd.setMinimumHeight(this.blockHeight);
            viewGroup.addView(jzvd, this.blockIndex, this.blockLayoutParams);
            jzvd.setUp(this.jzDataSource.cloneMe(), 0, this.mediaInterfaceClass);
        } catch (java.lang.IllegalAccessException | java.lang.InstantiationException | java.lang.NoSuchMethodException | java.lang.reflect.InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    public void dismissBrightnessDialog() {
    }

    public void dismissProgressDialog() {
    }

    public void dismissVolumeDialog() {
    }

    public android.content.Context getApplicationContext() {
        android.content.Context applicationContext;
        android.content.Context context = getContext();
        return (context == null || (applicationContext = context.getApplicationContext()) == null) ? context : applicationContext;
    }

    public long getCurrentPositionWhenPlaying() {
        cn.jzvd.JZMediaInterface jZMediaInterface;
        int i = this.state;
        if ((i != 5 && i != 6 && i != 3) || (jZMediaInterface = this.mediaInterface) == null) {
            return 0L;
        }
        try {
            return jZMediaInterface.getCurrentPosition();
        } catch (java.lang.IllegalStateException e) {
            e.printStackTrace();
            return 0L;
        }
    }

    public long getDuration() {
        try {
            return this.mediaInterface.getDuration();
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return 0L;
        }
    }

    public abstract int getLayoutId();

    public int getReplayTimes() {
        return this.t;
    }

    public void gotoFullscreen() {
        this.gotoFullscreenTime = java.lang.System.currentTimeMillis();
        android.view.ViewGroup viewGroup = (android.view.ViewGroup) getParent();
        this.jzvdContext = viewGroup.getContext();
        this.blockLayoutParams = getLayoutParams();
        this.blockIndex = viewGroup.indexOfChild(this);
        this.blockWidth = getWidth();
        this.blockHeight = getHeight();
        viewGroup.removeView(this);
        cloneAJzvd(viewGroup);
        this.n.add(viewGroup);
        ((android.view.ViewGroup) cn.jzvd.JZUtils.scanForActivity(this.jzvdContext).getWindow().getDecorView()).addView(this, new android.widget.FrameLayout.LayoutParams(-1, -1));
        setScreenFullscreen();
        cn.jzvd.JZUtils.hideStatusBar(this.jzvdContext);
        cn.jzvd.JZUtils.setRequestedOrientation(this.jzvdContext, 6);
        cn.jzvd.JZUtils.hideSystemUI(this.jzvdContext);
    }

    public void gotoNormalCompletion() {
        this.goBackFullscreenTime = java.lang.System.currentTimeMillis();
        ((android.view.ViewGroup) cn.jzvd.JZUtils.scanForActivity(this.jzvdContext).getWindow().getDecorView()).removeView(this);
        this.textureViewContainer.removeView(this.textureView);
        this.n.getLast().removeViewAt(this.blockIndex);
        this.n.getLast().addView(this, this.blockIndex, this.blockLayoutParams);
        this.n.pop();
        setScreenNormal();
        cn.jzvd.JZUtils.showStatusBar(this.jzvdContext);
        cn.jzvd.JZUtils.setRequestedOrientation(this.jzvdContext, 1);
        cn.jzvd.JZUtils.showSystemUI(this.jzvdContext);
    }

    public void gotoNormalScreen() {
        this.goBackFullscreenTime = java.lang.System.currentTimeMillis();
        ((android.view.ViewGroup) cn.jzvd.JZUtils.scanForActivity(this.jzvdContext).getWindow().getDecorView()).removeView(this);
        this.n.getLast().removeViewAt(this.blockIndex);
        this.n.getLast().addView(this, this.blockIndex, this.blockLayoutParams);
        this.n.pop();
        setScreenNormal();
        cn.jzvd.JZUtils.showStatusBar(this.jzvdContext);
        cn.jzvd.JZUtils.setRequestedOrientation(this.jzvdContext, 1);
        cn.jzvd.JZUtils.showSystemUI(this.jzvdContext);
    }

    public void init(android.content.Context context) {
        android.view.View.inflate(context, getLayoutId(), this);
        this.jzvdContext = context;
        this.startButton = (android.widget.ImageView) findViewById(fm.jiecao.jcvideoplayer_lib.R.id.start);
        this.fullscreenButton = (android.widget.ImageView) findViewById(fm.jiecao.jcvideoplayer_lib.R.id.fullscreen);
        this.progressBar = (android.widget.SeekBar) findViewById(fm.jiecao.jcvideoplayer_lib.R.id.bottom_seek_progress);
        this.currentTimeTextView = (android.widget.TextView) findViewById(fm.jiecao.jcvideoplayer_lib.R.id.current);
        this.totalTimeTextView = (android.widget.TextView) findViewById(fm.jiecao.jcvideoplayer_lib.R.id.total);
        this.bottomContainer = (android.view.ViewGroup) findViewById(fm.jiecao.jcvideoplayer_lib.R.id.layout_bottom);
        this.textureViewContainer = (android.view.ViewGroup) findViewById(fm.jiecao.jcvideoplayer_lib.R.id.surface_container);
        this.mSurfaceContainerParent = findViewById(fm.jiecao.jcvideoplayer_lib.R.id.surfaceContainerParent);
        this.topContainer = (android.view.ViewGroup) findViewById(fm.jiecao.jcvideoplayer_lib.R.id.layout_top);
        if (this.startButton == null) {
            this.startButton = new android.widget.ImageView(context);
        }
        if (this.fullscreenButton == null) {
            this.fullscreenButton = new android.widget.ImageView(context);
        }
        if (this.progressBar == null) {
            this.progressBar = new android.widget.SeekBar(context);
        }
        if (this.currentTimeTextView == null) {
            this.currentTimeTextView = new android.widget.TextView(context);
        }
        if (this.totalTimeTextView == null) {
            this.totalTimeTextView = new android.widget.TextView(context);
        }
        if (this.bottomContainer == null) {
            this.bottomContainer = new android.widget.LinearLayout(context);
        }
        if (this.textureViewContainer == null) {
            this.textureViewContainer = new android.widget.FrameLayout(context);
        }
        if (this.topContainer == null) {
            this.topContainer = new android.widget.RelativeLayout(context);
        }
        this.startButton.setOnClickListener(this);
        this.fullscreenButton.setOnClickListener(this);
        this.progressBar.setOnSeekBarChangeListener(this);
        this.bottomContainer.setOnClickListener(this);
        this.textureViewContainer.setOnClickListener(this);
        this.textureViewContainer.setOnTouchListener(this);
        this.mSurfaceContainerParent.setOnTouchListener(this);
        this.mScreenWidth = getContext().getResources().getDisplayMetrics().widthPixels;
        this.mScreenHeight = getContext().getResources().getDisplayMetrics().heightPixels;
        this.state = -1;
    }

    public boolean isMute() {
        cn.jzvd.JZMediaInterface jZMediaInterface = this.mediaInterface;
        if (jZMediaInterface != null) {
            return jZMediaInterface.isMute();
        }
        return false;
    }

    public boolean isReleased() {
        return this.state == 9;
    }

    public void onAliyunCurrentPositionChange(long j) {
        cn.jzvd.Jzvd.OnAliyunPositionChangeListener onAliyunPositionChangeListener = this.u;
        if (onAliyunPositionChangeListener != null) {
            onAliyunPositionChangeListener.onPositionChange(j);
        }
    }

    @Override // android.view.View.OnClickListener
    @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
    public void onClick(android.view.View view) {
        int id = view.getId();
        if (id == fm.jiecao.jcvideoplayer_lib.R.id.start) {
            clickStart();
        } else if (id == fm.jiecao.jcvideoplayer_lib.R.id.fullscreen) {
            clickFullscreen();
        } else if (id == fm.jiecao.jcvideoplayer_lib.R.id.surfaceContainerParent) {
            videoParentClick();
        }
        com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public void onCompletion() {
        java.lang.Runtime.getRuntime().gc();
        cancelProgressTimer();
        dismissBrightnessDialog();
        dismissProgressDialog();
        dismissVolumeDialog();
        onStateAutoComplete();
        cn.jzvd.JZMediaInterface jZMediaInterface = this.mediaInterface;
        if (jZMediaInterface != null) {
            jZMediaInterface.release();
            this.mediaInterface = null;
        }
        onStateRelease();
        cn.jzvd.JZUtils.scanForActivity(getContext()).getWindow().clearFlags(128);
        if (this.screen == 1) {
            if (this.n.isEmpty()) {
                clearFloatScreen();
            } else {
                gotoNormalCompletion();
            }
        }
    }

    public void onError(int i, int i2) {
        if (i == 38 || i2 == -38 || i == -38 || i2 == 38 || i2 == -19) {
            return;
        }
        onStateError();
    }

    public void onInfo(int i, int i2) {
        com.moji.tool.log.MJLogger.d("JZVD", "onInfo what - " + i + " extra - " + i2);
        if (i == 3) {
            com.moji.tool.log.MJLogger.d("JZVD", "MEDIA_INFO_VIDEO_RENDERING_START");
            int i3 = this.state;
            if (i3 == 4 || i3 == 2 || i3 == 3) {
                onStatePlaying();
                return;
            }
            return;
        }
        if (i == 701) {
            com.moji.tool.log.MJLogger.d("JZVD", "MEDIA_INFO_BUFFERING_START");
            this.backUpBufferState = this.state;
            setState(3);
        } else if (i == 702) {
            com.moji.tool.log.MJLogger.d("JZVD", "MEDIA_INFO_BUFFERING_END");
            int i4 = this.backUpBufferState;
            if (i4 != -1) {
                setState(i4);
                this.backUpBufferState = -1;
            }
        }
    }

    public void onLoadingBegin() {
    }

    public void onLoadingEnd() {
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        int i3 = this.screen;
        if (i3 == 1 || i3 == 2) {
            super.onMeasure(i, i2);
            return;
        }
        if (this.widthRatio == 0 || this.heightRatio == 0) {
            super.onMeasure(i, i2);
            return;
        }
        int size = android.view.View.MeasureSpec.getSize(i);
        int i4 = (int) ((size * this.heightRatio) / this.widthRatio);
        setMeasuredDimension(size, i4);
        getChildAt(0).measure(android.view.View.MeasureSpec.makeMeasureSpec(size, 1073741824), android.view.View.MeasureSpec.makeMeasureSpec(i4, 1073741824));
    }

    public void onPrepared() {
        com.moji.tool.log.MJLogger.i("JZVD", "onPrepared  [" + hashCode() + "] ");
        int i = this.state;
        this.state = 4;
        if (!this.preloading && i != 6 && i != 8 && i != 9) {
            this.mediaInterface.start();
            this.preloading = false;
        }
        if (this.jzDataSource.getCurrentUrl().toString().toLowerCase().contains("mp3") || this.jzDataSource.getCurrentUrl().toString().toLowerCase().contains("wma") || this.jzDataSource.getCurrentUrl().toString().toLowerCase().contains("aac") || this.jzDataSource.getCurrentUrl().toString().toLowerCase().contains("m4a") || this.jzDataSource.getCurrentUrl().toString().toLowerCase().contains("wav")) {
            onStatePlaying();
        }
    }

    public void onProgress(int i, long j, long j2) {
        this.mCurrentPosition = j;
        this.mVideoDuration = j2;
        if (!this.mTouchingProgressBar) {
            int i2 = this.seekToManulPosition;
            if (i2 == -1) {
                this.progressBar.setProgress(i);
            } else if (i2 > i) {
                return;
            } else {
                this.seekToManulPosition = -1;
            }
        }
        if (j != 0) {
            this.currentTimeTextView.setText(cn.jzvd.JZUtils.stringForTime(j));
        }
        this.totalTimeTextView.setText(cn.jzvd.JZUtils.stringForTime(j2));
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onProgressChanged(android.widget.SeekBar seekBar, int i, boolean z) {
        if (z) {
            this.currentTimeTextView.setText(cn.jzvd.JZUtils.stringForTime((i * getDuration()) / 100));
        }
    }

    public void onSeekComplete() {
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onStartTrackingTouch(android.widget.SeekBar seekBar) {
        com.moji.tool.log.MJLogger.i("JZVD", "bottomProgress onStartTrackingTouch [" + hashCode() + "] ");
        this.isSeekBarTrack = true;
        cancelProgressTimer();
        for (android.view.ViewParent parent = getParent(); parent != null; parent = parent.getParent()) {
            parent.requestDisallowInterceptTouchEvent(true);
        }
    }

    public void onStateAutoComplete() {
        this.state = 7;
        cancelProgressTimer();
        this.progressBar.setProgress(100);
        this.currentTimeTextView.setText(this.totalTimeTextView.getText());
    }

    public void onStateError() {
        this.state = 8;
        cancelProgressTimer();
    }

    public void onStateNormal() {
        com.moji.tool.log.MJLogger.i("JZVD", "onStateNormal  [" + hashCode() + "] ");
        this.state = 0;
        cancelProgressTimer();
        cn.jzvd.JZMediaInterface jZMediaInterface = this.mediaInterface;
        if (jZMediaInterface != null) {
            jZMediaInterface.release();
            this.mediaInterface = null;
        }
    }

    public void onStatePause(boolean z) {
        this.state = 6;
        cancelProgressTimer();
    }

    public void onStatePlaying() {
        com.moji.tool.log.MJLogger.i("JZVD", "onStatePlaying  [" + hashCode() + "] ");
        if (this.state == 4) {
            com.moji.tool.log.MJLogger.d("JZVD", "onStatePlaying:STATE_PREPARED ");
            this.mAudioManager = (android.media.AudioManager) getApplicationContext().getSystemService("audio");
            long j = this.seekToInAdvance;
            if (j != 0) {
                this.mediaInterface.seekTo(j);
                this.seekToInAdvance = 0L;
            }
        }
        this.state = 5;
        if (this.isSeekBarTrack) {
            return;
        }
        startProgressTimer();
    }

    public void onStatePreparing() {
        com.moji.tool.log.MJLogger.i("JZVD", "onStatePreparing  [" + hashCode() + "] ");
        this.state = 1;
        resetProgressAndTime();
    }

    public void onStatePreparingChangeUrl() {
        com.moji.tool.log.MJLogger.i("JZVD", "onStatePreparingChangeUrl  [" + hashCode() + "] ");
        this.state = 2;
        releaseAllVideos();
        startVideo();
    }

    public void onStatePreparingPlaying() {
        com.moji.tool.log.MJLogger.i("JZVD", "onStatePreparingPlaying  [" + hashCode() + "] ");
        this.state = 3;
    }

    public void onStateRelease() {
        this.state = 9;
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
    public void onStopTrackingTouch(android.widget.SeekBar seekBar) {
        com.moji.tool.log.MJLogger.i("JZVD", "bottomProgress onStopTrackingTouch [" + hashCode() + "] ");
        startProgressTimer();
        for (android.view.ViewParent parent = getParent(); parent != null; parent = parent.getParent()) {
            parent.requestDisallowInterceptTouchEvent(false);
        }
        int i = this.state;
        if (i != 5 && i != 6) {
            com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(seekBar);
            return;
        }
        long progress = (seekBar.getProgress() * getDuration()) / 100;
        this.seekToManulPosition = seekBar.getProgress();
        this.mediaInterface.seekTo(progress);
        this.mediaInterface.start();
        this.state = 5;
        com.moji.tool.log.MJLogger.i("JZVD", "seekTo " + progress + " [" + hashCode() + "] ");
        com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(seekBar);
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(android.view.View view, android.view.MotionEvent motionEvent) {
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        if (view.getId() != fm.jiecao.jcvideoplayer_lib.R.id.surface_container) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            touchActionDown(x, y);
            return false;
        }
        if (action == 1) {
            touchActionUp();
            return false;
        }
        if (action != 2) {
            return false;
        }
        touchActionMove(x, y);
        return false;
    }

    public void onVideoSizeChanged(int i, int i2) {
        com.moji.tool.log.MJLogger.i("JZVD", "onVideoSizeChanged  [" + hashCode() + "] ");
        cn.jzvd.JZTextureView jZTextureView = this.textureView;
        if (jZTextureView != null) {
            int i3 = this.videoRotation;
            if (i3 != 0) {
                jZTextureView.setRotation(i3);
            }
            this.textureView.setVideoSize(i, i2);
        }
    }

    public void pause() {
        pause(true);
    }

    public void pause(boolean z) {
        cn.jzvd.JZMediaInterface jZMediaInterface = this.mediaInterface;
        if (jZMediaInterface != null) {
            jZMediaInterface.pause(z);
        }
    }

    public void releaseAllVideos() {
        com.moji.tool.log.MJLogger.d("JZVD", "releaseAllVideos");
        reset();
        this.n.clear();
    }

    public void reset() {
        cancelProgressTimer();
        dismissBrightnessDialog();
        dismissProgressDialog();
        dismissVolumeDialog();
        onStateNormal();
        cn.jzvd.JZTextureView jZTextureView = this.textureView;
        if (jZTextureView != null) {
            jZTextureView.setSurfaceTextureListener(null);
        }
        this.textureViewContainer.removeAllViews();
        this.textureView = null;
        cn.jzvd.JZUtils.scanForActivity(getContext()).getWindow().clearFlags(128);
        cn.jzvd.JZMediaInterface jZMediaInterface = this.mediaInterface;
        if (jZMediaInterface != null) {
            jZMediaInterface.release();
            this.mediaInterface = null;
        }
        onStateRelease();
    }

    public void resetProgressAndTime() {
        this.mCurrentPosition = 0L;
        this.progressBar.setProgress(0);
        this.progressBar.setSecondaryProgress(0);
        this.currentTimeTextView.setText(cn.jzvd.JZUtils.stringForTime(0L));
        this.totalTimeTextView.setText(cn.jzvd.JZUtils.stringForTime(0L));
    }

    public void seekTo(long j) {
        cn.jzvd.JZMediaInterface jZMediaInterface = this.mediaInterface;
        if (jZMediaInterface != null) {
            jZMediaInterface.seekTo(j);
        }
    }

    public void setAliyunPositionChangeListener(cn.jzvd.Jzvd.OnAliyunPositionChangeListener onAliyunPositionChangeListener) {
        this.u = onAliyunPositionChangeListener;
    }

    public void setBufferProgress(int i) {
        this.progressBar.setSecondaryProgress(i);
    }

    public void setMute(boolean z) {
        cn.jzvd.JZMediaInterface jZMediaInterface = this.mediaInterface;
        if (jZMediaInterface != null) {
            jZMediaInterface.setMute(z);
        }
    }

    public void setReplayTimes(int i) {
        this.t = i;
    }

    public void setScreen(int i) {
        if (i == 0) {
            setScreenNormal();
        } else if (i == 1) {
            setScreenFullscreen();
        } else {
            if (i != 2) {
                return;
            }
            setScreenTiny();
        }
    }

    public void setScreenFullscreen() {
        this.screen = 1;
    }

    public void setScreenNormal() {
        this.screen = 0;
    }

    public void setScreenTiny() {
        this.screen = 2;
    }

    public void setState(int i) {
        switch (i) {
            case 0:
                onStateNormal();
                break;
            case 1:
                onStatePreparing();
                break;
            case 2:
                onStatePreparingChangeUrl();
                break;
            case 3:
                onStatePreparingPlaying();
                break;
            case 5:
                onStatePlaying();
                break;
            case 6:
                onStatePause(true);
                break;
            case 7:
                onStateAutoComplete();
                break;
            case 8:
                onStateError();
                break;
        }
    }

    public void setTextureViewRotation(int i) {
        cn.jzvd.JZTextureView jZTextureView = this.textureView;
        if (jZTextureView != null) {
            jZTextureView.setRotation(i);
        }
    }

    public void setUp(cn.jzvd.JZDataSource jZDataSource, int i) {
        setUp(jZDataSource, i, cn.jzvd.JZMediaSystem.class);
    }

    public void setUp(cn.jzvd.JZDataSource jZDataSource, int i, java.lang.Class<?> cls) {
        this.jzDataSource = jZDataSource;
        this.screen = i;
        onStateNormal();
        this.mediaInterfaceClass = cls;
    }

    public void setUp(java.lang.String str, java.lang.String str2) {
        setUp(new cn.jzvd.JZDataSource(str, str2), 0);
    }

    public void setUp(java.lang.String str, java.lang.String str2, int i) {
        setUp(new cn.jzvd.JZDataSource(str, str2), i);
    }

    public void setUp(java.lang.String str, java.lang.String str2, int i, java.lang.Class<?> cls) {
        setUp(new cn.jzvd.JZDataSource(str, str2), i, cls);
    }

    public void setVideoImageDisplayType(int i) {
        cn.jzvd.JZTextureView jZTextureView = this.textureView;
        if (jZTextureView != null) {
            jZTextureView.requestLayout();
        }
    }

    public void showBrightnessDialog(int i) {
    }

    public void showProgressDialog(float f, java.lang.String str, long j, java.lang.String str2, long j2) {
    }

    public void showVolumeDialog(float f, int i) {
    }

    public void showWifiDialog() {
    }

    public void start() {
        cn.jzvd.JZMediaInterface jZMediaInterface = this.mediaInterface;
        if (jZMediaInterface != null) {
            jZMediaInterface.start();
        }
    }

    public void startProgressTimer() {
        com.moji.tool.log.MJLogger.i("JZVD", "startProgressTimer:  [" + hashCode() + "] ");
        cancelProgressTimer();
        try {
            this.UPDATE_PROGRESS_TIMER = new java.util.Timer();
            cn.jzvd.Jzvd.ProgressTimerTask progressTimerTask = new cn.jzvd.Jzvd.ProgressTimerTask();
            this.mProgressTimerTask = progressTimerTask;
            this.UPDATE_PROGRESS_TIMER.schedule(progressTimerTask, 0L, 50L);
        } catch (java.lang.Exception e) {
            com.moji.tool.log.MJLogger.e("JZVD", "startProgressTimer: " + e.getMessage());
        }
    }

    public void startVideo() {
        com.moji.tool.log.MJLogger.d("JZVD", "startVideo [" + hashCode() + "] ");
        if (this.mediaInterface == null) {
            try {
                this.mediaInterface = (cn.jzvd.JZMediaInterface) this.mediaInterfaceClass.getConstructor(cn.jzvd.Jzvd.class).newInstance(this);
            } catch (java.lang.IllegalAccessException | java.lang.InstantiationException | java.lang.NoSuchMethodException | java.lang.reflect.InvocationTargetException e) {
                e.printStackTrace();
            }
        }
        if (this.textureView == null) {
            cn.jzvd.JZTextureView jZTextureView = new cn.jzvd.JZTextureView(getContext().getApplicationContext());
            this.textureView = jZTextureView;
            jZTextureView.setSurfaceTextureListener(this.mediaInterface);
        }
        if (this.textureViewContainer.indexOfChild(this.textureView) < 0) {
            this.textureViewContainer.addView(this.textureView, new android.widget.FrameLayout.LayoutParams(-1, -1, 17));
        }
        cn.jzvd.JZUtils.scanForActivity(getContext()).getWindow().addFlags(128);
        onStatePreparing();
    }

    public void touchActionDown(float f, float f2) {
        com.moji.tool.log.MJLogger.i("JZVD", "onTouch surfaceContainer actionDown [" + hashCode() + "] ");
        this.mTouchingProgressBar = true;
        this.mDownX = f;
        this.mDownY = f2;
        this.mChangeVolume = false;
        this.mChangePosition = false;
        this.mChangeBrightness = false;
    }

    public void touchActionMove(float f, float f2) {
        android.media.AudioManager audioManager;
        com.moji.tool.log.MJLogger.i("JZVD", "onTouch surfaceContainer actionMove [" + hashCode() + "] ");
        float f3 = f - this.mDownX;
        float f4 = f2 - this.mDownY;
        float abs = java.lang.Math.abs(f3);
        float abs2 = java.lang.Math.abs(f4);
        if (this.screen == 1) {
            if (this.mDownX > cn.jzvd.JZUtils.getScreenWidth(getContext()) || this.mDownY < cn.jzvd.JZUtils.getStatusBarHeight(getContext())) {
                return;
            }
            if (!this.mChangePosition && !this.mChangeVolume && !this.mChangeBrightness && (abs > 80.0f || abs2 > 80.0f)) {
                cancelProgressTimer();
                if (abs >= 80.0f) {
                    if (this.state != 8) {
                        this.mChangePosition = true;
                        this.mGestureDownPosition = getCurrentPositionWhenPlaying();
                    }
                } else if (this.mDownX < this.mScreenHeight * 0.5f) {
                    this.mChangeBrightness = true;
                    float f5 = cn.jzvd.JZUtils.getWindow(getContext()).getAttributes().screenBrightness;
                    if (f5 < 0.0f) {
                        try {
                            this.mGestureDownBrightness = android.provider.Settings.System.getInt(getContext().getContentResolver(), "screen_brightness");
                            com.moji.tool.log.MJLogger.i("JZVD", "current system brightness: " + this.mGestureDownBrightness);
                        } catch (android.provider.Settings.SettingNotFoundException e) {
                            e.printStackTrace();
                        }
                    } else {
                        this.mGestureDownBrightness = f5 * 255.0f;
                        com.moji.tool.log.MJLogger.i("JZVD", "current activity brightness: " + this.mGestureDownBrightness);
                    }
                } else {
                    this.mChangeVolume = true;
                    android.media.AudioManager audioManager2 = this.mAudioManager;
                    if (audioManager2 != null) {
                        this.mGestureDownVolume = audioManager2.getStreamVolume(3);
                    }
                }
            }
        }
        if (this.mChangePosition) {
            long duration = getDuration();
            long j = (int) (this.mGestureDownPosition + ((duration * f3) / (this.mScreenWidth * 1.0f)));
            this.mSeekTimePosition = j;
            if (j > duration) {
                this.mSeekTimePosition = duration;
            }
            showProgressDialog(f3, cn.jzvd.JZUtils.stringForTime(this.mSeekTimePosition), this.mSeekTimePosition, cn.jzvd.JZUtils.stringForTime(duration), duration);
        }
        if (this.mChangeVolume && (audioManager = this.mAudioManager) != null) {
            f4 = -f4;
            this.mAudioManager.setStreamVolume(3, this.mGestureDownVolume + ((int) (((audioManager.getStreamMaxVolume(3) * f4) * 3.0f) / this.mScreenHeight)), 0);
            showVolumeDialog(-f4, (int) (((this.mGestureDownVolume * 100) / r14) + (((f4 * 3.0f) * 100.0f) / this.mScreenHeight)));
        }
        if (this.mChangeBrightness) {
            float f6 = -f4;
            android.view.WindowManager.LayoutParams attributes = cn.jzvd.JZUtils.getWindow(getContext()).getAttributes();
            float f7 = this.mGestureDownBrightness;
            float f8 = (int) (((f6 * 255.0f) * 3.0f) / this.mScreenHeight);
            if ((f7 + f8) / 255.0f >= 1.0f) {
                attributes.screenBrightness = 1.0f;
            } else if ((f7 + f8) / 255.0f <= 0.0f) {
                attributes.screenBrightness = 0.01f;
            } else {
                attributes.screenBrightness = (f7 + f8) / 255.0f;
            }
            cn.jzvd.JZUtils.getWindow(getContext()).setAttributes(attributes);
            showBrightnessDialog((int) (((this.mGestureDownBrightness * 100.0f) / 255.0f) + (((f6 * 3.0f) * 100.0f) / this.mScreenHeight)));
        }
    }

    public void touchActionUp() {
        com.moji.tool.log.MJLogger.i("JZVD", "onTouch surfaceContainer actionUp [" + hashCode() + "] ");
        this.mTouchingProgressBar = false;
        dismissProgressDialog();
        dismissVolumeDialog();
        dismissBrightnessDialog();
        if (this.mChangePosition) {
            this.mediaInterface.seekTo(this.mSeekTimePosition);
            long duration = getDuration();
            long j = this.mSeekTimePosition * 100;
            if (duration == 0) {
                duration = 1;
            }
            this.progressBar.setProgress((int) (j / duration));
        }
        startProgressTimer();
    }

    public void videoParentClick() {
    }
}
