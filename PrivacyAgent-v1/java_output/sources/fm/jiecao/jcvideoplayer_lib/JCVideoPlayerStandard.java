package fm.jiecao.jcvideoplayer_lib;

/* loaded from: classes9.dex */
public class JCVideoPlayerStandard extends fm.jiecao.jcvideoplayer_lib.JCVideoPlayer {
    protected static java.util.Timer DISMISS_CONTROL_VIEW_TIMER;
    protected static android.graphics.Bitmap pauseSwitchCoverBitmap;
    protected android.widget.ImageView coverImageView;
    protected android.widget.ProgressBar mDialogVolumeProgressBar;
    protected fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard.DismissControlViewTimerTask mDismissControlViewTimerTask;
    protected android.app.Dialog mVolumeDialog;
    protected boolean textureSizeChanged;
    protected boolean textureUpdated;
    public android.widget.ProgressBar v;
    public android.widget.ImageView w;
    public fm.jiecao.jcvideoplayer_lib.JCResizeImageView x;
    public fm.jiecao.jcvideoplayer_lib.PreviewViewClickCallBack y;
    public fm.jiecao.jcvideoplayer_lib.VolumeClickCallBack z;

    /* renamed from: fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard$1, reason: invalid class name */
    public class AnonymousClass1 implements android.content.DialogInterface.OnClickListener {
        public AnonymousClass1() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
        public void onClick(android.content.DialogInterface dialogInterface, int i) {
            dialogInterface.dismiss();
            fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard.this.startPlayLogic();
            fm.jiecao.jcvideoplayer_lib.JCVideoPlayer.WIFI_TIP_DIALOG_SHOWED = true;
            com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackDialog(dialogInterface, i);
        }
    }

    /* renamed from: fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard$2, reason: invalid class name */
    public class AnonymousClass2 implements android.content.DialogInterface.OnClickListener {
        public AnonymousClass2() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
        public void onClick(android.content.DialogInterface dialogInterface, int i) {
            dialogInterface.dismiss();
            fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard.this.stopPlayByNoWiFi();
            com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackDialog(dialogInterface, i);
        }
    }

    public static class DismissControlViewTimerTask extends java.util.TimerTask {
        public java.lang.ref.WeakReference<fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard> n;

        /* renamed from: fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard$DismissControlViewTimerTask$1, reason: invalid class name */
        public class AnonymousClass1 implements java.lang.Runnable {
            public final /* synthetic */ fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard n;

            public AnonymousClass1(fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard jCVideoPlayerStandard) {
                this.n = jCVideoPlayerStandard;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.n.showTimerTaskView();
            }
        }

        public DismissControlViewTimerTask(java.lang.ref.WeakReference<fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard> weakReference) {
            this.n = weakReference;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard jCVideoPlayerStandard;
            int i;
            java.lang.ref.WeakReference<fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard> weakReference = this.n;
            if (weakReference == null || (jCVideoPlayerStandard = weakReference.get()) == null || (i = jCVideoPlayerStandard.currentState) == 0 || i == 7 || i == 6 || jCVideoPlayerStandard.getContext() == null || !(jCVideoPlayerStandard.getContext() instanceof android.app.Activity)) {
                return;
            }
            ((android.app.Activity) jCVideoPlayerStandard.getContext()).runOnUiThread(new fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard.DismissControlViewTimerTask.AnonymousClass1(jCVideoPlayerStandard));
        }
    }

    public JCVideoPlayerStandard(android.content.Context context) {
        super(context);
        this.y = null;
        this.z = null;
        c();
    }

    public JCVideoPlayerStandard(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
        this.y = null;
        this.z = null;
        c();
    }

    private void c() {
        this.thumbImageView = (android.widget.ImageView) findViewById(fm.jiecao.jcvideoplayer_lib.R.id.thumb);
        this.coverImageView = (android.widget.ImageView) findViewById(fm.jiecao.jcvideoplayer_lib.R.id.cover);
        this.v = (android.widget.ProgressBar) findViewById(fm.jiecao.jcvideoplayer_lib.R.id.loading);
        this.w = (android.widget.ImageView) findViewById(fm.jiecao.jcvideoplayer_lib.R.id.back_tiny);
        this.x = (fm.jiecao.jcvideoplayer_lib.JCResizeImageView) findViewById(fm.jiecao.jcvideoplayer_lib.R.id.cache);
        this.thumbImageView.setOnClickListener(this);
        this.backButton.setOnClickListener(this);
        this.w.setOnClickListener(this);
        this.voiceImageView.setOnClickListener(this);
        this.iv_all_music.setOnClickListener(this);
    }

