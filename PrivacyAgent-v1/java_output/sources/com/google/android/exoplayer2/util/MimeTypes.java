package com.google.android.exoplayer2.util;

/* loaded from: classes22.dex */
public final class MimeTypes {
    public static final java.lang.String APPLICATION_AIT = "application/vnd.dvb.ait";
    public static final java.lang.String APPLICATION_CAMERA_MOTION = "application/x-camera-motion";
    public static final java.lang.String APPLICATION_CEA608 = "application/cea-608";
    public static final java.lang.String APPLICATION_CEA708 = "application/cea-708";
    public static final java.lang.String APPLICATION_DVBSUBS = "application/dvbsubs";
    public static final java.lang.String APPLICATION_EMSG = "application/x-emsg";
    public static final java.lang.String APPLICATION_EXIF = "application/x-exif";
    public static final java.lang.String APPLICATION_ICY = "application/x-icy";
    public static final java.lang.String APPLICATION_ID3 = "application/id3";
    public static final java.lang.String APPLICATION_M3U8 = "application/x-mpegURL";
    public static final java.lang.String APPLICATION_MATROSKA = "application/x-matroska";
    public static final java.lang.String APPLICATION_MP4 = "application/mp4";
    public static final java.lang.String APPLICATION_MP4CEA608 = "application/x-mp4-cea-608";
    public static final java.lang.String APPLICATION_MP4VTT = "application/x-mp4-vtt";
    public static final java.lang.String APPLICATION_MPD = "application/dash+xml";
    public static final java.lang.String APPLICATION_PGS = "application/pgs";
    public static final java.lang.String APPLICATION_RAWCC = "application/x-rawcc";
    public static final java.lang.String APPLICATION_SCTE35 = "application/x-scte35";
    public static final java.lang.String APPLICATION_SS = "application/vnd.ms-sstr+xml";
    public static final java.lang.String APPLICATION_SUBRIP = "application/x-subrip";
    public static final java.lang.String APPLICATION_TTML = "application/ttml+xml";
    public static final java.lang.String APPLICATION_TX3G = "application/x-quicktime-tx3g";
    public static final java.lang.String APPLICATION_VOBSUB = "application/vobsub";
    public static final java.lang.String APPLICATION_WEBM = "application/webm";
    public static final java.lang.String AUDIO_AAC = "audio/mp4a-latm";
    public static final java.lang.String AUDIO_AC3 = "audio/ac3";
    public static final java.lang.String AUDIO_AC4 = "audio/ac4";
    public static final java.lang.String AUDIO_ALAC = "audio/alac";
    public static final java.lang.String AUDIO_ALAW = "audio/g711-alaw";
    public static final java.lang.String AUDIO_AMR = "audio/amr";
    public static final java.lang.String AUDIO_AMR_NB = "audio/3gpp";
    public static final java.lang.String AUDIO_AMR_WB = "audio/amr-wb";
    public static final java.lang.String AUDIO_DTS = "audio/vnd.dts";
    public static final java.lang.String AUDIO_DTS_EXPRESS = "audio/vnd.dts.hd;profile=lbr";
    public static final java.lang.String AUDIO_DTS_HD = "audio/vnd.dts.hd";
    public static final java.lang.String AUDIO_E_AC3 = "audio/eac3";
    public static final java.lang.String AUDIO_E_AC3_JOC = "audio/eac3-joc";
    public static final java.lang.String AUDIO_FLAC = "audio/flac";
    public static final java.lang.String AUDIO_MATROSKA = "audio/x-matroska";
    public static final java.lang.String AUDIO_MLAW = "audio/g711-mlaw";
    public static final java.lang.String AUDIO_MP4 = "audio/mp4";
    public static final java.lang.String AUDIO_MPEG = "audio/mpeg";
    public static final java.lang.String AUDIO_MPEG_L1 = "audio/mpeg-L1";
    public static final java.lang.String AUDIO_MPEG_L2 = "audio/mpeg-L2";
    public static final java.lang.String AUDIO_MSGSM = "audio/gsm";
    public static final java.lang.String AUDIO_OGG = "audio/ogg";
    public static final java.lang.String AUDIO_OPUS = "audio/opus";
    public static final java.lang.String AUDIO_RAW = "audio/raw";
    public static final java.lang.String AUDIO_TRUEHD = "audio/true-hd";
    public static final java.lang.String AUDIO_UNKNOWN = "audio/x-unknown";
    public static final java.lang.String AUDIO_VORBIS = "audio/vorbis";
    public static final java.lang.String AUDIO_WAV = "audio/wav";
    public static final java.lang.String AUDIO_WEBM = "audio/webm";
    public static final java.lang.String BASE_TYPE_APPLICATION = "application";
    public static final java.lang.String BASE_TYPE_AUDIO = "audio";
    public static final java.lang.String BASE_TYPE_TEXT = "text";
    public static final java.lang.String BASE_TYPE_VIDEO = "video";
    public static final java.lang.String TEXT_SSA = "text/x-ssa";
    public static final java.lang.String TEXT_VTT = "text/vtt";
    public static final java.lang.String VIDEO_AV1 = "video/av01";
    public static final java.lang.String VIDEO_DIVX = "video/divx";
    public static final java.lang.String VIDEO_DOLBY_VISION = "video/dolby-vision";
    public static final java.lang.String VIDEO_FLV = "video/x-flv";
    public static final java.lang.String VIDEO_H263 = "video/3gpp";
    public static final java.lang.String VIDEO_H264 = "video/avc";
    public static final java.lang.String VIDEO_H265 = "video/hevc";
    public static final java.lang.String VIDEO_MATROSKA = "video/x-matroska";
    public static final java.lang.String VIDEO_MP2T = "video/mp2t";
    public static final java.lang.String VIDEO_MP4 = "video/mp4";
    public static final java.lang.String VIDEO_MP4V = "video/mp4v-es";
    public static final java.lang.String VIDEO_MPEG = "video/mpeg";
    public static final java.lang.String VIDEO_MPEG2 = "video/mpeg2";
    public static final java.lang.String VIDEO_OGG = "video/ogg";
    public static final java.lang.String VIDEO_PS = "video/mp2p";
    public static final java.lang.String VIDEO_UNKNOWN = "video/x-unknown";
    public static final java.lang.String VIDEO_VC1 = "video/wvc1";
    public static final java.lang.String VIDEO_VP8 = "video/x-vnd.on2.vp8";
    public static final java.lang.String VIDEO_VP9 = "video/x-vnd.on2.vp9";
    public static final java.lang.String VIDEO_WEBM = "video/webm";
    public static final java.util.ArrayList<com.google.android.exoplayer2.util.MimeTypes.CustomMimeType> a = new java.util.ArrayList<>();
    public static final java.util.regex.Pattern b = java.util.regex.Pattern.compile("^mp4a\\.([a-zA-Z0-9]{2})(?:\\.([0-9]{1,2}))?$");

