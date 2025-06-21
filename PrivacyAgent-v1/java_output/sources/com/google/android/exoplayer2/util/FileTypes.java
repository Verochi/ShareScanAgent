package com.google.android.exoplayer2.util;

/* loaded from: classes22.dex */
public final class FileTypes {
    public static final int AC3 = 0;
    public static final int AC4 = 1;
    public static final int ADTS = 2;
    public static final int AMR = 3;
    public static final int FLAC = 4;
    public static final int FLV = 5;
    public static final int MATROSKA = 6;
    public static final int MP3 = 7;
    public static final int MP4 = 8;
    public static final int OGG = 9;
    public static final int PS = 10;
    public static final int TS = 11;
    public static final int UNKNOWN = -1;
    public static final int WAV = 12;
    public static final int WEBVTT = 13;

    @java.lang.annotation.Documented
    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    public @interface Type {
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static int inferFileTypeFromMimeType(@androidx.annotation.Nullable java.lang.String str) {
        char c;
        if (str == null) {
            return -1;
        }
        java.lang.String normalizeMimeType = com.google.android.exoplayer2.util.MimeTypes.normalizeMimeType(str);
        normalizeMimeType.hashCode();
        switch (normalizeMimeType.hashCode()) {
            case -2123537834:
                if (normalizeMimeType.equals("audio/eac3-joc")) {
                    c = 0;
                    break;
                }
                c = 65535;
                break;
            case -1662384011:
                if (normalizeMimeType.equals(com.google.android.exoplayer2.util.MimeTypes.VIDEO_PS)) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            case -1662384007:
                if (normalizeMimeType.equals(com.google.android.exoplayer2.util.MimeTypes.VIDEO_MP2T)) {
                    c = 2;
                    break;
                }
                c = 65535;
                break;
            case -1662095187:
                if (normalizeMimeType.equals("video/webm")) {
                    c = 3;
                    break;
                }
                c = 65535;
                break;
            case -1606874997:
                if (normalizeMimeType.equals("audio/amr-wb")) {
                    c = 4;
                    break;
                }
                c = 65535;
                break;
            case -1248337486:
                if (normalizeMimeType.equals("application/mp4")) {
                    c = 5;
                    break;
                }
                c = 65535;
                break;
            case -1004728940:
                if (normalizeMimeType.equals("text/vtt")) {
                    c = 6;
                    break;
                }
                c = 65535;
                break;
            case -387023398:
                if (normalizeMimeType.equals(com.google.android.exoplayer2.util.MimeTypes.AUDIO_MATROSKA)) {
                    c = 7;
                    break;
                }
                c = 65535;
                break;
            case -43467528:
                if (normalizeMimeType.equals("application/webm")) {
                    c = '\b';
                    break;
                }
                c = 65535;
                break;
            case 13915911:
                if (normalizeMimeType.equals(com.google.android.exoplayer2.util.MimeTypes.VIDEO_FLV)) {
                    c = '\t';
                    break;
                }
                c = 65535;
                break;
            case 187078296:
                if (normalizeMimeType.equals("audio/ac3")) {
                    c = '\n';
                    break;
                }
                c = 65535;
                break;
            case 187078297:
                if (normalizeMimeType.equals(com.google.android.exoplayer2.util.MimeTypes.AUDIO_AC4)) {
                    c = 11;
                    break;
                }
                c = 65535;
                break;
            case 187078669:
                if (normalizeMimeType.equals(com.google.android.exoplayer2.util.MimeTypes.AUDIO_AMR)) {
                    c = '\f';
                    break;
                }
                c = 65535;
                break;
            case 187090232:
                if (normalizeMimeType.equals("audio/mp4")) {
                    c = '\r';
                    break;
                }
                c = 65535;
                break;
            case 187091926:
                if (normalizeMimeType.equals(com.google.android.exoplayer2.util.MimeTypes.AUDIO_OGG)) {
                    c = 14;
                    break;
                }
                c = 65535;
                break;
            case 187099443:
                if (normalizeMimeType.equals(com.google.android.exoplayer2.util.MimeTypes.AUDIO_WAV)) {
                    c = 15;
                    break;
                }
                c = 65535;
                break;
            case 1331848029:
                if (normalizeMimeType.equals("video/mp4")) {
                    c = 16;
                    break;
                }
                c = 65535;
                break;
            case 1503095341:
                if (normalizeMimeType.equals("audio/3gpp")) {
                    c = 17;
                    break;
                }
                c = 65535;
                break;
            case 1504578661:
                if (normalizeMimeType.equals("audio/eac3")) {
                    c = 18;
                    break;
                }
                c = 65535;
                break;
            case 1504619009:
                if (normalizeMimeType.equals("audio/flac")) {
                    c = 19;
                    break;
                }
                c = 65535;
                break;
            case 1504831518:
                if (normalizeMimeType.equals("audio/mpeg")) {
                    c = 20;
                    break;
                }
                c = 65535;
                break;
            case 1505118770:
                if (normalizeMimeType.equals("audio/webm")) {
                    c = 21;
                    break;
                }
                c = 65535;
                break;
            case 2039520277:
                if (normalizeMimeType.equals(com.google.android.exoplayer2.util.MimeTypes.VIDEO_MATROSKA)) {
                    c = 22;
                    break;
                }
                c = 65535;
                break;
            default:
                c = 65535;
                break;
        }
        switch (c) {
        }
        return -1;
    }

    public static int inferFileTypeFromResponseHeaders(java.util.Map<java.lang.String, java.util.List<java.lang.String>> map) {
        java.util.List<java.lang.String> list = map.get("Content-Type");
        return inferFileTypeFromMimeType((list == null || list.isEmpty()) ? null : list.get(0));
    }

    public static int inferFileTypeFromUri(android.net.Uri uri) {
        java.lang.String lastPathSegment = uri.getLastPathSegment();
        if (lastPathSegment == null) {
            return -1;
        }
        if (lastPathSegment.endsWith(".ac3") || lastPathSegment.endsWith(".ec3")) {
            return 0;
        }
        if (lastPathSegment.endsWith(".ac4")) {
            return 1;
        }
        if (lastPathSegment.endsWith(".adts") || lastPathSegment.endsWith(".aac")) {
            return 2;
        }
        if (lastPathSegment.endsWith(".amr")) {
            return 3;
        }
        if (lastPathSegment.endsWith(".flac")) {
            return 4;
        }
        if (lastPathSegment.endsWith(".flv")) {
            return 5;
        }
        if (lastPathSegment.startsWith(".mk", lastPathSegment.length() - 4) || lastPathSegment.endsWith(".webm")) {
            return 6;
        }
        if (lastPathSegment.endsWith(".mp3")) {
            return 7;
        }
        if (lastPathSegment.endsWith(".mp4") || lastPathSegment.startsWith(".m4", lastPathSegment.length() - 4) || lastPathSegment.startsWith(".mp4", lastPathSegment.length() - 5) || lastPathSegment.startsWith(".cmf", lastPathSegment.length() - 5)) {
            return 8;
        }
        if (lastPathSegment.startsWith(".og", lastPathSegment.length() - 4) || lastPathSegment.endsWith(".opus")) {
            return 9;
        }
        if (lastPathSegment.endsWith(".ps") || lastPathSegment.endsWith(".mpeg") || lastPathSegment.endsWith(".mpg") || lastPathSegment.endsWith(".m2p")) {
            return 10;
        }
        if (lastPathSegment.endsWith(".ts") || lastPathSegment.startsWith(".ts", lastPathSegment.length() - 4)) {
            return 11;
        }
        if (lastPathSegment.endsWith(".wav") || lastPathSegment.endsWith(".wave")) {
            return 12;
        }
        return (lastPathSegment.endsWith(".vtt") || lastPathSegment.endsWith(".webvtt")) ? 13 : -1;
    }
}
