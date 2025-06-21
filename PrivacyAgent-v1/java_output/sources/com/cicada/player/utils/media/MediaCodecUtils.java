package com.cicada.player.utils.media;

/* loaded from: classes22.dex */
public class MediaCodecUtils {
    private static final java.lang.String TAG = "MediaCodecUtils";
    private static java.util.List<android.media.MediaCodecInfo> allDecoders;

    public static synchronized java.util.List<android.media.MediaCodecInfo> getCodecInfos(java.lang.String str, boolean z, android.media.MediaFormat mediaFormat) {
        java.util.ArrayList arrayList;
        synchronized (com.cicada.player.utils.media.MediaCodecUtils.class) {
            if (allDecoders == null) {
                allDecoders = getDeviceDecodecs();
            }
            arrayList = new java.util.ArrayList();
            for (android.media.MediaCodecInfo mediaCodecInfo : allDecoders) {
                java.lang.String codecMimeType = getCodecMimeType(mediaCodecInfo, str);
                if (codecMimeType != null) {
                    android.media.MediaCodecInfo.CodecCapabilities capabilitiesForType = mediaCodecInfo.getCapabilitiesForType(codecMimeType);
                    if (isSecureSupport(z, capabilitiesForType, codecMimeType) && isFormatSupport(mediaFormat, capabilitiesForType, codecMimeType)) {
                        arrayList.add(mediaCodecInfo);
                    }
                }
            }
        }
        return arrayList;
    }

    private static java.lang.String getCodecMimeType(android.media.MediaCodecInfo mediaCodecInfo, java.lang.String str) {
        for (java.lang.String str2 : mediaCodecInfo.getSupportedTypes()) {
            if (str2.equalsIgnoreCase(str)) {
                return str2;
            }
        }
        return null;
    }

    private static java.util.List<android.media.MediaCodecInfo> getDeviceDecodecs() {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        for (android.media.MediaCodecInfo mediaCodecInfo : new android.media.MediaCodecList(1).getCodecInfos()) {
            if (!mediaCodecInfo.isEncoder()) {
                arrayList.add(mediaCodecInfo);
            }
        }
        return arrayList;
    }

    private static int getFormatInteger(android.media.MediaFormat mediaFormat, java.lang.String str, int i) {
        return mediaFormat.containsKey(str) ? mediaFormat.getInteger(str) : i;
    }

    public static synchronized boolean isDolbyAudioSupport() {
        boolean z;
        java.lang.String str;
        synchronized (com.cicada.player.utils.media.MediaCodecUtils.class) {
            com.cicada.player.utils.Logger.i(TAG, "isDolbyAudioSupport begin");
            boolean z2 = false;
            try {
                if (allDecoders == null) {
                    allDecoders = getDeviceDecodecs();
                }
                z = false;
                for (android.media.MediaCodecInfo mediaCodecInfo : allDecoders) {
                    try {
                        for (java.lang.String str2 : mediaCodecInfo.getSupportedTypes()) {
                            java.lang.String str3 = TAG;
                            com.cicada.player.utils.Logger.i(str3, "decoder mime:" + str2 + ", name:" + mediaCodecInfo.getName());
                            if (!str2.equals(com.google.android.exoplayer2.util.MimeTypes.AUDIO_AC4) && str2.equals("audio/eac3")) {
                                if (mediaCodecInfo.getCapabilitiesForType(str2) != null) {
                                    android.media.MediaCodecInfo.AudioCapabilities audioCapabilities = mediaCodecInfo.getCapabilitiesForType(str2).getAudioCapabilities();
                                    int[] supportedSampleRates = audioCapabilities.getSupportedSampleRates();
                                    if (audioCapabilities == null || supportedSampleRates == null) {
                                        str = "decoder mime:audio/eac3 getAudioCapabilities is null";
                                    } else {
                                        java.lang.String str4 = new java.lang.String("");
                                        for (int i : supportedSampleRates) {
                                            str4 = (str4 + java.lang.String.valueOf(i)) + ", ";
                                        }
                                        com.cicada.player.utils.Logger.i(TAG, "find dolby decodeer, cap:" + audioCapabilities.getMaxInputChannelCount() + "," + str4);
                                        z = true;
                                    }
                                } else {
                                    str = "decoder mime:audio/eac3 getCapabilitiesForType is null";
                                }
                                com.cicada.player.utils.Logger.e(str3, str);
                            }
                        }
                    } catch (java.lang.Exception e) {
                        e = e;
                        z2 = z;
                        com.cicada.player.utils.Logger.e(TAG, "found exception: " + e.getMessage());
                        z = z2;
                        return z;
                    }
                }
            } catch (java.lang.Exception e2) {
                e = e2;
            }
        }
        return z;
    }

