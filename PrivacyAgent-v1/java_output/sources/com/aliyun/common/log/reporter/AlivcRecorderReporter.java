package com.aliyun.common.log.reporter;

/* loaded from: classes.dex */
public class AlivcRecorderReporter extends com.aliyun.common.log.reporter.AlivcReporterBase {
    public static final int INVALID_REPORT_ID = -1;
    private static final java.lang.String KEY_AVG_ENCODER_RENDER_COST = "avg_enc_render_cost";
    private static final java.lang.String KEY_AVG_FPS = "avg_fps";
    private static final java.lang.String KEY_AVG_INNER_RENDER_COST = "avg_inner_render_cost";
    private static final java.lang.String KEY_AVG_OES_RENDER_COST = "avg_oes_render_cost";
    private static final java.lang.String KEY_AVG_T2D_RENDER_COST = "avg_t2d_render_cost";
    private static final java.lang.String KEY_BEAUTY_LEVEL = "beauty_level";
    private static final java.lang.String KEY_BEAUTY_STATUS = "beauty_status";
    private static final java.lang.String KEY_CALLBACK = "callback";
    private static final java.lang.String KEY_CAMERA2_HARD_LEVEL = "camera2_hard_level";
    private static final java.lang.String KEY_CAMERA_MAX_LENS_ANGLE = "camera_max_lens_angle";
    private static final java.lang.String KEY_CAMERA_OPEN_RETURN = "camera_return";
    private static final java.lang.String KEY_CAMERA_TYPE = "cam_type";
    private static final java.lang.String KEY_CAMERA_VERSION = "camera_version";
    private static final java.lang.String KEY_CAPTURE_HEIGHT = "capture_height";
    private static final java.lang.String KEY_CAPTURE_WIDTH = "capture_width";
    private static final java.lang.String KEY_DISPLAY_VIEW = "display_view";
    private static final java.lang.String KEY_ENCODER_FPS = "enc_fps";
    private static final java.lang.String KEY_ENCODER_TYPE = "enc_type";
    private static final java.lang.String KEY_EXPOSURE_COMPENSATION = "exposure_compensation";
    private static final java.lang.String KEY_FACES = "faces";
    private static final java.lang.String KEY_FACE_COUNT = "face_count";
    private static final java.lang.String KEY_FACE_MODEL_PATH = "face_model_path";
    private static final java.lang.String KEY_FACE_ROTATION = "face_rotation";
    private static final java.lang.String KEY_FACE_TOGGLE = "face_toggle";
    private static final java.lang.String KEY_FILE_EXIST = "file_exist";
    private static final java.lang.String KEY_FILE_SIZE = "file_size";
    private static final java.lang.String KEY_FLASH_TYPE = "flash_type";
    private static final java.lang.String KEY_FLIP = "flip";
    private static final java.lang.String KEY_FOCUS_MODE = "focus_mode";
    private static final java.lang.String KEY_FOCUS_POINT_X = "focus_point_x";
    private static final java.lang.String KEY_FOCUS_POINT_Y = "focus_point_y";
    private static final java.lang.String KEY_FPS = "fps";
    private static final java.lang.String KEY_FRAME_COUNT = "frame_count";
    private static final java.lang.String KEY_GOP = "gop";
    private static final java.lang.String KEY_INTERNAL_FACE_STATUS = "inner_face_status";
    private static final java.lang.String KEY_MAX_ENCODER_RENDER_COST = "max_enc_render_cost";
    private static final java.lang.String KEY_MAX_INNER_RENDER_COST = "max_inner_render_cost";
    private static final java.lang.String KEY_MAX_OES_RENDER_COST = "max_oes_render_cost";
    private static final java.lang.String KEY_MAX_T2D_RENDER_COST = "max_t2d_render_cost";
    private static final java.lang.String KEY_MUTE = "mute";
    private static final java.lang.String KEY_OUTPUT_PATH = "out_path";
    private static final java.lang.String KEY_OUTPUT_VIDEO_HEIGHT = "out_height";
    private static final java.lang.String KEY_OUTPUT_VIDEO_WIDTH = "out_width";
    private static final java.lang.String KEY_PASTER_TYPE = "paster_type";
    private static final java.lang.String KEY_POSITION_X = "pos_x";
    private static final java.lang.String KEY_POSITION_Y = "pos_y";
    private static final java.lang.String KEY_RATE = "rate";
    private static final java.lang.String KEY_RECORD_SID = "record_sid";
    private static final java.lang.String KEY_RESOURCE_HEIGHT = "res_height";
    private static final java.lang.String KEY_RESOURCE_PATH = "res_path";
    private static final java.lang.String KEY_RESOURCE_WIDTH = "res_width";
    private static final java.lang.String KEY_RETURN = "res";
    private static final java.lang.String KEY_SLOWLY_RENDER_COUNT = "slowly_render_count";
    private static final java.lang.String KEY_STREAM_DURATION = "stream_duration";
    private static final java.lang.String KEY_STREAM_START_TIME = "stream_start_time";
    private static final java.lang.String KEY_SUPPORTED_PIC_SIZE_LIST = "pic_size_list";
    private static final java.lang.String KEY_TEXTURE_HEIGHT = "txt_height";
    private static final java.lang.String KEY_TEXTURE_WIDTH = "txt_width";
    private static final java.lang.String KEY_USE_TIME = "use_time";
    private static final java.lang.String KEY_VID = "vid";
    private static final java.lang.String KEY_VIDEO_BITRATE = "v_bitrate";
    private static final java.lang.String KEY_VIDEO_QUALITY = "v_quality";
    private static final java.lang.String KEY_ZOOM = "zoom";
    private static final int RECORDER_DEVICE_INFO_EVENT_ID = 2101;
    private static final int RECORDER_EVENT_ID = 2000;
    private static final java.lang.String RECORDER_MODULE_NAME = "record";
    private static final int RECORDER_PART_FINISH_USETIME = 2100;
    private java.lang.String mSessionID = com.aliyun.common.log.util.UUIDGenerator.generateUUID();

