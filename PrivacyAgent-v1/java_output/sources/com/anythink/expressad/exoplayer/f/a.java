package com.anythink.expressad.exoplayer.f;

@android.annotation.TargetApi(16)
/* loaded from: classes12.dex */
public final class a {
    public static final java.lang.String a = "MediaCodecInfo";
    public static final int b = -1;
    public final java.lang.String c;

    @androidx.annotation.Nullable
    public final java.lang.String d;

    @androidx.annotation.Nullable
    public final android.media.MediaCodecInfo.CodecCapabilities e;
    public final boolean f;
    public final boolean g;
    public final boolean h;
    public final boolean i;

    /* JADX WARN: Code restructure failed: missing block: B:28:0x005c, code lost:
    
        if ((com.anythink.expressad.exoplayer.k.af.a >= 21 && r3.isFeatureSupported("secure-playback")) != false) goto L37;
     */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x004b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private a(java.lang.String str, @androidx.annotation.Nullable java.lang.String str2, @androidx.annotation.Nullable android.media.MediaCodecInfo.CodecCapabilities codecCapabilities, boolean z, boolean z2, boolean z3) {
        boolean z4;
        boolean z5;
        this.c = (java.lang.String) com.anythink.expressad.exoplayer.k.a.a(str);
        this.d = str2;
        this.e = codecCapabilities;
        this.i = z;
        boolean z6 = true;
        if (!z2 && codecCapabilities != null) {
            if (com.anythink.expressad.exoplayer.k.af.a >= 19 && codecCapabilities.isFeatureSupported("adaptive-playback")) {
                z4 = true;
                this.f = z4;
                if (codecCapabilities != null) {
                    if (com.anythink.expressad.exoplayer.k.af.a >= 21 && codecCapabilities.isFeatureSupported("tunneled-playback")) {
                        z5 = true;
                        this.g = z5;
                        if (!z3) {
                            if (codecCapabilities != null) {
                            }
                            z6 = false;
                        }
                        this.h = z6;
                    }
                }
                z5 = false;
                this.g = z5;
                if (!z3) {
                }
                this.h = z6;
            }
        }
        z4 = false;
        this.f = z4;
        if (codecCapabilities != null) {
        }
        z5 = false;
        this.g = z5;
        if (!z3) {
        }
        this.h = z6;
    }

    private static int a(java.lang.String str, java.lang.String str2, int i) {
        if (i > 1 || ((com.anythink.expressad.exoplayer.k.af.a >= 26 && i > 0) || "audio/mpeg".equals(str2) || "audio/3gpp".equals(str2) || "audio/amr-wb".equals(str2) || "audio/mp4a-latm".equals(str2) || "audio/vorbis".equals(str2) || "audio/opus".equals(str2) || "audio/raw".equals(str2) || "audio/flac".equals(str2) || "audio/g711-alaw".equals(str2) || "audio/g711-mlaw".equals(str2) || "audio/gsm".equals(str2))) {
            return i;
        }
        int i2 = "audio/ac3".equals(str2) ? 6 : "audio/eac3".equals(str2) ? 16 : 30;
        java.lang.StringBuilder sb = new java.lang.StringBuilder("AssumedMaxChannelAdjustment: ");
        sb.append(str);
        sb.append(", [");
        sb.append(i);
        sb.append(" to ");
        sb.append(i2);
        sb.append("]");
        return i2;
    }

    public static com.anythink.expressad.exoplayer.f.a a(java.lang.String str) {
        return new com.anythink.expressad.exoplayer.f.a(str, null, null, true, false, false);
    }

    private static com.anythink.expressad.exoplayer.f.a a(java.lang.String str, java.lang.String str2, android.media.MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return new com.anythink.expressad.exoplayer.f.a(str, str2, codecCapabilities, false, false, false);
    }

    public static com.anythink.expressad.exoplayer.f.a a(java.lang.String str, java.lang.String str2, android.media.MediaCodecInfo.CodecCapabilities codecCapabilities, boolean z, boolean z2) {
        return new com.anythink.expressad.exoplayer.f.a(str, str2, codecCapabilities, false, z, z2);
    }

    private static boolean a(android.media.MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return com.anythink.expressad.exoplayer.k.af.a >= 19 && codecCapabilities.isFeatureSupported("adaptive-playback");
    }

