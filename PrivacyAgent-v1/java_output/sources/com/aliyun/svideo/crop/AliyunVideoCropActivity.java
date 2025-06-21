package com.aliyun.svideo.crop;

/* loaded from: classes29.dex */
public class AliyunVideoCropActivity extends android.app.Activity implements android.view.TextureView.SurfaceTextureListener, com.aliyun.svideo.base.widget.HorizontalListView.OnScrollCallBack, com.aliyun.svideo.base.widget.SizeChangedNotifier.Listener, android.media.MediaPlayer.OnVideoSizeChangedListener, com.aliyun.svideo.base.widget.VideoTrimFrameLayout.OnVideoScrollCallBack, android.view.View.OnClickListener, com.aliyun.svideosdk.crop.CropCallback, android.os.Handler.Callback {
    private static final int END_VIDEO = 1003;
    private static final int MAX_DURATION = Integer.MAX_VALUE;
    private static final int PAUSE_VIDEO = 1001;
    private static final int PLAY_VIDEO = 1000;
    public static final int RATIO_ORIGINAL = 3;
    public static final int REQUEST_CODE_CROP_VIDEO_CROP = 2;
    public static final int REQUEST_CODE_EDITOR_VIDEO_CROP = 1;
    public static final com.aliyun.svideosdk.common.struct.common.VideoDisplayMode SCALE_CROP = com.aliyun.svideosdk.common.struct.common.VideoDisplayMode.SCALE;
    public static final com.aliyun.svideosdk.common.struct.common.VideoDisplayMode SCALE_FILL = com.aliyun.svideosdk.common.struct.common.VideoDisplayMode.FILL;
    public static final java.lang.String TAG = com.aliyun.svideo.crop.AliyunVideoCropActivity.class.getSimpleName();
    private com.aliyun.svideo.crop.VideoTrimAdapter adapter;
    private android.widget.ImageView cancelBtn;
    private com.aliyun.svideosdk.crop.AliyunICrop crop;
    private android.widget.TextView dirationTxt;
    private long duration;
    private com.aliyun.svideo.base.widget.VideoTrimFrameLayout frame;
    private int frameHeight;
    private int frameRate;
    private int frameWidth;
    private int gop;
    private com.aliyun.svideo.base.widget.HorizontalListView listView;
    private com.aliyun.svideo.base.widget.FanProgressBar mCropProgress;
    private android.widget.FrameLayout mCropProgressBg;
    private long mEndTime;
    private java.lang.String mInputVideoPath;
    private com.aliyun.svideosdk.common.struct.common.VideoDisplayMode mOriginalMode;
    private com.aliyun.svideosdk.player.AliyunISVideoPlayer mPlayer;
    private int mScrollX;
    private int mScrollY;
    private long mStartTime;
    private android.view.Surface mSurface;
    private com.aliyun.svideosdk.common.AliyunIThumbnailFetcher mThumbnailFetcher;
    private android.widget.ImageView nextBtn;
    private java.lang.String outputPath;
    private int ratioMode;
    private int resolutionMode;
    private int screenWidth;
    private com.aliyun.svideo.base.widget.VideoSliceSeekBar seekBar;
    long startCropTimestamp;
    private android.view.TextureView textureview;
    private android.widget.ImageView transFormBtn;
    private int videoHeight;
    private int videoWidth;
    private int playState = 1003;
    private com.aliyun.svideosdk.common.struct.common.VideoQuality quality = com.aliyun.svideosdk.common.struct.common.VideoQuality.HD;
    private com.aliyun.svideosdk.common.struct.encoder.VideoCodecs mVideoCodec = com.aliyun.svideosdk.common.struct.encoder.VideoCodecs.H264_HARDWARE;
    private int cropDuration = 2000;
    private com.aliyun.svideosdk.common.struct.common.VideoDisplayMode cropMode = com.aliyun.svideosdk.common.struct.common.VideoDisplayMode.SCALE;
    private android.os.Handler playHandler = new android.os.Handler(this);
    private boolean isPause = false;
    private boolean isCropping = false;
    private boolean needPlayStart = false;
    private boolean isUseGPU = false;
    private int mAction = 0;
    private com.aliyun.svideo.base.widget.VideoSliceSeekBar.SeekBarChangeListener mSeekBarListener = new com.aliyun.svideo.crop.AliyunVideoCropActivity.AnonymousClass2();

    /* renamed from: com.aliyun.svideo.crop.AliyunVideoCropActivity$1, reason: invalid class name */
    public class AnonymousClass1 implements com.aliyun.svideosdk.player.PlayerCallback {

        /* renamed from: com.aliyun.svideo.crop.AliyunVideoCropActivity$1$1, reason: invalid class name and collision with other inner class name */
        public class RunnableC00551 implements java.lang.Runnable {
            public RunnableC00551() {
            }

            @Override // java.lang.Runnable
            public void run() {
                com.aliyun.svideo.crop.AliyunVideoCropActivity aliyunVideoCropActivity = com.aliyun.svideo.crop.AliyunVideoCropActivity.this;
                com.aliyun.common.utils.ToastUtil.showToast(aliyunVideoCropActivity, aliyunVideoCropActivity.getString(com.aliyun.svideo.crop.R.string.alivc_crop_video_tip_error));
            }
        }

        public AnonymousClass1() {
        }

        @Override // com.aliyun.svideosdk.player.PlayerCallback
        public void onDataSize(int i, int i2) {
            if (i == 0 || i2 == 0) {
                com.aliyun.svideosdk.common.struct.common.VideoDisplayMode videoDisplayMode = com.aliyun.svideo.crop.AliyunVideoCropActivity.SCALE_CROP;
                return;
            }
            com.aliyun.svideo.crop.AliyunVideoCropActivity aliyunVideoCropActivity = com.aliyun.svideo.crop.AliyunVideoCropActivity.this;
            aliyunVideoCropActivity.frameWidth = aliyunVideoCropActivity.frame.getWidth();
            com.aliyun.svideo.crop.AliyunVideoCropActivity aliyunVideoCropActivity2 = com.aliyun.svideo.crop.AliyunVideoCropActivity.this;
            aliyunVideoCropActivity2.frameHeight = aliyunVideoCropActivity2.frame.getHeight();
            com.aliyun.svideo.crop.AliyunVideoCropActivity.this.videoWidth = i;
            com.aliyun.svideo.crop.AliyunVideoCropActivity.this.videoHeight = i2;
            if (com.aliyun.svideo.crop.AliyunVideoCropActivity.this.crop != null && com.aliyun.svideo.crop.AliyunVideoCropActivity.this.mEndTime == 0) {
                try {
                    com.aliyun.svideo.crop.AliyunVideoCropActivity.this.mEndTime = (long) ((r0.crop.getVideoDuration(com.aliyun.svideo.crop.AliyunVideoCropActivity.this.mInputVideoPath) * 1.0f) / 1000.0f);
                } catch (java.lang.Exception unused) {
                    com.aliyun.common.utils.ToastUtil.showToast(com.aliyun.svideo.crop.AliyunVideoCropActivity.this, com.aliyun.svideo.crop.R.string.alivc_crop_video_tip_error);
                }
            }
            if (com.aliyun.svideo.crop.AliyunVideoCropActivity.this.cropMode == com.aliyun.svideo.crop.AliyunVideoCropActivity.SCALE_CROP) {
                com.aliyun.svideo.crop.AliyunVideoCropActivity.this.scaleCrop(i, i2);
            } else if (com.aliyun.svideo.crop.AliyunVideoCropActivity.this.cropMode == com.aliyun.svideo.crop.AliyunVideoCropActivity.SCALE_FILL) {
                com.aliyun.svideo.crop.AliyunVideoCropActivity.this.scaleFill(i, i2);
            }
            com.aliyun.svideo.crop.AliyunVideoCropActivity.this.mPlayer.setDisplaySize(com.aliyun.svideo.crop.AliyunVideoCropActivity.this.textureview.getLayoutParams().width, com.aliyun.svideo.crop.AliyunVideoCropActivity.this.textureview.getLayoutParams().height);
            com.aliyun.svideo.crop.AliyunVideoCropActivity.this.playVideo();
        }

