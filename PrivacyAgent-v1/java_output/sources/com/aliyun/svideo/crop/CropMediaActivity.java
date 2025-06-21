package com.aliyun.svideo.crop;

/* loaded from: classes29.dex */
public class CropMediaActivity extends android.app.Activity {
    private static final int CROP_CODE = 3001;
    private static final java.lang.String RECORD_CLASS = "com.aliyun.svideo.recorder.activity.AlivcSvideoRecordActivity";
    private static final int RECORD_CODE = 3002;
    public static final java.lang.String RESULT_TYPE = "result_type";
    public static final int RESULT_TYPE_CROP = 4001;
    public static final int RESULT_TYPE_RECORD = 4002;
    private java.lang.String[] filterList;
    private int frameRate;
    private int gop;
    private com.aliyun.svideo.media.MutiMediaView mMutiMediaView;
    private int maxVideoDuration;
    private int minCropDuration;
    private int minVideoDuration;
    private int ratioMode;
    private int resolutionMode;
    private final java.lang.String TAG = "CropMediaActivity";
    private com.aliyun.svideosdk.common.struct.common.VideoDisplayMode cropMode = com.aliyun.svideosdk.common.struct.common.VideoDisplayMode.FILL;
    private com.aliyun.svideosdk.common.struct.common.VideoQuality quality = com.aliyun.svideosdk.common.struct.common.VideoQuality.SSD;
    private com.aliyun.svideosdk.common.struct.encoder.VideoCodecs mVideoCodec = com.aliyun.svideosdk.common.struct.encoder.VideoCodecs.H264_HARDWARE;
    private int recordMode = 2;
    private int beautyLevel = 80;
    private boolean beautyStatus = true;
    private com.aliyun.svideosdk.common.struct.recorder.CameraType cameraType = com.aliyun.svideosdk.common.struct.recorder.CameraType.FRONT;
    private com.aliyun.svideosdk.common.struct.recorder.FlashType flashType = com.aliyun.svideosdk.common.struct.recorder.FlashType.ON;
    private int maxDuration = 30000;
    private int minDuration = 2000;
    private boolean needClip = true;
    private int sortMode = 2;
    private java.lang.String mTempMediaFilePath = null;

    /* renamed from: com.aliyun.svideo.crop.CropMediaActivity$1, reason: invalid class name */
    public class AnonymousClass1 implements com.aliyun.svideo.media.MutiMediaView.OnMediaClickListener {

        /* renamed from: com.aliyun.svideo.crop.CropMediaActivity$1$1, reason: invalid class name and collision with other inner class name */
        public class RunnableC00561 implements java.lang.Runnable {
            final /* synthetic */ com.aliyun.svideo.media.MediaInfo val$tempInfo;

            /* renamed from: com.aliyun.svideo.crop.CropMediaActivity$1$1$1, reason: invalid class name and collision with other inner class name */
            public class RunnableC00571 implements java.lang.Runnable {
                final /* synthetic */ java.lang.String val$path;
                final /* synthetic */ boolean val$rs;

                public RunnableC00571(boolean z, java.lang.String str) {
                    this.val$rs = z;
                    this.val$path = str;
                }

                @Override // java.lang.Runnable
                public void run() {
                    if (!this.val$rs) {
                        com.aliyun.svideo.common.utils.ToastUtils.show(com.aliyun.svideo.crop.CropMediaActivity.this, "HEIF图片转化失败，请重试!");
                        return;
                    }
                    java.lang.StringBuilder sb = new java.lang.StringBuilder();
                    sb.append("HEIF file convert to ");
                    sb.append(this.val$path);
                    com.aliyun.svideo.crop.CropMediaActivity.this.mTempMediaFilePath = this.val$path;
                    com.aliyun.svideo.crop.AliyunImageCropActivity.startImageCropForResult(com.aliyun.svideo.crop.CropMediaActivity.this, new com.aliyun.svideo.crop.bean.AlivcCropInputParam.Builder().setPath(this.val$path).setResolutionMode(com.aliyun.svideo.crop.CropMediaActivity.this.resolutionMode).setCropMode(com.aliyun.svideo.crop.CropMediaActivity.this.cropMode).setQuality(com.aliyun.svideo.crop.CropMediaActivity.this.quality).setGop(com.aliyun.svideo.crop.CropMediaActivity.this.gop).setFrameRate(com.aliyun.svideo.crop.CropMediaActivity.this.frameRate).setRatioMode(com.aliyun.svideo.crop.CropMediaActivity.this.ratioMode).setMinCropDuration(com.aliyun.svideo.crop.CropMediaActivity.this.minCropDuration).setVideoCodecs(com.aliyun.svideo.crop.CropMediaActivity.this.mVideoCodec).build(), 3001);
                }
            }

