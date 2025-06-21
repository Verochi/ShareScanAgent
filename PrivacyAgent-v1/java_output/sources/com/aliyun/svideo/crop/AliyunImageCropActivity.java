package com.aliyun.svideo.crop;

/* loaded from: classes29.dex */
public class AliyunImageCropActivity extends android.app.Activity implements com.aliyun.svideo.base.widget.HorizontalListView.OnScrollCallBack, com.aliyun.svideo.base.widget.SizeChangedNotifier.Listener, com.aliyun.svideo.base.widget.VideoTrimFrameLayout.OnVideoScrollCallBack, android.view.View.OnClickListener, com.aliyun.svideosdk.crop.CropCallback {
    public static final int REQUEST_CODE_EDITOR_IMAGE_CROP = 2;
    public static final java.lang.String RESULT_KEY_CROP_PATH = "crop_path";
    public static final com.aliyun.svideosdk.common.struct.common.VideoDisplayMode SCALE_CROP = com.aliyun.svideosdk.common.struct.common.VideoDisplayMode.SCALE;
    public static final com.aliyun.svideosdk.common.struct.common.VideoDisplayMode SCALE_FILL = com.aliyun.svideosdk.common.struct.common.VideoDisplayMode.FILL;
    public static final java.lang.String VIDEO_PATH = "video_path";
    private static int mOutStrokeWidth;
    private android.widget.ImageView cancelBtn;
    private com.aliyun.svideosdk.crop.AliyunICrop crop;
    private com.aliyun.svideo.base.widget.VideoTrimFrameLayout frame;
    private int frameHeight;
    private int frameRate;
    private int frameWidth;
    private int gop;
    private com.aliyun.svideo.base.widget.FanProgressBar mCropProgress;
    private android.widget.FrameLayout mCropProgressBg;
    private android.os.AsyncTask<java.lang.Void, java.lang.Void, java.lang.Void> mDeleteTask;
    private int mImageHeight;
    private android.widget.ImageView mImageView;
    private int mImageWidth;
    private java.lang.String mMimeType;
    private int mScrollX;
    private int mScrollY;
    private java.lang.String mSuffix;
    private android.widget.ImageView nextBtn;
    private java.lang.String outputPath;
    private java.lang.String path;
    private int ratioMode;
    private int resolutionMode;
    private int screenWidth;
    private android.widget.ImageView transFormBtn;
    private com.aliyun.svideosdk.common.struct.common.VideoQuality quality = com.aliyun.svideosdk.common.struct.common.VideoQuality.HD;
    private com.aliyun.svideosdk.common.struct.encoder.VideoCodecs mVideoCodecs = com.aliyun.svideosdk.common.struct.encoder.VideoCodecs.H264_HARDWARE;
    private com.aliyun.svideosdk.common.struct.common.VideoDisplayMode cropMode = com.aliyun.svideosdk.common.struct.common.VideoDisplayMode.SCALE;
    private boolean isCropping = false;

