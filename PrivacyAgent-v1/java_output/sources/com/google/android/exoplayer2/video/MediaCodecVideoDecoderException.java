package com.google.android.exoplayer2.video;

/* loaded from: classes22.dex */
public class MediaCodecVideoDecoderException extends com.google.android.exoplayer2.mediacodec.MediaCodecDecoderException {
    public final boolean isSurfaceValid;
    public final int surfaceIdentityHashCode;

    public MediaCodecVideoDecoderException(java.lang.Throwable th, @androidx.annotation.Nullable com.google.android.exoplayer2.mediacodec.MediaCodecInfo mediaCodecInfo, @androidx.annotation.Nullable android.view.Surface surface) {
        super(th, mediaCodecInfo);
        this.surfaceIdentityHashCode = java.lang.System.identityHashCode(surface);
        this.isSurfaceValid = surface == null || surface.isValid();
    }
}
