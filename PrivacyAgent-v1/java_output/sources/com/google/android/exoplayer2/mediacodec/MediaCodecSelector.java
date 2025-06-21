package com.google.android.exoplayer2.mediacodec;

/* loaded from: classes22.dex */
public interface MediaCodecSelector {
    public static final com.google.android.exoplayer2.mediacodec.MediaCodecSelector DEFAULT = new defpackage.rc1();

    java.util.List<com.google.android.exoplayer2.mediacodec.MediaCodecInfo> getDecoderInfos(java.lang.String str, boolean z, boolean z2) throws com.google.android.exoplayer2.mediacodec.MediaCodecUtil.DecoderQueryException;
}
