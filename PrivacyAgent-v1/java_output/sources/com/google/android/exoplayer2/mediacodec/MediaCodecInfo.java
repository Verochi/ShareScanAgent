package com.google.android.exoplayer2.mediacodec;

/* loaded from: classes22.dex */
public final class MediaCodecInfo {
    public static final int MAX_SUPPORTED_INSTANCES_UNKNOWN = -1;
    public static final java.lang.String TAG = "MediaCodecInfo";
    public final boolean a;
    public final boolean adaptive;

    @androidx.annotation.Nullable
    public final android.media.MediaCodecInfo.CodecCapabilities capabilities;
    public final java.lang.String codecMimeType;
    public final boolean hardwareAccelerated;
    public final java.lang.String mimeType;
    public final java.lang.String name;
    public final boolean secure;
    public final boolean softwareOnly;
    public final boolean tunneling;
    public final boolean vendor;

    public MediaCodecInfo(java.lang.String str, java.lang.String str2, java.lang.String str3, @androidx.annotation.Nullable android.media.MediaCodecInfo.CodecCapabilities codecCapabilities, boolean z, boolean z2, boolean z3, boolean z4, boolean z5) {
        this.name = (java.lang.String) com.google.android.exoplayer2.util.Assertions.checkNotNull(str);
        this.mimeType = str2;
        this.codecMimeType = str3;
        this.capabilities = codecCapabilities;
        this.hardwareAccelerated = z;
        this.softwareOnly = z2;
        this.vendor = z3;
        boolean z6 = true;
        this.adaptive = (z4 || codecCapabilities == null || !f(codecCapabilities)) ? false : true;
        this.tunneling = codecCapabilities != null && j(codecCapabilities);
        if (!z5 && (codecCapabilities == null || !h(codecCapabilities))) {
            z6 = false;
        }
        this.secure = z6;
        this.a = com.google.android.exoplayer2.util.MimeTypes.isVideo(str2);
    }

    public static int a(java.lang.String str, java.lang.String str2, int i) {
        if (i > 1 || ((com.google.android.exoplayer2.util.Util.SDK_INT >= 26 && i > 0) || "audio/mpeg".equals(str2) || "audio/3gpp".equals(str2) || "audio/amr-wb".equals(str2) || "audio/mp4a-latm".equals(str2) || "audio/vorbis".equals(str2) || "audio/opus".equals(str2) || "audio/raw".equals(str2) || "audio/flac".equals(str2) || "audio/g711-alaw".equals(str2) || "audio/g711-mlaw".equals(str2) || "audio/gsm".equals(str2))) {
            return i;
        }
        int i2 = "audio/ac3".equals(str2) ? 6 : "audio/eac3".equals(str2) ? 16 : 30;
        java.lang.StringBuilder sb = new java.lang.StringBuilder(java.lang.String.valueOf(str).length() + 59);
        sb.append("AssumedMaxChannelAdjustment: ");
        sb.append(str);
        sb.append(", [");
        sb.append(i);
        sb.append(" to ");
        sb.append(i2);
        sb.append("]");
        com.google.android.exoplayer2.util.Log.w("MediaCodecInfo", sb.toString());
        return i2;
    }

    @androidx.annotation.RequiresApi(21)
    public static android.graphics.Point b(android.media.MediaCodecInfo.VideoCapabilities videoCapabilities, int i, int i2) {
        int widthAlignment = videoCapabilities.getWidthAlignment();
        int heightAlignment = videoCapabilities.getHeightAlignment();
        return new android.graphics.Point(com.google.android.exoplayer2.util.Util.ceilDivide(i, widthAlignment) * widthAlignment, com.google.android.exoplayer2.util.Util.ceilDivide(i2, heightAlignment) * heightAlignment);
    }

    @androidx.annotation.RequiresApi(21)
    public static boolean c(android.media.MediaCodecInfo.VideoCapabilities videoCapabilities, int i, int i2, double d) {
        android.graphics.Point b = b(videoCapabilities, i, i2);
        int i3 = b.x;
        int i4 = b.y;
        return (d == -1.0d || d < 1.0d) ? videoCapabilities.isSizeSupported(i3, i4) : videoCapabilities.areSizeAndRateSupported(i3, i4, java.lang.Math.floor(d));
    }

    public static final boolean d(java.lang.String str) {
        return ("OMX.MTK.VIDEO.DECODER.HEVC".equals(str) && "mcv5a".equals(com.google.android.exoplayer2.util.Util.DEVICE)) ? false : true;
    }