    private static boolean isFormatSupport(android.media.MediaFormat mediaFormat, android.media.MediaCodecInfo.CodecCapabilities codecCapabilities, java.lang.String str) {
        boolean startsWith = str.startsWith("video");
        boolean startsWith2 = str.startsWith("audio");
        boolean z = false;
        if (!startsWith) {
            if (!startsWith2) {
                return false;
            }
            android.media.MediaCodecInfo.AudioCapabilities audioCapabilities = codecCapabilities.getAudioCapabilities();
            if (audioCapabilities == null) {
                com.cicada.player.utils.Logger.e(TAG, "audio format not support! audioCapabilities == null");
                return false;
            }
            int formatInteger = getFormatInteger(mediaFormat, "sample-rate", -1);
            int formatInteger2 = getFormatInteger(mediaFormat, "channel-count", -1);
            boolean z2 = formatInteger == -1 || audioCapabilities.isSampleRateSupported(formatInteger);
            int maxInputChannelCount = audioCapabilities.getMaxInputChannelCount();
            boolean z3 = z2 && (formatInteger2 == -1 || maxInputChannelCount >= formatInteger2);
            if (!z3) {
                com.cicada.player.utils.Logger.e(TAG, "audio format not support! sampleRate=" + formatInteger + ", supportedSampleRates=" + java.util.Arrays.toString(audioCapabilities.getSupportedSampleRates()) + ", channelCount=" + formatInteger2 + ", maxInputChannelCount=" + maxInputChannelCount);
            }
            return z3;
        }
        int formatInteger3 = getFormatInteger(mediaFormat, "width", -1);
        int formatInteger4 = getFormatInteger(mediaFormat, "height", -1);
        if (formatInteger3 <= 0 || formatInteger4 <= 0) {
            return true;
        }
        int max = java.lang.Math.max(formatInteger3, formatInteger4);
        int min = java.lang.Math.min(formatInteger3, formatInteger4);
        android.media.MediaCodecInfo.VideoCapabilities videoCapabilities = codecCapabilities.getVideoCapabilities();
        if (videoCapabilities == null) {
            com.cicada.player.utils.Logger.e(TAG, "video format not support! videoCapabilities == null");
            return false;
        }
        android.util.Range<java.lang.Integer> supportedWidths = videoCapabilities.getSupportedWidths();
        android.util.Range<java.lang.Integer> supportedHeights = videoCapabilities.getSupportedHeights();
        boolean contains = supportedWidths.contains((android.util.Range<java.lang.Integer>) java.lang.Integer.valueOf(max));
        boolean contains2 = supportedHeights.contains((android.util.Range<java.lang.Integer>) java.lang.Integer.valueOf(min));
        if (contains && contains2) {
            z = true;
        }
        if (!z) {
            com.cicada.player.utils.Logger.e(TAG, "video format not support! width[" + max + "] not in widthRange [" + supportedWidths.getLower() + ", " + supportedWidths.getUpper() + "] or height[" + min + "] not in heightRange[" + supportedHeights.getLower() + ", " + supportedHeights.getUpper() + "]");
        }
        if (z) {
            return z;
        }
        com.cicada.player.utils.Logger.w(TAG, "Still mark isFormatSupported = true, as some devices claim not support but can run actually");
        return true;
    }

    private static boolean isSecureSupport(boolean z, android.media.MediaCodecInfo.CodecCapabilities codecCapabilities, java.lang.String str) {
        boolean isFeatureSupported = codecCapabilities.isFeatureSupported("secure-playback");
        boolean isFeatureRequired = codecCapabilities.isFeatureRequired("secure-playback");
        if (z || !isFeatureRequired) {
            return !z || isFeatureSupported;
        }
        return false;
    }
}
