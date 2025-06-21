package cn.jzvd;

/* loaded from: classes.dex */
public class JzvdStd extends cn.jzvd.Jzvd {
    protected static java.util.Timer DISMISS_CONTROL_VIEW_TIMER = null;
    public static int LAST_GET_BATTERYLEVEL_PERCENT = 70;
    public static long LAST_GET_BATTERYLEVEL_TIME;
    public android.widget.ImageView backButton;
    public android.content.BroadcastReceiver battertReceiver;
    public android.widget.ImageView batteryLevel;
    public android.widget.LinearLayout batteryTimeLayout;
    public android.widget.ProgressBar bottomProgressBar;
    public android.widget.TextView clarity;
    public android.widget.PopupWindow clarityPopWindow;
    protected java.util.ArrayDeque<java.lang.Runnable> delayTask;
    protected android.view.GestureDetector gestureDetector;
    public android.widget.ProgressBar loadingProgressBar;
    protected android.app.Dialog mBrightnessDialog;
    protected android.widget.ProgressBar mDialogBrightnessProgressBar;
    protected android.widget.TextView mDialogBrightnessTextView;
    protected android.widget.ImageView mDialogIcon;
    protected android.widget.ProgressBar mDialogProgressBar;
    protected android.widget.TextView mDialogSeekTime;
    protected android.widget.TextView mDialogTotalTime;
    protected android.widget.ImageView mDialogVolumeImageView;
    protected android.widget.ProgressBar mDialogVolumeProgressBar;
    protected android.widget.TextView mDialogVolumeTextView;
    protected cn.jzvd.JzvdStd.DismissControlViewTimerTask mDismissControlViewTimerTask;
    protected boolean mIsWifi;
    protected android.app.Dialog mProgressDialog;
    public android.widget.TextView mRetryBtn;
    public android.widget.LinearLayout mRetryLayout;
    protected android.app.Dialog mVolumeDialog;
    public android.widget.ImageView posterImageView;
    public android.widget.TextView replayTextView;
    public android.widget.ImageView tinyBackImageView;
    public android.widget.TextView titleTextView;
    public android.widget.TextView videoCurrentTime;
    public android.content.BroadcastReceiver wifiReceiver;

