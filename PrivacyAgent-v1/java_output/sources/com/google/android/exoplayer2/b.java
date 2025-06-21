package com.google.android.exoplayer2;

/* loaded from: classes22.dex */
public final /* synthetic */ class b implements com.google.android.exoplayer2.ExoPlayerImplInternal.PlaybackInfoUpdateListener {
    public final /* synthetic */ com.google.android.exoplayer2.ExoPlayerImpl a;

    public /* synthetic */ b(com.google.android.exoplayer2.ExoPlayerImpl exoPlayerImpl) {
        this.a = exoPlayerImpl;
    }

    @Override // com.google.android.exoplayer2.ExoPlayerImplInternal.PlaybackInfoUpdateListener
    public final void onPlaybackInfoUpdate(com.google.android.exoplayer2.ExoPlayerImplInternal.PlaybackInfoUpdate playbackInfoUpdate) {
        this.a.v(playbackInfoUpdate);
    }
}
