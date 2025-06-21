package com.aliyun.svideo.editor.publish;

/* loaded from: classes29.dex */
public class CoverEditActivity extends android.app.Activity {
    public static final java.lang.String KEY_PARAM_RESULT = "thumbnail";
    public static final java.lang.String KEY_PARAM_VIDEO = "vidseo_path";
    private static final java.lang.String TAG = "CoverEditActivity";
    private com.aliyun.svideosdk.common.AliyunIThumbnailFetcher mCoverThumbnailFetcher;
    private long mEndTime;
    private android.widget.ImageView mIvLeft;
    private android.widget.ImageView mIvRight;
    private com.aliyun.svideo.common.widget.AlivcCircleLoadingDialog mLoadingDialog;
    private com.aliyun.svideosdk.player.AliyunISVideoPlayer mPlayer;
    private android.view.View mSlider;
    private android.view.Surface mSurface;
    private android.view.TextureView mTextureView;
    private com.aliyun.svideosdk.common.AliyunIThumbnailFetcher mThumbnailFetcher;
    private android.widget.LinearLayout mThumbnailList;
    private java.lang.String mVideoPath;
    private final android.view.View.OnTouchListener mOnTouchListener = new com.aliyun.svideo.editor.publish.CoverEditActivity.AnonymousClass2();
    private final android.view.View.OnTouchListener mSliderListener = new com.aliyun.svideo.editor.publish.CoverEditActivity.AnonymousClass3();
    private final java.lang.Runnable mInitThumbnails = new com.aliyun.svideo.editor.publish.CoverEditActivity.AnonymousClass4();
    private android.view.TextureView.SurfaceTextureListener mTextureViewListener = new com.aliyun.svideo.editor.publish.CoverEditActivity.AnonymousClass6();
    private android.view.View.OnClickListener mOnClickListener = new com.aliyun.svideo.editor.publish.CoverEditActivity.AnonymousClass7();

    /* renamed from: com.aliyun.svideo.editor.publish.CoverEditActivity$1, reason: invalid class name */
    public class AnonymousClass1 implements android.view.ViewTreeObserver.OnPreDrawListener {
        public AnonymousClass1() {
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            com.aliyun.svideo.editor.publish.CoverEditActivity.this.mTextureView.setSurfaceTextureListener(com.aliyun.svideo.editor.publish.CoverEditActivity.this.mTextureViewListener);
            com.aliyun.svideo.editor.publish.CoverEditActivity.this.resizeLayout();
            android.view.ViewTreeObserver viewTreeObserver = com.aliyun.svideo.editor.publish.CoverEditActivity.this.mTextureView.getViewTreeObserver();
            if (!viewTreeObserver.isAlive()) {
                return true;
            }
            viewTreeObserver.removeOnPreDrawListener(this);
            return true;
        }
    }

    /* renamed from: com.aliyun.svideo.editor.publish.CoverEditActivity$2, reason: invalid class name */
    public class AnonymousClass2 implements android.view.View.OnTouchListener {
        public AnonymousClass2() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(android.view.View view, android.view.MotionEvent motionEvent) {
            int left = com.aliyun.svideo.editor.publish.CoverEditActivity.this.mSlider.getLeft() - com.aliyun.svideo.editor.publish.CoverEditActivity.this.mSlider.getPaddingLeft();
            int left2 = ((com.aliyun.svideo.editor.publish.CoverEditActivity.this.mSlider.getLeft() + com.aliyun.svideo.editor.publish.CoverEditActivity.this.mThumbnailList.getWidth()) - ((com.aliyun.svideo.editor.publish.CoverEditActivity.this.mSlider.getWidth() - com.aliyun.svideo.editor.publish.CoverEditActivity.this.mSlider.getPaddingRight()) - com.aliyun.svideo.editor.publish.CoverEditActivity.this.mSlider.getPaddingLeft())) - com.aliyun.svideo.editor.publish.CoverEditActivity.this.mSlider.getPaddingLeft();
            if (motionEvent.getAction() == 1) {
                float x = (motionEvent.getX() + com.aliyun.svideo.editor.publish.CoverEditActivity.this.mSlider.getLeft()) - com.aliyun.svideo.editor.publish.CoverEditActivity.this.mSlider.getPaddingLeft();
                float f = left2;
                if (x >= f) {
                    x = f;
                }
                float f2 = left;
                if (x <= f2) {
                    x = f2;
                }
                com.aliyun.svideo.editor.publish.CoverEditActivity.this.seek((long) ((com.aliyun.svideo.editor.publish.CoverEditActivity.this.mThumbnailFetcher.getTotalDuration() * x) / com.aliyun.svideo.editor.publish.CoverEditActivity.this.mThumbnailList.getWidth()));
                com.aliyun.svideo.editor.publish.CoverEditActivity.this.mSlider.setX(x);
            }
            return true;
        }
    }