    public AlivcRecorderReporter(android.content.Context context) {
        com.aliyun.svideosdk.conan.event.AlivcEventReporter createAlivcReporter = com.aliyun.common.log.reporter.AlivcReporterManager.createAlivcReporter(context.getApplicationContext());
        this.mAlivcReporter = createAlivcReporter;
        if (createAlivcReporter != null) {
            createAlivcReporter.setSubModuleName("record");
            this.mAlivcReporter.setSessionId(this.mSessionID);
        }
        this.mEventId = 2000;
    }

    public java.lang.String getRequestId() {
        return this.mSessionID;
    }

    public void sendAddImageEvent(com.aliyun.svideosdk.common.struct.effect.EffectImage effectImage, float f, float f2, float f3, float f4, float f5) {
        java.lang.String str;
        java.util.HashMap<java.lang.String, java.lang.String> hashMap = new java.util.HashMap<>();
        hashMap.put("_interface", "addImage");
        if (effectImage != null) {
            hashMap.put(KEY_RESOURCE_PATH, effectImage.getBitmap() == null ? effectImage.getPath() : effectImage.getBitmap().toString());
            str = java.lang.String.valueOf(effectImage.getResId());
        } else {
            str = "";
            hashMap.put(KEY_RESOURCE_PATH, "");
        }
        hashMap.put(KEY_VID, str);
        hashMap.put(KEY_RESOURCE_WIDTH, java.lang.String.valueOf(f3));
        hashMap.put(KEY_RESOURCE_HEIGHT, java.lang.String.valueOf(f4));
        hashMap.put(KEY_POSITION_X, java.lang.String.valueOf(f));
        hashMap.put(KEY_POSITION_Y, java.lang.String.valueOf(f2));
        hashMap.put("rotation", java.lang.String.valueOf(f5));
        sendEvent(hashMap);
    }

    public void sendAddPasterEvent(com.aliyun.svideosdk.common.struct.effect.EffectSticker effectSticker, boolean z, java.lang.String str, float f) {
        java.util.HashMap<java.lang.String, java.lang.String> hashMap = new java.util.HashMap<>();
        hashMap.put("_interface", "addPaster");
        if (effectSticker != null) {
            hashMap.put(KEY_RESOURCE_PATH, effectSticker.getPath());
            hashMap.put(KEY_VID, java.lang.String.valueOf(effectSticker.getResId()));
        } else {
            hashMap.put(KEY_RESOURCE_PATH, "");
            hashMap.put(KEY_VID, "");
        }
        hashMap.put(KEY_INTERNAL_FACE_STATUS, java.lang.String.valueOf(z));
        hashMap.put(KEY_FACE_MODEL_PATH, str);
        hashMap.put(KEY_FACE_ROTATION, java.lang.String.valueOf(f));
        hashMap.put(KEY_POSITION_X, java.lang.String.valueOf(effectSticker.getXRadio()));
        hashMap.put(KEY_POSITION_Y, java.lang.String.valueOf(effectSticker.getYRadio()));
        hashMap.put(KEY_RESOURCE_WIDTH, java.lang.String.valueOf(effectSticker.getWidthRatio()));
        hashMap.put(KEY_RESOURCE_HEIGHT, java.lang.String.valueOf(effectSticker.getHeightRatio()));
        hashMap.put("rotation", java.lang.String.valueOf(effectSticker.getRotation()));
        hashMap.put(KEY_FLIP, java.lang.String.valueOf(effectSticker.isFlipH()));
        sendEvent(hashMap);
    }

    public void sendApplyAnimationFilterEvent(java.lang.String str, int i) {
        java.util.HashMap<java.lang.String, java.lang.String> hashMap = new java.util.HashMap<>();
        hashMap.put("_interface", "applyAnimationFilter");
        hashMap.put(KEY_RESOURCE_PATH, str);
        hashMap.put(KEY_VID, java.lang.String.valueOf(i));
        sendEvent(hashMap);
    }