    @androidx.annotation.RequiresApi(api = 14)
    private void d() {
        android.graphics.Bitmap bitmap;
        android.graphics.Point videoSize = fm.jiecao.jcvideoplayer_lib.JCVideoPlayer.jcMediaManager.getVideoSize();
        if (videoSize == null || (bitmap = this.textureView.getBitmap(videoSize.x, videoSize.y)) == null) {
            return;
        }
        pauseSwitchCoverBitmap = bitmap;
    }

    @Override // fm.jiecao.jcvideoplayer_lib.JCVideoPlayer
    public void addTextureView() {
        super.addTextureView();
        this.x.setVideoSize(fm.jiecao.jcvideoplayer_lib.JCVideoPlayer.jcMediaManager.getVideoSize());
        this.x.setRotation(this.videoRotation);
    }

    @Override // fm.jiecao.jcvideoplayer_lib.JCVideoPlayer, fm.jiecao.jcvideoplayer_lib.JCMediaPlayerListener
    @androidx.annotation.RequiresApi(api = 14)
    public boolean backToOtherListener() {
        d();
        boolean backToOtherListener = super.backToOtherListener();
        refreshCache();
        return backToOtherListener;
    }

    public void cancelDismissControlViewTimer() {
        java.util.Timer timer = DISMISS_CONTROL_VIEW_TIMER;
        if (timer != null) {
            timer.cancel();
        }
        fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard.DismissControlViewTimerTask dismissControlViewTimerTask = this.mDismissControlViewTimerTask;
        if (dismissControlViewTimerTask != null) {
            dismissControlViewTimerTask.cancel();
        }
    }

    public void changeUiToCompleteClear() {
        int i = this.currentScreen;
        if (i == 0 || i == 1) {
            setAllControlsVisible(4, 4, 0, 4, 0, 4, 0, 4);
            updateStartImage();
        } else {
            if (i != 2) {
                return;
            }
            setAllControlsVisible(4, 4, 0, 4, 0, 4, 0, 4);
            updateStartImage();
        }
    }

    public void changeUiToCompleteShow() {
        int i = this.currentScreen;
        if (i == 0 || i == 1) {
            setAllControlsVisible(0, 0, 0, 4, 0, 4, 4, 4);
            updateStartImage();
        } else {
            if (i != 2) {
                return;
            }
            setAllControlsVisible(0, 0, 0, 4, 0, 4, 4, 4);
            updateStartImage();
        }
    }

    public void changeUiToNormal() {
        int i = this.currentScreen;
        if (i == -1) {
            setAllControlsVisible(4, 4, 4, 4, 0, 4, 4, 4);
            return;
        }
        if (i == 0 || i == 1) {
            setAllControlsVisible(0, 4, 0, 4, 0, 0, 4, 0);
            updateStartImage();
        } else if (i == 2) {
            setAllControlsVisible(0, 4, 0, 4, 0, 0, 4, 0);
            updateStartImage();
        } else {
            if (i != 3) {
                return;
            }
            setAllControlsVisible(4, 4, 4, 4, 0, 4, 4, 4);
        }
    }

    public void changeUiToPauseClear() {
        int i = this.currentScreen;
        if (i == 0 || i == 1) {
            setAllControlsVisible(4, 4, 4, 4, 4, 4, 4, this.x.getVisibility());
        } else {
            if (i != 2) {
                return;
            }
            setAllControlsVisible(4, 4, 4, 4, 4, 4, 4, this.x.getVisibility());
        }
    }

    public void changeUiToPauseShow() {
        int i = this.currentScreen;
        if (i == 0 || i == 1) {
            setAllControlsVisible(0, 0, 0, 4, 4, 4, 4, this.x.getVisibility());
            updateStartImage();
        } else {
            if (i != 2) {
                return;
            }
            setAllControlsVisible(0, 0, 0, 4, 4, 4, 4, this.x.getVisibility());
            updateStartImage();
        }
    }

    public void changeUiToPlayingBufferingClear() {
        int i = this.currentScreen;
        if (i == 0 || i == 1) {
            setAllControlsVisible(4, 4, 4, 0, 4, 4, 0, this.x.getVisibility());
            updateStartImage();
        } else {
            if (i != 2) {
                return;
            }
            setAllControlsVisible(4, 4, 4, 0, 4, 4, 0, this.x.getVisibility());
            updateStartImage();
        }
    }

    public void changeUiToPlayingBufferingShow() {
        int i = this.currentScreen;
        if (i == 0 || i == 1) {
            setAllControlsVisible(0, 0, 4, 0, 4, 4, 4, this.x.getVisibility());
        } else {
            if (i != 2) {
                return;
            }
            setAllControlsVisible(0, 0, 4, 0, 4, 4, 4, this.x.getVisibility());
        }
    }

    public void changeUiToPlayingClear() {
        int i = this.currentScreen;
        if (i == 0 || i == 1) {
            setAllControlsVisible(4, 4, 4, 4, 4, 4, 0, this.x.getVisibility());
        } else {
            if (i != 2) {
                return;
            }
            setAllControlsVisible(4, 4, 4, 4, 4, 4, 0, this.x.getVisibility());
        }
    }