    @android.annotation.TargetApi(21)
    private static boolean a(android.media.MediaCodecInfo.VideoCapabilities videoCapabilities, int i, int i2, double d) {
        return (d == -1.0d || d <= 0.0d) ? videoCapabilities.isSizeSupported(i, i2) : videoCapabilities.areSizeAndRateSupported(i, i2, d);
    }

    private int b() {
        android.media.MediaCodecInfo.CodecCapabilities codecCapabilities;
        int maxSupportedInstances;
        if (com.anythink.expressad.exoplayer.k.af.a < 23 || (codecCapabilities = this.e) == null) {
            return -1;
        }
        maxSupportedInstances = codecCapabilities.getMaxSupportedInstances();
        return maxSupportedInstances;
    }

    @android.annotation.TargetApi(19)
    private static boolean b(android.media.MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return codecCapabilities.isFeatureSupported("adaptive-playback");
    }

    private void c(java.lang.String str) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder("NoSupport [");
        sb.append(str);
        sb.append("] [");
        sb.append(this.c);
        sb.append(", ");
        sb.append(this.d);
        sb.append("] [");
        sb.append(com.anythink.expressad.exoplayer.k.af.e);
        sb.append("]");
    }

    private static boolean c(android.media.MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return com.anythink.expressad.exoplayer.k.af.a >= 21 && codecCapabilities.isFeatureSupported("tunneled-playback");
    }

    private void d(java.lang.String str) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder("AssumedSupport [");
        sb.append(str);
        sb.append("] [");
        sb.append(this.c);
        sb.append(", ");
        sb.append(this.d);
        sb.append("] [");
        sb.append(com.anythink.expressad.exoplayer.k.af.e);
        sb.append("]");
    }

    @android.annotation.TargetApi(21)
    private static boolean d(android.media.MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return codecCapabilities.isFeatureSupported("tunneled-playback");
    }

    private static boolean e(android.media.MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return com.anythink.expressad.exoplayer.k.af.a >= 21 && codecCapabilities.isFeatureSupported("secure-playback");
    }

    @android.annotation.TargetApi(21)
    private static boolean f(android.media.MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return codecCapabilities.isFeatureSupported("secure-playback");
    }

    @android.annotation.TargetApi(23)
    private static int g(android.media.MediaCodecInfo.CodecCapabilities codecCapabilities) {
        int maxSupportedInstances;
        maxSupportedInstances = codecCapabilities.getMaxSupportedInstances();
        return maxSupportedInstances;
    }

    @android.annotation.TargetApi(21)
    public final android.graphics.Point a(int i, int i2) {
        android.media.MediaCodecInfo.CodecCapabilities codecCapabilities = this.e;
        if (codecCapabilities == null) {
            c("align.caps");
            return null;
        }
        android.media.MediaCodecInfo.VideoCapabilities videoCapabilities = codecCapabilities.getVideoCapabilities();
        if (videoCapabilities == null) {
            c("align.vCaps");
            return null;
        }
        int widthAlignment = videoCapabilities.getWidthAlignment();
        int heightAlignment = videoCapabilities.getHeightAlignment();
        return new android.graphics.Point(com.anythink.expressad.exoplayer.k.af.a(i, widthAlignment) * widthAlignment, com.anythink.expressad.exoplayer.k.af.a(i2, heightAlignment) * heightAlignment);
    }

    @android.annotation.TargetApi(21)
    public final boolean a(int i) {
        android.media.MediaCodecInfo.CodecCapabilities codecCapabilities = this.e;
        if (codecCapabilities == null) {
            c("sampleRate.caps");
            return false;
        }
        android.media.MediaCodecInfo.AudioCapabilities audioCapabilities = codecCapabilities.getAudioCapabilities();
        if (audioCapabilities == null) {
            c("sampleRate.aCaps");
            return false;
        }
        if (audioCapabilities.isSampleRateSupported(i)) {
            return true;
        }
        c("sampleRate.support, ".concat(java.lang.String.valueOf(i)));
        return false;
    }

    @android.annotation.TargetApi(21)
    public final boolean a(int i, int i2, double d) {
        android.media.MediaCodecInfo.CodecCapabilities codecCapabilities = this.e;
        if (codecCapabilities == null) {
            c("sizeAndRate.caps");
            return false;
        }
        android.media.MediaCodecInfo.VideoCapabilities videoCapabilities = codecCapabilities.getVideoCapabilities();
        if (videoCapabilities == null) {
            c("sizeAndRate.vCaps");
            return false;
        }
        if (a(videoCapabilities, i, i2, d)) {
            return true;
        }
        if (i >= i2 || !a(videoCapabilities, i2, i, d)) {
            c("sizeAndRate.support, " + i + "x" + i2 + "x" + d);
            return false;
        }
        java.lang.String str = "sizeAndRate.rotated, " + i + "x" + i2 + "x" + d;
        java.lang.StringBuilder sb = new java.lang.StringBuilder("AssumedSupport [");
        sb.append(str);
        sb.append("] [");
        sb.append(this.c);
        sb.append(", ");
        sb.append(this.d);
        sb.append("] [");
        sb.append(com.anythink.expressad.exoplayer.k.af.e);
        sb.append("]");
        return true;
    }

    public final android.media.MediaCodecInfo.CodecProfileLevel[] a() {
        android.media.MediaCodecInfo.CodecProfileLevel[] codecProfileLevelArr;
        android.media.MediaCodecInfo.CodecCapabilities codecCapabilities = this.e;
        return (codecCapabilities == null || (codecProfileLevelArr = codecCapabilities.profileLevels) == null) ? new android.media.MediaCodecInfo.CodecProfileLevel[0] : codecProfileLevelArr;
    }

    @android.annotation.TargetApi(21)
    public final boolean b(int i) {
        android.media.MediaCodecInfo.CodecCapabilities codecCapabilities = this.e;
        if (codecCapabilities == null) {
            c("channelCount.caps");
            return false;
        }
        android.media.MediaCodecInfo.AudioCapabilities audioCapabilities = codecCapabilities.getAudioCapabilities();
        if (audioCapabilities == null) {
            c("channelCount.aCaps");
            return false;
        }
        java.lang.String str = this.c;
        java.lang.String str2 = this.d;
        int maxInputChannelCount = audioCapabilities.getMaxInputChannelCount();
        if (maxInputChannelCount <= 1 && ((com.anythink.expressad.exoplayer.k.af.a < 26 || maxInputChannelCount <= 0) && !"audio/mpeg".equals(str2) && !"audio/3gpp".equals(str2) && !"audio/amr-wb".equals(str2) && !"audio/mp4a-latm".equals(str2) && !"audio/vorbis".equals(str2) && !"audio/opus".equals(str2) && !"audio/raw".equals(str2) && !"audio/flac".equals(str2) && !"audio/g711-alaw".equals(str2) && !"audio/g711-mlaw".equals(str2) && !"audio/gsm".equals(str2))) {
            int i2 = "audio/ac3".equals(str2) ? 6 : "audio/eac3".equals(str2) ? 16 : 30;
            java.lang.StringBuilder sb = new java.lang.StringBuilder("AssumedMaxChannelAdjustment: ");
            sb.append(str);
            sb.append(", [");
            sb.append(maxInputChannelCount);
            sb.append(" to ");
            sb.append(i2);
            sb.append("]");
            maxInputChannelCount = i2;
        }
        if (maxInputChannelCount >= i) {
            return true;
        }
        c("channelCount.support, ".concat(java.lang.String.valueOf(i)));
        return false;
    }

    public final boolean b(java.lang.String str) {
        java.lang.String c;
        if (str == null || this.d == null || (c = com.anythink.expressad.exoplayer.k.o.c(str)) == null) {
            return true;
        }
        if (!this.d.equals(c)) {
            c("codec.mime " + str + ", " + c);
            return false;
        }
        android.util.Pair<java.lang.Integer, java.lang.Integer> a2 = com.anythink.expressad.exoplayer.f.d.a(str);
        if (a2 == null) {
            return true;
        }
        for (android.media.MediaCodecInfo.CodecProfileLevel codecProfileLevel : a()) {
            if (codecProfileLevel.profile == ((java.lang.Integer) a2.first).intValue() && codecProfileLevel.level >= ((java.lang.Integer) a2.second).intValue()) {
                return true;
            }
        }
        c("codec.profileLevel, " + str + ", " + c);
        return false;
    }
}