    public void sendApplyFilterEvent(java.lang.String str) {
        java.util.HashMap<java.lang.String, java.lang.String> hashMap = new java.util.HashMap<>();
        hashMap.put("_interface", "applyFilter");
        hashMap.put(KEY_RESOURCE_PATH, str);
        sendEvent(hashMap);
    }

    public void sendApplyMvEvent(java.lang.String str) {
        java.util.HashMap<java.lang.String, java.lang.String> hashMap = new java.util.HashMap<>();
        hashMap.put("_interface", "applyMv");
        hashMap.put(KEY_RESOURCE_PATH, str);
        sendEvent(hashMap);
    }

    public void sendCameraInfoEvent(int i, float f) {
        java.util.HashMap<java.lang.String, java.lang.String> hashMap = new java.util.HashMap<>();
        hashMap.put("_deviceInfo", "cameraInfo");
        hashMap.put(KEY_CAMERA2_HARD_LEVEL, java.lang.String.valueOf(i));
        hashMap.put(KEY_CAMERA_MAX_LENS_ANGLE, java.lang.String.valueOf(f));
        sendEvent(2101, hashMap);
    }

    public void sendCancelRecordingEvent(java.lang.String str, long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, int i, float f, int i2) {
        java.util.HashMap<java.lang.String, java.lang.String> hashMap = new java.util.HashMap<>();
        hashMap.put("_interface", "cancelRecording");
        hashMap.put(KEY_RECORD_SID, str);
        hashMap.put(KEY_AVG_FPS, java.lang.String.valueOf(f));
        hashMap.put(KEY_SLOWLY_RENDER_COUNT, java.lang.String.valueOf(i2));
        hashMap.put(KEY_AVG_INNER_RENDER_COST, java.lang.String.valueOf(j));
        hashMap.put(KEY_MAX_INNER_RENDER_COST, java.lang.String.valueOf(j2));
        hashMap.put(KEY_AVG_OES_RENDER_COST, java.lang.String.valueOf(j3));
        hashMap.put(KEY_MAX_OES_RENDER_COST, java.lang.String.valueOf(j4));
        hashMap.put(KEY_AVG_T2D_RENDER_COST, java.lang.String.valueOf(j5));
        hashMap.put(KEY_MAX_T2D_RENDER_COST, java.lang.String.valueOf(j6));
        hashMap.put(KEY_AVG_ENCODER_RENDER_COST, java.lang.String.valueOf(j7));
        hashMap.put(KEY_MAX_ENCODER_RENDER_COST, java.lang.String.valueOf(j8));
        hashMap.put(KEY_FRAME_COUNT, java.lang.String.valueOf(i));
        sendEvent(hashMap);
    }

    public void sendDestroyEvent() {
        java.util.HashMap<java.lang.String, java.lang.String> hashMap = new java.util.HashMap<>();
        hashMap.put("_interface", "destroy");
        sendEvent(hashMap);
    }

    public int sendFinishPartUsetimeEvent(long j) {
        java.util.HashMap<java.lang.String, java.lang.String> hashMap = new java.util.HashMap<>();
        hashMap.put(KEY_USE_TIME, java.lang.String.valueOf(j));
        return sendEvent(2100, hashMap);
    }

    public void sendFinishRecordingEvent(long j) {
        java.util.HashMap<java.lang.String, java.lang.String> hashMap = new java.util.HashMap<>();
        hashMap.put("_interface", "finishRecording");
        hashMap.put(KEY_USE_TIME, java.lang.String.valueOf(j));
        sendEvent(hashMap);
    }

    public void sendMediaInfoEvent(com.aliyun.svideosdk.common.struct.recorder.MediaInfo mediaInfo) {
        java.lang.String str;
        java.util.HashMap<java.lang.String, java.lang.String> hashMap = new java.util.HashMap<>();
        hashMap.put("_interface", "setMediaInfo");
        if (mediaInfo != null) {
            hashMap.put(KEY_OUTPUT_VIDEO_WIDTH, java.lang.String.valueOf(mediaInfo.getVideoWidth()));
            hashMap.put(KEY_OUTPUT_VIDEO_HEIGHT, java.lang.String.valueOf(mediaInfo.getVideoHeight()));
            hashMap.put("crf", java.lang.String.valueOf(mediaInfo.getCrf()));
            hashMap.put("fps", java.lang.String.valueOf(mediaInfo.getFps()));
            hashMap.put(KEY_ENCODER_FPS, java.lang.String.valueOf(mediaInfo.getEncoderFps()));
            str = java.lang.String.valueOf(mediaInfo.getVideoCodec());
        } else {
            str = "";
            hashMap.put(KEY_OUTPUT_VIDEO_WIDTH, "");
            hashMap.put(KEY_OUTPUT_VIDEO_HEIGHT, "");
            hashMap.put("crf", "");
            hashMap.put("fps", "");
            hashMap.put(KEY_ENCODER_FPS, "");
        }
        hashMap.put(KEY_ENCODER_TYPE, str);
        sendEvent(hashMap);
    }