        @Override // com.aliyun.svideosdk.player.PlayerCallback
        public void onError(int i) {
            com.aliyun.svideosdk.common.struct.common.VideoDisplayMode videoDisplayMode = com.aliyun.svideo.crop.AliyunVideoCropActivity.SCALE_CROP;
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("错误码 : ");
            sb.append(i);
            com.aliyun.svideo.common.utils.ThreadUtils.runOnUiThread(new com.aliyun.svideo.crop.AliyunVideoCropActivity.AnonymousClass1.RunnableC00551());
        }

        @Override // com.aliyun.svideosdk.player.PlayerCallback
        public void onPlayComplete() {
        }
    }

    /* renamed from: com.aliyun.svideo.crop.AliyunVideoCropActivity$2, reason: invalid class name */
    public class AnonymousClass2 implements com.aliyun.svideo.base.widget.VideoSliceSeekBar.SeekBarChangeListener {
        public AnonymousClass2() {
        }

        @Override // com.aliyun.svideo.base.widget.VideoSliceSeekBar.SeekBarChangeListener
        public void onSeekEnd() {
            com.aliyun.svideo.crop.AliyunVideoCropActivity.this.needPlayStart = true;
            if (com.aliyun.svideo.crop.AliyunVideoCropActivity.this.playState == 1001) {
                com.aliyun.svideo.crop.AliyunVideoCropActivity.this.playVideo();
            }
        }

        @Override // com.aliyun.svideo.base.widget.VideoSliceSeekBar.SeekBarChangeListener
        public void onSeekStart() {
            com.aliyun.svideo.crop.AliyunVideoCropActivity.this.pauseVideo();
        }

        @Override // com.aliyun.svideo.base.widget.VideoSliceSeekBar.SeekBarChangeListener
        public void seekBarValueChanged(float f, float f2, int i) {
            long j;
            if (i == 0) {
                j = (long) ((com.aliyun.svideo.crop.AliyunVideoCropActivity.this.duration * f) / 100.0f);
                com.aliyun.svideo.crop.AliyunVideoCropActivity.this.mStartTime = j;
            } else if (i == 1) {
                j = (long) ((com.aliyun.svideo.crop.AliyunVideoCropActivity.this.duration * f2) / 100.0f);
                com.aliyun.svideo.crop.AliyunVideoCropActivity.this.mEndTime = j;
            } else {
                j = 0;
            }
            com.aliyun.svideo.crop.AliyunVideoCropActivity.this.dirationTxt.setText(((com.aliyun.svideo.crop.AliyunVideoCropActivity.this.mEndTime - com.aliyun.svideo.crop.AliyunVideoCropActivity.this.mStartTime) / 1000.0f) + "");
            if (com.aliyun.svideo.crop.AliyunVideoCropActivity.this.mPlayer != null) {
                com.aliyun.svideo.crop.AliyunVideoCropActivity.this.mPlayer.seek((int) j);
            }
            com.aliyun.svideosdk.common.struct.common.VideoDisplayMode videoDisplayMode = com.aliyun.svideo.crop.AliyunVideoCropActivity.SCALE_CROP;
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("mStartTime");
            sb.append(com.aliyun.svideo.crop.AliyunVideoCropActivity.this.mStartTime);
        }
    }

    /* renamed from: com.aliyun.svideo.crop.AliyunVideoCropActivity$3, reason: invalid class name */
    public class AnonymousClass3 extends android.os.AsyncTask {
        public AnonymousClass3() {
        }

        @Override // android.os.AsyncTask
        public java.lang.Object doInBackground(java.lang.Object[] objArr) {
            com.aliyun.common.utils.FileUtils.deleteFile(com.aliyun.svideo.crop.AliyunVideoCropActivity.this.outputPath);
            return null;
        }
    }

    /* renamed from: com.aliyun.svideo.crop.AliyunVideoCropActivity$4, reason: invalid class name */
    public class AnonymousClass4 implements java.lang.Runnable {
        final /* synthetic */ int val$percent;

        public AnonymousClass4(int i) {
            this.val$percent = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.aliyun.svideo.crop.AliyunVideoCropActivity.this.mCropProgress.setProgress(this.val$percent);
        }
    }

    /* renamed from: com.aliyun.svideo.crop.AliyunVideoCropActivity$5, reason: invalid class name */
    public class AnonymousClass5 implements java.lang.Runnable {
        final /* synthetic */ int val$code;

        public AnonymousClass5(int i) {
            this.val$code = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.aliyun.svideo.crop.AliyunVideoCropActivity.this.mCropProgressBg.setVisibility(8);
            com.aliyun.svideo.crop.AliyunVideoCropActivity.this.seekBar.setSliceBlocked(false);
            switch (this.val$code) {
                case -20004002:
                    com.aliyun.common.utils.ToastUtil.showToast(com.aliyun.svideo.crop.AliyunVideoCropActivity.this, com.aliyun.svideo.crop.R.string.alivc_crop_video_tip_not_supported_audio);
                    break;
                case -20004001:
                    com.aliyun.common.utils.ToastUtil.showToast(com.aliyun.svideo.crop.AliyunVideoCropActivity.this, com.aliyun.svideo.crop.R.string.alivc_crop_video_tip_not_supported_video);
                    break;
                default:
                    com.aliyun.common.utils.ToastUtil.showToast(com.aliyun.svideo.crop.AliyunVideoCropActivity.this, com.aliyun.svideo.crop.R.string.alivc_crop_video_tip_crop_failed);
                    break;
            }
            com.aliyun.svideo.crop.AliyunVideoCropActivity aliyunVideoCropActivity = com.aliyun.svideo.crop.AliyunVideoCropActivity.this;
            aliyunVideoCropActivity.setResult(0, aliyunVideoCropActivity.getIntent());
        }
    }

    /* renamed from: com.aliyun.svideo.crop.AliyunVideoCropActivity$6, reason: invalid class name */
    public class AnonymousClass6 implements java.lang.Runnable {

        /* renamed from: com.aliyun.svideo.crop.AliyunVideoCropActivity$6$1, reason: invalid class name */
        public class AnonymousClass1 implements java.lang.Runnable {
            public AnonymousClass1() {
            }

            @Override // java.lang.Runnable
            public void run() {
                com.aliyun.svideo.common.utils.UriUtils.saveVideoToMediaStore(com.aliyun.svideo.crop.AliyunVideoCropActivity.this.getApplicationContext(), com.aliyun.svideo.crop.AliyunVideoCropActivity.this.outputPath);
            }
        }

        public AnonymousClass6() {
        }

