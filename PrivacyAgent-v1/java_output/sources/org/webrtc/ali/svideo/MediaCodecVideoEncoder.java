package org.webrtc.ali.svideo;

@android.annotation.TargetApi(19)
/* loaded from: classes26.dex */
public class MediaCodecVideoEncoder {
    private static final int BITRATE_ADJUSTMENT_FPS = 30;
    private static final double BITRATE_CORRECTION_MAX_SCALE = 4.0d;
    private static final double BITRATE_CORRECTION_SEC = 3.0d;
    private static final int BITRATE_CORRECTION_STEPS = 20;
    public static final int COLOR_FormatYUV420Flexible = 2135033992;
    private static final int COLOR_QCOM_FORMATYUV420PackedSemiPlanar32m = 2141391876;
    private static final int DEQUEUE_TIMEOUT = 0;
    private static final java.lang.String[] H264_HW_EXCEPTION_MODELS;
    private static final java.lang.String[] H264_HW_QCOM_EXCEPTION_MODELS;
    private static final java.lang.String H264_MIME_TYPE = "video/avc";
    private static final java.lang.String HEVC_MIME_TYPE = "video/hevc";
    private static final java.lang.String[] INTERVAL_HW_EXCEPTION_MODELS;
    private static final int MAXIMUM_INITIAL_FPS = 30;
    private static final int MEDIA_CODEC_RELEASE_TIMEOUT_MS = 5000;
    private static final java.lang.String[] MTK_NO_ADJUSTMENT_MODELS;
    private static final float MULTI_BITRATE = 2.0f;
    private static final long QCOM_VP8_KEY_FRAME_INTERVAL_ANDROID_L_MS = 15000;
    private static final long QCOM_VP8_KEY_FRAME_INTERVAL_ANDROID_M_MS = 20000;
    private static final long QCOM_VP8_KEY_FRAME_INTERVAL_ANDROID_N_MS = 15000;
    private static final java.lang.String TAG = "MediaCodecVideoEncoder";
    private static final int VIDEO_AVCLevel3 = 256;
    private static final int VIDEO_AVCProfileHigh = 8;
    private static final java.lang.String VP8_MIME_TYPE = "video/x-vnd.on2.vp8";
    private static final java.lang.String VP9_MIME_TYPE = "video/x-vnd.on2.vp9";
    private static final org.webrtc.ali.svideo.MediaCodecVideoEncoder.MediaCodecProperties allwinnerH264HwProperties;
    private static final org.webrtc.ali.svideo.MediaCodecVideoEncoder.MediaCodecProperties amlogicH264HwProperties;
    private static int codecErrors;
    private static org.webrtc.ali.svideo.MediaCodecVideoEncoder.MediaCodecVideoEncoderErrorCallback errorCallback;
    private static final org.webrtc.ali.svideo.MediaCodecVideoEncoder.MediaCodecProperties exynosH264HighProfileHwProperties;
    private static final org.webrtc.ali.svideo.MediaCodecVideoEncoder.MediaCodecProperties exynosH264HwProperties;
    private static final org.webrtc.ali.svideo.MediaCodecVideoEncoder.MediaCodecProperties exynosVp8HwProperties;
    private static final org.webrtc.ali.svideo.MediaCodecVideoEncoder.MediaCodecProperties exynosVp9HwProperties;
    private static final org.webrtc.ali.svideo.MediaCodecVideoEncoder.MediaCodecProperties[] h264HighProfileHwList;
    private static final org.webrtc.ali.svideo.MediaCodecVideoEncoder.MediaCodecProperties[] h264HwList;
    private static java.util.Set<java.lang.String> hwEncoderDisabledTypes = new java.util.HashSet();
    private static final org.webrtc.ali.svideo.MediaCodecVideoEncoder.MediaCodecProperties intelVp8HwProperties;
    private static final org.webrtc.ali.svideo.MediaCodecVideoEncoder.MediaCodecProperties mtkH264HwProperties;
    private static final org.webrtc.ali.svideo.MediaCodecVideoEncoder.MediaCodecProperties qcomH264HwProperties;
    private static final org.webrtc.ali.svideo.MediaCodecVideoEncoder.MediaCodecProperties qcomVp8HwProperties;
    private static final org.webrtc.ali.svideo.MediaCodecVideoEncoder.MediaCodecProperties qcomVp9HwProperties;
    private static org.webrtc.ali.svideo.MediaCodecVideoEncoder runningInstance;
    private static final int[] supportedColorList;
    private static final java.lang.String[] supportedH264HighProfileHwCodecPrefixes;
    private static final java.lang.String[] supportedH264HwCodecPrefixes;
    private static final int[] supportedSurfaceColorList;
    private static final java.lang.String[] supportedVp8HwCodecPrefixes;
    private static final java.lang.String[] supportedVp9HwCodecPrefixes;
    private static final org.webrtc.ali.svideo.MediaCodecVideoEncoder.MediaCodecProperties[] vp9HwList;
    private double bitrateAccumulator;
    private double bitrateAccumulatorMax;
    private int bitrateAdjustmentScaleExp;
    private double bitrateObservationTimeMs;
    private int colorFormat;
    private org.webrtc.ali.svideo.GlRectDrawer drawer;
    private org.webrtc.ali.svideo.EglBase14 eglBase;
    private long forcedKeyFrameMs;
    private int height;
    private int initialFps;
    private int keyframe_interval;
    private long lastKeyFrameMs;
    private int latency;
    private int level;
    private android.media.MediaCodec mediaCodec;
    private java.lang.Thread mediaCodecThread;
    private java.nio.ByteBuffer[] outputBuffers;
    private int profile;
    private int targetBitrateBps;
    private int targetFps;
    private boolean texture_render_outside;
    private org.webrtc.ali.svideo.MediaCodecVideoEncoder.VideoCodecType type;
    private int width;
    private android.view.Surface inputSurface = null;
    private org.webrtc.ali.svideo.MediaCodecVideoEncoder.ProductCustomEncoderParam mProductParam = org.webrtc.ali.svideo.MediaCodecVideoEncoder.ProductCustomEncoderParam.kRTC;
    final android.media.MediaCodec.BufferInfo mDequeueBufferInfo = new android.media.MediaCodec.BufferInfo();
    private int last_set_bitrate_bps_ = 0;
    private long last_bitrate_log_time_ms_ = -1;
    private final int bitrate_log_interval_ms_ = 10000;
    private org.webrtc.ali.svideo.MediaCodecVideoEncoder.BitrateAdjustmentType bitrateAdjustmentType = org.webrtc.ali.svideo.MediaCodecVideoEncoder.BitrateAdjustmentType.NO_ADJUSTMENT;
    private java.nio.ByteBuffer configData = null;
    private boolean qcomExceptionModel = false;
    private org.webrtc.ali.svideo.MediaCodecVideoEncoder.ChipProperties chipProperties = null;

    /* renamed from: org.webrtc.ali.svideo.MediaCodecVideoEncoder$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {
        final /* synthetic */ org.webrtc.ali.svideo.MediaCodecVideoEncoder.C1CaughtException val$caughtException;
        final /* synthetic */ java.util.concurrent.CountDownLatch val$releaseDone;

        public AnonymousClass1(org.webrtc.ali.svideo.MediaCodecVideoEncoder.C1CaughtException c1CaughtException, java.util.concurrent.CountDownLatch countDownLatch) {
            this.val$caughtException = c1CaughtException;
            this.val$releaseDone = countDownLatch;
        }