    public void sendNeedFaceTrackInternalEvent(boolean z) {
        java.util.HashMap<java.lang.String, java.lang.String> hashMap = new java.util.HashMap<>();
        hashMap.put("_interface", "needFaceTrackInternal");
        hashMap.put(KEY_FACE_TOGGLE, java.lang.String.valueOf(z));
        sendEvent(hashMap);
    }

    public void sendPauseMvEvent() {
        java.util.HashMap<java.lang.String, java.lang.String> hashMap = new java.util.HashMap<>();
        hashMap.put("_interface", "pauseMv");
        sendEvent(hashMap);
    }

    public void sendRemoveAnimationFilterEvent(int i) {
        java.util.HashMap<java.lang.String, java.lang.String> hashMap = new java.util.HashMap<>();
        hashMap.put("_interface", "removeAnimationFilter");
        hashMap.put(KEY_VID, java.lang.String.valueOf(i));
        sendEvent(hashMap);
    }

    public void sendRemoveFilterEvent() {
        java.util.HashMap<java.lang.String, java.lang.String> hashMap = new java.util.HashMap<>();
        hashMap.put("_interface", "removeFilter");
        sendEvent(hashMap);
    }

    public void sendRemoveImageEvent(int i) {
        java.util.HashMap<java.lang.String, java.lang.String> hashMap = new java.util.HashMap<>();
        hashMap.put("_interface", "removeImage");
        hashMap.put(KEY_VID, java.lang.String.valueOf(i));
        sendEvent(hashMap);
    }

    public void sendRemoveMusicEvent() {
        java.util.HashMap<java.lang.String, java.lang.String> hashMap = new java.util.HashMap<>();
        hashMap.put("_interface", "removeMusic");
        sendEvent(hashMap);
    }

    public void sendRemovePasterEvent(int i) {
        java.util.HashMap<java.lang.String, java.lang.String> hashMap = new java.util.HashMap<>();
        hashMap.put("_interface", "removePaster");
        hashMap.put(KEY_VID, java.lang.String.valueOf(i));
        sendEvent(hashMap);
    }

    public void sendResizePreviewSizeEvent(long j) {
        java.util.HashMap<java.lang.String, java.lang.String> hashMap = new java.util.HashMap<>();
        hashMap.put("_interface", "resizePreviewSize");
        hashMap.put(KEY_USE_TIME, java.lang.String.valueOf(j));
        sendEvent(hashMap);
    }

    public void sendRestartMvEvent() {
        java.util.HashMap<java.lang.String, java.lang.String> hashMap = new java.util.HashMap<>();
        hashMap.put("_interface", "restartMv");
        sendEvent(hashMap);
    }

    public void sendResumeMvEvent() {
        java.util.HashMap<java.lang.String, java.lang.String> hashMap = new java.util.HashMap<>();
        hashMap.put("_interface", "resumeMv");
        sendEvent(hashMap);
    }

    public void sendSetBeautyLevelEvent(int i) {
        java.util.HashMap<java.lang.String, java.lang.String> hashMap = new java.util.HashMap<>();
        hashMap.put("_interface", "setBeautyLevel");
        hashMap.put("beauty_level", java.lang.String.valueOf(i));
        sendEvent(hashMap);
    }

    public void sendSetBeautyStatusEvent(boolean z) {
        java.util.HashMap<java.lang.String, java.lang.String> hashMap = new java.util.HashMap<>();
        hashMap.put("_interface", "setBeautyStatus");
        hashMap.put("beauty_status", java.lang.String.valueOf(z));
        sendEvent(hashMap);
    }

    public void sendSetCameraParamEvent(com.aliyun.svideosdk.common.struct.recorder.CameraParam cameraParam) {
        java.lang.String str;
        java.util.HashMap<java.lang.String, java.lang.String> hashMap = new java.util.HashMap<>();
        hashMap.put("_interface", "setCameraParam");
        if (cameraParam != null) {
            hashMap.put(KEY_FLASH_TYPE, cameraParam.getFlashType());
            hashMap.put(KEY_ZOOM, java.lang.String.valueOf(cameraParam.getZoomRatio()));
            hashMap.put(KEY_FOCUS_MODE, java.lang.String.valueOf(cameraParam.getFocusMode()));
            str = java.lang.String.valueOf(cameraParam.getExposureCompensationRatio());
        } else {
            str = "";
            hashMap.put(KEY_FLASH_TYPE, "");
            hashMap.put(KEY_ZOOM, "");
            hashMap.put(KEY_FOCUS_MODE, "");
        }
        hashMap.put(KEY_EXPOSURE_COMPENSATION, str);
        sendEvent(hashMap);
    }

    public void sendSetCameraTypeEvent(com.aliyun.svideosdk.common.struct.recorder.CameraType cameraType) {
        java.util.HashMap<java.lang.String, java.lang.String> hashMap = new java.util.HashMap<>();
        hashMap.put("_interface", "setCameraType");
        hashMap.put(KEY_CAMERA_TYPE, java.lang.String.valueOf(cameraType));
        sendEvent(hashMap);
    }

