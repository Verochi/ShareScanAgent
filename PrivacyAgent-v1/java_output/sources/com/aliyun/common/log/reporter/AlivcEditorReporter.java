package com.aliyun.common.log.reporter;

/* loaded from: classes.dex */
public class AlivcEditorReporter extends com.aliyun.common.log.reporter.AlivcReporterBase {
    private static final int EDITOR_EVENT_COMPOSE_CANCEL = 3055;
    private static final int EDITOR_EVENT_COMPOSE_COMPLETED = 3056;
    private static final int EDITOR_EVENT_COMPOSE_ERROR = 3054;
    private static final int EDITOR_EVENT_COMPOSE_START = 3053;
    private static final int EDITOR_EVENT_ID = 3000;
    private static final int EDITOR_EVENT_PLAY_ERROR = 3057;
    private static final java.lang.String EDITOR_MODULE_NAME = "edit";
    private static final java.lang.String KEY_EDITOR_BLUR_RADIUS = "blurRadius";
    private static final java.lang.String KEY_EDITOR_COMPOSE_TIME = "composeTime";
    private static final java.lang.String KEY_EDITOR_IS_STREAM = "isStream";
    private static final java.lang.String KEY_EDITOR_MUSIC_WEIGHT = "musicWeight";
    private static final java.lang.String KEY_EDITOR_NEED_DENOISE = "needDenoise";
    private static final java.lang.String KEY_EDITOR_NEED_ORIGIN_DURATION = "needOriginDuration";
    private static final java.lang.String KEY_EDITOR_OVERLAP_DURATION = "overlapDuration";
    private static final java.lang.String KEY_EDITOR_PARAM = "param";
    private static final java.lang.String KEY_EDITOR_RATE = "rate";
    private static final java.lang.String KEY_EDITOR_REPEAT = "repeat";
    private static final java.lang.String KEY_EDITOR_STREAM_DURATION = "streamDuration";
    private static final java.lang.String KEY_EDITOR_STREAM_ID = "streamID";
    private static final java.lang.String KEY_EDITOR_STREAM_START_TIME = "streamStartTime";
    private static final java.lang.String KEY_EDITOR_TARGET_ID = "targetID";
    private static final java.lang.String TAG = com.aliyun.common.log.reporter.AlivcPlayerReporter.class.getName();

    /* renamed from: com.aliyun.common.log.reporter.AlivcEditorReporter$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {
        final /* synthetic */ java.util.HashMap val$args;
        final /* synthetic */ com.aliyun.svideosdk.transcode.NativeParser val$nativeParser;
        final /* synthetic */ java.lang.String val$outputPath;

        public AnonymousClass1(java.lang.String str, com.aliyun.svideosdk.transcode.NativeParser nativeParser, java.util.HashMap hashMap) {
            this.val$outputPath = str;
            this.val$nativeParser = nativeParser;
            this.val$args = hashMap;
        }