    public static final class CustomMimeType {
        public final java.lang.String a;
        public final java.lang.String b;
        public final int c;

        public CustomMimeType(java.lang.String str, java.lang.String str2, int i) {
            this.a = str;
            this.b = str2;
            this.c = i;
        }
    }

    @androidx.annotation.VisibleForTesting
    public static final class Mp4aObjectType {
        public final int a;
        public final int b;

        public Mp4aObjectType(int i, int i2) {
            this.a = i;
            this.b = i2;
        }
    }

    @androidx.annotation.Nullable
    public static java.lang.String a(java.lang.String str) {
        int size = a.size();
        for (int i = 0; i < size; i++) {
            com.google.android.exoplayer2.util.MimeTypes.CustomMimeType customMimeType = a.get(i);
            if (str.startsWith(customMimeType.b)) {
                return customMimeType.a;
            }
        }
        return null;
    }

    public static boolean allSamplesAreSyncSamples(@androidx.annotation.Nullable java.lang.String str, @androidx.annotation.Nullable java.lang.String str2) {
        com.google.android.exoplayer2.util.MimeTypes.Mp4aObjectType b2;
        int encodingForAudioObjectType;
        if (str == null) {
            return false;
        }
        switch (str) {
            case "audio/mp4a-latm":
                if (str2 != null && (b2 = b(str2)) != null && (encodingForAudioObjectType = com.google.android.exoplayer2.audio.AacUtil.getEncodingForAudioObjectType(b2.b)) != 0 && encodingForAudioObjectType != 16) {
                }
                break;
        }
        return false;
    }

