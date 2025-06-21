package org.webrtc.ali.svideo;

/* loaded from: classes26.dex */
class MediaCodecUtils {
    static final java.lang.String EXYNOS_PREFIX = "OMX.Exynos.";
    static final java.lang.String INTEL_PREFIX = "OMX.Intel.";
    static final java.lang.String NVIDIA_PREFIX = "OMX.Nvidia.";
    static final java.lang.String QCOM_PREFIX = "OMX.qcom.";
    private static final java.lang.String TAG = "MediaCodecUtils";
    static final int COLOR_QCOM_FORMATYVU420PackedSemiPlanar32m4ka = 2141391873;
    static final int COLOR_QCOM_FORMATYVU420PackedSemiPlanar16m4ka = 2141391874;
    static final int COLOR_QCOM_FORMATYVU420PackedSemiPlanar64x32Tile2m8ka = 2141391875;
    static final int COLOR_QCOM_FORMATYUV420PackedSemiPlanar32m = 2141391876;
    static final int[] DECODER_COLOR_FORMATS = {19, 21, 2141391872, COLOR_QCOM_FORMATYVU420PackedSemiPlanar32m4ka, COLOR_QCOM_FORMATYVU420PackedSemiPlanar16m4ka, COLOR_QCOM_FORMATYVU420PackedSemiPlanar64x32Tile2m8ka, COLOR_QCOM_FORMATYUV420PackedSemiPlanar32m};
    static final int[] ENCODER_COLOR_FORMATS = {19, 21, 2141391872, COLOR_QCOM_FORMATYUV420PackedSemiPlanar32m};

    private MediaCodecUtils() {
    }

    public static boolean codecSupportsType(android.media.MediaCodecInfo mediaCodecInfo, org.webrtc.ali.svideo.VideoCodecType videoCodecType) {
        for (java.lang.String str : mediaCodecInfo.getSupportedTypes()) {
            if (videoCodecType.mimeType().equals(str)) {
                return true;
            }
        }
        return false;
    }

    public static boolean lessThanMinSizeToUseSoftwareDecoder(java.lang.String str, int i, int i2) {
        return str.startsWith("OMX.hisi.") && (i <= 128 || i2 <= 128);
    }

    public static boolean lessThanMinSizeToUseSoftwareEncoder(java.lang.String str, int i, int i2) {
        return str.startsWith("OMX.MTK.") && (i <= 128 || i2 <= 96) && (i2 <= 128 || i <= 96);
    }

    public static java.lang.Integer selectColorFormat(int[] iArr, android.media.MediaCodecInfo.CodecCapabilities codecCapabilities) {
        for (int i : iArr) {
            for (int i2 : codecCapabilities.colorFormats) {
                if (i2 == i) {
                    return java.lang.Integer.valueOf(i2);
                }
            }
        }
        return null;
    }

    public static boolean shouldDisableClientState() {
        java.lang.String str = android.os.Build.MODEL;
        return ("16s Pro".equalsIgnoreCase(str) && com.igexin.assist.util.AssistUtils.BRAND_MZ.equalsIgnoreCase(android.os.Build.BRAND)) || ("Redmi Note 5A".equalsIgnoreCase(str) && com.igexin.assist.util.AssistUtils.BRAND_XIAOMI.equalsIgnoreCase(android.os.Build.BRAND));
    }
}