        @Override // java.lang.Runnable
        public void run() {
            org.webrtc.svideo.utils.AlivcLog.c(org.webrtc.ali.svideo.MediaCodecVideoEncoder.TAG, "Java releaseEncoder on release thread");
            try {
                org.webrtc.ali.svideo.MediaCodecVideoEncoder.this.mediaCodec.stop();
            } catch (java.lang.Exception e) {
                org.webrtc.svideo.utils.AlivcLog.b(org.webrtc.ali.svideo.MediaCodecVideoEncoder.TAG, "Media encoder stop failed:" + e.getMessage());
            }
            try {
                org.webrtc.ali.svideo.MediaCodecVideoEncoder.this.mediaCodec.release();
            } catch (java.lang.Exception e2) {
                org.webrtc.svideo.utils.AlivcLog.b(org.webrtc.ali.svideo.MediaCodecVideoEncoder.TAG, "Media encoder release failed:" + e2.getMessage());
                this.val$caughtException.e = e2;
            }
            org.webrtc.svideo.utils.AlivcLog.c(org.webrtc.ali.svideo.MediaCodecVideoEncoder.TAG, "Java releaseEncoder on release thread done");
            this.val$releaseDone.countDown();
        }
    }

    /* renamed from: org.webrtc.ali.svideo.MediaCodecVideoEncoder$1CaughtException, reason: invalid class name */
    public class C1CaughtException {
        java.lang.Exception e;

        public C1CaughtException() {
        }
    }

    public enum BitrateAdjustmentType {
        NO_ADJUSTMENT,
        FRAMERATE_ADJUSTMENT,
        DYNAMIC_ADJUSTMENT,
        ACTUAL_FRAMERATE_ADJUSTMENT
    }

    public static class ChipProperties {
        public final int baseFrameRate;
        public final org.webrtc.ali.svideo.MediaCodecVideoEncoder.BitrateAdjustmentType bitrateAdjustmentType;
        public final java.lang.String chipName;
        public final int highProfileMinSdkVersion;
        public final int initFrameRate;
        public final boolean isNeedResetWhenDownBps;

        public ChipProperties(java.lang.String str, org.webrtc.ali.svideo.MediaCodecVideoEncoder.BitrateAdjustmentType bitrateAdjustmentType, boolean z, int i, int i2, int i3) {
            this.chipName = str;
            this.bitrateAdjustmentType = bitrateAdjustmentType;
            this.isNeedResetWhenDownBps = z;
            this.baseFrameRate = i;
            this.initFrameRate = i2;
            this.highProfileMinSdkVersion = i3;
        }
    }

    public static class EncoderProperties {
        public final java.lang.String codecName;
        public final int colorFormat;

        public EncoderProperties(java.lang.String str, int i) {
            this.codecName = str;
            this.colorFormat = i;
        }
    }

    public enum H264Profile {
        BASELINE(1),
        MAIN(2),
        CONSTRAINED_BASELINE(65536),
        CONSTRAINED_HIGH(524288),
        HIGH(8);

        private final int value;

        H264Profile(int i) {
            this.value = i;
        }

        public int getValue() {
            return this.value;
        }
    }

    public static class MediaCodecProperties {
        public final org.webrtc.ali.svideo.MediaCodecVideoEncoder.BitrateAdjustmentType bitrateAdjustmentType;
        public final java.lang.String codecPrefix;
        public final int minSdk;

        public MediaCodecProperties(java.lang.String str, int i, org.webrtc.ali.svideo.MediaCodecVideoEncoder.BitrateAdjustmentType bitrateAdjustmentType) {
            this.codecPrefix = str;
            this.minSdk = i;
            this.bitrateAdjustmentType = bitrateAdjustmentType;
        }
    }

    public interface MediaCodecVideoEncoderErrorCallback {
        void onMediaCodecVideoEncoderCriticalError(int i);
    }

    public static class OutputBufferInfo {
        public final java.nio.ByteBuffer buffer;
        public final boolean eos;
        public final int index;
        public final boolean isKeyFrame;
        public final long presentationTimestampUs;

        public OutputBufferInfo(int i, java.nio.ByteBuffer byteBuffer, boolean z, long j, boolean z2) {
            this.index = i;
            this.buffer = byteBuffer;
            this.isKeyFrame = z;
            this.presentationTimestampUs = j;
            this.eos = z2;
        }
    }

    public enum ProductCustomEncoderParam {
        kRTC(0),
        kRTS(1),
        kSVIDEO(2);

        private int mValue;

        ProductCustomEncoderParam(int i) {
            this.mValue = i;
        }

        public static org.webrtc.ali.svideo.MediaCodecVideoEncoder.ProductCustomEncoderParam toEnum(int i) {
            for (org.webrtc.ali.svideo.MediaCodecVideoEncoder.ProductCustomEncoderParam productCustomEncoderParam : values()) {
                if (productCustomEncoderParam.getValue() == i) {
                    return productCustomEncoderParam;
                }
            }
            throw new java.lang.RuntimeException("video encoder no match product enum");
        }

        public int getValue() {
            return this.mValue;
        }
    }

    public enum VideoCodecType {
        VIDEO_CODEC_UNKNOWN,
        VIDEO_CODEC_VP8,
        VIDEO_CODEC_VP9,
        VIDEO_CODEC_H264,
        VIDEO_CODEC_HEVC
    }

    static {
        org.webrtc.ali.svideo.MediaCodecVideoEncoder.BitrateAdjustmentType bitrateAdjustmentType = org.webrtc.ali.svideo.MediaCodecVideoEncoder.BitrateAdjustmentType.NO_ADJUSTMENT;
        qcomVp8HwProperties = new org.webrtc.ali.svideo.MediaCodecVideoEncoder.MediaCodecProperties("OMX.qcom.", 19, bitrateAdjustmentType);
        exynosVp8HwProperties = new org.webrtc.ali.svideo.MediaCodecVideoEncoder.MediaCodecProperties("OMX.Exynos.", 23, org.webrtc.ali.svideo.MediaCodecVideoEncoder.BitrateAdjustmentType.DYNAMIC_ADJUSTMENT);
        intelVp8HwProperties = new org.webrtc.ali.svideo.MediaCodecVideoEncoder.MediaCodecProperties("OMX.Intel.", 21, bitrateAdjustmentType);
        org.webrtc.ali.svideo.MediaCodecVideoEncoder.MediaCodecProperties mediaCodecProperties = new org.webrtc.ali.svideo.MediaCodecVideoEncoder.MediaCodecProperties("OMX.qcom.", 24, bitrateAdjustmentType);
        qcomVp9HwProperties = mediaCodecProperties;
        org.webrtc.ali.svideo.MediaCodecVideoEncoder.BitrateAdjustmentType bitrateAdjustmentType2 = org.webrtc.ali.svideo.MediaCodecVideoEncoder.BitrateAdjustmentType.FRAMERATE_ADJUSTMENT;
        org.webrtc.ali.svideo.MediaCodecVideoEncoder.MediaCodecProperties mediaCodecProperties2 = new org.webrtc.ali.svideo.MediaCodecVideoEncoder.MediaCodecProperties("OMX.Exynos.", 24, bitrateAdjustmentType2);
        exynosVp9HwProperties = mediaCodecProperties2;
        vp9HwList = new org.webrtc.ali.svideo.MediaCodecVideoEncoder.MediaCodecProperties[]{mediaCodecProperties, mediaCodecProperties2};
        org.webrtc.ali.svideo.MediaCodecVideoEncoder.MediaCodecProperties mediaCodecProperties3 = new org.webrtc.ali.svideo.MediaCodecVideoEncoder.MediaCodecProperties("OMX.qcom.", 19, bitrateAdjustmentType);
        qcomH264HwProperties = mediaCodecProperties3;
        org.webrtc.ali.svideo.MediaCodecVideoEncoder.MediaCodecProperties mediaCodecProperties4 = new org.webrtc.ali.svideo.MediaCodecVideoEncoder.MediaCodecProperties("OMX.Exynos.", 21, bitrateAdjustmentType2);
        exynosH264HwProperties = mediaCodecProperties4;
        org.webrtc.ali.svideo.MediaCodecVideoEncoder.MediaCodecProperties mediaCodecProperties5 = new org.webrtc.ali.svideo.MediaCodecVideoEncoder.MediaCodecProperties("OMX.allwinner.", 21, bitrateAdjustmentType);
        allwinnerH264HwProperties = mediaCodecProperties5;
        org.webrtc.ali.svideo.MediaCodecVideoEncoder.MediaCodecProperties mediaCodecProperties6 = new org.webrtc.ali.svideo.MediaCodecVideoEncoder.MediaCodecProperties("OMX.amlogic.", 21, bitrateAdjustmentType);
        amlogicH264HwProperties = mediaCodecProperties6;
        org.webrtc.ali.svideo.MediaCodecVideoEncoder.MediaCodecProperties mediaCodecProperties7 = new org.webrtc.ali.svideo.MediaCodecVideoEncoder.MediaCodecProperties("OMX.MTK.", 19, bitrateAdjustmentType);
        mtkH264HwProperties = mediaCodecProperties7;
        h264HwList = new org.webrtc.ali.svideo.MediaCodecVideoEncoder.MediaCodecProperties[]{mediaCodecProperties3, mediaCodecProperties4, mediaCodecProperties5, mediaCodecProperties6, mediaCodecProperties7};
        org.webrtc.ali.svideo.MediaCodecVideoEncoder.MediaCodecProperties mediaCodecProperties8 = new org.webrtc.ali.svideo.MediaCodecVideoEncoder.MediaCodecProperties("OMX.Exynos.", 23, bitrateAdjustmentType2);
        exynosH264HighProfileHwProperties = mediaCodecProperties8;
        h264HighProfileHwList = new org.webrtc.ali.svideo.MediaCodecVideoEncoder.MediaCodecProperties[]{mediaCodecProperties8};
        supportedVp8HwCodecPrefixes = new java.lang.String[]{"OMX.qcom.", "OMX.Intel.", "OMX.Exynos."};
        supportedVp9HwCodecPrefixes = new java.lang.String[]{"OMX.qcom.", "OMX.Exynos."};
        supportedH264HwCodecPrefixes = new java.lang.String[]{"OMX.qcom.", "OMX.Exynos.", "OMX.MTK.", "OMX.IMG.TOPAZ.", "OMX.hisi.", "OMX.k3.", "OMX.amlogic.", "OMX.rk.", "OMX.MS."};
        supportedH264HighProfileHwCodecPrefixes = new java.lang.String[]{"OMX.Exynos."};
        H264_HW_EXCEPTION_MODELS = new java.lang.String[]{"SAMSUNG-SGH-I337", "Nexus 7", "Nexus 4", "P6-C00", "HM 2A", "XT105", "XT109", "XT1060"};
        H264_HW_QCOM_EXCEPTION_MODELS = new java.lang.String[]{"mi note lte", "redmi note 4x", "1605-a01", "aosp on hammerhead", "lm-x210", "oppo r9s"};
        MTK_NO_ADJUSTMENT_MODELS = new java.lang.String[]{"vivo y83a", "vivo x21i", "vivo X21i A"};
        INTERVAL_HW_EXCEPTION_MODELS = new java.lang.String[]{"vivo X21A"};
        supportedColorList = new int[]{19, 21, 2141391872, COLOR_QCOM_FORMATYUV420PackedSemiPlanar32m, 39};
        supportedSurfaceColorList = new int[]{2130708361};
    }

    private static boolean checkMinSDKVersion(java.lang.String str) {
        if (str.startsWith("OMX.qcom.") || str.startsWith("OMX.MTK.") || str.startsWith("OMX.Exynos.") || str.startsWith("OMX.IMG.TOPAZ.")) {
            return true;
        }
        str.startsWith("OMX.k3.");
        return true;
    }

    private void checkOnMediaCodecThread() {
        if (this.mediaCodecThread.getId() == java.lang.Thread.currentThread().getId()) {
            return;
        }
        throw new java.lang.RuntimeException("MediaCodecVideoEncoder previously operated on " + this.mediaCodecThread + " but is now called on " + java.lang.Thread.currentThread());
    }

    private int convertBitRate(int i, int i2, float f) {
        int i3;
        if (this.mProductParam == org.webrtc.ali.svideo.MediaCodecVideoEncoder.ProductCustomEncoderParam.kSVIDEO) {
            return i * 1000;
        }
        org.webrtc.ali.svideo.MediaCodecVideoEncoder.ChipProperties chipProperties = this.chipProperties;
        if (chipProperties.bitrateAdjustmentType == org.webrtc.ali.svideo.MediaCodecVideoEncoder.BitrateAdjustmentType.FRAMERATE_ADJUSTMENT) {
            i3 = ((chipProperties.chipName.startsWith("OMX.rk.") ? i * 1000 : i * 9000) * this.chipProperties.baseFrameRate) / i2;
        } else {
            if (!chipProperties.chipName.startsWith("OMX.Exynos.")) {
                return i * 1000;
            }
            i3 = i * 900;
        }
        return (int) (i3 * f);
    }

    public static android.media.MediaCodec createByCodecName(java.lang.String str) {
        try {
            return android.media.MediaCodec.createByCodecName(str);
        } catch (java.lang.Exception unused) {
            return null;
        }
    }

    public static void disableH264HwCodec() {
        org.webrtc.svideo.utils.AlivcLog.e(TAG, "H.264 encoding is disabled by application.");
        hwEncoderDisabledTypes.add("video/avc");
    }

    public static void disableVp8HwCodec() {
        org.webrtc.svideo.utils.AlivcLog.e(TAG, "VP8 encoding is disabled by application.");
        hwEncoderDisabledTypes.add("video/x-vnd.on2.vp8");
    }

    public static void disableVp9HwCodec() {
        org.webrtc.svideo.utils.AlivcLog.e(TAG, "VP9 encoding is disabled by application.");
        hwEncoderDisabledTypes.add("video/x-vnd.on2.vp9");
    }

    private static org.webrtc.ali.svideo.MediaCodecVideoEncoder.EncoderProperties findHwEncoder(java.lang.String str, java.lang.String[] strArr, int[] iArr) {
        android.media.MediaCodecInfo mediaCodecInfo;
        java.lang.String str2;
        boolean z;
        if (str.equals("video/avc")) {
            java.util.List asList = java.util.Arrays.asList(H264_HW_EXCEPTION_MODELS);
            java.lang.String str3 = android.os.Build.MODEL;
            if (asList.contains(str3)) {
                org.webrtc.svideo.utils.AlivcLog.e(TAG, "Model: " + str3 + " has black listed H.264 encoder.");
                return null;
            }
        }
        for (int i = 0; i < android.media.MediaCodecList.getCodecCount(); i++) {
            try {
                mediaCodecInfo = android.media.MediaCodecList.getCodecInfoAt(i);
            } catch (java.lang.IllegalArgumentException e) {
                org.webrtc.svideo.utils.AlivcLog.b(TAG, "Cannot retrieve encoder codec info:" + e.getMessage());
                mediaCodecInfo = null;
            }
            if (mediaCodecInfo != null && mediaCodecInfo.isEncoder()) {
                java.lang.String[] supportedTypes = mediaCodecInfo.getSupportedTypes();
                int length = supportedTypes.length;
                int i2 = 0;
                while (true) {
                    if (i2 >= length) {
                        str2 = null;
                        break;
                    }
                    if (supportedTypes[i2].equals(str)) {
                        str2 = mediaCodecInfo.getName();
                        break;
                    }
                    i2++;
                }
                if (str2 != null && checkMinSDKVersion(str2)) {
                    org.webrtc.svideo.utils.AlivcLog.c(TAG, "Found candidate encoder " + str2);
                    int length2 = strArr.length;
                    int i3 = 0;
                    while (true) {
                        if (i3 >= length2) {
                            z = false;
                            break;
                        }
                        if (str2.startsWith(strArr[i3])) {
                            z = true;
                            break;
                        }
                        i3++;
                    }
                    if (z) {
                        try {
                            android.media.MediaCodecInfo.CodecCapabilities capabilitiesForType = mediaCodecInfo.getCapabilitiesForType(str);
                            for (int i4 : capabilitiesForType.colorFormats) {
                                org.webrtc.svideo.utils.AlivcLog.c(TAG, "   Color: 0x" + java.lang.Integer.toHexString(i4));
                            }
                            for (int i5 : iArr) {
                                for (int i6 : capabilitiesForType.colorFormats) {
                                    if (i6 == i5 && (!str2.startsWith("OMX.hisi.") || i6 != 19)) {
                                        org.webrtc.svideo.utils.AlivcLog.c(TAG, "Found target encoder for mime " + str + " : " + str2 + ". Color: 0x" + java.lang.Integer.toHexString(i6));
                                        return new org.webrtc.ali.svideo.MediaCodecVideoEncoder.EncoderProperties(str2, i6);
                                    }
                                }
                            }
                        } catch (java.lang.IllegalArgumentException e2) {
                            org.webrtc.svideo.utils.AlivcLog.b(TAG, "Cannot retrieve encoder capabilities:" + e2.getMessage());
                        }
                    } else {
                        continue;
                    }
                }
            }
        }
        return null;
    }

    private double getBitrateScale(int i) {
        return java.lang.Math.pow(BITRATE_CORRECTION_MAX_SCALE, i / 20.0d);
    }

    private org.webrtc.ali.svideo.MediaCodecVideoEncoder.ChipProperties getChipProperties(java.lang.String str, int i) {
        if (str.startsWith("OMX.qcom.")) {
            java.util.List asList = java.util.Arrays.asList(H264_HW_QCOM_EXCEPTION_MODELS);
            java.lang.String str2 = android.os.Build.MODEL;
            if (!asList.contains(str2.toLowerCase())) {
                this.qcomExceptionModel = false;
                return new org.webrtc.ali.svideo.MediaCodecVideoEncoder.ChipProperties(str, org.webrtc.ali.svideo.MediaCodecVideoEncoder.BitrateAdjustmentType.NO_ADJUSTMENT, false, i, i, 21);
            }
            org.webrtc.svideo.utils.AlivcLog.e(TAG, "Qcom Exception Model: " + str2);
            this.qcomExceptionModel = true;
            return new org.webrtc.ali.svideo.MediaCodecVideoEncoder.ChipProperties(str, org.webrtc.ali.svideo.MediaCodecVideoEncoder.BitrateAdjustmentType.NO_ADJUSTMENT, true, i, i, 21);
        }
        if (str.startsWith("OMX.MTK.")) {
            java.lang.String str3 = android.os.Build.HARDWARE;
            org.webrtc.svideo.utils.AlivcLog.c(TAG, "MTK hardware: " + str3);
            if (str3.equalsIgnoreCase("mt6763") || str3.equalsIgnoreCase("mt6763t")) {
                return new org.webrtc.ali.svideo.MediaCodecVideoEncoder.ChipProperties(str, org.webrtc.ali.svideo.MediaCodecVideoEncoder.BitrateAdjustmentType.NO_ADJUSTMENT, false, i, i, 21);
            }
            if (java.util.Arrays.asList(MTK_NO_ADJUSTMENT_MODELS).contains(android.os.Build.MODEL)) {
                return new org.webrtc.ali.svideo.MediaCodecVideoEncoder.ChipProperties(str, org.webrtc.ali.svideo.MediaCodecVideoEncoder.BitrateAdjustmentType.NO_ADJUSTMENT, false, i, i, 21);
            }
            boolean equalsIgnoreCase = str3.equalsIgnoreCase("mt6735");
            org.webrtc.ali.svideo.MediaCodecVideoEncoder.BitrateAdjustmentType bitrateAdjustmentType = org.webrtc.ali.svideo.MediaCodecVideoEncoder.BitrateAdjustmentType.ACTUAL_FRAMERATE_ADJUSTMENT;
            return equalsIgnoreCase ? new org.webrtc.ali.svideo.MediaCodecVideoEncoder.ChipProperties(str, bitrateAdjustmentType, false, i, i, Integer.MAX_VALUE) : new org.webrtc.ali.svideo.MediaCodecVideoEncoder.ChipProperties(str, bitrateAdjustmentType, false, i, i, 21);
        }
        if (str.startsWith("OMX.Exynos.")) {
            return android.os.Build.MODEL.equalsIgnoreCase("MX4 Pro") ? new org.webrtc.ali.svideo.MediaCodecVideoEncoder.ChipProperties(str, org.webrtc.ali.svideo.MediaCodecVideoEncoder.BitrateAdjustmentType.ACTUAL_FRAMERATE_ADJUSTMENT, false, i, i, Integer.MAX_VALUE) : new org.webrtc.ali.svideo.MediaCodecVideoEncoder.ChipProperties(str, org.webrtc.ali.svideo.MediaCodecVideoEncoder.BitrateAdjustmentType.FRAMERATE_ADJUSTMENT, false, 30, 30, 21);
        }
        if (str.startsWith("OMX.IMG.TOPAZ.")) {
            return android.os.Build.HARDWARE.equalsIgnoreCase("hi6250") ? new org.webrtc.ali.svideo.MediaCodecVideoEncoder.ChipProperties(str, org.webrtc.ali.svideo.MediaCodecVideoEncoder.BitrateAdjustmentType.ACTUAL_FRAMERATE_ADJUSTMENT, false, i, i, Integer.MAX_VALUE) : new org.webrtc.ali.svideo.MediaCodecVideoEncoder.ChipProperties(str, org.webrtc.ali.svideo.MediaCodecVideoEncoder.BitrateAdjustmentType.FRAMERATE_ADJUSTMENT, false, 30, 30, Integer.MAX_VALUE);
        }
        if (str.startsWith("OMX.hisi.")) {
            return new org.webrtc.ali.svideo.MediaCodecVideoEncoder.ChipProperties(str, org.webrtc.ali.svideo.MediaCodecVideoEncoder.BitrateAdjustmentType.ACTUAL_FRAMERATE_ADJUSTMENT, false, i, i, 23);
        }
        if (str.startsWith("OMX.k3.")) {
            return new org.webrtc.ali.svideo.MediaCodecVideoEncoder.ChipProperties(str, org.webrtc.ali.svideo.MediaCodecVideoEncoder.BitrateAdjustmentType.FRAMERATE_ADJUSTMENT, false, 30, 30, 21);
        }
        if (str.startsWith("OMX.amlogic.")) {
            org.webrtc.svideo.utils.AlivcLog.c(TAG, "getChipProperties for amlogic");
            return new org.webrtc.ali.svideo.MediaCodecVideoEncoder.ChipProperties(str, org.webrtc.ali.svideo.MediaCodecVideoEncoder.BitrateAdjustmentType.FRAMERATE_ADJUSTMENT, false, 30, 30, Integer.MAX_VALUE);
        }
        if (str.startsWith("OMX.rk.")) {
            return new org.webrtc.ali.svideo.MediaCodecVideoEncoder.ChipProperties(str, org.webrtc.ali.svideo.MediaCodecVideoEncoder.BitrateAdjustmentType.FRAMERATE_ADJUSTMENT, false, 30, 30, Integer.MAX_VALUE);
        }
        org.webrtc.svideo.utils.AlivcLog.c(TAG, "getChipProperties from unsupported chip list");
        return new org.webrtc.ali.svideo.MediaCodecVideoEncoder.ChipProperties(str, org.webrtc.ali.svideo.MediaCodecVideoEncoder.BitrateAdjustmentType.NO_ADJUSTMENT, false, i, i, 23);
    }

    public static boolean isH264HighProfileHwSupported() {
        return (hwEncoderDisabledTypes.contains("video/avc") || findHwEncoder("video/avc", supportedH264HighProfileHwCodecPrefixes, supportedColorList) == null) ? false : true;
    }

    public static boolean isH264HwSupported() {
        return (hwEncoderDisabledTypes.contains("video/avc") || findHwEncoder("video/avc", supportedH264HwCodecPrefixes, supportedColorList) == null) ? false : true;
    }

    public static boolean isH264HwSupportedUsingTextures() {
        return (hwEncoderDisabledTypes.contains("video/avc") || findHwEncoder("video/avc", supportedH264HwCodecPrefixes, supportedSurfaceColorList) == null) ? false : true;
    }

    public static boolean isVp8HwSupported() {
        return (hwEncoderDisabledTypes.contains("video/x-vnd.on2.vp8") || findHwEncoder("video/x-vnd.on2.vp8", supportedVp8HwCodecPrefixes, supportedColorList) == null) ? false : true;
    }

    public static boolean isVp8HwSupportedUsingTextures() {
        return (hwEncoderDisabledTypes.contains("video/x-vnd.on2.vp8") || findHwEncoder("video/x-vnd.on2.vp8", supportedVp8HwCodecPrefixes, supportedSurfaceColorList) == null) ? false : true;
    }

    public static boolean isVp9HwSupported() {
        return (hwEncoderDisabledTypes.contains("video/x-vnd.on2.vp9") || findHwEncoder("video/x-vnd.on2.vp9", supportedVp9HwCodecPrefixes, supportedColorList) == null) ? false : true;
    }

    public static boolean isVp9HwSupportedUsingTextures() {
        return (hwEncoderDisabledTypes.contains("video/x-vnd.on2.vp9") || findHwEncoder("video/x-vnd.on2.vp9", supportedVp9HwCodecPrefixes, supportedSurfaceColorList) == null) ? false : true;
    }

    public static void printStackTrace() {
        java.lang.Thread thread;
        org.webrtc.ali.svideo.MediaCodecVideoEncoder mediaCodecVideoEncoder = runningInstance;
        if (mediaCodecVideoEncoder == null || (thread = mediaCodecVideoEncoder.mediaCodecThread) == null) {
            return;
        }
        java.lang.StackTraceElement[] stackTrace = thread.getStackTrace();
        if (stackTrace.length > 0) {
            org.webrtc.svideo.utils.AlivcLog.a(TAG, "MediaCodecVideoEncoder stacks trace:");
            for (java.lang.StackTraceElement stackTraceElement : stackTrace) {
                org.webrtc.svideo.utils.AlivcLog.a(TAG, stackTraceElement.toString());
            }
        }
    }

    private void reportEncodedFrame(int i) {
        int i2 = this.targetFps;
        if (i2 == 0 || this.bitrateAdjustmentType != org.webrtc.ali.svideo.MediaCodecVideoEncoder.BitrateAdjustmentType.DYNAMIC_ADJUSTMENT) {
            return;
        }
        double d = i2;
        double d2 = this.bitrateAccumulator + (i - (this.targetBitrateBps / (8.0d * d)));
        this.bitrateAccumulator = d2;
        this.bitrateObservationTimeMs += 1000.0d / d;
        double d3 = this.bitrateAccumulatorMax * BITRATE_CORRECTION_SEC;
        double min = java.lang.Math.min(d2, d3);
        this.bitrateAccumulator = min;
        this.bitrateAccumulator = java.lang.Math.max(min, -d3);
        if (this.bitrateObservationTimeMs > 3000.0d) {
            org.webrtc.svideo.utils.AlivcLog.a(TAG, "Acc: " + ((int) this.bitrateAccumulator) + ". Max: " + ((int) this.bitrateAccumulatorMax) + ". ExpScale: " + this.bitrateAdjustmentScaleExp);
            double d4 = this.bitrateAccumulator;
            double d5 = this.bitrateAccumulatorMax;
            boolean z = true;
            if (d4 > d5) {
                this.bitrateAdjustmentScaleExp -= (int) ((d4 / d5) + 0.5d);
                this.bitrateAccumulator = d5;
            } else {
                double d6 = -d5;
                if (d4 < d6) {
                    this.bitrateAdjustmentScaleExp += (int) (((-d4) / d5) + 0.5d);
                    this.bitrateAccumulator = d6;
                } else {
                    z = false;
                }
            }
            if (z) {
                int min2 = java.lang.Math.min(this.bitrateAdjustmentScaleExp, 20);
                this.bitrateAdjustmentScaleExp = min2;
                this.bitrateAdjustmentScaleExp = java.lang.Math.max(min2, -20);
                org.webrtc.svideo.utils.AlivcLog.a(TAG, "Adjusting bitrate scale to " + this.bitrateAdjustmentScaleExp + ". Value: " + getBitrateScale(this.bitrateAdjustmentScaleExp));
                setRates(this.targetBitrateBps / 1000, this.targetFps);
            }
            this.bitrateObservationTimeMs = 0.0d;
        }
    }

    public static void setErrorCallback(org.webrtc.ali.svideo.MediaCodecVideoEncoder.MediaCodecVideoEncoderErrorCallback mediaCodecVideoEncoderErrorCallback) {
        org.webrtc.svideo.utils.AlivcLog.a(TAG, "Set error callback");
        errorCallback = mediaCodecVideoEncoderErrorCallback;
    }

    /*  JADX ERROR: ConcurrentModificationException in pass: ConstructorVisitor
        java.util.ConcurrentModificationException
        	at java.base/java.util.ArrayList$Itr.checkForComodification(ArrayList.java:1096)
        	at java.base/java.util.ArrayList$Itr.next(ArrayList.java:1050)
        	at jadx.core.dex.visitors.ConstructorVisitor.insertPhiInsn(ConstructorVisitor.java:139)
        	at jadx.core.dex.visitors.ConstructorVisitor.processInvoke(ConstructorVisitor.java:91)
        	at jadx.core.dex.visitors.ConstructorVisitor.replaceInvoke(ConstructorVisitor.java:56)
        	at jadx.core.dex.visitors.ConstructorVisitor.visit(ConstructorVisitor.java:42)
        */
    private boolean setRates(
    /*  JADX ERROR: ConcurrentModificationException in pass: ConstructorVisitor
        java.util.ConcurrentModificationException
        	at java.base/java.util.ArrayList$Itr.checkForComodification(ArrayList.java:1096)
        	at java.base/java.util.ArrayList$Itr.next(ArrayList.java:1050)
        	at jadx.core.dex.visitors.ConstructorVisitor.insertPhiInsn(ConstructorVisitor.java:139)
        	at jadx.core.dex.visitors.ConstructorVisitor.processInvoke(ConstructorVisitor.java:91)
        	at jadx.core.dex.visitors.ConstructorVisitor.replaceInvoke(ConstructorVisitor.java:56)
        */
    /*  JADX ERROR: Method generation error
        jadx.core.utils.exceptions.JadxRuntimeException: Code variable not set in r10v0 ??
        	at jadx.core.dex.instructions.args.SSAVar.getCodeVar(SSAVar.java:238)
        	at jadx.core.codegen.MethodGen.addMethodArguments(MethodGen.java:223)
        	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:168)
        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:401)
        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:301)
        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:184)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1597)
        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
        	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
        	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(ReferencePipeline.java:285)
        	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:571)
        	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:560)
        	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:151)
        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:174)
        	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:265)
        	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:636)
        	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:297)
        	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:286)
        	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:270)
        	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:161)
        	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:103)
        	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
        	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
        	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
        	at jadx.core.ProcessClass.process(ProcessClass.java:79)
        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:117)
        	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:402)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:390)
        	at jadx.core.dex.nodes.ClassNode.getCode(ClassNode.java:340)
        */

    public static org.webrtc.ali.svideo.MediaCodecVideoEncoder.EncoderProperties vp8HwEncoderProperties() {
        if (hwEncoderDisabledTypes.contains("video/x-vnd.on2.vp8")) {
            return null;
        }
        return findHwEncoder("video/x-vnd.on2.vp8", supportedVp8HwCodecPrefixes, supportedColorList);
    }

    private static org.webrtc.ali.svideo.MediaCodecVideoEncoder.MediaCodecProperties[] vp8HwList() {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        arrayList.add(qcomVp8HwProperties);
        arrayList.add(exynosVp8HwProperties);
        return (org.webrtc.ali.svideo.MediaCodecVideoEncoder.MediaCodecProperties[]) arrayList.toArray(new org.webrtc.ali.svideo.MediaCodecVideoEncoder.MediaCodecProperties[arrayList.size()]);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x002b  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x002e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void checkKeyFrameRequired(boolean z, long j) {
        boolean z2;
        long j2 = (j + 500) / 1000;
        if (this.lastKeyFrameMs < 0) {
            this.lastKeyFrameMs = j2;
        }
        if (!z) {
            long j3 = this.forcedKeyFrameMs;
            if (j3 > 0 && j2 > this.lastKeyFrameMs + j3) {
                z2 = true;
                if (!z || z2) {
                    org.webrtc.svideo.utils.AlivcLog.c(TAG, !z ? "Sync frame request" : "Sync frame forced");
                    android.os.Bundle bundle = new android.os.Bundle();
                    bundle.putInt("request-sync", 0);
                    this.mediaCodec.setParameters(bundle);
                    this.lastKeyFrameMs = j2;
                }
                return;
            }
        }
        z2 = false;
        if (z) {
        }
        org.webrtc.svideo.utils.AlivcLog.c(TAG, !z ? "Sync frame request" : "Sync frame forced");
        android.os.Bundle bundle2 = new android.os.Bundle();
        bundle2.putInt("request-sync", 0);
        this.mediaCodec.setParameters(bundle2);
        this.lastKeyFrameMs = j2;
    }

    public int dequeueInputBuffer() {
        checkOnMediaCodecThread();
        try {
            return this.mediaCodec.dequeueInputBuffer(0L);
        } catch (java.lang.Exception e) {
            org.webrtc.svideo.utils.AlivcLog.b(TAG, "dequeueIntputBuffer failed:" + e.getMessage());
            return -2;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x00c0 A[Catch: Exception -> 0x01c6, TryCatch #0 {Exception -> 0x01c6, blocks: (B:5:0x003d, B:7:0x0053, B:11:0x0060, B:15:0x00c0, B:19:0x00ec, B:21:0x00f3, B:23:0x00f9, B:25:0x00fd, B:27:0x0156, B:30:0x0160, B:32:0x016a, B:34:0x0172, B:36:0x0182, B:41:0x0195, B:45:0x01a5, B:50:0x01af, B:51:0x01c5), top: B:4:0x003d }] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0192  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0053 A[Catch: Exception -> 0x01c6, TryCatch #0 {Exception -> 0x01c6, blocks: (B:5:0x003d, B:7:0x0053, B:11:0x0060, B:15:0x00c0, B:19:0x00ec, B:21:0x00f3, B:23:0x00f9, B:25:0x00fd, B:27:0x0156, B:30:0x0160, B:32:0x016a, B:34:0x0172, B:36:0x0182, B:41:0x0195, B:45:0x01a5, B:50:0x01af, B:51:0x01c5), top: B:4:0x003d }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public org.webrtc.ali.svideo.MediaCodecVideoEncoder.OutputBufferInfo dequeueOutputBuffer() {
        int dequeueOutputBuffer;
        int i;
        org.webrtc.ali.svideo.MediaCodecVideoEncoder.VideoCodecType videoCodecType;
        checkOnMediaCodecThread();
        long j = this.last_bitrate_log_time_ms_;
        long nanoTime = java.lang.System.nanoTime() / 1000000;
        try {
            if (j >= 0) {
                if (nanoTime - this.last_bitrate_log_time_ms_ >= 10000) {
                    org.webrtc.svideo.utils.AlivcLog.c(TAG, "last set bitrate bps:" + this.last_set_bitrate_bps_);
                    nanoTime = java.lang.System.nanoTime() / 1000000;
                }
                this.mDequeueBufferInfo.set(0, 0, 0L, 0);
                dequeueOutputBuffer = this.mediaCodec.dequeueOutputBuffer(this.mDequeueBufferInfo, 0L);
                if (dequeueOutputBuffer >= 0) {
                    if ((this.mDequeueBufferInfo.flags & 2) != 0) {
                        org.webrtc.svideo.utils.AlivcLog.c(TAG, "Config frame generated. Offset: " + this.mDequeueBufferInfo.offset + ". Size: " + this.mDequeueBufferInfo.size);
                        this.configData = java.nio.ByteBuffer.allocateDirect(this.mDequeueBufferInfo.size);
                        this.outputBuffers[dequeueOutputBuffer].position(this.mDequeueBufferInfo.offset);
                        java.nio.ByteBuffer byteBuffer = this.outputBuffers[dequeueOutputBuffer];
                        android.media.MediaCodec.BufferInfo bufferInfo = this.mDequeueBufferInfo;
                        byteBuffer.limit(bufferInfo.offset + bufferInfo.size);
                        this.configData.put(this.outputBuffers[dequeueOutputBuffer]);
                        this.mediaCodec.releaseOutputBuffer(dequeueOutputBuffer, false);
                        dequeueOutputBuffer = this.mediaCodec.dequeueOutputBuffer(this.mDequeueBufferInfo, 0L);
                    }
                }
                i = dequeueOutputBuffer;
                if (i >= 0) {
                    if (i == -3) {
                        this.outputBuffers = this.mediaCodec.getOutputBuffers();
                        return dequeueOutputBuffer();
                    }
                    if (i == -2) {
                        return dequeueOutputBuffer();
                    }
                    if (i == -1) {
                        return null;
                    }
                    throw new java.lang.RuntimeException("dequeueOutputBuffer: " + i);
                }
                java.nio.ByteBuffer duplicate = this.outputBuffers[i].duplicate();
                duplicate.position(this.mDequeueBufferInfo.offset);
                android.media.MediaCodec.BufferInfo bufferInfo2 = this.mDequeueBufferInfo;
                duplicate.limit(bufferInfo2.offset + bufferInfo2.size);
                reportEncodedFrame(this.mDequeueBufferInfo.size);
                boolean z = (this.mDequeueBufferInfo.flags & 1) != 0;
                if (z) {
                    org.webrtc.svideo.utils.AlivcLog.c(TAG, "Sync frame generated");
                }
                if (!z || ((videoCodecType = this.type) != org.webrtc.ali.svideo.MediaCodecVideoEncoder.VideoCodecType.VIDEO_CODEC_H264 && videoCodecType != org.webrtc.ali.svideo.MediaCodecVideoEncoder.VideoCodecType.VIDEO_CODEC_HEVC)) {
                    return (this.mDequeueBufferInfo.flags & 4) != 0 ? new org.webrtc.ali.svideo.MediaCodecVideoEncoder.OutputBufferInfo(i, duplicate.slice(), z, this.mDequeueBufferInfo.presentationTimeUs, true) : new org.webrtc.ali.svideo.MediaCodecVideoEncoder.OutputBufferInfo(i, duplicate.slice(), z, this.mDequeueBufferInfo.presentationTimeUs, false);
                }
                org.webrtc.svideo.utils.AlivcLog.c(TAG, "Appending config frame of size " + this.configData.capacity() + " to output buffer with offset " + this.mDequeueBufferInfo.offset + ", size " + this.mDequeueBufferInfo.size);
                java.nio.ByteBuffer allocateDirect = java.nio.ByteBuffer.allocateDirect(this.configData.capacity() + this.mDequeueBufferInfo.size);
                this.configData.rewind();
                allocateDirect.put(this.configData);
                allocateDirect.put(duplicate);
                allocateDirect.position(0);
                android.media.MediaCodec.BufferInfo bufferInfo3 = this.mDequeueBufferInfo;
                return (bufferInfo3.flags & 4) != 0 ? new org.webrtc.ali.svideo.MediaCodecVideoEncoder.OutputBufferInfo(i, allocateDirect, z, bufferInfo3.presentationTimeUs, true) : new org.webrtc.ali.svideo.MediaCodecVideoEncoder.OutputBufferInfo(i, allocateDirect, z, bufferInfo3.presentationTimeUs, false);
            }
            this.mDequeueBufferInfo.set(0, 0, 0L, 0);
            dequeueOutputBuffer = this.mediaCodec.dequeueOutputBuffer(this.mDequeueBufferInfo, 0L);
            if (dequeueOutputBuffer >= 0) {
            }
            i = dequeueOutputBuffer;
            if (i >= 0) {
            }
        } catch (java.lang.Exception e) {
            org.webrtc.svideo.utils.AlivcLog.b(TAG, "dequeueOutputBuffer failed:" + e.getMessage());
            return new org.webrtc.ali.svideo.MediaCodecVideoEncoder.OutputBufferInfo(-1, null, false, -1L, false);
        }
        this.last_bitrate_log_time_ms_ = nanoTime;
    }

    public boolean encodeBuffer(boolean z, int i, int i2, long j) {
        checkOnMediaCodecThread();
        try {
            checkKeyFrameRequired(z, j);
            this.mediaCodec.queueInputBuffer(i, 0, i2, j, 0);
            return true;
        } catch (java.lang.Exception e) {
            org.webrtc.svideo.utils.AlivcLog.b(TAG, "encodeBuffer failed:" + e.getMessage());
            return false;
        }
    }

    public boolean encodeTexture(boolean z, int i, int i2, float[] fArr, long j) {
        checkOnMediaCodecThread();
        try {
            checkKeyFrameRequired(z, j);
            this.eglBase.makeCurrent();
            android.opengl.GLES20.glClear(16384);
            if (org.webrtc.ali.svideo.MediaCodecUtils.shouldDisableClientState()) {
                android.opengl.GLES10.glDisableClientState(32888);
            }
            if (i2 == org.webrtc.ali.svideo.GlRectDrawer.TextureType.TEXTURE_TYPE_OES.ordinal()) {
                org.webrtc.ali.svideo.GlRectDrawer glRectDrawer = this.drawer;
                int i3 = this.width;
                int i4 = this.height;
                glRectDrawer.drawOes(i, fArr, i3, i4, 0, 0, i3, i4);
            } else {
                if (i2 != org.webrtc.ali.svideo.GlRectDrawer.TextureType.TEXTURE_TYPE_2D.ordinal()) {
                    throw new java.lang.RuntimeException("encodeTexture failed with wrong textureType = " + i2);
                }
                org.webrtc.ali.svideo.GlRectDrawer glRectDrawer2 = this.drawer;
                int i5 = this.width;
                int i6 = this.height;
                glRectDrawer2.drawRgb(i, fArr, i5, i6, 0, 0, i5, i6);
            }
            this.eglBase.swapBuffers(java.util.concurrent.TimeUnit.MICROSECONDS.toNanos(j));
            return true;
        } catch (java.lang.RuntimeException e) {
            org.webrtc.svideo.utils.AlivcLog.b(TAG, "encodeTexture failed:" + e.getMessage());
            return false;
        }
    }

    public java.nio.ByteBuffer[] getInputBuffers() {
        java.nio.ByteBuffer[] inputBuffers = this.mediaCodec.getInputBuffers();
        org.webrtc.svideo.utils.AlivcLog.a(TAG, "Input buffers: " + inputBuffers.length);
        return inputBuffers;
    }

    /* JADX WARN: Code restructure failed: missing block: B:41:0x01ff, code lost:
    
        if (r4 > 23) goto L82;
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x02cf, code lost:
    
        if (r22 >= 0) goto L103;
     */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0149  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x017c  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x03b0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean initEncode(org.webrtc.ali.svideo.MediaCodecVideoEncoder.VideoCodecType videoCodecType, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, boolean z, org.webrtc.ali.svideo.EglBase14.Context context, int i11) {
        java.lang.String str;
        org.webrtc.ali.svideo.MediaCodecVideoEncoder.EncoderProperties encoderProperties;
        int i12;
        boolean z2;
        boolean z3;
        java.util.List asList;
        java.lang.String str2;
        long j;
        boolean z4 = context != null || z;
        this.texture_render_outside = z;
        org.webrtc.svideo.utils.AlivcLog.c(TAG, "Java initEncode: " + videoCodecType + ". Profile: " + i + ". Level:" + i2 + " : " + i3 + " : " + i6 + " x " + i7 + ". @ " + i8 + " kbps. Fps: " + i9 + ". bframes:" + i10 + ". gop:" + i5 + ". Encode from texture : " + z4 + ". render outside:" + z);
        this.profile = i;
        this.latency = i4;
        this.level = i2;
        this.width = i6;
        this.height = i7;
        this.keyframe_interval = i5;
        if (this.mediaCodecThread != null) {
            throw new java.lang.RuntimeException("Forgot to release()?");
        }
        this.mProductParam = org.webrtc.ali.svideo.MediaCodecVideoEncoder.ProductCustomEncoderParam.toEnum(i11);
        org.webrtc.ali.svideo.MediaCodecVideoEncoder.VideoCodecType videoCodecType2 = org.webrtc.ali.svideo.MediaCodecVideoEncoder.VideoCodecType.VIDEO_CODEC_VP8;
        if (videoCodecType == videoCodecType2) {
            str = "video/x-vnd.on2.vp8";
            encoderProperties = findHwEncoder("video/x-vnd.on2.vp8", supportedVp8HwCodecPrefixes, z4 ? supportedSurfaceColorList : supportedColorList);
        } else if (videoCodecType == org.webrtc.ali.svideo.MediaCodecVideoEncoder.VideoCodecType.VIDEO_CODEC_VP9) {
            encoderProperties = findHwEncoder("video/x-vnd.on2.vp9", supportedVp9HwCodecPrefixes, z4 ? supportedSurfaceColorList : supportedColorList);
            str = "video/x-vnd.on2.vp9";
        } else if (videoCodecType == org.webrtc.ali.svideo.MediaCodecVideoEncoder.VideoCodecType.VIDEO_CODEC_H264) {
            java.lang.String[] strArr = supportedH264HwCodecPrefixes;
            org.webrtc.ali.svideo.MediaCodecVideoEncoder.EncoderProperties findHwEncoder = findHwEncoder("video/avc", strArr, z4 ? supportedSurfaceColorList : supportedColorList);
            if (i == org.webrtc.ali.svideo.MediaCodecVideoEncoder.H264Profile.CONSTRAINED_HIGH.getValue() || i == org.webrtc.ali.svideo.MediaCodecVideoEncoder.H264Profile.HIGH.getValue()) {
                if (findHwEncoder("video/avc", strArr, z4 ? supportedSurfaceColorList : supportedColorList) != null) {
                    org.webrtc.svideo.utils.AlivcLog.c(TAG, "High profile H.264 encoder supported.");
                    z2 = true;
                    z3 = z2;
                    str = "video/avc";
                    encoderProperties = findHwEncoder;
                    i12 = 30;
                    boolean z5 = z4;
                    asList = java.util.Arrays.asList(INTERVAL_HW_EXCEPTION_MODELS);
                    str2 = android.os.Build.MODEL;
                    if (asList.contains(str2) && i12 >= 100) {
                        org.webrtc.svideo.utils.AlivcLog.c(TAG, "keyinterval: " + i12);
                        org.webrtc.svideo.utils.AlivcLog.c(TAG, "Model: " + str2 + " ,need to modify interval.");
                    }
                    if (encoderProperties != null) {
                        throw new java.lang.RuntimeException("Can not find HW encoder for " + videoCodecType);
                    }
                    runningInstance = this;
                    this.chipProperties = getChipProperties(encoderProperties.codecName, i9);
                    if (org.webrtc.ali.svideo.MediaCodecUtils.lessThanMinSizeToUseSoftwareEncoder(encoderProperties.codecName, i6, i7)) {
                        org.webrtc.svideo.utils.AlivcLog.c(TAG, "chip:" + encoderProperties.codecName + " is not support " + i6 + "x" + i7);
                        return false;
                    }
                    this.colorFormat = encoderProperties.colorFormat;
                    org.webrtc.ali.svideo.MediaCodecVideoEncoder.ChipProperties chipProperties = this.chipProperties;
                    org.webrtc.ali.svideo.MediaCodecVideoEncoder.BitrateAdjustmentType bitrateAdjustmentType = chipProperties.bitrateAdjustmentType;
                    this.bitrateAdjustmentType = bitrateAdjustmentType;
                    if (bitrateAdjustmentType == org.webrtc.ali.svideo.MediaCodecVideoEncoder.BitrateAdjustmentType.NO_ADJUSTMENT) {
                        this.targetFps = i9;
                    } else {
                        this.targetFps = chipProperties.initFrameRate;
                    }
                    this.initialFps = this.targetFps;
                    this.targetBitrateBps = convertBitRate(i8, i9, 2.0f);
                    this.forcedKeyFrameMs = 0L;
                    this.lastKeyFrameMs = -1L;
                    if (videoCodecType == videoCodecType2 && encoderProperties.codecName.startsWith(qcomVp8HwProperties.codecPrefix)) {
                        int i13 = android.os.Build.VERSION.SDK_INT;
                        if (i13 != 21 && i13 != 22) {
                            if (i13 == 23) {
                                j = 20000;
                                this.forcedKeyFrameMs = j;
                            }
                        }
                        j = 15000;
                        this.forcedKeyFrameMs = j;
                    }
                    this.bitrateAccumulatorMax = this.targetBitrateBps / 8.0d;
                    this.bitrateAccumulator = 0.0d;
                    this.bitrateObservationTimeMs = 0.0d;
                    this.bitrateAdjustmentScaleExp = 0;
                    org.webrtc.svideo.utils.AlivcLog.c(TAG, "Color format: " + this.colorFormat + ". Bitrate adjustment: " + this.bitrateAdjustmentType + ". Key frame interval: " + this.forcedKeyFrameMs + " . Initial fps: " + this.initialFps + ". targetBitrateBps: " + this.targetBitrateBps);
                    this.mediaCodecThread = java.lang.Thread.currentThread();
                    try {
                        android.media.MediaFormat createVideoFormat = android.media.MediaFormat.createVideoFormat(str, i6, i7);
                        if (videoCodecType == org.webrtc.ali.svideo.MediaCodecVideoEncoder.VideoCodecType.VIDEO_CODEC_H264) {
                            if (!z3 || android.os.Build.VERSION.SDK_INT < this.chipProperties.highProfileMinSdkVersion) {
                                org.webrtc.svideo.utils.AlivcLog.c(TAG, "Set 264 profile(" + i + ") and level(" + i2 + ")");
                                if (i >= 0) {
                                    createVideoFormat.setInteger(com.google.android.gms.common.Scopes.PROFILE, i);
                                }
                                if (i2 >= 0) {
                                    createVideoFormat.setInteger(com.aliyun.svideo.downloader.FileDownloaderModel.LEVEL, i2);
                                }
                            } else {
                                org.webrtc.svideo.utils.AlivcLog.c(TAG, "Set 264 profile(8) and level(4096), configureH264HighProfile = true");
                                createVideoFormat.setInteger(com.google.android.gms.common.Scopes.PROFILE, 8);
                                createVideoFormat.setInteger(com.aliyun.svideo.downloader.FileDownloaderModel.LEVEL, 4096);
                            }
                        } else if (videoCodecType == org.webrtc.ali.svideo.MediaCodecVideoEncoder.VideoCodecType.VIDEO_CODEC_HEVC) {
                            org.webrtc.svideo.utils.AlivcLog.c(TAG, "Set HEVC profile(" + i + ") and level(" + i2 + ")");
                            if (i >= 0) {
                                createVideoFormat.setInteger(com.google.android.gms.common.Scopes.PROFILE, i);
                            }
                        }
                        if (i3 >= 0) {
                            createVideoFormat.setInteger("bitrate-mode", i3);
                        }
                        createVideoFormat.setInteger("color-format", encoderProperties.colorFormat);
                        createVideoFormat.setInteger("frame-rate", this.initialFps);
                        createVideoFormat.setInteger("i-frame-interval", this.keyframe_interval);
                        createVideoFormat.setInteger(tv.danmaku.ijk.media.player.IjkMediaMeta.IJKM_KEY_BITRATE, this.targetBitrateBps);
                        if (android.os.Build.VERSION.SDK_INT >= 29) {
                            if (i10 > 0) {
                                createVideoFormat.setInteger("max-bframes", i10);
                            }
                            if (i4 > 0) {
                                createVideoFormat.setInteger(com.umeng.analytics.pro.bo.aZ, i4);
                            }
                        }
                        org.webrtc.svideo.utils.AlivcLog.c(TAG, "  Format: " + createVideoFormat);
                        android.media.MediaCodec createByCodecName = createByCodecName(encoderProperties.codecName);
                        this.mediaCodec = createByCodecName;
                        this.type = videoCodecType;
                        if (createByCodecName == null) {
                            org.webrtc.svideo.utils.AlivcLog.b(TAG, "Can not create media encoder");
                            release();
                            return false;
                        }
                        createByCodecName.configure(createVideoFormat, (android.view.Surface) null, (android.media.MediaCrypto) null, 1);
                        if (z5) {
                            if (z) {
                                this.inputSurface = this.mediaCodec.createInputSurface();
                            } else {
                                this.eglBase = new org.webrtc.ali.svideo.EglBase14(context, org.webrtc.ali.svideo.EglBase.CONFIG_RECORDABLE);
                                android.view.Surface createInputSurface = this.mediaCodec.createInputSurface();
                                this.inputSurface = createInputSurface;
                                this.eglBase.createSurface(createInputSurface);
                                this.drawer = new org.webrtc.ali.svideo.GlRectDrawer();
                            }
                        }
                        this.mediaCodec.start();
                        this.outputBuffers = this.mediaCodec.getOutputBuffers();
                        org.webrtc.svideo.utils.AlivcLog.c(TAG, "Output buffers: " + this.outputBuffers.length);
                        return true;
                    } catch (java.lang.Exception e) {
                        org.webrtc.svideo.utils.AlivcLog.b(TAG, "initEncode failed:" + e.getMessage());
                        release();
                        return false;
                    }
                }
                org.webrtc.svideo.utils.AlivcLog.c(TAG, "High profile H.264 encoder requested, but not supported. Use baseline.");
            }
            z2 = false;
            z3 = z2;
            str = "video/avc";
            encoderProperties = findHwEncoder;
            i12 = 30;
            boolean z52 = z4;
            asList = java.util.Arrays.asList(INTERVAL_HW_EXCEPTION_MODELS);
            str2 = android.os.Build.MODEL;
            if (asList.contains(str2)) {
                org.webrtc.svideo.utils.AlivcLog.c(TAG, "keyinterval: " + i12);
                org.webrtc.svideo.utils.AlivcLog.c(TAG, "Model: " + str2 + " ,need to modify interval.");
            }
            if (encoderProperties != null) {
            }
        } else {
            if (videoCodecType == org.webrtc.ali.svideo.MediaCodecVideoEncoder.VideoCodecType.VIDEO_CODEC_HEVC) {
                encoderProperties = findHwEncoder("video/hevc", supportedH264HwCodecPrefixes, z4 ? supportedSurfaceColorList : supportedColorList);
                str = "video/hevc";
            } else {
                str = null;
                encoderProperties = null;
            }
            i12 = 0;
            z3 = false;
            boolean z522 = z4;
            asList = java.util.Arrays.asList(INTERVAL_HW_EXCEPTION_MODELS);
            str2 = android.os.Build.MODEL;
            if (asList.contains(str2)) {
            }
            if (encoderProperties != null) {
            }
        }
        i12 = 100;
        z3 = false;
        boolean z5222 = z4;
        asList = java.util.Arrays.asList(INTERVAL_HW_EXCEPTION_MODELS);
        str2 = android.os.Build.MODEL;
        if (asList.contains(str2)) {
        }
        if (encoderProperties != null) {
        }
    }

    public void release() {
        org.webrtc.svideo.utils.AlivcLog.c(TAG, "Java releaseEncoder");
        checkOnMediaCodecThread();
        org.webrtc.ali.svideo.MediaCodecVideoEncoder.C1CaughtException c1CaughtException = new org.webrtc.ali.svideo.MediaCodecVideoEncoder.C1CaughtException();
        boolean z = false;
        if (this.mediaCodec != null) {
            java.util.concurrent.CountDownLatch countDownLatch = new java.util.concurrent.CountDownLatch(1);
            new java.lang.Thread(new org.webrtc.ali.svideo.MediaCodecVideoEncoder.AnonymousClass1(c1CaughtException, countDownLatch)).start();
            if (!org.webrtc.ali.svideo.ThreadUtils.awaitUninterruptibly(countDownLatch, 5000L)) {
                org.webrtc.svideo.utils.AlivcLog.b(TAG, "Media encoder release timeout");
                z = true;
            }
            this.mediaCodec = null;
        }
        this.mediaCodecThread = null;
        org.webrtc.ali.svideo.GlRectDrawer glRectDrawer = this.drawer;
        if (glRectDrawer != null) {
            glRectDrawer.release();
            this.drawer = null;
        }
        org.webrtc.ali.svideo.EglBase14 eglBase14 = this.eglBase;
        if (eglBase14 != null) {
            eglBase14.release();
            this.eglBase = null;
        }
        android.view.Surface surface = this.inputSurface;
        if (surface != null) {
            if (!this.texture_render_outside) {
                surface.release();
            }
            this.inputSurface = null;
        }
        runningInstance = null;
        if (!z) {
            if (c1CaughtException.e == null) {
                org.webrtc.svideo.utils.AlivcLog.c(TAG, "Java releaseEncoder done");
                return;
            } else {
                java.lang.RuntimeException runtimeException = new java.lang.RuntimeException(c1CaughtException.e);
                runtimeException.setStackTrace(org.webrtc.ali.svideo.ThreadUtils.concatStackTraces(c1CaughtException.e.getStackTrace(), runtimeException.getStackTrace()));
                throw runtimeException;
            }
        }
        codecErrors++;
        if (errorCallback != null) {
            org.webrtc.svideo.utils.AlivcLog.b(TAG, "Invoke codec error callback. Errors: " + codecErrors);
            errorCallback.onMediaCodecVideoEncoderCriticalError(codecErrors);
        }
        throw new java.lang.RuntimeException("Media encoder release timeout.");
    }

    public boolean releaseOutputBuffer(int i) {
        checkOnMediaCodecThread();
        try {
            this.mediaCodec.releaseOutputBuffer(i, false);
            return true;
        } catch (java.lang.Exception e) {
            org.webrtc.svideo.utils.AlivcLog.b(TAG, "releaseOutputBuffer failed:" + e.getMessage());
            return false;
        }
    }

    public int signalEndOfStream() {
        try {
            this.mediaCodec.signalEndOfInputStream();
            return 0;
        } catch (java.lang.Exception e) {
            org.webrtc.svideo.utils.AlivcLog.b(TAG, "signalEndOfStream failed:" + e.getMessage());
            return -1;
        }
    }
}