    @androidx.annotation.Nullable
    @androidx.annotation.VisibleForTesting
    public static com.google.android.exoplayer2.util.MimeTypes.Mp4aObjectType b(java.lang.String str) {
        java.util.regex.Matcher matcher = b.matcher(str);
        if (!matcher.matches()) {
            return null;
        }
        java.lang.String str2 = (java.lang.String) com.google.android.exoplayer2.util.Assertions.checkNotNull(matcher.group(1));
        java.lang.String group = matcher.group(2);
        try {
            return new com.google.android.exoplayer2.util.MimeTypes.Mp4aObjectType(java.lang.Integer.parseInt(str2, 16), group != null ? java.lang.Integer.parseInt(group) : 0);
        } catch (java.lang.NumberFormatException unused) {
            return null;
        }
    }

    @androidx.annotation.Nullable
    public static java.lang.String c(@androidx.annotation.Nullable java.lang.String str) {
        int indexOf;
        if (str == null || (indexOf = str.indexOf(47)) == -1) {
            return null;
        }
        return str.substring(0, indexOf);
    }

    public static int d(java.lang.String str) {
        int size = a.size();
        for (int i = 0; i < size; i++) {
            com.google.android.exoplayer2.util.MimeTypes.CustomMimeType customMimeType = a.get(i);
            if (str.equals(customMimeType.a)) {
                return customMimeType.c;
            }
        }
        return -1;
    }

    @androidx.annotation.Nullable
    public static java.lang.String getAudioMediaMimeType(@androidx.annotation.Nullable java.lang.String str) {
        if (str == null) {
            return null;
        }
        for (java.lang.String str2 : com.google.android.exoplayer2.util.Util.splitCodecs(str)) {
            java.lang.String mediaMimeType = getMediaMimeType(str2);
            if (mediaMimeType != null && isAudio(mediaMimeType)) {
                return mediaMimeType;
            }
        }
        return null;
    }

    public static int getEncoding(java.lang.String str, @androidx.annotation.Nullable java.lang.String str2) {
        com.google.android.exoplayer2.util.MimeTypes.Mp4aObjectType b2;
        str.hashCode();
        switch (str) {
            case "audio/eac3-joc":
                return 18;
            case "audio/vnd.dts":
                return 7;
            case "audio/mp4a-latm":
                if (str2 == null || (b2 = b(str2)) == null) {
                    return 0;
                }
                return com.google.android.exoplayer2.audio.AacUtil.getEncodingForAudioObjectType(b2.b);
            case "audio/ac3":
                return 5;
            case "audio/ac4":
                return 17;
            case "audio/eac3":
                return 6;
            case "audio/mpeg":
                return 9;
            case "audio/vnd.dts.hd":
                return 8;
            case "audio/true-hd":
                return 14;
            default:
                return 0;
        }
    }

