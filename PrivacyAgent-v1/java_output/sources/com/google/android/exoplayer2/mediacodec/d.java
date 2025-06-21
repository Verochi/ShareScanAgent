package com.google.android.exoplayer2.mediacodec;

/* loaded from: classes22.dex */
public final /* synthetic */ class d implements com.google.android.exoplayer2.mediacodec.MediaCodecUtil.ScoreProvider {
    public final /* synthetic */ com.google.android.exoplayer2.Format a;

    public /* synthetic */ d(com.google.android.exoplayer2.Format format) {
        this.a = format;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecUtil.ScoreProvider
    public final int a(java.lang.Object obj) {
        int G;
        G = com.google.android.exoplayer2.mediacodec.MediaCodecUtil.G(this.a, (com.google.android.exoplayer2.mediacodec.MediaCodecInfo) obj);
        return G;
    }
}