    /* renamed from: cn.jzvd.JzvdStd$1, reason: invalid class name */
    public class AnonymousClass1 extends android.content.BroadcastReceiver {
        public AnonymousClass1() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(android.content.Context context, android.content.Intent intent) {
            com.sensorsdata.analytics.android.sdk.aop.push.PushAutoTrackHelper.onBroadcastReceiver(this, context, intent);
            if ("android.intent.action.BATTERY_CHANGED".equals(intent.getAction())) {
                cn.jzvd.JzvdStd.LAST_GET_BATTERYLEVEL_PERCENT = (intent.getIntExtra(com.aliyun.svideo.downloader.FileDownloaderModel.LEVEL, 0) * 100) / intent.getIntExtra("scale", 100);
                cn.jzvd.JzvdStd.this.setBatteryLevel();
                try {
                    cn.jzvd.JzvdStd jzvdStd = cn.jzvd.JzvdStd.this;
                    jzvdStd.jzvdContext.unregisterReceiver(jzvdStd.battertReceiver);
                } catch (java.lang.Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /* renamed from: cn.jzvd.JzvdStd$2, reason: invalid class name */
    public class AnonymousClass2 extends android.content.BroadcastReceiver {
        public AnonymousClass2() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(android.content.Context context, android.content.Intent intent) {
            com.sensorsdata.analytics.android.sdk.aop.push.PushAutoTrackHelper.onBroadcastReceiver(this, context, intent);
            if (com.igexin.sdk.PushConsts.ACTION_BROADCAST_NETWORK_CHANGE.equals(intent.getAction())) {
                boolean isWifiConnected = cn.jzvd.JZUtils.isWifiConnected(context);
                cn.jzvd.JzvdStd jzvdStd = cn.jzvd.JzvdStd.this;
                if (jzvdStd.mIsWifi == isWifiConnected) {
                    return;
                }
                jzvdStd.mIsWifi = isWifiConnected;
                if (isWifiConnected || cn.jzvd.Jzvd.WIFI_TIP_DIALOG_SHOWED || jzvdStd.state != 5) {
                    return;
                }
                jzvdStd.startButton.performClick();
                cn.jzvd.JzvdStd.this.showWifiDialog();
            }
        }
    }

    /* renamed from: cn.jzvd.JzvdStd$3, reason: invalid class name */
    public class AnonymousClass3 extends android.view.GestureDetector.SimpleOnGestureListener {
        public AnonymousClass3() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(android.view.MotionEvent motionEvent) {
            int i = cn.jzvd.JzvdStd.this.state;
            if (i == 5 || i == 6) {
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                sb.append("doublClick [");
                sb.append(hashCode());
                sb.append("] ");
                cn.jzvd.JzvdStd.this.startButton.performClick();
            }
            return super.onDoubleTap(motionEvent);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public void onLongPress(android.view.MotionEvent motionEvent) {
            super.onLongPress(motionEvent);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(android.view.MotionEvent motionEvent) {
            cn.jzvd.JzvdStd jzvdStd = cn.jzvd.JzvdStd.this;
            if (!jzvdStd.mChangePosition && !jzvdStd.mChangeVolume) {
                jzvdStd.onClickUiToggle();
            }
            return super.onSingleTapConfirmed(motionEvent);
        }
    }

    /* renamed from: cn.jzvd.JzvdStd$4, reason: invalid class name */
    public class AnonymousClass4 implements android.content.DialogInterface.OnCancelListener {
        public AnonymousClass4() {
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(android.content.DialogInterface dialogInterface) {
            dialogInterface.dismiss();
            cn.jzvd.JzvdStd.this.releaseAllVideos();
            cn.jzvd.JzvdStd.this.clearFloatScreen();
        }
    }

    public class DismissControlViewTimerTask extends java.util.TimerTask {
        public DismissControlViewTimerTask() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            cn.jzvd.JzvdStd.this.dissmissControlView();
        }
    }

    public JzvdStd(android.content.Context context) {
        super(context);
        this.battertReceiver = new cn.jzvd.JzvdStd.AnonymousClass1();
        this.wifiReceiver = new cn.jzvd.JzvdStd.AnonymousClass2();
        this.delayTask = new java.util.ArrayDeque<>();
        this.gestureDetector = new android.view.GestureDetector(getContext().getApplicationContext(), new cn.jzvd.JzvdStd.AnonymousClass3());
    }

    public JzvdStd(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
        this.battertReceiver = new cn.jzvd.JzvdStd.AnonymousClass1();
        this.wifiReceiver = new cn.jzvd.JzvdStd.AnonymousClass2();
        this.delayTask = new java.util.ArrayDeque<>();
        this.gestureDetector = new android.view.GestureDetector(getContext().getApplicationContext(), new cn.jzvd.JzvdStd.AnonymousClass3());
    }

    /* JADX INFO: Access modifiers changed from: private */
    @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
    public /* synthetic */ void e(android.widget.LinearLayout linearLayout, android.view.View view) {
        int intValue = ((java.lang.Integer) view.getTag()).intValue();
        cn.jzvd.JZDataSource jZDataSource = this.jzDataSource;
        jZDataSource.currentUrlIndex = intValue;
        changeUrl(jZDataSource, getCurrentPositionWhenPlaying());
        this.clarity.setText(this.jzDataSource.getCurrentKey().toString());
        for (int i = 0; i < linearLayout.getChildCount(); i++) {
            if (i == this.jzDataSource.currentUrlIndex) {
                ((android.widget.TextView) linearLayout.getChildAt(i)).setTextColor(android.graphics.Color.parseColor("#fff85959"));
            } else {
                ((android.widget.TextView) linearLayout.getChildAt(i)).setTextColor(android.graphics.Color.parseColor("#ffffff"));
            }
        }
        android.widget.PopupWindow popupWindow = this.clarityPopWindow;
        if (popupWindow != null) {
            popupWindow.dismiss();
        }
        com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void f() {
        this.bottomContainer.setVisibility(4);
        this.topContainer.setVisibility(4);
        this.startButton.setVisibility(4);
        if (this.screen != 2) {
            this.bottomProgressBar.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
    public /* synthetic */ void g(android.content.DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
        cn.jzvd.Jzvd.WIFI_TIP_DIALOG_SHOWED = true;
        if (this.state == 6) {
            this.startButton.performClick();
        } else {
            startVideo();
        }
        com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackDialog(dialogInterface, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
    public /* synthetic */ void h(android.content.DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
        releaseAllVideos();
        clearFloatScreen();
        com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackDialog(dialogInterface, i);
    }

    public void cancelDismissControlViewTimer() {
        java.util.Timer timer = DISMISS_CONTROL_VIEW_TIMER;
        if (timer != null) {
            timer.cancel();
        }
        cn.jzvd.JzvdStd.DismissControlViewTimerTask dismissControlViewTimerTask = this.mDismissControlViewTimerTask;
        if (dismissControlViewTimerTask != null) {
            dismissControlViewTimerTask.cancel();
        }
    }

    public void changeStartButtonSize(int i) {
        android.view.ViewGroup.LayoutParams layoutParams = this.startButton.getLayoutParams();
        layoutParams.height = i;
        layoutParams.width = i;
        android.view.ViewGroup.LayoutParams layoutParams2 = this.loadingProgressBar.getLayoutParams();
        layoutParams2.height = i;
        layoutParams2.width = i;
    }

    public void changeUIToPreparingChangeUrl() {
        int i = this.screen;
        if (i == 0 || i == 1) {
            setAllControlsVisiblity(4, 4, 4, 0, 0, 4, 4);
            updateStartImage();
        }
    }

    public void changeUIToPreparingPlaying() {
        int i = this.screen;
        if (i == 0 || i == 1) {
            setAllControlsVisiblity(0, 0, 4, 0, 4, 4, 4);
            updateStartImage();
        }
    }

    public void changeUiToComplete() {
        int i = this.screen;
        if (i == 0 || i == 1) {
            setAllControlsVisiblity(0, 4, 0, 4, 0, 4, 4);
            updateStartImage();
        }
    }

    public void changeUiToError() {
        int i = this.screen;
        if (i == 0) {
            setAllControlsVisiblity(4, 4, 0, 4, 4, 4, 0);
            updateStartImage();
        } else {
            if (i != 1) {
                return;
            }
            setAllControlsVisiblity(0, 4, 0, 4, 4, 4, 0);
            updateStartImage();
        }
    }

    public void changeUiToNormal() {
        int i = this.screen;
        if (i == 0 || i == 1) {
            setAllControlsVisiblity(0, 4, 0, 4, 0, 4, 4);
            updateStartImage();
        }
    }

    public void changeUiToPauseClear() {
        int i = this.screen;
        if (i == 0 || i == 1) {
            setAllControlsVisiblity(4, 4, 4, 4, 4, 0, 4);
        }
    }

    public void changeUiToPauseShow() {
        int i = this.screen;
        if (i == 0 || i == 1) {
            setAllControlsVisiblity(0, 0, 0, 4, 4, 4, 4);
            updateStartImage();
        }
    }

    public void changeUiToPlayingClear() {
        int i = this.screen;
        if (i == 0 || i == 1) {
            setAllControlsVisiblity(4, 4, 4, 4, 4, 0, 4);
        }
    }

    public void changeUiToPlayingShow() {
        int i = this.screen;
        if (i == 0 || i == 1) {
            setAllControlsVisiblity(0, 0, 0, 4, 4, 4, 4);
            updateStartImage();
        }
    }

    public void changeUiToPreparing() {
        int i = this.screen;
        if (i == 0 || i == 1) {
            setAllControlsVisiblity(4, 4, 4, 0, 0, 4, 4);
            updateStartImage();
        }
    }

    @Override // cn.jzvd.Jzvd
    public void changeUrl(cn.jzvd.JZDataSource jZDataSource, long j) {
        super.changeUrl(jZDataSource, j);
        this.titleTextView.setText(jZDataSource.title);
    }

    public void clickBack() {
        backPress();
    }

    public void clickBackTiny() {
        clearFloatScreen();
    }

    public void clickClarity() {
        onCLickUiToggleToClear();
        android.widget.LinearLayout linearLayout = (android.widget.LinearLayout) ((android.view.LayoutInflater) this.jzvdContext.getSystemService("layout_inflater")).inflate(fm.jiecao.jcvideoplayer_lib.R.layout.jz_layout_clarity, (android.view.ViewGroup) null);
        defpackage.qu0 qu0Var = new defpackage.qu0(this, linearLayout);
        for (int i = 0; i < this.jzDataSource.urlsMap.size(); i++) {
            java.lang.String keyFromDataSource = this.jzDataSource.getKeyFromDataSource(i);
            android.widget.TextView textView = (android.widget.TextView) android.view.View.inflate(this.jzvdContext, fm.jiecao.jcvideoplayer_lib.R.layout.jz_layout_clarity_item, null);
            textView.setText(keyFromDataSource);
            textView.setTag(java.lang.Integer.valueOf(i));
            linearLayout.addView(textView, i);
            textView.setOnClickListener(qu0Var);
            if (i == this.jzDataSource.currentUrlIndex) {
                textView.setTextColor(android.graphics.Color.parseColor("#fff85959"));
            }
        }
        android.widget.PopupWindow popupWindow = new android.widget.PopupWindow((android.view.View) linearLayout, cn.jzvd.JZUtils.dip2px(this.jzvdContext, 240.0f), -1, true);
        this.clarityPopWindow = popupWindow;
        popupWindow.setContentView(linearLayout);
        this.clarityPopWindow.setAnimationStyle(fm.jiecao.jcvideoplayer_lib.R.style.pop_animation);
        this.clarityPopWindow.showAtLocation(this.textureViewContainer, androidx.core.view.GravityCompat.END, 0, 0);
    }

    public void clickPoster() {
        cn.jzvd.JZDataSource jZDataSource = this.jzDataSource;
        if (jZDataSource == null || jZDataSource.urlsMap.isEmpty() || this.jzDataSource.getCurrentUrl() == null) {
            android.widget.Toast.makeText(this.jzvdContext, getResources().getString(fm.jiecao.jcvideoplayer_lib.R.string.no_url), 0).show();
            return;
        }
        int i = this.state;
        if (i != 0) {
            if (i == 7) {
                onClickUiToggle();
            }
        } else if (this.jzDataSource.getCurrentUrl().toString().startsWith("file") || this.jzDataSource.getCurrentUrl().toString().startsWith(net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR) || cn.jzvd.JZUtils.isWifiConnected(this.jzvdContext) || cn.jzvd.Jzvd.WIFI_TIP_DIALOG_SHOWED) {
            startVideo();
        } else {
            showWifiDialog();
        }
    }

    public void clickRetryBtn() {
        if (this.jzDataSource.urlsMap.isEmpty() || this.jzDataSource.getCurrentUrl() == null) {
            android.widget.Toast.makeText(this.jzvdContext, getResources().getString(fm.jiecao.jcvideoplayer_lib.R.string.no_url), 0).show();
            return;
        }
        if (!this.jzDataSource.getCurrentUrl().toString().startsWith("file") && !this.jzDataSource.getCurrentUrl().toString().startsWith(net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR) && !cn.jzvd.JZUtils.isWifiConnected(this.jzvdContext) && !cn.jzvd.Jzvd.WIFI_TIP_DIALOG_SHOWED) {
            showWifiDialog();
        } else {
            this.seekToInAdvance = this.mCurrentPosition;
            startVideo();
        }
    }

    public void clickSurfaceContainer() {
        startDismissControlViewTimer();
    }

    public android.app.Dialog createDialogWithView(android.view.View view) {
        android.app.Dialog dialog = new android.app.Dialog(this.jzvdContext, fm.jiecao.jcvideoplayer_lib.R.style.jz_style_dialog_progress);
        dialog.setContentView(view);
        android.view.Window window = dialog.getWindow();
        window.addFlags(8);
        window.addFlags(32);
        window.addFlags(16);
        window.setLayout(-2, -2);
        android.view.WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.gravity = 17;
        window.setAttributes(attributes);
        return dialog;
    }

    @Override // cn.jzvd.Jzvd
    public void dismissBrightnessDialog() {
        super.dismissBrightnessDialog();
        android.app.Dialog dialog = this.mBrightnessDialog;
        if (dialog != null) {
            dialog.dismiss();
        }
    }

    @Override // cn.jzvd.Jzvd
    public void dismissProgressDialog() {
        super.dismissProgressDialog();
        android.app.Dialog dialog = this.mProgressDialog;
        if (dialog != null) {
            dialog.dismiss();
        }
    }

    @Override // cn.jzvd.Jzvd
    public void dismissVolumeDialog() {
        super.dismissVolumeDialog();
        android.app.Dialog dialog = this.mVolumeDialog;
        if (dialog != null) {
            dialog.dismiss();
        }
    }

    public void dissmissControlView() {
        int i = this.state;
        if (i == 0 || i == 8 || i == 7) {
            return;
        }
        post(new defpackage.pu0(this));
    }

    @Override // cn.jzvd.Jzvd
    public int getLayoutId() {
        return fm.jiecao.jcvideoplayer_lib.R.layout.jz_layout_std;
    }

    @Override // cn.jzvd.Jzvd
    public void init(android.content.Context context) {
        super.init(context);
        this.batteryTimeLayout = (android.widget.LinearLayout) findViewById(fm.jiecao.jcvideoplayer_lib.R.id.battery_time_layout);
        this.bottomProgressBar = (android.widget.ProgressBar) findViewById(fm.jiecao.jcvideoplayer_lib.R.id.bottom_progress);
        this.titleTextView = (android.widget.TextView) findViewById(fm.jiecao.jcvideoplayer_lib.R.id.title);
        this.backButton = (android.widget.ImageView) findViewById(fm.jiecao.jcvideoplayer_lib.R.id.back);
        this.posterImageView = (android.widget.ImageView) findViewById(fm.jiecao.jcvideoplayer_lib.R.id.poster);
        this.loadingProgressBar = (android.widget.ProgressBar) findViewById(fm.jiecao.jcvideoplayer_lib.R.id.loading);
        this.tinyBackImageView = (android.widget.ImageView) findViewById(fm.jiecao.jcvideoplayer_lib.R.id.back_tiny);
        this.batteryLevel = (android.widget.ImageView) findViewById(fm.jiecao.jcvideoplayer_lib.R.id.battery_level);
        this.videoCurrentTime = (android.widget.TextView) findViewById(fm.jiecao.jcvideoplayer_lib.R.id.video_current_time);
        this.replayTextView = (android.widget.TextView) findViewById(fm.jiecao.jcvideoplayer_lib.R.id.replay_text);
        this.clarity = (android.widget.TextView) findViewById(fm.jiecao.jcvideoplayer_lib.R.id.clarity);
        this.mRetryBtn = (android.widget.TextView) findViewById(fm.jiecao.jcvideoplayer_lib.R.id.retry_btn);
        this.mRetryLayout = (android.widget.LinearLayout) findViewById(fm.jiecao.jcvideoplayer_lib.R.id.retry_layout);
        if (this.batteryTimeLayout == null) {
            this.batteryTimeLayout = new android.widget.LinearLayout(context);
        }
        if (this.bottomProgressBar == null) {
            this.bottomProgressBar = new android.widget.ProgressBar(context);
        }
        if (this.titleTextView == null) {
            this.titleTextView = new android.widget.TextView(context);
        }
        if (this.backButton == null) {
            this.backButton = new android.widget.ImageView(context);
        }
        if (this.posterImageView == null) {
            this.posterImageView = new android.widget.ImageView(context);
        }
        if (this.loadingProgressBar == null) {
            this.loadingProgressBar = new android.widget.ProgressBar(context);
        }
        if (this.tinyBackImageView == null) {
            this.tinyBackImageView = new android.widget.ImageView(context);
        }
        if (this.batteryLevel == null) {
            this.batteryLevel = new android.widget.ImageView(context);
        }
        if (this.videoCurrentTime == null) {
            this.videoCurrentTime = new android.widget.TextView(context);
        }
        if (this.replayTextView == null) {
            this.replayTextView = new android.widget.TextView(context);
        }
        if (this.clarity == null) {
            this.clarity = new android.widget.TextView(context);
        }
        if (this.mRetryBtn == null) {
            this.mRetryBtn = new android.widget.TextView(context);
        }
        if (this.mRetryLayout == null) {
            this.mRetryLayout = new android.widget.LinearLayout(context);
        }
        this.posterImageView.setOnClickListener(this);
        this.backButton.setOnClickListener(this);
        this.tinyBackImageView.setOnClickListener(this);
        this.clarity.setOnClickListener(this);
        this.mRetryBtn.setOnClickListener(this);
    }

    public void onCLickUiToggleToClear() {
        int i = this.state;
        if (i == 1) {
            if (this.bottomContainer.getVisibility() == 0) {
                changeUiToPreparing();
            }
        } else if (i == 5) {
            if (this.bottomContainer.getVisibility() == 0) {
                changeUiToPlayingClear();
            }
        } else if (i == 6) {
            if (this.bottomContainer.getVisibility() == 0) {
                changeUiToPauseClear();
            }
        } else if (i == 7 && this.bottomContainer.getVisibility() == 0) {
            changeUiToComplete();
        }
    }

    @Override // cn.jzvd.Jzvd, android.view.View.OnClickListener
    @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
    public void onClick(android.view.View view) {
        super.onClick(view);
        int id = view.getId();
        if (id == fm.jiecao.jcvideoplayer_lib.R.id.poster) {
            clickPoster();
        } else if (id == fm.jiecao.jcvideoplayer_lib.R.id.surface_container) {
            clickSurfaceContainer();
            android.widget.PopupWindow popupWindow = this.clarityPopWindow;
            if (popupWindow != null) {
                popupWindow.dismiss();
            }
        } else if (id == fm.jiecao.jcvideoplayer_lib.R.id.back) {
            clickBack();
        } else if (id == fm.jiecao.jcvideoplayer_lib.R.id.back_tiny) {
            clickBackTiny();
        } else if (id == fm.jiecao.jcvideoplayer_lib.R.id.clarity) {
            clickClarity();
        } else if (id == fm.jiecao.jcvideoplayer_lib.R.id.retry_btn) {
            clickRetryBtn();
        }
        com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public void onClickUiToggle() {
        if (this.bottomContainer.getVisibility() != 0) {
            setSystemTimeAndBattery();
            this.clarity.setText(this.jzDataSource.getCurrentKey().toString());
        }
        int i = this.state;
        if (i == 1) {
            changeUiToPreparing();
            if (this.bottomContainer.getVisibility() == 0) {
                return;
            }
            setSystemTimeAndBattery();
            return;
        }
        if (i == 5) {
            if (this.bottomContainer.getVisibility() == 0) {
                changeUiToPlayingClear();
                return;
            } else {
                changeUiToPlayingShow();
                return;
            }
        }
        if (i == 6) {
            if (this.bottomContainer.getVisibility() == 0) {
                changeUiToPauseClear();
            } else {
                changeUiToPauseShow();
            }
        }
    }

    @Override // cn.jzvd.Jzvd
    public void onCompletion() {
        super.onCompletion();
        cancelDismissControlViewTimer();
    }

    @Override // cn.jzvd.Jzvd
    public void onProgress(int i, long j, long j2) {
        super.onProgress(i, j, j2);
        this.bottomProgressBar.setProgress(i);
    }

    @Override // cn.jzvd.Jzvd, android.widget.SeekBar.OnSeekBarChangeListener
    public void onStartTrackingTouch(android.widget.SeekBar seekBar) {
        super.onStartTrackingTouch(seekBar);
        cancelDismissControlViewTimer();
    }

    @Override // cn.jzvd.Jzvd
    public void onStateAutoComplete() {
        super.onStateAutoComplete();
        changeUiToComplete();
        cancelDismissControlViewTimer();
        this.bottomProgressBar.setProgress(100);
    }

    @Override // cn.jzvd.Jzvd
    public void onStateError() {
        super.onStateError();
        changeUiToError();
    }

    @Override // cn.jzvd.Jzvd
    public void onStateNormal() {
        super.onStateNormal();
        changeUiToNormal();
    }

    @Override // cn.jzvd.Jzvd
    public void onStatePause(boolean z) {
        super.onStatePause(z);
        changeUiToPauseShow();
        cancelDismissControlViewTimer();
    }

    @Override // cn.jzvd.Jzvd
    public void onStatePlaying() {
        super.onStatePlaying();
        changeUiToPlayingClear();
    }

    @Override // cn.jzvd.Jzvd
    public void onStatePreparing() {
        super.onStatePreparing();
        changeUiToPreparing();
    }

    @Override // cn.jzvd.Jzvd
    public void onStatePreparingChangeUrl() {
        super.onStatePreparingChangeUrl();
        changeUIToPreparingChangeUrl();
    }

    @Override // cn.jzvd.Jzvd
    public void onStatePreparingPlaying() {
        super.onStatePreparingPlaying();
        changeUIToPreparingPlaying();
    }

    @Override // cn.jzvd.Jzvd, android.widget.SeekBar.OnSeekBarChangeListener
    public void onStopTrackingTouch(android.widget.SeekBar seekBar) {
        super.onStopTrackingTouch(seekBar);
        startDismissControlViewTimer();
    }

    @Override // cn.jzvd.Jzvd, android.view.View.OnTouchListener
    public boolean onTouch(android.view.View view, android.view.MotionEvent motionEvent) {
        int id = view.getId();
        if (id == fm.jiecao.jcvideoplayer_lib.R.id.surface_container) {
            if (motionEvent.getAction() == 1) {
                startDismissControlViewTimer();
                if (this.mChangePosition) {
                    long duration = getDuration();
                    long j = this.mSeekTimePosition * 100;
                    if (duration == 0) {
                        duration = 1;
                    }
                    this.bottomProgressBar.setProgress((int) (j / duration));
                }
            }
            this.gestureDetector.onTouchEvent(motionEvent);
        } else if (id == fm.jiecao.jcvideoplayer_lib.R.id.bottom_seek_progress) {
            int action = motionEvent.getAction();
            if (action == 0) {
                cancelDismissControlViewTimer();
            } else if (action == 1) {
                startDismissControlViewTimer();
            }
        }
        return super.onTouch(view, motionEvent);
    }

    public void registerWifiListener(android.content.Context context) {
        if (context == null) {
            return;
        }
        this.mIsWifi = cn.jzvd.JZUtils.isWifiConnected(context);
        context.registerReceiver(this.wifiReceiver, new android.content.IntentFilter(com.igexin.sdk.PushConsts.ACTION_BROADCAST_NETWORK_CHANGE));
    }

    @Override // cn.jzvd.Jzvd
    public void reset() {
        super.reset();
        cancelDismissControlViewTimer();
        unregisterWifiListener(getApplicationContext());
    }

    @Override // cn.jzvd.Jzvd
    public void resetProgressAndTime() {
        super.resetProgressAndTime();
        this.bottomProgressBar.setProgress(0);
        this.bottomProgressBar.setSecondaryProgress(0);
    }

    public void setAllControlsVisiblity(int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        this.topContainer.setVisibility(i);
        this.bottomContainer.setVisibility(i2);
        this.startButton.setVisibility(i3);
        this.loadingProgressBar.setVisibility(i4);
        this.posterImageView.setVisibility(i5);
        this.bottomProgressBar.setVisibility(i6);
        this.mRetryLayout.setVisibility(i7);
    }

    public void setBatteryLevel() {
        int i = LAST_GET_BATTERYLEVEL_PERCENT;
        if (i < 15) {
            this.batteryLevel.setBackgroundResource(fm.jiecao.jcvideoplayer_lib.R.drawable.jz_battery_level_10);
            return;
        }
        if (i >= 15 && i < 40) {
            this.batteryLevel.setBackgroundResource(fm.jiecao.jcvideoplayer_lib.R.drawable.jz_battery_level_30);
            return;
        }
        if (i >= 40 && i < 60) {
            this.batteryLevel.setBackgroundResource(fm.jiecao.jcvideoplayer_lib.R.drawable.jz_battery_level_50);
            return;
        }
        if (i >= 60 && i < 80) {
            this.batteryLevel.setBackgroundResource(fm.jiecao.jcvideoplayer_lib.R.drawable.jz_battery_level_70);
            return;
        }
        if (i >= 80 && i < 95) {
            this.batteryLevel.setBackgroundResource(fm.jiecao.jcvideoplayer_lib.R.drawable.jz_battery_level_90);
        } else {
            if (i < 95 || i > 100) {
                return;
            }
            this.batteryLevel.setBackgroundResource(fm.jiecao.jcvideoplayer_lib.R.drawable.jz_battery_level_100);
        }
    }

    @Override // cn.jzvd.Jzvd
    public void setBufferProgress(int i) {
        super.setBufferProgress(i);
        this.bottomProgressBar.setSecondaryProgress(i);
    }

    @Override // cn.jzvd.Jzvd
    public void setScreenFullscreen() {
        super.setScreenFullscreen();
        this.fullscreenButton.setImageResource(fm.jiecao.jcvideoplayer_lib.R.drawable.jz_shrink);
        this.backButton.setVisibility(0);
        this.tinyBackImageView.setVisibility(4);
        this.batteryTimeLayout.setVisibility(0);
        if (this.jzDataSource.urlsMap.size() == 1) {
            this.clarity.setVisibility(8);
        } else {
            this.clarity.setText(this.jzDataSource.getCurrentKey().toString());
            this.clarity.setVisibility(0);
        }
        changeStartButtonSize((int) getResources().getDimension(fm.jiecao.jcvideoplayer_lib.R.dimen.jz_start_button_w_h_fullscreen));
        setSystemTimeAndBattery();
    }

    @Override // cn.jzvd.Jzvd
    public void setScreenNormal() {
        super.setScreenNormal();
        this.fullscreenButton.setImageResource(fm.jiecao.jcvideoplayer_lib.R.drawable.jz_enlarge);
        this.backButton.setVisibility(8);
        this.tinyBackImageView.setVisibility(4);
        changeStartButtonSize((int) getResources().getDimension(fm.jiecao.jcvideoplayer_lib.R.dimen.jz_start_button_w_h_normal));
        this.batteryTimeLayout.setVisibility(8);
        this.clarity.setVisibility(8);
    }

    @Override // cn.jzvd.Jzvd
    public void setScreenTiny() {
        super.setScreenTiny();
        this.tinyBackImageView.setVisibility(0);
        setAllControlsVisiblity(4, 4, 4, 4, 4, 4, 4);
        this.batteryTimeLayout.setVisibility(8);
        this.clarity.setVisibility(8);
    }

    public void setSystemTimeAndBattery() {
        this.videoCurrentTime.setText(new java.text.SimpleDateFormat("HH:mm").format(new java.util.Date()));
        if (java.lang.System.currentTimeMillis() - LAST_GET_BATTERYLEVEL_TIME <= 30000) {
            setBatteryLevel();
        } else {
            LAST_GET_BATTERYLEVEL_TIME = java.lang.System.currentTimeMillis();
            this.jzvdContext.registerReceiver(this.battertReceiver, new android.content.IntentFilter("android.intent.action.BATTERY_CHANGED"));
        }
    }

    @Override // cn.jzvd.Jzvd
    public void setUp(cn.jzvd.JZDataSource jZDataSource, int i, java.lang.Class cls) {
        if (java.lang.System.currentTimeMillis() - this.goBackFullscreenTime >= 200 && java.lang.System.currentTimeMillis() - this.gotoFullscreenTime >= 200) {
            super.setUp(jZDataSource, i, (java.lang.Class<?>) cls);
            this.titleTextView.setText(jZDataSource.title);
            setScreen(i);
        }
    }

    @Override // cn.jzvd.Jzvd
    public void showBrightnessDialog(int i) {
        super.showBrightnessDialog(i);
        if (this.mBrightnessDialog == null) {
            android.view.View inflate = android.view.LayoutInflater.from(this.jzvdContext).inflate(fm.jiecao.jcvideoplayer_lib.R.layout.jz_dialog_brightness, (android.view.ViewGroup) null);
            this.mDialogBrightnessTextView = (android.widget.TextView) inflate.findViewById(fm.jiecao.jcvideoplayer_lib.R.id.tv_brightness);
            this.mDialogBrightnessProgressBar = (android.widget.ProgressBar) inflate.findViewById(fm.jiecao.jcvideoplayer_lib.R.id.brightness_progressbar);
            this.mBrightnessDialog = createDialogWithView(inflate);
        }
        if (!this.mBrightnessDialog.isShowing()) {
            this.mBrightnessDialog.show();
        }
        if (i > 100) {
            i = 100;
        } else if (i < 0) {
            i = 0;
        }
        this.mDialogBrightnessTextView.setText(i + "%");
        this.mDialogBrightnessProgressBar.setProgress(i);
        onCLickUiToggleToClear();
    }

    @Override // cn.jzvd.Jzvd
    public void showProgressDialog(float f, java.lang.String str, long j, java.lang.String str2, long j2) {
        super.showProgressDialog(f, str, j, str2, j2);
        if (this.mProgressDialog == null) {
            android.view.View inflate = android.view.LayoutInflater.from(this.jzvdContext).inflate(fm.jiecao.jcvideoplayer_lib.R.layout.jz_dialog_progress, (android.view.ViewGroup) null);
            this.mDialogProgressBar = (android.widget.ProgressBar) inflate.findViewById(fm.jiecao.jcvideoplayer_lib.R.id.duration_progressbar);
            this.mDialogSeekTime = (android.widget.TextView) inflate.findViewById(fm.jiecao.jcvideoplayer_lib.R.id.tv_current);
            this.mDialogTotalTime = (android.widget.TextView) inflate.findViewById(fm.jiecao.jcvideoplayer_lib.R.id.tv_duration);
            this.mDialogIcon = (android.widget.ImageView) inflate.findViewById(fm.jiecao.jcvideoplayer_lib.R.id.duration_image_tip);
            this.mProgressDialog = createDialogWithView(inflate);
        }
        if (!this.mProgressDialog.isShowing()) {
            this.mProgressDialog.show();
        }
        this.mDialogSeekTime.setText(str);
        this.mDialogTotalTime.setText(" / " + str2);
        this.mDialogProgressBar.setProgress(j2 <= 0 ? 0 : (int) ((j * 100) / j2));
        if (f > 0.0f) {
            this.mDialogIcon.setBackgroundResource(fm.jiecao.jcvideoplayer_lib.R.drawable.jz_forward_icon);
        } else {
            this.mDialogIcon.setBackgroundResource(fm.jiecao.jcvideoplayer_lib.R.drawable.jz_backward_icon);
        }
        onCLickUiToggleToClear();
    }

    @Override // cn.jzvd.Jzvd
    public void showVolumeDialog(float f, int i) {
        super.showVolumeDialog(f, i);
        if (this.mVolumeDialog == null) {
            android.view.View inflate = android.view.LayoutInflater.from(this.jzvdContext).inflate(fm.jiecao.jcvideoplayer_lib.R.layout.jz_dialog_volume, (android.view.ViewGroup) null);
            this.mDialogVolumeImageView = (android.widget.ImageView) inflate.findViewById(fm.jiecao.jcvideoplayer_lib.R.id.volume_image_tip);
            this.mDialogVolumeTextView = (android.widget.TextView) inflate.findViewById(fm.jiecao.jcvideoplayer_lib.R.id.tv_volume);
            this.mDialogVolumeProgressBar = (android.widget.ProgressBar) inflate.findViewById(fm.jiecao.jcvideoplayer_lib.R.id.volume_progressbar);
            this.mVolumeDialog = createDialogWithView(inflate);
        }
        if (!this.mVolumeDialog.isShowing()) {
            this.mVolumeDialog.show();
        }
        if (i <= 0) {
            this.mDialogVolumeImageView.setBackgroundResource(fm.jiecao.jcvideoplayer_lib.R.drawable.jz_close_volume);
        } else {
            this.mDialogVolumeImageView.setBackgroundResource(fm.jiecao.jcvideoplayer_lib.R.drawable.jz_add_volume);
        }
        if (i > 100) {
            i = 100;
        } else if (i < 0) {
            i = 0;
        }
        this.mDialogVolumeTextView.setText(i + "%");
        this.mDialogVolumeProgressBar.setProgress(i);
        onCLickUiToggleToClear();
    }

    @Override // cn.jzvd.Jzvd
    public void showWifiDialog() {
        super.showWifiDialog();
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(this.jzvdContext);
        builder.setMessage(getResources().getString(fm.jiecao.jcvideoplayer_lib.R.string.tips_not_wifi));
        builder.setPositiveButton(getResources().getString(fm.jiecao.jcvideoplayer_lib.R.string.tips_not_wifi_confirm), new defpackage.nu0(this));
        builder.setNegativeButton(getResources().getString(fm.jiecao.jcvideoplayer_lib.R.string.tips_not_wifi_cancel), new defpackage.ou0(this));
        builder.setOnCancelListener(new cn.jzvd.JzvdStd.AnonymousClass4());
        builder.create().show();
    }

    public void startDismissControlViewTimer() {
        cancelDismissControlViewTimer();
        DISMISS_CONTROL_VIEW_TIMER = new java.util.Timer();
        cn.jzvd.JzvdStd.DismissControlViewTimerTask dismissControlViewTimerTask = new cn.jzvd.JzvdStd.DismissControlViewTimerTask();
        this.mDismissControlViewTimerTask = dismissControlViewTimerTask;
        DISMISS_CONTROL_VIEW_TIMER.schedule(dismissControlViewTimerTask, 2500L);
    }

    @Override // cn.jzvd.Jzvd
    public void startVideo() {
        super.startVideo();
        registerWifiListener(getApplicationContext());
    }

    public void unregisterWifiListener(android.content.Context context) {
        if (context == null) {
            return;
        }
        try {
            context.unregisterReceiver(this.wifiReceiver);
        } catch (java.lang.IllegalArgumentException e) {
            e.printStackTrace();
        }
    }

    public void updateStartImage() {
        int i = this.state;
        if (i == 5) {
            this.startButton.setVisibility(0);
            this.startButton.setImageResource(fm.jiecao.jcvideoplayer_lib.R.drawable.jz_click_pause_selector);
            this.replayTextView.setVisibility(8);
        } else if (i == 8) {
            this.startButton.setVisibility(4);
            this.replayTextView.setVisibility(8);
        } else if (i != 7) {
            this.startButton.setImageResource(fm.jiecao.jcvideoplayer_lib.R.drawable.jz_click_play_selector);
            this.replayTextView.setVisibility(8);
        } else {
            this.startButton.setVisibility(0);
            this.startButton.setImageResource(fm.jiecao.jcvideoplayer_lib.R.drawable.jz_click_replay_selector);
            this.replayTextView.setVisibility(0);
        }
    }
}