    /* renamed from: com.aliyun.svideo.editor.publish.CoverEditActivity$3, reason: invalid class name */
    public class AnonymousClass3 implements android.view.View.OnTouchListener {
        private float dx;
        private float lastX;

        public AnonymousClass3() {
        }

        /* JADX WARN: Code restructure failed: missing block: B:7:0x0039, code lost:
        
            if (r0 != 3) goto L19;
         */
        @Override // android.view.View.OnTouchListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public boolean onTouch(android.view.View view, android.view.MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            int left = view.getLeft() - view.getPaddingLeft();
            int left2 = ((view.getLeft() + com.aliyun.svideo.editor.publish.CoverEditActivity.this.mThumbnailList.getWidth()) - ((view.getWidth() - view.getPaddingRight()) - view.getPaddingLeft())) - view.getPaddingLeft();
            if (action != 0) {
                if (action != 1) {
                    if (action == 2) {
                        float rawX = motionEvent.getRawX();
                        this.lastX = rawX;
                        float f = rawX - this.dx;
                        float f2 = left2;
                        if (f >= f2) {
                            f = f2;
                        }
                        float f3 = left;
                        if (f <= f3) {
                            f = f3;
                        }
                        view.setX(f);
                        com.aliyun.svideo.editor.publish.CoverEditActivity.this.seek((long) ((com.aliyun.svideo.editor.publish.CoverEditActivity.this.mThumbnailFetcher.getTotalDuration() * (f - f3)) / com.aliyun.svideo.editor.publish.CoverEditActivity.this.mThumbnailList.getWidth()));
                    }
                }
                com.aliyun.svideo.editor.publish.CoverEditActivity.this.seek((long) ((com.aliyun.svideo.editor.publish.CoverEditActivity.this.mThumbnailFetcher.getTotalDuration() * (view.getX() - left)) / com.aliyun.svideo.editor.publish.CoverEditActivity.this.mThumbnailList.getWidth()));
            } else {
                float rawX2 = motionEvent.getRawX();
                this.lastX = rawX2;
                this.dx = rawX2 - view.getX();
            }
            return true;
        }
    }

    /* renamed from: com.aliyun.svideo.editor.publish.CoverEditActivity$4, reason: invalid class name */
    public class AnonymousClass4 implements java.lang.Runnable {
        public AnonymousClass4() {
        }

        @Override // java.lang.Runnable
        public void run() {
            com.aliyun.svideo.editor.publish.CoverEditActivity.this.mSlider.setX(com.aliyun.svideo.editor.publish.CoverEditActivity.this.mSlider.getX() - com.aliyun.svideo.editor.publish.CoverEditActivity.this.mSlider.getPaddingLeft());
            com.aliyun.svideo.editor.publish.CoverEditActivity.this.initThumbnails();
        }
    }

    /* renamed from: com.aliyun.svideo.editor.publish.CoverEditActivity$5, reason: invalid class name */
    public class AnonymousClass5 implements com.aliyun.svideosdk.common.AliyunIThumbnailFetcher.OnThumbnailCompletion {
        final /* synthetic */ int val$count;
        final /* synthetic */ long val$interval;
        final /* synthetic */ int val$position;
        private int vecIndex = 1;

        public AnonymousClass5(int i, int i2, long j) {
            this.val$position = i;
            this.val$count = i2;
            this.val$interval = j;
        }

        @Override // com.aliyun.svideosdk.common.AliyunIThumbnailFetcher.OnThumbnailCompletion
        public void onError(int i) {
            java.lang.String unused = com.aliyun.svideo.editor.publish.CoverEditActivity.TAG;
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("requestThumbnailImage error msg: ");
            sb.append(i);
        }

        @Override // com.aliyun.svideosdk.common.AliyunIThumbnailFetcher.OnThumbnailCompletion
        public void onThumbnailReady(android.graphics.Bitmap bitmap, long j, int i) {
            if (bitmap != null && !bitmap.isRecycled()) {
                java.lang.String unused = com.aliyun.svideo.editor.publish.CoverEditActivity.TAG;
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                sb.append("onThumbnailReady  put: ");
                sb.append(this.val$position);
                sb.append(" ,l = ");
                sb.append(j / 1000);
                android.widget.ImageView imageView = new android.widget.ImageView(com.aliyun.svideo.editor.publish.CoverEditActivity.this);
                imageView.setScaleType(android.widget.ImageView.ScaleType.FIT_XY);
                imageView.setImageBitmap(bitmap);
                com.aliyun.svideo.editor.publish.CoverEditActivity.this.mThumbnailList.addView(imageView);
                return;
            }
            int i2 = this.val$position;
            if (i2 == 0) {
                this.vecIndex = 1;
            } else if (i2 == this.val$count + 1) {
                this.vecIndex = -1;
            }
            int i3 = i2 + this.vecIndex;
            java.lang.String unused2 = com.aliyun.svideo.editor.publish.CoverEditActivity.TAG;
            java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
            sb2.append("requestThumbnailImage  failure: thisPosition = ");
            sb2.append(this.val$position);
            sb2.append("newPosition = ");
            sb2.append(i3);
            com.aliyun.svideo.editor.publish.CoverEditActivity.this.requestFetchThumbnail(this.val$interval, i3, this.val$count);
        }
    }

    /* renamed from: com.aliyun.svideo.editor.publish.CoverEditActivity$6, reason: invalid class name */
    public class AnonymousClass6 implements android.view.TextureView.SurfaceTextureListener {

        /* renamed from: com.aliyun.svideo.editor.publish.CoverEditActivity$6$1, reason: invalid class name */
        public class AnonymousClass1 implements com.aliyun.svideosdk.player.PlayerCallback {
            public AnonymousClass1() {
            }

            @Override // com.aliyun.svideosdk.player.PlayerCallback
            public void onDataSize(int i, int i2) {
                android.view.ViewGroup.LayoutParams layoutParams = com.aliyun.svideo.editor.publish.CoverEditActivity.this.mTextureView.getLayoutParams();
                float f = i / i2;
                if (f >= com.aliyun.svideo.editor.publish.CoverEditActivity.this.mTextureView.getWidth() / com.aliyun.svideo.editor.publish.CoverEditActivity.this.mTextureView.getHeight()) {
                    layoutParams.width = com.aliyun.svideo.editor.publish.CoverEditActivity.this.mTextureView.getWidth();
                    layoutParams.height = (int) (com.aliyun.svideo.editor.publish.CoverEditActivity.this.mTextureView.getWidth() / f);
                } else {
                    layoutParams.height = com.aliyun.svideo.editor.publish.CoverEditActivity.this.mTextureView.getHeight();
                    layoutParams.width = (int) (com.aliyun.svideo.editor.publish.CoverEditActivity.this.mTextureView.getHeight() * f);
                }
                com.aliyun.svideo.editor.publish.CoverEditActivity.this.mTextureView.setLayoutParams(layoutParams);
                com.aliyun.svideo.editor.publish.CoverEditActivity.this.mPlayer.setDisplaySize(layoutParams.width, layoutParams.height);
            }

            @Override // com.aliyun.svideosdk.player.PlayerCallback
            public void onError(int i) {
                java.lang.String unused = com.aliyun.svideo.editor.publish.CoverEditActivity.TAG;
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                sb.append("错误码 : ");
                sb.append(i);
            }

            @Override // com.aliyun.svideosdk.player.PlayerCallback
            public void onPlayComplete() {
            }
        }

        public AnonymousClass6() {
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureAvailable(android.graphics.SurfaceTexture surfaceTexture, int i, int i2) {
            if (com.aliyun.svideo.editor.publish.CoverEditActivity.this.mPlayer == null) {
                com.aliyun.svideo.editor.publish.CoverEditActivity.this.mSurface = new android.view.Surface(surfaceTexture);
                com.aliyun.svideo.editor.publish.CoverEditActivity.this.mPlayer = com.aliyun.svideosdk.player.impl.AliyunSVideoPlayerCreator.createPlayer();
                com.aliyun.svideo.editor.publish.CoverEditActivity.this.mPlayer.init(com.aliyun.svideo.editor.publish.CoverEditActivity.this);
                com.aliyun.svideo.editor.publish.CoverEditActivity.this.mPlayer.setPlayerCallback(new com.aliyun.svideo.editor.publish.CoverEditActivity.AnonymousClass6.AnonymousClass1());
                com.aliyun.svideo.editor.publish.CoverEditActivity.this.mPlayer.setDisplay(com.aliyun.svideo.editor.publish.CoverEditActivity.this.mSurface);
                com.aliyun.svideo.editor.publish.CoverEditActivity.this.mPlayer.setSource(com.aliyun.svideo.editor.publish.CoverEditActivity.this.mVideoPath);
            }
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public boolean onSurfaceTextureDestroyed(android.graphics.SurfaceTexture surfaceTexture) {
            if (com.aliyun.svideo.editor.publish.CoverEditActivity.this.mPlayer != null) {
                com.aliyun.svideo.editor.publish.CoverEditActivity.this.mPlayer.stop();
                com.aliyun.svideo.editor.publish.CoverEditActivity.this.mPlayer.release();
                com.aliyun.svideo.editor.publish.CoverEditActivity.this.mPlayer = null;
            }
            if (com.aliyun.svideo.editor.publish.CoverEditActivity.this.mSurface == null) {
                return false;
            }
            com.aliyun.svideo.editor.publish.CoverEditActivity.this.mSurface.release();
            com.aliyun.svideo.editor.publish.CoverEditActivity.this.mSurface = null;
            return false;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureSizeChanged(android.graphics.SurfaceTexture surfaceTexture, int i, int i2) {
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureUpdated(android.graphics.SurfaceTexture surfaceTexture) {
        }
    }

    /* renamed from: com.aliyun.svideo.editor.publish.CoverEditActivity$7, reason: invalid class name */
    public class AnonymousClass7 implements android.view.View.OnClickListener {
        public AnonymousClass7() {
        }

        @Override // android.view.View.OnClickListener
        @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
        public void onClick(android.view.View view) {
            if (view == com.aliyun.svideo.editor.publish.CoverEditActivity.this.mIvLeft) {
                com.aliyun.svideo.editor.publish.CoverEditActivity.this.onBackPressed();
            } else if (view == com.aliyun.svideo.editor.publish.CoverEditActivity.this.mIvRight) {
                if (com.aliyun.svideo.editor.publish.CoverEditActivity.this.mLoadingDialog == null) {
                    com.aliyun.svideo.editor.publish.CoverEditActivity.this.mLoadingDialog = new com.aliyun.svideo.common.widget.AlivcCircleLoadingDialog(com.aliyun.svideo.editor.publish.CoverEditActivity.this, 0);
                }
                com.aliyun.svideo.editor.publish.CoverEditActivity.this.mLoadingDialog.show();
                com.aliyun.svideo.editor.publish.CoverEditActivity.this.requestThumbnailCover();
            }
            com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    /* renamed from: com.aliyun.svideo.editor.publish.CoverEditActivity$8, reason: invalid class name */
    public class AnonymousClass8 implements com.aliyun.svideosdk.common.AliyunIThumbnailFetcher.OnThumbnailCompletion {
        public AnonymousClass8() {
        }

        @Override // com.aliyun.svideosdk.common.AliyunIThumbnailFetcher.OnThumbnailCompletion
        public void onError(int i) {
            com.aliyun.svideo.common.utils.ToastUtils.show(com.aliyun.svideo.editor.publish.CoverEditActivity.this, com.aliyun.svideo.editor.R.string.alivc_editor_cover_fetch_cover_error);
            com.aliyun.svideo.editor.publish.CoverEditActivity.this.mLoadingDialog.dismiss();
        }

        @Override // com.aliyun.svideosdk.common.AliyunIThumbnailFetcher.OnThumbnailCompletion
        public void onThumbnailReady(android.graphics.Bitmap bitmap, long j, int i) {
            java.io.FileOutputStream fileOutputStream;
            if (bitmap == null || bitmap.isRecycled()) {
                com.aliyun.svideo.editor.publish.CoverEditActivity.this.requestThumbnailCover();
                return;
            }
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            java.io.FileOutputStream fileOutputStream2 = null;
            sb.append(com.aliyun.svideo.editor.publish.CoverEditActivity.this.getExternalFilesDir(null));
            sb.append("thumbnail.jpeg");
            java.lang.String sb2 = sb.toString();
            try {
                try {
                    fileOutputStream = new java.io.FileOutputStream(sb2);
                } catch (java.lang.Exception e) {
                    e = e;
                }
            } catch (java.lang.Throwable th) {
                th = th;
            }
            try {
                bitmap.compress(android.graphics.Bitmap.CompressFormat.JPEG, 100, fileOutputStream);
                try {
                    fileOutputStream.close();
                } catch (java.io.IOException e2) {
                    e2.printStackTrace();
                }
                android.content.Intent intent = new android.content.Intent();
                intent.putExtra(com.aliyun.svideo.editor.publish.CoverEditActivity.KEY_PARAM_RESULT, sb2);
                com.aliyun.svideo.editor.publish.CoverEditActivity.this.setResult(-1, intent);
                com.aliyun.svideo.editor.publish.CoverEditActivity.this.finish();
                com.aliyun.svideo.editor.publish.CoverEditActivity.this.mLoadingDialog.dismiss();
            } catch (java.lang.Exception e3) {
                e = e3;
                fileOutputStream2 = fileOutputStream;
                java.lang.String unused = com.aliyun.svideo.editor.publish.CoverEditActivity.TAG;
                e.getMessage();
                com.aliyun.svideo.common.utils.ToastUtils.show(com.aliyun.svideo.editor.publish.CoverEditActivity.this, com.aliyun.svideo.editor.R.string.alivc_editor_cover_fetch_cover_error);
                com.aliyun.svideo.editor.publish.CoverEditActivity.this.mLoadingDialog.dismiss();
                if (fileOutputStream2 != null) {
                    try {
                        fileOutputStream2.close();
                    } catch (java.io.IOException e4) {
                        e4.printStackTrace();
                    }
                }
            } catch (java.lang.Throwable th2) {
                th = th2;
                fileOutputStream2 = fileOutputStream;
                if (fileOutputStream2 != null) {
                    try {
                        fileOutputStream2.close();
                    } catch (java.io.IOException e5) {
                        e5.printStackTrace();
                    }
                }
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initThumbnails() {
        int width = this.mThumbnailList.getWidth() / 8;
        this.mThumbnailFetcher.setParameters(width, width, com.aliyun.svideosdk.common.AliyunIThumbnailFetcher.CropMode.Mediate, com.aliyun.svideosdk.common.struct.common.VideoDisplayMode.SCALE, 8);
        long totalDuration = this.mThumbnailFetcher.getTotalDuration() / 8;
        for (int i = 1; i <= 8; i++) {
            requestFetchThumbnail(totalDuration, i, 8);
        }
    }

    private void initView() {
        this.mIvLeft = (android.widget.ImageView) findViewById(com.aliyun.svideo.editor.R.id.iv_left);
        this.mIvRight = (android.widget.ImageView) findViewById(com.aliyun.svideo.editor.R.id.iv_right);
        android.widget.TextView textView = (android.widget.TextView) findViewById(com.aliyun.svideo.editor.R.id.tv_center);
        this.mIvLeft.setVisibility(0);
        this.mIvRight.setVisibility(0);
        textView.setVisibility(0);
        textView.setText(com.aliyun.svideo.editor.R.string.alivc_editor_cover_tittle);
        this.mIvLeft.setImageResource(com.aliyun.svideo.editor.R.drawable.aliyun_svideo_crop_icon_cancel);
        this.mIvRight.setImageResource(com.aliyun.svideo.editor.R.mipmap.aliyun_svideo_icon_confirm);
        this.mIvLeft.setOnClickListener(this.mOnClickListener);
        this.mIvRight.setOnClickListener(this.mOnClickListener);
        android.view.View findViewById = findViewById(com.aliyun.svideo.editor.R.id.indiator);
        this.mSlider = findViewById;
        findViewById.setOnTouchListener(this.mSliderListener);
        android.widget.LinearLayout linearLayout = (android.widget.LinearLayout) findViewById(com.aliyun.svideo.editor.R.id.cover_thumbnail_list);
        this.mThumbnailList = linearLayout;
        linearLayout.setOnTouchListener(this.mOnTouchListener);
        android.view.TextureView textureView = (android.view.TextureView) findViewById(com.aliyun.svideo.editor.R.id.ttv_editor_cover);
        this.mTextureView = textureView;
        textureView.getViewTreeObserver().addOnPreDrawListener(new com.aliyun.svideo.editor.publish.CoverEditActivity.AnonymousClass1());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void requestFetchThumbnail(long j, int i, int i2) {
        long[] jArr = {((i - 1) * j) + (j / 2)};
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("requestThumbnailImage() times :");
        sb.append(jArr[0]);
        sb.append(" ,position = ");
        sb.append(i);
        this.mThumbnailFetcher.requestThumbnailImage(jArr, new com.aliyun.svideo.editor.publish.CoverEditActivity.AnonymousClass5(i, i2, j));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void requestThumbnailCover() {
        com.aliyun.svideosdk.common.AliyunIThumbnailFetcher createThumbnailFetcher = com.aliyun.svideosdk.common.impl.AliyunThumbnailFetcherFactory.createThumbnailFetcher();
        this.mCoverThumbnailFetcher = createThumbnailFetcher;
        createThumbnailFetcher.addVideoSource(this.mVideoPath, 0L, 2147483647L, 0L);
        this.mCoverThumbnailFetcher.setParameters(this.mTextureView.getWidth(), this.mTextureView.getHeight(), com.aliyun.svideosdk.common.AliyunIThumbnailFetcher.CropMode.Mediate, com.aliyun.svideosdk.common.struct.common.VideoDisplayMode.SCALE, 2);
        this.mCoverThumbnailFetcher.requestThumbnailImage(new long[]{this.mEndTime}, new com.aliyun.svideo.editor.publish.CoverEditActivity.AnonymousClass8());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resizeLayout() {
        com.aliyun.svideosdk.transcode.NativeParser nativeParser = new com.aliyun.svideosdk.transcode.NativeParser();
        nativeParser.init(this.mVideoPath);
        int parseInt = java.lang.Integer.parseInt(nativeParser.getValue(6));
        int parseInt2 = java.lang.Integer.parseInt(nativeParser.getValue(7));
        nativeParser.release();
        nativeParser.dispose();
        android.view.ViewGroup.LayoutParams layoutParams = this.mTextureView.getLayoutParams();
        float f = parseInt / parseInt2;
        if (f >= this.mTextureView.getWidth() / this.mTextureView.getHeight()) {
            layoutParams.width = this.mTextureView.getWidth();
            layoutParams.height = (int) (this.mTextureView.getWidth() / f);
        } else {
            layoutParams.height = this.mTextureView.getHeight();
            layoutParams.width = (int) (this.mTextureView.getHeight() * f);
        }
        this.mTextureView.setLayoutParams(layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void seek(long j) {
        this.mPlayer.seek(j);
        this.mEndTime = j;
    }

    @Override // android.app.Activity
    public void onCreate(@androidx.annotation.Nullable android.os.Bundle bundle) {
        super.onCreate(bundle);
        setContentView(com.aliyun.svideo.editor.R.layout.alivc_editor_activity_cover_edit);
        initView();
        this.mVideoPath = getIntent().getStringExtra(KEY_PARAM_VIDEO);
        com.aliyun.svideosdk.common.AliyunIThumbnailFetcher createThumbnailFetcher = com.aliyun.svideosdk.common.impl.AliyunThumbnailFetcherFactory.createThumbnailFetcher();
        this.mThumbnailFetcher = createThumbnailFetcher;
        createThumbnailFetcher.addVideoSource(this.mVideoPath, 0L, 2147483647L, 0L);
        this.mThumbnailList.post(this.mInitThumbnails);
    }

    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        com.aliyun.svideosdk.common.AliyunIThumbnailFetcher aliyunIThumbnailFetcher = this.mThumbnailFetcher;
        if (aliyunIThumbnailFetcher != null) {
            aliyunIThumbnailFetcher.release();
        }
        com.aliyun.svideosdk.common.AliyunIThumbnailFetcher aliyunIThumbnailFetcher2 = this.mCoverThumbnailFetcher;
        if (aliyunIThumbnailFetcher2 != null) {
            aliyunIThumbnailFetcher2.release();
        }
    }

    @Override // android.app.Activity
    @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
    public void onNewIntent(android.content.Intent intent) {
        super.onNewIntent(intent);
        com.sensorsdata.analytics.android.sdk.aop.push.PushAutoTrackHelper.onNewIntent(this, intent);
    }
}
