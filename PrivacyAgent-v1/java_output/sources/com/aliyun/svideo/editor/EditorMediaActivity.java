package com.aliyun.svideo.editor;

/* loaded from: classes29.dex */
public class EditorMediaActivity extends android.app.Activity {
    private static final java.lang.String BUNDLE_KEY_SAVE_MEDIAS = "bundle_key_save_transcoder";
    private static final int IMAGE_DURATION = 3000;
    private static final java.lang.String TAG = "EditorMediaActivity";
    private boolean isGetMedia = false;
    private java.util.ArrayList<com.aliyun.svideo.media.MediaInfo> mBundleSaveMedias;
    private int mCropPosition;
    private com.aliyun.svideo.media.MediaInfo mCurrMediaInfo;
    private com.aliyun.svideo.editor.bean.AlivcEditInputParam mInputParam;
    private com.aliyun.svideo.media.MutiMediaView mMutiMediaView;
    private boolean mNeedTranscode;
    private int mRatio;
    private com.aliyun.svideo.editor.Transcoder mTransCoder;
    private com.aliyun.svideo.base.widget.ProgressDialog progressDialog;

    /* renamed from: com.aliyun.svideo.editor.EditorMediaActivity$1, reason: invalid class name */
    public class AnonymousClass1 implements com.aliyun.svideo.editor.Transcoder.TransCallback {

        /* renamed from: com.aliyun.svideo.editor.EditorMediaActivity$1$1, reason: invalid class name and collision with other inner class name */
        public class RunnableC00581 implements java.lang.Runnable {
            final /* synthetic */ int val$errorCode;

            public RunnableC00581(int i) {
                this.val$errorCode = i;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (com.aliyun.svideo.editor.EditorMediaActivity.this.progressDialog != null) {
                    com.aliyun.svideo.editor.EditorMediaActivity.this.progressDialog.dismiss();
                }
                switch (this.val$errorCode) {
                    case -20004002:
                        com.aliyun.common.utils.ToastUtil.showToast(com.aliyun.svideo.editor.EditorMediaActivity.this, com.aliyun.svideo.editor.R.string.alivc_crop_video_tip_not_supported_audio);
                        break;
                    case -20004001:
                        com.aliyun.common.utils.ToastUtil.showToast(com.aliyun.svideo.editor.EditorMediaActivity.this, com.aliyun.svideo.editor.R.string.alivc_crop_video_tip_crop_failed);
                        break;
                    default:
                        com.aliyun.common.utils.ToastUtil.showToast(com.aliyun.svideo.editor.EditorMediaActivity.this, com.aliyun.svideo.editor.R.string.alivc_crop_video_tip_crop_failed);
                        break;
                }
            }
        }

        /* renamed from: com.aliyun.svideo.editor.EditorMediaActivity$1$2, reason: invalid class name */
        public class AnonymousClass2 implements java.lang.Runnable {
            public AnonymousClass2() {
            }

            @Override // java.lang.Runnable
            public void run() {
                com.aliyun.svideo.editor.EditorMediaActivity.this.mMutiMediaView.setNextEnable(true);
            }
        }

        public AnonymousClass1() {
        }

        @Override // com.aliyun.svideo.editor.Transcoder.TransCallback
        public void onCancelComplete() {
            com.aliyun.svideo.editor.EditorMediaActivity.this.runOnUiThread(new com.aliyun.svideo.editor.EditorMediaActivity.AnonymousClass1.AnonymousClass2());
        }

        @Override // com.aliyun.svideo.editor.Transcoder.TransCallback
        public void onComplete(java.util.List<com.aliyun.svideo.media.MediaInfo> list) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("ONCOMPLETED, dialog : ");
            sb.append(com.aliyun.svideo.editor.EditorMediaActivity.this.progressDialog == null);
            if (com.aliyun.svideo.editor.EditorMediaActivity.this.progressDialog != null) {
                com.aliyun.svideo.editor.EditorMediaActivity.this.progressDialog.dismiss();
            }
            com.aliyun.svideo.editor.EditorMediaActivity.this.mInputParam.setMediaInfos((java.util.ArrayList) list);
            com.aliyun.svideo.editor.EditorMediaActivity editorMediaActivity = com.aliyun.svideo.editor.EditorMediaActivity.this;
            com.aliyun.svideo.editor.editor.EditorActivity.startEdit(editorMediaActivity, editorMediaActivity.mInputParam, null);
        }