        @Override // java.lang.Runnable
        public void run() {
            com.aliyun.svideo.crop.AliyunVideoCropActivity.this.mCropProgress.setVisibility(8);
            com.aliyun.svideo.crop.AliyunVideoCropActivity.this.mCropProgressBg.setVisibility(8);
            com.aliyun.svideo.crop.AliyunVideoCropActivity.this.seekBar.setSliceBlocked(false);
            if (android.os.Build.VERSION.SDK_INT >= 29) {
                com.aliyun.svideo.common.utils.ThreadUtils.runOnSubThread(new com.aliyun.svideo.crop.AliyunVideoCropActivity.AnonymousClass6.AnonymousClass1());
            } else {
                com.aliyun.svideo.crop.AliyunVideoCropActivity.this.scanFile();
            }
            long j = com.aliyun.svideo.crop.AliyunVideoCropActivity.this.mEndTime - com.aliyun.svideo.crop.AliyunVideoCropActivity.this.mStartTime;
            com.aliyun.svideo.crop.bean.AlivcCropOutputParam alivcCropOutputParam = new com.aliyun.svideo.crop.bean.AlivcCropOutputParam();
            alivcCropOutputParam.setOutputPath(com.aliyun.svideo.crop.AliyunVideoCropActivity.this.outputPath);
            alivcCropOutputParam.setDuration(j);
            com.aliyun.svideo.crop.AliyunVideoCropActivity.this.onCropComplete(alivcCropOutputParam);
        }
    }

    /* renamed from: com.aliyun.svideo.crop.AliyunVideoCropActivity$7, reason: invalid class name */
    public class AnonymousClass7 implements java.lang.Runnable {
        public AnonymousClass7() {
        }

        @Override // java.lang.Runnable
        public void run() {
            com.aliyun.svideo.crop.AliyunVideoCropActivity.this.mCropProgressBg.setVisibility(8);
            com.aliyun.svideo.crop.AliyunVideoCropActivity.this.seekBar.setSliceBlocked(false);
        }
    }

    /* renamed from: com.aliyun.svideo.crop.AliyunVideoCropActivity$8, reason: invalid class name */
    public class AnonymousClass8 implements com.aliyun.svideosdk.common.AliyunIThumbnailFetcher.OnThumbnailCompletion {
        final /* synthetic */ int val$count;
        final /* synthetic */ long val$interval;
        final /* synthetic */ int val$position;
        private int vecIndex = 1;

        public AnonymousClass8(int i, int i2, long j) {
            this.val$position = i;
            this.val$count = i2;
            this.val$interval = j;
        }

        @Override // com.aliyun.svideosdk.common.AliyunIThumbnailFetcher.OnThumbnailCompletion
        public void onError(int i) {
            com.aliyun.svideosdk.common.struct.common.VideoDisplayMode videoDisplayMode = com.aliyun.svideo.crop.AliyunVideoCropActivity.SCALE_CROP;
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("requestThumbnailImage error msg: ");
            sb.append(i);
        }

        @Override // com.aliyun.svideosdk.common.AliyunIThumbnailFetcher.OnThumbnailCompletion
        public void onThumbnailReady(android.graphics.Bitmap bitmap, long j, int i) {
            if (bitmap != null && !bitmap.isRecycled()) {
                com.aliyun.svideosdk.common.struct.common.VideoDisplayMode videoDisplayMode = com.aliyun.svideo.crop.AliyunVideoCropActivity.SCALE_CROP;
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                sb.append("onThumbnailReady  put: ");
                sb.append(this.val$position);
                sb.append(" ,l = ");
                sb.append(j / 1000);
                com.aliyun.svideo.crop.AliyunVideoCropActivity.this.adapter.add(new java.lang.ref.SoftReference<>(bitmap));
                return;
            }
            int i2 = this.val$position;
            if (i2 == 0) {
                this.vecIndex = 1;
            } else if (i2 == this.val$count + 1) {
                this.vecIndex = -1;
            }
            int i3 = i2 + this.vecIndex;
            com.aliyun.svideosdk.common.struct.common.VideoDisplayMode videoDisplayMode2 = com.aliyun.svideo.crop.AliyunVideoCropActivity.SCALE_CROP;
            java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
            sb2.append("requestThumbnailImage  failure: thisPosition = ");
            sb2.append(this.val$position);
            sb2.append("newPosition = ");
            sb2.append(i3);
            com.aliyun.svideo.crop.AliyunVideoCropActivity.this.requestFetchThumbnail(this.val$interval, i3, this.val$count);
        }
    }

    private void deleteFile() {
        new com.aliyun.svideo.crop.AliyunVideoCropActivity.AnonymousClass3().executeOnExecutor(android.os.AsyncTask.THREAD_POOL_EXECUTOR, new java.lang.Object[0]);
    }

    private void getData() {
        android.content.Intent intent = getIntent();
        this.mAction = intent.getIntExtra(com.aliyun.svideo.crop.bean.AlivcCropInputParam.INTENT_KEY_ACTION, 0);
        java.lang.String stringExtra = intent.getStringExtra(com.aliyun.svideo.crop.bean.AlivcCropInputParam.INTENT_KEY_PATH);
        this.mInputVideoPath = stringExtra;
        try {
            this.duration = this.crop.getVideoDuration(stringExtra) / 1000;
        } catch (java.lang.Exception unused) {
            com.aliyun.common.utils.ToastUtil.showToast(this, com.aliyun.svideo.crop.R.string.alivc_crop_video_tip_crop_failed);
        }
        this.resolutionMode = intent.getIntExtra("mResolutionMode", 3);
        com.aliyun.svideosdk.common.struct.common.VideoDisplayMode videoDisplayMode = (com.aliyun.svideosdk.common.struct.common.VideoDisplayMode) intent.getSerializableExtra(com.aliyun.svideo.crop.bean.AlivcCropInputParam.INTENT_KEY_CROP_MODE);
        this.cropMode = videoDisplayMode;
        if (videoDisplayMode == null) {
            this.cropMode = com.aliyun.svideosdk.common.struct.common.VideoDisplayMode.SCALE;
        }
        this.mOriginalMode = this.cropMode;
        com.aliyun.svideosdk.common.struct.common.VideoQuality videoQuality = (com.aliyun.svideosdk.common.struct.common.VideoQuality) intent.getSerializableExtra(com.aliyun.svideo.crop.bean.AlivcCropInputParam.INTENT_KEY_QUALITY);
        this.quality = videoQuality;
        if (videoQuality == null) {
            this.quality = com.aliyun.svideosdk.common.struct.common.VideoQuality.HD;
        }
        this.gop = intent.getIntExtra("mGop", 250);
        this.frameRate = intent.getIntExtra(com.aliyun.svideo.crop.bean.AlivcCropInputParam.INTENT_KEY_FRAME_RATE, 30);
        this.ratioMode = intent.getIntExtra("mRatioMode", 2);
        this.cropDuration = intent.getIntExtra(com.aliyun.svideo.crop.bean.AlivcCropInputParam.INTENT_KEY_MIN_DURATION, 2000);
        this.isUseGPU = intent.getBooleanExtra(com.aliyun.svideo.crop.bean.AlivcCropInputParam.INTENT_KEY_USE_GPU, false);
        com.aliyun.svideosdk.common.struct.encoder.VideoCodecs videoCodecs = (com.aliyun.svideosdk.common.struct.encoder.VideoCodecs) intent.getSerializableExtra(com.aliyun.svideo.crop.bean.AlivcCropInputParam.INTENT_KEY_CODECS);
        this.mVideoCodec = videoCodecs;
        if (videoCodecs == null) {
            this.mVideoCodec = com.aliyun.svideosdk.common.struct.encoder.VideoCodecs.H264_HARDWARE;
        }
    }

