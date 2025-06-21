package com.aliyun.common.log.reporter;

/* loaded from: classes.dex */
public class AlivcReporterBase {
    private static final boolean CLOSE_EVENT = false;
    protected static final java.lang.String KEY_AUDIO_DURATION = "audioDuration";
    protected static final java.lang.String KEY_BITRATE = "bitrate";
    protected static final java.lang.String KEY_COLOR = "color";
    protected static final java.lang.String KEY_CRF = "crf";
    protected static final java.lang.String KEY_DEVICE_INFO = "_deviceInfo";
    protected static final java.lang.String KEY_DURATION = "duration";
    protected static final java.lang.String KEY_END_TIME = "endTime";
    protected static final java.lang.String KEY_ERROR_CODE = "errorCode";
    protected static final java.lang.String KEY_FONT = "font";
    protected static final java.lang.String KEY_FORMAT = "format";
    protected static final java.lang.String KEY_FRAME_RATE = "fps";
    protected static final java.lang.String KEY_GOP = "gop";
    protected static final java.lang.String KEY_HEIGHT = "height";
    protected static final java.lang.String KEY_ID = "id";
    protected static final java.lang.String KEY_INTERFACE = "_interface";
    protected static final java.lang.String KEY_MIRROR = "mirror";
    protected static final java.lang.String KEY_MUTE = "mute";
    protected static final java.lang.String KEY_OUTPUT_PATH = "outputPath";
    protected static final java.lang.String KEY_PATH = "path";
    protected static final java.lang.String KEY_POSTION_X = "posX";
    protected static final java.lang.String KEY_POSTION_Y = "posY";
    protected static final java.lang.String KEY_ROTATION = "rotation";
    protected static final java.lang.String KEY_SCALE_RATE = "scaleRate";
    protected static final java.lang.String KEY_SIZE = "size";
    protected static final java.lang.String KEY_START_TIME = "startTime";
    protected static final java.lang.String KEY_TEXT = "text";
    protected static final java.lang.String KEY_TIMESTAMP = "timestamp";
    protected static final java.lang.String KEY_TYPE = "type";
    protected static final java.lang.String KEY_VIDEO_CODEC = "videoCodec";
    protected static final java.lang.String KEY_VIDEO_DISPLAY_MODE = "videoDisplayMode";
    protected static final java.lang.String KEY_VIDEO_DURATION = "videoDuration";
    protected static final java.lang.String KEY_VIDEO_QUALITY = "videoQuality";
    protected static final java.lang.String KEY_VOLUME = "volume";
    protected static final java.lang.String KEY_WIDTH = "width";
    protected com.aliyun.svideosdk.conan.event.AlivcEventReporter mAlivcReporter;
    protected int mEventId;
    protected boolean mDestroyed = false;
    protected boolean mEventSending = false;

    public long getReportId() {
        com.aliyun.svideosdk.conan.event.AlivcEventReporter alivcEventReporter = this.mAlivcReporter;
        if (alivcEventReporter != null) {
            return alivcEventReporter.getEventReporterId();
        }
        return 0L;
    }

    public void release() {
        this.mDestroyed = true;
        com.aliyun.svideosdk.conan.event.AlivcEventReporter alivcEventReporter = this.mAlivcReporter;
        if (alivcEventReporter == null || this.mEventSending) {
            return;
        }
        alivcEventReporter.destory();
        this.mAlivcReporter = null;
    }

    public int sendEvent(int i, java.util.HashMap<java.lang.String, java.lang.String> hashMap) {
        com.aliyun.svideosdk.conan.event.AlivcEventReporter alivcEventReporter = this.mAlivcReporter;
        if (alivcEventReporter == null) {
            return -4;
        }
        int sendEvent = alivcEventReporter.sendEvent(i, hashMap);
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("sendEvent ");
        sb.append(i);
        sb.append(" result is ");
        sb.append(sendEvent);
        return sendEvent;
    }

    public int sendEvent(java.util.HashMap<java.lang.String, java.lang.String> hashMap) {
        com.aliyun.svideosdk.conan.event.AlivcEventReporter alivcEventReporter = this.mAlivcReporter;
        if (alivcEventReporter == null) {
            return -4;
        }
        int sendEvent = alivcEventReporter.sendEvent(this.mEventId, hashMap);
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("sendEvent result is ");
        sb.append(sendEvent);
        return sendEvent;
    }
}