    public void changeUiToPlayingShow() {
        int i = this.currentScreen;
        if (i == 0 || i == 1) {
            setAllControlsVisible(0, 0, 0, 4, 4, 4, 4, this.x.getVisibility());
            updateStartImage();
        } else {
            if (i != 2) {
                return;
            }
            setAllControlsVisible(0, 0, 0, 4, 4, 4, 4, this.x.getVisibility());
            updateStartImage();
        }
    }

    public void changeUiToPreparingClear() {
        int i = this.currentScreen;
        if (i == 0 || i == 1) {
            setAllControlsVisible(4, 4, 4, 0, 4, 0, 4, 0);
        } else {
            if (i != 2) {
                return;
            }
            setAllControlsVisible(4, 4, 4, 0, 4, 0, 4, 0);
        }
    }

    public void changeUiToPreparingShow() {
        int i = this.currentScreen;
        if (i == 0 || i == 1) {
            setAllControlsVisible(0, 4, 4, 0, 0, 0, 4, 0);
        } else {
            if (i != 2) {
                return;
            }
            setAllControlsVisible(0, 0, 4, 0, 0, 0, 4, 0);
        }
    }

    public void changeVoiceFullScreenSize() {
        android.widget.LinearLayout.LayoutParams layoutParams = (android.widget.LinearLayout.LayoutParams) this.voiceImageView.getLayoutParams();
        layoutParams.width = (int) getResources().getDimension(fm.jiecao.jcvideoplayer_lib.R.dimen.voice_video_w_full);
        layoutParams.height = (int) getResources().getDimension(fm.jiecao.jcvideoplayer_lib.R.dimen.voice_video_h_full);
        this.voiceImageView.setLayoutParams(layoutParams);
    }

    public void changeVoiceNormalSize() {
        android.widget.LinearLayout.LayoutParams layoutParams = (android.widget.LinearLayout.LayoutParams) this.voiceImageView.getLayoutParams();
        layoutParams.width = (int) getResources().getDimension(fm.jiecao.jcvideoplayer_lib.R.dimen.voice_video_w);
        layoutParams.height = (int) getResources().getDimension(fm.jiecao.jcvideoplayer_lib.R.dimen.voice_video_h);
        this.voiceImageView.setLayoutParams(layoutParams);
    }

    public void clearCacheImage() {
        pauseSwitchCoverBitmap = null;
        this.x.setImageBitmap(null);
    }

    @Override // fm.jiecao.jcvideoplayer_lib.JCVideoPlayer
    public void dismissVolumeDialog() {
        super.dismissVolumeDialog();
        android.app.Dialog dialog = this.mVolumeDialog;
        if (dialog != null) {
            dialog.dismiss();
        }
    }

    public int getCurrentState() {
        return this.currentState;
    }

    public boolean getIsNeedWifi() {
        return this.isNeedWifi;
    }

    @Override // fm.jiecao.jcvideoplayer_lib.JCVideoPlayer
    public int getLayoutId() {
        return fm.jiecao.jcvideoplayer_lib.R.layout.jc_layout_standard;
    }

    public boolean needShowThis(android.view.View view) {
        if (this.isNeedShowView) {
            return this.tv_time.equals(view) ? this.isNeedTime : this.iv_all_music.equals(view) ? this.isNeedVoice : this.startButton.equals(view) ? this.isNeedControlButton : this.bottomContainer.equals(view) ? this.isNeedControlBar : this.rl_wifi_toast.equals(view) ? this.isNeedWifi : this.fullscreenButton.equals(view) ? this.isNeedFullButton : this.v.equals(view);
        }
        return false;
    }

