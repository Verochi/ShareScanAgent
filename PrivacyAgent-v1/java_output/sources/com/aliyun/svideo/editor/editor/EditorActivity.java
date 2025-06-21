package com.aliyun.svideo.editor.editor;

/* loaded from: classes29.dex */
public class EditorActivity extends androidx.fragment.app.FragmentActivity {
    public static final java.lang.String EXTRA_DATA_SOURCE_TYPE = "extra_data_source_type";
    public static final java.lang.String NEXT_ACTIVITY_CLASS_NAME = "com.aliyun.svideo.editor.publish.PublishActivity";
    private static final java.lang.String TAG = "EditorActivity";
    private com.aliyun.svideo.editor.view.AlivcEditView editView;
    private com.aliyun.svideosdk.editor.AliyunIVodCompose mCompose;
    private com.aliyun.svideo.editor.bean.AlivcEditInputParam mInputParam;
    private com.moji.dialog.MJDialog mProgressDialog;
    private com.aliyun.svideosdk.common.struct.common.AliyunVideoParam mVideoParam;
    private android.widget.TextView tvProgress;
    private java.lang.String orientation = "";
    private com.moji.base.enums.VideoSourceType mSourceType = com.moji.base.enums.VideoSourceType.OTHER;
    private java.lang.String mOutputPath = "";
    private int mOutputVideoWidth = 0;
    private int mOutputVideoHeight = 0;
    private final com.aliyun.svideosdk.editor.AliyunIComposeCallBack mCallback = new com.aliyun.svideo.editor.editor.EditorActivity.AnonymousClass3();

    /* renamed from: com.aliyun.svideo.editor.editor.EditorActivity$1, reason: invalid class name */
    public class AnonymousClass1 implements android.view.View.OnClickListener {
        public AnonymousClass1() {
        }

        @Override // android.view.View.OnClickListener
        @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
        public void onClick(android.view.View view) {
            if (com.moji.tool.Utils.canClick()) {
                com.aliyun.svideo.editor.editor.EditorActivity.this.showExitDialog();
            }
            com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    /* renamed from: com.aliyun.svideo.editor.editor.EditorActivity$2, reason: invalid class name */
    public class AnonymousClass2 implements com.aliyun.svideo.editor.view.AlivcEditView.OnFinishListener {
        public AnonymousClass2() {
        }

        @Override // com.aliyun.svideo.editor.view.AlivcEditView.OnFinishListener
        public void onComplete(com.aliyun.svideo.editor.bean.AlivcEditOutputParam alivcEditOutputParam) {
            java.lang.String eventValue = com.aliyun.svideo.editor.editor.EditorActivity.this.getEventValue();
            com.moji.statistics.EventManager.getInstance().notifEvent(com.moji.statistics.EVENT_TAG2.MAIN_SHORTVIDEO_EDIT_NEXT_CK, eventValue);
            com.moji.statistics.EVENT_TAG_SENSORS event_tag_sensors = com.moji.statistics.EVENT_TAG_SENSORS.MAIN_SHORTVIDEO_EDIT_NEXT_CK;
            com.moji.statistics.EventManager.getInstance().notifEvent(event_tag_sensors, new com.moji.tool.SensorParams.Builder(event_tag_sensors.name()).setValue(eventValue).setEventValue(com.aliyun.svideo.editor.editor.EditorActivity.this.mSourceType.getDesc()).build());
            if (alivcEditOutputParam == null || android.text.TextUtils.isEmpty(alivcEditOutputParam.getConfigPath())) {
                return;
            }
            com.aliyun.svideo.editor.editor.EditorActivity.this.composeVideo(alivcEditOutputParam.getConfigPath());
            com.aliyun.svideo.editor.editor.EditorActivity.this.mOutputVideoWidth = alivcEditOutputParam.getOutputVideoWidth();
            com.aliyun.svideo.editor.editor.EditorActivity.this.mOutputVideoHeight = alivcEditOutputParam.getOutputVideoHeight();
        }
    }

    /* renamed from: com.aliyun.svideo.editor.editor.EditorActivity$3, reason: invalid class name */
    public class AnonymousClass3 implements com.aliyun.svideosdk.editor.AliyunIComposeCallBack {

        /* renamed from: com.aliyun.svideo.editor.editor.EditorActivity$3$1, reason: invalid class name */
        public class AnonymousClass1 implements java.lang.Runnable {
            public AnonymousClass1() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (com.aliyun.svideo.editor.editor.EditorActivity.this.mProgressDialog == null || !com.aliyun.svideo.editor.editor.EditorActivity.this.mProgressDialog.isShowing()) {
                    return;
                }
                com.aliyun.svideo.editor.editor.EditorActivity.this.mProgressDialog.dismiss();
            }
        }

        /* renamed from: com.aliyun.svideo.editor.editor.EditorActivity$3$2, reason: invalid class name */
        public class AnonymousClass2 implements java.lang.Runnable {
            final /* synthetic */ int val$progress;

            public AnonymousClass2(int i) {
                this.val$progress = i;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (!com.aliyun.svideo.editor.editor.EditorActivity.this.mProgressDialog.isShowing() || com.aliyun.svideo.editor.editor.EditorActivity.this.tvProgress == null) {
                    return;
                }
                com.aliyun.svideo.editor.editor.EditorActivity.this.tvProgress.setText(com.moji.tool.DeviceTool.getStringById(com.aliyun.svideo.editor.R.string.moji_video_compose_progress, new java.lang.Object[]{java.lang.Integer.valueOf(this.val$progress)}));
            }
        }

        /* renamed from: com.aliyun.svideo.editor.editor.EditorActivity$3$3, reason: invalid class name and collision with other inner class name */
        public class RunnableC00603 implements java.lang.Runnable {
            public RunnableC00603() {
            }

            @Override // java.lang.Runnable
            public void run() {
                com.aliyun.svideo.editor.editor.EditorActivity editorActivity = com.aliyun.svideo.editor.editor.EditorActivity.this;
                com.aliyun.svideo.common.utils.UriUtils.saveVideoToMediaStore(editorActivity, editorActivity.mOutputPath);
            }
        }

        /* renamed from: com.aliyun.svideo.editor.editor.EditorActivity$3$4, reason: invalid class name */
        public class AnonymousClass4 implements java.lang.Runnable {
            public AnonymousClass4() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (com.aliyun.svideo.editor.editor.EditorActivity.this.mProgressDialog != null && com.aliyun.svideo.editor.editor.EditorActivity.this.mProgressDialog.isShowing()) {
                    com.aliyun.svideo.editor.editor.EditorActivity.this.mProgressDialog.dismiss();
                }
                if (com.aliyun.svideo.editor.editor.EditorActivity.this.mCompose != null) {
                    com.aliyun.svideo.editor.editor.EditorActivity.this.mCompose.release();
                    com.aliyun.svideo.editor.editor.EditorActivity.this.mCompose = null;
                }
            }
        }