    @androidx.annotation.Nullable
    public static java.lang.String getMediaMimeType(@androidx.annotation.Nullable java.lang.String str) {
        com.google.android.exoplayer2.util.MimeTypes.Mp4aObjectType b2;
        java.lang.String str2 = null;
        if (str == null) {
            return null;
        }
        java.lang.String lowerInvariant = com.google.android.exoplayer2.util.Util.toLowerInvariant(str.trim());
        if (lowerInvariant.startsWith("avc1") || lowerInvariant.startsWith("avc3")) {
            return "video/avc";
        }
        if (lowerInvariant.startsWith("hev1") || lowerInvariant.startsWith("hvc1")) {
            return "video/hevc";
        }
        if (lowerInvariant.startsWith("dvav") || lowerInvariant.startsWith("dva1") || lowerInvariant.startsWith("dvhe") || lowerInvariant.startsWith("dvh1")) {
            return VIDEO_DOLBY_VISION;
        }
        if (lowerInvariant.startsWith("av01")) {
            return VIDEO_AV1;
        }
        if (lowerInvariant.startsWith("vp9") || lowerInvariant.startsWith("vp09")) {
            return "video/x-vnd.on2.vp9";
        }
        if (lowerInvariant.startsWith("vp8") || lowerInvariant.startsWith("vp08")) {
            return "video/x-vnd.on2.vp8";
        }
        if (!lowerInvariant.startsWith("mp4a")) {
            return (lowerInvariant.startsWith("ac-3") || lowerInvariant.startsWith("dac3")) ? "audio/ac3" : (lowerInvariant.startsWith("ec-3") || lowerInvariant.startsWith("dec3")) ? "audio/eac3" : lowerInvariant.startsWith("ec+3") ? "audio/eac3-joc" : (lowerInvariant.startsWith("ac-4") || lowerInvariant.startsWith("dac4")) ? AUDIO_AC4 : (lowerInvariant.startsWith("dtsc") || lowerInvariant.startsWith("dtse")) ? "audio/vnd.dts" : (lowerInvariant.startsWith("dtsh") || lowerInvariant.startsWith("dtsl")) ? "audio/vnd.dts.hd" : lowerInvariant.startsWith("opus") ? "audio/opus" : lowerInvariant.startsWith("vorbis") ? "audio/vorbis" : lowerInvariant.startsWith("flac") ? "audio/flac" : lowerInvariant.startsWith("stpp") ? "application/ttml+xml" : lowerInvariant.startsWith("wvtt") ? "text/vtt" : lowerInvariant.contains("cea708") ? "application/cea-708" : (lowerInvariant.contains("eia608") || lowerInvariant.contains("cea608")) ? "application/cea-608" : a(lowerInvariant);
        }
        if (lowerInvariant.startsWith("mp4a.") && (b2 = b(lowerInvariant)) != null) {
            str2 = getMimeTypeFromMp4ObjectType(b2.a);
        }
        return str2 == null ? "audio/mp4a-latm" : str2;
    }

    @androidx.annotation.Nullable
    public static java.lang.String getMimeTypeFromMp4ObjectType(int i) {
        if (i == 32) {
            return "video/mp4v-es";
        }
        if (i == 33) {
            return "video/avc";
        }
        if (i == 35) {
            return "video/hevc";
        }
        if (i == 64) {
            return "audio/mp4a-latm";
        }
        if (i == 163) {
            return "video/wvc1";
        }
        if (i == 177) {
            return "video/x-vnd.on2.vp9";
        }
        if (i == 165) {
            return "audio/ac3";
        }
        if (i == 166) {
            return "audio/eac3";
        }
        switch (i) {
            case 96:
            case 97:
            case 98:
            case 99:
            case 100:
            case 101:
                return "video/mpeg2";
            case 102:
            case 103:
            case 104:
                return "audio/mp4a-latm";
            case 105:
            case 107:
                return "audio/mpeg";
            case 106:
                return "video/mpeg";
            default:
                switch (i) {
                    case 169:
                    case com.google.android.exoplayer2.extractor.ts.TsExtractor.TS_STREAM_TYPE_AC4 /* 172 */:
                        return "audio/vnd.dts";
                    case 170:
                    case 171:
                        return "audio/vnd.dts.hd";
                    case 173:
                        return "audio/opus";
                    case 174:
                        return AUDIO_AC4;
                    default:
                        return null;
                }
        }
    }

