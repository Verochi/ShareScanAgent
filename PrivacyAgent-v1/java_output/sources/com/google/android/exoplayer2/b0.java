package com.google.android.exoplayer2;

/* loaded from: classes22.dex */
public final /* synthetic */ class b0 implements com.google.android.exoplayer2.source.MediaSource.MediaSourceCaller {
    public final /* synthetic */ com.google.android.exoplayer2.MediaSourceList n;

    public /* synthetic */ b0(com.google.android.exoplayer2.MediaSourceList mediaSourceList) {
        this.n = mediaSourceList;
    }

    @Override // com.google.android.exoplayer2.source.MediaSource.MediaSourceCaller
    public final void onSourceInfoRefreshed(com.google.android.exoplayer2.source.MediaSource mediaSource, com.google.android.exoplayer2.Timeline timeline) {
        this.n.t(mediaSource, timeline);
    }
}