        public AnonymousClass3() {
        }

        @Override // com.aliyun.svideosdk.editor.AliyunIComposeCallBack
        public void onComposeCompleted() {
            if (android.os.Build.VERSION.SDK_INT >= 29) {
                com.aliyun.svideo.common.utils.ThreadUtils.runOnSubThread(new com.aliyun.svideo.editor.editor.EditorActivity.AnonymousClass3.RunnableC00603());
            } else {
                android.media.MediaScannerConnection.scanFile(com.aliyun.svideo.editor.editor.EditorActivity.this.getApplicationContext(), new java.lang.String[]{com.aliyun.svideo.editor.editor.EditorActivity.this.mOutputPath}, new java.lang.String[]{"video/mp4"}, null);
            }
            com.moji.router.Postcard withInt = com.moji.router.MJRouter.getInstance().build("shortvideo/public").withString("video_path", com.aliyun.svideo.editor.editor.EditorActivity.this.mOutputPath).withInt("video_width", com.aliyun.svideo.editor.editor.EditorActivity.this.mOutputVideoWidth).withInt("video_height", com.aliyun.svideo.editor.editor.EditorActivity.this.mOutputVideoHeight);
            android.content.Intent intent = com.aliyun.svideo.editor.editor.EditorActivity.this.getIntent();
            if (intent != null) {
                withInt.withIntent(intent);
            }
            withInt.start();
            com.aliyun.svideo.editor.editor.EditorActivity.this.runOnUiThread(new com.aliyun.svideo.editor.editor.EditorActivity.AnonymousClass3.AnonymousClass4());
            com.aliyun.svideo.base.utils.VideoInfoUtils.printVideoInfo(com.aliyun.svideo.editor.editor.EditorActivity.this.mOutputPath);
        }