    public void sendSetDisplayView(android.view.SurfaceView surfaceView) {
        java.util.HashMap<java.lang.String, java.lang.String> hashMap = new java.util.HashMap<>();
        hashMap.put("_interface", "setDisplayView");
        hashMap.put(KEY_DISPLAY_VIEW, surfaceView == null ? "" : surfaceView.toString());
        sendEvent(hashMap);
    }

    public void sendSetEffectViewEvent(float f, float f2, float f3, float f4, com.aliyun.svideosdk.common.struct.effect.EffectBase effectBase) {
        java.util.HashMap<java.lang.String, java.lang.String> hashMap = new java.util.HashMap<>();
        hashMap.put("_interface", "setEffectView");
        hashMap.put(KEY_VID, effectBase != null ? java.lang.String.valueOf(effectBase.getResId()) : "");
        hashMap.put(KEY_RESOURCE_WIDTH, java.lang.String.valueOf(f3));
        hashMap.put(KEY_RESOURCE_HEIGHT, java.lang.String.valueOf(f4));
        hashMap.put(KEY_POSITION_X, java.lang.String.valueOf(f));
        hashMap.put(KEY_POSITION_Y, java.lang.String.valueOf(f2));
        sendEvent(hashMap);
    }

    public void sendSetExposureCompensationEvent(float f) {
        java.util.HashMap<java.lang.String, java.lang.String> hashMap = new java.util.HashMap<>();
        hashMap.put("_interface", "setExposureCompensationRatio");
        hashMap.put(KEY_EXPOSURE_COMPENSATION, java.lang.String.valueOf(f));
        sendEvent(hashMap);
    }

    public void sendSetFaceDetectRotationEvent(int i) {
        java.util.HashMap<java.lang.String, java.lang.String> hashMap = new java.util.HashMap<>();
        hashMap.put("_interface", "setFaceDetectRotation");
        hashMap.put("rotation", java.lang.String.valueOf(i));
        sendEvent(hashMap);
    }

    public void sendSetFaceTrackInternalMaxFaceCountEvent(int i) {
        java.util.HashMap<java.lang.String, java.lang.String> hashMap = new java.util.HashMap<>();
        hashMap.put("_interface", "setFaceTrackInternalMaxFaceCount");
        hashMap.put(KEY_FACE_COUNT, java.lang.String.valueOf(i));
        sendEvent(hashMap);
    }

    public void sendSetFaceTrackInternalModelPathEvent(java.lang.String str) {
        java.util.HashMap<java.lang.String, java.lang.String> hashMap = new java.util.HashMap<>();
        hashMap.put("_interface", "setFaceTrackInternalModelPath");
        hashMap.put(KEY_FACE_MODEL_PATH, str);
        java.io.File file = new java.io.File(str + "/face_all_data_130.dat");
        hashMap.put(KEY_FILE_EXIST, java.lang.String.valueOf(file.exists()));
        hashMap.put("file_size", java.lang.String.valueOf(file.length()));
        sendEvent(hashMap);
    }

    public void sendSetFacesEvent(float[][] fArr) {
        java.util.HashMap<java.lang.String, java.lang.String> hashMap = new java.util.HashMap<>();
        hashMap.put("_interface", "setFaces");
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        for (int i = 0; i < fArr.length; i++) {
            sb.append("LEFT_EYE_X[");
            sb.append(i);
            sb.append("]=");
            sb.append(fArr[i][0]);
            sb.append("\n");
            sb.append("LEFT_EYE_Y[");
            sb.append(i);
            sb.append("]=");
            sb.append(fArr[i][1]);
            sb.append("\n");
            sb.append("RIGHT_EYE_X[");
            sb.append(i);
            sb.append("]=");
            sb.append(fArr[i][2]);
            sb.append("\n");
            sb.append("RIGHT_EYE_Y[");
            sb.append(i);
            sb.append("]=");
            sb.append(fArr[i][3]);
            sb.append("\n");
            sb.append("MOUTH_X[");
            sb.append(i);
            sb.append("]=");
            sb.append(fArr[i][4]);
            sb.append("\n");
            sb.append("MOUTH_Y[");
            sb.append(i);
            sb.append("]=");
            sb.append(fArr[i][5]);
            sb.append("\n");
        }
        hashMap.put(KEY_FACES, java.lang.String.valueOf(sb.toString()));
        sendEvent(hashMap);
    }

    public void sendSetFocusEvent(float f, float f2) {
        java.util.HashMap<java.lang.String, java.lang.String> hashMap = new java.util.HashMap<>();
        hashMap.put("_interface", "setFocus");
        hashMap.put(KEY_FOCUS_POINT_X, java.lang.String.valueOf(f));
        hashMap.put(KEY_FOCUS_POINT_Y, java.lang.String.valueOf(f2));
        sendEvent(hashMap);
    }