    @androidx.annotation.RequiresApi(23)
    public static int e(android.media.MediaCodecInfo.CodecCapabilities codecCapabilities) {
        int maxSupportedInstances;
        maxSupportedInstances = codecCapabilities.getMaxSupportedInstances();
        return maxSupportedInstances;
    }

    public static boolean f(android.media.MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return com.google.android.exoplayer2.util.Util.SDK_INT >= 19 && g(codecCapabilities);
    }

    @androidx.annotation.RequiresApi(19)
    public static boolean g(android.media.MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return codecCapabilities.isFeatureSupported("adaptive-playback");
    }

    public static boolean h(android.media.MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return com.google.android.exoplayer2.util.Util.SDK_INT >= 21 && i(codecCapabilities);
    }

    @androidx.annotation.RequiresApi(21)
    public static boolean i(android.media.MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return codecCapabilities.isFeatureSupported("secure-playback");
    }

    public static boolean j(android.media.MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return com.google.android.exoplayer2.util.Util.SDK_INT >= 21 && k(codecCapabilities);
    }

    @androidx.annotation.RequiresApi(21)
    public static boolean k(android.media.MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return codecCapabilities.isFeatureSupported("tunneled-playback");
    }

    public static com.google.android.exoplayer2.mediacodec.MediaCodecInfo newInstance(java.lang.String str, java.lang.String str2, java.lang.String str3, @androidx.annotation.Nullable android.media.MediaCodecInfo.CodecCapabilities codecCapabilities, boolean z, boolean z2, boolean z3, boolean z4, boolean z5) {
        return new com.google.android.exoplayer2.mediacodec.MediaCodecInfo(str, str2, str3, codecCapabilities, z, z2, z3, z4, z5);
    }

    @androidx.annotation.Nullable
    @androidx.annotation.RequiresApi(21)
    public android.graphics.Point alignVideoSizeV21(int i, int i2) {
        android.media.MediaCodecInfo.VideoCapabilities videoCapabilities;
        android.media.MediaCodecInfo.CodecCapabilities codecCapabilities = this.capabilities;
        if (codecCapabilities == null || (videoCapabilities = codecCapabilities.getVideoCapabilities()) == null) {
            return null;
        }
        return b(videoCapabilities, i, i2);
    }

    public int getMaxSupportedInstances() {
        android.media.MediaCodecInfo.CodecCapabilities codecCapabilities;
        if (com.google.android.exoplayer2.util.Util.SDK_INT < 23 || (codecCapabilities = this.capabilities) == null) {
            return -1;
        }
        return e(codecCapabilities);
    }

    public android.media.MediaCodecInfo.CodecProfileLevel[] getProfileLevels() {
        android.media.MediaCodecInfo.CodecProfileLevel[] codecProfileLevelArr;
        android.media.MediaCodecInfo.CodecCapabilities codecCapabilities = this.capabilities;
        return (codecCapabilities == null || (codecProfileLevelArr = codecCapabilities.profileLevels) == null) ? new android.media.MediaCodecInfo.CodecProfileLevel[0] : codecProfileLevelArr;
    }