    @Override // fm.jiecao.jcvideoplayer_lib.JCVideoPlayer, android.view.View.OnClickListener
    @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
    public void onClick(android.view.View view) {
        super.onClick(view);
        int id = view.getId();
        if (id == fm.jiecao.jcvideoplayer_lib.R.id.thumb) {
            fm.jiecao.jcvideoplayer_lib.PreviewViewClickCallBack previewViewClickCallBack = this.y;
            if (previewViewClickCallBack != null) {
                previewViewClickCallBack.onClick();
            }
            if (this.currentState == 6) {
                onClickUiToggle();
            }
        } else if (id == fm.jiecao.jcvideoplayer_lib.R.id.surface_container) {
            startDismissControlViewTimer();
        } else if (id == fm.jiecao.jcvideoplayer_lib.R.id.back) {
            fm.jiecao.jcvideoplayer_lib.JCVideoPlayer.backPress();
        } else if (id == fm.jiecao.jcvideoplayer_lib.R.id.back_tiny) {
            java.lang.ref.WeakReference<fm.jiecao.jcvideoplayer_lib.JCMediaPlayerListener> weakReference = fm.jiecao.jcvideoplayer_lib.JCVideoPlayerManager.CURRENT_SCROLL_LISTENER;
            if (weakReference != null && weakReference.get() != null && !fm.jiecao.jcvideoplayer_lib.JCVideoPlayerManager.CURRENT_SCROLL_LISTENER.get().getUrl().equals(fm.jiecao.jcvideoplayer_lib.JCVideoPlayer.jcMediaManager.getDataSource())) {
                fm.jiecao.jcvideoplayer_lib.JCVideoPlayer.releaseAllVideos();
                com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
                return;
            }
            fm.jiecao.jcvideoplayer_lib.JCVideoPlayer.backPress();
        } else if (id == fm.jiecao.jcvideoplayer_lib.R.id.iv_voice || id == fm.jiecao.jcvideoplayer_lib.R.id.iv_all_music) {
            int streamVolume = this.mAudioManager.getStreamVolume(3);
            fm.jiecao.jcvideoplayer_lib.JCMediaManager jCMediaManager = fm.jiecao.jcvideoplayer_lib.JCVideoPlayer.jcMediaManager;
            if (jCMediaManager != null) {
                if (jCMediaManager.isMute()) {
                    fm.jiecao.jcvideoplayer_lib.JCVideoPlayer.jcMediaManager.setVolume(streamVolume, streamVolume);
                    fm.jiecao.jcvideoplayer_lib.JCVideoPlayer.jcMediaManager.setIsMute(false);
                    getMusicFocus();
                } else {
                    fm.jiecao.jcvideoplayer_lib.JCVideoPlayer.jcMediaManager.setVolume(0, 0);
                    fm.jiecao.jcvideoplayer_lib.JCVideoPlayer.jcMediaManager.setIsMute(true);
                    releaseMusicFocus();
                }
                fm.jiecao.jcvideoplayer_lib.VolumeClickCallBack volumeClickCallBack = this.z;
                if (volumeClickCallBack != null) {
                    volumeClickCallBack.onClick(fm.jiecao.jcvideoplayer_lib.JCVideoPlayer.jcMediaManager.isMute());
                }
            }
            changeVoiceBack();
        }
        com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public void onClickUiToggle() {
        int i = this.currentState;
        if (i == 1) {
            if (this.bottomContainer.getVisibility() == 0) {
                changeUiToPreparingClear();
                return;
            } else {
                changeUiToPreparingShow();
                return;
            }
        }
        if (i == 2) {
            if (this.bottomContainer.getVisibility() == 0) {
                changeUiToPlayingClear();
                return;
            } else {
                changeUiToPlayingShow();
                return;
            }
        }
        if (i == 5) {
            if (this.bottomContainer.getVisibility() == 0) {
                changeUiToPauseClear();
                return;
            } else {
                changeUiToPauseShow();
                return;
            }
        }
        if (i == 6) {
            if (this.bottomContainer.getVisibility() == 0) {
                changeUiToCompleteClear();
                return;
            } else {
                changeUiToCompleteShow();
                return;
            }
        }
        if (i == 3) {
            if (this.bottomContainer.getVisibility() == 0) {
                changeUiToPlayingBufferingClear();
            } else {
                changeUiToPlayingBufferingShow();
            }
        }
    }

    @Override // fm.jiecao.jcvideoplayer_lib.JCVideoPlayer, fm.jiecao.jcvideoplayer_lib.JCMediaPlayerListener
    public void onCompletion() {
        super.onCompletion();
        clearCacheImage();
    }

    @Override // fm.jiecao.jcvideoplayer_lib.JCVideoPlayer, fm.jiecao.jcvideoplayer_lib.JCMediaPlayerListener
    public void onInfo(int i, int i2) {
        super.onInfo(i, i2);
        if (i == 10001) {
            this.x.setRotation(this.videoRotation);
        }
    }

    @Override // fm.jiecao.jcvideoplayer_lib.JCVideoPlayer, android.widget.SeekBar.OnSeekBarChangeListener
    public void onStartTrackingTouch(android.widget.SeekBar seekBar) {
        super.onStartTrackingTouch(seekBar);
        cancelDismissControlViewTimer();
    }

    @Override // fm.jiecao.jcvideoplayer_lib.JCVideoPlayer, android.widget.SeekBar.OnSeekBarChangeListener
    public void onStopTrackingTouch(android.widget.SeekBar seekBar) {
        super.onStopTrackingTouch(seekBar);
        startDismissControlViewTimer();
    }

    @Override // fm.jiecao.jcvideoplayer_lib.JCVideoPlayer, android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(android.graphics.SurfaceTexture surfaceTexture, int i, int i2) {
        super.onSurfaceTextureAvailable(surfaceTexture, i, i2);
    }