    public void sendSetFocusModeEvent(int i) {
        java.util.HashMap<java.lang.String, java.lang.String> hashMap = new java.util.HashMap<>();
        hashMap.put("_interface", "setFocusMode");
        hashMap.put(KEY_FOCUS_MODE, java.lang.String.valueOf(i));
        sendEvent(hashMap);
    }

    public void sendSetGopEvent(int i) {
        java.util.HashMap<java.lang.String, java.lang.String> hashMap = new java.util.HashMap<>();
        hashMap.put("_interface", "setGop");
        hashMap.put("gop", java.lang.String.valueOf(i));
        sendEvent(hashMap);
    }

    public void sendSetLightEvent(com.aliyun.svideosdk.common.struct.recorder.FlashType flashType, boolean z) {
        java.util.HashMap<java.lang.String, java.lang.String> hashMap = new java.util.HashMap<>();
        hashMap.put("_interface", "setLight");
        hashMap.put(KEY_FLASH_TYPE, java.lang.String.valueOf(flashType));
        hashMap.put("res", java.lang.String.valueOf(z));
        sendEvent(hashMap);
    }

    public void sendSetMusicEvent(java.lang.String str, long j, long j2) {
        java.util.HashMap<java.lang.String, java.lang.String> hashMap = new java.util.HashMap<>();
        hashMap.put("_interface", "setMusic");
        hashMap.put(KEY_RESOURCE_PATH, str);
        hashMap.put(KEY_STREAM_START_TIME, java.lang.String.valueOf(j));
        hashMap.put(KEY_STREAM_DURATION, java.lang.String.valueOf(j2));
        sendEvent(hashMap);
    }

    public void sendSetMuteEvent(boolean z) {
        java.util.HashMap<java.lang.String, java.lang.String> hashMap = new java.util.HashMap<>();
        hashMap.put("_interface", "setMute");
        hashMap.put("mute", java.lang.String.valueOf(z));
        sendEvent(hashMap);
    }

    public void sendSetOnFrameCallbackEvent(java.lang.Object obj) {
        java.util.HashMap<java.lang.String, java.lang.String> hashMap = new java.util.HashMap<>();
        hashMap.put("_interface", "setOnFrameCallback");
        hashMap.put(KEY_CALLBACK, java.lang.String.valueOf(obj));
        sendEvent(hashMap);
    }

    public void sendSetOutputPathEvent(java.lang.String str) {
        java.util.HashMap<java.lang.String, java.lang.String> hashMap = new java.util.HashMap<>();
        hashMap.put("_interface", "setOutputPath");
        hashMap.put(KEY_OUTPUT_PATH, str);
        sendEvent(hashMap);
    }

    public void sendSetPictureSizeEvent(int i, int i2, java.util.List<android.hardware.Camera.Size> list) {
        java.util.HashMap<java.lang.String, java.lang.String> hashMap = new java.util.HashMap<>();
        hashMap.put("_interface", "setPictureSize");
        hashMap.put("width", java.lang.String.valueOf(i));
        hashMap.put("height", java.lang.String.valueOf(i2));
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        for (android.hardware.Camera.Size size : list) {
            sb.append(size.width);
            sb.append("X");
            sb.append(size.height);
            sb.append(com.alipay.sdk.m.u.i.b);
        }
        hashMap.put(KEY_SUPPORTED_PIC_SIZE_LIST, sb.toString());
        sendEvent(hashMap);
    }

    public void sendSetPictureSizeEvent(com.aliyun.common.utils.Size size, java.util.SortedSet<com.aliyun.common.utils.Size> sortedSet) {
        java.util.HashMap<java.lang.String, java.lang.String> hashMap = new java.util.HashMap<>();
        hashMap.put("_interface", "setPictureSize");
        hashMap.put("width", java.lang.String.valueOf(size.getWidth()));
        hashMap.put("height", java.lang.String.valueOf(size.getHeight()));
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        for (com.aliyun.common.utils.Size size2 : sortedSet) {
            sb.append(size2.getWidth());
            sb.append("X");
            sb.append(size2.getHeight());
            sb.append(com.alipay.sdk.m.u.i.b);
        }
        hashMap.put(KEY_SUPPORTED_PIC_SIZE_LIST, sb.toString());
        sendEvent(hashMap);
    }

    public void sendSetRateEvent(float f) {
        java.util.HashMap<java.lang.String, java.lang.String> hashMap = new java.util.HashMap<>();
        hashMap.put("_interface", "setRate");
        hashMap.put(KEY_RATE, java.lang.String.valueOf(f));
        sendEvent(hashMap);
    }

    public void sendSetRecordCallbackEvent(java.lang.Object obj) {
        java.util.HashMap<java.lang.String, java.lang.String> hashMap = new java.util.HashMap<>();
        hashMap.put("_interface", "setRecordCallback");
        hashMap.put(KEY_CALLBACK, java.lang.String.valueOf(obj));
        sendEvent(hashMap);
    }