        @Override // com.aliyun.svideosdk.editor.AliyunIComposeCallBack
        public void onComposeError(int i) {
            com.aliyun.svideo.editor.editor.EditorActivity.this.runOnUiThread(new com.aliyun.svideo.editor.editor.EditorActivity.AnonymousClass3.AnonymousClass1());
        }

        @Override // com.aliyun.svideosdk.editor.AliyunIComposeCallBack
        public void onComposeProgress(int i) {
            com.aliyun.svideo.editor.editor.EditorActivity.this.runOnUiThread(new com.aliyun.svideo.editor.editor.EditorActivity.AnonymousClass3.AnonymousClass2(i));
        }
    }

    /* renamed from: com.aliyun.svideo.editor.editor.EditorActivity$4, reason: invalid class name */
    public class AnonymousClass4 implements com.moji.dialog.control.MJDialogDefaultControl.SingleButtonCallback {
        public AnonymousClass4() {
        }

        public void onClick(@androidx.annotation.NonNull com.moji.dialog.MJDialog mJDialog, @androidx.annotation.NonNull com.moji.dialog.type.ETypeAction eTypeAction) {
            mJDialog.dismiss();
            com.aliyun.svideo.editor.editor.EditorActivity.this.finish();
        }
    }

    /* renamed from: com.aliyun.svideo.editor.editor.EditorActivity$5, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass5 {
        static final /* synthetic */ int[] $SwitchMap$com$moji$base$enums$VideoSourceType;