    @Override // fm.jiecao.jcvideoplayer_lib.JCVideoPlayer, android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(android.graphics.SurfaceTexture surfaceTexture) {
        return super.onSurfaceTextureDestroyed(surfaceTexture);
    }

    @Override // fm.jiecao.jcvideoplayer_lib.JCVideoPlayer, android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(android.graphics.SurfaceTexture surfaceTexture, int i, int i2) {
        super.onSurfaceTextureSizeChanged(surfaceTexture, i, i2);
        if (this.textureUpdated) {
            return;
        }
        this.textureSizeChanged = true;
    }

    @Override // fm.jiecao.jcvideoplayer_lib.JCVideoPlayer, android.view.TextureView.SurfaceTextureListener
    @androidx.annotation.RequiresApi(api = 14)
    public void onSurfaceTextureUpdated(android.graphics.SurfaceTexture surfaceTexture) {
        super.onSurfaceTextureUpdated(surfaceTexture);
        if (this.textureSizeChanged) {
            this.textureSizeChanged = false;
        } else {
            this.x.setVisibility(4);
            this.textureView.setHasUpdated();
        }
    }

    @Override // fm.jiecao.jcvideoplayer_lib.JCVideoPlayer, android.view.View.OnTouchListener
    public boolean onTouch(android.view.View view, android.view.MotionEvent motionEvent) {
        int id = view.getId();
        if (id == fm.jiecao.jcvideoplayer_lib.R.id.surface_container) {
            if (motionEvent.getAction() == 1) {
                startDismissControlViewTimer();
                if (!this.mChangePosition && !this.mChangeVolume) {
                    onClickUiToggle();
                }
            }
        } else if (id == fm.jiecao.jcvideoplayer_lib.R.id.progress) {
            int action = motionEvent.getAction();
            if (action == 0) {
                cancelDismissControlViewTimer();
            } else if (action == 1) {
                startDismissControlViewTimer();
            }
        }
        return super.onTouch(view, motionEvent);
    }

    @Override // fm.jiecao.jcvideoplayer_lib.JCVideoPlayer, fm.jiecao.jcvideoplayer_lib.JCMediaPlayerListener
    public void onVideoSizeChanged() {
        super.onVideoSizeChanged();
        this.x.setVideoSize(fm.jiecao.jcvideoplayer_lib.JCVideoPlayer.jcMediaManager.getVideoSize());
    }

    public void refreshCache() {
        fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard jCVideoPlayerStandard;
        if (pauseSwitchCoverBitmap == null || (jCVideoPlayerStandard = (fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard) fm.jiecao.jcvideoplayer_lib.JCVideoPlayerManager.getFirst()) == null) {
            return;
        }
        jCVideoPlayerStandard.x.setImageBitmap(pauseSwitchCoverBitmap);
        jCVideoPlayerStandard.x.setVisibility(0);
    }

    public void releaseVideo() {
        removeAllViews();
        setVisibility(8);
        if (this.currentState != 0) {
            fm.jiecao.jcvideoplayer_lib.JCVideoPlayer.releaseAllVideos();
        }
    }

    @Override // fm.jiecao.jcvideoplayer_lib.JCVideoPlayer
    public void resetProgressAndTime() {
        super.resetProgressAndTime();
    }

    public void seekTo(long j) {
        if (this.currentState == 2) {
            fm.jiecao.jcvideoplayer_lib.JCVideoPlayer.jcMediaManager.seekTo(j);
        }
    }

    @Override // fm.jiecao.jcvideoplayer_lib.JCVideoPlayer
    public void setAllControlsVisible(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        if (needShowThis(this.bottomContainer)) {
            this.bottomContainer.setVisibility(i2);
        } else {
            this.bottomContainer.setVisibility(8);
        }
        this.topContainer.setVisibility(i);
        if (i2 == 0) {
            this.tv_time.setVisibility(8);
            this.iv_all_music.setVisibility(8);
        } else if (android.text.TextUtils.isEmpty(this.time_total)) {
            this.tv_time.setVisibility(8);
            this.iv_all_music.setVisibility(8);
        } else {
            if (needShowThis(this.tv_time)) {
                this.tv_time.setVisibility(0);
            }
            if (needShowThis(this.iv_all_music)) {
                this.iv_all_music.setVisibility(0);
            }
        }
        if (needShowThis(this.startButton)) {
            this.startButton.setVisibility(i3);
        } else {
            this.startButton.setVisibility(8);
        }
        if (needShowThis(this.rl_wifi_toast)) {
            this.rl_wifi_toast.setVisibility(i3);
        } else {
            this.rl_wifi_toast.setVisibility(8);
        }
        if (needShowThis(this.v)) {
            this.v.setVisibility(i4);
        } else {
            this.v.setVisibility(8);
        }
        if (i5 == 0) {
            this.thumbImageView.setVisibility(i5);
            this.tv_time.setText(fm.jiecao.jcvideoplayer_lib.JCUtils.stringForTotalTime(this.time_total));
        } else {
            this.thumbImageView.setVisibility(8);
        }
        this.coverImageView.setVisibility(i6);
        this.x.setVisibility(i8);
    }

    public void setBgWithCorner(int i) {
        fm.jiecao.jcvideoplayer_lib.ClipRelativeLayout clipRelativeLayout = this.rl_video_2;
        if (clipRelativeLayout != null) {
            clipRelativeLayout.setRadius(i);
        }
    }

    public fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard setFullDetailOnClickListener(fm.jiecao.jcvideoplayer_lib.FullDetailClickCallBack fullDetailClickCallBack) {
        this.fullDetailClickCallBack = fullDetailClickCallBack;
        return this;
    }

    public fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard setFullScreenDetail(java.lang.String str) {
        this.fullDetail = str;
        return this;
    }

    public fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard setIsNeedControlBar(boolean z) {
        this.isNeedControlBar = z;
        return this;
    }

    public fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard setIsNeedControlButton(boolean z) {
        this.isNeedControlButton = z;
        return this;
    }

    public fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard setIsNeedCyclePlay(boolean z) {
        this.isNeedCyclePlay = z;
        return this;
    }

    public fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard setIsNeedFullButton(boolean z) {
        this.isNeedFullButton = z;
        return this;
    }

    public fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard setIsNeedMute(boolean z) {
        this.isNeedMute = z;
        return this;
    }

    public fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard setIsNeedScreenFull(boolean z) {
        this.isNeedScreen = z;
        return this;
    }

    public fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard setIsNeedShowView(boolean z) {
        this.isNeedShowView = z;
        return this;
    }

    public fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard setIsNeedSystemVolume(boolean z) {
        this.isNeedSystemVolume = z;
        return this;
    }

    public fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard setIsNeedTime(boolean z) {
        this.isNeedTime = z;
        return this;
    }

    public fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard setIsNeedVoice(boolean z) {
        this.isNeedVoice = z;
        return this;
    }

    public fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard setIsNeedWifi(boolean z) {
        this.isNeedWifi = z;
        return this;
    }

    public fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard setIsNeedWifiDialog(boolean z) {
        this.isNeedWifiDialog = z;
        return this;
    }

    public void setNormalFullScreenButtonLayoutParams() {
        android.widget.LinearLayout.LayoutParams layoutParams = (android.widget.LinearLayout.LayoutParams) this.fullscreenButton.getLayoutParams();
        android.content.res.Resources resources = getResources();
        int i = fm.jiecao.jcvideoplayer_lib.R.dimen.full_screen_button;
        layoutParams.width = (int) resources.getDimension(i);
        layoutParams.height = (int) getResources().getDimension(i);
        this.fullscreenButton.setLayoutParams(layoutParams);
    }

    public fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard setOnPlayStateChangeListener(fm.jiecao.jcvideoplayer_lib.VideoPlayStateChangeCallBack videoPlayStateChangeCallBack) {
        this.videoPlayStateClickCallBack = videoPlayStateChangeCallBack;
        return this;
    }

    public fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard setOnVolumeClickListener(fm.jiecao.jcvideoplayer_lib.VolumeClickCallBack volumeClickCallBack) {
        this.z = volumeClickCallBack;
        return this;
    }

    public fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard setPreviewOnClickListener(fm.jiecao.jcvideoplayer_lib.PreviewViewClickCallBack previewViewClickCallBack) {
        this.y = previewViewClickCallBack;
        return this;
    }

    @Override // fm.jiecao.jcvideoplayer_lib.JCVideoPlayer
    public void setProgressAndTime(int i, int i2, int i3, int i4) {
        super.setProgressAndTime(i, i2, i3, i4);
    }

    @Override // fm.jiecao.jcvideoplayer_lib.JCVideoPlayer
    public void setUiWitStateAndScreen(int i) {
        super.setUiWitStateAndScreen(i);
        int i2 = this.currentState;
        if (i2 == 0) {
            changeUiToNormal();
            return;
        }
        if (i2 == 1) {
            changeUiToPreparingShow();
            startDismissControlViewTimer();
            return;
        }
        if (i2 == 2) {
            changeUiToPlayingShow();
            setAllControlsVisible(4, 4, 4, 4, 4, 4, 4, this.x.getVisibility());
            startDismissControlViewTimer();
        } else {
            if (i2 == 3) {
                changeUiToPlayingBufferingShow();
                return;
            }
            if (i2 == 5) {
                changeUiToPauseShow();
                cancelDismissControlViewTimer();
            } else if (i2 == 6) {
                changeUiToCompleteShow();
                cancelDismissControlViewTimer();
            } else {
                if (i2 != 7) {
                    return;
                }
                changeUiToNormal();
            }
        }
    }

    @Override // fm.jiecao.jcvideoplayer_lib.JCVideoPlayer
    public boolean setUp(java.lang.String str, int i, java.lang.Object... objArr) {
        if (!super.setUp(str, i, new java.lang.Object[0])) {
            setUiWitStateAndScreen(7);
            return false;
        }
        int i2 = this.currentScreen;
        if (i2 == 2) {
            fm.jiecao.jcvideoplayer_lib.JCMediaManager jCMediaManager = fm.jiecao.jcvideoplayer_lib.JCVideoPlayer.jcMediaManager;
            if (jCMediaManager != null) {
                jCMediaManager.setIsFull(true);
            }
            if (!android.text.TextUtils.isEmpty(this.fullDetail)) {
                android.graphics.drawable.Drawable drawable = getResources().getDrawable(fm.jiecao.jcvideoplayer_lib.R.drawable.video_url_click_selector);
                drawable.setBounds(0, 0, (int) getResources().getDimension(fm.jiecao.jcvideoplayer_lib.R.dimen.video_detail_w), (int) getResources().getDimension(fm.jiecao.jcvideoplayer_lib.R.dimen.video_detial_h));
                this.tv_full_detail.setCompoundDrawables(drawable, null, null, null);
                this.tv_full_detail.setVisibility(0);
                this.tv_full_detail.setText(this.fullDetail);
            }
            this.fullscreenButton.setVisibility(8);
            this.backButton.setVisibility(0);
            android.widget.RelativeLayout.LayoutParams layoutParams = (android.widget.RelativeLayout.LayoutParams) this.startButton.getLayoutParams();
            android.content.res.Resources resources = getResources();
            int i3 = fm.jiecao.jcvideoplayer_lib.R.dimen.full_video_play;
            layoutParams.width = (int) resources.getDimension(i3);
            layoutParams.height = (int) getResources().getDimension(i3);
            this.startButton.setLayoutParams(layoutParams);
            this.topContainer.setBackgroundColor(android.graphics.Color.parseColor("#80000000"));
            this.w.setVisibility(4);
            if (this.isNeedWifi) {
                this.tv_full_wifi.setVisibility(0);
                this.rl_wifi_toast.setVisibility(8);
            } else {
                this.rl_wifi_toast.setVisibility(8);
                this.tv_full_wifi.setVisibility(8);
            }
            this.currentTimeTextView.setTextSize(1, 14.0f);
            this.totalTimeTextView.setTextSize(1, 14.0f);
            changeVoiceBack();
            changeVoiceFullScreenSize();
        } else if (i2 == 0 || i2 == 1) {
            if (needShowThis(this.fullscreenButton)) {
                setNormalFullScreenButtonLayoutParams();
                this.fullscreenButton.setVisibility(0);
            } else {
                this.fullscreenButton.setVisibility(8);
            }
            changeVoiceNormalSize();
            fm.jiecao.jcvideoplayer_lib.JCMediaManager jCMediaManager2 = fm.jiecao.jcvideoplayer_lib.JCVideoPlayer.jcMediaManager;
            if (jCMediaManager2 != null) {
                jCMediaManager2.setIsFull(false);
            }
            changeVoiceBack();
            setupFullScreenButton();
            this.backButton.setVisibility(8);
            this.w.setVisibility(4);
            if (objArr != null && objArr.length != 0) {
                java.lang.String trim = objArr[0].toString().trim();
                this.time_total = trim;
                if (android.text.TextUtils.isEmpty(trim) || "0".equals(this.time_total)) {
                    this.time_total = "";
                } else {
                    this.tv_time.setText(fm.jiecao.jcvideoplayer_lib.JCUtils.stringForTotalTime(this.time_total));
                    if (needShowThis(this.tv_time)) {
                        this.tv_time.setVisibility(0);
                    }
                    this.iv_all_music.setImageResource(fm.jiecao.jcvideoplayer_lib.R.drawable.music_pre_stop);
                    if (needShowThis(this.iv_all_music)) {
                        this.iv_all_music.setVisibility(0);
                    }
                }
            }
            if (this.isNeedWifi) {
                this.rl_wifi_toast.setVisibility(0);
                this.tv_full_wifi.setVisibility(8);
            } else {
                this.rl_wifi_toast.setVisibility(8);
                this.tv_full_wifi.setVisibility(8);
            }
        } else if (i2 == 3) {
            this.w.setVisibility(0);
            setAllControlsVisible(4, 4, 4, 4, 4, 4, 4, 4);
        }
        return true;
    }

    public void setVideoBackgroundColor(int i) {
        android.widget.RelativeLayout relativeLayout = this.rl_video;
        if (relativeLayout != null) {
            relativeLayout.setBackgroundColor(i);
        }
    }

    public fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard setVideoPlayProcessListener(fm.jiecao.jcvideoplayer_lib.IVideoPlayProcessChanged iVideoPlayProcessChanged) {
        this.iVideoPlayProcessChanged = iVideoPlayProcessChanged;
        return this;
    }

    public fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard setVideoTitle(java.lang.String str) {
        this.videotitle = str;
        return this;
    }

    public void setupFullScreenButton() {
        this.fullscreenButton.setImageResource(fm.jiecao.jcvideoplayer_lib.R.drawable.video_big_click_selector);
    }

    public void showTimerTaskView() {
        this.bottomContainer.setVisibility(4);
        this.topContainer.setVisibility(4);
        this.startButton.setVisibility(4);
        this.rl_wifi_toast.setVisibility(4);
        if (android.text.TextUtils.isEmpty(this.time_total)) {
            return;
        }
        if (needShowThis(this.tv_time)) {
            this.tv_time.setVisibility(0);
        }
        if (needShowThis(this.iv_all_music)) {
            this.iv_all_music.setVisibility(0);
        }
    }

    @Override // fm.jiecao.jcvideoplayer_lib.JCVideoPlayer
    public void showVolumeDialog(float f, int i) {
        super.showVolumeDialog(f, i);
        if (this.mVolumeDialog == null) {
            android.view.View inflate = android.view.LayoutInflater.from(getContext()).inflate(fm.jiecao.jcvideoplayer_lib.R.layout.jc_volume_dialog, (android.view.ViewGroup) null);
            inflate.findViewById(fm.jiecao.jcvideoplayer_lib.R.id.content).setRotation(90.0f);
            this.mDialogVolumeProgressBar = (android.widget.ProgressBar) inflate.findViewById(fm.jiecao.jcvideoplayer_lib.R.id.volume_progressbar);
            android.app.Dialog dialog = new android.app.Dialog(getContext(), fm.jiecao.jcvideoplayer_lib.R.style.jc_style_dialog_progress);
            this.mVolumeDialog = dialog;
            dialog.setContentView(inflate);
            this.mVolumeDialog.getWindow().addFlags(8);
            this.mVolumeDialog.getWindow().addFlags(32);
            this.mVolumeDialog.getWindow().addFlags(16);
            this.mVolumeDialog.getWindow().setLayout(-2, -2);
            android.view.WindowManager.LayoutParams attributes = this.mVolumeDialog.getWindow().getAttributes();
            attributes.gravity = 49;
            this.mVolumeDialog.getWindow().setAttributes(attributes);
        }
        if (!this.mVolumeDialog.isShowing()) {
            this.mVolumeDialog.show();
        }
        this.mDialogVolumeProgressBar.setProgress(i);
    }

    @Override // fm.jiecao.jcvideoplayer_lib.JCVideoPlayer
    public void showWifiDialog() {
        super.showWifiDialog();
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(getContext());
        builder.setMessage(getResources().getString(fm.jiecao.jcvideoplayer_lib.R.string.tips_not_wifi));
        builder.setPositiveButton(getResources().getString(fm.jiecao.jcvideoplayer_lib.R.string.tips_not_wifi_confirm), new fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard.AnonymousClass1());
        builder.setNegativeButton(getResources().getString(fm.jiecao.jcvideoplayer_lib.R.string.tips_not_wifi_cancel), new fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard.AnonymousClass2());
        builder.create().show();
    }

    public void startDismissControlViewTimer() {
        cancelDismissControlViewTimer();
        DISMISS_CONTROL_VIEW_TIMER = new java.util.Timer();
        fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard.DismissControlViewTimerTask dismissControlViewTimerTask = new fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard.DismissControlViewTimerTask(new java.lang.ref.WeakReference(this));
        this.mDismissControlViewTimerTask = dismissControlViewTimerTask;
        DISMISS_CONTROL_VIEW_TIMER.schedule(dismissControlViewTimerTask, 2500L);
    }

    public void startPlayLogic() {
        prepareVideo();
        startDismissControlViewTimer();
    }

    @Override // fm.jiecao.jcvideoplayer_lib.JCVideoPlayer
    @androidx.annotation.RequiresApi(api = 14)
    public void startWindowFullscreen(int i) {
        d();
        super.startWindowFullscreen(i);
        refreshCache();
    }

    public void stopPlayByNoWiFi() {
    }

    public void updateStartImage() {
        int i = this.currentState;
        if (i == 2) {
            this.startButton.setImageResource(fm.jiecao.jcvideoplayer_lib.R.drawable.jc_click_pause_selector);
        } else if (i == 7) {
            this.startButton.setImageResource(fm.jiecao.jcvideoplayer_lib.R.drawable.jc_click_play_selector);
        } else {
            this.startButton.setImageResource(fm.jiecao.jcvideoplayer_lib.R.drawable.jc_click_play_selector);
        }
    }
}
