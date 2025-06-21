package com.google.android.exoplayer2.mediacodec;

/* loaded from: classes22.dex */
public class MediaCodecDecoderException extends com.google.android.exoplayer2.decoder.DecoderException {

    @androidx.annotation.Nullable
    public final com.google.android.exoplayer2.mediacodec.MediaCodecInfo codecInfo;

    @androidx.annotation.Nullable
    public final java.lang.String diagnosticInfo;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public MediaCodecDecoderException(java.lang.Throwable th, @androidx.annotation.Nullable com.google.android.exoplayer2.mediacodec.MediaCodecInfo mediaCodecInfo) {
        super(r1.length() != 0 ? "Decoder failed: ".concat(r1) : new java.lang.String("Decoder failed: "), th);
        java.lang.String valueOf = java.lang.String.valueOf(mediaCodecInfo == null ? null : mediaCodecInfo.name);
        this.codecInfo = mediaCodecInfo;
        this.diagnosticInfo = com.google.android.exoplayer2.util.Util.SDK_INT >= 21 ? getDiagnosticInfoV21(th) : null;
    }

    @androidx.annotation.Nullable
    @androidx.annotation.RequiresApi(21)
    private static java.lang.String getDiagnosticInfoV21(java.lang.Throwable th) {
        if (th instanceof android.media.MediaCodec.CodecException) {
            return ((android.media.MediaCodec.CodecException) th).getDiagnosticInfo();
        }
        return null;
    }
}