        static {
            int[] iArr = new int[com.moji.base.enums.VideoSourceType.values().length];
            $SwitchMap$com$moji$base$enums$VideoSourceType = iArr;
            try {
                iArr[com.moji.base.enums.VideoSourceType.FEED.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$moji$base$enums$VideoSourceType[com.moji.base.enums.VideoSourceType.FEED_2.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$moji$base$enums$VideoSourceType[com.moji.base.enums.VideoSourceType.LIVE_VIEW.ordinal()] = 3;
            } catch (java.lang.NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$moji$base$enums$VideoSourceType[com.moji.base.enums.VideoSourceType.AGGREGATION.ordinal()] = 4;
            } catch (java.lang.NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$moji$base$enums$VideoSourceType[com.moji.base.enums.VideoSourceType.PROMOTION.ordinal()] = 5;
            } catch (java.lang.NoSuchFieldError unused5) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void composeVideo(java.lang.String str) {
        showProgressDialog();
        com.aliyun.svideosdk.editor.impl.AliyunVodCompose aliyunVodCompose = com.aliyun.svideo.editor.publish.ComposeFactory.INSTANCE.getAliyunVodCompose();
        this.mCompose = aliyunVodCompose;
        aliyunVodCompose.init(getApplicationContext());
        java.lang.String str2 = com.aliyun.svideo.base.Constants.SDCardConstants.getDir(this) + com.aliyun.svideo.common.utils.DateTimeUtils.getDateTimeFromMillisecond(java.lang.Long.valueOf(java.lang.System.currentTimeMillis())) + com.aliyun.svideo.base.Constants.SDCardConstants.COMPOSE_SUFFIX;
        this.mOutputPath = str2;
        this.mCompose.compose(str, str2, this.mCallback);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public java.lang.String getEventValue() {
        int i = com.aliyun.svideo.editor.editor.EditorActivity.AnonymousClass5.$SwitchMap$com$moji$base$enums$VideoSourceType[this.mSourceType.ordinal()];
        return (i == 1 || i == 2) ? "1" : i != 3 ? i != 4 ? i != 5 ? "0" : "4" : "3" : "2";
    }

    private java.lang.String getProjectJsonPath(java.util.List<com.aliyun.svideo.media.MediaInfo> list) {
        com.aliyun.svideosdk.importer.AliyunIImport importInstance = com.aliyun.svideosdk.importer.impl.AliyunImportCreator.getImportInstance(this);
        importInstance.setVideoParam(this.mVideoParam);
        int size = list.size();
        for (int i = 0; i < size; i++) {
            com.aliyun.svideo.media.MediaInfo mediaInfo = list.get(i);
            if (mediaInfo.mimeType.startsWith("video")) {
                importInstance.addMediaClip(new com.aliyun.svideosdk.common.struct.common.AliyunVideoClip.Builder().source(mediaInfo.filePath).startTime(mediaInfo.startTime).endTime(mediaInfo.startTime + mediaInfo.duration).duration(mediaInfo.duration).build());
            } else if (mediaInfo.mimeType.startsWith("image")) {
                importInstance.addMediaClip(new com.aliyun.svideosdk.common.struct.common.AliyunImageClip.Builder().source(mediaInfo.filePath).duration(mediaInfo.duration).build());
            }
        }
        java.lang.String generateProjectConfigure = importInstance.generateProjectConfigure();
        importInstance.release();
        return generateProjectConfigure;
    }

    private void initArgs() {
        android.content.Intent intent = getIntent();
        if (intent != null) {
            com.moji.base.enums.VideoSourceType serializableExtra = intent.getSerializableExtra(EXTRA_DATA_SOURCE_TYPE);
            if (serializableExtra instanceof com.moji.base.enums.VideoSourceType) {
                this.mSourceType = serializableExtra;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0128  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x012f  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:79:0x020d -> B:44:0x0224). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void initData() {
        android.content.Intent intent;
        int i;
        com.aliyun.svideo.editor.bean.AlivcEditInputParam alivcEditInputParam;
        java.lang.String str;
        android.media.MediaMetadataRetriever mediaMetadataRetriever;
        int i2;
        int i3;
        android.content.Intent intent2 = getIntent();
        int intExtra = intent2.getIntExtra(com.aliyun.svideo.editor.bean.AlivcEditInputParam.INTENT_KEY_FRAME, 30);
        int intExtra2 = intent2.getIntExtra("mGop", 250);
        int intExtra3 = intent2.getIntExtra("mRatioMode", 2);
        com.aliyun.svideosdk.common.struct.common.VideoQuality videoQuality = (com.aliyun.svideosdk.common.struct.common.VideoQuality) intent2.getSerializableExtra(com.aliyun.svideo.editor.bean.AlivcEditInputParam.INTENT_KEY_QUALITY);
        if (videoQuality == null) {
            videoQuality = com.aliyun.svideosdk.common.struct.common.VideoQuality.HD;
        }
        com.aliyun.svideosdk.common.struct.common.VideoQuality videoQuality2 = videoQuality;
        int intExtra4 = intent2.getIntExtra("mResolutionMode", 3);
        com.aliyun.svideosdk.common.struct.encoder.VideoCodecs videoCodecs = (com.aliyun.svideosdk.common.struct.encoder.VideoCodecs) intent2.getSerializableExtra(com.aliyun.svideo.editor.bean.AlivcEditInputParam.INTENT_KEY_CODEC);
        if (videoCodecs == null) {
            videoCodecs = com.aliyun.svideosdk.common.struct.encoder.VideoCodecs.H264_HARDWARE;
        }
        com.aliyun.svideosdk.common.struct.encoder.VideoCodecs videoCodecs2 = videoCodecs;
        int intExtra5 = intent2.getIntExtra(com.aliyun.svideo.editor.bean.AlivcEditInputParam.INTETN_KEY_CRF, 23);
        float floatExtra = intent2.getFloatExtra(com.aliyun.svideo.editor.bean.AlivcEditInputParam.INTETN_KEY_SCANLE_RATE, 1.0f);
        com.aliyun.svideosdk.common.struct.common.VideoDisplayMode videoDisplayMode = (com.aliyun.svideosdk.common.struct.common.VideoDisplayMode) intent2.getSerializableExtra(com.aliyun.svideo.editor.bean.AlivcEditInputParam.INTETN_KEY_SCANLE_MODE);
        if (videoDisplayMode == null) {
            videoDisplayMode = com.aliyun.svideosdk.common.struct.common.VideoDisplayMode.FILL;
        }
        com.aliyun.svideosdk.common.struct.common.VideoDisplayMode videoDisplayMode2 = videoDisplayMode;
        boolean booleanExtra = intent2.getBooleanExtra(com.aliyun.svideo.editor.bean.AlivcEditInputParam.INTENT_KEY_TAIL_ANIMATION, false);
        boolean booleanExtra2 = intent2.getBooleanExtra(com.aliyun.svideo.editor.bean.AlivcEditInputParam.INTENT_KEY_DE_NOISE, false);
        boolean booleanExtra3 = intent2.getBooleanExtra(com.aliyun.svideo.editor.bean.AlivcEditInputParam.INTENT_KEY_REPLACE_MUSIC, true);
        java.util.ArrayList parcelableArrayListExtra = intent2.getParcelableArrayListExtra(com.aliyun.svideo.editor.bean.AlivcEditInputParam.INTENT_KEY_MEDIA_INFO);
        boolean booleanExtra4 = intent2.getBooleanExtra(com.aliyun.svideo.editor.bean.AlivcEditInputParam.INTENT_KEY_WATER_MARK, false);
        boolean booleanExtra5 = intent2.getBooleanExtra(com.aliyun.svideo.editor.bean.AlivcEditInputParam.INTENT_KEY_HORIZONTAL_FLIP, false);
        boolean booleanExtra6 = intent2.getBooleanExtra(com.aliyun.svideo.editor.bean.AlivcEditInputParam.INTENT_KEY_IS_MIX, false);
        if (parcelableArrayListExtra == null || parcelableArrayListExtra.size() <= 0) {
            intent = intent2;
        } else {
            intent = intent2;
            if (!android.text.TextUtils.isEmpty(((com.aliyun.svideo.media.MediaInfo) parcelableArrayListExtra.get(0)).filePath)) {
                try {
                    com.aliyun.svideosdk.transcode.NativeParser nativeParser = new com.aliyun.svideosdk.transcode.NativeParser();
                    nativeParser.init(((com.aliyun.svideo.media.MediaInfo) parcelableArrayListExtra.get(0)).filePath);
                    i = java.lang.Integer.parseInt(nativeParser.getValue(5)) / 1000;
                } catch (java.lang.Exception e) {
                    com.moji.tool.log.MJLogger.e(TAG, e);
                }
                com.aliyun.svideo.editor.bean.AlivcEditInputParam.Builder builder = new com.aliyun.svideo.editor.bean.AlivcEditInputParam.Builder();
                if (parcelableArrayListExtra != null) {
                    builder.addMediaInfos(parcelableArrayListExtra);
                }
                com.aliyun.svideo.editor.bean.AlivcEditInputParam build = builder.setFrameRate(intExtra).setGop(intExtra2).setRatio(intExtra3).setVideoQuality(videoQuality2).setResolutionMode(intExtra4).setVideoCodec(videoCodecs2).setCrf(intExtra5).setScaleRate(floatExtra).setBitRate(i).setScaleMode(videoDisplayMode2).setHasTailAnimation(booleanExtra).setCanReplaceMusic(booleanExtra3).setHasWaterMark(booleanExtra4).setIsMixRecorder(booleanExtra6).setDeNoise(booleanExtra2).setHorizontalFlip(booleanExtra5).build();
                this.mInputParam = build;
                if (booleanExtra6) {
                    this.mVideoParam = build.generateVideoParam();
                    android.content.Intent intent3 = intent;
                    int intExtra6 = intent3.getIntExtra(com.aliyun.svideo.editor.bean.AlivcEditInputParam.INTENT_KEY_OUTPUT_WIDTH, -1);
                    int intExtra7 = intent3.getIntExtra(com.aliyun.svideo.editor.bean.AlivcEditInputParam.INTENT_KEY_OUTPUT_HEIGHT, -1);
                    if (intExtra6 != -1 && intExtra7 != -1) {
                        this.mVideoParam.setOutputWidth(intExtra6);
                        this.mVideoParam.setOutputHeight(intExtra7);
                    }
                } else {
                    this.mVideoParam = build.generateMixVideoParam();
                }
                alivcEditInputParam = this.mInputParam;
                if (alivcEditInputParam != null || alivcEditInputParam.getMediaInfos() == null || this.mInputParam.getMediaInfos().size() <= 0) {
                    return;
                }
                android.media.MediaMetadataRetriever mediaMetadataRetriever2 = null;
                try {
                    try {
                        try {
                            str = this.mInputParam.getMediaInfos().get(0).filePath;
                            mediaMetadataRetriever = new android.media.MediaMetadataRetriever();
                        } catch (java.lang.Exception e2) {
                            com.moji.tool.log.MJLogger.e(TAG, e2);
                        }
                    } catch (java.lang.Exception e3) {
                        e = e3;
                    }
                } catch (java.lang.Throwable th) {
                    th = th;
                }
                try {
                    mediaMetadataRetriever.setDataSource(str);
                    android.graphics.Bitmap frameAtTime = mediaMetadataRetriever.getFrameAtTime(0L, 3);
                    if (frameAtTime != null) {
                        i3 = frameAtTime.getWidth();
                        i2 = frameAtTime.getHeight();
                    } else {
                        com.aliyun.svideosdk.transcode.NativeParser nativeParser2 = new com.aliyun.svideosdk.transcode.NativeParser();
                        nativeParser2.init(str);
                        int parseInt = java.lang.Integer.parseInt(nativeParser2.getValue(14));
                        if (parseInt != 90 && parseInt != 270) {
                            i3 = java.lang.Integer.parseInt(nativeParser2.getValue(6));
                            i2 = java.lang.Integer.parseInt(nativeParser2.getValue(7));
                        }
                        int parseInt2 = java.lang.Integer.parseInt(nativeParser2.getValue(6));
                        int parseInt3 = java.lang.Integer.parseInt(nativeParser2.getValue(7));
                        i2 = parseInt2;
                        i3 = parseInt3;
                    }
                    if (i3 > 0 && i2 > 0) {
                        this.mVideoParam.setOutputWidth(i3);
                        this.mVideoParam.setOutputHeight(i2);
                    }
                    if (android.os.Build.VERSION.SDK_INT >= 29) {
                        mediaMetadataRetriever.close();
                    } else {
                        mediaMetadataRetriever.release();
                    }
                } catch (java.lang.Exception e4) {
                    e = e4;
                    mediaMetadataRetriever2 = mediaMetadataRetriever;
                    com.moji.tool.log.MJLogger.e(TAG, e);
                    if (mediaMetadataRetriever2 != null) {
                        if (android.os.Build.VERSION.SDK_INT >= 29) {
                            mediaMetadataRetriever2.close();
                        } else {
                            mediaMetadataRetriever2.release();
                        }
                        return;
                    }
                    return;
                } catch (java.lang.Throwable th2) {
                    th = th2;
                    mediaMetadataRetriever2 = mediaMetadataRetriever;
                    java.lang.Throwable th3 = th;
                    if (mediaMetadataRetriever2 == null) {
                        throw th3;
                    }
                    try {
                        if (android.os.Build.VERSION.SDK_INT >= 29) {
                            mediaMetadataRetriever2.close();
                        } else {
                            mediaMetadataRetriever2.release();
                        }
                        throw th3;
                    } catch (java.lang.Exception e5) {
                        com.moji.tool.log.MJLogger.e(TAG, e5);
                        throw th3;
                    }
                }
                return;
            }
        }
        i = 0;
        com.aliyun.svideo.editor.bean.AlivcEditInputParam.Builder builder2 = new com.aliyun.svideo.editor.bean.AlivcEditInputParam.Builder();
        if (parcelableArrayListExtra != null) {
        }
        com.aliyun.svideo.editor.bean.AlivcEditInputParam build2 = builder2.setFrameRate(intExtra).setGop(intExtra2).setRatio(intExtra3).setVideoQuality(videoQuality2).setResolutionMode(intExtra4).setVideoCodec(videoCodecs2).setCrf(intExtra5).setScaleRate(floatExtra).setBitRate(i).setScaleMode(videoDisplayMode2).setHasTailAnimation(booleanExtra).setCanReplaceMusic(booleanExtra3).setHasWaterMark(booleanExtra4).setIsMixRecorder(booleanExtra6).setDeNoise(booleanExtra2).setHorizontalFlip(booleanExtra5).build();
        this.mInputParam = build2;
        if (booleanExtra6) {
        }
        alivcEditInputParam = this.mInputParam;
        if (alivcEditInputParam != null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showExitDialog() {
        java.lang.String string = getString(com.aliyun.svideo.editor.R.string.cancel_this_edit);
        new com.moji.dialog.control.MJDialogDefaultControl.Builder(this).content("\n" + string + "\n").negativeText(com.aliyun.svideo.editor.R.string.cancel).canceledOnTouchOutside(true).positiveText(com.aliyun.svideo.editor.R.string.exit).onPositive(new com.aliyun.svideo.editor.editor.EditorActivity.AnonymousClass4()).show();
    }

    private void showProgressDialog() {
        com.moji.dialog.control.MJDialogCustomControl.Builder builder = new com.moji.dialog.control.MJDialogCustomControl.Builder(this);
        android.view.View inflate = android.view.LayoutInflater.from(this).inflate(com.aliyun.svideo.editor.R.layout.dialog_compose_progrss, (android.view.ViewGroup) null);
        com.moji.dialog.MJDialog build = builder.customView(inflate).needBg(false).setTheme(com.aliyun.svideo.editor.R.style.MJ_Dialog_Transparent).canceledOnTouchOutside(false).cancelable(false).build();
        this.mProgressDialog = build;
        android.view.Window window = build.getWindow();
        if (window != null) {
            window.setWindowAnimations(com.moji.widget.R.style.MJ_Dialog_Slide);
        }
        window.setDimAmount(0.0f);
        android.widget.TextView textView = (android.widget.TextView) inflate.findViewById(com.aliyun.svideo.editor.R.id.tv_loading_message);
        this.tvProgress = textView;
        textView.setText(com.moji.tool.DeviceTool.getStringById(com.aliyun.svideo.editor.R.string.moji_video_compose_progress, new java.lang.Object[]{0}));
        this.mProgressDialog.show();
    }

    public static void startEdit(android.content.Context context, com.aliyun.svideo.editor.bean.AlivcEditInputParam alivcEditInputParam, @androidx.annotation.Nullable android.os.Bundle bundle) {
        com.aliyun.common.httpfinal.QupaiHttpFinal.getInstance().initOkHttpFinal();
        com.aliyun.svideo.downloader.DownloaderManager.getInstance().init(context);
        startEdit(context, alivcEditInputParam, null, -1, -1, bundle);
    }

    public static void startEdit(android.content.Context context, com.aliyun.svideo.editor.bean.AlivcEditInputParam alivcEditInputParam, java.lang.String str, int i, int i2, @androidx.annotation.Nullable android.os.Bundle bundle) {
        if (alivcEditInputParam != null) {
            if ((alivcEditInputParam.getMediaInfos() == null || alivcEditInputParam.getMediaInfos().size() == 0) && com.aliyun.common.utils.StringUtils.isEmpty(str)) {
                return;
            }
            android.content.Intent intent = new android.content.Intent(context, (java.lang.Class<?>) com.aliyun.svideo.editor.editor.EditorActivity.class);
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
            intent.putExtra(com.aliyun.svideo.editor.bean.AlivcEditInputParam.INTENT_KEY_DE_NOISE, alivcEditInputParam.getDeNoise());
            intent.putExtra(com.aliyun.svideo.editor.bean.AlivcEditInputParam.INTENT_KEY_REPLACE_MUSIC, alivcEditInputParam.isCanReplaceMusic());
            intent.putExtra(com.aliyun.svideo.editor.bean.AlivcEditInputParam.INTENT_KEY_WATER_MARK, alivcEditInputParam.isHasWaterMark());
            intent.putExtra(com.aliyun.svideo.editor.bean.AlivcEditInputParam.INTENT_KEY_HORIZONTAL_FLIP, alivcEditInputParam.isHorizontalFlip());
            intent.putExtra(com.aliyun.svideo.editor.bean.AlivcEditInputParam.INTENT_KEY_IS_MIX, alivcEditInputParam.isMixRecorder());
            if (str != null) {
                intent.putExtra(com.aliyun.svideo.editor.bean.AlivcEditInputParam.INTENT_KEY_DRAFT_PATH, str);
                intent.putExtra(com.aliyun.svideo.editor.bean.AlivcEditInputParam.INTENT_KEY_OUTPUT_WIDTH, i);
                intent.putExtra(com.aliyun.svideo.editor.bean.AlivcEditInputParam.INTENT_KEY_OUTPUT_HEIGHT, i2);
            } else {
                intent.putParcelableArrayListExtra(com.aliyun.svideo.editor.bean.AlivcEditInputParam.INTENT_KEY_MEDIA_INFO, alivcEditInputParam.getMediaInfos());
            }
            if (bundle != null) {
                intent.putExtras(bundle);
            }
            context.startActivity(intent);
        }
    }

    public static void startEdit(android.content.Context context, com.aliyun.svideosdk.editor.draft.AliyunDraft aliyunDraft) {
        startEdit(context, new com.aliyun.svideo.editor.bean.AlivcEditInputParam.Builder().setScaleMode(com.aliyun.svideosdk.common.struct.common.VideoDisplayMode.valueOf(aliyunDraft.getConfig().getDisplayMode())).setVideoQuality(com.aliyun.svideosdk.common.struct.common.VideoQuality.values()[aliyunDraft.getConfig().getVideoQuality()]).setFrameRate(aliyunDraft.getConfig().getFps()).setGop(aliyunDraft.getConfig().getGop()).setCrf(aliyunDraft.getConfig().getCrf()).setVideoCodec(com.aliyun.svideosdk.common.struct.encoder.VideoCodecs.getInstanceByValue(aliyunDraft.getConfig().getVideoCodec())).setScaleRate(aliyunDraft.getConfig().getScale()).build(), aliyunDraft.getEditorProjectUri(), aliyunDraft.getConfig().getOutputWidth(), aliyunDraft.getConfig().getOutputHeight(), null);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, android.content.Intent intent) {
        super.onActivityResult(i, i2, intent);
        com.aliyun.svideo.editor.view.AlivcEditView alivcEditView = this.editView;
        if (alivcEditView != null) {
            alivcEditView.onActivityResult(i, i2, intent);
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        com.aliyun.svideo.editor.view.AlivcEditView alivcEditView = this.editView;
        if (alivcEditView != null ? alivcEditView.onBackPressed() : false) {
            return;
        }
        showExitDialog();
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(android.os.Bundle bundle) {
        super.onCreate(bundle);
        initArgs();
        if (!com.aliyun.svideo.music.utils.NotchScreenUtil.checkNotchScreen(this)) {
            getWindow().setFlags(1024, 1024);
        }
        getWindow().addFlags(128);
        setContentView(com.aliyun.svideo.editor.R.layout.alivc_editor_acitvity_edit);
        initData();
        this.editView = (com.aliyun.svideo.editor.view.AlivcEditView) findViewById(com.aliyun.svideo.editor.R.id.alivc_edit_view);
        boolean isHasTailAnimation = this.mInputParam.isHasTailAnimation();
        boolean isCanReplaceMusic = this.mInputParam.isCanReplaceMusic();
        boolean isMixRecorder = this.mInputParam.isMixRecorder();
        boolean deNoise = this.mInputParam.getDeNoise();
        java.lang.String stringExtra = getIntent().getStringExtra(com.aliyun.svideo.editor.bean.AlivcEditInputParam.INTENT_KEY_DRAFT_PATH);
        android.net.Uri parse = !com.aliyun.common.utils.StringUtils.isEmpty(stringExtra) ? android.net.Uri.parse(stringExtra) : android.net.Uri.fromFile(new java.io.File(getProjectJsonPath(this.mInputParam.getMediaInfos())));
        this.editView.setHasDeNoise(deNoise);
        this.editView.setParam(this.mVideoParam, parse, isHasTailAnimation, this.mInputParam.isHasWaterMark(), this.mInputParam.isHorizontalFlip());
        this.editView.setReplaceMusic(isCanReplaceMusic);
        this.editView.setHasRecordMusic(isCanReplaceMusic);
        this.editView.setIsMixRecord(isMixRecorder);
        this.editView.setLeftOnClickListener(new com.aliyun.svideo.editor.editor.EditorActivity.AnonymousClass1());
        this.editView.setmOnFinishListener(new com.aliyun.svideo.editor.editor.EditorActivity.AnonymousClass2());
        com.moji.base.MJShortActivityStack.getInstance().pushToActivityStack(this);
        java.lang.String eventValue = getEventValue();
        com.moji.statistics.EventManager.getInstance().notifEvent(com.moji.statistics.EVENT_TAG2.MAIN_SHORTVIDEO_EDIT_SW, eventValue);
        com.moji.statistics.EVENT_TAG_SENSORS event_tag_sensors = com.moji.statistics.EVENT_TAG_SENSORS.MAIN_SHORTVIDEO_EDIT_SW;
        com.moji.statistics.EventManager.getInstance().notifEvent(event_tag_sensors, new com.moji.tool.SensorParams.Builder(event_tag_sensors.name()).setValue(eventValue).setEventValue(this.mSourceType.getDesc()).build());
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        com.aliyun.svideo.editor.view.AlivcEditView alivcEditView = this.editView;
        if (alivcEditView != null) {
            alivcEditView.onDestroy();
        }
        com.moji.dialog.MJDialog mJDialog = this.mProgressDialog;
        if (mJDialog != null && mJDialog.isShowing()) {
            this.mProgressDialog.dismiss();
        }
        com.moji.base.MJShortActivityStack.getInstance().popFromActivityStack(this);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        com.aliyun.svideo.editor.view.AlivcEditView alivcEditView = this.editView;
        if (alivcEditView != null) {
            alivcEditView.onPause();
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        com.aliyun.svideo.editor.view.AlivcEditView alivcEditView = this.editView;
        if (alivcEditView != null) {
            alivcEditView.onResume();
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        com.aliyun.svideo.editor.view.AlivcEditView alivcEditView = this.editView;
        if (alivcEditView != null) {
            alivcEditView.onStart();
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        com.aliyun.svideo.editor.view.AlivcEditView alivcEditView = this.editView;
        if (alivcEditView != null) {
            alivcEditView.onStop();
        }
    }
}
