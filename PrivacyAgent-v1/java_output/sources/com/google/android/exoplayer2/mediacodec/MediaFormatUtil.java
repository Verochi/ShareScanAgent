package com.google.android.exoplayer2.mediacodec;

/* loaded from: classes22.dex */
public final class MediaFormatUtil {
    public static void maybeSetByteBuffer(android.media.MediaFormat mediaFormat, java.lang.String str, @androidx.annotation.Nullable byte[] bArr) {
        if (bArr != null) {
            mediaFormat.setByteBuffer(str, java.nio.ByteBuffer.wrap(bArr));
        }
    }

    public static void maybeSetColorInfo(android.media.MediaFormat mediaFormat, @androidx.annotation.Nullable com.google.android.exoplayer2.video.ColorInfo colorInfo) {
        if (colorInfo != null) {
            maybeSetInteger(mediaFormat, "color-transfer", colorInfo.colorTransfer);
            maybeSetInteger(mediaFormat, "color-standard", colorInfo.colorSpace);
            maybeSetInteger(mediaFormat, "color-range", colorInfo.colorRange);
            maybeSetByteBuffer(mediaFormat, "hdr-static-info", colorInfo.hdrStaticInfo);
        }
    }

    public static void maybeSetFloat(android.media.MediaFormat mediaFormat, java.lang.String str, float f) {
        if (f != -1.0f) {
            mediaFormat.setFloat(str, f);
        }
    }

    public static void maybeSetInteger(android.media.MediaFormat mediaFormat, java.lang.String str, int i) {
        if (i != -1) {
            mediaFormat.setInteger(str, i);
        }
    }

    public static void setCsdBuffers(android.media.MediaFormat mediaFormat, java.util.List<byte[]> list) {
        for (int i = 0; i < list.size(); i++) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder(15);
            sb.append("csd-");
            sb.append(i);
            mediaFormat.setByteBuffer(sb.toString(), java.nio.ByteBuffer.wrap(list.get(i)));
        }
    }

    public static void setString(android.media.MediaFormat mediaFormat, java.lang.String str, java.lang.String str2) {
        mediaFormat.setString(str, str2);
    }
}
