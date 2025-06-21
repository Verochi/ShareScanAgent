package com.google.android.exoplayer2.mediacodec;

/* loaded from: classes22.dex */
public final /* synthetic */ class e implements java.util.Comparator {
    public final /* synthetic */ com.google.android.exoplayer2.mediacodec.MediaCodecUtil.ScoreProvider n;

    public /* synthetic */ e(com.google.android.exoplayer2.mediacodec.MediaCodecUtil.ScoreProvider scoreProvider) {
        this.n = scoreProvider;
    }

    @Override // java.util.Comparator
    public final int compare(java.lang.Object obj, java.lang.Object obj2) {
        int H;
        H = com.google.android.exoplayer2.mediacodec.MediaCodecUtil.H(this.n, obj, obj2);
        return H;
    }
}