    @androidx.annotation.RequiresApi(21)
    public boolean isAudioChannelCountSupportedV21(int i) {
        android.media.MediaCodecInfo.CodecCapabilities codecCapabilities = this.capabilities;
        if (codecCapabilities == null) {
            m("channelCount.caps");
            return false;
        }
        android.media.MediaCodecInfo.AudioCapabilities audioCapabilities = codecCapabilities.getAudioCapabilities();
        if (audioCapabilities == null) {
            m("channelCount.aCaps");
            return false;
        }
        if (a(this.name, this.mimeType, audioCapabilities.getMaxInputChannelCount()) >= i) {
            return true;
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder(33);
        sb.append("channelCount.support, ");
        sb.append(i);
        m(sb.toString());
        return false;
    }

    @androidx.annotation.RequiresApi(21)
    public boolean isAudioSampleRateSupportedV21(int i) {
        android.media.MediaCodecInfo.CodecCapabilities codecCapabilities = this.capabilities;
        if (codecCapabilities == null) {
            m("sampleRate.caps");
            return false;
        }
        android.media.MediaCodecInfo.AudioCapabilities audioCapabilities = codecCapabilities.getAudioCapabilities();
        if (audioCapabilities == null) {
            m("sampleRate.aCaps");
            return false;
        }
        if (audioCapabilities.isSampleRateSupported(i)) {
            return true;
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder(31);
        sb.append("sampleRate.support, ");
        sb.append(i);
        m(sb.toString());
        return false;
    }

    public boolean isCodecSupported(com.google.android.exoplayer2.Format format) {
        java.lang.String mediaMimeType;
        java.lang.String str = format.codecs;
        if (str == null || this.mimeType == null || (mediaMimeType = com.google.android.exoplayer2.util.MimeTypes.getMediaMimeType(str)) == null) {
            return true;
        }
        if (!this.mimeType.equals(mediaMimeType)) {
            java.lang.String str2 = format.codecs;
            java.lang.StringBuilder sb = new java.lang.StringBuilder(java.lang.String.valueOf(str2).length() + 13 + mediaMimeType.length());
            sb.append("codec.mime ");
            sb.append(str2);
            sb.append(", ");
            sb.append(mediaMimeType);
            m(sb.toString());
            return false;
        }
        android.util.Pair<java.lang.Integer, java.lang.Integer> codecProfileAndLevel = com.google.android.exoplayer2.mediacodec.MediaCodecUtil.getCodecProfileAndLevel(format);
        if (codecProfileAndLevel == null) {
            return true;
        }
        int intValue = ((java.lang.Integer) codecProfileAndLevel.first).intValue();
        int intValue2 = ((java.lang.Integer) codecProfileAndLevel.second).intValue();
        if (!this.a && intValue != 42) {
            return true;
        }
        for (android.media.MediaCodecInfo.CodecProfileLevel codecProfileLevel : getProfileLevels()) {
            if (codecProfileLevel.profile == intValue && codecProfileLevel.level >= intValue2) {
                return true;
            }
        }
        java.lang.String str3 = format.codecs;
        java.lang.StringBuilder sb2 = new java.lang.StringBuilder(java.lang.String.valueOf(str3).length() + 22 + mediaMimeType.length());
        sb2.append("codec.profileLevel, ");
        sb2.append(str3);
        sb2.append(", ");
        sb2.append(mediaMimeType);
        m(sb2.toString());
        return false;
    }

    public boolean isFormatSupported(com.google.android.exoplayer2.Format format) throws com.google.android.exoplayer2.mediacodec.MediaCodecUtil.DecoderQueryException {
        int i;
        if (!isCodecSupported(format)) {
            return false;
        }
        if (!this.a) {
            if (com.google.android.exoplayer2.util.Util.SDK_INT >= 21) {
                int i2 = format.sampleRate;
                if (i2 != -1 && !isAudioSampleRateSupportedV21(i2)) {
                    return false;
                }
                int i3 = format.channelCount;
                if (i3 != -1 && !isAudioChannelCountSupportedV21(i3)) {
                    return false;
                }
            }
            return true;
        }
        int i4 = format.width;
        if (i4 <= 0 || (i = format.height) <= 0) {
            return true;
        }
        if (com.google.android.exoplayer2.util.Util.SDK_INT >= 21) {
            return isVideoSizeAndRateSupportedV21(i4, i, format.frameRate);
        }
        boolean z = i4 * i <= com.google.android.exoplayer2.mediacodec.MediaCodecUtil.maxH264DecodableFrameSize();
        if (!z) {
            int i5 = format.width;
            int i6 = format.height;
            java.lang.StringBuilder sb = new java.lang.StringBuilder(40);
            sb.append("legacyFrameSize, ");
            sb.append(i5);
            sb.append("x");
            sb.append(i6);
            m(sb.toString());
        }
        return z;
    }

    public boolean isHdr10PlusOutOfBandMetadataSupported() {
        if (com.google.android.exoplayer2.util.Util.SDK_INT >= 29 && "video/x-vnd.on2.vp9".equals(this.mimeType)) {
            for (android.media.MediaCodecInfo.CodecProfileLevel codecProfileLevel : getProfileLevels()) {
                if (codecProfileLevel.profile == 16384) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isSeamlessAdaptationSupported(com.google.android.exoplayer2.Format format) {
        if (this.a) {
            return this.adaptive;
        }
        android.util.Pair<java.lang.Integer, java.lang.Integer> codecProfileAndLevel = com.google.android.exoplayer2.mediacodec.MediaCodecUtil.getCodecProfileAndLevel(format);
        return codecProfileAndLevel != null && ((java.lang.Integer) codecProfileAndLevel.first).intValue() == 42;
    }

    public boolean isSeamlessAdaptationSupported(com.google.android.exoplayer2.Format format, com.google.android.exoplayer2.Format format2, boolean z) {
        if (this.a) {
            return ((java.lang.String) com.google.android.exoplayer2.util.Assertions.checkNotNull(format.sampleMimeType)).equals(format2.sampleMimeType) && format.rotationDegrees == format2.rotationDegrees && (this.adaptive || (format.width == format2.width && format.height == format2.height)) && ((!z && format2.colorInfo == null) || com.google.android.exoplayer2.util.Util.areEqual(format.colorInfo, format2.colorInfo));
        }
        if ("audio/mp4a-latm".equals(this.mimeType) && ((java.lang.String) com.google.android.exoplayer2.util.Assertions.checkNotNull(format.sampleMimeType)).equals(format2.sampleMimeType) && format.channelCount == format2.channelCount && format.sampleRate == format2.sampleRate) {
            android.util.Pair<java.lang.Integer, java.lang.Integer> codecProfileAndLevel = com.google.android.exoplayer2.mediacodec.MediaCodecUtil.getCodecProfileAndLevel(format);
            android.util.Pair<java.lang.Integer, java.lang.Integer> codecProfileAndLevel2 = com.google.android.exoplayer2.mediacodec.MediaCodecUtil.getCodecProfileAndLevel(format2);
            if (codecProfileAndLevel != null && codecProfileAndLevel2 != null) {
                return ((java.lang.Integer) codecProfileAndLevel.first).intValue() == 42 && ((java.lang.Integer) codecProfileAndLevel2.first).intValue() == 42;
            }
        }
        return false;
    }

    @androidx.annotation.RequiresApi(21)
    public boolean isVideoSizeAndRateSupportedV21(int i, int i2, double d) {
        android.media.MediaCodecInfo.CodecCapabilities codecCapabilities = this.capabilities;
        if (codecCapabilities == null) {
            m("sizeAndRate.caps");
            return false;
        }
        android.media.MediaCodecInfo.VideoCapabilities videoCapabilities = codecCapabilities.getVideoCapabilities();
        if (videoCapabilities == null) {
            m("sizeAndRate.vCaps");
            return false;
        }
        if (c(videoCapabilities, i, i2, d)) {
            return true;
        }
        if (i < i2 && d(this.name) && c(videoCapabilities, i2, i, d)) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder(69);
            sb.append("sizeAndRate.rotated, ");
            sb.append(i);
            sb.append("x");
            sb.append(i2);
            sb.append("x");
            sb.append(d);
            l(sb.toString());
            return true;
        }
        java.lang.StringBuilder sb2 = new java.lang.StringBuilder(69);
        sb2.append("sizeAndRate.support, ");
        sb2.append(i);
        sb2.append("x");
        sb2.append(i2);
        sb2.append("x");
        sb2.append(d);
        m(sb2.toString());
        return false;
    }

    public final void l(java.lang.String str) {
        java.lang.String str2 = this.name;
        java.lang.String str3 = this.mimeType;
        java.lang.String str4 = com.google.android.exoplayer2.util.Util.DEVICE_DEBUG_INFO;
        java.lang.StringBuilder sb = new java.lang.StringBuilder(java.lang.String.valueOf(str).length() + 25 + java.lang.String.valueOf(str2).length() + java.lang.String.valueOf(str3).length() + java.lang.String.valueOf(str4).length());
        sb.append("AssumedSupport [");
        sb.append(str);
        sb.append("] [");
        sb.append(str2);
        sb.append(", ");
        sb.append(str3);
        sb.append("] [");
        sb.append(str4);
        sb.append("]");
        com.google.android.exoplayer2.util.Log.d("MediaCodecInfo", sb.toString());
    }

    public final void m(java.lang.String str) {
        java.lang.String str2 = this.name;
        java.lang.String str3 = this.mimeType;
        java.lang.String str4 = com.google.android.exoplayer2.util.Util.DEVICE_DEBUG_INFO;
        java.lang.StringBuilder sb = new java.lang.StringBuilder(java.lang.String.valueOf(str).length() + 20 + java.lang.String.valueOf(str2).length() + java.lang.String.valueOf(str3).length() + java.lang.String.valueOf(str4).length());
        sb.append("NoSupport [");
        sb.append(str);
        sb.append("] [");
        sb.append(str2);
        sb.append(", ");
        sb.append(str3);
        sb.append("] [");
        sb.append(str4);
        sb.append("]");
        com.google.android.exoplayer2.util.Log.d("MediaCodecInfo", sb.toString());
    }

    public java.lang.String toString() {
        return this.name;
    }
}