    public void sendSetRecordRotationEvent(int i) {
        java.util.HashMap<java.lang.String, java.lang.String> hashMap = new java.util.HashMap<>();
        hashMap.put("_interface", "setRecordRotation");
        hashMap.put("rotation", java.lang.String.valueOf(i));
        sendEvent(hashMap);
    }

    public void sendSetRotationEvent(int i) {
        java.util.HashMap<java.lang.String, java.lang.String> hashMap = new java.util.HashMap<>();
        hashMap.put("_interface", "setRotation");
        hashMap.put("rotation", java.lang.String.valueOf(i));
        sendEvent(hashMap);
    }

    public void sendSetVideoBitrateEvent(int i) {
        java.util.HashMap<java.lang.String, java.lang.String> hashMap = new java.util.HashMap<>();
        hashMap.put("_interface", "setVideoBitrate");
        hashMap.put(KEY_VIDEO_BITRATE, java.lang.String.valueOf(i));
        sendEvent(hashMap);
    }

    public void sendSetVideoQualityEvent(com.aliyun.svideosdk.common.struct.common.VideoQuality videoQuality) {
        java.util.HashMap<java.lang.String, java.lang.String> hashMap = new java.util.HashMap<>();
        hashMap.put("_interface", "setVideoQuality");
        hashMap.put(KEY_VIDEO_QUALITY, java.lang.String.valueOf(videoQuality));
        sendEvent(hashMap);
    }

    public void sendSetZoomEvent(float f) {
        java.util.HashMap<java.lang.String, java.lang.String> hashMap = new java.util.HashMap<>();
        hashMap.put("_interface", "setZoom");
        hashMap.put(KEY_ZOOM, java.lang.String.valueOf(f));
        sendEvent(hashMap);
    }

    public void sendStartPreviewEvent(java.lang.Object obj, int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        java.util.HashMap<java.lang.String, java.lang.String> hashMap = new java.util.HashMap<>();
        hashMap.put("_interface", "startPreview");
        hashMap.put(KEY_CALLBACK, java.lang.String.valueOf(obj));
        hashMap.put(KEY_CAPTURE_WIDTH, java.lang.String.valueOf(i));
        hashMap.put(KEY_CAPTURE_HEIGHT, java.lang.String.valueOf(i2));
        hashMap.put(KEY_TEXTURE_WIDTH, java.lang.String.valueOf(i3));
        hashMap.put(KEY_TEXTURE_HEIGHT, java.lang.String.valueOf(i4));
        hashMap.put(KEY_CAMERA_OPEN_RETURN, java.lang.String.valueOf(i5));
        hashMap.put("beauty_level", java.lang.String.valueOf(i6));
        hashMap.put(KEY_CAMERA_VERSION, java.lang.String.valueOf(i7));
        sendEvent(hashMap);
    }

    public void sendStartRecordingEvent(float f, int i, long j, long j2, long j3, long j4, long j5, long j6, int i2, int i3, int i4, int i5, int i6, com.aliyun.svideosdk.common.struct.encoder.VideoCodecs videoCodecs, com.aliyun.svideosdk.common.struct.common.VideoQuality videoQuality, int i7, int i8, java.lang.String str) {
        java.util.HashMap<java.lang.String, java.lang.String> hashMap = new java.util.HashMap<>();
        hashMap.put("_interface", "startRecording");
        hashMap.put(KEY_AVG_FPS, java.lang.String.valueOf(f));
        hashMap.put(KEY_SLOWLY_RENDER_COUNT, java.lang.String.valueOf(i));
        hashMap.put(KEY_AVG_INNER_RENDER_COST, java.lang.String.valueOf(j));
        hashMap.put(KEY_MAX_INNER_RENDER_COST, java.lang.String.valueOf(j2));
        hashMap.put(KEY_AVG_T2D_RENDER_COST, java.lang.String.valueOf(j5));
        hashMap.put(KEY_MAX_T2D_RENDER_COST, java.lang.String.valueOf(j6));
        hashMap.put(KEY_FRAME_COUNT, java.lang.String.valueOf(i2));
        hashMap.put(KEY_AVG_OES_RENDER_COST, java.lang.String.valueOf(j3));
        hashMap.put(KEY_MAX_OES_RENDER_COST, java.lang.String.valueOf(j4));
        hashMap.put(KEY_VIDEO_BITRATE, java.lang.String.valueOf(i3));
        hashMap.put("crf", java.lang.String.valueOf(i4));
        hashMap.put(KEY_ENCODER_FPS, java.lang.String.valueOf(i5));
        hashMap.put("gop", java.lang.String.valueOf(i6));
        hashMap.put(KEY_ENCODER_TYPE, java.lang.String.valueOf(videoCodecs));
        hashMap.put(KEY_VIDEO_QUALITY, java.lang.String.valueOf(videoQuality));
        hashMap.put(KEY_OUTPUT_VIDEO_WIDTH, java.lang.String.valueOf(i7));
        hashMap.put(KEY_OUTPUT_VIDEO_HEIGHT, java.lang.String.valueOf(i8));
        hashMap.put(KEY_RECORD_SID, str);
        sendEvent(hashMap);
    }