    /* renamed from: com.aliyun.svideo.crop.AliyunImageCropActivity$1, reason: invalid class name */
    public class AnonymousClass1 implements android.view.ViewTreeObserver.OnGlobalLayoutListener {
        public AnonymousClass1() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            com.aliyun.svideo.crop.AliyunImageCropActivity aliyunImageCropActivity = com.aliyun.svideo.crop.AliyunImageCropActivity.this;
            aliyunImageCropActivity.frameWidth = aliyunImageCropActivity.frame.getWidth();
            com.aliyun.svideo.crop.AliyunImageCropActivity aliyunImageCropActivity2 = com.aliyun.svideo.crop.AliyunImageCropActivity.this;
            aliyunImageCropActivity2.frameHeight = aliyunImageCropActivity2.frame.getHeight();
            if (com.aliyun.svideo.crop.AliyunImageCropActivity.this.cropMode == com.aliyun.svideo.crop.AliyunImageCropActivity.SCALE_CROP) {
                com.aliyun.svideo.crop.AliyunImageCropActivity aliyunImageCropActivity3 = com.aliyun.svideo.crop.AliyunImageCropActivity.this;
                aliyunImageCropActivity3.scaleCrop(aliyunImageCropActivity3.mImageWidth, com.aliyun.svideo.crop.AliyunImageCropActivity.this.mImageHeight);
            } else if (com.aliyun.svideo.crop.AliyunImageCropActivity.this.cropMode == com.aliyun.svideo.crop.AliyunImageCropActivity.SCALE_FILL) {
                com.aliyun.svideo.crop.AliyunImageCropActivity aliyunImageCropActivity4 = com.aliyun.svideo.crop.AliyunImageCropActivity.this;
                aliyunImageCropActivity4.scaleFill(aliyunImageCropActivity4.mImageWidth, com.aliyun.svideo.crop.AliyunImageCropActivity.this.mImageHeight);
            }
            com.aliyun.svideo.crop.AliyunImageCropActivity.this.frame.getViewTreeObserver().removeGlobalOnLayoutListener(this);
        }
    }

    /* renamed from: com.aliyun.svideo.crop.AliyunImageCropActivity$2, reason: invalid class name */
    public class AnonymousClass2 implements java.lang.Runnable {
        final /* synthetic */ int val$percent;

        public AnonymousClass2(int i) {
            this.val$percent = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.aliyun.svideo.crop.AliyunImageCropActivity.this.mCropProgress.setProgress(this.val$percent);
        }
    }

    /* renamed from: com.aliyun.svideo.crop.AliyunImageCropActivity$3, reason: invalid class name */
    public class AnonymousClass3 implements java.lang.Runnable {
        final /* synthetic */ int val$code;

        public AnonymousClass3(int i) {
            this.val$code = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.aliyun.svideo.crop.AliyunImageCropActivity.this.mCropProgressBg.setVisibility(8);
            switch (this.val$code) {
                case -20004002:
                    com.aliyun.common.utils.ToastUtil.showToast(com.aliyun.svideo.crop.AliyunImageCropActivity.this, com.aliyun.svideo.crop.R.string.alivc_crop_video_tip_not_supported_audio);
                    break;
                case -20004001:
                    com.aliyun.common.utils.ToastUtil.showToast(com.aliyun.svideo.crop.AliyunImageCropActivity.this, com.aliyun.svideo.crop.R.string.alivc_crop_video_tip_not_supported_video);
                    break;
            }
            com.aliyun.svideo.crop.AliyunImageCropActivity aliyunImageCropActivity = com.aliyun.svideo.crop.AliyunImageCropActivity.this;
            aliyunImageCropActivity.setResult(0, aliyunImageCropActivity.getIntent());
        }
    }

    /* renamed from: com.aliyun.svideo.crop.AliyunImageCropActivity$4, reason: invalid class name */
    public class AnonymousClass4 implements java.lang.Runnable {

        /* renamed from: com.aliyun.svideo.crop.AliyunImageCropActivity$4$1, reason: invalid class name */
        public class AnonymousClass1 implements java.lang.Runnable {
            public AnonymousClass1() {
            }

            @Override // java.lang.Runnable
            public void run() {
                com.aliyun.svideo.common.utils.UriUtils.saveImgToMediaStore(com.aliyun.svideo.crop.AliyunImageCropActivity.this.getApplicationContext(), com.aliyun.svideo.crop.AliyunImageCropActivity.this.outputPath);
            }
        }

        public AnonymousClass4() {
        }

        @Override // java.lang.Runnable
        public void run() {
            com.aliyun.svideo.crop.AliyunImageCropActivity.this.mCropProgress.setVisibility(8);
            com.aliyun.svideo.crop.AliyunImageCropActivity.this.mCropProgressBg.setVisibility(8);
            if (android.os.Build.VERSION.SDK_INT >= 29) {
                com.aliyun.svideo.common.utils.ThreadUtils.runOnSubThread(new com.aliyun.svideo.crop.AliyunImageCropActivity.AnonymousClass4.AnonymousClass1());
            } else {
                com.aliyun.svideo.crop.AliyunImageCropActivity.this.scanFile();
            }
            com.aliyun.svideo.crop.bean.AlivcCropOutputParam alivcCropOutputParam = new com.aliyun.svideo.crop.bean.AlivcCropOutputParam();
            alivcCropOutputParam.setOutputPath(com.aliyun.svideo.crop.AliyunImageCropActivity.this.outputPath);
            com.aliyun.svideo.crop.AliyunImageCropActivity.this.onCropComplete(alivcCropOutputParam);
        }
    }

    /* renamed from: com.aliyun.svideo.crop.AliyunImageCropActivity$5, reason: invalid class name */
    public class AnonymousClass5 implements java.lang.Runnable {
        public AnonymousClass5() {
        }

        @Override // java.lang.Runnable
        public void run() {
            com.aliyun.svideo.crop.AliyunImageCropActivity.this.mCropProgressBg.setVisibility(8);
        }
    }

    public static class DeleteFileTask extends android.os.AsyncTask<java.lang.Void, java.lang.Void, java.lang.Void> {
        private java.lang.ref.WeakReference<com.aliyun.svideo.crop.AliyunImageCropActivity> weakReference;

        public DeleteFileTask(com.aliyun.svideo.crop.AliyunImageCropActivity aliyunImageCropActivity) {
            this.weakReference = new java.lang.ref.WeakReference<>(aliyunImageCropActivity);
        }

        @Override // android.os.AsyncTask
        public java.lang.Void doInBackground(java.lang.Void... voidArr) {
            com.aliyun.svideo.crop.AliyunImageCropActivity aliyunImageCropActivity;
            java.lang.ref.WeakReference<com.aliyun.svideo.crop.AliyunImageCropActivity> weakReference = this.weakReference;
            if (weakReference != null && (aliyunImageCropActivity = weakReference.get()) != null) {
                com.aliyun.common.utils.FileUtils.deleteFile(aliyunImageCropActivity.outputPath);
            }
            return null;
        }
    }

    private void deleteFile() {
        this.mDeleteTask = new com.aliyun.svideo.crop.AliyunImageCropActivity.DeleteFileTask(this).executeOnExecutor(android.os.AsyncTask.THREAD_POOL_EXECUTOR, new java.lang.Void[0]);
    }

    private void getData() {
        android.content.Intent intent = getIntent();
        java.lang.String stringExtra = intent.getStringExtra(com.aliyun.svideo.crop.bean.AlivcCropInputParam.INTENT_KEY_PATH);
        this.path = stringExtra;
        int lastIndexOf = stringExtra.lastIndexOf(".");
        this.mSuffix = lastIndexOf == -1 ? "" : this.path.substring(lastIndexOf);
        this.resolutionMode = intent.getIntExtra("mResolutionMode", 3);
        com.aliyun.svideosdk.common.struct.common.VideoDisplayMode videoDisplayMode = (com.aliyun.svideosdk.common.struct.common.VideoDisplayMode) intent.getSerializableExtra(com.aliyun.svideo.crop.bean.AlivcCropInputParam.INTENT_KEY_CROP_MODE);
        this.cropMode = videoDisplayMode;
        if (videoDisplayMode == null) {
            this.cropMode = com.aliyun.svideosdk.common.struct.common.VideoDisplayMode.SCALE;
        }
        com.aliyun.svideosdk.common.struct.common.VideoQuality videoQuality = (com.aliyun.svideosdk.common.struct.common.VideoQuality) intent.getSerializableExtra(com.aliyun.svideo.crop.bean.AlivcCropInputParam.INTENT_KEY_QUALITY);
        this.quality = videoQuality;
        if (videoQuality == null) {
            this.quality = com.aliyun.svideosdk.common.struct.common.VideoQuality.HD;
        }
        com.aliyun.svideosdk.common.struct.encoder.VideoCodecs videoCodecs = (com.aliyun.svideosdk.common.struct.encoder.VideoCodecs) intent.getSerializableExtra(com.aliyun.svideo.crop.bean.AlivcCropInputParam.INTENT_KEY_CODECS);
        this.mVideoCodecs = videoCodecs;
        if (videoCodecs == null) {
            this.mVideoCodecs = com.aliyun.svideosdk.common.struct.encoder.VideoCodecs.H264_HARDWARE;
        }
        this.gop = intent.getIntExtra("mGop", 250);
        this.frameRate = intent.getIntExtra(com.aliyun.svideo.crop.bean.AlivcCropInputParam.INTENT_KEY_FRAME_RATE, 30);
        this.ratioMode = intent.getIntExtra("mRatioMode", 2);
        com.aliyun.svideo.common.utils.BitmapUtils.checkAndAmendImgOrientation(this.path);
        android.graphics.BitmapFactory.Options options = new android.graphics.BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        android.graphics.BitmapFactory.decodeFile(this.path, options);
        this.mMimeType = options.outMimeType;
        this.mImageWidth = options.outWidth;
        this.mImageHeight = options.outHeight;
    }

    public static final java.lang.String getVersion() {
        return com.aliyun.common.global.Version.VERSION;
    }

    private void initView() {
        mOutStrokeWidth = com.aliyun.common.utils.DensityUtil.dip2px(this, 5.0f);
        android.widget.ImageView imageView = (android.widget.ImageView) findViewById(com.aliyun.svideo.crop.R.id.aliyun_transform);
        this.transFormBtn = imageView;
        imageView.setOnClickListener(this);
        android.widget.ImageView imageView2 = (android.widget.ImageView) findViewById(com.aliyun.svideo.crop.R.id.aliyun_next);
        this.nextBtn = imageView2;
        imageView2.setOnClickListener(this);
        android.widget.ImageView imageView3 = (android.widget.ImageView) findViewById(com.aliyun.svideo.crop.R.id.aliyun_back);
        this.cancelBtn = imageView3;
        imageView3.setOnClickListener(this);
        android.widget.FrameLayout frameLayout = (android.widget.FrameLayout) findViewById(com.aliyun.svideo.crop.R.id.aliyun_crop_progress_bg);
        this.mCropProgressBg = frameLayout;
        frameLayout.setVisibility(8);
        com.aliyun.svideo.base.widget.FanProgressBar fanProgressBar = (com.aliyun.svideo.base.widget.FanProgressBar) findViewById(com.aliyun.svideo.crop.R.id.aliyun_crop_progress);
        this.mCropProgress = fanProgressBar;
        fanProgressBar.setOutRadius((com.aliyun.common.utils.DensityUtil.dip2px(this, 40.0f) / 2) - (mOutStrokeWidth / 2));
        com.aliyun.svideo.base.widget.FanProgressBar fanProgressBar2 = this.mCropProgress;
        int i = mOutStrokeWidth;
        fanProgressBar2.setOffset(i / 2, i / 2);
        this.mCropProgress.setOutStrokeWidth(mOutStrokeWidth);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onCropComplete(com.aliyun.svideo.crop.bean.AlivcCropOutputParam alivcCropOutputParam) {
        android.content.Intent intent = getIntent();
        intent.putExtra(com.aliyun.svideo.crop.bean.AlivcCropOutputParam.RESULT_KEY_OUTPUT_PARAM, alivcCropOutputParam);
        setResult(-1, intent);
        finish();
    }

    private void resetScroll() {
        this.mScrollX = 0;
        this.mScrollY = 0;
    }

    private void resizeFrame() {
        android.widget.FrameLayout.LayoutParams layoutParams = (android.widget.FrameLayout.LayoutParams) this.frame.getLayoutParams();
        int i = this.ratioMode;
        if (i == 0) {
            int i2 = this.screenWidth;
            layoutParams.width = i2;
            layoutParams.height = (i2 * 4) / 3;
        } else if (i == 1) {
            int i3 = this.screenWidth;
            layoutParams.width = i3;
            layoutParams.height = i3;
        } else if (i != 2) {
            int i4 = this.screenWidth;
            layoutParams.width = i4;
            layoutParams.height = (i4 * 16) / 9;
        } else {
            int i5 = this.screenWidth;
            layoutParams.width = i5;
            layoutParams.height = (i5 * 16) / 9;
        }
        this.frame.setLayoutParams(layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void scaleCrop(int i, int i2) {
        android.widget.FrameLayout.LayoutParams layoutParams = (android.widget.FrameLayout.LayoutParams) this.mImageView.getLayoutParams();
        float max = java.lang.Math.max(i, i2) / java.lang.Math.min(i, i2);
        int i3 = this.ratioMode;
        float f = i3 != 0 ? i3 != 1 ? 1.7777778f : 1.0f : 1.3333334f;
        if (i3 == 3) {
            if (i >= i2) {
                int i4 = this.frameWidth;
                layoutParams.width = i4;
                layoutParams.height = (int) (i4 / max);
            } else if (max <= f) {
                int i5 = this.frameWidth;
                layoutParams.width = i5;
                layoutParams.height = (int) (i5 * max);
            } else {
                int i6 = this.frameHeight;
                layoutParams.height = i6;
                layoutParams.width = (int) (i6 / max);
            }
        } else if (i >= i2) {
            int i7 = this.frameHeight;
            layoutParams.height = i7;
            layoutParams.width = (int) (i7 * max);
        } else if (max <= f) {
            int i8 = this.frameHeight;
            layoutParams.height = i8;
            layoutParams.width = (int) (i8 / max);
        } else {
            int i9 = this.frameWidth;
            layoutParams.width = i9;
            layoutParams.height = (int) (i9 * max);
        }
        layoutParams.setMargins(0, 0, 0, 0);
        this.mImageView.setLayoutParams(layoutParams);
        this.cropMode = SCALE_CROP;
        this.transFormBtn.setActivated(false);
        resetScroll();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void scaleFill(int i, int i2) {
        android.widget.FrameLayout.LayoutParams layoutParams = (android.widget.FrameLayout.LayoutParams) this.mImageView.getLayoutParams();
        float max = java.lang.Math.max(i, i2) / java.lang.Math.min(i, i2);
        int i3 = this.ratioMode;
        float f = i3 != 0 ? i3 != 1 ? 1.7777778f : 1.0f : 1.3333334f;
        if (i >= i2) {
            int i4 = this.frameWidth;
            layoutParams.width = i4;
            layoutParams.height = (int) (i4 / max);
        } else if (max <= f) {
            int i5 = this.frameWidth;
            layoutParams.width = i5;
            layoutParams.height = (int) (i5 * max);
        } else {
            int i6 = this.frameHeight;
            layoutParams.height = i6;
            layoutParams.width = (int) (i6 / max);
        }
        layoutParams.setMargins(0, 0, 0, 0);
        this.mImageView.setLayoutParams(layoutParams);
        this.cropMode = SCALE_FILL;
        this.transFormBtn.setActivated(true);
        resetScroll();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void scanFile() {
        android.media.MediaScannerConnection.scanFile(getApplicationContext(), new java.lang.String[]{this.outputPath}, new java.lang.String[]{this.mMimeType}, null);
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
        if (this.frameWidth == 0 || this.frameHeight == 0) {
            com.aliyun.common.utils.ToastUtil.showToast(this, com.aliyun.svideo.crop.R.string.alivc_crop_video_tip_crop_failed);
            this.isCropping = false;
            return;
        }
        if (this.isCropping) {
            return;
        }
        this.outputPath = com.aliyun.svideo.base.Constants.SDCardConstants.getDir(this) + com.aliyun.svideo.common.utils.DateTimeUtils.getDateTimeFromMillisecond(java.lang.Long.valueOf(java.lang.System.currentTimeMillis())) + "-crop" + this.mSuffix;
        int i11 = this.mImageHeight;
        float f2 = ((float) i11) / ((float) this.mImageWidth);
        int i12 = this.ratioMode;
        if (i12 == 0) {
            f = 1.3333334f;
        } else if (i12 != 1) {
            f = 1.7777778f;
            if (i12 != 2 && i12 == 3) {
                f = f2;
            }
        } else {
            f = 1.0f;
        }
        int i13 = 540;
        if (f2 > f) {
            int measuredHeight = ((this.mImageView.getMeasuredHeight() - this.frameHeight) / 2) + this.mScrollY;
            int i14 = this.mImageWidth;
            int i15 = (measuredHeight * i14) / this.frameWidth;
            int i16 = this.resolutionMode;
            if (i16 == 0) {
                i13 = com.amap.api.maps.utils.SpatialRelationUtil.A_CIRCLE_DEGREE;
            } else if (i16 == 1) {
                i13 = com.autonavi.amap.mapcore.tools.GlMapUtil.DEVICE_DISPLAY_DPI_XHIGH;
            } else if (i16 != 2) {
                i13 = 720;
            }
            int i17 = this.ratioMode;
            if (i17 == 0) {
                i9 = (i14 * 4) / 3;
                i10 = (i13 * 4) / 3;
            } else if (i17 == 1) {
                i6 = i14;
                i3 = i6;
                i4 = i13;
                i7 = i15;
                i5 = 0;
            } else if (i17 != 2) {
                i9 = (i14 * 16) / 9;
                i10 = (i13 * 16) / 9;
            } else {
                i9 = (i14 * 16) / 9;
                i10 = (i13 * 16) / 9;
            }
            i4 = i10;
            i3 = i9;
            i6 = i14;
            i7 = i15;
            i5 = 0;
        } else {
            if (f2 < f) {
                int measuredWidth = ((this.mImageView.getMeasuredWidth() - this.frameWidth) / 2) + this.mScrollX;
                int i18 = this.mImageHeight;
                i5 = (measuredWidth * i18) / this.frameHeight;
                int i19 = this.resolutionMode;
                if (i19 == 0) {
                    i13 = com.amap.api.maps.utils.SpatialRelationUtil.A_CIRCLE_DEGREE;
                } else if (i19 == 1) {
                    i13 = com.autonavi.amap.mapcore.tools.GlMapUtil.DEVICE_DISPLAY_DPI_XHIGH;
                } else if (i19 != 2) {
                    i13 = 720;
                }
                int i20 = this.ratioMode;
                if (i20 == 0) {
                    i6 = (i18 * 3) / 4;
                    i8 = (i13 * 4) / 3;
                } else if (i20 == 1) {
                    i6 = i18;
                    i3 = i6;
                    i4 = i13;
                } else if (i20 != 2) {
                    i6 = (i18 * 9) / 16;
                    i8 = (i13 * 16) / 9;
                } else {
                    i6 = (i18 * 9) / 16;
                    i8 = (i13 * 16) / 9;
                }
                i4 = i8;
                i3 = i18;
            } else {
                int i21 = this.resolutionMode;
                if (i21 == 0) {
                    i13 = com.amap.api.maps.utils.SpatialRelationUtil.A_CIRCLE_DEGREE;
                } else if (i21 == 1) {
                    i13 = com.autonavi.amap.mapcore.tools.GlMapUtil.DEVICE_DISPLAY_DPI_XHIGH;
                } else if (i21 != 2) {
                    i13 = 720;
                }
                if (i12 != 0) {
                    if (i12 == 1) {
                        i6 = i11;
                        i3 = i6;
                        i4 = i13;
                    } else if (i12 == 2) {
                        i = (i11 * 9) / 16;
                        i2 = (i13 * 16) / 9;
                    } else if (i12 != 3) {
                        i = (i11 * 9) / 16;
                        i2 = (i13 * 16) / 9;
                    } else {
                        i6 = (int) (i11 / f2);
                        i3 = i11;
                        i4 = (int) (i13 * f2);
                    }
                    i5 = 0;
                } else {
                    i = (i11 * 3) / 4;
                    i2 = (i13 * 4) / 3;
                }
                i3 = i11;
                i4 = i2;
                i5 = 0;
                i6 = i;
            }
            i7 = 0;
        }
        com.aliyun.svideosdk.crop.CropParam cropParam = new com.aliyun.svideosdk.crop.CropParam();
        cropParam.setOutputPath(this.outputPath);
        cropParam.setInputPath(this.path);
        cropParam.setOutputWidth(i13);
        cropParam.setOutputHeight(i4);
        cropParam.setMediaType(com.aliyun.svideosdk.common.struct.common.MediaType.ANY_IMAGE_TYPE);
        cropParam.setCropRect(new android.graphics.Rect(i5, i7, i6 + i5, i3 + i7));
        cropParam.setScaleMode(this.cropMode);
        cropParam.setFrameRate(this.frameRate);
        cropParam.setGop(this.gop);
        cropParam.setQuality(this.quality);
        cropParam.setVideoCodec(this.mVideoCodecs);
        cropParam.setFillColor(androidx.core.view.ViewCompat.MEASURED_STATE_MASK);
        this.mCropProgressBg.setVisibility(0);
        this.crop.setCropParam(cropParam);
        this.isCropping = true;
        this.crop.startCrop();
    }

    public static void startImageCropForResult(android.app.Activity activity, com.aliyun.svideo.crop.bean.AlivcCropInputParam alivcCropInputParam, int i) {
        if (alivcCropInputParam == null || android.text.TextUtils.isEmpty(alivcCropInputParam.getPath())) {
            return;
        }
        android.content.Intent intent = new android.content.Intent(activity, (java.lang.Class<?>) com.aliyun.svideo.crop.AliyunImageCropActivity.class);
        intent.putExtra(com.aliyun.svideo.crop.bean.AlivcCropInputParam.INTENT_KEY_PATH, alivcCropInputParam.getPath());
        intent.putExtra("mResolutionMode", alivcCropInputParam.getResolutionMode());
        intent.putExtra(com.aliyun.svideo.crop.bean.AlivcCropInputParam.INTENT_KEY_CROP_MODE, alivcCropInputParam.getCropMode());
        intent.putExtra(com.aliyun.svideo.crop.bean.AlivcCropInputParam.INTENT_KEY_QUALITY, alivcCropInputParam.getQuality());
        intent.putExtra(com.aliyun.svideo.crop.bean.AlivcCropInputParam.INTENT_KEY_CODECS, alivcCropInputParam.getVideoCodecs());
        intent.putExtra("mGop", alivcCropInputParam.getGop());
        intent.putExtra("mRatioMode", alivcCropInputParam.getRatioMode());
        intent.putExtra(com.aliyun.svideo.crop.bean.AlivcCropInputParam.INTENT_KEY_ACTION, alivcCropInputParam.getAction());
        intent.putExtra(com.aliyun.svideo.crop.bean.AlivcCropInputParam.INTENT_KEY_MIN_DURATION, alivcCropInputParam.getMinCropDuration());
        intent.putExtra(com.aliyun.svideo.crop.bean.AlivcCropInputParam.INTENT_KEY_USE_GPU, alivcCropInputParam.isUseGPU());
        activity.startActivityForResult(intent, i);
    }

    public void initSurface() {
        com.aliyun.svideo.base.widget.VideoTrimFrameLayout videoTrimFrameLayout = (com.aliyun.svideo.base.widget.VideoTrimFrameLayout) findViewById(com.aliyun.svideo.crop.R.id.aliyun_video_surfaceLayout);
        this.frame = videoTrimFrameLayout;
        videoTrimFrameLayout.setOnSizeChangedListener(this);
        this.frame.setOnScrollCallBack(this);
        resizeFrame();
        this.mImageView = (android.widget.ImageView) findViewById(com.aliyun.svideo.crop.R.id.aliyun_image_view);
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
        runOnUiThread(new com.aliyun.svideo.crop.AliyunImageCropActivity.AnonymousClass5());
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
                scaleCrop(this.mImageWidth, this.mImageHeight);
            } else if (videoDisplayMode == SCALE_CROP) {
                scaleFill(this.mImageWidth, this.mImageHeight);
            }
        } else if (view == this.nextBtn) {
            startCrop();
        } else if (view == this.cancelBtn) {
            onBackPressed();
        }
        com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    @Override // com.aliyun.svideosdk.crop.CropCallback
    public void onComplete(long j) {
        runOnUiThread(new com.aliyun.svideo.crop.AliyunImageCropActivity.AnonymousClass4());
        this.isCropping = false;
    }

    @Override // android.app.Activity
    public void onCreate(@androidx.annotation.Nullable android.os.Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        getWindow().setFlags(1024, 1024);
        getWindow().addFlags(128);
        setContentView(com.aliyun.svideo.crop.R.layout.alivc_crop_activity_image_crop);
        this.screenWidth = getResources().getDisplayMetrics().widthPixels;
        com.aliyun.svideosdk.crop.AliyunICrop createCropInstance = com.aliyun.svideosdk.crop.impl.AliyunCropCreator.createCropInstance(this);
        this.crop = createCropInstance;
        createCropInstance.setCropCallback(this);
        getData();
        initView();
        initSurface();
        new com.aliyun.svideo.common.utils.image.ImageLoaderImpl().loadImage(this, org.apache.tools.ant.taskdefs.XSLTLiaison.FILE_PROTOCOL_PREFIX + this.path, new com.aliyun.svideo.common.utils.image.ImageLoaderOptions.Builder().skipDiskCacheCache().skipMemoryCache().build()).into(this.mImageView);
        this.frame.getViewTreeObserver().addOnGlobalLayoutListener(new com.aliyun.svideo.crop.AliyunImageCropActivity.AnonymousClass1());
    }

    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        com.aliyun.svideosdk.crop.AliyunICrop aliyunICrop = this.crop;
        if (aliyunICrop != null) {
            aliyunICrop.dispose();
            this.crop = null;
        }
        android.os.AsyncTask<java.lang.Void, java.lang.Void, java.lang.Void> asyncTask = this.mDeleteTask;
        if (asyncTask != null) {
            asyncTask.cancel(true);
            this.mDeleteTask = null;
        }
    }

    @Override // com.aliyun.svideosdk.crop.CropCallback
    public void onError(int i) {
        runOnUiThread(new com.aliyun.svideo.crop.AliyunImageCropActivity.AnonymousClass3(i));
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
        super.onPause();
    }

    @Override // com.aliyun.svideosdk.crop.CropCallback
    public void onProgress(int i) {
        runOnUiThread(new com.aliyun.svideo.crop.AliyunImageCropActivity.AnonymousClass2(i));
    }

    @Override // android.app.Activity
    public void onResume() {
        super.onResume();
    }

    @Override // com.aliyun.svideo.base.widget.HorizontalListView.OnScrollCallBack
    public void onScrollDistance(java.lang.Long l, int i) {
    }

    @Override // com.aliyun.svideo.base.widget.SizeChangedNotifier.Listener
    public void onSizeChanged(android.view.View view, int i, int i2, int i3, int i4) {
    }

    @Override // com.aliyun.svideo.base.widget.VideoTrimFrameLayout.OnVideoScrollCallBack
    public void onVideoScroll(float f, float f2) {
        android.widget.FrameLayout.LayoutParams layoutParams = (android.widget.FrameLayout.LayoutParams) this.mImageView.getLayoutParams();
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
        this.mImageView.setLayoutParams(layoutParams);
    }

    @Override // com.aliyun.svideo.base.widget.VideoTrimFrameLayout.OnVideoScrollCallBack
    public void onVideoSingleTapUp() {
    }
}