        @Override // java.lang.Runnable
        public void run() {
            java.io.File file = new java.io.File(this.val$outputPath);
            if (file.exists()) {
                this.val$nativeParser.init(this.val$outputPath);
                try {
                    this.val$args.put(com.anythink.core.api.ATAdConst.NETWORK_REQUEST_PARAMS_KEY.BANNER_SIZE, java.lang.String.valueOf(file.length()));
                    java.lang.String value = this.val$nativeParser.getValue(6);
                    java.util.HashMap hashMap = this.val$args;
                    if ("unknown".equals(value)) {
                        value = "0";
                    }
                    hashMap.put("width", value);
                    java.lang.String value2 = this.val$nativeParser.getValue(7);
                    java.util.HashMap hashMap2 = this.val$args;
                    if ("unknown".equals(value2)) {
                        value2 = "0";
                    }
                    hashMap2.put("height", value2);
                    java.lang.String value3 = this.val$nativeParser.getValue(13);
                    java.util.HashMap hashMap3 = this.val$args;
                    if ("unknown".equals(value3)) {
                        value3 = "0";
                    }
                    hashMap3.put("fps", value3);
                    java.lang.String value4 = this.val$nativeParser.getValue(5);
                    java.util.HashMap hashMap4 = this.val$args;
                    if ("unknown".equals(value4)) {
                        value4 = "0";
                    }
                    hashMap4.put(tv.danmaku.ijk.media.player.IjkMediaMeta.IJKM_KEY_BITRATE, value4);
                    this.val$args.put("format", this.val$nativeParser.getValue(10));
                    java.lang.String value5 = this.val$nativeParser.getValue(28);
                    java.util.HashMap hashMap5 = this.val$args;
                    if ("unknown".equals(value5)) {
                        value5 = "0";
                    }
                    hashMap5.put("duration", value5);
                    java.lang.String value6 = this.val$nativeParser.getValue(3);
                    java.util.HashMap hashMap6 = this.val$args;
                    if ("unknown".equals(value6)) {
                        value6 = "0";
                    }
                    hashMap6.put(com.tencent.connect.share.QzonePublish.PUBLISH_TO_QZONE_VIDEO_DURATION, value6);
                    java.lang.String value7 = this.val$nativeParser.getValue(18);
                    java.util.HashMap hashMap7 = this.val$args;
                    if ("unknown".equals(value7)) {
                        value7 = "0";
                    }
                    hashMap7.put("audioDuration", value7);
                } catch (java.lang.Exception unused) {
                    this.val$args.put("width", "0");
                    this.val$args.put("height", "0");
                    this.val$args.put("fps", "0");
                    this.val$args.put(tv.danmaku.ijk.media.player.IjkMediaMeta.IJKM_KEY_BITRATE, "0");
                    this.val$args.put("format", "unknown");
                    this.val$args.put("duration", "0");
                    this.val$args.put(com.tencent.connect.share.QzonePublish.PUBLISH_TO_QZONE_VIDEO_DURATION, "0");
                    this.val$args.put("audioDuration", "0");
                }
                this.val$nativeParser.release();
                this.val$nativeParser.dispose();
            }
            com.aliyun.common.log.reporter.AlivcEditorReporter.this.sendEvent(com.aliyun.common.log.reporter.AlivcEditorReporter.EDITOR_EVENT_COMPOSE_COMPLETED, this.val$args);
            com.aliyun.common.log.reporter.AlivcEditorReporter alivcEditorReporter = com.aliyun.common.log.reporter.AlivcEditorReporter.this;
            alivcEditorReporter.mEventSending = false;
            if (alivcEditorReporter.mDestroyed) {
                alivcEditorReporter.release();
            }
        }
    }

    /* renamed from: com.aliyun.common.log.reporter.AlivcEditorReporter$2, reason: invalid class name */
    public class AnonymousClass2 implements java.lang.Thread.UncaughtExceptionHandler {
        public AnonymousClass2() {
        }

        @Override // java.lang.Thread.UncaughtExceptionHandler
        public void uncaughtException(java.lang.Thread thread, java.lang.Throwable th) {
            java.lang.String unused = com.aliyun.common.log.reporter.AlivcEditorReporter.TAG;
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("parse File failed, msg is ");
            sb.append(th.getMessage());
        }
    }

    public AlivcEditorReporter(android.content.Context context, java.lang.String str) {
        com.aliyun.svideosdk.conan.event.AlivcEventReporter createAlivcReporter = com.aliyun.common.log.reporter.AlivcReporterManager.createAlivcReporter(context);
        this.mAlivcReporter = createAlivcReporter;
        if (createAlivcReporter != null) {
            createAlivcReporter.setSessionId(str);
            this.mAlivcReporter.setSubModuleName("edit");
        }
        this.mEventId = 3000;
    }

    public void sendAddAnimationFilterEvent(com.aliyun.svideosdk.common.struct.effect.TrackEffect<com.aliyun.svideosdk.common.struct.effect.EffectFilter> trackEffect) {
        if (trackEffect == null) {
            return;
        }
        java.util.HashMap<java.lang.String, java.lang.String> hashMap = new java.util.HashMap<>();
        hashMap.put("_interface", "addAnimationFilter");
        hashMap.put("path", java.lang.String.valueOf(trackEffect.getBean().getPath()));
        hashMap.put(com.umeng.analytics.AnalyticsConfig.RTD_START_TIME, java.lang.String.valueOf(trackEffect.getStartTime()));
        hashMap.put("duration", java.lang.String.valueOf(trackEffect.getDuration()));
        sendEvent(hashMap);
    }

    public void sendAddCaptionBmpEvent(com.aliyun.svideosdk.common.struct.effect.EffectCaption effectCaption) {
        if (effectCaption == null) {
            return;
        }
        java.util.HashMap<java.lang.String, java.lang.String> hashMap = new java.util.HashMap<>();
        hashMap.put("_interface", "addCaption");
        hashMap.put("type", "bmp");
        hashMap.put("param", effectCaption.toString());
        sendEvent(hashMap);
    }

    public void sendAddCaptionGeneratorEvent(com.aliyun.svideosdk.common.struct.effect.EffectCaption effectCaption) {
        if (effectCaption == null) {
            return;
        }
        java.util.HashMap<java.lang.String, java.lang.String> hashMap = new java.util.HashMap<>();
        hashMap.put("_interface", "addCaption");
        hashMap.put("type", "generator");
        hashMap.put("param", effectCaption.toString());
        sendEvent(hashMap);
    }

    public void sendAddFrameAnimationEvent(com.aliyun.svideosdk.common.struct.effect.ActionBase actionBase) {
        if (actionBase == null) {
            return;
        }
        java.util.HashMap<java.lang.String, java.lang.String> hashMap = new java.util.HashMap<>();
        hashMap.put("_interface", "addFrameAnimation");
        hashMap.put(KEY_EDITOR_TARGET_ID, java.lang.String.valueOf(actionBase.getTargetId()));
        hashMap.put("id", java.lang.String.valueOf(actionBase.getId()));
        hashMap.put("type", java.lang.String.valueOf(actionBase.getType().ordinal()));
        hashMap.put(com.umeng.analytics.AnalyticsConfig.RTD_START_TIME, java.lang.String.valueOf(actionBase.getStartTime()));
        hashMap.put("duration", java.lang.String.valueOf(actionBase.getDuration()));
        sendEvent(hashMap);
    }

    public void sendAddImageEvent(com.aliyun.svideosdk.common.struct.effect.TrackEffect<com.aliyun.svideosdk.common.struct.effect.EffectImage> trackEffect) {
        if (trackEffect == null) {
            return;
        }
        com.aliyun.svideosdk.common.struct.effect.EffectImage bean = trackEffect.getBean();
        java.util.HashMap<java.lang.String, java.lang.String> hashMap = new java.util.HashMap<>();
        hashMap.put("_interface", "addImage");
        hashMap.put("path", java.lang.String.valueOf(bean.getPath()));
        hashMap.put("width", java.lang.String.valueOf(bean.getWidthRatio()));
        hashMap.put("height", java.lang.String.valueOf(bean.getHeightRatio()));
        hashMap.put("posX", java.lang.String.valueOf(bean.getXRadio()));
        hashMap.put("posY", java.lang.String.valueOf(bean.getYRadio()));
        hashMap.put(com.umeng.analytics.AnalyticsConfig.RTD_START_TIME, java.lang.String.valueOf(trackEffect.getStartTime()));
        hashMap.put("duration", java.lang.String.valueOf(trackEffect.getDuration()));
        hashMap.put("rotation", java.lang.String.valueOf(bean.getRotation()));
        sendEvent(hashMap);
    }

    public void sendAddPasterEvent(com.aliyun.svideosdk.common.struct.effect.EffectPaster effectPaster) {
        if (effectPaster == null) {
            return;
        }
        java.util.HashMap<java.lang.String, java.lang.String> hashMap = new java.util.HashMap<>();
        hashMap.put("_interface", "addPaster");
        hashMap.put("param", effectPaster.toString());
        sendEvent(hashMap);
    }

    public void sendAddPasterEvent(java.lang.String str) {
        java.util.HashMap<java.lang.String, java.lang.String> hashMap = new java.util.HashMap<>();
        hashMap.put("_interface", "addPaster");
        hashMap.put("path", str);
        sendEvent(hashMap);
    }

    public void sendAddPasterWithStartTimeEvent(java.lang.String str, long j, long j2) {
        java.util.HashMap<java.lang.String, java.lang.String> hashMap = new java.util.HashMap<>();
        hashMap.put("_interface", "addPasterWithStartTime");
        hashMap.put("path", str);
        hashMap.put(com.umeng.analytics.AnalyticsConfig.RTD_START_TIME, java.lang.String.valueOf(j));
        hashMap.put("duration", java.lang.String.valueOf(j2));
        sendEvent(hashMap);
    }

    public void sendAddRunningDisplayModeEvent(com.aliyun.svideosdk.common.struct.common.VideoDisplayMode videoDisplayMode, int i, long j, long j2) {
        if (videoDisplayMode == null) {
            return;
        }
        java.util.HashMap<java.lang.String, java.lang.String> hashMap = new java.util.HashMap<>();
        hashMap.put("_interface", "addRunningDisplayMode");
        hashMap.put("videoDisplayMode", java.lang.String.valueOf(videoDisplayMode.getDisplayMode()));
        hashMap.put(KEY_EDITOR_STREAM_ID, java.lang.String.valueOf(i));
        hashMap.put(com.umeng.analytics.AnalyticsConfig.RTD_START_TIME, java.lang.String.valueOf(j));
        hashMap.put("duration", java.lang.String.valueOf(j2));
        sendEvent(hashMap);
    }

    public void sendAddSubtitleBmpEvent(com.aliyun.svideosdk.common.struct.effect.EffectText effectText) {
        if (effectText == null) {
            return;
        }
        java.util.HashMap<java.lang.String, java.lang.String> hashMap = new java.util.HashMap<>();
        hashMap.put("_interface", "addSubtitle");
        hashMap.put("type", "bmp");
        hashMap.put("param", effectText.toString());
        sendEvent(hashMap);
    }

    public void sendAddSubtitleEvent(java.lang.String str, java.lang.String str2) {
        java.util.HashMap<java.lang.String, java.lang.String> hashMap = new java.util.HashMap<>();
        hashMap.put("_interface", "addSubtitle");
        hashMap.put("text", str);
        hashMap.put("font", str2);
        sendEvent(hashMap);
    }

    public void sendAddSubtitleGeneratorEvent(com.aliyun.svideosdk.common.struct.effect.EffectText effectText) {
        if (effectText == null) {
            return;
        }
        java.util.HashMap<java.lang.String, java.lang.String> hashMap = new java.util.HashMap<>();
        hashMap.put("_interface", "addSubtitle");
        hashMap.put("type", "generator");
        hashMap.put("param", effectText.toString());
        sendEvent(hashMap);
    }

    public void sendAddSubtitleWithStartTimeEvent(java.lang.String str, java.lang.String str2, long j, long j2) {
        java.util.HashMap<java.lang.String, java.lang.String> hashMap = new java.util.HashMap<>();
        hashMap.put("_interface", "addSubtitleWithStartTime");
        hashMap.put("text", str);
        hashMap.put("font", str2);
        hashMap.put(com.umeng.analytics.AnalyticsConfig.RTD_START_TIME, java.lang.String.valueOf(j));
        hashMap.put("duration", java.lang.String.valueOf(j2));
        sendEvent(hashMap);
    }

    public void sendAddTailWaterMarkEvent(java.lang.String str, float f, float f2, float f3, float f4, long j) {
        java.util.HashMap<java.lang.String, java.lang.String> hashMap = new java.util.HashMap<>();
        hashMap.put("_interface", "addTailWaterMark");
        hashMap.put("path", str);
        hashMap.put("width", java.lang.String.valueOf(f));
        hashMap.put("height", java.lang.String.valueOf(f2));
        hashMap.put("posX", java.lang.String.valueOf(f3));
        hashMap.put("posY", java.lang.String.valueOf(f4));
        hashMap.put("duration", java.lang.String.valueOf(j));
        sendEvent(hashMap);
    }

    public void sendApplyBlurBackgroundEvent(int i, long j, long j2, float f) {
        java.util.HashMap<java.lang.String, java.lang.String> hashMap = new java.util.HashMap<>();
        hashMap.put("_interface", "applyBlurBackground");
        hashMap.put(KEY_EDITOR_STREAM_ID, java.lang.String.valueOf(i));
        hashMap.put(com.umeng.analytics.AnalyticsConfig.RTD_START_TIME, java.lang.String.valueOf(j));
        hashMap.put("duration", java.lang.String.valueOf(j2));
        hashMap.put(KEY_EDITOR_BLUR_RADIUS, java.lang.String.valueOf(f));
        sendEvent(hashMap);
    }

    public void sendApplyDubEvent(com.aliyun.svideosdk.common.struct.effect.TrackAudioStream trackAudioStream) {
        if (trackAudioStream == null && trackAudioStream.getSource() == null) {
            return;
        }
        java.util.HashMap<java.lang.String, java.lang.String> hashMap = new java.util.HashMap<>();
        hashMap.put("_interface", "applyDub");
        hashMap.put("path", trackAudioStream.getSource().getPath());
        hashMap.put(com.umeng.analytics.AnalyticsConfig.RTD_START_TIME, java.lang.String.valueOf(trackAudioStream.getStartTime()));
        hashMap.put("duration", java.lang.String.valueOf(trackAudioStream.getDuration()));
        hashMap.put(KEY_EDITOR_STREAM_START_TIME, java.lang.String.valueOf(trackAudioStream.getStreamStartTime()));
        hashMap.put(KEY_EDITOR_STREAM_DURATION, java.lang.String.valueOf(trackAudioStream.getStreamDuration()));
        hashMap.put(KEY_EDITOR_MUSIC_WEIGHT, java.lang.String.valueOf(trackAudioStream.getAudioWeight()));
        sendEvent(hashMap);
    }

    public void sendApplyFilterEvent(com.aliyun.svideosdk.common.struct.effect.EffectFilter effectFilter) {
        if (effectFilter == null && effectFilter.getSource() == null) {
            return;
        }
        java.util.HashMap<java.lang.String, java.lang.String> hashMap = new java.util.HashMap<>();
        hashMap.put("_interface", "applyFilter");
        hashMap.put("path", java.lang.String.valueOf(effectFilter.getSource().getPath()));
        sendEvent(hashMap);
    }

    public void sendApplyLutFilterEvent(com.aliyun.svideosdk.common.struct.effect.LUTEffectBean lUTEffectBean) {
        if (lUTEffectBean == null && lUTEffectBean.getSource() == null) {
            return;
        }
        java.util.HashMap<java.lang.String, java.lang.String> hashMap = new java.util.HashMap<>();
        hashMap.put("_interface", "applyLutFilter");
        hashMap.put("path", java.lang.String.valueOf(lUTEffectBean.getSource().getPath()));
        sendEvent(hashMap);
    }

    public void sendApplyMVEvent(com.aliyun.svideosdk.common.struct.effect.TrackEffectMV trackEffectMV) {
        if (trackEffectMV == null && trackEffectMV.getSource() == null) {
            return;
        }
        java.util.HashMap<java.lang.String, java.lang.String> hashMap = new java.util.HashMap<>();
        hashMap.put("_interface", "applyMV");
        hashMap.put("path", java.lang.String.valueOf(trackEffectMV.getSource().getPath()));
        sendEvent(hashMap);
    }

    public void sendApplyMusicEvent(com.aliyun.svideosdk.common.struct.effect.TrackAudioStream trackAudioStream) {
        if (trackAudioStream == null && trackAudioStream.getSource() == null) {
            return;
        }
        java.util.HashMap<java.lang.String, java.lang.String> hashMap = new java.util.HashMap<>();
        hashMap.put("_interface", "applyMusic");
        hashMap.put("path", trackAudioStream.getSource().getPath());
        hashMap.put(com.umeng.analytics.AnalyticsConfig.RTD_START_TIME, java.lang.String.valueOf(trackAudioStream.getStartTime()));
        hashMap.put("duration", java.lang.String.valueOf(trackAudioStream.getStartTime() + trackAudioStream.getStreamDuration()));
        hashMap.put(KEY_EDITOR_STREAM_START_TIME, java.lang.String.valueOf(trackAudioStream.getStreamStartTime()));
        hashMap.put(KEY_EDITOR_STREAM_DURATION, java.lang.String.valueOf(trackAudioStream.getStreamDuration()));
        hashMap.put(KEY_EDITOR_MUSIC_WEIGHT, java.lang.String.valueOf(trackAudioStream.getAudioWeight()));
        sendEvent(hashMap);
    }

    public void sendApplyMusicMixWeightEvent(int i, int i2) {
        java.util.HashMap<java.lang.String, java.lang.String> hashMap = new java.util.HashMap<>();
        hashMap.put("_interface", "applyMusicMixWeight");
        hashMap.put("id", java.lang.String.valueOf(i));
        hashMap.put(KEY_EDITOR_MUSIC_WEIGHT, java.lang.String.valueOf(i2));
        sendEvent(hashMap);
    }

    public void sendApplyMusicWeightEvent(int i, int i2) {
        java.util.HashMap<java.lang.String, java.lang.String> hashMap = new java.util.HashMap<>();
        hashMap.put("_interface", "applyMusicWeight");
        hashMap.put("id", java.lang.String.valueOf(i));
        hashMap.put(KEY_EDITOR_MUSIC_WEIGHT, java.lang.String.valueOf(i2));
        sendEvent(hashMap);
    }

    public void sendApplySourceChangeEvent() {
        java.util.HashMap<java.lang.String, java.lang.String> hashMap = new java.util.HashMap<>();
        hashMap.put("_interface", "applySourceChange");
        sendEvent(hashMap);
    }

    public void sendApplyWaterMarkEvent(java.lang.String str, float f, float f2, float f3, float f4) {
        java.util.HashMap<java.lang.String, java.lang.String> hashMap = new java.util.HashMap<>();
        hashMap.put("_interface", "applyWaterMark");
        hashMap.put("path", java.lang.String.valueOf(str));
        hashMap.put("width", java.lang.String.valueOf(f));
        hashMap.put("height", java.lang.String.valueOf(f2));
        hashMap.put("posX", java.lang.String.valueOf(f3));
        hashMap.put("posY", java.lang.String.valueOf(f4));
        sendEvent(hashMap);
    }

    public void sendCancelComposeEvent() {
        java.util.HashMap<java.lang.String, java.lang.String> hashMap = new java.util.HashMap<>();
        hashMap.put("_interface", "cancelCompose");
        sendEvent(3000, hashMap);
        hashMap.clear();
        sendEvent(EDITOR_EVENT_COMPOSE_CANCEL, hashMap);
    }

    public void sendClearAllAnimationFilterEvent() {
        java.util.HashMap<java.lang.String, java.lang.String> hashMap = new java.util.HashMap<>();
        hashMap.put("_interface", "clearAllAnimationFilter");
        sendEvent(hashMap);
    }

    public void sendComposeCompleteEvent(java.lang.String str, int i, long j) {
        if (str == null || str.isEmpty()) {
            return;
        }
        com.aliyun.svideosdk.transcode.NativeParser nativeParser = new com.aliyun.svideosdk.transcode.NativeParser();
        java.util.HashMap<java.lang.String, java.lang.String> hashMap = new java.util.HashMap<>();
        hashMap.put("_interface", "composeComplete");
        sendEvent(3000, hashMap);
        hashMap.clear();
        hashMap.put(KEY_EDITOR_COMPOSE_TIME, java.lang.String.valueOf((java.lang.System.nanoTime() - j) / 1000));
        java.lang.Thread thread = new java.lang.Thread(new com.aliyun.common.log.reporter.AlivcEditorReporter.AnonymousClass1(str, nativeParser, hashMap));
        thread.setUncaughtExceptionHandler(new com.aliyun.common.log.reporter.AlivcEditorReporter.AnonymousClass2());
        this.mEventSending = true;
        thread.start();
    }

    public void sendComposeErrorEvent(java.lang.String str, int i) {
        java.util.HashMap<java.lang.String, java.lang.String> hashMap = new java.util.HashMap<>();
        hashMap.put("errorCode", java.lang.String.valueOf(i));
        sendEvent(EDITOR_EVENT_COMPOSE_ERROR, hashMap);
    }

    public void sendComposeEvent(com.aliyun.svideosdk.common.struct.common.AliyunVideoParam aliyunVideoParam, java.lang.String str) {
        if (aliyunVideoParam == null) {
            return;
        }
        java.util.HashMap<java.lang.String, java.lang.String> hashMap = new java.util.HashMap<>();
        hashMap.put("_interface", "compose");
        sendEvent(3000, hashMap);
        hashMap.clear();
        hashMap.put("outputPath", str);
        hashMap.put(tv.danmaku.ijk.media.player.IjkMediaMeta.IJKM_KEY_BITRATE, java.lang.String.valueOf(aliyunVideoParam.getBitrate()));
        hashMap.put("fps", java.lang.String.valueOf(aliyunVideoParam.getFrameRate()));
        hashMap.put(com.aliyun.common.log.struct.AliyunLogKey.KEY_GOP, java.lang.String.valueOf(aliyunVideoParam.getGop()));
        hashMap.put("crf", java.lang.String.valueOf(aliyunVideoParam.getCrf()));
        hashMap.put("scaleRate", java.lang.String.valueOf(aliyunVideoParam.getScaleRate()));
        hashMap.put("videoQuality", java.lang.String.valueOf(aliyunVideoParam.getVideoQuality()));
        hashMap.put("videoDisplayMode", java.lang.String.valueOf(aliyunVideoParam.getScaleMode().getDisplayMode()));
        hashMap.put("videoCodec", java.lang.String.valueOf(aliyunVideoParam.getVideoCodec()));
        sendEvent(EDITOR_EVENT_COMPOSE_START, hashMap);
    }

    public void sendDeleteBlurBackgroundEvent(int i, int i2) {
        java.util.HashMap<java.lang.String, java.lang.String> hashMap = new java.util.HashMap<>();
        hashMap.put("_interface", "deleteBlurBackground");
        hashMap.put(KEY_EDITOR_STREAM_ID, java.lang.String.valueOf(i));
        hashMap.put("id", java.lang.String.valueOf(i2));
        sendEvent(hashMap);
    }

    public void sendDeleteTimeEffectEvent(int i) {
        java.util.HashMap<java.lang.String, java.lang.String> hashMap = new java.util.HashMap<>();
        hashMap.put("_interface", "deleteTimeEffect");
        hashMap.put("id", java.lang.String.valueOf(i));
        sendEvent(hashMap);
    }

    public void sendDenoiseEvent(int i, boolean z) {
        java.util.HashMap<java.lang.String, java.lang.String> hashMap = new java.util.HashMap<>();
        hashMap.put("_interface", "denoise");
        hashMap.put("id", java.lang.String.valueOf(i));
        hashMap.put(KEY_EDITOR_NEED_DENOISE, java.lang.String.valueOf(z));
        sendEvent(hashMap);
    }

    public void sendDisplayModeEvent(com.aliyun.svideosdk.common.struct.common.VideoDisplayMode videoDisplayMode) {
        if (videoDisplayMode == null) {
            return;
        }
        java.util.HashMap<java.lang.String, java.lang.String> hashMap = new java.util.HashMap<>();
        hashMap.put("_interface", "setDisplayMode");
        hashMap.put("videoDisplayMode", java.lang.String.valueOf(videoDisplayMode.getDisplayMode()));
        sendEvent(hashMap);
    }

    public void sendHidePasterEvent(com.aliyun.svideosdk.common.struct.effect.EffectPaster effectPaster) {
        if (effectPaster == null) {
            return;
        }
        java.util.HashMap<java.lang.String, java.lang.String> hashMap = new java.util.HashMap<>();
        hashMap.put("_interface", "hidePaster");
        hashMap.put("param", effectPaster.toString());
        sendEvent(hashMap);
    }

    public void sendInitEvent() {
        java.util.HashMap<java.lang.String, java.lang.String> hashMap = new java.util.HashMap<>();
        hashMap.put("_interface", "init");
        sendEvent(hashMap);
    }

    public void sendInvertEvent() {
        java.util.HashMap<java.lang.String, java.lang.String> hashMap = new java.util.HashMap<>();
        hashMap.put("_interface", "invert");
        sendEvent(hashMap);
    }

    public void sendOnDestroyEvent() {
        java.util.HashMap<java.lang.String, java.lang.String> hashMap = new java.util.HashMap<>();
        hashMap.put("_interface", "onDestroy");
        sendEvent(hashMap);
    }

    public void sendPauseEvent() {
        java.util.HashMap<java.lang.String, java.lang.String> hashMap = new java.util.HashMap<>();
        hashMap.put("_interface", com.anythink.expressad.foundation.d.c.cb);
        sendEvent(hashMap);
    }

    public void sendPlayErrorEvent(int i) {
        java.util.HashMap<java.lang.String, java.lang.String> hashMap = new java.util.HashMap<>();
        hashMap.put("errorCode", java.lang.String.valueOf(i));
        sendEvent(EDITOR_EVENT_PLAY_ERROR, hashMap);
    }

    public void sendPlayEvent() {
        java.util.HashMap<java.lang.String, java.lang.String> hashMap = new java.util.HashMap<>();
        hashMap.put("_interface", com.aliyun.vod.log.core.AliyunLogCommon.SubModule.play);
        sendEvent(hashMap);
    }

    public void sendRateEvent(float f, long j, long j2, boolean z) {
        java.util.HashMap<java.lang.String, java.lang.String> hashMap = new java.util.HashMap<>();
        hashMap.put("_interface", KEY_EDITOR_RATE);
        hashMap.put(KEY_EDITOR_RATE, java.lang.String.valueOf(f));
        hashMap.put(com.umeng.analytics.AnalyticsConfig.RTD_START_TIME, java.lang.String.valueOf(j));
        hashMap.put("duration", java.lang.String.valueOf(j2));
        hashMap.put(KEY_EDITOR_NEED_ORIGIN_DURATION, java.lang.String.valueOf(z));
        sendEvent(hashMap);
    }

    public void sendRemoveAnimationFilterEvent(com.aliyun.svideosdk.common.struct.effect.TrackEffect<com.aliyun.svideosdk.common.struct.effect.EffectFilter> trackEffect) {
        if (trackEffect == null) {
            return;
        }
        java.util.HashMap<java.lang.String, java.lang.String> hashMap = new java.util.HashMap<>();
        hashMap.put("_interface", "removeAnimationFilter");
        hashMap.put("id", java.lang.String.valueOf(trackEffect.getViewId()));
        sendEvent(hashMap);
    }

    public void sendRemoveDubEvent(com.aliyun.svideosdk.common.struct.effect.TrackAudioStream trackAudioStream) {
        if (trackAudioStream == null) {
            return;
        }
        java.util.HashMap<java.lang.String, java.lang.String> hashMap = new java.util.HashMap<>();
        hashMap.put("_interface", "removeDub");
        hashMap.put("id", java.lang.String.valueOf(trackAudioStream.getStreamId()));
        sendEvent(hashMap);
    }

    public void sendRemoveFilterEvent() {
        java.util.HashMap<java.lang.String, java.lang.String> hashMap = new java.util.HashMap<>();
        hashMap.put("_interface", "removeFilter");
        sendEvent(hashMap);
    }

    public void sendRemoveFrameAnimationEvent(com.aliyun.svideosdk.common.struct.effect.ActionBase actionBase) {
        if (actionBase == null) {
            return;
        }
        java.util.HashMap<java.lang.String, java.lang.String> hashMap = new java.util.HashMap<>();
        hashMap.put("_interface", "removeFrameAnimation");
        hashMap.put(KEY_EDITOR_TARGET_ID, java.lang.String.valueOf(actionBase.getTargetId()));
        hashMap.put("id", java.lang.String.valueOf(actionBase.getId()));
        hashMap.put(KEY_EDITOR_IS_STREAM, java.lang.String.valueOf(actionBase.isStream()));
        sendEvent(hashMap);
    }

    public void sendRemoveImageEvent(com.aliyun.svideosdk.common.struct.effect.TrackEffect<com.aliyun.svideosdk.common.struct.effect.EffectImage> trackEffect) {
        if (trackEffect == null) {
            return;
        }
        java.util.HashMap<java.lang.String, java.lang.String> hashMap = new java.util.HashMap<>();
        hashMap.put("_interface", "removeImage");
        hashMap.put("id", java.lang.String.valueOf(trackEffect.getViewId()));
        sendEvent(hashMap);
    }

    public void sendRemoveMusicEvent(com.aliyun.svideosdk.common.struct.effect.TrackAudioStream trackAudioStream) {
        if (trackAudioStream == null) {
            return;
        }
        java.util.HashMap<java.lang.String, java.lang.String> hashMap = new java.util.HashMap<>();
        hashMap.put("_interface", "removeMusic");
        hashMap.put("id", java.lang.String.valueOf(trackAudioStream.getStreamId()));
        sendEvent(hashMap);
    }

    public void sendRemovePasterEvent(com.aliyun.svideosdk.common.struct.effect.EffectPaster effectPaster) {
        if (effectPaster == null) {
            return;
        }
        java.util.HashMap<java.lang.String, java.lang.String> hashMap = new java.util.HashMap<>();
        hashMap.put("_interface", "removePaster");
        hashMap.put("param", effectPaster.toString());
        sendEvent(hashMap);
    }

    public void sendRemoveRunningDisplayModeEvent(int i, int i2) {
        java.util.HashMap<java.lang.String, java.lang.String> hashMap = new java.util.HashMap<>();
        hashMap.put("_interface", "removeRunningDisplayMode");
        hashMap.put(KEY_EDITOR_STREAM_ID, java.lang.String.valueOf(i));
        hashMap.put("id", java.lang.String.valueOf(i2));
        sendEvent(hashMap);
    }

    public void sendRepeatEvent(float f, long j, long j2, boolean z) {
        java.util.HashMap<java.lang.String, java.lang.String> hashMap = new java.util.HashMap<>();
        hashMap.put("_interface", KEY_EDITOR_REPEAT);
        hashMap.put(KEY_EDITOR_REPEAT, java.lang.String.valueOf(f));
        hashMap.put(com.umeng.analytics.AnalyticsConfig.RTD_START_TIME, java.lang.String.valueOf(j));
        hashMap.put("duration", java.lang.String.valueOf(j2));
        hashMap.put(KEY_EDITOR_NEED_ORIGIN_DURATION, java.lang.String.valueOf(z));
        sendEvent(hashMap);
    }

    public void sendReplayEvent() {
        java.util.HashMap<java.lang.String, java.lang.String> hashMap = new java.util.HashMap<>();
        hashMap.put("_interface", "replay");
        sendEvent(hashMap);
    }

    public void sendResetEffectEvent(com.aliyun.svideosdk.editor.EffectType effectType) {
        if (effectType == null) {
            return;
        }
        java.util.HashMap<java.lang.String, java.lang.String> hashMap = new java.util.HashMap<>();
        hashMap.put("_interface", "resetEffect");
        hashMap.put("type", java.lang.String.valueOf(effectType.getEffectType()));
        sendEvent(hashMap);
    }

    public void sendResumeEvent() {
        java.util.HashMap<java.lang.String, java.lang.String> hashMap = new java.util.HashMap<>();
        hashMap.put("_interface", com.anythink.expressad.foundation.d.c.cc);
        sendEvent(hashMap);
    }

    public void sendSaveEffectToLocalEvent() {
        java.util.HashMap<java.lang.String, java.lang.String> hashMap = new java.util.HashMap<>();
        hashMap.put("_interface", "saveEffectToLocal");
        sendEvent(hashMap);
    }

    public void sendSeekEvent(long j) {
        java.util.HashMap<java.lang.String, java.lang.String> hashMap = new java.util.HashMap<>();
        hashMap.put("_interface", "seek");
        hashMap.put("timestamp", java.lang.String.valueOf(j));
        sendEvent(hashMap);
    }

    public void sendSetDisplaySizeEvent(int i, int i2) {
        java.util.HashMap<java.lang.String, java.lang.String> hashMap = new java.util.HashMap<>();
        hashMap.put("_interface", "setDisplaySize");
        hashMap.put("width", java.lang.String.valueOf(i));
        hashMap.put("height", java.lang.String.valueOf(i2));
        sendEvent(hashMap);
    }

    public void sendSetDisplayViewEvent() {
        java.util.HashMap<java.lang.String, java.lang.String> hashMap = new java.util.HashMap<>();
        hashMap.put("_interface", "setDisplayView");
        sendEvent(hashMap);
    }

    public void sendSetFillBackgroundColorEvent(int i) {
        java.util.HashMap<java.lang.String, java.lang.String> hashMap = new java.util.HashMap<>();
        hashMap.put("_interface", "setFillBackgroundColor");
        hashMap.put("color", java.lang.String.valueOf(i));
        sendEvent(hashMap);
    }

    public void sendSetOutputPathEvent(java.lang.String str) {
        java.util.HashMap<java.lang.String, java.lang.String> hashMap = new java.util.HashMap<>();
        hashMap.put("_interface", "setOutputPath");
        hashMap.put("outputPath", str);
        sendEvent(hashMap);
    }

    public void sendSetTransitionEvent(int i, com.aliyun.svideosdk.common.struct.effect.TransitionBase transitionBase) {
        if (transitionBase == null) {
            return;
        }
        java.util.HashMap<java.lang.String, java.lang.String> hashMap = new java.util.HashMap<>();
        hashMap.put("_interface", "setTransition");
        hashMap.put("id", java.lang.String.valueOf(i));
        hashMap.put("type", java.lang.String.valueOf(transitionBase.mType));
        hashMap.put(KEY_EDITOR_OVERLAP_DURATION, java.lang.String.valueOf(transitionBase.getOverlapDuration()));
        sendEvent(hashMap);
    }

    public void sendSetTransitionsEvent() {
        java.util.HashMap<java.lang.String, java.lang.String> hashMap = new java.util.HashMap<>();
        hashMap.put("_interface", "setTransitions");
        sendEvent(hashMap);
    }

    public void sendSilenceEvent(boolean z) {
        java.util.HashMap<java.lang.String, java.lang.String> hashMap = new java.util.HashMap<>();
        hashMap.put("_interface", "setAudioSilence");
        hashMap.put("mute", java.lang.String.valueOf(z));
        sendEvent(hashMap);
    }

    public void sendStopEvent() {
        java.util.HashMap<java.lang.String, java.lang.String> hashMap = new java.util.HashMap<>();
        hashMap.put("_interface", "stop");
        sendEvent(hashMap);
    }

    public void sendUpdateAnimationFilterEvent(com.aliyun.svideosdk.common.struct.effect.TrackEffect<com.aliyun.svideosdk.common.struct.effect.EffectFilter> trackEffect) {
        if (trackEffect == null) {
            return;
        }
        java.util.HashMap<java.lang.String, java.lang.String> hashMap = new java.util.HashMap<>();
        hashMap.put("_interface", "updateAnimationFilter");
        hashMap.put("path", java.lang.String.valueOf(trackEffect.getBean().getPath()));
        hashMap.put(com.umeng.analytics.AnalyticsConfig.RTD_START_TIME, java.lang.String.valueOf(trackEffect.getStartTime()));
        hashMap.put("duration", java.lang.String.valueOf(trackEffect.getDuration()));
        sendEvent(hashMap);
    }

    public void sendUpdateTransitionEvent(int i, com.aliyun.svideosdk.common.struct.effect.TransitionBase transitionBase) {
        if (transitionBase == null) {
            return;
        }
        java.util.HashMap<java.lang.String, java.lang.String> hashMap = new java.util.HashMap<>();
        hashMap.put("_interface", "updateTransition");
        hashMap.put("id", java.lang.String.valueOf(i));
        hashMap.put("type", java.lang.String.valueOf(transitionBase.mType));
        hashMap.put(KEY_EDITOR_OVERLAP_DURATION, java.lang.String.valueOf(transitionBase.getOverlapDuration()));
        sendEvent(hashMap);
    }

    public void sendVolumeEvent(int i) {
        java.util.HashMap<java.lang.String, java.lang.String> hashMap = new java.util.HashMap<>();
        hashMap.put("_interface", com.anythink.expressad.advanced.js.NativeAdvancedJsUtils.h);
        hashMap.put("volume", java.lang.String.valueOf(i));
        sendEvent(hashMap);
    }
}