        @Override // com.aliyun.svideo.editor.Transcoder.TransCallback
        public void onError(java.lang.Throwable th, int i) {
            com.aliyun.svideo.editor.EditorMediaActivity.this.runOnUiThread(new com.aliyun.svideo.editor.EditorMediaActivity.AnonymousClass1.RunnableC00581(i));
        }

        @Override // com.aliyun.svideo.editor.Transcoder.TransCallback
        public void onProgress(int i) {
            if (com.aliyun.svideo.editor.EditorMediaActivity.this.progressDialog != null) {
                com.aliyun.svideo.editor.EditorMediaActivity.this.progressDialog.setProgress(i);
            }
        }
    }

    /* renamed from: com.aliyun.svideo.editor.EditorMediaActivity$2, reason: invalid class name */
    public class AnonymousClass2 implements com.aliyun.svideo.media.MutiMediaView.OnActionListener {
        public AnonymousClass2() {
        }

        @Override // com.aliyun.svideo.media.MutiMediaView.OnActionListener
        public void onBack() {
            com.aliyun.svideo.editor.EditorMediaActivity.this.finish();
        }

        @Override // com.aliyun.svideo.media.MutiMediaView.OnActionListener
        public void onNext(boolean z) {
            if (com.aliyun.svideo.common.utils.FastClickUtil.isFastClick()) {
                return;
            }
            if (com.aliyun.svideo.editor.EditorMediaActivity.this.isGetMedia) {
                com.aliyun.svideo.editor.EditorMediaActivity.this.mInputParam.setMediaInfos(com.aliyun.svideo.editor.EditorMediaActivity.this.mTransCoder.getOriginalVideos());
                android.content.Intent intent = new android.content.Intent(com.aliyun.svideo.editor.EditorMediaActivity.this, (java.lang.Class<?>) com.aliyun.svideo.editor.editor.EditorActivity.class);
                intent.putParcelableArrayListExtra(com.aliyun.svideo.editor.bean.AlivcEditInputParam.INTENT_KEY_MEDIA_INFO, com.aliyun.svideo.editor.EditorMediaActivity.this.mInputParam.getMediaInfos());
                com.aliyun.svideo.editor.EditorMediaActivity.this.setResult(100, intent);
                com.aliyun.svideo.editor.EditorMediaActivity.this.finish();
            }
            if (z) {
                com.aliyun.common.utils.ToastUtil.showToast(com.aliyun.svideo.editor.EditorMediaActivity.this, com.aliyun.svideo.editor.R.string.alivc_media_message_max_duration_import);
                return;
            }
            if (com.aliyun.svideo.editor.EditorMediaActivity.this.mTransCoder.getVideoCount() <= 0 || (com.aliyun.svideo.editor.EditorMediaActivity.this.progressDialog != null && com.aliyun.svideo.editor.EditorMediaActivity.this.progressDialog.isShowing())) {
                com.aliyun.common.utils.ToastUtil.showToast(com.aliyun.svideo.editor.EditorMediaActivity.this, com.aliyun.svideo.editor.R.string.alivc_media_please_select_video);
                return;
            }
            com.aliyun.svideo.editor.EditorMediaActivity editorMediaActivity = com.aliyun.svideo.editor.EditorMediaActivity.this;
            editorMediaActivity.progressDialog = com.aliyun.svideo.base.widget.ProgressDialog.show(editorMediaActivity, null, editorMediaActivity.getResources().getString(com.aliyun.svideo.editor.R.string.alivc_media_wait));
            com.aliyun.svideo.editor.EditorMediaActivity.this.progressDialog.setCancelable(true);
            com.aliyun.svideo.editor.EditorMediaActivity.this.progressDialog.setCanceledOnTouchOutside(false);
            com.aliyun.svideo.editor.EditorMediaActivity.this.progressDialog.setOnCancelListener(new com.aliyun.svideo.editor.EditorMediaActivity.OnCancelListener(com.aliyun.svideo.editor.EditorMediaActivity.this, null));
            com.aliyun.svideo.editor.EditorMediaActivity.this.mTransCoder.transcode(com.aliyun.svideo.editor.EditorMediaActivity.this.getApplicationContext(), com.aliyun.svideo.editor.EditorMediaActivity.this.mInputParam.getScaleMode(), com.aliyun.svideo.editor.EditorMediaActivity.this.mNeedTranscode);
        }
    }

    /* renamed from: com.aliyun.svideo.editor.EditorMediaActivity$3, reason: invalid class name */
    public class AnonymousClass3 implements com.aliyun.svideo.media.MutiMediaView.OnMediaClickListener {
        public AnonymousClass3() {
        }

        @Override // com.aliyun.svideo.media.MutiMediaView.OnMediaClickListener
        public void onClick(com.aliyun.svideo.media.MediaInfo mediaInfo) {
            android.graphics.Bitmap decodeFileDescriptor;
            if (!com.aliyun.svideo.editor.EditorMediaActivity.this.isGetMedia || com.aliyun.svideo.editor.EditorMediaActivity.this.mTransCoder.getVideoCount() <= 0) {
                java.lang.String unused = com.aliyun.svideo.editor.EditorMediaActivity.TAG;
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                sb.append("log_editor_video_path : ");
                sb.append(mediaInfo.filePath);
                com.aliyun.svideo.media.MediaInfo mediaInfo2 = new com.aliyun.svideo.media.MediaInfo();
                mediaInfo2.addTime = mediaInfo.addTime;
                mediaInfo2.mimeType = mediaInfo.mimeType;
                if (!mediaInfo.mimeType.startsWith("image")) {
                    mediaInfo2.duration = mediaInfo.duration;
                } else if (mediaInfo.filePath.endsWith("gif") || mediaInfo.filePath.endsWith("GIF")) {
                    com.aliyun.svideosdk.transcode.NativeParser nativeParser = new com.aliyun.svideosdk.transcode.NativeParser();
                    nativeParser.init(mediaInfo.filePath);
                    try {
                        if (java.lang.Integer.parseInt(nativeParser.getValue(4)) > 1) {
                            try {
                                int parseInt = java.lang.Integer.parseInt(nativeParser.getValue(3)) / 1000;
                                mediaInfo2.mimeType = "video";
                                mediaInfo2.duration = parseInt;
                            } catch (java.lang.Exception unused2) {
                                com.aliyun.svideo.common.utils.ToastUtils.show(com.aliyun.svideo.editor.EditorMediaActivity.this, com.aliyun.svideo.editor.R.string.alivc_editor_error_tip_play_video_error);
                                nativeParser.release();
                                nativeParser.dispose();
                                return;
                            }
                        } else {
                            mediaInfo2.duration = 3000;
                        }
                        nativeParser.release();
                        nativeParser.dispose();
                    } catch (java.lang.Exception unused3) {
                        com.aliyun.svideo.common.utils.ToastUtils.show(com.aliyun.svideo.editor.EditorMediaActivity.this, com.aliyun.svideo.editor.R.string.alivc_editor_error_tip_play_video_error);
                        nativeParser.release();
                        nativeParser.dispose();
                        return;
                    }
                } else {
                    if (com.aliyun.svideo.editor.EditorMediaActivity.this.mRatio == 3) {
                        try {
                            android.os.ParcelFileDescriptor openFileDescriptor = com.aliyun.svideo.editor.EditorMediaActivity.this.getContentResolver().openFileDescriptor(android.net.Uri.parse(mediaInfo.fileUri), "r");
                            if (openFileDescriptor != null && (decodeFileDescriptor = android.graphics.BitmapFactory.decodeFileDescriptor(openFileDescriptor.getFileDescriptor())) != null && (decodeFileDescriptor.getHeight() > 3840 || decodeFileDescriptor.getWidth() > 3840)) {
                                com.aliyun.svideo.common.utils.ToastUtils.show(com.aliyun.svideo.editor.EditorMediaActivity.this, "原尺寸输出时，图片宽高不能超过3840");
                                return;
                            }
                        } catch (java.io.FileNotFoundException e) {
                            e.printStackTrace();
                        }
                    }
                    mediaInfo2.duration = 3000;
                }
                mediaInfo2.filePath = mediaInfo.filePath;
                mediaInfo2.fileUri = mediaInfo.fileUri;
                mediaInfo2.id = mediaInfo.id;
                mediaInfo2.isSquare = mediaInfo.isSquare;
                mediaInfo2.thumbnailPath = mediaInfo.thumbnailPath;
                mediaInfo2.thumbnailUri = mediaInfo.thumbnailUri;
                mediaInfo2.title = mediaInfo.title;
                mediaInfo2.type = mediaInfo.type;
                com.aliyun.svideo.editor.EditorMediaActivity.this.mMutiMediaView.addSelectMedia(mediaInfo2);
                com.aliyun.svideo.editor.EditorMediaActivity.this.mMutiMediaView.setNextEnable(true);
                com.aliyun.svideo.editor.EditorMediaActivity.this.mTransCoder.addMedia(mediaInfo2);
            }
        }
    }

    /* renamed from: com.aliyun.svideo.editor.EditorMediaActivity$4, reason: invalid class name */
    public class AnonymousClass4 implements com.aliyun.svideo.media.MutiMediaView.OnSelectMediaChangeListener {
        public AnonymousClass4() {
        }

        @Override // com.aliyun.svideo.media.MutiMediaView.OnSelectMediaChangeListener
        public void onClick(com.aliyun.svideo.media.MediaInfo mediaInfo, int i) {
            if (com.aliyun.svideo.common.utils.FastClickUtil.isFastClickActivity(com.aliyun.svideo.editor.EditorMediaActivity.class.getSimpleName())) {
                return;
            }
            com.aliyun.svideo.editor.EditorMediaActivity.this.mCurrMediaInfo = mediaInfo;
            com.aliyun.svideo.editor.EditorMediaActivity.this.mCropPosition = i;
            if (mediaInfo.filePath.endsWith("gif") || mediaInfo.filePath.endsWith("GIF")) {
                android.widget.Toast.makeText(com.aliyun.svideo.editor.EditorMediaActivity.this, com.aliyun.svideo.editor.R.string.alivc_crop_media_gif_not_support, 0).show();
                return;
            }
            com.aliyun.svideo.crop.bean.AlivcCropInputParam build = new com.aliyun.svideo.crop.bean.AlivcCropInputParam.Builder().setRatioMode(com.aliyun.svideo.editor.EditorMediaActivity.this.mInputParam.getRatio()).setResolutionMode(com.aliyun.svideo.editor.EditorMediaActivity.this.mInputParam.getResolutionMode()).setCropMode(com.aliyun.svideo.editor.EditorMediaActivity.this.mInputParam.getScaleMode()).setFrameRate(com.aliyun.svideo.editor.EditorMediaActivity.this.mInputParam.getFrameRate()).setGop(com.aliyun.svideo.editor.EditorMediaActivity.this.mInputParam.getGop()).setQuality(com.aliyun.svideo.editor.EditorMediaActivity.this.mInputParam.getVideoQuality()).setVideoCodecs(com.aliyun.svideo.editor.EditorMediaActivity.this.mInputParam.getVideoCodec()).setAction(1).build();
            if (mediaInfo.mimeType.startsWith("video")) {
                build.setPath(mediaInfo.filePath);
                com.aliyun.svideo.crop.AliyunVideoCropActivity.startVideoCropForResult(com.aliyun.svideo.editor.EditorMediaActivity.this, build, 1);
            } else if (mediaInfo.mimeType.startsWith("image")) {
                build.setPath(mediaInfo.filePath);
                com.aliyun.svideo.crop.AliyunImageCropActivity.startImageCropForResult(com.aliyun.svideo.editor.EditorMediaActivity.this, build, 2);
            }
        }

        @Override // com.aliyun.svideo.media.MutiMediaView.OnSelectMediaChangeListener
        public void onRemove(com.aliyun.svideo.media.MediaInfo mediaInfo) {
            com.aliyun.svideo.editor.EditorMediaActivity.this.mTransCoder.removeMedia(mediaInfo);
        }

        @Override // com.aliyun.svideo.media.MutiMediaView.OnSelectMediaChangeListener
        public void onSwap(androidx.recyclerview.widget.RecyclerView recyclerView, androidx.recyclerview.widget.RecyclerView.ViewHolder viewHolder, androidx.recyclerview.widget.RecyclerView.ViewHolder viewHolder2) {
            com.aliyun.svideo.editor.EditorMediaActivity.this.mTransCoder.swap(viewHolder.getAdapterPosition(), viewHolder2.getAdapterPosition());
        }
    }

    public static class OnCancelListener implements android.content.DialogInterface.OnCancelListener {
        private java.lang.ref.WeakReference<com.aliyun.svideo.editor.EditorMediaActivity> weakReference;

        private OnCancelListener(com.aliyun.svideo.editor.EditorMediaActivity editorMediaActivity) {
            this.weakReference = new java.lang.ref.WeakReference<>(editorMediaActivity);
        }

        public /* synthetic */ OnCancelListener(com.aliyun.svideo.editor.EditorMediaActivity editorMediaActivity, defpackage.o90 o90Var) {
            this(editorMediaActivity);
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(android.content.DialogInterface dialogInterface) {
            com.aliyun.svideo.editor.EditorMediaActivity editorMediaActivity = this.weakReference.get();
            if (editorMediaActivity != null) {
                editorMediaActivity.mMutiMediaView.setNextEnable(false);
                editorMediaActivity.mTransCoder.cancel();
            }
        }
    }

    private void init() {
        com.aliyun.svideo.media.MutiMediaView mutiMediaView = (com.aliyun.svideo.media.MutiMediaView) findViewById(com.aliyun.svideo.editor.R.id.media_view);
        this.mMutiMediaView = mutiMediaView;
        mutiMediaView.enableSelectView(300000L);
        this.mMutiMediaView.enableSwap();
        com.aliyun.svideo.editor.Transcoder transcoder = new com.aliyun.svideo.editor.Transcoder();
        this.mTransCoder = transcoder;
        transcoder.init(this);
        this.mTransCoder.setTransCallback(new com.aliyun.svideo.editor.EditorMediaActivity.AnonymousClass1());
        this.mMutiMediaView.setOnActionListener(new com.aliyun.svideo.editor.EditorMediaActivity.AnonymousClass2());
        this.mMutiMediaView.setOnMediaClickListener(new com.aliyun.svideo.editor.EditorMediaActivity.AnonymousClass3());
        this.mMutiMediaView.setOnSelectMediaChangeListener(new com.aliyun.svideo.editor.EditorMediaActivity.AnonymousClass4());
        this.mMutiMediaView.loadMedia();
    }

    private void initData() {
        android.content.Intent intent = getIntent();
        int intExtra = intent.getIntExtra(com.aliyun.svideo.editor.bean.AlivcEditInputParam.INTENT_KEY_FRAME, 30);
        int intExtra2 = intent.getIntExtra("mGop", 250);
        this.mRatio = intent.getIntExtra("mRatioMode", 2);
        com.aliyun.svideosdk.common.struct.common.VideoQuality videoQuality = (com.aliyun.svideosdk.common.struct.common.VideoQuality) intent.getSerializableExtra(com.aliyun.svideo.editor.bean.AlivcEditInputParam.INTENT_KEY_QUALITY);
        if (videoQuality == null) {
            videoQuality = com.aliyun.svideosdk.common.struct.common.VideoQuality.HD;
        }
        int intExtra3 = intent.getIntExtra("mResolutionMode", 3);
        com.aliyun.svideosdk.common.struct.encoder.VideoCodecs videoCodecs = (com.aliyun.svideosdk.common.struct.encoder.VideoCodecs) intent.getSerializableExtra(com.aliyun.svideo.editor.bean.AlivcEditInputParam.INTENT_KEY_CODEC);
        if (videoCodecs == null) {
            videoCodecs = com.aliyun.svideosdk.common.struct.encoder.VideoCodecs.H264_HARDWARE;
        }
        int intExtra4 = intent.getIntExtra(com.aliyun.svideo.editor.bean.AlivcEditInputParam.INTETN_KEY_CRF, 23);
        float floatExtra = intent.getFloatExtra(com.aliyun.svideo.editor.bean.AlivcEditInputParam.INTETN_KEY_SCANLE_RATE, 1.0f);
        com.aliyun.svideosdk.common.struct.common.VideoDisplayMode videoDisplayMode = (com.aliyun.svideosdk.common.struct.common.VideoDisplayMode) intent.getSerializableExtra(com.aliyun.svideo.editor.bean.AlivcEditInputParam.INTETN_KEY_SCANLE_MODE);
        if (videoDisplayMode == null) {
            videoDisplayMode = com.aliyun.svideosdk.common.struct.common.VideoDisplayMode.FILL;
        }
        boolean booleanExtra = intent.getBooleanExtra(com.aliyun.svideo.editor.bean.AlivcEditInputParam.INTENT_KEY_TAIL_ANIMATION, false);
        boolean booleanExtra2 = intent.getBooleanExtra(com.aliyun.svideo.editor.bean.AlivcEditInputParam.INTENT_KEY_DE_NOISE, false);
        boolean booleanExtra3 = intent.getBooleanExtra(com.aliyun.svideo.editor.bean.AlivcEditInputParam.INTENT_KEY_REPLACE_MUSIC, true);
        java.util.ArrayList parcelableArrayListExtra = intent.getParcelableArrayListExtra(com.aliyun.svideo.editor.bean.AlivcEditInputParam.INTENT_KEY_MEDIA_INFO);
        boolean booleanExtra4 = intent.getBooleanExtra(com.aliyun.svideo.editor.bean.AlivcEditInputParam.INTENT_KEY_WATER_MARK, false);
        this.mNeedTranscode = intent.getBooleanExtra(com.aliyun.svideo.editor.bean.AlivcEditInputParam.INTENT_KEY_NEED_TRANSCODE, false);
        boolean booleanExtra5 = intent.getBooleanExtra(com.aliyun.svideo.editor.bean.AlivcEditInputParam.INTENT_KEY_HORIZONTAL_FLIP, false);
        boolean booleanExtra6 = intent.getBooleanExtra(com.aliyun.svideo.editor.bean.AlivcEditInputParam.INTENT_KEY_GET_MEDIA, false);
        this.isGetMedia = booleanExtra6;
        if (booleanExtra6) {
            this.mInputParam = new com.aliyun.svideo.editor.bean.AlivcEditInputParam.Builder().build();
        } else {
            this.mInputParam = new com.aliyun.svideo.editor.bean.AlivcEditInputParam.Builder().setFrameRate(intExtra).setGop(intExtra2).setRatio(this.mRatio).setVideoQuality(videoQuality).setResolutionMode(intExtra3).setVideoCodec(videoCodecs).setCrf(intExtra4).setScaleRate(floatExtra).setScaleMode(videoDisplayMode).setHasTailAnimation(booleanExtra).setCanReplaceMusic(booleanExtra3).addMediaInfos(parcelableArrayListExtra).setDeNoise(booleanExtra2).setHasWaterMark(booleanExtra4).setHorizontalFlip(booleanExtra5).build();
        }
    }

    public static void selectMediaOnResult(android.app.Activity activity, int i) {
        android.content.Intent intent = new android.content.Intent(activity, (java.lang.Class<?>) com.aliyun.svideo.editor.EditorMediaActivity.class);
        com.aliyun.svideo.editor.bean.AlivcEditInputParam build = new com.aliyun.svideo.editor.bean.AlivcEditInputParam.Builder().build();
        intent.putExtra(com.aliyun.svideo.editor.bean.AlivcEditInputParam.INTENT_KEY_FRAME, build.getFrameRate());
        intent.putExtra("mGop", build.getGop());
        intent.putExtra("mRatioMode", build.getRatio());
        intent.putExtra(com.aliyun.svideo.editor.bean.AlivcEditInputParam.INTENT_KEY_QUALITY, build.getVideoQuality());
        intent.putExtra("mResolutionMode", build.getResolutionMode());
        intent.putExtra(com.aliyun.svideo.editor.bean.AlivcEditInputParam.INTENT_KEY_CODEC, build.getVideoCodec());
        intent.putExtra(com.aliyun.svideo.editor.bean.AlivcEditInputParam.INTETN_KEY_CRF, build.getCrf());
        intent.putExtra(com.aliyun.svideo.editor.bean.AlivcEditInputParam.INTETN_KEY_SCANLE_RATE, build.getScaleRate());
        intent.putExtra(com.aliyun.svideo.editor.bean.AlivcEditInputParam.INTETN_KEY_SCANLE_MODE, build.getScaleMode());
        intent.putExtra(com.aliyun.svideo.editor.bean.AlivcEditInputParam.INTENT_KEY_TAIL_ANIMATION, build.isHasTailAnimation());
        intent.putExtra(com.aliyun.svideo.editor.bean.AlivcEditInputParam.INTENT_KEY_REPLACE_MUSIC, build.isCanReplaceMusic());
        intent.putExtra(com.aliyun.svideo.editor.bean.AlivcEditInputParam.INTENT_KEY_WATER_MARK, build.isHasWaterMark());
        intent.putExtra(com.aliyun.svideo.editor.bean.AlivcEditInputParam.INTENT_KEY_HORIZONTAL_FLIP, build.isHorizontalFlip());
        intent.putExtra(com.aliyun.svideo.editor.bean.AlivcEditInputParam.INTENT_KEY_DE_NOISE, build.getDeNoise());
        intent.putExtra(com.aliyun.svideo.editor.bean.AlivcEditInputParam.INTENT_KEY_NEED_TRANSCODE, build.isNeedTrancode());
        intent.putParcelableArrayListExtra(com.aliyun.svideo.editor.bean.AlivcEditInputParam.INTENT_KEY_MEDIA_INFO, build.getMediaInfos());
        intent.putExtra(com.aliyun.svideo.editor.bean.AlivcEditInputParam.INTENT_KEY_GET_MEDIA, true);
        activity.startActivityForResult(intent, i);
    }

    public static void startImport(android.content.Context context, com.aliyun.svideo.editor.bean.AlivcEditInputParam alivcEditInputParam) {
        if (alivcEditInputParam == null) {
            return;
        }
        android.content.Intent intent = new android.content.Intent(context, (java.lang.Class<?>) com.aliyun.svideo.editor.EditorMediaActivity.class);
        intent.putExtra(com.aliyun.svideo.editor.bean.AlivcEditInputParam.INTENT_KEY_FRAME, alivcEditInputParam.getFrameRate());
        intent.putExtra("mGop", alivcEditInputParam.getGop());
        intent.putExtra("mRatioMode", alivcEditInputParam.getRatio());
        intent.putExtra(com.aliyun.svideo.editor.bean.AlivcEditInputParam.INTENT_KEY_QUALITY, alivcEditInputParam.getVideoQuality());
        intent.putExtra("mResolutionMode", alivcEditInputParam.getResolutionMode());
        intent.putExtra(com.aliyun.svideo.editor.bean.AlivcEditInputParam.INTENT_KEY_CODEC, alivcEditInputParam.getVideoCodec());
        intent.putExtra(com.aliyun.svideo.editor.bean.AlivcEditInputParam.INTETN_KEY_CRF, alivcEditInputParam.getCrf());
        intent.putExtra(com.aliyun.svideo.editor.bean.AlivcEditInputParam.INTETN_KEY_SCANLE_RATE, alivcEditInputParam.getScaleRate());
        intent.putExtra(com.aliyun.svideo.editor.bean.AlivcEditInputParam.INTETN_KEY_SCANLE_MODE, alivcEditInputParam.getScaleMode());
        intent.putExtra(com.aliyun.svideo.editor.bean.AlivcEditInputParam.INTENT_KEY_TAIL_ANIMATION, alivcEditInputParam.isHasTailAnimation());
        intent.putExtra(com.aliyun.svideo.editor.bean.AlivcEditInputParam.INTENT_KEY_REPLACE_MUSIC, alivcEditInputParam.isCanReplaceMusic());
        intent.putExtra(com.aliyun.svideo.editor.bean.AlivcEditInputParam.INTENT_KEY_WATER_MARK, alivcEditInputParam.isHasWaterMark());
        intent.putExtra(com.aliyun.svideo.editor.bean.AlivcEditInputParam.INTENT_KEY_HORIZONTAL_FLIP, alivcEditInputParam.isHorizontalFlip());
        intent.putExtra(com.aliyun.svideo.editor.bean.AlivcEditInputParam.INTENT_KEY_DE_NOISE, alivcEditInputParam.getDeNoise());
        intent.putExtra(com.aliyun.svideo.editor.bean.AlivcEditInputParam.INTENT_KEY_NEED_TRANSCODE, alivcEditInputParam.isNeedTrancode());
        intent.putParcelableArrayListExtra(com.aliyun.svideo.editor.bean.AlivcEditInputParam.INTENT_KEY_MEDIA_INFO, alivcEditInputParam.getMediaInfos());
        context.startActivity(intent);
    }

    @Override // android.app.Activity
    public void onActivityResult(int i, int i2, android.content.Intent intent) {
        com.aliyun.svideo.crop.bean.AlivcCropOutputParam alivcCropOutputParam;
        com.aliyun.svideo.media.MediaInfo mediaInfo;
        super.onActivityResult(i, i2, intent);
        if (i2 != -1 || (alivcCropOutputParam = (com.aliyun.svideo.crop.bean.AlivcCropOutputParam) intent.getSerializableExtra(com.aliyun.svideo.crop.bean.AlivcCropOutputParam.RESULT_KEY_OUTPUT_PARAM)) == null) {
            return;
        }
        java.lang.String outputPath = alivcCropOutputParam.getOutputPath();
        if (i != 1) {
            if (i != 2 || android.text.TextUtils.isEmpty(outputPath) || (mediaInfo = this.mCurrMediaInfo) == null) {
                return;
            }
            int removeMedia = this.mTransCoder.removeMedia(mediaInfo);
            com.aliyun.svideo.media.MediaInfo mediaInfo2 = this.mCurrMediaInfo;
            mediaInfo2.filePath = outputPath;
            this.mTransCoder.addMedia(removeMedia, mediaInfo2);
            return;
        }
        long duration = alivcCropOutputParam.getDuration();
        long startTime = alivcCropOutputParam.getStartTime();
        if (android.text.TextUtils.isEmpty(outputPath) || duration <= 0 || this.mCurrMediaInfo == null) {
            return;
        }
        this.mMutiMediaView.changeDurationPosition(this.mCropPosition, duration);
        int removeMedia2 = this.mTransCoder.removeMedia(this.mCurrMediaInfo);
        com.aliyun.svideo.media.MediaInfo mediaInfo3 = this.mCurrMediaInfo;
        mediaInfo3.filePath = outputPath;
        mediaInfo3.startTime = startTime;
        mediaInfo3.duration = (int) duration;
        this.mTransCoder.addMedia(removeMedia2, mediaInfo3);
    }

    @Override // android.app.Activity
    public void onCreate(@androidx.annotation.Nullable android.os.Bundle bundle) {
        super.onCreate(bundle);
        setContentView(com.aliyun.svideo.editor.R.layout.alivc_editor_media);
        initData();
        init();
    }

    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.mMutiMediaView.onDestroy();
        this.mTransCoder.release();
    }

    @Override // android.app.Activity
    @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
    public void onNewIntent(android.content.Intent intent) {
        super.onNewIntent(intent);
        com.sensorsdata.analytics.android.sdk.aop.push.PushAutoTrackHelper.onNewIntent(this, intent);
    }

    @Override // android.app.Activity
    public void onRestoreInstanceState(android.os.Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        java.util.ArrayList<com.aliyun.svideo.media.MediaInfo> parcelableArrayList = bundle.getParcelableArrayList(BUNDLE_KEY_SAVE_MEDIAS);
        if (parcelableArrayList == null || parcelableArrayList.size() == 0) {
            return;
        }
        this.mBundleSaveMedias = parcelableArrayList;
    }

    @Override // android.app.Activity
    public void onResume() {
        super.onResume();
        java.util.ArrayList<com.aliyun.svideo.media.MediaInfo> arrayList = this.mBundleSaveMedias;
        if (arrayList != null) {
            java.util.Iterator<com.aliyun.svideo.media.MediaInfo> it = arrayList.iterator();
            while (it.hasNext()) {
                com.aliyun.svideo.media.MediaInfo next = it.next();
                this.mMutiMediaView.addSelectMedia(next);
                this.mTransCoder.addMedia(next);
            }
        }
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(android.os.Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putParcelableArrayList(BUNDLE_KEY_SAVE_MEDIAS, this.mTransCoder.getOriginalVideos());
    }

    @Override // android.app.Activity
    public void onStop() {
        super.onStop();
        this.mBundleSaveMedias = null;
    }
}