    public static java.lang.String getVersion() {
        return com.aliyun.common.global.Version.VERSION;
    }

    private void initView() {
        int dip2px = com.aliyun.common.utils.DensityUtil.dip2px(this, 5.0f);
        com.aliyun.svideo.base.widget.VideoSliceSeekBar videoSliceSeekBar = (com.aliyun.svideo.base.widget.VideoSliceSeekBar) findViewById(com.aliyun.svideo.crop.R.id.aliyun_seek_bar);
        this.seekBar = videoSliceSeekBar;
        videoSliceSeekBar.setSeekBarChangeListener(this.mSeekBarListener);
        int i = ((int) ((this.cropDuration / this.duration) * 100.0f)) + 1;
        com.aliyun.svideo.base.widget.VideoSliceSeekBar videoSliceSeekBar2 = this.seekBar;
        if (i > 100) {
            i = 100;
        }
        videoSliceSeekBar2.setProgressMinDiff(i);
        com.aliyun.svideo.base.widget.HorizontalListView horizontalListView = (com.aliyun.svideo.base.widget.HorizontalListView) findViewById(com.aliyun.svideo.crop.R.id.aliyun_video_tailor_image_list);
        this.listView = horizontalListView;
        horizontalListView.setOnScrollCallBack(this);
        com.aliyun.svideo.crop.VideoTrimAdapter videoTrimAdapter = new com.aliyun.svideo.crop.VideoTrimAdapter(this, new java.util.ArrayList());
        this.adapter = videoTrimAdapter;
        this.listView.setAdapter((android.widget.ListAdapter) videoTrimAdapter);
        android.widget.ImageView imageView = (android.widget.ImageView) findViewById(com.aliyun.svideo.crop.R.id.aliyun_transform);
        this.transFormBtn = imageView;
        imageView.setOnClickListener(this);
        android.widget.ImageView imageView2 = (android.widget.ImageView) findViewById(com.aliyun.svideo.crop.R.id.aliyun_next);
        this.nextBtn = imageView2;
        imageView2.setOnClickListener(this);
        android.widget.ImageView imageView3 = (android.widget.ImageView) findViewById(com.aliyun.svideo.crop.R.id.aliyun_back);
        this.cancelBtn = imageView3;
        imageView3.setOnClickListener(this);
        android.widget.TextView textView = (android.widget.TextView) findViewById(com.aliyun.svideo.crop.R.id.aliyun_duration_txt);
        this.dirationTxt = textView;
        textView.setText((this.duration / 1000.0f) + "");
        android.widget.FrameLayout frameLayout = (android.widget.FrameLayout) findViewById(com.aliyun.svideo.crop.R.id.aliyun_crop_progress_bg);
        this.mCropProgressBg = frameLayout;
        frameLayout.setVisibility(8);
        com.aliyun.svideo.base.widget.FanProgressBar fanProgressBar = (com.aliyun.svideo.base.widget.FanProgressBar) findViewById(com.aliyun.svideo.crop.R.id.aliyun_crop_progress);
        this.mCropProgress = fanProgressBar;
        int i2 = dip2px / 2;
        fanProgressBar.setOutRadius((com.aliyun.common.utils.DensityUtil.dip2px(this, 40.0f) / 2) - i2);
        this.mCropProgress.setOffset(i2, i2);
        this.mCropProgress.setOutStrokeWidth(dip2px);
        setListViewHeight();
        requestThumbItemTime();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onCropComplete(com.aliyun.svideo.crop.bean.AlivcCropOutputParam alivcCropOutputParam) {
        android.content.Intent intent = getIntent();
        intent.putExtra(com.aliyun.svideo.crop.bean.AlivcCropOutputParam.RESULT_KEY_OUTPUT_PARAM, alivcCropOutputParam);
        setResult(-1, intent);
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pauseVideo() {
        com.aliyun.svideosdk.player.AliyunISVideoPlayer aliyunISVideoPlayer = this.mPlayer;
        if (aliyunISVideoPlayer == null) {
            return;
        }
        aliyunISVideoPlayer.pause();
        this.playState = 1001;
        this.playHandler.removeMessages(1000);
        this.seekBar.showFrameProgress(false);
        this.seekBar.invalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void playVideo() {
        com.aliyun.svideosdk.player.AliyunISVideoPlayer aliyunISVideoPlayer;
        if (this.isCropping || (aliyunISVideoPlayer = this.mPlayer) == null) {
            return;
        }
        aliyunISVideoPlayer.seek((int) this.mStartTime);
        this.mPlayer.resume();
        this.playState = 1000;
        this.playHandler.sendEmptyMessage(1000);
        this.needPlayStart = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void requestFetchThumbnail(long j, int i, int i2) {
        long[] jArr = {((i - 1) * j) + (j / 2)};
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("requestThumbnailImage() times :");
        sb.append(jArr[0]);
        sb.append(" ,position = ");
        sb.append(i);
        this.mThumbnailFetcher.requestThumbnailImage(jArr, new com.aliyun.svideo.crop.AliyunVideoCropActivity.AnonymousClass8(i, i2, j));
    }

    private void requestThumbItemTime() {
        int i = this.screenWidth / 10;
        com.aliyun.svideosdk.common.AliyunIThumbnailFetcher createThumbnailFetcher = com.aliyun.svideosdk.common.impl.AliyunThumbnailFetcherFactory.createThumbnailFetcher();
        this.mThumbnailFetcher = createThumbnailFetcher;
        createThumbnailFetcher.addVideoSource(this.mInputVideoPath, 0L, 2147483647L, 0L);
        this.mThumbnailFetcher.setParameters(i, i, com.aliyun.svideosdk.common.AliyunIThumbnailFetcher.CropMode.Mediate, com.aliyun.svideosdk.common.struct.common.VideoDisplayMode.SCALE, 10);
        this.mThumbnailFetcher.setFastMode(true);
        long totalDuration = this.mThumbnailFetcher.getTotalDuration() / 10;
        for (int i2 = 1; i2 <= 10; i2++) {
            requestFetchThumbnail(totalDuration, i2, 10);
        }
    }

    private void resetScroll() {
        this.mScrollX = 0;
        this.mScrollY = 0;
    }

    private void resizeFrame() {
        int i;
        android.widget.FrameLayout.LayoutParams layoutParams = (android.widget.FrameLayout.LayoutParams) this.frame.getLayoutParams();
        int i2 = this.ratioMode;
        if (i2 == 0) {
            int i3 = this.screenWidth;
            layoutParams.width = i3;
            layoutParams.height = (i3 * 4) / 3;
        } else if (i2 == 1) {
            int i4 = this.screenWidth;
            layoutParams.width = i4;
            layoutParams.height = i4;
        } else if (i2 != 2) {
            int i5 = this.screenWidth;
            layoutParams.width = i5;
            layoutParams.height = (i5 * 16) / 9;
        } else {
            int i6 = this.screenWidth;
            layoutParams.width = i6;
            layoutParams.height = (i6 * 16) / 9;
        }
        this.frame.setLayoutParams(layoutParams);
        com.aliyun.svideosdk.transcode.NativeParser nativeParser = new com.aliyun.svideosdk.transcode.NativeParser();
        nativeParser.init(this.mInputVideoPath);
        try {
            try {
                this.videoWidth = java.lang.Integer.parseInt(nativeParser.getValue(6));
                this.videoHeight = java.lang.Integer.parseInt(nativeParser.getValue(7));
                nativeParser.release();
                nativeParser.dispose();
                int i7 = this.videoWidth;
                if (i7 == 0 || (i = this.videoHeight) == 0) {
                    return;
                }
                this.frameWidth = layoutParams.width;
                this.frameHeight = layoutParams.height;
                com.aliyun.svideosdk.common.struct.common.VideoDisplayMode videoDisplayMode = this.cropMode;
                if (videoDisplayMode == SCALE_CROP) {
                    scaleCrop(i7, i);
                } else if (videoDisplayMode == SCALE_FILL) {
                    scaleFill(i7, i);
                }
            } catch (java.lang.NumberFormatException e) {
                e.getMessage();
                nativeParser.release();
                nativeParser.dispose();
            }
        } catch (java.lang.Throwable th) {
            nativeParser.release();
            nativeParser.dispose();
            throw th;
        }
    }

    private void resumeVideo() {
        com.aliyun.svideosdk.player.AliyunISVideoPlayer aliyunISVideoPlayer = this.mPlayer;
        if (aliyunISVideoPlayer == null) {
            return;
        }
        if (this.needPlayStart) {
            playVideo();
            this.needPlayStart = false;
        } else {
            aliyunISVideoPlayer.resume();
            this.playState = 1000;
            this.playHandler.sendEmptyMessage(1000);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void scaleCrop(int i, int i2) {
        if (i == 0 || i2 == 0) {
            return;
        }
        android.widget.FrameLayout.LayoutParams layoutParams = (android.widget.FrameLayout.LayoutParams) this.textureview.getLayoutParams();
        float max = java.lang.Math.max(i, i2) / java.lang.Math.min(i, i2);
        int i3 = this.ratioMode;
        float f = i3 != 0 ? i3 != 1 ? 1.7777778f : 1.0f : 1.3333334f;
        if (i3 == 3) {
            if (i > i2) {
                int i4 = this.frameWidth;
                layoutParams.width = i4;
                layoutParams.height = (i4 * i2) / i;
            } else if (max >= f) {
                int i5 = this.frameHeight;
                layoutParams.height = i5;
                layoutParams.width = (i5 * i) / i2;
            } else {
                int i6 = this.frameWidth;
                layoutParams.width = i6;
                layoutParams.height = (i6 * i2) / i;
            }
        } else if (i > i2) {
            int i7 = this.frameHeight;
            layoutParams.height = i7;
            layoutParams.width = (i7 * i) / i2;
        } else if (max >= f) {
            int i8 = this.frameWidth;
            layoutParams.width = i8;
            layoutParams.height = (i8 * i2) / i;
        } else {
            int i9 = this.frameHeight;
            layoutParams.height = i9;
            layoutParams.width = (i9 * i) / i2;
        }
        layoutParams.setMargins(0, 0, 0, 0);
        this.textureview.setLayoutParams(layoutParams);
        this.cropMode = SCALE_CROP;
        this.transFormBtn.setActivated(true);
        resetScroll();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void scaleFill(int i, int i2) {
        if (i == 0 || i2 == 0) {
            return;
        }
        android.widget.FrameLayout.LayoutParams layoutParams = (android.widget.FrameLayout.LayoutParams) this.textureview.getLayoutParams();
        float max = java.lang.Math.max(i, i2) / java.lang.Math.min(i, i2);
        int i3 = this.ratioMode;
        float f = i3 != 0 ? i3 != 1 ? 1.7777778f : 1.0f : 1.3333334f;
        if (i > i2) {
            int i4 = this.frameWidth;
            layoutParams.width = i4;
            layoutParams.height = (i4 * i2) / i;
        } else if (max >= f) {
            int i5 = this.frameHeight;
            layoutParams.height = i5;
            layoutParams.width = (i5 * i) / i2;
        } else {
            int i6 = this.frameWidth;
            layoutParams.width = i6;
            layoutParams.height = (i6 * i2) / i;
        }
        layoutParams.setMargins(0, 0, 0, 0);
        this.textureview.setLayoutParams(layoutParams);
        this.cropMode = SCALE_FILL;
        this.transFormBtn.setActivated(false);
        resetScroll();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void scanFile() {
        android.media.MediaScannerConnection.scanFile(getApplicationContext(), new java.lang.String[]{this.outputPath}, new java.lang.String[]{"video/mp4"}, null);
    }

    private void setListViewHeight() {
        android.widget.FrameLayout.LayoutParams layoutParams = (android.widget.FrameLayout.LayoutParams) this.listView.getLayoutParams();
        layoutParams.height = (this.screenWidth - com.aliyun.svideo.common.utils.DensityUtils.dip2px(this, 40.0f)) / 10;
        this.listView.setLayoutParams(layoutParams);
        this.seekBar.setLayoutParams(new android.widget.FrameLayout.LayoutParams(-1, layoutParams.height));
    }

    private void startCrop() {
        float f;
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        if (!com.aliyun.svideo.common.utils.PermissionUtils.checkPermissionsGroup(this, new java.lang.String[]{"android.permission.READ_EXTERNAL_STORAGE"})) {
            com.aliyun.svideo.common.utils.ToastUtils.show(this, com.aliyun.svideo.common.utils.PermissionUtils.NO_PERMISSION_TIP[4]);
            return;
        }
        if (this.frameWidth == 0 || this.frameHeight == 0) {
            com.aliyun.common.utils.ToastUtil.showToast(this, com.aliyun.svideo.crop.R.string.alivc_crop_video_tip_crop_failed);
            this.isCropping = false;
            return;
        }
        if (this.isCropping) {
            return;
        }
        pauseVideo();
        android.widget.FrameLayout.LayoutParams layoutParams = (android.widget.FrameLayout.LayoutParams) this.textureview.getLayoutParams();
        this.outputPath = com.aliyun.svideo.base.Constants.SDCardConstants.getDir(this) + com.aliyun.svideo.common.utils.DateTimeUtils.getDateTimeFromMillisecond(java.lang.Long.valueOf(java.lang.System.currentTimeMillis())) + com.aliyun.svideo.base.Constants.SDCardConstants.CROP_SUFFIX;
        int i11 = this.videoHeight;
        int i12 = this.videoWidth;
        float f2 = ((float) i11) / ((float) i12);
        int i13 = this.ratioMode;
        if (i13 == 0) {
            f = 1.3333334f;
        } else if (i13 != 1) {
            f = 1.7777778f;
            if (i13 != 2 && i13 == 3) {
                f = f2;
            }
        } else {
            f = 1.0f;
        }
        int i14 = 540;
        if (f2 > f) {
            int i15 = ((((layoutParams.height - this.frameHeight) / 2) + this.mScrollY) * i12) / this.frameWidth;
            while (i15 % 4 != 0) {
                i15++;
            }
            int i16 = this.resolutionMode;
            if (i16 == 0) {
                i14 = com.amap.api.maps.utils.SpatialRelationUtil.A_CIRCLE_DEGREE;
            } else if (i16 == 1) {
                i14 = com.autonavi.amap.mapcore.tools.GlMapUtil.DEVICE_DISPLAY_DPI_XHIGH;
            } else if (i16 != 2) {
                i14 = 720;
            }
            i11 = this.videoWidth;
            int i17 = this.ratioMode;
            if (i17 == 0) {
                i9 = (i11 * 4) / 3;
                i10 = (i14 * 4) / 3;
            } else if (i17 == 1) {
                i5 = i15;
                i4 = i11;
                i3 = i14;
                i6 = 0;
            } else if (i17 != 2) {
                i5 = i15;
                i6 = 0;
                i4 = 0;
                i3 = 0;
            } else {
                i9 = (i11 * 16) / 9;
                i10 = (i14 * 16) / 9;
            }
            i3 = i10;
            i4 = i9;
            i5 = i15;
            i6 = 0;
        } else {
            if (f2 < f) {
                i6 = ((((layoutParams.width - this.frameWidth) / 2) + this.mScrollX) * i11) / this.frameHeight;
                while (i6 % 4 != 0) {
                    i6++;
                }
                int i18 = this.resolutionMode;
                if (i18 == 0) {
                    i14 = com.amap.api.maps.utils.SpatialRelationUtil.A_CIRCLE_DEGREE;
                } else if (i18 == 1) {
                    i14 = com.autonavi.amap.mapcore.tools.GlMapUtil.DEVICE_DISPLAY_DPI_XHIGH;
                } else if (i18 != 2) {
                    i14 = 720;
                }
                i11 = this.videoHeight;
                int i19 = this.ratioMode;
                if (i19 == 0) {
                    i7 = (i11 * 3) / 4;
                    i8 = (i14 * 4) / 3;
                } else if (i19 == 1) {
                    i4 = i11;
                    i3 = i14;
                } else if (i19 == 2) {
                    i7 = (i11 * 9) / 16;
                    i8 = (i14 * 16) / 9;
                } else if (i19 != 3) {
                    i7 = (i11 * 9) / 16;
                    i8 = (i14 * 16) / 9;
                } else {
                    i7 = (int) (i11 / f2);
                    i8 = (int) (i14 * f2);
                }
                i3 = i8;
                i4 = i11;
                i11 = i7;
            } else {
                int i20 = this.resolutionMode;
                if (i20 == 0) {
                    i14 = com.amap.api.maps.utils.SpatialRelationUtil.A_CIRCLE_DEGREE;
                } else if (i20 == 1) {
                    i14 = com.autonavi.amap.mapcore.tools.GlMapUtil.DEVICE_DISPLAY_DPI_XHIGH;
                } else if (i20 != 2) {
                    i14 = 720;
                }
                if (i13 == 0) {
                    i = (i11 * 3) / 4;
                    i2 = (i14 * 4) / 3;
                } else if (i13 == 1) {
                    i4 = i11;
                    i3 = i14;
                    i6 = 0;
                } else if (i13 == 2) {
                    i = (i11 * 9) / 16;
                    i2 = (i14 * 16) / 9;
                } else if (i13 != 3) {
                    i = (i11 * 9) / 16;
                    i2 = (i14 * 16) / 9;
                } else {
                    i = (int) (i11 / f2);
                    i2 = (int) (i14 * f2);
                }
                i3 = i2;
                i4 = i11;
                i5 = 0;
                i11 = i;
                i6 = 0;
            }
            i5 = 0;
        }
        com.aliyun.svideosdk.crop.CropParam cropParam = new com.aliyun.svideosdk.crop.CropParam();
        cropParam.setOutputPath(this.outputPath);
        cropParam.setInputPath(this.mInputVideoPath);
        cropParam.setOutputWidth(i14);
        cropParam.setOutputHeight(i3);
        cropParam.setCropRect(new android.graphics.Rect(i6, i5, i11 + i6, i4 + i5));
        long j = this.mStartTime;
        java.util.concurrent.TimeUnit timeUnit = java.util.concurrent.TimeUnit.MILLISECONDS;
        cropParam.setStartTime(j, timeUnit);
        cropParam.setEndTime(this.mEndTime, timeUnit);
        cropParam.setScaleMode(this.cropMode);
        cropParam.setFrameRate(this.frameRate);
        cropParam.setGop(this.gop);
        cropParam.setQuality(this.quality);
        cropParam.setVideoCodec(this.mVideoCodec);
        cropParam.setFillColor(androidx.core.view.ViewCompat.MEASURED_STATE_MASK);
        cropParam.setCrf(0);
        this.mCropProgressBg.setVisibility(0);
        cropParam.setUseGPU(this.isUseGPU);
        this.crop.setCropParam(cropParam);
        int startCrop = this.crop.startCrop();
        if (startCrop < 0) {
            com.aliyun.common.utils.ToastUtil.showToast(this, getString(com.aliyun.svideo.crop.R.string.alivc_crop_video_tip_crop_failed) + "  " + startCrop);
            return;
        }
        this.startCropTimestamp = java.lang.System.currentTimeMillis();
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("start : ");
        sb.append(this.startCropTimestamp);
        this.isCropping = true;
        this.seekBar.setSliceBlocked(true);
    }

    public static void startCropForResult(android.app.Activity activity, int i, com.aliyun.svideosdk.common.struct.common.AliyunSnapVideoParam aliyunSnapVideoParam) {
        android.content.Intent intent = new android.content.Intent(activity, (java.lang.Class<?>) com.aliyun.svideo.crop.CropMediaActivity.class);
        intent.putExtra(com.aliyun.svideosdk.common.struct.common.AliyunSnapVideoParam.SORT_MODE, aliyunSnapVideoParam.getSortMode());
        intent.putExtra("video_resolution", aliyunSnapVideoParam.getResolutionMode());
        intent.putExtra("video_ratio", aliyunSnapVideoParam.getRatioMode());
        intent.putExtra(com.aliyun.svideosdk.common.struct.common.AliyunSnapVideoParam.NEED_RECORD, aliyunSnapVideoParam.isNeedRecord());
        intent.putExtra("video_quality", aliyunSnapVideoParam.getVideoQuality());
        intent.putExtra(com.aliyun.svideosdk.common.struct.common.AliyunSnapVideoParam.VIDEO_CODEC, aliyunSnapVideoParam.getVideoCodec());
        intent.putExtra("video_gop", aliyunSnapVideoParam.getGop());
        intent.putExtra("video_framerate", aliyunSnapVideoParam.getFrameRate());
        intent.putExtra("crop_mode", aliyunSnapVideoParam.getScaleMode());
        intent.putExtra(com.aliyun.svideosdk.common.struct.common.AliyunSnapVideoParam.MIN_CROP_DURATION, aliyunSnapVideoParam.getMinCropDuration());
        intent.putExtra(com.aliyun.svideosdk.common.struct.common.AliyunSnapVideoParam.MIN_VIDEO_DURATION, aliyunSnapVideoParam.getMinVideoDuration());
        intent.putExtra(com.aliyun.svideosdk.common.struct.common.AliyunSnapVideoParam.MAX_VIDEO_DURATION, aliyunSnapVideoParam.getMaxVideoDuration());
        intent.putExtra(com.aliyun.svideosdk.common.struct.common.AliyunSnapVideoParam.RECORD_MODE, aliyunSnapVideoParam.getRecordMode());
        intent.putExtra(com.aliyun.svideosdk.common.struct.common.AliyunSnapVideoParam.FILTER_LIST, aliyunSnapVideoParam.getFilterList());
        intent.putExtra(com.aliyun.svideosdk.common.struct.common.AliyunSnapVideoParam.BEAUTY_LEVEL, aliyunSnapVideoParam.getBeautyLevel());
        intent.putExtra(com.aliyun.svideosdk.common.struct.common.AliyunSnapVideoParam.BEAUTY_STATUS, aliyunSnapVideoParam.getBeautyStatus());
        intent.putExtra(com.aliyun.svideosdk.common.struct.common.AliyunSnapVideoParam.CAMERA_TYPE, aliyunSnapVideoParam.getCameraType());
        intent.putExtra(com.aliyun.svideosdk.common.struct.common.AliyunSnapVideoParam.FLASH_TYPE, aliyunSnapVideoParam.getFlashType());
        intent.putExtra(com.aliyun.svideosdk.common.struct.common.AliyunSnapVideoParam.NEED_CLIP, aliyunSnapVideoParam.isNeedClip());
        intent.putExtra(com.aliyun.svideosdk.common.struct.common.AliyunSnapVideoParam.MAX_DURATION, aliyunSnapVideoParam.getMaxDuration());
        intent.putExtra(com.aliyun.svideosdk.common.struct.common.AliyunSnapVideoParam.MIN_DURATION, aliyunSnapVideoParam.getMinDuration());
        intent.putExtra(com.aliyun.svideosdk.common.struct.common.AliyunSnapVideoParam.CROP_USE_GPU, aliyunSnapVideoParam.isCropUseGPU());
        activity.startActivityForResult(intent, i);
    }

    public static void startVideoCropForResult(android.app.Activity activity, com.aliyun.svideo.crop.bean.AlivcCropInputParam alivcCropInputParam, int i) {
        if (alivcCropInputParam == null || android.text.TextUtils.isEmpty(alivcCropInputParam.getPath())) {
            return;
        }
        android.content.Intent intent = new android.content.Intent(activity, (java.lang.Class<?>) com.aliyun.svideo.crop.AliyunVideoCropActivity.class);
        intent.putExtra(com.aliyun.svideo.crop.bean.AlivcCropInputParam.INTENT_KEY_PATH, alivcCropInputParam.getPath());
        intent.putExtra("mResolutionMode", alivcCropInputParam.getResolutionMode());
        intent.putExtra(com.aliyun.svideo.crop.bean.AlivcCropInputParam.INTENT_KEY_CROP_MODE, alivcCropInputParam.getCropMode());
        intent.putExtra(com.aliyun.svideo.crop.bean.AlivcCropInputParam.INTENT_KEY_QUALITY, alivcCropInputParam.getQuality());
        intent.putExtra(com.aliyun.svideo.crop.bean.AlivcCropInputParam.INTENT_KEY_CODECS, alivcCropInputParam.getVideoCodecs());
        intent.putExtra("mGop", i == 1 ? 5 : alivcCropInputParam.getGop());
        intent.putExtra("mRatioMode", alivcCropInputParam.getRatioMode());
        intent.putExtra(com.aliyun.svideo.crop.bean.AlivcCropInputParam.INTENT_KEY_FRAME_RATE, alivcCropInputParam.getFrameRate());
        intent.putExtra(com.aliyun.svideo.crop.bean.AlivcCropInputParam.INTENT_KEY_ACTION, alivcCropInputParam.getAction());
        intent.putExtra(com.aliyun.svideo.crop.bean.AlivcCropInputParam.INTENT_KEY_MIN_DURATION, alivcCropInputParam.getMinCropDuration());
        intent.putExtra(com.aliyun.svideo.crop.bean.AlivcCropInputParam.INTENT_KEY_USE_GPU, alivcCropInputParam.isUseGPU());
        activity.startActivityForResult(intent, i);
    }

    public int getVideoWidth() {
        int i = this.resolutionMode;
        return i != 0 ? i != 1 ? (i == 2 || i != 3) ? 540 : 720 : com.autonavi.amap.mapcore.tools.GlMapUtil.DEVICE_DISPLAY_DPI_XHIGH : com.amap.api.maps.utils.SpatialRelationUtil.A_CIRCLE_DEGREE;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(android.os.Message message) {
        int i = message.what;
        if (i != 1000) {
            if (i != 1001) {
                return false;
            }
            pauseVideo();
            return false;
        }
        com.aliyun.svideosdk.player.AliyunISVideoPlayer aliyunISVideoPlayer = this.mPlayer;
        if (aliyunISVideoPlayer == null) {
            return false;
        }
        long currentPosition = aliyunISVideoPlayer.getCurrentPosition() / 1000;
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("currentPlayPos:");
        sb.append(currentPosition);
        if (currentPosition >= this.mEndTime) {
            playVideo();
            return false;
        }
        this.seekBar.showFrameProgress(true);
        this.seekBar.setFrameProgress(currentPosition / this.duration);
        this.playHandler.sendEmptyMessageDelayed(1000, 100L);
        return false;
    }

    public void initSurface() {
        com.aliyun.svideo.base.widget.VideoTrimFrameLayout videoTrimFrameLayout = (com.aliyun.svideo.base.widget.VideoTrimFrameLayout) findViewById(com.aliyun.svideo.crop.R.id.aliyun_video_surfaceLayout);
        this.frame = videoTrimFrameLayout;
        videoTrimFrameLayout.setOnSizeChangedListener(this);
        this.frame.setOnScrollCallBack(this);
        this.textureview = (android.view.TextureView) findViewById(com.aliyun.svideo.crop.R.id.aliyun_video_textureview);
        resizeFrame();
        this.textureview.setSurfaceTextureListener(this);
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (this.isCropping) {
            this.crop.cancel();
        } else {
            super.onBackPressed();
        }
    }

    @Override // com.aliyun.svideosdk.crop.CropCallback
    public void onCancelComplete() {
        runOnUiThread(new com.aliyun.svideo.crop.AliyunVideoCropActivity.AnonymousClass7());
        deleteFile();
        setResult(0);
        finish();
        this.isCropping = false;
    }

    @Override // android.view.View.OnClickListener
    @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
    public void onClick(android.view.View view) {
        if (view == this.transFormBtn) {
            if (this.isCropping) {
                com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
                return;
            }
            com.aliyun.svideosdk.common.struct.common.VideoDisplayMode videoDisplayMode = this.cropMode;
            if (videoDisplayMode == SCALE_FILL) {
                scaleCrop(this.videoWidth, this.videoHeight);
            } else if (videoDisplayMode == SCALE_CROP) {
                scaleFill(this.videoWidth, this.videoHeight);
            }
        } else if (view == this.nextBtn) {
            if (this.mScrollX != 0 || this.mScrollY != 0 || !this.cropMode.equals(this.mOriginalMode)) {
                this.mAction = 0;
            }
            int i = this.mAction;
            if (i == 0) {
                startCrop();
            } else if (i == 1) {
                long j = this.mEndTime - this.mStartTime;
                com.aliyun.svideo.crop.bean.AlivcCropOutputParam alivcCropOutputParam = new com.aliyun.svideo.crop.bean.AlivcCropOutputParam();
                alivcCropOutputParam.setOutputPath(this.mInputVideoPath);
                alivcCropOutputParam.setDuration(j);
                alivcCropOutputParam.setStartTime(this.mStartTime);
                onCropComplete(alivcCropOutputParam);
            }
        } else if (view == this.cancelBtn) {
            onBackPressed();
        }
        com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    @Override // com.aliyun.svideosdk.crop.CropCallback
    public void onComplete(long j) {
        long currentTimeMillis = java.lang.System.currentTimeMillis();
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("completed : ");
        sb.append(currentTimeMillis - this.startCropTimestamp);
        runOnUiThread(new com.aliyun.svideo.crop.AliyunVideoCropActivity.AnonymousClass6());
        this.isCropping = false;
        com.aliyun.svideo.base.utils.VideoInfoUtils.printVideoInfo(this.outputPath);
    }

    @Override // android.app.Activity
    public void onCreate(@androidx.annotation.Nullable android.os.Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        getWindow().setFlags(1024, 1024);
        getWindow().addFlags(128);
        setContentView(com.aliyun.svideo.crop.R.layout.alivc_crop_activity_video_crop);
        this.screenWidth = getResources().getDisplayMetrics().widthPixels;
        com.aliyun.svideosdk.crop.AliyunICrop createCropInstance = com.aliyun.svideosdk.crop.impl.AliyunCropCreator.createCropInstance(this);
        this.crop = createCropInstance;
        createCropInstance.setCropCallback(this);
        getData();
        initView();
        initSurface();
    }

    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        com.aliyun.svideosdk.crop.AliyunICrop aliyunICrop = this.crop;
        if (aliyunICrop != null) {
            aliyunICrop.dispose();
            this.crop = null;
        }
        com.aliyun.svideosdk.common.AliyunIThumbnailFetcher aliyunIThumbnailFetcher = this.mThumbnailFetcher;
        if (aliyunIThumbnailFetcher != null) {
            aliyunIThumbnailFetcher.release();
        }
    }

    @Override // com.aliyun.svideosdk.crop.CropCallback
    public void onError(int i) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("crop failed : ");
        sb.append(i);
        runOnUiThread(new com.aliyun.svideo.crop.AliyunVideoCropActivity.AnonymousClass5(i));
        this.isCropping = false;
    }

    @Override // android.app.Activity
    @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
    public void onNewIntent(android.content.Intent intent) {
        super.onNewIntent(intent);
        com.sensorsdata.analytics.android.sdk.aop.push.PushAutoTrackHelper.onNewIntent(this, intent);
    }

    @Override // android.app.Activity
    public void onPause() {
        if (this.playState == 1000) {
            pauseVideo();
        }
        this.isPause = true;
        super.onPause();
    }

    @Override // com.aliyun.svideosdk.crop.CropCallback
    public void onProgress(int i) {
        runOnUiThread(new com.aliyun.svideo.crop.AliyunVideoCropActivity.AnonymousClass4(i));
    }

    @Override // android.app.Activity
    public void onResume() {
        com.aliyun.svideosdk.player.AliyunISVideoPlayer aliyunISVideoPlayer;
        super.onResume();
        if (this.isPause) {
            playVideo();
        }
        if (!this.isCropping || (aliyunISVideoPlayer = this.mPlayer) == null) {
            return;
        }
        this.mPlayer.draw(aliyunISVideoPlayer.getCurrentPosition() / 1000);
    }

    @Override // com.aliyun.svideo.base.widget.HorizontalListView.OnScrollCallBack
    public void onScrollDistance(java.lang.Long l, int i) {
    }

    @Override // com.aliyun.svideo.base.widget.SizeChangedNotifier.Listener
    public void onSizeChanged(android.view.View view, int i, int i2, int i3, int i4) {
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(android.graphics.SurfaceTexture surfaceTexture, int i, int i2) {
        if (this.mPlayer == null) {
            this.mSurface = new android.view.Surface(surfaceTexture);
            com.aliyun.svideosdk.player.AliyunISVideoPlayer createPlayer = com.aliyun.svideosdk.player.impl.AliyunSVideoPlayerCreator.createPlayer();
            this.mPlayer = createPlayer;
            createPlayer.init(this);
            this.mPlayer.setPlayerCallback(new com.aliyun.svideo.crop.AliyunVideoCropActivity.AnonymousClass1());
            this.mPlayer.setDisplay(this.mSurface);
            this.mPlayer.setSource(this.mInputVideoPath);
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(android.graphics.SurfaceTexture surfaceTexture) {
        com.aliyun.svideosdk.player.AliyunISVideoPlayer aliyunISVideoPlayer = this.mPlayer;
        if (aliyunISVideoPlayer == null) {
            return false;
        }
        aliyunISVideoPlayer.stop();
        this.mPlayer.release();
        this.playState = 1003;
        this.mPlayer = null;
        this.mSurface.release();
        this.mSurface = null;
        return false;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(android.graphics.SurfaceTexture surfaceTexture, int i, int i2) {
        this.mPlayer.setDisplaySize(i, i2);
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(android.graphics.SurfaceTexture surfaceTexture) {
    }

    @Override // com.aliyun.svideo.base.widget.VideoTrimFrameLayout.OnVideoScrollCallBack
    public void onVideoScroll(float f, float f2) {
        if (this.isCropping) {
            return;
        }
        android.widget.FrameLayout.LayoutParams layoutParams = (android.widget.FrameLayout.LayoutParams) this.textureview.getLayoutParams();
        int i = layoutParams.width;
        int i2 = layoutParams.height;
        int i3 = this.frameWidth;
        if (i > i3 || i2 > this.frameHeight) {
            int i4 = i - i3;
            int i5 = i2 - this.frameHeight;
            if (i4 > 0) {
                int i6 = i4 / 2;
                int i7 = (int) (this.mScrollX + f);
                this.mScrollX = i7;
                if (i7 > i6) {
                    this.mScrollX = i6;
                }
                int i8 = -i6;
                if (this.mScrollX < i8) {
                    this.mScrollX = i8;
                }
            }
            if (i5 > 0) {
                int i9 = i5 / 2;
                int i10 = (int) (this.mScrollY + f2);
                this.mScrollY = i10;
                if (i10 > i9) {
                    this.mScrollY = i9;
                }
                int i11 = -i9;
                if (this.mScrollY < i11) {
                    this.mScrollY = i11;
                }
            }
            layoutParams.setMargins(0, 0, this.mScrollX, this.mScrollY);
        }
        this.textureview.setLayoutParams(layoutParams);
    }

    @Override // com.aliyun.svideo.base.widget.VideoTrimFrameLayout.OnVideoScrollCallBack
    public void onVideoSingleTapUp() {
        if (this.isCropping) {
            return;
        }
        int i = this.playState;
        if (i == 1003) {
            playVideo();
        } else if (i == 1000) {
            pauseVideo();
        } else if (i == 1001) {
            resumeVideo();
        }
    }

    @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
    public void onVideoSizeChanged(android.media.MediaPlayer mediaPlayer, int i, int i2) {
        this.frameWidth = this.frame.getWidth();
        this.frameHeight = this.frame.getHeight();
        this.videoWidth = i;
        this.videoHeight = i2;
        this.mStartTime = 0L;
        if (this.crop != null) {
            try {
                this.mEndTime = (long) ((r3.getVideoDuration(this.mInputVideoPath) * 1.0f) / 1000.0f);
            } catch (java.lang.Exception unused) {
                com.aliyun.common.utils.ToastUtil.showToast(this, com.aliyun.svideo.crop.R.string.alivc_crop_video_tip_crop_failed);
            }
        } else {
            this.mEndTime = 2147483647L;
        }
        com.aliyun.svideosdk.common.struct.common.VideoDisplayMode videoDisplayMode = this.cropMode;
        if (videoDisplayMode == SCALE_CROP) {
            scaleCrop(i, i2);
        } else if (videoDisplayMode == SCALE_FILL) {
            scaleFill(i, i2);
        }
    }
}