            public RunnableC00561(com.aliyun.svideo.media.MediaInfo mediaInfo) {
                this.val$tempInfo = mediaInfo;
            }

            @Override // java.lang.Runnable
            public void run() {
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                sb.append(android.os.Environment.getExternalStorageDirectory().getPath());
                java.lang.String str = java.io.File.separator;
                sb.append(str);
                sb.append("DCIM");
                sb.append(str);
                sb.append("Camera");
                sb.append(str);
                sb.append("crop_temp_");
                sb.append(java.lang.System.currentTimeMillis());
                sb.append(".png");
                java.lang.String sb2 = sb.toString();
                com.aliyun.svideo.common.utils.ThreadUtils.runOnUiThread(new com.aliyun.svideo.crop.CropMediaActivity.AnonymousClass1.RunnableC00561.RunnableC00571(com.aliyun.svideosdk.common.utils.AliyunSVideoUtils.convertHEIFImage(this.val$tempInfo.filePath, sb2, android.graphics.Bitmap.CompressFormat.PNG, 100), sb2));
            }
        }

        public AnonymousClass1() {
        }

        @Override // com.aliyun.svideo.media.MutiMediaView.OnMediaClickListener
        public void onClick(com.aliyun.svideo.media.MediaInfo mediaInfo) {
            java.lang.Class<?> cls;
            android.graphics.Bitmap decodeFileDescriptor;
            if (com.aliyun.svideo.common.utils.FastClickUtil.isFastClickActivity(com.aliyun.svideo.crop.CropMediaActivity.class.getSimpleName())) {
                return;
            }
            if (mediaInfo == null) {
                try {
                    cls = java.lang.Class.forName(com.aliyun.svideo.crop.CropMediaActivity.RECORD_CLASS);
                } catch (java.lang.ClassNotFoundException unused) {
                    cls = null;
                }
                if (cls == null) {
                    return;
                }
                android.content.Intent intent = new android.content.Intent(com.aliyun.svideo.crop.CropMediaActivity.this, cls);
                intent.putExtra("video_resolution", com.aliyun.svideo.crop.CropMediaActivity.this.resolutionMode);
                intent.putExtra("video_ratio", com.aliyun.svideo.crop.CropMediaActivity.this.ratioMode);
                intent.putExtra(com.aliyun.svideosdk.common.struct.common.AliyunSnapVideoParam.RECORD_MODE, com.aliyun.svideo.crop.CropMediaActivity.this.recordMode);
                intent.putExtra(com.aliyun.svideosdk.common.struct.common.AliyunSnapVideoParam.FILTER_LIST, com.aliyun.svideo.crop.CropMediaActivity.this.filterList);
                intent.putExtra(com.aliyun.svideosdk.common.struct.common.AliyunSnapVideoParam.BEAUTY_LEVEL, com.aliyun.svideo.crop.CropMediaActivity.this.beautyLevel);
                intent.putExtra(com.aliyun.svideosdk.common.struct.common.AliyunSnapVideoParam.BEAUTY_STATUS, com.aliyun.svideo.crop.CropMediaActivity.this.beautyStatus);
                intent.putExtra(com.aliyun.svideosdk.common.struct.common.AliyunSnapVideoParam.CAMERA_TYPE, com.aliyun.svideo.crop.CropMediaActivity.this.cameraType);
                intent.putExtra(com.aliyun.svideosdk.common.struct.common.AliyunSnapVideoParam.FLASH_TYPE, com.aliyun.svideo.crop.CropMediaActivity.this.flashType);
                intent.putExtra(com.aliyun.svideosdk.common.struct.common.AliyunSnapVideoParam.NEED_CLIP, com.aliyun.svideo.crop.CropMediaActivity.this.needClip);
                intent.putExtra(com.aliyun.svideosdk.common.struct.common.AliyunSnapVideoParam.MAX_DURATION, com.aliyun.svideo.crop.CropMediaActivity.this.maxDuration);
                intent.putExtra(com.aliyun.svideosdk.common.struct.common.AliyunSnapVideoParam.MIN_DURATION, com.aliyun.svideo.crop.CropMediaActivity.this.minDuration);
                intent.putExtra("video_quality", com.aliyun.svideo.crop.CropMediaActivity.this.quality);
                intent.putExtra("video_gop", com.aliyun.svideo.crop.CropMediaActivity.this.gop);
                intent.putExtra(com.aliyun.svideosdk.common.struct.common.AliyunSnapVideoParam.VIDEO_CODEC, com.aliyun.svideo.crop.CropMediaActivity.this.mVideoCodec);
                intent.putExtra(com.aliyun.svideosdk.common.struct.common.AliyunSnapVideoParam.CROP_USE_GPU, com.aliyun.svideo.crop.CropMediaActivity.this.getIntent().getBooleanExtra(com.aliyun.svideosdk.common.struct.common.AliyunSnapVideoParam.CROP_USE_GPU, false));
                intent.putExtra("need_gallery", false);
                com.aliyun.svideo.crop.CropMediaActivity.this.startActivityForResult(intent, 3002);
                return;
            }
            java.lang.String str = mediaInfo.filePath;
            if (str.endsWith("gif")) {
                android.widget.Toast.makeText(com.aliyun.svideo.crop.CropMediaActivity.this, com.aliyun.svideo.crop.R.string.alivc_crop_media_gif_not_support, 0).show();
                return;
            }
            if (!mediaInfo.mimeType.startsWith("image")) {
                com.aliyun.svideo.crop.AliyunVideoCropActivity.startVideoCropForResult(com.aliyun.svideo.crop.CropMediaActivity.this, new com.aliyun.svideo.crop.bean.AlivcCropInputParam.Builder().setPath(str).setResolutionMode(com.aliyun.svideo.crop.CropMediaActivity.this.resolutionMode).setCropMode(com.aliyun.svideo.crop.CropMediaActivity.this.cropMode).setQuality(com.aliyun.svideo.crop.CropMediaActivity.this.quality).setGop(com.aliyun.svideo.crop.CropMediaActivity.this.gop).setFrameRate(com.aliyun.svideo.crop.CropMediaActivity.this.frameRate).setRatioMode(com.aliyun.svideo.crop.CropMediaActivity.this.ratioMode).setMinCropDuration(com.aliyun.svideo.crop.CropMediaActivity.this.minCropDuration).setVideoCodecs(com.aliyun.svideo.crop.CropMediaActivity.this.mVideoCodec).setAction(0).setUseGPU(com.aliyun.svideo.crop.CropMediaActivity.this.getIntent().getBooleanExtra(com.aliyun.svideosdk.common.struct.common.AliyunSnapVideoParam.CROP_USE_GPU, false)).build(), 3001);
                return;
            }
            if (com.aliyun.svideo.crop.CropMediaActivity.this.ratioMode == 3) {
                try {
                    android.os.ParcelFileDescriptor openFileDescriptor = com.aliyun.svideo.crop.CropMediaActivity.this.getContentResolver().openFileDescriptor(android.net.Uri.parse(mediaInfo.fileUri), "r");
                    if (openFileDescriptor != null && (decodeFileDescriptor = android.graphics.BitmapFactory.decodeFileDescriptor(openFileDescriptor.getFileDescriptor())) != null && (decodeFileDescriptor.getHeight() > 3840 || decodeFileDescriptor.getWidth() > 3840)) {
                        com.aliyun.svideo.common.utils.ToastUtils.show(com.aliyun.svideo.crop.CropMediaActivity.this, "原尺寸输出时，图片宽高不能超过3840");
                        return;
                    }
                } catch (java.io.FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
            if (!com.aliyun.svideosdk.common.utils.AliyunSVideoUtils.isHEIFImage(mediaInfo.filePath) || android.os.Build.VERSION.SDK_INT < 28) {
                com.aliyun.svideo.crop.AliyunImageCropActivity.startImageCropForResult(com.aliyun.svideo.crop.CropMediaActivity.this, new com.aliyun.svideo.crop.bean.AlivcCropInputParam.Builder().setPath(str).setResolutionMode(com.aliyun.svideo.crop.CropMediaActivity.this.resolutionMode).setCropMode(com.aliyun.svideo.crop.CropMediaActivity.this.cropMode).setQuality(com.aliyun.svideo.crop.CropMediaActivity.this.quality).setGop(com.aliyun.svideo.crop.CropMediaActivity.this.gop).setFrameRate(com.aliyun.svideo.crop.CropMediaActivity.this.frameRate).setRatioMode(com.aliyun.svideo.crop.CropMediaActivity.this.ratioMode).setMinCropDuration(com.aliyun.svideo.crop.CropMediaActivity.this.minCropDuration).setVideoCodecs(com.aliyun.svideo.crop.CropMediaActivity.this.mVideoCodec).build(), 3001);
                return;
            }
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("HEIF file ");
            sb.append(mediaInfo.filePath);
            com.aliyun.svideo.common.utils.ThreadUtils.runOnSubThread(new com.aliyun.svideo.crop.CropMediaActivity.AnonymousClass1.RunnableC00561(mediaInfo));
        }
    }

    /* renamed from: com.aliyun.svideo.crop.CropMediaActivity$2, reason: invalid class name */
    public class AnonymousClass2 implements com.aliyun.svideo.media.MutiMediaView.OnActionListener {
        public AnonymousClass2() {
        }

        @Override // com.aliyun.svideo.media.MutiMediaView.OnActionListener
        public void onBack() {
            com.aliyun.svideo.crop.CropMediaActivity.this.finish();
        }

        @Override // com.aliyun.svideo.media.MutiMediaView.OnActionListener
        public void onNext(boolean z) {
        }
    }

    private void getData() {
        this.resolutionMode = getIntent().getIntExtra("video_resolution", 3);
        this.cropMode = (com.aliyun.svideosdk.common.struct.common.VideoDisplayMode) getIntent().getSerializableExtra("crop_mode");
        this.frameRate = getIntent().getIntExtra("video_framerate", 30);
        this.gop = getIntent().getIntExtra("video_gop", 250);
        this.quality = (com.aliyun.svideosdk.common.struct.common.VideoQuality) getIntent().getSerializableExtra("video_quality");
        this.mVideoCodec = (com.aliyun.svideosdk.common.struct.encoder.VideoCodecs) getIntent().getSerializableExtra(com.aliyun.svideosdk.common.struct.common.AliyunSnapVideoParam.VIDEO_CODEC);
        this.ratioMode = getIntent().getIntExtra("video_ratio", 2);
        getIntent().getBooleanExtra(com.aliyun.svideosdk.common.struct.common.AliyunSnapVideoParam.NEED_RECORD, true);
        this.minVideoDuration = getIntent().getIntExtra(com.aliyun.svideosdk.common.struct.common.AliyunSnapVideoParam.MIN_VIDEO_DURATION, 2000);
        this.maxVideoDuration = getIntent().getIntExtra(com.aliyun.svideosdk.common.struct.common.AliyunSnapVideoParam.MAX_VIDEO_DURATION, 600000);
        this.minCropDuration = getIntent().getIntExtra(com.aliyun.svideosdk.common.struct.common.AliyunSnapVideoParam.MIN_CROP_DURATION, 2000);
        this.recordMode = getIntent().getIntExtra(com.aliyun.svideosdk.common.struct.common.AliyunSnapVideoParam.RECORD_MODE, 2);
        this.filterList = getIntent().getStringArrayExtra(com.aliyun.svideosdk.common.struct.common.AliyunSnapVideoParam.FILTER_LIST);
        this.beautyLevel = getIntent().getIntExtra(com.aliyun.svideosdk.common.struct.common.AliyunSnapVideoParam.BEAUTY_LEVEL, 80);
        this.beautyStatus = getIntent().getBooleanExtra(com.aliyun.svideosdk.common.struct.common.AliyunSnapVideoParam.BEAUTY_STATUS, true);
        com.aliyun.svideosdk.common.struct.recorder.CameraType cameraType = (com.aliyun.svideosdk.common.struct.recorder.CameraType) getIntent().getSerializableExtra(com.aliyun.svideosdk.common.struct.common.AliyunSnapVideoParam.CAMERA_TYPE);
        this.cameraType = cameraType;
        if (cameraType == null) {
            this.cameraType = com.aliyun.svideosdk.common.struct.recorder.CameraType.FRONT;
        }
        com.aliyun.svideosdk.common.struct.recorder.FlashType flashType = (com.aliyun.svideosdk.common.struct.recorder.FlashType) getIntent().getSerializableExtra(com.aliyun.svideosdk.common.struct.common.AliyunSnapVideoParam.FLASH_TYPE);
        this.flashType = flashType;
        if (flashType == null) {
            this.flashType = com.aliyun.svideosdk.common.struct.recorder.FlashType.ON;
        }
        this.minDuration = getIntent().getIntExtra(com.aliyun.svideosdk.common.struct.common.AliyunSnapVideoParam.MIN_DURATION, 2000);
        this.maxDuration = getIntent().getIntExtra(com.aliyun.svideosdk.common.struct.common.AliyunSnapVideoParam.MAX_DURATION, 30000);
        this.needClip = getIntent().getBooleanExtra(com.aliyun.svideosdk.common.struct.common.AliyunSnapVideoParam.NEED_CLIP, true);
        this.sortMode = getIntent().getIntExtra(com.aliyun.svideosdk.common.struct.common.AliyunSnapVideoParam.SORT_MODE, 2);
    }

    private void init() {
        com.aliyun.svideo.media.MutiMediaView mutiMediaView = (com.aliyun.svideo.media.MutiMediaView) findViewById(com.aliyun.svideo.crop.R.id.crop_mediaview);
        this.mMutiMediaView = mutiMediaView;
        mutiMediaView.setMediaSortMode(this.sortMode);
        this.mMutiMediaView.setVideoDurationRange(this.minVideoDuration, this.maxVideoDuration);
        this.mMutiMediaView.setOnMediaClickListener(new com.aliyun.svideo.crop.CropMediaActivity.AnonymousClass1());
        this.mMutiMediaView.setOnActionListener(new com.aliyun.svideo.crop.CropMediaActivity.AnonymousClass2());
        this.mMutiMediaView.loadMedia();
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

    @Override // android.app.Activity
    public void onActivityResult(int i, int i2, android.content.Intent intent) {
        if (i != 3001) {
            if (i == 3002) {
                if (i2 != -1) {
                    if (i2 == 0) {
                        setResult(0);
                        return;
                    }
                    return;
                } else {
                    if (intent != null) {
                        intent.putExtra(RESULT_TYPE, 4002);
                    }
                    setResult(-1, intent);
                    finish();
                    return;
                }
            }
            return;
        }
        if (!android.text.TextUtils.isEmpty(this.mTempMediaFilePath)) {
            boolean deleteFile = com.aliyun.common.utils.FileUtils.deleteFile(this.mTempMediaFilePath);
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("delete temp file ");
            sb.append(this.mTempMediaFilePath);
            sb.append(" | ");
            sb.append(deleteFile);
        }
        if (i2 != -1) {
            if (i2 == 0) {
                setResult(0);
            }
        } else {
            if (intent != null) {
                intent.putExtra(RESULT_TYPE, 4001);
            }
            setResult(-1, intent);
            finish();
        }
    }

    @Override // android.app.Activity
    public void onCreate(@androidx.annotation.Nullable android.os.Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        getWindow().addFlags(128);
        setContentView(com.aliyun.svideo.crop.R.layout.alivc_crop_activity_media);
        getData();
        init();
    }

    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.mMutiMediaView.onDestroy();
    }

    @Override // android.app.Activity
    @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
    public void onNewIntent(android.content.Intent intent) {
        super.onNewIntent(intent);
        com.sensorsdata.analytics.android.sdk.aop.push.PushAutoTrackHelper.onNewIntent(this, intent);
    }
}
