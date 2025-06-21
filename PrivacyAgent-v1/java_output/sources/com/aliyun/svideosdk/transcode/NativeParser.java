package com.aliyun.svideosdk.transcode;

/* loaded from: classes12.dex */
public class NativeParser extends com.aliyun.svideosdk.nativeload.AbstractNativeLoader {
    public static final int AUDIO_BIT_RATE = 20;
    public static final int AUDIO_CHANNELS = 21;
    public static final int AUDIO_CODEC = 16;
    public static final int AUDIO_DURATION = 18;
    public static final int AUDIO_FORAMT = 23;
    public static final int AUDIO_FRAME_COUNT = 19;
    public static final int AUDIO_FRAME_SAMPLES = 24;
    public static final int AUDIO_SAMPLE_RATE = 22;
    public static final int AUDIO_START_TIME = 17;
    public static final int AUDIO_STREAM_DIC_KEY_START = 15;
    public static final int AUDIO_STREAM_INDEX = 15;
    public static final int DIC_KEY_END = 30;
    public static final int FILE_BIT_RATE = 29;
    public static final int FILE_DIC_KEY_START = 25;
    public static final int FILE_DURATION = 28;
    public static final int FILE_FORMAT = 26;
    public static final int FILE_NAME = 25;
    public static final int FILE_START_TIME = 27;
    private static final java.util.ArrayList<java.lang.String> SUPPORTED_COLOR_FORMAT_LIST;
    public static final java.lang.String VALUE_WRONG = "unknown";
    public static final int VIDEO_BIT_RATE = 5;
    public static final int VIDEO_CODEC = 1;
    public static final int VIDEO_CODEC_HEIGHT = 9;
    public static final int VIDEO_CODEC_WIDTH = 8;
    public static final int VIDEO_DURATION = 3;
    public static final int VIDEO_FORMAT = 10;
    public static final int VIDEO_FPS = 13;
    public static final int VIDEO_FRAME_COUNT = 4;
    public static final int VIDEO_GOP = 11;
    public static final int VIDEO_HEIGHT = 7;
    public static final int VIDEO_MAX_BFRAME = 12;
    public static final int VIDEO_ROTATION = 14;
    public static final int VIDEO_START_TIME = 2;
    public static final int VIDEO_STREAM_DIC_KEY_START = 0;
    public static final int VIDEO_STREAM_INDEX = 0;
    public static final int VIDEO_WIDTH = 6;
    private long dic;

    static {
        java.util.ArrayList<java.lang.String> arrayList = new java.util.ArrayList<>();
        SUPPORTED_COLOR_FORMAT_LIST = arrayList;
        arrayList.add("rgba64be");
        arrayList.add("yuvj422p");
        arrayList.add("yuv444p");
        arrayList.add("yuvj444p");
        arrayList.add("yuvj420p");
        arrayList.add("yuv420p");
        arrayList.add("nv12");
        arrayList.add("nv21");
        arrayList.add("bgra");
        arrayList.add("rgba");
        arrayList.add("argb");
        arrayList.add("bgr24");
        arrayList.add("rgb24");
        arrayList.add("pal8");
    }

    public NativeParser() {
        this.dic = 0L;
        this.dic = nativeCreate();
    }

    private native boolean nativeCheckBFrame(long j);

    private native boolean nativeCheckInvertAvailable(long j);

    private native long nativeCreate();

    private native void nativeDispose(long j);

    private native int nativeGetMaxGopSize(long j);

    private native java.lang.String nativeGetValue(long j, int i);

    private native int nativeInit(long j, java.lang.String str);

    private native void nativePrint(long j);

    private native void nativeRelease(long j);

    public boolean checkBFrame() {
        return nativeCheckBFrame(this.dic);
    }

    public boolean checkIfSupportedImage(java.lang.String str) {
        java.lang.String mimeType;
        if (!new java.io.File(str).exists() || (mimeType = com.aliyun.common.utils.FileUtils.getMimeType(str)) == null || !mimeType.contains("image")) {
            return false;
        }
        if (!mimeType.contains(com.aliyun.auth.common.AliyunVodHttpCommon.ImageExt.IMAGEEXT_JPEG) && !mimeType.contains(com.aliyun.auth.common.AliyunVodHttpCommon.ImageExt.IMAGEEXT_JPG) && !mimeType.contains("gif") && mimeType.contains(com.aliyun.auth.common.AliyunVodHttpCommon.ImageExt.IMAGEEXT_PNG)) {
            java.lang.String value = getValue(10);
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("Color format:");
            sb.append(value);
            if (!value.contains("yuv420p") && !value.contains("yuv444p")) {
                return SUPPORTED_COLOR_FORMAT_LIST.contains(value);
            }
        }
        return true;
    }

    public boolean checkInvertAvailable() {
        return nativeCheckInvertAvailable(this.dic);
    }

    public void dispose() {
        nativeDispose(this.dic);
    }

    public int getMaxGopSize() {
        return nativeGetMaxGopSize(this.dic);
    }

    public java.lang.String getValue(int i) {
        return (i < 0 || i >= 30) ? "unknown" : nativeGetValue(this.dic, i);
    }

    public int init(java.lang.String str) {
        com.aliyun.common.utils.Assert.assertEquals(java.lang.Boolean.FALSE, java.lang.Boolean.valueOf(android.text.TextUtils.isEmpty(str)));
        return nativeInit(this.dic, str);
    }

    public void print() {
        nativePrint(this.dic);
    }

    public void release() {
        nativeRelease(this.dic);
    }
}