    @androidx.annotation.Nullable
    public static java.lang.String getTextMediaMimeType(@androidx.annotation.Nullable java.lang.String str) {
        if (str == null) {
            return null;
        }
        for (java.lang.String str2 : com.google.android.exoplayer2.util.Util.splitCodecs(str)) {
            java.lang.String mediaMimeType = getMediaMimeType(str2);
            if (mediaMimeType != null && isText(mediaMimeType)) {
                return mediaMimeType;
            }
        }
        return null;
    }

    public static int getTrackType(@androidx.annotation.Nullable java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return -1;
        }
        if (isAudio(str)) {
            return 1;
        }
        if (isVideo(str)) {
            return 2;
        }
        if (isText(str)) {
            return 3;
        }
        if ("application/id3".equals(str) || "application/x-emsg".equals(str) || "application/x-scte35".equals(str)) {
            return 4;
        }
        if ("application/x-camera-motion".equals(str)) {
            return 5;
        }
        return d(str);
    }

    public static int getTrackTypeOfCodec(java.lang.String str) {
        return getTrackType(getMediaMimeType(str));
    }

    @androidx.annotation.Nullable
    public static java.lang.String getVideoMediaMimeType(@androidx.annotation.Nullable java.lang.String str) {
        if (str == null) {
            return null;
        }
        for (java.lang.String str2 : com.google.android.exoplayer2.util.Util.splitCodecs(str)) {
            java.lang.String mediaMimeType = getMediaMimeType(str2);
            if (mediaMimeType != null && isVideo(mediaMimeType)) {
                return mediaMimeType;
            }
        }
        return null;
    }

    public static boolean isAudio(@androidx.annotation.Nullable java.lang.String str) {
        return "audio".equals(c(str));
    }

    public static boolean isMatroska(@androidx.annotation.Nullable java.lang.String str) {
        if (str == null) {
            return false;
        }
        return str.startsWith("video/webm") || str.startsWith("audio/webm") || str.startsWith("application/webm") || str.startsWith(VIDEO_MATROSKA) || str.startsWith(AUDIO_MATROSKA) || str.startsWith(APPLICATION_MATROSKA);
    }

    public static boolean isText(@androidx.annotation.Nullable java.lang.String str) {
        return "text".equals(c(str)) || "application/cea-608".equals(str) || "application/cea-708".equals(str) || "application/x-mp4-cea-608".equals(str) || "application/x-subrip".equals(str) || "application/ttml+xml".equals(str) || "application/x-quicktime-tx3g".equals(str) || "application/x-mp4-vtt".equals(str) || "application/x-rawcc".equals(str) || "application/vobsub".equals(str) || "application/pgs".equals(str) || "application/dvbsubs".equals(str);
    }

    public static boolean isVideo(@androidx.annotation.Nullable java.lang.String str) {
        return "video".equals(c(str));
    }

    public static java.lang.String normalizeMimeType(java.lang.String str) {
        str.hashCode();
        switch (str) {
            case "audio/x-flac":
                return "audio/flac";
            case "audio/x-wav":
                return AUDIO_WAV;
            case "audio/mp3":
                return "audio/mpeg";
            default:
                return str;
        }
    }

    public static void registerCustomMimeType(java.lang.String str, java.lang.String str2, int i) {
        com.google.android.exoplayer2.util.MimeTypes.CustomMimeType customMimeType = new com.google.android.exoplayer2.util.MimeTypes.CustomMimeType(str, str2, i);
        int size = a.size();
        int i2 = 0;
        while (true) {
            if (i2 >= size) {
                break;
            }
            java.util.ArrayList<com.google.android.exoplayer2.util.MimeTypes.CustomMimeType> arrayList = a;
            if (str.equals(arrayList.get(i2).a)) {
                arrayList.remove(i2);
                break;
            }
            i2++;
        }
        a.add(customMimeType);
    }
}