    public void sendStopPreviewEvent(float f, int i, long j, long j2, long j3, long j4, long j5, long j6, int i2) {
        java.util.HashMap<java.lang.String, java.lang.String> hashMap = new java.util.HashMap<>();
        hashMap.put("_interface", "stopPreview");
        hashMap.put(KEY_AVG_FPS, java.lang.String.valueOf(f));
        hashMap.put(KEY_SLOWLY_RENDER_COUNT, java.lang.String.valueOf(i));
        hashMap.put(KEY_AVG_INNER_RENDER_COST, java.lang.String.valueOf(j));
        hashMap.put(KEY_MAX_INNER_RENDER_COST, java.lang.String.valueOf(j2));
        hashMap.put(KEY_AVG_OES_RENDER_COST, java.lang.String.valueOf(j3));
        hashMap.put(KEY_MAX_OES_RENDER_COST, java.lang.String.valueOf(j4));
        hashMap.put(KEY_AVG_T2D_RENDER_COST, java.lang.String.valueOf(j5));
        hashMap.put(KEY_MAX_T2D_RENDER_COST, java.lang.String.valueOf(j6));
        hashMap.put(KEY_FRAME_COUNT, java.lang.String.valueOf(i2));
        sendEvent(hashMap);
    }

    public void sendStopRecordingEvent(java.lang.String str, long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, int i, float f, int i2) {
        java.util.HashMap<java.lang.String, java.lang.String> hashMap = new java.util.HashMap<>();
        hashMap.put("_interface", "stopRecording");
        hashMap.put(KEY_RECORD_SID, str);
        hashMap.put(KEY_AVG_FPS, java.lang.String.valueOf(f));
        hashMap.put(KEY_SLOWLY_RENDER_COUNT, java.lang.String.valueOf(i2));
        hashMap.put(KEY_AVG_INNER_RENDER_COST, java.lang.String.valueOf(j));
        hashMap.put(KEY_MAX_INNER_RENDER_COST, java.lang.String.valueOf(j2));
        hashMap.put(KEY_AVG_OES_RENDER_COST, java.lang.String.valueOf(j3));
        hashMap.put(KEY_MAX_OES_RENDER_COST, java.lang.String.valueOf(j4));
        hashMap.put(KEY_AVG_T2D_RENDER_COST, java.lang.String.valueOf(j5));
        hashMap.put(KEY_MAX_T2D_RENDER_COST, java.lang.String.valueOf(j6));
        hashMap.put(KEY_AVG_ENCODER_RENDER_COST, java.lang.String.valueOf(j7));
        hashMap.put(KEY_MAX_ENCODER_RENDER_COST, java.lang.String.valueOf(j8));
        hashMap.put(KEY_FRAME_COUNT, java.lang.String.valueOf(i));
        sendEvent(hashMap);
    }

    public void sendSwitchCameraEvent(int i, long j) {
        java.util.HashMap<java.lang.String, java.lang.String> hashMap = new java.util.HashMap<>();
        hashMap.put("_interface", "switchCamera");
        hashMap.put("res", java.lang.String.valueOf(i));
        hashMap.put(KEY_USE_TIME, java.lang.String.valueOf(j));
        sendEvent(hashMap);
    }

    public void sendSwitchLightEvent(com.aliyun.svideosdk.common.struct.recorder.FlashType flashType) {
        java.util.HashMap<java.lang.String, java.lang.String> hashMap = new java.util.HashMap<>();
        hashMap.put("_interface", "switchLight");
        hashMap.put("res", java.lang.String.valueOf(flashType));
        sendEvent(hashMap);
    }

    public void sendTakePhotoEvent() {
        java.util.HashMap<java.lang.String, java.lang.String> hashMap = new java.util.HashMap<>();
        hashMap.put("_interface", "takePhoto");
        sendEvent(hashMap);
    }

    public void sendTakePictureEvent() {
        java.util.HashMap<java.lang.String, java.lang.String> hashMap = new java.util.HashMap<>();
        hashMap.put("_interface", "takePicture");
        sendEvent(hashMap);
    }

    public void sendUpdateAnimationFilterEvent(java.lang.String str, int i) {
        java.util.HashMap<java.lang.String, java.lang.String> hashMap = new java.util.HashMap<>();
        hashMap.put("_interface", "updateAnimationFilter");
        hashMap.put(KEY_RESOURCE_PATH, str);
        hashMap.put(KEY_VID, java.lang.String.valueOf(i));
        sendEvent(hashMap);
    }

    public void updateSubModuleName(java.lang.String str) {
        com.aliyun.svideosdk.conan.event.AlivcEventReporter alivcEventReporter = this.mAlivcReporter;
        if (alivcEventReporter != null) {
            alivcEventReporter.setSubModuleName(str);
        }
    }
}
